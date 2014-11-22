package com.lowes.qa.selenium.uimap;

/**
 * UI Map for ProductSearch
 */
public class UIMapProductSearch
{
	/****************Home Page************************/
	//Wbelement
		//xpath
		public static final String webElmntBrdCrumbs="//*[@id='breadcrumbs']/ul/li"	;
		public static final String webElmntBrdCrumbsLvl4="//*[@id='breadcrumbs']/ul/li[4]";
		public static final String webElmntBrdCrumbsLvl5="//*[@id='breadcrumbs']/ul/li[5]";
		public static final String webElmntSearchSugg1="html/body/table/tbody/tr/td[2]/table/tbody/tr[1]/td/div/table/tbody/tr/td/span";
		public static final String webElmntLCI="//*[@id='nav-inspiration']/ul/li[1]/div/div/ul/li[2]/a[1]/img";
		
		//css
		public static final String webElmntSearchSugegstions="css=td > span";
		
	//link
		//xpath
		public static final String lnkUnzip="//*[@id='disable-autozip']";
		public static final String lnkFindAStore="//*[@id='nav-store-find']/span";
		public static final String lnkShop="//*[@id='header-block']/div[3]/ul/li[2]/a/span[1]";
		public static final String lnkIdeas="//*[@id='header-block']/div[3]/ul/li[3]/a/span[1]";
	//textbox
		//id
		public static final String txtStoreZipField="nav-search-input";
		
	
	/****************Product List************************/
	//WebElements
		//xpath
		public static final String webElmntSqFootPrices= "//*[@class='pricing']/strong/span";
		public static final String webElmntNoSearchResultsHeading="//*[@id='one-column']/h1";
		public static final String webElmntThinkWeShouldHvIt="//*[@id='no-results']/h2/span";
		public static final String webElmntTotalResults= "//*[@id='main_content_rail']/div[3]/div[1]/form/span[1]";
		public static final String webElmntProductList2="//*[@id='productResults']/li";
		public static final String webElmntViewAll="//*[@id='main_content_rail']/div[3]/div[1]/form/a";
		public static final String webElmntProductListSort="//*[@id='main_content_rail']/div[3]/div[2]/div[1]/ul/li";
		public static final String webElmntRatingsCount="//*[@id='Rating']/ul/li/div/span";
		public static final String webElmntBreadboxStars="//*[@id='Rating-chosen']/ul/li/img";
		public static final String webElmntRatingStars="//*[@id='Rating']/ul/li/div/a";
		public static final String webElmntLeftRailList2="//*[@id='left_rail_pl']/ul[2]";
		public static final String webElmntLeftRailList1="//*[@id='left_rail_pl']/ul[1]";
		public static final String webElmntLeftRailLinks="//*[@id='left_rail_pl']/ul[2]/li";
		public static final String webElmntLeftRailHeading="//*[@id='left_rail_pl']/h4[1]";
		public static final String webElmntProductListSort2="//*[@class='clearfix']/li";
		public static final String webElmntLeftRailListHeading="//*[@id='left_rail_pl']/h4[1]";
		public static final String webElmntDivLeftRail="//*[@id='left_rail']/div[1]";
		public static final String webElmntListLeftRail="//*[@id='left_rail']/div[1]/ul[1]/li";
		//class
		public static final String webElmntTotalPages="totalPages";
		public static final String webElmntListView= "listView";
		public static final String webElmntGridView= "gridView";
		
		
		//id
		public static final String webElmntProductList="main_content_rail";
		public static final String webElmntRatingLeftRail="Rating";
		public static final String webElmntRatingsBreadbox="Rating-chosen";
		public static final String webElmntLeftRailProductList="left_rail_pl";
		public static final String webElmntLeftRail1="left_rail";
	//drop-down
		//xpath
		public static final String drpDownResultPerPage= "//*[@id='main_content_rail']/div[3]/div[1]/form/select";
	//button
		//xpath
		public static final String btnViewAll="//*[@id='main_content_rail']/div[3]/div[1]/form/a/span";
		public static final String btnCompare="//*[@id='itemBar']/div[1]/a/span";
	//chkBox
		//xpath
		public static final String chkBoxBrand="//*[@id='Brand']/ul/li";
	//link
		public static final String lnkBrdboxRatingRemove="//*[@id='Rating-chosen']/ul/li/a";
		public static final String lnkRatingFacet="//*[@id='Rating']/a";
	/****************Compare Products Page************************/	
	//Label
		//xpath
		public static final String lblComparePgHeading="//*[@id='product-compare-area']/div[3]/h1";
		public static final String lblItemNbr1Cmpr="//*[@id='product-compare-area']/div[3]/div[4]/table/tbody/tr[1]/td";
	//WebElements
		//xpath
		public static final String webElmntItemNbr1Stars="//*[@id='product-compare-area']/div[3]/div[4]/table/tbody/tr[3]/td/span/img";
	/****************Find A Store************************/
	//WebElements
		//xpath	
		public static final String webElmntFindStoreHeading="//*[@id='content-area-no-nav-widest']/h1";
	/****************Product Details Page************************/
	//Web element
		//xpath
		public static final String webElmntProductName = "//*[@id='descCont']/div[1]/h1";
		public static final String webElmntActiveStore = "//*[@id='lowes-store-active']/span[2]/span[2]";
		public static final String webElmntStorePickUpAvailMsg="//*[@id='delivery']/li[1]/div";
		public static final String webElmntStoreLTDAvailMsg="//*[@id='delivery']/li[2]/div";
		public static final String webElmntStoreParcelAvailMsg="//*[@id='delivery']/li[3]/div";
		public static final String webElmntChooseStorepopup= "html/body/div[21]/div[2]";
		public static final String webElmntReviewHelpSuccessMsg="//*[@id='BVSubmissionPopupContainer']/div[5]/div[2]/div[3]/div/div/div";
		public static final String webElmntChooseStorepopupHeading="html/body/div[21]/div[2]/div[1]/h3";
		public static final String webElmntEnergyStarImg="//*[@id='imgCont']/div[2]/span";
		public static final String webElmntThumbsUpCount="//*[@id='BVSubmissionPopupContainer']/div[5]/div[2]/div[1]/div[3]/span[2]/a/span/span[2]";
		public static final String webElmntThumbsDownCount="//*[@id='BVSubmissionPopupContainer']/div[5]/div[2]/div[1]/div[3]/span[3]/a/span/span[2]";
		public static final String webElmntRelatedItemCount="//*[@id='relatedItems']/div";
		public static final String webElmntAlsoViewedCount="//*[@id='alsoViewedBlock']/div/div/ul/li";
		public static final String webElmntAlsoViewedCount2="//*[@id='alsoViewedBlock']/div/div/div[2]/ul/li";
		public static final String webElmntBuyPairCount="//*[@id='buyPair']/div";
		public static final String webElmntMAPPriceDesc="//*[@id='pricing']/div[@class='priceDescriptors']";
		public static final String webElmntContextualHelp="//*[@id='pricing']/a[@class='contextHelp context_clicked']/img";
		//public static final String webElmntContextualHelpClose="//span[@class='ui-icon ui-icon-closethick']";
		public static final String webElmntContextualHelpClose="html/body/div[21]/div[1]/a/span";
		//id
		public static final String webElmntProductDetail = "descCont";
		public static final String webElmntItemNbr="ItemNumber";
		public static final String webElmntQuesPresent="BVQAQuestionsID0";
		public static final String webElmntNoQuestion="BVQANoQuestionsID";
		public static final String webElmntQues1Container="//*[@id='BVQAQuestionsID0']/div[2]";
		public static final String webElmntContextualHelpPopup="suggestedPrice_help";
		
	//link
		//xpath
		public static final String lnkChangeStore= "//*[@id='delivery']/li[1]/div/label/p[2]/a";
		public static final String lnkChangeStoreCart="//*[@id='vfileSelectedBanner']/div/a";
		public static final String lnkThumbsUp="//*[@id='BVSubmissionPopupContainer']/div[5]/div[2]/div[1]/div[3]/span[2]/a";
		public static final String lnkThumbsDown="//*[@id='BVSubmissionPopupContainer']/div[5]/div[2]/div[1]/div[3]/span[3]/a";
		//id
		public static final String lnkCancelChooseStorePopup="cancelModal";
		
	//button
		//xpath
		public static final String btnAddToCart="//li[2]/div/a/span";
		public static final String btnCkeckOut="//div[3]/div/button[2]";
		public static final String btnAskAQuestion="//*[@id='BVQAAskQuestionTopID']/a/img";
		public static final String btnAskAQuestionNoQues="//*[@id='BVQANoQuestionsID']/a/img";
	//label
		//xpath
		public static final String lblLTDFreeTxt="//*[@id='delivery']/li[2]/div/p";
		public static final String lblViewPriceInCart="//*[@id='pricing']/strong";
		public static final String lblUnitPrice="//*[@id='pricing']/span";
		//id
		public static final String lblSubTotal="subtotal-value";
	//dropdown
		//name
		public static final String drpDownQty="quantity";
	
		
	/****************Shopping Cart Page************************/	
	//Web element
		//xpath	
		public static final String webElmntAddToCartPopup="ui-dialog-title-productAddToCart";
		//css
		
		public static final String webElmntChooseStoreAvailNow="th.quantity";
		public static final String webElmntChooseStoreAvailFuture="th.future";
		
	//chkBox
		//id
		public static final String chkBoxChooseStoreFutureAvail="showFuture";
	//label
		//xpath
		public static final String lblFreeLTD="//li[@class='truck-delivery']/div[2]/span";
		public static final String lblPromoTxt="//span[@class='promo-text']";
	//button
		//xpath
		public static final String btnGuestChkOut="//div[@id='login-container']/div/div/div[2]/div/a/span";
		public static final String btnContinueChkOut="//*[@id='revpay_com_order']/span";
	/****************Answer A Question Page************************/
	//text box
		//id
		public static final String txtAnswerId="BVQAFieldTextAreaAnswerTextID";
		public static final String txtAnsNickNameId="BVQAFieldTextAnswerUsernicknameID";
		public static final String txtAnsLocation="BVQAFieldTextAnswerUserlocationID";
		public static final String txtAnsEmailID="BVQAFieldTextAnswerUseremailID";
	//drop-down	
		//id
		public static final String drpDownAnsGender="BVQAFieldSelectAnswerContextualDataFieldGenderID";
		public static final String drpDownAnsAge="BVQAFieldSelectAnswerContextualDataFieldAgeID";
	//chk-box
		//id
		public static final String chkBoxAnsEmailAlerts="BVQAFieldCheckboxAnswerUseremailalertsID";
	//button
		//id
		public static final String btnAnsPreview="BVQAPreviewAnswerButtonID";
		public static final String btnAnsSubmit="BVQASubmitAnswerButtonID";
	//web element
		//xpath
		public static final String webElmntAnsSuccess="//*[@id='BVSUSocialAnsweringFormID']/div/div[1]/div/div[1]/div";
	/****************Ask A Question Page************************/
	//web element
		//xpath
		public static final String webElmntAskQuesPage="//*[@id='BVQAEditQuestionContentID']/form/div[2]/div[1]/strong";
	//textbox
		//id
		public static final String txtQuestionSummary="BVQAFieldTextQuestionSummaryID";
		public static final String txtQuesDetails="BVQAFieldTextAreaQuestionDetailsID";
		public static final String txtQuesLocation="BVQAFieldTextQuestionUserlocationID";
		public static final String txtQuesUserEmail="BVQAFieldTextQuestionUseremailID";
	//drop down
		//id
		public static final String drpDownQuesGender="BVQAFieldSelectQuestionContextualDataFieldGenderID";
		public static final String drpDownQuesAge="BVQAFieldSelectQuestionContextualDataFieldAgeID";
	//checkbox
		//id
		public static final String chkBoxQuesEmailAlert="BVQAFieldCheckboxQuestionUseremailalertsID";
		public static final String chkBoxQuesEmailAlert2="BVQAFieldCheckboxQuestionSendemailonanswerID";
	//button
		//id
		public static final String btnQuesPreview="BVQAPreviewQuestionButtonID";
		public static final String btnQuesSubmit="BVQASubmitQuestionButtonID";
	//label
		public static final String lblQuesSubmittedTitle="BVQAQuestionSubmittedFormTitleID";
		
	/****************Ideas and How To's Category/Category result Page************************/	
	////web element
		//xpath
		public static final String webElmntHomeAreaList="//*[@id='left_rail_lci']/ul/li[1]/ul/li";
		public static final String webElmntSeeMoreFromList="//*[@id='left_rail_lci']/ul/li[7]/ul/li";
		public static final String webElmntHomeAreaListLink1="//*[@id='left_rail_lci']/ul/li[1]/ul/li[1]";	
		public static final String webElmntHomeAreaListLink2="//*[@id='left_rail_lci']/ul/li[1]/ul/li[2]";
		public static final String webElmntFilterBreadBox="//*[@id='left_rail_lci']/div";
		public static final String webElmntFilterBreadBoxHA="//*[@id='HomeAreas-chosen']/ul/li";
		public static final String webElmntFilterBreadBoxThemes="//*[@id='Themes-chosen']/ul/li";
		public static final String webElmntFilterBreadBoxSeeMore="//*[@id='SeeMoreFrom-chosen']/ul/li";
		public static final String webElmntHomeAreaHeading="//*[@id='cms']/div/div[1]/h1/span";
		public static final String webElmntLeftRailList="//*[@id='left_rail_lci']/ul/li";
		public static final String webElmntRefine1="//*[@id='left_rail_lci']/ul/li[1]/a";
		public static final String webElmntRefine2="//*[@id='left_rail_lci']/ul/li[2]/a";
		public static final String webElmntRefine3="//*[@id='left_rail_lci']/ul/li[3]/a";
		public static final String webElmntRefine4="//*[@id='left_rail_lci']/ul/li[4]/a";
		public static final String webElmntRefine5="//*[@id='left_rail_lci']/ul/li[5]/a";
		public static final String webElmntRefine6="//*[@id='left_rail_lci']/ul/li[6]/a";
		public static final String webElmntRefine7="//*[@id='left_rail_lci']/ul/li[7]/a";
		public static final String webElmntRefineCount="//*[@id='left_rail_lci']/ul/li";
		public static final String webElmntIdeasHeading="//*[@id='cms']/div/div[1]/h1/span";
		public static final String webElmntTotalResult="//*[@id='cms']/div/div[2]/div[1]/form/span[1]";
		
		//id
		public static final String webElmntLeftRail="left_rail_lci";
		public static final String webElmntHouzzGalleryPage="houzzHeader";
	//chkBox
		//id
		public static final String chkBoxLowesCreativeIdeas="_Lowe's Creative Ideas";
	/****************Community Stories Page************************/
	//web element
		//id
		public static final String webElmntCSHero="hero";
		public static final String webElmntCSPage="community_stories";
		public static final String webElmntCatSection="related_categories";
		
		//xpath
		public static final String webElmntCSHeroSection="//*[@id='hero']/div[1]";
		public static final String webElmntCSStory1="//*[@id='BVSYStoriesGrid']/div[1]";
	//link
		//xpath
		public static final String lnkCSViewAll1="//*[@id='community_stories']/div/div[1]/a/img";
		public static final String lnkCSCategories="//*[@id='related_categories']/ul/li";
	//button
		//id
		public static final String btnShareStory="share_your_story";
	/****************Community Stories Category Page************************/
	//webelement
		//xpath
		public static final String webElmntCSCatHeading="//*[@id='LCIBVCat']/h2";
		public static final String webElmntCSCatFilter="//*[@class='BVDI_QTFilterList BVDI_QTFilterListCheckboxes']/li";
		public static final String webElmntCSCatResultTitles="//*[@class='BVSYStoriesTitleLink']";
		
	/****************Community Stories Story Page************************/	
	//webelement
		//xpath
		public static final String webElmntCSStoryContent="//*[@class='BVSYStoryContentTextContainer']/div/span";	
		public static final String webElmntCSStoryComment="//*[@class='BVDIHeader BVDI_COHeader']/a[1]";
	/****************Community Stories Post Your Comment Page************************/		
	//webelement
		//xpath
		public static final String webElmntCommentShortDesc="//*[@id='BVSectionParentContentID']/div[2]";
	//txt
		//id
		public static final String txtStoryComment="BVFieldCommenttextID";
		public static final String txtCommentNickname="BVFieldUsernicknameID";
		public static final String txtCommentNickname2="BVModuleNicknameID";
		public static final String txtCommentUserEmail="BVFieldUseremailID";
	//chk box
		//id
		public static final String chkBoxCommentEmail="BVFieldUseremailalertsID";
		public static final String chkBoxCommentTC="BVFieldAgreedtotermsandconditionsID";
	//button
		//xpath
		public static final String btnCommentSubmit="//*[@id='BVButtonSubmitID']/button";
		public static final String btnCommentCancel="//*[@id='BVButtonCancelID']/button";
	//link
		//xpath
		public static final String lnkTC="//*[@id='BVModuleFooterLinksID']/a[1]";
		public static final String lnkCommentGuidelines="//*[@id='BVModuleFooterLinksID']/a[2]";
	/****************Share Your Story Page************************/	
	//web element
		//id
		public static final String webElmntStoryForm="storyForm";
		public static final String webElmntPreviewPhoto="BVSYStoryPhotoHeroPreviewID";
		
		
		//xpath
		public static final String webElmntSharePhotos="//*[@id='BVSectionMediaUploadID']/div[1]/span";
		public static final String webElmntYourInfo="//*[@id='BVSectionBasicInformationID']/div[1]/span";
		public static final String webElmntStoryPageHeading="//*[@id='BVMessagePageHeaderID']";
		public static final String webElmntPreviewStoryTitle="//*[@id='BVSYDisplayContentStoryID_preview']/div[3]/div/div[1]/span[2]";
		public static final String webElmntPreviewDate="//*[@id='BVSYDisplayContentStoryID_preview']/div[3]/div/div[2]/span[2]";
		public static final String webElmntPreviewLabelBy="//*[@id='BVSYDisplayContentStoryID_preview']/div[3]/div/div[3]/div[1]/span[2]";
		public static final String webElmntPreviewLabelFrom="//*[@id='BVSYDisplayContentStoryID_preview']/div[3]/div/div[3]/div[2]/span[1]";
		public static final String webElmntPreviewLabelCat="//*[@id='BVSYDisplayContentStoryID_preview']/div[3]/div/div[3]/div[3]/div/span[1]";
		public static final String webElmntPreviewNick="//*[@id='BVSYDisplayContentStoryID_preview']/div[3]/div/div[3]/div[1]/span[3]/span";
		public static final String webElmntPreviewLocation="//*[@id='BVSYDisplayContentStoryID_preview']/div[3]/div/div[3]/div[2]/span[2]";
		public static final String webElmntPreviewCat="//*[@id='BVSYDisplayContentStoryID_preview']/div[3]/div/div[3]/div[3]/div/span[2]";
		public static final String webElmntPreviewStory="//*[@id='BVSYDisplayContentStoryID_preview']/div[3]/div/div[4]/div/span";
		public static final String webElmntPreviewCaption="//*[@id='BVSYStoryPhotoHeroCaptionPreviewTextID']/span";
		public static final String webElmntStoryNickname2="//*[@id='BVModuleNicknameID']/div[2]";
		
		//class
		public static final String webElmntPhotoUploadFrame="BVInlinePhotoUploadFrame";
		
		
	//dropdown
		//name
		public static final String drpDownStoryCategory="bvcategoryid";
		public static final String drpDownStoryHomeDecCat="BVFieldContextdatavalueCategoryHomeDecoratingAndBuildingProjectsID";
		
	//textbox
		//id
		public static final String txtStoryTitle="BVFieldTitleID";
		public static final String txtStory="BVFieldStorytextID";
		public static final String txtStoryEmail="BVFieldUseremailID";
		public static final String txtStoryNickname="BVFieldUsernicknameID";
		
		public static final String txtStoryLocation="BVFieldUserlocationID";
		public static final String txtStoryPhotoCaption="BVFieldInputPhotoUploadCaptionID_1";
		
	//button
		//id
		public static final String btnBrowse="BVVisiblePhotoUploadInputID";
		public static final String btnUpload="BVVisiblePhotoUploadSubmitID";
		public static final String btnStoryPreview="//*[@id='BVButtonPreviewID']/button";
		public static final String btnStoryCancel="//*[@id='BVButtonCancelID']/button";
		public static final String btnSubmit="//*[@id='BVButtonSubmitID']/button";
		public static final String btnEdit="//*[@id='BVButtonEditID']/button";
		//xpath
		//public static final String btnBrowse="html/body/div/form/input[@id='BVVisiblePhotoUploadInputID']";
		//public static final String btnUpload="html/body/div/form/input[@id='BVVisiblePhotoUploadSubmitID']";
		
	//chkBox
		//id
		public static final String chkBoxStoryEmailAlert="BVFieldUseremailalertsID";
		public static final String chkBoxStoryEmailAlert2="BVFieldSendemailoncommentID";
		public static final String chkBoxStoryTC="BVFieldAgreedtotermsandconditionsID";
	//link
		//xpath
		public static final String lnkReturn="//*[@id='BVSubmissionContainer']/div/div[3]/a";

	/****************LCI Landing Page************************/	
	//webelement
		//xpath
		public static final String webElmntLCIPgDiv="//*[@id='page-block']/div/div";
	/****************Review & Pay Page************************/
	//drop-down
		//id
		public static final String drpDownCardType="checkout-card-type";
	//textbox
		//name
		public static final String txtCardNbr="cardNumber";
		//id
		public static final String txtCardSecurityCode="s-code";
	//radio button
		//id
		public static final String rdoBtnLCCOffer="financing-options";
		
	/****************Review & Pay Page************************/	
////////////////Sivani
		
		/*********Product Search*******************/
		
		//text
		//xpath
		
		public static final String txtAddProductTitle = "//*[@id='ui-dialog-title-productAddToCart']";
		public static final String txtMapDisplay = "//*[@id='SL-map-list']/div/div/h2";
		public static final String txtStoreDisplay = "//*[@id='lowes-store-active']/span[2]/span[2]";
		public static final String txtLumberData1 = "(//input[@type='text'])[6]";
		public static final String txtLumberData2 = "(//input[@type='text'])[7]";
		
		public static final String txtWrntyMsg1 = "//*[@id='warranty']/li[1]";
		public static final String txtWrntyMsg2 = "//*[@id='warranty']/li[2]";
		public static final String txtIdeasAndHowTos = "//*[@id='header-block']/div[3]/ul/li[3]/a/span[1]";
		public static final String txtInspiration = "//*[@id='nav-inspiration']/ul/li[1]/a";
		public static final String txtHouzzHeader = "//*[@id='houzzHeader']/h2";
		public static final String txtHeaderLocator = "//*[@id='HeaderLocator']";
		public static final String txtRefImg = "//*[@id='item_4484174']/div/div[3]/p[1]/strong";
		public static final String txtPricing1 = "//*[@id='pricing']/strong";
		public static final String txtPricing2 = "//*[@id='pricing']/a";
		public static final String txtPricing3 = "//*[@id='pricing']/div/p[1]";
		public static final String txtPricing4 = "//*[@id='pricing']/div/p[2]";
		public static final String txtPricing5 = "//*[@id='pricing']/div[2]/p[2]";
		public static final String txtChooseAPrj = "(//a[contains(text(),'Choose a Project')])[2]";
		public static final String txtHowTos = "//*[@id='lci-landing-content']/div[2]/h2";
		public static final String txtBuyingGuideLines = "//*[@id='lci-landing-content']/div[3]/h2";
		public static final String txtVideos = "//*[@id='lci-landing-content']/div[4]/h2";
		public static final String txtCalcs = "//*[@id='lci-landing-content']/div[5]/h2";
		public static final String txtHowToLib = "//*[@id='cms']/div/div[1]";
		public static final String txtselectedFilters = "*[@id='left_rail_lci']/div/ul";
		public static final String txtYourStore = "//*[@id='lowes-store-active']/span[2]/span[1]";
		public static final String txtStoreInfo = "//*[@id='nav-store-info']/span[1]";
		public static final String txtFindAStore = "//*[@id='nav-store-find']/span";
		public static final String txtHeaderMapDefault = "//*[@id='Header-map-default']/span";
		public static final String txtHeaderSearchSubmit = "//*[@id='Header-map-search-submit']";
		public static final String txtYourStoreHeading = "//*[@id='Header-store-listing-0595']/strong[1]";
		
		
		public static final String txtPrdCmpArea = "//*[@id='product-compare-area']/div[3]/h1";
		
		public static final String txtItemRTF = "//*[@id='productAddToCart']/div[2]/ul/li/h2";
		public static final String txtYouHvChsn = "//*[@id='left_rail_lci']/div/div/strong";
		public static final String txtYouHvChsnFrmSearch = "//*[@id='left_rail_pl']/div[1]/ul";
		
		public static final String txtContextualHelpImg = "[@id='pricing']/a/img";
		
		//id
		public static final String txtMapSearch = "SL-map-search";
		public static final String txtGiftCardTo = "gcTo_i";
		public static final String txtGiftCardFrom = "gcFrom_i";
		public static final String txtGiftCardMsg = "gift-msg-txtarea";
		public static final String txtRefridgerators = "refridgerators";
		
		//webelements
		//xpath
		public static final String webElmntPrsntAddToCartPopUp1 = "//*[@id='productAddToCart']/div/h2";
		public static final String webElmntPrsntAddToCartPopUp2 = "//*[@id='productAddToCart']/div/div[1]";
		public static final String webElmntPrsntAddToCartPopUp3 = "//*[@id='productAddToCart']/div/div[2]";
		public static final String webElmntPrsntAddToCartPopUp4 = "(//button[@type='button'])[4]";
		public static final String webElmntPrsntAddToCartPopUp5 = "(//button[@type='button'])[3]";
		public static final String webElmntPrsntWrntyMsg = "//*[@id='productAddToCart']/div/div[3]";
		
		
		public static final String webElmntPrsntFeaturedbannerCluster1 ="//*[@id='lci-landing-content']/div[5]/div[1]";
		public static final String webElmntPrsntFeaturedbannerCluster2 = "//*[@id='lci-landing-content']/div[5]/div[2]";
		public static final String webElmntPrsntFeaturedbannerCluster3 = "//*[@id='lci-landing-content']/div[6]/div";
		public static final String webElmntPrsntFeaturedbannerCluster4 = "//*[@id='lci-landing-content']/div[5]/div[1]/a/img";
		public static final String webElmntPrsntFeaturedbannerCluster5 = "//*[@id='lci-landing-content']/div[5]/div[1]/div/h3";
		public static final String webElmntPrsntFeaturedbannerCluster6 = "//*[@id='lci-landing-content']/div[5]/div[1]/div/p";
		
		public static final String webElmntPrsntStoreInfoPopUp1= "//*[@id='store-info-block']";
		public static final String webElmntPrsntStoreInfoPopUp2= "//*[@id='store-info-content']/p";
		public static final String webElmntPrsntStoreInfoPopUp3= "//*[@id='store-info-links']/li[1]";
		public static final String webElmntPrsntStoreInfoPopUp4= "//*[@id='store-info-links']/li[2]/a";
		
		public static final String webElmntPrsntPrdAddToCart1 = "//*[@id='productAddToCart']/div/h2";
		public static final String webElmntPrsntPrdAddToCart2 = "//*[@id='productAddToCart']/div/div[1]";
		public static final String webElmntPrsntPrdAddToCart3 = "//*[@id='productAddToCart']/div/div[2]";
		public static final String webElmntPrsntPrdAddToCart4 = "(//button[@type='button'])[4]";
		public static final String webElmntPrsntPrdAddToCart5 = "(//button[@type='button'])[3]";
		
		public static final String webElmntPresentDidYouKnow = "//*[@id='productAddToCart']/div[2]/h3";
		public static final String webElmntPresentItemAddedToCart = "Item Added to Cart";
		
		//links
		//xpath
		public static final String lnkClseAddToCartPopUp = "//div[17]/div/a/span";
		
		//css
		public static final String lnkLumber = "a[title=\"Lumber\"]";
		public static final String lnkAttic = "a[title=\"Attic\"]";
		public static final String lnkApplicances ="a[name=\"MASTHEAD_Appliances_Buckets_Refrigerators\"] > span.bucket-title";
		public static final String lnkFrnDoorRefrg =	"img[alt=\"French Door Refrigerators\"]";
		public static final String lnkHelpIcon = "img[alt=\"Help Icon\"]";
		public static final String lnkSavingMsg = "p.savingsMsg";
		public static final String lnkCmpMapItem1 = "//li/div/ul/li[2]/a/span";
		public static final String lnkCmpMapItem2 = "//div[3]/a/h3";
		public static final String lnkCmpMapItem = "//li/div/div/div/input";
		public static final String lnkCmpMapItemInput = "//li[2]/div/div/div/input";
		public static final String lnkMapItemBar = "//*[@id='itemBar']/div[1]/a";
		public static final String lnkBabyRoom = "a[title=\"Baby Room\"]";
		public static final String lnkBasement = "label[title=\"Basement\"]";
		public static final String lnkCabinetPulls = "a[title=\"Related Categories:Cabinet Pulls\"] > span";
		public static final String lnkShowHideDetails = "a.more-store-info.nav-link > span";
		public static final String lnkGetDirections = "li.togglable > a.learn-more";
		
		//id
		public static final String lnkPrice1To5 = "Price_$1---$5";
		public static final String lnkPrice5To10 = "Price_$5---$10";
		public static final String lnkStyleContmp = "Style_Contemporary";
		public static final String lnkStyleTrnstnl = "Style_Transitional";
		
		
		//buttons
		//xpath
		public static final String btnCheckkOut = "//div[3]/div/button[2]";
		public static final String btnCheckkOutRTF = "//li/div[2]/div[2]/button";
		//css
		public static final String btnLearnMore = "li.lci-bucket > a.learn-more";
		public static final String btnGreen = "button.button.button-green";
		public static final String btnIconToMyCart = "span.nav-icon.my-cart";
		public static final String btnStoreInfoSpan = "#nav-store-info > span";
		public static final String btnClose = "a.close > span";
		public static final String btnHeaderClose = "#Header-map-results > a.close > span";
		public static final String btnAddSpan = "a.button.add > span";
		public static final String btnChangeStoreInfo = "#nav-store-change > span";
		
		
		//id
		public static final String btnAddAllToCart = "addAllToCart";
		public static final String btnHeaderMapSearch = "Header-map-search-submit";
		
		
		
		
		//linktext
		
		public static final String lnkBldngSupp = "Building Supplies";
		public static final String lnkBuildAndRemodal = "Build & Remodel";
		public static final String lnkNext = "Next";
		public static final String lnkPrevious = "Previous";
		public static final String lnkGridView = "Grid View";
		public static final String lnkIdeasAndHowTos = "Ideas & How-Tos (2)";
		public static final String lnkRemove = "Remove";
		public static final String lnkBuiltInRfdge = "Built-In Refrigerators";
		public static final String lnkSlctCountry = "Wyoming, USA";
		public static final String lnkViewOnMap = "View on Map";
		public static final String lnkFindMoreStores = "Find More Stores";
		public static final String lnkBuyThePairItem = "Maytag Centennial 3.4 cu ft Top-Load Washer...";
		
		
		//dropdown
		//id
		public static final String drpDownGridSelect = "gridSelect";
		
		//radiobutton
		
		//css
		
		public static final String rdoBtnWrnty = "div.inputField > input[name=\"catEntryId_2\"]";
		//textbox
		//id
		public static final String txtStoreSearch = "Header-map-search";
		
		//kish
		public static final String buyThePair = "//*[@id='buyPair']";
		public static final String lblBuyThePair = "//*[@id='buyPair']/h2";
		public static final String imgBuyThePairItem = "//*[@id='buyPair']/div/a/img";
		public static final String titleBuyThePairItem = "//*[@id='buyPair']/div/p/a";
		public static final String frameRelatedItems = "//*[@id='relatedItems']";
		public static final String lblRelatedItems = "//*[@id='relatedItems']/h2";
		public static final String imgRelatedItem = "//*[@id='relatedItem1']/a/img";
		public static final String titleRelatedItem = "//*[@id='relatedItem1']/p/a";
		public static final String txtQtyInPD = "//ul[4]/li[2]/div/input[3]";
		public static final String lnkWashersDryers = "//li/div/ul/li/a/span";
		public static final String featureBanner1 = "//*[@id='lci-landing-content']/div[5]";
		public static final String featureBanner2 = "//*[@id='lci-landing-content']/div[6]";
		//Ankita 11th March
		/**Product details page**/
		//link
		//xpath
		public static final String lnkCommentOnReview="//*[@id='BVRRDisplayContentBodyID']/div/div[3]/div/div/a[2]/span";
		public static final String lnkNbrOfReviews="//*[@id='BVRRRatingSummaryLinkReadID']/a/span";
		public static final String lnkWriteAReview="//*[@id='BVRRRatingSummaryLinkWriteID']/a";
		//button
		//xpath
		public static final String btnWriteAReview="//span/div/a";
		//web element
		//xpath
		public static final String webElmntProductDetails="//*[@id='detailCont']";
		/***Submit a comment page***/
		//text
		//id
		public static final String txtCommentTitle="BVSUFieldTextCommentTitleID";
		public static final String txtComment="BVSUFieldTextAreaCommentTextID";
		public static final String txtCommentNickName="BVSUFieldTextCommentUserNicknameID";
		public static final String txtCommentLocation="BVSUFieldTextCommentUserLocationID";
		//checkbox
		//id
		public static final String chkBoxCommentEmailAlert="BVSUFieldCheckboxCommentEmailAlertID";
		//button
		//id
		public static final String btnCommentSubmit2="BVSUSubmitCommentButtonID";
		public static final String btnCommentPreview="BVSUPreviewCommentButtonID";
		
		/***Sumit Review Page***/
		//WebElmt
				//id
		public static final String webElmntStarRating4="star_link_rating_4";
		public static final String webElmntFeatureRating4="star_link_rating_Features_4";
		public static final String webElmntValueRt4="star_link_rating_Value_4";
		public static final String webElmntDesignRt4="star_link_rating_Design_4";
		public static final String webElmntQualityRt4="star_link_rating_Quality_4";
		public static final String webElmntEaseOfUseRt4="star_link_rating_Ease_4";
		//radio button
		//id
		public static final String rdoBtnRecommendToFrndYes="BVRRRecommendToFriendYesID";
		//text
		public static final String txtReviewTitle="BVRRFieldTextReviewTitleID";
		public static final String txtReviewTDesc="BVRRFieldTextAreaReviewTextID";
		public static final String txtReviewNickName="BVRRFieldTextReviewUsernicknameID";
		public static final String txtReviewLocation="BVRRFieldTextReviewUserlocationID";
		public static final String txtReviewEmail="BVRRFieldTextReviewUseremailID";
		//checkBox
		public static final String chkBoxPro1="BVRRProCheckbox1ID";
		public static final String chkBoxCon2="BVRRConCheckbox2ID";
		public static final String chkBoxEmailAlert1="BVRRFieldCheckboxReviewUseremailalertsID";
		public static final String chkBoxEmailAlert2="BVRRFieldCheckboxReviewUseremailalertsWhenCommentedID";
		//dropdown
		//id
		public static final String drpDownReviewGender="BVRRFieldSelectReviewContextualDataFieldGenderID";
		public static final String drpDownReviewAge="BVRRFieldSelectReviewContextualDataFieldAgeID";
		public static final String drpDownReviewPuchaseDate="BVRRFieldSelectReviewContextualDataFieldTimeOfPurchaseID";
		public static final String drpDownReviewPrchasePlace="BVRRFieldSelectReviewContextualDataFieldPlaceOfPurchaseID";
		public static final String drpDownReviewExpertise="BVRRFieldSelectReviewContextualDataFieldExpertiseID";
		//button
		//id
		public static final String btnReviewPreview="BVRRPreviewReviewButtonID";
		public static final String btnReviewSubmit="BVRRSubmitReviewButtonID";
		//label
		//xpath
		public static final String lblStoredNickName="//*[@id='BVRRFieldContainerReviewID']/span";
		/***MyLowes page***/
		//webelement
		//xpath
		public static final String webElmntNeedHelpPopup="//*[@id='contact-dialog']";
		
		//label
		public static final String lblCallUs="//*[@id='callUs']/div[2]/h3";
		public static final String lblCallUsPhn="//*[@id='callUs']/div[2]/p";
		public static final String lblTellUs="//*[@id='emailUs']/div/p";
		public static final String lblFAQs="//*[@id='browseFaq']/div/p";
		//link
		public static final String lnkEmailUs="//*[@id='emailUs']/div/a/h3";
		public static final String lnkFindAnswers="//*[@id='browseFaq']/div/a/h3";
		public static final String lnkNeedHelpClose="//div[12]/div[1]/a/span";
		/***Product List***/
		//web element
		//xpath
		public static final String webElmntQuickViewQtyInStoreOnly="//*[@id='descCont']/div[6]/p";
		public static final String webElmntQuickViewGetDetailsInStore="//*[@id='descCont']/div[6]/a/span";
		public static final String webElmntQuickViewInStore="//*[@id='descCont']/div[6]/a[1]";
		public static final String webElmntMultiplesInQty="//*[@id='subTotal']/li[2]/div/select/option";
		//label
		//xpath
		public static final String lblCmpreSqFootPrice1="//*[@id='product-compare-area']/div[3]/div[4]/table/tbody/tr[4]/td";
		public static final String lblCmpreSqFootPrice2="//*[@id='product-compare-area']/div[3]/div[5]/table/tbody/tr[4]/td";
		
		//kish
		//xpath
		public static final String myStoreModule = "//*[@id='priceAvailability']";
		public static final String filterBox = "//*[@id='left_rail_pl']/div[1]";
		public static final String lnkClearAll = "//*[@id='clear_all']";
		public static final String lblnumberOfResults = "//div/form/span[1]";
		public static final String lblRatingsCount = "//*[@id='Rating']/ul/li/div/span";
		public static final String lnkIdeasHowTos = "//*[@id='left_rail_pl']/ul[1]/li[2]/a";
		public static final String youHaveChoosen = "//*[@id='left_rail_lci']/div";
		public static final String lnkCurrentPage = "//span[3]/div/span[1]";
		public static final String autozip = "//*[@id='confirm-store']";
		
///////////////Added 13th March
		/***Product list**/
		//text
		//	id
			public static final String txtQtyQV="quantity";
			//link
		//xpath
		public static final String lnkItem1QuickView="//*[@id='productResults']/li[1]/div/div[1]/a[2]";
		public static final String lnkItem1CompareArea="//*[@id='productResults']/li[1]/div/div[1]/div";
		public static final String lnkItem1Compare="//*[@id='productResults']/li[1]/div/div[1]/div/input";
		public static final String lnkItem2Compare="//*[@id='productResults']/li[2]/div/div[1]/div/input";
		//button
		//xpath
		public static final String btnCompare2="//*[@id='itemBar']/div[1]/a";
		public static final String btnQVAddToCrt="//*[@id='descCont']/div[6]/a/span";
		public static final String btnContinueShopping="//div[3]/div/button[1]";
		//label
		public static final String lblWasPriceQuickView="//*[@id='pricing']/span[2]";
		public static final String lblsavingsQuickView="//*[@id='pricing']/p[1]/span";
		public static final String lblPurchasePrcQuickView="//*[@id='pricing']/p[2]/span";
		public static final String lblPurchasePrcQuickViewNonWas="//*[@id='pricing']/p/span";
		public static final String lblMiniCartItemPrice="//*[@id='miniCart']/ul/li/div[2]/div[3]/p[1]";
		public static final String lblMiniCartItemQty="//*[@id='miniCart']/ul/li/div[2]/div[3]/p[2]";
		public static final String lblYourStore="//*[@id='confirm-store']/div[2]/h3";
		public static final String lblStoreInfoName="//*[@id='store-info-content']/p";
		public static final String lblStoreInfoAdd1="//*[@id='store-info-content']/ul[1]/li[1]";
		public static final String lblStoreInfoAdd2="//*[@id='store-info-content']/ul[1]/li[2]";
		public static final String lblStoreInfoPhn="//*[@id='store-info-content']/ul[1]/li[3]";
		public static final String lblStoreInfoHrs="//*[@id='store-info-content']/ul[1]/li[4]";
		//webelement
		//xpath
		public static final String btnAddToCartAll="//*[@id='productResults']/li/div/div[3]/form/div/button";
		public static final String btnOutOfStockAll="//*[@id='productResults']/li/div/div[3]/div[3]/p/span";
		public static final String webElmntQuickViewPricing="//*[@id='descCont']/div[3]";
		public static final String webElmntMiniCartItemImg="//*[@id='miniCart']/ul/li/div[2]/div[1]/a/img";
		//id
		public static final String webElmntQuickView="qv";
		public static final String webElmntStoreInfoContent="store-info-content";
		//link
		public static final String lnkMiniCartItemName="//*[@id='miniCart']/ul/li/div[2]/div[2]/h3/a";
		public static final String lnkChangeStoreList="//*[@id='confirm-store']/div[2]/a";
		public static final String lnkMakeThisYourStoreAll="//*[@id='Header-map-list']/div/div/ol/li/ul/li[2]/a";
		public static final String lnkStoreInfoConfrmStore="//*[@id='confirm-store']/div[2]/div/a";
		//text
		public static final String txtChngStoreSearch="//*[@id='Header-map-search']";
		//css
		//public static final String lnkNeedHelpClose2="#contact-control-close > span.ui-icon.ui-icon-closethick";
		//public static final String lnkNeedHelpClose3=
		/**compare assistant**/
		//label
		//xpath
		public static final String lblItem1QtyReqd="//*[@id='product-compare-area']/div[3]/div[4]/table/tbody/tr[5]/td";
		public static final String lblItem2QtyReqd="//*[@id='product-compare-area']/div[3]/div[5]/table/tbody/tr[5]/td";
		//button
		//xpath
		public static final String btnCompareAddToCart1="//*[@id='header_container']/div[2]/div/table/tbody/tr[4]/td/a/span";
		/**Details**/
		public static final String lblStoreRestrictionMsg="//*[@id='posRestrictedAlertsWrapper']/ul/li";
		//txt
		//xpath
		public static final String QtyDetails="//ul/li[2]/div/input[3]";
		public static final String lnkChangeStore2="//*[@id='nav-store-change']/span[1]";
		public static final String lciLeftRail = "//*[@id='left_rail_lci']";
		public static final String webElmntTopActionBar = "//*[@id='cms']/div/div[2]/div[1]";
		//added 19th March
		public static final String lnkMAPContextualHelpAll="//*[@id='productResults']/li/div/div[3]/p[1]/a";
		
		public static final String webElmntZipLayerInList = "//li[1]/div/div[3]/div";
		//added 26th March
		public static final String webElmntChangeStorePopup="HeaderLocator";
		public static final String lnkChangeStoreClose="//*[@id='Header-map-results']/a/span";
		public static final String lblYourStoreInPopup="//*[@id='Header-map-list']/div/div/ol/li[1]/strong[1]";
		public static final String lblActiveStoreNameinPopup="//*[@id='Header-map-list']/div/div/ol/li[1]/strong[2]";
		public static final String lnkCurrentStoreShowHideDetails="//*[@id='Header-map-list']/div/div/ol/li[1]/a/span[1]";
		public static final String lnkFindMoreStores1="//*[@id='Header-map-find-store']/a";
		public static final String lblActiveStoreAdd="//*[@id='Header-map-list']/div/div/ol/li[1]";
		public static final String lblActiveStorePhnFax="//*[@id='Header-map-list']/div/div/ol/li[1]/span[3]";
		public static final String lblActiveStoreHrs="//*[@id='Header-map-list']/div/div/ol/li[1]/strong[3]";
		public static final String lnkActiveStoreViewOnMap="//*[@id='Header-map-list']/div/div/ol/li[1]/ul/li[1]/a";
		public static final String lnkActiveStoreGetDir="//*[@id='Header-map-list']/div/div/ol/li[1]/ul/li[2]/a";
		public static final String lnkActiveStoreHideDetailsUpArrow="//*[@id='Header-map-list']/div/div/ol/li[1]/a/span[1]";
		public static final String lblNextStoreName="//*[@id='Header-map-list']/div/div/ol/li[2]/strong[1]";
		public static final String lnkMakeThisYourStore="//*[@id='Header-map-list']/div/div/ol/li[2]/ul/li[2]/a";
		public static final String webElmntMap="//*[@id='SL-map-canvas']";
		

}