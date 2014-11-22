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

public class MyLowesPBCTest extends ParallelizedTestBase {
	public MyLowesPBCTest(String browserName, String version, String platform,
			String os) throws IOException, SAXException,
			ParserConfigurationException {
		super(browserName, version, platform, os);
		driver = DriverScriptRegistry.getDriverScript(MessageFormat.format(
				"{0}:{1}:{2}:{3}:{4}", browserName, version, platform, os, this
						.getClass().getName()), "MyLowes_PBC");
	}

	@Test
	public void testMLLIGrassSeedCalculatorCalculateAreaInAMethod() {
		driver.setCurrentTestCase("ML_LI_Grass Seed Calculator_Calculate area in a method");
		driver.setCurrentTestCaseDescription("ML_LI_Grass Seed Calculator_Calculate area in a method");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZGrassSeedCalculatorSearchGrassSeedProduct() {
		driver.setCurrentTestCase("ML_AZ_Grass Seed Calculator_Search Grass Seed Product");
		driver.setCurrentTestCaseDescription("ML_AZ_Grass Seed Calculator_Search Grass Seed Product");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZGrassSeedCalculatorCalculateGrassSeed() {
		driver.setCurrentTestCase("ML_AZ_Grass Seed Calculator_Calculate grass Seed");
		driver.setCurrentTestCaseDescription("ML_AZ_Grass Seed Calculator_Calculate grass Seed");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZGrassSeedCalculatorNPC() {
		driver.setCurrentTestCase("ML_AZ_Grass Seed Calculator_NPC");
		driver.setCurrentTestCaseDescription("ML_AZ_Grass Seed Calculator_NPC");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZMulchCalculatorNPCSectionVerification() {
		driver.setCurrentTestCase("ML_AZ_Mulch Calculator-NPC section verification");
		driver.setCurrentTestCaseDescription("ML_AZ_Mulch Calculator-NPC section verification");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZMulchCalculatorSearchMulchProducts() {
		driver.setCurrentTestCase("ML_AZ_Mulch Calculator-Search Mulch Products");
		driver.setCurrentTestCaseDescription("ML_AZ_Mulch Calculator-Search Mulch Products");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZMulchCalculatorVolumeResultConversion() {
		driver.setCurrentTestCase("ML_AZ_Mulch Calculator-Volume Result Conversion");
		driver.setCurrentTestCaseDescription("ML_AZ_Mulch Calculator-Volume Result Conversion");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZMulchCalculatorProductEstimateSection() {
		driver.setCurrentTestCase("ML_AZ_Mulch Calculator-Product Estimate section");
		driver.setCurrentTestCaseDescription("ML_AZ_Mulch Calculator-Product Estimate section");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZMulchCalculatorDisclaimer() {
		driver.setCurrentTestCase("ML_AZ_Mulch Calculator-Disclaimer");
		driver.setCurrentTestCaseDescription("ML_AZ_Mulch Calculator-Disclaimer");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZFertilizerCalculatorSearchFertilizerProducts() {
		driver.setCurrentTestCase("ML_AZ_Fertilizer Calculator-Search Fertilizer Products");
		driver.setCurrentTestCaseDescription("ML_AZ_Fertilizer Calculator-Search Fertilizer Products");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZFertilizerCalculatorDisclaimerVerification() {
		driver.setCurrentTestCase("ML_AZ_Fertilizer Calculator-Disclaimer verification");
		driver.setCurrentTestCaseDescription("ML_AZ_Fertilizer Calculator-Disclaimer verification");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZFertilizerCalclatorNPCSectionVerification() {
		driver.setCurrentTestCase("ML_AZ_Fertilizer Calclator-NPC section verification");
		driver.setCurrentTestCaseDescription("ML_AZ_Fertilizer Calclator-NPC section verification");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZFertilizerCalculatorViewFertilizerResults() {
		driver.setCurrentTestCase("ML_AZ_Fertilizer Calculator-View Fertilizer Results");
		driver.setCurrentTestCaseDescription("ML_AZ_Fertilizer Calculator-View Fertilizer Results");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZFertilizerCalculatorViewAreaResultsConversion() {
		driver.setCurrentTestCase("ML_AZ_Fertilizer Calculator-View Area Results-Conversion");
		driver.setCurrentTestCaseDescription("ML_AZ_Fertilizer Calculator-View Area Results-Conversion");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZFertilizerCalculatorSelectFertilizerReleaseRate() {
		driver.setCurrentTestCase("ML_AZ_Fertilizer Calculator-Select Fertilizer Release Rate");
		driver.setCurrentTestCaseDescription("ML_AZ_Fertilizer Calculator-Select Fertilizer Release Rate");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZFertilizerCalculatorResetButtonMechanism() {
		driver.setCurrentTestCase("ML_AZ_Fertilizer Calculator-Reset button mechanism");
		driver.setCurrentTestCaseDescription("ML_AZ_Fertilizer Calculator-Reset button mechanism");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIFertilizerCalculatorCaptureFertilizerArea() {
		driver.setCurrentTestCase("ML_LI_Fertilizer Calculator_Capture Fertilizer Area");
		driver.setCurrentTestCaseDescription("ML_LI_Fertilizer Calculator_Capture Fertilizer Area");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testMLLIPaintCalculatorSaveResultsToExistingHomeProfile() {
		driver.setCurrentTestCase("ML_LI_Paint Calculator_Save results to existing Home Profile");
		driver.setCurrentTestCaseDescription("ML_LI_Paint Calculator_Save results to existing Home Profile");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIMulchCalculatorSaveResultsToNewHomeProfile() {
		driver.setCurrentTestCase("ML_LI_Mulch Calculator_Save Results to New Home Profile");
		driver.setCurrentTestCaseDescription("ML_LI_Mulch Calculator_Save Results to New Home Profile");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIFertiCalSaveResultsToExistingHomeProfile() {
		driver.setCurrentTestCase("ML_LI_Ferti Cal_Save results to existing Home Profile");
		driver.setCurrentTestCaseDescription("ML_LI_Fertilizer Calculator_Save results to existing Home Profile");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIFertiCalSaveResultsToNewHomeProfile() {
		driver.setCurrentTestCase("ML_LI_Ferti Cal_Save Results to New Home Profile");
		driver.setCurrentTestCaseDescription("ML_LI_Fertilizer Calculator_Save Results to New Home Profile");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIGSCSaveResultsToExistingHomeProfile() {
		driver.setCurrentTestCase("ML_LI_GSC_Save Results  to existing Home Profile");
		driver.setCurrentTestCaseDescription("ML_LI_Grass Seed Calculator_Save Results  to existing Home Profile");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIGSCSaveResultsToNewHomeProfile() {
		driver.setCurrentTestCase("ML_LI_GSC_Save results to New Home Profile");
		driver.setCurrentTestCaseDescription("ML_LI_Grass Seed Calculator_Save results to New Home Profile");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIShopButtonInHomeProfile() {
		driver.setCurrentTestCase("ML_LI_Shop Button in Home Profile");
		driver.setCurrentTestCaseDescription("ML_LI_Shop Button in Home Profile");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLINegativeSpaceOfYardInMulchCalculator() {
		driver.setCurrentTestCase("ML_LI_Negative space of Yard in Mulch Calculator");
		driver.setCurrentTestCaseDescription("ML_LI_Negative space of Yard in Mulch Calculator");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLINegativeSpaceOfYardInSeedCalculator() {
		driver.setCurrentTestCase("ML_LI_Negative space of Yard in Seed Calculator");
		driver.setCurrentTestCaseDescription("ML_LI_Negative space of Yard in Seed Calculator");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLINegativeSpaceOfYardInFertilizerCalculator() {
		driver.setCurrentTestCase("ML_LI_Negative space of Yard in Fertilizer Calculator");
		driver.setCurrentTestCaseDescription("ML_LI_Negative space of Yard in Fertilizer Calculator");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIDeleteSpaceNavigationRevision() {
		driver.setCurrentTestCase("ML_LI_Delete Space Navigation Revision");
		driver.setCurrentTestCaseDescription("ML_LI_Delete Space Navigation Revision");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIFertiCalSavingCalculationResultsToHomeProfile() {
		driver.setCurrentTestCase("ML_LI_Ferti Cal_Saving calculation results to Home Profile");
		driver.setCurrentTestCaseDescription("ML_LI_Ferti Cal_Saving calculation results to Home Profile");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testMLLIPaintCalUnauthUserSavingResultToHomeProfile() {
		driver.setCurrentTestCase("ML_LI_Paint Cal_Unauth user saving result to Home Profile");
		driver.setCurrentTestCaseDescription("ML_LI_Paint Cal_Unauth user saving result to Home Profile");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLISeedCalUnauthUserSavingResultsToHP() {
		driver.setCurrentTestCase("ML_LI_Seed Cal_Unauth user saving results to HP");
		driver.setCurrentTestCaseDescription("ML_LI_Seed Cal_Unauth user saving results to HP");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIMulchCalUnauthUserSavingResultsToHP() {
		driver.setCurrentTestCase("ML_LI_Mulch Cal_Unauth user saving results to HP");
		driver.setCurrentTestCaseDescription("ML_LI_Mulch Cal_Unauth user saving results to HP");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIHomeProfileTooltipsForExteriorSpace() {
		driver.setCurrentTestCase("ML_LI_Home Profile-Tooltips for Exterior space");
		driver.setCurrentTestCaseDescription("ML_LI_Home Profile-Tooltips for Exterior space");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIHomeProfileTooltipsForInteriorSpace() {
		driver.setCurrentTestCase("ML_LI_Home Profile-Tooltips for Interior space");
		driver.setCurrentTestCaseDescription("ML_LI_Home Profile-Tooltips for Interior space");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZGrassSeedCalculatorResetButtonMechanism() {
		driver.setCurrentTestCase("ML_AZ_Grass Seed Calculator_Reset button mechanism");
		driver.setCurrentTestCaseDescription("ML_AZ_Grass Seed Calculator_Reset button mechanism");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZMulchCalculatorResetButtonMechanism() {
		driver.setCurrentTestCase("ML_AZ_Mulch Calculator-Reset button mechanism");
		driver.setCurrentTestCaseDescription("ML_AZ_Mulch Calculator-Reset button mechanism");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testMLMulchCalAreaByUsingDimensionsSavedInMyHP() {
		driver.setCurrentTestCase("ML_Mulch Cal_area by Using dimensions saved in my HP");
		driver.setCurrentTestCaseDescription("ML_Mulch Cal_area by Using dimensions saved in my HP");
		driver.driveTestExecution();
	}

	@Test
	public void testMLMulchCalAreaBySelectingEnterSquareFootage() {
		driver.setCurrentTestCase("ML_Mulch Cal_area by selecting Enter square footage");
		driver.setCurrentTestCaseDescription("ML_Mulch Cal_area by selecting Enter square footage");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLINegativeSpaceOfGardenInMulchCalculator() {
		driver.setCurrentTestCase("ML_LI_Negative space of Garden in Mulch Calculator");
		driver.setCurrentTestCaseDescription("ML_LI_Negative space of Garden in Mulch Calculator");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLILeftNavigationUpdated() {
		driver.setCurrentTestCase("ML_LI_Left Navigation updated");
		driver.setCurrentTestCaseDescription("ML_LI_Left Navigation updated");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLINegativeSpaceOfGardenInFertilizerCalculator() {
		driver.setCurrentTestCase("ML_LI_Negative space of Garden in Fertilizer Calculator");
		driver.setCurrentTestCaseDescription("ML_LI_Negative space of Garden in Fertilizer Calculator");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLINegativeSpaceOfGardenInSeedCalculator() {
		driver.setCurrentTestCase("ML_LI_Negative space of Garden in Seed Calculator");
		driver.setCurrentTestCaseDescription("ML_LI_Negative space of Garden in Seed Calculator");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZGrassSeedCalculatorFloatingResults() {
		driver.setCurrentTestCase("ML_AZ_Grass seed Calculator_Floating Results");
		driver.setCurrentTestCaseDescription("ML_AZ_Grass seed Calculator_Floating Results");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZFertilizerCalculatorFloatingResults() {
		driver.setCurrentTestCase("ML_AZ_Fertilizer Calculator_Floating Results");
		driver.setCurrentTestCaseDescription("ML_AZ_Fertilizer Calculator_Floating Results");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZPaintCalculatorFloatingResults() {
		driver.setCurrentTestCase("ML_AZ_Paint Calculator_Floating Results");
		driver.setCurrentTestCaseDescription("ML_AZ_Paint Calculator_Floating Results");
		driver.driveTestExecution();
	}

	@Test
	@Category(BuildVerificationTests.class)
	public void testMLAZPaintCalEnterDimensionsAddAndDeleteWalls() {
		driver.setCurrentTestCase("ML_AZ_Paint Cal_Enter Dimensions Add and Delete Walls");
		driver.setCurrentTestCaseDescription("ML_AZ_Paint Cal_Enter Dimensions Add and Delete Walls");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZMulchCalculatorFloatingResult() {
		driver.setCurrentTestCase("ML_AZ_Mulch Calculator-Floating Result");
		driver.setCurrentTestCaseDescription("ML_AZ_Mulch Calculator-Floating Result");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZFertiCalRememberDataInCalculatorSession() {
		driver.setCurrentTestCase("ML_AZ_Ferti Cal_Remember data in Calculator Session");
		driver.setCurrentTestCaseDescription("ML_AZ_Ferti Cal_Remember data in Calculator Session");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZMulchCalRememberDataInCalculatorSession() {
		driver.setCurrentTestCase("ML_AZ_Mulch Cal_Remember Data in Calculator Session");
		driver.setCurrentTestCaseDescription("ML_AZ_Mulch Cal_Remember Data in Calculator Session");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIPaintCalRememberDataInCalculatorSession() {
		driver.setCurrentTestCase("ML_LI_Paint Cal_Remember data in Calculator Session");
		driver.setCurrentTestCaseDescription("ML_LI_Paint Cal_Remember data in Calculator Session");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZGSCRememberDataInCalculatorSession() {
		driver.setCurrentTestCase("ML_AZ_GSC_Remember data in Calculator Session");
		driver.setCurrentTestCaseDescription("ML_AZ_GSC_Remember data in Calculator Session");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZMulchCalCalculateTheVolumeForMulch() {
		driver.setCurrentTestCase("ML_AZ_Mulch Cal-Calculate the volume for mulch.");
		driver.setCurrentTestCaseDescription("ML_AZ_Mulch Cal-Calculate the volume for mulch.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIMulchCalSaveResultsToExistingHomeProfile() {
		driver.setCurrentTestCase("ML_LI_Mulch Cal_Save Results to existing Home Profile");
		driver.setCurrentTestCaseDescription("ML_LI_Mulch Cal_Save Results to existing Home Profile");
		driver.driveTestExecution();
	}
}
