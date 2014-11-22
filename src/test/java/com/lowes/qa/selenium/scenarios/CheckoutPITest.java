package com.lowes.qa.selenium.scenarios;

import java.io.IOException;
import java.text.MessageFormat;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.lowes.qa.selenium.ParallelizedTestBase;
import com.lowes.qa.selenium.support.DriverScriptRegistry;

public class CheckoutPITest extends ParallelizedTestBase {
	public CheckoutPITest(String browserName, String version, String platform,
			String os) throws IOException, SAXException,
			ParserConfigurationException {
		super(browserName, version, platform, os);
		driver = DriverScriptRegistry.getDriverScript(MessageFormat.format(
				"{0}:{1}:{2}:{3}:{4}", browserName, version, platform, os, this
						.getClass().getName()), "CheckOut_PI");
	}

	@Test
	public void testSCAZRemoveLogicDeliveryCost() {
		driver.setCurrentTestCase("SC_AZ_Remove Logic_Delivery Cost");
		driver.setCurrentTestCaseDescription("Remove Logic_Delivery Cost");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZRemoveLogicShippingCost() {
		driver.setCurrentTestCase("SC_AZ_Remove Logic_Shipping Cost");
		driver.setCurrentTestCaseDescription("Remove Logic_Shipping Cost");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZOrderConfirmationPageWEXWithLeadTimeSPSOMOnly() {
		driver.setCurrentTestCase("SC_AZ_Order Confirmation Page - WEX with lead time - SP (SOM Only)");
		driver.setCurrentTestCaseDescription("Order Confirmation Page - WEX with lead time - SP (SOM Only)");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZSOMBuyGiftCardWithCreditCardOrderPostSOM() {
		driver.setCurrentTestCase("SC_AZ_SOM_BuyGiftCard_With CreditCard_OrderPost_SOM");
		driver.setCurrentTestCaseDescription("SOM_BuyGiftCard_With CreditCard_OrderPost_SOM");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZSOMMandatedGovtFeesCartPageCheckoutPageOrderConfirmationPageOrderDetailPageOrderConfirmationEmail() {
		driver.setCurrentTestCase("SC_AZ_SOM_Mandated Govt Fees_CartPage_Checkout page_Order Confirmation Page_Order detail Page_OrderConfirmationEmail");
		driver.setCurrentTestCaseDescription("SOM_Mandated Govt Fees_CartPage_Checkout page_Order Confirmation Page_Order detail Page_OrderConfirmationEmail");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZAbilityToHideFullfillmentOptionsForSOSVDYInternetOnly() {
		driver.setCurrentTestCase("SC_AZ_Ability to hideFullfillmentOptions for SOS VD= Y, Internet Only");
		driver.setCurrentTestCaseDescription("Ability to hideFullfillmentOptions for SOS VD= Y, Internet Only");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZOrderConfirmationPageSOSVDNWithLeadTimeSPSOM() {
		driver.setCurrentTestCase("SC_AZ_Order Confirmation Page - SOS VD=N with lead time - SP_SOM");
		driver.setCurrentTestCaseDescription("Order Confirmation Page - SOS VD=N with lead time - SP_SOM");
		driver.driveTestExecution();
	}
}
