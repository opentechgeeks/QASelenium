package com.lowes.qa.selenium.components;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
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
 * My Lowes_ID Class
 * @author Infosys
 */
public class MyLowes_ID extends ReusableLibrary
{
	/**
	 * Constructor to initialize the component library
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link DriverScript}
	 */
	
	String baseurl = dataTable.getData("General_Data", "URL");
	Selenium selenium = new WebDriverBackedSelenium(driver, baseurl);
	FunctionalComponents fc = new FunctionalComponents(scriptHelper);
	MyLowes mylowes = new MyLowes(scriptHelper);
	CheckOut_CM cm= new CheckOut_CM(scriptHelper);
	ProductSearch ps= new ProductSearch(scriptHelper);
	ProductSearch_SB ps2=new ProductSearch_SB(scriptHelper);
	public MyLowes_ID(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
	}
	/**
	 * This verifyingPriceFromProductDetailPageAndListsPage() method is used to validate the price from product detail page and lists page.
	 * @throws Exception 
	 * 
	 */
	public void verifyingPriceFromProductDetailPageAndListsPage() throws Exception
	{
		mylowes.verifyingRegisteredUserLoginModal();
		Thread.sleep(5000);
		fc.changeStore();
		Thread.sleep(5000);
		//search for an item
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","ItemNbr"));
		try {
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
			Thread.sleep(5000);
		} catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		}
		Thread.sleep(5000);
		report.updateTestLog("Searching For an Item","Searching Item Number - "+dataTable.getData("General_Data","ItemNbr")+"" ,Status.DONE);
		selenium.waitForPageToLoad("30000");											  
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
		
		driver.findElement(By.cssSelector(UIMapMyLowes.lnkSaveToLists)).click();
	    Thread.sleep(10000);
	    
		//Get the price of the product from product detail page
		String priceFromPDPage  = driver.findElement(By.xpath(UIMapMyLowes.txtPriceOfPrdInPDP)).getText();
		
		//Go to lists and verify the price
    	driver.findElement(By.linkText(UIMapMyLowes.lnkGoToLists)).click();
    	String priceFromLists = driver.findElement(By.xpath(UIMapMyLowes.txtPriceOfPrdInLstPg)).getText();
		
		if(priceFromLists.contains(priceFromPDPage))
		{
			report.updateTestLog("Veriyfication of price from product detail page and List page ","Verification is successful", Status.PASS);
		}
		else{
			report.updateTestLog("Veriyfication of price from product detail page and List page ","Verification is failed", Status.FAIL);
		}    
	}
	
	public void mouseHoverToListsFromYourAccount() throws Exception
	{
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.id(UIMapMyLowes.mouseHvrYourAccount)); 
	    actions.moveToElement(menuHoverLink).build().perform(); 
	    //Thread.sleep(10000);
	    System.out.println("Mouse Hover successful"); 
	    Thread.sleep(20000); 
	    WebElement subLink = driver.findElement(By.id(UIMapMyLowes.lnkLists)); 
	    actions.moveToElement(subLink).moveToElement(subLink).click().build().perform();
    
	}
	/**
	 * This verifyingWelcomeMessageInLists() method is used to verify the Welcome message in lists page.
	 * @throws Exception 
	 * 
	 */
	public void verifyingWelcomeMessageInLists() throws Exception
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
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkListsFromMyLowes)).click();
	    Thread.sleep(10000);
	    //driver.findElement(By.id(UIMapMyLowes.lnkShowWelcome)).click();
        //Check whether the Welcome message is present
        if(driver.findElement(By.xpath(UIMapMyLowes.txtPresentWlcmMsg)).isDisplayed())
        {
        	report.updateTestLog("Verification of welcome message in List page ","Verification is successful", Status.PASS);
        }
        else{
        	report.updateTestLog("Verification of welcome message in List page ","Verification is not successful", Status.FAIL);
        }
        //Hide the Welcome message
	    driver.findElement(By.id(UIMapMyLowes.lnkHideWelcome)).click();
	    Thread.sleep(5000);
	    //Show the Welcome message
	    driver.findElement(By.id(UIMapMyLowes.lnkShowWelcome)).click();
	    //Check whether the Welcome message is present
	    if(driver.findElement(By.xpath(UIMapMyLowes.txtPresentWlcmMsg)).isDisplayed())
        {
        	report.updateTestLog("Verification of welcome message in List page after hide","Verification is successful", Status.PASS);
        }
        else{
        	report.updateTestLog("Verification of welcome message in List page after hide","Verification is not successful", Status.FAIL);
        }
	}
	
	/**
	 * This verifyingListSectionInLists() method is used to verify the List section in Your Account Landing  page
	 * @throws Exception 
	 * 
	 */
	public void verifyingListSectionYourAccountLandingPage() throws Exception
	{
		fc.lowesUserRegistration();
		Thread.sleep(5000);
		fc.changeStore();
		Thread.sleep(5000);
		//mouseHoverToListsFromYourAccount();		
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
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkListsFromMyLowes)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
		String txtToBeDisplayed = "0 Items";
		String txtDisplayed = driver.findElement(By.xpath(UIMapMyLowes.txtOverview)).getText();
        
		if(txtDisplayed.contains(txtToBeDisplayed))
        {
        	report.updateTestLog("Verification of empty list message in List page","Verification is successful", Status.PASS);
        }
        else{
        	report.updateTestLog("Verification of empty list message in List page","Verification is not successful", Status.FAIL);
        }
		driver.findElement(By.xpath(UIMapMyLowes.webElmntSalutationListsPage)).click();
		
				
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
		fc.changeStore();
		Thread.sleep(5000);
		//mouseHoverToListsFromYourAccount();
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
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkListsFromMyLowes)).click();
	    Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
		Thread.sleep(5000);
		
		txtDisplayed = driver.findElement(By.xpath(UIMapMyLowes.txtOverview)).getText();
		if(txtDisplayed.contains(txtToBeDisplayed))
        {
        	report.updateTestLog("Verification of empty list message in List page","Verification is successful", Status.PASS);
        }
        else{
        	report.updateTestLog("Verification of empty list message in List page","Verification is not successful", Status.FAIL);
        }
		driver.findElement(By.xpath(UIMapMyLowes.webElmntSalutationListsPage)).click();
	    
	}
	
	
	/**
	 *  This verifyingSaveItemWithoutSignUp() method is used to sign in at the time of adding the item to 
	 *  list and verifying the item in the Lists under Your Account after creating an account
	 * 
	 */
	public void verifyingSaveItemWithoutSignUp() throws Exception{
		 
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","ItemNbr"));
		try {
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
			Thread.sleep(5000);
		} catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		}
		Thread.sleep(5000);
		report.updateTestLog("Searching For an Item","Searching Item Number - "+dataTable.getData("General_Data","ItemNbr")+"" ,Status.DONE);
		selenium.waitForPageToLoad("30000");
		//String itemFromPDDPage = driver.findElement(By.xpath("//*[@id='descCont']/div[1]/h1")).getText();												  
		boolean verItemPresent=selenium.isTextPresent("Item #: "+dataTable.getData("General_Data","ItemNbr"));
		if(verItemPresent)
		{
			report.updateTestLog("Veriyfing Navigating to Item's PDP Page","Item - " +dataTable.getData("General_Data","ItemNbr") +" is Present", Status.PASS);
		}
		else
		{
			report.updateTestLog("Veriyfing Navigating to Item's PDP Page","Item is NOT Present", Status.FAIL);
		}
		try{
			//Adding the element to the list after finding the element
			driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveItem)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveItem)).click();
		}
		Thread.sleep(3000);
		try{
			//Adding the element to the list after finding the element
			driver.findElement(By.cssSelector(UIMapMyLowes.lnkSaveToLists)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.cssSelector(UIMapMyLowes.lnkSaveToLists)).click();
		}
		
	    Thread.sleep(10000);
	    selenium.windowFocus();
		selenium.waitForPageToLoad("15000");
		boolean verPopUpBoxPresent=selenium.isElementPresent(UIMapFunctionalComponents.webElmntLoginPopup);
		System.out.println("PopUp Window identified is :"+verPopUpBoxPresent);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		boolean verFramePresent=driver.findElement(By.id(UIMapFunctionalComponents.webElmntLoginFrame)).isDisplayed();
		System.out.println("Verifying the Presence of frame id:"+verFramePresent);
		driver.switchTo().frame(driver.findElement(By.id(UIMapFunctionalComponents.webElmntLoginFrame)));
	    driver.findElement(By.xpath(UIMapMyLowes.btnSignInFrame)).click();
	    fc.lowesUserRegistration();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkListsFromMyLowes)).click();
	    Thread.sleep(5000);
	    //mouseHoverToListsFromYourAccount();
	    driver.findElement(By.xpath(UIMapMyLowes.lnkShowAllItems)).click();
	    Thread.sleep(5000);
	    String itemInLists = driver.findElement(By.xpath(UIMapMyLowes.txtOverview)).getText();	
	    String itemFromPDDPage = "0 Items";
		if(itemInLists.contains(itemFromPDDPage))
        {
        	report.updateTestLog("Verification of empty list message in List page","Verification is successful", Status.PASS);
        }
        else{
        	report.updateTestLog("Verification of empty list message in List page","Verification is not successful", Status.FAIL);
        }
	}
	
	/**
	 *  This verifyingWriteEntry() method is used to verify the write entry option in Lists page
	 * 
	 */
	public void verifyingWriteEntry() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
		fc.changeStore();
		Thread.sleep(5000);
		//mouseHoverToListsFromYourAccount();
		searchAnItemAndAddtoLists();
		try{
		driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
		Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
            }
		driver.findElement(By.cssSelector(UIMapMyLowes.btnAddEntry)).click();
		if(driver.findElement(By.xpath(UIMapMyLowes.webElmntPresenttxtBoxWriteEntry1)).isDisplayed() && 
		driver.findElement(By.xpath(UIMapMyLowes.webElmntPresenttxtBoxWriteEntry2)).isDisplayed() && 
		driver.findElement(By.xpath(UIMapMyLowes.webElmntPresenttxtBoxWriteEntry3)).isDisplayed() &&
		driver.findElement(By.xpath(UIMapMyLowes.webElmntPresenttxtBoxWriteEntry4)).isDisplayed() &&
		driver.findElement(By.xpath(UIMapMyLowes.webElmntPresenttxtBoxWriteEntry5)).isDisplayed() &&
		driver.findElement(By.xpath(UIMapMyLowes.webElmntPresenttxtBoxWriteEntry6)).isDisplayed())	{
			report.updateTestLog("Verification of WriteEntry button in Lists page","Verification is successful", Status.PASS);
		}
		else{
			report.updateTestLog("Verification of WriteEntry button in Lists page","Verification is not successful", Status.FAIL);
		}
		 driver.findElement(By.cssSelector(UIMapMyLowes.btnCancelSave)).click();
		 Thread.sleep(5000);
		 driver.findElement(By.cssSelector(UIMapMyLowes.btnAddEntry)).click();
		 driver.findElement(By.id(UIMapMyLowes.txtAddItmNm)).clear();
		 driver.findElement(By.id(UIMapMyLowes.txtAddItmNm)).sendKeys("Test");
		 driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveEntry)).click();
		 Thread.sleep(5000);
		 driver.findElement(By.cssSelector(UIMapMyLowes.btnDelEntry)).click();
	}
	
	/**
	 *  This verifyingWriteEntry() method is used to verify the write entry option in Lists page
	 * 
	 */
	public void verifyingEditNote() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
		fc.changeStore();
		Thread.sleep(5000);
		//mouseHoverToListsFromYourAccount();

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
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkListsFromMyLowes)).click();
	    Thread.sleep(5000);
		driver.findElement(By.cssSelector(UIMapMyLowes.btnAddEntry)).click();//Click on Write entry
		if(driver.findElement(By.xpath(UIMapMyLowes.webElmntPresenttxtBoxWriteEntry1)).isDisplayed() && 
		driver.findElement(By.xpath(UIMapMyLowes.webElmntPresenttxtBoxWriteEntry2)).isDisplayed() && 
		driver.findElement(By.xpath(UIMapMyLowes.webElmntPresenttxtBoxWriteEntry3)).isDisplayed() &&
		driver.findElement(By.xpath(UIMapMyLowes.webElmntPresenttxtBoxWriteEntry4)).isDisplayed() &&
		driver.findElement(By.xpath(UIMapMyLowes.webElmntPresenttxtBoxWriteEntry5)).isDisplayed() &&
		driver.findElement(By.xpath(UIMapMyLowes.webElmntPresenttxtBoxWriteEntry6)).isDisplayed())	{
			report.updateTestLog("Verification of WriteEntry button in Lists page","Verification is successful", Status.PASS);
		}
		else{
			report.updateTestLog("Verification of WriteEntry button in Lists page","Verification is not successful", Status.FAIL);
		}
		 driver.findElement(By.cssSelector(UIMapMyLowes.btnCancelSave)).click();
		 Thread.sleep(5000);
		 driver.findElement(By.cssSelector(UIMapMyLowes.btnAddEntry)).click();
		 Thread.sleep(5000);
		 driver.findElement(By.id(UIMapMyLowes.txtAddItmNm)).clear();
		 driver.findElement(By.id(UIMapMyLowes.txtAddItmNm)).sendKeys("Test");
		 driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveEntry)).click(); 
		 
		 
	}
	
	/**
	 *  This verifyingEditNotesForLists() method is used to verify the write entry option in Lists page
	 * 
	 */
	public void verifyingEditNotesForLists() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
		fc.changeStore();
		Thread.sleep(5000);
		searchAnItemAndAddtoLists();
		driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapMyLowes.lnkEdit)).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(UIMapMyLowes.btnEditCancelSave)).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapMyLowes.lnkEdit)).click();
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapMyLowes.txtEditItemNotes)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtEditItemNotes)).sendKeys(dataTable.getData("General_Data","Notes"));
		driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveEditedNotes)).click();	
		Thread.sleep(7000);
		if(driver.findElement(By.xpath(UIMapMyLowes.txtNotes)).getText().contains(dataTable.getData("General_Data","Notes"))){
			report.updateTestLog("Veriyfing Notes from Edit","Verification is successful", Status.PASS);
		}
		else{
			report.updateTestLog("Veriyfing Notes from Edit","Verification is not successful", Status.FAIL);
		}
		
		
	    deleteFromLists();
 }
	
		public void deleteFromLists() throws Exception {
		driver.findElement(By.name(UIMapMyLowes.chkBoxBatchChk)).click();
		Thread.sleep(4000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnSelectmMenu)).click();
	    Thread.sleep(4000);
	    driver.findElement(By.id(UIMapMyLowes.lnkBatchDelete)).click();
	}
	/**
	 *  This saveItemsToLists() method is used to save the items to lists
	 * 
	 */
	public void saveItemsToListsFromPDPage() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
		fc.changeStore();
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","ItemNbr"));
		try {
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
			Thread.sleep(5000);
		} catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		}
		Thread.sleep(5000);
		report.updateTestLog("Searching For an Item","Searching Item Number - "+dataTable.getData("General_Data","ItemNbr")+"" ,Status.DONE);
		//selenium.waitForPageToLoad("30000");
		Thread.sleep(7000);
		String itemFromPDPage = driver.findElement(By.xpath(UIMapMyLowes.txtItemInPdPage)).getText();		
		
		//Adding the element to the list after finding the element
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
		if(itemInLists.equals(itemFromPDPage)){
			report.updateTestLog("Verification of item in List page from PD Page","Verification is successful", Status.PASS);
        }
        else{
        	report.updateTestLog("Verification of item in List page from PD Page","Verification is not successful", Status.FAIL);
		}
		
		deleteFromLists();
	}
	
	/**
	 *  This saveItemsToListsWithDocuments() method is used to save the items to lists
	 * 
	 */
	public void saveItemsToListsWithDocuments() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
		fc.changeStore();
		Thread.sleep(5000);
		//mouseHoverToListsFromYourAccount();
		searchAnItemAndAddtoLists();
		driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
		Thread.sleep(7000);
		driver.findElement(By.linkText(UIMapMyLowes.lnkEdit)).click();
		Thread.sleep(7000);
		String relatedText  = driver.findElement(By.xpath(UIMapMyLowes.txtRltdTxt)).getText();
		String[] s = relatedText.split("\n"); 
        String line1 = s[1]; 
      
        if(!line1.isEmpty()){
        	report.updateTestLog("Verifying Related documents in Lists Page","Verification is successful", Status.PASS);
        }
        else{
        	report.updateTestLog("Verifying Related documents in Lists Page","Verification is not successful", Status.FAIL);
        }
        deleteFromLists();
      }
   

     /**
	 *  This verifyDateAddedForProducts() method is used to save the items to lists
	 * 
	 */
	public void verifyDateAddedForProducts() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
		fc.changeStore();
		Thread.sleep(5000);
		searchAnItemAndAddtoLists();
		driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
		Thread.sleep(7000);
		driver.findElement(By.linkText(UIMapMyLowes.lnkEdit)).click();
		Thread.sleep(7000);
		String dateAdded = driver.findElement(By.xpath(UIMapMyLowes.txtDateAdded)).getText();
		System.out.println(""+dateAdded);
		compareDateFromPDDPageWithListsPage(dateAdded);
		deleteFromLists();
		
	}
	private void compareDateFromPDDPageWithListsPage(String dateAdded) {
		
		 SimpleDateFormat dayFormat= new SimpleDateFormat("dd,");
		 SimpleDateFormat monthFormat= new SimpleDateFormat("MMM");
		 SimpleDateFormat yearFormat= new SimpleDateFormat("YYYY");
		//String datedisp1 = "Added on Dec 12, 2013";
		String[] dateSeperator = dateAdded.split("\\s");
		
		String date0 = dateSeperator[0];
		String date1 = dateSeperator[1];
		String date2 = dateSeperator[2];
		String date3 = dateSeperator[3];
		String date4 = dateSeperator[4];
		
		Date date = new Date(); 
        String day = dayFormat.format(date);
        String month = monthFormat.format(date);
        String year = yearFormat.format(date);
    	System.out.println(date2+"::"+month);
    	System.out.println(date3+"::"+day);
    	System.out.println(date4+"::"+year);
    	if(date2.equals(month) && date3.equals(day) &&date4.equals(year)  ){
    		report.updateTestLog("Verifying dates displayed in PDD Page and Lists Page","Verification is successful", Status.PASS);
		}
    	else{
    		report.updateTestLog("Verifying dates displayed in PDD Page and Lists Page","Verification is not successful", Status.FAIL);
    	}
	}
	/**
	 *  This moveItemsFromLists() method is used to move items from lists to a new destination
	 * 
	 */
	public void moveItemsFromLists() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
		fc.changeStore();
		Thread.sleep(5000);
		searchAnItemAndAddtoLists();
		try{
			driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
			Thread.sleep(5000);
		}
        catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
            Thread.sleep(5000);
        }
		driver.findElement(By.name(UIMapMyLowes.chkBoxBatchChk)).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(UIMapMyLowes.btnSelectmMenu)).click();
		driver.findElement(By.linkText(UIMapMyLowes.lnkMove)).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(UIMapMyLowes.btnMoveItem)).click();
		Thread.sleep(5000);
		deleteFromLists();	
		
	}
	
	/**
	 *  This createNewList() method is used to give a new name to the new list
	 * 
	 */
	public void createNewList() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
		fc.changeStore();
		Thread.sleep(5000);
		//mouseHoverToListsFromYourAccount();
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
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkListsFromMyLowes)).click();
	    Thread.sleep(5000);
		driver.findElement(By.cssSelector(UIMapMyLowes.btnAddList)).click();
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapMyLowes.txtAddList)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtAddList)).sendKeys(dataTable.getData("General_Data","newListName"));
		driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveList)).click();
		Thread.sleep(5000);
		if(driver.findElement(By.xpath(UIMapMyLowes.txtNewList)).getText().equals(dataTable.getData("General_Data","newListName"))){
			report.updateTestLog("Verifying newly created list in Lists page","New List creation is successful", Status.PASS);
		}
		else{
			report.updateTestLog("Verifying newly created list in Lists page","New List creation is not successful", Status.FAIL);
		}
		driver.findElement(By.linkText(UIMapMyLowes.lnkDelList)).click();
		Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnDelList)).click();
	    Thread.sleep(5000);
	}

	/**
	 *  This eidtNewListTitle() method is used to check whether a list is created without specifying the name
	 * 
	 */
	public void editNewListTitle() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
		fc.changeStore();
		Thread.sleep(5000);
		//mouseHoverToListsFromYourAccount();
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
		driver.findElement(By.cssSelector(UIMapMyLowes.lnkListsFromMyLowes)).click();
	    Thread.sleep(5000);
		driver.findElement(By.cssSelector(UIMapMyLowes.btnAddList)).click();
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapMyLowes.txtAddList)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtAddList)).sendKeys(dataTable.getData("General_Data","newListName"));
		driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveList)).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapMyLowes.lnkRenameList)).click();
		Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.txtNewListNm)).clear();
	    driver.findElement(By.cssSelector(UIMapMyLowes.txtNewListNm)).sendKeys(dataTable.getData("General_Data","newListName"));
	    driver.findElement(By.xpath(UIMapMyLowes.btnSaveEditedList)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.linkText(UIMapMyLowes.lnkDelList)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnDelList)).click();
	    Thread.sleep(5000);
		
	}
	/**
	 *  This editNoteAndSave() method is used to edit the note and save it
	 * 
	 */
	public void editNoteAndSave() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
		fc.changeStore();
		Thread.sleep(5000);
		searchAnItemAndAddtoLists();
		try{
			driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
			Thread.sleep(5000);
		}
        catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
        }
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapMyLowes.lnkEdit)).click();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnEditCancelSave)).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapMyLowes.lnkEdit)).click();
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapMyLowes.txtEditItemNotes)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtEditItemNotes)).sendKeys(dataTable.getData("General_Data","Notes"));
		driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveEditedNotes)).click();	
		Thread.sleep(7000);
		driver.findElement(By.linkText(UIMapMyLowes.lnkEdit)).click();
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapMyLowes.txtEditItemNotes)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtEditItemNotes)).sendKeys(dataTable.getData("General_Data","NotesNew"));	
		driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveEditedNotes)).click();	
		Thread.sleep(7000);
	    deleteFromLists();
		
	}
	
	/**
	 *  This editTitleOfTheProduct() method is used to change the name of the product from the existing list
	 * 
	 */
	public void editTitleOfTheProduct() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
		fc.changeStore();
		Thread.sleep(5000);
		searchAnItemAndAddtoLists();
		try{
			driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
			Thread.sleep(5000);
		}
        catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
        }
        Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapMyLowes.lnkEdit)).click();
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapMyLowes.txtEditItemTitle)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtEditItemTitle)).sendKeys(dataTable.getData("General_Data","NewNameForProduct"));
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveEditedNotes)).click();
	    Thread.sleep(5000);
	    String text = driver.findElement(By.xpath(UIMapMyLowes.txtNewItemTitle)).getText();
	    if(text.equals(dataTable.getData("General_Data","NewNameForProduct"))){
	    	report.updateTestLog("Verifying the title change of the product in Lists page" ,"Title change is successful", Status.PASS);
	    }
	    else{
	    	report.updateTestLog("Verifying the title change of the product in Lists page" ,"Title change is not successful", Status.FAIL);
	    }
	    deleteFromLists();
		
	}
	
	/**
	 *  This editAndUpdateTheEntry() method is used to add the new entry , edit the entry and save it
	 * 
	 */
	public void editAndUpdateTheEntry() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(10000);
		fc.changeStore();
		Thread.sleep(5000);
		searchAnItemAndAddtoLists();
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
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkListsFromMyLowes)).click();
	    try{
			driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
			Thread.sleep(5000);
		}
        catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
        }
		Thread.sleep(5000);
		try{
			driver.findElement(By.cssSelector(UIMapMyLowes.btnAddEntry)).click();
			Thread.sleep(5000);
		}
        catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.cssSelector(UIMapMyLowes.btnAddEntry)).click();
        }		
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapMyLowes.txtAddItmNm)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtAddItmNm)).sendKeys(dataTable.getData("General_Data","EntryTitle"));
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapMyLowes.txtAddItemNotes)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtAddItemNotes)).sendKeys(dataTable.getData("General_Data","Notes"));
		Thread.sleep(5000);
		 try{
			 driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveEntry)).click();
			Thread.sleep(5000);
			}
	        catch(Exception WebDriverException){
	            driver.findElement(By.linkText("No, thanks")).click();
	            report.updateTestLog("Survey Popup","Handled", Status.DONE);
	            driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveEntry)).click();
	        }
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapMyLowes.lnkEdit)).click();
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapMyLowes.txtEditItemNotes)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtEditItemNotes)).sendKeys(dataTable.getData("General_Data","NotesNew"));
		driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveEditedNotes)).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(UIMapMyLowes.btnDelItem)).click();
			
	}
	/**
	 *  This editEntryTitle() method is used to provide the title of the entry.
	 * 
	 */
	public void editEntryTitle() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
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
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkListsFromMyLowes)).click();
	    Thread.sleep(5000); 
	    try{
			driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
			Thread.sleep(5000);
		}
        catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
        }
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(UIMapMyLowes.btnAddEntry)).click();
		Thread.sleep(5000); 
		driver.findElement(By.id(UIMapMyLowes.txtAddItmNm)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtAddItmNm)).sendKeys(dataTable.getData("General_Data","EntryTitle"));
		driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveEntry)).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(UIMapMyLowes.btnDelItem)).click();
			
	}
	
	/**
	 *  This verifySignUpPopUpFromNPCProductsPage() method is used to provide the title of the entry.
	 * 
	 */
	public void verifySignUpPopUpFromNPCProductsPage() throws Exception {
		
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.xpath(UIMapMyLowes.mouseHvrHeaderBlock)); 
	    actions.moveToElement(menuHoverLink).build().perform(); 
	    System.out.println("Mouse Hover successful"); 
	    try{
	    	driver.findElement(By.linkText(UIMapMyLowes.lnkKtchnAndDng)).click();
		    Thread.sleep(5000); 
		    }
		    catch(Exception WebDriverException){
	            driver.findElement(By.linkText("No, thanks")).click();
	            report.updateTestLog("Survey Popup","Handled", Status.DONE);
	            driver.findElement(By.linkText(UIMapMyLowes.lnkKtchnAndDng)).click();
	        }
		 try{
			 driver.findElement(By.cssSelector(UIMapMyLowes.lnkBuilding)).click();
		    Thread.sleep(5000); 
		    }
		    catch(Exception WebDriverException){
		    driver.findElement(By.linkText("No, thanks")).click();
		    report.updateTestLog("Survey Popup","Handled", Status.DONE);
		    driver.findElement(By.cssSelector(UIMapMyLowes.lnkBuilding)).click();
		    }		    
	    Thread.sleep(5000); 
	    try{
	    //driver.findElement(By.linkText("Elegant Wall Shelf")).click();
	    driver.findElement(By.xpath(UIMapMyLowes.lnkNPCArticleName)).click();
	    Thread.sleep(5000); 
	    }
	    catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
           // driver.findElement(By.linkText("Elegant Wall Shelf")).click();
            driver.findElement(By.xpath(UIMapMyLowes.lnkNPCArticleName)).click();
        }
		Thread.sleep(5000);
	    driver.findElement(By.id(UIMapMyLowes.btnAddPrj)).click();
	    Thread.sleep(5000);
	    boolean verPopUpBoxPresent=selenium.isElementPresent(UIMapFunctionalComponents.webElmntLoginPopup);
		System.out.println("PopUp Window identified is :"+verPopUpBoxPresent);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		boolean verFramePresent=driver.findElement(By.id(UIMapFunctionalComponents.webElmntLoginFrame)).isDisplayed();
		System.out.println("Verifying the Presence of frame id:"+verFramePresent);
		driver.switchTo().frame(driver.findElement(By.id(UIMapFunctionalComponents.webElmntLoginFrame)));
		if((driver.findElement(By.id(UIMapFunctionalComponents.txtUserName)).isDisplayed())&& (driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).isDisplayed()) &&
				(driver.findElement(By.id(UIMapMyLowes.btnSignIn)).isDisplayed()))
		{
			report.updateTestLog("Verification of Sign In pop up", "Sign in Page is displayed properly ", Status.PASS);
		}else{
			report.updateTestLog("Verification of Sign In pop up", "Sign in Page is not displayed properly ", Status.FAIL);
		}
	}
	/**
	 *  This verifyDropDownWhileSavingToLists() method is used to verify whether the drop down while saving to lists
	 * 
	 */
	public void verifyDropDownWhileSavingToLists() throws Exception {
		
		saveItemsToListsFromPDPage();
		saveItemsToListsFromNPCProductsPage();
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.xpath(UIMapMyLowes.mouseHvrHeaderBlock)); 
	    actions.moveToElement(menuHoverLink).build().perform(); 
	    System.out.println("Mouse Hover successful"); 
	    try{
	    	driver.findElement(By.linkText(UIMapMyLowes.lnkKtchnAndDng)).click();
		    Thread.sleep(5000); 
		    }
		    catch(Exception WebDriverException){
	            driver.findElement(By.linkText("No, thanks")).click();
	            report.updateTestLog("Survey Popup","Handled", Status.DONE);
	            driver.findElement(By.linkText(UIMapMyLowes.lnkKtchnAndDng)).click();
	        }
		 try{
			 driver.findElement(By.cssSelector(UIMapMyLowes.lnkBuilding)).click();
		    Thread.sleep(5000); 
		    }
		    catch(Exception WebDriverException){
		    driver.findElement(By.linkText("No, thanks")).click();
		    report.updateTestLog("Survey Popup","Handled", Status.DONE);
		    driver.findElement(By.cssSelector(UIMapMyLowes.lnkBuilding)).click();
		    }		    
	    Thread.sleep(5000);	   
	   // String itemFromPCPage =   driver.findElement(By.linkText("Elegant Wall Shelf")).getText();	
	    String itemFromPCPage =   driver.findElement(By.xpath(UIMapMyLowes.lnkNPCArticleName)).getText();
	    try{
		    //driver.findElement(By.linkText("Elegant Wall Shelf")).click();
	    	driver.findElement(By.xpath(UIMapMyLowes.lnkNPCArticleName)).click();
		    Thread.sleep(5000); 
		    }
		    catch(Exception WebDriverException){
	            driver.findElement(By.linkText("No, thanks")).click();
	            report.updateTestLog("Survey Popup","Handled", Status.DONE);
	           // driver.findElement(By.linkText("Elegant Wall Shelf")).click();
	            driver.findElement(By.xpath(UIMapMyLowes.lnkNPCArticleName)).click();
	        }
			Thread.sleep(5000);
	    driver.findElement(By.id(UIMapMyLowes.btnAddPrj)).click();
	    driver.findElement(By.xpath(UIMapMyLowes.btnAddPrjA)).click();
	    driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
	    System.out.println("itemFromPCPage"+itemFromPCPage);
	    String itemInLists = driver.findElement(By.xpath(UIMapMyLowes.txtItemInListsPage)).getText();	
		if(itemInLists.equals(itemFromPCPage)){
			report.updateTestLog("Verification of item in List page from PC Page","Verification is successful", Status.PASS);
        }
        else{
        	report.updateTestLog("Verification of item in List page from PC Page","Verification is not successful", Status.FAIL);
		}
		
		deleteFromLists();
	
	}
	/**
	 *  This saveItemsToListsFromNPCProductsPage() method is used to provide the title of the entry.
	 * 
	 */
	public void saveItemsToListsFromNPCProductsPage() throws Exception {
		
		//fc.verifyingRegisteredUserLogin();
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.xpath(UIMapMyLowes.mouseHvrHeaderBlock)); 
	    actions.moveToElement(menuHoverLink).build().perform(); 
	    System.out.println("Mouse Hover successful"); 
	    try{
	    	driver.findElement(By.linkText(UIMapMyLowes.lnkKtchnAndDng)).click();
		    Thread.sleep(5000); 
		    }
		    catch(Exception WebDriverException){
	            driver.findElement(By.linkText("No, thanks")).click();
	            report.updateTestLog("Survey Popup","Handled", Status.DONE);
	            driver.findElement(By.linkText(UIMapMyLowes.lnkKtchnAndDng)).click();
	        }
		 try{
			 driver.findElement(By.cssSelector(UIMapMyLowes.lnkBuilding)).click();
		    Thread.sleep(5000); 
		    }
		    catch(Exception WebDriverException){
		    driver.findElement(By.linkText("No, thanks")).click();
		    report.updateTestLog("Survey Popup","Handled", Status.DONE);
		    driver.findElement(By.cssSelector(UIMapMyLowes.lnkBuilding)).click();
		    }		    
	    Thread.sleep(5000);	   
	  //  String itemFromPCPage =   driver.findElement(By.linkText("Elegant Wall Shelf")).getText();	
	    String itemFromPCPage =   driver.findElement(By.xpath(UIMapMyLowes.lnkNPCArticleName)).getText();	
	    try{
		   // driver.findElement(By.linkText("Elegant Wall Shelf")).click();
	    	driver.findElement(By.xpath(UIMapMyLowes.lnkNPCArticleName)).click();
		    Thread.sleep(5000); 
		    }
		    catch(Exception WebDriverException){
	            driver.findElement(By.linkText("No, thanks")).click();
	            report.updateTestLog("Survey Popup","Handled", Status.DONE);
	          //  driver.findElement(By.linkText("Elegant Wall Shelf")).click();
	            driver.findElement(By.xpath(UIMapMyLowes.lnkNPCArticleName)).click();
	        }
			Thread.sleep(5000);
	    driver.findElement(By.id(UIMapMyLowes.btnAddPrj)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnAddPrjA)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
	    System.out.println("itemFromPCPage"+itemFromPCPage);
	    String itemInLists = driver.findElement(By.xpath(UIMapMyLowes.txtItemInListsPage)).getText();	
		if(itemInLists.equals(itemFromPCPage)){
			report.updateTestLog("Verification of item in List page from PC Page","Verification is successful", Status.PASS);
        }
        else{
        	report.updateTestLog("Verification of item in List page from PC Page","Verification is not successful", Status.FAIL);
		}
		
		deleteFromLists();
	}
	/**
	 *  This closeTheReminderWithoutSaving() method is used to set up the reminder and close it without saving it.
	 * 
	 */
	public void closeTheReminderWithoutSaving() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
		fc.changeStore();
		Thread.sleep(5000);
		searchAnItemAndAddtoLists();
		driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
		 Thread.sleep(5000); 
		driver.findElement(By.cssSelector(UIMapMyLowes.btnSetRmndr)).click();
		 Thread.sleep(5000); 
	    driver.findElement(By.id(UIMapMyLowes.txtRmndrStrtDt)).click();
	    Thread.sleep(5000); 
	    driver.findElement(By.id(UIMapMyLowes.txtRmndrStrtDt)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtRmndrStrtDt)).sendKeys(dataTable.getData("General_Data","ReminderDate"));
	    Thread.sleep(5000); 
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnCloseRmndr)).click();
	    Thread.sleep(5000); 
		driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
		 Thread.sleep(5000); 
	    deleteFromLists();
		
	}
	/**
	 *  This verifyGreenTickWhileSavinfNPC() method is used to save the NPC item to lists
	 * 
	 */
	public void verifyGreenTickWhileSavinfNPC() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
		fc.changeStore();
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.xpath(UIMapMyLowes.mouseHvrHeaderBlock)); 
	    actions.moveToElement(menuHoverLink).build().perform(); 
	    System.out.println("Mouse Hover successful"); 
	    try{
	    	driver.findElement(By.linkText(UIMapMyLowes.lnkKtchnAndDng)).click();
	    	Thread.sleep(5000); 
		 }
		catch(Exception WebDriverException){
	            driver.findElement(By.linkText("No, thanks")).click();
	            report.updateTestLog("Survey Popup","Handled", Status.DONE);
	            driver.findElement(By.linkText(UIMapMyLowes.lnkKtchnAndDng)).click();
	        }
		 try{
			 driver.findElement(By.cssSelector(UIMapMyLowes.lnkBuilding)).click();
		     Thread.sleep(5000); 
		    }
		 catch(Exception WebDriverException){
		    driver.findElement(By.linkText("No, thanks")).click();
		    report.updateTestLog("Survey Popup","Handled", Status.DONE);
		    driver.findElement(By.cssSelector(UIMapMyLowes.lnkBuilding)).click();
		 }		    
	     Thread.sleep(5000);	   
	     try{
		    //driver.findElement(By.linkText("Elegant Wall Shelf")).click();
	    	 driver.findElement(By.xpath(UIMapMyLowes.lnkNPCArticleName)).click();
		    Thread.sleep(5000); 
		    }
		 catch(Exception WebDriverException){
	        driver.findElement(By.linkText("No, thanks")).click();
	        report.updateTestLog("Survey Popup","Handled", Status.DONE);
	      //  driver.findElement(By.linkText("Elegant Wall Shelf")).click();
	        driver.findElement(By.xpath(UIMapMyLowes.lnkNPCArticleName)).click();
	      }
		Thread.sleep(5000);
	  
	    driver.findElement(By.id(UIMapMyLowes.btnAddPrj)).click();
	    //driver.findElement(By.xpath("//*[@id='project-add-button']/a")).click();
	    //driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
	    
		if(driver.findElement(By.xpath(UIMapMyLowes.btnAddPrjGreenTick)).isDisplayed()){
			report.updateTestLog("Verification of Green tick mark beside saved items from NPC Page","Verification is successful", Status.PASS);
        }
        else{
        	report.updateTestLog("Verification of Green tick mark beside saved items from NPC Page","Verification is not successful", Status.FAIL);
		}
		//deleteFromLists();
	}	
	/**
	 *  This verifyAllItemsFromListsPage() method is used to verify All Items from Lists Page
	 * 
	 */
	public void verifyAllItemsFromListsPage() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
		fc.changeStore();
		Thread.sleep(5000);
		searchAnItemAndAddtoLists();
		driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
		Thread.sleep(2000);
		driver.findElement(By.id(UIMapMyLowes.btnShowAllItems)).click();
		Thread.sleep(2000);
		//deleteFromLists();
	}
	/**
	 *  This verifyAllItemsFromListsPage() method is used to verify All Items from Lists Page
	 * 
	 */
	public void verifyDefaultListBehaviour() throws Exception {
		
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
		fc.changeStore();
		Thread.sleep(5000);
		//mouseHoverToListsFromYourAccount();
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
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkListsFromMyLowes)).click();
	    Thread.sleep(5000);
		driver.findElement(By.cssSelector(UIMapMyLowes.btnAddList)).click();
		driver.findElement(By.id(UIMapMyLowes.txtAddList)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtAddList)).sendKeys(dataTable.getData("General_Data","newListName"));
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveList)).click();
		Thread.sleep(5000);
		if(driver.findElement(By.xpath(UIMapMyLowes.txtNewList)).getText().equals(dataTable.getData("General_Data","newListName"))){
			report.updateTestLog("Verifying newly created list in Lists page","New List creation is successful", Status.PASS);
		}
		else{
			try{
				driver.findElement(By.partialLinkText(dataTable.getData("General_Data","newListName"))).click();
				selenium.waitForPageToLoad("10000");
				driver.findElement(By.partialLinkText("Delete List")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(UIMapMyLowes.btnDeleteListConfirm)).click();
				selenium.waitForPageToLoad("10000");
				driver.findElement(By.cssSelector(UIMapMyLowes.btnAddList)).click();
				driver.findElement(By.id(UIMapMyLowes.txtAddList)).clear();
				driver.findElement(By.id(UIMapMyLowes.txtAddList)).sendKeys(dataTable.getData("General_Data","newListName"));
				Thread.sleep(5000);
				driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveList)).click();
				Thread.sleep(5000);
			}
			catch(Exception e)
			{
				System.out.println("No Duplicate List error");
				report.updateTestLog("Verifying newly created list in Lists page","New List creation is not successful", Status.FAIL);
			}
			
		}
		driver.findElement(By.name(UIMapMyLowes.lnkDefaultList)).click();
		searchAnItemAndAddtoLists();
		driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
		Thread.sleep(5000);
		driver.findElement(By.name(UIMapMyLowes.lnkDefaultList)).click();
		
		//deleting added list
		driver.findElement(By.partialLinkText(dataTable.getData("General_Data","newListName"))).click();
		selenium.waitForPageToLoad("10000");
		driver.findElement(By.partialLinkText("Delete List")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.btnDeleteListConfirm)).click();
		Thread.sleep(5000);
		selenium.waitForPageToLoad("10000");
		
	}
	/**
	 *  This saveImageFromHouzzGallery() method is used add the image to lists
	 * 
	 */
	public void saveImageFromHouzzGallery() throws Exception {
		
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.xpath("//*[@id='header-block']/div[3]/ul/li[3]/a/span[1]")); 
	    actions.moveToElement(menuHoverLink).build().perform(); 
	    System.out.println("Mouse Hover successful"); 
		driver.findElement(By.linkText(UIMapMyLowes.lnkKtchnAndDng)).click();
		driver.findElement(By.linkText(UIMapMyLowes.lnkHouzzGallery)).click();
		//driver.findElement(By.cssSelector(UIMapMyLowes.lnkTrmbleHouse)).click();
		driver.findElement(By.xpath(UIMapMyLowes.webElmntHouzzGallImg)).click();
		selenium.waitForPageToLoad("10000");
		driver.findElement(By.id(UIMapMyLowes.btnSavePhoto)).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText(UIMapMyLowes.lnkGoToLists)).click();
		selenium.waitForPageToLoad("10000");
		driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
		deleteFromLists();
	}
	/**
	 *  This verifyLocationOfItemsInLists() method is used to verify the location of the items in the lists
	 * 
	 */
	public void verifyLocationOfItemsInLists() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
		fc.changeStore();
		Thread.sleep(5000);
		searchAnItemAndAddtoLists();
		driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapMyLowes.lnkEdit)).click();
		Thread.sleep(5000);
		String locationOfItem = driver.findElement(By.xpath(UIMapMyLowes.txtLocOfItem)).getText();
		System.out.println("location of the item"+locationOfItem);
		if(locationOfItem.equals(driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).getText())){
			report.updateTestLog("Veriyfing the location of the item in Lists page in Saved Items", "Verification is successful", Status.PASS);
		}
		else{
			report.updateTestLog("Veriyfing the location of the item in Lists page in Saved Items", "Verification is not successful", Status.FAIL);
		}
		driver.findElement(By.cssSelector(UIMapMyLowes.lnkSavedItems)).click();
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapMyLowes.btnShowAllItems)).click();
		Thread.sleep(5000);
		if(locationOfItem.equals(driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).getText())){
			report.updateTestLog("Veriyfing the location of the item in Lists page in All Items", "Verification is successful", Status.PASS);
		}
		else{
			report.updateTestLog("Veriyfing the location of the item in Lists page In All Items", "Verification is not successful", Status.FAIL);
		}		
		driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveItemsNextIcon)).click();
	}
	/**
	 *  This verifyStorageLimitWhileCopying() method is verify the storage limit of the file while copying
	 * 
	 */
	public void verifyStorageLimitWhileCopying() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
		fc.changeStore();
		Thread.sleep(5000);
		searchAnItemAndAddtoLists();
		driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
		Thread.sleep(5000);
		driver.findElement(By.name(UIMapMyLowes.chkBoxBatchChk)).click();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnSelectmMenu)).click();
		driver.findElement(By.linkText(UIMapMyLowes.lnkMove)).click();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnMoveItem)).click();
		//verify the error message
	}
	
	/**
	 *  This verifyActionbarItems() method is to verify the actions present in the lists page
	 * 
	 */
	public void verifyActionbarItems() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
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
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkListsFromMyLowes)).click();
	    //verify the action bar items
	    if(driver.findElement(By.xpath(UIMapMyLowes.webElmntPresentActionBarItem1)).isDisplayed() &&
	    		driver.findElement(By.xpath(UIMapMyLowes.webElmntPresentActionBarItem2)).isDisplayed() &&
	    		driver.findElement(By.xpath(UIMapMyLowes.webElmntPresentActionBarItem3)).isDisplayed() &&
	    		driver.findElement(By.xpath(UIMapMyLowes.webElmntPresentActionBarItem4)).isDisplayed()  &&
	    		driver.findElement(By.xpath(UIMapMyLowes.webElmntPresentActionBarItem5)).isDisplayed()){
	    	
	    	report.updateTestLog("Verification of action bars in the list page", "Verification is successful", Status.PASS);
	    }
	    else{
	    	report.updateTestLog("Verification of action bars in the list page", "Verification is not successful", Status.FAIL);
	    }
		
	}	
	/**
	 *  This verifyCurrentUsageWhileUpload() method is to verify the actions present in the lists page
	 * 
	 */
	public void verifyCurrentUsageWhileUpload() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
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
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkListsFromMyLowes)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnUploadFile)).click();
	    driver.findElement(By.xpath(UIMapMyLowes.btnUploadFileInput)).sendKeys("D:\\Selenium Automation Naming Convention.docx");
	}
	/**
	 *  This verifyUndoDelete() method is to verify the actions present in the lists page
	 * 
	 */
	public void verifyUndoDelete() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
		fc.changeStore();
		Thread.sleep(5000);	
		searchAnItemAndAddtoLists();
		driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
		Thread.sleep(5000);	
		driver.findElement(By.cssSelector(UIMapMyLowes.lnkDelItm)).click();
		Thread.sleep(5000);	
	    driver.findElement(By.linkText(UIMapMyLowes.lnkUndo)).click();
	    Thread.sleep(5000);	
	    driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
	    Thread.sleep(5000);	
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkDelItm)).click();
	    Thread.sleep(5000);	
	    driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
	    Thread.sleep(5000);	
	    searchAnItemAndAddtoLists();
	    Thread.sleep(5000);	
	    driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
	    Thread.sleep(5000);	
	    driver.findElement(By.name(UIMapMyLowes.chkBoxBatchChk)).click();
	    Thread.sleep(5000);	
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnSelectmMenu)).click();
	    Thread.sleep(5000);	
	    driver.findElement(By.id(UIMapMyLowes.lnkBatchDelete)).click();
	    Thread.sleep(5000);	
	    driver.findElement(By.linkText(UIMapMyLowes.lnkUndo)).click();
	    Thread.sleep(5000);	
	    driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
	    Thread.sleep(5000);	
	}
	 /**
	  * This searchAnItemAndAddtoLists() method is used to search an item and add the item to lists
	  * 
	  */
	public void searchAnItemAndAddtoLists() throws Exception {
		
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","ItemNbr"));
		try{
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
			Thread.sleep(5000);
		}
        catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);}
        Thread.sleep(10000);
		report.updateTestLog("Searching For an Item","Searching Item Number - "+dataTable.getData("General_Data","ItemNbr")+"" ,Status.DONE);
													  
		try{
			//Adding the element to the list after finding the element
			driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveItem)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveItem)).click();
		}
		Thread.sleep(3000);
		try{
			//Adding the element to the list after finding the element
			driver.findElement(By.cssSelector(UIMapMyLowes.lnkSaveToLists)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.cssSelector(UIMapMyLowes.lnkSaveToLists)).click();
		}
		
		//driver.findElement(By.cssSelector("a.folders-and-lists > span.text")).click();
		Thread.sleep(10000);
		//mouseHoverToListsFromYourAccount();
		try{
			driver.findElement(By.linkText(UIMapMyLowes.lnkGoToLists)).click();
			Thread.sleep(5000);
		}
		 catch(Exception WebDriverException){
	            driver.findElement(By.linkText("No, thanks")).click();
	            report.updateTestLog("Survey Popup","Handled", Status.DONE);
	            driver.findElement(By.linkText(UIMapMyLowes.lnkGoToLists)).click();
		 }
		Thread.sleep(2000);
		}
	
	/**
	 *  This verifyNewListItemsAfterUserLoginsInNextTime() method is used to give a new name to the new list
	 * 
	 */
	public void verifyNewListItemsAfterUserLoginsInNextTime() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
		fc.changeStore();
		Thread.sleep(5000);
		//mouseHoverToListsFromYourAccount();
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
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkListsFromMyLowes)).click();
	    Thread.sleep(5000);
		driver.findElement(By.cssSelector(UIMapMyLowes.btnAddList)).click();
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapMyLowes.txtAddList)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtAddList)).sendKeys(dataTable.getData("General_Data","newListName"));
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveList)).click();
		Thread.sleep(5000);
		if(driver.findElement(By.xpath(UIMapMyLowes.txtNewList)).getText().equals(dataTable.getData("General_Data","newListName"))){
			report.updateTestLog("Verifying newly created list in Lists page","New List creation is successful", Status.PASS);
		}
		else{
			report.updateTestLog("Verifying newly created list in Lists page","New List creation is not successful", Status.FAIL);
		}
		searchAnItemAndAddtoLists();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(UIMapMyLowes.btnEditSpan)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.btnItemListSpan)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.btnEditItemBins)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.btnItemListDiv)).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveEditedNotes)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.btnNavPort)).click();
		Thread.sleep(5000);
		fc.signOut();
		fc.openLowesApplication();
		Thread.sleep(5000);
		fc.verifyingRegisteredUserLogin();
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
		driver.findElement(By.cssSelector(UIMapMyLowes.lnkListsFromMyLowes)).click();
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapMyLowes.btnShowAllItems)).click();
		Thread.sleep(5000);
		/*
		driver.findElement(By.xpath(UIMapMyLowes.btnNavPort)).click();
		Thread.sleep(5000);
		deleteFromLists();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapMyLowes.lnkDelList)).click();
		Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnDelList)).click();
	    Thread.sleep(5000);*/
		
		//deleting added list
				driver.findElement(By.partialLinkText(dataTable.getData("General_Data","newListName"))).click();
				selenium.waitForPageToLoad("10000");
				driver.findElement(By.partialLinkText("Delete List")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(UIMapMyLowes.btnDeleteListConfirm)).click();
				Thread.sleep(5000);
				selenium.waitForPageToLoad("10000");
		
	}
	/**
	 *  This validateTheReminderIcon() method is used to set up the reminder and and validating it
	 * 
	 */
	public void validateTheReminderIcon() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
		fc.changeStore();
		Thread.sleep(5000);
		searchAnItemAndAddtoLists();
		try{
		driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
		Thread.sleep(3000);
		}
		catch(Exception WebDriverException){
			 driver.findElement(By.linkText("No, thanks")).click();
			 report.updateTestLog("Survey Popup","Handled", Status.DONE);
			 driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
				Thread.sleep(3000);
				}
		try{
		 driver.findElement(By.cssSelector(UIMapMyLowes.btnSetRmndr)).click();
		 Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
		 driver.findElement(By.linkText("No, thanks")).click();
		 report.updateTestLog("Survey Popup","Handled", Status.DONE);
		 driver.findElement(By.cssSelector(UIMapMyLowes.btnSetRmndr)).click();
		}
		Thread.sleep(5000);	
		try{
			driver.findElement(By.id(UIMapMyLowes.txtRmndrStrtDt)).click();
			Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
		   driver.findElement(By.linkText("No, thanks")).click();
		   report.updateTestLog("Survey Popup","Handled", Status.DONE);
		   driver.findElement(By.id(UIMapMyLowes.txtRmndrStrtDt)).click();
		}
		Thread.sleep(3000);
	    driver.findElement(By.id(UIMapMyLowes.txtRmndrStrtDt)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtRmndrStrtDt)).sendKeys(dataTable.getData("General_Data","ReminderDate"));
	    Thread.sleep(3000);
	    try{
	    	 driver.findElement(By.cssSelector(UIMapMyLowes.btnCloseRmndr)).click();
		    Thread.sleep(5000);
		    }
		catch(Exception WebDriverException){
	         driver.findElement(By.linkText("No, thanks")).click();
	         report.updateTestLog("Survey Popup","Handled", Status.DONE);
	         driver.findElement(By.cssSelector(UIMapMyLowes.btnCloseRmndr)).click();
	       }
	    Thread.sleep(5000);
	    try{
	        driver.findElement(By.cssSelector(UIMapMyLowes.btnSetRmndr)).click();
		    Thread.sleep(5000);
		    }
		catch(Exception WebDriverException){
	         driver.findElement(By.linkText("No, thanks")).click();
	         report.updateTestLog("Survey Popup","Handled", Status.DONE);
	         driver.findElement(By.cssSelector(UIMapMyLowes.btnSetRmndr)).click();
	       }
		Thread.sleep(5000);
		try{
		   driver.findElement(By.id(UIMapMyLowes.txtRmndrStrtDt)).click();
		   Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
		   driver.findElement(By.linkText("No, thanks")).click();
		   report.updateTestLog("Survey Popup","Handled", Status.DONE);
		   driver.findElement(By.id(UIMapMyLowes.txtRmndrStrtDt)).click();
		}
		Thread.sleep(3000);
	    driver.findElement(By.id(UIMapMyLowes.txtRmndrStrtDt)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtRmndrStrtDt)).sendKeys(dataTable.getData("General_Data","EmptyReminderDate"));
	    try{
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveRmndr)).click();
	    Thread.sleep(5000);
	    }
	    catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveRmndr)).click();
            }
	    Thread.sleep(5000);
	    if(driver.findElement(By.xpath(UIMapMyLowes.webElmntPresentSetARmndr)).getText().equals("Please enter a start date for your Reminder")){
	    	report.updateTestLog("Verifying the date field in reminder","Date field is empty.Please enter a valid date", Status.PASS);
	    }
	    else{
	    	report.updateTestLog("Verifying the date field in reminder","Date field is not empty", Status.FAIL);
	    }
		driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
		Thread.sleep(5000);
	    deleteFromLists();
		
	}	 
	
	/**
	  * This verifyPurchaseDate() method is used verify the purchase date from purchase detail page, history page and lists page
	  * 
	  */
	public void verifyPurchaseDate() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
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
	    new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseType))).selectByVisibleText("Online");
	    Thread.sleep(3000);
		new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate))).selectByVisibleText("All");
		Thread.sleep(3000);
		driver.findElement(By.linkText(UIMapMyLowes.lnkItemView)).click();
		Thread.sleep(5000);
		String dateFromPurchaseHistoryPage =driver.findElement(By.xpath(UIMapMyLowes.txtDtFrmPHP)).getText();
		System.out.println("dateFromPurchaseHistoryPage is **"+dateFromPurchaseHistoryPage);
		
		
		driver.findElement(By.linkText(UIMapMyLowes.lnkPurDtls)).click();
		Thread.sleep(5000);
	    String dateFromPurchaseDetailPage= driver.findElement(By.xpath(UIMapMyLowes.txtDtFrmPDP)).getText();
	    System.out.println("dateFromPurchaseDetailPage is **"+dateFromPurchaseDetailPage);
		
	    driver.findElement(By.xpath(UIMapMyLowes.btnOrderDtlPg)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkSaveToLists)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkListsFromMyLowes)).click();
	    Thread.sleep(5000);
	   
	    String dateFromListsPage = driver.findElement(By.xpath(UIMapMyLowes.txtDtFromListsPg)).getText();
	    System.out.println("dateFromListsPage is **"+dateFromListsPage);
	    
	    compareDatedFromListsPageToPurchasesPage(dateFromPurchaseHistoryPage,dateFromPurchaseDetailPage,dateFromListsPage);
	   
		 }
	private void compareDatedFromListsPageToPurchasesPage(String dateFromPurchaseHistoryPage,String dateFromPurchaseDetailPage, String dateFromListsPage) throws ParseException {
		
  		String subStringDateFromListsPage = dateFromListsPage.substring(10, 22);
        System.out.println(subStringDateFromListsPage);
        DateFormat originalFormatDateFromPurchaseHistoryPage = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);
		DateFormat targetFormatDateFromListsPage = new SimpleDateFormat("MMM dd, yyyy");
		Date date = originalFormatDateFromPurchaseHistoryPage.parse(dateFromPurchaseHistoryPage);
		String formattedDateFromPurchaseHistoryPage = targetFormatDateFromListsPage.format(date);
		System.out.println("formattedDatesubStringdateFromListsPage is"+formattedDateFromPurchaseHistoryPage);
		
		if(formattedDateFromPurchaseHistoryPage.equals(subStringDateFromListsPage)){
			report.updateTestLog("Validating Dates from Lists page and Purchase History Page", "Verification is Successful", Status.PASS);
		}
		else{
			report.updateTestLog("Validating Dates from Lists page and Purchase History Page", "Verification is not Successful", Status.PASS);
		}
				
		DateFormat originalFormatDateFromPurchaseDetailPage = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
		Date date2 = originalFormatDateFromPurchaseDetailPage.parse(dateFromPurchaseDetailPage);
		String formattedDateFromPurchaseDetailPage = targetFormatDateFromListsPage.format(date2);
		System.out.println("formattedDatesubStringdateFromListsPage is"+formattedDateFromPurchaseDetailPage);

		if(formattedDateFromPurchaseDetailPage.equals(subStringDateFromListsPage)){
			report.updateTestLog("Validating Dates from Lists page and Purchase Detail Page", "Verification is Successful", Status.PASS);
		}
		else{
			report.updateTestLog("Validating Dates from Lists page and Purchase Detail Page", "Verification is not Successful", Status.PASS);
		}
}
	/**
	  * This verifySavedItemFromPurchases() method is used verify the saved items from purchase order
	  * 
	  */
	public void verifySavedItemFromPurchases() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
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
		try{driver.findElement(By.cssSelector(UIMapMyLowes.lnkPurchasesFromMyLowes)).click();
		selenium.waitForPageToLoad("20000");
		
		}
		catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.cssSelector(UIMapMyLowes.lnkPurchasesFromMyLowes)).click();
    		selenium.waitForPageToLoad("20000");
    		
    		}
	    new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseType))).selectByVisibleText("Online");
	    Thread.sleep(3000);
		new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate))).selectByVisibleText("All");
		Thread.sleep(3000);
		driver.findElement(By.linkText(UIMapMyLowes.lnkItemView)).click();
		Thread.sleep(5000);
		//String itemInPurchasePage = driver.findElement(By.xpath(UIMapMyLowes.txtItemInPurPg)).getText();
		
		driver.findElement(By.linkText(UIMapMyLowes.lnkPurDtls)).click();
		Thread.sleep(5000);
	    	
	    driver.findElement(By.xpath(UIMapMyLowes.btnOrderDtlPg)).click();
	    Thread.sleep(5000);
	    String itemInPurchasePage=null;
	    try{ itemInPurchasePage = driver.findElement(By.xpath(UIMapMyLowes.webElmntOrderItemName)).getText();}
		catch(Exception e)
		{
			itemInPurchasePage = driver.findElement(By.xpath(UIMapMyLowes.webElmntOrderItemName2)).getText();
			
		}
	    String itemInPurchasePageTrimmed=null;
	    if(itemInPurchasePage.length()>40)
	    	itemInPurchasePageTrimmed=itemInPurchasePage.substring(0, 40);
	    else
	    	itemInPurchasePageTrimmed=itemInPurchasePage;
	    
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkSaveToLists)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnOrderDtlPg)).click();
	    Thread.sleep(5000);
	    
		if(driver.findElement(By.xpath(UIMapMyLowes.webElmntGreenTickMark)).isDisplayed()){
			report.updateTestLog("Verification of Green tick mark beside lists in saved items from purchases Page","Verification is successful", Status.PASS);
        }
        else{
        	report.updateTestLog("Verification of Green tick mark beside lists in saved items from purchases Page","Verification is not successful", Status.FAIL);
		}
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkListsFromMyLowes)).click();
	    Thread.sleep(5000);	 
	    try{
	    driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
	    Thread.sleep(5000);
	    }
	    catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
    	    Thread.sleep(5000);
    	    }
	    String itemInLists = driver.findElement(By.xpath(UIMapMyLowes.txtItemInListsPage)).getText();	
	    String itemInListsTrimmed=null;
	    if(itemInLists.length()>40)
	    	itemInListsTrimmed=itemInLists.substring(0, 40);
	    else
	    	itemInListsTrimmed=itemInLists;
	    System.out.println(itemInListsTrimmed);
	    System.out.println(itemInPurchasePageTrimmed);
	    if(itemInListsTrimmed.equals(itemInPurchasePageTrimmed)){
			report.updateTestLog("Verification of item in List page from PD Page","Verification is successful", Status.PASS);
        }
        else{
        	report.updateTestLog("Verification of item in List page from PD Page","Verification is not successful", Status.FAIL);
		}
		
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnDelItem)).click();	       	  
	   
		 }
	
	/**
	 *  This verifyThumbnail() method is used to verify the thumbnail of the product
	 * 
	 */
	public void verifyThumbnail() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
		fc.changeStore();
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","ItemNbr"));
		try {
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
			Thread.sleep(5000);
		} catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		}
		Thread.sleep(5000);
		report.updateTestLog("Searching For an Item","Searching Item Number - "+dataTable.getData("General_Data","ItemNbr")+"" ,Status.DONE);
		selenium.waitForPageToLoad("30000");		
		
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
		//mouseHoverToListsFromYourAccount();
		driver.findElement(By.linkText(UIMapMyLowes.lnkGoToLists)).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
		Thread.sleep(3000);
		String itemInLists = driver.findElement(By.xpath(UIMapMyLowes.txtItemInListsPage)).getText();
		driver.findElement(By.xpath(UIMapMyLowes.lnkPDImg)).click();
		Thread.sleep(5000);
		String itemFromPDPage = driver.findElement(By.xpath(UIMapMyLowes.txtItemInPdPage)).getText();		
		if(itemInLists.equals(itemFromPDPage)){
			report.updateTestLog("Verification of item in List page from PD Page","Verification is successful", Status.PASS);
        }
        else{
        	report.updateTestLog("Verification of item in List page from PD Page","Verification is not successful", Status.FAIL);
		}
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
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkListsFromMyLowes)).click();
		deleteFromLists();	
	
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.xpath(UIMapMyLowes.mouseHvrHeaderBlock)); 
	    actions.moveToElement(menuHoverLink).build().perform(); 
	    System.out.println("Mouse Hover successful"); 
	    driver.findElement(By.linkText(UIMapMyLowes.lnkKtchnAndDng)).click();
	    Thread.sleep(5000); 
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkBuilding)).click();
	    Thread.sleep(5000); 
	    //String itemFromPCPage =  driver.findElement(By.linkText("Elegant Wall Shelf")).getText();
	    String itemFromPCPage =  driver.findElement(By.xpath(UIMapMyLowes.lnkNPCArticleName)).getText();
	    System.out.println("itemFromPCPage"+itemFromPCPage);
	   // driver.findElement(By.linkText("Elegant Wall Shelf")).click();
	    driver.findElement(By.xpath(UIMapMyLowes.lnkNPCArticleName)).click();
	    driver.findElement(By.id(UIMapMyLowes.btnAddPrj)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnAddPrjA)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
	    Thread.sleep(5000);
	    String npcItemInLists = driver.findElement(By.xpath(UIMapMyLowes.txtItemInListsPage)).getText();	
	    driver.findElement(By.xpath(UIMapMyLowes.lnkPDImg)).click();
	    Thread.sleep(3000);
	    
	   
		if(npcItemInLists.equals(itemFromPCPage)){
			report.updateTestLog("Verification of item in List page from PC Page","Verification is successful", Status.PASS);
	    }
	    else{
	    	report.updateTestLog("Verification of item in List page from PC Page","Verification is not successful", Status.FAIL);
		}
		driver.findElement(By.cssSelector(UIMapMyLowes.lnkMyLowes)).click();
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkListsFromMyLowes)).click();
		deleteFromLists();
	}
	

	/**
	 *  This verifyDropDownInListsPage() method is used to verify the drop downs in Lists Page
	 * 
	 */
	public void verifyDropDownInListsPage() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
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
			  driver.findElement(By.cssSelector(UIMapMyLowes.lnkListsFromMyLowes)).click();
		}
		catch(Exception WebDriverException){
            driver.findElement(By.linkText("No, thanks")).click();
            report.updateTestLog("Survey Popup","Handled", Status.DONE);
            driver.findElement(By.cssSelector(UIMapMyLowes.lnkListsFromMyLowes)).click();
            }
	  
	    Thread.sleep(5000);
	    if(driver.findElement(By.xpath(UIMapMyLowes.webElmntDpDwnInListsPage1)).isDisplayed() &&
	    		driver.findElement(By.xpath(UIMapMyLowes.webElmntDpDwnInListsPage1)).getText().equals("Show:")){
	    	
	    	driver.findElement(By.cssSelector(UIMapMyLowes.btnSpanSelection)).click();
	    	if(driver.findElement(By.xpath(UIMapMyLowes.webElmntDpDwnInListsPage2)).getText().equals("All Items") &&
	    			driver.findElement(By.xpath(UIMapMyLowes.webElmntDpDwnInListsPage3)).getText().equals("Products") &&
	    			driver.findElement(By.xpath(UIMapMyLowes.webElmntDpDwnInListsPage4)).getText().equals("Articles & Videos") &&
	    			driver.findElement(By.xpath(UIMapMyLowes.webElmntDpDwnInListsPage5)).getText().equals("Your Entries") &&
	    			driver.findElement(By.xpath(UIMapMyLowes.webElmntDpDwnInListsPage6)).getText().equals("Home Ideas Photos") &&
	    			driver.findElement(By.xpath(UIMapMyLowes.webElmntDpDwnInListsPage7)).getText().equals("Uploaded Files")){
	    		
	    		
	    		//driver.findElement(By.cssSelector("span.selection")).click();
			    driver.findElement(By.cssSelector(UIMapMyLowes.lnkTitleAllItems)).click();
			    driver.findElement(By.cssSelector(UIMapMyLowes.btnSpanSelection)).click();
			    driver.findElement(By.linkText(UIMapMyLowes.lnkProducts)).click();
			    driver.findElement(By.cssSelector(UIMapMyLowes.drpDownVariableB)).click();
			    driver.findElement(By.linkText(UIMapMyLowes.lnkArtAndVid)).click();
			    driver.findElement(By.cssSelector(UIMapMyLowes.drpDownVariableB)).click();
			    driver.findElement(By.linkText(UIMapMyLowes.lnkYourEntries)).click();
			    driver.findElement(By.cssSelector(UIMapMyLowes.drpDownVariableB)).click();
			    driver.findElement(By.linkText(UIMapMyLowes.lnkHmIdeaPhotos)).click();
			    driver.findElement(By.cssSelector(UIMapMyLowes.drpDownVariableB)).click();
			    driver.findElement(By.linkText(UIMapMyLowes.lnkUploadFiles)).click();
			    
			    report.updateTestLog("Verification of Show drop down in Lists page","Verification is successful", Status.PASS);
	    	}
	    	else{
	    		report.updateTestLog("Verification of Show drop down in Lists page","Verification is not successful", Status.FAIL);
	    	}	    	    			
	    }	        
	    if(driver.findElement(By.xpath(UIMapMyLowes.webElmntTxtFilterActionsSortBy)).isDisplayed() &&
	    		driver.findElement(By.xpath(UIMapMyLowes.webElmntTxtFilterActionsSortBy)).getText().equals("Sort by:")){
	    	driver.findElement(By.xpath(UIMapMyLowes.webElmntFilterActionsSortByMostRcnt)).click();
	    	
	    	
	    	System.out.println(driver.findElement(By.xpath(UIMapMyLowes.webElmntFilterActionsSortByMostRcnt2)).getText());
	    	System.out.println(driver.findElement(By.xpath(UIMapMyLowes.webElmntFilterActionsSortByAToZ)).getText());
	    	System.out.println(driver.findElement(By.xpath(UIMapMyLowes.webElmntFilterActionsSortByZToA)).getText());
	    	
	    	
	    	if(driver.findElement(By.xpath(UIMapMyLowes.webElmntFilterActionsSortByMostRcnt2)).getText().equals("Most Recent") &&
	    			driver.findElement(By.xpath(UIMapMyLowes.webElmntFilterActionsSortByAToZ)).getText().equals("A – Z") &&
	    			driver.findElement(By.xpath(UIMapMyLowes.webElmntFilterActionsSortByZToA)).getText().equals("Z – A")){
	    			    		
	    		//driver.findElement(By.xpath("//div[@id='sortBy']/a/span/b")).click();
		       // driver.findElement(By.linkText(UIMapMyLowes.lnkMstRcnt)).click();
	    		System.out.println("Clicking Most recent");
		        driver.findElement(By.xpath(UIMapMyLowes.webElmntFilterActionsSortByMostRcnt2)).click();
		        Thread.sleep(3000);
		        driver.findElement(By.xpath(UIMapMyLowes.webElmntFilterActionsSortByMostRcnt)).click();
		        System.out.println("Clicking A-Z");
		        driver.findElement(By.xpath(UIMapMyLowes.webElmntFilterActionsSortByAToZ)).click();
		        Thread.sleep(3000);
		        driver.findElement(By.xpath(UIMapMyLowes.webElmntFilterActionsSortByMostRcnt)).click();
		        System.out.println("Clicking Z-A");
		        driver.findElement(By.xpath(UIMapMyLowes.webElmntFilterActionsSortByZToA)).click();	
		        Thread.sleep(3000);
		        
		        report.updateTestLog("Verification of Sort By drop down in Lists page","Verification is successful", Status.PASS);
	    	}else{
	    		report.updateTestLog("Verification of Sort By drop down in Lists page","Verification is not successful", Status.FAIL);
	    	}
	        
	    }
	    
	}
	/**
	 *  This moveItemsFromListsUsingEdit() method is used to move items from lists to a new destination using Edit
	 * 
	 */
	public void moveItemsFromListsUsingEdit() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
		fc.changeStore();
		Thread.sleep(5000);
		searchAnItemAndAddtoLists();
		driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapMyLowes.lnkEdit)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.btnItemListSpan)).click();
		Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.editItemBin)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnEditItemsLabel)).click();
	    driver.findElement(By.xpath(UIMapMyLowes.editItemBin)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnItemListDiv)).click();
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveEditedNotes)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id(UIMapMyLowes.btnShowAllItems)).click();
	    Thread.sleep(5000);
		deleteFromLists();	
		
	}
	/**
	 *  This createNewListAndAddNote() method is used to give a new name to the new list and add a note
	 * 
	 */
	public void createNewListAndAddNote() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
		fc.changeStore();
		Thread.sleep(5000);
		//mouseHoverToListsFromYourAccount();
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
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkListsFromMyLowes)).click();
	    Thread.sleep(5000);
		driver.findElement(By.cssSelector(UIMapMyLowes.btnAddList)).click();
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapMyLowes.txtAddList)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtAddList)).sendKeys(dataTable.getData("General_Data","newListName"));
		driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveList)).click();
		Thread.sleep(5000);
		if(driver.findElement(By.xpath(UIMapMyLowes.txtNewList)).getText().equals(dataTable.getData("General_Data","newListName"))){
			report.updateTestLog("Verifying newly created list in Lists page","New List creation is successful", Status.PASS);
		}
		else{
			report.updateTestLog("Verifying newly created list in Lists page","New List creation is not successful", Status.FAIL);
		}
		driver.findElement(By.linkText(UIMapMyLowes.lnkAddANote)).click();
		Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.txtNewNote)).clear();
	    driver.findElement(By.cssSelector(UIMapMyLowes.txtNewNote)).sendKeys("test");
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkCancelSaveNote)).click();
		Thread.sleep(5000);
	    driver.findElement(By.linkText(UIMapMyLowes.lnkAddANote)).click();
		Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.txtNewNote)).clear();
	    driver.findElement(By.cssSelector(UIMapMyLowes.txtNewNote)).sendKeys("test");
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.lnkSaveNote)).click();
	    Thread.sleep(5000);
	    
		driver.findElement(By.linkText(UIMapMyLowes.lnkDelList)).click();
		Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnDelList)).click();
	    Thread.sleep(5000);
	    
	 
	}
	/**
	 *  This verifyLongNotes() method is used to add the long notes and verify more and hide buttons
	 * 
	 */
	public void verifyLongNotes() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
		fc.changeStore();
		Thread.sleep(5000);
		searchAnItemAndAddtoLists();
		driver.findElement(By.linkText(UIMapMyLowes.lnkSvdItms)).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapMyLowes.lnkEdit)).click();
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapMyLowes.txtEditItemNotes)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtEditItemNotes)).sendKeys(dataTable.getData("General_Data","Notes"));
		driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveEditedNotes)).click();	
		Thread.sleep(5000);
	    driver.findElement(By.linkText(UIMapMyLowes.lnkMore)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.linkText(UIMapMyLowes.lnkHide)).click();
	    Thread.sleep(5000);	
	    deleteFromLists();		
	}
	
	/**
	 *  This renameListName() method is used to give a new name to the new list
	 * 
	 */
	public void renameListName() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(8000);
		fc.changeStore();
		Thread.sleep(5000);
		//mouseHoverToListsFromYourAccount();
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
	    driver.findElement(By.cssSelector(UIMapMyLowes.lnkListsFromMyLowes)).click();
	    Thread.sleep(5000);
		driver.findElement(By.cssSelector(UIMapMyLowes.btnAddList)).click();
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapMyLowes.txtAddList)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtAddList)).sendKeys(dataTable.getData("General_Data","newListName"));
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(UIMapMyLowes.btnSaveList)).click();
		Thread.sleep(5000);
		if(driver.findElement(By.xpath(UIMapMyLowes.txtNewList)).getText().equals(dataTable.getData("General_Data","newListName"))){
			report.updateTestLog("Verifying newly created list in Lists page","New List creation is successful", Status.PASS);
		}
		else{
			report.updateTestLog("Verifying newly created list in Lists page","New List creation is not successful", Status.FAIL);
		}
		
		driver.findElement(By.linkText(UIMapMyLowes.lnkRenameList)).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(UIMapMyLowes.txtNewListNm)).clear();
		driver.findElement(By.cssSelector(UIMapMyLowes.txtNewListNm)).sendKeys(dataTable.getData("General_Data","newListNameupdated"));
		Thread.sleep(3000);
		driver.findElement(By.xpath(UIMapMyLowes.btnSaveEditedList)).click();
		Thread.sleep(5000);
		if(driver.findElement(By.xpath(UIMapMyLowes.txtNewList)).getText().equals(dataTable.getData("General_Data","newListNameupdated"))){
			report.updateTestLog("Verifying the change in title of the list","Title change is successful", Status.PASS);
		}
		else{
			report.updateTestLog("Verifying the change in title of the list","Title change is not successful", Status.FAIL);
		}
		driver.findElement(By.linkText(UIMapMyLowes.lnkDelList)).click();
		Thread.sleep(3000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnDelList)).click();	
	    Thread.sleep(5000);
		
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
		ClickCustomize("linkText", dataTable.getData("General_Data", "OrderNbr"));
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
        driver.findElement(By.id(UIMapMyLowes.txtZip)).clear();
        driver.findElement(By.id(UIMapMyLowes.txtZip)).sendKeys(dataTable.getData("General_Data","zipcode"));
        driver.findElement(By.id(UIMapMyLowes.btnCardRegSubmit)).click();
        
        selenium.waitForPageToLoad("20000");
	}
	
	/**Add Purchase**/
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
		cm.chkText(UIMapMyLowes.lblTransaction, "Transaction Number:");
		cm.chkText(UIMapMyLowes.lblPurchaseDt, "Purchase Date:");
		cm.chkText(UIMapMyLowes.lblStoreNbr, "Store Number:");
		chkElementDisplayed("id",UIMapMyLowes.txtTxnNo,"Transaction Number field");
		chkElementDisplayed("id",UIMapMyLowes.txtPurDate,"Purchase date field");
		chkElementDisplayed("id",UIMapMyLowes.txtStoreNo,"Store Number field");
		chkElementDisplayed("xpath",UIMapMyLowes.lnkTransactionHelp,"Transaction Number Help");
		chkElementDisplayed("xpath",UIMapMyLowes.lnkPurchaseDtHelp,"Purchase Date Help");
		chkElementDisplayed("xpath",UIMapMyLowes.lnkStoreNbrHelp,"Store Number Help");
		chkElementDisplayed("xpath",UIMapMyLowes.lnkPurchaseDtPicker,"Purchase Date Picker");
		ClickCustomize("xpath", UIMapMyLowes.lnkTransactionHelp);
		Thread.sleep(3000);
		int varCount=ps.countWebElement("html/body/div");
		System.out.println(varCount);
		chkElementDisplayed("xpath","//div["+varCount+"]","Transaction Number Help Popup");
		chkElementDisplayed("xpath","//div["+varCount+"]/div[2]/img","Image In Transaction Number Help Popup");
		chkElementDisplayed("xpath","//div["+varCount+"]/div[1]/a/span","Close In Transaction Number Help Popup");
		ClickCustomize("xpath", "//div["+varCount+"]/div[1]/a/span");
		Thread.sleep(1000);
		
		ClickCustomize("xpath", UIMapMyLowes.lnkPurchaseDtHelp);
		Thread.sleep(3000);
		varCount=ps.countWebElement("html/body/div");
		System.out.println(varCount);
		chkElementDisplayed("xpath","//div["+varCount+"]","Purchase date Help Popup");
		chkElementDisplayed("xpath","//div["+varCount+"]/div[2]/img","Image In Purchase date Help Popup");
		chkElementDisplayed("xpath","//div["+varCount+"]/div[1]/a/span","Close In Purchase date Help Popup");
		ClickCustomize("xpath", "//div["+varCount+"]/div[1]/a/span");
		Thread.sleep(1000);
		
		ClickCustomize("xpath", UIMapMyLowes.lnkPurchaseDtHelp);
		Thread.sleep(3000);
		varCount=ps.countWebElement("html/body/div");
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
		cm.chkText(UIMapMyLowes.lblTransaction, "Transaction Number:");
		cm.chkText(UIMapMyLowes.lblPurchaseDt, "Purchase Date:");
		cm.chkText(UIMapMyLowes.lblStoreNbr, "Store Number:");
		chkElementDisplayed("id",UIMapMyLowes.txtTxnNo,"Transaction Number field");
		chkElementDisplayed("id",UIMapMyLowes.txtPurDate,"Purchase date field");
		chkElementDisplayed("id",UIMapMyLowes.txtStoreNo,"Store Number field");
		
	}
	
	/**Checks MAP item in  product list**/
	public void checkMAPInPL() throws Exception
	{
		String varId=dataTable.getData("General_Data", "ItemId");
		
		cm.chkText("//*[@id='"+varId+"']/div/div[3]/p[1]/strong", "View Price in Cart");
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
		cm.chkText(UIMapMyLowes.lblViewPrcInCart, "View Price in Cart");
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
		cm.chkText(UIMapMyLowes.lblCurrentPriceLists, "View Price in Cart");
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
		cm.chkText(UIMapProductSearch.webElmntBrdCrumbsLvl4, "How do I add a past purchase to my purchase history?");
		
	}
	
	/**Checks whether FAQ-How do I add a past purchase to my purchase history? content is updated**/
	public void chkFAQAddingPastPurchsContent() throws Exception
	{
		ps2.checkTextContains(UIMapMyLowes.lblAddingInStorePurchsPara1, "From the Purchases section of your account, click the Add Purchase button.", "Adding In-Store Purchases");
		ps2.checkTextContains(UIMapMyLowes.lblAddingInStorePurchsPara2, "You'll then be asked to provide the transaction number", "Adding In-Store Purchases");
		ps2.checkTextContains(UIMapMyLowes.lblAddingInStorePurchsPara2, "Once you've entered that information, click the Add Purchase button.", "Adding In-Store Purchases");
		cm.chkText(UIMapMyLowes.lblFAQAddingPastPurchsHeading2, "Viewing Online / Mobile Purchases");
		ps2.checkTextContains(UIMapMyLowes.lblViewOlMobilePurchsPara1, "From the Purchases section of your account, click the Add Purchase button.", "Viewing Online / Mobile Purchases");
		ps2.checkTextContains(UIMapMyLowes.lblViewOlMobilePurchsPara2, "select the Online / Mobile option", "Viewing Online / Mobile Purchases");
		ps2.checkTextContains(UIMapMyLowes.lblViewOlMobilePurchsPara2, "Once you've entered that information, click the Add Purchase button.", "Viewing Online / Mobile Purchases");
		cm.chkText(UIMapMyLowes.lblFAQAddingPastPurchsHeading3, "Viewing In-Store Special Orders");
		
		
	}
	/**Checks mylowes card registration links**/
	public void chkMLCRegistrationAndRequestLinks() throws Exception
	{
		String varURL=driver.getCurrentUrl();
		ClickCustomize("linkText", "Request a MyLowe's Card");
		selenium.waitForPageToLoad("20000");
		ps.chkPagetitle("Request a MyLowe's Card");
		driver.get(varURL);
		selenium.waitForPageToLoad("20000");
		ClickCustomize("linkText", "Register your MyLowe's Card");
		selenium.waitForPageToLoad("20000");
		ps.chkPagetitle("Register a MyLowe's Card");
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
				int varCount=ps.countWebElement("html/body/div");
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
			cm.chkText(UIMapMyLowes.lblReminderSetItemView, "Reminder Set");
			
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
		String varURL;
		for(i=1;i<=varPgCount;i++)
		{
			try{ClickCustomize("linkText",dataTable.getData("General_Data", "OrderNbr"));
			selenium.waitForPageToLoad("20000");
			break;
			}
			
			catch(Exception e)
			{
				System.out.println("Not on Page:"+i);
				ClickCustomize("linkText", "Next");
				continue;
			}
			
		}
		if(i>varPgCount)
			report.updateTestLog("Finding Online Order Nbr", "Online Order not displayed in any page", Status.FAIL);
		
	}
	
	/**Checks Add To in Purchase Details for Online Purchase**/
	public void checkAddToOnlinePurchaseDetails() throws Exception
	{
		ClickCustomize("xpath", UIMapMyLowes.drpDownAddToOnlinePurchsDetails);
		Thread.sleep(1000);
		//adding to Home Profile
		ClickCustomize("xpath", UIMapMyLowes.lnkAddToHPPuchaseDetails+"/a/span[2]");
		Thread.sleep(5000);
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
			cm.chkText(UIMapMyLowes.lnkReminderPuchaseDetails+"/a/span", "Reminder Set");
			
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
	
	/**Checks Add To in Purchase Details for Online Purchase**/
	public void checkAddToInStorePurchaseDetails() throws Exception
	{
		ClickCustomize("xpath", UIMapMyLowes.drpDownAddToInStorePurchsDetails);
		Thread.sleep(1000);
		//adding to Home Profile
		ClickCustomize("xpath", UIMapMyLowes.lnkAddToHPPuchaseDetailsIS+"/a/span[2]");
		Thread.sleep(5000);
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
			cm.chkText(UIMapMyLowes.lnkReminderPuchaseDetailsIS+"/a/span", "Reminder Set");
				
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
		ps.chkPagetitle("Find Purchase");
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
				driver.navigate().refresh();
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

}


