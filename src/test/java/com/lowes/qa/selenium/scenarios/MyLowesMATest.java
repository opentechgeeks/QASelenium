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

public class MyLowesMATest extends ParallelizedTestBase {
	public MyLowesMATest(String browserName, String version, String platform,
			String os) throws IOException, SAXException,
			ParserConfigurationException {
		super(browserName, version, platform, os);
		driver = DriverScriptRegistry.getDriverScript(MessageFormat.format(
				"{0}:{1}:{2}:{3}:{4}", browserName, version, platform, os, this
						.getClass().getName()), "MyLowes_MA");
	}

	@Test
	public void testMLLIManageAccountDeleteCreditCardVerifycancelmechanismsforsecondarycards() {
		driver.setCurrentTestCase("ML_LI_Manage Account - Delete Credit Card - Verify cancel mechanisms for secondary cards");
		driver.setCurrentTestCaseDescription("ML_LI_Manage Account - Delete Credit Card - Verify cancel mechanisms for secondary cards");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIManageAccountDeleteCreditCardVerifycancelmechanismswhenthereisaprimarycardandmorethanonesecondaycards() {
		driver.setCurrentTestCase("ML_LI_Manage Account - Delete Credit Card - Verify cancel mechanisms when there is a primary card and more than one seconday cards");
		driver.setCurrentTestCaseDescription("ML_LI_Manage Account - Delete Credit Card - Verify cancel mechanisms when there is a primary card and more than one seconday cards");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIAddPrimaryCreditCard() {
		driver.setCurrentTestCase("ML_LI_Add Primary Credit Card");
		driver.setCurrentTestCaseDescription("ML_LI_Add Primary Credit Card");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIAddsecondarycreditcard() {
		driver.setCurrentTestCase("ML_LI_Add secondary credit card");
		driver.setCurrentTestCaseDescription("ML_LI_Add secondary credit card");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIManageAccountNewUserVerifyLearnmoreaboutreminderslink() {
		driver.setCurrentTestCase("ML_LI_Manage Account_New User_Verify Learn more about reminders link");
		driver.setCurrentTestCaseDescription("ML_LI_Manage Account_New User_Verify Learn more about reminders link");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIEditcreditcardwithnewnicknameandfutureexpirydate() {
		driver.setCurrentTestCase("ML_LI_Edit credit card with new nickname and future expiry date");
		driver.setCurrentTestCaseDescription("ML_LI_Edit credit card with new nickname and future expiry date");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIEditcreditcardwithpastdate() {
		driver.setCurrentTestCase("ML_LI_Edit credit card with past date");
		driver.setCurrentTestCaseDescription("ML_LI_Edit credit card with past date");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIAddsecondprimarycreditcard() {
		driver.setCurrentTestCase("ML_LI_Add second primary credit card");
		driver.setCurrentTestCaseDescription("ML_LI_Add second primary credit card");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIAddsecondprimarycardwithexistingprimarycardnickname() {
		driver.setCurrentTestCase("ML_LI_Add second primary card with existing primary card nickname");
		driver.setCurrentTestCaseDescription("ML_LI_Add second primary card with existing primary card nickname");
		driver.driveTestExecution();
	}
	@Test
	public void testMLAZVerifyMyLowesLandingPage() {
		driver.setCurrentTestCase("ML_AZ_Verify My Lowes Landing Page");
		driver.setCurrentTestCaseDescription("Verify My Lowes Landing Page");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIManageAccountDeleteaCreditCard() {
		driver.setCurrentTestCase("ML_LI_Manage Account - Delete a Credit Card");
		driver.setCurrentTestCaseDescription("Manage Account - Delete a Credit Card");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIManageAccountEditaCreditCard() {
		driver.setCurrentTestCase("ML_LI_Manage Account - Edit a Credit Card");
		driver.setCurrentTestCaseDescription("Manage Account - Edit a Credit Card");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIManageAccountEditandSavingaccount() {
		driver.setCurrentTestCase("ML_LI_Manage Account - Edit and Saving account");
		driver.setCurrentTestCaseDescription("Manage Account - Edit and Saving account Information from Preferences");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIManageAccountPrintPublications() {
		driver.setCurrentTestCase("ML_LI_Manage Account - Print Publications");
		driver.setCurrentTestCaseDescription("Manage Account - Print Publications option is enabled in Subscriptions page after logged into the account.");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIManageAccountSigninwithRememberme() {
		driver.setCurrentTestCase("ML_LI_Manage Account - Sign in with Remember me");
		driver.setCurrentTestCaseDescription("Manage Account - Sign in with Remember me");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIAddPrimaryAddresserrormessagescenarios() {
		driver.setCurrentTestCase("ML_LI_Add Primary Address- error message scenarios");
		driver.setCurrentTestCaseDescription("Add Primary Address- error message scenarios");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIEditaddressBlankfielderrormessageverification() {
		driver.setCurrentTestCase("ML_LI_Edit address_Blank field error message verification");
		driver.setCurrentTestCaseDescription("Edit address_Blank field error message verification");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIEditaddressCanceleditaddressverification() {
		driver.setCurrentTestCase("ML_LI_Edit address_Cancel edit address verification");
		driver.setCurrentTestCaseDescription("Edit address_Cancel edit address verification");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIRemindersEmailCopyChanges() {
		driver.setCurrentTestCase("ML_LI_Reminders Email - Copy Changes");
		driver.setCurrentTestCaseDescription("Reminders Email - Copy Changes");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIVerifyingaccountdeactivationinExacttarget() {
		driver.setCurrentTestCase("ML_LI_Verifying account deactivation in Exact target");
		driver.setCurrentTestCaseDescription("Verifying account deactivation in Exact target");
		driver.driveTestExecution();
	}
	@Test
	public void testMLCBCCancelsavingtheaddress() {
		driver.setCurrentTestCase("ML_CBC_Cancel saving the address");
		driver.setCurrentTestCaseDescription("Cancel saving the address");
		driver.driveTestExecution();
	}
	@Test
	public void testMLCBCWrongaddress() {
		driver.setCurrentTestCase("ML_CBC_Wrong address");
		driver.setCurrentTestCaseDescription("Wrong address combination validation.");
		driver.driveTestExecution();
	}
	@Test
	public void testMLCBCAddaddress() {
		driver.setCurrentTestCase("ML_CBC_Add address");
		driver.setCurrentTestCaseDescription("Add address");
		driver.driveTestExecution();
	}
	@Test
	public void testMLCBCPhonefieldonaddressbook() {
		driver.setCurrentTestCase("ML_CBC_Phone field on address book.");
		driver.setCurrentTestCaseDescription("Phone field on address book.");
		driver.driveTestExecution();
	}
	@Test
	public void testMLCBCUSPSsuggestion() {
		driver.setCurrentTestCase("ML_CBC_USPS suggestion");
		driver.setCurrentTestCaseDescription("USPS suggestion");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIUSPSAddressValidation() {
		driver.setCurrentTestCase("ML_LI_USPS Address Validation");
		driver.setCurrentTestCaseDescription("USPS Address Validation - Perfect Match");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIChangeRemovebuttonlabeltodelete() {
		driver.setCurrentTestCase("ML_LI_Change Remove button label to delete");
		driver.setCurrentTestCaseDescription("Change Remove button label to delete");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIRemindersWelcomePage() {
		driver.setCurrentTestCase("ML_LI_Reminders Welcome Page");
		driver.setCurrentTestCaseDescription("Reminders Help navigation for Authenticated customers - Reminders Welcome Page");
		driver.driveTestExecution();
	}
	@Test
	public void testMLAZMyLowesFAQs() {
		driver.setCurrentTestCase("ML_AZ_My Lowes FAQs");
		driver.setCurrentTestCaseDescription("Reminders Help navigation for Authenticated customers - My Lowes FAQs");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIFirstUseRemindersmodal() {
		driver.setCurrentTestCase("ML_LI_First Use Reminders modal");
		driver.setCurrentTestCaseDescription("Reminders Help navigation for Authenticated customers - First Use Reminders modal");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIAccountLandingpage() {
		driver.setCurrentTestCase("ML_LI_ Account Landing page");
		driver.setCurrentTestCaseDescription("Reminders  Help navigation for Authenticated customers - Account Landing page");
		driver.driveTestExecution();
	}
	@Test
	public void testMLAZRemindersIntrofromProductDetailPage() {
		driver.setCurrentTestCase("ML_AZ_Reminders Intro from Product Detail Page");
		driver.setCurrentTestCaseDescription("Reminders hep navigation for Un-Authenticated users - Reminders Intro from Product Detail Page");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIRemindersContextualHelp() {
		driver.setCurrentTestCase("ML_LI_Reminders Contextual Help");
		driver.setCurrentTestCaseDescription("Reminders Contextual Help");
		driver.driveTestExecution();
	}
	@Test
	public void testMLIncorporateemailaddressinthesetremindersmodal() {
		driver.setCurrentTestCase("ML_Incorporate email address in the set reminders modal");
		driver.setCurrentTestCaseDescription("Incorporate email address in the set reminders modal");
		driver.driveTestExecution();
	}
	@Test
	public void testMLAZVerifythatthetabsonMyLowesLandingPage() {
		driver.setCurrentTestCase("ML_AZ_Verify that the tabs on My Lowes Landing Page");
		driver.setCurrentTestCaseDescription("Verify that the tabs on My Lowes Landing Page are displayed in the correct form");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIsigninandsignuptabinMyLowesLandingPage() {
		driver.setCurrentTestCase("ML_LI_sign in and sign up tab in  My Lowes Landing Page");
		driver.setCurrentTestCaseDescription("Verify the correct funcionality of sign in and sign up tab in  My Lowes Landing Page");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIVerifySaveitemdropdownwhentheuserisanonymous() {
		driver.setCurrentTestCase("ML_LI_Verify Save item dropdown when the user is anonymous");
		driver.setCurrentTestCaseDescription("Verify Save item dropdown when the user is anonymous");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIYourAccountLandingpage() {
		driver.setCurrentTestCase("ML_LI_Your Account Landing page");
		driver.setCurrentTestCaseDescription("Your Account Landing page");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIYourAccounEditAccountandManangeAccount() {
		driver.setCurrentTestCase("ML_LI_Your Accoun, Edit Account and Manange Account");
		driver.setCurrentTestCaseDescription("Your Account Profile, Edit Account Information and Manange your Addresses pages");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIYourAccountCreditCenterpageandRebatespage() {
		driver.setCurrentTestCase("ML_LI_Your Account Credit Center page and Rebates page");
		driver.setCurrentTestCaseDescription("Your Account Credit Center page and Rebates page");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIYourAccountHelpCenterandFAQ() {
		driver.setCurrentTestCase("ML_LI_Your Account Help Center and FAQ");
		driver.setCurrentTestCaseDescription("Your Account Help Center and FAQ");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIAddprimaryaddressbyUSPS() {
		driver.setCurrentTestCase("ML_LI_Add primary address by USPS");
		driver.setCurrentTestCaseDescription("Add primary address by USPS");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIAddSecondaryaddress() {
		driver.setCurrentTestCase("ML_LI_Add Secondary address");
		driver.setCurrentTestCaseDescription("Add Secondary address");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIYourAccountSubscriptionspageformembers() {
		driver.setCurrentTestCase("ML_LI_Your Account Subscriptions page for members");
		driver.setCurrentTestCaseDescription("ML_LI_Your Account Subscriptions page for members");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIYourAccountSubscriptionspageforanonymoususer() {
		driver.setCurrentTestCase("ML_LI_Your Account Subscriptions page for anonymous user");
		driver.setCurrentTestCaseDescription("ML_LI_Your Account Subscriptions page for anonymous user");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIYourAccountRegistrationpage() {
		driver.setCurrentTestCase("ML_LI_Your Account Registration page");
		driver.setCurrentTestCaseDescription("ML_LI_Your Account Registration page");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIYourAccountManageCreditCardspage() {
		driver.setCurrentTestCase("ML_LI_Your Account Manage Credit Cards page");
		driver.setCurrentTestCaseDescription("ML_LI_Your Account Manage Credit Cards page");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIUserAccountDeactivationSuccessful() {
		driver.setCurrentTestCase("ML_LI_User Account Deactivation_Successful");
		driver.setCurrentTestCaseDescription("ML_LI_User Account Deactivation_Successful");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIAddprimaryaddresswithInvalidstreetaddress() {
		driver.setCurrentTestCase("ML_LI_Add primary address with Invalid street address");
		driver.setCurrentTestCaseDescription("ML_LI_Add primary address with Invalid street address");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIChangePhonefieldtosinglefieldaddaddress() {
		driver.setCurrentTestCase("ML_LI_Change_Phone field to single field_add address");
		driver.setCurrentTestCaseDescription("ML_LI_Change_Phone # field to single field _add address");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIChangePhonefieldtosinglefieldDisplayaddress() {
		driver.setCurrentTestCase("ML_LI_Change_Phone field to single field_Display address");
		driver.setCurrentTestCaseDescription("ML_LI_Change_Phone # field to single field_Display address");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIcancelbuttonshouldnotdeletetheaddress() {
		driver.setCurrentTestCase("ML_LI_cancel button should  not delete the address");
		driver.setCurrentTestCaseDescription("ML_LI_Delete address_cancel button should  not delete the address");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIDeleteaddressdeletingsecondaryaddress() {
		driver.setCurrentTestCase("ML_LI_Delete address_deleting secondary address");
		driver.setCurrentTestCaseDescription("ML_LI_Delete address_deleting secondary address");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIDeleteaddressVerificationofdeletingprimaryaddress() {
		driver.setCurrentTestCase("ML_LI_Delete address_Verification of deleting  primary address");
		driver.setCurrentTestCaseDescription("ML_LI_Delete address_Verification of deleting  primary address");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIEditaddressEditingprimaryaddress() {
		driver.setCurrentTestCase("ML_LI_Edit address_Editing primary address");
		driver.setCurrentTestCaseDescription("ML_LI_Edit address_Editing primary address");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIEditaddressEditingsecondaryaddress() {
		driver.setCurrentTestCase("ML_LI_Edit address_Editing secondary address");
		driver.setCurrentTestCaseDescription("ML_LI_Edit address_Editing secondary address");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIChangingtheusertoemployee() {
		driver.setCurrentTestCase("ML_LI_Changing the user to employee");
		driver.setCurrentTestCaseDescription("ML_LI_Changing the user to employee");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIEditaddressverificationonsameNickname() {
		driver.setCurrentTestCase("ML_LI_Edit address_verification on same Nickname");
		driver.setCurrentTestCaseDescription("ML_LI_Edit address_Error messaging verification on same Nickname");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIEditaddressHandlingUSPSsuggestionmodal() {
		driver.setCurrentTestCase("ML_LI_Edit address_Handling USPS suggestion modal");
		driver.setCurrentTestCaseDescription("ML_LI_Edit address_Handling USPS suggestion modal");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIEditaddressSpecialcharactererrormessagevalidation() {
		driver.setCurrentTestCase("ML_LI_Edit address_Special character error message validation");
		driver.setCurrentTestCaseDescription("ML_LI_Edit address_Special character error message validation");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIDisplayaddresspage() {
		driver.setCurrentTestCase("ML_LI_Display address page");
		driver.setCurrentTestCaseDescription("ML_LI_Display address page");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIEnteringacceptablespecialcharacter() {
		driver.setCurrentTestCase("ML_LI_Entering acceptable special character");
		driver.setCurrentTestCaseDescription("ML_LI_Entering acceptable special character");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIErrormesagewithoutenteringanything() {
		driver.setCurrentTestCase("ML_LI_Error mesage without entering anything");
		driver.setCurrentTestCaseDescription("ML_LI_Error mesage for user without entering anything");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIIncorporateemailaddressinthesetremindersmodal() {
		driver.setCurrentTestCase("ML_LI_Incorporate email address in the set reminders modal");
		driver.setCurrentTestCaseDescription("ML_LI_Incorporate email address in the set reminders modal");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIUpdateProfiepagewithPrimaryAddres() {
		driver.setCurrentTestCase("ML_LI_Update Profie page with Primary Addres");
		driver.setCurrentTestCaseDescription("ML_LI_Update Profie page with Primary Address-Customer with one or more stored  addresses on file");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIErrormessageforwrongCityStateZipCode() {
		driver.setCurrentTestCase("ML_LI_Error message for wrong City, State, ZipCode");
		driver.setCurrentTestCaseDescription("ML_LI_Error message for wrong City, State, ZipCode");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIVerificationofPreferenceslink() {
		driver.setCurrentTestCase("ML_LI_Verification of Preferences link");
		driver.setCurrentTestCaseDescription("ML_LI_Verification of Preferences link");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLILeftNavSubscriptionupdate() {
		driver.setCurrentTestCase("ML_LI_Left-Nav Subscription update");
		driver.setCurrentTestCaseDescription("ML_LI_Left-Nav Subscription update");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLILeftNavRebatespageverification() {
		driver.setCurrentTestCase("ML_LI_Left-Nav Rebates page verification");
		driver.setCurrentTestCaseDescription("ML_LI_Left-Nav Rebates page verification");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLILeftNavReminderspageverification() {
		driver.setCurrentTestCase("ML_LI_Left-Nav Reminders page verification");
		driver.setCurrentTestCaseDescription("ML_LI_Left-Nav Reminders page verification");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLILeftNavverificationwithstoredreminders() {
		driver.setCurrentTestCase("ML_LI_Left-Nav verification with stored reminders");
		driver.setCurrentTestCaseDescription("ML_LI_Left-Nav verification with stored reminders");
		driver.driveTestExecution();
	}
	@Test
	public void testMLCBCEmailusedpasswordmatchnotinpricinggroup() {
		driver.setCurrentTestCase("ML_CBC_Email used password match not in pricing group");
		driver.setCurrentTestCaseDescription("ML_LI_Email used password match not in pricing group");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIconsumercreditbreadcrumbsverify() {
		driver.setCurrentTestCase("ML_LI_consumer credit breadcrumbs verify");
		driver.setCurrentTestCaseDescription("ML_LI_Lowes consumer credit card page breadcrumbs verification");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLILeftnavandbreadcrumbsverify() {
		driver.setCurrentTestCase("ML_LI_Left nav and bread crumbs verify");
		driver.setCurrentTestCaseDescription("ML_LI_Left navigation link verification and bread crumbs verification ");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIMylowespageandlogoverification() {
		driver.setCurrentTestCase("ML_LI_My lowes page and  logo verification");
		driver.setCurrentTestCaseDescription("ML_LI_My lowes page and  logo verification");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIVerificationofyouraccountdropdown() {
		driver.setCurrentTestCase("ML_LI_Verification of your account drop down");
		driver.setCurrentTestCaseDescription("ML_LI_Verification of your account drop down from masthead");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLINewUserMylowespageverification() {
		driver.setCurrentTestCase("ML_LI_NewUser_My lowes page verification");
		driver.setCurrentTestCaseDescription("ML_LI_NewUser_New My lowes page content verification");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIVerifmylowescardandmylowespage() {
		driver.setCurrentTestCase("ML_LI_Verif my lowes card and my lowes page");
		driver.setCurrentTestCaseDescription("ML_LI_Verification of my lowes card section with card infromation in my lowes page");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIMylowespagetitleandsubtitleverification() {
		driver.setCurrentTestCase("ML_LI_My lowes page title and subtitle verification");
		driver.setCurrentTestCaseDescription("ML_LI_My lowes page title and subtitle verification");
		driver.driveTestExecution();
	}
	@Test
	public void testMLAZSubscriptionbreadcrumbsverification() {
		driver.setCurrentTestCase("ML_AZ_Subscription breadcrumbs verification");
		driver.setCurrentTestCaseDescription("ML_AZ_Subscription breadcrumbs verification");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIVerifyofaddingcreditcardfornewuser() {
		driver.setCurrentTestCase("ML_LI_Verify of adding credit card for new user");
		driver.setCurrentTestCaseDescription("ML_LI_Verify the functionality of adding credit card for new user with Address");
		driver.driveTestExecution();
	}
	@Test
	public void testMLAZSubscriptioncontentchanges() {
		driver.setCurrentTestCase("ML_AZ_Subscription content changes");
		driver.setCurrentTestCaseDescription("ML_AZ_Subscription content changes");
		driver.driveTestExecution();
	}
	@Test
	public void testMLAZaddressline1andaddressline2() {
		driver.setCurrentTestCase("ML_AZ_address line 1 and address line 2");
		driver.setCurrentTestCaseDescription("ML_AZ_Address book_Verifying # sign of address line 1 and address line 2");
		driver.driveTestExecution();
	}
	@Test
	public void testMLAZEnterinvalidpassword() {
		driver.setCurrentTestCase("ML_AZ_Enter invalid password");
		driver.setCurrentTestCaseDescription("ML_AZ_Enter invalid password");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIUSPSMilitaryaddressvalidation() {
		driver.setCurrentTestCase("ML_LI_USPS Military address validation");
		driver.setCurrentTestCaseDescription("ML_LI_USPS address validation-Military address validation");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIUSPSaddressPOaddressValidation() {
		driver.setCurrentTestCase("ML_LI_USPS address PO address Validation");
		driver.setCurrentTestCaseDescription("ML_LI_USPS address validation-PO address Validation");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIUSPSaddresremoteaddressvalidation() {
		driver.setCurrentTestCase("ML_LI_USPS addres remote address validation");
		driver.setCurrentTestCaseDescription("ML_LI_USPS address validation-remote territory  address validation");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIUsershouldbeabletodeactivatehisaccount() {
		driver.setCurrentTestCase("ML_LI_User should be able to deactivate his account");
		driver.setCurrentTestCaseDescription("ML_LI_Deactivated Account_User should be able to deactivate his account");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIErrormessageforeditcreditcardwithpastdate() {
		driver.setCurrentTestCase("ML_LI_Error message for edit credit card  with past date");
		driver.setCurrentTestCaseDescription("ML_LI_Error message for edit credit card  with past date");
		driver.driveTestExecution();
	}
	@Test
	public void testMLAZnewuserwithwrongzipcodefromMylowespage() {
		driver.setCurrentTestCase("ML_AZ_new user with wrong zipcode from My lowes page");
		driver.setCurrentTestCaseDescription("ML_AZ_Verifying new user registration with wrong zipcode from My lowes page");
		driver.driveTestExecution();
	}
	@Test
	public void testMLAZnewuserwithwrongzipcodefromyouraccountsignuppage() {
		driver.setCurrentTestCase("ML_AZ_new user with wrong zipcode from your account sign up page");
		driver.setCurrentTestCaseDescription("ML_AZ_Verifying new user registration with wrong zipcode from your account sign up page");
		driver.driveTestExecution();
	}
	@Test
	public void testMLAZnewuserwithwrongzipcodefromSignInmodalpage() {
		driver.setCurrentTestCase("ML_AZ_new user with wrong zipcode from Sign In modal page");
		driver.setCurrentTestCaseDescription("ML_AZ_Verifying new user registration with wrong zipcode from Sign In modal page");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIHTML5DoctypeVerifyHomePage() {
		driver.setCurrentTestCase("ML_LI_HTML5 Doctype_Verify Home Page");
		driver.setCurrentTestCaseDescription("ML_LI_HTML5 Doctype_Verify Home Page");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIHTML5DoctypeVerifyMyLowesPage() {
		driver.setCurrentTestCase("ML_LI_HTML5 Doctype_Verify MyLowes Page");
		driver.setCurrentTestCaseDescription("ML_LI_HTML5 Doctype_Verify MyLowes Page");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIHTML5DoctypeVerifyRegistrationConfirmationEmail() {
		driver.setCurrentTestCase("ML_LI_HTML5 Doctype_Verify Registration Confirmation E-mail");
		driver.setCurrentTestCaseDescription("ML_LI_HTML5 Doctype_Verify Registration Confirmation E-mail");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIAddprimaryaddressValidaddress() {
		driver.setCurrentTestCase("ML_LI_Add primary address- Valid address");
		driver.setCurrentTestCaseDescription("ML_LI_Add primary address- Valid address");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIFAQpagelinkfromRemindersWelcomePage() {
		driver.setCurrentTestCase("ML_LI_FAQ page link from Reminders Welcome Page");
		driver.setCurrentTestCaseDescription("ML_LI_Reminders help navigation_FAQ page link from Reminders Welcome Page");
		driver.driveTestExecution();
	}
	@Test
	public void testMLLIPositiveFunctionalTesting() {
		driver.setCurrentTestCase("ML_LI_ Positive Functional Testing");
		driver.setCurrentTestCaseDescription("ML_LI_ Positive Functional Testing");
		driver.driveTestExecution();
	}
	@Test
	public void testMLCBCVerifyCBCWelcomemessageshowsonallpages() {
		driver.setCurrentTestCase("ML_CBC_Verify CBC Welcome message shows on all pages");
		driver.setCurrentTestCaseDescription("ML_CBC_Verify CBC Welcome message shows on all pages");
		driver.driveTestExecution();
	}
	@Test
	public void testMLCBCVerifyContractPricing() {
		driver.setCurrentTestCase("ML_CBC_Verify Contract Pricing");
		driver.setCurrentTestCaseDescription("ML_CBC_Verify Contract Pricing");
		driver.driveTestExecution();
	}
	@Test
	public void testMLCBCVerifythelandingpageproductdescription() {
		driver.setCurrentTestCase("ML_CBC_Verify the landing page product description");
		driver.setCurrentTestCaseDescription("ML_CBC_Verify the landing page product description");
		driver.driveTestExecution();
	}
	@Test
	public void testMLCBCSignedInLandingPage() {
		driver.setCurrentTestCase("ML_CBC_Signed In Landing Page");
		driver.setCurrentTestCaseDescription("ML_CBC_Signed In Landing Page");
		driver.driveTestExecution();
	}
	@Test
	public void testMLCBCEnhancedBanner() {
		driver.setCurrentTestCase("ML_CBC_Enhanced Banner");
		driver.setCurrentTestCaseDescription("ML_CBC_Enhanced Banner");
		driver.driveTestExecution();
	}
	@Test
	public void testMLCBCFieldsareleftblank() {
		driver.setCurrentTestCase("ML_CBC_Fields are left blank");
		driver.setCurrentTestCaseDescription("ML_CBC_Fields are left blank");
		driver.driveTestExecution();
	}
	@Test
	public void testMLCBCUsershouldNOTbeloggedinaftersuccessfulregistration() {
		driver.setCurrentTestCase("ML_CBC_User should NOT be logged in after successful registration");
		driver.setCurrentTestCaseDescription("ML_CBC_User should NOT be logged in after successful registration");
		driver.driveTestExecution();
	}

}
