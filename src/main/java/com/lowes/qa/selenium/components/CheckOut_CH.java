package com.lowes.qa.selenium.components;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.cognizant.framework.Status;
import com.lowes.qa.selenium.support.ReusableLibrary;
import com.lowes.qa.selenium.support.ScriptHelper;
import com.lowes.qa.selenium.uimap.UIMapCheckOut;
import com.lowes.qa.selenium.uimap.UIMapFunctionalComponents;
import com.lowes.qa.selenium.uimap.UIMapMyLowes;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;


public class CheckOut_CH extends ReusableLibrary{

	String baseurl = dataTable.getData("General_Data", "URL");
	Selenium selenium = new WebDriverBackedSelenium(driver, baseurl);
	CheckOut ch = new CheckOut(scriptHelper);
	FunctionalComponents fc = new FunctionalComponents(scriptHelper); 
	ManageAccount ma = new ManageAccount(scriptHelper);
	ProductSearch ps=new ProductSearch(scriptHelper);
	public CheckOut_CH(ScriptHelper scriptHelper) {
		super(scriptHelper);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void validateConfirmOrderPage()throws Exception{
		
		String confirmMsg = driver.findElement(By.xpath("//*[@id='conf-main']/div[1]")).getText();
		if(confirmMsg.startsWith("Thank you for your order.")){
			report.updateTestLog("Verification of Confirmation page ","Confirmation page displayed" ,Status.PASS);
		}else{
			report.updateTestLog("Verification of Confirmation page ","Confirmation page not displayed" ,Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void reSelectLCCWithPercentageOff()throws Exception{
		ch.checkOutUsingLCCCardWithPercentage();
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void addSecondItemToCart() throws Exception {
		selenium.windowFocus();
		selenium.waitForPageToLoad("15000");
		driver.findElement(By.id("Ntt")).sendKeys(
				dataTable.getData("General_Data", "SecondItemNbr"));//389
		try{
			driver.findElement(By.xpath(UIMapMyLowes.lblSearchItemName))
			.click();
			}
			catch(Exception e){
				driver.findElement(By.linkText("No, thanks")).click();
	            report.updateTestLog("Survey Popup","Handeled", Status.DONE);
	            driver.findElement(By.xpath(UIMapMyLowes.lblSearchItemName))
				.click();
			}
		selenium.waitForPageToLoad("30000");
	    driver.findElement(By.id("LD")).click();
	    selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	    driver.findElement(By.xpath("//li[2]/div/a/span")).click();
	    selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
	    selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void addThirdItemToCart() throws Exception {
		selenium.windowFocus();
		selenium.waitForPageToLoad("15000");
		driver.findElement(By.id("Ntt")).sendKeys(
				dataTable.getData("General_Data", "ThirdItemNbr"));//40958
		try{
			driver.findElement(By.xpath(UIMapMyLowes.lblSearchItemName))
			.click();
			}
			catch(Exception e){
				driver.findElement(By.linkText("No, thanks")).click();
	            report.updateTestLog("Survey Popup","Handeled", Status.DONE);
	            driver.findElement(By.xpath(UIMapMyLowes.lblSearchItemName))
				.click();
			}
		selenium.waitForPageToLoad("30000");
	    driver.findElement(By.id("PL")).click();
	    selenium.waitForPageToLoad("20000");
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//li[2]/div/a/span")).click();
	    selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	    driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
	    selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void addSameItemTwice() throws Exception {
		ch.selectDlvryMthd();
		driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.btnbutton3)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// add same item twice

		driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void addSecondaryAddressForBilling()throws Exception{
		driver.findElement(By.cssSelector("#add_new_address > span")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.id("addressField2")).click();
		Thread.sleep(1000);
		System.out.println("Nick Name in excel:"+dataTable.getData("General_Data", "BillAddressNickName"));
		driver.findElement(By.id("addressField2")).sendKeys(
				dataTable.getData("General_Data", "AddressNickName"));
		/*
		 * driver.findElement(By.xpath("(//input[@id='addressField2'])[2]"))
		 * .sendKeys(dataTable.getData("General_Data", "password"));
		 */
		driver.findElement(By.id("firstName")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("firstName")).sendKeys(
				dataTable.getData("General_Data", "BillFirstname"));
		
		driver.findElement(By.id("lastName")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("lastName")).sendKeys(
				dataTable.getData("General_Data", "BillLastname"));
		
		driver.findElement(By.id("address1")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("address1")).sendKeys(
				dataTable.getData("General_Data", "BillAddress1"));
		
		/*
		 * driver.findElement(By.xpath("(//input[@id='address2'])[2]")).sendKeys(
		 * dataTable.getData("General_Data", "password"));
		 */
		driver.findElement(By.id("city")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("city")).sendKeys(
				dataTable.getData("General_Data", "BillCity"));
		
		new Select(driver.findElement(By.id("state")))
				.selectByVisibleText(dataTable.getData("General_Data", "BillState"));
		
		driver.findElement(By.id("zipCode")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("zipCode")).sendKeys(
				dataTable.getData("General_Data", "Billzipcode"));
		
		driver.findElement(By.name("phone1")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("phone1")).sendKeys(
				dataTable.getData("General_Data", "phone"));
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.btnAddAddress)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(3000);
		if(selenium.isTextPresent("The address name you entered is already in use. Please enter another address name."))
		{
			System.out.println("Duplicate NickName");
			String newNickName=dataTable.getData("General_Data", "AddressNickName").concat("1");
			dataTable.putData("General_Data", "AddressNickName", newNickName);
			System.out.println(newNickName);
			driver.findElement(By.id("addressField2")).clear();
			Thread.sleep(1000);
			driver.findElement(By.id("addressField2")).sendKeys(newNickName);
			
			driver.findElement(By.xpath(UIMapMyLowes.btnAddAddress)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void contextualHelpText()throws Exception{
		driver.findElement(By.xpath(UIMapMyLowes.btnShopCart)).click();
	    selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//checkiIn page Remember Help
		boolean confPage = driver.findElement(By.xpath("//*[@id='Rememberme_Help']/a/img")).isDisplayed();
		if(confPage){
			report.updateTestLog("Verification of You save in review page ","You save displayed in Review page" ,Status.PASS);
		}
		else{
		report.updateTestLog("Verification of You save in review page ","You save not review page" ,Status.FAIL);
		}	
		//for guest User
		try{
		/*** GUEST USER****/
		boolean guestUser=  selenium.isTextPresent("I Don't Have a Lowes.com Account");
		if (guestUser) {
			driver.findElement(By.xpath(UIMapMyLowes.btnGuestUserCheckOut)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		}
		}
		catch(Exception e){
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void continueContextualHelp()throws Exception{
		//prod dest
		contextualHelp();
		driver.findElement(By.xpath(UIMapMyLowes.btnSecureCheckOut)).click();
		selenium.waitForPageToLoad("20000");
		report.updateTestLog("Navigating to Shipping Options Page", "Navigated to Shipping Options Page", Status.DONE);
		Thread.sleep(6000);
		//shipping options
		contextualHelp();
		driver.findElement(By.xpath(UIMapMyLowes.btnSecureCheckOut)).click();
		selenium.waitForPageToLoad("20000");
		report.updateTestLog("Navigating to Review & Pay Page", "Navigated to Review & Pay Page", Status.DONE);
		Thread.sleep(6000);
		//review page
		boolean parcelShipping = driver.findElement(By.xpath("//*[@id='two-column-b']/div[2]/table/tbody/tr[2]/td[1]/a/img")).isDisplayed();
		if(parcelShipping){
			report.updateTestLog("Verification of You save in review page ","You save displayed in Review page" ,Status.PASS);
		}
		else{
		report.updateTestLog("Verification of You save in review page ","You save not review page" ,Status.FAIL);
		}
		
		boolean estimatedTax = driver.findElement(By.xpath("//*[@id='two-column-b']/div[2]/table/tbody/tr[3]/td[1]/a/img")).isDisplayed();
		if(estimatedTax){
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
	public void contextualHelp()throws Exception{
		boolean parcelShipping = driver.findElement(By.xpath("//*[@id='two-column-b']/div[1]/table/tbody/tr[2]/td[1]/a/img")).isDisplayed();
		if(parcelShipping){
			report.updateTestLog("Verification of You save in review page ","You save displayed in Review page" ,Status.PASS);
		}
		else{
		report.updateTestLog("Verification of You save in review page ","You save not review page" ,Status.FAIL);
		}
		
		boolean estimatedTax = driver.findElement(By.xpath("//*[@id='two-column-b']/div[1]/table/tbody/tr[3]/td[1]/a/img")).isDisplayed();
		if(estimatedTax){
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
	public void youSavedHelpText()throws Exception{
		//shippping address
		boolean shipAddPage = driver.findElement(By.xpath("//*[@id='two-column-b']/div[1]/table/tbody/tr[6]/td[1]/a/img")).isDisplayed();
		if(shipAddPage){
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
	public void continueYouSavedHelpText()throws Exception{
		//prodDest
		youSavedHelp();
		driver.findElement(By.xpath(UIMapMyLowes.btnSecureCheckOut)).click();
		selenium.waitForPageToLoad("20000");
		report.updateTestLog("Navigating to Shipping Options Page", "Navigated to Shipping Options Page", Status.DONE);
		Thread.sleep(6000);
		//options page
		youSavedHelp();
		driver.findElement(By.xpath(UIMapMyLowes.btnSecureCheckOut)).click();
		selenium.waitForPageToLoad("20000");
		report.updateTestLog("Navigating to Review & Pay Page", "Navigated to Review & Pay Page", Status.DONE);
		Thread.sleep(6000);
		//review page
		boolean revPage = driver.findElement(By.xpath("//*[@id='two-column-b']/div[2]/table/tbody/tr[5]/td[1]/a/img")).isDisplayed();
		if(revPage){
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
	public void orderConfYouSavedHelpText()throws Exception{
		boolean confPage = driver.findElement(By.xpath("//*[@id='conf-main']/div[2]/div[2]/div[2]/ul/li[6]/div[1]/a/img")).isDisplayed();
		if(confPage){
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
	public void youSavedHelp()throws Exception{
		boolean confPage = driver.findElement(By.xpath("//*[@id='two-column-b']/div[1]/table/tbody/tr[5]/td[1]/a/img")).isDisplayed();
		if(confPage){
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
	public void verifyDateMessageInRevPageSummary() throws Exception{
		String ValMessage = driver.findElement(By.xpath(UIMapCheckOut.webElmntVerifiyMessage)).getText();
		System.out.println(ValMessage);
		if (ValMessage.startsWith("If Ordered Today, Ships to You by ")){
			report.updateTestLog("Verification of delivery message","Message is displayed with delivery date", Status.PASS);
		}else
		{
			report.updateTestLog("Verification of delivery message","Message is not displayed with delivery date", Status.FAIL);			
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void verifyAddressMessageInProdDestPage() throws Exception{
		String addMessage = driver.findElement(By.xpath(UIMapCheckOut.txtErrorForMoreMiles)).getText();
		String availabilityMessage = driver.findElement(By.xpath(UIMapCheckOut.txtErrorForAvailability)).getText();
		String shipToMessage = driver.findElement(By.xpath(UIMapCheckOut.txtErrorForShipToAddress)).getText();
		//error display
		if (addMessage.startsWith("The address you entered is outside your selected store's delivery range. ")){
			report.updateTestLog("Verification of delivery message","Message is displayed ", Status.PASS);
		}else
		{
			report.updateTestLog("Verification of delivery message","Message is not displayed", Status.FAIL);			
		}
		//availability
		if (availabilityMessage.equals("Not Available")){
			report.updateTestLog("Verification of delivery message","Message is displayed ", Status.PASS);
		}else
		{
			report.updateTestLog("Verification of delivery message","Message is not displayed", Status.FAIL);			
		}
		//ship to 
		if (shipToMessage.startsWith("The address you entered is outside of your selected store's delivery range.")){
			report.updateTestLog("Verification of delivery message","Message is displayed ", Status.PASS);
		}else
		{
			report.updateTestLog("Verification of delivery message","Message is not displayed", Status.FAIL);			
		}
	}
	
	
	/**
	 * 
	 * @throws Exception
	 */
	public void addNewAdrsOnProdPageForMoreMiles()throws Exception{
		driver.findElement(By.linkText("Add New Address")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//entering address
		driver.findElement(By.id(UIMapCheckOut.txtAddressName)).clear();
	    driver.findElement(By.id(UIMapCheckOut.txtAddressName)).sendKeys(dataTable.getData("General_Data", "BillAddressNickName"));
	    driver.findElement(By.id(UIMapCheckOut.txtFName)).clear();
	    driver.findElement(By.id(UIMapCheckOut.txtFName)).sendKeys(dataTable.getData("General_Data", "BillFirstname"));
	    driver.findElement(By.id(UIMapCheckOut.txtLName)).clear();
	    driver.findElement(By.id(UIMapCheckOut.txtLName)).sendKeys(dataTable.getData("General_Data", "BillLastname"));
	    driver.findElement(By.id(UIMapCheckOut.txtAdd1)).clear();
	    driver.findElement(By.id(UIMapCheckOut.txtAdd1)).sendKeys(dataTable.getData("General_Data", "BillAddress1"));
	    driver.findElement(By.id(UIMapCheckOut.txtCity)).clear();
	    driver.findElement(By.id(UIMapCheckOut.txtCity)).sendKeys(dataTable.getData("General_Data", "BillCity"));
	    new Select(driver.findElement(By.id(UIMapCheckOut.txtState))).selectByVisibleText(dataTable.getData("General_Data", "BillState"));
	    driver.findElement(By.id(UIMapCheckOut.txtZip)).clear();
	    driver.findElement(By.id(UIMapCheckOut.txtZip)).sendKeys(dataTable.getData("General_Data", "Billzipcode"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		report.updateTestLog("Entering New Prod Destination Address", "New Prod Destination Address Added", Status.DONE);
		driver.findElement(By.xpath(UIMapCheckOut.btnSavePD)).click();
		selenium.waitForPageToLoad("120000");
		Thread.sleep(4000);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void addNewAddressInPD()throws Exception{
		
		ch.selectDlvryMthd();
		//providecheckOutOrderAsNewUserDetails
		ch.providecheckOutOrderAsNewUserDetails();
		//clickAddNewAddressOnProdDestPage
		addNewAdrsOnProdPageForMoreMiles();
	}
	
	
	/*******************************KISHORE*************************/
	
	//searchSelectDMandAddtoCart
	//addItemToCartWithDlvryMthd
	
	
public void provideShippingInformation() throws Exception
{
	driver.findElement(By.id(UIMapCheckOut.addressNickName)).sendKeys(dataTable.getData("General_Data", "AddressNickName"));
	driver.findElement(By.id(UIMapCheckOut.firstName)).sendKeys(dataTable.getData("General_Data", "Firstname"));
	driver.findElement(By.id(UIMapCheckOut.lastName)).sendKeys(dataTable.getData("General_Data", "Lastname"));
	driver.findElement(By.id(UIMapCheckOut.addressLine1)).sendKeys(dataTable.getData("General_Data", "Address1"));
	driver.findElement(By.id(UIMapCheckOut.city)).sendKeys(dataTable.getData("General_Data", "City"));
	new Select(driver.findElement(By.id(UIMapCheckOut.state))).selectByVisibleText(dataTable.getData("General_Data", "State"));
	driver.findElement(By.id(UIMapCheckOut.zipcode)).sendKeys(dataTable.getData("General_Data", "zipcode"));
}
public void checkoutFromShippingInformation() throws Exception
{
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
}
public void validateUIcheckoutPageMasthead() throws Exception
{
	
	//Verifying Sign in link in masthead
	if (driver.findElement(By.xpath("//*[@id='lowes-salutation-default']/a[1]")).isDisplayed())
	{
		report.updateTestLog("Verifying Sign in link in masthead","Sign in Link is displayed", Status.PASS);
	}
	else
	{
		report.updateTestLog("Verifying Sign in link in masthead","Sign in Link is not displayed", Status.FAIL);
	}
	//Verifying Sign up link in masthead
	if (driver.findElement(By.xpath("//*[@id='lowes-salutation-default']/a[2]")).isDisplayed())
	{
		report.updateTestLog("Verifying Sign up link in masthead","Sign up Link is displayed", Status.PASS);
	}
	else
	{
		report.updateTestLog("Verifying Sign up link in masthead","Sign up Link is not displayed", Status.FAIL);
	}
	//Verifying Mini Cart in masthead
	if (driver.findElement(By.xpath("//*[@id='lowes-cart']")).isDisplayed())
	{
		report.updateTestLog("Verifying Mini Cart in masthead","Mini Cart is displayed", Status.PASS);
	}
	else
	{
		report.updateTestLog("Verifying Mini Cart in masthead","Mini Cart is not displayed", Status.FAIL);
	}
}
public void validateUIcheckoutPageTabs() throws Exception
{
	String tabs[] = {"1. Shipping Address","2. Product Destination","3. Shipping Options","4. Review & Pay"};
	for(int i=1;i>=4;i++)
	{
	if(driver.findElement(By.xpath("//*[@id='content-area-no-nav-wider']/div[1]/div/div/div/div["+i+"]")).isDisplayed())
		report.updateTestLog("Verifying"+tabs[i-1]+"tab",tabs[i-1]+"tab is displayed",Status.PASS);
	else
		report.updateTestLog("Verifying"+tabs[i-1]+"tab",tabs[i-1]+"tab is displayed",Status.FAIL);
	}
}
public void validateShippingInfoFrame() throws Exception
{
	// Validating the display of Shipping Information frame	
	String frame1 = driver.findElement(By.xpath("//*[@id='content-area-no-nav-wider']/div[2]/div/div[1]/div/h5")).getText();
	System.out.println(frame1);
	if (frame1.equals("Shipping Information")) {
    	report.updateTestLog("Validating the display of Shipping Information frame ",
    			"Shipping Information frame is displayed", Status.PASS);
    } else {
    	report.updateTestLog("Validating the display of Shipping Information frame",
    			"Shipping Information frame is not displayed", Status.FAIL);
    }
	String text1 = driver.findElement(By.xpath("//*[@id='addressField2']/label")).getText();
	String text2 = driver.findElement(By.xpath("//*[@id='firstName']/label")).getText();
	String text3 = driver.findElement(By.xpath("//*[@id='lastName']/label")).getText();
	String text4 = driver.findElement(By.xpath("//*[@id='address1']/label")).getText();
	String text5 = driver.findElement(By.xpath("//*[@id='city1']/label")).getText();
	String text6 = driver.findElement(By.xpath("//*[@id='state1']/label")).getText();
	String text7 = driver.findElement(By.xpath("//*[@id='zipCode']/label")).getText();
	System.out.println(text1);
	System.out.println(text2);
	System.out.println(text3);
	System.out.println(text4);
	System.out.println(text5);
	System.out.println(text6);
	System.out.println(text7);
	String link1 = driver.findElement(By.xpath("//*[@id='content-area-no-nav-wider']/div[2]/div/div[1]/form/fieldset/div/ul/li[1]/a/span")).getText();
	String buttn1 = driver.findElement(By.xpath("//*[@id='revpay_com_order']/span")).getText();
	
	if (text1.equals("Address Nickname:")) {
    	report.updateTestLog("Validating the display of Address Nickname label ",
    			"Address Nickname label is displayed", Status.PASS);
    } else {
    	report.updateTestLog("Validating the display of Address Nickname label",
    			"Address Nickname label is not displayed", Status.FAIL);
    }
	
	if (text2.equals("First Name:")) {
    	report.updateTestLog("Validating the display of First Name label ",
    			"First Name label is displayed", Status.PASS);
    } else {
    	report.updateTestLog("Validating the display of First Name label",
    			"First Name label is not displayed", Status.FAIL);
    }
	
	if (text3.equals("Last Name:")) {
    	report.updateTestLog("Validating the display of Last Name label ",
    			"Last Name label is displayed", Status.PASS);
    } else {
    	report.updateTestLog("Validating the display of Last Name label",
    			"Last Name label is not displayed", Status.FAIL);
    }
	
	if (text4.equals("Address Line 1:")) {
    	report.updateTestLog("Validating the display of Address Line 1 label ",
    			"Address Line 1 label is displayed", Status.PASS);
    } else {
    	report.updateTestLog("Validating the display of Address Line 1 label",
    			"Address Line 1 label is not displayed", Status.FAIL);
    }
	
	if (text5.equals("City:")) {
    	report.updateTestLog("Validating the display of City label ",
    			"City label is displayed", Status.PASS);
    } else {
    	report.updateTestLog("Validating the display of City label",
    			"City label is not displayed", Status.FAIL);
    }
	
	if (text6.equals("State:")) {
    	report.updateTestLog("Validating the display of State label ",
    			"State label is displayed", Status.PASS);
    } else {
    	report.updateTestLog("Validating the display of State label",
    			"State label is not displayed", Status.FAIL);
    }
	
	if (text7.equals("ZIP Code:")) {
    	report.updateTestLog("Validating the display of ZIP Code label ",
    			"ZIP Code label is displayed", Status.PASS);
    } else {
    	report.updateTestLog("Validating the display of ZIP Code label",
    			"ZIP Code label is not displayed", Status.FAIL);
    }
}
public void validateChooseParcelShippingFrame() throws Exception
{
	//Verifying Choose Parcel Shipping Frame
	if(driver.findElement(By.xpath("//*[@id='content-area-no-nav-wider']/div[2]/div/div")).isDisplayed())
	{
		if(driver.findElement(By.xpath("//*[@id='billing-address-edit']/fieldset/ol/li")).isDisplayed())
		{
			report.updateTestLog("Verifying Product: Section in Choose Parcel Shipping Destination frame","Product: Section in Choose Parcel Shipping Destination frame is displayed",Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying Product: Section in Choose Parcel Shipping Destination frame","Product: Section in Choose Parcel Shipping Destination frame is not displayed",Status.FAIL);
		}
		
		if(driver.findElement(By.xpath("//*[@id='display-ship-address-dropdown-PD']/li[1]")).isDisplayed())
		{
			report.updateTestLog("Verifying Ship To: Section in Choose Parcel Shipping Destination frame","Ship To: Section in Choose Parcel Shipping Destination frame is displayed",Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying Ship To: Section in Choose Parcel Shipping Destination frame","Ship To: Section in Choose Parcel Shipping Destination frame is not displayed",Status.FAIL);
		}
		
		if(driver.findElement(By.xpath("//*[@id='js-add-address-1']")).isDisplayed())
		{
			report.updateTestLog("Verifying 'Add New Address' Section in Choose Parcel Shipping Destination frame","'Add New Address' Section in Choose Parcel Shipping Destination frame is displayed",Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying 'Add New Address' Section in Choose Parcel Shipping Destination frame","'Add New Address' Section in Choose Parcel Shipping Destination frame is not displayed",Status.FAIL);
		}
		
		if(driver.findElement(By.xpath("//*[@id='display-ship-address-dropdown-PD']/li[3]")).isDisplayed())
		{
			report.updateTestLog("Verifying Ship From: Section in Choose Parcel Shipping Destination frame","Ship From: Section in Choose Parcel Shipping Destination frame is displayed",Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying Ship From: Section in Choose Parcel Shipping Destination frame","Ship From: Section in Choose Parcel Shipping Destination frame is not displayed",Status.FAIL);
		}
		
		if(driver.findElement(By.xpath("//*[@id='Sec_chkout_canc']/span")).isDisplayed())
		{
			report.updateTestLog("Verifying Cancel Button in Choose Parcel Shipping Destination frame","Cancel Button in Choose Parcel Shipping Destination frame is displayed",Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying Cancel Button in Choose Parcel Shipping Destination frame","Cancel Button in Choose Parcel Shipping Destination frame is not displayed",Status.FAIL);
		}
		
		if(driver.findElement(By.xpath("//*[@id='Sec_chkout_prev']/span")).isDisplayed())
		{
			report.updateTestLog("Verifying Previous Button in Choose Parcel Shipping Destination frame","Previous Button in Choose Parcel Shipping Destination frame is displayed",Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying Previous Button in Choose Parcel Shipping Destination frame","Previous Button in Choose Parcel Shipping Destination frame is not displayed",Status.FAIL);
		}
		
		if(driver.findElement(By.xpath("//*[@id='revpay_com_order']/span")).isDisplayed())
		{
			report.updateTestLog("Verifying Continue Checkout Button in Choose Parcel Shipping Destination frame","Continue Checkout Button in Choose Parcel Shipping Destination frame is displayed",Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying Continue Checkout Button in Choose Parcel Shipping Destination frame","Continue Checkout Button in Choose Parcel Shipping Destination frame is not displayed",Status.FAIL);
		}
	}
	else
	{
		report.updateTestLog("Verifying Choose Parcel Shipping Frame","Choose Parcel Shipping Frame is not displayed",Status.FAIL);
	}
	}
public void shippingAddressPageValidations()throws Exception{
	
	validateUIcheckoutPageMasthead();
	//Validating the display of Shipping address page.
		if(driver.getTitle().contains("Lowe's: Secure Checkout - Shipping Address"))
		{
			report.updateTestLog("Validating the display of Shipping address page", 
					"Shipping address page is displayed",
					Status.PASS);
		} else {
			report.updateTestLog("Validating the display of Shipping address page", 
					"Shipping address page is not displayed",
					Status.FAIL);
		}
	// Validating the display of "Secure Checkout" text near Lock icon	
		String name = driver.findElement(By.xpath("//div[@id='content-area-no-nav-wider']/div/div/h1")).getText();
		if (name.equals("Secure Checkout")) {
	    	report.updateTestLog("Validating text beside 'LOCK' image",
	    			"Secure Checkout text is displayed", Status.PASS);
	    } else {
	    	report.updateTestLog("Validating text beside 'LOCK' image",
	    			"Secure Checkout text is not displayed", Status.FAIL);
	    }
		validateShippingInfoFrame();
		validateBillingSummary();
		verifyEasyReturnsAndSafeSecureLinks();
		validateFooterSection();
		clickCancelFromCheckOutPage();
		provideShippingInformation();
		checkoutFromShippingInformation();
		if(driver.getTitle().contains("Lowe's: Secure Checkout - Product Destination"))
		{
			report.updateTestLog("Validating the display of Product Destination page", 
					"Product Destination page is displayed",
					Status.PASS);
		} else {
			report.updateTestLog("Validating the display of Product Destination page", 
					"Product Destination page is not displayed",
					Status.FAIL);
		}
	}
    public void clickPreviousButtonFromSOP() throws Exception
    {
    	ClickCustomize("xpath",UIMapCheckOut.btnPrevious);
    	selenium.waitForPageToLoad("20000");
		Thread.sleep(5000);
    	if(driver.getTitle().contains("Lowe's: Secure Checkout - Product Destination"))
		{
			report.updateTestLog("Validating the display of Product Destination page", 
					"Product Destination page is displayed",
					Status.PASS);
		} else {
			report.updateTestLog("Validating the display of Product Destination page", 
					"Product Destination page is not displayed",
					Status.FAIL);
		}	
    }
    public void clickPreviousButtonFromPD() throws Exception
    {
    	ClickCustomize("id","Sec_chkout_prev");
    	selenium.waitForPageToLoad("20000");
		Thread.sleep(5000);
		if(driver.getTitle().contains("Lowe's: Shopping Cart"))
		{
			report.updateTestLog("Click functionality of Previous link", 
					"Shopping Cart page is displayed",
					Status.PASS);
		} else {
			report.updateTestLog("Click functionality of Previous link", 
					"Appropriate page is not displayed",
					Status.FAIL);
		}
		ch.providecheckOutOrderAsNewUserDetails();
    }
    public void validateConfirmPSoptionsFrame() throws Exception
    {
    	if(driver.findElement(By.xpath(UIMapCheckOut.frameConfirmParcelOptions)).isDisplayed())
    	{
    		boolean v1,v2,v3,v4,v5,v6;
    		v1= driver.findElement(By.xpath("//li/label")).isDisplayed();
    		v2= driver.findElement(By.xpath("//li/div/p")).isDisplayed();
    		v3= driver.findElement(By.xpath("//li[2]/label")).isDisplayed();
    		v4= driver.findElement(By.xpath("//select")).isDisplayed();
    		v5= driver.findElement(By.xpath("//li[3]/label")).isDisplayed();
    		v6= driver.findElement(By.xpath("//li[3]/div/p")).isDisplayed();
    		if(!v1)
    			report.updateTestLog("Verifying Product label", "Product label is not displayed",Status.FAIL);
    		if(!v2)
    			report.updateTestLog("Verifying Product Description", "Product Description is not displayed",Status.FAIL);
    		if(!v3)
    			report.updateTestLog("Verifying Service Level label", "Service Level label is not displayed",Status.FAIL);
    		if(!v4)
    			report.updateTestLog("Verifying Service Level Dropdown", "Service Level Dropdown is not displayed",Status.FAIL);
    		if(!v5)
    			report.updateTestLog("Verifying Ship To label", "Ship To label is not displayed",Status.FAIL);
    		if(!v6)
    			report.updateTestLog("Verifying Ship To Address", "Ship To Address is not displayed",Status.FAIL);
    	}
    	else
    		report.updateTestLog("Verifying Confirm Your Parcel Shipping Options frame","Confirm Your Parcel Shipping Options frame is not displayed",Status.FAIL);
    	
    }
    public void validateAddNewAddressSection() throws Exception
    {
    	if(driver.findElement(By.xpath(UIMapCheckOut.lnkAddNewAddress)).isDisplayed())

    	{

    	report.updateTestLog("Verifying Add New Address link", "Add New Address is displayed",Status.PASS);

    	ClickCustomize("xpath",UIMapCheckOut.lnkAddNewAddress);

    	Thread.sleep(8000);

    	String elements[] = {"Address Nickname:","First Name:","Last Name:","Company Name:","Address Line 1:","Address Line 2:","City:","State:","ZIP Code:"};

    	for(int i=1;i<=9;i++)

    	{

    	if(driver.findElement(By.xpath("//span[2]/li["+i+"]")).isDisplayed())

    	report.updateTestLog("Verifying"+elements[i-1]+"field",elements[i-1]+"field is displayed along with text box",Status.PASS);

    	else

    	report.updateTestLog("Verifying"+elements[i-1]+"field",elements[i-1]+"field is not displayed",Status.FAIL);

    	}

    	driver.findElement(By.id("address-name-PD")).sendKeys(dataTable.getData("General_Data", "BillAddressNickName"));

    	driver.findElement(By.id("fname-PD")).sendKeys(dataTable.getData("General_Data", "BillFirstname"));

    	driver.findElement(By.id("lname-PD")).sendKeys(dataTable.getData("General_Data", "BillLastname"));

    	driver.findElement(By.id("address-1-PD")).sendKeys(dataTable.getData("General_Data", "Address1"));

    	driver.findElement(By.id("city-PD")).sendKeys(dataTable.getData("General_Data", "City"));

    	new Select(driver.findElement(By.id("state-PD"))).selectByVisibleText(dataTable.getData("General_Data", "State"));

    	driver.findElement(By.id("zip-PD")).sendKeys(dataTable.getData("General_Data", "zipcode"));

    	Thread.sleep(1000);

    	driver.findElement(By.linkText("Save")).click();

    	selenium.waitForPageToLoad("20000");

    	Thread.sleep(5000);

    	String varShipAdd=dataTable.getData("General_Data", "BillAddressNickName")+" - "+dataTable.getData("General_Data", "BillFirstname")+" "+dataTable.getData("General_Data", "BillLastname");

    	System.out.println(varShipAdd);

    	int varOptionCount=ps.countWebElement(UIMapCheckOut.drpDownAddressValues);

    	System.out.println(varOptionCount);

    	int i=0;

    	for(i=1;i<=varOptionCount;i++)

    	{

    	String varAddrss=driver.findElement(By.xpath(UIMapCheckOut.drpDownAddressValues+"["+i+"]")).getText();

    	System.out.println("Option value:"+i+" "+varAddrss);

    	System.out.println("Option value:"+i+" "+varShipAdd);

    	if(varAddrss.trim().equals(varShipAdd.trim()))

    	{

    	String s = driver.findElement(By.xpath(UIMapCheckOut.drpDownAddressValues+"["+i+"]")).getAttribute("selected");

    	System.out.println("Selected"+s);

    	if(s.equals("true"))

    	report.updateTestLog("Checking Added Address", "Added Address displayed in Drop-down for selection", Status.PASS);

    	else

    	report.updateTestLog("Checking Added Address", "Added Address not displayed in Drop-down for selection", Status.FAIL);

    	break;

    	}

    	else

    	continue;

    	}

    	//verifying Undo link

    	ClickCustomize("xpath",UIMapCheckOut.lnkAddNewAddress);

    	Thread.sleep(8000);

    	driver.findElement(By.id("address-name-PD")).sendKeys(dataTable.getData("General_Data", "AddressNickName"));

    	driver.findElement(By.id("fname-PD")).sendKeys(dataTable.getData("General_Data", "Firstname"));

    	driver.findElement(By.id("lname-PD")).sendKeys(dataTable.getData("General_Data", "Lastname"));

    	driver.findElement(By.id("address-1-PD")).sendKeys(dataTable.getData("General_Data", "Address1"));

    	driver.findElement(By.id("city-PD")).sendKeys(dataTable.getData("General_Data", "City"));

    	new Select(driver.findElement(By.id("state-PD"))).selectByVisibleText(dataTable.getData("General_Data", "State"));

    	driver.findElement(By.id("zip-PD")).sendKeys(dataTable.getData("General_Data", "zipcode"));

    	ClickCustomize("xpath","//*[@id='buttons-li-PD']/div[2]/a[2]");

    	if(driver.findElement(By.xpath(UIMapCheckOut.lnkAddNewAddress)).isDisplayed())

    	report.updateTestLog("Verifying Undo link", "Undo link is correctly working",Status.PASS);

    	else

    	report.updateTestLog("Verifying Undo link", "Undo link is not working properly",Status.FAIL);

    	}

    	else

    	report.updateTestLog("Verifying Add New Address link", "Add New Address is not displayed",Status.FAIL);  
    	}
    public void verifySignInSignUpLinks() throws Exception
    {
    	driver.findElement(By.xpath("//*[@id='lowes-salutation-default']/a[2]")).click();

    	if(driver.getTitle().contains("Lowe's: Registration"))

    	{

    	report.updateTestLog("Validating the display of Sign Up page",

    	"Sign Up page is displayed",

    	Status.PASS);

    	} else {

    	report.updateTestLog("Validating the display of Sign Up page",

    	"Sign Up page is not displayed",

    	Status.FAIL);

    	}

    	//Navigate back to previous page

    	driver.navigate().back();

    	selenium.waitForPageToLoad("20000");

    	Thread.sleep(6000);

    	driver.findElement(By.xpath(UIMapFunctionalComponents.lnkSignIn)).click();

    	selenium.windowFocus();

    	selenium.waitForPageToLoad("120000");

    	boolean verPopUpBoxPresent=selenium.isElementPresent(UIMapFunctionalComponents.webElmntLoginPopup);

    	if(verPopUpBoxPresent)

    	{

    	report.updateTestLog("Verifying Signin PopUp Window","Popup is displayed",Status.PASS);

    	//ClickCustomize("xpath","//*[@id='checkout-page']/div[11]/div[1]/a/span");

    	driver.navigate().refresh();

    	selenium.waitForPageToLoad("20000");

    	}

    	else

    	report.updateTestLog("Verifying Signin PopUp Window","Popup is displayed",Status.FAIL); }
    public void validateBillingSummary() throws Exception
	{
		String frame2 = driver.findElement(By.xpath("//*[@id='two-column-b']/div[1]/div[1]/h5")).getText();
		System.out.println(frame2);
		if (frame2.equals("Billing Summary")) {
	    	report.updateTestLog("Validating the display of Billing Summary frame ",
	    			"Billing Summary frame is displayed", Status.PASS);
	    } else {
	    	report.updateTestLog("Validating the display of Billing Summary frame",
	    			"Billing Summary frame is not displayed", Status.FAIL);
	    }	
		
	if (driver.findElement(By.xpath("//*[@id='two-column-b']/div[1]")).isDisplayed())
	{
		if(driver.findElement(By.xpath("//*[@id='two-column-b']/div[1]/table/tbody/tr[1]/td[1]/strong")).isDisplayed())
		{
			report.updateTestLog("Verifying Subtotal in Billing Summary Section","Subtotal is displayed in Billing Summary",Status.PASS);	
		}
		else
		{
			report.updateTestLog("Verifying Subtotal in Billing Summary Section","Subtotal is not displayed in Billing Summary",Status.FAIL);
		}
		
		if(driver.findElement(By.xpath("//*[@id='two-column-b']/div[1]/table/tbody/tr[2]/td[1]")).isDisplayed())
		{
			report.updateTestLog("Verifying Estimated Parcel Shipping in Billing Summary Section","Estimated Parcel Shipping is displayed in Billing Summary",Status.PASS);	
		}
		else
		{
			report.updateTestLog("Verifying Estimated Parcel Shipping in Billing Summary Section","Estimated Parcel Shipping is not displayed in Billing Summary",Status.FAIL);
		}
		
		if(driver.findElement(By.xpath("//*[@id='two-column-b']/div[1]/table/tbody/tr[3]/td[1]")).isDisplayed())
		{
			report.updateTestLog("Verifying Estimated Tax in Billing Summary Section","Estimated Tax is displayed in Billing Summary",Status.PASS);	
		}
		else
		{
			report.updateTestLog("Verifying Estimated Tax in Billing Summary Section","Estimated Tax is not displayed in Billing Summary",Status.FAIL);
		}
		
		if(driver.findElement(By.xpath("//*[@id='two-column-b']/div[1]/table/tbody/tr[4]/td[1]")).isDisplayed())
		{
			report.updateTestLog("Verifying Balance Due in Billing Summary Section","Balance Due is displayed in Billing Summary",Status.PASS);	
		}
		else
		{
			report.updateTestLog("Verifying Balance Due in Billing Summary Section","Balance Due is not displayed in Billing Summary",Status.FAIL);
		}
		
		if(driver.findElement(By.xpath("//*[@id='two-column-b']/div[1]/table/tbody/tr[2]/td[1]/a/img")).isDisplayed() &&
				driver.findElement(By.xpath("//*[@id='two-column-b']/div[1]/table/tbody/tr[3]/td[1]/a/img")).isDisplayed())
		{
			report.updateTestLog("Verifying Contextual Help icons in Billing Summary Section","Contextual Help icons is displayed in Billing Summary",Status.PASS);	
		}
		else
		{
			report.updateTestLog("Verifying Contextual Help icons in Billing Summary Section","Contextual Help icons is not displayed in Billing Summary",Status.FAIL);
		}
		
	}
	else
	{
		report.updateTestLog("Verifying Billing Summary Section","Billing Summary Section is not displayed",Status.FAIL);
	}
	}
	public void enterInvalidCrditCardDetails() throws Exception
	{
		Thread.sleep(4000);
		if(selenium.isTextPresent("-9") ||  selenium.isTextPresent("-102") || selenium.isTextPresent("-304"))
		{
			report.updateTestLog("Verifying Invalid Credit Card details", "-9 error code is displayed",Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying Invalid Credit Card details", "-9 error code is not displayed",Status.FAIL);
		}
	}
	public void validateOCpage()
	{
		String getOrderConfirmationPgTitle=selenium.getTitle();
		System.out.println("Order Confirmation Page Title is :"+getOrderConfirmationPgTitle);
		if(getOrderConfirmationPgTitle.contains("Order"))
		{
			report.updateTestLog("Verifying Order Confirmation Page", "Order Confirmation Page displayed Successfully", Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying Order Confirmation Page", "Order Confirmation Page is not displayed Successfully", Status.FAIL);
		}
	}
	public void handleImpulseBuyPopover() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.btnShopCart)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(UIMapCheckOut.impulseBuyNoThankslink)).click();
	    selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//for guest User
		
		/*** GUEST USER****/
		try{
		boolean guestUser=  selenium.isTextPresent("I Don't Have a Lowes.com Account");
		if (guestUser) {
			driver.findElement(By.xpath(UIMapMyLowes.btnGuestUserCheckOut)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(3000);
		}
		}
		catch(Exception e){}
	}
	public void checkoutFromProductDestination() throws Exception
	{
		driver.findElement(By.xpath("//*[@id='revpay_com_order']/span")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(3000);
	}
	
	public void validateFREEshippinginCart() throws Exception
	{
	   String var1 = driver.findElement(By.xpath("//*[@id='ShopCartForm']/div[5]/div[2]/div[1]/ul/li[2]/div[1]")).getText();
	   String var2 = driver.findElement(By.xpath("//*[@id='ShopCartForm']/div[5]/div[2]/div[1]/ul/li[2]/div[2]/span")).getText();
	   if (var1.equals("Parcel Shipping") && var2.equals("FREE"))
	   {
		   report.updateTestLog("Verifying FREE Shipping in Cart Page","FREE Shipping promotion is displayed in Cart",Status.PASS);
	   }
	   else
	   {
		   report.updateTestLog("Verifying FREE Shipping in Cart Page","FREE Shipping promotion is not displayed in Cart",Status.FAIL);
	   }
	}
	public void validateFREEshippinginShippingInformation() throws Exception
	{
		String var1 = driver.findElement(By.xpath("//*[@id='two-column-b']/div[1]/table/tbody/tr[2]/td[1]")).getText();
		String var2 = driver.findElement(By.xpath("//*[@id='two-column-b']/div[1]/table/tbody/tr[2]/td[2]/span")).getText();
		   if (var1.equals("Parcel Shipping") && var2.equals("FREE"))
		   {
			   report.updateTestLog("Verifying FREE Shipping in Cart Page","FREE Shipping promotion is displayed in Cart",Status.PASS);
		   }
		   else
		   {
			   report.updateTestLog("Verifying FREE Shipping in Cart Page","FREE Shipping promotion is not displayed in Cart",Status.FAIL);
		   }
	}

	public void validateFREEshippinginProductDestination() throws Exception
	{
		String var1 = driver.findElement(By.xpath("//*[@id='two-column-b']/div[1]/table/tbody/tr[2]/td[1]")).getText();
		String var2 = driver.findElement(By.xpath("//*[@id='two-column-b']/div[1]/table/tbody/tr[2]/td[2]/span")).getText();
		   if (var1.equals("Parcel Shipping") && var2.equals("FREE"))
		   {
			   report.updateTestLog("Verifying FREE Shipping in Cart Page","FREE Shipping promotion is displayed in Cart",Status.PASS);
		   }
		   else
		   {
			   report.updateTestLog("Verifying FREE Shipping in Cart Page","FREE Shipping promotion is not displayed in Cart",Status.FAIL);
		   }
	}
	public void validateFREEshippinginReviewAndPay() throws Exception
	{
		String var1 = driver.findElement(By.xpath("//*[@id='two-column-b']/div[2]/table/tbody/tr[2]/td[1]")).getText();
		String var2 = driver.findElement(By.xpath("//*[@id='two-column-b']/div[2]/table/tbody/tr[2]/td[2]/span")).getText();
		   if (var1.equals("Parcel Shipping") && var2.equals("FREE"))
		   {
			   report.updateTestLog("Verifying FREE Shipping in Cart Page","FREE Shipping promotion is displayed in Cart",Status.PASS);
		   }
		   else
		   {
			   report.updateTestLog("Verifying FREE Shipping in Cart Page","FREE Shipping promotion is not displayed in Cart",Status.FAIL);
		   }
	}
	public void validateFREEshippinginOrderConfirmation() throws Exception
	{
		String var1 = driver.findElement(By.xpath("//*[@id='conf-main']/div[2]/div[2]/div[2]/ul/li[2]/div[1]")).getText();
		String var2 = driver.findElement(By.xpath("//*[@id='conf-main']/div[2]/div[2]/div[2]/ul/li[2]/div[2]")).getText();
		   if (var1.equals("Parcel Shipping") && var2.equals("FREE"))
		   {
			   report.updateTestLog("Verifying FREE Shipping in Cart Page","FREE Shipping promotion is displayed in Cart",Status.PASS);
		   }
		   else
		   {
			   report.updateTestLog("Verifying FREE Shipping in Cart Page","FREE Shipping promotion is not displayed in Cart",Status.FAIL);
		   }
	}
	public void validateOrderConfirmationUI() throws Exception
	{
		
	}
	public void clickCancelFromCheckOutPage() throws Exception
	{
		try{
		driver.findElement(By.xpath("//*[@id='Sec_chkout_canc']/span")).click();
		}
		catch(Exception e){}
		try{
			driver.findElement(By.xpath("//*[@id='content-area-no-nav-wider']/div[2]/div/div[1]/form/fieldset/div/ul/li[1]/a/span")).click();
			}
			catch(Exception e){}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		if(driver.getTitle().contains("Lowe's: Shopping Cart"))
		{
			report.updateTestLog("Click functionality of Cancel link", 
					"Shopping Cart page is displayed",
					Status.PASS);
		} else {
			report.updateTestLog("Click functionality of Cancel link", 
					"Appropriate page is not displayed",
					Status.FAIL);
		}
		ch.providecheckOutOrderAsNewUserDetails();
	}
	public void validateFooterSection() throws Exception
	{
		int varCount3=ps.countWebElement("//body[@id='checkout-page']/div");
		System.out.println(varCount3);
		boolean footer1 = selenium.isElementPresent("//*[@id='footer-safe-shop']");
		if (footer1)
			report.updateTestLog("Verifying Lowes Safe Shop Pledge link", "Lowes Safe Shop Pledge link is displayed",Status.PASS);
		else
			report.updateTestLog("Verifying Lowes Safe Shop Pledge link", "Lowes Safe Shop Pledge link is not displayed",Status.FAIL);
		boolean footer2 = selenium.isElementPresent("//*[@id='footer-toc']");
		if (footer2) {
			driver.findElement(By.xpath("//*[@id='footer-toc']")).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			if(driver.getTitle().contains("Terms and Conditions of Use"))
			{
				report.updateTestLog("Click functionality of Terms and Conditions of Use link", 
						"Appropriate page is displayed",
						Status.PASS);
			} else {
				report.updateTestLog("Click functionality of Terms and Conditions of Use link", 
						"Appropriate page is not displayed",
						Status.FAIL);
			}
		} 
		else {
		    report.updateTestLog("Validating the display of Terms and Conditions of Use link in footer",
		    			"The link is not displayed", Status.FAIL);
		    }
		
		//Navigate back to previous page
		driver.navigate().back();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		
		boolean footer3 = selenium.isElementPresent("//*[@id='footer-privacy']");
		if (footer3) {
			driver.findElement(By.xpath("//*[@id='footer-privacy']")).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			if(driver.getTitle().contains("Privacy and Security Statement"))
			{
				report.updateTestLog("Click functionality of Privacy Statement link", 
						"Appropriate page is displayed",
						Status.PASS);
			} else {
				report.updateTestLog("Click functionality of Privacy Statement link", 
						"Appropriate page is not displayed",
						Status.FAIL);
			}
		} 
		else {
		    report.updateTestLog("Validating the display of Privacy Statement link in footer",
		    			"The link is not displayed", Status.FAIL);
		    }
		
		//Navigate back to previous page
		driver.navigate().back();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		
		boolean footer4 = selenium.isElementPresent("//*[@id='footer-california']");
		if (footer4) {
			driver.findElement(By.xpath("//*[@id='footer-california']")).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			if((driver.getTitle().contains("Privacy and Security Statement")) && (selenium.isTextPresent("Notice to California Customers")))
			{
				report.updateTestLog("Click functionality of Your California Privacy Rights", 
						"Appropriate page is displayed",
						Status.PASS);
			} else {
				report.updateTestLog("Click functionality of Your California Privacy Rights", 
						"Appropriate page is not displayed",
						Status.FAIL);
			}
		} 
		else {
		    report.updateTestLog("Validating the display of Your California Privacy Rights link in footer",
		    			"The link is not displayed", Status.FAIL);
		    }
		//Navigate back to previous page
		driver.navigate().back();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		
		//validate the display of footer text
		boolean footer = selenium.isTextPresent("© 2014 Lowe's. All rights reserved. Lowe's and the gable design are registered trademarks of LF, LLC.");
		if (footer)
		{
			report.updateTestLog("Footer text", "is displayed",	Status.PASS);
		}
		else
		{
			report.updateTestLog("Footer text", "is not displayed",	Status.FAIL);
		}
		
	}
	public void validateSuccessMessage() throws Exception
	{
		if(!(selenium.isTextPresent("Thank you for your order.")))
		{
			report.updateTestLog("Verifying Order Success Message","Order Success Message not displayed",Status.FAIL);
		}
	}
	public void validateProductDetailInOC() throws Exception
	{
		boolean var1,var2,var3,var4,var5,var6,var7,var8;
		var1=driver.findElement(By.xpath("//div/div/img")).isDisplayed();
		var2=driver.findElement(By.xpath("//div[2]/div[2]/div/div/a")).isDisplayed();
		var3=driver.findElement(By.xpath("//div[2]/div[2]/div/div[2]")).isDisplayed();
		var4=driver.findElement(By.xpath("//div[2]/div/div[3]")).isDisplayed();
		var5=driver.findElement(By.xpath("//div[2]/div/div[4]")).isDisplayed();
		var6=driver.findElement(By.xpath("//div[2]/div[2]/div[2]/div/div[2]")).isDisplayed();
		var7=driver.findElement(By.xpath("//div[2]/div[2]/div[2]/div/div[3]")).isDisplayed();
		var8=driver.findElement(By.xpath("//div[2]/div[2]/div[2]/div/div[4]")).isDisplayed();
		if(!(var1 && var2 && var3 && var4 && var5 && var6 && var7 && var8))
		{
			report.updateTestLog("Verifying Product Detail Section in OC Page","Product Detail Section in OC Page is not displayed correctly",Status.FAIL);
		}
	}
	public void validateProductDisplayInOC() throws Exception
	{
		boolean var1,var2,var3,var4,var5; 
		var1=driver.findElement(By.xpath("//h5/span[2]")).isDisplayed();
		var2=driver.findElement(By.xpath("//h5/span[3]")).isDisplayed();
		var3=driver.findElement(By.xpath("//*[@id='conf-main']/div[3]/div[2]/div[1]/p[1]")).isDisplayed();
		var4=driver.findElement(By.xpath("//p[2]/strong")).isDisplayed();
		var5=driver.findElement(By.xpath("//p[4]")).isDisplayed();
		if(!(var1 && var2 && var3 && var4 && var5))
		{
			report.updateTestLog("Verifying Product Display Section in OC Page","Product Display Section in OC Page is not displayed correctly",Status.FAIL);
		}
	}
	public void validateSignUpAndNeedHelpInOC() throws Exception
	{
		boolean var1,var2,var3;
		var1=driver.findElement(By.xpath("//div[5]/div/div[3]/div")).isDisplayed();
		var2=driver.findElement(By.xpath("//li/p/strong")).isDisplayed();
		var3=driver.findElement(By.xpath("//div[3]/div[2]/div[2]/ul/li[2]/a")).isDisplayed();
		if(!(var1 && var2 && var3))
		{
			report.updateTestLog("Verifying SignUpAndNeedHelp OC Page","SignUpAndNeedHelp in OC Page is not displayed correctly",Status.FAIL);
		}
	}
	public void validateOrderDetailsInOC() throws Exception
	{
		boolean Var1,Var2,Var3,Var4,Var5,Var6,Var7,Var8,Var9,Var10,Var11,Var12,Var13,Var14,Var15,Var16;
		Var1=driver.findElement(By.xpath("//strong")).isDisplayed();
		Var2=driver.findElement(By.xpath("//strong[2]")).isDisplayed();
		Var3=driver.findElement(By.xpath("//div[2]/div/strong")).isDisplayed();
		Var4=driver.findElement(By.xpath("//div[2]/div/strong[2]")).isDisplayed();
		Var5=driver.findElement(By.xpath("//div[2]/strong")).isDisplayed();
		Var6=driver.findElement(By.xpath("//div[2]/div[2]/div[2]/ul/li/div")).isDisplayed();
		Var7=driver.findElement(By.xpath("//div[2]/ul/li[2]/div")).isDisplayed();
		Var8=driver.findElement(By.xpath("//div[2]/ul/li[3]/div")).isDisplayed();
		Var9=driver.findElement(By.xpath("//div[2]/div[2]/div[2]/ul/li[4]/div")).isDisplayed();
		Var10=driver.findElement(By.xpath("//div[2]/ul/li[5]/div")).isDisplayed();
		Var11=driver.findElement(By.xpath("//div[2]/ul/li/div[2]")).isDisplayed();
		Var12=driver.findElement(By.xpath("//li[2]/div[2]")).isDisplayed();
		Var13=driver.findElement(By.xpath("//li[3]/div[2]")).isDisplayed();
		Var14=driver.findElement(By.xpath("//li[4]/div[2]")).isDisplayed();
		Var15=driver.findElement(By.xpath("//li[5]/div[2]")).isDisplayed();
		Var16=driver.findElement(By.xpath("//li[3]/div/a/img")).isDisplayed();
		
		if(!(Var1&&Var2&&Var3&&Var4&&Var5&&Var6&&Var7&&Var8&&Var9&&Var10&&Var11&&Var12&&Var13&&Var14&&Var15&&Var16))
		{
			report.updateTestLog("Verifying Order Details OC Page","Order Details in OC Page is not displayed correctly",Status.FAIL);
		}

	}
	public void validateMastheadinOC() throws Exception
	{
		boolean var1,var2,var3,var4,var5,var6; 
		String s;
		var1=driver.findElement(By.xpath("//a")).isDisplayed();
		var2=driver.findElement(By.xpath("//a[2]")).isDisplayed();
		var3=driver.findElement(By.xpath("//span[2]")).isDisplayed();
		var4=driver.findElement(By.xpath("//div/ul/li[5]")).isDisplayed();
		var5=driver.findElement(By.xpath("//div/ul/li[6]")).isDisplayed();
		var6=driver.findElement(By.xpath("//li[6]/a/span[2]")).isDisplayed();
        s=driver.findElement(By.xpath("//li[6]/a/span[2]")).getText();
        if(!(var1 && var2 && var3 && var4 && var5 && var6))
		{
			report.updateTestLog("Verifying Masthead in OC Page","Masthead Section in OC Page is not displayed correctly",Status.FAIL);
		}
        if(!(s.equals("0")))
        {
        	report.updateTestLog("Verifying Quantity in Masthead","Quantity in Masthead is not Zero",Status.FAIL);
        }
	}

	public void validationErrorMessageWrongPin() throws Exception
	{
		String Message = driver.findElement(By.xpath(UIMapCheckOut.WebElmtErrorMsgWrongPin)).getText();
		System.out.println(Message);
		if (Message.contains("102")){
			report.updateTestLog("Verification of error message on Wrong Pin","Error 102 is displayed" ,Status.PASS);
		}
		else{
		report.updateTestLog("Verification of error message on Wrong Pin","Error 102 is not displayed" ,Status.FAIL);
		}
	 }	
	
	/**
	 * 
	 */
	public void validateFooterDetailsInProdDestPage()throws Exception{
		
		boolean footerSafeShop = selenium.isElementPresent(UIMapCheckOut.footersafe);
		if(!footerSafeShop){
			report.updateTestLog("Verification of Lowe's Safe Shopping Pledge link","Lowe's Safe Shopping Pledge link not displayed" ,Status.FAIL);
		}
		boolean footerToc = selenium.isElementPresent(UIMapCheckOut.footertoc);
		if(!footerToc){
			report.updateTestLog("Verification of Terms and Conditions of Use link","Terms and Conditions of Use link not displayed" ,Status.FAIL);
		}
		boolean footerPrivacy = selenium.isElementPresent(UIMapCheckOut.footerprivacy);
		if(!footerPrivacy){
			report.updateTestLog("Verification of Privacy Statement link","Privacy Statement link not displayed" ,Status.FAIL);
		}
		boolean footerCalifornia = selenium.isElementPresent(UIMapCheckOut.footercalifornia);
		if(!footerCalifornia){
			report.updateTestLog("Verification of Your California Privacy Rights link","Your California Privacy Rights link not displayed" ,Status.FAIL);
		}
		String copyRights = driver.findElement(By.xpath(UIMapCheckOut.footerblock)).getText();
		if(copyRights.contains("Lowe's. All rights reserved.")){
			report.updateTestLog("Verification of Copy Rights message","Copy Rights msg displayed" ,Status.PASS);
		}else{
			report.updateTestLog("Verification of Copy Rights message","Copy Rights msg not displayed" ,Status.FAIL);
		}
	}
	
	public void verifyEasyReturnsAndSafeSecureLinks() throws Exception
	{
		//Click functionality of "Shop with confidence, easy returns and shipping." link 
        driver.findElement(By.xpath("//*[@id='my-lowes-links']/ul/li[1]/a")).click();
		//driver.findElement(By.xpath("//div[2]/div/div/div[3]/ul/li/a/span")).click();
		Thread.sleep(2000);
		int varCount1=ps.countWebElement("//body[@id='checkout-page']/div");
		boolean verPopUp = driver.findElement(By.xpath("//*[@id='checkout-page']/div["+varCount1+"]")).isDisplayed(); 
		// Verifying the display of popup
		if (verPopUp)
		{
			String getPopUptxt = driver.findElement(By.xpath("//*[@id='checkout-page']/div["+varCount1+"]/div[2]")).getText().trim();
			if((getPopUptxt.contains("Lowes.com displays your shipping costs during the checkout process")))
			{
				report.updateTestLog("Validating Shop with confidence, easy returns and shipping link","Pop up is displayed with text", Status.PASS);
			}
			else
			{
				report.updateTestLog("Validating Shop with confidence, easy returns and shipping link","Pop up is not displayed", Status.FAIL);
			}
		}
		//close the pop up
		driver.findElement(By.xpath("//*[@id='checkout-page']/div["+varCount1+"]/div[1]/a/span")).click();
		Thread.sleep(2000);
		//Click functionality of "Shopping is always safe and secure." link 
		
		driver.findElement(By.xpath("//*[@id='my-lowes-links']/ul/li[2]/a")).click();
		//driver.findElement(By.xpath("//div[2]/div/div/div[3]/ul/li[2]/a/span")).click();
					
		Thread.sleep(2000);
		int varCount2=ps.countWebElement("//body[@id='checkout-page']/div");
		
		boolean verPopUp1 = driver.findElement(By.xpath("//*[@id='checkout-page']/div["+varCount2+"]")).isDisplayed(); 
		// Verifying the display of popup
		if (verPopUp1)
		{
			String getPopUptxt = driver.findElement(By.xpath("//*[@id='checkout-page']/div["+varCount2+"]/div[2]")).getText().trim();
			if((getPopUptxt.contains("We respect the privacy of our customers and are committed to providing a secure, friendly site where customers can shop without undue concern.")))
			{
				report.updateTestLog("Validating Shopping is always safe and secure link","Pop up is displayed with appropriate text", Status.PASS);
			}
			else
			{
				report.updateTestLog("Validating Shopping is always safe and secure link","Pop up is not displayed with appropriate text", Status.FAIL);
			}
		}
		//close the pop up
		driver.findElement(By.xpath("//*[@id='checkout-page']/div["+varCount2+"]/div[1]/a/span")).click();
		
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void validateFooterDetailsInSOP()throws Exception{
		validateFooterDetailsInProdDestPage();
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void validateFooterDetailsInReview()throws Exception{
		validateFooterDetailsInProdDestPage();
	}
	
	
	/**
	 * 
	 * @throws Exception
	 */
	public void validateFooterDetailsInConfirm()throws Exception{
		validateFooterDetailsInProdDestPage();
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void verifyMasterHeadInCartPage()throws Exception{
		
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void checkForEditAddressLinkInPDPage()throws Exception{
		boolean editPresent = selenium.isTextPresent("Edit Address");
		if(!editPresent){
			report.updateTestLog("Verification of link","Edit Address not displayed" ,Status.PASS);
		}else{
			report.updateTestLog("Verification of link","Edit Address displayed" ,Status.FAIL);
		}
		Thread.sleep(3000);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void validateAddressNickName()throws Exception{
		if(selenium.isTextPresent("The address name you entered is already in use. Please enter another address name."))
		{
			report.updateTestLog("Verification of link","Address verification has been Done" ,Status.PASS);
		}else{
			report.updateTestLog("Verification of link","Address verification not Done" ,Status.FAIL);
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void verifyLogOutPresentOnMasterHead()throws Exception{
		boolean signOutPresent = selenium.isTextPresent("Sign Out");
		if(signOutPresent){
			report.updateTestLog("Verification of link","Sign out link is present" ,Status.PASS);
		}else{
			report.updateTestLog("Verification of link","Sign out link is not present" ,Status.FAIL);
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void returnToCartToaddProduct() throws Exception {
		// return to cart
		driver.findElement(By.linkText("Return to Cart to Edit Products")).click();

		selenium.windowFocus();
		selenium.waitForPageToLoad("15000");
		
		fc.signOut();
		
		driver.findElement(By.id("Ntt")).sendKeys(
				dataTable.getData("General_Data", "SecondItemNbr"));//389
		try{
			driver.findElement(By.xpath(UIMapMyLowes.lblSearchItemName))
			.click();
			}
			catch(Exception e){
				driver.findElement(By.linkText("No, thanks")).click();
	            report.updateTestLog("Survey Popup","Handeled", Status.DONE);
	            driver.findElement(By.xpath(UIMapMyLowes.lblSearchItemName))
				.click();
			}
		selenium.waitForPageToLoad("30000");
	    driver.findElement(By.id("UPS")).click();
	    selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void reCheckOutOrderAsNewUserDetails()throws Exception{
		ch.providecheckOutOrderAsNewUserDetails();
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void reSignInAtSAP()throws Exception{
		fc.verifyingRegisteredUserLogin();
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void reDoReturnToCartToaddProduct()throws Exception{
		returnToCartToaddProduct();
		reCheckOutOrderAsNewUserDetails();
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void reSignInAtPDP()throws Exception{
		fc.verifyingRegisteredUserLogin();
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void revisitTillSOP()throws Exception{
		returnToCartToaddProduct();
		reCheckOutOrderAsNewUserDetails();
		ch.checkOutShippingInfoAddress();
		ch.provideNewUserShippingInformation();
		ch.checkoutProdDestPage();
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void reSignInAtSOP()throws Exception{
		fc.verifyingRegisteredUserLogin();
	}
	
	
	/**
	 * 
	 * @throws Exception
	 */
	public void getPickupLeadtimeDetails()throws Exception{
		String text = driver.findElement(By.xpath("//*[@id='delivery']/li[1]/div/label/p[1]")).getText();
		if(!text.equals("today")){
			report.updateTestLog("Verification of link","Lead time for pick up available" ,Status.PASS);
		}else{
			report.updateTestLog("Verification of link","Lead time for pick up not available" ,Status.FAIL);
		}
		
		String text2 = driver.findElement(By.xpath("//*[@id='delivery']/li[2]/div/label/p")).getText();
		if(!text2.equals("today")){
			report.updateTestLog("Verification of link","Lead time for truck up available" ,Status.PASS);
		}else{
			report.updateTestLog("Verification of link","Lead time for truck up not available" ,Status.FAIL);
		}
		driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
		ch.selectDlvryMthd();
		ch.providecheckOutOrderAsNewUserDetails();
		
		String getDateInRevPage = driver.findElement(By.xpath("//*[@id='two-column-b']/div[1]/table/tbody/tr[4]/td/strong")).getText();
		String[] parts = getDateInRevPage.split(":");
        String var = parts[1];
        if(text.contains(var)){
        	report.updateTestLog("Verification of link","Lead time for pick up is same as cart page" ,Status.PASS);
		}else{
			report.updateTestLog("Verification of link","Lead time for pick up is not same as cart page" ,Status.FAIL);
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void validateCartPageDefaultState()throws Exception{
		//validate item and model no present or not
		String itemModel = driver.findElement(By.xpath("//div[4]/div/div[2]/div/p")).getText();
		if(itemModel != null ){
			report.updateTestLog("Verification of link","item and model present" ,Status.PASS);
		}
		//remove link
		boolean remove = driver.findElement(By.linkText("Remove")).isDisplayed();
		if(!remove){
			report.updateTestLog("Verification of link","Remove not present" ,Status.FAIL);
		}
		//pickup
		String pickup = driver.findElement(By.xpath("//*[@id='vfileSelectedBanner']/div")).getText();
		if(pickup != null ){
			report.updateTestLog("Verification of link","pickup present" ,Status.PASS);
		}
		//truck
		String truck = driver.findElement(By.xpath("//li[2]/div[2]/div")).getText();
		if(truck != null ){
			report.updateTestLog("Verification of link","truck present" ,Status.PASS);
		}
		//parcel
		String parcel = driver.findElement(By.xpath("//li[3]/div[2]/div")).getText();
		if(parcel != null ){
			report.updateTestLog("Verification of link","parcel present" ,Status.PASS);
		}
		//unit price
		String unitPrice = driver.findElement(By.xpath("//div[2]/div[4]/div/div")).getText();
		if(unitPrice != null ){
			report.updateTestLog("Verification of link","unitPrice present" ,Status.PASS);
		}
		//get Qty
		String Qty = driver.findElement(By.name("quantity_1")).getAttribute("value");
		int qty = Integer.parseInt(Qty);
		if(qty >= 1){
			report.updateTestLog("Verification of link","unitPrice present" ,Status.PASS);
		}
		String[] parts = unitPrice.split("\\$");
        String var = parts[1];
        double unit = Double.parseDouble(var);
		double total = (unit * qty);
        //total price
        String totalPrice = driver.findElement(By.xpath("//div[5]/div/div")).getText();
		if(totalPrice != null ){
			report.updateTestLog("Verification of link","total price present" ,Status.PASS);
		}
		String[] parts2 = totalPrice.split("\\$");
        String var2 = parts2[1];
        //check total price
        double total2 = Double.parseDouble(var2);
        int retval = Double.compare(total, total2);
        if(retval < 0 || retval > 0){
        	report.updateTestLog("Verification of link","unitPrice and total price are not same" ,Status.PASS);
        }else{
        	report.updateTestLog("Verification of link","unitPrice and total price are same" ,Status.PASS);
        }
	}
	/**
	 * 
	 * @throws Execption
	 */
	public void validateChangedLeadTime()throws Exception{
		boolean available = selenium.isTextPresent("Availability");
		if(available){
			report.updateTestLog("Verification of link","Lead time message not present" ,Status.PASS);
        }else{
        	report.updateTestLog("Verification of link","Lead time message present" ,Status.FAIL);
        }
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void selectEPPForItem()throws Exception{
		//select 2 year warranty 
		driver.findElement(By.xpath("//div[2]/label/input")).click();
		
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void eppMessageInOCPage()throws Exception{
		//check eppMsg in OC page
		String eppMsg = driver.findElement(By.xpath("//div[6]/div/div")).getText();
		if(eppMsg.equals("Lowe's Protection Plan")){
			report.updateTestLog("Verification of link","Lowe's Protection Plan message present" ,Status.PASS);
        }else{
        	report.updateTestLog("Verification of link","Lowe's Protection Plan message not present" ,Status.FAIL);
        }
		String eppMsg2 = driver.findElement(By.xpath("//div[6]/div/div[2]")).getText();
		if(eppMsg2 != null){
			report.updateTestLog("Verification of link","Unit price for EPP present" ,Status.PASS);
        }else{
        	report.updateTestLog("Verification of link","Unit price for EPP not present" ,Status.FAIL);
        }
		String eppMsg3 = driver.findElement(By.xpath("//div[6]/div/div[3]")).getText();
		if(eppMsg3 != null){
			report.updateTestLog("Verification of link","EPP Qty present" ,Status.PASS);
        }else{
        	report.updateTestLog("Verification of link","EPP Qty not present" ,Status.FAIL);
        }
		String eppMsg4 = driver.findElement(By.xpath("//div[6]/div/div[4]")).getText();
		if(eppMsg4 != null){
			report.updateTestLog("Verification of link","Item total present" ,Status.PASS);
        }else{
        	report.updateTestLog("Verification of link","Item total not present" ,Status.FAIL);
        }
		
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void validateWGFInOCPage()throws Exception{
		boolean available = selenium.isTextPresent("NC WHITE GOODS FEE");
		if(available){
			report.updateTestLog("Verification of link","WHITE GOODS FEE message present" ,Status.PASS);
        }else{
        	report.updateTestLog("Verification of link","WHITE GOODS FEE message not present" ,Status.FAIL);
        }
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void verifySignUpInOCPage()throws Exception{
		boolean signUp = selenium.isElementPresent("//*[@id='user-signup']");
		if(signUp){
			report.updateTestLog("Verification of link","Sign Up for MyLowe's feild present" ,Status.PASS);
        }else{
        	report.updateTestLog("Verification of link","Sign Up for MyLowe's feild not present" ,Status.FAIL);
        }
		
		boolean available = selenium.isTextPresent("Sign Up for MyLowe's");
		if(available){
			report.updateTestLog("Verification of link","Sign Up for MyLowe's message present" ,Status.PASS);
        }else{
        	report.updateTestLog("Verification of link","Sign Up for MyLowe's message not present" ,Status.FAIL);
        }
		boolean available2 = selenium.isTextPresent("Create Your Account");
		if(available2){
			report.updateTestLog("Verification of link","Create Your Account message present" ,Status.PASS);
        }else{
        	report.updateTestLog("Verification of link","Create Your Account message not present" ,Status.FAIL);
        }
		boolean available3 = selenium.isTextPresent("Privacy and Security");
		if(available3){
			report.updateTestLog("Verification of link","Privacy and Security message present" ,Status.PASS);
        }else{
        	report.updateTestLog("Verification of link","Privacy and Security message not present" ,Status.FAIL);
        }
		boolean available4 = selenium.isTextPresent("Terms and Conditions");
		if(available4){
			report.updateTestLog("Verification of link","Terms and Conditions message present" ,Status.PASS);
        }else{
        	report.updateTestLog("Verification of link","Terms and Conditions message not present" ,Status.FAIL);
        }
		boolean available5 = selenium.isTextPresent("Log In");
		if(available5){
			report.updateTestLog("Verification of link","Log In message present" ,Status.PASS);
        }else{
        	report.updateTestLog("Verification of link","Log In message not present" ,Status.FAIL);
        }
		boolean available6 = selenium.isTextPresent("Thank you for choosing Lowes.com.");
		if(available6){
			report.updateTestLog("Verification of link","Thank you for choosing Lowes.com. message present" ,Status.PASS);
        }else{
        	report.updateTestLog("Verification of link","Thank you for choosing Lowes.com. message not present" ,Status.FAIL);
        }
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void validateMasterHeadInSAP()throws Exception{
		boolean signIn = driver.findElement(By.name("MASTHEAD_Account_SignIn")).isDisplayed();
		if(signIn){
			report.updateTestLog("Verification of link","SignIn message present" ,Status.PASS);
        }else{
        	report.updateTestLog("Verification of link","SignIn message not present" ,Status.FAIL);
        }
		boolean signUp = driver.findElement(By.name("MASTHEAD_Account_SignUp")).isDisplayed();
		if(signUp){
			report.updateTestLog("Verification of link","SignUp message present" ,Status.PASS);
        }else{
        	report.updateTestLog("Verification of link","SignUp message not present" ,Status.FAIL);
        }
		boolean count = driver.findElement(By.id("nav-cart-count")).isDisplayed();
		if(count){
			report.updateTestLog("Verification of link","cart count message present" ,Status.PASS);
        }else{
        	report.updateTestLog("Verification of link","cart count message not present" ,Status.FAIL);
        }
		boolean label = driver.findElement(By.id("nav-cart-label")).isDisplayed();
		if(label){
			report.updateTestLog("Verification of link","cart label message present" ,Status.PASS);
        }else{
        	report.updateTestLog("Verification of link","cart label message not present" ,Status.FAIL);
        }
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void validateMasterHeadInPDPage()throws Exception{
		validateMasterHeadInSAP();
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void validateMasterHeadInSOP()throws Exception{
		validateMasterHeadInSAP();
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void validateMasterHeadInReviewPage()throws Exception{
		validateMasterHeadInSAP();
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void validateMasterHeadInOCPage()throws Exception{
		String count = driver.findElement(By.id("nav-cart-count")).getText();
		int unit = Integer.parseInt(count);
		if(unit == 0){
			report.updateTestLog("Verification of link","cart count is Zero" ,Status.PASS);
        }else{
        	report.updateTestLog("Verification of link","cart count is not Zero" ,Status.FAIL);
        }
	}
	public void makeEmployeeAccount() throws Exception
	{
		ma.yourAccountPreferences();
		driver.findElement(
				By.xpath(UIMapMyLowes.webElmntEditAccInfo))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		ma.addEmployeeBenefitCode();
	}
	public void verifyGCsectionInReviewPay() throws Exception
	{
		boolean var1,var2,var3,var4;
		var1 = driver.findElement(By.xpath(UIMapCheckOut.lbloneOrMoreGC)).isDisplayed();
	    var2 = driver.findElement(By.xpath(UIMapCheckOut.GCNumber)).isDisplayed();
	    var3 = driver.findElement(By.xpath(UIMapCheckOut.GCPin)).isDisplayed();
	    var4 = driver.findElement(By.xpath(UIMapCheckOut.GCApply)).isDisplayed();
	    if(var1&&var2&&var3&&var4)
	    	report.updateTestLog("veriying fields in Gift Cards & Reward Certificates section","All fields are correctly displayed in Gift Cards & Reward Certificates section",Status.PASS);
	    else
	    	report.updateTestLog("veriying fields in Gift Cards & Reward Certificates section","fields are not correctly displayed in Gift Cards & Reward Certificates section",Status.FAIL);
	}
	public void verifyCreditCardSectionInRP() throws Exception
	{
		boolean var1,var2,var3,var4,var5,var6;
		var1 = driver.findElement(By.xpath(UIMapCheckOut.lblCardType)).isDisplayed();
	    var2 = driver.findElement(By.xpath(UIMapCheckOut.ddCardType)).isDisplayed();
	    var3 = driver.findElement(By.xpath(UIMapCheckOut.imgCardType)).isDisplayed();
	    var4 = driver.findElement(By.xpath(UIMapCheckOut.crdtCardNoForm)).isDisplayed();
	    var5 = driver.findElement(By.xpath(UIMapCheckOut.sCodeForm)).isDisplayed();
	    var6 = driver.findElement(By.xpath(UIMapCheckOut.expDateForm)).isDisplayed();
	    if(var1)
	    	report.updateTestLog("Verifying Card Type label","Card Type label is displayed",Status.PASS);
	    else
	    	report.updateTestLog("Verifying Card Type label","Card Type label is not displayed",Status.FAIL);
	    if(var2)
	    	report.updateTestLog("Verifying Card Type dropdown","Card Type dropdown is displayed",Status.PASS);
	    else
	    	report.updateTestLog("Verifying Card Type dropdown","Card Type dropdown is not displayed",Status.FAIL);
	    if(var3)
	    	report.updateTestLog("Verifying Card Type image","Card Type image is displayed",Status.PASS);
	    else
	    	report.updateTestLog("Verifying Card Type image","Card Type image is not displayed",Status.FAIL);
	    if(var4)
	    	report.updateTestLog("Verifying CreditCard Number field","CreditCard Number field is displayed",Status.PASS);
	    else
	    	report.updateTestLog("Verifying CreditCard Number field","CreditCard Number field is not displayed",Status.FAIL);
	    if(var5)
	    	report.updateTestLog("Verifying Security Code field","Security Code field is displayed",Status.PASS);
	    else
	    	report.updateTestLog("Verifying Security Code field","Security Code field is not displayed",Status.FAIL);
	    if(var6)
	    	report.updateTestLog("Verifying Expiration Date field","Expiration Date field is displayed",Status.PASS);
	    else
	    	report.updateTestLog("Verifying Expiration Date field","Expiration Date field is not displayed",Status.FAIL);
	}
	
	public void verifyBillInfoInRP() throws Exception
	{
		boolean var1,var2,var3,var4,var5,var6,var7,var8,var9,var10,var11;
		var1 = driver.findElement(By.xpath(UIMapCheckOut.chkBoxUseShip)).isDisplayed();
	    var2 = driver.findElement(By.xpath(UIMapCheckOut.billFirstName)).isDisplayed();
	    var3 = driver.findElement(By.xpath(UIMapCheckOut.billLastName)).isDisplayed();
	    var4 = driver.findElement(By.xpath(UIMapCheckOut.billCompanyName)).isDisplayed();
	    var5 = driver.findElement(By.xpath(UIMapCheckOut.billAddrLine1)).isDisplayed();
	    var6 = driver.findElement(By.xpath(UIMapCheckOut.billAddrLine2)).isDisplayed();
	    var7 = driver.findElement(By.xpath(UIMapCheckOut.billCity)).isDisplayed();
	    var8 = driver.findElement(By.xpath(UIMapCheckOut.billState)).isDisplayed();
	    var9 = driver.findElement(By.xpath(UIMapCheckOut.billZip)).isDisplayed();
	    var10 = driver.findElement(By.xpath(UIMapCheckOut.billPhone)).isDisplayed();
	    var11 = driver.findElement(By.xpath(UIMapCheckOut.billEmail)).isDisplayed();
	    if(var1)
	    	report.updateTestLog("Verifying Use My Shipping Address Checkbox","Use My Shipping Address Checkbox is displayed",Status.PASS);
	    else
	    	report.updateTestLog("Verifying Use My Shipping Address Checkbox","Use My Shipping Address Checkbox is not displayed",Status.FAIL);
	    if(var2)
	    	report.updateTestLog("Verifying First Name Field","First Name Field is displayed",Status.PASS);
	    else
	    	report.updateTestLog("Verifying First Name Field","First Name Field is not displayed",Status.FAIL);
	    if(var3)
	    	report.updateTestLog("Verifying Last Name Field","Last Name Field is displayed",Status.PASS);
	    else
	    	report.updateTestLog("Verifying Last Name Field","Last Name Field is not displayed",Status.FAIL);
	    if(var4)
	    	report.updateTestLog("Verifying Company Name Field","Company Name Field is displayed",Status.PASS);
	    else
	    	report.updateTestLog("Verifying Company Name Field","Company Name Field is not displayed",Status.FAIL);
	    if(var5)
	    	report.updateTestLog("Verifying Address Line1 Field","Address Line1 Field is displayed",Status.PASS);
	    else
	    	report.updateTestLog("Verifying Address Line1 Field","Address Line1 Field is not displayed",Status.FAIL);
	    if(var6)
	    	report.updateTestLog("Verifying Address Line2 Field","Address Line2 Field is displayed",Status.PASS);
	    else
	    	report.updateTestLog("Verifying Address Line2 Field","Address Line2 Field is not displayed",Status.FAIL);
	    if(var7)
	    	report.updateTestLog("Verifying City Field","City Field is displayed",Status.PASS);
	    else
	    	report.updateTestLog("Verifying City Field","City Field is not displayed",Status.FAIL);
	    if(var8)
	    	report.updateTestLog("Verifying State Field","State Field is displayed",Status.PASS);
	    else
	    	report.updateTestLog("Verifying State Field","State Field is not displayed",Status.FAIL);
	    if(var10)
	    	report.updateTestLog("Verifying Phone Field","Phone Field is displayed",Status.PASS);
	    else
	    	report.updateTestLog("Verifying Phone Field","Phone Field is not displayed",Status.FAIL);
	    if(var11)
	    	report.updateTestLog("Verifying Email Field","Email Field is displayed",Status.PASS);
	    else
	    	report.updateTestLog("Verifying Email Field","Email Field is not displayed",Status.FAIL);
	    if(var9)
	    	report.updateTestLog("Verifying Zip Code Field","Zip Code Field is displayed",Status.PASS);
	    else
	    	report.updateTestLog("Verifying Zip Code Field","Zip Code Field is not displayed",Status.FAIL);
	    
	}
	public void verifyFreeLowesAccInRP() throws Exception
	{
		driver.findElement(By.id("reg-messaging-expand")).click();

		Thread.sleep(1000);

		boolean var1,var2,var3;

		var1 = driver.findElement(By.xpath(UIMapCheckOut.iWantFreeAccLogin)).isDisplayed();

		var2 = driver.findElement(By.xpath(UIMapCheckOut.iWantFreeAccPwd)).isDisplayed();

		var3 = driver.findElement(By.xpath(UIMapCheckOut.iWantFreeAccReEnterPwd)).isDisplayed();

		if(var1)

		report.updateTestLog("Verifying Free Account Login Field","Free Account Login Field is displayed",Status.PASS);

		else

		report.updateTestLog("Verifying Free Account Login Field","Free Account Login Field is not displayed",Status.FAIL);

		if(var2)

		report.updateTestLog("Verifying Free Account Password Field","Free Account Password Field is displayed",Status.PASS);

		else

		report.updateTestLog("Verifying Free Account Password Field","Free Account Password Field is not displayed",Status.FAIL);

		if(var3)

		report.updateTestLog("Verifying Free Account Re-enter Password Field","Free Account Re-enter Password Field is displayed",Status.PASS);

		else

		report.updateTestLog("Verifying Free Account Re-enter Password Field","Free Account Re-enter Password Field is not displayed",Status.FAIL);
		}
	public void verifyCartSummaryInRP() throws Exception
	{
		boolean var1,var2,var3,var4,var5,var6,var7,var8;
		var1 = driver.findElement(By.xpath(UIMapCheckOut.lnkRtrnToCart)).isDisplayed();
	    var2 = driver.findElement(By.xpath(UIMapCheckOut.lblProductsInCart)).isDisplayed();
	    var3 = driver.findElement(By.xpath(UIMapCheckOut.lblUnitPrice)).isDisplayed();
	    var4 = driver.findElement(By.xpath(UIMapCheckOut.lblQuantity)).isDisplayed();
	    var5 = driver.findElement(By.xpath(UIMapCheckOut.lblTotal)).isDisplayed();
	    var6 = driver.findElement(By.xpath(UIMapCheckOut.ifOrderdMsg)).isDisplayed();
	    var7 = driver.findElement(By.xpath(UIMapCheckOut.shipToMsg)).isDisplayed();
	    var8 = driver.findElement(By.xpath(UIMapCheckOut.arrivesMsg)).isDisplayed();
	    if(var1)
	    	report.updateTestLog("Verifying Retutn To Cart to Edit Products link","Retutn To Cart to Edit Products link is displayed",Status.PASS);
	    else
	    	report.updateTestLog("Verifying Retutn To Cart to Edit Products link","Retutn To Cart to Edit Products link is not displayed",Status.FAIL);
	    if(var2)
	    	report.updateTestLog("Verifying Products In Cart label","Products In Cart label is displayed",Status.PASS);
	    else
	    	report.updateTestLog("Verifying Products In Cart label","Products In Cart label is not displayed",Status.FAIL);
	    if(var3)
	    	report.updateTestLog("Verifying Unit Price label","Unit Price label is displayed",Status.PASS);
	    else
	    	report.updateTestLog("Verifying Unit Price label","Unit Price label is not displayed",Status.FAIL);
	    if(var4)
	    	report.updateTestLog("Verifying Quantity label","Quantity label is displayed",Status.PASS);
	    else
	    	report.updateTestLog("Verifying Quantity label","Quantity label is not displayed",Status.FAIL);
	    if(var6)
	    	report.updateTestLog("Verifying If Ordered Message","If Ordered Message is displayed",Status.PASS);
	    else
	    	report.updateTestLog("Verifying If Ordered Message","If Ordered Message is not displayed",Status.FAIL);
	    if(var7)
	    	report.updateTestLog("Verifying Ship To Address","Ship To Address is displayed",Status.PASS);
	    else
	    	report.updateTestLog("Verifying Ship To Address","Ship To Address is not displayed",Status.FAIL);
	    if(var5)
	    	report.updateTestLog("Verifying Total label","Total label is displayed",Status.PASS);
	    else
	    	report.updateTestLog("Verifying Total label","Total label is not displayed",Status.FAIL);
	    if(var8)
	    	report.updateTestLog("Verifying Arrives Message","Arrives Message is displayed",Status.PASS);
	    else
	    	report.updateTestLog("Verifying Arrives Message","Arrives Message is not displayed",Status.FAIL);
	}
	public void clickCancelFromRP() throws Exception
	{
		try{

			driver.findElement(By.xpath("//*[@id='CreditcardForm']/div[5]/ul/li[1]/a/span")).click();

			}

			catch(Exception e){}

			selenium.waitForPageToLoad("20000");

			Thread.sleep(6000);

			if(driver.getTitle().contains("Lowe's: Shopping Cart"))

			{

			report.updateTestLog("Click functionality of Cancel link",

			"Shopping Cart page is displayed",

			Status.PASS);

			} else {

			report.updateTestLog("Click functionality of Cancel link",

			"Appropriate page is not displayed",

			Status.FAIL);

			}

			ch.providecheckOutOrderAsNewUserDetails();

			//provideShippingInformation();

			//checkoutFromShippingInformation();

			checkoutFromProductDestination();

			checkoutFromProductDestination();

	}
	public void clickPreviousButtonFromRP() throws Exception
    {
		ClickCustomize("xpath","//*[@id='CreditcardForm']/div[5]/ul/li[2]/a");
    	selenium.waitForPageToLoad("20000");
		Thread.sleep(5000);
		if(driver.getTitle().contains("Lowe's: Secure Checkout - Shipping Options"))
		{
			report.updateTestLog("Click functionality of Previous link", 
					"Shipping Options page is displayed",
					Status.PASS);
		} else {
			report.updateTestLog("Click functionality of Previous link", 
					"Appropriate page is not displayed",
					Status.FAIL);
		}
		checkoutFromProductDestination();
    }
	public void validateBillingSummaryInRP() throws Exception
	{
		String frame2 = driver.findElement(By.xpath("//*[@id='two-column-b']/div[2]/div[1]/h5")).getText();
		System.out.println(frame2);
		if (frame2.equals("Billing Summary")) {
	    	report.updateTestLog("Validating the display of Billing Summary frame ",
	    			"Billing Summary frame is displayed", Status.PASS);
	    } else {
	    	report.updateTestLog("Validating the display of Billing Summary frame",
	    			"Billing Summary frame is not displayed", Status.FAIL);
	    }	
		
	if (driver.findElement(By.xpath("//*[@id='two-column-b']/div[2]")).isDisplayed())
	{
		if(driver.findElement(By.xpath("//*[@id='two-column-b']/div[2]/table/tbody/tr[1]/td[1]/strong")).isDisplayed())
		{
			report.updateTestLog("Verifying Subtotal in Billing Summary Section","Subtotal is displayed in Billing Summary",Status.PASS);	
		}
		else
		{
			report.updateTestLog("Verifying Subtotal in Billing Summary Section","Subtotal is not displayed in Billing Summary",Status.FAIL);
		}
		
		if(driver.findElement(By.xpath("//*[@id='two-column-b']/div[2]/table/tbody/tr[2]/td[1]")).isDisplayed())
		{
			report.updateTestLog("Verifying Estimated Parcel Shipping in Billing Summary Section","Estimated Parcel Shipping is displayed in Billing Summary",Status.PASS);	
		}
		else
		{
			report.updateTestLog("Verifying Estimated Parcel Shipping in Billing Summary Section","Estimated Parcel Shipping is not displayed in Billing Summary",Status.FAIL);
		}
		
		if(driver.findElement(By.xpath("//*[@id='two-column-b']/div[2]/table/tbody/tr[3]/td[1]")).isDisplayed())
		{
			report.updateTestLog("Verifying Estimated Tax in Billing Summary Section","Estimated Tax is displayed in Billing Summary",Status.PASS);	
		}
		else
		{
			report.updateTestLog("Verifying Estimated Tax in Billing Summary Section","Estimated Tax is not displayed in Billing Summary",Status.FAIL);
		}
		
		if(driver.findElement(By.xpath("//*[@id='two-column-b']/div[2]/table/tbody/tr[4]/td[1]")).isDisplayed())
		{
			report.updateTestLog("Verifying Balance Due in Billing Summary Section","Balance Due is displayed in Billing Summary",Status.PASS);	
		}
		else
		{
			report.updateTestLog("Verifying Balance Due in Billing Summary Section","Balance Due is not displayed in Billing Summary",Status.FAIL);
		}
		
		if(driver.findElement(By.xpath("//*[@id='two-column-b']/div[2]/table/tbody/tr[2]/td[1]/a/img")).isDisplayed() &&
				driver.findElement(By.xpath("//*[@id='two-column-b']/div[2]/table/tbody/tr[3]/td[1]/a/img")).isDisplayed())
		{
			report.updateTestLog("Verifying Contextual Help icons in Billing Summary Section","Contextual Help icons is displayed in Billing Summary",Status.PASS);	
		}
		else
		{
			report.updateTestLog("Verifying Contextual Help icons in Billing Summary Section","Contextual Help icons is not displayed in Billing Summary",Status.FAIL);
		}
		
	}
	else
	{
		report.updateTestLog("Verifying Billing Summary Section","Billing Summary Section is not displayed",Status.FAIL);
	}
	}
}
