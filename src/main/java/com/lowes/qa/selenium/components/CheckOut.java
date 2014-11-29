package com.lowes.qa.selenium.components;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
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
import com.lowes.qa.selenium.uimap.UIMapMyLowes;
import com.lowes.qa.selenium.uimap.UIMapProductSearch;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class CheckOut extends ReusableLibrary {

	//protected TestParameters testParameters = new TestParameters();
	String baseurl = dataTable.getData("General_Data", "URL");
	Selenium selenium = new WebDriverBackedSelenium(driver, baseurl);
	FunctionalComponents fc = new FunctionalComponents(scriptHelper);
	//MyLowes mylowes = new MyLowes(scriptHelper);
	//MyLowes_ID mylowesid = new MyLowes_ID(scriptHelper);

	public CheckOut(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}

	public void addItemToCartWithDlvryMthd() throws Exception {
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data", "ItemNbr"));
		try {
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		} catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handeled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		}
		report.updateTestLog("Searching For an Item","Searching Item Number - "	+ dataTable.getData("General_Data", "ItemNbr") + "",Status.DONE);
		
		selenium.waitForPageToLoad("120000");
		boolean verItemPresent = selenium.isTextPresent("Item #: "+ dataTable.getData("General_Data", "ItemNbr"));
//		if (verItemPresent) {
//			report.updateTestLog("Veriyfing Navigating to Item's PDP Page",	"Item - " + dataTable.getData("General_Data", "ItemNbr")+ " is Present", Status.PASS);
//		} else {
//			report.updateTestLog("Veriyfing Navigating to Item's PDP Page","Item is NOT Present", Status.FAIL);
//		}
		selectDlvryMthd();
		driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	}
	
	public void emptyTheCart() throws Exception{

		int sz = driver.findElements(By.linkText("Remove")).size();
		for (int i = 0; i < sz; i++) {
			driver.findElement(By.linkText("Remove")).click();
			Thread.sleep(1000);
			selenium.waitForPageToLoad("20000");
			
		}
		if ((driver.findElement(By.xpath(UIMapCheckOut.txtCartEmpty)).getText()
				.contains("Your Shopping Cart Is Empty")) && 
				(driver.findElement(By.xpath(UIMapCheckOut.lblEmptyCartEstTotalValue)).getText().equals("$0.00")))
		{
			report.updateTestLog("Veriyfing the empty cart,Cart is empty",
					"Verification is successful", Status.PASS);
		} 
		else 
		{
			report.updateTestLog("Veriyfing the empty cart,Cart is not empty",
					"Verification is not successful", Status.FAIL);
		}

	}

	public void selectDlvryMthd() throws Exception {

		// dlvryMthd is configured in UI MAP
		// DeliveryMthd should be configured in General Data
		
		try{
			
		ClickCustomize("id",dataTable.getData("General_Data", "DeliveryMthd"));
			//driver.findElement(By.id(dataTable.getData("General_Data", "DeliveryMthd"))).click();
		Thread.sleep(2000);
		report.updateTestLog("Selecting delivery Method", "Delivery Method: "+dataTable.getData("General_Data", "DeliveryMthd")+" selected for Item: "+dataTable.getData("General_Data", "ItemNbr"), Status.PASS);
			
		}
		catch(Exception NoSuchElementException)
		{
			report.updateTestLog("Selecting delivery Method", "Delivery Method: "+dataTable.getData("General_Data", "DeliveryMthd")+" NOT AVAILABLE for Item: "+dataTable.getData("General_Data", "ItemNbr"), Status.FAIL);
		}

		
	}	
	
	public void searchAndAddItemsToCart() throws Exception {
		
		String s = dataTable.getData("General_Data", "ItemNbrs");
		        
    	String[] str = s.split(","); 
    	String item1 = str[0]; 
    	
    	String item2 = str[1]; 
    	String item3 = str[2]; 
    	String item4 = str[3]; 
                
        ArrayList<Integer> aList = new ArrayList<Integer>();
        
        aList.add(Integer.parseInt(item1));
        aList.add(Integer.parseInt(item2));
        aList.add(Integer.parseInt(item3));
        aList.add(Integer.parseInt(item4));
    	        
                
        for(int i=0;i<aList.size();i++){
        	
        	driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(String.valueOf(aList.get(i)));
    		try {
    			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
    		} catch (Exception WebDriverException) {
    			driver.findElement(By.linkText("No, thanks")).click();
    			report.updateTestLog("Survey Popup", "Handled", Status.DONE);
    			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
    	}       	     
     
		try {
		driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
		}
		catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
		}
		Thread.sleep(5000);
		 driver.findElement(By.xpath(UIMapMyLowes.btnbutton3)).click();
		Thread.sleep(7000);	
        }
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void clickIWantFreeLowesAcc() throws Exception {
		// *[@id='reg-messaging-expand']
		driver.findElement(By.id("reg-messaging-expand")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("password1")).clear();
		driver.findElement(By.id("password1")).sendKeys(
				dataTable.getData("General_Data", "password"));
		driver.findElement(By.id("password2")).clear();
		driver.findElement(By.id("password2")).sendKeys(
				dataTable.getData("General_Data", "confpassword"));
	}
	
	
	/**
	 * 
	 * @throws Exception
	 */
	public void checkOutOrderAsNewUser()throws Exception{
		selenium.waitForPageToLoad("30000");
		boolean verItemPresent = driver.findElement(
				By.name("listpage_productname")).isDisplayed();
		if (verItemPresent) {
			report.updateTestLog("Veriyfing Navigating to Item's PDP Page",
					"Name - " + dataTable.getData("General_Data", "searchName")
							+ " is Present", Status.PASS);
		} else {
			report.updateTestLog("Veriyfing Navigating to Item's PDP Page",
					"Model name is NOT Present", Status.FAIL);
		}

		selenium.waitForPageToLoad("30000");
		boolean selectElement = driver.findElement(By.xpath(UIMapMyLowes.txtElementDisplayed))
				.isDisplayed();
		if (selectElement) {
			driver.findElement(By.xpath(UIMapMyLowes.txtElementDisplayed)).click();
		} else {
			report.updateTestLog("Select of first element is failed",
					"Element NOT Present", Status.FAIL);
		}
		//add to cart
		selectDlvryMthd();
		//driver.findElement(By.id("LD")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
	    selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//providecheckOutOrderAsNewUserDetails
		//providecheckOutOrderAsNewUserDetails();
	}

		
	/**
	 * 
	 * @throws Exception
	 */
	public void providecheckOutOrderAsNewUserDetails()throws Exception{
		  
	     driver.findElement(By.xpath(UIMapMyLowes.btnShopCart)).click();
	     Thread.sleep(2000);
	  if(selenium.isTextPresent("No Thanks"))
	   driver.findElement(By.linkText("No Thanks")).click();
	     selenium.waitForPageToLoad("20000");
	  Thread.sleep(6000);
	  //for guest User
	  
	  /*** GUEST USER****/
	  try{boolean guestUser=  selenium.isTextPresent("I Don't Have a Lowes.com Account");
	  if (guestUser) {
	   driver.findElement(By.xpath(UIMapMyLowes.btnGuestUserCheckOut)).click();
	   selenium.waitForPageToLoad("20000");
	   Thread.sleep(6000);
	  }
	  }
	  catch(Exception NoSuchElementException)
	  {
	   System.out.println("Sign In Page Not Displayed");
	  }
	  
	 }

	
	/**
	 * 
	 * @throws Exception
	 */
	public void checkOutOrderWithSignInDetails()throws Exception{
		
	    driver.findElement(By.xpath(UIMapMyLowes.btnShopCart)).click();
	    selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//for guest User
		
		/*** Check In As Existing User****/
		boolean existingUser=  selenium.isTextPresent("I Have a Lowes.com Account");
		if (existingUser) {
			driver.findElement(By.id(UIMapFunctionalComponents.txtUserName))
					.sendKeys(dataTable.getData("General_Data", "email"));
			driver.findElement(By.id(UIMapFunctionalComponents.txtPassword))
					.sendKeys(dataTable.getData("General_Data", "password"));
			driver.findElement(By.id(UIMapFunctionalComponents.txtPassword))
					.sendKeys(Keys.ENTER);
			// driver.findElement(By.id("GoYourAccount")).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		}
		
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void checkOutGiftCard() throws Exception {
		driver.findElement(By.id(UIMapMyLowes.txtGCNbr)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtGCNbr)).sendKeys(
				dataTable.getData("General_Data", "GCNbr"));

		driver.findElement(By.id(UIMapMyLowes.txtGCPin)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtGCPin)).sendKeys(
				dataTable.getData("General_Data", "GCPin"));
		driver.findElement(By.xpath(UIMapCheckOut.btnApplyGC)).click();
		Thread.sleep(6000);
		selenium.waitForPageToLoad("20000");
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void removeGiftCard()throws Exception{
		driver.findElement(By.xpath(UIMapCheckOut.removeGiftCard)).click();
	}

	
	/*Enters gift Card details on Review & Pay Page and clicks on Apply button*/
	public void enterGiftCardDetails()throws Exception {
		driver.findElement(By.id(UIMapMyLowes.txtGCNbr)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtGCNbr)).sendKeys(dataTable.getData("General_Data", "GCNbr"));
		
		driver.findElement(By.id(UIMapMyLowes.txtGCPin)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtGCPin)).sendKeys(dataTable.getData("General_Data", "GCPin"));
	    driver.findElement(By.xpath(UIMapCheckOut.btnApplyGC)).click();
	    Thread.sleep(6000);
	    selenium.waitForPageToLoad("20000");
	   
	    
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void providePromotionCode()throws Exception{
		driver.findElement(By.id(UIMapMyLowes.txtBillEmailAdd)).clear();
		driver.findElement(By.id("promoCode1")).sendKeys(dataTable.getData("General_Data", "promoCode"));
	}
	
	
	/**
	 * SHIPPING INFORMATION
	 * @throws Exception
	 */
	public void provideNewUserShippingInformation() throws Exception {
		
		// checkout before USPS
		driver.findElement(By.xpath(UIMapMyLowes.btnSecureCheckOut)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// confirm USPS first
		boolean uspsContinue = selenium.isTextPresent("Confirm");
		if (uspsContinue) {
			driver.findElement(By.id(UIMapCheckOut.rdoBtnUSPSEnteredAddress)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(UIMapMyLowes.btnCfrmUSPSAddress))
					.click();
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// checkout aftr USPS
		
		driver.findElement(By.xpath(UIMapMyLowes.btnSecureCheckOut)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		report.updateTestLog("Navigating to Shipping Options Page", "Navigated to Shipping Options Page", Status.DONE);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void provideNewUserProdDestination()throws Exception{
		// checkout before USPS
		driver.findElement(By.xpath(UIMapMyLowes.btnSecureCheckOut)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		report.updateTestLog("Navigating to Shipping Options", "Navigated to Shipping Options", Status.DONE);
	}
	
	/**
	 * SHIPPING INFORMATION
	 * @throws Exception
	 */
	public void provideNewUserShippingInfoWidAddressChk() throws Exception {
		
		// checkout before USPS
		driver.findElement(By.xpath(UIMapMyLowes.btnSecureCheckOut)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// confirm USPS first
		boolean uspsContinue = selenium.isTextPresent("Confirm");
		if (uspsContinue) {
			driver.findElement(By.id(UIMapCheckOut.rdoBtnUSPSEnteredAddress)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(UIMapMyLowes.btnCfrmUSPSAddress))
					.click();
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// checkout aftr USPS
		validateProductDestinationAddressNewUser();
		driver.findElement(By.xpath(UIMapMyLowes.btnSecureCheckOut)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		report.updateTestLog("Navigating to Shipping Options Page", "Navigated to Shipping Options Page", Status.DONE);
	}
	
	
		
	/**
	 * 
	 * @throws Exception
	 */
	public void provideNewUserShippingOptions() throws Exception {
		driver.findElement(By.xpath(UIMapMyLowes.btnSecureCheckOut)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		report.updateTestLog("Navigating to Review & Pay Page", "Navigated to Review & Pay Page", Status.DONE);
	}
	
	/**
	 * REVIEW PAGE
	 * @throws Exception
	 */
	public void provideNewUserRevPageCCDetails()throws Exception{	
	    driver.findElement(By.id("ccAddTab")).click();
	    //add primary credit card details 
	    selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		report.updateTestLog("Selecting Add Credit Card", "Add Credit Card Selected", Status.DONE);
	}
	
	public void provideNewUserRevPageBADetails()throws Exception{
		//click create new address tab from billing info 
	    driver.findElement(By.linkText("Create New Address")).click();
	    selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	    //add billing info new credit card
	    checkOutBillingInfoAddNewAddress();
	    selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		
	}
	
	
	/***********This function stores Order Total displayed on Review & Pay Page for later validation**********/
	public void storeOrderTotal() throws Exception
	{
		//store Order Total
				String varOrderTotal=driver.findElement(By.xpath(UIMapCheckOut.lblOrderTotal)).getText();
				System.out.println(varOrderTotal);
				dataTable.putData("General_Data", "OrderTotal", varOrderTotal);
	}
	/**
	 * 
	 * @throws Exception
	 */
	public void clickCheckOutInReviewPageDetail()throws Exception{
		
		//click checkout button
	    driver.findElement(By.xpath(UIMapMyLowes.btnSecureCheckOut)).click();
	    selenium.waitForPageToLoad("120000");
		Thread.sleep(4000);
		//USPS Confirmation for final check out
		try{
		driver.findElement(By.xpath(UIMapCheckOut.rdoBtnUSPSEnteredAddress)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UIMapMyLowes.btnCfrmUSPSAddress)).click();
		selenium.waitForPageToLoad("120000");
		Thread.sleep(4000);
		
		}
		catch(Exception NoSuchElementException)
		{
			System.out.println("No USPS displayed");
			 
		}
		
	}


	/**
	 * 
	 * @throws Exception
	 */
	public void checkOutShippingInfoAddress() throws Exception {
		driver.findElement(By.id(UIMapMyLowes.txtAddressName)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtAddressName)).sendKeys(dataTable.getData("General_Data", "AddressNickName"));
		driver.findElement(By.id(UIMapMyLowes.txtFName)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtFName)).sendKeys(dataTable.getData("General_Data", "Firstname"));
		driver.findElement(By.id(UIMapMyLowes.txtLName)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtLName)).sendKeys(dataTable.getData("General_Data", "Lastname"));
		driver.findElement(By.id(UIMapMyLowes.txtAdd1)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtAdd1)).sendKeys(dataTable.getData("General_Data", "Address1"));
		/*driver.findElement(By.id(UIMapMyLowes.txtAdd2)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtAdd2)).sendKeys(dataTable.getData("General_Data", "Address2"));*/
		driver.findElement(By.id(UIMapMyLowes.txtCity)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtCity)).sendKeys(dataTable.getData("General_Data", "City"));
		new Select(driver.findElement(By.id(UIMapMyLowes.txtState))).selectByVisibleText(dataTable.getData("General_Data", "State"));
		driver.findElement(By.id(UIMapMyLowes.txtZpCd)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtZpCd)).sendKeys(dataTable.getData("General_Data", "zipcode"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		report.updateTestLog("Entering Shipping Address", "Shipping Address Added", Status.DONE);
		//String varPrimaryAddress=
		String varPrimaryAddress=dataTable.getData("General_Data", "AddressNickName")+" - "+dataTable.getData("General_Data", "Address1")+","+dataTable.getData("General_Data", "City")+
				" "+dataTable.getData("General_Data", "StateShortForm")+" "+dataTable.getData("General_Data", "zipcode");
		System.out.println(varPrimaryAddress);
		dataTable.putData("General_Data", "Primary Address", varPrimaryAddress);
		
	}


	/**
	 * 
	 * @throws Exception
	 */
	public void checkOutUsingMasterCreditCard() throws Exception {
		try{driver.findElement(By.name(UIMapMyLowes.txtCardNickName)).clear();
		driver.findElement(By.name(UIMapMyLowes.txtCardNickName)).sendKeys(dataTable.getData("General_Data", "nickName"));
		}
		catch(Exception e){
			System.out.println("Card NickName Not Displayed");
		}
		new Select(driver.findElement(By.id(UIMapMyLowes.drpDownChkOutType))).selectByVisibleText(dataTable.getData("General_Data","cardType"));
		driver.findElement(By.name(UIMapMyLowes.txtCheckOutCreditCardNo)).clear();
		driver.findElement(By.name(UIMapMyLowes.txtCheckOutCreditCardNo)).sendKeys(dataTable.getData("General_Data", "crditCardNo"));
		driver.findElement(By.id(UIMapMyLowes.txtSCode)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtSCode)).sendKeys(dataTable.getData("General_Data", "security code"));
		new Select(driver.findElement(By.id(UIMapMyLowes.txtExpMon))).selectByVisibleText(dataTable.getData("General_Data", "month"));
		new Select(driver.findElement(By.id(UIMapMyLowes.txtExpYear))).selectByVisibleText(dataTable.getData("General_Data", "year"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void checkOutUsingLCCCardWithPercentage() throws Exception {

		try{driver.findElement(By.name(UIMapMyLowes.txtCardNickName)).clear();

		driver.findElement(By.name(UIMapMyLowes.txtCardNickName)).sendKeys(dataTable.getData("General_Data", "nickName"));

		}

		catch(Exception e){

		System.out.println("Card NickName Not Displayed");

		}

		new Select(driver.findElement(By.id(UIMapMyLowes.drpDownChkOutType))).selectByVisibleText(dataTable.getData("General_Data","cardType"));

		driver.findElement(By.name(UIMapMyLowes.txtCheckOutCreditCardNo)).clear();

		driver.findElement(By.name(UIMapMyLowes.txtCheckOutCreditCardNo)).sendKeys(dataTable.getData("General_Data", "crditCardNo"));

		driver.findElement(By.id(UIMapMyLowes.txtSCode)).clear();

		driver.findElement(By.id(UIMapMyLowes.txtSCode)).sendKeys(dataTable.getData("General_Data", "security code"));

		report.updateTestLog("Addind Credit Card Details", "Credit Card Details entered", Status.DONE);

		//select percentage

		try{

		driver.findElement(By.xpath("//*[@id='percent-off']")).click();

		selenium.waitForPageToLoad("20000");

		Thread.sleep(6000);

		}

		catch(Exception NoSuchElementException)

		{

		System.out.println("percent-off Not Displayed for LCC");

		}

		}


	/**
	 * 
	 * @throws Exception
	 */
	public void checkOutBillingInfoAddNewAddress() throws Exception {
		try{
		driver.findElement(By.id(UIMapMyLowes.txtAddNickName)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtAddNickName)).sendKeys(dataTable.getData("General_Data", "BillAddressNickName"));
		}
		catch(Exception e)
		{
			System.out.println("Bill Nick Name field not present");
		}
		driver.findElement(By.id(UIMapMyLowes.txtBillFName)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtBillFName)).sendKeys(dataTable.getData("General_Data", "BillFirstname"));
		driver.findElement(By.id(UIMapMyLowes.txtBillLName)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtBillLName)).sendKeys(dataTable.getData("General_Data", "BillLastname"));
		driver.findElement(By.id(UIMapMyLowes.txtBillAdd1)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtBillAdd1)).sendKeys(dataTable.getData("General_Data", "BillAddress1"));
		//driver.findElement(By.id(UIMapMyLowes.txtBillAdd2)).clear();
		//driver.findElement(By.id(UIMapMyLowes.txtBillAdd2)).sendKeys(dataTable.getData("General_Data", "BillAddress2"));
		driver.findElement(By.id(UIMapMyLowes.txtBillCity)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtBillCity)).sendKeys(dataTable.getData("General_Data", "BillCity"));
		new Select(driver.findElement(By.id(UIMapMyLowes.txtBillState))).selectByVisibleText(dataTable.getData("General_Data", "BillState"));
		driver.findElement(By.id(UIMapMyLowes.txtBillZip)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtBillZip)).sendKeys(dataTable.getData("General_Data", "Billzipcode"));
		driver.findElement(By.id(UIMapMyLowes.txtBillPh1)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtBillPh1)).sendKeys(dataTable.getData("General_Data", "BillPhone1"));
		driver.findElement(By.id(UIMapMyLowes.txtBillPh2)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtBillPh2)).sendKeys(dataTable.getData("General_Data", "BillPhone2"));
		driver.findElement(By.name(UIMapMyLowes.txtBillPh3)).clear();
		driver.findElement(By.name(UIMapMyLowes.txtBillPh3)).sendKeys(dataTable.getData("General_Data", "BillPhone3"));
		driver.findElement(By.id(UIMapMyLowes.txtBillEmailAdd)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtBillEmailAdd)).sendKeys(dataTable.getData("General_Data", "confirmemail"));
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void clickUseMyShippingAddress()throws Exception{
		
		driver.findElement(By.id(UIMapMyLowes.txtBillFName)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtBillFName)).sendKeys(dataTable.getData("General_Data", "BillFirstname"));
		driver.findElement(By.id(UIMapMyLowes.txtBillLName)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtBillLName)).sendKeys(dataTable.getData("General_Data", "BillLastname"));
		driver.findElement(By.id(UIMapMyLowes.txtBillPh1)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtBillPh1)).sendKeys(dataTable.getData("General_Data", "BillPhone1"));
		driver.findElement(By.id(UIMapMyLowes.txtBillPh2)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtBillPh2)).sendKeys(dataTable.getData("General_Data", "BillPhone2"));
		driver.findElement(By.name(UIMapMyLowes.txtBillPh3)).clear();
		driver.findElement(By.name(UIMapMyLowes.txtBillPh3)).sendKeys(dataTable.getData("General_Data", "BillPhone3"));
		driver.findElement(By.id("useShippingAddress")).click();
		//selenium.waitForPageToLoad("20000");
		Thread.sleep(9000);
		driver.findElement(By.id(UIMapMyLowes.txtBillEmailAdd)).clear();
		//driver.findElement(By.id(UIMapMyLowes.txtBillEmailAdd)).sendKeys(dataTable.getData("General_Data", "confirmemail"));
		/*Code for unique email ID starts*/
		 java.util.Date date= new java.util.Date();
		 Timestamp t = new Timestamp(date.getTime());
		 String varTimeStamp = String.format("%1$TD %1$TT", t);
		 System.out.println(varTimeStamp);
		 String[] varDate = varTimeStamp.split(" ");
		 String[] varDatMon = varDate[0].split("/");
		 String[] varHrMinSec = varDate[1].split(":");
		 String varUniq = "test";
		 varUniq = varUniq.concat(varDatMon[0]+varDatMon[1]+varHrMinSec[0]+varHrMinSec[1]+varHrMinSec[2]);
		 /*Code for unique email ID ends*/
		 
		driver.findElement(By.id(UIMapMyLowes.txtBillEmailAdd)).sendKeys(varUniq+"@bh.exacttarget.com");
		dataTable.putData("General_Data", "confirmemail", varUniq+"@bh.exacttarget.com");
		
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void completeOrderByPrimaryAddress() throws Exception {
		new Select(driver.findElement(By.name("stored-billing-address-id")))
				.selectByVisibleText(dataTable.getData("General_Data",
						"Primary Address"));
		Thread.sleep(2000);
		driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim1)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim1)).sendKeys(
				dataTable.getData("General_Data", "BillPhone1"));
		driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim2)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim2)).sendKeys(
				dataTable.getData("General_Data", "BillPhone2"));
		driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim3)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim3)).sendKeys(
				dataTable.getData("General_Data", "BillPhone3"));
		driver.findElement(By.id(UIMapMyLowes.txtBillEmailAddPrim)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtBillEmailAddPrim)).sendKeys(
				dataTable.getData("General_Data", "confirmemail"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}
	/**
	 * 
	 * @throws Exception
	 */
	public void clickAddNewAddressOnProdDestPageLD() throws Exception {
		driver.findElement(By.linkText("Add New Address")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// entering address
		driver.findElement(By.id(UIMapCheckOut.txtAddressName)).clear();
		driver.findElement(By.id(UIMapCheckOut.txtAddressName)).sendKeys(
				dataTable.getData("General_Data", "AddressNickName"));
		driver.findElement(By.id(UIMapCheckOut.txtFName)).clear();
		driver.findElement(By.id(UIMapCheckOut.txtFName)).sendKeys(
				dataTable.getData("General_Data", "Firstname"));
		driver.findElement(By.id(UIMapCheckOut.txtLName)).clear();
		driver.findElement(By.id(UIMapCheckOut.txtLName)).sendKeys(
				dataTable.getData("General_Data", "Lastname"));
		driver.findElement(By.id(UIMapCheckOut.txtAdd1)).clear();
		driver.findElement(By.id(UIMapCheckOut.txtAdd1)).sendKeys(
				dataTable.getData("General_Data", "Address1"));
		driver.findElement(By.id(UIMapCheckOut.txtCity)).clear();
		driver.findElement(By.id(UIMapCheckOut.txtCity)).sendKeys(
				dataTable.getData("General_Data", "City"));
		new Select(driver.findElement(By.id(UIMapCheckOut.txtState)))
				.selectByVisibleText(dataTable.getData("General_Data", "State"));
		driver.findElement(By.id(UIMapCheckOut.txtZip)).clear();
		driver.findElement(By.id(UIMapCheckOut.txtZip)).sendKeys(
				dataTable.getData("General_Data", "zipcode"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		report.updateTestLog("Entering New Prod Destination Address",
				"New Prod Destination Address Added", Status.DONE);
		driver.findElement(By.xpath(UIMapCheckOut.btnSavePD)).click();
		selenium.waitForPageToLoad("120000");
		Thread.sleep(4000);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void clickAddNewAddressOnProdDestPageUPS() throws Exception {
		driver.findElement(By.linkText("Add New Address")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// entering address name
		driver.findElement(By.name(UIMapCheckOut.txtAddressNickNamee)).clear();
		String newNickName=dataTable.getData("General_Data", "AddressNickName").concat("1");
		dataTable.putData("General_Data", "AddressNickName", newNickName);
		System.out.println(newNickName);
		Thread.sleep(1000);
		driver.findElement(By.name(UIMapCheckOut.txtAddressNickNamee)).sendKeys(newNickName);
		driver.findElement(By.name(UIMapCheckOut.txtAddressFNamee)).clear();
		driver.findElement(By.name(UIMapCheckOut.txtAddressFNamee)).sendKeys(
		dataTable.getData("General_Data", "Firstname"));
		driver.findElement(By.name(UIMapCheckOut.txtAddressLNamee)).clear();
		driver.findElement(By.name(UIMapCheckOut.txtAddressLNamee)).sendKeys(
		dataTable.getData("General_Data", "Lastname"));
		driver.findElement(By.name(UIMapCheckOut.txtAddressLinee1)).clear();
		driver.findElement(By.name(UIMapCheckOut.txtAddressLinee1)).sendKeys(
		dataTable.getData("General_Data", "Address1"));
		driver.findElement(By.name(UIMapCheckOut.txtAddressCityy)).clear();
		driver.findElement(By.name(UIMapCheckOut.txtAddressCityy)).sendKeys(
		dataTable.getData("General_Data", "City"));
		new Select(driver.findElement(By.name(UIMapCheckOut.txtAddressStatee)))
		.selectByVisibleText(dataTable.getData("General_Data", "State"));
		driver.findElement(By.xpath(UIMapCheckOut.txtAddressZipCodee)).clear();
		driver.findElement(By.xpath(UIMapCheckOut.txtAddressZipCodee)).sendKeys(
		dataTable.getData("General_Data", "zipcode"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		report.updateTestLog("Entering New Prod Destination Address",
		"New Prod Destination Address Added", Status.DONE);
		driver.findElement(By.xpath(UIMapCheckOut.btnSavePDUPS)).click();
		selenium.waitForPageToLoad("120000");
		Thread.sleep(4000);
		}


	/**
	 * 
	 * @throws Exception
	 */
	public void clickAddNewAddressOnProdDestPage()throws Exception{
		driver.findElement(By.linkText("Add New Address")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//entering address
		driver.findElement(By.id(UIMapCheckOut.txtAddressName)).clear();
	    driver.findElement(By.id(UIMapCheckOut.txtAddressName)).sendKeys(dataTable.getData("General_Data", "AddressNickName"));
	    driver.findElement(By.id(UIMapCheckOut.txtFName)).clear();
	    driver.findElement(By.id(UIMapCheckOut.txtFName)).sendKeys(dataTable.getData("General_Data", "Firstname"));
	    driver.findElement(By.id(UIMapCheckOut.txtLName)).clear();
	    driver.findElement(By.id(UIMapCheckOut.txtLName)).sendKeys(dataTable.getData("General_Data", "Lastname"));
	    driver.findElement(By.id(UIMapCheckOut.txtAdd1)).clear();
	    driver.findElement(By.id(UIMapCheckOut.txtAdd1)).sendKeys(dataTable.getData("General_Data", "Address1"));
	    driver.findElement(By.id(UIMapCheckOut.txtCity)).clear();
	    driver.findElement(By.id(UIMapCheckOut.txtCity)).sendKeys(dataTable.getData("General_Data", "City"));
	    new Select(driver.findElement(By.id(UIMapCheckOut.txtState))).selectByVisibleText(dataTable.getData("General_Data", "State"));
	    driver.findElement(By.id(UIMapCheckOut.txtZip)).clear();
	    driver.findElement(By.id(UIMapCheckOut.txtZip)).sendKeys(dataTable.getData("General_Data", "zipcode"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		report.updateTestLog("Entering New Prod Destination Address", "New Prod Destination Address Added", Status.DONE);
		driver.findElement(By.xpath(UIMapCheckOut.btnSavePD)).click();
		selenium.waitForPageToLoad("120000");
		Thread.sleep(4000);
		driver.findElement(By.xpath(UIMapMyLowes.btnSecureCheckOut)).click();
	    selenium.waitForPageToLoad("120000");
		Thread.sleep(4000);
	}

	
	/*************This function validates Order Total displayed on Order Confirmation Page************/
	public void checkOrderTotal() throws Exception
	{
		String varOrderTotalDisplayed=driver.findElement(By.cssSelector(UIMapCheckOut.lblOrderTotalOrdrConfirmation)).getText();
		System.out.println(varOrderTotalDisplayed);
		if(varOrderTotalDisplayed.equals(dataTable.getData("General_Data", "OrderTotal")))
			report.updateTestLog("Checking Order Total", "Order Total Correct", Status.PASS);
		else
			report.updateTestLog("Checking Order Total", "Order Total INCorrect", Status.FAIL);
	}
	
	/*************This function validates whether Order# is displayed on Order Confirmation Page and stores the same in DataSheet************/
	public void checkOrderNbr() throws Exception
	{
		String varOrderNbrDisplayed=driver.findElement(By.cssSelector(UIMapCheckOut.lblOrderNbr)).getText();

		System.out.println(varOrderNbrDisplayed);

		if(!varOrderNbrDisplayed.isEmpty())

		{

		report.updateTestLog("Checking Order Nbr", "Order Nbr Displayed", Status.PASS);

		dataTable.putData("General_Data", "OrderNbr", varOrderNbrDisplayed);

		}

		else

		report.updateTestLog("Checking Order Nbr", "Order Nbr NOT Displayed", Status.FAIL);

		captureOrderNbr();	
	}
	
	
	
	
	/*This function clicks on Add to Cart button on Product Details Page*/
	public void clickCheckOutFromDetails() throws Exception
	{
		String varMiniCartCount=driver.findElement(By.id(UIMapCheckOut.webElmntMiniCartCount)).getText();
		
		dataTable.putData("General_Data", "CartCount", varMiniCartCount);
		WebElement varAddToCart = driver.findElement(By.xpath(UIMapProductSearch.btnAddToCart));
		WebElement varItemID = varAddToCart.findElement(By.xpath(".."));
		String varID = varItemID.getAttribute("id");
		String[] s=varID.split("_");
		System.out.println(s[1]);
		dataTable.putData("General_Data", "ItemId", s[1]);
		System.out.println(dataTable.getData("General_Data", "ItemId"));
		try{
		driver.findElement(By.xpath(UIMapProductSearch.btnAddToCart)).click();
		Thread.sleep(7000);}
		catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handled", Status.DONE);
			driver.findElement(By.xpath(UIMapProductSearch.btnAddToCart)).click();
			Thread.sleep(7000);}
		
		boolean varPopup = selenium.isElementPresent(UIMapProductSearch.webElmntAddToCartPopup);
		if(varPopup)
		{
			String varSuccess = driver.findElement(By.id(UIMapProductSearch.webElmntAddToCartPopup)).getText();
			if(varSuccess.equals("Your item was successfully added to cart."))
			{
				report.updateTestLog("Clicking CheckOut On Details Page", "Item added to Cart", Status.PASS);
			}
			else
			{
				report.updateTestLog("Clicking CheckOut On Details Page", "Item NOT added to Cart", Status.FAIL);
			}
		}
	}
	
	/*This function clicks on Continue shopping button on Item Added To Cart Popup on Product Details Page*/
	public void clickContinueShopping() throws Exception
	{
		driver.findElement(By.xpath(UIMapCheckOut.btnContinueShopping)).click();
		Thread.sleep(2000);
		report.updateTestLog("Clicking Continue Shopping", "Continue Shopping clicked", Status.DONE);
	}
	
	/*This function clicks on Checkout button on Item Added To Cart Popup on Product Details Page*/
	public void clickCheckOut() throws Exception
	{
		driver.findElement(By.xpath(UIMapProductSearch.btnCkeckOut)).click();
		Thread.sleep(2000);
		report.updateTestLog("Clicking Check Out", "Check Out clicked", Status.DONE);
	}
	
	public void closeChckOutPopup() throws Exception
	{
		driver.findElement(By.xpath(UIMapCheckOut.webElmntCloseChkOutPopup)).click();
		Thread.sleep(2000);
		report.updateTestLog("Closing Check Out Popup", "Check Out Popup closed", Status.DONE);
	}
	
	/*This function removes a particular Item from the cart*/
	public void removeItemFromCart() throws Exception
	{
		String varItemId=dataTable.getData("General_Data", "ItemId");
		driver.findElement(By.xpath("//*[@id='item_"+varItemId+"']/div[2]/div[3]/a")).click();
		selenium.waitForPageToLoad("20000");
		String varItemXpath="//*[@id='item_"+varItemId+"']";
		try{
		boolean varItemDisplayed=driver.findElement(By.xpath(varItemXpath)).isDisplayed();
		if(varItemDisplayed)
			report.updateTestLog("Clicking Remove for Item: "+dataTable.getData("General_Data", "ItemNbr"), "Item: "+dataTable.getData("General_Data", "ItemNbr")+" NOT removed", Status.FAIL);
		else
			report.updateTestLog("Clicking Remove for Item: "+dataTable.getData("General_Data", "ItemNbr"), "Item: "+dataTable.getData("General_Data", "ItemNbr")+" removed", Status.PASS);
		}
		catch(Exception NoSuchElementException)
		{
			report.updateTestLog("Clicking Remove for Item: "+dataTable.getData("General_Data", "ItemNbr"), "Item: "+dataTable.getData("General_Data", "ItemNbr")+" removed", Status.PASS);
		}
		
	}
	
	/*This function selects delivery method in Carts page*/
	public void selectDeliveryOptionCart() throws Exception
	{
		String varDeliveryOption = dataTable.getData("General_Data", "DeliveryMthd");
		if(varDeliveryOption.equals("PL"))
		{
			
			driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[2]/ul/li[1]/div/label/input")).click();
			Thread.sleep(5000);
			report.updateTestLog("Selecting Delivery Option","Delivery Option"+dataTable.getData("General_Data", "DeliveryMthd")+" selected for Item "+dataTable.getData("General_Data", "ItemNbr"), Status.DONE);
			
		}
		else if(varDeliveryOption.equals("UPS"))
		{
			driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[2]/ul/li[3]/div/label/input")).click();
			Thread.sleep(5000);
			report.updateTestLog("Selecting Delivery Option","Delivery Option"+dataTable.getData("General_Data", "DeliveryMthd")+" selected for Item "+dataTable.getData("General_Data", "ItemNbr"), Status.DONE);
		}
		else if(varDeliveryOption.equals("LD"))
		{
			driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[2]/ul/li[2]/div/label/input")).click();
			Thread.sleep(5000);
			report.updateTestLog("Selecting Delivery Option","Delivery Option"+dataTable.getData("General_Data", "DeliveryMthd")+" selected for Item "+dataTable.getData("General_Data", "ItemNbr"), Status.DONE);
		}
	}
	
	/*This function validates whether added product is displayed in Shopping Cart*/
	public void checkAddedProductInCart() throws Exception
	{
		try{
		boolean varItem=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']")).isDisplayed();
		if(varItem)
		{
			report.updateTestLog("Checking Item"+dataTable.getData("General_Data", "ItemNbr")+" In Cart","Item displayed in Cart",Status.PASS);
			boolean varDelOptionsDisplayed=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[2]/ul")).isDisplayed();
			System.out.println("Delivery Options displayed:"+varDelOptionsDisplayed);
			if(varDelOptionsDisplayed)
			{
				List<WebElement> varDelOptions = driver.findElements(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[2]/ul/li"));
				int varCount = varDelOptions.size();
				System.out.println("Delivery options Count:"+varCount);
				if(varCount==3)
					report.updateTestLog("Checking Delivery Options for Item"+dataTable.getData("General_Data", "ItemNbr")+" In Cart","3 Delivery Options displayed",Status.PASS);
				else
					report.updateTestLog("Checking Delivery Options for Item"+dataTable.getData("General_Data", "ItemNbr")+" In Cart","3 Delivery Options NOT displayed",Status.FAIL);
				
			}
			else
				report.updateTestLog("Checking Delivery Options for Item"+dataTable.getData("General_Data", "ItemNbr")+" In Cart","Delivery Options NOT displayed",Status.FAIL);
			
			boolean varQty=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[3]/input")).isDisplayed();
			System.out.println("Qty displayed:"+varQty);
			if(varQty)
				report.updateTestLog("Checking Quantity for Item"+dataTable.getData("General_Data", "ItemNbr")+" In Cart","Quantity displayed",Status.PASS);
			else
				report.updateTestLog("Checking Quantity for Item"+dataTable.getData("General_Data", "ItemNbr")+" In Cart","Quantity NOT displayed",Status.PASS);
			String varUnitPrice=null;
			
			try{
				 varUnitPrice=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[4]/div/div")).getText();
				System.out.println(varUnitPrice);
			}
			catch(Exception NoSuchElementException)
			{
				System.out.println("In first Catch Block");
				 varUnitPrice=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[4]")).getText();
				System.out.println(varUnitPrice);
			}
			if(!varUnitPrice.equals(""))
				report.updateTestLog("Checking Unit Price for Item"+dataTable.getData("General_Data", "ItemNbr")+" In Cart","Unit Price displayed",Status.PASS);
			else
				report.updateTestLog("Checking Unit Price for Item"+dataTable.getData("General_Data", "ItemNbr")+" In Cart","Unit Price NOT displayed",Status.PASS);
		}
		else
			report.updateTestLog("Checking Item"+dataTable.getData("General_Data", "ItemNbr")+" In Cart","Item NOT displayed in Cart",Status.FAIL);
		}
		catch(Exception NoSuchElementException)
		{
			report.updateTestLog("Checking Item"+dataTable.getData("General_Data", "ItemNbr")+" In Cart","Item Price/Qty/Delivery Options NOT displayed Properly in Cart",Status.FAIL);
		}
	}
	
	public void searchItem(String item) {
			
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(item);
		try {
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		} catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		}
		report.updateTestLog("Searching For an Item","Searching Item Number - "	+ item + "",Status.DONE);

		boolean verItemPresent = selenium.isTextPresent(item);
		if (verItemPresent) {
			report.updateTestLog("Verifying Navigating to Item's PDP Page",	"Item - " + item+ " is Present", Status.PASS);
		} else {
			report.updateTestLog("Verifying Navigating to Item's PDP Page","Item is NOT Present", Status.FAIL);
		}
	}
	
	public void addItemToCart() {
		try {
			driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
			}
			catch (Exception WebDriverException) {
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup", "Handled", Status.DONE);
				driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
			}
	}
	
	/*public void searchAndAddItemToCart() {
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data", "ItemNbr"));
		try {
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		} catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		}
		report.updateTestLog("Searching For an Item","Searching Item Number - "	+ dataTable.getData("General_Data", "ItemNbr") + "",Status.DONE);

		boolean verItemPresent = selenium.isTextPresent("ItemNbr");
		if (verItemPresent) {
			report.updateTestLog("Verifying Navigating to Item's PDP Page",	"Item - " + dataTable.getData("General_Data", "ItemNbr")+ " is Present", Status.PASS);
		} else {
			report.updateTestLog("Verifying Navigating to Item's PDP Page","Item is NOT Present", Status.FAIL);
		}
		try {
		driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
		}
		catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
		}
	}*/
	public void searchAndAddItemToCart() {
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data", "ItemNbr"));
		try {
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		} catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		}
		report.updateTestLog("Searching For an Item","Searching Item Number - "	+ dataTable.getData("General_Data", "ItemNbr") + "",Status.DONE);

		try {
		driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
		}
		catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
		}
	}
	
	/*This function updates Product Qty in Cart Page*/
	public void updateQtyInCart() throws Exception
	{
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[3]/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[3]/input")).clear();
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[3]/input")).sendKeys(dataTable.getData("General_Data", "Qty"));
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[3]/input")).sendKeys(Keys.ENTER);
		
		//driver.findElement(By.xpath(UIMapCheckOut.btnQtyUpdate)).click();
		selenium.waitForPageToLoad("30000");
		Thread.sleep(10000);
	}
	
	/*This function enters Sign In Info after Start Secure Checkout*/
	public void enterSignInInfoCheckOut() throws Exception
	{
		driver.findElement(By.id(UIMapFunctionalComponents.txtUserName)).sendKeys(dataTable.getData("General_Data","email"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(dataTable.getData("General_Data", "password"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(Keys.ENTER);
		//driver.findElement(By.id("GoYourAccount")).click();		
		selenium.waitForPageToLoad("30000");
		//Thread.sleep(20000);
		
	}
	
	
	/***********************Selects Shipping Address from Drop-Down on Product Destination Page************************/
	public void selectShippingAddProductDestinationPg() throws Exception
	{
		
			try{
			new Select(driver.findElement(By.id(UIMapCheckOut.drpDownLDShippingAddress))).selectByVisibleText(dataTable.getData("General_Data", "ShipToAdd"));
			Thread.sleep(2000);
			
			}
			catch(Exception e)
			{
				System.out.println("No Truck delivery Product");
			}
			try{
			new Select(driver.findElement(By.id(UIMapCheckOut.drpDownPDShippingAddress))).selectByVisibleText(dataTable.getData("General_Data", "ShipToAdd"));
			Thread.sleep(2000);
				
			}
			catch(Exception e)
			{
					System.out.println("No Parcel Shipping Product");
			}
		
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void checkOutCreditCard() throws Exception {
		driver.findElement(By.name(UIMapMyLowes.txtCardNickName)).clear();
		driver.findElement(By.name(UIMapMyLowes.txtCardNickName)).sendKeys(dataTable.getData("General_Data", "nickName"));
		new Select(driver.findElement(By.id(UIMapMyLowes.drpDownChkOutType))).selectByVisibleText(dataTable.getData("General_Data","cardType"));
		driver.findElement(By.xpath(UIMapMyLowes.lblCheckOutCreditCardNo)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.lblCheckOutCreditCardNo)).sendKeys(dataTable.getData("General_Data", "crditCardNo"));
		driver.findElement(By.id(UIMapMyLowes.txtSCode)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtSCode)).sendKeys("1111");
		new Select(driver.findElement(By.id(UIMapMyLowes.txtExpYear))).selectByVisibleText(dataTable.getData("General_Data", "year"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}
	
	
	/***For new User, checks whether address on Product Destination page is same as that entered in Shipping Address page.**/
	public void validateProductDestinationAddressNewUser() throws Exception
	{
		try{
			String varPDShippingAddress=driver.findElement(By.xpath(UIMapCheckOut.lblPDShippingAddress)).getText();
			System.out.println(varPDShippingAddress);
			String varExpectedAddress=dataTable.getData("General_Data", "AddressNickName")+" - "+dataTable.getData("General_Data", "Firstname")
			+" "+dataTable.getData("General_Data", "Lastname")+", "+dataTable.getData("General_Data", "Address1")+'\n'+dataTable.getData("General_Data", "City")+
			", "+dataTable.getData("General_Data", "StateShortForm")+" "+dataTable.getData("General_Data", "zipcode");
			System.out.println(varExpectedAddress);
			
			/*if((varPDShippingAddress.contains(dataTable.getData("General_Data", "AddressNickName"))) && (varPDShippingAddress.contains(dataTable.getData("General_Data", "Firstname"))) 
					&& (varPDShippingAddress.contains(dataTable.getData("General_Data", "Lastname"))) && (varPDShippingAddress.contains(dataTable.getData("General_Data", "Address1")))
					&& (varPDShippingAddress.contains(dataTable.getData("General_Data", "City"))) && (varPDShippingAddress.contains(dataTable.getData("General_Data", "StateShortForm"))) &&
					(varPDShippingAddress.contains(dataTable.getData("General_Data", "zipcode"))))*/
			if(varPDShippingAddress.equals(varExpectedAddress))
			{
				report.updateTestLog("Checking Product Destination Page", "Shipping Address Correct for Parcel Shipping", Status.PASS);
			}
			else
				report.updateTestLog("Checking Product Destination Page", "Shipping Address NOT Correct for Parcel Shipping", Status.FAIL);
		}
		catch(Exception NoSuchElementException)
		{
			System.out.println("No Parcel Shipping Product");
		}
		try{
			String varLDShippingAddress=driver.findElement(By.xpath(UIMapCheckOut.lblLDShippingAddress)).getText();
			System.out.println(varLDShippingAddress);
			String varExpectedAddress=dataTable.getData("General_Data", "AddressNickName")+" - "+dataTable.getData("General_Data", "Firstname")
			+" "+dataTable.getData("General_Data", "Lastname")+", "+dataTable.getData("General_Data", "Address1")+'\n'+dataTable.getData("General_Data", "City")+
			", "+dataTable.getData("General_Data", "StateShortForm")+" "+dataTable.getData("General_Data", "zipcode");
			System.out.println(varExpectedAddress);
			if(varLDShippingAddress.equals(varExpectedAddress))
			{
				report.updateTestLog("Checking Product Destination Page", "Shipping Address Correct for Truck Delivery", Status.PASS);
			}
			else
				report.updateTestLog("Checking Product Destination Page", "Shipping Address NOT Correct for Truck Delivery", Status.FAIL);
		}
		catch(Exception NoSuchElementException)
		{
			System.out.println("No Truck Delivery Product");
		}
	}
	
	/*******Validates Bill To Address on Order Confirmation page.**********/
	public void validateBillAddrssOrderConfirmation()
	{
		String varBillAddressName=driver.findElement(By.cssSelector(UIMapCheckOut.lblBillAdressNameOC)).getText();
		String varBillAddress=driver.findElement(By.cssSelector(UIMapCheckOut.lblBillAdressOC)).getText();
		String varExpectedBillAddName=dataTable.getData("General_Data", "BillFirstname")+" "+dataTable.getData("General_Data", "BillLastname");
		String varExpBillAddress=dataTable.getData("General_Data", "BillAddress1")+'\n'+dataTable.getData("General_Data", "BillCity")+", "+
		dataTable.getData("General_Data", "BillStateShortForm")+" "+dataTable.getData("General_Data", "Billzipcode");
		System.out.println(varBillAddressName);
		System.out.println(varExpectedBillAddName);
		if(varExpectedBillAddName.equals(varBillAddressName))
			report.updateTestLog("Checking Billing Address on Order Confirmation page", "Billing address Name correct", Status.PASS);
		else
			report.updateTestLog("Checking Billing Address on Order Confirmation page", "Billing address Name Incorrect", Status.FAIL);
		System.out.println(varBillAddress);
		System.out.println(varExpBillAddress);
		if(varExpBillAddress.equals(varBillAddress))
			report.updateTestLog("Checking Billing Address on Order Confirmation page", "Billing address correct", Status.PASS);
		else
			report.updateTestLog("Checking Billing Address on Order Confirmation page", "Billing address Incorrect", Status.FAIL);
	}
	
	/**********Validates Ship To Address on Order Confirmation page*********/
	/*Needs modification to check all shipping adresses on Order Confirmation page*/
	public void validateShipAddrssOrderConfirmation()
	{
		String varExpectedShipAddName=dataTable.getData("General_Data", "Firstname")+" "+dataTable.getData("General_Data", "Lastname");
		String varExpShipAddress=dataTable.getData("General_Data", "Address1")+'\n'+dataTable.getData("General_Data", "City")+", "+
		dataTable.getData("General_Data", "StateShortForm")+" "+dataTable.getData("General_Data", "zipcode");
		/*String varShipAddressName=driver.findElement(By.cssSelector(UIMapCheckOut.lblShipAdressNameOC)).getText();
		String varShipAddress=driver.findElement(By.cssSelector(UIMapCheckOut.lblShipAdressOC)).getText();
		
		System.out.println(varShipAddressName);
		System.out.println(varExpectedShipAddName);
		if(varExpectedShipAddName.equals(varShipAddressName))
			report.updateTestLog("Checking Shipping Address on Order Confirmation page", "Shipping address Name correct", Status.PASS);
		else
			report.updateTestLog("Checking Shipping Address on Order Confirmation page", "Shipping address Name Incorrect", Status.FAIL);
		System.out.println(varShipAddress);
		System.out.println(varExpShipAddress);
		if(varExpShipAddress.equals(varShipAddress))
			report.updateTestLog("Checking Shipping Address on Order Confirmation page", "Shipping address correct", Status.PASS);
		else
			report.updateTestLog("Checking Shipping Address on Order Confirmation page", "Shipping address Incorrect", Status.FAIL);*/
		int varCount =driver.findElements(By.xpath(UIMapCheckOut.webElmntOrderConfirmationShipItems)).size();
		System.out.println(varCount);
		for(int i=1;i<=varCount;i++)
			{
				
				String varDeliverTo=driver.findElement(By.xpath("("+UIMapCheckOut.lblDeliverToHeading+")["+i+"]")).getText();
				if(varDeliverTo.contains("Store Pickup"))
				{
					String varStoreAdd1=driver.findElement(By.xpath(UIMapCheckOut.lblStoreAddress1)).getText();
					String varStoreAdd2=driver.findElement(By.xpath(UIMapCheckOut.lblStoreAddress2)).getText();
					String[] s=varStoreAdd2.split(", Store #");
					String varStoreAddrss=varStoreAdd1+'\n'+s[1];
					System.out.println(varStoreAddrss);
					String varShipToAdd=driver.findElement(By.xpath("("+UIMapCheckOut.lblShipToAddress+")["+i+"]")).getText();
					System.out.println(varShipToAdd);
					if(varExpShipAddress.trim().equals(varShipToAdd.trim()))
						report.updateTestLog("Checking Shipping Address on Order Confirmation page", "Store Address for Pickup correct for Item "+i, Status.PASS);
					else
						report.updateTestLog("Checking Shipping Address on Order Confirmation page", "Store Address for Pickup Incorrect for Item "+i, Status.FAIL);
				}
				else
				{
				String varShipToName=driver.findElement(By.xpath("("+UIMapCheckOut.lblShipToName+")["+i+"]")).getText();
				String varShipToAdd=driver.findElement(By.xpath("("+UIMapCheckOut.lblShipToAddress+")["+i+"]")).getText();
				System.out.println(varShipToName);
				System.out.println(varExpectedShipAddName);
				if(varExpectedShipAddName.equals(varShipToName))
					report.updateTestLog("Checking Shipping Address on Order Confirmation page", "Shipping address Name correct for Item "+i, Status.PASS);
				else
					report.updateTestLog("Checking Shipping Address on Order Confirmation page", "Shipping address Name Incorrect for Item "+i, Status.FAIL);
				System.out.println(varShipToAdd);
				System.out.println(varExpShipAddress);
				if(varExpShipAddress.equals(varShipToAdd))
					report.updateTestLog("Checking Shipping Address on Order Confirmation page", "Shipping address correct for Item "+i, Status.PASS);
				else
					report.updateTestLog("Checking Shipping Address on Order Confirmation page", "Shipping address Incorrect for Item "+i, Status.FAIL);
				}
			}
		
	}
	
	public void navigateManageAddress() throws Exception
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
		if (varMyLowes.equals("Preferences")) {
			report.updateTestLog("Clicking Your Account link-Preferences",
					"Preferences page displayed", Status.PASS);
		} else {
			report.updateTestLog("Clicking Your Account link",
					"Preferences page NOT displayed", Status.FAIL);
		}
		try{
		driver.findElement(By.xpath(UIMapMyLowes.webElmntEditAddressPreferences)).click();
		selenium.waitForPageToLoad("20000");
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.webElmntEditAddressPreferences)).click();
			selenium.waitForPageToLoad("20000");
			}
		if(selenium.isTextPresent("Address Book"))
		{
			report.updateTestLog("Clicking Edit Address link",
					"Address Book displayed", Status.PASS);
		}
		else
			report.updateTestLog("Clicking Edit Address link",
					"Address Book NOT displayed", Status.FAIL);
	}
	
	
	/*******Validates Billing Address  is saved in Address Book******/
	public void validateBillAddAddressBook() throws Exception
	{
		String varBillAdrssName=driver.findElement(By.xpath(UIMapCheckOut.lblBillAdressName)).getText();
		String varBillAdrssFname=driver.findElement(By.xpath(UIMapCheckOut.lblBillAdressFnameAB)).getText();
		String varBillAdrssLname=driver.findElement(By.xpath(UIMapCheckOut.lblBillAdressLnameAB)).getText();
		String varBillAdrssLine1=driver.findElement(By.xpath(UIMapCheckOut.lblBillAdressLine1AB)).getText();
		String varBillAdrssCity=driver.findElement(By.xpath(UIMapCheckOut.lblBillAdressCityAB)).getText();
		String varBillAdrssState=driver.findElement(By.xpath(UIMapCheckOut.lblBillAdressStateAbbAB)).getText();
		String varBillAdrssZC=driver.findElement(By.xpath(UIMapCheckOut.lblBillAdressZipCodeAB)).getText();
		String varBillAdrssPhn1=driver.findElement(By.xpath(UIMapCheckOut.lblBillAdressPhn1AB)).getText();
		String varBillAdrssPhn2=driver.findElement(By.xpath(UIMapCheckOut.lblBillAdressPhn2AB)).getText();
		String varBillAdrssPhn3=driver.findElement(By.xpath(UIMapCheckOut.lblBillAdressPhn3AB)).getText();
		
		System.out.println(varBillAdrssName+"::"+dataTable.getData("General_Data", "BillAddressNickName"));
		if(varBillAdrssName.equals(dataTable.getData("General_Data", "BillAddressNickName")))
			report.updateTestLog("Checking Billing Address Name", "Billing Address Name Correct", Status.PASS);
		else
			report.updateTestLog("Checking Billing Address Name", "Billing Address Name NOT Correct", Status.FAIL);
		
		
		System.out.println(varBillAdrssFname+"::"+dataTable.getData("General_Data", "BillFirstname"));
		if(varBillAdrssFname.equals(dataTable.getData("General_Data", "BillFirstname")))
			report.updateTestLog("Checking Billing Address First Name", "Billing Address First Name Correct", Status.PASS);
		else
			report.updateTestLog("Checking Billing Address First Name", "Billing Address First Name NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrssLname+"::"+dataTable.getData("General_Data", "BillLastname"));
		if(varBillAdrssLname.equals(dataTable.getData("General_Data", "BillLastname")))
			report.updateTestLog("Checking Billing Address Last Name", "Billing Address Last Name Correct", Status.PASS);
		else
			report.updateTestLog("Checking Billing Address Last Name", "Billing Address Last Name NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrssLine1+"::"+dataTable.getData("General_Data", "BillAddress1"));
		if(varBillAdrssLine1.equals(dataTable.getData("General_Data", "BillAddress1")))
			report.updateTestLog("Checking Billing Address Address Line 1", "Billing Address Address Line 1 Correct", Status.PASS);
		else
			report.updateTestLog("Checking Billing Address Address Line 1", "Billing Address Address Line 1 NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrssCity+"::"+dataTable.getData("General_Data", "BillCity"));
		if(varBillAdrssCity.equals(dataTable.getData("General_Data", "BillCity")))
			report.updateTestLog("Checking Billing Address City", "Billing Address City Correct", Status.PASS);
		else
			report.updateTestLog("Checking Billing Address City", "Billing Address City NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrssState+"::"+dataTable.getData("General_Data", "BillStateShortForm"));
		if(varBillAdrssState.equals(dataTable.getData("General_Data", "BillStateShortForm")))
			report.updateTestLog("Checking Billing Address State", "Billing Address State Correct", Status.PASS);
		else
			report.updateTestLog("Checking Billing Address State", "Billing Address State NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrssZC+"::"+dataTable.getData("General_Data", "Billzipcode"));
		if(varBillAdrssZC.equals(dataTable.getData("General_Data", "Billzipcode")))
			report.updateTestLog("Checking Billing Address Zip Code", "Billing Address Zip Code Correct", Status.PASS);
		else
			report.updateTestLog("Checking Billing Address Zip Code", "Billing Address Zip Code NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrssPhn1+"::"+dataTable.getData("General_Data", "BillPhone1"));
		if(varBillAdrssPhn1.equals(dataTable.getData("General_Data", "BillPhone1")))
			report.updateTestLog("Checking Billing Address Phone", "Billing Address Phone1 Correct", Status.PASS);
		else
			report.updateTestLog("Checking Billing Address Phone", "Billing Address Phone1 NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrssPhn2+"::"+dataTable.getData("General_Data", "BillPhone2"));
		if(varBillAdrssPhn2.equals(dataTable.getData("General_Data", "BillPhone2")))
			report.updateTestLog("Checking Billing Address Phone", "Billing Address Phone2 Correct", Status.PASS);
		else
			report.updateTestLog("Checking Billing Address Phone", "Billing Address Phone2 NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrssPhn3+"::"+dataTable.getData("General_Data", "BillPhone3"));
		if(varBillAdrssPhn3.equals(dataTable.getData("General_Data", "BillPhone3")))
			report.updateTestLog("Checking Billing Address Phone", "Billing Address Phone3 Correct", Status.PASS);
		else
			report.updateTestLog("Checking Billing Address Phone", "Billing Address Phone3 NOT Correct", Status.FAIL);
		
		
	}
	
	
	/*******Validates Billing Address  is saved in Address Book for Scenario-New Registered User-selecting Primary Address as Billing address******/
	public void validateBillAddAddressBookForPrimaryAdd() throws Exception
	{
		String varBillAdrssName=driver.findElement(By.xpath(UIMapCheckOut.lblBillAdressName)).getText();
		String varBillAdrssFname=driver.findElement(By.xpath(UIMapCheckOut.lblBillAdressFnameAB)).getText();
		String varBillAdrssLname=driver.findElement(By.xpath(UIMapCheckOut.lblBillAdressLnameAB)).getText();
		String varBillAdrss=driver.findElement(By.xpath(UIMapCheckOut.lblBillNoAdress)).getText();
		
		String varBillAdrssPhn1=driver.findElement(By.xpath(UIMapCheckOut.lblBillAdressPhn1AB)).getText();
		String varBillAdrssPhn2=driver.findElement(By.xpath(UIMapCheckOut.lblBillAdressPhn2AB)).getText();
		String varBillAdrssPhn3=driver.findElement(By.xpath(UIMapCheckOut.lblBillAdressPhn3AB)).getText();
		
		System.out.println(varBillAdrssName+"::"+dataTable.getData("General_Data", "BillAddressNickName"));
		if(varBillAdrssName.equals(dataTable.getData("General_Data", "BillAddressNickName")))
			report.updateTestLog("Checking Billing Address Name", "Billing Address Name Correct", Status.PASS);
		else
			report.updateTestLog("Checking Billing Address Name", "Billing Address Name NOT Correct", Status.FAIL);
		
		
		System.out.println(varBillAdrssFname+"::"+dataTable.getData("General_Data", "BillFirstname"));
		if(varBillAdrssFname.equals(dataTable.getData("General_Data", "BillFirstname")))
			report.updateTestLog("Checking Billing Address First Name", "Billing Address First Name Correct", Status.PASS);
		else
			report.updateTestLog("Checking Billing Address First Name", "Billing Address First Name NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrssLname+"::"+dataTable.getData("General_Data", "BillLastname"));
		if(varBillAdrssLname.equals(dataTable.getData("General_Data", "BillLastname")))
			report.updateTestLog("Checking Billing Address Last Name", "Billing Address Last Name Correct", Status.PASS);
		else
			report.updateTestLog("Checking Billing Address Last Name", "Billing Address Last Name NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrss);
		if(varBillAdrss.equalsIgnoreCase("No Address on File"))
			report.updateTestLog("Checking Billing Address", "Billing Address Correct", Status.PASS);
		else
			report.updateTestLog("Checking Billing Address", "Billing Address NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrssPhn1+"::"+dataTable.getData("General_Data", "BillPhone1"));
		if(varBillAdrssPhn1.equals(dataTable.getData("General_Data", "BillPhone1")))
			report.updateTestLog("Checking Billing Address Phone", "Billing Address Phone1 Correct", Status.PASS);
		else
			report.updateTestLog("Checking Billing Address Phone", "Billing Address Phone1 NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrssPhn2+"::"+dataTable.getData("General_Data", "BillPhone2"));
		if(varBillAdrssPhn2.equals(dataTable.getData("General_Data", "BillPhone2")))
			report.updateTestLog("Checking Billing Address Phone", "Billing Address Phone2 Correct", Status.PASS);
		else
			report.updateTestLog("Checking Billing Address Phone", "Billing Address Phone2 NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrssPhn3+"::"+dataTable.getData("General_Data", "BillPhone3"));
		if(varBillAdrssPhn3.equals(dataTable.getData("General_Data", "BillPhone3")))
			report.updateTestLog("Checking Billing Address Phone", "Billing Address Phone3 Correct", Status.PASS);
		else
			report.updateTestLog("Checking Billing Address Phone", "Billing Address Phone3 NOT Correct", Status.FAIL);
		
		
	}
	
	
	/*******Validates Shipping Address  is saved in Address Book for Newly Registered User(Registered using Sign Up)-Billing Shipping Different/Billing Primary Address******/
	public void validateShipAddAddressBookRegFrmMH() throws Exception
	{
		String varShipAdrssName=driver.findElement(By.xpath(UIMapCheckOut.lblShipAdressName)).getText();
		String varShipAdrssFname=driver.findElement(By.xpath(UIMapCheckOut.lblShipAdressFnameAB)).getText();
		String varShipAdrssLname=driver.findElement(By.xpath(UIMapCheckOut.lblShipAdressLnameAB)).getText();
		String varShipAdrssLine1=driver.findElement(By.xpath(UIMapCheckOut.lblShipAdressLine1AB)).getText();
		String varShipAdrssCity=driver.findElement(By.xpath(UIMapCheckOut.lblShipAdressCityAB)).getText();
		String varShipAdrssState=driver.findElement(By.xpath(UIMapCheckOut.lblShipAdressStateAbbAB)).getText();
		String varShipAdrssZC=driver.findElement(By.xpath(UIMapCheckOut.lblShipAdressZipCodeAB)).getText();
		
		
		System.out.println(varShipAdrssName+"::"+dataTable.getData("General_Data", "AddressNickName"));
		if(varShipAdrssName.equals(dataTable.getData("General_Data", "AddressNickName")))
			report.updateTestLog("Checking Shipping Address Name", "Shipping Address Name Correct", Status.PASS);
		else
			report.updateTestLog("Checking Shipping Address Name", "Shipping Address Name NOT Correct", Status.FAIL);
		
		System.out.println(varShipAdrssFname+"::"+dataTable.getData("General_Data", "Firstname"));
		if(varShipAdrssFname.equals(dataTable.getData("General_Data", "Firstname")))
			report.updateTestLog("Checking Shipping Address First Name", "Shipping Address First Name Correct", Status.PASS);
		else
			report.updateTestLog("Checking Shipping Address First Name", "Shipping Address First Name NOT Correct", Status.FAIL);
		
		System.out.println(varShipAdrssLname+"::"+dataTable.getData("General_Data", "Lastname"));
		if(varShipAdrssLname.equals(dataTable.getData("General_Data", "Lastname")))
			report.updateTestLog("Checking Shipping Address Last Name", "Shipping Address Last Name Correct", Status.PASS);
		else
			report.updateTestLog("Checking Shipping Address Last Name", "Shipping Address Last Name NOT Correct", Status.FAIL);
		
		System.out.println(varShipAdrssLine1+"::"+dataTable.getData("General_Data", "Address1"));
		if(varShipAdrssLine1.equals(dataTable.getData("General_Data", "Address1")))
			report.updateTestLog("Checking Shipping Address Address Line 1", "Shipping Address Address Line 1 Correct", Status.PASS);
		else
			report.updateTestLog("Checking Shipping Address Address Line 1", "Shipping Address Address Line 1 NOT Correct", Status.FAIL);
		
		System.out.println(varShipAdrssCity+"::"+dataTable.getData("General_Data", "City"));
		if(varShipAdrssCity.equals(dataTable.getData("General_Data", "City")))
			report.updateTestLog("Checking Shipping Address City", "Shipping Address City Correct", Status.PASS);
		else
			report.updateTestLog("Checking Shipping Address City", "Shipping Address City NOT Correct", Status.FAIL);
		
		System.out.println(varShipAdrssState+"::"+dataTable.getData("General_Data", "StateShortForm"));
		if(varShipAdrssState.equals(dataTable.getData("General_Data", "StateShortForm")))
			report.updateTestLog("Checking Shipping Address State", "Shipping Address State Correct", Status.PASS);
		else
			report.updateTestLog("Checking Shipping Address State", "Shipping Address State NOT Correct", Status.FAIL);
		
		System.out.println(varShipAdrssZC+"::"+dataTable.getData("General_Data", "zipcode"));
		if(varShipAdrssZC.equals(dataTable.getData("General_Data", "zipcode")))
			report.updateTestLog("Checking Shipping Address Zip Code", "Shipping Address Zip Code Correct", Status.PASS);
		else
			report.updateTestLog("Checking Shipping Address Zip Code", "Shipping Address Zip Code NOT Correct", Status.FAIL);
		
	
		
		
	}
	
	/*******Validates Shipping Address  is saved in Address Book for Registered User from Review & Pay Page-Billing Shipping Same******/
	public void validateShipAddAddressBookRegFrmRevPay() throws Exception
	{
		String varShipAdrssName=driver.findElement(By.xpath(UIMapCheckOut.lblShipAdressName2)).getText();
		String varShipAdrssFname=driver.findElement(By.xpath(UIMapCheckOut.lblShipAdressFnameAB2)).getText();
		String varShipAdrssLname=driver.findElement(By.xpath(UIMapCheckOut.lblShipAdressLnameAB2)).getText();
		String varShipAdrssLine1=driver.findElement(By.xpath(UIMapCheckOut.lblShipAdressLine1AB2)).getText();
		String varShipAdrssCity=driver.findElement(By.xpath(UIMapCheckOut.lblShipAdressCityAB2)).getText();
		String varShipAdrssState=driver.findElement(By.xpath(UIMapCheckOut.lblShipAdressStateAbbAB2)).getText();
		String varShipAdrssZC=driver.findElement(By.xpath(UIMapCheckOut.lblShipAdressZipCodeAB2)).getText();
		
		
		System.out.println(varShipAdrssName+"::"+dataTable.getData("General_Data", "AddressNickName"));
		if(varShipAdrssName.equals(dataTable.getData("General_Data", "AddressNickName")))
			report.updateTestLog("Checking Shipping Address Name", "Shipping Address Name Correct", Status.PASS);
		else
			report.updateTestLog("Checking Shipping Address Name", "Shipping Address Name NOT Correct", Status.FAIL);
		
		System.out.println(varShipAdrssFname+"::"+dataTable.getData("General_Data", "Firstname"));
		if(varShipAdrssFname.equals(dataTable.getData("General_Data", "Firstname")))
			report.updateTestLog("Checking Shipping Address First Name", "Shipping Address First Name Correct", Status.PASS);
		else
			report.updateTestLog("Checking Shipping Address First Name", "Shipping Address First Name NOT Correct", Status.FAIL);
		
		System.out.println(varShipAdrssLname+"::"+dataTable.getData("General_Data", "Lastname"));
		if(varShipAdrssLname.equals(dataTable.getData("General_Data", "Lastname")))
			report.updateTestLog("Checking Shipping Address Last Name", "Shipping Address Last Name Correct", Status.PASS);
		else
			report.updateTestLog("Checking Shipping Address Last Name", "Shipping Address Last Name NOT Correct", Status.FAIL);
		
		System.out.println(varShipAdrssLine1+"::"+dataTable.getData("General_Data", "Address1"));
		if(varShipAdrssLine1.equals(dataTable.getData("General_Data", "Address1")))
			report.updateTestLog("Checking Shipping Address Address Line 1", "Shipping Address Address Line 1 Correct", Status.PASS);
		else
			report.updateTestLog("Checking Shipping Address Address Line 1", "Shipping Address Address Line 1 NOT Correct", Status.FAIL);
		
		System.out.println(varShipAdrssCity+"::"+dataTable.getData("General_Data", "City"));
		if(varShipAdrssCity.equals(dataTable.getData("General_Data", "City")))
			report.updateTestLog("Checking Shipping Address City", "Shipping Address City Correct", Status.PASS);
		else
			report.updateTestLog("Checking Shipping Address City", "Shipping Address City NOT Correct", Status.FAIL);
		
		System.out.println(varShipAdrssState+"::"+dataTable.getData("General_Data", "StateShortForm"));
		if(varShipAdrssState.equals(dataTable.getData("General_Data", "StateShortForm")))
			report.updateTestLog("Checking Shipping Address State", "Shipping Address State Correct", Status.PASS);
		else
			report.updateTestLog("Checking Shipping Address State", "Shipping Address State NOT Correct", Status.FAIL);
		
		System.out.println(varShipAdrssZC+"::"+dataTable.getData("General_Data", "zipcode"));
		if(varShipAdrssZC.equals(dataTable.getData("General_Data", "zipcode")))
			report.updateTestLog("Checking Shipping Address Zip Code", "Shipping Address Zip Code Correct", Status.PASS);
		else
			report.updateTestLog("Checking Shipping Address Zip Code", "Shipping Address Zip Code NOT Correct", Status.FAIL);
		
	
		
		
	}
	
	public void clickYourAccount() throws Exception
	{
		driver.findElement(By.xpath("//*[@id='nav-my-account']/span[2]")).click();
		selenium.waitForPageToLoad("20000");
	}
	
	/**********Stores Billing Address as Shipping Address in DataTable*********/
	public void makeBillingSameAsShippingInDataSheet() throws Exception
	{
		String add1=dataTable.getData("General_Data", "Address1");
		dataTable.putData("General_Data", "BillAddress1", add1);
		String add2=dataTable.getData("General_Data", "Address2");
		dataTable.putData("General_Data", "BillAddress2", add2);
		String city=dataTable.getData("General_Data", "City");
		dataTable.putData("General_Data", "BillCity", city);
		String state=dataTable.getData("General_Data", "State");
		dataTable.putData("General_Data", "BillState", state);
		String stateAbb=dataTable.getData("General_Data", "StateShortForm");
		dataTable.putData("General_Data", "BillStateShortForm", stateAbb);
		String zipcode=dataTable.getData("General_Data", "zipcode");
		dataTable.putData("General_Data", "Billzipcode", zipcode);
		//String nick=dataTable.getData("General_Data", "AddressNickName");
		dataTable.putData("General_Data", "BillAddressNickName", "DEFAULT");
	}
	
	/**********Stores Billing Address in DataTable for Primary Address *********/
	public void makeBillingPrimaryAddInDataSheet() throws Exception
	{
		String fname=dataTable.getData("General_Data", "Firstname");
		dataTable.putData("General_Data", "BillFirstname", fname);
		String lname=dataTable.getData("General_Data", "Lastname");
		dataTable.putData("General_Data", "BillLastname", lname);
		String add1=dataTable.getData("General_Data", "Address1");
		dataTable.putData("General_Data", "BillAddress1", add1);
		String add2=dataTable.getData("General_Data", "Address2");
		dataTable.putData("General_Data", "BillAddress2", add2);
		String city=dataTable.getData("General_Data", "City");
		dataTable.putData("General_Data", "BillCity", city);
		String state=dataTable.getData("General_Data", "State");
		dataTable.putData("General_Data", "BillState", state);
		String stateAbb=dataTable.getData("General_Data", "StateShortForm");
		dataTable.putData("General_Data", "BillStateShortForm", stateAbb);
		String zipcode=dataTable.getData("General_Data", "zipcode");
		dataTable.putData("General_Data", "Billzipcode", zipcode);
		//String nick=dataTable.getData("General_Data", "AddressNickName");
		dataTable.putData("General_Data", "BillAddressNickName", "DEFAULT");
	}
	
	/****************Makes the cart empty if Cart has Items*******/
	public void makeCartEmpty() throws Exception
	{
		String varMiniCartCount=driver.findElement(By.id(UIMapCheckOut.webElmntMiniCartCount)).getText();
		int varCount=Integer.valueOf(varMiniCartCount);
		if(varCount>0)
		{
			driver.findElement(By.xpath(UIMapCheckOut.webElmntMiniCart)).click();
			Thread.sleep(2000);
			selenium.waitForPageToLoad("20000");
			emptyTheCart();
		}
		
	}
	
	/*****
	 * This function stores TC Name and Order Nbr in an excel file for later validations
	 * @throws Exception
	 */
	public void captureOrderNbr() throws Exception
	{
		String varOrderNbrDisplayed=driver.findElement(By.cssSelector(UIMapCheckOut.lblOrderNbr)).getText();
		System.out.println(varOrderNbrDisplayed);

		FileUtils.writeStringToFile(new File(System.getProperty("user.dir")
				+ "/Results/OrderNbrs.txt"),
				dataTable.getData("General_Data", "TC_ID") + "\t"
						+ varOrderNbrDisplayed + "\r\n", true);

	}
	
	/**
	 * YourAccountPreferences will go to your Account link and click on
	 * Preferences
	 * 
	 * @throws Exception
	 */
	public void gotoYourAccountPreferences() throws Exception {
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
		Thread.sleep(6000);
		WebElement subLink = driver.findElement(By.id("nav-my-profile"));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.lblBreadCrumb2)).getText();
		System.out.println(varMyLowes);
		if (varMyLowes.equals("Preferences")) {
			report.updateTestLog("Clicking Your Account link",
					"MyLowe's page displayed", Status.PASS);
		} else {
			report.updateTestLog("Clicking Your Account link",
					"MyLowe's page NOT displayed", Status.FAIL);
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void clickThreeAddNewAddInProdDest()throws Exception{
		clickAddNewAddressOnProdDestPageUPS();
		Thread.sleep(6000);
		clickAddNewAddressOnProdDestPageUPS();
		Thread.sleep(6000);
		clickAddNewAddressOnProdDestPageUPS();
		Thread.sleep(6000);
	}
	
	
	
	
	
	
	
	/**
	 * 
	 * @throws Exception
	 */
	public void verifyNCWhiteGoodsFeeInCheckOut()throws Exception{
		String whiteGoodsLabel = driver.findElement(By.xpath("//div[7]/div[2]/div")).getText();
		if(whiteGoodsLabel.equals("NC WHITE GOODS FEE")){
			report.updateTestLog("Clicking Your Account link",
					"whiteGoodsLabel displayed", Status.PASS);
		}
		else{
			report.updateTestLog("Clicking Your Account link",
					"whiteGoodsLabel not displayed", Status.FAIL);
		}
		//whiteGoodsFee
		String whiteGoodsFee = driver.findElement(By.xpath("//div[7]/div[2]/div[5]")).getText();
		if(whiteGoodsFee.equals("$3.00")){
			report.updateTestLog("Clicking Your Account link",
					"whiteGoodsFee displayed", Status.PASS);
		}
		else{
			report.updateTestLog("Clicking Your Account link",
					"whiteGoodsFee not displayed", Status.FAIL);
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void verifySCWhiteGoodsFeeInCheckOut()throws Exception{
		String whiteGoodsLabel = driver.findElement(By.xpath("//div[7]/div[2]/div")).getText();
		if(whiteGoodsLabel.equals("SC WHITE GOODS FEE")){
			report.updateTestLog("Clicking Your Account link",
					"whiteGoodsLabel displayed", Status.PASS);
		}
		else{
			report.updateTestLog("Clicking Your Account link",
					"whiteGoodsLabel not displayed", Status.FAIL);
		}
		//whiteGoodsFee
		String whiteGoodsFee = driver.findElement(By.xpath("//div[7]/div[2]/div[5]")).getText();
		if(whiteGoodsFee.equals("$2.00")){
			report.updateTestLog("Clicking Your Account link",
					"whiteGoodsFee displayed", Status.PASS);
		}
		else{
			report.updateTestLog("Clicking Your Account link",
					"whiteGoodsFee not displayed", Status.FAIL);
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void verifySCWhiteGoodsFeeInReview()throws Exception{
		String whiteGoodsLabel = driver.findElement(By.xpath("//p/acronym")).getText();
		if(whiteGoodsLabel.equals("SC WHITE GOODS FEE")){
			report.updateTestLog("Clicking Your Account link",
					"whiteGoodsLabel displayed", Status.PASS);
		}
		else{
			report.updateTestLog("Clicking Your Account link",
					"whiteGoodsLabel not displayed", Status.FAIL);
		}
		//whiteGoodsFee
		String whiteGoodsFee = driver.findElement(By.xpath("//tr[5]/td[4]")).getText();
		if(whiteGoodsFee.equals("$2.00")){
			report.updateTestLog("Clicking Your Account link",
					"whiteGoodsFee displayed", Status.PASS);
		}
		else{
			report.updateTestLog("Clicking Your Account link",
					"whiteGoodsFee not displayed", Status.FAIL);
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void verifyNCWhiteGoodsFeeInReview()throws Exception{
		String whiteGoodsLabel = driver.findElement(By.xpath("//p/acronym")).getText();
		if(whiteGoodsLabel.equals("NC WHITE GOODS FEE")){
			report.updateTestLog("Clicking Your Account link",
					"whiteGoodsLabel displayed", Status.PASS);
		}
		else{
			report.updateTestLog("Clicking Your Account link",
					"whiteGoodsLabel not displayed", Status.FAIL);
		}
		//whiteGoodsFee
		String whiteGoodsFee = driver.findElement(By.xpath("//tr[5]/td[4]")).getText();
		if(whiteGoodsFee.equals("$3.00")){
			report.updateTestLog("Clicking Your Account link",
					"whiteGoodsFee displayed", Status.PASS);
		}
		else{
			report.updateTestLog("Clicking Your Account link",
					"whiteGoodsFee not displayed", Status.FAIL);
		}
	}
	
	
	/*This function selects delivery method for BOGO item in Cart page*/
	public void selectDeliveryOptionForBogo() throws Exception{
		String varDeliveryOptionBogo = dataTable.getData("General_Data", "BogoDeliveryMethod");
		if(varDeliveryOptionBogo.equals("PL"))
		{
			driver.findElement(By.id(UIMapCheckOut.rdoBtnBOGOSPU)).click();
			Thread.sleep(5000);
			report.updateTestLog("Selecting Delivery Option","Delivery Option Store Pick Up", Status.DONE);
		}
		else if(varDeliveryOptionBogo.equals("LD"))
		{
			driver.findElement(By.id(UIMapCheckOut.rdoBtnBOGOLTD)).click();
			Thread.sleep(5000);
			report.updateTestLog("Selecting Delivery Option","Delivery Option Lowes Truck Delivery", Status.DONE);
		}
		else if(varDeliveryOptionBogo.equals("UPS"))
		{
			driver.findElement(By.id(UIMapCheckOut.rdoBtnBOGOPS)).click();
			Thread.sleep(5000);
			report.updateTestLog("Selecting Delivery Option","Delivery Option Parcel Shipping", Status.DONE);
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void verifyYouSaveDisplayInCartPage() throws Exception
	{
		String SaveElement = driver.findElement(By.xpath(UIMapCheckOut.webElmntYouSave)).getText();
		System.out.println(SaveElement);
		if (SaveElement.equals("You Save ")){
			report.updateTestLog("Verification of You save in Cart page ","You save displayed in Cart page" ,Status.PASS);
		}
		else{
		report.updateTestLog("Verification of You save in Cart page ","You save not displayed in Cart page" ,Status.FAIL);
		}
	 }
	
	/**
	 * 
	 * @throws Exception
	 */
	public void verifyYouSaveDisplayInShippingAddress()throws Exception
	{
		String SaveElement = driver.findElement(By.xpath(UIMapCheckOut.webElmntYouSaveShpAdress)).getText();
		System.out.println(SaveElement);
		if (SaveElement.startsWith("You Saved ")){
			report.updateTestLog("Verification of You save in Shipping Address page ","You save displayed in Shippping Address page" ,Status.PASS);
		}
		else{
		report.updateTestLog("Verification of You save in Shippping Address page ","You save not displayed in Shippping Address page" ,Status.FAIL);
		}	
	}	
	
	/**
	 * 
	 * @throws Exception
	 */
	public void verifyYouSaveDisplayInProdDestination()throws Exception
	{
		String SaveElement = driver.findElement(By.xpath(UIMapCheckOut.webElmntYouSaveShpAdress)).getText();
		System.out.println(SaveElement);
		if (SaveElement.startsWith("You Saved ")){
			report.updateTestLog("Verification of You save in Product destination page ","You save displayed in Product destination page" ,Status.PASS);
		}
		else{
		report.updateTestLog("Verification of You save in Product destination page ","You save not Product destination page" ,Status.FAIL);
		}	
	}	
	/**
	 * 
	 * @throws Exception
	 */
	public void verifyYouSaveDisplayInShippingOptions()throws Exception
	{
		String SaveElement = driver.findElement(By.xpath(UIMapCheckOut.webElmntYouSaveShpAdress)).getText();
		System.out.println(SaveElement);
		if (SaveElement.startsWith("You Saved ")){
			report.updateTestLog("Verification of You save in ShippingOptions page ","You save displayed in Shipping Options page" ,Status.PASS);
		}
		else{
		report.updateTestLog("Verification of You save in ShippingOptions page ","You save not Shipping Options page" ,Status.FAIL);
		}	
	}	
	
	/**
	 * 
	 * @throws Exception
	 */
	public void verifyYouSaveDisplayInReviewPage()throws Exception
	{
		String SaveElement = driver.findElement(By.xpath(UIMapCheckOut.webElmntYouSaveRevAdress)).getText();
		System.out.println(SaveElement);
		if (SaveElement.startsWith("You Saved ")){
			report.updateTestLog("Verification of You save in review page ","You save displayed in Review page" ,Status.PASS);
		}
		else{
		report.updateTestLog("Verification of You save in review page ","You save not review page" ,Status.FAIL);
		}	
	}	
	
	
	/**
	 * 
	 * @throws Exception
	 */
	public void verifyYouSaveDisplayInOrderConf()throws Exception
	{
		String SaveElement = driver.findElement(By.xpath(UIMapCheckOut.webElmntYouSaveconfAdress)).getText();
		System.out.println(SaveElement);
		if (SaveElement.startsWith("You Saved ")){
			report.updateTestLog("Verification of You save in review page ","You save displayed in Review page" ,Status.PASS);
		}
		else{
		report.updateTestLog("Verification of You save in review page ","You save not review page" ,Status.FAIL);
		}	
	}
	
	
	
	
	
	public void searchAndAddIemsToCartWithDlvryMthd() throws Exception {

        

        addMultipleItems();

        selectDlvryMthd();

        try {

        driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();

        }

        catch (Exception WebDriverException) {

              driver.findElement(By.linkText("No, thanks")).click();

              report.updateTestLog("Survey Popup", "Handled", Status.DONE);

              driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();

        }

        Thread.sleep(5000);

        driver.findElement(By.xpath(UIMapMyLowes.btnbutton3)).click();

        Thread.sleep(7000);     

    }
	
	public void addMultipleItems() throws Exception {

        String s = dataTable.getData("General_Data", "ItemNbrs");
            

        String[] str = s.split(","); 
        String item1 = str[0];       
        String item2 = str[1]; 
        String item3 = str[2]; 
        String item4 = str[3]; 
           
       ArrayList<Integer> aList = new ArrayList<Integer>();
  
      aList.add(Integer.parseInt(item1));

      aList.add(Integer.parseInt(item2));

      aList.add(Integer.parseInt(item3));

      aList.add(Integer.parseInt(item4));
                    
      for(int i=0;i<aList.size();i++){
     
       driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(String.valueOf(aList.get(i)));
        try {

               driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);

              }
        catch (Exception WebDriverException) {

                    driver.findElement(By.linkText("No, thanks")).click();

                    report.updateTestLog("Survey Popup", "Handled", Status.DONE);

                    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);

        }                
     
  }
	}


	/**
	 * 
	 */
	public void returnToCartFromPD() throws Exception {
		driver.findElement(By.linkText("Return to Cart")).click();
		Thread.sleep(5000);
	}

	/**
	 * 
	 */
	/**
	 * 
	 */
	public void addAddressInPDLD() throws Exception {

		driver.findElement(By.xpath("//*[@id='LDshipModeId_1']")).click();
		// providecheckOutOrderAsNewUserDetails
		providecheckOutOrderAsNewUserDetails();
		// clickAddNewAddressOnProdDestPage
		clickAddNewAddressOnProdDestPageLD();
	}
	
	/**
	 * 
	 */
	public void addAddressInPDUPS() throws Exception {

		driver.findElement(By.xpath("//*[@id='UPSshipModeId_1']")).click();
		// providecheckOutOrderAsNewUserDetails
		providecheckOutOrderAsNewUserDetails();
		// clickAddNewAddressOnProdDestPage
		clickAddNewAddressOnProdDestPageUPS();
	}
	
	/**
	* 
	* @throws Exception
	*/
	public void checkOutAddress() throws Exception {
	driver.findElement(By.id(UIMapMyLowes.txtAddressName)).clear();
	driver.findElement(By.id(UIMapMyLowes.txtAddressName)).sendKeys(dataTable.getData("General_Data", "AddressNickName"));
	driver.findElement(By.id(UIMapMyLowes.txtFName)).clear();
	driver.findElement(By.id(UIMapMyLowes.txtFName)).sendKeys(dataTable.getData("General_Data", "Firstname"));
	driver.findElement(By.id(UIMapMyLowes.txtLName)).clear();
	driver.findElement(By.id(UIMapMyLowes.txtLName)).sendKeys(dataTable.getData("General_Data", "Lastname"));
	driver.findElement(By.id(UIMapMyLowes.txtAdd1)).clear();
	driver.findElement(By.id(UIMapMyLowes.txtAdd1)).sendKeys(dataTable.getData("General_Data", "Address1"));
	driver.findElement(By.id(UIMapMyLowes.txtAdd2)).clear();
	driver.findElement(By.id(UIMapMyLowes.txtAdd2)).sendKeys(dataTable.getData("General_Data", "Address2"));
	driver.findElement(By.id(UIMapMyLowes.txtCity)).clear();
	driver.findElement(By.id(UIMapMyLowes.txtCity)).sendKeys(dataTable.getData("General_Data", "City"));
	new Select(driver.findElement(By.id(UIMapMyLowes.txtState))).selectByVisibleText(dataTable.getData("General_Data", "State"));
	driver.findElement(By.id(UIMapMyLowes.txtZpCd)).clear();
	driver.findElement(By.id(UIMapMyLowes.txtZpCd)).sendKeys(dataTable.getData("General_Data", "zipcode"));
	selenium.waitForPageToLoad("20000");
	Thread.sleep(6000);
	}
	
	//Kishore
	public void makeEmptyCart() throws Exception
	{
		String varMiniCartCount=driver.findElement(By.id(UIMapCheckOut.webElmntMiniCartCount)).getText();
		int varCount=Integer.valueOf(varMiniCartCount);
		if(varCount>0)
		{
			driver.findElement(By.xpath(UIMapCheckOut.webElmntMiniCart)).click();
			Thread.sleep(2000);
			selenium.waitForPageToLoad("20000");
			int i;
			for(i=0;i<varCount;i++)
			{
					driver.findElement(By.linkText("Remove")).click();
					Thread.sleep(1000);
					selenium.waitForPageToLoad("20000");
			}
					
				if ((driver.findElement(By.xpath(UIMapCheckOut.txtCartEmpty)).getText()
						.contains("Your Shopping Cart Is Empty")) && 
						(driver.findElement(By.xpath(UIMapCheckOut.lblEmptyCartEstTotalValue)).getText().equals("$0.00")))
				{
					report.updateTestLog("Veriyfing the empty cart,Cart is empty",
							"Verification is successful", Status.PASS);
				} 
				else 
				{
					report.updateTestLog("Veriyfing the empty cart,Cart is not empty",
							"Verification is not successful", Status.FAIL);
				}
		
	      }
	}
	//Krishna
	public void checkoutProdDestPage() throws Exception {

		driver.findElement(By.xpath(UIMapMyLowes.btnSecureCheckOut)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}
	
	public void addCreditCardTabLIUser() throws Exception
	{
		driver.findElement(By.id("ccAddTab")).click();
		driver.findElement(By.name(UIMapMyLowes.txtCardNickName)).clear();
		driver.findElement(By.name(UIMapMyLowes.txtCardNickName)).sendKeys(dataTable.getData("General_Data", "nickName"));
		
		
		new Select(driver.findElement(By.id(UIMapMyLowes.drpDownChkOutType))).selectByVisibleText(dataTable.getData("General_Data","cardType"));
		driver.findElement(By.name(UIMapMyLowes.txtCheckOutCreditCardNo)).clear();
		driver.findElement(By.name(UIMapMyLowes.txtCheckOutCreditCardNo)).sendKeys(dataTable.getData("General_Data", "crditCardNo"));
		driver.findElement(By.id(UIMapMyLowes.txtSCode)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtSCode)).sendKeys(dataTable.getData("General_Data", "security code"));
		new Select(driver.findElement(By.id(UIMapMyLowes.txtExpMon))).selectByVisibleText(dataTable.getData("General_Data", "month"));
		new Select(driver.findElement(By.id(UIMapMyLowes.txtExpYear))).selectByVisibleText(dataTable.getData("General_Data", "year"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);	
	}
	public void unZip() throws Exception
	{
		ClickCustomize("xpath",UIMapFunctionalComponents.lnkStoreUnzip);
		selenium.waitForPageToLoad("20000");
		Thread.sleep(1000);
	}
}