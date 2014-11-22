package com.lowes.qa.selenium.scenarios;

import java.io.IOException;
import java.text.MessageFormat;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.lowes.qa.selenium.ParallelizedTestBase;
import com.lowes.qa.selenium.support.DriverScriptRegistry;

public class CheckoutCMTest extends ParallelizedTestBase {
	public CheckoutCMTest(String browserName, String version, String platform,
			String os) throws IOException, SAXException,
			ParserConfigurationException {
		super(browserName, version, platform, os);
		driver = DriverScriptRegistry.getDriverScript(MessageFormat.format(
				"{0}:{1}:{2}:{3}:{4}", browserName, version, platform, os, this
						.getClass().getName()), "CheckOut_CM");
	}

	@Test
	public void testSCAZMultipleItemsZippedInSellingRestrictedStore() {
		driver.setCurrentTestCase("SC_AZ_Multiple Items- Zipped in Selling Restricted Store");
		driver.setCurrentTestCaseDescription("Multiple Items- Zipped in Selling Restricted Store");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZNonSellingRestrictedItemZippedIntoSellingRestrictedStoreSP() {
		driver.setCurrentTestCase("SC_AZ_Non-Selling Restricted Item - Zipped into Selling Restricted Store - SP");
		driver.setCurrentTestCaseDescription("Non-Selling Restricted Item - Zipped into Selling Restricted Store - SP");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLISellingRestrictedItemZippedIntoSellingRestrictedStoreSPPopover() {
		driver.setCurrentTestCase("SC_LI_Selling Restricted Item_Zipped into Selling Restricted Store - SP Popover");
		driver.setCurrentTestCaseDescription("Selling Restricted Item_Zipped into Selling Restricted Store - SP Popover");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZSellingRestrictedItemZippedIntoSellingRestrictedStoreLD() {
		driver.setCurrentTestCase("SC_AZ_Selling Restricted Item - Zipped into Selling Restricted Store - LD");
		driver.setCurrentTestCaseDescription("Selling Restricted Item - Zipped into Selling Restricted Store - LD");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZSellingRestrictedItemZippedIntoSellingRestrictedStorePS() {
		driver.setCurrentTestCase("SC_AZ_Selling Restricted Item - Zipped into Selling Restricted Store - PS");
		driver.setCurrentTestCaseDescription("Selling Restricted Item - Zipped into Selling Restricted Store - PS");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZSellingRestrictionDuringStoreChangeViaMastHead() {
		driver.setCurrentTestCase("SC_AZ_Selling Restriction During Store Change via Mast Head");
		driver.setCurrentTestCaseDescription("Selling Restriction During Store Change via Mast Head");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLIZippedInWithPIFLeviedStateLTD() {
		driver.setCurrentTestCase("SC_LI_Zipped in with PIF levied State - LTD");
		driver.setCurrentTestCaseDescription("SC_LI_Zipped in with PIF levied State - LTD");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZZippedInNonPIFLeviedState() {
		driver.setCurrentTestCase("SC_AZ_ Zipped in Non-PIF Levied  State");
		driver.setCurrentTestCaseDescription("SC_AZ_ Zipped in Non-PIF Levied  State");
		driver.driveTestExecution();
	}
}
