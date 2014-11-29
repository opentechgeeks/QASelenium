package com.lowes.qa.selenium.components;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
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
import com.lowes.qa.selenium.uimap.UIMapCheckOut;
import com.lowes.qa.selenium.uimap.UIMapFunctionalComponents;
import com.lowes.qa.selenium.uimap.UIMapManagementCenter;
import com.lowes.qa.selenium.uimap.UIMapMyLowes;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class ManagementCenter extends ReusableLibrary
{
	String baseurl = dataTable.getData("General_Data", "URL");
	FunctionalComponents fc = new FunctionalComponents(scriptHelper);
	ProductSearch ps=new ProductSearch(scriptHelper);
	CheckOut_CH ch = new CheckOut_CH(scriptHelper);
	Selenium selenium = new WebDriverBackedSelenium(driver, baseurl);
	
	public ManagementCenter(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}
	
	public void verifyBOGOinCartSummary() throws Exception
	{
		if(driver.findElement(By.xpath(UIMapManagementCenter.webElmntBogoItem)).isDisplayed())
		{
			if(driver.findElement(By.xpath(UIMapManagementCenter.webElmntBogoDesc)).isDisplayed() &&
					driver.findElement(By.xpath(UIMapManagementCenter.lblBogoPrice2)).isDisplayed())
			{
				report.updateTestLog("Verifying BOGO item in Cart Summary section in Review&Pay page","BOGO item is displayed",Status.PASS);
				report.updateTestLog("Verifying BOGO item description in Cart Summary section in Review&Pay page","BOGO item description is displayed",Status.PASS);
			}
			else
				report.updateTestLog("Verifying BOGO item description in Cart Summary section in Review&Pay page","BOGO item description is not displayed",Status.FAIL);
		}
		else
			report.updateTestLog("Verifying BOGO item in Cart Summary section in Review&Pay page","BOGO item is Not displayed",Status.FAIL);
	}
	public void verifyBOGOinOC() throws Exception
	{
		String id1 = dataTable.getData("General_Data","BOGOid");
		System.out.println(dataTable.getData("General_Data","BOGOid"));
		if(driver.findElement(By.id(id1)).isDisplayed())
			report.updateTestLog("Verifying BOGO item in Order Confirmation page","BOGO item is displayed",Status.PASS);
		else
			report.updateTestLog("Verifying BOGO item in Order Confirmation page","BOGO item is NOT displayed",Status.FAIL);
	}
	public void verifySDandLDinCart() throws Exception
	{
		if(!(driver.findElement(By.xpath(UIMapCheckOut.lnkRemove)).isDisplayed()))
		{
			report.updateTestLog("Verifying the Promotion","Promotion not applied correctly", Status.FAIL);
		}
		if(driver.findElement(By.xpath(UIMapCheckOut.lblLD)).isDisplayed()
		   &&
		   driver.findElement(By.xpath(UIMapCheckOut.lblSD)).isDisplayed()
		  )
			report.updateTestLog("Verifying SD,LD","SD,LD are present",Status.PASS);
		else
			report.updateTestLog("Verifying SD,LD","SD,LD are not present",Status.FAIL);	
	}
	public void verifyGCInformationalText() throws Exception
	{
		try{
		if(driver.findElement(By.xpath(UIMapManagementCenter.lblGCInformationalText)).isDisplayed())
			report.updateTestLog("Verifying Informational Text","Informational Text is displayed",Status.PASS);
		else
			report.updateTestLog("Verifying Informational Text","Informational Text is NOT displayed",Status.FAIL);
		}
		catch(Exception e)
		{
			report.updateTestLog("Verifying Informational Text","Informational Text is displayed",Status.PASS);
		}
	}
	public void verifyBOGOinCart() throws Exception
	{
		int itemsCount = ps.countWebElement("//form/div[4]/div");
		System.out.println("itemsCount"+itemsCount);
		if(itemsCount==2 && 
		    driver.findElement(By.xpath(UIMapCheckOut.lblLD)).getText().equals(driver.findElement(By.xpath("(//div[2]/div[2]/div/div/div)[1]")).getText()))
			report.updateTestLog("Verifying BOGO Item","BOGO Item added successfully",Status.PASS);
		else
			report.updateTestLog("Verifying BOGO Item","BOGO Item NOT added",Status.FAIL);
	}
	
	public void getSubTotalInCart() throws Exception
	{
		String subtotal = driver.findElement(By.xpath(UIMapCheckOut.lblCartSubtotal)).getText();
		dataTable.putData("General_Data","SubTotal",subtotal);
	}
	public void verifySubTotalInCheckoutPage() throws Exception
	{
		String showedSubTotal = driver.findElement(By.xpath(UIMapManagementCenter.lblSubTotalInCheckOut)).getText();
		System.out.println("showedSubTotal"+showedSubTotal);
		String CartSubTotal = dataTable.getData("General_Data","SubTotal");
		System.out.println("CartSubTotal"+CartSubTotal);
		if(showedSubTotal.trim().equals(CartSubTotal.trim()))
			report.updateTestLog("Verifying SubTotal in Checkout Page","Subtotal is correct",Status.PASS);
		else
			report.updateTestLog("Verifying SubTotal in Checkout Page","Subtotal is NOT correct",Status.FAIL);
	}
	public void verifySubTotal() throws Exception
	{
		verifySubTotalInCheckoutPage();
		ch.checkoutFromProductDestination();
		verifySubTotalInCheckoutPage();
	}
	public void verifySubTotalInReviewPage() throws Exception
	{
		String showedSubTotal = driver.findElement(By.xpath("//*[@id='two-column-b']/div[2]/table/tbody/tr[1]/td[2]/strong")).getText();
		String CartSubTotal = dataTable.getData("General_Data","SubTotal");
		if(showedSubTotal.trim().equals(CartSubTotal.trim()))
			report.updateTestLog("Verifying SubTotal in Checkout Page","Subtotal is correct",Status.PASS);
		else
			report.updateTestLog("Verifying SubTotal in Checkout Page","Subtotal is NOT correct",Status.FAIL);
	}
	public void clickReturnToCart() throws Exception
	{
		driver.findElement(By.linkText("Return to Cart to Edit Products")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}
	public void validateBOGOItemInMiniCart() throws Exception
	{
			String CartBOGOimg = driver.findElement(By.xpath("//form/div[4]/div[2]/div/a/img")).getAttribute("src");
			ClickCustomize("xpath","//form/div[4]/div[2]/div/a/img");
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			Actions actions = new Actions(driver);
			WebElement varHoverMiniCart= driver.findElement(By.xpath(UIMapCheckOut.webElmntMiniCart));
			actions.moveToElement(varHoverMiniCart).build().perform();
			System.out.println("Mouse Hover successful");
			Thread.sleep(5000);
			Thread.sleep(15000);
			boolean var1;
			String CartBOGOimg1 = CartBOGOimg.replace("http:","").trim();
			String imgPath = "//img[contains(@src,'"+CartBOGOimg1+"')]";
			var1 = driver.findElement(By.xpath(imgPath)).isDisplayed();
			System.out.println(var1);
			if(var1)
				report.updateTestLog("Verifying BOGO Item in Mini cart","BOGO Item is displayed",Status.PASS);
			else
				report.updateTestLog("Verifying BOGO Item in Mini cart","BOGO Item is NOT displayed",Status.FAIL);
	}
	public void verifyQtyforMinQtyAndBogoItem() throws Exception
	{
		if(driver.findElement(By.xpath(UIMapManagementCenter.lblMinQtyMsg)).isDisplayed())
			report.updateTestLog("Verifying Minimum Qty message","Message displayed correctly",Status.PASS);
		else
			report.updateTestLog("Verifying Minimum Qty message","Message Not displayed",Status.FAIL);
		if(driver.findElement(By.xpath(UIMapManagementCenter.txtParentQtyValue)).getAttribute("value").equals(
				driver.findElement(By.xpath(UIMapManagementCenter.lblBoGoQtyValue)).getAttribute("value")))
				report.updateTestLog("Verifying qty for both items","Qty is same for both items",Status.PASS);
		else
			report.updateTestLog("Verifying qty for both items","Qty is not same for both items",Status.FAIL);
	}
	public void enterPromoInCart() throws Exception
	{
		try
		{
			driver.findElement(By.xpath(UIMapCheckOut.lnkRemove)).click();
			driver.findElement(By.id(UIMapCheckOut.txtPromoCode)).clear();
			driver.findElement(By.id(UIMapCheckOut.txtPromoCode)).sendKeys(dataTable.getData("General_Data","PromoCode"));
			ClickCustomize("xpath",UIMapCheckOut.btnPromoCodeApply);
			selenium.waitForPageToLoad("20000");
			Thread.sleep(3000);
		}
		catch(Exception e){
			driver.findElement(By.id(UIMapCheckOut.txtPromoCode)).clear();
			driver.findElement(By.id(UIMapCheckOut.txtPromoCode)).sendKeys(dataTable.getData("General_Data","PromoCode"));
			ClickCustomize("xpath",UIMapCheckOut.btnPromoCodeApply);
			selenium.waitForPageToLoad("20000");
			Thread.sleep(3000);			
		}
		
		if(!(driver.findElement(By.xpath(UIMapCheckOut.lnkRemove)).isDisplayed()))
		{
			report.updateTestLog("Verifying the Promotion","Promotion not applied correctly", Status.FAIL);
		}
	}
	
	public void searchGCusingModelNumber() throws Exception
	{
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data", "GCModelNbr"));
		try {
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		} catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handeled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		}
		report.updateTestLog("Searching For a Gift Card","Searching for Gift Card Model Number - "	+ dataTable.getData("General_Data", "GCModelNbr") + "",Status.DONE);
		selenium.waitForPageToLoad("120000");
	}
	
	public void addGCtoCart() throws Exception
	{
		driver.findElement(By.id("gcTo_i")).sendKeys(
				dataTable.getData("General_Data", "Firstname"));
		Thread.sleep(1000);
		driver.findElement(By.id("gcFrom_i")).sendKeys(
				dataTable.getData("General_Data", "Lastname"));
		driver.findElement(By.xpath("//*[@id='gift-msg-txtarea']")).sendKeys(
				dataTable.getData("General_Data", "GCMessage"));
		
		driver.findElement(By.xpath("//*[@id='giftCardForm']/div/ul/li[10]/button")).click();
		selenium.waitForPageToLoad("15000");
		Thread.sleep(4000);
	}
	public void verifyAddedGCinCart() throws Exception
	{
		if(driver.findElement(By.xpath("//div[3]/div[2]/div/p")).getText().contains(dataTable.getData("General_Data","GCModelNbr")))
			report.updateTestLog("Verifying added GC in cart","GC is displayed in Cart",Status.PASS);
		else
			report.updateTestLog("Verifying added GC in cart","GC is displayed in Cart",Status.FAIL);
	}
	
	public void getSRCofBogoItemInCart() throws Exception
	{
		dataTable.putData("General_Data","BOGOid",driver.findElement(By.xpath("//form/div[4]/div[2]")).getAttribute("id"));
	}
	
	public void verifyFREEparcelInCart() throws Exception
	{
		if(driver.findElement(By.xpath(UIMapCheckOut.lblGCParcelFree)).getText().equals("FREE"))
			report.updateTestLog("Verifying SpendXGetParcelFREE Promotion","Promotion applied correcly",Status.PASS);
		else
			report.updateTestLog("Verifying SpendXGetParcelFREE Promotion","Promotion NOT applied correcly",Status.FAIL);
	}
	public void verifyFREEparcelInCheckoutPage() throws Exception
	{
		if(driver.findElement(By.xpath(UIMapManagementCenter.lblFreeParcel)).getText().equals("FREE"))
			report.updateTestLog("Verifying SpendXGetParcelFREE Promotion in Checkout page","Promotion applied correcly in Checkout page",Status.PASS);
		else
			report.updateTestLog("Verifying SpendXGetParcelFREE Promotion in Checkout page","Promotion NOT applied correcly in Checkout page",Status.FAIL);
	}
	public void verifyFREEparcelInReviewPage() throws Exception
	{
		if(driver.findElement(By.xpath(UIMapManagementCenter.lblFreeParcelInReviewPay)).getText().equals("FREE"))
			report.updateTestLog("Verifying SpendXGetParcelFREE Promotion in Review page","Promotion applied correcly in Review page",Status.PASS);
		else
			report.updateTestLog("Verifying SpendXGetParcelFREE Promotion in Review page","Promotion NOT applied correcly in Review page",Status.FAIL);
	}
	
	public void selectdeliverymethodInCart(String varDeliveryOption) throws Exception
	{
		if(varDeliveryOption.equals("PL"))
		{
			driver.findElement(By.id(UIMapCheckOut.rdoBtnSPU)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			report.updateTestLog("Selecting Delivery Option","Delivery Option Store Pick Up", Status.DONE);
		}
		else if(varDeliveryOption.equals("LD"))
		{
			driver.findElement(By.id(UIMapCheckOut.rdoBtnLTD)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			report.updateTestLog("Selecting Delivery Option","Delivery Option Lowes Truck Delivery", Status.DONE);
		}
		else if(varDeliveryOption.equals("UPS"))
		{
			driver.findElement(By.id(UIMapCheckOut.rdoBtnPS)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			report.updateTestLog("Selecting Delivery Option","Delivery Option Parcel Shipping", Status.DONE);
		}
	}
	
	public void verifyFreeParcelByChangingDelMthd() throws Exception
	{
		selectdeliverymethodInCart("LD");
		if(driver.findElement(By.xpath(UIMapCheckOut.lblDel2Charges)).isDisplayed())
			report.updateTestLog("Verifying Estimated Parcel Shipping label","Estimated Parcel Shipping label is displayed",Status.PASS);
		else
			report.updateTestLog("Verifying Estimated Parcel Shipping label","Estimated Parcel Shipping label is NOT displayed",Status.FAIL);
		verifyFREEparcelInCart();
		String showedText = driver.findElement(By.xpath(UIMapCheckOut.lblDel1ChargesValue)).getText();
		String p = "$"+"//d"+"."+"//d";
		Pattern r = Pattern.compile(p);
		Matcher m = r.matcher(showedText);
		if(m.find() && driver.findElement(By.xpath(UIMapCheckOut.lblDel1Charges)).isDisplayed())
			report.updateTestLog("Verifying Truck Del charges","Truck Del charges are displayed",Status.PASS);
		else
			report.updateTestLog("Verifying Truck Del charges","Truck Del charges are NOT displayed",Status.FAIL);
		selectdeliverymethodInCart("UPS");
		verifyFREEparcelInCart();
	}
	
	public void validateNoWasPriceInPD() throws Exception
	{
		String url = driver.getCurrentUrl();
		String itemId[] = url.split("productId=");
		System.out.println(itemId[1]);
		dataTable.putData("General_Data","ItemId",itemId[1]);
		if(driver.findElement(By.xpath(UIMapManagementCenter.lblWasPrice)).getText().contains("Was"))
			report.updateTestLog("Checking Was Price","Was Price is displayed",Status.FAIL);
		else
			report.updateTestLog("Checking Was Price","Was Price is NOT displayed",Status.PASS);
		if(driver.findElement(By.xpath(UIMapManagementCenter.lblSellingPrice)).isDisplayed())
			report.updateTestLog("Checking Selling Price","Selling Price is displayed",Status.PASS);
		else
			report.updateTestLog("Checking Selling Price","Selling Price is NOT displayed",Status.FAIL);
	}
	
	public void searchByPartialItemDesc() throws Exception
	{
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","PartialItemDesc"));
		try{driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);}
		selenium.waitForPageToLoad("120000");
		Thread.sleep(4000);
		if(driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1")).isDisplayed())
			report.updateTestLog("Verifying Search Results page","Search Results page is displayed",Status.PASS);
		else
			report.updateTestLog("Verifying Search Results page","Search Results page is not displayed",Status.FAIL);
	}
	public void validateNoWasPriceInList() throws Exception
	{
		if(driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data","ItemId")+"']/div/div[3]/p/strong")).isDisplayed())
			report.updateTestLog("Checking Selling Price","Selling Price is displayed",Status.PASS);
		else
			report.updateTestLog("Checking Selling Price","Selling Price is NOT displayed",Status.FAIL);
		try{
		if(driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data","ItemId")+"']/div/div[3]/div[2]/p[1]")).isDisplayed())
			report.updateTestLog("Checking Was Price","Was Price is displayed",Status.FAIL);
		else
			report.updateTestLog("Checking Was Price","Was Price is NOT displayed",Status.PASS);
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking Was Price","Was Price is NOT displayed",Status.PASS);
		}
	}
	public void validateNoWasPriceInQuickView() throws Exception
	{
		ClickCustomize("xpath","//*[@id='item_"+dataTable.getData("General_Data","ItemId")+"']/div/div[1]/a[2]");
		selenium.waitForPageToLoad("120000");
		Thread.sleep(4000);
		if(driver.findElement(By.xpath("//*[@id='pricing']/span[1]")).isDisplayed())
			report.updateTestLog("Checking Selling Price","Selling Price is displayed in Quickview",Status.PASS);
		else
			report.updateTestLog("Checking Selling Price","Selling Price is NOT displayed in Quickview",Status.FAIL);
		if(driver.findElement(By.xpath("//*[@id='pricing']/span[2]")).isDisplayed())
			report.updateTestLog("Checking Was Price","Was Price is displayed in Quickview",Status.FAIL);
		else
			report.updateTestLog("Checking Was Price","Was Price is NOT displayed in Quickview",Status.PASS);
	}

	}
	



	
	

