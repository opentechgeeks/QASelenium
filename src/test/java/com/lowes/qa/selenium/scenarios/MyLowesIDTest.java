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

public class MyLowesIDTest extends ParallelizedTestBase {
	public MyLowesIDTest(String browserName, String version, String platform,
			String os) throws IOException, SAXException,
			ParserConfigurationException {
		super(browserName, version, platform, os);
		driver = DriverScriptRegistry.getDriverScript(MessageFormat.format(
				"{0}:{1}:{2}:{3}:{4}", browserName, version, platform, os, this
						.getClass().getName()), "MyLowes_ID");
	}

	@Test
	public void testMLLIListsMoveBatchMoveItems() {
		driver.setCurrentTestCase("ML_LI_Lists_Move-Batch Move Items");
		driver.setCurrentTestCaseDescription("Move the items to a new destination");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testMLLIListsVerifyWelcomeMessage() {
		driver.setCurrentTestCase("ML_LI_Lists Verify Welcome Message");
		driver.setCurrentTestCaseDescription("Verifying the welcome message in Lists page");
		driver.driveTestExecution();
	}

	@Test
	public void testMLListsVerifyListsSectionInYourAccountLandingPage() {
		driver.setCurrentTestCase("ML_Lists_Verify Lists section in Your Account landing page.");
		driver.setCurrentTestCaseDescription("Verifying the List section in Your Account Landing  page");
		driver.driveTestExecution();
	}

	@Test
	public void testMLListsSaveItemVerifySaveItemWithoutSignInAndCreatingANewUser() {
		driver.setCurrentTestCase("ML_Lists_Save Item_Verify save item without sign in and creating a new user");
		driver.setCurrentTestCaseDescription("Verify save item without sign in and creating a new user");
		driver.driveTestExecution();
	}

	@Test
	public void testMLListsWriteEntry() {
		driver.setCurrentTestCase("ML_Lists_Write Entry");
		driver.setCurrentTestCaseDescription("Verify Write Entry button from Lists Section in Your Account Landing Page");
		driver.driveTestExecution();
	}

	@Test
	public void testMLListsNotesEditNoteForLists() {
		driver.setCurrentTestCase("ML_Lists_Notes_Edit Note for Lists");
		driver.setCurrentTestCaseDescription("Verify WriteEdit Note for Lists");
		driver.driveTestExecution();
	}

	@Test
	public void testMLListsSaveItemProducts() {
		driver.setCurrentTestCase("ML_Lists_Save Item_Products");
		driver.setCurrentTestCaseDescription("Save Items to lists from Product Detail Page");
		driver.driveTestExecution();
	}

	@Test
	public void testMLListsDisplayRelatedProductDocumentsLinks() {
		driver.setCurrentTestCase("ML_Lists_Display related Product Documents links");
		driver.setCurrentTestCaseDescription("Save Items to lists which is having pdf's from Product Detail Page");
		driver.driveTestExecution();
	}

	@Test
	@Category(BuildVerificationTests.class)
	public void testMLListsVerifyDateAddedForProducts() {
		driver.setCurrentTestCase("ML_Lists_Verify Date added for products");
		driver.setCurrentTestCaseDescription("Verify Date added for products");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testMLLIVerifyTheCreationOfTheListAndNavigateToIt() {
		driver.setCurrentTestCase("ML_LI_Verify the creation of the list and navigate to it");
		driver.setCurrentTestCaseDescription("Create a new list in Lists Page");
		driver.driveTestExecution();
	}

	@Test
	public void testMLListTitleEditEmptyTitle() {
		driver.setCurrentTestCase("ML_List title Edit_Empty title");
		driver.setCurrentTestCaseDescription("Remove the name of the list  and click on save");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIVerifyThatTheNotesAddedToAListsAreDisplayedInRealTimeAndTheyCanUpdatedAndSaved() {
		driver.setCurrentTestCase("ML_LI_Verify that the notes added to a lists are displayed in real time and they can updated and saved.");
		driver.setCurrentTestCaseDescription("Add the notes and save. Edit the existing notes and update");
		driver.driveTestExecution();
	}

	@Test
	public void testMLListsRenameTitleOfItems() {
		driver.setCurrentTestCase("ML_Lists_Rename Title of Items");
		driver.setCurrentTestCaseDescription("To change the name of the produt from the list");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIVerifySaveWhenAddingOrEditingNotesOfAnEntry() {
		driver.setCurrentTestCase("ML_LI_Verify Save when adding or editing notes of an entry");
		driver.setCurrentTestCaseDescription("Verify Save when adding or editing notes of an entry");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIVerifySaveWhenEditingATitleOfAnEntry() {
		driver.setCurrentTestCase("ML_LI_Verify Save when editing a title of an entry");
		driver.setCurrentTestCaseDescription("Verify Save when editing a title of an entry");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZVerifyDropdownWhenSavingItemsForNotLoggedUsers() {
		driver.setCurrentTestCase("ML_AZ_Verify dropdown when saving items for not logged users");
		driver.setCurrentTestCaseDescription("Verify dropdown when saving items for not logged users");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIVerifyDrpDownSavingItemsPDpageAndNPC() {
		driver.setCurrentTestCase("ML_LI_VerifyDrpDown saving items PDpage and NPC");
		driver.setCurrentTestCaseDescription("Verify dropdown when saving items for logged users from product detail page and NPC; Original TC Name: ML_LI_Verify dropdown when saving items for logged users from product detail page and NPC");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testMLListsSaveItemNPC() {
		driver.setCurrentTestCase("ML_Lists_Save Item_NPC");
		driver.setCurrentTestCaseDescription("Saving NPC items");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIVerifyThatTheReminderIsNotUpdatedWhenCloseOrCancelTheAction() {
		driver.setCurrentTestCase("ML_LI_Verify that the reminder is not updated when close or cancel the action.");
		driver.setCurrentTestCaseDescription("Verify that the reminder is not updated when close or cancel the action.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLListsVerifySaveNPC() {
		driver.setCurrentTestCase("ML_Lists_Verify Save NPC");
		driver.setCurrentTestCaseDescription("Verification of saving the NPC item");
		driver.driveTestExecution();
	}

	@Test
	public void testMLListsVerifyViewAllMechanism() {
		driver.setCurrentTestCase("ML_Lists_Verify View All Mechanism");
		driver.setCurrentTestCaseDescription("Verify View All Mechanism");
		driver.driveTestExecution();
	}

	@Test
	public void testMLListsVerifyDefaultListBehavior() {
		driver.setCurrentTestCase("ML_Lists_Verify Default List Behavior");
		driver.setCurrentTestCaseDescription("Verify Default List Behavior");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIHouzzSaveToMyLowes() {
		driver.setCurrentTestCase("ML_LI_Houzz_Save to My Lowes");
		driver.setCurrentTestCaseDescription("Save the image to lists from Houzz Gallery");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIVerifyLocationPathOfAddedItemViewAllPageEditModals() {
		driver.setCurrentTestCase("ML_LI_VerifyLocationPath OfAddedItem_View All page_edit modals");
		driver.setCurrentTestCaseDescription("Verify the location path of item added showing in View All page and edit modals; Original TC Name: ML_LI_Verify the location path of item added showing in View All page and edit modals");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIFileUploadVerifyStorageLimitErrorMessageWhenCopying() {
		driver.setCurrentTestCase("ML_LI_File Upload_Verify Storage Limit Error Message when Copying");
		driver.setCurrentTestCaseDescription("Verify Storage Limit Error Message when Copying");
		driver.driveTestExecution();
	}

	@Test
	public void testMLListsVerifyActionBarItems() {
		driver.setCurrentTestCase("ML_Lists_Verify Action Bar Items");
		driver.setCurrentTestCaseDescription("Verification of action items in List page");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIFileUploadViewCurrentUsage() {
		driver.setCurrentTestCase("ML_LI_File Upload_View Current Usage");
		driver.setCurrentTestCaseDescription("To view the current usage of the upload");
		driver.driveTestExecution();
	}

	@Test
	public void testMLListsVerifyUndoDelete() {
		driver.setCurrentTestCase("ML_Lists_Verify Undo Delete");
		driver.setCurrentTestCaseDescription("To verify the Undo delete option from Lists Page");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIVerifyItemsAddedToListPresentWhenLoginNext() {
		driver.setCurrentTestCase("ML_LI_VerifyItemsAddedToListPresent When Login Next");
		driver.setCurrentTestCaseDescription("Verify the Items that were added to lists are present in when user logs in next time; Original TC Name: ML_LI_Verify the Items that were added to lists are present in when user logs in next time");
		driver.driveTestExecution();
	}

	@Test
	@Category(BuildVerificationTests.class)
	public void testMLListsRemindersAddReminderToProduct() {
		driver.setCurrentTestCase("ML_Lists_Reminders_Add Reminder to Product");
		driver.setCurrentTestCaseDescription("Validate the reminder icon present next to each item");
		driver.driveTestExecution();
	}

	@Test
	public void testMLListsSaveItemVerifySaveItemFromPurchaseHistoryPage() {
		driver.setCurrentTestCase("ML_Lists_Save Item_Verify save item from purchase history page");
		driver.setCurrentTestCaseDescription("validate the purchase date from purchases history to Lists page");
		driver.driveTestExecution();
	}

	@Test
	public void testMLListsVerifySavingOnLinePurchasesInDefaultList() {
		driver.setCurrentTestCase("ML_Lists_Verify Saving On-line purchases in default list");
		driver.setCurrentTestCaseDescription("validate the free tick mark beside saved items in purchase page");
		driver.driveTestExecution();
	}

	@Test
	public void testMLListsVerifyAnItemThumbnailsAndTitlesNavigatesCustomersToDetailPage() {
		driver.setCurrentTestCase("ML_Lists_Verify an item thumbnails and titles navigates customers to detail page.");
		driver.setCurrentTestCaseDescription("Verifying the thumbnail from product page to List page");
		driver.driveTestExecution();
	}

	@Test
	public void testMLListsShowOnlyDropdownOptionsAndResults() {
		driver.setCurrentTestCase("ML_Lists_Show only dropdown options and results");
		driver.setCurrentTestCaseDescription("Verify the drop downs in Lists page");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIVerifyThatThePriceIsCorrectlyDisplayedForProductsItemsInLists() {
		driver.setCurrentTestCase("ML_LI_Verify that the price is correctly displayed for products items in Lists");
		driver.setCurrentTestCaseDescription("verify the price in product detail page and lists page");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIListsCopyCopyItemsThroughEditModal() {
		driver.setCurrentTestCase("ML_LI_Lists_Copy-Copy Items through Edit modal");
		driver.setCurrentTestCaseDescription("Copy the items from one folder to other using Edit");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIListsNotesAddNoteToLists() {
		driver.setCurrentTestCase("ML_LI_Lists_Notes_Add Note to Lists");
		driver.setCurrentTestCaseDescription("Create a new list in Lists Page and add the notes");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIListsNotesMoreHideMechanismForLongNotes() {
		driver.setCurrentTestCase("ML_LI_Lists_Notes_More-Hide Mechanism for Long Notes");
		driver.setCurrentTestCaseDescription("Add the notes and save and verify the More and Hide buttons");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIListsRenameTitleOfAList() {
		driver.setCurrentTestCase("ML_LI_Lists_Rename Title of a List");
		driver.setCurrentTestCaseDescription("Rename the title of the list");
		driver.driveTestExecution();
	}
}
