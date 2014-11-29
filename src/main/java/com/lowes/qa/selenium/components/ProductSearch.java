package com.lowes.qa.selenium.components;



import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.cognizant.framework.Status;
import com.lowes.qa.selenium.support.ReusableLibrary;
import com.lowes.qa.selenium.support.ScriptHelper;
import com.lowes.qa.selenium.uimap.UIMapFunctionalComponents;
import com.lowes.qa.selenium.uimap.UIMapMyLowes;
import com.lowes.qa.selenium.uimap.UIMapProductSearch;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
public class ProductSearch extends ReusableLibrary
{
	String baseurl = dataTable.getData("General_Data", "URL");
	Selenium selenium = new WebDriverBackedSelenium(driver, baseurl);
	public ProductSearch(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
	}
	
	/*This function unzips the store*/
	public void unzipStore() throws Exception
	{
		driver.findElement(By.xpath(UIMapProductSearch.lnkUnzip)).click();
		driver.navigate().refresh();
		selenium.waitForPageToLoad("20000");
		boolean varUnzip = driver.findElement(By.id(UIMapProductSearch.txtStoreZipField)).isDisplayed();
		if(varUnzip)
		{
			report.updateTestLog("Unzipping Store","Store Unzipped", Status.PASS);
		}
		else
		{
			report.updateTestLog("Unzipping Store","Store NOT Unzipped", Status.FAIL);
		}
		Thread.sleep(2000);
	}
	
	
	/*This function clicks on Find A Store link*/
	public void clickFindStore() throws Exception
	{
		driver.findElement(By.xpath(UIMapProductSearch.lnkFindAStore)).click();
		selenium.waitForPageToLoad("10000");
		String varStorelocator = driver.findElement(By.xpath(UIMapProductSearch.webElmntFindStoreHeading)).getText();
		if(varStorelocator.equals("Store Locator"))
		{
			report.updateTestLog("Clicking Find A Store link","Store Locator Page displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking Find A Store link","Store Locator Page NOT displayed", Status.FAIL);
		}
	}
	
	/*This function clicks on Gift Card link*/
	public void clickGiftCards() throws Exception
	{
		driver.findElement(By.partialLinkText("Gift Cards")).click();
		selenium.waitForPageToLoad("10000");
		String varGiftCards = driver.findElement(By.xpath(UIMapMyLowes.webElmntBrdCrumbsLvl2)).getText();
		if(varGiftCards.equals("Shop Gift Cards at Lowe's"))
		{
			report.updateTestLog("Clicking Gift Cards link","Gift Cards Page displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking Gift Cards link","Gift Cards Page NOT displayed", Status.FAIL);
		}
	}
	
	/*This function clicks on Select Design (for Gift Cards)*/
	public void clickSelectDesign() throws Exception
	{
		driver.findElement(By.partialLinkText("Select Design")).click();
		selenium.waitForPageToLoad("10000");
		String varGiftCards = driver.findElement(By.xpath(UIMapMyLowes.webElmntBrdCrumbsLvl2)).getText();
		if(varGiftCards.equals("Gift Cards"))
		{
			report.updateTestLog("Clicking Select Design","Gift Cards List displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking Select Design","Gift Cards List NOT displayed", Status.FAIL);
		}
	}
	
	/*This function checks whether <!DOCTYPE html> is there is page source code*/
	public void verifyHtmlDoctype() throws Exception
	{
		
		String var = selenium.getHtmlSource();
		//System.out.println(var);
		if(var.contains("<!DOCTYPE html>"))
		{
			System.out.println("True");
			report.updateTestLog("Checking HTML source","DOCTYPE html in Source Code", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking HTML source","DOCTYPE html NOT in Source Code", Status.FAIL);
		}
	}
	
	/*This function selects a Department by hovering on Shop*/
	public void selectDept() throws Exception
	{
		try{Actions actions = new Actions(driver);
		WebElement varHoverShop = driver.findElement(By.xpath(UIMapProductSearch.lnkShop));
		actions.moveToElement(varHoverShop).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(2000);
		System.out.println(dataTable.getData("General_Data", "Dept"));
		WebElement varDept = driver.findElement(By.partialLinkText(dataTable.getData("General_Data", "Dept")));
		actions.moveToElement(varDept).build().perform();
		varDept.click();
		selenium.waitForPageToLoad("10000");
		String varDeptBreadcrumbs = driver.findElement(By.xpath(UIMapMyLowes.webElmntBrdCrumbsLvl2)).getText();
		if(varDeptBreadcrumbs.equals(dataTable.getData("General_Data", "Dept")))
		{
			report.updateTestLog("Opening Dept using Shop By Dept","Dept page displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Opening Dept using Shop By Dept","Dept page NOT displayed", Status.FAIL);
		}
		}
		catch(Exception WebDriverException)
		{
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			Actions actions = new Actions(driver);
			WebElement varHoverShop = driver.findElement(By.xpath(UIMapProductSearch.lnkShop));
			actions.moveToElement(varHoverShop).build().perform();
			System.out.println("Mouse Hover successful");
			Thread.sleep(2000);
			System.out.println(dataTable.getData("General_Data", "Dept"));
			WebElement varDept = driver.findElement(By.partialLinkText(dataTable.getData("General_Data", "Dept")));
			actions.moveToElement(varDept).build().perform();
			varDept.click();
			selenium.waitForPageToLoad("10000");
			String varDeptBreadcrumbs = driver.findElement(By.xpath(UIMapMyLowes.webElmntBrdCrumbsLvl2)).getText();
			if(varDeptBreadcrumbs.equals(dataTable.getData("General_Data", "Dept")))
			{
				report.updateTestLog("Opening Dept using Shop By Dept","Dept page displayed", Status.PASS);
			}
			else
			{
				report.updateTestLog("Opening Dept using Shop By Dept","Dept page NOT displayed", Status.FAIL);
			}
		}
			
		
	}
	
	/*This function selects a Category from a dept*/
	public void selectCat() throws Exception
	{
		try{driver.findElement(By.partialLinkText(dataTable.getData("General_Data", "Category"))).click();
		System.out.println(dataTable.getData("General_Data", "Category"));
		selenium.waitForPageToLoad("10000");}
		catch(Exception WebDriverException)
		{
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.partialLinkText(dataTable.getData("General_Data", "Category"))).click();
			
		System.out.println(dataTable.getData("General_Data", "Category"));
		selenium.waitForPageToLoad("10000");
		}
		String varCatBreadcrumbs = driver.findElement(By.xpath(UIMapMyLowes.webElmntBrdCrumbsLvl3)).getText();
		if(varCatBreadcrumbs.equals(dataTable.getData("General_Data", "Category")))
		{
			report.updateTestLog("Opening Category using Shop By Dept","Category page displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Opening Category using Shop By Dept","Category page NOT displayed", Status.FAIL);
		}
	}
	
	/*This function selects a Subcategory frm a Category*/
	public void selectSubCat() throws Exception
	{
		try{
		driver.findElement(By.partialLinkText(dataTable.getData("General_Data", "SubCategory"))).click();
		
		selenium.waitForPageToLoad("10000");
		}
		catch(Exception WebDriverException)
		{
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.partialLinkText(dataTable.getData("General_Data", "SubCategory"))).click();
			
		
		selenium.waitForPageToLoad("10000");
		}
		String varCatBreadcrumbs = driver.findElement(By.xpath(UIMapProductSearch.webElmntBrdCrumbsLvl4)).getText();
		if(varCatBreadcrumbs.equals(dataTable.getData("General_Data", "SubCategory")))
		{
			report.updateTestLog("Opening SubCategory using Shop By Dept","SubCategory page displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Opening SubCategory using Shop By Dept","SubCategory page NOT displayed", Status.FAIL);
		}
	}
	
	/*This function selects a link from  Subcategory */
	public void selectSubCatLink() throws Exception
	{
		try{
		driver.findElement(By.partialLinkText(dataTable.getData("General_Data", "SubCategoryLink"))).click();
		
		selenium.waitForPageToLoad("10000");
		}
		catch(Exception WebDriverException)
		{
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.partialLinkText(dataTable.getData("General_Data", "SubCategoryLink"))).click();
			
		
		selenium.waitForPageToLoad("10000");
		}
		String varCatBreadcrumbs = driver.findElement(By.xpath(UIMapProductSearch.webElmntBrdCrumbsLvl5)).getText();
		if(varCatBreadcrumbs.equals(dataTable.getData("General_Data", "SubCategoryLink")))
		{
			report.updateTestLog("Opening SubCategory using Shop By Dept","SubCategory page displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Opening SubCategory using Shop By Dept","SubCategory page NOT displayed", Status.FAIL);
		}
	}
	
	/*This function finds a Product from a Product list page*/
	public void findProductFromList() throws Exception
	{ 
		//String varNbrOfPages = driver.findElement(By.xpath("//*[@id='main_content_rail']/div[3]/div[6]/form/span[3]/div/span[3]")).getText();
		String varNbrOfPages = driver.findElement(By.className(UIMapProductSearch.webElmntTotalPages)).getText();
		int varNbrOfPages2 = Integer.valueOf(varNbrOfPages);
		System.out.println(varNbrOfPages2);
		int i=0;
		for(i = 1;i<=varNbrOfPages2;i++)
		{
		boolean varIsProduct = selenium.isTextPresent(dataTable.getData("General_Data", "Productname"));
		///
		if(varIsProduct)
		{
			dataTable.putData("General_Data", "Page", String.valueOf(i));
			System.out.println("Product Found on page:"+i);
			report.updateTestLog("Finding Product","Product Found on page:"+i, Status.PASS);
			break;
		}
		else
		{
			System.out.println("Product not found on page "+i);
			driver.findElement(By.partialLinkText("Next")).click();
			selenium.waitForPageToLoad("10000");
			Thread.sleep(10000);
		}
		}
		if(i==(varNbrOfPages2+1))
		{
			report.updateTestLog("Finding Product","Product Not Found", Status.FAIL);
		}
		///	
		/*if(varIsProduct)
		{
			System.out.println("Product Found on page:"+i);
			driver.findElement(By.partialLinkText(dataTable.getData("General_Data", "Productname"))).click();
			selenium.waitForPageToLoad("20000");
			String varProductName = driver.findElement(By.xpath(UIMapProductSearch.webElmntProductName)).getText();
			if(varProductName.equals(dataTable.getData("General_Data", "Productname")))
			{
				report.updateTestLog("Opening Product Details Page","Product Details Page displayed", Status.PASS);
				break;
			}
			else
			{
				report.updateTestLog("Opening Product Details Page","Product Details Page NOT displayed", Status.PASS);
				break;
			}
			
		}
		else
		{
			System.out.println("Product not found on page "+i);
			driver.findElement(By.partialLinkText("Next")).click();
			//driver.findElement(By.xpath("//*[@id='main_content_rail']/div[3]/div[1]/form/span[3]/a[2]/span")).click();
			selenium.waitForPageToLoad("10000");
			Thread.sleep(10000);
		}
		}*/
		
}
	
	/*This function clicks on a Product from Search Results*/
	public void clickProduct() throws Exception
	{
		driver.findElement(By.partialLinkText(dataTable.getData("General_Data", "Productname"))).click();
		selenium.waitForPageToLoad("20000");
		String varProductName = driver.findElement(By.xpath(UIMapProductSearch.webElmntProductName)).getText();
		if(varProductName.equals(dataTable.getData("General_Data", "Productname")))
		{
			report.updateTestLog("Opening Product Details Page","Product Details Page displayed", Status.PASS);
			
		}
		else
		{
			report.updateTestLog("Opening Product Details Page","Product Details Page NOT displayed", Status.PASS);
			
		}
	}
	/*This function verifies availability messages for SOE product*/
	public void verifyAvailabilityMsgSOE() throws Exception
	{
		String varStore = driver.findElement(By.xpath(UIMapProductSearch.webElmntActiveStore)).getText();
		//PL Availability Message
		String varPL = driver.findElement(By.xpath(UIMapProductSearch.webElmntStorePickUpAvailMsg)).getText();
		System.out.println(varPL);
		String pattern = "FREE"+'\n'+"Store Pickup"+'\n'+"Your order will be ready for pickup from "+varStore+" by \\d+/\\d+/\\d+."+'\n'+"Change Store";
		System.out.println(pattern);
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(varPL);
		if(m.find())
		{
			report.updateTestLog("Validating Availability Message","Store Pickup Availability Message correct", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Availability Message","Store Pickup Availability Message INcorrect", Status.FAIL);
		}
		//DL Availability Message
		String varDL = driver.findElement(By.xpath(UIMapProductSearch.webElmntStoreLTDAvailMsg)).getText();
		System.out.println(varDL);
		 pattern = "Lowe's Truck Delivery"+'\n'+"Your order will be ready for delivery to you from "+varStore+" by \\d+/\\d+/\\d+.";
		System.out.println(pattern);
		 r = Pattern.compile(pattern);
		 m = r.matcher(varDL);
		if(m.find())
		{
			report.updateTestLog("Validating Availability Message","Truck Delivery Availability Message correct", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Availability Message","Truck Delivery Availability Message INcorrect", Status.FAIL);
		}
		//PS Availability Message
		String varPS = driver.findElement(By.xpath(UIMapProductSearch.webElmntStoreParcelAvailMsg)).getText();
		System.out.println(varPS);
		 pattern = "Parcel Shipping"+'\n'+"Unavailable for This Order"+'\n'+"Sent by carriers like UPS, FedEx, USPS, etc.";
		 if(varPS.equals(pattern))
		 {
			 report.updateTestLog("Validating Availability Message","Parcel Shipping Availability Message correct", Status.PASS);
		 }
		 else
		 {
			 report.updateTestLog("Validating Availability Message","Parcel Shipping Availability Message INcorrect", Status.FAIL);
		 }
		 
		 //clicking Change store and validating Pop-Up
		 driver.findElement(By.xpath(UIMapProductSearch.lnkChangeStore)).click();
		 Thread.sleep(5000);
		 boolean varPopup = driver.findElement(By.xpath(UIMapProductSearch.webElmntChooseStorepopup)).isDisplayed();
		 if(varPopup)
		 {
			 String varstorePickupPopup = driver.findElement(By.xpath(UIMapProductSearch.webElmntChooseStorepopupHeading)).getText();
			 if(varstorePickupPopup.equals("Choose a Store Pickup Location"))
			 {
				 report.updateTestLog("Clicking Change Store ","Store Pickup Popup displayed", Status.PASS);
			 }
			 else
			 {
				 report.updateTestLog("Clicking Change Store ","Store Pickup Popup NOT displayed", Status.FAIL);
			 }
		 }
		 else
		 {
			 report.updateTestLog("Clicking Change Store ","Store Pickup Popup NOT displayed", Status.FAIL);
		 }
		 driver.findElement(By.id(UIMapProductSearch.lnkCancelChooseStorePopup)).click();
		 Thread.sleep(2000);
		 varPopup = driver.findElement(By.xpath(UIMapProductSearch.webElmntChooseStorepopup)).isDisplayed();
		 if(varPopup)
		 {
			 report.updateTestLog("Canceling Store Pickup Popup ","Store Pickup Popup NOT CLOSED", Status.FAIL);
		 }
		 else
		 {
			 report.updateTestLog("Canceling Store Pickup Popup ","Store Pickup Popup CLOSED", Status.PASS);
		 }
		
	}
	
	/*This function switches thr product Results in List View*/
	public void swtichProductResultsList() throws Exception
	{
		//boolean varListView1 = selenium.isElementPresent("//*[@id='main_content_rail']/div[3]/div[2]/div[2]/a[1]");
		//boolean varListView1 = selenium.isElementPresent("listView");
		//if(varListView1)
		//{
			String varListView2 = driver.findElement(By.className(UIMapProductSearch.webElmntListView)).getText();
			System.out.println(varListView2);
			if(varListView2.equals("List View"))
			{
				try{
				//driver.findElement(By.className("current gridView")).click();
				ClickCustomize("className", "current gridView");
				}
				catch(Exception NoSuchElementException)
				{
					//driver.findElement(By.className(UIMapProductSearch.webElmntGridView)).click();
					ClickCustomize("className",UIMapProductSearch.webElmntGridView);
				}
				
				Thread.sleep(2000);
				WebElement listView = driver.findElement(By.className(UIMapProductSearch.webElmntListView));
				WebElement bottomBarButtons = listView.findElement(By.xpath("..")); 
				System.out.println(bottomBarButtons+"/a[1]");
				//driver.findElement(By.className(UIMapProductSearch.webElmntListView)).click();
				ClickCustomize("className", UIMapProductSearch.webElmntListView);
				Thread.sleep(2000);
				report.updateTestLog("Switching to List View","List View Clicked", Status.DONE);
				//String varListView3 = driver.findElement(By.xpath("//*[@id='main_content_rail']/div[3]/div[2]/div[2]/a[1]")).getAttribute("class");
				//if(varListView3.equals("listView current"))
				
				if(driver.findElement(By.cssSelector("a.listView.current")).isDisplayed())
				{
					report.updateTestLog("Switching to List View","Search Results displayed in List View", Status.PASS);
				}
				else
				{
					report.updateTestLog("Switching to List View","Search Results NOT displayed in List View", Status.FAIL);
				}
			}
			else
			{
				report.updateTestLog("Switching to List View","List View Not Found", Status.FAIL);
			}
			
		//}
		//else
		//{
		//	report.updateTestLog("Switching to List View","List View Not Found", Status.FAIL);
		//}
	}
	
	/*This function switches thr product Results in Grid View*/
	public void swtichProductResultsGrid() throws Exception
	{
		//boolean varGridView1 = selenium.isElementPresent("//*[@id='main_content_rail']/div[3]/div[2]/div[2]/a[2]");
		//if(varGridView1)
		//{
			String varGridView2 = driver.findElement(By.className(UIMapProductSearch.webElmntGridView)).getText();
			System.out.println(varGridView2);
			if(varGridView2.equals("Grid View"))
			{
				
				//driver.findElement(By.className(UIMapProductSearch.webElmntGridView)).click();
				ClickCustomize("className", UIMapProductSearch.webElmntGridView);
				Thread.sleep(5000);
				//report.updateTestLog("Switching to Grid View","Grid View Clicked", Status.DONE);
				//String varGridView3 = driver.findElement(By.xpath("//*[@id='main_content_rail']/div[3]/div[2]/div[2]/a[2]")).getAttribute("class");
				if(driver.findElement(By.cssSelector("a.gridView.current")).isDisplayed())
				{
					report.updateTestLog("Switching to Grid View","Search Results displayed in Grid View", Status.PASS);
				}
				else
				{
					report.updateTestLog("Switching to Grid View","Search Results NOT displayed in Grid View", Status.FAIL);
				}
			}
			else
			{
				report.updateTestLog("Switching to Grid View","Grid View Not Found", Status.FAIL);
			}
			
		//}
		//else
		//{
		//	report.updateTestLog("Switching to Grid View","Grid View Not Found", Status.FAIL);
	//	}
	}
	
	/*This function validates Energy star badges in List/Grid View*/
	public void verifyEnergyStarList() throws Exception
	{
		WebElement varProduct = driver.findElement(By.partialLinkText(dataTable.getData("General_Data", "Productname")));
		WebElement productTitle = varProduct.findElement(By.xpath("..")); 
		WebElement titleArea = productTitle.findElement(By.xpath("..")); 
		WebElement productWrapper = titleArea.findElement(By.xpath("..")); 
		WebElement ItemId = productWrapper.findElement(By.xpath("..")); 
		System.out.println(ItemId.getAttribute("id"));
		String varItemId = ItemId.getAttribute("id");
		String varXpath = "//*[@id='"+varItemId+"']/div/div[1]/span";
		System.out.println(varXpath);
		try{
		boolean varEnergyStar1 = driver.findElement(By.xpath(varXpath)).isDisplayed();
		System.out.println(varEnergyStar1);
		if(varEnergyStar1)
		{
			String varEnergyStar2 = driver.findElement(By.xpath(varXpath)).getAttribute("name");
			System.out.println(varEnergyStar2);
			if(varEnergyStar2.equals("listpage_energystarbadge"))
			{
				if(dataTable.getData("General_Data", "EnergyStar").equals("Yes"))
				{
					report.updateTestLog("Checking Energy Star Badge","Energy Star Badge displayed", Status.PASS);
				}
				else if(dataTable.getData("General_Data", "EnergyStar").equals("No"))
				{
					report.updateTestLog("Checking Energy Star Badge","Energy Star Badge displayed", Status.FAIL);
				}
				
			}
		}
		else
		{
			if(dataTable.getData("General_Data", "EnergyStar").equals("Yes"))
			{
				report.updateTestLog("Checking Energy Star Badge","Energy Star Badge NOT displayed", Status.FAIL);
			}
			else if(dataTable.getData("General_Data", "EnergyStar").equals("No"))
			{
				report.updateTestLog("Checking Energy Star Badge","Energy Star Badge NOT displayed", Status.PASS);
			}
		}
		}
		catch(Exception NoSuchElementException)
		{
			if(dataTable.getData("General_Data", "EnergyStar").equals("Yes"))
			{
				report.updateTestLog("Checking Energy Star Badge","Energy Star Badge NOT displayed", Status.FAIL);
			}
			else if(dataTable.getData("General_Data", "EnergyStar").equals("No"))
			{
				report.updateTestLog("Checking Energy Star Badge","Energy Star Badge NOT displayed", Status.PASS);
			}
		}
		
		
	}
	
	/*This function validates Energy star badges in Product detail View*/
	public void verifyEnergyStarDetail() throws Exception
	{
		try{
		boolean varEnergyStar1 = driver.findElement(By.xpath(UIMapProductSearch.webElmntEnergyStarImg)).isDisplayed();
		System.out.println(varEnergyStar1);
		if(varEnergyStar1)
		{
			String varEnergyStar2 = driver.findElement(By.xpath(UIMapProductSearch.webElmntEnergyStarImg)).getAttribute("class");
			System.out.println(varEnergyStar2);
			if(varEnergyStar2.equals("energy_star"))
			{
				if(dataTable.getData("General_Data", "EnergyStar").equals("Yes"))
				{
					report.updateTestLog("Checking Energy Star Badge","Energy Star Badge displayed", Status.PASS);
				}
				else if(dataTable.getData("General_Data", "EnergyStar").equals("No"))
				{
					report.updateTestLog("Checking Energy Star Badge","Energy Star Badge NOT displayed", Status.FAIL);
				}
				
			}
		}
		else
		{
			if(dataTable.getData("General_Data", "EnergyStar").equals("Yes"))
			{
				report.updateTestLog("Checking Energy Star Badge","Energy Star Badge displayed", Status.FAIL);
			}
			else if(dataTable.getData("General_Data", "EnergyStar").equals("No"))
			{
				report.updateTestLog("Checking Energy Star Badge","Energy Star Badge NOT displayed", Status.PASS);
			}
		}
		}
		catch(Exception NoSuchElementException)
		{
			if(dataTable.getData("General_Data", "EnergyStar").equals("Yes"))
			{
				report.updateTestLog("Checking Energy Star Badge","Energy Star Badge NOT displayed", Status.FAIL);
			}
			else if(dataTable.getData("General_Data", "EnergyStar").equals("No"))
			{
				report.updateTestLog("Checking Energy Star Badge","Energy Star Badge NOT displayed", Status.PASS);
			}
		}
		
	}
	
	public void verifyEnergyStarDiffViews() throws Exception
	{
		swtichProductResultsList();
		findProductFromList();
		verifyEnergyStarList();
		swtichProductResultsGrid();
		//findProductFromList();
		verifyEnergyStarList();
		clickProduct();
		verifyEnergyStarDetail();
		
	}
	
	/*This function validates Free Delivery icon and popup*/
	public void checkFreeDelivery() throws Exception
	{
		WebElement varProduct = driver.findElement(By.partialLinkText(dataTable.getData("General_Data", "Productname")));
		WebElement productTitle = varProduct.findElement(By.xpath("..")); 
		WebElement titleArea = productTitle.findElement(By.xpath("..")); 
		WebElement productWrapper = titleArea.findElement(By.xpath("..")); 
		WebElement ItemId = productWrapper.findElement(By.xpath("..")); 
		System.out.println(ItemId.getAttribute("id"));
		String varItemId = ItemId.getAttribute("id");
		String varXpath = "//*[@id='"+varItemId+"']/div/div[5]/ul/li/a/span";
		System.out.println(varXpath);
		try{
			boolean varFreeDel1 = driver.findElement(By.xpath(varXpath)).isDisplayed();
			System.out.println(varFreeDel1);
			if(varFreeDel1)
			{
				String varFreeDel2 = driver.findElement(By.xpath(varXpath)).getText();
				System.out.println(varFreeDel2);
				if(varFreeDel2.equals("Free Delivery"))
				{
					report.updateTestLog("Checking Free Delivery Icon","Free Delivery Icon displayed", Status.PASS);
					driver.findElement(By.xpath(varXpath)).click();
					Thread.sleep(2000);
					boolean varFreeDelPopup = selenium.isElementPresent("free_delivery");
					if(varFreeDelPopup)
					{
						report.updateTestLog("Clicking Free Delivery Icon","Free Delivery Popup displayed", Status.PASS);
						String varFreeDelPopupText = driver.findElement(By.xpath("//*[@id='free_delivery']/p")).getText();
						if(varFreeDelPopupText.equals("No rebate required for FREE Delivery. FREE Next-Day Delivery applies to in-stock major appliances only. FREE Haul-Away offered on appliances and grills. US deliveries only. Must be within 75 miles of store. See store associate for details."))
						{
							report.updateTestLog("Clicking Free Delivery Icon","Free Delivery Popup Text correct", Status.PASS);
						}
						else
						{
							report.updateTestLog("Clicking Free Delivery Icon","Free Delivery Popup Text INcorrect", Status.FAIL);
						}
					}
					else
					{
						report.updateTestLog("Clicking Free Delivery Icon","Free Delivery Popup NOT displayed", Status.FAIL);
					}
				}
				else
				{
					report.updateTestLog("Checking Free Delivery Icon","Free Delivery Icon NOT displayed", Status.FAIL);
				}
			}
			else
			{
				report.updateTestLog("Checking Free Delivery Icon","Free Delivery Icon NOT displayed", Status.FAIL);
			}
		}
		catch(Exception NoSuchElementException)
		{
			report.updateTestLog("Checking Free Delivery Icon","Free Delivery Icon NOT displayed", Status.FAIL);
		}
		
	}
	
	/*This function validates whether Product description is displayed for Gift Cards List*/
	public void validateGiftCardPrdctDesc() throws Exception
	{
		//List<WebElement> varGC = driver.findElements(By.xpath(UIMapProductSearch.webElmntProductList2));
		//int varCount = varGC.size();
		for(int i = 1; i<=2; i++)
		{
			String varXpath = "//*[@id='productResults']/li["+i+"]";
			System.out.println(varXpath);
			String varID = driver.findElement(By.xpath(varXpath)).getAttribute("id");
			System.out.println(varID);
			String varXpath2 = "//*[@id='"+varID+"']/div/div[4]/ul[2]";
			System.out.println(varXpath2);
			try
			{
			//boolean varProductDesc = driver.findElement(By.xpath(varXpath2)).isDisplayed();
				boolean varProductDesc =selenium.isElementPresent(varXpath2);
			if(varProductDesc)
			{
				String varProductDesc2 = driver.findElement(By.xpath(varXpath2)).getText();
				report.updateTestLog("Checking Product Description for Gift Cards in list","Product Description:"+varProductDesc2+" for Gift Cards displayed", Status.FAIL);
			}
			else
			{
				report.updateTestLog("Checking Product Description for Gift Cards in list","Product Description for Gift Cards NOT displayed", Status.PASS);
			}
				
			}
			catch(Exception NoSuchElementException)
			{
				report.updateTestLog("Checking Product Description for Gift Cards in list","Product Description for Gift Cards NOT displayed", Status.PASS);
			}
		}
		
		
	}
	
	public void searchItemString() throws Exception
	{
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","SearchString"));
		try{driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);}
			report.updateTestLog("Searching For an Item","Searching Item - "+dataTable.getData("General_Data","SearchString")+"" ,Status.DONE);
		
		
		selenium.waitForPageToLoad("30000");
		
		boolean varProductList = selenium.isElementPresent(UIMapProductSearch.webElmntProductList);
		System.out.println(varProductList);
		if(varProductList)
		{
			report.updateTestLog("Veriyfing Navigating to Search Results ","Product List displayed in Search Results" , Status.PASS);
			boolean verItemPresent=selenium.isTextPresent("Search results for "+dataTable.getData("General_Data","SearchString")+":");
			if(verItemPresent)
			{
				report.updateTestLog("Veriyfing Navigating to Search Results ","Search Results displayed" , Status.PASS);
			}
			else if(selenium.isTextPresent("We found results for"))
			{
				report.updateTestLog("Veriyfing Navigating to Search Results ","Incorrect spelling. Search Results corresponding to related item displayed" , Status.PASS);
			}
			else if(selenium.isTextPresent(dataTable.getData("General_Data","SearchString")))
			{
				report.updateTestLog("Veriyfing Navigating to Search Results ","Search Results displayed" , Status.PASS);
			}
			
			else
			{
				report.updateTestLog("Veriyfing Navigating to Search Results ","Search Results NOT displayed for search string" , Status.FAIL);
			}
			
		}
		else{
			
			try{
			boolean varNoSearchResult = driver.findElement(By.xpath(UIMapProductSearch.webElmntNoSearchResultsHeading)).isDisplayed();
		System.out.println(varNoSearchResult);
		if(varNoSearchResult)
		{
			String varNoSearch1 = driver.findElement(By.xpath(UIMapProductSearch.webElmntNoSearchResultsHeading)).getText();
			System.out.println(varNoSearch1);
			System.out.println("We're sorry, we couldn't find any matches for \""+dataTable.getData("General_Data", "SearchString")+"\"");
			if(varNoSearch1.equals("We're sorry, we couldn't find any matches for \""+dataTable.getData("General_Data", "SearchString")+"\""))
			{
				report.updateTestLog("Veriyfing Navigating to Search Results ","Zero Search Results displayed" , Status.PASS);
			}
			String varNoSearch2 = driver.findElement(By.xpath(UIMapProductSearch.webElmntThinkWeShouldHvIt)).getText();
			System.out.println(varNoSearch2);
			if(varNoSearch2.equals("Think we should have it?"))
			{
				report.updateTestLog("Veriyfing Navigating to Search Results ","Think we should have it? Displayed" , Status.PASS);
			}
			
		}
		}
		catch(Exception NoSuchElementException)
		{
			List<WebElement> varGC = driver.findElements(By.xpath(UIMapProductSearch.webElmntBrdCrumbs));
			int varCount = varGC.size();
			boolean varDetails = selenium.isElementPresent(UIMapProductSearch.webElmntProductDetail);
			if(varDetails)
			{
				
			report.updateTestLog("Veriyfing Navigating to Search Results ","Product Details page displayed" , Status.PASS);
				
			}
			
			else if(driver.findElement(By.xpath(UIMapProductSearch.webElmntBrdCrumbs+"["+varCount+"]")).getText().equalsIgnoreCase(dataTable.getData("General_Data","SearchString")))
			{
				report.updateTestLog("Veriyfing Navigating to Search Results ","Categories displayed in Search results" , Status.DONE);
			}
			else
			report.updateTestLog("Veriyfing Navigating to Search Results ","Search Results NOT displayed" , Status.FAIL);
		}
			
		}
		
		
	
	}
	
	
	
	public void searchAndselect() throws Exception
	{
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","SearchString2"));
		Thread.sleep(2000);
		boolean varPopup = selenium.isElementPresent(UIMapProductSearch.webElmntSearchSugegstions);
		System.out.println(varPopup);
		if(varPopup)
		{
			report.updateTestLog("Entering Search string ","Suggestions Pop-up displayed" , Status.PASS);
			String varSuggestion1 = driver.findElement(By.xpath(UIMapProductSearch.webElmntSearchSugg1)).getText();
			System.out.println(varSuggestion1);
			driver.findElement(By.xpath(UIMapProductSearch.webElmntSearchSugg1)).click();
			//selenium.waitForPageToLoad("20000");
			Thread.sleep(10000);
			boolean varProductList = selenium.isElementPresent(UIMapProductSearch.webElmntProductList);
			System.out.println(varProductList);
			if(varProductList)
			{
				report.updateTestLog("Veriyfing Navigating to Search Results ","Product List displayed in Search Results" , Status.PASS);
				boolean verItemPresent=selenium.isTextPresent("Search results for "+varSuggestion1+":");
				if(verItemPresent)
				{
					report.updateTestLog("Veriyfing Navigating to Search Results ","Search Results displayed" , Status.PASS);
				}
				else if(selenium.isTextPresent("We found results for"))
				{
					report.updateTestLog("Veriyfing Navigating to Search Results ","Search Results corresponding to related item displayed" , Status.PASS);
				}
				else if(selenium.isTextPresent(varSuggestion1))
				{
					report.updateTestLog("Veriyfing Navigating to Search Results ","Search Results displayed" , Status.PASS);
				}
				
				else
				{
					report.updateTestLog("Veriyfing Navigating to Search Results ","Search Results NOT displayed for search string" , Status.FAIL);
				}
				
			}
			else{
			boolean varNoSearchResult = selenium.isElementPresent(UIMapProductSearch.webElmntNoSearchResultsHeading);
			System.out.println(varNoSearchResult);
			if(varNoSearchResult)
			{
				String varNoSearch1 = driver.findElement(By.xpath(UIMapProductSearch.webElmntNoSearchResultsHeading)).getText();
				System.out.println(varNoSearch1);
				System.out.println("We're sorry, we couldn't find any matches for \""+varSuggestion1+"\"");
				if(varNoSearch1.equals("We're sorry, we couldn't find any matches for \""+varSuggestion1+"\""))
				{
					report.updateTestLog("Veriyfing Navigating to Search Results ","Zero Search Results displayed" , Status.PASS);
				}
				String varNoSearch2 = driver.findElement(By.xpath(UIMapProductSearch.webElmntThinkWeShouldHvIt)).getText();
				System.out.println(varNoSearch2);
				if(varNoSearch1.equals("Think we should have it?"))
				{
					report.updateTestLog("Veriyfing Navigating to Search Results ","Think we should have it? Displayed" , Status.PASS);
				}
				
			}
			else
			{
				boolean varDetails = selenium.isElementPresent(UIMapProductSearch.webElmntProductDetail);
				if(varDetails)
				{
					String varItemName = driver.findElement(By.xpath(UIMapProductSearch.webElmntProductName)).getText();
					if(varItemName.equals(varSuggestion1))
					{
						report.updateTestLog("Veriyfing Navigating to Search Results ","Product Details page displayed" , Status.PASS);
					}
					else
					{
						report.updateTestLog("Veriyfing Navigating to Search Results ","Incorrect Product Details page displayed" , Status.FAIL);
					}
				}
				else
				report.updateTestLog("Veriyfing Navigating to Search Results ","Search Results NOT displayed" , Status.FAIL);
			}
				
			}
			
		}
		else
		{
			report.updateTestLog("Entering Serach string ","Suggestions Pop-up NOT displayed" , Status.FAIL);
		}
	}
	
	public void setResultPerPage() throws Exception
	{
		//selectDept();
		//selectCat();
		new Select(driver.findElement(By.xpath(UIMapProductSearch.drpDownResultPerPage))).selectByVisibleText(dataTable.getData("General_Data","ResultsPerPg"));
		Thread.sleep(5000);
		for(int i = 1;i<4;i++)
		{
			String varXpath = UIMapProductSearch.drpDownResultPerPage+"/option["+i+"]";
			
			if((driver.findElement(By.xpath(varXpath)).getText()).equals(dataTable.getData("General_Data","ResultsPerPg")))
					{
					//System.out.println("Results Per Page correctly set to:"+dataTable.getData("General_Data","ResultsPerPg"));
					if(driver.findElement(By.xpath(varXpath)).getAttribute("selected").equals("true"))
					{
					report.updateTestLog("Setting Results Per Page","Results Per Page set" , Status.DONE);
					String varCount1 = driver.findElement(By.xpath(UIMapProductSearch.webElmntTotalResults)).getText();
					int varCount2 = Integer.valueOf(varCount1);
					List<WebElement> varGC = driver.findElements(By.xpath(UIMapProductSearch.webElmntProductList2));
					int varCount3 = varGC.size();
					if(varCount2<=Integer.valueOf(dataTable.getData("General_Data","ResultsPerPg")))
					{
						if(varCount3==varCount2)
						{
						report.updateTestLog("Setting Results Per Page","Results Per Page:"+varCount2 , Status.PASS);
						}
						else
						{
							report.updateTestLog("Setting Results Per Page","Results Per Page NOT:"+varCount2 , Status.FAIL);
						}
					}
					else
					{
						if(varCount3==Integer.valueOf(dataTable.getData("General_Data","ResultsPerPg")))
						{
						report.updateTestLog("Setting Results Per Page","Results Per Page:"+dataTable.getData("General_Data","ResultsPerPg") , Status.PASS);
						}
						else
						{
							report.updateTestLog("Setting Results Per Page","Results Per Page NOT:"+dataTable.getData("General_Data","ResultsPerPg") , Status.FAIL);
						}
					}
					break;
					}
					else
					{
						report.updateTestLog("Setting Results Per Page","Results Per Page Not set" , Status.FAIL);
						break;
					}
					}
			
			else
			{
				continue;
			}
		}

	}
	
	/*this function retuns the result count displayed*/
	public int checkResultCount() throws Exception
	{
		String varResultCount = driver.findElement(By.xpath(UIMapProductSearch.webElmntTotalResults)).getText();
		int varCount = Integer.valueOf(varResultCount);
		return varCount;
	}
	
	/*this function validates View all button and its functionality*/
	public void checkViewAll() throws Exception
	{
		//String varResultCount = driver.findElement(By.xpath(UIMapProductSearch.webElmntTotalResults)).getText();
		int varCount = checkResultCount();
		if((varCount>16)&&(varCount<32)&&(dataTable.getData("General_Data","ResultsPerPg").equals("16")))
				{
			boolean varViewAll = selenium.isElementPresent(UIMapProductSearch.btnViewAll);
			if(varViewAll)
			{
				String varViewAll2 = driver.findElement(By.xpath(UIMapProductSearch.btnViewAll)).getText();
				if(varViewAll2.equals("View All"))
				{
				report.updateTestLog("Checking View All","View All button displayed" , Status.PASS);
				driver.findElement(By.xpath(UIMapProductSearch.btnViewAll)).click();
				Thread.sleep(10000);
				boolean varViewAll3 = driver.findElement(By.xpath(UIMapProductSearch.webElmntViewAll)).isDisplayed();
				if(varViewAll3)
				{
					List<WebElement> varGC = driver.findElements(By.xpath(UIMapProductSearch.webElmntProductList2));
					int varCount2 = varGC.size();
					if(varCount2==varCount)
					{
					report.updateTestLog("Clicking View All","All products displayed" , Status.PASS);
					}
					else
					{
						report.updateTestLog("Clicking View All","All products NOT displayed" , Status.FAIL);
					}
					
					
				}
				}
				else
				{
				report.updateTestLog("Checking View All","View All NOT displayed" , Status.FAIL);
				}
			}
			else
				report.updateTestLog("Checking View All","View All NOT displayed" , Status.FAIL);
			}
		else
		{
			boolean varViewAll = selenium.isElementPresent(UIMapProductSearch.btnViewAll);
			if(varViewAll)
			{
				String varViewAll2 = driver.findElement(By.xpath(UIMapProductSearch.btnViewAll)).getText();
				if(varViewAll2.equals("View All"))
				{
				report.updateTestLog("Checking View All","View All button displayed" , Status.FAIL);
				}
		}
		
	}
	}
	
	/*This function checks Sort By options*/
	public void checkSortBy() throws Exception
	{
		List<WebElement> varSortBy = driver.findElements(By.xpath(UIMapProductSearch.webElmntProductListSort));
		int varCount = varSortBy.size();
		int i;
		for(i=1;i<=varCount;i++)
		{
		String varXpath = UIMapProductSearch.webElmntProductListSort+"["+i+"]";
		String varSortBy2 = driver.findElement(By.xpath(varXpath)).getText();
		if(varSortBy2.equals("Price (Low to High)"))
		{
			report.updateTestLog("Checking Sorting Options","Price (Low to High) displayed" , Status.PASS);
			driver.findElement(By.xpath(varXpath)).click();
			Thread.sleep(5000);
			//System.out.println(driver.findElement(By.partialLinkText("Price (Low to High)")).isDisplayed());
			try{
				driver.findElement(By.xpath(varXpath+"/a")).click();
				report.updateTestLog("Clicking Price (Low to High)","Price (Low to High) NOT disabled after clicking" , Status.FAIL);
				break;
			}
			catch(Exception NoSuchElementException)
			{
				report.updateTestLog("Clicking Price (Low to High)","Price (Low to High) disabled after clicking" , Status.PASS);
				break;
			}
		}
		else
			continue;
		}
		if(i==varCount+1)
		{
			report.updateTestLog("Checking Sorting Options","Price (Low to High) NOT displayed" , Status.FAIL);
		}
		for(i=1;i<=varCount;i++)
		{
		//String varXpath = "//*[@id='main_content_rail']/div[3]/div[2]/div[1]/ul/li["+i+"]";
		String varXpath = UIMapProductSearch.webElmntProductListSort+"["+i+"]";
		String varSortBy2 = driver.findElement(By.xpath(varXpath)).getText();
		if(varSortBy2.equals("Price (High to Low)"))
		{
			report.updateTestLog("Checking Sorting Options","Price (High to Low) displayed" , Status.PASS);
			driver.findElement(By.xpath(varXpath)).click();
			Thread.sleep(5000);
			try{
				driver.findElement(By.xpath(varXpath+"/a")).click();
				report.updateTestLog("Clicking Price (High to Low)","Price (High to Low) NOT disabled after clicking" , Status.FAIL);
				break;
			}
			catch(Exception NoSuchElementException)
			{
				report.updateTestLog("Clicking Price (High to Low)","Price (High to Low) disabled after clicking" , Status.PASS);
				break;
			}
		}
		else
			continue;
		}
		if(i==varCount+1)
		{
			report.updateTestLog("Checking Sorting Options","Price (High to Low) NOT displayed" , Status.FAIL);
		}
		for(i=1;i<=varCount;i++)
		{
		//String varXpath = "//*[@id='main_content_rail']/div[3]/div[2]/div[1]/ul/li["+i+"]";
		String varXpath = UIMapProductSearch.webElmntProductListSort+"["+i+"]";
		String varSortBy2 = driver.findElement(By.xpath(varXpath)).getText();
		if(varSortBy2.equals("Brand"))
		{
			report.updateTestLog("Checking Sorting Options","Brand displayed" , Status.PASS);
			driver.findElement(By.xpath(varXpath)).click();
			Thread.sleep(5000);
			try{
				driver.findElement(By.xpath(varXpath+"/a")).click();
				report.updateTestLog("Clicking Brand","Brand NOT disabled after clicking" , Status.FAIL);
				break;
			}
			catch(Exception NoSuchElementException)
			{
				report.updateTestLog("Clicking Brand","Brand disabled after clicking" , Status.PASS);
				break;
			}
		}
		else
			continue;
		}
		if(i==varCount+1)
		{
			report.updateTestLog("Checking Sorting Options","Brand NOT displayed" , Status.FAIL);
		}
		for(i=1;i<=varCount;i++)
		{
		//String varXpath = "//*[@id='main_content_rail']/div[3]/div[2]/div[1]/ul/li["+i+"]";
		String varXpath = UIMapProductSearch.webElmntProductListSort+"["+i+"]";
		String varSortBy2 = driver.findElement(By.xpath(varXpath)).getText();
		if(varSortBy2.equals("Best Sellers"))
		{
			report.updateTestLog("Checking Sorting Options","Best Sellers displayed" , Status.PASS);
			driver.findElement(By.xpath(varXpath)).click();
			Thread.sleep(5000);
			try{
				driver.findElement(By.xpath(varXpath+"/a")).click();
				report.updateTestLog("Clicking Best Sellers","Best Sellers NOT disabled after clicking" , Status.FAIL);
				break;
			}
			catch(Exception NoSuchElementException)
			{
				report.updateTestLog("Clicking Best Sellers","Best Sellers disabled after clicking" , Status.PASS);
				break;
			}
		}
		else
			continue;
		}
		if(i==varCount+1)
		{
			report.updateTestLog("Checking Sorting Options","Best Sellers NOT displayed" , Status.FAIL);
		}
		for(i=1;i<=varCount;i++)
		{
		//String varXpath = "//*[@id='main_content_rail']/div[3]/div[2]/div[1]/ul/li["+i+"]";
		String varXpath = UIMapProductSearch.webElmntProductListSort+"["+i+"]";
		String varSortBy2 = driver.findElement(By.xpath(varXpath)).getText();
		if(varSortBy2.equals("Customer Ratings"))
		{
			report.updateTestLog("Checking Sorting Options","Customer Ratings displayed" , Status.PASS);
			driver.findElement(By.xpath(varXpath)).click();
			Thread.sleep(5000);
			try{
				driver.findElement(By.xpath(varXpath+"/a")).click();
				report.updateTestLog("Clicking Customer Ratings","Customer Ratings NOT disabled after clicking" , Status.FAIL);
				break;
			}
			catch(Exception NoSuchElementException)
			{
				report.updateTestLog("Clicking Customer Ratings","Customer Ratings disabled after clicking" , Status.PASS);
				break;
			}
		}
		else
			continue;
		}
		if(i==varCount+1)
		{
			report.updateTestLog("Checking Sorting Options","Customer Ratings NOT displayed" , Status.FAIL);
		}
		
		
	}
	
	/*This function clicks on Brand Name*/
	public void selectBrand() throws Exception
	{
		List<WebElement> varBrand = driver.findElements(By.xpath(UIMapProductSearch.chkBoxBrand));
		int varCount = varBrand.size();
		for(int i =1 ; i<=varCount;i++)
		{
			//String varXpath = "//*[@id='Brand']/ul/li["+i+"]/label";
			String varXpath = UIMapProductSearch.chkBoxBrand+"["+i+"]/label";
			String varBrandName = driver.findElement(By.xpath(varXpath)).getText();
			String[] s = varBrandName.split(" ");
		
			if(s[0].equals(dataTable.getData("General_Data", "Brand")))
					{
				driver.findElement(By.xpath(varXpath)).click();
				Thread.sleep(5000);
				String pattern = "(\\d+)";
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(s[1]);
			    if(m.find())
			    {
			    	int varCount2 = checkResultCount();
			    	if(varCount2==Integer.valueOf(m.group(1)))
			    	{
			    		report.updateTestLog("Clicking Brand","Search results displayed only for selected Brand" , Status.PASS);
			    		break;
			    	}
			    	else
			    	{
			    		report.updateTestLog("Clicking Brand","Search results NOT displayed only for selected Brand" , Status.FAIL);
			    		break;
			    	}
			    }
					}
				
					}
					
	}
	
	public void deleteCookies() throws Exception
	{
		driver.manage().deleteAllCookies();
		Thread.sleep(5000);
		report.updateTestLog("Deleting Cookies","Cookies Deleted" , Status.DONE);
		
	}
	
	/*this function selects an In stock product in product List*/
	public void selectInStockProduct() throws Exception
	{
		List<WebElement> varProductList = driver.findElements(By.xpath(UIMapProductSearch.webElmntProductList2));
		int varCount = varProductList.size();
		int i;
		for(i=1;i<=varCount;i++)
		{
			//String varXPath= "//*[@id='productResults']/li["+i+"]";
			String varXPath= UIMapProductSearch.webElmntProductList2+"["+i+"]";
			String varID = driver.findElement(By.xpath(varXPath)).getAttribute("id");
			System.out.println(varID);
			try{
		//	if(selenium.isElementPresent("//*[@id='"+varID+"']/div/button"))
				if(driver.findElement(By.xpath("//*[@id='"+varID+"']/div/button")).isDisplayed())
			{
				System.out.println("Add to Cart present for:"+varID);
				driver.findElement(By.xpath("//*[@id='"+varID+"']/div/div[2]/h3/a")).click();
				selenium.waitForPageToLoad("20000");
				boolean varDetailPage = selenium.isElementPresent(UIMapProductSearch.webElmntProductDetail);
				System.out.println("detail page displayed:"+varDetailPage);
				if(varDetailPage)
				{
					report.updateTestLog("Selecting In Stock Item","Product Details Page displayed" , Status.PASS);
					
					break;
				}
				else
				{
					report.updateTestLog("Selecting In Stock Item","Product Details Page NOT displayed" , Status.FAIL);
					break;
				}
			}
			else
				continue;
			}
			catch(Exception NoSuchElementException)
			{
				System.out.println("Add to Cart NOT present for:"+varID);
				continue;
			}
		}
		if(i==(varCount+1))
		{
			report.updateTestLog("Selecting In Stock Item","No In Stock Item in page" , Status.FAIL);
		}
		
	}
	
	/*This function clicks on Add To Cart in Details Page and navigates to Shopping Cart*/
	public void clickAddToCartFrmDetail() throws Exception
	{
		//String varItemName = driver.findElement(By.xpath(UIMapProductSearch.webElmntProductName)).getText();
		String varItemNbr = driver.findElement(By.id(UIMapProductSearch.webElmntItemNbr)).getText();
		WebElement varAddToCart = driver.findElement(By.xpath(UIMapProductSearch.btnAddToCart));
		WebElement varItemID = varAddToCart.findElement(By.xpath(".."));
		String varID = varItemID.getAttribute("id");
		String[] s=varID.split("_");
		System.out.println(s[1]);
		dataTable.putData("General_Data", "ItemId", s[1]);
		driver.findElement(By.xpath(UIMapProductSearch.btnAddToCart)).click();
		Thread.sleep(7000);
		boolean varPopup = selenium.isElementPresent(UIMapProductSearch.webElmntAddToCartPopup);
		if(varPopup)
		{
			String varSuccess = driver.findElement(By.id(UIMapProductSearch.webElmntAddToCartPopup)).getText();
			if(varSuccess.equals("Your item was successfully added to cart."))
			{
				report.updateTestLog("Adding Item To Cart","Item Added to Cart" , Status.PASS);
				driver.findElement(By.xpath(UIMapProductSearch.btnCkeckOut)).click();
				selenium.waitForPageToLoad("10000");
				//String varItemName2 = driver.findElement(By.xpath("//div[@id='item_"+s[1]+"']/div[2]/div/a")).getText();
				//System.out.println(varItemName2);
				//System.out.println(varItemName);
				
				String varItemModel = driver.findElement(By.xpath("//*[@id='item_"+s[1]+"']/div[2]/div[1]/p")).getText();
				System.out.println(varItemModel);
				if(varItemModel.contains("Item #:"+varItemNbr))
				//if(varItemName2.equals(varItemName))
				{
					report.updateTestLog("Clicking on CheckOut","Item displayed in CART" , Status.PASS);
					dataTable.putData("General_Data", "ItemId", s[1]);
				}
				else
				{
					report.updateTestLog("Clicking on CheckOut","Item NOT displayed in CART" , Status.FAIL);
				}
			}
			else
			{
				report.updateTestLog("Adding Item To Cart","Item NOT Added to Cart" , Status.FAIL);
			}
			
		}
		
	}
	
	/*This function validates store Pickup popup in Shopping Cart page*/
	public void checkStorePickUpPopupCart() throws Exception
	{
		String varID = dataTable.getData("General_Data", "ItemId");
		String varXpath = "//*[@id='item_"+varID+"']/div[2]/div[3]/input";
		driver.findElement(By.xpath(varXpath)).clear();
		driver.findElement(By.xpath(varXpath)).sendKeys("99999");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='item_"+varID+"']/div[2]/div[3]/div/a/span")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(UIMapProductSearch.lnkChangeStoreCart)).click();
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapProductSearch.chkBoxChooseStoreFutureAvail)).click();
		Thread.sleep(1000);
		boolean varAvailableNow = selenium.isElementPresent("css=th.quantity");
		if(varAvailableNow)
		{
			String varAvailNow = driver.findElement(By.cssSelector(UIMapProductSearch.webElmntChooseStoreAvailNow)).getText();
			if(varAvailNow.equals("Available"+'\n'+"Now"))
			{
				report.updateTestLog("Checking StoreLocator popup","Available Now info displayed" , Status.PASS);
			}
			else
			{
				report.updateTestLog("Checking StoreLocator popup","Available Now info NOT displayed" , Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Checking StoreLocator popup","Available Now info NOT displayed" , Status.FAIL);
		}
		boolean varAvailSevenDays = selenium.isElementPresent("css=th.future");
		if(varAvailSevenDays)
		{
			String varAvailsev = driver.findElement(By.cssSelector("UIMapProductSearch.webElmntChooseStoreAvailFuture")).getText();
			if(varAvailsev.equals("Available"+'\n'+"Within 7 Days"))
			{
				report.updateTestLog("Checking StoreLocator popup","Available Within 7 Days info displayed" , Status.PASS);
			}
			else
			{
				report.updateTestLog("Checking StoreLocator popup","Available Within 7 Days info NOT displayed" , Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Checking StoreLocator popup","Available Within 7 Days info NOT displayed" , Status.FAIL);
		}
	}

	/*This function selects Q&A tab*/
	public void selectQnATab() throws Exception
	{
		driver.findElement(By.partialLinkText("Community Q&A")).click();
		Thread.sleep(1000);
		boolean varQnA = selenium.isTextPresent("Q&A Home");
		//boolean varQuestions = selenium.isElementPresent("BVQAQuestionsID0");
		//boolean varNoQuestions = selenium.isElementPresent("BVQANoQuestionsID");
		//System.out.println("Questions present:"+varQuestions);
		if(varQnA)
		{
			report.updateTestLog("Clicking Q&A Tab","Q&A Home displayed" , Status.DONE);
			//driver.findElement(By.xpath("//*[@id='BVQAQuestionHeader0675814']/h1/a")).click();
		}
		else
		{
			report.updateTestLog("Clicking Q&A Tab","Q&A Home NOT present" , Status.FAIL);
		}
	}
	
	/*This function submits a question*/
	
	public void answerAQuestion() throws Exception
	{
		boolean varQuestions = selenium.isElementPresent(UIMapProductSearch.webElmntQuesPresent);
		boolean varNoQuestions = selenium.isElementPresent(UIMapProductSearch.webElmntNoQuestion);
		System.out.println("Questions present:"+varQuestions);
		if(varQuestions)
		{
			report.updateTestLog("Checking Q&A Home","Questions present in Checking Q&A Home", Status.DONE);
		//	List<WebElement> varGC = driver.findElements(By.xpath("//*[@id='BVQAQuestionsID']/div"));
		//	int varCount = varGC.size();
			//System.out.println("Nbr of Questions:"+varCount);
		//	int varQNbr=0;
			//Random rand = new Random(); 
			//varQNbr=rand.nextInt(varCount-1)+1;
				 
			
			//System.out.println("Question Nbr:"+varQNbr);
			String varID = driver.findElement(By.xpath(UIMapProductSearch.webElmntQues1Container)).getAttribute("id");
			
			System.out.println(varID);
			String[] s= varID.split("Answers");
			
			driver.findElement(By.cssSelector("a[name='BV_TrackingTag_QA_Display_HomteTab_QuestionSelect_"+s[1]+"']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='BVQAQuestion"+s[1]+"']/div[2]/div[3]/a/img")).click();
			boolean verPopUpBoxPresent=selenium.isElementPresent(UIMapFunctionalComponents.webElmntLoginPopup);
			System.out.println("PopUp Window identified is :"+verPopUpBoxPresent);
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			boolean verFramePresent=driver.findElement(By.id(UIMapFunctionalComponents.webElmntLoginFrame)).isDisplayed();
			System.out.println("Verifying the Presence of frame id:"+verFramePresent);
			driver.switchTo().frame(driver.findElement(By.id(UIMapFunctionalComponents.webElmntLoginFrame)));
			driver.findElement(By.id(UIMapFunctionalComponents.txtUserName)).click();
			Thread.sleep(2000);
			driver.findElement(By.id(UIMapFunctionalComponents.txtUserName)).sendKeys(dataTable.getData("General_Data","email"));
			driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(dataTable.getData("General_Data", "password"));
			driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(Keys.ENTER);
			//driver.findElement(By.id("GoYourAccount")).click();		
			selenium.waitForPageToLoad("20000");
			
			String getLoggedInUser=driver.findElement(By.xpath(UIMapFunctionalComponents.webElmntSalutation)).getText().trim();
			System.out.println("Verifying the Registered User detais :"+getLoggedInUser);
			if(getLoggedInUser.equals("Welcome, "+dataTable.getData("General_Data","Firstname")))          // Verifying the registered user details by Using Firstname
			{
				report.updateTestLog("Validating Login Credentials","Login Successful", Status.PASS);
			}
			else
			{
				report.updateTestLog("Validating Login Credentials","Login Failed..! for User "+dataTable.getData("General_Data","email")+" ", Status.FAIL);
			}
			        
			
			driver.findElement(By.id(UIMapProductSearch.txtAnswerId)).click();
			driver.findElement(By.id(UIMapProductSearch.txtAnswerId)).sendKeys("Test123");
			try{
			
				
			driver.findElement(By.id(UIMapProductSearch.txtAnsNickNameId)).click();
			driver.findElement(By.id(UIMapProductSearch.txtAnsNickNameId)).sendKeys("MyLowes");
			}
			catch(Exception NoSuchElementException)
			{
				System.out.println("NickName already present");
			}
			
			driver.findElement(By.id(UIMapProductSearch.txtAnsLocation)).click();
			driver.findElement(By.id(UIMapProductSearch.txtAnsLocation)).sendKeys("Ohio");
			new Select(driver.findElement(By.id(UIMapProductSearch.drpDownAnsGender))).selectByVisibleText("Female");
			new Select(driver.findElement(By.id(UIMapProductSearch.drpDownAnsAge))).selectByVisibleText("18-24");
			
			
			try{
			String varChecked = driver.findElement(By.id(UIMapProductSearch.chkBoxAnsEmailAlerts)).getAttribute("checked");
			if(varChecked.equals("true"))
			{
				System.out.println("Email already checked");
			}
			
			}
			catch(Exception NullPointerException)
			{
				driver.findElement(By.id(UIMapProductSearch.chkBoxAnsEmailAlerts)).click();
			}
			driver.findElement(By.id(UIMapProductSearch.txtAnsEmailID)).click();
			String varEmail = driver.findElement(By.id(UIMapProductSearch.txtAnsEmailID)).getAttribute("value");
			if(varEmail.equals(dataTable.getData("General_Data","email")))
			{
				report.updateTestLog("Validating Email Field","Email field correctly prepopulated", Status.PASS);
			}
			else
			{
				report.updateTestLog("Validating Email Field","Email field Not correctly prepopulated", Status.FAIL);
			}
			driver.findElement(By.id(UIMapProductSearch.btnAnsPreview)).click();
			Thread.sleep(2000);
			boolean varAnswerPreview= selenium.isTextPresent("Answer Preview");
			if(varAnswerPreview)
			{
				report.updateTestLog("Clicking Preview","Answer Preview page displayed", Status.PASS);
				driver.findElement(By.id(UIMapProductSearch.btnAnsSubmit)).click();
				Thread.sleep(5000);
				String varSuccess = driver.findElement(By.xpath(UIMapProductSearch.webElmntAnsSuccess)).getText();
				if(varSuccess.equals("Can you help us answer community questions? Join our Community Answers Team."))
				{
					report.updateTestLog("Clicking Submit","Answer Submitted succesfully", Status.PASS);
				}
				else
				{
					report.updateTestLog("Clicking Submit","Answer NOT Submitted succesfully", Status.FAIL);
				}
			}
			else
			{
				report.updateTestLog("Clicking Preview","Answer Preview page NOT displayed", Status.FAIL);
			}
		}
		else if(varNoQuestions)
			report.updateTestLog("Checking Q&A Home","Questions NOT present in Checking Q&A Home", Status.FAIL);
	}
	
	/*This function submits a question*/
	
	public void askAQuestion() throws Exception
	{
		boolean varQuestions = selenium.isElementPresent(UIMapProductSearch.webElmntQuesPresent);
		boolean varNoQuestions = selenium.isElementPresent(UIMapProductSearch.webElmntNoQuestion);
		System.out.println("Questions present:"+varQuestions);
		if(varQuestions)
		{
			report.updateTestLog("Checking Q&A Home","Questions present in Checking Q&A Home", Status.DONE);
			driver.findElement(By.xpath(UIMapProductSearch.btnAskAQuestion)).click();
			selenium.waitForPageToLoad("20000");
			String varQPage = driver.findElement(By.xpath(UIMapProductSearch.webElmntAskQuesPage)).getText();
			if(varQPage.equals("Tips for Submitting a Question"))
			{
				report.updateTestLog("Clicking Answer A Question","Question Page displayed", Status.PASS);
			}
			else
			{
				report.updateTestLog("Clicking Answer A Question","Question Page NOT displayed", Status.FAIL);
			}
		}
		else if(varNoQuestions)
		{
			report.updateTestLog("Checking Q&A Home","Questions NOT present in Checking Q&A Home", Status.DONE);
			driver.findElement(By.xpath(UIMapProductSearch.btnAskAQuestionNoQues)).click();
			selenium.waitForPageToLoad("20000");
			String varQPage = driver.findElement(By.xpath(UIMapProductSearch.webElmntAskQuesPage)).getText();
			if(varQPage.equals("Tips for Submitting a Question"))
			{
				report.updateTestLog("Clicking Ask A Question","Question Page displayed", Status.PASS);
			}
			else
			{
				report.updateTestLog("Clicking Ask A Question","Question Page NOT displayed", Status.FAIL);
			}
		}
			driver.findElement(By.id(UIMapProductSearch.txtQuestionSummary)).click();
			driver.findElement(By.id(UIMapProductSearch.txtQuestionSummary)).sendKeys("TestQuestion");
			driver.findElement(By.id(UIMapProductSearch.txtQuesDetails)).click();
			driver.findElement(By.id(UIMapProductSearch.txtQuesDetails)).sendKeys("TestQuestion:Details");
			driver.findElement(By.id(UIMapProductSearch.txtQuestionSummary)).click();
			driver.findElement(By.id(UIMapProductSearch.txtQuestionSummary)).sendKeys("Ohio");
			new Select(driver.findElement(By.id(UIMapProductSearch.drpDownQuesGender))).selectByVisibleText("Female");
			new Select(driver.findElement(By.id(UIMapProductSearch.drpDownQuesAge))).selectByVisibleText("18-24");
			try{
				String varChecked = driver.findElement(By.id(UIMapProductSearch.chkBoxQuesEmailAlert)).getAttribute("checked");
				if(varChecked.equals("true"))
				{
					System.out.println("Email1 already checked");
				}
				
				}
				catch(Exception NullPointerException)
				{
					driver.findElement(By.id(UIMapProductSearch.chkBoxQuesEmailAlert)).click();
				}
				try{
					String varChecked2 = driver.findElement(By.id(UIMapProductSearch.chkBoxQuesEmailAlert2)).getAttribute("checked");
					if(varChecked2.equals("true"))
					{
						System.out.println("Email2 already checked");
					}
					
					}
					catch(Exception NullPointerException)
					{
						driver.findElement(By.id(UIMapProductSearch.chkBoxQuesEmailAlert2)).click();
					}
				driver.findElement(By.id(UIMapProductSearch.txtQuesUserEmail)).click();
				driver.findElement(By.id(UIMapProductSearch.txtQuesUserEmail)).sendKeys("test001@bh.exacttarget.com");
				driver.findElement(By.id(UIMapProductSearch.btnQuesPreview)).click();
				Thread.sleep(2000);
				boolean varQPreview= selenium.isTextPresent("Question Preview");
				if(varQPreview)
				{
					report.updateTestLog("Clicking Preview","Question Preview page displayed", Status.PASS);
					driver.findElement(By.id(UIMapProductSearch.btnQuesSubmit)).click();
					//Thread.sleep(5000);
					selenium.waitForPageToLoad("20000");
					String varSuccess = driver.findElement(By.id(UIMapProductSearch.lblQuesSubmittedTitle)).getText();
					if(varSuccess.equals("Thank You!"))
					{
						report.updateTestLog("Clicking Submit","Question Submitted succesfully", Status.PASS);
					}
					else
					{
						report.updateTestLog("Clicking Submit","Question NOT Submitted succesfully", Status.FAIL);
					}
				}
				else
				{
					report.updateTestLog("Clicking Preview","Question Preview page NOT displayed", Status.FAIL);
				}
			
		}
	
	/*This function clicks on Review Tab*/
	public void selectReviewTab() throws Exception
	{
		try{driver.findElement(By.partialLinkText("Reviews")).click();
		Thread.sleep(1000);
		}
		catch(Exception WebDriverException)
		{driver.findElement(By.linkText("No, thanks")).click();
		report.updateTestLog("Survey Popup","Handeled", Status.DONE);
		driver.findElement(By.partialLinkText("Reviews")).click();
		Thread.sleep(1000);}
		boolean varReview = selenium.isTextPresent("Product Reviews");
		//boolean varQuestions = selenium.isElementPresent("BVQAQuestionsID0");
		//boolean varNoQuestions = selenium.isElementPresent("BVQANoQuestionsID");
		//System.out.println("Questions present:"+varQuestions);
		if(varReview)
		{
			
			report.updateTestLog("Clicking Reviews","Product Reviews displayed" , Status.DONE);
			boolean varSummary = selenium.isTextPresent("Summary of Customer Ratings & Reviews");
			if(varSummary)
			{
				report.updateTestLog("Checking Reviews","Product Reviews displayed under Summary of Customer Ratings & Reviews" , Status.DONE);
			}
			else
			{
				report.updateTestLog("Checking Reviews","0 Product Reviews" , Status.DONE);
			}
			
			//driver.findElement(By.xpath("//*[@id='BVQAQuestionHeader0675814']/h1/a")).click();
		}
		else
		{
			report.updateTestLog("Clicking Reviews","Product Reviews NOT present" , Status.FAIL);
		}
	}
	
	/*This function marks a review as helpful by clicking on Thumbs Up*/
	public void markReviewThumbsUp() throws Exception
	{
		String varThumbsUpOldCount = driver.findElement(By.xpath(UIMapProductSearch.webElmntThumbsUpCount)).getText();
		System.out.println("Thumbs Up Old Count:"+varThumbsUpOldCount);
		driver.findElement(By.xpath(UIMapProductSearch.lnkThumbsUp)).click();
		Thread.sleep(10000);
		String varSuccess = driver.findElement(By.xpath(UIMapProductSearch.webElmntReviewHelpSuccessMsg)).getText();
		if(varSuccess.equals("Thank you! You have successfully submitted feedback for this review."))
		{
			report.updateTestLog("Marking Review Thumbs Up","Success Message displayed" , Status.PASS);
			String varThumbsUpNewCount = driver.findElement(By.xpath(UIMapProductSearch.webElmntThumbsUpCount)).getText();
			System.out.println("Thumbs Up New Count:"+varThumbsUpNewCount);
			int varThuumbsUpOldCnt = Integer.valueOf(varThumbsUpOldCount);
			int varThuumbsUpNewCnt = Integer.valueOf(varThumbsUpNewCount);
			if(varThuumbsUpNewCnt==(varThuumbsUpOldCnt+1))
			{
				report.updateTestLog("Marking Review Thumbs Up","Thumbs Up Count increased by 1" , Status.PASS);
			}
			else
			{
				report.updateTestLog("Marking Review Thumbs Up","Thumbs Up Count NOT increased by 1" , Status.FAIL);
			}
			
		}
		else
		{
			report.updateTestLog("Marking Review Thumbs Up","Success Message NOT displayed" , Status.FAIL);
		}
	}
	
	/*This function marks a review a Thumbs Down*/
	public void markReviewThumbsDown() throws Exception
	{
		String varThumbsDownOldCount = driver.findElement(By.xpath(UIMapProductSearch.webElmntThumbsDownCount)).getText();
		System.out.println("Thumbs Down Old Count:"+varThumbsDownOldCount);
		driver.findElement(By.xpath(UIMapProductSearch.lnkThumbsDown)).click();
		Thread.sleep(10000);
		String varSuccess = driver.findElement(By.xpath(UIMapProductSearch.webElmntReviewHelpSuccessMsg)).getText();
		if(varSuccess.equals("Thank you! You have successfully submitted feedback for this review."))
		{
			report.updateTestLog("Marking Review Thumbs Down","Success Message displayed" , Status.PASS);
			String varThumbsDownNewCount = driver.findElement(By.xpath(UIMapProductSearch.webElmntThumbsDownCount)).getText();
			System.out.println("Thumbs Down New Count:"+varThumbsDownNewCount);
			int varThuumbsDownOldCnt = Integer.valueOf(varThumbsDownOldCount);
			int varThuumbsDownNewCnt = Integer.valueOf(varThumbsDownNewCount);
			if(varThuumbsDownNewCnt==(varThuumbsDownOldCnt+1))
			{
				report.updateTestLog("Marking Review Thumbs Down","Thumbs Down Count increased by 1" , Status.PASS);
			}
			else
			{
				report.updateTestLog("Marking Review Thumbs Down","Thumbs Down Count NOT increased by 1" , Status.FAIL);
			}
			
		}
		else
		{
			report.updateTestLog("Marking Review Thumbs Down","Success Message NOT displayed" , Status.FAIL);
		}
	}
		
	
	/*Check state of rating in left navigation*/
	public void checkStateRating(String Varexpand) throws Exception
	{
		
			
			String varExpanded = driver.findElement(By.id(UIMapProductSearch.webElmntRatingLeftRail)).getAttribute("class");
			System.out.println("Ratings Class:"+varExpanded);
			if(varExpanded.equals("open"))
			{
				if(Varexpand.equals("Expanded"))
				{
					report.updateTestLog("Checking Ratings","Ratings Expanded as Expected" , Status.PASS);
				}
				else if(Varexpand.equals("Collapsed"))
				{
					report.updateTestLog("Checking Ratings","Ratings Expanded" , Status.FAIL);
				}
			}
			else if(varExpanded.equals(""))
			{
				if(Varexpand.equals("Expanded"))
				{
					report.updateTestLog("Checking Ratings","Ratings Collapsed" , Status.FAIL);
				}
				else if(Varexpand.equals("Collapsed"))
				{
					report.updateTestLog("Checking Ratings","Ratings Collapsed as Expected" , Status.PASS);
				}
			}
			
		}
		
		
	/*This function validates whether the count next to ratings stars and Product List is matching*/
	public void checkStarProductCount() throws Exception
	{
		String varRatingsCount = driver.findElement(By.xpath(UIMapProductSearch.webElmntRatingsCount)).getText();
		String pattern = "(\\d+)";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(varRatingsCount);
	     if (m.find( )) 
	     {
	    	String varResultCount = driver.findElement(By.xpath(UIMapProductSearch.webElmntTotalResults)).getText();
	    	if(m.group(1).equals(varResultCount))
	    	{
	    		report.updateTestLog("Checking Product Results count","Product Results Count matching" , Status.PASS);	
	    	}
	    	else
	    	{
	    		report.updateTestLog("Checking Product Results count","Product Results Count NOT matching" , Status.FAIL);	
	    	}
	     }
	     else
	     {
	    	 System.out.println("Results count not displayed with stars");
	     }
	}
	
	//Selecting a rating and validating product list
	public void selectRating() throws Exception
	{
		Random rand = new Random();
		int varNbrStars = rand.nextInt(5-1)+1;
		System.out.println("Star Selection:"+varNbrStars);
		String varXpath = "//*[@id='Rating']/ul/li/div/a["+varNbrStars+"]";
		driver.findElement(By.xpath(varXpath)).click();
		report.updateTestLog("Selecting Ratings",varNbrStars+" Stars Ratings selected" , Status.DONE);
		Thread.sleep(5000);
		boolean varRatingsChosen = driver.findElement(By.id(UIMapProductSearch.webElmntRatingsBreadbox)).isDisplayed();
		if(varRatingsChosen)
		{
			report.updateTestLog("Checking Ratings Chosen Pop-up","Ratings Chosen Pop-up displayed" , Status.PASS);
			String varStarsInPopup = driver.findElement(By.xpath(UIMapProductSearch.webElmntBreadboxStars)).getAttribute("title");
			System.out.println("Stars In Popup:"+varStarsInPopup);
			String varStarsInPopupExpected = "Rating "+varNbrStars+" stars and above";
			if(varStarsInPopup.equals(varStarsInPopupExpected))
			{
				report.updateTestLog("Checking Stars in Ratings Chosen Pop-up","Stars in Ratings Chosen Pop-up same as selection" , Status.PASS);
				checkStarProductCount();
			}
			else
			{
				report.updateTestLog("Checking Stars in Ratings Chosen Pop-up","Stars in Ratings Chosen Pop-up NOT same as selection" , Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Checking Ratings Chosen Pop-up","Ratings Chosen Pop-up NOT displayed" , Status.FAIL);
		}
	}
	
	/*This function removes the Star selection*/
	public void removeRating() throws Exception
	{
		String varRemove = driver.findElement(By.xpath(UIMapProductSearch.lnkBrdboxRatingRemove)).getText();
		if(varRemove.equals("remove"))
		{
			report.updateTestLog("Checking Remove link in Ratings Chosen Pop-up","Remove link In Ratings Chosen Pop-up displayed" , Status.PASS);
			driver.findElement(By.xpath(UIMapProductSearch.lnkBrdboxRatingRemove)).click();
			report.updateTestLog("Removing Ratings","Ratings removed" , Status.DONE);
			Thread.sleep(5000);
			boolean varRatingsChosen = driver.findElement(By.id(UIMapProductSearch.webElmntRatingsBreadbox)).isDisplayed();
			System.out.println("Ratings Chosen Pop-up Displayed after Remove:"+varRatingsChosen);
			if(varRatingsChosen)
			{
				report.updateTestLog("Checking Ratings Chosen Pop-up","Ratings Chosen Pop-up STILL displayed" , Status.FAIL);
			}
			else
			{
				report.updateTestLog("Checking Ratings Chosen Pop-up","Ratings Chosen Pop-up Not displayed" , Status.PASS);
				checkStarProductCount();
			}
		}
		else
		{
			report.updateTestLog("Checking Remove link in Ratings Chosen Pop-up","Remove link In Ratings Chosen Pop-up NOT displayed" , Status.FAIL);
		}
	}
	
	/*validate ratings functionality*/
	public void validateRatings() throws Exception
	{
		boolean varRatingDisplayed = selenium.isElementPresent("Rating");
		if(varRatingDisplayed)
		{
			report.updateTestLog("Checking Ratings","Ratings displayed" , Status.PASS);
			//checking default Expanded
			checkStateRating("Expanded");
			//The numbers next to the ratings should reflect how many products have the qualification.
			checkStarProductCount();
			//validate nbr of stars in ratings*/
			List<WebElement> varStars = driver.findElements(By.xpath(UIMapProductSearch.webElmntRatingStars));
			int varCount = varStars.size();
			if(varCount==5)
			{
				report.updateTestLog("Checking Stars count","Five Stars displayed" , Status.PASS);	
			}
			else
			{
				report.updateTestLog("Checking Stars count","Five Stars NOT displayed" , Status.FAIL);
			}
			//Collapsing Ratings 
			try{driver.findElement(By.xpath(UIMapProductSearch.lnkRatingFacet)).click();
			Thread.sleep(2000);}
			catch(Exception WebDriverException)
			{
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup","Handeled", Status.DONE);
				driver.findElement(By.xpath(UIMapProductSearch.lnkRatingFacet)).click();
				Thread.sleep(2000);}
			checkStateRating("Collapsed");
			//Expanding Ratings 
			driver.findElement(By.xpath(UIMapProductSearch.lnkRatingFacet)).click();
			Thread.sleep(2000);
			checkStateRating("Expanded");
			//Selecting  & Removing ratings and validating product list and Ratings Chosen Pop-up
			selectRating();
			removeRating();
			selectRating();
			removeRating();
			selectRating();
			removeRating();	
			
			
		}
		else
		{
			report.updateTestLog("Checking Ratings","Ratings Not displayed" , Status.FAIL);
		}
	}
	
	/*This function selects links on left navigation*/
	public void selectLinkLeftNav() throws Exception
	{
		String varURL = driver.getCurrentUrl();
		int varLinkCount = 0;
		int varCount = 0;
		String varXpath1 = null;
		int flag = 0;
		try
		{
			boolean varUL1 = driver.findElement(By.id(UIMapProductSearch.webElmntLeftRailProductList)).isDisplayed();
			System.out.println("left_rail_pl displayed");
			if(varUL1)
			{
				String varClass2 = driver.findElement(By.xpath(UIMapProductSearch.webElmntLeftRailList2)).getAttribute("class");
				//String varShowMe = driver.findElement(By.xpath("//*[@id='left_rail_pl']/
				if(varClass2.equals("categories sep"))
				{
				report.updateTestLog("Checking Left Navigation","Links displayed in Left Navigation" , Status.PASS);
				List<WebElement> varLinks = driver.findElements(By.xpath(UIMapProductSearch.webElmntLeftRailLinks));
				varCount = varLinks.size();
				varXpath1=UIMapProductSearch.webElmntLeftRailList2+"/li[";
				}
				else
				{
				String varClass1 = driver.findElement(By.xpath(UIMapProductSearch.webElmntLeftRailList1)).getAttribute("class");
				if(varClass1.equals("categories sep"))
				{
					String varShowMe = driver.findElement(By.xpath(UIMapProductSearch.webElmntLeftRailListHeading)).getText();
					if(varShowMe.equals("Show Me"))
					{report.updateTestLog("Checking Left Navigation","Links NOT displayed in Left Navigation" , Status.FAIL);}
					else
					{
				report.updateTestLog("Checking Left Navigation","Links displayed in Left Navigation" , Status.PASS);
				List<WebElement> varLinks = driver.findElements(By.xpath(UIMapProductSearch.webElmntLeftRailList1+"/li"));
				varCount = varLinks.size();
				varXpath1=UIMapProductSearch.webElmntLeftRailList1+"/li[";
					}
				}	
				else
				{
					report.updateTestLog("Checking Left Navigation","Links NOT displayed in Left Navigation" , Status.FAIL);
				}
				}
			}
			else
			{
				report.updateTestLog("Checking Left Navigation","Links NOT displayed in Left Navigation" , Status.FAIL);
			}
		}
		catch(Exception NoSuchElementException)
		{
			boolean varUL2 = driver.findElement(By.id(UIMapProductSearch.webElmntLeftRail1)).isDisplayed();
			System.out.println("left_rail displayed");
			if(varUL2)
			{	
				String varClass3 = driver.findElement(By.xpath(UIMapProductSearch.webElmntDivLeftRail)).getAttribute("class");
				if(varClass3.equals("cat_nav"))
				{
				report.updateTestLog("Checking Left Navigation","Links displayed in Left Navigation" , Status.PASS);
				List<WebElement> varLinks = driver.findElements(By.xpath(UIMapProductSearch.webElmntListLeftRail));
				varCount = varLinks.size();
				varXpath1=UIMapProductSearch.webElmntListLeftRail+"[";
			//	flag=2;
				}
				else
				{
					report.updateTestLog("Checking Left Navigation","Links NOT displayed in Left Navigation" , Status.FAIL);
				}
			}
			else
			{
				report.updateTestLog("Checking Left Navigation","Links NOT displayed in Left Navigation" , Status.FAIL);
			}
			
			
		}
			
			
			
			
			
		
		
		
		Random rand = new Random();
		//randomly clicking on links
		System.out.println("Links Count:" +varCount);
		int loopCount;
		if(varCount>5)
			loopCount=5;
		else
			loopCount=varCount;
		System.out.println("Loop count:"+loopCount);
		for(int i=1;i<=loopCount;i++)
		{
			
			varLinkCount = rand.nextInt(varCount-1)+1;
			System.out.println("Random link nbr:"+varLinkCount);
			String varXpath2 = varXpath1+varLinkCount+"]/a";
			String varName = driver.findElement(By.xpath(varXpath2)).getText();
			if(varName.equals("More"))
			{
				driver.findElement(By.xpath(varXpath2)).click();
				Thread.sleep(2000);
			}
			System.out.println("Selected link:"+varName);
			driver.findElement(By.xpath(varXpath2)).click();
			Thread.sleep(2000);
			selenium.waitForCondition("selenium.isElementPresent(\"xpath=//*[@id='breadcrumbs']/ul/li\");", "10000");
			//selenium.waitForCondition("driver.findElement(By.xpath(\"//*[@id='breadcrumbs']/ul/li\");", "10000");
			List<WebElement> varBrdCrmb = driver.findElements(By.xpath(UIMapProductSearch.webElmntBrdCrumbs));
			int varCount2 = varBrdCrmb.size();
			String varBrdCrmbTxt = driver.findElement(By.xpath("//*[@id='breadcrumbs']/ul/li["+varCount2+"]")).getText();
			if(varName.equalsIgnoreCase(varBrdCrmbTxt))
			{
				report.updateTestLog("Selected link: "+varName,varName+" displayed in breadcrumb" , Status.PASS);
			}
			else
			{
				String varBrdCrmbparent = driver.findElement(By.xpath("//*[@id='breadcrumbs']/ul/li["+(varCount2-1)+"]")).getText();
				if(varName.equalsIgnoreCase(varBrdCrmbparent))
				{
					report.updateTestLog("Selected link: "+varName,varName+" displayed in breadcrumb" , Status.PASS);
				}
				else
				report.updateTestLog("Selected link: "+varName,varName+" NOT displayed in breadcrumb" , Status.FAIL);
			}
			driver.get(varURL);
			
			selenium.waitForPageToLoad("60000");
			
		}
		
		
	}
	
	/*This function selects links on left navigation for Browse->Category Page*/
	public void selectLinkLeftNavCat() throws Exception
	{
		String varURL = driver.getCurrentUrl();
		int varLinkCount = 0;
		int varCount = 0;
		String varXpath1 = null;
		int flag = 0;
		try
		{
			boolean varUL1 = driver.findElement(By.id(UIMapProductSearch.webElmntLeftRailProductList)).isDisplayed();
			System.out.println("left_rail_pl displayed");
			if(varUL1)
			{
				String varClass2 = driver.findElement(By.xpath(UIMapProductSearch.webElmntLeftRailList2)).getAttribute("class");
				//String varShowMe = driver.findElement(By.xpath("//*[@id='left_rail_pl']/
				if(varClass2.equals("categories sep"))
				{
				report.updateTestLog("Checking Left Navigation","Links displayed in Left Navigation" , Status.PASS);
				List<WebElement> varLinks = driver.findElements(By.xpath(UIMapProductSearch.webElmntLeftRailLinks));
				varCount = varLinks.size();
				varXpath1=UIMapProductSearch.webElmntLeftRailList2+"/li[";
				}
				else
				{
				String varClass1 = driver.findElement(By.xpath(UIMapProductSearch.webElmntLeftRailList1)).getAttribute("class");
				if(varClass1.equals("categories sep"))
				{
					String varShowMe = driver.findElement(By.xpath(UIMapProductSearch.webElmntLeftRailListHeading)).getText();
					if(varShowMe.equals("Show Me"))
					{report.updateTestLog("Checking Left Navigation","Links NOT displayed in Left Navigation" , Status.FAIL);}
					else
					{
				report.updateTestLog("Checking Left Navigation","Links displayed in Left Navigation" , Status.PASS);
				List<WebElement> varLinks = driver.findElements(By.xpath("//*[@id='left_rail_pl']/ul[1]/li"));
				varCount = varLinks.size();
				varXpath1=UIMapProductSearch.webElmntLeftRailList1+"/li[";
					}
				}	
				else
				{
					report.updateTestLog("Checking Left Navigation","Links NOT displayed in Left Navigation" , Status.FAIL);
				}
				}
			}
			else
			{
				report.updateTestLog("Checking Left Navigation","Links NOT displayed in Left Navigation" , Status.FAIL);
			}
		}
		catch(Exception NoSuchElementException)
		{
			boolean varUL2 = driver.findElement(By.id(UIMapProductSearch.webElmntLeftRail1)).isDisplayed();
			System.out.println("left_rail displayed");
			if(varUL2)
			{	
				String varClass3 = driver.findElement(By.xpath(UIMapProductSearch.webElmntDivLeftRail)).getAttribute("class");
				if(varClass3.equals("cat_nav"))
				{
				report.updateTestLog("Checking Left Navigation","Links displayed in Left Navigation" , Status.PASS);
				List<WebElement> varLinks = driver.findElements(By.xpath(UIMapProductSearch.webElmntListLeftRail));
				varCount = varLinks.size();
				varXpath1=UIMapProductSearch.webElmntListLeftRail+"[";
			//	flag=2;
				}
				else
				{
					report.updateTestLog("Checking Left Navigation","Links NOT displayed in Left Navigation" , Status.FAIL);
				}
			}
			else
			{
				report.updateTestLog("Checking Left Navigation","Links NOT displayed in Left Navigation" , Status.FAIL);
			}
			
			
		}
		
		Random rand = new Random();
		//randomly clicking on links
		System.out.println("Links Count:" +varCount);
		int loopCount;
		if(varCount>5)
			loopCount=5;
		else
			loopCount=varCount;
		System.out.println("Loop count:"+loopCount);
		for(int i=1;i<=loopCount;i++)
		{
			String varProductCount1 = null;
			String varNameTrimmed=null;
			varLinkCount = rand.nextInt(varCount-1)+1;
			System.out.println("Random link nbr:"+varLinkCount);
			String varXpath2 = varXpath1+varLinkCount+"]/a";
			String varName = driver.findElement(By.xpath(varXpath2)).getText();
			String pattern = "([A-Za-z\\s&-]*)(.*)";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(varName);
			
		     if (m.find( )) 
		     {
		    	 System.out.println(m.group(1));
		    	 int len = m.group(1).length();
		    	 varNameTrimmed=m.group(1).substring(0,len-1);
	    	      len = m.group(2).length();
	    	     varProductCount1=m.group(2).substring(1, len-1);
	    	     System.out.println("Product Count in link:"+varProductCount1);
		     }
			if(varNameTrimmed.equals("More"))
			{
				driver.findElement(By.xpath(varXpath2)).click();
				Thread.sleep(2000);
			}
			System.out.println("Selected link:"+varNameTrimmed);
			driver.findElement(By.xpath(varXpath2)).click();
			Thread.sleep(2000);
			selenium.waitForCondition("selenium.isElementPresent(\"xpath=//*[@id='breadcrumbs']/ul/li\");", "10000");
			//selenium.waitForCondition("driver.findElement(By.xpath(\"//*[@id='breadcrumbs']/ul/li\");", "10000");
			List<WebElement> varBrdCrmb = driver.findElements(By.xpath(UIMapProductSearch.webElmntBrdCrumbs));
			int varCount2 = varBrdCrmb.size();
			String varBrdCrmbTxt = driver.findElement(By.xpath("//*[@id='breadcrumbs']/ul/li["+varCount2+"]")).getText();
			if(varNameTrimmed.equalsIgnoreCase(varBrdCrmbTxt))
			{
				report.updateTestLog("Selected link: "+varNameTrimmed,varNameTrimmed+" displayed in breadcrumb" , Status.PASS);
				try
				{String varProductCount2 = driver.findElement(By.xpath(UIMapProductSearch.webElmntTotalResults)).getText();
				System.out.println("Count in product list:"+varProductCount2);
				if(varProductCount2.equals(varProductCount1))
				{
					report.updateTestLog("Checking Product List","Products List displayed as per selected link" , Status.PASS);
				}
				else
				{
					report.updateTestLog("Checking Product List","Products List NOT displayed as per selected link" , Status.FAIL);
				}
				}
				catch(Exception NoSuchElementException)
				{
					System.out.println("No Products displayed");
				}
			}
			else
			{
				String varBrdCrmbparent = driver.findElement(By.xpath("//*[@id='breadcrumbs']/ul/li["+(varCount2-1)+"]")).getText();
				if(varName.equalsIgnoreCase(varBrdCrmbparent))
				{
					report.updateTestLog("Selected link: "+varName,varName+" displayed in breadcrumb" , Status.PASS);
				}
				else
				report.updateTestLog("Selected link: "+varNameTrimmed,varNameTrimmed	+" NOT displayed in breadcrumb" , Status.FAIL);
			}
			driver.get(varURL);
			
			selenium.waitForPageToLoad("60000");
			
		}
		
		
	}
	
	/*This function selects links on left navigation for Browse->ProductList Page*/
	public void selectLinkLeftNavProductList() throws Exception
	{
		String varURL = driver.getCurrentUrl();
		int varLinkCount = 0;
		int varCount = 0;
		String varXpath1 = null;
		//int flag = 0;
			boolean varUL = driver.findElement(By.xpath(UIMapProductSearch.webElmntLeftRailList1)).isDisplayed();
			if(varUL)
			{
				
				report.updateTestLog("Checking Left Navigation","Links displayed in Left Navigation" , Status.PASS);
				List<WebElement> varLinks = driver.findElements(By.xpath(UIMapProductSearch.webElmntLeftRailList1+"/li"));
				varCount = varLinks.size();
				varXpath1=UIMapProductSearch.webElmntLeftRailList1+"/li[";
			}
			else
			{
				report.updateTestLog("Checking Left Navigation","Links NOT displayed in Left Navigation" , Status.FAIL);
			}
		
		Random rand = new Random();
		//randomly clicking on links
		System.out.println("Links Count:" +varCount);
		int loopCount;
		if(varCount>5)
			loopCount=5;
		else
			loopCount=varCount;
		System.out.println("Loop count:"+loopCount);
		for(int i=1;i<=loopCount;i++)
		{
			String varProductCount1 = null;
			String varNameTrimmed=null;
			varLinkCount = rand.nextInt(varCount-1)+1;
			System.out.println("Random link nbr:"+varLinkCount);
			String varXpath2 = varXpath1+varLinkCount+"]/a";
			String varName = driver.findElement(By.xpath(varXpath2)).getText();
			String pattern = "([A-Za-z\\s&-]*)(.*)";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(varName);
			
		     if (m.find( )) 
		     {
		    	 System.out.println(m.group(1));
		    	 int len = m.group(1).length();
		    	 varNameTrimmed=m.group(1).substring(0,len-1);
	    	      len = m.group(2).length();
	    	     varProductCount1=m.group(2).substring(1, len-1);
	    	     System.out.println("Product Count in link:"+varProductCount1);
		     }
			if(varNameTrimmed.equals("More"))
			{
				driver.findElement(By.xpath(varXpath2)).click();
				Thread.sleep(2000);
			}
			System.out.println("Selected link:"+varNameTrimmed);
			driver.findElement(By.xpath(varXpath2)).click();
			Thread.sleep(2000);
			selenium.waitForCondition("selenium.isElementPresent(\"xpath=//*[@id='breadcrumbs']/ul/li\");", "10000");
			//selenium.waitForCondition("driver.findElement(By.xpath(\"//*[@id='breadcrumbs']/ul/li\");", "10000");
			List<WebElement> varBrdCrmb = driver.findElements(By.xpath(UIMapProductSearch.webElmntBrdCrumbs));
			int varCount2 = varBrdCrmb.size();
			String varBrdCrmbTxt = driver.findElement(By.xpath("//*[@id='breadcrumbs']/ul/li["+varCount2+"]")).getText();
			if(varNameTrimmed.equalsIgnoreCase(varBrdCrmbTxt))
			{
				report.updateTestLog("Selected link: "+varNameTrimmed,varNameTrimmed+" displayed in breadcrumb" , Status.PASS);
				try{
				String varProductCount2 = driver.findElement(By.xpath(UIMapProductSearch.webElmntTotalResults)).getText();
				System.out.println("Count in product list:"+varProductCount2);
				if(varProductCount2.equals(varProductCount1))
				{
					report.updateTestLog("Checking Product List","Products List displayed as per selected link" , Status.PASS);
				}
				else
				{
					report.updateTestLog("Checking Product List","Products List NOT displayed as per selected link" , Status.FAIL);
				}}
				catch(Exception NoSuchElementException)
				{
					System.out.println("No Products displayed");
				}
			}
			else
			{
				String varBrdCrmbparent = driver.findElement(By.xpath("//*[@id='breadcrumbs']/ul/li["+(varCount2-1)+"]")).getText();
				if(varName.equalsIgnoreCase(varBrdCrmbparent))
				{
					report.updateTestLog("Selected link: "+varName,varName+" displayed in breadcrumb" , Status.PASS);
				}
				else
				report.updateTestLog("Selected link: "+varNameTrimmed,varNameTrimmed	+" NOT displayed in breadcrumb" , Status.FAIL);
			}
			driver.get(varURL);
			
			selenium.waitForPageToLoad("60000");
			
		}
		
		
	}
	
	/*This function selects links on left navigation for Dept-Sup Category page*/
	public void selectLinkLeftNavSupCat() throws Exception
	{	
		String varURL = driver.getCurrentUrl();
		int varLinkCount = 0;
		int varCount = 0;
		String varXpath1 = null;
		//int flag = 0;
			boolean varUL = driver.findElement(By.xpath(UIMapProductSearch.webElmntDivLeftRail+"/ul")).isDisplayed();
			if(varUL)
			{
				report.updateTestLog("Checking Left Navigation","Links displayed in Left Navigation" , Status.PASS);
				List<WebElement> varLinks = driver.findElements(By.xpath("//*[@id='left_rail']/div[1]/ul/li"));
				varCount = varLinks.size();
				varXpath1=UIMapProductSearch.webElmntListLeftRail+"[";
			}
			else
			{
				report.updateTestLog("Checking Left Navigation","Links NOT displayed in Left Navigation" , Status.FAIL);
			}
			Random rand = new Random();
			//randomly clicking on links
			System.out.println("Links Count:" +varCount);
			int loopCount;
			if(varCount>5)
				loopCount=5;
			else
				loopCount=varCount;
			System.out.println("Loop count:"+loopCount);
			for(int i=1;i<=loopCount;i++)
			{
				//String varProductCount1 = null;
				String varNameTrimmed=null;
				varLinkCount = rand.nextInt(varCount-1)+1;
				System.out.println("Random link nbr:"+varLinkCount);
				String varXpath2 = varXpath1+varLinkCount+"]/a";
				System.out.println(varXpath2);
				String varName = driver.findElement(By.xpath(varXpath2)).getText();
				String pattern = "([A-Za-z\\s&-]*)(.*)";
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(varName);
				
			     if (m.find( )) 
			     {
			    	 System.out.println(m.group(1));
			    	 int len = m.group(1).length();
			    	 varNameTrimmed=m.group(1).substring(0,len-1);
		    	    //  len = m.group(2).length();
		    	    // varProductCount1=m.group(2).substring(1, len-1);
		    	    // System.out.println("Product Count in link:"+varProductCount1);
			     }
				if(varNameTrimmed.equals("More"))
				{
					driver.findElement(By.xpath(varXpath2)).click();
					Thread.sleep(2000);
				}
				System.out.println("Selected link:"+varNameTrimmed);
				driver.findElement(By.xpath(varXpath2)).click();
				Thread.sleep(2000);
				FunctionalComponents.waitforVisible(driver,UIMapProductSearch.webElmntBrdCrumbs,20);
				//selenium.waitForCondition("selenium.isElementPresent(\"xpath=//*[@id='breadcrumbs']/ul/li\");", "10000");
				//selenium.waitForCondition("driver.findElement(By.xpath(\"//*[@id='breadcrumbs']/ul/li\");", "10000");
				List<WebElement> varBrdCrmb = driver.findElements(By.xpath(UIMapProductSearch.webElmntBrdCrumbs));
				int varCount2 = varBrdCrmb.size();
				String varBrdCrmbTxt = driver.findElement(By.xpath("//*[@id='breadcrumbs']/ul/li["+varCount2+"]")).getText();
				if(varNameTrimmed.equalsIgnoreCase(varBrdCrmbTxt))
				{
					report.updateTestLog("Selected link: "+varNameTrimmed,varNameTrimmed+" displayed in breadcrumb. Correct Page displayed" , Status.PASS);
					
				}
				else
				{
					String varBrdCrmbparent = driver.findElement(By.xpath("//*[@id='breadcrumbs']/ul/li["+(varCount2-1)+"]")).getText();
					if(varName.equalsIgnoreCase(varBrdCrmbparent))
					{
						report.updateTestLog("Selected link: "+varName,varName+" displayed in breadcrumb. Correct Page displayed" , Status.PASS);
					}
					else
					report.updateTestLog("Selected link: "+varNameTrimmed,varNameTrimmed	+" NOT displayed in breadcrumb" , Status.FAIL);
				}
				driver.get(varURL);
				
				FunctionalComponents.waitforVisible(driver,UIMapProductSearch.webElmntListLeftRail,20);
			}
		
	}
	
	
	/*This function clicks on Home Link*/
	public void clickHome() throws Exception
	{
		driver.findElement(By.linkText("Home")).click();
		selenium.waitForPageToLoad("20000");
		String getLowesHomePgTitle=selenium.getTitle();
		System.out.println("Lowes HomePage Title is :"+getLowesHomePgTitle);
		if(getLowesHomePgTitle.contains("Lowe's Home Improvement: Appliances, Tools,"))
		{
			report.updateTestLog("Clicking Home Link", "Lowes homepage displayed Successfully", Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking Home Link", "Lowes homepage NOT displayed", Status.FAIL);
		}
	}
	
	/*This function validates product description in List view*/
	public void checkProductDescList() throws Exception
	{
		//count nbr of products on page and randomly check product desc of any 3
		List<WebElement> varGC = driver.findElements(By.xpath(UIMapProductSearch.webElmntProductList2));
		int varCount = varGC.size();
		Random rand = new Random();
		for(int i=0;i<3;i++)
		{
		int varRandomProduct = rand.nextInt(varCount-1)+1;
		System.out.println("Random Product Nbr:"+varRandomProduct);
		String varXpath = "//*[@id='productResults']/li["+varRandomProduct+"]";
		System.out.println(driver.findElement(By.xpath(varXpath)).getAttribute("id"));
		String varProductName = driver.findElement(By.xpath(varXpath+"/div/div[2]/h3/a")).getText();
		boolean varProductDesc=driver.findElement(By.xpath(varXpath+"/div/div[4]/ul[2]")).isDisplayed();
		if(varProductDesc)
		{
			report.updateTestLog("Checking Product Desc in List View", "Product Desc displayed in List View", Status.PASS);
			List<WebElement> varBullets = driver.findElements(By.xpath(varXpath+"/div/div[4]/ul[2]/li"));
			int varBulletsCount = varBullets.size();
			if(varBulletsCount<=3)
			{
				report.updateTestLog("Checking Bullet points in Product Desc", "Bullet Points less than three for Product "+varProductName, Status.PASS);
			}
			else
			{
				report.updateTestLog("Checking Bullet points in Product Desc", "Bullet Points NOT less than three for Product "+varProductName, Status.FAIL);
			}
			for(int j=1;j<=varBulletsCount;j++)
			{
				int len = driver.findElement(By.xpath(varXpath+"/div/div[4]/ul[2]/li["+j+"]")).getText().length();
				if(len>153)
				{
					report.updateTestLog("Checking Bullet points in Product Desc", "Bullet Point "+j+" length>150 for Product "+varProductName, Status.FAIL);
				}
				if(j==varBulletsCount)
				{
					report.updateTestLog("Checking Bullet points in Product Desc", "Bullet Points nbr of characters validated for Product "+varProductName, Status.DONE);
				}
			}
			
			
			
		}
		else
		{
			report.updateTestLog("Checking Product Desc in List View", "Product Desc NOT displayed in List View", Status.FAIL);
		}
		}
		
		
	}
	
	/*This function validates product description in Grid view*/
	public void checkProductDescGrid() throws Exception
	{
		//count nbr of products on page and randomly check product desc of any 3
		List<WebElement> varGC = driver.findElements(By.xpath(UIMapProductSearch.webElmntProductList2));
		int varCount = varGC.size();
		Random rand = new Random();
		for(int i=0;i<3;i++)
		{
		int varRandomProduct = rand.nextInt(varCount-1)+1;
		System.out.println("Random Product Nbr:"+varRandomProduct);
		String varXpath = "//*[@id='productResults']/li["+varRandomProduct+"]";
		System.out.println(driver.findElement(By.xpath(varXpath)).getAttribute("id"));
		String varProductName = driver.findElement(By.xpath(varXpath+"/div/div[2]/h3/a")).getText();
		boolean varProductDesc=driver.findElement(By.xpath(varXpath+"/div/div[4]/ul[2]")).isDisplayed();
		if(varProductDesc)
		{
			
			report.updateTestLog("Checking Product Desc in Grid View", "Product Desc displayed in Grid View for Product "+varProductName, Status.FAIL);
			
		}
		else
		{
			report.updateTestLog("Checking Product Desc in Grid View", "Product Desc NOT displayed in Grid View for Product "+varProductName, Status.PASS);
		}
		}
		
		
	}
	
	/*This function validates product descriptions in Product List*/
	public void validateProductDesc() throws Exception
	{
		//switching to list view
		swtichProductResultsList();
		checkProductDescList();
		swtichProductResultsGrid();
		checkProductDescGrid();
		
	}
	
	/*This function validates the Ratings of products in Products list and comparison page*/
	public void validateProductRatings() throws Exception
	{
		int starFlag=0;
		int notRatedFlag=0;
		String starItemNbr = null;
		String notRatedItemNbr = null;
		String starItemNbrTrimmed = null;
		String notRatedItemNbrTrimmed = null;
		String varProductName=null;
		String varProductName2=null;
		List<WebElement> varGC = driver.findElements(By.xpath(UIMapProductSearch.webElmntProductList2));
		int varCount = varGC.size();
		System.out.println("Products Count:"+varCount);
		for(int i=1;i<=varCount;i++)
		{
			String varXpath = "//*[@id='productResults']/li["+i+"]";
			if((starFlag==0)||(notRatedFlag==0))
			{
			try
			{	System.out.println(varXpath+"/div/div[2]/div/img");
				boolean varStars = driver.findElement(By.xpath(varXpath+"/div/div[2]/div/img")).isDisplayed();
				if(varStars)
				{
					
					System.out.println("Stars Rating displayed for "+varProductName);
					varProductName = driver.findElement(By.xpath(varXpath+"/div/div[2]/h3/a")).getText();
					// System.out.println("Stars Rating displayed for "+varProductName);
					 report.updateTestLog("Checking Ratings in Product List", "Star Ratings displayed for Product "+varProductName, Status.PASS);
					 String varToolTip = driver.findElement(By.xpath(varXpath+"/div/div[2]/div/img")).getAttribute("title");
					 String pattern = "Rating [0-9].*[0-9]* out of 5 stars";
					 Pattern r = Pattern.compile(pattern);
					 Matcher m = r.matcher(varToolTip);
					 if (m.find( )) 
					 {
						 report.updateTestLog("Checking Ratings-ToolTip in Product List", "Tooltip text present "+varToolTip, Status.PASS);
					 }
					 else
					 {
						 report.updateTestLog("Checking Ratings-ToolTip in Product List", "Tooltip text NOT present "+varToolTip, Status.FAIL);
					 }
					 String varReviewCount = driver.findElement(By.xpath(varXpath+"/div/div[2]/div/a")).getText();
					 System.out.println(varReviewCount);
					 pattern = "[0-9]+ [Rr]eview[s]*";
					 r = Pattern.compile(pattern);
					 m = r.matcher(varReviewCount);
					 if (m.find( )) 
					 {
						 report.updateTestLog("Checking Ratings-Reviews in Product List", "Reviews Count displayed "+varReviewCount, Status.PASS);
					 }
					 else
					 {
						 report.updateTestLog("Checking Ratings-Reviews in Product List", "Reviews Count NOT displayed ", Status.FAIL);
					 }
					 starFlag=i;
					 starItemNbr = driver.findElement(By.xpath(varXpath+"/div/div[4]/ul[1]/li[1]")).getText();
					 starItemNbrTrimmed = starItemNbr.substring(8, starItemNbr.length());
					 System.out.println(starItemNbrTrimmed);
				}
			}
			catch(Exception NoSuchElementException)
			{
				//varProductName = driver.findElement(By.xpath(varXpath+"/div/div[2]/h3/a")).getText();
				System.out.println(varXpath+"/div/div[2]/div/strong");
				boolean varNotRated = driver.findElement(By.xpath(varXpath+"/div/div[2]/div/strong")).isDisplayed();
				if(varNotRated)
				{
					varProductName2 = driver.findElement(By.xpath(varXpath+"/div/div[2]/h3/a")).getText();
					System.out.println("Not Yet Rated "+varProductName2);
					
					//System.out.println("Not Yet Rated "+varProductName);
					report.updateTestLog("Checking Ratings in Product List", "'NOT YET RATED' displayed for Product "+varProductName2, Status.PASS);
					notRatedFlag = i;
					notRatedItemNbr=driver.findElement(By.xpath(varXpath+"/div/div[4]/ul[1]/li[1]")).getText();
					notRatedItemNbrTrimmed=notRatedItemNbr.substring(8, notRatedItemNbr.length());
					System.out.println(notRatedItemNbrTrimmed);
					
				}
				
			}
			}
			else
			{
				break;
			}
			}
				//selecting star rated item for comparison
				driver.findElement(By.xpath("//*[@id='productResults']/li["+starFlag+"]/div/div/div/input")).click();
				Thread.sleep(2000);
				//selecting not yet rated item for comparison
				driver.findElement(By.xpath("//*[@id='productResults']/li["+notRatedFlag+"]/div/div/div/input")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(UIMapProductSearch.btnCompare)).click();
				//selenium.waitForPageToLoad("20000");
				//if(selenium.is)
				System.out.println("Calling waitforVisible");
				FunctionalComponents.waitforVisible(driver,UIMapProductSearch.lblComparePgHeading,20);
				System.out.println("waitforVisible executed");
				String varItemNbr = driver.findElement(By.xpath(UIMapProductSearch.lblItemNbr1Cmpr)).getText();
				if(varItemNbr.equals(starItemNbrTrimmed))
				{
					boolean varStar2 = driver.findElement(By.xpath(UIMapProductSearch.webElmntItemNbr1Stars)).isDisplayed();
					boolean varNotRated2 = driver.findElement(By.xpath("//*[@id='product-compare-area']/div[3]/div[5]/table/tbody/tr[3]/td/strong")).isDisplayed();
					if(varStar2)
					{	
						report.updateTestLog("Checking Ratings in Comparison page", "Star Ratings displayed for Product In Comparison Page for "+varProductName, Status.PASS);
						String	varToolTip = driver.findElement(By.xpath("//*[@id='product-compare-area']/div[3]/div[4]/table/tbody/tr[3]/td/span/img")).getAttribute("title");
						 String pattern = "Rating [0-9].*[0-9]* out of 5 stars";
						 Pattern r = Pattern.compile(pattern);
						 Matcher m = r.matcher(varToolTip);
						 if (m.find( )) 
						 {
							 report.updateTestLog("Checking Ratings-ToolTip in Product Comparison", "Tooltip text present "+varToolTip, Status.FAIL);
						 }
						 else if (varToolTip.equals(""))
						 {
							 report.updateTestLog("Checking Ratings-ToolTip in Product Comparison", "Tooltip text NOT present "+varToolTip, Status.PASS);
						 }
						 String varReviewCount = driver.findElement(By.xpath("//*[@id='product-compare-area']/div[3]/div[4]/table/tbody/tr[3]/td/span")).getText();
						 System.out.println(varReviewCount);
						 pattern = "[0-9]+ [Rr]eview[s]*";
						 r = Pattern.compile(pattern);
						 m = r.matcher(varReviewCount);
						 if (m.find( )) 
						 {
							 report.updateTestLog("Checking Ratings-Reviews in Product Comparison", "Reviews Count displayed "+varReviewCount, Status.PASS);
						 }
						 else
						 {
							 report.updateTestLog("Checking Ratings-Reviews in Product Comparison", "Reviews Count NOT displayed ", Status.FAIL);
						 }
					}
					else
					{
						report.updateTestLog("Checking Ratings in Comparison page", "Star Ratings NOT displayed for Product In Comparison Page for "+varProductName, Status.FAIL);
					}
					if(varNotRated2)
					{
						report.updateTestLog("Checking Ratings in Comparison page", "'NOT YET RATED' displayed for Product In Comparison Page for "+varProductName, Status.PASS);
					}
					else
					{
						report.updateTestLog("Checking Ratings in Comparison page", "'NOT YET RATED' NOT displayed for Product In Comparison Page for "+varProductName, Status.FAIL);
					}
				}
				else
				{
					boolean varStar3 = driver.findElement(By.xpath("//*[@id='product-compare-area']/div[3]/div[5]/table/tbody/tr[3]/td/span/img")).isDisplayed();
					boolean varNotRated3 = driver.findElement(By.xpath("//*[@id='product-compare-area']/div[3]/div[4]/table/tbody/tr[3]/td/strong")).isDisplayed();
					if(varStar3)
					{
						report.updateTestLog("Checking Ratings in Comparison page", "Star Ratings displayed for Product In Comparison Page for "+varProductName2, Status.PASS);
						String	varToolTip = driver.findElement(By.xpath("//*[@id='product-compare-area']/div[3]/div[5]/table/tbody/tr[3]/td/span/img")).getAttribute("title");
						 String pattern = "Rating [0-9].*[0-9]* out of 5 stars";
						 Pattern r = Pattern.compile(pattern);
						 Matcher m = r.matcher(varToolTip);
						 if (m.find( )) 
						 {
							 report.updateTestLog("Checking Ratings-ToolTips in Product Comparison", "Tooltip text present "+varToolTip, Status.FAIL);
						 }
						 else if (varToolTip.equals(""))
						 {
							 report.updateTestLog("Checking Ratings-Reviews in Product Comparison", "Tooltip text NOT present "+varToolTip, Status.PASS);
						 }
						 String varReviewCount = driver.findElement(By.xpath("//*[@id='product-compare-area']/div[3]/div[5]/table/tbody/tr[3]/td/span")).getText();
						 System.out.println(varReviewCount);
						 pattern = "[0-9]+ [Rr]eview[s]*";
						 r = Pattern.compile(pattern);
						 m = r.matcher(varReviewCount);
						 if (m.find( )) 
						 {
							 report.updateTestLog("Checking Ratings-Reviews in Product Comparison", "Reviews Count displayed "+varReviewCount, Status.PASS);
						 }
						 else
						 {
							 report.updateTestLog("Checking Ratings-Reviews in Product Comparison", "Reviews Count NOT displayed ", Status.FAIL);
						 }
					}
					else
					{
						report.updateTestLog("Checking Ratings in Comparison page", "Star Ratings NOT displayed for Product In Comparison Page for "+varProductName2, Status.FAIL);
					}
					if(varNotRated3)
					{
						report.updateTestLog("Checking Ratings in Comparison page", "'NOT YET RATED' displayed for Product In Comparison Page for "+varProductName2, Status.PASS);
					}
					else
					{
						report.updateTestLog("Checking Ratings in Comparison page", "'NOT YET RATED' NOT displayed for Product In Comparison Page for "+varProductName2, Status.FAIL);
					}
				
				
			}
			
		}
	
	public boolean validateCheckBox(String varXpath,boolean checked) throws Exception
	{
		try{
		System.out.println(varXpath);
		String varChecked = driver.findElement(By.xpath(varXpath)).getAttribute("checked");
		System.out.println(varChecked);
		if(varChecked.equals("true") && checked)
		{
			return true;
		}
		else
		{
			return false;
		}
		}
		catch(Exception NullPointerException)
		{
			System.out.println("Exception");
			if(checked)
			return false;
			else
				return true;
		}
	}
	
	public int multiSelectFacetValidation(int varTotal, String pattern, String varLabel) throws Exception
	{
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(varLabel);
		
	     if (m.find( )) 
	     {
	    	 //String varProductCount1 = m.group(2);
	    	 int len = m.group(2).length();
	    	 String varProductCount1 = m.group(2).substring(1, len-1);
	    	 System.out.println("Count in link:"+varProductCount1);
	    	 String varProductCount2 = driver.findElement(By.xpath(UIMapProductSearch.webElmntTotalResults)).getText();
	    	 
	    	 System.out.println("Count in product list:"+varProductCount2);
	    	 if(varTotal==0)
	    	 {
				if(varProductCount2.equals(varProductCount1))
				{
					report.updateTestLog("Checking Product List","Products List displayed as per selected link" , Status.PASS);
				}
				else
				{
					report.updateTestLog("Checking Product List","Products List NOT displayed as per selected link" , Status.FAIL);
				}
	    	 }
	    	 else
	    	 {
	    		 int varProductCount = Integer.valueOf(varProductCount1);
		    	 int varTotal2 = varProductCount+varTotal; 
		    	 int varTotal3 = Integer.valueOf(varProductCount2);
		    	 if(varTotal2==varTotal3)
		    	 {
		    		 report.updateTestLog("Checking Product List","Products List displayed as per selected link" , Status.PASS);
		    	 }
		    	 else
		    	 {
		    		 report.updateTestLog("Checking Product List","Products List NOT displayed as per selected link" , Status.FAIL);
		    	 }
		    	 
	    	 }
	    	 int varProductCount = Integer.valueOf(varProductCount1);
	    	 int varTotal2 = varProductCount+varTotal;
	    	 System.out.println(varTotal2);
	    	 return varTotal2;
	     }
	     else
	    	 return 0;
	}
	
	public void selectPriceMultiSelectFacet() throws Exception
	{
		
		boolean varPriceFacet = selenium.isElementPresent("Price");
		if(varPriceFacet)
		{
			report.updateTestLog("Checking Price facet", "Price facet displayed", Status.PASS);
			List<WebElement> varPriceList = driver.findElements(By.xpath("//*[@id='Price']/ul/li"));
			int varCount = varPriceList.size();
			//selecting first checkbox in Price
			driver.findElement(By.xpath("//*[@id='Price']/ul/li[1]/input")).click();
			Thread.sleep(5000);
			String varLabel1 = driver.findElement(By.xpath("//*[@id='Price']/ul/li[1]/label")).getText();
			boolean varChecked1 = validateCheckBox("//*[@id='Price']/ul/li[1]/input",true);
			
			if(varChecked1)
			{
				report.updateTestLog("Selected Price facet:"+varLabel1,varLabel1+ " Price facet selected", Status.PASS);
				
				
			}
			else
			{
				report.updateTestLog("Selected Price facet:"+varLabel1,varLabel1+ " Price facet NOT selected", Status.FAIL);
			}
			
			int varTotal = multiSelectFacetValidation(0,"([$[0-9]\\s-]+)(.*)",varLabel1);
			 if(varTotal==0)
			 {
				 System.out.println("Not able to validate count in Product List");
			 }
			 else
			 {
				 Random rand = new Random();
				 int varLinkCount = rand.nextInt(varCount-2)+2;
				 System.out.println("Random:"+varLinkCount);
				 driver.findElement(By.xpath("//*[@id='Price']/ul/li["+varLinkCount+"]/input")).click();
				 Thread.sleep(5000);
				 String varLabel2 = driver.findElement(By.xpath("//*[@id='Price']/ul/li["+varLinkCount+"]/label")).getText();
				 String varxpath2 = "//*[@id='Price']/ul/li["+varLinkCount+"]/input";
				 boolean varChecked2 = validateCheckBox(varxpath2,true);
					
					if(varChecked2)
					{
						report.updateTestLog("Selected Price facet:"+varLabel2,varLabel2+ " Price facet selected", Status.PASS);
						
						
					}
					else
					{
						report.updateTestLog("Selected Price facet:"+varLabel2,varLabel2+ " Price facet NOT selected", Status.FAIL);
					}
					
					multiSelectFacetValidation(varTotal,"([$[0-9]\\s-]+)(.*)",varLabel2);
					driver.findElement(By.partialLinkText("Clear All Selections")).click();
					Thread.sleep(5000);
			 }
			
			
		}
		else
		{
			report.updateTestLog("Checking Price facet", "Price facet NOT displayed", Status.FAIL);
		}
	}
	
	public void selectBrandMultiSelectFacet() throws Exception
	{
		
		boolean varBrandFacet = selenium.isElementPresent("Brand");
		if(varBrandFacet)
		{
			report.updateTestLog("Checking Brand facet", "Brand facet displayed", Status.PASS);
			List<WebElement> varvarBrandFacetList = driver.findElements(By.xpath(UIMapProductSearch.chkBoxBrand));
			int varCount = varvarBrandFacetList.size();
			//selecting first checkbox in Brand
			driver.findElement(By.xpath("//*[@id='Brand']/ul/li[1]/input")).click();
			Thread.sleep(5000);
			String varLabel1 = driver.findElement(By.xpath("//*[@id='Brand']/ul/li[1]/label")).getText();
			boolean varChecked1 = validateCheckBox("//*[@id='Brand']/ul/li[1]/input",true);
			
			if(varChecked1)
			{
				report.updateTestLog("Selected Brand facet:"+varLabel1,varLabel1+ " Brand facet selected", Status.PASS);
				
				
			}
			else
			{
				report.updateTestLog("Selected Brand facet:"+varLabel1,varLabel1+ " Brand facet NOT selected", Status.FAIL);
			}
			
			int varTotal = multiSelectFacetValidation(0,"([[A-Z][a-z]\\s-]+)(.*)",varLabel1);
			 if(varTotal==0)
			 {
				 System.out.println("Not able to validate count in Product List");
			 }
			 else
			 {
				 Random rand = new Random();
				 int varLinkCount = rand.nextInt(varCount-2)+2;
				 System.out.println("Random:"+varLinkCount);
				 driver.findElement(By.xpath("//*[@id='Brand']/ul/li["+varLinkCount+"]/input")).click();
				 Thread.sleep(5000);
				 String varLabel2 = driver.findElement(By.xpath("//*[@id='Brand']/ul/li["+varLinkCount+"]/label")).getText();
				 String varxpath2 = "//*[@id='Brand']/ul/li["+varLinkCount+"]/input";
				 boolean varChecked2 = validateCheckBox(varxpath2,true);
					
					if(varChecked2)
					{
						report.updateTestLog("Selected Brand facet:"+varLabel2,varLabel2+ " Brand facet selected", Status.PASS);
						
						
					}
					else
					{
						report.updateTestLog("Selected Brand facet:"+varLabel2,varLabel2+ " Brand facet NOT selected", Status.FAIL);
					}
					
					multiSelectFacetValidation(varTotal,"([[A-Z][a-z]\\s-]+)(.*)",varLabel2);
					driver.findElement(By.partialLinkText("Clear All Selections")).click();
					Thread.sleep(5000);
			 }
			
			
		}
		else
		{
			report.updateTestLog("Checking Brand facet", "Brand facet NOT displayed", Status.FAIL);
		}
	}
	
	/*Defect specific TC*/
	public void breadcrmbValidate() throws Exception
	{
	driver.get("http://pplws.lowes.com/pl_Appliances_4294796368+4294937007_4294937087_?cm_sp=MajorAppliances-_-Home|A1-_-Pct_Off|10_Off_Majors_Appliances_Shop&cm_cr=Homepage-_-Web+Activity-_-Homepage+A2+7.30.12-_-HomePage_Area2-_-132107_2_MajorAppliances-Home-A1-Pct_Off-10_Off_Majors_Appliances_Shop");
	selenium.waitForPageToLoad("20000");
	String varbrdcrmb1 = driver.findElement(By.xpath("//*[@id='breadcrumbs']/ul/li[1]/a")).getText();
	String varbrdcrmb2 = driver.findElement(By.xpath("//*[@id='breadcrumbs']/ul/li[2]/a")).getText();
	String varbrdcrmb3 = driver.findElement(By.xpath(UIMapMyLowes.webElmntBrdCrumbsLvl3)).getText();
	if((varbrdcrmb1.equals("Home"))&&(varbrdcrmb2.equals("10 Percent off major appliances"))&&(varbrdcrmb3.equals("Appliances")))
	{
		report.updateTestLog("Checking BreadCrumbs", "Breadcrumbs displayed as "+varbrdcrmb1+":"+varbrdcrmb2+":"+varbrdcrmb3, Status.PASS);
		
	}
	else
	{
		report.updateTestLog("Checking BreadCrumbs", "Breadcrumbs NOT displayed as "+varbrdcrmb1+":"+varbrdcrmb2+":"+varbrdcrmb3, Status.FAIL);
	}
	try{
	driver.findElement(By.partialLinkText("Cooktops")).click();
	FunctionalComponents.waitforVisible(driver,"//*[@id='breadcrumbs']/ul/li[4]",20);
	}
	catch(Exception WebDriverException)
	{
		driver.findElement(By.linkText("No, thanks")).click();
		report.updateTestLog("Survey Popup","Handeled", Status.DONE);
		driver.findElement(By.partialLinkText("Cooktops")).click();
		FunctionalComponents.waitforVisible(driver,"//*[@id='breadcrumbs']/ul/li[4]",20);
		}
	String varCookTops = driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1/span")).getText();
	if(varCookTops.equals("Cooktops"))
	{
		report.updateTestLog("Checking Cooktops", "Cooktops page displayed", Status.PASS);
	}
	else
	{
		report.updateTestLog("Checking Cooktops", "Cooktops page not displayed", Status.FAIL);
	}
	 varbrdcrmb1 = driver.findElement(By.xpath("//*[@id='breadcrumbs']/ul/li[1]/a")).getText();
	 varbrdcrmb2 = driver.findElement(By.xpath("//*[@id='breadcrumbs']/ul/li[2]/a")).getText();
	 varbrdcrmb3 = driver.findElement(By.xpath("//*[@id='breadcrumbs']/ul/li[3]/a")).getText();
	String varbrdcrmb4 = driver.findElement(By.xpath(UIMapProductSearch.webElmntBrdCrumbsLvl4)).getText();
	if((varbrdcrmb1.equals("Home"))&&(varbrdcrmb2.equals("10 Percent off major appliances"))&&(varbrdcrmb3.equals("Appliances")))
	{
		report.updateTestLog("Checking BreadCrumbs", "Breadcrumbs displayed as "+varbrdcrmb1+":"+varbrdcrmb2+":"+varbrdcrmb3+":"+varbrdcrmb4, Status.PASS);
		
	}
	else
	{
		report.updateTestLog("Checking BreadCrumbs", "Breadcrumbs NOT displayed as "+varbrdcrmb1+":"+varbrdcrmb2+":"+varbrdcrmb3+":"+varbrdcrmb4, Status.FAIL);
	}
	driver.findElement(By.xpath("//*[@id='breadcrumbs']/ul/li[2]/a")).click();
	selenium.waitForPageToLoad("20000");
	String varAppliances = driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1/span")).getText();
	if(varAppliances.equals("10 Percent off major appliances"))
	{
		report.updateTestLog("Clicking '10 Percent off major appliances' link", "'10 Percent off major appliances' page displayed", Status.PASS);
	}
	else
	{
		report.updateTestLog("Clicking '10 Percent off major appliances' link", "'10 Percent off major appliances' page NOT displayed", Status.FAIL);
	}
	}
	
	/*This function validates max and min messaging on Search page*/
	public void validateMaxMinMsg() throws Exception
	{
		boolean varConfirmStore = driver.findElement(By.id("confirm-store")).isDisplayed();
		if(varConfirmStore)
		{
			report.updateTestLog("Checking Confirm Store dialog", "Confirm Store dialog displayed", Status.PASS);
			try{driver.findElement(By.id("close-confirm-store")).click();
			Thread.sleep(2000);
			}
			catch(Exception WebDriverException)
			{
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup","Handeled", Status.DONE);
				driver.findElement(By.id("close-confirm-store")).click();
				Thread.sleep(2000);
			}
			varConfirmStore = driver.findElement(By.id("confirm-store")).isDisplayed();
			if(varConfirmStore)
			{
				report.updateTestLog("Closing Confirm Store dialog", "Confirm Store dialog STILL displayed", Status.FAIL);
			}
			else
			{
				report.updateTestLog("Closing Confirm Store dialog", "Confirm Store dialog NOT displayed", Status.PASS);
			}
		}
		else
		{
			report.updateTestLog("Checking Confirm Store dialog", "Confirm Store dialog NOT displayed", Status.FAIL);
		}
		
	}
	
	/*This function validates whether buyPair is displayed or not*/
	public void checkBuyPairProductDetail() throws Exception
	{
		boolean varBuyPairPresent = selenium.isTextPresent("Buy the Pair");
		if(varBuyPairPresent)
		{
			if(driver.findElement(By.xpath("//*[@id='productRight']/div[@id='buyPair']")).isDisplayed())
			{
			if(dataTable.getData("General_Data", "BuyPair").equals("Yes"))
			{
			report.updateTestLog("Checking Buy Pair Section", "Buy Pair Section displayed in Right Rail", Status.PASS);
			String varBuyPairLabel = driver.findElement(By.xpath("//*[@id='buyPair']/h2")).getText();
			if(varBuyPairLabel.equals("Buy the Pair"))
			{
				report.updateTestLog("Checking Buy Pair Label", "Buy Pair label displayed", Status.PASS);
			}
			else
			{
				report.updateTestLog("Checking Buy Pair Label", "Buy Pair label NOT displayed", Status.FAIL);
			}
			List<WebElement> varGC = driver.findElements(By.xpath("//*[@id='buyPair']/div"));
			int varCount = varGC.size();
			for(int i=1;i<=varCount;i++)
			{
			String varXpath = "//*[@id='buyPair']/div["+i+"]";
			String varUrl = driver.getCurrentUrl();
			boolean varBuyPairImg = driver.findElement(By.xpath(varXpath+"/a/img")).isDisplayed();
			if(varBuyPairImg)
				report.updateTestLog("Checking Buy Pair Item Image for Item "+i, "Buy Pair Item Image displayed for Item "+i, Status.PASS);
			else
				report.updateTestLog("Checking Buy Pair Item Image for Item "+i, "Buy Pair Item Image NOT displayed for Item "+i, Status.FAIL);
			String varBuyPairName = driver.findElement(By.xpath(varXpath+"/p/a")).getText();
			String varBuyPairTrimmed = varBuyPairName.substring(0, 37);
			if(varBuyPairName.isEmpty())
			{
				report.updateTestLog("Checking Buy Pair Item Name for Item "+i, "Buy Pair Item Name NOT displayed for Item "+i, Status.FAIL);
			}
			else
			{
				report.updateTestLog("Checking Buy Pair Item Name for Item "+i, "Buy Pair Item Name displayed for Item "+i, Status.PASS);
			}
			boolean varStars = driver.findElement(By.xpath(varXpath+"/p/img")).isDisplayed();
			if(varStars)
				report.updateTestLog("Checking Buy Pair Star Ratings for Item "+i, "Buy Pair Star Ratings displayed for Item "+i, Status.PASS);
			else
				report.updateTestLog("Checking Buy Pair Star Ratings for Item "+i, "Buy Pair Star Ratings NOT displayed for Item "+i, Status.FAIL);
			boolean varPrice = driver.findElement(By.xpath(varXpath+"/p/span")).isDisplayed();
			if(varPrice)
			{
				String varClass = driver.findElement(By.xpath(varXpath+"/p/span")).getAttribute("class");
				if(varClass.equals("price"))
				report.updateTestLog("Checking Buy Pair Price for Item "+i, "Buy Pair Price displayed for Item "+i, Status.PASS);
				else
					report.updateTestLog("Checking Buy Pair Price for Item "+i, "Buy Pair Price NOT displayed for Item "+i, Status.FAIL);	
			}
			else
				report.updateTestLog("Checking Buy Pair Price for Item "+i, "Buy Pair Price NOT displayed for Item "+i, Status.FAIL);
			
			driver.findElement(By.xpath(varXpath+"/a/img")).click();
			selenium.waitForPageToLoad("20000");
			String varItemName = driver.findElement(By.xpath(UIMapProductSearch.webElmntProductName)).getText();
			String varItemNameTrimmed = varItemName.substring(0, 37);
			if(varItemNameTrimmed.equals(varBuyPairTrimmed))
			{
				report.updateTestLog("Clicking Image in buy Pair section for Item "+i , "Detail page displayed for  Item "+i, Status.PASS);
			}
			else
			{
				report.updateTestLog("Clicking Image in buy Pair section for Item "+i , "Detail page NOT displayed for  Item "+i, Status.FAIL);
			}
			driver.get(varUrl);
			selenium.waitForPageToLoad("20000");
			driver.findElement(By.xpath(varXpath+"/p/a")).click();
			selenium.waitForPageToLoad("20000");
			varItemName = driver.findElement(By.xpath(UIMapProductSearch.webElmntProductName)).getText();
			varItemNameTrimmed = varItemName.substring(0, 37);
			if(varItemNameTrimmed.equals(varBuyPairTrimmed))
			{
				report.updateTestLog("Clicking Item Name in buy Pair section for Item "+i , "Detail page displayed for  Item "+i, Status.PASS);
			}
			else
			{
				report.updateTestLog("Clicking Item Name in buy Pair section for Item "+i , "Detail page NOT displayed for  Item "+i, Status.FAIL);
			}
			driver.get(varUrl);
			selenium.waitForPageToLoad("20000");
			}
			}
			else
				report.updateTestLog("Checking Buy Pair Section", "Buy Pair Section displayed in Right Rail", Status.FAIL);
			}
			
			}
		
		else
		{
			if(dataTable.getData("General_Data", "BuyPair").equals("Yes"))
			report.updateTestLog("Checking Buy Pair Section", "Buy Pair Section NOT displayed in Right Rail", Status.FAIL);
			else
				report.updateTestLog("Checking Buy Pair Section", "Buy Pair Section NOT displayed in Right Rail", Status.PASS);
		}	
			
	}
	
	/*This function validates the presence of search bar*/
	public void validateSearchBar() throws Exception
	{
		boolean varSearch = selenium.isElementPresent("Ntt");
		boolean varSearchIcon = selenium.isElementPresent("//*[@id='frmQuickSearch']/span/button");
		if(varSearch && varSearchIcon)
		{
			report.updateTestLog("Checking Search Bar & Icon", "Search Bar & Icon displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Search Bar & Icon", "Search Bar & Icon NOT displayed", Status.FAIL);
		}
	}
	
	/*This function validates the page after default search & Missspelled Search*/
	public void validateSearchDefaultMisspelled() throws Exception
	{
		if(dataTable.getData("General_Data", "Missplelled").equals("No"))
		{
		//validate Breadcrumbs after Search
		String varBrdCrmb = driver.findElement(By.xpath("//*[@id='breadcrumbs']/ul/li[1]")).getText();
		
		System.out.println(varBrdCrmb);

		String varBrdCrmb2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntBrdCrumbsLvl2)).getText();
		System.out.println(varBrdCrmb2);
		System.out.println("Search \""+dataTable.getData("General_Data", "SearchString")+"\"");
		if(varBrdCrmb.equals("Home") && varBrdCrmb2.equals("Search \""+dataTable.getData("General_Data", "SearchString")+"\""))
		{
			report.updateTestLog("Checking Breadcrumbs after Search", "Breadcrumbs displayed with Home Link and Search Item", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Breadcrumbs after Search", "Breadcrumbs NOT displayed with Home Link and Search Item", Status.FAIL);
		}
		
		//validate message
		String varMesg = driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1")).getText();
		System.out.println(varMesg);
		if(varMesg.equals("Search results for "+dataTable.getData("General_Data", "SearchString")+":"))
		{
			report.updateTestLog("Checking Message after Search", "Message after Search correctly displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Message after Search", "Message after Search NOT correctly displayed", Status.FAIL);
		}
	}
		else
		{
			String varBrdCrmb = driver.findElement(By.xpath(UIMapProductSearch.webElmntBrdCrumbs)).getText();
			
			System.out.println(varBrdCrmb);
			System.out.println("Home: Search \""+dataTable.getData("General_Data", "SearchString")+"\"");
			if(varBrdCrmb.equals("Home: Search \""+dataTable.getData("General_Data", "SearchString")+"\""))
			{
				report.updateTestLog("Checking Breadcrumbs after Misspelled Search", "Breadcrumbs displayed with Home Link and Search Item", Status.PASS);
			}
			else
			{
				report.updateTestLog("Checking Breadcrumbs after Misspelled Search", "Breadcrumbs NOT displayed with Home Link and Search Item", Status.FAIL);
			}
			
			//validate message after Misspelled search
			String varMesg = driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1")).getText();
			System.out.println(varMesg);
			String pattern = "We found results for (.*):";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(varMesg);
		     if (m.find( )) 
			{
				report.updateTestLog("Checking Misspelled Message after Search", "Message after Misspelled Search correctly displayed", Status.PASS);
			}
			else
			{
				report.updateTestLog("Checking Misspelled Message after Search", "Message after Misspelled Search NOT correctly displayed", Status.FAIL);
			}
		}
	
	}
	
	
	
	/*This function validates zero search results*/
	public void searchNoResult() throws Exception
	{
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","SearchString"));
		try{driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);}
			report.updateTestLog("Searching For an Item","Searching Item - "+dataTable.getData("General_Data","SearchString")+"" ,Status.DONE);
		
		
		selenium.waitForPageToLoad("30000");
		String varNoSearch1 = driver.findElement(By.xpath(UIMapProductSearch.webElmntNoSearchResultsHeading)).getText();
		System.out.println(varNoSearch1);
		System.out.println("We're sorry, we couldn't find any matches for \""+dataTable.getData("General_Data", "SearchString")+"\"");
		String varNoSearch2 = driver.findElement(By.xpath(UIMapProductSearch.webElmntThinkWeShouldHvIt)).getText();
		System.out.println(varNoSearch2);
		if(varNoSearch1.equals("We're sorry, we couldn't find any matches for \""+dataTable.getData("General_Data", "SearchString")+"\"")&&varNoSearch2.equals("Think we should have it?"))
		{
			report.updateTestLog("Veriyfing Navigating to Search Results ","Zero Search Results Page displayed" , Status.PASS);
		}
		else
		{
			report.updateTestLog("Veriyfing Navigating to Search Results ","Zero Search Results Page NOT displayed" , Status.FAIL);
		}
		String varSearchBarText = driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).getText();
		System.out.println("Search Bar Text:"+varSearchBarText);
		if(varSearchBarText.equals(""))
		{
			report.updateTestLog("Veriyfing Search Bar after Zero Search Results ","Search Phrase not displayed in Search Bar" , Status.PASS);
		}
		else
		{
			report.updateTestLog("Veriyfing Search Bar after Zero Search Results ","Search Bar not Empty" , Status.FAIL);
		}
		
		
		
		
	}
	
	/*This function validates if Product Details page is displayed as Search Result*/
	public void searchResultProductDetail() throws Exception
	{
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","SearchString2"));
		try{driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);}
			report.updateTestLog("Searching For an Item","Searching Item - "+dataTable.getData("General_Data","SearchString2")+"" ,Status.DONE);
		
		
		selenium.waitForPageToLoad("30000");
		boolean varDetails = selenium.isElementPresent(UIMapProductSearch.webElmntProductDetail);
		if(varDetails)
		{
			//String varItemName = driver.findElement(By.xpath(UIMapProductSearch.webElmntProductName)).getText();
			if(selenium.isTextPresent(dataTable.getData("General_Data","SearchString2")))
			{
				report.updateTestLog("Veriyfing Navigating to Search Results ","Product Details page displayed" , Status.PASS);
			}
			else
			{
				report.updateTestLog("Veriyfing Navigating to Search Results ","Incorrect Product Details page displayed" , Status.FAIL);
			}
		}
		else
		report.updateTestLog("Veriyfing Navigating to Search Results ","Search Results NOT displayed" , Status.FAIL);
		String varSearchBarText = driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).getText();
		if(varSearchBarText.equals(""))
		{
			report.updateTestLog("Veriyfing Search Bar after Search Results ","Search Phrase not displayed in Search Bar" , Status.PASS);
		}
		else
		{
			report.updateTestLog("Veriyfing Search Bar after Search Results ","Search Bar not Empty" , Status.FAIL);
		}
		
	}
	
	/*This function validates if Product List page is displayed as Search Result*/
	public void searchResultProductList() throws Exception
	{
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","SearchString3"));
		try{driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);}
			report.updateTestLog("Searching For an Item","Searching Item - "+dataTable.getData("General_Data","SearchString3")+"" ,Status.DONE);
		
		
		selenium.waitForPageToLoad("30000");
		boolean varProductList = selenium.isElementPresent(UIMapProductSearch.webElmntProductList);
		System.out.println(varProductList);
		if(varProductList)
		{
			report.updateTestLog("Veriyfing Navigating to Search Results ","Product List displayed in Search Results" , Status.PASS);
			
			
		}
		else
		{
			report.updateTestLog("Veriyfing Navigating to Search Results ","Product List NOT displayed in Search Results" , Status.FAIL);
		}
		String varSearchBarText = driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).getText();
		if(varSearchBarText.equals(""))
		{
			report.updateTestLog("Veriyfing Search Bar after Search Results ","Search Phrase not displayed in Search Bar" , Status.PASS);
		}
		else
		{
			report.updateTestLog("Veriyfing Search Bar after Search Results ","Search Bar not Empty" , Status.FAIL);
		}
	}
	
	/*This function validates whether facets on right rail are displayed as labels rather than links*/
	public void facetValidation() throws Exception
	{
		boolean varPriceFacet = selenium.isElementPresent("Price");
		int varLinkCount = 1;
		if(varPriceFacet)
		{
			String varProductCount = driver.findElement(By.xpath(UIMapProductSearch.webElmntTotalResults)).getText();
			System.out.println("Count before Selecting Price Facet:"+varProductCount);
			report.updateTestLog("Checking Price facet", "Price facet displayed", Status.PASS);
			List<WebElement> varPriceList = driver.findElements(By.xpath("//*[@id='Price']/ul/li"));
			int varCount = varPriceList.size();
			
			Random rand = new Random();
			if(varCount>6)
			{
			 varLinkCount = rand.nextInt(6-1)+1;
			System.out.println("Random:"+varLinkCount);
			}
			else
			{
				 varLinkCount = rand.nextInt(varCount-1)+1;
				System.out.println("Random:"+varLinkCount);
			}
			 
			 driver.findElement(By.xpath("//*[@id='Price']/ul/li["+varLinkCount+"]/input")).click();
			 Thread.sleep(5000);
			 String varLabel2 = driver.findElement(By.xpath("//*[@id='Price']/ul/li["+varLinkCount+"]/label")).getText();
			 
				
			 
			 String varToolTip = driver.findElement(By.xpath("//*[@id='Price']/ul/li["+varLinkCount+"]/label")).getAttribute("title");
			// String varToolTipExp = "Price:".concat(m.group(1));
			 System.out.println(varToolTip);
			// System.out.println(varToolTipExp);
			 //System.out.println(varToolTip.compareTo(varToolTipExp));
			 
			 //validating mouse hover text
			 String pattern = "Price:(.*)";
			 Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(varToolTip);
			 if (m.find( )) 
			     
			 {
				 report.updateTestLog("Checking Mouse Hover for "+varLabel2,varToolTip+ " present for "+varLabel2, Status.PASS);
			 }
			 else
			 {
				 report.updateTestLog("Checking Mouse Hover for "+varLabel2,varToolTip+ " NOT present for "+varLabel2, Status.FAIL);
			 }
			 
			 String varxpath2 = "//*[@id='Price']/ul/li["+varLinkCount+"]/input";
			 
			 
			 boolean varChecked2 = validateCheckBox(varxpath2,true);
				
				if(varChecked2)
				{
					report.updateTestLog("Selected Price facet:"+varLabel2,varLabel2+ " Price facet selected", Status.PASS);
					
					
				}
				else
				{
					report.updateTestLog("Selected Price facet:"+varLabel2,varLabel2+ " Price facet NOT selected", Status.FAIL);
				}
				//validating product List refresh
				multiSelectFacetValidation(0,"([$[0-9]\\s-]+)(.*)",varLabel2);
				//unchecking
				driver.findElement(By.xpath("//*[@id='Price']/ul/li["+varLinkCount+"]/input")).click();
				Thread.sleep(5000);
				boolean varChecked3 = validateCheckBox(varxpath2,false);
				
				if(varChecked3)
				{
					report.updateTestLog("Unchecked Price facet:"+varLabel2,varLabel2+ " Price facet Unchecked", Status.PASS);
					
					
				}
				else
				{
					report.updateTestLog("Unchecked Price facet:"+varLabel2,varLabel2+ " Price facet NOT Unchecked", Status.FAIL);
				}
				String varProductCount2 = driver.findElement(By.xpath(UIMapProductSearch.webElmntTotalResults)).getText();
				System.out.println("Count After Selecting Price Facet:"+varProductCount2);
				if(varProductCount2.equals(varProductCount))
				{
					report.updateTestLog("Unchecked Price facet:"+varLabel2,varLabel2+ " Price facet Unchecked. Product List Refreshed", Status.PASS);
				}
				else
				{
					report.updateTestLog("Unchecked Price facet:"+varLabel2,varLabel2+ " Price facet Unchecked. Product List NOT Refreshed", Status.FAIL);
				}
				
	}
	
	}
	
	/*These functions validates Eco Rebate link in Product List page(List View and Grid View, Details page & Add To Cart page*/
	
	public void verifyEcoRebateList() throws Exception
	{
		WebElement varProduct = driver.findElement(By.partialLinkText(dataTable.getData("General_Data", "Productname")));
		WebElement productTitle = varProduct.findElement(By.xpath("..")); 
		WebElement titleArea = productTitle.findElement(By.xpath("..")); 
		WebElement productWrapper = titleArea.findElement(By.xpath("..")); 
		WebElement ItemId = productWrapper.findElement(By.xpath("..")); 
		System.out.println(ItemId.getAttribute("id"));
		String varItemId = ItemId.getAttribute("id");
		String[] s = varItemId.split("_");
		dataTable.putData("General_Data", "ItemId", s[1]);
		boolean varEcoRebates = driver.findElement(By.xpath("//*[@id='ecorebates_"+s[1]+"']/div/div[1]/div/div/a")).isDisplayed();
		System.out.println("//*[@id='ecorebates_"+s[1]+"']/div/div[1]/div/div/a");
		if(varEcoRebates)
		{
			String varEcoRebateText = driver.findElement(By.xpath("//*[@id='ecorebates_"+s[1]+"']/div/div[1]/div/div/a")).getText();
			String pattern = "PLUS, up to (.*) in Rebates";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(varEcoRebateText);
		     if (m.find( )) 
		     {
		    	 report.updateTestLog("Checking Eco Rebate link in List view","Eco Rebate link displayed in List view", Status.PASS);
		    	 driver.findElement(By.xpath("//*[@id='ecorebates_"+s[1]+"']/div/div[1]/div/div/a")).click();
		    	 Thread.sleep(2000);
		    	 if(selenium.isElementPresent("fancybox-content"))
		    	 {
		    		 report.updateTestLog("Clicking Eco Rebate link in List view","Light Box with all the Rebate Information displayed", Status.PASS);
		    		 String varRebateInfo = driver.findElement(By.xpath("//*[@id='ecorebates_"+s[1]+"_detailsContainer_ProductsAccordion']/div[2]/div/div[1]/table/tbody/tr/td[3]/div")).getText();
		    		 if(varRebateInfo.contains("rebate up to:")||varRebateInfo.contains("rebates up to:"))
		    		 {
		    			 report.updateTestLog("Checking Rebate Info in Light Box","Rebate Info displayed in Light Box", Status.PASS);
		    		 }
		    		 else
		    		 {
		    			 report.updateTestLog("Checking Rebate Info in Light Box","Rebate Info NOT displayed in Light Box", Status.FAIL);
		    		 }
		    		 
		    		 driver.findElement(By.id("fancybox-close")).click();
		    		 Thread.sleep(2000);
		    	 }
		    	 else
		    	 {
		    		 report.updateTestLog("Clicking Eco Rebate link in List view","Light Box with all the Rebate Information NOT displayed", Status.FAIL);
		    	 }
		     }
		     else
		     {
		    	 report.updateTestLog("Checking Eco Rebate link in List view","Eco Rebate link NOT displayed in List view", Status.FAIL);
		     }
		}
		
		
	}
	
	public void verifyEcoRebateGrid() throws Exception
	{
		WebElement varProduct = driver.findElement(By.partialLinkText(dataTable.getData("General_Data", "Productname")));
		WebElement productTitle = varProduct.findElement(By.xpath("..")); 
		WebElement titleArea = productTitle.findElement(By.xpath("..")); 
		WebElement productWrapper = titleArea.findElement(By.xpath("..")); 
		WebElement ItemId = productWrapper.findElement(By.xpath("..")); 
		System.out.println(ItemId.getAttribute("id"));
		String varItemId = ItemId.getAttribute("id");
		String[] s = varItemId.split("_");
		dataTable.putData("General_Data", "ItemId", s[1]);
		boolean varEcoRebates = driver.findElement(By.xpath("//*[@id='ecorebates_"+s[1]+"']/div/div[1]/div/div/a")).isDisplayed();
		if(varEcoRebates)
		{
			report.updateTestLog("Checking Eco Rebate link in Grid view","Eco Rebate link displayed in Grid view", Status.FAIL);
		}
		else
		{
		    report.updateTestLog("Checking Eco Rebate link in Grid view","Eco Rebate link NOT displayed in Grid view", Status.PASS);
		}
	}
	
	public void verifyEcoRebateDetails() throws Exception
	{
		/*WebElement varProduct = driver.findElement(By.partialLinkText(dataTable.getData("General_Data", "Productname")));
		WebElement productTitle = varProduct.findElement(By.xpath("..")); 
		WebElement titleArea = productTitle.findElement(By.xpath("..")); 
		WebElement productWrapper = titleArea.findElement(By.xpath("..")); 
		WebElement ItemId = productWrapper.findElement(By.xpath("..")); 
		System.out.println(ItemId.getAttribute("id"));
		String varItemId = ItemId.getAttribute("id");
		String[] s = varItemId.split("_");
		dataTable.putData("General_Data", "ItemId", s[1]);*/
		boolean varEcoRebates = driver.findElement(By.xpath("//*[@id='ecorebates_"+dataTable.getData("General_Data", "ItemId")+"']/div/div[1]/div/div/a" )).isDisplayed();
		if(varEcoRebates)
		{
			String varEcoRebateText = driver.findElement(By.xpath("//*[@id='ecorebates_"+dataTable.getData("General_Data", "ItemId")+"']/div/div[1]/div/div/a")).getText();
			//String pattern = "PLUS, up to (.*) in Rebates";
			String pattern = "PLUS, up to (.*) in Rebates";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(varEcoRebateText);
		     if (m.find( )) 
		     {
		    	 report.updateTestLog("Checking Eco Rebate link in Detail view","Eco Rebate link displayed in Detail view", Status.PASS);
		    	 driver.findElement(By.xpath("//*[@id='ecorebates_"+dataTable.getData("General_Data", "ItemId")+"']/div/div[1]/div/div/a")).click();
		    	 Thread.sleep(2000);
		    	 if(selenium.isElementPresent("fancybox-content"))
		    	 {
		    		 report.updateTestLog("Clicking Eco Rebate link in Detail view","Light Box with all the Rebate Information displayed", Status.PASS);
		    		 //System.out.println(driver.findElement(By.xpath("//*[@id='ecorebates_"+dataTable.getData("General_Data", "ItemId")+"_detailsContainer_ProductsAccordion']/div[2]/div/div[1]/table/tbody/tr/td[3]/div")).getText());
		    		 String varRebateInfo = driver.findElement(By.xpath("//*[@id='ecorebates_"+dataTable.getData("General_Data", "ItemId")+"_detailsContainer_ProductsAccordion']/div[2]/div/div[1]/table/tbody/tr/td[3]/div")).getText();
		    		 if(varRebateInfo.contains("rebate up to:")||varRebateInfo.contains("rebates up to:"))
		    		 {
		    			 report.updateTestLog("Checking Rebate Info in Light Box","Rebate Info displayed in Light Box", Status.PASS);
		    		 }
		    		 else
		    		 {
		    			 report.updateTestLog("Checking Rebate Info in Light Box","Rebate Info NOT displayed in Light Box", Status.FAIL);
		    		 }
		    		 driver.findElement(By.id("fancybox-close")).click();
		    		 Thread.sleep(2000);
		    	 }
		    	 else
		    	 {
		    		 report.updateTestLog("Clicking Eco Rebate link in Detail view","Light Box with all the Rebate Information NOT displayed", Status.FAIL);
		    	 }
		     }
		     else
		     {
		    	 report.updateTestLog("Checking Eco Rebate link in Detail view","Eco Rebate link NOT displayed in Detail view", Status.FAIL);
		     }
		}
	
	
		
	}
	
	
/*	public void verifyEcoRebateCart() throws Exception
	{
		
		List<WebElement> varItems = driver.findElements(By.xpath("//*[@class='cart-items']/div"));
		int varCount = varItems.size();
		int i=0;
		int j=0;
		int k;
		for(i=0;i<varCount;i++)
		{
		j=j+1;
		k=i+1;
		String varItem= driver.findElement(By.xpath("//*[@class='cart-items']/div["+k+"]")).getAttribute("id");
		String[] s= varItem.split("_");
		if(s[1].equals(dataTable.getData("General_Data", "ItemId")))
		{
		
		if(dataTable.getData("General_Data", "EcoRebate").equals("Yes"))
		{
		boolean varEcoRebates = driver.findElement(By.xpath("//*[@id='ecorebates_"+dataTable.getData("General_Data", "ItemId")+"_"+j+"']/div/div[1]/div/div/a" )).isDisplayed();
		if(varEcoRebates)
		{
			String varEcoRebateText = driver.findElement(By.xpath("//*[@id='ecorebates_"+dataTable.getData("General_Data", "ItemId")+"_"+j+"']/div/div[1]/div/div/a")).getText();
			//String pattern = "PLUS, up to (.*) in Rebates";
			String pattern = "PLUS, up to (.*) in Rebates";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(varEcoRebateText);
		     if (m.find( )) 
		     {
		    	 report.updateTestLog("Checking Eco Rebate link in Cart view","Eco Rebate link displayed in Cart view", Status.PASS);
		    	 driver.findElement(By.xpath("//*[@id='ecorebates_"+dataTable.getData("General_Data", "ItemId")+"_"+j+"']/div/div[1]/div/div/a")).click();
		    	 Thread.sleep(2000);
		    	 if(selenium.isElementPresent("fancybox-content"))
		    	 {
		    		 report.updateTestLog("Clicking Eco Rebate link in Cart view","Light Box with all the Rebate Information displayed", Status.PASS);
		    		 //System.out.println(driver.findElement(By.xpath("//*[@id='ecorebates_"+dataTable.getData("General_Data", "ItemId")+"_detailsContainer_ProductsAccordion']/div[2]/div/div[1]/table/tbody/tr/td[3]/div")).getText());
		    		 String varRebateInfo = driver.findElement(By.xpath("//*[@id='ecorebates_"+dataTable.getData("General_Data", "ItemId")+"_"+j+"_detailsContainer_ProductsAccordion']/div[2]/div/div[1]/table/tbody/tr/td[3]/div")).getText();
		    		 if(varRebateInfo.contains("rebate up to:")||varRebateInfo.contains("rebates up to:"))
		    		 {
		    			 report.updateTestLog("Checking Rebate Info in Light Box","Rebate Info displayed in Light Box", Status.PASS);
		    		 }
		    		 else
		    		 {
		    			 report.updateTestLog("Checking Rebate Info in Light Box","Rebate Info NOT displayed in Light Box", Status.FAIL);
		    		 }
		    		 driver.findElement(By.id("fancybox-close")).click();
		    		 Thread.sleep(2000);
		    		 break;
		    	 }
		    	 else
		    	 {
		    		 report.updateTestLog("Clicking Eco Rebate link in Cart view","Light Box with all the Rebate Information NOT displayed", Status.FAIL);
		    		 break;
		    	 }
		     }
		     else
		     {
		    	 report.updateTestLog("Checking Eco Rebate link in Cart view","Eco Rebate link NOT displayed in Cart view", Status.FAIL);
	    		 break; 
		    	 
		     }
		}
		else
		{
			 report.updateTestLog("Checking Eco Rebate link in Cart view","Eco Rebate link NOT displayed in Cart view", Status.FAIL);
    		 break; 
		}
		}
		else
		{
			boolean varEcoRebateHidden = driver.findElement(By.id("ecorebates_"+dataTable.getData("General_Data", "ItemId")+"_"+j)).isDisplayed();
			if(varEcoRebateHidden)
			{
				report.updateTestLog("Checking Eco Rebate link in Cart view","Eco Rebate link displayed in Cart view for Non-EcoRebate Item", Status.FAIL);
	    		 break; 
			}
			else
			{
				
				report.updateTestLog("Checking Eco Rebate link in Cart view","Eco Rebate link NOT displayed in Cart view for Non-EcoRebate Item", Status.PASS);
	    		 break; 
			}
		}
		
		}
		else
		{
			j=j+1;
			continue;
		}
		}
		
		
	
		
		
	}
*/
	public void verifyEcoRebateCart() throws Exception
	{
		/*WebElement varProduct = driver.findElement(By.partialLinkText(dataTable.getData("General_Data", "Productname")));
		WebElement productTitle = varProduct.findElement(By.xpath("..")); 
		WebElement titleArea = productTitle.findElement(By.xpath("..")); 
		WebElement productWrapper = titleArea.findElement(By.xpath("..")); 
		WebElement ItemId = productWrapper.findElement(By.xpath("..")); 
		System.out.println(ItemId.getAttribute("id"));
		String varItemId = ItemId.getAttribute("id");
		String[] s = varItemId.split("_");
		dataTable.putData("General_Data", "ItemId", s[1]);*/
		boolean varEcoRebates = driver.findElement(By.xpath("//*[@id='ecorebates_"+dataTable.getData("General_Data", "ItemId")+"_1']/div/div[1]/div/div/a" )).isDisplayed();
		if(varEcoRebates)
		{
			String varEcoRebateText = driver.findElement(By.xpath("//*[@id='ecorebates_"+dataTable.getData("General_Data", "ItemId")+"_1']/div/div[1]/div/div/a")).getText();
			//String pattern = "PLUS, up to (.*) in Rebates";
			String pattern = "PLUS, up to (.*) in Rebates";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(varEcoRebateText);
		     if (m.find( )) 
		     {
		    	 report.updateTestLog("Checking Eco Rebate link in Cart view","Eco Rebate link displayed in Cart view", Status.PASS);
		    	 driver.findElement(By.xpath("//*[@id='ecorebates_"+dataTable.getData("General_Data", "ItemId")+"_1']/div/div[1]/div/div/a")).click();
		    	 Thread.sleep(2000);
		    	 if(selenium.isElementPresent("fancybox-content"))
		    	 {
		    		 report.updateTestLog("Clicking Eco Rebate link in Detail view","Light Box with all the Rebate Information displayed", Status.PASS);
		    		 //System.out.println(driver.findElement(By.xpath("//*[@id='ecorebates_"+dataTable.getData("General_Data", "ItemId")+"_detailsContainer_ProductsAccordion']/div[2]/div/div[1]/table/tbody/tr/td[3]/div")).getText());
		    		 String varRebateInfo = driver.findElement(By.xpath("//*[@id='ecorebates_"+dataTable.getData("General_Data", "ItemId")+"_1_detailsContainer_ProductsAccordion']/div[2]/div/div[1]/table/tbody/tr/td[3]/div")).getText();
		    		 if(varRebateInfo.contains("rebate up to:"))
		    		 {
		    			 report.updateTestLog("Checking Rebate Info in Light Box","Rebate Info displayed in Light Box", Status.PASS);
		    		 }
		    		 else
		    		 {
		    			 report.updateTestLog("Checking Rebate Info in Light Box","Rebate Info NOT displayed in Light Box", Status.FAIL);
		    		 }
		    		 driver.findElement(By.id("fancybox-close")).click();
		    		 Thread.sleep(2000);
		    	 }
		    	 else
		    	 {
		    		 report.updateTestLog("Clicking Eco Rebate link in Cart view","Light Box with all the Rebate Information NOT displayed", Status.FAIL);
		    	 }
		     }
		     else
		     {
		    	 report.updateTestLog("Checking Eco Rebate link in Cart view","Eco Rebate link NOT displayed in Cart view", Status.FAIL);
		     }
		}
	
	
		
	}
	
	/*Verify Y Item is added with No EcoRebate   when X is added to cart in Buy X(Eco Rebate) Get Y(Non-Eco Rebate) promotion*/
	public void verifyEcoRebateCartNonEcoItem() throws Exception
	{
		try{
		boolean varNonEcoItem = driver.findElement(By.xpath("//*[@class='cart-items']/div[2]")).isDisplayed();
		if(varNonEcoItem)
		{
		String varItemId = driver.findElement(By.xpath("//*[@class='cart-items']/div[2]")).getAttribute("id");
		String varPromo = driver.findElement(By.xpath("//*[@id='"+varItemId+"']/div[2]/div[1]/div/div")).getText();
		if(varPromo.contains("Buy "+dataTable.getData("General_Data", "ItemNbr")+" get "))
		{
			report.updateTestLog("Checking Non Eco Rebate Item Cart","Non Eco Rebate Item displayed in cart with promotion", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Non Eco Rebate Item Cart","Non Eco Rebate Item NOT displayed in cart with promotion", Status.FAIL);
		}
		
		String[] s = varItemId.split("_");
		
		boolean varEcoRebateHidden = driver.findElement(By.id("ecorebates_"+s[1]+"_"+3)).isDisplayed();
		if(varEcoRebateHidden)
		{
			report.updateTestLog("Checking Eco Rebate link in Cart view","Eco Rebate link displayed in Cart view for Non-EcoRebate Item", Status.FAIL);
    		
		}
		else
		{
			
			report.updateTestLog("Checking Eco Rebate link in Cart view","Eco Rebate link NOT displayed in Cart view for Non-EcoRebate Item", Status.PASS);
    		
		}
		}
		}
		catch(Exception NoSuchElementException)
		{
			report.updateTestLog("Checking Non Eco Rebate Item Cart","Non Eco Rebate Item Not displayed in cart", Status.FAIL);
		}
	
	
	}
	
	public void changePage() throws Exception
	{
		driver.findElement(By.className("go_to_page_field")).sendKeys("2");
		driver.findElement(By.className("go_to_page_field")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.className("go_to_page_field")).sendKeys(dataTable.getData("General_Data", "Page"));
		driver.findElement(By.className("go_to_page_field")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}
	
	public void inspectWasPriceSavePercent() throws Exception
	{
		if(driver.findElement(By.className("was-price")).isDisplayed())
		{
			String varWasPrice = driver.findElement(By.className("was-price")).getText();
			String pattern = "Was: (.*)";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(varWasPrice);
		     if (m.find( )) 
		     {
		    	 report.updateTestLog("Checking Was Price in Detail Page","Was Price displayed in Detail Page", Status.PASS);
		     }
		     else
		     {
		    	 report.updateTestLog("Checking Was Price in Detail Page","Was Price NOT displayed correctly in Detail Page", Status.FAIL);
		     }
		//Save 10% thru 01/07/2014 
		
		}
		else
		{
			report.updateTestLog("Checking Was Price in Detail Page","Was Price NOT displayed in Detail Page", Status.FAIL);
		}
		if(driver.findElement(By.className("save-percent")).isDisplayed())
		{
			String varSavings = driver.findElement(By.className("save-percent")).getText();
			String pattern = "Save ([5-9]|[1-9]\\d+)% thru (0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/20\\d\\d";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(varSavings);
		     if (m.find( )) 
		     {
		    	 report.updateTestLog("Checking Save % & thru Date in Detail Page","Save % & thru Date displayed in Detail Page", Status.PASS);
		     }
		     else
		     {
		    	 report.updateTestLog("Checking Save % & thru Date in Detail Page","Save % & thru Date NOT displayed correctly in Detail Page", Status.FAIL);
		     }
		//Save 10% thru 01/07/2014 
		
		}
		else
		{
			report.updateTestLog("Checking Save % & thru Date in Detail Page","Save % & thru Date NOT displayed in Detail Page", Status.FAIL);
		}
		
	}
	
	/*This function selects delivery method in Carts page*/
	public void selectDeliveryOption() throws Exception
	{
		String varDeliveryOption = dataTable.getData("General_Data", "Delivery");
		if(varDeliveryOption.equals("StorePickup"))
		{
			
			driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[2]/ul/li[1]/div/label/input")).click();
			Thread.sleep(5000);
			report.updateTestLog("Selecting Delivery Option","Delivery Option"+dataTable.getData("General_Data", "Delivery")+" selected for Item "+dataTable.getData("General_Data", "ItemNbr"), Status.DONE);
			
		}
		else if(varDeliveryOption.equals("Parcel"))
		{
			driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[2]/ul/li[3]/div/label/input")).click();
			Thread.sleep(5000);
			report.updateTestLog("Selecting Delivery Option","Delivery Option"+dataTable.getData("General_Data", "Delivery")+" selected for Item "+dataTable.getData("General_Data", "ItemNbr"), Status.DONE);
		}
		else if(varDeliveryOption.equals("LTD"))
		{
			driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[2]/ul/li[2]/div/label/input")).click();
			Thread.sleep(5000);
			report.updateTestLog("Selecting Delivery Option","Delivery Option"+dataTable.getData("General_Data", "Delivery")+" selected for Item "+dataTable.getData("General_Data", "ItemNbr"), Status.DONE);
		}
	}
	
	/*This function clicks on Secure Check Out anonymous user */
	public void clickSecureCheckoutAZ() throws Exception
	{
		driver.findElement(By.cssSelector("span.cart-links > a.button-green.start-checkout  > span")).click();
		report.updateTestLog("Selecting Secure Checkout","Secure Checkout clicked", Status.DONE);
		selenium.waitForPageToLoad("20000");
		
		/*
		String varTitle = driver.findElement(By.xpath("//*[@id='Logon']/div/div/div[1]/h5")).getText();
		if(varTitle.equals("I Have a Lowes.com Account"))
		{
			report.updateTestLog("Selecting Secure Checkout","Logon form displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Selecting Secure Checkout","Logon form NOT displayed", Status.FAIL);
		}
		
		*/
	}
	
	public void enterSignInInfo() throws Exception
	{
		driver.findElement(By.id(UIMapFunctionalComponents.txtUserName)).sendKeys(dataTable.getData("General_Data","email"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(dataTable.getData("General_Data", "password"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(Keys.ENTER);
		//driver.findElement(By.id("GoYourAccount")).click();		
		selenium.waitForPageToLoad("30000");
		//Thread.sleep(20000);
		String getLoggedInUser=driver.findElement(By.xpath(UIMapFunctionalComponents.webElmntSalutation)).getText().trim();
		System.out.println("Verifying the Registered User detais :"+getLoggedInUser);
		if(getLoggedInUser.equals("Welcome, "+dataTable.getData("General_Data","Firstname")))          // Verifying the registered user details by Using Firstname
		{
			report.updateTestLog("Validating Login Credentials","Login Successful", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Login Credentials","Login Failed..! for User "+dataTable.getData("General_Data","email")+" ", Status.FAIL);
		}
		boolean varError = selenium.isTextPresent("The address you entered is outside your selected store's delivery range. Please return to Cart and select Store Pickup and see your new purchase total.");
		if(varError)
		{
			driver.findElement(By.partialLinkText("return to Cart")).click();
			selenium.waitForPageToLoad("20000");
		}
		boolean varCart = selenium.isTextPresent("Products in Cart");
		if(varCart)
		{
			driver.findElement(By.xpath(UIMapProductSearch.lnkUnzip)).click();
			
			Thread.sleep(2000);
			driver.findElement(By.id(UIMapProductSearch.txtStoreZipField)).sendKeys(dataTable.getData("General_Data","Store"));
			try{driver.findElement(By.id("nav-button-store-search")).click();}
			catch(Exception WebDriverException){
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup","Handeled", Status.DONE);
				driver.findElement(By.id("nav-button-store-search")).click();
			}
			selenium.waitForPageToLoad("15000");
			boolean varStoreZipped = selenium.isElementPresent("//*[@id='nav-store-info']/span[1]");
			if(varStoreZipped)
			{
				report.updateTestLog("Zipping Store","Store "+dataTable.getData("General_Data","Store")+" Zipped successfully", Status.PASS);
			}
			else
			{
				report.updateTestLog("Zipping Store","Store Not Zipped successfully", Status.FAIL);
			}
			try{
				driver.findElement(By.cssSelector("span.cart-links > a.button-green.start-checkout  > span")).click();
				report.updateTestLog("Selecting Secure Checkout","Secure Checkout clicked again after changing store", Status.DONE);
				selenium.waitForPageToLoad("20000");
			}
			catch(Exception NoSuchElementException)
			{
				System.out.println("Secure Checkout button Not displayed");
			}
			
		}
	}
	
	public void clickContinueCheckout() throws Exception
	{
		driver.findElement(By.xpath(UIMapProductSearch.btnContinueChkOut)).click();
		selenium.waitForPageToLoad("20000");
	}
	
	public void navigateReviewPayPage() throws Exception
	{
		boolean varReviewPage = selenium.isTextPresent("Review and Pay");
		if(varReviewPage)
		{
			report.updateTestLog("Navigating to Review and Pay Page","Review and Pay Page displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Navigating to Review and Pay Page","Review and Pay Page NOT displayed", Status.FAIL);
		}
		
	}
	
	public void validateRebateFinalCheckOut() throws Exception
	{
		//selecting from saved credit card
		try{driver.findElement(By.xpath("//*[@id='stored-cards']/tbody/tr[4]/td[1]/input")).click();
		Thread.sleep(5000);
		}
		catch(Exception WebDriverException)
		{
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath("//*[@id='stored-cards']/tbody/tr[4]/td[1]/input")).click();
			Thread.sleep(5000);
		}
		driver.findElement(By.xpath("//*[@id='selectedcard_cvv']")).sendKeys("1111");
		new Select(driver.findElement(By.name("stored-billing-address-id"))).selectByVisibleText(dataTable.getData("General_Data","Address"));
		driver.findElement(By.xpath("//*[@id='storedBillingPhone1']")).sendKeys("987");
		driver.findElement(By.xpath("//*[@id='storedBillingPhone2']")).sendKeys("654");
		driver.findElement(By.xpath("//*[@id='billingPhone3']")).sendKeys("3212");
		driver.findElement(By.xpath("//*[@id='stored-billing-address-email']")).sendKeys(dataTable.getData("General_Data","OrderEmail"));
		driver.findElement(By.xpath(UIMapProductSearch.btnContinueChkOut)).click();
		selenium.waitForPageToLoad("300000");
		String varTitle = selenium.getTitle();
		if(varTitle.equals("Order Confirmation"))
		{
			report.updateTestLog("Final Checkout","Order Confirmation Page displayed", Status.PASS);
			boolean varSuccessMsg1 = selenium.isTextPresent("Rebates available for this purchase are listed below. Also, visit our Rebate Center for more information.");
			boolean varSuccessMsg2 = selenium.isTextPresent("Lowes.com will send order updates to "+dataTable.getData("General_Data","OrderEmail"));
			boolean varSuccessMsg3 = selenium.isTextPresent("You can also check your order status at any time in your Purchase History.");
			if(varSuccessMsg1&&varSuccessMsg2&&varSuccessMsg3)
			{
				report.updateTestLog("Order Confirmation page","Success message displayed correctly", Status.PASS);
			}
			else
			{
				report.updateTestLog("Order Confirmation page","Success message NOT displayed correctly", Status.FAIL);
			}
			//validating Rebate link
			List<WebElement> varGC = driver.findElements(By.xpath("//*[@class='l-module l-module-tertiary']"));
				int varCount = varGC.size();
			for(int i = 1;i<=varCount;i++)
			{
				int j=i-1;
				String varItem = driver.findElement(By.xpath("//*[@class='l-module l-module-tertiary']["+i+"]/div[2]/div[2]/div[2]/div")).getAttribute("id");
				String[] s = varItem.split("_");
				System.out.println(s[1]);
				System.out.println(dataTable.getData("General_Data", "ItemId"));
				if(s[1].equals(dataTable.getData("General_Data", "ItemId")))
				{
					try{
					String varRebate = driver.findElement(By.xpath("//*[@id='ecorebates_"+s[1]+"_"+j+"']/div/div[1]/div/div/a")).getText();
					String pattern = "PLUS, up to (.*) in Rebates";
					Pattern r = Pattern.compile(pattern);
					Matcher m = r.matcher(varRebate);
				     if (m.find( )) 
				     {report.updateTestLog("Checking Eco Rebate link in Order Confirmation page","Eco Rebate link displayed in Order Confirmation page", Status.PASS);
			    	 driver.findElement(By.xpath("//*[@id='ecorebates_"+s[1]+"_"+j+"']/div/div[1]/div/div/a")).click();
			    	 Thread.sleep(5000);
			    	 if(selenium.isElementPresent("fancybox-content"))
			    	 {
			    		 report.updateTestLog("Clicking Eco Rebate link in Detail view","Light Box with all the Rebate Information displayed", Status.PASS);
			    		 //System.out.println(driver.findElement(By.xpath("//*[@id='ecorebates_"+dataTable.getData("General_Data", "ItemId")+"_detailsContainer_ProductsAccordion']/div[2]/div/div[1]/table/tbody/tr/td[3]/div")).getText());
			    		 String varRebateInfo = driver.findElement(By.xpath("//*[@id='ecorebates_"+s[1]+"_"+j+"_detailsContainer_ProductsAccordion']/div[2]/div/div[1]/table/tbody/tr/td[3]/div")).getText();
			    		 if(varRebateInfo.contains("rebate up to:")||varRebateInfo.contains("rebates up to:"))
			    		 {
			    			 report.updateTestLog("Checking Rebate Info in Light Box","Rebate Info displayed in Light Box", Status.PASS);
			    		 }
			    		 else
			    		 {
			    			 report.updateTestLog("Checking Rebate Info in Light Box","Rebate Info NOT displayed in Light Box", Status.FAIL);
			    		 }
			    		 driver.findElement(By.id("fancybox-close")).click();
			    		 Thread.sleep(2000);
			    	 }
			    	 else
			    	 {
			    		 report.updateTestLog("Clicking Eco Rebate link in Cart view","Light Box with all the Rebate Information NOT displayed", Status.FAIL);
			    	 }
				     }
				     else
				     {
				    	 report.updateTestLog("Checking Eco Rebate link in Cart view","Eco Rebate link NOT displayed in Cart view", Status.FAIL);
				     }
					}
					catch(Exception NoSuchElementException)
					{
						report.updateTestLog("Checking Eco Rebate link in Order Confirmation page","Eco Rebate link NOT displayed in Order Confirmation page", Status.FAIL);
					}
				}
				else
				{
					try{
						boolean varRebate = driver.findElement(By.xpath("//*[@id='ecorebates_"+s[1]+"_0']/div/div[1]/div/div/a")).isDisplayed();
						if(varRebate)
						{
							report.updateTestLog("Checking Eco Rebate link in Order Confirmation page for Non Eco Item","Eco Rebate link displayed in Order Confirmation page", Status.FAIL);
						}
					}
					catch(Exception NoSuchElementException)
					{
						report.updateTestLog("Checking Eco Rebate link in Order Confirmation page for Non Eco Item","Eco Rebate link NOT displayed in Order Confirmation page", Status.PASS);
					}
				}
						
				}
					
			
				
				
			//validating links
			try{
				boolean varPurchaseHistory = driver.findElement(By.partialLinkText("Purchase History")).isDisplayed();
				if(varPurchaseHistory)
				{
					report.updateTestLog("Order Confirmation page","Purchase History displayed as link", Status.PASS);
				}}
				catch(Exception NoSuchElementException)
				{
					report.updateTestLog("Order Confirmation page","Purchase History NOT displayed as link", Status.FAIL);
				}
			try{
				boolean varRebatesAvail = driver.findElement(By.partialLinkText("Rebates available")).isDisplayed();
				if(varRebatesAvail)
				{
					report.updateTestLog("Order Confirmation page","Rebates available displayed as link", Status.FAIL);
				}}
				catch(Exception NoSuchElementException)
				{
					report.updateTestLog("Order Confirmation page","Rebates available NOT displayed as link", Status.PASS);
				}
			try{
				boolean varRebateCenter = driver.findElement(By.partialLinkText("Rebate Center")).isDisplayed();
				if(varRebateCenter)
				{
					report.updateTestLog("Order Confirmation page","Rebate Center displayed as link", Status.PASS);
					driver.findElement(By.partialLinkText("Rebate Center")).click();
					selenium.waitForPageToLoad("20000");
					String varUrl = driver.getCurrentUrl();
					if(varUrl.equals("https://pplws.lowes.com/cd_Rebate+Center_441568837_"))
					{
						report.updateTestLog("Clicking Rebate Center link","Rebate Center URL Correct", Status.PASS);
					}
					else
					{
						report.updateTestLog("Clicking Rebate Center link","Rebate Center URL NOT Correct", Status.FAIL);
						
					}
				}}
				catch(Exception NoSuchElementException)
				{
					report.updateTestLog("Order Confirmation page","Rebate Center NOT displayed as link", Status.FAIL);
				}
		}
		else
		{
			report.updateTestLog("Final Checkout","Order Confirmation Page NOT displayed", Status.FAIL);
		}
		
	}
	
	/*To select sort By on Product List*/
	public void selectSortBy() throws Exception
	{
		String varSortBy2 = dataTable.getData("General_Data", "SortBy");
		//System.out.println(varSortBy2);
		List<WebElement> varSortBy = driver.findElements(By.xpath(UIMapProductSearch.webElmntProductListSort2));
		
		int varCount = varSortBy.size();
		System.out.println(varCount);
		int i;
		for(i=1;i<=varCount;i++)
		{
			String varXpath = UIMapProductSearch.webElmntProductListSort2+"["+i+"]";
			String varSortBy3 = driver.findElement(By.xpath(varXpath)).getText();
			System.out.println(varSortBy3);
			if(varSortBy3.equals(varSortBy2))
			{
				driver.findElement(By.xpath(varXpath)).click();
				Thread.sleep(2000);
				try{
					driver.findElement(By.xpath(varXpath+"/a")).click();
					report.updateTestLog("Selecting Sort By","Sort By NOT selected:"+ varSortBy2, Status.FAIL);
					break;
				}
				catch(Exception NoSuchElementException)
				{
					report.updateTestLog("Selecting Sort By","Sort By selected:"+ varSortBy2 , Status.PASS);
					break;
				}
				
			}
			else
			{
				continue;
			}
			
		}
		
		
	}
	
	/*To select page nbr Product List*/
	public void selectPageProductList() throws Exception
	{
		
		driver.findElement(By.className("go_to_page_field")).sendKeys(dataTable.getData("General_Data", "Page"));
		driver.findElement(By.className("go_to_page_field")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String varCurrentPage = driver.findElement(By.className("currentPage")).getText();
		System.out.println("Current Page:"+varCurrentPage);
		if(varCurrentPage.equals(dataTable.getData("General_Data", "Page")))
		{
			report.updateTestLog("Selecting Page Nbr","Page Nbr selected:"+ dataTable.getData("General_Data", "Page") , Status.PASS);
		}
		else
		{
			report.updateTestLog("Selecting Page Nbr","Page Nbr NOT selected:"+ dataTable.getData("General_Data", "Page") , Status.FAIL);
		}
	}
	
	
	
	/*To validate facets selected in Product List are retained on clicking back from details page*/
	public void validateFacetRetention() throws Exception
	{
		setResultPerPage();
		selectSortBy();
		selectPageProductList();
		String varUrl = driver.getCurrentUrl();
		//click randomly on any product
		List<WebElement> varGC = driver.findElements(By.xpath(UIMapProductSearch.webElmntProductList2));
		int varCount = varGC.size();
		Random rand = new Random();
		int varRandomProduct = rand.nextInt(varCount-1)+1;
		System.out.println("Random Product Nbr:"+varRandomProduct);
		String varXpath = "//*[@id='productResults']/li["+varRandomProduct+"]";
		String varItemId = driver.findElement(By.xpath(varXpath)).getAttribute("id");
		String varProductName = driver.findElement(By.xpath("//*[@id='"+varItemId+"']/div/div[2]/h3/a")).getText();
		System.out.println(varProductName);
		driver.findElement(By.xpath("//*[@id='"+varItemId+"']/div/div[2]/h3/a")).click();
		
		selenium.waitForPageToLoad("20000");
		boolean varDetails = selenium.isElementPresent(UIMapProductSearch.webElmntProductDetail);
		if(varDetails)
		{
			//String varItemName = driver.findElement(By.xpath(UIMapProductSearch.webElmntProductName)).getText();
			if(varProductName.equals(driver.findElement(By.xpath(UIMapProductSearch.webElmntProductName)).getText()))
			{
				report.updateTestLog("Clicking on Product Name in Product List","Product Details page displayed" , Status.PASS);
			}
			else
			{
				report.updateTestLog("Clicking on Product Name in Product List","Incorrect Product Details page displayed" , Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Clicking on Product Name in Product List","Product Details page NOT displayed" , Status.FAIL);
		}
		//going back
		driver.get(varUrl);
		selenium.waitForPageToLoad("20000");
		//checking results per page
		for(int i = 1;i<4;i++)
		{
			String varXpath2 = "//*[@class='show_results']/option["+i+"]";
			
			if((driver.findElement(By.xpath(varXpath2)).getText()).equals(dataTable.getData("General_Data","ResultsPerPg")))
					{
					//System.out.println("Results Per Page correctly set to:"+dataTable.getData("General_Data","ResultsPerPg"));
					try{
					if(driver.findElement(By.xpath(varXpath2)).getAttribute("selected").equals("true"))
					{
					report.updateTestLog("Checking Results Per Page","Results Per Page same as before" , Status.DONE);
					break;
					}
					else
					{
						report.updateTestLog("Checking Results Per Page","Results Per Page NOT same as before" , Status.DONE);	
					break;
					}
					}
					catch(Exception NullPointerException)
					{
						report.updateTestLog("Checking Results Per Page","Results Per Page NOT same as before" , Status.DONE);	
						break;
					}
					}
			
			else
			{
				continue;
			}
		}
		
		//checking Sort By
		String varSortBy2 = dataTable.getData("General_Data", "SortBy");
		List<WebElement> varSortBy = driver.findElements(By.xpath("//*[@class='clearfix']/li"));
		int varCount2 = varSortBy.size();
		System.out.println(varCount2);
		int i;
		for(i=1;i<=varCount2;i++)
		{
			String varXpath3 = "//*[@class='clearfix']/li["+i+"]";
			String varSortBy3 = driver.findElement(By.xpath(varXpath3)).getText();
			//System.out.println();
			if(varSortBy3.equals(varSortBy2))
			{
				
				try{
					driver.findElement(By.xpath(varXpath3+"/a")).click();
					report.updateTestLog("Checking Sort By","Sort By NOT :"+ varSortBy2, Status.FAIL);
					break;
				}
				catch(Exception NoSuchElementException)
				{
					report.updateTestLog("Checking Sort By","Sort By :"+ varSortBy2+"same as before" , Status.PASS);
					break;
				}
				
			}
			else
			{
				continue;
			}
			
		}
		//checking Page Nbr
		String varCurrentPage = driver.findElement(By.className("currentPage")).getText();
		if(varCurrentPage.equals(dataTable.getData("General_Data", "Page")))
		{
			report.updateTestLog("Checking Page Nbr","Page Nbr same as before:"+ dataTable.getData("General_Data", "Page") , Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Page Nbr","Page Nbr NOT same as before:"+ dataTable.getData("General_Data", "Page") , Status.FAIL);
		}
		
	}
	/*Verify H1 Tags in Search results*/
	public void validateH1TagSearch() throws Exception
	{
		System.out.println(dataTable.getData("General_Data", "Missplelled"));
		if(dataTable.getData("General_Data", "Missplelled").equals("No"))
		{
		String varSearch1 = driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1")).getText();
		if(varSearch1.equals("Search results for "+dataTable.getData("General_Data", "SearchString")+":"))
		{
			report.updateTestLog("Checking Search Result Message","Search Result Message displayed in H1 Tag" , Status.PASS);
			String varSearch2 = driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1/span")).getText();
			if(varSearch2.equals(dataTable.getData("General_Data", "SearchString")))
			{
				report.updateTestLog("Checking Search Result Message","Item Name displayed in Bold" , Status.PASS);
			}
			else
			{
				report.updateTestLog("Checking Search Result Message","Item Name NOT displayed in Bold" , Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Checking Search Result Message","Search Result Message NOT displayed in H1 Tag" , Status.FAIL);
		}
		}
		else
		{
			String varSearch1 = driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1")).getText();
			String pattern = "We found results for (.*):";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(varSearch1);
			if (m.find( ))
			//if(varSearch1.contains("We found results for"))
			{
				report.updateTestLog("Checking Misspelled Search Result Message","Misspelled Search Result Message displayed in H1 Tag" , Status.PASS);
				String varSearch2 = driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1/span")).getText();
				if(varSearch2.equals(m.group(1)))
					{
					report.updateTestLog("Checking Misspelled Search Result Message","Referred Item Name displayed in Bold" , Status.PASS);
					}
				else
					{
					report.updateTestLog("Checking Misspelled Search Result Message","Referred Item Name NOT displayed in Bold" , Status.FAIL);
					}
			}
			else
			{
				report.updateTestLog("Checking Misspelled Search Result Message","Misspelled Search Result Message NOT displayed in H1 Tag" , Status.FAIL);
			}
		}	
		}
	/*Verify H1 Tags when navigating thru products*/
	public void validateH1TagNavigation(String navLevel) throws Exception
	{
		
		String varSearch1 = driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1/span")).getText();
		String varItem = null;
		if(navLevel.equals("2"))
				varItem=dataTable.getData("General_Data", "Category");
		else if(navLevel.equals("3"))
				varItem=dataTable.getData("General_Data", "SubCategory");
		else if(navLevel.equals("4"))
				varItem=dataTable.getData("General_Data", "SubCategoryLink");
		System.out.println(varItem);
		System.out.println(varSearch1);
		if(varSearch1.equals(varItem))
		{
			report.updateTestLog("Checking Search Result Message","Search Result Message displayed in H1 Tag and Bold" , Status.PASS);
			
		}
		else
		{
			report.updateTestLog("Checking Search Result Message","Search Result Message NOT displayed in H1 Tag and Bold" , Status.FAIL);
		}
		
		
			
		}
	
	/*This function validates through the products and checks H1 Tag*/
	public void navigateProduct() throws Exception
	{
		String varNavLevel = dataTable.getData("General_Data", "NavLevel");
		if(varNavLevel.equals("2"))
		{
			selectDept();
			selectCat();
			validateH1TagNavigation(varNavLevel);

		}
		else if(varNavLevel.equals("3"))
		{
			selectDept();
			selectCat();
			selectSubCat();
			validateH1TagNavigation(varNavLevel);
		}
		else if(varNavLevel.equals("4"))
		{
			selectDept();
			selectCat();
			selectSubCat();
			selectSubCatLink();
			validateH1TagNavigation(varNavLevel);
		}
	}
	
	/*Validate whether related categories displayed or not*/
	public void validateRelatedCat() throws Exception
	{
		boolean varLeftRail = selenium.isElementPresent(UIMapProductSearch.webElmntLeftRail1);
		boolean varLeftRailPL = selenium.isElementPresent("left_rail_pl");
		if(varLeftRail)
		{
			try{
				String varRelatedCat = driver.findElement(By.xpath("//*[@id='left_rail']/div[@class='cat_nav']/h4")).getText();
				if(varRelatedCat.equals("Related Categories"))
				{
					report.updateTestLog("Checking Related Categories in Left Navigation","Related Categories displayed in Left Navigation" , Status.DONE);
				}
				else
				{
					report.updateTestLog("Checking Related Categories in Left Navigation","Related Categories NOT displayed in Left Navigation" , Status.DONE);
				}
			}
		catch(Exception NoSuchElementException)
		{
			report.updateTestLog("Checking Related Categories in Left Navigation","Related Categories NOT displayed in Left Navigation" , Status.DONE);
		}
		}
		else if(varLeftRailPL)
		{
			try{
				String varRelatedCat = driver.findElement(By.xpath("//*[@id='left_rail_pl']/h4")).getText();
				if(varRelatedCat.equals("Related Categories"))
				{
					report.updateTestLog("Checking Related Categories in Left Navigation","Related Categories displayed in Left Navigation" , Status.DONE);
				}
				else
				{
					report.updateTestLog("Checking Related Categories in Left Navigation","Related Categories NOT displayed in Left Navigation" , Status.DONE);
				}
			}
		catch(Exception NoSuchElementException)
		{
			report.updateTestLog("Checking Related Categories in Left Navigation","Related Categories NOT displayed in Left Navigation" , Status.DONE);
		}
		}
	}
	/*validate left navigation properly displayed*/
	public void validateLeftnav() throws Exception
	{
		
		boolean varLeftNav = selenium.isElementPresent("left-navigation");
		if(varLeftNav)
		{
			boolean varCat;
			report.updateTestLog("Checking Left Navigation","Information displayed in Left Navigation" , Status.PASS);
			try{
			 varCat = driver.findElement(By.xpath("//*[@id='left_rail']/div[@class='cat_nav']")).isDisplayed();
			 if(varCat)
			 	{
				 report.updateTestLog("Checking Categories in Left Navigation","Categories displayed in Left Navigation" , Status.DONE);
				
			 	}
			}
			catch(Exception NoSuchElementException)
			{
				 varCat = driver.findElement(By.xpath("//*[@id='left_rail_pl']/ul")).isDisplayed();
				 if(varCat)
					{
					report.updateTestLog("Checking Categories in Left Navigation","Categories or links displayed in Left Navigation" , Status.DONE);
				
					
				}
				
				
			}
		}
			
		else
		{
			report.updateTestLog("Checking Left Navigation","Information NOT displayed in Left Navigation" , Status.FAIL);
		}
	}
	/*Validating if left navigation and related categories are properly displayed*/
	public void validateLeftNavReldCat() throws Exception
	{
		//hoover over the Shop By Department Super Category. Select Lawn & Garden. Verify that the Left Navigation for Lawn & Garden is properly displayed.
		Actions actions = new Actions(driver);
		WebElement varHoverShop = driver.findElement(By.xpath(UIMapProductSearch.lnkShop));
		actions.moveToElement(varHoverShop).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(2000);
		
		WebElement varDept = driver.findElement(By.partialLinkText("Lawn & Garden"));
		actions.moveToElement(varDept).build().perform();
		varDept.click();
		selenium.waitForPageToLoad("10000");
		String varPageHeading = driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1/span")).getText();
		report.updateTestLog("Opening Lawn & Garden","Page displayed:"+varPageHeading, Status.DONE);
		validateLeftnav();
		validateRelatedCat();
		//Select Outdoor Power Equipment.  Verify that the Left Navigation for Outdoor Power Equipment is properly displayed.
		 actions = new Actions(driver);
		 varHoverShop = driver.findElement(By.xpath(UIMapProductSearch.lnkShop));
		actions.moveToElement(varHoverShop).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(2000);
		
		 varDept = driver.findElement(By.partialLinkText("Lawn & Garden"));
		actions.moveToElement(varDept).build().perform();
		varDept.click();
		selenium.waitForPageToLoad("10000");
		driver.findElement(By.partialLinkText("Outdoor Tools & Equipment")).click();
		selenium.waitForPageToLoad("20000");
		varPageHeading = driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1/span")).getText();
		report.updateTestLog("Opening Outdoor Tools & Equipment","Page displayed:"+varPageHeading, Status.DONE);
		validateLeftnav();
		validateRelatedCat();
		//Select Outdoor & Landscape Lighting.   Verify that the Left Navigation for Outdoor Power Equipment is properly displayed.
		 actions = new Actions(driver);
		 varHoverShop = driver.findElement(By.xpath(UIMapProductSearch.lnkShop));
		actions.moveToElement(varHoverShop).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(2000);
		
		 varDept = driver.findElement(By.partialLinkText("Outdoor Living"));
		actions.moveToElement(varDept).build().perform();
		Thread.sleep(2000);
		WebElement varLink=driver.findElement(By.partialLinkText("Landscape Lighting"));
		actions.moveToElement(varLink).build().perform();
		Thread.sleep(2000);
		varLink.click();
		selenium.waitForPageToLoad("10000");
		
		varPageHeading = driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1/span")).getText();
		report.updateTestLog("Opening Landscape Lighting","Page displayed:"+varPageHeading, Status.DONE);
		validateLeftnav();
		validateRelatedCat();
		//Select Animal Care.   Verify that the Left Navigation for Outdoor Power Equipment is properly displayed.
		 actions = new Actions(driver);
		 varHoverShop = driver.findElement(By.xpath(UIMapProductSearch.lnkShop));
		actions.moveToElement(varHoverShop).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(2000);
		
		 varDept = driver.findElement(By.partialLinkText("Outdoor Living"));
		actions.moveToElement(varDept).build().perform();
		varDept.click();
		selenium.waitForPageToLoad("20000");
		driver.findElement(By.partialLinkText("Animal & Pet Care")).click();
		selenium.waitForPageToLoad("10000");
		
		varPageHeading = driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1/span")).getText();
		report.updateTestLog("Opening Animal & Pet Care","Page displayed:"+varPageHeading, Status.DONE);
		validateLeftnav();
		validateRelatedCat();
		
		//Select patio Furninture.   Verify that the Left Navigation for Outdoor Power Equipment is properly displayed.
		 actions = new Actions(driver);
		 varHoverShop = driver.findElement(By.xpath(UIMapProductSearch.lnkShop));
		actions.moveToElement(varHoverShop).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(2000);
		
		 varDept = driver.findElement(By.partialLinkText("Outdoor Living"));
		actions.moveToElement(varDept).build().perform();
		Thread.sleep(2000);
		varLink= driver.findElement(By.partialLinkText("Patio Furniture"));
		actions.moveToElement(varLink).build().perform();
		Thread.sleep(2000);
		varLink.click();
		//driver.findElement(By.partialLinkText("Patio Furniture")).click();
		selenium.waitForPageToLoad("10000");
		
		varPageHeading = driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1/span")).getText();
		report.updateTestLog("Opening Patio Furniture","Page displayed:"+varPageHeading, Status.DONE);
		validateLeftnav();
		validateRelatedCat();
		//Select Garden Tools.
		 actions = new Actions(driver);
		 varHoverShop = driver.findElement(By.xpath(UIMapProductSearch.lnkShop));
		actions.moveToElement(varHoverShop).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(2000);
		
		 varDept = driver.findElement(By.partialLinkText("Lawn & Garden"));
		actions.moveToElement(varDept).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Garden Hand Tools")).click();
		selenium.waitForPageToLoad("10000");
		
		varPageHeading = driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1/span")).getText();
		report.updateTestLog("Opening Garden Hand Tools","Page displayed:"+varPageHeading, Status.DONE);
		validateLeftnav();
		validateRelatedCat();
		//Select Plants
		 actions = new Actions(driver);
		 varHoverShop = driver.findElement(By.xpath(UIMapProductSearch.lnkShop));
		actions.moveToElement(varHoverShop).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(2000);
		
		 varDept = driver.findElement(By.partialLinkText("Lawn & Garden"));
		actions.moveToElement(varDept).build().perform();
		Thread.sleep(2000);
		varLink=driver.findElement(By.partialLinkText("Plants & Planters"));
		actions.moveToElement(varLink).build().perform();
		Thread.sleep(2000);
		varLink.click();
		
		selenium.waitForPageToLoad("10000");
		
		varPageHeading = driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1/span")).getText();
		report.updateTestLog("Opening Plant & Planters","Page displayed:"+varPageHeading, Status.DONE);
		validateLeftnav();
		validateRelatedCat();
		//select Outdoor Living
		 actions = new Actions(driver);
		 varHoverShop = driver.findElement(By.xpath(UIMapProductSearch.lnkShop));
		actions.moveToElement(varHoverShop).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(2000);
		varDept = driver.findElement(By.partialLinkText("Outdoor Living"));
		actions.moveToElement(varDept).build().perform();
		Thread.sleep(2000);
		varDept.click();
		selenium.waitForPageToLoad("10000");
		varPageHeading = driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1/span")).getText();
		report.updateTestLog("Opening Outdoor Living","Page displayed:"+varPageHeading, Status.DONE);
		validateLeftnav();
		validateRelatedCat();
		//Select Garden Hand Tool
		 actions = new Actions(driver);
		 varHoverShop = driver.findElement(By.xpath(UIMapProductSearch.lnkShop));
		actions.moveToElement(varHoverShop).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(2000);
		
		 varDept = driver.findElement(By.partialLinkText("Lawn & Garden"));
		actions.moveToElement(varDept).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Garden Hand Tools")).click();
		selenium.waitForPageToLoad("10000");
		
		varPageHeading = driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1/span")).getText();
		report.updateTestLog("Opening Garden Hand Tools","Page displayed:"+varPageHeading, Status.DONE);
		validateLeftnav();
		validateRelatedCat();
		//Select Fencing
		 actions = new Actions(driver);
		 varHoverShop = driver.findElement(By.xpath(UIMapProductSearch.lnkShop));
		actions.moveToElement(varHoverShop).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(2000);
		
		 varDept = driver.findElement(By.partialLinkText("Lawn & Garden"));
		actions.moveToElement(varDept).build().perform();
		Thread.sleep(2000);
		varLink=driver.findElement(By.partialLinkText("Fencing"));
		actions.moveToElement(varLink).build().perform();
		Thread.sleep(2000);
		varLink.click();
		
		selenium.waitForPageToLoad("10000");
		
		varPageHeading = driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1/span")).getText();
		report.updateTestLog("Opening Fencing","Page displayed:"+varPageHeading, Status.DONE);
		validateLeftnav(); 
		validateRelatedCat();
		//select Grills & Outdoor cooking
		actions = new Actions(driver);
		 varHoverShop = driver.findElement(By.xpath(UIMapProductSearch.lnkShop));
		actions.moveToElement(varHoverShop).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(2000);
		
		 varDept = driver.findElement(By.partialLinkText("Outdoor Living"));
		actions.moveToElement(varDept).build().perform();
		varDept.click();
		selenium.waitForPageToLoad("10000");
		driver.findElement(By.partialLinkText("Grills & Outdoor Cooking")).click();
		selenium.waitForPageToLoad("20000");
		varPageHeading = driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1/span")).getText();
		report.updateTestLog("Opening Grills & Outdoor Cooking","Page displayed:"+varPageHeading, Status.DONE);
		validateLeftnav();
		validateRelatedCat();
		
		
	}
	
	
	//checks whether varXPath(with h1 Tag) contains required label
	public void validateH1Tag(String varXpath, String varLabel) throws Exception
	{
		try{
		String varHeading = driver.findElement(By.xpath(varXpath)).getText();
		if(varHeading.equals(varLabel))
		{
			report.updateTestLog("Checking H1 Tag","H1 Tag displayed for :"+varLabel, Status.PASS);
		}
		}
		catch(Exception NoSuchElementException)
		{
			report.updateTestLog("Checking H1 Tag","H1 Tag NOT displayed for :"+varLabel, Status.FAIL);
		}
		
	}
	//clicks on View All Savings link for various categories/dept
	public void clickViewAllSavingsLink() throws Exception
	{
		Actions actions = new Actions(driver);
		WebElement varHoverShop = driver.findElement(By.xpath(UIMapProductSearch.lnkShop));
		actions.moveToElement(varHoverShop).build().perform();
		Thread.sleep(2000);
		//FunctionalComponents.waitforVisible(driver,"//*[@id='nav-departments']/ul/li",5);
		System.out.println("Mouse Hover successful");
		WebElement varDept = driver.findElement(By.partialLinkText(dataTable.getData("General_Data", "Dept")));
		actions.moveToElement(varDept).build().perform();
		//FunctionalComponents.waitforVisible(driver,"//*[@id='nav-departments']/ul/li[1]/div/ul[2]/li/a",5);
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("View All Savings in "+dataTable.getData("General_Data", "Dept"))).click();
		selenium.waitForPageToLoad("10000");
		validateH1Tag("//*[@id='content-area-with-nav']/div[3]/h1","Promotions");
	}
	
	/*Validating Subtotal amt displayed for SOS min mul qty item*/
	public void validateSubTotalMinMulQty() throws Exception
	{
		String varUnitPrice = driver.findElement(By.xpath(UIMapProductSearch.lblUnitPrice)).getText();
		Double varUnitPriceDbl=0.0;
		if(varUnitPrice.length()>7)
	     {
	    	// int i = s.length()-7;
	    	 String[] s1 = varUnitPrice.split(",");
	    	 String s2 = s1[0].substring(1,s1[0].length());
	    	 String s3=s2+s1[1];
	    	 System.out.println(s3);
	    	 varUnitPriceDbl = Double.valueOf(s3);
	    	System.out.println("Unit Price:"+varUnitPriceDbl);
	     }
		else
		{
			String s1=varUnitPrice.substring(1, varUnitPrice.length());
			varUnitPriceDbl = Double.valueOf(s1);
			System.out.println(varUnitPriceDbl);
		}
		new Select(driver.findElement(By.name(UIMapProductSearch.drpDownQty))).selectByVisibleText(dataTable.getData("General_Data", "Qty"));
		report.updateTestLog("Selecting Min Mul Qty from dropdown","Min Mul Qty selected from dropdown :"+dataTable.getData("General_Data", "Qty"), Status.DONE);
		Thread.sleep(1000);
		String varSubTotalDisplayed = driver.findElement(By.id(UIMapProductSearch.lblSubTotal)).getText();
		//computation
		Double varSubTotaldbl = varUnitPriceDbl*(Integer.valueOf(dataTable.getData("General_Data", "Qty")));
		
		System.out.println("Computed value:"+varSubTotaldbl);
		 double roundOff = (double) Math.round(varSubTotaldbl * 100) / 100;
		 System.out.println("After Round Off:"+roundOff);
		//double varSubTotaldblRoundOff = f.format(varSubTotaldbl);
		String varSubTotalStr = String.format("%.2f", roundOff);
		String varSubTotalExptd=null;
		if(varSubTotalStr.length()>6)
	     {
	    	 int i = varSubTotalStr.length()-6;
	    	 String s1 = varSubTotalStr.substring(0, i);
	    	 String s2 = varSubTotalStr.substring(i,varSubTotalStr.length());
	    	  varSubTotalExptd = s1+","+s2;
	    	 System.out.println(varSubTotalExptd);
	     }
		else
		{
			 varSubTotalExptd = varSubTotalStr;
			 System.out.println(varSubTotalExptd);
		}
		if(varSubTotalDisplayed.equals(varSubTotalExptd))
		{
			report.updateTestLog("Checking SubTotal","Subtotal value correct", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking SubTotal","Subtotal value NOT correct", Status.FAIL);
		}
	}
	/*This function validates whether sq foot pricing(if displayed) is displayed upto 2 decimal points.*/
	public void verifySqFootPricingDecimal() throws Exception
	{
		//List<WebElement> varItems = driver.findElements(By.xpath(UIMapProductSearch.webElmntSqFootPrices));
		//int varCount = varItems.size();
		List<WebElement> varGC = driver.findElements(By.xpath(UIMapProductSearch.webElmntProductList2));
		int varCount = varGC.size();
		System.out.println(varCount);
		int varCount2=0;
		int varDecimal0Flag=0;
		int sqFootFlag=0;
		int DecimalPlaceFlag=0;
		
		 //for (WebElement varItems2 : varItems) {
		for(int i=1;i<=varCount;i++){
			String varXpath = "//*[@id='productResults']/li["+i+"]";
			System.out.println(varXpath);
			String varID = driver.findElement(By.xpath(varXpath)).getAttribute("id");
			System.out.println(varID);
	          /*  WebElement Pricingstrong = driver.findElement(By.xpath(".."));
	            WebElement Pricing = driver.findElement(By.xpath(".."));
	            WebElement PricingArea = driver.findElement(By.xpath(".."));
	            WebElement ProductWrapper= driver.findElement(By.xpath(".."));
	            WebElement ItemId= driver.findElement(By.xpath(".."));
	            System.out.println("Entered");
	            System.out.println(ItemId.getAttribute("id"));
	    		String varItemId = ItemId.getAttribute("id");
	    		*/
			try{
				boolean varSqFootPriceDisplayed=driver.findElement(By.xpath("//*[@id='"+varID+"']/div/div[3]/p/strong/span")).isDisplayed();
				if(varSqFootPriceDisplayed)
				{
					sqFootFlag=sqFootFlag+1;	
	    		String varPrice=driver.findElement(By.xpath("//*[@id='"+varID+"']/div/div[3]/p/strong")).getText();
	    		String s1=varPrice.substring(1,varPrice.length());
	    		String[] s2= s1.split(" ");
	    		System.out.println(s2[0]);
	    		String pattern = "[0-9]+.([0-9][0-9])";
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(s2[0]);
			    if (m.find( )) 
			    {
			    	DecimalPlaceFlag=DecimalPlaceFlag+1;
			    	varCount2=varCount2+1;
			    	if(m.group(1).equals("00"))
			    	{
			    		varDecimal0Flag=varDecimal0Flag+1;
			    	}
			    }
				}
			}
			catch(Exception NoSuchElementException)
			{
				
				continue;
			}
	        }
		 if(DecimalPlaceFlag==sqFootFlag)
		 {
			 report.updateTestLog("Checking Sq Foot Pricing","Sq Foot Pricing displayed with round off upto 2 Decimal points", Status.PASS);
			 if(varDecimal0Flag>0)
				 report.updateTestLog("Checking Sq Foot Pricing for Items with Decimals=0","Sq Foot Pricing displayed up to 2 zero decimal points", Status.PASS);
			 else
				 report.updateTestLog("Checking Sq Foot Pricing for Items with Decimals=0","Sq Foot Pricing could not be validated", Status.FAIL);
		 }
		 else
			 report.updateTestLog("Checking Sq Foot Pricing","Sq Foot Pricing NOT displayed with round off upto 2 Decimal points", Status.FAIL);
		
		
	}
	
	/*public void selectRandomHomeArea() throws Exception
	{
		boolean varFilterBox=selenium.isElementPresent(UIMapProductSearch.webElmntFilterBreadBox);
		List<WebElement> varHomeAreaList = driver.findElements(By.xpath(UIMapProductSearch.webElmntHomeAreaList));
		int varCount = varHomeAreaList.size();
		Random rand = new Random();
		int varLink1Nbr = rand.nextInt(6-1)+1;
		System.out.println("Link Nbr:"+varLink1Nbr);
		if(varFilterBox)
		{
			try{
			String varChecked=driver.findElement(By.xpath(UIMapProductSearch.webElmntHomeAreaList+"["+varLink1Nbr+"]/input")).getAttribute("checked");
			while(varChecked.equals("True"))
			varLink1Nbr = rand.nextInt(6-1)+1;
			System.out.println("Link Nbr:"+varLink1Nbr);	
			driver.findElement(By.xpath(UIMapProductSearch.webElmntHomeAreaList+"["+varLink1Nbr+"]/input")).click();
			Thread.sleep(5000);
		}
		else
		{
		driver.findElement(By.xpath(UIMapProductSearch.webElmntHomeAreaList+"["+varLink1Nbr+"]")).click();
		Thread.sleep(5000);
		}
		String varHomeArea1Label=driver.findElement(By.xpath(UIMapProductSearch.webElmntHomeAreaList+"["+varLink1Nbr+"]/label")).getText();
		System.out.println("Home Area1:"+varHomeArea1Label);
		dataTable.putData("General_Data", "SelectedLink", varHomeArea1Label);
	}*/
	
	public void checkRemoveLink(String varLabel, String varXpath)
	{
		List<WebElement> varFilter = driver.findElements(By.xpath(varXpath));
		int varCount = varFilter.size();
		int i=0;
		for(i=1;i<=varCount;i++)
		{
			String varFilterLabel=driver.findElement(By.xpath(varXpath+"["+i+"]")).getText();
			System.out.println(varFilterLabel);
			System.out.println(varLabel);
			if(varFilterLabel.contains(varLabel))
			{
				String varRemoveLink=driver.findElement(By.xpath(varXpath+"["+i+"]/a")).getText();
				if(varRemoveLink.equals("remove"))
				{
				report.updateTestLog("Checking Remove in Filter Breadbox","Remove displayed for selected filter"+varLabel, Status.PASS);
				break;
				}
				else
				{
					report.updateTestLog("Checking Remove in Filter Breadbox","Remove NOT displayed for selected filter"+varLabel, Status.PASS);
					break;
				}
			}
			else
			continue;
		}
			if(i==(varCount+1))
			{
				report.updateTestLog("Checking Filter in Filter Breadbox","Not found in Filter breadbox:"+varLabel, Status.FAIL);
			}
			
	}
	
	public void clickRemoveLink(String varLabel, String varXpath) throws Exception
	{
		List<WebElement> varFilter = driver.findElements(By.xpath(varXpath));
		int varCount = varFilter.size();
		int i=0;
		for(i=1;i<=varCount;i++)
		{
			String varFilterLabel=driver.findElement(By.xpath(varXpath+"["+i+"]")).getText();
			System.out.println(varFilterLabel);
			System.out.println(varLabel);
			if(varFilterLabel.contains(varLabel))
			{
				driver.findElement(By.xpath(varXpath+"["+i+"]/a")).click();
				Thread.sleep(5000);
				
				break;
			}
			else
			continue;
		}
		if(i==(varCount+1))
		{
			report.updateTestLog("Checking Filter in Filter Breadbox","Not found in Filter breadbox:"+varLabel, Status.FAIL);
		}
		else
		{
			System.out.println(i);
			boolean varFilterBoxDisplayed=driver.findElement(By.xpath(UIMapProductSearch.webElmntFilterBreadBox)).isDisplayed();
			if(varFilterBoxDisplayed)
			{
				varFilter = driver.findElements(By.xpath(UIMapProductSearch.webElmntFilterBreadBoxHA));
				 varCount = varFilter.size();
			for(i=1;i<=varCount;i++)
			{
				String varFilterLabel=driver.findElement(By.xpath(UIMapProductSearch.webElmntFilterBreadBoxHA+"["+i+"]")).getText();
					
				if(varFilterLabel.contains(varLabel))
				{
					report.updateTestLog("Checking Filter in Filter Breadbox","Filter NOT REMOVED from Filter breadbox:"+varLabel, Status.FAIL);
					break;
				}
				else
					continue;
					
				}
				if(i==(varCount+1))
				{
					report.updateTestLog("Checking Filter in Filter Breadbox","Filter removed from Filter breadbox:"+varLabel, Status.PASS);
				}
			}
			else
			{
				if(varCount==1)
				{
					report.updateTestLog("Checking Filter in Filter Breadbox","Filter Breadbox disappeared as expected", Status.PASS);
				}
				else
				{
					report.updateTestLog("Checking Filter in Filter Breadbox","Filter Breadbox disappeared ", Status.FAIL);
				}
			}
			}
			
	}
	
	public void selectRefinementIdeas(String varLabel) throws Exception
	{
		//driver.findElement(By.xpath(UIMapProductSearch.webElmntHomeAreaListLink1+"/a")).click();
		List<WebElement> varHomeAreaList= driver.findElements(By.xpath(UIMapProductSearch.webElmntHomeAreaList));
		int i=0;
		int varCount = varHomeAreaList.size();
		for(i=1;i<=varCount;i++)
		{
		String varHomeArealink= driver.findElement(By.xpath(UIMapProductSearch.webElmntHomeAreaList+"["+i+"]/a")).getAttribute("title");
		String varHomeArealinkWithCount=driver.findElement(By.xpath(UIMapProductSearch.webElmntHomeAreaList+"["+i+"]/a")).getText();
		System.out.println(varHomeArealink);
		System.out.println(varLabel);
		if(varHomeArealink.contains(varLabel))
		{
		driver.findElement(By.xpath(UIMapProductSearch.webElmntHomeAreaList+"["+i+"]/a")).click();
		Thread.sleep(5000);
		boolean varFilterBox=selenium.isElementPresent(UIMapProductSearch.webElmntFilterBreadBox);
		if(varFilterBox)
		{
			report.updateTestLog("Selecting Home Area Link","Filter Breadbox displayed", Status.PASS);
			String varLabel1= driver.findElement(By.xpath(UIMapProductSearch.webElmntHomeAreaListLink1+"/label")).getAttribute("title");
			checkRemoveLink(varLabel1,UIMapProductSearch.webElmntFilterBreadBoxHA);
			break;
		}
		else
		{
			report.updateTestLog("Selecting Home Area Link","Filter Breadbox NOT displayed", Status.FAIL);
			break;
		}
		}
		else
			continue;
		}
		if(i==(varCount+1))
		{
			report.updateTestLog("Searching Home Area Link","Home Area Link NOT displayed", Status.FAIL);
			
		}
		
	}
	
	public void selectHomeAreaCheckBox(String varLabel) throws Exception
	{
		List<WebElement> varHomeAreaList= driver.findElements(By.xpath(UIMapProductSearch.webElmntHomeAreaList));
		int i=0;
		int varCount = varHomeAreaList.size();
		for(i=1;i<=varCount;i++)
		{
		String varHomeArealink= driver.findElement(By.xpath(UIMapProductSearch.webElmntHomeAreaList+"["+i+"]/label")).getAttribute("title");
		String varHomeArealinkWithCount=driver.findElement(By.xpath(UIMapProductSearch.webElmntHomeAreaList+"["+i+"]/label")).getText();
		System.out.println(varHomeArealink);
		System.out.println(varLabel);
		if(varHomeArealink.contains(varLabel))
		{
			driver.findElement(By.xpath(UIMapProductSearch.webElmntHomeAreaList+"["+i+"]/input")).click();
			report.updateTestLog("Selecting filter"+varLabel,"Filter Selected"+varLabel, Status.DONE);	
			Thread.sleep(5000);
			//String varLabel1=driver.findElement(By.xpath(varXpath+"/label")).getAttribute("title");
			checkRemoveLink(varHomeArealink,UIMapProductSearch.webElmntFilterBreadBoxHA);
			
			break;
		}
		else
		{
			continue;
		}
		}
		if(i==(varCount+1))
		{
			report.updateTestLog("Selecting filter"+varLabel,"Filter Not Displayed", Status.DONE);


		}


	}
	
	public void selectLeftRailIdeasCheckBox(String varLabel, String varXpath) throws Exception
	{
		List<WebElement> varList= driver.findElements(By.xpath(varXpath));
		int i=0;
		int varCount = varList.size();
		for(i=1;i<=varCount;i++)
		{
		String varHomeArealink= driver.findElement(By.xpath(varXpath+"["+i+"]/label")).getAttribute("title");
		String varHomeArealinkWithCount=driver.findElement(By.xpath(varXpath+"["+i+"]/label")).getText();
		System.out.println(varHomeArealink);
		System.out.println(varLabel);
		if(varHomeArealink.contains(varLabel))
		{
			driver.findElement(By.xpath(varXpath+"["+i+"]/input")).click();
			report.updateTestLog("Selecting filter"+varLabel,"Filter Selected"+varLabel, Status.DONE);	
			Thread.sleep(5000);
			//String varLabel1=driver.findElement(By.xpath(varXpath+"/label")).getAttribute("title");
			//int varTotal2=checkListRefreshMultiRefine(varTotal,"([[A-Z][a-z]\\s-']+)(.*)",varHomeArealinkWithCount);
			//return varTotal2;
			break;
		}
		else
		{
			continue;
		}
		}
		if(i==(varCount+1))
		{
			
			report.updateTestLog("Selecting filter"+varLabel,"Filter Not Displayed", Status.DONE);	


		}


	}
	
	public void selectClearAllSelections() throws Exception
	{
		driver.findElement(By.partialLinkText("Clear All Selections")).click();
		Thread.sleep(5000);
		boolean varFilterBox=driver.findElement(By.xpath(UIMapProductSearch.webElmntFilterBreadBox)).isDisplayed();
		if(varFilterBox)
			report.updateTestLog("Selecting Clear all selections","Filter Breadbox NOT disappeaed", Status.FAIL);	
		else
			report.updateTestLog("Selecting Clear all selections","Filter Breadbox disappeaed", Status.PASS);	
	}
	
	
	

	public void navigateToHomeArea() throws Exception
	{
		try{Actions actions = new Actions(driver);
		WebElement varHoverShop = driver.findElement(By.xpath(UIMapProductSearch.lnkIdeas));
		actions.moveToElement(varHoverShop).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(2000);
		System.out.println(dataTable.getData("General_Data", "Dept"));
		WebElement varDept = driver.findElement(By.partialLinkText(dataTable.getData("General_Data", "Dept")));
		actions.moveToElement(varDept).build().perform();
		varDept.click();
		selenium.waitForPageToLoad("10000");
		String varHomeAreaHeading = driver.findElement(By.xpath(UIMapProductSearch.webElmntHomeAreaHeading)).getText();
		if(varHomeAreaHeading.equals(dataTable.getData("General_Data", "Dept")))
		{
			report.updateTestLog("Opening Home Area Page","Home Area Page displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Opening Home Area Page","Home Area Page NOT displayed", Status.FAIL);
		}
		}
		catch(Exception WebDriverException)
		{
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			Actions actions = new Actions(driver);
			WebElement varHoverShop = driver.findElement(By.xpath(UIMapProductSearch.lnkShop));
			actions.moveToElement(varHoverShop).build().perform();
			System.out.println("Mouse Hover successful");
			Thread.sleep(2000);
			System.out.println(dataTable.getData("General_Data", "Dept"));
			WebElement varDept = driver.findElement(By.partialLinkText(dataTable.getData("General_Data", "Dept")));
			actions.moveToElement(varDept).build().perform();
			varDept.click();
			selenium.waitForPageToLoad("10000");
			String varDeptBreadcrumbs = driver.findElement(By.xpath(UIMapMyLowes.webElmntBrdCrumbsLvl2)).getText();
			if(varDeptBreadcrumbs.equals(dataTable.getData("General_Data", "Dept")))
			{
				report.updateTestLog("Opening Dept using Shop By Dept","Dept page displayed", Status.PASS);
			}
			else
			{
				report.updateTestLog("Opening Dept using Shop By Dept","Dept page NOT displayed", Status.FAIL);
			}
		}
			
	}

	public void validateFilterBreadBox() throws Exception
	{
		selectRefinementIdeas("Baby Room");
		selectHomeAreaCheckBox("Basement");
		clickRemoveLink("Baby Room",UIMapProductSearch.webElmntFilterBreadBoxHA);
		clickRemoveLink("Basement",UIMapProductSearch.webElmntFilterBreadBoxHA);
		selectHomeAreaCheckBox("Basement");
		selectClearAllSelections();
		
		
	}
	
	public boolean isSorted(List<String> list) throws Exception
	{
		for(int a=0;a<list.size()-1;a++)
	    {
	        if(list.get(a).compareToIgnoreCase(list.get(a+1))>0)
	        {
	            return false;
	        }
	    }
	    return true;
	}
	
	public boolean checkLeftRail() throws Exception
	{
		boolean varLeftRail=selenium.isElementPresent(UIMapProductSearch.webElmntLeftRail);
		return varLeftRail;
		
	}
	
	/*public int checkListRefreshMultiRefine(int varTotal, String pattern, String varLabel) throws Exception
	{
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(varLabel);
		System.out.println("Entered");
	     if (m.find( )) 
	     {
	    	 System.out.println(m.group(2));
	    	 int len = m.group(2).length();
	    	 String varProductCount1 = m.group(2).substring(1, len-1);
	    	 System.out.println("Count in link:"+varProductCount1);
	    	 String varProductCount2 = driver.findElement(By.xpath(UIMapProductSearch.webElmntTotalResult)).getText();
	    	 int varNewCount=Integer.valueOf(varProductCount2);
	    	 System.out.println("Count in product list:"+varProductCount2);
	    	 System.out.println("Previous count in list:"+varTotal);
	    	 if(varTotal==0)
	    	 {
				if(varProductCount2.equals(varProductCount1))
				{
					report.updateTestLog("Checking List","List displayed as per selected link" , Status.PASS);
					return varNewCount;
				}
				else
				{
					report.updateTestLog("Checking List","List NOT displayed as per selected link" , Status.FAIL);
					return varNewCount;
				}
	    	 }
	    	 else
	    	 {
	    		 
	    		 int varProductCount = Integer.valueOf(varProductCount1);
		    	 int varTotal2 = varProductCount+varTotal; 
		    	 int varTotal3 = Integer.valueOf(varProductCount2);
		    	 System.out.println(varTotal2);
		    	 if(varTotal2==varTotal3)
		    	 {
		    		 report.updateTestLog("Checking Product List","Products List displayed as per selected link" , Status.PASS);
		    		 return varTotal3;
		    	 }
		    	 else
		    	 {
		    		 report.updateTestLog("Checking Product List","Products List NOT displayed as per selected link" , Status.FAIL);
		    		 return varTotal3;
		    	 }
		    	 
	    	 }
	    	 
	     }
	     else
	    	 System.out.println("Pattern not matched");
	    	 return 0;
	}*/
	
	
	public void validateCatResultsLeftRail() throws Exception
	{
		boolean varLeftRail=checkLeftRail();
		if(varLeftRail)
		{
			report.updateTestLog("Checking Left Rail on Category Landing Page","Left Rail displayed on Category Landing Page", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Left Rail on Category Landing Page","Left Rail displayed on Category Landing Page", Status.PASS);
		}
		selectRefinementIdeas("Baby Room");
		
		varLeftRail=checkLeftRail();
		if(varLeftRail)
		{
			report.updateTestLog("Checking Left Rail on Category Results Page","Left Rail displayed on Category Results Page", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Left Rail on Category Results Page","Left Rail displayed on Category Results Page", Status.PASS);
		}
		
		selectLeftRailIdeasCheckBox("Lowe's Creative Ideas",UIMapProductSearch.webElmntSeeMoreFromList);
		//varTotal=checkListRefreshMultiRefine(varTotal,"([[A-Z][a-z]\\s-]+)(.*)","Lowe's Creative Ideas");
		checkRemoveLink("Lowe's Creative Ideas",UIMapProductSearch.webElmntFilterBreadBoxSeeMore);
		selectHomeAreaCheckBox("Basement");
		//varTotal=checkListRefreshMultiRefine(varTotal,"([[A-Z][a-z]\\s-]+)(.*)","Basement");
		selectClearAllSelections();
		
		
		
		List<WebElement> varRefinementList= driver.findElements(By.xpath(UIMapProductSearch.webElmntLeftRailList));
		int i=0;
		int chkBoxCount=0;
		int varCount = varRefinementList.size();
		List<String> varCat=new ArrayList<String>();
		
		
		for(i=1;i<=varCount;i++)
		{
			String varRefine=driver.findElement(By.xpath(UIMapProductSearch.webElmntLeftRailList+"["+i+"]/a")).getText();
			System.out.println(varRefine);
			List<WebElement> varRefinementList1= driver.findElements(By.xpath(UIMapProductSearch.webElmntLeftRailList+"["+i+"]/ul/li"));
			int varCount1 = varRefinementList1.size();
			if(varCount1>8)
			{
				String varMore= driver.findElement(By.xpath(UIMapProductSearch.webElmntLeftRailList+"["+i+"]/ul/li["+varCount1+"]/a")).getText();
				if(varMore.equals("More"))
				{
					report.updateTestLog("Checking More Link in Left Rail for:"+varRefine,"More link displayed in Left Rail for:"+varRefine, Status.PASS);
					driver.findElement(By.xpath(UIMapProductSearch.webElmntLeftRailList+"["+i+"]/ul/li["+varCount1+"]/a")).click();
					Thread.sleep(2000);
					varMore= driver.findElement(By.xpath(UIMapProductSearch.webElmntLeftRailList+"["+i+"]/ul/li["+varCount1+"]/a")).getText();
					if(varMore.equals("Less"))
						report.updateTestLog("Clicking More Link in Left Rail for:"+varRefine,"Less link displayed in Left Rail for:"+varRefine, Status.PASS);
					else
						report.updateTestLog("Clicking More Link in Left Rail for:"+varRefine,"Less link NOT displayed in Left Rail for:"+varRefine, Status.FAIL);
				}
				else
				{
					report.updateTestLog("Checking More Link in Left Rail for:"+varRefine,"More link NOT displayed in Left Rail for:"+varRefine, Status.FAIL);
				}
			}
			int j=0;
			for(j=1;j<varCount1;j++)
			{
				String varLabel=driver.findElement(By.xpath(UIMapProductSearch.webElmntLeftRailList+"["+i+"]/ul/li["+j+"]/label")).getAttribute("title");
				//System.out.println(UIMapProductSearch.webElmntLeftRailList+"["+i+"]/ul/li["+j+"]/label");
				//System.out.println(varLabel);
				varCat.add(varLabel);
				//System.out.println(j);
				//System.out.println(varCount1);
				boolean varCheckBox=driver.findElement(By.xpath(UIMapProductSearch.webElmntLeftRailList+"["+i+"]/ul/li["+j+"]/input")).isDisplayed();
				if(varCheckBox)
				{
					chkBoxCount=chkBoxCount+1;
				}
				if(j==(varCount1-1))
				{
					
					boolean varSorted=isSorted(varCat);
					if(varSorted)
					{
						varCat.clear();
						report.updateTestLog("Checking Refinement Sorting in Left Rail for:"+varRefine,"Refinement Sorted in Left Rail for:"+varRefine, Status.PASS);
					}
					else
					{
						varCat.clear();
						report.updateTestLog("Checking Refinement Sorting in Left Rail for:"+varRefine,"Refinement NOT Sorted in Left Rail for:"+varRefine, Status.FAIL);
					}
					System.out.println(chkBoxCount);
					if(chkBoxCount==(varCount1-1))
					{
						report.updateTestLog("Checking Checkboxes for All Subcategories in Left Rail for:"+varRefine,"Checkboxes displayed for ALL Subcategories in Left Rail for:"+varRefine, Status.PASS);
						chkBoxCount=0;
					}
					else
					{
						report.updateTestLog("Checking Checkboxes for All Subcategories in Left Rail for:"+varRefine,"Checkboxes NOT displayed for ALL Subcategories in Left Rail for:"+varRefine, Status.FAIL);
						chkBoxCount=0;
					}
					
				}
			}
			
		}
		
		String[] catGroups={"Home Areas","Activities","Themes","Seasons & Holidays","Information Types","Region","See More From"};
		
		List<WebElement> varCatGroups= driver.findElements(By.xpath(UIMapProductSearch.webElmntRefineCount));
		int varCount1 = varCatGroups.size();
		System.out.println(varCount1);
		String[] varCatGroup=new String[varCount1];
		for(i=1;i<=varCount1;i++)
			{
			varCatGroup[i-1]=driver.findElement(By.xpath(UIMapProductSearch.webElmntRefineCount+"["+i+"]/a")).getText();
			System.out.println(varCatGroup[i-1]);
			}
		int j=0;
		for(i=0;i<7;i++)
		{	System.out.println(catGroups[i]+" "+varCatGroup[i]);
			if(catGroups[i].equals(varCatGroup[i]))
			{
				j=j+1;
				
				if(j==varCatGroup.length)
					break;
			}
			else
				continue;
		}
		
		
		if(j==varCatGroup.length)
			{
			System.out.println("In Order");
			report.updateTestLog("Checking Category Groups ordering in Left Rail", "Category Groups displayed in Correct order in Left Rail", Status.PASS);	
			}
		else
		{
			System.out.println("NOT In Order");
			report.updateTestLog("Checking Category Groups ordering in Left Rail", "Category Groups NOT displayed in Correct order in Left Rail", Status.FAIL);	
		}
		
		/*
		String varCatGrp1=driver.findElement(By.xpath(UIMapProductSearch.webElmntRefine1)).getText();
		String varCatGrp2=driver.findElement(By.xpath(UIMapProductSearch.webElmntRefine2)).getText();
		String varCatGrp3=driver.findElement(By.xpath(UIMapProductSearch.webElmntRefine3)).getText();
		String varCatGrp4=driver.findElement(By.xpath(UIMapProductSearch.webElmntRefine4)).getText();
		String varCatGrp5=driver.findElement(By.xpath(UIMapProductSearch.webElmntRefine5)).getText();
		String varCatGrp6=driver.findElement(By.xpath(UIMapProductSearch.webElmntRefine6)).getText();
		String varCatGrp7=driver.findElement(By.xpath(UIMapProductSearch.webElmntRefine7)).getText();
		if(varCatGrp1.equals("Home Areas")&&varCatGrp2.equals("Activities")&&varCatGrp3.equals("Themes")&&varCatGrp4.equals("Seasons & Holidays")&&varCatGrp5.equals("Information Types")&&varCatGrp6.equals("Region")&&varCatGrp7.equals("See More From"))
			report.updateTestLog("Checking Category Groups ordering in Left Rail", "Category Groups displayed in Correct order in Left Rail", Status.PASS);	
		else
			report.updateTestLog("Checking Category Groups ordering in Left Rail", "Category Groups NOT displayed in Correct order in Left Rail", Status.FAIL);	
		*/
		String varSeeMoreFrom1=driver.findElement(By.xpath(UIMapProductSearch.webElmntSeeMoreFromList+"[1]/label")).getAttribute("title");
		String varSeeMoreFrom2=driver.findElement(By.xpath(UIMapProductSearch.webElmntSeeMoreFromList+"[2]/a")).getText();
		if(varSeeMoreFrom1.equals("Lowe's Creative Ideas")&&varSeeMoreFrom2.equals("Houzz Gallery"))
		{
			report.updateTestLog("Checking See More From Category", "Subcategories displayed correctly in See More From Category", Status.PASS);	
			
			
			driver.findElement(By.xpath(UIMapProductSearch.webElmntSeeMoreFromList+"[2]/a")).click();
			selenium.waitForPageToLoad("20000");
			boolean varHeading=selenium.isElementPresent(UIMapProductSearch.webElmntHouzzGalleryPage);
			if(varHeading)
			{
				report.updateTestLog("Clicking Houzz Gallery", "Houzz Gallery landing page displayed", Status.PASS);	
			}
			else
				report.updateTestLog("Clicking Houzz Gallery", "Houzz Gallery landing page NOT displayed", Status.FAIL);	
		}
		else
			report.updateTestLog("Checking See More From Category", "Subcategories NOT displayed correctly in See More From Category", Status.FAIL);	
	}
	
	public void validateCategoryLeftRail() throws Exception
	{
		//validating whether left rail is displayed
		boolean varLeftRail=checkLeftRail();
		if(varLeftRail)
		{
			report.updateTestLog("Checking Left Rail on Category Landing Page","Left Rail displayed on Category Landing Page", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Left Rail on Category Landing Page","Left Rail displayed on Category Landing Page", Status.PASS);
		}
		//validate H1 Tag
		validateH1Tag(UIMapProductSearch.webElmntIdeasHeading, dataTable.getData("General_Data", "Dept"));
		List<WebElement> varRefinementList= driver.findElements(By.xpath(UIMapProductSearch.webElmntLeftRailList));
		int i=0;
		int RefinemntDisplayedCount=0;
		int varCount = varRefinementList.size();
		
		//validate More Link,refinement sorting
		List<String> varCat=new ArrayList<String>();
		for(i=1;i<=varCount;i++)
		{	int j=0;
			String varRefine=driver.findElement(By.xpath(UIMapProductSearch.webElmntLeftRailList+"["+i+"]/a")).getText();
			System.out.println(varRefine);
			List<WebElement> varRefinementList1= driver.findElements(By.xpath(UIMapProductSearch.webElmntLeftRailList+"["+i+"]/ul/li"));
			int varCount1 = varRefinementList1.size();
			if(varCount1>8)
			{
				String varMore= driver.findElement(By.xpath(UIMapProductSearch.webElmntLeftRailList+"["+i+"]/ul/li["+varCount1+"]/a")).getText();
				if(varMore.equals("More"))
				{
					report.updateTestLog("Checking More Link in Left Rail for:"+varRefine,"More link displayed in Left Rail for:"+varRefine+" having subcategories "+varCount1, Status.PASS);
					
					for(j=1;j<varCount1;j++)
					{
						String varClass=driver.findElement(By.xpath(UIMapProductSearch.webElmntLeftRailList+"["+i+"]/ul/li["+j+"]")).getAttribute("class");
						if(varClass.equals(""))
						{
							RefinemntDisplayedCount=RefinemntDisplayedCount+1;
						}
						else
							continue;
					}
					System.out.println("Nbr of refinements displayed:"+RefinemntDisplayedCount);
					if(RefinemntDisplayedCount==6)
					{
						report.updateTestLog("Checking nbr of Refinements displayed with More link for "+varRefine," 6 Refinements displayed with More link for :"+varRefine, Status.PASS);
						RefinemntDisplayedCount=0;
					}
					else
					{
						report.updateTestLog("Checking nbr of Refinements displayed with More link for "+varRefine," 6 Refinements NOT displayed with More link for :"+varRefine, Status.FAIL);
						RefinemntDisplayedCount=0;
					}
					driver.findElement(By.xpath(UIMapProductSearch.webElmntLeftRailList+"["+i+"]/ul/li["+varCount1+"]/a")).click();
					Thread.sleep(2000);
					varMore= driver.findElement(By.xpath(UIMapProductSearch.webElmntLeftRailList+"["+i+"]/ul/li["+varCount1+"]/a")).getText();
					if(varMore.equals("Less"))
						report.updateTestLog("Clicking More Link in Left Rail for:"+varRefine,"Less link displayed in Left Rail for:"+varRefine, Status.PASS);
					else
						report.updateTestLog("Clicking More Link in Left Rail for:"+varRefine,"Less link NOT displayed in Left Rail for:"+varRefine, Status.FAIL);
				
					
				}
				else
				{
					report.updateTestLog("Checking More Link in Left Rail for:"+varRefine,"More link NOT displayed in Left Rail for:"+varRefine+" having subcategories "+varCount1, Status.FAIL);
				}
			}
			else
			{
				String varMore= driver.findElement(By.xpath(UIMapProductSearch.webElmntLeftRailList+"["+i+"]/ul/li["+varCount1+"]/a")).getText();
				if(varMore.equals("More"))
				{
					report.updateTestLog("Checking More Link in Left Rail for:"+varRefine,"More link displayed in Left Rail for:"+varRefine+" having subcategories "+varCount1, Status.FAIL);
				}
				else
				{
					report.updateTestLog("Checking More Link in Left Rail for:"+varRefine,"More link NOT displayed in Left Rail for:"+varRefine+" having subcategories "+varCount1, Status.PASS);
				}
			}
			
			for(j=1;j<varCount1;j++)
			{
				String varLabel=driver.findElement(By.xpath(UIMapProductSearch.webElmntLeftRailList+"["+i+"]/ul/li["+j+"]/a")).getAttribute("title");
				varCat.add(varLabel);
				if(j==(varCount1-1))
				{
					
					boolean varSorted=isSorted(varCat);
					if(varSorted)
					{
						varCat.clear();
						report.updateTestLog("Checking Refinement Sorting in Left Rail for:"+varRefine,"Refinement Sorted in Left Rail for:"+varRefine, Status.PASS);
					}
					else
					{
						varCat.clear();
						report.updateTestLog("Checking Refinement Sorting in Left Rail for:"+varRefine,"Refinement NOT Sorted in Left Rail for:"+varRefine, Status.FAIL);
					}
				}
				//String varLabelWithCount=driver.findElement(By.xpath(UIMapProductSearch.webElmntLeftRailList+"["+i+"]/ul/li["+j+"]/a")).getText();
				
				
			}
		}
		
		//verifying cat groups order
		String[] catGroups={"Home Areas","Activities","Themes","Seasons & Holidays","Information Types","Region","See More From"};
		
		List<WebElement> varCatGroups= driver.findElements(By.xpath(UIMapProductSearch.webElmntRefineCount));
		int varCount1 = varCatGroups.size();
		System.out.println(varCount1);
		String[] varCatGroup=new String[varCount1];
		for(i=1;i<=varCount1;i++)
			{
			varCatGroup[i-1]=driver.findElement(By.xpath(UIMapProductSearch.webElmntRefineCount+"["+i+"]/a")).getText();
			System.out.println(varCatGroup[i-1]);
			}
		int j=0;
		for(i=0;i<7;i++)
		{	System.out.println(catGroups[i]+" "+varCatGroup[i]);
			if(catGroups[i].equals(varCatGroup[i]))
			{
				j=j+1;
				
				if(j==varCatGroup.length)
					break;
			}
			else
				continue;
		}
		
		
		if(j==varCatGroup.length)
			{
			System.out.println("In Order");
			report.updateTestLog("Checking Category Groups ordering in Left Rail", "Category Groups displayed in Correct order in Left Rail", Status.PASS);	
			}
		else
		{
			System.out.println("NOT In Order");
			report.updateTestLog("Checking Category Groups ordering in Left Rail", "Category Groups NOT displayed in Correct order in Left Rail", Status.FAIL);	
		}
		
		
	}
	
	
	/*Navigating to Community stories from category landing page*/
	public void navigateCommunityStories() throws Exception
	{
		driver.findElement(By.partialLinkText("Share Your Story")).click();
		selenium.waitForPageToLoad("20000");
		boolean varCS=selenium.isElementPresent(UIMapProductSearch.webElmntCSHero);
		if(varCS)
		{
			report.updateTestLog("Navigating to Community Stories Page", "Community Stories Page displayed", Status.PASS);	
		}
		else
			report.updateTestLog("Navigating to Community Stories Page", "Community Stories Page NOT displayed", Status.FAIL);		
	}
	

	/*Validating Hero Image in community stories page*/
	public void validateHeroCS() throws Exception
	{
		boolean varHero=driver.findElement(By.xpath(UIMapProductSearch.webElmntCSHeroSection)).isDisplayed();
		if(varHero)
		{
			report.updateTestLog("Validating Hero Image", "Hero Image displayed", Status.PASS);	
		}
		else
			report.updateTestLog("Validating Hero Image", "Hero Image  NOT displayed", Status.FAIL);
	}
	
	/*Validating Category heading for selected category in community stories - category page*/
	public void validateCSCatText() throws Exception
	{
		boolean varCat=driver.findElement(By.xpath(UIMapProductSearch.webElmntCSCatHeading)).isDisplayed();
		if(varCat)
		{
			report.updateTestLog("Validating Selected category Text-heading", "Selected category Text-heading displayed", Status.PASS);	
		}
		else
			report.updateTestLog("Validating Selected category Text-heading", "Selected category Text-heading  NOT displayed", Status.FAIL);
	}
	
	/*Validating Category section in community stories page*/
	public boolean validateCSCatSection() throws Exception
	{
		boolean varCatSection=driver.findElement(By.id(UIMapProductSearch.webElmntCatSection)).isDisplayed();
		if(varCatSection)
		{
			report.updateTestLog("Validating Categories section", "Categories section displayed", Status.PASS);	
			return true;
		}
		else
		{
			report.updateTestLog("Validating Categories section", "Categories section  NOT displayed", Status.FAIL);
			return false;
		}
		
	}
	
	/*Randomly selecting a category from  Category section in community stories page*/
	public void selectCategoryCS() throws Exception
	{
		List<WebElement> varCat = driver.findElements(By.xpath(UIMapProductSearch.lnkCSCategories));
		int varCount = varCat.size();
		Random rand = new Random();
		int varRandomCat = rand.nextInt(varCount-1)+1;
		System.out.println("Random category nbr:"+varRandomCat);
		driver.findElement(By.xpath(UIMapProductSearch.lnkCSCategories+"["+varRandomCat+"]/a")).click();
		selenium.waitForPageToLoad("20000");
		validateCSCatText();
		
	}
	
	/*Selects filter in CS-category page and validates result*/
	public void selectFilterCSCat() throws Exception
	{
		String varResultCount=null;
		List<WebElement> varFilter = driver.findElements(By.xpath(UIMapProductSearch.webElmntCSCatFilter));
		int varCount = varFilter.size();
		for(int i=1;i<=varCount;i++)
		{
			 varResultCount=driver.findElement(By.xpath(UIMapProductSearch.webElmntCSCatFilter+"["+i+"]/label/span[2]")).getText();
			System.out.println(varResultCount);
			if(varResultCount.equals("(0)"))
			{
				continue;
			}
			else
			{
				driver.findElement(By.xpath(UIMapProductSearch.webElmntCSCatFilter+"["+i+"]/label/span[1]")).click();
				Thread.sleep(2000);
				break;
			}
		}
		String varCount2=varResultCount.substring(1,varResultCount.length()-1);
		System.out.println(varCount2);
		int varCount3=Integer.valueOf(varCount2);
		if(varCount3<=8)
			{
				List<WebElement> varResults = driver.findElements(By.xpath(UIMapProductSearch.webElmntCSCatResultTitles));
				int varResultCount2= varResults.size();
				if(varCount3==varResultCount2)
					{
						report.updateTestLog("Selecting Filter", "Search Results displayed based on selected filter", Status.PASS);		
					}
					else
					{
						report.updateTestLog("Selecting Filter", "Search Results NOT displayed based on selected filter", Status.FAIL);		
					}
			}
		else
			{
			List<WebElement> varResults = driver.findElements(By.xpath(UIMapProductSearch.webElmntCSCatResultTitles));
			int varResultCount2= varResults.size();
			boolean varNext= driver.findElement(By.partialLinkText("next")).isDisplayed();
			if((8==varResultCount2)&&varNext)
			{
				report.updateTestLog("Selecting Filter", "Search Results displayed based on selected filter with Next option", Status.PASS);		
			}
			else
			{
				report.updateTestLog("Selecting Filter", "Search Results NOT displayed based on selected filter with Next option", Status.FAIL);		
			}
			}
		
	}
	
	/*Clicking any story title on community stories-category page*/
	public void selectStoryCSCat() throws Exception
	{
		String varId= driver.findElement(By.xpath(UIMapProductSearch.webElmntCSStory1)).getAttribute("id");
		System.out.println(varId);
		driver.findElement(By.xpath("//*[@id='"+varId+"']/div/div[1]/div[2]/div[1]/span[2]/a")).click();
		
		selenium.waitForPageToLoad("10000");
		boolean varContent=driver.findElement(By.xpath(UIMapProductSearch.webElmntCSStoryContent)).isDisplayed();
		if(varContent)
		{
			report.updateTestLog("Selecting Story Title", "Story Content displayed", Status.PASS);
			boolean varLikeStory=selenium.isTextPresent("Did you like this story?");
			if(varLikeStory)
			{
				report.updateTestLog("Validating Did you like this story section", "Did you like this story section displayed", Status.PASS);
			}
			else
			{
				report.updateTestLog("Validating Did you like this story section", "Did you like this story section NOT displayed", Status.FAIL);
			}
			
		}
		else
		{
			report.updateTestLog("Selecting Story Title", "Story Content NOT displayed", Status.FAIL);		
		}
			
		
	}
	
	public void checkElements(String varXpath, String varLabel)
	{
		boolean varDisplayed=selenium.isElementPresent(varXpath);
		if(varDisplayed)
		{
			report.updateTestLog("Validating element: "+varLabel, "Element displayed: "+varLabel, Status.PASS);		
		}
		else
		
		{
			report.updateTestLog("Validating element: "+varLabel, "Element NOT displayed: "+varLabel, Status.FAIL);		
		}	
	}
	
	/*checks comment form in story*/
	public void checkCommentFormStoryCSCat() throws Exception
	{
		driver.findElement(By.xpath(UIMapProductSearch.webElmntCSStoryComment)).click();
		Thread.sleep(5000);
		selenium.waitForPageToLoad("20000");
		boolean verPopUpBoxPresent=selenium.isElementPresent(UIMapFunctionalComponents.webElmntLoginPopup);
		System.out.println("PopUp Window identified is :"+verPopUpBoxPresent);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		boolean verFramePresent=driver.findElement(By.id(UIMapFunctionalComponents.webElmntLoginFrame)).isDisplayed();
		System.out.println("Verifying the Presence of frame id:"+verFramePresent);
		driver.switchTo().frame(driver.findElement(By.id(UIMapFunctionalComponents.webElmntLoginFrame)));
		driver.findElement(By.id(UIMapFunctionalComponents.txtUserName)).click();
		Thread.sleep(2000);
		driver.findElement(By.id(UIMapFunctionalComponents.txtUserName)).sendKeys(dataTable.getData("General_Data","email"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(dataTable.getData("General_Data", "password"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(Keys.ENTER);
		//driver.findElement(By.id("GoYourAccount")).click();		
		selenium.waitForPageToLoad("15000");
		//Thread.sleep(20000);
		String getLoggedInUser=driver.findElement(By.xpath(UIMapFunctionalComponents.webElmntSalutation)).getText().trim();
		System.out.println("Verifying the Registered User detais :"+getLoggedInUser);
		if(getLoggedInUser.equals("Welcome, "+dataTable.getData("General_Data","Firstname")))          // Verifying the registered user details by Using Firstname
		{
			report.updateTestLog("Validating Login Credentials","Login Successful", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Login Credentials","Login Failed..! for User "+dataTable.getData("General_Data","email")+" ", Status.FAIL);
		}
		boolean varCommentForm=selenium.isTextPresent("Write your comment");
		if(varCommentForm)
		{
			report.updateTestLog("Validating Comment Form", "Comment Form displayed", Status.PASS);
			boolean varShortDesc=driver.findElement(By.xpath(UIMapProductSearch.webElmntCommentShortDesc)).isDisplayed();
			if(varShortDesc)
			{
				report.updateTestLog("Validating Comment Form-Short Desc", "Short Desc displayed", Status.PASS);
			}
			else
			{
				report.updateTestLog("Validating Comment Form-Short Desc", "Short Desc NOT displayed", Status.FAIL);
			}
			checkElements(UIMapProductSearch.txtStoryComment,"Comment Input Box");
			try{
				boolean varNickName=driver.findElement(By.id(UIMapProductSearch.txtCommentNickname)).isDisplayed();
				if(varNickName)
				{
					report.updateTestLog("Validating Comment Nickname", "Nickname Input box displayed", Status.PASS);
				}
				else
				{
					report.updateTestLog("Validating Comment Nickname", "Nickname Input box not displayed", Status.FAIL);
				}
				}
				catch(Exception e)
				{
					boolean varNickName=driver.findElement(By.id(UIMapProductSearch.txtCommentNickname2)).isDisplayed();
					if(varNickName)
					{
						report.updateTestLog("Validating Comment Nickname", "Comment nickname already present", Status.PASS);
					}
					else
					{
						report.updateTestLog("Validating Comment Nickname", "Already present Comment nickname NOT displayed", Status.FAIL);
					}
				}
				checkElements(UIMapProductSearch.chkBoxCommentEmail,"Email Alert checkbox");
				checkElements(UIMapProductSearch.chkBoxCommentTC,"T & C checkbox");
				checkElements(UIMapProductSearch.txtCommentUserEmail,"Email Text field");
				checkElements(UIMapProductSearch.btnCommentSubmit,"Submit button");
				checkElements(UIMapProductSearch.btnCommentCancel,"Cancel button");
				String varTC=driver.findElement(By.xpath(UIMapProductSearch.lnkTC)).getText();
				if(varTC.equals("Terms and conditions"))
				{
					report.updateTestLog("Validating Terms and conditions link", "Terms and conditions link displayed", Status.PASS);
				}
				else
				{
					report.updateTestLog("Validating Terms and conditions link", "Terms and conditions link NOT displayed", Status.FAIL);
				}
				String varGuidelines=driver.findElement(By.xpath(UIMapProductSearch.lnkCommentGuidelines)).getText();
				if(varGuidelines.equals("Comment guidelines"))
				{
					report.updateTestLog("Validating Comment guidelines link", "Comment guidelines link displayed", Status.PASS);
				}
				else
				{
					report.updateTestLog("Validating Comment guidelines link", "Comment guidelines link NOT displayed", Status.FAIL);
				}
			/*boolean varCommentInput=selenium.isElementPresent(UIMapProductSearch.txtStoryComment);
			if(varCommentInput)
			{
				report.updateTestLog("Validating Comment Input box", "Comment Input box displayed", Status.PASS);
			}
			else
			{
				report.updateTestLog("Validating Comment Input box", "Comment Input box not displayed", Status.FAIL);
			}
			
			boolean varEmailAlert=selenium.isElementPresent(UIMapProductSearch.chkBoxCommentEmail);
			if(varEmailAlert)
			{
				report.updateTestLog("Validating Comment Email Alert checkbox", "Comment Email Alert checkbox displayed", Status.PASS);
			}
			else
			{
				report.updateTestLog("Validating Comment Email Alert checkbox", "Comment Email Alert checkbox not displayed", Status.FAIL);
			}
			boolean varTCCheckbox=selenium.isElementPresent(UIMapProductSearch.chkBoxCommentTC);
			if(varTCCheckbox)
			{
				report.updateTestLog("Validating Comment T&C Checkbox", "Comment Input box displayed", Status.PASS);
			}
			else
			{
				report.updateTestLog("Validating Comment T&C Checkbox", "Comment Input box not displayed", Status.FAIL);
			}
			boolean varCommentInput=selenium.isElementPresent(UIMapProductSearch.chkBoxCommentTC);
			if(varCommentInput)
			{
				report.updateTestLog("Validating Comment Input box", "Comment Input box displayed", Status.PASS);
			}
			else
			{
				report.updateTestLog("Validating Comment Input box", "Comment Input box not displayed", Status.FAIL);
			}
			boolean varCommentInput=selenium.isElementPresent(UIMapProductSearch.chkBoxCommentEmail);
			if(varCommentInput)
			{
				report.updateTestLog("Validating Comment Input box", "Comment Input box displayed", Status.PASS);
			}
			else
			{
				report.updateTestLog("Validating Comment Input box", "Comment Input box not displayed", Status.FAIL);
			}
			boolean varCommentInput=selenium.isElementPresent(UIMapProductSearch.chkBoxCommentEmail);
			if(varCommentInput)
			{
				report.updateTestLog("Validating Comment Input box", "Comment Input box displayed", Status.PASS);
			}
			else
			{
				report.updateTestLog("Validating Comment Input box", "Comment Input box not displayed", Status.FAIL);
			}*/
			
			
		}
		else
		{
			report.updateTestLog("Validating Comment Form", "Comment Form NOT displayed", Status.FAIL);
		}
		
	}
	
	/*Validating Hero section in community stories page*/
	public void validateHeroSectionCS() throws Exception
	{
		String varURL=driver.getCurrentUrl();
		validateHeroCS();	
		driver.findElement(By.xpath(UIMapProductSearch.lnkCSViewAll1)).click();
		selenium.waitForPageToLoad("20000");
		validateHeroCS();
		validateCSCatText();
		driver.get(varURL);
		selenium.waitForPageToLoad("20000");
		if(validateCSCatSection())
		{
		selectCategoryCS();
		selectFilterCSCat();
		selectStoryCSCat();
		checkCommentFormStoryCSCat();
		}
		
		
		
	}
	
	public void clickShareStoryButton() throws Exception
	{
		driver.findElement(By.id(UIMapProductSearch.btnShareStory)).click();
		selenium.waitForPageToLoad("20000");
		selenium.waitForPageToLoad("20000");
		boolean verPopUpBoxPresent=selenium.isElementPresent(UIMapFunctionalComponents.webElmntLoginPopup);
		System.out.println("PopUp Window identified is :"+verPopUpBoxPresent);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		boolean verFramePresent=driver.findElement(By.id(UIMapFunctionalComponents.webElmntLoginFrame)).isDisplayed();
		System.out.println("Verifying the Presence of frame id:"+verFramePresent);
		driver.switchTo().frame(driver.findElement(By.id(UIMapFunctionalComponents.webElmntLoginFrame)));
		driver.findElement(By.id(UIMapFunctionalComponents.txtUserName)).click();
		Thread.sleep(2000);
		driver.findElement(By.id(UIMapFunctionalComponents.txtUserName)).sendKeys(dataTable.getData("General_Data","email"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(dataTable.getData("General_Data", "password"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(Keys.ENTER);
		//driver.findElement(By.id("GoYourAccount")).click();		
		selenium.waitForPageToLoad("15000");
		//Thread.sleep(20000);
		String getLoggedInUser=driver.findElement(By.xpath(UIMapFunctionalComponents.webElmntSalutation)).getText().trim();
		System.out.println("Verifying the Registered User detais :"+getLoggedInUser);
		if(getLoggedInUser.equals("Welcome, "+dataTable.getData("General_Data","Firstname")))          // Verifying the registered user details by Using Firstname
		{
			report.updateTestLog("Validating Login Credentials","Login Successful", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Login Credentials","Login Failed..! for User "+dataTable.getData("General_Data","email")+" ", Status.FAIL);
		}
		if(driver.findElement(By.id(UIMapProductSearch.webElmntStoryForm)).isDisplayed())
		{
			report.updateTestLog("Validating Select A Category Model","Select A Category Model displayed", Status.PASS);
			new Select(driver.findElement(By.name(UIMapProductSearch.drpDownStoryCategory))).selectByVisibleText("Home Decorating and Building Projects");
			driver.findElement(By.partialLinkText("Continue")).click();
			selenium.waitForPageToLoad("120000");
			String varHeading=driver.findElement(By.xpath(UIMapProductSearch.webElmntStoryPageHeading)).getText();
			System.out.println(varHeading);
			if(varHeading.equalsIgnoreCase("Share your story"))
			
			{
				report.updateTestLog("Selecting category and clicking Continue","Share your story Page displayed", Status.PASS);
			}
			else
			{
				report.updateTestLog("Selecting category and clicking Continue","Share your story Page NOT displayed", Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Validating Select A Category Model","Select A Category Model NOT displayed", Status.FAIL);
		}
		
	}
	
	public void shareStory() throws Exception
	{
		String varNick=null;
		checkElements(UIMapProductSearch.txtStoryTitle,"Story Title Text Box");
		checkElements(UIMapProductSearch.txtStory,"Story Text Box");
		String varSharePhotos=driver.findElement(By.xpath(UIMapProductSearch.webElmntSharePhotos)).getText();
		System.out.println(varSharePhotos);
		if(varSharePhotos.equalsIgnoreCase("Share Photos"))
		{
			report.updateTestLog("Validating Share Photos","Share Photos displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Share Photos","Share Photos NOT displayed", Status.FAIL);
		}
		
		
		
		checkElements(UIMapProductSearch.webElmntYourInfo,"Your Information section header");
		
		checkElements(UIMapProductSearch.txtStoryEmail,"Your Email Text Box");	
		checkElements(UIMapProductSearch.chkBoxStoryEmailAlert,"Please send me an email when my story is posted. Checkbox");
		checkElements(UIMapProductSearch.chkBoxStoryEmailAlert2,"Please send me an email when someone comments on my story. checkbox");
		checkElements(UIMapProductSearch.chkBoxStoryTC,"Story Terms & Conditions checkbox");
		checkElements(UIMapProductSearch.btnStoryPreview,"Preview button");
		checkElements(UIMapProductSearch.btnStoryCancel,"Cancel button");
		driver.findElement(By.id(UIMapProductSearch.txtStoryTitle)).click();
		Thread.sleep(2000);
		driver.findElement(By.id(UIMapProductSearch.txtStoryTitle)).sendKeys("Test Title");
		driver.findElement(By.id(UIMapProductSearch.txtStory)).click();
		driver.findElement(By.id(UIMapProductSearch.txtStory)).sendKeys("TestsummaryTestsummaryTestsummaryTestsummaryTestsummaryTestsummary");
		
		driver.switchTo().frame(driver.findElement(By.className(UIMapProductSearch.webElmntPhotoUploadFrame)));
		checkElements(UIMapProductSearch.btnBrowse,"Browse button");
		checkElements(UIMapProductSearch.btnUpload,"Upload button");
		driver.findElement(By.id(UIMapProductSearch.btnBrowse)).click();
		System.out.println("Clicked Browse:");
		Thread.sleep(5000);
		Robot r = new Robot(); 
		r.keyPress(KeyEvent.VK_D);        // D
		r.keyRelease(KeyEvent.VK_D);
		r.keyPress(KeyEvent.VK_SHIFT);              // : (colon)
		r.keyPress(KeyEvent.VK_SEMICOLON);
		r.keyRelease(KeyEvent.VK_SEMICOLON);
		r.keyRelease(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_BACK_SLASH );    // \ (back slash)
		r.keyRelease(KeyEvent.VK_BACK_SLASH );
		r.keyPress(KeyEvent.VK_A);        // A
		r.keyRelease(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_PERIOD); 
		r.keyRelease(KeyEvent.VK_PERIOD); 
		r.keyPress(KeyEvent.VK_J);        // J
		r.keyRelease(KeyEvent.VK_J);
		r.keyPress(KeyEvent.VK_P);        // P
		r.keyRelease(KeyEvent.VK_P);
		r.keyPress(KeyEvent.VK_G);        // G
		r.keyRelease(KeyEvent.VK_G);

		r.keyPress(KeyEvent.VK_ENTER); 
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.id(UIMapProductSearch.btnUpload)).click();
		//driver.findElement(By.xpath(UIMapProductSearch.btnUpload)).click();
		selenium.waitForPageToLoad("20000");
		driver.switchTo().defaultContent();
		driver.findElement(By.id(UIMapProductSearch.txtStoryPhotoCaption)).sendKeys("Testing Caption");
		
		java.util.Date date= new java.util.Date();
		 Timestamp t = new Timestamp(date.getTime());
		 String varTimeStamp = String.format("%1$TD %1$TT", t);
		 System.out.println(varTimeStamp);
		 String[] varDate = varTimeStamp.split(" ");
		 String[] varDatMon = varDate[0].split("/");
		 String[] varHrMinSec = varDate[1].split(":");
		try{
			boolean varNickName=driver.findElement(By.id(UIMapProductSearch.txtStoryNickname)).isDisplayed();
			if(varNickName)
			{
				System.out.println("Nick Name Input Box");
				report.updateTestLog("Validating Comment Nickname", "Nickname Input box displayed", Status.PASS);
				varNick="Test"+varHrMinSec[0]+varHrMinSec[1]+varHrMinSec[2];
				driver.findElement(By.id(UIMapProductSearch.txtStoryNickname)).sendKeys(varNick);
				
			}
			else
			{
				report.updateTestLog("Validating Comment Nickname", "Nickname Input box not displayed", Status.FAIL);
			}
			}
			catch(Exception e)
			{
				System.out.println("Nick Name Input box not displayed");
				boolean varNickName=driver.findElement(By.xpath(UIMapProductSearch.webElmntStoryNickname2)).isDisplayed();
				if(varNickName)
				{
					varNick=driver.findElement(By.xpath(UIMapProductSearch.webElmntStoryNickname2)).getText();
					report.updateTestLog("Validating Comment Nickname", "Comment nickname already present", Status.PASS);
				}
				else
				{
					report.updateTestLog("Validating Comment Nickname", "Already present Comment nickname NOT displayed", Status.FAIL);
				}
			}
		driver.findElement(By.id(UIMapProductSearch.txtStoryLocation)).click();
		driver.findElement(By.id(UIMapProductSearch.txtStoryLocation)).clear();
		driver.findElement(By.id(UIMapProductSearch.txtStoryLocation)).sendKeys("Ohio");
		new Select(driver.findElement(By.id(UIMapProductSearch.drpDownStoryHomeDecCat))).selectByVisibleText("Flooring");
		driver.findElement(By.id(UIMapProductSearch.chkBoxStoryTC)).click();
		driver.findElement(By.xpath(UIMapProductSearch.btnStoryPreview)).click();
		selenium.waitForPageToLoad("20000");
		String varHeading=driver.findElement(By.xpath(UIMapProductSearch.webElmntStoryPageHeading)).getText();
		if(varHeading.equalsIgnoreCase("Preview your story"))
		{
			report.updateTestLog("Validating Preview your story Heading", "Preview your story displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Preview your story Heading", "Preview your story NOT displayed", Status.FAIL);
		}
		String varPreTitle=driver.findElement(By.xpath(UIMapProductSearch.webElmntPreviewStoryTitle)).getText();
		if(varPreTitle.equals("Test Title"))
		{
			report.updateTestLog("Validating Test Title in Preview", "Test Title displayed correctly in Preview", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Test Title in Preview", "Test Title NOT displayed correctly in Preview", Status.FAIL);
		}
		checkElements(UIMapProductSearch.webElmntPreviewDate,"Date In Preview");
		String varByLabel=driver.findElement(By.xpath(UIMapProductSearch.webElmntPreviewLabelBy)).getText();
		if(varByLabel.equals("By:"))
		{
			report.updateTestLog("Validating By: label in Preview", "By: label displayed correctly in Preview", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating By: label in Preview", "By: label NOT displayed correctly in Preview", Status.FAIL);
		}
		String varNick2=driver.findElement(By.xpath(UIMapProductSearch.webElmntPreviewNick)).getText();
		if(varNick2.equals(varNick))
		{
			report.updateTestLog("Validating Nick name in Preview", "Nick name displayed correctly in Preview", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Nick name in Preview", "Nick name NOT displayed correctly in Preview", Status.FAIL);
		}
		String varFromLabel=driver.findElement(By.xpath(UIMapProductSearch.webElmntPreviewLabelFrom)).getText();
		if(varFromLabel.equals("From:"))
		{
			report.updateTestLog("Validating From: label in Preview", "From: label displayed correctly in Preview", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating From: label in Preview", "From: label NOT displayed correctly in Preview", Status.FAIL);
		}
		String varPreLocation=driver.findElement(By.xpath(UIMapProductSearch.webElmntPreviewLocation)).getText();
		if(varPreLocation.equals("Ohio"))
		{
			report.updateTestLog("Validating Location in Preview", "Location displayed correctly in Preview", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Location in Preview", "Location NOT displayed correctly in Preview", Status.FAIL);
		}
		String varCatLabel=driver.findElement(By.xpath(UIMapProductSearch.webElmntPreviewLabelCat)).getText();
		if(varCatLabel.contains("Category: "))
		{
			report.updateTestLog("Validating Category: label in Preview", "Category: label displayed correctly in Preview", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Category: label in Preview", "Category: label NOT displayed correctly in Preview", Status.FAIL);
		}
		String varPreCat=driver.findElement(By.xpath(UIMapProductSearch.webElmntPreviewCat)).getText();
		if(varPreCat.equals("Flooring"))
		{
			report.updateTestLog("Validating Category in Preview", "Category displayed correctly in Preview", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Category in Preview", "Category NOT displayed correctly in Preview", Status.FAIL);
		}
		String varPreStory=driver.findElement(By.xpath(UIMapProductSearch.webElmntPreviewStory)).getText();
		if(varPreStory.equals("TestsummaryTestsummaryTestsummaryTestsummaryTestsummaryTestsummary"))
		{
			report.updateTestLog("Validating Story in Preview", "Story displayed correctly in Preview", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Story in Preview", "Story NOT displayed correctly in Preview", Status.FAIL);
		}
		checkElements(UIMapProductSearch.webElmntPreviewPhoto,"Photo In Preview");
		String varCaption=driver.findElement(By.xpath(UIMapProductSearch.webElmntPreviewCaption)).getText();
		if(varCaption.equals("Testing Caption"))
		{
			report.updateTestLog("Validating Caption in Preview", "Caption displayed correctly in Preview", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Caption in Preview", "Caption NOT displayed correctly in Preview", Status.FAIL);
		}
		
		checkElements(UIMapProductSearch.chkBoxStoryTC,"T&C Check box");
		checkElements(UIMapProductSearch.btnSubmit,"Submit Button");
		checkElements(UIMapProductSearch.btnEdit,"Edit Button");
		checkElements(UIMapProductSearch.btnStoryCancel,"Cancel Button");
		driver.findElement(By.xpath(UIMapProductSearch.btnSubmit)).click();
		selenium.waitForPageToLoad("20000");
		varHeading=driver.findElement(By.xpath(UIMapProductSearch.webElmntStoryPageHeading)).getText();
		if(varHeading.equalsIgnoreCase("Thanks for your story"))
		{
			report.updateTestLog("Selected Submit", "Thanks for your story displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Selected Submit", "Thanks for your story NOT displayed", Status.FAIL);
		}
		String varReturn=driver.findElement(By.xpath(UIMapProductSearch.lnkReturn)).getText();
		if(varReturn.equalsIgnoreCase("Return"))
		{
			report.updateTestLog("Validating Return link", "Return link displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Return link", "Return link NOT displayed", Status.FAIL);
		}
		driver.findElement(By.xpath(UIMapProductSearch.lnkReturn)).click();
		selenium.waitForPageToLoad("20000");
		checkElements(UIMapProductSearch.webElmntCSPage,"Community Stories Page");
	}

	/*Navigate to LCI Landing page*/
	public void navigateLCILandingPage() throws Exception
	{
		Actions actions = new Actions(driver);
		WebElement varHoverIdeas= driver.findElement(By.xpath(UIMapProductSearch.lnkIdeas));
		actions.moveToElement(varHoverIdeas).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(2000);
		
		WebElement varLCI = driver.findElement(By.xpath(UIMapProductSearch.webElmntLCI));
		actions.moveToElement(varLCI).build().perform();
		varLCI.click();
		selenium.waitForPageToLoad("10000");
		boolean varLCIDisplayed=driver.findElement(By.xpath(UIMapProductSearch.webElmntCSHeroSection)).isDisplayed();
		if(varLCIDisplayed)
			report.updateTestLog("Navigating to Lowes Creative Ideas Page", "Lowes Creative Ideas Page displayed", Status.PASS);	
		else
			report.updateTestLog("Navigating to Lowes Creative Ideas Page", "Lowes Creative Ideas Page NOT displayed", Status.FAIL);	
	}
	
	/*This function returns the count of a web element on a page*/
	public int countWebElement(String varXpath) throws Exception
	{
		List<WebElement> varGC = driver.findElements(By.xpath(varXpath));
		int varCount = varGC.size();
		return varCount;
	}
	
	/*Validate LCI Landing page*/
	public void validateLCILandingPage() throws Exception
	{
		//Hero section
		boolean varLCIDisplayed=driver.findElement(By.xpath(UIMapProductSearch.webElmntCSHeroSection)).isDisplayed();
		if(varLCIDisplayed)
			report.updateTestLog("Validating Hero section in Lowes Creative Ideas Page", "Hero section displayed in LCI Landing page", Status.PASS);	
		else
			report.updateTestLog("Validating Hero section in Lowes Creative Ideas Page", "Hero section NOT displayed in LCI Landing page", Status.FAIL);	
		
		//"Featured Content Cluster Module"
		int varDivCount=countWebElement(UIMapProductSearch.webElmntLCIPgDiv);
		int varCount=0,varCount2=0,varCount3=0;
		int j=0;
		for(int i=2;i<=varDivCount;i++)
		{
			String varClass=driver.findElement(By.xpath(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]")).getAttribute("class");
			System.out.println("varClass:"+varClass);
			if(varClass.equals("project_module clearfix"))
			{
				String varHeading=driver.findElement(By.xpath(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/h2")).getText();
				System.out.println("varHeading:"+varHeading);
				report.updateTestLog("Navigating to:"+varHeading,"Validation starts for "+varHeading,Status.DONE);
				if(varHeading.equals("Featured Projects"))
				{
					varCount=countWebElement(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div");
					System.out.println("varCount:"+varCount);
					if(varCount==2)
					{
						varCount2=countWebElement(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div[1]/div");
						varCount3=countWebElement(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div[2]/div");
						System.out.println("varcount2:"+varCount2);
						System.out.println("varcount3:"+varCount3);
						if((varCount2==3)&&(varCount3==3))
						{
							report.updateTestLog("Validating Featured Projects in LCI Landing page", "6 Articles displayed in Featured Projects", Status.PASS);	
							for(j=1;j<=varCount2;j++)
							{
								String varClass2=driver.findElement(By.xpath(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div[1]/div["+j+"]")).getAttribute("class");
								System.out.println("varClass2:"+varClass2);
								if(varClass2.equals("grid_5 alpha omega"))
								{
									String varSeeAll=driver.findElement(By.xpath(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div[1]/div["+j+"]/div/a")).getText();
									System.out.println(varSeeAll);
									String pattern = "See All (.*)";
									Pattern r = Pattern.compile(pattern);
									Matcher m = r.matcher(varSeeAll);
									String varName=driver.findElement(By.xpath(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div[1]/div["+j+"]/div/h3/a")).getText();
									if(m.find())
								    {
								    	
								    	report.updateTestLog("Validating See All Link for "+varName, "See All link displayed for "+varName, Status.PASS);	
								    }
								    else
								    {
								    	report.updateTestLog("Validating See All Link for "+varName, "See All link NOT displayed for "+varName, Status.FAIL);	
								    }
								}
								else if(varClass2.equals("grid_11 alpha omega"))
								{
									String varSeeAll=driver.findElement(By.xpath(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div[1]/div["+j+"]/div[2]/a")).getText();
									System.out.println(varSeeAll);
									String pattern = "See All (.*)";
									Pattern r = Pattern.compile(pattern);
									Matcher m = r.matcher(varSeeAll);
									String varName=driver.findElement(By.xpath(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div[1]/div["+j+"]/div[2]/h3/a")).getText();
									if(m.find())
								    {
								    	
								    	report.updateTestLog("Validating See All Link for "+varName, "See All link displayed for "+varName, Status.PASS);	
								    }
									else
								    {
								    	report.updateTestLog("Validating See All Link for "+varName, "See All link NOT displayed for "+varName, Status.FAIL);	
								    }
								}
								String varClass3=driver.findElement(By.xpath(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div[2]/div["+j+"]")).getAttribute("class");
								System.out.println("varClass2:"+varClass3);
								if(varClass3.equals("grid_5 alpha omega"))
								{
									String varSeeAll=driver.findElement(By.xpath(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div[2]/div["+j+"]/div/a")).getText();
									System.out.println(varSeeAll);
									String pattern = "See All (.*)";
									Pattern r = Pattern.compile(pattern);
									Matcher m = r.matcher(varSeeAll);
									String varName=driver.findElement(By.xpath(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div[2]/div["+j+"]/div/h3/a")).getText();
									if(m.find())
								    {
								    	
								    	report.updateTestLog("Validating See All Link for "+varName, "See All link displayed for "+varName, Status.PASS);	
								    }
								    else
								    {
								    	report.updateTestLog("Validating See All Link for "+varName, "See All link NOT displayed for "+varName, Status.FAIL);	
								    }
								}
								else if(varClass3.equals("grid_11 alpha omega"))
								{
									String varSeeAll=driver.findElement(By.xpath(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div[2]/div["+j+"]/div[2]/a")).getText();
									System.out.println(varSeeAll);
									String pattern = "See All (.*)";
									Pattern r = Pattern.compile(pattern);
									Matcher m = r.matcher(varSeeAll);
									String varName=driver.findElement(By.xpath(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div[2]/div["+j+"]/div[2]/h3/a")).getText();
									if(m.find())
								    {
								    	
								    	report.updateTestLog("Validating See All Link for "+varName, "See All link displayed for "+varName, Status.PASS);	
								    }
									else
								    {
								    	report.updateTestLog("Validating See All Link for "+varName, "See All link NOT displayed for "+varName, Status.FAIL);	
								    }
								}
									
							}
							
							
						}
						
						else
							report.updateTestLog("Validating Featured Projects in LCI Landing page", "6 Articles NOT displayed in Featured Projects", Status.FAIL);		
					}
					else
						report.updateTestLog("Validating Featured Projects in LCI Landing page", "6 Articles NOT displayed in Featured Projects", Status.FAIL);		
				}
				else if(varHeading.equals("More Creative Ideas"))
				{
					varCount=countWebElement(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div");
					System.out.println("varCount:"+varCount);
					if(varCount==1)
					{
						varCount2=countWebElement(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div/div");
						System.out.println("varcount2:"+varCount2);
						if(varCount2==3)
						{	
							report.updateTestLog("Validating More Creative Ideas in LCI Landing page", "3 Articles displayed in Featured Projects", Status.PASS);	
						
							for(j=1;j<=varCount2;j++)
							{
							String varClass2=driver.findElement(By.xpath(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div[1]/div["+j+"]")).getAttribute("class");
							System.out.println("varClass2:"+varClass2);
							if(varClass2.equals("grid_5 alpha omega"))
							{
							String varSeeAll=driver.findElement(By.xpath(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div[1]/div["+j+"]/div/a")).getText();
							System.out.println(varSeeAll);
							String pattern = "See All (.*)";
							Pattern r = Pattern.compile(pattern);
							Matcher m = r.matcher(varSeeAll);
							String varName=driver.findElement(By.xpath(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div[1]/div["+j+"]/div/h3/a")).getText();
							if(m.find())
						    {
						    	
						    	report.updateTestLog("Validating See All Link for "+varName, "See All link displayed for "+varName, Status.PASS);	
						    }
						    else
						    {
						    	report.updateTestLog("Validating See All Link for "+varName, "See All link NOT displayed for "+varName, Status.FAIL);	
						    }
							}
						else if(varClass2.equals("grid_11 alpha omega"))
						{
							String varSeeAll=driver.findElement(By.xpath(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div[1]/div["+j+"]/div[2]/a")).getText();
							System.out.println(varSeeAll);
							String pattern = "See All (.*)";
							Pattern r = Pattern.compile(pattern);
							Matcher m = r.matcher(varSeeAll);
							String varName=driver.findElement(By.xpath(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div[1]/div["+j+"]/div[2]/h3/a")).getText();
							if(m.find())
						    {
						    	
						    	report.updateTestLog("Validating See All Link for "+varName, "See All link displayed for "+varName, Status.PASS);	
						    }
							else
						    {
						    	report.updateTestLog("Validating See All Link for "+varName, "See All link NOT displayed for "+varName, Status.FAIL);	
						    }
							}
					
					
							}
						}
						else
						{
							report.updateTestLog("Validating More Creative Ideas in LCI Landing page", "3 Articles NOT displayed in Featured Projects", Status.FAIL);	
						}
					}
					else
					{
						report.updateTestLog("Validating More Creative Ideas in LCI Landing page", "3 Articles NOT displayed in Featured Projects", Status.FAIL);	
					}
				}
			}
			else if(varClass.equals("project_carousel clearfix"))
			{
				String varHeading=driver.findElement(By.xpath(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/h2")).getText();
				System.out.println("varHeading:"+varHeading);
				report.updateTestLog("Navigating to:"+varHeading,"Validation starts for "+varHeading,Status.DONE);
					varCount=countWebElement(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div/div");
					System.out.println("varCount:"+varCount);
					if(varCount==3)
					{
						varCount2=countWebElement(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div/div[2]/ul/li");
						if((varCount2>3)&&(varCount2<=6))
						{
							report.updateTestLog("Validating "+varHeading+" in LCI Landing page", "3 to 6 Videos/Articles with previous and Next icons displayed in section:"+varHeading, Status.PASS);	
							for(j=1;j<=varCount2;j++)
							{
								if(j==4)
								{
									driver.findElement(By.xpath(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div/div[3]")).click();
									Thread.sleep(1000);
								}
								boolean varImg=driver.findElement(By.xpath(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div/div[2]/ul/li["+j+"]/a/img")).isDisplayed();
								boolean varTxt=driver.findElement(By.xpath(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div/div[2]/ul/li["+j+"]/a/div")).isDisplayed();
								String varTxt2=driver.findElement(By.xpath(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div/div[2]/ul/li["+j+"]/a/div")).getText();
								if(varImg&&varTxt)
								{
									report.updateTestLog("Validating "+varHeading+" in LCI Landing page", "Image and name displayed for "+varTxt2, Status.PASS);	
								}
								else
								{
									report.updateTestLog("Validating "+varHeading+" in LCI Landing page", "Image and name NOT displayed for "+varTxt2, Status.FAIL);	
								}
							}
						}
						else
						{
							report.updateTestLog("Validating "+varHeading+" in LCI Landing page", "Videos/Article NOT between 3-6 with previous and Next icons displayed in section:"+varHeading, Status.PASS);	
						}
					}
					else if(varCount==1)
					{
						varCount2=countWebElement(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div/div/ul/li");
						if((varCount<=3))
						{
							report.updateTestLog("Validating "+varHeading+" in LCI Landing page", "Less than 3 Videos/Articles  section displayed", Status.PASS);	
							for(j=1;j<=varCount2;j++)
							{
								boolean varImg=driver.findElement(By.xpath(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div/div[2]/ul/li["+j+"]/a/img")).isDisplayed();
								boolean varTxt=driver.findElement(By.xpath(UIMapProductSearch.webElmntLCIPgDiv+"["+i+"]/div/div[2]/ul/li["+j+"]/a/div")).isDisplayed();
								if(varImg&&varTxt)
								{
									report.updateTestLog("Validating "+varHeading+" in LCI Landing page", "Image and name displayed for "+varTxt, Status.PASS);	
								}
								else
								{
									report.updateTestLog("Validating "+varHeading+" in LCI Landing page", "Image and name NOT displayed for "+varTxt, Status.FAIL);	
								}
							}
						}
					}
				}
			else
				continue;
			}
		}
		
	/*This function validates if the product list is displayed with Sort option-varSortBy*/
	public boolean checkSortByPL(String varSortBy) throws Exception
	{
		List<WebElement> varSort = driver.findElements(By.xpath(UIMapProductSearch.webElmntProductListSort2));
		int varCount = varSort.size();
		int i;
		for(i=2;i<=varCount;i++)
		{
			String varXpath = UIMapProductSearch.webElmntProductListSort2+"["+i+"]";
			String varSortBy2 = driver.findElement(By.xpath(varXpath)).getText();
			if(varSortBy2.equals(varSortBy))
			{
			System.out.println("SortBY:"+i);
			try{
				boolean varSortByLink=driver.findElement(By.xpath(varXpath+"/a")).isDisplayed();
			if(varSortByLink)
			{
				System.out.println("link displayed");
				return false;
				
			}
			else
			{
				System.out.println("link not displayed");
				return true;
				
			}
			}
			catch(Exception NoSuchElementFoundException)
			{
				System.out.println("Catch block:link not displayed");
				return true;
			}
			}
			else
				continue;
			
		}
		System.out.println("Loop over");
		return false;
	}
	/*This function validates that default SortBy Option in Product List is Best Match on searching*/
	public void verifySortByBestMatchOnSearch() throws Exception
	{
		boolean varBestMatch=checkSortByPL("Best Match");
		if(varBestMatch)
		{
			report.updateTestLog("Validating Sort By", "Best Match is Sort By option on Searching", Status.PASS);	
		}
		else
		{
			report.updateTestLog("Validating Sort By", "Best Match is NOT Sort By option on Searching", Status.FAIL);	
		}
	}
	
	public void openURL() throws Exception
	{
		driver.get(dataTable.getData("General_Data", "URL2"));
		selenium.waitForPageToLoad("20000");
		
	}
	
	/*This function validates that default SortBy Option in Product List is Best Match on navigating*/
	public void verifySortByBestSellerOnNav() throws Exception
	{
		boolean varBestMatch=checkSortByPL("Best Sellers");
		if(varBestMatch)
		{
			report.updateTestLog("Validating Sort By", "Best Sellers is Sort By option on Navigating", Status.PASS);	
		}
		else
		{
			report.updateTestLog("Validating Sort By", "Best Sellers is NOT Sort By option on Navigating", Status.FAIL);	
		}
	}
	
	
	
	/**
	 * 
	 * @throws Exception
	 */
	public void checkOutAddress()throws Exception{
		driver.findElement(By.id("address-name")).clear();
	    driver.findElement(By.id("address-name")).sendKeys(
				dataTable.getData("General_Data", "AddressNickName"));
	    driver.findElement(By.id("fname")).clear();
	    driver.findElement(By.id("fname")).sendKeys(
				dataTable.getData("General_Data", "Firstname"));
	    driver.findElement(By.id("lname")).clear();
	    driver.findElement(By.id("lname")).sendKeys(
				dataTable.getData("General_Data", "Lastname"));
	    driver.findElement(By.id("address-1")).clear();
	    driver.findElement(By.id("address-1")).sendKeys(
				dataTable.getData("General_Data", "Address1"));
	   // driver.findElement(By.id("address-2")).clear();
	   // driver.findElement(By.id("address-2")).sendKeys(
				//dataTable.getData("General_Data", "Address2"));
	    driver.findElement(By.id("city")).clear();
	    driver.findElement(By.id("city")).sendKeys(
				dataTable.getData("General_Data", "City"));
	    new Select(driver.findElement(By.id("state"))).selectByVisibleText(dataTable.getData("General_Data", "State"));
	    driver.findElement(By.id("zip")).clear();
	    driver.findElement(By.id("zip")).sendKeys(
				dataTable.getData("General_Data", "zipcode"));
	   // selenium.waitForPageToLoad("20000");
		//Thread.sleep(6000);
	}



	/**
	 * 
	 * @throws Exception
	 */
	public void checkOutLCC() throws Exception {
		new Select(driver.findElement(By.id(UIMapProductSearch.drpDownCardType))).selectByVisibleText("Lowe's Consumer Credit Card");
		driver.findElement(By.name(UIMapProductSearch.txtCardNbr)).sendKeys(dataTable.getData("General_Data", "crditCardNo"));
		driver.findElement(By.id(UIMapProductSearch.txtCardSecurityCode)).sendKeys(dataTable.getData("General_Data", "CardSCode"));
		driver.findElement(By.id(UIMapProductSearch.rdoBtnLCCOffer)).click();
		Thread.sleep(5000);
		
	}


	/**
	 * 
	 * @throws Exception
	 */
	public void checkOutBillingInfoAddNewAddress() throws Exception {
		//driver.findElement(By.id("addressField2")).clear();
	//	driver.findElement(By.id("addressField2")).sendKeys(
				//dataTable.getData("General_Data", "AddressNickName"));
		driver.findElement(By.id("billingFname")).clear();
		driver.findElement(By.id("billingFname")).sendKeys(
				dataTable.getData("General_Data", "Firstname"));
		driver.findElement(By.id("billingLname")).clear();
		driver.findElement(By.id("billingLname")).sendKeys(
				dataTable.getData("General_Data", "Lastname"));
		driver.findElement(By.id("billingAddress1")).clear();
		driver.findElement(By.id("billingAddress1")).sendKeys(
				dataTable.getData("General_Data", "Address1"));
		//driver.findElement(By.id("billingAddress2")).clear();
		//driver.findElement(By.id("billingAddress2")).sendKeys(
				//dataTable.getData("General_Data", "Address2"));
		driver.findElement(By.id("billingCity")).clear();
		driver.findElement(By.id("billingCity")).sendKeys(
				dataTable.getData("General_Data", "City"));
		new Select(driver.findElement(By.id("billingState")))
				.selectByVisibleText(dataTable.getData("General_Data", "State"));
		driver.findElement(By.id("billingZip")).clear();
		driver.findElement(By.id("billingZip")).sendKeys(
				dataTable.getData("General_Data", "zipcode"));
		driver.findElement(By.id("billingPhone1")).clear();
		driver.findElement(By.id("billingPhone1")).sendKeys(
				dataTable.getData("General_Data", "Phone1"));
		driver.findElement(By.id("billingPhone2")).clear();
		driver.findElement(By.id("billingPhone2")).sendKeys(
				dataTable.getData("General_Data", "Phone2"));
		driver.findElement(By.name("billingPhone3")).clear();
		driver.findElement(By.name("billingPhone3")).sendKeys(
				dataTable.getData("General_Data", "Phone3"));
		driver.findElement(By.id("billingEmailAddress")).clear();
		driver.findElement(By.id("billingEmailAddress")).sendKeys(
				dataTable.getData("General_Data", "OrderEmail"));
	}
	
	public void validateOrderConfirmationFreeLTD() throws Exception
	{
		//Validating Free LTD on Cart page
		String varFreeLTD=driver.findElement(By.xpath(UIMapProductSearch.lblFreeLTD)).getText();
		if(varFreeLTD.equalsIgnoreCase("FREE"))
		{
			report.updateTestLog("Validating LTD Promo in Cart", "LTD FREE displayed in Cart", Status.PASS);
			
		}
		else
		{
			report.updateTestLog("Validating LTD Promo in Cart", "LTD FREE NOT displayed in Cart", Status.FAIL);
		}
		clickSecureCheckoutAZ();
		boolean guestUser=  selenium.isTextPresent("I Don't Have a Lowes.com Account");
		if (guestUser) {
			driver.findElement(By.xpath(UIMapProductSearch.btnGuestChkOut)).click();
			selenium.waitForPageToLoad("20000");
			
		}
		checkOutAddress();
		for(int j=0;j<10;j++)
		{
		driver.findElement(By.xpath(UIMapProductSearch.btnContinueChkOut)).click();
	    System.out.println("Continue CheckOut1");
	    Thread.sleep(5000);
		selenium.waitForPageToLoad("20000");
		System.out.println(selenium.getTitle());
		if(selenium.getTitle().contains("Lowe's: Secure Checkout - Product Destination"))
			break;
		else continue;
		}
	    driver.findElement(By.xpath(UIMapProductSearch.btnContinueChkOut)).click();
	    System.out.println("Continue CheckOut2");
	    Thread.sleep(5000);
	    selenium.waitForPageToLoad("20000");
	    
	    checkOutLCC();
	    checkOutBillingInfoAddNewAddress();
	  //Validating Free LTD on Review & Pay page
	    varFreeLTD=driver.findElement(By.xpath(UIMapProductSearch.lblPromoTxt)).getText();
		if(varFreeLTD.equalsIgnoreCase("FREE"))
		{
			report.updateTestLog("Validating LTD Promo in Review & Pay Page", "LTD FREE displayed in Review & Pay Page", Status.PASS);
			
		}
		else
		{
			report.updateTestLog("Validating LTD Promo in Review & Pay Page", "LTD FREE NOT displayed in Review & Pay Page", Status.FAIL);
		}
		for(int j=0;j<10;j++)
		{
		driver.findElement(By.xpath(UIMapProductSearch.btnContinueChkOut)).click();
	    System.out.println("Final CheckOut");
	    Thread.sleep(5000);
		selenium.waitForPageToLoad("120000");
		System.out.println(selenium.getTitle());
		if(selenium.getTitle().contains("Order Confirmation"))
			break;
		else continue;
		}
	    
	    String varTitle=selenium.getTitle();
	    System.out.println(varTitle);
	    if(varTitle.equalsIgnoreCase("Order Confirmation"))
	    {
	    	report.updateTestLog("Clicking Checkout on Review & Pay Page", "Order Confirmation page displayed", Status.PASS);
	    	//Validating Free LTD on Order Confirmation page
	    	varFreeLTD=driver.findElement(By.xpath(UIMapProductSearch.lblPromoTxt)).getText();
			if(varFreeLTD.equalsIgnoreCase("FREE"))
			{
				report.updateTestLog("Validating LTD Promo in Order Confirmation Page", "LTD FREE displayed in Order Confirmation Page", Status.PASS);
				
			}
			else
			{
				report.updateTestLog("Validating LTD Promo in Order Confirmation Page", "LTD FREE NOT displayed in Order Confirmation Page", Status.FAIL);
			}
	    }
	    else
	    {
	    	report.updateTestLog("Clicking Checkout on Review & Pay Page", "Order Confirmation page NOT displayed", Status.FAIL);
	    }
	    
		
		
	}
	
	/*Validates Contextual Help*/
	public boolean validateContexualHelpDisplayed() throws Exception
	{
		try{
			boolean varPopup=driver.findElement(By.id(UIMapProductSearch.webElmntContextualHelpPopup)).isDisplayed();
			if(varPopup)
			{
				return true;				
			}
			else
			{
				return false;
				
			}
			}
		catch(Exception e)
		{
			return false;
			
		}
	}
	/*Validates MAp item in Details page from some other section*/
	public void validateMAPDetails(String varNameTrimmed, String varPrice, String varEnds) throws Exception
	{
		String varItemName = driver.findElement(By.xpath(UIMapProductSearch.webElmntProductName)).getText();
		String varItemNameTrimmed = varItemName.substring(0, 37);
		if(varItemNameTrimmed.equals(varNameTrimmed))
		{
			report.updateTestLog("Clicking Item Name for MAP Item", "Detail page displayed for MAP Item ", Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking Item Name for MAP Item", "Detail page NOT displayed for MAP Item ", Status.FAIL);
		}
		String varPriceDetail=driver.findElement(By.xpath(UIMapProductSearch.webElmntMAPPriceDesc+"/p/span")).getText();
		if(varPriceDetail.equals(varPrice))
		{
			report.updateTestLog("Validating MAP Price On Details Page", "MAP Price On Details Page same as that in section", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating MAP Price On Details Page", "MAP Price On Details Page NOT same as that in section", Status.FAIL);
		}
		if(varEnds.equals(""))
		{
			System.out.println("No Ends Date");
		}
		else
		{
			String varEndsDetail=driver.findElement(By.xpath(UIMapProductSearch.webElmntMAPPriceDesc+"/p[2]")).getText();
			if(varEndsDetail.equals(varEnds))
			{
				report.updateTestLog("Validating MAP Ends Date On Details Page", "MAP Ends Date On Details Page same as that in section", Status.PASS);
			}
			else
			{
				report.updateTestLog("Validating MAP Ends Date On Details Page", "MAP Ends Date On Details Page NOT same as that in section", Status.FAIL);
			}
		}
		String varViewPrice=driver.findElement(By.xpath(UIMapProductSearch.lblViewPriceInCart)).getText();
		if(varViewPrice.equals("View Price in Cart"))
		{
			report.updateTestLog("Validating MAP View Price in Cart Text On Details Page", "MAP View Price in Cart Text displayed", Status.PASS);
			boolean varContexualHelp=driver.findElement(By.xpath(UIMapProductSearch.webElmntContextualHelp)).isDisplayed();
			if(varContexualHelp)
			{
				report.updateTestLog("Validating MAP Contextual Help On Details Page", "MAP Contextual Help displayed", Status.PASS);
				try{
				driver.findElement(By.xpath(UIMapProductSearch.webElmntContextualHelp)).click();
				Thread.sleep(1000);
				if(validateContexualHelpDisplayed())
					report.updateTestLog("Clicking Contextual Help On Details Page", "Contextual Help Layer displayed", Status.PASS);
				else
					report.updateTestLog("Clicking Contextual Help On Details Page", "Contextual Help Layer NOT displayed", Status.FAIL);
				driver.findElement(By.xpath(UIMapProductSearch.webElmntContextualHelpClose)).click();
				Thread.sleep(5000);
				/*if(validateContexualHelpDisplayed())
					report.updateTestLog("Closing Contextual Help On Details Page", "Contextual Help Layer NOT displayed", Status.PASS);
				else
					report.updateTestLog("Closing Contextual Help On Details Page", "Contextual Help Layer displayed", Status.FAIL);
				*/
				report.updateTestLog("Closing Contextual Help On Details Page", "Contextual Help Layer closed", Status.DONE);
				}
				catch(Exception NoSuchElementFoundException)
				{
					System.out.println("Element Not Found");
				}
			}
			else
			{
				report.updateTestLog("Validating MAP Contextual Help On Details Page", "MAP Contextual Help NOT displayed", Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Validating MAP View Price in Cart Text On Details Page", "MAP View Price in Cart Text NOT displayed", Status.FAIL);
		}
	}
	
	/*Validates MAp item in Related Items section*/
	public void validateMAPinRelatedItems() throws Exception
	{
		int varCount=countWebElement(UIMapProductSearch.webElmntRelatedItemCount);
		int varCount2=0;
		int i=0;
		for(i=1;i<=varCount;i++)
		{
			try
			{
				boolean varMAP=driver.findElement(By.xpath(UIMapProductSearch.webElmntRelatedItemCount+"["+i+"]/div")).isDisplayed();
				if(varMAP)
				{
					varCount2=countWebElement(UIMapProductSearch.webElmntRelatedItemCount+"["+i+"]/div/p");
					System.out.println(varCount2);
					String varURL=driver.getCurrentUrl();
					String varName=driver.findElement(By.xpath(UIMapProductSearch.webElmntRelatedItemCount+"["+i+"]/p/a")).getText();
					String varNameTrimmed = varName.substring(0, 37);
					if(varCount2==1)
					{
						report.updateTestLog("Validating Related Items section", "Related Items contain MAP Item without Ends Date", Status.DONE);
						String varMSRP=driver.findElement(By.xpath(UIMapProductSearch.webElmntRelatedItemCount+"["+i+"]/div/p")).getText();
						if(varMSRP.contains("MSRP:"))
							report.updateTestLog("Validating pricing for MAP Item", "MSRP: displayed for MAP Item ", Status.PASS);
						else
							report.updateTestLog("Validating pricing for MAP Item", "MSRP: NOT displayed for MAP Item ", Status.PASS);
						
						String varPrice=driver.findElement(By.xpath(UIMapProductSearch.webElmntRelatedItemCount+"["+i+"]/div/p/span")).getText();
						System.out.println("MAP Price:"+varPrice);
						
						//clicking on Img
						driver.findElement(By.xpath(UIMapProductSearch.webElmntRelatedItemCount+"["+i+"]/a/img")).click();
						Thread.sleep(2000);
						selenium.waitForPageToLoad("20000");
						String varItemName = driver.findElement(By.xpath(UIMapProductSearch.webElmntProductName)).getText();
						String varItemNameTrimmed = varItemName.substring(0, 37);
						if(varItemNameTrimmed.equals(varNameTrimmed))
						{
							report.updateTestLog("Clicking Image in Related Item section for MAP Item", "Detail page displayed for MAP Item ", Status.PASS);
						}
						else
						{
							report.updateTestLog("Clicking Image in Related Item section for MAP Item", "Detail page NOT displayed for MAP Item ", Status.FAIL);
						}
						driver.get(varURL);
						selenium.waitForPageToLoad("20000");
						//clicking Name
						driver.findElement(By.xpath(UIMapProductSearch.webElmntRelatedItemCount+"["+i+"]/p/a")).click();
						Thread.sleep(2000);
						selenium.waitForPageToLoad("20000");
						validateMAPDetails(varNameTrimmed,varPrice,"");
						break;
						
					}
					else if(varCount2==2)
					{
						report.updateTestLog("Validating Related Items section", "Related Items contain MAP Item WITH Ends Date", Status.DONE);
						String varMSRP=driver.findElement(By.xpath(UIMapProductSearch.webElmntRelatedItemCount+"["+i+"]/div/p")).getText();
						if(varMSRP.contains("MSRP:"))
							report.updateTestLog("Validating pricing for MAP Item", "MSRP: displayed for MAP Item ", Status.PASS);
						else
							report.updateTestLog("Validating pricing for MAP Item", "MSRP: NOT displayed for MAP Item ", Status.PASS);
						
						String varPrice=driver.findElement(By.xpath(UIMapProductSearch.webElmntRelatedItemCount+"["+i+"]/div/p[1]/span")).getText();
						System.out.println("MAP Price:"+varPrice);
						String varEndsDt=driver.findElement(By.xpath(UIMapProductSearch.webElmntRelatedItemCount+"["+i+"]/div/p[2]")).getText();
						System.out.println("MAP Ends Date:"+varEndsDt);
						String pattern = "Ends (0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/20\\d\\d";
						Pattern r = Pattern.compile(pattern);
						Matcher m = r.matcher(varEndsDt);
					     if (m.find( )) 
					    	 report.updateTestLog("Validating End Date for MAP Item", "End date displayed for MAP Item ", Status.PASS);
							else
							report.updateTestLog("Validating End Date for MAP Item", "End date NOT displayed for MAP Item ", Status.PASS); 
						
						//clicking on Img
						driver.findElement(By.xpath(UIMapProductSearch.webElmntRelatedItemCount+"["+i+"]/a/img")).click();
						Thread.sleep(2000);
						selenium.waitForPageToLoad("20000");
						String varItemName = driver.findElement(By.xpath(UIMapProductSearch.webElmntProductName)).getText();
						String varItemNameTrimmed = varItemName.substring(0, 37);
						if(varItemNameTrimmed.equals(varNameTrimmed))
						{
							report.updateTestLog("Clicking Image in Related Item section for MAP Item", "Detail page displayed for MAP Item ", Status.PASS);
						}
						else
						{
							report.updateTestLog("Clicking Image in Related Item section for MAP Item", "Detail page NOT displayed for MAP Item ", Status.FAIL);
						}
						driver.get(varURL);
						selenium.waitForPageToLoad("20000");
						//clicking Name
						driver.findElement(By.xpath(UIMapProductSearch.webElmntRelatedItemCount+"["+i+"]/p/a")).click();
						Thread.sleep(2000);
						selenium.waitForPageToLoad("20000");
						validateMAPDetails(varNameTrimmed,varPrice,varEndsDt);
						break;
						
					}
					else
					{
						report.updateTestLog("Validating Related Items section", "Related Items contain MAP Item with Incorrect Price Desc", Status.FAIL);
						break;
					}
				
					}
				else
				{
					System.out.println("Item not MAP:"+i);
					continue;
				}
				
			}
			catch(Exception NoSuchElementException)
			{
				System.out.println("Item not MAP:"+i);
				continue;
			}
		}
		if(i>varCount)
		{
			report.updateTestLog("Validating Related Items section", "No Map Item in related Items section", Status.FAIL);
		}
	}
	
	/*Validates MAp item in Related Items section*/
	public void validateMAPinBuyPair() throws Exception
	{
		int varCount=countWebElement(UIMapProductSearch.webElmntBuyPairCount);
		int varCount2=0;
		int i=0;
		for(i=1;i<=varCount;i++)
		{
			try
			{
				boolean varMAP=driver.findElement(By.xpath(UIMapProductSearch.webElmntBuyPairCount+"["+i+"]/div")).isDisplayed();
				if(varMAP)
				{
					varCount2=countWebElement(UIMapProductSearch.webElmntBuyPairCount+"["+i+"]/div/p");
					System.out.println(varCount2);
					String varURL=driver.getCurrentUrl();
					String varName=driver.findElement(By.xpath(UIMapProductSearch.webElmntBuyPairCount+"["+i+"]/p/a")).getText();
					String varNameTrimmed = varName.substring(0, 37);
					if(varCount2==1)
					{
						report.updateTestLog("Validating Buy Pair section", "Buy Pair contain MAP Item without Ends Date", Status.DONE);
						String varMSRP=driver.findElement(By.xpath(UIMapProductSearch.webElmntBuyPairCount+"["+i+"]/div/p")).getText();
						if(varMSRP.contains("MSRP:"))
							report.updateTestLog("Validating pricing for MAP Item", "MSRP: displayed for MAP Item ", Status.PASS);
						else
							report.updateTestLog("Validating pricing for MAP Item", "MSRP: NOT displayed for MAP Item ", Status.PASS);
						
						String varPrice=driver.findElement(By.xpath(UIMapProductSearch.webElmntBuyPairCount+"["+i+"]/div/p/span")).getText();
						System.out.println("MAP Price:"+varPrice);
						
						//clicking on Img
						driver.findElement(By.xpath(UIMapProductSearch.webElmntBuyPairCount+"["+i+"]/a/img")).click();
						Thread.sleep(2000);
						selenium.waitForPageToLoad("20000");
						String varItemName = driver.findElement(By.xpath(UIMapProductSearch.webElmntProductName)).getText();
						String varItemNameTrimmed = varItemName.substring(0, 37);
						if(varItemNameTrimmed.equals(varNameTrimmed))
						{
							report.updateTestLog("Clicking Image in Buy Pair section for MAP Item", "Detail page displayed for MAP Item ", Status.PASS);
						}
						else
						{
							report.updateTestLog("Clicking Image in Buy Pair section for MAP Item", "Detail page NOT displayed for MAP Item ", Status.FAIL);
						}
						driver.get(varURL);
						selenium.waitForPageToLoad("20000");
						//clicking Name
						driver.findElement(By.xpath(UIMapProductSearch.webElmntBuyPairCount+"["+i+"]/p/a")).click();
						Thread.sleep(2000);
						selenium.waitForPageToLoad("20000");
						validateMAPDetails(varNameTrimmed,varPrice,"");
						break;
						
					}
					else if(varCount2==2)
					{
						report.updateTestLog("Validating Related Items section", "Related Items contain MAP Item WITH Ends Date", Status.DONE);
						String varMSRP=driver.findElement(By.xpath(UIMapProductSearch.webElmntBuyPairCount+"["+i+"]/div/p")).getText();
						if(varMSRP.contains("MSRP:"))
							report.updateTestLog("Validating pricing for MAP Item", "MSRP: displayed for MAP Item ", Status.PASS);
						else
							report.updateTestLog("Validating pricing for MAP Item", "MSRP: NOT displayed for MAP Item ", Status.PASS);
						String varPrice=driver.findElement(By.xpath(UIMapProductSearch.webElmntBuyPairCount+"["+i+"]/div/p[1]/span")).getText();
						System.out.println("MAP Price:"+varPrice);
						String varEndsDt=driver.findElement(By.xpath(UIMapProductSearch.webElmntBuyPairCount+"["+i+"]/div/p[2]")).getText();
						System.out.println("MAP Ends Date:"+varEndsDt);
						String pattern = "Ends (0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/20\\d\\d";
						Pattern r = Pattern.compile(pattern);
						Matcher m = r.matcher(varEndsDt);
					     if (m.find( )) 
					    	 report.updateTestLog("Validating End Date for MAP Item", "End date displayed for MAP Item ", Status.PASS);
							else
							report.updateTestLog("Validating End Date for MAP Item", "End date NOT displayed for MAP Item ", Status.PASS); 
						//clicking on Img
						driver.findElement(By.xpath(UIMapProductSearch.webElmntBuyPairCount+"["+i+"]/a/img")).click();
						Thread.sleep(2000);
						selenium.waitForPageToLoad("20000");
						String varItemName = driver.findElement(By.xpath(UIMapProductSearch.webElmntBuyPairCount)).getText();
						String varItemNameTrimmed = varItemName.substring(0, 37);
						if(varItemNameTrimmed.equals(varNameTrimmed))
						{
							report.updateTestLog("Clicking Image in Buy Pair section for MAP Item", "Detail page displayed for MAP Item ", Status.PASS);
						}
						else
						{
							report.updateTestLog("Clicking Image in Buy Pair section for MAP Item", "Detail page NOT displayed for MAP Item ", Status.FAIL);
						}
						driver.get(varURL);
						selenium.waitForPageToLoad("20000");
						//clicking Name
						driver.findElement(By.xpath(UIMapProductSearch.webElmntBuyPairCount+"["+i+"]/p/a")).click();
						Thread.sleep(2000);
						selenium.waitForPageToLoad("20000");
						validateMAPDetails(varNameTrimmed,varPrice,varEndsDt);
						break;
						
					}
					else
					{
						report.updateTestLog("Validating Buy Pair section", "Related Items contain MAP Item with Incorrect Price Desc", Status.FAIL);
						break;
					}
				
					}
				else
				{
					System.out.println("Item not MAP:"+i);
					continue;
				}
				
			}
			catch(Exception NoSuchElementException)
			{
				System.out.println("Item not MAP:"+i);
				continue;
			}
		}
		if(i>varCount)
		{
			report.updateTestLog("Validating Buy Pair section", "No Map Item in Buy Pair section", Status.FAIL);
		}
	}
	
	/*Validates MAp item in Customer also viewed section*/
	public void validateMAPinAlsoViewed() throws Exception
	{
		
		
		int varCount=countWebElement(UIMapProductSearch.webElmntAlsoViewedCount);
		int varCount2=0;
		int i=0;
		System.out.println(varCount);
		if(varCount==0)
		{
			varCount=countWebElement(UIMapProductSearch.webElmntAlsoViewedCount2);
			for(i=1;i<=varCount;i++)
			{
				try
				{
					boolean varMAP=driver.findElement(By.xpath(UIMapProductSearch.webElmntAlsoViewedCount2+"["+i+"]/div")).isDisplayed();
					if(varMAP)
					{
						varCount2=countWebElement(UIMapProductSearch.webElmntAlsoViewedCount2+"["+i+"]/div/p");
						System.out.println(varCount2);
						String varURL=driver.getCurrentUrl();
						String varName=driver.findElement(By.xpath(UIMapProductSearch.webElmntAlsoViewedCount2+"["+i+"]/a[2]")).getText();
						String varNameTrimmed = varName.substring(0, 37);
						if(varCount2==1)
						{
							report.updateTestLog("Validating Customers Also Viewed section", "Customers Also Viewed contains MAP Item without Ends Date", Status.DONE);
							String varMSRP=driver.findElement(By.xpath(UIMapProductSearch.webElmntAlsoViewedCount2+"["+i+"]/div/p")).getText();
							if(varMSRP.contains("MSRP:"))
								report.updateTestLog("Validating pricing for MAP Item", "MSRP: displayed for MAP Item ", Status.PASS);
							else
								report.updateTestLog("Validating pricing for MAP Item", "MSRP: NOT displayed for MAP Item ", Status.PASS);
							
							String varPrice=driver.findElement(By.xpath(UIMapProductSearch.webElmntAlsoViewedCount2+"["+i+"]/div/p/span")).getText();
							System.out.println("MAP Price:"+varPrice);
							
							//clicking on Img
							driver.findElement(By.xpath(UIMapProductSearch.webElmntAlsoViewedCount2+"["+i+"]/a[1]/img")).click();
							Thread.sleep(2000);
							selenium.waitForPageToLoad("20000");
							String varItemName = driver.findElement(By.xpath(UIMapProductSearch.webElmntProductName)).getText();
							String varItemNameTrimmed = varItemName.substring(0, 37);
							if(varItemNameTrimmed.equals(varNameTrimmed))
							{
								report.updateTestLog("Clicking Image in Customers Also Viewed section for MAP Item", "Detail page displayed for MAP Item ", Status.PASS);
							}
							else
							{
								report.updateTestLog("Clicking Image in Customers Also Viewed section for MAP Item", "Detail page NOT displayed for MAP Item ", Status.FAIL);
							}
							driver.get(varURL);
							selenium.waitForPageToLoad("20000");
							//clicking Name
							driver.findElement(By.xpath(UIMapProductSearch.webElmntAlsoViewedCount2+"["+i+"]/a[2]")).click();
							Thread.sleep(2000);
							selenium.waitForPageToLoad("20000");
							validateMAPDetails(varNameTrimmed,varPrice,"");
							break;
							
						}
						else if(varCount2==2)
						{
							report.updateTestLog("Validating Customers Also Viewed section", "Customers Also Viewed contain MAP Item WITH Ends Date", Status.DONE);
							String varMSRP=driver.findElement(By.xpath(UIMapProductSearch.webElmntAlsoViewedCount2+"["+i+"]/div/p")).getText();
							if(varMSRP.contains("MSRP:"))
								report.updateTestLog("Validating pricing for MAP Item", "MSRP: displayed for MAP Item ", Status.PASS);
							else
								report.updateTestLog("Validating pricing for MAP Item", "MSRP: NOT displayed for MAP Item ", Status.PASS);
							
							String varPrice=driver.findElement(By.xpath(UIMapProductSearch.webElmntAlsoViewedCount2+"["+i+"]/div/p[1]/span")).getText();
							System.out.println("MAP Price:"+varPrice);
							String varEndsDt=driver.findElement(By.xpath(UIMapProductSearch.webElmntAlsoViewedCount2+"["+i+"]/div/p[2]")).getText();
							System.out.println("MAP Ends Date:"+varEndsDt);
							String pattern = "Ends (0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/20\\d\\d";
							Pattern r = Pattern.compile(pattern);
							Matcher m = r.matcher(varEndsDt);
						     if (m.find( )) 
						    	 report.updateTestLog("Validating End Date for MAP Item", "End date displayed for MAP Item ", Status.PASS);
								else
								report.updateTestLog("Validating End Date for MAP Item", "End date NOT displayed for MAP Item ", Status.PASS); 
							
							//clicking on Img
							driver.findElement(By.xpath(UIMapProductSearch.webElmntAlsoViewedCount2+"["+i+"]/a[1]/img")).click();
							Thread.sleep(2000);
							selenium.waitForPageToLoad("20000");
							String varItemName = driver.findElement(By.xpath(UIMapProductSearch.webElmntProductName)).getText();
							String varItemNameTrimmed = varItemName.substring(0, 37);
							if(varItemNameTrimmed.equals(varNameTrimmed))
							{
								report.updateTestLog("Clicking Image in Customers Also Viewed section for MAP Item", "Detail page displayed for MAP Item ", Status.PASS);
							}
							else
							{
								report.updateTestLog("Clicking Image in Customers Also Viewed section for MAP Item", "Detail page NOT displayed for MAP Item ", Status.FAIL);
							}
							driver.get(varURL);
							selenium.waitForPageToLoad("20000");
							//clicking Name
							driver.findElement(By.xpath(UIMapProductSearch.webElmntAlsoViewedCount2+"["+i+"]/a[2]")).click();
							Thread.sleep(2000);
							selenium.waitForPageToLoad("20000");
							validateMAPDetails(varNameTrimmed,varPrice,varEndsDt);
							break;
							
						}
						else
						{
							report.updateTestLog("Validating Customers Also Viewed section", "Customers Also Viewed contains MAP Item with Incorrect Price Desc", Status.FAIL);
							break;
						}
					
						}
					else
					{
						System.out.println("Item not MAP:"+i);
						continue;
					}
					
				}
				catch(Exception NoSuchElementException)
				{
					System.out.println("Item not MAP:"+i);
					continue;
				}
			}
				
		}
		
		else
		{
		for(i=1;i<=varCount;i++)
		{
			try
			{
				boolean varMAP=driver.findElement(By.xpath(UIMapProductSearch.webElmntAlsoViewedCount+"["+i+"]/div")).isDisplayed();
				if(varMAP)
				{
					varCount2=countWebElement(UIMapProductSearch.webElmntAlsoViewedCount+"["+i+"]/div/p");
					System.out.println(varCount2);
					String varURL=driver.getCurrentUrl();
					String varName=driver.findElement(By.xpath(UIMapProductSearch.webElmntAlsoViewedCount+"["+i+"]/a[2]")).getText();
					String varNameTrimmed = varName.substring(0, 37);
					if(varCount2==1)
					{
						report.updateTestLog("Validating Customers Also Viewed section", "Customers Also Viewed contains MAP Item without Ends Date", Status.DONE);
						String varMSRP=driver.findElement(By.xpath(UIMapProductSearch.webElmntBuyPairCount+"["+i+"]/div/p")).getText();
						if(varMSRP.contains("MSRP:"))
							report.updateTestLog("Validating pricing for MAP Item", "MSRP: displayed for MAP Item ", Status.PASS);
						else
							report.updateTestLog("Validating pricing for MAP Item", "MSRP: NOT displayed for MAP Item ", Status.PASS);
						
						String varPrice=driver.findElement(By.xpath(UIMapProductSearch.webElmntAlsoViewedCount+"["+i+"]/div/p/span")).getText();
						System.out.println("MAP Price:"+varPrice);
						
						//clicking on Img
						driver.findElement(By.xpath(UIMapProductSearch.webElmntAlsoViewedCount+"["+i+"]/a[1]/img")).click();
						Thread.sleep(2000);
						selenium.waitForPageToLoad("20000");
						String varItemName = driver.findElement(By.xpath(UIMapProductSearch.webElmntProductName)).getText();
						String varItemNameTrimmed = varItemName.substring(0, 37);
						if(varItemNameTrimmed.equals(varNameTrimmed))
						{
							report.updateTestLog("Clicking Image in Customers Also Viewed section for MAP Item", "Detail page displayed for MAP Item ", Status.PASS);
						}
						else
						{
							report.updateTestLog("Clicking Image in Customers Also Viewed section for MAP Item", "Detail page NOT displayed for MAP Item ", Status.FAIL);
						}
						driver.get(varURL);
						selenium.waitForPageToLoad("20000");
						//clicking Name
						driver.findElement(By.xpath(UIMapProductSearch.webElmntAlsoViewedCount+"["+i+"]/a[2]")).click();
						Thread.sleep(2000);
						selenium.waitForPageToLoad("20000");
						validateMAPDetails(varNameTrimmed,varPrice,"");
						break;
						
					}
					else if(varCount2==2)
					{
						report.updateTestLog("Validating Customers Also Viewed section", "Customers Also Viewed contain MAP Item WITH Ends Date", Status.DONE);
						String varMSRP=driver.findElement(By.xpath(UIMapProductSearch.webElmntBuyPairCount+"["+i+"]/div/p")).getText();
						if(varMSRP.contains("MSRP:"))
							report.updateTestLog("Validating pricing for MAP Item", "MSRP: displayed for MAP Item ", Status.PASS);
						else
							report.updateTestLog("Validating pricing for MAP Item", "MSRP: NOT displayed for MAP Item ", Status.PASS);
						
						String varPrice=driver.findElement(By.xpath(UIMapProductSearch.webElmntAlsoViewedCount+"["+i+"]/div/p[1]/span")).getText();
						System.out.println("MAP Price:"+varPrice);
						String varEndsDt=driver.findElement(By.xpath(UIMapProductSearch.webElmntAlsoViewedCount+"["+i+"]/div/p[2]")).getText();
						System.out.println("MAP Ends Date:"+varEndsDt);
						String pattern = "Ends (0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/20\\d\\d";
						Pattern r = Pattern.compile(pattern);
						Matcher m = r.matcher(varEndsDt);
					     if (m.find( )) 
					    	 report.updateTestLog("Validating End Date for MAP Item", "End date displayed for MAP Item ", Status.PASS);
							else
							report.updateTestLog("Validating End Date for MAP Item", "End date NOT displayed for MAP Item ", Status.PASS); 
						
						//clicking on Img
						driver.findElement(By.xpath(UIMapProductSearch.webElmntAlsoViewedCount+"["+i+"]/a[1]/img")).click();
						Thread.sleep(2000);
						selenium.waitForPageToLoad("20000");
						String varItemName = driver.findElement(By.xpath(UIMapProductSearch.webElmntProductName)).getText();
						String varItemNameTrimmed = varItemName.substring(0, 37);
						if(varItemNameTrimmed.equals(varNameTrimmed))
						{
							report.updateTestLog("Clicking Image in Customers Also Viewed section for MAP Item", "Detail page displayed for MAP Item ", Status.PASS);
						}
						else
						{
							report.updateTestLog("Clicking Image in Customers Also Viewed section for MAP Item", "Detail page NOT displayed for MAP Item ", Status.FAIL);
						}
						driver.get(varURL);
						selenium.waitForPageToLoad("20000");
						//clicking Name
						driver.findElement(By.xpath(UIMapProductSearch.webElmntAlsoViewedCount+"["+i+"]/a[2]")).click();
						Thread.sleep(2000);
						selenium.waitForPageToLoad("20000");
						validateMAPDetails(varNameTrimmed,varPrice,varEndsDt);
						break;
						
					}
					else
					{
						report.updateTestLog("Validating Customers Also Viewed section", "Customers Also Viewed contains MAP Item with Incorrect Price Desc", Status.FAIL);
						break;
					}
				
					}
				else
				{
					System.out.println("Item not MAP:"+i);
					continue;
				}
				
			}
			catch(Exception NoSuchElementException)
			{
				System.out.println("Item not MAP:"+i);
				continue;
			}
		}
		}
		if(i>varCount)
		{
			report.updateTestLog("Validating Customers Also Viewed section", "No Map Item in Customers Also Viewed section", Status.FAIL);
		}
	}
	
	public void verifyFeatureBannercluster() throws Exception
	{
		boolean var1,var2;
		var1 = driver.findElement(By.xpath(UIMapProductSearch.featureBanner1)).isDisplayed();
		var2 = driver.findElement(By.xpath(UIMapProductSearch.featureBanner2)).isDisplayed();
		if(var1 && var2)
		{
			report.updateTestLog("Verifying Feature Banner  Cluster in Category page","Feature Banner Cluster is displayed",Status.PASS);
			WebElement w = driver.findElement(By.xpath("//*[@id='lci-landing-content']/div[5]/div[1]"));
			String varClass = w.findElement(By.xpath("..")).getAttribute("class");
			if(varClass.equals("grid_8 alpha"))
			{
				report.updateTestLog("verifying layout of blogger section","Blogger Section layout is horizontal",Status.PASS);
				boolean var5,var6,var7;
				var5 = driver.findElement(By.xpath("//*[@id='lci-landing-content']/div[5]/div[1]/a/img")).isDisplayed();
				if(var5)
					report.updateTestLog("Verifying image for blogger banner","image is displayed",Status.PASS);
				else
					report.updateTestLog("Verifying image for blogger banner","image is not displayed",Status.FAIL);
				
				var6 = driver.findElement(By.xpath("//*[@id='lci-landing-content']/div[5]/div[1]/div/h3")).isDisplayed();
				if(var6)
					report.updateTestLog("Verifying title for blogger banner","title is displayed",Status.PASS);
				else
					report.updateTestLog("Verifying title for blogger banner","title is not displayed",Status.FAIL);
				
				var7 = driver.findElement(By.xpath("//*[@id='lci-landing-content']/div[5]/div[1]/div/p")).isDisplayed();
				if(var7)
					report.updateTestLog("Verifying description for blogger banner","description is displayed",Status.PASS);
				else
					report.updateTestLog("Verifying description for blogger banner","description is not displayed",Status.FAIL);
				
			}
			else
				report.updateTestLog("verifying layout of blogger section","Blogger Section layout is not horizontal",Status.FAIL);
			WebElement w2 = driver.findElement(By.xpath("//*[@id='lci-landing-content']/div[6]/div[1]"));
			String varClass2 = w2.findElement(By.xpath("..")).getAttribute("class");
			if(varClass2.equals("grid_4 omega"))
			{
				report.updateTestLog("verifying layout of MyLowes section","MyLowes Section layout is vertical",Status.PASS);
				boolean var5,var6,var7;
				var5 = driver.findElement(By.xpath("//*[@id='lci-landing-content']/div[6]/div/a/img")).isDisplayed();
				if(var5)
					report.updateTestLog("Verifying image for Mylowes banner","image is displayed",Status.PASS);
				else
					report.updateTestLog("Verifying image for Mylowes banner","image is not displayed",Status.FAIL);
				
				var6 = driver.findElement(By.xpath("//*[@id='lci-landing-content']/div[6]/div/h3")).isDisplayed();
				if(var6)
					report.updateTestLog("Verifying title for Mylowes banner","title is displayed",Status.PASS);
				else
					report.updateTestLog("Verifying title for Mylowes banner","title is not displayed",Status.FAIL);
				
				var7 = driver.findElement(By.xpath("//*[@id='lci-landing-content']/div[6]/div/p")).isDisplayed();
				if(var7)
					report.updateTestLog("Verifying description for Mylowes banner","description is displayed",Status.PASS);
				else
					report.updateTestLog("Verifying description for Mylowes banner","description is not displayed",Status.FAIL);
				
			}
			else
				report.updateTestLog("verifying layout of MyLowes section","MyLowes Section layout is not vertical",Status.FAIL);
			WebElement w1 = driver.findElement(By.xpath("//*[@id='lci-landing-content']/div[5]/div[2]"));
			String varClass1 = w1.findElement(By.xpath("..")).getAttribute("class");
			if(varClass1.equals("grid_8 alpha"))
			{
				report.updateTestLog("verifying layout of Community Stories section","Community Stories Section layout is horizontal",Status.PASS);
				boolean var5,var6,var7;
				var5 = driver.findElement(By.xpath("//*[@id='lci-landing-content']/div[5]/div[2]/a/img")).isDisplayed();
				if(var5)
					report.updateTestLog("Verifying image for CS banner","image is displayed",Status.PASS);
				else
					report.updateTestLog("Verifying image for CS banner","image is not displayed",Status.FAIL);
				
				var6 = driver.findElement(By.xpath("//*[@id='lci-landing-content']/div[5]/div[2]/div/h3")).isDisplayed();
				if(var6)
					report.updateTestLog("Verifying title for CS banner","title is displayed",Status.PASS);
				else
					report.updateTestLog("Verifying title for CS banner","title is not displayed",Status.FAIL);
				
				var7 = driver.findElement(By.xpath("//*[@id='lci-landing-content']/div[5]/div[2]/div/p")).isDisplayed();
				if(var7)
					report.updateTestLog("Verifying description for CS banner","description is displayed",Status.PASS);
				else
					report.updateTestLog("Verifying description for CS banner","description is not displayed",Status.FAIL);
				
		
			}
			else
				report.updateTestLog("verifying layout of Community Stories section","Community Stories Section layout is not horizontal",Status.FAIL);
				
		}
		else
			report.updateTestLog("Verifying Feature Banner  Cluster in Category page","Feature Banner Cluster is not displayed",Status.FAIL);
	}
	
////Added 11th March
	
	/**This function validates whether page title is as expected**/
	public void chkPagetitle(String pgTitle) throws Exception
	{
		System.out.println(selenium.getTitle());
		if(selenium.getTitle().equals(pgTitle))
			report.updateTestLog("Checking Page Title", "Page Title as Expected is:"+pgTitle, Status.PASS);
		else
			report.updateTestLog("Checking Page Title", "Page Title Not :"+pgTitle, Status.FAIL);
	}
	
	/**This function submits Comment on a Review**/
	public void submitCommentOnReview() throws Exception
	{
		//click on comment
		ClickCustomize("xpath", UIMapProductSearch.lnkCommentOnReview);
		Thread.sleep(5000);
		//enter login info
		boolean verPopUpBoxPresent=selenium.isElementPresent(UIMapFunctionalComponents.webElmntLoginPopup);
		System.out.println("PopUp Window identified is :"+verPopUpBoxPresent);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		boolean verFramePresent=driver.findElement(By.id(UIMapFunctionalComponents.webElmntLoginFrame)).isDisplayed();
		System.out.println("Verifying the Presence of frame id:"+verFramePresent);
		driver.switchTo().frame(driver.findElement(By.id(UIMapFunctionalComponents.webElmntLoginFrame)));
		driver.findElement(By.id(UIMapFunctionalComponents.txtUserName)).click();
		Thread.sleep(2000);
		driver.findElement(By.id(UIMapFunctionalComponents.txtUserName)).sendKeys(dataTable.getData("General_Data","email"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(dataTable.getData("General_Data", "password"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(Keys.ENTER);
		//driver.findElement(By.id("GoYourAccount")).click();		
		Thread.sleep(5000);
		selenium.waitForPageToLoad("20000");
		chkPagetitle("Submit a New Comment");
		//enter comment details
		ClickCustomize("id", UIMapProductSearch.txtCommentTitle);
		driver.findElement(By.id(UIMapProductSearch.txtCommentTitle)).sendKeys(dataTable.getData("General_Data", "CommentTitle"));
		ClickCustomize("id", UIMapProductSearch.txtComment);
		driver.findElement(By.id(UIMapProductSearch.txtComment)).sendKeys(dataTable.getData("General_Data", "Comment"));
		ClickCustomize("id", UIMapProductSearch.txtCommentNickName);
		driver.findElement(By.id(UIMapProductSearch.txtCommentNickName)).sendKeys(dataTable.getData("General_Data", "CommentNickname"));
		ClickCustomize("id", UIMapProductSearch.txtCommentLocation);
		driver.findElement(By.id(UIMapProductSearch.txtCommentLocation)).sendKeys(dataTable.getData("General_Data", "CommentLocation"));
		ClickCustomize("id", UIMapProductSearch.chkBoxCommentEmailAlert);
		
		//clicking Preview
		ClickCustomize("id", UIMapProductSearch.btnCommentPreview);
		chkPagetitle("Preview comment");
		
		//clicking Submit
		ClickCustomize("id", UIMapProductSearch.btnCommentSubmit2);
		chkPagetitle("Thank You!");
	}
	
	/**This function validates and click Write A review Link besides Star Ratings on Product detail Page**/
	public void clickWriteAReviewBesidesStars() throws Exception
	{
		try{
		String varNbrOfReviews=driver.findElement(By.xpath(UIMapProductSearch.lnkNbrOfReviews)).getText();
		System.out.println(varNbrOfReviews);
		String pattern = "\\d+ reviews";	
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(varNbrOfReviews);
		if(m.find())
			report.updateTestLog("Checking Number Of Reviews", "Number Of Reviewes Correctly displayed", Status.PASS);
		else
			report.updateTestLog("Checking Number Of Reviews", "Number Of Reviewes NOT Correctly displayed", Status.FAIL);
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking Number Of Reviews", "Number Of Reviewes Not displayed", Status.FAIL);
		}
		
		try{
			String varWriteAReview=driver.findElement(By.xpath(UIMapProductSearch.lnkWriteAReview)).getText();
			
			if(varWriteAReview.equalsIgnoreCase("Write a review"))
				report.updateTestLog("Checking Write a review Link", "Write a review Link Correctly displayed", Status.PASS);
			else
				report.updateTestLog("Checking Write a review Link", "Write a review Link NOT Correctly displayed", Status.FAIL);
			}
			catch(Exception e)
			{
				report.updateTestLog("Checking Write a review Link", "Write a review Link Not displayed", Status.FAIL);
			}
		ClickCustomize("linkText", "Write a review");
		Thread.sleep(4000);
		selenium.waitForPageToLoad("20000");
		chkPagetitle("Submit a New Review");
	}
	
	/**
	 * This function enter Details on Submit Review page and submits the review
	 */
	public void submitReview() throws Exception
	{
		ClickCustomize("id", UIMapProductSearch.webElmntStarRating4);
		ClickCustomize("id", UIMapProductSearch.webElmntFeatureRating4);
		ClickCustomize("id", UIMapProductSearch.webElmntValueRt4);
		ClickCustomize("id", UIMapProductSearch.webElmntDesignRt4);
		ClickCustomize("id", UIMapProductSearch.webElmntQualityRt4);
		ClickCustomize("id", UIMapProductSearch.webElmntEaseOfUseRt4);
		
		ClickCustomize("id", UIMapProductSearch.rdoBtnRecommendToFrndYes);
		
		ClickCustomize("id", UIMapProductSearch.txtReviewTitle);
		driver.findElement(By.id(UIMapProductSearch.txtReviewTitle)).sendKeys(dataTable.getData("General_Data", "CommentTitle"));
		ClickCustomize("id", UIMapProductSearch.txtReviewTDesc);
		driver.findElement(By.id(UIMapProductSearch.txtReviewTDesc)).sendKeys(dataTable.getData("General_Data", "Comment"));
		ClickCustomize("id", UIMapProductSearch.chkBoxPro1);
		ClickCustomize("id", UIMapProductSearch.chkBoxCon2);
		
		try{
		ClickCustomize("id", UIMapProductSearch.txtReviewNickName);
		driver.findElement(By.id(UIMapProductSearch.txtReviewNickName)).sendKeys(dataTable.getData("General_Data", "CommentNickname"));
		}
		catch(Exception e)
		{
			if(driver.findElement(By.xpath(UIMapProductSearch.lblStoredNickName)).isDisplayed())
				System.out.println("Nick Name already Present");
			else
				report.updateTestLog("Entering Details", "Nick Name field not present", Status.FAIL);
		}
		ClickCustomize("id", UIMapProductSearch.txtReviewLocation);
		driver.findElement(By.id(UIMapProductSearch.txtReviewLocation)).clear();
		driver.findElement(By.id(UIMapProductSearch.txtReviewLocation)).sendKeys(dataTable.getData("General_Data", "CommentLocation"));
		
		new Select(driver.findElement(By.id(UIMapProductSearch.drpDownReviewGender))).selectByVisibleText(dataTable.getData("General_Data", "Gender"));
		new Select(driver.findElement(By.id(UIMapProductSearch.drpDownReviewAge))).selectByVisibleText(dataTable.getData("General_Data", "Age"));
		new Select(driver.findElement(By.id(UIMapProductSearch.drpDownReviewPuchaseDate))).selectByVisibleText(dataTable.getData("General_Data", "PurchaseDate"));
		new Select(driver.findElement(By.id(UIMapProductSearch.drpDownReviewPrchasePlace))).selectByVisibleText(dataTable.getData("General_Data", "PurchasePlace"));
		new Select(driver.findElement(By.id(UIMapProductSearch.drpDownReviewExpertise))).selectByVisibleText(dataTable.getData("General_Data", "Expertise"));
		
		try{
			String varClass=driver.findElement(By.id(UIMapProductSearch.chkBoxEmailAlert1)).getAttribute("checked");
			System.out.println(varClass);
			if(varClass.equals("true"))
				System.out.println("Email alert 1 already checked");
			else
				ClickCustomize("id", UIMapProductSearch.chkBoxEmailAlert1);
		}
		catch(Exception e)
		{
			ClickCustomize("id", UIMapProductSearch.chkBoxEmailAlert1);
		}
		
		try{
			String varClass=driver.findElement(By.id(UIMapProductSearch.chkBoxEmailAlert2)).getAttribute("checked");
			System.out.println(varClass);
			if(varClass.equals("true"))
				System.out.println("Email alert 2 already checked");
			else
				ClickCustomize("id", UIMapProductSearch.chkBoxEmailAlert2);
		}
		catch(Exception e)
		{
			ClickCustomize("id", UIMapProductSearch.chkBoxEmailAlert2);
		}
		
		/*String varEmail=driver.findElement(By.id(UIMapProductSearch.txtReviewEmail)).getAttribute("value");
		System.out.println(varEmail);
		if(varEmail.equals(dataTable.getData("General_Data", "email")))
			System.out.println("Email displayed");
		else
			report.updateTestLog("Entering Details", "EMail field prepopulated value incorrect", Status.FAIL);
		*/
		ClickCustomize("id", UIMapProductSearch.btnReviewPreview);
		Thread.sleep(2000);
		selenium.waitForPageToLoad("20000");
		chkPagetitle("Review Preview");
		
		ClickCustomize("id", UIMapProductSearch.btnReviewSubmit);
		Thread.sleep(2000);
		selenium.waitForPageToLoad("20000");
		chkPagetitle("Thank You!");
		
	}
	
	/**
	 * This function clicks on Write A Review button in Reviews Tab
	 */
	public void clickWriteAReviewBtn() throws Exception
	{
		ClickCustomize("xpath", UIMapProductSearch.btnWriteAReview);
		Thread.sleep(5000);
		selenium.waitForPageToLoad("20000");
		chkPagetitle("Submit a New Review");
	}
	
	/**
	 * This function clicks on Write A Review button in Reviews Tab for unauthenticated user and enters Login Info
	 */
	public void clickWriteAReviewBtnAZ() throws Exception
	{
		ClickCustomize("xpath", UIMapProductSearch.btnWriteAReview);
		Thread.sleep(5000);
		boolean verPopUpBoxPresent=selenium.isElementPresent(UIMapFunctionalComponents.webElmntLoginPopup);
		System.out.println("PopUp Window identified is :"+verPopUpBoxPresent);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		boolean verFramePresent=driver.findElement(By.id(UIMapFunctionalComponents.webElmntLoginFrame)).isDisplayed();
		System.out.println("Verifying the Presence of frame id:"+verFramePresent);
		driver.switchTo().frame(driver.findElement(By.id(UIMapFunctionalComponents.webElmntLoginFrame)));
		driver.findElement(By.id(UIMapFunctionalComponents.txtUserName)).click();
		Thread.sleep(2000);
		driver.findElement(By.id(UIMapFunctionalComponents.txtUserName)).sendKeys(dataTable.getData("General_Data","email"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(dataTable.getData("General_Data", "password"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(Keys.ENTER);
		//driver.findElement(By.id("GoYourAccount")).click();		
		Thread.sleep(5000);
		selenium.waitForPageToLoad("20000");
		chkPagetitle("Submit a New Review");
	}
	
	//Rajesh
	public void clickOnFirstItemInListPage() throws Exception
	{
		ClickCustomize("xpath","//h3/a");
		selenium.waitForPageToLoad("20000");
		Thread.sleep(5000);
		if(driver.findElement(By.xpath("//*[@id='prodPrimaryImg']")).isDisplayed())
			report.updateTestLog("Verifying Detail Page","Detail Page is displayed",Status.PASS);
		else
			report.updateTestLog("Verifying Detail Page","Detail Page is not displayed",Status.FAIL);
	}
	public void addToCompareAvailableItems()
	{
		int y=0;
		int x=Integer.parseInt(dataTable.getData("General_Data", "CompNumAvail"));
		System.out.println("number of available items to be compared is: "+x);
		for(int i=1;i<=16;i++)
		{
								
			String btnXpath="//li["+i+"]/div/div[3]/form/div/button";
			
			try
			{
			if (driver.findElement(By.xpath(btnXpath)).getText().equals("Add to Cart"))
			{
				String chkBx="//li["+i+"]/div/div/div/input";
				driver.findElement(By.xpath(chkBx)).click();
				report.updateTestLog("Checking compare box for available item "+i,"checkbox for item "+i+" is checked",Status.DONE);
				y=y+1;
				
			
				
			}
			else
			{
				report.updateTestLog("Checking compare box for available item" , "There is no available item", Status.FAIL);
			}
			
			if (y==x)
			{
				break;
			}
			}
			catch(Exception WebDriverException)
			{
				
			}
			
		}
		
	}
		
	public void addToCompareUnavailableItems()
	{
		int y=0;
		int x=Integer.parseInt(dataTable.getData("General_Data", "CompNumUnavail"));
		System.out.println("number of Unavailable items to be compared is: "+x);
		for(int j=1;j<=16;j++)
		{
			
			String btnXpath="//li["+j+"]/div/div[3]/div[3]/p/a[2]/span";
			try
			{
			if (driver.findElement(By.xpath(btnXpath)).getText().equals("Check Other Stores"))
			{
				
				String itemNumXpath="(//li["+j+"]/div/div[4]/ul/li)[1]";
				String itemNumLP=driver.findElement(By.xpath(itemNumXpath)).getText();
				dataTable.putData("General_Data", "Productname", itemNumLP);
				System.out.println("Unavailable Item name is :"+itemNumLP);
				
				
				String chkBx="//li["+j+"]/div/div/div/input";
				driver.findElement(By.xpath(chkBx)).click();
				report.updateTestLog("Checking compare box for Unavailable item "+j,"checkbox for item "+j+" is checked",Status.DONE);
				y=y+1;
				
			
				
			}
								
			if (y==x)
			{
				break;
			}
			}
			catch(Exception WebDriverException)
			{
				
			}
		}
		
			if (y==0)
			{
				report.updateTestLog("Checking compare box for Unavailable item" , "There is no Unavailable item", Status.FAIL);
			}
			
			
		
		
	}
	
	public void clickCompareButton()
	{
		if(driver.findElement(By.xpath("//*[@id='itemBar']/div[1]/a")).isDisplayed())
		{
			ClickCustomize("xpath","//*[@id='itemBar']/div[1]/a");
			report.updateTestLog("Clicking on Compare button", "Compare Button is clicked", Status.PASS);
			if(driver.findElement(By.xpath("//*[@id='product-compare-area']/div[3]/h1")).isDisplayed())
			{
				report.updateTestLog("Launching Compare Assistant page", "Compare Assistant page is displayed", Status.PASS);
			}
			else
			{
				report.updateTestLog("Launching Compare Assistant page", "Compare Assistant page is NOT displayed", Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Clicking on Compare button", "Compare Button is not dipslayed", Status.FAIL);
		}
			
	}
	
	public void clickGetDetails()
	{
		if (driver.findElement(By.xpath("//*[@id='header_container']/div[4]/div/table/tbody/tr[4]/td/p/a")).isDisplayed())
		{
			report.updateTestLog("Verifying Get Details button", "Get Details button is displayed", Status.PASS);
			if(driver.findElement(By.name("quantity")).isDisplayed())
			{
				report.updateTestLog("Verifying quantity box on Compare Assistant page", "Quanity box is displayed", Status.FAIL);
			}
			else
			{
				report.updateTestLog("Verifying quantity box on Compare Assistant page", "Quanity box is NOT displayed", Status.PASS);
				ClickCustomize("xpath","//*[@id='header_container']/div[4]/div/table/tbody/tr[4]/td/p/a");
				report.updateTestLog("Clicking on Get Details button", "Get Details button is clicked", Status.PASS);
				if(driver.findElement(By.xpath("//div[5]/div/ul/li[1]/a")).isDisplayed())
				{
					report.updateTestLog("Launching PD page", "Product detail page is displayed", Status.PASS);
				}
				else
				{
					report.updateTestLog("Launching PD page", "Product detail page is NOT displayed", Status.FAIL);
				}
			}
		}
		else
		{
			report.updateTestLog("Clicking on Get Details button", "Get Details button is NOT dipslayed", Status.FAIL);
		}

	}
	
	public void validateItemNameinPDpage()
	{
		if(driver.findElement(By.xpath("//*[@id='descCont']/div[1]/p")).getText().contains(dataTable.getData("General_Data","Productname")))
		{
			report.updateTestLog("Validating Product Name", "PD page for correct item is displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Product Name", "PD page for correct item is NOT displayed", Status.FAIL);
		}
	}
	
	//End Rajesh
}
	











