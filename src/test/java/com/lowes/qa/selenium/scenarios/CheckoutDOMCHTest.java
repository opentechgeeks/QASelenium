package com.lowes.qa.selenium.scenarios;

import java.io.IOException;
import java.text.MessageFormat;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.xml.sax.SAXException;

import com.lowes.qa.selenium.ParallelizedTestBase;
import com.lowes.qa.selenium.categories.BuildVerificationTests;
import com.lowes.qa.selenium.support.DriverScriptRegistry;

public class CheckoutDOMCHTest extends ParallelizedTestBase {
	public CheckoutDOMCHTest(String browserName, String version,
			String platform, String os) throws IOException, SAXException,
			ParserConfigurationException {
		super(browserName, version, platform, os);
		driver = DriverScriptRegistry.getDriverScript(MessageFormat.format(
				"{0}:{1}:{2}:{3}:{4}", browserName, version, platform, os, this
						.getClass().getName()), "CheckOut_DOM_CH");
	}

	@Test
	public void testLCCPromosAreDispWhenGiftCardIsAppliedAndRemoved() {
		driver.setCurrentTestCase("LCC Promos are disp when Gift card is applied and removed");
		driver.setCurrentTestCaseDescription("SC_AZ_LCC Promos are displayed when Gift card is applied and removed");
		driver.driveTestExecution();
	}

	@Test
	@Category(BuildVerificationTests.class)
	public void testOrderCompletionWhiteGoodTaxNCParcelShipping() {
		driver.setCurrentTestCase("Order Completion_White Good Tax_NC_Parcel Shipping");
		driver.setCurrentTestCaseDescription("SC_LI_Order Completion_Item in White Good Tax in Yesrth Carolina_Parcel Shipping");
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
	@Category(BuildVerificationTests.class)
	public void testSCAZItemWithLeadTimeForAllTheDeliveryMethods() {
		driver.setCurrentTestCase("SC_AZ_Item with lead time for all the delivery methods");
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
