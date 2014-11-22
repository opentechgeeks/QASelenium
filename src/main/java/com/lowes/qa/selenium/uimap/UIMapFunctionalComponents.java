package com.lowes.qa.selenium.uimap;

/**
 * UI Map for Functional Components
 */
public class UIMapFunctionalComponents
{
	/****************HOME PAGE************************/
	//WebElements
		//IDs
		public static final String webElmntLoginFrame = "iframe_modal_account";
		//xpath
		public static final String webElmntStoreInfo = "//*[@id='nav-store-info']/span[1]";
		public static final String webElmntLoginPopup = "//div[@id='modal_iframe_account']";
		public static final String webElmntSalutation = "//li[2][@id='lowes-salutation-active']/a/span";
	
	// Text boxes
		//IDs
		public static final String txtUserName= "Ecom_User_ID";
		public static final String txtPassword= "logonPassword";
		public static final String txtStoreZip = "nav-search-input";
		public static final String txtSearchBar = "Ntt";
	
	//Links
		//IDs
		
		//xpath
		public static final String lnkStoreUnzip = "//*[@id='disable-autozip']";
		public static final String lnkSignIn = "//a[contains(text(),'Sign In')]";
		public static final String lnkSignUp = "//a[@name='MASTHEAD_Account_SignUp']";
		
	
	/****************Registration Page************************/	
	// Buttons
		//xpath
		public static final String btnRegistrationSubmit = "//div[@id='registerSubmit']/button";
	
	// Text boxes
		//IDs
		public static final String txtFirstName ="firstName";
		public static final String txtLastName ="lastName";
		public static final String txtEmail ="email1";
		public static final String txtPhone ="phoneUS";
		public static final String txtRegPassword ="password1";
		public static final String txtConfPassword ="password2";
		
	/****************Product Details page************************/	
	//WebElements
		//xpath
		public static final String webElmntProductName= "/html/body/div[3]/div/div[2]/div/div/div[3]/div/div[2]/div[2]/div/h1";
		public static final String webElmntConfirmationTxt= "//div[@id='productAddToCart']//div/h2";
	
	//Text boxes
		//xpath
		public static final String txtQty = "//ul[@id='subTotal']/li[2]/div/input[3]";
	
	// Buttons
		//xpath
		public static final String btnAddToCart = "//li[2]/div/a/span";
		public static final String btnCheckout = "(//button[@type='button'])[4]";
	
		
}