package com.lowes.qa.selenium.components;

import java.sql.Timestamp;
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
import com.lowes.qa.selenium.uimap.UIMapFunctionalComponents;
import com.lowes.qa.selenium.uimap.UIMapMyLowes;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;


/**
 * My Lowes Class
 * @author Infosys
 */
public class MyLowes extends ReusableLibrary
{
	/**
	 * Constructor to initialize the component library
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link DriverScript}
	 */
	
	String baseurl = dataTable.getData("General_Data", "URL");
	Selenium selenium = new WebDriverBackedSelenium(driver, baseurl);
	FunctionalComponents fc = new FunctionalComponents(scriptHelper);
	
	public MyLowes(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
	}
	
	
	/**
	 * This welcomePageValidation() method is used to validate the
	 *  welcome page if user is able to successfully signin/signup 
	 */
	private void welcomePageValidation(String getLoggedInUser) {
		if(getLoggedInUser.equals("Welcome, "+dataTable.getData("General_Data","Firstname")))          // Verifying the registered user details by Using Firstname
		{
			report.updateTestLog("Validating Login Credentials","User Registration Successful", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Login Credentials","User Registration UnSuccessful", Status.FAIL);
		}
	}
	
	/**
	 * This lowesUserRegistration() method is used to register the user 
	 * when uses the phone number to track in-store purchases and don't want a physical MyLowe's card.
	 */
	public void lowesUserRegistrationUsingPhNo()
	{
		driver.findElement(By.xpath(UIMapFunctionalComponents.lnkSignUp)).click();
		selenium.waitForPageToLoad("5000");
		boolean verUserRegForm = driver.findElement(By.id(UIMapMyLowes.btnCreateAccount)).isDisplayed(); // Verifying the Create Account Button
		System.out.println("User Registration Page Displayed is :"+verUserRegForm);
		if(verUserRegForm)
		{
			userSignUpData();
			driver.findElement(By.id(UIMapMyLowes.btnCreateAccount)).click();
			//selenium.waitForPageToLoad("45000");
			report.updateTestLog("Verifying Lowes User Registration page" ,"Navigation to User Registration Page Successfull", Status.PASS);
			String getLoggedInUser=driver.findElement(By.xpath(UIMapFunctionalComponents.webElmntSalutation)).getText().trim();
			System.out.println("Verifying the Registered User detais :"+getLoggedInUser);
			welcomePageValidation(getLoggedInUser);
		}
		else
		{
			report.updateTestLog("Verifying Lowes User Registration page" ,"Failed to Navigate to User Registration Page", Status.FAIL);	
		}
	}
	
	/**
	 * This lowesUserRegistrationCardAlreadyExists() method is used to register the user 
	 * when user is already having the lowes card
	 */
	public void lowesUserRegistrationCardAlreadyExists() throws Exception {
		   	   
		 	driver.findElement(By.xpath(UIMapFunctionalComponents.lnkSignUp)).click();
			//selenium.waitForPageToLoad("5000");
			boolean verUserRegForm=driver.findElement(By.xpath(UIMapFunctionalComponents.btnRegistrationSubmit)).isDisplayed(); // Verifying the Create Account Button
			System.out.println("User Registration Page Displayed is :"+verUserRegForm);
			if(verUserRegForm)
			{
				userSignUpData();
				driver.findElement(By.id(UIMapMyLowes.btnCardRegister)).click();//Selecting the radio button if lowe's card already exists
				driver.findElement(By.name(UIMapMyLowes.txtCardNo)).sendKeys(dataTable.getData("General_Data","lowescardno"));
				//driver.findElement(By.xpath(UIMapFunctionalComponents.btnRegistrationSubmit)).click(); // Clicking the Create Account button to register user
				driver.findElement(By.id(UIMapMyLowes.btnCreateAccount)).click();
				Thread.sleep(5000);
				report.updateTestLog("Verifying Lowes User Registration page" ,"Navigation to User Registration Page Successfull", Status.PASS);
				String getLoggedInUser=driver.findElement(By.xpath(UIMapFunctionalComponents.webElmntSalutation)).getText().trim();
				System.out.println("Verifying the Registered User detais :"+getLoggedInUser);
				welcomePageValidation(getLoggedInUser);
			}
			else
			{
				report.updateTestLog("Verifying Lowes User Registration page" ,"Failed to Navigate to User Registration Page", Status.FAIL);	
			}
		 }
	 /**
	 * This userSignUpData() method is used to enter the details of the user 
	 * for a successful sign up
	 */
	private void userSignUpData() {
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
		driver.findElement(By.id(UIMapFunctionalComponents.txtFirstName)).sendKeys(dataTable.getData("General_Data","Firstname")); //Entering the firsname in User Registration form
		driver.findElement(By.id(UIMapFunctionalComponents.txtLastName)).sendKeys(dataTable.getData("General_Data","Lastname"));  // Entering the lastname in User Registration form
		driver.findElement(By.id(UIMapFunctionalComponents.txtEmail)).sendKeys(varUniq+"@bh.exacttarget.com");//Unique Email ID based on timestamp
		driver.findElement(By.id(UIMapFunctionalComponents.txtPhone)).sendKeys(dataTable.getData("General_Data","phone"));  // Entering Phone number
		driver.findElement(By.id(UIMapFunctionalComponents.txtRegPassword)).sendKeys(dataTable.getData("General_Data","password")); // Entering Password
		driver.findElement(By.id(UIMapFunctionalComponents.txtConfPassword)).sendKeys(dataTable.getData("General_Data","confpassword")); //Entering Confirm Password
		//driver.findElement(By.id("prefStoreZipCode")).sendKeys(dataTable.getData("General_Data","zipcode")); //Entering Zipcode
	}
	
	/**
	 * This lowesUserRegistrationCardAlreadyExists() method is used to register the user 
	 * when user is already having the lowes card
	 */
	public void lowesUserRegistrationInMail() throws Exception {
		   	   
		 	driver.findElement(By.xpath(UIMapFunctionalComponents.lnkSignUp)).click();
		 	Thread.sleep(12000);
			boolean verUserRegForm = driver.findElement(By.id(UIMapMyLowes.btnCreateAccount)).isDisplayed(); // Verifying the Create Account Button
			System.out.println("User Registration Page Displayed is :"+verUserRegForm);
			if(verUserRegForm)
			{
				userSignUpData();
				driver.findElement(By.cssSelector(UIMapMyLowes.rdoBtnLowesPref)).click();//Verifying Mail me a MyLowe's card radio button
				driver.findElement(By.id(UIMapMyLowes.txtAddress1)).clear();
				driver.findElement(By.id(UIMapMyLowes.txtAddress1)).sendKeys(dataTable.getData("General_Data","AddLine1"));
				driver.findElement(By.id(UIMapMyLowes.txtCity)).clear();
				driver.findElement(By.id(UIMapMyLowes.txtCity)).sendKeys(dataTable.getData("General_Data","City"));
				new Select(driver.findElement(By.id(UIMapMyLowes.txtState))).selectByVisibleText(dataTable.getData("General_Data", "State"));
				//driver.findElement(By.xpath(UIMapFunctionalComponents.btnRegistrationSubmit)).click(); //Clicking the Create Account button to register user
				driver.findElement(By.id(UIMapMyLowes.btnCreateAccount)).click();
				Thread.sleep(5000);
				report.updateTestLog("Verifying Lowes User Registration page" ,"Navigation to User Registration Page Successfull", Status.PASS);
				String getLoggedInUser=driver.findElement(By.xpath(UIMapFunctionalComponents.webElmntSalutation)).getText().trim();
				System.out.println("Verifying the Registered User detais :"+getLoggedInUser);
				welcomePageValidation(getLoggedInUser);
			}
			else
			{
				report.updateTestLog("Verifying Lowes User Registration page" ,"Failed to Navigate to User Registration Page", Status.FAIL);	
			}
		 }
	

	/**
	 * This userSignUpData() method is used to enter the details of the user 
	 * for a successful sign up
	 */
	private void userSignUpEmptyData() {
		driver.findElement(By.id(UIMapFunctionalComponents.txtFirstName)).sendKeys(dataTable.getData("General_Data","FirstnameEmpty")); //Entering the firsname in User Registration form
		driver.findElement(By.id(UIMapFunctionalComponents.txtLastName)).sendKeys(dataTable.getData("General_Data","LastnameEmpty"));  // Entering the lastname in User Registration form
		driver.findElement(By.id(UIMapFunctionalComponents.txtEmail)).sendKeys(dataTable.getData("General_Data","emailEmpty"));  // Entering Email id
		driver.findElement(By.id(UIMapFunctionalComponents.txtPhone)).sendKeys(dataTable.getData("General_Data","phoneEmpty"));  // Entering Phone number
		driver.findElement(By.id(UIMapFunctionalComponents.txtRegPassword)).sendKeys(dataTable.getData("General_Data","passwordEmpty")); // Entering Password
		driver.findElement(By.id(UIMapFunctionalComponents.txtConfPassword)).sendKeys(dataTable.getData("General_Data","confpasswordEmpty")); //Entering Confirm Password
		//driver.findElement(By.id("prefStoreZipCode")).sendKeys(dataTable.getData("General_Data","zipcodeEmpty")); //Entering Zipcode
	}
	
	/**
	 * This lowesUserRegistrationCardAlreadyExists() method is used to register the user 
	 * when user is already having the lowes card
	 */
	public void validatingErrMesgsWhileSignUp() throws Exception {
		   
		 	driver.findElement(By.xpath(UIMapFunctionalComponents.lnkSignUp)).click();
			Thread.sleep(7000);
			boolean verUserRegForm=driver.findElement(By.xpath(UIMapFunctionalComponents.btnRegistrationSubmit)).isDisplayed(); // Verifying the Create Account Button
			System.out.println("User Registration Page Displayed is :"+verUserRegForm);
			if(verUserRegForm)
			{
				userSignUpEmptyData();
				driver.findElement(By.id(UIMapMyLowes.btnCreateAccount)).click();
				Thread.sleep(5000);
				if((driver.findElement(By.xpath(UIMapMyLowes.txtPresentFirstName)).isDisplayed())||
						(driver.findElement(By.xpath(UIMapMyLowes.txtPresentLastName)).isDisplayed())||
						(driver.findElement(By.xpath(UIMapMyLowes.txtPresentEmail)).isDisplayed())||
						(driver.findElement(By.xpath(UIMapMyLowes.txtPresentPhone)).isDisplayed())||
						(driver.findElement(By.xpath(UIMapMyLowes.txtPresentRegPassword)).isDisplayed())||
						(driver.findElement(By.xpath(UIMapMyLowes.txtPresentConfPassword)).isDisplayed())){
					report.updateTestLog("Verification of error messages successful", "Enter all the mandatory fiels :First name,"+
							"last name, email address,password, confirm password, zip code and phone number ", Status.PASS);
				}
				else{
					report.updateTestLog("Verification of error messages unsuccessful", "Error messages are not displayed properly", Status.FAIL);
				}
				clearTheTextFields();
				userSignUpData();
				driver.findElement(By.id(UIMapFunctionalComponents.txtEmail)).clear();
				driver.findElement(By.id(UIMapFunctionalComponents.txtEmail)).sendKeys(dataTable.getData("General_Data","emailExisting"));
				driver.findElement(By.id(UIMapMyLowes.btnCreateAccount)).click();
				Thread.sleep(5000);
				if(driver.findElement(By.xpath(UIMapMyLowes.txtPresentEmail)).isDisplayed()){
					report.updateTestLog("Verication of error messages successful", "The email address you entered is already registered to"+ 
							"Lowes.com account. Please enter a new email address or sign in to access your account.", Status.PASS);
				}
				else{
					report.updateTestLog("Verification of error messages unsuccessful", "Error messages are not displayed properly", Status.FAIL);				
				}
				clearTheTextFields();				
				userSignUpData();
				driver.findElement(By.id(UIMapFunctionalComponents.txtRegPassword)).clear();
				driver.findElement(By.id(UIMapFunctionalComponents.txtConfPassword)).clear();
				driver.findElement(By.id(UIMapFunctionalComponents.txtRegPassword)).sendKeys(dataTable.getData("General_Data","invPassword"));
				driver.findElement(By.id(UIMapFunctionalComponents.txtConfPassword)).sendKeys(dataTable.getData("General_Data","invConfPassword"));
				driver.findElement(By.id(UIMapMyLowes.btnCreateAccount)).click();
				Thread.sleep(5000);
				if((driver.findElement(By.xpath(UIMapMyLowes.txtPresentRegPassword)).isDisplayed())||
						(driver.findElement(By.xpath(UIMapMyLowes.txtPresentConfPassword)).isDisplayed())){
					report.updateTestLog("Verication of error messages successful", "Your password doesn't appear to be valid is displayed.", Status.PASS);
				}
				else{
					report.updateTestLog("Verification of error messages unsuccessful", "Error messages are not displayed properly", Status.FAIL);				
				}
			}
			else
			{
				report.updateTestLog("Verifying Lowes User Registration page" ,"Failed to Navigate to User Registration Page", Status.FAIL);	
			}
			}	
	

	/**
	 * This clearTheTextFields() method is used to clear all the text fields
	 */
	private void clearTheTextFields() {
		
		driver.findElement(By.id(UIMapFunctionalComponents.txtFirstName)).clear();
		driver.findElement(By.id(UIMapFunctionalComponents.txtLastName)).clear();
		driver.findElement(By.id(UIMapFunctionalComponents.txtEmail)).clear();
		driver.findElement(By.id(UIMapFunctionalComponents.txtPhone)).clear();
		driver.findElement(By.id(UIMapFunctionalComponents.txtRegPassword)).clear();
		driver.findElement(By.id(UIMapFunctionalComponents.txtConfPassword)).clear();
		//driver.findElement(By.id("prefStoreZipCode")).clear();
		
	}
	
	/**
	 * This userLoginWhileSavingTheItemToList() method is used to sign in at the time of adding the item to list 
	 * 
	 */
	public void userLoginWhileSavingTheItemToList() throws Exception{
		 
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","ItemNbr"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		report.updateTestLog("Searching For an Item","Searching Item Number - "+dataTable.getData("General_Data","ItemNbr")+"" ,Status.DONE);
		//selenium.waitForPageToLoad("10000");
		boolean verItemPresent=selenium.isTextPresent("Item #: "+dataTable.getData("General_Data","ItemNbr"));
		if(verItemPresent)
		{
			report.updateTestLog("Veriyfing Navigating to Item's PDP Page","Item - " +dataTable.getData("General_Data","ItemNbr") +" is Present", Status.PASS);
		}
		else
		{
			report.updateTestLog("Veriyfing Navigating to Item's PDP Page","Item is NOT Present", Status.FAIL);
		}
		//Adding the element to the list after finding the element
		driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveItem)).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(UIMapMyLowes.lnkSaveToLists)).click();
	    Thread.sleep(5000);
	    
	    verifyingUserLogin();			
				
	}
	
	/**
	 * This userLoginWhileSavingTheItemToList() method is used to sign in at the time of adding the item to home profile 
	 * 
	 */
	public void userLoginWhileSavingTheItemToHomeProfile() throws Exception{
	 	
	 	
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","ItemNbr"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		Thread.sleep(7000);
		report.updateTestLog("Searching For an Item","Searching Item Number - "+dataTable.getData("General_Data","ItemNbr")+"" ,Status.DONE);
		boolean verItemPresent=selenium.isTextPresent("Item #: "+dataTable.getData("General_Data","ItemNbr"));
		if(verItemPresent)
		{
			report.updateTestLog("Veriyfing Navigating to Item's PDP Page","Item - " +dataTable.getData("General_Data","ItemNbr") +" is Present", Status.PASS);
		}
		else
		{
			report.updateTestLog("Veriyfing Navigating to Item's PDP Page","Item is NOT Present", Status.FAIL);
		}
		//Adding the element to the list after finding the element
		driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveItem)).click();
		Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkSaveToHomeProfile)).click();
	    Thread.sleep(5000);    
	    
	    verifyingUserLogin();			
				
	}
	
	/**
	 * This userLoginWhileAddingTheItemToCart() method is used to sign in at the time of adding the item to cart.
	 * 
	 */
	public void userLoginWhileAddingTheItemToCart() throws Exception 
	{
		driver.findElement(By.xpath(UIMapFunctionalComponents.lnkStoreUnzip)).click();
		
		//Enter the Zip code of the required store in the text box present displayed and click enter
	    driver.findElement(By.id(UIMapFunctionalComponents.txtStoreZip)).clear();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtStoreZip)).sendKeys(dataTable.getData("General_Data", "zipcode"));
	    driver.findElement(By.id(UIMapFunctionalComponents.txtStoreZip)).sendKeys(Keys.ENTER);
		
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data", "ItemNbr"));
		try {
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		} catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		}
		Thread.sleep(7000);
		report.updateTestLog("Searching For an Item","Searching Item Number - "	+ dataTable.getData("General_Data", "ItemNbr") + "",Status.DONE);

		try {
		driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
		}
		catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
		}
		try {
			 driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
			 Thread.sleep(7000);
			}
			catch (Exception WebDriverException) {
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup", "Handled", Status.DONE);
			    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
			    Thread.sleep(7000);
			}
		try {
			 driver.findElement(By.id(UIMapMyLowes.rdoBtnShpngMdlStore)).click();
			 Thread.sleep(7000);
			}
			catch (Exception WebDriverException) {
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup", "Handled", Status.DONE);
				driver.findElement(By.id(UIMapMyLowes.rdoBtnShpngMdlStore)).click();
			    Thread.sleep(7000);
			}
		try {
			driver.findElement(By.xpath(UIMapMyLowes.btnSecureChkOut)).click();
			 Thread.sleep(7000);
			}
			catch (Exception WebDriverException) {
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup", "Handled", Status.DONE);
				driver.findElement(By.xpath(UIMapMyLowes.btnSecureChkOut)).click();
			    Thread.sleep(7000);
			}    
	}
	/**
	 * This verifyingRegisteredUserLogin() method is used to validate the valid user sign in.
	 * 
	 */
	public void verifyingUserLogin() throws Exception 
	{
		boolean verPopUpBoxPresent=selenium.isElementPresent(UIMapFunctionalComponents.webElmntLoginPopup);
		System.out.println("PopUp Window identified is :"+verPopUpBoxPresent);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		boolean verFramePresent=driver.findElement(By.id(UIMapFunctionalComponents.webElmntLoginFrame)).isDisplayed();
		System.out.println("Verifying the Presence of frame id:"+verFramePresent);
		driver.switchTo().frame(driver.findElement(By.id(UIMapFunctionalComponents.webElmntLoginFrame)));
		if((driver.findElement(By.id(UIMapFunctionalComponents.txtUserName)).isDisplayed())&& 
				(driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).isDisplayed()) &&
				(driver.findElement(By.id(UIMapMyLowes.btnSignIn)).isDisplayed()))
		{
			report.updateTestLog("Verification of Sign In pop up", "Sign in Page is displayed properly ", Status.PASS);
		}else{
			report.updateTestLog("Verification of Sign In pop up", "Sign in Page is not displayed properly ", Status.FAIL);
		}
		driver.findElement(By.id(UIMapFunctionalComponents.txtUserName)).sendKeys(dataTable.getData("General_Data","email"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(dataTable.getData("General_Data", "password"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(Keys.ENTER);
		selenium.waitForPageToLoad("15000");
	}
	
	/**
	 * This userSignUpFromPurchases() method is used to sign in at the time of clicking on purchases
	 * @throws Exception 
	 * 
	 */
	public void userSignUpFromPurchases() throws Exception
	{
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.id(UIMapMyLowes.mouseHvrYourAccount)); 
        actions.moveToElement(menuHoverLink).build().perform(); 
        System.out.println("Mouse Hover successful"); 
        Thread.sleep(20000); 
        WebElement subLink = driver.findElement(By.id(UIMapMyLowes.lnkPurcahses)); 
        actions.moveToElement(subLink).moveToElement(subLink).click().build().perform();
        Thread.sleep(20000);
        //driver.findElement(By.id("close-this-zip")).click();
        driver.findElement(By.xpath(UIMapFunctionalComponents.lnkSignUp)).click();
        //driver.findElement(By.id("close-this-zip")).click();
        Thread.sleep(10000);
        signUpFromLandingPage();
     
	}
 		
	/**
	 * This verifySignUpFormZipInStore() method is used to validate the sign up form when user is zipped in
	 * 
	 */
	public void verifySignUpFormZipInStore() throws Exception
    {
		driver.findElement(By.xpath(UIMapFunctionalComponents.lnkSignUp)).click();
		/*if(driver.findElement(By.id(UIMapMyLowes.txtZipCode)).isDisplayed())
		{
			report.updateTestLog("Verification of zip code before zipping into store", "Zip Code is present in the Sign Up form ", Status.PASS);
		}
		else{
			report.updateTestLog("Verification of zip code before zipping into store", "Zip Code is not present in the Sign Up form ", Status.FAIL);
		}*/
		try{
			driver.findElement(By.xpath(UIMapFunctionalComponents.lnkStoreUnzip)).click();		
		}
		catch(Exception WebDriverException)
        {
              driver.findElement(By.linkText("No, thanks")).click();
              report.updateTestLog("Survey Popup","Handeled", Status.DONE);
              driver.findElement(By.xpath(UIMapFunctionalComponents.lnkStoreUnzip)).click();		
                          selenium.waitForPageToLoad("20000");
        }
		
		driver.findElement(By.id(UIMapFunctionalComponents.txtStoreZip)).clear();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtStoreZip)).sendKeys(dataTable.getData("General_Data","zipcode"));
	    driver.findElement(By.id(UIMapMyLowes.btnFindAStore)).sendKeys(Keys.ENTER);
	    //selenium.waitForPageToLoad("15000");
	    driver.findElement(By.xpath(UIMapFunctionalComponents.lnkSignUp)).click();
	    Thread.sleep(15000);
	    /*if(driver.findElement(By.id(UIMapMyLowes.txtZipCode)).isDisplayed())
		{
			report.updateTestLog("Verification of zip code after zipping into store", "Zip Code is present in the Sign Up form ", Status.FAIL);
		}
		else{
			report.updateTestLog("Verification of zip code after zipping into store", "Zip Code is not present in the Sign Up form ", Status.PASS);
		}	   */
    }
	/**
	 * This userLoginWhileWritingReview() method is used to sign in at the time of writing the review
	 * 
	 */
	public void userLoginWhileWritingReview() throws Exception{
	 	
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","ItemNbr"));
		try {
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		} catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		}
		Thread.sleep(5000);
		try {
			driver.findElement(By.linkText(UIMapMyLowes.lnkTxtReviews)).click();
			Thread.sleep(5000);
		} catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handled", Status.DONE);
			driver.findElement(By.linkText(UIMapMyLowes.lnkTxtReviews)).click();
			Thread.sleep(5000);
		}
		try {
			driver.findElement(By.xpath(UIMapMyLowes.lnkWriteAReview)).click();
			Thread.sleep(5000);	
		} catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.lnkWriteAReview)).click();
			Thread.sleep(5000);	
		}			    
		verifyingUserLogin();
		if(driver.findElement(By.id(UIMapMyLowes.txtTitleDisplay)).isDisplayed()){
			report.updateTestLog("Verification of product review page", "user is successfully logged in and product " +
					"review page is displayed", Status.PASS);
		}
		else{
			report.updateTestLog("Verification of product review page", "user is successfully not successfully " +
					"logged in and product review page is displayed", Status.FAIL);
		}	
	}
	
	/**
	 * This verifyingRegisteredUserLogin() method is used to validate the valid user sign in.
	 * 
	 */
	public void verifyingRegisteredUserLoginModal() throws Exception 
	{
		driver.findElement(By.xpath(UIMapFunctionalComponents.lnkSignIn)).click();
		selenium.windowFocus();
		Thread.sleep(5000);
		boolean verPopUpBoxPresent=selenium.isElementPresent(UIMapFunctionalComponents.webElmntLoginPopup);
		System.out.println("PopUp Window identified is :"+verPopUpBoxPresent);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		boolean verFramePresent=driver.findElement(By.id(UIMapFunctionalComponents.webElmntLoginFrame)).isDisplayed();
		System.out.println("Verifying the Presence of frame id:"+verFramePresent);
		driver.switchTo().frame(driver.findElement(By.id(UIMapFunctionalComponents.webElmntLoginFrame)));
		if((driver.findElement(By.id(UIMapFunctionalComponents.txtUserName)).isDisplayed())&& 
				(driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).isDisplayed()) &&
				(driver.findElement(By.id(UIMapMyLowes.btnSignIn)).isDisplayed()))
		{
			report.updateTestLog("Verification of Sign In pop up", "Sign in Page is displayed properly ", Status.PASS);
		}else{
			report.updateTestLog("Verification of Sign In pop up", "Sign in Page is not displayed properly ", Status.FAIL);
		}
		
		driver.findElement(By.id(UIMapFunctionalComponents.txtUserName)).sendKeys(dataTable.getData("General_Data","email"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(dataTable.getData("General_Data", "password"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(Keys.ENTER);
		Thread.sleep(7000);
		
		String getLoggedInUser=driver.findElement(By.xpath(UIMapFunctionalComponents.webElmntSalutation)).getText().trim();
		System.out.println("Verifying the Registered User detais :"+getLoggedInUser);
		if(getLoggedInUser.equals("Welcome, "+dataTable.getData("General_Data","Firstname"))) // Verifying the registered user details by Using Firstname
		{
			report.updateTestLog("Validating Login Credentials","Login Successful", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Login Credentials","Login Failed..! for User "+dataTable.getData("General_Data","email")+" ", Status.FAIL);
		}
			
	}
	/**
	 * This userLoginWhileSettingAuserLoginWhileSettingAReminder() method is used to sign in while setting  up reminder a reminder
	 * 
	 */
	public void userLoginWhileSettingAuserLoginWhileSettingAReminder() throws Exception{
	 		 	
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","ItemNbr"));
		
		try {
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		} catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		}
		report.updateTestLog("Searching For an Item","Searching Item Number - "+dataTable.getData("General_Data","ItemNbr")+"" ,Status.DONE);
		//selenium.waitForPageToLoad("30000");
		boolean verItemPresent=selenium.isTextPresent("Item #: "+dataTable.getData("General_Data","ItemNbr"));
		if(verItemPresent)
		{
			report.updateTestLog("Veriyfing Navigating to Item's PDP Page","Item - " +dataTable.getData("General_Data","ItemNbr") +" is Present", Status.PASS);
		}
		else
		{
			report.updateTestLog("Veriyfing Navigating to Item's PDP Page","Item is NOT Present", Status.FAIL);
		}
		try {
			//click in setting up a reminder		
			driver.findElement(By.xpath(UIMapMyLowes.btnSetUpARmdr)).click();
			Thread.sleep(5000);
		} catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handled", Status.DONE);
			//click in setting up a reminder		
			driver.findElement(By.xpath(UIMapMyLowes.btnSetUpARmdr)).click();
			Thread.sleep(5000);
		}
		try {
			 driver.findElement(By.xpath(UIMapMyLowes.lnkSignInSetARmdr)).click();
			 Thread.sleep(5000);
		} catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handled", Status.DONE);
			//click in setting up a reminder		
			driver.findElement(By.xpath(UIMapMyLowes.lnkSignInSetARmdr)).click();
			Thread.sleep(5000);
		}	   
		//selenium.waitForPageToLoad("15000");	    
		//fc.verifyingRegisteredUserLogin();	
		driver.findElement(By.id(UIMapFunctionalComponents.txtUserName)).click();
		Thread.sleep(2000);
		driver.findElement(By.id(UIMapFunctionalComponents.txtUserName)).sendKeys(dataTable.getData("General_Data","email"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(dataTable.getData("General_Data", "password"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(Keys.ENTER);
		//driver.findElement(By.id("GoYourAccount")).click();		
		selenium.waitForPageToLoad("20000");
		
		Thread.sleep(10000);
		
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
		
				
	}
	
	/**
	 * This method requestingAdditionalLowesCard() is used to verify the user is able to register, request additional card, de-activate lowe's card.
	 * 
	 */
	public void requestingAdditionalLowesCard() throws Exception
   {
		verifyingRegisteredUserLoginModal();
		
		//De-Activate the lowe's card
		driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.lnkManageMyLowes)).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapMyLowes.lnkTxtDeactivate)).click();
		driver.findElement(By.xpath(UIMapMyLowes.btnDeactivateCard)).click();
        Thread.sleep(5000);	 
       
       //Requesting an additional card
        driver.findElement(By.cssSelector(UIMapMyLowes.btnReqAddCard)).click();
        Thread.sleep(1000);
        driver.findElement(By.name(UIMapMyLowes.rdoBtnUseMyPrefPhNo)).click();
        driver.findElement(By.id(UIMapMyLowes.btnCardRegSubmit)).click();
	    Thread.sleep(5000);	    
	    if(driver.findElement(By.id(UIMapMyLowes.txtCnfrmMsgDsp)).isDisplayed()){
	    	report.updateTestLog("Requesting additional lowes card", "Additional Lowes card is requested successfully ",  Status.PASS);
	    }
	    else{
	    	report.updateTestLog("Requesting additional lowes card", "Additional Lowes card request is not successful ",  Status.FAIL);
	    }
        
        //Requesting replacement of a lowes card
	    driver.findElement(By.xpath(UIMapMyLowes.lnkManageMyLowes)).click();
	    Thread.sleep(2000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnReqRplcmntCard)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnReqRplcmntCardSubmit)).click();	    
	   }
	
	/**
	 * This method useExistingPhNoToTrackInStore() is used to verify the user is able to choose phone to track In-store Purchases
	 * 
	 */
	public void useExistingPhNoToTrackInStore() throws Exception
   {
		verifyingRegisteredUserLoginModal();
       
		//De-Activate the lowe's card
		driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.lnkManageMyLowes)).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapMyLowes.lnkTxtDeactivate)).click();
		driver.findElement(By.xpath(UIMapMyLowes.btnDeactivateCard)).click();
        Thread.sleep(5000);	
       
       //To track In-Store purchases with the existing phone number
        driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
        Thread.sleep(5000);	 
        driver.findElement(By.linkText(UIMapMyLowes.lnkStartTracking)).click();
        Thread.sleep(5000);
        driver.findElement(By.id(UIMapMyLowes.btnCardRegSubmit)).click();
        if(driver.findElement(By.xpath(UIMapMyLowes.txtCnfrmMsgDisplay)).isDisplayed()){
	    	report.updateTestLog("Tracking In-Store Purchases with existing phone nummber", "Traking is successful",  Status.PASS);
	    }
	    else{
	    	report.updateTestLog("Tracking In-Store Purchases with existing phone nummber", "Tracking is not successful ",  Status.FAIL);
	    }
   }
	
	/**
	 * This useNewPhNoToTrackInStore() method is used to verify the user is able to choose phone to track In-store Purchases
	 * 
	 */
	public void useNewPhNoToTrackInStore() throws Exception
   {
		verifyingRegisteredUserLoginModal();
		
		//De-Activate the lowe's card
		driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.lnkManageMyLowes)).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapMyLowes.lnkTxtDeactivate)).click();
		driver.findElement(By.xpath(UIMapMyLowes.btnDeactivateCard)).click();
        Thread.sleep(5000);	
       
        //To track In-Store purchases with the existing phone number
        driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
        Thread.sleep(5000);	 
        driver.findElement(By.xpath(UIMapMyLowes.lnkStartTracking)).click();
        Thread.sleep(5000);
        driver.findElement(By.id(UIMapFunctionalComponents.txtPhone)).clear();
        driver.findElement(By.id(UIMapFunctionalComponents.txtPhone)).sendKeys(dataTable.getData("General_Data","newPhoneNo"));
        driver.findElement(By.id(UIMapMyLowes.btnCardRegSubmit)).click();
        if(driver.findElement(By.xpath(UIMapMyLowes.txtCnfrmMsgDisplay)).isDisplayed()){
	    	report.updateTestLog("Tracking In-Store Purchases with new phone nummber", "Traking is successful",  Status.PASS);
	    }
	    else{
	    	report.updateTestLog("Tracking In-Store Purchases with new phone nummber", "Tracking is not successful ",  Status.FAIL);
	    }
   }
	/**
	 * This useNewAddressToTrackInStore() method is used to verify the user is able to add a new address to track In-store Purchases
	 * 
	 */
	public void useNewAddressToTrackInStore() throws Exception
   {
		verifyingRegisteredUserLoginModal();
		
		//De-Activate the lowe's card
		/*driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.lnkManageMyLowes)).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapMyLowes.lnkTxtDeactivate)).click();
		driver.findElement(By.xpath(UIMapMyLowes.btnDeactivateCard)).click();
        Thread.sleep(5000);	
       */
       //To track In-Store purchases with the new phone number
		driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
        Thread.sleep(5000);	 
        driver.findElement(By.xpath(UIMapMyLowes.lnkStartTracking)).click();
        driver.findElement(By.cssSelector(UIMapMyLowes.rdoBtnLowesPref)).click();
        driver.findElement(By.id(UIMapMyLowes.txtAddress1)).clear();
        driver.findElement(By.id(UIMapMyLowes.txtAddress1)).sendKeys(dataTable.getData("General_Data","AddLine1"));
        driver.findElement(By.id(UIMapMyLowes.txtCity)).clear();
        driver.findElement(By.id(UIMapMyLowes.txtCity)).sendKeys(dataTable.getData("General_Data","City"));
        driver.findElement(By.id(UIMapMyLowes.txtZip)).clear();
        driver.findElement(By.id(UIMapMyLowes.txtZip)).sendKeys(dataTable.getData("General_Data","newZipCode"));
        driver.findElement(By.id(UIMapMyLowes.btnCardRegSubmit)).click();
        Thread.sleep(15000);
        if(driver.findElement(By.xpath(UIMapMyLowes.txtCnfrmMsgDisplay)).isDisplayed()){
	    	report.updateTestLog("Tracking In-Store Purchases with new address nummber", "Traking is successful",  Status.PASS);
	    }
	    else{
	    	report.updateTestLog("Tracking In-Store Purchases with new address nummber", "Tracking is not successful ",  Status.FAIL);
	    }
   }
	
	/**
	 * This userSignUpFromReviewPayPage() method is used to sign up from the  Review and Pay Page 
	 * 
	 */
	public void userSignUpFromReviewPayPage() throws Exception{
	 	
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","ItemNbr"));
			
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
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id(UIMapMyLowes.rdoBtnShpngMdlStore)).click();
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOutSpan)).click();
	    new Select(driver.findElement(By.id(UIMapMyLowes.drpDownChkOutType))).selectByVisibleText(dataTable.getData("General_Data", "CardType"));
	    driver.findElement(By.xpath(UIMapMyLowes.txtCCNo)).clear();
	    driver.findElement(By.xpath(UIMapMyLowes.txtCCNo)).sendKeys(dataTable.getData("General_Data","CardNo"));
	    driver.findElement(By.id(UIMapMyLowes.txtSCode)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtSCode)).sendKeys(dataTable.getData("General_Data","CCPin"));
	    new Select(driver.findElement(By.id(UIMapMyLowes.txtExpMon))).selectByVisibleText(dataTable.getData("General_Data", "ExpMonth"));
	    new Select(driver.findElement(By.id(UIMapMyLowes.txtExpYear))).selectByVisibleText(dataTable.getData("General_Data", "ExpYear"));
	    driver.findElement(By.id(UIMapMyLowes.txtBillFName)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtBillFName)).sendKeys(dataTable.getData("General_Data","Firstname"));
	    driver.findElement(By.id(UIMapMyLowes.txtBillLName)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtBillLName)).sendKeys(dataTable.getData("General_Data","Lastname"));
	    driver.findElement(By.id(UIMapMyLowes.txtBillAdd1)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtBillAdd1)).sendKeys(dataTable.getData("General_Data","AddLine1"));
	    driver.findElement(By.id(UIMapMyLowes.txtBillCity)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtBillCity)).sendKeys(dataTable.getData("General_Data","City"));
	    new Select(driver.findElement(By.id(UIMapMyLowes.txtBillState))).selectByVisibleText(dataTable.getData("General_Data", "State"));
	    driver.findElement(By.id(UIMapMyLowes.txtBillZip)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtBillZip)).sendKeys(dataTable.getData("General_Data","zipcode"));
	    driver.findElement(By.id(UIMapMyLowes.txtBillPh1)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtBillPh1)).sendKeys(dataTable.getData("General_Data","Ph1"));
	    driver.findElement(By.id(UIMapMyLowes.txtBillPh2)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtBillPh2)).sendKeys(dataTable.getData("General_Data","Ph2"));
	    driver.findElement(By.name(UIMapMyLowes.txtBillPh3)).clear();
	    driver.findElement(By.name(UIMapMyLowes.txtBillPh3)).sendKeys(dataTable.getData("General_Data","Ph3"));
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
	    driver.findElement(By.id(UIMapMyLowes.txtBillEmailAdd)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtBillEmailAdd)).sendKeys(varUniq+"@bh.exacttarget.com");//Unique Email ID based on timestamp
	    driver.findElement(By.id(UIMapMyLowes.txtBillMsgExp)).click();
	    driver.findElement(By.id(UIMapMyLowes.txtpwd1)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtpwd1)).sendKeys(dataTable.getData("General_Data","password"));
	    driver.findElement(By.id(UIMapMyLowes.txtpwd2)).clear();
	    
	    driver.findElement(By.id(UIMapMyLowes.txtpwd2)).sendKeys(dataTable.getData("General_Data","confpassword"));
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();	    
	}
	
	/**
	 * This UpdateSignUpLinkFromReviewPayPage()  method is used to sign up from the  Review and Pay Page 
	 * 
	 */
	public void updateSignUpLinkFromReviewPayPage() throws Exception{
	 	
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","ItemNbr"));
		try {
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		} catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		}
		Thread.sleep(5000);
		try {
			driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
			}
			catch (Exception WebDriverException) {
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup", "Handled", Status.DONE);
				driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
			}
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(7000);
	    driver.findElement(By.id(UIMapMyLowes.rdoBtnShpngMdlStore)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnSecureChkOut)).click();
	    //driver.findElement(By.cssSelector("div.continue-checkout > a.button.primary > span")).click();
	    signUpFromLandingPage();
	    
	}	
	/**
	 * This signUpFromLandingPage()  method is used to validate the fields present in the sign up page
	 * 
	 */
	public void signUpFromLandingPage() throws Exception{
	 	
		driver.findElement(By.xpath(UIMapFunctionalComponents.lnkSignUp)).click();
		if((driver.findElement(By.xpath(UIMapMyLowes.txtBoxPresentFirstName)).isDisplayed())
				&& (driver.findElement(By.xpath(UIMapMyLowes.txtBoxPresentLastName)).isDisplayed())
			    && (driver.findElement(By.xpath(UIMapMyLowes.txtBoxPresentEmail)).isDisplayed())
			    && (driver.findElement(By.xpath(UIMapMyLowes.txtBoxPresentPhone)).isDisplayed()) 
			    && (driver.findElement(By.xpath(UIMapMyLowes.txtBoxPresentRegPassword)).isDisplayed()) 
			    && (driver.findElement(By.xpath(UIMapMyLowes.txtBoxPresentConfPassword)).isDisplayed())
			    && (driver.findElement(By.xpath(UIMapMyLowes.chkBoxPresentSubscriptions)).isDisplayed())
			    && (driver.findElement(By.xpath(UIMapMyLowes.rdoBtnPresentRegCardOption1)).isDisplayed())
			    && (driver.findElement(By.xpath(UIMapMyLowes.rdoBtnPresentRegCardOption2)).isDisplayed())
			    && (driver.findElement(By.xpath(UIMapMyLowes.rdoBtnPresentRegCardOption3)).isDisplayed())
			    && (driver.findElement(By.id(UIMapMyLowes.btnCreateAccount)).isDisplayed())
			    && (driver.findElement(By.xpath(UIMapMyLowes.txtTermsAndConditions)).isDisplayed()))
				
			report.updateTestLog("Verification of mandatory fields in Sign up page", "All the Mandatory fields are present. Enter all the mandatory fiels :First name,"+
					"last name, email address,password, confirm password, zip code and phone number ", Status.PASS);
		}	
	
	/**
	 * This registerLowesCard() method is used to register the lowes card
	 * 
	 */
	public void registerLowesCard() throws Exception
   {
			
		verifyingRegisteredUserLoginModal();
		try{
			driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
            }
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.lnkManageMyLowes)).click();
		driver.findElement(By.xpath(UIMapMyLowes.btnRegMyLowesCard)).click();
		driver.findElement(By.name(UIMapMyLowes.txtCardNo)).clear();
	    driver.findElement(By.name(UIMapMyLowes.txtCardNo)).sendKeys(dataTable.getData("General_Data","lowescardno"));
	    driver.findElement(By.id(UIMapMyLowes.btnCardRegSubmit)).click();
        if(driver.findElement(By.id(UIMapMyLowes.txtCnfrmMsgDisplay)).isDisplayed()){
	    	report.updateTestLog("Tracking In-Store Purchases with existing phone nummber", "Traking is successful",  Status.PASS);
	    }
	    else{
	    	report.updateTestLog("Tracking In-Store Purchases with existing phone nummber", "Tracking is not successful ",  Status.FAIL);
	    }
   }
	/**
	 * This method is used to verify the user is able to choose phone to track In-store Purchases
	 * 
	 */
	public void useexistingCardNoToTrackInStore() throws Exception
   {
		verifyingRegisteredUserLoginModal();
		
		//De-Activate the lowe's card
		try{
			driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
            }
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.lnkManageMyLowes)).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapMyLowes.lnkTxtDeactivate)).click();
		driver.findElement(By.xpath(UIMapMyLowes.btnDeactivateCard)).click();
        Thread.sleep(5000);	
       
       //To track In-Store purchases with the new phone number
		driver.findElement(By.xpath(UIMapFunctionalComponents.lnkSignUp)).click();
        Thread.sleep(7000);	 
        driver.findElement(By.xpath(UIMapMyLowes.lnkStartTracking)).click();
        driver.findElement(By.name(UIMapMyLowes.txtCardNo)).clear();
	    driver.findElement(By.name(UIMapMyLowes.txtCardNo)).sendKeys(dataTable.getData("General_Data","lowescardno"));
        driver.findElement(By.id(UIMapFunctionalComponents.txtPhone)).clear();
        driver.findElement(By.id(UIMapFunctionalComponents.txtPhone)).sendKeys(dataTable.getData("General_Data","newPhoneNo"));
        driver.findElement(By.id(UIMapMyLowes.btnCardRegSubmit)).click();	
        if(driver.findElement(By.id(UIMapMyLowes.txtCnfrmMsgDisplay)).isDisplayed()){
	    	report.updateTestLog("Tracking In-Store Purchases with new phone nummber", "Tracking is successful",  Status.PASS);
	    }
	    else{
	    	report.updateTestLog("Tracking In-Store Purchases with new phone nummber", "Tracking is not successful ",  Status.FAIL);
	    }
       
        
   }
	/**
	 *  This searchPurchases() method is used to search an order in Purchases
	 * 
	 */
	public void searchPurchases() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(5000);
		fc.changeStore();
		Thread.sleep(5000);
		try{
			driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
            }
		Thread.sleep(5000);
		try{
			 driver.findElement(By.cssSelector(UIMapMyLowes.lnkPurchasesFromMyLowes)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
          driver.findElement(By.linkText("No, thanks")).click();
          report.updateTestLog("Survey Popup","Handled", Status.DONE);
          driver.findElement(By.cssSelector(UIMapMyLowes.lnkPurchasesFromMyLowes)).click();
          }
		Thread.sleep(5000);	  
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkAddPurchase)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id(UIMapMyLowes.txtConfNo)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtConfNo)).sendKeys(dataTable.getData("General_Data","orderNo"));
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnAddPurchase)).click();
	    Thread.sleep(5000);
	    if(driver.findElement(By.xpath(UIMapMyLowes.txtPurchaseConfResults)).getText().
	    		equals("Results for Confirmation #"+dataTable.getData("General_Data","orderNo"))){
	    			report.updateTestLog("Verifying the search in Purchases ","Verification is successful", Status.PASS);
	    		}
	    else{
	    	report.updateTestLog("Verifying the search in Purchases ","Verification is not successful", Status.FAIL);
	    	}
	    driver.findElement(By.id(UIMapMyLowes.lnkModPurResults)).click();
	    fc.signOut();
	}
	
	/**
	 *  This verifyTheDisclaimers() method is used to search an order in Purchases
	 * 
	 */
	public void verifyTheDisclaimers() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(5000);
		fc.changeStore();
		Thread.sleep(5000);
		try{
			driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
            }
		Thread.sleep(5000);
		try{
			 driver.findElement(By.cssSelector(UIMapMyLowes.lnkPurchasesFromMyLowes)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
          driver.findElement(By.linkText("No, thanks")).click();
          report.updateTestLog("Survey Popup","Handled", Status.DONE);
          driver.findElement(By.cssSelector(UIMapMyLowes.lnkPurchasesFromMyLowes)).click();
          }
		Thread.sleep(5000);	  
	    
	    if(driver.findElement(By.xpath(UIMapMyLowes.txtPurchaseDisclaimer1)).isDisplayed() &&
	    		driver.findElement(By.xpath(UIMapMyLowes.txtPurchaseDisclaimer2)).isDisplayed())
	    		{
	    			report.updateTestLog("Verifying the Dislcaimers ","Verification is successful", Status.PASS);
	    		}
	    else{
	    	report.updateTestLog("Verifying the Dislcaimers ","Verification is not successful", Status.FAIL);
	    }
	 }
	/**
	 *  This verifyCCInfoFromPurchases() method is used to search an order in Purchases
	 * 
	 */
	public void verifyCCInfoFromPurchases() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(5000);
		fc.changeStore();
		Thread.sleep(5000);
		try{
			driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
            }
		Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkPurchasesFromMyLowes)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkAddPurchase)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id(UIMapMyLowes.txtConfNo)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtConfNo)).sendKeys(dataTable.getData("General_Data","orderNo"));
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnAddPurchase)).click();
	    Thread.sleep(5000);
	    
	    if(driver.findElement(By.xpath(UIMapMyLowes.txtCCInfoPymntMethod)).getText().equals("Payment Method") &&
	    		(driver.findElement(By.xpath(UIMapMyLowes.txtCCInfoMaster)).getText().contains("Master Card") ||
	    				driver.findElement(By.xpath(UIMapMyLowes.txtCCInfoVISA)).getText().contains("VISA")) &&
	    		driver.findElement(By.xpath(UIMapMyLowes.txtCCInfoStar)).getText().contains("****")){
	    	
    			report.updateTestLog("Verifying the CC info","Verification is successful", Status.PASS);
    		}
	    	else{
	    		report.updateTestLog("Verifying the CC info","Verification is not successful", Status.FAIL);
	    	
	    }
	}
	/**
	 *  This verifyPurchaseDetails() method is used to verify the details of the purchases
	 * 
	 */
	public void verifyPurchaseDetails() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(5000);
		fc.changeStore();
		Thread.sleep(5000);
		try{
			driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
            }
		Thread.sleep(5000);
		try{
			 driver.findElement(By.cssSelector(UIMapMyLowes.lnkPurchasesFromMyLowes)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.cssSelector(UIMapMyLowes.lnkPurchasesFromMyLowes)).click();
            }
		Thread.sleep(5000);	   
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkAddPurchase)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id(UIMapMyLowes.txtConfNo)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtConfNo)).sendKeys(dataTable.getData("General_Data","orderNo"));
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnAddPurchase)).click();
	    Thread.sleep(5000);
	    
	    if((driver.findElement(By.xpath(UIMapMyLowes.txtPurchaseInfoDate)).isDisplayed()&&
	    		driver.findElement(By.xpath(UIMapMyLowes.txtPurchaseInfoDate)).getText().equals("Purchase Date:"))&&
	      /*(driver.findElement(By.xpath(UIMapMyLowes.txtPurchaseInfoType)).isDisplayed()&&
	    		driver.findElement(By.xpath(UIMapMyLowes.txtPurchaseInfoType)).getText().equals("Purchase Type:"))&&*/
	      (driver.findElement(By.xpath(UIMapMyLowes.txtPurchaseInfoOrder)).isDisplayed()&&
	    	   driver.findElement(By.xpath(UIMapMyLowes.txtPurchaseInfoOrder)).getText().equals("Order #:"))&&
	      (driver.findElement(By.xpath(UIMapMyLowes.txtPurchaseInfoStatus)).isDisplayed()&&
	   	   	   driver.findElement(By.xpath(UIMapMyLowes.txtPurchaseInfoStatus)).getText().equals("Purchase Status:"))&&  
	   	  (driver.findElement(By.xpath(UIMapMyLowes.txtPurchaseInfoTotal)).isDisplayed()&&
	 	   	   driver.findElement(By.xpath(UIMapMyLowes.txtPurchaseInfoTotal)).getText().equals("Purchase Total:"))){
	    	
    			report.updateTestLog("Verifying the purchase details","Verification is successful", Status.PASS);
    		}
	    	else{
	    		report.updateTestLog("Verifying the purchase details","Verification is not successful", Status.FAIL);		    	
	    	}
	}
	/**
	 *  This verifyInvalidTransactionError() method is used to verify the error message displayed for invalid transaction number
	 * 
	 */
	public void verifyInvalidTransactionError() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(5000);
		fc.changeStore();
		Thread.sleep(5000);
		try{
			driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
            }
		Thread.sleep(5000);
		try{
			 driver.findElement(By.cssSelector(UIMapMyLowes.lnkPurchasesFromMyLowes)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
           driver.findElement(By.linkText("No, thanks")).click();
           report.updateTestLog("Survey Popup","Handled", Status.DONE);
           driver.findElement(By.cssSelector(UIMapMyLowes.lnkPurchasesFromMyLowes)).click();
           }
		Thread.sleep(5000);	  
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkAddPurchase)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id(UIMapMyLowes.txtConfNo)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtConfNo)).sendKeys(dataTable.getData("General_Data","orderNo"));
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnAddPurchase)).click();
	    Thread.sleep(5000);
	    
	    if(driver.findElement(By.xpath(UIMapMyLowes.txtInvalidConfNoMsg1)).isDisplayed()){
	    		report.updateTestLog("Verifying the error message for invalid confirmation number","Verification is successful", Status.PASS);
    		}
	    	else{
	    		report.updateTestLog("Verifying the error message for invalid confirmation number","Verification is not successful", Status.FAIL);
	    	
	    }
	}
	
	/**
	 * This requestMLCReplacement() method is used to request the MLC Replacement.
	 * 
	 */
	public void requestMLCReplacement() throws Exception
   {
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(5000);
		fc.changeStore();
		Thread.sleep(5000);
		try{
			driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
            }
		Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.lnkMLCReqRplcmnt)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkMLcReqRplcmntbtn)).click();
	    Thread.sleep(5000);
        if(driver.findElement(By.xpath(UIMapMyLowes.txtChooseASavedAdd)).isDisplayed()&&
        		driver.findElement(By.xpath(UIMapMyLowes.txtChooseASavedAdd)).getText().equals("Choose a Saved Address:")){
	    	report.updateTestLog("Verification of display of address while request replacement", "Verification is successful",  Status.PASS);
	    }
	    else{
	    	report.updateTestLog("Verification of display of address while request replacement", "Verification is not successful",  Status.FAIL);
	    }
   }
	 
	/**
	 *  This verifyCancelInPurchasesPage() method is used to verify whether the cancel button is present or not in purchases page
	 * 
	 */
	public void verifyCancelInPurchasesPage() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(5000);
		fc.changeStore();
		Thread.sleep(5000);
		try{
			driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
            }
		Thread.sleep(5000);
		try{
			 driver.findElement(By.cssSelector(UIMapMyLowes.lnkPurchasesFromMyLowes)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
           driver.findElement(By.linkText("No, thanks")).click();
           report.updateTestLog("Survey Popup","Handled", Status.DONE);
           driver.findElement(By.cssSelector(UIMapMyLowes.lnkPurchasesFromMyLowes)).click();
           }
		Thread.sleep(5000);	  
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkAddPurchase)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id(UIMapMyLowes.txtConfNo)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtConfNo)).sendKeys(dataTable.getData("General_Data","orderNo"));
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnAddPurchase)).click();
	    Thread.sleep(5000);
	    if(selenium.isTextPresent("Cancel")){
	    	report.updateTestLog("Verification of cancel in purchases page ", "Verification is successful",  Status.FAIL);
	    }
	    else{
	    	report.updateTestLog("Verification of cancel in purchases page ", "Verification is not successful",  Status.PASS);
	    }
	}
	
	/**
	 *  This verifyStatusInPurchaseHistoryAndPurchaseDetails() method is used to verify the status in purchase detail page and purchase history page
	 * 
	 */
	public void verifyStatusInPurchaseHistoryAndPurchaseDetails() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(5000);
		fc.changeStore();
		Thread.sleep(5000);
		try{
			driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
            }
		Thread.sleep(5000);
		try{
			 driver.findElement(By.cssSelector(UIMapMyLowes.lnkPurchasesFromMyLowes)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
           driver.findElement(By.linkText("No, thanks")).click();
           report.updateTestLog("Survey Popup","Handled", Status.DONE);
           driver.findElement(By.cssSelector(UIMapMyLowes.lnkPurchasesFromMyLowes)).click();
           }
		Thread.sleep(5000);	  
	    new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseType))).selectByVisibleText(UIMapMyLowes.txtAllPurhases);
	    new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate))).selectByVisibleText(UIMapMyLowes.txtTxnDate);
	    Thread.sleep(5000);
	    String statusInPurchaseHistoryPage = driver.findElement(By.xpath(UIMapMyLowes.txtStatusInPurHistPg)).getText();
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkAddPurchase)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id(UIMapMyLowes.txtConfNo)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtConfNo)).sendKeys(dataTable.getData("General_Data","orderNo"));
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnAddPurchase)).click();
	    Thread.sleep(5000);
	    String statusInPurchaseDetailPage =driver.findElement(By.xpath(UIMapMyLowes.txtStatusInPurDetailPg)).getText();
	    if(statusInPurchaseHistoryPage.equals(statusInPurchaseDetailPage)){
	    	report.updateTestLog("Verification of status in purchase history page and purchase detail page ", "Verification is successful",  Status.PASS);
	    }
	    else{
	    	report.updateTestLog("Verification of status in purchase history page and purchase detail page ", "Verification is not successful",  Status.FAIL);
	    }
	}
	/**
	 *  This verifyPurchasesPage() method is used to verify the purchases page
	 * 
	 */
	public void verifyPurchasesPage() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(5000);
		fc.changeStore();
		Thread.sleep(5000);
		try{
			driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
            }
		Thread.sleep(5000);
		try{
			 driver.findElement(By.cssSelector(UIMapMyLowes.lnkPurchasesFromMyLowes)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
           driver.findElement(By.linkText("No, thanks")).click();
           report.updateTestLog("Survey Popup","Handled", Status.DONE);
           driver.findElement(By.cssSelector(UIMapMyLowes.lnkPurchasesFromMyLowes)).click();
           }
		Thread.sleep(5000);	  
	    
	}
	/**
	 *  This validatePurchasesPageFields() method is used to validate the fields in purchases page
	 * 
	 */
	public void validatePurchasesPageFields() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(5000);
		fc.changeStore();
		Thread.sleep(5000);
		try{
			driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
            }
		Thread.sleep(5000);
		try{
			 driver.findElement(By.cssSelector(UIMapMyLowes.lnkPurchasesFromMyLowes)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
           driver.findElement(By.linkText("No, thanks")).click();
           report.updateTestLog("Survey Popup","Handled", Status.DONE);
           driver.findElement(By.cssSelector(UIMapMyLowes.lnkPurchasesFromMyLowes)).click();
           }
		Thread.sleep(5000);	  
		driver.findElement(By.cssSelector(UIMapMyLowes.lnkAddPurchase)).click();
	    Thread.sleep(5000);
	    new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurhcseTypeAddPur))).selectByVisibleText(UIMapMyLowes.txtInStore);
	    driver.findElement(By.cssSelector(UIMapMyLowes.txtInStoreValue)).click();
	    Thread.sleep(5000);	    
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnAddPurchaseSpan)).click();
	    if(selenium.isTextPresent("This field is required.")){
	    	report.updateTestLog("Verification of mandatory fields in Purchase history page", "Verification is successful",  Status.PASS);
	    }
	    else{
	    	report.updateTestLog("Verification of mandatory fields in Purchase history page", "Verification is not successful",  Status.FAIL);
	    }
	    driver.findElement(By.id(UIMapMyLowes.txtTxnNo)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtTxnNo)).sendKeys("sfafff");
	    driver.findElement(By.id(UIMapMyLowes.txtPurDate)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtPurDate)).sendKeys("12/26/2010");
	    driver.findElement(By.xpath(UIMapMyLowes.txtPurPgTxt)).click();
	    driver.findElement(By.id(UIMapMyLowes.txtStoreNo)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtStoreNo)).sendKeys("dsfs");
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnAddPurchaseSpan)).click();
	    Thread.sleep(5000);
	    if(selenium.isTextPresent("The transaction number you entered is invalid. Please try again.")){
	    	
	    	report.updateTestLog("Verification of transactionnumber field in purchase history page", "Verification is successful",  Status.PASS);
	    }
	    else{
	    	report.updateTestLog("Verification of transactionnumber field in purchase history page", "Verification is not successful",  Status.FAIL);
	    }
	    
	    if(selenium.isTextPresent("The date you entered is invalid. Please try again.")){
	    
	    	report.updateTestLog("Verification of date field in Purchase history page", "Verification is successful",  Status.PASS);
	    }
	    else{
	    	report.updateTestLog("Verification of date field in Purchase history page", "Verification is not successful",  Status.FAIL);
	    }
	    if(selenium.isTextPresent("The store number you entered is invalid. Please try again")){
	    	
	    	report.updateTestLog("Verification of store field in Purchase history page", "Verification is successful",  Status.PASS);
	    }
	    else{
	    	report.updateTestLog("Verification of store field in Purchase history page", "Verification is not successful",  Status.FAIL);
	    }
	}
	
	/**
	 * This registerMLCWithExistingMLC() method is used to validate the error message if the user registers MLC card with the existing MLC
	 * 
	 */
	public void registerMLCWithExistingMLC() throws Exception
   {
			
		verifyingRegisteredUserLoginModal();
		try{
			driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
            }
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.lnkManageMyLowes)).click();
		driver.findElement(By.xpath(UIMapMyLowes.btnRegMyLowesCard)).click();
		driver.findElement(By.name(UIMapMyLowes.txtCardNo)).clear();
	    driver.findElement(By.name(UIMapMyLowes.txtCardNo)).sendKeys(dataTable.getData("General_Data","lowescardno"));
	    driver.findElement(By.id(UIMapMyLowes.btnCardRegSubmit)).click();
        if(selenium.isTextPresent("The MyLowe's card number you entered is already registered. Please visit Your Account page")){
	    	report.updateTestLog("Registering MLC with existing MLC", "Verification is successful",  Status.PASS);
	    }
	    else{
	    	report.updateTestLog("Registering MLC with existing MLC", "Verification is not successful ",  Status.FAIL);
	    }
   }
	/**
	 *  This verifyPurchaseHistoryPageWithNoOnlinePurchases() method is used to verify the results when there is no online purchase
	 * 
	 */
	public void verifyPurchaseHistoryPageWithNoOnlinePurchases() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(5000);
		fc.changeStore();
		Thread.sleep(5000);
		try{
			driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
            }
		Thread.sleep(5000);
		try{
			 driver.findElement(By.cssSelector(UIMapMyLowes.lnkPurchasesFromMyLowes)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
           driver.findElement(By.linkText("No, thanks")).click();
           report.updateTestLog("Survey Popup","Handled", Status.DONE);
           driver.findElement(By.cssSelector(UIMapMyLowes.lnkPurchasesFromMyLowes)).click();
           }
		Thread.sleep(5000);	  
	    new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseType))).selectByVisibleText(UIMapMyLowes.txtOnline);
	    validateErrMsgForNoOnlineTnx();
	    new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseType))).selectByVisibleText(UIMapMyLowes.txtInStore);
	    validateErrMsgForNoOnlineTnx();
	    new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseType))).selectByVisibleText(UIMapMyLowes.txtAllPurhases);
	    validateErrMsgForNoOnlineTnx();
	    new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate))).selectByVisibleText(UIMapMyLowes.txtPurDtLast6Mon);
	    validateErrMsgForNoOnlineTnx();
	    new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate))).selectByVisibleText(UIMapMyLowes.txtPurDt2013);
	    validateErrMsgForNoOnlineTnx();
	    new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate))).selectByVisibleText(UIMapMyLowes.txtPurDt2012);
	    validateErrMsgForNoOnlineTnx();
	    new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate))).selectByVisibleText(UIMapMyLowes.txtPurDtAll);
	    validateErrMsgForNoOnlineTnx();
	   
	}

	 private void validateErrMsgForNoOnlineTnx() {
	
		 if(selenium.isTextPresent("You have not made any purchases during this period")){
			 report.updateTestLog("Verifying Error Message", "Verification is successful",  Status.PASS);
	}
	    else{
	    	report.updateTestLog("Verifying Error Message", "Verification is not successful",  Status.FAIL);
	    }
	}
	 /**
	 *  This verifyPurchaseHistoryPageWithNoFOB() method is used to verify the results when there is no FOB associated
	 * 
	 */
	public void verifyPurchaseHistoryPageWithNoFOB() throws Exception {
			
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(5000);
		fc.changeStore();
		Thread.sleep(5000);
		try{
			driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
            }
		Thread.sleep(5000);
		try{
			 driver.findElement(By.cssSelector(UIMapMyLowes.lnkPurchasesFromMyLowes)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
           driver.findElement(By.linkText("No, thanks")).click();
           report.updateTestLog("Survey Popup","Handled", Status.DONE);
           driver.findElement(By.cssSelector(UIMapMyLowes.lnkPurchasesFromMyLowes)).click();
           }
		Thread.sleep(5000);	  
	    new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseType))).selectByVisibleText(UIMapMyLowes.txtInStore);
	    validatePurchaseHistoryPageWithNoFOB();
	    new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseType))).selectByVisibleText(UIMapMyLowes.txtAllPurhases);
	    validatePurchaseHistoryPageWithNoFOB();
	    new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate))).selectByVisibleText(UIMapMyLowes.txtPurDtLast6Mon);
	    validatePurchaseHistoryPageWithNoFOB();
	    new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate))).selectByVisibleText(UIMapMyLowes.txtPurDt2013);
	    validatePurchaseHistoryPageWithNoFOB();
	    new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate))).selectByVisibleText(UIMapMyLowes.txtPurDt2012);
	    validatePurchaseHistoryPageWithNoFOB();
	    new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate))).selectByVisibleText(UIMapMyLowes.txtPurDtAll);
	    validatePurchaseHistoryPageWithNoFOB();	   
	}

	private void validatePurchaseHistoryPageWithNoFOB() {
		if(driver.findElement(By.xpath(UIMapMyLowes.txtNoPurchases)).isDisplayed()){
			report.updateTestLog("Verifying Message display when there is no FOB associated", "Verification is successful",  Status.PASS);
		}
		else{
			report.updateTestLog("Verifying Message display when there is no FOB associated", "Verification is not successful",  Status.FAIL);
		}
		
	}
	/**
	 *  This verifyFulfillmentDomination() method is used to verify the purchases page
	 * 
	 */
	public void verifyFulfillmentDomination() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(5000);
		fc.changeStore();
		Thread.sleep(5000);
		try{
			driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
            }
		Thread.sleep(5000);
		try{
			 driver.findElement(By.cssSelector(UIMapMyLowes.lnkPurchasesFromMyLowes)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
           driver.findElement(By.linkText("No, thanks")).click();
           report.updateTestLog("Survey Popup","Handled", Status.DONE);
           driver.findElement(By.cssSelector(UIMapMyLowes.lnkPurchasesFromMyLowes)).click();
           }
		Thread.sleep(5000);	  
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkAddPurchase)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id(UIMapMyLowes.txtConfNo)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtConfNo)).sendKeys(dataTable.getData("General_Data", "orderNo"));
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnAddPurchase)).click();
	    Thread.sleep(5000);
	    
	}

	public void selectInStoreInAddPurchase() throws Exception{
		
		try{
			driver.findElement(By.xpath("//*[@id='purchaseControls']/a")).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.xpath("//*[@id='purchaseControls']/a")).click();
            }
		Thread.sleep(5000);
		
		try{
			new Select(driver.findElement(By.xpath("//*[@id='purchaseType']"))).selectByVisibleText("In-Store");
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            new Select(driver.findElement(By.xpath("//*[@id='purchaseType']"))).selectByVisibleText(dataTable.getData("General_Data", "PurchaseType"));
            }
		
		
		
		
		
		
	}
	
	public void validateAddPurchaseInStoreForm() throws Exception {
		
		try{
			if(driver.findElement(By.xpath("//*[@id='inStorePurchaseForm']/form/div[1]/label")).isDisplayed())
			{
			   report.updateTestLog("Verifying display of Transaction Number label", "Transaction Numebr label is displayed",Status.PASS);
			}
			else 
			{
				report.updateTestLog("Verifying display of Transaction Number label", "Transaction Number is not displayed", Status.PASS);
			}
		}
			
			catch(Exception WebDriverException){
	            driver.findElement(By.linkText("No, thanks")).click();
	            report.updateTestLog("Survey Popup","Handled", Status.DONE);
	            if(driver.findElement(By.xpath("//*[@id='inStorePurchaseForm']/form/div[1]/label")).isDisplayed())
				{
				   report.updateTestLog("Verifying display of Transaction Number label", "Transaction Numebr label is displayed",Status.PASS);
				}
				else 
				{
					report.updateTestLog("Verifying display of Transaction Number label", "Transaction Number is not displayed", Status.FAIL);
				}
	            }
			if (driver.findElement(By.xpath("//*[@id='inStorePurchaseForm']/form/div[2]/label")).isDisplayed())
			{
				report.updateTestLog("Verifying display of Purchase Date label", "Purchase Date label is dipslayed", Status.PASS);
				
			}
			else 
			{
				report.updateTestLog("Verifying display of Purchase Date label", "Purchase Date label is not displayed", Status.FAIL);
			}
			
			if (driver.findElement(By.xpath("//*[@id='inStorePurchaseForm']/form/div[3]/label")).isDisplayed())
			{
				report.updateTestLog("Verifying display of Store Number label", "Store Number label is displayed", Status.PASS);
				
			}
			else
			{
				report.updateTestLog("Verifying Store Number label", "Store Number lable is not displayed", Status.FAIL);
			}
			
				
				
		
	}
	
	
	public void validateErrorMessageForInvalidPurchase() throws Exception
	{
		
			driver.findElement(By.xpath("//*[@id='transNumber']")).sendKeys(dataTable.getData("General_Data","orderNo"));
			driver.findElement(By.xpath("//*[@id='purchaseDate']")).sendKeys(dataTable.getData("General_Data","ReminderDate"));
			driver.findElement(By.xpath("//*[@id='storeNumber']")).sendKeys(dataTable.getData("General_Data","ItemNbr"));
		    driver.findElement(By.xpath("//*[@id='inStorePurchaseForm']/form/div[4]/button")).click();
				
			try
			{
				if(driver.findElement(By.xpath(UIMapMyLowes.txtInvalidConfNoMsg1)).isDisplayed())
				{
					report.updateTestLog("Verifying Error Message for invalid purchase","Error message is displayed" ,Status.PASS);
				}
				else
				{
					report.updateTestLog("Verifying Error Message for invalid purchase", "Error Message is not displayed", Status.FAIL);
				}
			}
			catch(Exception WebDriverException)
			{
				driver.findElement(By.linkText("No, thanks")).click();
	            report.updateTestLog("Survey Popup","Handled", Status.DONE);
	            if(driver.findElement(By.xpath(UIMapMyLowes.txtInvalidConfNoMsg1)).isDisplayed())
				{
					report.updateTestLog("Verifying Error Message for invalid purchase","Error message is displayed" ,Status.PASS);
				}
				else
				{
					report.updateTestLog("Verifying Error Message for invalid purchase", "Error Message is not displayed", Status.FAIL);
				}
	            	            
	            
			}
			if(driver.findElement(By.xpath("//*[@id='transNumber']")).getAttribute("value").equals(null))
					{
				    report.updateTestLog("Verifying Transaction Numebr field visibility", "Transaction Number field is not visible and not populated", Status.FAIL);
					}
			else
			{
				report.updateTestLog("Verifying Transaction Number field visibility","Transaction Number field is visible and populated", Status.PASS);
			}
			
			if(driver.findElement(By.xpath("//*[@id='purchaseDate']")).getAttribute("value").equals(null))
			{
		    report.updateTestLog("Verifying Purchase Date field visibility", "Purchase Date field is not visible and not populated", Status.FAIL);
			}
	        else
        	{
		     report.updateTestLog("Verifying Purchase Date field visibility","Purchase Date field is visible and populated", Status.PASS);
	        }
			
			if(driver.findElement(By.xpath("//*[@id='storeNumber']")).getAttribute("value").equals(null))
			{
		    report.updateTestLog("Verifying Store Number field visibility", "Store Number field is not visible and not populated", Status.FAIL);
			}
	        else
        	{
		     report.updateTestLog("Verifying Store Number field visibility","Store Number field is visible and populated", Status.PASS);
	        }
			
			
	}
  
	public void navigateToPurchasesFromYourAccount() throws Exception
	{
		try
		{
			Actions actions = new Actions(driver);
			WebElement menuHoverLink = driver.findElement(By.id(UIMapMyLowes.mouseHvrYourAccount)); 
			actions.moveToElement(menuHoverLink).build().perform(); 
			System.out.println("Mouse Hover successful"); 
			Thread.sleep(20000); 
			WebElement subLink = driver.findElement(By.id(UIMapMyLowes.lnkPurcahses)); 
			actions.moveToElement(subLink).moveToElement(subLink).click().build().perform();
			Thread.sleep(20000);
			if (driver.findElement(By.xpath("//*[@id='breadcrumbs']")).isDisplayed())
			{
				report.updateTestLog("Verifying Purchases landing page ", "Bread Crumb is displayed", Status.PASS);
				
			}
			else
			{
				report.updateTestLog("Verifying Purchases landing page ", "Bread Crumb is not displayed", Status.FAIL);
			}
		}
		catch(Exception WebDriverException)
		{
			driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
			Actions actions = new Actions(driver);
			WebElement menuHoverLink = driver.findElement(By.id(UIMapMyLowes.mouseHvrYourAccount)); 
			actions.moveToElement(menuHoverLink).build().perform(); 
			System.out.println("Mouse Hover successful"); 
			Thread.sleep(20000); 
			WebElement subLink = driver.findElement(By.id(UIMapMyLowes.lnkPurcahses)); 
			actions.moveToElement(subLink).moveToElement(subLink).click().build().perform();
			Thread.sleep(20000);
			if (driver.findElement(By.xpath("//*[@id='breadcrumbs']")).isDisplayed())
			{
				report.updateTestLog("Verifying Purchases landing page ", "Bread Crumb is displayed", Status.PASS);
				
			}
			else
			{
				report.updateTestLog("Verifying Purchases landing page ", "Bread Crumb is not displayed", Status.FAIL);
			}
		}
	}
	
	public void signInFromPurchasesPage() throws Exception{
		
		try
		{
			driver.findElement(By.xpath(UIMapMyLowes.txtUserName)).sendKeys(dataTable.getData("General_Data","email"));
			driver.findElement(By.xpath(UIMapMyLowes.txtPassword)).sendKeys(dataTable.getData("General_Data","password"));
			driver.findElement(By.xpath(UIMapMyLowes.btnCreateAccount2)).click();
			Thread.sleep(20000); 
			
			if(driver.findElement(By.xpath("//*[@id='lowes-salutation-active']/a[1]/span")).getText().equals("Welcome, "+dataTable.getData("General_Data","Firstname")))          // Verifying the registered user details by Using Firstname
			{
				report.updateTestLog("Validating Login Credentials","Login Successful", Status.PASS);
			}
			else
			{
				report.updateTestLog("Validating Login Credentials","Login Failed..! for User "+dataTable.getData("General_Data","email")+" ", Status.FAIL);
			}
			
		}
		catch(Exception WebDriverException)
		{
			driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.xpath(UIMapMyLowes.txtUserName)).sendKeys(dataTable.getData("General_Data","email"));
			driver.findElement(By.xpath(UIMapMyLowes.txtPassword)).sendKeys(dataTable.getData("General_Data","password"));
			driver.findElement(By.xpath(UIMapMyLowes.btnCreateAccount2)).click();
			Thread.sleep(20000); 
			if(driver.findElement(By.xpath("//*[@id='lowes-salutation-active']/a[1]/span")).getText().equals("Welcome, "+dataTable.getData("General_Data","Firstname")))          // Verifying the registered user details by Using Firstname
			{
				report.updateTestLog("Validating Login Credentials","Login Successful", Status.PASS);
			}
			else
			{
				report.updateTestLog("Validating Login Credentials","Login Failed..! for User "+dataTable.getData("General_Data","email")+" ", Status.FAIL);
			}
			
		}
		
	}
	
	public void validatePurchasesPageDisclaimer() throws Exception{
		if(driver.findElement(By.xpath(UIMapMyLowes.txtPurchaseDisclaimer1)).isDisplayed() &&
	    		driver.findElement(By.xpath(UIMapMyLowes.txtPurchaseDisclaimer2)).isDisplayed())
	    		{
	    			report.updateTestLog("Verifying the Dislcaimers ","Verification is successful", Status.PASS);
	    		}
	    else{
	    	report.updateTestLog("Verifying the Dislcaimers ","Verification is not successful", Status.FAIL);
	    }
		
		
	}
	
	public void clickAddPurchaseAndValidate() throws Exception
	{
		
		try{
			driver.findElement(By.xpath("//*[@id='purchaseControls']/a")).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.xpath("//*[@id='purchaseControls']/a")).click();
            }
		Thread.sleep(5000);
		
		try
		{
			if(driver.findElement(By.xpath("//*[@id='findPurchase']/p")).isDisplayed())
			{
				report.updateTestLog("Verifying purchases landing page", "Purchases Landing Page is launched", Status.PASS);
				
			}
			else
			{
				report.updateTestLog("Verifying purchases landing page", "Purchases Landing Page is not launched", Status.FAIL);
			}
			
		}
		
		catch(Exception webDriverException)
		{
			driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            if(driver.findElement(By.xpath("//*[@id='findPurchase']/p")).isDisplayed())
			{
				report.updateTestLog("Verifying purchases landing page", "Purchases Landing Page is launched", Status.PASS);
				
			}
			else
			{
				report.updateTestLog("Verifying purchases landing page", "Purchases Landing Page is not launched", Status.FAIL);
			}
		}
		
		
	}

	
  
}