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

public class ProductSearchSOMSBTest extends ParallelizedTestBase {
	public ProductSearchSOMSBTest(String browserName, String version,
			String platform, String os) throws IOException, SAXException,
			ParserConfigurationException {
		super(browserName, version, platform, os);
		driver = DriverScriptRegistry.getDriverScript(MessageFormat.format(
				"{0}:{1}:{2}:{3}:{4}", browserName, version, platform, os, this
						.getClass().getName()), "ProductSearch_SOM_SB");
	}

	@Test
	public void testPSAZHTML5DoctypeVerifyStoreLocatorPage() {
		driver.setCurrentTestCase("PS_AZ_HTML5 Doctype_Verify Store Locator Page");
		driver.setCurrentTestCaseDescription("");
		driver.driveTestExecution();
	}

	@Test
	public void testPSBusinessControlledPropDisableInventoryPopoverSOEItem() {
		driver.setCurrentTestCase("PS_BusinessControlledProp_DisableInventoryPopover_SOE_Item");
		driver.setCurrentTestCaseDescription("Verify that Inventory Popover for WEX (SOE) item is business controlled and won't be displayed when the feature is turned off. Verify that Inventory Popover for stocked item is NOT affected; Original TC Name: PS_Business Controlled Property_Disable Inventory Popover_WEX_SOE_Item");
		driver.driveTestExecution();
	}

	@Test
	public void testPSDefaultStateItemWithEnergyStar() {
		driver.setCurrentTestCase("PS_Default state_Item with Energy Star");
		driver.setCurrentTestCaseDescription("Test case is to validate the Energy star displayed for a default state item in grid and list view displayed for a default state item in grid and list view");
		driver.driveTestExecution();
	}

	@Test
	public void testPSClickingFreeDeliveryIconInListPageOpensAPopup() {
		driver.setCurrentTestCase("PS_Clicking Free Delivery Icon in list page opens a Popup");
		driver.setCurrentTestCaseDescription("The Purpose of this test case is to Verify that a Popup is displayed after clicking on 'Free Delivery' icon in the list page of an item with free delivery.");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIHTML5DoctypeVerifyStoreLocatorPage() {
		driver.setCurrentTestCase("PS_LI_HTML5 Doctype_Verify Store Locator Page");
		driver.setCurrentTestCaseDescription("Test case is to verify that the Store Locator page has doctype as HTML5 for Logged in user");
		driver.driveTestExecution();
	}

	@Test
	public void testPSHTML5DoctypeVerifyGiftCardPage() {
		driver.setCurrentTestCase("PS_HTML5 Doctype_Verify Gift Card Page");
		driver.setCurrentTestCaseDescription("Test case is to verify whether the doctype displayed is HTML5 for the Gift card page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSNZVerifyPrdctDescONProductListPageForAllGiftcards() {
		driver.setCurrentTestCase(" PS_NZ_VerifyPrdctDescONProduct List Page for all Giftcards");
		driver.setCurrentTestCaseDescription("Verify the Product description and information in a product list for all gift cards as a UnZipped User. Original TC Name: PS_NZ_Verify the product descriptions and information in a product List Page for all Giftcards");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZHTML5DoctypeVerifySearchPage() {
		driver.setCurrentTestCase("PS_AZ_HTML5 Doctype_Verify Search Page");
		driver.setCurrentTestCaseDescription("Verify that The Doc type on the search landing  page  matches  HTML5");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZSpecialCharacter() {
		driver.setCurrentTestCase("PS_AZ_Special character");
		driver.setCurrentTestCaseDescription("Verifies if system takes the special character '&'");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZPositiveFunctionalTestForBrowser() {
		driver.setCurrentTestCase("PS_AZ_ Positive Functional Test for Browser");
		driver.setCurrentTestCaseDescription("Verifying the Functionality of the Misspelled Search.");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZPositiveFuncitionalTest() {
		driver.setCurrentTestCase("PS_AZ_Positive Funcitional Test");
		driver.setCurrentTestCaseDescription("Verifying the Functionality of the Misspelled Search and all the links in the Search Page.");
		driver.driveTestExecution();
	}

	@Test
	public void testPSItemFutureAvailablityWithLeadTimeSC() {
		driver.setCurrentTestCase("PS_Item_futureAvailablity with lead time_SC");
		driver.setCurrentTestCaseDescription("The Purpose of this test case is to Verify that the item with lead time is available(delivery method) in the shopping cart page. Original TC Name: PS_Item with future availablity with lead time becomes unavailable in the shopping cart page.");
		driver.driveTestExecution();
	}

	@Test
	public void testPSBazaarVoiceAnswerAQuestionUnauthenticatedUser() {
		driver.setCurrentTestCase("PS_BazaarVoice_Answer A Question_Unauthenticated User");
		driver.setCurrentTestCaseDescription("Verify that an authenticated user is able to submit a Review to an item.");
		driver.driveTestExecution();
	}

	@Test
	public void testPSBazaarVoiceAskAQuestionUnauthenticatedUser() {
		driver.setCurrentTestCase("PS_BazaarVoice_Ask a Question_Unauthenticated User");
		driver.setCurrentTestCaseDescription("Verify that an authenticated user is able to ask a question");
		driver.driveTestExecution();
	}

	@Test
	public void testPSBazaarVoiceMarkingAReviewAsHelpful() {
		driver.setCurrentTestCase("PS_BazaarVoice_Marking a Review As Helpful");
		driver.setCurrentTestCaseDescription("Test case is to verify whether the user is able to mark a review as helpful. Original TC Name: PS_BazaarVoice_Marking a Review As Helpful_Positive Functional Test");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZVerifyTheFunctionalityOfTheStarsRatingsLinks() {
		driver.setCurrentTestCase("PS_AZ_ Verify the functionality of the stars ratings links");
		driver.setCurrentTestCaseDescription("Verify the Functionality of the stars rating links");
		driver.driveTestExecution();
	}

	@Test
	@Category(BuildVerificationTests.class)
	public void testPSAZVerifyleftNavigatorPerformASearchInAListPage() {
		driver.setCurrentTestCase("PS_AZ_ Verifyleft navigator_perform a search in a List page");
		driver.setCurrentTestCaseDescription("Verify whether the left Navigator works properly  in a List Page after performing a Search operation. Original TC Name: PS_AZ_ Verify that the left navigator works properly after perform a search in a List page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZCategoryPageVerifyInfoDisplayedCategoryPage() {
		driver.setCurrentTestCase("PS_AZ_Category pageVerifyInfo Displayed_category page");
		driver.setCurrentTestCaseDescription("Verify that the left Navigator works properly after browse a Product List; Original TC Name: PS_AZ_Category page_Verify the information displayed after access to a category page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZProductDescriptionsOnListViewListPage() {
		driver.setCurrentTestCase("PS_AZ_Product Descriptions on List View List Page");
		driver.setCurrentTestCaseDescription("Verify the Product descriptions in a List Page");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testPSAZVerifyLeftNavigatorAfterBrowseAProductList() {
		driver.setCurrentTestCase("PS_AZ_VerifyLeft navigatorAfter browse a product list");
		driver.setCurrentTestCaseDescription("Original TC Name:PS_AZ_Sup Cat & Cat page_Verify that the left navigator works properly after browse a product list");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZProductListPageReviewsUserInterface() {
		driver.setCurrentTestCase("PS_AZ_ Product List page reviews_User Interface");
		driver.setCurrentTestCaseDescription("To verify the GUI layout of the Ratings & Review section for products that have no reviews and products that have reviews");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZVerifyInfoSuperCategoryPage() {
		driver.setCurrentTestCase("PS_AZ_VerifyInfoSuper Category page");
		driver.setCurrentTestCaseDescription("Verify the  information displayed after access to a super category page; Original TC Name: PS_AZ_Verify the information displayed after access to a Super Category page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZPopulatingDomForFacets() {
		driver.setCurrentTestCase("PS_AZ_Populating Dom for facets");
		driver.setCurrentTestCaseDescription("Verifying the Populating Dom for facets");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZBreadcrumb() {
		driver.setCurrentTestCase("PS_AZ_Breadcrumb");
		driver.setCurrentTestCaseDescription("Testcase is to Verify  a defect found related to breadcrumb");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZSearch() {
		driver.setCurrentTestCase("PS_AZ_Search");
		driver.setCurrentTestCaseDescription("Verify the Max and Min Messaging in the Search page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZDetailPageCompleteTheSetModule() {
		driver.setCurrentTestCase("PS_AZ_Detail page_Complete the Set module");
		driver.setCurrentTestCaseDescription("Verifying the Complete the Set Module in a product detail page");
		driver.driveTestExecution();
	}

	@Test
	@Category(BuildVerificationTests.class)
	public void testPSSearchMessagingDefaultOrMisspelledWord() {
		driver.setCurrentTestCase("PS_Search messaging Default or misspelled word");
		driver.setCurrentTestCaseDescription("Test case is to validate the search functionality when mispelled or default word is provided");
		driver.driveTestExecution();
	}

	@Test
	@Category(BuildVerificationTests.class)
	public void testPSSearchMatchModificationsSearchResultCorresPages() {
		driver.setCurrentTestCase(" PS_SearchMatchModifications_Search resultCorresPages");
		driver.setCurrentTestCaseDescription("Test case is to validate the search results displayed when different words are provided for search bar; Original TC Name: PS_Search Engine Match Mode Modifications_Search result and corresponding pages");
		driver.driveTestExecution();
	}

	@Test
	public void testPSSEOImprovementsRemoveHrefsLeftNavigation() {
		driver.setCurrentTestCase("PS_SEO improvements Remove hrefs_Left Navigation");
		driver.setCurrentTestCaseDescription("The test case verifies if left navigation is no more displayed as hyperlink.");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZMULTIListAndDetailPageThroughDepartment() {
		driver.setCurrentTestCase("PS_AZ_MULTI_List & Detail Page through Department");
		driver.setCurrentTestCaseDescription("Test case is to validate the List page when Rebate items are added to the lists");
		driver.driveTestExecution();
	}

	@Test
	@Category(BuildVerificationTests.class)
	public void testPSAZInspectWasPriceSavePercentThruDateDetailPg() {
		driver.setCurrentTestCase("PS_AZ_InspectWasPriceSavePercentThruDate DetailPg");
		driver.setCurrentTestCaseDescription("Verify the Was price,Save Percentage and Thru Date in a detail page. Original TC Name: PS_AZ_Inspect Was Price, Save percentage and Thru Date in Detail Page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIMULTISPEcoLTDPSOrderConfPgSuccessMsg() {
		driver.setCurrentTestCase("PS_LI_MULTI_[SP(eco)+LTD+PS]OrderConfPg_SuccessMsg");
		driver.setCurrentTestCaseDescription("Test case is to verify the success message displayed in the Order confirmation page when Rebate items are purchased");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIMULTISPEcoLTDPSOrderConfPgLineItemMessage() {
		driver.setCurrentTestCase("PS_LI_MULTI_[SP(eco)+LTD+PS]OrderConfPg_LineItemMessage");
		driver.setCurrentTestCaseDescription("Test case is to verify the success message displayed in the Order confirmation page when Rebate items are purchased; Oribinal TC Name: PS_LI_MULTI_[SP(eco)+LTD+PS] Order Confirmaiton page Line Item Level Message");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testPSAZMultiSelectFacetbrowserBackNavPaginationHistory() {
		driver.setCurrentTestCase("PS_AZ_MultiSelectFacetbrowserBack_nav _pagination history");
		driver.setCurrentTestCaseDescription("The test  case verifies if facets selected by customer remains selected even though user click to browser's back button. Original TC Name: PS_AZ_Multi-selected facets with browser back button_navigation_pagination history");
		driver.driveTestExecution();
	}

	@Test
	public void testPSH1TagsRemDottedLinesForSearchedItem() {
		driver.setCurrentTestCase("PS_H1 Tags Rem_DottedLinesForSearched item");
		driver.setCurrentTestCaseDescription("Test case is to validate whether the Dotted lines are removed for searched item; Original TC Name:PS_H1 Tags Remove Dotted lines for searched item");
		driver.driveTestExecution();
	}

	@Test
	public void testPSH1TagsRemDottedLinesNavigatingThruProducts() {
		driver.setCurrentTestCase("PS_H1 TagsRemDottedLinesNavigatingThru products");
		driver.setCurrentTestCaseDescription("Test case is to validate whether the dotted lines are removed while navigating through products; Original TC: PS_H1 Tags Remove Dotted lines when navigating thru products");
		driver.driveTestExecution();
	}

	@Test
	public void testPSNZLeftNavRelatedCatOnCategoryPages() {
		driver.setCurrentTestCase("PS_NZ_ Left navRelatedCatOn Category pages");
		driver.setCurrentTestCaseDescription("Verify that the Left Navigation and Related Categories are displaying properly on each page. Original TC Name: PS_NZ_ Left nav and Related Categories are not displaying on certain Category pages");
		driver.driveTestExecution();
	}

	@Test
	public void testPSH1TagsForPromotionalItems() {
		driver.setCurrentTestCase("PS_H1 Tags for promotional items");
		driver.setCurrentTestCaseDescription("Test case is to validate the H1 tags for promotional items");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZBxGy2XEcoYRegCartPage() {
		driver.setCurrentTestCase("PS_AZ_[BxGy] [2 (x=eco+y=reg)] Cart Page");
		driver.setCurrentTestCaseDescription("Test case is to validate the Cart page when Rebate items are added to the cart");
		driver.driveTestExecution();
	}

	@Test
	public void testPSCheckSubtotalMinMulQtyInProductDetailsPage() {
		driver.setCurrentTestCase("PS_Check subtotalMinMulQty in product details page");
		driver.setCurrentTestCaseDescription("This test case validates the subtotal for min/mul quantity in product details page. Original TC Name: PS_Check subtotal for min mul quantity in product details page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZVerifySquareFootPricingNewFeaturesInAListPage() {
		driver.setCurrentTestCase("PS_AZ_Verify Square Foot Pricing new features in a List page");
		driver.setCurrentTestCaseDescription("Verify the  Square Foot Pricing news features in a Product List page.");
		driver.driveTestExecution();
	}

	@Test
	public void testPSCategoryResultsPageBreadBoxAllrefinements() {
		driver.setCurrentTestCase("PS_Category Results Page_BreadBox_Allrefinements");
		driver.setCurrentTestCaseDescription("Verify the refinements selected in the left rail are displayed in the Filter Bread Box.");
		driver.driveTestExecution();
	}

	@Test
	public void testPSCategoryResultsPageLeftRail() {
		driver.setCurrentTestCase("PS_Category Results Page_Left Rail");
		driver.setCurrentTestCaseDescription("Verify Category Results page always contain a Left Rail");
		driver.driveTestExecution();
	}

	@Test
	public void testPSCategoryPageLeftRailCategoryResultsPage() {
		driver.setCurrentTestCase("PS_Category Page_Left Rail_Category Results Page");
		driver.setCurrentTestCaseDescription("Verify Category Results Page displayed when clicking on the refinements.");
		driver.driveTestExecution();
	}

	@Test
	public void testPSCommunityStoriesHero() {
		driver.setCurrentTestCase("PS_Community Stories_Hero");
		driver.setCurrentTestCaseDescription("Verify Hero for Community Story page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSCommunityStoriesShareYourStoryModule() {
		driver.setCurrentTestCase("PS_Community Stories_Share Your Story Module");
		driver.setCurrentTestCaseDescription("Verify Share Your Story Module on CS Page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLandingPageNav() {
		driver.setCurrentTestCase("PS_Landing Page_Nav");
		driver.setCurrentTestCaseDescription("Verify LCI Landing page displayed by navigating through Masthead.");
		driver.driveTestExecution();
	}

	@Test
	@Category(BuildVerificationTests.class)
	public void testPSAZSupCatAndCatPageSortByVerifyBestMatch() {
		driver.setCurrentTestCase("PS_AZ_ Sup Cat & Cat page_Sort by_VerifyBest Match");
		driver.setCurrentTestCaseDescription("Verify the catalog Ordered by 'Best Match'; Original TC Name: PS_AZ_ Sup Cat & Cat page_Sort by_Verify the catalog ordering by Best Match");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZSupCatAndCatPageVerifySortByBrands() {
		driver.setCurrentTestCase(" PS_AZ_Sup Cat & Cat page_VerifySortByBrands");
		driver.setCurrentTestCaseDescription("Verify the catalog Ordered by 'Popular Brands'; Original TC Name: PS_AZ_Sup Cat & Cat page_Popular Brands_Verify the catalog ordering by Popular Brands");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZSupCatAndCatPageSortByBestSeller() {
		driver.setCurrentTestCase(" PS_AZ_Sup Cat & Cat page_Sort by_Best Seller");
		driver.setCurrentTestCaseDescription("Verify the catalog Ordereed by 'Best Seller'; Original TC Name: PS_AZ_Sup Cat & Cat page_Sort by_Verify the catalog ordering by Best Seller");
		driver.driveTestExecution();
	}

	@Test
	@Category(BuildVerificationTests.class)
	public void testPSAZCheckFreeDeliverMajoApplianceListDetailPag() {
		driver.setCurrentTestCase("PS_AZ_CheckFreeDeliverMajo Appliance list, detail pag");
		driver.setCurrentTestCaseDescription("Verify that 'Free delivery' is displayed for all qualified major appliance list; Original TC Name: PS_AZ_Check Free Delivery for qualified major Appliance list, detail page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZMAPRelatedItems() {
		driver.setCurrentTestCase("PS_AZ_MAP_Related Items");
		driver.setCurrentTestCaseDescription("Verify that if MAP displayed in Related Items section.");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZMAPCustomerAlsoViewedItems() {
		driver.setCurrentTestCase("PS_AZ_MAP_Customer Also Viewed Items");
		driver.setCurrentTestCaseDescription("Verify that if MAP displayed in Customer Also Viewed section.");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZMAPBuyThePair() {
		driver.setCurrentTestCase("PS_AZ_MAP_Buy the Pair");
		driver.setCurrentTestCaseDescription("Verify that if MAP displayed in Buy the Pair section on detail page.");
		driver.driveTestExecution();
	}
}
