package com.lowes.qa.selenium.scenarios;

import java.io.IOException;
import java.text.MessageFormat;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.xml.sax.SAXException;

import com.lowes.qa.selenium.ParallelizedTestBase;
import com.lowes.qa.selenium.categories.SmokeTests;
import com.lowes.qa.selenium.support.DriverScriptRegistry;

public class CheckoutDOMCMTest extends ParallelizedTestBase {
	public CheckoutDOMCMTest(String browserName, String version,
			String platform, String os) throws IOException, SAXException,
			ParserConfigurationException {
		super(browserName, version, platform, os);
		driver = DriverScriptRegistry.getDriverScript(MessageFormat.format(
				"{0}:{1}:{2}:{3}:{4}", browserName, version, platform, os, this
						.getClass().getName()), "CheckOut_DOM_CM");
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
	public void testSCVerifyEstimatedTruckDeliveryCharges() {
		driver.setCurrentTestCase("SC_Verify_Estimated Truck Delivery Charges");
		driver.setCurrentTestCaseDescription("To validate that estimated Truck Delivery work fine after the implementation of Mini Cart functionality.");
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
	public void testSCLIOrderCompletionNewUserSameShippingAndBillingAddressLTD() {
		driver.setCurrentTestCase("SC_LI_OrderCompletion_New User_Same Shipping and Billing address_LTD");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verify that when A newly registered user ,who has registered from masthead ,enters the shipping address and billing address same in secure checkout pages for Lowes Truck Delivery  item and places order, the address should be saved to Manage Addresses and both should displayed as the  same  in order confirmation page.");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIOCPrimaryAddAsBillingSecondaryAddAsShippingLTD() {
		driver.setCurrentTestCase("SC_LI_OC_PrimaryAdd as Billing_SecondaryAdd as Shipping_LTD");
		driver.setCurrentTestCaseDescription("This test case is to validate order placement with LI user, by selecting Primary address from profile as Billing address and Secondary address as shipping for LTD item and places order, the address should be  displayed correctly and same as provided in the Secure Checkout pages  in the Order confirmation page. Original TC Name: SC_LI_OrderCompletion_Primary address as Billing_Secondary address as Shipping_LTD");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZVerifyAllLinksButtons() {
		driver.setCurrentTestCase("SC_AZ_Verify all links,buttons");
		driver.setCurrentTestCaseDescription("This is to verify all new links,button,static text,headers,help messaging etc. on Regular Cart page are displayed and functioned properly as part of new INTERIM CART look & feel. Original TC Name: SC_AZ_Verify all links,buttons,help messaging,header,static text are displayed and fucntioned properly.");
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
	public void testSCAZEmptyCartPageWhenItemRemovedFromCart() {
		driver.setCurrentTestCase("SC_AZ_EmptyCartPage when ItemRemovedFromCart");
		driver.setCurrentTestCaseDescription("To verify new Empty Cart page layout as per new design/comps. Original TC Name: SC_AZ_Empty Cart Page when Item is removed from Regular Cart");
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
