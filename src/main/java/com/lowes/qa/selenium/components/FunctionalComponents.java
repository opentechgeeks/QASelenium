package com.lowes.qa.selenium.components;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.cognizant.framework.Status;
import com.lowes.qa.selenium.support.DriverScript;
import com.lowes.qa.selenium.support.ReusableLibrary;
import com.lowes.qa.selenium.support.ScriptHelper;
import com.lowes.qa.selenium.uimap.UIMapFunctionalComponents;
import com.lowes.qa.selenium.uimap.UIMapMyLowes;
import com.lowes.qa.selenium.uimap.UIMapProductSearch;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

/**
 * Functional Components class
 * 
 * @author Infosys
 */
public class FunctionalComponents extends ReusableLibrary
{
	
	/**
	 * Constructor to initialize the component library
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link DriverScript}
	 */
	
	String baseurl = dataTable.getData("General_Data", "URL");
	Selenium selenium = new WebDriverBackedSelenium(driver, baseurl);
	public FunctionalComponents(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
	}
	
	public void openLowesApplication() throws Exception
	{
		driver.manage().window().maximize();
		//driver.get(baseurl);
		System.out.println(dataTable.getData("General_Data", "TC_ID"));
		selenium.waitForPageToLoad("15000");
		selenium.setSpeed("2000");
		String getLowesHomePgTitle=selenium.getTitle();
		System.out.println("Lowes HomePage Title is :"+getLowesHomePgTitle);
		if(getLowesHomePgTitle.contains("Lowe's Home Improvement: Appliances, Tools,"))
		{
			report.updateTestLog("Verifying Launch of Lowes HomePage", "Lowes homepage Launched Successfully", Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying Launch of Lowes HomePage", "Failed to Launch Lowes HomePage", Status.FAIL);
		}
		
		// store zip
		boolean varStoreZipped = driver.findElement(By.xpath(UIMapFunctionalComponents.webElmntStoreInfo)).isDisplayed();
		if(varStoreZipped)
		{
			System.out.println("Default Store Zipped");
		}
		else
		{
		driver.findElement(By.id(UIMapFunctionalComponents.txtStoreZip)).sendKeys(dataTable.getData("General_Data","Store"));
		
		try{
			driver.findElement(By.id(UIMapFunctionalComponents.txtStoreZip)).sendKeys(Keys.ENTER);
			
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtStoreZip)).sendKeys(Keys.ENTER);
		}
		selenium.waitForPageToLoad("15000");
		varStoreZipped = driver.findElement(By.xpath(UIMapFunctionalComponents.webElmntStoreInfo)).isDisplayed();
		if(varStoreZipped)
		{
			report.updateTestLog("Zipping Store","Store "+dataTable.getData("General_Data","Store")+" Zipped successfully", Status.PASS);
		}
		else
		{
			report.updateTestLog("Zipping Store","Store Not Zipped successfully", Status.FAIL);
		}
		}
	}
	
	public void changeStore() throws Exception
	{
		try{
		driver.findElement(By.xpath(UIMapFunctionalComponents.lnkStoreUnzip)).click();
		Thread.sleep(2000);}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapFunctionalComponents.lnkStoreUnzip)).click();
			Thread.sleep(2000);}
		
		
		driver.findElement(By.id(UIMapFunctionalComponents.txtStoreZip)).sendKeys(dataTable.getData("General_Data","Store"));
		
		try{
			//driver.findElement(By.id("nav-button-store-search")).click();
			driver.findElement(By.id(UIMapFunctionalComponents.txtStoreZip)).sendKeys(Keys.ENTER);
			selenium.waitForPageToLoad("120000");
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			//driver.findElement(By.id("nav-button-store-search")).click();
			driver.findElement(By.id(UIMapFunctionalComponents.txtStoreZip)).sendKeys(Keys.ENTER);
			selenium.waitForPageToLoad("120000");
		}
		
	//	boolean varStoreZipped = selenium.isElementPresent("//*[@id='nav-store-info']/span[1]");
		boolean varStoreZipped = driver.findElement(By.xpath(UIMapFunctionalComponents.webElmntStoreInfo)).isDisplayed();
		if(varStoreZipped)
		{
			report.updateTestLog("Zipping Store","Store "+dataTable.getData("General_Data","Store")+" Zipped successfully", Status.PASS);
		}
		else
		{
			report.updateTestLog("Zipping Store","Store Not Zipped successfully", Status.FAIL);
		}
	}
	public void lowesUserRegistration()
	{
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
		driver.findElement(By.xpath(UIMapFunctionalComponents.lnkSignUp)).click();
		selenium.waitForPageToLoad("15000");
		boolean verUserRegForm=driver.findElement(By.xpath(UIMapFunctionalComponents.btnRegistrationSubmit)).isDisplayed(); // Verifying the Create Account Button
		System.out.println("User Registration Page Displayed is :"+verUserRegForm);
		if(verUserRegForm)
		{
			try{
			driver.findElement(By.id(UIMapFunctionalComponents.txtFirstName)).clear();
			driver.findElement(By.id(UIMapFunctionalComponents.txtFirstName)).sendKeys(dataTable.getData("General_Data","Firstname")); //Entering the firsname in User Registration form
			driver.findElement(By.id(UIMapFunctionalComponents.txtLastName)).clear();
			driver.findElement(By.id(UIMapFunctionalComponents.txtLastName)).sendKeys(dataTable.getData("General_Data","Lastname"));  // Entering the lastname in User Registration form
			driver.findElement(By.id(UIMapFunctionalComponents.txtEmail)).clear();
			driver.findElement(By.id(UIMapFunctionalComponents.txtEmail)).sendKeys(varUniq+"@bh.exacttarget.com");//Unique Email ID based on timestamp
			dataTable.putData("General_Data", "email", varUniq+"@bh.exacttarget.com");
			//driver.findElement(By.id("email1")).sendKeys(dataTable.getData("General_Data","email"));  // Entering Email id
			driver.findElement(By.id(UIMapFunctionalComponents.txtPhone)).clear();
			driver.findElement(By.id(UIMapFunctionalComponents.txtPhone)).sendKeys(dataTable.getData("General_Data","phone"));  // Entering Phone number
			driver.findElement(By.id(UIMapFunctionalComponents.txtRegPassword)).clear();
			driver.findElement(By.id(UIMapFunctionalComponents.txtRegPassword)).sendKeys(dataTable.getData("General_Data","password")); // Entering Password
			driver.findElement(By.id(UIMapFunctionalComponents.txtConfPassword)).clear();
			driver.findElement(By.id(UIMapFunctionalComponents.txtConfPassword)).sendKeys(dataTable.getData("General_Data","confpassword")); //Entering Confirm Password
			//driver.findElement(By.id("Ecom_BillTo_Postal_PostalCode")).sendKeys(dataTable.getData("General_Data","zipcode")); //Entering Zipcode
			driver.findElement(By.xpath(UIMapFunctionalComponents.btnRegistrationSubmit)).click(); // Clicking the Create Account button to register user
			}
			
			catch(Exception WebDriverException)
			{
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup","Handeled", Status.DONE);
				driver.findElement(By.id(UIMapFunctionalComponents.txtFirstName)).clear();
				driver.findElement(By.id(UIMapFunctionalComponents.txtFirstName)).sendKeys(dataTable.getData("General_Data","Firstname")); //Entering the firsname in User Registration form
				driver.findElement(By.id(UIMapFunctionalComponents.txtLastName)).clear();
				driver.findElement(By.id(UIMapFunctionalComponents.txtLastName)).sendKeys(dataTable.getData("General_Data","Lastname"));  // Entering the lastname in User Registration form
				driver.findElement(By.id(UIMapFunctionalComponents.txtEmail)).clear();
				driver.findElement(By.id(UIMapFunctionalComponents.txtEmail)).sendKeys(varUniq+"@bh.exacttarget.com");//Unique Email ID based on timestamp
				dataTable.putData("General_Data", "email", varUniq+"@bh.exacttarget.com");
				//driver.findElement(By.id("email1")).sendKeys(dataTable.getData("General_Data","email"));  // Entering Email id
				driver.findElement(By.id(UIMapFunctionalComponents.txtPhone)).clear();
				driver.findElement(By.id(UIMapFunctionalComponents.txtPhone)).sendKeys(dataTable.getData("General_Data","phone"));  // Entering Phone number
				driver.findElement(By.id(UIMapFunctionalComponents.txtRegPassword)).clear();
				driver.findElement(By.id(UIMapFunctionalComponents.txtRegPassword)).sendKeys(dataTable.getData("General_Data","password")); // Entering Password
				driver.findElement(By.id(UIMapFunctionalComponents.txtConfPassword)).clear();
				driver.findElement(By.id(UIMapFunctionalComponents.txtConfPassword)).sendKeys(dataTable.getData("General_Data","confpassword")); //Entering Confirm Password
				//driver.findElement(By.id("Ecom_BillTo_Postal_PostalCode")).sendKeys(dataTable.getData("General_Data","zipcode")); //Entering Zipcode
				driver.findElement(By.xpath(UIMapFunctionalComponents.btnRegistrationSubmit)).click();
			}
			selenium.waitForPageToLoad("120000");
			report.updateTestLog("Verifying Lowes User Registration page" ,"Navigation to User Registration Page Successfull", Status.PASS);
			String getLoggedInUser=driver.findElement(By.xpath(UIMapFunctionalComponents.webElmntSalutation)).getText().trim();
			System.out.println("Verifying the Registered User detais :"+getLoggedInUser);
			if(getLoggedInUser.equals("Welcome, "+dataTable.getData("General_Data","Firstname")))          // Verifying the registered user details by Using Firstname
			{
				report.updateTestLog("Validating Login Credentials","User Registration Successful", Status.PASS);
			}
			else
			{
				report.updateTestLog("Validating Login Credentials","User Registration UnSuccessful", Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Verifying Lowes User Registration page" ,"Failed to Navigate to User Registration Page", Status.FAIL);	
		}
	}
	
	
	public void verifyingRegisteredUserLogin() throws Exception 
	{
		
			driver.findElement(By.xpath(UIMapFunctionalComponents.lnkSignIn)).click();
			selenium.windowFocus();
			
			selenium.waitForPageToLoad("120000");
		
			
		String varPgTitle=selenium.getTitle();
		System.out.println(varPgTitle);
		if(!varPgTitle.contains("Lowe's: Sign In"))
		{
			boolean verPopUpBoxPresent=selenium.isElementPresent(UIMapFunctionalComponents.webElmntLoginPopup);
			System.out.println("PopUp Window identified is :"+verPopUpBoxPresent);
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			boolean verFramePresent=driver.findElement(By.id(UIMapFunctionalComponents.webElmntLoginFrame)).isDisplayed();
			System.out.println("Verifying the Presence of frame id:"+verFramePresent);
			driver.switchTo().frame(driver.findElement(By.id(UIMapFunctionalComponents.webElmntLoginFrame)));
		}
		
		
		driver.findElement(By.id(UIMapFunctionalComponents.txtUserName)).click();
		Thread.sleep(2000);
		driver.findElement(By.id(UIMapFunctionalComponents.txtUserName)).sendKeys(dataTable.getData("General_Data","email"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(dataTable.getData("General_Data", "password"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(Keys.ENTER);
		//driver.findElement(By.id("GoYourAccount")).click();		
		selenium.waitForPageToLoad("20000");
		
		Thread.sleep(10000);
		waitforVisible(driver, UIMapFunctionalComponents.webElmntSalutation, 20);
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
	
	/*Verifying Employee Login*/
	public void verifyingEmployeeLogin() throws Exception 
	{
		
			driver.findElement(By.xpath(UIMapFunctionalComponents.lnkSignIn)).click();
			selenium.windowFocus();
			
			selenium.waitForPageToLoad("120000");
		
			
		String varPgTitle=selenium.getTitle();
		System.out.println(varPgTitle);
		if(!varPgTitle.contains("Lowe's: Sign In"))
		{
			boolean verPopUpBoxPresent=selenium.isElementPresent(UIMapFunctionalComponents.webElmntLoginPopup);
			System.out.println("PopUp Window identified is :"+verPopUpBoxPresent);
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			boolean verFramePresent=driver.findElement(By.id(UIMapFunctionalComponents.webElmntLoginFrame)).isDisplayed();
			System.out.println("Verifying the Presence of frame id:"+verFramePresent);
			driver.switchTo().frame(driver.findElement(By.id(UIMapFunctionalComponents.webElmntLoginFrame)));
		}
		
		
		driver.findElement(By.id(UIMapFunctionalComponents.txtUserName)).click();
		Thread.sleep(2000);
		driver.findElement(By.id(UIMapFunctionalComponents.txtUserName)).sendKeys(dataTable.getData("General_Data","email"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(dataTable.getData("General_Data", "password"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(Keys.ENTER);
		//driver.findElement(By.id("GoYourAccount")).click();		
		selenium.waitForPageToLoad("20000");
		
		Thread.sleep(10000);
		waitforVisible(driver, UIMapFunctionalComponents.webElmntSalutation, 20);
		String getLoggedInUser=driver.findElement(By.xpath(UIMapFunctionalComponents.webElmntSalutation)).getText().trim();
		String varEmployee=driver.findElement(By.xpath(UIMapFunctionalComponents.webElmntSalutation+"/span")).getText().trim();
		System.out.println("Verifying the Registered User detais :"+getLoggedInUser);
		if((getLoggedInUser.contains("Welcome, "+dataTable.getData("General_Data","Firstname"))) &&  (varEmployee.equals("- (Employee)")) )        // Verifying the registered user details by Using Firstname
		{
			report.updateTestLog("Validating Login Credentials","Login Successful for Employee", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Login Credentials","Login Failed..! for Employee "+dataTable.getData("General_Data","email")+" ", Status.FAIL);
		}
		
	}
	
	public void searchItem() throws Exception
	{
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","ItemNbr"));
		try{driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);}
		/*Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER); 
		r.keyRelease(KeyEvent.VK_ENTER);*/
		//selenium.waitForPageToLoad("15000");
		//driver.findElement(By.id("Ntt")).sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath("//form[@id='frmQuickSearch']/span/button")).click();
		report.updateTestLog("Searching For an Item","Searching Item Number - "+dataTable.getData("General_Data","ItemNbr")+"" ,Status.DONE);
		
		
		selenium.waitForPageToLoad("120000");
		boolean verItemPresent=selenium.isTextPresent("Item #: "+dataTable.getData("General_Data","ItemNbr"));
		if(verItemPresent)
		{
			report.updateTestLog("Veriyfing Navigating to Item's PDP Page","Item - " +dataTable.getData("General_Data","ItemNbr") +" is Present", Status.PASS);
		}
		else
		{
			report.updateTestLog("Veriyfing Navigating to Item's PDP Page","Item is NOT Present", Status.FAIL);
		}
	}
	
	
	public void searchUsingModelNumber() throws Exception
	{
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","ItemNbr"));
		//driver.findElement(By.xpath("//form[@id='frmQuickSearch']/span/button")).click();
		try{driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);}
		report.updateTestLog("Searching For an Item using Model Number","Searching By Model Number - "+dataTable.getData("General_Data","ItemNbr")+"" ,Status.DONE);
		selenium.waitForPageToLoad("30000");
		boolean verItemPresent=selenium.isTextPresent("Model #: "+dataTable.getData("General_Data","ItemNbr"));
		if(verItemPresent)
		{
			report.updateTestLog("Veriyfing Navigating to Item's PDP Page","Model Number - " +dataTable.getData("General_Data","ItemNbr") +" is Present", Status.PASS);
		}
		else
		{
			report.updateTestLog("Veriyfing Navigating to Item's PDP Page","Model Number is NOT Present", Status.FAIL);
		}
	}
	
	
	
	
	
	public void enterQtyAndAddItemToCart() 
	{
		selenium.waitForPageToLoad("30000");
		String prodText=driver.findElement(By.xpath(UIMapFunctionalComponents.webElmntProductName)).getText().trim();
		System.out.println("Product Name is :"+prodText);
		//driver.findElement(By.id("quantity_of_3478135")).clear();
		driver.findElement(By.xpath(UIMapFunctionalComponents.txtQty)).clear();
		driver.findElement(By.xpath(UIMapFunctionalComponents.txtQty)).sendKeys(dataTable.getData("General_Data","Qty"));
		driver.findElement(By.xpath(UIMapFunctionalComponents.btnAddToCart)).click();
		report.updateTestLog("Verifying the Clicking the Item Add to Cart","Add to Cart Button Clicked for item "+dataTable.getData("General_Data","ItemNbr"), Status.DONE);
		selenium.waitForPageToLoad("30000");
		selenium.windowFocus();
		String confPopUpgetProdTxt=driver.findElement(By.xpath(UIMapFunctionalComponents.webElmntConfirmationTxt)).getText().trim();
		System.out.println("Product text in Confirmation PopUp : "+confPopUpgetProdTxt);
		if(prodText.equals(confPopUpgetProdTxt))
		{
			report.updateTestLog("Verifying the correct product is added to Cart", "Correct product added to cart",Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying the correct product is added to Cart", "Product not added to cart",Status.FAIL);
		}
		//driver.findElement(By.xpath("//div[17]/div[3]/div/button[2]")).click();
		selenium.click("xpath="+UIMapFunctionalComponents.btnCheckout+"\"");
		selenium.waitForPageToLoad("30000");
		/*String verShopCartPage=selenium.getText("//form[@id='ShopCartForm']/div[4]/div/div[2]/div/a/p").trim();
		System.out.println("Verifying the Item added to shopcart page is correct :"+verShopCartPage);
		if(verShopCartPage.contains(dataTable.getData("General_Data","Itemnbr")))
		{
			report.updateTestLog("Verifying Whether the Item is added to Shopping Cart","Item Displayed in Shopping Cart Page", Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying Whether the Item is added to Shopping Cart","Item NOT Displayed in Shopping Cart Page", Status.FAIL);
		}*/
	}
	/**
     * isWebElementPresent
     * checks if an webElement is present or not
     * @param xPath
     * @throws Exception
     */
     public void isWebElementPresent(String xPath, String varLabel) throws Exception {
           boolean elementPresent = selenium.isElementPresent(xPath);
           if (elementPresent) {
                 report.updateTestLog("Validating web element"+varLabel,
                             "Element displayed", Status.PASS);
           } else {
                 report.updateTestLog("Validating web element"+varLabel,
                             "WebElement NOT displayed", Status.FAIL);
           }

     }
    
     /**
      * TextPresentVerification
      * 
       * Verifies xPath text matches with the Original Text or not
      * will get Passed if correct or throws Fail Exception and terminates.
      * @param xPath
      * @param original
      * @throws Exception
      */
     public void textPresentVerification(String xPath, String original) throws Exception{
         String varMyLowes = driver.findElement(
                     By.xpath('"'+xPath+'"')).getText();
         selenium.waitForPageToLoad("5000");
         if (varMyLowes.equals('"'+original+'"')) {
               report.updateTestLog("Checking for Original Text Message",
                           "Original Text message is displayed", Status.PASS);
         }
         else{
               report.updateTestLog("Checking for Original Text Message",
                           "Original Text Message NOT displayed", Status.FAIL);
         }
               
   }

    
     
     public static void waitforVisible(WebDriver driver,String Xpath,int sec) throws Exception
     { 
      int count=0; for(int i=0;i<=sec;i++) 
     { 
      if(driver.findElements(By.xpath(Xpath)).size()>0) 
     { 
      if(new WebDriverBackedSelenium(driver,driver.getCurrentUrl()).isVisible(Xpath))
     { 
     count++; 
     break;
     } 
     else
     { 
     Thread.sleep(1000); 
     System.out.println("Waiting for element to visible");
     } 
     } 
     } 
     if(count <=0) throw new Exception("given Element is not visible in time");
     }
     
     public void signOut() throws Exception{
    	 driver.findElement(By.linkText("Sign Out")).click();
    	 selenium.waitForPageToLoad("20000");
    	 report.updateTestLog("Signing Out", "User Signed Out", Status.DONE);
     }
   
     //added 03/27
     /*This function returns the count of a web element on a page*/
 	public int countWebElement(String varXpath) throws Exception
 	{
 		List<WebElement> varGC = driver.findElements(By.xpath(varXpath));
 		int varCount = varGC.size();
 		return varCount;
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
 	
 	/**this function validates the text at an xpath with expected value***/
 	 public void chkText(String varXpath, String varValue) throws Exception
 	 {
 		try{ String varApplicationValue=driver.findElement(By.xpath(varXpath)).getText();
 		System.out.println(varApplicationValue);
 		System.out.println(varValue);
 		 if(varApplicationValue.trim().equalsIgnoreCase(varValue))
 			 report.updateTestLog("Checking "+varValue, varValue+" Displayed", Status.PASS);
 		 else
 			 report.updateTestLog("Checking "+varValue, varValue+" NOT Displayed", Status.FAIL);
 		}
 		catch(Exception e)
 		{
 			report.updateTestLog("Checking "+varValue, varValue+" NOT Displayed", Status.FAIL);
 		}
 	 }
 	 
 	/**This function validates whether page title is as expected**/
 	public void chkPagetitle(String pgTitle) throws Exception
 	{
 		System.out.println(selenium.getTitle());
 		if(selenium.getTitle().equals(pgTitle))
 			report.updateTestLog("Checking Page Title", "Page Title as Expected is:"+pgTitle, Status.PASS);
 		else
 			report.updateTestLog("Checking Page Title", "Page Title Not :"+pgTitle, Status.FAIL);
 	}
 	
 	/**Checks whether text at xpath contains a specific text**/
	public void checkTextContains(String varXpath, String txt, String elementDesc) throws Exception
	{
		String varTxt=driver.findElement(By.xpath(varXpath)).getText();
		System.out.println(varTxt);
		System.out.println(txt);
		if(varTxt.contains(txt))
			report.updateTestLog("Checking "+elementDesc, elementDesc+" contains "+txt, Status.PASS);
		else
			report.updateTestLog("Checking "+elementDesc, elementDesc+" Does Not contain "+txt, Status.FAIL);
	}
	
	/**Checks whether text at xpath Does not contain a specific text**/
	public void checkTextNotContains(String varXpath, String txt, String elementDesc) throws Exception
	{
		String varTxt=driver.findElement(By.xpath(varXpath)).getText();
		if(varTxt.contains(txt))
			report.updateTestLog("Checking "+elementDesc, elementDesc+" contains "+txt, Status.FAIL);
		else
			report.updateTestLog("Checking "+elementDesc, elementDesc+" Does Not contain "+txt, Status.PASS);
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

}
