package com.lowes.qa.selenium.components;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.cognizant.framework.Status;
import com.lowes.qa.selenium.support.ReusableLibrary;
import com.lowes.qa.selenium.support.ScriptHelper;
import com.lowes.qa.selenium.uimap.UIMapFunctionalComponents;
import com.lowes.qa.selenium.uimap.UIMapMyLowes;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class HomeProfile_Dim extends ReusableLibrary
{
	String baseurl = dataTable.getData("General_Data", "URL");
	Selenium selenium = new WebDriverBackedSelenium(driver, baseurl);
	public HomeProfile_Dim(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
	}
	//ProductSearch ps = new ProductSearch(scriptHelper);
	//PS2 ps2=new PS2(scriptHelper);
	FunctionalComponents fc=new FunctionalComponents(scriptHelper);
	//MyLowes2 mid=new MyLowes2(scriptHelper);
	//CheckOut_CM cm= new CheckOut_CM(scriptHelper);
	
	
	public void clickGetQuickAccurateLink() throws Exception
	{
		ClickCustomize("linkText", "Get Quick, Accurate Measurements");
		Thread.sleep(2000);
		
		String oldTab = driver.getWindowHandle();
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		newTab.remove(oldTab);
		// change focus to new tab
	    driver.switchTo().window(newTab.get(0));
	    Thread.sleep(5000);
	    fc.chkPagetitle("MyLowe's Laser Measuring Video Tutorial");
	   fc.chkElementDisplayed("xpath", UIMapMyLowes.webElmntBoschToolVideo, "Bosch Tool Video");
	    driver.close();
	    driver.switchTo().window(oldTab);
	}
	
	/**Checks batch delete checkBox**/
	public void chkCalcBatchDeleteChkBox() throws Exception
	{
		//selecting batch delete
		ClickCustomize("id", UIMapMyLowes.chkBoxCalcBatchDelete);
		Thread.sleep(2000);
		int varCount=fc.countWebElement(UIMapMyLowes.chkBoxCalcAll);
		int i=0;
		String varChecked=null;
		for(i=1;i<=varCount;i++)
		{
			try{
				varChecked=driver.findElement(By.xpath("//*[@id='calculationsContainer']/div[2]/div[3]/div["+i+"]/div[2]/input")).getAttribute("checked");
				if(varChecked.equals("true"))
					{
					continue;
					}
				else
				{
					System.out.println("Not True for:"+i+varChecked);
					break;
					
				}
					
			}
			catch(Exception e)
			{
				System.out.println("Not True for:"+i+varChecked);
				report.updateTestLog("Checking All Calc checkboxes on clicking Batch Delete", "All Calc NOT selected", Status.FAIL);
				break;
			}
		}
		if(i>varCount)
			report.updateTestLog("Checking All Calc checkboxes on clicking Batch Delete", "All Calc selected", Status.PASS);
		else
			report.updateTestLog("Checking All Calc checkboxes on clicking Batch Delete", "All Calc NOT selected", Status.FAIL);
		//deselecting batch delete
		ClickCustomize("id", UIMapMyLowes.chkBoxCalcBatchDelete);
		Thread.sleep(2000);
		for(i=1;i<=varCount;i++)
		{
			try{
				varChecked=driver.findElement(By.xpath("//*[@id='calculationsContainer']/div[2]/div[3]/div["+i+"]/div[2]/input")).getAttribute("checked");
				if(varChecked.equals("true"))
					{
					System.out.println("True for:"+i+varChecked);
					break;
					}
				else
				{
					continue;
					
				}
					
			}
			catch(Exception e)
			{
				continue;
			}
		}
		if(i>varCount)
			report.updateTestLog("Checking All Calc checkboxes on Deselecting Batch Delete", "All Calc deselected", Status.PASS);
		else
			report.updateTestLog("Checking All Calc checkboxes on Deselecting Batch Delete", "All Calc NOT deselected", Status.FAIL);
		
		
		
	}
	
	/**Checks Calculation page layout with atleast one calculation**/
	public void chkCalcPgLayoutWithCalcAdded() throws Exception
	{
		int varCount=fc.countWebElement(UIMapMyLowes.webElmntAllCalc);
		System.out.println(varCount);
		int i=0;
		for(i=1;i<=varCount;i++)
		{
			fc.chkElementDisplayed("xpath", "//*[@id='calculationsContainer']/div[2]/div[3]/div["+i+"]/div[2]/div[2]/div[1]/h5", "Calculation Name for Calc"+i);
			fc.chkText("//*[@id='calculationsContainer']/div[2]/div[3]/div["+i+"]/div[2]/div[2]/div[1]/div/a[1]", "Show Details");
			fc.chkElementDisplayed("xpath", "//*[@id='calculationsContainer']/div[2]/div[3]/div["+i+"]/div[2]/div[2]/div[1]/div/a[2]/img", "Trashcan icon for Calc"+i);
			fc.chkElementDisplayed("xpath", "//*[@id='calculationsContainer']/div[2]/div[3]/div["+i+"]/div[2]/input", "Checkbox for Calc"+i);
		}
	}
	
	/**Clicks Hide details for a calculation**/
	public void clickHideDetails() throws Exception
	{
		ClickCustomize("partialLinkText", "Hide Details");
		Thread.sleep(2000);
		String varClass=driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc1Drawer)).getAttribute("class");
		if(varClass.equals("drawer closed"))
			report.updateTestLog("Clicking Hide Details", "Calc Drawer closed", Status.PASS);
		else
		{
			report.updateTestLog("Clicking Hide Details", "Calc Drawer NOT closed:"+varClass, Status.FAIL);
		}
		
	}
	
	/**checks Calculator Sort bar when space is having atleast 1 Paint calculation**/
	public void checkCalcSortBar() throws Exception
	{
		fc.chkElementDisplayed("xpath", UIMapMyLowes.webElmntTotalCalc, "Calculations count");
		fc.chkText(UIMapMyLowes.webElmntGoToPrjctCalc, "Go to Project Calculators");
		fc.chkText(UIMapMyLowes.webElmntCalcShowLabel, "Show:");
		fc.chkElementDisplayed("xpath", UIMapMyLowes.webElmntCalcShow, "Show Mechanism");
		fc.chkElementDisplayed("id", UIMapMyLowes.chkBoxCalcBatchDelete, "Batch Delete CheckBox");
		fc.chkElementDisplayed("xpath", UIMapMyLowes.webElmntActions, "Actions Drop-down");
	}
	
	/**Check Custom Shape **/
	public void chkCustomShape() throws Exception
	{
		ClickCustomize("id", UIMapMyLowes.webElmntCustomShape);
		Thread.sleep(2000);
		fc.chkText(UIMapMyLowes.labelCustomShapeMsg, "Select another square below or beside this square to draw a wall.");
		//drawing horizontal line-undo
		ClickCustomize("id", "cell_14_2");
		Thread.sleep(2000);
		fc.chkElementDisplayed("xpath", "//*[@id='cell_2_2']/div[2]", "Horizontal Line");
		ClickCustomize("xpath", UIMapMyLowes.btnCustomShapeUndo);
		Thread.sleep(2000);
		String varClass=driver.findElement(By.xpath(UIMapMyLowes.btnCustomShapeUndo)).getAttribute("disabled");
		System.out.println(varClass);
		if(varClass.equals("true"))
			report.updateTestLog("Selecting Undo After drawing horizontal line", "Undo disabled", Status.PASS);
		else
			report.updateTestLog("Selecting Undo After drawing horizontal line", "Undo disabled", Status.FAIL);
		try{
		if(driver.findElement(By.xpath("//*[@id='cell_2_2']/div[2]")).isDisplayed())
			report.updateTestLog("Selecting Undo After drawing horizontal line", "Horizontal line still displayed", Status.FAIL);
		else
			report.updateTestLog("Selecting Undo After drawing horizontal line", "Horizontal line NOT displayed", Status.PASS);
		}
		catch(Exception e)
		{
			report.updateTestLog("Selecting Undo After drawing horizontal line", "Horizontal line NOT displayed", Status.PASS);
		}
		//drawing horizontal line-vertical line-undo
		ClickCustomize("id", "cell_14_2");
		Thread.sleep(2000);
		fc.chkElementDisplayed("xpath", "//*[@id='cell_2_2']/div[2]", "Horizontal Line");
		ClickCustomize("id", "cell_14_10");
		Thread.sleep(2000);
		fc.chkElementDisplayed("xpath", "//*[@id='cell_14_2']/div", "Vertical Line");
		ClickCustomize("xpath", UIMapMyLowes.btnCustomShapeUndo);
		Thread.sleep(2000);
		try{
		varClass=driver.findElement(By.xpath(UIMapMyLowes.btnCustomShapeUndo)).getAttribute("disabled");
		System.out.println(varClass);
		if(varClass.equals("true"))
			report.updateTestLog("Selecting Undo After drawing Vertical line", "Undo disabled", Status.FAIL);
		else
			report.updateTestLog("Selecting Undo After drawing Vertical line", "Undo NOT disabled", Status.PASS);
		}
		catch(Exception e)
		{
			report.updateTestLog("Selecting Undo After drawing Vertical line", "Undo NOT disabled", Status.PASS);
		}
		try{
			if(driver.findElement(By.xpath("//*[@id='cell_14_2']/div[2]")).isDisplayed())
				report.updateTestLog("Selecting Undo After drawing Vertical line", "Vertical line still displayed", Status.FAIL);
			else
				report.updateTestLog("Selecting Undo After drawing Vertical line", "Vertical line NOT displayed", Status.PASS);
			}
			catch(Exception e)
			{
				report.updateTestLog("Selecting Undo After drawing Vertical line", "Vertical line NOT displayed", Status.PASS);
			}
		try{
			if(driver.findElement(By.xpath("//*[@id='cell_2_2']/div[2]")).isDisplayed())
				report.updateTestLog("Selecting Undo After drawing Vertical line", "Horizontal line displayed", Status.PASS);
			else
				report.updateTestLog("Selecting Undo After drawing Vertical line", "Horizontal line NOT displayed", Status.FAIL);
			}
			catch(Exception e)
			{
				report.updateTestLog("Selecting Undo After drawing Vertical line", "Horizontal line NOT displayed", Status.FAIL);
			}
		
		//drawing additional lines till shape is complete
		ClickCustomize("id", "cell_14_10");
		Thread.sleep(2000);
		ClickCustomize("id", "cell_9_10");
		Thread.sleep(2000);
		ClickCustomize("id", "cell_9_7");
		Thread.sleep(2000);
		ClickCustomize("id", "cell_5_7");
		Thread.sleep(2000);
		ClickCustomize("id", "cell_5_5");
		Thread.sleep(2000);
		ClickCustomize("id", "cell_2_5");
		Thread.sleep(2000);
		ClickCustomize("xpath", "//*[@id='cell_2_2']/div[1]");
		Thread.sleep(5000);
		
		fc.chkText(UIMapMyLowes.labelCustomShapeMsg2, "Once you've finished selecting the shape and position of your room, select Continue.");
		varClass=driver.findElement(By.xpath(UIMapMyLowes.btnRotate1)).getAttribute("class");
		String varClass2=driver.findElement(By.xpath(UIMapMyLowes.btnRotate2)).getAttribute("class");
		if(varClass.contains("disabled") || varClass2.contains("disabled"))
			report.updateTestLog("Checking Rotate buttons after Custom shape is drawn", "Rotate buttons Disabled", Status.FAIL);
		else
			report.updateTestLog("Checking Rotate buttons after Custom shape is drawn", "Rotate buttons Enabled", Status.PASS);
		
		varClass=driver.findElement(By.xpath(UIMapMyLowes.btnFlip1)).getAttribute("class");
		varClass2=driver.findElement(By.xpath(UIMapMyLowes.btnFlip2)).getAttribute("class");
		if(varClass.contains("disabled") || varClass2.contains("disabled"))
			report.updateTestLog("Checking Flip buttons after Custom shape is drawn", "Flip buttons Disabled", Status.FAIL);
		else
			report.updateTestLog("Checking Flip buttons after Custom shape is drawn", "Flip buttons Enabled", Status.PASS);
		
		if(driver.findElement(By.xpath(UIMapMyLowes.btnCustomShapeContinue)).isEnabled())
			report.updateTestLog("Checking Continue button after Custom shape is drawn", "Continue button Enabled", Status.PASS);
		else
			report.updateTestLog("Checking Continue button after Custom shape is drawn", "Continue button Disabled", Status.PASS);
	}
	
	/**Store Negative space value in data sheet**/
	public void storeInvalidNegSpaceInDataSheet() throws Exception
	{
		dataTable.putData("General_Data", "NegSpaceArea", "200");
	}
	
	public void documentUploadInSpace() throws Exception
	{
			
		int varCount=fc.countWebElement(UIMapMyLowes.webElmntDocsCount);
		System.out.println(varCount);
		try{
			driver.findElement(By.xpath(UIMapMyLowes.btnUploadDocInSpace)).click();
		}
		catch(Exception e)
		{
			driver.findElement(By.xpath(UIMapMyLowes.btnUploadFrstDocInSpace)).click();
		}
		
			Thread.sleep(5000);
			Robot r = new Robot(); 
			r.keyPress(KeyEvent.VK_D);        // D
			r.keyRelease(KeyEvent.VK_D);
			
			r.keyPress(KeyEvent.VK_SHIFT);              // : (colon)
			r.keyPress(KeyEvent.VK_SEMICOLON);
			r.keyRelease(KeyEvent.VK_SEMICOLON);
			r.keyRelease(KeyEvent.VK_SHIFT);
			r.keyPress(KeyEvent.VK_BACK_SLASH );    // \ (back slash)
			r.keyRelease(KeyEvent.VK_BACK_SLASH );
			r.keyPress(KeyEvent.VK_T);        // T
			r.keyRelease(KeyEvent.VK_T);
			r.keyPress(KeyEvent.VK_PERIOD); 
			r.keyRelease(KeyEvent.VK_PERIOD); 
			r.keyPress(KeyEvent.VK_T);        // t
			r.keyRelease(KeyEvent.VK_T);
			r.keyPress(KeyEvent.VK_X);        // x
			r.keyRelease(KeyEvent.VK_X);
			r.keyPress(KeyEvent.VK_T);        // t
			r.keyRelease(KeyEvent.VK_T);
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_ENTER); 
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);

			
			String successfulUpload=driver.findElement(By.xpath(UIMapMyLowes.webElmntDocsUploadSuccessMsg)).getText();
			Thread.sleep(2000);

			if(successfulUpload.contains("Upload complete"))
			{

				int divCount=fc.countWebElement("html/body/div");
				System.out.println("//div["+(divCount-((varCount*2)+1))+"]/div[1]/a/span");
				driver.findElement(By.xpath("//div["+(divCount-((varCount*2)+1))+"]/div[1]/a/span")).click();
				
			}
			else if(successfulUpload.contains("Server error. Try again."))
				report.updateTestLog("Trying to upload Document","Upload Failed. Server Error",Status.FAIL);
			else
			{
				report.updateTestLog("Trying to attach a document","Document attachment failed",Status.FAIL);
			}
			Thread.sleep(5000);	
			//document 2 upload
			varCount=fc.countWebElement(UIMapMyLowes.webElmntDocsCount);
			System.out.println(varCount);
			try{
				driver.findElement(By.xpath(UIMapMyLowes.btnUploadDocInSpace)).click();
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath(UIMapMyLowes.btnUploadFrstDocInSpace)).click();
			}
				Thread.sleep(5000);
				r = new Robot(); 
				r.keyPress(KeyEvent.VK_D);        // D
				r.keyRelease(KeyEvent.VK_D);
				
				r.keyPress(KeyEvent.VK_SHIFT);              // : (colon)
				r.keyPress(KeyEvent.VK_SEMICOLON);
				r.keyRelease(KeyEvent.VK_SEMICOLON);
				r.keyRelease(KeyEvent.VK_SHIFT);
				r.keyPress(KeyEvent.VK_BACK_SLASH );    // \ (back slash)
				r.keyRelease(KeyEvent.VK_BACK_SLASH );
				r.keyPress(KeyEvent.VK_A);        // A
				r.keyRelease(KeyEvent.VK_A);
				r.keyPress(KeyEvent.VK_PERIOD); 
				r.keyRelease(KeyEvent.VK_PERIOD); 
				r.keyPress(KeyEvent.VK_T);        // t
				r.keyRelease(KeyEvent.VK_T);
				r.keyPress(KeyEvent.VK_X);        // x
				r.keyRelease(KeyEvent.VK_X);
				r.keyPress(KeyEvent.VK_T);        // t
				r.keyRelease(KeyEvent.VK_T);
				Thread.sleep(2000);
				r.keyPress(KeyEvent.VK_ENTER); 
				r.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(3000);

				successfulUpload=driver.findElement(By.xpath(UIMapMyLowes.webElmntDocsUploadSuccessMsg)).getText();
				Thread.sleep(2000);

				if(successfulUpload.contains("Upload complete"))
				{

					int divCount=fc.countWebElement("html/body/div");
					System.out.println("//div["+(divCount-((varCount*2)+1))+"]/div[1]/a/span");
					driver.findElement(By.xpath("//div["+(divCount-((varCount*2)+1))+"]/div[1]/a/span")).click();

					
					

			}
			else if(successfulUpload.contains("Server error. Try again."))
				report.updateTestLog("Trying to upload Document","Upload Failed. Server Error",Status.FAIL);
			else
			{
				report.updateTestLog("Trying to attach a document","Document attachment failed",Status.FAIL);
			}
		
				Thread.sleep(5000);	
	}
	
	/**Clicks on Show Mechanism on HP page and selects Products**/
	public void showAllProducts() throws Exception
	{
		ClickCustomize("xpath",UIMapMyLowes.drpDownShow);
		Thread.sleep(1000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntShowAllProducts)).click();
		Thread.sleep(5000);
	}
	}
	



	
	

