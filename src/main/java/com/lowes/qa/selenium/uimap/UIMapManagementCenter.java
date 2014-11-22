package com.lowes.qa.selenium.uimap;

/**
 * UI Map for ManagementCenter
 */
public class UIMapManagementCenter
{
	//xpath
	public static final String webElmntBogoItem = "//*[@id='two-column-b']/div[1]/table/tbody/tr[6]";
	public static final String webElmntBogoDesc = "//*[@id='two-column-b']/div[1]/table/tbody/tr[6]/td[2]/div";
	public static final String lblBogoPrice2 = "//*[@id='two-column-b']/div[1]/table/tbody/tr[6]/td[4]/span/div/p/span";
	public static final String lblBogoUnitPrice = "//div[2]/div[2]/div[2]/div/div[2]";
	public static final String lblGCInformationalText="//div[3]/p";
	public static final String lblSubTotalInCheckOut = "//*[@id='two-column-b']/div[1]/table/tbody/tr[1]/td[2]/strong";
	public static final String lblMinQtyMsg = "//div[2]/div[3]/div";
	public static final String txtParentQtyValue = "//input[@name='quantity_1']";
	public static final String lblBoGoQtyValue = "//input[@name='quantity_2']";   
	public static final String lblFreeParcel = "//*[@id='two-column-b']/div[1]/table/tbody/tr[2]/td[2]/span";
	public static final String lblFreeParcelInReviewPay = "//*[@id='two-column-b']/div[2]/table/tbody/tr[2]/td[2]/span";
	public static final String lblWasPrice = "//*[@id='pricing']/p[1]";
	public static final String lblSellingPrice = "//*[@id='pricing']/span";
}