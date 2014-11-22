package com.lowes.qa.selenium.uimap;

/**
 * UI Map for CheckOut
 */
public class UIMapCheckOut
{
	

	/****************Product Details Page************************/
	//button
		//xpath
		public static final String btnContinueShopping="//div[3]/div/button[1]";
		public static final String btnViewCartCheckout="//*[@id='miniCartDialog']/div[4]/a/span";
	//web element
		//id
		public static final String webElmntMiniCartCount="nav-cart-count";
		//xpath
		public static final String webElmntMiniCart="//*[@id='lowes-cart']/a/span[1]";
		public static final String webElmntMiniCartNextArrow="//*[@id='miniCart']/div[2]";
		public static final String webElmntMiniCartDiv="//*[@id='miniCart']/div";
		public static final String webElmntMiniCartItemCount1="//*[@id='miniCart']/ul/li";//no carousel
		public static final String webElmntMiniCartItemCount2="//*[@id='miniCart']/div[3]/ul/li";//with carousel
	//link
		//xpath
		public static final String lnkMiniCartItemName="//*[@id='miniCart']/ul/li[1]/div[2]/div[2]/h3/a";
		public static final String lnkMiniCartItems="//*[@id='miniCart']/ul/li";
		public static final String lnkMiniCartItems2="//*[@id='miniCart']/div/ul/li";
		public static final String lnkMiniCartItemName2="//*[@id='miniCart']/div/ul/li[1]/div[2]/div[2]/h3/a";//if mini cart has more than 3 items
	//check-box
		//xpath
		public static final String chkBoxEPPOption1="//*[@id='warranty']/li[1]/div/input[1]";
	//label
		public static final String lblEPPOption1="//*[@id='warranty']/li[1]/div/span";
		public static final String lblItemUnitPrice="//*[@id='pricing']/span";
	//text
		//name
		public static final String txtQtyDetails="quantity";
	/*************Product List*******************/
	//button
		//xpath
		public static final String btnAddToCart="//li[1]/div/div[3]/div[3]/a/span";//"//div[@class='addToCart']/a/span";
	/*************Shopping Cart Page*******************/
		
	//radio
		 //id
		public static final String rdoShpMdlStorePickUp = "PL";
		public static final String rdoShpMdlTruckDlvry = "LD";
		public static final String rdoShpMdlParcelShpng = "UPS";
		
	//text
		 //xpath
		public static final String txtCartEmpty = "//*[@id='cartMain']/div[3]/h3";
		public static final String txtQtyCart="//div[2]/div[3]/input";
		
	//label
		//xpath
		public static final String lblShoppingCartHeading="//*[@id='ShopCartForm']/div[2]/h2";
		public static final String lblCartSubtotal="//*[@id='ShopCartForm']/div[5]/div[2]/div[1]/ul/li[1]/div[2]/span";
		public static final String lblEstSalesTaxNoDeliverySelected="//*[@id='ShopCartForm']/div[5]/div[2]/div[1]/ul/li[2]/div[2]/span";
		public static final String lblEstSalesTax1DeliverySelected="//*[@id='ShopCartForm']/div[5]/div[2]/div[1]/ul/li[3]/div[2]/span";
		public static final String lblEstDelValue="//*[@id='ShopCartForm']/div[5]/div[2]/div[1]/ul/li[2]/div[2]/span";
		public static final String lblEstDelLabel="//*[@id='ShopCartForm']/div[5]/div[2]/div[1]/ul/li[2]/div[1]";
		public static final String lblEstDelHelp="//*[@id='ShopCartForm']/div[5]/div[2]/div[1]/ul/li[2]/div[1]/a/img";
		public static final String lblEstDelHelpTxt="//*[@id='cart-page']/div[16]/div[2]/p";
		public static final String lblParcelShippingoption3="//*[@id='scGenericshipModeId']/option[3]";
		public static final String lblRTFAddedMsg="//*[@id='productAddToCart']/div[2]/ul/li[1]/div[2]/div[2]";
		public static final String lblShoppingCart="//*[@id='ShopCartForm']/div[2]/h2";
		public static final String lblContinueShoppingPopup="//*[@id='return-to-shopping-tooltip']/h1";
		public static final String lblCartSummary="//*[@id='ShopCartForm']/div[5]/div[1]/h5";
		public static final String lblEstParcelShippingCharges="//*[@id='ShopCartForm']/div[5]/div[2]/div[1]/div[2]/div[1]/span/label";
		public static final String lblPromoCode="//*[@id='ShopCartForm']/div[5]/div[2]/div[1]/div[2]/div[2]/p[1]";
		public static final String lblSubTotal="//*[@id='ShopCartForm']/div[5]/div[2]/div[1]/ul/li[1]/div[1]";
		
		public static final String lblSubTotalValue="//*[@id='ShopCartForm']/div[5]/div[2]/div[1]/ul/li[1]/div[2]/span";
		public static final String lblDel1Charges="//*[@id='ShopCartForm']/div[5]/div[2]/div[1]/ul/li[2]/div[1]";
		public static final String lblDel1ChargesValue="//*[@id='ShopCartForm']/div[5]/div[2]/div[1]/ul/li[2]/div[2]/span";
		public static final String lblDel2Charges="//*[@id='ShopCartForm']/div[5]/div[2]/div[1]/ul/li[3]/div[1]";
		public static final String lblDel2ChargesValue="//*[@id='ShopCartForm']/div[5]/div[2]/div[1]/ul/li[3]/div[2]/span";
		public static final String lbl30DaysCartMsg="//*[@id='ShopCartForm']/div[5]/div[2]/div[2]/p";
		public static final String lblEmptyCartHeading="//*[@id='cartMain']/div[3]/h3";
		public static final String lblEmptyCartTxt1="//*[@id='cartMain']/div[3]/p[1]";
		public static final String lblEmptyCartTxt2="//*[@id='cartMain']/div[3]/p[2]";
		public static final String lblEmptyShoppingCart="//*[@id='cartMain']/div[2]/h2";
		public static final String lblEmptyCartSubtotal="//*[@id='cartMain']/div[5]/div[2]/div[1]/ul/li[1]/div[1]";
		public static final String lblEmptyCartSubtotalValue="//*[@id='cartMain']/div[5]/div[2]/div[1]/ul/li[1]/div[2]/span";
		public static final String lblEmptyCartEstSalesTax="//*[@id='cartMain']/div[5]/div[2]/div[1]/ul/li[2]/div[1]";
		public static final String lblEmptyCartEstSalesTaxValue="//*[@id='cartMain']/div[5]/div[2]/div[1]/ul/li[2]/div[2]/span";
		public static final String lblEmptyCartEstTotal="//*[@id='cartMain']/div[5]/div[2]/div[2]/ul/li/div[1]";
		public static final String lblEmptyCartEstTotalValue="//*[@id='cartMain']/div[5]/div[2]/div[2]/ul/li/div[2]";
		public static final String lblCartSummaryYouSave="//*[@id='ShopCartForm']/div[5]/div[2]/div[2]/ul/li[2]/div[1]";	
		public static final String lblCartSummaryYouSaveHelp="//*[@id='ShopCartForm']/div[5]/div[2]/div[2]/ul/li[2]/div[1]/a/img";
		public static final String lblCartSummaryYouSaveAmt="//*[@id='ShopCartForm']/div[5]/div[2]/div[2]/ul/li[2]/div[2]/span";
		public static final String lblYouSavePopupTxt="//*[@id='youSaveHelp']/p";
		public static final String lblParcelShippingOption1="//*[@id='scGenericshipModeId']/option[1]";
		public static final String lblParcelShippingOption2="//*[@id='scGenericshipModeId']/option[2]";
		public static final String lblParcelShippingOption3="//*[@id='scGenericshipModeId']/option[3]";
		public static final String lblUnavailableErrorMsg="//*[@id='ShopCartForm']/div[1]/div[1]";
		public static final String lblShipToAddress="//div[2]/div[1]/address";
		public static final String lblShipToName="//p[2]/span";
		public static final String lblDeliverToHeading="//p[2]/strong";
		public static final String lblStoreAddress1="//*[@id='store-info-content']/ul[1]/li[1]";
		public static final String lblStoreAddress2="//*[@id='store-info-content']/ul[1]/li[1]";
		public static final String lblPromoTxt1="//*[@id='ShopCartForm']/div[5]/div[2]/div[1]/div[2]/div[2]/div[2]/div/span[1]";
		public static final String lblPromoTxt2="//*[@id='ShopCartForm']/div[5]/div[2]/div[1]/ul/li[2]/div[1]";
		public static final String lblPromoDiscount="//*[@id='ShopCartForm']/div[5]/div[2]/div[1]/ul/li[2]/div[2]/span";
		//class
		//public static final String lblEPPItemNbr="epp-item-number";
	//web element
		//xpath
		public static final String webElmntCartItems="//*[@id='ShopCartForm']/div[4]/div";
		public static final String webElmntRTFItem1="//*[@id='productAddToCart']/div[2]/ul/li[1]/input";
		public static final String webElmntShippingDelInfo="//*[@id='cart-page']/div[16]/div[2]";
		public static final String webElmntShippingDelInfoClose="//*[@id='cart-page']/div[16]/div[1]/a/span";
		public static final String webElmntEasyExchangeInfo="//*[@id='cart-page']/div[17]/div[2]";
		public static final String webElmntEasyExchangeInfoClose="//*[@id='cart-page']/div[17]/div[1]/a/span";
		public static final String webElmntContinueShoppingPopup="//*[@id='return-to-shopping-tooltip']";
		public static final String webElmntContinueShoppingClose="//*[@id='cart-page']/div[18]/div[1]/a/span";
		public static final String webElmntPopupClose="//*[@class='ui-icon ui-icon-closethick']";
		public static final String webElmntStrtChkOut1Img="//*[@id='ShopCartForm']/div[2]/div[2]/a[2]/span/img";
		public static final String webElmntStrtChkOut2Img="//*[@id='ShopCartForm']/div[5]/div[2]/div[2]/span/a[2]/span/img";
		public static final String webElmntParcelShippingIcon="//*[@id='ShopCartForm']/div[5]/div[2]/div[1]/div[2]/div[1]/span/label/i";
		public static final String webElmntParcelShippingHelp="//*[@id='ShopCartForm']/div[5]/div[2]/div[1]/div[2]/div[1]/span/label/a/img";
		public static final String webElmntPromoCodeHelp="//*[@id='ShopCartForm']/div[5]/div[2]/div[1]/div[2]/div[2]/p[1]/a/img";
		public static final String webElmntCartLinkPopup="//div[@class='ajax_container ui-dialog-content ui-widget-content']";
		public static final String webElmntEmptyCart="//*[@id='cartMain']/div[3]";
		public static final String webElmntCloseChkOutPopup="//*[@class='ui-icon ui-icon-closethick']";
		public static final String webElmntMiniCartItem="//*[@id='miniCart']/ul/li/div[2]/div/a";
		public static final String webElmntDivAll="//*[@id='cart-page']/div";
		public static final String webElmntOrderConfirmationShipItems="//div[@class='l-module l-module-tertiary']";
		//id
		
		public static final String webElmntYouSavePopup="youSaveHelp";
		//class
		public static final String webElmntCartEPP="product-epp";
		//public static final String webElmntCloseChkOutPopup="ui-icon ui-icon-closethick";
	//link
		//class
		public static final String lnkProductDesc="itemdescription";
		
		
		//xpath
		public static final String lnkRTFItem1Name="//*[@id='productAddToCart']/div[2]/ul/li[1]/h2/a";
		public static final String lnkSafeSecure="//*[@id='ShopCartForm']/div[2]/h2/span/a";
		public static final String lnkSafeSecureEmptyCart="//*[@id='cartMain']/div[2]/h2/span/a";
	//dropdown
		//id
		public static final String drpDownParcelShippingOptions="scGenericshipModeId";
		//xpath
	//button
		//xpath
		public static final String btnRTFAddToCart="//*[@id='productAddToCart']/div[2]/ul/li[1]/div[2]/div[2]/button/span";
		public static final String btnQtyUpdate="//*[@class='button secondary update']/span";
		public static final String btnStrtSecureChkOut1="//*[@id='ShopCartForm']/div[2]/div[2]/a[2]/span";
		public static final String btnStrtSecureChkOut2="//*[@id='ShopCartForm']/div[5]/div[2]/div[2]/span/a[2]/span";
		public static final String btnPromoCodeApply="//a[@class='button secondary apply-promo-code']/span";
	/*************Gift Card Page Page*******************/
		//textbox
			//id
			public static final String txtGCQty="quantity";
			public static final String txtGCOtherAmt="gcAmount";
		//dropdown
			//id
			public static final String drpDownGCAmt="giftcard-value";
			
		//label
			//xpath
			public static final String lblGCQtyError="//*[@id='giftCardForm']/div/ul/li[3]/label[2]";
			public static final String lblGCAmtError="//*[@id='giftcard-other-amount']/label[2]";
			
		//button
			//xpath
			public static final String btnGCCheckOut="//*[@id='giftCardForm']/div/ul/li[10]/button";
		//weblement
			//id
			public static final String webElmntGCItemId="catEntryId";
			
			
			 //id
				public static final String txtPromoCode = "promoCode1";
				
			//WebElements
				public static final String webElmntPrsntPromoCodeErrMsg = "//*[@id='ShopCartForm']/div[5]/div[2]/div[1]/div[2]/div[2]/div[2]/div/p";
				
			//buttons
				//xpath
				public static final String btnPromoCode = "//form[@id='ShopCartForm']/div[5]/div[2]/div/div[2]/div[2]/div[2]/a/span";
				
				
		    //Link
				//id
				public static final String lnkCart = "nav-cart-label";
		/**********Purchases Page**********/
			//xpath
				public static final String txtOderTypePurchases = "//*[@id='paymentAmounts']/ul/li[2]/span[1]";
					
			//id
				public static final String btnFindOrderSubmit = "findOrdersSubmit";	
		/**********Product Destination Page**********/	
		//	label
				//xpath
				public static final String lblPDShippingAddress="//span[@id='display-ship-address-dropdown-PD']/li/div";
				public static final String lblLDShippingAddress="//span[@id='display-ship-address-dropdown-LD']/li/div";
		//drop-down
				//id
				public static final String drpDownLDShippingAddress="shippingAddress-LD";
				public static final String drpDownPDShippingAddress="shippingAddress-PD";
		//radio button
			//id
				public static final String rdoBtnUSPSEnteredAddress="usps1";
		/**********Order Confirmation Page**********/
		//label
			//css
				public static final String lblBillAdressNameOC="span.name";
				public static final String lblBillAdressOC="address";
				public static final String lblShipAdressNameOC="p.pickup-store > span";
				public static final String lblShipAdressOC="div.aside > address";
				public static final String lblDelType="span.fullfillment-title";
				public static final String lblOrderTotalOrdrConfirmation="li.conf-balance > div.value";
				public static final String lblOrderNbr="strong.number";
		/**********Address Book Page**********/	
		//label
				//xpath
				public static final String lblBillAdressFnameAB="//*[@id='address_book']/div[2]/div[3]/div[1]/span[1]";
				public static final String lblBillAdressLnameAB="//*[@id='address_book']/div[2]/div[3]/div[1]/span[2]";
				public static final String lblBillAdressLine1AB="//*[@id='address_book']/div[2]/div[3]/div[2]/span[2]";
				public static final String lblBillAdressCityAB="//*[@id='address_book']/div[2]/div[3]/div[2]/span[4]";
				public static final String lblBillAdressStateAbbAB="//*[@id='address_book']/div[2]/div[3]/div[2]/span[5]";
				public static final String lblBillAdressZipCodeAB="//*[@id='address_book']/div[2]/div[3]/div[2]/span[6]";
				public static final String lblBillAdressPhn1AB="//*[@id='address_book']/div[2]/div[3]/div[3]/span/span[1]";
				public static final String lblBillAdressPhn2AB="//*[@id='address_book']/div[2]/div[3]/div[3]/span/span[2]";
				public static final String lblBillAdressPhn3AB="//*[@id='address_book']/div[2]/div[3]/div[3]/span/span[3]";
				public static final String lblBillAdressName="//*[@id='address_book']/div[2]/div[2]/span[1]/strong/span";
				
				public static final String lblBillNoAdress="//*[@id='address_book']/div[2]/div[3]/div[2]/p/i";
				
				
				public static final String lblShipAdressFnameAB="//*[@id='address_book']/div[3]/div[3]/div[1]/span[1]";
				public static final String lblShipAdressLnameAB="//*[@id='address_book']/div[3]/div[3]/div[1]/span[2]";
				public static final String lblShipAdressLine1AB="//*[@id='address_book']/div[3]/div[3]/div[2]/span[2]";
				public static final String lblShipAdressCityAB="//*[@id='address_book']/div[3]/div[3]/div[2]/span[4]";
				public static final String lblShipAdressStateAbbAB="//*[@id='address_book']/div[3]/div[3]/div[2]/span[5]";
				public static final String lblShipAdressZipCodeAB="//*[@id='address_book']/div[3]/div[3]/div[2]/span[6]";
				public static final String lblShipAdressName="//*[@id='address_book']/div[3]/div[2]/span[1]/strong/span";
				public static final String lblShipAdressPhn1AB="//*[@id='address_book']/div[3]/div[3]/div[3]/span/span[1]";
				public static final String lblShipAdressPhn2AB="//*[@id='address_book']/div[3]/div[3]/div[3]/span/span[2]";
				public static final String lblShipAdressPhn3AB="//*[@id='address_book']/div[3]/div[3]/div[3]/span/span[3]";
				
				public static final String lblShipAdressFnameAB2="//*[@id='address_book']/div[4]/div[3]/div[1]/span[1]";
				public static final String lblShipAdressLnameAB2="//*[@id='address_book']/div[4]/div[3]/div[1]/span[2]";
				public static final String lblShipAdressLine1AB2="//*[@id='address_book']/div[4]/div[3]/div[2]/span[2]";
				public static final String lblShipAdressCityAB2="//*[@id='address_book']/div[4]/div[3]/div[2]/span[4]";
				public static final String lblShipAdressStateAbbAB2="//*[@id='address_book']/div[4]/div[3]/div[2]/span[5]";
				public static final String lblShipAdressZipCodeAB2="//*[@id='address_book']/div[4]/div[3]/div[2]/span[6]";
				public static final String lblShipAdressName2="//*[@id='address_book']/div[4]/div[2]/span[1]/strong/span";
				
				public static final String txtAddressName = "address-name-LD";
				public static final String txtFName= "fname-LD";
				public static final String txtLName= "lname-LD";
				public static final String txtAdd1 = "address-1-LD";
				public static final String txtAdd2 = "address-2-LD";
				public static final String txtCity= "city-LD";
				public static final String txtState= "state-LD";
				public static final String txtZip= "zip-LD";
				public static final String btnSavePD = "//li[11]/div[2]/a/span";
				
				public static final String txtPriAddName="(//input[@id='addressField2'])[2]";
				public static final String txtPriAddFName="(//input[@id='firstName'])[2]";
				public static final String txtPriAddLName="(//input[@id='lastName'])[2]";
				public static final String txtPriAddPhn="(//input[@name='phone1'])[2]";
				
		/**********Review & Pay Page**********/	
				//button
				//xpath
				public static final String btnApplyGC="//*[@id='giftCardInputs']/fieldset/ol/li[4]/div/a/span";
				//label
				//xpath
				public static final String lblRevPayError="//*[@id='content-area-no-nav-wider']/div[1]/p";
				public static final String lblOrderTotal="//*[@id='Total']";
				public static final String lblPromoTxtRevPay="//*[@id='two-column-b']/div[2]/table/tbody/tr[2]/td[1]/span";
				public static final String lblPromoDiscountRevPay="//*[@id='two-column-b']/div[2]/table/tbody/tr[2]/td[2]/span";
				//css
				public static final String lblEmailReqderror="label.error";
				

				public static final String btnAddtoCart1= "//li[2]/div/a/span";
				public static final String btnCheckOut1 = "(//button[@type='button'])[4]";
			    public static final String rdoBtnEpp1 = "//*[@id='item_3246500']/div[2]/div[6]/div[2]/label[1]/span";
			    public static final String rdoBtnEpp2 = "//*[@id='item_3246500']/div[2]/div[6]/div[2]/label[2]/span";
			    public static final String rdoBtnEpp3 = "//*[@id='item_3246500']/div[2]/div[6]/div[2]/label[3]";
			    public static final String rdoBtnSPU = "PLshipModeId_1";
			    public static final String rdoBtnLTD = "LDshipModeId_1";
			    public static final String rdoBtnPS = "UPSshipModeId_1";
			    public static final String rdoBtnBOGOSPU = "PLshipModeId_2";
			    public static final String rdoBtnBOGOLTD = "LDshipModeId_2";
			    public static final String rdoBtnBOGOPS = "UPSshipModeId_2";
			    public static final String webElmntYouSave = "//*[@id='ShopCartForm']/div[5]/div[2]/div[2]/ul/li[2]/div[1]";
			    public static final String webElmntYouSaveShpAdress = "//*[@id='two-column-b']/div[1]/table/tbody/tr[6]";
			    public static final String webElmntYouSaveRevAdress = "//*[@id='two-column-b']/div[2]/table/tbody/tr[5]/td[1]";
			    public static final String webElmntYouSaveconfAdress = "//*[@id='conf-main']/div[2]/div[2]/div[2]/ul/li[6]/div[1]";
			    public static final String webElmntVerifiyMessage = "//*[@id='two-column-b']/div[1]/table/tbody/tr[3]/td[1]/div";
			    
			    public static final String txtErrorForMoreMiles = "//div[5]/div/div/div/p";
			    public static final String txtErrorForAvailability = "//td[2]/span";
			    public static final String txtErrorForShipToAddress = "//span/li/div/p/span";
			    
			 // Sasi
				//Xpath
				public static final String webElmntShoppingCart=".//*[@id='ShopCartForm']/div[2]/h2";
				public static final String webElmntBilledTo=".//*[@id='conf-main']/div[2]/div[2]/div[1]/div/div[1]/div[2]";
				public static final String webElmntDeliverTo="";
				public static final String webElmtSpecialFinancing="//*[@id='two-column-b']/div[2]/table/tbody/tr[2]/td[1]/span";
				public static final String btncompleteOrder=".//*[@id='revpay_com_order']/span";
				public static final String diaUSPSPopup="//*[@id='DialogAddressConfirm']/div";
				public static final String btnConfirmUSPSPopup=".//*[@id='btAddrConfirm']";
				//ID's
				public static final String rdoBtnLCCSpecialFinancing="financing-options";
				public static final String rdoBtnLCCPercentOff="percent-off";
				public static final String removeGCLink="Remove";
				
				
			    public static final String state="state";
				public static final String addressNickName="address-name";
				public static final String firstName="fname";
				public static final String lastName="lname";
				public static final String addressLine1="address-1";
				public static final String city="city";
				public static final String zipcode="zip";
				public static final String creditNo="//div[2]/fieldset/ol/li[2]/div/input";
				public static final String txtCheckOutCreditCardNo="cardNumber";
				public static final String impulseBuyNoThankslink="//div[16]/div[2]/div/div[2]/a";
				
				
				public static final String webElmntImpulsePopUp = "//*[@id='cart-page']/div[16]";
			    public static final String lnkNoThanks = "no_suggested";  
			    public static final String WebElmtErrorMsgWrongPin="//*[@id='content-area-no-nav-wider']/div[1]/p";
			    
//Kishore 
			    //xpath
			    public static final String lblestimatedTotalValue = "//*[@id='ShopCartForm']/div[5]/div[2]/div[2]/ul/li/div[2]/span";  
			    public static final String lnkRemove = "//*[@id='ShopCartForm']/div[5]/div[2]/div[1]/div[2]/div[2]/div[2]/div/span[2]/a";
			    public static final String txtParentQuantityInCart = "//div[3]/input";
			    public static final String lblLineQuanityInCart = "//div[6]/div[2]/div[3]";
			    public static final String lblUnitPriceValue = "//div[2]/div[4]/div/div";
			    public static final String lblTotalValue = "//div[5]/div/div";
			    public static final String lblLineUnitPriceValue = "//div[6]/div[2]/div[4]/div";
			    public static final String availablityPopover = "//div[16]/div[2]";
			    public static final String cancelAvailabilityPopover = "//*[@id='cancelModal']";
			    public static final String lblLineTotalValue = "//div[6]/div[2]/div[5]/div";
			    public static final String txtDeliveryDirections = "//textarea";
			    public static final String lblSpecialTax = "//div[6]";
			    
			  //20th Kish
			    //xpath
			    public static final String txtGCTo = "//li/input";
			    public static final String txtGCFrom = "//li[2]/input";
			    public static final String btnGCSave = "//div[2]/div/div[2]/div/a";
			    public static final String txtGCUnitPrice = "//div[4]/div/input";
			    public static final String lblLD = "(//div[2]/div/div/div)[1]";
			    public static final String lblSD = "//*[@id='ShopCartForm']/div[5]/div[2]/div[1]/div[2]/div[2]/div[2]/div/span[1]";
			    public static final String lblPromoDiscountTotal = "//div[5]/span/div/p";
			    public static final String lblEmpAndRetlPriceWithSavings = "//div[2]/div[2]/div[4]/div";
			    public static final String lblEmpPrice = "//div[2]/div[2]/div[4]/div/div";
			    public static final String lblEmpSavings = "//div[2]/div[2]/div[4]/div/span";
								
			    //name
			    public static final String txtGCMsg = "gcMessage";
			    //id
			    public static final String lccBanner = "lcc-block";
			    /*******************KRISHNA  2/17*******************/
			    public static final String removeGiftCard = "//a[contains(text(),'Remove')]";
			    public static final String BusinessChargesInReview = "//div[@id='two-column-b']/div/table/tbody/tr[5]/td/strong";
			    public static final String BusinessChargesInConfirm = "//div[@id='conf-main']/div[3]/div[2]/div/p[4]";
			    
			    public static final String footersafe = "//*[@id='footer-safe-shop']";
			    public static final String footertoc = "//*[@id='footer-toc']";
			    public static final String footerprivacy = "//*[@id='footer-privacy']";
			    public static final String footercalifornia = "//*[@id='footer-california']";
			    public static final String footerblock = "//div[@id='footer-block']/div[2]/div/p";
			    
//3rd Mar
			    public static final String lblStorePickUpLeadTime="//div[2]/div[2]/ul/li[1]/div[2]";
			    public static final String lblLTDLeadTime="//div[2]/div[2]/ul/li[2]/div[2]";
			    public static final String lblParcelLeadTime="//div[2]/div[2]/ul/li[3]/div[2]";
			    public static final String lblEstArrivalDateValue = "//*[@id='conf-main']/div[3]/div[2]/div[1]/p[1]/span";
			    public static final String lblLeadTimeinReviewPay = "//*[@id='two-column-b']/div[1]/table/tbody/tr[3]/td[1]/div";
			    public static final String lblNoLeadTimeInOC = "//*[@id='conf-main']/div[3]/div[2]/div[1]/p[1]";
			    public static final String lblAddPurchases = "//*[@id='purchaseControls']/a";
			    
//Ankita
			    /*************Shopping Cart Page*******************/
			  //label
			  //xpath
			  public static final String lblImpulseBuyItemName="//*[@id='suggested_item']/div/div[1]/div[2]/h4";
			  //web element
			  //id
			  public static final String webElmntDelMethodsBuyImpulse="ship-options";
			  //button
			  //xpath
			  public static final String btnAddToCartBuyImpulse="//*[@id='suggested_item']/div/div[2]/div[2]/a/span";
			  //link
			  //id
			  public static final String lnkNoThanksBuyImpulse="no_suggested";
			   
			  /**********Product Destination Page**********/ 
			  // label
			  //xpath
			  public static final String lblTruckDelNotAvailable="//*[@id='two-column-b']/div[1]/table/tbody/tr[2]/td[2]/span";
			  public static final String lblShippingAddressError="//*[@id='display-ship-address-dropdown-LD']/li[1]/div/p/span";
			  /**********Review & Pay Page**********/ 
			  //label
			      //xpath
			  public static final String lblGCBalance="//*[@id='giftCardInputs']/fieldset/ol/li[5]/table/tbody/tr[1]/td[3]";
			  public static final String lblAmtAppliedonGC="//*[@id='giftCardInputs']/fieldset/ol/li[5]/table/tbody/tr[2]/td[2]/span";
			      //id
			  public static final String lblBalanceDueAfterGC="gcBalanceDue";
			  //web element
			      //id
			  public static final String webElmntExpirationFields="card-exp-date";
			  //drop-down
			  public static final String drpDownExpMonth="//*[@id='expiration-month']";
			  public static final String drpDownExpYear="//*[@id='expiration-year']";
			  //text
			  public static final String txtCardNbr="//*[@id='cc-add']/fieldset/ol/li[2]/div/input";
			  /*************Gift Card Page Page*******************/
			  //radiobutton
			  public static final String rdoBtnParcelShippingGC="//*[@id='giftcard-delivery']/input";
			  //textbox
			  //id
			  public static final String txtGCTo1="gcTo_i";
			  public static final String txtGCFrom1="gcFrom_i";
			  public static final String txtGCMsg1="gift-msg-txtarea";
			  /**********Product Destination Page**********/ 
			  //text
			  //name
			  public static final String txtAddressNickNamee="addressField2";
			  public static final String txtAddressFNamee="firstName";
			  public static final String txtAddressLNamee="lastName";
			  public static final String txtAddressLinee1="address1";
			  public static final String txtAddressCityy="city";
			  public static final String txtAddressStatee="state";
			  //xpath
			  public static final String txtAddressZipCodee="//ol/span[2]/li[9]/div/input";
			  /**********Shipping Options Page**********/ 
			  //label
			  //xpath
			  public static final String lblServiceLevel="//*[@id='billing-address-edit']/fieldset/ol/li[2]/div";
			  public static final String lblShipToAdd="//*[@id='billing-address-edit']/fieldset/ol/li[3]/div/p";
			//label
			//xpath
			public static final String lblTruckDel="//*[@id='two-column-b']/div[1]/table/tbody/tr[2]/td[2]";
			/**********Product Destination Page**********/ 
			//drop-down
			//xpath
			public static final String drpDownSelectShipAddress="//*[@id='billing-address-edit']/fieldset/ol/span/li/div/select";
			public static final String lnkReturnToCart = "//*[@id='two-column-b']/div[1]/div/a";
//Krishna
			public static final String txtAddressNameUPS = "address-name-PD";
			public static final String txtFNameUPS= "fname-PD";
			public static final String txtLNameUPS= "lname-PD";
			public static final String txtAdd1UPS = "address-1-PD";
			public static final String txtAdd2UPS = "address-2-PD";
			public static final String txtCityUPS= "city-PD";
			public static final String txtStateUPS= "state-PD";
			public static final String txtZipUPS= "zip-PD";
			public static final String btnSavePDUPS = "//li[10]/div[2]/a/span";
			
			//Kish
			public static final String btnPrevious = "//*[@id='content-area-no-nav-wider']/div[2]/div/div/div[1]/div/ul/li[2]/a/span";
			public static final String frameConfirmParcelOptions = "//*[@id='content-area-no-nav-wider']/div[2]/div/div/div[1]";
			public static final String lnkAddNewAddress = "//li[2]/div[2]/a";
			//public static final String drpDownAddressValues="//*[@id='billing-address-edit']/fieldset/ol/span/li/div/select/option";
			public static final String lblDetailPrice = "//*[@id='mystore-item-price']";
			public static final String lblPriceInNotification = "//div[21]/div[2]/div/div[1]";
			public static final String frameReviewPay = "//div[2]/div/div[2]/div/div";
			public static final String giftCardSection = "//*[@id='giftCardInputs']";
			public static final String lbloneOrMoreGC = "//*[@id='giftCardInputs']/fieldset/ol/li[1]/div/label";
			public static final String GCNumber = "//*[@id='giftCardInputs']/fieldset/ol/li[2]";
			public static final String GCPin = "//*[@id='giftCardInputs']/fieldset/ol/li[3]";
			public static final String GCApply = "//*[@id='giftCardInputs']/fieldset/ol/li[4]/div/a";
			public static final String lblCardType = "//*[@id='CreditcardForm']/div[2]/fieldset/ol/li[1]/label";
			public static final String ddCardType = "//*[@id='checkout-card-type']";
			public static final String imgCardType = "//*[@id='CreditcardForm']/div[2]/fieldset/ol/li[1]/div/img";
			public static final String crdtCardNoForm = "//*[@id='CreditcardForm']/div[2]/fieldset/ol/li[2]";
			public static final String sCodeForm = "//*[@id='CreditcardForm']/div[2]/fieldset/ol/li[3]";
			public static final String expDateForm = "//*[@id='card-exp-date']";
            public static final String chkBoxUseShip = "//*[@id='billing-address-edit']/div/label";
            public static final String billFirstName = "//*[@id='billing-address-edit']/fieldset/ol/li[1]";
            public static final String billLastName = "//*[@id='billing-address-edit']/fieldset/ol/li[2]";
            public static final String billCompanyName = "//*[@id='billing-address-edit']/fieldset/ol/li[3]";
            public static final String billAddrLine1 = "//*[@id='billing-address-edit']/fieldset/ol/li[4]";
            public static final String billAddrLine2 = "//*[@id='billing-address-edit']/fieldset/ol/li[5]";
            public static final String billCity = "//*[@id='billing-address-edit']/fieldset/ol/li[6]";
            public static final String billState = "//*[@id='billing-address-edit']/fieldset/ol/li[7]";
            public static final String billZip = "//*[@id='billing-address-edit']/fieldset/ol/li[8]";
            public static final String billPhone = "//*[@id='billing-address-edit']/fieldset/ol/li[9]";
            public static final String billEmail = "//*[@id='billing-address-edit']/fieldset/ol/li[10]";
            public static final String iWantFreeAcc = "//*[@id='simple-reg-container']";
            public static final String iWantFreeAccLogin = "//*[@id='simple-reg-container']/li[2]";
            public static final String iWantFreeAccPwd = "//*[@id='simple-reg-container']/li[3]";
            public static final String iWantFreeAccReEnterPwd = "//*[@id='simple-reg-container']/li[4]";
            public static final String cartSummary = "//*[@id='two-column-b']/div[1]";
            public static final String lnkRtrnToCart = "//*[@id='two-column-b']/div[1]/div/a";
            public static final String lblProductsInCart = "//*[@id='two-column-b']/div[1]/table/tbody/tr[1]/th[1]";
            public static final String lblUnitPrice = "//*[@id='two-column-b']/div[1]/table/tbody/tr[1]/th[2]";
            public static final String lblQuantity = "//*[@id='two-column-b']/div[1]/table/tbody/tr[1]/th[3]";
            public static final String lblTotal = "//*[@id='two-column-b']/div[1]/table/tbody/tr[1]/th[4]";
            public static final String ifOrderdMsg = "//*[@id='two-column-b']/div[1]/table/tbody/tr[3]/td[1]/div";
            public static final String shipToMsg = "//*[@id='two-column-b']/div[1]/table/tbody/tr[4]/td";
            public static final String arrivesMsg = "//*[@id='two-column-b']/div[1]/table/tbody/tr[5]/td";
            

          //Ankita 5th-6th March
          		/**********Product Destination page********/
          			 //drop-down
          			    //xpath
          			    public static final String drpDownAddressValues="//*[@id='billing-address-edit']/fieldset/ol/span/li/div/select/option";
          			  //label
          			    //xpath
          			    public static final String lblChooseParcelDest="//*[@id='content-area-no-nav-wider']/div[2]/div/div/div[1]/h5";
          			    public static final String lblChooseLTDDest="//*[@id='content-area-no-nav-wider']/div[2]/div/div/div[2]/h5";
          	    /**********Review & Pay page********/ 
          			  //Label
          			    //xpath
          			    public static final String lblCartSummaryUnitPrc="//*[@id='two-column-b']/div[1]/table/tbody/tr[3]/td[2]";
          			    public static final String lblCartSummaryQty="//*[@id='two-column-b']/div[1]/table/tbody/tr[3]/td[3]";
          			    public static final String lblCartSummaryTotl="//*[@id='two-column-b']/div[1]/table/tbody/tr[3]/td[4]";
          			    public static final String lblBillSummrySubtotal="//*[@id='two-column-b']/div[2]/table/tbody/tr[1]/td[1]/strong";
          			    public static final String lblBillSummrySubtotalValue="//*[@id='two-column-b']/div[2]/table/tbody/tr[1]/td[2]/strong";
          			    public static final String lblBillSummryDelivry="//*[@id='two-column-b']/div[2]/table/tbody/tr[2]/td[1]";
          			    public static final String lblBillSummryDelivryCost="//*[@id='shpCost']";
          			    public static final String lblBillSummryTax="//*[@id='two-column-b']/div[2]/table/tbody/tr[3]/td[1]";
          			    public static final String lblBillSummryTaxValue="//*[@id='two-column-b']/div[2]/table/tbody/tr[3]/td[2]";
          			    public static final String lblBillSummrybalncDue= "//*[@id='two-column-b']/div[2]/table/tbody/tr[4]/td[1]";
          			    public static final String lblBillSummrybalncDueValue= "//*[@id='Total']";
          			    public static final String lblGiftCards="//*[@id='giftCardInputs']/h3";
          			    public static final String lblCreditCardInfo="//*[@id='CreditcardForm']/h3[1]";
          			    public static final String lblBillingInfo="//*[@id='CreditcardForm']/h3[2]";
          			    public static final String lblCartSummary1="//*[@id='two-column-b']/div[1]/div/h5";
          			    public static final String lblBillSummary1="//*[@id='two-column-b']/div[2]/div[1]/h5";		
          			  //chk box
          			    public static final String chkBoxStoreCard="//*[@id='storeCard']";
          			    public static final String chkBoxPrimaryCard="//*[@id='primaryCard']";
          	/**********Order Confirmation page********/ 
          		//Label
          			//xpath
          			    public static final String lblThankYouMsg= "//*[@id='conf-main']/div[1]";
          			    public static final String lblOrderDetails="//*[@id='conf-main']/div[2]/div[1]/h5";
          			    public static final String lblShipDetails= "//*[@id='conf-main']/div[3]/div[1]/h5/span[2]";
          		//Web Elemnet
          			//xpath
          			    public static final String webElmntOrderDetailsBox="//*[@id='conf-main']/div[2]";
          			    public static final String webElmntCreateAcctBox="//*[@id='user-signup']";
          	/***Secure Checkout****/
          		//Web Elemnet
          			//xpath	
          			    public static final String webElmntSecureChkOutTab1="//*[@id='content-area-no-nav-wider']/div[1]/div/div/div/div[1]";
          			    public static final String webElmntSecureChkOutTab2="//*[@id='content-area-no-nav-wider']/div[1]/div/div/div/div[2]";
          			    public static final String webElmntSecureChkOutTab3="//*[@id='content-area-no-nav-wider']/div[1]/div/div/div/div[3]";
          			    public static final String webElmntSecureChkOutTab4="//*[@id='content-area-no-nav-wider']/div[1]/div/div/div/div[4]";
          			    public static final String lblPDShippingAddress2="//*[@id='display-ship-address-dropdown-PD']/li[1]/div";
          			    public static final String webElmntForgtPsswrdDialog="//*[@id='forgotPasswordDialog']";
          		//label
          			//xpath
          			    public static final String lblSecureChkOut="//*[@id='content-area-no-nav']/h1";
          			    public static final String lblIHvLowesAcct= "//*[@id='Logon']/div/div/div[1]/h5";
          			    public static final String lblChkOutFastr="//*[@id='Logon']/div/div/div[2]/p";
          			    public static final String lblEmail="//*[@id='Logon']/div/div/div[2]/fieldset/ol/li[1]/label";
          			    public static final String lblEmailExample= "//*[@id='Logon']/div/div/div[2]/fieldset/ol/li[1]/div/div";
          			    public static final String lblPasswrd="//*[@id='Logon']/div/div/div[2]/fieldset/ol/li[2]/label";
          			    public static final String lblPasswrdInstruction="//*[@id='Logon']/div/div/div[2]/fieldset/ol/li[2]/div/div";
          			    public static final String lblNeedHelp="//*[@id='content-area-no-nav']/p";
          			    public static final String lblIDntHvLowesAcct="//*[@id='login-container']/div/div/div[1]/h5";
          			    public static final String lblInvalidEmailError="//*[@id='content-area-no-nav']/div[1]/p";
          		//button
          			    //xpath
          			    public static final String btnSignIn="//*[@id='Logon']/div/div/div[2]/fieldset/ol/li[4]/div/a[1]/span";
          			    public static final String btnChkOut= "//*[@id='login-container']/div/div/div[2]/div/a/span";
          		//link
          			    //xpath
          			    public static final String lnkForgotPswrd="//*[@id='forgotPasswordLink']";
          			    
          	/**********Shipping Options page********/
          		//label
          			    //xpath
          			    public static final String lblConfrmParcelOptions="//*[@id='content-area-no-nav-wider']/div[2]/div/div/div[1]/form/div[1]/h5";
          			    public static final String lblConfrmLTDOptions="//*[@id='content-area-no-nav-wider']/div[2]/div/div/div[1]/form/div[3]/h5";
          			    public static final String lblLTDTxt="(//*[@id='billing-address-edit']/fieldset)[2]";
             /**********Shopping Cart page********/   
          	//text box
          			   //name
          			    public static final String txtGCToCart="gcTo";
          			    public static final String txtGCFromCart="gcFrom";
          			    public static final String txtGCMsgCart="gcMessage";
          	//label
          		//xpath
          			    public static final String lblGCMsgMaxLen="//div[2]/div[1]/div[2]/ol/li[3]/p/span";
          			    public static final String lblGCInvalidQtyError= "//*[@id='giftCardErrors']/ul/li[3]";
          			    public static final String lblGCInvalidUntPrcError="//*[@id='giftCardErrors']/ul/li[2]";
          			    public static final String lblGCParcelFree="//*[@id='shpCost']/span";
          			    public static final String lblWasPriceCart= "//div[2]/div[4]/div/p";
          			    public static final String lblUPSavingsCart= "//div[2]/div[4]/div/span";
          			    public static final String lblUnitPriceCart= "//div[2]/div[4]/div";
          	//webelement
          			    //xpath
          			    public static final String webElmntHome="//*[@id='header-brand']/a/img";
          			    public static final String gcParcelShippingOptionsCount="//*[@id='scGenericshipModeId']/option";
          			    public static final String drpDownGCParcelShippingOption="//*[@id='scGenericshipModeId']";
          /***********Store Locator page***/
          	//text
          			    //id
          			    public static final String txtStoreSearch="SL-map-search";
          			    public static final String txtToStore="SL-map-directions-to";
          			    public static final String txtFromStore="SL-map-directions-from";
          			    public static final String txtChngStoreSearch="Header-map-search";
          	//web elemnt
          			    //xpath
          			    public static final String webElmntResult24="//*[@id='LowesStoreLocator']/div[1]/div[1]/div[3]/div/div[1]/ol/li[24]";
          			    public static final String webElmntResult1="//*[@id='LowesStoreLocator']/div[1]/div[1]/div[3]/div/div[1]/ol/li[1]";
          			    public static final String webElmntGetDirectionsBox="//form/div/div[1]/div[1]/div[1]/div[2]";
          			   
          			    //id
          			    public static final String webElmntchngStorePopup= "HeaderLocator";
          			    public static final String webElmntStoreInfoPopup="store-info-content";
          	//link
          			    //xpath
          			    public static final String lnkShowDetails="//*[@id='LowesStoreLocator']/div[1]/div[1]/div[3]/div/div[1]/ol/li[1]/a/span";
          			    public static final String lnkGetDirections="//*[@id='LowesStoreLocator']/div[1]/div[1]/div[3]/div/div[1]/ol/li[1]//ul/li[3]/a";
          			    public static final String lnkBackToStoreSearch="//*[@id='SL-map-directions']/a/span[2]";
          			    public static final String lnkchngStore="//*[@id='nav-store-change']/span[2]";
          			    public static final String lnkMakeThisYourStore="//*[@id='Header-map-list']/div/div[1]/ol/li[1]/ul/li[2]/a";
          			    public static final String lnkStoreInfo="//*[@id='nav-store-info']/span[1]";
          	//button
          			    //id
          			    public static final String btnReverseDirections="SL-map-switch-directions";
          			    public static final String btnGetDirections= "SL-map-get-directions";
          			    //xpath
          			    public static final String btnPrint="//form/div/div[1]/div[1]/div[3]/div/div[1]/a";
          	//label
          			    //xpath
          			    public static final String lblDrivingDirectionsHd="//div[1]/div[3]/div/div[1]/h5";
          			    
          	/************Purchases**********/
          	//text
          			    //id
          			    public static final String txtOrderSearch="confNumber";
          	//label
          			    //xpath
          			    public static final String lblPurchaseStatus="//*[@id='order_detail']/div[1]/div[2]/table/tbody/tr[2]/td[2]";
          	/************Product list**********/	
          	//label
          			    //xpath
          			    public static final String lblQuickViewWasPrice= "//*[@id='pricing']/span[2]";
          			    public static final String lblQuickViewSavePercent="//*[@id='pricing']/p/span";
          			    public static final String lblQuickViewMapPrice="//*[@id='pricing']";
          			    public static final String lblPDMapPrice="//*[@id='pricing']";
          			    public static final String lblQuickViewClose="//*[@id='Category']/div[39]/div[1]/a/span";
          			    public static final String lblQuickViewClose2="//*[@id='Category']/div[23]/div[1]/a/span";
          			    public static final String lblMapQuickViewClose="//div[39]/div[1]/a/span";
          			    public static final String lblMapQuickViewClose2="//div[24]/div[1]/a/span";
          			    public static final String lblComprItem1OriginalPrice="//*[@id='product-compare-area']/div[3]/div[4]/table/tbody/tr[4]/td/span";
          			    public static final String lblComprItem1PriceMap="//*[@id='product-compare-area']/div[3]/div[4]/table/tbody/tr[4]/td/div";
          			    public static final String lblComprItem1OrigPriceMap="//*[@id='product-compare-area']/div[3]/div[4]/table/tbody/tr[5]/td";
          			    public static final String lblComprItem1RetailPrcMap= "//*[@id='product-compare-area']/div[3]/div[4]/table/tbody/tr[6]/td/p/span";
          			    public static final String lblComprItem1Savings="//*[@id='product-compare-area']/div[3]/div[4]/table/tbody/tr[5]/td";
          	//link
          			    public static final String lnkComprItem1Name="//*[@id='header_container']/div[2]/div/table/tbody/tr[2]/td/div[2]/a";
          	//button
          			    public static final String btnCompare="//*[@id='itemBar']/div[1]/a";
          	/************Product Details**********/	
          	//label
          			    //xpath
          			    public static final String lblWasPricePD="//*[@id='pricing']/p[1]";
          			    public static final String lblWasPriceSavingsPD="//*[@id='pricing']/p[2]/span";
          			    public static final String lblWasPriceSavePercnt="//*[@id='pricing']/p[2]/span[2]";
          	/************Review & Pay**********/	
          			  //label
          			    //xpath
          			    public static final String lblShipToRevPay="//*[@id='two-column-b']/div[1]/table/tbody/tr[4]/td";
          			  public static final String lblDel1="//*[@id='two-column-b']/div[1]/table/tbody/tr[2]/td[1]";
          			public static final String lblDel2="//*[@id='two-column-b']/div[1]/table/tbody/tr[3]/td[1]";
          			public static final String lblDel3="//*[@id='two-column-b']/div[1]/table/tbody/tr[4]/td[1]";
          			
          			public static final String lblCartEmpty = "//*[@id='miniCart']/ul/li/h3";
          			public static final String lblItemAdded = "//*[@id='ui-dialog-title-productAddToCart']";
          			public static final String webelmntMiniCartImg = "//*[@id='miniCart']/ul/li/div[2]/div[1]/a/img";
          			public static final String webelmntMiniCartPrice = "//*[@id='miniCart']/ul/li/div[2]/div[3]/p[1]";
          			/**************BF*****************/
          			public static final String btnCCAdd="ccAddTab";  
          			public static final String btnStoreCard="storeCard";  
          			public static final String btnPrimaryCard="primaryCard";  
          			public static final String btnCreateAddress="Create New Address";
          			public static final String lblSellingRstns="//li[2]/div/label/span";
          			public static final String webElmntSellingRstns = "//*[@id='selling-restriction-dialog']/div";
          			public static final String btnSearchSubmit = "#frmQuickSearch > span.ui-frame > button[type=\"submit\"]";
          			public static final String txtSelectedId="selectedcard_id";
          			public static final String txtSelectedCvv="selectedcard_cvv";
          			public static final String txtSelectedAdd="stored-billing-address-id";
          			
          		/////Added 03/27
          			public static final String lblPricingDetail="//*[@id='pricing']";
          			public static final String lblEstSalesTax2DelMthd="//*[@id='ShopCartForm']/div[5]/div[2]/div[1]/ul/li[4]/div[2]/span";
          			public static final String lblOrderSubtotalChkOutPgs="//*[@id='two-column-b']/div[1]/table/tbody/tr[1]/td[2]";    
          			public static final String lblOrderDel1ChargesChkOutPgs="//*[@id='two-column-b']/div[1]/table/tbody/tr[2]/td[2]";
          			public static final String lblOrderEstTax2DelMthd="//*[@id='two-column-b']/div[1]/table/tbody/tr[4]/td[2]";
          			public static final String lblOrderDel1ChargesRevPay="//*[@id='two-column-b']/div[2]/table/tbody/tr[2]/td[2]";
          			public static final String lblOrderEstTax2DelMthdRevPay="//*[@id='two-column-b']/div[2]/table/tbody/tr[4]/td[2]";
          			public static final String lblPartialOrder="//*[@id='conf-main']/div[1]/ul/li";
          			public static final String lblOrderSubtotalOC="//*[@id='conf-main']/div[3]/div[2]/div[2]/ul/li[1]/div[2]";
          			public static final String lblDelChargesOC="//*[@id='conf-main']/div[3]/div[2]/div[2]/ul/li[2]/div[2]";
          			public static final String lblTax1DelOC="//*[@id='conf-main']/div[3]/div[2]/div[2]/ul/li[3]/div[2]";
          			public static final String lblOrderTotalOC="//*[@id='conf-main']/div[3]/div[2]/div[2]/ul/li[4]/div[2]";
          			public static final String lblPurchaseTotalAmt="//*[@id='order_detail']/div[1]/div[2]/table/tbody/tr[3]/td[2]";
          			public static final String lblPurchaseSubTotalAmt="//*[@id='paymentAmounts']/ul/li[1]/span[2]";
          			public static final String lblDelCharges1Amt="//*[@id='paymentAmounts']/ul/li[2]/span[2]";
          			public static final String lblEstTax1DelAmt="//*[@id='paymentAmounts']/ul/li[3]/span[2]";
          			public static final String lblPurchaseTotalFooter="//*[@id='order_detail']/div[3]/h3[2]/span";
          
}