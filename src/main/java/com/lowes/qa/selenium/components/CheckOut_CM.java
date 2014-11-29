package com.lowes.qa.selenium.components;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.cognizant.framework.Status;
import com.lowes.qa.selenium.support.DriverScript;
import com.lowes.qa.selenium.support.ReusableLibrary;
import com.lowes.qa.selenium.support.ScriptHelper;
import com.lowes.qa.selenium.uimap.UIMapCheckOut;
import com.lowes.qa.selenium.uimap.UIMapFunctionalComponents;
import com.lowes.qa.selenium.uimap.UIMapMyLowes;
import com.lowes.qa.selenium.uimap.UIMapProductSearch;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

/**
 * CheckOut_CM class
 * @author Infosys
 */
public class CheckOut_CM extends ReusableLibrary
{
	
	/**
	 * Constructor to initialize the component library
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link DriverScript}
	 */
	String baseurl = dataTable.getData("General_Data", "URL");
	Selenium selenium = new WebDriverBackedSelenium(driver, baseurl);
	public static double youSaveAmt=0.0;
	CheckOut co=new CheckOut(scriptHelper);
	CheckOut_CH ch = new CheckOut_CH(scriptHelper);
	ProductSearch ps=new ProductSearch(scriptHelper);
	FunctionalComponents fc=new FunctionalComponents(scriptHelper);
	public CheckOut_CM(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
	}
	
	/*This function returns the count of a web element on a page*/
	public int countWebElement(String varXpath) throws Exception
	{
		List<WebElement> varGC = driver.findElements(By.xpath(varXpath));
		int varCount = varGC.size();
		return varCount;
	}
	
	/*This function validates whether added items are displayed in Shopping Cart with correct delivery methods selected*/
	public void validateDeliveryInCart() throws Exception
	{
		String varDelivery=dataTable.getData("General_Data", "DeliveryMthd");
		String varListNbr=null;
		if(varDelivery.equals("PL"))
			varListNbr="1";
		else if(varDelivery.equals("LD"))
			varListNbr="2";
		else if(varDelivery.equals("UPS"))
			varListNbr="3";
		try{
		String varChecked=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[2]/ul/li["+varListNbr+"]/div/label/input")).getAttribute("checked");
		
		if(varChecked.equals("true"))
		{
			report.updateTestLog("Validating delivery Method in Cart for Item: "+dataTable.getData("General_Data", "ItemNbr"), "Delivery Method: "+dataTable.getData("General_Data", "DeliveryMthd")+" checked for Item: "+dataTable.getData("General_Data", "ItemNbr"), Status.PASS);
			
		}
		
		}
		catch(Exception NullPointerException)
		{
			report.updateTestLog("Validating delivery Method in Cart for Item: "+dataTable.getData("General_Data", "ItemNbr"), "Delivery Method: "+dataTable.getData("General_Data", "DeliveryMthd")+" NOT checked for Item: "+dataTable.getData("General_Data", "ItemNbr"), Status.PASS);
		}
	
	}
	
	/*This function validates the error messages displayed on entering invalid Qty/Amt for Gift Card*/
	public void checkInvalidGiftCardQtyAmt() throws Exception
	{
		driver.findElement(By.xpath(UIMapCheckOut.btnAddToCart)).click();
		selenium.waitForPageToLoad("20000");
		driver.findElement(By.id(UIMapCheckOut.txtGCQty)).clear();
		driver.findElement(By.id(UIMapCheckOut.txtGCQty)).sendKeys("20");
		driver.findElement(By.id(UIMapCheckOut.txtGCQty)).sendKeys(Keys.TAB);
		try{
		String varQtyError=driver.findElement(By.xpath(UIMapCheckOut.lblGCQtyError)).getText();
		if(varQtyError.contains("Please enter a valid quantity."))
			report.updateTestLog("Entering Qty>10","Error Message displayed",Status.PASS);
		else
			report.updateTestLog("Entering Qty>10","Error Message NOT displayed",Status.FAIL);
		}
		catch(Exception e)
		{
			report.updateTestLog("Entering Invalid Qty","Error Message NOT displayed",Status.FAIL);
		}
		driver.findElement(By.id(UIMapCheckOut.txtGCQty)).clear();
		driver.findElement(By.id(UIMapCheckOut.txtGCQty)).sendKeys("1");
		new Select(driver.findElement(By.id(UIMapCheckOut.drpDownGCAmt))).selectByVisibleText("Other Amount");
		Thread.sleep(2000);
		driver.findElement(By.id(UIMapCheckOut.txtGCOtherAmt)).clear();
		driver.findElement(By.id(UIMapCheckOut.txtGCOtherAmt)).sendKeys("501");
		driver.findElement(By.id(UIMapCheckOut.txtGCOtherAmt)).sendKeys(Keys.TAB);;
		//Please enter a valid amount.
		try{
			String varAmtError=driver.findElement(By.xpath(UIMapCheckOut.lblGCAmtError)).getText();
			if(varAmtError.contains("Please enter a valid amount."))
				report.updateTestLog("Entering Amt>500","Error Message displayed",Status.PASS);
			else
				report.updateTestLog("Entering Amt>500","Error Message NOT displayed",Status.FAIL);
			}
		catch(Exception e)
		{
			report.updateTestLog("Entering Invalid Amount","Error Message NOT displayed",Status.FAIL);
		}
		
		
	}
	
	/*This function validates the error messages displayed on entering invalid Qty/Amt for Gift Card*/
	public void checkProductDescCart() throws Exception
	{
		int varCount=countWebElement(UIMapCheckOut.webElmntCartItems);
		String varAddedItemName=driver.findElement(By.xpath(UIMapCheckOut.webElmntCartItems+"["+varCount+"]/div[2]/div/a")).getText();
		driver.findElement(By.xpath(UIMapCheckOut.webElmntCartItems+"["+varCount+"]/div[2]/div/a")).click();
		selenium.waitForPageToLoad("20000");
		String varItemName=driver.findElement(By.xpath(UIMapProductSearch.webElmntProductName)).getText();
		if(varItemName.contains(varAddedItemName))
		{
			report.updateTestLog("Clicking Product Description","Product Details Page displayed",Status.PASS);
		}
		else
			report.updateTestLog("Clicking Product Description","Product Details Page NOT displayed",Status.FAIL);
		
	}
	
	/*This function opens mini cart model*/
	public void openMiniCart() throws Exception
	{
		Actions actions = new Actions(driver);
		WebElement varHoverMiniCart= driver.findElement(By.xpath(UIMapCheckOut.webElmntMiniCart));
		actions.moveToElement(varHoverMiniCart).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(5000);
	}
	/*This function validates whether added Item is displayed in Mini Cart and count is increased by 1*/
	public void checkMiniCart() throws Exception
	{
		int varCount=0,i=0;
		String varCartItemId=null;
		String varOldCount=dataTable.getData("General_Data", "CartCount");
		int oldCount=Integer.valueOf(varOldCount);
		System.out.println("Old Count:"+oldCount);
		String varItemAdded=null;
		int varNewCount=0;
		openMiniCart();
		Thread.sleep(2000);
		try{
			System.out.println(driver.findElement(By.xpath(UIMapCheckOut.webElmntMiniCartItemCount1)).getAttribute("id"));
			varNewCount=ps.countWebElement(UIMapCheckOut.webElmntMiniCartItemCount1);
			System.out.println("Items in Mini Cart:"+varNewCount);
			
		}
		catch(Exception NoSuchElementException)
		{
			System.out.println(driver.findElement(By.xpath(UIMapCheckOut.webElmntMiniCartItemCount2)).getAttribute("id"));
			varNewCount=ps.countWebElement(UIMapCheckOut.webElmntMiniCartItemCount2);
			System.out.println("Items in Mini Cart:"+varNewCount);
		}
		
		
		
		/*String varMiniCartCount=driver.findElement(By.id(UIMapCheckOut.webElmntMiniCartCount)).getText();
		int varNewCount=Integer.valueOf(varMiniCartCount);
		System.out.println("New Count:"+varNewCount);*/
		
		String varItemName=driver.findElement(By.xpath(UIMapProductSearch.webElmntProductName)).getText();
		
	
		String varItemNameTrimmed=null;
		String varItemAddedTrimmed=null;
		if(varItemName.length()>40)
		{
			System.out.println("varItemName length:"+varItemName.length());
			varItemNameTrimmed=varItemName.substring(0, 40);
			if(varItemNameTrimmed.contains("\""))
			{
				String[] s=varItemNameTrimmed.split("\"");
				varItemNameTrimmed=s[0];
			}
		}
		else
		{
			varItemNameTrimmed=varItemName;
			if(varItemNameTrimmed.contains("\""))
			{
				String[] s=varItemNameTrimmed.split("\"");
				varItemNameTrimmed=s[0];
			}
		}
		
		
		
		for(i=1;i<=varNewCount;i++)
		{
		if(i==4)
		{
		driver.findElement(By.xpath(UIMapCheckOut.webElmntMiniCartNextArrow)).click();
		Thread.sleep(2000);
		}
		if(varNewCount<=3)
		{
			varItemAdded=driver.findElement(By.xpath(UIMapCheckOut.lnkMiniCartItems+"["+i+"]/div[2]/div[2]/h3/a")).getText();
			System.out.println("varItemAdded::"+varItemAdded);
			varCartItemId=driver.findElement(By.xpath(UIMapCheckOut.lnkMiniCartItems+"["+i+"]")).getAttribute("id");
		}
		else
		{
			varItemAdded=driver.findElement(By.xpath(UIMapCheckOut.lnkMiniCartItems2+"["+i+"]/div[2]/div[2]/h3/a")).getText();
			System.out.println("varItemAdded::"+varItemAdded);
			varCartItemId=driver.findElement(By.xpath(UIMapCheckOut.lnkMiniCartItems2+"["+i+"]")).getAttribute("id");
		}
		/*if(varItemAdded.length()>40)
			varItemAddedTrimmed=varItemAdded.substring(0, 40);
		else
			varItemAddedTrimmed=varItemAdded;*/
		System.out.println("Reached here");
		System.out.println("varItemAdded:::"+varItemAdded);
		System.out.println("varItemNameTrimmed"+varItemNameTrimmed);
		System.out.println("length"+varItemNameTrimmed.length());
		if(varItemAdded.length()<varItemNameTrimmed.length())
			System.out.println(varItemAdded.length());
		else
			{varItemAddedTrimmed=varItemAdded.substring(0, varItemNameTrimmed.length());
			}
			
		System.out.println(varItemAddedTrimmed);
		System.out.println(varItemNameTrimmed);
		//if()
		if(varItemAddedTrimmed.equals(varItemNameTrimmed))//&&(varNewCount==(oldCount+1)))
		{
			report.updateTestLog("Checking Item Added in Mini Cart", "Item displayed in Mini Cart", Status.PASS);
			if(dataTable.getData("General_Data","EPPInPD").equals("Yes"))
			{
				boolean varEPP=driver.findElement(By.xpath("//*[@id='"+varCartItemId+"']/div[2]/div[4]")).isDisplayed();
				if(varEPP)
				{
					report.updateTestLog("Checking EPP Info for Item Added in Mini Cart", "EPP Info displayed for Item in Mini Cart", Status.PASS);
					String varEPPDisp=driver.findElement(By.xpath("//*[@id='"+varCartItemId+"']/div[2]/div[4]/h4")).getText();
					if(varEPPDisp.contains(dataTable.getData("General_Data", "EPPName")))
						report.updateTestLog("Checking EPP Info for Item Added in Mini Cart", "EPP Info CORRECT for Item in Mini Cart", Status.PASS);
					else
						report.updateTestLog("Checking EPP Info for Item Added in Mini Cart", "EPP Info NOT CORRECT for Item in Mini Cart", Status.FAIL);
				}
				else
					report.updateTestLog("Checking EPP Info for Item Added in Mini Cart", "EPP Info NOT displayed for Item in Mini Cart", Status.PASS);
			}
			break;
		}
		else
		{
			continue;
			
		}
		}
		if(i>varNewCount)
			report.updateTestLog("Checking Item Added in Mini Cart", "Item NOT displayed in Mini Cart", Status.FAIL);
	}
	
	/*This function validates whether added RTF Item is displayed in Mini Cart*/
	public void checkRTFInMiniCart() throws Exception
	{
		int i=0;
			
		String varItemAdded=null;
		String varMiniCartCount=driver.findElement(By.id(UIMapCheckOut.webElmntMiniCartCount)).getText();
		int varNewCount=Integer.valueOf(varMiniCartCount);
		System.out.println("New Count:"+varNewCount);
		
		String varItemName=dataTable.getData("General_Data", "RTFItemName");
		String varItemNameTrimmed=null;
		String varItemAddedTrimmed=null;
		if(varItemName.length()>40)
			varItemNameTrimmed=varItemName.substring(0, 40);
		else
			varItemNameTrimmed=varItemName;
		
		openMiniCart();
		
		for(i=1;i<=varNewCount;i++)
		{
		if(i==4)
		{
		driver.findElement(By.xpath(UIMapCheckOut.webElmntMiniCartNextArrow)).click();
		Thread.sleep(2000);
		}
		if(varNewCount<=3)
		{
			varItemAdded=driver.findElement(By.xpath(UIMapCheckOut.lnkMiniCartItems+"["+i+"]/div[2]/div[2]/h3/a")).getText();
			
		}
		else
		{
			varItemAdded=driver.findElement(By.xpath(UIMapCheckOut.lnkMiniCartItemName2+"["+i+"]/div[2]/div[2]/h3/a")).getText();
			
		}
		if(varItemAdded.length()>40)
		{
			varItemAddedTrimmed=varItemAdded.substring(0, 40);
			if(varItemNameTrimmed.contains("\""))
			{
				String[] s=varItemNameTrimmed.split("\"");
				varItemNameTrimmed=s[0];
			}
		}
		else
		{
			varItemAddedTrimmed=varItemAdded;
			if(varItemNameTrimmed.contains("\""))
			{
				String[] s=varItemNameTrimmed.split("\"");
				varItemNameTrimmed=s[0];
			}
		}
		System.out.println(varItemAddedTrimmed);
		System.out.println(varItemNameTrimmed);
		//if()
		if(varItemAddedTrimmed.equals(varItemNameTrimmed))//&&(varNewCount==(oldCount+1)))
		{
			report.updateTestLog("Checking RTF Item in Mini Cart", "RTF Item displayed in Mini Cart", Status.PASS);
			break;
		}
		else
		{
			continue;
			
		}
		}
		if(i>varNewCount)
			report.updateTestLog("Checking RTF Item in Mini Cart", "RTF Item NOT displayed in Mini Cart", Status.FAIL);
	}
	
	/*This function clicks on View Cart & CheckOut button on Mini Cart*/
	public void clickViewCartCheckOut() throws Exception
	{
		driver.findElement(By.xpath(UIMapCheckOut.btnViewCartCheckout)).click();
		selenium.waitForPageToLoad("20000");
		String varShoppingCart=selenium.getTitle();
		if(varShoppingCart.equals("Lowe's: Shopping Cart"))
		report.updateTestLog("Clicking View Cart & CheckOut button", "Shopping Cart displayed", Status.PASS);
		else
		report.updateTestLog("Clicking View Cart & CheckOut button", "Shopping Cart NOT displayed", Status.FAIL);
	}

	/*This function selects delivery method for an item on Details page, adds the same to cart and validates Mini Cart*/
	public void validateMiniCart() throws Exception
	{
		co.selectDlvryMthd();
		co.clickCheckOutFromDetails();
		co.clickContinueShopping();
		checkMiniCart();
	}
	
	/*This function adds an item from detail page, clicks on Continue checkout and validates Mini cart*/
	public void checkMiniCartfromDetail() throws Exception
	{
		co.clickCheckOutFromDetails();
		co.clickContinueShopping();
		//co.closeChckOutPopup();
		checkMiniCart();
	}
	
	public void checkoutFromDetail() throws Exception
	{
		co.clickCheckOutFromDetails();
		driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(2000);
	}
	
	
	
	/*This function selects EPP option on Product Details Page*/
	public void selectEPP() throws Exception
	{
		driver.findElement(By.xpath(UIMapCheckOut.chkBoxEPPOption1)).click();
		Thread.sleep(1000);
		String varEPPValue=driver.findElement(By.xpath(UIMapCheckOut.lblEPPOption1)).getText();
		
		dataTable.putData("General_Data", "EPPName", varEPPValue);
		
	}
	
	/*This function removes an Item with EPP from the cart*/
	public void removeEPPItemFromCart() throws Exception
	{
		
		WebElement EPPItem=driver.findElement(By.className(UIMapCheckOut.webElmntCartEPP));
		WebElement ItemMain=EPPItem.findElement(By.xpath(".."));
		WebElement ItemId=ItemMain.findElement(By.xpath(".."));
		
		String itemId=ItemId.getAttribute("id");
		System.out.println(itemId);
		
		driver.findElement(By.xpath("//*[@id='"+itemId+"']/div[2]/div[3]/a")).click();
		selenium.waitForPageToLoad("20000");
		String varItemXpath="//*[@id='"+itemId+"']";
		
		try{
			boolean varItemDisplayed=driver.findElement(By.xpath(varItemXpath)).isDisplayed();
			if(varItemDisplayed)
				report.updateTestLog("Clicking Remove for EPP Item", "EPP Item NOT removed", Status.FAIL);
			else
				report.updateTestLog("Clicking Remove for EPP Item", "EPP Item removed", Status.PASS);
			}
			catch(Exception NoSuchElementException)
			{
				report.updateTestLog("Clicking Remove for EPP Item", "EPP Item removed", Status.PASS);
			}
	}
	
	/*This function checks EPP Options*/
	public void checkEPP() throws Exception
	{
		try
		{
			String varEPPSection=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[6]/div[1]/div/strong")).getText();
			System.out.println(varEPPSection);
			if(varEPPSection.equals("Lowe's Protection Plan"))
			{
				if(dataTable.getData("General_Data", "IsEPP").equals("Yes"))
				{
					report.updateTestLog("Checking EPP Section for Item:"+dataTable.getData("General_Data", "ItemNbr"), "EPP Section displayed", Status.PASS);
					String varEPPOption1=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[6]/div[2]/label[1]")).getText();
					String pattern="2yr Extended Protection Plan (.*)";
					Pattern r = Pattern.compile(pattern);
					Matcher m = r.matcher(varEPPOption1);
					if(m.find())
					{
						report.updateTestLog("Checking EPP Option 1", "2yr Extended Protection Plan displayed", Status.PASS);
					}
					else
						report.updateTestLog("Checking EPP Option 1", "2yr Extended Protection Plan NOT displayed", Status.FAIL);
					String varEPPOption2=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[6]/div[2]/label[2]")).getText();
					 pattern="4yr Extended Protection Plan (.*)";
					 r = Pattern.compile(pattern);
					 m = r.matcher(varEPPOption2);
					if(m.find())
					{
						report.updateTestLog("Checking EPP Option 2", "4yr Extended Protection Plan displayed", Status.PASS);
					}
					else
						report.updateTestLog("Checking EPP Option 2", "4yr Extended Protection Plan NOT displayed", Status.FAIL);
					
					String varEPPOption3=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[6]/div[2]/label[3]")).getText();
					if(varEPPOption3.contains("No Thanks"))
						report.updateTestLog("Checking EPP Option 3", "No Thanks displayed", Status.PASS);
					else
						report.updateTestLog("Checking EPP Option 3", "No Thanks NOT displayed", Status.FAIL);
				}
				else
					report.updateTestLog("Checking EPP Section for Item:"+dataTable.getData("General_Data", "ItemNbr"), "EPP Section displayed", Status.FAIL);
			}
			else
			{
				if(dataTable.getData("General_Data", "IsEPP").equals("Yes"))
				{
					report.updateTestLog("Checking EPP Section for Item:"+dataTable.getData("General_Data", "ItemNbr"), "EPP Section NOT displayed", Status.FAIL);
				}
				else
					report.updateTestLog("Checking EPP Section for Item:"+dataTable.getData("General_Data", "ItemNbr"), "EPP Section NOT displayed", Status.PASS);
			}
		}
		catch(Exception NoSuchElementException)
		{
			if(dataTable.getData("General_Data", "IsEPP").equals("Yes"))
			{
				report.updateTestLog("Checking EPP Section for Item:"+dataTable.getData("General_Data", "ItemNbr"), "EPP Section NOT displayed", Status.FAIL);
			}
			else
				report.updateTestLog("Checking EPP Section for Item:"+dataTable.getData("General_Data", "ItemNbr"), "EPP Section NOT displayed", Status.PASS);
		}
		
		
		
	}
	
	/*This function selects EPP option(1/2/3) in CART page and Validates change in subtotal amt*/
	public void selectEPPInCart(int option, String oldCartSubtotal) throws Exception
	{
		
		String oldSubtotal=null;
		if(oldCartSubtotal.length()>7)
		{
			String s1[]=oldCartSubtotal.split(",");
			String s2=s1[0].substring(1,s1[0].length());
			oldSubtotal=s2.concat(s1[1]);
		}
		else
		{
			oldSubtotal=oldCartSubtotal.substring(1,oldCartSubtotal.length());
		}
		Double varOldSubtotalDbl=Double.valueOf(oldSubtotal);
		
		
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[6]/div[2]/label["+option+"]/input")).click();
		Thread.sleep(7000);
		if((option==1)||(option==2))
		{
		String varEPPOption=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[6]/div[2]/label["+option+"]")).getText();
		String  varEPPOptionValue=varEPPOption.substring(31, varEPPOption.length()-1);
		Double varEPPValue=Double.valueOf(varEPPOptionValue);
		Double newSubtotalDbl=varEPPValue+varOldSubtotalDbl;
		double roundOff = (double) Math.round(newSubtotalDbl * 100) / 100;
		String varSubTotalStr = String.format("%.2f", roundOff);
		
		
		String newCartSubtotal=driver.findElement(By.xpath(UIMapCheckOut.lblCartSubtotal)).getText();
		String newSubtotal=null;
		if(newCartSubtotal.length()>7)
		{
			String s1[]=newCartSubtotal.split(",");
			String s2=s1[0].substring(1,s1[0].length());
			newSubtotal=s2.concat(s1[1]);
		}
		else
		{
			newSubtotal=newCartSubtotal.substring(1,newCartSubtotal.length());
		}
		System.out.println(newSubtotal);
		System.out.println(varSubTotalStr);
		if(newSubtotal.equals(varSubTotalStr))
		{
			report.updateTestLog("Selecting EPP Option:"+option+" in Cart", "Selected EPP Amount added in Subtotal", Status.PASS);
		}
		else
		{
			report.updateTestLog("Selecting EPP Option:"+option+" in Cart", "Selected EPP Amount NOT added in Subtotal", Status.FAIL);
		}
	}
	else if(option==3)
	{
	String newCartSubtotal=driver.findElement(By.xpath(UIMapCheckOut.lblCartSubtotal)).getText();
	if(newCartSubtotal.equals(oldCartSubtotal))
		report.updateTestLog("Selecting EPP Option:"+option+" in Cart", "No Change in Subtotal", Status.PASS);
	else
		report.updateTestLog("Selecting EPP Option:"+option+" in Cart", "Change in Subtotal", Status.FAIL);
		
	}
	
		
		
		
	}
	
	/*This function checks changing EPP options changes subtotal based on selected option*/
	public void changeEPPInCart() throws Exception
	{
		checkEPP();
		String oldCartSubtotal=driver.findElement(By.xpath(UIMapCheckOut.lblCartSubtotal)).getText();
		selectEPPInCart(1,oldCartSubtotal);
		selectEPPInCart(2,oldCartSubtotal);
		selectEPPInCart(3,oldCartSubtotal);
	}
	
	/*This function selects Truck Delivery for an item in Cart and validates Est Truck delivery Charges*/
	public void verifyEstTruckDelCharges() throws Exception
	{
		String varOldEstSalesTax=driver.findElement(By.xpath(UIMapCheckOut.lblEstSalesTaxNoDeliverySelected)).getText();
		String varOldEstTaxValue=varOldEstSalesTax.substring(1, varOldEstSalesTax.length());
		Double  varOldEstTaxDbl=Double.valueOf(varOldEstTaxValue);
		
		co.selectDeliveryOptionCart();
		
		String varEstTruckDel=driver.findElement(By.xpath(UIMapCheckOut.lblEstDelLabel)).getText();
		if(varEstTruckDel.equals("Estimated Truck Delivery"))
		{
			report.updateTestLog("Checking Estimated Truck delivery Label", "Estimated Truck delivery Label displayed", Status.PASS);
			String varEstTruckDelValue=driver.findElement(By.xpath(UIMapCheckOut.lblEstDelValue)).getText();
			System.out.println(varEstTruckDelValue);
			String pattern="\\$\\d+\\.\\d+";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(varEstTruckDelValue);
			if(m.find())
				report.updateTestLog("Checking Estimated Truck delivery Value", "Estimated Truck delivery Value displayed", Status.PASS);	
			else
				report.updateTestLog("Checking Estimated Truck delivery Value", "Estimated Truck delivery Value NOT displayed", Status.FAIL);
			String varNewEstSalesTax=driver.findElement(By.xpath(UIMapCheckOut.lblEstSalesTax1DeliverySelected)).getText();
			String varNewEstTaxValue=varNewEstSalesTax.substring(1, varNewEstSalesTax.length());
			Double  varNewEstTaxDbl=Double.valueOf(varNewEstTaxValue);
			System.out.println(varNewEstTaxDbl);
			System.out.println(varOldEstTaxDbl);
			if(varNewEstTaxDbl>varOldEstTaxDbl)
				report.updateTestLog("Checking Estimated Sales Tax Value", "Truck delivery charges included in Sales Tax calculation", Status.PASS);	
			else
				report.updateTestLog("Checking Estimated Sales Tax Value", "Truck delivery charges NOT included in Sales Tax calculation", Status.FAIL);	
			driver.findElement(By.xpath(UIMapCheckOut.lblEstDelHelp)).click();
			Thread.sleep(2000);
			int divCount=ps.countWebElement(UIMapCheckOut.webElmntDivAll);
			System.out.println("Total Divisions:"+divCount);
			
			String varHelpTxt=driver.findElement(By.xpath("//*[@id='cart-page']/div["+divCount+"]/div[2]/p")).getText();
			if(!varHelpTxt.equals(""))
			{
				report.updateTestLog("Clicking Truck Delivery Help Icon", "Information related to truck delivery charges Displayed", Status.PASS);
			}
			else
				report.updateTestLog("Clicking Truck Delivery Help Icon", "Information related to truck delivery charges NOT Displayed", Status.FAIL);
		}
		else
			report.updateTestLog("Checking Estimated Truck delivery Label", "Estimated Truck delivery Label NOT displayed", Status.FAIL);
		
	}
	
	/*This function selects Parcel Shipping for an item in Cart and validates Est Parcel Shipping Charges*/
	public void verifyEstParcelDelCharges() throws Exception
	{
		String varOldEstSalesTax=driver.findElement(By.xpath(UIMapCheckOut.lblEstSalesTaxNoDeliverySelected)).getText();
		String varOldEstTaxValue=varOldEstSalesTax.substring(1, varOldEstSalesTax.length());
		Double  varOldEstTaxDbl=Double.valueOf(varOldEstTaxValue);
		
		co.selectDeliveryOptionCart();
		new Select(driver.findElement(By.id(UIMapCheckOut.drpDownParcelShippingOptions))).selectByIndex(2);
		
		Thread.sleep(10000);
		
		String varEstParcelDel=driver.findElement(By.xpath(UIMapCheckOut.lblEstDelLabel)).getText();
		if(varEstParcelDel.equals("Estimated Parcel Shipping"))
		{
			report.updateTestLog("Checking Estimated Parcel Shipping Label", "Estimated Estimated Parcel Shipping displayed", Status.PASS);
			String varParcelShippingAmt=driver.findElement(By.xpath(UIMapCheckOut.lblParcelShippingoption3)).getText();
			System.out.println("varParcelShippingAmt"+varParcelShippingAmt);
			String[] s1=varParcelShippingAmt.split("\\$");
			String s2=s1[1].trim();
			String varEstParcelDelValue=driver.findElement(By.xpath(UIMapCheckOut.lblEstDelValue)).getText();
			String varEstParcelDelValue2=varEstParcelDelValue.substring(1, varEstParcelDelValue.length());
			System.out.println(varEstParcelDelValue2);
			System.out.println(s2);
			if(varEstParcelDelValue2.equals(s2))
				report.updateTestLog("Checking Estimated Parcel Shipping Value", "Estimated Parcel Shipping Value based on option selected", Status.PASS);	
			else
				report.updateTestLog("Checking Estimated Parcel Shipping Value", "Estimated Parcel Shipping Value NOT based on option selected", Status.FAIL);
			String varNewEstSalesTax=driver.findElement(By.xpath(UIMapCheckOut.lblEstSalesTax1DeliverySelected)).getText();
			String varNewEstTaxValue=varNewEstSalesTax.substring(1, varNewEstSalesTax.length());
			Double  varNewEstTaxDbl=Double.valueOf(varNewEstTaxValue);
			System.out.println(varNewEstTaxDbl);
			System.out.println(varOldEstTaxDbl);
			if(varNewEstTaxDbl>varOldEstTaxDbl)
				report.updateTestLog("Checking Estimated Sales Tax Value", "Parcel Shipping charges included in Sales Tax calculation", Status.PASS);	
			else
				report.updateTestLog("Checking Estimated Sales Tax Value", "Parcel Shipping charges NOT included in Sales Tax calculation", Status.FAIL);	
			driver.findElement(By.xpath(UIMapCheckOut.lblEstDelHelp)).click();
			Thread.sleep(2000);
			int divCount=ps.countWebElement(UIMapCheckOut.webElmntDivAll);
			System.out.println("Total Divisions:"+divCount);
			String varHelpTxt=driver.findElement(By.xpath("//*[@id='cart-page']/div["+divCount+"]/div[2]/p")).getText();
			if(!varHelpTxt.equals(""))
			{
				report.updateTestLog("Clicking Parcel Shipping Help Icon", "Information related to Parcel Shipping charges Displayed", Status.PASS);
			}
			else
				report.updateTestLog("Clicking Parcel Shipping Help Icon", "Information related to Parcel Shipping charges NOT Displayed", Status.FAIL);
		}
		else
			report.updateTestLog("Checking Estimated Parcel Shipping Label", "Estimated Parcel Shipping Label NOT displayed", Status.FAIL);
		
	}
	
	/*This function adds RTF Item displayed in Parent Item Added Pop-up*/
	public void addRTFItemToCart() throws Exception
	{
		String varRTFItemId=driver.findElement(By.xpath(UIMapCheckOut.webElmntRTFItem1)).getAttribute("value");
		dataTable.putData("General_Data", "RTFItemId", varRTFItemId);
		String varRTFItemName=driver.findElement(By.xpath(UIMapCheckOut.lnkRTFItem1Name)).getText();
		dataTable.putData("General_Data", "RTFItemName", varRTFItemName);
		driver.findElement(By.xpath(UIMapCheckOut.btnRTFAddToCart)).click();
		Thread.sleep(5000);
		String varSuccess=driver.findElement(By.xpath(UIMapCheckOut.lblRTFAddedMsg)).getText();
		if(varSuccess.equals("Item Added to Cart"))
		{
			report.updateTestLog("Adding RTF Item To Cart","RTF Item Added to Cart",Status.PASS);
		}
		else
			report.updateTestLog("Adding RTF Item To Cart","RTF Item NOT Added to Cart",Status.FAIL);
	}
	
	/*This functiom validates whether added RTF Item is displayed in Cart properly*/
	public void validateRTFItemInCart() throws Exception
	{
		try{
			boolean varRTF=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "RTFItemId")+"']")).isDisplayed();
			if(varRTF)
			{
				report.updateTestLog("Checking RTF Item In Cart","RTF Item Displayed In Cart",Status.PASS);
				boolean varRTFDelOptions=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "RTFItemId")+"']/div[2]/div[2]/ul")).isDisplayed();
				if(varRTFDelOptions)
					report.updateTestLog("Checking RTF Item In Cart","RTF Item Delivery options Displayed In Cart",Status.PASS);
				else
					report.updateTestLog("Checking RTF Item In Cart","RTF Item Delivery options NOT Displayed In Cart",Status.FAIL);
				boolean varRTFPrice=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "RTFItemId")+"']/div[2]/div[5]")).isDisplayed();
				if(varRTFPrice)
					report.updateTestLog("Checking RTF Item In Cart","RTF Item Price Displayed In Cart",Status.PASS);
				else
					report.updateTestLog("Checking RTF Item In Cart","RTF Item Price NOT Displayed In Cart",Status.FAIL);
			}
			else
				report.updateTestLog("Checking RTF Item In Cart","RTF Item NOT Displayed In Cart",Status.FAIL);
			
		}
		catch(Exception NoSuchElementException)
		{
		report.updateTestLog("Checking RTF Item In Cart","RTF Item NOT Properly displayed In Cart",Status.FAIL);
		}
	}
	
	/*This function checks whether RTF Item is retained after Parent Item is deleted*/
	public void validateRTFAfterRemovingParent() throws Exception
	{
		try{
			boolean varRTF=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "RTFItemId")+"']")).isDisplayed();
			if(varRTF)
			{
				report.updateTestLog("Checking RTF Item In Cart After removing Parent Item","RTF Item Displayed In Cart",Status.PASS);
			}
			else
				report.updateTestLog("Checking RTF Item In Cart After removing Parent Item","RTF Item NOT Displayed In Cart",Status.FAIL);
			
		}
		catch(Exception NoSuchElementException)
		{
		report.updateTestLog("Checking RTF Item In Cart After removing Parent Item","RTF Item NOT Properly displayed In Cart",Status.FAIL);
		}
	}
	
	/*This function checks whether EPP is displayed as selected in Cart Page when selected from PD Page*/
	public void checkEPPSelected(int option) throws Exception
	{
		if(dataTable.getData("General_Data", "IsEPP").equals("Yes"))
		{
		try{
		String varChecked=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[6]/div[2]/label["+option+"]/input")).getAttribute("checked");
		System.out.println("Checked:"+varChecked);
		//String varChecked2=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[6]/div[2]/label["+option+"]/input")).getAttribute("class");
		//System.out.println(varChecked2);
		if(varChecked.equals("true"))
			report.updateTestLog("Checking Selected EPP In Cart","Epp Option displayed as Selected in Cart",Status.PASS);
		else
			report.updateTestLog("Checking Selected EPP In Cart","Epp Option NOT displayed as Selected in Cart",Status.FAIL);
		}
		catch(Exception NullPointerException)
		{
			report.updateTestLog("Checking Selected EPP In Cart","Epp Option NOT displayed as Selected in Cart",Status.FAIL);
		}
		}
		
			
	}
	
	/*This function updates EPP in Cart*/
	public void updateEPPCart(int option) throws Exception
	{
		if(dataTable.getData("General_Data", "IsEPP").equals("Yes"))
		{
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[6]/div[2]/label["+option+"]/input")).click();
		Thread.sleep(7000);
		if((option==1)||(option==2))
		{
			String varItemQty=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[3]/input")).getAttribute("value");
			String varEPPQty=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[6]/div[3]/ul/li")).getText();
			if(varItemQty.equals(varEPPQty))
			{
				report.updateTestLog("Checking EPP Qty In Cart","Epp Qty same as Parent Element Qty in Cart",Status.PASS);
				try{
					driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[6]/div[3]/ul/li")).sendKeys("1");
					report.updateTestLog("Checking EPP Qty In Cart after selecting Option:"+option,"Epp Qty NOT readonly in Cart",Status.FAIL);
				}
				catch(Exception e)
				{
					report.updateTestLog("Checking EPP Qty In Cart after selecting Option:"+option,"Epp Qty readonly in Cart",Status.PASS);
				}
			}
		String varEPPOption=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[6]/div[2]/label["+option+"]")).getText();
		String  varEPPOptionValue=varEPPOption.substring(31, varEPPOption.length()-1);
		String varEPPPrice=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[6]/div[4]/ul/li")).getText();
		String[] s1=varEPPPrice.split("\\$");
		
		System.out.println(varEPPOptionValue);
		System.out.println(s1[1]);
		if(varEPPOptionValue.equals(s1[1]))
		{
			report.updateTestLog("Checking EPP Price In Cart after selecting Option:"+option,"Epp Price displayed based on EPP Option in Cart",Status.PASS);
		}
		else
			report.updateTestLog("Checking EPP Price In Cart after selecting Option:"+option,"Epp Price NOT displayed based on EPP Option in Cart",Status.FAIL);
		
		
		}
		else if(option==3)
		{
			try{
				boolean varItemNbr=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[6]/div[1]/div[2]")).isDisplayed();
				if(varItemNbr)
					report.updateTestLog("Checking EPP Item Nbr In Cart after selecting No Thanks","Epp Item  Nbr displayed in Cart",Status.FAIL);
			}
			catch(Exception e)
			{
				report.updateTestLog("Checking EPP Item Nbr In Cart after selecting No Thanks","Epp Item  Nbr NOT displayed in Cart",Status.PASS);
			}
			try{
				boolean varItemNbr=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[6]/div[3]/ul/li")).isDisplayed();
				if(varItemNbr)
					report.updateTestLog("Checking EPP Item Qty In Cart after selecting No Thanks","Epp Item  Qty displayed in Cart",Status.FAIL);
			}
			catch(Exception e)
			{
				report.updateTestLog("Checking EPP Item Qty In Cart after selecting No Thanks","Epp Item  Qty NOT displayed in Cart",Status.PASS);
			}
			try{
				boolean varItemNbr=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[6]/div[4]/ul/li")).isDisplayed();
				if(varItemNbr)
					report.updateTestLog("Checking EPP Item Price In Cart after selecting No Thanks","Epp Item  Price displayed in Cart",Status.FAIL);
			}
			catch(Exception e)
			{
				report.updateTestLog("Checking EPP Item Price In Cart after selecting No Thanks","Epp Item  Price NOT displayed in Cart",Status.PASS);
			}
		}
		}
		
	}
	
	/*This function validates EPP when EPP is added from PD Page*/
	public void validateEPPAddedFromDetails() throws Exception
	{
		checkEPP();
		checkEPPSelected(1);
		
		//checking qty 
		String varItemQty=driver.findElement(By.xpath(UIMapCheckOut.txtQtyCart)).getAttribute("value");
		String varEPPQty=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[6]/div[3]/ul/li")).getText();
		if(varItemQty.equals(varEPPQty))
		{
			report.updateTestLog("Checking EPP Qty In Cart","Epp Qty same as Parent Element Qty in Cart",Status.PASS);
			try{
				driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[6]/div[3]/ul/li")).sendKeys("1");
				report.updateTestLog("Checking EPP Qty In Cart","Epp Qty NOT readonly in Cart",Status.FAIL);
			}
			catch(Exception e)
			{
				report.updateTestLog("Checking EPP Qty In Cart","Epp Qty readonly in Cart",Status.PASS);
			}
		}
		else
			report.updateTestLog("Checking EPP Qty In Cart","Epp Qty NOT same as Parent Element Qty in Cart",Status.FAIL);
		updateEPPCart(2);
		updateEPPCart(3);
		
	}

	/*This function validates the default EPP Option is No Thanks when EPP was not selected in Details page*/
	public void checkDefaultEPPNoThanks() throws Exception
	{
		try{
		String varChecked=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[6]/div[2]/label[3]/input")).getAttribute("checked");
		System.out.println("Checked:"+varChecked);
		//String varChecked2=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[6]/div[2]/label["+option+"]/input")).getAttribute("class");
		//System.out.println(varChecked2);
		if(varChecked.equals("true"))
			report.updateTestLog("Checking Default EPP In Cart","Epp Option No Thanks as Selected in Cart",Status.PASS);
		else
			report.updateTestLog("Checking Default EPP In Cart","Epp Option No Thanks NOT Selected in Cart",Status.FAIL);
		}
		catch(Exception NullPointerException)
		{
			report.updateTestLog("Checking Default EPP In Cart","Epp Option No Thanks NOT Selected in Cart",Status.FAIL);
		}
	}
	
	/*This function checks whether EPP Qty is updated on updating Parent Item Qty*/
	public void checkEPPQtyAfterParentQtyUpdate() throws Exception
	{
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[3]/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[3]/input")).clear();
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[3]/input")).sendKeys("2");
		driver.findElement(By.xpath(UIMapCheckOut.btnQtyUpdate)).click();
		Thread.sleep(10000);
		String varItemQty=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[3]/input")).getAttribute("value");
		String varEPPQty=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[6]/div[3]/ul/li")).getText();
		if(varItemQty.equals(varEPPQty))
		{
			report.updateTestLog("Checking EPP Qty In Cart After Updating Item Qty","Epp Qty Also Updated",Status.PASS);
			try{
				driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[6]/div[3]/ul/li")).sendKeys("1");
				report.updateTestLog("Checking EPP Qty In Cart After Updating Item Qty","Updated Epp Qty NOT ReadOnly",Status.FAIL);
			}
			catch(Exception e)
			{
				report.updateTestLog("Checking EPP Qty In Cart After Updating Item Qty","Updated Epp Qty readonly in Cart",Status.PASS);
			}
		}
		else
			report.updateTestLog("Checking EPP Qty In Cart After Updating Item Qty","Epp Qty NOT NOT updated",Status.FAIL);
	}
	
	/*This function checks whether EPP Total Price is EPP Unit Price*Qty*/
	public void checkEPPTotalPrice() throws Exception
	{
		String varEPPQty=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[6]/div[3]/ul/li")).getText();
		int varQty=Integer.valueOf(varEPPQty);
		String varEPPPrice=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[6]/div[4]/ul/li")).getText();
		String[] s1=varEPPPrice.split("\\$");
		double varUnitPrice=Double.valueOf(s1[1]);
		double varTotalPrice=varUnitPrice*varQty;
		System.out.println(varTotalPrice);
		double roundOff = (double) Math.round(varTotalPrice * 100) / 100;
		System.out.println("After Round Off:"+roundOff);
		String varTotalPriceStr = String.format("%.2f", roundOff);
		String varEPPTotalPrice="$"+varTotalPriceStr;
		String varTotalPriceDisp=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[6]/div[5]/ul/li")).getText();
		System.out.println(varEPPTotalPrice);
		System.out.println(varTotalPriceDisp);
		if(varTotalPriceDisp.equals(varEPPTotalPrice))
			report.updateTestLog("Checking EPP Total Price","Epp Total Price calculation correct",Status.PASS);
		else
			report.updateTestLog("Checking EPP Total Price","Epp Total Price calculation NOT correct",Status.FAIL);
		
	}
	
	/*This function checks the EPP functionality when Parent Qty is updated*/
	public void checkEPPParentQty() throws Exception
	{
		checkEPP();
		checkDefaultEPPNoThanks();
		updateEPPCart(2);
		checkEPPQtyAfterParentQtyUpdate();
		checkEPPTotalPrice();
	}
	
	/*This function validates EPP displayed properly when cart has 2 items-1 EPP,1-Without EPP*/
	public void checkEPPMultipleItemsInCart() throws Exception
	{
		checkEPPSelected(1);
		updateEPPCart(2);
		updateEPPCart(3);
	}
	
	/*This function adds GiftCard to Cart*/
	public void addGiftCardCart() throws Exception
	{
		driver.findElement(By.xpath(UIMapCheckOut.btnAddToCart)).click();
		selenium.waitForPageToLoad("20000");
		String varGCItemId=driver.findElement(By.id(UIMapCheckOut.webElmntGCItemId)).getAttribute("value");
		System.out.println(varGCItemId);
		dataTable.putData("General_Data", "GiftCardItemId", varGCItemId);
		driver.findElement(By.xpath(UIMapCheckOut.btnGCCheckOut)).click();
		selenium.waitForPageToLoad("20000");
		boolean varShoppingCart=selenium.isTextPresent("Products in Cart");
		if(varShoppingCart)
			report.updateTestLog("CheckOut clicked for Gift Card", "Shopping Cart displayed", Status.PASS);
		else
			report.updateTestLog("CheckOut clicked for Gift Card", "Shopping Cart NOT displayed", Status.FAIL);
	}
	
	/*This function validates whether added GiftCard is displayed in Shopping Cart*/
	public void checkGiftCardInCart() throws Exception
	{
		try{
		boolean varItem=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']")).isDisplayed();
		if(varItem)
		{
			report.updateTestLog("Checking Gift Card In Cart","Gift Card displayed in Cart",Status.PASS);
		}
		else
			report.updateTestLog("Checking Gift Card In Cart","Gift Card NOT displayed in Cart",Status.FAIL);
		}
		catch(Exception NoSuchElementException)
		{
			report.updateTestLog("Checking Gift Card In Cart","Gift Card NOT displayed in Cart",Status.FAIL);
		}
	}
	
	/*This function validates links*/
	public void verifyShoppingCartLinks() throws Exception
	{
		int divCount=0;
		//Shipping & Delivery
		boolean varShoppingDel=driver.findElement(By.partialLinkText("Shipping & Delivery")).isDisplayed();
		if(varShoppingDel)
		{
			report.updateTestLog("Checking Shipping & Delivery link","Shipping & Delivery displayed in Shopping Cart",Status.PASS);
			driver.findElement(By.partialLinkText("Shipping & Delivery")).click();
			Thread.sleep(1000);
			divCount=ps.countWebElement(UIMapCheckOut.webElmntDivAll);
			System.out.println("Total Divisions:"+divCount);
			
			//boolean varPopup=driver.findElement(By.xpath(UIMapCheckOut.webElmntShippingDelInfo)).isDisplayed();
			boolean varPopup=driver.findElement(By.xpath("//*[@id='cart-page']/div["+divCount+"]/div[2]")).isDisplayed();
			if(varPopup)
			{
				report.updateTestLog("Clicking Shipping & Delivery link","Shipping & Delivery Information displayed",Status.PASS);
				//driver.findElement(By.xpath(UIMapCheckOut.webElmntShippingDelInfoClose)).click();
				driver.findElement(By.xpath("//*[@id='cart-page']/div["+divCount+"]/div[1]/a/span")).click();
				Thread.sleep(3000);
				
			}
			else
			{
				report.updateTestLog("Clicking Shipping & Delivery link","Shipping & Delivery Information NOT displayed",Status.FAIL);
			}
		}
		else
			report.updateTestLog("Checking Shipping & Delivery link","Shipping & Delivery NOT displayed in Shopping Cart",Status.FAIL);
		
		//Easy Returns & Exchanges
		boolean varEasyReturns=driver.findElement(By.partialLinkText("Easy Returns & Exchanges")).isDisplayed();
		if(varEasyReturns)
		{
			report.updateTestLog("Checking Easy Returns & Exchanges link","Easy Returns & Exchanges displayed in Shopping Cart",Status.PASS);
			driver.findElement(By.partialLinkText("Easy Returns & Exchanges")).click();
			Thread.sleep(1000);
			divCount=ps.countWebElement(UIMapCheckOut.webElmntDivAll);
			System.out.println("Total Divisions:"+divCount);
			//boolean varPopup=driver.findElement(By.xpath(UIMapCheckOut.webElmntEasyExchangeInfo)).isDisplayed();
			boolean varPopup=driver.findElement(By.xpath("//*[@id='cart-page']/div["+divCount+"]/div[2]")).isDisplayed();
			if(varPopup)
			{
				report.updateTestLog("Clicking Easy Returns & Exchanges link","Easy Returns & Exchanges Information displayed",Status.PASS);
				//driver.findElement(By.xpath(UIMapCheckOut.webElmntEasyExchangeInfoClose)).click();
				driver.findElement(By.xpath("//*[@id='cart-page']/div["+divCount+"]/div[1]/a/span")).click();
				Thread.sleep(3000);
				
			}
			else
			{
				report.updateTestLog("Clicking Easy Returns & Exchanges link","Easy Returns & Exchanges Information NOT displayed",Status.FAIL);
			}
		}
		else
			report.updateTestLog("Checking Easy Returns & Exchanges link","Easy Returns & Exchanges NOT displayed in Shopping Cart",Status.FAIL);
		
		//Shopping Cart Your purchase is always safe and secure.
		String varShoppingCart=driver.findElement(By.xpath(UIMapCheckOut.lblShoppingCart)).getText();
		System.out.println(varShoppingCart);
		if(varShoppingCart.equals("Shopping Cart Your purchase is always safe and secure."))
		{
			String varSafeSecure=driver.findElement(By.xpath(UIMapCheckOut.lnkSafeSecure)).getText();
			if(varSafeSecure.equals("safe and secure."))
			{
				report.updateTestLog("Checking Safe & secure link","Safe & secure link embedded with 'Shopping Cart Your purchase is always safe and secure' heading.",Status.PASS);
			}
			else
				report.updateTestLog("Checking Safe & secure link","Safe & secure link NOT embedded with 'Shopping Cart Your purchase is always safe and secure' heading.",Status.FAIL);
		}
		else
			report.updateTestLog("Checking Safe & secure link","'Shopping Cart Your purchase is always safe and secure' heading Not Displayed",Status.FAIL);
		
		//Change Store
		boolean varChangeStore=driver.findElement(By.partialLinkText("Change Store")).isDisplayed();
		if(varChangeStore)
		{
			report.updateTestLog("Checking Change Store link","Change Store link displayed",Status.PASS);
		}
		else
			report.updateTestLog("Checking Change Store link","Change Store link NOT displayed",Status.FAIL);
		
		//Continue Shopping
		boolean varContinueShopping=driver.findElement(By.partialLinkText("Continue Shopping")).isDisplayed();
		if(varContinueShopping)
		{
			report.updateTestLog("Checking Continue Shopping Link", "Checking Continue Shopping Link displayed", Status.PASS);
			
			driver.findElement(By.partialLinkText("Continue Shopping")).click();
			Thread.sleep(1000);
			divCount=ps.countWebElement(UIMapCheckOut.webElmntDivAll);
			System.out.println("Total Divisions:"+divCount);
			boolean varCSPopup=driver.findElement(By.xpath(UIMapCheckOut.webElmntContinueShoppingPopup)).isDisplayed();
			
			if(varCSPopup)
			{
			String varPopupTxt=driver.findElement(By.xpath(UIMapCheckOut.lblContinueShoppingPopup)).getText();
				
				
				System.out.println(varPopupTxt);
			
			boolean varBackToHome=driver.findElement(By.partialLinkText("Back to Home")).isDisplayed();
			if((varPopupTxt.equals("Continue Shopping"))&&varBackToHome)
			{
				report.updateTestLog("Clicking Continue Shopping Link", "Continue Shopping Popup properly displayed", Status.PASS);
				//driver.findElement(By.xpath(UIMapCheckOut.webElmntContinueShoppingClose)).click();
				driver.findElement(By.xpath("//*[@id='cart-page']/div["+divCount+"]/div[1]/a/span")).click();
				Thread.sleep(3000);
			}
			else
				report.updateTestLog("Clicking Continue Shopping Link", "Continue Shopping Popup NOT properly displayed", Status.FAIL);
			}
			else
				report.updateTestLog("Clicking Continue Shopping Link", "Continue Shopping Popup NOT displayed", Status.FAIL);
			
		}
		else
			report.updateTestLog("Checking Continue Shopping Link", "Checking Continue Shopping Link NOT displayed", Status.FAIL);
	}
	
	/*This function validates links/Static text in Shopping Cart*/
	public void verifyShoppingCartElements() throws Exception
	{
		verifyShoppingCartLinks();
		
		//Store Info & Hours
		try{
			boolean varStoreInfoHours=driver.findElement(By.partialLinkText("Store Info & Hours")).isDisplayed();
			if(varStoreInfoHours)
			{
				report.updateTestLog("Checking Store Info & Hours link","Store Info & Hours link displayed",Status.FAIL);
			}
			else
				report.updateTestLog("Checking Store Info & Hours link","Store Info & Hours link NOT displayed",Status.PASS);
		}
		catch(Exception NoSuchElementException){
			report.updateTestLog("Checking Store Info & Hours link","Store Info & Hours link NOT displayed",Status.PASS);
		}
		
		
		
		//Empty Cart
		boolean varEmptyCart=selenium.isTextPresent("Empty Cart");
		if(varEmptyCart)
			report.updateTestLog("Checking Empty Cart option", "Empty Cart option displayed", Status.FAIL);
		else
			report.updateTestLog("Checking Empty Cart option", "Empty Cart option NOT displayed", Status.PASS);
		
		//Start Secure Checkout
		boolean varStrtCheckout1=driver.findElement(By.xpath(UIMapCheckOut.btnStrtSecureChkOut1)).isDisplayed();
		boolean varStrtCheckout2=driver.findElement(By.xpath(UIMapCheckOut.btnStrtSecureChkOut2)).isDisplayed();
		if(varStrtCheckout1&&varStrtCheckout2)
		{
			report.updateTestLog("Checking Start Secure Checkout buttons", "2 Start Secure Checkout buttons displayed", Status.PASS);
			boolean varStrtCheckout1Img=driver.findElement(By.xpath(UIMapCheckOut.webElmntStrtChkOut1Img)).isDisplayed();
			boolean varStrtCheckout2Img=driver.findElement(By.xpath(UIMapCheckOut.webElmntStrtChkOut2Img)).isDisplayed();
			if(varStrtCheckout1Img&&varStrtCheckout2Img)
			{
				report.updateTestLog("Checking Image in Start Secure Checkout buttons", "Image in Start Secure Checkout buttons displayed", Status.PASS);
			}
		}
		else
			report.updateTestLog("Checking Start Secure Checkout buttons", "2 Start Secure Checkout buttons NOT displayed", Status.FAIL);
		
		//Cart summary
		String varCartSummary=driver.findElement(By.xpath(UIMapCheckOut.lblCartSummary)).getText();
		if(varCartSummary.equals("Cart Summary"))
			report.updateTestLog("Checking Cart Summary", "Cart Summary displayed", Status.PASS);
		else
			report.updateTestLog("Checking Cart Summary", "Cart Summary NOT displayed", Status.FAIL);
		
		//ParcelShipping
		String varParcelShipping=driver.findElement(By.xpath(UIMapCheckOut.lblEstParcelShippingCharges)).getText();
		System.out.println(varParcelShipping);
		boolean varParcelIcon=driver.findElement(By.xpath(UIMapCheckOut.webElmntParcelShippingIcon)).isDisplayed();
		System.out.println(varParcelIcon);
		boolean varParcelHelp=driver.findElement(By.xpath(UIMapCheckOut.webElmntParcelShippingHelp)).isDisplayed();
		System.out.println(varParcelHelp);
		if((varParcelShipping.trim().equals("Estimate Parcel Shipping Charges"))&& varParcelIcon && varParcelHelp)
		{
			report.updateTestLog("Checking Parcel Shipping", "Estimate Parcel Shipping Charges displayed with Icon and help link", Status.PASS);
		}
		else
			report.updateTestLog("Checking Parcel Shipping", "Estimate Parcel Shipping Charges NOT displayed with Icon and help link", Status.FAIL);
		
		//Promotion code
		String varPromoCode	=driver.findElement(By.xpath(UIMapCheckOut.lblPromoCode)).getText();
		System.out.println(varPromoCode.trim());
		boolean varPromoField=driver.findElement(By.id(UIMapCheckOut.txtPromoCode)).isDisplayed();
		System.out.println(varPromoField);
		boolean varPromocodeHelp=driver.findElement(By.xpath(UIMapCheckOut.webElmntPromoCodeHelp)).isDisplayed();
		System.out.println(varPromocodeHelp);
		if((varPromoCode.trim().equals("Promotion Code"))&& varPromoField && varPromocodeHelp)
		{
			report.updateTestLog("Checking Promotion Code", "Promotion Code displayed with Input field and help link", Status.PASS);
		}
		else
			report.updateTestLog("Checking Promotion Code", "Promotion Code NOT displayed with Input field and help link", Status.FAIL);
		
		//Subtotal
		String varSubtotal=driver.findElement(By.xpath(UIMapCheckOut.lblSubTotal)).getText();
		System.out.println(varSubtotal);
		boolean varSubtotalValue =driver.findElement(By.xpath(UIMapCheckOut.lblSubTotalValue)).isDisplayed();
		System.out.println(varSubtotalValue);
		if((varSubtotal.equals("Subtotal")) && varSubtotalValue)
		{
			report.updateTestLog("Checking Subtotal", "Subtotal displayed with value", Status.PASS);
		}
		else
			report.updateTestLog("Checking Subtotal", "Subtotal NOT displayed with value", Status.FAIL);
		//Estimated Truck Delivery
		String varEstTruckDel=driver.findElement(By.xpath(UIMapCheckOut.lblDel1Charges)).getText();
		System.out.println(varEstTruckDel.trim());
		boolean varEstTruckDelValue =driver.findElement(By.xpath(UIMapCheckOut.lblDel1ChargesValue)).isDisplayed();
		System.out.println(varEstTruckDelValue);
		if((varEstTruckDel.trim().equals("Estimated Truck Delivery")) && varEstTruckDelValue)
		{
			report.updateTestLog("Checking Estimated Truck Delivery", "Estimated Truck Delivery displayed with value", Status.PASS);
		}
		else
			report.updateTestLog("Checking Estimated Truck Delivery", "Estimated Truck Delivery NOT displayed with value", Status.FAIL);
		//Estimated Parcel Shipping
		String varEstParcel=driver.findElement(By.xpath(UIMapCheckOut.lblDel2Charges)).getText();
		boolean varEstParcelValue =driver.findElement(By.xpath(UIMapCheckOut.lblDel2ChargesValue)).isDisplayed();
		if((varEstParcel.trim().equals("Estimated Parcel Shipping")) && varEstParcelValue)
		{
			report.updateTestLog("Checking Estimated Parcel Shipping", "Estimated Parcel Shipping displayed with value", Status.PASS);
			
		}
		else
			report.updateTestLog("Checking Estimated Parcel Shipping", "Estimated Parcel Shipping NOT displayed with value", Status.FAIL);
		
		//30 days message
		String varCart30DaysMsg=driver.findElement(By.xpath(UIMapCheckOut.lbl30DaysCartMsg)).getText();
		
		if((varCart30DaysMsg.trim().equals("Items may remain in your cart for up to 30 days.")))
		{
			report.updateTestLog("Checking Items may remain in your cart for up to 30 days.", "Items may remain in your cart for up to 30 days. displayed", Status.PASS);
		}
		else
			report.updateTestLog("Checking Items may remain in your cart for up to 30 days.", "Items may remain in your cart for up to 30 days. NOT displayed", Status.FAIL);
		
		
		
	}
	
	public void checkAddedGiftCard() throws Exception
	{
		String varTo=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[1]/div[2]/ol/li[1]/label")).getText();
		boolean varToField=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[1]/div[2]/ol/li[1]/input")).isDisplayed();
		
		if((varTo.equals("To:")) && varToField)
			report.updateTestLog("Checking Gift Card To:", "Gift Card To: displayed with Field", Status.PASS);
		else
			report.updateTestLog("Checking Gift Card To:", "Gift Card To: NOT displayed with Field", Status.FAIL);
		
		String varFrom=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[1]/div[2]/ol/li[2]/label")).getText();
		boolean varFromField=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[1]/div[2]/ol/li[2]/input")).isDisplayed();
		
		if((varFrom.equals("From:")) && varFromField)
			report.updateTestLog("Checking Gift Card From:", "Gift Card From: displayed with Field", Status.PASS);
		else
			report.updateTestLog("Checking Gift Card From:", "Gift Card From: NOT displayed with Field", Status.FAIL);
		
		String varMsg=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[1]/div[2]/ol/li[3]/label")).getText();
		System.out.println(varMsg);
		boolean varMsgField=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[1]/div[2]/ol/li[3]/textarea")).isDisplayed();
		System.out.println(varMsgField);
		if((varMsg.equals("Message:")) && varMsgField)
			report.updateTestLog("Checking Gift Card Message:", "Gift Card Message: displayed with Field", Status.PASS);
		else
			report.updateTestLog("Checking Gift Card Message:", "Gift Card Message: NOT displayed with Field", Status.FAIL);
		
		String varEstParcelFREE =driver.findElement(By.xpath(UIMapCheckOut.lblDel2ChargesValue)).getText();
		if(varEstParcelFREE.trim().equalsIgnoreCase("FREE"))
			report.updateTestLog("Checking Free Parcel for Gift Card", "Free Parcel for Gift Card displayed", Status.PASS);
		else
			report.updateTestLog("Checking Free Parcel for Gift Card", "Free Parcel for Gift Card NOT displayed", Status.PASS);
	}
	
	
	/*This function validates Empty Cart*/
	public void verifyEmptyCart() throws Exception
	{
		String varClass=driver.findElement(By.xpath(UIMapCheckOut.webElmntEmptyCart)).getAttribute("class");
		if(varClass.equals("empty-cart-items"))
		{
			report.updateTestLog("Checking Empty Cart Section", "Empty Cart Section displayed", Status.PASS);
			String varEmptyCartHd=driver.findElement(By.xpath(UIMapCheckOut.lblEmptyCartHeading)).getText();
			System.out.println(varEmptyCartHd);
			String varEmptyCartTxt1=driver.findElement(By.xpath(UIMapCheckOut.lblEmptyCartTxt1)).getText();
			System.out.println(varEmptyCartTxt1);
			String varEmptyCartTxt2=driver.findElement(By.xpath(UIMapCheckOut.lblEmptyCartTxt2)).getText();
			System.out.println(varEmptyCartTxt2);
			if((varEmptyCartHd.trim().equals("Your Shopping Cart Is Empty")) && (varEmptyCartTxt1.trim().equalsIgnoreCase("Shopping cart items expire after 30 days.")) && (varEmptyCartTxt2.trim().contains("Save every day at Lowe's. Get 5% off every purchase when you use your Lowe's Consumer Credit Card.")) && (varEmptyCartTxt2.trim().contains("To find other great values, browse Featured Promotions or shop products with New Lower Prices.")))
					{
				report.updateTestLog("Checking Empty Cart Message", "Empty Cart Message correctly displayed", Status.PASS);
					}
			else
				report.updateTestLog("Checking Empty Cart Message", "Empty Cart Message NOT correctly displayed", Status.FAIL);
			
			String varSubtotal=driver.findElement(By.xpath(UIMapCheckOut.lblEmptyCartSubtotal)).getText();
			if(varSubtotal.trim().equals("Subtotal"))
			{
				report.updateTestLog("Checking Subtotal label", "Subtotal label displayed", Status.PASS);
				String varSubtotalValue=driver.findElement(By.xpath(UIMapCheckOut.lblEmptyCartSubtotalValue)).getText();
				if(varSubtotalValue.equals("$0.00"))
					report.updateTestLog("Checking Subtotal value", "Subtotal value $0.00 displayed", Status.PASS);
				else
					report.updateTestLog("Checking Subtotal value", "Subtotal value $0.00 NOT displayed", Status.FAIL);
			}
			else
				report.updateTestLog("Checking Subtotal label", "Subtotal label displayed", Status.PASS);
			
			String varEstSalesTax=driver.findElement(By.xpath(UIMapCheckOut.lblEmptyCartEstSalesTax)).getText();
			if(varEstSalesTax.trim().equals("Estimated Sales Tax"))
			{
				report.updateTestLog("Checking Estimated Sales Tax label", "Estimated Sales Tax label displayed", Status.PASS);
				String varEstSalesTaxValue=driver.findElement(By.xpath(UIMapCheckOut.lblEmptyCartEstSalesTaxValue)).getText();
				if(varEstSalesTaxValue.equals("$0.00"))
					report.updateTestLog("Checking Estimated Sales Tax value", "Estimated Sales Tax value $0.00 displayed", Status.PASS);
				else
					report.updateTestLog("Checking Estimated Sales Tax value", "Estimated Sales Tax value $0.00 NOT displayed", Status.FAIL);
			}
			else
				report.updateTestLog("Checking Estimated Sales Tax label", "Estimated Sales Tax label displayed", Status.PASS);
			
			String varEstTotal=driver.findElement(By.xpath(UIMapCheckOut.lblEmptyCartEstTotal)).getText();
			if(varEstTotal.trim().equals("Estimated Total"))
			{
				report.updateTestLog("Checking Estimated Total label", "Estimated Total label displayed", Status.PASS);
				String varEstTotalValue=driver.findElement(By.xpath(UIMapCheckOut.lblEmptyCartEstTotalValue)).getText();
				if(varEstTotalValue.equals("$0.00"))
					report.updateTestLog("Checking Estimated Total value", "Estimated Total value $0.00 displayed", Status.PASS);
				else
					report.updateTestLog("Checking Estimated Total value", "Estimated Total value $0.00 NOT displayed", Status.FAIL);
			}
			else
				report.updateTestLog("Checking Estimated Total label", "Estimated Total label displayed", Status.PASS);
			//Shipping & Delivery
			boolean varShoppingDel=driver.findElement(By.partialLinkText("Shipping & Delivery")).isDisplayed();
			if(varShoppingDel)
			{
				report.updateTestLog("Checking Shipping & Delivery link","Shipping & Delivery displayed in Shopping Cart",Status.PASS);
				driver.findElement(By.partialLinkText("Shipping & Delivery")).click();
				Thread.sleep(1000);
				boolean varPopup=driver.findElement(By.xpath(UIMapCheckOut.webElmntShippingDelInfo)).isDisplayed();
				if(varPopup)
				{
					report.updateTestLog("Clicking Shipping & Delivery link","Shipping & Delivery Information displayed",Status.PASS);
					driver.findElement(By.xpath(UIMapCheckOut.webElmntShippingDelInfoClose)).click();
					Thread.sleep(3000);
					
				}
				else
				{
					report.updateTestLog("Clicking Shipping & Delivery link","Shipping & Delivery Information NOT displayed",Status.FAIL);
				}
			}
			else
				report.updateTestLog("Checking Shipping & Delivery link","Shipping & Delivery NOT displayed in Shopping Cart",Status.FAIL);
			
			//Easy Returns & Exchanges
			boolean varEasyReturns=driver.findElement(By.partialLinkText("Easy Returns & Exchanges")).isDisplayed();
			if(varEasyReturns)
			{
				report.updateTestLog("Checking Easy Returns & Exchanges link","Easy Returns & Exchanges displayed in Shopping Cart",Status.PASS);
				driver.findElement(By.partialLinkText("Easy Returns & Exchanges")).click();
				Thread.sleep(1000);
				boolean varPopup=driver.findElement(By.xpath(UIMapCheckOut.webElmntEasyExchangeInfo)).isDisplayed();
				if(varPopup)
				{
					report.updateTestLog("Clicking Easy Returns & Exchanges link","Easy Returns & Exchanges Information displayed",Status.PASS);
					driver.findElement(By.xpath(UIMapCheckOut.webElmntEasyExchangeInfoClose)).click();
					Thread.sleep(3000);
					
				}
				else
				{
					report.updateTestLog("Clicking Easy Returns & Exchanges link","Easy Returns & Exchanges Information NOT displayed",Status.FAIL);
				}
			}
			else
				report.updateTestLog("Checking Easy Returns & Exchanges link","Easy Returns & Exchanges NOT displayed in Shopping Cart",Status.FAIL);
			
			//Shopping Cart Your purchase is always safe and secure.
			String varShoppingCart=driver.findElement(By.xpath(UIMapCheckOut.lblEmptyShoppingCart)).getText();
			System.out.println(varShoppingCart);
			if(varShoppingCart.equals("Shopping Cart Your purchase is always safe and secure."))
			{
				String varSafeSecure=driver.findElement(By.xpath(UIMapCheckOut.lnkSafeSecureEmptyCart)).getText();
				if(varSafeSecure.equals("safe and secure."))
				{
					report.updateTestLog("Checking Safe & secure link","Safe & secure link embedded with 'Shopping Cart Your purchase is always safe and secure' heading.",Status.PASS);
				}
				else
					report.updateTestLog("Checking Safe & secure link","Safe & secure link NOT embedded with 'Shopping Cart Your purchase is always safe and secure' heading.",Status.FAIL);
			}
			else
				report.updateTestLog("Checking Safe & secure link","'Shopping Cart Your purchase is always safe and secure' heading Not Displayed",Status.FAIL);
			
			//Change Store
			boolean varChangeStore=driver.findElement(By.partialLinkText("Change Store")).isDisplayed();
			if(varChangeStore)
			{
				report.updateTestLog("Checking Change Store link","Change Store link displayed",Status.PASS);
			}
			else
				report.updateTestLog("Checking Change Store link","Change Store link NOT displayed",Status.FAIL);
				
		}
		else
			report.updateTestLog("Checking Empty Cart Section", "Empty Cart Section NOT displayed", Status.FAIL);
	}
	
	/*This function validates whether FREE is displayed in DElivery Option/Cart Summary for Free Parcel Del Items*/
	public void verifyFREEParcelShippingCart() throws Exception
	{
		//*[@id='item_4635761']/div[2]/div[2]/ul/li[3]/div[2]/span
		try{
		String varFreeParcel=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[2]/ul/li[3]/div[2]/span")).getText();
		if(varFreeParcel.equalsIgnoreCase("FREE"))
			report.updateTestLog("Checking Parcel in Delivery Methods", "Free Parcel displayed in Delivery Options", Status.PASS);
		else
			report.updateTestLog("Checking Parcel in Delivery Methods", "Free Parcel NOT displayed in Delivery Options", Status.FAIL);
		
		co.selectDeliveryOptionCart();
		String varDelLabel=driver.findElement(By.xpath(UIMapCheckOut.lblDel1Charges)).getText();
		
			if(varDelLabel.trim().equals("Parcel Shipping"))
			{
				report.updateTestLog("Checking Parcel Shipping in Cart Summary", "Parcel Shipping label displayed in Cart Summary", Status.PASS);
				String varDelValue=driver.findElement(By.xpath(UIMapCheckOut.lblDel1ChargesValue)).getText();
				if(varDelValue.equalsIgnoreCase("FREE"))
					report.updateTestLog("Checking Parcel Shipping in Cart Summary", "Parcel Shipping value FREE displayed in Cart Summary", Status.PASS);
				else
					report.updateTestLog("Checking Parcel Shipping in Cart Summary", "Parcel Shipping value FREE NOT displayed in Cart Summary", Status.FAIL);
			}
			else
				report.updateTestLog("Checking Parcel Shipping in Cart Summary", "Parcel Shipping label NOT displayed in Cart Summary", Status.FAIL);
		}
		catch(Exception NoSuchElementException){
			report.updateTestLog("Checking Parcel Shipping in Cart", "Parcel FREE Not displayed in del Options/cart summary", Status.FAIL);
		}
	}
	
	/*This function validates whether FREE is displayed in DElivery Option/Cart Summary for Free Truck Del Items*/
	public void verifyFREETruckShippingCart() throws Exception
	{
		//*[@id='item_4635761']/div[2]/div[2]/ul/li[3]/div[2]/span
		try{
		String varFreeTruck=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[2]/ul/li[2]/div[2]/span")).getText();
		if(varFreeTruck.equalsIgnoreCase("FREE"))
			report.updateTestLog("Checking Truck Delivery in Delivery Methods", "Free Truck Delivery displayed in Delivery Options", Status.PASS);
		else
			report.updateTestLog("Checking Truck Delivery in Delivery Methods", "Free Truck Delivery NOT displayed in Delivery Options", Status.FAIL);
		
		co.selectDeliveryOptionCart();
		String varDelLabel=driver.findElement(By.xpath(UIMapCheckOut.lblDel1Charges)).getText();
		
			if(varDelLabel.trim().equals("Estimated Truck Delivery"))
			{
				report.updateTestLog("Checking Estimated Truck Delivery in Cart Summary", "Estimated Truck Delivery label displayed in Cart Summary", Status.PASS);
				String varDelValue=driver.findElement(By.xpath(UIMapCheckOut.lblDel1ChargesValue)).getText();
				if(varDelValue.equalsIgnoreCase("FREE"))
					report.updateTestLog("Checking Estimated Truck Delivery in Cart Summary", "Estimated Truck Delivery value FREE displayed in Cart Summary", Status.PASS);
				else
					report.updateTestLog("Checking Estimated Truck Delivery in Cart Summary", "Estimated Truck Delivery value FREE NOT displayed in Cart Summary", Status.FAIL);
			}
			else
				report.updateTestLog("Checking Estimated Truck Delivery in Cart Summary", "Parcel Shipping label NOT displayed in Cart Summary", Status.FAIL);
		}
		catch(Exception NoSuchElementException){
			report.updateTestLog("Checking Truck Delivery in Cart", "Truck Delivery FREE Not displayed in del Options/cart summary", Status.FAIL);
		}
	}
	
	/*This function applies promo in cart*/
	public void applyPromoInCart() throws Exception
	{
		driver.findElement(By.id(UIMapCheckOut.txtPromoCode)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(UIMapCheckOut.txtPromoCode)).sendKeys(dataTable.getData("General_Data", "PromoCode"));
		driver.findElement(By.xpath(UIMapCheckOut.btnPromoCodeApply)).click();
		selenium.waitForPageToLoad("20000");
	}
	
	public void verifyYouSaveInCart() throws Exception
	{
		
		
		try{
			String varYouSave=driver.findElement(By.xpath(UIMapCheckOut.lblCartSummaryYouSave)).getText();
			if(varYouSave.trim().equalsIgnoreCase("You Save"))
			{
				
				report.updateTestLog("Checking You Save in Cart Summary","You Save displayed in Cart Summary",Status.PASS);
				String varYouSaveAmt=driver.findElement(By.xpath(UIMapCheckOut.lblCartSummaryYouSaveAmt)).getText();
				String pattern="\\$\\d+\\.\\d+";
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(varYouSaveAmt);
				if(m.find())
				{
					report.updateTestLog("Checking You Save Value in Cart Summary","You Save value displayed in Cart Summary",Status.PASS);
					
				}
				else
					report.updateTestLog("Checking You Save Value in Cart Summary","You Save value NOT displayed in Cart Summary",Status.FAIL);
				
				boolean varYouSaveHelp=driver.findElement(By.xpath(UIMapCheckOut.lblCartSummaryYouSaveHelp)).isDisplayed();
				if(varYouSaveHelp)
				{
					report.updateTestLog("Checking You Save Help Icon in Cart Summary","You Save Help Icon displayed in Cart Summary",Status.PASS);
					driver.findElement(By.xpath(UIMapCheckOut.lblCartSummaryYouSaveHelp)).click();
					Thread.sleep(2000);
					boolean varYouSavePopup=driver.findElement(By.id(UIMapCheckOut.webElmntYouSavePopup)).isDisplayed();
					if(varYouSavePopup)
					{
						report.updateTestLog("Clicking You Save Help Icon in Cart Summary","You Save Help Popup displayed in Cart Summary",Status.PASS);
						String varYouSavePopupTxt=driver.findElement(By.xpath(UIMapCheckOut.lblYouSavePopupTxt)).getText();
						if(varYouSavePopupTxt.trim().contains("Your savings are determined by our promotional offer that applies to an item at any given time. It excludes shipping and delivery costs."))
							report.updateTestLog("Checking You Save Help Popup in Cart Summary","You Save Help Popup displayed with correct content in Cart Summary",Status.PASS);
						else
							report.updateTestLog("Checking You Save Help Popup in Cart Summary","You Save Help Popup NOT displayed with correct content in Cart Summary",Status.FAIL);
					}
					else
						report.updateTestLog("Clicking You Save Help Icon in Cart Summary","You Save Help Popup NOT displayed in Cart Summary",Status.FAIL);
				}
				else
					report.updateTestLog("Checking You Save Help Icon in Cart Summary","You Save Help Icon NOT displayed in Cart Summary",Status.FAIL);
			}
			else
				report.updateTestLog("Checking You Save in Cart Summary","You Save NOT displayed in Cart Summary",Status.FAIL);
		}
		catch(Exception NoSuchElementException)
		{
			report.updateTestLog("Checking You Save in Cart Summary","You Save NOT displayed in Cart Summary",Status.FAIL);
		}
		
		
	}
	
	/*This function validates You save amt on changing item qty*/
	public void validateYouSaveOnChangingQty() throws Exception
	{
		String varYouSaveAmt=driver.findElement(By.xpath(UIMapCheckOut.lblCartSummaryYouSaveAmt)).getText();
		String varAmt=varYouSaveAmt.substring(1,varYouSaveAmt.length());
		System.out.println(varAmt);
		double varAmtdbl=Double.valueOf(varAmt);
		
		co.updateQtyInCart();
		
		String varQty=dataTable.getData("General_Data", "Qty");
		double varQtyDbl=Double.valueOf(varQty);
		
		double newVarYouSaveAmt=varAmtdbl*varQtyDbl;
		double roundOff = (double) Math.round(newVarYouSaveAmt * 100) / 100;
		String varYouSaveStr = String.format("%.2f", roundOff);
		varYouSaveAmt=driver.findElement(By.xpath(UIMapCheckOut.lblCartSummaryYouSaveAmt)).getText();
		if(varYouSaveAmt.equals("$"+varYouSaveStr))
		{
			report.updateTestLog("Checking You Save Value in Cart Summary","You Save value computes based on Qty in Cart Summary",Status.PASS);
		}
		else
			report.updateTestLog("Checking You Save Value in Cart Summary","You Save value INCORRECT in Cart Summary",Status.FAIL);
		verifyYouSaveInCart();
	}
	
	/*This function checks the Estimated Parcel Shipping Charges Options*/
	public void verifyEstParcelShippingCharges() throws Exception
	{
		try{
		String varParcelShipping=driver.findElement(By.xpath(UIMapCheckOut.lblEstParcelShippingCharges)).getText();
		System.out.println(varParcelShipping);
		boolean varDropDown=driver.findElement(By.id(UIMapCheckOut.drpDownParcelShippingOptions)).isDisplayed();
		if(varParcelShipping.trim().equalsIgnoreCase("Estimate Parcel Shipping Charges") && varDropDown)
		{
			report.updateTestLog("Checking Parcel Shipping", "Estimate Parcel Shipping Charges displayed label and drop-down", Status.PASS);
			String varOption1=driver.findElement(By.xpath(UIMapCheckOut.lblParcelShippingOption1)).getText();
			String varOption2=driver.findElement(By.xpath(UIMapCheckOut.lblParcelShippingOption2)).getText();
			String varOption3=driver.findElement(By.xpath(UIMapCheckOut.lblParcelShippingOption3)).getText();
			String pattern1="Standard 1-3 Business Days \\$\\d+\\.\\d+";
			Pattern r = Pattern.compile(pattern1);
			Matcher m = r.matcher(varOption1);
			if(m.find())
			{
				report.updateTestLog("Checking Parcel Shipping - Option 1", "Standard 1-3 Business Days $x.xx displayed", Status.PASS);
			}
			else
				report.updateTestLog("Checking Parcel Shipping - Option 1", "Standard 1-3 Business Days $x.xx NOT displayed", Status.FAIL);
			String pattern2="2 Business Days \\$\\d+\\.\\d+";
			 r = Pattern.compile(pattern2);
			 m = r.matcher(varOption2);
			if(m.find())
			{
				report.updateTestLog("Checking Parcel Shipping - Option 2", "2 Business Days $x.xx displayed", Status.PASS);
			}
			else
				report.updateTestLog("Checking Parcel Shipping - Option 2", "2 Business Days $x.xx NOT displayed", Status.FAIL);
			String pattern3="Next Day Delivery \\$\\d+\\.\\d+";
			 r = Pattern.compile(pattern3);
			 m = r.matcher(varOption3);
			if(m.find())
			{
				report.updateTestLog("Checking Parcel Shipping - Option 3", "Next Day Delivery $x.xx displayed", Status.PASS);
			}
			else
				report.updateTestLog("Checking Parcel Shipping - Option 3", "Next Day Delivery $x.xx NOT displayed", Status.FAIL);
		}
		else
			report.updateTestLog("Checking Parcel Shipping", "Estimate Parcel Shipping Charges NOT displayed label and drop-down", Status.FAIL);
		
		}
		catch(Exception NoSuchElementException){
			report.updateTestLog("Checking Parcel Shipping", "Estimate Parcel Shipping Charges NOT displayed label and drop-down", Status.FAIL);
		}
	}
	
	/*This function selects Parcel Shipping Option on Shopping Cart Page*/
	public void selectParcelShippingOption() throws Exception
	{
		int varOption=Integer.valueOf(dataTable.getData("General_Data", "ParcelOption"));
		String varXpath=null;
		if(varOption==0)
			varXpath=UIMapCheckOut.lblParcelShippingOption1;
		else if(varOption==1)
			varXpath=UIMapCheckOut.lblParcelShippingOption2;
		else if(varOption==2)
			varXpath=UIMapCheckOut.lblParcelShippingOption3;
		String varOptionValue=driver.findElement(By.xpath(varXpath)).getText();
		String[] s= varOptionValue.split("\\$");
		System.out.println(s[1]);
		
		
		new Select(driver.findElement(By.id(UIMapCheckOut.drpDownParcelShippingOptions))).selectByIndex(varOption);
		
		selenium.waitForPageToLoad("20000");
		String varEstParcel=driver.findElement(By.xpath(UIMapCheckOut.lblDel1Charges)).getText();
		if(varEstParcel.trim().equalsIgnoreCase("Estimated Parcel Shipping"))
		{
			report.updateTestLog("Checking Estimated Parcel Shipping in Cart Summary", "Estimated Parcel Shipping displayed in Cart Summary", Status.PASS);
			String varParcelCharge=driver.findElement(By.xpath(UIMapCheckOut.lblDel1ChargesValue)).getText();
			System.out.println(varParcelCharge);
			String varExpCharge="$".concat(s[1]);
			System.out.println(varExpCharge);
			if(varParcelCharge.trim().equals(varExpCharge.trim()))
				report.updateTestLog("Checking Estimated Parcel Shipping in Cart Summary", "Estimated Parcel Shipping value displayed based on Option selected in Cart Summary", Status.PASS);
			else
				report.updateTestLog("Checking Estimated Parcel Shipping in Cart Summary", "Estimated Parcel Shipping value NOT displayed based on Option selected in Cart Summary", Status.FAIL);
		}
		else
			report.updateTestLog("Checking Estimated Parcel Shipping in Cart Summary", "Estimated Parcel Shipping NOT displayed in Cart Summary", Status.FAIL);
	}
	
	/*This function validates that Subtotal is displayed correctly in Shopping Cart*/
	public void checkSubtotal() throws Exception
	{
		int varCount=countWebElement(UIMapCheckOut.webElmntCartItems);
		System.out.println("Nbr of items:"+varCount);
		double varSubtotaldbl=0.0;
		for(int i=1;i<=varCount;i++)
		{
			String varItemTotal=driver.findElement(By.xpath(UIMapCheckOut.webElmntCartItems+"["+i+"]/div[2]/div[5]/div/div")).getText();
			String varItemTotal2=varItemTotal.substring(1);
			System.out.println(varItemTotal2);
			double varItemTotaldbl=Double.valueOf(varItemTotal2);
			varSubtotaldbl=varSubtotaldbl+varItemTotaldbl;
			System.out.println(varSubtotaldbl);
			
		}
		System.out.println(varSubtotaldbl);
		double roundOff = (double) Math.round(varSubtotaldbl * 100) / 100;
		System.out.println("After Round Off:"+roundOff);
		String varSubTotalStr = String.format("%.2f", roundOff);
		String varSubTotalExptd=null;
		if(varSubTotalStr.length()>6)
	     {
	    	 int i = varSubTotalStr.length()-6;
	    	 String s1 = varSubTotalStr.substring(0, i);
	    	 String s2 = varSubTotalStr.substring(i,varSubTotalStr.length());
	    	  varSubTotalExptd = s1+","+s2;
	    	 System.out.println(varSubTotalExptd);
	     }
		else
		{
			 varSubTotalExptd = varSubTotalStr;
			 System.out.println(varSubTotalExptd);
		}
		System.out.println(varSubTotalExptd);
		String varSubtotalDisp=driver.findElement(By.xpath(UIMapCheckOut.lblSubTotalValue)).getText();
		System.out.println(varSubtotalDisp);
		if(varSubtotalDisp.equals("$"+varSubTotalExptd))
			report.updateTestLog("Checking Subtotal Value in Cart Summary", "Subtotal Value displayed correctly in Cart Summary", Status.PASS);
		else
			report.updateTestLog("Checking Subtotal Value in Cart Summary", "Subtotal Value NOT displayed correctly in Cart Summary", Status.FAIL);
	}
	
	/*This function clicks on Start Secure Checkout button in Cart page*/
	public void clickStartSecureChkOut() throws Exception
	 {
	  driver.findElement(By.xpath(UIMapCheckOut.btnStrtSecureChkOut2)).click();
	  Thread.sleep(2000);
	  if(selenium.isTextPresent("No Thanks"))
	   driver.findElement(By.linkText("No Thanks")).click();
	  selenium.waitForPageToLoad("20000");
	  
	  String varLoggedIn=dataTable.getData("General_Data", "LoggedIn");
	  if(varLoggedIn.equals("Yes"))
	  {
	   if(selenium.getTitle().contains("Lowe's: Secure Checkout"))
	    report.updateTestLog("Clicking secure checkOut","Page next to Secure Checkout page displayed",Status.PASS);
	   else
	    report.updateTestLog("Clicking secure checkOut","Page next to Secure Checkout page NOT displayed",Status.FAIL);
	  }
	  else
	  {
	   if(selenium.getTitle().contains("Lowe's: Sign In"))
	    report.updateTestLog("Clicking secure checkOut","Lowes sign In page displayed",Status.PASS);
	   else
	    report.updateTestLog("Clicking secure checkOut","Lowes sign In page NOT displayed",Status.FAIL);
	   
	  }
	 } 

	
	public void clickRemoveInMiniCart() throws Exception
	{
		int varCount=0,i=0;
		String varItemAdded=null;
		String varCartItemId=null;
		String varMiniCartCount=driver.findElement(By.id(UIMapCheckOut.webElmntMiniCartCount)).getText();
		int varNewCount=Integer.valueOf(varMiniCartCount);
		System.out.println("New Count:"+varNewCount);
		String varItemName=driver.findElement(By.xpath(UIMapProductSearch.webElmntProductName)).getText();
		
		
		String varItemNameTrimmed=null;
		String varItemAddedTrimmed=null;
		if(varItemName.length()>40)
		{
			varItemNameTrimmed=varItemName.substring(0, 40);
			if(varItemNameTrimmed.contains("\""))
			{
				String[] s=varItemNameTrimmed.split("\"");
				varItemNameTrimmed=s[0];
			}
		}
		else
		{
			varItemNameTrimmed=varItemName;
			if(varItemNameTrimmed.contains("\""))
			{
				String[] s=varItemNameTrimmed.split("\"");
				varItemNameTrimmed=s[0];
			}
		}
		
		
		openMiniCart();
		
		for(i=1;i<=varNewCount;i++)
		{
		if(i==4)
		{
		driver.findElement(By.xpath(UIMapCheckOut.webElmntMiniCartNextArrow)).click();
		Thread.sleep(2000);
		}
		if(varNewCount<=3)
		{
			varItemAdded=driver.findElement(By.xpath(UIMapCheckOut.lnkMiniCartItems+"["+i+"]/div[2]/div[2]/h3/a")).getText();
			varCartItemId=driver.findElement(By.xpath(UIMapCheckOut.lnkMiniCartItems+"["+i+"]")).getAttribute("id");
		}
		else
		{
			varItemAdded=driver.findElement(By.xpath(UIMapCheckOut.lnkMiniCartItemName2+"["+i+"]/div[2]/div[2]/h3/a")).getText();
			varCartItemId=driver.findElement(By.xpath(UIMapCheckOut.lnkMiniCartItems2+"["+i+"]")).getAttribute("id");
		}
		if(varItemAdded.length()>40)
			varItemAddedTrimmed=varItemAdded.substring(0, 40);
		else
			varItemAddedTrimmed=varItemAdded;
		System.out.println(varItemAddedTrimmed);
		System.out.println(varItemNameTrimmed);
		//if()
		if(varItemAddedTrimmed.equals(varItemNameTrimmed))//&&(varNewCount==(oldCount+1)))
		{
			driver.findElement(By.xpath("//*[@id='"+varCartItemId+"']/div[2]/a")).click();
			Thread.sleep(1000);
			boolean varItemRemoved=selenium.isTextPresent("Item removed from cart.");
			if(varItemRemoved)
			{
				report.updateTestLog("Clicking remove in Mini Cart for Item:"+dataTable.getData("General_Data", "ItemNbr"), "Item successfuly removed", Status.PASS);
				driver.navigate().refresh();
				selenium.waitForPageToLoad("20000");
				break;
			}
			else
			{
				report.updateTestLog("Clicking remove in Mini Cart for Item:"+dataTable.getData("General_Data", "ItemNbr"), "Item NOT successfuly removed", Status.FAIL);
				break;
			}
			
		}
		}
	}
	
	public void clickRemoveInMiniCartForRTF() throws Exception
	{
		int i=0;
		String varCartItemId=null;
		String varItemAdded=null;
		String varMiniCartCount=driver.findElement(By.id(UIMapCheckOut.webElmntMiniCartCount)).getText();
		int varNewCount=Integer.valueOf(varMiniCartCount);
		System.out.println("New Count:"+varNewCount);
		
		String varItemName=dataTable.getData("General_Data", "RTFItemName");
		String varItemNameTrimmed=null;
		String varItemAddedTrimmed=null;
		if(varItemName.length()>40)
		{
			varItemNameTrimmed=varItemName.substring(0, 40);
			if(varItemNameTrimmed.contains("\""))
			{
				String[] s=varItemNameTrimmed.split("\"");
				varItemNameTrimmed=s[0];
			}
		}
		else
		{
			varItemNameTrimmed=varItemName;
			if(varItemNameTrimmed.contains("\""))
			{
				String[] s=varItemNameTrimmed.split("\"");
				varItemNameTrimmed=s[0];
			}
		}
		
		openMiniCart();
		
		for(i=1;i<=varNewCount;i++)
		{
		if(i==4)
		{
		driver.findElement(By.xpath(UIMapCheckOut.webElmntMiniCartNextArrow)).click();
		Thread.sleep(2000);
		}
		if(varNewCount<=3)
		{
			varItemAdded=driver.findElement(By.xpath(UIMapCheckOut.lnkMiniCartItems+"["+i+"]/div[2]/div[2]/h3/a")).getText();
			varCartItemId=driver.findElement(By.xpath(UIMapCheckOut.lnkMiniCartItems+"["+i+"]")).getAttribute("id");
		}
		else
		{
			varItemAdded=driver.findElement(By.xpath(UIMapCheckOut.lnkMiniCartItemName2+"["+i+"]/div[2]/div[2]/h3/a")).getText();
			varCartItemId=driver.findElement(By.xpath(UIMapCheckOut.lnkMiniCartItems2+"["+i+"]")).getAttribute("id");
		}
		if(varItemAdded.length()>40)
			varItemAddedTrimmed=varItemAdded.substring(0, 40);
		else
			varItemAddedTrimmed=varItemAdded;
		System.out.println(varItemAddedTrimmed);
		System.out.println(varItemNameTrimmed);
		//if()
		if(varItemAddedTrimmed.equals(varItemNameTrimmed))//&&(varNewCount==(oldCount+1)))
		{
			driver.findElement(By.xpath("//*[@id='"+varCartItemId+"']/div[2]/a")).click();
			Thread.sleep(1000);
			boolean varItemRemoved=selenium.isTextPresent("Item removed from cart.");
			if(varItemRemoved)
			{
				report.updateTestLog("Clicking remove in Mini Cart for RTF Item:"+dataTable.getData("General_Data", "RTFItemName"), "Item successfuly removed", Status.PASS);
				driver.navigate().refresh();
				selenium.waitForPageToLoad("20000");
				break;
			}
			else
			{
				report.updateTestLog("Clicking remove in Mini Cart for RTF Item:"+dataTable.getData("General_Data", "RTFItemName"), "Item NOT successfuly removed", Status.FAIL);
				break;
			}
			
		}
		}
		
		
	}
	/*This function checks item present in Mini cart and removes the same from Regular Cart*/
	public void removeItemInMiniCartRegCart() throws Exception
	{
		openMiniCart();
		String varItemIdStr=driver.findElement(By.xpath(UIMapCheckOut.webElmntMiniCartItem)).getAttribute("href");
		String[] s=varItemIdStr.split("productId=");
		System.out.println(s[1]);
		String varItemId=s[1];
		clickViewCartCheckOut();
		selenium.waitForPageToLoad("20000");
		driver.findElement(By.xpath("//*[@id='item_"+varItemId+"']/div[2]/div[3]/a")).click();
		selenium.waitForPageToLoad("20000");
		String varItemXpath="//*[@id='item_"+varItemId+"']";
		try{
		boolean varItemDisplayed=driver.findElement(By.xpath(varItemXpath)).isDisplayed();
		if(varItemDisplayed)
			report.updateTestLog("Clicking Remove  in Regular Cart for Item From Mini Cart", "Item NOT removed", Status.FAIL);
		else
			report.updateTestLog("Clicking Remove  in Regular Cart for Item From Mini Cart", "Item removed", Status.PASS);
		}
		catch(Exception NoSuchElementException)
		{
			report.updateTestLog("Clicking Remove  in Regular Cart for Item From Mini Cart", "Item: "+dataTable.getData("General_Data", "ItemNbr")+" removed", Status.PASS);
		}
	}
	
	/*This function checks whether the Item removed from mini Cart is displayed in regular Cart*/
	public void checkMiniCartRemovedItems() throws Exception
	{
		try{
			boolean varItem=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']")).isDisplayed();
			if(varItem)
			{
				report.updateTestLog("Checking Item"+dataTable.getData("General_Data", "ItemNbr")+" In Cart","Item displayed in Cart",Status.FAIL);
			}
			else
				report.updateTestLog("Checking Item"+dataTable.getData("General_Data", "ItemNbr")+" In Cart","Item NOT displayed in Cart",Status.PASS);
			}
			catch(Exception NoSuchElementException)
			{
				report.updateTestLog("Checking Item"+dataTable.getData("General_Data", "ItemNbr")+" In Cart","Item NOT displayed in Cart",Status.PASS);
			}
	}
	
	/*This function validates That only numeric characters are accepted in Gift Card-Qty field in Cart*/
	public void validateGCQty() throws Exception
	{
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[3]/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[3]/input")).clear();
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[3]/input")).sendKeys("6F");
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[3]/input")).sendKeys(Keys.TAB);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[3]/input")).sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath(UIMapCheckOut.btnQtyUpdate)).click();
		Thread.sleep(10000);
		String varNewQty=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[3]/input")).getAttribute("value");
		if(varNewQty.equals("1"))
		{
			report.updateTestLog("Entering Alphanumeric in Gift Card Qty", "Qty updated to 1", Status.PASS);
		}
		else
			report.updateTestLog("Entering Alphanumeric in Gift Card Qty", "Qty NOT updated to 1", Status.FAIL);
		
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[3]/input")).clear();
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[3]/input")).sendKeys(dataTable.getData("General_Data", "Qty"));
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[3]/input")).sendKeys(Keys.TAB);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[3]/input")).sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		varNewQty=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[3]/input")).getAttribute("value");
		if(varNewQty.equals(dataTable.getData("General_Data", "Qty")))
		{
			report.updateTestLog("Entering Valid Numeric in Gift Card Qty", "Qty updated to Valid Numeric entered", Status.PASS);
		}
		else
			report.updateTestLog("Entering Valid Numeric in Gift Card Qty", "Qty NOT updated to Valid Numeric entered", Status.FAIL);
	}
	
	/*This function validates That only numeric characters are accepted in Gift Card-Unit Price field in Cart*/
	public void validateGCUnitPrice() throws Exception
	{
		String varOldUP=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[4]/div/input")).getAttribute("value");
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[4]/div/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[4]/div/input")).clear();
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[4]/div/input")).sendKeys("6F");
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[4]/div/input")).sendKeys(Keys.TAB);
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[4]/div/input")).sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath(UIMapCheckOut.btnQtyUpdate)).click();
		//Thread.sleep(10000);
		String varNewUP=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[4]/div/input")).getAttribute("value");
		if(varNewUP.equals(varOldUP))
		{
			report.updateTestLog("Entering Alphanumeric in Gift Card Unit Price", "Unit Price updated to Original Value", Status.PASS);
		}
		else
			report.updateTestLog("Entering Alphanumeric in Gift Card Unit Price", "Unit Price NOT updated to Original Value", Status.FAIL);
		
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[4]/div/input")).clear();
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[4]/div/input")).sendKeys(dataTable.getData("General_Data", "UnitPrice"));
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[4]/div/input")).sendKeys(Keys.TAB);
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[4]/div/input")).sendKeys(Keys.ENTER);
		//Thread.sleep(10000);
		varNewUP=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[4]/div/input")).getAttribute("value");
		if(varNewUP.equals(dataTable.getData("General_Data", "UnitPrice")))
		{
			report.updateTestLog("Entering Valid Numeric in Gift Card Unit Price", "Unit Price updated to Valid Numeric entered", Status.PASS);
		}
		else
			report.updateTestLog("Entering Valid Numeric in Gift Card Unit Price", "Unit Price NOT updated to Valid Numeric entered", Status.FAIL);
	}
	
	/*This function selects delivery method in Carts page for Bogo Item-2*/
	public void selectDeliveryOptionCartBogo() throws Exception
	{
		String varDeliveryOption = dataTable.getData("General_Data", "DeliveryMthd");
		if(varDeliveryOption.equals("PL"))
		{
			
			driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"'][2]/div[2]/div[2]/ul/li[1]/div/label/input")).click();
			Thread.sleep(5000);
			report.updateTestLog("Selecting Delivery Option","Delivery Option"+dataTable.getData("General_Data", "DeliveryMthd")+" selected for Item "+dataTable.getData("General_Data", "ItemNbr"), Status.DONE);
			
		}
		else if(varDeliveryOption.equals("UPS"))
		{
			driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"'][2]/div[2]/div[2]/ul/li[3]/div/label/input")).click();
			Thread.sleep(5000);
			report.updateTestLog("Selecting Delivery Option","Delivery Option"+dataTable.getData("General_Data", "DeliveryMthd")+" selected for Item "+dataTable.getData("General_Data", "ItemNbr"), Status.DONE);
		}
		else if(varDeliveryOption.equals("LD"))
		{
			driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"'][2]/div[2]/div[2]/ul/li[2]/div/label/input")).click();
			Thread.sleep(5000);
			report.updateTestLog("Selecting Delivery Option","Delivery Option"+dataTable.getData("General_Data", "DeliveryMthd")+" selected for Item "+dataTable.getData("General_Data", "ItemNbr"), Status.DONE);
		}
	}
	
	
	/*This function validates whether Estimated Parcel Shipping is displayed as FREE*/
	public void checkFreeEstParcelShipping() throws Exception
	{
	String varDelLabel=driver.findElement(By.xpath(UIMapCheckOut.lblDel1Charges)).getText();
	
	if(varDelLabel.trim().equals("Estimated Parcel Shipping"))
	{
		report.updateTestLog("Checking Estimated Parcel Shipping in Cart Summary", "Estimated Parcel Shipping label displayed in Cart Summary", Status.PASS);
		String varDelValue=driver.findElement(By.xpath(UIMapCheckOut.lblDel1ChargesValue)).getText();
		if(varDelValue.equalsIgnoreCase("FREE"))
			report.updateTestLog("Checking Estimated Parcel Shipping in Cart Summary", "Estimated Parcel Shipping value FREE displayed in Cart Summary", Status.PASS);
		else
			report.updateTestLog("Checking Estimated Parcel Shipping in Cart Summary", "Estimated Parcel Shipping value FREE NOT displayed in Cart Summary", Status.FAIL);
	}
	else
		report.updateTestLog("Checking Estimated Parcel Shipping in Cart Summary", "Estimated Parcel Shipping label NOT displayed in Cart Summary", Status.FAIL);
	
}
	
	/*This function checks whether Employee discount is displayed for EPP Item*/
	public void checkEmployeeDiscountEPP() throws Exception
	{
		String varEPPPrice=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[6]/div[4]/ul/li")).getText();
		String varEPPPrice1=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[6]/div[4]/ul")).getText();
		if((!varEPPPrice.contains("Employee Savings"))&& (!varEPPPrice1.contains("Employee Savings")))
			report.updateTestLog("Checking Employee discount in EPP Price", "EPP Price does not contain Employee Discount", Status.PASS);
		else
			report.updateTestLog("Checking Employee discount in EPP Price", "EPP Price contains Employee Discount", Status.FAIL);
		
	}
	
	/*This function checks Employee discount in EPP for various options*/
	public void verifyEPPForEmployee() throws Exception
	{
		updateEPPCart(2);
		checkEmployeeDiscountEPP();
		updateEPPCart(3);
		
	}
	
	/*This function checks whether Correct You Save Amount is displayed for Employees-Was Price Items*/
	public void verifyEmpYouSaveForWasPriceItems() throws Exception
	{
		ps.searchItemString();
		String varUnitPriceNormal=driver.findElement(By.xpath(UIMapCheckOut.lblItemUnitPrice)).getText();
		String varUnitPrice=varUnitPriceNormal.substring(1);
		double varUnitPriceOld=Double.valueOf(varUnitPrice);
		fc.verifyingEmployeeLogin();
		fc.changeStore();
		co.makeCartEmpty();
		ps.searchItemString();
		String varUnitPriceEmp=driver.findElement(By.xpath(UIMapCheckOut.lblItemUnitPrice)).getText();
		varUnitPrice=varUnitPriceEmp.substring(1);
		double varUnitPriceNew=Double.valueOf(varUnitPrice);
		
		double varYouSavedbl=varUnitPriceOld-varUnitPriceNew;
		double roundOff = (double) Math.round(varYouSavedbl * 100) / 100;
		String varYouSaveStr = String.format("%.2f", roundOff);
		System.out.println("Expected You Save:"+varYouSaveStr);
		co.clickCheckOutFromDetails();
		co.clickCheckOut();
		try{
			String varYouSave=driver.findElement(By.xpath(UIMapCheckOut.lblCartSummaryYouSave)).getText();
			if(varYouSave.trim().equalsIgnoreCase("You Save"))
			{
				
				report.updateTestLog("Checking You Save in Cart Summary","You Save displayed in Cart Summary",Status.PASS);
				String varYouSaveAmt=driver.findElement(By.xpath(UIMapCheckOut.lblCartSummaryYouSaveAmt)).getText();
				String varYouSaveDisp=varYouSaveAmt.substring(1);
				System.out.println("You Save displayed:"+varYouSaveDisp);
				if(varYouSaveDisp.equals(varYouSaveStr))
					report.updateTestLog("Checking You Save value in Cart Summary","You Save displayed as difference between the selling price of regualr user and employee user.",Status.PASS);
				else
					report.updateTestLog("Checking You Save value in Cart Summary","You Save NOT displayed as difference between the selling price of regualr user and employee user.",Status.FAIL);
			}
			else
				report.updateTestLog("Checking You Save in Cart Summary","You Save NOT displayed in Cart Summary",Status.FAIL);
		}
		catch(Exception NoSuchElementException)
		{
			report.updateTestLog("Checking You Save in Cart Summary","You Save NOT displayed in Cart Summary",Status.FAIL);
		}
		
			
	}
	
	/*This function validates whether Unavailable message is displayed on top of the cart*/
	public void verifyUnavailableErrorMsg() throws Exception
	{
		try{
		String varErrorMsg=driver.findElement(By.xpath(UIMapCheckOut.lblUnavailableErrorMsg)).getText();
		String varQty=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[3]/input")).getAttribute("value");
		System.out.println(dataTable.getData("General_Data", "ItemId")+"varQty"+varQty);
		String varItemName=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[1]/a")).getText();
		//String varErrorExpected="Your quantity of "+varQty+" "+varItemName+" is unavailable at your selected store.";
		String varErrorExpected="Quantity for the item "+dataTable.getData("General_Data", "ItemNbr")+" cannot be fulfilled at this time.";
		System.out.println(varErrorMsg);
		System.out.println(varErrorExpected);
		if(varErrorMsg.trim().equalsIgnoreCase(varErrorExpected))
		{
			report.updateTestLog("Checking Unavailable Error in Cart","Unavailable error Message correctly displayed in Cart",Status.PASS);
			String del1Unavailable=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[2]/ul/li[1]/div[2]/p[1]")).getText();
			String del2Unavailable=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[2]/ul/li[2]/div[2]/p[1]")).getText();
			String del3Unavailable=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[2]/ul/li[3]/div[2]/p[1]")).getText();
			if((del1Unavailable.trim().equalsIgnoreCase("Unavailable for This Order")) && (del2Unavailable.trim().equalsIgnoreCase("Unavailable for This Order")) && (del3Unavailable.trim().equalsIgnoreCase("Unavailable for This Order")))
			{
				report.updateTestLog("Checking Delivery Methods in Cart","All Delivery Methods in Cart Unavailable",Status.PASS);
			}
			else
				report.updateTestLog("Checking Delivery Methods in Cart","All Delivery Methods in Cart NOT Unavailable",Status.FAIL);
			
		}
		else
			report.updateTestLog("Checking Unavailable Error in Cart","Unavailable error Message NOT correctly displayed in Cart",Status.FAIL);
		
		if(varQty.equals(dataTable.getData("General_Data","Qty")))
			report.updateTestLog("Checking Quantity in Cart","Quantity same as the one entered in Details",Status.PASS);
		else
			report.updateTestLog("Checking Quantity in Cart","Quantity NOT same as the one entered in Details",Status.FAIL);
		}
			
		catch(Exception NoSuchElementException)
		{
			report.updateTestLog("Checking Unavailable Error in Cart","Unavailable error Message NOT displayed in Cart",Status.FAIL);
		}
	}
	
	/*This function validates whether Unavailable message is displayed on top of the cart*/
	public void verifyUnavailableErrorMsg2() throws Exception
	{
		try{
		String varErrorMsg=driver.findElement(By.xpath(UIMapCheckOut.lblUnavailableErrorMsg)).getText();
		String varQty=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[3]/input")).getAttribute("value");
		String varItemName=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[1]/a")).getText();
		String varErrorExpected="Your quantity of "+varQty+" "+varItemName+" is unavailable at your selected store.";
		//String varErrorExpected="Quantity for the item "+dataTable.getData("General_Data", "ItemNbr")+" cannot be fulfilled at this time.";
		System.out.println(varErrorMsg);
		System.out.println(varErrorExpected);
		if(varErrorMsg.trim().equalsIgnoreCase(varErrorExpected))
		{
			report.updateTestLog("Checking Unavailable Error in Cart","Unavailable error Message correctly displayed in Cart",Status.PASS);
			
			
		}
		else
			report.updateTestLog("Checking Unavailable Error in Cart","Unavailable error Message NOT correctly displayed in Cart",Status.FAIL);
		
		}
			
		catch(Exception NoSuchElementException)
		{
			report.updateTestLog("Checking Unavailable Error in Cart","Unavailable error Message NOT displayed in Cart",Status.FAIL);
		}
	}
	
	
	/*Enters Item Qty on PD Page*/
	public void enterQtyPD() throws Exception
	{
		driver.findElement(By.xpath(UIMapFunctionalComponents.txtQty)).clear();
		driver.findElement(By.xpath(UIMapFunctionalComponents.txtQty)).sendKeys(dataTable.getData("General_Data","Qty"));
	}
	
	/*Verifies WhiteGoods Fee*/
	public void verifyWhiteGoodsFee() throws Exception
	{
		String varStoreState=dataTable.getData("General_Data", "WhiteGoodsFeeStore");
		try{
			String varWhiteGoodsLabel=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[7]/div[2]/div[1]")).getText();
			String varWhiteGoodsFee=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[7]/div[2]/div[4]")).getText();
			String[] s=varWhiteGoodsFee.split("\\$");
			if(varStoreState.equals("NC"))
			{
			if(varWhiteGoodsLabel.trim().equalsIgnoreCase("NC WHITE GOODS FEE"))
					report.updateTestLog("Checking White Goods Fee In Cart","NC White Goods Fee In Cart displayed",Status.PASS);
			else
				report.updateTestLog("Checking White Goods Fee In Cart","NC White Goods Fee In Cart NOT displayed",Status.FAIL);
			if(s[1].trim().equalsIgnoreCase("3.00"))
					report.updateTestLog("Checking White Goods Fee Unit Price In Cart","Unit Price $3.00 displayed",Status.PASS);
			else
				report.updateTestLog("Checking White Goods Fee Unit Price In Cart","Unit Price $3.00 NOT displayed",Status.FAIL);	
					
			}
			else if(varStoreState.equals("SC"))
			{
			if(varWhiteGoodsLabel.trim().equalsIgnoreCase("SC WHITE GOODS FEE"))
					report.updateTestLog("Checking White Goods Fee In Cart","SC White Goods Fee In Cart displayed",Status.PASS);
			else
				report.updateTestLog("Checking White Goods Fee In Cart","SC White Goods Fee In Cart NOT displayed",Status.FAIL);
			if(s[1].trim().equalsIgnoreCase("2.00"))
					report.updateTestLog("Checking White Goods Fee Unit Price In Cart","Unit Price $2.00 displayed",Status.PASS);
			else
				report.updateTestLog("Checking White Goods Fee Unit Price In Cart","Unit Price $2.00 NOT displayed",Status.FAIL);	
			
			
			}
			else
				report.updateTestLog("Checking White Goods Fee In Cart","Incorrect WhiteGoodsFeeStore in datasheet",Status.FAIL);
			
			
			
		}
		catch(Exception NoSuchElementException)
		{
			report.updateTestLog("Checking White Goods Fee In Cart","White Goods validation Failed",Status.FAIL);
		}
	}
	
	
	public void checkWhiteFeeInSubtotal() throws Exception
	{
		co.selectDeliveryOptionCart();
		checkWhiteGoodsFeeIncludedInSubtotal();
	}
	
	public void checkWhiteGoodsFeeForNonSCNCStore() throws Exception
	{
		
		driver.findElement(By.xpath(UIMapFunctionalComponents.lnkStoreUnzip)).click();
		selenium.waitForPageToLoad("20000");
		driver.findElement(By.id(UIMapFunctionalComponents.txtStoreZip)).sendKeys(dataTable.getData("General_Data","NonNCSCStore"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtStoreZip)).sendKeys(Keys.ENTER);
		selenium.waitForPageToLoad("20000");
		report.updateTestLog("Changing to Non Nc/Sc store", "Store changed", Status.DONE);
		verifyNoWhiteGoodsFee();
	}
	
	/*validates whether white goods fee is removed on changing to Non NC/SC store*/
	public void verifyNoWhiteGoodsFee() throws Exception
	{
		try{
			boolean varWhiteGoodsSection=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[7]")).isDisplayed();
			if(varWhiteGoodsSection)
				report.updateTestLog("Checking White Goods Fee In Cart","White Goods Fee In Cart Displayed",Status.FAIL);
			else
				report.updateTestLog("Checking White Goods Fee In Cart","White Goods Fee In Cart NOT Displayed",Status.PASS);
	}
		catch(Exception NoSuchElementException)
		{
			report.updateTestLog("Checking White Goods Fee In Cart","White Goods Fee In Cart Not Displayed",Status.PASS);
		}
	}
	
	/*Validates whether White Goods Fee is included in Subtotal*/
	public void checkWhiteGoodsFeeIncludedInSubtotal()
	{
		String varStoreState=dataTable.getData("General_Data", "WhiteGoodsFeeStore");
		double varFeeDbl=0.0;
		if(varStoreState.equals("NC"))
		{
			String varWhiteGoodsFee=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[7]/div[2]/div[5]")).getText();
			String s=varWhiteGoodsFee.substring(1);
			varFeeDbl=Double.valueOf(s);
			System.out.println(varFeeDbl);
		}
		else if(varStoreState.equals("SC"))
		{
		String varWhiteGoodsFee=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[7]/div[2]/div[5]/div")).getText();
		String[] s=varWhiteGoodsFee.split("\\$");
		varFeeDbl=Double.valueOf(s[1]);
		System.out.println(varFeeDbl);
		}
		String varTotalItemPrice=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[5]/div[1]/div")).getText();
		String totalPrice=null;
		if(varTotalItemPrice.length()>7)
		{
			String s1[]=varTotalItemPrice.split(",");
			String s2=s1[0].substring(1,s1[0].length());
			totalPrice=s2.concat(s1[1]);
		}
		else
		{
			totalPrice=varTotalItemPrice.substring(1,varTotalItemPrice.length());
		}
		
		double varTotalPriceDbl=Double.valueOf(totalPrice);
		System.out.println(varTotalPriceDbl);
		double varExpSubtotal=varTotalPriceDbl+varFeeDbl;
		System.out.println(varExpSubtotal);
		double roundOff = (double) Math.round(varExpSubtotal * 100) / 100;
		System.out.println("After Round Off:"+roundOff);
		String varSubTotalStr = String.format("%.2f", roundOff);
		 
		String newCartSubtotal=driver.findElement(By.xpath(UIMapCheckOut.lblCartSubtotal)).getText();
		String newSubtotal=null;
		if(newCartSubtotal.length()>7)
		{
			String s1[]=newCartSubtotal.split(",");
			String s2=s1[0].substring(1,s1[0].length());
			newSubtotal=s2.concat(s1[1]);
		}
		else
		{
			newSubtotal=newCartSubtotal.substring(1,newCartSubtotal.length());
		}
		System.out.println(newSubtotal);
		if(newSubtotal.equals(varSubTotalStr))
			report.updateTestLog("Checking Subtotal In Cart","White Goods Fee included in Subtotal",Status.PASS);
		else
			report.updateTestLog("Checking Subtotal In Cart","White Goods Fee NOT included in Subtotal",Status.FAIL);
	}
	
	/*This function checks how many items are there in cart*/
	public int countItemsInCart() throws Exception
	{
		try{int varCount=ps.countWebElement(UIMapCheckOut.webElmntCartItems);
			return varCount;
		}
		catch(Exception NoSuchElementException)
		{
			return 0;
		}
		
	}
	
	public void check1ItemRemaining() throws Exception
	{
		int varCount = countItemsInCart();
		if(varCount==1)
			report.updateTestLog("Checking Remaining Items", "1 Item remaining", Status.PASS);
		else
			report.updateTestLog("Checking Remaining Items", "Remaining Items Count: "+varCount, Status.FAIL);
			
	}
	
	/*This function checks EPP functionality when there are 2 EPP Items in Cart*/
	public void validateEPPMultiple() throws Exception
	{
		if(dataTable.getData("General_Data", "EPPInPD").equals("Yes"))
		{
			checkEPPSelected(1);
			updateEPPCart(2);
			updateEPPCart(3);
		}
		else
		{
			checkEPPSelected(3);
			updateEPPCart(2);
			
		}
	}
	
	
	/*This function validates Regular Cart after adding Flexible Promo-BOGO Item*/
	public void validateFlexiblePromoItemCart() throws Exception
	{
		int itemCount=ps.countWebElement("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']");
		System.out.println(itemCount);
		if(itemCount==2)
		{
		report.updateTestLog("Checking whether Flexible Code Applied", "Item Buy 1 Get 1", Status.DONE);
		String varPromoItem1= driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"'][1]/div[2]/div[1]/div/div")).getText();
		System.out.println("Item 1 Promo Text:"+varPromoItem1);
		String varPromoItem2= driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"'][2]/div[2]/div[1]/div/div")).getText();
		System.out.println("Item 2 Promo Text:"+varPromoItem2);
		String varPromoItem2UnitPrice= driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"'][2]/div[2]/div[4]/span/div/p")).getText();
		System.out.println("Item 2 Promo Text in Unit Price:"+varPromoItem2UnitPrice);
		String varPromoText="BOGO ".concat(dataTable.getData("General_Data", "ItemNbr"));
		System.out.println("Promo text expected:"+varPromoText);
		if((varPromoItem1.equals(varPromoText)) && (varPromoItem2.equals(varPromoText)) && (varPromoItem2UnitPrice.equals(varPromoText)))
		{
			report.updateTestLog("Checking Promo text in Both Items", "Promo Text correctly displayed in both Items", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Promo text in Both Items", "Promo Text NOT correctly displayed in both Items", Status.FAIL);
		}
		
		String varTotalPrice=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"'][1]/div[2]/div[5]/div/div")).getText();
		System.out.println("Total Price of Item1:"+varTotalPrice);
		String getItemDeduction=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"'][2]/div[2]/div[5]/span/div/p")).getText();
		System.out.println("Deduction amount displayed:"+getItemDeduction);
		if(getItemDeduction.equals("-"+varTotalPrice))
			report.updateTestLog("Checking Amount deducted", "Amount deducted correctly", Status.PASS);
		else
			report.updateTestLog("Checking Amount deducted", "Amount NOT deducted correctly", Status.FAIL);
		
		String varCartSubTotal=driver.findElement(By.xpath(UIMapCheckOut.lblCartSubtotal)).getText();
		if(varCartSubTotal.equals(varTotalPrice))
			report.updateTestLog("Checking Cart Subtotal", "Cart Subtotal displayed as Item 1 Price. Item 2 Price deducted.", Status.PASS);
		else
			report.updateTestLog("Checking Cart Subtotal", "Cart Subtotal NOT displayed as Item 1 Price.", Status.FAIL);
		
		boolean youSaveLabel=driver.findElement(By.xpath(UIMapCheckOut.lblCartSummaryYouSave)).isDisplayed();
		if(youSaveLabel)
		{
			report.updateTestLog("Checking You Save", "You SAVE displayed in Cart Summary", Status.PASS);
			String varYouSaveAmt=driver.findElement(By.xpath(UIMapCheckOut.lblCartSummaryYouSaveAmt)).getText();
			if(varYouSaveAmt.equals(varTotalPrice))
				report.updateTestLog("Checking You Save Amount", "You save amount displayed as Item Price", Status.PASS);
			else
				report.updateTestLog("Checking You Save Amount", "You save NOT amount displayed as Item Price", Status.FAIL);
		}
		else
			report.updateTestLog("Checking You Save", "You SAVE not displayed in Cart Summary", Status.FAIL);
		}
		else
		{
			report.updateTestLog("Checking whether Flexible Code Applied", "Item NOT Buy 1 Get 1", Status.FAIL);
		}
	}
	
	public void applyGConGCError() throws Exception
	{
		 try{
			    String varError=driver.findElement(By.xpath(UIMapCheckOut.lblRevPayError)).getText();
			    if(varError.equals("Gift cards cannot be applied to the purchase of gift cards."))
			    	report.updateTestLog("Applying Gift Card", "Correct Error Message displayed", Status.PASS);
			    else
			    	report.updateTestLog("Applying Gift Card", "Correct Error Message NOT displayed", Status.FAIL);
			    }
			    catch(Exception NoSuchElementException)
			    {
			    	report.updateTestLog("Applying Gift Card", "Error Message NOT displayed", Status.FAIL);
			    }
	}
	
	
	public void addAddrssInPrimaryAdd() throws Exception
	{
		if(dataTable.getData("General_Data", "BillingAdd").equals("Primary"))
		{
		driver.findElement(By.xpath(UIMapCheckOut.txtPriAddName)).clear();
		driver.findElement(By.xpath(UIMapCheckOut.txtPriAddName)).sendKeys(dataTable.getData("General_Data", "BillAddressNickName"));
		
		driver.findElement(By.xpath(UIMapCheckOut.txtPriAddFName)).clear();
		driver.findElement(By.xpath(UIMapCheckOut.txtPriAddFName)).sendKeys(dataTable.getData("General_Data", "BillFirstname"));
		
		driver.findElement(By.xpath(UIMapCheckOut.txtPriAddLName)).clear();
		driver.findElement(By.xpath(UIMapCheckOut.txtPriAddLName)).sendKeys(dataTable.getData("General_Data", "BillLastname"));
		
		driver.findElement(By.xpath(UIMapMyLowes.lblPrimaryAddress1)).sendKeys(
				dataTable.getData("General_Data", "BillAddress1"));
		
		driver.findElement(By.xpath(UIMapMyLowes.lblPrimaryCity)).sendKeys(
				dataTable.getData("General_Data", "BillCity"));
		new Select(driver.findElement(By.xpath(UIMapMyLowes.lblPrimaryState)))
				.selectByVisibleText(dataTable.getData("General_Data", "BillState"));
		driver.findElement(By.xpath(UIMapMyLowes.lblPrimaryZipCode)).sendKeys(
				dataTable.getData("General_Data", "Billzipcode"));
		
		driver.findElement(By.xpath(UIMapCheckOut.txtPriAddPhn)).clear();
		driver.findElement(By.xpath(UIMapCheckOut.txtPriAddPhn)).sendKeys(dataTable.getData("General_Data", "BillPhone1")+"-"+dataTable.getData("General_Data", "BillPhone2")+"-"+dataTable.getData("General_Data", "BillPhone3"));
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(UIMapMyLowes.btnSaveEditPAddress)).click();
		
		String varPrimaryAddress=dataTable.getData("General_Data", "BillAddressNickName")+" - "+dataTable.getData("General_Data", "BillAddress1")+","+dataTable.getData("General_Data", "BillCity")+
				" "+dataTable.getData("General_Data", "BillStateShortForm")+" "+dataTable.getData("General_Data", "Billzipcode");
		System.out.println(varPrimaryAddress);
		dataTable.putData("General_Data", "Primary Address", varPrimaryAddress);
		
		// pop up when given address with spelling mistake
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		boolean uspsContinue = selenium.isTextPresent("Confirm");
		if(uspsContinue){
			driver.findElement(By.id(UIMapCheckOut.rdoBtnUSPSEnteredAddress)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(UIMapMyLowes.btnCfrmUSPSAddress))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		}
		
		}
		else if(dataTable.getData("General_Data", "ShippingAdd").equals("Primary"))
		{
		driver.findElement(By.xpath(UIMapCheckOut.txtPriAddName)).clear();
		driver.findElement(By.xpath(UIMapCheckOut.txtPriAddName)).sendKeys(dataTable.getData("General_Data", "AddressNickName"));
		
		driver.findElement(By.xpath(UIMapCheckOut.txtPriAddFName)).clear();
		driver.findElement(By.xpath(UIMapCheckOut.txtPriAddFName)).sendKeys(dataTable.getData("General_Data", "Firstname"));
		
		driver.findElement(By.xpath(UIMapCheckOut.txtPriAddLName)).clear();
		driver.findElement(By.xpath(UIMapCheckOut.txtPriAddLName)).sendKeys(dataTable.getData("General_Data", "Lastname"));
		
		driver.findElement(By.xpath(UIMapMyLowes.lblPrimaryAddress1)).sendKeys(
				dataTable.getData("General_Data", "Address1"));
		
		driver.findElement(By.xpath(UIMapMyLowes.lblPrimaryCity)).sendKeys(
				dataTable.getData("General_Data", "City"));
		new Select(driver.findElement(By.xpath(UIMapMyLowes.lblPrimaryState)))
				.selectByVisibleText(dataTable.getData("General_Data", "State"));
		driver.findElement(By.xpath(UIMapMyLowes.lblPrimaryZipCode)).sendKeys(
				dataTable.getData("General_Data", "zipcode"));
		
		driver.findElement(By.xpath(UIMapCheckOut.txtPriAddPhn)).clear();
		driver.findElement(By.xpath(UIMapCheckOut.txtPriAddPhn)).sendKeys(dataTable.getData("General_Data", "Phone1")+"-"+dataTable.getData("General_Data", "Phone2")+"-"+dataTable.getData("General_Data", "Phone3"));
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(UIMapMyLowes.btnSaveEditPAddress)).click();
		
		/*String varPrimaryAddress=dataTable.getData("General_Data", "AddressNickName")+" - "+dataTable.getData("General_Data", "Address1")+","+dataTable.getData("General_Data", "City")+
				" "+dataTable.getData("General_Data", "StateShortForm")+" "+dataTable.getData("General_Data", "zipcode");
		System.out.println(varPrimaryAddress);
		dataTable.putData("General_Data", "Primary Address", varPrimaryAddress);*/
		String varShipToAddress=dataTable.getData("General_Data", "AddressNickName")+" - "+dataTable.getData("General_Data", "Firstname")+" "+dataTable.getData("General_Data", "Lastname");
		System.out.println(varShipToAddress);
		dataTable.putData("General_Data", "ShipToAdd", varShipToAddress);
		
		// pop up when given address with spelling mistake
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		boolean uspsContinue = selenium.isTextPresent("Confirm");
		if(uspsContinue){
			driver.findElement(By.id(UIMapCheckOut.rdoBtnUSPSEnteredAddress)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(UIMapMyLowes.btnCfrmUSPSAddress))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		}
		
		}
	}
	
	
	public void addAddrssInSecAdd() throws Exception
	{
		if(dataTable.getData("General_Data", "BillingAdd").equals("Secondary"))
		{
		
			driver.findElement(By.cssSelector("#add_new_address > span")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.id("addressField2")).sendKeys(
					dataTable.getData("General_Data", "BillAddressNickName"));
			
			
			driver.findElement(By.id("firstName")).sendKeys(
					dataTable.getData("General_Data", "BillFirstname"));
			
			driver.findElement(By.id("lastName")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("lastName")).sendKeys(
					dataTable.getData("General_Data", "BillLastname"));
			
			driver.findElement(By.id("address1")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("address1")).sendKeys(
					dataTable.getData("General_Data", "BillAddress1"));
			
			
			driver.findElement(By.id("city")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("city")).sendKeys(
					dataTable.getData("General_Data", "BillCity"));
			
			new Select(driver.findElement(By.id("state")))
					.selectByVisibleText(dataTable.getData("General_Data", "BillState"));
			
			driver.findElement(By.id("zipCode")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("zipCode")).sendKeys(
					dataTable.getData("General_Data", "Billzipcode"));
			
			driver.findElement(By.name("phone1")).click();
			Thread.sleep(1000);
			driver.findElement(By.name("phone1")).sendKeys(
					dataTable.getData("General_Data", "BillPhone1")+"-"+dataTable.getData("General_Data", "BillPhone2")+"-"+dataTable.getData("General_Data", "BillPhone3"));
			
			Thread.sleep(2000);
			driver.findElement(By.xpath(UIMapMyLowes.btnAddAddress)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(3000);
			
			String varPrimaryAddress=dataTable.getData("General_Data", "BillAddressNickName")+" - "+dataTable.getData("General_Data", "BillAddress1")+","+dataTable.getData("General_Data", "BillCity")+
					" "+dataTable.getData("General_Data", "BillStateShortForm")+" "+dataTable.getData("General_Data", "Billzipcode");
			System.out.println(varPrimaryAddress);
			dataTable.putData("General_Data", "Primary Address", varPrimaryAddress);

			
		
		}
		else if(dataTable.getData("General_Data", "ShippingAdd").equals("Secondary"))
		{
			driver.findElement(By.cssSelector("#add_new_address > span")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.id("addressField2")).sendKeys(
					dataTable.getData("General_Data", "AddressNickName"));
			
			
			driver.findElement(By.id("firstName")).sendKeys(
					dataTable.getData("General_Data", "Firstname"));
			
			driver.findElement(By.id("lastName")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("lastName")).sendKeys(
					dataTable.getData("General_Data", "Lastname"));
			
			driver.findElement(By.id("address1")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("address1")).sendKeys(
					dataTable.getData("General_Data", "Address1"));
			
			
			driver.findElement(By.id("city")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("city")).sendKeys(
					dataTable.getData("General_Data", "City"));
			
			new Select(driver.findElement(By.id("state")))
					.selectByVisibleText(dataTable.getData("General_Data", "State"));
			
			driver.findElement(By.id("zipCode")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("zipCode")).sendKeys(
					dataTable.getData("General_Data", "zipcode"));
			
			driver.findElement(By.name("phone1")).click();
			Thread.sleep(1000);
			driver.findElement(By.name("phone1")).sendKeys(
					dataTable.getData("General_Data", "Phone1")+"-"+dataTable.getData("General_Data", "Phone2")+"-"+dataTable.getData("General_Data", "Phone3"));
			
			Thread.sleep(2000);
			driver.findElement(By.xpath(UIMapMyLowes.btnAddAddress)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(3000);
			
			/*String varSecondaryAddress=dataTable.getData("General_Data", "AddressNickName")+" - "+dataTable.getData("General_Data", "Address1")+","+dataTable.getData("General_Data", "City")+
					" "+dataTable.getData("General_Data", "StateShortForm")+" "+dataTable.getData("General_Data", "zipcode");
			System.out.println(varSecondaryAddress);
			dataTable.putData("General_Data", "Primary Address", varSecondaryAddress);*/
			String varShipToAddress=dataTable.getData("General_Data", "AddressNickName")+" - "+dataTable.getData("General_Data", "Firstname")+" "+dataTable.getData("General_Data", "Lastname");
			System.out.println(varShipToAddress);
			dataTable.putData("General_Data", "ShipToAdd", varShipToAddress);
		
		}
	}
	
	/*******Validates Primary Address is same as before in Address Book after Order Completion******/
	public void validatePrimAddAddressBook() throws Exception
	{
		String varBillAdrssName=driver.findElement(By.xpath(UIMapCheckOut.lblBillAdressName)).getText();
		String varBillAdrssFname=driver.findElement(By.xpath(UIMapCheckOut.lblBillAdressFnameAB)).getText();
		String varBillAdrssLname=driver.findElement(By.xpath(UIMapCheckOut.lblBillAdressLnameAB)).getText();
		String varBillAdrssLine1=driver.findElement(By.xpath(UIMapCheckOut.lblBillAdressLine1AB)).getText();
		String varBillAdrssCity=driver.findElement(By.xpath(UIMapCheckOut.lblBillAdressCityAB)).getText();
		String varBillAdrssState=driver.findElement(By.xpath(UIMapCheckOut.lblBillAdressStateAbbAB)).getText();
		String varBillAdrssZC=driver.findElement(By.xpath(UIMapCheckOut.lblBillAdressZipCodeAB)).getText();
		String varBillAdrssPhn1=driver.findElement(By.xpath(UIMapCheckOut.lblBillAdressPhn1AB)).getText();
		String varBillAdrssPhn2=driver.findElement(By.xpath(UIMapCheckOut.lblBillAdressPhn2AB)).getText();
		String varBillAdrssPhn3=driver.findElement(By.xpath(UIMapCheckOut.lblBillAdressPhn3AB)).getText();
		if(dataTable.getData("General_Data", "BillingAdd").equals("Primary"))
		{
		
		
		System.out.println(varBillAdrssName+"::"+dataTable.getData("General_Data", "BillAddressNickName"));
		if(varBillAdrssName.equals(dataTable.getData("General_Data", "BillAddressNickName")))
			report.updateTestLog("Checking Primary Address Name", "Primary Address Name Correct", Status.PASS);
		else
			report.updateTestLog("Checking Primary Address Name", "Primary Address Name NOT Correct", Status.FAIL);
		
		
		System.out.println(varBillAdrssFname+"::"+dataTable.getData("General_Data", "BillFirstname"));
		if(varBillAdrssFname.equals(dataTable.getData("General_Data", "BillFirstname")))
			report.updateTestLog("Checking Primary Address First Name", "Primary Address First Name Correct", Status.PASS);
		else
			report.updateTestLog("Checking Primary Address First Name", "Primary Address First Name NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrssLname+"::"+dataTable.getData("General_Data", "BillLastname"));
		if(varBillAdrssLname.equals(dataTable.getData("General_Data", "BillLastname")))
			report.updateTestLog("Checking Primary Address Last Name", "Primary Address Last Name Correct", Status.PASS);
		else
			report.updateTestLog("Checking Primary Address Last Name", "Primary Address Last Name NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrssLine1+"::"+dataTable.getData("General_Data", "BillAddress1"));
		if(varBillAdrssLine1.equals(dataTable.getData("General_Data", "BillAddress1")))
			report.updateTestLog("Checking Primary Address Address Line 1", "Primary Address Address Line 1 Correct", Status.PASS);
		else
			report.updateTestLog("Checking Primary Address Address Line 1", "Primary Address Address Line 1 NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrssCity+"::"+dataTable.getData("General_Data", "BillCity"));
		if(varBillAdrssCity.equals(dataTable.getData("General_Data", "BillCity")))
			report.updateTestLog("Checking Primary Address City", "Primary Address City Correct", Status.PASS);
		else
			report.updateTestLog("Checking Primary Address City", "Primary Address City NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrssState+"::"+dataTable.getData("General_Data", "BillStateShortForm"));
		if(varBillAdrssState.equals(dataTable.getData("General_Data", "BillStateShortForm")))
			report.updateTestLog("Checking Primary Address State", "Primary Address State Correct", Status.PASS);
		else
			report.updateTestLog("Checking Primary Address State", "Primary Address State NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrssZC+"::"+dataTable.getData("General_Data", "Billzipcode"));
		if(varBillAdrssZC.equals(dataTable.getData("General_Data", "Billzipcode")))
			report.updateTestLog("Checking Primary Address Zip Code", "Primary Address Zip Code Correct", Status.PASS);
		else
			report.updateTestLog("Checking Primary Address Zip Code", "Primary Address Zip Code NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrssPhn1+"::"+dataTable.getData("General_Data", "BillPhone1"));
		if(varBillAdrssPhn1.equals(dataTable.getData("General_Data", "BillPhone1")))
			report.updateTestLog("Checking Primary Address Phone", "Primary Address Phone1 Correct", Status.PASS);
		else
			report.updateTestLog("Checking Primary Address Phone", "Primary Address Phone1 NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrssPhn2+"::"+dataTable.getData("General_Data", "BillPhone2"));
		if(varBillAdrssPhn2.equals(dataTable.getData("General_Data", "BillPhone2")))
			report.updateTestLog("Checking Primary Address Phone", "Primary Address Phone2 Correct", Status.PASS);
		else
			report.updateTestLog("Checking Primary Address Phone", "Primary Address Phone2 NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrssPhn3+"::"+dataTable.getData("General_Data", "BillPhone3"));
		if(varBillAdrssPhn3.equals(dataTable.getData("General_Data", "BillPhone3")))
			report.updateTestLog("Checking Primary Address Phone", "Primary Address Phone3 Correct", Status.PASS);
		else
			report.updateTestLog("Checking Primary Address Phone", "Primary Address Phone3 NOT Correct", Status.FAIL);
		}
		else if(dataTable.getData("General_Data", "ShippingAdd").equals("Primary"))
		{
			
			
			System.out.println(varBillAdrssName+"::"+dataTable.getData("General_Data", "AddressNickName"));
			if(varBillAdrssName.equals(dataTable.getData("General_Data", "AddressNickName")))
				report.updateTestLog("Checking Primary Address Name", "Primary Address Name Correct", Status.PASS);
			else
				report.updateTestLog("Checking Primary Address Name", "Primary Address Name NOT Correct", Status.FAIL);
			
			
			System.out.println(varBillAdrssFname+"::"+dataTable.getData("General_Data", "Firstname"));
			if(varBillAdrssFname.equals(dataTable.getData("General_Data", "Firstname")))
				report.updateTestLog("Checking Primary Address First Name", "Primary Address First Name Correct", Status.PASS);
			else
				report.updateTestLog("Checking Primary Address First Name", "Primary Address First Name NOT Correct", Status.FAIL);
			
			System.out.println(varBillAdrssLname+"::"+dataTable.getData("General_Data", "Lastname"));
			if(varBillAdrssLname.equals(dataTable.getData("General_Data", "Lastname")))
				report.updateTestLog("Checking Primary Address Last Name", "Primary Address Last Name Correct", Status.PASS);
			else
				report.updateTestLog("Checking Primary Address Last Name", "Primary Address Last Name NOT Correct", Status.FAIL);
			
			System.out.println(varBillAdrssLine1+"::"+dataTable.getData("General_Data", "Address1"));
			if(varBillAdrssLine1.equals(dataTable.getData("General_Data", "Address1")))
				report.updateTestLog("Checking Primary Address Address Line 1", "Primary Address Address Line 1 Correct", Status.PASS);
			else
				report.updateTestLog("Checking Primary Address Address Line 1", "Primary Address Address Line 1 NOT Correct", Status.FAIL);
			
			System.out.println(varBillAdrssCity+"::"+dataTable.getData("General_Data", "City"));
			if(varBillAdrssCity.equals(dataTable.getData("General_Data", "City")))
				report.updateTestLog("Checking Primary Address City", "Primary Address City Correct", Status.PASS);
			else
				report.updateTestLog("Checking Primary Address City", "Primary Address City NOT Correct", Status.FAIL);
			
			System.out.println(varBillAdrssState+"::"+dataTable.getData("General_Data", "StateShortForm"));
			if(varBillAdrssState.equals(dataTable.getData("General_Data", "StateShortForm")))
				report.updateTestLog("Checking Primary Address State", "Primary Address State Correct", Status.PASS);
			else
				report.updateTestLog("Checking Primary Address State", "Primary Address State NOT Correct", Status.FAIL);
			
			System.out.println(varBillAdrssZC+"::"+dataTable.getData("General_Data", "zipcode"));
			if(varBillAdrssZC.equals(dataTable.getData("General_Data", "zipcode")))
				report.updateTestLog("Checking Primary Address Zip Code", "Primary Address Zip Code Correct", Status.PASS);
			else
				report.updateTestLog("Checking Primary Address Zip Code", "Primary Address Zip Code NOT Correct", Status.FAIL);
			
			System.out.println(varBillAdrssPhn1+"::"+dataTable.getData("General_Data", "Phone1"));
			if(varBillAdrssPhn1.equals(dataTable.getData("General_Data", "Phone1")))
				report.updateTestLog("Checking Primary Address Phone", "Primary Address Phone1 Correct", Status.PASS);
			else
				report.updateTestLog("Checking Primary Address Phone", "Primary Address Phone1 NOT Correct", Status.FAIL);
			
			System.out.println(varBillAdrssPhn2+"::"+dataTable.getData("General_Data", "Phone2"));
			if(varBillAdrssPhn2.equals(dataTable.getData("General_Data", "Phone2")))
				report.updateTestLog("Checking Primary Address Phone", "Primary Address Phone2 Correct", Status.PASS);
			else
				report.updateTestLog("Checking Primary Address Phone", "Primary Address Phone2 NOT Correct", Status.FAIL);
			
			System.out.println(varBillAdrssPhn3+"::"+dataTable.getData("General_Data", "Phone3"));
			if(varBillAdrssPhn3.equals(dataTable.getData("General_Data", "Phone3")))
				report.updateTestLog("Checking Primary Address Phone", "Primary Address Phone3 Correct", Status.PASS);
			else
				report.updateTestLog("Checking Primary Address Phone", "Primary Address Phone3 NOT Correct", Status.FAIL);
			
		}
		
	}
	
	
	/*******Validates Secondary Address is same as before in Address Book after Order Completion******/
	public void validateSecAddAddressBook() throws Exception
	{
		String varBillAdrssName=driver.findElement(By.xpath(UIMapCheckOut.lblShipAdressName)).getText();
		String varBillAdrssFname=driver.findElement(By.xpath(UIMapCheckOut.lblShipAdressFnameAB)).getText();
		String varBillAdrssLname=driver.findElement(By.xpath(UIMapCheckOut.lblShipAdressLnameAB)).getText();
		String varBillAdrssLine1=driver.findElement(By.xpath(UIMapCheckOut.lblShipAdressLine1AB)).getText();
		String varBillAdrssCity=driver.findElement(By.xpath(UIMapCheckOut.lblShipAdressCityAB)).getText();
		String varBillAdrssState=driver.findElement(By.xpath(UIMapCheckOut.lblShipAdressStateAbbAB)).getText();
		String varBillAdrssZC=driver.findElement(By.xpath(UIMapCheckOut.lblShipAdressZipCodeAB)).getText();
		String varBillAdrssPhn1=driver.findElement(By.xpath(UIMapCheckOut.lblShipAdressPhn1AB)).getText();
		String varBillAdrssPhn2=driver.findElement(By.xpath(UIMapCheckOut.lblShipAdressPhn2AB)).getText();
		String varBillAdrssPhn3=driver.findElement(By.xpath(UIMapCheckOut.lblShipAdressPhn3AB)).getText();
		if(dataTable.getData("General_Data", "BillingAdd").equals("Secondary"))
		{
		System.out.println("Billing address Secondary");
		
		
		System.out.println(varBillAdrssName+"::"+dataTable.getData("General_Data", "BillAddressNickName"));
		if(varBillAdrssName.equals(dataTable.getData("General_Data", "BillAddressNickName")))
			report.updateTestLog("Checking Secondary Address Name", "Secondary Address Name Correct", Status.PASS);
		else
			report.updateTestLog("Checking Secondary Address Name", "Secondary Address Name NOT Correct", Status.FAIL);
		
		
		System.out.println(varBillAdrssFname+"::"+dataTable.getData("General_Data", "BillFirstname"));
		if(varBillAdrssFname.equals(dataTable.getData("General_Data", "BillFirstname")))
			report.updateTestLog("Checking Secondary Address First Name", "Secondary Address First Name Correct", Status.PASS);
		else
			report.updateTestLog("Checking Secondary Address First Name", "Secondary Address First Name NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrssLname+"::"+dataTable.getData("General_Data", "BillLastname"));
		if(varBillAdrssLname.equals(dataTable.getData("General_Data", "BillLastname")))
			report.updateTestLog("Checking Secondary Address Last Name", "Secondary Address Last Name Correct", Status.PASS);
		else
			report.updateTestLog("Checking Secondary Address Last Name", "Secondary Address Last Name NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrssLine1+"::"+dataTable.getData("General_Data", "BillAddress1"));
		if(varBillAdrssLine1.equals(dataTable.getData("General_Data", "BillAddress1")))
			report.updateTestLog("Checking Secondary Address Address Line 1", "Secondary Address Address Line 1 Correct", Status.PASS);
		else
			report.updateTestLog("Checking Secondary Address Address Line 1", "Secondary Address Address Line 1 NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrssCity+"::"+dataTable.getData("General_Data", "BillCity"));
		if(varBillAdrssCity.equals(dataTable.getData("General_Data", "BillCity")))
			report.updateTestLog("Checking Secondary Address City", "Secondary Address City Correct", Status.PASS);
		else
			report.updateTestLog("Checking Secondary Address City", "Secondary Address City NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrssState+"::"+dataTable.getData("General_Data", "BillStateShortForm"));
		if(varBillAdrssState.equals(dataTable.getData("General_Data", "BillStateShortForm")))
			report.updateTestLog("Checking Secondary Address State", "Secondary Address State Correct", Status.PASS);
		else
			report.updateTestLog("Checking Secondary Address State", "Secondary Address State NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrssZC+"::"+dataTable.getData("General_Data", "Billzipcode"));
		if(varBillAdrssZC.equals(dataTable.getData("General_Data", "Billzipcode")))
			report.updateTestLog("Checking Secondary Address Zip Code", "Secondary Address Zip Code Correct", Status.PASS);
		else
			report.updateTestLog("Checking Secondary Address Zip Code", "Secondary Address Zip Code NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrssPhn1+"::"+dataTable.getData("General_Data", "BillPhone1"));
		if(varBillAdrssPhn1.equals(dataTable.getData("General_Data", "BillPhone1")))
			report.updateTestLog("Checking Secondary Address Phone", "Secondary Address Phone1 Correct", Status.PASS);
		else
			report.updateTestLog("Checking Secondary Address Phone", "Secondary Address Phone1 NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrssPhn2+"::"+dataTable.getData("General_Data", "BillPhone2"));
		if(varBillAdrssPhn2.equals(dataTable.getData("General_Data", "BillPhone2")))
			report.updateTestLog("Checking Secondary Address Phone", "Secondary Address Phone2 Correct", Status.PASS);
		else
			report.updateTestLog("Checking Secondary Address Phone", "Secondary Address Phone2 NOT Correct", Status.FAIL);
		
		System.out.println(varBillAdrssPhn3+"::"+dataTable.getData("General_Data", "BillPhone3"));
		if(varBillAdrssPhn3.equals(dataTable.getData("General_Data", "BillPhone3")))
			report.updateTestLog("Checking Secondary Address Phone", "Secondary Address Phone3 Correct", Status.PASS);
		else
			report.updateTestLog("Checking Secondary Address Phone", "Secondary Address Phone3 NOT Correct", Status.FAIL);
		}
		else if(dataTable.getData("General_Data", "ShippingAdd").equals("Secondary"))
		{
			System.out.println("Shipping address Secondary");
			
			System.out.println(varBillAdrssName+"::"+dataTable.getData("General_Data", "AddressNickName"));
			if(varBillAdrssName.equals(dataTable.getData("General_Data", "AddressNickName")))
				report.updateTestLog("Checking Secondary Address Name", "Secondary Address Name Correct", Status.PASS);
			else
				report.updateTestLog("Checking Secondary Address Name", "Secondary Address Name NOT Correct", Status.FAIL);
			
			
			System.out.println(varBillAdrssFname+"::"+dataTable.getData("General_Data", "Firstname"));
			if(varBillAdrssFname.equals(dataTable.getData("General_Data", "Firstname")))
				report.updateTestLog("Checking Secondary Address First Name", "Secondary Address First Name Correct", Status.PASS);
			else
				report.updateTestLog("Checking Secondary Address First Name", "Secondary Address First Name NOT Correct", Status.FAIL);
			
			System.out.println(varBillAdrssLname+"::"+dataTable.getData("General_Data", "Lastname"));
			if(varBillAdrssLname.equals(dataTable.getData("General_Data", "Lastname")))
				report.updateTestLog("Checking Secondary Address Last Name", "Secondary Address Last Name Correct", Status.PASS);
			else
				report.updateTestLog("Checking Secondary Address Last Name", "Secondary Address Last Name NOT Correct", Status.FAIL);
			
			System.out.println(varBillAdrssLine1+"::"+dataTable.getData("General_Data", "Address1"));
			if(varBillAdrssLine1.equals(dataTable.getData("General_Data", "Address1")))
				report.updateTestLog("Checking Secondary Address Address Line 1", "Secondary Address Address Line 1 Correct", Status.PASS);
			else
				report.updateTestLog("Checking Secondary Address Address Line 1", "Secondary Address Address Line 1 NOT Correct", Status.FAIL);
			
			System.out.println(varBillAdrssCity+"::"+dataTable.getData("General_Data", "City"));
			if(varBillAdrssCity.equals(dataTable.getData("General_Data", "City")))
				report.updateTestLog("Checking Secondary Address City", "Secondary Address City Correct", Status.PASS);
			else
				report.updateTestLog("Checking Secondary Address City", "Secondary Address City NOT Correct", Status.FAIL);
			
			System.out.println(varBillAdrssState+"::"+dataTable.getData("General_Data", "StateShortForm"));
			if(varBillAdrssState.equals(dataTable.getData("General_Data", "StateShortForm")))
				report.updateTestLog("Checking Secondary Address State", "Secondary Address State Correct", Status.PASS);
			else
				report.updateTestLog("Checking Secondary Address State", "Secondary Address State NOT Correct", Status.FAIL);
			
			System.out.println(varBillAdrssZC+"::"+dataTable.getData("General_Data", "zipcode"));
			if(varBillAdrssZC.equals(dataTable.getData("General_Data", "zipcode")))
				report.updateTestLog("Checking Secondary Address Zip Code", "Secondary Address Zip Code Correct", Status.PASS);
			else
				report.updateTestLog("Checking Secondary Address Zip Code", "Secondary Address Zip Code NOT Correct", Status.FAIL);
			
			System.out.println(varBillAdrssPhn1+"::"+dataTable.getData("General_Data", "Phone1"));
			if(varBillAdrssPhn1.equals(dataTable.getData("General_Data", "Phone1")))
				report.updateTestLog("Checking Secondary Address Phone", "Secondary Address Phone1 Correct", Status.PASS);
			else
				report.updateTestLog("Checking Secondary Address Phone", "Secondary Address Phone1 NOT Correct", Status.FAIL);
			
			System.out.println(varBillAdrssPhn2+"::"+dataTable.getData("General_Data", "Phone2"));
			if(varBillAdrssPhn2.equals(dataTable.getData("General_Data", "Phone2")))
				report.updateTestLog("Checking Secondary Address Phone", "Secondary Address Phone2 Correct", Status.PASS);
			else
				report.updateTestLog("Checking Secondary Address Phone", "Secondary Address Phone2 NOT Correct", Status.FAIL);
			
			System.out.println(varBillAdrssPhn3+"::"+dataTable.getData("General_Data", "Phone3"));
			if(varBillAdrssPhn3.equals(dataTable.getData("General_Data", "Phone3")))
				report.updateTestLog("Checking Secondary Address Phone", "Secondary Address Phone3 Correct", Status.PASS);
			else
				report.updateTestLog("Checking Secondary Address Phone", "Secondary Address Phone3 NOT Correct", Status.FAIL);
			
		}
		
	}
	
	/************This function creates Primary Address string to be displayed in Billing Address-Primary Address drop down*******
	 * This is for scenario where user account has single address to be used as both Shipping and Billing Address/
	 * 
	 */
	public void storePrimaryAddrssforDropDown() throws Exception
	{
		String varPrimaryAddress=dataTable.getData("General_Data", "AddressNickName")+" - "+dataTable.getData("General_Data", "Address1")+","+dataTable.getData("General_Data", "City")+
				" "+dataTable.getData("General_Data", "StateShortForm")+" "+dataTable.getData("General_Data", "zipcode");
		System.out.println(varPrimaryAddress);
		dataTable.putData("General_Data", "Primary Address", varPrimaryAddress);
	}
	
	/*This method checks whether correct Delivery Method is displayed for item in Order Confirmation page-for single product in Cart*/
	public void checkDelTypeOrderConfrmation() throws Exception
	{
		String varDeliveryOption = dataTable.getData("General_Data", "DeliveryMthd");
		String varDelTypeDisplayed=driver.findElement(By.cssSelector(UIMapCheckOut.lblDelType)).getText();
		if(varDeliveryOption.equals("PL"))
		{
			if(varDelTypeDisplayed.trim().equals("Store Pickup"))
				report.updateTestLog("Checking Delivery Method displayed on Order Confirmation", "Store Pickup displayed", Status.PASS);
			else
				report.updateTestLog("Checking Delivery Method displayed on Order Confirmation", "Store Pickup NOT displayed", Status.FAIL);	
		}
		else if(varDeliveryOption.equals("UPS"))
		{
			if(varDelTypeDisplayed.trim().equals("Parcel Shipping"))
				report.updateTestLog("Checking Delivery Method displayed on Order Confirmation", "Parcel Shipping displayed", Status.PASS);
			else
				report.updateTestLog("Checking Delivery Method displayed on Order Confirmation", "Parcel Shipping NOT displayed", Status.FAIL);	
		}
		else if(varDeliveryOption.equals("LD"))
		{
			if(varDelTypeDisplayed.trim().equals("Lowe's Truck Delivery"))
				report.updateTestLog("Checking Delivery Method displayed on Order Confirmation", "Lowe's Truck Delivery displayed", Status.PASS);
			else
				report.updateTestLog("Checking Delivery Method displayed on Order Confirmation", "Lowe's Truck Delivery NOT displayed", Status.FAIL);	
		}
	}
	
	/******
	 * This function validates whether proper error message is displayed when Email address and Phone Nbr fields are left blank on Review & Pay Page
	 */
	public void validateNoEmailErrorRevPayPg() throws Exception
	{
		driver.findElement(By.id(UIMapMyLowes.txtBillPh1)).clear();
		
		driver.findElement(By.id(UIMapMyLowes.txtBillPh2)).clear();
		
		driver.findElement(By.name(UIMapMyLowes.txtBillPh3)).clear();
		
		driver.findElement(By.id(UIMapMyLowes.txtBillEmailAdd)).clear();
		
		co.clickCheckOutInReviewPageDetail();
		try{
		String varError=driver.findElement(By.cssSelector(UIMapCheckOut.lblEmailReqderror)).getText();
		if(varError.equals("Please enter your email address."))
			report.updateTestLog("Checking Error Message", "Correct Error Message displayed", Status.PASS);
		else
			report.updateTestLog("Checking Error Message", "Correct Error Message NOT displayed", Status.FAIL);
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking Error Message", "Error Message NOT displayed", Status.FAIL);
		}
	}
	
	/****
	 * This function clicks on Cancel Link displayed on opening Address Book having Primary Address
	 */
	public void clickCancelPrimaryAddAddBook() throws Exception
	{
		driver.findElement(By.partialLinkText("Cancel")).click();
		Thread.sleep(2000);
	}
	
	/**
	 * This function validates Order Level PromoCode Text and value is displayed Correctly after applying in CART
	 */
	public void checkAppliedOrderLevelPCCart() throws Exception
	{
		try{
		String varPromoCodeTxt1=driver.findElement(By.xpath(UIMapCheckOut.lblPromoTxt1)).getText();
		String varPromoCodeTxt2=driver.findElement(By.xpath(UIMapCheckOut.lblPromoTxt2)).getText();
		String varPromoDiscount=driver.findElement(By.xpath(UIMapCheckOut.lblPromoDiscount)).getText();
		if((!varPromoCodeTxt1.isEmpty()) && (!varPromoCodeTxt2.isEmpty()) && (!varPromoDiscount.isEmpty()) )
			report.updateTestLog("Checking Promo Applied", "Promo Label and discount displayed in Cart", Status.PASS);
		else
			report.updateTestLog("Checking Promo Applied", "Promo Label and discount NOT displayed in Cart", Status.FAIL);
			
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking Promo Applied", "Promo Label and discount NOT displayed in Cart", Status.FAIL);
		}
	}
	
	/**
	 * This function validates Order Level PromoCode Text and value is displayed  in Review & Pay Page
	 */
	public void checkAppliedOrderLevelPCRevPayPg() throws Exception
	{
		try{
		String varPromoCodeTxt1=driver.findElement(By.xpath(UIMapCheckOut.lblPromoTxtRevPay)).getText();
		
		String varPromoDiscount=driver.findElement(By.xpath(UIMapCheckOut.lblPromoDiscountRevPay)).getText();
		if((!varPromoCodeTxt1.isEmpty()) && (!varPromoDiscount.isEmpty()) )
			report.updateTestLog("Checking Promo Applied", "Promo Label and discount displayed in Review & Pay Page", Status.PASS);
		else
			report.updateTestLog("Checking Promo Applied", "Promo Label and discount NOT displayed in Review & Pay Page", Status.FAIL);
			
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking Promo Applied", "Promo Label and discount NOT displayed in Review & Pay Page", Status.FAIL);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * This verifyMultipleItemsZippedInRstctdStore() method is used to verify the purchase order which is parcel shipping
	 * 
	 */
	public void verifyMultipleItemsZippedInRstctdStore() throws Exception {
		
		fc.changeStore();//zip into a restricted selling store
		Thread.sleep(5000);
		//Item should have a selling restriction
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data", "ItemNbr1"));
		try {
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		} catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		}
		report.updateTestLog("Searching For an Item","Searching Item Number - "	+ dataTable.getData("General_Data", "ItemNbr1") + "",Status.DONE);

		try {
		driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
		}
		catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
		}
		Thread.sleep(5000);
		try{		
			driver.findElement(By.id(dataTable.getData("General_Data", "DeliveryMthd1"))).click();//Pick up in store delivery method
			Thread.sleep(2000);
			report.updateTestLog("Selecting delivery Method", "Delivery Method: "+dataTable.getData("General_Data", "DeliveryMthd")+" selected for Item: "+dataTable.getData("General_Data", "ItemNbr"), Status.PASS);
				
			}
		catch(Exception NoSuchElementException)
		{
				report.updateTestLog("Selecting delivery Method", "Delivery Method: "+dataTable.getData("General_Data", "DeliveryMthd")+" NOT AVAILABLE for Item: "+dataTable.getData("General_Data", "ItemNbr"), Status.FAIL);
		}
		Thread.sleep(5000);
		//validate the restricted error message when store pick up is selected as delivery method
		if(driver.findElement(By.xpath("")).isDisplayed()){
			report.updateTestLog("Verifying the restricted selecting delivery option","Verification is successful", Status.PASS);
		}else{
			report.updateTestLog("Verifying the restricted selecting delivery option","Verification is not successful", Status.FAIL);
		}
		Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
		try{		
			driver.findElement(By.id(dataTable.getData("General_Data", "DeliveryMthd2"))).click();//Truck delivery is the delivery method
			Thread.sleep(2000);
			report.updateTestLog("Selecting delivery Method", "Delivery Method: "+dataTable.getData("General_Data", "DeliveryMthd")+" selected for Item: "+dataTable.getData("General_Data", "ItemNbr"), Status.PASS);
				
			}
		catch(Exception NoSuchElementException)
		{
				report.updateTestLog("Selecting delivery Method", "Delivery Method: "+dataTable.getData("General_Data", "DeliveryMthd")+" NOT AVAILABLE for Item: "+dataTable.getData("General_Data", "ItemNbr"), Status.FAIL);
		}
		Thread.sleep(5000);
		
		//Item should have a selling restriction
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data", "ItemNbr2"));
		try {
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		} catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);
		}
		report.updateTestLog("Searching For an Item","Searching Item Number - "	+ dataTable.getData("General_Data", "ItemNbr2") + "",Status.DONE);

		Thread.sleep(5000);
		try{		
			driver.findElement(By.id(dataTable.getData("General_Data", "DeliveryMthd1"))).click();//Pick up in store delivery method
			Thread.sleep(2000);
			report.updateTestLog("Selecting delivery Method", "Delivery Method: "+dataTable.getData("General_Data", "DeliveryMthd")+" selected for Item: "+dataTable.getData("General_Data", "ItemNbr"), Status.PASS);
				
			}
		catch(Exception NoSuchElementException)
		{
				report.updateTestLog("Selecting delivery Method", "Delivery Method: "+dataTable.getData("General_Data", "DeliveryMthd")+" NOT AVAILABLE for Item: "+dataTable.getData("General_Data", "ItemNbr"), Status.FAIL);
		}
		Thread.sleep(5000);
		//validate the restricted error message when store pick up is selected as delivery method
		if(driver.findElement(By.xpath("")).isDisplayed()){
			report.updateTestLog("Verifying the restricted selecting delivery option","Verification is successful", Status.PASS);
		}else{
			report.updateTestLog("Verifying the restricted selecting delivery option","Verification is not successful", Status.FAIL);
		}
		try{		
			driver.findElement(By.id(dataTable.getData("General_Data", "DeliveryMthd2"))).click();//Truck delivery is the delivery method
			Thread.sleep(2000);
			report.updateTestLog("Selecting delivery Method", "Delivery Method: "+dataTable.getData("General_Data", "DeliveryMthd")+" selected for Item: "+dataTable.getData("General_Data", "ItemNbr"), Status.PASS);
				
			}
		catch(Exception NoSuchElementException)
		{
				report.updateTestLog("Selecting delivery Method", "Delivery Method: "+dataTable.getData("General_Data", "DeliveryMthd")+" NOT AVAILABLE for Item: "+dataTable.getData("General_Data", "ItemNbr"), Status.FAIL);
		}
		Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	}
	
	/**
	 * This verifyNonSellingItmInRstctdStoreSPAZ() method is used to verify the purchase order which is parcel shipping
	 * 
	 */
	public void verifyNonSellingItmInRstctdStoreSPAZ() throws Exception {
		
		fc.changeStore();//zip into a store which has selling restriction
		Thread.sleep(5000);
	    co.searchAndAddItemToCart(); //Non-selling restriction item to be added in cart
	    Thread.sleep(5000);
	    co.selectDlvryMthd();//store pick up delivery method should be selected
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	    
	}
	
	/**
	 * This verifyNonSellingItmInRstctdStoreSPLI() method is used to verify the purchase order which is parcel shipping
	 * 
	 */
	public void verifyNonSellingItmInRstctdStoreSPLI() throws Exception {
	
		fc.verifyingRegisteredUserLogin();
		verifyNonSellingItmInRstctdStoreSPAZ(); //Add the selling restriction item to the cart
	}
	
	/**
	 * This verifyNonSellingItmInRstctdStoreLDAZ() method is used to verify the purchase order which is parcel shipping
	 * 
	 */
	public void verifyNonSellingItmInRstctdStoreLDAZ() throws Exception {
		
		fc.changeStore();//Zip into a store which has selling restriction
		Thread.sleep(5000);
	    co.searchAndAddItemToCart(); //selling restriction item to be added in cart
	    Thread.sleep(5000);
	    co.selectDlvryMthd();//Truck delivery method should be selected
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	    
	}
	
	/**
	 * This verifyNonSellingItmInRstctdStorePSAZ() method is used to verify the purchase order which is parcel shipping
	 * 
	 */
	public void verifyNonSellingItmInRstctdStorePSAZ() throws Exception {
		
		fc.changeStore();//zip into a store which has selling restriction
		Thread.sleep(5000);
	    co.searchAndAddItemToCart(); //selling restriction item to be added in cart
	    Thread.sleep(5000);
	    co.selectDlvryMthd();//Parcel delivery method should be selected
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	    
	}
	/**
	 * This verifyNonSellingItmInRstctdStoreViaMstHead() method is used to verify the purchase order which is parcel shipping
	 * 
	 */
	public void verifyNonSellingItmInRstctdStoreViaMstHead() throws Exception {
		
		fc.changeStore();//zip into a store which doesnot have any selling restriction
		Thread.sleep(5000);
		co.searchAndAddItemToCart(); //Non-selling restriction item to be added in cart
		Thread.sleep(5000);
		co.selectDlvryMthd();//store pick up delivery method should be selected
	    Thread.sleep(5000);
	    
	    //change the store from the master head.
	    driver.findElement(By.cssSelector(UIMapProductSearch.btnChangeStoreInfo)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id(UIMapProductSearch.txtStoreSearch)).clear();
	    driver.findElement(By.id(UIMapProductSearch.txtStoreSearch)).sendKeys(dataTable.getData("General_Data","zipcode")); //selling restricted store
	    driver.findElement(By.id(UIMapProductSearch.btnHeaderMapSearch)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.linkText("Make This Your Store")).click();
	    Thread.sleep(5000);	
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	    Thread.sleep(5000);
	    co.selectDlvryMthd();////store pick up delivery method should be selected
	    //validate the restricted error message when store pick up is selected as delivery method
		if(driver.findElement(By.xpath("")).isDisplayed()){
			report.updateTestLog("Verifying the restricted selecting delivery option","Verification is successful", Status.PASS);
		}else{
			report.updateTestLog("Verifying the restricted selecting delivery option","Verification is not successful", Status.FAIL);
		} 
		
		
	    
	}
	
	/**
	 * This verifyNonPIFLeviedState() method is used to verify the PIF Levied state
	 * 
	 */
	public void verifyNonPIFLeviedState() throws Exception {
		
		co.searchAndAddItemToCart();
		Thread.sleep(5000);	
	    driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	}
	
	/**
	 * This verifyPIFLeviedStateLTD() method is used to verify the PIF Levied State for LTD
	 * 
	 */
	public void verifyPIFLeviedStateLTD() throws Exception {
		
		fc.verifyingRegisteredUserLogin();
		Thread.sleep(5000);
		co.addItemToCartWithDlvryMthd();//Item with PIF and the delivery method is Parcel Shipping
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapProductSearch.webElmntPrsntPrdAddToCart5)).click();
		Thread.sleep(5000);
		co.addItemToCartWithDlvryMthd();//Item with PIF and the delivery method is Truck Delivery
	    driver.findElement(By.cssSelector(UIMapMyLowes.btnStrtChkOut)).click();
	    //An if condition to be added to verify the PIF tag present present or not
	}
	
	/***********Kishore*************/
	public void validatePromoCodeinCart() throws Exception
	{
		String s = driver.findElement(By.xpath(UIMapCheckOut.lblCartSubtotal)).getText();
		float d = transformStringToFloatPrice(s);
		try
		{
			driver.findElement(By.xpath(UIMapCheckOut.lnkRemove)).click();
			driver.findElement(By.id(UIMapCheckOut.txtPromoCode)).sendKeys(dataTable.getData("General_Data","PromoCode"));
			ClickCustomize("xpath",UIMapCheckOut.btnPromoCodeApply);
			selenium.waitForPageToLoad("20000");
			Thread.sleep(3000);
		}
		catch(Exception e){
			driver.findElement(By.id(UIMapCheckOut.txtPromoCode)).sendKeys(dataTable.getData("General_Data","PromoCode"));
			ClickCustomize("xpath",UIMapCheckOut.btnPromoCodeApply);
			selenium.waitForPageToLoad("20000");
			Thread.sleep(3000);			
		}
		
		if(!(driver.findElement(By.xpath(UIMapCheckOut.lnkRemove)).isDisplayed()))
		{
			report.updateTestLog("Verifying the Promotion","Promotion not applied correctly", Status.FAIL);
		}
		String s1 = driver.findElement(By.xpath(UIMapCheckOut.lblDel1ChargesValue)).getText();
		float f = 5;
		if((d > f) && (s1.equals("-$1.00")))
		{
			report.updateTestLog("Verifying the Promotion percentage","Promotion percentage applied correctly", Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying the Promotion","Promotion percentage not applied correctly", Status.FAIL);
		}
	}
	
	public void validateQuantityOfParentAndLineItems() throws Exception
	{
		if(driver.findElement(By.xpath(UIMapCheckOut.lblSpecialTax)).getText().contains("Special Fees"))
		{
	    report.updateTestLog("Verifying the Special Tax for this item","Special Tax is displayed", Status.PASS);	
		String s = driver.findElement(By.xpath(UIMapCheckOut.txtParentQuantityInCart)).getAttribute("value");
		String s1 = driver.findElement(By.xpath(UIMapCheckOut.lblLineQuanityInCart)).getText();
		System.out.println("Parent:"+s);
		System.out.println("Line Item:"+s1);
	    if(s.equals(s1.trim()))
	    {
	    	report.updateTestLog("Verifying the Quantity for Parent and Line items","Quantity for Parent and Line items are matched", Status.PASS);
	    }
	    else
	    {
	    	report.updateTestLog("Verifying the Quantity for Parent and Line items","Quantity for Parent and Line items are not matched", Status.FAIL);
	    }
	    try
	    {
	    driver.findElement(By.xpath(UIMapCheckOut.lblLineQuanityInCart)).sendKeys("2");
	    report.updateTestLog("Verifying whether Line item quantity is editable","Line item quantity is editable", Status.FAIL);
	    }
	    catch(Exception e)
	    {
	    	report.updateTestLog("Verifying whether Line item quantity is editable","Line item quantity is not editable", Status.PASS);
	    }
	    driver.findElement(By.xpath(UIMapCheckOut.txtParentQuantityInCart)).clear();
	    driver.findElement(By.xpath(UIMapCheckOut.txtParentQuantityInCart)).sendKeys(dataTable.getData("General_Data", "Qty"));
	    ClickCustomize("xpath",UIMapCheckOut.btnQtyUpdate);
	    selenium.waitForPageToLoad("20000");
	    Thread.sleep(1000);
	    String s2 = driver.findElement(By.xpath(UIMapCheckOut.txtParentQuantityInCart)).getAttribute("value");
		String s3 = driver.findElement(By.xpath(UIMapCheckOut.lblLineQuanityInCart)).getText();
		System.out.println(s2);
		System.out.println(s3);
		if(s2.equals(s3.trim()))
	    {
	    	report.updateTestLog("Verifying the Quantity for Parent and Line items after changing the Parent item quantity","Quantity for Parent and Line items are matched", Status.PASS);
	    }
	    else
	    {
	    	report.updateTestLog("Verifying the Quantity for Parent and Line items after changing the Parent item quantity","Quantity for Parent and Line items are not matched", Status.FAIL);
	    }
		int Qty = Integer.parseInt(s2);
		String parentUnitPrice = driver.findElement(By.xpath(UIMapCheckOut.lblUnitPriceValue)).getText();
		float parentUnitPrice1 = transformStringToFloatPrice(parentUnitPrice);
		System.out.println(parentUnitPrice1);
		String parentTotalPrice = driver.findElement(By.xpath(UIMapCheckOut.lblTotalValue)).getText();
		float parentTotalPrice1 = transformStringToFloatPrice(parentTotalPrice);
		System.out.println(parentTotalPrice1);
		System.out.println(driver.findElement(By.xpath(UIMapCheckOut.lblLineUnitPriceValue)).getText());
		String[] s4 = driver.findElement(By.xpath(UIMapCheckOut.lblLineUnitPriceValue)).getText().split("Tax");
		String lineUnitPrice=s4[1];
		System.out.println(s4[0]+":::"+s4[1]);
		float lineUnitPrice1 = transformStringToFloatPrice(lineUnitPrice);
		System.out.println(lineUnitPrice1);
		String[] s5 = driver.findElement(By.xpath(UIMapCheckOut.lblLineTotalValue)).getText().split("Tax");
		String lineTotalPrice = s5[1];
		System.out.println(s5[0]+":::"+s5[1]);
		float lineTotalPrice1 = transformStringToFloatPrice(lineTotalPrice);
		System.out.println(lineTotalPrice1);
		if((parentTotalPrice1 == (Qty*parentUnitPrice1)) && (lineTotalPrice1 == (Qty*lineUnitPrice1)))
		{
			report.updateTestLog("Verifying the Total Price for Parent and Line items after changing quantity","Total Price for Parent and Line items are correctly reflected", Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying the Total Price for Parent and Line items after changing quantity","Total Price for Parent and Line items are not correctly reflected", Status.FAIL);
		}
		co.providecheckOutOrderAsNewUserDetails();
		ch.provideShippingInformation();
		ch.checkoutFromShippingInformation();
		ch.checkoutFromProductDestination();
	    ClickCustomize("xpath",UIMapCheckOut.lnkReturnToCart);
	    selenium.waitForPageToLoad("20000");
	    Thread.sleep(1000);
		driver.findElement(By.xpath(UIMapCheckOut.txtParentQuantityInCart)).clear();
		driver.findElement(By.xpath(UIMapCheckOut.txtParentQuantityInCart)).sendKeys("1");
	    ClickCustomize("xpath",UIMapCheckOut.btnQtyUpdate);
	    selenium.waitForPageToLoad("20000");
	    Thread.sleep(1000);
		}
		else
		{
			report.updateTestLog("Verifying the Special Tax for this item","Special Tax is not displayed", Status.FAIL);
		}
	}
	public void giveDeliveryInstructions() throws Exception
	{
		driver.findElement(By.xpath(UIMapCheckOut.txtDeliveryDirections)).sendKeys(dataTable.getData("General_Data", "DeliveryDirections"));
	}
	public void verifySpecialTaxForAnItem() throws Exception
	{
		if(driver.findElement(By.xpath(UIMapCheckOut.lblSpecialTax)).getText().contains("Special Fees"))
		{
			report.updateTestLog("Verifying the Special Tax for this item","Special Tax is displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying the Special Tax for this item","Special Tax is not displayed", Status.FAIL);
		}
	}
	public void enterQtyInCart() throws Exception
	{
		driver.findElement(By.xpath(UIMapCheckOut.txtParentQuantityInCart)).clear();
		driver.findElement(By.xpath(UIMapCheckOut.txtParentQuantityInCart)).sendKeys(dataTable.getData("General_Data", "Qty"));
		ClickCustomize("xpath",UIMapCheckOut.btnQtyUpdate);
	    selenium.waitForPageToLoad("20000");
	    Thread.sleep(1000);
	       
	}
	public void removeUnavailableItem() throws Exception
	{
		try{
			String varErrorMsg=driver.findElement(By.xpath(UIMapCheckOut.lblUnavailableErrorMsg)).getText();
			String varQty="1";
			String varItemName=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[1]/a")).getText();
			String varErrorExpected="Your quantity of "+varQty+" "+varItemName+" is unavailable at your selected store.";
			//String varErrorExpected="Quantity for the item "+dataTable.getData("General_Data", "ItemNbr")+" cannot be fulfilled at this time.";
			System.out.println(varErrorMsg);
			System.out.println(varErrorExpected);
			if(varErrorMsg.trim().equalsIgnoreCase(varErrorExpected))
			{
				report.updateTestLog("Checking Unavailable Error in Cart","Unavailable error Message correctly displayed in Cart",Status.PASS);
				
				
			}
			else
				report.updateTestLog("Checking Unavailable Error in Cart","Unavailable error Message NOT correctly displayed in Cart",Status.FAIL);
			
			}
				
			catch(Exception NoSuchElementException)
			{
				report.updateTestLog("Checking Unavailable Error in Cart","Unavailable error Message NOT displayed in Cart",Status.FAIL);
			}
		ClickCustomize("xpath","//div[2]/p/a");
		if(driver.findElement(By.xpath(UIMapCheckOut.availablityPopover)).isDisplayed())
		{
			report.updateTestLog("Verifying the Availability Popover","Availability Popover is displayed", Status.PASS);
		    ClickCustomize("xpath",UIMapCheckOut.cancelAvailabilityPopover);
		    driver.findElement(By.xpath("//div[5]/div/div[2]/div[3]/a")).click();
		    selenium.waitForPageToLoad("20000");
		    Thread.sleep(1000);
		    if(!(selenium.isTextPresent("Not available at this store.")))
		    report.updateTestLog("Verifying whether unavailable item is removed","unavailable item is removed", Status.PASS); 
		    else
		    report.updateTestLog("Verifying whether unavailable item is removed","unavailable item is not removed", Status.FAIL); 	
		}
		else
		{
		  report.updateTestLog("Verifying the Availability Popover","Availability Popover is not displayed", Status.FAIL);
		}
	}
	
	public void editGiftCardLayerInCart() throws Exception
	{
		ClickCustomize("name",UIMapCheckOut.txtGCToCart);

		driver.findElement(By.name(UIMapCheckOut.txtGCToCart)).sendKeys(dataTable.getData("General_Data", "GCTo"));

		driver.findElement(By.name(UIMapCheckOut.txtGCFromCart)).sendKeys(dataTable.getData("General_Data", "GCFrom"));

		driver.findElement(By.name(UIMapCheckOut.txtGCMsgCart)).sendKeys(dataTable.getData("General_Data", "GCMessage"));

		ClickCustomize("xpath",UIMapCheckOut.btnGCSave);

		selenium.waitForPageToLoad("20000");

		Thread.sleep(1000);
	}
	public void validateGiftCardDetailsInCart() throws Exception
	{
		if((driver.findElement(By.xpath(UIMapCheckOut.lblDel2Charges)).getText().contains("Estimated Sales Tax"))
			&& (driver.findElement(By.xpath(UIMapCheckOut.lblEstSalesTax1DeliverySelected)).getText().contains("$0.00")))	
		{
			report.updateTestLog("Verifying the Estimated Sales Tax value","Estimated Sales Tax value is $0.00", Status.PASS);
		}
		else
			report.updateTestLog("Verifying the Estimated Sales Tax value","Estimated Sales Tax value is not $0.00", Status.FAIL);
	    
		driver.findElement(By.xpath(UIMapCheckOut.txtGCUnitPrice)).clear();
		driver.findElement(By.xpath(UIMapCheckOut.txtGCUnitPrice)).sendKeys(dataTable.getData("General_Data", "GCAmount"));
		try{driver.findElement(By.xpath(UIMapCheckOut.txtGCUnitPrice)).sendKeys(Keys.ENTER);}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapCheckOut.txtGCUnitPrice)).sendKeys(Keys.ENTER);}
		selenium.waitForPageToLoad("20000");
	    Thread.sleep(1000);
	}
	public void verifyLCCbanner() throws Exception
	{
		if(driver.findElement(By.id(UIMapCheckOut.lccBanner)).isDisplayed())
		{
			driver.findElement(By.id(UIMapCheckOut.rdoBtnLCCPercentOff)).click();
			selenium.waitForPageToLoad("20000");
		}
		else
			System.out.println("LCC Banner is not displayed");
	}
	public void verifyItemLevelPromotion() throws Exception
	{
		try
		{
			driver.findElement(By.xpath(UIMapCheckOut.lnkRemove)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(3000);	
			driver.findElement(By.id(UIMapCheckOut.txtPromoCode)).sendKeys(dataTable.getData("General_Data","PromoCode"));
			ClickCustomize("xpath",UIMapCheckOut.btnPromoCodeApply);
			selenium.waitForPageToLoad("20000");
			Thread.sleep(3000);
		}
		catch(Exception e){
			driver.findElement(By.id(UIMapCheckOut.txtPromoCode)).sendKeys(dataTable.getData("General_Data","PromoCode"));
			ClickCustomize("xpath",UIMapCheckOut.btnPromoCodeApply);
			selenium.waitForPageToLoad("20000");
			Thread.sleep(3000);			
		}
		if(!(driver.findElement(By.xpath(UIMapCheckOut.lnkRemove)).isDisplayed()))
		{
			report.updateTestLog("Verifying the Promotion","Promotion not applied correctly", Status.FAIL);
		}
		if(driver.findElement(By.xpath(UIMapCheckOut.lblLD)).isDisplayed()
		   &&
		   driver.findElement(By.xpath(UIMapCheckOut.lblSD)).isDisplayed()
		   &&
		   driver.findElement(By.xpath(UIMapCheckOut.lblPromoDiscountTotal)).isDisplayed())
		{
			report.updateTestLog("Verifying SD,LD and Discount","SD,LD and Discount are present",Status.PASS);
			String s = driver.findElement(By.xpath(UIMapCheckOut.lblTotalValue)).getText();
			float f = transformStringToFloatPrice(s);
			String s1 = driver.findElement(By.xpath(UIMapCheckOut.lblPromoDiscountTotal)).getText();
			String d = s1.replace("-","");
			float f1 = transformStringToFloatPrice(d);
			String s2 = driver.findElement(By.xpath(UIMapCheckOut.lblCartSubtotal)).getText();
			float f2 = transformStringToFloatPrice(s2);
			if(f2 == (f-f1))
				report.updateTestLog("Verifying Subtotal","Subtotal is correct",Status.PASS);
			else
				report.updateTestLog("Verifying Subtotal","Subtotal is not correct",Status.FAIL);
		}
		else
			report.updateTestLog("Verifying SD,LD and Discount","SD,LD and Discount are not present",Status.FAIL);
	}
	public void verifyYouSaveAmount() throws Exception
	{
		try
		{
			driver.findElement(By.xpath(UIMapCheckOut.lnkRemove)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(3000);	
			driver.findElement(By.id(UIMapCheckOut.txtPromoCode)).sendKeys(dataTable.getData("General_Data","PromoCode"));
			ClickCustomize("xpath",UIMapCheckOut.btnPromoCodeApply);
			selenium.waitForPageToLoad("20000");
			Thread.sleep(3000);
		}
		catch(Exception e){
			driver.findElement(By.id(UIMapCheckOut.txtPromoCode)).sendKeys(dataTable.getData("General_Data","PromoCode"));
			ClickCustomize("xpath",UIMapCheckOut.btnPromoCodeApply);
			selenium.waitForPageToLoad("20000");
			Thread.sleep(3000);			
		}
		if(!(driver.findElement(By.xpath(UIMapCheckOut.lnkRemove)).isDisplayed()))
		{
			report.updateTestLog("Verifying the Promotion","Promotion not applied correctly", Status.FAIL);
		}
		String promodiscount = driver.findElement(By.xpath(UIMapCheckOut.lblPromoDiscountTotal)).getText();
		String d = promodiscount.replace("-","");
		float promodiscountAmnt = transformStringToFloatPrice(d);
		System.out.println("promodiscountAmnt"+promodiscountAmnt);
		String EmpAndRetlPriceWithSavings = driver.findElement(By.xpath(UIMapCheckOut.lblEmpAndRetlPriceWithSavings)).getText();
		String EmpPrice = driver.findElement(By.xpath(UIMapCheckOut.lblEmpPrice)).getText();
		String EmpSavings = driver.findElement(By.xpath(UIMapCheckOut.lblEmpSavings)).getText();
		String youSaveAmnt = driver.findElement(By.xpath(UIMapCheckOut.lblCartSummaryYouSaveAmt)).getText();
		String s = EmpAndRetlPriceWithSavings.replace(EmpPrice,"");
		String s1 = s.replace(EmpSavings,"");
		String s2 = s1.replace("Retail: ","");
		float retailPrice = transformStringToFloatPrice(s2);
		System.out.println("retailPrice"+retailPrice);
		float employeePrice = transformStringToFloatPrice(EmpPrice);
		System.out.println("employeePrice"+employeePrice);
		float youSaveAmount = transformStringToFloatPrice(youSaveAmnt); 
		System.out.println("youSaveAmount"+youSaveAmount);
		String employeeSavingsPercentage = EmpSavings.replace("% Employee Savings","");
		int savings = Integer.parseInt(employeeSavingsPercentage);
		float retailMinusEmpPrice = retailPrice - employeePrice;
		float retailSavingsValue = ((retailPrice*savings)/100);
		System.out.println(retailMinusEmpPrice);
		System.out.println(retailSavingsValue);
		
			if(youSaveAmount == (retailSavingsValue+promodiscountAmnt))
			{
				report.updateTestLog("Verifying You Save amount","You Save amount is correctly calculated",Status.PASS);
			}
			else
			{
				report.updateTestLog("Verifying You Save amount","You Save amount is incorrect",Status.FAIL);
			}	
		driver.findElement(By.xpath(UIMapCheckOut.lblCartSummaryYouSaveHelp)).click();
		if(driver.findElement(By.xpath(UIMapCheckOut.lblYouSavePopupTxt)).getText().equals(dataTable.getData("General_Data", "YouSaveText")))
			report.updateTestLog("Verifying You Save Text","You Save Text is correct",Status.PASS);
		else
			report.updateTestLog("Verifying You Save Text","You Save Text is incorrect",Status.FAIL);
	}
	/****This function validates Lead Times for item with all 3 delivery methods available*****/
	public void checkLeadTimeMessageCart() throws Exception
	{
	//check enabled
	int varCount=ps.countWebElement("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[2]/ul/li");
	int i=0;
	for(i=1;i<=varCount;i++)
	{
	String varClass=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[2]/ul/li["+i+"]")).getAttribute("class");
	if(varClass.contains("enabled"))
	continue;
	else
	break;
	}
	if(i<=3)
	report.updateTestLog("Checking Whether All Delivery Methods enabled", "All delivery Methods Not Enabled", Status.FAIL);
	else
	report.updateTestLog("Checking Whether All Delivery Methods enabled", "All delivery Methods Enabled", Status.PASS);
	//Check Store Pickup Lead Time message
	String varStorePickupLeadTime=driver.findElement(By.xpath(UIMapCheckOut.lblStorePickUpLeadTime)).getText();
	System.out.println(varStorePickupLeadTime);
	String pattern="Store Pickup"+'\n'+"Your order will be available for pickup by (\\d+/\\d+/\\d+).";
	Pattern r = Pattern.compile(pattern);
	Matcher m = r.matcher(varStorePickupLeadTime);
	if(m.find())
	{
	report.updateTestLog("Checking Store Pickup Lead Time", "Store Pickup Lead Time Correctly displayed", Status.PASS);
    dataTable.putData("General_Data","LeadTime",m.group(1));
	}
	else
	report.updateTestLog("Checking Store Pickup Lead Time", "Store Pickup Lead Time NOT Correctly displayed", Status.FAIL);
	//Check LTD Lead Time message
	String varLTDLeadTime=driver.findElement(By.xpath(UIMapCheckOut.lblLTDLeadTime)).getText();
	System.out.println(varLTDLeadTime);
	pattern="Lowe's Truck Delivery"+'\n'+"You'll be contacted within 24 hours of (\\d+/\\d+/\\d+) to arrange your delivery.";
	r = Pattern.compile(pattern);
	m = r.matcher(varLTDLeadTime);
	if(m.find())
	{
	     report.updateTestLog("Checking LTD Lead Time", "LTD Lead Time Correctly displayed", Status.PASS);
	     dataTable.putData("General_Data","LeadTime",m.group(1));
	}
	else
	report.updateTestLog("Checking LTD Lead Time", "LTD Lead Time NOT Correctly displayed", Status.FAIL);
	//Check Parcel Lead Time message
	String varParcelLeadTime=driver.findElement(By.xpath(UIMapCheckOut.lblParcelLeadTime)).getText();
	System.out.println(varParcelLeadTime);
	pattern="FREE"+'\n'+"Parcel Shipping";
	r = Pattern.compile(pattern);
	m = r.matcher(varParcelLeadTime);
	if(m.find())
	report.updateTestLog("Checking Parcel Shipping Lead Time", "Parcel Shipping Lead Time Correctly displayed", Status.PASS);
	else
	report.updateTestLog("Checking Parcel Shipping Lead Time", "Parcel Shipping Lead Time NOT Correctly displayed", Status.FAIL);
	}
	/****This function validates No Lead Time message for item with all 3 delivery methods available*****/
	public void checkNoLeadTimeMessageCart() throws Exception
	{
	//check enabled
	int varCount=ps.countWebElement("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[2]/ul/li");
	int i=0;
	for(i=1;i<=varCount;i++)
	{
	String varClass=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[2]/ul/li["+i+"]")).getAttribute("class");
	if(varClass.contains("enabled"))
	continue;
	else
	break;
	}
	if(i<=3)
	report.updateTestLog("Checking Whether All Delivery Methods enabled", "All delivery Methods Not Enabled", Status.FAIL);
	else
	report.updateTestLog("Checking Whether All Delivery Methods enabled", "All delivery Methods Enabled", Status.PASS);
	//Check Store Pickup Lead Time message
	String varStorePickupNoLeadTime=driver.findElement(By.xpath(UIMapCheckOut.lblStorePickUpLeadTime)).getText();
	System.out.println(varStorePickupNoLeadTime);
	String pattern="Store Pickup"+'\n'+"Your item is available for pickup today.";
	Pattern r = Pattern.compile(pattern);
	Matcher m = r.matcher(varStorePickupNoLeadTime);
	if(m.find())
	{
	report.updateTestLog("Checking Store Pickup No Lead Time Message", "Store Pickup No Lead Time Message Correctly displayed", Status.PASS);
	}
	else
	report.updateTestLog("Checking Store Pickup No Lead Time Message", "Store Pickup No Lead Time Message NOT Correctly displayed", Status.FAIL);
	//Check LTD Lead Time message
	String varLTDNoLeadTime=driver.findElement(By.xpath(UIMapCheckOut.lblLTDLeadTime)).getText();
	System.out.println(varLTDNoLeadTime);
	pattern="Lowe's Truck Delivery"+'\n'+"You'll be contacted within 24 hours to arrange your delivery.";
	r = Pattern.compile(pattern);
	m = r.matcher(varLTDNoLeadTime);
	if(m.find())
	{
	     report.updateTestLog("Checking LTD No Lead Time Message", "LTD No Lead Time Message Correctly displayed", Status.PASS);
	}
	else
	report.updateTestLog("Checking LTD No Lead Time Message", "LTD No Lead Time Message NOT Correctly displayed", Status.FAIL);
	//Check Parcel Lead Time message
	String varParcelNoLeadTime=driver.findElement(By.xpath(UIMapCheckOut.lblParcelLeadTime)).getText();
	System.out.println(varParcelNoLeadTime);
	pattern="Parcel Shipping"+'\n'+"Sent by carriers like UPS, FedEx, USPS, etc.";
	r = Pattern.compile(pattern);
	m = r.matcher(varParcelNoLeadTime);
	System.out.println(varParcelNoLeadTime);
	System.out.println(r);
	if(m.find())
	report.updateTestLog("Checking Parcel Shipping No Lead Time Message", "Parcel Shipping No Lead Time Message Correctly displayed", Status.PASS);
	else
	report.updateTestLog("Checking Parcel Shipping No Lead Time Message", "Parcel Shipping No Lead Time Message NOT Correctly displayed", Status.FAIL);
	}

public void leadTimeMessageinReviewPay() throws Exception
{
	String varStorePickupLeadTime=driver.findElement(By.xpath(UIMapCheckOut.lblLeadTimeinReviewPay)).getText();
	System.out.println(varStorePickupLeadTime);
	String pattern="If Ordered Today, Ships to Store by (\\d+/\\d+/\\d+).";
	Pattern r = Pattern.compile(pattern);
	Matcher m = r.matcher(varStorePickupLeadTime);
	if(m.find())
	{
		report.updateTestLog("Checking Store Pickup Lead Time", "Store Pickup Lead Time Correctly displayed", Status.PASS);
	    dataTable.putData("General_Data","LeadTime",m.group(1));
	    Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println(sdf.format(date));
	    if(sdf.format(date).equals(m.group(1)))
	    	report.updateTestLog("Verifying whether date is Today's Date or not","date is Today's Date", Status.PASS);
	    else
	    	report.updateTestLog("Verifying whether date is Today's Date or not","date is not Today's Date", Status.FAIL);
	}
	else
		report.updateTestLog("Checking Store Pickup Lead Time", "Store Pickup Lead Time incorrectly displayed", Status.FAIL);
}
	
public void verifyLeadTimeinOC() throws Exception
{
	String EstArrivalDate = driver.findElement(By.xpath(UIMapCheckOut.lblEstArrivalDateValue)).getText();
	if(EstArrivalDate.equals(dataTable.getData("General_Data","LeadTime")))
		report.updateTestLog("Verifying the lead time in Order confirmation page", "Lead time is correctly displayed as in cart page", Status.PASS);
	else
		report.updateTestLog("Verifying the lead time in Order confirmation page", "Lead time is not correctly displayed as in cart page", Status.FAIL);
}
public void verifyNoLeadTimeMessageInOC() throws Exception
{
	String varStorePickupNoLeadTime=driver.findElement(By.xpath(UIMapCheckOut.lblNoLeadTimeInOC)).getText();
	System.out.println(varStorePickupNoLeadTime);
	String pattern="Estimated Pickup Date:"+'\n'+"Available today*";
	Pattern r = Pattern.compile(pattern);
	Matcher m = r.matcher(varStorePickupNoLeadTime);
	if(m.find())
	report.updateTestLog("Verify lead time in Order confirmation page","No lead time displayed on order confirmation page", Status.PASS);
	else
    report.updateTestLog("Verify lead time in Order confirmation page","lead time displayed on order confirmation page is incorrect", Status.FAIL);
}
public void validateDeliveryDetails() throws Exception
{
	String varOrderNbrDisplayed=driver.findElement(By.cssSelector(UIMapCheckOut.lblOrderNbr)).getText();
	dataTable.putData("General_Data","OrderNbr",varOrderNbrDisplayed);	
	driver.findElement(By.xpath(UIMapMyLowes.lnkMylowesLandingPage)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(3000);
		driver.findElement(By.xpath(UIMapMyLowes.lblPurchases)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(3000);
    driver.findElement(By.xpath(UIMapCheckOut.lblAddPurchases)).click();
    Thread.sleep(3000);
    driver.findElement(By.id(UIMapMyLowes.txtConfNo)).clear();
    driver.findElement(By.id(UIMapMyLowes.txtConfNo)).sendKeys(dataTable.getData("General_Data","OrderNbr"));
    driver.findElement(By.cssSelector(UIMapMyLowes.btnAddPurchase)).click();
    Thread.sleep(6000);
    driver.findElement(By.xpath(UIMapMyLowes.lnkViewDelDetails)).click();
    Thread.sleep(6000);
    String ExpecteddelDetails = "A Lowe's representative will call within 24 hours of purchase to schedule your delivery. If you don't receive a call after 24 hours, please call Customer Care at 1-800-44-LOWES Monday through Saturday, 7 a.m. to 1 a.m. (ET) and Sunday, 10 a.m. to 9 p.m. (ET).";
    String actualdelDetails = driver.findElement(By.xpath(UIMapMyLowes.txtDelDetails)).getText();
    if(ExpecteddelDetails.equals(actualdelDetails))
    	report.updateTestLog("Verifying Delivery Details in order detail page from Purchase page","Delivery details correctly displayed", Status.PASS);
    else
    	report.updateTestLog("Verifying Delivery Details in order detail page from Purchase page","Delivery details incorrectly displayed", Status.FAIL);
}
public void impulseBuyPopoverNoThanks() throws Exception
{
driver.findElement(By.xpath(UIMapMyLowes.btnShopCart)).click();
Thread.sleep(3000);
verifyImpulseBuy();
// driver.findElement(By.xpath(UIMapCheckOut.impulseBuyNoThankslink)).click();
driver.findElement(By.linkText("No Thanks")).click();
selenium.waitForPageToLoad("20000");
Thread.sleep(6000);
if(selenium.getTitle().contains("Lowe's: Sign In"))
report.updateTestLog("Clicking secure checkOut","Lowes sign In page displayed",Status.PASS);
else
report.updateTestLog("Clicking secure checkOut","Lowes sign In page NOT displayed",Status.FAIL);
}
 
 
public void verifyImpulseBuy() throws Exception
{
String varItemName=driver.findElement(By.xpath(UIMapCheckOut.lblImpulseBuyItemName)).getText();
if(!varItemName.isEmpty())
report.updateTestLog("Checking Impulse Buy Popover", "Item Displayed in Impulse Buy Popover", Status.PASS);
else
report.updateTestLog("Checking Impulse Buy Popover", "Item NOT Displayed in Impulse Buy Popover", Status.FAIL);
if(driver.findElement(By.id(UIMapCheckOut.webElmntDelMethodsBuyImpulse)).isDisplayed())
report.updateTestLog("Checking Impulse Buy Popover", "Delivery Methods Displayed in Impulse Buy Popover", Status.PASS);
else
report.updateTestLog("Checking Impulse Buy Popover", "Delivery Methods NOT Displayed in Impulse Buy Popover", Status.FAIL);
String varAddToCart=driver.findElement(By.xpath(UIMapCheckOut.btnAddToCartBuyImpulse)).getText();
System.out.println("Add To Cart Button:"+varAddToCart);
if(varAddToCart.trim().contains("Add to Cart"))
report.updateTestLog("Checking Impulse Buy Popover", "Add To Cart Button Displayed in Impulse Buy Popover", Status.PASS);
else
report.updateTestLog("Checking Impulse Buy Popover", "Add To Cart Button NOT Displayed in Impulse Buy Popover", Status.FAIL);
String varNoThanks=driver.findElement(By.id(UIMapCheckOut.lnkNoThanksBuyImpulse)).getText();
if(varNoThanks.trim().equals("No Thanks"))
report.updateTestLog("Checking Impulse Buy Popover", "No Thanks link Displayed in Impulse Buy Popover", Status.PASS);
else
report.updateTestLog("Checking Impulse Buy Popover", "No Thanks link NOT Displayed in Impulse Buy Popover", Status.FAIL);
}
 
/**
* This function validates error messages for Invalid LAR Card details on Review & Pay Page
*/
public void checkErrorOnInvalidLAR() throws Exception
{
driver.findElement(By.name(UIMapMyLowes.txtCardNickName)).clear();
driver.findElement(By.name(UIMapMyLowes.txtCardNickName)).sendKeys(dataTable.getData("General_Data", "nickName"));
////Expiration Fields validation
new Select(driver.findElement(By.id(UIMapMyLowes.drpDownChkOutType))).selectByVisibleText(dataTable.getData("General_Data","cardType"));
Thread.sleep(4000);
String varExpirationClass=driver.findElement(By.id(UIMapCheckOut.webElmntExpirationFields)).getAttribute("class");
System.out.println(varExpirationClass);
if(varExpirationClass.equalsIgnoreCase("hidden"))
report.updateTestLog("Checking Expiry Date Fields", "Expiry Date Fields Not Displayed", Status.PASS);
else
report.updateTestLog("Checking Expiry Date Fields", "Expiry Date Fields Displayed", Status.FAIL);
//Entering invalid Card Number
driver.findElement(By.name(UIMapMyLowes.txtCheckOutCreditCardNo)).clear();
driver.findElement(By.name(UIMapMyLowes.txtCheckOutCreditCardNo)).sendKeys(dataTable.getData("General_Data", "InvalidCrditCardNo"));
driver.findElement(By.id(UIMapMyLowes.txtSCode)).clear();
driver.findElement(By.id(UIMapMyLowes.txtSCode)).sendKeys(dataTable.getData("General_Data", "security code"));
co.completeOrderByPrimaryAddress();
//click checkout button
driver.findElement(By.xpath(UIMapMyLowes.btnSecureCheckOut)).click();
selenium.waitForPageToLoad("120000");
Thread.sleep(2000);
//validate error message
String varError=driver.findElement(By.xpath(UIMapCheckOut.lblRevPayError)).getText();
if(varError.contains("An invalid credit card number was entered."))
report.updateTestLog("Entering Invalid Card Number", "Correct Error Message displayed", Status.PASS);
else
report.updateTestLog("Entering Invalid Card Number", "Correct Error Message NOT displayed", Status.FAIL);
//Entering Text in Card Number
driver.findElement(By.name(UIMapMyLowes.txtCardNickName)).clear();
driver.findElement(By.name(UIMapMyLowes.txtCardNickName)).sendKeys(dataTable.getData("General_Data", "nickName"));
new Select(driver.findElement(By.id(UIMapMyLowes.drpDownChkOutType))).selectByVisibleText(dataTable.getData("General_Data","cardType"));
Thread.sleep(4000);
driver.findElement(By.name(UIMapMyLowes.txtCheckOutCreditCardNo)).clear();
driver.findElement(By.name(UIMapMyLowes.txtCheckOutCreditCardNo)).sendKeys("test");
driver.findElement(By.id(UIMapMyLowes.txtSCode)).clear();
driver.findElement(By.id(UIMapMyLowes.txtSCode)).sendKeys(dataTable.getData("General_Data", "security code"));
co.completeOrderByPrimaryAddress();
//click checkout button
driver.findElement(By.xpath(UIMapMyLowes.btnSecureCheckOut)).click();
selenium.waitForPageToLoad("120000");
Thread.sleep(2000);
//validate error message
varError=driver.findElement(By.xpath(UIMapCheckOut.lblRevPayError)).getText();
if(varError.contains("Please enter digits only. Card number."))
report.updateTestLog("Entering Text in Card Number", "Correct Error Message displayed", Status.PASS);
else
report.updateTestLog("Entering Text in Card Number", "Correct Error Message NOT displayed", Status.FAIL);
//Entering Text in Security Code
driver.findElement(By.name(UIMapMyLowes.txtCardNickName)).clear();
driver.findElement(By.name(UIMapMyLowes.txtCardNickName)).sendKeys(dataTable.getData("General_Data", "nickName"));
new Select(driver.findElement(By.id(UIMapMyLowes.drpDownChkOutType))).selectByVisibleText(dataTable.getData("General_Data","cardType"));
Thread.sleep(4000);
driver.findElement(By.name(UIMapMyLowes.txtCheckOutCreditCardNo)).clear();
driver.findElement(By.name(UIMapMyLowes.txtCheckOutCreditCardNo)).sendKeys(dataTable.getData("General_Data", "crditCardNo"));
driver.findElement(By.id(UIMapMyLowes.txtSCode)).clear();
driver.findElement(By.id(UIMapMyLowes.txtSCode)).sendKeys("test");
co.completeOrderByPrimaryAddress();
//click checkout button
driver.findElement(By.xpath(UIMapMyLowes.btnSecureCheckOut)).click();
selenium.waitForPageToLoad("120000");
Thread.sleep(2000);
//validate error message
varError=driver.findElement(By.xpath(UIMapCheckOut.lblRevPayError)).getText();
if(varError.contains("Please enter digits only. Security Code."))
report.updateTestLog("Entering Text in Security Code", "Correct Error Message displayed", Status.PASS);
else
report.updateTestLog("Entering Text in Security Code", "Correct Error Message NOT displayed", Status.FAIL);
}
 
/***
* This function validates whether Error message is displayed when GC Card appiled has amount less than purchase total
*/
public void checkErrorGCAmtLessThanOrderTotal() throws Exception
{
co.enterGiftCardDetails();
//check Balance Due displayed
String varBalanceDue=driver.findElement(By.id(UIMapCheckOut.lblBalanceDueAfterGC)).getText();
String varBalance=null;
if(varBalanceDue.length()>7)
{
String s1[]=varBalanceDue.split(",");
String s2=s1[0].substring(1,s1[0].length());
varBalance=s2.concat(s1[1]);
}
else
{
varBalance=varBalanceDue.substring(1);
}
double varBalancedbl=Double.valueOf(varBalance);
System.out.println(varBalancedbl);
if(varBalancedbl>(0.00))
report.updateTestLog("Checking Balance Due", "Balance Due > $0.00 displayed", Status.PASS);
else
report.updateTestLog("Checking Balance Due", "Balance Due > $0.00 NOT displayed", Status.FAIL);
co.completeOrderByPrimaryAddress();
driver.findElement(By.xpath(UIMapMyLowes.btnSecureCheckOut)).click();
selenium.waitForPageToLoad("120000");
Thread.sleep(2000);
//validate error message
String varError=driver.findElement(By.xpath(UIMapCheckOut.lblRevPayError)).getText();
if(varError.contains("The gift card number you entered has insufficient funds."))
report.updateTestLog("Applying Gift Card having amount less than Order Total", "Correct Error Message displayed", Status.PASS);
else
report.updateTestLog("Applying Gift Card having amount less than Order Total", "Correct Error Message NOT displayed", Status.FAIL);
}
 
/***
* This function validates whether Correct error messages are displayed for Invalid Credit Card Details
*/
public void checkErrorMsgInvalidCreditCardDetails() throws Exception
{
//Credit Card details without Expiry Date
try{driver.findElement(By.name(UIMapMyLowes.txtCardNickName)).clear();
driver.findElement(By.name(UIMapMyLowes.txtCardNickName)).sendKeys(dataTable.getData("General_Data", "nickName"));
}
catch(Exception e){
System.out.println("Card NickName Not Displayed");
}
new Select(driver.findElement(By.id(UIMapMyLowes.drpDownChkOutType))).selectByVisibleText(dataTable.getData("General_Data","cardType"));
driver.findElement(By.name(UIMapMyLowes.txtCheckOutCreditCardNo)).clear();
driver.findElement(By.name(UIMapMyLowes.txtCheckOutCreditCardNo)).sendKeys(dataTable.getData("General_Data", "crditCardNo"));
driver.findElement(By.id(UIMapMyLowes.txtSCode)).clear();
driver.findElement(By.id(UIMapMyLowes.txtSCode)).sendKeys(dataTable.getData("General_Data", "security code"));
co.completeOrderByPrimaryAddress();
driver.findElement(By.xpath(UIMapMyLowes.btnSecureCheckOut)).click();
selenium.waitForPageToLoad("120000");
Thread.sleep(2000);
//validate error message
String varError=driver.findElement(By.xpath(UIMapCheckOut.lblRevPayError)).getText();
if(varError.contains("The credit card expiration Date is invalid."))
report.updateTestLog("Entering Credit Card Details without Expiry Date", "Correct Error Message displayed", Status.PASS);
else
report.updateTestLog("Entering Credit Card Details without Expiry Date", "Correct Error Message NOT displayed", Status.FAIL);
//validate Credit Card Nbr, Security Code and Expiry Date Fields
String varCardNbr=driver.findElement(By.xpath(UIMapCheckOut.txtCardNbr)).getAttribute("value");
if(varCardNbr.isEmpty())
report.updateTestLog("Checking Card Number field after no Expiry Date", "Card Number field displayed Blank", Status.PASS);
else
report.updateTestLog("Checking Card Number field after no Expiry Date", "Card Number field NOT displayed Blank:"+varCardNbr, Status.FAIL);
if(driver.findElement(By.id(UIMapMyLowes.txtSCode)).getAttribute("value").isEmpty())
report.updateTestLog("Checking Security Code field after no Expiry Date", "Security Code field displayed Blank", Status.PASS);
else
report.updateTestLog("Checking Security Code field after no Expiry Date", "Security Code field NOT displayed Blank:"+varCardNbr, Status.FAIL);
String varMonthSelected=driver.findElement(By.xpath(UIMapCheckOut.drpDownExpMonth+"/option[1]")).getAttribute("selected");
if(varMonthSelected.equals("true"))
report.updateTestLog("Checking Expiry Month field after no Expiry Date", "Expiry Month field displayed as Default", Status.PASS);
else
report.updateTestLog("Checking Expiry Month field after no Expiry Date", "Expiry Month field NOT displayed as Default:"+varMonthSelected, Status.FAIL);
String varYrSelected=driver.findElement(By.xpath(UIMapCheckOut.drpDownExpYear+"/option[1]")).getAttribute("selected");
if(varYrSelected.equals("true"))
report.updateTestLog("Checking Expiry Year field after no Expiry Date", "Expiry Year field displayed as Default", Status.PASS);
else
report.updateTestLog("Checking Expiry Year field after no Expiry Date", "Expiry Year field NOT displayed as Default:"+varYrSelected, Status.FAIL);
//Credit Card Details with Invalid Credit Card Nbr
String invalidCreditCardNbr=dataTable.getData("General_Data", "InvalidCrditCardNo");
dataTable.putData("General_Data", "crditCardNo", invalidCreditCardNbr);
co.checkOutUsingMasterCreditCard();
co.completeOrderByPrimaryAddress();
driver.findElement(By.xpath(UIMapMyLowes.btnSecureCheckOut)).click();
selenium.waitForPageToLoad("120000");
Thread.sleep(2000);
//validate error message
varError=driver.findElement(By.xpath(UIMapCheckOut.lblRevPayError)).getText();
System.out.println(varError);
if(varError.contains("An invalid credit card number was entered. For security purposes, please re-enter your payment information. For further assistance, contact Lowe's Customer Care at 1-800-890-5932 and reference error code -9."))
report.updateTestLog("Entering Credit Card Details with Invalid Credit Card Nbr", "Correct Error Message displayed", Status.PASS);
else
report.updateTestLog("Entering Credit Card Details with Invalid Credit Card Nbr", "Correct Error Message NOT displayed", Status.FAIL);
//validate Credit Card Nbr, Security Code and Expiry Date Fields
varCardNbr=driver.findElement(By.xpath(UIMapCheckOut.txtCardNbr)).getAttribute("value");
if(varCardNbr.isEmpty())
report.updateTestLog("Checking Card Number field after no Expiry Date", "Card Number field displayed Blank", Status.PASS);
else
report.updateTestLog("Checking Card Number field after no Expiry Date", "Card Number field NOT displayed Blank:"+varCardNbr, Status.FAIL);
if(driver.findElement(By.id(UIMapMyLowes.txtSCode)).getAttribute("value").isEmpty())
report.updateTestLog("Checking Security Code field after no Expiry Date", "Security Code field displayed Blank", Status.PASS);
else
report.updateTestLog("Checking Security Code field after no Expiry Date", "Security Code field NOT displayed Blank:"+driver.findElement(By.id(UIMapMyLowes.txtSCode)).getAttribute("value"), Status.FAIL);
for(int i=1;i<=12;i++)
{
String varMonth=driver.findElement(By.xpath(UIMapCheckOut.drpDownExpMonth+"/option["+i+"]")).getText();
System.out.println(varMonth);
if(varMonth.equals(dataTable.getData("General_Data", "month")))
{
try{
varMonthSelected=driver.findElement(By.xpath(UIMapCheckOut.drpDownExpMonth+"/option["+i+"]")).getAttribute("selected");
System.out.println("Month Selected:"+varMonthSelected);
if(varMonthSelected.equals("true"))
{
report.updateTestLog("Checking Expiry Month field after Invalid Card Nbr", "Expiry Month field displayed as Entered", Status.PASS);
break;
}
}
catch(Exception e)
{
report.updateTestLog("Checking Expiry Month field after Invalid Card Nbr", "Expiry Month field NOT displayed as Entered", Status.FAIL);
break;
}
}
else
continue;
}
for(int i=1;i<=11;i++)
{
String varYear=driver.findElement(By.xpath(UIMapCheckOut.drpDownExpYear+"/option["+i+"]")).getText();
System.out.println(varYear);
if(varYear.equals(dataTable.getData("General_Data", "year")))
{
try{
varYrSelected=driver.findElement(By.xpath(UIMapCheckOut.drpDownExpYear+"/option["+i+"]")).getAttribute("selected");
System.out.println("Year Selected:"+varYrSelected);
if(varYrSelected.equals("true"))
{
report.updateTestLog("Checking Expiry Year field after Invalid Card Nbr", "Expiry Year field displayed as Entered", Status.PASS);
break;
}
}
catch(Exception e)
{
report.updateTestLog("Checking Expiry Year field after Invalid Card Nbr", "Expiry Year field NOT displayed as Entered", Status.FAIL);
break;
}
}
else
continue;
}
}
/**
* This function validates error messages when shipping radius is >75 miles
*/
public void checkShippingRadius75MilesError() throws Exception
{
co.selectDeliveryOptionCart();
String varTruckDelCharges=driver.findElement(By.xpath(UIMapCheckOut.lblEstDelValue)).getText();
System.out.println(varTruckDelCharges);
co.providecheckOutOrderAsNewUserDetails();
//validate Truck delivery Charges
String varTruckDelCharges2=driver.findElement(By.xpath(UIMapCheckOut.lblTruckDel)).getText();
System.out.println(varTruckDelCharges2);
if(varTruckDelCharges2.equals(varTruckDelCharges))
report.updateTestLog("Checking Truck Delivery Charges", "Truck Delivery Charges same as in Cart Page", Status.PASS);
else
report.updateTestLog("Checking Truck Delivery Charges", "Truck Delivery Charges NOT same as in Cart Page", Status.FAIL);
co.checkOutShippingInfoAddress();
// checkout before USPS
driver.findElement(By.xpath(UIMapMyLowes.btnSecureCheckOut)).click();
selenium.waitForPageToLoad("20000");
Thread.sleep(6000);
// confirm USPS first
boolean uspsContinue = selenium.isTextPresent("Confirm");
if (uspsContinue) {
driver.findElement(By.id(UIMapCheckOut.rdoBtnUSPSEnteredAddress)).click();
Thread.sleep(1000);
driver.findElement(By.xpath(UIMapMyLowes.btnCfrmUSPSAddress))
.click();
}
selenium.waitForPageToLoad("20000");
Thread.sleep(6000);
// validate Error Message & Truck delivery-Not Available on Product Destination Page
String varTruckDel2=driver.findElement(By.xpath(UIMapCheckOut.lblTruckDelNotAvailable)).getText();
System.out.println(varTruckDel2);
if(varTruckDel2.equals("Not Available"))
report.updateTestLog("Checking Truck Delivery Charges on Product destination Page", " Truck Delivery Charges displayed as Not Available", Status.PASS);
else
report.updateTestLog("Checking Truck Delivery Charges on Product destination Page", " Truck Delivery Charges NOT displayed as Not Available", Status.FAIL);
String varError1=driver.findElement(By.xpath(UIMapCheckOut.lblRevPayError)).getText();
System.out.println(varError1);
String varError2=driver.findElement(By.xpath(UIMapCheckOut.lblShippingAddressError)).getText();
System.out.println(varError2);
if(varError1.equals("The address you entered is outside your selected store's delivery range. Please return to Cart and select Store Pickup and see your new purchase total.")
&& (varError2.equals("The address you entered is outside of your selected store's delivery range. Return to Cart to select Store Pickup to complete your purchase.")))
{ 
report.updateTestLog("Checking Error On Product Destination Page", "Error displayed on Product destination Page", Status.PASS);
if(driver.findElement(By.linkText("Return to Cart")).isDisplayed() && driver.findElement(By.linkText("Add New Address")).isDisplayed())
{
report.updateTestLog("Checking Links", "Return to Cart link & Add New Address link displayed", Status.PASS);
driver.findElement(By.linkText("Return to Cart")).click();
selenium.waitForPageToLoad("20000");
//checking Regular Cart Page
String varError3=driver.findElement(By.xpath(UIMapCheckOut.lblUnavailableErrorMsg)).getText();
if(varError3.equals("The address you entered is outside your selected store's delivery range. Your order has been changed to Store Pickup and your purchase total has been updated."))
report.updateTestLog("Checking Error Message in Cart page", "Error Message displayed in Cart page", Status.PASS);
else
report.updateTestLog("Checking Error Message in Cart page", "Error Message NOT displayed in Cart page", Status.FAIL);
dataTable.putData("General_Data", "DeliveryMthd", "PL");
validateDeliveryInCart();
String varDelLabel=driver.findElement(By.xpath(UIMapCheckOut.lblEstDelLabel)).getText();
if(varDelLabel.equals("Estimated Sales Tax"))
report.updateTestLog("Checking Cart Summary", "Cart Summary Updated", Status.PASS);
else
report.updateTestLog("Checking Cart Summary", "Cart Summary NOT Updated", Status.FAIL);
}
else
report.updateTestLog("Checking Links", "Return to Cart link & Add New Address link NOT displayed", Status.FAIL);
}
else
report.updateTestLog("Checking Error On Product Destination Page", "Error NOT displayed on Product destination Page", Status.FAIL);
}
/** this function returns double value from the String amount displayed in application
* 
*/
public double convertToDbl(String varAmt) throws Exception
{
String varAmt2=null;
if(varAmt.length()>7)
{
String s1[]=varAmt.split(",");
String s2=s1[0].substring(1,s1[0].length());
varAmt2=s2.concat(s1[1]);
}
else
{
varAmt2=varAmt.substring(1);
}
double varAmtdbl=Double.valueOf(varAmt2);
return varAmtdbl;
}
/** This function stores total amount on GiftCard and clicks on Cancel on Review & Pay Page
* 
*/
public void storeGCAmt() throws Exception
{
String varGCBalance=driver.findElement(By.xpath(UIMapCheckOut.lblGCBalance)).getText();
System.out.println(varGCBalance);
double varGCBalanceDbl=convertToDbl(varGCBalance);
System.out.println(varGCBalanceDbl);
String varAmtAppliedOnGc=driver.findElement(By.xpath(UIMapCheckOut.lblAmtAppliedonGC)).getText();
System.out.println(varAmtAppliedOnGc);
double varAmtAppliedDbl=convertToDbl(varAmtAppliedOnGc.substring(1));
System.out.println(varAmtAppliedDbl);
Double varTotalAmtInGC=varGCBalanceDbl+varAmtAppliedDbl;
System.out.println(varTotalAmtInGC);
double roundOff = (double) Math.round(varTotalAmtInGC * 100) / 100;
System.out.println("After Round Off:"+roundOff);
String varTotalAmtStr = String.format("%.2f", roundOff);
System.out.println("String Converted:"+varTotalAmtStr);
dataTable.putData("General_Data", "GCBalance", varTotalAmtStr);
driver.findElement(By.linkText("Cancel")).click();
selenium.waitForPageToLoad("20000");
}
/*******
* This function validates whether GC Applied amount, balance due are updated when another item is added
*/
public void checkBalanceDueAfterAddingItemRevPayPg() throws Exception
{
String varOrderTotal=driver.findElement(By.xpath(UIMapCheckOut.lblOrderTotal)).getText();
System.out.println(varOrderTotal);
double varOrderTotalDbl=convertToDbl(varOrderTotal);
System.out.println(varOrderTotalDbl);
double varGCAmt=Double.valueOf(dataTable.getData("General_Data", "GCBalance"));
if(varGCAmt>varOrderTotalDbl)
{
String varAmtApplied=driver.findElement(By.xpath(UIMapCheckOut.lblAmtAppliedonGC)).getText();
System.out.println(varAmtApplied);
if(varAmtApplied.equals("-"+varOrderTotal))
{
report.updateTestLog("Checking Gift Card Total", "Gift Card Total updated correctly", Status.PASS);
}
else
report.updateTestLog("Checking Gift Card Total", "Gift Card Total NOT updated correctly", Status.FAIL);
String varBalanceDue=driver.findElement(By.id(UIMapCheckOut.lblBalanceDueAfterGC)).getText();
System.out.println(varBalanceDue);
if(varBalanceDue.equals("$0.00"))
report.updateTestLog("Checking Balance Due", "Balance Due updated correctly", Status.PASS);
else
report.updateTestLog("Checking Balance Due", "Balance Due NOT updated correctly", Status.FAIL);
double GCBalanceLeft=varGCAmt-varOrderTotalDbl;
double roundOff = (double) Math.round(GCBalanceLeft * 100) / 100;
System.out.println("GC Balance Left After Round Off:"+roundOff);
String varGCBalLeft=String.format("%.2f", roundOff);
String varGCBalExp=null;
if(varGCBalLeft.length()>6)
{
int i = varGCBalLeft.length()-6;
String s1 = varGCBalLeft.substring(0, i);
String s2 = varGCBalLeft.substring(i,varGCBalLeft.length());
varGCBalExp = s1+","+s2;
System.out.println(varGCBalExp);
}
else
{
varGCBalExp = varGCBalLeft;
System.out.println(varGCBalExp);
}
String varGCBalanceDisp=driver.findElement(By.xpath(UIMapCheckOut.lblGCBalance)).getText();
System.out.println(varGCBalanceDisp);
if(varGCBalanceDisp.equals("$"+varGCBalExp))
report.updateTestLog("Checking GC Balance", "GC Balance updated Correctly", Status.PASS);
else
report.updateTestLog("Checking GC Balance", "GC Balance NOT updated Correctly", Status.FAIL);
}
else
{
String varAmtApplied=driver.findElement(By.xpath(UIMapCheckOut.lblAmtAppliedonGC)).getText();
System.out.println(varAmtApplied);
String varGCAmt2=dataTable.getData("General_Data", "GCBalance");
String varGCAmt2exp=null;
if(varGCAmt2.length()>6)
{
int i = varGCAmt2.length()-6;
String s1 = varGCAmt2.substring(0, i);
String s2 = varGCAmt2.substring(i,varGCAmt2.length());
varGCAmt2exp = s1+","+s2;
System.out.println(varGCAmt2exp);
}
else
{
varGCAmt2exp = varGCAmt2;
System.out.println(varGCAmt2exp);
}
if(varAmtApplied.equals("-$"+varGCAmt2exp))
{
report.updateTestLog("Checking Gift Card Total", "Gift Card Total updated correctly", Status.PASS);
}
else
report.updateTestLog("Checking Gift Card Total", "Gift Card Total NOT updated correctly", Status.FAIL);
String varBalanceDue=driver.findElement(By.id(UIMapCheckOut.lblBalanceDueAfterGC)).getText();
System.out.println(varBalanceDue);
double varBalanceDue2=varOrderTotalDbl-varGCAmt;
double roundOff = (double) Math.round(varBalanceDue2 * 100) / 100;
System.out.println("Balance Due After Round Off:"+roundOff);
String vaBalLeft=String.format("%.2f", roundOff);
String vaBalExp=null;
if(vaBalLeft.length()>6)
{
int i = vaBalLeft.length()-6;
String s1 = vaBalLeft.substring(0, i);
String s2 = vaBalLeft.substring(i,vaBalLeft.length());
vaBalExp = s1+","+s2;
System.out.println(vaBalExp);
}
else
{
vaBalExp = vaBalLeft;
System.out.println(vaBalExp);
}
if(varBalanceDue.equals("$"+vaBalExp))
report.updateTestLog("Checking Balance Due", "Balance Due updated correctly", Status.PASS);
else
report.updateTestLog("Checking Balance Due", "Balance Due NOT updated correctly", Status.FAIL);
String varGCBalanceDisp=driver.findElement(By.xpath(UIMapCheckOut.lblGCBalance)).getText();
if(varGCBalanceDisp.equals("$0.00"))
report.updateTestLog("Checking GC Balance", "GC Balance updated Correctly", Status.PASS);
else
report.updateTestLog("Checking GC Balance", "GC Balance NOT updated Correctly", Status.FAIL);
}
}
/**This function validates whether Parcel Shipping delivery method is selected by default for GC***/
public void validateParcelShippingRdoBtnGC() throws Exception
{
try{String varChecked=driver.findElement(By.xpath(UIMapCheckOut.rdoBtnParcelShippingGC)).getAttribute("checked");
if(varChecked.equals("true"))
report.updateTestLog("Checking Parcel Shipping radio Button", "Parcel Shipping radio button selected by default", Status.PASS);
else
report.updateTestLog("Checking Parcel Shipping radio Button", "Parcel Shipping radio button NOT selected by default", Status.FAIL);
}
catch(Exception e)
{
report.updateTestLog("Checking Parcel Shipping radio Button", "Parcel Shipping radio button NOT selected by default", Status.FAIL);
}
}
/**This function enters To, From & Message fields on GC page******/
public void enterGCDetails() throws Exception
{
driver.findElement(By.id(UIMapCheckOut.txtGCTo1)).click();
driver.findElement(By.id(UIMapCheckOut.txtGCTo1)).clear();
driver.findElement(By.id(UIMapCheckOut.txtGCTo1)).sendKeys("Testto");
driver.findElement(By.id(UIMapCheckOut.txtGCFrom1)).click();
driver.findElement(By.id(UIMapCheckOut.txtGCFrom1)).clear();
driver.findElement(By.id(UIMapCheckOut.txtGCFrom1)).sendKeys("Testfrom");
driver.findElement(By.id(UIMapCheckOut.txtGCMsg1)).click();
driver.findElement(By.id(UIMapCheckOut.txtGCMsg1)).clear();
driver.findElement(By.id(UIMapCheckOut.txtGCMsg1)).sendKeys("Test");
}
/***This function clicks on Add new Address on Product Destination page and adds new Address***/
public void addNewAddressProductDestination() throws Exception
{
driver.findElement(By.linkText("Add New Address")).click();
Thread.sleep(2000);
//entering address
driver.findElement(By.name(UIMapCheckOut.txtAddressNickNamee)).clear();
driver.findElement(By.name(UIMapCheckOut.txtAddressNickNamee)).sendKeys(dataTable.getData("General_Data", "AddressNickName"));
driver.findElement(By.name(UIMapCheckOut.txtAddressFNamee)).clear();
driver.findElement(By.name(UIMapCheckOut.txtAddressFNamee)).sendKeys(dataTable.getData("General_Data", "Firstname"));
driver.findElement(By.name(UIMapCheckOut.txtAddressLNamee)).clear();
driver.findElement(By.name(UIMapCheckOut.txtAddressLNamee)).sendKeys(dataTable.getData("General_Data", "Lastname"));
driver.findElement(By.name(UIMapCheckOut.txtAddressLinee1)).clear();
driver.findElement(By.name(UIMapCheckOut.txtAddressLinee1)).sendKeys(dataTable.getData("General_Data", "Address1"));
driver.findElement(By.name(UIMapCheckOut.txtAddressCityy)).clear();
driver.findElement(By.name(UIMapCheckOut.txtAddressCityy)).sendKeys(dataTable.getData("General_Data", "City"));
new Select(driver.findElement(By.name(UIMapCheckOut.txtAddressStatee))).selectByVisibleText(dataTable.getData("General_Data", "State"));
Thread.sleep(1000);
driver.findElement(By.xpath(UIMapCheckOut.txtAddressZipCodee)).clear();
driver.findElement(By.xpath(UIMapCheckOut.txtAddressZipCodee)).sendKeys(dataTable.getData("General_Data", "zipcode"));
Thread.sleep(1000);
driver.findElement(By.linkText("Save")).click();
selenium.waitForPageToLoad("20000");
Thread.sleep(5000);
report.updateTestLog("Adding New Address", "New Address Added", Status.DONE);
}
/***Select Newly Added Address in Product Destination*****/
public void selectAddedAddressProductDestination() throws Exception
{
String varShipAdd=dataTable.getData("General_Data", "AddressNickName")+" - "+dataTable.getData("General_Data", "Firstname")+" "+dataTable.getData("General_Data", "Lastname");
System.out.println(varShipAdd);
new Select(driver.findElement(By.xpath(UIMapCheckOut.drpDownSelectShipAddress))).selectByVisibleText(varShipAdd);
report.updateTestLog("Selecting New Address", "New Address Selected", Status.DONE);
Thread.sleep(1000);
driver.findElement(By.xpath(UIMapMyLowes.btnSecureCheckOut)).click();
selenium.waitForPageToLoad("120000");
}

/**This function checks the Ship to address & Service level on Shipping options page for Remote Territories Address**/
public void validateShippingOptionRemoteTerritory() throws Exception
{
String varServiceLevel=driver.findElement(By.xpath(UIMapCheckOut.lblServiceLevel)).getText();
System.out.println(varServiceLevel);
if(varServiceLevel.equals("Standard 1-3 Business Days FREE"))
report.updateTestLog("Checking Service Level", "Service Level-Standard displayed", Status.PASS);
else
report.updateTestLog("Checking Service Level", "Service Level-Standard NOT displayed", Status.FAIL);
String varShipToAdd=driver.findElement(By.xpath(UIMapCheckOut.lblShipToAdd)).getText();
System.out.println(varShipToAdd);
String varExpectedAdd=dataTable.getData("General_Data", "Firstname")+" "+dataTable.getData("General_Data", "Lastname")+'\n'
+dataTable.getData("General_Data", "Address1")+'\n'+dataTable.getData("General_Data", "City")+" "+dataTable.getData("General_Data", "StateShortForm")
+" "+dataTable.getData("General_Data", "zipcode");
System.out.println(varExpectedAdd);
if(varShipToAdd.equals(varExpectedAdd))
report.updateTestLog("Checking Ship To Address", "Ship To Address Correct", Status.PASS);
else
report.updateTestLog("Checking Ship To Address", "Ship To Address NOT Correct", Status.FAIL);
}
/***This function clicks on Previous link***/
public void clickPrevious() throws Exception
{
driver.findElement(By.linkText("Previous")).click();
selenium.waitForPageToLoad("20000");
}

public void getCurrentQtyInCart() throws Exception
{
	String s = driver.findElement(By.xpath(UIMapCheckOut.txtParentQuantityInCart)).getAttribute("value");
	dataTable.putData("General_Data","CurrentQty",s);
}
public void validateMinimumMsgInCart() throws Exception
{
	String s = dataTable.getData("General_Data","CurrentQty");
	String updatedQty = driver.findElement(By.xpath(UIMapCheckOut.txtParentQuantityInCart)).getAttribute("value");
	if(driver.findElement(By.xpath(UIMapCheckOut.lblUnavailableErrorMsg)).getText().contains("Please note that the quantity has been updated to meet the required minimum.")
			&&
			s.equals(updatedQty))
	report.updateTestLog("Verifying Minimum message and the quantity","Minimum message is displayed correctly and the quantity has been updated to meet required minimum", Status.PASS);
	else
		report.updateTestLog("Verifying Minimum message and the quantity","Minimum message and quantity not updated correctly", Status.FAIL);	
	}

/***This function validates that US territories newly added addresses are not displayed for SOS-DD Items-Parcel***/
public void checkTerritoryAddressSOSDD() throws Exception
{
	String varShipAdd=dataTable.getData("General_Data", "AddressNickName")+" - "+dataTable.getData("General_Data", "Firstname")+" "+dataTable.getData("General_Data", "Lastname");
	System.out.println(varShipAdd);
	int varOptionCount=ps.countWebElement(UIMapCheckOut.drpDownAddressValues);
	int i=0;
	for(i=1;i<=varOptionCount;i++)
	{
		String varAddrss=driver.findElement(By.xpath(UIMapCheckOut.drpDownAddressValues+"["+i+"]")).getText();
		if(varAddrss.equals(varShipAdd))
		{
			report.updateTestLog("Checking Added US Territory Address", "Added US Territory Address displayed in Drop-down for selection", Status.FAIL);
			break;
		}
		else
			continue;
	}
	if(i>varOptionCount)
		report.updateTestLog("Checking Added US Territory Address", "Added US Territory Address NOT displayed in Drop-down for selection", Status.PASS);
}

/**
 * this function validates Cart Summary section in Review & Pay Page for Gift Card
 */
public void chkCartSummaryRevPayPgGC() throws Exception
{
	//unit Price
	try{
	if(!driver.findElement(By.xpath(UIMapCheckOut.lblCartSummaryUnitPrc)).getText().isEmpty())
		report.updateTestLog("Checking Unit Price in Cart Summary", "Unit Price Displayed in Cart Summary", Status.PASS);
	else
		report.updateTestLog("Checking Unit Price in Cart Summary", "Unit Price NOT Displayed in Cart Summary", Status.FAIL);
		}
	catch(Exception e)
	{
		report.updateTestLog("Checking Unit Price in Cart Summary", "Unit Price NOT Displayed in Cart Summary", Status.FAIL);
	}
	
	//Qty
			try{
			if(!driver.findElement(By.xpath(UIMapCheckOut.lblCartSummaryQty)).getText().isEmpty())
				report.updateTestLog("Checking Quantity in Cart Summary", "Quantity Displayed in Cart Summary", Status.PASS);
			else
				report.updateTestLog("Checking Quantity in Cart Summary", "Quantity NOT Displayed in Cart Summary", Status.FAIL);
				}
			catch(Exception e)
			{
				report.updateTestLog("Checking Quantity in Cart Summary", "Quantity NOT Displayed in Cart Summary", Status.FAIL);
			}
	//Total
			try{
			if(!driver.findElement(By.xpath(UIMapCheckOut.lblCartSummaryTotl)).getText().isEmpty())
				report.updateTestLog("Checking Total in Cart Summary", "Total Displayed in Cart Summary", Status.PASS);
			else
				report.updateTestLog("Checking Total in Cart Summary", "Total NOT Displayed in Cart Summary", Status.FAIL);
				}
			catch(Exception e)
			{
				report.updateTestLog("Checking Total in Cart Summary", "Total NOT Displayed in Cart Summary", Status.FAIL);
			}
}


/**
 * this function validates Billing Summary section in Review & Pay Page for Gift Card
 */
public void chkBillSummaryRevPayPgGC() throws Exception
{
	//Subtotal
	try{
		String varSubTotal=driver.findElement(By.xpath(UIMapCheckOut.lblBillSummrySubtotal)).getText();
		
	if(varSubTotal.equalsIgnoreCase("Subtotal")&&(!driver.findElement(By.xpath(UIMapCheckOut.lblBillSummrySubtotalValue)).getText().isEmpty()))
		report.updateTestLog("Checking Subtotal in Billing Summary", "Subtotal Displayed in Billing Summary", Status.PASS);
	else
		report.updateTestLog("Checking Subtotal in Billing Summary", "Subtotal NOT Displayed in Billing Summary", Status.FAIL);
		}
	catch(Exception e)
	{
		report.updateTestLog("Checking Subtotal in Billing Summary", "Subtotal NOT Displayed in Billing Summary", Status.FAIL);
	}
	
	//Parcel Shipping
			try{
				String varParcelShipping=driver.findElement(By.xpath(UIMapCheckOut.lblBillSummryDelivry)).getText();
			if((varParcelShipping.trim().equalsIgnoreCase("Parcel Shipping")) && (driver.findElement(By.xpath(UIMapCheckOut.lblBillSummryDelivryCost)).getText().trim().equalsIgnoreCase("FREE")))
				report.updateTestLog("Checking Parcel Shipping in Cart Summary", "Parcel Shipping Displayed AS FREE in Billing Summary", Status.PASS);
			else
				report.updateTestLog("Checking Parcel Shipping in Billing Summary", "Parcel Shipping NOT Displayed AS FREE in Billing Summary", Status.FAIL);
				}
			catch(Exception e)
			{
				report.updateTestLog("Checking Parcel Shipping in Billing Summary", "Parcel Shipping NOT Displayed AS FREE in Billing Summary", Status.FAIL);
			}
			//Tax
			try{
				String varTax=driver.findElement(By.xpath(UIMapCheckOut.lblBillSummryTax)).getText();
				
			if(varTax.trim().equalsIgnoreCase("Tax")&&(!driver.findElement(By.xpath(UIMapCheckOut.lblBillSummryTaxValue)).getText().isEmpty()))
				report.updateTestLog("Checking Tax in Billing Summary", "Tax Displayed in Billing Summary", Status.PASS);
			else
				report.updateTestLog("Checking Tax in Billing Summary", "Tax NOT Displayed in Billing Summary", Status.FAIL);
				}
			catch(Exception e)
			{
				report.updateTestLog("Checking Tax in Billing Summary", "Tax NOT Displayed in Billing Summary", Status.FAIL);
			}
			//Balance Due
			try{
				String varBal=driver.findElement(By.xpath(UIMapCheckOut.lblBillSummrybalncDue)).getText();
				
			if(varBal.trim().equalsIgnoreCase("Balance Due")&&(!driver.findElement(By.xpath(UIMapCheckOut.lblBillSummrybalncDueValue)).getText().isEmpty()))
				report.updateTestLog("Checking Balance Due in Billing Summary", "Balance Due Displayed in Billing Summary", Status.PASS);
			else
				report.updateTestLog("Checking Balance Due in Billing Summary", "Balance Due NOT Displayed in Billing Summary", Status.FAIL);
				}
			catch(Exception e)
			{
				report.updateTestLog("Checking Balance Due in Billing Summary", "Balance Due NOT Displayed in Billing Summary", Status.FAIL);
			}
			
}

/**
 * This function validates information on Order Confirmation page for GC
 */
 public void chkOCforGC() throws Exception
 {
	 //thankyou message
	 String varThankuMsg=driver.findElement(By.xpath(UIMapCheckOut.lblThankYouMsg)).getText();
	 if(varThankuMsg.contains("Thank you for your order."))
		 report.updateTestLog("Checking Thank You Message", "Thank You Message Displayed", Status.PASS);
	 else
		 report.updateTestLog("Checking Thank You Message", "Thank You Message NOT Displayed", Status.FAIL);
	 
	 //order details
	 try{
	 boolean varOrderDetails=driver.findElement(By.xpath(UIMapCheckOut.webElmntOrderDetailsBox)).isDisplayed();
	 String varOrderDetails2=driver.findElement(By.xpath(UIMapCheckOut.lblOrderDetails)).getText();
	 if(varOrderDetails && (varOrderDetails2.trim().equalsIgnoreCase("Order Details")))
		 report.updateTestLog("Checking Order Details", "Order Details Displayed", Status.PASS);
	 else
		 report.updateTestLog("Checking Order Details", "Order Details NOT Displayed", Status.FAIL);
	 }
	 catch(Exception e)
	 {
		 report.updateTestLog("Checking Order Details", "Order Details NOT Displayed", Status.FAIL);
	 }
	 
	 //Parcel Shipping
	 try{
		 String varParcelShipping=driver.findElement(By.xpath(UIMapCheckOut.lblShipDetails)).getText();
		 if(varParcelShipping.trim().equalsIgnoreCase("Parcel Shipping"))
			 report.updateTestLog("Checking Parcel Shipping Info", "Parcel Shipping Info Displayed", Status.PASS);
		 else
			 report.updateTestLog("Checking Parcel Shipping Info", "Parcel Shipping Info NOT Displayed", Status.FAIL);
	 }
	 catch(Exception e)
	 {
		 report.updateTestLog("Checking Parcel Shopping Info", "Parcel Shopping Info NOT Displayed", Status.FAIL);
	 }
	 
	//Create Lowes Acct Box
	 try{
		 boolean varCreateAcct=driver.findElement(By.xpath(UIMapCheckOut.webElmntCreateAcctBox)).isDisplayed();
		 if(varCreateAcct)
			 report.updateTestLog("Checking Create Acct Box", "Create Acct Box Displayed", Status.PASS);
		 else
			 report.updateTestLog("Checking Create Acct Box", "Create Acct Box NOT Displayed", Status.FAIL);
	 }
	 catch(Exception e)
	 {
		 report.updateTestLog("Checking Create Acct Box", "Create Acct Box NOT Displayed", Status.FAIL);
	 }
	 
 }
 
 /***
  * This function checks whether Store Card & Primary Card checkBoxes are disabled for LAR Card
  */
 public void checkChkBoxesDisabledForLAR() throws Exception
 {
    driver.findElement(By.name(UIMapMyLowes.txtCardNickName)).clear();
	driver.findElement(By.name(UIMapMyLowes.txtCardNickName)).sendKeys(dataTable.getData("General_Data", "nickName"));
	
	new Select(driver.findElement(By.id(UIMapMyLowes.drpDownChkOutType))).selectByVisibleText(dataTable.getData("General_Data","cardType"));
	Thread.sleep(4000);
	 boolean varStoreCard=driver.findElement(By.xpath(UIMapCheckOut.chkBoxStoreCard)).isEnabled();
	 boolean varPrimaryCard=driver.findElement(By.xpath(UIMapCheckOut.chkBoxPrimaryCard)).isEnabled();
	 if(varStoreCard)
		 report.updateTestLog("Checking Store Card check Box", "Store Card check Box Not disabled", Status.FAIL);
	 else
		 report.updateTestLog("Checking Store Card check Box", "Store Card check Box disabled", Status.PASS);
	 
	 if(varPrimaryCard)
		 report.updateTestLog("Checking Primary Card check Box", "Primary Card check Box Not disabled", Status.FAIL);
	 else
		 report.updateTestLog("Checking Primary Card check Box", "Primary Card check Box disabled", Status.PASS);
 }
 
 /***This function changes Shipping Address stored in dataSheet ****/
 public void changeShippingAddrssDataSheet() throws Exception
 {
	 String varAddressNickName=dataTable.getData("General_Data", "AddressNickName");
	 dataTable.putData("General_Data", "AddressNickName", varAddressNickName+"1");
	 String varFName=dataTable.getData("General_Data", "Firstname");
	 dataTable.putData("General_Data", "Firstname", varFName+"a");
	 String varLName=dataTable.getData("General_Data", "Lastname");
	 dataTable.putData("General_Data", "Lastname", varLName+"a");
 }
 
 /**This function checks whether added address is displayed in Ship To Drop-down on Product Destination page***/
 public void checkAddressDisplayedProductDestination() throws Exception
 {
	 	String varShipAdd=dataTable.getData("General_Data", "AddressNickName")+" - "+dataTable.getData("General_Data", "Firstname")+" "+dataTable.getData("General_Data", "Lastname");
		System.out.println(varShipAdd);
		int varOptionCount=ps.countWebElement(UIMapCheckOut.drpDownAddressValues);
		int i=0;
		for(i=1;i<=varOptionCount;i++)
		{
			String varAddrss=driver.findElement(By.xpath(UIMapCheckOut.drpDownAddressValues+"["+i+"]")).getText();
			System.out.println(varAddrss);
			System.out.println(varShipAdd);
			if(varAddrss.equals(varShipAdd))
			{
				report.updateTestLog("Checking Added Address after SAVE", "Added Address displayed in Drop-down for selection", Status.PASS);
				break;
			}
			else
				continue;
		}
		if(i>varOptionCount)
			report.updateTestLog("Checking Added Address after SAVE", "Added Address NOT displayed in Drop-down for selection", Status.FAIL); 
	 
 }
 
 /**This function adds new Address and clicks on Cancel link on Product destination page**/
 public void addNewAddressCancelProductDestination() throws Exception
	{
		driver.findElement(By.linkText("Add New Address")).click();
		Thread.sleep(2000);
		//entering address
		driver.findElement(By.name(UIMapCheckOut.txtAddressNickNamee)).clear();
		driver.findElement(By.name(UIMapCheckOut.txtAddressNickNamee)).sendKeys(dataTable.getData("General_Data", "AddressNickName"));
		driver.findElement(By.name(UIMapCheckOut.txtAddressFNamee)).clear();
		driver.findElement(By.name(UIMapCheckOut.txtAddressFNamee)).sendKeys(dataTable.getData("General_Data", "Firstname"));
		driver.findElement(By.name(UIMapCheckOut.txtAddressLNamee)).clear();
		driver.findElement(By.name(UIMapCheckOut.txtAddressLNamee)).sendKeys(dataTable.getData("General_Data", "Lastname"));
		driver.findElement(By.name(UIMapCheckOut.txtAddressLinee1)).clear();
		driver.findElement(By.name(UIMapCheckOut.txtAddressLinee1)).sendKeys(dataTable.getData("General_Data", "Address1"));
		driver.findElement(By.name(UIMapCheckOut.txtAddressCityy)).clear();
		driver.findElement(By.name(UIMapCheckOut.txtAddressCityy)).sendKeys(dataTable.getData("General_Data", "City"));
		new Select(driver.findElement(By.name(UIMapCheckOut.txtAddressStatee))).selectByVisibleText(dataTable.getData("General_Data", "State"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(UIMapCheckOut.txtAddressZipCodee)).clear();
		driver.findElement(By.xpath(UIMapCheckOut.txtAddressZipCodee)).sendKeys(dataTable.getData("General_Data", "zipcode"));
		Thread.sleep(1000);
		driver.findElement(By.linkText("Undo")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(5000);
		report.updateTestLog("Adding New Address", "New Address Added and Cancel Clicked", Status.DONE);
		
		
	}
 
 /**This function checks whether added address is NOT displayed in Ship To Drop-down on Product Destination page***/
 public void checkAddressDisplayedProductDestinationCancel() throws Exception
 {
	 /*	String varShipAdd=dataTable.getData("General_Data", "AddressNickName")+" - "+dataTable.getData("General_Data", "Firstname")+" "+dataTable.getData("General_Data", "Lastname");
		System.out.println(varShipAdd);
		int varOptionCount=ps.countWebElement(UIMapCheckOut.drpDownAddressValues);
		System.out.println(varOptionCount);
		int i=0;
		for(i=1;i<=varOptionCount;i++)
		{
			System.out.println(UIMapCheckOut.drpDownAddressValues+"["+i+"]");
			String varAddrss=driver.findElement(By.xpath(UIMapCheckOut.drpDownAddressValues+"["+i+"]")).getText();
			
			if(varAddrss.equals(varShipAdd))
			{
				report.updateTestLog("Checking Added Address after Cancel", "Added Address displayed in Drop-down for selection", Status.FAIL);
				break;
			}
			else
				continue;
		}
		if(i>varOptionCount)
			report.updateTestLog("Checking Added Address after Cancel", "Added Address NOT displayed in Drop-down for selection", Status.PASS); 
	 */
	 	try{String varPDShippingAddress=driver.findElement(By.xpath(UIMapCheckOut.lblPDShippingAddress2)).getText();
		System.out.println(varPDShippingAddress);
		String varExpectedAddress=dataTable.getData("General_Data", "AddressNickName")+" - "+dataTable.getData("General_Data", "Firstname")
		+" "+dataTable.getData("General_Data", "Lastname")+", "+dataTable.getData("General_Data", "Address1")+'\n'+dataTable.getData("General_Data", "City")+
		", "+dataTable.getData("General_Data", "StateShortForm")+" "+dataTable.getData("General_Data", "zipcode");
		System.out.println(varExpectedAddress);
		
		
		if(varPDShippingAddress.equals(varExpectedAddress))
		{
			report.updateTestLog("Checking Address Saved on Clicking Cancel", "Address Saved on Clicking Cancel", Status.FAIL);
		}
		else
			report.updateTestLog("Checking Address Saved on Clicking Cancel", "Address NOT Saved on Clicking Cancel", Status.PASS);
	 	}
	 	catch(Exception e)
	 	{
	 		
	 	}
 }
 
 /**Validates whether 4 tabs are displayed if any item is added in cart with Parcel shipping delivery method-No Addresses saved**/
 public void validateSecureChkOutTabsParcelNoAdd() throws Exception
 {
	 String varTab1=driver.findElement(By.xpath(UIMapCheckOut.webElmntSecureChkOutTab1)).getText();
	 String varTab2=driver.findElement(By.xpath(UIMapCheckOut.webElmntSecureChkOutTab2)).getText();
	 String varTab3=driver.findElement(By.xpath(UIMapCheckOut.webElmntSecureChkOutTab3)).getText();
	 String varTab4=driver.findElement(By.xpath(UIMapCheckOut.webElmntSecureChkOutTab4)).getText();
	 if(varTab1.contains("Shipping Address") && varTab2.contains("Product Destination") && varTab3.contains("Shipping Options") && varTab4.contains("Review & Pay"))
		 report.updateTestLog("Validating Tabs", "4 tabs correctly displayed", Status.PASS);
	 else
		 report.updateTestLog("Validating Tabs", "4 tabs NOT correctly displayed", Status.FAIL);
 }
 
 /**This function clicks on Continue checkout button on Shipping Address page**/
 public void clickContinueChkOut() throws Exception
 {
	// checkout before USPS
		driver.findElement(By.xpath(UIMapMyLowes.btnSecureCheckOut)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// confirm USPS first
		boolean uspsContinue = selenium.isTextPresent("Confirm");
		if (uspsContinue) {
			driver.findElement(By.id(UIMapCheckOut.rdoBtnUSPSEnteredAddress)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(UIMapMyLowes.btnCfrmUSPSAddress))
					.click();
		}
		selenium.waitForPageToLoad("20000");
		
 }
 
 /**this function validates the text at an xpath with expected value***/
 public void chkText(String varXpath, String varValue) throws Exception
 {
	 String varApplicationValue=driver.findElement(By.xpath(varXpath)).getText();
	 if(varApplicationValue.trim().equalsIgnoreCase(varValue))
		 report.updateTestLog("Checking "+varValue, varValue+" Displayed", Status.PASS);
	 else
		 report.updateTestLog("Checking "+varValue, varValue+" Displayed", Status.FAIL);
 }
 
 /**This function validates Secure Checkout page***/
 public void verifySecureChkOutPg() throws Exception
 {
	/* String varSecureChkOut=driver.findElement(By.xpath(UIMapCheckOut.lblSecureChkOut)).getText();
	 String varIHvLowesAcct=driver.findElement(By.xpath(UIMapCheckOut.lblIHvLowesAcct)).getText();
	 String varChkOutFastr=driver.findElement(By.xpath(UIMapCheckOut.lblChkOutFastr)).getText();
	 String varEmail=driver.findElement(By.xpath(UIMapCheckOut.lblEmail)).getText();
	 String varEmailExample=driver.findElement(By.xpath(UIMapCheckOut.lblEmailExample)).getText();
	 String varPasswrd=driver.findElement(By.xpath(UIMapCheckOut.lblPasswrd)).getText();
	 String varPasswrdInstruction=driver.findElement(By.xpath(UIMapCheckOut.lblPasswrdInstruction)).getText();
	 String varSignIn=driver.findElement(By.xpath(UIMapCheckOut.btnSignIn)).getText();
	 String varForgotPswrdt=driver.findElement(By.xpath(UIMapCheckOut.lnkForgotPswrd)).getText();
	 String varNeedHelp=driver.findElement(By.xpath(UIMapCheckOut.lblNeedHelp)).getText();
	 String varIDntHvLowesAcct=driver.findElement(By.xpath(UIMapCheckOut.lblIDntHvLowesAcct	)).getText();
	 String varChkOut=driver.findElement(By.xpath(UIMapCheckOut.btnChkOut)).getText();*/
	 
	 chkText(UIMapCheckOut.lblSecureChkOut,"Secure Checkout Shopping is always safe and secure.");
	 chkText(UIMapCheckOut.lblIHvLowesAcct,"I Have a Lowes.com Account");
	 chkText(UIMapCheckOut.lblChkOutFastr,"Checkout faster by signing in");
	 chkText(UIMapCheckOut.lblEmail,"E-mail Address:");
	 chkText(UIMapCheckOut.lblEmailExample,"Example: name@domain.com");
	 chkText(UIMapCheckOut.lblPasswrd,"Password:");
	 chkText(UIMapCheckOut.lblPasswrdInstruction,"Password is case sensitive");
	 chkText(UIMapCheckOut.btnSignIn,"Sign In");
	 chkText(UIMapCheckOut.lnkForgotPswrd,"Forgot Your password?");
	 chkText(UIMapCheckOut.lblNeedHelp,"Need Help? Call Lowe's Customer Care at 1-800-445-6937, or email us at customercare@lowes.com.");
	 chkText(UIMapCheckOut.lblIDntHvLowesAcct,"I Don't Have a Lowes.com Account");
	 chkText(UIMapCheckOut.btnChkOut,"Checkout");
	 //Checking Forgot passwrd link
	 driver.findElement(By.linkText("Forgot Your password?")).click();
	 Thread.sleep(4000);
	 try{
	 boolean varForgtPsswrd=driver.findElement(By.xpath(UIMapCheckOut.webElmntForgtPsswrdDialog)).isDisplayed();
	 if(varForgtPsswrd)
	 {
		 report.updateTestLog("Clicking Forgot Your password?", "Reset Passwrd Dialog displayed", Status.PASS);
		 driver.findElement(By.linkText("Cancel")).click();
		 Thread.sleep(3000);
	 }
		 
	 else
		 report.updateTestLog("Clicking Forgot Your password?", "Reset Passwrd Dialog NOT displayed", Status.FAIL);
	 }
	 catch(Exception e)
	 {
		 report.updateTestLog("Clicking Forgot Your password?", "Reset Passwrd Dialog NOT displayed", Status.FAIL);
	 }
	 //checking customercare@lowes.com. link
	 driver.findElement(By.linkText("customercare@lowes.com.")).click();
	 selenium.waitForPageToLoad("120000");
	 if(selenium.getTitle().equals("Contact Us"))
		 report.updateTestLog("Clicking customercare@lowes.com.", "Contact Us page displayed", Status.PASS);
	 else
		 report.updateTestLog("Clicking customercare@lowes.com.", "Contact Us page NOT displayed", Status.FAIL);
	 driver.navigate().back();
	 selenium.waitForPageToLoad("120000");
	 //clicking Checkout button
	 driver.findElement(By.xpath(UIMapCheckOut.btnChkOut)).click();
	 selenium.waitForPageToLoad("120000");
	 verifyRevPayPageDisplayed();
	 driver.findElement(By.linkText("Cancel")).click();
	 selenium.waitForPageToLoad("120000");
	 driver.findElement(By.xpath(UIMapCheckOut.btnStrtSecureChkOut2)).click();
		Thread.sleep(2000);
		if(selenium.isTextPresent("No Thanks"))
			driver.findElement(By.linkText("No Thanks")).click();
		selenium.waitForPageToLoad("120000");
	
 }
 
/***This function validates Invalid Email Error on Secure ChkOut Page***/
 public void invalidEmailError() throws Exception
 {
	 chkText(UIMapCheckOut.lblInvalidEmailError,"Please enter a valid log-in ID or email address and password.");
 }
 
 /***This function validates Review & Pay Page is displayed on Successful SignIn on Secure ChkOut Page for Store Pickup***/
 public void verifyRevPayPageDisplayed() throws Exception
 {
	if(selenium.getTitle().contains("Review and Pay"))
		report.updateTestLog("Checking Review & Pay Page Displayed", "Review & Pay Page Displayed", Status.PASS);
	else
		report.updateTestLog("Checking Review & Pay Page Displayed", "Review & Pay Page NOT Displayed", Status.FAIL);
 }
 
 /**This method checks Cart Summary section in Shipping Address/Product Destination & Shipping Options page for an Order
  * containing items - 1 in each delivery method
  */
 public void validateCartSummaryMultipleItems() throws Exception
 {
	 chkText(UIMapCheckOut.lblDel1, "Lowe's Truck Delivery");
	 chkText(UIMapCheckOut.lblDel2, "Estimated Parcel Shipping");
	 chkText(UIMapCheckOut.lblDel3, "Store Pick Up");
 }
 
 /**This function validates Product Destination Page for Multiple Items Order***/
 public void verifyProductDestinationMultipleItems() throws Exception
 {
	 validateCartSummaryMultipleItems();
	 chkText(UIMapCheckOut.lblChooseParcelDest, "Choose Parcel Shipping Destination");
	 chkText(UIMapCheckOut.lblChooseLTDDest, "Choose Lowe's Truck Delivery Destination");
 }
 
 /**This function validates Shipping Options Page for Multiple Items Order***/
 public void verifyShipOptionsMultipleItems() throws Exception
 {
	 validateCartSummaryMultipleItems();
	 chkText(UIMapCheckOut.lblConfrmParcelOptions, "Confirm Your Parcel Shipping Options");
	 chkText(UIMapCheckOut.lblConfrmLTDOptions, "Confirm Your Lowe's Truck Delivery Options");
 }
 
 /**This function validates Review & Pay Page for Multiple Items Order***/
 public void verifyRevPayMultipleItems() throws Exception
 {
	 chkText(UIMapCheckOut.lblGiftCards, "Gift Cards & Reward Certificates");
	 chkText(UIMapCheckOut.lblCreditCardInfo, "Credit Card Information");
	 chkText(UIMapCheckOut.lblBillingInfo, "Billing Information");
	 chkText(UIMapCheckOut.lblCartSummary1, "Cart Summary");
	 chkText(UIMapCheckOut.lblBillSummary1, "Billing Summary");
 }
 
 /**
  * This function validates that whether Parcel Shipping is auto-selected for added GC in Cart(should be the only item added)
  */
 public void checkParcelSelectedForGCCart() throws Exception
 {
	dataTable.putData("General_Data", "DeliveryMthd", "UPS");
	validateDeliveryInCart();
 }

 /**This function checks Max Length field for a particular Text Area***/
 public void checkMaxLength(String name, String expMaxLen, String fieldName)
 {
	 String maxLength=driver.findElement(By.name(name)).getAttribute("maxlength");
	 if(maxLength.equals(expMaxLen))
		 report.updateTestLog("Checking MaxLength of field "+fieldName, fieldName+" Max length is "+expMaxLen, Status.PASS);
	 else
		 report.updateTestLog("Checking MaxLength of field "+fieldName, fieldName+" Max length is NOT "+expMaxLen, Status.FAIL);
 }
 
 /***This function validates Gift Card functionality in Cart***/
 public void verifyGCFunctionalityinCart() throws Exception
 {
	 checkParcelSelectedForGCCart();
	 //Checking Parcel Shipping Options
	 int varCount=ps.countWebElement(UIMapCheckOut.gcParcelShippingOptionsCount);
	 if(varCount==2)
	 {
		 String varOption1=driver.findElement(By.xpath(UIMapCheckOut.gcParcelShippingOptionsCount+"[1]")).getText();
		 String pattern = "Standard .* Business Days FREE";
		 Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(varOption1);
			if(m.find())
				report.updateTestLog("Checking Parcel Shipping option1", varOption1+" Displayed", Status.PASS);
			else
				report.updateTestLog("Checking Parcel Shipping option1", varOption1+" Displayed", Status.FAIL);
		String varOption2=driver.findElement(By.xpath(UIMapCheckOut.gcParcelShippingOptionsCount+"[2]")).getText();
		pattern = "Next Day Delivery \\$.*";
		r = Pattern.compile(pattern);
		m = r.matcher(varOption2);
		if(m.find())
			report.updateTestLog("Checking Parcel Shipping option2", varOption2+" Displayed", Status.PASS);
		else
			report.updateTestLog("Checking Parcel Shipping option2", varOption2+" Displayed", Status.FAIL);
			
	 }
	 else
		 report.updateTestLog("Checking Parcel Shipping options", "More than 2 Options displayed", Status.FAIL);
	//selecting Parcel Shipping Option
	 new Select(driver.findElement(By.xpath(UIMapCheckOut.drpDownGCParcelShippingOption))).selectByIndex(0);	
		Thread.sleep(2000);
		if(driver.findElement(By.xpath(UIMapCheckOut.lblGCParcelFree)).getText().trim().equalsIgnoreCase("FREE"))
			report.updateTestLog("Selecting Parcel Shipping option1", " Parcel Shipping FREE Displayed", Status.PASS);
		else
			report.updateTestLog("Selecting Parcel Shipping option1", " Parcel Shipping FREE NOT Displayed", Status.FAIL);
		
	 //checking Max Length of all fields
	 checkMaxLength(UIMapCheckOut.txtGCToCart,"50","To");
	 checkMaxLength(UIMapCheckOut.txtGCFromCart,"50","From");
	 String varMsgMaxLength=driver.findElement(By.xpath(UIMapCheckOut.lblGCMsgMaxLen)).getText();
	 System.out.println(varMsgMaxLength);
	 if(varMsgMaxLength.trim().equals("255"))
		 report.updateTestLog("Checking MaxLength of Message field", "Max length is 255", Status.PASS);
	 else
		 report.updateTestLog("Checking MaxLength of Message field", "Max length is NOT 255", Status.FAIL);
	 //entering data in all fields
	 String varTo=dataTable.getData("General_Data", "GCTo");
	 driver.findElement(By.name(UIMapCheckOut.txtGCToCart)).click();
	 driver.findElement(By.name(UIMapCheckOut.txtGCToCart)).clear();
	 driver.findElement(By.name(UIMapCheckOut.txtGCToCart)).sendKeys(varTo);
	 
	 String varFrom=dataTable.getData("General_Data", "GCFrom");
	 driver.findElement(By.name(UIMapCheckOut.txtGCFromCart)).click();
	 driver.findElement(By.name(UIMapCheckOut.txtGCFromCart)).clear();
	 driver.findElement(By.name(UIMapCheckOut.txtGCFromCart)).sendKeys(varFrom);
	 
	 String varMsg=dataTable.getData("General_Data", "GCMessage");
	 driver.findElement(By.name(UIMapCheckOut.txtGCMsgCart)).click();
	 driver.findElement(By.name(UIMapCheckOut.txtGCMsgCart)).clear();
	 driver.findElement(By.name(UIMapCheckOut.txtGCMsgCart)).sendKeys(varMsg);
	 Thread.sleep(1000);
	 String varMsgCharRemaining=driver.findElement(By.xpath(UIMapCheckOut.lblGCMsgMaxLen)).getText();
	 int varCharRemainingExp=255-varMsg.length();
	 System.out.println(varCharRemainingExp);
	 String varCharRemainingExpStr=String.valueOf(varCharRemainingExp);
	 if(varCharRemainingExpStr.equals(varMsgCharRemaining))
		 report.updateTestLog("Checking Character Countdown", "Character countdown decreased by message length", Status.PASS);
	 else
		 report.updateTestLog("Checking Character Countdown", "Character countdown NOT decreased by message length", Status.FAIL);
	 
	 driver.findElement(By.linkText("Save")).click();
	 selenium.waitForPageToLoad("20000");
	 
	 String varGCToSavd=driver.findElement(By.name(UIMapCheckOut.txtGCToCart)).getAttribute("value");
	 String varGCFromSavd=driver.findElement(By.name(UIMapCheckOut.txtGCFromCart)).getAttribute("value");
	 String varGCMsgSavd=driver.findElement(By.name(UIMapCheckOut.txtGCMsgCart)).getText();
	 if(varGCToSavd.equals(varTo) && varGCFromSavd.equals(varFrom) && varGCMsgSavd.equals(varMsg))
		 report.updateTestLog("Checking Gift Card Fields after Save", "Gift Card fields correctly displayed after Save", Status.PASS);
	 else
		 report.updateTestLog("Checking Gift Card Fields after Save", "Gift Card fields correctly displayed after Save", Status.FAIL);
	 
	 //going to other page and returning to cart
	 driver.findElement(By.xpath(UIMapCheckOut.webElmntHome)).click();
	 selenium.waitForPageToLoad("20000");
	 driver.navigate().back();
	 selenium.waitForPageToLoad("20000");
	 varGCToSavd=driver.findElement(By.name(UIMapCheckOut.txtGCToCart)).getAttribute("value");
	 varGCFromSavd=driver.findElement(By.name(UIMapCheckOut.txtGCFromCart)).getAttribute("value");
	 varGCMsgSavd=driver.findElement(By.name(UIMapCheckOut.txtGCMsgCart)).getText();
	 if(varGCToSavd.equals(varTo) && varGCFromSavd.equals(varFrom) && varGCMsgSavd.equals(varMsg))
		 report.updateTestLog("Checking Gift Card Fields after moving to other page", "Gift Card fields correctly displayed after moving back to cart", Status.PASS);
	 else
		 report.updateTestLog("Checking Gift Card Fields after moving to other page", "Gift Card fields correctly displayed after moving back to cart", Status.FAIL);
	 
	 //editing fields and clicking Cancel
	 driver.findElement(By.name(UIMapCheckOut.txtGCToCart)).click();
	 driver.findElement(By.name(UIMapCheckOut.txtGCToCart)).sendKeys("a");
	 
	 driver.findElement(By.name(UIMapCheckOut.txtGCFromCart)).click();
	 driver.findElement(By.name(UIMapCheckOut.txtGCFromCart)).sendKeys("a");
	 
	 driver.findElement(By.name(UIMapCheckOut.txtGCMsgCart)).click();
	 driver.findElement(By.name(UIMapCheckOut.txtGCMsgCart)).sendKeys("a");
	 Thread.sleep(1000);
	 driver.findElement(By.linkText("Cancel")).click();
	 Thread.sleep(4000);
	 
	 varGCToSavd=driver.findElement(By.name(UIMapCheckOut.txtGCToCart)).getAttribute("value");
	 varGCFromSavd=driver.findElement(By.name(UIMapCheckOut.txtGCFromCart)).getAttribute("value");
	 varGCMsgSavd=driver.findElement(By.name(UIMapCheckOut.txtGCMsgCart)).getText();
	 if(varGCToSavd.equals(varTo) && varGCFromSavd.equals(varFrom) && varGCMsgSavd.equals(varMsg))
		 report.updateTestLog("Checking Gift Card Fields after Cancel", "Gift Card fields retained older value after Cancel", Status.PASS);
	 else
		 report.updateTestLog("Checking Gift Card Fields after Cancel", "Gift Card fields retained older value after Cancel", Status.FAIL);
	 
	 //Checking Qty validation
	 	driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[3]/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[3]/input")).clear();
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[3]/input")).sendKeys("11");
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[3]/input")).sendKeys(Keys.TAB);
		Thread.sleep(2000);
		String varError=null;
		if(driver.findElement(By.xpath(UIMapCheckOut.lblGCInvalidQtyError)).isDisplayed())
		{
			varError=driver.findElement(By.xpath(UIMapCheckOut.lblGCInvalidQtyError)).getText();
			if(varError.equals("Gift card quantities may not exceed 10."))
				report.updateTestLog("Entering Qty>10", "Correct Error Message Displayed", Status.PASS);
			else
				report.updateTestLog("Entering Qty>10", "Correct Error Message NOT Displayed", Status.FAIL);
			driver.findElement(By.xpath(UIMapCheckOut.btnStrtSecureChkOut2)).click();
			selenium.waitForPageToLoad("20000");
			String varNewQty=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[3]/input")).getAttribute("value");
			if(varNewQty.equals("1"))
			{
				report.updateTestLog("Entering value>10 in Gift Card Qty", "Qty updated to 1", Status.PASS);
			}
			else
				report.updateTestLog("Entering value>10 in Gift Card Qty", "Qty NOT updated to 1", Status.FAIL);
		}
		else
			report.updateTestLog("Entering Qty>10", "Error Message NOT Displayed", Status.FAIL);
		
		//Checking Unit Price validation
		String varOldUP=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[4]/div/input")).getAttribute("value");
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[4]/div/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[4]/div/input")).clear();
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[4]/div/input")).sendKeys("501");
		driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[4]/div/input")).sendKeys(Keys.TAB);
		Thread.sleep(5000);
		
		System.out.println("Popup:"+driver.findElement(By.xpath(UIMapCheckOut.lblGCInvalidUntPrcError)).getAttribute("style"));
		if(driver.findElement(By.xpath(UIMapCheckOut.lblGCInvalidUntPrcError)).isDisplayed())
		{
			varError=driver.findElement(By.xpath(UIMapCheckOut.lblGCInvalidUntPrcError)).getText();
			if(varError.equals("Gift cards are limited to a maximum of $500."))
				report.updateTestLog("Entering Unit Price>500", "Correct Error Message Displayed", Status.PASS);
			else
				report.updateTestLog("Entering Unit Price>500", "Correct Error Message NOT Displayed", Status.FAIL);
			driver.findElement(By.xpath(UIMapCheckOut.btnStrtSecureChkOut2)).click();
			selenium.waitForPageToLoad("20000");
			String varNewUP=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[4]/div/input")).getAttribute("value");
			if(varNewUP.equals(varOldUP))
			{
				report.updateTestLog("Entering Unit Price>500 & clicking secure CheckOut", "Unit Price updated to Original Value", Status.PASS);
			}
			else
				report.updateTestLog("Entering Unit Price>500 & clicking secure CheckOut", "Unit Price NOT updated to Original Value", Status.FAIL);
		}
		else
			report.updateTestLog("Entering Unit Price>500", "Error Message NOT Displayed", Status.FAIL);
 }
 
 /**This function changes Store using Find a Store link on masthead**/
 public void changeStoreUsingFindAStore() throws Exception
 {
	 ClickCustomize("linkText", "Find a Store");
	 selenium.waitForPageToLoad("20000");
	 if(selenium.getTitle().equals("Lowe's: Store locator"))
	 {
		 report.updateTestLog("Clicking Find a Store", "Store locator page displayed", Status.PASS);
		 driver.findElement(By.id(UIMapCheckOut.txtStoreSearch)).click();
		 driver.findElement(By.id(UIMapCheckOut.txtStoreSearch)).clear();
		 driver.findElement(By.id(UIMapCheckOut.txtStoreSearch)).sendKeys(dataTable.getData("General_Data", "NewStore"));
		 driver.findElement(By.id(UIMapCheckOut.txtStoreSearch)).sendKeys(Keys.ENTER);
		 Thread.sleep(5000);
		 ClickCustomize("linkText", "Make This Your Store"); 
		 selenium.waitForPageToLoad("20000");
		 ClickCustomize("partialLinkText", "Store Info");
		 Thread.sleep(2000);
		 String varStoreAddress=driver.findElement(By.xpath(UIMapCheckOut.lblStoreAddress2)).getText();
		 if(varStoreAddress.contains("Store #"+dataTable.getData("General_Data", "NewStore")))
			 report.updateTestLog("Chacking New Store", "Store changed successfuly", Status.PASS);
		 else
			 report.updateTestLog("Chacking New Store", "Store NOT changed successfuly", Status.FAIL);
	 }
	else
		 report.updateTestLog("Clicking Find a Store", "Store locator page NOT displayed", Status.FAIL);
 }
 
 
 public void verifyStoreLocator()throws Exception{
		
		//driver.findElement(By.xpath("//*[@id='nav-store-find']/span")).click();
	 ClickCustomize("linkText", "Find a Store");	
	 selenium.waitForPageToLoad("120000");
		
		if(driver.getTitle().contains("Lowe's: Store locator"))
		{
			report.updateTestLog("Validating the display of Store Locator page", 
					"Store Locator page is displayed",Status.PASS);
			
			//enter the destination zipcode in the find a store search box
			driver.findElement(By.id(UIMapCheckOut.txtStoreSearch)).sendKeys(dataTable.getData("General_Data","zipcode"));
			driver.findElement(By.id(UIMapCheckOut.txtStoreSearch)).sendKeys(Keys.ENTER);
			Thread.sleep(10000);
			
			//Validate if 24 nearest stores are displayed
			boolean NoOfStores = selenium.isElementPresent(UIMapCheckOut.webElmntResult24);
			if(NoOfStores)
			{
				report.updateTestLog("Validating the display of 24 Store results", 
						"24 nearest Stores are displayed",Status.PASS);
			}
			else
			{
				report.updateTestLog("Validating the display of 24 Store results", 
						"24 nearest Stores are not displayed",Status.FAIL);
			}
			
			//click on Show Details link
			//driver.findElement(By.xpath("//*[@id='LowesStoreLocator']/div[1]/div[1]/div[3]/div/div[1]/ol/li[1]/a/span")).click();
			ClickCustomize("xpath", UIMapCheckOut.lnkShowDetails);
			
			
			//verify the display of details
			String ShowDetailsTxt = driver.findElement(By.xpath(UIMapCheckOut.webElmntResult1)).getText();
			//System.out.println(ShowDetailsTxt);
			if ( (ShowDetailsTxt.contains("Store")) & 
					(ShowDetailsTxt.contains("Phone:")) & 
					(ShowDetailsTxt.contains("Fax:")) & 
					(ShowDetailsTxt.contains("Make This Your Store")) & 
					(ShowDetailsTxt.contains("Get Directions")) & 
					(ShowDetailsTxt.contains("Hide Details")))
			{
				report.updateTestLog("Validating display of details after clicking on Show details",
						"Details are displayed", Status.PASS);
			
			}	
			else
			{
				report.updateTestLog("Validating display of details after clicking on Show details",
						"Details are not displayed", Status.FAIL);
			}
			
			//Click on "Get Directions"
			ClickCustomize("xpath", UIMapCheckOut.lnkGetDirections);
			Thread.sleep(4000);
			//driver.findElement(By.xpath(UIMapCheckOut.lnkGetDirections)).click();
			// get Directions box display
			boolean getDirectionsBox = driver.findElement(By.xpath(UIMapCheckOut.webElmntGetDirectionsBox)).isDisplayed();
			if(getDirectionsBox)
			{
				//The Store we selected should be populated in the "To" box.
				String getDirectionsToTxt = driver.findElement(By.id(UIMapCheckOut.txtToStore)).getAttribute("value");
				//String getDirectionsToTxt = driver.findElement(By.id("SL-map-directions-to")).getText();	
				System.out.println(getDirectionsToTxt);
				if ( (getDirectionsToTxt.contains(dataTable.getData("General_Data","zipcode"))))
						{
					report.updateTestLog("Validating display of selected store in the 'B' Box",
							"Selected store is displayed in the 'B' Box", Status.PASS);
						}
				else
				{
					report.updateTestLog("Validating display of selected store in the 'B' Box",
							"Selected store is not displayed in the 'B' Box", Status.FAIL);
				}
				//display of reverse directions button
				boolean reverseDirBttn = driver.findElement(By.id(
				UIMapCheckOut.btnReverseDirections)).isDisplayed();
				if (reverseDirBttn)
				{
					report.updateTestLog("Validating display of reverse Directions button",
							"reverse directions is displayed in the 'B' Box", Status.PASS);
						}
				
				else
				{
					report.updateTestLog("Validating display of reverse Directions button",
							"reverse directions is not displayed in the 'B' Box", Status.FAIL);
				}
			
			//Enter a "From " address and click on "Get Directions"
			driver.findElement(By.id(UIMapCheckOut.txtFromStore)).clear();
			driver.findElement(By.id(UIMapCheckOut.txtFromStore)).sendKeys(
					dataTable.getData("General_Data","NewStore"));
			//driver.findElement(By.id(UIMapCheckOut.btnGetDirections)).click();
			ClickCustomize("id", UIMapCheckOut.btnGetDirections);
			Thread.sleep(10000);
			String drivingDirections = driver.findElement(By.xpath(
					UIMapCheckOut.lblDrivingDirectionsHd)).getText();
			System.out.println(drivingDirections);
			if ( (drivingDirections.contains("Driving Directions to")))
			{
			report.updateTestLog("Validating display of Driving directions",
						"Driving directions are displayed ", Status.PASS);
			}
			else
			{
				report.updateTestLog("Validating display of Driving directions",
						"Driving directions are not displayed", Status.FAIL);
			}
			//print button is enabled or not
			boolean printBttn = driver.findElement(By.xpath(
			UIMapCheckOut.btnPrint)).isEnabled();
		
			if (printBttn)
			{
				report.updateTestLog("Validating Print button",
						"Print button is enabled", Status.PASS);
			}
			else
			{
				report.updateTestLog("Validating Print button",
						"Print button not enabled", Status.FAIL);
			}
			
			//Reverse directions
			//driver.findElement(By.id(UIMapCheckOut.btnReverseDirections)).click();
			ClickCustomize("id", UIMapCheckOut.btnReverseDirections);
			Thread.sleep(10000);
			String s1 = driver.findElement(By.id(UIMapCheckOut.txtFromStore)).getAttribute("value");
			String s2 = driver.findElement(By.id(UIMapCheckOut.txtToStore)).getAttribute("value");
			if ((s1.contains(dataTable.getData("General_Data","zipcode"))) & 
					(s2.contains(dataTable.getData("General_Data","NewStore"))))
				{
				report.updateTestLog("Validating the reverse directions functionality",
						"Directions are reversed", Status.PASS);	
				}
			else
				{
				report.updateTestLog("Validating the reverse directions functionality",
						"Directions are not reversed", Status.FAIL);
				}
			
			//back to Store Search link
			boolean BackToStoreSearch = driver.findElement(By.xpath(
			UIMapCheckOut.lnkBackToStoreSearch)).isDisplayed();
			if (BackToStoreSearch)
			{
				//driver.findElement(By.xpath(UIMapCheckOut.lnkBackToStoreSearch)).click();
				ClickCustomize("xpath", UIMapCheckOut.lnkBackToStoreSearch);
				Thread.sleep(2000);
				selenium.waitForPageToLoad("20000");
								
			}
			else
			{
				report.updateTestLog("Validating display of back to Store Search link",
						"back to Store Search link is not displayed in the 'B' Box", Status.FAIL);
			}
			
			
			
			}
			else
			{
				report.updateTestLog("Validating display of Get Directions Box",
						"Get Directions Box is not displayed", Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Validating the display of Store Locator page", 
					"Store Locator page is not displayed",Status.FAIL);
		}
	}
 
/**This function stores Item Name in data sheet***/
 public void storeItemName() throws Exception
 {
	 String varItemName=driver.findElement(By.xpath(UIMapProductSearch.webElmntProductName)).getText();
	 dataTable.putData("General_Data", "ItemName", varItemName);
 }
 
 /****
 * This function checks whether Product Text is displayed only once under LTD in Shipping Options Page
 */
 public void checkPrdctTxtUnderLTDShippingOptions() throws Exception
 {
	 String ltdShippingOptionsProduct="Product:";
	 int count1=0;
	 String ltdProductName=dataTable.getData("General_Data", "ItemName");
	 System.out.println(ltdProductName);
	 int count2=0;
	 String ltdShippingOptionsTxtDisp=driver.findElement(By.xpath(UIMapCheckOut.lblLTDTxt)).getText();
	 System.out.println(ltdShippingOptionsTxtDisp);
	 Pattern r = Pattern.compile(ltdShippingOptionsProduct);
		Matcher m = r.matcher(ltdShippingOptionsTxtDisp);
		while(m.find())
			count1++;
		System.out.println(count1);
		count2=(ltdShippingOptionsTxtDisp.length() - ltdShippingOptionsTxtDisp.replace(ltdProductName, "").length()) / ltdProductName.length();
		
		System.out.println(count2);
		if((count1==1) && (count2==1))
			report.updateTestLog("Checking Product text under LTD Shipping Options", "Product text Displayed ONCE under LTD Shipping Options", Status.PASS);
		else
			report.updateTestLog("Checking Product text under LTD Shipping Options", "Product text NOT Displayed ONCE under LTD Shipping Options", Status.FAIL);
		
 }
 
 /****Stores Order Nbr in Data sheet****/
 public void storeOrderNbrInDataSheet() throws Exception
 {
	 String varOrderNbrDisplayed=driver.findElement(By.cssSelector(UIMapCheckOut.lblOrderNbr)).getText();
	 System.out.println(varOrderNbrDisplayed);
	 dataTable.putData("General_Data", "OrderNbr", varOrderNbrDisplayed);
 }
 
 /***This function navigates to Purchases****/
 public void navigatePurchases() throws Exception
	{
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.id(UIMapMyLowes.lnkMyAccount));
		actions.moveToElement(menuHoverLink).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(2000);
		//WebElement subLink = driver.findElement(By.id(UIMapMyLowes.lnkHomeProfile));
		WebElement subLink = driver.findElement(By.partialLinkText("Purchases"));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		selenium.waitForPageToLoad("30000");
		
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.lblBreadCrumb3)).getText();
		System.out.println(varMyLowes);
		
		if (varMyLowes.contains("Purchase")) {
			report.updateTestLog("Clicking Your Account link-Purchases",
					"Purchases page displayed", Status.PASS);
		} else {
			report.updateTestLog("Clicking Your Account link-Purchases",
					"Purchases page NOT displayed", Status.FAIL);
		}
		
	}
 
 /***This function performs Find Purchase Operation for AZ User and validates whether entered Order nbr is In Process & Cancel Order Is Not Available***/
 public void cancelOrderSOMAZ() throws Exception
 {
	
	 driver.findElement(By.id(UIMapCheckOut.txtOrderSearch)).sendKeys(dataTable.getData("General_Data", "OrderNbr"));
	 driver.findElement(By.id(UIMapCheckOut.txtOrderSearch)).sendKeys(Keys.ENTER);
	 selenium.waitForPageToLoad("20000");
	 checkOrderStatus();
	 try{
		 driver.findElement(By.linkText("Cancel Order")).click();
		 Thread.sleep(5000);
		 report.updateTestLog("Clicking Cancel Order for SOM Orders", "Able to Cancel SOM Orders", Status.FAIL);
	 }
	 catch(Exception e)
	 {
		 report.updateTestLog("Clicking Cancel Order for SOM Orders", "Cancel Order button not displayed", Status.PASS);
	 }
 }
 
 
 /**Validates whether Order is in Status-In Process on Purchase Details**/
 public void checkOrderStatus() throws Exception
 {
	 String varStatus=driver.findElement(By.xpath(UIMapCheckOut.lblPurchaseStatus)).getText();
	 if(varStatus.equals(dataTable.getData("General_Data", "OrderStatus")))
		 report.updateTestLog("Checking Order status", "Order status-"+varStatus, Status.PASS);
	 else
		 report.updateTestLog("Checking Order status", "Order status NOT -"+dataTable.getData("General_Data", "OrderStatus"), Status.FAIL);
 }
 
 /**Validate whether Cancel Order is displayed for Logged In User for In Process Puchases**/
 public void cancelOrderSOMLI() throws Exception
 {
	
	ClickCustomize("linkText", dataTable.getData("General_Data", "OrderNbr"));
	 selenium.waitForPageToLoad("20000");
	 checkOrderStatus();
	 try{
		 driver.findElement(By.linkText("Cancel Order")).click();
		 Thread.sleep(5000);
		 report.updateTestLog("Clicking Cancel Order for SOM Orders", "Able to Cancel SOM Orders", Status.FAIL);
	 }
	 catch(Exception e)
	 {
		 report.updateTestLog("Clicking Cancel Order for SOM Orders", "Cancel Order button not displayed", Status.PASS);
	 }
 }
 
 public void changeStoreMH()throws Exception{
		//click on Change link on masthead
		//driver.findElement(By.xpath(UIMapCheckOut.lnkchngStore)).click();
		ClickCustomize("xpath", UIMapCheckOut.lnkchngStore);
		//check if change store pop-up is displayed
		boolean changeStorePopup = driver.findElement(By.id(UIMapCheckOut.webElmntchngStorePopup)).isDisplayed();
		if(changeStorePopup)
		{
			//enter new zipcode in pop-up
			driver.findElement(By.id(UIMapCheckOut.txtChngStoreSearch)).sendKeys(dataTable.getData("General_Data","zipcode"));
			Thread.sleep(10000);
			driver.findElement(By.id(UIMapCheckOut.txtChngStoreSearch)).sendKeys(Keys.ENTER);
			Thread.sleep(10000);
			
			//click on Make this yor store link
			//driver.findElement(By.xpath(UIMapCheckOut.lnkMakeThisYourStore)).click();
			ClickCustomize("xpath", UIMapCheckOut.lnkMakeThisYourStore);
			selenium.waitForPageToLoad("120000");
			
			//click on store info link
			//driver.findElement(By.xpath(UIMapCheckOut.lnkStoreInfo)).click();
			ClickCustomize("xpath", UIMapCheckOut.lnkStoreInfo);
			String StoreInfo = driver.findElement(By.id(UIMapCheckOut.webElmntStoreInfoPopup)).getText();
			System.out.println(StoreInfo);
			if (StoreInfo.contains(dataTable.getData("General_Data","zipcode")))
			{
				report.updateTestLog("Zipping Store","zipcode "+dataTable.getData(
						"General_Data","zipcode")+" Zipped successfully", Status.PASS);
			
			}	
			else
			{
				report.updateTestLog("Zipping Store","Store Not Zipped successfully", Status.FAIL);
			}	
									
		}
		else
		{
			System.out.println("Change Store pop is not displayed");
			report.updateTestLog("Zipping Store","Store Not Zipped successfully!!", Status.FAIL);
		}
				
	
	}
 
 /*** 
  * validates WAS Price Item on List & Details Page
  */
 public void verifyWasPriceInList() throws Exception
 {
	    String varNbrOfPages = driver.findElement(By.className(UIMapProductSearch.webElmntTotalPages)).getText();
		int varNbrOfPages2 = Integer.valueOf(varNbrOfPages);
		System.out.println(varNbrOfPages2);
		int i=0;
		for(i = 1;i<=varNbrOfPages2;i++)
		{
		if(selenium.isTextPresent("Item #: "+dataTable.getData("General_Data", "ItemNbr")))
		{
			List<WebElement> varProductList = driver.findElements(By.xpath(UIMapProductSearch.webElmntProductList2));
			int varCount = varProductList.size();
			int j;
			String varID=null;
			
			for(j=1;j<=varCount;j++)
			{
				//String varXPath= "//*[@id='productResults']/li["+i+"]";
				String varXPath= UIMapProductSearch.webElmntProductList2+"["+j+"]";
				varID = driver.findElement(By.xpath(varXPath)).getAttribute("id");
				System.out.println(varID);
				String varItemNbr=driver.findElement(By.xpath("//*[@id='"+varID+"']/div/div[4]/ul[1]/li[1]")).getText();
				System.out.println(varItemNbr);
				if(varItemNbr.contains("Item #: "+dataTable.getData("General_Data", "ItemNbr")))
				{
					dataTable.putData("General_Data", "WASPriceItemId", varID);
				}
				else
				{
					dataTable.putData("General_Data", "ItemId", varID);
				}
				if(!(dataTable.getData("General_Data", "WASPriceItemId").isEmpty()) && !(dataTable.getData("General_Data", "ItemId").isEmpty()))
				{
					System.out.println("Was Price item id:"+dataTable.getData("General_Data", "WASPriceItemId"));
					System.out.println("item id:"+dataTable.getData("General_Data", "ItemId"));
					break;
				}
			}
			String varItem=dataTable.getData("General_Data", "ItemId");
			//checking if Was Price displayed is correct for Item in list
			
			String varWasPriceItem=dataTable.getData("General_Data", "WASPriceItemId");
			try{
			String varWasPriceDisp=driver.findElement(By.xpath("//*[@id='"+varWasPriceItem+"']/div/div[3]/div[2]/p[1]")).getText();
			System.out.println("Was Price List:"+varWasPriceDisp);
			if(varWasPriceDisp.equals("Was: $"+dataTable.getData("General_Data", "PreviousPrice")))
				report.updateTestLog("Checking Was Price", "Previous Price displayed as Was Price", Status.PASS);
			else
				report.updateTestLog("Checking Was Price", "Previous Price NOT displayed as Was Price", Status.FAIL);
			}
			catch(Exception e)
			{
				report.updateTestLog("Checking Was Price", "Previous Price NOT displayed as Was Price", Status.FAIL);
			}
			//checking WAS price in Quick View
			
			ClickCustomize("xpath", "//*[@id='"+varWasPriceItem+"']/div/div[1]/a[2]");
			Thread.sleep(2000);
			try{
			String quickViewWasPrice=driver.findElement(By.xpath(UIMapCheckOut.lblQuickViewWasPrice)).getText();
			System.out.println("Quick View:"+quickViewWasPrice);
			/*String[] s=quickViewWasPrice.split("\\$");
			System.out.println(s[1]);
			if(s[1].equals())*/
			if(quickViewWasPrice.equals("Was: $"+dataTable.getData("General_Data", "PreviousPrice")))
				report.updateTestLog("Checking Was Price in Quick View", "Previous Price displayed as Was Price in Quick View", Status.PASS);
			else
				report.updateTestLog("Checking Was Price in Quick View", "Previous Price NOT displayed as Was Price in Quick View", Status.FAIL);
			}
			catch(Exception e)
			{
				report.updateTestLog("Checking Was Price in Quick View", "Previous Price NOT displayed as Was Price in Quick View", Status.FAIL);
			}
			driver.navigate().refresh();
			selenium.waitForPageToLoad("20000");
			
			Thread.sleep(2000);
			//selecting 2 products(inclusing Was price item) for comparison
			
			ClickCustomize("xpath", "//*[@id='"+varWasPriceItem+"']/div/div[1]/div/input");
			Thread.sleep(2000);
			ClickCustomize("xpath", "//*[@id='"+varItem+"']/div/div[1]/div/input");
			Thread.sleep(2000);
			ClickCustomize("xpath", UIMapCheckOut.btnCompare);
			selenium.waitForPageToLoad("20000");
			String varOrigPrice=driver.findElement(By.xpath(UIMapCheckOut.lblComprItem1OriginalPrice)).getText();
			System.out.println("Was price in comparison assistant:"+varOrigPrice);
			if(varOrigPrice.equals("$"+dataTable.getData("General_Data", "PreviousPrice")))
				report.updateTestLog("Checking Was Price in Comparison Assistant", "Previous Price displayed as Was Price in Comparison Assistant", Status.PASS);
			else
				report.updateTestLog("Checking Was Price in Comparison Assistant", "Previous Price NOT displayed as Was Price in Comparison Assistant", Status.FAIL);
			ClickCustomize("xpath", UIMapCheckOut.lnkComprItem1Name);
			selenium.waitForPageToLoad("20000");
			try{
				String varWasPricePD=driver.findElement(By.xpath(UIMapCheckOut.lblWasPricePD)).getText();
				System.out.println("Was price in PD:"+varWasPricePD);
				if(varWasPricePD.equals("Was: $"+dataTable.getData("General_Data", "PreviousPrice")))
					report.updateTestLog("Checking Was Price in Product Details", "Previous Price displayed as Was Price in Product Details", Status.PASS);
				else
					report.updateTestLog("Checking Was Price in Product Details", "Previous Price NOT displayed as Was Price in Product Details", Status.FAIL);
				}
		 	
				catch(Exception e)
				{
					report.updateTestLog("Checking Was Price in Product Details", "Previous Price NOT displayed as Was Price in Product Details", Status.FAIL);
				}
				break;
		}
		else
		{
			System.out.println("Item not found on page "+i);
			driver.findElement(By.partialLinkText("Next")).click();
			selenium.waitForPageToLoad("20000");
		}
		}
		if(i==(varNbrOfPages2+1))
		{
			report.updateTestLog("Finding Product","Product Not Found", Status.FAIL);
		} 
	 
 }
 
 /*** 
  * validates WAS Price Item on cart
  */
 public void verifyWasPriceInCart() throws Exception
 {
	    String varWasPricePD=driver.findElement(By.xpath(UIMapCheckOut.lblWasPriceCart)).getText();
		System.out.println("Was price in Cart:"+varWasPricePD);
		if(varWasPricePD.equals("Was $"+dataTable.getData("General_Data", "PreviousPrice")))
			report.updateTestLog("Checking Was Price On Cart Page", "Previous Price displayed as Was Price On Page", Status.PASS);
		else
			report.updateTestLog("Checking Was Price On Cart Page", "Previous Price NOT displayed as Was Price On Page", Status.FAIL);
 }
 
 /**validates whether Was Price is displayed on chkOut pages
  * 
  */
 public void verifyNoWasPriceOnPage() throws Exception
 {
	   
		if(selenium.isTextPresent("Was: $"+dataTable.getData("General_Data", "PreviousPrice")) || selenium.isTextPresent("$"+dataTable.getData("General_Data", "PreviousPrice")))
			report.updateTestLog("Checking Was Price On CheckOut/Order Confirmation Page", "Previous Price displayed as Was Price On CheckOut/Order Confirmation Page", Status.FAIL);
		else
			report.updateTestLog("Checking Was Price On CheckOut/Order Confirmation Page", "Previous Price NOT displayed as Was Price On CheckOut/Order Confirmation Page", Status.PASS);
 }
 
 /***This function validates Previous price is NOT displayed in pre cart Pages for Map Price products**/
 public void verifyMAPNoWasPreCart() throws Exception
 {
	 String varNbrOfPages = driver.findElement(By.className(UIMapProductSearch.webElmntTotalPages)).getText();
		int varNbrOfPages2 = Integer.valueOf(varNbrOfPages);
		System.out.println(varNbrOfPages2);
		int i=0;
		for(i = 1;i<=varNbrOfPages2;i++)
		{
		if(selenium.isTextPresent("Item #: "+dataTable.getData("General_Data", "ItemNbr")))
		{
			List<WebElement> varProductList = driver.findElements(By.xpath(UIMapProductSearch.webElmntProductList2));
			int varCount = varProductList.size();
			int j;
			String varID=null;
			
			for(j=1;j<=varCount;j++)
			{
				//String varXPath= "//*[@id='productResults']/li["+i+"]";
				String varXPath= UIMapProductSearch.webElmntProductList2+"["+j+"]";
				varID = driver.findElement(By.xpath(varXPath)).getAttribute("id");
				System.out.println(varID);
				String varItemNbr=driver.findElement(By.xpath("//*[@id='"+varID+"']/div/div[4]/ul[1]/li[1]")).getText();
				System.out.println(varItemNbr);
				if(varItemNbr.contains("Item #: "+dataTable.getData("General_Data", "ItemNbr")))
				{
					dataTable.putData("General_Data", "WASPriceItemId", varID);
				}
				else
				{
					dataTable.putData("General_Data", "ItemId", varID);
				}
				if(!(dataTable.getData("General_Data", "WASPriceItemId").isEmpty()) && !(dataTable.getData("General_Data", "ItemId").isEmpty()))
				{
					System.out.println("Was Price item id:"+dataTable.getData("General_Data", "WASPriceItemId"));
					System.out.println("item id:"+dataTable.getData("General_Data", "ItemId"));
					break;
				}
			}
			String varItem=dataTable.getData("General_Data", "ItemId");
			//checking if Was Price displayed is correct for Item in list
			
			String varWasPriceItem=dataTable.getData("General_Data", "WASPriceItemId");
			
			String varWasPriceDisp=driver.findElement(By.xpath("//*[@id='"+varWasPriceItem+"']/div/div[3]")).getText();
			System.out.println("Was Price List:"+varWasPriceDisp);
			if(varWasPriceDisp.contains("Was $"+dataTable.getData("General_Data", "PreviousPrice")))
			{
				report.updateTestLog("Checking Was Price", "Previous Price displayed as Was Price", Status.FAIL);
			}
			else
			{
				report.updateTestLog("Checking Was Price", "Previous Price NOT displayed as Was Price", Status.PASS);
			
			if(varWasPriceDisp.contains("View Price in Cart") && varWasPriceDisp.contains("MSRP:") )
				report.updateTestLog("Checking Price", "View Price in Cart & MSRP displayed", Status.PASS);
			else
				report.updateTestLog("Checking Price", "View Price in Cart & MSRP NOT displayed", Status.FAIL);
			}
		 	
			
			//checking WAS price in Quick View
			
			ClickCustomize("xpath", "//*[@id='"+varWasPriceItem+"']/div/div[1]/a[2]");
			Thread.sleep(2000);
			
			String quickViewWasPrice=driver.findElement(By.xpath(UIMapCheckOut.lblQuickViewMapPrice)).getText();
			System.out.println("Quick View:"+quickViewWasPrice);
			/*String[] s=quickViewWasPrice.split("\\$");
			System.out.println(s[1]);
			if(s[1].equals())*/
			if(quickViewWasPrice.contains("Was $"+dataTable.getData("General_Data", "PreviousPrice")))
			{
				report.updateTestLog("Checking Was Price in Quick View", "Previous Price displayed as Was Price in Quick View", Status.FAIL);
			}
			else
			{
				report.updateTestLog("Checking Was Price in Quick View", "Previous Price NOT displayed as Was Price in Quick View", Status.PASS);
			
			if(quickViewWasPrice.contains("View Price In Cart") && varWasPriceDisp.contains("MSRP:") )
				report.updateTestLog("Checking Price in Quick View", "View Price in Cart & MSRP displayed in Quick View", Status.PASS);
			else
				report.updateTestLog("Checking Price in Quick View", "View Price in Cart & MSRP NOT displayed in Quick View", Status.FAIL);
			}
			
			driver.navigate().refresh();
			selenium.waitForPageToLoad("20000");
			
			//selecting 2 products(inclusing Was price item) for comparison
			
			ClickCustomize("xpath", "//*[@id='"+varWasPriceItem+"']/div/div[1]/div/input");
			Thread.sleep(2000);
			ClickCustomize("xpath", "//*[@id='"+varItem+"']/div/div[1]/div/input");
			Thread.sleep(2000);
			ClickCustomize("xpath", UIMapCheckOut.btnCompare);
			selenium.waitForPageToLoad("20000");
			String varPrice=driver.findElement(By.xpath(UIMapCheckOut.lblComprItem1PriceMap)).getText();
			String varOrigPrice=driver.findElement(By.xpath(UIMapCheckOut.lblComprItem1OrigPriceMap)).getText();
			String varRetailPrice=driver.findElement(By.xpath(UIMapCheckOut.lblComprItem1RetailPrcMap)).getText();
			
			if(varPrice.equals("View Price in Cart"))
				report.updateTestLog("Checking Price in Comparison Assistant", "View Price in Cart displayed in Price", Status.PASS);
			else
				report.updateTestLog("Checking Price in Comparison Assistant", "View Price in Cart NOT displayed in Price", Status.FAIL);
			if(varOrigPrice.equals("- -"))
				report.updateTestLog("Checking Original Price in Comparison Assistant", "- - displayed in Original Price", Status.PASS);
			else
				report.updateTestLog("Checking Original Price in Comparison Assistant", "- - NOT displayed in Original Price", Status.FAIL);
			if(varRetailPrice.contains("$"))
				report.updateTestLog("Checking Retail Price in Comparison Assistant", "$ with value displayed in Retail Price", Status.PASS);
			else
				report.updateTestLog("Checking Retail Price in Comparison Assistant", "$ with value NOT displayed in Retail Price", Status.FAIL);
			
			
			ClickCustomize("xpath", UIMapCheckOut.lnkComprItem1Name);
			selenium.waitForPageToLoad("20000");
			
				String varWasPricePD=driver.findElement(By.xpath(UIMapCheckOut.lblPDMapPrice)).getText();
				System.out.println("Map price in PD:"+varWasPricePD);
				if(varWasPricePD.contains("Was $"+dataTable.getData("General_Data", "PreviousPrice")))
				{
					report.updateTestLog("Checking Was Price in Product Details", "Previous Price displayed as Was Price in Product Details", Status.FAIL);
				}
				else
				{
					report.updateTestLog("Checking Was Price in Product Details", "Previous Price NOT displayed as Was Price in Product Details", Status.PASS);
				
				if(varWasPricePD.contains("View Price in Cart") && varWasPriceDisp.contains("MSRP:") )
					report.updateTestLog("Checking Price in Product Details", "View Price in Cart & MSRP displayed in Product Details", Status.PASS);
				else
					report.updateTestLog("Checking Price in Product Details", "View Price in Cart & MSRP NOT displayed in Product Details", Status.FAIL);
				}
				
				break;
		}
		else
		{
			System.out.println("Item not found on page "+i);
			driver.findElement(By.partialLinkText("Next")).click();
			selenium.waitForPageToLoad("20000");
		}
		}
		if(i==(varNbrOfPages2+1))
		{
			report.updateTestLog("Finding Product","Product Not Found", Status.FAIL);
		} 
 }
 
 /**This function validates  that MAP is displayed as Was price when set as Override WAS price in Price Override Tool (i.e.Management Center) in all pre-cart pages for Employee User.**/
 public void verifyMapasWasForEMP() throws Exception
 {
	 String varNbrOfPages = driver.findElement(By.className(UIMapProductSearch.webElmntTotalPages)).getText();
		int varNbrOfPages2 = Integer.valueOf(varNbrOfPages);
		System.out.println(varNbrOfPages2);
		int i=0;
		for(i = 1;i<=varNbrOfPages2;i++)
		{
		if(selenium.isTextPresent("Item #: "+dataTable.getData("General_Data", "ItemNbr")))
		{
			List<WebElement> varProductList = driver.findElements(By.xpath(UIMapProductSearch.webElmntProductList2));
			int varCount = varProductList.size();
			int j;
			String varID=null;
			
			for(j=1;j<=varCount;j++)
			{
				//String varXPath= "//*[@id='productResults']/li["+i+"]";
				String varXPath= UIMapProductSearch.webElmntProductList2+"["+j+"]";
				varID = driver.findElement(By.xpath(varXPath)).getAttribute("id");
				System.out.println(varID);
				String varItemNbr=driver.findElement(By.xpath("//*[@id='"+varID+"']/div/div[4]/ul[1]/li[1]")).getText();
				System.out.println(varItemNbr);
				if(varItemNbr.contains("Item #: "+dataTable.getData("General_Data", "ItemNbr")))
				{
					dataTable.putData("General_Data", "WASPriceItemId", varID);
				}
				else
				{
					dataTable.putData("General_Data", "ItemId", varID);
				}
				if(!(dataTable.getData("General_Data", "WASPriceItemId").isEmpty()) && !(dataTable.getData("General_Data", "ItemId").isEmpty()))
				{
					System.out.println("Was Price item id:"+dataTable.getData("General_Data", "WASPriceItemId"));
					System.out.println("item id:"+dataTable.getData("General_Data", "ItemId"));
					break;
				}
			}
			String varItem=dataTable.getData("General_Data", "ItemId");
			//checking if Map Price is displayed as Was Price for Item in list
			
			String varWasPriceItem=dataTable.getData("General_Data", "WASPriceItemId");
			
			String varWasPriceDisp=driver.findElement(By.xpath("//*[@id='"+varWasPriceItem+"']/div/div[3]")).getText();
			System.out.println("Was Price List:"+varWasPriceDisp);
			if(varWasPriceDisp.contains("View Price in Cart") && varWasPriceDisp.contains("MSRP:") )
				report.updateTestLog("Checking Price", "View Price in Cart & MSRP displayed", Status.FAIL);
			else
			{
				report.updateTestLog("Checking Price", "View Price in Cart & MSRP NOT displayed", Status.PASS);
			if(varWasPriceDisp.contains("Was $"+dataTable.getData("General_Data", "MapPrice")))
			{
				report.updateTestLog("Checking Was Price", "MAP Price displayed as Was Price", Status.FAIL);
			}
			else
			{
				report.updateTestLog("Checking Was Price", "MAP Price NOT displayed as Was Price", Status.PASS);
			}
			}
		 	
			
			//checking WAS price in Quick View
			
			ClickCustomize("xpath", "//*[@id='"+varWasPriceItem+"']/div/div[1]/a[2]");
			Thread.sleep(2000);
			
			String quickViewWasPrice=driver.findElement(By.xpath(UIMapCheckOut.lblQuickViewMapPrice)).getText();
			System.out.println("Quick View:"+quickViewWasPrice);
			/*String[] s=quickViewWasPrice.split("\\$");
			System.out.println(s[1]);
			if(s[1].equals())*/
			if(quickViewWasPrice.contains("View Price In Cart") && varWasPriceDisp.contains("MSRP:") )
				report.updateTestLog("Checking Price in Quick View", "View Price in Cart & MSRP displayed in Quick View", Status.FAIL);
			else
			{
				report.updateTestLog("Checking Price in Quick View", "View Price in Cart & MSRP NOT displayed in Quick View", Status.PASS);
			if(quickViewWasPrice.contains("Was $"+dataTable.getData("General_Data", "MapPrice")))
			{
				report.updateTestLog("Checking Was Price in Quick View", "MAP Price displayed as Was Price in Quick View", Status.FAIL);
			}
			else
			{
				report.updateTestLog("Checking Was Price in Quick View", "MAP Price NOT displayed as Was Price in Quick View", Status.PASS);
			
			}
			}
			
			driver.navigate().refresh();
			selenium.waitForPageToLoad("20000");
			
			//selecting 2 products(inclusing Was price item) for comparison
			
			ClickCustomize("xpath", "//*[@id='"+varWasPriceItem+"']/div/div[1]/div/input");
			Thread.sleep(2000);
			ClickCustomize("xpath", "//*[@id='"+varItem+"']/div/div[1]/div/input");
			Thread.sleep(2000);
			ClickCustomize("xpath", UIMapCheckOut.btnCompare);
			selenium.waitForPageToLoad("20000");
			String varPrice=driver.findElement(By.xpath(UIMapCheckOut.lblComprItem1PriceMap)).getText();
			String varOrigPrice=driver.findElement(By.xpath(UIMapCheckOut.lblComprItem1OrigPriceMap)).getText();
			
			
			if(varPrice.equals("View Price in Cart"))
				report.updateTestLog("Checking Price in Comparison Assistant", "View Price in Cart displayed in Price", Status.FAIL);
			else
				report.updateTestLog("Checking Price in Comparison Assistant", "View Price in Cart NOT displayed in Price", Status.PASS);
			if(varOrigPrice.equals("$"+dataTable.getData("General_Data", "MapPrice")))
				report.updateTestLog("Checking Was Price in Comparison Assistant", "MAP Price displayed as Was Price in Comparison Assistant", Status.PASS);
			else
				report.updateTestLog("Checking Was Price in Comparison Assistant", "MAP Price NOT displayed as Was Price in Comparison Assistant", Status.FAIL);
			
			
			
			ClickCustomize("xpath", UIMapCheckOut.lnkComprItem1Name);
			selenium.waitForPageToLoad("20000");
			
				String varWasPricePD=driver.findElement(By.xpath(UIMapCheckOut.lblPDMapPrice)).getText();
				System.out.println("Map price in PD:"+varWasPricePD);
				if(varWasPricePD.contains("View Price in Cart") && varWasPriceDisp.contains("MSRP:") )
					report.updateTestLog("Checking Price in Product Details", "View Price in Cart & MSRP displayed in Product Details", Status.FAIL);
				else
				{
					report.updateTestLog("Checking Price in Product Details", "View Price in Cart & MSRP NOT displayed in Product Details", Status.PASS);
				if(varWasPricePD.contains("Was $"+dataTable.getData("General_Data", "MapPrice")))
				{
					report.updateTestLog("Checking Was Price in Product Details", "MAP Price displayed as Was Price in Product Details", Status.FAIL);
				}
				else
				{
					report.updateTestLog("Checking Was Price in Product Details", "MAP Price NOT displayed as Was Price in Product Details", Status.PASS);
				
				}
				}
				
				break;
		}
		else
		{
			System.out.println("Item not found on page "+i);
			driver.findElement(By.partialLinkText("Next")).click();
			selenium.waitForPageToLoad("20000");
		}
		}
		if(i==(varNbrOfPages2+1))
		{
			report.updateTestLog("Finding Product","Product Not Found", Status.FAIL);
		} 
 }
 
 /**
  * This function validates whether Savings Round Off to nearest Integer is correctly displayed in all pages
  * @throws Exception
  */
 public void chkSavingsRoundOff() throws Exception
 {
	 String varNbrOfPages = driver.findElement(By.className(UIMapProductSearch.webElmntTotalPages)).getText();
		int varNbrOfPages2 = Integer.valueOf(varNbrOfPages);
		System.out.println(varNbrOfPages2);
		int i=0;
		double varCurrentPrice=Double.valueOf(dataTable.getData("General_Data", "CurrentPrice"));
		double varPrevPrice=Double.valueOf(dataTable.getData("General_Data", "PreviousPrice"));
		double savePercent=((varPrevPrice-varCurrentPrice)/varPrevPrice)*100;
		
		int varSavings=(int) Math.round(savePercent);
		System.out.println(varSavings);
		for(i = 1;i<=varNbrOfPages2;i++)
		{
		if(selenium.isTextPresent("Item #: "+dataTable.getData("General_Data", "ItemNbr")))
		{
			List<WebElement> varProductList = driver.findElements(By.xpath(UIMapProductSearch.webElmntProductList2));
			int varCount = varProductList.size();
			int j;
			String varID=null;
			
			for(j=1;j<=varCount;j++)
			{
				//String varXPath= "//*[@id='productResults']/li["+i+"]";
				String varXPath= UIMapProductSearch.webElmntProductList2+"["+j+"]";
				varID = driver.findElement(By.xpath(varXPath)).getAttribute("id");
				System.out.println(varID);
				String varItemNbr=driver.findElement(By.xpath("//*[@id='"+varID+"']/div/div[4]/ul[1]/li[1]")).getText();
				System.out.println(varItemNbr);
				if(varItemNbr.contains("Item #: "+dataTable.getData("General_Data", "ItemNbr")))
				{
					dataTable.putData("General_Data", "WASPriceItemId", varID);
				}
				else
				{
					dataTable.putData("General_Data", "ItemId", varID);
				}
				if(!(dataTable.getData("General_Data", "WASPriceItemId").isEmpty()) && !(dataTable.getData("General_Data", "ItemId").isEmpty()))
				{
					System.out.println("Was Price item id:"+dataTable.getData("General_Data", "WASPriceItemId"));
					System.out.println("item id:"+dataTable.getData("General_Data", "ItemId"));
					break;
				}
			}
			String varItem=dataTable.getData("General_Data", "ItemId");
			//checking if Was Price displayed is correct for Item in list
			
			String varWasPriceItem=dataTable.getData("General_Data", "WASPriceItemId");
			try{
			String varWasPriceDisp=driver.findElement(By.xpath("//*[@id='"+varWasPriceItem+"']/div/div[3]/div[2]/p[2]")).getText();
			System.out.println("Savings List:"+varWasPriceDisp);
			if(varWasPriceDisp.contains("Save  "+varSavings+"%"))
				report.updateTestLog("Checking Savings", "Savings rounded off to nearest Integer", Status.PASS);
			else
				report.updateTestLog("Checking Savings", "Savings NOT rounded off to nearest Integer", Status.FAIL);
			}
			catch(Exception e)
			{
				report.updateTestLog("Checking Savings", "Savings NOT displayed", Status.FAIL);
			}
			//checking WAS price in Quick View
			
			ClickCustomize("xpath", "//*[@id='"+varWasPriceItem+"']/div/div[1]/a[2]");
			Thread.sleep(2000);
			try{
			String quickViewWasPrice=driver.findElement(By.xpath(UIMapCheckOut.lblQuickViewSavePercent)).getText();
			System.out.println("Quick View:"+quickViewWasPrice);
			/*String[] s=quickViewWasPrice.split("\\$");
			System.out.println(s[1]);
			if(s[1].equals())*/
			if(quickViewWasPrice.contains("Save "+varSavings+"%"))
				report.updateTestLog("Checking Savings in Quick View", "Savings rounded off to nearest Integer in Quick View", Status.PASS);
			else
				report.updateTestLog("Checking Savings in Quick View", "Savings NOT rounded off to nearest Integer in Quick View", Status.FAIL);
			}
			catch(Exception e)
			{
				report.updateTestLog("Checking Savings in Quick View", "Savings NOT displayed in Quick View", Status.FAIL);
			}
			driver.navigate().refresh();
			selenium.waitForPageToLoad("20000");
			
			Thread.sleep(2000);
			//selecting 2 products(inclusing Was price item) for comparison
			
			ClickCustomize("xpath", "//*[@id='"+varWasPriceItem+"']/div/div[1]/div/input");
			Thread.sleep(2000);
			ClickCustomize("xpath", "//*[@id='"+varItem+"']/div/div[1]/div/input");
			Thread.sleep(2000);
			ClickCustomize("xpath", UIMapCheckOut.btnCompare);
			selenium.waitForPageToLoad("20000");
			String varOrigPrice=driver.findElement(By.xpath(UIMapCheckOut.lblComprItem1Savings)).getText();
			System.out.println("Savings in comparison assistant:"+varOrigPrice);
			if(varOrigPrice.contains(varSavings+"% Savings"))
				report.updateTestLog("Checking Savings in Comparison Assistant", "Savings rounded off to nearest Integer in Comparison Assistant", Status.PASS);
			else
				report.updateTestLog("Checking Savings in Comparison Assistant", "Savings rounded off to nearest Integer in Comparison Assistant", Status.FAIL);
			ClickCustomize("xpath", UIMapCheckOut.lnkComprItem1Name);
			selenium.waitForPageToLoad("20000");
			try{
				String varWasPricePD=driver.findElement(By.xpath(UIMapCheckOut.lblWasPriceSavingsPD)).getText();
				System.out.println("Was price in PD:"+varWasPricePD);
				if(varWasPricePD.contains("Save "+varSavings+"%"))
					report.updateTestLog("Checking Savings in Product Details", "Savings rounded off to nearest Integer in Product Details", Status.PASS);
				else
					report.updateTestLog("Checking Savings in Product Details", "Savings NOT rounded off to nearest Integer in Product Details", Status.FAIL);
				co.clickCheckOutFromDetails();
				co.clickCheckOut();
				String varWasPriceCart=driver.findElement(By.xpath(UIMapCheckOut.lblUPSavingsCart)).getText();
				System.out.println("Savings in Cart:"+varWasPriceCart);
				if(varWasPriceCart.contains("Save "+varSavings+"%"))
					report.updateTestLog("Checking Savings in Cart", "Savings rounded off to nearest Integer in Cart", Status.PASS);
				else
					report.updateTestLog("Checking Savings in Cart", "Savings NOT rounded off to nearest Integer in Cart", Status.FAIL);
			
			}
		 	
				catch(Exception e)
				{
					report.updateTestLog("Checking Savings in Product Details", "Savings NOT displayed in Product Details", Status.FAIL);
				}
				break;
		}
		else
		{
			System.out.println("Item not found on page "+i);
			driver.findElement(By.partialLinkText("Next")).click();
			selenium.waitForPageToLoad("20000");
		}
		}
		if(i==(varNbrOfPages2+1))
		{
			report.updateTestLog("Finding Product","Product Not Found", Status.FAIL);
		} 
 }
 
 /***
  * This function selects delivery option for RTF item in cart
  */
 public void selectDeliveryOptionCartRTF() throws Exception
 {
	 String varId=dataTable.getData("General_Data", "RTFItemId");
	 dataTable.putData("General_Data", "ItemId", varId);
	 co.selectDeliveryOptionCart();
 }
 
 /**
  * This function validates Error message and succesful registration when LAR is invalid and user selected 
  * I want a free lowes acct
  */
 public void checkRevPayOnSimpleRegistrationInvalidLAR() throws Exception
 {
	 chkText(UIMapCheckOut.lblRevPayError, "An invalid credit card number was entered. For security purposes, please re-enter your payment information. For further assistance, contact Lowe's Customer Care at 1-800-890-5932 and reference error code -9.");
	 chkText(UIMapFunctionalComponents.webElmntSalutation, "Welcome, "+dataTable.getData("General_Data", "BillFirstname"));
 }
 
 /**
  * enters LAR Card details
  */
 public void checkOutUsingLAR() throws Exception
	{
		try{driver.findElement(By.name(UIMapMyLowes.txtCardNickName)).clear();
		driver.findElement(By.name(UIMapMyLowes.txtCardNickName)).sendKeys(dataTable.getData("General_Data", "nickName"));
		}
		catch(Exception e)
		{
			System.out.println("No NickName field");
		}
		////Expiration Fields validation
		new Select(driver.findElement(By.id(UIMapMyLowes.drpDownChkOutType))).selectByVisibleText(dataTable.getData("General_Data","cardType"));
		Thread.sleep(4000);
		
		//Entering invalid Card Number
		driver.findElement(By.name(UIMapMyLowes.txtCheckOutCreditCardNo)).clear();
		driver.findElement(By.name(UIMapMyLowes.txtCheckOutCreditCardNo)).sendKeys(dataTable.getData("General_Data", "crditCardNo"));
		driver.findElement(By.id(UIMapMyLowes.txtSCode)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtSCode)).sendKeys(dataTable.getData("General_Data", "security code"));
		
	}
 
 public void clickCheckOutInReviewPage()throws Exception{
		
		//click checkout button
	    driver.findElement(By.xpath(UIMapMyLowes.btnSecureCheckOut)).click();
	    selenium.waitForPageToLoad("120000");
		
		//USPS Confirmation for final check out
		
	}
 /**
  * validates that employee savings are not included in gift cards for employees
  */
 public void chkEmployeeSavingsGC() throws Exception
 {
	 String varGCUnitPrice=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "GiftCardItemId")+"']/div[2]/div[4]")).getText();
	 if(!varGCUnitPrice.contains("Employee Savings"))
		 report.updateTestLog("Checking Employee Savings for Gift Card", "Employee Savings Not Displayed for Gift Card", Status.PASS);
	 else
		 report.updateTestLog("Checking Employee Savings for Gift Card", "Employee Savings Displayed for Gift Card", Status.FAIL);
 }
 
/**
 * Stores Unit Price of an item for regular User
 */
 public void storeUnitPrice() throws Exception
 {
	 String varUnitPrice=driver.findElement(By.xpath(UIMapCheckOut.lblItemUnitPrice)).getText();
	 String varUPAfterDollar=varUnitPrice.substring(1);
	 dataTable.putData("General_Data", "UnitPrice", varUPAfterDollar);
	 driver.get(baseurl);
}
 /**
  * validates Savings and You Save amt include Employee Savings for WAS Item
  */
 public void chkSavingsYouSaveForWasPrcItemEMP() throws Exception
 {
	 fc.searchItem();
	 String varUnitPriceOld=dataTable.getData("General_Data", "UnitPrice");
	// 
	 String varEmpSavePercentDisp=driver.findElement(By.xpath(UIMapCheckOut.lblWasPriceSavePercnt)).getText();
	 String s2=varEmpSavePercentDisp.substring(9);
	 String[] s3=s2.split("\\%");
	 String varEmpSavePercent=s3[0];
	 double varEmpSavePercentDbl=Double.valueOf(varEmpSavePercent);
	 System.out.println("Employee Savings percent:"+varEmpSavePercentDbl);
	 co.clickCheckOutFromDetails();
	 co.clickCheckOut();
	 String varWasPrice=driver.findElement(By.xpath(UIMapCheckOut.lblWasPriceCart)).getText();
	 if(varWasPrice.contains("Was $"))
	 {
		 report.updateTestLog("Checkin Was Price", "Was Price displayed", Status.PASS);
		 String varWasPriceAfterDollar=varWasPrice.substring(5);
		 double varWasPriceDbl=Double.valueOf(varWasPriceAfterDollar);
		 double varUnitPriceOldDbl=Double.valueOf(varUnitPriceOld);
		 System.out.println("Old Unit Price:"+varUnitPriceOldDbl);
		 double varUnitPriceNewExpDbl=(varUnitPriceOldDbl-((varEmpSavePercentDbl/100)*varUnitPriceOldDbl));
		 System.out.println("Expected new unit price:"+varUnitPriceNewExpDbl);
		 double roundOff = (double) Math.round(varUnitPriceNewExpDbl * 100) / 100;
		 String varUnitPriceExp=String.format("%.2f", roundOff);
		 String varUnitPriceNew=driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[4]/div/div")).getText();
		 System.out.println(varUnitPriceExp+"::"+varUnitPriceNew);
		 if(varUnitPriceNew.equals("$"+varUnitPriceExp))
		 {
			 report.updateTestLog("Checking Unit Price", "Unit Price includes Employee Savings", Status.PASS);
			 Double dblPercntExp=((varWasPriceDbl-roundOff)/varWasPriceDbl)*100;
			 int i = (int)Math.round(dblPercntExp);
			 int j=i+1;
			 String varSavingsCart=driver.findElement(By.xpath(UIMapCheckOut.lblUPSavingsCart)).getText();
			 System.out.println(i);
			 System.out.println(j);
			 System.out.println(varSavingsCart);
			 if((varSavingsCart.equals("Total Savings of "+i+"% Including Employee Savings")) || (varSavingsCart.equals("Total Savings of  "+j+"% Including Employee Savings")))
				 report.updateTestLog("Checking Saving Percent", "Saving Percent Correct", Status.PASS);
			 else
				 report.updateTestLog("Checking Saving Percent", "Saving Percent NOT Correct", Status.FAIL);
			 
			 double varYouSaveExpDbl=varUnitPriceOldDbl-roundOff;
			 double roundOff2 = (double) Math.round(varYouSaveExpDbl * 100) / 100;
			 String varYouSaveExp=String.format("%.2f", roundOff2);
			 String varYouSaveDisp=driver.findElement(By.xpath(UIMapCheckOut.lblCartSummaryYouSaveAmt)).getText();
			 System.out.println(varYouSaveExp+"::"+varYouSaveDisp);
			 if(varYouSaveDisp.equals("$"+varYouSaveExp))
				 report.updateTestLog("Checking You Save Amount", "You Save Amount correct", Status.PASS);
			 else
				 report.updateTestLog("Checking You Save Amount", "You Save Amount NOT correct", Status.FAIL);
		 }
		 else
			 report.updateTestLog("Checking Unit Price", "Unit Price DOES NOT include Employee Savings", Status.FAIL);
	 }
     else
		 report.updateTestLog("Checkin Was Price", "Was Price NOT displayed", Status.FAIL);
	 
 }
 
 /**
  * validates Employee Savings and You Save amt include Employee Savings for Retail Item
  */
 public void chkSavingsYouSaveForRetailItemEMP() throws Exception
 {
	 String varEmpSavings=null;
	 try{
	 String varEmpSavingsDisp=driver.findElement(By.xpath(UIMapCheckOut.lblUPSavingsCart)).getText();
	 System.out.println(varEmpSavingsDisp);
	 String pattern = "(\\d+)\\% Employee Savings";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(varEmpSavingsDisp);
		if(m.find())
		{
			report.updateTestLog("Checking Employee Savings", "Employee Savings correctly displayed", Status.PASS);
			varEmpSavings=m.group(1);
		}
		else
			report.updateTestLog("Checking Employee Savings", "Employee Savings NOT correctly displayed", Status.FAIL);
	 }
	 catch(Exception e)
	 {
		 report.updateTestLog("Checking Employee Savings", "Employee Savings NOT displayed", Status.FAIL);
	 }
	 
	 String varUP=driver.findElement(By.xpath(UIMapCheckOut.lblUnitPriceCart)).getText();
	 String[] s=varUP.split("Retail: \\$");
	 System.out.println(s[1]);
	 String[] s2=s[1].split(" ");
	 System.out.println(s2[0]);
	 String varRetailPrc=s2[0];
	 double dblRetailPrc=Double.valueOf(varRetailPrc);
	 double dblEmpSavePercnt=Double.valueOf(varEmpSavings);
	 double dblYouSave=(dblEmpSavePercnt/100)*dblRetailPrc;
	 double roundOff = (double) Math.round(dblYouSave * 100) / 100;
	 String varYouSaveExp=String.format("%.2f", roundOff);
	 String varYouSaveDisp=driver.findElement(By.xpath(UIMapCheckOut.lblCartSummaryYouSaveAmt)).getText();
	 System.out.println(varYouSaveExp+";;"+varYouSaveDisp);
	 if(varYouSaveDisp.equals("$"+varYouSaveExp))
		 report.updateTestLog("Checking You Save Amount", "You Save Amount correct", Status.PASS);
	 else
		 report.updateTestLog("Checking You Save Amount", "You Save Amount NOT correct", Status.FAIL);
 }
 
 /**
  * This function validates whether added US Remote Territory addres is displayed in Ship To section
  * on Review & Pay Page
  */
 public void chkShipToTerritoryAddrssRevPay() throws Exception
 {
	 String varShipToAddrss=driver.findElement(By.xpath(UIMapCheckOut.lblShipToRevPay)).getText();
	 if(varShipToAddrss.contains(dataTable.getData("General_Data", "City")+", "+dataTable.getData("General_Data", "StateShortForm")+" "+dataTable.getData("General_Data", "zipcode")))
			 report.updateTestLog("Checking Added Remote territory address In Ship To", "Added Remote territory address DISPLAYED In Ship To", Status.FAIL);
	 else
		 report.updateTestLog("Checking Added Remote territory address In Ship To", "Added Remote territory address NOT displayed In Ship To", Status.PASS);
 }
 
//added 03/27
 /**Checks Savings Percentage for InStore Only Was Prc/Sq Ft. Prc Items**/
 public void chkSavingsToggleOnInStoreSqFtPP() throws Exception
 {
	    String varNbrOfPages = driver.findElement(By.className(UIMapProductSearch.webElmntTotalPages)).getText();
			int varNbrOfPages2 = Integer.valueOf(varNbrOfPages);
			System.out.println(varNbrOfPages2);
			int i=0;
			for(i = 1;i<=varNbrOfPages2;i++)
			{
			if(selenium.isTextPresent("Item #: "+dataTable.getData("General_Data", "ItemNbr")))
			{
				List<WebElement> varProductList = driver.findElements(By.xpath(UIMapProductSearch.webElmntProductList2));
				int varCount = varProductList.size();
				int j;
				String varID=null;
				
				for(j=1;j<=varCount;j++)
				{
					//String varXPath= "//*[@id='productResults']/li["+i+"]";
					String varXPath= UIMapProductSearch.webElmntProductList2+"["+j+"]";
					varID = driver.findElement(By.xpath(varXPath)).getAttribute("id");
					System.out.println(varID);
					String varItemNbr=driver.findElement(By.xpath("//*[@id='"+varID+"']/div/div[4]/ul[1]/li[1]")).getText();
					System.out.println(varItemNbr);
					if(varItemNbr.contains("Item #: "+dataTable.getData("General_Data", "ItemNbr")))
					{
						dataTable.putData("General_Data", "WASPriceItemId", varID);
						break;
					}
					
				}
				
				String varWasPriceItem=dataTable.getData("General_Data", "WASPriceItemId");
				
				String varWasPriceDisp=driver.findElement(By.xpath("//*[@id='"+varWasPriceItem+"']/div/div[3]")).getText();
				System.out.println("Was Price List:"+varWasPriceDisp);
				if(varWasPriceDisp.contains("Save "))
					report.updateTestLog("Checking Price in List page", "Savings displayed", Status.FAIL);
				else
					report.updateTestLog("Checking Price in List page", "Savings Not Displayed", Status.PASS);
				ClickCustomize("xpath", "//*[@id='"+varWasPriceItem+"']/div/div[2]/h3/a");
				selenium.waitForPageToLoad("20000");
				
				//Savings Calculation
				double varCurrentLinearPrice=Double.valueOf(dataTable.getData("General_Data", "PreviousPurchasePrc"));
				double varPrevLinearPrice=Double.valueOf(dataTable.getData("General_Data", "PurchasePrc"));
				double savePercent=((varPrevLinearPrice-varCurrentLinearPrice)/varPrevLinearPrice)*100;
				
				int varSavings=(int) Math.round(savePercent);
				//details page
				String varPrcDisp=driver.findElement(By.xpath(UIMapCheckOut.lblPricingDetail)).getText();
				System.out.println(varPrcDisp);
				if(varPrcDisp.contains("Save "+varSavings+"%"))
					report.updateTestLog("Checking Savings in Detail Page", "Savings Roundoff to last integer", Status.PASS);
				else
					report.updateTestLog("Checking Savings in Detail Page", "Savings NOT Roundoff to last integer", Status.FAIL);
			}
			else
			{
				System.out.println("Item not found on page "+i);
				driver.findElement(By.partialLinkText("Next")).click();
				selenium.waitForPageToLoad("20000");
			}
			}
			if(i==(varNbrOfPages2+1))
			{
				report.updateTestLog("Finding Product","Product Not Found", Status.FAIL);
			}
 	}
 

 
 
 /**Checks Savings in Pricing Area for Was Price/Retail Price/Savings in cart for Employee**/
 public void chkSavingsInCartEmp() throws Exception
 {
	 String varId=dataTable.getData("General_Data", "ItemId");
	 String varName=dataTable.getData("General_Data", "ItemName");
	 System.out.println(varId);
	 String varUnitPrc=driver.findElement(By.xpath("//*[@id='item_"+varId+"']/div[2]/div[4]/div[1]/div")).getText();
	 varUnitPrc=varUnitPrc.substring(1);
	 String varType=dataTable.getData("General_Data", "ItemType");
	 System.out.println(varType);
	 if(varType.equals("Retail"))
	 {
		 String varOldPrc=driver.findElement(By.xpath("//*[@id='item_"+varId+"']/div[2]/div[4]/div[1]")).getText();
		 System.out.println(varOldPrc);
		 String pattern = "Retail: \\$(\\d+.\\d\\d)";
		 Pattern r = Pattern.compile(pattern);
		 Matcher m = r.matcher(varOldPrc);
		 if(m.find())
		 {
			 System.out.println(m.group(1));
			 double oldPrc=Double.valueOf(m.group(1));
			 double newPrc=Double.valueOf(varUnitPrc);
			 double savePrct=((oldPrc-newPrc)/oldPrc)*100;
			 int savings=(int)Math.round(savePrct);
			 System.out.println(savings);
			 String varSavings=driver.findElement(By.xpath("//*[@id='item_"+varId+"']/div[2]/div[4]/div[1]/span")).getText();
			 if(varSavings.trim().equals(savings+"% Employee Savings"))
				 report.updateTestLog("Checking Savings in Pricing", "Employee Savings Correctly displayed", Status.PASS );
			 else
				 report.updateTestLog("Checking Savings in Pricing", "Employee Savings NOT Correctly displayed", Status.FAIL );
			 if(dataTable.getData("General_Data", "PromoApplied").equals("Yes"))
			 {
				 String varPromoSavings=driver.findElement(By.xpath("//*[@id='item_"+varId+"']/div[2]/div[4]/span/div/p")).getText();
				 String varPromoAmt=dataTable.getData("General_Data", "PromoPercntOff");
				 if(varPromoSavings.trim().equals(varPromoAmt+"% Off"))
					 report.updateTestLog("Checking Savings in Pricing", "Promo Savings Correctly displayed", Status.PASS );
				 else
					 report.updateTestLog("Checking Savings in Pricing", "Promo Savings NOT Correctly displayed", Status.FAIL );
			 }
		 }
		 else
		 {
			 report.updateTestLog("Checking Savings in Pricing", "Retail Price not displayed for Item: "+varName, Status.FAIL);
		 }
	 }
	 else if(varType.equals("Was"))
	 {
		 String varOldPrc=driver.findElement(By.xpath("//*[@id='item_"+varId+"']/div[2]/div[4]/div[1]/p")).getText();
		 System.out.println(varOldPrc);
		 varOldPrc=varOldPrc.substring(5);
		 System.out.println(varOldPrc);
		 double oldPrc=Double.valueOf(varOldPrc);
		 double newPrc=Double.valueOf(varUnitPrc);
		 double savePrct=((oldPrc-newPrc)/oldPrc)*100;
		 int savings=(int)Math.round(savePrct);
		 System.out.println(savings);
		 String varSavings=driver.findElement(By.xpath("//*[@id='item_"+varId+"']/div[2]/div[4]/div[1]/span")).getText();
		System.out.println(varSavings);
		System.out.println("Total Savings of "+savings+"% Including Employee Savings");
		 if(varSavings.trim().equals("Total Savings of "+savings+"% Including Employee Savings"))
			 report.updateTestLog("Checking Savings in Pricing", "Employee Savings Correctly displayed", Status.PASS );
		 else
			 report.updateTestLog("Checking Savings in Pricing", "Employee Savings NOT Correctly displayed", Status.FAIL );
		 if(dataTable.getData("General_Data", "PromoApplied").equals("Yes"))
		 {
			 String varPromoSavings=driver.findElement(By.xpath("//*[@id='item_"+varId+"']/div[2]/div[4]/span/div/p")).getText();
			 String varPromoAmt=dataTable.getData("General_Data", "PromoPercntOff");
			 if(varPromoSavings.trim().equals(varPromoAmt+"% Off"))
				 report.updateTestLog("Checking Savings in Pricing", "Promo Savings Correctly displayed", Status.PASS );
			 else
				 report.updateTestLog("Checking Savings in Pricing", "Promo Savings NOT Correctly displayed", Status.FAIL );
		 }
	 }
 }
 
 /**Checks Employee You Save Amt includes Promo discount**/
 public void calculateYouSaveEMPPromo() throws Exception
 {
	 String varId=dataTable.getData("General_Data", "ItemId");
	 String actualPrice=dataTable.getData("General_Data", "UnitPrice");
	 System.out.println(actualPrice);
	// String varYouSave=dataTable.getData("General_Data", "YouSave");
	// double youSaveAmt=Double.valueOf(varYouSave);
	// System.out.println(youSaveAmt);
	 double acualPrc=Double.valueOf(actualPrice);
	 String varUnitPrc=driver.findElement(By.xpath("//*[@id='item_"+varId+"']/div[2]/div[4]/div[1]/div")).getText();
	 varUnitPrc=varUnitPrc.substring(1);
	 System.out.println(varUnitPrc);
	 double newPrc=Double.valueOf(varUnitPrc);
	 youSaveAmt=youSaveAmt+(acualPrc-newPrc);
	 youSaveAmt = (double) Math.round(youSaveAmt * 100) / 100;
	 if(dataTable.getData("General_Data", "PromoApplied").equals("Yes"))
	 {
		 String promoTxt=driver.findElement(By.xpath("//*[@id='item_"+varId+"']/div[2]/div[5]/span/div/p")).getText();
		 //String[] s=promoTxt.split("\\%");
		 promoTxt=promoTxt.substring(2);
		 System.out.println("Promo discount:"+promoTxt);
		 double promoDiscount=Double.valueOf(promoTxt);
		 System.out.println(youSaveAmt);
		 System.out.println(promoDiscount);
		 youSaveAmt=youSaveAmt+promoDiscount;
		 youSaveAmt = (double) Math.round(youSaveAmt * 100) / 100;
		 System.out.println("Final You Save:"+youSaveAmt);
	 }
	// dataTable.putData("General_Data", "YouSave", String.format("%.2f", youSaveAmt));
	// System.out.println(String.format("%.2f", youSaveAmt));
 }
 
 /**Checks Pricing Area for Was Price/Retail Price/Savings in cart for Employee**/
 public void chkPricingInCartEmp() throws Exception
 {
	 
	 //String varYouSave=dataTable.getData("General_Data", "YouSave");
	 String youSaveDisp=driver.findElement(By.xpath(UIMapCheckOut.lblCartSummaryYouSaveAmt)).getText();
	System.out.println(youSaveDisp);
	 if(youSaveDisp.equals("$"+youSaveAmt))
		 report.updateTestLog("Checking You Save Amount", "You Save Amount correct", Status.PASS);
	 else
		 report.updateTestLog("Checking You Save Amount", "You Save Amount NOT correct", Status.FAIL);
 }
 
 /**stores Cart Subtotal, UPS Delivery Charges, Est Sales Tax and Ext Subtotal Values**/
 public void storeUPSChargesFrmCart() throws Exception
 {
	 String varSubtotal=driver.findElement(By.xpath(UIMapCheckOut.lblCartSubtotal)).getText();
	// varSubtotal=varSubtotal.substring(1);
	 System.out.println(varSubtotal);
	 dataTable.putData("General_Data", "UPSSubtotal", varSubtotal);
	
	 String varEstTax=driver.findElement(By.xpath(UIMapCheckOut.lblEstSalesTax1DeliverySelected)).getText();
	 // varEstTax=varEstTax.substring(1);
	 System.out.println(varEstTax);
	 dataTable.putData("General_Data", "UPSEstTax", varEstTax);
	 
	 String varEstTotal=driver.findElement(By.xpath(UIMapCheckOut.lblestimatedTotalValue)).getText();
	 // varEstTotal=varEstTotal.substring(1);
	 System.out.println(varEstTotal);
	 dataTable.putData("General_Data", "UPSEstTotal", varEstTotal);
	 
 }
 
 /**stores Cart Subtotal, LD Delivery Charges, ,UPS delivery Charges, Est Sales Tax and Ext Subtotal Values**/
 public void storeChargesFrmCart() throws Exception
 {
	 String varSubtotal=driver.findElement(By.xpath(UIMapCheckOut.lblCartSubtotal)).getText();
	// varSubtotal=varSubtotal.substring(1);
	 System.out.println(varSubtotal);
	 dataTable.putData("General_Data", "Subtotal", varSubtotal);
	 
	 String varLDCharges=driver.findElement(By.xpath(UIMapCheckOut.lblEstDelValue)).getText();
	// varLDCharges=varLDCharges.substring(1);
	 System.out.println(varLDCharges);
	 dataTable.putData("General_Data", "LDCharges", varLDCharges);
	 
	 String varUPSCharges=driver.findElement(By.xpath(UIMapCheckOut.lblDel2ChargesValue)).getText();
	// varUPSCharges=varUPSCharges.substring(1);
	 System.out.println(varUPSCharges);
	 dataTable.putData("General_Data", "UPSCharges", varUPSCharges);
	 
	 String varEstTax=driver.findElement(By.xpath(UIMapCheckOut.lblEstSalesTax2DelMthd)).getText();
	// varEstTax=varEstTax.substring(1);
	 System.out.println(varEstTax);
	 dataTable.putData("General_Data", "EstTax", varEstTax);
	 
	 String varEstTotal=driver.findElement(By.xpath(UIMapCheckOut.lblestimatedTotalValue)).getText();
	// varEstTotal=varEstTotal.substring(1);
	 System.out.println(varEstTotal);
	 dataTable.putData("General_Data", "EstTotal", varEstTotal);
	 
 }
 
 public void chkChargesInChkOutPgsForPartialOrder() throws Exception
 {
	 fc.chkText(UIMapCheckOut.lblOrderSubtotalChkOutPgs, dataTable.getData("General_Data", "Subtotal"));
	 fc.chkText(UIMapCheckOut.lblOrderDel1ChargesChkOutPgs, dataTable.getData("General_Data", "LDCharges"));
	 fc.chkText(UIMapCheckOut.lblBillSummryDelivryCost, dataTable.getData("General_Data", "UPSCharges"));
	 fc.chkText(UIMapCheckOut.lblOrderEstTax2DelMthd, dataTable.getData("General_Data", "EstTax"));
	 fc.chkText(UIMapCheckOut.lblOrderTotal, dataTable.getData("General_Data", "EstTotal"));
 }
 
 public void chkChargesInRevPayPgForPartialOrder() throws Exception
 {
	 fc.chkText(UIMapCheckOut.lblBillSummrySubtotalValue, dataTable.getData("General_Data", "Subtotal"));
	 fc.chkText(UIMapCheckOut.lblOrderDel1ChargesRevPay, dataTable.getData("General_Data", "LDCharges"));
	 fc.chkText(UIMapCheckOut.lblBillSummryDelivryCost, dataTable.getData("General_Data", "UPSCharges"));
	 fc.chkText(UIMapCheckOut.lblOrderEstTax2DelMthdRevPay, dataTable.getData("General_Data", "EstTax"));
	 fc.chkText(UIMapCheckOut.lblOrderTotal, dataTable.getData("General_Data", "EstTotal"));
 }
 
 public void chkChargesInOCForPartialOrder() throws Exception
 {
	 fc.checkTextContains(UIMapCheckOut.lblPartialOrder, "We were unable to process the", "Partail order Text");
	 fc.chkText(UIMapCheckOut.lblOrderSubtotalOC, dataTable.getData("General_Data", "UPSSubtotal"));
	 fc.chkText(UIMapCheckOut.lblDelChargesOC, dataTable.getData("General_Data", "UPSCharges"));
	 fc.chkText(UIMapCheckOut.lblTax1DelOC, dataTable.getData("General_Data", "UPSEstTax"));
	 fc.chkText(UIMapCheckOut.lblOrderTotalOC, dataTable.getData("General_Data", "UPSEstTotal"));
 }
 
 public void chkChargesInFindOrderForPartialOrder() throws Exception
 {
	 fc.chkText(UIMapCheckOut.lblPurchaseTotalAmt, dataTable.getData("General_Data", "UPSEstTotal"));
	 fc.chkText(UIMapCheckOut.lblPurchaseSubTotalAmt, dataTable.getData("General_Data", "UPSSubtotal"));
	 fc.chkText(UIMapCheckOut.lblDelCharges1Amt, dataTable.getData("General_Data", "UPSCharges"));
	 fc.chkText(UIMapCheckOut.lblEstTax1DelAmt, dataTable.getData("General_Data", "UPSEstTax"));
	 fc.checkTextContains(UIMapCheckOut.lblPurchaseTotalFooter, dataTable.getData("General_Data", "UPSEstTotal") , "Purchase Total in Footer");
 }
 
 public void chkChargesForPartialOrder() throws Exception
 {
	 co.providecheckOutOrderAsNewUserDetails();
	 co.checkOutShippingInfoAddress();
	 chkChargesInChkOutPgsForPartialOrder();
	 clickContinueChkOut();
	 chkChargesInChkOutPgsForPartialOrder();
	 co.provideNewUserProdDestination();
	 chkChargesInChkOutPgsForPartialOrder();
	 co.provideNewUserShippingOptions();
	 chkChargesInRevPayPgForPartialOrder();
	 co.checkOutUsingMasterCreditCard();
	 co.checkOutBillingInfoAddNewAddress();
	 co.clickCheckOutInReviewPageDetail();
	 co.captureOrderNbr();
	 chkChargesInOCForPartialOrder();
 }
}


