package com.lowes.qa.selenium.scenarios;

import java.io.IOException;
import java.text.MessageFormat;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.lowes.qa.selenium.ParallelizedTestBase;
import com.lowes.qa.selenium.support.DriverScriptRegistry;

public class CheckoutMLCTest extends ParallelizedTestBase {
	public CheckoutMLCTest(String browserName, String version, String platform,
			String os) throws IOException, SAXException,
			ParserConfigurationException {
		super(browserName, version, platform, os);
		driver = DriverScriptRegistry.getDriverScript(MessageFormat.format(
				"{0}:{1}:{2}:{3}:{4}", browserName, version, platform, os, this
						.getClass().getName()), "CheckOut_MLC");
	}

	@Test
	public void testSCAZValidateOrderDetailGroupParcelOrder() {
		driver.setCurrentTestCase("SC_AZ_Validate Order Detail Group Parcel Order");
		driver.setCurrentTestCaseDescription("SC_AZ_Validate Order Detail Group Parcel Order");
		driver.driveTestExecution();
	}

	@Test
	public void testSCAZValidateOrderDetailGroupStoreOrder() {
		driver.setCurrentTestCase("SC_AZ_Validate Order Detail Group Store Order");
		driver.setCurrentTestCaseDescription("SC_AZ_Validate Order Detail Group Store Order");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIValidateOrderDetailGroupParcelOrder() {
		driver.setCurrentTestCase("ML_LI_Validate Order Detail Group Parcel Order");
		driver.setCurrentTestCaseDescription("ML_LI_Validate Order Detail Group Parcel Order");
		driver.driveTestExecution();
	}
}
