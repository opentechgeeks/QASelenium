package com.lowes.qa.selenium.scenarios;

import java.io.IOException;
import java.text.MessageFormat;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.xml.sax.SAXException;

import com.lowes.qa.selenium.ParallelizedTestBase;
import com.lowes.qa.selenium.categories.BuildVerificationTests;
import com.lowes.qa.selenium.categories.SmokeTests;
import com.lowes.qa.selenium.support.DriverScriptRegistry;

public class CheckoutBFTest extends ParallelizedTestBase {
	public CheckoutBFTest(String browserName, String version, String platform,
			String os) throws IOException, SAXException,
			ParserConfigurationException {
		super(browserName, version, platform, os);
		driver = DriverScriptRegistry.getDriverScript(MessageFormat.format(
				"{0}:{1}:{2}:{3}:{4}", browserName, version, platform, os, this
						.getClass().getName()), "CheckOut_BF");
	}

	@Test
	public void testSCAZVerifyThatThePromotionalCodesAreNotCaseSensitive() {
		driver.setCurrentTestCase("SC_AZ_Verify that the promotional codes are not case sensitive");
		driver.setCurrentTestCaseDescription("Verify that the promotional codes are not case sensitive");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIMultiItemsRemoveShipAddDelivery() {
		driver.setCurrentTestCase("SC_LI_MultiItems_Remove_Ship_Add_Delivery");
		driver.setCurrentTestCaseDescription("MultiItems_Remove_Ship_Add_Delivery");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZRetrievingCCCreditCardNickName() {
		driver.setCurrentTestCase("SC_AZ_Retrieving CC - Credit Card Nick Name");
		driver.setCurrentTestCaseDescription("Retrieving CC - Credit Card Nick Name");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZREMOVEPICKUPADDSHIP() {
		driver.setCurrentTestCase("SC_AZ_REMOVE_PICKUP_ADD_SHIP");
		driver.setCurrentTestCaseDescription("REMOVE_PICKUP_ADD_SHIP");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZObtainShippingChargesVendorDirect() {
		driver.setCurrentTestCase("SC_AZ_Obtain Shipping Charges - Vendor Direct");
		driver.setCurrentTestCaseDescription("Obtain Shipping Charges - Vendor Direct");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIRetrievingCCNoBillingAddress() {
		driver.setCurrentTestCase("SC_LI_Retrieving CC - No Billing Address");
		driver.setCurrentTestCaseDescription("Retrieving CC - No Billing Address");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIStoringTheFirstAndSecondCreditCard() {
		driver.setCurrentTestCase("SC_LI_Storing the first and second credit card");
		driver.setCurrentTestCaseDescription("Storing the first and second credit card");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testSCLCCPromotionUsingABOGOPromotion() {
		driver.setCurrentTestCase("SC_LCC Promotion using a BOGO promotion");
		driver.setCurrentTestCaseDescription("Promotion using a BOGO promotion");
		driver.driveTestExecution();
	}

	@Test
	public void testR634004TaxChargesSOMSTKPUSalesTaxNotComingAcross() {
		driver.setCurrentTestCase("R6_3.4_004_Tax Charges_SOM_STK_PU_sales tax not coming across");
		driver.setCurrentTestCaseDescription("Tax Charges_SOM_STK_PU_sales tax not coming across");
		driver.driveTestExecution();
	}

	@Test
	public void testFFNegative22ErrorSOMStkitemQtyMorethan5() {
		driver.setCurrentTestCase("FF_Negative22Error_SOM_StkitemQty_Morethan5");
		driver.setCurrentTestCaseDescription("SOM_StkitemQty_Morethan5");
		driver.driveTestExecution();
	}

	@Test
	public void testFFNegative22ErrorSOMStkwithMultipleItemsOneitemwithQty1OtherItemQtymorethan5() {
		driver.setCurrentTestCase("FF_Negative22Error_SOM_StkwithMultipleItems_oneitemwithQty1_OtherItemQtymorethan5");
		driver.setCurrentTestCaseDescription("SOM_StkwithMultipleItems_oneitemwithQty1_OtherItemQtymorethan5");
		driver.driveTestExecution();
	}

	@Test
	public void testFFNegative22ErrorSOMStkwithmultipleitemsEqualQty() {
		driver.setCurrentTestCase("FF_Negative22Error_SOM_Stkwithmultipleitems_EqualQty");
		driver.setCurrentTestCaseDescription("SOM_Stkwithmultipleitems_EqualQty");
		driver.driveTestExecution();
	}

	@Test
	public void testFFNegative22ErrorSOMMultipleitemsOneStkTDOneSOSStorePickup() {
		driver.setCurrentTestCase("FF_Negative22Error_SOM_Multipleitems_OneStk(TD)_OneSOS(StorePickup)");
		driver.setCurrentTestCaseDescription("SOM_Multipleitems_OneStk(TD)_OneSOS(StorePickup)");
		driver.driveTestExecution();
	}

	@Test
	public void testFFNegative22ErrorSOMMultipleitemsOneStkTDOneSOSParcelShipping() {
		driver.setCurrentTestCase("FF_Negative22Error_SOM_Multipleitems_OneStk(TD)_OneSOS(Parcel Shipping)");
		driver.setCurrentTestCaseDescription("SOM_Multipleitems_OneStk(TD)_OneSOS(Parcel Shipping)");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZSellingRestrictionsPL() {
		driver.setCurrentTestCase("SC_AZ_Selling restrictions_PL");
		driver.setCurrentTestCaseDescription("Selling restrictions_PL");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZSellingRestrictionsLTD() {
		driver.setCurrentTestCase("SC_AZ_Selling restrictions_LTD");
		driver.setCurrentTestCaseDescription("Selling restrictions_LTD");
		driver.driveTestExecution();
	}

	@Test
	@Category(BuildVerificationTests.class)
	public void testSCAZSimpleRegistrationInReviewAndPay() {
		driver.setCurrentTestCase("SC_AZ_Simple Registration in Review & Pay");
		driver.setCurrentTestCaseDescription("Simple Registration in Review & Pay");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIMultipleItemsSglAddressPickUpInStoreHaveLowesShipIt() {
		driver.setCurrentTestCase("SC_LI_Multiple Items_Sgl Address_Pick Up In Store_Have Lowes Ship It");
		driver.setCurrentTestCaseDescription("Multiple Items_Sgl Address_Pick Up In Store_Have Lowes Ship It");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLISecureCheckoutProcessMultipleItemsSingleAddressPickUpAndLowesTruckDelivery() {
		driver.setCurrentTestCase("SC_LI_ Secure Checkout process - Multiple Items - Single Address - Pick Up and Lowes Truck Delivery");
		driver.setCurrentTestCaseDescription(" Secure Checkout process - Multiple Items - Single Address - Pick Up and Lowes Truck Delivery");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZObtainTruckDeliveryChargesTDFREEItemLevel() {
		driver.setCurrentTestCase("SC_AZ_Obtain Truck Delivery Charges - TD FREE (item level)");
		driver.setCurrentTestCaseDescription("Obtain Truck Delivery Charges - TD FREE (item level)");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZObtainShippingChargesGiftCard() {
		driver.setCurrentTestCase("SC_AZ_Obtain Shipping Charges - Gift Card");
		driver.setCurrentTestCaseDescription("Obtain Shipping Charges - Gift Card");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZObtainShippingChargesPromotion() {
		driver.setCurrentTestCase("SC_AZ_Obtain Shipping Charges - Promotion");
		driver.setCurrentTestCaseDescription("Obtain Shipping Charges - Promotion");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZObtainTruckDeliveryChargesPromotion() {
		driver.setCurrentTestCase("SC_AZ_Obtain Truck Delivery Charges - Promotion");
		driver.setCurrentTestCaseDescription("Obtain Truck Delivery Charges - Promotion");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZPickupDeliveryAndShippingAddMultipleItems91215pcs() {
		driver.setCurrentTestCase("SC_AZ_Pickup, Delivery & Shipping_Add Multiple Items(9, 12, 15pcs)");
		driver.setCurrentTestCaseDescription("Pickup, Delivery & Shipping_Add Multiple Items(9, 12, 15pcs)");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIDeliveryAndShippingAddMultipleItems8101214pcs() {
		driver.setCurrentTestCase("SC_LI_Delivery & Shipping_Add Multiple Items(8, 10, 12, 14pcs)");
		driver.setCurrentTestCaseDescription("Delivery & Shipping_Add Multiple Items(8, 10, 12, 14pcs)");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testSCLIRetrievingCCOneCreditCardStoredFirstUse() {
		driver.setCurrentTestCase("SC_LI_Retrieving CC - One credit card stored - First use");
		driver.setCurrentTestCaseDescription("Retrieving CC - One credit card stored - First use");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIRetrievingCCOneCreditCardStoredSecondUse() {
		driver.setCurrentTestCase("SC_LI_Retrieving CC -One credit card stored - Second use");
		driver.setCurrentTestCaseDescription("Retrieving CC -One credit card stored - Second use");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIRetrievingCCMultipleCreditCardStoredFirstUse() {
		driver.setCurrentTestCase("SC_LI_Retrieving CC - Multiple credit card stored - First use");
		driver.setCurrentTestCaseDescription("Retrieving CC - Multiple credit card stored - First use");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIRetrievingCCMultipleCreditCardStoredFirstAndSecondUse() {
		driver.setCurrentTestCase("SC_LI_Retrieving CC - Multiple credit card stored - First and second use");
		driver.setCurrentTestCaseDescription("Retrieving CC - Multiple credit card stored - First and second use");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIStoringCreditCardAsPrimaryCard() {
		driver.setCurrentTestCase("SC_LI_Storing credit card as primary card");
		driver.setCurrentTestCaseDescription("Storing credit card as primary card");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZBuyXGetFreeParcel() {
		driver.setCurrentTestCase("SC_AZ_BuyXGetFreeParcel");
		driver.setCurrentTestCaseDescription("BuyXGetFreeParcel");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZBuyXYSavePercentInBothItems() {
		driver.setCurrentTestCase("SC_AZ_BuyX+Y SavePercent in both items");
		driver.setCurrentTestCaseDescription("BuyX+Y SavePercent in both items");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZBuyXYSavePercentOffInYItem() {
		driver.setCurrentTestCase("SC_AZ_BuyX+Y SavePercentOff in Y item");
		driver.setCurrentTestCaseDescription("BuyX+Y SavePercentOff in Y item");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZSpendXgetFreeTD() {
		driver.setCurrentTestCase("SC_AZ_SpendXgetFreeTD");
		driver.setCurrentTestCaseDescription("SpendXgetFreeTD");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZSpendXgetFreeParcelShipping() {
		driver.setCurrentTestCase("SC_AZ_SpendXgetFreeParcel Shipping");
		driver.setCurrentTestCaseDescription("SpendXgetFreeParcel Shipping");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIAllShippingAddMultipleItems715pcs() {
		driver.setCurrentTestCase("SC_LI_All Shipping_Add Multiple Items(7-15pcs)");
		driver.setCurrentTestCaseDescription("All Shipping_Add Multiple Items(7-15pcs)");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIMultipleItemsAndAddressesParcelShippingPickUpInStore() {
		driver.setCurrentTestCase("SC_LI_Multiple Items and Addresses_Parcel Shipping - Pick Up In Store");
		driver.setCurrentTestCaseDescription("Multiple Items and Addresses_Parcel Shipping - Pick Up In Store");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIPositiveEPPNoExtendedProtectionPlanAndRTFItemSelected() {
		driver.setCurrentTestCase("SC_LI_Positive-EPP(No Extended Protection Plan)&RTF item selected");
		driver.setCurrentTestCaseDescription("Positive-EPP(No Extended Protection Plan)&RTF item selected");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLI20MinuteGuaranteeOrderConfirmationPage() {
		driver.setCurrentTestCase("SC_LI_20 Minute Guarantee- Order Confirmation Page");
		driver.setCurrentTestCaseDescription("20 Minute Guarantee- Order Confirmation Page");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZSingleItemSingleAddressHaveLowesShipIt() {
		driver.setCurrentTestCase("SC_AZ_Single Item_ Single Address_Have Lowes Ship It");
		driver.setCurrentTestCaseDescription("Single Item_ Single Address_Have Lowes Ship It");
		driver.driveTestExecution();
	}
}
