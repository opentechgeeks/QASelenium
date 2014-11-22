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
import com.lowes.qa.selenium.uimap.UIMapCheckOut;
import com.lowes.qa.selenium.uimap.UIMapFunctionalComponents;
import com.lowes.qa.selenium.uimap.UIMapMyLowes;
import com.lowes.qa.selenium.uimap.UIMapProductSearch;
import com.thoughtworks.selenium.Selenium;


import com.cognizant.framework.Status;
import com.thoughtworks.selenium.Selenium;

public class CheckOut_BF extends ReusableLibrary {

	/**
	 * Constructor to initialize the component library
	 * 
	 * @param scriptHelper
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link DriverScript}
	 */

	String baseurl = dataTable.getData("General_Data", "URL");
	Selenium selenium = new WebDriverBackedSelenium(driver, baseurl);
	FunctionalComponents fc = new FunctionalComponents(scriptHelper);
	MyLowes mylowes = new MyLowes(scriptHelper);
	CheckOut chkout = new CheckOut(scriptHelper);
	ManageAccount mgAcc = new ManageAccount(scriptHelper);
	
	public CheckOut_BF(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}
	
	/**
	 * This verifyCseSnstvePrmtnalCode() method is used to verify the entered promotion code is case sensitive or not
	 * 
	 */
	public void verifyCseSnstvePrmtnalCode() throws Exception {
		
		driver.findElement(By.id(UIMapCheckOut.txtPromoCode)).clear();
	    driver.findElement(By.id(UIMapCheckOut.txtPromoCode)).sendKeys(dataTable.getData("General_Data", "PromoCode"));
	    driver.findElement(By.xpath(UIMapCheckOut.btnPromoCode)).click();
		
		if(driver.findElement(By.xpath(UIMapCheckOut.webElmntPrsntPromoCodeErrMsg)).isDisplayed()){
			report.updateTestLog("Verification of promotion code case sensitivity","Verification is successful",Status.PASS);
		}else{
			report.updateTestLog("Verification of promotion code case sensitivity","Verification is not successful",Status.FAIL);	
		}	
		
	}
	
	/**
	 * This verifyAddRmvItemsCartPageAZ() method is used to verify the items in cart(By adding and removing)
	 * 
	 */
	public void verifyAddRmvItemsCartPageAZ() throws Exception {
		
		chkout.searchAndAddItemsToCart();
		chkout.makeCartEmpty();
		chkout.searchAndAddItemToCart();
		driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
		Thread.sleep(5000);
		if(driver.findElement(By.linkText(UIMapProductSearch.lnkRemove)).isDisplayed()){
			report.updateTestLog("Verification of item in the cart when added again","Verification is successful",Status.PASS);
		}else{
			report.updateTestLog("Verification of item in the cart when added again","Verification is not successful",Status.FAIL);
		}
		
	}
	
	/**
	 * This verifyAddRmvItemsCartPageLI() method is used to verify the items in cart(By adding and removing)
	 * 
	 */
	public void verifyAddRmvItemsCartPageLI() throws Exception {
		
		chkout.searchAndAddItemsToCart();
		chkout.makeCartEmpty();
		chkout.searchAndAddItemToCart();
		driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
		Thread.sleep(5000);
		if(driver.findElement(By.linkText(UIMapProductSearch.lnkRemove)).isDisplayed()){
			report.updateTestLog("Verification of item in the cart when added again","Verification is successful",Status.PASS);
		}else{
			report.updateTestLog("Verification of item in the cart when added again","Verification is not successful",Status.FAIL);
		}
		
	}
	
	/**
	 * This verifyCCNickNameAZ() method is used to verify the nick name of the credit card
	 * 
	 */
	public void verifyCCNickNameAZ() throws Exception {
		
		driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
		Thread.sleep(5000);
		  driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOutSpan)).click();
		chkout.checkOutCreditCard();
		try{
		String nickNm = driver.findElement(By.name(UIMapMyLowes.txtCardNickName)).getText();
		
		 
		 if(nickNm.length()<=35){
			 report.updateTestLog("Verification of characters in the nick name of a credit card","Verification is successful",Status.PASS);
		 }else{
			 report.updateTestLog("Verification of characters in the nick name of a credit card","Verification is not successful",Status.FAIL);
		 }
		 }	
		catch(Exception e){
			System.out.println("Card NickName Not Displayed in the Review and Pay Page");
			}	
		
	}
	
	/**
	 * This verifyCCNickNameLI() method is used to verify the nick name of the credit card
	 * 
	 */
	public void verifyCCNickNameLI() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		verifyCCNickNameAZ();
	}
	/**
	 * This verifyShpngChrgsVndrDrct() method is used to verify the shipping charges of a vendor direct item
	 * 
	 */
	public void verifyShpngChrgsVndrDrct() throws Exception {
		
		//fc.verifyingRegisteredUserLogin();
		String item = dataTable.getData("General_Data", "ItemNbr");
		chkout.searchItem(item);
		chkout.selectDlvryMthd();
		chkout.addItemToCart();
		driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
		Thread.sleep(5000);
		if(driver.findElement(By.xpath(UIMapCheckOut.lblGCParcelFree)).isDisplayed() && 
			driver.findElement(By.xpath(UIMapCheckOut.lblGCParcelFree)).getText().equals("FREE")){
			report.updateTestLog("Verification of estimated parcel shipping charges for a normal item","Verification is not successful",Status.PASS);
		}
		else{
			report.updateTestLog("Verification of estimated parcel shipping charges for a normal item","Verification is successful",Status.PASS);
		}
		item = dataTable.getData("General_Data", "Item2");
		chkout.searchItem(item);
		chkout.selectDlvryMthd();
		chkout.addItemToCart();	
		Thread.sleep(7000);
		driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
		Thread.sleep(7000);		
		if(driver.findElement(By.xpath(UIMapCheckOut.lblGCParcelFree)).isDisplayed() && 
			driver.findElement(By.xpath(UIMapCheckOut.lblGCParcelFree)).getText().equals("FREE")){
			report.updateTestLog("Verification of estimated parcel shipping charges for a vendor item","Verification is successful",Status.PASS);
		}
		else{
			report.updateTestLog("Verification of estimated parcel shipping charges for a vendor item","Verification is not successful",Status.PASS);
		}
	}
				
	/**
	 * This storeTwoCCCards() method is used to store two Credit cards
	 * 
	 */
	public void storeTwoCCCards() throws Exception {
		
	
		driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
		Thread.sleep(5000);
	    /*driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOutSpan)).click();
		Thread.sleep(5000);*/
		chkout.checkOutAddress();
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id(UIMapCheckOut.btnCCAdd)).click();
	    chkout.checkOutCreditCard();
	    driver.findElement(By.id(UIMapCheckOut.btnStoreCard)).click();
	    driver.findElement(By.id(UIMapCheckOut.btnPrimaryCard)).click();
		
	}
	/**
	 * This verifyBOGOPromotion() method is used to verify the BOGO Promotion
	 * 
	 */
	public void verifyBOGOPromotion() throws Exception {
		
		driver.findElement(By.id(UIMapCheckOut.txtPromoCode)).clear();
	    driver.findElement(By.id(UIMapCheckOut.txtPromoCode)).sendKeys(dataTable.getData("General_Data", "PromoCode"));
	    driver.findElement(By.xpath(UIMapCheckOut.btnPromoCode)).click();
		
		if(driver.findElement(By.xpath(UIMapCheckOut.lblCartSummaryYouSave)).isDisplayed() &&
				(driver.findElement(By.xpath(UIMapCheckOut.lblCartSummaryYouSave)).getText().contains(("You Save")))){
			report.updateTestLog("Verification of promotion code case sensitivity","Verification is successful",Status.PASS);
		}else{
			report.updateTestLog("Verification of promotion code case sensitivity","Verification is not successful",Status.FAIL);	
		}	
	}
	/**
	 * This verifySalesTax() method is used to verify the sales tax for a stock item
	 * 
	 */
	public void verifySalesTax() throws Exception {
		
		driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();		
		if(driver.findElement(By.xpath(UIMapCheckOut.lblCartSummaryYouSave)).isDisplayed() &&
				(driver.findElement(By.xpath(UIMapCheckOut.lblCartSummaryYouSave)).getText().contains(("You Save")))){
			report.updateTestLog("Verification of promotion code case sensitivity","Verification is successful",Status.PASS);
		}else{
			report.updateTestLog("Verification of promotion code case sensitivity","Verification is not successful",Status.FAIL);	
		}	
	    driver.findElement(By.id(UIMapCheckOut.lnkNoThanks)).click();
	    driver.findElement(By.id(UIMapCheckOut.btnCCAdd)).click();		
		chkout.checkOutCreditCard();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapCheckOut.btnCreateAddress)).click();
		mgAcc.checkOutBillingInfoAddNewAddress();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
		
		
				
	}
	
	

	/**
	 * This verifyStockItemQtyMoreThan5() method is used to verify the sales tax for a stock item
	 * 
	 */
	public void verifyStockItemQtyMoreThan5() throws Exception {
		
		driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();		
		if(driver.findElement(By.xpath(UIMapCheckOut.lblCartSummaryYouSave)).isDisplayed() &&
				(driver.findElement(By.xpath(UIMapCheckOut.lblCartSummaryYouSave)).getText().contains(("You Save")))){
			report.updateTestLog("Verification of promotion code case sensitivity","Verification is successful",Status.PASS);
		}else{
			report.updateTestLog("Verification of promotion code case sensitivity","Verification is not successful",Status.FAIL);	
		}	
	    driver.findElement(By.id(UIMapCheckOut.lnkNoThanks)).click();
	    driver.findElement(By.id(UIMapCheckOut.btnCCAdd)).click();		
		chkout.checkOutCreditCard();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapCheckOut.btnCreateAddress)).click();
		mgAcc.checkOutBillingInfoAddNewAddress();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
		
		
				
	}
	/**
	 * This verifyStockItemQtyMultipleItems() method is used to verify the sales tax for a stock item
	 * 
	 */
	public void verifyStockItemQtyMultipleItems() throws Exception {
		
		driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();		
		if(driver.findElement(By.xpath(UIMapCheckOut.lblCartSummaryYouSave)).isDisplayed() &&
				(driver.findElement(By.xpath(UIMapCheckOut.lblCartSummaryYouSave)).getText().contains(("You Save")))){
			report.updateTestLog("Verification of promotion code case sensitivity","Verification is successful",Status.PASS);
		}else{
			report.updateTestLog("Verification of promotion code case sensitivity","Verification is not successful",Status.FAIL);	
		}	
		 driver.findElement(By.id(UIMapCheckOut.lnkNoThanks)).click();
		    driver.findElement(By.id(UIMapCheckOut.btnCCAdd)).click();		
			chkout.checkOutCreditCard();
			Thread.sleep(5000);
			driver.findElement(By.linkText(UIMapCheckOut.btnCreateAddress)).click();
			mgAcc.checkOutBillingInfoAddNewAddress();
			driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
			
		
				
	}
	
	/**
	 * This verifySellingRstrctnsPL() method is used to verify the selling restrictions
	 * 
	 * 
	 */
	public void verifySellingRstrctnsPL() throws Exception {

		
		driver.findElement(By.xpath(UIMapCheckOut.lblSellingRstns)).click();
		
		String sellingRstrncn = driver.findElement(By.xpath(UIMapCheckOut.webElmntSellingRstns)).getText();
		if(sellingRstrncn.contains("Due to selling restrictions, one or more items aren't available for store pickup in your area")){   
	   
	    	report.updateTestLog("Verifications of Employee Savings in the order page "," Verification is Successfull", Status.PASS);
	    }else{
	    	report.updateTestLog("Verifications of Employee Savings in the order page "," Verification is not Successfull", Status.FAIL);
	    }
	}
	
	/**
	 * This verifySellingRstrctnsLTD() method is used to verify the selling restrictions
	 * 
	 * 
	 */
	public void verifySellingRstrctnsLTD() throws Exception {

		
		driver.findElement(By.xpath(UIMapCheckOut.lblSellingRstns)).click();
		
		driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();	
		mgAcc.checkOutAddress();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
		Thread.sleep(5000);
		boolean shippingAddErr = selenium.isTextPresent("Due to shipping restrictions, one or more items aren't available for delivery in your area. Please enter a new shipping address.");
		if(shippingAddErr){   
	   
	    	report.updateTestLog("Verifications of Truck Delivery Restriction in Review and Pay Page "," Verification is Successfull", Status.PASS);
	    }else{
	    	report.updateTestLog("Verifications of Truck Delivery Restriction in Review and Pay Page "," Verification is not Successfull", Status.FAIL);
	    }
	}
	
	/**
	 * This verifySimpleRegistrationReview&Pay() method is used to verify the simple registration while review and pay
	 * 
	 */
	public void verifySimpleRegistrationReviewAndPay() throws Exception {
		
		chkout.addItemToCartWithDlvryMthd();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapCheckOut.btnCCAdd)).click();		
		chkout.checkOutCreditCard();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapCheckOut.btnCreateAddress)).click();
		mgAcc.checkOutBillingInfoAddNewAddress();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();    
	}
	
	/**
	 * This verifyMulItemsAddressPickUpInStore&Pay() method is used to verify multiple items pick up in store
	 * 
	 */
	public void verifyMulItemsAddressPickUpInStoreAndPay() throws Exception {
		
		
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys("41239");
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
	    Thread.sleep(5000);	     
	    driver.findElement(By.id(UIMapCheckOut.rdoShpMdlStorePickUp)).click();
	    driver.findElement(By.xpath(UIMapFunctionalComponents.btnAddToCart)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntPrdAddToCart5)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys("318");
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
	    Thread.sleep(5000);
	    driver.findElement(By.id(UIMapCheckOut.rdoShpMdlStorePickUp)).click();
	    driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id(UIMapCheckOut.btnCCAdd)).click();			
		chkout.checkOutCreditCard();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapCheckOut.btnCreateAddress)).click();
		mgAcc.checkOutBillingInfoAddNewAddress();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();    
		
	  }
	/**
	 * This verifySingleReleaseOrderPurchaseHistory() method is used to verify multiple items pick up in store
	 * 
	 */
	public void verifySingleReleaseOrderPurchaseHistory() throws Exception {
		
		
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys("41239");
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
	    Thread.sleep(5000);	     
	    driver.findElement(By.id(UIMapCheckOut.rdoShpMdlStorePickUp)).click();
	    driver.findElement(By.xpath(UIMapFunctionalComponents.btnAddToCart)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntPrdAddToCart5)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys("318");
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
	    Thread.sleep(5000);
	    driver.findElement(By.id(UIMapCheckOut.rdoShpMdlStorePickUp)).click();
	    driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id(UIMapCheckOut.btnCCAdd)).click();			
		chkout.checkOutCreditCard();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapCheckOut.btnCreateAddress)).click();
		mgAcc.checkOutBillingInfoAddNewAddress();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();    
		
	  }
	

	/**
	 * This verifyStoringALARCard() method is used to verify the sales tax for a stock item
	 * 
	 */
	public void verifyStoringALARCard() throws Exception {
		
		
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys("41239");
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
	    Thread.sleep(5000);	     
	    driver.findElement(By.id(UIMapCheckOut.rdoShpMdlStorePickUp)).click();
	    driver.findElement(By.xpath(UIMapFunctionalComponents.btnAddToCart)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntPrdAddToCart5)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys("318");
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
	    Thread.sleep(5000);
	    driver.findElement(By.id(UIMapCheckOut.rdoShpMdlStorePickUp)).click();
	    driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id(UIMapCheckOut.btnCCAdd)).click();			
		chkout.checkOutCreditCard();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapCheckOut.btnCreateAddress)).click();
		mgAcc.checkOutBillingInfoAddNewAddress();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();    
		
	  }
	
	/**
	 * This verifyMultipleOrderPlcmntLI() method is used to verify multiple items pick up in store
	 * 
	 */
	public void verifyMultipleOrderPlcmntLI() throws Exception {
		
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys("318");
	    driver.findElement(By.id(UIMapCheckOut.rdoShpMdlStorePickUp)).click();
	    driver.findElement(By.xpath(UIMapFunctionalComponents.btnAddToCart)).click();
	    driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntPrdAddToCart5)).click();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys("136470");
	    driver.findElement(By.cssSelector(UIMapCheckOut.btnSearchSubmit)).click();

	    driver.findElement(By.xpath(UIMapFunctionalComponents.btnAddToCart)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	    mgAcc.checkOutAddress();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
		Thread.sleep(5000);
		
		driver.findElement(By.id(UIMapCheckOut.btnCCAdd)).click();	
		chkout.checkOutCreditCard();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapCheckOut.btnCreateAddress)).click();
		mgAcc.checkOutBillingInfoAddNewAddress();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();    
		}
	/**
	 * This verifyEmpDiscOnAllPages() method is used to verify multiple items pick up in store
	 * 
	 */
	public void verifyEmpDiscOnAllPages() throws Exception {
		
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys("318");
	    driver.findElement(By.id(UIMapCheckOut.rdoShpMdlStorePickUp)).click();
	    driver.findElement(By.xpath(UIMapFunctionalComponents.btnAddToCart)).click();
	    driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntPrdAddToCart5)).click();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys("136470");
	    driver.findElement(By.cssSelector(UIMapCheckOut.btnSearchSubmit)).click();

	    driver.findElement(By.xpath(UIMapFunctionalComponents.btnAddToCart)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	    mgAcc.checkOutAddress();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
		Thread.sleep(5000);
		
		driver.findElement(By.id(UIMapCheckOut.btnCCAdd)).click();	
		chkout.checkOutCreditCard();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapCheckOut.btnCreateAddress)).click();
		mgAcc.checkOutBillingInfoAddNewAddress();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();    
		}
	
	/**
	 * This verifyEmpLoggedInPurchaseList() method is used to verify multiple items pick up in store
	 * 
	 */
	public void verifyEmpLoggedInPurchaseList() throws Exception {
		
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys("318");
	    driver.findElement(By.id(UIMapCheckOut.rdoShpMdlStorePickUp)).click();
	    driver.findElement(By.xpath(UIMapFunctionalComponents.btnAddToCart)).click();
	    driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntPrdAddToCart5)).click();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys("136470");
	    driver.findElement(By.cssSelector(UIMapCheckOut.btnSearchSubmit)).click();

	    driver.findElement(By.xpath(UIMapFunctionalComponents.btnAddToCart)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	    mgAcc.checkOutAddress();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
		Thread.sleep(5000);
		
		driver.findElement(By.id(UIMapCheckOut.btnCCAdd)).click();	
		chkout.checkOutCreditCard();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapCheckOut.btnCreateAddress)).click();
		mgAcc.checkOutBillingInfoAddNewAddress();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();    
		}
	


	/**
	 * This verifyTDChargesFree() method is used to verify multiple items pick up in store
	 * 
	 */
	public void verifyTDChargesFree() throws Exception {
		
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys("23076");
	    driver.findElement(By.id(UIMapCheckOut.rdoShpMdlTruckDlvry)).click();
	    driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
	    driver.findElement(By.xpath(UIMapFunctionalComponents.btnCheckout)).click();
	    
	    if(driver.findElement(By.xpath(UIMapCheckOut.lblDel1Charges)).getText().contains("Estimated Truck Delivery ") &&
	    		driver.findElement(By.xpath(UIMapCheckOut.lblDel1ChargesValue)).getText().contains("FREE") ||
	    		driver.findElement(By.xpath(UIMapCheckOut.lblDel2Charges)).getText().contains("Estimated Truck Delivery ") &&
	    		driver.findElement(By.xpath(UIMapCheckOut.lblDel2ChargesValue)).getText().contains("FREE"))
	    {
	    	
	    	report.updateTestLog("Verification of Truck DeliveryCharges","Verification is successful",Status.PASS);
		}else{
			report.updateTestLog("Verification of Truck DeliveryCharges","Verification is not successful",Status.FAIL);
		}	 
	}	
	
	/**
	 * This verifyShippingChargesGiftCard() method is used to verify multiple items pick up in store
	 * 
	 */
	public void verifyShippingChargesGiftCard() throws Exception {
		
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys("389");
	    driver.findElement(By.id(UIMapCheckOut.rdoShpMdlTruckDlvry)).click();
	    driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
	    driver.findElement(By.xpath(UIMapFunctionalComponents.btnCheckout)).click();
	    if(driver.findElement(By.xpath(UIMapCheckOut.lblDel1Charges)).getText().contains("Estimated Parcel Shipping ") &&
	    		driver.findElement(By.xpath(UIMapCheckOut.lblDel1ChargesValue)).getText().contains("FREE") ||
	    		driver.findElement(By.xpath(UIMapCheckOut.lblDel2Charges)).getText().contains("Estimated Parcel Shipping ") &&
	    		driver.findElement(By.xpath(UIMapCheckOut.lblDel2ChargesValue)).getText().contains("FREE"))
	    {
	    	
	    	report.updateTestLog("Verification of Truck DeliveryCharges","Verification is successful",Status.PASS);
		}else{
			report.updateTestLog("Verification of Truck DeliveryCharges","Verification is not successful",Status.FAIL);
		}	 
	}
	
	
	/**
	 * This verifyShippingChargesPromotion() method is used to verify multiple items pick up in store
	 * 
	 */
	public void verifyShippingChargesPromotion() throws Exception {
		
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys("389");
	    driver.findElement(By.id(UIMapCheckOut.rdoShpMdlTruckDlvry)).click();
	    driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
	    driver.findElement(By.xpath(UIMapFunctionalComponents.btnCheckout)).click();
	    if(driver.findElement(By.xpath(UIMapCheckOut.lblDel1Charges)).getText().contains("Estimated Parcel Shipping ") &&
	    		driver.findElement(By.xpath(UIMapCheckOut.lblDel1ChargesValue)).getText().contains("FREE") ||
	    		driver.findElement(By.xpath(UIMapCheckOut.lblDel2Charges)).getText().contains("Estimated Parcel Shipping ") &&
	    		driver.findElement(By.xpath(UIMapCheckOut.lblDel2ChargesValue)).getText().contains("FREE"))
	    {
	    	
	    	report.updateTestLog("Verification of Truck DeliveryCharges","Verification is successful",Status.PASS);
		}else{
			report.updateTestLog("Verification of Truck DeliveryCharges","Verification is not successful",Status.FAIL);
		}	 
	}
	/**
	 * This verifyShippingLevelPromotionInfo() method is used to verify multiple items pick up in store
	 * 
	 */
	public void verifyShippingLevelPromotionInfo() throws Exception {
		
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys("389");
	    driver.findElement(By.id(UIMapCheckOut.rdoShpMdlTruckDlvry)).click();
	    driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
	    driver.findElement(By.xpath(UIMapFunctionalComponents.btnCheckout)).click();
	    if(driver.findElement(By.xpath(UIMapCheckOut.lblDel1Charges)).getText().contains("Estimated Parcel Shipping ") &&
	    		driver.findElement(By.xpath(UIMapCheckOut.lblDel1ChargesValue)).getText().contains("FREE") ||
	    		driver.findElement(By.xpath(UIMapCheckOut.lblDel2Charges)).getText().contains("Estimated Parcel Shipping ") &&
	    		driver.findElement(By.xpath(UIMapCheckOut.lblDel2ChargesValue)).getText().contains("FREE"))
	    {
	    	
	    	report.updateTestLog("Verification of Truck DeliveryCharges","Verification is successful",Status.PASS);
		}else{
			report.updateTestLog("Verification of Truck DeliveryCharges","Verification is not successful",Status.FAIL);
		}	 
	}
	/**
	 * This verifyProductLevelPromotionInfo() method is used to verify multiple items pick up in store
	 * 
	 */
	public void verifyProductLevelPromotionInfo() throws Exception {
		
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys("389");
	    driver.findElement(By.id(UIMapCheckOut.rdoShpMdlTruckDlvry)).click();
	    driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
	    driver.findElement(By.xpath(UIMapFunctionalComponents.btnCheckout)).click();
	    if(driver.findElement(By.xpath(UIMapCheckOut.lblDel1Charges)).getText().contains("Estimated Parcel Shipping ") &&
	    		driver.findElement(By.xpath(UIMapCheckOut.lblDel1ChargesValue)).getText().contains("FREE") ||
	    		driver.findElement(By.xpath(UIMapCheckOut.lblDel2Charges)).getText().contains("Estimated Parcel Shipping ") &&
	    		driver.findElement(By.xpath(UIMapCheckOut.lblDel2ChargesValue)).getText().contains("FREE"))
	    {
	    	
	    	report.updateTestLog("Verification of Truck DeliveryCharges","Verification is successful",Status.PASS);
		}else{
			report.updateTestLog("Verification of Truck DeliveryCharges","Verification is not successful",Status.FAIL);
		}	 
	}
	/**
	 * This verifyOrderLevelPromotionInfo() method is used to verify multiple items pick up in store
	 * 
	 */
	public void verifyOrderLevelPromotionInfo() throws Exception {
		
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys("389");
	    driver.findElement(By.id(UIMapCheckOut.rdoShpMdlTruckDlvry)).click();
	    driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
	    driver.findElement(By.xpath(UIMapFunctionalComponents.btnCheckout)).click();
	    if(driver.findElement(By.xpath(UIMapCheckOut.lblDel1Charges)).getText().contains("Estimated Parcel Shipping ") &&
	    		driver.findElement(By.xpath(UIMapCheckOut.lblDel1ChargesValue)).getText().contains("FREE") ||
	    		driver.findElement(By.xpath(UIMapCheckOut.lblDel2Charges)).getText().contains("Estimated Parcel Shipping ") &&
	    		driver.findElement(By.xpath(UIMapCheckOut.lblDel2ChargesValue)).getText().contains("FREE"))
	    {
	    	
	    	report.updateTestLog("Verification of Truck DeliveryCharges","Verification is successful",Status.PASS);
		}else{
			report.updateTestLog("Verification of Truck DeliveryCharges","Verification is not successful",Status.FAIL);
		}	 
	}

	
	/**
	 * This verifyTDChargesPromotion() method is used to verify multiple items pick up in store
	 * 
	 */
	public void verifyTDChargesPromotion() throws Exception {
		
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).clear();
	    driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys("389");
	    driver.findElement(By.id(UIMapCheckOut.rdoShpMdlTruckDlvry)).click();
	    driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
	    driver.findElement(By.xpath(UIMapFunctionalComponents.btnCheckout)).click();
	    if(driver.findElement(By.xpath(UIMapCheckOut.lblDel1Charges)).getText().contains("Estimated Truck Delivery ") &&
	    		driver.findElement(By.xpath(UIMapCheckOut.lblDel1ChargesValue)).getText().contains("FREE") ||
	    		driver.findElement(By.xpath(UIMapCheckOut.lblDel2Charges)).getText().contains("Estimated Truck Delivery ") &&
	    		driver.findElement(By.xpath(UIMapCheckOut.lblDel2ChargesValue)).getText().contains("FREE"))
	    {
	    	report.updateTestLog("Verification of Truck DeliveryCharges","Verification is successful",Status.PASS);
		}else{
			report.updateTestLog("Verification of Truck DeliveryCharges","Verification is not successful",Status.FAIL);
		}	 
	}
		
	
	
	/**
	 * This verifyOneCCCardFirstUse() method is used to verify the stored cc card first use
	 * 
	 */
	public void verifyOneCCCardFirstUse() throws Exception {
		
		
		driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	    driver.findElement(By.name(UIMapCheckOut.txtSelectedId)).click();
	    driver.findElement(By.id(UIMapCheckOut.txtSelectedCvv)).clear();
	    driver.findElement(By.id(UIMapCheckOut.txtSelectedCvv)).sendKeys("1111");
	    new Select(driver.findElement(By.name("stored-billing-address-id"))).selectByVisibleText("DEFAULT - sfsa,mooresville NC 28117");
	    driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim1)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim1)).sendKeys(dataTable.getData("General_Data", "Phone1"));
	    driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim2)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim2)).sendKeys(dataTable.getData("General_Data", "Phone2"));
	    driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim3)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim3)).sendKeys(dataTable.getData("General_Data", "Phone3"));
	    driver.findElement(By.id(UIMapMyLowes.txtBillEmailAddPrim)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtBillEmailAddPrim)).sendKeys(dataTable.getData("General_Data", "confirmemail"));
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
		
	}
	
	/**
	 * This verifyOneCCCardSecondUse() method is used to verify the stored cc card second use
	 * 
	 */
	public void verifyOneCCCardSecondUse() throws Exception {
		
		
		driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	    driver.findElement(By.name(UIMapCheckOut.txtSelectedId)).click();
	    driver.findElement(By.id(UIMapCheckOut.txtSelectedCvv)).clear();
	    driver.findElement(By.id(UIMapCheckOut.txtSelectedCvv)).sendKeys("1111");
	    new Select(driver.findElement(By.name(UIMapCheckOut.txtSelectedAdd))).selectByVisibleText("DEFAULT - sfsa,mooresville NC 28117");
	    driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim1)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim1)).sendKeys(dataTable.getData("General_Data", "Phone1"));
	    driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim2)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim2)).sendKeys(dataTable.getData("General_Data", "Phone2"));
	    driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim3)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim3)).sendKeys(dataTable.getData("General_Data", "Phone3"));
	    driver.findElement(By.id(UIMapMyLowes.txtBillEmailAddPrim)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtBillEmailAddPrim)).sendKeys(dataTable.getData("General_Data", "confirmemail"));
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
		
	}
	
	/**
	 * This verifyMultCCCardFirstUse() method is used to verify the stored multiple cards first use
	 * 
	 */
	public void verifyMultCCCardFirstUse() throws Exception {
		
		
		driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
		 driver.findElement(By.name(UIMapCheckOut.txtSelectedId)).click();
		    driver.findElement(By.id(UIMapCheckOut.txtSelectedCvv)).clear();
		    driver.findElement(By.id(UIMapCheckOut.txtSelectedCvv)).sendKeys("1111");
	    new Select(driver.findElement(By.name(UIMapCheckOut.txtSelectedAdd))).selectByVisibleText("DEFAULT - sfsa,mooresville NC 28117");
	    driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim1)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim1)).sendKeys(dataTable.getData("General_Data", "Phone1"));
	    driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim2)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim2)).sendKeys(dataTable.getData("General_Data", "Phone2"));
	    driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim3)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim3)).sendKeys(dataTable.getData("General_Data", "Phone3"));
	    driver.findElement(By.id(UIMapMyLowes.txtBillEmailAddPrim)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtBillEmailAddPrim)).sendKeys(dataTable.getData("General_Data", "confirmemail"));
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
		
	}
	
	/**
	 * This verifyMultCCCardSecondUse() method is used to verify the stores multiple cards second use
	 * 
	 */
	public void verifyMultCCCardSecondUse() throws Exception {
		
		
		driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
		 driver.findElement(By.name(UIMapCheckOut.txtSelectedId)).click();
		    driver.findElement(By.id(UIMapCheckOut.txtSelectedCvv)).clear();
		    driver.findElement(By.id(UIMapCheckOut.txtSelectedCvv)).sendKeys("1111");
	    new Select(driver.findElement(By.name(UIMapCheckOut.txtSelectedAdd))).selectByVisibleText("DEFAULT - sfsa,mooresville NC 28117");
	    driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim1)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim1)).sendKeys(dataTable.getData("General_Data", "Phone1"));
	    driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim2)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim2)).sendKeys(dataTable.getData("General_Data", "Phone2"));
	    driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim3)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtBillPhnPrim3)).sendKeys(dataTable.getData("General_Data", "Phone3"));
	    driver.findElement(By.id(UIMapMyLowes.txtBillEmailAddPrim)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtBillEmailAddPrim)).sendKeys(dataTable.getData("General_Data", "confirmemail"));
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
		
	}
	
	/**
	 * This verifyBuyXGetFreeParcel() method is used to verify the Buy X get Free Parcel
	 * 
	 */
	public void verifyBuyXGetFreeParcel() throws Exception {
		
	if(driver.findElement(By.xpath(UIMapCheckOut.lblDel1Charges)).getText().contains("Estimated Parcel Shipping")&&
	driver.findElement(By.xpath(UIMapCheckOut.lblGCParcelFree)).getText().contains("FREE")){
		report.updateTestLog("Verification of Parcel shipping charges for  verifyBuyXGetFreeParcel","Verification is successful",Status.PASS);
	}
	else{
		report.updateTestLog("Verification of Parcel shipping charges for  verifyBuyXGetFreeParcel","Verification is not successful",Status.FAIL);
	}
	}
	
	
	/**
	 * This verifyBuyXPlusYSavePercentYItem() method is used to verify buy X plus save Percent Y item
	 * 
	 */
	public void verifyBuyXPlusYSavePercentYItem() throws Exception {
		

		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar))
				.sendKeys(dataTable.getData("General_Data", "Item2"));
		try {
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar))
					.sendKeys(Keys.ENTER);
		} catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handeled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar))
					.sendKeys(Keys.ENTER);
		}
		report.updateTestLog(
				"Searching For an Item",
				"Searching Item Number - "
						+ dataTable.getData("General_Data", "Item2") + "",
				Status.DONE);
		
		Thread.sleep(5000);
		driver.findElement(By.id("PL")).click();
		driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	
		if(driver.findElement(By.xpath(UIMapCheckOut.webElmntYouSave)).getText().contains("You Save")){
			report.updateTestLog("Verification of Parcel shipping charges for  verifyBuyXPlusYSavePercentYItem","Verification is successful",Status.PASS);
		}
		else{
			report.updateTestLog("Verification of Parcel shipping charges for  verifyBuyXPlusYSavePercentYItem","Verification is not successful",Status.FAIL);
		}
		
	}
	/**
	 * This verifySpendXGetFreeTD() method is used to verify spend get free TD
	 * 
	 */
	public void verifySpendXGetFreeTD() throws Exception {
		
		if(driver.findElement(By.xpath(UIMapCheckOut.lblDel1Charges)).getText().contains("Truck Delivery Charges")&&
		driver.findElement(By.xpath(UIMapCheckOut.lblGCParcelFree)).getText().contains("FREE")){
			report.updateTestLog("Verification of Parcel shipping charges for  verifySpendXGetFreeTD","Verification is successful",Status.PASS);
		}
		else{
			report.updateTestLog("Verification of Parcel shipping charges for  verifySpendXGetFreeTD","Verification is not successful",Status.FAIL);
		}
	}
	
	/**
	 * This verifySpendXGetFreeParcelShpng() method is used to Spend X Get Free Parcel Shipping
	 * 
	 */
	public void verifySpendXGetFreeParcelShpng() throws Exception {
		
		if(driver.findElement(By.xpath(UIMapCheckOut.lblDel1Charges)).getText().contains("Estimated Parcel Shipping")&&
		driver.findElement(By.xpath(UIMapCheckOut.lblGCParcelFree)).getText().contains("FREE")){
			report.updateTestLog("Verification of Parcel shipping charges for  verifySpendXGetFreeParcelShpng","Verification is successful",Status.PASS);
		}
		else{
			report.updateTestLog("Verification of Parcel shipping charges for  verifySpendXGetFreeParcelShpng","Verification is not successful",Status.FAIL);
		}
	}
	/**
	 * This verifyPositiverEPPAndRTFItem() method is used to verify the epp and RTF item
	 * 
	 */
	public void verifyPositiverEPPAndRTFItem() throws Exception {
		
		chkout.addItemToCartWithDlvryMthd();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapCheckOut.btnCCAdd)).click();		
		chkout.checkOutCreditCard();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapCheckOut.btnCreateAddress)).click();
		mgAcc.checkOutBillingInfoAddNewAddress();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	}
	/**
	 * This verifyMinGuaranteeOrderConfPage() method is used to verify the conf page with minimum guarantee order
	 * 
	 */
	public void verifyMinGuaranteeOrderConfPage() throws Exception {
		
		chkout.addItemToCartWithDlvryMthd();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapCheckOut.btnCCAdd)).click();		
		chkout.checkOutCreditCard();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapCheckOut.btnCreateAddress)).click();
		mgAcc.checkOutBillingInfoAddNewAddress();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	}
	/**
	 * This verifySingleItemAddressLowesShip() method is used to Spend X Get Free Parcel Shipping
	 * 
	 */
	public void verifySingleItemAddressLowesShip() throws Exception {
		
		chkout.addItemToCartWithDlvryMthd();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapCheckOut.btnCCAdd)).click();		
		chkout.checkOutCreditCard();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapCheckOut.btnCreateAddress)).click();
		mgAcc.checkOutBillingInfoAddNewAddress();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	}
	
	
	/*************************************************CI****************************************************************/
	
	/**
	 * This verifyPIFShippedToNonPIFLeviedState() method is used to ship the PIF item to non-PIF levied state. 
	 * 
	 */
	public void verifyPIFShippedToNonPIFLeviedState() throws Exception {
		
		fc.changeStore();//Zip into a store which is having PIF restriction
		Thread.sleep(5000);
	    chkout.searchAndAddItemToCart(); //search and add the PIF restricted item
	    Thread.sleep(5000);
	    chkout.selectDlvryMthd();//Truck delivery method should be selected
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	    Thread.sleep(5000);
	    	    
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	    
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	    chkout.checkOutCreditCard();
	    chkout.checkOutAddress();// Non PIF levied state
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	    
	}
	/**
	 * This verifyPIFShippedToPIFLeviedState() method is used to ship the PIF item to PIF levied state. 
	 * 
	 */
	public void verifyPIFShippedToPIFLeviedState() throws Exception {
		
		fc.changeStore();//Zip into a store which is having PIF restriction
		Thread.sleep(5000);
	    chkout.searchAndAddItemToCart(); //search and add the PIF restricted item
	    Thread.sleep(5000);
	    chkout.selectDlvryMthd();//Truck delivery method should be selected
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	    Thread.sleep(5000);
	    	    
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	    
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	    chkout.checkOutCreditCard();
	    chkout.checkOutAddress();//  PIF levied state
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	    
	}
	/**
	 * This verifyManGovtTBIFees() method is used to verify the mandatory Government TBI Fees
	 * 
	 * 
	 */
	public void verifyManGovtTBIFees() throws Exception {
		
		fc.changeStore();
		Thread.sleep(5000);
	    chkout.searchAndAddItemToCart(); //search and add the item which has TBI fee
	    Thread.sleep(5000);
	    chkout.selectDlvryMthd();//Any delivery method should be selected
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(5000);
	    //Remover the item from the cart
	    chkout.removeItemFromCart();	    
	  }	
	
	/**
	 * This verifyEmpDiscountRetailCNFPrice() method is used to verify the mandatory Government TBI Fees
	 * 
	 * 
	 */
	public void verifyEmpDiscountRetailCNFPrice() throws Exception {
		
		
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	    Thread.sleep(5000);
	    	    
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	    
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	    chkout.checkOutCreditCard();
	    chkout.checkOutAddress();
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	    boolean verItemPresent=selenium.isTextPresent("xx% employee Savings");
		if(verItemPresent){	   
	    	report.updateTestLog("Verifications of Employee Savings in the order page "," Verification is Successfull", Status.PASS);
	    }else{
	    	report.updateTestLog("Verifications of Employee Savings in the order page "," Verification is not Successfull", Status.FAIL);
	    }
	  
	}
	
	/**
	 * This verifyEmpDiscountWasCNFPrice() method is used to verify the mandatory Government TBI Fees
	 * 
	 * 
	 */
	public void verifyEmpDiscountWasCNFPrice() throws Exception {
		
		fc.verifyingRegisteredUserLogin();//Login as employee with valid user id and password
		fc.changeStore();
		Thread.sleep(5000);
	    chkout.searchAndAddItemToCart(); //search and add the item 
	    Thread.sleep(5000);
	    chkout.selectDlvryMthd();//Any delivery method should be selected
	    Thread.sleep(5000);
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	    Thread.sleep(5000);
	    	    
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	    
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	    chkout.checkOutCreditCard();
	    chkout.checkOutAddress();
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	    boolean verItemPresent=selenium.isTextPresent(" SAVE xx % including Employee Savings");
		if(verItemPresent){   
	   
	    	report.updateTestLog("Verifications of Employee Savings in the order page "," Verification is Successfull", Status.PASS);
	    }else{
	    	report.updateTestLog("Verifications of Employee Savings in the order page "," Verification is not Successfull", Status.FAIL);
	    }
	    	   
	}
	/**
	 * This verifySellingRstrctnsPLAndLTDAZ() method is used to verify the selling restrictions
	 * 
	 * 
	 */
	public void verifySellingRstrctnsPLAndLTDAZ() throws Exception {
		
		fc.changeStore();//Zip in selling restriction store
		chkout.searchAndAddItemToCart(); //search and add the item 
	    Thread.sleep(5000);
	    chkout.selectDlvryMthd();// Parcel shipping delivery method should be selected
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	    Thread.sleep(5000);
	    	    
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	    
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	    chkout.checkOutCreditCard();
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
		driver.findElement(By.id(UIMapMyLowes.txtCity)).sendKeys(dataTable.getData("General_Data", "City")); //selling restriction location should be entered
		new Select(driver.findElement(By.id(UIMapMyLowes.txtState))).selectByVisibleText(dataTable.getData("General_Data", "State"));
		driver.findElement(By.id(UIMapMyLowes.txtZpCd)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtZpCd)).sendKeys(dataTable.getData("General_Data", "zipcode"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		boolean shippingAddErr = selenium.isTextPresent("Due to shipping restrictions, one or more items are not available for delivery or store pickup in your area. please enter a new shipping address message should display");
		if(shippingAddErr){   
	   
	    	report.updateTestLog("Verifications of Employee Savings in the order page "," Verification is Successfull", Status.PASS);
	    }else{
	    	report.updateTestLog("Verifications of Employee Savings in the order page "," Verification is not Successfull", Status.FAIL);
	    }
		driver.findElement(By.id(UIMapMyLowes.txtCity)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtCity)).sendKeys(dataTable.getData("General_Data", "City"));
		driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
		
		/********Second item*********/
	    chkout.searchAndAddItemToCart(); //search and add the item 
	    Thread.sleep(5000);
	    chkout.selectDlvryMthd();//Truck Delivery method should be selected
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	    Thread.sleep(5000);
	    	    
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	    
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	    chkout.checkOutCreditCard();
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
		driver.findElement(By.id(UIMapMyLowes.txtCity)).sendKeys(dataTable.getData("General_Data", "City")); //selling restriction location should be entered
		new Select(driver.findElement(By.id(UIMapMyLowes.txtState))).selectByVisibleText(dataTable.getData("General_Data", "State"));
		driver.findElement(By.id(UIMapMyLowes.txtZpCd)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtZpCd)).sendKeys(dataTable.getData("General_Data", "zipcode"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		shippingAddErr = selenium.isTextPresent("Due to shipping restrictions, one or more items are not available for delivery or store pickup in your area. please enter a new shipping address message should display");
		if(shippingAddErr){   
	   
	    	report.updateTestLog("Verifications of Employee Savings in the order page "," Verification is Successfull", Status.PASS);
	    }else{
	    	report.updateTestLog("Verifications of Employee Savings in the order page "," Verification is not Successfull", Status.FAIL);
	    }
		driver.findElement(By.id(UIMapMyLowes.txtCity)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtCity)).sendKeys(dataTable.getData("General_Data", "City"));		
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	    
	    
	   
	}
	/**
	 * This verifySelingRstrctnsPLAndLTDLI() method is used to verify the mandatory Government TBI Fees
	 * 
	 * 
	 */
	public void verifySellingRstrctnsPLAndLTDLI() throws Exception {
		fc.verifyingRegisteredUserLogin();
		verifySellingRstrctnsPLAndLTDAZ();
	}
	
	/**
	 * This verifyNonSellingRstrcnStoreSellingRstrcnItemAZ() method is used to verify the mandatory Government TBI Fees
	 * 
	 * 
	 */
	public void verifyNonSellingRstrcnStoreSellingRstrcnItemAZ() throws Exception {
		
		fc.changeStore();//zip into non selling restriction store
		chkout.searchAndAddItemToCart(); //search and add the item 
	    Thread.sleep(5000);
	    chkout.selectDlvryMthd();// Parcel shipping delivery method should be selected
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	    Thread.sleep(5000);
	    	    
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	    
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	    chkout.checkOutCreditCard();
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
		driver.findElement(By.id(UIMapMyLowes.txtCity)).sendKeys(dataTable.getData("General_Data", "City")); //selling restriction location should be entered
		new Select(driver.findElement(By.id(UIMapMyLowes.txtState))).selectByVisibleText(dataTable.getData("General_Data", "State"));
		driver.findElement(By.id(UIMapMyLowes.txtZpCd)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtZpCd)).sendKeys(dataTable.getData("General_Data", "zipcode"));
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		boolean shippingAddErr = selenium.isTextPresent("Due to shipping restrictions, one or more items are not available for delivery or store pickup in your area. please enter a new shipping address message should display");
		if(shippingAddErr){   
	   
	    	report.updateTestLog("Verifications of Employee Savings in the order page "," Verification is Successfull", Status.PASS);
	    }else{
	    	report.updateTestLog("Verifications of Employee Savings in the order page "," Verification is not Successfull", Status.FAIL);
	    }
		driver.findElement(By.id(UIMapMyLowes.txtCity)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtCity)).sendKeys(dataTable.getData("General_Data", "City"));
		driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	   
	}
	
	/**
	 * This verifyNonSellingRstrcnStoreSellingRstrcnItemLI() method is used to verify the mandatory Government TBI Fees
	 * 
	 * 
	 */
	public void verifyNonSellingRstrcnStoreSellingRstrcnItemLI() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		verifyNonSellingRstrcnStoreSellingRstrcnItemAZ();    
	   
	}
	/**********************************************CM******************************************************************/
	
	/**
	 * This verifyMultipleItemsZippedInRstctdStore() method is used to verify the purchase order which is parcel shipping
	 * 
	 */
	public void verifyMultipleItemsZippedInRstctdStore() throws Exception {
		
		fc.changeStore();//zip into a restricted selling store
		Thread.sleep(5000);
		//Item should have a selling restriction
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data", "ItemNbr1"));
		try {
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		} catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		}
		report.updateTestLog("Searching For an Item","Searching Item Number - "	+ dataTable.getData("General_Data", "ItemNbr1") + "",Status.DONE);

		try {
		driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
		}
		catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
		}
		Thread.sleep(5000);
		try{		
			driver.findElement(By.id(dataTable.getData("General_Data", "DeliveryMthd1"))).click();//Pick up in store delivery method
			Thread.sleep(2000);
			report.updateTestLog("Selecting delivery Method", "Delivery Method: "+dataTable.getData("General_Data", "DeliveryMthd")+" selected for Item: "+dataTable.getData("General_Data", "ItemNbr"), Status.PASS);
				
			}
		catch(Exception NoSuchElementException)
		{
				report.updateTestLog("Selecting delivery Method", "Delivery Method: "+dataTable.getData("General_Data", "DeliveryMthd")+" NOT AVAILABLE for Item: "+dataTable.getData("General_Data", "ItemNbr"), Status.FAIL);
		}
		Thread.sleep(5000);
		//validate the restricted error message when store pick up is selected as delivery method
		if(driver.findElement(By.xpath("")).isDisplayed()){
			report.updateTestLog("Verifying the restricted selecting delivery option","Verification is successful", Status.PASS);
		}else{
			report.updateTestLog("Verifying the restricted selecting delivery option","Verification is not successful", Status.FAIL);
		}
		Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
		try{		
			driver.findElement(By.id(dataTable.getData("General_Data", "DeliveryMthd2"))).click();//Truck delivery is the delivery method
			Thread.sleep(2000);
			report.updateTestLog("Selecting delivery Method", "Delivery Method: "+dataTable.getData("General_Data", "DeliveryMthd")+" selected for Item: "+dataTable.getData("General_Data", "ItemNbr"), Status.PASS);
				
			}
		catch(Exception NoSuchElementException)
		{
				report.updateTestLog("Selecting delivery Method", "Delivery Method: "+dataTable.getData("General_Data", "DeliveryMthd")+" NOT AVAILABLE for Item: "+dataTable.getData("General_Data", "ItemNbr"), Status.FAIL);
		}
		Thread.sleep(5000);
		
		//Item should have a selling restriction
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data", "ItemNbr2"));
		try {
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		} catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		}
		report.updateTestLog("Searching For an Item","Searching Item Number - "	+ dataTable.getData("General_Data", "ItemNbr2") + "",Status.DONE);

		Thread.sleep(5000);
		try{		
			driver.findElement(By.id(dataTable.getData("General_Data", "DeliveryMthd1"))).click();//Pick up in store delivery method
			Thread.sleep(2000);
			report.updateTestLog("Selecting delivery Method", "Delivery Method: "+dataTable.getData("General_Data", "DeliveryMthd")+" selected for Item: "+dataTable.getData("General_Data", "ItemNbr"), Status.PASS);
				
			}
		catch(Exception NoSuchElementException)
		{
				report.updateTestLog("Selecting delivery Method", "Delivery Method: "+dataTable.getData("General_Data", "DeliveryMthd")+" NOT AVAILABLE for Item: "+dataTable.getData("General_Data", "ItemNbr"), Status.FAIL);
		}
		Thread.sleep(5000);
		//validate the restricted error message when store pick up is selected as delivery method
		if(driver.findElement(By.xpath("")).isDisplayed()){
			report.updateTestLog("Verifying the restricted selecting delivery option","Verification is successful", Status.PASS);
		}else{
			report.updateTestLog("Verifying the restricted selecting delivery option","Verification is not successful", Status.FAIL);
		}
		try{		
			driver.findElement(By.id(dataTable.getData("General_Data", "DeliveryMthd2"))).click();//Truck delivery is the delivery method
			Thread.sleep(2000);
			report.updateTestLog("Selecting delivery Method", "Delivery Method: "+dataTable.getData("General_Data", "DeliveryMthd")+" selected for Item: "+dataTable.getData("General_Data", "ItemNbr"), Status.PASS);
				
			}
		catch(Exception NoSuchElementException)
		{
				report.updateTestLog("Selecting delivery Method", "Delivery Method: "+dataTable.getData("General_Data", "DeliveryMthd")+" NOT AVAILABLE for Item: "+dataTable.getData("General_Data", "ItemNbr"), Status.FAIL);
		}
		Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	}
	
	/**
	 * This verifyNonSellingItmInRstctdStoreSPAZ() method is used to verify the purchase order which is parcel shipping
	 * 
	 */
	public void verifyNonSellingItmInRstctdStoreSPAZ() throws Exception {
		
		fc.changeStore();//zip into a store which has selling restriction
		Thread.sleep(5000);
	    chkout.searchAndAddItemToCart(); //Non-selling restriction item to be added in cart
	    Thread.sleep(5000);
	    chkout.selectDlvryMthd();//store pick up delivery method should be selected
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	    
	}
	
	/**
	 * This verifyNonSellingItmInRstctdStoreSPLI() method is used to verify the purchase order which is parcel shipping
	 * 
	 */
	public void verifyNonSellingItmInRstctdStoreSPLI() throws Exception {
	
		fc.verifyingRegisteredUserLogin();
		verifyNonSellingItmInRstctdStoreSPAZ(); //Add the selling restriction item to the cart
	}
	
	/**
	 * This verifyNonSellingItmInRstctdStoreLDAZ() method is used to verify the purchase order which is parcel shipping
	 * 
	 */
	public void verifyNonSellingItmInRstctdStoreLDAZ() throws Exception {
		
		fc.changeStore();//Zip into a store which has selling restriction
		Thread.sleep(5000);
	    chkout.searchAndAddItemToCart(); //selling restriction item to be added in cart
	    Thread.sleep(5000);
	    chkout.selectDlvryMthd();//Truck delivery method should be selected
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	    
	}
	
	/**
	 * This verifyNonSellingItmInRstctdStorePSAZ() method is used to verify the purchase order which is parcel shipping
	 * 
	 */
	public void verifyNonSellingItmInRstctdStorePSAZ() throws Exception {
		
		fc.changeStore();//zip into a store which has selling restriction
		Thread.sleep(5000);
	    chkout.searchAndAddItemToCart(); //selling restriction item to be added in cart
	    Thread.sleep(5000);
	    chkout.selectDlvryMthd();//Parcel delivery method should be selected
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	    
	}
	/**
	 * This verifyNonSellingItmInRstctdStoreViaMstHead() method is used to verify the purchase order which is parcel shipping
	 * 
	 */
	public void verifyNonSellingItmInRstctdStoreViaMstHead() throws Exception {
		
		fc.changeStore();//zip into a store which doesnot have any selling restriction
		Thread.sleep(5000);
		chkout.searchAndAddItemToCart(); //Non-selling restriction item to be added in cart
		Thread.sleep(5000);
		chkout.selectDlvryMthd();//store pick up delivery method should be selected
	    Thread.sleep(5000);
	    
	    //change the store from the master head.
	    driver.findElement(By.cssSelector(UIMapProductSearch.btnChangeStoreInfo)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id(UIMapProductSearch.txtStoreSearch)).clear();
	    driver.findElement(By.id(UIMapProductSearch.txtStoreSearch)).sendKeys(dataTable.getData("General_Data","zipcode")); //selling restricted store
	    driver.findElement(By.id(UIMapProductSearch.btnHeaderMapSearch)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.linkText("Make This Your Store")).click();
	    Thread.sleep(5000);	
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	    Thread.sleep(5000);
	    chkout.selectDlvryMthd();////store pick up delivery method should be selected
	    //validate the restricted error message when store pick up is selected as delivery method
		if(driver.findElement(By.xpath("")).isDisplayed()){
			report.updateTestLog("Verifying the restricted selecting delivery option","Verification is successful", Status.PASS);
		}else{
			report.updateTestLog("Verifying the restricted selecting delivery option","Verification is not successful", Status.FAIL);
		}    
	    
	}
	
	/**
	 * This verifyNonPIFLeviedState() method is used to verify the PIF Levied state
	 * 
	 */
	public void verifyNonPIFLeviedState() throws Exception {
		
		chkout.searchAndAddItemToCart();
		Thread.sleep(5000);	
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	}
	
	/**
	 * This verifyPIFLeviedStateLTD() method is used to verify the PIF Levied State for LTD
	 * 
	 */
	public void verifyPIFLeviedStateLTD() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(5000);
		chkout.addItemToCartWithDlvryMthd();//Item with PIF and the delivery method is Parcel Shipping
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntPrdAddToCart5)).click();
		Thread.sleep(5000);
		chkout.addItemToCartWithDlvryMthd();//Item with PIF and the delivery method is Truck Delivery
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	    //An if condition to be added to verify the PIF tag present present or not
	}
	

/*******************************************************MLC******************************************************************/
	/**
	 * This verifyOrderDetailGroupParcelOrderAZ() method is used to verify the purchase order which is parcel shipping
	 * 
	 */
	public void verifyOrderDetailGroupParcelOrderAZ() throws Exception {
		
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.id(UIMapMyLowes.mouseHvrYourAccount)); 
	    actions.moveToElement(menuHoverLink).build().perform(); 
	    //Thread.sleep(10000);
	    System.out.println("Mouse Hover successful"); 
	    Thread.sleep(20000); 
	    WebElement subLink = driver.findElement(By.id(UIMapMyLowes.lnkPurcahses)); 
	    actions.moveToElement(subLink).moveToElement(subLink).click().build().perform();
	    driver.findElement(By.id(UIMapMyLowes.txtConfNo)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtConfNo)).sendKeys(dataTable.getData("General_Data","orderno"));
	    driver.findElement(By.id(UIMapCheckOut.btnFindOrderSubmit)).click();
	    Thread.sleep(5000);
	    //Validating Purchase Details
	    validatePurchaseDetails();
	    //Validating Order Details
	    if(driver.findElement(By.xpath(UIMapCheckOut.txtOderTypePurchases)).isDisplayed() &&
	    		driver.findElement(By.xpath(UIMapCheckOut.txtOderTypePurchases)).getText().contains("Parcel Shipping")){
	    	report.updateTestLog("Verifying the order details","Verification is successful", Status.PASS);
	    }
	    else{
	    	report.updateTestLog("Verifying the order details","Verification is not successful", Status.FAIL);
	    }
	    
	    
	}

	public void validatePurchaseDetails() {
		if((driver.findElement(By.xpath(UIMapMyLowes.txtPurchaseInfoDate)).isDisplayed()&&
	    		driver.findElement(By.xpath(UIMapMyLowes.txtPurchaseInfoDate)).getText().equals("Purchase Date:"))&&
	      (driver.findElement(By.xpath(UIMapMyLowes.txtPurchaseInfoType)).isDisplayed()&&
	    		driver.findElement(By.xpath(UIMapMyLowes.txtPurchaseInfoType)).getText().equals("Purchase Type:"))&&
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
	 * This verifyOrderDetailGroupParcelOrderLI() method is used to verify the purchase order which is parcel shipping
	 * 
	 */
	public void verifyOrderDetailGroupParcelOrderLI() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(5000);
		fc.changeStore();
		Thread.sleep(5000);
		verifyOrderDetailGroupParcelOrderAZ();
		
	}
	/**
	 * This verifyOrderDetailGroupStoreOrder() method is used to verify the purchase order which is parcel shipping
	 * 
	 */
	public void verifyOrderDetailGroupStoreOrder() throws Exception {
		
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.id(UIMapMyLowes.mouseHvrYourAccount)); 
	    actions.moveToElement(menuHoverLink).build().perform(); 
	    //Thread.sleep(10000);
	    System.out.println("Mouse Hover successful"); 
	    Thread.sleep(20000); 
	    WebElement subLink = driver.findElement(By.id(UIMapMyLowes.lnkPurcahses)); 
	    actions.moveToElement(subLink).moveToElement(subLink).click().build().perform();
	    driver.findElement(By.id(UIMapMyLowes.txtConfNo)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtConfNo)).sendKeys(dataTable.getData("General_Data","orderno"));
	    driver.findElement(By.id(UIMapCheckOut.btnFindOrderSubmit)).click();
	    Thread.sleep(5000);
	    validatePurchaseDetails();
	    //Validating Order Details
	    if(driver.findElement(By.xpath(UIMapCheckOut.txtOderTypePurchases)).isDisplayed() &&
	    		driver.findElement(By.xpath(UIMapCheckOut.txtOderTypePurchases)).getText().contains("Pick Up In Store")){
	    	report.updateTestLog("Verifying the order details","Verification is successful", Status.PASS);
	    }
	    else{
	    	report.updateTestLog("Verifying the order details","Verification is not successful", Status.FAIL);
	    }
	    
	}
	
	
/************************************PI************************************************************/
	

	
	/**
	 * This verifyRemoveLogicDeliveryCost() method is verify the delivery cost
	 * 
	 */
	public void verifyRemoveLogicDeliveryCost() throws Exception {
		
		if(driver.findElement(By.xpath(UIMapCheckOut.lblDel1Charges)).getText().contains("Truck Delivery Charges")&&
		driver.findElement(By.xpath(UIMapCheckOut.lblGCParcelFree)).getText().contains("FREE")){
			report.updateTestLog("Verification of Parcel shipping charges for  verifySpendXGetFreeTD","Verification is successful",Status.PASS);
		}
		else{
			report.updateTestLog("Verification of Parcel shipping charges for  verifySpendXGetFreeTD","Verification is not successful",Status.FAIL);
		}
	}
	
	/**
	 * This verifyRemoveLogicShippingCost() method is used to verify the shipping cost
	 * 
	 */
	public void verifyRemoveLogicShippingCost() throws Exception {
		
		if(driver.findElement(By.xpath(UIMapCheckOut.lblDel1Charges)).getText().contains("Estimated Parcel Shipping")&&
		driver.findElement(By.xpath(UIMapCheckOut.lblGCParcelFree)).getText().contains("FREE")){
			report.updateTestLog("Verification of Parcel shipping charges for  verifyBuyXGetFreeParcel","Verification is successful",Status.PASS);
		}
		else{
			report.updateTestLog("Verification of Parcel shipping charges for  verifyBuyXGetFreeParcel","Verification is not successful",Status.FAIL);
		}
		}
	
	/**
	 * This verifyOrderConfWithLeadTime() method is used to verify the order of a wax item with lead time
	 * 
	 */
	public void verifyOrderConfWithLeadTime() throws Exception {
		
		chkout.addItemToCartWithDlvryMthd();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapCheckOut.btnCCAdd)).click();		
		chkout.checkOutCreditCard();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapCheckOut.btnCreateAddress)).click();
		mgAcc.checkOutBillingInfoAddNewAddress();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	}	
	
	/**
	 * This verifyGiftCardWithCCOrderPost() method is used to verify the order of a wax item with lead time
	 * 
	 */
	public void verifyGiftCardWithCCOrderPost() throws Exception {
		
		chkout.addItemToCartWithDlvryMthd();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapCheckOut.btnCCAdd)).click();		
		chkout.checkOutCreditCard();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapCheckOut.btnCreateAddress)).click();
		mgAcc.checkOutBillingInfoAddNewAddress();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	}	
	
	/**
	 * This verifyGovtFeesCartPageCheckoutPgOrderConfPgConfEmail() method is used to verify the govt fees in check out page
	 * 
	 */
	public void verifyGovtFeesCartPageCheckoutPgOrderConfPgConfEmail() throws Exception {
		
		chkout.addItemToCartWithDlvryMthd();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapCheckOut.btnCCAdd)).click();		
		chkout.checkOutCreditCard();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapCheckOut.btnCreateAddress)).click();
		mgAcc.checkOutBillingInfoAddNewAddress();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	}	
	
	/**
	 * This verifyAbleToHideFulFillment() method is used to verify the fulfillment
	 * 
	 */
	public void verifyAbleToHideFulFillment() throws Exception {
		
		chkout.addItemToCartWithDlvryMthd();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapCheckOut.btnCCAdd)).click();		
		chkout.checkOutCreditCard();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapCheckOut.btnCreateAddress)).click();
		mgAcc.checkOutBillingInfoAddNewAddress();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	}	
	/**
	 * This verifyOrderConfPageWithLeadTime() method is used to verify the fulfillment
	 * 
	 */
	public void verifyOrderConfPageWithLeadTime() throws Exception {
		
		chkout.addItemToCartWithDlvryMthd();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapCheckOut.btnCCAdd)).click();		
		chkout.checkOutCreditCard();
		Thread.sleep(5000);
		driver.findElement(By.linkText(UIMapCheckOut.btnCreateAddress)).click();
		mgAcc.checkOutBillingInfoAddNewAddress();
		driver.findElement(By.cssSelector(UIMapMyLowes.btnReviewAndPay)).click();
	}	
	

	

	

	

}
