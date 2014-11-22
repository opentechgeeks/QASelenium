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

public class MyLowesHPTest extends ParallelizedTestBase {
	public MyLowesHPTest(String browserName, String version, String platform,
			String os) throws IOException, SAXException,
			ParserConfigurationException {
		super(browserName, version, platform, os);
		driver = DriverScriptRegistry.getDriverScript(MessageFormat.format(
				"{0}:{1}:{2}:{3}:{4}", browserName, version, platform, os, this
						.getClass().getName()), "MyLowes_HP");
	}

	@Test
	public void testMLLIEditYardDimensions() {
		driver.setCurrentTestCase("ML_LI_Edit_Yard_Dimensions");
		driver.setCurrentTestCaseDescription("The test case is to verify the setting of dimensions functionality for a yard space");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIYardAndGardenAddNegativeSpaces() {
		driver.setCurrentTestCase("ML_LI_Yard and Garden_Add_Negative_Spaces");
		driver.setCurrentTestCaseDescription("Test case is to verify the dimensions functionality in the home profile by providing negative space");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIDocumentTabDocumentListVerifyCount() {
		driver.setCurrentTestCase("ML_LI_Document_Tab-Document_List-Verify_Count");
		driver.setCurrentTestCaseDescription("Test case is to verify the count of the documents present in the home profile documents page");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLISummaryTileCreateNewSpace() {
		driver.setCurrentTestCase("ML_LI_Summary_Tile-Create_New_Space");
		driver.setCurrentTestCaseDescription("Test case to check the home profile");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testMLLICreateAccountAndCreateNewHomeProfile() {
		driver.setCurrentTestCase("ML_LI_Create Account and Create New Home Profile");
		driver.setCurrentTestCaseDescription("Test case to Create Account and Create New Home Profile");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLINegativeSpaceErrorNetAreaLessThanZero() {
		driver.setCurrentTestCase("ML_LI_Negative_Space_Error_Net Area Less Than Zero");
		driver.setCurrentTestCaseDescription("Test case is to verify the dimensions functionality in the home profile by providing negative space");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLINetAreaCalculation() {
		driver.setCurrentTestCase("ML_LI_Net_Area_Calculation");
		driver.setCurrentTestCaseDescription("Test case is to verify the net area calculations");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIVerifyActionsDelete() {
		driver.setCurrentTestCase("ML_LI_Verify Actions Delete");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verify that the  list is refreshed and a success message has been displayed along with the Undo link when an item is deleted");
		driver.driveTestExecution();
	}

	@Test
	@Category(BuildVerificationTests.class)
	public void testMLLIVerificationOfTrashCanExistence() {
		driver.setCurrentTestCase("ML_LI_Verification of TrashCan Existence");
		driver.setCurrentTestCaseDescription("The puropose of this test case is to verify when  Clicked on the Trash can at the top-right corner of the item's row and inspect the Item is deleted.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIClickOnProfileName() {
		driver.setCurrentTestCase("ML_LI_Click_on_Profile_name");
		driver.setCurrentTestCaseDescription("Click_on_Profile_name");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLINavigationBarRenameProfileName() {
		driver.setCurrentTestCase("ML_LI_Navigation_Bar-Rename_Profile_name");
		driver.setCurrentTestCaseDescription("Navigation_Bar-Rename_Profile_name");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLICreationOfNotCancelItInListView() {
		driver.setCurrentTestCase("ML_LI_Creation of Not_CancelIt  in ListView");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to check that the changes made to the product notes etc are not saved when a cancel button is pressed; TC name changed as Name too long error coming: ML_LI_Creation of Note For Recently Added Item and CancelIt  in ListView");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLICreateNoteCancelItInGridView() {
		driver.setCurrentTestCase("ML_LI_Create Note_Cancel It in Grid View");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to check that the changes made to the product notes etc are not saved when a cancel button is pressed in grid view; Original Name: ML_LI_Create Note For Recently Added Item and Cancel It in Grid View");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIEditExistingNoteCancelChangesListView() {
		driver.setCurrentTestCase("ML_LI_Edit_ExistingNote_Cancel_Changes-List_View");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to check that the changes made to the  existing product notes etc are not saved when a cancel button is pressed in list view; Original TC Name: ML_LI_Edit_ExistingNote_for_Item_and_Cancel_Changes-List_View");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIEditExistingNoteCancelChangesInGridView() {
		driver.setCurrentTestCase("ML_LI_Edit_Existing_Note_Cancel_Changes in Grid_View");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to check that the changes made to the existing  product notes etc are not saved when a cancel button is pressed in grid view; Original TC Name: ML_LI_Edit_Existing_Note_for_Item_and_Cancel_Changes in Grid_View");
		driver.driveTestExecution();
	}

	@Test
	@Category(BuildVerificationTests.class)
	public void testMLLICreateNoteForAnItemAndSaveIt() {
		driver.setCurrentTestCase("ML_LI_Create Note for an Item_and Save It");
		driver.setCurrentTestCaseDescription("The purpose of this test case is for creating a Note for an Item and Saving  It");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIVerifySaveButtonWorkedAndUseCloseButton() {
		driver.setCurrentTestCase("ML_LI_Verify_Save_Button_Worked_and_Use_Close_Button");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verify that when a close button is clicked after editing the items title in home profile, the changes should be saved");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testMLLIEditItemInListView() {
		driver.setCurrentTestCase("ML_LI_Edit_item_in_list_view");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to Edit an item in list  view and saving the changes");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testMLLIListViewAssignItemFromOneSpaceToAnother() {
		driver.setCurrentTestCase("ML_LI_List_view_Assign_item_from_one_space_to_another");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to assign item from one space to another  in List view");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIGridViewAssignItemFromOneSpaceToAnother() {
		driver.setCurrentTestCase("ML_LI_Grid_view_Assign_item_from_one_space_to_another");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to assign an item from one space to another in the grid view");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIListViewPOS() {
		driver.setCurrentTestCase("ML_LI_List_view-POS");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to assign an item from one space to another and verify the change of ''LOacted in'' field.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLICreateHomeProfileWithoutHomeProfile() {
		driver.setCurrentTestCase("ML_LI_Create Home Profile_without Home Profile");
		driver.setCurrentTestCaseDescription("Creating Home Profile and verifying the containers");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIVerifyInformationItemsTabSpaceLandingPage() {
		driver.setCurrentTestCase("ML_LI_VerifyInformation_Items Tab_Space Landing page");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to inspect the items tab in a space landing page of home profile; Original TC Name: ML_LI_Verify the information displayed in the Items Tab within a Space Landing page");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIVerifyInformationTabOfSpacePageWithNoDim() {
		driver.setCurrentTestCase("ML_LI_VerifyInformation_tab of Space pageWithNoDim");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to inspect the dimensions page in any of the space; Original TC NAME: ML_LI_Verify the information displayed in the Dimensions tab of Space page that doesnt have a dimensions added");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIHideAndUnhideFunctionality() {
		driver.setCurrentTestCase("ML_LI_Hide and Unhide functionality ");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verify  Hide and Unhide functionality");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLINavigationBarHoverOverProfileName() {
		driver.setCurrentTestCase("ML_LI_Navigation_Bar-Hover_over_Profile_name");
		driver.setCurrentTestCaseDescription("Test case to Hover over the Profile name.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIAllDocsFromSummaryPage() {
		driver.setCurrentTestCase("ML_LI_All Docs from summary page");
		driver.setCurrentTestCaseDescription("Test case to validate the summary report.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIProductAddToSpacesXMechanismListViewAndEditMode() {
		driver.setCurrentTestCase("ML_LI_Product_Add to Spaces_X Mechanism_List View and Edit Mode");
		driver.setCurrentTestCaseDescription("Test case to view the Edit mode.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIExteriorDimensionsAddYardDimensions() {
		driver.setCurrentTestCase("ML_LI_Exterior_Dimensions-Add_Yard_Dimensions");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to add a space and create spaces in the dimensions tab");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIExteriorDimensionsEditYardDimensionsPOS() {
		driver.setCurrentTestCase("ML_LI_Exterior_Dimensions-Edit_Yard_Dimensions-POS");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to edit the existing dimensions and they should be saved if it is geometrically possible");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIExteriorDimensionsEnterFirstNegativeSpace() {
		driver.setCurrentTestCase("ML_LI_Exterior_Dimensions-Enter_first_Negative_Space");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to add a negative space");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIExteriorDimensionsAddNewNegativeSpace() {
		driver.setCurrentTestCase("ML_LI_Exterior_Dimensions-Add_New_Negative_Space");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to Add New Negative Space by clicking on ''Add New Negative Space'' link");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIExteriorDimensionsNegativeSpaceErrorNetAreaLessThan0() {
		driver.setCurrentTestCase("ML_LI_Exterior_Dimensions-Negative_Space_Error_Net Area Less Than 0");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to inspect the ''Does Not Compute''");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIVerifyTheFunctionalityOfTheNewHeader() {
		driver.setCurrentTestCase("ML_LI_Verify the functionality of the new Header");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verfiy the edit functionalit");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testMLLISpaceTileSpaceWithAllTypesOfItemsAndDimensions() {
		driver.setCurrentTestCase("ML_LI_Space Tile_Space with all types of items and dimensions");
		driver.setCurrentTestCaseDescription("Test case to check if the space have all types of Items in it.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLISortingAllProductsTileListAndGridView() {
		driver.setCurrentTestCase("ML_LI_Sorting All Products Tile_List and Grid View");
		driver.setCurrentTestCaseDescription("Test case to check the Sorting functionality.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLILogDirectlyIntoYourHomeProfile() {
		driver.setCurrentTestCase("ML_LI_Log directly into your Home Profile");
		driver.setCurrentTestCaseDescription("Test case to check the behavoiur of Home profile with out logged in user");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIManuallyAddAppliancesNewItemWithOptionalPOS() {
		driver.setCurrentTestCase("ML_LI_ManuallyAddAppliancesNew itemWith Optional - POS");
		driver.setCurrentTestCaseDescription("Original TC Name: ML_LI_Manually add an Appliances product from the Items Page - New item - With Optional - POS");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIHomeProfileNotCreated() {
		driver.setCurrentTestCase("ML_LI_Home_Profile_Not_Created");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to create a home Profile");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZUserDoesNotHaveALowesComAccount() {
		driver.setCurrentTestCase("ML_AZ_User Does Not Have A  Lowes.Com Account");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to create an account from Your Account->Home profile");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZUserHomeProfileCreatedAlready() {
		driver.setCurrentTestCase("ML_AZ_User-Home_Profile_Created_Already");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to sign in from Your Account->Home Profile");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZUserHomeProfileNotCreated() {
		driver.setCurrentTestCase("ML_AZ_User-Home_Profile_Not_Created");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verify whether user is navigated to Home Profile Summary page with four default living spaces created when clicked on create a home profile");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIPaintCalcDetailsVeriifyLayout() {
		driver.setCurrentTestCase("ML_LI_Paint_Calc_Details_Veriify_Layout");
		driver.setCurrentTestCaseDescription("User should have home profile created with a living space with at least one paint calculation associated with it.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIMulchCalcDetailsVeriifyLayout() {
		driver.setCurrentTestCase("ML_LI_Mulch_Calc_Details_Veriify_Layout");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verify the layout of Mulch Calc Results View");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLILowesComProductWithRelatedDocsListView() {
		driver.setCurrentTestCase("ML_LI_Lowes.com Product with Related Docs_List View");
		driver.setCurrentTestCaseDescription("");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testMLLIRemoveSpaceAssignmentWithX() {
		driver.setCurrentTestCase("ML_LI_Remove_Space_Assignment_With_X");
		driver.setCurrentTestCaseDescription("This Test case removes an Item for a Living Space.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIInspectSortBarSummaryPage() {
		driver.setCurrentTestCase("ML_LI_Inspect Sort Bar_Summary page");
		driver.setCurrentTestCaseDescription("Test case to validate the summary Page.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIPhotosFromSpaceDetailPage() {
		driver.setCurrentTestCase("ML_LI_Photos from space detail page");
		driver.setCurrentTestCaseDescription("Test case to validate the Photos Uploaded.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIPhotosFromSpaceDetailSortByAndShowMechanism() {
		driver.setCurrentTestCase("ML_LI_Photos from space detail_ sort by and show mechanism");
		driver.setCurrentTestCaseDescription("Test case to validate the sort by and show mechanism.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIDocumentsFromSpaceDetailPage() {
		driver.setCurrentTestCase("ML_LI_Documents from space detail page");
		driver.setCurrentTestCaseDescription("Test case to validate the Document functionality.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLICalculationsListViewAddANote() {
		driver.setCurrentTestCase("ML_LI_Calculations_List_View-Add_A_Note");
		driver.setCurrentTestCaseDescription("The puropose of this test case is to add a note for the caluclation and save it");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIViewVerifyDeleteFunctionality() {
		driver.setCurrentTestCase("ML_LI_View-Verify_Delete_Functionality");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verfiy that when an undo link is clicked changes should reappear  in list view.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIPaintCalculationsListViewVerifyEditMode() {
		driver.setCurrentTestCase("ML_LI_Paint_Calculations_List_ViewVerifyEdit_Mode");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verify the type of paints when clicked on Shop Paint; Original TC NAME: ML_LI_Paint_Calculations_List_View-Verify_layout_of_Edit_Mode");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIMulchCalculationsListViewVerifyLayoutOfEditMode() {
		driver.setCurrentTestCase("ML_LI_Mulch_Calculations_List_View-Verify_layout_of_Edit_Mode");
		driver.setCurrentTestCaseDescription("The purpose of thisa test case is to verify the mulch items when cliked on Shop Mulch");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIGrassSeedCalculationsListViewVerifyLayoutOfEditMode() {
		driver.setCurrentTestCase("ML_LI_Grass_Seed_Calculations_List_View-Verify_layout_of_Edit_Mode");
		driver.setCurrentTestCaseDescription("The purpose of this test acse is to verify the Product List page displaying grass seed options");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIFertilizerCalculationsListViewVerifyLayoutOfEditMode() {
		driver.setCurrentTestCase("ML_LI_Fertilizer_Calculations_List_View-Verify_layout_of_Edit_Mode");
		driver.setCurrentTestCaseDescription("The purpose of thisa test case is to verfiy that the Product List page for Fertilizer is dipslayed when clicked on ''Shop Fertilizer'' button.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLICalculatorAccessTabVerifyCalculatorTab() {
		driver.setCurrentTestCase("ML_LI_Calculator Access Tab-Verify Calculator Tab");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verify that Calculations that were saved to space is displayed OR if no calculations have been saved, then links to different calculators is displayed.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLICalculatorAccessTabInternalLivingSpacePaintCalculator() {
		driver.setCurrentTestCase("ML_LI_Calculator_Access_Tab-Internal_Living_Space-Paint_Calculator");
		driver.setCurrentTestCaseDescription("The purpose of this atest case is to verify the placement of Paint Calculator and View All Project Calculators");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLISummaryPageShowMechanism() {
		driver.setCurrentTestCase("ML_LI_Summary page_ Show  mechanism");
		driver.setCurrentTestCaseDescription("Test case to validate the summary Page.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIEditCalculationAddANote() {
		driver.setCurrentTestCase("ML_LI_Edit_Calculation-Add_A_Note");
		driver.setCurrentTestCaseDescription("Test case to validate the Add to Note property.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIUndoTrashCanDeleteCalculations() {
		driver.setCurrentTestCase("ML_LI_Undo_Trash_Can_Delete_Calculations");
		driver.setCurrentTestCaseDescription("Test case to validate the Undo Property after deletion of a Calculation.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIDimensionsFromSpaceDetailPage() {
		driver.setCurrentTestCase("ML_LI_Dimensions from space detail page");
		driver.setCurrentTestCaseDescription("Test case to Calculate the shape and dimensions");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIDocsTileDeleteAndUndeleteDocumentListView() {
		driver.setCurrentTestCase("ML_LI_Docs_Tile-Delete and Undelete_Document_List_View");
		driver.setCurrentTestCaseDescription("Test case to check the documentation Delete and Re-do property.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLICalcAccessTabInternalLivingSpaceViewAllProjectCalculators() {
		driver.setCurrentTestCase("ML_LI_CalcAccessTabInternalLivingSpaceView_All_Project_Calculators");
		driver.setCurrentTestCaseDescription("The purpose of the test case is to verify the placement of Paint Calculator and View All Project Calculators links. Original Tc Name: ML_LI_Calculator_Access_Tab-Internal_Living_Space-View_All_Project_Calculators");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLICalcAccessTabExternalLivingSpaceGrassSeedCalculator() {
		driver.setCurrentTestCase("ML_LI_CalcAccessTabExternalLivingSpaceGrass_Seed_Calculator");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verfiy the placement of Grass Seed Calculator, Mulch Calculator, Fertilizer Calculator, and View All Project Calculators links. Original TC Name:ML_LI_Calculator_Access_Tab-External_Living_Space-Grass_Seed_Calculator");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLICalcAccessTabExternalLivingSpaceMulchCalculator() {
		driver.setCurrentTestCase("ML_LI_CalcAccessTabExternalLivingSpaceMulch_Calculator");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verify placement of Grass Seed Calculator, Mulch Calculator, Fertilizer Calculator, and View All Project Calculators links. Original TC Name: ML_LI_Calculator_Access_Tab-External_Living_Space-Mulch_Calculator");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLICalcAccessTabExternalLivingSpaceFertilizerCalculator() {
		driver.setCurrentTestCase("ML_LI_CalcAccessTabExternalLivingSpaceFertilizer_Calculator");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verify placement of Grass Seed Calculator, Mulch Calculator, Fertilizer Calculator, and View All Project Calculators links. Original TC Name: ML_LI_Calculator_Access_Tab-External_Living_Space-Fertilizer_Calculator");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLICalcAccessTabExternalLivingSpaceViewAllProjectCalculators() {
		driver.setCurrentTestCase("ML_LI_CalcAccessTabExternalLivingSpace-View_All_Project_Calculators");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verify placement of Grass Seed Calculator, Mulch Calculator, Fertilizer Calculator, and View All Project Calculators links. Original TC Name: ML_LI_Calculator_Access_Tab-External_Living_Space-View_All_Project_Calculators");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIAUndoDeleteCalculations() {
		driver.setCurrentTestCase("ML_LI_A-Undo_Delete_Calculations");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verify the undo functionality for calculations");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIVerifyTrashCanWorksDeletesFromCalcDetailsView() {
		driver.setCurrentTestCase("ML_LI_Verify_Trash_Can_Works_Deletes_From_Calc_Details_View");
		driver.setCurrentTestCaseDescription("The purpose of this  test case is to verify  that the list is refreshed and  'calc name' has been deleted and the Undo link is displayed when trash can has been clicked");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIAVerifyTrashCanDeletesFromListView() {
		driver.setCurrentTestCase("ML_LI_A-Verify_Trash_Can_Deletes_From_List_View");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verify that  the list is refreshed and the row where the calculation was before now displays: 'calc name' has been deleted and the Undo link.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIVerifyTrashCanDeletesFromListViewOnlyOneCalc() {
		driver.setCurrentTestCase("ML_LI_Verify_Trash_Can_Deletes_From_List_View_(only one calc)");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verfiy that the the calculation is deleted. List View is disappeared and links to Project Calculators is  displayed ");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIVerifyTrashCanWorksDeletesFromCalcDetailsViewMultiple() {
		driver.setCurrentTestCase("ML_LI_Verify_Trash_Can_Works_Deletes_From_Calc_Details_View_Multiple");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verify the calculation is  deleted. List View is displayed for all other calculations when a trash can is clicked. Original TC Name: ML_LI_Verify_Trash_Can_Works_Deletes_From_Calc_Details_View_(multiple calcs)");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIVerifyTrashCanWorksDeletesFromCalcDetailsView1Calc() {
		driver.setCurrentTestCase("ML_LI_VerifyTrashCan WorksDeletesFromCalcDetails View_1Calc");
		driver.setCurrentTestCaseDescription("The purpose of the test case is to verify that the calculation is deleted. List View is disappeared and links to Project Calculators is displayed. Original TC NAME: ML_LI_Verify_Trash_Can_Works_Deletes_From_Calc_Details_View_(only one calc)");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIVerifyTrashCanDeletesFromListViewMultipleCalcs() {
		driver.setCurrentTestCase("ML_LI_Verify_Trash_Can_Deletes_From_List_View_(multiple calcs)");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verfiy that a calculation is deleted when clicked on trash can");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIAllProductsFromSummaryPage() {
		driver.setCurrentTestCase("ML_LI_All Products from summary page");
		driver.setCurrentTestCaseDescription("Test case to validate all the products from the Summary page.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIReplceDeleteSpaceMechanism() {
		driver.setCurrentTestCase("ML_LI_Replce_Delete Space mechanism");
		driver.setCurrentTestCaseDescription("Test case to delete a Space from home profile");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLISpaceTileSpaceWithSomeTypesOfItemsAndDimensions() {
		driver.setCurrentTestCase("ML_LI_Space Tile_Space with some types of items and dimensions");
		driver.setCurrentTestCaseDescription("Test case to validate a space with some Items");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIAllProductsSortAndShowMechanism() {
		driver.setCurrentTestCase("ML_LI_All Products_ Sort and Show mechanism");
		driver.setCurrentTestCaseDescription("Test case to sort the Items in a product");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testMLLIAllProductsBatchDeleteAndUndo() {
		driver.setCurrentTestCase("ML_LI_All Products_ Batch delete and Undo");
		driver.setCurrentTestCaseDescription("Test case to perform Deletion and Undo Operation.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIVerifyLinksWhenSavingAProductToListsAndHomeProfile() {
		driver.setCurrentTestCase("ML_LI_Verify links when saving a product to Lists  and Home Profile");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to save an item from product detail page to home profile and lists and then naviagte to the space where the item is located.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIVerifyAllItemsCheckboxfunctions() {
		driver.setCurrentTestCase("ML_LI_VerifyAllItems_Checkboxfunctions");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to verify that when a user clicks  ''All Items'' Checkbox in the items bar and inspect whether all the cheboxes are checked  in the each row of it");
		driver.driveTestExecution();
	}

	@Test
	@Category(BuildVerificationTests.class)
	public void testMLLIVerifyDropdownWhenSavingItemsFromPurchases() {
		driver.setCurrentTestCase("ML_LI_ Verify dropdown when saving items  from purchases");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to save an item from purchase history page and purchase detail page to home profile");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLICalculationsIKnowTheAreaCalcVerifyLayoutOfAreaCalculation() {
		driver.setCurrentTestCase("ML_LI_CalculationsIKnowTheAreaCalcVerify Layout_of_Area_Calculation");
		driver.setCurrentTestCaseDescription("The purpose of this test case is to Verify the layout of Detail view for calculations. Original TC Name: ML_LI_Calculations_I_Know_the_Area_Calculation-Verify_Layout_of_Area_Calculation");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testMLLISortByListMostRecentlyAdded() {
		driver.setCurrentTestCase("ML_LI_SortByList_MostRecentlyAdded");
		driver.setCurrentTestCaseDescription("The purpose of this test cases is to verify dropdown menu is closed and the order of items has not been changed when clicked  on sort by Most Recently Added option");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIDocsTileDeleteAndUndeleteDocumentEditMode() {
		driver.setCurrentTestCase("ML_LI_Docs_Tile-Delete and Undelete_Document_Edit_Mode");
		driver.setCurrentTestCaseDescription("Test case to delete and Undo a document in Edit Mode.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLICalculationEditNameAndNote() {
		driver.setCurrentTestCase("ML_LI_Calculation-Edit Name and Note");
		driver.setCurrentTestCaseDescription("Test case to edit name and Note of a calculation.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIYardOrGardenLinkToCalculators() {
		driver.setCurrentTestCase("ML_LI_Yard or Garden_Link to Calculators");
		driver.setCurrentTestCaseDescription("Test case to navigate to Garden Link.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIPhotosTileDeleteAndUndeletePhoto() {
		driver.setCurrentTestCase("ML_LI_Photos_Tile-Delete and Undelete_Photo");
		driver.setCurrentTestCaseDescription("Test case to validate the Deletion and Undo Property for a photo.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLVerifyMaliciousTextIsNotAcceptedInNameAndNotesFields() {
		driver.setCurrentTestCase("ML_Verify malicious text is not accepted in Name and Notes fields");
		driver.setCurrentTestCaseDescription("Test case is to verify the error message displayed when code scripts are provided in the name and notes fields and saved");
		driver.driveTestExecution();
	}

	@Test
	public void testMLPhotosTabPhotosGalleryVerifyCount() {
		driver.setCurrentTestCase("ML_Photos_Tab-Photos_Gallery-Verify_Count");
		driver.setCurrentTestCaseDescription("Test case is to verify the count of the photos displayed in the photo modal");
		driver.driveTestExecution();
	}

	@Test
	public void testMLPhotosTilePhotosGalleryVerifyLayout() {
		driver.setCurrentTestCase("ML_Photos_Tile-Photos_Gallery-Verify_Layout");
		driver.setCurrentTestCaseDescription("Test case is to verify the layout changes in the photo modal");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIDocumentTabDocumentListVerifyLayout() {
		driver.setCurrentTestCase("ML_LI_Document_Tab-Document_List-Verify_Layout");
		driver.setCurrentTestCaseDescription("Test case is to verify the layout of list view for documents in the home profile");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIUndoTrashCanDeleteFromCalcDetailsView() {
		driver.setCurrentTestCase("ML_LI_Undo_Trash_Can_Delete_From_Calc_Details_View");
		driver.setCurrentTestCaseDescription("Test case to validate the Deletion and Undo Property for a Calculation.");
		driver.driveTestExecution();
	}

	@Test
	@Category(BuildVerificationTests.class)
	public void testMLLIEditItemGridView() {
		driver.setCurrentTestCase("ML_LI_Edit_Item_grid_view");
		driver.setCurrentTestCaseDescription("Test case to edit the Item in the Grid view.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLICalculationWithTableOfDimensionsLayoutInEditMode() {
		driver.setCurrentTestCase("ML_LI_Calculation with Table of Dimensions-Layout in Edit Mode");
		driver.setCurrentTestCaseDescription("Test case to view the Calculation table in Edit mode.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIDimensionSummaryForNegativeSpaces() {
		driver.setCurrentTestCase("ML_LI_Dimension_Summary_for_Negative_Spaces");
		driver.setCurrentTestCaseDescription("Test case to calculate the dimension summary for negative spaces.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIPhotosTabDeleteAndUndeletePhoto() {
		driver.setCurrentTestCase("ML_LI_Photos_Tab-Delete and Undelete_Photo");
		driver.setCurrentTestCaseDescription("Test case to delete a photo Tab and then Undo the Deletion process");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIAllCalculationsListViewVerifyTheOrderOfCalculations() {
		driver.setCurrentTestCase("ML_LI_All_Calculations_List_View-Verify_the_order_of_calculations");
		driver.setCurrentTestCaseDescription("Test case to check the sorting order of calculations");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLISpaceTileSpaceWithNeitherItemsNorDimensions() {
		driver.setCurrentTestCase("ML_LI_Space Tile_Space with neither items nor dimensions");
		driver.setCurrentTestCaseDescription("Test case to validate the text for No Spaces.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIDocumentsFromSpaceDetailSortByAndShowMechanism() {
		driver.setCurrentTestCase("ML_LI_Documents from space detail_ sort by and show mechanism");
		driver.setCurrentTestCaseDescription("Test case to validate the sort by and show mechanism.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIAllPhotosUploadFunctionality() {
		driver.setCurrentTestCase("ML_LI_All Photos_ Upload functionality");
		driver.setCurrentTestCaseDescription("Test case to check the photo upload functionality");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLISpaceTileSpaceWithSquareFootageArea() {
		driver.setCurrentTestCase("ML_LI_Space Tile_Space with square footage area");
		driver.setCurrentTestCaseDescription("Test case to check the square area value for a Space Tile");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLINavigateToSpaceUsingSpacesTile() {
		driver.setCurrentTestCase("ML_LI_Navigate to Space using Spaces Tile");
		driver.setCurrentTestCaseDescription("Test case to validate the scroll bar availability in the Spaces Tile.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIAllPhotosFromSummaryPage() {
		driver.setCurrentTestCase("ML_LI_All Photos from summary page");
		driver.setCurrentTestCaseDescription("Test case to validate the photos summary page.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIAllPhotosSortAndShowMechanism() {
		driver.setCurrentTestCase("ML_LI_All Photos_ Sort and Show mechanism");
		driver.setCurrentTestCaseDescription("Test case to validate thVerify the  Square Foot Pricing news features in a Product List page.e Sort and Show Mechanism for Photos");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIBatchDeleteCalculations() {
		driver.setCurrentTestCase("ML_LI_Batch_Delete_Calculations");
		driver.setCurrentTestCaseDescription("Test case to delete a batch calculation.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIEditTheDocument() {
		driver.setCurrentTestCase("ML_LI_Edit the Document");
		driver.setCurrentTestCaseDescription("Test case to edit a document");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIAllDocsSortAndShowMechanism() {
		driver.setCurrentTestCase("ML_LI_All Docs_ Sort and Show mechanism");
		driver.setCurrentTestCaseDescription("Test case to view the sort and show mechanism");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIProductSpaceDetailPage() {
		driver.setCurrentTestCase("ML_LI_Product-space detail page");
		driver.setCurrentTestCaseDescription("Test case to validate the Product space detail page.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIProductsBatchDeleteAndUndo() {
		driver.setCurrentTestCase("ML_LI_Products_Batch_Delete_and_Undo");
		driver.setCurrentTestCaseDescription("Test case to check the functionality of Product batch delete and Undo.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIProductsFromSpaceDetailSortByAndShowMechanism() {
		driver.setCurrentTestCase("ML_LI_Products from space detail_ sort by and show mechanism");
		driver.setCurrentTestCaseDescription("Test case to validate the Sort and Show Mechanism for Products");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIEmptyCalculationSortBar() {
		driver.setCurrentTestCase("ML_LI_Empty_Calculation_Sort Bar");
		driver.setCurrentTestCaseDescription("Test case to validate the Calculation sort bar empty.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIPhotosTabNotesField() {
		driver.setCurrentTestCase("ML_LI_Photos_Tab-Notes_Field");
		driver.setCurrentTestCaseDescription("Test case to validate the notes property.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIAllDocsUploadFunctionality() {
		driver.setCurrentTestCase("ML_LI_All Docs_ Upload functionality");
		driver.setCurrentTestCaseDescription("Test case to upload a document");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIPhotosTabPhotosGallerySortMechanism() {
		driver.setCurrentTestCase("ML_LI_Photos_Tab-Photos_Gallery-Sort_Mechanism");
		driver.setCurrentTestCaseDescription("Test case to validate the show and sort functionality.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLICalculationsListViewVerifyLayout() {
		driver.setCurrentTestCase("ML_LI_Calculations_List_View-Verify_Layout");
		driver.setCurrentTestCaseDescription("Test case to verify the List view lay out of calculations");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIFertilizerCalcDetailsVeriifyLayout() {
		driver.setCurrentTestCase("ML_LI_Fertilizer_Calc_Details_Veriify_Layout");
		driver.setCurrentTestCaseDescription("Test case to validate the Details layout for Fertilizer calculations.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLISeedCalcDetailsVeriifyLayout() {
		driver.setCurrentTestCase("ML_LI_Seed_Calc_Details_Veriify_Layout");
		driver.setCurrentTestCaseDescription("Test case to validate the Details layout for Grass Seed calculations.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIBoschLaserMeasuringToolVideo() {
		driver.setCurrentTestCase("ML_LI_Bosch Laser Measuring Tool Video");
		driver.setCurrentTestCaseDescription("Test case to validate Bosch Laser Measuring tool video");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIDocumentTabDocumentListSortMechanism() {
		driver.setCurrentTestCase("ML_LI_Document_Tab-Document_List-Sort_Mechanism");
		driver.setCurrentTestCaseDescription("Test case to validate the document tab sort mechanism.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIDocumentsTabDeleteDocumentInListView() {
		driver.setCurrentTestCase("ML_LI_Documents_Tab-Delete_Document_in_List_View");
		driver.setCurrentTestCaseDescription("Test case to validate the document tab delete mechanism.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIDocumentsTabDeleteDocumentInEditMode() {
		driver.setCurrentTestCase("ML_LI_Documents_Tab-Delete_Document_in_Edit_Mode");
		driver.setCurrentTestCaseDescription("Test case to validate the document tab delete mechanism in Edit Mode.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLINewListSortByGridViewPOS() {
		driver.setCurrentTestCase("ML_LI_New_List-Sort_By-Grid_view-POS");
		driver.setCurrentTestCaseDescription("Test case to validate the Sort mechanism");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIProductRemoveSpaces() {
		driver.setCurrentTestCase("ML_LI_Product_Remove Spaces");
		driver.setCurrentTestCaseDescription("Test case to validate the product Remove spaces.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLICalculationsListViewVerifyOrder() {
		driver.setCurrentTestCase("ML_LI_Calculations_List_View-Verify_Order");
		driver.setCurrentTestCaseDescription("Test case to validate the Calculations List View verify Order");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIExteriorDimensionsNetAreaCalculation() {
		driver.setCurrentTestCase("ML_LI_Exterior_Dimensions-Net_Area_Calculation");
		driver.setCurrentTestCaseDescription("Test case to validate the Exterior Dimensions Net Area calculation.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIEditPhotoInModal() {
		driver.setCurrentTestCase("ML_LI_Edit Photo In Modal");
		driver.setCurrentTestCaseDescription("Test case to edit photo in Modal");
		driver.driveTestExecution();
	}

	@Test
	@Category(BuildVerificationTests.class)
	public void testMLLIEditCalculationPaint() {
		driver.setCurrentTestCase("ML_LI_Edit_Calculation-Paint");
		driver.setCurrentTestCaseDescription("Test case to Edit calculation Paint.");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testMLLIGridViewPOS() {
		driver.setCurrentTestCase("ML_LI_Grid_view-POS");
		driver.setCurrentTestCaseDescription("Test case to check the Grid View POS.");
		driver.driveTestExecution();
	}
}
