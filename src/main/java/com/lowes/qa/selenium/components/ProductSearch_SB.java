package com.lowes.qa.selenium.components;



import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.cognizant.framework.Status;
import com.lowes.qa.selenium.support.ReusableLibrary;
import com.lowes.qa.selenium.support.ScriptHelper;
import com.lowes.qa.selenium.uimap.UIMapCheckOut;
import com.lowes.qa.selenium.uimap.UIMapFunctionalComponents;
import com.lowes.qa.selenium.uimap.UIMapMyLowes;
import com.lowes.qa.selenium.uimap.UIMapProductSearch;
import com.thoughtworks.selenium.Selenium;
public class ProductSearch_SB extends ReusableLibrary
{
	String baseurl = dataTable.getData("General_Data", "URL");
	Selenium selenium = new WebDriverBackedSelenium(driver, baseurl);
	public ProductSearch_SB(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
	}
	//CheckOut_CM cm=new CheckOut_CM(scriptHelper);
	CheckOut ch=new CheckOut(scriptHelper);
	//ProductSearch ps=new ProductSearch(scriptHelper);
	//MyLowes2 mid=new MyLowes2(scriptHelper);
	FunctionalComponents fc= new FunctionalComponents(scriptHelper);
////Added 11th March
	
	/**This function validates whether page title is as expected**/
	public void chkPagetitle(String pgTitle) throws Exception
	{
		System.out.println(selenium.getTitle());
		if(selenium.getTitle().equals(pgTitle))
			report.updateTestLog("Checking Page Title", "Page Title as Expected is:"+pgTitle, Status.PASS);
		else
			report.updateTestLog("Checking Page Title", "Page Title Not :"+pgTitle, Status.FAIL);
	}
	
	

	/***
	 * Validates Quantity Required & Add to Cart button of min or multiple SOS item from product compare page
	 */
	public void chkComparePgForMinMulSOS() throws Exception
	{
		
			List<WebElement> varProductList = driver.findElements(By.xpath(UIMapProductSearch.webElmntProductList2));
			int varCount = varProductList.size();
			int j;
			String varID;
			String varId1="";
			String varId2="";
			for(j=1;j<=varCount;j++)
			{
				//String varXPath= "//*[@id='productResults']/li["+i+"]";
				String varXPath= UIMapProductSearch.webElmntProductList2+"["+j+"]";
				varID = driver.findElement(By.xpath(varXPath)).getAttribute("id");
				System.out.println(varID);
				//String varItemNbr=driver.findElement(By.xpath("//*[@id='"+varID+"']/div/div[4]/ul[1]/li[1]")).getText();
				String varPrice=driver.findElement(By.xpath("//*[@id='"+varID+"']/div/div[3]")).getText();
				System.out.println(varPrice);
				
				if(varPrice.contains("You must order this item in"))
				{
					if(!varId1.isEmpty())
					{
						System.out.println("Varid1 not empty");
					dataTable.putData("General_Data", "ItemId2", varID);
					varId2=dataTable.getData("General_Data", "ItemId2");
					ClickCustomize("xpath", "//*[@id='"+varId2+"']/div/div[1]/div/input");
					Thread.sleep(2000);
					}	
					else{
						System.out.println("varId1 empty");
					dataTable.putData("General_Data", "ItemId", varID);
					varId1=dataTable.getData("General_Data", "ItemId");
					ClickCustomize("xpath", "//*[@id='"+varId1+"']/div/div[1]/div/input");
					Thread.sleep(2000);
					}	
					 
					
					if(!varId1.isEmpty() && !varId2.isEmpty())
						break;
					else
						continue;
				}
				else
					continue;
			}
			if(j>varCount)
			{
				report.updateTestLog("Checking SOS-Min-Mul Items", "SOS-Min-Mul Items not present in Product List", Status.PASS);
			
			
			}
			else
			{
				ClickCustomize("xpath", UIMapProductSearch.btnCompare);
				selenium.waitForPageToLoad("20000");
				String item1Qty=driver.findElement(By.xpath(UIMapProductSearch.lblItem1QtyReqd)).getText();
				String item2Qty=driver.findElement(By.xpath(UIMapProductSearch.lblItem2QtyReqd)).getText();
				String pattern = "Order In Quantities of \\d+";	
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(item1Qty);
				if(m.find())
					report.updateTestLog("Checking SOS Item 1 Qty", "Order In Quantities of <Qty> displayed", Status.PASS);
				else
					report.updateTestLog("Checking SOS Item 1 Qty", "Order In Quantities of <Qty> NOT displayed", Status.FAIL);
				m = r.matcher(item2Qty);
				if(m.find())
					report.updateTestLog("Checking SOS Item 2 Qty", "Order In Quantities of <Qty> displayed", Status.PASS);
				else
					report.updateTestLog("Checking SOS Item 2 Qty", "Order In Quantities of <Qty> NOT displayed", Status.FAIL);
				try{
				if(driver.findElement(By.xpath(UIMapProductSearch.btnCompareAddToCart1)).isDisplayed())
				{
					ClickCustomize("xpath", UIMapProductSearch.btnCompareAddToCart1);
					Thread.sleep(7000);
					String varItemAdded=driver.findElement(By.xpath(UIMapProductSearch.txtAddProductTitle)).getText();
					if(varItemAdded.equals("Your item was successfully added to cart."))
						report.updateTestLog("Adding SOS Item 1 To Cart", "SOS Item 1 added to cart", Status.PASS);
					else
						report.updateTestLog("Adding SOS Item 1 To Cart", "SOS Item 1 NOT added to cart", Status.FAIL);
				}
				else
					report.updateTestLog("Checking SOS Item 1 Add To Cart", "Add To Cart NOT displayed", Status.FAIL);
				}
				catch(Exception e)
				{
					report.updateTestLog("Checking SOS Item 1 Add To Cart", "Add To Cart NOT displayed", Status.FAIL);
				}
			}
		
		
	}
	
	/**Stores the item id of instock product in datasheet**/
	
	public void storeInStockProduct() throws Exception
	{
		List<WebElement> varProductList = driver.findElements(By.xpath(UIMapProductSearch.webElmntProductList2));
		int varCount = varProductList.size();
		int i;
		WebElement inStockItem1=driver.findElement(By.xpath(UIMapProductSearch.btnAddToCartAll));
		WebElement parent1=inStockItem1.findElement(By.xpath(".."));
		String varId=parent1.findElement(By.xpath("..")).getAttribute("id");
		System.out.println(varId);
		dataTable.putData("General_Data", "ItemId", varId);
		String varName=driver.findElement(By.xpath("//*[@id='"+varId+"']/div/div[2]/h3/a")).getText();
		System.out.println(varName);
		dataTable.putData("General_Data", "ItemName", varName);
		
	}
	
	/**Checks whether text at xpath contains a specific text**/
	public void checkTextContains(String varXpath, String txt, String elementDesc) throws Exception
	{
		String varTxt=driver.findElement(By.xpath(varXpath)).getText();
		System.out.println(varTxt);
		System.out.println(txt);
		if(varTxt.contains(txt))
			report.updateTestLog("Checking "+elementDesc, elementDesc+" contains "+txt, Status.PASS);
		else
			report.updateTestLog("Checking "+elementDesc, elementDesc+" Does Not contain "+txt, Status.FAIL);
	}
	
	/**Checks whether text at xpath Does not contain a specific text**/
	public void checkTextNotContains(String varXpath, String txt, String elementDesc) throws Exception
	{
		String varTxt=driver.findElement(By.xpath(varXpath)).getText();
		if(varTxt.contains(txt))
			report.updateTestLog("Checking "+elementDesc, elementDesc+" contains "+txt, Status.FAIL);
		else
			report.updateTestLog("Checking "+elementDesc, elementDesc+" Does Not contain "+txt, Status.PASS);
	}
	
	/**Checks Quick View for Sq Foot Pricing Item-AZ user**/
	public void chkQuickViewSqFootPricingItemAZ() throws Exception
	{
		String varId=dataTable.getData("General_Data", "ItemId");
		boolean wasFlag=false;
		String varPricing=driver.findElement(By.xpath("//*[@id='"+varId+"']/div/div[3]")).getText();
		if(varPricing.contains("Was:"))
			wasFlag=true;
		
		ClickCustomize("xpath", "//*[@id='"+varId+"']/div/div[1]/a[2]");
		Thread.sleep(3000);
		System.out.println(wasFlag);
		checkTextContains(UIMapProductSearch.lblUnitPrice,"/ Sq. Ft.","Square Ft. Pricing");
		if(wasFlag)
		{
			
			checkTextContains(UIMapProductSearch.lblWasPriceQuickView,"Was:","Sq Ft. Pricing");
			checkTextContains(UIMapProductSearch.lblsavingsQuickView,"Save ","Sq Ft. Pricing");
			checkTextContains(UIMapProductSearch.lblPurchasePrcQuickView,"Purchase Price:","Sq Ft. Pricing");
			checkTextContains(UIMapProductSearch.lblPurchasePrcQuickView,"(Covers ","Sq Ft. Pricing");
			
			
		}
		else
		{
			checkTextContains(UIMapProductSearch.lblPurchasePrcQuickViewNonWas,"Purchase Price:","Sq Ft. Pricing");
			checkTextContains(UIMapProductSearch.lblPurchasePrcQuickViewNonWas,"(Covers ","Sq Ft. Pricing");
		}
		driver.navigate().refresh();
		selenium.waitForPageToLoad("20000");
		
	}
	
	/**Checks Quick View for Sq Foot Pricing Item-NZ user**/
	public void chkQuickViewSqFootPricingItemNZ() throws Exception
	{
		
		
		ClickCustomize("xpath", UIMapProductSearch.lnkItem1QuickView);
		Thread.sleep(3000);
		
		checkTextNotContains(UIMapProductSearch.webElmntQuickViewPricing,"/ Sq. Ft.","Square Ft. Pricing");
		checkTextNotContains(UIMapProductSearch.webElmntQuickViewPricing,"Was:","Sq Ft. Pricing");
		checkTextNotContains(UIMapProductSearch.webElmntQuickViewPricing,"Save ","Sq Ft. Pricing");
		checkTextNotContains(UIMapProductSearch.webElmntQuickViewPricing,"Purchase Price:","Sq Ft. Pricing");
		checkTextNotContains(UIMapProductSearch.webElmntQuickViewPricing,"(Covers ","Sq Ft. Pricing");
		
		driver.navigate().refresh();
		selenium.waitForPageToLoad("20000");
		
	}
	
	/**clicks Quick view for first In Stock item in list and clicks Add To Cart **/
	public void addItemToCartFrmQVList() throws Exception
	{
		
		ClickCustomize("xpath", UIMapProductSearch.lnkItem1QuickView);
		Thread.sleep(3000);
		ClickCustomize("xpath", UIMapProductSearch.btnQVAddToCrt);
		Thread.sleep(7000);
		try{
		String varAddedToCart=driver.findElement(By.xpath(UIMapProductSearch.txtAddProductTitle)).getText();
		if(varAddedToCart.equals("Your item was successfully added to cart."))
		{
			report.updateTestLog("Checking Message in Notification model", "'Your item was successfully added to cart.' DISPLAYED" , Status.PASS);
			try{
				boolean varQuickViewDisp=driver.findElement(By.id(UIMapProductSearch.webElmntQuickView)).isDisplayed();
				if(varQuickViewDisp)
					report.updateTestLog("Checking Quick View Model after adding item to cart", "Quick View Model Displayed", Status.FAIL);
				else
					report.updateTestLog("Checking Quick View Model after adding item to cart", "Quick View Model NOT Displayed", Status.PASS);
			}
			catch(Exception e)
			{
				report.updateTestLog("Checking Quick View Model after adding item to cart", "Quick View Model NOT Displayed", Status.PASS);
			}
			ch.clickContinueShopping();
			openMiniCart();
			//check ProductImage Mini cart
			try{
				boolean varImg=driver.findElement(By.xpath(UIMapProductSearch.webElmntMiniCartItemImg)).isDisplayed();
				if(varImg)
				{
					report.updateTestLog("Checking Item Image in Mini cart", "Item Image displayed in Mini cart", Status.PASS);
					ClickCustomize("xpath", UIMapProductSearch.webElmntMiniCartItemImg);
					selenium.waitForPageToLoad("20000");
					String varName=dataTable.getData("General_Data", "ItemName");
					String varNameDisp=driver.findElement(By.xpath(UIMapProductSearch.webElmntProductName)).getText();
					if(varName.trim().equals(varNameDisp.trim()))
						report.updateTestLog("Clicking Item Image in Mini Cart", "Product Details Page displayed", Status.PASS);
					else
						report.updateTestLog("Clicking Item Image in Mini Cart", "Product Details Page NOT displayed", Status.FAIL);
					driver.navigate().back();
					selenium.waitForPageToLoad("20000");
						
				}
				else
					report.updateTestLog("Checking Item Image in Mini cart", "Item Image NOT displayed in Mini cart", Status.FAIL);
			}
			catch(Exception e)
			{
				report.updateTestLog("Checking Item Image in Mini cart", "Item Image NOT displayed in Mini cart", Status.FAIL);
			}
			//check ProductName in cart
			
			String varItemNameTrimmed="";
			String varItemName=dataTable.getData("General_Data", "ItemName");;
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
			try{
				openMiniCart();
			String varName=driver.findElement(By.xpath(UIMapProductSearch.lnkMiniCartItemName)).getText();
			String varItemAddedTrimmed="";
			if(varName.length()<varItemNameTrimmed.length())
				System.out.println(varName.length());
			else
				{
				varItemAddedTrimmed=varName.substring(0, varItemNameTrimmed.length());
				}
			System.out.println(varItemAddedTrimmed);
			System.out.println(varItemNameTrimmed);
			//if()
			if(varItemAddedTrimmed.equals(varItemNameTrimmed))//&&(varNewCount==(oldCount+1)))
			{
				report.updateTestLog("Checking Item Name in Mini cart", "Item Name Correctly displayed in Mini cart", Status.PASS);
				ClickCustomize("xpath", UIMapProductSearch.lnkMiniCartItemName);
				selenium.waitForPageToLoad("20000");
				
				String varNameDisp=driver.findElement(By.xpath(UIMapProductSearch.webElmntProductName)).getText();
				if(varItemName.trim().equals(varNameDisp.trim()))
					report.updateTestLog("Clicking Item Image in Mini Cart", "Product Details Page displayed", Status.PASS);
				else
					report.updateTestLog("Clicking Item Image in Mini Cart", "Product Details Page NOT displayed", Status.FAIL);
				driver.navigate().back();
				selenium.waitForPageToLoad("20000");
			}	
			else
				report.updateTestLog("Checking Item Name in Mini cart", "Item Name NOT Correctly displayed in Mini cart", Status.FAIL);
					
			}
			catch(Exception e)
			{
				report.updateTestLog("Checking Item Name in Mini cart", "Item Name NOT displayed in Mini cart", Status.FAIL);
			}
			
			//checking selling price & Qty
			openMiniCart();
			String varPrice=driver.findElement(By.xpath(UIMapProductSearch.lblMiniCartItemPrice)).getText();
			String varQty=driver.findElement(By.xpath(UIMapProductSearch.lblMiniCartItemQty)).getText();
			String pattern = "\\$\\d+\\.\\d\\d";	
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(varPrice);
			if(m.find())
				report.updateTestLog("Checking Price in Mini Cart", "Price Displayed in Mini Cart", Status.PASS);
			else
				report.updateTestLog("Checking Price in Mini Cart", "Price NOT Displayed in Mini Cart", Status.FAIL);
			pattern ="Qty\\.: \\d+";
			 r = Pattern.compile(pattern);
			 m = r.matcher(varQty);
			 if(m.find())
					report.updateTestLog("Checking Qty in Mini Cart", "Qty Displayed in Mini Cart", Status.PASS);
				else
					report.updateTestLog("Checking Qty in Mini Cart", "Qty NOT Displayed in Mini Cart", Status.FAIL);
			//checking View Cart & CheckOut mechanism 
			try{ boolean varButton=driver.findElement(By.xpath(UIMapCheckOut.btnViewCartCheckout)).isDisplayed();
			 if(varButton)
			 {
				 report.updateTestLog("Checking View Cart & CheckOut in Mini Cart", "View Cart & CheckOut Displayed in Mini Cart", Status.PASS);
				 clickViewCartCheckOut();
			 }
			 else
				 report.updateTestLog("Checking View Cart & CheckOut in Mini Cart", "View Cart & CheckOut NOT Displayed in Mini Cart", Status.FAIL);
			}
			catch(Exception e)
			{
				 report.updateTestLog("Checking View Cart & CheckOut in Mini Cart", "View Cart & CheckOut NOT Displayed in Mini Cart", Status.FAIL);
			}
			
		}
		else
			report.updateTestLog("Checking Message in Notification model", "'Your item was successfully added to cart.' NOT DISPLAYED" , Status.FAIL);
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking Message in Notification model", "Notification model NOT DISPLAYED" , Status.FAIL);
		}
	}
	
	public void checkNeedHelp() throws Exception
	{
		System.out.println("Reaching here");
		
		try{
			ClickCustomize("partialLinkText", "Need Help?");
			Thread.sleep(2000);
			boolean varPopup=driver.findElement(By.xpath(UIMapProductSearch.webElmntNeedHelpPopup)).isDisplayed();
			if(varPopup)
			{
				report.updateTestLog("Clicking Need Help", "Need Help POPUP displayed", Status.PASS);
				
				fc.chkText(UIMapProductSearch.lblCallUs, "Call Us");
				String varCallUsPhn=driver.findElement(By.xpath(UIMapProductSearch.lblCallUsPhn)).getText();
				if(!varCallUsPhn.isEmpty())
					report.updateTestLog("Checking Call Us Phn", "Call Us Phn displayed", Status.PASS);
				else
					report.updateTestLog("Checking Call Us Phn", "Call Us Phn NOT displayed", Status.FAIL);
				fc.chkText(UIMapProductSearch.lnkEmailUs, "Email Us");
				fc.chkText(UIMapProductSearch.lblTellUs, "Tell us how we're doing.");
				fc.chkText(UIMapProductSearch.lnkFindAnswers, "Find Answers Here");
				fc.chkText(UIMapProductSearch.lblFAQs, "FAQs");
			
				
				ClickCustomize("partialLinkText", "Email Us");
				Thread.sleep(2000);
				
				String oldTab = driver.getWindowHandle();
				
				ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
				newTab.remove(oldTab);
				// change focus to new tab
			    driver.switchTo().window(newTab.get(0));
			    Thread.sleep(5000);
			    chkPagetitle("My Online Experience FAQs");
			    driver.close();
			 // change focus back to old tab
			    driver.switchTo().window(oldTab);
			    ClickCustomize("partialLinkText", "Need Help?");
				Thread.sleep(2000);
			    ClickCustomize("partialLinkText", "Find Answers Here");
				Thread.sleep(2000);
				
				ArrayList<String> newTab2 = new ArrayList<String>(driver.getWindowHandles());
				newTab2.remove(oldTab);
				driver.switchTo().window(newTab2.get(0));
			    Thread.sleep(5000);
			    chkPagetitle("Contact Us");
			    driver.close();
			    driver.switchTo().window(oldTab);
			}
			else
				report.updateTestLog("Clicking Need Help", "Need Help POPUP NOT displayed", Status.FAIL);
			
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking Need Help", "Need Help NOT properly displayed", Status.FAIL);
		}
	}

	/**Opens QuickView for first Item in list**/
	public void quickViewForFirstItemInList() throws Exception
	{
		ClickCustomize("xpath", UIMapProductSearch.lnkItem1QuickView);
		Thread.sleep(3000);
	}
	
	/**updates qty of an item from quick view and Adds the same to cart **/
	public void updateQtyAndAddToCartFromQuickView() throws Exception
	{
		
		try{
		if(driver.findElement(By.id(UIMapProductSearch.txtQtyQV)).isDisplayed())
		{
			driver.findElement(By.id(UIMapProductSearch.txtQtyQV)).clear();
			driver.findElement(By.id(UIMapProductSearch.txtQtyQV)).sendKeys(dataTable.getData("General_Data", "Qty"));
			report.updateTestLog("Checking Quick View Model for Qty", "Qty Displayed", Status.PASS);
		}
		else
			report.updateTestLog("Checking Quick View Model for Qty", "Qty NOT Displayed", Status.FAIL);
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking Quick View Model for Qty", "Qty NOT Displayed", Status.FAIL);
		}
		if(driver.findElement(By.xpath(UIMapProductSearch.btnQVAddToCrt)).isDisplayed())
		{
			report.updateTestLog("Checking Quick View Model for Add To Cart Button", "Add To Cart Button Displayed", Status.PASS);
		
		ClickCustomize("xpath", UIMapProductSearch.btnQVAddToCrt);
		Thread.sleep(7000);
		try{
		String varAddedToCart=driver.findElement(By.xpath(UIMapProductSearch.txtAddProductTitle)).getText();
		if(varAddedToCart.equals("Your item was successfully added to cart."))
		{
			report.updateTestLog("Checking Message in Notification model", "'Your item was successfully added to cart.' DISPLAYED" , Status.PASS);
			
		}
		else
			report.updateTestLog("Checking Message in Notification model", "'Your item was successfully added to cart.' NOT DISPLAYED" , Status.FAIL);
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking Message in Notification model", "'Your item was successfully added to cart.' NOT DISPLAYED" , Status.FAIL);
		}}
		else
		{
			report.updateTestLog("Checking Quick View Model for Add To Cart Button", "Add To Cart Button NOT Displayed", Status.FAIL);
		}
			
	}
	
/**Stores the item id of out Of Stock product in datasheet**/
	
	public void storeOutOfStockProduct() throws Exception
	{
		List<WebElement> varProductList = driver.findElements(By.xpath(UIMapProductSearch.webElmntProductList2));
		int varCount = varProductList.size();
		int i;
		WebElement inStockItem1=driver.findElement(By.xpath(UIMapProductSearch.btnOutOfStockAll));
		WebElement parent1=inStockItem1.findElement(By.xpath(".."));
		WebElement parent2=parent1.findElement(By.xpath(".."));
		WebElement parent3=parent2.findElement(By.xpath(".."));
		WebElement parent4=parent3.findElement(By.xpath(".."));
		String varId=parent4.findElement(By.xpath("..")).getAttribute("id");
		System.out.println(varId);
		dataTable.putData("General_Data", "ItemId", varId);
		String varName=driver.findElement(By.xpath("//*[@id='"+varId+"']/div/div[2]/h3/a")).getText();
		System.out.println(varName);
		dataTable.putData("General_Data", "ItemName", varName);
		
	}
	
	/**Clicks quick View of a specific item in Product List**/
	public void clickQV() throws Exception
	{
		String varId=dataTable.getData("General_Data", "ItemId");
		ClickCustomize("xpath", "//*[@id='"+varId+"']/div/div[1]/a[2]");
		Thread.sleep(3000);
	}
	
	public void clickQuickViewInStockItem() throws Exception
	{
		storeInStockProduct();
		clickQV();
	}
	
	public void clickQuickViewOutOfStockItem() throws Exception
	{
		storeOutOfStockProduct();
		clickQV();
	}
	
	/**Checks Quick View for Out Of Stock Products**/
	public void checkQVForOutOfStock() throws Exception
	{
		String varGetDetails=driver.findElement(By.xpath(UIMapProductSearch.btnQVAddToCrt)).getText();
		if(varGetDetails.equalsIgnoreCase("Get Details"))
		{
			report.updateTestLog("Checking Get Details", "Get Details displayed", Status.PASS );
			ClickCustomize("xpath", UIMapProductSearch.btnQVAddToCrt);
			selenium.waitForPageToLoad("20000");
			String varName=dataTable.getData("General_Data", "ItemName");
			String varNameDisp=driver.findElement(By.xpath(UIMapProductSearch.webElmntProductName)).getText();
			if(varName.trim().equals(varNameDisp.trim()))
				report.updateTestLog("Clicking Get Details", "Product Details Page displayed", Status.PASS);
			else
				report.updateTestLog("Clicking Get Details", "Product Details Page NOT displayed", Status.FAIL);
			driver.navigate().back();
			selenium.waitForPageToLoad("20000");
		}
	}
	
	/**Clicks on Continue Shopping on Notification Model -added from Quick View**/
	public void clickContinueShoppingFrmQV() throws Exception
	{
		ClickCustomize("xpath", UIMapProductSearch.btnContinueShopping);
		
		Thread.sleep(3000);
	}
	
	/**Checks details in Mini Cart for added Item**/
	public void verifyItemInMiniCart() throws Exception
	{
		//Checking Item Name in Mini Cart
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
			varNewCount=fc.countWebElement(UIMapCheckOut.webElmntMiniCartItemCount1);
			System.out.println("Items in Mini Cart:"+varNewCount);
			
		}
		catch(Exception NoSuchElementException)
		{
			System.out.println(driver.findElement(By.xpath(UIMapCheckOut.webElmntMiniCartItemCount2)).getAttribute("id"));
			varNewCount=fc.countWebElement(UIMapCheckOut.webElmntMiniCartItemCount2);
			System.out.println("Items in Mini Cart:"+varNewCount);
		}
		
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
			report.updateTestLog("Checking Item Name in Mini Cart", "Item displayed in Mini Cart", Status.PASS);
			ClickCustomize("xpath", "//*[@id='"+varCartItemId+"']/div[2]/div[2]/h3/a");
			selenium.waitForPageToLoad("20000");
			
			String varNameDisp=driver.findElement(By.xpath(UIMapProductSearch.webElmntProductName)).getText();
			if(varItemName.trim().equals(varNameDisp.trim()))
				report.updateTestLog("Clicking Item Name in Mini Cart", "Product Details Page displayed", Status.PASS);
			else
				report.updateTestLog("Clicking Item Name in Mini Cart", "Product Details Page NOT displayed", Status.FAIL);
			driver.navigate().back();
			selenium.waitForPageToLoad("20000");
			openMiniCart();
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
			
			//Checking Image
			if(driver.findElement(By.xpath("//*[@id='"+varCartItemId+"']/div[2]/div[1]/a/img")).isDisplayed())
				report.updateTestLog("Checking image for Item Added in Mini Cart", "Image displayed for Item in Mini Cart", Status.PASS);
			else
				report.updateTestLog("Checking image for Item Added in Mini Cart", "Image NOT displayed for Item in Mini Cart", Status.FAIL);
			//Checking Unit Price
			if(driver.findElement(By.xpath("//*[@id='"+varCartItemId+"']/div[2]/div[3]/p[1]")).getText().contains("$"))
				report.updateTestLog("Checking Price for Item Added in Mini Cart", "Price displayed for Item in Mini Cart", Status.PASS);
			else
				report.updateTestLog("Checking Price for Item Added in Mini Cart", "Price NOT displayed for Item in Mini Cart", Status.FAIL);
			//Checking Qty
			if(driver.findElement(By.xpath("//*[@id='"+varCartItemId+"']/div[2]/div[3]/p[2]")).getText().contains("Qty.:"))
				report.updateTestLog("Checking Qty for Item Added in Mini Cart", "Qty displayed for Item in Mini Cart", Status.PASS);
			else
				report.updateTestLog("Checking Qty for Item Added in Mini Cart", "Qty NOT displayed for Item in Mini Cart", Status.FAIL);
			
			break;
		}
		else
		{
			continue;
			
		}
		}
		if(i>varNewCount)
			report.updateTestLog("Checking Item Added in Mini Cart", "Item NOT displayed in Mini Cart", Status.FAIL);
		//checking View Cart & CheckOut mechanism 
		try{ boolean varButton=driver.findElement(By.xpath(UIMapCheckOut.btnViewCartCheckout)).isDisplayed();
		 if(varButton)
		 {
			 report.updateTestLog("Checking View Cart & CheckOut in Mini Cart", "View Cart & CheckOut Displayed in Mini Cart", Status.PASS);
			 clickViewCartCheckOut();
			 driver.navigate().back();
			 selenium.waitForPageToLoad("20000");
		 }
		 else
			 report.updateTestLog("Checking View Cart & CheckOut in Mini Cart", "View Cart & CheckOut NOT Displayed in Mini Cart", Status.FAIL);
		}
		catch(Exception e)
		{
			 report.updateTestLog("Checking View Cart & CheckOut in Mini Cart", "View Cart & CheckOut NOT Displayed in Mini Cart", Status.FAIL);
		}
		
		
		
		
	}
	
	public void verifyRTFItemInMiniCart() throws Exception
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
			System.out.println("varItemAdded::"+varItemAdded);
			varCartItemId=driver.findElement(By.xpath(UIMapCheckOut.lnkMiniCartItems+"["+i+"]")).getAttribute("id");
			
		}
		else
		{
			varItemAdded=driver.findElement(By.xpath(UIMapCheckOut.lnkMiniCartItemName2+"["+i+"]/div[2]/div[2]/h3/a")).getText();
			System.out.println("varItemAdded::"+varItemAdded);
			varCartItemId=driver.findElement(By.xpath(UIMapCheckOut.lnkMiniCartItems2+"["+i+"]")).getAttribute("id");
			
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
			//Checking Unit Price
			if(driver.findElement(By.xpath("//*[@id='"+varCartItemId+"']/div[2]/div[3]/p[1]")).getText().contains("$"))
				report.updateTestLog("Checking Price for Item Added in Mini Cart", "Price displayed for Item in Mini Cart", Status.PASS);
			else
				report.updateTestLog("Checking Price for Item Added in Mini Cart", "Price NOT displayed for Item in Mini Cart", Status.FAIL);
			//Checking Qty
			if(driver.findElement(By.xpath("//*[@id='"+varCartItemId+"']/div[2]/div[3]/p[2]")).getText().contains("Qty.:"))
				report.updateTestLog("Checking Qty for Item Added in Mini Cart", "Qty displayed for Item in Mini Cart", Status.PASS);
			else
				report.updateTestLog("Checking Qty for Item Added in Mini Cart", "Qty NOT displayed for Item in Mini Cart", Status.FAIL);
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
	
	/**validates Mini Cart on adding an item with EPP and RTF**/
	public void checkMiniCartItemWithEPPRTF() throws Exception
	{
		verifyItemInMiniCart();
		verifyRTFItemInMiniCart();
		clickRemoveInMiniCart();
		verifyRTFItemInMiniCart();
		clickRemoveInMiniCartForRTF();
		
	}
	
	/**Validates whether Lowe's is spelled correctly in Store Level Restriction message**/
	public void checkLowesInStoreLevelRestrictionMsg() throws Exception
	{
		try{String varMsg=driver.findElement(By.xpath(UIMapProductSearch.lblStoreRestrictionMsg)).getText();
		if(varMsg.contains("Lowe's"))
			report.updateTestLog("Checking Lowe's spelling in Restriction Message", "Lowe's spelling Correct in Restriction Message", Status.PASS);
		else
			report.updateTestLog("Checking Lowe's spelling in Restriction Message", "Lowe's spelling NOT Correct in Restriction Message", Status.FAIL);
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking Lowe's spelling in Restriction Message", "Restriction Message Not Displayed", Status.FAIL);
		}
	}
	
	/**Stores Item Id of required Item from Product List**/
	public void storeItemId() throws Exception
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
				dataTable.putData("General_Data", "ItemId", varID);
				break;
			}
			else
				continue;
		}
		if(j>varCount)
			report.updateTestLog("Searching for Required item  in Product List: "+dataTable.getData("General_Data", "ItemNbr"), " Required item Not displayed in Product List: "+dataTable.getData("General_Data", "ItemNbr"), Status.FAIL);
	}
	
	/**Validates that no error message is displayed on updating qty of item with no minimum order requirement**/
	public void chkNoMinimumOrderErrorMessage() throws Exception
	{
		
		String s = dataTable.getData("General_Data","Qty");
		String varId=dataTable.getData("General_Data", "ItemId");
		System.out.println(varId);
		String updatedQty = driver.findElement(By.xpath("//*[@id='item_"+varId+"']/div[2]/div[3]/input")).getAttribute("value");
		try{
		if(driver.findElement(By.xpath(UIMapCheckOut.lblUnavailableErrorMsg)).getText().contains("Please note that the quantity has been updated to meet the required minimum."))
			report.updateTestLog("Checking Minimum Order Error Message on updating Qty", "Minimum Order Error Message displayed on updating Qty", Status.FAIL);	
		else
		{
			report.updateTestLog("Checking Minimum Order Error Message on updating Qty", "Minimum Order Error Message NOT displayed on updating Qty", Status.PASS);	
			if(s.equals(updatedQty))
				report.updateTestLog("Checking Qty", "Qty Updated", Status.PASS);	
			else
				report.updateTestLog("Checking Qty", "Qty NOT Updated", Status.FAIL);
		}
			}
		catch(Exception e)
		{
			report.updateTestLog("Checking Minimum Order Error Message on updating Qty", "Minimum Order Error Message NOT displayed on updating Qty", Status.PASS);	
			if(s.equals(updatedQty))
				report.updateTestLog("Checking Qty", "Qty Updated", Status.PASS);	
			else
				report.updateTestLog("Checking Qty", "Qty NOT Updated", Status.FAIL);
			
		}
	}
	
	/**Changes Qty field in dataTable**/
	public void changeQtyInDataSheet() throws Exception
	{
		String s=dataTable.getData("General_Data", "Qty2");
		dataTable.putData("General_Data", "Qty", s);
	}
	
	public void getCurrentQtyInCart2() throws Exception
	{
		String varId=dataTable.getData("General_Data", "ItemId");
		System.out.println(varId);
		try{String minMsg= driver.findElement(By.xpath("//*[@id='item_"+varId+"']/div[2]/div[3]/div[1]")).getText();
		String pattern ="Please enter a quantity of \\d+ or more";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(minMsg);
		if(m.find())
		{
			report.updateTestLog("Checking Min Order message", "Min Order message displayed", Status.PASS);
		}
		else
			report.updateTestLog("Checking Min Order message", "Min Order message NOT displayed", Status.FAIL);
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking Min Order message", "Min Order message NOT displayed", Status.FAIL);
		}
		
		String s = driver.findElement(By.xpath("//*[@id='item_"+varId+"']/div[2]/div[3]/input")).getAttribute("value");
		dataTable.putData("General_Data","CurrentQty",s);
	}
	public void validateMinimumMsgInCart2() throws Exception
	{
		String s = dataTable.getData("General_Data","CurrentQty");
		String varId=dataTable.getData("General_Data", "ItemId");
		System.out.println(varId);
		String updatedQty = driver.findElement(By.xpath("//*[@id='item_"+varId+"']/div[2]/div[3]/input")).getAttribute("value");
		if(driver.findElement(By.xpath(UIMapCheckOut.lblUnavailableErrorMsg)).getText().contains("Please note that the quantity has been updated to meet the required minimum.")
				&&
				s.equals(updatedQty))
		report.updateTestLog("Verifying Minimum message and the quantity","Minimum message is displayed correctly and the quantity has been updated to meet required minimum", Status.PASS);
		else
			report.updateTestLog("Verifying Minimum message and the quantity","Minimum message and quantity not updated correctly", Status.FAIL);	
		}
	
	
	public void updateQtyInDetails() throws Exception
	{
		driver.findElement(By.xpath(UIMapProductSearch.QtyDetails)).clear();
		driver.findElement(By.xpath(UIMapProductSearch.QtyDetails)).sendKeys(dataTable.getData("General_Data", "Qty"));
		
	}
	/**verifies Minimum order functionality on cart page**/
	public void chkMinOrderCart() throws Exception
	{
		String s=dataTable.getData("General_Data", "MinOrder");
		if(s.equals("Yes"))
		{
			getCurrentQtyInCart2();
			ch.updateQtyInCart();
			chkNoMinimumOrderErrorMessage();
			changeQtyInDataSheet();
			ch.updateQtyInCart();
			validateMinimumMsgInCart2();
			String s2 = dataTable.getData("General_Data","CurrentQty");
			dataTable.putData("General_Data", "Qty", s2);
			ch.updateQtyInCart();
		}
		else
		{
			changeQtyInDataSheet();
			ch.updateQtyInCart();
			chkNoMinimumOrderErrorMessage();
		}
	}
	
	/**Checks user is auto-zipped**/
	public void checkAutoZip() throws Exception
	{
		try{boolean varStoreInfo=driver.findElement(By.xpath(UIMapFunctionalComponents.webElmntStoreInfo)).isDisplayed();
		if(varStoreInfo)
			report.updateTestLog("Checking Autozip", "store Info displayed", Status.PASS);
		
		else
			report.updateTestLog("Checking Autozip", "store Info NOT displayed", Status.FAIL);
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking Autozip", "store Info NOT displayed", Status.FAIL);
		}
		try{boolean varChangeStore=driver.findElement(By.xpath(UIMapProductSearch.lnkChangeStore2)).isDisplayed();
		if(varChangeStore)
			report.updateTestLog("Checking Autozip", "Change Store displayed", Status.PASS);
		
		else
			report.updateTestLog("Checking Autozip", "Change Store NOT displayed", Status.FAIL);
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking Autozip", "Change Store NOT displayed", Status.FAIL);
		}
	}
	
	/**chnages store using Change Store link in list**/
	public void changeStoreUsingConfirmStore() throws Exception
	{
		ClickCustomize("xpath", UIMapProductSearch.lnkChangeStoreList);
		Thread.sleep(10000);
		driver.findElement(By.xpath(UIMapProductSearch.txtChngStoreSearch)).sendKeys(dataTable.getData("General_Data", "zipcode"));
		driver.findElement(By.xpath(UIMapProductSearch.txtChngStoreSearch)).sendKeys(Keys.ENTER);
		Thread.sleep(7000);
		WebElement makeThisYourStore=driver.findElement(By.linkText("Make This Your Store"));
		WebElement parent=makeThisYourStore.findElement(By.xpath(".."));
		WebElement parent2=parent.findElement(By.xpath(".."));
		String varId=parent2.findElement(By.xpath("..")).getAttribute("id");
		ClickCustomize("xpath", "//*[@id='"+varId+"']/a/span[1]");
		Thread.sleep(1000);
		String varStoreDetails=driver.findElement(By.xpath( "//*[@id='"+varId+"']/span[2]")).getText();
		System.out.println(varStoreDetails);
		String storeName=driver.findElement(By.xpath( "//*[@id='"+varId+"']/strong[1]")).getText();
		System.out.println(storeName);
		//String storeAdd1=driver.findElement(By.xpath( "//*[@id='"+varId+"']/span[1]")).getText();
		//String storePhn=driver.findElement(By.xpath( "//*[@id='"+varId+"']/span[3]")).getText();
		//String storeHrs=driver.findElement(By.xpath( "//*[@id='"+varId+"']/strong[2]")).getText();
		ClickCustomize("xpath", "//*[@id='"+varId+"']/ul/li[2]/a");
		selenium.waitForPageToLoad("20000");
		String varYourStore=driver.findElement(By.xpath(UIMapProductSearch.lblYourStore)).getText();
		System.out.println(varYourStore);
		if(varStoreDetails.contains(varYourStore))
			report.updateTestLog("Changing Store Using Confirm Store-Change Store link", "Changed Store displayed in Confirm Store section", Status.PASS);
		else
			report.updateTestLog("Changing Store Using Confirm Store-Change Store link", "Changed Store NOT displayed in Confirm Store section", Status.FAIL);
		String varStoreMasthead=driver.findElement(By.xpath(UIMapProductSearch.webElmntActiveStore)).getText();
		System.out.println(varStoreMasthead);
		if(varStoreMasthead.trim().equals(storeName.trim()))
			report.updateTestLog("Changing Store Using Confirm Store-Change Store link", "Changed Store displayed in masthead", Status.PASS);
		else
			report.updateTestLog("Changing Store Using Confirm Store-Change Store link", "Changed Store NOT displayed in masthead", Status.FAIL);
		fc.clickHome();
		fc.searchItemString();
		varYourStore=driver.findElement(By.xpath(UIMapProductSearch.lblYourStore)).getText();
		System.out.println(varYourStore);
		if(varStoreDetails.contains(varYourStore))
			report.updateTestLog("Navigating to Home Page and then to list", "Changed store displayed", Status.PASS);
		else
			report.updateTestLog("Navigating to Home Page and then to list", "Changed store NOT displayed", Status.FAIL);
		ClickCustomize("xpath", UIMapProductSearch.lnkStoreInfoConfrmStore);
		try{
			String varStoreInfoName=driver.findElement(By.xpath(UIMapProductSearch.lblStoreInfoName)).getText();
			String varStoreInfoAdd1=driver.findElement(By.xpath(UIMapProductSearch.lblStoreInfoAdd1)).getText();
			String varStoreInfoAdd2=driver.findElement(By.xpath(UIMapProductSearch.lblStoreInfoAdd2)).getText();
			String varStoreInfoPhn=driver.findElement(By.xpath(UIMapProductSearch.lblStoreInfoPhn)).getText();
			String varStoreInfoHrs=driver.findElement(By.xpath(UIMapProductSearch.lblStoreInfoHrs)).getText();
		if(!varStoreInfoName.isEmpty() && !varStoreInfoAdd1.isEmpty() && !varStoreInfoAdd2.isEmpty() && !varStoreInfoPhn.isEmpty() && !varStoreInfoHrs.isEmpty())
			report.updateTestLog("Checking Store Info", "Store Info displayed ", Status.PASS);
		else
			report.updateTestLog("Checking Store Info", "Store Info NOT displayed ", Status.FAIL);
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking Store Info", "Store Info NOT displayed", Status.FAIL);
		}
		
	}
	
	/**Selects delivery method for BOGO items in cart**/
	public void selectDelvryMethodCartBOGO() throws Exception
	{
		String varDeliveryOption = dataTable.getData("General_Data", "DeliveryMthd");
		if(varDeliveryOption.equals("PL"))
		{
			
			driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[2]/ul/li[1]/div/label/input")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[2]/ul/li[1]/div/label/input)[2]")).click();
			Thread.sleep(5000);
			report.updateTestLog("Selecting Delivery Option","Delivery Option"+dataTable.getData("General_Data", "DeliveryMthd")+" selected for BOGO Items "+dataTable.getData("General_Data", "ItemNbr"), Status.DONE);
			
		}
		else if(varDeliveryOption.equals("UPS"))
		{
			driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[2]/ul/li[3]/div/label/input")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[2]/ul/li[3]/div/label/input)[2]")).click();
			Thread.sleep(5000);
			report.updateTestLog("Selecting Delivery Option","Delivery Option"+dataTable.getData("General_Data", "DeliveryMthd")+" selected for BOGO Items "+dataTable.getData("General_Data", "ItemNbr"), Status.DONE);
		}
		else if(varDeliveryOption.equals("LD"))
		{
			driver.findElement(By.xpath("//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[2]/ul/li[2]/div/label/input")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("(//*[@id='item_"+dataTable.getData("General_Data", "ItemId")+"']/div[2]/div[2]/ul/li[2]/div/label/input)[2]")).click();
			Thread.sleep(5000);
			report.updateTestLog("Selecting Delivery Option","Delivery Option"+dataTable.getData("General_Data", "DeliveryMthd")+" selected for BOGO Items "+dataTable.getData("General_Data", "ItemNbr"), Status.DONE);
		}
	}
	//Added 19th march
	public void storeMapItemFromList() throws Exception
	{
		String varNbrOfPages = driver.findElement(By.className(UIMapProductSearch.webElmntTotalPages)).getText();
		int varNbrOfPages2 = Integer.valueOf(varNbrOfPages);
		System.out.println(varNbrOfPages2);
		int i=0;
		for(i = 1;i<=varNbrOfPages2;i++)
		{
			System.out.println("Page:"+i);
			try{
			WebElement mapItem1=driver.findElement(By.xpath(UIMapProductSearch.lnkMAPContextualHelpAll));
			WebElement parent1=mapItem1.findElement(By.xpath(".."));
			WebElement parent2=parent1.findElement(By.xpath(".."));
			WebElement parent3=parent2.findElement(By.xpath(".."));
			String varId=parent3.findElement(By.xpath("..")).getAttribute("id");
			System.out.println(varId);
			dataTable.putData("General_Data", "ItemId", varId);
			String varName=driver.findElement(By.xpath("//*[@id='"+varId+"']/div/div[2]/h3/a")).getText();
			System.out.println(varName);
			dataTable.putData("General_Data", "ItemName", varName);
			break;
			}
			catch(Exception e)
			{
				System.out.println("Product not found on page "+i);
				driver.findElement(By.partialLinkText("Next")).click();
				selenium.waitForPageToLoad("10000");
				Thread.sleep(10000);
			}
		}
		if(i==(varNbrOfPages2+1))
		{
			report.updateTestLog("Finding Product","Product Not Found", Status.FAIL);
		}
	}
	 
	//added
	
				
	/**Checks Instore product in list**/
	public void chkInStoreOnlyInProductList() throws Exception
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
				dataTable.putData("General_Data", "ItemId", varID);
				break;
			}
			else
				continue;
		}
		
		swtichProductResultsGrid();
		try{
			if(driver.findElement(By.xpath("//*[@id='"+dataTable.getData("General_Data", "ItemId")+"']/div/p")).isDisplayed())
				report.updateTestLog("Checking QTY in List", "Qty NOT Suppressed", Status.FAIL);
			else
				report.updateTestLog("Checking QTY in List", "Qty Suppressed", Status.PASS);
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking QTY in List", "Qty Suppressed", Status.PASS);
		}
		try{
			if(driver.findElement(By.xpath("//*[@id='"+dataTable.getData("General_Data", "ItemId")+"']/div/button")).isDisplayed())
				report.updateTestLog("Checking Add To Cart button in List", "Add To Cart button NOT Suppressed", Status.FAIL);
			else
				report.updateTestLog("Checking Add To Cart button in List", "Add To Cart button Suppressed", Status.PASS);
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking Add To Cart button in List", "Add To Cart button Suppressed", Status.PASS);
		}
		
		try{
			String varGetDetails=driver.findElement(By.xpath("//*[@id='"+dataTable.getData("General_Data", "ItemId")+"']/div/div[3]/div[2]/p/a/span")).getText();
			System.out.println(varGetDetails);
			if(varGetDetails.equals("Get Details"))
				report.updateTestLog("Checking Get Details button in List", "Get Details button Displayed", Status.PASS);
			else
				report.updateTestLog("Checking Get Details button in List", "Get Details button Not Displayed", Status.FAIL);
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking Get Details button in List", "Get Details button Not Displayed", Status.FAIL);
		}
		
		try{
			String varInStoreOnly=driver.findElement(By.xpath("//*[@id='"+dataTable.getData("General_Data", "ItemId")+"']/div/div[1]/a[2]")).getText();
			System.out.println(varInStoreOnly);
			if(varInStoreOnly.equals("In-Store Only"))
				report.updateTestLog("Checking In-Store Only in List", "In-Store Only Displayed", Status.PASS);
			else
				report.updateTestLog("Checking In-Store Only in List", "In-Store Only Not Displayed", Status.FAIL);
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking In-Store Only in List", "In-Store Only Not Displayed", Status.FAIL);
		}
		
		//clicking Quick View
		ClickCustomize("xpath", "//*[@id='"+dataTable.getData("General_Data", "ItemId")+"']/div/div[1]/a[2]");
		Thread.sleep(5000);
		try{
			if(driver.findElement(By.xpath(UIMapProductSearch.webElmntQuickViewQtyInStoreOnly)).isDisplayed())
				report.updateTestLog("Checking Qty button in Quick View", "Qty  NOT Suppressed", Status.FAIL);
			else
				report.updateTestLog("Checking Qty in Quick View", "Qty  Suppressed", Status.PASS);
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking Qty in Quick View", "Qty Suppressed", Status.PASS);
		}
		
		try{
			String varGetDetails=driver.findElement(By.xpath(UIMapProductSearch.webElmntQuickViewGetDetailsInStore)).getText();
			System.out.println(varGetDetails);
			if(varGetDetails.equals("Get Details"))
				report.updateTestLog("Checking Get Details button button in Quick View", "Get Details button displayed", Status.PASS);
			else if(varGetDetails.equalsIgnoreCase("Add To Cart"))
				report.updateTestLog("Checking Add To Cart button in Quick View", "Add To Cart button  displayed", Status.FAIL);
			else
				report.updateTestLog("Checking Get Details button in Quick View", "Get Details button NOT displayed", Status.FAIL);
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking Get Details button in Quick View", "Get Details button NOT displayed", Status.FAIL);
		}
		
		try{
			String varInStoreOnly=driver.findElement(By.xpath(UIMapProductSearch.webElmntQuickViewInStore)).getText();
			System.out.println(varInStoreOnly);
			if(varInStoreOnly.equals("In-Store Only"))
				report.updateTestLog("Checking In-Store Only in Quick View", "In-Store Only displayed", Status.PASS);
			
			else
				report.updateTestLog("Checking In-Store Only in Quick View", "In-Store Only NOT displayed", Status.FAIL);
		}
		catch(Exception e)
		{
			report.updateTestLog("Checking In-Store Only in Quick View", "In-Store Only NOT displayed", Status.FAIL);
		}
		
		ClickCustomize("xpath", UIMapProductSearch.webElmntQuickViewGetDetailsInStore);
		selenium.waitForPageToLoad("20000");
		driver.navigate().back();
		selenium.waitForPageToLoad("20000");
		
	}
	
	/**Checking multiples count in Qty dropdown from product list page for an SOS item**/
	public void checkMultiplesCountInQtyPL() throws Exception
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
				break;
			}
			else
				continue;
		}
		String[] s=varID.split("_");
		String varItemId=s[1];
		System.out.println(varItemId);
		int varCount2=fc.countWebElement("//*[@id='quantity_of_"+varItemId+"']/option");
		if(varCount2==100)
			report.updateTestLog("Checking Multiples Count in Qty dropdown from product list", "Multiples Count is 100", Status.PASS);
		else
			report.updateTestLog("Checking Multiples Count in Qty dropdown from product list", "Multiples Count is NOT 100, but:"+varCount2, Status.FAIL);
	}
	
	/**Checking multiples count in Qty dropdown from Details page for an SOS item**/
	public void checkMultiplesCountInQtyDetail() throws Exception
	{
		
		int varCount2=fc.countWebElement(UIMapProductSearch.webElmntMultiplesInQty);
		if(varCount2==100)
			report.updateTestLog("Checking Multiples Count in Qty dropdown from Details", "Multiples Count is 100", Status.PASS);
		else
			report.updateTestLog("Checking Multiples Count in Qty dropdown from Details", "Multiples Count is NOT 100, but:"+varCount2, Status.FAIL);
	}
	
	/** finds a product Not Available in store and checks Get Detail;s button in Quick View***/
	public void chkGetDetailsQuickViewForItemNotAvail() throws Exception
	{
		String varNbrOfPages = driver.findElement(By.className(UIMapProductSearch.webElmntTotalPages)).getText();
		int varNbrOfPages2 = Integer.valueOf(varNbrOfPages);
		System.out.println(varNbrOfPages2);
		int i=0;
		
		for(i = 1;i<=varNbrOfPages2;i++)
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
					break;
				}
				else
					continue;
			}
			ClickCustomize("xpath","//*[@id='"+varID+"']/div/div[1]/a[2]");
			Thread.sleep(4000);
			try{
			String varGetDetails=driver.findElement(By.xpath(UIMapProductSearch.webElmntQuickViewGetDetailsInStore)).getText();
			if(varGetDetails.equalsIgnoreCase("Get Details"))
				{
				report.updateTestLog("Checking Get Details in Quick View", "Get Details displayed in Quick View", Status.PASS);
				ClickCustomize("xpath", UIMapProductSearch.webElmntQuickViewGetDetailsInStore);
				selenium.waitForPageToLoad("20000");
				if(driver.findElement(By.xpath(UIMapProductSearch.webElmntProductDetails)).isDisplayed())
					report.updateTestLog("Clicking Get Details", "Product Details displayed", Status.PASS);
				else
					report.updateTestLog("Clicking Get Details", "Product Details NOT displayed", Status.FAIL);
				}
			else
				report.updateTestLog("Checking Get Details in Quick View", "Get Details NOT displayed in Quick View", Status.FAIL);
				
			}
			catch(Exception e)
			{
				report.updateTestLog("Checking Get Details in Quick View", "Get Details NOT displayed in Quick View", Status.FAIL);
			}
			
			break;
		}
		if(i==(varNbrOfPages2+1))
		{
			report.updateTestLog("Finding Product","Product Not Found", Status.FAIL);
		}
	}
	
	/**Checks Sq foor pricing in Compare Assistant**/
	public void checkSqFootPricingInCompare() throws Exception
	{
		String varNbrOfPages = driver.findElement(By.className(UIMapProductSearch.webElmntTotalPages)).getText();
		int varNbrOfPages2 = Integer.valueOf(varNbrOfPages);
		System.out.println(varNbrOfPages2);
		int i=0;
		
		for(i = 1;i<=varNbrOfPages2;i++)
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
				//String varItemNbr=driver.findElement(By.xpath("//*[@id='"+varID+"']/div/div[4]/ul[1]/li[1]")).getText();
				String varPrice=driver.findElement(By.xpath("//*[@id='"+varID+"']/div/div[3]/p/strong")).getText();
				System.out.println(varPrice);
				if(varPrice.contains(" / Sq. Ft"))
				{
					String varId1=dataTable.getData("General_Data", "ItemId");
					if(varId1.isEmpty())
						dataTable.putData("General_Data", "ItemId", varID);
					else
						dataTable.putData("General_Data", "ItemId2", varID);
					break;
				}
				else
					continue;
			}
			String varId1=dataTable.getData("General_Data", "ItemId");
			String varId2=dataTable.getData("General_Data", "ItemId2");
			ClickCustomize("xpath", "//*[@id='"+varId1+"']/div/div[1]/div/input");
			Thread.sleep(2000);
			ClickCustomize("xpath", "//*[@id='"+varId2+"']/div/div[1]/div/input");
			Thread.sleep(2000);
			ClickCustomize("xpath", UIMapProductSearch.btnCompare);
			selenium.waitForPageToLoad("20000");
			String varPrice1=driver.findElement(By.xpath(UIMapProductSearch.lblCmpreSqFootPrice1)).getText();
			String varPrice2=driver.findElement(By.xpath(UIMapProductSearch.lblCmpreSqFootPrice2)).getText();
			if((varPrice1.contains(" / Sq. Ft")) && (varPrice2.contains(" / Sq. Ft")))
					report.updateTestLog("Checking Sq Foot Pricing in Compare assistant", "Sq Foot Pricing displayed in Compare assistant for both items", Status.PASS);
			else
				 report.updateTestLog("Checking Sq Foot Pricing in Compare assistant", "Sq Foot Pricing NOT displayed in Compare assistant for both items", Status.FAIL);
			
			driver.findElement(By.xpath(UIMapCheckOut.webElmntHome)).click();
			 selenium.waitForPageToLoad("20000");
			 fc.unzipStore();
			 fc.selectDept();
			 fc.selectCat();
			 fc.selectSubCat();
			 ClickCustomize("xpath", "//*[@id='"+varId1+"']/div/div[1]/div/input");
				Thread.sleep(2000);
				ClickCustomize("xpath", "//*[@id='"+varId2+"']/div/div[1]/div/input");
				Thread.sleep(2000);
				ClickCustomize("xpath", UIMapProductSearch.btnCompare);
				selenium.waitForPageToLoad("20000");
				try{
					varPrice1=driver.findElement(By.xpath(UIMapProductSearch.lblCmpreSqFootPrice1)).getText();
					varPrice2=driver.findElement(By.xpath(UIMapProductSearch.lblCmpreSqFootPrice2)).getText();
					if((varPrice1.contains(" / Sq. Ft")) && (varPrice2.contains(" / Sq. Ft")))
						report.updateTestLog("Checking Sq Foot Pricing in Compare assistant", "Sq Foot Pricing displayed in Compare assistant for both items", Status.FAIL);
				}
			 catch(Exception e)
			 {
				 report.updateTestLog("Checking Sq Foot Pricing in Compare assistant", "Sq Foot Pricing NOT displayed in Compare assistant for both items", Status.PASS);
			 }
			break;
		}
		if(i==(varNbrOfPages2+1))
		{
			report.updateTestLog("Finding Product","Product Not Found", Status.FAIL);
		}
	}
	
	/**Checks Map Price Item Compare Bar Hover Price**/
	public void checkMapItemPriceOnCompareBarHover() throws Exception
	{
		String varNbrOfPages = driver.findElement(By.className(UIMapProductSearch.webElmntTotalPages)).getText();
		int varNbrOfPages2 = Integer.valueOf(varNbrOfPages);
		System.out.println(varNbrOfPages2);
		int i=0;
		
		for(i = 1;i<=varNbrOfPages2;i++)
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
				//String varItemNbr=driver.findElement(By.xpath("//*[@id='"+varID+"']/div/div[4]/ul[1]/li[1]")).getText();
				String varPrice=driver.findElement(By.xpath("//*[@id='"+varID+"']/div/div[3]")).getText();
				System.out.println(varPrice);
				if(varPrice.contains("View Price in Cart"))
				{
					if(varPrice.contains("Out of Stock"))
						dataTable.putData("General_Data", "ItemId2", varID);
					else
						dataTable.putData("General_Data", "ItemId", varID);
					String varId1=dataTable.getData("General_Data", "ItemId");
					String varId2=dataTable.getData("General_Data", "ItemId2");
					if(!varId1.isEmpty() && !varId2.isEmpty())
						break;
					else
						continue;
				}
				else
					continue;
			}
			String varId1=dataTable.getData("General_Data", "ItemId");
			String varId2=dataTable.getData("General_Data", "ItemId2");
			ClickCustomize("xpath", "//*[@id='"+varId1+"']/div/div[1]/div/input");
			Thread.sleep(2000);
			ClickCustomize("xpath", "//*[@id='"+varId2+"']/div/div[1]/div/input");
			Thread.sleep(2000);
			
			String[] s1= varId1.split("_");
			String[] s2= varId2.split("_");
			String varID11=s1[1];
			String varID22=s2[1];
			System.out.println(varID11);
			System.out.println(varID22);
			if(varID11.isEmpty())
				report.updateTestLog("Checking Compare Bar Hover Price for Map Price Unavailable Item", "Compare Bar Hover Price for Map Price Unavailable Item Not displayed", Status.PASS );
			else
				report.updateTestLog("Checking Compare Bar Hover Price for Map Price Unavailable Item", "Compare Bar Hover Price for Map Price Unavailable Item displayed", Status.FAIL );	
			
			if(varID22.isEmpty())
				report.updateTestLog("Checking Compare Bar Hover Price for Map Price Available Item", "Compare Bar Hover Price for Map Price Available Item Not displayed", Status.FAIL );
			else
				report.updateTestLog("Checking Compare Bar Hover Price for Map Price Available Item", "Compare Bar Hover Price for Map Price Available Item displayed", Status.PASS );	
			
			break;
		}
		if(i==(varNbrOfPages2+1))
		{
			report.updateTestLog("Finding Product","Product Not Found", Status.FAIL);
		}
	}
	/**Checks In Store Item in list for Non Zipped User**/
	public void chkInStoreItemforNZ() throws Exception
	{
		swtichProductResultsGrid();
		List<WebElement> varProductList = driver.findElements(By.xpath(UIMapProductSearch.webElmntProductList2));
		int varCount = varProductList.size();
		int j;
		String varID=null;
		
		for(j=1;j<=varCount;j++)
		{
			String varZipBoxClass=driver.findElement(By.xpath("//*[@id='productResults']/li["+j+"]/div/div[3]/div[1]")).getAttribute("class");
					if(varZipBoxClass.equals("zipIn"))
						continue;
						
					else
						break;
						
		}
		if(j>varCount)
		
			report.updateTestLog("checking Pricing Area ", "Zip box displayed for all items on page", Status.PASS);
		
		else
			report.updateTestLog("checking Pricing Area ", "Zip box NOT displayed for all items on page", Status.FAIL);
		
		ClickCustomize("xpath", UIMapProductSearch.lnkItem1QuickView);
		Thread.sleep(5000);
		String varZipBoxClass=driver.findElement(By.xpath("//*[@id='descCont']/div[3]")).getAttribute("class");
		if(varZipBoxClass.equals("zipIn"))
			report.updateTestLog("checking Pricing Area ", "Zip box displayed in Quick View", Status.PASS);
		else
			report.updateTestLog("checking Pricing Area ", "Zip box NOT displayed in Quick View", Status.FAIL);
		
		driver.findElement(By.xpath(UIMapCheckOut.webElmntHome)).click();
		 selenium.waitForPageToLoad("20000");
		 fc.searchItemString();
		 swtichProductResultsList();
		 
		 
	}
	
	/**
	 * Checks Quick View & Compare button behaviour
	 */
	public void chkQuickViewCompare() throws Exception
	{
		String varQuickView=driver.findElement(By.xpath(UIMapProductSearch.lnkItem1QuickView)).getAttribute("class");
		if(varQuickView.equals("quickview"))
			report.updateTestLog("Checking Quick View", "Quick View Displayed", Status.PASS);
		else
			report.updateTestLog("Checking Quick View", "Quick View NOT Displayed", Status.FAIL);
		
		String varCompareArea=driver.findElement(By.xpath(UIMapProductSearch.lnkItem1CompareArea)).getAttribute("class");
		
		if(varCompareArea.equals("compareArea"))
			report.updateTestLog("Checking Compare link", "Compare link Displayed", Status.PASS);
		else
			report.updateTestLog("Checking Compare link", "Compare link NOT Displayed", Status.FAIL);
		
		ClickCustomize("xpath", UIMapProductSearch.lnkItem1Compare);
		Thread.sleep(2000);
		String varCompareBtnClass=driver.findElement(By.xpath(UIMapProductSearch.btnCompare2)).getAttribute("class");
		if(varCompareBtnClass.contains("disabled"))
			report.updateTestLog("Checking Compare Button", "Compare Button Disabled", Status.PASS);
		else
			report.updateTestLog("Checking Compare Button", "Compare Button NOT Button", Status.FAIL);
		
		ClickCustomize("xpath", UIMapProductSearch.lnkItem2Compare);
		Thread.sleep(2000);
		varCompareBtnClass=driver.findElement(By.xpath(UIMapProductSearch.btnCompare2)).getAttribute("class");
		if(varCompareBtnClass.contains("disabled"))
			report.updateTestLog("Checking Compare Button", "Compare Button Disabled", Status.FAIL);
		else
			report.updateTestLog("Checking Compare Button", "Compare Button NOT Button", Status.PASS);
		
		ClickCustomize("partialLinkText", "Remove All");
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapCheckOut.webElmntHome)).click();
		 selenium.waitForPageToLoad("20000");
	}
	
	/**Checks Save % not less than 5 % for Was Price Items on PL**/
	public void chkSavingsForWasPrcItems() throws Exception
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
			String varPrice=driver.findElement(By.xpath("//*[@id='"+varID+"']/div/div[3]")).getText();
			
			if(varPrice.contains("Save "))
			{
				String varSavePercnt=driver.findElement(By.xpath("//*[@id='"+varID+"']/div/div[3]/div[2]/p[2]")).getText();
				String pattern = "Save  (\\d+)\\%";
				Pattern r = Pattern.compile(pattern);
				Matcher m = r.matcher(varSavePercnt);
				if(m.find())
				{
					int savePercntValue=Integer.valueOf(m.group(1));
					if(savePercntValue>5)
					{
						System.out.println(m.group(1));
						continue;
					}
					else
						{
						report.updateTestLog("Checking Save %", "Save% less than 5%", Status.FAIL);
						break;
						
						}
				}
				
				
			}
			else
				continue;
		}
		if(j>varCount)
			report.updateTestLog("Checking Save %", "Save% NOT less than 5% for all items", Status.PASS);
	}
	
	public void inspectChangeStoreMH() throws Exception
	{
		ClickCustomize("xpath", UIMapProductSearch.lnkChangeStore2);
		Thread.sleep(10000);
		//checking elements
		fc.chkElementDisplayed("id", UIMapProductSearch.webElmntChangeStorePopup, "Change Store Popup");
		fc.chkElementDisplayed("id", UIMapProductSearch.txtStoreSearch, "Search box");
		fc.chkElementDisplayed("xpath", UIMapProductSearch.txtHeaderSearchSubmit, "Search Icon");
		fc.chkElementDisplayed("xpath", UIMapProductSearch.lnkChangeStoreClose, "Change Store Popup Close link");
		
		String storeName=driver.findElement(By.xpath(UIMapProductSearch.webElmntActiveStore)).getText();
		fc.chkText(UIMapProductSearch.lblYourStoreInPopup, "Your Store:");
		String storeNameInPoup=driver.findElement(By.xpath(UIMapProductSearch.lblActiveStoreNameinPopup)).getText();
		if(storeNameInPoup.equals(storeName))
			report.updateTestLog("Checking Store Name", "Active Store Name displayed", Status.PASS);
		else
			report.updateTestLog("Checking Store Name", "Active Store Name NOT displayed", Status.FAIL);
		fc.chkText(UIMapProductSearch.lnkCurrentStoreShowHideDetails, "Show Details");
		fc.chkText(UIMapProductSearch.lnkFindMoreStores1, "Find More Stores");
		
		ClickCustomize("xpath", UIMapProductSearch.lnkCurrentStoreShowHideDetails);
		Thread.sleep(1000);
		fc.chkText(UIMapProductSearch.lblYourStoreInPopup, "Your Store:");
		storeNameInPoup=driver.findElement(By.xpath(UIMapProductSearch.lblActiveStoreNameinPopup)).getText();
		if(storeNameInPoup.equals(storeName))
			report.updateTestLog("Checking Store Name after clicking Show Details", "Active Store Name displayed", Status.PASS);
		else
			report.updateTestLog("Checking Store Name after clicking Show Details", "Active Store Name NOT displayed", Status.FAIL);
		fc.chkElementDisplayed("xpath", UIMapProductSearch.lblActiveStoreAdd, "Active Store Address");
		checkTextContains(UIMapProductSearch.lblActiveStorePhnFax, "Phone: ", "Store Detailed Info");
		checkTextContains(UIMapProductSearch.lblActiveStorePhnFax, "Fax: ", "Store Detailed Info");
		fc.chkElementDisplayed("xpath", UIMapProductSearch.lblActiveStoreHrs, "Active Store Hours");
		fc.chkText(UIMapProductSearch.lnkActiveStoreViewOnMap, "View on Map");
		fc.chkText(UIMapProductSearch.lnkActiveStoreGetDir, "Get Directions");
		fc.chkText(UIMapProductSearch.lnkCurrentStoreShowHideDetails, "Hide Details");
		fc.chkElementDisplayed("xpath", UIMapProductSearch.lnkActiveStoreHideDetailsUpArrow, "Hide Details Up Arrow");
		
		String varNewStore=driver.findElement(By.xpath(UIMapProductSearch.lblNextStoreName)).getText();
		
		ClickCustomize("xpath", UIMapProductSearch.lnkMakeThisYourStore);
		selenium.waitForPageToLoad("20000");
		storeName=driver.findElement(By.xpath(UIMapProductSearch.webElmntActiveStore)).getText();
		if(storeName.equals(varNewStore))
			report.updateTestLog("Clicking Make This Your Store", "Your Store Updated", Status.PASS);
		else
			report.updateTestLog("Clicking Make This Your Store", "Your Store Updated", Status.FAIL);
		ClickCustomize("linkText", "Find a Store");
		selenium.waitForPageToLoad("20000");
		chkPagetitle("Lowe's: Store locator");
		fc.chkElementDisplayed("xpath", UIMapProductSearch.webElmntMap, "Map");
	}
	
	/*This function switches thr product Results in Grid View*/
	public void swtichProductResultsGrid() throws Exception
	{
		//boolean varGridView1 = selenium.isElementPresent("//*[@id='main_content_rail']/div[3]/div[2]/div[2]/a[2]");
		//if(varGridView1)
		//{
			String varGridView2 = driver.findElement(By.className(UIMapProductSearch.webElmntGridView)).getText();
			System.out.println(varGridView2);
			if(varGridView2.equals("Grid View"))
			{
				
				//driver.findElement(By.className(UIMapProductSearch.webElmntGridView)).click();
				ClickCustomize("className", UIMapProductSearch.webElmntGridView);
				Thread.sleep(5000);
				//report.updateTestLog("Switching to Grid View","Grid View Clicked", Status.DONE);
				//String varGridView3 = driver.findElement(By.xpath("//*[@id='main_content_rail']/div[3]/div[2]/div[2]/a[2]")).getAttribute("class");
				if(driver.findElement(By.cssSelector("a.gridView.current")).isDisplayed())
				{
					report.updateTestLog("Switching to Grid View","Search Results displayed in Grid View", Status.PASS);
				}
				else
				{
					report.updateTestLog("Switching to Grid View","Search Results NOT displayed in Grid View", Status.FAIL);
				}
			}
			else
			{
				report.updateTestLog("Switching to Grid View","Grid View Not Found", Status.FAIL);
			}
	
}
	
	/*This function switches thr product Results in List View*/
	public void swtichProductResultsList() throws Exception
	{
		//boolean varListView1 = selenium.isElementPresent("//*[@id='main_content_rail']/div[3]/div[2]/div[2]/a[1]");
		//boolean varListView1 = selenium.isElementPresent("listView");
		//if(varListView1)
		//{
			String varListView2 = driver.findElement(By.className(UIMapProductSearch.webElmntListView)).getText();
			System.out.println(varListView2);
			if(varListView2.equals("List View"))
			{
				try{
				//driver.findElement(By.className("current gridView")).click();
				ClickCustomize("className", "current gridView");
				}
				catch(Exception NoSuchElementException)
				{
					//driver.findElement(By.className(UIMapProductSearch.webElmntGridView)).click();
					ClickCustomize("className",UIMapProductSearch.webElmntGridView);
				}
				
				Thread.sleep(2000);
				WebElement listView = driver.findElement(By.className(UIMapProductSearch.webElmntListView));
				WebElement bottomBarButtons = listView.findElement(By.xpath("..")); 
				System.out.println(bottomBarButtons+"/a[1]");
				//driver.findElement(By.className(UIMapProductSearch.webElmntListView)).click();
				ClickCustomize("className", UIMapProductSearch.webElmntListView);
				Thread.sleep(2000);
				report.updateTestLog("Switching to List View","List View Clicked", Status.DONE);
				//String varListView3 = driver.findElement(By.xpath("//*[@id='main_content_rail']/div[3]/div[2]/div[2]/a[1]")).getAttribute("class");
				//if(varListView3.equals("listView current"))
				
				if(driver.findElement(By.cssSelector("a.listView.current")).isDisplayed())
				{
					report.updateTestLog("Switching to List View","Search Results displayed in List View", Status.PASS);
				}
				else
				{
					report.updateTestLog("Switching to List View","Search Results NOT displayed in List View", Status.FAIL);
				}
			}
			else
			{
				report.updateTestLog("Switching to List View","List View Not Found", Status.FAIL);
			}
			
		//}
		//else
		//{
		//	report.updateTestLog("Switching to List View","List View Not Found", Status.FAIL);
		//}
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
}
	











