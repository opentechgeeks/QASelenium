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

public class CheckoutSOMCHTest extends ParallelizedTestBase {
	public CheckoutSOMCHTest(String browserName, String version,
			String platform, String os) throws IOException, SAXException,
			ParserConfigurationException {
		super(browserName, version, platform, os);
		driver = DriverScriptRegistry.getDriverScript(MessageFormat.format(
				"{0}:{1}:{2}:{3}:{4}", browserName, version, platform, os, this
						.getClass().getName()), "CheckOut_SOM_CH");
	}

	@Test
	public void testLCCPromosAreDispWhenGiftCardIsAppliedAndRemoved() {
		driver.setCurrentTestCase("LCC Promos are disp when Gift card is applied and removed");
		driver.setCurrentTestCaseDescription("SC_AZ_LCC Promos are displayed when Gift card is applied and removed");
		driver.driveTestExecution();
	}

	@Test
	public void testFutureOrderConfirmationPageNewlyRegisteredUser() {
		driver.setCurrentTestCase("Future Order confirmation page_newly  registered user");
		driver.setCurrentTestCaseDescription("SC_LI_Future Order confirmation page_Successorder newly  registered user");
		driver.driveTestExecution();
	}

	@Test
	public void testErrorValidationPickupNewBillingAddress() {
		driver.setCurrentTestCase("Error Validation_Pickup_New billing address");
		driver.setCurrentTestCaseDescription("SC_LI_Error Validation_Pickup_New billing address");
		driver.driveTestExecution();
	}

	@Test
	@Category(BuildVerificationTests.class)
	public void testOrderCompletionWhiteGoodTaxNCParcelShipping() {
		driver.setCurrentTestCase("Order Completion_White Good Tax_NC_Parcel Shipping");
		driver.setCurrentTestCaseDescription("SC_LI_Order Completion_Item in White Good Tax in North Carolina_Parcel Shipping");
		driver.driveTestExecution();
	}

	@Test
	@Category(BuildVerificationTests.class)
	public void testOrderCompletionWhiteGoodTaxSCParcelShipping() {
		driver.setCurrentTestCase("Order Completion_White Good Tax_SC _Parcel Shipping");
		driver.setCurrentTestCaseDescription("SC_LI_Order Completion_Item in White Good Tax in South Carolina _Parcel Shipping");
		driver.driveTestExecution();
	}

	@Test
	public void testNewUserDifferentShippingAndBillingAddressLTDPS() {
		driver.setCurrentTestCase("New User_Different Shipping and Billing address_LTD_PS");
		driver.setCurrentTestCaseDescription("SC_LI_Order Completion_New User_From Review and Pay page_Different Shipping and Billing address_LTD_PS");
		driver.driveTestExecution();
	}

	@Test
	public void testNewUserReviewSameShippingAndBillingLTDPS() {
		driver.setCurrentTestCase("New User_Review_Same Shipping and Billing_LTD_PS");
		driver.setCurrentTestCaseDescription("SC_LI_Order Completion_New User_From Review and Pay Page_Same Shipping and Billing address_LTD_PS");
		driver.driveTestExecution();
	}

	@Test
	public void testNewUserSameShippingAndBillingAddressLTDPS() {
		driver.setCurrentTestCase("New User_Same Shipping and Billing address_LTD_PS");
		driver.setCurrentTestCaseDescription("SC_LI_Order Completion_New User_Same Shipping and Billing address_LTD_PS");
		driver.driveTestExecution();
	}

	@Test
	public void testNewShippingNewBillingPSAndLTLoginatCheckOut() {
		driver.setCurrentTestCase("New Shipping_New Billing_PS&LT_Loginat_CheckOut");
		driver.setCurrentTestCaseDescription("SC_LI_OrderCompletion_New Shipping  Address_New Billing Address_PS&LT_Loginat_CheckOut");
		driver.driveTestExecution();
	}

	@Test
	public void testNewShippingAddressNewBillingAddressParcelShipping() {
		driver.setCurrentTestCase("New shipping address_New billing address _Parcel shipping");
		driver.setCurrentTestCaseDescription("SC_LI_OrderCompletion_New shipping address_New billing address _Parcel shipping");
		driver.driveTestExecution();
	}

	@Test
	public void testNewShippingAddressNewBillingAddressPSAndLT() {
		driver.setCurrentTestCase("New Shipping Address_New Billing Address_PS&LT");
		driver.setCurrentTestCaseDescription("SC_LI_OrderCompletion_New Shipping Address_New Billing Address_PS&LT");
		driver.driveTestExecution();
	}

	@Test
	public void testNewShippingAddressNewBillingAddressLTD() {
		driver.setCurrentTestCase("New shipping address_New billing address_LTD");
		driver.setCurrentTestCaseDescription("SC_LI_OrderCompletion_New shipping address_New billing address_LTD");
		driver.driveTestExecution();
	}

	@Test
	public void testNewShippingAddressBillingAddressFromDdLTD() {
		driver.setCurrentTestCase("New Shipping Address_Billing Address from dd_LTD");
		driver.setCurrentTestCaseDescription("SC_LI_OrderCompletion_New Shipping Address_Using Billing Address from drop down_LTD");
		driver.driveTestExecution();
	}

	@Test
	public void testNewShippingAddressBillingAddressFromDdLTDAndPS() {
		driver.setCurrentTestCase("New Shipping Address_Billing Address from dd_LTD & PS");
		driver.setCurrentTestCaseDescription("SC_LI_OrderCompletion_New Shipping Address_Using Billing Address from drop down_LTD & PS");
		driver.driveTestExecution();
	}

	@Test
	public void testaddingAThirdAddressInTheProductDestinationTab() {
		driver.setCurrentTestCase("adding a third address in the product destination tab");
		driver.setCurrentTestCaseDescription("SC_AZ_Unable to continue shopping after adding a third address in the product destination tab");
		driver.driveTestExecution();
	}

	@Test
	public void testplaceAnOrderWithVisaCardAsModeOfPayment() {
		driver.setCurrentTestCase("place an order with visa card as mode of payment");
		driver.setCurrentTestCaseDescription("SC_AZ_Unable to place an order with visa card as mode of payment");
		driver.driveTestExecution();
	}

	@Test
	public void testSuggestedAddressIsDisplayedInAddressValidationPopup() {
		driver.setCurrentTestCase("Suggested Address is displayed in address validation popup");
		driver.setCurrentTestCaseDescription("SC_AZ_Verify Suggested Address is displayed in address validation popup");
		driver.driveTestExecution();
	}

	@Test
	public void testSecureCheckoutPagesAreDisplayedWhenAnItemIsAddedTwice() {
		driver.setCurrentTestCase("Secure checkout pages are displayed when an item is added twice");
		driver.setCurrentTestCaseDescription("SC_AZ_Verifying Secure checkout pages are displayed when an item is added twice");
		driver.driveTestExecution();
	}

	@Test
	public void testenetringMaxCharsInLastNameFieldOfReviewAndPayPage() {
		driver.setCurrentTestCase("enetring Max chars in last Name field of Review & Pay Page");
		driver.setCurrentTestCaseDescription("SC_AZ_Verify the display of OC page on palcing order by enetring Max chars in last Name field of Review & Pay Page");
		driver.driveTestExecution();
	}

	@Test
	public void testnavigateTillReviewAndpayPageWithPaintSampleItemOnly() {
		driver.setCurrentTestCase("navigate till review&pay page with paint sample item only");
		driver.setCurrentTestCaseDescription("SC_AZ_Verifying user is able to navigate till review&pay page with paint sample item only");
		driver.driveTestExecution();
	}

	@Test
	public void testAddressVerificationInReviewAndPayPageAndPlacingAnOrder() {
		driver.setCurrentTestCase("Address Verification in Review&Pay page and Placing an order");
		driver.setCurrentTestCaseDescription("SC_AZ_Address Verification in Review&Pay page and Placing an order");
		driver.driveTestExecution();
	}

	@Test
	public void testOrderConfirmationPageUnregisteredAndAlreadyRegisterd() {
		driver.setCurrentTestCase("Order confirmation page_unregistered and already registerd");
		driver.setCurrentTestCaseDescription("SC_AZ_Future Order confirmation page_User messaging_success order_unregistered and already registerd user message");
		driver.driveTestExecution();
	}

	@Test
	public void testAZSpecialFeeWhenSCIsGivenAsShippingWhileRemainZippedIntoNC() {
		driver.setCurrentTestCase("AZ_Special Fee when SC is given as shipping while remain zipped into NC");
		driver.setCurrentTestCaseDescription("SC_AZ_SOM - Verify Special Fee when SC Address is given as an shipping address while remain zipped into NC store");
		driver.driveTestExecution();
	}

	@Test
	public void testLISpecialFeeWhenSCIsGivenAsShippingWhileRemainZippedIntoNC() {
		driver.setCurrentTestCase("LI_Special Fee when SC is given as shipping while remain zipped into NC");
		driver.setCurrentTestCaseDescription("SC_LI_Verify Special Fee when SC Address is given as an shipping address while remain zipped into NC store");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZVerifyYouSaveDisplayedInTheCheckoutPages() {
		driver.setCurrentTestCase("SC_AZ_Verify You Save displayed in the checkout pages");
		driver.setCurrentTestCaseDescription("SC_AZ_Verify You Save displayed in the checkout pages");
		driver.driveTestExecution();
	}

	@Test
	public void testVerifyYouSaveDisplayedInTheOrderConfirmationPage() {
		driver.setCurrentTestCase("Verify You Save displayed in the Order Confirmation Page");
		driver.setCurrentTestCaseDescription("SC_AZ_Verify You Save displayed in the Order Confirmation Page");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZVerifyContextualHelpIconAgainstYouSaved() {
		driver.setCurrentTestCase("SC_AZ_Verify contextual help icon against You Saved");
		driver.setCurrentTestCaseDescription("SC_AZ_Verify contextual help icon against You Saved");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZContextualHelpIconInCheckout() {
		driver.setCurrentTestCase("SC_AZ_Contextual Help icon in checkout");
		driver.setCurrentTestCaseDescription("SC_AZ_Contextual Help icon in checkout");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZCartSummaryMessagingInCheckoutSOSItems() {
		driver.setCurrentTestCase("SC_AZ_Cart summary messaging in checkout SOS items");
		driver.setCurrentTestCaseDescription("SC_AZ_Cart summary messaging in checkout SOS items");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZCartSummaryMessagingInCheckoutSTKItems() {
		driver.setCurrentTestCase("SC_AZ_Cart summary messaging in checkout STK items");
		driver.setCurrentTestCaseDescription("SC_AZ_Cart summary messaging in checkout STK items");
		driver.driveTestExecution();
	}

	@Test
	public void testAZFREELTDAddressIsMoreThan75Miles() {
		driver.setCurrentTestCase("AZ_FREE LTD_address is more than 75 miles ");
		driver.setCurrentTestCaseDescription("SC_AZ_Product Destination Page Hard Stop for FREE LTD-Delivery address is more than 75 miles _SOM");
		driver.driveTestExecution();
	}

	@Test
	@Category(BuildVerificationTests.class)
	public void testLIFREELTDAddressIsMoreThan75Miles() {
		driver.setCurrentTestCase("LI_FREE LTD_address is more than 75 miles ");
		driver.setCurrentTestCaseDescription("SC_LI_Product Destination Page Hard Stop for FREE LTD-Delivery address is more than 75 miles _SOM");
		driver.driveTestExecution();
	}

	@Test
	public void testAZLTDAddressIsMoreThan75Miles() {
		driver.setCurrentTestCase("AZ_LTD address is more than 75 miles");
		driver.setCurrentTestCaseDescription("SC_AZ_Product Destination Page Hard Stop for LTD Delivery address is more than 75 miles entered in PD page");
		driver.driveTestExecution();
	}

	@Test
	public void testAZLTDAddressIsMoreThan75MilesMultipleItems() {
		driver.setCurrentTestCase("AZ_LTD_address is more than 75 miles _multiple items");
		driver.setCurrentTestCaseDescription("SC_AZ__Product Destination Page Hard Stop for LTD-Delivery address is more than 75 miles _checking with multiple items");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testLILTDAddressIsMoreThan75MilesEnteredInPDPage() {
		driver.setCurrentTestCase("LI_LTD_address is more than 75 miles _entered in PD page");
		driver.setCurrentTestCaseDescription("SC_LI_Product Destination Page Hard Stop for LTD-Delivery address is more than 75 miles _entered in PD page_SOM");
		driver.driveTestExecution();
	}

	@Test
	public void testAZLTDAddressIsMoreThan75MilesEnteredInShippingAddressPage() {
		driver.setCurrentTestCase("AZ_LTD_address is more than 75 miles _entered in shipping address page");
		driver.setCurrentTestCaseDescription("SC_AZ_Product Destination Page Hard Stop for LTD-Delivery address is more than 75 miles _entered in shipping address page_SOM");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZVerifyUseMyShippingAddressCheckbox() {
		driver.setCurrentTestCase("SC_AZ_Verify Use My Shipping Address Checkbox");
		driver.setCurrentTestCaseDescription("SC_AZ_Verify Use My Shipping Address Checkbox");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZPlaceAnOrderUsingImpluseByItem() {
		driver.setCurrentTestCase("SC_AZ_Place an order using impluse by item");
		driver.setCurrentTestCaseDescription("SC_AZ_Place an order using impluse by item");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZUserEntersInvalidCreditCardDetails() {
		driver.setCurrentTestCase("SC_AZ_User enters invalid credit card details ");
		driver.setCurrentTestCaseDescription("SC_AZ_User enters invalid credit card details ");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIUserEntersInvalidCreditCardDetails() {
		driver.setCurrentTestCase("SC_LI_User enters invalid credit card details");
		driver.setCurrentTestCaseDescription("SC_LI_User enters invalid credit card details");
		driver.driveTestExecution();
	}

	@Test
	@Category(BuildVerificationTests.class)
	public void testSCAZSOMOrderPlacementWEXSOEPickup() {
		driver.setCurrentTestCase("SC_AZ_SOM_Order Placement_WEX(SOE)_Pickup");
		driver.setCurrentTestCaseDescription("SC_AZ_SOM_Order Placement_WEX(SOE)_Pickup");
		driver.driveTestExecution();
	}

	@Test
	public void testLIOCNewShippingAddressUsingBillingFromDdPS() {
		driver.setCurrentTestCase("LI_OC_New Shipping Address_Using Billing from dd_PS");
		driver.setCurrentTestCaseDescription("SC_LI_OrderCompletion_New Shipping Address_Using Billing Address from drop down_PS");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testSCAZSOMOrderPlacementWEXSOELTD() {
		driver.setCurrentTestCase("SC_AZ_SOM_Order Placement_WEX(SOE)_LTD");
		driver.setCurrentTestCaseDescription("SC_AZ_SOM_Order Placement_WEX(SOE)_LTD");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIDOMMultipleItemOrderPlacement() {
		driver.setCurrentTestCase("SC_LI_DOM_Multiple item order placement");
		driver.setCurrentTestCaseDescription("SC_LI_DOM_Multiple item order placement");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testSCAZSOMSOSDDItemOrderPlacementPS() {
		driver.setCurrentTestCase("SC_AZ_SOM_SOS DD item_Order placement_PS");
		driver.setCurrentTestCaseDescription("SC_AZ_SOM_SOS DD item_Order placement_PS");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testSCAZSOMSOSDDItemOrderPlacementPickup() {
		driver.setCurrentTestCase("SC_AZ_SOM_SOS DD item_Order placement_Pickup");
		driver.setCurrentTestCaseDescription("SC_AZ_SOM_SOS DD item_Order placement_Pickup");
		driver.driveTestExecution();
	}

	@Test
	@Category(BuildVerificationTests.class)
	public void testSCAZSOMSOSVDNItemOrderPlacementPickup() {
		driver.setCurrentTestCase("SC_AZ_SOM_SOS VD=N item_Order placement_Pickup");
		driver.setCurrentTestCaseDescription("SC_AZ_SOM_SOS VD=N item_Order placement_Pickup");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testSCAZSOMSOSVDNItemOrderPlacementLTD() {
		driver.setCurrentTestCase("SC_AZ_SOM_SOS VD=N  item_Order placement_LTD");
		driver.setCurrentTestCaseDescription("SC_AZ_SOM_SOS VD=N  item_Order placement_LTD");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZValidCreditCardNumberWithInvalidSecurityCode() {
		driver.setCurrentTestCase("SC_AZ_ Valid Credit Card number with Invalid Security code");
		driver.setCurrentTestCaseDescription("SC_AZ_ Valid Credit Card number with Invalid Security code");
		driver.driveTestExecution();
	}

	@Test
	public void testAZShippingServiceLevelTextSelectedInCart() {
		driver.setCurrentTestCase("AZ_shipping service level text_selected in cart");
		driver.setCurrentTestCaseDescription("SC_AZ_Obtain and Dispaly standard shipping service level text  from new service _selected in cart");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testAZShippingServiceLevelTextSelectedInSOP() {
		driver.setCurrentTestCase("AZ_shipping service level text_selected in SOP");
		driver.setCurrentTestCaseDescription("SC_AZ_Obtain and Dispaly standard shipping service level text  from new service _selected in shipping options page");
		driver.driveTestExecution();
	}

	@Test
	public void testLIShippingServiceLevelTextSelectedInCart() {
		driver.setCurrentTestCase("LI_shipping service level text_selected in cart");
		driver.setCurrentTestCaseDescription("SC_LI_Obtain and Dispaly standard shipping service level text  from new service _selected in cart");
		driver.driveTestExecution();
	}

	@Test
	public void testLIShippingServiceLevelTextSelectedInSOP() {
		driver.setCurrentTestCase("LI_shipping service level text_selected in SOP");
		driver.setCurrentTestCaseDescription("SC_LI_Obtain and Dispaly standard shipping service level text  from new service _selected in shipping options page");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZFooterChanges() {
		driver.setCurrentTestCase("SC_AZ_Footer changes");
		driver.setCurrentTestCaseDescription("SC_AZ_Footer changes");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZMastHeadChanges() {
		driver.setCurrentTestCase("SC_AZ_Mast head changes");
		driver.setCurrentTestCaseDescription("SC_AZ_Mast head changes");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZRemoveEditAddressLinkInCheckoutLTD() {
		driver.setCurrentTestCase("SC_AZ_Remove Edit Address link in checkout_LTD");
		driver.setCurrentTestCaseDescription("SC_AZ_Remove Edit Address link in checkout_LTD");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZRemoveEditAddressLinkInCheckoutPS() {
		driver.setCurrentTestCase("SC_AZ_Remove Edit Address link in checkout_PS");
		driver.setCurrentTestCaseDescription("SC_AZ_Remove Edit Address link in checkout_PS");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIRemoveEditAddressLinkInCheckoutLTD() {
		driver.setCurrentTestCase("SC_LI_Remove Edit Address link in checkout_LTD");
		driver.setCurrentTestCaseDescription("SC_LI_Remove Edit Address link in checkout_LTD");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIRemoveEditAddressLinkInCheckoutPS() {
		driver.setCurrentTestCase("SC_LI_Remove Edit Address link in checkout_PS");
		driver.setCurrentTestCaseDescription("SC_LI_Remove Edit Address link in checkout_PS");
		driver.driveTestExecution();
	}

	@Test
	@Category(BuildVerificationTests.class)
	public void testSCAZItemWithLeadTimeForAllTheDeliveryMethods() {
		driver.setCurrentTestCase("SC_AZ_Item with lead time for all the delivery methods");
		driver.setCurrentTestCaseDescription("");
		driver.driveTestExecution();
	}

	@Test
	@Category(BuildVerificationTests.class)
	public void testSCAZUIEnhancementDefaultState() {
		driver.setCurrentTestCase("SC_AZ_UI_Enhancement_DefaultState");
		driver.setCurrentTestCaseDescription("");
		driver.driveTestExecution();
	}

	@Test
	@Category(BuildVerificationTests.class)
	public void testSCAZWEX22ErrorCode() {
		driver.setCurrentTestCase("SC_AZ_ WEX_-22 Error code");
		driver.setCurrentTestCaseDescription("");
		driver.driveTestExecution();
	}
}
