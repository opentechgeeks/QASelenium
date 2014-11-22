package com.lowes.qa.selenium.components;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.cognizant.framework.Status;
import com.lowes.qa.selenium.support.DriverScript;
import com.lowes.qa.selenium.support.ReusableLibrary;
import com.lowes.qa.selenium.support.ScriptHelper;
import com.lowes.qa.selenium.uimap.UIMapFunctionalComponents;
import com.lowes.qa.selenium.uimap.UIMapMyLowes;
import com.lowes.qa.selenium.uimap.UIMapProductSearch;
import com.thoughtworks.selenium.Selenium;


/**
 * My Lowes Class
 * @author Infosys
 */
public class ProductSearch_SN extends ReusableLibrary
{
	/**
	 * Constructor to initialize the component library
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link DriverScript}
	 */
	
	String baseurl = dataTable.getData("General_Data", "URL");
	Selenium selenium = new WebDriverBackedSelenium(driver, baseurl);
	FunctionalComponents fc = new FunctionalComponents(scriptHelper);
	
	public ProductSearch_SN(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
	}
	
	/**
	 * This verifyingItemAddedToCartMsgSuccessfully() method is used to verify the successful message after item is added to cart.
	 * 
	 */
	public void verifyingItemAddedToCartMsgSuccessfullyAZ() throws Exception 
	{
			
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","ItemNbr"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		report.updateTestLog("Searching For an Item","Searching Item Number - "+dataTable.getData("General_Data","ItemNbr")+"" ,Status.DONE);
		boolean verItemPresent=selenium.isTextPresent("Item #: "+dataTable.getData("General_Data","ItemNbr"));
		if(verItemPresent)
		{
			report.updateTestLog("Verifying Navigating to Item's PDP Page","Item - " +dataTable.getData("General_Data","ItemNbr") +" is Present", Status.PASS);
		}
		else
		{
			report.updateTestLog("Veriyfing Navigating to Item's PDP Page","Item is NOT Present", Status.FAIL);
		}
		driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
		Thread.sleep(5000);
		if(driver.findElement(By.xpath(UIMapProductSearch.txtAddProductTitle)).getText().equals("Your item was successfully added to cart."))
		{
			report.updateTestLog("Verifying successful message while adding item added to cart","Verification is successful", Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying successful message while adding item added to cart","Verification is not successful", Status.FAIL);
		}
		
		if(driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntAddToCartPopUp1)).isDisplayed() &&
			driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntAddToCartPopUp2)).isDisplayed() &&
			driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntAddToCartPopUp3)).isDisplayed() &&
			driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntAddToCartPopUp4)).isDisplayed() &&
			driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntAddToCartPopUp5)).isDisplayed()){
			report.updateTestLog("Verification of name, price,quantity,continue shopping button and check button display in the nodal window","Verification is successful", Status.PASS);
		}else{
			report.updateTestLog("Verification of name, price,quantity,continue shopping button and check button display in the nodal window","Verification is not successful", Status.FAIL);
		}
		driver.findElement(By.xpath(UIMapProductSearch.lnkClseAddToCartPopUp)).click();
		Thread.sleep(5000);
		    
	}
	
	/**
	 * This verifyStoreLocatorDisambiguation() method is used to verify the disambiguation of the store display
	 * 
	 */
	public void verifyStoreLocatorDisambiguation() throws Exception
	
	{
		driver.findElement(By.id(UIMapFunctionalComponents.txtStoreZip)).clear();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtStoreZip)).sendKeys(dataTable.getData("General_Data","ZipCode"));
	    driver.findElement(By.id(UIMapMyLowes.btnFindAStore)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id(UIMapProductSearch.txtMapSearch)).clear();
	    driver.findElement(By.id(UIMapProductSearch.txtMapSearch)).sendKeys(dataTable.getData("General_Data","Map"));
	    if(driver.findElement(By.xpath(UIMapProductSearch.txtMapDisplay)).getText().equals("Did you mean:")){
	    	report.updateTestLog("Verifying disambiguation in store","Verification is successful", Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying disambiguation in store","Verification is not successful", Status.FAIL);
		}
	}
	
	/**
	 * This verifyStoreLocatorCanadaStores() method is used to verify the canada stores
	 * 
	 */
	public void verifyStoreLocatorCanadaStores() throws Exception
	
	{
		 driver.findElement(By.id(UIMapFunctionalComponents.txtStoreZip)).clear();
		    driver.findElement(By.id(UIMapFunctionalComponents.txtStoreZip)).sendKeys(dataTable.getData("General_Data","ZipCode"));
		    driver.findElement(By.id(UIMapMyLowes.btnFindAStore)).click();
		    Thread.sleep(5000);
		    driver.findElement(By.id(UIMapProductSearch.txtMapSearch)).clear();
		    driver.findElement(By.id(UIMapProductSearch.txtMapSearch)).sendKeys(dataTable.getData("General_Data","State"));
		    if(driver.findElement(By.xpath(UIMapProductSearch.txtMapDisplay)).getText().equals("Did you mean:")){
		    	report.updateTestLog("Verifying disambiguation in store","Verification is successful", Status.PASS);
			}
			else
			{
				report.updateTestLog("Verifying disambiguation in store","Verification is not successful", Status.FAIL);
			}
	}
	
	/**
	 * This verifyElementAutozip() method is used to verify the autozip
	 * 
	 */
	public void verifyElementAutozip() throws Exception
	
	{
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(5000);
	    if(driver.findElement(By.xpath(UIMapProductSearch.txtStoreDisplay)).getText().equals("Test Store Of Mooresville, NC")){
	    	report.updateTestLog("Verifying autozipping the store","Verification is successful", Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying autozipping the store","Verification is not successful", Status.FAIL);
		}
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
	 * This verifyHTML5DocTypeHomePage() method is used to verify the HTML5 doc type home page
	 * 
	 */
	public void verifyHTML5DocTypeHomePage() throws Exception
	
	{
		driver.findElement(By.id(UIMapFunctionalComponents.txtStoreZip)).clear();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtStoreZip)).sendKeys(dataTable.getData("General_Data","ZipCode"));
	    driver.findElement(By.id(UIMapMyLowes.btnFindAStore)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id(UIMapProductSearch.txtMapSearch)).clear();
	    driver.findElement(By.id(UIMapProductSearch.txtMapSearch)).sendKeys(dataTable.getData("General_Data","State"));
	    if(driver.findElement(By.xpath(UIMapProductSearch.txtMapDisplay)).getText().equals("Did you mean:")){
	    	report.updateTestLog("Verifying disambiguation in store","Verification is successful", Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying disambiguation in store","Verification is not successful", Status.FAIL);
		}
	}
	
	/**
	 * This verifyMiniCartDropDownCheckOutPages() method is used to verify the mini cart check out
	 * 
	 */
	public void verifyMiniCartDropDownCheckOutPages() throws Exception 
	{
		fc.verifyingRegisteredUserLogin();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","ItemNbr"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		report.updateTestLog("Searching For an Item","Searching Item Number - "+dataTable.getData("General_Data","ItemNbr")+"" ,Status.DONE);
		boolean verItemPresent=selenium.isTextPresent("Item #: "+dataTable.getData("General_Data","ItemNbr"));
		if(verItemPresent)
		{
			report.updateTestLog("Verifying Navigating to Item's PDP Page","Item - " +dataTable.getData("General_Data","ItemNbr") +" is Present", Status.PASS);
		}
		else
		{
			report.updateTestLog("Veriyfing Navigating to Item's PDP Page","Item is NOT Present", Status.FAIL);
		}
		driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
		Thread.sleep(5000);
		if(driver.findElement(By.xpath(UIMapProductSearch.txtAddProductTitle)).getText().equals("Your item was successfully added to cart."))
		{
			report.updateTestLog("Verifying successful message while adding item added to cart","Verification is successful", Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying successful message while adding item added to cart","Verification is not successful", Status.FAIL);
		}
		driver.findElement(By.xpath(UIMapProductSearch.btnCheckkOut)).click();
		driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
		Thread.sleep(5000);
		    
	}
	
	/**
	 * This verifyAddToCartNotificationModalLumberPriceGridAZ() method is used to add to cart notification modal number price to grid
	 * 
	 */
	public void verifyAddToCartNotificationModalLumberPriceGridAZ() throws Exception 
	{
		//fc.verifyingRegisteredUserLogin();
		driver.findElement(By.linkText(UIMapProductSearch.lnkBldngSupp)).click();
	    driver.findElement(By.cssSelector(UIMapProductSearch.lnkLumber)).click();
	    new Select(driver.findElement(By.id(UIMapProductSearch.drpDownGridSelect))).selectByVisibleText("Dimensional Lumber");
	    driver.findElement(By.xpath(UIMapProductSearch.txtLumberData1)).clear();
	    driver.findElement(By.xpath(UIMapProductSearch.txtLumberData1)).sendKeys("2");
	    driver.findElement(By.xpath(UIMapProductSearch.txtLumberData2)).clear();
	    driver.findElement(By.xpath(UIMapProductSearch.txtLumberData2)).sendKeys("1");
	    driver.findElement(By.id(UIMapProductSearch.btnAddAllToCart)).click();
	}
	
	/**
	 * This verifyAddToCartNotificationModalLumberPriceGridLI() method is used to add to cart notification modal number price to grid
	 * 
	 */
	public void verifyAddToCartNotificationModalLumberPriceGridLI() throws Exception 
	{
		fc.verifyingRegisteredUserLogin();
		driver.findElement(By.linkText(UIMapProductSearch.lnkBldngSupp)).click();
	    driver.findElement(By.cssSelector(UIMapProductSearch.lnkLumber)).click();
	    new Select(driver.findElement(By.id(UIMapProductSearch.drpDownGridSelect))).selectByVisibleText("Dimensional Lumber");
	    driver.findElement(By.xpath(UIMapProductSearch.txtLumberData1)).clear();
	    driver.findElement(By.xpath(UIMapProductSearch.txtLumberData1)).sendKeys("2");
	    driver.findElement(By.xpath(UIMapProductSearch.txtLumberData2)).clear();
	    driver.findElement(By.xpath(UIMapProductSearch.txtLumberData2)).sendKeys("1");
	    driver.findElement(By.id(UIMapProductSearch.btnAddAllToCart)).click();
	}
	
	/**
	 * This verifyFeaturedBannerCluster() method is used to verify the featured banner cluster
	 * 
	 */
	public void verifyFeaturedBannerCluster() throws Exception 
	{
		fc.verifyingRegisteredUserLogin();
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.xpath(UIMapMyLowes.mouseHvrHeaderBlock)); 
	    actions.moveToElement(menuHoverLink).build().perform(); 
	    System.out.println("Mouse Hover successful"); 
	    driver.findElement(By.linkText(UIMapMyLowes.lnkKtchnAndDng)).click();
	    if(driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntFeaturedbannerCluster1)).isDisplayed() &&
	    		driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntFeaturedbannerCluster2)).isDisplayed() &&
	    		driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntFeaturedbannerCluster3)).isDisplayed() &&
	    		driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntFeaturedbannerCluster4)).isDisplayed() &&
	    		driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntFeaturedbannerCluster5)).isDisplayed() &&
	    		driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntFeaturedbannerCluster6)).isDisplayed() ){
	    	report.updateTestLog("Verifying the Featured Banner Cluster in the Kitchen and Dining Page","Verification is successful", Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying the Featured Banner Cluster in the Kitchen and Dining Page","Verification is not successful", Status.FAIL);
		}
	}
	
	/**
	 * This verifyingItemAddedToNotificationModalEPP() method is used to verify the successful message after item is added to cart.
	 * 
	 */
	public void verifyingItemAddedToNotificationModalEPPAZ() throws Exception 
	{
			
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","ItemNbr"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		report.updateTestLog("Searching For an Item","Searching Item Number - "+dataTable.getData("General_Data","ItemNbr")+"" ,Status.DONE);
		boolean verItemPresent=selenium.isTextPresent("Item #: "+dataTable.getData("General_Data","ItemNbr"));
		if(verItemPresent)
		{
			report.updateTestLog("Verifying Navigating to Item's PDP Page","Item - " +dataTable.getData("General_Data","ItemNbr") +" is Present", Status.PASS);
		}
		else
		{
			report.updateTestLog("Veriyfing Navigating to Item's PDP Page","Item is NOT Present", Status.FAIL);
		}
		//String PriceOfProduct = driver.findElement(By.xpath(".//*[@id='mystore-item-price']")).getText();
		
		if(driver.findElement(By.xpath(UIMapProductSearch.txtWrntyMsg1)).isDisplayed() &&
				driver.findElement(By.xpath(UIMapProductSearch.txtWrntyMsg2)).isDisplayed())
		{
			report.updateTestLog("Verifying warranty messages while adding item added to cart","Verification is successful", Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying warranty messages while adding item added to cart","Verification is not successful", Status.FAIL);
		}
		//String warrantyPrice = driver.findElement(By.xpath("//*[@id='warrantyprice_3444070']")).getText(); 
		
		driver.findElement(By.cssSelector(UIMapProductSearch.rdoBtnWrnty)).click();
	    driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
	    if(driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntAddToCartPopUp1)).isDisplayed() &&
				driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntAddToCartPopUp2)).isDisplayed() &&
				driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntAddToCartPopUp3)).isDisplayed() &&
				driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntWrntyMsg)).isDisplayed())
				{
				report.updateTestLog("Verification of name, price,quantity,warrantymessage display in the nodal window","Verification is successful", Status.PASS);
		}else{
				report.updateTestLog("Verification of name, price,quantity,warrantymessage display in the nodal window","Verification is not successful", Status.FAIL);
		}
			driver.findElement(By.xpath(UIMapProductSearch.lnkClseAddToCartPopUp)).click();
			Thread.sleep(5000);
	}
	
	/**
	 * This verifyingItemAddedToCartNotificationModalLI() method is used to verify the successful message after item is added to cart.
	 * 
	 */
	public void verifyingItemAddedToCartNotificationModalLI() throws Exception 
	{
		fc.verifyingRegisteredUserLogin();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","ItemNbr"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		report.updateTestLog("Searching For an Item","Searching Item Number - "+dataTable.getData("General_Data","ItemNbr")+"" ,Status.DONE);
		boolean verItemPresent=selenium.isTextPresent("Item #: "+dataTable.getData("General_Data","ItemNbr"));
		if(verItemPresent)
		{
			report.updateTestLog("Verifying Navigating to Item's PDP Page","Item - " +dataTable.getData("General_Data","ItemNbr") +" is Present", Status.PASS);
		}
		else
		{
			report.updateTestLog("Veriyfing Navigating to Item's PDP Page","Item is NOT Present", Status.FAIL);
		}
		driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
		Thread.sleep(5000);
		if(driver.findElement(By.xpath(UIMapProductSearch.txtAddProductTitle)).getText().equals("Your item was successfully added to cart."))
		{
			report.updateTestLog("Verifying successful message while adding item added to cart","Verification is successful", Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying successful message while adding item added to cart","Verification is not successful", Status.FAIL);
		}
		
		if(driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntAddToCartPopUp1)).isDisplayed() &&
			driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntAddToCartPopUp2)).isDisplayed() &&
			driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntAddToCartPopUp3)).isDisplayed() &&
			driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntAddToCartPopUp4)).isDisplayed() &&
			driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntAddToCartPopUp5)).isDisplayed()){
			report.updateTestLog("Verification of name, price,quantity,continue shopping button and check button display in the nodal window","Verification is successful", Status.PASS);
		}else{
			report.updateTestLog("Verification of name, price,quantity,continue shopping button and check button display in the nodal window","Verification is not successful", Status.FAIL);
		}
		driver.findElement(By.xpath(UIMapProductSearch.lnkClseAddToCartPopUp)).click();
		Thread.sleep(5000);
		    
	}
	
	/**
	 * This verifyResultsPagePaginationControls() method is used to verify the pagination controls
	 * 
	 */
	public void verifyResultsPagePaginationControls() throws Exception 
	{
		fc.verifyingRegisteredUserLogin();
		driver.findElement(By.linkText(UIMapProductSearch.lnkBuildAndRemodal)).click();
	    driver.findElement(By.cssSelector(UIMapProductSearch.lnkAttic)).click();
	    driver.findElement(By.linkText(UIMapProductSearch.lnkNext)).click();
	    driver.findElement(By.linkText(UIMapProductSearch.lnkPrevious)).click();
	}
	
	/**
	 * This verifyMasterHeadMegaMenu() method is used to verify the master head mega menu
	 * 
	 */
	public void verifyMasterHeadMegaMenu() throws Exception 
	{
		fc.verifyingRegisteredUserLogin();
		if(driver.findElement(By.xpath(UIMapProductSearch.txtIdeasAndHowTos)).getText().equals("Ideas & How-Tos ")&&
				driver.findElement(By.xpath(UIMapProductSearch.txtInspiration)).isDisplayed() &&
				driver.findElement(By.xpath(UIMapProductSearch.txtHouzzHeader)).isDisplayed()){
			report.updateTestLog("Verification of master head mega menu","Verification is successful", Status.PASS);
		}
		else{
			report.updateTestLog("Verification of master head mega menu","Verification is not successful", Status.FAIL);
		}
		driver.findElement(By.cssSelector(UIMapProductSearch.btnLearnMore)).click();
		
	}
	
	/**
	 * This verifySearchResultsFromProductToNonProduct() method is used to search results from product to non-product
	 * 
	 */
	public void verifySearchResultsFromProductToNonProduct() throws Exception 
	{
		fc.verifyingRegisteredUserLogin();
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","ItemNbr"));
		driver.findElement(By.linkText(UIMapProductSearch.lnkIdeasAndHowTos)).click();
	}
	
	/**
	 * This verifyGiftCardNotificationModalAZ() method is used to search results from product to non-product
	 * 
	 */
	public void verifyGiftCardNotificationModalAZ() throws Exception 
	{
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys("alloc-pagoda");
	    driver.findElement(By.id(UIMapProductSearch.txtGiftCardTo)).clear();
	    driver.findElement(By.id(UIMapProductSearch.txtGiftCardTo)).sendKeys("a");
	    driver.findElement(By.id(UIMapProductSearch.txtGiftCardFrom)).clear();
	    driver.findElement(By.id(UIMapProductSearch.txtGiftCardFrom)).sendKeys("s");
	    driver.findElement(By.id(UIMapProductSearch.txtGiftCardMsg)).clear();
	    driver.findElement(By.id(UIMapProductSearch.txtGiftCardMsg)).sendKeys("test");
	    driver.findElement(By.cssSelector(UIMapProductSearch.btnGreen)).click();
	    driver.findElement(By.linkText(UIMapProductSearch.lnkRemove)).click();
	    driver.findElement(By.cssSelector(UIMapProductSearch.btnIconToMyCart)).click();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys("318");
	}
	/**
	 * This verifyGiftCardNotificationModalLI() method is used to search results from product to non-product
	 * 
	 */
	public void verifyGiftCardNotificationModalLI() throws Exception 
	{
		fc.verifyingRegisteredUserLogin();
		verifyGiftCardNotificationModalAZ();
	}
	
	/**
	 * This verifyModalAfterAddingItemtToCart() method is used to verify the successful message after item is added to cart.
	 * 
	 */
	public void verifyModalAfterAddingItemtToCart() throws Exception 
	{
		fc.verifyingRegisteredUserLogin();
		verifyingItemAddedToCartMsgSuccessfullyAZ();
	}
	
	/**
	 * This verifyStorePopUpLocator() method is used to verify the existing store pop up
	 * 
	 */
	public void verifyStorePopUpLocatorStoreInfo() throws Exception 
	{
		fc.verifyingRegisteredUserLogin();
		driver.findElement(By.cssSelector(UIMapProductSearch.btnStoreInfoSpan)).click();
		Thread.sleep(5000);
		if(driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntStoreInfoPopUp1)).isDisplayed() &&
				driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntStoreInfoPopUp2)).isDisplayed() &&
				driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntStoreInfoPopUp3)).isDisplayed() &&
				driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntStoreInfoPopUp4)).isDisplayed()){
			report.updateTestLog("Verification of Store Info Pop up","Verification is successful", Status.PASS);
		}else{
			report.updateTestLog("Verification of Store Info Pop up","Verification is not successful", Status.FAIL);
		}
		 driver.findElement(By.cssSelector(UIMapProductSearch.btnClose)).click();
		 Thread.sleep(5000);
		 driver.findElement(By.cssSelector(UIMapProductSearch.btnStoreInfoSpan)).click();
		 Thread.sleep(5000);
		 if(driver.findElement(By.xpath(UIMapProductSearch.txtHeaderLocator)).isDisplayed()){
			 report.updateTestLog("Verification of Change Store Info Pop up","Verification is successful", Status.PASS);
		 }else{
			 report.updateTestLog("Verification of Change Store Info Pop up","Verification is not successful", Status.FAIL);
		 }
		 driver.findElement(By.cssSelector(UIMapProductSearch.btnHeaderClose)).click();
	}
	
	/**
	 * This verifyNotificationModalFromComparePageAZ() method is used to verify the notification modal while comparing prices of products
	 * 
	 */
	public void verifyNotificationModalFromComparePageAZ() throws Exception 
	{
		
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys("nuts");
	    driver.findElement(By.xpath(UIMapProductSearch.lnkCmpMapItem)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapProductSearch.lnkCmpMapItemInput)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapProductSearch.lnkMapItemBar)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapProductSearch.btnAddSpan)).click();
	    if(driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntAddToCartPopUp1)).isDisplayed() &&
				driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntAddToCartPopUp2)).isDisplayed() &&
				driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntAddToCartPopUp3)).isDisplayed() &&
				driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntAddToCartPopUp4)).isDisplayed() &&
				driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntAddToCartPopUp5)).isDisplayed()){
				report.updateTestLog("Verification of name, price,quantity,continue shopping button and check button display in the nodal window","Verification is successful", Status.PASS);
			}else{
				report.updateTestLog("Verification of name, price,quantity,continue shopping button and check button display in the nodal window","Verification is not successful", Status.FAIL);
		}
		 driver.findElement(By.cssSelector(UIMapProductSearch.btnHeaderClose)).click();
	}
	
	/**
	 * This verifyMasterHeadMegaMenuHowTos() method is used to verify the master head mega menu How To's
	 * 
	 */
	public void verifyMasterHeadMegaMenuHowTos() throws Exception 
	{
		fc.verifyingRegisteredUserLogin();
		if(driver.findElement(By.xpath(UIMapProductSearch.txtIdeasAndHowTos)).getText().equals("Ideas & How-Tos ")&&
				driver.findElement(By.xpath(UIMapProductSearch.txtInspiration)).isDisplayed() &&
				driver.findElement(By.xpath(UIMapProductSearch.txtHouzzHeader)).isDisplayed()){
			report.updateTestLog("Verification of master head mega menu","Verification is successful", Status.PASS);
		}
		else{
			report.updateTestLog("Verification of master head mega menu","Verification is not successful", Status.FAIL);
		}
		driver.findElement(By.xpath(UIMapProductSearch.txtChooseAPrj)).click();
		Thread.sleep(10000);
		if((driver.findElement(By.xpath(UIMapProductSearch.txtHowTos)).isDisplayed() && 
				driver.findElement(By.xpath(UIMapProductSearch.txtHowTos)).getText().equals("How-Tos")) &&
			(driver.findElement(By.xpath(UIMapProductSearch.txtBuyingGuideLines)).isDisplayed()&& 
				driver.findElement(By.xpath(UIMapProductSearch.txtBuyingGuideLines)).getText().equals("Buying Guides")) &&
			(driver.findElement(By.xpath(UIMapProductSearch.txtVideos)).isDisplayed()&& 
				driver.findElement(By.xpath(UIMapProductSearch.txtVideos)).getText().equals("Videos")) &&
			(driver.findElement(By.xpath(UIMapProductSearch.txtCalcs)).isDisplayed()&& 
						driver.findElement(By.xpath(UIMapProductSearch.txtCalcs)).getText().equals("Calculators"))){
			report.updateTestLog("Verification of Ideas and How To's ThirdLink (Choose a Project Links)","Verification is successful", Status.PASS);
		}
		else{
			report.updateTestLog("Verification of Ideas and How To's ThirdLink (Choose a Project Links)","Verification is successful", Status.FAIL);
			}
		
		if(driver.findElement(By.xpath(UIMapProductSearch.txtHowToLib)).isDisplayed() &&
				driver.findElement(By.xpath(UIMapProductSearch.txtHowToLib)).getText().equals("Lowe's How-To Library")){
			report.updateTestLog("Verification of Lowe's How-To Library","Verification is successful", Status.PASS);
		}
		else{
			report.updateTestLog("Verification of Lowe's How-To Library","Verification is successful", Status.FAIL);
		}
	}
	
	/**
	 * This verifyNotificationModalFromComparePageLI() method is used to verify the notification modal while comparing prices of products
	 * 
	 */
	public void verifyNotificationModalFromComparePageLI() throws Exception 
	{
		
	    fc.verifyingRegisteredUserLogin();
	    verifyNotificationModalFromComparePageAZ();
	}
	
	/**
	 * This verifyingItemAddedToCartMsgSuccessfullyLI() method is used to verify the notification modal while comparing prices of products
	 * 
	 */
	public void verifyingItemAddedToCartMsgSuccessfullyLI() throws Exception 
	{
		
	    fc.verifyingRegisteredUserLogin();
	    verifyingItemAddedToCartMsgSuccessfullyAZ();
	}
	
	/**
	 * This verifyMAPItemPriceAZ() method is used to verify the strike thru price of a MAP item
	 * 
	 */
	public void verifyMAPItemPriceAZ() throws Exception 
	{		
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","ItemNbr"));
		if(driver.findElement(By.xpath(UIMapProductSearch.txtPricing5)).isDisplayed() && 
			 driver.findElement(By.xpath(UIMapProductSearch.txtPricing5)).getText().contains("Ends")){
		 report.updateTestLog("Verification of MAP item price","Verification is successful", Status.PASS);
		}
		else{
			report.updateTestLog("Verification of MAP item price","Verification is not successful", Status.FAIL);
		}		 
	 }
	
	/**
	 * This verifyMAPItemPriceLI() method is used to verify the strike thru price of a MAP item
	 * 
	 */
	public void verifyMAPItemPriceLI() throws Exception 
	{	
		fc.verifyingRegisteredUserLogin();
		verifyMAPItemPriceAZ();
	}
	
	/**
	 * This verifyMAPItemComparePageAZ() method is used to verify the strike thru price of a MAP item
	 * 
	 */
	public void verifyMAPItemComparePageAZ() throws Exception 
	{		
		driver.findElement(By.xpath(UIMapProductSearch.lnkCmpMapItem1)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapProductSearch.lnkCmpMapItem1)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapProductSearch.lnkCmpMapItem)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapProductSearch.lnkCmpMapItemInput)).click();
		Thread.sleep(5000);
		
		if(driver.findElement(By.xpath(UIMapProductSearch.txtPrdCmpArea)).isDisplayed()){
		 report.updateTestLog("Verification of comparison Assistant","Verification is successful", Status.PASS);
		}
		else{
			report.updateTestLog("Verification of comparison Assistant","Verification is not successful", Status.FAIL);
		}		 
	 }
	/**
	 * This verifyMAPItemComparePageLI() method is used to verify the strike thru price of a MAP item
	 * 
	 */
	public void verifyMAPItemComparePageLI() throws Exception 
	{	
		fc.verifyingRegisteredUserLogin();
		verifyMAPItemComparePageAZ();
	}
	
	/**
	 * This verifyMAPItemDetailPage() method is used to verify the Product detail Page of a MAP Item
	 * 
	 */	
	public void verifyMAPItemDetailPageAZ() throws Exception 
	{		
		//MAP item with a Price
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","ItemNbr"));
		if(driver.findElement(By.xpath(UIMapProductSearch.txtPricing1)).isDisplayed() &&
				driver.findElement(By.xpath(UIMapProductSearch.txtPricing1)).getText().equals("View Price in Cart")){
			report.updateTestLog("Verification of View Price In Cart Text","Verification is successful", Status.PASS);
		}
		else{
			report.updateTestLog("Verification of View Price In Cart Text","Verification is not successful", Status.FAIL);
		}	
		if(driver.findElement(By.xpath(UIMapProductSearch.txtPricing2)).isDisplayed()){				
			report.updateTestLog("Verification of contextual Help","Verification is successful", Status.PASS);
		}
		else{
			report.updateTestLog("Verification of contextual Help","Verification is not successful", Status.FAIL);
		}
		/*driver.findElement(By.cssSelector("img[alt=\"Help Icon\"]")).click();
		Thread.sleep(5000);
	    driver.findElement(By.xpath("//div[21]/div/a/span")).click();
		Thread.sleep(5000);*/
		if(driver.findElement(By.xpath(UIMapProductSearch.txtPricing3)).isDisplayed()){			
			report.updateTestLog("Verification of Static Price","Verification is successful", Status.PASS);
		}
		else{
			report.updateTestLog("Verification of Static Price","Verification is not successful", Status.FAIL);
		}
		if(driver.findElement(By.xpath(UIMapProductSearch.txtPricing4)).isDisplayed() && 
				 driver.findElement(By.xpath(UIMapProductSearch.txtPricing4)).getText().contains("Ends")){
			 report.updateTestLog("Verification of MAP item price Ends","Verification is successful", Status.PASS);
		}
		else{
				report.updateTestLog("Verification of MAP item price Ends","Verification is not successful", Status.FAIL);
		}		
		
	}
	/**
	 * This verifyMAPItemDetailPageLI() method is used to verify the Product detail Page of a MAP Item
	 * 
	 */
	public void verifyMAPItemDetailPageLI() throws Exception 
	{	
		 fc.verifyingRegisteredUserLogin();
		 verifyMAPItemDetailPageAZ();
	}
	
	
	/**
	 * This verifyMAPItemListPageAZ() method is used to verify the Product list Page of a MAP Item
	 * 
	 */
	public void verifyMAPItemListPageAZ() throws Exception 
	{		
		driver.findElement(By.cssSelector(UIMapProductSearch.lnkApplicances)).click();
		Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapProductSearch.lnkFrnDoorRefrg)).click();
		Thread.sleep(5000);
		if(driver.findElement(By.xpath(UIMapProductSearch.txtRefImg)).isDisplayed() &&
				driver.findElement(By.cssSelector(UIMapProductSearch.lnkHelpIcon)).isDisplayed()){
			report.updateTestLog("Verification of View Price In Cart Text and contextual Help","Verification is successful", Status.PASS);
		}else{
			report.updateTestLog("Verification of View Price In Cart Text and contextual Help","Verification is successful", Status.FAIL);
		}
		if(driver.findElement(By.cssSelector(UIMapProductSearch.lnkSavingMsg)).isDisplayed()){
			report.updateTestLog("Verification of End With","Verification is successful", Status.PASS);
		}else{
			report.updateTestLog("Verification of Ends With","Verification is successful", Status.FAIL);
		}
		driver.findElement(By.linkText(UIMapProductSearch.lnkGridView)).click();		
	    
	}
	
	/**
	 * This verifyMAPItemListPageLI() method is used to verify the Product list Page of a MAP Item
	 * 
	 */
	public void verifyMAPItemListPageLI() throws Exception 
	{
		fc.verifyingRegisteredUserLogin();
		verifyMAPItemListPageAZ();
	}
	
	/**
	 * This verifyingItemAddedToNotificationModalEPP() method is used to verify the successful message after item is added to cart.
	 * 
	 */
	public void verifyingItemAddedToNotificationModalEPPLI() throws Exception 
	{
		 fc.verifyingRegisteredUserLogin();
		 verifyingItemAddedToNotificationModalEPPAZ();
	}
	
	/**
	 * This verifyNotificationModalRTFAddedDetailsPage() method is used to verify the notification modal with RTF details on it.
	 * 
	 */
	public void verifyNotificationModalRTFAddedDetailsPage() throws Exception 
	{
		
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","ItemNbr"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		report.updateTestLog("Searching For an Item","Searching Item Number - "+dataTable.getData("General_Data","ItemNbr")+"" ,Status.DONE);
		boolean verItemPresent=selenium.isTextPresent("Item #: "+dataTable.getData("General_Data","ItemNbr"));
		if(verItemPresent)
		{
			report.updateTestLog("Verifying Navigating to Item's PDP Page","Item - " +dataTable.getData("General_Data","ItemNbr") +" is Present", Status.PASS);
		}
		else
		{
			report.updateTestLog("Veriyfing Navigating to Item's PDP Page","Item is NOT Present", Status.FAIL);
		}
		//String itemFromPDPage = driver.findElement(By.xpath(UIMapMyLowes.txtItemInPdPage)).getText();
		driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
		Thread.sleep(5000);
		if(driver.findElement(By.xpath(UIMapProductSearch.txtAddProductTitle)).getText().equals("Your item was successfully added to cart."))
		{
			report.updateTestLog("Verifying successful message while adding item added to cart","Verification is successful", Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying successful message while adding item added to cart","Verification is not successful", Status.FAIL);
		}
		
		//String RTFItem = driver.findElement(By.xpath(UIMapProductSearch.txtItemRTF)).getText();
		if(driver.findElement(By.xpath(UIMapProductSearch.webElmntPresentDidYouKnow)).isDisplayed()){
			report.updateTestLog("Verification Did you know text display in the nodal window","Verification is successful", Status.PASS);
		}else{
			report.updateTestLog("Verification Did you know text display in the nodal window","Verification is not successful", Status.FAIL);
		}
		driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntAddToCartPopUp4)).click();
		Thread.sleep(5000);
	
		
		if(selenium.isTextPresent(UIMapProductSearch.webElmntPresentItemAddedToCart)){
			report.updateTestLog("Verification of RTF Item added to cart message in the pop up","Verification is successful", Status.PASS);
		}else{
			report.updateTestLog("Verification of RTF Item added to cart message in the pop up","Verification is not successful", Status.FAIL);
		}
		
		driver.findElement(By.xpath(UIMapProductSearch.btnCheckkOutRTF)).click();
		/*if(selenium.isTextPresent(itemFromPDPage) && selenium.isTextPresent(RTFItem)){
			report.updateTestLog("Verification of All the Items Added to Cart","Verification is successful", Status.PASS);
		}else{
			report.updateTestLog("Verification of All the Items Added to Cart","Verification is not successful", Status.FAIL);
		}*/
	}	
	
	/**
	 * This verifyNotificationModalRTFAddedDetailsPageLI() method is used to verify the notification modal with RTF details on it.
	 * 
	 */
	public void verifyNotificationModalRTFAddedDetailsPageLI() throws Exception 
	{
		fc.lowesUserRegistration();
		verifyNotificationModalRTFAddedDetailsPage();
	}
	
	/**
	 * This verifyNotificationModalEPPAndRTFDetail() method is used to verify the notification modal with RTF details and EPP 
	 * 
	 */
	public void verifyNotificationModalEPPAndRTFDetailAZ() throws Exception 
	{
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","ItemNbr"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		report.updateTestLog("Searching For an Item","Searching Item Number - "+dataTable.getData("General_Data","ItemNbr")+"" ,Status.DONE);
		boolean verItemPresent=selenium.isTextPresent("Item #: "+dataTable.getData("General_Data","ItemNbr"));
		if(verItemPresent)
		{
			report.updateTestLog("Verifying Navigating to Item's PDP Page","Item - " +dataTable.getData("General_Data","ItemNbr") +" is Present", Status.PASS);
		}
		else
		{
			report.updateTestLog("Veriyfing Navigating to Item's PDP Page","Item is NOT Present", Status.FAIL);
		}
			
		if(driver.findElement(By.xpath(UIMapProductSearch.txtWrntyMsg1)).isDisplayed() &&
				driver.findElement(By.xpath(UIMapProductSearch.txtWrntyMsg2)).isDisplayed())
		{
			report.updateTestLog("Verifying warranty messages while adding item added to cart","Verification is successful", Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying warranty messages while adding item added to cart","Verification is not successful", Status.FAIL);
		}
		 
		
		driver.findElement(By.cssSelector(UIMapProductSearch.rdoBtnWrnty)).click();
		driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
		
		if(driver.findElement(By.xpath(UIMapProductSearch.webElmntPresentDidYouKnow)).isDisplayed()){
			report.updateTestLog("Verification Did you know text display in the nodal window","Verification is successful", Status.PASS);
		}else{
			report.updateTestLog("Verification Did you know text display in the nodal window","Verification is not successful", Status.FAIL);
		}
		
		    
	}
	
	/**
	 * This verifyNotificationModalEPPAndRTFDetail() method is used to verify the notification modal with RTF details and EPP 
	 * 
	 */
	
	public void verifyNotificationModalEPPAndRTFDetailLI() throws Exception 
	{
		fc.lowesUserRegistration();
		verifyNotificationModalEPPAndRTFDetailAZ();
	}
	
	/**
	 * This verifySearchResultsPageFilterBehaviour() method is used to verify the filter behaviour in search results page
	 * 
	 */
	public void verifySearchResultsPageFilterBehaviour() throws Exception 
	{	
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.xpath(UIMapMyLowes.mouseHvrHeaderBlock)); 
	    actions.moveToElement(menuHoverLink).build().perform(); 
	    System.out.println("Mouse Hover successful"); 
		driver.findElement(By.linkText(UIMapMyLowes.lnkKtchnAndDng)).click();
		Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapProductSearch.lnkBabyRoom)).click();
	    Thread.sleep(5000);
	    if(driver.findElement(By.xpath(UIMapProductSearch.txtYouHvChsn)).isDisplayed()){
	    	report.updateTestLog("Verification of 'You Have Choosen' text in the selection window","Verification is successful", Status.PASS);
	    }else{
	    	report.updateTestLog("Verification of 'You Have Choosen' text in the selection window","Verification is not successful", Status.FAIL);
	    }
	    String selectedText = driver.findElement(By.xpath(UIMapProductSearch.txtselectedFilters)).getText();
	    System.out.println("selectedText is"+selectedText);
	    int sizeOfSelectedText = selectedText.length();
	    System.out.println("sizeOfSelectedText is"+sizeOfSelectedText);
	    
	    driver.findElement(By.cssSelector(UIMapProductSearch.lnkBasement)).click();
	    Thread.sleep(5000);
	    String selectedTexts = driver.findElement(By.xpath(UIMapProductSearch.txtselectedFilters)).getText();
	    System.out.println("selectedTexts is"+selectedTexts);
	    int sizeOfselectedTexts = selectedTexts.length();
	    System.out.println("sizeOfselectedTexts is***"+sizeOfselectedTexts);
	    
	    driver.findElement(By.linkText("remove")).click();
	    Thread.sleep(5000);
	    String afterDelTxts = driver.findElement(By.xpath(UIMapProductSearch.txtselectedFilters)).getText();
	    System.out.println("afterDelTxts is"+afterDelTxts);
	    int sizeAfterDelTxts = afterDelTxts.length();
	    System.out.println("sizeAfterDelTxts is"+sizeAfterDelTxts);
	    
	    if(sizeAfterDelTxts<sizeOfselectedTexts){
	    	report.updateTestLog("Verification of Filter behaviour in the Search Results page","Verification is successful", Status.PASS);
	    }
		else{
	    	report.updateTestLog("Verification of Filter behaviour in the Search Results page","Verification is successful", Status.FAIL);
	    }
	    
	}
	
	/**
	 * This verifyFilterBoxEnhancement() method is used to verify the filter behaviour in search results page
	 * 
	 */
	public void verifyFilterBoxEnhancement() throws Exception 
	{	
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(UIMapProductSearch.txtRefridgerators);
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapProductSearch.lnkBuiltInRfdge)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapProductSearch.lnkCabinetPulls)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id(UIMapProductSearch.lnkPrice1To5)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id(UIMapProductSearch.lnkPrice5To10)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id(UIMapProductSearch.lnkStyleContmp)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id(UIMapProductSearch.lnkStyleTrnstnl)).click();
	    Thread.sleep(5000);
	    if(driver.findElement(By.xpath(UIMapProductSearch.txtYouHvChsnFrmSearch)).isDisplayed()){
	    	report.updateTestLog("Verification of 'You Have Choosen' text in the selection window","Verification is successful", Status.PASS);
	    }else{
	    	report.updateTestLog("Verification of 'You Have Choosen' text in the selection window","Verification is not successful", Status.FAIL);
	    }
	    String slctdTxtBfrNext = driver.findElement(By.xpath(UIMapProductSearch.txtYouHvChsnFrmSearch)).getText();
	    int slctdTxtBfrNextSize = slctdTxtBfrNext.length();
	    driver.findElement(By.linkText(UIMapProductSearch.lnkNext)).click();
	    String slctdTxtAfrrNext = driver.findElement(By.xpath(UIMapProductSearch.txtYouHvChsnFrmSearch)).getText();
	    int slctdTxtAfrrNextSize = slctdTxtAfrrNext.length();
	    if(slctdTxtBfrNextSize==slctdTxtAfrrNextSize){
	    	report.updateTestLog("Verification of filter box size before and after","Verification is successful", Status.PASS);
	    }else{
	    	report.updateTestLog("Verification of filter box size before and after","Verification is not successful", Status.FAIL);
	    }
	}
	
	/**
	 * This verifyChangeStoreAZ() method is used to verify the change store
	 * 
	 */
	public void verifyChangeStoreAZ() throws Exception 
	{	
		
		driver.findElement(By.cssSelector(UIMapProductSearch.btnChangeStoreInfo)).click();
		Thread.sleep(5000);
	    driver.findElement(By.id(UIMapProductSearch.txtStoreSearch)).clear();
	    driver.findElement(By.id(UIMapProductSearch.txtStoreSearch)).sendKeys(dataTable.getData("General_Data","Country"));
	    driver.findElement(By.id(UIMapProductSearch.btnHeaderMapSearch)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.linkText(UIMapProductSearch.lnkSlctCountry)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapProductSearch.lnkShowHideDetails)).click();
	    driver.findElement(By.cssSelector(UIMapProductSearch.lnkShowHideDetails)).click();
	    driver.findElement(By.cssSelector(UIMapProductSearch.lnkShowHideDetails)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.linkText(UIMapProductSearch.lnkViewOnMap)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapProductSearch.btnChangeStoreInfo)).click();
	    driver.findElement(By.cssSelector(UIMapProductSearch.lnkShowHideDetails)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapProductSearch.lnkGetDirections)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapProductSearch.btnChangeStoreInfo)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.linkText(UIMapProductSearch.lnkFindMoreStores)).click();
	    Thread.sleep(5000);     
	   
	}
	/**
	 * This verifyChangeStoreLI() method is used to verify the change store
	 * 
	 */
	public void verifyChangeStoreLI() throws Exception 
	{
		fc.verifyingRegisteredUserLogin();
		verifyChangeStoreAZ();
	}
	/**
	 * This verifyStorePopUpLocatorChangeStore() method is used to verify the store info
	 * 
	 */
	public void verifyStorePopUpLocatorChangeStore() throws Exception 
	{
		fc.verifyingRegisteredUserLogin();
		if(driver.findElement(By.xpath(UIMapProductSearch.txtYourStore)).isDisplayed() &&
				driver.findElement(By.xpath(UIMapProductSearch.txtStoreInfo)).isDisplayed() &&
				driver.findElement(By.xpath(UIMapProductSearch.txtFindAStore)).isDisplayed())
				{
			report.updateTestLog("Verification of Your Store, Store Info and Find A Store","Verification is successful", Status.PASS);
		}
		else{
			report.updateTestLog("Verification of Your Store, Store Info and Find A Store","Verification is successful", Status.FAIL);
		}
	    driver.findElement(By.cssSelector(UIMapProductSearch.btnChangeStoreInfo)).click();
	    Thread.sleep(5000);
	    if(driver.findElement(By.xpath(UIMapProductSearch.txtHeaderLocator)).isDisplayed() &&
	    		driver.findElement(By.xpath(UIMapProductSearch.txtHeaderMapDefault)).isDisplayed() &&
	    		driver.findElement(By.xpath(UIMapProductSearch.txtHeaderSearchSubmit)).isDisplayed()){
	    	report.updateTestLog("Verification of Change Store Info pop up","Verification is successful", Status.PASS);
	    }
	    
	    else{
	    	report.updateTestLog("Verification of Change Store Info pop up","Verification is successful", Status.FAIL);	    
	    }
	    if(driver.findElement(By.xpath(UIMapProductSearch.txtYourStoreHeading)).isDisplayed() &&
	    		driver.findElement(By.xpath(UIMapProductSearch.txtYourStoreHeading)).getText().equals("Your Store:")){
	    	
	    	report.updateTestLog("Verification of Your Store in Change Store Info pop up","Verification is successful", Status.PASS);
	    }
	    else{
	    	report.updateTestLog("Verification of Your Store in Change Store Info pop up","Verification is successful", Status.FAIL);
	    }
	    driver.findElement(By.cssSelector(UIMapProductSearch.lnkShowHideDetails)).click();
	    driver.findElement(By.cssSelector(UIMapProductSearch.lnkShowHideDetails)).click();
	    driver.findElement(By.cssSelector(UIMapProductSearch.lnkShowHideDetails)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.linkText(UIMapProductSearch.lnkViewOnMap)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapProductSearch.btnChangeStoreInfo)).click();
	    driver.findElement(By.cssSelector(UIMapProductSearch.lnkShowHideDetails)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapProductSearch.lnkGetDirections)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapProductSearch.btnChangeStoreInfo)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.linkText(UIMapProductSearch.lnkFindMoreStores)).click();
	    Thread.sleep(5000); 
	    
	}
	/**
	 * This verifyMAPStrikethruPrice() method is used to verify the MAP items strike thru price
	 * 
	 */
	public void verifyMAPStrikethruPrice() throws Exception 
	{
		 driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","ItemNbr"));
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			report.updateTestLog("Searching For an Item","Searching Item Number - "+dataTable.getData("General_Data","ItemNbr")+"" ,Status.DONE);
			boolean verItemPresent=selenium.isTextPresent("Item #: "+dataTable.getData("General_Data","ItemNbr"));
			if(verItemPresent)
			{
				report.updateTestLog("Verifying Navigating to Item's PDP Page","Item - " +dataTable.getData("General_Data","ItemNbr") +" is Present", Status.PASS);
			}
			else
			{
				report.updateTestLog("Veriyfing Navigating to Item's PDP Page","Item is NOT Present", Status.FAIL);
			}
			if(driver.findElement(By.xpath(UIMapProductSearch.txtContextualHelpImg)).isDisplayed()){
				report.updateTestLog("Verification of contextual help in product detail page","Verification is successful", Status.PASS);
			}else{
				report.updateTestLog("Verification of contextual help in product detail page","Verification is not successful", Status.FAIL);
			}
	}
	/**
	 * This verifyBuyThePair() method is used to verify the MAP items Buy The Pair Section
	 * 
	 */
	public void verifyBuyThePair() throws Exception 
	{
		 driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","ItemNbr"));
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			report.updateTestLog("Searching For an Item","Searching Item Number - "+dataTable.getData("General_Data","ItemNbr")+"" ,Status.DONE);
			boolean verItemPresent=selenium.isTextPresent("Item #: "+dataTable.getData("General_Data","ItemNbr"));
			if(verItemPresent)
			{
				report.updateTestLog("Verifying Navigating to Item's PDP Page","Item - " +dataTable.getData("General_Data","ItemNbr") +" is Present", Status.PASS);
			}
			else
			{
				report.updateTestLog("Veriyfing Navigating to Item's PDP Page","Item is NOT Present", Status.FAIL);
			}
			driver.findElement(By.linkText(UIMapProductSearch.lnkBuyThePairItem)).click();
		    Thread.sleep(5000);
		    driver.findElement(By.cssSelector(UIMapProductSearch.lnkHelpIcon)).click();
		    Thread.sleep(5000);
			if(driver.findElement(By.xpath(UIMapProductSearch.txtContextualHelpImg)).isDisplayed()){
				report.updateTestLog("Verification of contextual help in product detail page","Verification is successful", Status.PASS);
			}else{
				report.updateTestLog("Verification of contextual help in product detail page","Verification is not successful", Status.FAIL);
			}
			
	}
	/**
	 * This verifyDocTypeCatAndListPageLI() method is used to verify the DocType in Category and List Page
	 * 
	 */
	public void verifyDocTypeCatAndListPageLI() throws Exception 
	{
		fc.verifyingRegisteredUserLogin();
		verifyDocTypeCatAndListPageAZ();
	}
	/**
	 * This verifyDocTypeCatAndListPageAZ() method is used to verify the DocType in Category and List Page
	 * 
	 */
	public void verifyDocTypeCatAndListPageAZ() throws Exception 
	{
		driver.findElement(By.cssSelector(UIMapProductSearch.lnkApplicances)).click();
		Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapProductSearch.lnkFrnDoorRefrg)).click();
		Thread.sleep(5000);
		//String url = "http://pplws.lowes.com/pl_French+Door+Refrigerators_4294857963_4294937087_?cm_cr=Refrigerators-_-Web+Activity-_-Refrigerators+TF+Popular+Categories-_-SC_Refrigerators_TopFlexible_Area-_-10241561_1_Refrigerators_Pop_Cat-1#!";
		//fc.testOpenlowes(url);
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
}
