package com.lowes.qa.selenium.scenarios;

import java.io.IOException;
import java.text.MessageFormat;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.lowes.qa.selenium.ParallelizedTestBase;
import com.lowes.qa.selenium.support.DriverScriptRegistry;

public class ProductSearchDOMSBTest extends ParallelizedTestBase {
	public ProductSearchDOMSBTest(String browserName, String version,
			String platform, String os) throws IOException, SAXException,
			ParserConfigurationException {
		super(browserName, version, platform, os);
		driver = DriverScriptRegistry.getDriverScript(MessageFormat.format(
				"{0}:{1}:{2}:{3}:{4}", browserName, version, platform, os, this
						.getClass().getName()), "ProductSearch_DOM_SB");
	}

	@Test
	public void testPSAZVerificationOfEnergyStarBadge() {
		driver.setCurrentTestCase("PS_AZ_Verification of Energy Star Badge");
		driver.setCurrentTestCaseDescription("Verification of Energy star badge in List/Grid views and from search.");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZVerifyStoreLocatorDOCTYPEInViewSource() {
		driver.setCurrentTestCase("PS_AZ_Verify Store Locator DOCTYPE in View Source");
		driver.setCurrentTestCaseDescription("Verify that the Store Locator page doctype is HTML5.");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZClickingFreeDeliveryIconInListPageOpensAPopup() {
		driver.setCurrentTestCase("PS_AZ_Clicking Free Delivery Icon in list page opens a Popup");
		driver.setCurrentTestCaseDescription("The Purpose of this test case is to Verify that a Popup is displayed after clicking on 'Free Delivery' icon in the list page of an item with free delivery.");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZBusinessControlledPropDisableInventoryPopoverSOEItem() {
		driver.setCurrentTestCase("PS_AZ_BusinessControlledProp_DisableInventoryPopover_SOE_Item");
		driver.setCurrentTestCaseDescription("Verify that Inventory Popover for WEX (SOE) item is business controlled and won't be displayed when the feature is turned off. Verify that Inventory Popover for stocked item is NOT affected; Original TC Name:PS_AZ_Business Controlled Property_Disable Inventory Popover_WEX_SOE_Item");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZCheckSubtotalMinMulQtyInProductDetailsPage() {
		driver.setCurrentTestCase("PS_AZ_Check subtotalMinMulQty in product details page");
		driver.setCurrentTestCaseDescription("This test case validates the subtotal for min/mul quantity in product details page. Original TC Name: PS_AZ_Check subtotal for min mul quantity in product details page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZVerifyThatMAPPriceDisplayedInBuyThePair() {
		driver.setCurrentTestCase("PS_AZ_Verify that MAP Price displayed in Buy the Pair");
		driver.setCurrentTestCaseDescription("Verify that if MAP displayed in Buy the Pair section on detail page. Original TC Name: PS_AZ_Verify that MAP Price displayed in Buy the Pair section on detail page.");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZMAPDisplayingInCustomerAlsoViewedItems() {
		driver.setCurrentTestCase("PS_AZ_MAP displaying in Customer Also Viewed Items");
		driver.setCurrentTestCaseDescription("Verify that if MAP displayed in Customer Also Viewed section. Original TC Name:PS_AZ_Verify that MAP displaying in Customer Also Viewed Items");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZVerificationOfMAPPriceForRelatedItems() {
		driver.setCurrentTestCase("PS_AZ_Verification of MAP Price for Related Items");
		driver.setCurrentTestCaseDescription("Verify that if MAP displayed in Related Items section.");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZVerifyFreeDeliveryMajorAppCheckout() {
		driver.setCurrentTestCase("PS_AZ_Verify Free Delivery_MajorApp_Checkout");
		driver.setCurrentTestCaseDescription("Verify that 'Free delivery' is displayed for all qualified major appliance list; Original TC Name:PS_AZ_Verify Free Delivery for qualified major Appliance list in detail page");
		driver.driveTestExecution();
	}
}
