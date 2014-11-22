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

public class ProductSearchSOMSNTest extends ParallelizedTestBase {
	public ProductSearchSOMSNTest(String browserName, String version,
			String platform, String os) throws IOException, SAXException,
			ParserConfigurationException {
		super(browserName, version, platform, os);
		driver = DriverScriptRegistry.getDriverScript(MessageFormat.format(
				"{0}:{1}:{2}:{3}:{4}", browserName, version, platform, os, this
						.getClass().getName()), "ProductSearch_SOM_SN");
	}

	@Test
	public void testPSAZMiniCartAddedToCartSuccessfullyMessageDisplayed() {
		driver.setCurrentTestCase("PS_AZ_Mini Cart_Added to Cart Successfully_Message Displayed");
		driver.setCurrentTestCaseDescription("Mini Cart_Added to Cart Successfully_Message Displayed");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZVerifyStoreLocatorDisplayDisambiguationDisplay() {
		driver.setCurrentTestCase("PS_AZ_Verify Store Locator_Display Disambiguation display");
		driver.setCurrentTestCaseDescription("Verify Store Locator_Display Disambiguation display");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZVerifyStoreLocatorCanadaStores() {
		driver.setCurrentTestCase("PS_AZ_Verify Store Locator_Canada stores");
		driver.setCurrentTestCaseDescription("Verify Store Locator_Canada stores");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIDigitalElementAutozip() {
		driver.setCurrentTestCase("PS_LI_Digital Element_Autozip");
		driver.setCurrentTestCaseDescription("Digital Element_Autozip");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZHTML5DoctypeVerifyHomePage() {
		driver.setCurrentTestCase("PS_AZ_HTML5 Doctype_Verify Home Page");
		driver.setCurrentTestCaseDescription("HTML5 Doctype_Verify Home Page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZMiniCartDropdownCheckoutPages() {
		driver.setCurrentTestCase("PS_AZ_Mini Cart Dropdown_Checkout Pages");
		driver.setCurrentTestCaseDescription("Mini Cart Dropdown_Checkout Pages");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZMiniCartAddToCartNotificationModalLumberPriceGrid() {
		driver.setCurrentTestCase("PS_AZ_Mini Cart_Add to cart Notification Modal_Lumber Price Grid");
		driver.setCurrentTestCaseDescription("Mini Cart_Add to cart Notification Modal_Lumber Price Grid");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIMiniCartAddToCartNotificationModalLumberPriceGrid() {
		driver.setCurrentTestCase("PS_LI_Mini Cart_Add to cart Notification Modal_Lumber Price Grid");
		driver.setCurrentTestCaseDescription("Mini Cart_Add to cart Notification Modal_Lumber Price Grid");
		driver.driveTestExecution();
	}

	@Test
	public void testPSCategoryPageFeaturedBannerCluster() {
		driver.setCurrentTestCase("PS_Category Page_Featured Banner Cluster");
		driver.setCurrentTestCaseDescription("Category Page_Featured Banner Cluster");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZMiniCartAddedToCartNotificationModalEPP() {
		driver.setCurrentTestCase("PS_AZ_Mini Cart_Added to Cart_Notification Modal_EPP");
		driver.setCurrentTestCaseDescription("Mini Cart_Added to Cart_Notification Modal_EPP");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIMiniCartAddedToCartNotificationModalListPage() {
		driver.setCurrentTestCase("PS_LI_MiniCart_Added to Cart Notification Modal_List Page");
		driver.setCurrentTestCaseDescription("MiniCart_Added to Cart Notification Modal_List Page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSCategoryResultsPageActionBarPaginationControls() {
		driver.setCurrentTestCase("PS_Category Results Page_Action Bar_Pagination Controls");
		driver.setCurrentTestCaseDescription("Category Results Page_Action Bar_Pagination Controls");
		driver.driveTestExecution();
	}

	@Test
	public void testPSMastHeadAndMegaMenuHouzz() {
		driver.setCurrentTestCase("PS_MastHead&Mega Menu_Houzz");
		driver.setCurrentTestCaseDescription("MastHead&Mega Menu_Houzz");
		driver.driveTestExecution();
	}

	@Test
	public void testPSNPCSearchResultsPageB15240ToggleFromProductToNonProduct() {
		driver.setCurrentTestCase("PS_NPC Search Results Page_B-15240_Toggle from Product to Non Product");
		driver.setCurrentTestCaseDescription("Search Results Page_B-15240_Toggle from Product to Non Product");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testPSAZMiniCartAddToCartNotificationModalGiftCard() {
		driver.setCurrentTestCase("PS_AZ_Mini Cart_Add to cart Notification Modal_Gift Card");
		driver.setCurrentTestCaseDescription("Mini Cart_Add to cart Notification Modal_Gift Card");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIMiniCartAddToCartNotificationModalGiftCard() {
		driver.setCurrentTestCase("PS_LI_Mini Cart_Add to cart Notification Modal_Gift Card");
		driver.setCurrentTestCaseDescription("Mini Cart_Add to cart Notification Modal_Gift Card");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIVerifyStoreLocatorPopupStoreInfo() {
		driver.setCurrentTestCase("PS_LI_Verify Store Locator popup_store info");
		driver.setCurrentTestCaseDescription("Verify Store Locator popup_store info");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZMiniCartAddedToCartNotificationModalComparePage() {
		driver.setCurrentTestCase("PS_AZ_Mini-Cart_Added to Cart Notification Modal_Compare Page");
		driver.setCurrentTestCaseDescription("Mini-Cart_Added to Cart Notification Modal_Compare Page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSMastHeadAndMegaMenuHowTos() {
		driver.setCurrentTestCase("PS_MastHead&Mega Menu_How tos");
		driver.setCurrentTestCaseDescription("MastHead&Mega Menu_How tos");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIMiniCartAddedToCartNotificationModalComparePage() {
		driver.setCurrentTestCase("PS_LI_Mini-Cart_Added to Cart Notification Modal_Compare Page");
		driver.setCurrentTestCaseDescription("Mini-Cart_Added to Cart Notification Modal_Compare Page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIMiniCartAddedToCartNotificationModalProductDetailPage() {
		driver.setCurrentTestCase("PS_LI_Mini-Cart_Added to Cart Notification Modal_Product Detail Page");
		driver.setCurrentTestCaseDescription("Mini-Cart_Added to Cart Notification Modal_Product Detail Page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZMAPCatAndSuperCat() {
		driver.setCurrentTestCase("PS_AZ_MAP_Cat and Super Cat");
		driver.setCurrentTestCaseDescription("MAP_Cat and Super Cat");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZMAPComparePage() {
		driver.setCurrentTestCase("PS_AZ_MAP_Compare page");
		driver.setCurrentTestCaseDescription("AZ_MAP_Compare page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZMAPDetailPage() {
		driver.setCurrentTestCase("PS_AZ_MAP_Detail Page");
		driver.setCurrentTestCaseDescription("AZ_MAP_Detail Page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZMAPListPage() {
		driver.setCurrentTestCase("PS_AZ_MAP_List page");
		driver.setCurrentTestCaseDescription("AZ_MAP_List page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZMiniCartAddedToCartNotificationModalWithRTFAddedDetailPage() {
		driver.setCurrentTestCase("PS_AZ_MiniCart_Added to Cart Notification Modal_with RTF Added_Detail Page");
		driver.setCurrentTestCaseDescription("MiniCart_Added to Cart Notification Modal_with RTF Added_Detail Page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZMiniCartAddedToCartNotificationModalWithEPPAndRTFDetailPage() {
		driver.setCurrentTestCase("PS_AZ_Mini-Cart_Added to Cart Notification Modal_with EPP and RTF_Detail Page");
		driver.setCurrentTestCaseDescription("Mini-Cart_Added to Cart Notification Modal_with EPP and RTF_Detail Page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIMiniCartAddedToCartNotificationModalWithEPPAndRTFDetailPage() {
		driver.setCurrentTestCase("PS_LI_Mini-Cart_Added to Cart Notification Modal_with EPP and RTF_Detail Page");
		driver.setCurrentTestCaseDescription("");
		driver.driveTestExecution();
	}

	@Test
	public void testPSNPCSearchResultsPageFilterBehavior() {
		driver.setCurrentTestCase("PS_NPC Search Results Page_Filter Behavior");
		driver.setCurrentTestCaseDescription(" Search Results Page_Filter Behavior");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZFilterBoxEnhancement() {
		driver.setCurrentTestCase("PS_AZ_Filter box enhancement");
		driver.setCurrentTestCaseDescription("Filter box enhancement");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZVerifyTheUserIsAbleToSearchForAStoreByClickingTheChangeStoreLinkPOS() {
		driver.setCurrentTestCase("PS_AZ_Verify the user is able to search for a store by clicking the Change store link_POS");
		driver.setCurrentTestCaseDescription("Verify the user is able to search for a store by clicking the Change store link_POS");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIVerifyStoreLocatorPopupChangeStore() {
		driver.setCurrentTestCase("PS_LI_Verify Store Locator popup_Change store");
		driver.setCurrentTestCaseDescription("Verify Store Locator popup_Change store");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZMAPSuggestedRetailPriceStrikethruInGridView() {
		driver.setCurrentTestCase("PS_AZ_MAP suggested retail price strikethru in Grid View");
		driver.setCurrentTestCaseDescription("MAP suggested retail price strikethru in Grid View");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZMAPBuyThePair() {
		driver.setCurrentTestCase("PS_AZ_MAP_Buy the Pair");
		driver.setCurrentTestCaseDescription("MAP_Buy the Pair");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIHTML5DoctypeVerifyCategoryAndListPage() {
		driver.setCurrentTestCase("PS_LI_HTML5 Doctype_Verify Category and List Page");
		driver.setCurrentTestCaseDescription("HTML5 Doctype_Verify Category and List Page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZHTML5DoctypeVerifyCategoryAndListPage() {
		driver.setCurrentTestCase("PS_AZ_HTML5 Doctype_Verify Category and List Page");
		driver.setCurrentTestCaseDescription("HTML5 Doctype_Verify Category and List Page");
		driver.driveTestExecution();
	}
}
