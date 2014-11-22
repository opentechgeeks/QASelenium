package com.lowes.qa.selenium.scenarios;

import java.io.IOException;
import java.text.MessageFormat;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.lowes.qa.selenium.ParallelizedTestBase;
import com.lowes.qa.selenium.support.DriverScriptRegistry;

public class MyLowesMLCTest extends ParallelizedTestBase {
	public MyLowesMLCTest(String browserName, String version, String platform,
			String os) throws IOException, SAXException,
			ParserConfigurationException {
		super(browserName, version, platform, os);
		driver = DriverScriptRegistry.getDriverScript(MessageFormat.format(
				"{0}:{1}:{2}:{3}:{4}", browserName, version, platform, os, this
						.getClass().getName()), "MyLowes_MLC");
	}

	@Test
	public void testMLAZVerifyTheModifySearchFunctionality() {
		driver.setCurrentTestCase("ML_AZ_Verify the Modify Search Functionality");
		driver.setCurrentTestCaseDescription("Verify the Modify Search Functionality");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIVerifyTheDisclaimersAfterWeUseTheFilters() {
		driver.setCurrentTestCase("ML_LI_Verify the disclaimers after we use the filters");
		driver.setCurrentTestCaseDescription("Verify the disclaimers after we use the filters");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLILastFiveDigitsOfCCMustNOTBeDisplayedVISA() {
		driver.setCurrentTestCase("ML_LI_Last Five Digits of CC Must NOT be Displayed VISA");
		driver.setCurrentTestCaseDescription("Last Five Digits of CC Must NOT be Displayed VISA");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIVerifyMsgDisplayedForAPurchaseThatIsAlreadyTiedToTheCustomersMyLowesCard() {
		driver.setCurrentTestCase("ML_LI_Verify msg displayed for a purchase that is already tied to the customers MyLowes Card");
		driver.setCurrentTestCaseDescription("Verify msg displayed for a purchase that is already tied to the customers MyLowes Card");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIVerifyTheErrorWhenTryingToSearchForAnInvalidTransaction() {
		driver.setCurrentTestCase("ML_LI_Verify the error when trying to search for an invalid transaction");
		driver.setCurrentTestCaseDescription("Verify the error when trying to search for an invalid transaction");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIRequestMLCReplacementDoubleCommasSuppression() {
		driver.setCurrentTestCase("ML_LI_Request MLC Replacement (double commas suppression)");
		driver.setCurrentTestCaseDescription("Request MLC Replacement (double commas suppression)");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLISwitchOrderCancelCancelButtonNotDisplayed() {
		driver.setCurrentTestCase("ML_LI_Switch Order Cancel_Cancel Button not displayed");
		driver.setCurrentTestCaseDescription("Switch Order Cancel_Cancel Button not displayed");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLICompareStatusInPurchaseHistoryVsPurchaseDetail() {
		driver.setCurrentTestCase("ML_LI_Compare Status in Purchase History vs Purchase Detail");
		driver.setCurrentTestCaseDescription("Compare Status in Purchase History vs Purchase Detail");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIPurchasesPageVerfication() {
		driver.setCurrentTestCase("ML_LI_Purchases Page Verfication");
		driver.setCurrentTestCaseDescription("Purchases Page Verfication");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIFieldValidationsInPurchasesPage() {
		driver.setCurrentTestCase("ML_LI_Field Validations in Purchases Page");
		driver.setCurrentTestCaseDescription("Field Validations in Purchases Page");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIYourAccountLinkWhileRegisteringAMLCWithExistingMLC() {
		driver.setCurrentTestCase("ML_LI_Your Account link while registering a MLC with existing MLC");
		driver.setCurrentTestCaseDescription("Your Account link while registering a MLC with existing MLC");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIVerifyNewPurchaseHistoryPgOnlinePrchsWithNoOLPrchs() {
		driver.setCurrentTestCase("ML_LI_VerifyNew Purchase HistoryPg OnlinePrchs WithNoOLPrchs");
		driver.setCurrentTestCaseDescription("Verify the display of the New Purchase History page when select Online purchases option when the user has not online purchases. Original TC Name: ML_LI_Verify the display of the New Purchase History page when select Online purchases option when the user has not online purchases.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIVerifyTheDisplayOfTheNewPurchaseHistoryPageWhenSelectInStorePurchasesOptionWhenTheUserDoesNotHasAnyKeyFobAssociated() {
		driver.setCurrentTestCase("ML_LI_Verify the display of the New Purchase History page when select In-store purchases option when the user does not has any Key Fob associated");
		driver.setCurrentTestCaseDescription("Verify the display of the New Purchase History page when select In-store purchases option when the user does not has any Key Fob associated");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIFulfillmentDomination() {
		driver.setCurrentTestCase("ML_LI_Fulfillment Domination");
		driver.setCurrentTestCaseDescription("Fulfillment Domination");
		driver.driveTestExecution();
	}

}
