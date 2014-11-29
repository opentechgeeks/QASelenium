package com.lowes.qa.selenium.components;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.cognizant.framework.Status;
import com.lowes.qa.selenium.support.DriverScript;
import com.lowes.qa.selenium.support.ReusableLibrary;
import com.lowes.qa.selenium.support.ScriptHelper;
import com.lowes.qa.selenium.uimap.UIMapCheckOut;
import com.lowes.qa.selenium.uimap.UIMapFunctionalComponents;
import com.lowes.qa.selenium.uimap.UIMapMyLowes;
import com.lowes.qa.selenium.uimap.UIMapProductSearch;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;


/**
 * My Lowes Class
 * @author Infosys
 */
public class MyLowes_MLC extends ReusableLibrary
{
	/**
	 * Constructor to initialize the component library
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link DriverScript}
	 */
	
	String baseurl = dataTable.getData("General_Data", "URL");
	Selenium selenium = new WebDriverBackedSelenium(driver, baseurl);
	FunctionalComponents fc = new FunctionalComponents(scriptHelper);
	//CheckOut_CM cm= new CheckOut_CM(scriptHelper);
	CheckOut ch= new CheckOut(scriptHelper);
	//ProductSearch ps= new ProductSearch(scriptHelper);
	//PS2 ps2=new PS2(scriptHelper);
	//ManageAccount purchases = new ManageAccount(scriptHelper);
	Boolean invalidloginFlag = false;
	
	HomeProfile hp=new HomeProfile(scriptHelper);
	public static ArrayList<String> listPLItems=new ArrayList<String>();
	public static ArrayList<String> listLDItems=new ArrayList<String>();
	public static ArrayList<String> listUPSItems=new ArrayList<String>();
	public MyLowes_MLC(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
	}

	///Added by Ankita 18th March
		/**Opens Details page for Product**/
	public void selectProduct()
	{
		String varId=dataTable.getData("General_Data", "ItemId");
		ClickCustomize("xpath", "//*[@id='"+varId+"']/div/div[2]/h3/a");
		selenium.waitForPageToLoad("20000");
	}
	
	/**Adds an item to list and validates whether its is displayed in list**/
	public void addItemToList() throws Exception
	{
			//Adding the element to the list after finding the element
			String itemFromPDPage = driver.findElement(By.xpath(UIMapMyLowes.txtItemInPdPage)).getText();	
			if(itemFromPDPage.length()>40)
				itemFromPDPage=itemFromPDPage.substring(0, 40);
			driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveItem)).click();
				Thread.sleep(5000);
				driver.findElement(By.cssSelector(UIMapMyLowes.lnkSaveToLists)).click();
				Thread.sleep(5000);
				//mouseHoverToListsFromYourAccount();
				driver.findElement(By.linkText(UIMapMyLowes.lnkGoToLists)).click();
				Thread.sleep(5000);
				driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
				Thread.sleep(5000);
				String itemInLists = driver.findElement(By.xpath(UIMapMyLowes.txtItemInListsPage)).getText();	
				itemInLists=itemInLists.substring(0, itemFromPDPage.length());
				System.out.println(itemInLists);
				System.out.println(itemFromPDPage);
				if(itemInLists.equals(itemFromPDPage)){
					report.updateTestLog("Verification of item in List page from PD Page","Verification is successful", Status.PASS);
		        }
		        else{
		        	report.updateTestLog("Verification of item in List page from PD Page","Verification is not successful", Status.FAIL);
				}
	}
	
	/**Checks Get Details Button for Added Item in List for Not available item**/
	public void chkGetDetailsInList() throws Exception
	{
		try{
			String varButton=driver.findElement(By.xpath(UIMapMyLowes.btnGetDetailslist)).getText();
			if(varButton.equalsIgnoreCase("Get Details"))
			{
				report.updateTestLog("Checking Get Details Button", "Get Details displayed", Status.PASS );
				ClickCustomize("xpath", UIMapMyLowes.btnGetDetailslist);
				selenium.waitForPageToLoad("20000");
				if(driver.findElement(By.xpath(UIMapMyLowes.webElmntProductName)).isDisplayed())
					{report.updateTestLog("Clicking Get Details Button", "Details page displayed", Status.PASS );
					driver.navigate().back();
					selenium.waitForPageToLoad("20000");
					chkGetDetailsAfterEdit();
					}
				else
					report.updateTestLog("Clicking Get Details Button", "Details page NOT displayed", Status.FAIL );
				
			}
			else
				report.updateTestLog("Checking Get Details Button", "Get Details NOT displayed", Status.FAIL );
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking Get Details Button", "Get Details NOT displayed", Status.FAIL );
		}
	}
	
	/**Checks Add To Cart Button for Added Item in List for Not available item**/
	public void chkAddToCartInList() throws Exception
	{
		try{
			String varButton=driver.findElement(By.xpath(UIMapMyLowes.btnGetDetailslist)).getText();
			if(varButton.equalsIgnoreCase("Add to Cart"))
			{
				report.updateTestLog("Checking Add to Cart Button", "Add to Cart displayed", Status.PASS );
				ClickCustomize("xpath", UIMapMyLowes.btnGetDetailslist);
				Thread.sleep(7000);
				if(driver.findElement(By.xpath(UIMapMyLowes.webElmntAddedToCartFrmList)).getText().equals("Your item was successfully added to cart."))
					{
					
					report.updateTestLog("Clicking Add to Cart Button", "Item added to cart", Status.PASS );
					ClickCustomize("xpath", UIMapMyLowes.btnContinueShoppingLists);
					Thread.sleep(2000);
					chkAddToCartAfterEdit();
					}
				else
					report.updateTestLog("Clicking Add to Cart Button", "Item NOT added to cart", Status.FAIL );
				
			}
			else
				report.updateTestLog("Checking Add to Cart Button", "Add to Cart NOT displayed", Status.FAIL );
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking Add to Cart Button", "Add to Cart NOT displayed", Status.FAIL );
		}
	}
	
	/**Switches to grid view in Lists page**/
	public void switchListToGridView() throws Exception
	{
		ClickCustomize("xpath", UIMapMyLowes.lnkGridView);
	}
	
	/**Clicks on edit link and checks whether Get Details is disp[layed**/
	public void chkGetDetailsAfterEdit() throws Exception
	{
		ClickCustomize("linkText", "Edit");
		Thread.sleep(5000);
		try{boolean varbuttonDisp=driver.findElement(By.xpath(UIMapMyLowes.btnGetDetailslist)).isDisplayed();
		if(varbuttonDisp)
		{
		String varButton=driver.findElement(By.xpath(UIMapMyLowes.btnGetDetailslist)).getText();
		if(varButton.equalsIgnoreCase("Get Details"))
		{
			report.updateTestLog("Clicking Edit", "Get Details displayed", Status.PASS );
			ClickCustomize("xpath", UIMapMyLowes.btnGetDetailslist);
			if(driver.findElement(By.xpath(UIMapMyLowes.webElmntProductName)).isDisplayed())
			{report.updateTestLog("Clicking Get Details Button after Edit", "Details page displayed", Status.PASS );
			driver.navigate().back();
			selenium.waitForPageToLoad("20000");
			}
			else
			{
				report.updateTestLog("Clicking Get Details Button after Edit", "Details page NOT displayed", Status.FAIL );
				
			}
		}
		else
			report.updateTestLog("Clicking Edit", "Get Details displayed", Status.FAIL );
		}
		else
			report.updateTestLog("Clicking Edit", "Get Details NOT displayed", Status.FAIL );
		}
		catch(Exception e)
		{
			report.updateTestLog("Clicking Edit", "Get Details NOT displayed", Status.FAIL );
		}
	
	}
	
	/**Clicks on edit link and checks whether Add To cart is disp[layed**/
	public void chkAddToCartAfterEdit() throws Exception
	{
		ClickCustomize("linkText", "Edit");
		Thread.sleep(5000);
		try{boolean varbuttonDisp=driver.findElement(By.xpath(UIMapMyLowes.btnGetDetailslist)).isDisplayed();
		if(varbuttonDisp)
		{
		String varButton=driver.findElement(By.xpath(UIMapMyLowes.btnGetDetailslist)).getText();
		if(varButton.equalsIgnoreCase("Add to Cart"))
		{
			report.updateTestLog("Clicking Edit", "Add to Cart displayed", Status.PASS );
			ClickCustomize("xpath", UIMapMyLowes.btnGetDetailslist);
			Thread.sleep(7000);
			if(driver.findElement(By.xpath(UIMapMyLowes.webElmntAddedToCartFrmList)).getText().equals("Your item was successfully added to cart."))
			{
			
				report.updateTestLog("Clicking Add to Cart Button After Edit", "Item added to cart", Status.PASS );
				ClickCustomize("xpath", UIMapMyLowes.btnContinueShoppingLists);
				Thread.sleep(2000);
			}
			else
				report.updateTestLog("Clicking Add to Cart Button After Edit", "Item NOT added to cart", Status.PASS );
		}
		else
			report.updateTestLog("Clicking Edit", "Add to Cart displayed", Status.FAIL );
		}
		else
			report.updateTestLog("Clicking Edit", "Add to Cart NOT displayed", Status.FAIL );
		}
		catch(Exception e)
		{
			report.updateTestLog("Clicking Edit", "Add to Cart NOT displayed", Status.FAIL );
		}
	
	}
	
	/**checks whether correct Current Price and Was Price is displayed on Lists**/
	public void validateWasPriceInLists() throws Exception
	{
		String varCurrentPricePD=driver.findElement(By.xpath(UIMapMyLowes.txtPriceOfPrdInPDP)).getText();
		varCurrentPricePD=varCurrentPricePD.substring(1);
		System.out.println(varCurrentPricePD);
		String varWasPricePD=driver.findElement(By.xpath(UIMapMyLowes.lblWasPriceDetails)).getText();
		varWasPricePD=varWasPricePD.substring(6);
		System.out.println(varWasPricePD);
		addItemToList();
		String varCurrentPriceList=driver.findElement(By.xpath(UIMapMyLowes.lblCurrentPriceLists)).getText();
		varCurrentPriceList=varCurrentPriceList.substring(1);
		System.out.println(varCurrentPriceList);
		
		
		if(varCurrentPricePD.equals(varCurrentPriceList))
			report.updateTestLog("Checking Current Price in List", "Current Price in List displayed Correctly", Status.PASS);
		else
			report.updateTestLog("Checking Current Price in List", "Current Price in List NOT displayed Correctly", Status.FAIL);
		
		try{String varWasPriceLists=driver.findElement(By.xpath(UIMapMyLowes.lblWasPriceLists)).getText();
		String varWasPriceLists2=varWasPriceLists.substring(6);
		System.out.println(varWasPriceLists2);
		if(varWasPriceLists.contains("Was:") && varWasPriceLists2.equals(varWasPricePD))
			report.updateTestLog("Checking Was Price in List", "Was Price in List displayed Correctly", Status.PASS);
		else
			report.updateTestLog("Checking Was Price in List", "Was Price in List NOT displayed Correctly", Status.FAIL);
		
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking Was Price in List", "Was Price in List NOT displayed Correctly", Status.FAIL);
		}
	}
	
	/**Validates whether Add To drop-down is present for Gift Cards in Purchase History**/
	public void chkAddToForGCInPurchaseHistory() throws Exception
	{
		try{
			if(driver.findElement(By.className(UIMapMyLowes.drpDownSaveItemPurchaseHistory)).isDisplayed())
				report.updateTestLog("Checking Add To drop-down in Purchase Details", "Add To drop-down Displayed in Purchase Details", Status.FAIL);
			else
				report.updateTestLog("Checking Add To drop-down in Purchase Details", "Add To drop-down NOT Displayed in Purchase Details", Status.PASS);
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking Add To drop-down in Purchase Details", "Add To drop-down NOT Displayed in Purchase Details", Status.PASS);
		}
	}
	
	/**Navigates to Purchases**/
	public void navigatePurchases2() throws Exception
	{
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.id(UIMapMyLowes.lnkMyAccount));
		actions.moveToElement(menuHoverLink).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(2000);
		//WebElement subLink = driver.findElement(By.id(UIMapMyLowes.lnkHomeProfile));
		WebElement subLink = driver.findElement(By.partialLinkText("Purchases"));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		selenium.waitForPageToLoad("30000");
		
	}
	
	/**Clicks on an Order Nbr on Purchase History**/
	public void clickOrderNbrPurchaseHistory() throws Exception
	{
		System.out.println("Order Nbr:"+dataTable.getData("General_Data", "OrderNbr"));
		ClickCustomize("partialLinkText", dataTable.getData("General_Data", "OrderNbr"));
		selenium.waitForPageToLoad("20000");
	}
	
	
	/**Deactivates MLC**/
	public void deactivateMLC() throws Exception
	{
		ClickCustomize("partialLinkText", "Manage MyLowe's Card");
		selenium.waitForPageToLoad("20000");
		ClickCustomize("partialLinkText", "Deactivate");
		Thread.sleep(2000);
		ClickCustomize("xpath", UIMapMyLowes.btnDeactivateMLC);
		Thread.sleep(5000);
		if(selenium.isTextPresent("has been deactivated."))
			report.updateTestLog("Deactivating MLC", "MLC Deactivated", Status.PASS);
		else
			report.updateTestLog("Deactivating MLC", "MLC NOT Deactivated", Status.FAIL);
	}
	
	
	/**navigates to Instore Purchases**/
	public void navigateToInStore() throws Exception
	{
		try{driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseType)).click();}
			catch(Exception WebDriverException)
			{
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup","Handeled", Status.DONE);
				driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseType)).click();
			}
			Thread.sleep(1000);
			Select select = new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseType)));
			select.selectByVisibleText("In-Store");
			selenium.waitForPageToLoad("10000");
			driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate)).click();
			Thread.sleep(1000);
			Select select2 = new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate)));
			select2.selectByVisibleText("All");
			selenium.waitForPageToLoad("10000");
			
		
	}
	
	/**navigates to Instore Purchases-30Days**/
	public void navigateToInStoreDefault() throws Exception
	{
		try{driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseType)).click();}
			catch(Exception WebDriverException)
			{
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup","Handeled", Status.DONE);
				driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseType)).click();
			}
			Thread.sleep(1000);
			Select select = new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseType)));
			select.selectByVisibleText("In-Store");
			selenium.waitForPageToLoad("10000");
			
			
		
	}
	/**navigates to Online Purchases-30Days**/
	public void navigateToOnlineDefault() throws Exception
	{
		try{driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseType)).click();}
			catch(Exception WebDriverException)
			{
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup","Handeled", Status.DONE);
				driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseType)).click();
			}
			Thread.sleep(1000);
			Select select = new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseType)));
			select.selectByVisibleText("Online");
			selenium.waitForPageToLoad("10000");
			
			
		
	}
	
	/**Check message displayed below in store option when no mlc is attached to acct**/
	public void validateNoMLCInStoreMsg() throws Exception
	{
		String varMsg=driver.findElement(By.xpath(UIMapMyLowes.lblNoMLCInStoreMsg)).getText();
		System.out.println(varMsg);
		String varExp="Did you know you can see your in-store purchase history when you use a MyLowe's card?"+'\n'+"With a MyLowe's card, you can also:"+
				'\n'+"Attach other purchases to your history using information from a store receipt."+'\n'+"Add purchased items to your Home Profile."
				+'\n'+"Set Reminders for future purchases."+'\n'
				+"Request a MyLowe's Card"+'\n'+"Already have a MyLowe's card? Register your MyLowe's Card";
		System.out.println(varExp);
		if(varMsg.contains(varExp))
			report.updateTestLog("Checking No Purchases Message", "No Purchases Message displayed", Status.PASS);
		else
			report.updateTestLog("Checking No Purchases Message", "No Purchases Message NOT correctly displayed", Status.FAIL);
	}
	
	/**Requests for a MyLowes card**/
	public void requestMLCFromPurchases() throws Exception
	{
		ClickCustomize("linkText", "Request a MyLowe's Card");
		selenium.waitForPageToLoad("20000");
		driver.findElement(By.id(UIMapMyLowes.txtAddress1)).clear();
        driver.findElement(By.id(UIMapMyLowes.txtAddress1)).sendKeys(dataTable.getData("General_Data","Address1"));
        driver.findElement(By.id(UIMapMyLowes.txtCity)).clear();
        driver.findElement(By.id(UIMapMyLowes.txtCity)).sendKeys(dataTable.getData("General_Data","City"));
        new Select(driver.findElement(By.id(UIMapMyLowes.txtState))).selectByVisibleText(dataTable.getData("General_Data", "State"));
        Thread.sleep(1000);
        driver.findElement(By.id(UIMapMyLowes.txtZip)).clear();
        driver.findElement(By.id(UIMapMyLowes.txtZip)).sendKeys(dataTable.getData("General_Data","zipcode"));
        driver.findElement(By.id(UIMapMyLowes.btnCardRegSubmit)).click();
        Thread.sleep(3000);
        selenium.waitForPageToLoad("20000");
	}
	
	/**Adds Instore Purchase**/
	public void addInStorePurchase() throws Exception
	{
		ClickCustomize("xpath", UIMapMyLowes.btnAddPurchaseInStore);
		Thread.sleep(1000);
		new Select(driver.findElement(By.id(UIMapMyLowes.drpDownAddPurchsType))).selectByVisibleText("In-Store");
		Thread.sleep(2000);
		driver.findElement(By.id(UIMapMyLowes.txtTxnNo)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtTxnNo)).sendKeys(dataTable.getData("General_Data", "TransactionNbr"));
	    driver.findElement(By.id(UIMapMyLowes.txtPurDate)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtPurDate)).sendKeys(dataTable.getData("General_Data", "PurchaseDt"));
	    driver.findElement(By.xpath(UIMapMyLowes.txtPurPgTxt)).click();
	    driver.findElement(By.id(UIMapMyLowes.txtStoreNo)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtStoreNo)).sendKeys(dataTable.getData("General_Data", "StoreNbr"));
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnAddPurchaseSpan)).click();
	}
	
	/**Adds Instore Purchase**/
	public void addInStorePurchase2() throws Exception
	{
		
		new Select(driver.findElement(By.id(UIMapMyLowes.drpDownAddPurchsType))).selectByVisibleText("In-Store");
		Thread.sleep(2000);
		driver.findElement(By.id(UIMapMyLowes.txtTxnNo)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtTxnNo)).sendKeys(dataTable.getData("General_Data", "TransactionNbr"));
	    driver.findElement(By.id(UIMapMyLowes.txtPurDate)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtPurDate)).sendKeys(dataTable.getData("General_Data", "PurchaseDt"));
	    driver.findElement(By.xpath(UIMapMyLowes.txtPurPgTxt)).click();
	    driver.findElement(By.id(UIMapMyLowes.txtStoreNo)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtStoreNo)).sendKeys(dataTable.getData("General_Data", "StoreNbr"));
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnAddPurchaseSpan)).click();
	}
	
	
	/**checks if instore order added succesfully**/
	public void chkAddedInStoreSuccess() throws Exception
	{
		if(driver.findElement(By.xpath(UIMapMyLowes.txtPurchaseConfResults)).getText().
	    		equals("Your In-Store Purchase Results")){
	    			report.updateTestLog("Verifying the Instore Order search in Purchases ","Verification is successful", Status.PASS);
	    		}
	    else{
	    	report.updateTestLog("Verifying the Instore Order search in Purchases ","Verification is not successful", Status.FAIL);
	    	}
	}
	
	
	/**Check Existing Order error on adding existing Instore Order**/
	public void chkExistingOrderError() throws Exception
	{
		//add code to check error message
		
		
		
		//
		ClickCustomize("xpath", UIMapMyLowes.btnAddPurchaseInStore);
		Thread.sleep(1000);
	}
	
	
	/**Adds Online Purchase**/
	public void addOnlinePurchase() throws Exception
	{
		System.out.println("Clicking Add Purchase");
		ClickCustomize("xpath", UIMapMyLowes.btnAddPurchaseInStore);
		Thread.sleep(3000);
		new Select(driver.findElement(By.id(UIMapMyLowes.drpDownAddPurchsType))).selectByVisibleText("Online / Mobile");
		Thread.sleep(2000);
		driver.findElement(By.id(UIMapMyLowes.txtConfNo)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtConfNo)).sendKeys(dataTable.getData("General_Data","OrderNbr"));
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnAddPurchase)).click();
	    Thread.sleep(5000);
	    if(driver.findElement(By.xpath(UIMapMyLowes.txtPurchaseConfResults)).getText().
	    		equals("Results for Confirmation #"+dataTable.getData("General_Data","OrderNbr"))){
	    			report.updateTestLog("Verifying the Online Order search in Purchases ","Verification is successful", Status.PASS);
	    		}
	    else{
	    	report.updateTestLog("Verifying the Online Order search in Purchases ","Verification is not successful", Status.FAIL);
	    	}
	   
	}
	
	/**Adds Instore/special order Purchase**/
	public void addInstoreSpecialPurchase() throws Exception
	{
		ClickCustomize("xpath", UIMapMyLowes.btnAddPurchaseInStore);
		Thread.sleep(1000);
		new Select(driver.findElement(By.id(UIMapMyLowes.drpDownAddPurchsType))).selectByVisibleText("In-Store Special Order");
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.txtPONbr)).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtPONbr)).clear();
	    driver.findElement(By.xpath(UIMapMyLowes.txtPONbr)).sendKeys(dataTable.getData("General_Data","PONbr"));
	    
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnAddSpecialOrderPurchase)).click();
	    Thread.sleep(5000);
	    
	   
	}
	public void chkAddedInStoreSpecialSuccess()
	{
		if(driver.findElement(By.xpath(UIMapMyLowes.txtPurchaseConfResults)).getText().
	    		equals("Results for PO #"+dataTable.getData("General_Data","PONbr"))){
	    			report.updateTestLog("Verifying the PO search in Purchases ","Verification is successful", Status.PASS);
	    		}
	    else{
	    	report.updateTestLog("Verifying the PO search in Purchases ","Verification is not successful", Status.FAIL);
	    	}
	}
	
	/**Validates whether a web elemnt is displayed**/
	public void chkElementDisplayed(String identifierType, String identifier, String varElementDesc) throws Exception
	{
		try
		{
			if(identifierType.equals("id"))
			{
				if(driver.findElement(By.id(identifier)).isDisplayed())
					report.updateTestLog("Checking "+varElementDesc, varElementDesc+" Displayed", Status.PASS);
				else
					report.updateTestLog("Checking "+varElementDesc, varElementDesc+" NOT Displayed", Status.FAIL);
			}
			else if(identifierType.equals("xpath"))
			{
				if(driver.findElement(By.xpath(identifier)).isDisplayed())
					report.updateTestLog("Checking "+varElementDesc, varElementDesc+" Displayed", Status.PASS);
				else
					report.updateTestLog("Checking "+varElementDesc, varElementDesc+" NOT Displayed", Status.FAIL);
			}
			else if(identifierType.equals("cssSelector"))
			{
				if(driver.findElement(By.cssSelector(identifier)).isDisplayed())
					report.updateTestLog("Checking "+varElementDesc, varElementDesc+" Displayed", Status.PASS);
				else
					report.updateTestLog("Checking "+varElementDesc, varElementDesc+" NOT Displayed", Status.FAIL);
			}
			else if(identifierType.equals("partialLinkText"))
			{
				if(driver.findElement(By.partialLinkText(identifier)).isDisplayed())
					report.updateTestLog("Checking "+varElementDesc, varElementDesc+" Displayed", Status.PASS);
				else
					report.updateTestLog("Checking "+varElementDesc, varElementDesc+" NOT Displayed", Status.FAIL);
			}
				
			
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking "+varElementDesc, varElementDesc+" NOT Displayed", Status.FAIL);
		}
	}
	
	/**validates Add Purchase for InSTore purchases**/
	public void validateAddPurchaseForInStore() throws Exception
	{
		ClickCustomize("xpath", UIMapMyLowes.btnAddPurchaseInStore);
		Thread.sleep(1000);
		new Select(driver.findElement(By.id(UIMapMyLowes.drpDownAddPurchsType))).selectByVisibleText("In-Store");
		Thread.sleep(2000);
		fc.chkText(UIMapMyLowes.lblTransaction, "Transaction Number:");
		fc.chkText(UIMapMyLowes.lblPurchaseDt, "Purchase Date:");
		fc.chkText(UIMapMyLowes.lblStoreNbr, "Store Number:");
		chkElementDisplayed("id",UIMapMyLowes.txtTxnNo,"Transaction Number field");
		chkElementDisplayed("id",UIMapMyLowes.txtPurDate,"Purchase date field");
		chkElementDisplayed("id",UIMapMyLowes.txtStoreNo,"Store Number field");
		chkElementDisplayed("xpath",UIMapMyLowes.lnkTransactionHelp,"Transaction Number Help");
		chkElementDisplayed("xpath",UIMapMyLowes.lnkPurchaseDtHelp,"Purchase Date Help");
		chkElementDisplayed("xpath",UIMapMyLowes.lnkStoreNbrHelp,"Store Number Help");
		chkElementDisplayed("xpath",UIMapMyLowes.lnkPurchaseDtPicker,"Purchase Date Picker");
		ClickCustomize("xpath", UIMapMyLowes.lnkTransactionHelp);
		Thread.sleep(3000);
		int varCount=fc.countWebElement("html/body/div");
		System.out.println(varCount);
		chkElementDisplayed("xpath","//div["+varCount+"]","Transaction Number Help Popup");
		chkElementDisplayed("xpath","//div["+varCount+"]/div[2]/img","Image In Transaction Number Help Popup");
		chkElementDisplayed("xpath","//div["+varCount+"]/div[1]/a/span","Close In Transaction Number Help Popup");
		ClickCustomize("xpath", "//div["+varCount+"]/div[1]/a/span");
		Thread.sleep(1000);
		
		ClickCustomize("xpath", UIMapMyLowes.lnkPurchaseDtHelp);
		Thread.sleep(3000);
		varCount=fc.countWebElement("html/body/div");
		System.out.println(varCount);
		chkElementDisplayed("xpath","//div["+varCount+"]","Purchase date Help Popup");
		chkElementDisplayed("xpath","//div["+varCount+"]/div[2]/img","Image In Purchase date Help Popup");
		chkElementDisplayed("xpath","//div["+varCount+"]/div[1]/a/span","Close In Purchase date Help Popup");
		ClickCustomize("xpath", "//div["+varCount+"]/div[1]/a/span");
		Thread.sleep(1000);
		
		ClickCustomize("xpath", UIMapMyLowes.lnkPurchaseDtHelp);
		Thread.sleep(3000);
		varCount=fc.countWebElement("html/body/div");
		System.out.println(varCount);
		chkElementDisplayed("xpath","//div["+varCount+"]","Store Number Help Popup");
		chkElementDisplayed("xpath","//div["+varCount+"]/div[2]/img","Image In Store Number Help Popup");
		chkElementDisplayed("xpath","//div["+varCount+"]/div[1]/a/span","Close In Store Number Help Popup");
		ClickCustomize("xpath", "//div["+varCount+"]/div[1]/a/span");
		Thread.sleep(1000);
		chkElementDisplayed("cssSelector", UIMapMyLowes.btnAddPurchaseSpan,"Add Purchase");
		chkElementDisplayed("partialLinkText", "Close","Close");
	}
	
	/**validates Add Purchase for InSTore purchases**/
	public void validateAddPurchaseFieldsForInStore() throws Exception
	{
		ClickCustomize("xpath", UIMapMyLowes.btnAddPurchaseInStore);
		Thread.sleep(1000);
		new Select(driver.findElement(By.id(UIMapMyLowes.drpDownAddPurchsType))).selectByVisibleText("In-Store");
		Thread.sleep(2000);
		fc.chkText(UIMapMyLowes.lblTransaction, "Transaction Number:");
		fc.chkText(UIMapMyLowes.lblPurchaseDt, "Purchase Date:");
		fc.chkText(UIMapMyLowes.lblStoreNbr, "Store Number:");
		chkElementDisplayed("id",UIMapMyLowes.txtTxnNo,"Transaction Number field");
		chkElementDisplayed("id",UIMapMyLowes.txtPurDate,"Purchase date field");
		chkElementDisplayed("id",UIMapMyLowes.txtStoreNo,"Store Number field");
		
	}
	
	/**Checks MAP item in  product list**/
	public void checkMAPInPL() throws Exception
	{
		String varId=dataTable.getData("General_Data", "ItemId");
		
		fc.chkText("//*[@id='"+varId+"']/div/div[3]/p[1]/strong", "View Price in Cart");
		chkElementDisplayed("xpath","//*[@id='"+varId+"']/div/div[3]/p[1]/a/img","MAP Contextual Help");
		String varMSRP=driver.findElement(By.xpath("//*[@id='"+varId+"']/div/div[3]/div[3]/p")).getText();
		System.out.println(varMSRP);
		if(varMSRP.contains("MSRP: $"))
			report.updateTestLog("Checking MSRP", "MSRP displayed", Status.PASS);
		else
			report.updateTestLog("Checking MSRP", "MSRP NOT displayed", Status.FAIL);
		
		
	}
	
	/**Checks MAP item in Details**/
	public void checkMAPInPD() throws Exception
	{
		fc.chkText(UIMapMyLowes.lblViewPrcInCart, "View Price in Cart");
		chkElementDisplayed("xpath",UIMapMyLowes.lnkMAPHelp,"MAP Contextual Help In Details");
		String varMSRP=driver.findElement(By.xpath(UIMapMyLowes.lblMSRP)).getText();
		System.out.println(varMSRP);
		if(varMSRP.contains("MSRP:$"))
			report.updateTestLog("Checking MSRP In Details", "MSRP displayed", Status.PASS);
		else
			report.updateTestLog("Checking MSRP In Details", "MSRP NOT displayed", Status.FAIL);
		
		
	}
	
	/**Checks MAP item in List**/
	public void checkMAPInLIST() throws Exception
	{
		fc.chkText(UIMapMyLowes.lblCurrentPriceLists, "View Price in Cart");
		chkElementDisplayed("xpath",UIMapMyLowes.lnkMAPHelpList,"MAP Contextual Help In List");
		String varMSRP=driver.findElement(By.xpath(UIMapMyLowes.lblMSRPList)).getText();
		System.out.println(varMSRP);
		if(varMSRP.contains("MSRP: $"))
			report.updateTestLog("Checking MSRP In List", "MSRP displayed", Status.PASS);
		else
			report.updateTestLog("Checking MSRP In List", "MSRP NOT displayed", Status.FAIL);
		ClickCustomize("xpath", UIMapMyLowes.lnkMAPHelpList);
		Thread.sleep(1000);
		chkElementDisplayed("id",UIMapMyLowes.webElmntMSRPHelpPopup,"MAP Help Popup In List");
		//ClickCustomize("xpath", UIMapMyLowes.lnkMapPopupClose);
		//Thread.sleep(1000);
		driver.navigate().refresh();
		selenium.waitForPageToLoad("20000");;
		ClickCustomize("xpath", UIMapMyLowes.btnGetDetailslist);
		Thread.sleep(7000);
		if(driver.findElement(By.xpath(UIMapMyLowes.webElmntAddedToCartFrmList)).getText().equals("Your item was successfully added to cart."))
			{
			
			report.updateTestLog("Clicking Add to Cart Button", "Item added to cart", Status.PASS );
			ClickCustomize("xpath", UIMapMyLowes.btnContinueShoppingLists);
			Thread.sleep(2000);
			chkAddToCartAfterEdit();
			}
		else
			report.updateTestLog("Clicking Add to Cart Button", "Item NOT added to cart", Status.FAIL );
		
	}
	
	/**navigates to Help**/
	public void clickHelp2() throws Exception
	{
		ClickCustomize("linkText", "Help");
		selenium.waitForPageToLoad("20000");
		System.out.println(selenium.getTitle());
		if(selenium.getTitle().equals("Help"))
			report.updateTestLog("Clicking Help", "Help displayed", Status.PASS);
		else
			report.updateTestLog("Clicking Help", "Help displayed", Status.FAIL);
	}
	
	/**clicks Lowes.com FAQs on help page**/
	public void clickLowesDotComFAQs() throws Exception
	{
		ClickCustomize("xpath", UIMapMyLowes.lnkLowesDtComFAQs);
		selenium.waitForPageToLoad("20000");
		if(selenium.getTitle().equals("MyLowe's FAQs"))
			report.updateTestLog("Clicking Lowes.com Account-FAQs", "FAQs displayed", Status.PASS);
		else
			report.updateTestLog("Clicking Lowes.com Account-FAQs", "FAQs displayed", Status.FAIL);
	}
	
	/**Selects How do I add a past purchase to my purchase history? from FAQ's pg**/
	public void clickFAQAddingPastPurchs() throws Exception
	{
		ClickCustomize("xpath", UIMapMyLowes.lnkMyLowesCard);
		Thread.sleep(2000);
		ClickCustomize("linkText", "How do I add a past purchase to my purchase history?");
		selenium.waitForPageToLoad("20000");
		fc.chkText(UIMapProductSearch.webElmntBrdCrumbsLvl4, "How do I add a past purchase to my purchase history?");
		
	}
	
	/**Checks whether FAQ-How do I add a past purchase to my purchase history? content is updated**/
	public void chkFAQAddingPastPurchsContent() throws Exception
	{
		fc.checkTextContains(UIMapMyLowes.lblAddingInStorePurchsPara1, "From the Purchases section of your account, click the Add Purchase button.", "Adding In-Store Purchases");
		fc.checkTextContains(UIMapMyLowes.lblAddingInStorePurchsPara2, "You'll then be asked to provide the transaction number", "Adding In-Store Purchases");
		fc.checkTextContains(UIMapMyLowes.lblAddingInStorePurchsPara2, "Once you've entered that information, click the Add Purchase button.", "Adding In-Store Purchases");
		fc.chkText(UIMapMyLowes.lblFAQAddingPastPurchsHeading2, "Viewing Online / Mobile Purchases");
		fc.checkTextContains(UIMapMyLowes.lblViewOlMobilePurchsPara1, "From the Purchases section of your account, click the Add Purchase button.", "Viewing Online / Mobile Purchases");
		fc.checkTextContains(UIMapMyLowes.lblViewOlMobilePurchsPara2, "select the Online / Mobile option", "Viewing Online / Mobile Purchases");
		fc.checkTextContains(UIMapMyLowes.lblViewOlMobilePurchsPara2, "Once you've entered that information, click the Add Purchase button.", "Viewing Online / Mobile Purchases");
		fc.chkText(UIMapMyLowes.lblFAQAddingPastPurchsHeading3, "Viewing In-Store Special Orders");
		
		
	}
	/**Checks mylowes card registration links**/
	public void chkMLCRegistrationAndRequestLinks() throws Exception
	{
		String varURL=driver.getCurrentUrl();
		ClickCustomize("linkText", "Request a MyLowe's Card");
		selenium.waitForPageToLoad("20000");
		fc.chkPagetitle("Request a MyLowe's Card");
		driver.get(varURL);
		selenium.waitForPageToLoad("20000");
		ClickCustomize("linkText", "Register your MyLowe's Card");
		selenium.waitForPageToLoad("20000");
		fc.chkPagetitle("Register a MyLowe's Card");
	}
	
	/**sets filter as ALL in date-filter in Purchases**/
	public void setDateAllPurchases() throws Exception
	{
		driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate)).click();
		Thread.sleep(1000);
		Select select2 = new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate)));
		select2.selectByVisibleText("All");
		selenium.waitForPageToLoad("10000");
	}
	
	/**Checks Add To in Purchases-Item View**/
	public void checkAddToItemViewPurchases() throws Exception
	{
		ClickCustomize("xpath", UIMapMyLowes.drpDownAddToItemViewAll);
		Thread.sleep(1000);
		//adding to Home Profile
		ClickCustomize("xpath", UIMapMyLowes.lnkAddToHPItemViewPurchases);
		Thread.sleep(5000);
		if(selenium.isTextPresent("item wll be saved in the Home Profile, If the user has no Home Profile set up yet, system will display a message to prompt user to create Home Profile."))
		{
		int divCount=fc.countWebElement("html/body/div");
		ClickCustomize("xpath", "html/body/div["+divCount+"]/div/a/span");
		Thread.sleep(2000);
		ClickCustomize("xpath", UIMapMyLowes.drpDownAddToInStorePurchsDetails);
		}
		ClickCustomize("xpath", UIMapMyLowes.drpDownAddToItemViewAll);
		String varClass=driver.findElement(By.xpath(UIMapMyLowes.lnkAddToHPItemViewPurchasesLst)).getAttribute("class");
		if(varClass.equals("active"))
			report.updateTestLog("Adding item to Home Profile in Item View", "Item Added to HP", Status.PASS);
		else
			report.updateTestLog("Adding item to Home Profile in Item View", "Item NOT Added to HP", Status.FAIL);
		if(driver.findElement(By.xpath(UIMapMyLowes.webElmntAddToHPItemViewCheck)).isDisplayed())
			report.updateTestLog("Adding item to Home Profile in Item View", "Item Added to HP-Check displayed", Status.PASS);
		else
			report.updateTestLog("Adding item to Home Profile in Item View", "Item NOT Added to HP-Check NOT displayed", Status.FAIL);
		
		//adding to List
				ClickCustomize("xpath", UIMapMyLowes.lnkAddToListItemViewPurchases);
				Thread.sleep(5000);
				ClickCustomize("xpath", UIMapMyLowes.drpDownAddToItemViewAll);
				varClass=driver.findElement(By.xpath(UIMapMyLowes.lnkAddToListItemViewPurchasesLst)).getAttribute("class");
				if(varClass.equals("active"))
					report.updateTestLog("Adding item to List in Item View", "Item Added to List", Status.PASS);
				else
					report.updateTestLog("Adding item to List in Item View", "Item NOT Added to List", Status.FAIL);
				if(driver.findElement(By.xpath(UIMapMyLowes.webElmntAddToListItemViewCheck)).isDisplayed())
					report.updateTestLog("Adding item to List in Item View", "Item Added to List-Check displayed", Status.PASS);
				else
					report.updateTestLog("Adding item to List in Item View", "Item NOT Added to List-Check NOT displayed", Status.FAIL);
				
		//adding Reminder
				ClickCustomize("xpath", UIMapMyLowes.lnkReminderItemViewPurchases);
				Thread.sleep(5000);
				int varCount=fc.countWebElement("html/body/div");
				System.out.println(varCount);
				chkElementDisplayed("xpath","//div["+varCount+"]","Set Reminder Popup");
				driver.findElement(By.cssSelector("img.ui-datepicker-trigger"))
				.click();
				DateFormat dateFormat = new SimpleDateFormat("d");
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DAY_OF_YEAR, 1);
				Date tomorrow = calendar.getTime();
				String varDate=dateFormat.format(tomorrow);
				System.out.println(varDate);
				driver.findElement(By.linkText(varDate)).click();
				Thread.sleep(1000);
				driver.findElement(
						By.cssSelector("a.button.reminder_notes_save_continue > span"))
						.click();
			Thread.sleep(5000);
			fc.chkText(UIMapMyLowes.lblReminderSetItemView, "Reminder Set");
			
			if(driver.findElement(By.xpath(UIMapMyLowes.webElmntReminderItemViewCheck)).isDisplayed())
				report.updateTestLog("Adding Reminder in Item View", "Reminder Added-Check displayed", Status.PASS);
			else
				report.updateTestLog("Adding Reminder in Item View", "Reminder NOT Added -Check NOT displayed", Status.FAIL);
	}
	
	public void purchaseSwitchPurchaseView() throws Exception
	{
		
		driver.findElement(By.xpath(UIMapMyLowes.lnkPurchaseView)).click();
		Thread.sleep(5000);
		
		if(driver.findElement(By.id("orderView")).isDisplayed())
		{
			report.updateTestLog("Switching to Purchase View","switched to Purchase View" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Switching to Purchase View","NOT switched to Purchase View" ,Status.FAIL);
		}
		//*[@id='itemView']/ul[1]/li/div[3]/div[1]/span
	}
	
	/**selects a specific purchase  from all  purchases displayed in Purchase View**/
	public void selectPurchase() throws Exception
	{
		int varPgCount=Integer.valueOf(driver.findElement(By.xpath(UIMapMyLowes.lnkPurchaseTotalPage)).getText());
		int i=0;
		int j;
		int varFound=0;
		for(i=1;i<=varPgCount;i++)
		{
			int varCount=fc.countWebElement(UIMapMyLowes.webElmntItemViewOrdersOnPg);
			
			System.out.println("Checking Page:"+i);
			for(j=1;j<=varCount;j++)
					{
				System.out.println("Checking Order:"+j);
				System.out.println(dataTable.getData("General_Data", "OrderNbr"));
				String varOrderNbrDisp=driver.findElement(By.xpath("//*[@id='orderView']/tbody/tr["+j+"]/td[2]/a")).getText();
				System.out.println(varOrderNbrDisp);
				if(varOrderNbrDisp.equals(dataTable.getData("General_Data", "OrderNbr")))
				{
					ClickCustomize("linkText",dataTable.getData("General_Data", "OrderNbr"));
					selenium.waitForPageToLoad("20000");
					varFound=1;
					dataTable.putData("General_Data", "OrderNbrOnPg", String.valueOf(j));
					break;
				}
				if(j==varCount)	
				{
					System.out.println("Not on Page:"+i);
					ClickCustomize("linkText", "Next");
				}
				
					}
			if(varFound==1)
				break;
			
		}
		if(i>varPgCount)
			report.updateTestLog("Finding Online Order Nbr", "Online Order not displayed in any page", Status.FAIL);
		System.out.println("Pg Nbr:"+i);
		dataTable.putData("General_Data", "PgNbr", String.valueOf(i));
		
	}
	
	/**Checks Add To in Purchase Details for Online Purchase**/
	public void checkAddToOnlinePurchaseDetails() throws Exception
	{
		ClickCustomize("xpath", UIMapMyLowes.drpDownAddToOnlinePurchsDetails);
		Thread.sleep(1000);
		//adding to Home Profile
		ClickCustomize("xpath", UIMapMyLowes.lnkAddToHPPuchaseDetails+"/a/span[2]");
		Thread.sleep(5000);
		if(selenium.isTextPresent("item wll be saved in the Home Profile, If the user has no Home Profile set up yet, system will display a message to prompt user to create Home Profile."))
		{
		int divCount=fc.countWebElement("html/body/div");
		ClickCustomize("xpath", "html/body/div["+divCount+"]/div/a/span");
		Thread.sleep(2000);
		ClickCustomize("xpath", UIMapMyLowes.drpDownAddToInStorePurchsDetails);
		}
		ClickCustomize("xpath", UIMapMyLowes.drpDownAddToOnlinePurchsDetails);
		String varClass=driver.findElement(By.xpath(UIMapMyLowes.lnkAddToHPPuchaseDetails)).getAttribute("class");
		if(varClass.equals("active"))
			report.updateTestLog("Adding Online order-item to Home Profile in Purchase View", "Item Added to HP", Status.PASS);
		else
			report.updateTestLog("Adding Online order-item to Home Profile in Purchase View", "Item NOT Added to HP", Status.FAIL);
		if(driver.findElement(By.xpath(UIMapMyLowes.lnkAddToHPPuchaseDetails+"/a/span[1]")).isDisplayed())
			report.updateTestLog("Adding Online order-item to Home Profile in Purchase View", "Item Added to HP-Check displayed", Status.PASS);
		else
			report.updateTestLog("Adding Online order-item to Home Profile in Purchase View", "Item NOT Added to HP-Check NOT displayed", Status.FAIL);
		
		//adding to List
				ClickCustomize("xpath", UIMapMyLowes.lnkAddToListPuchaseDetails+"/a/span[2]");
				Thread.sleep(5000);
				ClickCustomize("xpath", UIMapMyLowes.drpDownAddToOnlinePurchsDetails);
				varClass=driver.findElement(By.xpath(UIMapMyLowes.lnkAddToListPuchaseDetails)).getAttribute("class");
				if(varClass.equals("active"))
					report.updateTestLog("Adding Online order-item to List in Purchase View", "Item Added to List", Status.PASS);
				else
					report.updateTestLog("Adding Online order-item to List in Purchase View", "Item NOT Added to List", Status.FAIL);
				if(driver.findElement(By.xpath(UIMapMyLowes.lnkAddToListPuchaseDetails+"/a/span[1]")).isDisplayed())
					report.updateTestLog("Adding Online order-item to List in Purchase View", "Item Added to List-Check displayed", Status.PASS);
				else
					report.updateTestLog("Adding Online order-item to List in Purchase View", "Item NOT Added to List-Check NOT displayed", Status.FAIL);
				
		//adding Reminder
				ClickCustomize("xpath", UIMapMyLowes.lnkReminderPuchaseDetails+"/a/span[2]");
				Thread.sleep(5000);
				
				try{
				driver.findElement(By.cssSelector("img.ui-datepicker-trigger"))
				.click();
				DateFormat dateFormat = new SimpleDateFormat("d");
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DAY_OF_YEAR, 1);
				Date tomorrow = calendar.getTime();
				String varDate=dateFormat.format(tomorrow);
				System.out.println(varDate);
				driver.findElement(By.linkText(varDate)).click();
				Thread.sleep(1000);
				driver.findElement(
						By.cssSelector("a.button.reminder_notes_save_continue > span"))
						.click();
			Thread.sleep(5000);
			fc.chkText(UIMapMyLowes.lnkReminderPuchaseDetails+"/a/span", "Reminder Set");
			
			if(driver.findElement(By.xpath(UIMapMyLowes.lnkReminderPuchaseDetails+"/a/span/img")).isDisplayed())
				report.updateTestLog("Adding Reminder in Item View", "Reminder Added-Check displayed", Status.PASS);
			else
				report.updateTestLog("Adding Reminder in Item View", "Reminder NOT Added -Check NOT displayed", Status.FAIL);
				}
				catch(Exception e)
				{
					report.updateTestLog("Adding Reminder in Item View", "Reminder not addeds", Status.FAIL);
				}
			ClickCustomize("linkText", "Back to Purchases");
			selenium.waitForPageToLoad("20000");
	}
	
	/**Checks Add To in Purchase Details for Instore Purchase**/
	public void checkAddToInStorePurchaseDetails() throws Exception
	{
		ClickCustomize("xpath", UIMapMyLowes.drpDownAddToInStorePurchsDetails);
		Thread.sleep(1000);
		//adding to Home Profile
		ClickCustomize("xpath", UIMapMyLowes.lnkAddToHPPuchaseDetailsIS+"/a/span[2]");
		Thread.sleep(5000);
		if(selenium.isTextPresent("item wll be saved in the Home Profile, If the user has no Home Profile set up yet, system will display a message to prompt user to create Home Profile."))
		{
		int divCount=fc.countWebElement("html/body/div");
		ClickCustomize("xpath", "html/body/div["+divCount+"]/div/a/span");
		Thread.sleep(2000);
		ClickCustomize("xpath", UIMapMyLowes.drpDownAddToInStorePurchsDetails);
		}
		ClickCustomize("xpath", UIMapMyLowes.drpDownAddToInStorePurchsDetails);
		String varClass=driver.findElement(By.xpath(UIMapMyLowes.lnkAddToHPPuchaseDetailsIS)).getAttribute("class");
		if(varClass.equals("active"))
			report.updateTestLog("Adding Online order-item to Home Profile in Purchase View", "Item Added to HP", Status.PASS);
		else
			report.updateTestLog("Adding Online order-item to Home Profile in Purchase View", "Item NOT Added to HP", Status.FAIL);
		if(driver.findElement(By.xpath(UIMapMyLowes.lnkAddToHPPuchaseDetailsIS+"/a/span[1]")).isDisplayed())
			report.updateTestLog("Adding Online order-item to Home Profile in Purchase View", "Item Added to HP-Check displayed", Status.PASS);
		else
			report.updateTestLog("Adding Online order-item to Home Profile in Purchase View", "Item NOT Added to HP-Check NOT displayed", Status.FAIL);
		
		//adding to List
				ClickCustomize("xpath", UIMapMyLowes.lnkAddToListPuchaseDetailsIS+"/a/span[2]");
				Thread.sleep(5000);
				ClickCustomize("xpath", UIMapMyLowes.drpDownAddToInStorePurchsDetails);
				varClass=driver.findElement(By.xpath(UIMapMyLowes.lnkAddToListPuchaseDetailsIS)).getAttribute("class");
				if(varClass.equals("active"))
					report.updateTestLog("Adding Online order-item to List in Purchase View", "Item Added to List", Status.PASS);
				else
					report.updateTestLog("Adding Online order-item to List in Purchase View", "Item NOT Added to List", Status.FAIL);
				if(driver.findElement(By.xpath(UIMapMyLowes.lnkAddToListPuchaseDetailsIS+"/a/span[1]")).isDisplayed())
					report.updateTestLog("Adding Online order-item to List in Purchase View", "Item Added to List-Check displayed", Status.PASS);
				else
					report.updateTestLog("Adding Online order-item to List in Purchase View", "Item NOT Added to List-Check NOT displayed", Status.FAIL);
				
		//adding Reminder
				ClickCustomize("xpath", UIMapMyLowes.lnkReminderPuchaseDetailsIS+"/a/span[2]");
				Thread.sleep(5000);
				try{
				driver.findElement(By.cssSelector("img.ui-datepicker-trigger"))
				.click();
				DateFormat dateFormat = new SimpleDateFormat("d");
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DAY_OF_YEAR, 1);
				Date tomorrow = calendar.getTime();
				String varDate=dateFormat.format(tomorrow);
				System.out.println(varDate);
				driver.findElement(By.linkText(varDate)).click();
				Thread.sleep(1000);
				driver.findElement(
						By.cssSelector("a.button.reminder_notes_save_continue > span"))
						.click();
			Thread.sleep(5000);
			fc.chkText(UIMapMyLowes.lnkReminderPuchaseDetailsIS+"/a/span", "Reminder Set");
				
			if(driver.findElement(By.xpath(UIMapMyLowes.lnkReminderPuchaseDetailsIS+"/a/span/img")).isDisplayed())
				report.updateTestLog("Adding Reminder in Item View", "Reminder Added-Check displayed", Status.PASS);
			else
				report.updateTestLog("Adding Reminder in Item View", "Reminder NOT Added -Check NOT displayed", Status.FAIL);
				}
				catch(Exception e)
				{
					report.updateTestLog("Adding Reminder in Item View", "Reminder NOT Added", Status.FAIL);
				}
	}
	
	/**Finds a purchase**/
	public void findPurchase() throws Exception
	{
		fc.chkPagetitle("Find Purchase");
		driver.findElement(By.id(UIMapCheckOut.txtOrderSearch)).sendKeys(dataTable.getData("General_Data", "OrderNbr"));
		 driver.findElement(By.id(UIMapCheckOut.txtOrderSearch)).sendKeys(Keys.ENTER);
		 selenium.waitForPageToLoad("20000");
		 
	}
	
	/**Checks Add To in Purchase Details for Online Purchase for AZ User**/
	public void checkAddToOnlinePurchaseDetailsAZ() throws Exception
	{
		ClickCustomize("xpath", UIMapMyLowes.drpDownAddToOnlinePurchsDetails);
		Thread.sleep(1000);
		//adding to Home Profile
		ClickCustomize("xpath", UIMapMyLowes.lnkAddToHPPuchaseDetails+"/a/span[2]");
		Thread.sleep(2000);
		selenium.waitForPageToLoad("20000");
		if(selenium.isElementPresent(UIMapFunctionalComponents.webElmntLoginPopup))
		{
			report.updateTestLog("Adding Online order-item to Home Profile for Not Logged In User", "Login Popup displayed", Status.PASS);
			
		}
		else
			report.updateTestLog("Adding Online order-item to Home Profile for Not Logged In User", "Login Popup NOT displayed", Status.FAIL);
		driver.navigate().refresh();
		selenium.waitForPageToLoad("20000");
		//adding to List
		ClickCustomize("xpath", UIMapMyLowes.drpDownAddToOnlinePurchsDetails);
		Thread.sleep(1000);		
		ClickCustomize("xpath", UIMapMyLowes.lnkAddToListPuchaseDetails+"/a/span[2]");
		Thread.sleep(2000);
		selenium.waitForPageToLoad("20000");
		if(selenium.isElementPresent(UIMapFunctionalComponents.webElmntLoginPopup))
		{
			report.updateTestLog("Adding Online order-item to List for Not Logged In User", "Login Popup displayed", Status.PASS);
			
		}
		else
			report.updateTestLog("Adding Online order-item to List for Not Logged In User", "Login Popup NOT displayed", Status.FAIL);
		driver.navigate().refresh();
		selenium.waitForPageToLoad("20000");	
		//adding Reminder
		ClickCustomize("xpath", UIMapMyLowes.drpDownAddToOnlinePurchsDetails);
		Thread.sleep(1000);		
		ClickCustomize("xpath", UIMapMyLowes.lnkReminderPuchaseDetails+"/a/span[2]");
				Thread.sleep(2000);
				chkElementDisplayed("partialLinkText", "Learn more about Reminders.", "Learn more about Reminders.");
		
				ClickCustomize("linkText", "Continue");
				Thread.sleep(4000);
				ClickCustomize("xpath", UIMapMyLowes.lnkSignInReminderPopup);
				Thread.sleep(2000);
				selenium.waitForPageToLoad("20000");
				driver.findElement(By.id(UIMapFunctionalComponents.txtUserName)).sendKeys(dataTable.getData("General_Data","email"));
				driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(dataTable.getData("General_Data", "password"));
				driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(Keys.ENTER);
				//driver.findElement(By.id("GoYourAccount")).click();		
				selenium.waitForPageToLoad("20000");
				
				
	}
	
	public void storeAddrssForMLCReplacement() throws Exception
	{
		String varAddress1=dataTable.getData("General_Data", "BillAddress1")+", "+dataTable.getData("General_Data", "BillCity")+
				", "+dataTable.getData("General_Data", "BillStateShortForm")+"  "+dataTable.getData("General_Data", "Billzipcode");
		System.out.println(varAddress1);
		String varAddress2=dataTable.getData("General_Data", "Address1")+", "+dataTable.getData("General_Data", "City")+
				", "+dataTable.getData("General_Data", "StateShortForm")+"  "+dataTable.getData("General_Data", "zipcode");
		System.out.println(varAddress2);
		dataTable.putData("General_Data", "SavedAdd1", varAddress1);
		dataTable.putData("General_Data", "SavedAdd2", varAddress2);
	}
	
	/**checks addresses displayed in MLC Replacement**/
	public void chkAddressMlcReplacement() throws Exception 
	{
		ClickCustomize("partialLinkText", "Manage MyLowe's Card");
		selenium.waitForPageToLoad("20000");
		ClickCustomize("partialLinkText", "Request Replacement");
		Thread.sleep(2000);
		String varAdd1=driver.findElement(By.xpath(UIMapMyLowes.webElmntMLCRplcmntAddressValue1)).getText();
		String varAdd2=driver.findElement(By.xpath(UIMapMyLowes.webElmntMLCRplcmntAddressValue2)).getText();
		System.out.println(varAdd1);
		System.out.println(varAdd2);
		if(varAdd1.trim().equals(dataTable.getData("General_Data", "SavedAdd1")) && varAdd2.trim().equals(dataTable.getData("General_Data", "SavedAdd2")))
			{report.updateTestLog("Checking addresses", "Addresses displayed without double commas", Status.PASS);
			new Select(driver.findElement(By.id(UIMapMyLowes.drpDownSavedAddrss))).selectByVisibleText(varAdd1);
			Thread.sleep(2000);
			varAdd1=driver.findElement(By.xpath(UIMapMyLowes.webElmntMLCRplcmntAddressValue1)).getText();
			varAdd2=driver.findElement(By.xpath(UIMapMyLowes.webElmntMLCRplcmntAddressValue2)).getText();
			
			if(varAdd1.trim().equals(dataTable.getData("General_Data", "SavedAdd1")) && varAdd2.trim().equals(dataTable.getData("General_Data", "SavedAdd2")))
			{
				report.updateTestLog("Checking addresses after selecting an address", "Addresses displayed without double commas", Status.PASS);
			}
			else
				report.updateTestLog("Checking addresses", "Addresses displayed Incorrectly", Status.FAIL);
			}
		else
			report.updateTestLog("Checking addresses", "Addresses displayed Incorrectly", Status.FAIL);
	}
	
	/**navigates to reminders**/
	public void navigateReminders() throws Exception
	{
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.id(UIMapMyLowes.lnkMyAccount));
		actions.moveToElement(menuHoverLink).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(2000);
		//WebElement subLink = driver.findElement(By.id(UIMapMyLowes.lnkHomeProfile));
		WebElement subLink = driver.findElement(By.partialLinkText("Reminders"));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		selenium.waitForPageToLoad("30000");
		
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.lblBreadCrumb3)).getText();
		System.out.println(varMyLowes);
		
		if (varMyLowes.contains("Reminders")) {
			report.updateTestLog("Clicking Your Account link-Reminders",
					"Reminders page displayed", Status.PASS);
		} else {
			report.updateTestLog("Clicking Your Account link-Reminders",
					"Reminders page NOT displayed", Status.FAIL);
		}
	}
	/**Adds first reminder for an acct for an item in Purchase details**/
	public void addReminderFrmPurchaseDetails() throws Exception
	{
		ClickCustomize("xpath", UIMapMyLowes.drpDownAddToOnlinePurchsDetails);
		Thread.sleep(1000);
		
				
		//adding Reminder
				ClickCustomize("xpath", UIMapMyLowes.lnkReminderPuchaseDetails+"/a/span[2]");
				Thread.sleep(5000);
				
				try{
					if(selenium.isTextPresent("Continue"))
					{
						ClickCustomize("linkText", "Continue");
						Thread.sleep(1000);
					}
				driver.findElement(By.cssSelector("img.ui-datepicker-trigger"))
				.click();
				DateFormat dateFormat2 = new SimpleDateFormat("M/d/y");
				
				DateFormat dateFormat = new SimpleDateFormat("d");
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DAY_OF_YEAR, 1);
				
			//newly added	
				try{
					Calendar calendar2 = Calendar.getInstance();
					Date today = calendar2.getTime();
					String varDate2=dateFormat.format(today);
					System.out.println(varDate2);
					driver.findElement(By.linkText(varDate2)).click();
					report.updateTestLog("Checking Date in Reminder popup", "Start Date earlier than tomorrow's date.", Status.FAIL);
					driver.findElement(By.cssSelector("img.ui-datepicker-trigger"))
					.click();
					
				}
				catch(Exception e)
				{
					report.updateTestLog("Checking Date in Reminder popup", "Start Date no earlier than tomorrow's date.", Status.PASS);
				}
				//till here
				Date tomorrow = calendar.getTime();
				String varDate=dateFormat.format(tomorrow);
				System.out.println(varDate);
				String varDateFull=dateFormat2.format(tomorrow);
				
				driver.findElement(By.linkText(varDate)).click();
				Thread.sleep(1000);
				//newly added
				new Select(driver.findElement(By.id(UIMapMyLowes.drpDownSendReminder))).selectByVisibleText(dataTable.getData("General_Data", "ReminderFrequency"));
				Thread.sleep(1000);
				ClickCustomize("id", UIMapMyLowes.txtReminderNotes);
				driver.findElement(By.id(UIMapMyLowes.txtReminderNotes)).clear();
				driver.findElement(By.id(UIMapMyLowes.txtReminderNotes)).sendKeys(dataTable.getData("General_Data", "ReminderNotes"));
				//till here
				driver.findElement(
						By.cssSelector("a.button.reminder_notes_save_continue > span"))
						.click();
			Thread.sleep(5000);
			fc.chkText(UIMapMyLowes.lnkReminderPuchaseDetails+"/a/span", "Reminder Set");
			
			if(driver.findElement(By.xpath(UIMapMyLowes.lnkReminderPuchaseDetails+"/a/span/img")).isDisplayed())
				{report.updateTestLog("Adding Reminder in Item View", "Reminder Added-Check displayed", Status.PASS);
			dataTable.putData("General_Data", "ReminderDate", varDateFull);
			String varItemName=driver.findElement(By.xpath(UIMapMyLowes.webElmntOrderItemName2)).getText();
			System.out.println(varItemName);
			dataTable.putData("General_Data", "ItemName", varItemName);
				}
				else
				report.updateTestLog("Adding Reminder in Item View", "Reminder NOT Added -Check NOT displayed", Status.FAIL);
				}
				catch(Exception e)
				{
					report.updateTestLog("Adding Reminder in Item View", "Reminder not addeds", Status.FAIL);
				}
			ClickCustomize("linkText", "Back to Purchases");
			selenium.waitForPageToLoad("20000");
	
	}
	
	/**Adds first reminder for an acct for an item in Purchase details**/
	public void addReminderFrmPurchaseDetails2() throws Exception
	{
		ClickCustomize("xpath", UIMapMyLowes.drpDownAddToOnlinePurchsDetails);
		Thread.sleep(1000);
		
				
		//adding Reminder
				ClickCustomize("xpath", UIMapMyLowes.lnkReminderPuchaseDetails+"/a/span[2]");
				Thread.sleep(5000);
				
				try{
					if(selenium.isTextPresent("Continue"))
					{
						ClickCustomize("linkText", "Continue");
						Thread.sleep(1000);
					}
				driver.findElement(By.cssSelector("img.ui-datepicker-trigger"))
				.click();
				DateFormat dateFormat2 = new SimpleDateFormat("M/d/y");
				
				DateFormat dateFormat = new SimpleDateFormat("d");
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DAY_OF_YEAR, 2);
				Date tomorrow = calendar.getTime();
				String varDate=dateFormat.format(tomorrow);
				System.out.println(varDate);
				String varDateFull=dateFormat2.format(tomorrow);
				
				driver.findElement(By.linkText(varDate)).click();
				Thread.sleep(1000);
				driver.findElement(
						By.cssSelector("a.button.reminder_notes_save_continue > span"))
						.click();
			Thread.sleep(5000);
			fc.chkText(UIMapMyLowes.lnkReminderPuchaseDetails+"/a/span", "Reminder Set");
			
			if(driver.findElement(By.xpath(UIMapMyLowes.lnkReminderPuchaseDetails+"/a/span/img")).isDisplayed())
				{report.updateTestLog("Adding Reminder in Item View", "Reminder Added-Check displayed", Status.PASS);
			dataTable.putData("General_Data", "ReminderDate", varDateFull);
			String varItemName=driver.findElement(By.xpath(UIMapMyLowes.webElmntOrderItemName2)).getText();
			System.out.println(varItemName);
			dataTable.putData("General_Data", "ItemName", varItemName);
				}
				else
				report.updateTestLog("Adding Reminder in Item View", "Reminder NOT Added -Check NOT displayed", Status.FAIL);
				}
				catch(Exception e)
				{
					report.updateTestLog("Adding Reminder in Item View", "Reminder not addeds", Status.FAIL);
				}
			ClickCustomize("linkText", "Back to Purchases");
			selenium.waitForPageToLoad("20000");
	
	}
	
	/**
	 * checks added reminder on reminders page
	 */
	public void chkAddedReminder() throws Exception
	{
		/*String varItemName=dataTable.getData("General_Data", "ItemName");
		//String varItemNameDisp=driver.findElement(By.xpath(UIMapMyLowes.lblMatchReminder1)).getText();
		String varDate=dataTable.getData("General_Data", "ReminderDate");
		fc.chkText(UIMapMyLowes.lblMatchReminder1, varItemName);
		fc.chkText(UIMapMyLowes.lblReminderDateTxt, "Your reminder will be sent on "+varDate);*/
		int itemFound=0;
		String varPgInfo=driver.findElement(By.xpath(UIMapMyLowes.webElmntReminderPg)).getText();
		String[] s=varPgInfo.split("of ");
		int varPgCount=Integer.valueOf(s[1]);
		System.out.println("Pages:"+varPgCount);
		int i=0;
		for(i=1;i<=varPgCount;i++)
		{
			int itemCount=fc.countWebElement(UIMapMyLowes.lnkItemNameOnReminderAll);
			int j=0;
			for(j=2;j<=(itemCount+1);j++)
			{
				String varItemName=driver.findElement(By.xpath("//*[@id='remindersList']/div["+j+"]/div[2]/div[1]/div[2]/h5/a")).getText();
				
				String varItem=dataTable.getData("General_Data", "ItemName");
				System.out.println(varItemName+"::"+varItem);
				if(varItemName.equals(varItem))
				{
					String varReminderDate=driver.findElement(By.xpath("//*[@id='remindersList']/div["+j+"]/div[2]/p")).getText();
					String varDate=dataTable.getData("General_Data", "ReminderDate");
					System.out.println("Your reminder will be sent on "+varDate+"::"+varReminderDate);
					if(varReminderDate.equals("Your reminder will be sent on "+varDate))
					{
						report.updateTestLog("Checking Reminder Added", "Reminder Added", Status.PASS);
						System.out.println("Division:"+j);
						dataTable.putData("General_Data", "ReminderDiv", String.valueOf(j));
						itemFound=1;
						break;
					}
					else
					{
						report.updateTestLog("Checking Reminder Added", "Reminder Added with wrong date", Status.FAIL);
						itemFound=1;
						break;
					}
				}
			}
			if(itemFound==1)
				break;
			else
				ClickCustomize("partialLinkText", "Next");
		}
		if(itemFound!=1)
			report.updateTestLog("Checking Reminder Added", "Reminder NOT Displayed", Status.FAIL);
		
		
	}
	
	/***This function navigates to Purchases****/
	 public void navigatePurchases() throws Exception
		{
			Actions actions = new Actions(driver);
			WebElement menuHoverLink = driver.findElement(By.id(UIMapMyLowes.lnkMyAccount));
			actions.moveToElement(menuHoverLink).build().perform();
			System.out.println("Mouse Hover successful");
			Thread.sleep(2000);
			//WebElement subLink = driver.findElement(By.id(UIMapMyLowes.lnkHomeProfile));
			WebElement subLink = driver.findElement(By.partialLinkText("Purchases"));
			actions.moveToElement(subLink).build().perform();
			subLink.click();
			selenium.waitForPageToLoad("30000");
			
			String varMyLowes = driver.findElement(
					By.xpath(UIMapMyLowes.lblBreadCrumb3)).getText();
			System.out.println(varMyLowes);
			
			if (varMyLowes.contains("Purchase")) {
				report.updateTestLog("Clicking Your Account link-Purchases",
						"Purchases page displayed", Status.PASS);
			} else {
				report.updateTestLog("Clicking Your Account link-Purchases",
						"Purchases page NOT displayed", Status.FAIL);
			}
			
		}
	
	public void chkReminderforOrderWithSingleItem() throws Exception
	{
		navigatePurchases();
		clickOrderNbrPurchaseHistory();
		addReminderFrmPurchaseDetails();
		navigateReminders();
		chkAddedReminder();
		navigatePurchases();
		clickOrderNbrPurchaseHistory();
		addReminderFrmPurchaseDetails2();
		navigateReminders();
		chkAddedReminder();
	}
	
	public void requestAdditionalMLC() throws Exception
	{
		ClickCustomize("partialLinkText", "Manage MyLowe's Card");
		selenium.waitForPageToLoad("20000");
		ClickCustomize("partialLinkText", "Request Additional Card");
		selenium.waitForPageToLoad("20000");
		driver.findElement(By.id(UIMapMyLowes.txtAddress1)).clear();
        driver.findElement(By.id(UIMapMyLowes.txtAddress1)).sendKeys(dataTable.getData("General_Data","Address1"));
        driver.findElement(By.id(UIMapMyLowes.txtCity)).clear();
        driver.findElement(By.id(UIMapMyLowes.txtCity)).sendKeys(dataTable.getData("General_Data","City"));
        new Select(driver.findElement(By.id(UIMapMyLowes.txtState))).selectByVisibleText(dataTable.getData("General_Data", "State"));
        Thread.sleep(1000);
        driver.findElement(By.id(UIMapMyLowes.txtZip)).clear();
        driver.findElement(By.id(UIMapMyLowes.txtZip)).sendKeys(dataTable.getData("General_Data","zipcode"));
        driver.findElement(By.id(UIMapMyLowes.btnCardRegSubmit)).click();
        Thread.sleep(3000);
        selenium.waitForPageToLoad("20000");
	}
	
	
	
	/**
	 * validates added in store purchase
	 */
	
	public void chkAddedInStorePurchase() throws Exception
	{
		//checking modify search link
		chkElementDisplayed("xpath", UIMapMyLowes.lnkModifySearch, "Modify Search link");
		//checking if order grayed out
		/*String varOrder=driver.findElement(By.xpath(UIMapMyLowes.webElmntItemNameInInstoreOrder)).getText();
		System.out.println(varOrder);
		try{
			if(driver.findElement(By.partialLinkText(varOrder)).isDisplayed())
			{
				report.updateTestLog("Checking if Order Grayed out", "Order is NOT grayed out", Status.FAIL);
			}
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking if Order Grayed out", "Order is grayed out", Status.PASS);
		}*/
		//checking Order details
		String varClass=driver.findElement(By.xpath(UIMapMyLowes.webElmntAddedInStoreOrderDiv1)).getAttribute("class");
		if(varClass.equals("order-info-summary clearfix"))
			report.updateTestLog("Checking Order Summary", "Order Summary displayed", Status.PASS);
		else
			report.updateTestLog("Checking Order Summary", "Order Summary NOT displayed", Status.FAIL);
		
		chkElementDisplayed("xpath", UIMapMyLowes.lblAddedInStoreOrderType, "Purchase Type");
		chkElementDisplayed("xpath", UIMapMyLowes.lblAddedInStorePurchaseAt, "Purchase At");
		chkElementDisplayed("xpath", UIMapMyLowes.lblAddedInStoreInvoiceNbr, "Invoice Nbr");
		chkElementDisplayed("xpath", UIMapMyLowes.lblAddedInStorePurchaseTotal, "Purchase Total");
		
		//checking View Details
		try{
			if(driver.findElement(By.partialLinkText("View Details")).isDisplayed())
			{
				report.updateTestLog("Checking View Details", "View Details displayed", Status.FAIL);
			}
			else
				report.updateTestLog("Checking View Details", "View Details NOT displayed", Status.PASS);
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking View Details", "View Details NOT displayed", Status.PASS);
		}
		
		//checking Add To and Reminders
		try{
			if(driver.findElement(By.className("save-item-panel")).isDisplayed())
			{
				report.updateTestLog("Checking Save Item functionality", "Save Item functionality displayed", Status.FAIL);
			}
			else
				report.updateTestLog("Checking Save Item functionality", "Save Item functionality NOT displayed", Status.PASS);
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking Save Item functionality", "Save Item functionality NOT displayed", Status.PASS);
		}
		
	}
	
	/***stores MLC Nbr**/
	public void storeMLCNbr() throws Exception
	{
		String varMLC=driver.findElement(By.xpath(UIMapMyLowes.txtMyLowesCardNo)).getText();
		varMLC=varMLC.trim();
		System.out.println(varMLC);
		dataTable.putData("General_Data", "MLCNbr", varMLC);
	}
	
	/**Checks Link To MLC Card if single MLC Card in acct**/
	public void chkLinkToMLCSingleCard() throws Exception
	{
		fc.chkText(UIMapMyLowes.lnkLinkInStorePrchsToMLC, "Attach this purchase to your MyLowe's card"+dataTable.getData("General_Data", "MLCNbr"));
		
	}
	
	/**Checks Link To MLC Card if Multiple MLC Card in acct**/
	public void chkLinkToMLCMultipleCard() throws Exception
	{
		chkElementDisplayed("xpath", UIMapMyLowes.drpDownSelectMLCForLinking, "MLC dropdown");
		fc.chkText(UIMapMyLowes.lblAddToMLCNbr, "Add to MyLowe's Card #:");
		
	}
	
	/**attaches an Instore Purchase to MLC-Single MLC in ACCCT*/
	public void linkToMLCSingleCard() throws Exception
	{
		ClickCustomize("partialLinkText", "Attach this purchase to your MyLowe's card");
		Thread.sleep(5000);
		String varMsg="You've successfully attached this purchase to MyLowe's card #"+dataTable.getData("General_Data", "MLCNbr")+". It will appear in this card's purchase history within 24 hours.";
		fc.chkText(UIMapMyLowes.lblInStoreOrderLinkedSuccessMsg, varMsg);
		Thread.sleep(5000);
		fc.chkText(UIMapMyLowes.lblInStoreOrderLinkedSuccessMsg, varMsg);
	}
	
	/**attaches an Instore Purchase to MLC-Multiple MLC in ACCCT*/
	public void linkToMLCMultipleCard() throws Exception
	{
		new Select(driver.findElement(By.xpath(UIMapMyLowes.drpDownSelectMLCForLinking))).selectByVisibleText(dataTable.getData("General_Data", "MLCNbr"));
		Thread.sleep(1000);
		ClickCustomize("xpath", UIMapMyLowes.btnAddOrderToMLC);
		Thread.sleep(5000);
		String varMsg="You've successfully attached this purchase to MyLowe's card #"+dataTable.getData("General_Data", "MLCNbr")+". It will appear in this card's purchase history within 24 hours.";
		fc.chkText(UIMapMyLowes.lblInStoreOrderLinkedSuccessMsg, varMsg);
		Thread.sleep(5000);
		fc.chkText(UIMapMyLowes.lblInStoreOrderLinkedSuccessMsg, varMsg);
	}

	/**Stores Item Name from Purchase details page**/
	public void storeItemNameFromPurchaseDetails() throws Exception
	{
		clickOrderNbrPurchaseHistory();
		String varItemName=driver.findElement(By.xpath(UIMapMyLowes.webElmntOrderItemName2)).getText();
		System.out.println(varItemName);
		dataTable.putData("General_Data", "ItemName", varItemName);
		ClickCustomize("linkText", "Back to Purchases");
		selenium.waitForPageToLoad("20000");
	}
	
	/**Checks Online Purchases in the Purchase History page which is associated to Key Fob  and inspect List Navigation and Module**/
	public void chkOnlinePurchaseItemViewSingleItem() throws Exception
	{
		String varSelected=driver.findElement(By.xpath(UIMapMyLowes.lnkTransactioDtOption1)).getAttribute("selected");
		System.out.println("Selected:"+varSelected);
		if(varSelected.equals("true"))
			report.updateTestLog("Checking Default value in Date Filter", "Default value:Last 30 days selected", Status.PASS);
		else
			report.updateTestLog("Checking Default value in Date Filter", "Default value:Last 30 days selected", Status.FAIL);
		
		storeItemNameFromPurchaseDetails();
		hp.purchaseSwitchItemView();	
		
		fc.checkTextContains(UIMapMyLowes.lblPurchaseListFooter, "Page 1 of 1", "Purchase History Item View");
		String varClass=driver.findElement(By.xpath(UIMapMyLowes.lnkPrevious)).getAttribute("class");
		if(varClass.contains("disabled"))
			report.updateTestLog("Checking Previous Link", "Previous disabled", Status.PASS);
		else
			report.updateTestLog("Checking Previous Link", "Previous NOT disabled", Status.FAIL);
		varClass=driver.findElement(By.xpath(UIMapMyLowes.lnkNext)).getAttribute("class");
		if(varClass.contains("disabled"))
			report.updateTestLog("Checking Next Link", "Next disabled", Status.PASS);
		else
			report.updateTestLog("Checking Next Link", "Next NOT disabled", Status.FAIL);
		
		fc.chkText(UIMapMyLowes.lnkItem1NameItemViewPurchases, dataTable.getData("General_Data", "ItemName"));
		
		chkElementDisplayed("xpath", UIMapMyLowes.lnkThumbNail, "Item Thumbnail");
		chkElementDisplayed("xpath", UIMapMyLowes.drpDownAddToItemViewAll, "Add To Mechanism");
		ClickCustomize("xpath", UIMapMyLowes.drpDownAddToItemViewAll);
		fc.chkText(UIMapMyLowes.lnkAddToHPItemViewPurchases, "Home Profile");
		fc.chkText(UIMapMyLowes.lnkAddToListItemViewPurchases, "Lists");
		fc.chkText(UIMapMyLowes.lnkReminderItemViewPurchases, "Reminders");
		
		ClickCustomize("xpath", UIMapMyLowes.lnkReminderItemViewPurchases);
		Thread.sleep(5000);
		if(selenium.isTextPresent("Continue"))
		{
			ClickCustomize("linkText", "Continue");
			Thread.sleep(2000);
		}
		List<String> varCat=new ArrayList<String>();
		varCat.add("Once");
		varCat.add("Weekly");
		varCat.add("Every 2 Weeks");
		varCat.add("Monthly");
		varCat.add("Every 2 Months");
		varCat.add("Every 3 Months");
		varCat.add("Every 6 Months");
		varCat.add("Yearly");
		List<String> varCat2=new ArrayList<String>();
		for(int i=1;i<=8;i++)
		{
			varCat2.add(driver.findElement(By.xpath("//*[@id='reminder_rep']/option["+i+"]")).getText());
			
		}
		System.out.println("::"+varCat+"::");
		System.out.println("::"+varCat2+"::");
		if(varCat.equals(varCat2))
			report.updateTestLog("Checking Options in reminder", "Reminder options correctly displayed", Status.PASS);
		else
			report.updateTestLog("Checking Options in reminder", "Reminder options NOT correctly displayed", Status.FAIL);
		
		int varCount=fc.countWebElement("html/body/div");
		System.out.println(varCount);
		chkElementDisplayed("xpath","//div["+varCount+"]","Set Reminder Popup");
		driver.findElement(By.cssSelector("img.ui-datepicker-trigger"))
		.click();
		DateFormat dateFormat = new SimpleDateFormat("d");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		Date tomorrow = calendar.getTime();
		String varDate=dateFormat.format(tomorrow);
		System.out.println(varDate);
		driver.findElement(By.linkText(varDate)).click();
		Thread.sleep(1000);
		driver.findElement(
				By.cssSelector("a.button.reminder_notes_save_continue > span"))
				.click();
	Thread.sleep(5000);
	fc.chkText(UIMapMyLowes.lblReminderSetItemView, "Reminder Set");
	
	if(driver.findElement(By.xpath(UIMapMyLowes.webElmntReminderItemViewCheck)).isDisplayed())
		report.updateTestLog("Adding Reminder in Item View", "Reminder Added-Check displayed", Status.PASS);
	else
		report.updateTestLog("Adding Reminder in Item View", "Reminder NOT Added -Check NOT displayed", Status.FAIL);
	
	System.out.println(driver.findElement(By.xpath(UIMapMyLowes.lnkTransactioDtOption1)).getText());
	/*String varSelected=driver.findElement(By.xpath(UIMapMyLowes.lnkTransactioDtOption1)).getAttribute("selected");
	System.out.println("Selected:"+varSelected);
	if(varSelected.equals("true"))
		report.updateTestLog("Checking Default value in Date Filter", "Default value:Last 30 days selected", Status.PASS);
	else
		report.updateTestLog("Checking Default value in Date Filter", "Default value:Last 30 days selected", Status.FAIL);
		*/
		List<String> varDateOptions=new ArrayList<String>();
		varDateOptions.add("Last 30 days");
		varDateOptions.add("Last 6 months");
		varDateOptions.add("2014");
		varDateOptions.add("2013");
		varDateOptions.add("2012");
		varDateOptions.add("All");
		
		List<String> varDateOptions2=new ArrayList<String>();
		for(int i=1;i<=6;i++)
		{
			varDateOptions2.add(driver.findElement(By.xpath("//*[@id='transaction-date']/option["+i+"]")).getText());
			/*try{
				varSelected=driver.findElement(By.xpath("//*[@id='transaction-date']/option["+i+"]")).getAttribute("selected");
				System.out.println("Selected:"+varSelected);
			}
			catch(Exception e)
			{
				continue;
			}*/
		}
		System.out.println("::"+varDateOptions+"::");
		System.out.println("::"+varDateOptions2+"::");
		if(varDateOptions.equals(varDateOptions2))
			report.updateTestLog("Checking Options in Date Filter", "Date Filter options correctly displayed", Status.PASS);
		else
			report.updateTestLog("Checking Options in Date Filter", "Date Filter options NOT correctly displayed", Status.FAIL);
		purchaseSwitchPurchaseView();
		clickOrderNbrPurchaseHistory();
		try{
			if(driver.findElement(By.partialLinkText("Find Purchases")).isDisplayed())
				report.updateTestLog("Checking Find Purchase link", "Find Purchase link displayed", Status.FAIL);
			else
				report.updateTestLog("Checking Find Purchase link", "Find Purchase link NOT displayed", Status.PASS);
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking Find Purchase link", "Find Purchase link NOT displayed", Status.PASS);
			
		}
		ClickCustomize("linkText", "Back to Purchases");
		selenium.waitForPageToLoad("20000");
		navigateToOnlineDefault();
		
		fc.chkText(UIMapMyLowes.txtPurchaseDisclaimer2, "** Items purchased in store will appear in your purchase history within 24 hours of purchase."
				+'\n'+"** Items returned in store will remain visible in your purchase history."+'\n'+
				"** Results can't be used as receipts for returns.");
		
		
	}
	
	/**Checks EPP Details in InStore Order-Purchase Details**/
	public void chkEPPInStoreOrderPurchsDetails() throws Exception
	{
		String varEPPRef=null;
		int varEPP=0;
		try{
			varEPPRef=driver.findElement(By.xpath(UIMapMyLowes.lblEPPReferenceNbr)).getText();
		if(!varEPPRef.isEmpty())
		{
			report.updateTestLog("Checking EPP reference nbr", " EPP reference nbr displayed", Status.PASS );
			varEPP=1;
		}
		else
			report.updateTestLog("Checking EPP reference nbr", " EPP reference nbr NOT displayed", Status.FAIL );
		}
		
		catch(Exception e)
		{
			report.updateTestLog("Checking EPP reference nbr", " EPP reference nbr NOT displayed", Status.FAIL );
		}
		if(varEPP==1)
		try{
			if(driver.findElement(By.linkText(varEPPRef)).isDisplayed())
			{
				ClickCustomize("linkText", varEPPRef);
				report.updateTestLog("Checking EPP reference nbr", " EPP reference nbr displayed As Link", Status.FAIL );
				driver.navigate().back();
				
			}
			
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking EPP reference nbr", " EPP reference nbr displayed As Link", Status.FAIL );
			
		}
		
		chkElementDisplayed("xpath", UIMapMyLowes.webElmntEPPImg, "Epp Image");
		/*try{
			ClickCustomize("xpath", UIMapMyLowes.webElmntEPPImg);
			report.updateTestLog("Trying to click Image", "Image Clicked", Status.FAIL);
			
		}
		catch(Exception e)
		{
			report.updateTestLog("Trying to click Image", "Image not clickable", Status.PASS);
		}*/
		chkElementDisplayed("partialLinkText", "View Plan Details", "View Plan Details link");
		try{
			if(driver.findElement(By.linkText("Manage Your Plan")).isDisplayed())
			report.updateTestLog("Checking Manage Your Plan", "Manage Your Plan displayed", Status.FAIL);
			else
				report.updateTestLog("Checking Manage Your Plan", "Manage Your Plan NOT displayed", Status.PASS);
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking Manage Your Plan", "Manage Your Plan NOT displayed", Status.PASS);
		}
		ClickCustomize("linkText", "Protection Plan Information");
		selenium.waitForPageToLoad("20000");
		fc.chkPagetitle("Protection Plans");
		driver.navigate().back();
		selenium.waitForPageToLoad("20000");
		ClickCustomize("linkText", "Back to Purchases");
		
		selenium.waitForPageToLoad("20000");
	}
	
	/**checks EPP item in Purchase History-Item View**/
	public void checkEPPInItemView() throws Exception
	{
		System.out.println(dataTable.getData("General_Data", "PgNbr"));
		for(int i=1;i<Integer.valueOf(dataTable.getData("General_Data", "PgNbr"));i++)
		{
			ClickCustomize("linkText", "Previous");
			selenium.waitForPageToLoad("20000");
		}
		
		chkElementDisplayed("partialLinkText", "Purchase Details", "Purchase Details");
		int varPgCount=Integer.valueOf(driver.findElement(By.xpath(UIMapMyLowes.lnkPurchaseTotalPage)).getText());
		int i=0;
		
		for(i=1;i<=varPgCount;i++)
		{
			int varCount=fc.countWebElement(UIMapMyLowes.webElmntItemViewItemsAll);
			System.out.println("Items on Page:"+i+":"+varCount);
			int j;
			for(j=1;j<=varCount;j++)
			{
				String varItemName=driver.findElement(By.xpath("//*[@id='itemView']/ul["+j+"]/li/div[2]/h3")).getText();
				System.out.println(varItemName);
						if(varItemName.contains("EPP"))
							break;
						else
							continue;
			}
			if(j>varCount)
			{
				System.out.println("Not on Page:"+i);
				ClickCustomize("linkText", "Next");
				continue;
			}
			else
			{
				chkElementDisplayed("xpath", "//*[@id='itemView']/ul["+j+"]/li/div[1]/img", "EPP Image in Item View");
				chkElementDisplayed("xpath", "//*[@id='itemView']/ul["+j+"]/li/div[2]/b/p", "EPP Price in Item View");
				chkElementDisplayed("xpath", "//*[@id='itemView']/ul["+j+"]/li/div[3]/div[1]/span", "Add to Mechanism in Item View for EPP");
				break;
			}
			
		}
		if(i>varPgCount)
			report.updateTestLog("Finding Online Order Nbr", "Online Order not displayed in any page", Status.FAIL);
		
	}
	
	
	/**checks find Purchase page**/
	public void chkFindPurchasePg() throws Exception
	{
		fc.chkText(UIMapMyLowes.lblFindPurchaseType, "Select purchase type:");
		chkElementDisplayed("id", UIMapMyLowes.drpDownPurhcseTypeAddPur, "Select Purchase Type drop-down");
		try{String varClass=driver.findElement(By.xpath(UIMapMyLowes.lnkFindPurchsDrpdownOption1)).getAttribute("selected");
		if(varClass.equals("true"))
			report.updateTestLog("Checking default value in Select Purchase Type drop-down", "Online / Mobile selected by default", Status.PASS);
		else
			report.updateTestLog("Checking default value in Select Purchase Type drop-down", "Online / Mobile NOT selected by default", Status.FAIL);
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking default value in Select Purchase Type drop-down", "Online / Mobile NOT selected by default", Status.FAIL);
		}
		fc.chkText(UIMapMyLowes.lblFindPurchaseType, "Confirmation or Order Number:");
		chkElementDisplayed("id", UIMapMyLowes.lblFindPurchsOrderNbr, "Confirmation or Order Number: Field");
		chkElementDisplayed("id", UIMapMyLowes.btnFindOrderSubmit, "Submit button");
		chkElementDisplayed("xpath",UIMapMyLowes.webElmntLogonForm,"Logon Form");
	}
	
	/**checks Online order purchase details page opened from find Purchase page/purchase history**/
	public void chkOnlinePurchaseFromFindPurchase() throws Exception
	{
		
		//chkElementDisplayed("xpath",UIMapMyLowes.webElmntLogonForm,"Logon Form");
		fc.chkText(UIMapMyLowes.webElmntPurchaseDetailsHeading, "Purchase Details");
		fc.chkText(UIMapMyLowes.btnPurchaseDetailsPrint, "Print");
		chkElementDisplayed("xpath",UIMapMyLowes.txtDtFrmPDP,"Purchase Date");
		chkElementDisplayed("xpath",UIMapMyLowes.lblAddedInStorePurchaseAt,"Purchase Store");
		chkElementDisplayed("xpath",UIMapMyLowes.lblOrderNbrPurchaseDetails,"Order Nbr");
		chkElementDisplayed("xpath",UIMapMyLowes.lblPurchaseStatus,"Purchase Status");
		chkElementDisplayed("xpath",UIMapMyLowes.lblPurchaseTotal,"Purchase Total");
		int varCount=fc.countWebElement(UIMapMyLowes.webElmntOlPurchsDetailsAllItems);
		System.out.println(varCount);
		for(int i=2;i<=(varCount+1);i++)
		{
			chkElementDisplayed("xpath","//*[@id='order_detail']/div["+i+"]/h3",i+" Fulfillment method ");
			chkElementDisplayed("xpath","//*[@id='order_detail']/div["+i+"]/div[2]/div/div[1]/a/img","Item "+i+" image ");
			chkElementDisplayed("xpath","//*[@id='order_detail']/div["+i+"]/div[2]/div/div[2]/div[1]/a/span","Item "+i+" Status ");
			chkElementDisplayed("xpath","//*[@id='order_detail']/div["+i+"]/div[2]/div/div[2]/h5/a","Item "+i+" Name ");
			chkElementDisplayed("xpath","//*[@id='order_detail']/div["+i+"]/div[2]/div/div[2]/div[2]","Item "+i+" Item# Model# info ");
			chkElementDisplayed("xpath","//*[@id='order_detail']/div["+i+"]/div[2]/div/div[2]/div[3]/div/div[1]/span","Item "+i+" Add To Mechanism ");
			chkElementDisplayed("xpath","//*[@id='order_detail']/div["+i+"]/div[2]/div/div[3]/div[1]/div","Item "+i+" Unit Price");
			
			chkElementDisplayed("xpath","//*[@id='order_detail']/div["+i+"]/div[2]/div/div[3]/div[2]/div","Item "+i+" Quantity");
			chkElementDisplayed("xpath","//*[@id='order_detail']/div["+i+"]/div[2]/div/div[3]/div[3]/div","Item "+i+" Item Total");
	}
		fc.chkText(UIMapMyLowes.lblPaymentInfo,"Payment Information");
		chkElementDisplayed("xpath",UIMapMyLowes.lblSubtotalAmt,"Subtotal amt");
		chkElementDisplayed("xpath",UIMapMyLowes.lblPurchaseTotalAmt,"Purchase Subtotal");
		chkElementDisplayed("xpath",UIMapMyLowes.lblOnlineOrderPaymentMethod,"payment method");
}
	
	public void clickFindAnotherPurchase() throws Exception 
	{
		ClickCustomize("linkText", "Find Another Purchase");
		Thread.sleep(2000);
		selenium.waitForPageToLoad("20000");
		chkElementDisplayed("id", UIMapMyLowes.webElmntFindOrder, "Find Order Page");
	}
	
	/**Finds a purchase**/
	public void findInStoreSpecialOrder() throws Exception
	{
		fc.chkPagetitle("Find Purchase");
		new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurhcseTypeAddPur))).selectByVisibleText("In-Store Special Order");
		Thread.sleep(2000);
		ClickCustomize("xpath", UIMapMyLowes.txtPONbr);
		driver.findElement(By.xpath(UIMapMyLowes.txtPONbr)).sendKeys(dataTable.getData("General_Data", "PONbr"));
		//driver.findElement(By.xpath(UIMapMyLowes.txtPONbr)).sendKeys(Keys.ENTER);
		ClickCustomize("id", "findOrdersSubmit"); 
		Thread.sleep(2000);
		selenium.waitForPageToLoad("20000");
		 
		 
		 
	}
	
	public void chkPOOrderDisplayed() throws Exception
	{
		fc.chkPagetitle("Order #"+dataTable.getData("General_Data", "PONbr"));
	}
	
	public void chkInvalidPOError() throws Exception
	{
		fc.chkText(UIMapMyLowes.lblInvalidPOError, "We could not find the P.O. number you entered. Please re-enter your P.O. number. Note: Lowes.com retains details related to in-store Special Orders for one year after the purchase date.");
	}
	
	public void clickModifySearch() throws Exception
	{
		
		ClickCustomize("linkText", "Modify Search");
		Thread.sleep(2000);	
		ClickCustomize("xpath", UIMapMyLowes.btnAddPurchaseInStore);
		Thread.sleep(1000);
	}
	
	public void chkInvalidPOErrorLI() throws Exception
	{
		fc.chkText(UIMapMyLowes.txtInvalidConfNoMsg1, "We could not find the P.O. number you entered. Please re-enter your P.O. number. Note: Lowes.com retains details related to in-store Special Orders for one year after the purchase date.");
	}
	
	
	public void checkInstoreOrderInPurchaseDetails() throws Exception
	{
		fc.chkText(UIMapMyLowes.webElmntPurchaseDetailsHeading, "Purchase Information");
		fc.chkText(UIMapMyLowes.btnPurchaseDetailsPrint, "Print");
		chkElementDisplayed("xpath",UIMapMyLowes.txtDtFrmPDP,"Purchase Date");
		chkElementDisplayed("xpath",UIMapMyLowes.lblAddedInStorePurchaseAt,"Purchase Store");
		chkElementDisplayed("xpath",UIMapMyLowes.lblAddedInStoreInvoiceNbr,"Order Nbr");
		chkElementDisplayed("xpath",UIMapMyLowes.lblPurchaseStatus,"Purchase Status");
		chkElementDisplayed("xpath",UIMapMyLowes.lblPurchaseTotal,"Purchase Total");
		fc.chkText(UIMapMyLowes.lblAddedInStoreOrderType, "In-Store Purchase");
		int itemCount=fc.countWebElement(UIMapMyLowes.webElmntOnlinePurchaseAll);
		System.out.println(itemCount);
		for(int i=2;i<=itemCount;i++)
		{
			chkElementDisplayed("xpath","//*[@id='order_detail']/div[2]/div["+i+"]/div/div[2]/div[1]",i+" Status");
			chkElementDisplayed("xpath","//*[@id='order_detail']/div[2]/div["+i+"]/div/div[3]/div[1]/div",i+" Unit Price");
			chkElementDisplayed("xpath","//*[@id='order_detail']/div[2]/div["+i+"]/div/div[3]/div[2]/div",i+" Qty");
			chkElementDisplayed("xpath","//*[@id='order_detail']/div[2]/div["+i+"]/div/div[3]/div[3]/div",i+" Total");
			chkElementDisplayed("xpath","//*[@id='order_detail']/div[2]/div["+i+"]/div/div[2]/div[3]/div[1]/span",i+" Add To Mechanism");
			if(driver.findElement(By.xpath("//*[@id='order_detail']/div[2]/div["+i+"]/div/div[2]")).getText().contains("This product is currently unavailable online."))
			{
				chkElementDisplayed("xpath","//*[@id='order_detail']/div[2]/div["+i+"]/div/div[2]/h5",i+" Name not As Link");
				chkElementDisplayed("xpath","//*[@id='order_detail']/div[2]/div["+i+"]/div/div[1]/img",i+" Image as Unavailable");
			}
			else
			{
				chkElementDisplayed("xpath","//*[@id='order_detail']/div[2]/div["+i+"]/div/div[2]/h5/a",i+" Name As Link");
				chkElementDisplayed("xpath","//*[@id='order_detail']/div[2]/div["+i+"]/div/div[1]/a/imgg",i+" Image");
			}
			
	 }
		fc.chkText(UIMapMyLowes.lblInStoreOrderPaymentInfo,"Payment Information");
		chkElementDisplayed("xpath",UIMapMyLowes.lblSubtotalAmt,"Subtotal amt");
		//chkElementDisplayed("xpath",UIMapMyLowes.lblPurchaseTotalAmt,"Purchase Subtotal");
		chkElementDisplayed("xpath",UIMapMyLowes.lblInstoreOrderPaymentMethod,"payment method");
	}
	
	/**checks only online orders are displayed on selecting online**/
	public void chkOrderType() throws Exception
	{
		int varPgCount=Integer.valueOf(driver.findElement(By.xpath(UIMapMyLowes.lnkPurchaseTotalPage)).getText());
		int i=0;
		int varFound=0;
		for(i=1;i<=varPgCount;i++)
		{
			int varCount=fc.countWebElement(UIMapMyLowes.webElmntItemViewOrdersOnPg);
			int j;
			System.out.println("Checking Page:"+i);
			for(j=1;j<=varCount;j++)
					{
				System.out.println("Checking Order Type:"+j);
				System.out.println(dataTable.getData("General_Data", "OrderType"));
				String varOrderNbrDisp=driver.findElement(By.xpath("//*[@id='orderView']/tbody/tr["+j+"]/td[3]")).getText();
				System.out.println(varOrderNbrDisp);
				if(varOrderNbrDisp.equals(dataTable.getData("General_Data", "OrderType")))
				{
					
				}
				else
				{
					varFound=1;
					report.updateTestLog("Checking Order Type", "Order Type NOT as per filter selected for item:"+j+" on page :"+i, Status.FAIL);
					break;
					
					
					
				}
				
				if(j==varCount)	
				{
					System.out.println("All Order type correct on page:"+i);
					if(i<varPgCount)
					{
						ClickCustomize("linkText", "Next");
					}
					
				}
				
			}
			if(varFound==1)
				break;
			
		}
		if(i>varPgCount)
			report.updateTestLog("Checking Order Type", "Order Type as per filter selected", Status.PASS);
		else
			report.updateTestLog("Checking Order Type", "Order Type NOT as per filter selected", Status.FAIL);
		System.out.println("current Pg Nbr:"+i);
		for(int k=1;k<(i-1);k++)
		{
			ClickCustomize("linkText", "Previous");
			selenium.waitForPageToLoad("20000");
		}
	}
	
	public void clickBackToPurchases() throws Exception
	{
		ClickCustomize("linkText", "Back to Purchases");
		selenium.waitForPageToLoad("20000");
	}
	
	public void checkPurchaseViewInStoreDisplay() throws Exception
	{
		fc.chkText(UIMapMyLowes.lblPurchaseViewHd, "Purchases");
		
		chkElementDisplayed("xpath",UIMapMyLowes.btnAddPurchaseInStore,"Add Purchase button");
		chkElementDisplayed("xpath",UIMapMyLowes.webElmntPurchasesItemView,"Item View");
		chkElementDisplayed("xpath",UIMapMyLowes.lnkPurchaseView,"Purchase View");
		
		fc.chkText(UIMapMyLowes.lblType, "Type:");
		fc.chkText(UIMapMyLowes.lblDate, "Date:");
		fc.chkText(UIMapMyLowes.lblMyLowesCard, "MyLowe's Card:");
		
		
		
		chkElementDisplayed("id",UIMapMyLowes.drpDownPurchaseType,"Type dropdown");
		chkElementDisplayed("id",UIMapMyLowes.drpDownPurchaseDate,"Date dropdown");
		chkElementDisplayed("id",UIMapMyLowes.drpDownMLC,"MLC dropdown");
		
		fc.chkText(UIMapMyLowes.lblDateInTable, "Date");
		fc.chkText(UIMapMyLowes.lblOrderNbrInTable, "Order #");
		fc.chkText(UIMapMyLowes.lblTypeInTable, "Type");
		fc.chkText(UIMapMyLowes.lblItemsInTable, "# Items");
		fc.chkText(UIMapMyLowes.lblTotalInTable, "Total");
		fc.chkText(UIMapMyLowes.lblStatusInTable, "Status");
		
		fc.checkTextContains(UIMapMyLowes.lblPurchaseListFooter, "Previous", "Online Orders table Footer");
		fc.checkTextContains(UIMapMyLowes.lblPurchaseListFooter, "Next", "Online Orders table Footer");
		
		
		fc.chkText(UIMapMyLowes.txtPurchaseDisclaimer1, "Don't see a purchase? Still have your receipt? Add Purchase");
		fc.chkText(UIMapMyLowes.txtPurchaseDisclaimer2, "** Items purchased in store will appear in your purchase history within 24 hours of purchase."
				+'\n'+"** Items returned in store will remain visible in your purchase history."+'\n'+
				"** Results can't be used as receipts for returns.");
	}
	
	
	public void chkAllPurchasesPurchaseViewDisplay() throws Exception
	{
		
		fc.chkText(UIMapMyLowes.lblPurchaseViewHd, "Purchases");
		
		chkElementDisplayed("xpath",UIMapMyLowes.btnAddPurchaseInStore,"Add Purchase button");
		chkElementDisplayed("xpath",UIMapMyLowes.webElmntPurchasesItemView,"Item View");
		chkElementDisplayed("xpath",UIMapMyLowes.lnkPurchaseView,"Purchase View");
		
		String varSelected=driver.findElement(By.xpath(UIMapMyLowes.lnkTransactioDtOption1)).getAttribute("selected");
		System.out.println("Selected:"+varSelected);
		if(varSelected.equals("true"))
			report.updateTestLog("Checking Default value in Date Filter", "Default value:Last 30 days selected", Status.PASS);
		else
			report.updateTestLog("Checking Default value in Date Filter", "Default value:Last 30 days selected", Status.FAIL);
		
		driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate)).click();
		Thread.sleep(1000);
		Select select2 = new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate)));
		select2.selectByVisibleText("All");
		selenium.waitForPageToLoad("20000");
		fc.chkText(UIMapMyLowes.lblType, "Type:");
		fc.chkText(UIMapMyLowes.lblDate, "Date:");
		chkElementDisplayed("id",UIMapMyLowes.drpDownPurchaseType,"Type dropdown");
		chkElementDisplayed("id",UIMapMyLowes.drpDownPurchaseDate,"Date dropdown");
		
		fc.chkText(UIMapMyLowes.lblDateInTable, "Date");
		fc.chkText(UIMapMyLowes.lblOrderNbrInTable, "Order #");
		fc.chkText(UIMapMyLowes.lblTypeInTable, "Type");
		fc.chkText(UIMapMyLowes.lblItemsInTable, "# Items");
		fc.chkText(UIMapMyLowes.lblTotalInTable, "Total");
		fc.chkText(UIMapMyLowes.lblStatusInTable, "Status");
		
		fc.checkTextContains(UIMapMyLowes.lblPurchaseListFooter, "Previous", "Online Orders table Footer");
		fc.checkTextContains(UIMapMyLowes.lblPurchaseListFooter, "Next", "Online Orders table Footer");
		
		fc.chkText(UIMapMyLowes.txtPurchaseDisclaimer1, "Don't see a purchase? Still have your receipt? Add Purchase");
		fc.chkText(UIMapMyLowes.txtPurchaseDisclaimer2, "** Items purchased in store will appear in your purchase history within 24 hours of purchase."
				+'\n'+"** Items returned in store will remain visible in your purchase history."+'\n'+
				"** Results can't be used as receipts for returns.");
	}
	
	
	
	public void clickManageCard() throws Exception
	{
		ClickCustomize("partialLinkText", "Manage Card");
		selenium.waitForPageToLoad("20000");
		fc.chkPagetitle("Manage MyLowe's Card");
	}
	
	public void chkManageMLCDisplay() throws Exception
	{
		fc.chkText(UIMapMyLowes.lblMLCheading, "Manage MyLowe's Card");
		fc.chkText(UIMapMyLowes.btnRqstAdditionalMLC, "Request Additional Card");
		chkElementDisplayed("xpath",UIMapMyLowes.webElmntBookMark,"Bookmark image");
		fc.checkTextContains(UIMapMyLowes.lblMLCTxt, "This card was last used", "Last Used Info");
		fc.chkText(UIMapMyLowes.lnkViewPurchsHistory, "View Purchase History");
		fc.chkText(UIMapMyLowes.lnkDeactivate, "Deactivate");
		chkElementDisplayed("xpath",UIMapMyLowes.webElmntDeactivateImg,"Deactivate image");
		fc.chkText(UIMapMyLowes.lblCardOwner, "Card Owner");
		fc.checkTextContains(UIMapMyLowes.lblCardOwnerValue, dataTable.getData("General_Data", "Firstname")+" "+dataTable.getData("General_Data", "Lastname"), "Card Owner Info");
		fc.chkText(UIMapMyLowes.lblMLCNbr, "MyLowe's Card Number");
		fc.checkTextContains(UIMapMyLowes.lblMLCNbrvalue, dataTable.getData("General_Data", "MLCNbr"), "Card Info");
		fc.chkText(UIMapMyLowes.lnkPrintTempCard, "Print Temporary Card");
		chkElementDisplayed("xpath",UIMapMyLowes.webElmntRqstreplacementImg,"Request Replacement Image");
		fc.chkText(UIMapMyLowes.lnkRqstReplacement, "Request Replacement");
		
		
	}
	
	public void chkRqstReplacementDisplay() throws Exception
	{
		ClickCustomize("partialLinkText", "Request Replacement");
		Thread.sleep(2000);
		fc.chkText(UIMapMyLowes.lblRqstReplacementHd, "Request a Replacement"+'\n'+"MyLowe's Card");
		fc.chkText(UIMapMyLowes.lblReplacementInfo, "A shipping address is required to receive"+'\n'+"your MyLowe's card.");
		fc.chkText(UIMapMyLowes.lblChooseSavedAddress, "Choose a Saved Address:");
		chkElementDisplayed("id",UIMapMyLowes.drpDownSavedAddrss ,"Choose address dropdown");
		fc.chkText(UIMapMyLowes.lnkShipToDiffLocation, "Want to ship to a different address?");
		fc.chkText(UIMapMyLowes.btnRqstMLC, "Request MyLowe's Card");
		fc.chkText(UIMapMyLowes.lnkCancel2, "Cancel");
		fc.chkText(UIMapMyLowes.lnkTC, "Terms and Conditions");
		fc.chkText(UIMapMyLowes.lnkPrivacy, "Privacy and Security");
		chkElementDisplayed("xpath",UIMapMyLowes.webElmntRqstreplacementImg,"Request Replacement Image");
		fc.chkText(UIMapMyLowes.lnkRqstReplacement, "Request Replacement");
	}
	
	
	public void chkRqstAdditionalCardDisplay() throws Exception
	{
		ClickCustomize("partialLinkText", "Request Additional Card");
		selenium.waitForPageToLoad("20000");
		fc.chkText(UIMapMyLowes.lblRqstMLCHd, "Request a MyLowe's Card");
		fc.chkText(UIMapMyLowes.lblRqstMLCTxt, "Choose how you'd like to track your in-store purchases.");
		chkElementDisplayed("xpath",UIMapMyLowes.rdoBtnMLCOption1 ,"I'll use my phone number. Radiobutton");
		fc.chkText(UIMapMyLowes.lblRqstMLCOption1, "I'll use my phone number.");
		chkElementDisplayed("xpath",UIMapMyLowes.rdoBtnMLCOption2 ,"I have a MyLowe's card to register. Radiobutton");
		fc.chkText(UIMapMyLowes.lblRqstMLCOption2, "I have a MyLowe's card to register.");
		chkElementDisplayed("xpath",UIMapMyLowes.rdoBtnMLCOption3 ,"Send me a MyLowe's card. Radiobutton");
		fc.chkText(UIMapMyLowes.lblRqstMLCOption3, "Send me a MyLowe's card.");
		String varClass=driver.findElement(By.xpath(UIMapMyLowes.rdoBtnMLCOption3)).getAttribute("checked");
		if(varClass.equals("true"))
			report.updateTestLog("Checking default selection on Request MLC Page", "Send me a MyLowe's card. selected", Status.PASS);
		else
			report.updateTestLog("Checking default selection on Request MLC Page", "Send me a MyLowe's card. selected", Status.FAIL);
		fc.chkText(UIMapMyLowes.lblRqstMLCAdd1, "Address Line 1:");
		fc.chkText(UIMapMyLowes.lblRqstMLCAdd2, "Address Line 2:");
		fc.chkText(UIMapMyLowes.lblRqstMLCCity, "City:");
		fc.chkText(UIMapMyLowes.lblRqstMLCState, "State:");
		fc.chkText(UIMapMyLowes.lblRqstMLCzipCode, "ZIP Code:");
		fc.chkText(UIMapMyLowes.lblRqstMLCTxt2, "The address you've entered will be saved as your primary address.");
		fc.chkText(UIMapMyLowes.lblRqstMLCTxt3, "By clicking Submit, you agree to the Terms and Conditions");
		chkElementDisplayed("id",UIMapMyLowes.txtAddress1 ,"Address line 1 Field");
		chkElementDisplayed("id",UIMapMyLowes.txtAddress2 ,"Address line 2 Field");
		chkElementDisplayed("id",UIMapMyLowes.txtCity ,"City Field");
		chkElementDisplayed("id",UIMapMyLowes.txtState ,"State Field");
		chkElementDisplayed("id",UIMapMyLowes.txtZip ,"Zip code Field");
		chkElementDisplayed("id",UIMapMyLowes.btnCardRegSubmit ,"Submit Button");
		fc.chkText(UIMapMyLowes.lblRqstMLCtxt4, "All Your Receipts."+'\n'+"All in One Place.");
		fc.chkText(UIMapMyLowes.lblRqstMLCtxt5, "Here's how purchase tracking works:");
		fc.chkText(UIMapMyLowes.lblRqstMLCtxt6, "When you buy something in-store, give your phone number OR your MyLowe's card to the associate at checkout.");
		fc.chkText(UIMapMyLowes.lblRqstMLCtxt7, "When you log in later, you'll see your purchase.");
		
		
	}
	
	public void chkRqstAdditionalCardDisplayOption2() throws Exception
	{
		ClickCustomize("xpath", UIMapMyLowes.lblRqstMLCOption2);
		Thread.sleep(2000);
		
		fc.chkText(UIMapMyLowes.lblRqstMLCTxt, "Choose how you'd like to track your in-store purchases.");
		chkElementDisplayed("xpath",UIMapMyLowes.rdoBtnMLCOption1 ,"I'll use my phone number. Radiobutton");
		
		fc.chkText(UIMapMyLowes.lblRqstMLCNbr, "MyLowe's Card Number:");
		chkElementDisplayed("xpath",UIMapMyLowes.txtMLCNbr, "MyLowe's Card Number: field");
		fc.chkText(UIMapMyLowes.lblRqstMLCPhnNbr, "Phone Number:");
		chkElementDisplayed("xpath",UIMapMyLowes.txtMLCPhnNbr ,"Phone Number: field");
		fc.chkText(UIMapMyLowes.lblYourMLCNbr, "Your MyLowe's Card Number");
		fc.chkText(UIMapMyLowes.lblMLCOnCard, "Find your number on the back of the card.");
		chkElementDisplayed("xpath",UIMapMyLowes.webElmntMLCImg ,"MLC Contextual help image");
		
		chkElementDisplayed("xpath",UIMapMyLowes.rdoBtnMLCOption3 ,"Send me a MyLowe's card. Radiobutton");
		fc.chkText(UIMapMyLowes.lblRqstMLCOption3, "Send me a MyLowe's card.");
		
		chkElementDisplayed("id",UIMapMyLowes.btnCardRegSubmit ,"Submit Button");
		fc.chkText(UIMapMyLowes.lblRqstMLCTxt3, "By clicking Submit, you agree to the Terms and Conditions");
	}
	
	public void chkRqstAdditionalCardDisplayOption1() throws Exception
	{
		ClickCustomize("xpath", UIMapMyLowes.lblRqstMLCOption1);
		Thread.sleep(2000);
		
		
		fc.chkText(UIMapMyLowes.lblRqstMLCPhnNbr1, "Phone Number:");
		chkElementDisplayed("xpath",UIMapMyLowes.txtMLCPhnNbr1 ,"Phone Number: field");
		chkElementDisplayed("xpath",UIMapMyLowes.rdoBtnMLCOption2 ,"I have a MyLowe's card to register. Radiobutton");
		fc.chkText(UIMapMyLowes.lblRqstMLCOption2, "I have a MyLowe's card to register.");
		chkElementDisplayed("xpath",UIMapMyLowes.rdoBtnMLCOption3 ,"Send me a MyLowe's card. Radiobutton");
		fc.chkText(UIMapMyLowes.lblRqstMLCOption3, "Send me a MyLowe's card.");
		
		chkElementDisplayed("id",UIMapMyLowes.btnCardRegSubmit ,"Submit Button");
		fc.chkText(UIMapMyLowes.lblRqstMLCTxt3, "By clicking Submit, you agree to the Terms and Conditions");
	}
	
	
	public void chkDeactivateMLCDisplay() throws Exception
	{
		ClickCustomize("partialLinkText", "Deactivate");
		Thread.sleep(3000);
		
		fc.chkText(UIMapMyLowes.lblDeactivateDialogtxt, "Wait! If you deactivate this card number, you'll no longer be able to use it to track your in-store purchases or view your purchase history.");
		fc.chkText(UIMapMyLowes.btnDeactivateCard2, "Deactivate Card");
		fc.chkText(UIMapMyLowes.btnDeactivateCardCancel, "Cancel");
		
		ClickCustomize("linkText", "Cancel");
		Thread.sleep(2000);
		
		ClickCustomize("partialLinkText", "Deactivate");
		Thread.sleep(2000);
		ClickCustomize("xpath", UIMapMyLowes.btnDeactivateCard2);
		Thread.sleep(5000);
		fc.chkText(UIMapMyLowes.lblCardDeactivated, "Card #"+dataTable.getData("General_Data", "MLCNbr")+" has been deactivated.");
	}
	
	
	/**navigates to Preferences**/
	public void navigatePreferences() throws Exception
	{
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.id(UIMapMyLowes.lnkMyAccount));
		actions.moveToElement(menuHoverLink).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(2000);
		//WebElement subLink = driver.findElement(By.id(UIMapMyLowes.lnkHomeProfile));
		WebElement subLink = driver.findElement(By.partialLinkText("Preferences"));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		selenium.waitForPageToLoad("30000");
		
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.lblBreadCrumb2)).getText();
		System.out.println(varMyLowes);
		
		if (varMyLowes.contains("Preferences")) {
			report.updateTestLog("Clicking Your Account link-Preferences",
					"Reminders page displayed", Status.PASS);
		} else {
			report.updateTestLog("Clicking Your Account link-Preferences",
					"Reminders page NOT displayed", Status.FAIL);
		}
	}
	
	//Nupur TCs 21st March
public void purchaseHistoryInvalidTrans()throws Exception{
		
		//click on add purchases button
		driver.findElement(By.linkText("Add Purchase")).click();
		Thread.sleep(2000);
		//select in-store from drop down
		driver.findElement(By.id("purchaseType")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select[@id='purchaseType']/option[2]")).click();
		Thread.sleep(2000);
		
		//verify the display of Transaction Number
		try {
		boolean transNoLabel = driver.findElement(By.xpath("//div[@id='inStorePurchaseForm']/form/div[1]/label")).isDisplayed();
		boolean transNoTxtBox = driver.findElement(By.id("transNumber")).isDisplayed();
		if ((transNoLabel) && (transNoTxtBox))
		{
			report.updateTestLog("Validating the display of Transaction number label and input box",
					"Transaction number label and input box are displayed in the Add Purchases section", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the display of Transaction number label and input box",
					"Transaction number label and input box are not displayed in the Add Purchases section", Status.FAIL);
		}
		} catch(Exception e)
		{
			report.updateTestLog("Validating the display of Transaction number label and input box",
					"User has not selected Purchase type as In-store or does not have MLC card", Status.FAIL);
		}
		
		//verify the display of Purchase Date
		try {
		boolean PurchaseDateLabel = driver.findElement(By.xpath("//div[@id='inStorePurchaseForm']/form/div[2]/label")).isDisplayed();
		boolean PurchaseDateTxtBox = driver.findElement(By.id("purchaseDate")).isDisplayed();
		if ((PurchaseDateLabel) && (PurchaseDateTxtBox))
		{
			report.updateTestLog("Validating the display of Purchase Date label and input box",
					"Purchase Date label and input box are displayed in the Add Purchases section", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the display of Purchase Date label and input box",
					"Purchase Date label and input box are not displayed in the Add Purchases section", Status.FAIL);
		}
		} catch(Exception e)
		{
			report.updateTestLog("Validating the display of Purchase Date label and input box",
					"User has not selected Purchase type as In-store or does not have MLC card", Status.FAIL);
		}
		
		//verify the display of Store Number
		try {
		boolean StoreNumberLabel = driver.findElement(By.xpath("//div[@id='inStorePurchaseForm']/form/div[3]/label")).isDisplayed();
		boolean StoreNumberTxtBox = driver.findElement(By.id("storeNumber")).isDisplayed();
		if ((StoreNumberLabel) && (StoreNumberTxtBox))
		{
			report.updateTestLog("Validating the display of Store Number label and input box",
					"Store Number label and input box are displayed in the Add Purchases section", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the display of Store Number label and input box",
					"Store Number label and input box are not displayed in the Add Purchases section", Status.FAIL);
		}
		} catch(Exception e)
		{
			report.updateTestLog("Validating the display of Store Number label and input box",
					"User has not selected Purchase type as In-store or does not have MLC card", Status.FAIL);
		}
		
		// enter invalid data in fields and validate the display of error message
		
		driver.findElement(By.id("transNumber")).sendKeys(dataTable.getData("General_Data", "transNumber"));
		Thread.sleep(2000);
		driver.findElement(By.id("purchaseDate")).sendKeys(dataTable.getData("General_Data", "month"));
		Thread.sleep(2000);
		driver.findElement(By.id("storeNumber")).sendKeys(dataTable.getData("General_Data", "zipcode2"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='inStorePurchaseForm']/form/div[4]/button")).click();
		Thread.sleep(6000);
		
		String errorMsg = driver.findElement(By.xpath("//div[@id='findPurchase']/div[2]/div[1]")).getText();
		System.out.println(errorMsg);
		if (errorMsg.contains("We're sorry, but we're unable to locate your purchase at this time. It can take up to 24 hours for in-store purchases to appear in search results. Please try again later, or call Customer Care at 1-800-44-LOWES (56937) for further assistance."))
		{
			report.updateTestLog("Validating the display of Error message",
					"Error message is displayed in the Add Purchases section", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the display of Error message",
					"Error message is not displayed in the Add Purchases section", Status.FAIL);
		}
		
		//validate that the search fields are still visible and populated
		String transNumber1 = driver.findElement(By.id("transNumber")).getAttribute("value");
		String purchaseDate1 = driver.findElement(By.id("purchaseDate")).getAttribute("value");
		String storeNumber1 = driver.findElement(By.id("storeNumber")).getAttribute("value");
		if (
				(transNumber1.equals((dataTable.getData("General_Data", "transNumber"))))&&
				(purchaseDate1.equals((dataTable.getData("General_Data", "month"))))&&
				(storeNumber1.equals((dataTable.getData("General_Data", "zipcode2")))) 
			)
		{
			report.updateTestLog("Validating if the search fields are still visible and populated",
					"The search fields are still visible and populated", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating if the search fields are still visible and populated",
					"The search fields are not visible and populated", Status.FAIL);
		}
		
	}
	
	
	// function to navigate to Your Account->Purchases as an anonymous user
	
	public void yourAccountPurchasesAZ() throws Exception {
		Actions actions = new Actions(driver);
		try{
			WebElement menuHoverLink = driver.findElement(By.id("nav-my-account"));
			Thread.sleep(6000);
			actions.moveToElement(menuHoverLink).build().perform();
			}
			catch(Exception e){
				driver.findElement(By.linkText("No, thanks")).click();
	            report.updateTestLog("Survey Popup","Handeled", Status.DONE);
				WebElement menuHoverLink = driver.findElement(By.id("nav-my-account"));
				Thread.sleep(6000);
				actions.moveToElement(menuHoverLink).build().perform();
			}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		WebElement subLink = driver.findElement(By.id("nav-my-order"));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		String varMyLowes = driver.findElement(
				By.xpath("//*[@id='breadcrumbs']/ul/li[3]")).getText();
		System.out.println(varMyLowes);
		if (varMyLowes.contains("Find Purchase")) {
			report.updateTestLog("Clicking Your Account link->Purchases for Anonymous user",
					"Find Purchase page displayed", Status.PASS);
		} else {
			report.updateTestLog("Clicking Your Account link->Purchases for Anonymous user",
					"Find Purchase page NOT displayed", Status.FAIL);
		}
	}
	
	//Sign in from Find Purchases page
	public void loginFromFindPurchases() throws Exception {
		
		driver.findElement(By.id("Ecom_User_ID")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("Ecom_User_ID")).sendKeys(dataTable.getData("General_Data","email"));
		driver.findElement(By.id("logonPassword")).sendKeys(dataTable.getData("General_Data", "password"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(Keys.ENTER);
		selenium.waitForPageToLoad("20000");
		Thread.sleep(10000);
	//	waitforVisible(driver, UIMapFunctionalComponents.webElmntSalutation, 20);
		String getLoggedInUser=driver.findElement(By.xpath(UIMapFunctionalComponents.webElmntSalutation)).getText().trim();
		System.out.println("Verifying the Registered User detais :"+getLoggedInUser);
		if(getLoggedInUser.contains("Welcome, "+dataTable.getData("General_Data","Firstname")))          // Verifying the registered user details by Using Firstname
		{
			report.updateTestLog("Validating Login Credentials","Login Successful", Status.PASS);
		}
		else
		{
			invalidloginFlag = true;
			report.updateTestLog("Validating Login Credentials","Login Failed..! for User "+dataTable.getData("General_Data","email")+" ", Status.FAIL);
		}
		
		
	}
	
	//Sign out from Find Purchases page
	public void signOutFromFindPurchases() throws Exception {
		try{
		driver.findElement(By.xpath("//div[@id='find-orders']/div/div/div/a")).click();	
		}catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath("//div[@id='find-orders']/div/div/div/a")).click();
		}
		selenium.waitForPageToLoad("20000");
		
		if(driver.getTitle().contains("Find Purchase"))
		{
			report.updateTestLog("Click functionality of Sign Out Link on Find Purchases page", 
					"User Stays on 'Find purchases' page as AZ user",Status.PASS);
		} else {
			report.updateTestLog("Click functionality of Sign Out Link on Find Purchases page", 
					"User doesn't stay on 'Find purchases' page",Status.FAIL);
		}
		
	}
	
	public void findPurchasesLoginUser()throws Exception{
	
		//validating step 9 of test case. Find Purchases page for logged in user.
		//verifying the display of dropdown 'Select Purchase type'.
		driver.findElement(By.id("purchaseType")).click();
		Thread.sleep(1000);
		
		if (driver.findElement(By.xpath("//select[@id='purchaseType']/option[1]")).isDisplayed())
		{
			String a = driver.findElement(By.xpath("//select[@id='purchaseType']/option[1]")).getText();
			report.updateTestLog("Validating the contents of Select Purchase Type dropdown",
					" "+a+" is displayed as first option", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the contents of Select Purchase Type dropdown",
					"Select Purchase Type dropdown is not displayed properly", Status.FAIL);
		}
		
		if (driver.findElement(By.xpath("//select[@id='purchaseType']/option[2]")).isDisplayed())
		{
			String b = driver.findElement(By.xpath("//select[@id='purchaseType']/option[2]")).getText();
			report.updateTestLog("Validating the contents of Select Purchase Type dropdown",
					" "+b+" is displayed as second option", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the contents of Select Purchase Type dropdown",
					"Select Purchase Type dropdown is not displayed properly", Status.FAIL);
		}
		
		//Select In-Store Special Order from dropdown
		driver.findElement(By.xpath("//select[@id='purchaseType']/option[2]")).click();
		
		//validate the left side box
		try{
		String leftBoxText = driver.findElement(By.xpath("//div[@id='find-orders']/div[1]/div[1]")).getText();
		if  (
				(leftBoxText.contains("You are signed in as:")) &
				(leftBoxText.contains(dataTable.getData("General_Data","Firstname"))) &
				(leftBoxText.contains(dataTable.getData("General_Data","email"))) &
				(leftBoxText.contains("Sign Out"))
			) 
		{
				report.updateTestLog("Validating the contents of left side box",
					" Name and email id are displayed properly", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the contents of left side box",
					" Name and email id are not displayed properly", Status.PASS);
		}
		} catch(Exception e)
		{
			report.updateTestLog("Validating the display of left side box",
					" Left hand side box is not displayed.", Status.PASS);
		}
		
		//go to Your account->Purchases
		yourAccountPurchases();

		
		//validating step 5 of test case. Verify text at the bottom of purchases page
		String disclaimer1 = driver.findElement(By.xpath("//div[@id='order-history']/div[3]")).getText();
		System.out.println(disclaimer1);
		String disclaimer2 = driver.findElement(By.xpath("//div[@id='order-history']/div[4]")).getText();
		System.out.println(disclaimer2);
		if ( 
			(disclaimer1.contains("Don't see a purchase? Still have your receipt?")) &
			(disclaimer2.contains("** Items purchased in store will appear in your purchase history within 24 hours of purchase.")) &
			(disclaimer2.contains("** Items returned in store will remain visible in your purchase history."))	&
			(disclaimer2.contains("** Results can't be used as receipts for returns."))
		   )
		{
			report.updateTestLog("Validating the display of disclaimer at the bottom of Purchases",
					"Disclaimer is displayed properly", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the display of disclaimer at the bottom of Purchases",
					"Disclaimer is not displayed properly", Status.FAIL);
		}
		//Step 6. click on Add Purchases button
		driver.findElement(By.linkText("Add Purchase")).click();
		Thread.sleep(2000);
		
		//verifying the text present on add purchases section
		String text1 = driver.findElement(By.xpath("//div[@id='findPurchase']/p")).getText();
		if (text1.contains("Complete the form below to find a prior purchase. Certain transactions can then be added to your purchase history."))
		{
			report.updateTestLog("Validating the display of text at the top of Add Purchases page",
					"Text is displayed properly", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the display of text at the top of Add Purchases page",
					"Text is not displayed properly", Status.FAIL);
		}
		//verifying the display of dropdown
		driver.findElement(By.id("purchaseType")).click();
		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//select[@id='purchaseType']/option[1]")).isDisplayed())
		{
			String a = driver.findElement(By.xpath("//select[@id='purchaseType']/option[1]")).getText();
			report.updateTestLog("Validating the contents of Select Purchase Type dropdown",
					" "+a+" is displayed as first option", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the contents of Select Purchase Type dropdown",
					"Select Purchase Type dropdown is not displayed properly", Status.FAIL);
		}
		
		if (driver.findElement(By.xpath("//select[@id='purchaseType']/option[2]")).isDisplayed())
		{
			String b = driver.findElement(By.xpath("//select[@id='purchaseType']/option[2]")).getText();
			report.updateTestLog("Validating the contents of Select Purchase Type dropdown",
					" "+b+" is displayed as second option", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the contents of Select Purchase Type dropdown",
					"Select Purchase Type dropdown is not displayed properly", Status.FAIL);
		}
		if (driver.findElement(By.xpath("//select[@id='purchaseType']/option[3]")).isDisplayed())
		{
			String c = driver.findElement(By.xpath("//select[@id='purchaseType']/option[3]")).getText();
			report.updateTestLog("Validating the contents of Select Purchase Type dropdown",
					" "+c+" is displayed as third option", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the contents of Select Purchase Type dropdown",
					"Select Purchase Type dropdown is not displayed properly", Status.FAIL);
		}
		
		//step 11. Select Online Purchases option from dropdown.
		driver.findElement(By.xpath("//select[@id='purchaseType']/option[1]")).click();
		//enter invalid order no
		driver.findElement(By.id("confNumber")).sendKeys(dataTable.getData("General_Data", "OrderNumber1"));
		driver.findElement(By.xpath("(//button[@type='submit'])[4]")).click();
		Thread.sleep(2000);
		//div[@id='onlinePurchaseForm']/form/div/div/span
		String errorMsg = driver.findElement(By.xpath("//div[@id='onlinePurchaseForm']/form/div[1]/div[1]/label")).getText();
		if (errorMsg.contains("The confirmation number you entered is invalid. Please try again."))
		{
			report.updateTestLog("Validating the display of error message on entering wrong order no",
					"Error message is displayed properly", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the display of error message on entering wrong order no",
					"Error message is not displayed properly", Status.FAIL);
		}
		
		//enter valid order no
		driver.findElement(By.id("confNumber")).clear();
		driver.findElement(By.id("confNumber")).sendKeys(dataTable.getData("General_Data", "OrderNumber2"));
		driver.findElement(By.xpath("(//button[@type='submit'])[4]")).click();
		Thread.sleep(6000);
		
		//div[@id='onlinePurchaseForm']/form/div/div/span
		String confirmationMsg = driver.findElement(By.xpath("//div[@id='findPurchase']")).getText();
		System.out.println(confirmationMsg);
		if (confirmationMsg.contains("Results for Confirmation"))
		{
			report.updateTestLog("Validating the display of Order details on entering correct order no",
					"Order details are displayed properly", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the display of error message on entering wrong order no",
					"Order details are not displayed properly", Status.FAIL);
		}
		Thread.sleep(2000);
		
		// click on Modify Search button
		driver.findElement(By.linkText("Modify Search")).click();
		//verifying the display of dropdown
		driver.findElement(By.id("purchaseType")).click();
		Thread.sleep(1000);
		
		//select In store special order from dropdown
		driver.findElement(By.xpath("//select[@id='purchaseType']/option[3]")).click();
		Thread.sleep(1000);
		
		//clear master order no field
		driver.findElement(By.id("moNumber")).clear();
		
		//enter invalid PO no with valid format
		driver.findElement(By.id("poNumber")).sendKeys(dataTable.getData("General_Data", "PO1"));
		driver.findElement(By.xpath("(//button[@type='submit'])[6]")).click();
		Thread.sleep(2000);
		
		String errorMsg1 = driver.findElement(By.xpath("//div[@id='findPurchase']/div[2]/div[1]")).getText();
		if (errorMsg1.contains("We could not find the P.O. number you entered. Please re-enter your P.O. number."))
		{
			report.updateTestLog("Validating the display of error message on entering wrong PO no with valid format",
					"Error message is displayed properly", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the display of error message on entering wrong PO no with valid format",
					"Error message is not displayed properly", Status.FAIL);
		}
		//enter invalid PO no with invalid format
		driver.findElement(By.id("poNumber")).click();
		driver.findElement(By.id("poNumber")).clear();
		driver.findElement(By.id("poNumber")).sendKeys(dataTable.getData("General_Data", "PO2"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@type='submit'])[6]")).click();
		Thread.sleep(2000);
		
		String errorMsg2 = driver.findElement(By.xpath("//div[@id='poNumberDiv']/label")).getText();
		if (errorMsg2.contains("The P.O. number you entered is invalid. Please try again."))
		{
			report.updateTestLog("Validating the display of error message on entering wrong PO no with invalid format",
					"Error message is displayed properly", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the display of error message on entering wrong PO no with invalid format",
					"Error message is not displayed properly", Status.FAIL);
		}
		//click on add to purchase without entering anything
		driver.findElement(By.id("poNumber")).clear();
		driver.findElement(By.xpath("(//button[@type='submit'])[6]")).click();
		Thread.sleep(2000);
		
		String errorMsg3 = driver.findElement(By.xpath("//div[@id='poNumberDiv']/label")).getText();
		if (errorMsg3.contains("This field is required."))
		{
			report.updateTestLog("Validating the display of error message on entering no PO number",
					"Error message is displayed properly", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the display of error message on entering no PO number",
					"Error message is not displayed properly", Status.FAIL);
		}
		
		/****Added by Ankita 03/23**/
		driver.findElement(By.xpath(UIMapMyLowes.txtPONbr)).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtPONbr)).clear();
	    driver.findElement(By.xpath(UIMapMyLowes.txtPONbr)).sendKeys(dataTable.getData("General_Data","PONbr"));
	    
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnAddSpecialOrderPurchase)).click();
	    Thread.sleep(5000);

	    if(driver.findElement(By.xpath(UIMapMyLowes.txtPurchaseConfResults)).getText().
	    		equals("Results for PO #"+dataTable.getData("General_Data","PONbr"))){
	    			report.updateTestLog("Verifying the PO search in Purchases ","Verification is successful", Status.PASS);
	    		}
	    else{
	    	report.updateTestLog("Verifying the PO search in Purchases ","Verification is not successful", Status.FAIL);
	    	}
		
	}
	
	public void yourAccountPurchases() throws Exception {
		Actions actions = new Actions(driver);
		try{
			WebElement menuHoverLink = driver.findElement(By.id("nav-my-account"));
			Thread.sleep(6000);
			actions.moveToElement(menuHoverLink).build().perform();
			}
			catch(Exception e){
				driver.findElement(By.linkText("No, thanks")).click();
	            report.updateTestLog("Survey Popup","Handeled", Status.DONE);
				WebElement menuHoverLink = driver.findElement(By.id("nav-my-account"));
				Thread.sleep(6000);
				actions.moveToElement(menuHoverLink).build().perform();
			}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		WebElement subLink = driver.findElement(By.id("nav-my-order"));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.lblBreadCrumb3)).getText();
		System.out.println(varMyLowes);
		if (varMyLowes.equals("Purchases")) {
			report.updateTestLog("Clicking Your Account link",
					"MyLowe's page displayed", Status.PASS);
		} else {
			report.updateTestLog("Clicking Your Account link",
					"MyLowe's page NOT displayed", Status.FAIL);
		}
	}
	
	public void findPurchasesAZUser()throws Exception{
		//verfifying the display of text at the top
		String txt = driver.findElement(By.xpath("//div[@id='find-orders']/div[2]/div[1]/div[1]/p[2]")).getText();
		if (txt.contains("Complete the form below to find a prior purchase. Certain transactions can then be added to your purchase history."))
		{
			report.updateTestLog("Validating the display of text at the top",
					"Text at the top of the page is displayed properly", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the display of text at the top",
					"Text at the top of the page is not displayed properly", Status.FAIL);
		}
		
		//verifying the display of dropdown 'Select Purchase type'.
		driver.findElement(By.id("purchaseType")).click();
		Thread.sleep(1000);
		
		if (driver.findElement(By.xpath("//select[@id='purchaseType']/option[1]")).isDisplayed())
		{
			String a = driver.findElement(By.xpath("//select[@id='purchaseType']/option[1]")).getText();
			report.updateTestLog("Validating the contents of Select Purchase Type dropdown",
					" "+a+" is displayed as first option", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the contents of Select Purchase Type dropdown",
					"Select Purchase Type dropdown is not displayed properly", Status.FAIL);
		}
		
		if (driver.findElement(By.xpath("//select[@id='purchaseType']/option[2]")).isDisplayed())
		{
			String b = driver.findElement(By.xpath("//select[@id='purchaseType']/option[2]")).getText();
			report.updateTestLog("Validating the contents of Select Purchase Type dropdown",
					" "+b+" is displayed as second option", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the contents of Select Purchase Type dropdown",
					"Select Purchase Type dropdown is not displayed properly", Status.FAIL);
		}
		
		//validate error message display after login with invalid credentials
		loginFromFindPurchases();
		if (invalidloginFlag == true)
		{
			try{
				String errMsg = driver.findElement(By.xpath("//form[@id='Logon']/div[1]/div[1]/div[2]")).getText();
				if (errMsg.contains("Please enter a valid log-in ID or email address and password."))
				{
					report.updateTestLog("Validating the display of error message after invalid login credentials",
							"Error message is displayed properly", Status.PASS);
				}
				else
				{
					report.updateTestLog("Validating the display of error message after invalid login credentials",
							"Error message is not displayed properly", Status.FAIL);
				}
				
			} catch(Exception e)
			{
				report.updateTestLog("Validating the display of error message after invalid login credentials",
						"Error message is not displayed", Status.FAIL);
			}
			
		}
		
		//navigate back
		driver.navigate().back();
		Thread.sleep(1000);
		
		//click on Sign up
		driver.findElement(By.xpath("(//a[contains(text(),'Sign Up')])[2]")).click();
		selenium.waitForPageToLoad("20000");
		if(driver.getTitle().contains("Lowe's: Registration"))
		{
			report.updateTestLog("Click functionality of 'Sign up' link", 
					"Register page is displayed",Status.PASS);
		} else {
			report.updateTestLog("Click functionality of 'Sign up' link", 
					"Register page is not displayed",Status.FAIL);
		}
	
		//navigate back
		driver.navigate().back();
		Thread.sleep(1000);
		
		//forgot password. cannot check the functionality through automation. only validaing the display of popup
		driver.findElement(By.id("forgotPasswordLink")).click();
		
		if (driver.findElement(By.xpath("//input[@id='resetLogonId']")).isDisplayed())
		{
			report.updateTestLog("Validating the display of Forgot password popup", 
					"Forgot password popup is displayed",Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the display of Forgot password popup", 
					"Forgot password popup is not displayed",Status.FAIL);
		}
		
		//close the pop up
		driver.navigate().refresh();
		
		
		
		//Select Online Purchases option from dropdown.
		driver.findElement(By.xpath("//select[@id='purchaseType']/option[1]")).click();
		//enter invalid order no
		driver.findElement(By.id("confNumber")).sendKeys(dataTable.getData("General_Data", "OrderNumber1"));
		driver.findElement(By.id("findOrdersSubmit")).click();
		Thread.sleep(2000);
		//div[@id='onlinePurchaseForm']/form/div/div/span
		String errorMsg = driver.findElement(By.xpath("//fieldset[@id='containerSOM']/label[2]")).getText();
		if (errorMsg.contains("The confirmation number you entered is invalid. Please try again."))
		{
			report.updateTestLog("Validating the display of error message on entering wrong order no",
					"Error message is displayed properly", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the display of error message on entering wrong order no",
					"Error message is not displayed properly", Status.FAIL);
		}
		//enter invalid order no in invalid format
		Thread.sleep(3000);
		driver.findElement(By.id("confNumber")).clear();
		driver.findElement(By.id("confNumber")).sendKeys(dataTable.getData("General_Data", "OrderNumber2"));
		driver.findElement(By.id("findOrdersSubmit")).click();
		Thread.sleep(2000);
		String errorMsg1 = driver.findElement(By.xpath("//fieldset[@id='containerSOM']/label[2]")).getText();
		if (errorMsg1.contains("The confirmation number you entered is invalid. Please try again."))
		{
			report.updateTestLog("Validating the display of error message on entering wrong order no with invalid format",
					"Error message is displayed properly", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the display of error message on entering wrong order no with invalid format",
					"Error message is not displayed properly", Status.FAIL);
		}
		//click on Find purchase without entering order no
		driver.findElement(By.id("confNumber")).clear();
		driver.findElement(By.id("findOrdersSubmit")).click();
		Thread.sleep(2000);
		String errorMsg2 = driver.findElement(By.xpath("//fieldset[@id='containerSOM']/label[2]")).getText();
		if (errorMsg2.contains("This field is required."))
		{
			report.updateTestLog("Validating the display of error message on entering blank order no",
					"Error message is displayed properly", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the display of error message on entering blank order no",
					"Error message is not displayed properly", Status.FAIL);
		}
		//enter valid order no
		
		driver.findElement(By.id("confNumber")).clear();
		driver.findElement(By.id("confNumber")).sendKeys(dataTable.getData("General_Data", "OrderNumber3"));
		driver.findElement(By.id("findOrdersSubmit")).click();
		selenium.waitForPageToLoad("20000");
		if(driver.getTitle().contains("Order #"+dataTable.getData("General_Data","OrderNumber3")))
		{
			report.updateTestLog("Validating the display of Order details on entering correct order no",
					"Order details are displayed properly", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the display of error message on entering correct order no",
					"Order details are not displayed properly", Status.FAIL);
		}
		
		Thread.sleep(2000);
		//navigate back
		driver.navigate().back();
		Thread.sleep(1000);
				
		//select In store special order from dropdown
		driver.findElement(By.xpath("//select[@id='purchaseType']/option[2]")).click();
		Thread.sleep(1000);
		
		//clear master order no field
		driver.findElement(By.id("moNumber")).clear();
		
		//enter invalid PO no with valid format
		driver.findElement(By.id("poNumber")).sendKeys(dataTable.getData("General_Data", "PO1"));
		driver.findElement(By.id("findOrdersSubmit")).click();
		selenium.waitForPageToLoad("20000");
		
		String errorMsg3 = driver.findElement(By.xpath("//div[@id='find-orders']/div[2]/div[1]/div[2]")).getText();
		if (errorMsg3.contains("We could not find the P.O. number you entered. Please re-enter your P.O. number."))
		{
			report.updateTestLog("Validating the display of error message on entering wrong PO no with valid format",
					"Error message is displayed properly", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the display of error message on entering wrong PO no with valid format",
					"Error message is not displayed properly", Status.FAIL);
		}
		//enter invalid PO no with invalid format
		driver.findElement(By.id("poNumber")).click();
		driver.findElement(By.id("poNumber")).clear();
		driver.findElement(By.id("poNumber")).sendKeys(dataTable.getData("General_Data", "PO2"));
		Thread.sleep(1000);
		driver.findElement(By.id("findOrdersSubmit")).click();
		Thread.sleep(2000);
		
		String errorMsg4 = driver.findElement(By.xpath("//fieldset[@id='containerOMS']/ul/li[2]/label[1]")).getText();
		if (errorMsg4.contains("The P.O. number you entered is invalid. Please try again."))
		{
			report.updateTestLog("Validating the display of error message on entering wrong PO no with invalid format",
					"Error message is displayed properly", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the display of error message on entering wrong PO no with invalid format",
					"Error message is not displayed properly", Status.FAIL);
		}
		//click on add to purchase without entering anything
		driver.findElement(By.id("poNumber")).clear();
		driver.findElement(By.id("findOrdersSubmit")).click();
		selenium.waitForPageToLoad("20000");
		//Boolean errorMsg5 = driver.findElement(By.xpath("//div[@id='find-orders']/div[2]/div[1]/div[2]")).isDisplayed();
		//Boolean errorMsg6 = driver.findElement(By.xpath("//fieldset[@id='containerOMS']/ul/li[2]/label")).isDisplayed();
		if (
				(driver.findElement(By.xpath("//div[@id='find-orders']/div[2]/div[1]/div[2]")).isDisplayed()) ||
				(driver.findElement(By.xpath("//fieldset[@id='containerOMS']/ul/li[2]/label")).isDisplayed())
			)	
		{
			report.updateTestLog("Validating the display of error message on entering no PO number",
					"Error message is displayed properly", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the display of error message on entering no PO number",
					"Error message is not displayed properly", Status.FAIL);
		}
		
		/****Added by Ankita 03/23**/
		//valid PO Nbr
		ClickCustomize("xpath", UIMapMyLowes.txtPONbr);
		driver.findElement(By.xpath(UIMapMyLowes.txtPONbr)).sendKeys(dataTable.getData("General_Data", "PONbr"));
		//driver.findElement(By.xpath(UIMapMyLowes.txtPONbr)).sendKeys(Keys.ENTER);
		ClickCustomize("id", "findOrdersSubmit"); 
		Thread.sleep(2000);
		selenium.waitForPageToLoad("20000");

		fc.chkPagetitle("Order #"+dataTable.getData("General_Data", "PONbr"));
		
	}
	
	/**Checks whether the option to link purchase to MLC os displayed or not*/
	public void chklinkPurchaseToMLCOption() throws Exception
	{
		boolean option;
		try{
		option=driver.findElement(By.partialLinkText("Attach this purchase to your MyLowe's card")).isDisplayed();
		
		}
		catch(Exception e)
		{
			option=driver.findElement(By.xpath(UIMapMyLowes.drpDownSelectMLCForLinking)).isDisplayed();
			
		}
		if(option)
		{
			report.updateTestLog("Checking An option to link purchase to MLC", "Option to link purchase to MLC displayed", Status.PASS);
		
		}
		else
			report.updateTestLog("Checking An option to link purchase to MLC", "Option to link purchase to MLC NOT displayed", Status.FAIL);
	}
	
	/**attaches an Instore Purchase to MLC*/
	public void linkPurchaseToMLC() throws Exception
	{
		try{
		ClickCustomize("partialLinkText", "Attach this purchase to your MyLowe's card");
		Thread.sleep(5000);
		}
		catch(Exception e)
		{
			System.out.println("Multiple cards");
			new Select(driver.findElement(By.xpath(UIMapMyLowes.drpDownSelectMLCForLinking))).selectByVisibleText(dataTable.getData("General_Data", "MLCNbr"));
			Thread.sleep(1000);
			ClickCustomize("xpath", UIMapMyLowes.btnAddOrderToMLC);
			Thread.sleep(5000);
		}
		String varMsg="You've successfully attached this purchase to MyLowe's card #"+dataTable.getData("General_Data", "MLCNbr")+". It will appear in this card's purchase history within 24 hours.";
		fc.chkText(UIMapMyLowes.lblInStoreOrderLinkedSuccessMsg, varMsg);
		
	}
	
	/**Validates if the Type/Date filters, Recent Purchases and Disclamer text is displayed on Purchases Page**/
	public void chkPurchaseDisplay() throws Exception 
	{
		chkElementDisplayed("id",UIMapMyLowes.drpDownPurchaseType,"Type dropdown");
		chkElementDisplayed("id",UIMapMyLowes.drpDownPurchaseDate,"Date dropdown");
		chkElementDisplayed("id",UIMapMyLowes.webElmntRecentPurchases,"Recent Purchases");
		fc.chkText(UIMapMyLowes.txtPurchaseDisclaimer1, "Don't see a purchase? Still have your receipt? Add Purchase");
		fc.chkText(UIMapMyLowes.txtPurchaseDisclaimer2, "** Items purchased in store will appear in your purchase history within 24 hours of purchase."
				+'\n'+"** Items returned in store will remain visible in your purchase history."+'\n'+
				"** Results can't be used as receipts for returns.");
	}
	
	/**Validates if the Add Purchase Section is getting displayed or not**/
	public void chkAddPurchaseToggle() throws Exception
	{
		String addPurchaseClicked=dataTable.getData("General_Data", "AddPurchaseClicked");
		boolean varAddPurchaseDisp=driver.findElement(By.xpath(UIMapMyLowes.webElmntAddPurchaseSection)).isDisplayed();
		if(varAddPurchaseDisp)
		{
			if(addPurchaseClicked.equals("Yes"))
				report.updateTestLog("Checking If Add Purchase Section is displayed", "Add Purchase Section displayed", Status.PASS);
			else
				report.updateTestLog("Checking If Add Purchase Section is displayed", "Add Purchase Section displayed", Status.FAIL);
		}
		else
		{
		if(addPurchaseClicked.equals("Yes"))
			report.updateTestLog("Checking If Add Purchase Section is displayed", "Add Purchase Section NOT displayed", Status.FAIL);
		else
			report.updateTestLog("Checking If Add Purchase Section is displayed", "Add Purchase Section NOT displayed", Status.PASS);
			
		}
	}
	
	/**Validates Add Purchase fields**/
	public void chkAddPurchaseFields() throws Exception
	{
		int varCount=fc.countWebElement(UIMapMyLowes.webElmntAddPurchaseOptions);
		if(varCount==3)
		{	
			if(driver.findElement(By.xpath(UIMapMyLowes.lnkFindPurchsDrpdownOption1)).getText().trim().equals("Online / Mobile")
					&& driver.findElement(By.xpath(UIMapMyLowes.lnkFindPurchsDrpdownOption2)).getText().trim().equals("In-Store")
					&& driver.findElement(By.xpath(UIMapMyLowes.lnkFindPurchsDrpdownOption3)).getText().trim().equals("In-Store Special Order"))
			{
				report.updateTestLog("Checking Add Purchase Options", "Add Purchase Options correctly displayed", Status.PASS);
				//selecting Online/mobile
				new Select(driver.findElement(By.id(UIMapMyLowes.drpDownAddPurchsType))).selectByVisibleText("Online / Mobile");
				Thread.sleep(2000);
				fc.chkText(UIMapMyLowes.lblConfNbr, "Confirmation Number or Order Number:");
				chkElementDisplayed("id", UIMapMyLowes.txtConfNo, "Confirmation Number Field");
				//selecting Instore
				new Select(driver.findElement(By.id(UIMapMyLowes.drpDownAddPurchsType))).selectByVisibleText("In-Store");
				Thread.sleep(2000);
				fc.chkText(UIMapMyLowes.lblTransaction, "Transaction Number:");
				fc.chkText(UIMapMyLowes.lblPurchaseDt, "Purchase Date:");
				fc.chkText(UIMapMyLowes.lblStoreNbr, "Store Number:");
				chkElementDisplayed("id",UIMapMyLowes.txtTxnNo,"Transaction Number field");
				chkElementDisplayed("id",UIMapMyLowes.txtPurDate,"Purchase date field");
				chkElementDisplayed("id",UIMapMyLowes.txtStoreNo,"Store Number field");
				//selecting Instore special order
				new Select(driver.findElement(By.id(UIMapMyLowes.drpDownAddPurchsType))).selectByVisibleText("In-Store Special Order");
				Thread.sleep(2000);
				fc.chkText(UIMapMyLowes.lblAddInStoreTxt, "Look up by:");
				chkElementDisplayed("xpath",UIMapMyLowes.rdoButtonPO,"PO Nbr Radio Button");
				chkElementDisplayed("xpath",UIMapMyLowes.txtPONbr,"PO Nbr Field");
				chkElementDisplayed("xpath",UIMapMyLowes.rdoButtonMO,"MO Nbr Radio Button");
				chkElementDisplayed("xpath",UIMapMyLowes.txtMONbr,"MO Nbr Field");
				//checking Add Purchase and Close
				chkElementDisplayed("partialLinkText", "Add Purchase", "Add Purchase button");
				chkElementDisplayed("partialLinkText", "Close","Close link");
			}
			else
				report.updateTestLog("Checking Add Purchase Options", "Add Purchase Options NOT correctly displayed", Status.FAIL);
		}
		else
			report.updateTestLog("Checking Add Purchase Options", "Add Purchase Options Count NOT 3", Status.FAIL);
	}
	
	public void clickAddPurchase() throws Exception
	{
		ClickCustomize("xpath", UIMapMyLowes.btnAddPurchaseInStore);
		Thread.sleep(1000);
	}
	
	public void clickCloseAddPurchase() throws Exception
	{
		ClickCustomize("partialLinkText", "Close");
		Thread.sleep(2000);
		
	}
	
	/**Checks breadcrumbs while on Added InStore Purchase page**/
	public void chkBrdCrumbInStorePurchaseDetails() throws Exception
	{
		fc.chkText(UIMapMyLowes.lnkBrdCrumbLvl1, "Home");
		fc.chkText(UIMapMyLowes.webElmntBrdCrumbsLvl2, "MyLowe's");
		fc.chkText(UIMapMyLowes.webElmntBrdCrumbsLvl3, "Purchases");
	}
	
	/**Validates if Add Purchase button is displayed**/
	public void chkAddPurchaseButton() throws Exception
	{
		chkElementDisplayed("xpath", UIMapMyLowes.btnAddPurchaseInStore, "Add Purchase Button");
		
	}
	

	/**Checks Reminder functionality for Orders with multiple items**/
	public void chkReminderForSingleItemMulOrderItemView() throws Exception
	{
		hp.purchaseSwitchItemView();
		
		//setting Reminder for first item in first order
		ClickCustomize("xpath", UIMapMyLowes.drpDownAddToItemViewAll);
		Thread.sleep(1000);
		ClickCustomize("xpath", UIMapMyLowes.lnkReminderItemViewPurchases);
				Thread.sleep(5000);
				if(selenium.isTextPresent("Continue"))
					{
						ClickCustomize("linkText", "Continue");
						Thread.sleep(1000);
					}
				int varCount=fc.countWebElement("html/body/div");
				System.out.println(varCount);
				chkElementDisplayed("xpath","//div["+varCount+"]","Set Reminder Popup");
				driver.findElement(By.cssSelector("img.ui-datepicker-trigger"))
				.click();
				DateFormat dateFormat = new SimpleDateFormat("d");
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DAY_OF_YEAR, 1);
				Date tomorrow = calendar.getTime();
				String varDate=dateFormat.format(tomorrow);
				System.out.println(varDate);
				driver.findElement(By.linkText(varDate)).click();
				Thread.sleep(1000);
				driver.findElement(
						By.cssSelector("a.button.reminder_notes_save_continue > span"))
						.click();
			Thread.sleep(5000);
			fc.chkText(UIMapMyLowes.lblReminderSetItemView, "Reminder Set");
			
			if(driver.findElement(By.xpath(UIMapMyLowes.webElmntReminderItemViewCheck)).isDisplayed())
				report.updateTestLog("Adding Reminder in Item View", "Reminder Added-Check displayed", Status.PASS);
			else
				report.updateTestLog("Adding Reminder in Item View", "Reminder NOT Added -Check NOT displayed", Status.FAIL);
		//refreshing page and switching to item view
			driver.navigate().refresh();
			selenium.waitForPageToLoad("20000");
			hp.purchaseSwitchItemView();
		//checking reminder set for first item in first order
			ClickCustomize("xpath", UIMapMyLowes.drpDownAddToItemViewAll);
			Thread.sleep(1000);
			String varReminderchk=driver.findElement(By.xpath(UIMapMyLowes.lblReminderItem1stItemView)).getAttribute("title");
			if(varReminderchk.equals("Reminder Set"))
				report.updateTestLog("Checking Reminder for First item in First order", "Reminder SET", Status.PASS);
			else
				report.updateTestLog("Checking Reminder for First item in First order", "Reminder NOT SET", Status.FAIL);
		//checking reminder not set for last item in last order
			ClickCustomize("xpath", UIMapMyLowes.lnkAddTo6thIteminItemView);
			Thread.sleep(1000);
			varReminderchk=driver.findElement(By.xpath(UIMapMyLowes.lblReminderItem6thItemView)).getAttribute("title");
			if(varReminderchk.equals("Set a Reminder"))
				report.updateTestLog("Checking Reminder for last item in last order", "Reminder not SET", Status.PASS);
			else
				report.updateTestLog("Checking Reminder for last item in last order", "Reminder SET", Status.FAIL);
		//purchase view
			purchaseSwitchPurchaseView();
		//selecting last(2nd) order with multiple items
			ClickCustomize("xpath", UIMapMyLowes.lnkPurchaseView2ndOrder);
			selenium.waitForPageToLoad("20000");
		//setting reminder for first item in last order
			ClickCustomize("xpath", UIMapMyLowes.drpDownAddToOnlinePurchsDetails);
			Thread.sleep(1000);
			ClickCustomize("xpath", UIMapMyLowes.lnkReminderPuchaseDetails+"/a/span[2]");
					Thread.sleep(5000);
					
					try{
				Thread.sleep(5000);
				if(selenium.isTextPresent("Continue"))
						{
							ClickCustomize("linkText", "Continue");
							Thread.sleep(1000);
						}
					driver.findElement(By.cssSelector("img.ui-datepicker-trigger"))
					.click();
					dateFormat = new SimpleDateFormat("d");
					calendar = Calendar.getInstance();
					calendar.add(Calendar.DAY_OF_YEAR, 1);
					tomorrow = calendar.getTime();
					varDate=dateFormat.format(tomorrow);
					System.out.println(varDate);
					driver.findElement(By.linkText(varDate)).click();
					Thread.sleep(1000);
					driver.findElement(
							By.cssSelector("a.button.reminder_notes_save_continue > span"))
							.click();
				Thread.sleep(5000);
				fc.chkText(UIMapMyLowes.lnkReminderPuchaseDetails+"/a/span", "Reminder Set");
				
				if(driver.findElement(By.xpath(UIMapMyLowes.lnkReminderPuchaseDetails+"/a/span/img")).isDisplayed())
					report.updateTestLog("Adding Reminder in Item View", "Reminder Added-Check displayed", Status.PASS);
				else
					report.updateTestLog("Adding Reminder in Item View", "Reminder NOT Added -Check NOT displayed", Status.FAIL);
					}
					catch(Exception e)
					{
						report.updateTestLog("Adding Reminder in Item View", "Reminder not addeds", Status.FAIL);
						
					}
				//refreshing page
					driver.navigate().refresh();
					selenium.waitForPageToLoad("20000");	
				//checking reminder set for first item
					ClickCustomize("xpath", UIMapMyLowes.drpDownAddToOnlinePurchsDetails);
					varReminderchk=driver.findElement(By.xpath(UIMapMyLowes.lnkReminderPuchaseDetails+"/a")).getAttribute("title");
					if(varReminderchk.equals("Reminder Set"))
						report.updateTestLog("Checking Reminder for First item", "Reminder SET", Status.PASS);
					else
						report.updateTestLog("Checking Reminder for First item", "Reminder SET", Status.FAIL);
				//checking Reminder not set for last item
					ClickCustomize("xpath", UIMapMyLowes.lnkPurchaseDetailsItem3AddTo);
					varReminderchk=driver.findElement(By.xpath(UIMapMyLowes.lnkPurchaseDetailsItem3Reminder)).getAttribute("title");
					if(varReminderchk.equals("Reminder Set"))
						report.updateTestLog("Checking Reminder for First item", "Set a Reminder", Status.PASS);
					else
						report.updateTestLog("Checking Reminder for First item", "Set a Reminder", Status.FAIL);
	}
	
	/**Checks warning message displayed when No Online Purchases**/
	public void chkErrorMesgOnNoOnlinePurchase() throws Exception
	{
		fc.chkText(UIMapMyLowes.lblType, "Type:");
		fc.chkText(UIMapMyLowes.lblDate, "Date:");
		chkElementDisplayed("id",UIMapMyLowes.drpDownPurchaseType,"Type dropdown");
		chkElementDisplayed("id",UIMapMyLowes.drpDownPurchaseDate,"Date dropdown");
		
		//select Online
		try{driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseType)).click();}
		catch(Exception WebDriverException)
		{
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseType)).click();
		}
		Thread.sleep(1000);
		Select select = new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseType)));
		select.selectByVisibleText("Online");
		selenium.waitForPageToLoad("10000");
		
		fc.chkText(UIMapMyLowes.lblNoPurchase, "You have not made any purchases during this period.");
		
		List<String> varDateOptions=new ArrayList<String>();
		varDateOptions.add("Last 30 days");
		varDateOptions.add("Last 6 months");
		varDateOptions.add("2014");
		varDateOptions.add("2013");
		varDateOptions.add("2012");
		varDateOptions.add("All");
		
		List<String> varDateOptions2=new ArrayList<String>();
		for(int i=1;i<=6;i++)
		{
			varDateOptions2.add(driver.findElement(By.xpath("//*[@id='transaction-date']/option["+i+"]")).getText());
			
		}
		System.out.println("::"+varDateOptions+"::");
		System.out.println("::"+varDateOptions2+"::");
		if(varDateOptions.equals(varDateOptions2))
			report.updateTestLog("Checking Options in Date Filter", "Date Filter options correctly displayed", Status.PASS);
		else
			report.updateTestLog("Checking Options in Date Filter", "Date Filter options NOT correctly displayed", Status.FAIL);
		String varSelected=driver.findElement(By.xpath(UIMapMyLowes.lnkTransactioDtOption1)).getAttribute("selected");
		System.out.println("Selected:"+varSelected);
		if(varSelected.equals("true"))
			report.updateTestLog("Checking Default value in Date Filter", "Default value:Last 30 days selected", Status.PASS);
		else
			report.updateTestLog("Checking Default value in Date Filter", "Default value:Last 30 days selected", Status.FAIL);
		
		try{
			if(driver.findElement(By.id(UIMapMyLowes.drpDownMLC)).isDisplayed())
				report.updateTestLog("Checking MLC Drop-down", " MLC Drop-down displayed", Status.FAIL);
			else
				report.updateTestLog("Checking MLC Drop-down", " MLC Drop-down NOT displayed", Status.PASS);
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking MLC Drop-down", " MLC Drop-down NOT displayed", Status.PASS);
		}
		
		//Last 6 Months
		driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate)).click();
		Thread.sleep(1000);
		Select select2 = new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate)));
		select2.selectByVisibleText("Last 6 months");
		selenium.waitForPageToLoad("10000");
		fc.chkText(UIMapMyLowes.lblNoPurchase, "You have not made any purchases during this period.");
		
		//current year
		driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate)).click();
		Thread.sleep(1000);
		select2 = new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate)));
		select2.selectByVisibleText("2014");
		selenium.waitForPageToLoad("10000");
		fc.chkText(UIMapMyLowes.lblNoPurchase, "You have not made any purchases during this period.");
		
		//previous year
		driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate)).click();
		Thread.sleep(1000);
		select2 = new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate)));
		select2.selectByVisibleText("2013");
		selenium.waitForPageToLoad("10000");
		fc.chkText(UIMapMyLowes.lblNoPurchase, "You have not made any purchases during this period.");
		
		//All
				driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate)).click();
				Thread.sleep(1000);
				select2 = new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate)));
				select2.selectByVisibleText("All");
				selenium.waitForPageToLoad("10000");
				fc.chkText(UIMapMyLowes.lblNoPurchase, "You have not made any purchases during this period.");
		 //invalid Online Conf Nbr
		clickAddPurchase();
		chkAddPurchaseToggle();
		driver.findElement(By.id(UIMapMyLowes.txtConfNo)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtConfNo)).sendKeys(dataTable.getData("General_Data","OrderNbr"));
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnAddPurchase)).click();
	    Thread.sleep(10000);
	    fc.chkText(UIMapMyLowes.txtInvalidConfNoMsg1, "We could not find the confirmation or order number you entered. Please re-enter your confirmation or order number.");
	   
	    
	}
	
	
	/**Stores number of Items displayed in Purchase View for selected filter**/
	public void storeItemCountForSelectedFilter() throws Exception
	{
		int varPgCount=Integer.valueOf(driver.findElement(By.xpath(UIMapMyLowes.lnkPurchaseTotalPage)).getText());
		int i=0;
		int varFound=0;
		int count=0;
		for(i=1;i<=varPgCount;i++)
		{
			int varCount=fc.countWebElement(UIMapMyLowes.webElmntItemViewOrdersOnPg);
			int j;
			
			for(j=1;j<=varCount;j++)
				{
				
				
				String varItemCount=driver.findElement(By.xpath("//*[@id='orderView']/tbody/tr["+j+"]/td[4]")).getText();
				int varItemCountInt=Integer.valueOf(varItemCount);
				count=count+varItemCountInt;
				
				if(j==varCount)	
				{
					if(i<varPgCount)
						ClickCustomize("linkText", "Next");
				}
				
				}
			
			
		}
		System.out.println(count);
		dataTable.putData("General_Data", "ItemCount", String.valueOf(count));
		for(int k=1;k<(i-1);k++)
		{
			ClickCustomize("linkText", "Previous");
			selenium.waitForPageToLoad("20000");
		}
	}
	
	/***counts items displayed in Item View**/
	public void countItemsInItemView() throws Exception
	{
		int varPgCount=Integer.valueOf(driver.findElement(By.xpath(UIMapMyLowes.lnkPurchaseTotalPage)).getText());
		int i=0;
		int count=0;
		//webElmntItemViewItemsAll
		for(i=1;i<=varPgCount;i++)
		{
			int varCount=fc.countWebElement(UIMapMyLowes.webElmntItemViewItemsAll);
			count=count+varCount;
			if(i==varPgCount)
				break;
			ClickCustomize("linkText", "Next");
				
		}
		System.out.println(count);
		System.out.println(dataTable.getData("General_Data", "ItemCount"));
		if(String.valueOf(count).equals(dataTable.getData("General_Data", "ItemCount")))
			report.updateTestLog("Checking Items Displayed in Item View", "Items Displayed as per selected Filter", Status.PASS);
		else
			report.updateTestLog("Checking Items Displayed in Item View", "Items NOT Displayed as per selected Filter", Status.FAIL);
	}
	
	
	/** Validates Online Purchase Detail page for the Returned Items**/
	public void  checkReturnedItemOnlinePurchsDetails() throws Exception
	{
		fc.chkText(UIMapMyLowes.txtPurchaseInfoType, "Return Location:");
		chkElementDisplayed("xpath",UIMapMyLowes.lblAddedInStorePurchaseAt,"Returned Location Value");
		fc.chkText(UIMapMyLowes.lblMLCardNbr, "MyLowe's Card #:");
		chkElementDisplayed("xpath",UIMapMyLowes.lblMLCardNbrValue,"MyLowe's Card #: Value");
		fc.chkText(UIMapMyLowes.txtPurchaseInfoOrder, "Order #");
		chkElementDisplayed("xpath",UIMapMyLowes.lblAddedInStoreInvoiceNbr,"Invloice nbr Value");
		
		
		String varTxt=driver.findElement(By.xpath(UIMapMyLowes.webElmntOnlineDetailsItem1)).getText();
		if(varTxt.contains("RETURNED"))
			report.updateTestLog("Checking Returned Item", "Returned displayed", Status.PASS);
		else
			report.updateTestLog("Checking Returned Item", "Returned NOT displayed", Status.FAIL);
		chkElementDisplayed("xpath","//*[@id='order_detail']/div[2]/h3"," Fulfillment method ");
		chkElementDisplayed("xpath","//*[@id='order_detail']/div[2]/div[2]/div/div[1]/a/img","Item image ");
		chkElementDisplayed("xpath","//*[@id='order_detail']/div[2]/div[2]/div/div[2]/div[1]/a/span","Item  Status ");
		chkElementDisplayed("xpath","//*[@id='order_detail']/div[2]/div[2]/div/div[2]/h5/a","Item  Name ");
		chkElementDisplayed("xpath","//*[@id='order_detail']/div[2]/div[2]/div/div[2]/div[2]","Item# Model# info ");
		chkElementDisplayed("xpath","//*[@id='order_detail']/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/span","Item Add To Mechanism ");
		chkElementDisplayed("xpath","//*[@id='order_detail']/div[2]/div[2]/div/div[3]/div[1]/div","Item Unit Price");
		chkElementDisplayed("xpath","//*[@id='order_detail']/div[2]/div[2]/div/div[3]/div[2]/div","Item  Quantity");
		chkElementDisplayed("xpath","//*[@id='order_detail']/div[2]/div[2]/div/div[3]/div[3]/div"," Item Returned Total");
		
		fc.chkText(UIMapMyLowes.lblTotalCredit, "Total Credit:");
		chkElementDisplayed("xpath",UIMapMyLowes.lblTotalCreditValue,"Total Credit: Value");
		
		ClickCustomize("linkText", "Back to Purchases");
		selenium.waitForPageToLoad("20000");
		fc.chkPagetitle("Purchases");
	}
	
	/**Checks order status in Purchase History and clicks the Order Nbr**/
	
	public void selectPurchaseAfterCheckingStatus() throws Exception
	{
		int varPgCount=Integer.valueOf(driver.findElement(By.xpath(UIMapMyLowes.lnkPurchaseTotalPage)).getText());
		int i=0;
		int varFound=0;
		for(i=1;i<=varPgCount;i++)
		{
			int varCount=fc.countWebElement(UIMapMyLowes.webElmntItemViewOrdersOnPg);
			int j;
			
			for(j=1;j<=varCount;j++)
					{
				
				
				String varOrderNbrDisp=driver.findElement(By.xpath("//*[@id='orderView']/tbody/tr["+j+"]/td[2]/a")).getText();
				
				if(varOrderNbrDisp.equals(dataTable.getData("General_Data", "OrderNbr")))
				{
					String varStatus=driver.findElement(By.xpath("//*[@id='orderView']/tbody/tr["+j+"]/td[6]")).getText();
					if(varStatus.equals(dataTable.getData("General_Data", "OrderStatus")))
						report.updateTestLog("Checking Order Status", "Order Status correctly displayed as:"+dataTable.getData("General_Data", "OrderStatus"), Status.PASS);
					else
						report.updateTestLog("Checking Order Status", "Order Status NOT displayed as:"+dataTable.getData("General_Data", "OrderStatus"), Status.FAIL);
					ClickCustomize("linkText",dataTable.getData("General_Data", "OrderNbr"));
					selenium.waitForPageToLoad("20000");
					varFound=1;
					break;
				}
				if(j==varCount)	
				{
					System.out.println("Not on Page:"+i);
					ClickCustomize("linkText", "Next");
				}
				
					}
			if(varFound==1)
				break;
			
		}
		if(i>varPgCount)
			report.updateTestLog("Finding Online Order Nbr", "Online Order not displayed in any page", Status.FAIL);
		
	}
	
	/**Checks Order Status in Purchase Details for Online Order**/
	public void chkStatusInOnlinePurchaseDetails()
	{
		String varShipping=driver.findElement(By.xpath(UIMapMyLowes.lblAddedInStoreOrderType)).getText();
		String varExpectedShipping=dataTable.getData("General_Data", "DeliveryMthd");
		if(varShipping.equals(varExpectedShipping))
			report.updateTestLog("Checking Item Shipping in Online Purchase details", "Item Shipping correctly displayed as:"+varExpectedShipping, Status.PASS);
		else
			report.updateTestLog("Checking Item Shipping in Online Purchase details", "Item Shipping NOT displayed as:"+varExpectedShipping, Status.FAIL);
		
		String varOrderStatus=driver.findElement(By.xpath(UIMapMyLowes.txtStatusInPurDetailPg)).getText();
		String varExpectedOrder=dataTable.getData("General_Data", "OrderStatusDetails");
		if(varOrderStatus.equals(varExpectedOrder))
			report.updateTestLog("Checking Order Status in Online Purchase details", "Order status correctly displayed as:"+varExpectedOrder, Status.PASS);
		else
			report.updateTestLog("Checking Order Status in Online Purchase details", "Order status NOT displayed as:"+varExpectedOrder, Status.FAIL);
		
		String varItemStatus=driver.findElement(By.xpath(UIMapMyLowes.lnkItem1StatusOlPurchaseDetails)).getText();
		if(varItemStatus.equals(varExpectedOrder))
			report.updateTestLog("Checking Item Status in Online Purchase details", "Item status correctly displayed as:"+varExpectedOrder, Status.PASS);
		else
			report.updateTestLog("Checking Item Status in Online Purchase details", "Item status NOT displayed as:"+varExpectedOrder, Status.FAIL);
	}
	
	/**Checks View Details Popup for PS Order In Online Purchase Details page**/
	public void clickViewDetailsPS() throws Exception
	{
		ClickCustomize("xpath", UIMapMyLowes.lnkViewDelDetails);
		Thread.sleep(2000);
		
		fc.chkText(UIMapMyLowes.lblShippedTo, "Ship To:");
		if(!driver.findElement(By.xpath(UIMapMyLowes.lblShippedToValue)).getText().isEmpty())
			report.updateTestLog("Cheking Ship to Value", "Ship to Value displayed", Status.PASS);
		else
			report.updateTestLog("Cheking Ship to Value", "Ship to Value NOT displayed", Status.FAIL);
		
		fc.chkText(UIMapMyLowes.lblShippedFrom, "Shipped From::");
		if(!driver.findElement(By.xpath(UIMapMyLowes.lblShippedFromValue)).getText().isEmpty())
			report.updateTestLog("Cheking Shipped From: Value", "Shipped From: Value displayed", Status.PASS);
		else
			report.updateTestLog("Cheking Shipped From: Value", "Shipped From: Value NOT displayed", Status.FAIL);
		
		fc.chkText(UIMapMyLowes.lblShippedWithin, "Ships Within:");
		if(!driver.findElement(By.xpath(UIMapMyLowes.lblShippedWithinValue)).getText().isEmpty())
			report.updateTestLog("Cheking Ships Within: Value", "Ships Within: Value displayed", Status.PASS);
		else
			report.updateTestLog("Cheking Ships Within: Value", "Ships Within: Value NOT displayed", Status.FAIL);
	}
	
	/***This function changes Billing Address stored in dataSheet ****/
	 public void changeBillingAddrssDataSheet() throws Exception
	 {
		 String varAddressNickName=dataTable.getData("General_Data", "BillAddressNickName");
		 dataTable.putData("General_Data", "BillAddressNickName", varAddressNickName+"1");
		 
	 }
	 


	 public void checkPurchaseViewOnlineDisplay() throws Exception
	{
		fc.chkText(UIMapMyLowes.lblPurchaseViewHd, "Purchases");
		
		chkElementDisplayed("xpath",UIMapMyLowes.btnAddPurchaseInStore,"Add Purchase button");
		chkElementDisplayed("xpath",UIMapMyLowes.webElmntPurchasesItemView,"Item View");
		chkElementDisplayed("xpath",UIMapMyLowes.lnkPurchaseView,"Purchase View");
		
		fc.chkText(UIMapMyLowes.lblType, "Type:");
		fc.chkText(UIMapMyLowes.lblDate, "Date:");
		//fc.chkText(UIMapMyLowes.lblMyLowesCard, "MyLowe's Card:");
		
		
		
		chkElementDisplayed("id",UIMapMyLowes.drpDownPurchaseType,"Type dropdown");
		chkElementDisplayed("id",UIMapMyLowes.drpDownPurchaseDate,"Date dropdown");
		//chkElementDisplayed("id",UIMapMyLowes.drpDownMLC,"MLC dropdown");
		
		fc.chkText(UIMapMyLowes.lblDateInTable, "Date");
		fc.chkText(UIMapMyLowes.lblOrderNbrInTable, "Order #");
		fc.chkText(UIMapMyLowes.lblTypeInTable, "Type");
		fc.chkText(UIMapMyLowes.lblItemsInTable, "# Items");
		fc.chkText(UIMapMyLowes.lblTotalInTable, "Total");
		fc.chkText(UIMapMyLowes.lblStatusInTable, "Status");
		
		fc.checkTextContains(UIMapMyLowes.lblPurchaseListFooter, "Previous", "Online Orders table Footer");
		fc.checkTextContains(UIMapMyLowes.lblPurchaseListFooter, "Next", "Online Orders table Footer");
		
		
		fc.chkText(UIMapMyLowes.txtPurchaseDisclaimer1, "Don't see a purchase? Still have your receipt? Add Purchase");
		fc.chkText(UIMapMyLowes.txtPurchaseDisclaimer2, "** Items purchased in store will appear in your purchase history within 24 hours of purchase."
				+'\n'+"** Items returned in store will remain visible in your purchase history."+'\n'+
				"** Results can't be used as receipts for returns.");
	}
	 
	 /**Checks whether Reminder welcome message is closed or displayed**/
	 public void chkReminderWelcomeMessage(String exp) throws Exception
	 {
		 if(driver.findElement(By.xpath(UIMapMyLowes.webElmntReminderWelcmMsg)).isDisplayed())
		 {
			 if(exp.equals("Yes"))
			 {
				 report.updateTestLog("Checking Reminders welcome Message", "Welcome Message displayed", Status.PASS);
			 }
			 else
				 report.updateTestLog("Checking Reminders welcome Message", "Welcome Message displayed", Status.FAIL);
		 }
		 else
		 {
			 if(exp.equals("Yes"))
			 {
				 report.updateTestLog("Checking Reminders welcome Message", "Welcome Message NOT displayed", Status.FAIL);
			 }
			 else
				 report.updateTestLog("Checking Reminders welcome Message", "Welcome Message NOT displayed", Status.PASS);
		 }
	 }
	 
	 /**checks display of reminder page**/
	 public void chkReminderPgDisplay() throws Exception
	 {
		//checking welcome message
		 chkReminderWelcomeMessage("Yes");
		 //checking all links
		 fc.chkText(UIMapMyLowes.lnkCloseWelcmMesg, "Close Welcome Message");
		 fc.chkText(UIMapMyLowes.webElmntReminderFAQPage, "FAQ page");
		 fc.chkText(UIMapMyLowes.lnkReminderFrmPurchaseHistory, "From your Lowes.com purchase history");
		 fc.chkText(UIMapMyLowes.lnkReminderFrmPrdctPg, "On a Lowes.com product page");
		 //clicking FAQ and navigating back to reminders
		 ClickCustomize("linkText", "FAQ page");
		 selenium.waitForPageToLoad("20000");
		 fc.chkText(UIMapMyLowes.lblOnlineExperience, "Online Experience");
		 driver.navigate().back();
		 selenium.waitForPageToLoad("20000");
		 fc.chkPagetitle("Reminders");
		 //clicking From your Lowes.com purchase history and navigating back to reminders
		 ClickCustomize("partialLinkText", "purchase history");
		 selenium.waitForPageToLoad("20000");
		 fc.chkPagetitle("Purchases");
		 driver.navigate().back();
		 selenium.waitForPageToLoad("20000");
		 fc.chkPagetitle("Reminders");
		//clicking On a Lowes.com product page and navigating back to reminders
		 ClickCustomize("partialLinkText", "product page");
		 selenium.waitForPageToLoad("20000");
		 fc.chkPagetitle("Lowe's Home Improvement: Appliances, Tools, Hardware, Paint, Flooring");
		 driver.navigate().back();
		 selenium.waitForPageToLoad("20000");
		 fc.chkPagetitle("Reminders");
		 //closing welcome Message
		 ClickCustomize("linkText", "Close Welcome Message");
		 Thread.sleep(2000);
		 chkReminderWelcomeMessage("No");
		 fc.chkText(UIMapMyLowes.lnkShowWelcmMesg, "Show Welcome Screen");
		//clicking Show Welcome Screen
		 ClickCustomize("linkText", "Show Welcome Screen");
		 Thread.sleep(2000);
		 chkReminderWelcomeMessage("Yes");
		 
	 }
	 
	//Ankita 03/26
		/***
		 * checks List Page Layout
		 */
		public void chkListLayout() throws Exception
		{
			chkElementDisplayed("xpath", UIMapMyLowes.txtNewList, "List Name");
			chkElementDisplayed("xpath", UIMapMyLowes.webElmntListHeader, "List Header");
			fc.checkTextContains(UIMapMyLowes.webElmntListHeader, "Rename", "List Header");
			fc.checkTextContains(UIMapMyLowes.webElmntListHeader, "Add a Note", "List Header");
			chkElementDisplayed("xpath", UIMapMyLowes.webElmntListOverView, "List OverView Container");
			chkElementDisplayed("xpath", UIMapMyLowes.webElmntListHeader2, "List OverView Header");
			chkElementDisplayed("xpath", UIMapMyLowes.webElmntListOverViewFilter, "List OverView Filter");
			
			
		}
		
		/**Checks HP layout**/
		public void chkHPElements() throws Exception
		{
			chkElementDisplayed("xpath", UIMapMyLowes.webElmntHPNotes, "Home Profile Notes");
			 fc.chkText(UIMapMyLowes.btnDeleteHP, "Delete Home Profile");
			 fc.chkText(UIMapMyLowes.lblNotes, "Notes:");
		}
		
		/**Adds item id in delivery method specific list**/
		public void storeItemIdForADelMthd() throws Exception
		{
			String varDeliveryOption = dataTable.getData("General_Data", "DeliveryMthd");
			String varItemId=dataTable.getData("General_Data", "ItemId");
			if(varDeliveryOption.equals("PL"))
			{
				listPLItems.add(varItemId);
			}
			else if(varDeliveryOption.equals("UPS"))
			{					
				listUPSItems.add(varItemId);
			}
			else if(varDeliveryOption.equals("LD"))
			{					
				listLDItems.add(varItemId);
			}
			System.out.println("PL Items:"+listPLItems);
			System.out.println("UPS Items:"+listUPSItems);
			System.out.println("LD Items:"+listLDItems);
		}
		
		/**Checks grouping in Order Confirmation page**/
		public void chkItemGroupingInOC() throws Exception
		{
			int i=0;
			ArrayList<String> listPLItems2=new ArrayList<String>();
			ArrayList<String> listLDItems2=new ArrayList<String>();
			ArrayList<String> listUPSItems2=new ArrayList<String>();
			int delMthdCount=Integer.valueOf(dataTable.getData("General_Data", "DelMthdCount"));
			
			for(i=3;i<=(delMthdCount+2);i++)
			{
				try{String varClass=driver.findElement(By.xpath("//*[@id='conf-main']/div["+i+"]")).getAttribute("class");
				
				if(varClass.equals("l-module l-module-tertiary"))	
				{
					String varDelMthd=driver.findElement(By.xpath("//*[@id='conf-main']/div["+i+"]/div[1]/h5/span[2]")).getText();
					System.out.println(varDelMthd);
					int count=fc.countWebElement("//*[@id='conf-main']/div["+i+"]/div[2]/div[2]/div[2]/div");
					int j=0;
					for(j=1;j<=count;j++)
					{
						String varId=driver.findElement(By.xpath("//*[@id='conf-main']/div["+i+"]/div[2]/div[2]/div[2]/div["+j+"]")).getAttribute("id");
						System.out.println(varId);
						String[] s=varId.split("_");
						System.out.println(s[1]);
						if(varDelMthd.equals("Parcel Shipping"))
						{
							listUPSItems2.add(s[1]);
						}
						else if(varDelMthd.equals("Lowe's Truck Delivery"))
						{
							listLDItems2.add(s[1]);
						}
						else if(varDelMthd.equals("Store Pickup"))
						{
							listPLItems2.add(s[1]);
						}
					}
					
				}
				else
				{
					report.updateTestLog("Checking Items on Order Confirmation page", "Order not successfully placed for all items", Status.FAIL);
					break;
				}
				
				if(i==(delMthdCount+2))
				{
					System.out.println(listPLItems2);
					System.out.println(listLDItems2);
					System.out.println(listUPSItems2);
					if(chkListsEqual(listPLItems, listPLItems2))
						report.updateTestLog("Checking if PL Items are grouped on Order Confirmation page", "PL Items Grouped", Status.PASS);
					else
						report.updateTestLog("Checking if PL Items are grouped on Order Confirmation page", "PL Items NOT Grouped", Status.FAIL);
					if(chkListsEqual(listLDItems, listLDItems2))
						report.updateTestLog("Checking if LD Items are grouped on Order Confirmation page", "LD Items Grouped", Status.PASS);
					else
						report.updateTestLog("Checking if LD Items are grouped on Order Confirmation page", "LD Items NOT Grouped", Status.FAIL);
					if(chkListsEqual(listUPSItems, listUPSItems2))
						report.updateTestLog("Checking if UPS Items are grouped on Order Confirmation page", "UPS Items Grouped", Status.PASS);
					else
						report.updateTestLog("Checking if UPS Items are grouped on Order Confirmation page", "UPS Items NOT Grouped", Status.FAIL);
				}
				}
				catch(Exception e)
				{
					report.updateTestLog("Checking Items on Order Confirmation page", "Order not successfully placed for all items", Status.FAIL);
					break;
				}
				
			}
		}
		
		/**Takes two lists and returns true if both are equal**/
		public boolean chkListsEqual(ArrayList<String> list1, ArrayList<String> list2) throws Exception
		{
			System.out.println("Comparing if lists equal");
			Collections.sort(list1);
			Collections.sort(list2);
			System.out.println(list1);
			System.out.println(list2);
			if(list1.equals(list2))
				return true;
			else
				return false;
		}
		
		/**For AZ User navigates to Account-Purchases and validates if Find Purchase is displayed**/
		public void navigatePurchasesAZ() throws Exception
		{
			navigatePurchases2();
			fc.chkPagetitle("Find Purchase");
		}
		
		/**SEarches , adds delivery method, continue shopping**/
		public void addItemsToCart2() throws Exception
		{
			fc.searchItem();
			ch.selectDlvryMthd();
			ch.clickCheckOutFromDetails();
			storeItemIdForADelMthd();
		}
		
		public void chKCancelOrderButtonForDOMEligibleAZ()
		{
			
			if (driver.findElement(By.xpath("//*[@id='order_detail']/div[1]/div[2]/table/tbody/tr[2]/td[2]")).getText().equals("In Process"))
			{
			report.updateTestLog("Verifying order status", "Status is InProcess.Hence eligible for Cancelling", Status.PASS);	
		
			     if (driver.findElement(By.xpath("//*[@id='order_detail']/h3/a")).getText().equals("Cancel Order"))
			    {
				   report.updateTestLog("Verifying Cancel Order Button existence", "Cancel Order Button is displayed", Status.FAIL);
			    }
			     else
			     {
			    	 report.updateTestLog("Verifying Cancel Order Button existence", "Cancel Order Button is NOT displayed", Status.PASS); 
			     }
			}
			else
			{
				report.updateTestLog("Verifying order status", "Status is NOT InProcess.Hence NOT eligible for Cancelling", Status.FAIL);
			}
		}
		
		public void chKCancelOrderButtonForDOMNonEligibleAZ()
		{
			if (driver.findElement(By.xpath("//*[@id='order_detail']/h3/a")).getText().equals("Cancel Order"))
			    {
				   report.updateTestLog("Verifying Cancel Order Button existence", "Cancel Order Button is displayed", Status.FAIL);
			    }
			     else
			     {
			    	 report.updateTestLog("Verifying Cancel Order Button existence", "Cancel Order Button is NOT displayed", Status.PASS); 
			     }
			
		}
		
		public void cancelInProcessDomOrder() throws Exception
		{
			ClickCustomize("linkText", "Cancel Order");
			Thread.sleep(2000);
			ClickCustomize("xpath", "btnCancelOrderConfirm");
			selenium.waitForPageToLoad("20000");
			
		}
		
		/** Validates InStore Purchase Detail page for the Returned Items**/
		public void  checkReturnedItemInStorePurchsDetails() throws Exception
		{
			fc.chkText(UIMapMyLowes.txtPurchaseInfoType, "Return Location:");
			chkElementDisplayed("xpath",UIMapMyLowes.lblAddedInStorePurchaseAt,"Returned Location Value");
			fc.chkText(UIMapMyLowes.lblMLCardNbr, "MyLowe's Card #:");
			chkElementDisplayed("xpath",UIMapMyLowes.lblMLCardNbrValue,"MyLowe's Card #: Value");
			fc.chkText(UIMapMyLowes.txtPurchaseInfoOrder, "Order #");
			chkElementDisplayed("xpath",UIMapMyLowes.lblAddedInStoreInvoiceNbr,"Invloice nbr Value");
			
			
			String varTxt=driver.findElement(By.xpath(UIMapMyLowes.webElmntInStoreReturnedItem1)).getText();
			if(varTxt.contains("RETURNED"))
				report.updateTestLog("Checking Returned Item", "Returned displayed", Status.PASS);
			else
				report.updateTestLog("Checking Returned Item", "Returned NOT displayed", Status.FAIL);
			chkElementDisplayed("xpath","//*[@id='order_detail']/div[2]/h3"," Fulfillment method ");
			chkElementDisplayed("xpath","//*[@id='order_detail']/div[2]/div[1]/div/div[1]/a/img","Item image ");
			fc.chkText("//*[@id='order_detail']/div[2]/div[1]/div/div[2]/div[1]", "RETURNED");
			chkElementDisplayed("xpath","//*[@id='order_detail']/div[2]/div[1]/div/div[2]/h5/a","Item  Name ");
			dataTable.putData("General_Data", "ItemName", driver.findElement(By.xpath("//*[@id='order_detail']/div[2]/div[1]/div/div[2]/h5/a")).getText());
			chkElementDisplayed("xpath","//*[@id='order_detail']/div[2]/div[1]/div/div[2]/div[2]","Item# Model# info ");
			chkElementDisplayed("xpath","//*[@id='order_detail']/div[2]/div[1]/div/div[2]/div[3]/div[1]/span","Item Add To Mechanism ");
			chkElementDisplayed("xpath","//*[@id='order_detail']/div[2]/div[1]/div/div[3]/div[1]/div","Item Unit Price");
			chkElementDisplayed("xpath","//*[@id='order_detail']/div[2]/div[1]/div/div[3]/div[2]/div","Item  Quantity");
			chkElementDisplayed("xpath","//*[@id='order_detail']/div[2]/div[1]/div/div[3]/div[3]/div"," Item Returned Total");
			
			fc.chkText(UIMapMyLowes.lblTotalCredit, "Total Credit:");
			chkElementDisplayed("xpath",UIMapMyLowes.lblTotalCreditValue,"Total Credit: Value");
			
			ClickCustomize("linkText", "Back to Purchases");
			selenium.waitForPageToLoad("20000");
			fc.chkPagetitle("Purchases");
		}
		
		/**Check Returned Item in Item View**/
		public void chkReturnedItemInItemView() throws Exception
		{
			String varOrderNbrOnOPg=dataTable.getData("General_Data", "OrderNbrOnPg");
			System.out.println(varOrderNbrOnOPg);
			fc.chkText("//*[@id='itemView']/div["+varOrderNbrOnOPg+"]/a", "Purchase Details");	
			int varCount=fc.countWebElement(UIMapMyLowes.webElmntItemViewItemsAll);
				
				int j;
				for(j=1;j<=varCount;j++)
				{
					String varItemName=driver.findElement(By.xpath("//*[@id='itemView']/ul["+j+"]/li/div[2]/h3")).getText();
					System.out.println(varItemName);
					if(varItemName.equals(dataTable.getData("General_Data", "ItemName")))
					{
						fc.chkText("//*[@id='itemView']/ul["+j+"]/li/div[2]/div", "RETURNED");	
						chkElementDisplayed("xpath","//*[@id='itemView']/ul["+j+"]/li/div[1]/a/img","Item image ");
						chkElementDisplayed("xpath","//*[@id='itemView']/ul["+j+"]/li/div[2]/b/p","Item Price ");
						chkElementDisplayed("xpath","//*[@id='itemView']/ul["+j+"]/li/div[3]/div[1]/span","Add To Mechanism");
						break;
					}
				}
				fc.chkText(UIMapMyLowes.txtPurchaseDisclaimer1, "Don't see a purchase? Still have your receipt? Add Purchase");
				fc.chkText(UIMapMyLowes.txtPurchaseDisclaimer2, "** Items purchased in store will appear in your purchase history within 24 hours of purchase."
						+'\n'+"** Items returned in store will remain visible in your purchase history."+'\n'+
						"** Results can't be used as receipts for returns.");	
		}
}