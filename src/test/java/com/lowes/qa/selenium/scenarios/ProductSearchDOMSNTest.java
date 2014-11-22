package com.lowes.qa.selenium.scenarios;

import java.io.IOException;
import java.text.MessageFormat;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.lowes.qa.selenium.ParallelizedTestBase;
import com.lowes.qa.selenium.support.DriverScriptRegistry;

public class ProductSearchDOMSNTest extends ParallelizedTestBase {
	public ProductSearchDOMSNTest(String browserName, String version,
			String platform, String os) throws IOException, SAXException,
			ParserConfigurationException {
		super(browserName, version, platform, os);
		driver = DriverScriptRegistry.getDriverScript(MessageFormat.format(
				"{0}:{1}:{2}:{3}:{4}", browserName, version, platform, os, this
						.getClass().getName()), "ProductSearch_DOM_SN");
	}

	@Test
	public void testPSLIDigitalElementAutozip() {
		driver.setCurrentTestCase("PS_LI_Digital Element_Autozip");
		driver.setCurrentTestCaseDescription("Digital Element_Autozip");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZVerifyMiniCartNotificationModelInMasterHeadWhenLumberPriceItemsAddedToCart() {
		driver.setCurrentTestCase("PS_AZ_Verify Mini Cart Notification Model in Master Head when Lumber Price items added to cart");
		driver.setCurrentTestCaseDescription("Verify Mini Cart Notification Model in Master Head when Lumber Price items added to cart");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZVerifyicationOfNotificationModelInComparePage() {
		driver.setCurrentTestCase("PS_AZ_Verifyication of  Notification Model in Compare Page");
		driver.setCurrentTestCaseDescription("Verifyication of  Notification Model in Compare Page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIVerificationOfAddedToCartNotificationModalInListPage() {
		driver.setCurrentTestCase("PS_LI_Verification of Added to Cart Notification Modal in List Page");
		driver.setCurrentTestCaseDescription("Verification of Added to Cart Notification Modal in List Page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIVerificationOfAddedToCartNotificationModalInComparePage() {
		driver.setCurrentTestCase("PS_LI_Verification of Added to Cart Notification Modal in Compare Page");
		driver.setCurrentTestCaseDescription("Verification of Added to Cart Notification Modal in Compare Page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIVerificationOfAddedToCartNotificationModalInProductDetailPage() {
		driver.setCurrentTestCase("PS_LI_Verification of Added to Cart Notification Modal in Product Detail Page");
		driver.setCurrentTestCaseDescription("Verification of Added to Cart Notification Modal in Product Detail Page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIVerificationOfAddToCartNotificationModalForLumberPrice() {
		driver.setCurrentTestCase("PS_LI_Verification of Add to cart Notification Modal for Lumber Price");
		driver.setCurrentTestCaseDescription("Verification of Add to cart Notification Modal for Lumber Price");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIVerificationOfAddToCartNotificationModalForGiftCard() {
		driver.setCurrentTestCase("PS_LI_Verification of Add to cart Notification Modal for Gift Card");
		driver.setCurrentTestCaseDescription("Verification of Add to cart Notification Modal for Gift Card");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIVerificationOfAddedToCartMessage() {
		driver.setCurrentTestCase("PS_LI_Verification of  Added to Cart Message.");
		driver.setCurrentTestCaseDescription("Verification of  Added to Cart Message.");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIVerificationOfAddedToCartNotificationModalForEPPItems() {
		driver.setCurrentTestCase("PS_LI_Verification of Added to Cart Notification Modal for EPP Items");
		driver.setCurrentTestCaseDescription("Verification of Added to Cart Notification Modal for EPP Items");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZVerificationOfErrorMessageWhenForeignAddressIsEnteredInSearchBox() {
		driver.setCurrentTestCase("PS_AZ_Verification of Error Message when Foreign Address is entered in Search Box");
		driver.setCurrentTestCaseDescription("Verification of Error Message when Foreign Address is entered in Search Box");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZVerificationOfCanadaStoresInStoreLocator() {
		driver.setCurrentTestCase("PS_AZ_Verification of Canada stores in Store Locator.");
		driver.setCurrentTestCaseDescription("Verification of Canada stores in Store Locator.");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZVerificationOfMiniCartPopupInCheckoutPages() {
		driver.setCurrentTestCase("PS_AZ_Verification of Mini Cart Popup in Checkout Pages");
		driver.setCurrentTestCaseDescription("Verification of Mini Cart Popup in Checkout Pages");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIVerifyStoreInfoInStoreLocatorPopup() {
		driver.setCurrentTestCase("PS_LI_Verify Store info in StoreLocator popup");
		driver.setCurrentTestCaseDescription("Verify Store info in StoreLocator popup");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZVerificationOfAddedToCartNotificationModalWithRTFAddedInDetailPage() {
		driver.setCurrentTestCase("PS_AZ_Verification of Added to Cart Notification Modal with RTF Added in Detail Page");
		driver.setCurrentTestCaseDescription("MiniCart_Added to Cart Notification Modal_with RTF Added_Detail Page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIVerificationOfAddToCartNotificationModalWithRTFItems() {
		driver.setCurrentTestCase("PS_LI_Verification of Add to cart notification modal with RTF Items");
		driver.setCurrentTestCaseDescription("MiniCart_Added to Cart Notification Modal_with RTF Added_Detail Page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZMiniCartAddedToCartNotificationModalWithEPPAndRTFDetailPage() {
		driver.setCurrentTestCase("PS_AZ_Mini-Cart_Added to Cart Notification Modal_with EPP and RTF_Detail Page");
		driver.setCurrentTestCaseDescription("");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIMiniCartAddedToCartNotificationModalWithEPPAndRTFDetailPage() {
		driver.setCurrentTestCase("PS_LI_Mini-Cart_Added to Cart Notification Modal_with EPP and RTF_Detail Page");
		driver.setCurrentTestCaseDescription("");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIVerificationOfMAPPriceItemDetailsInDetailsPage() {
		driver.setCurrentTestCase("PS_LI_Verification of MAP price item details in Details page");
		driver.setCurrentTestCaseDescription("Verification of MAP price item details in Details page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIVerifyPriceForMAPItemsInCatAndSuperCat() {
		driver.setCurrentTestCase("PS_LI_Verify price for MAP items in Cat and Super Cat");
		driver.setCurrentTestCaseDescription("Verify price for MAP items in Cat and Super Cat");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIVerificationOfMAPPriceItemsWitnNormalItemsInComparePage() {
		driver.setCurrentTestCase("PS_LI_Verification of MAP Price items witn normal items in Compare page");
		driver.setCurrentTestCaseDescription("Verification of MAP Price items witn normal items in Compare page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIVerifyThePriceOfMAPItemInListsAndGridView() {
		driver.setCurrentTestCase("PS_LI_Verify the Price of MAP item in Lists and Grid View");
		driver.setCurrentTestCaseDescription("Verify the Price of MAP item in Lists and Grid View");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZVerificationOfStrikethruForMAPItemsInGridView() {
		driver.setCurrentTestCase("PS_AZ_Verification of strikethru for MAP items in Grid View");
		driver.setCurrentTestCaseDescription("Verification of strikethru for MAP items in Grid View");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIVerificationOfViewSourceForListPage() {
		driver.setCurrentTestCase("PS_LI_Verification of View source for List Page");
		driver.setCurrentTestCaseDescription("Verification of View source for List Page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZVerificationOfViewSourceForListPage() {
		driver.setCurrentTestCase("PS_AZ_Verification of View source for list page");
		driver.setCurrentTestCaseDescription("Verification of View source for list page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZVerificationOfViewSourceForHomePage() {
		driver.setCurrentTestCase("PS_AZ_Verification of View source for Home page");
		driver.setCurrentTestCaseDescription("Verification of View source for Home page");
		driver.driveTestExecution();
	}

	@Test
	public void testPSAZVerifyThatMAPPriceDisplayedInBuyThePairSectionOnDetailPage() {
		driver.setCurrentTestCase("PS_AZ_Verify that MAP Price displayed in Buy the Pair section on detail page.");
		driver.setCurrentTestCaseDescription("Verify that MAP Price displayed in Buy the Pair section on detail page.");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIVerifyStoreLocatorPopupChangeStore() {
		driver.setCurrentTestCase("PS_LI_Verify Store Locator popup_Change store");
		driver.setCurrentTestCaseDescription("Verify Store Locator popup_Change store");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIVerifyTheUserIsAbleToSearchForAStoreByClickingTheChangeStoreLink() {
		driver.setCurrentTestCase("PS_LI_Verify the user is able to search for a store by clicking the Change store link");
		driver.setCurrentTestCaseDescription("Verify the user is able to search for a store by clicking the Change store link");
		driver.driveTestExecution();
	}

	@Test
	public void testPSLIMiniCartAddedToCartNotificationModalGridView() {
		driver.setCurrentTestCase("PS_LI_Mini-Cart_Added to Cart Notification Modal_Grid View");
		driver.setCurrentTestCaseDescription("Mini-Cart_Added to Cart Notification Modal_Grid View");
		driver.driveTestExecution();
	}
}
