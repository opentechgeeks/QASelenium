package com.lowes.qa.selenium.components;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

public class ManageAccount extends ReusableLibrary {

	String baseurl = dataTable.getData("General_Data", "URL");
	Selenium selenium = new WebDriverBackedSelenium(driver, baseurl);
	ProductSearch ps=new ProductSearch(scriptHelper);
	public ManageAccount(ScriptHelper scriptHelper) {
		super(scriptHelper);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void viewSource() throws Exception{
		//html source code
		String var = selenium.getHtmlSource();
        String[] parts = var.split("\\s");
        String var1 = parts[0];
        if(var1.equals("<!DOCTYPE")){
        	report.updateTestLog("source code visible",
					"source code visible", Status.PASS);
        }else{
        	report.updateTestLog("source code not visible",
					"source code not visible", Status.FAIL);
        }
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void verifyMyLowesZipCodeUserLogin() throws Exception {
		driver.findElement(By.xpath(UIMapMyLowes.lnkMasterHeadSignUp))
				.click();
		selenium.waitForPageToLoad("15000");
		verifyZipcode();
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void verifyYourAccountZipCodeLogin() throws Exception {
		inspectSignUpFromSignIn();
		Thread.sleep(6000);
		verifyMyLowesZipCodeUserLogin();
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void verifyModelPageZipCodeLogin()throws Exception{
		driver.findElement(By.xpath(UIMapMyLowes.lnkMasterHeadSignIn)).click();
		Thread.sleep(6000);
		
		boolean verPopUpBoxPresent=selenium.isElementPresent(UIMapFunctionalComponents.webElmntLoginPopup);
		System.out.println("PopUp Window identified is :"+verPopUpBoxPresent);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		boolean verFramePresent=driver.findElement(By.id(UIMapFunctionalComponents.webElmntLoginFrame)).isDisplayed();
		System.out.println("Verifying the Presence of frame id:"+verFramePresent);
		driver.switchTo().frame(driver.findElement(By.id(UIMapFunctionalComponents.webElmntLoginFrame)));
		
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.txtSignIn)).getText();
		System.out.println(varMyLowes);
		if (varMyLowes.equals(UIMapMyLowes.lblSignIn)) {
			report.updateTestLog("Clicking Sign In link",
					"Sign In page displayed", Status.PASS);
			driver.findElement(By.xpath(UIMapMyLowes.lnkClickSignInMyLowes))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		} else {
			report.updateTestLog("Clicking Sign In link",
					"Sign In page displayed", Status.FAIL);
		}
		Thread.sleep(6000);
		verifyMyLowesZipCodeUserLogin();
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public static final String lnkDisableAutoZip = "//*[@id='disable-autozip']";
	public static final String btnRegisterSubmit = "//div[@id='registerSubmit']/button";
	
	public void verifyZipcode()throws Exception{
		/* Code for unique email ID starts */
		java.util.Date date = new java.util.Date();
		Timestamp t = new Timestamp(date.getTime());
		String varTimeStamp = String.format("%1$TD %1$TT", t);
		System.out.println(varTimeStamp);
		String[] varDate = varTimeStamp.split(" ");
		String[] varDatMon = varDate[0].split("/");
		String[] varHrMinSec = varDate[1].split(":");
		String varUniq = "test";
		varUniq = varUniq.concat(varDatMon[0] + varDatMon[1] + varHrMinSec[0]
				+ varHrMinSec[1] + varHrMinSec[2]);
		selenium.waitForPageToLoad("15000");
		driver.findElement(By.xpath(UIMapMyLowes.lnkDisableAutoZip)).click();
		Thread.sleep(6000);
		boolean verUserRegForm = driver.findElement(
				By.xpath(UIMapMyLowes.btnRegisterSubmit)).isDisplayed();
		System.out.println("User Registration Page Displayed is :"
				+ verUserRegForm);
		if (verUserRegForm) {
			driver.findElement(By.id("firstName")).sendKeys(
					dataTable.getData("General_Data", "Firstname"));
			driver.findElement(By.id("lastName")).sendKeys(
					dataTable.getData("General_Data", "Lastname"));
			driver.findElement(By.id("email1")).sendKeys(
					varUniq + "@bh.exacttarget.com");
			driver.findElement(By.id("phoneUS")).sendKeys(
					dataTable.getData("General_Data", "phone"));
			driver.findElement(By.id("prefStoreZipCode"))
					.sendKeys("00000");
			driver.findElement(By.id("prefStoreZipCode")).clear();
			driver.findElement(By.id("prefStoreZipCode"))
					.sendKeys(dataTable.getData("General_Data", "zipcode"));
			driver.findElement(By.id("password1")).sendKeys(
					dataTable.getData("General_Data", "password"));
			driver.findElement(By.id("password2")).sendKeys(
					dataTable.getData("General_Data", "confpassword"));
			driver.findElement(By.xpath(UIMapMyLowes.btnRegisterSubmit))
					.click();
			selenium.waitForPageToLoad("45000");
			Thread.sleep(6000);
			report.updateTestLog("Verifying Lowes User Registration page",
					"Navigation to User Registration Page Successfull",
					Status.PASS);
		} else {
			report.updateTestLog("Verifying Lowes User Registration page",
					"Failed to Navigate to User Registration Page", Status.FAIL);
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void verifyLogin()throws Exception{
		try{
		driver.findElement(By.xpath(UIMapMyLowes.lnkSignIn)).click();
		}
		catch(Exception e){
			driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handeled", Status.DONE);
            driver.findElement(By.xpath(UIMapMyLowes.lnkSignIn)).click();
		}
		selenium.windowFocus();
		selenium.waitForPageToLoad("15000");
		boolean verPopUpBoxPresent=selenium.isElementPresent(UIMapMyLowes.lblModalAccount);
		System.out.println("PopUp Window identified is :"+verPopUpBoxPresent);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		boolean verFramePresent=driver.findElement(By.id("iframe_modal_account")).isDisplayed();
		System.out.println("Verifying the Presence of frame id:"+verFramePresent);
		driver.switchTo().frame(driver.findElement(By.id("iframe_modal_account")));
		driver.findElement(By.id("Ecom_User_ID")).sendKeys(dataTable.getData("General_Data","email"));
		driver.findElement(By.id("logonPassword")).sendKeys(dataTable.getData("General_Data", "password"));
		driver.findElement(By.id("logonPassword")).sendKeys(Keys.ENTER);
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//driver.findElement(By.xpath(UIMapMyLowes.lnkSignInClose)).click();
		driver.navigate().refresh();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void yourAccoutSignIn() throws Exception {
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.txtSignIn)).getText();
		System.out.println(varMyLowes);
		if (varMyLowes.equals(UIMapMyLowes.lblSignIn)) {
			report.updateTestLog("Clicking Sign In link",
					"Sign In page displayed", Status.PASS);
			
			driver.findElement(By.id("Ecom_User_ID")).sendKeys(
					dataTable.getData("General_Data", "email"));
			driver.findElement(By.id("logonPassword")).sendKeys(
					dataTable.getData("General_Data", "password"));
			driver.findElement(By.id("logonPassword")).sendKeys(Keys.ENTER);
			//driver.findElement(By.xpath(UIMapMyLowes.btnCreateAccount)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		} else {
			report.updateTestLog("Clicking Sign In link",
					"Sign In page NOT displayed", Status.FAIL);
		}
	}

	/**
	 * MyLowesLandingPageSignin Sign in from myLowesLandingPage
	 * 
	 * @throws Exception
	 */
	public void myLowesLandingPageSignin() throws Exception {
		driver.findElement(
				By.xpath(UIMapMyLowes.lnkMylowesLandingPage))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//moving out from feedback pop-up
		try{
		driver.findElement(By.xpath(UIMapMyLowes.lnkMylowesLandingPageSignIn))
				.click();
		}
		catch(Exception e){
			driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.lnkMylowesLandingPageSignIn))
			.click();
		}
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.txtSignIn)).getText();
		System.out.println(varMyLowes);
		if (varMyLowes.equals("Sign In")) {
			report.updateTestLog("Clicking Sign In link",
					"Sign In page displayed", Status.PASS);
			driver.findElement(By.id("Ecom_User_ID")).sendKeys(
					dataTable.getData("General_Data", "email"));
			driver.findElement(By.id("logonPassword")).sendKeys(
					dataTable.getData("General_Data", "password"));
			//driver.findElement(By.xpath(UIMapMyLowes.btnCreateAccount)).click();
			driver.findElement(By.id("logonPassword")).sendKeys(Keys.ENTER);
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		} else {
			report.updateTestLog("Clicking Sign In link",
					"Sign In page NOT displayed", Status.FAIL);
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void myLowesLandingPageReSignin()throws Exception{
		myLowesLandingPageSignin();
	}


	/**
	 * 
	 * @throws Exception
	 */
	public void inspectSignUpFromSignIn() throws Exception {
		driver.findElement(By.xpath(UIMapMyLowes.lnkClickYourAccount))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// *[@id='nav-my-account']/span[2]
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.txtSignIn)).getText();
		System.out.println(varMyLowes);
		if (varMyLowes.equals("Sign In")) {
			report.updateTestLog("Clicking Sign In link",
					"Sign In page displayed", Status.PASS);
			driver.findElement(By.xpath(UIMapMyLowes.lnkClickSignInMyLowes))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		} else {
			report.updateTestLog("Clicking Sign In link",
					"Sign In page displayed", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void emailVerificationSignUp() throws Exception {
		java.util.Date date= new java.util.Date();
        Timestamp t = new Timestamp(date.getTime());
        String varTimeStamp = String.format("%1$TD %1$TT", t);
        System.out.println(varTimeStamp);
        String[] varDate = varTimeStamp.split(" ");
        String[] varDatMon = varDate[0].split("/");
        String varUniq = "test";
        varUniq = varUniq.concat(varDatMon[0]+varDatMon[1]);
        //
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// *[@id='registrationForm']/p[1]/a
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.lblMyLowesSignUp)).getText();
		System.out.println(varMyLowes);
		if (varMyLowes.equals(UIMapMyLowes.txtMyLowesSignUp)) {
			report.updateTestLog("Clicking Sign In link",
					"Sign In page displayed", Status.PASS);
			driver.findElement(By.id("firstName")).sendKeys(
					dataTable.getData("General_Data", "Firstname"));
			driver.findElement(By.id("lastName")).sendKeys(
					dataTable.getData("General_Data", "Lastname"));
			
			//email ID
			driver.findElement(By.id("email1")).sendKeys(varUniq);
			selenium.waitForPageToLoad("20000");
			Thread.sleep(8000);
			driver.findElement(By.id("email1")).clear();
			//email ID
			driver.findElement(By.id("email1")).sendKeys(varUniq+"@bh.exacttarget.com");
			
			
			driver.findElement(By.id("phoneUS")).sendKeys(
					dataTable.getData("General_Data", "phone")); 
			driver.findElement(By.id("password1")).sendKeys(
					dataTable.getData("General_Data", "wrongpassword")); 
			selenium.waitForPageToLoad("20000");
			Thread.sleep(8000);
			driver.findElement(By.id("password1")).clear();
			driver.findElement(By.id("password1")).sendKeys(
					dataTable.getData("General_Data", "password")); 
			driver.findElement(By.id("password2")).sendKeys(
					dataTable.getData("General_Data", "wrongpassword"));
			selenium.waitForPageToLoad("20000");
			Thread.sleep(8000);
			driver.findElement(By.id("password2")).clear();
			driver.findElement(By.id("password2")).sendKeys(
					dataTable.getData("General_Data", "confpassword"));
			selenium.waitForPageToLoad("20000");
			Thread.sleep(8000);
			driver.findElement(By.id("password2")).clear();
			driver.findElement(By.id("password2")).sendKeys(
					dataTable.getData("General_Data", "password"));
			Thread.sleep(6000);
			driver.findElement(By.xpath(UIMapFunctionalComponents.btnRegistrationSubmit)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		} else {
			report.updateTestLog("Clicking Sign In link",
					"Sign In page NOT displayed", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void reopenLowesApplication() throws Exception {
		driver.get(baseurl);
		selenium.waitForPageToLoad("15000");
		// driver.manage().window().maximize();
		selenium.setSpeed("2000");
		String getLowesHomePgTitle = selenium.getTitle();
		System.out.println("Lowes HomePage Title is :" + getLowesHomePgTitle);
		if (getLowesHomePgTitle
				.contains("Lowe's Home Improvement: Appliances, Tools,")) {
			report.updateTestLog("Verifying Launch of Lowes HomePage",
					"Lowes homepage Launched Successfully", Status.PASS);
		} else {
			report.updateTestLog("Verifying Launch of Lowes HomePage",
					"Failed to Launch Lowes HomePage", Status.FAIL);
		}
		driver.findElement(By.xpath(UIMapMyLowes.lnkSignIn)).click();
		selenium.windowFocus();
		selenium.waitForPageToLoad("15000");
	}

	/**
	 * lowesUserRegistrationRemember login with User and check remember me
	 * 
	 * @throws Exception
	 */
	public void lowesUserRegistrationRemember() throws Exception {
		driver.findElement(
				By.xpath(UIMapMyLowes.lnkMylowesLandingPage))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		try{
		driver.findElement(By.xpath(UIMapMyLowes.lnkMylowesLandingPageSignIn))
				.click();
		}
		catch(Exception e){
			driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.lnkMylowesLandingPageSignIn))
			.click();
		}
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.txtSignIn)).getText();
		System.out.println(varMyLowes);
		if (varMyLowes.equals(UIMapMyLowes.lblSignIn)) {
			report.updateTestLog("Clicking Sign In link",
					"Sign In page displayed", Status.PASS);
			driver.findElement(By.id("Ecom_User_ID")).sendKeys(
					dataTable.getData("General_Data", "email"));
			driver.findElement(By.id("logonPassword")).sendKeys(
					dataTable.getData("General_Data", "password"));
			driver.findElement(By.id("rememberme")).click();
			driver.findElement(By.id("logonPassword")).sendKeys(Keys.ENTER);
			//driver.findElement(By.xpath(UIMapMyLowes.btnCreateAccount)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			driver.quit();
			/*
			 * driver.get(baseurl); selenium.waitForPageToLoad("15000");
			 * //driver.manage().window().maximize(); selenium.setSpeed("2000");
			 * driver
			 * .findElement(By.xpath("//a[contains(text(),'Sign In')]")).click
			 * (); selenium.windowFocus(); selenium.waitForPageToLoad("15000");
			 */

		} else {
			report.updateTestLog("Clicking Sign In link",
					"Sign In page NOT displayed", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void signOutMyLowesLandingPage() throws Exception {
		driver.findElement(
				By.xpath(UIMapMyLowes.lnkMylowesLandingPage))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.linkText("Sign Out")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * yourAccountLandingPage
	 * 
	 * @throws Exception
	 */
	public void yourAccountLandingPage() throws Exception {
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
		driver.findElement(By.id("nav-my-account")).click();
		Thread.sleep(6000);
	}

	/**
	 * inspectYourAccountLandingHomePage
	 * 
	 * @throws Exception
	 */
	public void inspectYourAccountLandingHomePage() throws Exception {
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.lblBreadCrumb2)).getText();
		System.out.println(varMyLowes);
		if (varMyLowes.equals(UIMapMyLowes.txtMyLowesBreadCrumb)) {
			report.updateTestLog("Clicking Your Account link",
					"MyLowe's page displayed", Status.PASS);
			String varAccountSummary = driver.findElement(
					By.xpath(UIMapMyLowes.lblAccoountSummary))
					.getText();
			System.out.println(varAccountSummary);
			if (varAccountSummary.equals(UIMapMyLowes.txtAccountSummary)) {
				report.updateTestLog("Clicking Your Account link",
						"MyLowe's page displayed", Status.PASS);
				boolean editAccount = selenium
						.isElementPresent(UIMapMyLowes.lblEditAccount);
				if (!editAccount) {
					report.updateTestLog("Clicking Your EditAccount link",
							"EditAccount link NOT displayed", Status.FAIL);
				} else {
					
					driver.findElement(By.linkText(UIMapMyLowes.txtEditAccount))
							.click();
					selenium.waitForPageToLoad("200000");
					Thread.sleep(6000);
					report.updateTestLog("Clicking Your EditAccount link",
							"EditAccount link displayed", Status.PASS);
					driver.findElement(By.id("nav-my-account")).click();
					selenium.waitForPageToLoad("200000");
					Thread.sleep(6000);
				}
				boolean editAddress = selenium
						.isElementPresent(UIMapMyLowes.lblEditAddress);
				if (!editAddress) {
					report.updateTestLog("Clicking Your editAddress link",
							"editAddress link NOT displayed", Status.FAIL);
				} else {
					report.updateTestLog("Clicking Your editAddress link",
							"editAddress link displayed", Status.PASS);
					driver.findElement(
							By.xpath(UIMapMyLowes.lblEditAddress))
							.click();
					selenium.waitForPageToLoad("200000");
					Thread.sleep(6000);
					driver.findElement(By.id("nav-my-account")).click();
					selenium.waitForPageToLoad("200000");
					Thread.sleep(6000);
				}
				boolean editPreferences = selenium
						.isElementPresent(UIMapMyLowes.lblEditPreferences);
				if (!editPreferences) {
					report.updateTestLog("Clicking Your editPreferences link",
							"editPreferences link NOT displayed", Status.FAIL);
				} else {
					driver.findElement(
							By.xpath(UIMapMyLowes.lblEditPreferences))
							.click();
					selenium.waitForPageToLoad("200000");
					Thread.sleep(6000);
					driver.findElement(By.id("nav-my-account")).click();
					selenium.waitForPageToLoad("200000");
					Thread.sleep(6000);
				}
				boolean manageMyLowesCard = selenium
						.isElementPresent(UIMapMyLowes.lblManageMylowesCard);
				if (!manageMyLowesCard) {
					report.updateTestLog(
							"Clicking Your manageMyLowesCard link",
							"manageMyLowesCard link NOT displayed", Status.FAIL);
				} else {
					driver.findElement(
							By.xpath(UIMapMyLowes.lblManageMylowesCard))
							.click();
					selenium.waitForPageToLoad("200000");
					Thread.sleep(6000);
					driver.findElement(By.id("nav-my-account")).click();
					selenium.waitForPageToLoad("200000");
					Thread.sleep(6000);
				}
				boolean creditCardServices = selenium
						.isElementPresent(UIMapMyLowes.lblCreditCardServices);
				if (!creditCardServices) {
					report.updateTestLog(
							"Clicking Your creditCardServices link",
							"creditCardServices link NOT displayed",
							Status.FAIL);
				} else {
					driver.findElement(
							By.xpath(UIMapMyLowes.lblCreditCardServices))
							.click();
					selenium.waitForPageToLoad("200000");
					Thread.sleep(6000);
					driver.findElement(By.id("nav-my-account")).click();
					selenium.waitForPageToLoad("200000");
					Thread.sleep(6000);
				}
				boolean subscriptions = selenium
						.isElementPresent(UIMapMyLowes.lblSubscriptions);
				if (!subscriptions) {
					report.updateTestLog("Clicking Your subscriptions link",
							"subscriptions link NOT displayed", Status.FAIL);
				} else {
					driver.findElement(
							By.cssSelector("a[title=\"Subscriptions\"]"))
							.click();
					selenium.waitForPageToLoad("200000");
					Thread.sleep(6000);
					driver.findElement(By.id("nav-my-account")).click();
					selenium.waitForPageToLoad("200000");
					Thread.sleep(6000);
				}
				boolean rebates = selenium
						.isElementPresent(UIMapMyLowes.lblRebates);
				if (!rebates) {
					report.updateTestLog("Clicking Your rebates link",
							"rebates link NOT displayed", Status.FAIL);
				} else {
					driver.findElement(By.cssSelector("a[title=\"Rebates\"]"))
							.click();
					selenium.waitForPageToLoad("200000");
					Thread.sleep(6000);
					driver.findElement(By.id("nav-my-account")).click();
					selenium.waitForPageToLoad("200000");
					Thread.sleep(6000);
				}
				boolean yourStore = selenium
						.isElementPresent(UIMapMyLowes.lblYourStore);
				if (!yourStore) {
					report.updateTestLog("Clicking Your yourStore link",
							"yourStore link NOT displayed", Status.FAIL);
				} else {
					driver.findElement(
							By.xpath(UIMapMyLowes.lblYourStore))
							.click();
					selenium.waitForPageToLoad("200000");
					Thread.sleep(6000);
					driver.findElement(By.id("nav-my-account")).click();
					selenium.waitForPageToLoad("200000");
					Thread.sleep(6000);
				}
				boolean changeStore = selenium
						.isElementPresent(UIMapMyLowes.lblChangeStore);
				if (!changeStore) {
					report.updateTestLog("Clicking Your changeStore link",
							"changeStore Link NOT displayed", Status.FAIL);
				} else {
					driver.findElement(
							By.xpath(UIMapMyLowes.lblChangeStore))
							.click();
					selenium.waitForPageToLoad("200000");
					Thread.sleep(6000);
					driver.findElement(By.id("nav-my-account")).click();
					selenium.waitForPageToLoad("200000");
					Thread.sleep(6000);
				}

			}// Account Summary
			else {
				report.updateTestLog("Clicking Your Account link",
						"MyLowe's page NOT displayed", Status.FAIL);
			}// Account Summary
			String varRecentPurchases = driver.findElement(
					By.xpath("//*[@id='dashboard_orders']/h3/span")).getText();
			System.out.println(varRecentPurchases);
			
			String varReminders = driver.findElement(
					By.xpath(UIMapMyLowes.lblViewAllReminders)).getText();
			System.out.println(varReminders);
			if (varReminders.equals("Reminders")) {
				report.updateTestLog("Clicking Your Reminders link",
						"Reminders page displayed", Status.PASS);
				boolean viewAllReminders = selenium
						.isElementPresent(UIMapMyLowes.btnViewAllReminders);
				if (viewAllReminders) {
					report.updateTestLog("Clicking Your Reminders link",
							"Reminders page NOT displayed", Status.PASS);
					driver.findElement(
							By.xpath(UIMapMyLowes.btnViewAllReminders)).click();
					selenium.waitForPageToLoad("200000");
					Thread.sleep(6000);
					driver.findElement(By.id("nav-my-account")).click();
					selenium.waitForPageToLoad("200000");
					Thread.sleep(6000);
				}
				boolean learnMoreReminders = selenium
						.isTextPresent("Learn more about Reminders.");
				if (learnMoreReminders) {
					report.updateTestLog("Clicking Your Reminders link",
							"Reminders page NOT displayed", Status.PASS);
					driver.findElement(
							By.linkText("Learn more about Reminders.")).click();
					selenium.waitForPageToLoad("200000");
					Thread.sleep(6000);
					driver.findElement(By.id("nav-my-account")).click();
					selenium.waitForPageToLoad("200000");
					Thread.sleep(6000);
				}
			}// Reminders
			else {
				report.updateTestLog("Clicking Your Reminders link",
						"Reminders page NOT displayed", Status.FAIL);
			}// Reminders
			String varLists = driver.findElement(
					By.xpath(UIMapMyLowes.lblViewAllLists)).getText();
			System.out.println(varLists);
			if (varLists.equals("Lists")) {
				report.updateTestLog("Clicking Your Reminders link",
						"Reminders page displayed", Status.PASS);
				boolean viewAllLists = selenium
						.isElementPresent(UIMapMyLowes.btnViewAllLists);
				if (viewAllLists) {
					report.updateTestLog("Clicking Your Purchasers link",
							"Purchasers page NOT displayed", Status.PASS);
					driver.findElement(
							By.xpath(UIMapMyLowes.btnViewAllLists)).click();
					selenium.waitForPageToLoad("200000");
					Thread.sleep(6000);
					driver.findElement(By.id("nav-my-account")).click();
					selenium.waitForPageToLoad("200000");
					Thread.sleep(6000);
				}
				boolean learnMoreLists = selenium
						.isTextPresent("Learn more about Lists.");
				if (learnMoreLists) {
					report.updateTestLog("Clicking Your Reminders link",
							"Reminders page NOT displayed", Status.PASS);
					driver.findElement(By.linkText("Learn more about Lists."))
							.click();
					selenium.waitForPageToLoad("200000");
					Thread.sleep(6000);
					driver.findElement(By.id("nav-my-account")).click();
					selenium.waitForPageToLoad("200000");
					Thread.sleep(6000);
				}

			}// Lists
			else {
				report.updateTestLog("Clicking Your Lists link",
						"Lists page NOT displayed", Status.FAIL);
			}// Lists
			if (varRecentPurchases.equals("Recent Purchases")) {
				report.updateTestLog("Clicking Your Account link",
						"MyLowe's page displayed", Status.PASS);
				boolean viewAllPurchases = selenium
						.isElementPresent(UIMapMyLowes.btnViewAllPurchaces);
				if (viewAllPurchases) {
					report.updateTestLog("Clicking Your Purchasers link",
							"Purchasers page NOT displayed", Status.PASS);
					driver.findElement(
							By.xpath(UIMapMyLowes.btnViewAllPurchaces))
							.click();
					selenium.waitForPageToLoad("200000");
					Thread.sleep(6000);
					driver.findElement(By.id("nav-my-account")).click();
					selenium.waitForPageToLoad("200000");
					Thread.sleep(6000);
				}
			}// Recent Purchases
			else {
				report.updateTestLog("Clicking Your Purchasers link",
						"Purchasers page NOT displayed", Status.FAIL);
			}// Recent Purchases

		} else {
			report.updateTestLog("Clicking Your Account link",
					"MyLowe's page NOT displayed", Status.FAIL);
		}// MyLowe's
	}

	/**
	 * yourAccountHomePage
	 * 
	 * @throws Exception
	 */
	public void yourAccountHomePage() throws Exception {
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.lblBreadCrumb2)).getText();
		System.out.println(varMyLowes);
		if (varMyLowes.equals("MyLowe's")) {
			report.updateTestLog("Clicking Your Account link",
					"MyLowe's page displayed", Status.PASS);
		} else {
			report.updateTestLog("Clicking Your Account link",
					"MyLowe's page NOT displayed", Status.FAIL);
		}
		boolean purchases = selenium
				.isElementPresent(UIMapMyLowes.lblPurchases);
		if (!purchases) {
			report.updateTestLog("Clicking Your Account link",
					"MyLowe's page NOT displayed", Status.FAIL);
		}
		driver.findElement(By.cssSelector("#nav_purchases > a")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		boolean lists = selenium.isElementPresent(UIMapMyLowes.lblLists);
		if (!lists) {
			report.updateTestLog("Clicking Your Account link",
					"MyLowe's page NOT displayed", Status.FAIL);
		}
		driver.findElement(By.cssSelector("#nav_portfolio > a")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		boolean preferences = selenium
				.isElementPresent(UIMapMyLowes.lblPreferences);
		if (!preferences) {
			report.updateTestLog("Clicking Your Account link",
					"MyLowe's page NOT displayed", Status.FAIL);
		}
		driver.findElement(By.cssSelector("#nav_profile > a")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.lblMyLowesLeftNav)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(
				By.xpath(UIMapMyLowes.lblManageMylowesCard))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		boolean homeProfile = selenium
				.isElementPresent(UIMapMyLowes.lblHomeProfile);
		if (!homeProfile) {
			report.updateTestLog("Clicking Your Account link",
					"MyLowe's page NOT displayed", Status.FAIL);
		}
		driver.findElement(By.cssSelector("#nav_homeprofile > a")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

	}

	/**
	 * YourAccountPreferences will go to your Account link and click on
	 * Preferences
	 * 
	 * @throws Exception
	 */
	public void yourAccountPreferences() throws Exception {
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
	 * YourAccountSubscriptions will go to your Account link and click on
	 * Subscriptions page
	 * 
	 * @throws Exception
	 */
	public void yourAccountSubscriptions() throws Exception {
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
		WebElement subLink = driver.findElement(By.id("nav-my-subscriptions"));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.lblBreadCrumb3)).getText();
		System.out.println(varMyLowes);
		if (varMyLowes.equals("Subscriptions")) {
			report.updateTestLog("Clicking Your Account link",
					"MyLowe's page displayed", Status.PASS);
		} else {
			report.updateTestLog("Clicking Your Account link",
					"MyLowe's page NOT displayed", Status.FAIL);
		}
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void yourAccountSubscriptionsWithoutSignIn() throws Exception {
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
		WebElement subLink = driver.findElement(By.id("nav-my-subscriptions"));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.lblBreadCrumb2)).getText();
		System.out.println(varMyLowes);
		if (varMyLowes.equals("Subscriptions")) {
			report.updateTestLog("Clicking Your Account link",
					"MyLowe's page displayed", Status.PASS);
		} else {
			report.updateTestLog("Clicking Your Account link",
					"MyLowe's page NOT displayed", Status.FAIL);
		}
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void yourAccountsRebates() throws Exception {
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
		WebElement subLink = driver.findElement(By.id("nav-my-rebates"));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.lblBreadCrumb2)).getText();
		System.out.println(varMyLowes);
		if (varMyLowes.equals("Rebate Center")) {
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
	public void yourAccountCreditCardServices() throws Exception {
		Thread.sleep(6000);
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
		WebElement subLink = driver.findElement(By.id("nav-my-credit-center"));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		selenium.waitForPageToLoad("20000");
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.lblBreadCrumb2)).getText();
		System.out.println(varMyLowes);
		if ((varMyLowes.trim().equalsIgnoreCase("Lowe's Consumer Credit Center")) ||(varMyLowes.trim().equalsIgnoreCase("Lowe’s Consumer Credit Center"))) {
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

	/**
	 * 
	 * @throws Exception
	 */
	public void yourAccountLists() throws Exception {
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
		WebElement subLink = driver.findElement(By.id("nav-portfolio"));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.lblBreadCrumb3)).getText();
		System.out.println(varMyLowes);
		if (varMyLowes.equals("Saved Items")) {
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
	public void yourAccountReminders() throws Exception {
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
		WebElement subLink = driver.findElement(By.id("nav-my-reminders"));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.lblBreadCrumb3)).getText();
		System.out.println(varMyLowes);
		if (varMyLowes.equals("Reminders")) {
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
	public void yourAccountHomeProfile() throws Exception {
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
		WebElement subLink = driver.findElement(By.id("nav-home-profile"));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.lblBreadCrumb2)).getText();
		System.out.println(varMyLowes);
		if (varMyLowes.equals("Home Profile")) {
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
	public void yourAccPrefWithOutSignIn()throws Exception{
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
				By.xpath(UIMapMyLowes.txtSignIn)).getText();
		System.out.println(varMyLowes);
		if (varMyLowes.equals(UIMapMyLowes.lblSignIn)) {
			report.updateTestLog("Clicking Sign In link",
					"Sign In page displayed", Status.PASS);
			driver.findElement(By.id("Ecom_User_ID")).sendKeys(
					dataTable.getData("General_Data", "email"));
			driver.findElement(By.id("logonPassword")).sendKeys(
					dataTable.getData("General_Data", "password"));
			driver.findElement(By.id("logonPassword")).sendKeys(Keys.ENTER);
			//driver.findElement(By.xpath(UIMapMyLowes.btnCreateAccount)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		} else {
			report.updateTestLog("Clicking Sign In link",
					"Sign In page NOT displayed", Status.FAIL);
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void verifyMyLowesViewSource() throws Exception {
		viewSource();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// your account
		driver.findElement(By.xpath(UIMapMyLowes.btnYourAccount))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void verifyPurchasesViewSource() throws Exception {
		verifyMyLowesViewSource();
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void verifySubscriptionsViewSource() throws Exception {
		verifyMyLowesViewSource();
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void verifyCCServicesViewSource() throws Exception {
		verifyMyLowesViewSource();
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void verifyListsViewSource() throws Exception {
		verifyMyLowesViewSource();
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void verifyReminderViewSource() throws Exception {
		verifyMyLowesViewSource();
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void verifyHPViewSource() throws Exception {
		verifyMyLowesViewSource();
	}
	

	/**
	 * 
	 * @throws Exception
	 */
	public void verifyMylowesCardNumber() throws Exception {
		String varMylowesCard = driver
				.findElement(
						By.xpath(UIMapMyLowes.txtMyLowesCardName))
				.getText();
		if (varMylowesCard.equals("MyLowe's Card Number")) {
			report.updateTestLog("You are in MyLowe's Card",
					"You are in MyLowe's Card", Status.PASS);
			String mylowesCardNo = driver
					.findElement(
							By.xpath(UIMapMyLowes.txtMyLowesCardNo))
					.getText();
			if (mylowesCardNo != null) {
				report.updateTestLog("You are in MyLowe's Card",
						"You are in MyLowe's Card", Status.PASS);
			} else {
				report.updateTestLog("You are in MyLowe's Card",
						"You are in MyLowe's Card", Status.FAIL);
			}
		} else {
			report.updateTestLog("You are in MyLowe's Card",
					"You are in MyLowe's Card", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void leftNavPreferences() throws Exception {
		driver.findElement(By.xpath(UIMapMyLowes.btnYourAccount))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// a[@id='nav-my-account']/span[2]
		driver.findElement(By.xpath(UIMapMyLowes.lblPreferences)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// *[@id='nav_profile']/a
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void myLowesCreditCardServices() throws Exception {
		driver.findElement(By.xpath(UIMapMyLowes.btnYourAccount))
				.click();
		String varManageSettings = driver
				.findElement(
						By.xpath(UIMapMyLowes.lblManageSettings))
				.getText();
		if (varManageSettings.equals(UIMapMyLowes.txtManageSettings)) {
			report.updateTestLog("You are in Manage Settings",
					"You are in Manage Settings", Status.PASS);
			boolean creditCardServices = selenium
					.isTextPresent("Credit Cards Services");
			if (creditCardServices) {
				report.updateTestLog("Clicking Your creditCardServices link",
						"creditCardServices link displayed", Status.PASS);
				driver.findElement(By.linkText("Credit Cards Services"))
						.click();
				selenium.waitForPageToLoad("20000");
				Thread.sleep(6000);
				String varMyLowes = driver.findElement(
						By.xpath(UIMapMyLowes.lblBreadCrumb2)).getText();
				if  ((varMyLowes.trim().equalsIgnoreCase("Lowe's Consumer Credit Center")) ||(varMyLowes.trim().equalsIgnoreCase("Lowe’s Consumer Credit Center"))) {
					report.updateTestLog("Clicking Your Account link",
							"MyLowe's page displayed", Status.PASS);
				} else {
					report.updateTestLog("Clicking Your Account link",
							"MyLowe's page NOT displayed", Status.FAIL);
				}
			} else {
				report.updateTestLog("Clicking Your creditCardServices link",
						"creditCardServices link NOT displayed", Status.FAIL);
			}
		} else {
			report.updateTestLog("You are not in Manage Settings",
					"You are not in Manage Settings", Status.FAIL);
		}

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void inspectRebateCenter() throws Exception {
		// online submission
		boolean onlineSubmission = selenium
				.isElementPresent(UIMapMyLowes.lnkRebateOnlineSubmission);
		if (onlineSubmission) {
			report.updateTestLog("Clicking Your onlineSubmission link",
					"onlineSubmission link NOT displayed", Status.PASS);
			driver.findElement(By.xpath(UIMapMyLowes.lnkRebateOnlineSubmission))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		} else {
			report.updateTestLog("Clicking Your EditAccount link",
					"EditAccount link NOT displayed", Status.FAIL);
		}
		// rebate status
		boolean rebateStatus = selenium
				.isElementPresent(UIMapMyLowes.lnkRebateRebateStatus);
		if (rebateStatus) {
			report.updateTestLog("Clicking Your rebateStatus link",
					"rebateStatus link NOT displayed", Status.PASS);
			driver.findElement(
					By.xpath(UIMapMyLowes.lnkRebateRebateStatus))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		} else {
			report.updateTestLog("Clicking Your EditAccount link",
					"EditAccount link NOT displayed", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void verifyViewAllRemindersSort() throws Exception {
		driver.findElement(By.xpath(UIMapMyLowes.btnYourAccount))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

		String varReminders = driver.findElement(By.xpath(UIMapMyLowes.lblReminders))
				.getText();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		if (varReminders.equals(UIMapMyLowes.txtReminders)) {
			report.updateTestLog("Reminder Tab is present",
					"Reminder Tab is present", Status.PASS);
		} else {
			report.updateTestLog("Reminder Tab is not present",
					"Reminder Tab is not present", Status.FAIL);
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		boolean remindersPresent = selenium.isTextPresent("View All Reminders");
		if (remindersPresent) {
			driver.findElement(By.xpath(UIMapMyLowes.lnkViewAllReminders)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		} else {
			report.updateTestLog("View all Reminder button is not present",
					"View all Reminder buttton is not present", Status.FAIL);
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.lblBreadCrumb3)).getText();
		System.out.println(varMyLowes);
		if (varMyLowes.equals("Reminders")) {
			report.updateTestLog("Clicking Your Account link",
					"MyLowe's page displayed", Status.PASS);
		} else {
			report.updateTestLog("Clicking Your Account link",
					"MyLowe's page NOT displayed", Status.FAIL);
		}
	}

	/**
	 * ManageCreditCard goes into manage credit card link
	 * 
	 * @throws Exception
	 */
	public void manageCreditCard() throws Exception {
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.lblManageCreditCard))
				.getText();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		if (varMyLowes.equals(UIMapMyLowes.txtManageCreditCard)) {
			report.updateTestLog("Checking for Manage Credit Card",
					"Manage Credit card displayed", Status.PASS);
		} else {
			report.updateTestLog("Checking for Manage Credit Card",
					"Manage Credit card NOT displayed", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void deactivateManageCreditCard() throws Exception {
		try{
			boolean elementPresent = driver.findElement(
					By.cssSelector(UIMapMyLowes.webElmntManageCrdeitCard))
					.isDisplayed();
			if(elementPresent){
			deactivateMyLowesCreditCard();
			}
		} catch(Exception e) {
			addMyLowesCreditCardDetails();
			selenium.waitForPageToLoad("2000");
			Thread.sleep(6000);
			driver.findElement(By.xpath(UIMapMyLowes.btnDeleteManageCreditCard))
					.click();
			selenium.waitForPageToLoad("2000");
			Thread.sleep(6000);
			driver.findElement(
					By.xpath(UIMapMyLowes.btnCfrmDeleteManageCreditCard))
					.click();
		}
	}

	/**
	 * DeactivateMyLowesCreditCard will Deactivate the credit card details
	 * 
	 * @throws Exception
	 */
	public void deactivateMyLowesCreditCard() throws Exception {
		driver.findElement(
				By.xpath(UIMapMyLowes.lnkManageCreditCard))
				.click();
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.txtManageCreditCards)).getText();
		selenium.waitForPageToLoad("2000");
		Thread.sleep(6000);
		if (varMyLowes.equals("Manage Credit Cards")) {
			report.updateTestLog("Checking for Manage Credit Card",
					"Manage Credit card displayed", Status.PASS);
			driver.findElement(By.xpath(UIMapMyLowes.btnDeleteManageCreditCard))
					.click();
			selenium.waitForPageToLoad("2000");
			Thread.sleep(6000);
			driver.findElement(
					By.xpath(UIMapMyLowes.btnCfrmDeleteManageCreditCard))
					.click();
		} else {
			report.updateTestLog("Checking for Manage Credit Card",
					"Manage Credit card NOT displayed", Status.FAIL);
		}
	}

	/**
	 * addMyLowesCreditCardDetails
	 * 
	 * @throws Exception
	 */
	
	
	public void addMyLowesCreditCardDetails() throws Exception {
		// *[@id='manage_cc_add_cc']/div/h4
		driver.findElement(By.linkText("Add a Credit Card")).click();
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.lblEnterCreditCardInfo)).getText();
		selenium.waitForPageToLoad("2000");
		Thread.sleep(6000);
		if (varMyLowes.equals("Enter Credit Card Information")) {
			report.updateTestLog("Checking for Manage Credit Card",
					"Manage Credit card displayed", Status.PASS);

			driver.findElement(By.id("ccNickName")).clear();
			driver.findElement(By.id("ccNickName")).sendKeys(
					dataTable.getData("General_Data", "nickName"));
			new Select(driver.findElement(By.id("ccType")))
					.selectByVisibleText(dataTable.getData("General_Data",
							"cardType"));
			driver.findElement(By.id("ccAddccno")).clear();
			driver.findElement(By.id("ccAddccno")).sendKeys(
					dataTable.getData("General_Data", "crditCardNo"));
			new Select(driver.findElement(By.id("exMonth")))
					.selectByVisibleText(dataTable.getData("General_Data",
							"month"));
			new Select(driver.findElement(By.id("exYear")))
					.selectByVisibleText(dataTable.getData("General_Data",
							"year"));
			driver.findElement(By.id("bt_ea_save_add_new_cc")).click();
			selenium.waitForPageToLoad("2000");
			Thread.sleep(6000);
			if(selenium.isTextPresent("This nickname is already in use. Please enter a new nickname."))
			{
				System.out.println("Duplicate NickName");
				String newNickName=dataTable.getData("General_Data", "nickName").concat("1");
				System.out.println(newNickName);
				dataTable.putData("General_Data", "nickName", newNickName);
				driver.findElement(By.id("ccNickName")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("ccNickName")).sendKeys(newNickName);
				
				driver.findElement(By.id("bt_ea_save_add_new_cc")).click();
				selenium.waitForPageToLoad("20000");
				Thread.sleep(6000);
			}
			
		} else {
			report.updateTestLog("Checking for Manage Credit Card",
					"Manage Credit card NOT displayed", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void addManageCreditCardInternally() throws Exception {
		driver.findElement(By.xpath(UIMapMyLowes.lnkAddCreditCardInternally)).click();
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.lblEnterCreditCardInfo)).getText();
		selenium.waitForPageToLoad("2000");
		Thread.sleep(6000);
		if (varMyLowes.equals("Enter Credit Card Information")) {
			report.updateTestLog("Checking for Manage Credit Card",
					"Manage Credit card displayed", Status.PASS);

			driver.findElement(By.id("ccNickName")).clear();
			driver.findElement(By.id("ccNickName")).sendKeys(
					dataTable.getData("General_Data", "nickName2"));
			new Select(driver.findElement(By.id("ccType")))
					.selectByVisibleText(dataTable.getData("General_Data",
							"cardType"));
			driver.findElement(By.id("ccAddccno")).clear();
			driver.findElement(By.id("ccAddccno")).sendKeys(
					dataTable.getData("General_Data", "crditCardNo"));
			// click on month
			new Select(driver.findElement(By.id("exMonth")))
					.selectByVisibleText(dataTable.getData("General_Data",
							"month"));
			// click on year
			new Select(driver.findElement(By.id("exYear")))
					.selectByVisibleText(dataTable.getData("General_Data",
							"year"));
			driver.findElement(By.id("bt_ea_save_add_new_cc")).click();
			selenium.waitForPageToLoad("2000");
			Thread.sleep(6000);
			if(selenium.isTextPresent("This nickname is already in use. Please enter a new nickname."))
			{
				System.out.println("Duplicate NickName");
				String newNickName=dataTable.getData("General_Data", "nickName2").concat("1");
				dataTable.putData("General_Data", "nickName2", newNickName);
				System.out.println(newNickName);
				driver.findElement(By.id("ccNickName")).clear();
				Thread.sleep(1000);
				driver.findElement(By.id("ccNickName")).sendKeys(newNickName);
				
				driver.findElement(By.id("bt_ea_save_add_new_cc")).click();
				selenium.waitForPageToLoad("20000");
				Thread.sleep(6000);
			}
			
			
			String varAddedCard=driver.findElement(By.xpath(UIMapMyLowes.lblCardName)).getText();
			if(varAddedCard.equals(dataTable.getData("General_Data", "nickName2")))
				report.updateTestLog("Adding Credit Card",
						"Added Credit card displayed", Status.PASS);
			else
				report.updateTestLog("Adding Credit Card",
						"Added Credit card NOT displayed", Status.FAIL);
			
			
		} else {
			report.updateTestLog("Checking for Manage Credit Card",
					"Manage Credit card NOT displayed", Status.FAIL);
		}

	}

	
	public void deleteAddedCard() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.lnkDeleteAddedCard)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(UIMapMyLowes.btnCfrmDeleteManageCreditCard)).click();
		Thread.sleep(5000);
	}
	public void deletePrimaryCard() throws Exception
	{
		driver.findElement(By.xpath("(//a[contains(text(),'Delete')])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(UIMapMyLowes.btnCfrmDeleteManageCreditCard)).click();
		selenium.waitForPageToLoad("200000");
		Thread.sleep(10000);
		if(selenium.isTextPresent("You have no credit cards on file") && selenium.isElementPresent("Add a Credit Card"))
			report.updateTestLog("Verifying Credit Cards module","Add a Credit Card link displayed",Status.PASS);
		else
			report.updateTestLog("Verifying Credit Cards module","Add a Credit Card link NOT displayed",Status.FAIL);
	}
	/**
	 * 
	 * @throws Exception
	 */
	public void makePrimaryCreditCard() throws Exception {
		driver.findElement(By.xpath(UIMapMyLowes.webElmntMakePrimary)).click();
		selenium.waitForPageToLoad("2000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void editSecondaryCreditCard() throws Exception {
		driver.findElement(By.xpath(UIMapMyLowes.webElmntEditSCCard)).click();
		selenium.waitForPageToLoad("2000");
		Thread.sleep(6000);
		// div[7]/div[2]/div/a
		driver.findElement(By.xpath(UIMapMyLowes.txtSCCardNickName))
				.clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtSCCardNickName))
				.sendKeys(dataTable.getData("General_Data", "nickName"));
		//driver.findElement(By.xpath(UIMapMyLowes.txtSCCardMonth)).clear();
		new Select(driver.findElement(By
				.xpath(UIMapMyLowes.txtSCCardMonth)))
				.selectByVisibleText(dataTable.getData("General_Data", "month"));
		//driver.findElement(By.xpath(UIMapMyLowes.txtSCCardYear)).clear();
		new Select(
				driver.findElement(By.xpath(UIMapMyLowes.txtSCCardYear)))
				.selectByVisibleText(dataTable.getData("General_Data", "year"));
		selenium.waitForPageToLoad("2000");
		Thread.sleep(6000);
		driver.findElement(
				By.xpath(UIMapMyLowes.btnSaveEditManageCreditCard))
				.click();
		selenium.waitForPageToLoad("2000");
		Thread.sleep(6000);
		
		
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void editManageCreditCard() throws Exception {
		try {
			boolean elementPresent = driver.findElement(
					By.cssSelector(UIMapMyLowes.webElmntManageCrdeitCard))
					.isDisplayed();
			if(elementPresent){
			editMyLowesCreditCard();
			}
		} catch(Exception e) {
			addMyLowesCreditCardDetails();
			//selenium.waitForPageToLoad("2000");
			Thread.sleep(6000);
			System.out.println("CreditCardDetails entered");
			driver.findElement(By.xpath(UIMapMyLowes.webElmntEditPCCard)).click();
			Thread.sleep(2000);
			/* Editing Credit card details */
			driver.findElement(By.xpath(UIMapMyLowes.txtSCCardNickName))
					.clear();
			driver.findElement(By.xpath(UIMapMyLowes.txtSCCardNickName))
					.sendKeys(dataTable.getData("General_Data", "nickName"));
			// click on month
			new Select(driver.findElement(By
					.xpath(UIMapMyLowes.txtSCCardMonth)))
					.selectByVisibleText(dataTable.getData("General_Data",
							"month"));
			// select previous year
			new Select(driver.findElement(By
					.xpath(UIMapMyLowes.txtSCCardYear)))
					.selectByVisibleText("2013");
			selenium.waitForPageToLoad("2000");
			Thread.sleep(6000);
			// click on year
			new Select(driver.findElement(By
					.xpath(UIMapMyLowes.txtSCCardYear)))
					.selectByVisibleText(dataTable.getData("General_Data",
							"year"));
			selenium.waitForPageToLoad("2000");
			Thread.sleep(6000);
			driver.findElement(
					By.xpath(UIMapMyLowes.btnSaveEditManageCreditCard))
					.click();
			selenium.waitForPageToLoad("2000");
			Thread.sleep(6000);
		}
	}

	/**
	 * editMyLowesCreditCard Will Edit the MyLowes Credit card details
	 * 
	 * @throws Exception
	 */
	public void editMyLowesCreditCard() throws Exception {
		driver.findElement(
				By.xpath(UIMapMyLowes.lnkManageCreditCard))
				.click();
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.txtManageCreditCards)).getText();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		if (varMyLowes.equals("Manage Credit Cards")) {
			report.updateTestLog("Checking for Manage Credit Card",
					"Manage Credit card displayed", Status.PASS);
			driver.findElement(By.xpath(UIMapMyLowes.webElmntEditPCCard)).click();
			/* Editing Credit card details */
			driver.findElement(By.xpath(UIMapMyLowes.txtSCCardNickName))
					.clear();
			driver.findElement(By.xpath(UIMapMyLowes.txtSCCardNickName))
					.sendKeys(dataTable.getData("General_Data", "nickName"));
			// click on month
			new Select(driver.findElement(By
					.xpath(UIMapMyLowes.txtSCCardMonth)))
					.selectByVisibleText(dataTable.getData("General_Data",
							"month"));
			// selecting past year
			new Select(driver.findElement(By
					.xpath(UIMapMyLowes.txtSCCardYear)))
					.selectByVisibleText("2013");
			selenium.waitForPageToLoad("2000");
			Thread.sleep(6000);
			// select year
			new Select(driver.findElement(By
					.xpath(UIMapMyLowes.txtSCCardYear)))
					.selectByVisibleText(dataTable.getData("General_Data",
							"year"));
			selenium.waitForPageToLoad("2000");
			Thread.sleep(6000);
			driver.findElement(
					By.xpath(UIMapMyLowes.btnSaveEditManageCreditCard))
					.click();
			selenium.waitForPageToLoad("2000");
			Thread.sleep(6000);
		} else {
			report.updateTestLog("Checking for Manage Credit Card",
					"Manage Credit card NOT displayed", Status.FAIL);
		}
	}

	/**
	 * editAccountInformatio will Edit the Accout Information details
	 * 
	 * @throws Exception
	 */
	public void editAccountInformation() throws Exception {
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.lblEditAccInfo))
				.getText();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		if (varMyLowes.equals(UIMapMyLowes.txtAccInfo)) {
			report.updateTestLog("Checking for Account Information",
					"Account Information displayed", Status.PASS);
			driver.findElement(
					By.xpath(UIMapMyLowes.webElmntEditAccInfo))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			// retrieving Edit Account Information
			String editAcc = driver.findElement(
					By.xpath(UIMapMyLowes.lnkEditAccInfo))
					.getText();
			// click on Edit account Information
			if (editAcc.equals(UIMapMyLowes.txtEditAccount)) {
				report.updateTestLog("Checking for Edit Account Information",
						"Edit Account Information displayed", Status.PASS);

				// retrieving Name String
				String editAccName = driver
						.findElement(
								By.xpath(UIMapMyLowes.lblAccName))
						.getText();
				// checking Name
				if (editAccName.equals(UIMapMyLowes.txtAccName)) {
					report.updateTestLog(
							"Checking for Edit Account Information Name",
							"Name Edit Account Information displayed",
							Status.PASS);
					driver.findElement(
							By.xpath(UIMapMyLowes.webElmntChangeName))
							.click();
					selenium.waitForPageToLoad("20000");
					Thread.sleep(6000);
					driver.findElement(By.id("fname")).clear();
					driver.findElement(By.id("fname")).sendKeys(
							dataTable.getData("General_Data", "Firstname"));
					driver.findElement(By.id("lname")).clear();
					driver.findElement(By.id("lname")).sendKeys(
							dataTable.getData("General_Data", "Lastname"));
					selenium.waitForPageToLoad("20000");
					Thread.sleep(6000);
					driver.findElement(By.id("bt_ea_save_name")).click();
					selenium.waitForPageToLoad("2000");
					Thread.sleep(6000);
				} else {
					report.updateTestLog(
							"Checking for Edit Account Information Name",
							"Edit Account Information Name NOT displayed",
							Status.FAIL);
				}

				// retrieving EmailAddress
				String editAccEmailAddress = driver
						.findElement(
								By.xpath(UIMapMyLowes.lblAccEmail))
						.getText();
				// checking EmailAddress
				if (editAccEmailAddress.equals(UIMapMyLowes.txtAccEmail)) {
					report.updateTestLog(
							"Checking for Edit Account Information Email Address",
							"Edit Account Information Email Address  displayed",
							Status.PASS);
					driver.findElement(
							By.xpath(UIMapMyLowes.webElmntChangeEmail))
							.click();
					selenium.waitForPageToLoad("20000");
					Thread.sleep(6000);
					driver.findElement(By.id("logonId")).clear();
					driver.findElement(By.id("logonId")).sendKeys(
							dataTable.getData("General_Data", "email"));
					driver.findElement(By.id("logonIdVerify")).clear();
					driver.findElement(By.id("logonIdVerify")).sendKeys(
							dataTable.getData("General_Data", "email"));
					selenium.waitForPageToLoad("20000");
					Thread.sleep(6000);
					driver.findElement(By.id("bt_ea_save_email")).click();
					selenium.waitForPageToLoad("2000");
					Thread.sleep(6000);
				} else {
					report.updateTestLog(
							"Checking for Edit Account Information Email Address",
							"Edit Account Information Email Address NOT displayed",
							Status.FAIL);
				}

				// retrieving password
				String editAccPassword = driver
						.findElement(
								By.xpath(UIMapMyLowes.lblAccPassword))
						.getText();
				// checking password
				if (editAccPassword.equals(UIMapMyLowes.txtAccPassword)) {
					report.updateTestLog(
							"Checking for Edit Account Information Password",
							"Edit Account Information Password displayed",
							Status.PASS);
					driver.findElement(
							By.xpath(UIMapMyLowes.webElmntChangePassword))
							.click();
					selenium.waitForPageToLoad("20000");
					Thread.sleep(6000);
					driver.findElement(By.id("oldLogonPassword")).clear();
					driver.findElement(By.id("oldLogonPassword")).sendKeys(
							dataTable.getData("General_Data", "password"));
					driver.findElement(By.id("logonPassword")).clear();
					driver.findElement(By.id("logonPassword")).sendKeys(
							dataTable.getData("General_Data", "password"));
					driver.findElement(By.id("logonPasswordVerify")).clear();
					driver.findElement(By.id("logonPasswordVerify")).sendKeys(
							dataTable.getData("General_Data", "confpassword"));
					selenium.waitForPageToLoad("20000");
					Thread.sleep(6000);
					driver.findElement(By.id("bt_ea_save_password")).click();
					selenium.waitForPageToLoad("2000");
					Thread.sleep(6000);
				} else {
					report.updateTestLog(
							"Checking for Edit Account Information Password",
							"Edit Account Information Password NOT displayed",
							Status.FAIL);
				}
				selenium.waitForPageToLoad("2000");
				Thread.sleep(6000);
				// calling addEmployeeBenefitCode
				addEmployeeBenefitCode();
				selenium.waitForPageToLoad("2000");
				Thread.sleep(6000);
			} else {
				report.updateTestLog("Checking for Edit Account Information",
						"Edit Account Information NOT displayed", Status.FAIL);
			}// closing Edit Account Information

		} else {
			report.updateTestLog("Checking for Account Information",
					"Account Information NOT displayed", Status.FAIL);
		}// closing Account Information

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void addEmployeeBenefitCode() throws Exception {
		// retrieving BenefitCode
		String editAccBenefitCode = driver
				.findElement(
						By.xpath(UIMapMyLowes.lblAccBCode))
				.getText();
		// checking BenefitCode
		if (editAccBenefitCode.equals(UIMapMyLowes.txtAccBCode)) {
			report.updateTestLog(
					"Checking for Edit Account Information Benefit Code",
					"Edit Account Information Benefit Code displayed",
					Status.PASS);
			driver.findElement(
					By.xpath(UIMapMyLowes.webElmntChangeBCode))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			driver.findElement(By.id("benefitCode")).clear();
			driver.findElement(By.id("benefitCode")).sendKeys(
					dataTable.getData("General_Data", "benefitCode"));
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			driver.findElement(By.id("bt_ea_save_benefit")).click();
			selenium.waitForPageToLoad("2000");
			Thread.sleep(6000);
		} else {
			report.updateTestLog(
					"Checking for Edit Account Information Benefit Code",
					"Edit Account Information Benefit Code NOT displayed",
					Status.FAIL);
		}// closing BenefitCode
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void verifyLowesEmployee() throws Exception {
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.lblEditAccInfo))
				.getText();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		if (varMyLowes.equals(UIMapMyLowes.txtAccInfo)) {
			report.updateTestLog("Checking for Account Information",
					"Account Information displayed", Status.PASS);
			driver.findElement(
					By.xpath(UIMapMyLowes.webElmntEditAccInfo))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			// retrieving Edit Account Information
			String editAcc = driver.findElement(
					By.xpath(UIMapMyLowes.lnkEditAccInfo))
					.getText();
			// click on Edit account Information
			if (editAcc.equals(UIMapMyLowes.txtEditAccount)) {
				report.updateTestLog("Checking for Edit Account Information",
						"Edit Account Information displayed", Status.PASS);
				addEmployeeBenefitCode();
				boolean lowesEmployee = selenium.isTextPresent("- (Employee)");
				if (lowesEmployee) {
					report.updateTestLog("Login Employee is Lowes Employee",
							"Login Employee is Lowes Employee", Status.PASS);
				} else {
					report.updateTestLog(
							"Login Employee is not Lowes Employee",
							"Login Employee is not Lowes Employee", Status.FAIL);
				}
			} else {
				report.updateTestLog("Checking for Edit Account Information",
						"Edit Account Information NOT displayed", Status.FAIL);
			}// closing Edit Account Information

		} else {
			report.updateTestLog("Checking for Account Information",
					"Account Information NOT displayed", Status.FAIL);
		}// closing Account Information

		/*
		 * String lowesEmployee = driver .findElement(
		 * By.xpath("//*[@id='lowes-salutation-active']/a[1]/span/span"))
		 * .getText(); // checking lowes employee if
		 * (lowesEmployee.equals("- (Employee)")) {
		 * report.updateTestLog("Login Employee is Lowes Employee",
		 * "Login Employee is Lowes Employee", Status.PASS); } else {
		 * report.updateTestLog("Login Employee is not Lowes Employee",
		 * "Login Employee is not Lowes Employee", Status.FAIL); }
		 */
	}

	/**
	 * subscriptionsPrintPublications will select Print Publications from
	 * subscriptions and save those
	 * 
	 * @throws Exception
	 */
	public void subscriptionsPrintPublications() throws Exception {
		String varSubscriptions = driver.findElement(
				By.xpath(UIMapMyLowes.lblSubscriptionsHeading)).getText();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

		// check for Subscriptions
		if (varSubscriptions.equals(UIMapMyLowes.txtSubscriptions)) {
			report.updateTestLog("Checking for Subscriptions",
					"Subscriptions displayed", Status.PASS);
			String varEnewsLetter = driver
					.findElement(
							By.xpath(UIMapMyLowes.lblENewsletters))
					.getText();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			/* E-NewsLetter */
			if (varEnewsLetter.equals(UIMapMyLowes.txtENewsletters)) {
				report.updateTestLog("Checking for Subscriptions",
						"Subscriptions displayed", Status.PASS);
				// click on default selected element
				driver.findElement(By.id("opt_promo_email")).click();
				String varPrintPublications = driver
						.findElement(
								By.xpath(UIMapMyLowes.lblPrintPublications))
						.getText();
				selenium.waitForPageToLoad("20000");
				Thread.sleep(6000);
				/* Print Publications */
				if (varPrintPublications.equals(UIMapMyLowes.txtPrintPublications)) {
					driver.findElement(By.id("opt_LCI_printed")).click();
					/*driver.findElement(By.id("opt_LCI_ideas_creativas_printed"))
							.click();*/
					driver.findElement(
							By.xpath("//a[@id='subscriptionsSubmit']"))
							.click();
				} else {
					report.updateTestLog("Checking for Subscriptions",
							"Subscriptions NOT displayed", Status.FAIL);
				}// end of EnewsLetter
			} else {
				report.updateTestLog("Checking for Subscriptions",
						"Subscriptions NOT displayed", Status.FAIL);
			}// end of EnewsLetter
		} else {
			report.updateTestLog("Checking for Subscriptions",
					"Subscriptions NOT displayed", Status.FAIL);
		}// end of Subscriptions

	}

	/**
	 * editPrimaryAddressPreferences
	 * 
	 * @throws Exception
	 */
	public void editPrimaryAddressPreferences() throws Exception {
		driver.findElement(
				By.xpath(UIMapMyLowes.webElmntEditPAddress))
				.click();
		//driver.findElement(By.cssSelector("#add_new_address > span")).click();
		driver.findElement(By.xpath(UIMapMyLowes.btnSaveEditPAddress)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void addPrimaryAddress() throws Exception {
		// *[@id='dashboard']/div/div[2]/div[2]/div[2]/a
		driver.findElement(
				By.xpath(UIMapMyLowes.webElmntEditPAddress))
				.click();
		driver.findElement(By.xpath(UIMapMyLowes.lblPrimaryAddress1)).sendKeys(
				dataTable.getData("General_Data", "Address1"));
		/*
		 * driver.findElement(By.xpath("(//input[@id='address2'])[2]")).sendKeys(
		 * dataTable.getData("General_Data", "password"));
		 */
		driver.findElement(By.xpath(UIMapMyLowes.lblPrimaryCity)).sendKeys(
				dataTable.getData("General_Data", "City"));
		new Select(driver.findElement(By.xpath(UIMapMyLowes.lblPrimaryState)))
				.selectByVisibleText(dataTable.getData("General_Data", "State"));
		driver.findElement(By.xpath(UIMapMyLowes.lblPrimaryZipCode)).sendKeys(
				dataTable.getData("General_Data", "zipcode"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.btnSaveEditPAddress)).click();
		// pop up when given address with spelling mistake
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		boolean uspsContinue = selenium.isTextPresent("Confirm");
		if(uspsContinue){
		driver.findElement(By.xpath(UIMapMyLowes.btnCfrmUSPSAddress))
				.click();
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * editAddressPreferences
	 * 
	 * @throws Exception
	 */
	public void editAddressPreferences() throws Exception {
		driver.findElement(By.xpath(UIMapMyLowes.webElmntEditAddressPreferences)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.linkText("Edit")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		editAddress();
		driver.findElement(By.xpath(UIMapMyLowes.btnSaveEditPAddress)).click();
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void editAddress() throws Exception {
		Thread.sleep(6000);
		// clearing all the fields
		driver.findElement(By.xpath(UIMapMyLowes.lblEditAddress1))
				.clear();
		driver.findElement(By.xpath(UIMapMyLowes.lblEditAddress2))
				.clear();
		driver.findElement(By.xpath(UIMapMyLowes.lblEditFname)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.lblEditLname)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.lblPrimaryAddress1)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.lblEditaddress)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.lblPrimaryCity)).clear();
		new Select(driver.findElement(By.xpath(UIMapMyLowes.lblPrimaryState)))
				.selectByVisibleText("Choose a State");
		driver.findElement(By.xpath(UIMapMyLowes.lblPrimaryZipCode)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.lblEditPhone)).clear();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * addValidAddress
	 * 
	 * @throws Exception
	 */
	public void addValidAddress() throws Exception {
		driver.findElement(By.xpath(UIMapMyLowes.lblEditAddress2))
				.sendKeys(dataTable.getData("General_Data", "nickName"));
		/*
		 * driver.findElement(By.xpath("(//input[@id='addressField2'])[2]"))
		 * .sendKeys(dataTable.getData("General_Data", "password"));
		 */
		driver.findElement(By.xpath(UIMapMyLowes.lblEditFname)).sendKeys(
				dataTable.getData("General_Data", "Firstname"));
		driver.findElement(By.xpath(UIMapMyLowes.lblEditLname)).sendKeys(
				dataTable.getData("General_Data", "Lastname"));
		driver.findElement(By.xpath(UIMapMyLowes.lblPrimaryAddress1)).sendKeys(
				dataTable.getData("General_Data", "Address1"));
		/*
		 * driver.findElement(By.xpath("(//input[@id='address2'])[2]")).sendKeys(
		 * dataTable.getData("General_Data", "password"));
		 */
		driver.findElement(By.xpath(UIMapMyLowes.lblPrimaryCity)).sendKeys(
				dataTable.getData("General_Data", "City"));
		new Select(driver.findElement(By.xpath(UIMapMyLowes.lblPrimaryState)))
				.selectByVisibleText(dataTable.getData("General_Data", "State"));
		driver.findElement(By.xpath(UIMapMyLowes.lblPrimaryZipCode)).sendKeys(
				dataTable.getData("General_Data", "zipcode"));
		driver.findElement(By.xpath(UIMapMyLowes.lblEditPhone)).sendKeys(
				dataTable.getData("General_Data", "phone"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.btnSaveEditPAddress)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		if(selenium.isTextPresent("The address name you entered is already in use. Please enter another address name."))
		{
			String newNickName=dataTable.getData("General_Data", "nickName").concat("1");
			dataTable.putData("General_Data", "nickName", newNickName);
			driver.findElement(By.xpath(UIMapMyLowes.lblEditAddress2)).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath(UIMapMyLowes.lblEditAddress2)).sendKeys(newNickName);
			driver.findElement(By.xpath(UIMapMyLowes.btnSaveEditPAddress)).click();
			
			Thread.sleep(6000);
		}
		
		

	}

	/**
	 * addValidAddress
	 * 
	 * @throws Exception
	 */
	public void addValidUSPSAddress() throws Exception {
		driver.findElement(By.id("addressField2")).click();
		Thread.sleep(1000);
		System.out.println("Nick Name in excel:"+dataTable.getData("General_Data", "nickName"));
		driver.findElement(By.id("addressField2")).sendKeys(
				dataTable.getData("General_Data", "nickName"));
		/*
		 * driver.findElement(By.xpath("(//input[@id='addressField2'])[2]"))
		 * .sendKeys(dataTable.getData("General_Data", "password"));
		 */
		driver.findElement(By.id("firstName")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("firstName")).sendKeys(
				dataTable.getData("General_Data", "Firstname"));
		
		driver.findElement(By.id("lastName")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("lastName")).sendKeys(
				dataTable.getData("General_Data", "Lastname"));
		
		driver.findElement(By.id("address1")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("address1")).sendKeys(
				dataTable.getData("General_Data", "Address1"));
		
		/*
		 * driver.findElement(By.xpath("(//input[@id='address2'])[2]")).sendKeys(
		 * dataTable.getData("General_Data", "password"));
		 */
		driver.findElement(By.id("city")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("city")).sendKeys(
				dataTable.getData("General_Data", "City"));
		
		new Select(driver.findElement(By.id("state")))
				.selectByVisibleText(dataTable.getData("General_Data", "State"));
		
		driver.findElement(By.id("zipCode")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("zipCode")).sendKeys(
				dataTable.getData("General_Data", "zipcode"));
		
		driver.findElement(By.name("phone1")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("phone1")).sendKeys(
				dataTable.getData("General_Data", "phone"));
		
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.btnAddAddress)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(3000);
		if(selenium.isTextPresent("This nickname is already in use. Please enter a new nickname."))
		{
			System.out.println("Duplicate NickName");
			String newNickName=dataTable.getData("General_Data", "nickName").concat("1");
			dataTable.putData("General_Data", "nickName", newNickName);
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
	public void addSecondaryAddress() throws Exception {
		driver.findElement(
				By.xpath(UIMapMyLowes.webElmntEditPAddress))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		addSecondaryAddressInternally();
		Thread.sleep(8000);
		
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void addSecondaryAddressInternally()throws Exception{
		driver.findElement(By.cssSelector("#add_new_address > span")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		addValidUSPSAddress();
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void checkAddressFields() throws Exception {
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

		// wrong zipcode
		driver.findElement(By.id("zipCode")).clear();
		driver.findElement(By.id("zipCode")).sendKeys(
				dataTable.getData("General_Data", "zipcode2"));
		// *[@id='cbc-registration']/div[1]/ul/li[3]/div[2]/form/div[2]/p

		// wrong City
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys(
				dataTable.getData("General_Data", "City2"));
		driver.findElement(By.xpath(UIMapMyLowes.btnAddAddress)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

		// wrong State
		driver.findElement(By.id("city")).clear();
		new Select(driver.findElement(By.id("state")))
				.selectByVisibleText(dataTable
						.getData("General_Data", "State2"));
		driver.findElement(By.xpath(UIMapMyLowes.btnAddAddress)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void readPhoneNumberFormat() throws Exception {
		driver.findElement(
				By.xpath(UIMapMyLowes.webElmntEditPAddress))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		String areaCode = driver.findElement(
				By.xpath(UIMapMyLowes.lblPhoneFirst)).getText();
		String middleCode = driver.findElement(
				By.xpath(UIMapMyLowes.lblPhoneMiddle)).getText();
		String lastCode = driver.findElement(
				By.xpath(UIMapMyLowes.lblPhoneLast)).getText();
		if (!areaCode.isEmpty()) {
			report.updateTestLog("areaCode present", "areaCode present",
					Status.PASS);
		} else {
			report.updateTestLog("areaCode not present",
					"areaCode not present", Status.FAIL);
		}
		if (!middleCode.isEmpty()) {
			report.updateTestLog("middleCode present", "middleCode present",
					Status.PASS);
		} else {
			report.updateTestLog("middleCode not present",
					"middleCode not present", Status.FAIL);
		}
		if (!lastCode.isEmpty()) {
			report.updateTestLog("lastCode present", "lastCode present",
					Status.PASS);
		} else {
			report.updateTestLog("lastCode not present",
					"lastCode not present", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void confirmUspsEnteredAddress() throws Exception {
		driver.findElement(
				By.xpath(UIMapMyLowes.webElmntEditPAddress))
				.click();
		driver.findElement(By.cssSelector("#add_new_address > span")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		addValidUSPSAddress();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntUspsAddress)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntCnfrmUspsAddress)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void deleteSecondaryAddress() throws Exception {
		driver.findElement(By.partialLinkText("Delete")).click();
		Thread.sleep(8000);
		driver.findElement(By.id("bt_confirm_delete_address")).click();
	}

	
	/**
	 * cancelEditPrimaryAddress
	 * 
	 * @throws Exception
	 */
	public void cancelEditPrimaryAddress() throws Exception {
		driver.findElement(
				By.xpath(UIMapMyLowes.webElmntEditPAddress))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntCancelEditPriAddress)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		editAddress();
		driver.findElement(By.xpath(UIMapMyLowes.btnCnfrmCancelPriAddress))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	
	/**
	 * 
	 * @throws Exception
	 */
	public void cancelEditSecondaryAddress() throws Exception {
		driver.findElement(
				By.xpath(UIMapMyLowes.webElmntEditPAddress))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntCancelEditSecAddress)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		editAddress();
		driver.findElement(By.xpath(UIMapMyLowes.btnCnfrmCancelPriAddress))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void editPrimaryAddress() throws Exception {
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntCancelEditPriAddress))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		editAddress();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		addValidAddress();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void editSecondaryAddress() throws Exception {
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntCancelEditSecAddress)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		editAddress();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		addValidAddress();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void inspectDeleteForPrimary() throws Exception {
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		String name = driver.findElement(
				By.xpath(UIMapMyLowes.webElmntCancelEditPriAddress)).getText();
		if (name.equals("Delete")) {
			report.updateTestLog("Not Primary Address", "Not Primary Address",
					Status.FAIL);
		}
	}

	/**
	 * setReminder
	 * 
	 * @throws Exception
	 */
	public void setReminderForItem() throws Exception {
		boolean helpIconPresent = selenium
				.isElementPresent(UIMapMyLowes.imgHelpIconPresent);
		if (helpIconPresent) {
			driver.findElement(
					By.xpath(UIMapMyLowes.imgHelpIconPresent)).click();
			Thread.sleep(2000);
			driver.navigate().refresh();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		}
		//selenium.waitForPageToLoad("20000");
		//Thread.sleep(6000);
		driver.findElement(
				By.xpath(UIMapMyLowes.webElmntSetItemForReminder))
				.click();
		Thread.sleep(2000);
		boolean click = selenium.isTextPresent("Continue");
		if (click) {
			driver.findElement(By.linkText("Continue")).click();
			Thread.sleep(3000);
		}
		String emailContentDisplayed = driver.findElement(
				By.xpath(UIMapMyLowes.lblEmailText1)).getText();
		String[] s = emailContentDisplayed.split(":");
		String emailTo = s[0];
		System.out.println(emailTo);
		String email = s[1];
		System.out.println(email);
		String textContentDisplayed = driver.findElement(
				By.xpath(UIMapMyLowes.lblEmailText2)).getText();
		System.out.println(textContentDisplayed);
		if (!email.isEmpty()) {
			if (!textContentDisplayed.isEmpty()) {
				System.out.println("Clicking Date Picker");
				driver.findElement(By.cssSelector("img.ui-datepicker-trigger"))
						.click();
				//selenium.waitForPageToLoad("20000");
				Thread.sleep(6000);
				/*DateFormat dateFormat = new SimpleDateFormat("dd");
				Date date = new Date();
				String link = dateFormat.format(date);
				System.out.println(link);
				int next = Integer.parseInt(link);
				System.out.println(next);
				next = next + 1;
				
				String tomorrow = Integer.toString(next);
				System.out.println(tomorrow);*/
				DateFormat dateFormat = new SimpleDateFormat("d");
				Calendar calendar = Calendar.getInstance();
				calendar.add(Calendar.DAY_OF_YEAR, 1);
				Date tomorrow = calendar.getTime();
				String varDate=dateFormat.format(tomorrow);
				System.out.println(varDate);
				driver.findElement(By.linkText(varDate)).click();
				//selenium.waitForPageToLoad("20000");
				Thread.sleep(6000);
				driver.findElement(
						By.cssSelector("a.button.reminder_notes_save_continue > span"))
						.click();
				Thread.sleep(2000);
				driver.findElement(By.cssSelector("div.headline > a.close"))
						.click();
			} else {
				report.updateTestLog("Reminder Content not present",
						"Reminder Content not present", Status.FAIL);
			}
		} else {
			report.updateTestLog("Email address not present",
					"Email address not present", Status.FAIL);
		}

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void searchItemUsingName() throws Exception {
		selenium.windowFocus();
		selenium.waitForPageToLoad("15000");
		driver.findElement(By.id("Ntt")).sendKeys(
				dataTable.getData("General_Data", "searchName"));
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
		report.updateTestLog(
				"Searching For an Item using Name",
				"Searching By Name - "
						+ dataTable.getData("General_Data", "searchName") + "",
				Status.DONE);
		selenium.waitForPageToLoad("30000");
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void setReminderThroughPL() throws Exception {
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

		//selenium.waitForPageToLoad("30000");
		boolean selectElement = driver.findElement(By.xpath(UIMapMyLowes.txtElementDisplayed))
				.isDisplayed();
		if (selectElement) {
			driver.findElement(By.xpath(UIMapMyLowes.txtElementDisplayed)).click();
		} else {
			report.updateTestLog("Select of first element is failed",
					"Element NOT Present", Status.FAIL);
		}
		// Set Reminder from product list page
		setReminderForItem();
		selenium.waitForPageToLoad("30000");

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void saveItemThroughPL() throws Exception {
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
		saveItem();
		selenium.waitForPageToLoad("30000");
	}
	
	public void saveItemThroughPLLoggedIn() throws Exception {
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

		/*selenium.waitForPageToLoad("30000");
		boolean selectElement = driver.findElement(By.xpath(UIMapMyLowes.txtElementDisplayed))
				.isDisplayed();
		if (selectElement) {
			driver.findElement(By.xpath(UIMapMyLowes.txtElementDisplayed)).click();
		} else {
			report.updateTestLog("Select of first element is failed",
					"Element NOT Present", Status.FAIL);
		}*/
		ps.selectInStockProduct();
		saveItemForLoggedIn();
		selenium.waitForPageToLoad("30000");
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void saveItem() throws Exception {
		try{driver.findElement(By.cssSelector("span.text")).click();
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.cssSelector("span.text")).click();
		}
		
		driver.findElement(By.cssSelector("a.folders-and-lists > span.text"))
				.click();
		Thread.sleep(5000);
		boolean elementPresent = selenium.isTextPresent(UIMapMyLowes.lblSignIn);
		if (elementPresent) {
			report.updateTestLog("Clicking Sign In link",
					"Sign In page displayed", Status.PASS);
			/*driver.findElement(By.id("Ecom_User_ID")).sendKeys(
					dataTable.getData("General_Data", "email"));
			driver.findElement(By.id("logonPassword")).sendKeys(
					dataTable.getData("General_Data", "password"));
			//driver.findElement(By.xpath(UIMapMyLowes.btnCreateAccount)).click();
			driver.findElement(By.id("logonPassword")).sendKeys(Keys.ENTER);*/
			
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
			
			String getLoggedInUser=driver.findElement(By.xpath(UIMapFunctionalComponents.webElmntSalutation)).getText().trim();
			System.out.println("Verifying the Registered User detais :"+getLoggedInUser);
			if(getLoggedInUser.contains("Welcome, "+dataTable.getData("General_Data","Firstname")))          // Verifying the registered user details by Using Firstname
			{
				report.updateTestLog("Validating Login Credentials","Login Successful", Status.PASS);
			}
			else
			{
				report.updateTestLog("Validating Login Credentials","Login Failed..! for User "+dataTable.getData("General_Data","email")+" ", Status.FAIL);
			}
			
			signOutMyLowesLandingPage();
		} else {
			report.updateTestLog("Clicking Sign In link",
					"Sign In page NOT displayed", Status.FAIL);
		}
	}

	
	public void saveItemForLoggedIn() throws Exception {
		try{driver.findElement(By.cssSelector("span.text")).click();
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.cssSelector("span.text")).click();
		}
		
		driver.findElement(By.cssSelector("a.folders-and-lists > span.text"))
				.click();
		Thread.sleep(5000);
		
			/*driver.findElement(By.id("Ecom_User_ID")).sendKeys(
					dataTable.getData("General_Data", "email"));
			driver.findElement(By.id("logonPassword")).sendKeys(
					dataTable.getData("General_Data", "password"));
			//driver.findElement(By.xpath(UIMapMyLowes.btnCreateAccount)).click();
			driver.findElement(By.id("logonPassword")).sendKeys(Keys.ENTER);*/
			
			
		boolean verItemSaved=selenium.isTextPresent("Item Saved");
		if(verItemSaved)
		{
			report.updateTestLog("Saving To List", "Saved to List successfully", Status.PASS);
		}
		else
			report.updateTestLog("Saving To List", "NOT Saved to List", Status.FAIL);
		
	}
		
	
	/**
	 * 
	 * @throws Exception
	 */
	public void checkingProductName() throws Exception {

		
		String varGetNameFromPL = driver.findElement(
				By.xpath(UIMapMyLowes.txtGetNameFromPL)).getText();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		
		// Set Reminder from YourAccount
		yourAccountReminders();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(2000);
		driver.navigate().refresh();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		String varGetNameFromReminderyourAccount = driver
				.findElement(
						By.xpath(UIMapMyLowes.txtGetNameFromReminderyourAccount))
				.getText();
		if (varGetNameFromPL.equals(varGetNameFromReminderyourAccount)) {
			report.updateTestLog("Item Name Matching", "Item Name displayed",
					Status.PASS);
		} else {
			report.updateTestLog("Item Name not Matching",
					"Item Name NOT Present", Status.FAIL);
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// Item matching and is Present

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void subscriptionsEmailNewsLetter() throws Exception {
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//driver.findElement(By.id("opt_energy_email")).click();
		driver.findElement(By.id("opt_lowes_for_pros_email")).click();
		//driver.findElement(By.id("opt_racing_email")).click();
		driver.findElement(By.cssSelector("#subscriptionsSubmit > span"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void inspectSubscriberDetail() throws Exception {
		String getEmailId = driver.findElement(
				By.xpath(UIMapMyLowes.lblSubscriberEmail)).getText();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		if (!getEmailId.isEmpty()) {
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			boolean unSubscribe = selenium
					.isElementPresent(UIMapMyLowes.lblUnSubscribe);
			if (unSubscribe) {
				report.updateTestLog("unSubscribe Present",
						"unSubscribe Present", Status.PASS);
			} else {
				report.updateTestLog("unSubscribe not Present",
						"unSubscribe not Present", Status.FAIL);
			}
		} else {
			report.updateTestLog("Email not Present", "Email not Present",
					Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void changeSubscribeAddress() throws Exception {
		String changeAddress = driver
				.findElement(
						By.xpath(UIMapMyLowes.lblChangeAddressSubscribe))
				.getText();
		if (changeAddress.equals("Change Address.")) {
			report.updateTestLog("changeAddress Present",
					"changeAddress Present", Status.PASS);
			driver.findElement(By.linkText("Change Address.")).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			driver.findElement(
					By.xpath(UIMapMyLowes.webElmntChangeAddressSubscribe))
					.click();
			driver.findElement(By.id("firstName")).clear();
			driver.findElement(By.id("firstName")).sendKeys(
					dataTable.getData("General_Data", "Firstname"));
			driver.findElement(By.id("lastName")).clear();
			driver.findElement(By.id("lastName")).sendKeys(
					dataTable.getData("General_Data", "Lastname"));
			driver.findElement(By.id("address1")).clear();
			driver.findElement(By.id("address1")).sendKeys(
					dataTable.getData("General_Data", "Address1"));
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			driver.findElement(By.id("city")).clear();
			driver.findElement(By.id("city")).sendKeys(
					dataTable.getData("General_Data", "City"));
			new Select(driver.findElement(By.id("state")))
					.selectByVisibleText(dataTable.getData("General_Data",
							"State"));
			driver.findElement(By.id("zipCode")).clear();
			driver.findElement(By.id("zipCode")).sendKeys(
					dataTable.getData("General_Data", "zipcode"));
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		} else {
			report.updateTestLog("changeAddress not Present",
					"changeAddress not Present", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void loginYourAccountSubscriptions() throws Exception {
		driver.get(baseurl);
		selenium.waitForPageToLoad("15000");
		// driver.manage().window().maximize();
		selenium.setSpeed("6000");
		yourAccountSubscriptionsWithoutSignIn();
		Thread.sleep(6000);
		boolean saveDisabled = driver
				.findElement(
						By.xpath(UIMapMyLowes.btnSaveDisabled))
				.isEnabled();
		if (!saveDisabled) {
			report.updateTestLog("save button disabled",
					"save button disabled", Status.FAIL);
		}
		String enterSubscriberDetails = driver.findElement(
				By.xpath(UIMapMyLowes.lblEnterSubscriberDetails)).getText();
		if (enterSubscriberDetails.equals("Enter Subscriber Details:")) {
			boolean emailId = driver
					.findElement(By.xpath(UIMapMyLowes.lblEnterEmailID)).isDisplayed();
			if (!emailId) {
				report.updateTestLog("emailId not displayed",
						"emailId not displayed", Status.FAIL);
			}
		}
		Thread.sleep(6000);
		driver.findElement(By.id("opt_LCI_printed")).click();
		//Thread.sleep(6000);
		//driver.findElement(By.id("opt_LCI_ideas_creativas_printed")).click();
		Thread.sleep(6000);
		/*
		 * driver.findElement(By.xpath("//*[@id='subscriptionsSubmit']/span")).click
		 * (); Thread.sleep(6000);
		 */
		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("firstName")).sendKeys(
				dataTable.getData("General_Data", "Firstname"));
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys(
				dataTable.getData("General_Data", "Lastname"));
		driver.findElement(By.id("address1")).clear();
		driver.findElement(By.id("address1")).sendKeys(
				dataTable.getData("General_Data", "Address1"));
		
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
		 
		
		driver.findElement(By.id("emailId")).clear();
		driver.findElement(By.id("emailId")).sendKeys(
				varUniq+"@bh.exacttarget.com");
		dataTable.putData("General_Data", "email", varUniq+"@bh.exacttarget.com");
		// *[@id='emailId']
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys(
				dataTable.getData("General_Data", "City"));
		new Select(driver.findElement(By.id("state")))
				.selectByVisibleText(dataTable.getData("General_Data", "State"));
		driver.findElement(By.id("zipCode")).clear();
		driver.findElement(By.id("zipCode")).sendKeys(
				dataTable.getData("General_Data", "zipcode2"));
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.btnSaveSubscription))
				.click();
		Thread.sleep(6000);
		driver.findElement(By.id("zipCode")).clear();
		driver.findElement(By.id("zipCode")).sendKeys(
				dataTable.getData("General_Data", "zipcode"));
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.btnSaveSubscription))
				.click();
		Thread.sleep(6000);
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		/* create account */
		driver.findElement(By.xpath(UIMapMyLowes.btnSubscriptionCreateAccount))
				.click();
		Thread.sleep(6000);
		// *[@id='subscriptions_create_account']
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void enterCreateAccountDetails() throws Exception {
		driver.findElement(By.id("email1")).sendKeys(
				dataTable.getData("General_Data", "email")); // Entering Email
																// id
		driver.findElement(By.id("phoneUS")).sendKeys(
				dataTable.getData("General_Data", "phone")); // Entering Phone
																// number
		driver.findElement(By.id("password1")).sendKeys(
				dataTable.getData("General_Data", "password")); // Entering
																// Password
		driver.findElement(By.id("password2")).sendKeys(
				dataTable.getData("General_Data", "confpassword")); // Entering
																	// Confirm
																	// Password
		// driver.findElement(By.id("Ecom_BillTo_Postal_PostalCode")).sendKeys(dataTable.getData("General_Data","zipcode"));
		// //Entering Zipcode
		driver.findElement(By.xpath(UIMapMyLowes.btnRegisterSubmit))
				.click(); // Clicking the Create Account button to register user
		selenium.waitForPageToLoad("65000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void crossCheckSubscribeAddress() throws Exception {
		driver.findElement(By.linkText("Unsubscribe")).click();
		String address1 = driver.findElement(By.id("address1")).getText();
		if (address1 == null) {
			report.updateTestLog("address1 not displayed",
					"address1 not displayed", Status.FAIL);
		}
		String city = driver.findElement(By.id("city")).getText();
		if (city == null) {
			report.updateTestLog("city not displayed", "city not displayed",
					Status.FAIL);
		}

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void inspectSubscribeAddress() throws Exception {
		// div[2]/div[2]/div[2]/a
		driver.findElement(By.xpath(UIMapMyLowes.webElmntEditAddressPreferences)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		String changeAddress = driver.findElement(
				By.xpath(UIMapMyLowes.lblChangeAddress)).getText();
		if (changeAddress.equals("Change Address")) {
			report.updateTestLog("changeAddress Present",
					"changeAddress Present", Status.PASS);
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			if (changeAddress.equals("Subscription Address 1")) {
				report.updateTestLog("same address present",
						"same address Present", Status.PASS);
			} else {
				report.updateTestLog("same address not present",
						"same address not Present", Status.FAIL);
			}
		} else {
			report.updateTestLog("changeAddress Present",
					"changeAddress Present", Status.FAIL);
		}
		// div[4]/div[2]/span/strong/span
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void cancleDeactivateAccount()throws Exception{
		String getDeactivateName = driver.findElement(
				By.xpath(UIMapMyLowes.lblDeactivateDashboard)).getText();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		if (getDeactivateName.equals("Deactivate Account")) {
			report.updateTestLog("Name Matching", "Name displayed", Status.PASS);
			driver.findElement(
					By.xpath(UIMapMyLowes.lblDeactivateDashboard)).click();
			// giving wrong password
			driver.findElement(By.id("logonPassword")).clear();
			driver.findElement(
					By.xpath(UIMapMyLowes.btnCancelAccountDeactivate))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		}
		else{
			
		}
	}


	/**
	 * 
	 * @throws Exception
	 */
	public void deactivateAccount() throws Exception {
		String getDeactivateName = driver.findElement(
				By.xpath(UIMapMyLowes.lblDeactivateDashboard)).getText();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		if (getDeactivateName.equals("Deactivate Account")) {
			report.updateTestLog("Name Matching", "Name displayed", Status.PASS);
			driver.findElement(
					By.xpath(UIMapMyLowes.lblDeactivateDashboard)).click();
			// giving wrong password
			driver.findElement(By.id("logonPassword")).clear();
			driver.findElement(By.id("logonPassword")).sendKeys(
					dataTable.getData("General_Data", "wrongpassword"));
			driver.findElement(
					By.xpath(UIMapMyLowes.btnSubmitAccountDeactivate))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			// leaving the password field blank and click deactivate button
			driver.findElement(By.id("logonPassword")).clear();
			driver.findElement(
					By.xpath(UIMapMyLowes.btnSubmitAccountDeactivate))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			// giving correct password
			driver.findElement(By.id("logonPassword")).clear();
			driver.findElement(By.id("logonPassword")).sendKeys(
					dataTable.getData("General_Data", "password"));
			driver.findElement(
					By.xpath(UIMapMyLowes.btnSubmitAccountDeactivate))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			// *[@id='content-area-no-nav']/h2
			String deactivateConfirm = driver.findElement(
					By.xpath(UIMapMyLowes.txtDeactivateCnfrm)).getText();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(10000);
			if (deactivateConfirm.equals("Your account has been deactivated")) {
				report.updateTestLog("Account Deactivated",
						"Account Deactivated", Status.PASS);
			} else {
				report.updateTestLog("Account Deactivation Failed",
						"Account Deactivation Failed", Status.FAIL);
			}
		} else {
			report.updateTestLog("Name not Matching", "Name NOT Present",
					Status.FAIL);
		}

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void confirmDeactivateAccount() throws Exception {
		driver.findElement(By.id("logonPassword")).clear();
		driver.findElement(By.id("logonPassword")).sendKeys(
				dataTable.getData("General_Data", "password"));
		driver.findElement(
				By.xpath(UIMapMyLowes.btnSubmitAccountDeactivate))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void cbcUserFormEmail() throws Exception {
		driver.get(baseurl);
		selenium.waitForPageToLoad("15000");
		// driver.manage().window().maximize();
		selenium.setSpeed("2000");
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//email
		java.util.Date date= new java.util.Date();
        Timestamp t = new Timestamp(date.getTime());
        String varTimeStamp = String.format("%1$TD %1$TT", t);
        System.out.println(varTimeStamp);
        String[] varDate = varTimeStamp.split(" ");
        String[] varDatMon = varDate[0].split("/");
        String[] varHrMinSec = varDate[1].split(":");
        String varUniq = "test";
        varUniq = varUniq.concat(varDatMon[0]+varDatMon[1]+varHrMinSec[0]+varHrMinSec[1]+varHrMinSec[2]);
        //email
		driver.findElement(By.id("cbcsecuritycode")).clear();
		driver.findElement(By.id("cbcsecuritycode")).sendKeys(
				dataTable.getData("General_Data", "cbcsecuritycode"));
		driver.findElement(By.cssSelector("button.button.primary")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		
		driver.findElement(By.id("email1")).clear();
		//email ID
		driver.findElement(By.id("email1")).sendKeys(varUniq+"@bh.exacttarget.com");
		//put email 
		dataTable.putData("General_Data", "email", varUniq+"@bh.exacttarget.com");
		
		driver.findElement(By.id("email2")).clear();
		//email ID
		driver.findElement(By.id("email2")).sendKeys(varUniq+"@bh.exacttarget.com");
		//put email
		dataTable.putData("General_Data", "confirmemail", varUniq+"@bh.exacttarget.com");
		
		driver.findElement(By.id("password1")).clear();
		driver.findElement(By.id("password1")).sendKeys(
				dataTable.getData("General_Data", "password"));
		driver.findElement(By.id("password2")).clear();
		driver.findElement(By.id("password2")).sendKeys(
				dataTable.getData("General_Data", "confpassword"));
		driver.findElement(By.xpath(UIMapMyLowes.btnSaveEditPAddress)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void cancelCBCUserRegAddress() throws Exception {
		cbcUserFormEmail();
		driver.findElement(By.xpath(UIMapMyLowes.btnCancelCBCUser)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void wrongCBCUserAddressValidation() throws Exception {
		cbcUserFormEmail();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// /filling address Address1 City State nickName
		driver.findElement(By.id("addressField2")).clear();
		driver.findElement(By.id("addressField2")).sendKeys(
				dataTable.getData("General_Data", "nickName"));
		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("firstName")).sendKeys(
				dataTable.getData("General_Data", "Firstname"));
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys(
				dataTable.getData("General_Data", "Lastname"));
		driver.findElement(By.id("address1")).clear();
		driver.findElement(By.id("address1")).sendKeys(
				dataTable.getData("General_Data", "Address1"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys(
				dataTable.getData("General_Data", "City"));
		new Select(driver.findElement(By.id("state")))
				.selectByVisibleText(dataTable.getData("General_Data", "State"));
		driver.findElement(By.id("zipCode")).clear();
		driver.findElement(By.id("zipCode")).sendKeys(
				dataTable.getData("General_Data", "zipcode"));
		driver.findElement(By.id("phone1")).clear();
		driver.findElement(By.id("phone1")).sendKeys(
				dataTable.getData("General_Data", "phone"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.btnCheckAddressFields)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

		// wrong zipcode
		driver.findElement(By.id("zipCode")).clear();
		driver.findElement(By.id("zipCode")).sendKeys(
				dataTable.getData("General_Data", "zipcode2"));
		// *[@id='cbc-registration']/div[1]/ul/li[3]/div[2]/form/div[2]/p

		// wrong City
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys(
				dataTable.getData("General_Data", "City2"));
		driver.findElement(By.xpath(UIMapMyLowes.btnCheckAddressFields)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

		// wrong State
		driver.findElement(By.id("city")).clear();
		new Select(driver.findElement(By.id("state")))
				.selectByVisibleText(dataTable
						.getData("General_Data", "State2"));
		driver.findElement(By.xpath(UIMapMyLowes.btnCheckAddressFields)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void registerCBCUser() throws Exception {
		cbcUserFormEmail();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.btnCheckAddressFields)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// /filling address Address1 City State nickName
		driver.findElement(By.id("addressField2")).clear();
		driver.findElement(By.id("addressField2")).sendKeys(
				dataTable.getData("General_Data", "nickName"));
		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("firstName")).sendKeys(
				dataTable.getData("General_Data", "Firstname"));
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys(
				dataTable.getData("General_Data", "Lastname"));
		driver.findElement(By.id("address1")).clear();
		driver.findElement(By.id("address1")).sendKeys(
				dataTable.getData("General_Data", "Address1"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys(
				dataTable.getData("General_Data", "City"));
		new Select(driver.findElement(By.id("state")))
				.selectByVisibleText(dataTable.getData("General_Data", "State"));

		// wrong zipcode
		driver.findElement(By.id("zipCode")).clear();
		driver.findElement(By.id("zipCode")).sendKeys(
				dataTable.getData("General_Data", "zipcode2"));

		// verify phone field
		boolean phFieldPresent = selenium.isElementPresent(UIMapMyLowes.lblPhoneField);
		if (phFieldPresent) {
			driver.findElement(By.id("phone1")).clear();
			driver.findElement(By.id("phone1")).sendKeys(
					dataTable.getData("General_Data", "phone"));
		} else {
			report.updateTestLog("phone field count is more than one",
					"phone field count is more than one", Status.FAIL);
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.btnCheckAddressFields)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void verifyUserNotLoggedIn()throws Exception{
		boolean signIn = driver.findElement(By.xpath(UIMapMyLowes.lnkMasterHeadSignIn)).isDisplayed();
		if(signIn){
			report.updateTestLog("Sign In is Displayed",
					"Sign In is Displayed", Status.PASS);
		}else{
			report.updateTestLog("Sign In is not Displayed",
					"Sign In is not Displayed", Status.FAIL);
		}
		
		boolean signUp = driver.findElement(By.xpath(UIMapMyLowes.lnkMasterHeadSignUp)).isDisplayed();
		if(signUp){
			report.updateTestLog("Sign In is Displayed",
					"Sign In is Displayed", Status.PASS);
		}else{
			report.updateTestLog("Sign In is not Displayed",
					"Sign In is not Displayed", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void verifyCbcBanner() throws Exception {
		//checking businessName
		String businessName = driver.findElement(
				By.xpath(UIMapMyLowes.lblCBCBusinessName))
				.getText();
		String[] parts = businessName.split(" ");
		String var1 = parts[1];
		if (!var1.isEmpty()) {
			report.updateTestLog("Welcome page Present",
					"BusinessName displayed", Status.PASS);
		} else {
			report.updateTestLog("Welcome page not Present",
					"BusinessName not displayed", Status.FAIL);
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//checking banner
		boolean banner = driver.findElement(By.xpath(UIMapMyLowes.lblCBCBannerName)).isDisplayed();
		if(banner){
			report.updateTestLog("Banner Present",
					"Banner displayed", Status.PASS);
		} else {
			report.updateTestLog("Banner not Present",
					"Banner not displayed", Status.FAIL);
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//div[@id='cbc-global-banner-enhanced']/div/h2
		String companyName = driver.findElement(
				By.xpath(UIMapMyLowes.lblCBCCompanyName))
				.getText();
		if (!companyName.isEmpty()) {
			report.updateTestLog("Welcome page Present",
					"companyName displayed", Status.PASS);
		} else {
			report.updateTestLog("Welcome page not Present",
					"companyName not displayed", Status.FAIL);
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//div[@id='cbc-global-banner-enhanced']/div[2]/div/h3
		String myOrders = driver.findElement(
				By.xpath(UIMapMyLowes.lblCBCMyOrders))
				.getText();
		if (myOrders.equals("My Orders")) {
			report.updateTestLog("Welcome page Present",
					"My Orders displayed", Status.PASS);
		} else {
			report.updateTestLog("Welcome page not Present",
					"My Orders not displayed", Status.FAIL);
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//div[@id='cbc-global-banner-enhanced']/div[2]/div[2]/h3
		String myCatalogs = driver.findElement(
				By.xpath(UIMapMyLowes.lblCBCMyCatalogs))
				.getText();
		if (myCatalogs.equals("My Catalogs")) {
			report.updateTestLog("Welcome page Present",
					"My Catalogs displayed", Status.PASS);
		} else {
			report.updateTestLog("Welcome page not Present",
					"My Catalogs not displayed", Status.FAIL);
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		
		
		//checking company name length
		String companyNameLength = driver.findElement(
				By.xpath(UIMapMyLowes.lblCBCCompanyName))
				.getText();
		if (companyNameLength.length() <= 25) {
			report.updateTestLog("Welcome page Present",
					"companyNameLength displayed", Status.PASS);
		} else {
			report.updateTestLog("Welcome page not Present",
					"companyNameLength not displayed", Status.FAIL);
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void verifyCbcBannerCheckOut()throws Exception{
		searchItemUsingName();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		verifyCbcBanner();
		saveItemThroughPLLoggedIn();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		verifyCbcBanner();
		//add to cart
		driver.findElement(By.id("LD")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
	    selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		verifyCbcBanner();
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void verifyCbcBreadcrumb()throws Exception{
	
		//See Your Catalog
		boolean catalog = selenium.isTextPresent("See Your Catalog");
		if(catalog){
			report.updateTestLog("Welcome page Present",
					"catalog displayed", Status.PASS);
			driver.findElement(By.xpath(UIMapMyLowes.webElmntSeeYourCatalog))
			.click();
		}else{
			report.updateTestLog("Welcome page not Present",
					"catalog not displayed", Status.FAIL);
		}	 
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//cbcUserBreadcrumb
		String cbcUserBreadcrumb = driver.findElement(
				By.xpath(UIMapMyLowes.lblBreadCrumb2)).getText();
		if (cbcUserBreadcrumb.equals("Bloomingdales")) {
			report.updateTestLog("Clicking catalog",
					"cbcUserBreadcrumb page displayed", Status.PASS);
		} else {
			report.updateTestLog("Clicking Catalog",
					"cbcUserBreadcrumb page NOT displayed", Status.FAIL);
		}
	    driver.findElement(By.partialLinkText("Appliances")).click();
		//li[@id='Departments_Appliances']/a
	    selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	    String appliances = driver.findElement(
				By.xpath(UIMapMyLowes.lblBreadCrumb3)).getText();
		if (appliances.equals("Appliances")) {
			report.updateTestLog("Clicking catalog",
					"cbcUserBreadcrumb page displayed", Status.PASS);
		} else {
			report.updateTestLog("Clicking Catalog",
					"cbcUserBreadcrumb page NOT displayed", Status.FAIL);
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//re-checking banner
		boolean reChekcBanner = driver.findElement(By.xpath(UIMapMyLowes.lblCBCBannerName)).isDisplayed();
		if(reChekcBanner){
			report.updateTestLog("Banner Present",
					"Banner displayed", Status.PASS);
		} else {
			report.updateTestLog("Banner not Present",
					"Banner not displayed", Status.FAIL);
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}
	
	
	/*this function selects an Pro Price product in product List*/
	public void compareProPriceProduct() throws Exception
	{
		int compareFlag=0;
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
				if(driver.findElement(By.xpath("//*[@id='"+varID+"']/div/div[3]/p/img")).isDisplayed())
			{
				System.out.println("Pro Price present for:"+varID);
				driver.findElement(By.xpath("//*[@id='"+varID+"']/div/div[1]/div/input")).click();
				Thread.sleep(2000);
				compareFlag=compareFlag+1;
				if(compareFlag==2)
				{
					report.updateTestLog("Selecting Compare", "Compare selected for 2 Pro Price Products", Status.PASS);
					break;
				}
				
					
			}
			else
				continue;
			}
			catch(Exception NoSuchElementException)
			{
				System.out.println("Pro Price NOT present for:"+varID);
				continue;
			}
		}
		if(i==(varCount+1))
		{
			report.updateTestLog("Selecting Pro Price Item","No Pro Price Item in page" , Status.FAIL);
		}
		
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void compareItems()throws Exception{
		boolean proPrice = driver.findElement(By.xpath(UIMapMyLowes.lblYourContractPrice)).isDisplayed();
		if(proPrice){
			report.updateTestLog("ProPrice Present",
					"ProPrice displayed", Status.PASS);
		} else {
			report.updateTestLog("ProPrice not Present",
					"ProPrice not displayed", Status.FAIL);
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//compare1
		/*boolean compare1 = driver.findElement(By.xpath(UIMapMyLowes.lblCompare1)).isDisplayed();
		if(compare1){
			report.updateTestLog("ProPrice Present",
					"ProPrice displayed", Status.PASS);
			//click compare1
			driver.findElement(By.xpath(UIMapMyLowes.lblCompare1)).click();
		} else {
			report.updateTestLog("ProPrice not Present",
					"ProPrice not displayed", Status.FAIL);
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//compare2
		boolean compare2 = driver.findElement(By.xpath(UIMapMyLowes.lblCompare2)).isDisplayed();
		if(compare2){
			report.updateTestLog("ProPrice Present",
					"ProPrice displayed", Status.PASS);
			//click compare2
			driver.findElement(By.xpath(UIMapMyLowes.lblCompare2)).click();
		} else {
			report.updateTestLog("ProPrice not Present",
					"ProPrice not displayed", Status.FAIL);
		}*/
		compareProPriceProduct();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//click compare both items
		driver.findElement(By.xpath(UIMapMyLowes.btnCompare)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		
		boolean proPrice2 = driver.findElement(By.xpath(UIMapMyLowes.lblProPrice)).isDisplayed();
		if(proPrice2){
			report.updateTestLog("ProPrice Present",
					"ProPrice displayed", Status.PASS);
		} else {
			report.updateTestLog("ProPrice not Present",
					"ProPrice not displayed", Status.FAIL);
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		boolean proPrice3 = driver.findElement(By.xpath(UIMapMyLowes.lblProPrice2)).isDisplayed();
		if(proPrice3){
			report.updateTestLog("ProPrice Present",
					"ProPrice displayed", Status.PASS);
		} else {
			report.updateTestLog("ProPrice not Present",
					"ProPrice not displayed", Status.FAIL);
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		
		//click page detail
		
		driver.findElement(By.xpath(UIMapMyLowes.webElmntCompare1)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		boolean proPrice4 = driver.findElement(By.xpath(UIMapMyLowes.lblProPrice)).isDisplayed();
		if(proPrice4){
			report.updateTestLog("ProPrice Present",
					"ProPrice displayed", Status.PASS);
		} else {
			report.updateTestLog("ProPrice not Present",
					"ProPrice not displayed", Status.FAIL);
		}
		//previous page
		driver.navigate().back();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//page detail 2
		driver.findElement(By.xpath(UIMapMyLowes.webElmntCompare2)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		boolean proPrice5 = driver.findElement(By.xpath(UIMapMyLowes.lblProPrice)).isDisplayed();
		if(proPrice5){
			report.updateTestLog("ProPrice Present",
					"ProPrice displayed", Status.PASS);
		} else {
			report.updateTestLog("ProPrice not Present",
					"ProPrice not displayed", Status.FAIL);
		}
		
	}
	
	
	/**
	 * 
	 * @throws Exception
	 */
	public void previousPage() throws Exception {
		driver.navigate().back();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}
	
	
	/**
	 * 
	 * @throws Exception
	 */
	public void uspsSugession() throws Exception {
		cbcUserFormEmail();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// /filling address Address1 City State nickName
		driver.findElement(By.id("addressField2")).clear();
		driver.findElement(By.id("addressField2")).sendKeys(
				dataTable.getData("General_Data", "nickName"));
		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("firstName")).sendKeys(
				dataTable.getData("General_Data", "Firstname"));
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys(
				dataTable.getData("General_Data", "Lastname"));
		driver.findElement(By.id("address1")).clear();
		driver.findElement(By.id("address1")).sendKeys(
				dataTable.getData("General_Data", "Address1"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys(
				dataTable.getData("General_Data", "City"));
		new Select(driver.findElement(By.id("state")))
				.selectByVisibleText(dataTable.getData("General_Data", "State"));

		// wrong zipcode
		driver.findElement(By.id("zipCode")).clear();
		driver.findElement(By.id("zipCode")).sendKeys(
				dataTable.getData("General_Data", "zipcode2"));
		driver.findElement(By.id("phone1")).clear();
		driver.findElement(By.id("phone1")).sendKeys(
				dataTable.getData("General_Data", "phone"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.btnCheckAddressFields)).click();
		// pop up when given address with spelling mistake
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		boolean uspsContinue = selenium.isTextPresent("Confirm");
		if(uspsContinue){
		driver.findElement(By.xpath(UIMapMyLowes.btnCfrmUSPSAddress))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void isDeleteDisplayedForReminders() throws Exception {
		boolean deletePresent1 = selenium
				.isElementPresent(UIMapMyLowes.lblDelDisplayedForReminders1);
		if (deletePresent1) {
			report.updateTestLog("WebEmelemt Present", "Element displayed",
					Status.PASS);
		} else {
			report.updateTestLog("WebElement not Present",
					"WebElement NOT displayed", Status.FAIL);
		}

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void matchReminders() throws Exception {
		String reminder1 = driver
				.findElement(
						By.xpath(UIMapMyLowes.lblMatchReminder1))
				.getText();
		String reminder2 = driver
				.findElement(
						By.xpath(UIMapMyLowes.lblMatchReminder2))
				.getText();
		// clicking on myLowes
		driver.findElement(
				By.xpath(UIMapMyLowes.lnkMyLowes1))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(2000);
		// reminder from Landing Page
		String landingReminder1 = driver.findElement(
				By.xpath(UIMapMyLowes.lblMatchLandingReminder1))
				.getText();
		String landingReminder2 = driver.findElement(
				By.xpath(UIMapMyLowes.lblMatchLandingReminder2))
				.getText();
		if (reminder1.equals(landingReminder1)) {
			report.updateTestLog("Reminder is same", "Reminder displayed",
					Status.PASS);
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		} else {
			report.updateTestLog("Reminder not same", "Reminder NOT displayed",
					Status.FAIL);
		}
		if (reminder2.equals(landingReminder2)) {
			report.updateTestLog("Reminder is same", "Reminder displayed",
					Status.PASS);
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		} else {
			report.updateTestLog("Reminder not same", "Reminder NOT displayed",
					Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void clickHelp() throws Exception {
		driver.findElement(By.linkText("Help")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.name("HELP_faqs")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.id("My_Lowes_Reminders")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void inspectHelpCenter() throws Exception {
		driver.findElement(By.linkText("Help")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void inspectRemindersPage() throws Exception {
		String reminderPage = driver.findElement(
				By.xpath(UIMapMyLowes.lblReminderWelcomeMsg))
				.getText();
		if (reminderPage.equals("Close Welcome Message")) {
			report.updateTestLog("Reminder page Displayed",
					"Reminder page displayed", Status.PASS);
		} else {
			report.updateTestLog("Reminder page not Displayed",
					"Reminder page not displayed", Status.FAIL);
		}
		String faqPage = driver.findElement(
				By.xpath(UIMapMyLowes.webElmntReminderFAQPage))
				.getText();
		if (faqPage.equals("FAQ page")) {
			report.updateTestLog("Reminder page FAQ page Displayed",
					"Reminder page FAQ page displayed", Status.PASS);
			driver.findElement(
					By.xpath(UIMapMyLowes.webElmntReminderFAQPage))
					.click();
			String myLowesFAQ = driver.findElement(
					By.xpath(UIMapMyLowes.lblBreadCrumb4)).getText();
			if (myLowesFAQ.equals("MyLowe's FAQs")) {
				report.updateTestLog("MyLowe's FAQs page Displayed",
						"MyLowe's FAQs page displayed", Status.PASS);
			} else {
				report.updateTestLog("MyLowe's FAQs page not Displayed",
						"MyLowe's FAQs page not displayed", Status.FAIL);
			}
		} else {
			report.updateTestLog("Reminder page FAQ page not Displayed",
					"Reminder page FAQ page not displayed", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void learnMoreAboutReminders() throws Exception {
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
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(
				By.xpath(UIMapMyLowes.webElmntSetItemForReminder))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Learn more about Reminders.")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		if(driver.findElement(By.xpath("//*[@id='cu-header']/h1")).isDisplayed())
		{
			report.updateTestLog("Verifying MyLowes FAQ page", "MyLowe's FAQ page is displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying MyLowes FAQ page", "MyLowe's FAQ page is not displayed", Status.FAIL);
		}
		
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void yourAccountLearnMoreAboutReminders() throws Exception {
		driver.findElement(By.xpath(UIMapMyLowes.btnYourAccount))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.linkText("Learn more about Reminders.")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void checkOutOrderAsNewUser1()throws Exception{
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
		/*boolean selectElement = driver.findElement(By.xpath(UIMapMyLowes.txtElementDisplayed))
				.isDisplayed();
		if (selectElement) {
			driver.findElement(By.xpath(UIMapMyLowes.txtElementDisplayed)).click();
			selenium.waitForPageToLoad("20000");
		} else {
			report.updateTestLog("Select of first element is failed",
					"Element NOT Present", Status.FAIL);
		}*/
		ps.selectInStockProduct();
		//add to cart
				
		driver.findElement(By.id("LD")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
	    selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//providecheckOutOrderAsNewUserDetails
		providecheckOutOrderAsNewUserDetails();
	}
		
	/**
	 * 
	 * @throws Exception
	 */
	public void providecheckOutOrderAsNewUserDetails()throws Exception{
		
	    driver.findElement(By.xpath(UIMapMyLowes.btnShopCart)).click();
	    selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//for guest User
		
		boolean guestUser=  selenium.isTextPresent("I Don't Have a Lowes.com Account");
		if (guestUser) {
			driver.findElement(
					By.xpath(UIMapMyLowes.btnGuestUserCheckOut))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		}
		
	    //add address to check out primary address
	    checkOutAddress();
	    //checkout before USPS
	    driver.findElement(By.xpath(UIMapMyLowes.btnSecureCheckOut)).click();
	    selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//confirm USPS first
	    driver.findElement(By.cssSelector("#btAddrConfirm > span")).click();
	    selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//checkout aftr USPS
	    driver.findElement(By.xpath(UIMapMyLowes.btnSecureCheckOut)).click();
	    selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//click new credit card details tab
	    driver.findElement(By.id("ccAddTab")).click();
	    //add primary credit card details 
	    checkOutCreditCard();
	    selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//click create new address tab from billing info 
	    driver.findElement(By.linkText("Create New Address")).click();
	    selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	    //add billing info new credit card
	    checkOutBillingInfoAddNewAddress();
	    selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//click checkout button
	    driver.findElement(By.xpath(UIMapMyLowes.btnSecureCheckOut)).click();
	    selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//USPS Confirmation for final check out
	    driver.findElement(By.cssSelector("#btAddrConfirm > span")).click();
	    selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}
		
	/**
	 * 
	 * @throws Exception
	 */
	public void checkOutCreditCard() throws Exception {
		driver.findElement(By.name("cardNickname")).clear();
		driver.findElement(By.name("cardNickname")).sendKeys(
				dataTable.getData("General_Data", "nickName"));
		new Select(driver.findElement(By.id("checkout-card-type")))
				.selectByVisibleText(dataTable.getData("General_Data",
						"cardType"));
		driver.findElement(
				By.xpath(UIMapMyLowes.lblCheckOutCreditCardNo))
				.clear();
		driver.findElement(
				By.xpath(UIMapMyLowes.lblCheckOutCreditCardNo))
				.sendKeys(dataTable.getData("General_Data", "crditCardNo"));
		driver.findElement(By.id("s-code")).clear();
		driver.findElement(By.id("s-code")).sendKeys("1111");
		new Select(driver.findElement(By.id("expiration-year")))
				.selectByVisibleText(dataTable.getData("General_Data", "year"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}
	

	/**
	 * 
	 * @throws Exception
	 */
	public void checkOutAddress() throws Exception {
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
		driver.findElement(By.id("address-2")).clear();
		driver.findElement(By.id("address-2")).sendKeys(
				dataTable.getData("General_Data", "Address2"));
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys(
				dataTable.getData("General_Data", "City"));
		new Select(driver.findElement(By.id("state")))
				.selectByVisibleText(dataTable.getData("General_Data", "State"));
		driver.findElement(By.id("zip")).clear();
		driver.findElement(By.id("zip")).sendKeys(
				dataTable.getData("General_Data", "zipcode"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void checkOutBillingInfoAddNewAddress() throws Exception {
		driver.findElement(By.id("addressField2")).clear();
		driver.findElement(By.id("addressField2")).sendKeys(
				dataTable.getData("General_Data", "AddressNickName"));
		driver.findElement(By.id("billingFname")).clear();
		driver.findElement(By.id("billingFname")).sendKeys(
				dataTable.getData("General_Data", "Firstname"));
		driver.findElement(By.id("billingLname")).clear();
		driver.findElement(By.id("billingLname")).sendKeys(
				dataTable.getData("General_Data", "Lastname"));
		driver.findElement(By.id("billingAddress1")).clear();
		driver.findElement(By.id("billingAddress1")).sendKeys(
				dataTable.getData("General_Data", "Address1"));
		driver.findElement(By.id("billingAddress2")).clear();
		driver.findElement(By.id("billingAddress2")).sendKeys(
				dataTable.getData("General_Data", "Address2"));
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
				dataTable.getData("General_Data", "confirmemail"));
	}
	/**
	 * 
	 * @throws Exception
	 */
	
	public void validateCBCEmail()throws Exception{
		driver.get(baseurl);
		selenium.waitForPageToLoad("15000");
		// driver.manage().window().maximize();
		selenium.setSpeed("2000");
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
        //cbcsecuritycode
		driver.findElement(By.id("cbcsecuritycode")).clear();
		driver.findElement(By.id("cbcsecuritycode")).sendKeys(
				dataTable.getData("General_Data", "cbcsecuritycode"));
		driver.findElement(By.cssSelector("button.button.primary")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		
		driver.findElement(By.id("email1")).clear();
		//email ID
		driver.findElement(By.id("email1")).sendKeys(dataTable.getData("General_Data", "email"));
		
		driver.findElement(By.id("email2")).clear();
		//email ID
		driver.findElement(By.id("email2")).sendKeys(dataTable.getData("General_Data", "confirmemail"));
		driver.findElement(By.id("password1")).clear();
		driver.findElement(By.id("password1")).sendKeys(
				dataTable.getData("General_Data", "password"));
		driver.findElement(By.id("password2")).clear();
		driver.findElement(By.id("password2")).sendKeys(
				dataTable.getData("General_Data", "confpassword"));
		driver.findElement(By.xpath(UIMapMyLowes.btnSaveEditPAddress)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		
		boolean validate = selenium.isTextPresent("This email address is already associated with your Lowes.com account and associated with your company.");
		if(validate){
			report.updateTestLog("Clicking CBC link",
					"Email already exists displayed", Status.PASS);
		}else{
			report.updateTestLog("Clicking CBC link",
					"Email already exists not displayed", Status.FAIL);
		}
	}
	//kish
	public void addCreditCard() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.lnkAddCreditCardInternally)).click();
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.lblEnterCreditCardInfo)).getText();
		selenium.waitForPageToLoad("2000");
		Thread.sleep(6000);
		if (varMyLowes.equals("Enter Credit Card Information")) {
			report.updateTestLog("Checking for Manage Credit Card",
					"Manage Credit card displayed", Status.PASS);

			driver.findElement(By.id("ccNickName")).clear();
			driver.findElement(By.id("ccNickName")).sendKeys(
					dataTable.getData("General_Data", "nickName"));
			new Select(driver.findElement(By.id("ccType")))
					.selectByVisibleText(dataTable.getData("General_Data",
							"cardType"));
			driver.findElement(By.id("ccAddccno")).clear();
			driver.findElement(By.id("ccAddccno")).sendKeys(
					dataTable.getData("General_Data", "crditCardNo"));
			// click on month
			new Select(driver.findElement(By.id("exMonth")))
					.selectByVisibleText(dataTable.getData("General_Data",
							"month"));
			// click on year
			new Select(driver.findElement(By.id("exYear")))
					.selectByVisibleText(dataTable.getData("General_Data",
							"year"));
			driver.findElement(By.id("bt_ea_save_add_new_cc")).click();
			selenium.waitForPageToLoad("2000");
			Thread.sleep(6000);
			String s = dataTable.getData("General_Data", "nickName");
			System.out.println("String"+s);
			if(selenium.isTextPresent(s.toLowerCase()))	
		        report.updateTestLog("Verifying card","card added",Status.PASS);
		    else
		    	report.updateTestLog("Verifying card","card NOT added",Status.FAIL);
	}
	}
	public void addSecondaryCreditCard() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.lnkAddCreditCardInternally)).click();
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.lblEnterCreditCardInfo)).getText();
		selenium.waitForPageToLoad("2000");
		Thread.sleep(6000);
		if (varMyLowes.equals("Enter Credit Card Information")) {
			report.updateTestLog("Checking for Manage Credit Card",
					"Manage Credit card displayed", Status.PASS);

			driver.findElement(By.id("ccNickName")).clear();
			driver.findElement(By.id("ccNickName")).sendKeys(
					dataTable.getData("General_Data", "nickName")+"second");
			new Select(driver.findElement(By.id("ccType")))
					.selectByVisibleText(dataTable.getData("General_Data",
							"cardType"));
			driver.findElement(By.id("ccAddccno")).clear();
			driver.findElement(By.id("ccAddccno")).sendKeys(
					dataTable.getData("General_Data", "crditCardNo"));
			// click on month
			new Select(driver.findElement(By.id("exMonth")))
					.selectByVisibleText(dataTable.getData("General_Data",
							"month"));
			// click on year
			new Select(driver.findElement(By.id("exYear")))
					.selectByVisibleText(dataTable.getData("General_Data",
							"year"));
			driver.findElement(By.id("bt_ea_save_add_new_cc")).click();
			selenium.waitForPageToLoad("2000");
			Thread.sleep(6000);
			if(selenium.isTextPresent(dataTable.getData("General_Data", "nickName").toLowerCase()))	
		        report.updateTestLog("Verifying card","card added",Status.PASS);
		    else
		    	report.updateTestLog("Verifying card","card NOT added",Status.FAIL);
	}
	}
	public void replaceURL() throws Exception
	{
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String partialURL[] = url.split("servlet");
		System.out.println("reached here");
		String totalURL = partialURL[0]+"servlet/AjaxCreditCardAddCmd?ccNickName="+dataTable.getData("General_Data","nickName")+"&storeId=10151&catalogId=10051&langId=-1&ccno=4539942679206230&exMonth=05&exYear=2014&ccType=VISA&Secondary=true";
		System.out.println("totalURL"+totalURL);
		driver.get(totalURL);
		selenium.waitForPageToLoad("15000");
		selenium.setSpeed("2000");
		if(selenium.isTextPresent("This nickname is already in use. Please enter a new nickname"))
			report.updateTestLog("Verifying JSON response","JSON message correctly displayed",Status.PASS);
		else
			report.updateTestLog("Verifying JSON response","JSON message Incorrectly displayed",Status.FAIL);
		driver.navigate().back();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		String s = "manage-cc";
		int count1 = ps.countWebElement("//*[@id="+s+"]/div");
		System.out.println("count1 "+count1);
		if(count1<=9)
			report.updateTestLog("Verifying whether another credit card added with same nick name","Credit card not added with same nick name",Status.PASS);
		else
			report.updateTestLog("Verifying whether another credit card added with same nick name","Credit card added with same nick name",Status.FAIL);
	}

	public void clickAddCreditCardInPreference() throws Exception
	{
		ClickCustomize("xpath","//*[@id='dashboard']/div/div[3]/div[2]/div/a");
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}
	public void replaceURLForRepeatedPrimaryCard() throws Exception
	{
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String partialURL[] = url.split("servlet");
		System.out.println("reached here");
		String totalURL = partialURL[0]+"servlet/AjaxCreditCardAddCmd?ccNickName="+dataTable.getData("General_Data","nickName")+"ABC&storeId=10151&catalogId=10051&langId=-1&ccno=4539942679206230&exMonth=05&exYear=2014&ccType=VISA&primary=true";
		System.out.println("totalURL"+totalURL);
		driver.get(totalURL);
		selenium.waitForPageToLoad("15000");
		selenium.setSpeed("2000");
		String s = "\"primary\": [\"true\"]";
		if(driver.findElement(By.xpath("html/body")).isDisplayed() && selenium.isTextPresent(s))
			report.updateTestLog("Verifying JSON response","JSON message correctly displayed",Status.PASS);
		else
			report.updateTestLog("Verifying JSON response","JSON message Incorrectly displayed",Status.FAIL);
		driver.navigate().back();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		String showedText = driver.findElement(By.xpath("//div[6]/div[2]/span/strong/span")).getText();
		System.out.println("showedText"+showedText);
		String ExpText = dataTable.getData("General_Data","nickName")+"ABC";
		System.out.println("ExpText"+ExpText);
	    if(showedText.equalsIgnoreCase(ExpText))	
	        report.updateTestLog("Verifying new Primary card","New Primary card added",Status.PASS);
	    else
	    	report.updateTestLog("Verifying new Primary card","New Primary card NOT added",Status.FAIL);
	}
	public void replaceURLForPastExpiryDate() throws Exception
		{
			String url = driver.getCurrentUrl();
			System.out.println(url);
			String partialURL[] = url.split("servlet");
			System.out.println("reached here");
			String totalURL = partialURL[0]+"servlet/AjaxCreditCardUpdateCmd?storeId=10151&catalogId=10051&langId=-1&ccNickName="+dataTable.getData("General_Data","nickName")+"&exMonth=01&exYear=2012&primary=true&ccId=3066";
			System.out.println("totalURL"+totalURL);
			driver.get(totalURL);
			selenium.waitForPageToLoad("15000");
			selenium.setSpeed("2000");
			if(driver.findElement(By.xpath("html/body")).isDisplayed() && selenium.isTextPresent("Please enter a future date. The card expiration date can't occur in the past"))
				report.updateTestLog("Verifying JSON response","JSON message correctly displayed",Status.PASS);
			else
				report.updateTestLog("Verifying JSON response","JSON message Incorrectly displayed",Status.FAIL);
			driver.navigate().back();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			String expmnth = driver.findElement(By.xpath("//div[6]/div[3]/span[3]/span/span[1]")).getText();
			String expyear = driver.findElement(By.xpath("//div[6]/div[3]/span[3]/span/span[2]")).getText();
			System.out.println("Exp Mnth"+expmnth);
			System.out.println("Exp Year"+expyear);
			String ExpectedMnth = "01";
			String ExpectedYear = "2012";
			if(expmnth.trim().equals(ExpectedMnth) && expyear.trim().equals(ExpectedYear))
				report.updateTestLog("Verifying credit card expiration date","Credit card expiration date updated with the past date",Status.FAIL);
			else
				report.updateTestLog("Verifying credit card expiration date","Credit card expiration date not updated with the past date",Status.PASS);
	    }
	public void replaceURLForFutureExpiryDate() throws Exception
	{
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String partialURL[] = url.split("servlet");
		System.out.println("reached here");
		String totalURL = partialURL[0]+"servlet/AjaxCreditCardUpdateCmd?storeId=10151&catalogId=10051&langId=-1&ccNickName="+dataTable.getData("General_Data","nickName")+"abcd&exMonth=05&exYear=2020&primary=true&ccId=3066";
		System.out.println("totalURL"+totalURL);
		driver.get(totalURL);
		selenium.waitForPageToLoad("15000");
		selenium.setSpeed("2000");
		String s = "\"exYear\": [\"2020\"], \"ccNickName\": [\""+dataTable.getData("General_Data","nickName")+"abcd\"]";
		if(driver.findElement(By.xpath("html/body")).isDisplayed() && selenium.isTextPresent(s))
			report.updateTestLog("Verifying JSON response","JSON message correctly displayed",Status.PASS);
		else
			report.updateTestLog("Verifying JSON response","JSON message Incorrectly displayed",Status.FAIL);
		driver.navigate().back();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		String expmnth = driver.findElement(By.xpath("//div[6]/div[3]/span[3]/span/span[1]")).getText();
		String expyear = driver.findElement(By.xpath("//div[6]/div[3]/span[3]/span/span[2]")).getText();
		System.out.println("Exp Mnth"+expmnth);
		System.out.println("Exp Year"+expyear);
		String ExpectedMnth = "05";
		String ExpectedYear = "2020";
		if(expmnth.trim().equals(ExpectedMnth) && expyear.trim().equals(ExpectedYear))
			report.updateTestLog("Verifying credit card expiration date","Credit card expiration date not updated with the past date",Status.PASS);
		else
			report.updateTestLog("Verifying credit card expiration date","Credit card expiration date updated with the past date",Status.FAIL);
    }
	
	public void replaceURLToAddSecondaryCard() throws Exception
	{
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String partialURL[] = url.split("servlet");
		System.out.println("reached here");
		String totalURL = partialURL[0]+"servlet/AjaxCreditCardAddCmd?ccNickName="+dataTable.getData("General_Data","nickName")+"11&storeId=10151&catalogId=10051&langId=-1&ccno=4539942679206230&exMonth=05&exYear=2020&ccType=VISA&Secondary=true";
		System.out.println("totalURL"+totalURL);
		driver.get(totalURL);
		selenium.waitForPageToLoad("15000");
		selenium.setSpeed("2000");
		String s = "\"error\": \"false\"";
		if(driver.findElement(By.xpath("html/body")).isDisplayed() && selenium.isTextPresent(s))
			report.updateTestLog("Verifying JSON response","JSON message correctly displayed",Status.PASS);
		else
			report.updateTestLog("Verifying JSON response","JSON message Incorrectly displayed",Status.FAIL);
		driver.navigate().back();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		if(selenium.isTextPresent(dataTable.getData("General_Data","nickName").toLowerCase()+"11"))	
	        report.updateTestLog("Verifying secondary card","New secondary card added",Status.PASS);
	    else
	    	report.updateTestLog("Verifying secondary card","New secondary card NOT added",Status.FAIL);
	}
	public void replaceURLToAddPrimaryCard() throws Exception
	{
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String partialURL[] = url.split("servlet");
		System.out.println("reached here");
		String totalURL = partialURL[0]+"servlet/AjaxCreditCardAddCmd?ccNickName=test&storeId=10151&catalogId=10051&langId=-1&ccno=4539942679206230&exMonth=12&exYear=2020&ccType=VISA&primary=true";
		System.out.println("totalURL"+totalURL);
		driver.get(totalURL);
		selenium.waitForPageToLoad("15000");
		selenium.setSpeed("2000");
		String s = "\"error\": \"false\"";
		if(driver.findElement(By.xpath("html/body")).isDisplayed() && selenium.isTextPresent(s))
			report.updateTestLog("Verifying JSON response","JSON message correctly displayed",Status.PASS);
		else
			report.updateTestLog("Verifying JSON response","JSON message Incorrectly displayed",Status.FAIL);
		driver.navigate().back();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		if(selenium.isTextPresent("test"))	
	        report.updateTestLog("Verifying Primary card","Primary card added",Status.PASS);
	    else
	    	report.updateTestLog("Verifying Primary card","Primary card NOT added",Status.FAIL);
	}
	public void closeBrowser() throws Exception
	{
		driver.close();
	}
	
	public void verifyCancelCloseInDeletePopup() throws Exception
	{
		ClickCustomize("xpath",UIMapMyLowes.lnkDelSecondaryCard);
		Thread.sleep(3000);
		String nickname = driver.findElement(By.xpath("(//td[2]/span)[1]")).getText();
		dataTable.putData("General_Data","nickName2",nickname);
		ClickCustomize("linkText","Cancel");
		Thread.sleep(3000);
		if(selenium.isTextPresent(nickname))
			report.updateTestLog("Verifying Secondary card after clicking on cancel button","Secondary credit card exists",Status.PASS);
		else
			report.updateTestLog("Verifying Secondary card after clicking on cancel button","Secondary credit card does not exists",Status.FAIL);
		ClickCustomize("xpath",UIMapMyLowes.lnkDelSecondaryCard);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("span.ui-icon.ui-icon-closethick")).click();
		Thread.sleep(3000);
		if(selenium.isTextPresent(nickname))
			report.updateTestLog("Verifying Secondary card after clicking on close button","Secondary credit card exists",Status.PASS);
		else
			report.updateTestLog("Verifying Secondary card after clicking on close button","Secondary credit card does not exists",Status.FAIL);
		ClickCustomize("xpath",UIMapMyLowes.lnkDelSecondaryCard);
		Thread.sleep(3000);
	}
	public void verifyCancelCloseInDelPopupForPrimary() throws Exception
	{
		ClickCustomize("xpath",UIMapMyLowes.lnkDelPrimaryCard);
		Thread.sleep(3000);
		String nickname = driver.findElement(By.xpath("(//td[2]/span)[1]")).getText();
		dataTable.putData("General_Data","nickName2",nickname);
		ClickCustomize("linkText","Cancel");
		Thread.sleep(3000);
		if(selenium.isTextPresent(nickname))
			report.updateTestLog("Verifying Primary card after clicking on cancel button","Primary credit card exists",Status.PASS);
		else
			report.updateTestLog("Verifying Primary card after clicking on cancel button","Primary credit card does not exists",Status.FAIL);
		ClickCustomize("xpath",UIMapMyLowes.lnkDelPrimaryCard);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("span.ui-icon.ui-icon-closethick")).click();
		Thread.sleep(3000);
		if(selenium.isTextPresent(nickname))
			report.updateTestLog("Verifying Primary card after clicking on close button","Primary credit card exists",Status.PASS);
		else
			report.updateTestLog("Verifying Primary card after clicking on close button","Primary credit card does not exists",Status.FAIL);
		ClickCustomize("xpath",UIMapMyLowes.lnkDelPrimaryCard);
		Thread.sleep(3000);
	}
	//Rajesh
	public void reminderFAQasNewRegisteredUser() throws Exception 
    {
    	
    	driver.findElement(By.xpath("//*[@id='has_NeverUsed']")).click();
    	if (driver.findElement(By.xpath("//*[@id='productRight']/div[2]/ul/li[2]/div[2]/div[2]/div/a[2]")).isDisplayed())
    	{
    		report.updateTestLog("Verifying Reminder popup for the first time", "'Set a reminder to order this post' popup is displayed", Status.PASS);
    		driver.findElement(By.xpath("//a[contains(text(),'Learn more about Reminders.')]")).click();
    		selenium.waitForPageToLoad("200000");
    		Thread.sleep(6000);
    		if(driver.findElement(By.xpath("//*[@id='cu-header']/h1")).isDisplayed())
    		{
    			report.updateTestLog("Verifying MyLowes FAQ page", "MyLowe's FAQ page is displayed", Status.PASS);
    		}
    		else
    		{
    			report.updateTestLog("Verifying MyLowes FAQ page", "MyLowe's FAQ page is not displayed", Status.FAIL);
    		}
    		
    		
    	}
    	else
    	{
    		report.updateTestLog("Verifying Reminder popup for the first time", "'Set a reminder to order this post' popup not is displayed", Status.PASS);
    	}
    }
	//End Rajesh

	/**
	 * 
	 */
	public void openLowesApplicationAfterCBCReg()throws Exception{
		driver.get(baseurl);
		selenium.waitForPageToLoad("15000");
		selenium.setSpeed("2000");
	}
}
