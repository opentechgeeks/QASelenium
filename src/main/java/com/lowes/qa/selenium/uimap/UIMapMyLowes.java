package com.lowes.qa.selenium.uimap;

/**
 * UI Map for MyLowes
 */
public class UIMapMyLowes
{
	/****************Home Page************************/
	//links
		//id
		public static final String lnkMyAccount = "nav-my-account";
		public static final String lnkHPYourAcct="//*[@id='nav-home-profile']";
		public static final String lnkSignUp2="//*[@id='Logon']/div/div/p/a";
		//xpath
		
		
	//label
		//xpath
		public static final String lblInvalidZipCodeTxt="//*[@id='registrationForm']/ul[4]/li/label[2]";
		
	//webelement
		//xpath
		public static final String webElmntYourAcct="//*[@id='nav-my-account']/span[3]";
		public static final String webElmntSignInHeading="//*[@id='Logon']/div/div/h1";
		
	//text box
		//xpath
		public static final String txtUserName="//*[@id='Ecom_User_ID']";
		public static final String txtPassword="//*[@id='logonPassword']";
	/****************Product Details Page************************/
	//Web element
		//xpath
		public static final String webElmntProductName = "//*[@id='descCont']/div[1]/h1";
		public static final String webElmntSaveToList="//*[@id='saveItemBlock']/div[3]/ul/li[1]/a/span[2]";
		public static final String webElmntSaveToHP=  "//*[@id='saveItemBlock']/div[3]/ul/li[2]/a/span[2]";
		public static final String webElmntInfoGuidesTab="//*[@id='info-guides-tab']/a";
		public static final String webElmntRelatedDocs="//*[@id='Infoandguides_tab']/div/ul/li";
		//id	
		public static final String webElmntSaveItem = "saveItemBlock";
	//link
		//xpath
		public static final String lnkGoToHP="//*[@id='saveItemBlock']/div[3]/div[1]/a";
		
		
	/****************Redirected Sign In page************************/
	//links
		//css
		public static final String lnkSignUp = "a.signUpLink";
	
	/****************My Account Page************************/
	//Web Elements
		//xpath
		public static final String webElmntBrdCrumbsLvl2 = "//*[@id='breadcrumbs']/ul/li[2]";
		public static final String webElmntBrdCrumbsLvl2_2 ="html/body/div[3]/div[1]/div/ul/li[3]";
		public static final String webElmntAcctSummaryHeading="//*[@id='mylowes-account-info']/h3/span";
		//css
		public static final String webElmntHeading= "h1 > span";
		
	//Links
		//id
		public static final String lnkHomeProfile = "nav_homeprofile";
		public static final String lnkHomeProfile2="html/body/div[3]/div[3]/div/div[2]/ul/li[3]/a";
		public static final String lnkLists ="nav_portfolio";
		public static final String lnkPurchases ="nav_purchases";
		//xpath
		public static final String lnkMyLowes1="//*[@id='nav_account']/a";
		
	/****************HomeProfile Page************************/	
	//Web Elements	
		//xpath
		public static final String webElmntShowHP= "//div[@id='spaces_module']/div[2]/div[2]/div[2]/a/span";
		public static final String webElmntShowAllProducts= "//*[@id='spaces_module']/div[2]/div[2]/div[2]/ul/li[2]/a";
		public static final String webElmntContainer1="//*[@id='spaces_module']/div[2]/div[1]/div/a/span";
		public static final String webElmntContainer2="//*[@id='spaces_module']/div[2]/div[2]/div[2]/a/span";
		public static final String webElmntContainer3="//*[@id='spaces_module']/div[2]/div[3]/div[2]/a/span";
		public static final String webElmntWelcomeMsg="//*[@id='welcome_message']/div[2]";
		public static final String webElmntSpaceCount="//*[@id='spaces_module']/div[1]/h2";
		public static final String webElmntHPName="//*[@id='hp-header']/h2/div[1]/span/a";
		public static final String webElmntHPRenameError="//*[@id='notificationArea']";
		public static final String webElmntHPNotes="//*[@id='profile_notes']/pre";
		public static final String webElmntProfileNotesError="html/body/div[15]/div[2]/div/p";
		public static final String webElmntViewOrAssignProducts="//*[@id='items_trigger']/img";
		public static final String webElmntViewOrAssignProducts2="//*[@id='items_trigger']";
		public static final String webElmntAllPhotos="//*[@id='spaces_module']/div[2]/div[2]/div[2]/ul/li[3]/a";
		public static final String webElmntAllDocs="//*[@id='spaces_module']/div[2]/div[2]/div[2]/ul/li[4]/a";
		public static final String webElmntShowSpaces="//*[@id='spaces_module']/div[2]/div[2]/div[2]/ul/li[1]/a";
		public static final String webElmntShowDefault="//*[@id='spaces_module']/div[2]/div[2]/div[2]/a/span/a";
		public static final String webElmntSpaceDropScroll="//*[@id='space-listing-dropdown']/div/div/div/div[2]/div[2]/div";
		//css selector
		public static final String webElmntDeleteHPMessage="div.modal_content > p";
		public static final String webElmntSelectShow= "a.btn.dropdown-toggle > span";
	//button
		//css selector
		public static final String btnDeleteHomeProfile="#delete_profile > a.button.secondary > span";
		public static final String btnDeleteHomeProfileOK="div.modal_content > button.button.primary";
		//xpath
		public static final String btnHPNameRenameSave="//*[@id='hp-header']/h2/div[2]/div/button";
		public static final String btnHPNotesSave="//*[@id='profile_notes']/div/a[1]/span";
		
		//xpath
		public static final String btnDeleteHomeProfileConfirm="//div[4]/button";
	//Text box
		//xpath
		public static final String txtDeleteHomeProfile="(//input[@type='text'])[11]";
		public static final String txtHPNameRename="//*[@id='hp-header']/h2/div[2]/input";
		public static final String txtHPNotes="//*[@id='profile_notes']/textarea";
	//link
		//xpath
		public static final String lnkHPNameRename="//*[@id='hp-header']/h2/div[1]/a";
		public static final String lnkHPNameRenameCancel="//*[@id='hp-header']/h2/div[2]/div/a";
		public static final String lnkHPName="//*[@id='hp-header']/h2/div[1]/span/a";
		public static final String lnkNewSpace1="//*[@id='spaces_module']/div[2]/div[1]/div/ul/li[1]/a";
		public static final String lnkNewSpace3="//*[@id='spaces_module']/div[2]/div[1]/div/ul/li[3]/a";
		public static final String lnkCreateHP="//*[@id='create_profile_link']/span";
		public static final String lnkSpace5="//*[@id='spaces_grid']/li[5]/h3/div[1]/span/a";
		public static final String lnkSpace1="//*[@id='spaces_grid']/li[1]/h3/div[1]/span/a";
		
		//id
		public static final String lnkCreateHomeProfile="create_profile_link";
	//drop down
		//xpath
		public static final String drpDownNewSpace="//*[@id='spaces_module']/div[2]/div[1]/div/a/span/b";
		public static final String drpDownSpace="//*[@id='space-drop']";
		public static final String drpDownShow="//*[@id='spaces_module']/div[2]/div[2]/div[2]/a/span/b";
	//label
		//xpath
		public static final String lblSpaceCount="//*[@id='spaces_module']/div[1]/h2";
		public static final String lblShow="//*[@id='spaces_module']/div[2]/div[2]/div[1]";
		public static final String lblSortBy="//*[@id='spaces_module']/div[2]/div[3]/div[1]";
		public static final String lblSpace4PhotosCount="//*[@id='spaces_grid']/li[4]/div/div[2]/span[2]";
		public static final String lblSpace5PhotosCount="//*[@id='spaces_grid']/li[5]/div/div[2]/span[2]";
		public static final String lblSpace3CalcCount="//*[@id='spaces_grid']/li[3]/div/div[2]/span";
		public static final String lblSpace5CalcCount="//*[@id='spaces_grid']/li[5]/div/div[2]/span[3]";
		public static final String lblSpace5DimCount="//*[@id='spaces_grid']/li[5]/div/div[1]";
		public static final String lblSpace5ProdCount="//*[@id='spaces_grid']/li[5]/div/div[2]/span[1]";
		public static final String lblSpace5DocCount="//*[@id='spaces_grid']/li[5]/div/div[2]/span[4]";
		public static final String lblSpace1Txt="//*[@id='spaces_grid']/li[1]/div/p";
	/****************View All Products Page************************/
	//Web Elements	
		//xpath	
		public static final String webElmntProductCount= "//*[@id='product_list']/div[1]/h2";
		public static final String webElmntMultipleDeletePopup= "//*[@id='delete_multiple_items_confirm_pop']";
		public static final String webElmntDeleteUndoMsg= "//div[@id='item_list']/div/div[2]/p";
		public static final String webElmntRecentlyAdded = "//*[@id='item_list']/div[1]/div[1]/div[1]/p";
		public static final String webElmntUnassignedStatus = "//*[@id='item_list']/div[1]/div[1]/div[2]/div[2]/div[2]/span[2]";
		public static final String webElmntProductAssignedSpace = "//*[@id='item_list']/div[1]/div[1]/div[2]/div[2]/div[2]/span[2]/span/a[1]";
		public static final String webElmntManualItemAssignedSpace = "//*[@id='item_list']/div[1]/div[1]/div[2]/div[2]/div[3]/span[2]/span/a[1]";
		public static final String webElmntProductAssignedSpaceGrid = "//*[@id='productForm']/ul/li[3]/div[1]/span[2]/span/a[1]";
		public static final String webElmntManualItemAssignedSpaceGrid = "//*[@id='manual_item_form']/ul/li[3]/ul/li[2]/div[1]/span[2]/span/a[1]";
		public static final String webElmntNoteItemList = "//*[@id='item_list']/div[1]/div[1]/div[2]/div[2]/div[1]/span";
		public static final String webElmntGridViewImg = "//*[@id='product_list']/div[1]/ul/li[2]/a/img";
		public static final String webElmntListViewImg = "//*[@id='product_list']/div[1]/ul/li[1]/a/img";
		public static final String webElmntGridView = "//*[@id='product_list']/div[1]/ul/li[2]";
		public static final String webElmntListView = "//*[@id='product_list']/div[1]/ul/li[1]";
		public static final String webElmntUnassignedGridProduct= "//li[3]/div/span[2]";
		public static final String webElmntUnassignedGridManualItem= "//li[2]/div/span[2]";
		public static final String webElmntItem1Name= "//*[@id='item_list']/div[1]/div[1]/div[2]/div[1]/h5";
		public static final String webElmntItem2Name= "//*[@id='item_list']/div[1]/div[3]/div[2]/div[1]/h5";
		public static final String webElmntItem3Name="//*[@id='item_list']/div[1]/div[5]/div[2]/div[1]/h5";
		public static final String webElmntDeleteCurrentSpace= "//*[@id='productForm']/ul/li[3]/div[1]/span[2]/span/a[2]/span";
		public static final String webElmntItemNames="//*[@id='item_list']/div[1]/div/div[2]/div[1]/h5";
		public static final String webElmntSpaceGrid="//*[@id='spaces_grid']/li";
		public static final String webElmntLocatedIn="//*[@id='item_list']/div[1]/div[1]/div[2]/div[2]/div[2]/span[2]/span";
		public static final String webElmntSpaceList="//div[@id='spaces_list_my']/ul/li";
		public static final String webElmntIntSpaceList="//div[@id='spaces_list_new_in']/ul/li";
		public static final String webElmntExtSpaceList="//div[@id='spaces_list_new_ex']/ul/li";
		public static final String webElmntAllProducts="//*[@id='product_list']/div[2]/div[2]/div[2]/ul/li[2]/a";
		public static final String webElmntEnterProductInfo="//*[@class='btn add_item']/span";
		public static final String webElmntEnterProductInfo2="//*[@id='product_list']/div[2]/div[1]/a/span";
		public static final String webElmntManualItemFormX="//*[@id='manual_item_form']/ul";
		public static final String webElmntSavedBrandName="(//input[@id='brandName'])[2]";
		public static final String webElmntSavedHeight="(//input[@id='height'])[2]";
		public static final String webElmntSavedWidth="(//input[@id='width'])[2]";
		public static final String webElmntSavedDepth="(//input[@id='depth'])[2]";
		public static final String webElmntSavedFinish="(//input[@id='finish'])[2]";
		public static final String webElmntSavedItemName="(//input[@id='itemModelNumber'])[2]";
		public static final String webElmntSavedLink="(//input[@id='link'])[2]";
		public static final String webElmntSavedNotes="(//div[@id='notes'])[2]";
		public static final String webElmntSortByHp="//*[@id='product_list']/div[2]/div[3]/div[2]/a/span";
		public static final String webElmntSortByHpMostRecent="//*[@id='product_list']/div[2]/div[3]/div[2]/ul/li[1]/a";
		public static final String webElmntEditItem13Arrow="//*[@id='item_list']/div[1]/div[13]/div[2]/div[1]/div/a[2]/span";
		public static final String webElmntEditItem1Arrow="//*[@id='item_list']/div[1]/div[1]/div[2]/div[1]/div/a[2]/span";
		public static final String webElmntSelectSpaceDownArrow="//*[@id='toggle_space_selector']/span";
		public static final String webElmntItem1TrashCan="//*[@id='item_list']/div[1]/div[1]/div[2]/div[1]/div/a[3]/img";
		public static final String webElmntItem1Edit="//*[@id='item_list']/div[1]/div[1]/div[2]/div[1]/div/a[2]";
		public static final String webElmntItem1EditDownArrow="//*[@id='item_list']/div[1]/div[1]/div[2]/div[1]/div/a[2]/span";
		public static final String webElmntItem1Img="//*[@id='item_list']/div[1]/div[1]/div[1]/img";
		public static final String webElmntRemoveSpace="//*[@id='item_list']/div[1]/div[1]/div[2]/div[2]/div[2]/span[2]/span/a[2]/span";
		public static final String webElmntProductsActions="//*[@id='product_list']/div[2]/div[4]/div[2]/a";
		public static final String webElmntMultipleDelConfirmMsg="//*[@id='delete_multiple_items_confirm_pop']/div/div[1]/strong";
		//id
		public static final String webElmntProductForm = "productForm";
		public static final String webElmntManualItemForm = "manual_item_form";
		
		
		
		//css selector
		public static final String webElmntTrashcanDelete= "img[alt=\"Delete\"]";
		public static final String webElmntAssignedSpace= "li.space_selector_container > div.current_location > span.assigned_spaces > span.location > a.space_name";
		public static final String webElmntItemAddedSuccessMsg="#manual_item_success > p";
		public static final String webElmntProductTypeSaved="span.capitalize";
		public static final String webElmntdatePicker="img.ui-datepicker-trigger";
	//Links	
		//xpath
		public static final String lnkEdit2 = "//a[contains(text(),'Edit')]";
		public static final String lnkUndo2 = "//*[@id='item_list']/div[1]/div[2]/p/a";
		public static final String lnkAddAnote = "//a[contains(text(),'Add a note')]";
		public static final String lnkItem13LocatedInSpace="//*[@id='item_list']/div[1]/div[13]/div[2]/div[2]/div[2]/span[2]/span/a[1]";
		public static final String lnkItem1LocatedInSpace="//*[@id='item_list']/div[1]/div[1]/div[2]/div[2]/div[2]/span[2]/span/a[1]";
		public static final String lnkItem1ViewProduct="//*[@id='item_list']/div[1]/div[1]/div[2]/div[1]/div/a[1]";
		public static final String lnkSpaceDrpDownKitchen="//*[@id='carousel_space_id_128947415']/span";
		
		public static final String lnkProductsShowDoc="//*[@id='product_list']/div[2]/div[2]/div[2]/ul/li[3]/a";
		public static final String lnkProductsShowSpaces="//*[@id='product_list']/div[2]/div[2]/div[2]/ul/li[1]/a";
		public static final String lnkProductsBatchDelete="//*[@id='product_list']/div[2]/div[4]/div[2]/ul/li/a";
		public static final String lnkSelectSpaces2 ="//*[@id='toggle_space_selector']";
		public static final String lnkCancelItem1="//*[@id='manual_item_form']/ul/li[4]/a";
		public static final String lnkClose="//*[@id='manual_item_form']/ul/li[1]/div/div/a";
		//id
		public static final String lnkSelectSpaces = "toggle_space_selector";
		//css Selector
		public static final String lnkCancelItem = "li.form_buttons > a.cancel";
		public static final String lnkCloseItem = "a.close_and_save_item";
		
	//Text Box
		//name
		public static final String txtItemName = "name";
		public static final String txtNote = "note";
		//id
		public static final String txtBrand = "brandName";
		public static final String txtHeight = "height";
		public static final String txtWidth = "width";
		public static final String txtDepth = "depth";
		public static final String txtFinish = "finish";
		public static final String txtItemNbr = "itemModelNumber";
		public static final String txtLink = "link";
		public static final String txtPurchaseDate = "purchaseDate";
		
		
		//xpath
		public static final String txtNotes2 = "//*[@id='notes']/pre";
		public static final String txtNotesTextArea = "//*[@id='notes']/textarea";
	//checkbox
		//id
		public static final String chkBoxBatchDelete="batch_delete";
		//xpath
		public static final String chkBoxBatchDelete2="//*[@id='batch_delete']";
		public static final String chkBoxItem1 = "(//input[@type='checkbox'])[2]";
		public static final String chkBoxItem="//*[@id='item_list']/div[1]/div[1]/input[1]";
		public static final String chkBoxItem2="//*[@id='item_list']/div[1]/div[3]/input[1]";
		public static final String chkBoxSpace2="//*[@id='spaces_list_my']/ul/li[2]/input";
		public static final String chkBoxSpace4 = "//div[@id='spaces_list_my']/ul/li[4]/input";
		public static final String chkBoxSpace5 = "//div[@id='spaces_list_my']/ul/li[5]/input";
		public static final String chkBoxSpace1 = "//div[@id='spaces_list_my']/ul/li/input";
		public static final String chkBoxSpace3 = "//div[@id='spaces_list_my']/ul/li[3]/input";
		public static final String chkBoxYARD="//*[@id='space_128947414']";
		public static final String chkBoxKitchen4="//*[@id='space_128947415']";
	//button
		//xpath
		public static final String btnConfirmDelete = "//*[@id='delete_multiple_items_confirm_pop']/div/div[2]/button";
		public static final String btnSave= "//li[4]/button";
		public static final String btnSave2="//*[@id='productForm']/ul/li[4]/button";
		public static final String btnSaveManualItem="//*[@id='manual_item_form']/ul/li[4]/button";
		
		
	//drop-down
		//name
		public static final String drpDownProductType="entitySubType";
		public static final String drpDownProductSubType="productType";
		public static final String drpDownProductName="maItemName";
		//xpath
		public static final String drpDownSortBy="//*[@id='product_list']/div[2]/div[3]/div[2]/a/span/b";
		public static final String drpDownShowDefault="//*[@id='product_list']/div[2]/div[2]/div[2]/a/span/a";
	//label
		//xpath
		public static final String lblUnassignedProductForm="//*[@id='productForm']/ul/li[3]/div[1]/span[3]";
		public static final String lblSortByAToZ="//*[@id='product_list']/div[2]/div[3]/div[2]/ul/li[2]/a";
		public static final String lblAddToSpaces="//*[@id='productForm']/ul/li[3]/div[1]/span[1]";
		public static final String lblAddToSpacesManualItem="//*[@id='manual_item_form']/ul/li[3]/ul/li[2]/div[1]/span[1]";
		public static final String lblProductsShow="//*[@id='product_list']/div[2]/div[2]/div[1]";
		public static final String lblProductsSortBy="//*[@id='product_list']/div[2]/div[3]/div[1]";
		public static final String lblProductNewIntSpace="//*[@id='spaces_list_new_in']/h3";
		public static final String lblProductNewExtSpace="//*[@id='spaces_list_new_ex']/h3";
		public static final String lblYourSpacesSpace5="//*[@id='spaces_list_my']/ul/li[5]/label";
		public static final String lblYourSpacesSpaceList="//*[@id='spaces_list_my']/ul/li";
	/****************Space Page************************/	
	//Web Elements
		//xpath
		public static final String webElmntSummary = "(//a[contains(text(),'Summary')])[2]";
		public static final String webElmntShowDownArrow="//*[@id='product_list']/div[2]/div[2]/div[2]/a/span/b";
		public static final String webElmntDelConfirmationMsg="//*[@id='delete_space_dialog']/div/div[1]/p";
		//IDs
		public static final String webElmntSpaceName = "space-drop";
		public static final String webElmntItemList = "item_list";
		public static final String webElmntSpaceNotes = "space_notes";
	//TextArea
		public static final String txtSpaceNotes = "//*[@id='space_notes']/textarea";
		public static final String txtSpaceNotesPre ="//*[@id='space_notes']/pre";
		//CSS Selector
		public static final String webElmntShow= "a.btn.dropdown-toggle > span";
	//buttons
		//xpath
		public static final String btnDeleteSpace2= "//*[@id='delete_space']/span";
		public static final String btnDeleteSpaceConfirm= "//div[@id='delete_space_dialog']/div/div[3]/button";
		public static final String btnSaveSpaceNotes= "//*[@id='space_notes']/div/a[1]/span";
		
	//label
		//xpath
		public static final String lblShowPhotos="//*[@id='product_list']/div[2]/div[2]/div[2]/ul/li[2]/a";
	//link
		//xpath
		public static final String lnkShowCalc="//*[@id='product_list']/div[2]/div[2]/div[2]/ul/li[4]/a";
		public static final String lnkShowDim="//*[@id='product_list']/div[2]/div[2]/div[2]/ul/li[5]/a";
	/****************Dimensions Page************************/
	//Web Elements
		//xpath
		public static final String webElmntDimHeading = "//*[@id='tabs_dimensions']/div[1]/h2";
		public static final String webElmntShapeRect2 = "//*[@id='shape_rect']";
		public static final String webElmntRightBorder = "//div[24]/div";
		public static final String webElmntRightCanvas= "//div[@id='canvas']/div[7]";
		public static final String webElmntRightArrow= "(//img[@alt='Arrow_double_vert'])[3]";
		public static final String webElmntBottomBorder = "//div[21]/div[2]/div";
		public static final String webElmntBottomCanvas= "//div[@id='canvas']/div[5]";
		public static final String webElmntBottomArrow= "(//img[@alt='Arrow_double_horz'])[3]";
		//public static final String webElmntLeftBorder = "//div[4]/div[2]/div[2]";
		public static final String webElmntLeftBorder = "//div[3]/div/div[4]/div[2]/div[2]";
		public static final String webElmntLeftCanvas="//div[@id='canvas']/div[6]";
		public static final String webElmntLeftArrow="//img[@alt='Arrow_double_vert']";
		public static final String webElmntTopBorder = "//div[3]/div/div[4]/div[2]/div";
		public static final String webElmntTopCanvas= "//div[@id='canvas']/div[4]";
		public static final String webElmntTopArrow= "//img[@alt='Arrow_double_horz']";
		public static final String webElmntDimNeededError = "//*[@id='dimensions_needed']/p";
		public static final String webElmntTotalArea = "//*[@id='totalArea']/h4/div";
		public static final String webElmntNegAreaSummary= "//*[@id='dimensions_list']/div/div[2]/div/div/div[2]/span[2]";
		public static final String webElmntDeleteNegSpaceArea1= "//div[@id='negativeSpaces']/div[2]/div/span[3]";
		public static final String webElmntDeleteNegSpaceArea2= "//div[@id='negativeSpaces']/div[2]/div[2]/span[3]";
		public static final String webElmntSelectAShape= "//*[@id='dimensions_tool']/h1[1]";
		public static final String webElmntLawnAreaExpanded= "//*[@id='accordion']/h3[2]";
		//css selector
		public static final String webElmntNetArea = "#totalNetArea > span";
	//button
		//xpath
		public static final String btnContinue= "//*[@id='section_shapes']/div[3]/a/span";
		public static final String btnEditDimensions= "//*[@id='edit_calc']/span";
		public static final String btnEditYardMsrments= "//*[@id='edit_border']/span";
		public static final String btnFinish2="//*[@id='section_openings']/div[3]/a/span";
		//css selector
		public static final String btnFinish= "#section_openings > div.controls > a.continue_btn.button > span";
	//Text Box
		//xpath
		public static final String txtLength= "(//input[@id='length_ft'])[2]";
		public static final String txtNotes3= "(//input[@id='notes'])[2]";
		public static final String txtNegSpaceArea1= "//div[@id='negativeSpaces']/div[2]/div[1]/span[2]/input";
		public static final String txtNegSpaceArea2= "//div[@id='negativeSpaces']/div[2]/div[2]/span[2]/input";
		public static final String txtNegSpaceAreaName1= "//div[@id='negativeSpaces']/div[2]/div[1]/span[1]/input";
		public static final String txtNegSpaceAreaName2= "//div[@id='negativeSpaces']/div[2]/div[2]/span[1]/input";
	//Links
		//xpath
		
		public static final String lnkAddAnother="//*[@id='negativeSpaces']/a";;
	//label
		//xpath
		public static final String lblSummaryBreadth="//*[@id='dimensions_list']/div/div[1]/div/div/div[3]/span[2]";
		public static final String lblSummaryLength="//*[@id='dimensions_list']/div/div[1]/div/div/div[2]/span[2]";
		public static final String lblNonLawnInAreaTotal="//*[@id='totalNegativeSpace']/h4/div";
		public static final String lblNetAreaInAreaTotal="//*[@id='totalNetArea']/span";
		public static final String lblNonLawnHeadingInLawnArea="//*[@id='negativeSpaces']/h4";
		
		
		
	/****************Documents Page************************/
		//xpath
		public static final String webElmntDocCount = "//*[@id='total_documents_items']";
		public static final String webElmntDocUpload = "//*[@id='documentsContainer']/div[2]/div[2]/div[1]/a/span";
		public static final String webElmntDocUpload2 = "//*[@id='documentsContainer']/div[1]/div[2]/div[2]/div[1]/a/span";//from All Docs 
		public static final String webElmntDocShow ="//*[@id='documentsContainer']/div[2]/div[2]/div[2]/div[1]";
		public static final String webElmntDocShow2 ="//*[@id='documentsContainer']/div[1]/div[2]/div[2]/div[2]/div[1]";//from All Docs 
		public static final String webElmntDocShowDropDown="//*[@id='documentsContainer']/div[2]/div[2]/div[2]/div[2]/a/span";
		public static final String webElmntDocSortBy ="//*[@id='documentsContainer']/div[2]/div[2]/div[3]/div[1]";
		public static final String webElmntDocSortBy2 ="//*[@id='documentsContainer']/div[1]/div[2]/div[2]/div[3]/div[1]";//from All Docs
		public static final String webElmntDocSortByDefault="//*[@id='documentsContainer']/div[1]/div[2]/div[2]/div[3]/div[2]/a/span/a";//from All Docs
		public static final String webElmntDocSortByDropDown ="//*[@id='documentsContainer']/div[2]/div[2]/div[3]/div[2]/a/span";
		public static final String webElmntDoc1Name="//div[2]/h5";
		public static final String webElmntDocCountOnPg="//*[@id='documentsContainer']/div[2]/div[3]/div";
		public static final String webElmntDoc1Namee="//*[@id='documentsContainer']/div[2]/div[3]/div[1]/div[2]/form/div[2]/div[2]/h5";
		public static final String webElmntDoc2Namee="//*[@id='documentsContainer']/div[2]/div[3]/div[2]/div[2]/form/div[2]/div[2]/h5";
		public static final String webElmntDoc1Icon="//*[@id='documentsContainer']/div/div[2]/div[3]/div[1]/div[2]/form/div[1]";
		public static final String webElmntDoc2Name="//div[2]/div[2]/form/div[2]/div[2]/h5";
		public static final String webElmntDoc1Trashcan="//img[@alt='Delete']";
		//public static final String webElmntDoc1Trashcan1="//*[@id='documentsContainer']/div[2]/div[3]/div[1]/div[2]/form/div[2]/div[1]/a[3]/img";
		public static final String webElmntDoc1Trashcan2="//*[@id='documentsContainer']/div/div[2]/div[3]/div[1]/div[2]/form/div[2]/div[1]/a[3]/img";//from All Docs
		public static final String webElmntDoc2Trashcan="(//img[@alt='Delete'])[2]";
		public static final String webElmntDocList="//*[@id='documentsContainer']/div[2]/div[3]/div";
		public static final String webElmntDoc1LocatedIn="//div[4]/div/span/a";
		public static final String webElmntDoc2LocatedIn="//div[2]/div[2]/form/div[2]/div[4]/div/span/a";
		public static final String webElmntDoc1UnassignOption="//span/a[2]";
		public static final String webElmntDoc2UnassignOption="//div[2]/div[2]/form/div[2]/div[4]/div/span/a[2]";
		public static final String webElmntDoc1Trashcan1="//div[@id='documentsContainer']/div[2]/div[3]/div[1]/div[2]/form/div[2]/div[1]/a[3]/img";
		public static final String webElmntDocNotes="//*[@id='note']";
		public static final String webElmntDocsSortByDownArrow="//*[@id='documentsContainer']/div[2]/div[2]/div[3]/div[2]/a/span/b";
		public static final String webElmntDocsShowDownArrow="//*[@id='documentsContainer']/div[2]/div[2]/div[2]/div[2]/a/span/b";
		public static final String webElmntDocsSortByDownArrow2="//*[@id='documentsContainer']/div[1]/div[2]/div[2]/div[3]/div[2]/a/span/b";//from All Docs
		public static final String webElmntDocsSortByAToZ="//*[@id='documentsContainer']/div[1]/div[2]/div[2]/div[3]/div[2]/ul/li[2]/a";
		public static final String webElmntDocsSortByMostRecent="//*[@id='documentsContainer']/div[1]/div[2]/div[2]/div[3]/div[2]/ul/li[1]/a";
		public static final String webElmntDocsUploadPopup="//*[@id='upload-modal-2']/form/span/input";
		public static final String webElmntDoc1DeletedMsg="//div[@id='documentsContainer']/div[2]/div[3]/div[1]/p";
		public static final String webElmntItemListRelatedDocs="//*[@id='productForm']/ul/li[5]/ul/li";
	//label
		//xpath
		public static final String lblDescription="//*[@id='product-detail-tabs']/ul/li[1]/a";
		public static final String lblDocAddedNotes="//*[@id='calculationsContainer']/div[2]/div[3]/div/div[2]/div[2]/div[2]/div";
		public static final String lblDocCharRemaining="//*[@id='documentsContainer']/div/div[2]/div[3]/div[1]/div[2]/form/div[2]/div[3]/p[2]";
	//link
		//xpath
		public static final String lnkDoc1DownloadLink="//a[contains(text(),'Download')]";
		public static final String lnkDoc2DownloadLink="(//a[contains(text(),'Download')])[2]";
		public static final String lnkDoc2EditLink="(//a[contains(text(),'Edit')])[2]";
		public static final String lnkDoc1AddToSpaces="//div[4]/a/span";
		public static final String lnkDoc2AddToSpaces="//div[2]/div[2]/form/div[2]/div[4]/a/span";
		public static final String lnkDocUndoLink="//div[3]/div/p/a";
		public static final String lnkDocEdit="//div[@id='documentsContainer']/div/div[2]/div[3]/div[1]/div[2]/form/div[2]/div[1]/a[2]";
		public static final String lnkDocSortByMostRecent="//*[@id='documentsContainer']/div[2]/div[2]/div[3]/div[2]/ul/li[1]/a";
		public static final String lnkDocSortByAToZ="//*[@id='documentsContainer']/div[2]/div[2]/div[3]/div[2]/ul/li[2]/a";
		public static final String lnkDocShowProducts="//*[@id='documentsContainer']/div[2]/div[2]/div[2]/div[2]/ul/li[1]/a";
		public static final String lnkDocShowPhotos="//*[@id='documentsContainer']/div[2]/div[2]/div[2]/div[2]/ul/li[2]/a";
		public static final String lnkDocShowDocs="//*[@id='documentsContainer']/div[2]/div[2]/div[2]/div[2]/ul/li[3]/a";
		public static final String lnkDocShowCalc="//*[@id='documentsContainer']/div[2]/div[2]/div[2]/div[2]/ul/li[4]/a";
		public static final String lnkDocShowDim="//*[@id='documentsContainer']/div[2]/div[2]/div[2]/div[2]/ul/li[5]/a";
		public static final String lnkDoc1Edit="//*[@id='documentsContainer']/div/div[2]/div[3]/div[1]/div[2]/form/div[2]/div[1]/a[2]";//from All Documents
		public static final String lnkDoc1Edit1="//*[@id='documentsContainer']/div[2]/div[3]/div[1]/div[2]/form/div[2]/div[1]/a[2]";//from space->documents
		public static final String lnkDocUploadClose="//div[17]/div[1]/a/span";
		public static final String lnkDoc1DeletedMsgUndo="//div[@id='documentsContainer']/div[2]/div[3]/div[1]/p/a";
	//button
		//xpath
		public static final String btnDoc1Save="//*[@id='documentsContainer']/div/div[2]/div[3]/div[1]/div[2]/form/div[2]/div[5]/button";
		
	//dropdown
		//xpath
		public static final String drpDownSortByDefault="//*[@id='documentsContainer']/div[2]/div[2]/div[3]/div[2]/a/span/a";
		
	/****************Calculations tab page************************/		
	//web element
		//xpath
		public static final String webElmntCalcTotalNetArea="//*[@id='calcDetailForm']/div[2]/div[1]/h4";
		public static final String webElmntCalcAddedOn="//*[@id='calcDetailForm']/div[2]/div[2]/div[1]";
		public static final String webElmntStaticTextCol1="//*[@id='calcDetailForm']/div[2]/div[1]/table/thead/tr/td[1]";
		public static final String webElmntStaticTextCol2="//*[@id='calcDetailForm']/div[2]/div[1]/table/thead/tr/td[2]";
		public static final String webElmntStaticTextCol3="//*[@id='calcDetailForm']/div[2]/div[1]/table/thead/tr/td[4]";
		public static final String webElmntCalcTypeIcon="//*[@id='calculationsContainer']/div[2]/div[3]/div/div[2]/div[1]";
		public static final String webElmntCalcTrashcan="//*[@id='calcDetailForm']/div[1]/div/a[2]/img";
		public static final String webElmntTotalCalc="//*[@id='total_calc_items']";
		public static final String webElmntGoToPrjctCalc="//*[@id='calculationsContainer']/div[2]/div[2]/div[1]/a/span";
		public static final String webElmntCalcSavedNotes="//*[@id='calculationsContainer']/div[2]/div[3]/div[1]/div[2]/div[2]/div[2]/div";
		public static final String webElmntDeleteCalcTrashcan= "//*[@id='calculationsContainer']/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/div/a[2]/img";
		public static final String webElmntDeleteCalc2Trashcan="//*[@id='calculationsContainer']/div[2]/div[3]/div[2]/div[2]/div[2]/div[1]/div/a[2]/img";
		public static final String webElmntDeleteCalcAllTrashcan="//*[@id='calculationsContainer']/div[2]/div[3]/div/div[2]/div[2]/div[1]/div/a[2]/img";
		public static final String webElmntCalc1Name="//*[@id='calculationsContainer']/div[2]/div[3]/div[1]/div[2]/div[2]/div[1]/h5";
		public static final String webElmntCalc2Name="//*[@id='calculationsContainer']/div[2]/div[3]/div[2]/div[2]/div[2]/div[1]/h5";
		public static final String webElmntCalc3Name="//*[@id='calculationsContainer']/div[2]/div[3]/div[3]/div[2]/div[2]/div[1]/h5";
		public static final String webElmntCalc4Name="//*[@id='calculationsContainer']/div[2]/div[3]/div[4]/div[2]/div[2]/div[1]/h5";
		public static final String webElmntCalc5Name="//*[@id='calculationsContainer']/div[2]/div[3]/div[5]/div[2]/div[2]/div[1]/h5";
		public static final String webElmntCalculatorHeading="//*[@id='article-header']/div/h1";
		public static final String webElmntAllCalculatorsHeading="//*[@id='projectCalculators']/h3";
		public static final String webElmntActions = "//*[@id='calculationsContainer']/div[2]/div[2]/div[3]/div[2]/a";
		public static final String webElmntDeleteAction = "//*[@id='calculationsContainer']/div[2]/div[2]/div[3]/div[2]/ul/li/a";
		public static final String webElmntDeleteMsgCalcName = "//*[@id='calculationsContainer']/div[2]/div[3]/div[1]/p/strong";
		public static final String webElmntDeleteMsgCalc2Name ="//*[@id='calculationsContainer']/div[2]/div[3]/div[2]/p/strong";
		public static final String webElmntCalcDisclaimer="//*[@id='calcDetailForm']/div[2]/div[2]/p[1]";
		public static final String webElmntCalc1Img="//*[@id='calculationsContainer']/div[2]/div[3]/div[1]/div[2]/div[1]";
		public static final String webElmntCalc2Img="//*[@id='calculationsContainer']/div[2]/div[3]/div[2]/div[2]/div[1]";
		public static final String webElmntCalc3Img="//*[@id='calculationsContainer']/div[2]/div[3]/div[3]/div[2]/div[1]";
		public static final String webElmntCalc4Img="//*[@id='calculationsContainer']/div[2]/div[3]/div[4]/div[2]/div[1]";
		public static final String webElmntCalc5Img="//*[@id='calculationsContainer']/div[2]/div[3]/div[5]/div[2]/div[1]";
		
		
		public static final String webElmntNoCalcImg="//*[@id='calculationsContainer']/div[3]/div[4]/img";
		public static final String webElmntCalcShowDownArrow="//*[@id='calculationsContainer']/div[3]/div[2]/div[2]/div[2]/a/span/b";
		public static final String webElmntCalcMatDetails="//*[@id='calcDetailForm']/div[2]/div[1]/p";
		public static final String webElmntCalcTableAreaValue="//*[@id='calcDetailForm']/div[2]/div[1]/table/tbody/tr/td[5]";
		public static final String webElmntShopPaintPg="//div/div[1]/form/span[1]";
		public static final String webElmntAllCalc="//*[@id='calculationsContainer']/div[2]/div[3]/div";
		//paint related
		public static final String webElmntCalcStaticTxt2="//*[@id='calcDetailForm']/div[2]/div[1]/small";
		public static final String webElmntCalcPaintNeeded="//*[@id='calcDetailForm']/div[2]/div[1]/div/h4[1]";
		public static final String webElmntCalcPrimerNeeded="//*[@id='calcDetailForm']/div[2]/div[1]/div/h4[2]";
		
		public static final String webElmntStaticTextPaintEstCovg="//*[@id='calcDetailForm']/div[2]/div[2]/p[1]/strong";
		public static final String webElmntPaintDisclaimer="//*[@id='calcDetailForm']/div[2]/div[2]/p[2]";
					//mulch	related
		
		public static final String webElmntCalcVolume="//*[@id='calcDetailForm']/div[2]/div[1]/h4[2]";
		public static final String webElmntCalcPrdctQty="//*[@id='calcDetailForm']/div[2]/div[1]/h4[3]";
		public static final String webElmntCalcMulchDisclaimer="//*[@id='calcDetailForm']/div[2]/div[2]/p";
		public static final String webElmntCalcMulchArea1="//*[@id='calcDetailForm']/div[2]/div[1]/table/tbody/tr/td[1]";
		public static final String webElmntCalcMulcLength="//*[@id='calcDetailForm']/div[2]/div[1]/table/tbody/tr/td[2]";
		public static final String webElmntCalcMulcWidth="//*[@id='calcDetailForm']/div[2]/div[1]/table/tbody/tr/td[4]";
		//css
					//mulch
		public static final String webElmntCalcMulchMatDetails="p.material_details";
		public static final String webElmntCalcDisclamer2="div.drawer_details_right > p.disclaimer";
		
	//link
		//xpath
		public static final String lnkShowDetails = "//*[@id='calculationsContainer']/div[2]/div[3]/div/div[2]/div[2]/div[1]/div/a[1]";
		public static final String lnkCalc5ShowDetails ="//*[@id='calculationsContainer']/div[2]/div[3]/div[5]/div[2]/div[2]/div[1]/div/a[1]";
		public static final String lnkCalcCancel ="//*[@id='calcDetailForm']/div[4]/a";
		public static final String lnkCalcHideDetails ="//*[@id='calcDetailForm']/div[1]/div/a[1]";
		public static final String lnkCalcResultSpace="//*[@id='mulchCalculator']/div[2]/div/div[2]/div/div[4]/div/a";
		public static final String lnkCalcAttachANote="//*[@id='calculationsContainer']/div[2]/div[3]/div[1]/div[2]/div[2]/div[2]/div/a";
		public static final String lnkCalcAttachANoteAll="//*[@id='calculationsContainer']/div[2]/div[3]/div/div[2]/div[2]/div[2]/div/a";
		public static final String lnkDeleteCalcUndo="//*[@id='calculationsContainer']/div[2]/div[3]/div[1]/p/a";
		public static final String lnkDeleteCalcUndo2="//*[@id='calculationsContainer']/div[2]/div[3]/div/p/a";
		public static final String lnkDeleteCalc2Undo="//*[@id='calculationsContainer']/div[2]/div[3]/div[2]/p/a";
		public static final String lnkCalculatorLink1="//*[@id='calculationsContainer']/div[3]/div[3]/div/div[1]/a";
		public static final String lnkCalculatorLink2="//*[@id='calculationsContainer']/div[3]/div[3]/div/div[2]/a";
		public static final String lnkCalculatorLink3="//*[@id='calculationsContainer']/div[3]/div[3]/div/div[3]/a";
		public static final String lnkCalculatorLink4="//*[@id='calculationsContainer']/div[3]/div[3]/div/div[4]/a";
		public static final String lnkGoToProjCalc="//*[@id='calculationsContainer']/div[3]/div[2]/div[1]/a/span";
		public static final String lnkCalcShowProducts="//*[@id='calculationsContainer']/div[3]/div[2]/div[2]/div[2]/ul/li[1]/a";
		public static final String lnkCalcShowPhotos="//*[@id='calculationsContainer']/div[3]/div[2]/div[2]/div[2]/ul/li[2]/a";
		public static final String lnkCalcShowDocs="//*[@id='calculationsContainer']/div[3]/div[2]/div[2]/div[2]/ul/li[3]/a";
		public static final String lnkCalcShowCalc="//*[@id='calculationsContainer']/div[3]/div[2]/div[2]/div[2]/ul/li[4]/a";
		public static final String lnkCalcShowDim="//*[@id='calculationsContainer']/div[3]/div[2]/div[2]/div[2]/ul/li[5]/a";
		public static final String lnkCancel= "(//a[contains(text(),'Cancel')])[7]";
		public static final String lnkSeedMulchFertLink="//*[@id='section_review']/div[2]/div[6]/a";
	//textbox
		//id
		public static final String txtCalcName="name";
		
	//button
		//xpath
		public static final String btnCalcSave="//*[@id='calcDetailForm']/div[4]/button";
		public static final String btnCalcShop="//*[@id='calcDetailForm']/div[2]/div[2]/div[2]/a/span";
		public static final String btnCalcSave2="//*[@id='calcDetailForm']/div[4]/button/span";
	//checkbox
		//xpath
		public static final String chkBoxCalc1="//*[@id='calculationsContainer']/div[2]/div[3]/div[1]/div[2]/input";
	//drpDown
		public static final String drpDownCalcShowDefault="//*[@id='calculationsContainer']/div[3]/div[2]/div[2]/div[2]/a/span/a";
	//label
		public static final String lblGrassSeedTotalArea="//*[@id='calcDetailForm']/div[2]/div[1]/h4[1]";
		public static final String lblGrassSeedQty="//*[@id='calcDetailForm']/div[2]/div[1]/h4[2]";
	/****************Project Calculators Page************************/	
	//link
		//xpath
		public static final String lnkGrassSeedCalc="//*[@id='calcLinkList']/li[8]/a";
		
	/****************Calculator Page************************/	
	//radio button
		//id
				//mulch
		public static final String rdoBtnEnterSqFootage="knownDimensions";
	//drop-down
		//id
		public static final String drpDownCalcProductType="productType";
		//css selector
		public static final String drpDownCalcResultSaveSpace="div.save-results.clearfix > select";
	//button
		//xpath		
		public static final String btnMulchCalculate="//*[@id='mulchCalculator']/div[2]/div/div[1]/div[3]/div/div[4]/button";
		
		public static final String btnCalcResultSave="//*[@id='mulchCalculator']/div[2]/div/div[2]/div/div[4]/a/span";
		public static final String btnCalcResultSave2="//*[@id='saveDialogContent']/div/button";	
	//text box
		//id
		public static final String txtCalcArea="areaTotal";
		public static final String txtMulchDepth="mulchDepth";
		public static final String txtCalcResultTitle="resultsTitle";
		//xpath
		public static final String txtCalcName1="//*[@id='name']";
	/****************Lists Page************************/
	//WebElements
		//xpath
		public static final String webElmntListShow="//*[@id='showOnly']/a/span";
		public static final String webElmntListShowAllItems="//*[@id='showOnly']/ul/li[1]/a";
		public static final String webElmntListItem1Name="//*[@id='itemList']/div[2]/div[2]/div[1]/h5/a";
	/****************Purchases Page************************/
	//WebElements
		//xpath	
		public static final String webElmntBrdCrumbsLvl3 = "//*[@id='breadcrumbs']/ul/li[3]";
		public static final String webElmntPurchaseDetailsHeading="//*[@id='order_detail']/h3/span";
		public static final String webElmntOrderItemName="//*[@id='order_detail']/div[2]/div[1]/div/div[2]/h5";
		public static final String webElmntOrderItemName2 ="//*[@id='order_detail']/div[2]/div[2]/div/div[2]/h5/a";
		public static final String webElmntItemViewItemName="//*[@id='itemView']/ul[1]/li/div[2]/h3";
		public static final String webElmntSaveFrmPurchases="//div/span[contains(text(),'Add To')]";
		public static final String webElmntSaveToHPFrmPurchases="//div/ul/li/a/span[contains(text(),'Home Profile')]";
		public static final String webElmntPurchasesItemView="//*[@id='purchaseControls']/div/a[1]";
		//css
		public static final String webElmntSavedTrue="css=span.check";
		
		
		
	//drop-down
		//id
		//public static final String drpDownPurchaseType= "purchase-method";
		//public static final String drpDownPurchaseDate= "transaction-date";
	//link
		//xpath
		public static final String lnkPurchaseViewOrderNbr="//*[@id='orderView']/tbody/tr[1]/td[2]/a";
	/****************Photos Tab Page************************/
		//WebElements
		//xpath
		public static final String webElmntPhotosCount="//*[@id='total_photo_items']";
		public static final String webElmntPhoto1Thumbnail="//*[@id='photosContainer']/div[2]/div[3]/div[1]";//from space page
		public static final String webElmntPhoto1Thumbnail1="//*[@id='photosContainer']/div[1]/div[2]/div[3]/div[1]";//from Show all Photos
		public static final String webElmntPhoto2Thumbnail="//*[@id='photosContainer']/div[2]/div[3]/div[2]";//from space page
		public static final String webElmntPhoto1Name="//*[@id='photosContainer']/div[2]/div[3]/div[1]";
		public static final String webElmntPhoto2Name="//*[@id='photosContainer']/div[2]/div[3]/div[2]";
		public static final String webElmntPhoto1NameDisp="//*[@id='photosContainer']/div[2]/div[3]/div[1]/p[2]/a[2]";
		public static final String webElmntPhoto2NameDisp="//*[@id='photosContainer']/div[2]/div[3]/div[2]/p[2]/a[2]";
		public static final String webElmntPhoto1TrashCan="//*[@id='photosContainer']/div[2]/div[3]/div[1]/p[2]/a[1]";//from space page
		public static final String webElmntPhoto1TrashCan1="//*[@id='photosContainer']/div[1]/div[2]/div[3]/div[1]/p[2]/a[1]";//from Show All Photos
		public static final String webElmntPhoto2TrashCan="//*[@id='photosContainer']/div[2]/div[3]/div[2]/p[2]/a[1]";//from space page
		public static final String webElmntPhotosSortByDownArrow="//*[@id='photosContainer']/div[2]/div[2]/div[3]/div[2]/a/span/b";
		public static final String webElmntPhotosShowDownArrow="//*[@id='photosContainer']/div[2]/div[2]/div[2]/div[2]/a/span/b";
		public static final String webElmntPhotosShowDownArrow2="//*[@id='photosContainer']/div[1]/div[2]/div[2]/div[2]/div[2]/a/span/b";
		public static final String webElmntPhotosUploadSuccessMsg="//*[@id='upload-modal-2']/ul/li/div/div/p";
		public static final String webElmntNoPhotoImg="//*[@id='photosContainer']/div[3]/div[4]/img";
		public static final String webElmntPhotoSortByDownArrow="//*[@id='photosContainer']/div[1]/div[2]/div[2]/div[3]/div[2]/a/span/b";//from All Photos
		public static final String webElmntPhotoInvalidNotesMsg="//div[21]/div[2]/div/p";
		public static final String webElmntPhotoDetailNote="//*[@id='photo-note']/p/div[3]/textarea";
		public static final String webElmntPhotoDetailNoteCharRemaining="//*[@id='photo-note']/p/div[3]/p/span";
		public static final String webElmntPhotoDetailUnassignSpace="//*[@id='lowesPhotoModal']/div[2]/div[3]/div/span/a[2]";
		
	//button
		//xpath
		public static final String btnUpload="//*[@id='photosContainer']/div[2]/div[2]/div[1]/a/span";
		public static final String btnUpload2="//*[@id='photosContainer']/div[1]/div[2]/div[2]/div[1]/a/span";//from All Photos
		public static final String btnUploadPhotos="//*[@id='photosContainer']/div[3]/div[3]/p[2]/a/span";
		public static final String btnPhotoInvalidNote="//div[21]/div[2]/div/button";
		public static final String btnPhotoDetailSpaceApply="//*[@id='space-select-listing']/div/div[2]/div/button";
		public static final String btnPhotoDetail="//*[@id='lowesPhotoModal']/div[2]/div[4]/button";
	//label
		//xpath
		public static final String lblShowInPhotos="//*[@id='photosContainer']/div[2]/div[2]/div[2]/div[1]";
		public static final String lblShowInPhotos2="//*[@id='photosContainer']/div[1]/div[2]/div[2]/div[2]/div[1]";//from All Photos
		public static final String lblSortInPhotos="//*[@id='photosContainer']/div[2]/div[2]/div[3]/div[1]";
		public static final String lblSortInPhotos2="//*[@id='photosContainer']/div[1]/div[2]/div[2]/div[3]/div[1]";//from All photos
		public static final String lblNoPhotosShow="//*[@id='photosContainer']/div[3]/div[2]/div[2]/div[1]";
		public static final String lblPhotoDetailName="//*[@id='edit_photo_name']/h3/div[1]/span";
		public static final String lblPhotoDetailSpace4="//*[@id='space-select-listing']/div/div[1]/ul/div/div/li[4]/label/span";
		public static final String lblPhotoDetailLocatedIn="//*[@id='lowesPhotoModal']/div[2]/div[3]/div/span/a[1]";
		public static final String lblPhotoDetailSavedNotes="//*[@id='photo-note']/p/div[1]/span";
	//link
		public static final String lnkPhotosSortByMostRecent="//*[@id='photosContainer']/div[2]/div[2]/div[3]/div[2]/ul/li[1]/a";
		public static final String lnkPhotosSortByMostRecent2="//*[@id='photosContainer']/div[1]/div[2]/div[2]/div[3]/div[2]/ul/li[1]/a";//from All Photos
		public static final String lnkPhotosSortByAtoZ="//*[@id='photosContainer']/div[2]/div[2]/div[3]/div[2]/ul/li[2]/a";
		public static final String lnkPhotosSortByAtoZ2="//*[@id='photosContainer']/div[1]/div[2]/div[2]/div[3]/div[2]/ul/li[2]/a";//from All Photos
		public static final String lnkPhotosShowProducts="//*[@id='photosContainer']/div[2]/div[2]/div[2]/div[2]/ul/li[1]/a";
		public static final String lnkPhotosShowPhotos="//*[@id='photosContainer']/div[2]/div[2]/div[2]/div[2]/ul/li[2]/a";
		public static final String lnkPhotosShowDocs="//*[@id='photosContainer']/div[2]/div[2]/div[2]/div[2]/ul/li[3]/a";
		public static final String lnkPhotosShowCalc="//*[@id='photosContainer']/div[2]/div[2]/div[2]/div[2]/ul/li[4]/a";
		public static final String lnkPhotosShowDim="//*[@id='photosContainer']/div[2]/div[2]/div[2]/div[2]/ul/li[5]/a";
		public static final String lnkPhotoUndo="//*[@id='photosContainer']/div[1]/div[2]/div[3]/div[1]/p[1]/a";//from all Photos
		public static final String lnkPhotoUndo1="//*[@id='photosContainer']/div[2]/div[3]/div[1]/p[1]/a";//from space
		public static final String lnkPhoto1Name="//*[@id='photosContainer']/div[1]/div[2]/div[3]/div[1]/p[2]/a[2]";
		public static final String lnkPhotosShowAllSpaces="//*[@id='photosContainer']/div[1]/div[2]/div[2]/div[2]/div[2]/ul/li[1]/a";
		public static final String lnkPhotosShowAllProducts="//*[@id='photosContainer']/div[1]/div[2]/div[2]/div[2]/div[2]/ul/li[2]/a";
		public static final String lnkPhotosShowAllPhotos="//*[@id='photosContainer']/div[1]/div[2]/div[2]/div[2]/div[2]/ul/li[3]/a";
		public static final String lnkPhotosShowAllDocs="//*[@id='photosContainer']/div[1]/div[2]/div[2]/div[2]/div[2]/ul/li[4]/a";
		public static final String lnkPhotoDetailNameEdit="//*[@id='edit_photo_name']/h3/div[1]/a";
		public static final String lnkPhotosNotesCancel="//*[@id='space_notes']/div/a[2]";
		public static final String lnkPhotoDetailAddToSpaces="//*[@id='lowesPhotoModal']/div[2]/div[3]/a/span";
	//dropdown
		public static final String lnkPhotoMostRecent="//*[@id='photosContainer']/div[1]/div[2]/div[2]/div[3]/div[2]/a/span/a";
	//checkbox
		//xpath
		public static final String chkBoxPhotoDetailSpace4="//*[@id='space-select-listing']/div/div[1]/ul/div/div/li[4]/label/input";
		/**
		 * UI Map for MasterPage 
		 */
		

			/*******************************************START MYLOWES*****************************************************/
			
			//webElements MyLowes
			public static final String webElmntManageCrdeitCard = "a[title=\"Manage Credit Card\"]";
			public static final String webElmntMakePrimary = "//div[7]/div[3]/span[4]/input";
			//public static final String webElmntMakePrimary = "(//input[@id='manage-cc-edit-cc-make-primary'])[2]";
			public static final String webElmntEditSCCard = "//div[7]/div[2]/div/a";
			public static final String webElmntEditPCCard = "//div[6]/div[2]/div/a";
			public static final String webElmntEditAccInfo= "//*[@id='dashboard']/div/div[1]/div[2]/div[2]/a";
			public static final String webElmntChangeName= "//*[@id='manage-account-info']/div[1]/div[2]/div[2]/a";
			public static final String webElmntChangeEmail= "//*[@id='manage-account-info']/div[2]/div[2]/div[2]/a";
			public static final String webElmntChangePassword= "//*[@id='manage-account-info']/div[3]/div[2]/div[2]/a";
			public static final String webElmntChangeBCode= "//*[@id='manage-account-info']/div[4]/div[2]/div[2]/a";
			public static final String webElmntEditPAddress= "//*[@id='dashboard']/div/div[2]/div[2]/div[2]/a";
			public static final String webElmntEditAddressPreferences= "//div[2]/div[2]/div[2]/a";
			public static final String webElmntUspsAddress = "//div[2]/div/div[2]/input";
			public static final String webElmntCnfrmUspsAddress = "//div[3]/a/span";
			public static final String webElmntCancelEditPriAddress = "//div[4]/div/div[2]/div[2]/div/a";
			public static final String webElmntCancelEditSecAddress = "//div[3]/div[2]/div/a";
			public static final String webElmntSetItemForReminder = "//div[@id='productRight']/div[2]/ul/li[2]/a/span";
			public static final String webElmntChangeAddressSubscribe = "//*[@id='address_form']/ul/li[2]/label[2]/input";
			public static final String webElmntSeeYourCatalog = "//a[contains(text(),'See Your Catalog')]";
			public static final String webElmntCompare1 = "//div[@id='header_container']/div[2]/div/table/tbody/tr[2]/td/div[2]/a";
			public static final String webElmntCompare2 = "//div[@id='header_container']/div[3]/div/table/tbody/tr[2]/td/div[2]/a";
			public static final String webElmntReminderFAQPage = "//*[@id='one-column']/div[4]/div/div[1]/div/p[2]/a";
			
			
			
			// Links MyLowes
			public static final String lnkMasterHeadSignUp = "//a[@name='MASTHEAD_Account_SignUp']";
			public static final String lnkMasterHeadSignIn = "//a[@name='MASTHEAD_Account_SignIn']";
			public static final String lnkClickSignInMyLowes = "//*[@id='Logon']/div/div/p/a";
			public static final String lnkDisableAutoZip = "//*[@id='disable-autozip']";
			public static final String lnkSignIn = "//a[contains(text(),'Sign In')]";
			public static final String lnkMylowesLandingPage = "//*[@id='header-block']/div[3]/ul/li[5]/a/span";
			public static final String lnkMylowesLandingPageSignIn = "//*[@id='registrationForm']/p[1]/a";
			public static final String lnkSignInClose = "//div[9]/div/a/span";
			public static final String lnkClickYourAccount = "//*[@id='nav-my-account']/span[2]";
			public static final String lnkRebateOnlineSubmission = "//div/div/div/div/div/ul/li[2]/a";
			public static final String lnkRebateRebateStatus = "//div[3]/div/div/div/div/div/ul/li[3]/a";
			public static final String lnkViewAllReminders = "//div[3]/h3/a/span";
			public static final String lnkManageCreditCard= "//*[@id='dashboard']/div/div[3]/div[2]/div[2]/a";
			public static final String lnkAddCreditCardInternally = "//h3/a/span";
			public static final String lnkEditAccInfo = "//*[@id='manage-account-info']/h3/span";
			public static final String lnkDeleteAddedCard="(//a[contains(text(),'Delete')])[3]";
			
			
			//buttons MyLowes
			public static final String btnRegisterSubmit = "//div[@id='registerSubmit']/button";
			public static final String btnCreateAccount2 = "//*[@id='GoYourAccount']";
			public static final String btnCreateAccountSignUp = "//*[@id='createAccount']";
			public static final String btnViewAllPurchaces= "//div[@id='dashboard_orders']/h3/a/span";
			public static final String btnViewAllReminders= "//div[@id='reminders']/h3/a/span";
			public static final String btnViewAllLists= "//div[@id='product_list']/h3/a/span";
			public static final String btnYourAccount= "//a[@id='nav-my-account']/span[2]";
			public static final String btnDeleteManageCreditCard = "(//a[contains(text(),'Delete')])[2]";
			public static final String btnCfrmDeleteManageCreditCard = "(//button[@id='bt_confirm_delete_card'])[2]";
			public static final String btnSaveEditManageCreditCard = "(//button[@id='bt_manage_cc_save_edit_cc'])[2]";
			public static final String btnSaveEditPAddress = "(//button[@type='submit'])[5]";
			public static final String btnCancelCBCUser = "(//button[@type='button'])[5]";
			public static final String btnCfrmUSPSAddress = "//a[@id='btAddrConfirm']/span";
			public static final String btnAddAddress = "(//button[@type='submit'])[4]";
			public static final String btnCheckAddressFields = "(//button[@type='submit'])[6]";
			public static final String btnbutton3 = "(//button[@type='button'])[3]";
			public static final String btnCnfrmCancelPriAddress = "(//a[contains(text(),'Cancel')])[2]";
			//css
			public static final String btnCloseHelp = "span.ui-icon.ui-icon-closethick";
			//xpath
			public static final String btnSaveDisabled = "//a[@id='subscriptionsSubmit']/span";
			public static final String btnSaveSubscription = "//*[@id='subscriptionsSubmit']/span";
			public static final String btnSubscriptionCreateAccount = "//*[@id='subscriptions_create_account']";
			public static final String btnCancelAccountDeactivate = "//*[@id='bt_deactivate_account_cancel']";
			public static final String btnSubmitAccountDeactivate = "//*[@id='bt_deactivate_account_submit']/span";
			//public static final String btnAddToCart = "//li[2]/div/a/span";
			public static final String btnCheckOut = "(//button[@type='button'])[4]";
			public static final String btnCompare = "//div[@id='itemBar']/div/a/span";
			public static final String btnSecureCheckOut = "//a[@id='revpay_com_order']/span";
			public static final String btnShopCart = "//form[@id='ShopCartForm']/div[5]/div[2]/div[2]/span/a[2]/span";
			public static final String btnGuestUserCheckOut = "//div[@id='login-container']/div/div/div[2]/div/a/span";
			public static final String btnSignInPaintToSelectSpace = "//*[@id='paintCalculator']/div[3]/div/div[2]/div/div[2]/a/span";
			public static final String btnPaintCalSaveToHome = "//*[@id='paintCalculator']/div[3]/div/div[2]/div/div[2]/select";
			public static final String btnSignInGSDToSelectSpace = "//*[@id='seedCalculator']/div[2]/div/div[2]/div/div[3]/a/span";
			public static final String btnGSDCalSaveToHome = "//*[@id='seedCalculator']/div[2]/div/div[2]/div/div[3]/select";
			
			
			
			
			// Labels MyLowes
			public static final String lblSignIn = "Sign In";
			public static final String lblModalAccount = "//div[@id='modal_iframe_account']";
			public static final String lblMyLowesSignUp= "//*[@id='registrationForm']/h1";
			public static final String lblBreadCrumb2= "//*[@id='breadcrumbs']/ul/li[2]";
			public static final String lblBreadCrumb3= "//*[@id='breadcrumbs']/ul/li[3]";
			public static final String lblBreadCrumb4= "//*[@id='breadcrumbs']/ul/li[4]";
			public static final String lblAccoountSummary= "//*[@id='mylowes-account-info']/h3/span";
			public static final String lblEditAccount= "//*[@id='mylowes-account-info']/div[1]/div[1]/div[2]/p[1]/a";
			public static final String lblEditAddress= "//*[@id='mylowes-account-info']/div[1]/div[1]/div[2]/p[2]/a[2]";
			public static final String lblEditPreferences= "//*[@id='mylowes-account-info']/div[1]/div[1]/div[2]/a";
			public static final String lblManageMylowesCard= "//*[@id='mylowes-account-info']/div[1]/div[3]/div[2]/a";
			public static final String lblCreditCardServices= "//*[@id='mylowes-account-info']/div[1]/div[5]/div/ul/li[2]/a";
			public static final String lblSubscriptions = "//*[@id='mylowes-account-info']/div[1]/div[5]/div/ul/li[3]/a";
			public static final String lblRebates = "//*[@id='mylowes-account-info']/div[1]/div[5]/div/ul/li[4]/a";
			public static final String lblYourStore = "//*[@id='mylowes-account-info']/div[1]/div[5]/div/ul/li[6]/a";
			public static final String lblChangeStore = "//*[@id='mylowes-account-info']/div[1]/div[5]/div/ul/li[8]/a";
			public static final String lblViewAllReminders= "//*[@id='reminders']/h3/span";
			public static final String lblViewAllPurchaces= "//*[@id='dashboard_orders']/h3/span";
			public static final String lblViewAllLists= "//*[@id='product_list']/h3/span";
			public static final String lblPurchases = "//*[@id='nav_purchases']/a";
			public static final String lblLists = "//*[@id='nav_portfolio']/a";
			public static final String lblPreferences = "//*[@id='nav_profile']/a";
			public static final String lblMyLowesLeftNav = "//li[@id='nav_account']/a";
			public static final String lblHomeProfile = "//*[@id='nav_homeprofile']/a";
			public static final String lblManageSettings = "//*[@id='mylowes-account-info']/div[1]/div[5]/div/ul/li[1]/span";
			public static final String lblReminders = "//div[3]/h3/span";
			public static final String lblManageCreditCard = "//*[@id='dashboard']/div/div[3]/div[1]/div[2]";
			public static final String lblEnterCreditCardInfo = "//*[@id='manage_cc_add_cc']/div/h4";
			public static final String lblEditAccInfo = "//*[@id='dashboard']/div/div[1]/div[1]/div[2]";
			public static final String lblAccName = "//*[@id='manage-account-info']/div[1]/div[2]/span/strong";
			public static final String lblAccEmail = "//*[@id='manage-account-info']/div[2]/div[2]/span/strong";
			public static final String lblAccPassword = "//*[@id='manage-account-info']/div[3]/div[2]/span/strong";
			public static final String lblAccBCode = "//*[@id='manage-account-info']/div[4]/div[2]/span/strong";
			public static final String lblSubscriptionsHeading = "//*[@id='subscriptionsForm']/div/h3/span";
			public static final String lblENewsletters = "//*[@id='subscriptionsForm']/div/div[1]/div[1]/ul/li[1]/h5";
			public static final String lblPrintPublications = "//*[@id='subscriptionsForm']/div/div[1]/div[1]/ul/li[6]/h5";
			public static final String lblPrimaryAddress1 = "(//input[@id='address1'])[2]";
			public static final String lblPrimaryCity = "(//input[@id='city'])[2]";
			public static final String lblPrimaryState = "(//select[@id='state'])[2]";
			public static final String lblPrimaryZipCode = "(//input[@id='zipCode'])[2]";
			public static final String lblEditAddress1 = "(//input[@id='addressField1'])[2]";
			public static final String lblEditAddress2 = "(//input[@id='addressField2'])[2]";
			public static final String lblEditFname = "(//input[@id='firstName'])[2]";
			public static final String lblEditLname = "(//input[@id='lastName'])[2]";
			public static final String lblEditaddress = "(//input[@id='address2'])[2]";
			public static final String lblEditPhone = "(//input[@name='phone1'])[2]";
			public static final String lblPhoneFirst = "//*[@id='ab_phone_area_code']";
			public static final String lblPhoneMiddle = "//*[@id='ab_phone_middle_three']";
			public static final String lblPhoneLast = "//*[@id='ab_phone_last_four']";
			public static final String lblEmailText1 = "//*[@id='reminders_modal']/p[1]";
			public static final String lblEmailText2 = "//*[@id='reminders_modal']/p[2]";
			public static final String lblSearchItemName = "//form[@id='frmQuickSearch']/span/button";
			public static final String lblSubscriberEmail = "//*[@id='existing_Email']";
			public static final String lblUnSubscribe = "//*[@id='subscriptionsForm']/div/div[1]/div[2]/div/div[3]/p/a";
			public static final String lblChangeAddressSubscribe = "//*[@id='subscriptionsForm']/div/div[1]/div[2]/div/div[1]/p/a";
			public static final String lblEnterSubscriberDetails = "//*[@id='email_form']/h5";
			public static final String lblEnterEmailID = "//*[@id='emailId']";
			public static final String lblChangeAddress = "//div[4]/div[2]/span/strong/span";
			public static final String lblDeactivateDashboard = "//*[@id='dashboard']/div/h3/div/a/span";
			public static final String lblPhoneField = "//*[@id='phone1']";
			public static final String lblCBCBusinessName = "//li[@id='lowes-salutation-active']/a/span";
			public static final String lblCBCBannerName = "//div[@id='cbc-global-banner-enhanced']/div";
			public static final String lblCBCCompanyName = "//div[@id='cbc-global-banner-enhanced']/div/h2";
			public static final String lblCBCMyOrders = "//div[@id='cbc-global-banner-enhanced']/div[2]/div/h3";
			public static final String lblCBCMyCatalogs = "//div[@id='cbc-global-banner-enhanced']/div[2]/div[2]/h3";
			public static final String lblYourContractPrice = "//img[@alt='Your Contract Price']";
			public static final String lblCompare1 = "//li/div/div/div/input";
			public static final String lblCompare2 = "//li[2]/div/div/div/input";
			public static final String lblProPrice = "//img[@alt='Pro Price']";
			public static final String lblProPrice2 = "(//img[@alt='Pro Price'])[2]";
			public static final String lblCheckOutCreditCardNo = "//div[@id='cc-add']/fieldset[2]/ol/li[2]/div/input";
			public static final String lblCheckOutLCCCreditCardNo = "//*[@name='cardNumber']";
			public static final String lblReminderWelcomeMsg = "//*[@id='one-column']/div[4]/div/div[1]/a";
			public static final String lblDelDisplayedForReminders1 = "//*[@id='remindersList']/div[2]/div[3]/div[1]/a[2]";
			public static final String lblDelDisplayedForReminders2 = "//*[@id='remindersList']/div[3]/div[3]/div[1]/a[2]";
			public static final String lblMatchReminder1 = "//*[@id='remindersList']/div[2]/div[2]/div[1]/div[2]/h5/a";
			public static final String lblMatchReminder2 = "//*[@id='remindersList']/div[3]/div[2]/div[1]/div[2]/h5/a";
			public static final String lblMatchLandingReminder1 = "//*[@id='reminders']/table/tbody/tr[1]/td[2]/a[1]";
			public static final String lblMatchLandingReminder2 = "//*[@id='reminders']/table/tbody/tr[2]/td[2]/a[1]";
			public static final String lblCardName="//div[7]/div[2]/span/strong/span";
			
			//text MyLowes
			public static final String txtMyLowesBreadCrumb= "MyLowe's";
			public static final String txtAccountSummary= "Account Summary";
			public static final String txtEditAccount= "Edit Account Information";
			public static final String txtAccInfo= "Account Information";
			public static final String txtSignIn = "//*[@id='Logon']/div/div/h1";
			public static final String txtMyLowesSignUp= "Sign Up";
			public static final String txtMyLowesCardName= "//*[@id='mylowes-account-info']/div[1]/div[3]/div[2]/span";
			public static final String txtMyLowesCardNo= "//*[@id='mylowes-account-info']/div[1]/div[3]/div[2]/p";
			public static final String txtManageSettings = "Manage Settings";
			public static final String txtReminders = "Reminders";
			public static final String txtManageCreditCard = "Credit Cards"; 
			public static final String txtManageCreditCards= "//*[@id='manage-cc']/h3/span";
			public static final String txtSCCardNickName= "(//input[@name='ccNickName'])[3]";
			public static final String txtSCCardMonth = "(//select[@name='exMonth'])[3]";
			public static final String txtSCCardYear = "(//select[@name='exYear'])[3]";
			public static final String txtAccName ="Name";
			public static final String txtAccEmail ="Email Address";
			public static final String txtAccPassword ="Password";
			public static final String txtAccBCode ="Benefit Code";
			public static final String txtSubscriptions ="Subscriptions";
			public static final String txtENewsletters ="E-Newsletters";
			public static final String txtPrintPublications ="Print Publications";
			public static final String txtElementDisplayed ="//h3/a";
			public static final String txtGetNameFromPL ="//*[@id='descCont']/div[1]/h1";
			public static final String txtGetNameFromReminderyourAccount ="//*[@id='remindersList']/div[2]/div[2]/div[1]/div[2]/h5/a";
			public static final String txtDeactivateCnfrm ="//*[@id='content-area-no-nav']/h2";
			
			
			//img MyLowes
			public static final String imgHelpIconPresent ="//*[@id='addReminderHelpTrigger']/img";
			
			
			/*******************************************END MYLOWES*****************************************************/
			
			
			/*******************************************START PBC*****************************************************/
			
			//WebElmnt PBC
			public static final String webElmntCreateHomeProfile = "//a[@id='create_profile_link']/span";
			public static final String webElmntIdeasHowDos = "//div[@id='header-block']/div[3]/ul/li[3]/a/span";
			public static final String webElmntChooseProject = "(//a[contains(text(),'Choose a Project')])[2]";
			public static final String webElmntCalculator = "a[title=\"Calculator\"]";
			public static final String webElmntGSCalculator = "//a[contains(text(),'Grass Seed Calculator')]";
			public static final String webElmntMulchCalculator = "//a[contains(text(),'Mulch Calculator')]";
			public static final String webElmntFertiCalculator = "//a[contains(text(),'Fertilizer Calculator')]";
			public static final String webElmntPaintCalculator = "//a[contains(text(),'Paint Calculator')]";
			public static final String webElmntMulchVolResults = "//form[@id='mulchCalculator']/div[2]/div/div[2]/div/div/div/select";
			public static final String webElmntFertiReleaseDateHelp = "//form[@id='fertCalculator']/div[2]/div/div/div[2]/div/a/strong";
			public static final String webElmntFertiReleaseDateHelpClose = "//div[9]/div/a/span";
			public static final String webElmntFertiDeliverySystemHelp = "//form[@id='fertCalculator']/div[2]/div/div/div[3]/div/a/strong";
			public static final String webElmntFertiDeliverySystemHelpClose = "//div[10]/div/a/span";
			public static final String webElmntMulchTotalAreaSelect = "//form[@id='mulchCalculator']/div[2]/div/div/div/div/div[4]/select";
			public static final String webElmntAddDimensions = "//a[contains(text(),'Add Dimensions')]";
			public static final String webElmntFertiFutureProjectSelect = "//form[@id='fertCalculator']/div[2]/div/div[2]/div/div[4]/select";
			public static final String webElmntFertiFutureProjectSelectSave = "//form[@id='fertCalculator']/div[2]/div/div[2]/div/div[4]/a/span";
			public static final String webElmntMulchTypeHelp = "//*[@id='mulchCalculator']/div[2]/div/div[1]/div[2]/div/h2/a/strong";
			public static final String webElmntMulchDepthHelp = "//*[@id='mulchCalculator']/div[2]/div/div[1]/div[3]/div/h2/a/strong";
			public static final String webElmntMulchFutureProjectSelect = "//*[@id='mulchCalculator']/div[2]/div/div[2]/div/div[4]/select";
			public static final String webElmntMulchFutureProjectSelectSave = "//*[@id='mulchCalculator']/div[2]/div/div[2]/div/div[4]/a/span";
			public static final String webElmntPaintFutureProjectSelect = "//form[@id='paintCalculator']/div[3]/div/div[2]/div/div[2]/select";
			public static final String webElmntPaintFutureProjectSelectSave = "//form[@id='paintCalculator']/div[3]/div/div[2]/div/div[2]/a/span";
			
			public static final String webElmntSelectYard = "(//a[contains(text(),'Yard')])[2]";
			public static final String webElmntSelectProductList = "//div[@id='product_list']/div[2]/div[2]/div[2]/a/span/b";
			public static final String webElmntSelectDimensions = "//a[contains(text(),'Dimensions')]";
			public static final String webElmntClickSpaceShapes = "//div[@id='accordion']/h3";
			public static final String webElmntCnfrmSwitchShapes = "//div[@id='dialog_confirm_change_shape']/p[3]/a/span";
			public static final String webElmntShapeRect = "//div[@id='shape_rect']";
			public static final String webElmntTabsDimensions = "//div[@id='tabs_dimensions']/div[2]/div/div[2]/a/span/b";
			public static final String webElmntCalculations = "(//a[contains(text(),'Calculations')])[6]";
			public static final String webElmntShowDetails3 = "(//a[contains(text(),'Show Details')])[3]";
			public static final String webElmntShowDetails2 = "(//a[contains(text(),'Show Details')])[2]";
			public static final String webElmntShowDetails1 = "//a[contains(text(),'Show Details')]";
			public static final String webElmntSubPaintHelp = "//div[@id='checkRefine']/a/strong";
			public static final String webElmntViewAllProjectCal = "//a[contains(text(),'View All Project Calculators')]";
			public static final String webElmntBathroom = "(//a[contains(text(),'Bathroom')])[3]";
			
			
			//buttons PBC
			public static final String btnVolRes = "div.volume-results-holder.clearfix > select > option[value=\"1\"]";
			public static final String btnDelArea2 = "//li[@id='area2']/a/b";
			public static final String btnWallArea2 = "//li[@id='wall2']/a/b";
			public static final String btnShopSeed = "//form[@id='seedCalculator']/div[2]/div/div[2]/div/div[2]/div/a/span";
			public static final String btnShopMulch = "//form[@id='mulchCalculator']/div[2]/div/div[2]/div/div[3]/div/a/span";
			public static final String btnShopFerti = "//form[@id='fertCalculator']/div[2]/div/div[2]/div/div[3]/div/a/span";
			public static final String btnShopPaint = "//div[@id='coverage']/div[2]/a/span";
			public static final String btnContinueSelectedShape = "//div[@id='section_shapes']/div[3]/a/span";
			public static final String btnFinishYardRectShape = "//div[@id='section_openings']/div[3]/a/span";
			public static final String btnFinishBathroomRectShape = "//div[@id='section_openings']/div[2]/a/span";
			public static final String btnDeleteSpace = "//a[@id='delete_space']/span";
			public static final String btnCnfrmDeleteSpace = "//div[@id='delete_space_dialog']/div/div[3]/button";
			
			
			//txt PBC
			public static final String txtSignInToSelectSpace ="Sign In to Select a Space";
			public static final String txtCreateHP ="Create a Home Profile";
			public static final String txtAddDimensions ="Add Dimensions";
			public static final String txtDisclaimerSeed = "*Actual quantities may vary by application method and brand. Check product labels for spread rates. Grass seed estimates don’t apply to pastures.";
			public static final String txtDisclaimerMulch = "*Actual product quantities may vary depending on the mulch brand and surface of the area being mulched.";
			public static final String txtDisclaimerFerti = "*Coverage amounts and application rates vary by fertilizer brand and type. Check product labels for details. Applying too much fertilizer at once may burn your lawn.";
			public static final String txtSeedCalResults = "Seed Calculator Results";
			public static final String txtMulchCalResults = "Mulch Calculator Results";
			public static final String txtFertiCalResults = "Fertilizer Calculator Results";
			public static final String txtPaintCalResults = "Paint Calculator Results";
			
			
			//lbl PBC
			public static final String lblShopSeedDisclaimer = "//*[@id='seedCalculator']/div[2]/div/div[2]/div/div[2]/div[2]/p";
			public static final String lblShopSeedDisclaimer2 = "//*[@id='seedCalculator']/div[2]/div/div[2]/div/div[2]/div[2]/p[2]";
			public static final String lblShopMulchDisclaimer = "//form[@id='mulchCalculator']/div[2]/div/div[2]/div/div[3]/div[2]/p";
			public static final String lblShopFertiDisclaimer = "//form[@id='fertCalculator']/div[2]/div/div[2]/div/div[3]/div[2]/p";
			public static final String lblRectDimension = "(//input[@id='length_ft'])[2]";
			public static final String lblCnfrmYardRectDimension = "//div[16]/div/div[4]/div/a";
			public static final String lblCnfrmBathRoomRectDimension = "//div[15]/div/div[4]/div/a/span";
			
			
			/*******************************************END PBC*****************************************************/		
		
//////////////////////////////////Sivani
			
			/**********Home Page*********************/
			
			//Links
			//id
			//public static final String lnkLists= "nav-portfolio";
			public static final String btnFindAStore = "nav-button-store-search";
			
			//MouseHover
			//id
			public static final String mouseHvrYourAccount = "nav-my-account";
			//xpath
			public static final String mouseHvrHeaderBlock = "//*[@id='header-block']/div[3]/ul/li[3]/a/span[1]";
			
			//buttons
			//xpath
			public static final String btnSignInFrame = "//*[@id='Logon']/div/div/p/a";
			
			
			
			/********My Lowes Page******************/
			
			//Links
			
			//css
			public static final String lnkMyLowes = "a[name=\"MASTHEAD_MyLowes\"] > span";
			public static final String lnkManageMyLowes = "//*[@id='mylowes-account-info']/div[1]/div[3]/div[2]/a";
			public static final String lnkListsFromMyLowes = "#nav_portfolio > a";
			public static final String lnkStartTracking = "Start In-Store Purchase Tracking";
			public static final String lnkMLCReqRplcmnt = "//*[@id='mylowes-account-info']/div[1]/div[3]/div[2]/a";
			public static final String lnkPurcahses = "nav-my-order";
			public static final String lnkMLcReqRplcmntbtn = "a.mylowes-panel-btn.request-replacement > span";
			
			
			//xpaths
			public static final String txtPresentFirstName = "//form[@id='registrationForm']/ul[2]/li/label[2]";
			public static final String txtPresentLastName = "//form[@id='registrationForm']/ul[2]/li[2]/label[2]";
			public static final String txtPresentEmail = "//form[@id='registrationForm']/ul[3]/li/label[2]";
			public static final String txtPresentPhone = "//form[@id='registrationForm']/ul[3]/li[2]/label[2]";
			public static final String txtPresentRegPassword = "//form[@id='registrationForm']/ul[5]/li/label[2]";
			public static final String txtPresentConfPassword = "//form[@id='registrationForm']/ul[5]/li[2]/label[2]";
			
			
			public static final String txtBoxPresentFirstName = "//*[@id='registrationForm']/ul[2]/li[1]/label";
			public static final String txtBoxPresentLastName = "//*[@id='registrationForm']/ul[2]/li[2]/label";
			public static final String txtBoxPresentEmail = "//*[@id='registrationForm']/ul[3]/li[1]/label";
			public static final String txtBoxPresentPhone = "//*[@id='registrationForm']/ul[3]/li[2]/label";
			public static final String txtBoxPresentRegPassword = "//*[@id='registrationForm']/ul[5]/li[1]/label";
			public static final String txtBoxPresentConfPassword = "//*[@id='registrationForm']/ul[5]/li[2]/label";
			
			//id
			public static final String txtCnfrmMsgDisplay= "//*[@id='ConfirmationMessageDisplay']/div/h3/strong";
			
			//name
			public static final String txtCardNo ="keyfob";
			
			//check box
			
			//xpath
			public static final String chkBoxPresentSubscriptions = "//*[@id='signup-subscriptions']";

			
			//Buttons
			
			//id
			public static final String btnCardRegister= "card-register"; 
			public static final String btnCreateAccount = "createAccount";
			public static final String btnSignIn = "GoYourAccount";	
			public static final String btnCardRegSubmit = "mlcRegistration";
			
			
			//xpath
			public static final String btnDeactivateCard = "//div[8]/div[2]/a/span";
			public static final String btnReqRplcmntCardSubmit = "(//button[@type='submit'])[4]";
			public static final String btnRegMyLowesCard = "//*[@id='manage-keyfob']/div[2]/span/a";
			public static final String btnEditCancelSave = "div.save-edit > a.cancel";
			
			//Link Text
			
			public static final String lnkTxtDeactivate = "Deactivate";
			
				
			
			/***************Product Detail Page************************/
			//Links
			
			//xpath
			
			
			public static final String lnkGoToLists= "Go to Lists";	
			public static final String lnkSaveToLists = "a.folders-and-lists > span.text";
			public static final String lnkSaveToHomeProfile = "a.home-profile > span.text";
			public static final String lnkWriteAReview = "//*[@id='BVRRRatingSummaryLinkWriteID']/a";
			public static final String lnkSignInSetARmdr = "(//a[contains(text(),'Sign In')])[2]";
			
			
			//id
			public static final String lnkModPurResults = "modifyResultsLink";
			
			//buttons
			//xpath
			public static final String btnAddToCart = "//li[2]/div/a/span";
			//public static final String btnChkOut = "(//button[@type='button'])[4]";
			public static final String btnSecureChkOut = "//form[@id='ShopCartForm']/div[2]/div[2]/a[2]/span";
			public static final String btnSetUpARmdr = "//div[@id='productRight']/div[2]/ul/li[2]/a/span";
			
			//css
			
			public static final String btnSaveItem = "span.text";
			public static final String btnReqAddCard = "a.button.secondary > span";
			public static final String btnReqRplcmntCard = "a.mylowes-panel-btn.request-replacement > span";
			public static final String btnAddPurchase = "button.button.primary";
			public static final String btnAddPurchaseSpan = "#inStorePurchaseForm > form[name=\"findPurchaseForm\"] > div.row > button.button.primary";
			public static final String btnStrtChkOut = "a.button-green.start-checkout  > span";
			public static final String btnStrtChkOutSpan = "div.continue-checkout > a.button.primary > span";
			public static final String btnReviewAndPay = "#revpay_com_order > span";
			public static final String btnGCSubmission = "//div[@id='giftCardInputs']/fieldset/ol/li[4]/div/a/span";
			public static final String btnConfirmUSPS = "#btAddrConfirm > span";
			
			
			//Text
			
			//xpath
			public static final String txtCnfrmMsgDsp= "ConfirmationMessageDisplay";
			public static final String txtTermsAndConditions= "//*[@id='registrationForm']/p[2]/a";
			public static final String txtPurchaseConfResults= "//*[@id='findPurchase']/div[1]/div[1]";
			public static final String txtPurchaseDisclaimer1= "//*[@id='order-history']/div[3]";
			public static final String txtPurchaseDisclaimer2= "//*[@id='order-history']/div[4]";
			public static final String txtCCInfoPymntMethod= "//*[@id='paymentInfo']/h5";
			public static final String txtCCInfoMaster= "//*[@id='paymentInfo']/ul/li/span[1]";
			public static final String txtCCInfoVISA= "//*[@id='paymentInfo']/ul/li/span[1]";
			public static final String txtCCInfoStar= "//*[@id='paymentInfo']/ul/li/span[2]";
			public static final String txtPurchaseInfoDate = "//*[@id='order_detail']/div[1]/div[1]/table/tbody/tr[1]/td[1]";
			public static final String txtPurchaseInfoType = "//*[@id='order_detail']/div[1]/div[1]/table/tbody/tr[2]/td[1]";
			public static final String txtPurchaseInfoOrder = "//*[@id='order_detail']/div[1]/div[2]/table/tbody/tr[1]/td[1]";
			public static final String txtPurchaseInfoStatus = "//*[@id='order_detail']/div[1]/div[2]/table/tbody/tr[2]/td[1]";
			public static final String txtPurchaseInfoTotal= "//*[@id='order_detail']/div[1]/div[2]/table/tbody/tr[3]/td[1]";
			public static final String txtInvalidConfNoMsg1= ".//*[@id='findPurchase']/div[2]/div[1]";
			public static final String txtInvalidConfNoMsg2= "//*[@id='order_detail']/div[1]/div[2]/table/tbody/tr[3]/td[1]";
			public static final String txtChooseASavedAdd= "//*[@id='chooseAddress']/ul/li[1]/label";
			public static final String txtStatusInPurDetailPg= "//*[@id='order_detail']/div[1]/div[2]/table/tbody/tr[2]/td[2]";
			public static final String txtStatusInPurHistPg= "//*[@id='orderView']/tbody/tr[1]/td[6]";
			public static final String txtFobAssocInFindPur= "//*[@id='inStorePurchaseForm']/div";
			public static final String txtNoPurchases = "//*[@id='no-purchases']/div";
			public static final String txtPurPgTxt = "//div[@id='inStorePurchaseForm']/form/div[2]/div";
			
			public static final String txtPriceOfPrdInPDP= "//*[@id='pricing']/span";
			
			
			
			//id
			public static final String txtAllPurhases= "All Purchases";
			public static final String txtTxnDate= "All";
			public static final String txtInStore= "In-Store";
			public static final String txtOnline= "Online";
			public static final String txtInStoreValue= "option[value=\"IS\"]";
			public static final String txtPurDtLast6Mon= "Last 6 months";
			public static final String txtPurDt2013= "2013";
			public static final String txtPurDt2012= "2012";
			public static final String txtPurDtAll= "All";
			
			public static final String txtCCNo= "//div[2]/fieldset/ol/li[2]/div/input";
			public static final String txtSCode= "s-code";
			public static final String txtExpMon= "expiration-month";
			public static final String txtExpYear= "expiration-year";
			public static final String txtBillFName= "billingFname";
			public static final String txtBillLName= "billingLname";
			public static final String txtBillAdd1= "billingAddress1";
			public static final String txtBillAdd2= "billingAddress2";
			public static final String txtBillCity= "billingCity";
			public static final String txtBillState= "billingState";
			public static final String txtBillZip= "billingZip";
			public static final String txtBillPh1= "billingPhone1";
			public static final String txtBillPh2= "billingPhone2";
			public static final String txtAddNickName= "addressField2";			
			public static final String txtCardNickName= "cardNickname";	
			public static final String txtAddressName = "address-name";
			public static final String txtFName= "fname";
			public static final String txtLName= "lname";
			public static final String txtAdd1 = "address-1";
			public static final String txtAdd2 = "address-2";
			public static final String txtBillPhnPrim1="storedBillingPhone1";
			public static final String txtBillPhnPrim2="storedBillingPhone2";
			public static final String txtBillPhnPrim3="billingPhone3";
			
			public static final String txtBillEmailAdd= "billingEmailAddress";
			public static final String txtBillEmailAddPrim= "stored-billing-address-email";
			public static final String txtBillMsgExp= "reg-messaging-expand";
			public static final String txtpwd1= "password1";
			public static final String txtpwd2= "password2";
			
			public static final String txtZpCd= "zip";
			public static final String txtGCNbr="giftCard";
			public static final String txtGCPin= "gc-pin";
			
			//name
			public static final String txtBillPh3= "billingPhone3";
			
			//Dropdown
			
			//id
			public static final String drpDownPurchaseType= "purchase-method";
			public static final String drpDownPurchaseDate= "transaction-date";
			public static final String drpDownChkOutType= "checkout-card-type";
			public static final String drpDownPurhcseTypeAddPur= "purchaseType";
			
			
			//Link Text
			public static final String lnkTxtReviews = "Reviews";
			
			
			
			/********My Lowes Purchases Page******************/
			
			//Links
			//css
			public static final String lnkPurchasesFromMyLowes = "#nav_purchases > a";
			public static final String lnkAddPurchase = "a.find-purchases-nav > span";
			
			//xpath
			public static final String lnkPDImg = "//*[@id='itemList']/div[3]/div[1]/a/img";
			
			//link text
			public static final String lnkPurDtls = "Purchase Details";
			
			//Textboxes
			
			//id
			public static final String txtZipCode = "prefStoreZipCode";
			
			//Id's
			public static final String txtAddress1= "address1";
			public static final String txtCity= "city";
			public static final String txtState= "state";
			public static final String txtTitleDisplay = "BVRRSubmissionFormTitle";
			public static final String txtZip= "zipCode";
			public static final String txtConfNo= "confNumber";
			public static final String txtTxnNo= "transNumber";
			public static final String txtPurDate= "purchaseDate";
			public static final String txtStoreNo= "storeNumber";
			
			
			//Radio buttons
			//Css
			public static final String rdoBtnLowesPref = "li.request-option.clearfix > label > input[name=\"mylowesPref\"]";
			
			//id
			public static final String rdoBtnShpngMdlStore = "PLshipModeId_1";
			
			//name
			public static final String rdoBtnUseMyPrefPhNo = "mylowesPref";
			
			//xpath
			public static final String rdoBtnPresentRegCardOption1= "//*[@id='registrationOptions']/ul/li[1]/label/input";
			public static final String rdoBtnPresentRegCardOption2 = "//*[@id='card-register']";
			public static final String rdoBtnPresentRegCardOption3 = "//*[@id='registrationOptions']/ul/li[3]/label/input";
			
			
			//text
			
			//xpath
			public static final String txtDtFrmPDP= "//*[@id='order_detail']/div[1]/div[1]/table/tbody/tr[1]/td[2]";
			public static final String txtDtFrmPHP = "//*[@id='itemView']/div[1]/h3";
			public static final String txtItemInPurPg = "//*[@id='itemView']/ul[1]/li/div[2]/h3/a";
			
			
			
			//Webelements
			//xpath
			public static final String webElmntGreenTickMark = "//*[@id='order_detail']/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/ul/li[2]/a/span[1]";
			
			
			
			//buttons
			//xpath
			public static final String btnOrderDtlPg = "//div[@id='order_detail']/div[2]/div[2]/div/div[2]/div[3]/div/div";
			
			
			/******************** My Lowes Lists Page******************/
			
			//text
			//xpath
			public static final String txtPresentWlcmMsg = "//*[@id='welcomeMessage']/img";
			public static final String txtPriceOfPrdInLstPg= "//*[@id='itemList']/div[3]/div[2]/div[3]";
			public static final String txtOverview = "//*[@id='overview']";
			public static final String txtNotes = "//*[@id='itemList']/div[3]/div[2]/div[2]/p";
			public static final String txtItemInPdPage = "//*[@id='descCont']/div[1]/h1";
			public static final String txtItemInListsPage = "//*[@id='itemList']/div[3]/div[2]/div[1]/h5/a";
			public static final String txtRltdTxt = "//*[@id='itemList']/div[3]/div[2]/div[4]";
			public static final String txtDateAdded = "//*[@id='itemList']/div[3]/div[2]/div[4]/div[2]/p";
			public static final String txtNewList = "//*[@id='binHeader']/h1";
			public static final String txtNewItemTitle = "//div[@id='itemList']/div[3]/div[2]/div/h5/a";
			public static final String txtLocOfItem = "//*[@id='itemList']/div[3]/div[2]/div[2]/p[3]/a";
			public static final String txtDtFromListsPg = "//*[@id='itemList']/div[3]/div[2]/div[3]/p";
			
			
			
			//css
			public static final String txtNewListNm = "input[name=\"Click to add a name.\"]";
			public static final String txtNewNote = "textarea[name=\"Click to add a note.\"]";
			
			//id
			public static final String txtAddItmNm= "addItemName";
			public static final String txtEditItemNotes= "editItemNotes";
			public static final String txtAddList= "addListInput";
			public static final String txtEditItemTitle= "editItemTitle";
			public static final String txtAddItemNotes= "addItemNotes";
			public static final String txtRmndrStrtDt = "reminder_start_date";
			
			
			//Links
			//id
			
			public static final String lnkHideWelcome = "hideWelcome";
			public static final String lnkShowWelcome = "showWelcome";	
			public static final String lnkBatchDelete = "batchDelete";
			public static final String btnShowAllItems = "showAllItemsLink";
			
			//xpath
			public static final String lnkShowAllItems = "//*[@id='showAllItemsLink']";
			public static final String lnkSaveNote = "//div[@id='editBinNote']/a/span";
			public static final String lnkCancelSaveNote = "#editBinNote > a.cancel";
			
			
			//css
			public static final String lnkBuilding = "a[title=\"Building\"]";
			public static final String lnkTrmbleHouse = "img[alt=\"Historic Trimble House\"]";
			public static final String lnkSavedItems = "div.drawer-left > p.loc-in > a[title=\"Saved Items\"]";
			public static final String lnkDelItm = "img[alt=\"Delete\"]";
			public static final String lnkTitleAllItems = "a[title=\"All Items\"]";
			
			//Webelements
			//xpath
			public static final String webElmntSalutationListsPage = "//*[@id='lowes-salutation-active']/a[2]";
			public static final String webElmntPresenttxtBoxWriteEntry1 = "//*[@id='addItemName']";
			public static final String webElmntPresenttxtBoxWriteEntry2 = "//*[@id='addItemBox']/div[1]/p[1]/span";
			public static final String webElmntPresenttxtBoxWriteEntry3 = "//*[@id='addItemBox']/div[1]/div/div/span";
			public static final String webElmntPresenttxtBoxWriteEntry4 = "//*[@id='addItemBox']/div[1]/label/strong";
			public static final String webElmntPresenttxtBoxWriteEntry5 = "//*[@id='saveFreeFormBtn']";
			public static final String webElmntPresenttxtBoxWriteEntry6 = "//*[@id='addItemBox']/div[3]/a[2]";
			
			public static final String webElmntPresentActionBarItem1 = "//*[@id='uploadFile']/span";
			public static final String webElmntPresentActionBarItem2 = "//*[@id='addItem']/span";
			public static final String webElmntPresentActionBarItem3 = "//*[@id='filterActions']/div[3]";
			public static final String webElmntPresentActionBarItem4 = "//*[@id='filterActions']/div[4]";
			public static final String webElmntPresentActionBarItem5 = "//*[@id='actions']/a/span";
			
			
			public static final String webElmntDpDwnInListsPage1 = "//*[@id='filterActions']/div[3]/div[1]";
			public static final String webElmntDpDwnInListsPage2 = "//*[@id='showOnly']/ul/li[1]/a";
			public static final String webElmntDpDwnInListsPage3 = "//*[@id='showOnly']/ul/li[2]/a";
			public static final String webElmntDpDwnInListsPage4 = "//*[@id='showOnly']/ul/li[3]/a";
			public static final String webElmntDpDwnInListsPage5 = "//*[@id='showOnly']/ul/li[4]/a";
			public static final String webElmntDpDwnInListsPage6 = "//*[@id='showOnly']/ul/li[5]/a";
			public static final String webElmntDpDwnInListsPage7 = "//*[@id='showOnly']/ul/li[6]/a";
			
			
			public static final String webElmntPresentSetARmndr = "//*[@id='lists']/div[14]/div[2]/div[1]";
			
			public static final String webElmntTxtFilterActionsSortBy = "//*[@id='filterActions']/div[4]/div[1]";
			public static final String webElmntFilterActionsSortByMostRcnt = "//div[@id='sortBy']/a/span/b";
			public static final String webElmntFilterActionsSortByMostRcnt2 = "//*[@id='sortBy']/ul/li[1]/a";
			public static final String webElmntFilterActionsSortByAToZ = "//*[@id='sortBy']/ul/li[2]/a";
			public static final String webElmntFilterActionsSortByZToA = "//*[@id='sortBy']/ul/li[3]/a";
			public static final String webElmntHouzzGallImg="//*[@id='houzzThumbs']/div[2]/a/img";
			//link
			public static final String lnkNPCArticleName="//div/div/h3/a";
			//LinkText
			
			public static final String lnkSvdItms = "Saved Items";
			public static final String lnkEdit = "Edit";
			public static final String lnkMove = "Move";
			public static final String lnkDelList = "Delete List";
			public static final String lnkRenameList = "Rename";
			public static final String lnkKtchnAndDng = "Kitchen & Dining";
			public static final String lnkCredenza = "2-In-1 Credenza";
			public static final String lnkDefaultList = "default_list";
			public static final String lnkMore = "More";
			public static final String lnkHide = "Hide";
			public static final String lnkAddANote = "Add a Note";
			public static final String lnkHouzzGallery = "Houzz Gallery";
			public static final String lnkUndo= "Undo";
			public static final String lnkItemView = "Item View";
			public static final String lnkProducts = "Products";
			public static final String lnkArtAndVid = "Articles & Videos";
			public static final String lnkYourEntries = "Your Entries";
			public static final String lnkHmIdeaPhotos = "Home Ideas Photos";
			public static final String lnkUploadFiles = "Uploaded Files";
			public static final String lnkMstRcnt = "Most Recent";
			
			
			//buttons
			//css
			public static final String btnAddEntry = "#addItem > span";
			public static final String btnCancelSave = "div.save > a.cancel";
			public static final String btnSaveEntry = "#saveFreeFormBtn > span";
			public static final String btnDelEntry = "a.delete-item";
			public static final String btnSaveEditedNotes = "div.save-edit > a.button.primary > span";
			public static final String btnSelectmMenu = "#actions > a.flyout-button > span";
			public static final String btnMoveItem = "div.submit > a.button.primary > span";
			public static final String btnAddList = "#addListLink > span";
			public static final String btnSaveList = "a.button.primary > span";
			public static final String btnDelList = "//div[@id='deleteBin']/a/span";
			public static final String btnSaveEditedList = "//div[@id='editBinName']/a/span";
			public static final String btnDelItem = "a.delete-item > img";
			public static final String btnSetRmndr = "a.set-reminder";
			public static final String btnCloseRmndr = "a.close_reminder";
			public static final String btnSaveRmndr = "a.button.reminder_notes_save_continue > span";
			public static final String btnSaveItemsNextIcon = "p.loc-in > a";
			public static final String btnUploadFile = "#uploadFile > span";
			public static final String btnEditItemsLabel = "#editItemBins > li > label";
			public static final String btnSpanSelection = "span.selection";
			
			
			
			
			//xpath
			public static final String btnAddPrjA = "//*[@id='project-add-button']/a";
			public static final String btnAddPrjGreenTick = "//*[@id='project-add-button']/span";
			public static final String btnUploadFileInput = "//*[@id='uploadModal']/form/span/input";
			public static final String btnEditSpan = "a.edit-btn.open > span";
			public static final String btnItemListSpan = "//div[@id='itemList']/div[3]/div[2]/div[2]/div/div/span/span";
			public static final String btnEditItemBins= "//ul[@id='editItemBins']/li[2]/input";
			public static final String btnItemListDiv = "//div[@id='itemList']/div[3]/div[2]/div[2]/div/div/div/div[2]/span/span";
			public static final String btnNavPort = "//*[@id='nav_portfolio']/ul/li[2]/a";
			public static final String editItemBin = "//ul[@id='editItemBins']/li/input";
			public static final String btnDeleteListConfirm="//*[@id='deleteBin']/a[1]/span";
			
			//id
			public static final String btnAddPrj = "project-add-button";
			public static final String btnSavePhoto = "savePhoto";
			
			//check box
			
			public static final String chkBoxBatchChk = "batchCheck";
			
			//drop down
			public static final String drpDownVariableB = "b";
			public static final String drpDownVariableAtoZ = "A-Z";
			public static final String drpDownVariableZToA = "Z-A";
			//txt
			//name
			public static final String txtCheckOutCreditCardNo = "cardNumber";
			
			//kishore
			public static final String lnkViewDelDetails = "//*[@id='order_detail']/div[2]/div[2]/div/div[2]/div[1]/a";
		    public static final String txtDelDetails =	"//*[@id='item-details-0']/div";
		    
		    //Ankita 18th march
		    //list page
		    //button
		    //xpath
		    public static final String btnGetDetailslist= "//*[@id='pricing']/a/span";
		    public static final String btnContinueShoppingLists="//div[3]/div/button[1]/span";
		    //link
		    public static final String lnkGridView= "//*[@id='listHeader']/ul/li[2]/a/img";
		    public static final String lnkMAPHelpList="//*[@id='pricing']/p[1]/a/img";
		   
		    public static final String lnkMapPopupClose="body[@id='lists']/div[12]/div/a/span";
		    //label
		    //xpath
		    public static final String lblCurrentPriceLists="//*[@id='pricing']/p[1]";
		    public static final String lblWasPriceLists= "//*[@id='pricing']/p[2]/span";
		    public static final String lblMSRPList="//*[@id='pricing']/p[2]";
		    
		    //web element
		    public static final String webElmntAddedToCartFrmList="//*[@id='ui-dialog-title-productAddToCart']";
		    public static final String webElmntMSRPHelpPopup="suggestedPrice_help";
		   //purchases
		  //drop-down
		    //class
		    public static final String drpDownSaveItemPurchaseHistory= "save-item";
		    public static final String drpDownAddPurchsType="purchaseType";
		    public static final String drpDownAddToItemViewAll="//*[@id='itemView']/ul/li/div[3]/div/div[1]/span";
		    public static final String drpDownAddToOnlinePurchsDetails="//*[@id='order_detail']/div[2]/div[2]/div/div[2]/div[3]/div/div[1]/span";
		    public static final String drpDownAddToInStorePurchsDetails="//*[@id='order_detail']/div[2]/div[2]/div/div[2]/div[3]/div[1]/span";
		    //label
		    //xpath
		    public static final String lblNoMLCInStoreMsg="(//*[@id='no-purchases']/div)[1]";
		    public static final String lblTransaction="//*[@id='inStorePurchaseForm']/form/div[1]/label";
		    public static final String lblPurchaseDt="//*[@id='inStorePurchaseForm']/form/div[2]/label";
		    public static final String lblStoreNbr="//*[@id='inStorePurchaseForm']/form/div[3]/label";
		    //link
		    public static final String lnkTransactionHelp="//*[@id='inStorePurchaseForm']/form/div[1]/div/a/img";
		    public static final String lnkPurchaseDtHelp="//*[@id='inStorePurchaseForm']/form/div[2]/div/div[3]/a/img";
		    public static final String lnkStoreNbrHelp="//*[@id='inStorePurchaseForm']/form/div[3]/div/a/img";
		    public static final String lnkPurchaseDtPicker="//*[@id='inStorePurchaseForm']/form/div[2]/div/div[2]/img";
		    public static final String lnkAddToHPItemViewPurchases= "//*[@id='itemView']/ul/li/div[3]/div/div[2]/ul/li[1]/a/span[2]";
		    public static final String lnkAddToListItemViewPurchases= "//*[@id='itemView']/ul/li/div[3]/div/div[2]/ul/li[2]/a/span[2]";
		    public static final String lnkReminderItemViewPurchases= "//*[@id='itemView']/ul/li/div[3]/div/div[2]/ul/li[3]/a/span[2]";
		    public static final String lnkAddToHPItemViewPurchasesLst= "//*[@id='itemView']/ul/li/div[3]/div/div[2]/ul/li[1]";
		    public static final String lnkAddToListItemViewPurchasesLst= "//*[@id='itemView']/ul/li/div[3]/div/div[2]/ul/li[2]";
		    public static final String lnkReminderItemViewPurchasesLst= "//*[@id='itemView']/ul/li/div[3]/div/div[2]/ul/li[3]";
		    public static final String lblReminderSetItemView= "//*[@id='itemView']/ul[1]/li/div[3]/div/div[2]/ul/li[3]/a/span";
		    public static final String lnkPurchaseView="//*[@id='purchaseControls']/div/a[2]";
		    public static final String lnkPurchaseTotalPage= "//*[@id='purchaseList']/div[3]/div/span[3]";
		    public static final String lnkAddToHPPuchaseDetails="//*[@id='order_detail']/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/ul/li[1]";
		    public static final String lnkAddToListPuchaseDetails="//*[@id='order_detail']/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/ul/li[2]";
		    public static final String lnkReminderPuchaseDetails="//*[@id='order_detail']/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/ul/li[3]";
		    public static final String lnkAddToHPPuchaseDetailsIS="//*[@id='order_detail']/div[2]/div[2]/div/div[2]/div[3]/div[2]/ul/li[1]";
		    public static final String lnkAddToListPuchaseDetailsIS="//*[@id='order_detail']/div[2]/div[2]/div/div[2]/div[3]/div[2]/ul/li[2]";
		    public static final String lnkReminderPuchaseDetailsIS="//*[@id='order_detail']/div[2]/div[2]/div/div[2]/div[3]/div[2]/ul/li[3]";
		    
		    //button
		    public static final String btnAddPurchaseInStore="//*[@id='purchaseControls']/a/span";
		    //web element
		    public static final String webElmntAddToHPItemViewCheck= "//*[@id='itemView']/ul/li/div[3]/div/div[2]/ul/li[1]/a/span[1]";
		    public static final String webElmntAddToListItemViewCheck= "//*[@id='itemView']/ul/li/div[3]/div/div[2]/ul/li[2]/a/span[1]";
		    public static final String webElmntReminderItemViewCheck= "//*[@id='itemView']/ul/li/div[3]/div/div[2]/ul/li[3]/a/span[1]";
		    public static final String webElmntPurchaseViewRows="//*[@id='orderView']/tbody/tr";
		    //Details Page
		    public static final String lblWasPriceDetails= "//*[@id='pricing']/p[1]";
		    public static final String lblViewPrcInCart="//*[@id='pricing']/strong";
		    public static final String lnkMAPHelp= "//*[@id='pricing']/a/img";
		    public static final String lblMSRP= "//*[@id='pricing']/div[2]/p";
		   //request my lowes
		    //text
		    
		    //MyLowes page
		    public static final String btnDeactivateMLC="//*[@id='deactivate-dialog']/a[1]/span";
		    public static final String webElmntMLCRplcmntAddressValue1="//*[@id='addressName']/option[1]";
		    public static final String webElmntMLCRplcmntAddressValue2="//*[@id='addressName']/option[2]";
		    public static final String drpDownSavedAddrss="addressName";
		    //help page
		    public static final String lnkLowesDtComFAQs="//*[@id='content-area-no-nav-widest']/div[2]/div/ul/li[2]/ul[3]/li[2]/a";
		    public static final String lnkMyLowesCard="//*[@id='My_Lowes_Card']/a/h2";
		    //label
		    public static final String lblAddingInStorePurchsPara1="//*[@id='cu-faq']/p[2]";
		    public static final String lblAddingInStorePurchsPara2="//*[@id='cu-faq']/p[3]";
		    public static final String lblFAQAddingPastPurchsHeading2="//*[@id='cu-faq']/h3[2]";
		    public static final String lblViewOlMobilePurchsPara1="//*[@id='cu-faq']/p[4]";
		    public static final String lblViewOlMobilePurchsPara2="//*[@id='cu-faq']/p[5]";
		    public static final String lblFAQAddingPastPurchsHeading3= "//*[@id='cu-faq']/h3[3]";
		    
		    public static final String txtTotalArea = "//*[@id='mulchCalculator']/div[2]/div/div/div/div/div[4]/span[2]";
		    public static final String lblEstCoverageAmnts = "//*[@id='coverage']/div[3]/p";
		    public static final String lnkDelSecondaryCard = "//div[6]/div[2]/div/a[2]";
		    public static final String lnkDelPrimaryCard = "//div[6]/div[2]/div/a[2]";
		  //Ankita Added 20th March
		    public static final String lblReminderDateTxt="//*[@id='remindersList']/div[2]/div[2]/p";
		    public static final String lnkModifySearch="//*[@id='modifyResultsLink']";
		    public static final String webElmntItemNameInInstoreOrder="//*[@id='order_detail']/div[2]/div/div/div[2]/h5";
		    public static final String webElmntAddedInStoreOrderDiv1="//*[@id='order_detail']/div[1]";
		    public static final String lblAddedInStoreOrderType="//*[@id='order_detail']/div[2]/h3";
		    public static final String lblAddedInStorePurchaseAt="//*[@id='order_detail']/div[1]/div[1]/table/tbody/tr[2]/td[2]/a";
		    public static final String lblAddedInStoreInvoiceNbr="//*[@id='order_detail']/div[1]/div[2]/table/tbody/tr[1]/td[2]";
		    public static final String lblAddedInStorePurchaseTotal="//*[@id='paymentAmounts']/ul/li/span[2]";
		    public static final String lnkLinkInStorePrchsToMLC= "//*[@id='findPurchase']/div[4]/div/div/a";
		    public static final String lblInStoreOrderLinkedSuccessMsg="//*[@id='findPurchase']/div[4]/div";
		    public static final String drpDownSelectMLCForLinking="//*[@id='findPurchase']/div[4]/div/div/ul/li[2]/select";
		    public static final String lblAddToMLCNbr="//*[@id='findPurchase']/div[4]/div/div/ul/li[1]/span";
		    public static final String btnAddOrderToMLC="//*[@id='findPurchase']/div[4]/div/div/ul/li[3]/button";
		    public static final String lnkItem1NameItemViewPurchases="//*[@id='itemView']/ul/li/div[2]/h3/a";
		    public static final String lblPurchaseListFooter="//*[@id='purchaseList']/div[3]/div";
		    public static final String lnkPrevious="//*[@id='purchaseList']/div[3]/div/span[1]";
		    public static final String lnkNext="//*[@id='purchaseList']/div[3]/div/span[4]";
		    public static final String lnkThumbNail="//*[@id='itemView']/ul/li/div[1]/a";
		    public static final String drpDownSendReminder="reminder_rep";
		    public static final String lnkTransactioDtOption1="//*[@id='transaction-date']/option[1]";
		    public static final String lblEPPReferenceNbr="//*[@id='order_detail']/div[2]/div[2]/div/div[2]/div[3]";
		    public static final String webElmntEPPImg="//*[@id='order_detail']/div[2]/div[2]/div/div[1]/img";
		    public static final String webElmntItemViewItemsAll= "//*[@id='itemView']/ul";
		    public static final String webElmntItemViewPgCount="//*[@id='purchaseList']/div[3]/div/span[2]";
		    public static final String webElmntItemViewOrdersOnPg= "//*[@id='orderView']/tbody/tr";
		    public static final String lnkSignInReminderPopup="(//a[contains(text(),'Sign In')])[2]";
		    public static final String lnkFindPurchsDrpdownOption1="//*[@id='purchaseType']/option[1]";
		    public static final String lnkFindPurchsDrpdownOption2="//*[@id='purchaseType']/option[2]";
		    public static final String lnkFindPurchsDrpdownOption3="//*[@id='purchaseType']/option[3]";
		    public static final String lblFindPurchaseType= "//*[@id='FindOrderForm']/fieldset[1]/label";
		    public static final String lblFindPurchsOrderNbr= "//*[@id='containerSOM']/label";
		    public static final String btnFindOrderSubmit= "findOrdersSubmit";
		    public static final String webElmntLogonForm= "//*[@id='Logon']/div/div";
		    public static final String lblOrderNbrPurchaseDetails="//*[@id='order-number-data']";
		    public static final String lblPurchaseStatus="//*[@id='order_detail']/div[1]/div[2]/table/tbody/tr[2]/td[2]";
		    public static final String lblPurchaseTotal= "//*[@id='order_detail']/div[1]/div[2]/table/tbody/tr[3]/td[2]";
		    public static final String lblPaymentInfo= "//*[@id='order_detail']/div/h3/span";
		    public static final String lblPurchaseTotalAmt= "//*[@id='purchaseTotal']/span[2]";
		    public static final String lblSubtotalAmt="//*[@id='paymentAmounts']/ul/li[1]/span[2]";
		    public static final String webElmntFindOrder="find-orders";
		    public static final String txtPONbr= "//*[@id='poNumber']";
		    public static final String lblInvalidPOError= "//*[@id='find-orders']/div[2]/div/div[2]/p";
		    public static final String btnPurchaseDetailsPrint= "//*[@id='order_detail']/h3/a/span";
		    public static final String lblInStoreOrderPaymentInfo="//*[@id='order_detail']/div[3]/h3";
		    public static final String lblInstoreOrderPaymentMethod= "//*[@id='paymentInfo']/div";
		    public static final String lblOnlineOrderPaymentMethod="//*[@id='paymentInfo']/ul/li";
		    public static final String webElmntOnlinePurchaseAll="//*[@id='order_detail']/div[2]/div";
		    public static final String lblPurchaseViewHd="//*[@id='order-history']/h1/span";
		    public static final String lblType= "//*[@id='purchases']/fieldset/label[1]";
		    public static final String lblDate= "//*[@id='purchases']/fieldset/label[2]";
		    public static final String lblMyLowesCard= "//*[@id='purchases']/fieldset/label[3]";
		    public static final String drpDownMLC="keyfob-number";
		    public static final String lblDateInTable="//*[@id='orderView']/thead/tr/th[1]/span";
		    public static final String lblOrderNbrInTable="//*[@id='orderView']/thead/tr/th[2]/span";
		    public static final String lblTypeInTable= "//*[@id='orderView']/thead/tr/th[3]/span";
		    public static final String lblItemsInTable= "//*[@id='orderView']/thead/tr/th[4]/span";
		    public static final String lblTotalInTable= "//*[@id='orderView']/thead/tr/th[5]/span";
		    public static final String lblStatusInTable= "//*[@id='orderView']/thead/tr/th[6]/span";
		    public static final String lblMLCheading="//*[@id='manage-keyfob']/h3/span[1]";
		    public static final String btnRqstAdditionalMLC= "//*[@id='manage-keyfob']/h3/span[2]/a/span";
		    public static final String webElmntBookMark="//*[@id='manage-keyfob']/div/div[1]";
		    public static final String lblMLCTxt="//*[@id='manage-keyfob']/div/div[2]";
		    public static final String lnkViewPurchsHistory="//*[@id='manage-keyfob']/div/div[2]/a";
		    public static final String lnkDeactivate="//*[@id='manage-keyfob']/div/div[2]/div/a";
		    public static final String webElmntDeactivateImg= "//*[@id='manage-keyfob']/div/div[2]/div/a/img";
		    public static final String lblCardOwner= "//*[@id='manage-keyfob']/div/div[3]/div[1]/span";
		    public static final String lblCardOwnerValue="//*[@id='manage-keyfob']/div/div[3]/div[1]";
		    public static final String lblMLCNbr="//*[@id='manage-keyfob']/div/div[3]/div[2]/span";
		    public static final String lblMLCNbrvalue="//*[@id='manage-keyfob']/div/div[3]/div[2]";
		    public static final String lnkPrintTempCard="//*[@id='manage-keyfob']/div/div[3]/div[2]/div/a";
		    public static final String webElmntRqstreplacementImg="//*[@id='manage-keyfob']/div/div[4]/div[2]/a/img";
		    public static final String lnkRqstReplacement="//*[@id='manage-keyfob']/div/div[4]/div[2]/a/span";
		    public static final String lblRqstReplacementHd= "//*[@id='manage-keyfob']/div/div[4]/div[1]/div/h4";
		    public static final String lblReplacementInfo= "//*[@id='manage-keyfob']/div//div[4]/div[1]/div/p";
		    public static final String lblChooseSavedAddress= "//*[@id='chooseAddress']/ul/li[1]/label";
		    public static final String lnkShipToDiffLocation= "//*[@id='chooseAddress']/ul/li[2]/a";
		    public static final String btnRqstMLC="//*[@id='chooseAddress']/ul/li[3]/button/span";
		    public static final String lnkCancel2="//*[@id='chooseAddress']/ul/li[3]/a/span";
		    public static final String lnkTC= "//*[@id='chooseAddress']/ul/li[4]/div/a[1]";
		    public static final String lnkPrivacy="//*[@id='chooseAddress']/ul/li[4]/div/a[2]";	
		    public static final String lblRqstMLCHd= "//*[@id='loginRegister']/h1";
		    public static final String lblRqstMLCTxt="//*[@id='loginRegister']/p";
		    public static final String lblRqstMLCOption1= "//*[@id='purchaseTrackingSelection']/ul/li[1]/label/span";
		    public static final String rdoBtnMLCOption1="//*[@id='purchaseTrackingSelection']/ul/li[1]/label/input";
		    public static final String lblRqstMLCOption2= "//*[@id='purchaseTrackingSelection']/ul/li[2]/label/span";
		    public static final String rdoBtnMLCOption2="//*[@id='purchaseTrackingSelection']/ul/li[2]/label/input";
		    public static final String lblRqstMLCOption3= "//*[@id='purchaseTrackingSelection']/ul/li[3]/label/span";
		    public static final String rdoBtnMLCOption3="//*[@id='purchaseTrackingSelection']/ul/li[3]/label/input";
		    public static final String lblRqstMLCAdd1="//*[@id='purchaseTrackingSelection']/ul/li[3]/div/ul[1]/li[1]/label";
		    public static final String lblRqstMLCAdd2="//*[@id='purchaseTrackingSelection']/ul/li[3]/div/ul[1]/li[2]/label";
		    public static final String lblRqstMLCCity= "//*[@id='purchaseTrackingSelection']/ul/li[3]/div/ul[2]/li[1]/label";
		    public static final String lblRqstMLCState="//*[@id='purchaseTrackingSelection']/ul/li[3]/div/ul[2]/li[2]/label";
		    public static final String lblRqstMLCzipCode="//*[@id='purchaseTrackingSelection']/ul/li[3]/div/ul[3]/li/label";
		    public static final String lblRqstMLCTxt2="//*[@id='purchaseTrackingSelection']/ul/li[3]/div/p";
		    public static final String lblRqstMLCTxt3="//*[@id='purchaseTrackingSelection']/p";
		    public static final String txtAddress2= "address2";
		    public static final String lblRqstMLCNbr="//*[@id='purchaseTrackingSelection']/ul/li[2]/div/ul[1]/li/label";
		    public static final String lblRqstMLCPhnNbr="//*[@id='purchaseTrackingSelection']/ul/li[2]/div/ul[2]/li/label";
		    public static final String txtMLCNbr= "//*[@id='purchaseTrackingSelection']/ul/li[2]/div/ul[1]/li/input";
		    public static final String txtMLCPhnNbr="//*[@id='purchaseTrackingSelection']/ul/li[2]/div/ul[2]/li/input";
		    public static final String lblRqstMLCtxt4= "//*[@id='mboxImported-default-purchase-tracking-messaging-0']/div/h3";
		    public static final String lblRqstMLCtxt5="//*[@id='mboxImported-default-purchase-tracking-messaging-0']/div/p[1]/b";
		    public static final String lblRqstMLCtxt6="//*[@id='mboxImported-default-purchase-tracking-messaging-0']/div/p[2]";
		    public static final String lblRqstMLCtxt7= "//*[@id='mboxImported-default-purchase-tracking-messaging-0']/div/p[3]";
		    public static final String lblYourMLCNbr= "//*[@id='mlcContextual']/div[1]/h4";
		    public static final String lblMLCOnCard="//*[@id='mlcContextual']/div[1]/p[1]";
		    public static final String webElmntMLCImg="//*[@id='mlcContextual']/div[1]/p[2]/img";
		    public static final String lblRqstMLCPhnNbr1="//*[@id='purchaseTrackingSelection']/ul/li[1]/div[1]/ul/li/label";
		    public static final String lblDeactivateDialogtxt= "//*[@id='deactivate-dialog']/div/p";
		    public static final String btnDeactivateCard2= "//*[@id='deactivate-dialog']/a/span";
		    public static final String btnDeactivateCardCancel="//*[@id='deactivate-dialog']/a[2]";
		    public static final String lblCardDeactivated="//*[@id='manage-keyfob']/div/div/p/span";
		    public static final String txtMLCPhnNbr1="//*[@id='purchaseTrackingSelection']/ul/li[1]/div[1]/ul/li/input";
		    public static final String webElmntRecentPurchases="orderView";
		    public static final String webElmntAddPurchaseSection=  "//*[@id='findPurchase']";
		    public static final String webElmntAddPurchaseOptions= "//*[@id='purchaseType']/option";
		    public static final String lblConfNbr="//*[@id='onlinePurchaseForm']/form/div[1]/label";
		    public static final String lblAddInStoreTxt= "//*[@id='specialOrderForm']/form/div[1]/label";
		    public static final String rdoButtonPO= "//*[@id='poNumberDiv']/input[1]";
		    public static final String rdoButtonMO="//*[@id='moNumberDiv']/input[1]";
		    public static final String txtMONbr="//*[@id='moNumber']";
		    public static final String lnkBrdCrumbLvl1= "//*[@id='breadcrumbs']/ul/li[1]/a";
		    public static final String lnkAddTo6thIteminItemView="//*[@id='itemView']/ul[6]/li/div[3]/div/div[1]/span";
		    public static final String lblReminderItem6thItemView= "//*[@id='itemView']/ul[6]/li/div[3]/div[1]/div[2]/ul/li[3]/a";
		    public static final String lblReminderItem1stItemView="//*[@id='itemView']/ul[1]/li/div[3]/div[1]/div[2]/ul/li[3]/a";
		    public static final String lnkPurchaseView2ndOrder= "//*[@id='orderView']/tbody/tr[2]/td[2]/a";
		    public static final String lnkPurchaseDetailsItem3AddTo="//*[@id='order_detail']/div[2]/div[6]/div/div[2]/div[3]/div/div[1]/span";
		    public static final String lnkPurchaseDetailsItem3Reminder= "//*[@id='order_detail']/div[2]/div[6]/div/div[2]/div[3]/div/div[2]/ul/li[3]/a";
		    public static final String lblNoPurchase="//*[@id='no-purchases']/div/p";
		    public static final String webElmntOnlineDetailsItem1="//*[@id='order_detail']/div[2]/div[2]/div";
		    public static final String lnkItem1StatusOlPurchaseDetails="//*[@id='order_detail']/div[2]/div[2]/div/div[2]/div[1]/a/span";
		    public static final String lblShippedTo="//*[@id='item-details-0']/div[1]/div[1]/label";
		    public static final String lblShippedToValue="//*[@id='item-details-0']/div[1]/div[1]/span";
		    public static final String lblShippedFrom="//*[@id='item-details-0']/div[1]/div[2]/label";
		    public static final String lblShippedFromValue="//*[@id='item-details-0']/div[1]/div[2]/span";
		    public static final String lblShippedWithin="//*[@id='item-details-0']/div[1]/div[2]/label";
		    public static final String lblShippedWithinValue="//*[@id='item-details-0']/div[1]/div[2]/span";
		    public static final String webElmntOlPurchsDetailsAllItems="//*[@id='order_detail']/div/div[2]/div";
		    public static final String webElmntReminderWelcmMsg="//*[@id='one-column']/div[4]/div/div[1]";
		    public static final String lnkCloseWelcmMesg= "//*[@id='one-column']/div[4]/div/div[1]/a";
		    public static final String lnkReminderFrmPurchaseHistory= "//*[@id='one-column']/div[4]/div/div[2]/div/div[1]/div[1]/p/a";
		    public static final String lnkReminderFrmPrdctPg= "//*[@id='one-column']/div[4]/div/div[2]/div/div[1]/div[2]/p/a";
		    public static final String lblOnlineExperience="//*[@id='left-nav-block']/h2[1]";
		    public static final String lnkShowWelcmMesg="//*[@id='one-column']/div[4]/h1/a";
		    public static final String txtReminderNotes="reminder_notes";
		    public static final String webElmntReminderPg="//*[@id='filter-bar']/div[2]/ul/li[2]";
		    public static final String webElmntRemindersOnPg="//*[@id='remindersList']/div";
		    public static final String lnkItemNameOnReminderAll= "//*[@id='remindersList']/div/div[2]/div[1]/div[2]/h5/a";
		    public static final String btnReminderSave="//*[@id='reminders_modal']/div[2]/a[1]/span";
		    public static final String lblReminderSavedMsg="//*[@id='productRight']/div[2]/ul/li[2]/div[2]/div[2]/div/p";
		    public static final String webElmntReminderFromList="//*[@id='itemList']/div[3]/div[2]/div[1]/a[1]";
		    public static final String webElmntBoschToolVideo= "//*[@id='content-area-no-nav-widest']/div/div[2]/iframe";
		    public static final String chkBoxCalcBatchDelete= "calc_batch_delete";
		    public static final String chkBoxCalcAll= "//*[@id='calculationsContainer']/div[2]/div[3]/div/div[2]/input";
		    public static final String webElmntCalc1Drawer= "//*[@id='calculationsContainer']/div[2]/div[3]/div[1]/div[2]/div[2]";
		    public static final String webElmntCalcShow="//*[@id='calculationsContainer']/div[2]/div[2]/div[2]/div[2]/a/span";
		    public static final String webElmntCalcShowLabel= "//*[@id='calculationsContainer']/div[2]/div[2]/div[2]/div[1]";
		    public static final String webElmntListHeader="//*[@id='binHeader']";
		    public static final String webElmntListOverView="//*[@id='overview']";
		    public static final String webElmntListHeader2="//*[@id='listHeader']";
		    public static final String webElmntListOverViewFilter= "//*[@id='filterActions']";
		    public static final String btnDeleteHP= "//*[@id='delete_profile']/a/span";
		    public static final String lblNotes="//*[@id='profile_notes']/label";
		    public static final String webElmntItemsInADElMthdGrpOC="//*[@id='conf-main']/div[3]/div[2]/div[2]/div[2]/div";
		    public static final String webElmntCustomShape="shape_other";
		    public static final String labelCustomShapeMsg="//*[@id='ui-arrowtip-1']/div/div[3]/p";
		    public static final String btnCustomShapeUndo="//*[@id='custom_undo']";
		    public static final String labelCustomShapeMsg2="//*[@id='ui-arrowtip-2']/div/div[3]/p";
		    public static final String btnRotate1= "//*[@id='rotate_group']/div[1]";
		    public static final String btnRotate2="//*[@id='rotate_group']/div[2]";
		    public static final String btnFlip1= "//*[@id='flip_group']/div[1]";
		    public static final String btnFlip2="//*[@id='flip_group']/div[2]";
		    public static final String btnCustomShapeContinue="//*[@id='section_shapes']/div[3]/a";
		    public static final String btnCancelOrderConfirm= "//*[@id='cancelPurchase']/a[1]/span";	
		    public static final String btnAddSpecialOrderPurchase="#specialOrderForm > form[name=\"findPurchaseForm\"] > div.row > button.button.primary";
		    
		    //added 03.28
		    public static final String btnUploadFrstDocInSpace= "//*[@id='documentsContainer']/div[3]/div[2]/div[1]/a/span";
		    public static final String btnUploadDocInSpace= "//*[@id='documentsContainer']/div[2]/div[2]/div[1]/a/span";
		    public static final String lblMLCardNbr="//*[@id='order_detail']/div[1]/div[2]/table/tbody/tr[4]/td[1]";
		    public static final String lblMLCardNbrValue="//*[@id='order_detail']/div[1]/div[2]/table/tbody/tr[4]/td[2]";
		    public static final String lblTotalCredit= "//*[@id='paymentAmounts']/ul/li[3]/span[1]";
		    public static final String lblTotalCreditValue= "//*[@id='paymentAmounts']/ul/li[3]/span[2]";
		    public static final String webElmntInStoreReturnedItem1="//*[@id='order_detail']/div[2]/div[1]/div";
		    public static final String webElmntDocsUploadSuccessMsg="//*[@id='upload-modal-5']/ul/li/div/div/p";
		    public static final String webElmntDocsCount="//*[@id='documentsContainer']/div[2]/div[3]/div";
		    public static final String webElmntItemNameInDeleteMsg= "//*[@id='item_list']/div[1]/div[2]/p/strong";
}