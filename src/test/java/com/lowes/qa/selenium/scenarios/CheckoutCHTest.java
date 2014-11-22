package com.lowes.qa.selenium.scenarios;

import java.io.IOException;
import java.text.MessageFormat;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.lowes.qa.selenium.ParallelizedTestBase;
import com.lowes.qa.selenium.support.DriverScriptRegistry;

public class CheckoutCHTest extends ParallelizedTestBase {
	public CheckoutCHTest(String browserName, String version, String platform,
			String os) throws IOException, SAXException,
			ParserConfigurationException {
		super(browserName, version, platform, os);
		driver = DriverScriptRegistry.getDriverScript(MessageFormat.format(
				"{0}:{1}:{2}:{3}:{4}", browserName, version, platform, os, this
						.getClass().getName()), "CheckOut_CH");
	}

	@Test
	public void testSCAZPIFCheckoutZippedIntoPIFLeviedStateAndShipToOtherThanPIFLeviedState() {
		driver.setCurrentTestCase("SC_AZ_PIF Checkout_Zipped into PIF levied state and ship to other than PIF levied state");
		driver.setCurrentTestCaseDescription("Checkout_Zipped into PIF levied state and ship to other than PIF levied state");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZPIFCheckoutZippedIntoPIFLeviedStateAndShipToPIFLeviedState() {
		driver.setCurrentTestCase("SC_AZ_PIF Checkout_Zipped into PIF levied state and ship to PIF levied state");
		driver.setCurrentTestCaseDescription("Checkout_Zipped into PIF levied state and ship to PIF levied state");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZMandatoryGovernmentFeesTBIFees() {
		driver.setCurrentTestCase("SC_AZ_Mandatory Government Fees_TBI Fees");
		driver.setCurrentTestCaseDescription("Mandatory Government Fees_TBI Fees");
		driver.driveTestExecution();
	}

	@Test
	public void testSCEMPEmployeeDiscountRetailPriceCNFPage() {
		driver.setCurrentTestCase("SC_EMP_Employee Discount_Retail Price_CNF page");
		driver.setCurrentTestCaseDescription("Employee Discount_Retail Price_CNF page");
		driver.driveTestExecution();
	}

	@Test
	public void testSCEMPEmployeeDiscountWasPriceCNFPage() {
		driver.setCurrentTestCase("SC_EMP_Employee Discount_Was Price_ CNF page");
		driver.setCurrentTestCaseDescription("Employee Discount_Was Price_ CNF page");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLISellingRestrictionsPLAndLTD() {
		driver.setCurrentTestCase("SC_LI_Selling restrictions_PL&LTD");
		driver.setCurrentTestCaseDescription("Selling restrictions_PL&LTD");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLISellingRestrictionsNEWUSERPLAndLTD() {
		driver.setCurrentTestCase("SC_LI_Selling restrictions_NEWUSER_PL&LTD");
		driver.setCurrentTestCaseDescription("Selling restrictions_NEWUSER_PL&LTD");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZSellingRestrictionsZipToNonSellingRestrictionAndShipToSellingRestrictionLocation() {
		driver.setCurrentTestCase("SC_AZ_Selling restrictions_Zip  to non selling restriction & ship to selling restriction location");
		driver.setCurrentTestCaseDescription("Selling restrictions_Zip  to non selling restriction & ship to selling restriction location");
		driver.driveTestExecution();
	}

	@Test
	public void testSCLISellingRestrictionsZipToNonSellingRestrctionAndShipToSellingRetrictionLocation() {
		driver.setCurrentTestCase("SC_LI_Selling restrictions_Zip  to non selling restrction & ship to selling retriction location");
		driver.setCurrentTestCaseDescription("Selling restrictions_Zip  to non selling restrction & ship to selling retriction location");
		driver.driveTestExecution();
	}
}
