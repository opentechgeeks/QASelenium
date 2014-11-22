package com.lowes.qa.selenium.scenarios;

import java.io.IOException;
import java.text.MessageFormat;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.xml.sax.SAXException;

import com.lowes.qa.selenium.ParallelizedTestBase;
import com.lowes.qa.selenium.categories.BuildVerificationTests;
import com.lowes.qa.selenium.support.DriverScriptRegistry;

public class MyLowesTest extends ParallelizedTestBase {
	public MyLowesTest(String browserName, String version, String platform,
			String os) throws IOException, SAXException,
			ParserConfigurationException {
		super(browserName, version, platform, os);
		driver = DriverScriptRegistry.getDriverScript(MessageFormat.format(
				"{0}:{1}:{2}:{3}:{4}", browserName, version, platform, os, this
						.getClass().getName()), "MyLowes");
	}

	@Test
	public void testMLAZSignUpCreatingAnAccountBySelectingIDontWantACardRadioButton() {
		driver.setCurrentTestCase("ML_AZ_Sign Up_ Creating an account by selecting _I dont want a card radio button");
		driver.setCurrentTestCaseDescription("Launching of Lowe's HomePage ,Signing up a new user if the user uses the phone number to track in-store purchases and don't want a physical MyLowe's card.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZSignUpCreatingAnAccountBySelectingIAlreadyHaveAMyLowesCardRadioButton() {
		driver.setCurrentTestCase("ML_AZ_Sign Up_ Creating an account by selecting _I already have a MyLowes card radio button");
		driver.setCurrentTestCaseDescription("Launching of Lowe's HomePage ,Logging into the application to register the user when user is already having the lowes card");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZSignUpCreatingAccntSendMeMyLowesCardInTheMailRadioButton() {
		driver.setCurrentTestCase("ML_AZ_Sign Up_ CreatingAccnt_SendMeMyLowes card in the mail radio button");
		driver.setCurrentTestCaseDescription("Launching of Lowe's HomePage ,Logging into the application to register the user when user is wants the lowes card to send in email; Original TC Name: ML_AZ_Sign Up_ Creating an account by selecting _Send me a MyLowes card in the mail radio button");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZSignUpErrorMessageValidation() {
		driver.setCurrentTestCase("ML_AZ_Sign Up_Error message validation");
		driver.setCurrentTestCaseDescription("Validating error messages on screen");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZSignUpVerifyingSignUpFormIfUserIsZippedInVsUnZipedIn() {
		driver.setCurrentTestCase("ML_AZ_Sign up_Verifying Sign Up form if user is Zipped In Vs UnZiped In");
		driver.setCurrentTestCaseDescription("Validating zip code field from sign up form while zipping/unzipping");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZUpdateSignUpPageLinksThroughPurchases() {
		driver.setCurrentTestCase("ML_AZ_Update Sign Up page links_through Purchases");
		driver.setCurrentTestCaseDescription("Sign up from purchases");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZUpdateSignUpPageLinksThroughLandingPage() {
		driver.setCurrentTestCase("ML_AZ_Update Sign Up page links_through landing page");
		driver.setCurrentTestCaseDescription("Validating sign up fields from Master head");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLISignInModalMasthead() {
		driver.setCurrentTestCase("ML_LI_Sign In Modal (Masthead)");
		driver.setCurrentTestCaseDescription("User logging from master head and validating the fields in sign in pop up");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLISignInFromProductDetailPageWhileSettingReminders() {
		driver.setCurrentTestCase("ML_LI_Sign In from Product detail page while setting reminders");
		driver.setCurrentTestCaseDescription("User logging from product detail page while setting reminders");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLISignInFromProductDetailPageWhileSavingItemToLists() {
		driver.setCurrentTestCase("ML_LI_Sign In from Product detail page while saving item to lists");
		driver.setCurrentTestCaseDescription("Sign up while adding items to thelists");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLISignInFromProductDetailPageWhileSavingItemToHomeProfile() {
		driver.setCurrentTestCase("ML_LI_Sign In from Product detail page while saving item to home profile");
		driver.setCurrentTestCaseDescription("Sign up while adding items to the home profile");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLISignInFromItemWriteReviewBazaarVoiceLink() {
		driver.setCurrentTestCase("ML_LI_Sign In from Item write review (Bazaar voice link)");
		driver.setCurrentTestCaseDescription("Verify whether the user is able to sign while writing the review");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLISignInAfterAddingAnItemToTheCart() {
		driver.setCurrentTestCase("ML_LI_Sign In after adding an item to the cart");
		driver.setCurrentTestCaseDescription("User signing in while adding an item to cart.");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIRegisterMyLowesCard() {
		driver.setCurrentTestCase("ML_LI_Register My lowes card");
		driver.setCurrentTestCaseDescription("Registering lowes card");
		driver.driveTestExecution();
	}

	@Test
	@Category(BuildVerificationTests.class)
	public void testMLLIRequestingAdditionalMyLowesCardForExistingUser() {
		driver.setCurrentTestCase("ML_LI_Requesting additional my lowes card for existing user");
		driver.setCurrentTestCaseDescription("Requesting additional my lowes card for existing user");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIChooseToUsePhoneToTrackInStorePurchases() {
		driver.setCurrentTestCase("ML_LI_Choose to use phone to track In-store Purchases");
		driver.setCurrentTestCaseDescription("Request to Choose to use phone to track In-store Purchases");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIChoosesIAlreadyHaveAMyLowesCardToTrackInStorePurchases() {
		driver.setCurrentTestCase("ML_LI_chooses i already have a MyLowes card to track In-store Purchases");
		driver.setCurrentTestCaseDescription("Request to enter the existing card number to track Instore Purchases");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIChoosesToUpdateWithNewPhoneNumberToTrackInstorePurchases() {
		driver.setCurrentTestCase("ML_LI_chooses to update with new phone number to track Instore Purchases");
		driver.setCurrentTestCaseDescription("Request to chooses to update with new phone number to track Instore Purchases");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIRequestToSendAMyLowesCardInMailButWithDifferentAddressToTrackInStorePurchases() {
		driver.setCurrentTestCase("ML_LI_ Request to send a my lowes card in mail but with different address to track In-store Purchases");
		driver.setCurrentTestCaseDescription(" Request to send a my lowes card in mail but with different address to track In-store Purchases");
		driver.driveTestExecution();
	}

	@Test
	public void testMLAZUpdateSignUpPageLinksThroughReviewAndPayPage() {
		driver.setCurrentTestCase("ML_AZ_Update Sign Up page links_through Review and Pay page");
		driver.setCurrentTestCaseDescription("User sign up from from Review & Pay page");
		driver.driveTestExecution();
	}

	@Test
	public void testMLLIUserRegistrationWhileOnReviewAndPayPage() {
		driver.setCurrentTestCase("ML_LI_User registration while on Review & Pay Page");
		driver.setCurrentTestCaseDescription("User Registration from Review & Pay page");
		driver.driveTestExecution();
	}
}
