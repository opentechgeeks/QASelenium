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

public class CheckoutDOMBFTest extends ParallelizedTestBase {
	public CheckoutDOMBFTest(String browserName, String version,
			String platform, String os) throws IOException, SAXException,
			ParserConfigurationException {
		super(browserName, version, platform, os);
		driver = DriverScriptRegistry.getDriverScript(MessageFormat.format(
				"{0}:{1}:{2}:{3}:{4}", browserName, version, platform, os, this
						.getClass().getName()), "CheckOut_DOM_BF");
	}

	@Test
	public void testSCLIRetrievingCCNoBillingAddress() {
		driver.setCurrentTestCase("SC_LI_Retrieving CC_No Billing Address");
		driver.setCurrentTestCaseDescription("Retrieving CC_No Billing Address");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIRetrievingCCSavingBillingAddress() {
		driver.setCurrentTestCase("SC_LI_Retrieving CC_Saving Billing Address");
		driver.setCurrentTestCaseDescription("Retrieving CC_Saving Billing Address");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIRetrievingCCCreditCardNickName() {
		driver.setCurrentTestCase("SC_LI_Retrieving CC_Credit Card Nick Name");
		driver.setCurrentTestCaseDescription("Retrieving CC_Credit Card Nick Name");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIStoringTheFirstAndSecondCreditCard() {
		driver.setCurrentTestCase("SC_LI_Storing the first and second credit card");
		driver.setCurrentTestCaseDescription("Storing the first and second credit card");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIStoringCreditCardAsPrimaryCard() {
		driver.setCurrentTestCase("SC_LI_Storing credit card as primary card");
		driver.setCurrentTestCaseDescription("Storing credit card as primary card");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testSCAZRemovePickupAddShip() {
		driver.setCurrentTestCase("SC_AZ_Remove_Pickup add Ship");
		driver.setCurrentTestCaseDescription("Remove_Pickup add Ship");
		driver.driveTestExecution();
	}
}
