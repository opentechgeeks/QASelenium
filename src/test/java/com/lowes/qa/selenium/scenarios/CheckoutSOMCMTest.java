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

public class CheckoutSOMCMTest extends ParallelizedTestBase {
	public CheckoutSOMCMTest(String browserName, String version,
			String platform, String os) throws IOException, SAXException,
			ParserConfigurationException {
		super(browserName, version, platform, os);
		driver = DriverScriptRegistry.getDriverScript(MessageFormat.format(
				"{0}:{1}:{2}:{3}:{4}", browserName, version, platform, os, this
						.getClass().getName()), "CheckOut_SOM_CM");
	}

	@Test
	public void testSCVerifyRegularCartMultipleDeliveryMethods() {
		driver.setCurrentTestCase("SC_Verify Regular Cart_Multiple Delivery Methods");
		driver.setCurrentTestCaseDescription("To validate that -Multiple Delivery methods work fine in Regular Cart after the implementation of Mini Cart functionality");
		driver.driveTestExecution();
	}

	@Test
	public void testSCVerifyQtyAmtGiftCardItemInCart() {
		driver.setCurrentTestCase(" SC_Verify Qty_Amt gift card item in Cart");
		driver.setCurrentTestCaseDescription("To verify  Minimum Quantity of Gift cards and the amount entered should not exceed the limit. Original TC Name: SC_Verify Minimum Quantity and Threshold amount for a gift card item in Cart");
		driver.driveTestExecution();
	}

	@Test
	public void testSCProductDescriptionLinkInRegularCartPage() {
		driver.setCurrentTestCase("SC_Product Description link in regular cart page");
		driver.setCurrentTestCaseDescription("To Validate Product Description link in regular cart page");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testSCRemoveSingleItemFromCart() {
		driver.setCurrentTestCase("SC_Remove Single item from cart");
		driver.setCurrentTestCaseDescription("To validate the remove functionality for a single item.");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testSCAZChangingEPPOptionsForAGivenItem() {
		driver.setCurrentTestCase("SC_AZ_Changing EPP options for a given item");
		driver.setCurrentTestCaseDescription("To validate behaviour of a cart when an EPP item is changed to 2 years,4 years & No Thanks. Original TC Name: SC_AZ_Changing EPP options for a given item (2yr, 4 yr, No Thanks, etc.)");
		driver.driveTestExecution();
	}

	@Test
	public void testSCVerifyEstimatedTruckDeliveryCharges() {
		driver.setCurrentTestCase("SC_Verify_Estimated Truck Delivery Charges");
		driver.setCurrentTestCaseDescription("To validate that estimated Truck Delivery work fine after the implementation of Mini Cart functionality.");
		driver.driveTestExecution();
	}

	@Test
	public void testSCVerifyEstimatedParcelShippingCharges() {
		driver.setCurrentTestCase("SC_Verify_Estimated Parcel Shipping Charges");
		driver.setCurrentTestCaseDescription("To validate that Estimated Parcel Shipping work fine after the implementation of Mini Cart functionality.");
		driver.driveTestExecution();
	}

	@Test
	public void testSCRemovingParentItemFromTheCartForRTFsIems() {
		driver.setCurrentTestCase("SC_Removing parent item from the Cart for RTFs iems");
		driver.setCurrentTestCaseDescription("To validate that the removal of a parent item should not remove the RTF item associated with it from the Cart.");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZDisplayRegularCartEPPSelected() {
		driver.setCurrentTestCase("SC_AZ_DisplayRegularCart _EPP selected");
		driver.setCurrentTestCaseDescription("This test case is to verify the customer should have the option to add, change or opt out of an EPP while in Regular Cart, regardless of whether or not they selected an EPP when adding the Parent item to Regular Cart,so that the customer has maximum flexibility; Original TC Name: SC_AZ_Display Regular Cart _With EPP selected on Product Detail Page");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZDisplayRegularCartEPPQuantityUpdateCheck() {
		driver.setCurrentTestCase("SC_AZ_Display Regular Cart _EPP Quantity Update Check");
		driver.setCurrentTestCaseDescription("This is to verify Display of Regular Cart for EPP Quantity Update Check.The customer should have the option to add, change or opt out of an EPP while in Regular Cart.");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZDisplayCart2ItemsOneEPPAnotherWithoutEPP() {
		driver.setCurrentTestCase("SC_AZ_DisplayCart 2Items_OneEPPAnother without EPP");
		driver.setCurrentTestCaseDescription("This test case is to veirfy the customer should have the option to add, change or opt out of an EPP while in Regular Cart, regardless of whether or not they selected an EPP when adding the Parent item to Regular Cart,so that the customer has maximum flexibility; Original TC Name: SC_AZ_Display Regular Cart _Two Items_One with EPP and Another without EPP");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZVerifyAllLinksButtons() {
		driver.setCurrentTestCase("SC_AZ_Verify all links,buttons");
		driver.setCurrentTestCaseDescription("This is to verify all new links,button,static text,headers,help messaging etc. on Regular Cart page are displayed and functioned properly as part of new INTERIM CART look & feel. Original TC Name: SC_AZ_Verify all links,buttons,help messaging,header,static text are displayed and fucntioned properly.");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZEmptyCartPageWhenItemRemovedFromCart() {
		driver.setCurrentTestCase("SC_AZ_EmptyCartPage when ItemRemovedFromCart");
		driver.setCurrentTestCaseDescription("To verify new Empty Cart page layout as per new design/comps. Original TC Name: SC_AZ_Empty Cart Page when Item is removed from Regular Cart");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZVerifyFREEPARCELInCartSummary() {
		driver.setCurrentTestCase("SC_AZ_Verify FREE PARCEL InCartSummary ");
		driver.setCurrentTestCaseDescription("This is to verify when free parcel shipping is anabled for an item in the cart than 'FREE' is displayed next to 'Estimated Flat Rate Delivery' label in Cart Summary section. Original TC Name: SC_AZ_Verify FREE is displayed in the Cart Summary Section when a item has free parcel shipping promotion enabled");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZVerifyFREETruckDelInCartSummary() {
		driver.setCurrentTestCase("SC_AZ_Verify FREE TruckDel InCartSummary ");
		driver.setCurrentTestCaseDescription("This is to verify when free Lowes truck delivery is anabled for an item in the cart than 'FREE' is displayed next to 'Estimated Parcel Shipping' label in Cart Summary section. Original TC Name: SC_AZ_Verify FREE is displayed in the Cart Summary section for an item when free Lowes Truck Delivery promotion enabled");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZVerifyYouSaveAmtDisplayeCartSummarySection() {
		driver.setCurrentTestCase(" SC_AZ_VerifyYouSaveAmt displayeCart Summary Section");
		driver.setCurrentTestCaseDescription("Original TC Name: SC_AZ_Verify You Save amount is displayed in the Cart Summary Section");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZVerifyStandardBusinessDaysDelieveryOption() {
		driver.setCurrentTestCase(" SC_AZ_Verify Standard Business Days Delievery option");
		driver.setCurrentTestCaseDescription("Verify Standard Business Days Delivery (Standard 3-7 Business Days) option text is changed in Estimated Shipping level dropdown. Original TC Name: SC_AZ_Verify Standard Business Days Delievery option text is changed");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIVerifyStandardBusinessDaysDelieveryOption() {
		driver.setCurrentTestCase(" SC_LI_Verify Standard Business Days Delievery option");
		driver.setCurrentTestCaseDescription("Verify Standard Business Days Delivery (Standard 3-7 Business Days) option text is changed in Estimated Shipping level dropdown. Original TC name: SC_LI_Verify Standard Business Days Delievery option text is changed ");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZMiniCartDropdownRemoveFunctionality() {
		driver.setCurrentTestCase("SC_AZ_Mini Cart Dropdown Remove Functionality");
		driver.setCurrentTestCaseDescription("");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIAlphanumericalCharactersInGiftCardQty() {
		driver.setCurrentTestCase(" SC_LI_ Alphanumerical CharactersInGift CardQty");
		driver.setCurrentTestCaseDescription("Verifies the functionality of gift card quantity box when user enters alphanumerical character in the quantity box and Click on Continue Check out / update option. Original TC Name: SC_LI_Verify While  Entering  Alphanumerical Characters  While Updating the Quantity For Gift cards");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZApplyingBOGOPromoWithParcelShippingPromo() {
		driver.setCurrentTestCase("SC_AZ_Applying BOGO promo with parcel shipping promo");
		driver.setCurrentTestCaseDescription("The purpose of this Test Case is to apply BOGO promo with parcel shipping promo");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testSCEMPAddEPPItemEmpDiscountShouldNotApplyOnEPP() {
		driver.setCurrentTestCase("SC_EMP_Add EPP item, emp discount should not apply on EPP");
		driver.setCurrentTestCaseDescription("To verify an emp discount should not be applied to EPP");
		driver.driveTestExecution();
	}

	@Test
	@Category(BuildVerificationTests.class)
	public void testSCEMPItemWithWASPriceValidateYouSave() {
		driver.setCurrentTestCase(" SC_EMP_Item with WAS price Validate YouSave");
		driver.setCurrentTestCaseDescription("To verify Was price & Retails price are displayed correctly. Original TC Name: SC_EMP_Item with WAS price,you save text and amount should not display");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIVerifyCartSiginingInFromShippingUnavailableItem() {
		driver.setCurrentTestCase("SC_LI_VerifyCart_sigining in from Shipping_Unavailable Item");
		driver.setCurrentTestCaseDescription("Original TC Name: SC_LI_Verify item in Cart while sigining in from Shipping_Unavailable Item");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZNoWhiteGoodsFeeForNonSCStores() {
		driver.setCurrentTestCase("SC_AZ_NoWhite Goods Fee For Non SC stores");
		driver.setCurrentTestCaseDescription("To verify that White Goods Fee should not be displayed for Non SC stores. Original TC Name: SC_AZ_White Goods Fee should not be displayed for Non SC stores");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZNoWhiteGoodsFeeForNonNCStores() {
		driver.setCurrentTestCase("SC_AZ_NoWhite Goods Fee For Non NC stores");
		driver.setCurrentTestCaseDescription("To verify that White Goods Fee should not be displayed for Non NC stores. Original TC Name: SC_AZ_White Goods Fee should not be displayed for Non NC stores");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIVerifyCartSiginingInFromShippingUnavailAvail() {
		driver.setCurrentTestCase("SC_LI_VerifyCart_sigining in from Shipping_Unavail+Avail");
		driver.setCurrentTestCaseDescription("Verify an item in cart after navigating back to cart upon item unavailibility to logged in user selected store. Original TC Name: SC_LI_Verify item in Cart while sigining in from Shipping_Unavailable Item+Available Item");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZVerifyUnavailableState() {
		driver.setCurrentTestCase("SC_AZ_Verify Unavailable State");
		driver.setCurrentTestCaseDescription("To validate the display of item that becomes unavailable when added to cart.");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZVerifyEmptyCartFuctionality() {
		driver.setCurrentTestCase("SC_AZ_Verify Empty Cart Fuctionality");
		driver.setCurrentTestCaseDescription("To validate the remove functionality for a single item with EPP");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZDisplayRegularCartTwoEPPItems() {
		driver.setCurrentTestCase("SC_AZ_Display Regular Cart _Two EPP Items");
		driver.setCurrentTestCaseDescription("Original TC Name: SC_AZ_Display Regular Cart _Two Items with EPP from Product Detail Page");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZVerifyRegularCartItemWithFlexiblePromotion() {
		driver.setCurrentTestCase("SC_AZ_Verify Regular Cart Item with Flexible Promotion");
		driver.setCurrentTestCaseDescription("To validate that -Flexible Promotions work fine after the implementation of Mini Cart functionality");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIOCNewUserDiffShippingBillingAddrsLTDPS() {
		driver.setCurrentTestCase("SC_LI_OC_New user_DiffShipping BillingAddrs_LTD_PS");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verify that when A newly registered user ,who has registered from masthead, enters the shipping address and billing address different in secure checkout pages for one  parcel shipping item  and one Truck delivery item and places order, the addresses should be saved to Manage Addresses and both should displayed as different in order confirmation page. Original TC Name: SC_LI_OrderCompletion_New user_Different Shipping and Billing address_LTD_PS");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIOCNewUserFrmRevPaySameShipBillLTD() {
		driver.setCurrentTestCase("SC_LI_OC_New user_FrmRevPay_SameShipBill LTD");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verify that when A newly registered user, who has registered from Review&Pay page, enters the shipping address and billing address same in secure checkout pages for Lowes Truck Delivery item and places order, the address should be saved to Manage Addresses and both should displayed as the  same  in order confirmation page. Original Tc Name: SC_LI_OrderCompletion_New User_From Review and Pay Page_Same Shipping and Billing address_LTD");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIOCNewUserFrmRevPaySameShipBillPS() {
		driver.setCurrentTestCase("SC_LI_OC_New user_FrmRevPay_SameShipBill PS");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verify that when A newly registered user, who has registered from Review&Pay page, enters the shipping address and billing address same in secure checkout pages for parcel shipping item and places order, the address should be saved to Manage Addresses and both should displayed as the  same  in order confirmation page. Original TC Name: SC_LI_OrderCompletion_New User_From Review and Pay Page_Same Shipping and Billing address_PS");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIOrderCompletionNewUserSameShippingAndBillingAddressLTD() {
		driver.setCurrentTestCase("SC_LI_OrderCompletion_New User_Same Shipping and Billing address_LTD");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verify that when A newly registered user ,who has registered from masthead ,enters the shipping address and billing address same in secure checkout pages for Lowes Truck Delivery  item and places order, the address should be saved to Manage Addresses and both should displayed as the  same  in order confirmation page.");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIOrderCompletionNewUserSameShippingAndBillingAddressPS() {
		driver.setCurrentTestCase("SC_LI_OrderCompletion_New User_Same Shipping and Billing address_PS");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verify that when A newly registered user ,who has registered from masthead, enters the shipping address and billing address same in secure checkout pages for parcel shipping item and places order, the address should be saved to Manage Addresses and both should displayed as the  same  in order confirmation page.");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testSCAZVerifyingErrorOnApplyingGiftCardForGiftCard() {
		driver.setCurrentTestCase("SC_AZ_Verifying error on applying gift card for gift card");
		driver.setCurrentTestCaseDescription("Test case is to verify whether an error message is displayed on applying gift card for gift card item; Original TC Name: SC_AZ_Verifying error displayed on applying gift card for gift card item");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIOCPrimaryAddAsBillingSecondaryAddAsShippingLTD() {
		driver.setCurrentTestCase("SC_LI_OC_PrimaryAdd as Billing_SecondaryAdd as Shipping_LTD");
		driver.setCurrentTestCaseDescription("This test case is to validate order placement with LI user, by selecting Primary address from profile as Billing address and Secondary address as shipping for LTD item and places order, the address should be  displayed correctly and same as provided in the Secure Checkout pages  in the Order confirmation page. Original TC Name: SC_LI_OrderCompletion_Primary address as Billing_Secondary address as Shipping_LTD");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIOCPrimaryAddAsBillingSecondaryAddAsShippingPS() {
		driver.setCurrentTestCase("SC_LI_OC_PrimaryAdd as Billing_SecondaryAdd as Shipping_PS");
		driver.setCurrentTestCaseDescription("Original TC Name: SC_LI_Ordercompletion_Primary address as billing_Secondary address as shipping_PS");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIOCPrimaryAddAsShippingSecondaryAddAsBillingLTD() {
		driver.setCurrentTestCase("SC_LI_OC_PrimaryAdd as Shipping_SecondaryAdd as Billing_LTD");
		driver.setCurrentTestCaseDescription("Original TC Name: SC_LI_OrderCompletion_Primary address as shipping_Secondary address as billing_LTD");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIOCPrimaryAddAsShippingSecondaryAddAsBillingPS() {
		driver.setCurrentTestCase("SC_LI_OC_PrimaryAdd as Shipping_SecondaryAdd as Billing_PS");
		driver.setCurrentTestCaseDescription("Original TC Name: SC_LI_OrderCompletion_Primary address as shipping_Secondary address as billing_PS");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIOCPrimaryAddAsShippingSecondaryAddAsBillingPSLTD() {
		driver.setCurrentTestCase("SC_LI_OC_PrimaryAdd as Shipping_SecondaryAdd as Billing_PS_LTD");
		driver.setCurrentTestCaseDescription("Original TC Name: SC_LI_OrderCompletion_Primary address as shipping_Secondary address as billing _PS_LTD");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIOCPrimaryAddasBillingSecAddAsshippingPSLTDChkOutSignIn() {
		driver.setCurrentTestCase("SC_LI_OC_PrimaryAddasBilling_SecAddAsshipping_PS_LTD_ChkOutSign In");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verify that when a User selects  the primary address as billing and secondary address as shipping  in secure checkout pages for Parcel Shipping  Delivery  item and places order, the address should be  displayed correctly and same as provided in the Secure Checkout pages  in the Order confirmation page. Original TC Name: SC_LI_OrderCompletion_Primary address as billing_Secondary address as shipping_PS_LTD_CheckOut Sign In");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIOCPrimaryAddasShippingSecAddAsBillingPSLTDChkOutSignIn() {
		driver.setCurrentTestCase("SC_LI_OC_PrimaryAddasShipping_SecAddAsBilling_PS_LTD_ChkOutSign In");
		driver.setCurrentTestCaseDescription("Original TC Name: SC_LI_OrderCompletion_Primary address as shipping_Secondary address as billing _PS_LTD_CheckOut Sign In");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIOCPickupNewBillingAddressCheckoutSignIn() {
		driver.setCurrentTestCase("SC_LI_OC_Pickup_New billing address_Checkout SignIn");
		driver.setCurrentTestCaseDescription("This test case is to verify the order placed with registered user by entering new billing address in Review & Pay page.The billing address should be  displayed correctly in your account under manage address section without overiding existing address and same as provided in the Secure Checkout pages  in the Order confirmation page. Original TC Name: SC_LI_OrderCompletion_Pickup_New billing address_Checkout SignIn");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIOCPickupUseBillingAddressFromDropDown() {
		driver.setCurrentTestCase("SC_LI_OC_Pickup_Use billing address from drop down");
		driver.setCurrentTestCaseDescription("This test case is to verify the order placed with registered user by selecting billing address from drop down in Review & Pay page. The billing address should be  displayed correctly and same as provided in the Secure Checkout pages  in the Order confirmation page. Original TC Name-SC_LI_OrderCompletion_Pickup_Use billing address from drop down");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIOCStoredShippAddNewBillAddPSLTLoginAtChkOut() {
		driver.setCurrentTestCase("SC_LI_OC_StoredShippAdd_NewBillAdd_PS_LT_LoginAtChkOut");
		driver.setCurrentTestCaseDescription("Original TC Name-SC_LI_OrderCompletion_UseStoredShippingAddress_NewBillingAddress_PS&LT_LoginAtCheckOut");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIOCStoredShippAddNewBillAddPSLoginAtChkOut() {
		driver.setCurrentTestCase("SC_LI_OC_StoredShippAdd_NewBillAdd_PS_LoginAtChkOut");
		driver.setCurrentTestCaseDescription("Original TC Name: SC_LI_OrderCompletion_UseStoredShippingAddress_NewBillingAddress_PS_LoginAtCheckOut");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIOCUsingShippingBillingAddrssfromDrpDownLTDAndPS() {
		driver.setCurrentTestCase("SC_LI_OC_Using ShippingBilling Addrssfrom DrpDown_LTD & PS");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verify that when user selects shipping address from address dropdown and selects billing address from use primary address in review n pay page, the shipping and billing addresses are dispalyed correctly on the Order Confirmation page, in the Sterling Console and same changes should be reflected in tha Manage Addresses page. Original TC Name: SC_LI_OrderCompletion_Using Shipping Address and Billing address from drop down_LTD & PS");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIOCUsingShippingBillingAddrssfromDrpDownLTD() {
		driver.setCurrentTestCase("SC_LI_OC_Using ShippingBilling Addrssfrom DrpDown_LTD");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verify that when user selects shipping address from address dropdown and selects billing address from use primary address in review n pay page, the shipping and billing addresses are dispalyed correctly on the Order Confirmation page, in the Sterling Console and same changes should be reflected in tha Manage Addresses page. Original TC Name: SC_LI_OrderCompletion_Using Shipping Address_Billing address from drop down_LTD");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIOCUsingShippingBillingAddrssfromDrpDownPS() {
		driver.setCurrentTestCase("SC_LI_OC_Using ShippingBilling Addrssfrom DrpDown_PS");
		driver.setCurrentTestCaseDescription("Original TC Name: SC_LI_OrderCompletion_Using Shipping Address_Billing address from drop down_PS");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZReviewAndPayPageEmailAndPhoneNoValidation() {
		driver.setCurrentTestCase("SC_AZ_Review & Pay page_Email & Phone No._Validation");
		driver.setCurrentTestCaseDescription("This testcase is to verify the error message when order is placed without giving Email and Phone number");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZValidPromoCodePositiveFunctionalTest() {
		driver.setCurrentTestCase("SC_AZ_Valid Promo Code Positive Functional Test");
		driver.setCurrentTestCaseDescription("Verify that a promo code is applied in the cart page when a valid promo is entered and to place order successfully");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIChkAlphanumericalCharactersInUnitPriceTextBox() {
		driver.setCurrentTestCase("SC_LI_ Chk Alphanumerical Characters  in Unit Price Text box ");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verify that when user enters any alpha numeric characters/values in the price text box and tries to checkout , the default price value is filled automatically. Original TC Name: SC_LI_ Verify While Entering  Alphanumerical Characters  in Unit Price Text box Issue.");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZPositiveFunctionalTestPickup() {
		driver.setCurrentTestCase("SC_AZ_Positive Functional Test_Pickup");
		driver.setCurrentTestCaseDescription("SC_AZ_Positive Functional Test_Pickup");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZPositiveFunctionalTestPickupAndLTD() {
		driver.setCurrentTestCase("SC_AZ_Positive Functional Test_Pickup & LTD");
		driver.setCurrentTestCaseDescription("SC_AZ_Positive Functional Test_Pickup & LTD");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZVerifyUnavailableStateWhenItemIsAddedToTheCart() {
		driver.setCurrentTestCase("SC_AZ_Verify Unavailable State when item is added to the cart");
		driver.setCurrentTestCaseDescription("SC_AZ_Verify Unavailable State when item is added to the cart");
		driver.driveTestExecution();
	}

	@Test
	public void testsubtotalOfAnItemWithSpecialTaxWhenRemovedFromTheCart() {
		driver.setCurrentTestCase("subtotal of an item with special tax when removed from the cart.");
		driver.setCurrentTestCaseDescription("SC_LI_To verify cart subtotal or total of an item with special tax when  the  item is removed from the cart.");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testSCLIStoringALarCardLarCardsCannotBeStored() {
		driver.setCurrentTestCase("SC_LI_Storing a LAR card - LAR cards cannot be stored");
		driver.setCurrentTestCaseDescription("");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testSCANZVeriftyTheFunctionalityOfPlacingOrderForGiftCardWithoutZippingIntoTheStore() {
		driver.setCurrentTestCase("SC_ANZ_Verifty the functionality of Placing order for Gift Card without Zipping into the store.");
		driver.setCurrentTestCaseDescription("SC_ANZ_Verifty the functionality of Placing order for Gift Card without Zipping into the store.");
		driver.driveTestExecution();
	}
}
