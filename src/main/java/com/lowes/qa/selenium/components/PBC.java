package com.lowes.qa.selenium.components;

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
import com.lowes.qa.selenium.uimap.UIMapMyLowes;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;


public class PBC extends ReusableLibrary {

	String baseurl = dataTable.getData("General_Data", "URL");
	Selenium selenium = new WebDriverBackedSelenium(driver, baseurl);
	HomeProfile hp = new HomeProfile(scriptHelper);
	ProductSearch ps=new ProductSearch(scriptHelper);
	
	public PBC(ScriptHelper scriptHelper) {
		super(scriptHelper);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @author Ravi
	 * @throws Exception
	 */
	public void yourAccountCreateHomeProfile() throws Exception {
		Actions actions = new Actions(driver);
		try {
			WebElement menuHoverLink = driver.findElement(By
					.id("nav-my-account"));
			Thread.sleep(6000);
			actions.moveToElement(menuHoverLink).build().perform();
		} catch (Exception e) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handeled", Status.DONE);
			WebElement menuHoverLink = driver.findElement(By
					.id("nav-my-account"));
			Thread.sleep(6000);
			actions.moveToElement(menuHoverLink).build().perform();
		}
		Thread.sleep(6000);
		WebElement subLink = driver.findElement(By.id("nav-home-profile"));
		actions.moveToElement(subLink).build().perform();
		subLink.click();

		// check brudcrum
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.lblBreadCrumb2)).getText();
		System.out.println(varMyLowes);
		if (varMyLowes.equals("Home Profile")) {
			report.updateTestLog("Clicking Your Account link",
					"Your Home Profile page displayed", Status.PASS);
		}
		// login user as 1st time user
		String createHP = driver.findElement(
				By.xpath(UIMapMyLowes.lblBreadCrumb2)).getText();
		System.out.println(createHP);
		if (createHP.equals("Create Your Home Profile")) {
			report.updateTestLog("Clicking Your Account link",
					"Your Home Profile page displayed", Status.PASS);
		boolean createHomeProfile = driver.findElement(
				By.xpath(UIMapMyLowes.webElmntCreateHomeProfile)).isDisplayed();
		if (createHomeProfile) {
			try{
			driver.findElement(By.cssSelector("#create_profile_link > span"))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			}catch(Exception e){
				driver.findElement(By.linkText("No, thanks")).click();
	            report.updateTestLog("Survey Popup","Handeled", Status.DONE);
				driver.findElement(By.cssSelector("#create_profile_link > span"))
				.click();
				selenium.waitForPageToLoad("20000");
				Thread.sleep(6000);
			}
			
		}
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void calculatorFromIdeasHowDos() throws Exception {
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By
				.xpath(UIMapMyLowes.webElmntIdeasHowDos));
		Thread.sleep(6000);
		actions.moveToElement(menuHoverLink).build().perform();
		Thread.sleep(6000);
		WebElement subLink = driver.findElement(By
				.xpath(UIMapMyLowes.webElmntChooseProject));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// click on calculators from create project
		driver.findElement(By.cssSelector(UIMapMyLowes.webElmntCalculator)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void calculateUsingGrassSeedCalculator() throws Exception {
		boolean grassSeedPresent = driver.findElement(
				By.xpath(UIMapMyLowes.webElmntGSCalculator))
				.isDisplayed();
		if (grassSeedPresent) {
			report.updateTestLog("Checking for Grass Seed Calculator",
					"Grass Seed Calculator displayed", Status.PASS);
			try{
			driver.findElement(
					By.xpath(UIMapMyLowes.webElmntGSCalculator))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			}catch(Exception e){
				driver.findElement(By.linkText("No, thanks")).click();
	            report.updateTestLog("Survey Popup","Handeled", Status.DONE);
	            driver.findElement(
						By.xpath(UIMapMyLowes.webElmntGSCalculator))
						.click();
	            selenium.waitForPageToLoad("20000");
				Thread.sleep(6000);
			}
			
		} else {
			report.updateTestLog("Checking for Grass Seed Calculator",
					"Grass Seed Calculator is not displayed", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void calculateUsingMulchCalculator() throws Exception {
		boolean grassSeedPresent = driver.findElement(
				By.xpath(UIMapMyLowes.webElmntMulchCalculator))
				.isDisplayed();
		if (grassSeedPresent) {
			report.updateTestLog("Checking for Mulch Calculator",
					"Mulch Calculator displayed", Status.PASS);
			try{
			driver.findElement(
					By.xpath(UIMapMyLowes.webElmntMulchCalculator))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			}
			catch(Exception e){
				driver.findElement(By.linkText("No, thanks")).click();
	            report.updateTestLog("Survey Popup","Handeled", Status.DONE);
	            driver.findElement(
						By.xpath(UIMapMyLowes.webElmntMulchCalculator))
						.click();
				selenium.waitForPageToLoad("20000");
				Thread.sleep(6000);
			}
		} else {
			report.updateTestLog("Checking for Mulch Calculator",
					"Mulch Calculator is not displayed", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void calculateUsingFertilizerCalculator() throws Exception {
		boolean grassSeedPresent = driver.findElement(
				By.xpath(UIMapMyLowes.webElmntFertiCalculator))
				.isDisplayed();
		if (grassSeedPresent) {
			report.updateTestLog("Checking for Fertilizer Calculator",
					"Fertilizer Calculator displayed", Status.PASS);
			try{
			driver.findElement(
					By.xpath(UIMapMyLowes.webElmntFertiCalculator))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			}
			catch(Exception e){
				driver.findElement(By.linkText("No, thanks")).click();
	            report.updateTestLog("Survey Popup","Handeled", Status.DONE);
	            driver.findElement(
						By.xpath(UIMapMyLowes.webElmntFertiCalculator))
						.click();
				selenium.waitForPageToLoad("20000");
				Thread.sleep(6000);
			}
		} else {
			report.updateTestLog("Checking for Fertilizer Calculator",
					"Fertilizer Calculator is not displayed", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void calculateUsingPaintCalculator() throws Exception {
		boolean grassSeedPresent = driver.findElement(
				By.xpath(UIMapMyLowes.webElmntPaintCalculator))
				.isDisplayed();
		if (grassSeedPresent) {
			report.updateTestLog("Checking for Paint Calculator",
					"Paint Calculator displayed", Status.PASS);
			try{
			driver.findElement(
					By.xpath(UIMapMyLowes.webElmntPaintCalculator))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			}
			catch(Exception e){
				driver.findElement(By.linkText("No, thanks")).click();
	            report.updateTestLog("Survey Popup","Handeled", Status.DONE);
	            driver.findElement(
						By.xpath(UIMapMyLowes.webElmntPaintCalculator))
						.click();
				selenium.waitForPageToLoad("20000");
				Thread.sleep(6000);
			}
		} else {
			report.updateTestLog("Checking for Paint Calculator",
					"Paint Calculator is not displayed", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void calGSCSquareFootage() throws Exception {
		// click SquareFootage
		driver.findElement(By.id("helpCalculate")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.id("area1LengthFt")).clear();
		driver.findElement(By.id("area1LengthFt")).sendKeys(
				dataTable.getData("General_Data", "Area1"));
		driver.findElement(By.id("area1WidthFt")).clear();
		driver.findElement(By.id("area1WidthFt")).sendKeys(
				dataTable.getData("General_Data", "Area2"));
		// add area button
		addAreaSquareFootage();
		// delete area button
		deleteAreaSquareFootage();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		new Select(driver.findElement(By.id("growingZone")))
				.selectByVisibleText(dataTable.getData("General_Data",
						"Growing Zone"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		new Select(driver.findElement(By.id("seedType")))
				.selectByVisibleText(dataTable.getData("General_Data",
						"Grass Type"));
		driver.findElement(By.xpath(UIMapMyLowes.btnAddAddress)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void calMulchSquareFootage() throws Exception {
		// click SquareFootage
		driver.findElement(By.id("helpCalculate")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.id("area1LengthFt")).clear();
		driver.findElement(By.id("area1LengthFt")).sendKeys(
				dataTable.getData("General_Data", "Area1"));
		driver.findElement(By.id("area1WidthFt")).clear();
		driver.findElement(By.id("area1WidthFt")).sendKeys(
				dataTable.getData("General_Data", "Area2"));
		// add area button
		addAreaSquareFootage();
		// delete area button
		deleteAreaSquareFootage();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		new Select(driver.findElement(By.id("productType")))
				.selectByVisibleText(dataTable.getData("General_Data",
						"Mulch Type"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.id("mulchDepth")).sendKeys(
				dataTable.getData("General_Data", "Mulch Depth"));
		driver.findElement(By.xpath(UIMapMyLowes.btnAddAddress)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

		// volumn results
		new Select(
				driver.findElement(By
						.xpath(UIMapMyLowes.webElmntMulchVolResults)))
				.selectByVisibleText(dataTable.getData("General_Data",
						"Volumn Results"));
		driver.findElement(
				By.cssSelector(UIMapMyLowes.btnVolRes))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void calFertilizerSquareFootage() throws Exception {
		// click SquareFootage
		driver.findElement(By.id("helpCalculate")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.id("area1LengthFt")).clear();
		driver.findElement(By.id("area1LengthFt")).sendKeys(
				dataTable.getData("General_Data", "Area1"));
		driver.findElement(By.id("area1WidthFt")).clear();
		driver.findElement(By.id("area1WidthFt")).sendKeys(
				dataTable.getData("General_Data", "Area2"));
		// add area button
		addAreaSquareFootage();
		// delete area button new
		// Select(driver.findElement(By.id("releaseRate"))).selectByVisibleText("Slow-Release");
		deleteAreaSquareFootage();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		new Select(driver.findElement(By.id("releaseRate")))
				.selectByVisibleText(dataTable.getData("General_Data",
						"Fertilizer Release Date"));
		// help
		driver.findElement(
				By.xpath(UIMapMyLowes.webElmntFertiReleaseDateHelp))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntFertiReleaseDateHelpClose)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		new Select(driver.findElement(By.id("deliverySystem")))
				.selectByVisibleText(dataTable.getData("General_Data",
						"Delivery System"));
		// help
		driver.findElement(
				By.xpath(UIMapMyLowes.webElmntFertiDeliverySystemHelp))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntFertiDeliverySystemHelpClose)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.btnAddAddress)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void calGSCAcreage() throws Exception {
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// click Acreage
		driver.findElement(By.id("knownDimensions")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.id("areaTotal")).clear();
		driver.findElement(By.id("areaTotal")).sendKeys(
				dataTable.getData("General_Data", "TotalArea"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		new Select(driver.findElement(By.id("growingZone")))
				.selectByVisibleText(dataTable.getData("General_Data",
						"Growing Zone"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		new Select(driver.findElement(By.id("seedType")))
				.selectByVisibleText(dataTable.getData("General_Data",
						"Grass Type"));
		driver.findElement(By.xpath(UIMapMyLowes.btnAddAddress)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void calMulchAcreage() throws Exception {
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// click Acreage
		driver.findElement(By.id("knownDimensions")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.id("areaTotal")).clear();
		driver.findElement(By.id("areaTotal")).sendKeys(
				dataTable.getData("General_Data", "TotalArea"));
		new Select(
				driver.findElement(By
						.xpath(UIMapMyLowes.webElmntMulchTotalAreaSelect)))
				.selectByVisibleText(dataTable.getData("General_Data",
				"TA Acres"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		new Select(driver.findElement(By.id("productType")))
				.selectByVisibleText(dataTable.getData("General_Data",
						"Mulch Type"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.id("mulchDepth")).sendKeys(
				dataTable.getData("General_Data", "Mulch Depth"));
		driver.findElement(By.xpath(UIMapMyLowes.btnAddAddress)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void calFertilizerAcreage() throws Exception {
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// click Acreage
		driver.findElement(By.id("knownDimensions")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.id("areaTotal")).clear();
		driver.findElement(By.id("areaTotal")).sendKeys(
				dataTable.getData("General_Data", "TotalArea"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		new Select(driver.findElement(By.id("releaseRate")))
				.selectByVisibleText(dataTable.getData("General_Data",
						"Fertilizer Release Date"));
		// help
		driver.findElement(
				By.xpath(UIMapMyLowes.webElmntFertiReleaseDateHelp))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntFertiReleaseDateHelpClose)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		new Select(driver.findElement(By.id("deliverySystem")))
				.selectByVisibleText(dataTable.getData("General_Data",
						"Delivery System"));
		driver.findElement(
				By.xpath(UIMapMyLowes.webElmntFertiDeliverySystemHelp))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntFertiDeliverySystemHelpClose)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.btnAddAddress)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void calGSCHomeProfileDimentions() throws Exception {
		driver.findElement(By.id("knownDimensions")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// click home profile
		driver.findElement(By.id("hpDimensions")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

		//if not sign in
		boolean signInToSelectSpace = selenium
				.isTextPresent("Sign In to Select a Space");
		if (signInToSelectSpace) {
			driver.findElement(
					By.xpath(UIMapMyLowes.btnCheckOut))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			signInToSelectSpace();
		}
		
		// create home profile
		boolean createHPD = selenium.isTextPresent("Create a Home Profile");
		if (createHPD) {
			driver.findElement(By.linkText("Create a Home Profile")).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			// create home profile from your account
			driver.findElement(By.cssSelector("#create_profile_link > span"))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			// create home profile dimentions
			createGSCHPD();
		}
		// Add Dimensions
		boolean addDimensions = selenium.isTextPresent("Add Dimensions");
		if (addDimensions) {
			driver.findElement(
					By.xpath(UIMapMyLowes.webElmntAddDimensions)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			// create home profile from your account
			driver.findElement(By.cssSelector("#create_profile_link > span"))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			// create home profile dimentions
			createGSCHPD();
		}
		new Select(driver.findElement(By.id("selectSpace")))
				.selectByVisibleText(dataTable.getData("General_Data",
						"SelectSpace"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// get space dimentions
		driver.findElement(By.xpath(UIMapMyLowes.btnCancelCBCUser)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		new Select(driver.findElement(By.id("growingZone")))
				.selectByVisibleText(dataTable.getData("General_Data",
						"Growing Zone"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		new Select(driver.findElement(By.id("seedType")))
				.selectByVisibleText(dataTable.getData("General_Data",
						"Grass Type"));
		driver.findElement(By.xpath(UIMapMyLowes.btnAddAddress)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void calFertiHomeProfileDimentions() throws Exception {
		driver.findElement(By.id("knownDimensions")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// click home profile
		driver.findElement(By.id("hpDimensions")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

		//if not sign in
		boolean signInToSelectSpace = selenium
				.isTextPresent("Sign In to Select a Space");
		if (signInToSelectSpace) {
			driver.findElement(
					By.xpath(UIMapMyLowes.btnCheckOut))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			signInToSelectSpace();
		}
		
		// create home profile
		boolean createHPD = selenium.isTextPresent("Create a Home Profile");
		if (createHPD) {
			driver.findElement(By.linkText("Create a Home Profile")).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			// create home profile from your account
			driver.findElement(By.cssSelector("#create_profile_link > span"))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			// create home profile dimentions
			createFertiHPD();
		}
		// Add Dimensions
		boolean addDimensions = selenium.isTextPresent("Add Dimensions");
		if (addDimensions) {
			driver.findElement(
					By.xpath(UIMapMyLowes.webElmntAddDimensions)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			// create home profile dimentions
			createFertiHPD();
		}
		new Select(driver.findElement(By.id("selectSpace")))
				.selectByVisibleText(dataTable.getData("General_Data",
						"SelectSpace"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// get space dimentions
		driver.findElement(By.xpath(UIMapMyLowes.btnCancelCBCUser)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		new Select(driver.findElement(By.id("releaseRate")))
				.selectByVisibleText(dataTable.getData("General_Data",
						"Fertilizer Release Date"));
		// help
		driver.findElement(
				By.xpath(UIMapMyLowes.webElmntFertiReleaseDateHelp))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntFertiReleaseDateHelpClose)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		new Select(driver.findElement(By.id("deliverySystem")))
				.selectByVisibleText(dataTable.getData("General_Data",
						"Delivery System"));
		driver.findElement(
				By.xpath(UIMapMyLowes.webElmntFertiDeliverySystemHelp))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntFertiDeliverySystemHelpClose)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.btnAddAddress)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// save results to future projects
		new Select(
				driver.findElement(By
						.xpath(UIMapMyLowes.webElmntFertiFutureProjectSelect)))
				.selectByVisibleText(dataTable.getData("General_Data",
						"Future Projects"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(
				By.xpath(UIMapMyLowes.webElmntFertiFutureProjectSelectSave))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.btnSaveEditPAddress))
		.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void calMulchHomeProfileDimentions() throws Exception {
		driver.findElement(By.id("knownDimensions")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// click home profile
		driver.findElement(By.id("hpDimensions")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		
		//if not sign in
		boolean signInToSelectSpace = selenium
				.isTextPresent(UIMapMyLowes.txtSignInToSelectSpace);
		if (signInToSelectSpace) {
			driver.findElement(
					By.xpath(UIMapMyLowes.btnCheckOut))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			signInToSelectSpace();
		}
		
		// create home profile
		boolean createHPD = selenium.isTextPresent(UIMapMyLowes.txtCreateHP);
		if (createHPD) {
			driver.findElement(By.linkText("Create a Home Profile")).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			// create home profile from your account
			driver.findElement(By.cssSelector("#create_profile_link > span"))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			// create home profile dimentions
			createMulchHPD();
		}
		// Add Dimensions
		boolean addDimensions = selenium.isTextPresent(UIMapMyLowes.txtAddDimensions);
		if (addDimensions) {
			driver.findElement(
					By.xpath(UIMapMyLowes.webElmntAddDimensions)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			// create home profile dimentions
			createMulchHPD();
		}
		new Select(driver.findElement(By.id("selectSpace")))
				.selectByVisibleText(dataTable.getData("General_Data",
						"SelectSpace"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// get space dimentions
		driver.findElement(By.xpath(UIMapMyLowes.btnCancelCBCUser)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		new Select(driver.findElement(By.id("productType")))
				.selectByVisibleText(dataTable.getData("General_Data",
						"Mulch Type"));
		Thread.sleep(2000);
		// help
		driver.findElement(
				By.xpath(UIMapMyLowes.webElmntMulchTypeHelp))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntFertiReleaseDateHelpClose)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.id("mulchDepth")).click();
		driver.findElement(By.id("mulchDepth")).clear();
		driver.findElement(By.id("mulchDepth")).sendKeys(
				dataTable.getData("General_Data", "Mulch Depth"));
		driver.findElement(
				By.xpath(UIMapMyLowes.webElmntMulchDepthHelp))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntFertiDeliverySystemHelpClose)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.btnAddAddress)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// save results to future projects
		new Select(
				driver.findElement(By
						.xpath(UIMapMyLowes.webElmntMulchFutureProjectSelect)))
				.selectByVisibleText(dataTable.getData("General_Data",
						"Future Projects"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(
				By.xpath(UIMapMyLowes.webElmntMulchFutureProjectSelectSave))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.btnSaveEditPAddress))
		.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public void observeGrassSeedNPCSection() throws Exception {
		boolean planningTools = selenium.isTextPresent("Planning Tools");
		if (planningTools) {
			boolean fertilizerCal = selenium
					.isTextPresent("Fertilizer Calculator");
			boolean mulchCal = selenium.isTextPresent("Mulch Calculator");
		} else {
			report.updateTestLog("Planning Tools",
					"Planning Tools NOT displayed", Status.FAIL);
		}
		boolean buyingGuides = selenium.isTextPresent("Buying Guides");
		if (buyingGuides) {
			boolean typesOfGrass = selenium.isTextPresent("Types of Grass");
			boolean fertilizerBuyingGuide = selenium
					.isTextPresent("Fertilizer Buying Guide");
			boolean lawnSpreader = selenium
					.isTextPresent("Lawn Spreader Buying Guide");
			boolean gardenTool = selenium
					.isTextPresent("Garden Tool Buying Guide");
		} else {
			report.updateTestLog("Buying Guides",
					"Buying Guides NOT displayed", Status.FAIL);

		}
		boolean howTo = selenium.isTextPresent("How Tos");
		if (howTo) {
			boolean seedLawn = selenium.isTextPresent("Seed Your Lawn");
			boolean aerateLawn = selenium.isTextPresent("Aerate Your Lawn");
			boolean growGrass = selenium
					.isTextPresent("Grow Grass in the Shade");
			boolean fertilizeLawn = selenium
					.isTextPresent("Fertilize Your Lawn");
			boolean testingSoil = selenium
					.isTextPresent("Testing and Improving Your Soil");
			boolean careLawn = selenium.isTextPresent("Care for Your Lawn");
		} else {
			report.updateTestLog("How Tos", "How Tos NOT displayed",
					Status.FAIL);
		}
		boolean relatedProd = selenium.isTextPresent("Related Products");
		if (relatedProd) {
			boolean grasssSeed = selenium.isTextPresent("Grass Seed");
			boolean lawnFertilizer = selenium.isTextPresent("Lawn Fertilizer");
			boolean spreaders = selenium.isTextPresent("Spreaders");
		} else {
			report.updateTestLog("Related Products",
					"Related Products NOT displayed", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public void observeMulchCalNPCSection() throws Exception {
		boolean planningTools = selenium.isTextPresent("Planning Tools");
		if (planningTools) {
			boolean fertilizerCal = selenium
					.isTextPresent("Fertilizer Calculator");
			boolean grassSeed = selenium.isTextPresent("Grass Seed Calculator");
		} else {
			report.updateTestLog("Planning Tools",
					"Planning Tools NOT displayed", Status.FAIL);
		}
		boolean buyingGuides = selenium.isTextPresent("Buying Guides");
		if (buyingGuides) {
			boolean gardenTool = selenium
					.isTextPresent("Garden Tool Buying Guide");
		} else {
			report.updateTestLog("Buying Guides",
					"Buying Guides NOT displayed", Status.FAIL);

		}
		boolean howTo = selenium.isTextPresent("How Tos");
		if (howTo) {
			boolean landscape = selenium.isTextPresent("Landscape with Mulch");
			boolean fixLandscape = selenium
					.isTextPresent("Fix Up Your Landscape");
			boolean watering = selenium
					.isTextPresent("The Importance of Watering");
			boolean gardeners = selenium
					.isTextPresent("Tips for New Gardeners");
		} else {
			report.updateTestLog("How Tos", "How Tos NOT displayed",
					Status.FAIL);
		}
		boolean relatedProd = selenium.isTextPresent("Related Products");
		if (relatedProd) {
			boolean bagged = selenium.isTextPresent("Bagged Mulch");
			boolean tools = selenium.isTextPresent("Garden Tools");
			boolean pavers = selenium
					.isTextPresent("Pavers, Edgers & Retaining Walls");
		} else {
			report.updateTestLog("Related Products",
					"Related Products NOT displayed", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public void observeFertilizerNPCSection() throws Exception {
		boolean planningTools = selenium.isTextPresent("Planning Tools");
		if (planningTools) {
			boolean grassSeed = selenium.isTextPresent("Grass Seed Calculator");
			boolean mulchCal = selenium.isTextPresent("Mulch Calculator");
		} else {
			report.updateTestLog("Planning Tools",
					"Planning Tools NOT displayed", Status.FAIL);
		}
		boolean buyingGuides = selenium.isTextPresent("Buying Guides");
		if (buyingGuides) {
			boolean fertilizerBuyingGuide = selenium
					.isTextPresent("Fertilizer Buying Guide");
			boolean lawnSpreader = selenium
					.isTextPresent("Lawn Spreader Buying Guide");
			boolean gardenTool = selenium
					.isTextPresent("Garden Tool Buying Guide");
		} else {
			report.updateTestLog("Buying Guides",
					"Buying Guides NOT displayed", Status.FAIL);

		}
		boolean howTo = selenium.isTextPresent("How Tos");
		if (howTo) {
			boolean seedLawn = selenium.isTextPresent("Seed Your Lawn");
			boolean aerateLawn = selenium.isTextPresent("Aerate Your Lawn");
			boolean fertilizeLawn = selenium
					.isTextPresent("Fertilize Your Lawn");
			boolean careLawn = selenium.isTextPresent("Care for Your Lawn");
			boolean fixLandscape = selenium
					.isTextPresent("Fix Up Your Landscape");
		} else {
			report.updateTestLog("How Tos", "How Tos NOT displayed",
					Status.FAIL);
		}
		boolean relatedProd = selenium.isTextPresent("Related Products");
		if (relatedProd) {
			boolean fertilizer = selenium.isTextPresent("Fertilizers");
			boolean spreaders = selenium.isTextPresent("Spreaders");
		} else {
			report.updateTestLog("Related Products",
					"Related Products NOT displayed", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void addAreaSquareFootage() throws Exception {
		driver.findElement(By.xpath(UIMapMyLowes.btnbutton3)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.id("area2LengthFt")).clear();
		driver.findElement(By.id("area2LengthFt")).sendKeys(
				dataTable.getData("General_Data", "Area1"));
		driver.findElement(By.id("area2WidthFt")).clear();
		driver.findElement(By.id("area2WidthFt")).sendKeys(
				dataTable.getData("General_Data", "Area2"));

	}

	/************************ BACK FORM ******************************/

	/**
	 * 
	 * @throws Exception
	 */
	public void backSeed() throws Exception {
		driver.navigate().back();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void backMulch() throws Exception {
		driver.navigate().back();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void backFertilizer() throws Exception {
		driver.navigate().back();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void backPaint() throws Exception {
		driver.navigate().back();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/************************ DELETE RESET ***************************/

	/**
	 * 
	 * @throws Exception
	 */
	public void resetAreaFootage() throws Exception {
		driver.findElement(By.cssSelector("a.reset > span")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void resetAreaAcreage() throws Exception {
		driver.findElement(By.cssSelector("a.reset > span")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}


	/**
	 * 
	 * @throws Exception
	 */
	public void deleteAreaSquareFootage() throws Exception {
		driver.findElement(By.xpath(UIMapMyLowes.btnDelArea2)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void deleteWallPaintDimentions() throws Exception {
		driver.findElement(By.xpath(UIMapMyLowes.btnWallArea2)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/************************************* SHOP *********************************/
	/**
	 * 
	 * @throws Exception
	 */
	public void shopSeed() throws Exception {
		// disclaimerShopMulch
		// //*[@id='seedCalculator']/div[2]/div/div[2]/div/div[2]/div[2]/p
		String disclaimerShopMulch = driver.findElement(
				By.xpath(UIMapMyLowes.lblShopSeedDisclaimer)).getText();
		if (disclaimerShopMulch.equals(UIMapMyLowes.txtDisclaimerSeed)) {
			report.updateTestLog("disclaimerShopSeed",
					"disclaimerShopSeed displayed", Status.PASS);
		}
		if (!disclaimerShopMulch.equals(UIMapMyLowes.txtDisclaimerSeed)) {
			String disclaimerShopMulch2 = driver.findElement(
					By.xpath(UIMapMyLowes.lblShopSeedDisclaimer2)).getText();
			if (disclaimerShopMulch2.equals(UIMapMyLowes.txtDisclaimerSeed)) {
				report.updateTestLog("Related Products",
						"disclaimerShopSeed displayed", Status.PASS);
			}
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.btnShopSeed)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void shopMulch() throws Exception {
		// disclaimerShopMulch
		String disclaimerShopMulch = driver
				.findElement(
						By.xpath(UIMapMyLowes.lblShopMulchDisclaimer))
				.getText();
		if (disclaimerShopMulch
				.equals(UIMapMyLowes.txtDisclaimerMulch)) {
			report.updateTestLog("disclaimerShopMulch",
					"disclaimerShopMulch displayed", Status.PASS);
		} else {
			report.updateTestLog("Related Products",
					"disclaimerShopMulch NOT displayed", Status.FAIL);
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(
				By.xpath(UIMapMyLowes.btnShopMulch))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void shopFertilizer() throws Exception {
		// disclaimerShopMulch
		String disclaimerShopFertilizer = driver
				.findElement(
						By.xpath(UIMapMyLowes.lblShopFertiDisclaimer))
				.getText();
		if (disclaimerShopFertilizer
				.equals(UIMapMyLowes.txtDisclaimerFerti)) {
			report.updateTestLog("disclaimershopFertilizer",
					"disclaimershopFertilizer displayed", Status.PASS);
		} else {
			report.updateTestLog("disclaimershopFertilizer",
					"disclaimershopFertilizer NOT displayed", Status.FAIL);
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(
				By.xpath(UIMapMyLowes.btnShopFerti))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void shopPaint() throws Exception{
		// disclaimerShopMulch
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(
				By.xpath(UIMapMyLowes.btnShopPaint))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/********************** CREATE HOME PROFILE METHOD FOR GRASS FERTI MULCH ***************/

	/**
	 * 
	 * @throws Exception
	 */
	public void createGSCHPD() throws Exception {
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// createYardDimentions
		selectingDimentionsFromYard();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// createRecSpaceDimentions
		createRecSpaceDimentions();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// goToCalFromProdListDimentios
		goToCalFromProdListDimensions();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// calculateUsingGrassSeedCalculator
		calculateUsingGrassSeedCalculator();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// calGSCHomeProfileDimentions
		calGSCHomeProfileDimentions();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void createFertiHPD() throws Exception {
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// createYardDimentions
		selectingDimentionsFromYard();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// createRecSpaceDimentions
		createRecSpaceDimentions();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// goToCalFromProdListDimentios
		goToCalFromProdListDimensions();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// calculateUsingGrassSeedCalculator
		calculateUsingFertilizerCalculator();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// calGSCHomeProfileDimentions
		calFertiHomeProfileDimentions();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void createMulchHPD() throws Exception {
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// createYardDimentions
		selectingDimentionsFromYard();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// createRecSpaceDimentions
		createRecSpaceDimentions();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// goToCalFromProdListDimentios
		goToCalFromProdListDimensions();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// calculateUsingMulchCalculator
		calculateUsingMulchCalculator();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// calMulchHomeProfileDimentions
		calMulchHomeProfileDimentions();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

	}

	/**************************** COMMON ********************************/

	/**
	 * 
	 * @throws Exception
	 */
	public void selectingDimentionsFromYard() throws Exception {
		driver.findElement(By.xpath(UIMapMyLowes.webElmntSelectYard))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// selecting product drop down
		driver.findElement(
				By.xpath(UIMapMyLowes.webElmntSelectProductList))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// selecting Dimentions
		driver.findElement(By.xpath(UIMapMyLowes.webElmntSelectDimensions))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void createRecSpaceDimentions() throws Exception {
		driver.findElement(By.xpath(UIMapMyLowes.webElmntClickSpaceShapes)).click();
		driver.findElement(By.xpath(UIMapMyLowes.webElmntCnfrmSwitchShapes)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//
		driver.findElement(By.xpath(UIMapMyLowes.webElmntShapeRect)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(
				By.xpath(UIMapMyLowes.btnContinueSelectedShape)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// give dimentions of rectangle
		driver.findElement(By.xpath(UIMapMyLowes.lblRectDimension)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.lblRectDimension)).sendKeys(
				dataTable.getData("General_Data", "Area1"));
		driver.findElement(By.xpath(UIMapMyLowes.lblCnfrmYardRectDimension)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.lblRectDimension)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.lblRectDimension)).sendKeys(
				dataTable.getData("General_Data", "Area1"));
		driver.findElement(By.xpath(UIMapMyLowes.lblCnfrmYardRectDimension)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.lblRectDimension)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.lblRectDimension)).sendKeys(
				dataTable.getData("General_Data", "Area1"));
		driver.findElement(By.xpath(UIMapMyLowes.lblCnfrmYardRectDimension)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.lblRectDimension)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.lblRectDimension)).sendKeys(
				dataTable.getData("General_Data", "Area1"));
		driver.findElement(By.xpath(UIMapMyLowes.lblCnfrmYardRectDimension)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(
				By.xpath(UIMapMyLowes.btnFinishYardRectShape))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void goToCalFromProdListDimensions() throws Exception {
		driver.findElement(
				By.xpath(UIMapMyLowes.webElmntTabsDimensions))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

		driver.findElement(
				By.xpath(UIMapMyLowes.webElmntCalculations)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void showDetailsGSC() throws Exception{
		boolean showDetailsGSC = selenium.isTextPresent(UIMapMyLowes.txtSeedCalResults);
		if(showDetailsGSC){
			report.updateTestLog("Clicking show details link",
					"show details link displayed", Status.PASS);
			driver.findElement(
					By.xpath(UIMapMyLowes.webElmntShowDetails3)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		}else{
			report.updateTestLog("Clicking show details link",
					"show details link not displayed", Status.FAIL);
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void showDetailsMulch() throws Exception{
		boolean showDetailsGSC = selenium.isTextPresent(UIMapMyLowes.txtMulchCalResults);
		if(showDetailsGSC){
			report.updateTestLog("Clicking show details link",
					"show details link displayed", Status.PASS);
			driver.findElement(
					By.xpath(UIMapMyLowes.webElmntShowDetails2)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		}else{
			report.updateTestLog("Clicking show details link",
					"show details link not displayed", Status.FAIL);
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void showDetailsFerti() throws Exception{
		boolean showDetailsGSC = selenium.isTextPresent(UIMapMyLowes.txtFertiCalResults);
		if(showDetailsGSC){
			report.updateTestLog("Clicking show details link",
					"show details link displayed", Status.PASS);
			driver.findElement(
					By.xpath(UIMapMyLowes.webElmntShowDetails1)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		}else{
			report.updateTestLog("Clicking show details link",
					"show details link not displayed", Status.FAIL);
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void showDetailsPaint() throws Exception{
		boolean showDetailsGSC = selenium.isTextPresent(UIMapMyLowes.txtPaintCalResults);
		if(showDetailsGSC){
			report.updateTestLog("Clicking show details link",
					"show details link displayed", Status.PASS);
			driver.findElement(
					By.xpath(UIMapMyLowes.webElmntShowDetails1)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		}else{
			report.updateTestLog("Clicking show details link",
					"show details link not displayed", Status.FAIL);
		}
	}

	/****************** PAINT DIMENSIONS *******************/
	/**
	 * 
	 * @throws Exception
	 */
	public void enterPaintCalDimensions() throws Exception {
		int wallOptions = ps.countWebElement("//*[@id='wallQuantity']/option");
		report.updateTestLog("Verifying Wall options dropdown",(wallOptions-1)+"Wall options(1-8) displayed in the dropdown",Status.DONE);
		driver.findElement(By.id("wall1HeightFt")).clear();
		driver.findElement(By.id("wall1HeightFt")).sendKeys(
				dataTable.getData("General_Data", "HeightFt"));
		driver.findElement(By.id("wall1HeightIn")).clear();
		driver.findElement(By.id("wall1HeightIn")).sendKeys(
				dataTable.getData("General_Data", "HeightIn"));
		driver.findElement(By.id("wall1WidthFt")).clear();
		driver.findElement(By.id("wall1WidthFt")).sendKeys(
				dataTable.getData("General_Data", "HeightFt"));
		driver.findElement(By.id("wall1WidthIn")).clear();
		driver.findElement(By.id("wall1WidthIn")).sendKeys(
				dataTable.getData("General_Data", "HeightIn"));
		// addPaintCalDimensions
		addPaintCalDimensions();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// deleteWallPaintDimentions
		deleteWallPaintDimentions();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// substract windows and doors
		substractPaintCalDimensions();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.btnAddAddress)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		int coatOptions = ps.countWebElement("//*[@id='paintCoats']/option");
		report.updateTestLog("Verifying coat Options dropdown",(coatOptions-1)+"coat Options(1-8) displayed in the dropdown",Status.DONE);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void addPaintCalDimensions() throws Exception {

		try{
		driver.findElement(By.xpath(UIMapMyLowes.btnCancelCBCUser)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		}
		catch(Exception e){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.btnCancelCBCUser)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		}
		driver.findElement(By.id("wall2HeightFt")).clear();
		driver.findElement(By.id("wall2HeightFt")).sendKeys(
				dataTable.getData("General_Data", "HeightFt"));
		driver.findElement(By.id("wall2HeightIn")).clear();
		driver.findElement(By.id("wall2HeightIn")).sendKeys(
				dataTable.getData("General_Data", "HeightIn"));
		driver.findElement(By.id("wall2WidthFt")).clear();
		driver.findElement(By.id("wall2WidthFt")).sendKeys(
				dataTable.getData("General_Data", "HeightFt"));
		driver.findElement(By.id("wall2WidthIn")).clear();
		driver.findElement(By.id("wall2WidthIn")).sendKeys(
				dataTable.getData("General_Data", "HeightIn"));
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void substractPaintCalDimensions() throws Exception {
		boolean isSelected = driver.findElement(By.id("addWindowsDoors")).isSelected();
		if(!isSelected){
		driver.findElement(By.id("addWindowsDoors")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		}
		new Select(driver.findElement(By.id("windowsQuantity")))
				.selectByVisibleText(dataTable.getData("General_Data",
						"Windows Qty"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		new Select(driver.findElement(By.id("doorsQuantity")))
				.selectByVisibleText(dataTable.getData("General_Data",
						"Doors Qty"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void calPaintHomeProfileDimensions() throws Exception {
		boolean isSelected = driver.findElement(By.id("useExistingSpace")).isSelected();
		if(!isSelected){
		driver.findElement(By.id("useExistingSpace")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		}
		
		//if not sign in
		boolean signInToSelectSpace = selenium
				.isTextPresent(UIMapMyLowes.txtSignInToSelectSpace);
		if (signInToSelectSpace) {
			driver.findElement(
					By.xpath(UIMapMyLowes.btnbutton3))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			signInToSelectSpace();
		}
		
		// Create Home Profile
		boolean createHPD = selenium.isTextPresent(UIMapMyLowes.txtCreateHP);
		if (createHPD) {
			driver.findElement(By.linkText(UIMapMyLowes.txtCreateHP)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			driver.findElement(By.cssSelector("#create_profile_link > span"))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			// createPaintHPD
			createPaintHPD();
		}
		// Add Dimensions
		boolean addDimensions = selenium.isTextPresent(UIMapMyLowes.txtAddDimensions);
		if (addDimensions) {
			driver.findElement(
					By.xpath(UIMapMyLowes.webElmntAddDimensions)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			// createPaintHPD
			createPaintHPD();
		}
		// select HPD
		new Select(driver.findElement(By.id("selectSpace")))
				.selectByVisibleText(dataTable.getData("General_Data",
						"SelectSpace"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// get space dimentions
		driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// get substract information
		// help
		driver.findElement(By.xpath(UIMapMyLowes.webElmntSubPaintHelp))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntFertiReleaseDateHelpClose)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// substract
		substractPaintCalDimensions();
		// calculate
		driver.findElement(By.xpath(UIMapMyLowes.btnAddAddress)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

		// save results to future projects
		new Select(
				driver.findElement(By
						.xpath(UIMapMyLowes.webElmntPaintFutureProjectSelect)))
				.selectByVisibleText(dataTable.getData("General_Data",
						"Future Projects"));
		driver.findElement(
				By.xpath(UIMapMyLowes.webElmntPaintFutureProjectSelectSave))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.btnSaveEditPAddress)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void createPaintHPD() throws Exception {
		// selectingDimentionsFromBathroom
		selectingDimentionsFromBathroom();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// createRecSpaceDimBathroom
		createRecSpaceDimBathroom();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

		// goToCalFromProdListDimentios
		goToCalFromProdListDimensions();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

		// go back to paint calculator
		driver.findElement(
				By.xpath(UIMapMyLowes.webElmntViewAllProjectCal))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntPaintCalculator))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//calPaintHomeProfileDimensions
		calPaintHomeProfileDimensions();

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void selectingDimentionsFromBathroom() throws Exception {
		//driver.findElement(By.xpath(UIMapMyLowes.webElmntBathroom)).click();
		driver.findElement(By.partialLinkText("Bathroom")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// selecting product drop down
		driver.findElement(
				By.xpath(UIMapMyLowes.webElmntSelectProductList))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// selecting Dimentions
		driver.findElement(By.xpath(UIMapMyLowes.webElmntSelectDimensions))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void createRecSpaceDimBathroom() throws Exception {
		driver.findElement(By.xpath(UIMapMyLowes.webElmntShapeRect)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(
				By.xpath(UIMapMyLowes.btnContinueSelectedShape)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// give dimentions of rectangle
		bathroomRecdimensions();
		driver.findElement(
				By.xpath(UIMapMyLowes.btnFinishBathroomRectShape))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

	}

	/**
	 * HeightFt
	 * 
	 * @throws Exception
	 */
	public void bathroomRecdimensions() throws Exception {
		driver.findElement(By.xpath(UIMapMyLowes.lblRectDimension)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.lblRectDimension)).sendKeys(
				dataTable.getData("General_Data", "HeightFt"));
		driver.findElement(By.xpath(UIMapMyLowes.lblCnfrmBathRoomRectDimension)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.lblRectDimension)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.lblRectDimension)).sendKeys(
				dataTable.getData("General_Data", "HeightFt"));
		driver.findElement(By.xpath(UIMapMyLowes.lblCnfrmBathRoomRectDimension)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.lblRectDimension)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.lblRectDimension)).sendKeys(
				dataTable.getData("General_Data", "HeightFt"));
		driver.findElement(By.xpath(UIMapMyLowes.lblCnfrmBathRoomRectDimension)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.lblRectDimension)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.lblRectDimension)).sendKeys(
				dataTable.getData("General_Data", "HeightFt"));
		driver.findElement(By.xpath(UIMapMyLowes.lblCnfrmBathRoomRectDimension)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void deleteSpace() throws Exception {
		driver.findElement(By.xpath(UIMapMyLowes.btnDeleteSpace)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// Delete Confirm
		driver.findElement(
				By.xpath(UIMapMyLowes.btnCnfrmDeleteSpace))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/****************************** signInFertCalToSelectSpace ********************************/
	/**
	 * 
	 * @throws Exception
	 */
	public void signInFertCalToSelectSpace() throws Exception {
		boolean signInToSelectSpace = selenium
				.isTextPresent(UIMapMyLowes.txtSignInToSelectSpace);
		if (signInToSelectSpace) {
			driver.findElement(
					By.xpath(UIMapMyLowes.webElmntFertiFutureProjectSelectSave))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void saveFertiCalFutureProjects() throws Exception {
		boolean createHomeProfile = selenium
				.isTextPresent(UIMapMyLowes.txtCreateHP);
		if (createHomeProfile) {
			driver.findElement(
					By.xpath(UIMapMyLowes.webElmntFertiFutureProjectSelectSave))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		boolean saveToHome = driver
				.findElement(
						By.xpath(UIMapMyLowes.webElmntFertiFutureProjectSelect))
				.isEnabled();
		if (saveToHome) {
			new Select(
					driver.findElement(By
							.xpath(UIMapMyLowes.webElmntFertiFutureProjectSelect)))
					.selectByVisibleText(dataTable.getData("General_Data",
							"Future Projects"));
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			driver.findElement(
					By.xpath(UIMapMyLowes.webElmntFertiFutureProjectSelectSave))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			driver.findElement(By.xpath(UIMapMyLowes.btnSaveEditPAddress))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		}
	}

	/****************************** signInPaintCalToSelectSpace ******************************/
	/**
	 * 
	 * @throws Exception
	 */
	public void signInPaintCalToSelectSpace() throws Exception {
		boolean signInToSelectSpace = selenium
				.isTextPresent(UIMapMyLowes.txtSignInToSelectSpace);
		if (signInToSelectSpace) {
			driver.findElement(
					By.xpath(UIMapMyLowes.btnSignInPaintToSelectSpace))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void savePaintCalFutureProjects() throws Exception {
		boolean createHomeProfile = selenium
				.isTextPresent(UIMapMyLowes.txtCreateHP);
		if (createHomeProfile) {
			driver.findElement(
					By.xpath(UIMapMyLowes.btnSignInPaintToSelectSpace))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		boolean saveToHome = driver
				.findElement(
						By.xpath(UIMapMyLowes.btnPaintCalSaveToHome))
				.isEnabled();
		if (saveToHome) {
			new Select(
					driver.findElement(By
							.xpath(UIMapMyLowes.btnPaintCalSaveToHome)))
					.selectByVisibleText(dataTable.getData("General_Data",
							"Future Projects"));
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			driver.findElement(
					By.xpath(UIMapMyLowes.btnSignInPaintToSelectSpace))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			driver.findElement(By.xpath(UIMapMyLowes.btnSaveEditPAddress))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		}
	}

	/*********************************** signInGSDToSelectSpace ******************************/
	/**
	 * 
	 * @throws Exception
	 */
	public void signInGSDToSelectSpace() throws Exception {
		boolean signInToSelectSpace = selenium
				.isTextPresent(UIMapMyLowes.txtSignInToSelectSpace);
		if (signInToSelectSpace) {
			driver.findElement(
					By.xpath(UIMapMyLowes.btnSignInGSDToSelectSpace))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void saveGSDFutureProjects() throws Exception {
		boolean createHomeProfile = selenium
				.isTextPresent(UIMapMyLowes.txtCreateHP);
		if (createHomeProfile) {
			driver.findElement(
					By.xpath(UIMapMyLowes.btnSignInGSDToSelectSpace))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		boolean saveToHome = driver
				.findElement(
						By.xpath(UIMapMyLowes.btnGSDCalSaveToHome))
				.isEnabled();
		if (saveToHome) {
			new Select(
					driver.findElement(By
							.xpath(UIMapMyLowes.btnGSDCalSaveToHome)))
					.selectByVisibleText(dataTable.getData("General_Data",
							"Future Projects"));
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			driver.findElement(
					By.xpath(UIMapMyLowes.btnSignInGSDToSelectSpace))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			driver.findElement(By.xpath(UIMapMyLowes.btnSaveEditPAddress))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		}
	}

	/********************************* signInMulchCalToSelectSpace *************************/
	/**
	 * 
	 * @throws Exception
	 */
	public void signInMulchCalToSelectSpace() throws Exception {
		boolean signInToSelectSpace = selenium
				.isTextPresent(UIMapMyLowes.txtSignInToSelectSpace);
		if (signInToSelectSpace) {
			driver.findElement(
					By.xpath(UIMapMyLowes.webElmntMulchFutureProjectSelectSave))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void saveMulchCalFutureProjects() throws Exception {
		boolean createHomeProfile = selenium
				.isTextPresent(UIMapMyLowes.txtCreateHP);
		if (createHomeProfile) {
			driver.findElement(
					By.xpath(UIMapMyLowes.webElmntMulchFutureProjectSelectSave))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		boolean saveToHome = driver
				.findElement(
						By.xpath(UIMapMyLowes.webElmntMulchFutureProjectSelect))
				.isEnabled();
		if (saveToHome) {
			new Select(
					driver.findElement(By
							.xpath(UIMapMyLowes.webElmntMulchFutureProjectSelect)))
					.selectByVisibleText(dataTable.getData("General_Data",
							"Future Projects"));
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			driver.findElement(
					By.xpath(UIMapMyLowes.webElmntMulchFutureProjectSelectSave))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			driver.findElement(By.xpath(UIMapMyLowes.btnSaveEditPAddress))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void verifyGardenSpace() throws Exception {
		boolean verifyGarden = selenium.isTextPresent("Garden");
		if(verifyGarden){
			report.updateTestLog("Clicking Your Account link",
					"home profile displayed page displayed", Status.PASS);
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		}
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void signInToSelectSpace() throws Exception {
		boolean verPopUpBoxPresent=selenium.isElementPresent(UIMapMyLowes.lblModalAccount);
		System.out.println("PopUp Window identified is :"+verPopUpBoxPresent);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		boolean verFramePresent=driver.findElement(By.id("iframe_modal_account")).isDisplayed();
		System.out.println("Verifying the Presence of frame id:"+verFramePresent);
		driver.switchTo().frame(driver.findElement(By.id("iframe_modal_account")));
		driver.findElement(By.id("Ecom_User_ID")).sendKeys(dataTable.getData("General_Data","email"));
		driver.findElement(By.id("logonPassword")).sendKeys(dataTable.getData("General_Data", "password"));
		driver.findElement(By.id("logonPassword")).sendKeys(Keys.ENTER);
	}
	
	public void verifyNetArea() throws Exception
	{
		String totalArea= driver.findElement(By.xpath(UIMapMyLowes.webElmntTotalArea)).getText();
		String[] z = totalArea.split(" ");
		String totalAreaSplit= z[0];
		int totalAreaNo= Integer.parseInt(totalAreaSplit);
		
		String nonLawnArea=driver.findElement(By.xpath(UIMapMyLowes.lblNonLawnInAreaTotal)).getText();
		String[] x = nonLawnArea.split(" ");
		String nonLawnAreaSplit= x[0];
		int nonLawnAreaNo= Integer.parseInt(nonLawnAreaSplit);
		
		String netArea= driver.findElement(By.xpath(UIMapMyLowes.lblNetAreaInAreaTotal)).getText();
		String[] y = netArea.split(" ");
		String netAreaSplit= y[0];
		int netAreaNo= Integer.parseInt(netAreaSplit);
		
		if(netAreaNo == (totalAreaNo-nonLawnAreaNo))
			dataTable.putData("General_Data","Net Area",netAreaSplit);
		else
			report.updateTestLog("verifying net area","Net Area is not correct",Status.FAIL);
	}
	public void createRecSpeceWithNonLawnSpaces() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.webElmntShapeRect)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(
				By.xpath(UIMapMyLowes.btnContinueSelectedShape)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		//Entering Top dim
		driver.findElement(By.xpath(UIMapMyLowes.webElmntTopBorder)).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).sendKeys(dataTable.getData("General_Data","Area1"));
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath("//div[16]/div/div[4]/div/a/span")).click();
		
		Thread.sleep(1000);
		String varTopLen = driver.findElement(By.xpath(UIMapMyLowes.webElmntTopCanvas)).getText();
		System.out.println("Top length saved:"+varTopLen);
		String varXpectedTopLen = dataTable.getData("General_Data","Area1").concat("' 0\"");
		System.out.println("Top length xpected:"+varXpectedTopLen);
		if(varTopLen.equals(varXpectedTopLen))
		{
			report.updateTestLog("Entering Top Length","Top Length displayed on top border" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Entering Top Length","Top Length NOT displayed on top border" ,Status.FAIL);
		}
		boolean varTopArrow = driver.findElement(By.xpath(UIMapMyLowes.webElmntTopArrow)).isDisplayed();
		if(varTopArrow)
		{
			report.updateTestLog("Entering Top Length","Arrow on top border" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Entering Top Length","Arrow NOT on top border" ,Status.FAIL);
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntBottomBorder));
		
		//Entering Bottom dim
		driver.findElement(By.xpath(UIMapMyLowes.webElmntBottomBorder)).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).sendKeys(dataTable.getData("General_Data","Area1"));
		//driver.findElement(By.xpath("//div[16]/div/div[4]/div/a/span")).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		String varBottomLen = driver.findElement(By.xpath(UIMapMyLowes.webElmntBottomCanvas)).getText();
		System.out.println("Bottom length saved:"+varBottomLen);
		String varXpectedBottomLen = dataTable.getData("General_Data","Area1").concat("' 0\"");
		System.out.println("Bottom length xpected:"+varXpectedBottomLen);
		if(varBottomLen.equals(varXpectedBottomLen))
		{
			report.updateTestLog("Entering Bottom Length","Bottom Length displayed on Bottom border" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Entering Bottom Length","Bottom Length NOT displayed on Bottom border" ,Status.FAIL);
		}
		boolean varBottomArrow = driver.findElement(By.xpath(UIMapMyLowes.webElmntBottomArrow)).isDisplayed();
		if(varBottomArrow)
		{
			report.updateTestLog("Entering Bottom Length","Arrow on Bottom border" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Entering Bottom Length","Arrow NOT on Bottom border" ,Status.FAIL);
		}
		Thread.sleep(2000);
		//Entering Left dim
		driver.findElement(By.xpath(UIMapMyLowes.webElmntLeftBorder));
		
		driver.findElement(By.xpath(UIMapMyLowes.webElmntLeftBorder)).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).sendKeys(dataTable.getData("General_Data","Area1"));
		//driver.findElement(By.xpath("//div[16]/div/div[4]/div/a/span")).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		String varLeftLen = driver.findElement(By.xpath(UIMapMyLowes.webElmntLeftCanvas)).getText();
		System.out.println("Left length saved:"+varLeftLen);
		String varXpectedLeftLen = dataTable.getData("General_Data","Area1").concat("' 0\"");
		System.out.println("Left length xpected:"+varXpectedLeftLen);
		if(varLeftLen.equals(varXpectedLeftLen))
		{
			report.updateTestLog("Entering Left Length","Left Length displayed on Left border" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Entering Left Length","Left Length NOT displayed on Left border" ,Status.FAIL);
		}
		boolean varLeftArrow = driver.findElement(By.xpath(UIMapMyLowes.webElmntLeftArrow)).isDisplayed();
		if(varLeftArrow)
		{
			report.updateTestLog("Entering Left Length","Arrow on Left border" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Entering Left Length","Arrow NOT on Left border" ,Status.FAIL);
		}
		
		//Entering Right dim
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntRightBorder));
		driver.findElement(By.xpath(UIMapMyLowes.webElmntRightBorder)).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).sendKeys(dataTable.getData("General_Data","Area1"));
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		String varRightLen = driver.findElement(By.xpath(UIMapMyLowes.webElmntRightCanvas)).getText();
		System.out.println("Right length saved:"+varRightLen);
		String varXpectedRightLen = dataTable.getData("General_Data","Area1").concat("' 0\"");
		System.out.println("Right length xpected:"+varXpectedRightLen);
		if(varRightLen.equals(varXpectedRightLen))
		{
			report.updateTestLog("Entering Right Length","Right Length displayed on Right border" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Entering Right Length","Right Length NOT displayed on Right border" ,Status.FAIL);
		}
		boolean varRightArrow = driver.findElement(By.xpath(UIMapMyLowes.webElmntRightArrow)).isDisplayed();
		if(varRightArrow)
		{
			report.updateTestLog("Entering Right Length","Arrow on Right border" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Entering Right Length","Arrow NOT on Right border" ,Status.FAIL);
		}
		
		driver.findElement(By.xpath("//*[@id='negativeSpaces']/div[2]/div/span[1]/input")).clear();
		driver.findElement(By.xpath("//*[@id='negativeSpaces']/div[2]/div/span[1]/input")).sendKeys("NewShape");
		driver.findElement(By.xpath("//*[@id='negativeSpaces']/div[2]/div/span[2]/input")).clear();
		driver.findElement(By.xpath("//*[@id='negativeSpaces']/div[2]/div/span[2]/input")).sendKeys("5");
		driver.findElement(
				By.xpath(UIMapMyLowes.btnFinishYardRectShape))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}
	
	public void verifyPulledDataFromHP() throws Exception
	{
		if(driver.findElement(By.id("hpDimensions")).getAttribute("checked").equals("true"))
		{
		String status = driver.findElement(By.id("hpDimensions")).getAttribute("checked");
		System.out.println("Status"+status);
		new Select(driver.findElement(By.id("selectSpace")))
			.selectByVisibleText(dataTable.getData("General_Data",
					"SelectSpace")+" ("+dataTable.getData("General_Data",
					"Net Area")+" sq. ft.)");
			System.out.println("Selected space");
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			// get space dimentions
			driver.findElement(By.xpath(UIMapMyLowes.btnCancelCBCUser)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			System.out.println("HHHH"+driver.findElement(By.id("areaTotal")).getAttribute("value"));
			System.out.println("Pulled Data"+dataTable.getData("General_Data","Net Area"));
			if(driver.findElement(By.id("areaTotal")).getAttribute("value").equals(dataTable.getData("General_Data","Net Area")))
				report.updateTestLog("Verifying Pulled Data from HP","Data pulled correctly",Status.PASS);
			else
				report.updateTestLog("Verifying Pulled Data from HP","Data pulled Incorrectly",Status.FAIL);
		}
		else
	      report.updateTestLog("Verifying whether Use Dimensions dropdown selected by default","Use Dimensions dropdown Not selected by default",Status.FAIL);
	}
	
	/*This function opens Calculations tab for a space in Home Profile*/
	public void openCalculationsTabInHPspace() throws Exception
	{
		driver.findElement(By.cssSelector(UIMapMyLowes.webElmntShow)).click();
		driver.findElement(By.linkText("Calculations")).click();
		Thread.sleep(5000);
		boolean varDimensions = selenium.isElementPresent(UIMapMyLowes.webElmntDimHeading);
		if(varDimensions)
		{
			report.updateTestLog("Opening Calculations tab","Calculations opened" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Opening Calculations tab","Calculations NOT opened" ,Status.FAIL);
		}	
	}
	public void clickPaintCalcFromInteriorSpace() throws Exception
	{
		openCalculationsTabInHPspace();
		ClickCustomize("xpath",UIMapMyLowes.webElmntPaintCalculator);
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}
	public void enterWallDimensionsForPaint() throws Exception
	{
		driver.findElement(By.id("wall1HeightFt")).clear();
		driver.findElement(By.id("wall1HeightFt")).sendKeys(
				dataTable.getData("General_Data", "HeightFt"));
		driver.findElement(By.id("wall1HeightIn")).clear();
		driver.findElement(By.id("wall1HeightIn")).sendKeys(
				dataTable.getData("General_Data", "HeightIn"));
		driver.findElement(By.id("wall1WidthFt")).clear();
		driver.findElement(By.id("wall1WidthFt")).sendKeys(
				dataTable.getData("General_Data", "HeightFt"));
		driver.findElement(By.id("wall1WidthIn")).clear();
		driver.findElement(By.id("wall1WidthIn")).sendKeys(
				dataTable.getData("General_Data", "HeightIn"));
		driver.findElement(By.xpath(UIMapMyLowes.btnAddAddress)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}
	public void verifyEstimatedCoverageAmounts() throws Exception
	{
	  String s = "Estimated Coverage Amounts:.*Paint: 350 sq. ft. per gallon.*Primer: 200 sq. ft. per gallon.*";
	  String showedText = driver.findElement(By.xpath(UIMapMyLowes.lblEstCoverageAmnts)).getText();
	  Pattern p = Pattern.compile(s);
	  Matcher m = p.matcher(showedText);
	  System.out.println("Pattern"+p);
	  System.out.println("ShowedText"+showedText);
		if (m.find())
			report.updateTestLog("Verifying Estimated Coverage Amounts section","Estimated Coverage Amounts section displayed correctly.",Status.PASS);
		else
			report.updateTestLog("Verifying Estimated Coverage Amounts section","Estimated Coverage Amounts section Not displayed correctly.",Status.FAIL);
	}
	
	
}
