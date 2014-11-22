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

public class ProductSearchSOMMFTest extends ParallelizedTestBase {
	public ProductSearchSOMMFTest(String browserName, String version,
			String platform, String os) throws IOException, SAXException,
			ParserConfigurationException {
		super(browserName, version, platform, os);
		driver = DriverScriptRegistry.getDriverScript(MessageFormat.format(
				"{0}:{1}:{2}:{3}:{4}", browserName, version, platform, os, this
						.getClass().getName()), "ProductSearch_SOM_MF");
	}

	@Test
	public void testGiftCardPickupDeliveryUnavailableShippingAvailable() {
		driver.setCurrentTestCase("Gift Card_Pickup_Delivery Unavailable_Shipping_Available");
		driver.setCurrentTestCaseDescription("PS_AZ_Detail Page_Gift Card_Pickup, Delivery Unavailable_Shipping(FREE) Available");
		driver.driveTestExecution();
	}

	@Test
	public void testSTKPickupDeliveryShippingUnavailable() {
		driver.setCurrentTestCase("STK_Pickup_Delivery_Shipping Unavailable");
		driver.setCurrentTestCaseDescription("PS_AZ_Detail Page_STK_Pickup, Delivery & Shipping Unavailable");
		driver.driveTestExecution();
	}

	@Test
	@Category(SmokeTests.class)
	public void testSTKPickupDeliveryUnavailableShippingAvailable() {
		driver.setCurrentTestCase("STK_Pickup_Delivery Unavailable_Shipping Available");
		driver.setCurrentTestCaseDescription("PS_AZ_Detail Page_STK_Pickup, Delivery Unavailable_Shipping Available");
		driver.driveTestExecution();
	}

	@Test
	public void testPickupDeliveryAvailableShippingUnavailable() {
		driver.setCurrentTestCase("Pickup_Delivery Available_Shipping Unavailable");
		driver.setCurrentTestCaseDescription("PS_AZ_Detail Page_STK_Pickup, Delivery Available_Shipping Unavailable");
		driver.driveTestExecution();
	}

	@Test
	public void testSTKEPPPickupDeliveryAvailableShippingUnavailable() {
		driver.setCurrentTestCase("STK_EPP_Pickup Delivery_Available_Shipping Unavailable");
		driver.setCurrentTestCaseDescription("PS_AZ_Detail Page_STK+EPP_Pickup, Delivery (FREE) Available_Shipping Unavailable");
		driver.driveTestExecution();
	}

	@Test
	public void testSTKPickupDeliveryShippingAvailable() {
		driver.setCurrentTestCase("STK_Pickup_Delivery_Shipping Available");
		driver.setCurrentTestCaseDescription("PS_AZ_Detail Page_STK_Pickup, Delivery & Shipping Available");
		driver.driveTestExecution();
	}

	@Test
	public void testWEXEPPPickupDeliveryAvailableShippingUnavailable() {
		driver.setCurrentTestCase("WEX_EPP_Pickup_Delivery_Available_Shipping Unavailable");
		driver.setCurrentTestCaseDescription("PS_AZ_Detail Page_WEX+EPP_Pickup, Delivery(FREE) Available_Shipping Unavailable");
		driver.driveTestExecution();
	}

	@Test
	public void testSOSPickupDeliveryAvailableShippingUnavailable() {
		driver.setCurrentTestCase("SOS_Pickup_Delivery_Available_Shipping Unavailable");
		driver.setCurrentTestCaseDescription("PS_AZ_Detail Page_SOS_Pickup, Delivery Available_Shipping Unavailable");
		driver.driveTestExecution();
	}

	@Test
	public void testSOSEPPPickupDeliveryAvailableShippingUnavailable() {
		driver.setCurrentTestCase("SOS_EPP_Pickup_Delivery_Available_Shipping Unavailable");
		driver.setCurrentTestCaseDescription("PS_AZ_Detail Page_SOS+EPP_Pickup, Delivery(FREE) Available_Shipping Unavailable");
		driver.driveTestExecution();
	}

	@Test
	public void testSOSVDYPickupDeliveryShippingAvailable() {
		driver.setCurrentTestCase("SOS_VD=Y_Pickup_Delivery_Shipping Available");
		driver.setCurrentTestCaseDescription("PS_AZ_Detail Page_SOS VD=Y_Pickup, Delivery & Shipping(FREE) Available");
		driver.driveTestExecution();
	}

	@Test
	public void testSOSEPickupDeliveryUnavailableShippingAvailable() {
		driver.setCurrentTestCase("SOSE_Pickup_ Delivery_Unavailable_Shipping Available");
		driver.setCurrentTestCaseDescription("PS_AZ_Detail Page_SOSE_Pickup, Delivery Unavailable_Shipping(FREE) Available");
		driver.driveTestExecution();
	}

	@Test
	public void testWEXPickupDeliveryAvailableShippingUnavailable() {
		driver.setCurrentTestCase("WEX_Pickup_Delivery_Available_Shipping Unavailable");
		driver.setCurrentTestCaseDescription("PS_AZ_Detail Page_WEX_Pickup, Delivery Available_Shipping Unavailable");
		driver.driveTestExecution();
	}

	@Test
	public void testWEXPickupDeliveryShippingUnavailable() {
		driver.setCurrentTestCase("WEX_Pickup_Delivery_Shipping Unavailable");
		driver.setCurrentTestCaseDescription("PS_AZ_Detail Page_WEX_Pickup, Delivery & Shipping Unavailable");
		driver.driveTestExecution();
	}

	@Test
	public void testSTKPickupAvailableDeliveryShippingUnavailable() {
		driver.setCurrentTestCase("STK_Pickup_Available_ Delivery_Shipping Unavailable");
		driver.setCurrentTestCaseDescription("PS_AZ_Detail Page_STK_Pickup Available_ Delivery & Shipping Unavailable");
		driver.driveTestExecution();
	}

	@Test
	public void testAddToCartSTKPickupDeliveryUnavailableShippingAvailable() {
		driver.setCurrentTestCase("Add to Cart_STK_Pickup_Delivery Unavailable_Shipping Available");
		driver.setCurrentTestCaseDescription("PS_AZ_Add to Cart_STK_Pickup, Delivery Unavailable_Shipping Available");
		driver.driveTestExecution();
	}

	@Test
	public void testAddToCartSTKEPPPickupDeliveryAvailableShippingUnavailable() {
		driver.setCurrentTestCase("Add to Cart_STK_EPP_Pickup_Delivery Available_Shipping Unavailable");
		driver.setCurrentTestCaseDescription("PS_AZ_Add to Cart_STK+EPP_Pickup, Delivery Available_Shipping Unavailable");
		driver.driveTestExecution();
	}

	@Test
	public void testAddToCartSTKPickupDeliveryAvailableShippingUnavailable() {
		driver.setCurrentTestCase("Add to Cart_STK_Pickup_Delivery Available_Shipping Unavailable");
		driver.setCurrentTestCaseDescription("PS_AZ_Add to Cart_STK_Pickup, Delivery (FREE) Available_Shipping Unavailable");
		driver.driveTestExecution();
	}

	@Test
	public void testAddToCartSTKPickupDeliveryShippingAvailable() {
		driver.setCurrentTestCase("Add to Cart_STK_Pickup_Delivery_Shipping Available");
		driver.setCurrentTestCaseDescription("PS_AZ_Add to Cart_STK_Pickup, Delivery & Shipping Available");
		driver.driveTestExecution();
	}

	@Test
	public void testAddToCartSTKPickupDeliveryAvailableShippingUnavailableCS() {
		driver.setCurrentTestCase("Add to Cart_STK_Pickup_Delivery Available_Shipping Unavailable_CS");
		driver.setCurrentTestCaseDescription("PS_AZ_Add to Cart_STK_Pickup, Delivery Available_Shipping Unavailable_Change Store");
		driver.driveTestExecution();
	}

	@Test
	public void testAddToCartSTKPickupDeliveryShippingAvailableCS() {
		driver.setCurrentTestCase("Add to Cart_STK_Pickup_Delivery_Shipping Available_CS");
		driver.setCurrentTestCaseDescription("PS_AZ_Add to Cart_STK_Pickup, Delivery & Shipping Available_Change Store");
		driver.driveTestExecution();
	}

	@Test
	public void testAddToCartWEXPickupDeliveryAvailableShippingUnavailable() {
		driver.setCurrentTestCase("Add to Cart_WEX_Pickup_Delivery Available_Shipping Unavailable");
		driver.setCurrentTestCaseDescription("PS_Add to Cart_WEX_Pickup, Delivery Available_Shipping Unavailable_Change Store_Pickup");
		driver.driveTestExecution();
	}

	@Test
	public void testAddToCartWEXEPPPickupDeliveryAvailableShippingUnavailable() {
		driver.setCurrentTestCase("Add to Cart_WEX_EPP_Pickup_Delivery Available_Shipping Unavailable");
		driver.setCurrentTestCaseDescription("PS_Add to Cart_WEX+EPP_Pickup, Delivery(FREE) Available_Shipping Unavailable_Delivery");
		driver.driveTestExecution();
	}

	@Test
	public void testAddToCartWEXEPPRIPickupDeliveryAvailableShippingUnavailable() {
		driver.setCurrentTestCase("Add to Cart_WEX_EPP_RI_Pickup_Delivery Available_Shipping Unavailable");
		driver.setCurrentTestCaseDescription("PS_Add to Cart_WEX+EPP+Related Item_Pickup, Delivery Available_Shipping Unavailable");
		driver.driveTestExecution();
	}

	@Test
	public void testAddToCartWEXRTFEPPPickupDeliveryAvailableShippingUnavailable() {
		driver.setCurrentTestCase("Add to Cart_WEX_RTF_EPP_Pickup_Delivery Available_Shipping Unavailable");
		driver.setCurrentTestCaseDescription("PS_AZ_Add to Cart_WEX+RTF+EPP_Pickup, Delivery Available_Shipping Unavailable_Pickup");
		driver.driveTestExecution();
	}

	@Test
	public void testAddToCartSOSPickupDeliveryAvailableShippingUnavailablePickup() {
		driver.setCurrentTestCase("Add to Cart_SOS_Pickup_Delivery Available_Shipping Unavailable_Pickup");
		driver.setCurrentTestCaseDescription("PS_AZ_Add to Cart_SOS_Pickup, Delivery Available_Shipping Unavailable_Pickup");
		driver.driveTestExecution();
	}

	@Test
	public void testAddToCartSOSEPPPickupDeliveryAvailableShippingUnavailable() {
		driver.setCurrentTestCase("Add to Cart_SOS_EPP_Pickup_Delivery Available_Shipping Unavailable");
		driver.setCurrentTestCaseDescription("PS_AZ_Add to Cart_SOS+EPP_Pickup, Delivery(FREE) Available_Shipping Unavailable_Delivery");
		driver.driveTestExecution();
	}

	@Test
	public void testAddToCartSOSVDYPickupDeliveryShippingAvailableShipping() {
		driver.setCurrentTestCase("Add to Cart_SOS VD=Y_Pickup_Delivery Shipping Available_Shipping");
		driver.setCurrentTestCaseDescription("PS_AZ_Add to Cart_SOS VD=Y_Pickup, Delivery & Shipping(FREE) Available_Shipping");
		driver.driveTestExecution();
	}

	@Test
	public void testAddToCartSOSEPickupDeliveryUnavailableShippingAvailable() {
		driver.setCurrentTestCase("Add to Cart_SOSE_Pickup_Delivery Unavailable_Shipping Available");
		driver.setCurrentTestCaseDescription("PS_AZ_Add to Cart_SOSE_Pickup, Delivery Unavailable_Shipping(FREE) Available");
		driver.driveTestExecution();
	}

	@Test
	public void testAddToCartGiftCardPickupDeliveryUnavailableShippingAvailable() {
		driver.setCurrentTestCase("Add to Cart_Gift Card_Pickup_Delivery Unavailable_Shipping Available");
		driver.setCurrentTestCaseDescription("PS_AZ_Add to Cart_Gift Card_Pickup, Delivery Unavailable_Shipping(FREE) Available");
		driver.driveTestExecution();
	}

	@Test
	public void testAddToCartSTKPickupDeliveryShippingUnavailableUnavailable5Stores() {
		driver.setCurrentTestCase("Add to Cart_STK_Pickup_Delivery Shipping Unavailable_Unavailable 5 Stores");
		driver.setCurrentTestCaseDescription("PS_AZ_Add to Cart_STK_Pickup, Delivery & Shipping Unavailable_Future Unavailable 5 Stores");
		driver.driveTestExecution();
	}

	@Test
	public void testAddToCartSTKPickupDeliveryShippingAvailableUnavailable5Stores() {
		driver.setCurrentTestCase("Add to Cart_STK_Pickup_Delivery Shipping Available_Unavailable 5 Stores");
		driver.setCurrentTestCaseDescription("PS_AZ_Add to Cart_STK_Pickup, Delivery & Shipping Available_Future Unavailable 5 Stores");
		driver.driveTestExecution();
	}

	@Test
	public void testAddToCartWEXPickupDeliveryShippingUnavailableAtLeast1() {
		driver.setCurrentTestCase("Add to Cart_WEX_Pickup_Delivery Shipping Unavailable_at least 1");
		driver.setCurrentTestCaseDescription("PS_AZ_Add to Cart_WEX_Pickup, Delivery & Shipping Unavailable_at least 1 store from another warehouse available");
		driver.driveTestExecution();
	}

	@Test
	public void testAddToCartWEXPickupDeliveryAvailableShippingUnavailableWEX() {
		driver.setCurrentTestCase("Add to Cart_WEX_Pickup_Delivery Available Shipping Unavailable_WEX");
		driver.setCurrentTestCaseDescription("PS_AZ_Add to Cart_WEX_Pickup, Delivery Available & Shipping Unavailable_WEX in current store & Stocked in 1 of the 5 closest stores");
		driver.driveTestExecution();
	}

	@Test
	public void testAvailabilitySTKPickupDeliveryAvailableShippingUnavailable() {
		driver.setCurrentTestCase("Availability_STK_Pickup_Delivery Available_Shipping Unavailable");
		driver.setCurrentTestCaseDescription("PS_AZ_Availability Popover_STK_Pickup, Delivery Available_Shipping Unavailable");
		driver.driveTestExecution();
	}

	@Test
	public void testAvailabilitySTKPickupDeliveryShippingAvailableUnavailability5Stores() {
		driver.setCurrentTestCase("Availability_STK_Pickup_Delivery Shipping Available_Unavailability 5 Stores");
		driver.setCurrentTestCaseDescription("PS_AZ_Availability Popover_STK_Pickup, Delivery & Shipping Available_Future Unavailability 5 Stores");
		driver.driveTestExecution();
	}

	@Test
	public void testAvailabilitySTKPickupDeliveryShippingAvailableAvailableCurrentStore() {
		driver.setCurrentTestCase("Availability STK_Pickup_Delivery Shipping Available_Available Current Store");
		driver.setCurrentTestCaseDescription("PS_AZ_Availability Popover_STK_Pickup, Delivery & Shipping Available_Future Available Current Store");
		driver.driveTestExecution();
	}

	@Test
	public void testAvailabilityWEXPickupDeliveryShippingUnavailableUnavailableIn5Stores() {
		driver.setCurrentTestCase("Availability WEX_Pickup_Delivery Shipping Unavailable_Unavailable in 5 stores");
		driver.setCurrentTestCaseDescription("PS_AZ_Availability Popover_WEX_Pickup, Delivery & Shipping Unavailable_Unavailable in 5 closest stores");
		driver.driveTestExecution();
	}

	@Test
	public void testGiftCardCatalogStructureVerifyTheItemNumberOfTheGiftCards() {
		driver.setCurrentTestCase("Gift Card Catalog Structure__Verify the Item number of the Gift Cards");
		driver.setCurrentTestCaseDescription("PS_AZ_Gift Card Catalog Structure__Verify the Item number of the Gift Cards");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZViewAllButton() {
		driver.setCurrentTestCase("PS_AZ_View All Button");
		driver.setCurrentTestCaseDescription("PS_AZ_View All Button");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZProductCompareProductComparisonBar() {
		driver.setCurrentTestCase("PS_AZ_Product Compare_Product comparison bar");
		driver.setCurrentTestCaseDescription("PS_AZ_Product Compare_Product comparison bar");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZProductCompareComparisonBarThreshold() {
		driver.setCurrentTestCase("PS_AZ_Product Compare_Comparison Bar Threshold");
		driver.setCurrentTestCaseDescription("PS_AZ_Product Compare_Comparison Bar Threshold");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZProductCompareRemoveCapability() {
		driver.setCurrentTestCase("PS_AZ_Product Compare_Remove capability");
		driver.setCurrentTestCaseDescription("PS_AZ_Product Compare_Remove capability");
		driver.driveTestExecution();
	}

	@Test
	public void testPSNZLumberPricingGrid() {
		driver.setCurrentTestCase("PS_NZ_Lumber Pricing Grid ");
		driver.setCurrentTestCaseDescription("PS_NZ_Lumber Pricing Grid ");
		driver.driveTestExecution();
	}

	@Test
	public void testLumberPricingGridProductExpandedMiddle() {
		driver.setCurrentTestCase("Lumber Pricing Grid_Product_expanded_Middle");
		driver.setCurrentTestCaseDescription("PS_AZ_Lumber Pricing Grid_Product selected, expanded state _Middle area");
		driver.driveTestExecution();
	}

	@Test
	public void testLumberPricingGridProductExpandedBottom() {
		driver.setCurrentTestCase("Lumber Pricing Grid_Product_expanded_Bottom");
		driver.setCurrentTestCaseDescription("PS_AZ_Lumber Pricing Grid_Product selected, expanded state_Bottom Area");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZPositiveFunctionalTest() {
		driver.setCurrentTestCase("PS_AZ_Positive Functional Test");
		driver.setCurrentTestCaseDescription("PS_AZ_Positive Functional Test");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIVerifyListAndGridView() {
		driver.setCurrentTestCase("PS_LI_Verify List and Grid view");
		driver.setCurrentTestCaseDescription("PS_LI_Verify List and Grid view");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZListPageProductDisplay() {
		driver.setCurrentTestCase("PS_AZ_List page_Product Display");
		driver.setCurrentTestCaseDescription("PS_AZ_List page_Product Display");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZDisplayOnlyDetailListAndComparePage() {
		driver.setCurrentTestCase("PS_AZ_Display Only_Detail, List and Compare Page");
		driver.setCurrentTestCaseDescription("PS_AZ_Display Only_Detail, List and Compare Page");
		driver.driveTestExecution();
	}

	@Test
	public void testRemoveAllSelectionsHyperlinkInSearchTextBox() {
		driver.setCurrentTestCase("Remove All Selections hyperlink in search text box ");
		driver.setCurrentTestCaseDescription("PS_AZ_Remove All Selections hyperlink in left Nav needs to be consistent in search text box ");
		driver.driveTestExecution();
	}

	@Test
	public void testRemoveAllSelectionsHyperlinkShopByDepartment() {
		driver.setCurrentTestCase("Remove All Selections hyperlink (Shop By Department)");
		driver.setCurrentTestCaseDescription("PS_AZ_Remove All Selections hyperlink in left Nav needs to be consistent (Shop By Department)");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZPagination() {
		driver.setCurrentTestCase("PS_AZ_Pagination");
		driver.setCurrentTestCaseDescription("PS_AZ_Pagination");
		driver.driveTestExecution();
	}

	@Test
	public void testVerifyTheFunctionalityOfSortByGridListViewBridge() {
		driver.setCurrentTestCase("Verify the functionality of Sort By_Grid_List View bridge");
		driver.setCurrentTestCaseDescription("PS_NZ_Verify the functionality of Sort By, Grid, List View bridge");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZBackToPLAndPDPage() {
		driver.setCurrentTestCase("PS_AZ_Back to PL and PD Page");
		driver.setCurrentTestCaseDescription("PS_AZ_Back to PL and PD Page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZBackToRecentlyAddedItem() {
		driver.setCurrentTestCase("PS_AZ_Back to Recently Added Item");
		driver.setCurrentTestCaseDescription("PS_AZ_Back to Recently Added Item");
		driver.driveTestExecution();
	}

	@Test
	public void testProductHasAnAvailablePriceButDoesNotHaveAWasPrice() {
		driver.setCurrentTestCase("Product has an available price but does not have a Was price");
		driver.setCurrentTestCaseDescription("PS_AZ_Product has an available price but does not have a Was price");
		driver.driveTestExecution();
	}

	@Test
	public void testProductHasAWasPriceAndDiffGrtrThan5Percent() {
		driver.setCurrentTestCase("Product has a Was price & diff grtr than 5 percent");
		driver.setCurrentTestCaseDescription("PS_LI_Product has a Was price and difference between it and Offer price is greater than 5 percent");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZNLPItem() {
		driver.setCurrentTestCase("PS_AZ_NLP Item");
		driver.setCurrentTestCaseDescription("PS_AZ_NLP Item");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZProductComparisonLayoutUserInterface() {
		driver.setCurrentTestCase("PS_AZ_ Product Comparison Layout - User Interface");
		driver.setCurrentTestCaseDescription("PS_AZ_ Product Comparison Layout - User Interface");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZPricingnotDisplayedPositiveFunctionalTest() {
		driver.setCurrentTestCase("PS_AZ_PricingnotDisplayed_Positive Functional Test");
		driver.setCurrentTestCaseDescription("PS_AZ_PricingnotDisplayed_Positive Functional Test");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZDetailAndListPagesCompleteTheSet() {
		driver.setCurrentTestCase("PS_AZ_Detail and List pages_Complete the Set");
		driver.setCurrentTestCaseDescription("PS_AZ_Detail and List pages_Complete the Set");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIVerifyTheFunctionalityOfProductDisplayTileViews() {
		driver.setCurrentTestCase("PS_LI_Verify the functionality of Product Display Tile Views");
		driver.setCurrentTestCaseDescription("PS_LI_Verify the functionality of Product Display Tile Views");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZDetailPagePageLayout() {
		driver.setCurrentTestCase("PS_AZ_Detail page_ Page layout");
		driver.setCurrentTestCaseDescription("PS_AZ_Detail page_ Page layout");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZZIPCodeEPP() {
		driver.setCurrentTestCase("PS_AZ_ZIP Code_EPP");
		driver.setCurrentTestCaseDescription("PS_AZ_ZIP Code_EPP");
		driver.driveTestExecution();
	}

	@Test
	public void testGridViewGetDetailsButtonDisplaysForUnavailableItems() {
		driver.setCurrentTestCase("Grid view_Get Details button displays for unavailable items");
		driver.setCurrentTestCaseDescription("PS_AZ_List page (Grid view)_Get Details button displays for unavailable items");
		driver.driveTestExecution();
	}

	@Test
	public void testListViewGetDetailsButtonDisplaysForUnavailableItems() {
		driver.setCurrentTestCase("List view_Get Details button displays for unavailable items");
		driver.setCurrentTestCaseDescription("PS_AZ_List page (List view)_ Get Details button displays for unavailable items");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZPriceMismatchOnListPageAndDetailPage() {
		driver.setCurrentTestCase("PS_AZ_Price Mismatch on List page and  Detail page");
		driver.setCurrentTestCaseDescription("PS_AZ_Price Mismatch on List page and  Detail page");
		driver.driveTestExecution();
	}

	@Test
	public void testUpdateEPPLogoInProtectionPlanTabOnDetailPage() {
		driver.setCurrentTestCase("Update EPP Logo in Protection Plan tab on detail page");
		driver.setCurrentTestCaseDescription("PS_AZ_Production Fix_Update EPP Logo in Protection Plan tab on detail page");
		driver.driveTestExecution();
	}

	@Test
	public void testAvailabilityPopoverSTKPickupDeliveryUnavailableShippingAvailable() {
		driver.setCurrentTestCase("Availability Popover_STK_Pickup_Delivery Unavailable_Shipping Available");
		driver.setCurrentTestCaseDescription("PS_AZ_Availability Popover_STK_Pickup, Delivery Unavailable_Shipping Available");
		driver.driveTestExecution();
	}

	@Test
	public void testAvailabilityPopoverSTKPickupDeliveryAvailableShippingUnavailableInStockQuantityMoreThan9999() {
		driver.setCurrentTestCase("Availability Popover_STK_Pickup_Delivery Available_Shipping Unavailable_In stock quantity more than 9999");
		driver.setCurrentTestCaseDescription("PS_AZ_Availability Popover_STK_Pickup, Delivery Available_Shipping Unavailable_In stock quantity more than 9999");
		driver.driveTestExecution();
	}

	@Test
	public void testAvailabilityPopoverSTKPickupDeliveryAvailableShippingUnavailable() {
		driver.setCurrentTestCase("Availability Popover_STK_Pickup_Delivery Available_Shipping Unavailable");
		driver.setCurrentTestCaseDescription("PS_AZ_Availability Popover_STK_Pickup, Delivery (FREE) Available_Shipping Unavailable");
		driver.driveTestExecution();
	}

	@Test
	public void testAvailabilityPopoverSTKPickupDeliveryAvailableShippingUnavailableFutureQuantityMoreThan9999() {
		driver.setCurrentTestCase("Availability Popover_STK_Pickup_Delivery Available_Shipping Unavailable_Future quantity more than 9999");
		driver.setCurrentTestCaseDescription("PS_AZ_Availability Popover_STK_Pickup, Delivery Available_Shipping Unavailable_Future quantity more than 9999");
		driver.driveTestExecution();
	}
}
