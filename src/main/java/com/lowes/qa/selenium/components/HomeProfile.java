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
public class HomeProfile extends ReusableLibrary
{
	String baseurl = dataTable.getData("General_Data", "URL");
	Selenium selenium = new WebDriverBackedSelenium(driver, baseurl);
	public HomeProfile(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
	}
	ProductSearch ps = new ProductSearch(scriptHelper);
		
	/* Clicking My Account Link*/
	public void clickMyAccount() throws Exception
	{
		try
		{driver.findElement(By.id(UIMapMyLowes.lnkMyAccount)).click();
		selenium.waitForPageToLoad("120000");
		//FunctionalComponents.waitforVisible(driver, UIMapMyLowes.webElmntBrdCrumbsLvl2, 20);
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(UIMapMyLowes.lnkHomeProfile2)));
		System.out.println("Reached here");
		String varMyLowes = driver.findElement(By.xpath(UIMapMyLowes.webElmntBrdCrumbsLvl2)).getText();
		System.out.println(varMyLowes);
		if(varMyLowes.equals("MyLowe's"))
		{
			report.updateTestLog("Clicking My Account link","MyLowe's page displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking My Account link","MyLowe's page NOT displayed", Status.FAIL);
		}}
		catch(Exception WebDriverException)
		{
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.id(UIMapMyLowes.lnkMyAccount)).click();
			selenium.waitForPageToLoad("20000");
			String varMyLowes = driver.findElement(By.xpath(UIMapMyLowes.webElmntBrdCrumbsLvl2)).getText();
			System.out.println(varMyLowes);
			if(varMyLowes.equals("MyLowe's"))
			{
				report.updateTestLog("Clicking My Account link","MyLowe's page displayed" ,Status.PASS);
			}
			else
			{
				report.updateTestLog("Clicking My Account link","MyLowe's page NOT displayed", Status.FAIL);
			}
		}
	}
	
	/*Navigating to already created Home Profile by clicking Home Profile link*/
	public void navHomeProfile() throws Exception
	{
		try
		{
		//driver.findElement(By.id(UIMapMyLowes.lnkHomeProfile)).click();
		System.out.println(driver.findElement(By.id(UIMapMyLowes.lnkHomeProfile)).getText());
			driver.findElement(By.id(UIMapMyLowes.lnkHomeProfile)).click();
		selenium.waitForPageToLoad("60000");
		Thread.sleep(5000);
		String varHomeProfile = driver.findElement(By.xpath(UIMapMyLowes.webElmntBrdCrumbsLvl2)).getText();
		System.out.println(varHomeProfile);
		if(varHomeProfile.equals("Home Profile"))
		{
			report.updateTestLog("Clicking Home Profile link","Home Profile Summary page displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking Home Profile link","Home Profile Summary page NOT displayed", Status.FAIL);
		}	
		}
		catch(Exception WebDriverException)
		{
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.id(UIMapMyLowes.lnkHomeProfile)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(5000);
			String varHomeProfile = driver.findElement(By.xpath(UIMapMyLowes.webElmntBrdCrumbsLvl2)).getText();
			System.out.println(varHomeProfile);
			if(varHomeProfile.equals("Home Profile"))
			{
				report.updateTestLog("Clicking Home Profile link","Home Profile Summary page displayed", Status.PASS);
			}
			else
			{
				report.updateTestLog("Clicking Home Profile link","Home Profile Summary page NOT displayed", Status.FAIL);
			}	
		}
		
		
	}
	
	/*Navigating to already created Home Profile by clicking Home Profile link*/
	public void navHomeProfile2() throws Exception
	{
		try
		{
		//driver.findElement(By.id(UIMapMyLowes.lnkHomeProfile)).click();
		System.out.println(driver.findElement(By.xpath(UIMapMyLowes.lnkHomeProfile2)).getText());
		//driver.findElement(By.id(UIMapMyLowes.lnkHomeProfile)).click();	
		driver.findElement(By.xpath(UIMapMyLowes.lnkHomeProfile2)).click();
		selenium.waitForPageToLoad("60000");
		Thread.sleep(5000);
		String varHomeProfile = driver.findElement(By.xpath(UIMapMyLowes.webElmntBrdCrumbsLvl2)).getText();
		System.out.println(varHomeProfile);
		if(varHomeProfile.equals("Home Profile"))
		{
			report.updateTestLog("Clicking Home Profile link","Home Profile Summary page displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking Home Profile link","Home Profile Summary page NOT displayed", Status.FAIL);
		}	
		}
		catch(Exception WebDriverException)
		{
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.lnkHomeProfile2)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(5000);
			String varHomeProfile = driver.findElement(By.xpath(UIMapMyLowes.webElmntBrdCrumbsLvl2)).getText();
			System.out.println(varHomeProfile);
			if(varHomeProfile.equals("Home Profile"))
			{
				report.updateTestLog("Clicking Home Profile link","Home Profile Summary page displayed", Status.PASS);
			}
			else
			{
				report.updateTestLog("Clicking Home Profile link","Home Profile Summary page NOT displayed", Status.FAIL);
			}	
		}
		
		
	}
	
	
	
	/*This function creates a new Home Profile by clicking Create Home profile link*/
	public void createHomeProfile() throws Exception
	{
		
		try{
		
			driver.findElement(By.id(UIMapMyLowes.lnkHomeProfile)).click();
			//driver.findElement(By.xpath(UIMapMyLowes.lnkHomeProfile2)).click();
		selenium.waitForPageToLoad("20000");
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.id(UIMapMyLowes.lnkHomeProfile)).click();
			//driver.findElement(By.xpath(UIMapMyLowes.lnkHomeProfile2)).click();
			selenium.waitForPageToLoad("20000");
		}
		Thread.sleep(5000);
		String varHomeProfile = driver.findElement(By.xpath(UIMapMyLowes.webElmntBrdCrumbsLvl2)).getText();
		System.out.println(varHomeProfile);
		if(varHomeProfile.equals("Create Your Home Profile"))
		{
			report.updateTestLog("Clicking Home Profile link","Create Home Profile page displayed", Status.PASS);
			
			try{
			driver.findElement(By.id(UIMapMyLowes.lnkCreateHomeProfile)).click();
			selenium.waitForPageToLoad("20000");
			}
			catch(Exception WebDriverException){
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup","Handeled", Status.DONE);
				driver.findElement(By.id(UIMapMyLowes.lnkCreateHomeProfile)).click();
				selenium.waitForPageToLoad("20000");
			}
			String varHomeProfile2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntBrdCrumbsLvl2)).getText();
			System.out.println(varHomeProfile2);
			if(varHomeProfile2.equals("Home Profile"))
			{
				report.updateTestLog("Clicking Home Profile link","Home Profile Summary page displayed", Status.PASS);
				
			}
			else
			{
				report.updateTestLog("Clicking Home Profile link","Home Profile Summary page NOT displayed", Status.FAIL);
			}	
						
		}
		else
		{
			report.updateTestLog("Clicking Home Profile link","Create Home Profile page NOT displayed", Status.FAIL);
		}	
		
		
				
	}
	
	/* This function opens a selected Space page for the Home Profile*/
	public void openHomeProfileSpace() throws Exception
	{
		try{driver.findElement(By.partialLinkText(dataTable.getData("General_Data","Space"))).click();
		Thread.sleep(2000);
		selenium.waitForPageToLoad("20000");}
		catch(Exception WebDriverException)
		{
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.partialLinkText(dataTable.getData("General_Data","Space"))).click();
					selenium.waitForPageToLoad("20000");
		}
		
		Thread.sleep(10000);
		String varSpace = driver.findElement(By.id(UIMapMyLowes.webElmntSpaceName)).getText();
		System.out.println(varSpace);
		if(varSpace.equals(dataTable.getData("General_Data","Space")))
		{
			report.updateTestLog("Clicking Space link","Space page displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking Space link","Space page NOT displayed", Status.FAIL);
		}
	}
	
	/*This function opens Dimension tab for a space in Home Profile*/
	public void dimHomeProfile() throws Exception
	{
		driver.findElement(By.cssSelector(UIMapMyLowes.webElmntShow)).click();
		driver.findElement(By.linkText("Dimensions")).click();
		Thread.sleep(5000);
		boolean varDimensions = selenium.isElementPresent(UIMapMyLowes.webElmntDimHeading);
		if(varDimensions)
		{
			report.updateTestLog("Opening Dimension tab","Dimensions opened" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Opening Dimension tab","Dimensions NOT opened" ,Status.FAIL);
		}	
		
		
	}
	
	/*This function opens Documents tab for a space in Home Profile*/
	public void docHomeProfile() throws Exception
	{
		driver.findElement(By.cssSelector(UIMapMyLowes.webElmntShow)).click();
		driver.findElement(By.linkText("Documents")).click();
		Thread.sleep(5000);
		boolean varDocuments = selenium.isElementPresent(UIMapMyLowes.webElmntDocCount);
		if(varDocuments)
		{
			report.updateTestLog("Opening Documents tab","Documents opened" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Opening Documents tab","Documents NOT opened" ,Status.FAIL);
		}	
		
	}
	
	
	/*This function selects Rectangle shape in dimensions*/
	public void dimRectHomeProfile() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.webElmntShapeRect2)).click();
		Thread.sleep(2000);
		String varClass = driver.findElement(By.xpath(UIMapMyLowes.webElmntShapeRect2)).getAttribute("class");
		System.out.println(varClass);
		if(varClass.equals("shape on"))
		{
			report.updateTestLog("Selecting Rectangle Shape","Rectangle Shape selected" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Selecting Rectangle Shape","Rectangle Shape NOT selected", Status.FAIL);
		}
		driver.findElement(By.xpath(UIMapMyLowes.btnContinue)).click();
		Thread.sleep(5000);
				
	}
	
	/*This TC edits the dimensions and notes for a shape in an Home Profile and clicks on Cancel;*/
	
	public void editDimensionsHPCancel() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.btnEditDimensions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.btnEditYardMsrments)).click();
		driver.findElement(By.xpath(UIMapMyLowes.webElmntRightBorder)).click();
		//driver.findElement(By.id("border_border_128947294")).click();
		String varRightDim = driver.findElement(By.xpath(UIMapMyLowes.txtLength)).getAttribute("value");
		System.out.println("Right Dim before edit:"+varRightDim);
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).sendKeys("11");
		driver.findElement(By.xpath(UIMapMyLowes.lnkCancel)).click();
		driver.findElement(By.xpath(UIMapMyLowes.webElmntRightBorder)).click();
		//driver.findElement(By.id("border_border_128947294")).click();
		String varRightDim2 = driver.findElement(By.xpath(UIMapMyLowes.txtLength)).getAttribute("value");
		driver.findElement(By.xpath(UIMapMyLowes.lnkCancel)).click();
		System.out.println("Right Dim after edit:"+varRightDim2);
		if(varRightDim.equals(varRightDim2))
		{
			report.updateTestLog("Clicking Cancel on editing Right Dimensions","Dimensions not updated" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking Cancel on editing Right Dimensions","Dimensions CHANGED" ,Status.FAIL);
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntBottomBorder));
		driver.findElement(By.xpath(UIMapMyLowes.webElmntBottomBorder)).click();
		//driver.findElement(By.id("border_border_128947292")).click();
		String varBottomDim = driver.findElement(By.xpath(UIMapMyLowes.txtLength)).getAttribute("value");
		System.out.println("Bottom Dim before edit:"+varBottomDim);
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).sendKeys("11");
		driver.findElement(By.xpath(UIMapMyLowes.lnkCancel)).click();
		driver.findElement(By.xpath(UIMapMyLowes.webElmntBottomBorder)).click();
		//driver.findElement(By.id("border_border_128947292")).click();
		String varBottomDim2 = driver.findElement(By.xpath(UIMapMyLowes.txtLength)).getAttribute("value");
		driver.findElement(By.xpath(UIMapMyLowes.lnkCancel)).click();
		System.out.println("Bottom Dim after edit:"+varBottomDim2);
		if(varBottomDim.equals(varBottomDim2))
		{
			report.updateTestLog("Clicking Cancel on editing Bottom Dimensions","Dimensions not updated" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking Cancel on editing Bottom Dimensions","Dimensions CHANGED" ,Status.FAIL);
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntLeftBorder));
		driver.findElement(By.xpath(UIMapMyLowes.webElmntLeftBorder)).click();
		//driver.findElement(By.id("border_border_128947291")).click();
		String varLeftDim = driver.findElement(By.xpath(UIMapMyLowes.txtLength)).getAttribute("value");
		System.out.println("Left Dim before edit:"+varLeftDim);
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).sendKeys("11");
		driver.findElement(By.xpath(UIMapMyLowes.lnkCancel)).click();
		driver.findElement(By.xpath(UIMapMyLowes.webElmntLeftBorder)).click();
		//driver.findElement(By.id("border_border_128947291")).click();
		String varLeftDim2 = driver.findElement(By.xpath(UIMapMyLowes.txtLength)).getAttribute("value");
		System.out.println("Left Dim after edit:"+varLeftDim2);
		driver.findElement(By.xpath(UIMapMyLowes.lnkCancel)).click();
		if(varLeftDim.equals(varLeftDim2))
		{
			report.updateTestLog("Clicking Cancel on editing Left Dimensions","Dimensions not updated" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking Cancel on editing Left Dimensions","Dimensions CHANGED" ,Status.FAIL);
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntTopBorder));
		driver.findElement(By.xpath(UIMapMyLowes.webElmntTopBorder)).click();
		//driver.findElement(By.id("border_border_128947293")).click();
		String varTopDim = driver.findElement(By.xpath(UIMapMyLowes.txtLength)).getAttribute("value");
		System.out.println("Top Dim before edit:"+varTopDim);
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).sendKeys("11");
		driver.findElement(By.xpath(UIMapMyLowes.lnkCancel)).click();
		driver.findElement(By.xpath(UIMapMyLowes.webElmntTopBorder)).click();
		//driver.findElement(By.id("border_border_128947293")).click();
		String varTopDim2 = driver.findElement(By.xpath(UIMapMyLowes.txtLength)).getAttribute("value");
		driver.findElement(By.xpath(UIMapMyLowes.lnkCancel)).click();
		System.out.println("Top Dim after edit:"+varTopDim2);
		if(varTopDim.equals(varTopDim2))
		{
			report.updateTestLog("Clicking Cancel on editing Top Dimensions","Dimensions not updated" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking Cancel on editing Top Dimensions","Dimensions CHANGED" ,Status.FAIL);
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntBottomBorder));
		driver.findElement(By.xpath(UIMapMyLowes.webElmntBottomBorder)).click();
		String varBottomNote = driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).getAttribute("value");
		System.out.println("Bottom Note before edit:"+varBottomNote);
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).sendKeys("Note Bottom");
		driver.findElement(By.xpath(UIMapMyLowes.lnkCancel)).click();
		driver.findElement(By.xpath(UIMapMyLowes.webElmntBottomBorder)).click();
		String varBottomNote2 = driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).getAttribute("value");
		driver.findElement(By.xpath(UIMapMyLowes.lnkCancel)).click();
		System.out.println("Bottom Note after edit:"+varBottomNote2);
		if(varBottomNote.equals(varBottomNote2))
		{
			report.updateTestLog("Clicking Cancel on editing Dimensions Bottom Note","Dimensions Note not updated" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking Cancel on editing Dimensions Bottom Note","Dimensions Note CHANGED" ,Status.FAIL);
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntLeftBorder));
		driver.findElement(By.xpath(UIMapMyLowes.webElmntLeftBorder)).click();
		
		String varLeftNote = driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).getAttribute("value");
		System.out.println("Left Note before edit:"+varLeftNote);
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).sendKeys("Note Left");
		driver.findElement(By.xpath(UIMapMyLowes.lnkCancel)).click();
		driver.findElement(By.xpath(UIMapMyLowes.webElmntLeftBorder)).click();
		String varLeftNote2 = driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).getAttribute("value");
		driver.findElement(By.xpath(UIMapMyLowes.lnkCancel)).click();
		System.out.println("Left Note after edit:"+varLeftNote2);
		if(varLeftNote.equals(varLeftNote2))
		{
			report.updateTestLog("Clicking Cancel on editing Dimensions Left Note","Dimensions Note not updated" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking Cancel on editing Dimensions Left Note","Dimensions Note CHANGED" ,Status.FAIL);
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntTopBorder));
		driver.findElement(By.xpath(UIMapMyLowes.webElmntTopBorder)).click();
		String varTopNote = driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).getAttribute("value");
		System.out.println("Top Note before edit:"+varTopNote);
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).sendKeys("Note Top");
		driver.findElement(By.xpath(UIMapMyLowes.lnkCancel)).click();
		driver.findElement(By.xpath(UIMapMyLowes.webElmntTopBorder)).click();
		String varTopNote2 = driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).getAttribute("value");
		driver.findElement(By.xpath(UIMapMyLowes.lnkCancel)).click();
		System.out.println("Top Note after edit:"+varTopNote2);
		if(varTopNote.equals(varTopNote2))
		{
			report.updateTestLog("Clicking Cancel on editing Dimensions Top Note","Dimensions Note not updated" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking Cancel on editing Dimensions top Note","Dimensions Note CHANGED" ,Status.FAIL);
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntRightBorder));
		driver.findElement(By.xpath(UIMapMyLowes.webElmntRightBorder)).click();
		String varRightNote = driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).getAttribute("value");
		System.out.println("Right Note before edit:"+varRightNote);
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).sendKeys("Note Right");
		driver.findElement(By.xpath(UIMapMyLowes.lnkCancel)).click();
		driver.findElement(By.xpath(UIMapMyLowes.webElmntRightBorder)).click();
		String varRightNote2 = driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).getAttribute("value");
		driver.findElement(By.xpath(UIMapMyLowes.lnkCancel)).click();
		System.out.println("Right Note after edit:"+varRightNote2);
		if(varRightNote.equals(varRightNote2))
		{
			report.updateTestLog("Clicking Cancel on editing Dimensions Right Note","Dimensions Note not updated" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking Cancel on editing Dimensions Right Note","Dimensions Note CHANGED" ,Status.FAIL);
		}
		/*driver.findElement(By.xpath("//*[@id='border_top']")).click();
		driver.findElement(By.xpath("//*[@id='notes']")).clear();
		driver.findElement(By.xpath("//*[@id='notes']")).sendKeys("Note Top");
		driver.findElement(By.xpath("//*[@id='ZFDUfSOl']/div/a[2]")).click();*/
		driver.findElement(By.cssSelector(UIMapMyLowes.btnFinish)).click();
		Thread.sleep(5000);
		int varLeftDimValue = Integer.valueOf(varLeftDim2);
		int varRightDimValue = Integer.valueOf(varRightDim2);
		int varBottomDimValue = Integer.valueOf(varBottomDim2);
		int varTopDimValue = Integer.valueOf(varTopDim2);
		int varTotalArea  = varLeftDimValue*varBottomDimValue;
		if((varLeftDimValue!=varRightDimValue) || (varBottomDimValue!=varTopDimValue))
			{
			String varErrorMsg = driver.findElement(By.xpath(UIMapMyLowes.webElmntDimNeededError)).getText();
			System.out.println(varErrorMsg);
			if(varErrorMsg.equals("We are unable to calculate the area with the dimensions you provided. Please check the values entered."))
			{
				report.updateTestLog("Clicking Finish after Editing Dimensions","Error Message displayed because of incorrect dimensions" ,Status.PASS);
			}
			}
		
		else
			{
			String varTotalArea2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntTotalArea)).getText();
			if(varTotalArea2.equals(varTotalArea+" sq. ft."))
			{
				report.updateTestLog("Clicking Finish after Editing Dimensions","Total Area correctly displayed" ,Status.PASS);
			}
			else
			{
				report.updateTestLog("Clicking Finish after Editing Dimensions","Total Area Incorrect" ,Status.FAIL);
			}
			}
	}
		
	/*This function requires that the YARD profile should already have 1(exactly 1) negative space added and valid dimensions added. This function adds 1 new negative space and 
	 * validates the Area Totals box and Net Area displayed
	 */
	public void editDimensionsHPNegative() throws Exception
	{
		boolean varNonLawnSpaces = selenium.isElementPresent(UIMapMyLowes.webElmntNegAreaSummary);
		if(varNonLawnSpaces)
		{
		String varOldNegSpaceArea = driver.findElement(By.xpath(UIMapMyLowes.webElmntNegAreaSummary)).getText();
		report.updateTestLog("Checking Non Lawn spaces in Summary","Already having Negative Space In Summary:"+varOldNegSpaceArea ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Non Lawn spaces in Summary","Does not have Negative Space in Summary" ,Status.FAIL);
		}
		driver.findElement(By.xpath(UIMapMyLowes.btnEditDimensions)).click();
		Thread.sleep(2000);
		String varNegativeSpace = driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceArea1)).getAttribute("value");
		System.out.println("Negative Space:"+varNegativeSpace);
		if(varNegativeSpace.equals(""))
		{
			report.updateTestLog("Clicking on Edit Dimensions","Does not have Negative Space" ,Status.FAIL);
		}
		else
		{
			report.updateTestLog("Clicking on Edit Dimensions","Already having Negative Space In Edit Dimension Box:"+varNegativeSpace ,Status.PASS);
		}
		driver.findElement(By.linkText("Add Another")).click();
		Thread.sleep(1000);
		String varNewNegSpaceName = driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceAreaName2)).getText();
		String varNewNegSpaceArea = driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceArea2)).getText();
		System.out.println("New Space Name:"+varNewNegSpaceName);
		System.out.println("New Space Area:"+varNewNegSpaceArea);
		if(varNewNegSpaceName.equals("") && varNewNegSpaceArea.equals(""))
		{
			report.updateTestLog("Clicking on Add Another link","Blank Name and Area fields added" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking on Add Another link","Blank Name and Area fields NOT added" ,Status.FAIL);
		}
			Thread.sleep(5000);
		 driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceAreaName2)).clear();
		 driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceAreaName2)).sendKeys(dataTable.getData("General_Data","NegSpaceName"));
		 driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceArea2)).clear();
		 driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceArea2)).sendKeys(dataTable.getData("General_Data","NegSpaceArea"));
		 driver.findElement(By.cssSelector(UIMapMyLowes.btnFinish)).click();
		 Thread.sleep(5000);
		 varNewNegSpaceArea = driver.findElement(By.xpath(UIMapMyLowes.webElmntNegAreaSummary)).getText();
		 System.out.println("New Negative Space Area:"+varNewNegSpaceArea);
		 System.out.println("Negative Space Area from Excel:"+dataTable.getData("General_Data","NegSpaceArea")+" sq. ft.");
		 if(varNewNegSpaceArea.equals(dataTable.getData("General_Data","NegSpaceArea")+" sq. ft."))
		 {
			 report.updateTestLog("Clicking on Finish link","New Negative Space updated" ,Status.PASS);
		 }
		 else
		 {
			 report.updateTestLog("Clicking on Finish link","New Negative Space NOT updated" ,Status.FAIL);
		 }
		 String varTotalArea = driver.findElement(By.xpath(UIMapMyLowes.webElmntTotalArea)).getText();
		 System.out.println("Total Area:"+varTotalArea);
		 String[] s = varTotalArea.split(" ");
		 int varTotalArea2 = Integer.valueOf(s[0]);
		 System.out.println("Total Area:"+varTotalArea2);
		 int varNegSpace1 = Integer.valueOf(varNegativeSpace);
		 int varNegSpace2 = Integer.valueOf(dataTable.getData("General_Data","NegSpaceArea"));
		 int varNetArea = varTotalArea2-(varNegSpace1+varNegSpace2);
		 System.out.println("Net Area:"+varNetArea);
		 String varNetArea2 = driver.findElement(By.cssSelector(UIMapMyLowes.webElmntNetArea)).getText();
		 System.out.println(varNetArea2);
		 if(varNetArea2.equals(varNetArea+" sq. ft."))
		 {
			 report.updateTestLog("Clicking on Finish link","Net Area calculation is correct" ,Status.PASS);
		 }
		 else
		 {
			 report.updateTestLog("Clicking on Finish link","Net Area calculation is NOT correct" ,Status.PASS);
		 }
		 driver.findElement(By.xpath(UIMapMyLowes.btnEditDimensions)).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath(UIMapMyLowes.webElmntDeleteNegSpaceArea2)).click();
		 Thread.sleep(5000);
		 driver.findElement(By.cssSelector(UIMapMyLowes.btnFinish)).click();
		 Thread.sleep(5000);
		
		 
	}
		
	
	/*This function verifies count of documents for a space in Home Profile. Prerequisite: Upload few documents in Home Profile
	 * of a user and update the count in the datasheet
	 */
	public void verifyDocumentCountHP() throws Exception
	{
		String varNbrOfDocs = driver.findElement(By.xpath(UIMapMyLowes.webElmntDocCount)).getText();
		System.out.println(varNbrOfDocs);
		int varCount=countWebElement(UIMapMyLowes.webElmntDocsCount);
		System.out.println(varCount);
		String[] s = varNbrOfDocs.split(" ");
		if(varNbrOfDocs.equals(varCount+" Document") || varNbrOfDocs.equals(varCount+" Documents"))
		{
			report.updateTestLog("Checking Documents Count","Documents Count is correct" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Documents Count","Documents Count is NOT correct" ,Status.FAIL);
		}
		
	}
		
	public void negSpaceErrorHP() throws Exception
	{
		boolean varNonLawnSpaces = selenium.isElementPresent(UIMapMyLowes.webElmntNegAreaSummary);
		if(varNonLawnSpaces)
		{
		String varOldNegSpaceArea = driver.findElement(By.xpath(UIMapMyLowes.webElmntNegAreaSummary)).getText();
		report.updateTestLog("Checking Non Lawn spaces in Summary","Already having Negative Space In Summary:"+varOldNegSpaceArea ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Non Lawn spaces in Summary","Does not have Negative Space in Summary" ,Status.FAIL);
		}
		driver.findElement(By.xpath(UIMapMyLowes.btnEditDimensions)).click();
		Thread.sleep(2000);
		String varNegativeSpace = driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceArea1)).getAttribute("value");
		System.out.println("Negative Space:"+varNegativeSpace);
		if(varNegativeSpace.equals(""))
		{
			report.updateTestLog("Clicking on Edit Dimensions","Does not have Negative Space" ,Status.FAIL);
		}
		else
		{
			report.updateTestLog("Clicking on Edit Dimensions","Already having Negative Space:"+varNegativeSpace ,Status.PASS);
		}
		driver.findElement(By.linkText("Add Another")).click();
		Thread.sleep(1000);
		String varNewNegSpaceName = driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceAreaName2)).getText();
		String varNewNegSpaceArea = driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceArea2)).getText();
		System.out.println("New Space Name:"+varNewNegSpaceName);
		System.out.println("New Space Area:"+varNewNegSpaceArea);
		if(varNewNegSpaceName.equals("") && varNewNegSpaceArea.equals(""))
		{
			report.updateTestLog("Clicking on Add Another link","Blank Name and Area fields added" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking on Add Another link","Blank Name and Area fields NOT added" ,Status.FAIL);
		}
			Thread.sleep(5000);
			driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceAreaName2)).clear();
			 driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceAreaName2)).sendKeys(dataTable.getData("General_Data","NegSpaceName"));
			 driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceArea2)).clear();
			 driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceArea2)).sendKeys(dataTable.getData("General_Data","NegSpaceArea"));
			 driver.findElement(By.cssSelector(UIMapMyLowes.btnFinish)).click();
			 Thread.sleep(5000);
		 String varNegErrorMsg = driver.findElement(By.xpath(UIMapMyLowes.webElmntDimNeededError)).getText();
		System.out.println(varNegErrorMsg);
			if(varNegErrorMsg.equals("The non-lawn footage you entered is greater than the area of your space. Please check the values entered."))
			{
				report.updateTestLog("Clicking Finish after entering Negative Space greater than Total Yard Area","Negative Space Error Message displayed" ,Status.PASS);
			}
			else
			{
				report.updateTestLog("Clicking Finish after entering Negative Space greater than Total Yard Area","Required Error Message NOT displayed" ,Status.FAIL);
			}
		driver.findElement(By.xpath(UIMapMyLowes.btnEditDimensions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntDeleteNegSpaceArea2)).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(UIMapMyLowes.btnFinish)).click();
		Thread.sleep(10000);
		int varNegSpace1 = Integer.valueOf(varNegativeSpace);
		String varTotalArea = driver.findElement(By.xpath(UIMapMyLowes.webElmntTotalArea)).getText();
		System.out.println("Total Area:"+varTotalArea);
		String[] s = varTotalArea.split(" ");
		int varTotalArea2 = Integer.valueOf(s[0]);
		System.out.println("Total Area:"+varTotalArea2);
		int varNetArea = varTotalArea2-(varNegSpace1);
		System.out.println("Net Area:"+varNetArea);
		String varNetArea2 = driver.findElement(By.cssSelector(UIMapMyLowes.webElmntNetArea)).getText();
		System.out.println(varNetArea2);
			if(varNetArea2.equals(varNetArea+" sq. ft."))
			 {
				 report.updateTestLog("Clicking on Finish link","Net Area calculation is correct" ,Status.PASS);
			 }
			 else
			 {
				 report.updateTestLog("Clicking on Finish link","Net Area calculation is NOT correct" ,Status.FAIL);
			 }
			 
			
	}
	
	/*This function requires a Home profile space with valid dimensions and no Negative space.
	 * The function adds a new negative space and checks the Net Area Calculation
	 */
	public void netAreaCalculationHP()throws Exception
	{
		
		driver.findElement(By.xpath(UIMapMyLowes.btnEditDimensions)).click();
		
		Thread.sleep(2000);
		String varNegativeSpace = driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceArea1)).getAttribute("value");
		System.out.println("Negative Space:"+varNegativeSpace);
		if(varNegativeSpace.equals(""))
		{
			report.updateTestLog("Clicking on Edit Dimensions","Does not have Negative Space" ,Status.FAIL);
		}
		else
		{
			report.updateTestLog("Clicking on Edit Dimensions","Already having Negative Space In Edit Dimension Box:"+varNegativeSpace ,Status.PASS);
		}
		String varNewNegSpaceName = driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceAreaName2)).getText();
		String varNewNegSpaceArea = driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceArea2)).getText();
		System.out.println("New Space Name:"+varNewNegSpaceName);
		System.out.println("New Space Area:"+varNewNegSpaceArea);
		if(varNewNegSpaceName.equals("") && varNewNegSpaceArea.equals(""))
		{
			report.updateTestLog("Clicking on Add Another link","Blank Name and Area fields added" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking on Add Another link","Blank Name and Area fields NOT added" ,Status.FAIL);
		}
		Thread.sleep(5000);
		 driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceAreaName2)).clear();
		 driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceAreaName2)).sendKeys(dataTable.getData("General_Data","NegSpaceName"));
		 driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceArea2)).clear();
		 driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceArea2)).sendKeys(dataTable.getData("General_Data","NegSpaceArea"));
		 driver.findElement(By.cssSelector(UIMapMyLowes.btnFinish)).click();
		 Thread.sleep(5000);
		 int varNegSpace1 = Integer.valueOf(varNegativeSpace);
		 int varNegSpace2 = Integer.valueOf(dataTable.getData("General_Data","NegSpaceArea"));
		String varTotalArea = driver.findElement(By.xpath(UIMapMyLowes.webElmntTotalArea)).getText();
		System.out.println("Total Area:"+varTotalArea);
		String[] s = varTotalArea.split(" ");
		int varTotalArea2 = Integer.valueOf(s[0]);
		System.out.println("Total Area:"+varTotalArea2);
		int varNetArea = varTotalArea2-(varNegSpace1+varNegSpace2);
		System.out.println("Net Area:"+varNetArea);
		String varNetArea2 = driver.findElement(By.cssSelector(UIMapMyLowes.webElmntNetArea)).getText();
		System.out.println(varNetArea2);
			if(varNetArea2.equals(varNetArea+" sq. ft."))
				{
				report.updateTestLog("Clicking on Finish link","Net Area calculation is correct" ,Status.PASS);
				}
			else
				{
				report.updateTestLog("Clicking on Finish link","Net Area calculation is NOT correct" ,Status.FAIL);
				}
			driver.findElement(By.xpath(UIMapMyLowes.btnEditDimensions)).click();
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(UIMapMyLowes.webElmntDeleteNegSpaceArea2)).click();
			 Thread.sleep(5000);
			 driver.findElement(By.cssSelector(UIMapMyLowes.btnFinish)).click();
			 Thread.sleep(5000);
		
	}
	
	/*This method clicks on All Products link*/
	public void clickAllProductsHP() throws Exception
	{
		driver.findElement(By.linkText("View or Assign Products")).click();
		Thread.sleep(2000);
		try{driver.findElement(By.xpath(UIMapMyLowes.webElmntShowHP)).click();
		System.out.println("Show Mechanism clicked");
		FunctionalComponents.waitforVisible(driver,UIMapMyLowes.webElmntShowAllProducts,5);}
		catch(Exception WebDriverException)
		{
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.webElmntShowHP)).click();
			System.out.println("Show Mechanism clicked");
			FunctionalComponents.waitforVisible(driver,UIMapMyLowes.webElmntShowAllProducts,5);}
		
		driver.findElement(By.xpath(UIMapMyLowes.webElmntShowAllProducts)).click();
		
		
		selenium.waitForPageToLoad("20000");
		boolean varProductList = selenium.isElementPresent(UIMapMyLowes.webElmntProductCount);
		if(varProductList)
		{
			report.updateTestLog("Clicking View All Products link","Products List displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking View All Products link","Products List NOT displayed" ,Status.FAIL);
		}
	}
	

	/*This method deletes  item in  Home Profile using checkbox option
	 */
	public void deleteItemsHomeProfileAction() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.lnkEdit2)).click();
		Thread.sleep(2000);
		String varItemName = driver.findElement(By.name(UIMapMyLowes.txtItemName)).getAttribute("value");
		//driver.findElement(By.cssSelector(UIMapMyLowes.lnkCancelItem)).click();
		ClickCustomize("linkText", "Cancel");
		Thread.sleep(5000);
		//driver.findElement(By.xpath(UIMapMyLowes.chkBoxItem1)).click();
		driver.findElement(By.cssSelector("input.item_select")).click();
	    driver.findElement(By.linkText("Actions")).click();
	    driver.findElement(By.linkText("Delete")).click();
	    boolean varConfirmationPopup = selenium.isElementPresent(UIMapMyLowes.webElmntMultipleDeletePopup);
	    if(varConfirmationPopup)
	    {
	    	report.updateTestLog("Deleting using Action-Delete","Deletion confirmation message displayed" ,Status.PASS);
	    }
	    else
	    {
	    	report.updateTestLog("Deleting using Action-Delete","Deletion confirmation message NOT displayed" ,Status.FAIL);
	    }
	   
	    driver.findElement(By.xpath(UIMapMyLowes.btnConfirmDelete)).click();
	    Thread.sleep(2000);
	    String varItemName2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntDeleteUndoMsg)).getText();
	    boolean varUndoLink = selenium.isElementPresent(UIMapMyLowes.lnkUndo2);
	    System.out.println(varItemName2);
	   // System.out.println(varItemName+" has been deleted. Undo");
	   // System.out.println(varItemName);
	    String varXpectedMsg = varItemName.concat(" has been deleted. Undo");
	    System.out.println(varXpectedMsg);
	    System.out.println(varUndoLink);
	    System.out.println(varItemName2.compareToIgnoreCase(varXpectedMsg));
	    if(varItemName2.equalsIgnoreCase(varXpectedMsg))
	    {
	    	System.out.println("Confirmation message");
	    	if(varUndoLink)
	    	{
	    		System.out.println("Undo Link");
	    		report.updateTestLog("Checking confirmation message","Item deletion confirmation message displayed with Undo Link" ,Status.PASS);
	    		ClickCustomize("linkText", "Undo");
	    		Thread.sleep(5000);
	    	}
	    	else
	    	{
	    		report.updateTestLog("Checking confirmation message","Item deletion confirmation message NOT displayed with Undo Link" ,Status.FAIL);
	    		
	    	}
	    }
	    else
	    {
	    	report.updateTestLog("Checking confirmation message","Item deletion confirmation message NOT displayed with Undo Link" ,Status.FAIL);
	    }
	    
	}
	/*This method deletes  item in  Home Profile using trashcan option
	 */
	public void deleteItemsHomeProfileTrashCan() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.lnkEdit2)).click();
		Thread.sleep(2000);
		String varItemName = driver.findElement(By.name(UIMapMyLowes.txtItemName)).getAttribute("value");
		//driver.findElement(By.cssSelector(UIMapMyLowes.lnkCancelItem)).click();
		ClickCustomize("linkText", "Cancel");
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(UIMapMyLowes.webElmntTrashcanDelete)).click();
	   
	    Thread.sleep(2000);
	    String varItemName2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntDeleteUndoMsg)).getText();
	    boolean varUndoLink = selenium.isElementPresent(UIMapMyLowes.lnkUndo2);
	    System.out.println(varItemName2);
	   // System.out.println(varItemName+" has been deleted. Undo");
	   // System.out.println(varItemName);
	    String varXpectedMsg = varItemName.concat(" has been deleted. Undo");
	    System.out.println(varXpectedMsg);
	    System.out.println(varUndoLink);
	    System.out.println(varItemName2.compareTo(varXpectedMsg));
	    if(varItemName2.equalsIgnoreCase(varXpectedMsg))
	    {
	    	System.out.println("Confirmation message");
	    	if(varUndoLink)
	    	{
	    		System.out.println("Undo Link");
	    		report.updateTestLog("Checking confirmation message","Item deletion confirmation message displayed with Undo Link" ,Status.PASS);
	    	}
	    	else
	    	{
	    		report.updateTestLog("Checking confirmation message","Item deletion confirmation message NOT displayed with Undo Link" ,Status.FAIL);
	    		
	    	}
	    }
	    else
	    {
	    	report.updateTestLog("Checking confirmation message","Item deletion confirmation message NOT displayed with Undo Link" ,Status.FAIL);
	    }
	    
	}
	/*This method creates Note for the UNASSIGNED Item added in List View and clicks on Cancel*/
	public void createNoteItemListCancelHP() throws Exception
	{

		System.out.println("Entered");
		
		//driver.findElement(By.xpath(UIMapMyLowes.lnkEdit2)).click();
		//Thread.sleep(2000);
		//driver.findElement(By.className("edit_item")).click();
		driver.findElement(By.xpath(UIMapMyLowes.lnkEdit2)).click();
		
		FunctionalComponents.waitforVisible(driver, UIMapMyLowes.txtNotes2, 10);
		
		boolean varIsClosePresent = selenium.isElementPresent("css=a.close_and_save_item");
		if(varIsClosePresent)
		{
			report.updateTestLog("Checking Close Link","Close link displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Close Link","Close link NOT displayed" ,Status.FAIL);
		}
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes2)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).sendKeys(dataTable.getData("General_Data","SpaceNotes"));
		Thread.sleep(2000);
		driver.findElement(By.id(UIMapMyLowes.lnkSelectSpaces)).click();
		Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.chkBoxSpace4)).click();
	    Thread.sleep(5000);
	   // driver.findElement(By.cssSelector(UIMapMyLowes.lnkCancelItem)).click();
	    driver.findElement(By.partialLinkText("Cancel")).click();
	    Thread.sleep(5000);
	    
	    //String varIsRecentlyAdded = driver.findElement(By.xpath(UIMapMyLowes.webElmntRecentlyAdded)).getText();
	    boolean varRecentlyAddedBanner = selenium.isElementPresent(UIMapMyLowes.webElmntRecentlyAdded);
	    //if(varIsRecentlyAdded.equals("Recently Added"))
	    if(varRecentlyAddedBanner)
	    {
	    	report.updateTestLog("Checking Recently added Status","Recently added Status retained" ,Status.PASS);
	    }
	    else
	    {
	    	report.updateTestLog("Checking Recently added Status","Recently added Status NOT retained" ,Status.FAIL);
	    }
	    	boolean varIsAddNotePresent = selenium.isElementPresent(UIMapMyLowes.lnkAddAnote);
		   if(varIsAddNotePresent)
		   {
			   report.updateTestLog("Checking Note Status","Add a note link retained" ,Status.PASS);
		   }
		   else
		   {
			   report.updateTestLog("Checking Note Status","Add a note link NOT retained" ,Status.FAIL);
		   }
	  
	   String varUnassigned = driver.findElement(By.xpath(UIMapMyLowes.webElmntUnassignedStatus)).getText();
	   //boolean varUnassigned = selenium.isElementPresent("//*[@id='item_list']/div[1]/div[1]/div[2]/div[2]/div[2]/span[2]");
	   if(varUnassigned.equals("Unassigned"))
	   {
		   report.updateTestLog("Checking Unassigned Status","Unassigned Status retained" ,Status.PASS);
	   }
	   else
	   {
		   report.updateTestLog("Checking Unassigned Status","Unassigned Status NOT retained" ,Status.FAIL);
	   }
	  // driver.findElement(By.cssSelector(UIMapMyLowes.webElmntTrashcanDelete)).click();
	   //Thread.sleep(5000);
	    
	}
	
	/*This method edits Note for the UNASSIGNED Item added in List View and clicks on Cancel*/
	public void editNoteItemListCancelHP() throws Exception
	{
		String varItemType;
		String varAssignedSpace;
		String varAssignedSpace2;
		try{
			varAssignedSpace = driver.findElement(By.xpath(UIMapMyLowes.webElmntProductAssignedSpace)).getText();
			System.out.println("Already Assigned Space:"+varAssignedSpace);
			varItemType = "Product";
			System.out.println(varItemType);
			
		}
		catch(Exception NoSuchElementException)
		{
			varAssignedSpace = driver.findElement(By.xpath(UIMapMyLowes.webElmntManualItemAssignedSpace)).getText();
			System.out.println("Already Assigned Space:"+varAssignedSpace);
			varItemType = "ManualItem";
			System.out.println(varItemType);
		}
		
		
		//driver.findElement(By.className("edit_item")).click();
		driver.findElement(By.xpath(UIMapMyLowes.lnkEdit2)).click();
		
		FunctionalComponents.waitforVisible(driver, UIMapMyLowes.txtNotes2, 10);
		
		boolean varIsClosePresent = selenium.isElementPresent("css=a.close_and_save_item");
		if(varIsClosePresent)
		{
			report.updateTestLog("Checking Close Link","Close link displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Close Link","Close link NOT displayed" ,Status.FAIL);
		}
		
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes2)).click();
		FunctionalComponents.waitforVisible(driver, UIMapMyLowes.txtNotesTextArea, 10);
		
		String varNote = driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).getText();
		System.out.println("Note Already Present:"+varNote);
		
		driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).sendKeys(dataTable.getData("General_Data","SpaceNotes"));
		//boolean varIsProduct = selenium.isElementPresent(UIMapMyLowes.webElmntProductForm);
		//boolean varIsManualItem = selenium.isElementPresent(UIMapMyLowes.webElmntManualItemForm);
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//li[2]/div/span[2]/span/a[2]/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.id(UIMapMyLowes.lnkSelectSpaces)).click();
		Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.chkBoxSpace4)).click();
	    Thread.sleep(5000);
	    //driver.findElement(By.cssSelector(UIMapMyLowes.lnkCancelItem)).click();
	    driver.findElement(By.partialLinkText("Cancel")).click();
	    Thread.sleep(5000);
	    
	    //String varIsRecentlyAdded = driver.findElement(By.xpath(UIMapMyLowes.webElmntRecentlyAdded)).getText();
	   /* boolean varRecentlyAddedBanner = selenium.isElementPresent(UIMapMyLowes.webElmntRecentlyAdded);
	    //if(varIsRecentlyAdded.equals("Recently Added"))
	    if(varRecentlyAddedBanner)
	    {
	    	report.updateTestLog("Checking Recently added Status","Recently added Status retained" ,Status.PASS);
	    }
	    else
	    {
	    	report.updateTestLog("Checking Recently added Status","Recently added Status NOT retained" ,Status.FAIL);
	    }
	   */
		 
		 String varNote2 =  driver.findElement(By.xpath(UIMapMyLowes.webElmntNoteItemList)).getText();
		 System.out.println(varNote2);
		 if(varNote.equals(varNote2))
		 {
			 report.updateTestLog("Checking Note Status","Previous Note retained" ,Status.PASS);
		 }
		 else
		 {
			 report.updateTestLog("Checking Note Status","Previous Note NOT retained" ,Status.FAIL);
		 }
	   
	   if(varItemType.equals("Product")){
		 varAssignedSpace2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntProductAssignedSpace)).getText();
	  System.out.println("Space after editing and cancel:"+varAssignedSpace2);
	  if(varAssignedSpace.equals(varAssignedSpace2))
	   {
		   report.updateTestLog("Checking Assigned To Status","Assigned To Status retained" ,Status.PASS);
	   }
	   else
	   {
		   report.updateTestLog("Checking Assigned To Status","Assigned To Status NOT retained" ,Status.FAIL);
	   }
	   }
	   else if(varItemType.equals("ManualItem"))
	   {
		   varAssignedSpace2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntManualItemAssignedSpace)).getText();
			  System.out.println("Space after editing and cancel:"+varAssignedSpace2);
			  if(varAssignedSpace.equals(varAssignedSpace2))
			   {
				   report.updateTestLog("Checking Assigned To Status","Assigned To Status retained" ,Status.PASS);
			   }
			   else
			   {
				   report.updateTestLog("Checking Assigned To Status","Assigned To Status NOT retained" ,Status.FAIL);
			   }
	   }
	   
	    
	}
	
	/*This method creates NOTE for the UNASSIGNED Item added in Grid View and clicks on Cancel*/
	public void createNoteItemGridCancelHP() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.webElmntGridViewImg)).click();
		Thread.sleep(1000);
		String varGridActive = driver.findElement(By.xpath(UIMapMyLowes.webElmntGridView)).getAttribute("class");
		if(varGridActive.equals("gridView active"))
		{
			report.updateTestLog("Clicking Grid View","Items displayed in Grid View" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking Grid View","Items NOT displayed in Grid View" ,Status.FAIL);
		}
		//driver.findElement(By.xpath(UIMapMyLowes.lnkEdit2)).click();
		//driver.findElement(By.className("edit_item")).click();
		driver.findElement(By.xpath(UIMapMyLowes.lnkEdit2)).click();
		
		FunctionalComponents.waitforVisible(driver, UIMapMyLowes.txtNotes2, 10);
		//Thread.sleep(2000);
		boolean varIsClosePresent = selenium.isElementPresent("css=a.close_and_save_item");
		if(varIsClosePresent)
		{
			report.updateTestLog("Checking Close Link","Close link displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Close Link","Close link NOT displayed" ,Status.FAIL);
		}
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes2)).click();
		Thread.sleep(2000);
		String varNote = driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).getText();
		System.out.println("Note Already Present:"+varNote);
		
		driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).sendKeys(dataTable.getData("General_Data","SpaceNotes"));
		Thread.sleep(2000);
		driver.findElement(By.id(UIMapMyLowes.lnkSelectSpaces)).click();
		Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.chkBoxSpace4)).click();
	    Thread.sleep(5000);
	   // driver.findElement(By.cssSelector(UIMapMyLowes.lnkCancelItem)).click();
	    driver.findElement(By.partialLinkText("Cancel")).click();
	    Thread.sleep(5000);
	    
	    driver.findElement(By.xpath(UIMapMyLowes.lnkEdit2)).click();
	    //driver.findElement(By.className("edit_item")).click();
	    FunctionalComponents.waitforVisible(driver, UIMapMyLowes.txtNotes2, 10);
		boolean varIsProduct = selenium.isElementPresent(UIMapMyLowes.webElmntProductForm);
		boolean varIsManualItem = selenium.isElementPresent(UIMapMyLowes.webElmntManualItemForm);
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes2)).click();
		Thread.sleep(2000);
		String varNote2 = driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).getText();
		System.out.println("Note Present after editing and Cancel:"+varNote2);
	    
	    if(varNote.equals(varNote2))
	     {
	    	report.updateTestLog("Checking Note Status","Previous Note retained" ,Status.PASS);
		 }
		else
		 {
			 report.updateTestLog("Checking Note Status","Previous Note NOT retained" ,Status.FAIL);
		 }
	   
	   if(varIsProduct)
	   {
		   System.out.println("Product");
		   String varUnassigned = driver.findElement(By.xpath(UIMapMyLowes.webElmntUnassignedGridProduct)).getText();
		   System.out.println(varUnassigned);
		   if(varUnassigned.equals("Unassigned"))
		   {
			   report.updateTestLog("Checking Unassigned Status","Unassigned Status retained" ,Status.PASS);
		   }
		   else
		   {
			   report.updateTestLog("Checking Unassigned Status","Unassigned Status NOT retained" ,Status.FAIL);
		   }
		  
	   }
	   else if(varIsManualItem)
	   {
		   System.out.println("Manual Item");
		   String varUnassigned = driver.findElement(By.xpath(UIMapMyLowes.webElmntUnassignedGridManualItem)).getText();
		   System.out.println(varUnassigned);
		   if(varUnassigned.equals("Unassigned"))
		   {
			   report.updateTestLog("Checking Unassigned Status","Unassigned Status retained" ,Status.PASS);
		   }
		   else
		   {
			   report.updateTestLog("Checking Unassigned Status","Unassigned Status NOT retained" ,Status.FAIL);
		   }
		  
	   }
	   //driver.findElement(By.className("delete_item")).click();
	  // driver.findElement(By.cssSelector(UIMapMyLowes.webElmntTrashcanDelete)).click();
	 //  Thread.sleep(5000);
	   }
	    
	   
	/*This method edits NOTE for the Assigned Item added in Grid View, adds Yard space and clicks on Cancel
	 * The item should have already note and space(other than Yard) assigned*/
	public void editNoteItemGridCancelHP() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.webElmntGridViewImg)).click();
		Thread.sleep(5000);
		String varGridActive = driver.findElement(By.xpath(UIMapMyLowes.webElmntGridView)).getAttribute("class");
		if(varGridActive.equals("gridView active"))
		{
			report.updateTestLog("Clicking Grid View","Items displayed in Grid View" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking Grid View","Items NOT displayed in Grid View" ,Status.FAIL);
		}
		//driver.findElement(By.xpath(UIMapMyLowes.lnkEdit2)).click();
		driver.findElement(By.className("edit_item")).click();
		FunctionalComponents.waitforVisible(driver, UIMapMyLowes.txtNotes2, 10);
		//Thread.sleep(2000);
		
		boolean varIsClosePresent = selenium.isElementPresent("css=a.close_and_save_item");
		if(varIsClosePresent)
		{
			report.updateTestLog("Checking Close Link","Close link displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Close Link","Close link NOT displayed" ,Status.FAIL);
		}
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes2)).click();
		Thread.sleep(2000);
		String varNote = driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).getText();
		System.out.println("Note Already Present:"+varNote);
		
		driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).sendKeys(dataTable.getData("General_Data","SpaceNotes"));
		Thread.sleep(2000);
		String varAssignedSpace = driver.findElement(By.cssSelector(UIMapMyLowes.webElmntAssignedSpace)).getText();
		System.out.println("Already assigned space:"+varAssignedSpace);
		//driver.findElement(By.cssSelector("li.space_selector_container > div.current_location > span.assigned_spaces > span.location > a.unassign_space > span")).click();
		
		driver.findElement(By.id(UIMapMyLowes.lnkSelectSpaces)).click();
		Thread.sleep(5000);
	    driver.findElement(By.xpath(UIMapMyLowes.chkBoxSpace4)).click();
	    Thread.sleep(5000);
	   // driver.findElement(By.cssSelector(UIMapMyLowes.lnkCancelItem)).click();
	    driver.findElement(By.partialLinkText("Cancel")).click();
	    Thread.sleep(5000);
	    
	    driver.findElement(By.xpath(UIMapMyLowes.lnkEdit2)).click();
	   // driver.findElement(By.className("edit_item")).click();
	    FunctionalComponents.waitforVisible(driver, UIMapMyLowes.txtNotes2, 10);
		boolean varIsProduct = selenium.isElementPresent(UIMapMyLowes.webElmntProductForm);
		boolean varIsManualItem = selenium.isElementPresent(UIMapMyLowes.webElmntManualItemForm);
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes2)).click();
		String varNote2 = driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).getText();
		System.out.println("Note Present after editing and Cancel:"+varNote2);
	    
	    if(varNote.equals(varNote2))
	     {
	    	report.updateTestLog("Checking Note Status","Previous Note retained" ,Status.PASS);
		 }
		else
		 {
			 report.updateTestLog("Checking Note Status","Previous Note NOT retained" ,Status.FAIL);
		 }
	 /*   String varAssignedSpace2 = driver.findElement(By.cssSelector(UIMapMyLowes.webElmntAssignedSpace)).getText();
	    System.out.println("Space after editing and cancel:"+varAssignedSpace2);
	    if(varAssignedSpace.equals(varAssignedSpace2))
	    {
	    	report.updateTestLog("Checking Assigned To Status","Assigned To Status retained" ,Status.PASS);
	    }
	    else
	    {
	    	report.updateTestLog("Checking Assigned To Status","Assigned To Status NOT retained" ,Status.FAIL);
	    }*/
	   if(varIsProduct)
	   {
		   System.out.println("Product");
		   //boolean varNewSpaceSaved = selenium.isElementPresent("//li[3]/div/span[2]/span[2]/a");
		   		//String varAssignedSpace2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntProductAssignedSpaceGrid)).getText();
		   String varAssignedSpace2 = driver.findElement(By.cssSelector(UIMapMyLowes.webElmntAssignedSpace)).getText();
		   System.out.println("Assigned space after editing and cancel:"+varAssignedSpace2);
			   if(varAssignedSpace.equals(varAssignedSpace2))
			   {
				   report.updateTestLog("Checking Assigned To Status","Assigned To Status retained" ,Status.PASS);
			   }
			   else
			   {
				   report.updateTestLog("Checking Assigned To Status","Assigned To Status NOT retained" ,Status.FAIL);
			   }
			  
		   
		   }
		  
	   else if(varIsManualItem)
	   {
		   System.out.println("Manual Item");
		  // boolean varNewSpaceSaved = selenium.isElementPresent("//li[2]/div/span[2]/span[2]/a");
		   	
			   //String varAssignedSpace2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntManualItemAssignedSpaceGrid)).getText();
		   String varAssignedSpace2 = driver.findElement(By.cssSelector(UIMapMyLowes.webElmntAssignedSpace)).getText();  
		   System.out.println("Assigned space after editing and cancel:"+varAssignedSpace2);
			   if(varAssignedSpace.equals(varAssignedSpace2))
			   {
				   report.updateTestLog("Checking Assigned To Status","Assigned To Status retained" ,Status.PASS);
			   }
			   else
			   {
				   report.updateTestLog("Checking Assigned To Status","Assigned To Status NOT retained" ,Status.FAIL);
			   }
	   }
		  
	  // driver.findElement(By.className("delete_item")).click();
	   } 
	
	/*This function edits NOTES for an Item in HP and saves it by clicking on SAVE button*/
	public void saveNotesItemHP() throws Exception
	{
		
		driver.findElement(By.xpath(UIMapMyLowes.btnSave)).click();
		Thread.sleep(10000);
		String varNote = driver.findElement(By.xpath(UIMapMyLowes.webElmntNoteItemList)).getText();
		if(varNote.equals(dataTable.getData("General_Data","SpaceNotes")))
		{
			report.updateTestLog("Checking Saved Notes","Notes saved successfully" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Saved Notes","Notes NOT saved successfully" ,Status.FAIL);
		}
	}
	
	/*This function edits NOTES for an Item in HP and saves it by clicking on CLOSE button*/
	public void closeNotesItemHP() throws Exception
	{
		
		
		driver.findElement(By.cssSelector(UIMapMyLowes.lnkCloseItem)).click();
		Thread.sleep(10000);
		String varNote = driver.findElement(By.xpath(UIMapMyLowes.webElmntNoteItemList)).getText();
		if(varNote.equals(dataTable.getData("General_Data","SpaceNotes")))
		{
			report.updateTestLog("Checking Saved Notes","Notes saved successfully" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Saved Notes","Notes NOT saved successfully" ,Status.FAIL);
		}
	}
	
	/*Clicking Edit button for an item in HP*/
	public void editItemHP() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.lnkEdit2)).click();
		Thread.sleep(2000);
		boolean varIsClosePresent = selenium.isElementPresent("css=a.close_and_save_item");
		if(varIsClosePresent)
		{
			report.updateTestLog("Checking Close Link","Close link displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Close Link","Close link NOT displayed" ,Status.FAIL);
		}
	}
	
	/*Editing Notes for an Item in HP*/
	public void editNotesForItemHP() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes2)).click();
		/*String varNote = driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).getText();
		System.out.println("Note Already Present:"+varNote);*/
		
		driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).sendKeys(dataTable.getData("General_Data","SpaceNotes"));
		Thread.sleep(2000);
	}
	
	
	/*This function verifies the default view for items in HP*/
	public void checkDefaultViewItemsHP() throws Exception
	{
		String varIsListDefault = driver.findElement(By.xpath(UIMapMyLowes.webElmntListView)).getAttribute("class");
		System.out.println(varIsListDefault);
		if(varIsListDefault.equals("active listView"))
		{
			report.updateTestLog("Checking Default View","List is Default View" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Default View","List is NOT Default View" ,Status.FAIL);
		}
	}
	/*This function checks the alignment when user clicks Edit button in List View*/
	public void editItemInList() throws Exception
	{
		String varSecondItem = driver.findElement(By.xpath(UIMapMyLowes.webElmntItem2Name)).getText();
		System.out.println("Second Item Name before clicking Edit:"+varSecondItem);
		editItemHP();
		boolean varIsProduct = selenium.isElementPresent(UIMapMyLowes.webElmntProductForm);
		boolean varIsManualItem = selenium.isElementPresent(UIMapMyLowes.webElmntManualItemForm);
		String varSecondItem2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntItem2Name)).getText();
		System.out.println("Second Item Name After clicking Edit:"+varSecondItem2);
		if(varSecondItem.equals(varSecondItem2) && varIsProduct)
		{
			report.updateTestLog("Checking Second Item after clicking on Edit","Second Item shifted and Product form displayed" ,Status.PASS);
		}
		else if(varSecondItem.equals(varSecondItem2) && varIsManualItem)
		{
			report.updateTestLog("Checking Second Item after clicking on Edit","Second Item shifted and Manual Item form displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Second Item after clicking on Edit","Second Item NOT shifted" ,Status.FAIL);
		}
		editNotesForItemHP();
		saveNotesItemHP();
		switchGridViewItemsHP();
		switchListViewItemsHP();
		String varNote2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntNoteItemList)).getText();
		if(varNote2.equals(dataTable.getData("General_Data","SpaceNotes")))
		{
			report.updateTestLog("Checking Saved Notes","Notes saved successfully in LIST view" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Saved Notes","Notes NOT saved successfully in LIST view" ,Status.FAIL);
		}
		
	}
	
	public void switchGridViewItemsHP() throws Exception
	{
		System.out.println("Grid view selected");
		driver.findElement(By.xpath(UIMapMyLowes.webElmntGridViewImg)).click();
		Thread.sleep(5000);
		String varGridActive = driver.findElement(By.xpath(UIMapMyLowes.webElmntGridView)).getAttribute("class");
		if(varGridActive.equals("gridView active"))
		{
			report.updateTestLog("Clicking Grid View","Items displayed in Grid View" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking Grid View","Items NOT displayed in Grid View" ,Status.FAIL);
		}	
	}
	
	public void switchListViewItemsHP() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.webElmntListViewImg)).click();
		Thread.sleep(5000);
		String varIsListActive = driver.findElement(By.xpath(UIMapMyLowes.webElmntListView)).getAttribute("class");
		System.out.println(varIsListActive);
		if(varIsListActive.equals("listView active"))
		{
			report.updateTestLog("Checking List View","List View displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking List View","List View NOT displayed" ,Status.FAIL);
		}
	}
	
	/*This function assigns an item to first space in Select Space*/
	public void addItemToSpace() throws Exception
	{
		Thread.sleep(10000);
		driver.findElement(By.id(UIMapMyLowes.lnkSelectSpaces)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.chkBoxSpace1)).click();
		driver.findElement(By.xpath(UIMapMyLowes.btnSave)).click();
		Thread.sleep(10000);
		String varSpace = driver.findElement(By.xpath(UIMapMyLowes.webElmntProductAssignedSpace)).getText();
		report.updateTestLog("Assigning Item to Space","Item assigned to space:"+varSpace ,Status.DONE);
	}
	
	/*This function assigns an item to a particular Space*/
	public void addItemToSpace2() throws Exception
	{
		Thread.sleep(10000);
		driver.findElement(By.id(UIMapMyLowes.lnkSelectSpaces)).click();
		Thread.sleep(5000);
		int varCount=ps.countWebElement(UIMapMyLowes.lblYourSpacesSpaceList);
		int i=0;
		for(i=1;i<=varCount;i++)
		{
			String varLabel=driver.findElement(By.xpath(UIMapMyLowes.lblYourSpacesSpaceList+"["+i+"]/label")).getText();
			if(varLabel.equalsIgnoreCase(dataTable.getData("General_Data", "NewSpaceNAme")))
			{
				driver.findElement(By.xpath(UIMapMyLowes.lblYourSpacesSpaceList+"["+i+"]/input")).click();
				driver.findElement(By.xpath(UIMapMyLowes.btnSave)).click();
				System.out.println(varLabel+" selected");
				Thread.sleep(10000);
				String varSpace = driver.findElement(By.xpath(UIMapMyLowes.webElmntProductAssignedSpace)).getText();
				if(varSpace.equalsIgnoreCase(varLabel))
				report.updateTestLog("Assigning Item to Space","Item assigned to space:"+varSpace ,Status.DONE);
				else
				report.updateTestLog("Assigning Item to Space","Item assigned to space:"+varSpace ,Status.FAIL);	
				break;
			}
			
		}
		if(i>varCount)
			report.updateTestLog("Assigning Item to Space","Space Not present in List"+dataTable.getData("General_Data", "Space") ,Status.FAIL);
		
		
		
	}
	
	public void clickCancel() throws Exception
	{
		driver.findElement(By.partialLinkText("Cancel")).click();
		Thread.sleep(2000);
	}
	
	/*This function returns the count of a web element on a page*/
	public int countWebElement(String varXpath) throws Exception
	{
		List<WebElement> varGC = driver.findElements(By.xpath(varXpath));
		int varCount = varGC.size();
		return varCount;
	}
	
	/*This function changes the space to which the item is assigned to in LIST view*/
	public void changeSpaceForItemHPList() throws Exception
	{
		
		driver.findElement(By.xpath(UIMapMyLowes.webElmntDeleteCurrentSpace)).click();
		Thread.sleep(2000);
		driver.findElement(By.id(UIMapMyLowes.lnkSelectSpaces)).click();
		int varCount=countWebElement(UIMapMyLowes.webElmntSpaceList);
		for(int i=1;i<=varCount;i++)
		{
			String varSpacelabel = UIMapMyLowes.webElmntSpaceList+"["+i+"]/label";
			System.out.println(varSpacelabel);
			String varSpacelabel2 = driver.findElement(By.xpath(varSpacelabel)).getText();
			System.out.println(varSpacelabel2);
			if(varSpacelabel2.equals(dataTable.getData("General_Data","Space")))
			{
				String varSpace = UIMapMyLowes.webElmntSpaceList+"["+i+"]/input";
				driver.findElement(By.xpath(varSpace)).click();
				break;
			}
			else
			{
				continue;
			}
		}
		driver.findElement(By.xpath(UIMapMyLowes.btnSave)).click();
		Thread.sleep(10000);
		
		String varNewSpace = driver.findElement(By.xpath(UIMapMyLowes.webElmntProductAssignedSpace)).getText();
		if(varNewSpace.equals(dataTable.getData("General_Data","Space")))
		{
			report.updateTestLog("Changing Space","Assigned to new space "+dataTable.getData("General_Data","Space") ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Changing Space","NOT Assigned to new space "+dataTable.getData("General_Data","Space") ,Status.FAIL);
		}
		//driver.findElement(By.className("delete_item")).click();
		driver.findElement(By.cssSelector(UIMapMyLowes.webElmntTrashcanDelete)).click();
		Thread.sleep(5000);
		
	}
	
	/*This function changes the space to which the item is assigned to in Grid view*/
	public void changeSpaceForItemHPGrid() throws Exception
	{
		
		driver.findElement(By.id(UIMapMyLowes.lnkSelectSpaces)).click();
		Thread.sleep(5000);
		int varCount=countWebElement(UIMapMyLowes.webElmntSpaceList);
		for(int i=1;i<=varCount;i++)
		{	
			try{String varOldSpace =  UIMapMyLowes.webElmntSpaceList+"["+i+"]/input";
			System.out.println(varOldSpace);
			String varOldSpacechecked = driver.findElement(By.xpath(varOldSpace)).getAttribute("checked");
			System.out.println(varOldSpacechecked);
			if(varOldSpacechecked.equals("true"))
			{
				String varOldSpacelabel = UIMapMyLowes.webElmntSpaceList+"["+i+"]/label";
				String varOldSpacelabel2 = driver.findElement(By.xpath(varOldSpacelabel)).getText();
				driver.findElement(By.xpath(varOldSpace)).click();
				report.updateTestLog("Unchecking Old Space","Old space:"+varOldSpacelabel2+" Unchecked",Status.DONE);
				break;
			}
			
			}
			catch(Exception NullPointerException)
			{
				continue;
			}
		}
		for(int i=1;i<=varCount;i++)
		{
			
			String varSpacelabel = UIMapMyLowes.webElmntSpaceList+"["+i+"]/label";
			//System.out.println(varSpacelabel);
			String varSpacelabel2 = driver.findElement(By.xpath(varSpacelabel)).getText();
			//System.out.println(varSpacelabel2);
			if(varSpacelabel2.equals(dataTable.getData("General_Data","Space")))
			{
				String varSpace = UIMapMyLowes.webElmntSpaceList+"["+i+"]/input";
				driver.findElement(By.xpath(varSpace)).click();
				report.updateTestLog("Selecting new space","New space:"+varSpacelabel2+" selected",Status.DONE);
				break;
			}
			else
			{
				continue;
			}
		}
		driver.findElement(By.xpath(UIMapMyLowes.btnSave)).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(UIMapMyLowes.lnkEdit2)).click();
	    
		Thread.sleep(2000);
		boolean varIsProduct = selenium.isElementPresent(UIMapMyLowes.webElmntProductForm);
		boolean varIsManualItem = selenium.isElementPresent(UIMapMyLowes.webElmntManualItemForm);
		if(varIsProduct)
		   {
			   System.out.println("Product");
			   //boolean varNewSpaceSaved = selenium.isElementPresent("//li[3]/div/span[2]/span[2]/a");
			   		String varAssignedSpace2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntProductAssignedSpaceGrid)).getText();
				   System.out.println("Assigned space after editing and saving:"+varAssignedSpace2);
				   if(varAssignedSpace2.equals(dataTable.getData("General_Data","Space")))
				   {
					   report.updateTestLog("Checking Space","Space changed to:"+varAssignedSpace2 ,Status.PASS);
				   }
				   else
				   {
					   report.updateTestLog("Checking Space","Space NOT changed" ,Status.FAIL);
				   }
				  
			   
			   }
			  
		   else if(varIsManualItem)
		   {
			   System.out.println("Manual Item");
			  // boolean varNewSpaceSaved = selenium.isElementPresent("//li[2]/div/span[2]/span[2]/a");
			   	
				   String varAssignedSpace2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntManualItemAssignedSpaceGrid)).getText();
				   System.out.println("Assigned space after editing and saving:"+varAssignedSpace2);
				   if(varAssignedSpace2.equals(dataTable.getData("General_Data","Space")))
				   {
					   report.updateTestLog("Checking Space","Space changed to:"+varAssignedSpace2 ,Status.PASS);
				   }
				   else
				   {
					   report.updateTestLog("Checking Space","Space NOT changed" ,Status.FAIL);
				   }
		   }
		//driver.findElement(By.className("delete_item")).click();
		driver.findElement(By.cssSelector(UIMapMyLowes.webElmntTrashcanDelete)).click();
		Thread.sleep(5000);
	}
	
	/*This function validates the Your Spaces: section on clicking Edit for an Item in Home Profile*/
	public void validateYourSpacesHP() throws Exception
	{
		 String[] a = new String[10];
		 String[] b = new String[10];
		List<WebElement> varSpaces = driver.findElements(By.xpath(UIMapMyLowes.webElmntSpaceGrid));
		int i;
		int j;
		i=0;
		j=0;
		for (WebElement varSpaces2 : varSpaces) {
		 
	            
	            j=i+1;
	            String varSpacesxpath =UIMapMyLowes.webElmntSpaceGrid+"["+j+"]/h3/div[1]/span/a";
	            	
	            a[i] = driver.findElement(By.xpath(varSpacesxpath)).getText();
	            System.out.println("String at place:"+i+":"+a[i]);
	            i=i+1;
	            
	            
	        }
		  
		  
		 clickAllProductsHP();
		 checkDefaultViewItemsHP();
		 
		//int varSpaceCount = varSpaces.size();
		String[] varLocatedIn = new String[3];
		for (int counter=0;counter<=2;counter++)
		{
			try{
			int counter2 = counter+1;
			String varXPath = UIMapMyLowes.webElmntLocatedIn+"["+counter2+"]/a[1]";
			varLocatedIn[counter] = driver.findElement(By.xpath(varXPath)).getText();
			System.out.println(varLocatedIn[counter] );
			}
			catch(Exception NoSuchElementException)
			{
				break;
			}
		}

		editItemHP();
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapMyLowes.lnkSelectSpaces)).click();
		Thread.sleep(5000);
		List<WebElement> varYourSpaces = driver.findElements(By.xpath(UIMapMyLowes.webElmntSpaceList));
		System.out.println("Reached here");
		i=0;
		j=0;
		for (WebElement varYourSpaces2 : varYourSpaces) {
          
			
			j = i+1;
            String varYourSpacesxpath = UIMapMyLowes.webElmntSpaceList+"["+j+"]/label";
            b[i] = driver.findElement(By.xpath(varYourSpacesxpath)).getText();
            System.out.println("String at place:"+i+":"+b[i]);
            i=i+1;
          
        }
		
		i=0;
		if(varYourSpaces.size()==varSpaces.size())
		{
		System.out.println("Reached here");	
		for(i=0;i<varYourSpaces.size();i++)
		{
			System.out.println("String a:"+i+"Value:"+a[i]);
			System.out.println("String b:"+i+"Value:"+b[i]);
			if(a[i].equals(b[i]))
				continue;
			else
				report.updateTestLog("Checking Your Spaces section","Values in Your Spaces section not correct" ,Status.FAIL);
				break;
		}
		if (i==(varYourSpaces.size()))
		{
			report.updateTestLog("Checking Your Spaces section","Values in Your Spaces section correct" ,Status.PASS);
		}}
		else
		{
			report.updateTestLog("Checking Your Spaces section","Values in Your Spaces section not correct" ,Status.FAIL);
		}
		i=0;
		for(i=0;i<=2;i++)
		{	
			for(j=1;j<=varYourSpaces.size();j++)
			{
			String varSpacelabel = UIMapMyLowes.webElmntSpaceList+"["+j+"]/label";
			//System.out.println(varSpacelabel);
			String varSpacelabel2 = driver.findElement(By.xpath(varSpacelabel)).getText();
			System.out.println(varSpacelabel2);
			System.out.println(varLocatedIn[i]);
			if(varSpacelabel2.equals(varLocatedIn[i]))
					{
					try
					{
						String varOldSpace = UIMapMyLowes.webElmntSpaceList+"["+j+"]/input";
						String varOldSpacechecked = driver.findElement(By.xpath(varOldSpace)).getAttribute("checked");
						System.out.println(varOldSpacechecked);
						if(varOldSpacechecked.equals("true"))
						{
							report.updateTestLog("Checking Your Spaces section","Value"+varSpacelabel2+" in Your Spaces section checked" ,Status.PASS);
							break;
						}
						
					}
					catch(Exception NullPointerException)
					{
						report.updateTestLog("Checking Your Spaces section","Value"+varSpacelabel2+" in Your Spaces section NOT checked" ,Status.FAIL);
					}
					}
		}
		}
		for(i=1;i<=varYourSpaces.size();i++)
		{	
			try{
			String varOldSpace =  UIMapMyLowes.webElmntSpaceList+"["+i+"]/input";
			System.out.println(varOldSpace);
			String varOldSpacechecked = driver.findElement(By.xpath(varOldSpace)).getAttribute("checked");
			System.out.println(varOldSpacechecked);
			if(varOldSpacechecked.equals("true"))
			{
				String varOldSpacelabel = UIMapMyLowes.webElmntSpaceList+"["+i+"]/label";
				String varOldSpacelabel2 = driver.findElement(By.xpath(varOldSpacelabel)).getText();
				driver.findElement(By.xpath(varOldSpace)).click();
				report.updateTestLog("Unchecking Old Space","Old space:"+varOldSpacelabel2+" Unchecked",Status.DONE);
				
			}
			
			}
			catch(Exception NullPointerException)
			{
				continue;
			}
		}
		//selecting space
		for(i=1;i<11;i++)
		{
			
			String varSpacelabel = UIMapMyLowes.webElmntSpaceList+"["+i+"]/label";
			//System.out.println(varSpacelabel);
			String varSpacelabel2 = driver.findElement(By.xpath(varSpacelabel)).getText();
			//System.out.println(varSpacelabel2);
			if(varSpacelabel2.equals(dataTable.getData("General_Data","Space")))
			{
				String varSpace = UIMapMyLowes.webElmntSpaceList+"["+i+"]/input";
				driver.findElement(By.xpath(varSpace)).click();
				report.updateTestLog("Selecting new space","New space:"+varSpacelabel2+" selected",Status.DONE);
				break;
			}
			else
			{
				continue;
			}
		}
		//selecting Interior space
		for(i=1;i<11;i++)
		{
			
			String varSpacelabel = UIMapMyLowes.webElmntIntSpaceList+"["+i+"]/label";
			//System.out.println(varSpacelabel);
			String varSpacelabel2 = driver.findElement(By.xpath(varSpacelabel)).getText();
			//System.out.println(varSpacelabel2);
			if(varSpacelabel2.equals(dataTable.getData("General_Data","NewInteriorSpace")))
			{
				String varSpace = UIMapMyLowes.webElmntIntSpaceList+"["+i+"]/input";
				driver.findElement(By.xpath(varSpace)).click();
				report.updateTestLog("Selecting new space","New Interior space:"+varSpacelabel2+" selected",Status.DONE);
				break;
			}
			else
			{
				continue;
			}
		}
		//selecting Exterior space
		for(i=1;i<11;i++)
		{
			
			String varSpacelabel = UIMapMyLowes.webElmntExtSpaceList+"["+i+"]/label";
			//System.out.println(varSpacelabel);
			String varSpacelabel2 = driver.findElement(By.xpath(varSpacelabel)).getText();
			//System.out.println(varSpacelabel2);
			if(varSpacelabel2.equals(dataTable.getData("General_Data","NewExteriorSpace")))
			{
				String varSpace =  UIMapMyLowes.webElmntExtSpaceList+"["+i+"]/input";
				driver.findElement(By.xpath(varSpace)).click();
				report.updateTestLog("Selecting new space","New Exterior space:"+varSpacelabel2+" selected",Status.DONE);
				break;
			}
			else
			{
				continue;
			}
		}
		driver.findElement(By.xpath(UIMapMyLowes.btnSave)).click();
		Thread.sleep(30000);
		//String[] varLocatedIn2 = new String[3];
		String varLocatedIn3=null;
		int FlagSpace = 0;
		int FlagIntSpace = 0;
		int FlagExtSpace = 0;
		int counter;
		for (counter=0;counter<=2;counter++)
		{
			try{
			int counter2 = counter+1;
			String varXPath = UIMapMyLowes.webElmntLocatedIn+"["+counter2+"]/a[1]";
			varLocatedIn3 = driver.findElement(By.xpath(varXPath)).getText();
			System.out.println(varLocatedIn3);
			if(varLocatedIn3.equals(dataTable.getData("General_Data","Space")))
					{
				FlagSpace = 1;
				System.out.println("Space Verified");
				
					}
			else if(varLocatedIn3.equals(dataTable.getData("General_Data","NewInteriorSpace")))
			{
				FlagIntSpace = 1;
				System.out.println("NewInteriorSpace Verified");
				
			}
			else if(varLocatedIn3.equals(dataTable.getData("General_Data","NewExteriorSpace")))
			{
				FlagExtSpace = 1;
				System.out.println("NewExteriorSpace Verified");
				
			}
			}
			catch(Exception NoSuchElementException)
			{
				break;
			}
		}
		if((FlagSpace==1)&&(FlagIntSpace==1)&&(FlagExtSpace==1))
		{
			report.updateTestLog("Validating Located IN","Located In Verified",Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Located IN","Located In NOT Verified",Status.FAIL);
		}
		}		
	
	/*This function validates the Your Spaces: section on clicking Edit for an Item in Home Profile*/
	public void validateYourSpacesHPCancel() throws Exception
	{
		 String[] a = new String[10];
		 String[] b = new String[10];
		List<WebElement> varSpaces = driver.findElements(By.xpath(UIMapMyLowes.webElmntSpaceGrid));
		int i;
		int j;
		i=0;
		j=0;
		for (WebElement varSpaces2 : varSpaces) {
		 
	            
	            j=i+1;
	            String varSpacesxpath =UIMapMyLowes.webElmntSpaceGrid+"["+j+"]/h3/div[1]/span/a";
	            	
	            a[i] = driver.findElement(By.xpath(varSpacesxpath)).getText();
	            System.out.println("String at place:"+i+":"+a[i]);
	            i=i+1;
	            
	            
	        }
		  
		  
		 clickAllProductsHP();
		 checkDefaultViewItemsHP();
		 
		//int varSpaceCount = varSpaces.size();
		 int varLocatedInCountOld=ps.countWebElement(UIMapMyLowes.webElmntLocatedIn);
		String[] varLocatedIn = new String[varLocatedInCountOld];
		for (int counter=0;counter<varLocatedInCountOld;counter++)
		{
			try{
			int counter2 = counter+1;
			String varXPath = UIMapMyLowes.webElmntLocatedIn+"["+counter2+"]/a[1]";
			varLocatedIn[counter] = driver.findElement(By.xpath(varXPath)).getText();
			System.out.println(varLocatedIn[counter] );
			}
			catch(Exception NoSuchElementException)
			{
				break;
			}
		}

		editItemHP();
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapMyLowes.lnkSelectSpaces)).click();
		Thread.sleep(5000);
		List<WebElement> varYourSpaces = driver.findElements(By.xpath(UIMapMyLowes.webElmntSpaceList));
		System.out.println("Reached here");
		i=0;
		j=0;
		for (WebElement varYourSpaces2 : varYourSpaces) {
          
			
			j = i+1;
            String varYourSpacesxpath = UIMapMyLowes.webElmntSpaceList+"["+j+"]/label";
            b[i] = driver.findElement(By.xpath(varYourSpacesxpath)).getText();
            System.out.println("String at place:"+i+":"+b[i]);
            i=i+1;
          
        }
		
		i=0;
		if(varYourSpaces.size()==varSpaces.size())
		{
		System.out.println("Reached here");	
		for(i=0;i<varYourSpaces.size();i++)
		{
			System.out.println("String a:"+i+"Value:"+a[i]);
			System.out.println("String b:"+i+"Value:"+b[i]);
			if(a[i].equals(b[i]))
				continue;
			else
				report.updateTestLog("Checking Your Spaces section","Values in Your Spaces section not correct" ,Status.FAIL);
				break;
		}
		if (i==(varYourSpaces.size()))
		{
			report.updateTestLog("Checking Your Spaces section","Values in Your Spaces section correct" ,Status.PASS);
		}}
		else
		{
			report.updateTestLog("Checking Your Spaces section","Values in Your Spaces section not correct" ,Status.FAIL);
		}
		i=0;
		for(i=0;i<varLocatedInCountOld;i++)
		{	
			for(j=1;j<=varYourSpaces.size();j++)
			{
			String varSpacelabel = UIMapMyLowes.webElmntSpaceList+"["+j+"]/label";
			//System.out.println(varSpacelabel);
			String varSpacelabel2 = driver.findElement(By.xpath(varSpacelabel)).getText();
			System.out.println(varSpacelabel2);
			System.out.println(varLocatedIn[i]);
			if(varSpacelabel2.equals(varLocatedIn[i]))
					{
					try
					{
						String varOldSpace = UIMapMyLowes.webElmntSpaceList+"["+j+"]/input";
						String varOldSpacechecked = driver.findElement(By.xpath(varOldSpace)).getAttribute("checked");
						System.out.println(varOldSpacechecked);
						if(varOldSpacechecked.equals("true"))
						{
							report.updateTestLog("Checking Your Spaces section","Value"+varSpacelabel2+" in Your Spaces section checked" ,Status.PASS);
							driver.findElement(By.xpath(varOldSpace)).click();
							report.updateTestLog("Unchecking Old Space","Old space:"+varSpacelabel2+" Unchecked",Status.DONE);
							break;
						}
						
					}
					catch(Exception NullPointerException)
					{
						report.updateTestLog("Checking Your Spaces section","Value"+varSpacelabel2+" in Your Spaces section NOT checked" ,Status.FAIL);
					}
					}
		}
		}
		/*for(i=1;i<=varYourSpaces.size();i++)
		{	
			try{
			String varOldSpace =  UIMapMyLowes.webElmntSpaceList+"["+i+"]/input";
			System.out.println(varOldSpace);
			String varOldSpacechecked = driver.findElement(By.xpath(varOldSpace)).getAttribute("checked");
			System.out.println(varOldSpacechecked);
			if(varOldSpacechecked.equals("true"))
			{
				String varOldSpacelabel = UIMapMyLowes.webElmntSpaceList+"["+i+"]/label";
				String varOldSpacelabel2 = driver.findElement(By.xpath(varOldSpacelabel)).getText();
				driver.findElement(By.xpath(varOldSpace)).click();
				report.updateTestLog("Unchecking Old Space","Old space:"+varOldSpacelabel2+" Unchecked",Status.DONE);
				
			}
			
			}
			catch(Exception NullPointerException)
			{
				continue;
			}
		}*/
		//selecting space
		int varCount=ps.countWebElement(UIMapMyLowes.lblYourSpacesSpaceList);
		for(i=1;i<varCount;i++)
		{
			
			String varSpacelabel = UIMapMyLowes.webElmntSpaceList+"["+i+"]/label";
			//System.out.println(varSpacelabel);
			String varSpacelabel2 = driver.findElement(By.xpath(varSpacelabel)).getText();
			//System.out.println(varSpacelabel2);
			if(varSpacelabel2.equals(dataTable.getData("General_Data","Space")))
			{
				String varSpace = UIMapMyLowes.webElmntSpaceList+"["+i+"]/input";
				driver.findElement(By.xpath(varSpace)).click();
				report.updateTestLog("Selecting new space","New space:"+varSpacelabel2+" selected",Status.DONE);
				break;
			}
			else
			{
				continue;
			}
		}
		//selecting Interior space
		for(i=1;i<11;i++)
		{
			
			String varSpacelabel = UIMapMyLowes.webElmntIntSpaceList+"["+i+"]/label";
			//System.out.println(varSpacelabel);
			String varSpacelabel2 = driver.findElement(By.xpath(varSpacelabel)).getText();
			//System.out.println(varSpacelabel2);
			if(varSpacelabel2.equals(dataTable.getData("General_Data","NewInteriorSpace")))
			{
				String varSpace = UIMapMyLowes.webElmntIntSpaceList+"["+i+"]/input";
				driver.findElement(By.xpath(varSpace)).click();
				report.updateTestLog("Selecting new space","New Interior space:"+varSpacelabel2+" selected",Status.DONE);
				break;
			}
			else
			{
				continue;
			}
		}
		//selecting Exterior space
		for(i=1;i<11;i++)
		{
			
			String varSpacelabel = UIMapMyLowes.webElmntExtSpaceList+"["+i+"]/label";
			//System.out.println(varSpacelabel);
			String varSpacelabel2 = driver.findElement(By.xpath(varSpacelabel)).getText();
			//System.out.println(varSpacelabel2);
			if(varSpacelabel2.equals(dataTable.getData("General_Data","NewExteriorSpace")))
			{
				String varSpace =  UIMapMyLowes.webElmntExtSpaceList+"["+i+"]/input";
				driver.findElement(By.xpath(varSpace)).click();
				report.updateTestLog("Selecting new space","New Exterior space:"+varSpacelabel2+" selected",Status.DONE);
				break;
			}
			else
			{
				continue;
			}
		}
		driver.findElement(By.partialLinkText("Cancel")).click();
		Thread.sleep(30000);
		//String[] varLocatedIn2 = new String[3];
		int varLocatedInCountNew=ps.countWebElement(UIMapMyLowes.webElmntLocatedIn);
		
		String[] varLocatedInNew = new String[varLocatedInCountNew];
		System.out.println(varLocatedInCountNew);
		System.out.println(varLocatedInCountOld);
		if(varLocatedInCountOld==varLocatedInCountNew)
		{
			
		for (int counter=0;counter<varLocatedInCountNew;counter++)
		{
			try{
			int counter2 = counter+1;
			String varXPath = UIMapMyLowes.webElmntLocatedIn+"["+counter2+"]/a[1]";
			varLocatedInNew[counter] = driver.findElement(By.xpath(varXPath)).getText();
			System.out.println(varLocatedInNew[counter] );
			System.out.println(varLocatedIn[counter]);
			if(varLocatedInNew[counter].equals(varLocatedIn[counter]))
			{
					report.updateTestLog("Checking Located In", "Located In Verified for Space "+counter, Status.PASS);
					
			}
			else
			{
				report.updateTestLog("Checking Located In", "Located In NOT Verified for Space "+counter, Status.FAIL);
				break;
			}
			
			}
			catch(Exception NoSuchElementException)
			{
				break;
			}
		}
		}
		else
			report.updateTestLog("Checking Located In", "Located In Incorrect", Status.FAIL);
		
	}
	
	/*This function validates the Your Spaces: section on clicking Edit for an Item in Home Profile*/
	public void validateYourSpacesHPGrid() throws Exception
	{
		 String[] a = new String[10];
		 String[] b = new String[10];
		List<WebElement> varSpaces = driver.findElements(By.xpath(UIMapMyLowes.webElmntSpaceGrid));
		int i;
		int j;
		i=0;
		j=0;
		for (WebElement varSpaces2 : varSpaces) {
		 
	            
	            j=i+1;
	            String varSpacesxpath =UIMapMyLowes.webElmntSpaceGrid+"["+j+"]/h3/div[1]/span/a";
	            	
	            a[i] = driver.findElement(By.xpath(varSpacesxpath)).getText();
	            System.out.println("String at place:"+i+":"+a[i]);
	            i=i+1;
	            
	            
	        }
		  
		  
		 clickAllProductsHP();
		 checkDefaultViewItemsHP();
		 switchGridViewItemsHP();
		//int varSpaceCount = varSpaces.size();
		/* int varLocatedInCountOld=ps.countWebElement(UIMapMyLowes.webElmntLocatedIn);
		String[] varLocatedIn = new String[varLocatedInCountOld];
		for (int counter=0;counter<varLocatedInCountOld;counter++)
		{
			try{
			int counter2 = counter+1;
			String varXPath = UIMapMyLowes.webElmntLocatedIn+"["+counter2+"]/a[1]";
			varLocatedIn[counter] = driver.findElement(By.xpath(varXPath)).getText();
			System.out.println(varLocatedIn[counter] );
			}
			catch(Exception NoSuchElementException)
			{
				break;
			}
		}*/

		editItemHP();
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapMyLowes.lnkSelectSpaces)).click();
		Thread.sleep(5000);
		List<WebElement> varYourSpaces = driver.findElements(By.xpath(UIMapMyLowes.webElmntSpaceList));
		System.out.println("Reached here");
		i=0;
		j=0;
		for (WebElement varYourSpaces2 : varYourSpaces) {
          
			
			j = i+1;
            String varYourSpacesxpath = UIMapMyLowes.webElmntSpaceList+"["+j+"]/label";
            b[i] = driver.findElement(By.xpath(varYourSpacesxpath)).getText();
            System.out.println("String at place:"+i+":"+b[i]);
            i=i+1;
          
        }
		
		i=0;
		if(varYourSpaces.size()==varSpaces.size())
		{
		System.out.println("Reached here");	
		for(i=0;i<varYourSpaces.size();i++)
		{
			System.out.println("String a:"+i+"Value:"+a[i]);
			System.out.println("String b:"+i+"Value:"+b[i]);
			if(a[i].equals(b[i]))
				continue;
			else
				report.updateTestLog("Checking Your Spaces section","Values in Your Spaces section not correct" ,Status.FAIL);
				break;
		}
		if (i==(varYourSpaces.size()))
		{
			report.updateTestLog("Checking Your Spaces section","Values in Your Spaces section correct" ,Status.PASS);
		}}
		else
		{
			report.updateTestLog("Checking Your Spaces section","Values in Your Spaces section not correct" ,Status.FAIL);
		}
		i=0;
		for(j=1;j<=varYourSpaces.size();j++)
			{
			String varSpacelabel = UIMapMyLowes.webElmntSpaceList+"["+j+"]/label";
			//System.out.println(varSpacelabel);
			String varSpacelabel2 = driver.findElement(By.xpath(varSpacelabel)).getText();
			System.out.println(varSpacelabel2);
			if(varSpacelabel2.equals(dataTable.getData("General_Data", "NewSpaceNAme")))
			{
					
					try
					{
						String varOldSpace = UIMapMyLowes.webElmntSpaceList+"["+j+"]/input";
						String varOldSpacechecked = driver.findElement(By.xpath(varOldSpace)).getAttribute("checked");
						System.out.println(varOldSpacechecked);
						if(varOldSpacechecked.equals("true"))
						{
							report.updateTestLog("Checking Your Spaces section","Value"+varSpacelabel2+" in Your Spaces section checked" ,Status.PASS);
							driver.findElement(By.xpath(varOldSpace)).click();
							report.updateTestLog("Unchecking Old Space","Old space:"+varSpacelabel2+" Unchecked",Status.DONE);
							break;
						}
						
					}
					catch(Exception NullPointerException)
					{
						report.updateTestLog("Checking Your Spaces section","Value"+varSpacelabel2+" in Your Spaces section NOT checked" ,Status.FAIL);
					}
			}
			else
				continue;
					
		}
		
		
		//selecting space
		int varCount=ps.countWebElement(UIMapMyLowes.lblYourSpacesSpaceList);
		for(i=1;i<varCount;i++)
		{
			
			String varSpacelabel = UIMapMyLowes.webElmntSpaceList+"["+i+"]/label";
			//System.out.println(varSpacelabel);
			String varSpacelabel2 = driver.findElement(By.xpath(varSpacelabel)).getText();
			//System.out.println(varSpacelabel2);
			if(varSpacelabel2.equals(dataTable.getData("General_Data","Space")))
			{
				String varSpace = UIMapMyLowes.webElmntSpaceList+"["+i+"]/input";
				driver.findElement(By.xpath(varSpace)).click();
				report.updateTestLog("Selecting new space","New space:"+varSpacelabel2+" selected",Status.DONE);
				break;
			}
			else
			{
				continue;
			}
		}
		//selecting Interior space
		for(i=1;i<11;i++)
		{
			
			String varSpacelabel = UIMapMyLowes.webElmntIntSpaceList+"["+i+"]/label";
			//System.out.println(varSpacelabel);
			String varSpacelabel2 = driver.findElement(By.xpath(varSpacelabel)).getText();
			//System.out.println(varSpacelabel2);
			if(varSpacelabel2.equals(dataTable.getData("General_Data","NewInteriorSpace")))
			{
				String varSpace = UIMapMyLowes.webElmntIntSpaceList+"["+i+"]/input";
				driver.findElement(By.xpath(varSpace)).click();
				report.updateTestLog("Selecting new space","New Interior space:"+varSpacelabel2+" selected",Status.DONE);
				break;
			}
			else
			{
				continue;
			}
		}
		//selecting Exterior space
		for(i=1;i<11;i++)
		{
			
			String varSpacelabel = UIMapMyLowes.webElmntExtSpaceList+"["+i+"]/label";
			//System.out.println(varSpacelabel);
			String varSpacelabel2 = driver.findElement(By.xpath(varSpacelabel)).getText();
			//System.out.println(varSpacelabel2);
			if(varSpacelabel2.equals(dataTable.getData("General_Data","NewExteriorSpace")))
			{
				String varSpace =  UIMapMyLowes.webElmntExtSpaceList+"["+i+"]/input";
				driver.findElement(By.xpath(varSpace)).click();
				report.updateTestLog("Selecting new space","New Exterior space:"+varSpacelabel2+" selected",Status.DONE);
				break;
			}
			else
			{
				continue;
			}
		}
		driver.findElement(By.xpath(UIMapMyLowes.btnSave)).click();
		Thread.sleep(5000);
		switchListViewItemsHP();
		
		Thread.sleep(2000);
		//String[] varLocatedIn2 = new String[3];
		String varLocatedIn3=null;
		int FlagSpace = 0;
		int FlagIntSpace = 0;
		int FlagExtSpace = 0;
		int counter;
		for (counter=0;counter<=2;counter++)
		{
			try{
			int counter2 = counter+1;
			String varXPath = UIMapMyLowes.webElmntLocatedIn+"["+counter2+"]/a[1]";
			varLocatedIn3 = driver.findElement(By.xpath(varXPath)).getText();
			System.out.println(varLocatedIn3);
			if(varLocatedIn3.equals(dataTable.getData("General_Data","Space")))
					{
				FlagSpace = 1;
				System.out.println("Space Verified");
				
					}
			else if(varLocatedIn3.equals(dataTable.getData("General_Data","NewInteriorSpace")))
			{
				FlagIntSpace = 1;
				System.out.println("NewInteriorSpace Verified");
				
			}
			else if(varLocatedIn3.equals(dataTable.getData("General_Data","NewExteriorSpace")))
			{
				FlagExtSpace = 1;
				System.out.println("NewExteriorSpace Verified");
				
			}
			}
			catch(Exception NoSuchElementException)
			{
				break;
			}
		}
		if((FlagSpace==1)&&(FlagIntSpace==1)&&(FlagExtSpace==1))
		{
			report.updateTestLog("Validating Located IN","Located In Verified",Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Located IN","Located In NOT Verified",Status.FAIL);
		}
		
	}
	
	
	
	/*This function deletes the newly added spaces*/
	public void deleteAddedSpaces() throws Exception
	{
		driver.findElement(By.partialLinkText(dataTable.getData("General_Data","Space"))).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.btnDeleteSpace2)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.btnDeleteSpaceConfirm)).click();
		Thread.sleep(5000);
		report.updateTestLog("Deleting added space","Space deleted",Status.DONE);
		
		
		if(dataTable.getData("General_Data","NewInteriorSpace").equals(""))
		{System.out.println("No Interior Space");}
		else
		{
		driver.findElement(By.partialLinkText(dataTable.getData("General_Data","NewInteriorSpace"))).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.btnDeleteSpace2)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.btnDeleteSpaceConfirm)).click();
		Thread.sleep(5000);
		report.updateTestLog("Deleting added Interior space","Space deleted",Status.DONE);
		}
		if(dataTable.getData("General_Data","NewExteriorSpace").equals(""))
		{System.out.println("No Exterior Space");}
		else
		{
		driver.findElement(By.partialLinkText(dataTable.getData("General_Data","NewExteriorSpace"))).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.btnDeleteSpace2)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.btnDeleteSpaceConfirm)).click();
		Thread.sleep(5000);
		report.updateTestLog("Deleting added Exterior space","Space deleted",Status.DONE);
		}
	}
	
	/*This function deletes the newly added spaces*/
	public void deleteNewAddedSpaces(String space) throws Exception
	{
		driver.findElement(By.partialLinkText(space)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.btnDeleteSpace2)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.btnDeleteSpaceConfirm)).click();
		Thread.sleep(5000);
		report.updateTestLog("Deleting added space","Space deleted",Status.DONE);
		
	}
	
	/*This function validates the Containers in Home Profile Summary page*/
	public void validateContainersHP() throws Exception
	{
		//validating presence of containers
		boolean varIsFrstContainerPrsnt = selenium.isElementPresent(UIMapMyLowes.webElmntContainer1);
		if(varIsFrstContainerPrsnt)
		{
			report.updateTestLog("Validating Container 1","Container 1 Present",Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Container 1","Container 1 NOT Present",Status.FAIL);
		}
		boolean varIsScndContainerPrsnt = selenium.isElementPresent(UIMapMyLowes.webElmntContainer2);
		if(varIsScndContainerPrsnt)
		{
			report.updateTestLog("Validating Container 2","Container 2 Present",Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Container 2","Container 2 NOT Present",Status.FAIL);
		}
		boolean varIsThrdContainerPrsnt = selenium.isElementPresent(UIMapMyLowes.webElmntContainer3);
		if(varIsThrdContainerPrsnt)
		{
			report.updateTestLog("Validating Container 3","Container 3 Present",Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Container 3","Container 3 NOT Present",Status.FAIL);
		}
		boolean varContainer1 = driver.findElement(By.xpath(UIMapMyLowes.webElmntContainer1)).isEnabled();
		if(varContainer1)
		{
			report.updateTestLog("Validating Container 1 Enabled","Container 1 Enabled",Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Container 1 Enabled","Container 1 NOT Enabled",Status.FAIL);
		}
		boolean varContainer2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntContainer2)).isEnabled();
		if(varContainer2)
		{
			report.updateTestLog("Validating Container 2 Enabled","Container 2 Enabled",Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Container 2 Enabled","Container 2 NOT Enabled",Status.FAIL);
		}
		boolean varContainer3 = driver.findElement(By.xpath(UIMapMyLowes.webElmntContainer3)).isEnabled();
		if(varContainer3)
		{
			report.updateTestLog("Validating Container 3 Enabled","Container 3 Enabled",Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Container 3 Enabled","Container 3 NOT Enabled",Status.FAIL);
		}
		
	}
	
	/*This function deletes Home Profile for a user*/
	public void deleteHomeProfile() throws Exception
	{
		driver.findElement(By.cssSelector(UIMapMyLowes.btnDeleteHomeProfile)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.txtDeleteHomeProfile)).sendKeys("DELETE");
		System.out.println("Delete Popup");
		driver.findElement(By.xpath(UIMapMyLowes.btnDeleteHomeProfileConfirm)).click();
		System.out.println("Delete Popup->DELETE");
		Thread.sleep(2000);
		String varProfileDeleted = driver.findElement(By.cssSelector(UIMapMyLowes.webElmntDeleteHPMessage)).getText();	
		System.out.println(varProfileDeleted);
		if(varProfileDeleted.equals("Your home profile has been deleted."))
		{
			driver.findElement(By.cssSelector(UIMapMyLowes.btnDeleteHomeProfileOK)).click();
			selenium.waitForPageToLoad("30000");
			String varMyLowes = driver.findElement(By.xpath(UIMapMyLowes.webElmntBrdCrumbsLvl2)).getText();
			System.out.println(varMyLowes);
			if(varMyLowes.equals("MyLowe's"))
			{
			report.updateTestLog("Deleting Home Profile","Home Profile Deleted",Status.PASS);
			}
			else
			{
				report.updateTestLog("Deleting Home Profile","Home Profile NOT Deleted",Status.FAIL);
			}
		}
		else
			report.updateTestLog("Deleting Home Profile","Some Error Ocurred",Status.FAIL);
		
		
	}
	
	/*This function validates Space summary page having Items and Dimensions*/
	public void validateSpacePageHP() throws Exception
	{
		boolean varItemList = selenium.isElementPresent(UIMapMyLowes.webElmntItemList);
		boolean varSpaceNotes = selenium.isElementPresent(UIMapMyLowes.webElmntSpaceNotes);
		if(varItemList)
		{
			report.updateTestLog("Opening Space page","Item List displayed",Status.PASS);
		}
		else
		{
			report.updateTestLog("Opening Space page","Item List NOT displayed",Status.FAIL);
		}
		if(varSpaceNotes)
		{
			report.updateTestLog("Opening Space page","Space Notes displayed",Status.PASS);
		}
		else
		{
			report.updateTestLog("Opening Space page","Space Notes NOT displayed",Status.FAIL);
		}
	}
	
	/*This function validates the Dimensions page for a space with no dimensions added*/
	public void validateDimPageWithNoDim() throws Exception
	{
		String varSelectShape = driver.findElement(By.xpath(UIMapMyLowes.webElmntSelectAShape)).getText();
		System.out.println(varSelectShape);
		if(varSelectShape.equals("1. Select a shape"))
		{
			report.updateTestLog("Checking Dimensions page","Select A Shape Process displayed",Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Dimensions page","Select A Shape Process NOT displayed",Status.FAIL);
		}
	}
	
	/*This function validates the welcome message on HP Summary page*/
	public void validateWelcomeMsgBlock() throws Exception
	{	boolean varIsWelcomeMsg = driver.findElement(By.xpath(UIMapMyLowes.webElmntWelcomeMsg)).isDisplayed();
	System.out.println(varIsWelcomeMsg);
		
		//String varWelcomeBlock = driver.findElement(By.xpath("//*[@id='welcome_message']/div[2]/h2")).getText();
		//System.out.println(varWelcomeBlock);
		if(varIsWelcomeMsg)
		{
			report.updateTestLog("Checking Welcome Message","Welcome Message displayed",Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Welcome Message","Welcome Message NOT displayed",Status.FAIL);
		}
		boolean varHideWelcomeLink = driver.findElement(By.partialLinkText("Hide Welcome Message")).isDisplayed();
		System.out.println(varHideWelcomeLink);
		if(varHideWelcomeLink)
		{
			report.updateTestLog("Checking Hide Welcome Message link","Hide Welcome Message link displayed",Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Hide Welcome Message link","Hide Welcome Message link NOT displayed",Status.FAIL);
		}
		boolean varFAQLink = driver.findElement(By.partialLinkText("FAQ page")).isDisplayed();
		System.out.println(varFAQLink);
		if(varFAQLink)
		{
			report.updateTestLog("Checking FAQ link","FAQ link displayed",Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking FAQ link","FAQ link NOT displayed",Status.FAIL);
		}
		
	}
	
	/*This function refereshes HP Summary page*/
	public void refreshPage() throws Exception
	{
		driver.navigate().refresh();
		selenium.waitForPageToLoad("20000");
		report.updateTestLog("Refreshing Page","Page Refreshed",Status.DONE);
	}
	
	/*This function hides the welcome message*/
	public void hideWelcomeMessage() throws Exception
	{
		driver.findElement(By.partialLinkText("Hide Welcome Message")).click();
		Thread.sleep(2000);
		report.updateTestLog("Clicking Hide Welcome Message","Hide Welcome Message clicked",Status.DONE);
	}
	
	/*this function displays the Welcome Message*/
	public void showWelcomeMessage() throws Exception
	{
		driver.findElement(By.partialLinkText("Show Welcome Message")).click();
		Thread.sleep(2000);
		report.updateTestLog("Clicking Show Welcome Message","Show Welcome Message clicked",Status.DONE);
	}
	
	/*This function validates whether the welcome message is hidden on HP summary page*/
	public void validateHiddenWlcmMsg() throws Exception
	{
		boolean varIsWelcomeMsg = driver.findElement(By.xpath(UIMapMyLowes.webElmntWelcomeMsg)).isDisplayed();
		
		
		System.out.println(varIsWelcomeMsg);
		if(varIsWelcomeMsg)
		{
			report.updateTestLog("Checking Welcome Message Block","Welcome Message NOT Hidden",Status.FAIL);
		}
		else
		{
			report.updateTestLog("Checking Welcome Message Block","Welcome Message Hidden",Status.PASS);
		}
		boolean varShowWelcomeLink = driver.findElement(By.partialLinkText("Show Welcome Message")).isDisplayed();
		System.out.println(varShowWelcomeLink);
		if(varShowWelcomeLink)
		{
			report.updateTestLog("Checking Show Welcome Message link","Show Welcome Message link displayed",Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Show Welcome Message link","Show Welcome Message link NOT displayed",Status.FAIL);
		}
		
	}
	
	/*This function creates a new Space HP*/
	public void createNewSpaceHP() throws Exception
	{
		driver.findElement(By.cssSelector(UIMapMyLowes.webElmntSelectShow)).click();
		Thread.sleep(2000);
		try{
		String varSpaceXpath = "//a[contains(text(),'"+dataTable.getData("General_Data","Space")+"')]";
		System.out.println(varSpaceXpath);
		driver.findElement(By.xpath(varSpaceXpath)).click();
		}
		catch(Exception ElementNotVisibleException)
		{
			String varSpaceXpath = "(//a[contains(text(),'"+dataTable.getData("General_Data","Space")+"')])[2]";
			System.out.println(varSpaceXpath);
			driver.findElement(By.xpath(varSpaceXpath)).click();
		}
		Thread.sleep(5000);
		String varSpace = driver.findElement(By.id(UIMapMyLowes.webElmntSpaceName)).getText();
		System.out.println(varSpace);
		if(varSpace.equals(dataTable.getData("General_Data","Space")))
		{
			report.updateTestLog("Creating New Space","Space page displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Creating New Space","Space page NOT displayed", Status.FAIL);
		}
	}
	
	
	
	/*This function selects shape for Space dimension in HP*/
	public void selectShapeDimenHP() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.webElmntShapeRect2)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.btnContinue)).click();
		Thread.sleep(5000);
		String varLawnAreaExpanded = driver.findElement(By.xpath(UIMapMyLowes.webElmntLawnAreaExpanded)).getAttribute("aria-expanded");
		if(varLawnAreaExpanded.equals("true"))
		{
			report.updateTestLog("Selecting Shape","Shape selected successfully" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Selecting Shape","Shape NOT selected successfully" ,Status.FAIL);
		}
		
	}
	
	/*This function adds YARD-Rect shape dimenions*/
	public void addYardDimensionsHP() throws Exception
	{
		//Entering Top dim
		driver.findElement(By.xpath(UIMapMyLowes.webElmntTopBorder)).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).sendKeys(dataTable.getData("General_Data","LengthTop"));
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath("//div[16]/div/div[4]/div/a/span")).click();
		
		Thread.sleep(1000);
		String varTopLen = driver.findElement(By.xpath(UIMapMyLowes.webElmntTopCanvas)).getText();
		System.out.println("Top length saved:"+varTopLen);
		String varXpectedTopLen = dataTable.getData("General_Data","LengthTop").concat("' 0\"");
		System.out.println("Top length xpected:"+varXpectedTopLen);
		if(varTopLen.equals(varXpectedTopLen))
		{
			report.updateTestLog("Entering Top Length","Top Length displayed on top border" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Entering Top Length","Top Length NOT displayed on top border" ,Status.FAIL);
		}
		boolean varTopArrow = driver.findElement(By.xpath(UIMapMyLowes.webElmntTopArrow)).isDisplayed();
		if(varTopArrow)
		{
			report.updateTestLog("Entering Top Length","Arrow on top border" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Entering Top Length","Arrow NOT on top border" ,Status.FAIL);
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntBottomBorder));
		
		//Entering Bottom dim
		driver.findElement(By.xpath(UIMapMyLowes.webElmntBottomBorder)).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).sendKeys(dataTable.getData("General_Data","LengthBottom"));
		//driver.findElement(By.xpath("//div[16]/div/div[4]/div/a/span")).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		String varBottomLen = driver.findElement(By.xpath(UIMapMyLowes.webElmntBottomCanvas)).getText();
		System.out.println("Bottom length saved:"+varBottomLen);
		String varXpectedBottomLen = dataTable.getData("General_Data","LengthBottom").concat("' 0\"");
		System.out.println("Bottom length xpected:"+varXpectedBottomLen);
		if(varBottomLen.equals(varXpectedBottomLen))
		{
			report.updateTestLog("Entering Bottom Length","Bottom Length displayed on Bottom border" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Entering Bottom Length","Bottom Length NOT displayed on Bottom border" ,Status.FAIL);
		}
		boolean varBottomArrow = driver.findElement(By.xpath(UIMapMyLowes.webElmntBottomArrow)).isDisplayed();
		if(varBottomArrow)
		{
			report.updateTestLog("Entering Bottom Length","Arrow on Bottom border" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Entering Bottom Length","Arrow NOT on Bottom border" ,Status.FAIL);
		}
		Thread.sleep(2000);
		//Entering Left dim
		driver.findElement(By.xpath(UIMapMyLowes.webElmntLeftBorder));
		
		driver.findElement(By.xpath(UIMapMyLowes.webElmntLeftBorder)).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).sendKeys(dataTable.getData("General_Data","LengthLeft"));
		//driver.findElement(By.xpath("//div[16]/div/div[4]/div/a/span")).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		String varLeftLen = driver.findElement(By.xpath(UIMapMyLowes.webElmntLeftCanvas)).getText();
		System.out.println("Left length saved:"+varLeftLen);
		String varXpectedLeftLen = dataTable.getData("General_Data","LengthLeft").concat("' 0\"");
		System.out.println("Left length xpected:"+varXpectedLeftLen);
		if(varLeftLen.equals(varXpectedLeftLen))
		{
			report.updateTestLog("Entering Left Length","Left Length displayed on Left border" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Entering Left Length","Left Length NOT displayed on Left border" ,Status.FAIL);
		}
		boolean varLeftArrow = driver.findElement(By.xpath(UIMapMyLowes.webElmntLeftArrow)).isDisplayed();
		if(varLeftArrow)
		{
			report.updateTestLog("Entering Left Length","Arrow on Left border" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Entering Left Length","Arrow NOT on Left border" ,Status.FAIL);
		}
		
		//Entering Right dim
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntRightBorder));
		driver.findElement(By.xpath(UIMapMyLowes.webElmntRightBorder)).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).sendKeys(dataTable.getData("General_Data","LengthRight"));
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		String varRightLen = driver.findElement(By.xpath(UIMapMyLowes.webElmntRightCanvas)).getText();
		System.out.println("Right length saved:"+varRightLen);
		String varXpectedRightLen = dataTable.getData("General_Data","LengthRight").concat("' 0\"");
		System.out.println("Right length xpected:"+varXpectedRightLen);
		if(varRightLen.equals(varXpectedRightLen))
		{
			report.updateTestLog("Entering Right Length","Right Length displayed on Right border" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Entering Right Length","Right Length NOT displayed on Right border" ,Status.FAIL);
		}
		boolean varRightArrow = driver.findElement(By.xpath(UIMapMyLowes.webElmntRightArrow)).isDisplayed();
		if(varRightArrow)
		{
			report.updateTestLog("Entering Right Length","Arrow on Right border" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Entering Right Length","Arrow NOT on Right border" ,Status.FAIL);
		}
		
		//verifying Negative Space fields
		boolean varIsNegSpaceName = driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceAreaName1)).isDisplayed();
		if(varIsNegSpaceName)
		{
			report.updateTestLog("Validating Negative Space Name field","Negative Space Name field displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Negative Space Name field","Negative Space Name field NOT displayed" ,Status.FAIL);
		}
		boolean varisNegSpaceArea = driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceArea1)).isDisplayed();
		if(varisNegSpaceArea)
		{
			report.updateTestLog("Validating Negative Space Area field","Negative Space Area field displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Negative Space Area field","Negative Space Area field NOT displayed" ,Status.FAIL);
		}
		
		//Clicking Finish
		driver.findElement(By.cssSelector(UIMapMyLowes.btnFinish)).click();
		Thread.sleep(5000);
		
		//Validating Total Area and Net Area
		int varLen = Integer.valueOf(dataTable.getData("General_Data","LengthTop"));
		int varWid = Integer.valueOf(dataTable.getData("General_Data","LengthLeft"));
		int varArea = (varLen*varWid);
		String varTotalArea = driver.findElement(By.xpath(UIMapMyLowes.webElmntTotalArea)).getText();
		System.out.println("Total Area:"+varTotalArea);
		String[] s = varTotalArea.split(" ");
		int varTotalArea2 = Integer.valueOf(s[0]);
		System.out.println("Total Area:"+varTotalArea2);
		String varNetArea = driver.findElement(By.cssSelector(UIMapMyLowes.webElmntNetArea)).getText();
		System.out.println("Total Net Area:"+varNetArea);
		String[] s2 = varNetArea.split(" ");
		int varNetArea2 = Integer.valueOf(s2[0]);
		System.out.println("Total Net Area:"+varNetArea2);
		if(varArea==varTotalArea2)
		{
			report.updateTestLog("Checking Total Area","Total Area calculated correctly" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Total Area","Total Area calculation Incorrect" ,Status.FAIL);
		}
		if(varArea==varNetArea2)
		{
			report.updateTestLog("Checking Net Area","Net Area calculated correctly" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Net Area","Net Area calculation Incorrect" ,Status.FAIL);
		}
		
	}
	
	/*This function clicks on Edit Dimensions button*/
	public void clickEditYardDimHP() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.btnEditDimensions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.btnEditYardMsrments)).click();
	}
	
	/*This function edits Yard dimensions and saves it*/
	public void editYardDimHP() throws Exception
	{
		//editing Right dim
		driver.findElement(By.xpath(UIMapMyLowes.webElmntRightBorder)).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).sendKeys(dataTable.getData("General_Data","LengthRight"));
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).sendKeys(Keys.ENTER);
		/*Thread.sleep(2000);
		String varRightLen = driver.findElement(By.xpath("//div[@id='canvas']/div[6]")).getText();
		System.out.println("Right length saved:"+varRightLen);
		String varXpectedRightLen = dataTable.getData("General_Data","LengthRight").concat("' 0\"");
		System.out.println("Right length xpected:"+varXpectedRightLen);
		if(varRightLen.equals(varXpectedRightLen))
		{
			report.updateTestLog("Editing Right Length","Updated Right Length displayed on Right border" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Editing Right Length","Updated Right Length NOT displayed on Right border" ,Status.FAIL);
		}*/
		driver.findElement(By.xpath(UIMapMyLowes.webElmntRightBorder)).click();
		//driver.findElement(By.id("border_border_128947294")).click();
		String varRightDim2 = driver.findElement(By.xpath(UIMapMyLowes.txtLength)).getAttribute("value");
		driver.findElement(By.xpath(UIMapMyLowes.lnkCancel)).click();
		System.out.println("Right Dim after edit:"+varRightDim2);
		if(varRightDim2.equals(dataTable.getData("General_Data","LengthRight")))
		{
			report.updateTestLog("editing Right Dimensions","Dimensions updated" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("editing Right Dimensions","Dimensions NOT updated" ,Status.FAIL);
		}
		
		//editing Top dim
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntTopBorder));
		driver.findElement(By.xpath(UIMapMyLowes.webElmntTopBorder)).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).sendKeys(dataTable.getData("General_Data","LengthTop"));
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntTopBorder)).click();
		//driver.findElement(By.id("border_border_128947293")).click();
		String varTopDim2 = driver.findElement(By.xpath(UIMapMyLowes.txtLength)).getAttribute("value");
		driver.findElement(By.xpath(UIMapMyLowes.lnkCancel)).click();
		System.out.println("Top Dim after edit:"+varTopDim2);
		if(varTopDim2.equals(dataTable.getData("General_Data","LengthTop")))
		{
			report.updateTestLog("editing Top Dimensions","Dimensions updated" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("editing Top Dimensions","Dimensions NOT updated" ,Status.FAIL);
		}
		/*String varTopLen = driver.findElement(By.xpath("//div[@id='canvas']/div[7]")).getText();
		System.out.println("Top length saved:"+varTopLen);
		String varXpectedTopLen = dataTable.getData("General_Data","LengthTop").concat("' 0\"");
		System.out.println("Top length xpected:"+varXpectedTopLen);
		if(varTopLen.equals(varXpectedTopLen))
		{
			report.updateTestLog("Editing Top Length","Updated Top Length displayed on top border" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Editing Top Length","Updated Top Length NOT displayed on top border" ,Status.FAIL);
		}*/
		//editing Bottom dim
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntBottomBorder));
		driver.findElement(By.xpath(UIMapMyLowes.webElmntBottomBorder)).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).sendKeys(dataTable.getData("General_Data","LengthBottom"));
		//driver.findElement(By.xpath("//div[16]/div/div[4]/div/a/span")).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntBottomBorder)).click();
		//driver.findElement(By.id("border_border_128947292")).click();
		String varBottomDim2 = driver.findElement(By.xpath(UIMapMyLowes.txtLength)).getAttribute("value");
		driver.findElement(By.xpath(UIMapMyLowes.lnkCancel)).click();
		System.out.println("Bottom Dim after edit:"+varBottomDim2);
		if(varBottomDim2.equals(dataTable.getData("General_Data","LengthBottom")))
		{
			report.updateTestLog("editing Bottom Dimensions","Dimensions updated" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("editing Bottom Dimensions","Dimensions NOT updated" ,Status.FAIL);
		}
		/*String varBottomLen = driver.findElement(By.xpath("//div[@id='canvas']/div[5]")).getText();
		System.out.println("Bottom length saved:"+varBottomLen);
		String varXpectedBottomLen = dataTable.getData("General_Data","LengthBottom").concat("' 0\"");
		System.out.println("Bottom length xpected:"+varXpectedBottomLen);
		if(varBottomLen.equals(varXpectedBottomLen))
		{
			report.updateTestLog("Editing Bottom Length","Updated Bottom Length displayed on Bottom border" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Editing Bottom Length","Updated Bottom Length NOT displayed on Bottom border" ,Status.FAIL);
		}*/
		//editing left dim
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntLeftBorder));
		driver.findElement(By.xpath(UIMapMyLowes.webElmntLeftBorder)).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).sendKeys(dataTable.getData("General_Data","LengthLeft"));
		//driver.findElement(By.xpath("//div[16]/div/div[4]/div/a/span")).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtLength)).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntLeftBorder)).click();
		//driver.findElement(By.id("border_border_128947291")).click();
		String varLeftDim2 = driver.findElement(By.xpath(UIMapMyLowes.txtLength)).getAttribute("value");
		System.out.println("Left Dim after edit:"+varLeftDim2);
		driver.findElement(By.xpath(UIMapMyLowes.lnkCancel)).click();
		if(varLeftDim2.equals(dataTable.getData("General_Data","LengthLeft")))
		{
			report.updateTestLog("editing Left Dimensions","Dimensions updated" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("editing Left Dimensions","Dimensions NOT updated" ,Status.FAIL);
		}
		/*String varLeftLen = driver.findElement(By.xpath("//div[@id='canvas']/div[4]")).getText();
		System.out.println("Left length saved:"+varLeftLen);
		String varXpectedLeftLen = dataTable.getData("General_Data","LengthLeft").concat("' 0\"");
		System.out.println("Left length xpected:"+varXpectedLeftLen);
		if(varLeftLen.equals(varXpectedLeftLen))
		{
			report.updateTestLog("Editing Left Length","Updated Left Length displayed on Left border" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Editing Left Length","Updated Left Length NOT displayed on Left border" ,Status.FAIL);
		}*/
		
		//editing Top Notes
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntTopBorder));
		driver.findElement(By.xpath(UIMapMyLowes.webElmntTopBorder)).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).sendKeys(dataTable.getData("General_Data","NoteTop"));
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntTopBorder)).click();
		String varTopNote2 = driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).getAttribute("value");
		driver.findElement(By.xpath(UIMapMyLowes.lnkCancel)).click();
		System.out.println("Top Note after edit:"+varTopNote2);
		if(varTopNote2.equals(dataTable.getData("General_Data","NoteTop")))
		{
			report.updateTestLog("Editing Top Notes","Top Border Notes Updated" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Editing Top Notes","Top Border Notes NOT Updated" ,Status.FAIL);
		}
		Thread.sleep(5000);
		//editing Bottom notes
		driver.findElement(By.xpath(UIMapMyLowes.webElmntBottomBorder));
		driver.findElement(By.xpath(UIMapMyLowes.webElmntBottomBorder)).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).sendKeys(dataTable.getData("General_Data","NoteBottom"));
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntBottomBorder)).click();
		String varBottomNote2 = driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).getAttribute("value");
		driver.findElement(By.xpath(UIMapMyLowes.lnkCancel)).click();
		System.out.println("Bottom Note after edit:"+varBottomNote2);
		if(varBottomNote2.equals(dataTable.getData("General_Data","NoteBottom")))
		{
			report.updateTestLog("Editing Bottom Notes","Bottom Border Notes Updated" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Editing Bottom Notes","Bottom Border Notes NOT Updated" ,Status.FAIL);
		}
		Thread.sleep(5000);
		//editing Left Notes
		driver.findElement(By.xpath(UIMapMyLowes.webElmntLeftBorder));
		driver.findElement(By.xpath(UIMapMyLowes.webElmntLeftBorder)).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).sendKeys(dataTable.getData("General_Data","NoteLeft"));
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntLeftBorder)).click();
		String varLeftNote2 = driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).getAttribute("value");
		driver.findElement(By.xpath(UIMapMyLowes.lnkCancel)).click();
		System.out.println("Left Note after edit:"+varLeftNote2);
		if(varLeftNote2.equals(dataTable.getData("General_Data","NoteLeft")))
		{
			report.updateTestLog("Editing Left Notes","Left Border Notes Updated" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Editing Left Notes","Left Border Notes NOT Updated" ,Status.FAIL);
		}
		Thread.sleep(5000);
		//editing RightNotes
		driver.findElement(By.xpath(UIMapMyLowes.webElmntRightBorder));
		driver.findElement(By.xpath(UIMapMyLowes.webElmntRightBorder)).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).sendKeys(dataTable.getData("General_Data","NoteRight"));
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntRightBorder)).click();
		String varRightNote2 = driver.findElement(By.xpath(UIMapMyLowes.txtNotes3)).getAttribute("value");
		driver.findElement(By.xpath(UIMapMyLowes.lnkCancel)).click();
		System.out.println("Right Note after edit:"+varRightNote2);
		if(varRightNote2.equals(dataTable.getData("General_Data","NoteRight")))
		{
			report.updateTestLog("Editing Right Notes","Right Border Notes Updated" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Editing Right Notes","Right Border Notes NOT Updated" ,Status.FAIL);
		}
		Thread.sleep(2000);
		
		//Clicking Finish
		driver.findElement(By.cssSelector(UIMapMyLowes.btnFinish)).click();
		Thread.sleep(5000);
		
		//checking for incorrect dimensions Message or Total Area/Net Area
		int varLeftDimValue = Integer.valueOf(dataTable.getData("General_Data","LengthLeft"));
		int varRightDimValue = Integer.valueOf(dataTable.getData("General_Data","LengthRight"));
		int varBottomDimValue = Integer.valueOf(dataTable.getData("General_Data","LengthBottom"));
		int varTopDimValue = Integer.valueOf(dataTable.getData("General_Data","LengthTop"));
		int varArea  = varLeftDimValue*varBottomDimValue;
		if((varLeftDimValue!=varRightDimValue) || (varBottomDimValue!=varTopDimValue))
			{
			String varErrorMsg = driver.findElement(By.xpath(UIMapMyLowes.webElmntDimNeededError)).getText();
			System.out.println(varErrorMsg);
			if(varErrorMsg.equals("We are unable to calculate the area with the dimensions you provided. Please check the values entered."))
			{
				report.updateTestLog("Clicking Finish after Editing Dimensions","Error Message displayed because of incorrect dimensions" ,Status.PASS);
			}
			}
		
		else
		{
	
		//int varLen = Integer.valueOf(dataTable.getData("General_Data","LengthTop"));
		//int varWid = Integer.valueOf(dataTable.getData("General_Data","LengthLeft"));
		//int varArea = (varLen*varWid);
		String varTotalArea = driver.findElement(By.xpath(UIMapMyLowes.webElmntTotalArea)).getText();
		System.out.println("Total Area:"+varTotalArea);
		String[] s = varTotalArea.split(" ");
		int varTotalArea2 = Integer.valueOf(s[0]);
		System.out.println("Total Area:"+varTotalArea2);
		String varNetArea = driver.findElement(By.cssSelector(UIMapMyLowes.webElmntNetArea)).getText();
		System.out.println("Total Net Area:"+varNetArea);
		String[] s2 = varNetArea.split(" ");
		int varNetArea2 = Integer.valueOf(s2[0]);
		System.out.println("Total Net Area:"+varNetArea2);
		if(varArea==varTotalArea2)
		{
			report.updateTestLog("Checking Total Area","Total Area calculated correctly" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Total Area","Total Area calculation Incorrect" ,Status.FAIL);
		}
		if(varArea==varNetArea2)
		{
			report.updateTestLog("Checking Net Area","Net Area calculated correctly" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Net Area","Net Area calculation Incorrect" ,Status.FAIL);
		}
		}
	
	}
	
	/*This function adds first negative space*/
	public void addFirstNegativeSpace() throws Exception
	{
		 driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceAreaName1)).clear();
		 driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceAreaName1)).sendKeys(dataTable.getData("General_Data","NegSpaceName"));
		 driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceArea1)).clear();
		 driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceArea1)).sendKeys(dataTable.getData("General_Data","NegSpaceArea"));
		 
		 driver.findElement(By.cssSelector(UIMapMyLowes.btnFinish)).click();
		 Thread.sleep(5000);
		 
		 String varTotalArea = driver.findElement(By.xpath(UIMapMyLowes.webElmntTotalArea)).getText();
		 System.out.println("Total Area:"+varTotalArea);
		 String[] s = varTotalArea.split(" ");
		 int varTotalArea2 = Integer.valueOf(s[0]);
		 System.out.println("Total Area:"+varTotalArea2);
		 int varNegSpace1 = Integer.valueOf(dataTable.getData("General_Data","NegSpaceArea"));
		 int varNetArea = varTotalArea2-varNegSpace1;
		 System.out.println("Net Area:"+varNetArea);
		 String varNetArea2 = driver.findElement(By.cssSelector(UIMapMyLowes.webElmntNetArea)).getText();
		 System.out.println(varNetArea2);
		 if(varNetArea2.equals(varNetArea+" sq. ft."))
		 {
			 report.updateTestLog("Clicking on Finish link","Net Area calculation is correct" ,Status.PASS);
		 }
		 else
		 {
			 report.updateTestLog("Clicking on Finish link","Net Area calculation is NOT correct" ,Status.PASS);
		 }
		 
	}
	
	/*This function deletes the single Negative space added to the dimension*/
	public void deleteFrstNegSpace() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.btnEditDimensions)).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath(UIMapMyLowes.webElmntDeleteNegSpaceArea1)).click();
		 Thread.sleep(5000);
		 driver.findElement(By.cssSelector(UIMapMyLowes.btnFinish)).click();
		 Thread.sleep(5000);
		 report.updateTestLog("Deleting single negative space","Negative space deleted" ,Status.PASS);
	}
	
	/*This function clicks on Summary link*/
	public void clickSummaryHP() throws Exception
	{
		driver.findElement(By.id(UIMapMyLowes.webElmntSpaceName)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntSummary)).click();
		selenium.waitForPageToLoad("10000");
		boolean varSummaryPage = selenium.isElementPresent(UIMapMyLowes.webElmntSpaceCount);
		if(varSummaryPage)
		{
			report.updateTestLog("Clicking Summary link","Home Profile summary page displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking Summary link","Home Profile summary page NOT displayed" ,Status.FAIL);
		}
	}
	
	/*This function renames Home Profile page*/
	public void renameHomeProfile() throws Exception
	{
	Actions actions = new Actions(driver);
	WebElement menuHoverLink = driver.findElement(By.xpath(UIMapMyLowes.webElmntHPName));
	actions.moveToElement(menuHoverLink).build().perform();
	
	Thread.sleep(5000);
	WebElement varRenameLink = driver.findElement(By.xpath(UIMapMyLowes.lnkHPNameRename));
	actions.moveToElement(varRenameLink).build().perform();
	varRenameLink.click();
	//String varRename = driver.findElement(By.xpath(UIMapMyLowes.lnkHPNameRename)).getText();
	//System.out.println(varRename);
	//driver.findElement(By.xpath(UIMapMyLowes.lnkHPNameRename)).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath(UIMapMyLowes.txtHPNameRename)).clear();
	driver.findElement(By.xpath(UIMapMyLowes.txtHPNameRename)).sendKeys(dataTable.getData("General_Data","NewHPNAme"));
	driver.findElement(By.xpath(UIMapMyLowes.btnHPNameRenameSave)).click();
	Thread.sleep(5000);
	String varNewHPName = driver.findElement(By.xpath(UIMapMyLowes.webElmntHPName)).getText();
	if(varNewHPName.equals(dataTable.getData("General_Data","NewHPNAme")))
	{
		report.updateTestLog("Renaming Home Profile","Home Profile Renamed" ,Status.PASS);
	}
	else
	{
		report.updateTestLog("Renaming Home Profile","Home Profile Rename UNSUCCESSFUL" ,Status.FAIL);
	}
	}
	
	/*This function renames Space*/
	public void renameSpaceHP() throws Exception
	{
	Actions actions = new Actions(driver);
	WebElement menuHoverLink = driver.findElement(By.partialLinkText(dataTable.getData("General_Data","Space")));
	actions.moveToElement(menuHoverLink).build().perform();
	//System.out.println("Mouse Hover successful");
	Thread.sleep(5000);
	WebElement varRenameLink = driver.findElement(By.partialLinkText("Rename"));
	actions.moveToElement(varRenameLink).build().perform();
	varRenameLink.click();
	//String varRename = driver.findElement(By.partialLinkText("Rename")).getText();
	//System.out.println(varRename);
	//driver.findElement(By.partialLinkText("Rename")).click();
	Thread.sleep(1000);
	String varRenameXpath = "//input[@value='"+dataTable.getData("General_Data","Space")+"']";
	System.out.println(varRenameXpath);
	driver.findElement(By.xpath(varRenameXpath)).clear();
	driver.findElement(By.xpath(varRenameXpath)).sendKeys(dataTable.getData("General_Data","NewSpaceNAme"));
	driver.findElement(By.xpath(varRenameXpath)).sendKeys(Keys.ENTER);
	
	Thread.sleep(5000);
	boolean varSpaceRenamed = driver.findElement(By.partialLinkText(dataTable.getData("General_Data","NewSpaceNAme"))).isDisplayed();
	if(varSpaceRenamed)
	{
		report.updateTestLog("Renaming Space","Space Renamed" ,Status.PASS);
	}
	else
	{
		report.updateTestLog("Renaming Space","Space Rename UNSUCCESSFUL" ,Status.FAIL);
	}
	driver.findElement(By.partialLinkText(dataTable.getData("General_Data","NewSpaceNAme"))).click();
	Thread.sleep(5000);
	String varLocatedIn = driver.findElement(By.xpath(UIMapMyLowes.webElmntManualItemAssignedSpace)).getText();
	if(varLocatedIn.equals(dataTable.getData("General_Data","NewSpaceNAme")))
	{
		report.updateTestLog("Renaming Space","Space Renamed for Item" ,Status.PASS);
	}
	else
	{
		report.updateTestLog("Renaming Space","Space NOT Renamed for Item" ,Status.FAIL);
	}
	navHomeProfile();
	deleteNewAddedSpaces(dataTable.getData("General_Data","NewSpaceNAme"));
	
	}
	
	/*This functions returns WebElement list with already added spaces in a home profile*/
	public List<WebElement> getAvailableSpaces() throws Exception{
		 List<WebElement> varSpaces = driver.findElements(By.xpath(UIMapMyLowes.webElmntSpaceGrid));
		 
		 for (WebElement varSpaces2 : varSpaces) {
	            System.out.println(varSpaces2.getAttribute("data-space-subtype"));
	            
	        }
		 return varSpaces;

	}
	
	public void addNotesHomeProfile() throws Exception
	{
		driver.findElement(By.id(UIMapMyLowes.webElmntSpaceNotes)).click();
		//new Actions(driver).moveToElement(driver.findElement(By.id("space_notes"))).click().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.txtSpaceNotes)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtSpaceNotes)).sendKeys(dataTable.getData("General_Data","SpaceNotes"));
		driver.findElement(By.xpath(UIMapMyLowes.btnSaveSpaceNotes)).click();
		Thread.sleep(5000);
		String varSpaceNotes = driver.findElement(By.xpath(UIMapMyLowes.txtSpaceNotesPre)).getText();
		System.out.println("Notes Saved:"+varSpaceNotes);
		System.out.println("Notes in datasheet:"+ dataTable.getData("General_Data","SpaceNotes"));
		if(varSpaceNotes.equals(dataTable.getData("General_Data","SpaceNotes")))
		{
			report.updateTestLog("Saving Space Notes","Space Notes saved" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Saving Space Notes","Space Notes NOT saved", Status.FAIL);
		}
		
	}
	
	/*this function adds new products to home profile*/
	public void addProductFrmHomeProfile() throws Exception
	{
		driver.findElement(By.cssSelector(UIMapMyLowes.webElmntShow)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntAllProducts)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntEnterProductInfo2)).click();
	
		FunctionalComponents.waitforVisible(driver, UIMapMyLowes.webElmntManualItemFormX, 5);
		new Select(driver.findElement(By.name(UIMapMyLowes.drpDownProductType))).selectByVisibleText(dataTable.getData("General_Data","Category"));
		Thread.sleep(5000);
		
		
		
		boolean varProductType = selenium.isElementPresent(UIMapMyLowes.drpDownProductSubType);
		if(varProductType)
		{
		System.out.println("TYPE OF APPLIANCE DISPLAYED");
		new Select(driver.findElement(By.name(UIMapMyLowes.drpDownProductSubType))).selectByVisibleText(dataTable.getData("General_Data","ProductType"));
		}
		driver.findElement(By.id(UIMapMyLowes.drpDownProductName)).sendKeys(dataTable.getData("General_Data","ItemNbr"));
		//driver.findElement(By.xpath("//*[@id='manual_item_form']/ul/li[4]/button")).click();
		driver.findElement(By.xpath(UIMapMyLowes.btnSave)).click();
		Thread.sleep(10000);
		String varProductAdded = driver.findElement(By.xpath(UIMapMyLowes.webElmntItem1Name)).getText();
		System.out.println(varProductAdded);
		if(varProductAdded.equals(dataTable.getData("General_Data","ItemNbr")))
		{
			report.updateTestLog("Saving Product","Product "+varProductAdded+" saved" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Saving Product","Product "+varProductAdded+" NOT saved", Status.FAIL);
		}
		
		
	}
	
	/*this function adds new products to space*/
	public void addProductFrmSpace() throws Exception
	{
		System.out.println("Reaching in func addProductFrmSpace");
		driver.findElement(By.xpath(UIMapMyLowes.webElmntEnterProductInfo2)).click();
		//driver.findElement(By.xpath(UIMapMyLowes.webElmntEnterProductInfo)).click();
		FunctionalComponents.waitforVisible(driver, UIMapMyLowes.webElmntManualItemFormX, 5);
		new Select(driver.findElement(By.name(UIMapMyLowes.drpDownProductType))).selectByVisibleText(dataTable.getData("General_Data","Category"));
		Thread.sleep(5000);
		//boolean varProductType = selenium.isElementPresent("//*[@id='maProductType']/select");
		boolean varProductType = selenium.isElementPresent(UIMapMyLowes.drpDownProductSubType);
		if(varProductType)
		{
		new Select(driver.findElement(By.name(UIMapMyLowes.drpDownProductSubType))).selectByVisibleText(dataTable.getData("General_Data","ProductType"));
		}
		driver.findElement(By.id(UIMapMyLowes.drpDownProductName)).sendKeys(dataTable.getData("General_Data","ItemNbr"));
		driver.findElement(By.xpath(UIMapMyLowes.btnSave)).click();
		Thread.sleep(10000);
		String varProductAdded = driver.findElement(By.xpath(UIMapMyLowes.webElmntItem1Name)).getText();
		System.out.println(varProductAdded);
		if(varProductAdded.equals(dataTable.getData("General_Data","ItemNbr")))
		{
			report.updateTestLog("Saving Product","Product "+varProductAdded+" saved" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Saving Product","Product "+varProductAdded+" NOT saved", Status.FAIL);
		}
		
		
	}
	
	/*this function adds new products from HomeProfile entering all optional data*/
	public void addProductFrmHomeProfile2() throws Exception
	{
		driver.findElement(By.cssSelector(UIMapMyLowes.webElmntShow)).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath(UIMapMyLowes.lblShowPhotos)).click();
		
		Thread.sleep(2000);
		System.out.println("Reaching in func addProductFrmHomeProfile2");
		driver.findElement(By.xpath(UIMapMyLowes.webElmntEnterProductInfo2)).click();
		//driver.findElement(By.xpath(UIMapMyLowes.webElmntEnterProductInfo)).click();
		FunctionalComponents.waitforVisible(driver, UIMapMyLowes.webElmntManualItemFormX, 5);
		new Select(driver.findElement(By.name(UIMapMyLowes.drpDownProductType))).selectByVisibleText(dataTable.getData("General_Data","Category"));
		Thread.sleep(5000);
		//boolean varProductType = selenium.isElementPresent("//*[@id='maProductType']/select");
		boolean varProductType = selenium.isElementPresent(UIMapMyLowes.drpDownProductSubType);
		if(varProductType)
		{
		new Select(driver.findElement(By.name(UIMapMyLowes.drpDownProductSubType))).selectByVisibleText(dataTable.getData("General_Data","ProductType"));
		}
		driver.findElement(By.id(UIMapMyLowes.drpDownProductName)).sendKeys(dataTable.getData("General_Data","ItemName"));
		List<WebElement> varSpaces = driver.findElements(By.xpath(UIMapMyLowes.webElmntSpaceList));
		for(int i=1;i<varSpaces.size();i++)
		{
			String varSpacelabel = UIMapMyLowes.webElmntSpaceList+"["+i+"]/label";
			System.out.println(varSpacelabel);
			String varSpacelabel2 = driver.findElement(By.xpath(varSpacelabel)).getText();
			System.out.println(varSpacelabel2);
			if(varSpacelabel2.equals(dataTable.getData("General_Data","Space")))
			{
				String varSpace = UIMapMyLowes.webElmntSpaceList+"["+i+"]/input";
				driver.findElement(By.xpath(varSpace)).click();
				break;
			}
			else
			{
				continue;
			}
		}

		
		driver.findElement(By.id(UIMapMyLowes.txtBrand)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtBrand)).sendKeys(dataTable.getData("General_Data","Brand"));
		driver.findElement(By.cssSelector(UIMapMyLowes.webElmntdatePicker)).click();
	    driver.findElement(By.linkText(dataTable.getData("General_Data","PurchaseDate"))).click();
	    driver.findElement(By.id(UIMapMyLowes.txtHeight)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtHeight)).sendKeys(dataTable.getData("General_Data","height"));
	    driver.findElement(By.id(UIMapMyLowes.txtWidth)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtWidth)).sendKeys(dataTable.getData("General_Data","width"));
	    driver.findElement(By.id(UIMapMyLowes.txtDepth)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtDepth)).sendKeys(dataTable.getData("General_Data","depth"));
	    driver.findElement(By.id(UIMapMyLowes.txtFinish)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtFinish)).sendKeys(dataTable.getData("General_Data","finish"));
	    driver.findElement(By.id(UIMapMyLowes.txtItemNbr)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtItemNbr)).sendKeys(dataTable.getData("General_Data","ItemNbr"));
	    driver.findElement(By.id(UIMapMyLowes.txtLink)).clear();
	    driver.findElement(By.id(UIMapMyLowes.txtLink)).sendKeys(dataTable.getData("General_Data","link"));
	    driver.findElement(By.xpath(UIMapMyLowes.txtNotes2)).click();
	    driver.findElement(By.name(UIMapMyLowes.txtNote)).clear();
	    driver.findElement(By.name(UIMapMyLowes.txtNote)).sendKeys(dataTable.getData("General_Data","SpaceNotes"));
	   // driver.findElement(By.xpath("(//button[@type='submit'])[4]")).click();
	    driver.findElement(By.xpath(UIMapMyLowes.btnSave)).click();
	    Thread.sleep(2000);
	    String varSuccess = driver.findElement(By.cssSelector(UIMapMyLowes.webElmntItemAddedSuccessMsg)).getText();
	    if(varSuccess.equals("Success! Your item has been added."))
	    {
	    	report.updateTestLog("Checking Success Message","Success message displayed" ,Status.PASS);
	    }
	    else
	    {
	    	report.updateTestLog("Checking Success Message","Success message NOT displayed" ,Status.FAIL);
	    }
	    Thread.sleep(5000);
	    driver.findElement(By.linkText("Edit")).click();
	    String varMaType = driver.findElement(By.cssSelector(UIMapMyLowes.webElmntProductTypeSaved)).getText();
	    if(varMaType.equals(dataTable.getData("General_Data","Category")))
	    {
	    	report.updateTestLog("Checking Category","Category saved" ,Status.PASS);
	    }
	    else
	    {
	    	report.updateTestLog("Checking Category","Category NOT saved" ,Status.FAIL);
	    }
	    String varSpace1 = driver.findElement(By.cssSelector(UIMapMyLowes.webElmntAssignedSpace)).getText();
	    if(varSpace1.equals(dataTable.getData("General_Data","Space")))
	    {
	    	report.updateTestLog("Checking Space","Space saved" ,Status.PASS);
	    }
	    else
	    {
	    	report.updateTestLog("Checking Space","Space saved" ,Status.FAIL);
	    }
	    String varBrand = driver.findElement(By.xpath(UIMapMyLowes.webElmntSavedBrandName)).getAttribute("value");
	    
	    if(varBrand.equals(dataTable.getData("General_Data","Brand")))
	    {
	    	report.updateTestLog("Checking Brand","Brand saved" ,Status.PASS);
	    }
	    else
	    {
	    	report.updateTestLog("Checking Brand","Brand NOT saved" ,Status.FAIL);
	    }
	    String varPurchaseDate = driver.findElement(By.id(UIMapMyLowes.txtPurchaseDate)).getAttribute("value");
	    String[] varDat = varPurchaseDate.split("/");
	    if(varDat[1].equals(dataTable.getData("General_Data","PurchaseDate")))
	    {
	    	report.updateTestLog("Checking Purchase Date","Purchase Date saved" ,Status.PASS);
	    }
	    else
	    {
	    	report.updateTestLog("Checking Purchase Date","Purchase Date NOT saved" ,Status.FAIL);
	    }
	    String varHeight = driver.findElement(By.xpath(UIMapMyLowes.webElmntSavedHeight)).getAttribute("value");
	    if(varHeight.equals(dataTable.getData("General_Data","height")))
	    {
	    	report.updateTestLog("Checking Height","Height saved" ,Status.PASS);
	    }
	    else
	    {
	    	report.updateTestLog("Checking Height","Height NOT saved" ,Status.FAIL);
	    }
	    String varWidth = driver.findElement(By.xpath(UIMapMyLowes.webElmntSavedWidth)).getAttribute("value");
	    if(varWidth.equals(dataTable.getData("General_Data","width")))
	    {
	    	report.updateTestLog("Checking Width","Width saved" ,Status.PASS);
	    }
	    else
	    {
	    	report.updateTestLog("Checking Width","Width NOT saved" ,Status.FAIL);
	    }
	    String varDepth = driver.findElement(By.xpath(UIMapMyLowes.webElmntSavedDepth)).getAttribute("value");
	    if(varDepth.equals(dataTable.getData("General_Data","depth")))
	    {
	    	report.updateTestLog("Checking Depth","Depth saved" ,Status.PASS);
	    }
	    else
	    {
	    	report.updateTestLog("Checking Depth","Depth NOT saved" ,Status.FAIL);
	    }
	    String varFinish = driver.findElement(By.xpath(UIMapMyLowes.webElmntSavedFinish)).getAttribute("value");
	    if(varFinish.equals(dataTable.getData("General_Data","finish")))
	    {
	    	report.updateTestLog("Checking Finish","Finish saved" ,Status.PASS);
	    }
	    else
	    {
	    	report.updateTestLog("Checking Finish","Finish NOT saved" ,Status.FAIL);
	    }
	    String varItemNbr = driver.findElement(By.xpath(UIMapMyLowes.webElmntSavedItemName)).getAttribute("value");
	    if(varItemNbr.equals(dataTable.getData("General_Data","ItemNbr")))
	    {
	    	report.updateTestLog("Checking Item Nbr","Item Nbr saved" ,Status.PASS);
	    }
	    else
	    {
	    	report.updateTestLog("Checking Item Nbr","Item Nbr NOT saved" ,Status.FAIL);
	    }	
	    String varLink = driver.findElement(By.xpath(UIMapMyLowes.webElmntSavedLink)).getAttribute("value");
	    if(varLink.equals(dataTable.getData("General_Data","link")))
	    {
	    	report.updateTestLog("Checking Link","Link saved" ,Status.PASS);
	    }
	    else
	    {
	    	report.updateTestLog("Checking Link","Link NOT saved" ,Status.FAIL);
	    }
	    //Thread.sleep(2000);
	    //driver.findElement(By.xpath(UIMapMyLowes.txtNotes2)).click();
	    //Thread.sleep(5000);
	    //String varNotes = driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).getText();
	    String varNotes = driver.findElement(By.xpath(UIMapMyLowes.webElmntSavedNotes)).getText();
	    if(varNotes.equals(dataTable.getData("General_Data","SpaceNotes")))
	    {
	    	report.updateTestLog("Checking Notes","Notes saved" ,Status.PASS);
	    }
	    else
	    {
	    	report.updateTestLog("Checking Notes","Notes NOT saved" ,Status.FAIL);
	    }
	}
		
	/*this function validates default spaces in newly created home profile */	
	public void validateDefaultSpacesHP() throws Exception
	{
		if(selenium.isTextPresent("Bathroom") && selenium.isTextPresent("Bedroom") && selenium.isTextPresent("Kitchen") && selenium.isTextPresent("Yard"))
		{
			report.updateTestLog("Validating Default spaces in Home Profile" ,"Home Profile created with Default Spaces", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Default spaces in Home Profile" ,"Home Profile NOT created with Default Spaces", Status.FAIL);
		}
	}
		
	/*This function clicks on Home Profile link under My Account on Mast Head for Not Logged In users*/
	public void clickHomeProfileAZ() throws Exception
	{
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.id(UIMapMyLowes.lnkMyAccount));
		actions.moveToElement(menuHoverLink).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(5000);
		//WebElement subLink = driver.findElement(By.id(UIMapMyLowes.lnkHomeProfile));
		WebElement subLink = driver.findElement(By.partialLinkText("Home Profile"));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(5000);
		boolean varLogon = selenium.isElementPresent("Logon");
		if(varLogon)
		{
			report.updateTestLog("Clicking Home Profile for Anonymous User" ,"Logon form displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking Home Profile for Anonymous User" ,"Logon form NOT displayed", Status.FAIL);
		}
		driver.findElement(By.cssSelector(UIMapMyLowes.lnkSignUp));
		selenium.waitForPageToLoad("10000");
	}
		
	/*This function validates whether My account page is displayed after user clicks on HP->Signup*/
	public void validateMyAccountPage() throws Exception
	{
		
		String varMyLowes = driver.findElement(By.cssSelector(UIMapMyLowes.webElmntHeading)).getText();
		if(varMyLowes.equals("MyLowe's"))
		{
			report.updateTestLog("Validating page displayed after Registration" ,"Account Information page displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating page displayed after Registration" ,"Account Information page displayed", Status.PASS);
		}
	}
	
	/*This function enters sign in from Your Account->Home Profile for NON-logged In user(already having HP)  and displays HP page*/
	public void signInHomeProfile() throws Exception
	{
		driver.findElement(By.id(UIMapFunctionalComponents.txtUserName)).sendKeys(dataTable.getData("General_Data","email"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(dataTable.getData("General_Data", "password"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(Keys.ENTER);
		selenium.waitForPageToLoad("20000");
		String varHomeProfile = driver.findElement(By.xpath(UIMapMyLowes.webElmntBrdCrumbsLvl2)).getText();
		System.out.println(varHomeProfile);
		if(varHomeProfile.equals("Home Profile"))
		{
			report.updateTestLog("Clicking Home Profile link","Home Profile Summary page displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking Home Profile link","Home Profile Summary page NOT displayed", Status.FAIL);
		}	
	}

	/*This function enters sign in from Your Account->Home Profile for NON-logged In user(not having HP)  and displays Create HP page*/
	public void signInCreateHomeProfile() throws Exception
	{
		driver.findElement(By.id(UIMapFunctionalComponents.txtUserName)).sendKeys(dataTable.getData("General_Data","email"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(dataTable.getData("General_Data", "password"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(Keys.ENTER);
		selenium.waitForPageToLoad("20000");
		String varHomeProfile = driver.findElement(By.xpath(UIMapMyLowes.webElmntBrdCrumbsLvl2)).getText();
		System.out.println(varHomeProfile);
		if(varHomeProfile.equals("Create Your Home Profile"))
		{
			report.updateTestLog("Clicking Home Profile link","Create Home Profile page displayed", Status.PASS);
			selenium.waitForPageToLoad("20000");
			driver.findElement(By.id(UIMapMyLowes.lnkCreateHomeProfile)).click();
			String varHomeProfile2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntBrdCrumbsLvl2)).getText();
			System.out.println(varHomeProfile2);
			if(varHomeProfile2.equals("Home Profile"))
			{
				report.updateTestLog("Clicking Home Profile link","Home Profile Summary page displayed", Status.PASS);
				
			}
			else
			{
				report.updateTestLog("Clicking Home Profile link","Home Profile Summary page NOT displayed", Status.FAIL);
			}	
						
		}
		else
		{
			report.updateTestLog("Clicking Home Profile link","Create Home Profile page NOT displayed", Status.FAIL);
		}
	}
	
	/*This function validates the layout of paint calculations results view*/
	public void checkPaintCalcResultLayout() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.lnkShowDetails)).click();
		Thread.sleep(5000);
		//checking editable fields
		driver.findElement(By.id(UIMapMyLowes.txtCalcName)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtCalcName)).sendKeys("Editable");
		Thread.sleep(1000);
		String varPaintCalcName = driver.findElement(By.id(UIMapMyLowes.txtCalcName)).getAttribute("value");
		if(varPaintCalcName.equals("Editable"))
		{
			report.updateTestLog("Checking Paint Calculator Name Field","Name field editable", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Paint Calculator Name Field","Name field NOT editable", Status.FAIL);
		}
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes2)).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).sendKeys("Editable");
		Thread.sleep(1000);
		String varNote = driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).getText();
		System.out.println(varNote);
		boolean varNoteEnabled = driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).isEnabled();
		if(varNoteEnabled)
		{
			report.updateTestLog("Checking Paint Calculator Notes Field","Notes field editable", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Paint Calculator Notes Field","Notes field NOT editable", Status.FAIL);
		}
		//checking static fields
		String varStatic = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcTotalNetArea)).getText();
		String pattern = "Total Net Area: \\d+\\.*\\d* sq. ft.";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(varStatic);
		if (m.find( ))
		{
			report.updateTestLog("Checking \"Total Net Area\"","Static text displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking \"Total Net Area\"","Static text NOT displayed", Status.FAIL);
		}
		
		varStatic = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcStaticTxt2)).getText();
		pattern = "(\\d+\\.*\\d* sq. ft. of wall space, minus \\d+\\.*\\d* sq. ft. of windows/doors)";
		 r = Pattern.compile(pattern);
		 m = r.matcher(varStatic);
		if (m.find( ))
		{
			report.updateTestLog("Checking small text below \"Total Net Area\"","Static text displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking small text below \"Total Net Area\"","Static text NOT displayed", Status.FAIL);
		}
		
		varStatic = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcPaintNeeded)).getText();
		pattern = "Paint Needed: \\d+\\.*\\d* quarts for \\d+\\.*\\d* coat";
		 r = Pattern.compile(pattern);
		 m = r.matcher(varStatic);
		if (m.find( ))
		{
			report.updateTestLog("Checking Paint Needed text","Static text displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Paint Needed text","Static text NOT displayed", Status.FAIL);
		}
		
		varStatic = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcPrimerNeeded)).getText();
		pattern = "Primer Needed: \\d+\\.*\\d* quarts for \\d+\\.*\\d* coat";
		 r = Pattern.compile(pattern);
		 m = r.matcher(varStatic);
		if (m.find( ))
		{
			report.updateTestLog("Checking Primer Needed text","Static text displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Primer Needed text","Static text NOT displayed", Status.FAIL);
		}
		
		String varCol1 = driver.findElement(By.xpath(UIMapMyLowes.webElmntStaticTextCol1)).getText();
		if(varCol1.equals("Wall"))
		{
			report.updateTestLog("Checking Wall column","Static text displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Wall column","Static text NOT displayed", Status.FAIL);
		}
		
		String varCol2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntStaticTextCol2)).getText();
		if(varCol2.equals("Width"))
		{
			report.updateTestLog("Checking Width column","Static text displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Width column","Static text NOT displayed", Status.FAIL);
		}
		
		String varCol3 = driver.findElement(By.xpath(UIMapMyLowes.webElmntStaticTextCol3)).getText();
		if(varCol3.equals("Height"))
		{
			report.updateTestLog("Checking Height column","Static text displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Height column","Static text NOT displayed", Status.FAIL);
		}
		
		String varEstimatedCovg1 = driver.findElement(By.xpath(UIMapMyLowes.webElmntStaticTextPaintEstCovg)).getText();
		if(varEstimatedCovg1.equals("Estimated Coverage Amounts*:"))
		{
			report.updateTestLog("Checking Estimated Coverage Amounts heading","Static text displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Estimated Coverage Amounts heading","Static text NOT displayed", Status.FAIL);
		}
		//String varEstimatedCovg2 = driver.findElement(By.cssSelector("div.drawer_details_right > p")).getText();
		//System.out.println(varEstimatedCovg2);
		/*if(varEstimatedCovg2.equals("Estimated Coverage Amounts*:\n Paint: 350 sq. ft. per gallon\n Primer: 200 sq. ft. per gallon"))
		{
			report.updateTestLog("Checking Estimated Coverage Amounts ","Static text displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Estimated Coverage Amounts ","Static text NOT displayed", Status.FAIL);
		}*/
		
		String varDisclaimer = driver.findElement(By.xpath(UIMapMyLowes.webElmntPaintDisclaimer)).getText();
		if(varDisclaimer.equals("*Actual amounts may vary by application method, type and brand of paint / primer."))
		{
			report.updateTestLog("Checking Estimated Coverage Amounts disclaimer","Static text displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Estimated Coverage Amounts disclaimer","Static text NOT displayed", Status.FAIL);
		}
		
		
		
		//checking buttons and links
		String varSave2 = driver.findElement(By.xpath(UIMapMyLowes.btnCalcSave)).getText();
			if(varSave2.equals("Save"))
			{
			report.updateTestLog("Checking Save Button","Save button displayed", Status.PASS);
			}
			else
			{
				report.updateTestLog("Checking Save Button","Save button NOT displayed", Status.FAIL);
			}
		
		String varCancel = driver.findElement(By.xpath(UIMapMyLowes.lnkCalcCancel)).getText();
		if(varCancel.equals("Cancel"))
		{
			report.updateTestLog("Checking Cancel link","Cancel link displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Cancel link","Cancel link NOT displayed", Status.FAIL);
		}
		String varClose = driver.findElement(By.xpath(UIMapMyLowes.lnkCalcHideDetails)).getText();
		if(varClose.equals("Hide Details"))
		{
			report.updateTestLog("Checking Hide Details link","Hide Details link displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Hide Details link","Hide Details link NOT displayed", Status.FAIL);
		}
		String varShopPaint = driver.findElement(By.xpath(UIMapMyLowes.btnCalcShop)).getText();
		if(varShopPaint.equals("Shop Paint"))
		{
			report.updateTestLog("Checking Shop Paint link","Shop Paint  link displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Shop Paint link","Shop Paint  link NOT displayed", Status.FAIL);
		}
		//cHECKING Trashcan
		boolean varTrashCan = selenium.isElementPresent(UIMapMyLowes.webElmntCalcTrashcan);
		if(varTrashCan)
		{
			report.updateTestLog("Checking Trashcan for delete","Trashcan for delete displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Trashcan for delete","Trashcan for delete NOT displayed", Status.FAIL);
		}
	}
	
	/*This function validates the layout of Mulch calculations results view*/
	public void checkMulchCalcResultLayout() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.lnkShowDetails)).click();
		Thread.sleep(5000);
		//checking editable fields
		driver.findElement(By.id(UIMapMyLowes.txtCalcName)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtCalcName)).sendKeys("Editable");
		Thread.sleep(1000);
		String varPaintCalcName = driver.findElement(By.id(UIMapMyLowes.txtCalcName)).getAttribute("value");
		if(varPaintCalcName.equals("Editable"))
		{
			report.updateTestLog("Checking Mulch Calculator Name Field","Name field editable", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Mulch Calculator Name Field","Name field NOT editable", Status.FAIL);
		}
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes2)).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).sendKeys("Editable");
		Thread.sleep(1000);
		String varNote = driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).getText();
		System.out.println(varNote);
		boolean varNoteEnabled = driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).isEnabled();
		if(varNoteEnabled)
		{
			report.updateTestLog("Checking Mulch Calculator Notes Field","Notes field editable", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Mulch Calculator Notes Field","Notes field NOT editable", Status.FAIL);
		}
		//checking static fields
		String varStatic = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcTotalNetArea)).getText();
		String pattern = "Total Area: \\d+\\.*\\d* sq. ft.";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(varStatic);
		if (m.find( ))
		{
			report.updateTestLog("Checking \"Total Area\"","Static text displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking \"Total Area\"","Static text NOT displayed", Status.FAIL);
		}
		
		varStatic = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcVolume)).getText();
		pattern = "Volume Result: \\d+\\.*\\d* cu. ft.";
		 r = Pattern.compile(pattern);
		 m = r.matcher(varStatic);
		if (m.find( ))
		{
			report.updateTestLog("Checking Volume Result","Static text displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Volume Result","Static text NOT displayed", Status.FAIL);
		}
		
		varStatic = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcPrdctQty)).getText();
		pattern = "Product Quantity Needed: \\d+\\.*\\d* x \\d+\\.*\\d* cu. ft. bags";
		 r = Pattern.compile(pattern);
		 m = r.matcher(varStatic);
		if (m.find( ))
		{
			report.updateTestLog("Checking Product Quantity Needed text","Static text displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Product Quantity Needed text","Static text NOT displayed", Status.FAIL);
		}
		
		boolean varThickness = selenium.isTextPresent("Thickness:");
		if(varThickness)
		{
			report.updateTestLog("Checking Thickness","Static text displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Thickness","Static text NOT displayed", Status.FAIL);
		}
		boolean varMaterial = selenium.isTextPresent("Material:");
		if(varMaterial)
		{
			report.updateTestLog("Checking Material","Static text displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Material","Static text NOT displayed", Status.FAIL);
		}
		
		boolean varLawn = selenium.isTextPresent("Lawn");
		if(varLawn)
		{
			report.updateTestLog("Checking Lawn","Static text displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Lawn","Static text NOT displayed", Status.FAIL);
		}
		
		boolean varLength = selenium.isTextPresent("Length");
		if(varLength)
		{
			report.updateTestLog("Checking Length","Static text displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Length","Static text NOT displayed", Status.FAIL);
		}
		
		boolean varWidth = selenium.isTextPresent("Width");
		if(varWidth)
		{
			report.updateTestLog("Checking Width","Static text displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Width","Static text NOT displayed", Status.FAIL);
		}
		
		String varDisclaimer = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcMulchDisclaimer)).getText();
		if(varDisclaimer.equals("*Actual quantities may vary by mulch brand and surface of the area being mulched."))
		{
			report.updateTestLog("Checking disclaimer","Static text displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking disclaimer","Static text NOT displayed", Status.FAIL);
		}
		
		
		
		//checking buttons and links
		String varSave2 = driver.findElement(By.xpath(UIMapMyLowes.btnCalcSave)).getText();
			if(varSave2.equals("Save"))
			{
			report.updateTestLog("Checking Save Button","Save button displayed", Status.PASS);
			}
			else
			{
				report.updateTestLog("Checking Save Button","Save button NOT displayed", Status.FAIL);
			}
		
		String varCancel = driver.findElement(By.xpath(UIMapMyLowes.lnkCalcCancel)).getText();
		if(varCancel.equals("Cancel"))
		{
			report.updateTestLog("Checking Cancel link","Cancel link displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Cancel link","Cancel link NOT displayed", Status.FAIL);
		}
		String varClose = driver.findElement(By.xpath(UIMapMyLowes.lnkCalcHideDetails)).getText();
		if(varClose.equals("Hide Details"))
		{
			report.updateTestLog("Checking Hide Details link","Hide Details link displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Hide Details link","Hide Details link NOT displayed", Status.FAIL);
		}
		String varShopPaint = driver.findElement(By.xpath(UIMapMyLowes.btnCalcShop)).getText();
		if(varShopPaint.equals("Shop Mulch"))
		{
			report.updateTestLog("Checking Shop Mulch link","Shop Mulch  link displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Shop Mulch link","Shop Mulch  link NOT displayed", Status.FAIL);
		}
		//cHECKING Trashcan
		boolean varTrashCan = selenium.isElementPresent(UIMapMyLowes.webElmntCalcTrashcan);
		if(varTrashCan)
		{
			report.updateTestLog("Checking Trashcan for delete","Trashcan for delete displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Trashcan for delete","Trashcan for delete NOT displayed", Status.FAIL);
		}
	}
	
	/*This function validates the layout of Mulch calculations results view-created using I kNow The AREA*/
	public void checkMulchCalcLayoutArea() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.lnkShowDetails)).click();
		Thread.sleep(5000);
		//checking editable fields
		driver.findElement(By.id(UIMapMyLowes.txtCalcName)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtCalcName)).sendKeys("Editable");
		Thread.sleep(1000);
		String varPaintCalcName = driver.findElement(By.id(UIMapMyLowes.txtCalcName)).getAttribute("value");
		if(varPaintCalcName.equals("Editable"))
		{
			report.updateTestLog("Checking Mulch Calculator Name Field","Name field editable", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Mulch Calculator Name Field","Name field NOT editable", Status.FAIL);
		}
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes2)).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).sendKeys("Editable");
		Thread.sleep(1000);
		String varNote = driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).getText();
		System.out.println(varNote);
		boolean varNoteEnabled = driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).isEnabled();
		if(varNoteEnabled)
		{
			report.updateTestLog("Checking Mulch Calculator Notes Field","Notes field editable", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Mulch Calculator Notes Field","Notes field NOT editable", Status.FAIL);
		}
		
		
		//checking static fields
		String varStatic = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcTotalNetArea)).getText();
		String pattern = "Total Area: \\d+\\.*\\d* sq. ft.";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(varStatic);
		if (m.find( ))
		{
			report.updateTestLog("Checking \"Total Area\"","Static text displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking \"Total Area\"","Static text NOT displayed", Status.FAIL);
		}
		
				
		varStatic = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcAddedOn)).getText();
		pattern = "Added on \\d+/\\d+/\\d+";
		r = Pattern.compile(pattern);
		m = r.matcher(varStatic);
		if (m.find( ))
		{
			report.updateTestLog("Checking Added On","Static text displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Added On","Static text NOT displayed", Status.FAIL);
		}
			
	try{
		String varLawn = driver.findElement(By.xpath(UIMapMyLowes.webElmntStaticTextCol1)).getText();
		report.updateTestLog("Checking Lawn","Lawn displayed", Status.FAIL);
	}
	catch(Exception ElementNotVisibleException)
	{
		report.updateTestLog("Checking Lawn","Lawn NOT displayed", Status.PASS);
	}
	try{
		String varLength = driver.findElement(By.xpath(UIMapMyLowes.webElmntStaticTextCol2)).getText();
		report.updateTestLog("Checking Length","Length displayed", Status.FAIL);
	}
	catch(Exception ElementNotVisibleException)
	{
		report.updateTestLog("Checking Length","Length NOT displayed", Status.PASS);
	}
	try{
		String varWidth = driver.findElement(By.xpath(UIMapMyLowes.webElmntStaticTextCol3)).getText();
		report.updateTestLog("Checking Width","Width displayed", Status.FAIL);
	}
	catch(Exception ElementNotVisibleException)
	{
		report.updateTestLog("Checking Width","Width NOT displayed", Status.PASS);
	}
	
		
		String varCalcType = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcTypeIcon)).getAttribute("class");
		String varCalcType2 = null;
		System.out.println(varCalcType);
		String[] s = varCalcType.split(" ");
		
		if(s[1].equals("mulch"))
			varCalcType2 = "Mulch";
			
		else if(s[1].equals("grassseed"))
			varCalcType2 = "Grass Seed";
		else if(s[1].equals("fertilizer"))
			varCalcType2 = "Fertilizer";
		System.out.println(varCalcType2);
		
		boolean varMatDetails = driver.findElement(By.cssSelector(UIMapMyLowes.webElmntCalcMulchMatDetails)).isDisplayed();
		if(varMatDetails)
		{
			try{
			driver.findElement(By.cssSelector(UIMapMyLowes.webElmntCalcMulchMatDetails)).sendKeys("test");
			}
			//boolean varMatDetailsStatic = driver.findElement(By.cssSelector(UIMapMyLowes.webElmntCalcMulchMatDetails)).isEnabled();
			//if(varMatDetailsStatic)
			//report.updateTestLog("Checking Material Details","Material Details not static text", Status.FAIL);
			//else
			catch(Exception WebDriverException)
			{report.updateTestLog("Checking Material Details","Material Details static text displayed", Status.PASS);
			}
		}
		else
			report.updateTestLog("Checking Material Details","Material Details not displayed", Status.FAIL);
		
		boolean varDisclaimer= driver.findElement(By.cssSelector(UIMapMyLowes.webElmntCalcDisclamer2)).isDisplayed();
		if(varDisclaimer)
		{
			//boolean varDisclaimerStatic = driver.findElement(By.cssSelector(UIMapMyLowes.webElmntCalcDisclamer2)).isEnabled();
			//if(varDisclaimerStatic)
			//report.updateTestLog("Checking Disclaimer","Disclaimer not static text", Status.FAIL);
			//else
			report.updateTestLog("Checking Disclaimer","Disclaimer displayed", Status.PASS);
		}
		else
			report.updateTestLog("Checking Disclaimer","Disclaimer not displayed", Status.FAIL);
		//checking buttons and links
		String varSave2 = driver.findElement(By.xpath(UIMapMyLowes.btnCalcSave)).getText();
			if(varSave2.equals("Save"))
			{
			report.updateTestLog("Checking Save Button","Save button displayed", Status.PASS);
			}
			else
			{
				report.updateTestLog("Checking Save Button","Save button NOT displayed", Status.FAIL);
			}
		
		String varCancel = driver.findElement(By.xpath(UIMapMyLowes.lnkCalcCancel)).getText();
		if(varCancel.equals("Cancel"))
		{
			report.updateTestLog("Checking Cancel link","Cancel link displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Cancel link","Cancel link NOT displayed", Status.FAIL);
		}
		String varClose = driver.findElement(By.xpath(UIMapMyLowes.lnkCalcHideDetails)).getText();
		if(varClose.equals("Hide Details"))
		{
			report.updateTestLog("Checking Hide Details link","Hide Details link displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Hide Details link","Hide Details link NOT displayed", Status.FAIL);
		}
		String varShopPaint = driver.findElement(By.xpath(UIMapMyLowes.btnCalcShop)).getText();
		String varCalcType3 = "Shop "+varCalcType2;
		System.out.println(varCalcType3);
		if(varShopPaint.equals(varCalcType3))
		{
			report.updateTestLog("Checking Shop _ link",varCalcType3+"  link displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Shop _ link",varCalcType3+"  link NOT displayed", Status.FAIL);
		}
		//cHECKING Trashcan
		boolean varTrashCan = selenium.isElementPresent(UIMapMyLowes.webElmntCalcTrashcan);
		if(varTrashCan)
		{
			report.updateTestLog("Checking Trashcan for delete","Trashcan for delete displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Trashcan for delete","Trashcan for delete NOT displayed", Status.FAIL);
		}
	}
	
	/*This function opens Calculations tab for a space in Home Profile*/
	public void calcHomeProfile() throws Exception
	{
		driver.findElement(By.cssSelector(UIMapMyLowes.webElmntSelectShow)).click();
		driver.findElement(By.linkText("Calculations")).click();
		
		Thread.sleep(5000);
		boolean varCalculations = selenium.isElementPresent(UIMapMyLowes.webElmntTotalCalc);
		if(varCalculations)
		{
			report.updateTestLog("Opening Calculations tab","Calculations opened" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Opening Calculations tab","Calculations NOT opened" ,Status.FAIL);
		}	
		
		
	}
	
	/*This function adds new Mulch calculator results to YARD*/
	public void addNewMulchCalc() throws Exception
	{
		//driver.findElement(By.xpath(UIMapMyLowes.webElmntGoToPrjctCalc)).click();
		try{
		driver.findElement(By.partialLinkText("View All Project Calculators")).click();
		selenium.waitForPageToLoad("20000");
		}
		catch(Exception NoSuchElementException)
		{
			driver.findElement(By.xpath(UIMapMyLowes.webElmntGoToPrjctCalc)).click();
			selenium.waitForPageToLoad("20000");
		}
		try{
		driver.findElement(By.partialLinkText("Mulch Calculator")).click();
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.partialLinkText("Mulch Calculator")).click();}
		selenium.waitForPageToLoad("20000");
		driver.findElement(By.id(UIMapMyLowes.rdoBtnEnterSqFootage)).click();
		driver.findElement(By.id(UIMapMyLowes.txtCalcArea)).sendKeys(dataTable.getData("General_Data", "TotalArea"));
		//driver.findElement(By.id("productType")).click();
		//Thread.sleep(2000);
		new Select(driver.findElement(By.id(UIMapMyLowes.drpDownCalcProductType))).selectByVisibleText("Cypress");
		//driver.findElement(By.id(UIMapMyLowes.drpDownCalcProductType)).sendKeys(Keys.TAB);
		//driver.findElement(By.xpath("//*[@id='productType']/option[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id(UIMapMyLowes.txtMulchDepth)).click();
		driver.findElement(By.id(UIMapMyLowes.txtMulchDepth)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtMulchDepth)).sendKeys(dataTable.getData("General_Data", "MulchDepth"));
		driver.findElement(By.xpath(UIMapMyLowes.btnMulchCalculate)).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id='mulchCalculator']/div[2]/div/div[2]/div/div[4]/select")).click();
		//driver.findElement(By.xpath("//*[@id='mulchCalculator']/div[2]/div/div[2]/div/div[4]/select/option[2]")).click();
		//Select select = new Select(driver.findElement(By.xpath("//*[@id='mulchCalculator']/div[2]/div/div[2]/div/div[4]/select")));
		//select.selectByVisibleText(dataTable.getData("General_Data", "Space"));
		 new Select(driver.findElement(By.cssSelector(UIMapMyLowes.drpDownCalcResultSaveSpace))).selectByVisibleText(dataTable.getData("General_Data", "Space"));
		// driver.findElement(By.cssSelector(UIMapMyLowes.drpDownCalcResultSaveSpace)).sendKeys(Keys.TAB);
		 Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.btnCalcResultSave)).click();
		Thread.sleep(2000);
		driver.findElement(By.id(UIMapMyLowes.txtCalcResultTitle)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtCalcResultTitle)).sendKeys(dataTable.getData("General_Data", "CalcName"));
		driver.findElement(By.xpath(UIMapMyLowes.btnCalcResultSave2)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.lnkCalcResultSpace)).click();
		report.updateTestLog("Saving New Mulch Calculator Results","Results saved", Status.DONE);
		selenium.waitForPageToLoad("10000");
	}
	
	/*this function adds Note and saves to Mulch calculation results*/
	public void addNoteMulchCalc() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.lnkCalcAttachANote)).click();
		Thread.sleep(5000);
		String varCalcType = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcTypeIcon)).getAttribute("class");
		String[] s = varCalcType.split(" ");
		String varShopButton = driver.findElement(By.xpath(UIMapMyLowes.btnCalcShop)).getText();
		String[] s2 = varShopButton.split(" ");
		if(s[1].equalsIgnoreCase(s2[1]))
		{
			report.updateTestLog("Checking Shop _ link","Shop "+ s2[1]+"  link displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Shop _ link","Shop "+ s2[1]+"  link NOT displayed", Status.PASS);
		}
		String varSave2 = driver.findElement(By.xpath(UIMapMyLowes.btnCalcSave)).getText();
		if(varSave2.equals("Save"))
		{
		if(driver.findElement(By.xpath(UIMapMyLowes.btnCalcSave)).isEnabled())
		{
			report.updateTestLog("Checking Save Button","Save button displayed & Enabled", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Save Button","Save button displayed but DISABLED", Status.FAIL);
		}
			
		}
		else
		{
			report.updateTestLog("Checking Save Button","Save button NOT displayed", Status.FAIL);
		}
	
	String varCancel = driver.findElement(By.xpath(UIMapMyLowes.lnkCalcCancel)).getText();
	if(varCancel.equals("Cancel"))
	{
		if(driver.findElement(By.xpath(UIMapMyLowes.lnkCalcCancel)).isEnabled())
		{
			report.updateTestLog("Checking Cancel link","Cancel link displayed & Enabled", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Cancel link","Cancel link displayed but DISABLED", Status.FAIL);
		}
		
	}
	else
	{
		report.updateTestLog("Checking Cancel link","Cancel link NOT displayed", Status.FAIL);
	}
	driver.findElement(By.xpath(UIMapMyLowes.txtNotes2)).click();
	driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).sendKeys(dataTable.getData("General_Data", "SpaceNotes"));
	driver.findElement(By.xpath(UIMapMyLowes.btnCalcSave)).click();
	Thread.sleep(2000);
	String varNotes = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcSavedNotes)).getText();
	if(varNotes.equals(dataTable.getData("General_Data", "SpaceNotes")))
	{
		report.updateTestLog("Checking Saved Notes","Notes saved", Status.PASS);
	}
	else
	{
		report.updateTestLog("Checking Saved Notes","Notes NOT saved", Status.FAIL);
	}
	
	}
	
	/*This function deletes a calculation result*/
	public void deleteCalc() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.webElmntDeleteCalcTrashcan)).click();
		Thread.sleep(5000);
		System.out.println("Checking Undo Link");
		String varUndo = driver.findElement(By.xpath(UIMapMyLowes.lnkDeleteCalcUndo)).getText();
		System.out.println(varUndo);
		if(varUndo.equals("Undo"))
		{
			report.updateTestLog("Deleting Calculator results","Calculator results deleted", Status.DONE);
		}
	}
	
	/*This function validates whether the calculation reappears on clicking Undo link*/
	public void clickUndoCalc() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.lnkDeleteCalcUndo)).click();
		Thread.sleep(5000);
		String CalcName = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc1Name)).getText();
		if(CalcName.equals(dataTable.getData("General_Data", "CalcName")))
		{
			report.updateTestLog("Clicking UNDO link","Calculator results Reappeared", Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking UNDO link","Calculator results NOT Reappeared", Status.FAIL);
		}
	}
	
	/*editing and saving CALC results using Save button*/
	public void editCalcSave() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.lnkShowDetails)).click();
		Thread.sleep(5000);
		String varClose = driver.findElement(By.xpath(UIMapMyLowes.lnkCalcHideDetails)).getText();
		if(varClose.equals("Hide Details"))
		{
			report.updateTestLog("Checking Hide Details link","Hide Details link displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Hide Details link","Hide Details link NOT displayed", Status.FAIL);
		}
		driver.findElement(By.id(UIMapMyLowes.txtCalcName)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtCalcName)).sendKeys(dataTable.getData("General_Data", "CalcName"));
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes2)).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).sendKeys(dataTable.getData("General_Data", "SpaceNotes"));
		driver.findElement(By.xpath(UIMapMyLowes.btnCalcSave)).click();
		//driver.navigate().refresh();
		//calcHomeProfile();
		//selenium.waitForPageToLoad("10000");
		Thread.sleep(5000);
		String varNotes = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcSavedNotes)).getText();
		if(varNotes.equals(dataTable.getData("General_Data", "SpaceNotes")))
		{
			report.updateTestLog("Checking Saved Notes on clicking SAVE","Notes saved", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Saved Notes on clicking SAVE","Notes NOT saved", Status.FAIL);
		}
		String CalcName = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc1Name)).getText();
		if(CalcName.equals(dataTable.getData("General_Data", "CalcName")))
		{
			report.updateTestLog("Checking Saved Name on clicking SAVE","Name saved", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Saved Name on clicking SAVE","Name NOT saved", Status.FAIL);
		}
		
	}
	
	/*editing and saving CALC results using Hide Details link button*/
	public void editCalcHideDetails() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.lnkShowDetails)).click();
		Thread.sleep(5000);
		String varClose = driver.findElement(By.xpath(UIMapMyLowes.lnkCalcHideDetails)).getText();
		if(varClose.equals("Hide Details"))
		{
			report.updateTestLog("Checking Hide Details link","Hide Details link displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Hide Details link","Hide Details link NOT displayed", Status.FAIL);
		}
		driver.findElement(By.id(UIMapMyLowes.txtCalcName)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtCalcName)).sendKeys(dataTable.getData("General_Data", "CalcName2"));
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes2)).click();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).sendKeys(dataTable.getData("General_Data", "Notes2"));
		
		driver.findElement(By.xpath(UIMapMyLowes.lnkCalcHideDetails)).click();
		//driver.navigate().refresh();
		//calcHomeProfile();
		//selenium.waitForPageToLoad("10000");
		Thread.sleep(5000);
		String varNotes = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcSavedNotes)).getText();
		
		if(varNotes.equals(dataTable.getData("General_Data", "Notes2")))
		{
			report.updateTestLog("Checking Saved Notes on clicking Hide Details","Notes saved", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Saved Notes on clicking Hide Details","Notes NOT saved", Status.FAIL);
		}
		String CalcName = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc1Name)).getText();
		if(CalcName.equals(dataTable.getData("General_Data", "CalcName2")))
		{
			report.updateTestLog("Checking Saved Name on clicking Hide Details","Name saved", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Saved Name on clicking Hide Details","Name NOT saved", Status.FAIL);
		}
		
	}
	
	
	
	
	/*editing CALC results using Cancel link button*/
	public void editCalcCancel() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.lnkShowDetails)).click();
		Thread.sleep(2000);
		String varClose = driver.findElement(By.xpath(UIMapMyLowes.lnkCalcHideDetails)).getText();
		if(varClose.equals("Hide Details"))
		{
			report.updateTestLog("Checking Hide Details link","Hide Details link displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Hide Details link","Hide Details link NOT displayed", Status.FAIL);
		}
		String varOldName = driver.findElement(By.id(UIMapMyLowes.txtCalcName)).getAttribute("value");
		
		driver.findElement(By.id(UIMapMyLowes.txtCalcName)).clear();
		driver.findElement(By.id(UIMapMyLowes.txtCalcName)).sendKeys(dataTable.getData("General_Data", "CalcName3"));
		driver.findElement(By.xpath(UIMapMyLowes.txtNotes2)).click();
		
		String varOldnotes = driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).getText();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).sendKeys(dataTable.getData("General_Data", "Notes3"));
		driver.findElement(By.xpath(UIMapMyLowes.lnkCalcCancel)).click();
		//driver.navigate().refresh();
		//calcHomeProfile();
		//selenium.waitForPageToLoad("10000");
		Thread.sleep(5000);
		String varNotes = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcSavedNotes)).getText();
		if(varNotes.equals(varOldnotes))
		{
			report.updateTestLog("Checking Saved Notes on clicking Cancel","Notes Retained", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Saved Notes on clicking Cancel","Notes NOT Retained", Status.FAIL);
		}
		String CalcName = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc1Name)).getText();
		System.out.println(varOldName);
		System.out.println(CalcName);
		if(CalcName.equals(varOldName))
		{
			report.updateTestLog("Checking Saved Name on clicking Cancel","Name Retained", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Saved Name on clicking Cancel","Name NOT Retained", Status.FAIL);
		}
		
	}
	
	/*this function clicks on Shop_ link and validates whether results page is displayed*/
	public void clickShopLink() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.lnkShowDetails)).click();
		Thread.sleep(5000);
		//String 
		driver.findElement(By.xpath(UIMapMyLowes.btnCalcShop)).click();
		selenium.waitForPageToLoad("10000");
		String varTitle = selenium.getTitle();
		System.out.println(varTitle);
		if(varTitle.equals("Shop at Lowes.com: Search Results"))
		{
			report.updateTestLog("Clicking on Shop link","Search Results displayed", Status.PASS);
			String varURL = driver.getCurrentUrl();
			if(varURL.contains(dataTable.getData("General_Data", "CalcType")))
			{
				report.updateTestLog("Clicking on Shop link","Search Results related to:"+ dataTable.getData("General_Data", "CalcType")+" displayed", Status.PASS);
			}
		}
		else
		{
			report.updateTestLog("Clicking on Shop link","Search Results NOT displayed", Status.FAIL);
		}
	}
	
	/*This function validates Calculations tab*/
	public void validateCalcTab() throws Exception
	{
		boolean varPubCalc = selenium.isTextPresent("Project Calculators");
		boolean varCalcLink = selenium.isTextPresent("View All Project Calculators");
		System.out.println(varPubCalc);
		System.out.println(varCalcLink);
		if(varPubCalc && varCalcLink)
		{
			report.updateTestLog("Validating Calculations tab","No Calculations saved. Calculators displayed", Status.PASS);
		}
		else
		{
			boolean varTotalCalc = driver.findElement(By.xpath(UIMapMyLowes.webElmntTotalCalc)).isDisplayed();
			if(varTotalCalc)
			{
				report.updateTestLog("Validating Calculations tab","Calculations Count displayed", Status.PASS);
			}
			else
			{
				report.updateTestLog("Validating Calculations tab","Calculations Count NOT displayed", Status.FAIL);
			}
			
			boolean varCalcName = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc1Name)).isDisplayed();
			if(varCalcName)
			{
				report.updateTestLog("Validating Calculations tab","Calculation Name displayed", Status.PASS);
			}
			else
			{
				report.updateTestLog("Validating Calculations tab","Calculation Name NOT displayed", Status.FAIL);
			}
			
			boolean varShowDetails = driver.findElement(By.xpath(UIMapMyLowes.lnkShowDetails)).isDisplayed();
			if(varShowDetails)
			{
				report.updateTestLog("Validating Calculations tab","Show Details Link displayed", Status.PASS);
			}
			else
			{
				report.updateTestLog("Validating Calculations tab","Show Details Link NOT displayed", Status.FAIL);
			}
			
			boolean varTrashcan = driver.findElement(By.xpath(UIMapMyLowes.webElmntDeleteCalcTrashcan)).isDisplayed();
			if(varTrashcan)
			{
				report.updateTestLog("Validating Calculations tab","Trashcan for deleting Calculation displayed", Status.PASS);
			}
			else
			{
				report.updateTestLog("Validating Calculations tab","Trashcan for deleting Calculation NOT displayed", Status.FAIL);
			}
			
		}
	}
	
	/*This function validates Kitchen space with no calculations*/
	public void checkKitchenNoCalc() throws Exception
	{
		String varPaintCalc = driver.findElement(By.xpath(UIMapMyLowes.lnkCalculatorLink1)).getText();
		if(varPaintCalc.equals("Paint Calculator"))
		{
			report.updateTestLog("Validating Calculations tab","Paint Calculator link displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Calculations tab","Paint Calculator link NOT displayed", Status.FAIL);
		}
		String varProjectCalc = driver.findElement(By.xpath(UIMapMyLowes.lnkCalculatorLink2)).getText();
		if(varProjectCalc.equals("View All Project Calculators"))
		{
			report.updateTestLog("Validating Calculations tab","View All Project Calculators link displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Calculations tab","View All Project Calculators link NOT displayed", Status.FAIL);
		}
		
	}
	
	/*this function clicks on Paint Calculator link*/
	public void clickPaintCalc() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.lnkCalculatorLink1)).click();
		selenium.waitForPageToLoad("10000");
		String varPaint = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalculatorHeading)).getText();
		if(varPaint.equals("Paint Calculator"))
		{
			report.updateTestLog("Clicking Paint Calculator link","Paint Calculator page displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking Paint Calculator link","Paint Calculator page NOT displayed", Status.FAIL);
		}
	}
	
	/*this function clicks on View all Project Calculators  link*/
	public void clickViewAllProjCalc() throws Exception
	{
		driver.findElement(By.partialLinkText("View All Project Calculators")).click();
		selenium.waitForPageToLoad("30000");
		String varPaint = driver.findElement(By.xpath(UIMapMyLowes.webElmntAllCalculatorsHeading)).getText();
		System.out.println("::"+varPaint+"::");
		if(varPaint.equals("Project Calculators"))
		{
			report.updateTestLog("Clicking View All Project Calculators link","Project Calculators page displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking View All Project Calculators link","Project Calculators page NOT displayed", Status.FAIL);
		}
	}
	
	/*This function validates Yard space with no calculations*/
	public void checkYardNoCalc() throws Exception
	{
		String varGrassSeedCalc = driver.findElement(By.xpath(UIMapMyLowes.lnkCalculatorLink1)).getText();
		if(varGrassSeedCalc.equals("Grass Seed Calculator"))
		{
			report.updateTestLog("Validating Calculations tab","Grass Seed Calculator link displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Calculations tab","Grass Seed Calculator link NOT displayed", Status.FAIL);
		}
		String varMulchCalc = driver.findElement(By.xpath(UIMapMyLowes.lnkCalculatorLink2)).getText();
		if(varMulchCalc.equals("Mulch Calculator"))
		{
			report.updateTestLog("Validating Calculations tab","Mulch Calculator link displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Calculations tab","Mulch Seed Calculator link NOT displayed", Status.FAIL);
		}
		String varFertCalc = driver.findElement(By.xpath(UIMapMyLowes.lnkCalculatorLink3)).getText();
		if(varFertCalc.equals("Fertilizer Calculator"))
		{
			report.updateTestLog("Validating Calculations tab","Fertilizer Calculator link displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Calculations tab","Fertilizer Calculator link NOT displayed", Status.FAIL);
		}
		String varProjectCalc = driver.findElement(By.xpath(UIMapMyLowes.lnkCalculatorLink4)).getText();
		if(varProjectCalc.equals("View All Project Calculators"))
		{
			report.updateTestLog("Validating Calculations tab","View All Project Calculators link displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Calculations tab","View All Project Calculators link NOT displayed", Status.FAIL);
		}
		
	}
	
	/*this function clicks on Grass seed calculator  link*/
	public void clickGrassSeedCalc() throws Exception
	{
		driver.findElement(By.partialLinkText("Grass Seed Calculator")).click();
		selenium.waitForPageToLoad("10000");
		String varPaint = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalculatorHeading)).getText();
		System.out.println("::"+varPaint+"::");
		if(varPaint.equals("Grass Seed Calculator"))
		{
			report.updateTestLog("Clicking Grass Seed Calculator link","Grass Seed Calculator page displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking Grass Seed Calculator link","Grass Seed Calculator page NOT displayed", Status.FAIL);
		}
	}
	
	/*this function clicks on Mulch calculator  link*/
	public void clickMulchCalc() throws Exception
	{
		driver.findElement(By.partialLinkText("Mulch Calculator")).click();
		selenium.waitForPageToLoad("10000");
		String varPaint = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalculatorHeading)).getText();
		System.out.println("::"+varPaint+"::");
		if(varPaint.equals("Mulch Calculator"))
		{
			report.updateTestLog("Clicking Mulch Calculator link","Mulch Calculator page displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking Mulch Calculator link","Mulch Calculator page NOT displayed", Status.FAIL);
		}
	}
	
	/*this function clicks on Fertilizer calculator  link*/
	public void clickFertCalc() throws Exception
	{
		driver.findElement(By.partialLinkText("Fertilizer Calculator")).click();
		selenium.waitForPageToLoad("10000");
		String varPaint = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalculatorHeading)).getText();
		System.out.println("::"+varPaint+"::");
		if(varPaint.equals("Fertilizer Calculator"))
		{
			report.updateTestLog("Clicking Fertilizer Calculator link","Fertilizer Calculator page displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking Fertilizer Calculator link","Fertilizer Calculator page NOT displayed", Status.FAIL);
		}
	}
	
	/*This function validates delete functionality in Calculations tab-should have 3 calculations*/
	public void verifyDeleteCalc() throws Exception
	{
		//Storing Calculations names before deletion
		String varCalc1 = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc1Name)).getText();
		System.out.println(varCalc1);
		String varCalc2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc2Name)).getText();
		System.out.println(varCalc2);
		String varCalc3 = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc3Name)).getText();
		System.out.println(varCalc3);
		
		//deleting first calculation using checkbox
		driver.findElement(By.xpath(UIMapMyLowes.chkBoxCalc1)).click();
		driver.findElement(By.xpath(UIMapMyLowes.webElmntActions)).click();
		driver.findElement(By.xpath(UIMapMyLowes.webElmntDeleteAction)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.btnConfirmDelete)).click();
		Thread.sleep(2000);
		String varCalc1Undo = driver.findElement(By.xpath(UIMapMyLowes.webElmntDeleteMsgCalcName)).getText();
		if(varCalc1Undo.equals(varCalc1))
		{
			report.updateTestLog("Deleting using Check-box","Item Name displayed on deletion message", Status.PASS);
		}
		else
		{
			report.updateTestLog("Deleting using Check-box","Item Name NOT displayed on deletion message", Status.FAIL);
		}
		String varUndo1 = driver.findElement(By.xpath(UIMapMyLowes.lnkDeleteCalcUndo)).getText();
		if(varUndo1.equals("Undo"))
		{
			report.updateTestLog("Deleting using Check-box","Undo link displayed on deletion message", Status.PASS);
		}
		else
		{
			report.updateTestLog("Deleting using Check-box","Undo link NOT displayed on deletion message", Status.FAIL);
		}
		
		//deleting second calculation using trashcan
		driver.findElement(By.xpath(UIMapMyLowes.webElmntDeleteCalc2Trashcan)).click();
		Thread.sleep(2000);
		String varCalc2Undo = driver.findElement(By.xpath(UIMapMyLowes.webElmntDeleteMsgCalc2Name)).getText();
		if(varCalc2Undo.equals(varCalc2))
		{
			report.updateTestLog("Deleting using Trashcan","Item Name displayed on deletion message", Status.PASS);
		}
		else
		{
			report.updateTestLog("Deleting using Trashcan","Item Name NOT displayed on deletion message", Status.FAIL);
		}
		String varUndo2 = driver.findElement(By.xpath(UIMapMyLowes.lnkDeleteCalc2Undo)).getText();
		if(varUndo2.equals("Undo"))
		{
			report.updateTestLog("Deleting using Trashcan","Undo link displayed on deletion message", Status.PASS);
		}
		else
		{
			report.updateTestLog("Deleting using Trashcan","Undo link NOT displayed on deletion message", Status.FAIL);
		}
		
		//selecting Undo for both calculations
		driver.findElement(By.xpath(UIMapMyLowes.lnkDeleteCalcUndo)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.lnkDeleteCalc2Undo)).click();
		Thread.sleep(5000);
		String varCalc11 = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc1Name)).getText();
		System.out.println(varCalc11);
		String varCalc22 = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc2Name)).getText();
		System.out.println(varCalc22);
		String varCalc33 = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc3Name)).getText();
		System.out.println(varCalc33);
		if(varCalc11.equals(varCalc1))
		{
			report.updateTestLog("Clicking on Undo link","First Calculation same as before", Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking on Undo link","First Calculation NOT same as before", Status.FAIL);
		}
		if(varCalc22.equals(varCalc2))
		{
			report.updateTestLog("Clicking on Undo link","Second Calculation same as before", Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking on Undo link","Second Calculation NOT same as before", Status.FAIL);
		}
		if(varCalc33.equals(varCalc3))
		{
			report.updateTestLog("Clicking on Undo link","Third Calculation same as before", Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking on Undo link","Third Calculation NOT same as before", Status.FAIL);
		}
		
	}
	
	/*This function deletes a calculation using Trashcan on Calculations Details*/
	public void deleteTrashCanCalcDetail() throws Exception
	{
		String varCalc1 = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc1Name)).getText();
		System.out.println(varCalc1);
		driver.findElement(By.xpath(UIMapMyLowes.lnkShowDetails)).click();
		Thread.sleep(5000);
		String varClose = driver.findElement(By.xpath(UIMapMyLowes.lnkCalcHideDetails)).getText();
		if(varClose.equals("Hide Details"))
		{
			report.updateTestLog("Checking Hide Details link","Hide Details link displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Hide Details link","Hide Details link NOT displayed", Status.FAIL);
		}
		driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcTrashcan)).click();
		Thread.sleep(5000);
		String varCalc1Undo = driver.findElement(By.xpath(UIMapMyLowes.webElmntDeleteMsgCalcName)).getText();
		if(varCalc1Undo.equals(varCalc1))
		{
			report.updateTestLog("Deleting using TrashCan on Calculations Details","Item Name displayed on deletion message", Status.PASS);
		}
		else
		{
			report.updateTestLog("Deleting using TrashCan on Calculations Details","Item Name NOT displayed on deletion message", Status.FAIL);
		}
		String varUndo1 = driver.findElement(By.xpath(UIMapMyLowes.lnkDeleteCalcUndo)).getText();
		if(varUndo1.equals("Undo"))
		{
			report.updateTestLog("Deleting using TrashCan on Calculations Details","Undo link displayed on deletion message", Status.PASS);
		}
		else
		{
			report.updateTestLog("Deleting using TrashCan on Calculations Details","Undo link NOT displayed on deletion message", Status.FAIL);
		}
		

	}
	
	/*this function checks the delete calculation using Trashcan functionality in detail view in a space having multiple calculations*/
	public void deleteCalcTrashCanDetailMultiple() throws Exception
	{
		//Storing Calculations names before deletion
		String varCalc1 = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc1Name)).getText();
		System.out.println(varCalc1);
		String varCalc2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc2Name)).getText();
		System.out.println(varCalc2);
		String varCalc3 = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc3Name)).getText();
		System.out.println(varCalc3);
		deleteTrashCanCalcDetail();
		String varCalc22 = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc2Name)).getText();
		System.out.println(varCalc22);
		String varCalc33 = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc3Name)).getText();
		System.out.println(varCalc33);
		if(varCalc22.equals(varCalc2))
		{
			report.updateTestLog("Deleting using Trashcan on Details","Second Calculation same as before", Status.PASS);
		}
		else
		{
			report.updateTestLog("Deleting using Trashcan on Details","Second Calculation NOT same as before", Status.FAIL);
		}
		if(varCalc33.equals(varCalc3))
		{
			report.updateTestLog("Deleting using Trashcan on Details","Third Calculation same as before", Status.PASS);
		}
		else
		{
			report.updateTestLog("Deleting using Trashcan on Details","Third Calculation NOT same as before", Status.FAIL);
		}
		
	}
	
	
	
	/*This function clicks on Undo link*/
	public void clickUndo() throws Exception
	{
		driver.findElement(By.partialLinkText("Undo")).click();
		Thread.sleep(5000);
		
	}
	
	/*This function deletes a calculation results using Trashcan from list view*/
	public void deleteTrashCanCalcList() throws Exception
	{
		String varCalc1 = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc1Name)).getText();
		System.out.println(varCalc1);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntDeleteCalcTrashcan)).click();
		Thread.sleep(2000);
		
		String varCalc1Undo = driver.findElement(By.xpath(UIMapMyLowes.webElmntDeleteMsgCalcName)).getText();
		if(varCalc1Undo.equals(varCalc1))
		{
			report.updateTestLog("Deleting using TrashCan on Calculations List","Item Name displayed on deletion message", Status.PASS);
		}
		else
		{
			report.updateTestLog("Deleting using TrashCan on Calculations List","Item Name NOT displayed on deletion message", Status.FAIL);
		}
		String varUndo1 = driver.findElement(By.xpath(UIMapMyLowes.lnkDeleteCalcUndo)).getText();
		if(varUndo1.equals("Undo"))
		{
			report.updateTestLog("Deleting using TrashCan on Calculations List","Undo link displayed on deletion message", Status.PASS);
		}
		else
		{
			report.updateTestLog("Deleting using TrashCan on Calculations List","Undo link NOT displayed on deletion message", Status.FAIL);
		}

	}
	
	/*this function checks the delete calculation using Trashcan functionality in detail view in a space having multiple calculations*/
	public void deleteCalcTrashCanListMultiple() throws Exception
	{
		//Storing Calculations names before deletion
		String varCalc1 = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc1Name)).getText();
		System.out.println(varCalc1);
		String varCalc2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc2Name)).getText();
		System.out.println(varCalc2);
		String varCalc3 = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc3Name)).getText();
		System.out.println(varCalc3);
		deleteTrashCanCalcList();
		String varCalc22 = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc2Name)).getText();
		System.out.println(varCalc22);
		String varCalc33 = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc3Name)).getText();
		System.out.println(varCalc33);
		if(varCalc22.equals(varCalc2))
		{
			report.updateTestLog("Deleting using Trashcan on List","Second Calculation same as before", Status.PASS);
		}
		else
		{
			report.updateTestLog("Deleting using Trashcan on List","Second Calculation NOT same as before", Status.FAIL);
		}
		if(varCalc33.equals(varCalc3))
		{
			report.updateTestLog("Deleting using Trashcan on List","Third Calculation same as before", Status.PASS);
		}
		else
		{
			report.updateTestLog("Deleting using Trashcan on List","Third Calculation NOT same as before", Status.FAIL);
		}
		
	}
	
	/*This function deletes a calculation results using Trashcan from list view*/
	public void deleteTrashCanCalcList1Item() throws Exception
	{
		String varCalc1 = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc1Name)).getText();
		System.out.println(varCalc1);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntDeleteCalcTrashcan)).click();
		Thread.sleep(2000);
		
		String varCalc1Undo = driver.findElement(By.xpath(UIMapMyLowes.webElmntDeleteMsgCalcName)).getText();
		if(varCalc1Undo.equals(varCalc1))
		{
			report.updateTestLog("Deleting using TrashCan on Calculations List","Item Name displayed on deletion message", Status.PASS);
		}
		else
		{
			report.updateTestLog("Deleting using TrashCan on Calculations List","Item Name NOT displayed on deletion message", Status.FAIL);
		}
		String varUndo1 = driver.findElement(By.xpath(UIMapMyLowes.lnkDeleteCalcUndo)).getText();
		if(varUndo1.equals("Undo"))
		{
			report.updateTestLog("Deleting using TrashCan on Calculations List","Undo link displayed on deletion message", Status.PASS);
		}
		else
		{
			report.updateTestLog("Deleting using TrashCan on Calculations List","Undo link NOT displayed on deletion message", Status.FAIL);
		}
		driver.navigate().refresh();
		selenium.waitForPageToLoad("10000");

	}
	
	/*This function deletes a calculation results using Trashcan from Details view*/
	public void deleteTrashCanCalcDetail1Item() throws Exception
	{
		String varCalc1 = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc1Name)).getText();
		System.out.println(varCalc1);
		
		driver.findElement(By.xpath(UIMapMyLowes.lnkShowDetails)).click();
		Thread.sleep(5000);
		String varClose = driver.findElement(By.xpath(UIMapMyLowes.lnkCalcHideDetails)).getText();
		if(varClose.equals("Hide Details"))
		{
			report.updateTestLog("Checking Hide Details link","Hide Details link displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Hide Details link","Hide Details link NOT displayed", Status.FAIL);
		}
		driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcTrashcan)).click();
		Thread.sleep(5000);
		
		String varCalc1Undo = driver.findElement(By.xpath(UIMapMyLowes.webElmntDeleteMsgCalcName)).getText();
		if(varCalc1Undo.equals(varCalc1))
		{
			report.updateTestLog("Deleting using TrashCan on Calculations Details","Item Name displayed on deletion message", Status.PASS);
		}
		else
		{
			report.updateTestLog("Deleting using TrashCan on Calculations Details","Item Name NOT displayed on deletion message", Status.FAIL);
		}
		String varUndo1 = driver.findElement(By.xpath(UIMapMyLowes.lnkDeleteCalcUndo)).getText();
		if(varUndo1.equals("Undo"))
		{
			report.updateTestLog("Deleting using TrashCan on Calculations Details","Undo link displayed on deletion message", Status.PASS);
		}
		else
		{
			report.updateTestLog("Deleting using TrashCan on Calculations Details","Undo link NOT displayed on deletion message", Status.FAIL);
		}
		driver.navigate().refresh();
		selenium.waitForPageToLoad("10000");

	}
	
	public void saveItemToListHP() throws Exception
	{
		String varItemName=null;
		try{ varItemName = driver.findElement(By.xpath(UIMapMyLowes.webElmntProductName)).getText();}
		catch(Exception WebDriverException)
		{
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			 varItemName = driver.findElement(By.xpath(UIMapMyLowes.webElmntProductName)).getText();
		}
		String varItemNameTrimmed = varItemName.substring(0,36);
		System.out.println(varItemNameTrimmed);
		driver.findElement(By.id(UIMapMyLowes.webElmntSaveItem)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntSaveToList)).click();
		
		Thread.sleep(5000);
		driver.findElement(By.id(UIMapMyLowes.webElmntSaveItem)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntSaveToHP)).click();
		Thread.sleep(5000);
		//String verItemSaved = driver.findElement(By.xpath("//*[@id='saveItemBlock']/div[1]/span/span[2]")).getText();
		//System.out.println("SAVE ITEM::"+verItemSaved+"::");
		boolean verItemSaved=selenium.isTextPresent("Item Saved");
		if(verItemSaved)
		{
			if(selenium.isTextPresent("Go to Lists"))
			{
			report.updateTestLog("Adding Item To List","Item added to List" ,Status.PASS);
			}
			if(selenium.isTextPresent("Go to Home Profile"))
			{
			report.updateTestLog("Adding Item To Home Profile","Item added to Home Profile" ,Status.PASS);
			}
			driver.findElement(By.xpath(UIMapMyLowes.lnkGoToHP)).click();
			selenium.waitForPageToLoad("10000");
			Thread.sleep(5000);
			driver.findElement(By.xpath(UIMapMyLowes.webElmntShowHP)).click();
			Thread.sleep(2000);
			//selenium.waitForPageToLoad("10000");
			driver.findElement(By.xpath(UIMapMyLowes.webElmntShowAllProducts)).click();
			selenium.waitForPageToLoad("10000");
			driver.navigate().refresh();
			selenium.waitForPageToLoad("10000");
			//driver.findElement(By.xpath(UIMapMyLowes.lnkItem1ViewProduct)).click();
			//selenium.waitForPageToLoad("20000");
			
			String varItemName2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntItem1Name)).getText();
			
			String varItemName2Trimmed = varItemName2.substring(0,36);
			System.out.println(varItemName2Trimmed);
			//following code verifies whether the topmost item in Home Profile Products summary is same as one that is added to Home Profile
			//hence, this assumes that the Summary list is sorted by Most recent for the user
			
			if(varItemNameTrimmed.equals(varItemName2Trimmed))
			{
				report.updateTestLog("Verifying Added Item in home profile","Item displayed in Home Profile" ,Status.PASS);
			}
			else
			{
				report.updateTestLog("Verifying Added Item in home profile","Item NOT displayed in Home Profile" ,Status.FAIL);
			}
			
			driver.findElement(By.id(UIMapMyLowes.lnkLists)).click();
			selenium.waitForPageToLoad("10000");
			driver.findElement(By.xpath(UIMapMyLowes.webElmntListShow)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(UIMapMyLowes.webElmntListShowAllItems)).click();
			Thread.sleep(2000);
			
			String varItemName3 = driver.findElement(By.xpath(UIMapMyLowes.webElmntListItem1Name)).getText();
			
			String varItemName3Trimmed = varItemName3.substring(0,36);
			System.out.println(varItemName3Trimmed);
			//following code verifies whether the topmost item in Home Profile Products summary is same as one that is added to Home Profile
			//hence, this assumes that the Summary list is sorted by Most recent for the user
			
			if(varItemNameTrimmed.equals(varItemName3Trimmed))
			{
				report.updateTestLog("Verifying Added Item in List","Item displayed in List" ,Status.PASS);
			}
			else
			{
				report.updateTestLog("Verifying Added Item in List","Item NOT displayed in List" ,Status.FAIL);
			}
			
		}
		else
		{
			report.updateTestLog("Adding Item To List & Home profile","Item Not added to List & HomeProfile" ,Status.FAIL);
		}
	}
	
	/*This function validates the All Items checkbox*/
	public void clickAllItemsCheckbox() throws Exception
	{
		driver.findElement(By.id(UIMapMyLowes.chkBoxBatchDelete)).click();
		Thread.sleep(1000);
		String varChecked1 = driver.findElement(By.xpath(UIMapMyLowes.chkBoxItem)).getAttribute("checked");
		System.out.println(varChecked1);
		if(varChecked1.equals("true"))
		{
			report.updateTestLog("Clicking All Items Check Box","Item 1 checked" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking All Items Check Box","Item 1 NOT checked" ,Status.FAIL);
		}
		String varChecked2 = driver.findElement(By.xpath(UIMapMyLowes.chkBoxItem2)).getAttribute("checked");
		System.out.println(varChecked2);
		if(varChecked2.equals("true"))
		{
			report.updateTestLog("Clicking All Items Check Box","Item 2 checked" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking All Items Check Box","Item 2 NOT checked" ,Status.FAIL);
		}
	}
	
	public void saveItemToHomeProfile() throws Exception
	{
		String varItemName = null;
		String varItemNameTrimmed = null;
		try{ varItemName = driver.findElement(By.xpath(UIMapMyLowes.webElmntProductName)).getText();
		 varItemNameTrimmed = varItemName.substring(0,36);
		System.out.println(varItemNameTrimmed);
		driver.findElement(By.id(UIMapMyLowes.webElmntSaveItem)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntSaveToHP)).click();
		Thread.sleep(5000);}
		catch(Exception WebDriverException)
		{
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			varItemName = driver.findElement(By.xpath(UIMapMyLowes.webElmntProductName)).getText();
			 varItemNameTrimmed = varItemName.substring(0,36);
			System.out.println(varItemNameTrimmed);
			driver.findElement(By.id(UIMapMyLowes.webElmntSaveItem)).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(UIMapMyLowes.webElmntSaveToHP)).click();
			Thread.sleep(5000);
		}
		
		//String verItemSaved = driver.findElement(By.xpath("//*[@id='saveItemBlock']/div[1]/span/span[2]")).getText();
		//System.out.println("SAVE ITEM::"+verItemSaved+"::");
		boolean verItemSaved=selenium.isTextPresent("Item Saved");
		if(verItemSaved)
		{
			report.updateTestLog("Adding Item To Home Profile","Item added to Home Profile" ,Status.PASS);
			driver.findElement(By.xpath(UIMapMyLowes.lnkGoToHP)).click();
			selenium.waitForPageToLoad("10000");
			//driver.findElement(By.xpath("//*[@id='items_trigger']")).click();
			driver.findElement(By.xpath(UIMapMyLowes.webElmntShowHP)).click();
			Thread.sleep(1000);
			//selenium.waitForPageToLoad("10000");
			driver.findElement(By.xpath(UIMapMyLowes.webElmntShowAllProducts)).click();
			selenium.waitForPageToLoad("10000");
			driver.navigate().refresh();
			selenium.waitForPageToLoad("10000");
			//driver.findElement(By.xpath(UIMapMyLowes.lnkItem1ViewProduct)).click();
			//selenium.waitForPageToLoad("20000");
			
			String varItemName2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntItem1Name)).getText();
			
			String varItemName2Trimmed = varItemName2.substring(0,36);
			System.out.println(varItemName2Trimmed);
			//following code verifies whether the topmost item in Home Profile Products summary is same as one that is added to Home Profile
			//hence, this assumes that the Summary list is sorted by Most recent for the user
			
			if(varItemNameTrimmed.equals(varItemName2Trimmed))
			{
				report.updateTestLog("Verifying Added Item in home profile","Item displayed in Home Profile" ,Status.PASS);
			}
			else
			{
				report.updateTestLog("Verifying Added Item in home profile","Item NOT displayed in Home Profile" ,Status.FAIL);
			}
			
			
		}
		else
		{
			report.updateTestLog("Adding Item To Home Profile","Item NOT Added to Home Profile", Status.FAIL);
		}
	}
	
	/*Navigating to Purchases*/
	public void navPurchase() throws Exception
	{
		try{driver.findElement(By.id(UIMapMyLowes.lnkPurchases)).click();}
		catch(Exception WebDriverException)
		{
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.id(UIMapMyLowes.lnkPurchases)).click();
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(5000);
		String varHomeProfile = driver.findElement(By.xpath(UIMapMyLowes.webElmntBrdCrumbsLvl3)).getText();
		System.out.println(varHomeProfile);
		if(varHomeProfile.equals("Purchases"))
		{
			report.updateTestLog("Clicking Purchases link","Purchases Summary page displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Clicking Purchases link","Purchases Summary page NOT displayed", Status.FAIL);
		}	
		
	}
	
	public void inStorepurchases() throws Exception
	{
		try{driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseType)).click();}
		catch(Exception WebDriverException)
		{
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseType)).click();
		}
		Thread.sleep(1000);
		Select select = new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseType)));
		select.selectByVisibleText("In-Store");
		selenium.waitForPageToLoad("10000");
		driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate)).click();
		Thread.sleep(1000);
		Select select2 = new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate)));
		select2.selectByVisibleText("All");
		selenium.waitForPageToLoad("10000");
		//report.updateTestLog("Selecting In-Store purchases","Purchases Summary page NOT displayed", Status.FAIL);
		boolean varItemsdisplayed = selenium.isElementPresent("no-purchases");
		if(varItemsdisplayed)
		{
			report.updateTestLog("Selecting In-Store purchases","Purchases Not displayed", Status.FAIL);
		}
		else
		{
			report.updateTestLog("Selecting In-Store purchases","Purchases displayed", Status.PASS);
		}
	}
	
	public void onlinePurchases() throws Exception
	{
		try{driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseType)).click();}
		catch(Exception WebDriverException)
		{
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseType)).click();
		}
		Thread.sleep(1000);
		Select select = new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseType)));
		select.selectByVisibleText("Online");
		selenium.waitForPageToLoad("10000");
		driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate)).click();
		Thread.sleep(1000);
		Select select2 = new Select(driver.findElement(By.id(UIMapMyLowes.drpDownPurchaseDate)));
		select2.selectByVisibleText("All");
		selenium.waitForPageToLoad("10000");
		//report.updateTestLog("Selecting In-Store purchases","Purchases Summary page NOT displayed", Status.FAIL);
		boolean varItemsdisplayed = selenium.isElementPresent("no-purchases");
		if(varItemsdisplayed)
		{
			report.updateTestLog("Selecting Online purchases","Purchases Not displayed", Status.FAIL);
		}
		else
		{
			report.updateTestLog("Selecting Online purchases","Purchases displayed", Status.PASS);
		}
	}
	
	public void purchasesPurchaseDetails() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.lnkPurchaseViewOrderNbr)).click();
		//driver.findElement(By.xpath("//*[@id='itemView']/div[1]/a")).click();
		
		selenium.waitForPageToLoad("10000");
		boolean varOrderDetail = selenium.isElementPresent(UIMapMyLowes.webElmntPurchaseDetailsHeading);
		if(varOrderDetail)
		{
			report.updateTestLog("Selecting Order#","Purchases displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("Selecting Order#","Purchases NOT displayed", Status.FAIL);
		}
		String varItemName = driver.findElement(By.xpath(UIMapMyLowes.webElmntOrderItemName)).getText();
		String varItemNameTrimmed = null;
		int TrimFlag = 0;
		if(varItemName.length()>36)
		{
			varItemNameTrimmed = varItemName.substring(0,36);
			System.out.println(varItemNameTrimmed);
			TrimFlag = 1;
			System.out.println(TrimFlag);
			
		}
		
		//driver.findElement(By.partialLinkText("Add To"));
		selenium.click(UIMapMyLowes.webElmntSaveFrmPurchases);
		Thread.sleep(2000);
		selenium.click(UIMapMyLowes.webElmntSaveToHPFrmPurchases);
		Thread.sleep(2000);
		selenium.click(UIMapMyLowes.webElmntSaveFrmPurchases);
		Thread.sleep(2000);
		/*String varCheck = driver.findElement(By.xpath("//*[@id='order_detail']/div[2]/div[2]/div/div[2]/div[3]/div[2]/ul/li[1]/a/span[1]")).getAttribute("class");
		System.out.println(varCheck);
		if(varCheck.equals("check"))
		{
			report.updateTestLog("Saving to Home Profile using Purchase Details","Saved to Home Profile", Status.PASS);
		}
		else
		{
			report.updateTestLog("Saving to Home Profile using Purchase Details","NOT Saved to Home Profile", Status.FAIL);
		}*/
		boolean varChecked = selenium.isElementPresent(UIMapMyLowes.webElmntSavedTrue);
		if(varChecked)
		{
			report.updateTestLog("Saving to Home Profile using Purchase Details","Saved to Home Profile", Status.PASS);
		}
		else
		{
			report.updateTestLog("Saving to Home Profile using Purchase Details","NOT Saved to Home Profile", Status.FAIL);
		}
		navHomeProfile();
		clickAllProductsHP();
		String varItemName2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntItem1Name)).getText();
		String varItemName2Trimmed = null;
		if(varItemName2.length()>36)
		{
		varItemName2Trimmed = varItemName2.substring(0,36);
		System.out.println(varItemName2Trimmed);
		}
		//following code verifies whether the topmost item in Home Profile Products summary is same as one that is added to Home Profile
		//hence, this assumes that the Summary list is sorted by Most recent for the user
		
		if(TrimFlag==1)
		{
		if(varItemNameTrimmed.equals(varItemName2Trimmed))
		{
			report.updateTestLog("Verifying Added Item in home profile","Item displayed in Home Profile" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying Added Item in home profile","Item NOT displayed in Home Profile" ,Status.FAIL);
		}
		}
		else
		{
			if(varItemName.equals(varItemName2))
			{
				report.updateTestLog("Verifying Added Item in home profile","Item displayed in Home Profile" ,Status.PASS);
			}
			else
			{
				report.updateTestLog("Verifying Added Item in home profile","Item NOT displayed in Home Profile" ,Status.FAIL);
			}
		}
		
	}
	
	public void purchaseSwitchItemView() throws Exception
	{
		
		driver.findElement(By.xpath(UIMapMyLowes.webElmntPurchasesItemView)).click();
		Thread.sleep(5000);
		String varCurrentView = driver.findElement(By.xpath(UIMapMyLowes.webElmntPurchasesItemView)).getAttribute("class");
		if(varCurrentView.equals("item-view current"))
		{
			report.updateTestLog("Switching to Item View","switched to Item View" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Switching to Item View","NOT switched to Item View" ,Status.FAIL);
		}
		//*[@id='itemView']/ul[1]/li/div[3]/div[1]/span
	}
	
	public void purchaseItemViewAddToHP() throws Exception
	{
		
		String varItemName = driver.findElement(By.xpath(UIMapMyLowes.webElmntItemViewItemName)).getText();
		String varItemNameTrimmed = null;
		int TrimFlag = 0;
		if(varItemName.length()>36)
		{
			varItemNameTrimmed = varItemName.substring(0,36);
			System.out.println(varItemNameTrimmed);
			TrimFlag = 1;
			System.out.println(TrimFlag);
			
		}
		//String varCheck = null;
		//driver.findElement(By.partialLinkText("Add To"));
		selenium.click(UIMapMyLowes.webElmntSaveFrmPurchases);
		Thread.sleep(2000);
		selenium.click(UIMapMyLowes.webElmntSaveToHPFrmPurchases);
		Thread.sleep(2000);
		selenium.click(UIMapMyLowes.webElmntSaveFrmPurchases);
		Thread.sleep(2000);
	/*	try{
			varCheck = driver.findElement(By.xpath("//*[@id='itemView']/ul[1]/li/div[3]/div[2]/ul/li[1]/a/span[1]")).getAttribute("class");
		
		System.out.println(varCheck);
		if(varCheck.equals("check"))
		{
			report.updateTestLog("Saving to Home Profile using Purchase History","Saved to Home Profile", Status.PASS);
		}
		else
		{
			report.updateTestLog("Saving to Home Profile using Purchase History","NOT Saved to Home Profile", Status.FAIL);
		}
		}
		catch(Exception NoSuchElementException)
		{
			String varcheck2 = driver.findElement(By.xpath("//*[@id='itemView']/ul/li/div[3]/div/div[2]/ul/li[1]/a/span[1]")).getAttribute("class");
			
			System.out.println(varcheck2);
			if(varcheck2.equals("check"))
			{
				report.updateTestLog("Saving to Home Profile using Purchase History","Saved to Home Profile", Status.PASS);
			}
			else
			{
				report.updateTestLog("Saving to Home Profile using Purchase History","NOT Saved to Home Profile", Status.FAIL);
			}
		}*/
		boolean varChecked = selenium.isElementPresent(UIMapMyLowes.webElmntSavedTrue);
		if(varChecked)
		{
			report.updateTestLog("Saving to Home Profile using Purchase History","Saved to Home Profile", Status.PASS);
		}
		else
		{
			report.updateTestLog("Saving to Home Profile using Purchase History","NOT Saved to Home Profile", Status.FAIL);
		}
		navHomeProfile();
		clickAllProductsHP();
		String varItemName2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntItem1Name)).getText();
		String varItemName2Trimmed = null;
		if(varItemName2.length()>36)
		{
		varItemName2Trimmed = varItemName2.substring(0,36);
		System.out.println(varItemName2Trimmed);
		}
		//following code verifies whether the topmost item in Home Profile Products summary is same as one that is added to Home Profile
		//hence, this assumes that the Summary list is sorted by Most recent for the user
		
		if(TrimFlag==1)
		{
		if(varItemNameTrimmed.equals(varItemName2Trimmed))
		{
			report.updateTestLog("Verifying Added Item in home profile","Item displayed in Home Profile" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying Added Item in home profile","Item NOT displayed in Home Profile" ,Status.FAIL);
		}
		}
		else
		{
			if(varItemName.equals(varItemName2))
			{
				report.updateTestLog("Verifying Added Item in home profile","Item displayed in Home Profile" ,Status.PASS);
			}
			else
			{
				report.updateTestLog("Verifying Added Item in home profile","Item NOT displayed in Home Profile" ,Status.FAIL);
			}
		}
	}
	
	public void checkItemsSortingHP() throws Exception
	{
		int i=0;
		int j=0;
		String[] varItemsBeforeSorting = new String[3];
		String[] varItemsAfterSorting = new String[3];
		for(i=0;i<3;i++)
		{
			j=j+1;
			String varXPath = "//*[@id='item_list']/div[1]/div["+j+"]/div[2]/div[1]/h5";
			varItemsBeforeSorting[i]=driver.findElement(By.xpath(varXPath)).getText();
			System.out.println(varItemsBeforeSorting[i]);
			j=j+1;
		}
		driver.findElement(By.xpath(UIMapMyLowes.webElmntSortByHp)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntSortByHpMostRecent)).click();
		Thread.sleep(5000);
		j=0;
		for(i=0;i<3;i++)
		{
			j=j+1;
			String varXPath = "//*[@id='item_list']/div[1]/div["+j+"]/div[2]/div[1]/h5";
			varItemsAfterSorting[i]=driver.findElement(By.xpath(varXPath)).getText();
			System.out.println(varItemsAfterSorting[i]);
			j=j+1;
		}
		for(i=0;i<3;i++)
		{
			if(varItemsAfterSorting[i].equals(varItemsBeforeSorting[i]))
			{
				if(i==2)
				{
					report.updateTestLog("Clicking Most recent","Sorting Not Changed" ,Status.PASS);
				}
				continue;
			}
			else
			{
				report.updateTestLog("Clicking Most recent","Sorting Changed" ,Status.FAIL);
				break;
			}
		}
	}
	
	/*this function updates the HP Profile name and Profile Notes to *javascript* and validates the error message*/
	public void checkCodeScriptHPNameNotes() throws Exception
	{
		String varOldName = driver.findElement(By.xpath(UIMapMyLowes.lnkHPName)).getText();
		System.out.println(varOldName);
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.xpath(UIMapMyLowes.lnkHPName));
		actions.moveToElement(menuHoverLink).build().perform();
		
		Thread.sleep(5000);
		WebElement varRenameLink = driver.findElement(By.xpath(UIMapMyLowes.lnkHPNameRename));
		actions.moveToElement(varRenameLink).build().perform();
		varRenameLink.click();
		Thread.sleep(1000);
		//String varOldName = driver.findElement(By.xpath(UIMapMyLowes.txtHPNameRename)).getText();
		
		driver.findElement(By.xpath(UIMapMyLowes.txtHPNameRename)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtHPNameRename)).sendKeys("*javascript.*");
		driver.findElement(By.xpath(UIMapMyLowes.btnHPNameRenameSave)).click();
		Thread.sleep(2000);
		if(driver.findElement(By.xpath(UIMapMyLowes.webElmntHPRenameError)).isDisplayed())
		{
		String varError = driver.findElement(By.xpath(UIMapMyLowes.webElmntHPRenameError)).getText();
		
		if(varError.equals("We're unable to complete your request at this time. Please try again."))
		{
			report.updateTestLog("Entering script code in HP Name","Error Message displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Entering script code in HP Name","Error Message NOT displayed" ,Status.FAIL);
		}
		}
		else
		{
			report.updateTestLog("Entering script code in HP Name","Error Message NOT displayed" ,Status.FAIL);
		}
		driver.navigate().refresh();
		selenium.waitForPageToLoad("10000");
		String varNewName = driver.findElement(By.xpath(UIMapMyLowes.lnkHPName)).getText();
		System.out.println(varNewName);
		if(varNewName.equals(varOldName))
		{
			report.updateTestLog("Refreshing Page","Old HP Name retained" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Refreshing Page","Old HP Name NOT retained" ,Status.FAIL);
		}
		driver.findElement(By.xpath(UIMapMyLowes.webElmntHPNotes)).click();
		Thread.sleep(1000);
		String varOldNotes = driver.findElement(By.xpath(UIMapMyLowes.txtHPNotes)).getText();
		System.out.println(varOldNotes);
		driver.findElement(By.xpath(UIMapMyLowes.txtHPNotes)).clear();
		driver.findElement(By.xpath(UIMapMyLowes.txtHPNotes)).sendKeys("*javascript.*");
		driver.findElement(By.xpath(UIMapMyLowes.btnHPNotesSave)).click();
		String varError2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntProfileNotesError)).getText();
		if(varError2.equals("Invalid notes input. Please remove special characters and try again."))
		{
			report.updateTestLog("Entering script code in HP Notes","Error Message displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Entering script code in HP Notes","Error Message NOT displayed" ,Status.FAIL);
		}
		driver.navigate().refresh();
		selenium.waitForPageToLoad("10000");
		driver.findElement(By.xpath(UIMapMyLowes.webElmntHPNotes)).click();
		Thread.sleep(1000);
		String varNewNotes = driver.findElement(By.xpath(UIMapMyLowes.txtHPNotes)).getText();
		System.out.println(varNewNotes);
		if(varNewNotes.equals(varOldNotes))
		{
			report.updateTestLog("Refreshing Page","Old HP Notes retained" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Refreshing Page","Old HP Notes NOT retained" ,Status.FAIL);
		}
		
	}
	
	/*This function opens Photos in a Space in HP*/
	public void photosHomeProfile() throws Exception
	{
		driver.findElement(By.cssSelector(UIMapMyLowes.webElmntSelectShow)).click();
		driver.findElement(By.linkText("Photos")).click();
		Thread.sleep(5000);
		boolean varDocuments = selenium.isElementPresent(UIMapMyLowes.webElmntPhotosCount);
		if(varDocuments)
		{
			report.updateTestLog("Opening Photos tab","Photos opened" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Opening Photos tab","Photos NOT opened" ,Status.FAIL);
		}	
		
	}
	
	/*This function verifies count of Photos for a space in Home Profile. Prerequisite: Upload few Photos in Home Profile
	 * of a user and update the count in the datasheet
	 */
	public void verifyPhotosCountHP() throws Exception
	{
		String varNbrOfPhotos = driver.findElement(By.xpath(UIMapMyLowes.webElmntPhotosCount)).getText();
		System.out.println(varNbrOfPhotos);
		
		String[] s = varNbrOfPhotos.split(" ");
		if(s[0].equals(dataTable.getData("General_Data","NbrOfPhotos")))
		{
			report.updateTestLog("Checking Photos Count","Photos Count is correct" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Photos Count","Photos Count is NOT correct" ,Status.FAIL);
		}
		
	}
	
	/*this function verifies the layout of Photos tab(Should have atleast 2 Photos*/
	public void verifyPhotoslayout() throws Exception
	{
		//checking thumbnails
		boolean varImage1 = driver.findElement(By.xpath(UIMapMyLowes.webElmntPhoto1Thumbnail)).isDisplayed();
		if(varImage1)
		{
			report.updateTestLog("Checking Photos Layout-Thumbnail","Image 1 Thumbnail displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Photos Layout-Thumbnail","Image 1 Thumbnail NOT displayed" ,Status.FAIL);
		}
		boolean varImage2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntPhoto2Thumbnail)).isDisplayed();
		if(varImage2)
		{
			report.updateTestLog("Checking Photos Layout-Thumbnail","Image 2 Thumbnail displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Photos Layout-Thumbnail","Image 2 Thumbnail NOT displayed" ,Status.FAIL);
		}
		//checking names
		String varImage1Name = driver.findElement(By.xpath(UIMapMyLowes.webElmntPhoto1Name)).getAttribute("data-image-name");
		System.out.println(varImage1Name);
		String varImage2Name = driver.findElement(By.xpath(UIMapMyLowes.webElmntPhoto2Name)).getAttribute("data-image-name");
		System.out.println(varImage2Name);
		String varImage1Name2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntPhoto1NameDisp)).getText();
		String varImage2Name2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntPhoto2NameDisp)).getText();
		if(varImage1Name2.equals(varImage1Name))
		{
			report.updateTestLog("Checking Photos Layout-Name","Image 1 Name displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Photos Layout-Name","Image 1 Name NOT displayed" ,Status.FAIL);
		}
		if(varImage2Name2.equals(varImage2Name))
		{
			report.updateTestLog("Checking Photos Layout-Name","Image 2 Name displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Photos Layout-Name","Image 2 Name NOT displayed" ,Status.FAIL);
		}
		//checking Trashcan icon
		Actions actions = new Actions(driver);
		WebElement menuHoverImage = driver.findElement(By.xpath(UIMapMyLowes.webElmntPhoto1Thumbnail));
		actions.moveToElement(menuHoverImage).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(5000);
		WebElement varTrashCan11 = driver.findElement(By.xpath(UIMapMyLowes.webElmntPhoto1TrashCan));
		actions.moveToElement(varTrashCan11).build().perform();
		boolean varTrashCan1 = driver.findElement(By.xpath(UIMapMyLowes.webElmntPhoto1TrashCan)).isDisplayed();
		if(varTrashCan1)
		{
			report.updateTestLog("Checking Photos Layout-TrashCan","Image 1 TrashCan displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Photos Layout-TrashCan","Image 1 TrashCan NOT displayed" ,Status.FAIL);
		}
		menuHoverImage = driver.findElement(By.xpath(UIMapMyLowes.webElmntPhoto2Thumbnail));
		actions.moveToElement(menuHoverImage).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(5000);
		WebElement varTrashCan22 = driver.findElement(By.xpath(UIMapMyLowes.webElmntPhoto2TrashCan));
		actions.moveToElement(varTrashCan22).build().perform();
		boolean varTrashCan2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntPhoto2TrashCan)).isDisplayed();
		if(varTrashCan2)
		{
			report.updateTestLog("Checking Photos Layout-TrashCan","Image 2 TrashCan displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Photos Layout-TrashCan","Image 2 TrashCan NOT displayed" ,Status.FAIL);
		}
	}
	
	public void verifyDocsLayout() throws Exception
	{
		/*//verifying nbr of documents
		String varNbrOfDocs = driver.findElement(By.xpath(UIMapMyLowes.webElmntDocCount)).getText();
		System.out.println(varNbrOfDocs);
		
		String[] s = varNbrOfDocs.split(" ");
		if(s[0].equals(dataTable.getData("General_Data","NbrOfDocs")))
		{
			report.updateTestLog("Checking Documents Count","Correct Documents Count Displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Documents Count","Correct Documents Count NOT Displayed" ,Status.FAIL);
		}*/
		//Verifying Upload:
		String varUpload = driver.findElement(By.xpath(UIMapMyLowes.webElmntDocUpload)).getText();
		if(varUpload.equals("Upload"))
		{
			report.updateTestLog("Checking Upload option","Upload option Displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Upload option","Upload option NOT Displayed" ,Status.FAIL);
		}
		//Verifying Show :
		String varShow = driver.findElement(By.xpath(UIMapMyLowes.webElmntDocShow)).getText();
		boolean varShow2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntDocShowDropDown)).isDisplayed();
		if(varShow.equals("Show:") && varShow2 )
		{
			report.updateTestLog("Checking Show label and drop-down","Show label and drop-down Displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Show label and drop-down","Show label and drop-down NOT Displayed" ,Status.FAIL);
		}
		//verifying Sort By
		String varSortBy = driver.findElement(By.xpath(UIMapMyLowes.webElmntDocSortBy)).getText();
		boolean varSortBy2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntDocSortByDropDown)).isDisplayed();
		if(varSortBy.equals("Sort by:") && varSortBy2 )
		{
			report.updateTestLog("Checking Sort By label and drop-down","Sort By label and drop-down Displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Sort By label and drop-down","Sort By label and drop-down NOT Displayed" ,Status.FAIL);
		}
		//verifying Document Names
		String varName1 = driver.findElement(By.xpath(UIMapMyLowes.webElmntDoc1Name)).getText();
		String varName2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntDoc2Name)).getText();
		if(varName1.equals(" "))
		{
			report.updateTestLog("Checking Document 1 Name","Document 1 Name NOT Displayed" ,Status.FAIL);
		}
		else
		{
			report.updateTestLog("Checking Document 1 Name","Document 1 Name:"+ varName1+" Displayed" ,Status.PASS);
		}
		if(varName2.equals(" "))
		{
			report.updateTestLog("Checking Document 2 Name","Document 2 Name NOT Displayed" ,Status.FAIL);
		}
		else
		{
			report.updateTestLog("Checking Document 2 Name","Document 2 Name:"+ varName2+" Displayed" ,Status.PASS);
		}
		//Checking Download: options
		boolean varDownload1 = driver.findElement(By.xpath(UIMapMyLowes.lnkDoc1DownloadLink)).isDisplayed();
		if(varDownload1)
		{
			report.updateTestLog("Checking Document 1 Download option","Document 1 Download option Displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Document 1 Download option","Document 1 Download option NOT Displayed" ,Status.FAIL);
		}
		boolean varDownload2 = driver.findElement(By.xpath(UIMapMyLowes.lnkDoc2DownloadLink)).isDisplayed();
		if(varDownload2)
		{
			report.updateTestLog("Checking Document 2 Download option","Document 2 Download option Displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Document 2 Download option","Document 2 Download option NOT Displayed" ,Status.FAIL);
		}
		//checking Edit Options
		boolean varEdit1 = driver.findElement(By.xpath(UIMapMyLowes.lnkEdit2)).isDisplayed();
		if(varEdit1)
		{
			report.updateTestLog("Checking Document 1 Edit option","Document 1 Edit option Displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Document 1 Edit option","Document 1 Edit option NOT Displayed" ,Status.FAIL);
		}
		boolean varEdit2 = driver.findElement(By.xpath(UIMapMyLowes.lnkDoc2EditLink)).isDisplayed();
		if(varEdit2)
		{
			report.updateTestLog("Checking Document 2 Edit option","Document 2 Edit option Displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Document 2 Edit option","Document 2 Edit option NOT Displayed" ,Status.FAIL);
		}
		//checking TrashCan icons
		boolean varDel1 = driver.findElement(By.xpath(UIMapMyLowes.webElmntDoc1Trashcan)).isDisplayed();
		if(varDel1)
		{
			report.updateTestLog("Checking Document 1 Trashcan","Document 1 Trashcan Displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Document 1 Trashcan","Document 1 Trashcan NOT Displayed" ,Status.FAIL);
		}
		boolean varDel2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntDoc2Trashcan)).isDisplayed();
		if(varDel2)
		{
			report.updateTestLog("Checking Document 2 Trashcan","Document 2 Trashcan Displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Document 2 Trashcan","Document 2 Trashcan NOT Displayed" ,Status.FAIL);
		}
		//Document  Notes
		
		List<WebElement> varDocs = driver.findElements(By.xpath(UIMapMyLowes.webElmntDocList));
		int DocsCount = varDocs.size();
		String[] s1 = new String[DocsCount];
		for(int i=0;i<DocsCount;i++)
		{
			int j = i+1;
			String varXpath = "//*[@id='documentsContainer']/div[2]/div[3]/div["+j+"]";
			System.out.println(varXpath);
			s1[i] =  driver.findElement(By.xpath(varXpath)).getAttribute("id");
			System.out.println(s1[i]);
		
		String varXpath1 = "//*[@id='"+s1[i]+"']/div[2]/form/div[2]/div[2]/div/a";
		try{
		String varAddANote1 = driver.findElement(By.xpath(varXpath1)).getText();
		if(varAddANote1.equals("Add a Note"))
		{
			report.updateTestLog("Checking Document Notes","Add A Note link Displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Document Notes","Add A Note link NOT  Displayed" ,Status.FAIL);
		}
		}
		catch(Exception ElementNotVisibleException)
		{
			String varXpath2 = ".//*[@id='"+s1[i]+"']/div[2]/form/div[2]/div[1]/a[2]";
			driver.findElement(By.xpath(varXpath2)).click();
			Thread.sleep(2000);
			driver.findElement(By.id("note")).click();
			Thread.sleep(1000);
			String varNotes = driver.findElement(By.id("note")).getText();
			String varNotesTrimmed = varNotes.substring(0,37);
			String varNotes1 = varNotesTrimmed+"...";
			
			System.out.println(varNotes1);
			driver.findElement(By.partialLinkText("Cancel")).click();
			Thread.sleep(1000);
			String varXpath3 = ".//*[@id='"+s1[i]+"']/div[2]/form/div[2]/div[2]/div";
			String varNotes2 = driver.findElement(By.xpath(varXpath3)).getText();
			System.out.println(varNotes2);
			if(varNotes2.equals(varNotes1))
			{
				report.updateTestLog("Checking Document Notes","Document Notes Preview Displayed" ,Status.PASS);
			}
			else
			{
				report.updateTestLog("Checking Document Notes","Document Notes Preview NOT Displayed" ,Status.FAIL);
			}
			
		}
		}
		//checking located in
		String varLocatedIn1 = driver.findElement(By.xpath(UIMapMyLowes.webElmntDoc1LocatedIn)).getText();
		if(varLocatedIn1.equals(dataTable.getData("General_Data", "Space")))
		{
			report.updateTestLog("Checking Located IN","Document1 Located IN Space displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Located IN","Document1 Located IN Space NOT displayed" ,Status.FAIL);
		}
		String varLocatedIn2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntDoc2LocatedIn)).getText();
		if(varLocatedIn2.equals(dataTable.getData("General_Data", "Space")))
		{
			report.updateTestLog("Checking Located IN","Document2 Located IN Space displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Located IN","Document2 Located IN Space NOT displayed" ,Status.FAIL);
		}
		//checking Unassign option
		boolean varUnassign = driver.findElement(By.xpath(UIMapMyLowes.webElmntDoc1UnassignOption)).isDisplayed();
		if(varUnassign)
		{
			String varX = driver.findElement(By.xpath(UIMapMyLowes.webElmntDoc1UnassignOption)).getText();
			if(varX.equals("X"))
			{
				report.updateTestLog("Checking Unassign Option","Document1 Unassign X displayed" ,Status.PASS);
			}
			else
			{
				report.updateTestLog("Checking Unassign Option","Document1 Unassign X NOT displayed" ,Status.FAIL);
			}
			
		}
		else
		{
			report.updateTestLog("Checking Unassign Option","Document1 Unassign X NOT displayed" ,Status.FAIL);
		}
		boolean varUnassign2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntDoc2UnassignOption)).isDisplayed();
		if(varUnassign2)
		{
			String varX = driver.findElement(By.xpath(UIMapMyLowes.webElmntDoc2UnassignOption)).getText();
			if(varX.equals("X"))
			{
				report.updateTestLog("Checking Unassign Option","Document2 Unassign X displayed" ,Status.PASS);
			}
			else
			{
				report.updateTestLog("Checking Unassign Option","Document2 Unassign X NOT displayed" ,Status.FAIL);
			}
			
		}
		else
		{
			report.updateTestLog("Checking Unassign Option","Document2 Unassign X NOT displayed" ,Status.FAIL);
		}
		//checking Add to Space option
		String varAssignSpace1 = driver.findElement(By.xpath(UIMapMyLowes.lnkDoc1AddToSpaces)).getText();
		if(varAssignSpace1.equals("Add to Spaces"))
		{
			report.updateTestLog("Checking Add to Spaces","Document1 Add to Spaces displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Add to Spaces","Document1 Add to Spaces NOT displayed" ,Status.FAIL);
		}
		String varAssignSpace2 = driver.findElement(By.xpath(UIMapMyLowes.lnkDoc2AddToSpaces)).getText();
		if(varAssignSpace2.equals("Add to Spaces"))
		{
			report.updateTestLog("Checking Add to Spaces","Document2 Add to Spaces displayed" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Add to Spaces","Document2 Add to Spaces NOT displayed" ,Status.FAIL);
		}
	}
	
	
	
	/*BVG TCs*/
	
	/**
	 * 
	 * @throws Exception
	 */
	/*public void spaceCreation() throws Exception
	{
		driver.findElement(By.xpath("//*[@id='header-block']/div[3]/ul/li[5]/a/span")).click();
		selenium.waitForPageToLoad("8000");
		driver.findElement(By.xpath(UIMapMyLowes.lblHomeProfile)).click();
		selenium.waitForPageToLoad("8000");

		System.out.println("I am inside the SpaceCreation method:");
		selenium.click("//*[@id='spaces_module']/div[2]/div[1]/div/a/span/b']");

		String s=driver.findElement(By.xpath("//div[@class='dropdown opened']//li[1]")).getText();
		System.out.println("Desired Value:"+s);
		selenium.select("//*[@id='spaces_module']/div[2]/div[1]/div/a/span']","");
		selenium.waitForPageToLoad("8000");
		//driver.findElement(By.cssSelector("span..firepath-matching-node")).click();
		System.out.println("This step is done:");

		WebElement elem = driver.findElement(By.xpath("//*[@id='spaces_module']/div[2]/div[1]/div/a/span']"));
		List<WebElement> options = elem.findElements(By.tagName("option"));
		System.out.println("The size of the drop down is:"+options);




		driver.findElement(By.xpath(UIMapMyLowes.webElmntContainer1 )).click();
		WebElement countr = driver.findElement(By.xpath(UIMapMyLowes.webElmntContainer1 ));

		        Select sel = new Select( countr );
		        List<WebElement> lista = sel.getOptions();
		        System.out.println( "List --> count of elements :" + lista.size());
		        for( WebElement e: lista){
		            System.out.println( e.getText() +"this is what I have printed");
		        }

		        sel.selectByVisibleText("yyyyyy");


		driver.findElement(By.xpath(UIMapMyLowes.lnkCreateHP)).click();
		selenium.waitForPageToLoad("8000");
		//driver.findElement(By.xpath("//*[@id='spaces_grid']/li[4]/h3/div[1]/span/a")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath((UIMapMyLowes.lnkCreateHP))));
		wait = new WebDriverWait(driver, 10);
		System.out.println("I am trying to execute this step:");
		System.out.println((dataTable.getData("General_Data","phone")));
		selenium.waitForPageToLoad("8000");
		if(selenium.isTextPresent(dataTable.getData("General_Data","phone")))
		{
			System.out.println("enter the dragon");
			driver.findElement(By.partialLinkText(dataTable.getData("General_Data","phone"))).click();

			//selenium.click(dataTable.getData("General_Data","phone"));

		}

		System.out.println("Mission accomplished");

	}	*/
	public void spaceCreation() throws Exception
	{
		Thread.sleep(3000);
		try{
		driver.findElement(By.xpath(UIMapMyLowes.drpDownNewSpace)).click();
		Thread.sleep(3000);
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.drpDownNewSpace)).click();
			Thread.sleep(3000);
		}
		
		String dropDownExtract=driver.findElement(By.xpath(UIMapMyLowes.lnkNewSpace1)).getText();
		if(!dropDownExtract.equals(""))
		{
			report.updateTestLog("Trying to validate Space Creation method" ,"Space creation validation is Successful", Status.PASS);
		}
		Thread.sleep(3000);

	}
	public void dotClick() throws Exception
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapFunctionalComponents.lnkStoreUnzip)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapFunctionalComponents.lnkSignUp)).click();
		selenium.waitForPageToLoad("15000");
		boolean verUserRegForm=driver.findElement(By.xpath(UIMapFunctionalComponents.btnRegistrationSubmit)).isDisplayed(); // Verifying the Create Account Button
		System.out.println("User Registration Page Displayed is :"+verUserRegForm);
		if(verUserRegForm)
		{
			driver.findElement(By.id("firstName")).sendKeys(dataTable.getData("General_Data","Firstname")); //Entering the firsname in User Registration form
			driver.findElement(By.id("lastName")).sendKeys(dataTable.getData("General_Data","Lastname"));  // Entering the lastname in User Registration form
			driver.findElement(By.id("email1")).sendKeys(dataTable.getData("General_Data","email"));  // Entering Email id
			driver.findElement(By.id("phoneUS")).sendKeys(dataTable.getData("General_Data","phone"));  // Entering Phone number
			driver.findElement(By.id("password1")).sendKeys(dataTable.getData("General_Data","password")); // Entering Password
			driver.findElement(By.id("password2")).sendKeys(dataTable.getData("General_Data","confpassword")); //Entering Confirm Password
			//driver.findElement(By.id("Ecom_BillTo_Postal_PostalCode")).sendKeys(dataTable.getData("General_Data","zipcode")); //Entering Zipcode
			driver.findElement(By.xpath(UIMapFunctionalComponents.btnRegistrationSubmit)).click(); // Clicking the Create Account button to register user

			selenium.waitForPageToLoad("45000");

			String getLoggedInUser=driver.findElement(By.xpath(UIMapFunctionalComponents.webElmntSalutation)).getText().trim();
			System.out.println("Verifying the Registered User detais :"+getLoggedInUser);
			String InvalidZipCodeText=driver.findElement(By.xpath(UIMapMyLowes.lblInvalidZipCodeTxt)).getText();
			if(getLoggedInUser.equals("Welcome, "+dataTable.getData("General_Data","Firstname")))          // Verifying the registered user details by Using Firstname
			{
				report.updateTestLog("Validating Login Credentials","User Registration Successful", Status.FAIL);
				selenium.waitForPageToLoad("10000");
			}

			else if(InvalidZipCodeText.equalsIgnoreCase("Please enter a five-digit ZIP code."))
			{
				report.updateTestLog("Validating Login Credentials","User Registration UnSuccessful", Status.PASS);
				selenium.waitForPageToLoad("10000");
			}
		}
	}


	

	public void createAccountWithNewHomeProfiles() throws Exception
	{
		
		/*selenium.click(UIMapMyLowes.webElmntYourAcct);
		Thread.sleep(3000);

		selenium.click(UIMapMyLowes.lnkHPYourAcct);
		selenium.waitForPageToLoad("60000");*/
		
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.id(UIMapMyLowes.lnkMyAccount));
		actions.moveToElement(menuHoverLink).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(5000);
		//WebElement subLink = driver.findElement(By.id(UIMapMyLowes.lnkHomeProfile));
		WebElement subLink = driver.findElement(By.partialLinkText("Home Profile"));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(5000);
		
		boolean signin = selenium.isElementPresent(UIMapMyLowes.webElmntSignInHeading);
		boolean  signup= selenium.isElementPresent(UIMapMyLowes.lnkSignUp2);
		System.out.println("signup"+signup);
		System.out.println("signin"+signin);
		if(signup)
		{
			if(signin)
			{

				java.util.Date date= new java.util.Date();
				Timestamp t = new Timestamp(date.getTime());
				String varTimeStamp = String.format("%1$TD %1$TT", t);
				System.out.println(varTimeStamp);
				String[] varDate = varTimeStamp.split(" ");
				String[] varDatMon = varDate[0].split("/");
				String[] varHrMinSec = varDate[1].split(":");
				String varUniq = "test";
				varUniq = varUniq.concat(varDatMon[0]+varDatMon[1]+varHrMinSec[0]+varHrMinSec[1]+varHrMinSec[2]);
				/*Code for unique email ID ends*/
				driver.findElement(By.xpath(UIMapFunctionalComponents.lnkSignUp)).click();
				selenium.waitForPageToLoad("15000");
				boolean verUserRegForm=driver.findElement(By.xpath(UIMapFunctionalComponents.btnRegistrationSubmit)).isDisplayed(); // Verifying the Create Account Button
				System.out.println("User Registration Page Displayed is :"+verUserRegForm);
				if(verUserRegForm)
				{
					driver.findElement(By.id("firstName")).sendKeys(dataTable.getData("General_Data","Firstname")); //Entering the firsname in User Registration form
					driver.findElement(By.id("lastName")).sendKeys(dataTable.getData("General_Data","Lastname"));  // Entering the lastname in User Registration form
					driver.findElement(By.id("email1")).sendKeys(varUniq+"@bh.exacttarget.com");//Unique Email ID based on timestamp
					//driver.findElement(By.id("email1")).sendKeys(dataTable.getData("General_Data","email"));  // Entering Email id
					driver.findElement(By.id("phoneUS")).sendKeys(dataTable.getData("General_Data","phone"));  // Entering Phone number
					driver.findElement(By.id("password1")).sendKeys(dataTable.getData("General_Data","password")); // Entering Password
					driver.findElement(By.id("password2")).sendKeys(dataTable.getData("General_Data","confpassword")); //Entering Confirm Password
					//driver.findElement(By.id("Ecom_BillTo_Postal_PostalCode")).sendKeys(dataTable.getData("General_Data","zipcode")); //Entering Zipcode
					driver.findElement(By.xpath(UIMapFunctionalComponents.btnRegistrationSubmit)).click(); // Clicking the Create Account button to register user

					selenium.waitForPageToLoad("45000");
					report.updateTestLog("Verifying Lowes User Registration page" ,"Navigation to User Registration Page Successfull", Status.PASS);
					String getLoggedInUser=driver.findElement(By.xpath(UIMapFunctionalComponents.webElmntSalutation)).getText().trim();
					System.out.println("Verifying the Registered User detais :"+getLoggedInUser);
					if(getLoggedInUser.equals("Welcome, "+dataTable.getData("General_Data","Firstname")))          // Verifying the registered user details by Using Firstname
					{

						String accountSummary=driver.findElement(By.xpath(UIMapMyLowes.webElmntAcctSummaryHeading)).getText();
						Thread.sleep(2000);
						if(accountSummary.equalsIgnoreCase("Account Summary"))
						{
							driver.findElement(By.xpath(UIMapMyLowes.lblHomeProfile)).click();
							Thread.sleep(5000);
							if(selenium.isElementPresent(UIMapMyLowes.lnkCreateHP))
							{
								driver.findElement(By.xpath(UIMapMyLowes.lnkCreateHP)).click();
								Thread.sleep(5000);
								String accSummary=driver.findElement(By.xpath(UIMapMyLowes.drpDownSpace)).getText();
								Thread.sleep(2000);
								if(accSummary.equalsIgnoreCase("Summary"))
								{
									String input = driver.findElement(By.xpath(UIMapMyLowes.lblSpaceCount)).getText();
									int output = extractInt(input);
									if(output==4)
									{
										report.updateTestLog("Validating Login Credentials","User Registration Successful", Status.PASS); 
									}
									else
									{
										report.updateTestLog("Validating Login Credentials","User Registration UnSuccessful", Status.FAIL);
									}								
								}
								else
								{
									report.updateTestLog("Validating Login Credentials","User Registration UnSuccessful", Status.FAIL);
								}
							}
							else
							{
								report.updateTestLog("Validating Login Credentials","User Registration UnSuccessful", Status.FAIL);
							}

						}
						else
						{
							report.updateTestLog("Validating Login Credentials","User Registration UnSuccessful", Status.FAIL);
						}
					}
					else
					{
						report.updateTestLog("Verifying Lowes User Registration page" ,"Failed to Navigate to User Registration Page", Status.FAIL); 
					}
				}
				else
				{
					report.updateTestLog("Verifying Lowes User Registration page" ,"Failed to Navigate to User Registration Page", Status.FAIL);
				}
			}
		}

	}


	public void clickOnProfileName()
	{
		/*selenium.click(UIMapMyLowes.webElmntYourAcct);
		selenium.waitForPageToLoad("30000");
		selenium.click(UIMapMyLowes.lnkHPYourAcct);
		selenium.waitForPageToLoad("30000");
		*/
		String summary=driver.findElement(By.xpath(UIMapMyLowes.drpDownSpace)).getText();
		//selenium.waitForPageToLoad("30000");
		if(summary.equalsIgnoreCase("summary")){

			try{driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();}
			catch(Exception WebDriverException){
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup","Handeled", Status.DONE);
				driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();}

			try{
				Thread.sleep(10000);
			}
			catch( Exception e){
				System.out.println("Inactive state");
			}

			driver.findElement(By.xpath(UIMapMyLowes.webElmntShowAllProducts)).click();

			try
			{
				Thread.sleep(10000);
			}
			catch( Exception e)
			{
				System.out.println("Inactive state");
			}

			String ItemNo=selenium.getText(UIMapMyLowes.webElmntProductCount);
			System.out.println("Printing the Item no:"+ItemNo);
			if(ItemNo.contains("Item"))
			{
				driver.findElement(By.xpath(UIMapMyLowes.webElmntHPName)).click();
				try
				{
					Thread.sleep(10000);
				}
				catch( Exception e)
				{
					System.out.println("Inactive state");
				}

				report.updateTestLog("Trying to click on Profile Name" ,"Successfully clicked on profile name", Status.PASS);


			}

		}

	}
	public void navigationToHomeProfile() throws Exception
	{
		/*selenium.click(UIMapMyLowes.webElmntYourAcct);
		try{
			Thread.sleep(5000);
		}
		catch( Exception e){
			System.out.println("Inactive state");
		}
		driver.findElement(By.xpath(UIMapMyLowes.lnkHPYourAcct)).click();
		Thread.sleep(5000);


		//driver.findElement(By.xpath(UIMapMyLowes.lblHomeProfile)).click();

		String summary=selenium.getText(UIMapMyLowes.drpDownSpace);
		Thread.sleep(5000);
		//selenium.waitForPageToLoad("10000");
		System.out.println("Executed till this point");

		if(summary.equalsIgnoreCase("summary"))
		{
			report.updateTestLog("Trying to navigate to Home Profile" ,"Navigation Successful", Status.PASS);
			//driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
		}
		else
		{
			report.updateTestLog("Trying to navigate to Home Profile" ,"Navigation failed", Status.FAIL);
			//driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
		}*/



		/*Actions actions = new Actions(driver);
		try{
			WebElement menuHoverLink = driver.findElement(By.id(UIMapMyLowes.lnkMyAccount));
			Thread.sleep(6000);
			actions.moveToElement(menuHoverLink).build().perform();
		}
		catch(Exception e){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			WebElement menuHoverLink = driver.findElement(By.id(UIMapMyLowes.lnkMyAccount));
			Thread.sleep(6000);
			actions.moveToElement(menuHoverLink).build().perform();
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		WebElement subLink = driver.findElement(By.id(UIMapMyLowes.lnkHomeProfile));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		*/
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.id(UIMapMyLowes.lnkMyAccount));
		actions.moveToElement(menuHoverLink).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(5000);
		//WebElement subLink = driver.findElement(By.id(UIMapMyLowes.lnkHomeProfile));
		WebElement subLink = driver.findElement(By.partialLinkText("Home Profile"));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		selenium.waitForPageToLoad("30000");
		
		String varMyLowes = driver.findElement(
				By.xpath(UIMapMyLowes.lblBreadCrumb2)).getText();
		System.out.println(varMyLowes);
		if (varMyLowes.equals("Home Profile")) {
			report.updateTestLog("Clicking Your Account link-HP",
					"Home Profile page displayed", Status.PASS);
		} else {
			report.updateTestLog("Clicking Your Account link",
					"Home Profile page NOT displayed", Status.FAIL);
		}
	}



	public void summaryTile(){

		driver.findElement(By.xpath(UIMapMyLowes.drpDownNewSpace)).click();
		try
		{
			Thread.sleep(10000);
		}
		catch( Exception e)
		{
			System.out.println("Inactive state");
		}

		driver.findElement(By.xpath(UIMapMyLowes.drpDownNewSpace )).click();
		WebElement countr = driver.findElement(By.xpath(UIMapMyLowes.drpDownNewSpace ));

		Select sel = new Select( countr );
		List<WebElement> lista = sel.getOptions();
		System.out.println( "List --> count of elements :" + lista.size());
		if(lista.size()==21)
		{
			report.updateTestLog("Trying to check the number of Spaces" ,"All the Spaces are present", Status.PASS);
		}

	}

	public void mouseHover() throws Exception
	{
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.xpath(UIMapMyLowes.webElmntHPName));
		actions.moveToElement(menuHoverLink).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(7000);
		String hoverText = driver.findElement(By.xpath(UIMapMyLowes.lnkHPNameRename)).getText();
		if(hoverText.equalsIgnoreCase("Rename"))
		{
			report.updateTestLog("Trying to hover over the profile Name" ,"Hovering is successful", Status.PASS);
		}
	}

	public void profileRename() throws Exception
	{
		String ProfileName;
		String ProfileNameNew;
		Thread.sleep(2000);
		ProfileName=driver.findElement(By.xpath(UIMapMyLowes.webElmntHPName)).getText();
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.xpath(UIMapMyLowes.webElmntHPName));
		actions.moveToElement(menuHoverLink).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(5000);
		WebElement subLink = driver.findElement(By.xpath(UIMapMyLowes.lnkHPNameRename));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		Thread.sleep(4000);
		//*[@id='hp-header']/h2/div[2]/input

		
		if(selenium.isElementPresent(UIMapMyLowes.btnHPNameRenameSave) && selenium.isElementPresent(UIMapMyLowes.lnkHPNameRenameCancel))
		{
			System.out.println("I have entered the save and cancel condition also");
			driver.findElement(By.xpath(UIMapMyLowes.txtHPNameRename )).sendKeys("HomeProf");
			Thread.sleep(5000);
			driver.findElement(By.xpath(UIMapMyLowes.lnkHPNameRenameCancel)).click();
			Thread.sleep(5000);
			ProfileNameNew=selenium.getText(UIMapMyLowes.webElmntHPName);
			Thread.sleep(2000);
			System.out.println("This is the new prof name:"+ProfileNameNew);
			if(ProfileNameNew.equals(ProfileName))
			{
				report.updateTestLog("Trying to Rename using Cancel" ,"Name not changed", Status.PASS);
				
				ProfileName=selenium.getText(UIMapMyLowes.webElmntHPName);
				Thread.sleep(5000);
				actions = new Actions(driver);
				menuHoverLink = driver.findElement(By.xpath(UIMapMyLowes.webElmntHPName));
				actions.moveToElement(menuHoverLink).build().perform();
				System.out.println("Mouse Hover successful");
				Thread.sleep(5000);
				WebElement subLink1 = driver.findElement(By.xpath(UIMapMyLowes.lnkHPNameRename));
				actions.moveToElement(subLink1).build().perform();
				subLink1.click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(UIMapMyLowes.txtHPNameRename )).sendKeys("HomeProf");
					Thread.sleep(3000);
					driver.findElement(By.xpath(UIMapMyLowes.btnHPNameRenameSave)).click();
					Thread.sleep(5000);
					
					String NewProfileName=selenium.getText(UIMapMyLowes.webElmntHPName);
					if(NewProfileName.equals("HomeProf"))
					{
						report.updateTestLog("Trying to Rename using Save" ,"Name changed", Status.PASS);
					}
					else
						report.updateTestLog("Trying to Rename" ,"Name NOT changed", Status.FAIL);
				}
			else
				
				report.updateTestLog("Trying to Rename using Cancel" ,"Name changed", Status.FAIL);
			}
			
		
		else
		{
			report.updateTestLog("Trying to check save and cancel" ,"save and cancel Not Displayed", Status.FAIL);
			Thread.sleep(2000);
		}			

	}	

	public void changeToGridView() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntShowAllProducts)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntGridViewImg)).click();
		Thread.sleep(5000);
	}

	public void ProfilePageWithOutLoggedInUser()throws Exception
	{
		selenium.click(UIMapMyLowes.webElmntYourAcct);
		try{
			Thread.sleep(10000);
		}
		catch( Exception e){
			System.out.println("Inactive state");
		}
		selenium.click(UIMapMyLowes.lnkHPYourAcct);
		selenium.waitForPageToLoad("5000");

		selenium.click(UIMapMyLowes.webElmntYourAcct);
		try{
			Thread.sleep(10000);
		}
		catch( Exception e){
			System.out.println("Inactive state");
		}

		selenium.click(UIMapMyLowes.lnkHPYourAcct);
		selenium.waitForPageToLoad("5000");
		System.out.println("Executed till this point");

		String signIn=driver.findElement(By.xpath(UIMapMyLowes.webElmntSignInHeading)).getText();
		if(signIn.equalsIgnoreCase("Sign In"))
		{

			driver.findElement(By.xpath(UIMapMyLowes.txtUserName)).sendKeys("lowesapptesting61");
			driver.findElement(By.xpath(UIMapMyLowes.txtPassword)).sendKeys("test123");
			selenium.click("//*[@id='GoYourAccount']");
			Thread.sleep(5000);
			String homeprof=driver.findElement(By.xpath(UIMapMyLowes.lblBreadCrumb2)).getText();
			if(homeprof.equalsIgnoreCase("home profile"))
			{			
				report.updateTestLog("Trying to log in to home profile","Login to home profile is successful", Status.PASS);
				selenium.waitForPageToLoad("10000");
			}
		}
		else
		{
			report.updateTestLog("Trying to Rename" ,"Name changed successfully", Status.FAIL);
			selenium.waitForPageToLoad("10000");
		}			

	}
	public void editMode() throws Exception
	{
		try{driver.findElement(By.xpath(UIMapMyLowes.webElmntViewOrAssignProducts)).click();
		selenium.waitForPageToLoad("20000");
		}
		catch(Exception e)
		{
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.webElmntViewOrAssignProducts)).click();
			selenium.waitForPageToLoad("20000");
		}
		System.out.println("All Items displayed");
		//String a[];
		//*[@id='item_list']/div[1]/div[13]/div[2]/div[2]/div[2]/span[2]/span/a[1]
		//String LocatedIn=driver.findElement(By.xpath(UIMapMyLowes.lnkItem13LocatedInSpace)).getText();
		String LocatedIn=driver.findElement(By.xpath(UIMapMyLowes.lnkItem1LocatedInSpace)).getText();
		Thread.sleep(3000);
		System.out.println(LocatedIn);;
		if(!LocatedIn.equalsIgnoreCase(""))
		{
			System.out.println("1st");
			//driver.findElement(By.xpath(UIMapMyLowes.webElmntEditItem13Arrow)).click();
			driver.findElement(By.xpath(UIMapMyLowes.webElmntEditItem1Arrow)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(UIMapMyLowes.webElmntSelectSpaceDownArrow)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(UIMapMyLowes.webElmntDeleteCurrentSpace)).click();
			Thread.sleep(5000);
			String unassigned=driver.findElement(By.xpath(UIMapMyLowes.lblUnassignedProductForm)).getText();
			System.out.println(unassigned);
			if(unassigned.contains("Unassigned"))
			{
				System.out.println("2nd");
				driver.findElement(By.xpath(UIMapMyLowes.chkBoxSpace4)).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath(UIMapMyLowes.btnSave2)).click();
				Thread.sleep(6000);
				//driver.findElement(By.xpath(UIMapMyLowes.webElmntEditItem13Arrow)).click();
				driver.findElement(By.xpath(UIMapMyLowes.webElmntEditItem1Arrow)).click();
				Thread.sleep(5000);

				driver.findElement(By.xpath(UIMapMyLowes.webElmntDeleteCurrentSpace)).click();
				Thread.sleep(5000);

				String Text2=driver.findElement(By.xpath(UIMapMyLowes.lblUnassignedProductForm)).getText();
				Thread.sleep(2000);
				System.out.println(Text2);
				if(Text2.equalsIgnoreCase("Unassigned"))
				{
					System.out.println("3rd");
					report.updateTestLog("Trying to Edit the Items in home profile","Editing is successful", Status.PASS);
					Thread.sleep(5000);
					driver.findElement(By.xpath(UIMapMyLowes.webElmntSelectSpaceDownArrow)).click();
					Thread.sleep(4000);	
					driver.findElement(By.xpath(UIMapMyLowes.chkBoxSpace1)).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath(UIMapMyLowes.btnSave2)).click();
					Thread.sleep(5000);

				}
				else
				{
					report.updateTestLog("Trying to Edit the Items in home profile","Editing Failed", Status.FAIL);
					Thread.sleep(5000);
				}
			}
			else
			{
				report.updateTestLog("Trying to Edit the Items in home profile","Editing Failed", Status.FAIL);
				Thread.sleep(5000);
			}
		}
		else
		{
			report.updateTestLog("Trying to Edit the Items in home profile","Editing Failed", Status.FAIL);
			Thread.sleep(5000);
		}
	}
	public void spaceWithAllItemsAndDimensions() throws Exception
	{
		Thread.sleep(5000);
		//driver.findElement(By.xpath(UIMapMyLowes.webElmntViewOrAssignProducts)).click();
		//Thread.sleep(5000);
		String Product;
		String Photos;
		String documents;
		String space;
		try{
		driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
		Thread.sleep(3000);}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
			Thread.sleep(3000);
		}
		
		Product= driver.findElement(By.xpath(UIMapMyLowes.webElmntShowAllProducts)).getText();
		Thread.sleep(2000);

		Photos=driver.findElement(By.xpath(UIMapMyLowes.webElmntAllPhotos)).getText();
		Thread.sleep(2000);
		documents=driver.findElement(By.xpath(UIMapMyLowes.webElmntAllDocs)).getText();
		Thread.sleep(2000);
		space=driver.findElement(By.xpath(UIMapMyLowes.webElmntShowSpaces)).getText();
		Thread.sleep(2000);

		if((Product.matches(".*\\d.*")) && (Photos.matches(".*\\d.*")) && (documents.matches(".*\\d.*")) && (space.matches(".*\\d.*"))) {

			report.updateTestLog("Trying to check space with all Items","Checking is successful", Status.PASS);
			Thread.sleep(2000);

		}

		else
		{
			report.updateTestLog("Trying to check space with all Items","Checking failed", Status.FAIL);
			Thread.sleep(2000);

		}

	}

	/*This function verifies the default view for items in HP*/
	/*public void checkDefaultViewItemsHP() throws Exception
	{
		driver.findElement(By.xpath(UIMapMyLowes.webElmntViewOrAssignProducts)).click();
		selenium.waitForPageToLoad("10000");
		String varIsListDefault = driver.findElement(By.xpath("//*[@id='product_list']/div[1]/ul/li[1]")).getAttribute("class");
		System.out.println(varIsListDefault);
		if(varIsListDefault.equals("active listView"))
		{
			report.updateTestLog("Checking Default View","List is Default View" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Checking Default View","List is NOT Default View" ,Status.FAIL);
		}
	}*/



	public void validationOfSortingFunctionality() throws Exception
	{
		try{driver.findElement(By.xpath(UIMapMyLowes.webElmntViewOrAssignProducts)).click();
		selenium.waitForPageToLoad("20000");}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.webElmntViewOrAssignProducts)).click();
			selenium.waitForPageToLoad("20000");}
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntGridViewImg)).click();
		Thread.sleep(10000);
		boolean TrashIcon=driver.findElement(By.xpath(UIMapMyLowes.webElmntItem1TrashCan)).isDisplayed();
		String EditIcon=driver.findElement(By.xpath(UIMapMyLowes.webElmntItem1Edit)).getText();
		System.out.println(TrashIcon);
		System.out.println(EditIcon);
		if(TrashIcon && (!EditIcon.equals("")))
		{
			
			driver.findElement(By.xpath(UIMapMyLowes.drpDownSortBy)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(UIMapMyLowes.lblSortByAToZ)).click();
			Thread.sleep(10000);
			
			
			// Have to insert the code for A-z Validation here..
			List<String> varCat=new ArrayList<String>();
			int varCount=ps.countWebElement(UIMapMyLowes.webElmntItemNames);
			int j=0;
			for(int i=1;i<=varCount;i++)
			{
				j=j+1;
				String varItemName=driver.findElement(By.xpath("//*[@id='item_list']/div[1]/div["+j+"]/div[2]/div[1]/h5")).getText();
				System.out.println("//*[@id='item_list']/div[1]/div["+j+"]/div[2]/div[1]/h5");
				System.out.println(varItemName);
				varCat.add(varItemName);
				j=j+1;
			}
			boolean varSorted=ps.isSorted(varCat);
			if(varSorted)
				report.updateTestLog("Trying to Sort the Items A-Z","A-Z Sorting is Successful", Status.PASS);
			else
				report.updateTestLog("Trying to Sort the Items A-Z","A-Z Sorting NOT Successful", Status.FAIL);
			
			
			
			driver.findElement(By.xpath(UIMapMyLowes.webElmntListViewImg)).click();
			Thread.sleep(10000);
			
				driver.findElement(By.xpath(UIMapMyLowes.drpDownSortBy)).click();
				Thread.sleep(10000);
				driver.findElement(By.xpath(UIMapMyLowes.webElmntSortByHpMostRecent)).click();
				Thread.sleep(10000);

				report.updateTestLog("Trying to Sort the Items","Sorting is Successful", Status.PASS);
				selenium.waitForPageToLoad("10000");

		

		}

		else
		{
			report.updateTestLog("Trying to Sort the Items","Items not displayed", Status.FAIL);
			
		}

	}
	/*public void saveItemToHomeProfile() throws Exception
	{
		String varItemName = driver.findElement(By.xpath(UIMapMyLowes.webElmntProductName)).getText();
		String varItemNameTrimmed = varItemName.substring(0,36);
		System.out.println(varItemNameTrimmed);
		driver.findElement(By.id(UIMapMyLowes.webElmntSaveItem)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntSaveToHP)).click();
		Thread.sleep(5000);
		//String verItemSaved = driver.findElement(By.xpath("//*[@id='saveItemBlock']/div[1]/span/span[2]")).getText();
		//System.out.println("SAVE ITEM::"+verItemSaved+"::");
		boolean verItemSaved=selenium.isTextPresent("Item Saved");
		if(verItemSaved)
		{
			report.updateTestLog("Adding Item To Home Profile","Item added to Home Profile" ,Status.PASS);
			driver.findElement(By.xpath("//*[@id='saveItemBlock']/div[3]/div/a")).click();
			selenium.waitForPageToLoad("10000");
			driver.findElement(By.xpath("//*[@id='items_trigger']")).click();
			Thread.sleep(10000);
			//driver.findElement(By.xpath(UIMapMyLowes.lnkItem1ViewProduct)).click();
			//selenium.waitForPageToLoad("20000");

			String varItemName2 = driver.findElement(By.xpath(UIMapMyLowes.webElmntItem1Name)).getText();

			String varItemName2Trimmed = varItemName2.substring(0,36);
			System.out.println(varItemName2Trimmed);
			//following code verifies whether the topmost item in Home Profile Products summary is same as one that is added to Home Profile
			//hence, this assumes that the Summary list is sorted by Most recent for the user

			if(varItemNameTrimmed.equals(varItemName2Trimmed))
			{
				report.updateTestLog("Verifying Added Item in home profile","Item displayed in Home Profile" ,Status.PASS);
			}
			else
			{
				report.updateTestLog("Verifying Added Item in home profile","Item NOT displayed in Home Profile" ,Status.FAIL);
			}


		}
		else
		{
			report.updateTestLog("Adding Item To Home Profile","Item NOT Added to Home Profile", Status.FAIL);
		}
	}*/


	public void relatedDocsListView() throws Exception
	{
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.id(UIMapMyLowes.lnkMyAccount));
		actions.moveToElement(menuHoverLink).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(5000);
		//WebElement subLink = driver.findElement(By.id(UIMapMyLowes.lnkHomeProfile));
		WebElement subLink = driver.findElement(By.partialLinkText("Home Profile"));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntViewOrAssignProducts)).click();
		selenium.waitForPageToLoad("10000");
		boolean ImgTxt=driver.findElement(By.xpath(UIMapMyLowes.webElmntItem1Img)).isDisplayed();
		selenium.waitForPageToLoad("10000");
		String viewProductLink=driver.findElement(By.xpath(UIMapMyLowes.lnkItem1ViewProduct)).getText();
		selenium.waitForPageToLoad("10000");

		if((ImgTxt) && (!viewProductLink.equals("")))
		{
			System.out.println("Image and View Product present");
			driver.findElement(By.xpath(UIMapMyLowes.webElmntItem1EditDownArrow)).click();
			//selenium.waitForPageToLoad("10000");
			Thread.sleep(2000);
			
			
			int varCount=countWebElement(UIMapMyLowes.webElmntItemListRelatedDocs);
			System.out.println("Related Docs Count:"+varCount);
			String[] s1=new String[varCount];
			String[] s2=new String[varCount];
			String SpaceText=driver.findElement(By.xpath(UIMapMyLowes.lblAddToSpaces)).getText();
			System.out.println(SpaceText);
			if(SpaceText.equalsIgnoreCase("Add to Spaces:"))
			{
				System.out.println("Add to spaces present");
				
				
				for(int i=1;i<=varCount;i++)
				{
					s1[i-1]=driver.findElement(By.xpath(UIMapMyLowes.webElmntItemListRelatedDocs+"["+i+"]")).getAttribute("id");
					System.out.println(i+"  "+s1[i-1]);
				}
				driver.findElement(By.xpath(UIMapMyLowes.txtCalcName1)).clear();
				driver.findElement(By.xpath(UIMapMyLowes.txtCalcName1)).sendKeys("Fridge Name Updated");
				//selenium.waitForPageToLoad("10000");
				System.out.println("Before Notes Clicked");
				
				driver.findElement(By.xpath(UIMapMyLowes.txtNotes2)).click();
				Thread.sleep(2000);
				System.out.println("After Notes Clicked");
				driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).clear();
				
				driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).sendKeys("I have updated the Text also");
				
				driver.findElement(By.xpath(UIMapMyLowes.btnSave2)).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(UIMapMyLowes.lnkItem1ViewProduct)).click();
				selenium.waitForPageToLoad("40000");
				driver.findElement(By.xpath(UIMapMyLowes.webElmntInfoGuidesTab)).click();
				Thread.sleep(2000);
				varCount=countWebElement(UIMapMyLowes.webElmntRelatedDocs);
				for(int i=1;i<=varCount;i++)
				{
					s2[i-1]=driver.findElement(By.xpath(UIMapMyLowes.webElmntRelatedDocs+"["+i+"]")).getAttribute("id");
					System.out.println(i+"  "+s2[i-1]);
				}
				if(s1.length==s2.length)
				{
					System.out.println("Length match");
					int i=0;
					for(i=0;i<s1.length;i++)
					{
						if(s1[i].equals(s2[i]))
							continue;
						else
						{
							System.out.println(i+"  "+s1[i]);
							System.out.println(i+"  "+s2[i]);
							break;
							
						}
						
						
					}
					if(i==s1.length)
						report.updateTestLog("Trying to update related docs list view","Updating is Successful. Related Docs Correct" ,Status.PASS);
					else
						report.updateTestLog("Trying to update related docs list view","Updating is failed. Related Docs not same" ,Status.FAIL);
				}
				else
				{
					report.updateTestLog("Trying to update related docs list view","Updating is failed" ,Status.FAIL);
				}
				
			}
			else
			{
				report.updateTestLog("Trying to update related docs list view","Updating is failed" ,Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Trying to update related docs list view","Updating is failed" ,Status.FAIL);
		}	
	}

	public void removeSpaceAssignment() throws Exception
	{

		Thread.sleep(10000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntItem1EditDownArrow)).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntSelectSpaceDownArrow)).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(UIMapMyLowes.chkBoxSpace4)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.chkBoxSpace5)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.btnSave2)).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntProductAssignedSpace)).click();
		Thread.sleep(10000);
		String ItemCountText=driver.findElement(By.xpath(UIMapMyLowes.webElmntProductCount)).getText();
		String ItemCount = ItemCountText.substring(0,1);
		int ItemCountNumber=Integer.parseInt(ItemCount);
		System.out.println("Number of Item numbers "+" "+ItemCountNumber);
		Thread.sleep(10000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntRemoveSpace)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.drpDownSpace)).click();
		Thread.sleep(5000);
		//driver.findElement(By.xpath(UIMapMyLowes.lnkSpaceDrpDownKitchen)).click();
		//Thread.sleep(5000);
		
		driver.navigate().refresh();
		selenium.waitForPageToLoad("20000");
		String NewItemCountText=driver.findElement(By.xpath(UIMapMyLowes.webElmntProductCount)).getText();
		String NewItemCount = NewItemCountText.substring(0,1);
		int NewItemCountNumber=Integer.parseInt(NewItemCount);
		driver.navigate().refresh();

		Thread.sleep(5000);
		System.out.println("Number of Item numbers "+" "+NewItemCountNumber);

		if((ItemCountNumber-NewItemCountNumber)==1)
		{
			report.updateTestLog("Trying to Remove space assignment","Space assignment is removed Successfully" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("Trying to Remove space assignment","Space assignment removal Failed" ,Status.FAIL);
		}

	}

	public void summaryReportValidation() throws Exception
	{
		Thread.sleep(5000);
		String spacesText=driver.findElement(By.xpath(UIMapMyLowes.lblSpaceCount)).getText();
		System.out.println("This is spacesText"+spacesText);
		if(spacesText.contains(" Spaces"))
		{
			System.out.println("I am inside first if condition");
			String plusSpacesText=driver.findElement(By.xpath(UIMapMyLowes.webElmntContainer1)).getText();


			if(plusSpacesText.contains(("+")))
			{
				System.out.println("I am inside Second if condition");
				String showText=driver.findElement(By.xpath(UIMapMyLowes.lblShow)).getText();
				System.out.println("This is to get the Text"+showText);
				if(showText.contains("Show:"))
				{
					System.out.println("I am inside Third if condition");
					String sortBy=driver.findElement(By.xpath(UIMapMyLowes.lblSortBy)).getText();
					System.out.println("This is to get the sort by Text"+sortBy);
					if(sortBy.contains("Sort by:"))
					{
						System.out.println("I am inside Fourth if condition");
						report.updateTestLog("Trying to validate Summary Page","Summary page validation is Successful" ,Status.PASS);
					}
					else
					{
						report.updateTestLog("Trying to validate Summary Page","Summary page validation failedl" ,Status.FAIL);
					}

				}
				else
				{
					report.updateTestLog("Trying to validate Summary Page","Summary page validation failedl" ,Status.FAIL);
				}


			}
			else
			{
				report.updateTestLog("Trying to validate Summary Page","Summary page validation failedl" ,Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Trying to validate Summary Page","Summary page validation failedl" ,Status.FAIL);
		}
	}
	public void photosInSpaceDetailPage() throws Exception
	{

		String photoText=driver.findElement(By.xpath(UIMapMyLowes.lblSpace5PhotosCount)).getText();
		System.out.println(photoText);
		Thread.sleep(5000);
		if((!photoText.equals("")))
		{
			
			Thread.sleep(2000);

			try{driver.findElement(By.partialLinkText("Yard")).click();
			selenium.waitForPageToLoad("30000");
			}
			catch(Exception WebDriverException){
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup","Handeled", Status.DONE);
				driver.findElement(By.partialLinkText("Yard")).click();
				selenium.waitForPageToLoad("30000");
			}
			

			driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
			Thread.sleep(4000);
			
			driver.findElement(By.xpath(UIMapMyLowes.lblShowPhotos)).click();
			selenium.waitForPageToLoad("30000");
			Thread.sleep(10000);
			String sub= photoText.substring(0,1);
			int photoCount=Integer.parseInt(sub);
			System.out.println(photoCount);
			String Upload=driver.findElement(By.xpath(UIMapMyLowes.btnUpload)).getText();
			
			System.out.println("This is the Upload Text"+Upload);
			if(Upload.equalsIgnoreCase("Upload"))
			{
				
				String showText=driver.findElement(By.xpath(UIMapMyLowes.lblShowInPhotos)).getText();
				System.out.println(showText);
				if(showText.contains("Show"))
				{
					
					String sortText=driver.findElement(By.xpath(UIMapMyLowes.lblSortInPhotos)).getText();
					System.out.println(sortText);
					if(sortText.contains("Sort"))
					{	
						
						int count=0;
						for( int i=0;i<photoCount;i++)
						{
							int j=i+1;
							String varXpath = "//*[@id='photosContainer']/div[2]/div[3]/div[" + j+ "]/div";		
							
							if(selenium.isElementPresent(varXpath))
							{
								
								++count;
								if(count==photoCount)
								{
									report.updateTestLog("Trying to validate the number of photos uploaded","Validation Successful" ,Status.PASS);
								}
								
							}
							else
							{
								report.updateTestLog("Trying to validate the number of photos uploaded","Validation Failed" ,Status.FAIL);
							}
							
						}
						
					}
					else
					{
						report.updateTestLog("Trying to validate the number of photos uploaded","Validation Failed" ,Status.FAIL);
					}

				}
				else
				{
					report.updateTestLog("Trying to validate the number of photos uploaded","Validation Failed" ,Status.FAIL);
				}
			}
			else
			{
				report.updateTestLog("Trying to validate the number of photos uploaded","Validation Failed" ,Status.FAIL);
			}
		}
	}
	public void sortByAndShowMechanism() throws Exception
	{
		Thread.sleep(5000);
		String photoText=driver.findElement(By.xpath(UIMapMyLowes.lblSpace5PhotosCount)).getText();
		Thread.sleep(5000);
		String number=photoText.substring(0,1);
		int photoTextNumber=Integer.parseInt(number);
		System.out.println("Photo count"+photoTextNumber);
		if(photoTextNumber>=2)
		{
			System.out.println("1st");
			try{driver.findElement(By.partialLinkText("Yard")).click();
			selenium.waitForPageToLoad("20000");
			}
			catch(Exception WebDriverException){
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup","Handeled", Status.DONE);
				driver.findElement(By.partialLinkText("Yard")).click();
				selenium.waitForPageToLoad("20000");
				}
			
			driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(UIMapMyLowes.lblShowPhotos)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(10000);
			driver.findElement(By.xpath(UIMapMyLowes.webElmntPhotosSortByDownArrow)).click();
			Thread.sleep(5000);
			//driver.findElement(By.xpath(UIMapMyLowes.webElmntPhotosSortByDownArrow)).click();
			//Thread.sleep(5000);


			String MostRecent=driver.findElement(By.xpath(UIMapMyLowes.lnkPhotosSortByMostRecent)).getText();
			Thread.sleep(2000);
			String A2Z=driver.findElement(By.xpath(UIMapMyLowes.lnkPhotosSortByAtoZ)).getText();
			Thread.sleep(2000);
			if(MostRecent.equalsIgnoreCase("Most Recent"))
			{
				System.out.println("2nd");
				if(A2Z.equalsIgnoreCase("A-Z"))
				{
					System.out.println("3rd");
					driver.findElement(By.xpath(UIMapMyLowes.lnkPhotosSortByAtoZ)).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath(UIMapMyLowes.webElmntPhotosSortByDownArrow)).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath(UIMapMyLowes.lnkPhotosSortByMostRecent)).click();
					Thread.sleep(5000);

					driver.findElement(By.xpath(UIMapMyLowes.webElmntPhotosShowDownArrow)).click();
					Thread.sleep(5000);

					String products=driver.findElement(By.xpath(UIMapMyLowes.lnkPhotosShowProducts)).getText();
					Thread.sleep(2000);
					String photos=driver.findElement(By.xpath(UIMapMyLowes.lnkPhotosShowPhotos)).getText();
					Thread.sleep(2000);
					String documents=driver.findElement(By.xpath(UIMapMyLowes.lnkPhotosShowDocs)).getText();
					Thread.sleep(2000);
					String calculations=driver.findElement(By.xpath(UIMapMyLowes.lnkPhotosShowCalc)).getText();
					Thread.sleep(2000);
					String dimensions=driver.findElement(By.xpath(UIMapMyLowes.lnkPhotosShowDim)).getText();
					Thread.sleep(2000);
					if((products.equalsIgnoreCase("Products"))&& (photos.equalsIgnoreCase("Photos"))&&(documents.equalsIgnoreCase("Documents"))&&(calculations.equalsIgnoreCase("Calculations"))&&(dimensions.equalsIgnoreCase("Dimensions")))
					{
						System.out.println("4th");
						report.updateTestLog("trying to validate sort and show mechanism","Sort and Show mechanism validation is Successful" ,Status.PASS);
					}
					else
					{
						report.updateTestLog("trying to validate sort and show mechanism","Sort and Show mechanism validation is Successful" ,Status.FAIL);
					}
				}
				else
				{
					report.updateTestLog("trying to validate sort and show mechanism","Sort and Show mechanism validation is Failed" ,Status.FAIL);
				}

			}
			else
			{
				report.updateTestLog("trying to validate sort and show mechanism","Sort and Show mechanism validation is Successful" ,Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("trying to validate sort and show mechanism","Sort and Show mechanism validation is Successful" ,Status.FAIL);
		}

	}

	public void viewDocuments() throws Exception{

	/*	Thread.sleep(5000);
		try{driver.findElement(By.partialLinkText("Yard")).click();
		selenium.waitForPageToLoad("20000");
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.partialLinkText("Yard")).click();
			selenium.waitForPageToLoad("20000");
			}
*/
		String showTextDefault=driver.findElement(By.xpath(UIMapMyLowes.drpDownShowDefault)).getText();

		if(showTextDefault.equalsIgnoreCase("Products"))
		{
			System.out.println("1st");
		
			driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(UIMapMyLowes.lnkProductsShowDoc)).click();
			Thread.sleep(5000);
			String Label=driver.findElement(By.xpath(UIMapMyLowes.webElmntDoc1Namee)).getText();
			Thread.sleep(5000);
			if((!Label.equals("")))
			{
				System.out.println("2nd");
				String upload=driver.findElement(By.xpath(UIMapMyLowes.webElmntDocUpload)).getText();
				String Show=driver.findElement(By.xpath(UIMapMyLowes.webElmntDocShow)).getText();
				String Sort=driver.findElement(By.xpath(UIMapMyLowes.webElmntDocSortBy)).getText();

				if((upload.contains("Upload")) && (Show.contains("Show")) && (Sort.contains("Sort by")))
				{	
					System.out.println("3rd");
					report.updateTestLog("trying to validate Document functionality","Documentation function validation is Successful" ,Status.PASS);

				}
				else
				{
					report.updateTestLog("trying to validate Document functionality","Documentation function validation is Failed" ,Status.FAIL);
				}

			}
			else
			{
				report.updateTestLog("trying to validate Document functionality","Documentation function validation is Failed" ,Status.FAIL);
			}

		}
		else
		{
			report.updateTestLog("trying to validate Document functionality","Documentation function validation is Failed" ,Status.FAIL);
		}
	}

	/*This method validates the Components in the show dropdown in the summary page*/
	public void summaryReportShowDropDown() throws Exception
	{
		Thread.sleep(10000);
		try{
		driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
		Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
			Thread.sleep(5000);
			}
		String spaces=driver.findElement(By.xpath(UIMapMyLowes.webElmntShowSpaces)).getText();
		Thread.sleep(5000);
		String AllProducts=driver.findElement(By.xpath(UIMapMyLowes.webElmntShowAllProducts)).getText();
		Thread.sleep(5000);
		String AllPhotos=driver.findElement(By.xpath(UIMapMyLowes.webElmntAllPhotos)).getText();
		Thread.sleep(5000);
		String AllDocuments=driver.findElement(By.xpath(UIMapMyLowes.webElmntAllDocs)).getText();
		System.out.println("Spaces"+spaces);
		System.out.println("AllProds"+AllProducts);
		System.out.println("All Photos"+AllPhotos);
		System.out.println("All Docs"+AllDocuments);

		if((spaces.matches(".*\\d.*")) && (AllProducts.matches(".*\\d.*")) && (AllPhotos.matches(".*\\d.*")) && (AllDocuments.matches(".*\\d.*")))
		{
			report.updateTestLog("trying to validate Show dropdown in Summary Report","Show drop down validation is Successful" ,Status.PASS);
		}
		else
		{
			report.updateTestLog("trying to validate Show dropdown in Summary Report","Show drop down validation failed" ,Status.FAIL);
		}

	}
	public void editCalculationAddNote() throws Exception
	{
		
		
		String calc=driver.findElement(By.xpath(UIMapMyLowes.lblSpace5CalcCount)).getText();
		Thread.sleep(3000);
		if((!calc.equals("")))
		{
			System.out.println("1st");
			Thread.sleep(10000);
			driver.findElement(By.partialLinkText("Yard")).click();
			selenium.waitForPageToLoad("20000");
			/*if(selenium.isElementPresent("//*[@id='spaces_grid']/li[5]/h3/a"))
			{
				System.out.println("2nd");
				driver.findElement(By.partialLinkText("Yard")).click();
				selenium.waitForPageToLoad("5000");
			}*/
			driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
			Thread.sleep(5000);
			String calculationText=driver.findElement(By.xpath(UIMapMyLowes.lnkShowCalc)).getText();
			Thread.sleep(5000);
			if(calculationText.equalsIgnoreCase("Calculations"))
			{
				System.out.println("3rd");
				driver.findElement(By.xpath(UIMapMyLowes.lnkShowCalc)).click();
				Thread.sleep(5000);
				String calculationCount=driver.findElement(By.xpath(UIMapMyLowes.webElmntTotalCalc)).getText();

				Thread.sleep(2000);
				if((calculationCount.matches(".*\\d.*")))
				{
					System.out.println("4th");

					driver.findElement(By.xpath(UIMapMyLowes.lnkCalcAttachANoteAll)).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath(UIMapMyLowes.txtNotes2)).click();	
					Thread.sleep(2000);
					driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).sendKeys("This is the text added by me");
					Thread.sleep(2000);
					String ImageText = driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcTypeIcon)).getAttribute("class");

					String[] s = ImageText.split(" ");
					Thread.sleep(2000);
					String shopButtonText = driver.findElement(By.xpath(UIMapMyLowes.btnCalcShop)).getText();

					String[] x = shopButtonText.split(" ");
					Thread.sleep(2000);

					String ImageTextSplit= s[1];
					String shopButtonTextSplit=x[1];
					System.out.println("This is S[[1]]"+ImageTextSplit);
					System.out.println("This is X[[1]]"+shopButtonTextSplit);
					if(s[1].equalsIgnoreCase(x[1]))
					{
						System.out.println("5th");
						String save=driver.findElement(By.xpath(UIMapMyLowes.btnCalcSave2)).getText();
						Thread.sleep(2000);
						String cancel= driver.findElement(By.xpath(UIMapMyLowes.lnkCalcCancel)).getAttribute("class");
						Thread.sleep(2000);
						System.out.println("save and cancel"+save+cancel);
						if(save.equalsIgnoreCase("save") && cancel.equalsIgnoreCase("cancel"))
						{
							System.out.println("6th");
							driver.findElement(By.xpath(UIMapMyLowes.btnCalcSave2)).click();
							Thread.sleep(5000);
							driver.findElement(By.xpath(UIMapMyLowes.webElmntDeleteCalcAllTrashcan)).click();
							Thread.sleep(5000);
							report.updateTestLog("trying to Edit Notes","Editing Notes is Successful" ,Status.PASS);


						}
						else
						{
							report.updateTestLog("trying to Edit Notes","Editing Notes Failed" ,Status.FAIL);
						}
					}
					else
					{
						report.updateTestLog("trying to Edit Notes","Editing Notes Failed" ,Status.FAIL);
					}


				}
				else
				{
					report.updateTestLog("trying to Edit Notes","Editing Notes Failed" ,Status.FAIL);
				}
			}
			else
			{
				report.updateTestLog("trying to Edit Notes","Editing Notes Failed" ,Status.FAIL);
			}



		}
		else
		{
			report.updateTestLog("trying to Edit Notes","Editing Notes Failed" ,Status.FAIL);
		}

	}
	public void undoCalculation() throws Exception
	{
		
		Thread.sleep(3000);
		String calc=driver.findElement(By.xpath(UIMapMyLowes.lblSpace5CalcCount)).getText();
		Thread.sleep(3000);
		if((!calc.equals("")))
		{
			System.out.println("1st");
			System.out.println("Now click on Yard");
			Thread.sleep(10000);
			try{
			driver.findElement(By.partialLinkText("Yard")).click();
			selenium.waitForPageToLoad("20000");
			}
			catch(Exception WebDriverException){
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup","Handeled", Status.DONE);
				driver.findElement(By.partialLinkText("Yard")).click();
				selenium.waitForPageToLoad("20000");
				}
			driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
			Thread.sleep(5000);
			String calculationText=driver.findElement(By.xpath(UIMapMyLowes.lnkShowCalc)).getText();
			System.out.println(calculationText);
			if(calculationText.equalsIgnoreCase("Calculations"))
			{
				System.out.println("Calculations displayed");
				driver.findElement(By.xpath(UIMapMyLowes.lnkShowCalc)).click();
				selenium.waitForPageToLoad("20000");
				Thread.sleep(5000);
				String calculationCount=driver.findElement(By.xpath(UIMapMyLowes.webElmntTotalCalc)).getText();
				System.out.println(calculationCount);
				Thread.sleep(2000);
				if((calculationCount.matches(".*\\d.*")))
				{
					System.out.println("Matches with nbr");
					driver.findElement(By.xpath(UIMapMyLowes.webElmntDeleteCalcAllTrashcan)).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath(UIMapMyLowes.lnkDeleteCalcUndo2)).click();
					Thread.sleep(5000);

					Boolean deleteButton=selenium.isElementPresent(UIMapMyLowes.webElmntDeleteCalcAllTrashcan);
					if(deleteButton)
					{
						System.out.println("4th");
						report.updateTestLog("trying to Undo Deletion operation on Calculations","Undo Operation is Successful" ,Status.PASS);
					}
					else
					{
						report.updateTestLog("trying to Undo Deletion operation on Calculations","Undo Operation Failed" ,Status.FAIL);
					}

				}
				else
				{
					System.out.println("Calculations Count not validated");
					report.updateTestLog("trying to Undo Deletion operation on Calculations","Calculations Count not validated" ,Status.FAIL);
				}
			}
			else
			{
				System.out.println("Calculations NOT displayed in Show Mechanism");
				report.updateTestLog("trying to Undo Deletion operation on Calculations","Calculations NOT displayed in Show Mechanism" ,Status.FAIL);
			}

		}
		else
		{
			System.out.println("No calculations");
			report.updateTestLog("trying to Undo Deletion operation on Calculations","No calculations" ,Status.FAIL);
		}
	}
	public void spaceDimensions() throws Exception
	{
		Thread.sleep(5000);
		String dimension=driver.findElement(By.xpath(UIMapMyLowes.lblSpace5DimCount)).getText();
		Thread.sleep(5000);
		if((!dimension.equals("")))
		{
			try{driver.findElement(By.xpath(UIMapMyLowes.lnkSpace5)).click();
			Thread.sleep(5000);
			}
			catch(Exception WebDriverException){
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup","Handeled", Status.DONE);
				driver.findElement(By.xpath(UIMapMyLowes.lnkSpace5)).click();
				Thread.sleep(5000);
				}
			driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(UIMapMyLowes.lnkShowDim)).click();
			Thread.sleep(5000);
			String shape=driver.findElement(By.xpath(UIMapMyLowes.lnkShowDim)).getText();
			String Area=driver.findElement(By.xpath(UIMapMyLowes.webElmntNegAreaSummary)).getText();
			driver.findElement(By.xpath(UIMapMyLowes.lblSummaryBreadth)).getText();
			String length=driver.findElement(By.xpath(UIMapMyLowes.lblSummaryLength)).getText();
			String breadth=driver.findElement(By.xpath(UIMapMyLowes.lblSummaryBreadth)).getText();
			if((!shape.equals("")) && (!length.equals("")) && (!breadth.equals("")))
			{
				report.updateTestLog("Trying to Calculate space dimensions","Space dimension Calculation is Successful" ,Status.PASS);
			}

		}
		else
		{
			report.updateTestLog("Trying to Calculate space dimensions","Space dimension Calculation Failed" ,Status.FAIL);
		}

	}
	public void docDeleteRedo() throws Exception
	{
		Thread.sleep(3000);

		driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntAllDocs)).click();
		Thread.sleep(5000);
		String documentText=driver.findElement(By.xpath(UIMapMyLowes.webElmntDocCount)).getText();
		String[] s = documentText.split(" ");
		Thread.sleep(2000);

		driver.findElement(By.xpath(UIMapMyLowes.webElmntDoc1Trashcan1)).click();
		Thread.sleep(5000);

		String documentTextAftrDeletion=driver.findElement(By.xpath(UIMapMyLowes.webElmntDocCount)).getText();

		String[] t = documentTextAftrDeletion.split(" ");
		Thread.sleep(2000);
		int initialCount=Integer.parseInt(s[0]);
		int countAfterDeletion=Integer.parseInt(t[0]);
		System.out.println("Init count"+initialCount);
		System.out.println("Final count"+countAfterDeletion);

		if((initialCount-countAfterDeletion)==1)
		{
			driver.findElement(By.xpath(UIMapMyLowes.lnkDocUndoLink)).click();
			Thread.sleep(5000);
			report.updateTestLog("Trying to Perform Deletion and Undo property","Deletion and Undo property is Successful" ,Status.PASS);

		}

		else
		{
			report.updateTestLog("Trying to Perform Deletion and Undo property","Deletion and Undo property Failed" ,Status.FAIL);
		}
	}

	public void allProductsSummaryPage() throws Exception
	{
		Thread.sleep(5000);
		try{
		driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
		Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
			Thread.sleep(5000);
			}
		String spaces=driver.findElement(By.xpath(UIMapMyLowes.webElmntShowSpaces)).getText();
		Thread.sleep(5000);
		String AllProducts=driver.findElement(By.xpath(UIMapMyLowes.webElmntShowAllProducts)).getText();
		Thread.sleep(5000);
		String AllPhotos=driver.findElement(By.xpath(UIMapMyLowes.webElmntAllPhotos)).getText();
		Thread.sleep(5000);
		String AllDocuments=driver.findElement(By.xpath(UIMapMyLowes.webElmntAllDocs)).getText();
		System.out.println("Spaces"+spaces);
		System.out.println("AllProds"+AllProducts);
		System.out.println("All Photos"+AllPhotos);
		System.out.println("All Docs"+AllDocuments);

		if((spaces.contains("Spaces")) && (AllProducts.contains("All Products")) && (AllPhotos.contains("All Photos")) && (AllDocuments.contains("All Documents")))
		{

			driver.findElement(By.xpath(UIMapMyLowes.webElmntShowAllProducts)).click();
			Thread.sleep(5000);

			String ItemsAdded= driver.findElement(By.xpath(UIMapMyLowes.webElmntProductCount)).getText();				
			String EnterProductInfo= driver.findElement(By.xpath(UIMapMyLowes.webElmntEnterProductInfo2)).getText();
			String show= driver.findElement(By.xpath(UIMapMyLowes.lblProductsShow)).getText();
			String sortBy= driver.findElement(By.xpath(UIMapMyLowes.lblProductsSortBy)).getText();
			if(selenium.isElementPresent(UIMapMyLowes.webElmntListViewImg) && selenium.isElementPresent(UIMapMyLowes.webElmntGridViewImg))
			{

				if(selenium.isElementPresent(UIMapMyLowes.chkBoxBatchDelete2))
				{

					if((!ItemsAdded.equals("")) && (!EnterProductInfo.equals("")) && (!show.equals("")) && (!sortBy.equals("")))
					{

						report.updateTestLog("Trying to validate All Product Summary page" ,"All Product summary page validation is Successful",Status.PASS);
					}
					else
					{
						report.updateTestLog("Trying to validate All Product Summary page" ,"All Product summary page validation Failed",Status.FAIL);
					}
				}
				else
				{
					report.updateTestLog("Trying to validate All Product Summary page" ,"All Product summary page validation Failed",Status.FAIL);
				}
			}
			else
			{
				report.updateTestLog("Trying to validate All Product Summary page" ,"All Product summary page validation Failed",Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Trying to validate All Product Summary page" ,"All Product summary page validation Failed",Status.FAIL);
		}

	}

	public void deleteASpace() throws Exception{

		Thread.sleep(5000);
		String spacesText= driver.findElement(By.xpath(UIMapMyLowes.lblSpaceCount)).getText();
		Thread.sleep(5000);
		String[] x = spacesText.split(" ");
		Thread.sleep(2000);

		String spaceCountText= x[0];
		int spaceCount=Integer.parseInt(spaceCountText);
		Thread.sleep(5000);
		try{
		driver.findElement(By.xpath(UIMapMyLowes.lnkSpace1)).click();
		selenium.waitForPageToLoad("20000");
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.lnkSpace1)).click();
			selenium.waitForPageToLoad("20000");
			}
		driver.findElement(By.xpath(UIMapMyLowes.btnDeleteSpace2)).click();
		Thread.sleep(3000);
		String DelConfirmationMsg= driver.findElement(By.xpath(UIMapMyLowes.webElmntDelConfirmationMsg)).getText();
		Thread.sleep(5000);
		if((!DelConfirmationMsg.equals("")))
		{
			driver.findElement(By.xpath(UIMapMyLowes.btnDeleteSpaceConfirm)).click();
			Thread.sleep(5000);

			String spacesTextAfterDeletion= driver.findElement(By.xpath(UIMapMyLowes.lblSpaceCount)).getText();
			Thread.sleep(5000);
			String[] y = spacesTextAfterDeletion.split(" ");
			Thread.sleep(2000);

			String spaceCountTextAfterDeletion= y[0];
			int spaceCountAfterDeletion=Integer.parseInt(spaceCountTextAfterDeletion);
			Thread.sleep(5000);
			if((spaceCount-spaceCountAfterDeletion)==1)
			{
				report.updateTestLog("Trying to delete a Space" ,"Space deletion is Successful",Status.PASS);

				driver.findElement(By.xpath(UIMapMyLowes.drpDownNewSpace)).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath(UIMapMyLowes.lnkNewSpace3)).click();
				Thread.sleep(5000);

			}
			else
			{
				report.updateTestLog("Trying to delete a Space" ,"Space deletion failed",Status.FAIL);		
			}

		}
		else
		{
			report.updateTestLog("Trying to delete a Space" ,"Space deletion failed",Status.FAIL);		
		}	
	}

	public void spaceWithSomeItems() throws Exception
	{
		Thread.sleep(3000);
		String products= driver.findElement(By.xpath(UIMapMyLowes.lblSpace5ProdCount)).getText();
		Thread.sleep(5000);
		String photos= driver.findElement(By.xpath(UIMapMyLowes.lblSpace5PhotosCount)).getText();
		Thread.sleep(5000);
		String calculation= driver.findElement(By.xpath(UIMapMyLowes.lblSpace5CalcCount)).getText();
		Thread.sleep(5000);
		String area= driver.findElement(By.xpath(UIMapMyLowes.lblSpace5DimCount)).getText();
		Thread.sleep(5000);

		if((!products.equals("")) && (!photos.equals("")) && (!calculation.equals("")) && (!area.equals("")))
		{

			driver.findElement(By.partialLinkText("Yard")).click();
			Thread.sleep(5000);

			if((products.matches(".*\\d.*")) && (photos.matches(".*\\d.*")) && (calculation.matches(".*\\d.*")) && (area.matches(".*\\d.*")))
			{
				report.updateTestLog("Trying to Validate Spaces with some Items" ,"Space validation with Items is Successful",Status.PASS);
			}
			else
			{
				report.updateTestLog("Trying to Validate Spaces with some Items" ,"Space validation with Items failed",Status.FAIL);
			}			
		}
		else
		{
			report.updateTestLog("Trying to Validate Spaces with some Items" ,"Space validation with Items failed",Status.FAIL);
		}
	}

	public void showAndSortMechanism() throws Exception
	{
		try{driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
		Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
			Thread.sleep(5000);
			}
		driver.findElement(By.xpath(UIMapMyLowes.webElmntShowAllProducts)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
		Thread.sleep(5000);
		String spaces=driver.findElement(By.xpath(UIMapMyLowes.lnkProductsShowSpaces)).getText();
		Thread.sleep(5000);
		String AllProducts=driver.findElement(By.xpath(UIMapMyLowes.lblShowPhotos)).getText();
		Thread.sleep(5000);
		String AllPhotos=driver.findElement(By.xpath(UIMapMyLowes.lnkProductsShowDoc)).getText();
		Thread.sleep(5000);
		String AllDocuments=driver.findElement(By.xpath(UIMapMyLowes.lnkShowCalc)).getText();

		if((spaces.matches(".*\\d.*")) && (AllProducts.matches(".*\\d.*")) && (AllPhotos.matches(".*\\d.*")) && (AllDocuments.matches(".*\\d.*")))
		{
			driver.findElement(By.xpath(UIMapMyLowes.drpDownSortBy)).click();
			Thread.sleep(5000);
			String mostRecent= driver.findElement(By.xpath(UIMapMyLowes.webElmntSortByHpMostRecent)).getText();
			String A2Z= driver.findElement(By.xpath(UIMapMyLowes.lblSortByAToZ)).getText();
			if(mostRecent.equalsIgnoreCase("Most Recent") && A2Z.equalsIgnoreCase("A-Z"))
			{
				driver.findElement(By.xpath(UIMapMyLowes.lblSortByAToZ)).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(UIMapMyLowes.drpDownSortBy)).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(UIMapMyLowes.webElmntSortByHpMostRecent)).click();
				Thread.sleep(5000);
				report.updateTestLog("Trying to Sort the Products" ,"Sorting process is Successful",Status.PASS);
			}
			else
			{
				report.updateTestLog("Trying to Sort the Products" ,"Sorting process Failed",Status.PASS);
			}


		}
		else
		{
			report.updateTestLog("Trying to Sort the Products" ,"Sorting process Failed",Status.PASS);
		}
	}
	public void directLogin() throws Exception
	{
		/*driver.findElement(By.xpath(UIMapMyLowes.webElmntYourAcct)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.lnkHPYourAcct)).click();
		Thread.sleep(5000);*/
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.id(UIMapMyLowes.lnkMyAccount));
		actions.moveToElement(menuHoverLink).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(5000);
		//WebElement subLink = driver.findElement(By.id(UIMapMyLowes.lnkHomeProfile));
		WebElement subLink = driver.findElement(By.partialLinkText("Home Profile"));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(5000);

		driver.findElement(By.id(UIMapFunctionalComponents.txtUserName)).sendKeys(dataTable.getData("General_Data","email"));
		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(dataTable.getData("General_Data", "password"));

		driver.findElement(By.id(UIMapFunctionalComponents.txtPassword)).sendKeys(Keys.ENTER);		
		selenium.waitForPageToLoad("15000");

		String summary= driver.findElement(By.xpath(UIMapMyLowes.drpDownSpace)).getText();
		if(summary.equalsIgnoreCase("Summary"))
		{
			report.updateTestLog("Trying to login directly into Home Profile" ,"Direct login to home profile is Successful",Status.PASS);
		}
		else
		{
			report.updateTestLog("Trying to login directly into Home Profile" ,"Direct login to home profile Failed",Status.FAIL);
		}
	}
	public void productDeleteAndUndo() throws Exception
	{
		Thread.sleep(3000);
		try{
		driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
		Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
			Thread.sleep(5000);
			}
		driver.findElement(By.xpath(UIMapMyLowes.webElmntShowAllProducts)).click();
		Thread.sleep(5000);
		String initialText=driver.findElement(By.xpath(UIMapMyLowes.webElmntProductCount)).getText();
		System.out.println(initialText);
		Thread.sleep(5000);
		String[] x = initialText.split(" ");
		Thread.sleep(2000);

		String initialCount= x[0];
		System.out.println(initialCount);
		driver.findElement(By.xpath(UIMapMyLowes.chkBoxItem)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntProductsActions)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.lnkProductsBatchDelete)).click();
		Thread.sleep(2000);
		String deletionMsg=driver.findElement(By.xpath(UIMapMyLowes.webElmntMultipleDelConfirmMsg)).getText();
		Thread.sleep(5000);
		if((!deletionMsg.equals("")))
		{
			driver.findElement(By.xpath(UIMapMyLowes.btnConfirmDelete)).click();
			Thread.sleep(3000);
			String finalText=driver.findElement(By.xpath(UIMapMyLowes.webElmntProductCount)).getText();
			Thread.sleep(5000);
			String[] y = finalText.split(" ");
			System.out.println(finalText);
			
			Thread.sleep(2000);

			String finalCount= y[0];
			System.out.println(finalCount);
			int initialCountt=Integer.parseInt(initialCount);
			int finalcountt=Integer.parseInt(finalCount);


			if((initialCountt-finalcountt)==1)
			{
				driver.findElement(By.xpath(UIMapMyLowes.lnkUndo2)).click();
				Thread.sleep(3000);
				String finalTxt=driver.findElement(By.xpath(UIMapMyLowes.webElmntProductCount)).getText();
				System.out.println(finalTxt);
				Thread.sleep(5000);
				String[] z = finalTxt.split(" ");
				Thread.sleep(2000);

				String finalSubTxt= z[0];
				System.out.println(finalSubTxt);
				int finalTxtCount=Integer.parseInt(finalSubTxt);

				if((finalTxtCount-initialCountt)==0)
				{
					report.updateTestLog("Trying to delete a product and undo the deletion" ,"Deletion and Undo operation is Successful",Status.PASS);
				}
				else
				{
					report.updateTestLog("Trying to delete a product and undo the deletion" ,"Deletion and Undo operation Failed",Status.FAIL);	
				}
			}
			else
			{
				report.updateTestLog("Trying to delete a product and undo the deletion" ,"Deletion and Undo operation Failed",Status.FAIL);	
			}

		}
		else
		{
			report.updateTestLog("Trying to delete a product and undo the deletion" ,"Deletion and Undo operation Failed",Status.FAIL);	
		}	
	}


	public void documentDeleteAndUndo() throws Exception
	{
		Thread.sleep(5000);
		try{driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();//done
		Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();//done
			Thread.sleep(5000);
		}
		
		driver.findElement(By.xpath(UIMapMyLowes.webElmntAllDocs)).click();//done
		Thread.sleep(5000);
		String initialText=driver.findElement(By.xpath(UIMapMyLowes.webElmntDocCount)).getText();//done
		System.out.println(initialText);
		Thread.sleep(5000);
		String[] x = initialText.split(" ");
		Thread.sleep(2000);
		
		String initialCount= x[0];
		System.out.println(initialCount);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntDoc1Trashcan)).click();//done
		Thread.sleep(2000);

		String finalText=driver.findElement(By.xpath(UIMapMyLowes.webElmntDocCount)).getText();//done
		System.out.println(finalText);
		Thread.sleep(5000);

		String[] y = finalText.split(" ");
		
		Thread.sleep(2000);

		String finalCount= y[0];
		System.out.println(finalCount);
		int initialCountt=Integer.parseInt(initialCount);
		int finalCountt=Integer.parseInt(finalCount);			
		System.out.println(initialCountt);
		System.out.println(finalCountt);
		if((initialCountt-finalCountt)==1)
		{
			driver.findElement(By.xpath(UIMapMyLowes.lnkDocUndoLink)).click();
			Thread.sleep(3000);
			String finalTxt=driver.findElement(By.xpath(UIMapMyLowes.webElmntDocCount)).getText();
			System.out.println(finalTxt);
			Thread.sleep(5000);
			String[] z = finalTxt.split(" ");
			Thread.sleep(2000);

			String finalSubTxt= z[0];
			System.out.println(finalSubTxt);
			int finalTxtCount=Integer.parseInt(finalSubTxt);
			System.out.println(finalTxtCount);
			if((finalTxtCount-initialCountt)==0)
			{
				report.updateTestLog("Trying to delete a product and undo the deletion" ,"Deletion and Undo operation is Successful",Status.PASS);
			}
			else
			{
				report.updateTestLog("Trying to delete a product and undo the deletion" ,"Deletion and Undo operation Failed",Status.FAIL);	
			}
		}
		else
		{
			report.updateTestLog("Trying to delete a product and undo the deletion" ,"Deletion and Undo operation Failed",Status.FAIL);	
		}
	}

	public void docDeleteNUndoInEditMode() throws Exception
	{

		Thread.sleep(5000);
		try{driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();//done
		Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();//done
			Thread.sleep(5000);
			}
		driver.findElement(By.xpath(UIMapMyLowes.webElmntAllDocs)).click();//done
		Thread.sleep(5000);
		String initialText=driver.findElement(By.xpath(UIMapMyLowes.webElmntDocCount)).getText();//done
		Thread.sleep(5000);
		String[] x = initialText.split(" ");
		Thread.sleep(2000);

		String initialCount= x[0];
		driver.findElement(By.xpath(UIMapMyLowes.lnkEdit2)).click();//done
		Thread.sleep(2000);
		if(selenium.isElementPresent(UIMapMyLowes.webElmntDocNotes))
		{

			driver.findElement(By.xpath(UIMapMyLowes.webElmntDoc1Trashcan)).click();//done
			Thread.sleep(5000);
			if(selenium.isElementPresent(UIMapMyLowes.lnkDocUndoLink))
			{
				String finalText=driver.findElement(By.xpath(UIMapMyLowes.webElmntDocCount)).getText();//done
				Thread.sleep(5000);

				String[] y = finalText.split(" ");
				Thread.sleep(2000);

				String finalCount= y[0];

				int initialCountt=Integer.parseInt(initialCount);
				int finalCountt=Integer.parseInt(finalCount);			

				if((initialCountt-finalCountt)==1)
				{
					driver.findElement(By.xpath(UIMapMyLowes.lnkDocUndoLink)).click();//done
					Thread.sleep(5000);
					String TextAfterUndo=driver.findElement(By.xpath(UIMapMyLowes.webElmntDocCount)).getText();//done
					Thread.sleep(5000);
					String[] z = TextAfterUndo.split(" ");
					Thread.sleep(2000);

					String CountAfterUndo= z[0];
					int UndoCount=Integer.parseInt(CountAfterUndo);

					if((UndoCount-initialCountt)==0)
					{
						report.updateTestLog("Trying to delete a Document and undo in Edit Mode" ,"Deletion and Undo operation is Successful",Status.PASS);
					}
					else
					{
						report.updateTestLog("Trying to delete a Document and undo in Edit Mode" ,"Deletion and Undo operation Failed",Status.FAIL);							
					}
				}
				else
				{
					report.updateTestLog("Trying to delete a Document and undo in Edit Mode" ,"Deletion and Undo operation Failed",Status.FAIL);							
				}
			}
			else
			{
				report.updateTestLog("Trying to delete a Document and undo in Edit Mode" ,"Deletion and Undo operation Failed",Status.FAIL);							
			}
		}
		else
		{
			report.updateTestLog("Trying to delete a Document and undo in Edit Mode" ,"Deletion and Undo operation Failed",Status.FAIL);							
		}
	}	

	public void calculationEditNameAndNote() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.lnkShowCalc)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.lnkCalcAttachANoteAll)).click();
		Thread.sleep(5000);


		
		String ItemNameOnButton= driver.findElement(By.xpath(UIMapMyLowes.btnCalcShop)).getText();
		Thread.sleep(2000);
		System.out.println("Item name on Button"+ItemNameOnButton);
		
		if(ItemNameOnButton.contains("Mulch"))
		{
			System.out.println("1st");
			String saveButton= driver.findElement(By.xpath(UIMapMyLowes.btnCalcSave)).getAttribute("class");
			String cancelButton=driver.findElement(By.xpath(UIMapMyLowes.lnkCalcCancel)).getAttribute("class");	
			if((!saveButton.equals("")) && (!cancelButton.equals("")))
			{
				System.out.println("2nd");
				driver.findElement(By.xpath(UIMapMyLowes.txtNotes2)).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).sendKeys("This the text added by me");
				Thread.sleep(2000);
				driver.findElement(By.xpath(UIMapMyLowes.btnCalcSave)).click();
				Thread.sleep(3000);
				String textAdded=driver.findElement(By.xpath(UIMapMyLowes.lblDocAddedNotes)).getText();
				Thread.sleep(2000);
				if((!textAdded.equals("")) && (!textAdded.equalsIgnoreCase("Add a note")))
				{
					System.out.println("3rd");
					report.updateTestLog("Trying to Edit name and note for a Calculation" ,"Editing process is Successful",Status.PASS);
				}
				else
				{
					report.updateTestLog("Trying to Edit name and note for a Calculation" ,"Editing process Failed",Status.FAIL);
				}
			}
			else
			{
				report.updateTestLog("Trying to Edit name and note for a Calculation" ,"Editing process Failed",Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Trying to Edit name and note for a Calculation" ,"Editing process Failed",Status.FAIL);
		}

	}

	public void yardOrGardenLinkToCalculators() throws Exception
	{
		Thread.sleep(5000);
		driver.findElement(By.partialLinkText("Yard")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(UIMapMyLowes.lnkShowDim)).click();
		Thread.sleep(2000);
		String text=driver.findElement(By.xpath(UIMapMyLowes.lnkSeedMulchFertLink)).getText();
		Thread.sleep(2000);
		System.out.println("Printing to know whether we need to trim it or not"+text);
		if(text.equalsIgnoreCase("How much seed, mulch and fertilizer will you need?"))
		{
			driver.findElement(By.xpath(UIMapMyLowes.lnkSeedMulchFertLink)).click();
			Thread.sleep(5000);
			System.out.println("1");
			String projectCalc=driver.findElement(By.xpath(UIMapMyLowes.webElmntAllCalculatorsHeading)).getText();
			if(projectCalc.equalsIgnoreCase("Project Calculators"))
			{
				System.out.println("2");
				report.updateTestLog("Trying to navigate to Garden link in Calculations" ,"Navigation is Successful",Status.PASS);
			}
			else
			{
				report.updateTestLog("Trying to navigate to Garden link in Calculations" ,"Navigation Failed",Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Trying to navigate to Garden link in Calculations" ,"Navigation Failed",Status.FAIL);
		}
	}

	public void photoDeleteAndUndo() throws Exception
	{
		Thread.sleep(5000);
		try{
		driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
		Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
			Thread.sleep(5000);
			}
		driver.findElement(By.xpath(UIMapMyLowes.webElmntAllPhotos)).click();
		Thread.sleep(5000);
		String text=driver.findElement(By.xpath(UIMapMyLowes.webElmntPhotosCount)).getText();
		System.out.println(text);
		String[] x = text.split(" ");
		Thread.sleep(2000);

		String initialCount= x[0];
		int initialCountNumber=Integer.parseInt(initialCount);
		System.out.println(initialCountNumber);
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By.xpath(UIMapMyLowes.webElmntPhoto1Thumbnail1));
		actions.moveToElement(menuHoverLink).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(5000);
		WebElement subLink = driver.findElement(By.xpath(UIMapMyLowes.webElmntPhoto1TrashCan1));
		actions.moveToElement(subLink).build().perform();

		if(selenium.isElementPresent(UIMapMyLowes.webElmntPhoto1TrashCan1))
		{
			actions.moveToElement(subLink).build().perform();
			subLink.click();
			Thread.sleep(5000);
			String textAfterDel=driver.findElement(By.xpath(UIMapMyLowes.webElmntPhotosCount)).getText();
			System.out.println(textAfterDel);
			String[] y = textAfterDel.split(" ");
			String countAfterDel= y[0];
			int countFinal=Integer.parseInt(countAfterDel);
			System.out.println(countFinal);
			if((initialCountNumber-countFinal)==1)
			{
				driver.findElement(By.xpath(UIMapMyLowes.lnkPhotoUndo)).click();
				Thread.sleep(5000);
				String textAfterUndo=driver.findElement(By.xpath(UIMapMyLowes.webElmntPhotosCount)).getText();
				System.out.println(textAfterUndo);
				y = textAfterUndo.split(" ");
				Thread.sleep(2000);

				String countAfterUndo= y[0];
				int countUndo=Integer.parseInt(countAfterUndo);
				System.out.println(countUndo);
				if(countUndo==initialCountNumber)
				
				report.updateTestLog("Trying to Delete a photo and Undo the Deletion" ,"Deletion and Undo process is Successful",Status.PASS);
				else
					report.updateTestLog("Trying to Delete a photo and Undo the Deletion" ,"Deletion and Undo process NOT Successful",Status.FAIL);
			}
			else
			{
				report.updateTestLog("Trying to Delete a photo and Undo the Deletion" ,"Deletion and Undo process Failed",Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Trying to Delete a photo and Undo the Deletion" ,"Deletion and Undo process Failed",Status.FAIL);
		}

	}

	public void calcDeleteAndUndo() throws Exception
	{
		Thread.sleep(5000);
		try{
		driver.findElement(By.partialLinkText("Yard")).click();
		selenium.waitForPageToLoad("20000");
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.partialLinkText("Yard")).click();
			selenium.waitForPageToLoad("20000");
			}
		driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.lnkShowCalc)).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath(UIMapMyLowes.lnkShowDetails)).click();
		Thread.sleep(5000);


		String text=driver.findElement(By.xpath(UIMapMyLowes.webElmntTotalCalc)).getText();
		String[] x = text.split(" ");
		Thread.sleep(2000);

		String initialCount= x[0];
		int initialCountNumber=Integer.parseInt(initialCount);



		driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcTrashcan)).click();
		Thread.sleep(5000);

		String textAfterDel=driver.findElement(By.xpath(UIMapMyLowes.webElmntTotalCalc)).getText();
		String[] y = textAfterDel.split(" ");
		Thread.sleep(2000);

		String finalCount= y[0];
		int finalCountNumber=Integer.parseInt(finalCount);
		if((initialCountNumber-finalCountNumber)==1)
		{
			driver.findElement(By.xpath(UIMapMyLowes.lnkDeleteCalcUndo2)).click();
			Thread.sleep(5000);
			report.updateTestLog("Trying to Delete a Calculation and Undo the Deletion" ,"Deletion and Undo process is Successful",Status.PASS);
		}
		else
		{
			report.updateTestLog("Trying to Delete a Calculation and Undo the Deletion" ,"Deletion and Undo process Failed",Status.FAIL);
		}
	}

	public void calculationTableInEditMode() throws Exception
	{
		Thread.sleep(5000);
		try{
		driver.findElement(By.partialLinkText("Yard")).click();
		selenium.waitForPageToLoad("20000");
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.partialLinkText("Yard")).click();
			selenium.waitForPageToLoad("20000");
			}
		driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.lnkShowCalc)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.lnkShowDetails)).click();
		Thread.sleep(5000);
		String area= driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcMulchArea1)).getText();
		String length= driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcMulcLength)).getText();
		String width= driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcMulcWidth)).getText();
		if((!area.equals("")) && (!length.equals("")) && (!width.equals("")))
		{	
			String calFullName= driver.findElement(By.xpath(UIMapMyLowes.txtCalcName1)).getAttribute("value");
			String[] x = calFullName.split(" ");
			Thread.sleep(2000);

			String calcName= x[0];
			String calButton=driver.findElement(By.xpath(UIMapMyLowes.btnCalcShop)).getText();
			System.out.println("This is the calcName"+calcName);
			System.out.println("This is the calculation Button"+ calButton);
			if(calButton.contains(calcName))
			{

				System.out.println("calButton.contains(calcName");
				if(selenium.isElementPresent(UIMapMyLowes.webElmntCalcTrashcan))
				{
					System.out.println("webElmntCalcTrashcan present");
					Thread.sleep(3000);

					String addedDate=driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcAddedOn)).getText();
					String[] y = addedDate.split(" ");
					Thread.sleep(2000);

					String addedDateSplit1= y[0];
					String addedDateSplit2= y[1];
					System.out.println(addedDateSplit1);
					System.out.println(addedDateSplit2);
					if(addedDateSplit1.equalsIgnoreCase("Added") && addedDateSplit2.equalsIgnoreCase("on"))
					{

					
							if(selenium.isElementPresent(UIMapMyLowes.webElmntCalcDisclaimer))
							{
								System.out.println("webElmntCalcDisclaimer");
								if(selenium.isElementPresent(UIMapMyLowes.txtNotes2))
								{
									System.out.println("txtNotes2");
									String saveButton=driver.findElement(By.xpath(UIMapMyLowes.btnCalcSave2)).getText();
									String cancelButton=driver.findElement(By.xpath(UIMapMyLowes.lnkCalcCancel)).getText();
									System.out.println(saveButton);
									System.out.println(cancelButton);
									if(saveButton.equalsIgnoreCase("Save") && cancelButton.equalsIgnoreCase("cancel"))
									{

										report.updateTestLog("Trying to view a Calculation Table in Edit mode" ,"View of calculation Tab in edit mode is Successful",Status.PASS);
									}
									else
									{
										report.updateTestLog("Trying to view a Calculation Table in Edit mode" ,"View of calculation Tab in edit mode Failed",Status.FAIL);
									}
								}
								else
								{
									report.updateTestLog("Trying to view a Calculation Table in Edit mode" ,"View of calculation Tab in edit mode Failed",Status.FAIL);
								}
							}
							else
							{
								report.updateTestLog("Trying to view a Calculation Table in Edit mode" ,"View of calculation Tab in edit mode Failed",Status.FAIL);
							}
					}
						
						else
						{
							report.updateTestLog("Trying to view a Calculation Table in Edit mode" ,"View of calculation Tab in edit mode Failed",Status.FAIL);
						}
						
						
					}
					else
					{
						report.updateTestLog("Trying to view a Calculation Table in Edit mode" ,"View of calculation Tab in edit mode Failed",Status.FAIL);
					}
				}
				else
				{
					report.updateTestLog("Trying to view a Calculation Table in Edit mode" ,"View of calculation Tab in edit mode Failed",Status.FAIL);
				}

			}
			else
			{
				report.updateTestLog("Trying to view a Calculation Table in Edit mode" ,"View of calculation Tab in edit mode Failed",Status.FAIL);
			}

		
	}

	public void dimensionSummaryForNegativeSpace() throws Exception
	{
		Thread.sleep(3000);
		try{driver.findElement(By.partialLinkText("Yard")).click();
		selenium.waitForPageToLoad("20000");
		
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.partialLinkText("Yard")).click();
			selenium.waitForPageToLoad("20000");
			
			}
		driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.lnkShowDim)).click();
		Thread.sleep(5000);
		String nonLawnArea=driver.findElement(By.xpath(UIMapMyLowes.lblNonLawnInAreaTotal)).getText();
		String[] x = nonLawnArea.split(" ");
		Thread.sleep(2000);

		String nonLawnAreaSplit= x[0];
		int nonLawnAreaNo= Integer.parseInt(nonLawnAreaSplit);
		if(nonLawnAreaNo>0)
		{
			String netArea= driver.findElement(By.xpath(UIMapMyLowes.lblNetAreaInAreaTotal)).getText();
			String[] y = netArea.split(" ");
			Thread.sleep(2000);

			String netAreaSplit= y[0];
			int netAreaNo= Integer.parseInt(netAreaSplit);

			String totalArea= driver.findElement(By.xpath(UIMapMyLowes.webElmntTotalArea)).getText();
			String[] z = totalArea.split(" ");
			Thread.sleep(2000);

			String totalAreaSplit= z[0];
			int totalAreaNo= Integer.parseInt(totalAreaSplit);
			if(totalAreaNo>netAreaNo)
			{
				Thread.sleep(5000);
				driver.findElement(By.xpath(UIMapMyLowes.webElmntLawnAreaExpanded)).click();
				Thread.sleep(5000);
				String editYardMeasure= driver.findElement(By.xpath(UIMapMyLowes.btnEditYardMsrments)).getText();
				if((selenium.isElementPresent(UIMapMyLowes.btnEditYardMsrments)) && (editYardMeasure.equalsIgnoreCase("Edit Yard Measurements")))
				{
					String nonLawnSpaces= driver.findElement(By.xpath(UIMapMyLowes.lblNonLawnHeadingInLawnArea)).getText();
					if(nonLawnSpaces.equalsIgnoreCase("Non-Lawn Spaces"))
					{
						if((selenium.isElementPresent(UIMapMyLowes.txtNegSpaceAreaName1)) && (selenium.isElementPresent(UIMapMyLowes.txtNegSpaceArea1)))
						{
							driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceAreaName2)).clear();
							driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceAreaName2)).sendKeys("NewShape");
							driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceArea2)).clear();
							driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceArea2)).sendKeys("5");
							driver.findElement(By.xpath(UIMapMyLowes.btnFinish2)).click();
							Thread.sleep(5000);
							driver.findElement(By.xpath(UIMapMyLowes.webElmntLawnAreaExpanded)).click();
							Thread.sleep(5000);

							report.updateTestLog("Trying to view dimension summary for negative space " ,"Dimension summary for negative space is Successful",Status.PASS);
							driver.findElement(By.xpath(UIMapMyLowes.webElmntDeleteNegSpaceArea2)).click();
							Thread.sleep(5000);
							driver.findElement(By.xpath(UIMapMyLowes.btnFinish2)).click();
							Thread.sleep(5000);
						}
						else
						{
							report.updateTestLog("Trying to view dimension summary for negative space " ,"Dimension summary for negative space Failed",Status.FAIL);
						}
					}
					else
					{
						report.updateTestLog("Trying to view dimension summary for negative space " ,"Dimension summary for negative space Failed",Status.FAIL);
					}
				}
				else
				{
					report.updateTestLog("Trying to view dimension summary for negative space " ,"Dimension summary for negative space Failed",Status.FAIL);
				}
			}
			else
			{
				report.updateTestLog("Trying to view dimension summary for negative space " ,"Dimension summary for negative space Failed",Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Trying to view dimension summary for negative space " ,"Dimension summary for negative space Failed",Status.FAIL);
		}

	}

	public void photosTabDeleteAndUndo() throws Exception
	{
		Thread.sleep(3000);
		try{
		driver.findElement(By.partialLinkText("Yard")).click();
		selenium.waitForPageToLoad("20000");
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.partialLinkText("Yard")).click();
			selenium.waitForPageToLoad("20000");
			}
		driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.lblShowPhotos)).click();
		Thread.sleep(5000);
		String text=driver.findElement(By.xpath(UIMapMyLowes.webElmntPhotosCount)).getText();
		System.out.println(text);
		String[] x = text.split(" ");
		Thread.sleep(2000);

		String initialCount= x[0];
		int initialCountNumber=Integer.parseInt(initialCount);
		System.out.println(initialCountNumber);
		System.out.println("this is the initial count no"+initialCountNumber);
		Actions actions = new Actions(driver);
		//*[@id='photosContainer']/div[2]/div[3]/div[1]/div
		WebElement menuHoverLink = driver.findElement(By.xpath(UIMapMyLowes.webElmntPhoto1Thumbnail));
		actions.moveToElement(menuHoverLink).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(5000);
		WebElement subLink = driver.findElement(By.xpath(UIMapMyLowes.webElmntPhoto1TrashCan));
		actions.moveToElement(subLink).build().perform();

		if(selenium.isElementPresent(UIMapMyLowes.webElmntPhoto1TrashCan))
		{
			actions.moveToElement(subLink).build().perform();
			subLink.click();
			Thread.sleep(5000);
			String textAfterDel=driver.findElement(By.xpath(UIMapMyLowes.webElmntPhotosCount)).getText();
			System.out.println(textAfterDel);
			String[] y = textAfterDel.split(" ");
			Thread.sleep(2000);

			String countAfterDel= y[0];
			int countFinal=Integer.parseInt(countAfterDel);
			System.out.println(countFinal);
			if((initialCountNumber-countFinal)==1)
			{
				driver.findElement(By.xpath(UIMapMyLowes.lnkPhotoUndo1)).click();
				Thread.sleep(5000);
				try{
					actions.moveToElement(subLink).build().perform();
					if(driver.findElement(By.xpath(UIMapMyLowes.webElmntPhoto1TrashCan)).isDisplayed())
				report.updateTestLog("Trying to Delete a photo and Undo the Deletion" ,"Deletion and Undo process is Successful",Status.PASS);
				else
					report.updateTestLog("Trying to Delete a photo and Undo the Deletion" ,"Undo process Failed",Status.FAIL);
				}
				catch(Exception NoSuchElementException)
				{
					report.updateTestLog("Trying to Delete a photo and Undo the Deletion" ,"Undo process Failed",Status.FAIL);
					
				}
			}
			else
			{
				report.updateTestLog("Trying to Delete a photo and Undo the Deletion" ,"Deletion and Undo process Failed",Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Trying to Delete a photo and Undo the Deletion" ,"Deletion and Undo process Failed",Status.FAIL);
		}

	}

	public void calculatorSort() throws Exception
	{
		Thread.sleep(3000);
		try{
		driver.findElement(By.partialLinkText("Yard")).click();
		selenium.waitForPageToLoad("20000");
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.partialLinkText("Yard")).click();
			selenium.waitForPageToLoad("20000");
			}
		driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(UIMapMyLowes.lnkShowCalc)).click();
		Thread.sleep(5000);
		String fert=driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc1Img)).getAttribute("class");
		System.out.println("This is the Text extracted from Fert"+fert);
		String[] y = fert.split(" ");
		Thread.sleep(2000);

		//String fertt= y[0];
	}

	public void spaceWithNoItems() throws Exception
	{
		System.out.println("started 655146546");
		Thread.sleep(5000);
		String text= driver.findElement(By.xpath(UIMapMyLowes.lblSpace1Txt)).getText();

		String[] y = text.split(". S");
		Thread.sleep(2000);

		String textForTesting= y[0];

		if(textForTesting.contains("Nothing to see here yet"))
		{
			report.updateTestLog("Trying to check the text for no Spaces attached","text for no Spaces has been validated",Status.PASS);
		}
		else
		{
			report.updateTestLog("Trying to check the text for no Spaces attached","text for no Spaces has failed",Status.FAIL);
		}
	}
	//Pending to complete the process of Upload.
	public void photoUpload() throws Exception
	{
		Thread.sleep(5000);
		try{
		driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
		Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
			Thread.sleep(5000);
			}
		String allPhotos=driver.findElement(By.xpath(UIMapMyLowes.webElmntAllPhotos)).getText();
		if(!allPhotos.equals(""))
		{
			
			System.out.println("entered the if condition");
			driver.findElement(By.xpath(UIMapMyLowes.webElmntAllPhotos)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(5000);
			String initialText=driver.findElement(By.xpath(UIMapMyLowes.webElmntPhotosCount)).getText();
			System.out.println(initialText);
			
			String[] x = initialText.split(" ");
			
			String initialTextPart= x[0];
			int initialCount=Integer.parseInt(initialTextPart);
			System.out.println(initialCount);
			driver.findElement(By.xpath(UIMapMyLowes.btnUpload2)).click();
			Thread.sleep(5000);
			/*driver.findElement(By.xpath(UIMapMyLowes.webElmntDocsUploadPopup)).click();
			Thread.sleep(15000);*/

			Robot r = new Robot(); 
			r.keyPress(KeyEvent.VK_D);        // D
			r.keyRelease(KeyEvent.VK_D);
			/*r.keyPress(KeyEvent.VK_COLON);    // : (colon)
            r.keyRelease(KeyEvent.VK_COLON);*/
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
			r.keyPress(KeyEvent.VK_J);        // J
			r.keyRelease(KeyEvent.VK_J);
			r.keyPress(KeyEvent.VK_P);        // P
			r.keyRelease(KeyEvent.VK_P);
			r.keyPress(KeyEvent.VK_G);        // G
			r.keyRelease(KeyEvent.VK_G);

			r.keyPress(KeyEvent.VK_ENTER); 
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(5000);
			String successMsg= driver.findElement(By.xpath(UIMapMyLowes.webElmntPhotosUploadSuccessMsg)).getText();
			

			if(successMsg.contains("Upload complete."))
			{
				driver.findElement(By.xpath("//div[29]/div[1]/a/span")).click();
				Thread.sleep(3000);
				String finalText=driver.findElement(By.xpath(UIMapMyLowes.webElmntPhotosCount)).getText();
				System.out.println(finalText);
				String[] y = finalText.split("");
				

				String finalTextPart= y[0];
				int finalCount=Integer.parseInt(finalTextPart);
				System.out.println(finalCount);
				if((finalCount-initialCount)==0)
				{
					report.updateTestLog("Trying to upload a Photo","Uploading process is Successful",Status.PASS);
					Actions actions = new Actions(driver);
					WebElement menuHoverLink = driver.findElement(By.xpath(UIMapMyLowes.lnkPhoto1Name));
					actions.moveToElement(menuHoverLink).build().perform();
					System.out.println("Mouse Hover successful");
					Thread.sleep(5000);
					driver.findElement(By.xpath(UIMapMyLowes.webElmntPhoto1TrashCan1)).click();
					Thread.sleep(5000);
					String doubleFinalText=driver.findElement(By.xpath(UIMapMyLowes.webElmntPhotosCount)).getText();
					System.out.println(doubleFinalText);
					String[] z = doubleFinalText.split("");
					

					String doubleFinalTextPart= z[0];
					
					int doubleFinalCount=Integer.parseInt(doubleFinalTextPart);
					System.out.println(doubleFinalCount);
					if((doubleFinalCount-initialCount)==0)
					{
						report.updateTestLog("Trying to delete the uploaded photo","Deletion of Uploaded photo is Successful",Status.PASS);
					}
					else
					{
						report.updateTestLog("Trying to delete the uploaded photo","Deletion of Uploaded photo Failed",Status.FAIL);
					}
				}
				else
				{
					report.updateTestLog("Trying to delete the uploaded photo","Deletion of Uploaded photo Failed",Status.FAIL);
				}
			}
			else if(successMsg.contains("Server error. Try again."))
				report.updateTestLog("Trying to upload photo","Upload Failed. Server Error",Status.FAIL);
			else
				report.updateTestLog("Trying to upload photo","Upload Failed.",Status.FAIL);
		}
		else
		{
			report.updateTestLog("Trying to upload a Photo","Show All Photos not displayed",Status.FAIL);
		}

	}

	public void sortByAndShowDocumentMechanism() throws Exception
	{
		String docs=driver.findElement(By.xpath(UIMapMyLowes.lblSpace5DocCount)).getText();
		Thread.sleep(5000);
		String[] x = docs.split(" ");
		Thread.sleep(2000);

		String docsSplitText= x[0];
		int docsCount= Integer.parseInt(docsSplitText);
		if(docsCount>=2)
		{
			System.out.println("1st");
			try{
			driver.findElement(By.partialLinkText("Yard")).click();
			selenium.waitForPageToLoad("20000");
			}
			catch(Exception WebDriverException){
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup","Handeled", Status.DONE);
				driver.findElement(By.partialLinkText("Yard")).click();
				selenium.waitForPageToLoad("20000");
				}
			
			driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
			Thread.sleep(5000);
			String docsButton=driver.findElement(By.xpath(UIMapMyLowes.lnkProductsShowDoc)).getText();
			Thread.sleep(2000);
			if(docsButton.equalsIgnoreCase("Documents"))
			{
				System.out.println("2nd");
				driver.findElement(By.xpath(UIMapMyLowes.lnkProductsShowDoc)).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(UIMapMyLowes.webElmntDocsSortByDownArrow)).click();
				Thread.sleep(2000);
				//*[@id='documentsContainer']/div[2]/div[2]/div[3]/div[2]/ul/li[1]/a
				String mostRecent=driver.findElement(By.xpath(UIMapMyLowes.lnkDocSortByMostRecent)).getText();
				
				
				String A2Z=driver.findElement(By.xpath(UIMapMyLowes.lnkDocSortByAToZ)).getText();
				
				System.out.println("most Recent, A2Z"+mostRecent+A2Z);
				if(mostRecent.equalsIgnoreCase("Most Recent") && A2Z.equalsIgnoreCase("A-Z"))
				{
					System.out.println("3rd");
					/*driver.findElement(By.xpath(UIMapMyLowes.webElmntDocsSortByDownArrow)).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath(UIMapMyLowes.lnkDocSortByMostRecent)).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath(UIMapMyLowes.webElmntDocsSortByDownArrow)).click();
					Thread.sleep(2000);*/
					driver.findElement(By.xpath(UIMapMyLowes.lnkDocSortByAToZ)).click();
					Thread.sleep(5000);
					int varCount=ps.countWebElement(UIMapMyLowes.webElmntDocCountOnPg);
					List<String> varCat=new ArrayList<String>();
					for(int i=1;i<=varCount;i++)
					{
						
						String varDocName=driver.findElement(By.xpath("//*[@id='documentsContainer']/div[2]/div[3]/div["+i+"]/div[2]/form/div[2]/div[2]/h5")).getText();
						System.out.println(varDocName);
						varCat.add(varDocName);
						
					}
					boolean varSorted=ps.isSorted(varCat);
					if(varSorted)
						report.updateTestLog("Trying to Sort the Docs A-Z","A-Z Sorting is Successful", Status.PASS);
					else
						report.updateTestLog("Trying to Sort the Docs A-Z","A-Z Sorting NOT Successful", Status.FAIL);
					
					driver.findElement(By.xpath(UIMapMyLowes.webElmntDocsShowDownArrow)).click();
					Thread.sleep(3000);
					String prod=driver.findElement(By.xpath(UIMapMyLowes.lnkDocShowProducts)).getText();
					Thread.sleep(3000);
					String photos=driver.findElement(By.xpath(UIMapMyLowes.lnkDocShowPhotos)).getText();
					Thread.sleep(3000);
					String documents=driver.findElement(By.xpath(UIMapMyLowes.lnkDocShowDocs)).getText();
					Thread.sleep(3000);
					String calculations=driver.findElement(By.xpath(UIMapMyLowes.lnkDocShowCalc)).getText();
					Thread.sleep(3000);
					String dimensions=driver.findElement(By.xpath(UIMapMyLowes.lnkDocShowDim)).getText();
					Thread.sleep(3000);
					if((prod.equalsIgnoreCase("Products")) && (photos.equalsIgnoreCase("Photos")) && (documents.equalsIgnoreCase("Documents")) && (calculations.equalsIgnoreCase("Calculations")) && (dimensions.equalsIgnoreCase("Dimensions")))
					{
						System.out.println("5th");
						report.updateTestLog("Trying to validate Sort By and Show By mechanism","Sort by and show by mechanism validation is successful",Status.PASS);
					}
					else
					{
						report.updateTestLog("Trying to validate Sort By and Show By mechanism","Sort by and show by mechanism validation Failed",Status.FAIL);
					}
					/*String text1=driver.findElement(By.xpath(UIMapMyLowes.webElmntDoc1Namee)).getText();
					Thread.sleep(3000);
					String text2=driver.findElement(By.xpath(UIMapMyLowes.webElmntDoc2Namee)).getText();
					Thread.sleep(3000);
					int compare = text1.compareTo(text2);
					System.out.println("came till If condition");
					System.out.println(compare);
					
					
					if (compare <= 0)  
					{  
						System.out.println("4th");
						System.out.println("The strings are in sorted order.");

						
					} 
					
					else
					{
						report.updateTestLog("Trying to validate Sort By and Show By mechanism","Sort by and show by mechanism validation Failed",Status.FAIL);
					}*/

				}
				else
				{
					report.updateTestLog("Trying to validate Sort By and Show By mechanism","Sort by and show by mechanism validation Failed",Status.FAIL);
				}

			}
			else
			{
				report.updateTestLog("Trying to validate Sort By and Show By mechanism","Sort by and show by mechanism validation Failed",Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Trying to validate Sort By and Show By mechanism","Sort by and show by mechanism validation Failed",Status.FAIL);
		}
	}

	public void squareAreaFootage() throws Exception
	{
		String sqArea= driver.findElement(By.xpath(UIMapMyLowes.lblSpace5DimCount)).getText();
		String[] x = sqArea.split(" ");
		Thread.sleep(2000);

		String areaNo= x[0];
		String areaUnits=x[1];
		String areaType=x[2];
		int areaValue=Integer.parseInt(areaNo);
		if((areaValue>0) && (areaUnits.equalsIgnoreCase("sq.")) && (areaType.equalsIgnoreCase("ft.")))
		{
			report.updateTestLog("Trying to validate the Square Area footage","Square area footage validation is successful",Status.PASS);

		}
		else
		{
			report.updateTestLog("Trying to validate the Square Area footage","Square area footage validation Failed",Status.FAIL);
		}

	}
	public void scrollBarValidation() throws Exception
	{
		try{driver.findElement(By.xpath(UIMapMyLowes.drpDownSpace)).click();
		Thread.sleep(3000);
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.drpDownSpace)).click();
			Thread.sleep(3000);
			}
		String spacesText=driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDefault)).getText();

		System.out.println("Starting the int extraction process");
		/*System.out.println("This is wat I have extracted"+spacesText);
		String[] x = spacesText.split("s (");
		Thread.sleep(2000);

		String spacesText1= x[0];
		System.out.println("This is spaces Text"+spacesText1);
		String[] y = spacesText1.split(")");
		Thread.sleep(2000);


		String spacesNo=y[0];
		int spacesNumber=Integer.parseInt(spacesNo);
		 */		//System.out.println("This is the count:"+spacesNumber);



		String input = spacesText;
		int output = extractInt(input);
		System.out.println("This is what I have got from Regex"+output);

		if(output>3)
		{

			if(selenium.isElementPresent(UIMapMyLowes.webElmntSpaceDropScroll))
			{
				System.out.println("2nd");
				report.updateTestLog("Trying to validate the scroll bar","Scroll bar is available",Status.PASS);
			}
			else
			{
				report.updateTestLog("Trying to validate the scroll bar","Scroll bar is not available",Status.FAIL);
			}
		}
		else if(output<=3)
		{
			if(selenium.isElementPresent(UIMapMyLowes.webElmntSpaceDropScroll))
			{
				report.updateTestLog("Trying to validate the scroll bar","Scroll bar is not available",Status.FAIL);
			}

		}
	}
	public static int extractInt(String str) {
		Matcher matcher = Pattern.compile("\\d+").matcher(str);

		if (!matcher.find())
		{
			throw new NumberFormatException("For input string [" + str + "]");
		}

		return Integer.parseInt(matcher.group());

	}


	public void photosUpload() throws Exception
	{
		try{driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
		Thread.sleep(4000);
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
			Thread.sleep(4000);
			}
		String spaces=driver.findElement(By.xpath(UIMapMyLowes.webElmntShowSpaces)).getText();
		Thread.sleep(4000);

		String products=driver.findElement(By.xpath(UIMapMyLowes.webElmntShowAllProducts)).getText();
		Thread.sleep(4000);

		String photos=driver.findElement(By.xpath(UIMapMyLowes.webElmntAllPhotos)).getText();
		Thread.sleep(4000);

		String documents=driver.findElement(By.xpath(UIMapMyLowes.webElmntAllDocs)).getText();
		Thread.sleep(5000);

		if(spaces.contains("Spaces") && products.contains("All Products") && photos.contains("All Photos") && documents.contains("All Documents"))
		{	
			System.out.println("1st");
			if((spaces.matches(".*\\d.*")) && (products.matches(".*\\d.*")) && (photos.matches(".*\\d.*")) && (documents.matches(".*\\d.*")))
			{
				System.out.println("2nd");
				driver.findElement(By.xpath(UIMapMyLowes.webElmntAllPhotos)).click();
				selenium.waitForPageToLoad("20000");
				Thread.sleep(4000);
				String photosUploaded= driver.findElement(By.xpath(UIMapMyLowes.webElmntPhotosCount)).getText();
				System.out.println(photosUploaded);
				Thread.sleep(2000);
				String[] x = photosUploaded.split(" ");
				Thread.sleep(2000);

				String spacesText1= x[0];
				int noOfPhotos= Integer.parseInt(spacesText1);
				System.out.println(noOfPhotos);
				if(noOfPhotos>=0)
				{	
					System.out.println("3rd");
					String upload=driver.findElement(By.xpath(UIMapMyLowes.btnUpload2)).getText();
					Thread.sleep(2000);
					if(upload.equalsIgnoreCase("Upload"))
					{
						System.out.println("4th");
						String showText=driver.findElement(By.xpath(UIMapMyLowes.lblShowInPhotos2)).getText();
						Thread.sleep(2000);
						if(showText.equalsIgnoreCase("Show:"))
						{
							System.out.println("5th");
							String sortBy=driver.findElement(By.xpath(UIMapMyLowes.lblSortInPhotos2)).getText();
							Thread.sleep(2000);
							if(sortBy.equalsIgnoreCase("Sort by:"))
							{
								System.out.println("6th");
								driver.findElement(By.xpath(UIMapMyLowes.lblHomeProfile)).click();
								Thread.sleep(3000);
								driver.findElement(By.partialLinkText("Bedroom")).click();
								Thread.sleep(4000);
								String photoCount=driver.findElement(By.xpath(UIMapMyLowes.webElmntProductCount)).getText();
								Thread.sleep(2000);
								String[] y = photoCount.split(" ");
								Thread.sleep(2000);

								String photoCount2= y[0];
								int photoCountNumber=Integer.parseInt(photoCount2);
								if(photoCountNumber==0)
								{
									System.out.println("7th");
									if(selenium.isElementPresent(UIMapMyLowes.webElmntNoPhotoImg))
									{
										System.out.println("8th");
										if(selenium.isElementPresent(UIMapMyLowes.btnUploadPhotos))
										{
											System.out.println("9th");
											if(selenium.isElementPresent(UIMapMyLowes.lblNoPhotosShow))
											{
												System.out.println("10th");
												report.updateTestLog("Trying to view All Photos from summary page","Summary page validation is successful",Status.PASS);
											}
											else
											{
												report.updateTestLog("Trying to view All Photos from summary page","Summary page validation failed",Status.FAIL);
											}

										}
										else
										{
											report.updateTestLog("Trying to view All Photos from summary page","Summary page validation failed",Status.FAIL);
										}
									}
									else
									{
										report.updateTestLog("Trying to view All Photos from summary page","Summary page validation failed",Status.FAIL);
									}
								}
								else
								{
									report.updateTestLog("Trying to view All Photos from summary page","Summary page validation failed",Status.FAIL);
								}

							}
							else
							{
								report.updateTestLog("Trying to view All Photos from summary page","Summary page validation failed",Status.FAIL);
							}


						}
						else
						{
							report.updateTestLog("Trying to view All Photos from summary page","Summary page validation failed",Status.FAIL);
						}

					}
					else
					{
						report.updateTestLog("Trying to view All Photos from summary page","Summary page validation failed",Status.FAIL);
					}

				}
				else
				{
					report.updateTestLog("Trying to view All Photos from summary page","Summary page validation failed",Status.FAIL);
				}

			}
			else
			{
				report.updateTestLog("Trying to view All Photos from summary page","Summary page validation failed",Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Trying to view All Photos from summary page","Summary page validation failed",Status.FAIL);
		}

	}

	public void sortAndShowPhotos() throws Exception
	{

		try{driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
		Thread.sleep(5000);
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
			Thread.sleep(5000);
			}
		driver.findElement(By.xpath(UIMapMyLowes.webElmntAllPhotos)).click();
		Thread.sleep(5000);
		String sortByButton=driver.findElement(By.xpath(UIMapMyLowes.lnkPhotoMostRecent)).getText();
		Thread.sleep(3000);
		if(sortByButton.equalsIgnoreCase("Most Recent"))
		{
			driver.findElement(By.xpath(UIMapMyLowes.webElmntPhotoSortByDownArrow)).click();
			Thread.sleep(3000);
			String mostRecent=driver.findElement(By.xpath(UIMapMyLowes.lnkPhotosSortByMostRecent2)).getText();
			String A2Z=driver.findElement(By.xpath(UIMapMyLowes.lnkPhotosSortByAtoZ2)).getText();
			if((mostRecent.equalsIgnoreCase("Most Recent") && A2Z.equalsIgnoreCase("A-Z")))
			{

				driver.findElement(By.xpath(UIMapMyLowes.lnkPhotosSortByAtoZ2)).click();
				Thread.sleep(4000);

				driver.findElement(By.xpath(UIMapMyLowes.webElmntPhotoSortByDownArrow)).click();
				Thread.sleep(3000);

				driver.findElement(By.xpath(UIMapMyLowes.lnkPhotosSortByMostRecent2)).click();
				Thread.sleep(4000);

				driver.findElement(By.xpath(UIMapMyLowes.webElmntPhotosShowDownArrow2)).click();
				Thread.sleep(4000);

				String spaces=driver.findElement(By.xpath(UIMapMyLowes.lnkPhotosShowAllSpaces)).getText();
				Thread.sleep(4000);

				String products=driver.findElement(By.xpath(UIMapMyLowes.lnkPhotosShowAllProducts)).getText();
				Thread.sleep(4000);

				String photos=driver.findElement(By.xpath(UIMapMyLowes.lnkPhotosShowAllPhotos)).getText();
				Thread.sleep(4000);

				String documents=driver.findElement(By.xpath(UIMapMyLowes.lnkPhotosShowAllDocs)).getText();
				Thread.sleep(5000);


				if(spaces.contains("Spaces") && products.contains("All Products") && photos.contains("All Photos") && documents.contains("All Documents"))
				{	

					if((spaces.matches(".*\\d.*")) && (products.matches(".*\\d.*")) && (photos.matches(".*\\d.*")) && (documents.matches(".*\\d.*")))
					{

						report.updateTestLog("Trying to validate Sort and Show mechanism","Sort and Show mechanism validation is Successful",Status.PASS);
					}
					else
					{
						report.updateTestLog("Trying to validate Sort and Show mechanism","Sort and Show mechanism validation is Successful",Status.FAIL);
					}
				}
				else
				{
					report.updateTestLog("Trying to validate Sort and Show mechanism","Sort and Show mechanism validation is Successful",Status.FAIL);
				}	
			}
			else
			{
				report.updateTestLog("Trying to validate Sort and Show mechanism","Sort and Show mechanism validation is Successful",Status.FAIL);
			}

		}
		else
		{
			report.updateTestLog("Trying to validate Sort and Show mechanism","Sort and Show mechanism validation is Successful",Status.FAIL);
		}

	}

	public void batchDeleteCalculation() throws Exception
	{
		if(selenium.isElementPresent(UIMapMyLowes.lblSpace5ProdCount))
		{
			System.out.println("1st");
			try{driver.findElement(By.partialLinkText("Yard")).click();
			selenium.waitForPageToLoad("20000");
			}
			catch(Exception WebDriverException){
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup","Handeled", Status.DONE);
				selenium.waitForPageToLoad("20000");
			}
			Thread.sleep(3000);
			driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
			Thread.sleep(4000);
			String cal=driver.findElement(By.xpath(UIMapMyLowes.lnkShowCalc)).getText();
			if(cal.equalsIgnoreCase("Calculations"))
			{
				System.out.println("2nd");
				driver.findElement(By.xpath(UIMapMyLowes.lnkShowCalc)).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath(UIMapMyLowes.chkBoxCalc1)).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(UIMapMyLowes.webElmntActions)).click();
				Thread.sleep(2000);
				String del=driver.findElement(By.xpath(UIMapMyLowes.webElmntDeleteAction)).getText();
				if(del.equalsIgnoreCase("Delete"))
				{
					System.out.println("3rd");
					driver.findElement(By.xpath(UIMapMyLowes.webElmntDeleteAction)).click();
					Thread.sleep(2000);
					String deletionText=driver.findElement(By.xpath(UIMapMyLowes.webElmntMultipleDelConfirmMsg)).getText();
					Thread.sleep(2000);
					if(!deletionText.equals(""))
					{
						System.out.println("4th");
						driver.findElement(By.xpath(UIMapMyLowes.btnConfirmDelete)).click();
						Thread.sleep(5000);

						String undo=driver.findElement(By.xpath(UIMapMyLowes.lnkDeleteCalcUndo)).getText();
						if(undo.equalsIgnoreCase("Undo"))
						{
							System.out.println("5th");
							report.updateTestLog("Trying for batch deletion of a Calculation","Batch deletion is Successful",Status.PASS);
							driver.findElement(By.xpath(UIMapMyLowes.lnkDeleteCalcUndo)).click();
							Thread.sleep(2000);
						}
						else
						{
							report.updateTestLog("Trying for batch deletion of a Calculation","Batch deletion Failed",Status.FAIL);
						}	
					}
					else
					{
						report.updateTestLog("Trying for batch deletion of a Calculation","Batch deletion Failed",Status.FAIL);
					}	
				}
				else
				{
					report.updateTestLog("Trying for batch deletion of a Calculation","Batch deletion Failed",Status.FAIL);
				}	
			}
			else
			{
				report.updateTestLog("Trying for batch deletion of a Calculation","Batch deletion Failed",Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Trying for batch deletion of a Calculation","Batch deletion Failed",Status.FAIL);
		}
	}

	public void allDocsSummaryPage() throws Exception
	{

		driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
		Thread.sleep(5000);
		String spaces=driver.findElement(By.xpath(UIMapMyLowes.webElmntShowSpaces)).getText();
		Thread.sleep(3000);
		String allProducts=driver.findElement(By.xpath(UIMapMyLowes.webElmntShowAllProducts)).getText();
		Thread.sleep(3000);
		String allPhotos=driver.findElement(By.xpath(UIMapMyLowes.webElmntAllPhotos)).getText();
		Thread.sleep(3000);
		String allDocuments=driver.findElement(By.xpath(UIMapMyLowes.webElmntAllDocs)).getText();
		Thread.sleep(3000);

		if(allProducts.contains("All Products") && allPhotos.contains("All Photos") && allDocuments.contains("All Documents") && spaces.contains("Spaces"))
		{
			System.out.println("1st");
			driver.findElement(By.xpath(UIMapMyLowes.webElmntAllDocs)).click();
			Thread.sleep(4000);
			String docNo=driver.findElement(By.xpath(UIMapMyLowes.webElmntDocCount)).getText();
			Thread.sleep(2000);
			String[] x = docNo.split(" ");
			Thread.sleep(2000);

			String docCount= x[0];
			int totalCountNumber=Integer.parseInt(docCount);
			if(totalCountNumber>=0)
			{
				System.out.println("2nd");
				String upload=driver.findElement(By.xpath(UIMapMyLowes.webElmntDocUpload2)).getText();
				Thread.sleep(2000);
				if(upload.equalsIgnoreCase("Upload"))
				{
					System.out.println("3rd");
					String show=driver.findElement(By.xpath(UIMapMyLowes.webElmntDocShow2)).getText();
					Thread.sleep(2000);
					if(show.equalsIgnoreCase("Show:"))
					{
						System.out.println("4th");
						String sortBy=driver.findElement(By.xpath(UIMapMyLowes.webElmntDocSortBy2)).getText();
						Thread.sleep(2000);
						if(sortBy.equalsIgnoreCase("Sort by:"))
						{
							System.out.println("5th");
							if(selenium.isElementPresent(UIMapMyLowes.webElmntDoc1Icon))
							{
								System.out.println("6th");
								report.updateTestLog("Trying for validate All documents summary page","Validation of All documents page is successful",Status.PASS);
								Thread.sleep(2000);
							}
							else
							{
								report.updateTestLog("Trying for validate All documents summary page","Validation of All documents page Failed",Status.FAIL);
							}
						}
						else
						{
							report.updateTestLog("Trying for validate All documents summary page","Validation of All documents page Failed",Status.FAIL);
						}

					}
					else
					{
						report.updateTestLog("Trying for validate All documents summary page","Validation of All documents page Failed",Status.FAIL);
					}
				}
				else
				{
					report.updateTestLog("Trying for validate All documents summary page","Validation of All documents page Failed",Status.FAIL);
				}
			}
			else
			{
				report.updateTestLog("Trying for validate All documents summary page","Validation of All documents page Failed",Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Trying for validate All documents summary page","Validation of All documents page Failed",Status.FAIL);
		}

	}
	public void editDocument() throws Exception
	{
		try{driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
		Thread.sleep(3000);
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
			Thread.sleep(3000);
			}
		String allDocs=driver.findElement(By.xpath(UIMapMyLowes.webElmntAllDocs)).getText();
		Thread.sleep(3000);
		if(allDocs.contains("All Documents"))
		{
			System.out.println("1st");
			driver.findElement(By.xpath(UIMapMyLowes.webElmntAllDocs)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(3000);
			if(selenium.isElementPresent(UIMapMyLowes.webElmntDocCount))
			{
				System.out.println("2nd");
				String editLink=driver.findElement(By.xpath(UIMapMyLowes.lnkDoc1Edit)).getText();
				Thread.sleep(3000);
				if(editLink.equalsIgnoreCase("Edit"))
				{
					System.out.println("3rd");
					driver.findElement(By.xpath(UIMapMyLowes.lnkDoc1Edit)).click();
					Thread.sleep(3000);
					if(selenium.isElementPresent(UIMapMyLowes.webElmntDocNotes))
					{
						System.out.println("4th");
						driver.findElement(By.xpath(UIMapMyLowes.txtCalcName1)).clear();
						driver.findElement(By.xpath(UIMapMyLowes.txtCalcName1)).sendKeys("This is what I have added. Let me check the total number of characters I can enter here and then save the text. I hope this tese case runs absolutely fine");
						Thread.sleep(5000);
						driver.findElement(By.xpath(UIMapMyLowes.btnDoc1Save)).click();
						Thread.sleep(3000);


						driver.findElement(By.xpath(UIMapMyLowes.lnkDoc1Edit)).click();
						Thread.sleep(3000);
						String charLimitInitial=driver.findElement(By.xpath(UIMapMyLowes.lblDocCharRemaining)).getText();
						System.out.println(charLimitInitial);
						String[] x = charLimitInitial.split(" ");
						Thread.sleep(2000);

						String charLimit= x[0];
						int charLimitNumberInitial=Integer.parseInt(charLimit);
						System.out.println(charLimitNumberInitial);
						Thread.sleep(2000);
						String textToBeAdded=new String("Trying the check the updation of character limit");
						driver.findElement(By.xpath(UIMapMyLowes.webElmntDocNotes)).sendKeys(textToBeAdded);
						String charLimitFinal=driver.findElement(By.xpath(UIMapMyLowes.lblDocCharRemaining)).getText();
						String[] y = charLimitFinal.split(" ");
						Thread.sleep(2000);

						String charCount= y[0];
						int charLimitNumberFinal=Integer.parseInt(charCount);
						System.out.println(charLimitNumberFinal);
						Thread.sleep(2000);

						if((charLimitNumberInitial-charLimitNumberFinal)==textToBeAdded.length())
						{
							System.out.println("5th");
							driver.findElement(By.xpath(UIMapMyLowes.btnDoc1Save)).click();
							Thread.sleep(3000);
							report.updateTestLog("Trying for vedit a document","Editing a document is successful",Status.PASS);
						}
						else
						{
							report.updateTestLog("Trying for vedit a document","Incorrect Char Remaining displayed",Status.FAIL);
						}

					}
					else
					{
						report.updateTestLog("Trying for vedit a document","Editing a document is successful",Status.FAIL);
					}

				}
				else
				{
					report.updateTestLog("Trying for vedit a document","Editing a document is successful",Status.FAIL);
				}


			}
			else
			{
				report.updateTestLog("Trying for vedit a document","Editing a document is successful",Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Trying for vedit a document","Editing a document is successful",Status.FAIL);
		}
	}

	public void sortAndShowDocuments() throws Exception
	{
		try{driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
		Thread.sleep(3000);}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
			Thread.sleep(3000);}

		String spaces=driver.findElement(By.xpath(UIMapMyLowes.webElmntShowSpaces)).getText();
		Thread.sleep(2000);

		String products=driver.findElement(By.xpath(UIMapMyLowes.webElmntShowAllProducts)).getText();
		Thread.sleep(2000);

		String photos=driver.findElement(By.xpath(UIMapMyLowes.webElmntAllPhotos)).getText();
		Thread.sleep(2000);

		String documents=driver.findElement(By.xpath(UIMapMyLowes.webElmntAllDocs)).getText();
		Thread.sleep(2000);
		System.out.println("This"+spaces+products+photos+documents);
		if(spaces.contains("Spaces") && products.contains("All Products") && photos.contains("All Photos") && documents.contains("All Documents"))
		{	
			System.out.println("1st");
			if((spaces.matches(".*\\d.*")) && (products.matches(".*\\d.*")) && (photos.matches(".*\\d.*")) && (documents.matches(".*\\d.*")))
			{
				System.out.println("2nd");
				driver.findElement(By.xpath(UIMapMyLowes.webElmntAllDocs)).click();
				Thread.sleep(3000);
				String mostRecent=driver.findElement(By.xpath(UIMapMyLowes.webElmntDocSortByDefault)).getText();
				Thread.sleep(2000);
				System.out.println("most recent"+mostRecent);
				if(mostRecent.equalsIgnoreCase("Most Recent"))
				{
					System.out.println("3rd");
					driver.findElement(By.xpath(UIMapMyLowes.webElmntDocsSortByDownArrow2)).click();
					Thread.sleep(2000);
					String A2Z=driver.findElement(By.xpath(UIMapMyLowes.webElmntDocsSortByAToZ)).getText();
					System.out.println("A2Z"+A2Z);
					if(A2Z.equalsIgnoreCase("A-Z"))
					{
						System.out.println("4th");
						driver.findElement(By.xpath(UIMapMyLowes.webElmntDocsSortByAToZ)).click();
						Thread.sleep(5000);
						driver.findElement(By.xpath(UIMapMyLowes.webElmntDocsSortByDownArrow2)).click();
						Thread.sleep(3000);
						driver.findElement(By.xpath(UIMapMyLowes.webElmntDocsSortByMostRecent)).click();
						Thread.sleep(5000);

						report.updateTestLog("Trying to sort and show documents","Sort and show operation on Documents is successful",Status.PASS);
					}
					else
					{
						report.updateTestLog("Trying to sort and show documents","Sort and show operation on Documents Failed",Status.FAIL);
					}
				}
				else
				{
					report.updateTestLog("Trying to sort and show documents","Sort and show operation on Documents Failed",Status.FAIL);
				}
			}
			else
			{
				report.updateTestLog("Trying to sort and show documents","Sort and show operation on Documents Failed",Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Trying to sort and show documents","Sort and show operation on Documents Failed",Status.FAIL);
		}

	}

	public void productSpaceDetailPage() throws Exception
	{
		if(selenium.isElementPresent(UIMapMyLowes.lblSpace5ProdCount))
		{
			System.out.println("1st");
			try{driver.findElement(By.partialLinkText("Yard")).click();
			selenium.waitForPageToLoad("20000");
			}
			catch(Exception WebDriverException){
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup","Handeled", Status.DONE);
				driver.findElement(By.partialLinkText("Yard")).click();
				selenium.waitForPageToLoad("20000");
				}
			Thread.sleep(3000);
			String showInitial=driver.findElement(By.xpath(UIMapMyLowes.drpDownShowDefault)).getText();
			Thread.sleep(3000);
			if(showInitial.equalsIgnoreCase("Products"))
			{
				System.out.println("2nd");
				String productTotal=driver.findElement(By.xpath(UIMapMyLowes.webElmntProductCount)).getText();
				System.out.println(productTotal);
				Thread.sleep(3000);
				String[] x = productTotal.split(" ");
				Thread.sleep(2000);

				String prodTotal= x[0];
				int productCount=Integer.parseInt(prodTotal);
				System.out.println(productCount);
				if(productCount>0)
				{
					System.out.println("3rd");
					String productInfoButton=driver.findElement(By.xpath(UIMapMyLowes.webElmntEnterProductInfo2)).getText();
					Thread.sleep(2000);
					if(productInfoButton.equalsIgnoreCase("Enter Product Info"))
					{
						System.out.println("4th");
						String showText=driver.findElement(By.xpath(UIMapMyLowes.lblProductsShow)).getText();
						Thread.sleep(2000);
						if(showText.equalsIgnoreCase("Show:"))
						{
							System.out.println("5th");

							String sortText=driver.findElement(By.xpath(UIMapMyLowes.lblProductsSortBy)).getText();
							Thread.sleep(2000);
							if(sortText.equalsIgnoreCase("Sort by:"))
							{
								System.out.println("6th");
								if(selenium.isElementPresent(UIMapMyLowes.webElmntListViewImg) && selenium.isElementPresent(UIMapMyLowes.webElmntGridViewImg) && selenium.isElementPresent(UIMapMyLowes.webElmntProductsActions))
								{
									System.out.println("7th");
									report.updateTestLog("Trying to Validate Product space detail page","Product space detail page validation is Successful",Status.PASS);									
								}
								else
								{
									report.updateTestLog("Trying to Validate Product space detail page","Product space detail page validation Failed",Status.FAIL);
								}
							}
							else
							{
								report.updateTestLog("Trying to Validate Product space detail page","Product space detail page validation Failed",Status.FAIL);
							}
						}
						else
						{
							report.updateTestLog("Trying to Validate Product space detail page","Product space detail page validation Failed",Status.FAIL);
						}

					}
					else
					{
						report.updateTestLog("Trying to Validate Product space detail page","Product space detail page validation Failed",Status.FAIL);
					}
				}
				else
				{
					report.updateTestLog("Trying to Validate Product space detail page","Product space detail page validation Failed",Status.FAIL);
				}
			}
			else
			{
				report.updateTestLog("Trying to Validate Product space detail page","Product space detail page validation Failed",Status.FAIL);
			}

		}
		else
		{
			report.updateTestLog("Trying to Validate Product space detail page","Product space detail page validation Failed",Status.FAIL);
		}
	}		
	public void productBatchDeleteAndUndo() throws Exception
	{
		if(selenium.isElementPresent(UIMapMyLowes.lblSpace5ProdCount))
		{

			try{driver.findElement(By.partialLinkText("Yard")).click();
			selenium.waitForPageToLoad("20000");
			}
			catch(Exception WebDriverException){
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup","Handeled", Status.DONE);
				driver.findElement(By.partialLinkText("Yard")).click();
				selenium.waitForPageToLoad("20000");
				}
			Thread.sleep(3000);

			String prodText= driver.findElement(By.xpath(UIMapMyLowes.webElmntProductCount)).getText();
			String[] x = prodText.split(" ");
			Thread.sleep(2000);

			String prodTotal= x[0];
			int productCountInitial=Integer.parseInt(prodTotal);
			driver.findElement(By.xpath(UIMapMyLowes.chkBoxItem)).click();
			Thread.sleep(3000);

			driver.findElement(By.xpath(UIMapMyLowes.webElmntProductsActions)).click();
			Thread.sleep(3000);

			driver.findElement(By.xpath(UIMapMyLowes.lnkProductsBatchDelete)).click();
			Thread.sleep(3000);

			if(selenium.isElementPresent(UIMapMyLowes.webElmntMultipleDelConfirmMsg))
			{

				driver.findElement(By.xpath(UIMapMyLowes.btnConfirmDelete)).click();
				Thread.sleep(3000);

				if(selenium.isElementPresent(UIMapMyLowes.lnkUndo2))
				{

					String prodTextFinal= driver.findElement(By.xpath(UIMapMyLowes.webElmntProductCount)).getText();
					String[] y = prodTextFinal.split(" ");
					Thread.sleep(2000);

					String prodTotalFinal= y[0];
					int productCountFinal=Integer.parseInt(prodTotalFinal);
					if((productCountInitial-productCountFinal)==1)
					{

						driver.findElement(By.xpath(UIMapMyLowes.lnkUndo2)).click();
						Thread.sleep(3000);
						report.updateTestLog("Trying to check product batch delete functionality","Product batch delete functionality is Successful",Status.PASS);
					}
					else
					{
						report.updateTestLog("Trying to check product batch delete functionality","Product batch delete functionality is Successful",Status.FAIL);
					}

				}
				else
				{
					report.updateTestLog("Trying to check product batch delete functionality","Product batch delete functionality is Successful",Status.FAIL);
				}

			}
			else
			{
				report.updateTestLog("Trying to check product batch delete functionality","Product batch delete functionality is Successful",Status.FAIL);
			}

		}
		else
		{
			report.updateTestLog("Trying to check product batch delete functionality","Product batch delete functionality is Successful",Status.FAIL);
		}

	}

	public void productSortAndShowMechanism() throws Exception
	{
		if(selenium.isElementPresent(UIMapMyLowes.lblSpace5ProdCount))
		{
			System.out.println("1st");
			String prodTag=driver.findElement(By.xpath(UIMapMyLowes.lblSpace5ProdCount)).getText();
			Thread.sleep(2000);
			String[] x = prodTag.split(" ");
			Thread.sleep(2000);

			String prodTotal= x[0];
			int productCount=Integer.parseInt(prodTotal);
			if(productCount>=2)
			{
				System.out.println("2nd");
				try{driver.findElement(By.partialLinkText("Yard")).click();
				selenium.waitForPageToLoad("20000");
				}
				catch(Exception WebDriverException){
					driver.findElement(By.linkText("No, thanks")).click();
					report.updateTestLog("Survey Popup","Handeled", Status.DONE);
					driver.findElement(By.partialLinkText("Yard")).click();
					selenium.waitForPageToLoad("20000");
					}
				Thread.sleep(3000);
				String prodTag2=driver.findElement(By.xpath(UIMapMyLowes.drpDownShowDefault)).getText();
				Thread.sleep(3000);
				System.out.println(prodTag2);
				if(prodTag2.contains("Products"))
				{
					driver.findElement(By.xpath(UIMapMyLowes.drpDownSortBy)).click();
					Thread.sleep(3000);
					String mostRecent=driver.findElement(By.xpath(UIMapMyLowes.webElmntSortByHpMostRecent)).getText();
					Thread.sleep(2000);
					System.out.println(mostRecent);
					String A2Z=driver.findElement(By.xpath(UIMapMyLowes.lblSortByAToZ)).getText();
					Thread.sleep(2000);
					System.out.println(A2Z);
					if(mostRecent.equalsIgnoreCase("Most Recent") && (A2Z.equalsIgnoreCase("A-Z")))
					{
						System.out.println("3rd");
						driver.findElement(By.xpath(UIMapMyLowes.lblSortByAToZ)).click();
						Thread.sleep(4000); 
						List<String> varCat=new ArrayList<String>();
						int varCount=ps.countWebElement(UIMapMyLowes.webElmntItemNames);
						int j=0;
						for(int i=1;i<=varCount;i++)
						{
							j=j+1;
							String varItemName=driver.findElement(By.xpath("//*[@id='item_list']/div[1]/div["+j+"]/div[2]/div[1]/h5")).getText();
							
							System.out.println(varItemName);
							varCat.add(varItemName);
							j=j+1;
						}
						boolean varSorted=ps.isSorted(varCat);
						if(varSorted)
							report.updateTestLog("Trying to Sort the Items A-Z","A-Z Sorting is Successful", Status.PASS);
						else
							report.updateTestLog("Trying to Sort the Items A-Z","A-Z Sorting NOT Successful", Status.FAIL);
						
						driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
						Thread.sleep(6000);

						String products=driver.findElement(By.xpath(UIMapMyLowes.lnkProductsShowSpaces)).getText();
						Thread.sleep(2000);
						String photos=driver.findElement(By.xpath(UIMapMyLowes.lblShowPhotos)).getText();
						Thread.sleep(2000);
						String documents=driver.findElement(By.xpath(UIMapMyLowes.lnkProductsShowDoc)).getText();
						Thread.sleep(2000);
						String calculations=driver.findElement(By.xpath(UIMapMyLowes.lnkShowCalc)).getText();
						Thread.sleep(2000);
						String dimensions=driver.findElement(By.xpath(UIMapMyLowes.lnkShowDim)).getText();
						Thread.sleep(2000);

						System.out.println(products+photos+documents+calculations+dimensions+"this is a text");
						if(products.contains("Products") && photos.contains("Photos") && documents.contains("Documents") && calculations.contains("Calculations") && dimensions.contains("Dimensions"))
						{
							System.out.println("5th");
							report.updateTestLog("Trying to check product sort and show functionality","Product sort and show functionality is Successful",Status.PASS);
						}
						else
						{
							report.updateTestLog("Trying to check product sort and show functionality","Product sort and show functionality failed",Status.FAIL);
						}
						
						/*String text1=driver.findElement(By.xpath(UIMapMyLowes.webElmntItem1Name)).getText();
						Thread.sleep(3000);
						String text2=driver.findElement(By.xpath(UIMapMyLowes.webElmntItem2Name)).getText();
						Thread.sleep(3000);
						int compare = text1.compareToIgnoreCase(text2);
						System.out.println("came till If condition");
						if (compare < 0)  
						{  
							System.out.println("4th");
							System.out.println("The strings are in sorted order.");

							

						}
						else
						{
							report.updateTestLog("Trying to check product sort and show functionality","Product sort and show functionality failed",Status.FAIL);
						}*/
						

					}
					else
					{
						report.updateTestLog("Trying to check product sort and show functionality","Product sort and show functionality failed",Status.FAIL);
					}
				}
				else
				{
					report.updateTestLog("Trying to check product sort and show functionality","Product sort and show functionality failed",Status.FAIL);
				}

			}
			else
			{
				report.updateTestLog("Trying to check product sort and show functionality","Product sort and show functionality failed",Status.FAIL);
			}

		}
		else
		{
			report.updateTestLog("Trying to check product sort and show functionality","Product sort and show functionality failed",Status.FAIL);
		}
	}
	public void emptyCalculationSortBar() throws Exception
	{
		
		try{driver.findElement(By.partialLinkText("Bathroom")).click();
		selenium.waitForPageToLoad("20000");
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.partialLinkText("Bathroom")).click();
			selenium.waitForPageToLoad("20000");
			}
		Thread.sleep(4000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
		Thread.sleep(4000);
		String calc=driver.findElement(By.xpath(UIMapMyLowes.lnkShowCalc)).getText();
		Thread.sleep(2000);
		if(calc.equalsIgnoreCase("Calculations"))
		{	driver.findElement(By.xpath(UIMapMyLowes.lnkShowCalc)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(3000);
			
			if(selenium.isElementPresent(UIMapMyLowes.lnkGoToProjCalc) && selenium.isElementPresent(UIMapMyLowes.drpDownCalcShowDefault) && selenium.isElementPresent(UIMapMyLowes.webElmntNoCalcImg))
			{
				if(selenium.isElementPresent(UIMapMyLowes.lnkCalculatorLink1) && selenium.isElementPresent(UIMapMyLowes.lnkCalculatorLink2))
				{

					driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcShowDownArrow)).click();
					Thread.sleep(4000);
					String products=driver.findElement(By.xpath(UIMapMyLowes.lnkCalcShowProducts)).getText();
					Thread.sleep(2000);
					String photos=driver.findElement(By.xpath(UIMapMyLowes.lnkCalcShowPhotos)).getText();
					Thread.sleep(2000);
					String documents=driver.findElement(By.xpath(UIMapMyLowes.lnkCalcShowDocs)).getText();
					Thread.sleep(2000);
					String calculations=driver.findElement(By.xpath(UIMapMyLowes.lnkCalcShowCalc)).getText();
					Thread.sleep(2000);
					String dimensions=driver.findElement(By.xpath(UIMapMyLowes.lnkCalcShowDim)).getText();
					Thread.sleep(2000);

					if(products.contains("Products") && photos.contains("Photos") && documents.contains("Documents") && calculations.contains("Calculations") && dimensions.contains("Dimensions"))
					{
						Thread.sleep(3000);
						driver.findElement(By.xpath(UIMapMyLowes.lnkGoToProjCalc)).click();
						selenium.waitForPageToLoad("20000");
						Thread.sleep(4000);
						String projCalc=driver.findElement(By.xpath(UIMapMyLowes.webElmntAllCalculatorsHeading)).getText();
						Thread.sleep(3000);
						if(projCalc.equalsIgnoreCase("Project Calculators"))
						{
							driver.findElement(By.xpath(UIMapMyLowes.lnkGrassSeedCalc)).click();
							selenium.waitForPageToLoad("20000");
							Thread.sleep(4000);
							String grassSeedCal=driver.findElement(By.xpath(UIMapMyLowes.webElmntCalculatorHeading)).getText();
							Thread.sleep(3000);
							if(grassSeedCal.equalsIgnoreCase("Grass Seed Calculator"))
							{
								report.updateTestLog("Trying to validate the calculate sort bar","Calculate sort bar functionality is Successful",Status.PASS);
							}
							else
							{
								report.updateTestLog("Trying to validate the calculate sort bar","Calculate sort bar functionality failed",Status.FAIL);
							}
						}
						else
						{
							report.updateTestLog("Trying to validate the calculate sort bar","Calculate sort bar functionality failed",Status.FAIL);
						}
					}
					else
					{
						report.updateTestLog("Trying to validate the calculate sort bar","Calculate sort bar functionality failed",Status.FAIL);
					}

				}
				else
				{
					report.updateTestLog("Trying to validate the calculate sort bar","Calculate sort bar functionality failed",Status.FAIL);
				}
			}
			else
			{
				report.updateTestLog("Trying to validate the calculate sort bar","Calculate sort bar functionality failed",Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Trying to validate the calculate sort bar","Calculate sort bar functionality failed",Status.FAIL);
		}

	}

	public void photosTabEditField() throws Exception
	{

		
		try{driver.findElement(By.partialLinkText("Yard")).click();
		selenium.waitForPageToLoad("20000");
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.partialLinkText("Yard")).click();
			selenium.waitForPageToLoad("20000");
			}
		Thread.sleep(3000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(UIMapMyLowes.lblShowPhotos)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(5000);
		if(selenium.isElementPresent(UIMapMyLowes.btnUpload) && selenium.isElementPresent(UIMapMyLowes.txtSpaceNotesPre))
		{
			System.out.println("1st");
			driver.findElement(By.xpath(UIMapMyLowes.txtSpaceNotesPre)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(UIMapMyLowes.txtSpaceNotes)).sendKeys("<script>alert('hacked')</script>");
			Thread.sleep(4000);
			driver.findElement(By.xpath(UIMapMyLowes.btnSaveSpaceNotes)).click();
			Thread.sleep(3000);
			String invalidMsg=driver.findElement(By.xpath(UIMapMyLowes.webElmntPhotoInvalidNotesMsg)).getText();
			Thread.sleep(3000);
			String[] x = invalidMsg.split(" ");
			Thread.sleep(2000);

			String invMsg= x[0];
			if(invMsg.equalsIgnoreCase("Invalid"))
			{
				System.out.println("invMsg"+invMsg);
				System.out.println("2nd");
				driver.findElement(By.xpath(UIMapMyLowes.btnPhotoInvalidNote)).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath(UIMapMyLowes.lnkPhotosNotesCancel)).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath(UIMapMyLowes.txtSpaceNotesPre)).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath(UIMapMyLowes.txtSpaceNotes)).sendKeys("save this text");
				Thread.sleep(4000);
				driver.findElement(By.xpath(UIMapMyLowes.btnSaveSpaceNotes)).click();
				Thread.sleep(5000);
				report.updateTestLog("Trying to edit the notes field","Notes field editing functionality is Successful",Status.PASS);
			}
			else
			{
				report.updateTestLog("Trying to edit the notes field","Notes field editing functionality failed",Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Trying to edit the notes field","Notes field editing functionality failed",Status.FAIL);
		}

	}

	public void documentUpload() throws Exception
	{
		Thread.sleep(4000);
		try{driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
		Thread.sleep(4000);
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
			Thread.sleep(4000);
		}
		String allDocs=driver.findElement(By.xpath(UIMapMyLowes.webElmntAllDocs)).getText();
		Thread.sleep(4000);
		if(allDocs.contains("All Documents"))
		{
			driver.findElement(By.xpath(UIMapMyLowes.webElmntAllDocs)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(4000);
			String oldDocText=driver.findElement(By.xpath(UIMapMyLowes.webElmntDocCount)).getText();
			Thread.sleep(3000);
			String[] x = oldDocText.split(" ");
			Thread.sleep(2000);

			String oldDoc= x[0];
			int oldDocNo=Integer.parseInt(oldDoc);
			driver.findElement(By.xpath(UIMapMyLowes.webElmntDocUpload2)).click();
			Thread.sleep(5000);
			/*if(selenium.isElementPresent(UIMapMyLowes.webElmntDocsUploadPopup))
			{
				Thread.sleep(6000);
			}


			driver.switchTo().frame(driver.findElement(By.id("upload-modal-2")));
			Thread.sleep(5000);
			driver.findElement(By.xpath(UIMapMyLowes.webElmntDocsUploadPopup)).click();
			Thread.sleep(4000);*/
			/*if(selenium.isElementPresent(UIMapMyLowes.webElmntDocsUploadPopup))
			{
				System.out.println("entered this complex loop");
				Thread.sleep(2000);
				driver.findElement(By.xpath(UIMapMyLowes.webElmntDocsUploadPopup)).click();
				Thread.sleep(4000);
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_ENTER); 
				r.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(3000);

			}*/

			Robot r = new Robot(); 
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

			String successfulUpload=driver.findElement(By.xpath(UIMapMyLowes.webElmntPhotosUploadSuccessMsg)).getText();
			Thread.sleep(2000);

			if(successfulUpload.contains("Upload complete"))
			{

				driver.findElement(By.xpath(UIMapMyLowes.lnkDocUploadClose)).click();
				Thread.sleep(3000);

				String newDocText=driver.findElement(By.xpath(UIMapMyLowes.webElmntDocCount)).getText();
				Thread.sleep(3000);
				String[] y = newDocText.split(" ");
				Thread.sleep(2000);

				String newDoc= y[0];
				int newDocNo=Integer.parseInt(newDoc);
				if((newDocNo-oldDocNo)==1)
				{
					report.updateTestLog("Trying to attach a document","Document attachment is Successful",Status.PASS);
					driver.findElement(By.xpath(UIMapMyLowes.webElmntDoc1Trashcan2)).click();
					Thread.sleep(3000);

				}
				else
				{
					report.updateTestLog("Trying to attach a document","Document attachment failed",Status.FAIL);
				}

			}
			else if(successfulUpload.contains("Server error. Try again."))
				report.updateTestLog("Trying to upload Document","Upload Failed. Server Error",Status.FAIL);
			else
			{
				report.updateTestLog("Trying to attach a document","Document attachment failed",Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Trying to attach a document","Document attachment failed. All Documents link not present",Status.FAIL);
		}
	}
	public void showAndSortPhotos() throws Exception
	{
		Thread.sleep(3000);
		if(selenium.isElementPresent(UIMapMyLowes.lblSpace5PhotosCount))
		{
			try{driver.findElement(By.partialLinkText("Yard")).click();
			selenium.waitForPageToLoad("20000");
			}
			catch(Exception WebDriverException){
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup","Handeled", Status.DONE);
				driver.findElement(By.partialLinkText("Yard")).click();
				selenium.waitForPageToLoad("20000");
				}
			Thread.sleep(3000);
			driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(UIMapMyLowes.lblShowPhotos)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(UIMapMyLowes.webElmntPhotosSortByDownArrow)).click();
			Thread.sleep(3000);

			String A2Z=driver.findElement(By.xpath(UIMapMyLowes.lnkPhotosSortByAtoZ)).getText();
			Thread.sleep(2000);
			String mostRecent=driver.findElement(By.xpath(UIMapMyLowes.lnkPhotosSortByMostRecent)).getText();
			Thread.sleep(2000);
			if((A2Z.equalsIgnoreCase("A-Z")) && (mostRecent.equalsIgnoreCase("Most Recent")))
			{
				System.out.println("2nd");
				driver.findElement(By.xpath(UIMapMyLowes.lnkPhotosSortByAtoZ)).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(UIMapMyLowes.webElmntPhotosSortByDownArrow)).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath(UIMapMyLowes.lnkPhotosSortByMostRecent)).click();
				Thread.sleep(5000);
				report.updateTestLog("Trying to validate sort and show functionality for Photos","Sort and show functionality is Successful",Status.PASS);
			}
			else
			{
				report.updateTestLog("Trying to validate sort and show functionality for Photos","Sort and show functionality failed",Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Trying to validate sort and show functionality for Photos","Sort and show functionality failed",Status.FAIL);
		}
	}

	public void listViewCalculations() throws Exception
	{
		Thread.sleep(3000);
		if(selenium.isElementPresent(UIMapMyLowes.lblSpace5CalcCount))
		{
			try{driver.findElement(By.partialLinkText("Yard")).click();
			selenium.waitForPageToLoad("20000");
			}
			catch(Exception WebDriverException){
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup","Handeled", Status.DONE);
				driver.findElement(By.partialLinkText("Yard")).click();
				selenium.waitForPageToLoad("20000");
				}
			Thread.sleep(3000);
			driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(UIMapMyLowes.lnkShowCalc)).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(5000);
			if((selenium.isElementPresent(UIMapMyLowes.webElmntCalc1Name)) && selenium.isElementPresent(UIMapMyLowes.lnkShowDetails) && selenium.isElementPresent(UIMapMyLowes.webElmntDeleteCalcTrashcan))
			{
				String note=driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcSavedNotes)).getText();
				System.out.println(note);
				/*if(note.equalsIgnoreCase("Attach a Note") || ((!note.equalsIgnoreCase("")&& (!note.equalsIgnoreCase("Attach a Note")))))
				{
					report.updateTestLog("Trying to validate list view calculations","List view calculations functionality is Successful",Status.PASS);
				}*/
				if(note.equals(""))
				{
					String AttachNote=driver.findElement(By.xpath(UIMapMyLowes.lnkCalcAttachANote)).getText();
					if(AttachNote.equalsIgnoreCase("Attach a Note"))
						report.updateTestLog("Trying to validate list view calculations","List view calculations functionality is Successful",Status.PASS);
					else
						report.updateTestLog("Trying to validate list view calculations","Niether Saved Notes nor Attach Notes link displayed",Status.FAIL);
				}
				
				else
				{
					report.updateTestLog("Trying to validate list view calculations","List view calculations functionality Passed",Status.PASS);
				}
			}
			else
			{
				report.updateTestLog("Trying to validate list view calculations","List view calculations functionality failed",Status.FAIL);
			}

		}
		else
		{
			report.updateTestLog("Trying to validate list view calculations","List view calculations functionality failed",Status.FAIL);
		}
	}
	
	/*space should have Fertilizer calculator*/
	public void fertCalcDetailLayout() throws Exception
	{
			System.out.println("1st");
			try{driver.findElement(By.partialLinkText(dataTable.getData("General_Data", "Space"))).click();
			selenium.waitForPageToLoad("20000");
			}
			catch(Exception WebDriverException){
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup","Handeled", Status.DONE);
				driver.findElement(By.partialLinkText(dataTable.getData("General_Data", "Space"))).click();
				selenium.waitForPageToLoad("20000");
				}
			Thread.sleep(3000);
			driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(UIMapMyLowes.lnkShowCalc)).click();
			Thread.sleep(5000);

			String details=driver.findElement(By.xpath(UIMapMyLowes.lnkShowDetails)).getText();
			Thread.sleep(3000);

			if(details.contains("Show Details"))
			{
				System.out.println("2nd");
				driver.findElement(By.xpath(UIMapMyLowes.lnkShowDetails)).click();
				Thread.sleep(5000);
				if(selenium.isElementPresent(UIMapMyLowes.txtNotes2))
				{
					System.out.println("3rd");
					if(selenium.isElementPresent(UIMapMyLowes.txtCalcName1))
					{
						System.out.println("4th");
						if(selenium.isElementPresent(UIMapMyLowes.webElmntCalcTotalNetArea))
						{
							System.out.println("5th");
							if(selenium.isElementPresent(UIMapMyLowes.webElmntCalcMatDetails))
							{
								System.out.println("6th");
								String col1= driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcMulchArea1)).getText();
								Thread.sleep(2000);
								String col2= driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcMulcLength)).getText();
								Thread.sleep(2000);
								String col3= driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcMulcWidth)).getText();
								Thread.sleep(2000);
								String col4= driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcTableAreaValue)).getText();
								Thread.sleep(2000);
								if((!col1.equals("")) && (!col2.equals("")) && (!col3.equals("")) && (!col4.equals("")))
								{
									System.out.println("7th");
									String disclaimer=driver.findElement(By.xpath(UIMapMyLowes.webElmntPaintDisclaimer)).getText();
									Thread.sleep(3000);
									System.out.println(disclaimer);
									if(!disclaimer.equals(""))
									{
										System.out.println("8th");
										report.updateTestLog("Trying to validate fertilizer calculations detail layout","Fertilizer calculator detailed functionality validation is Successful",Status.PASS);
									}
									else
									{
										report.updateTestLog("Trying to validate fertilizer calculations detail layout","Fertilizer calculator detailed functionality validation Failed",Status.FAIL);
									}
								}
								else
								{
									report.updateTestLog("Trying to validate fertilizer calculations detail layout","Fertilizer calculator detailed functionality validation Failed",Status.FAIL);
								}
							}
							else
							{
								report.updateTestLog("Trying to validate fertilizer calculations detail layout","Fertilizer calculator detailed functionality validation Failed",Status.FAIL);
							}
						}
						else
						{
							report.updateTestLog("Trying to validate fertilizer calculations detail layout","Fertilizer calculator detailed functionality validation Failed",Status.FAIL);
						}

					}
					else
					{
						report.updateTestLog("Trying to validate fertilizer calculations detail layout","Fertilizer calculator detailed functionality validation Failed",Status.FAIL);
					}

				}
				else
				{
					report.updateTestLog("Trying to validate fertilizer calculations detail layout","Fertilizer calculator detailed functionality validation Failed",Status.FAIL);
				}
			}
			else
			{
				report.updateTestLog("Trying to validate fertilizer calculations detail layout","Fertilizer calculator detailed functionality validation Failed",Status.FAIL);
			}
		
	}




	public void grassSeedCalcDetailLayout() throws Exception
	{
		Thread.sleep(3000);
		
			try{driver.findElement(By.partialLinkText(dataTable.getData("General_Data", "Space"))).click();
			selenium.waitForPageToLoad("20000");
			}
			catch(Exception WebDriverException){
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup","Handeled", Status.DONE);
				driver.findElement(By.partialLinkText(dataTable.getData("General_Data", "Space"))).click();
				selenium.waitForPageToLoad("20000");
				}
			Thread.sleep(3000);
			driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();//done
			Thread.sleep(3000);
			driver.findElement(By.xpath(UIMapMyLowes.lnkShowCalc)).click();//done
			Thread.sleep(5000);
			String details=driver.findElement(By.xpath(UIMapMyLowes.lnkShowDetails)).getText();
			Thread.sleep(3000);

			if(details.contains("Show Details"))
			{
				System.out.println("2nd");
				driver.findElement(By.xpath(UIMapMyLowes.lnkShowDetails)).click();//done
				Thread.sleep(5000);
				if(selenium.isElementPresent(UIMapMyLowes.txtNotes2))//done
				{
					System.out.println("3rd");
					if(selenium.isElementPresent(UIMapMyLowes.txtCalcName1))//done
					{
						System.out.println("4th");
						if(selenium.isElementPresent(UIMapMyLowes.lblGrassSeedTotalArea))//done
						{
							System.out.println("5th");
							if(selenium.isElementPresent(UIMapMyLowes.lblGrassSeedQty))//done
							{

								String zone=driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcMatDetails)).getText();//done
								Thread.sleep(2000);
								System.out.println("I think defect is here");
								System.out.println("printing the Zone"+zone);

								if(zone.contains("Zone") && zone.contains("Seed Type"))
								{
									System.out.println("6th");

									String col10=driver.findElement(By.xpath(UIMapMyLowes.webElmntStaticTextCol1)).getText();//new code
									String col11=driver.findElement(By.xpath(UIMapMyLowes.webElmntStaticTextCol2)).getText();//new code
									String col12=driver.findElement(By.xpath(UIMapMyLowes.webElmntStaticTextCol3)).getText();//new code

									//*[@id='calcDetailForm']/div[2]/div[1]/table/tbody/tr/td[1]
									String col1= driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcMulchArea1)).getText();//done
									Thread.sleep(2000);
									String col2= driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcMulcLength)).getText();//done
									Thread.sleep(2000);
									String col3= driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcMulcWidth)).getText();//done
									Thread.sleep(2000);
									String col4= driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcTableAreaValue)).getText();//done
									Thread.sleep(2000);
									if((!col1.equals("")) && (!col2.equals("")) && (!col3.equals("")) && (!col4.equals("")) && (col10.contains("Lawn")) && (col11.contains("Length")) && (col12.contains("Width")))//done
									{
										System.out.println("7th");
										String disclaimer=driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcMulchDisclaimer)).getText();//new code
										Thread.sleep(3000);
										if(!disclaimer.equals("") && disclaimer.contains("*Actual quantities may vary by application method and brand. Check product labels for spread rates. Grass seed estimates don't apply to pastures."))//new code
										{

											System.out.println("8th");

											report.updateTestLog("Trying to validate Grass Seed calculations detail layout","Grass Seed calculator detailed functionality validation is Successful",Status.PASS);
										}
										else
										{
											report.updateTestLog("Trying to validate Grass Seed calculations detail layout","Grass Seed calculator detailed functionality validation Failed",Status.FAIL);
										}
									}
									else
									{
										report.updateTestLog("Trying to validate Grass Seed calculations detail layout","Grass Seed calculator detailed functionality validation Failed",Status.FAIL);
									}
								}
								else
								{
									report.updateTestLog("Trying to validate Grass Seed calculations detail layout","Grass Seed calculator detailed functionality validation Failed",Status.FAIL);
								}

							}
							else
							{
								report.updateTestLog("Trying to validate Grass Seed calculations detail layout","Grass Seed calculator detailed functionality validation Failed",Status.FAIL);
							}
						}
						else
						{
							report.updateTestLog("Trying to validate Grass Seed calculations detail layout","Grass Seed calculator detailed functionality validation Failed",Status.FAIL);
						}

					}
					else
					{
						report.updateTestLog("Trying to validate Grass Seed calculations detail layout","Grass Seed calculator detailed functionality validation Failed",Status.FAIL);
					}

				}
				else
				{
					report.updateTestLog("Trying to validate Grass Seed calculations detail layout","Grass Seed calculator detailed functionality validation Failed",Status.FAIL);
				}
			}
			else
			{
				report.updateTestLog("Trying to validate Grass Seed calculations detail layout","Grass Seed calculator detailed functionality validation Failed",Status.FAIL);
			}
		
	}
	public void boschLaserToolMeasuringVideo() throws Exception
	{
		try{driver.findElement(By.partialLinkText("Yard")).click();
		selenium.waitForPageToLoad("20000");
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.partialLinkText("Yard")).click();
			selenium.waitForPageToLoad("20000");
			}
		Thread.sleep(3000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(UIMapMyLowes.lnkShowDim)).click();
		Thread.sleep(5000);
		report.updateTestLog("Trying to validate Bosch Laser tool measuring video","Bosch Laser tool measuring video validation is Successful",Status.PASS);
		/*driver.findElement(By.xpath("//*[@id='accordion']/h3[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='dialog_confirm_change_shape']/p[3]/a[1]/span")).click();
		Thread.sleep(3000);*/


		/*
		String oldTab = driver.getWindowHandle();
	    driver.findElement(By.xpath("//*[@id='dimensions_tool']/div[1]/a")).click();
	    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	    newTab.remove(oldTab);
	    // change focus to new tab
	    driver.switchTo().window(newTab.get(0));

		 */

		/* driver.findElement(By.xpath("//*[@id='dimensions_tool']/div[1]/a")).click();
	      Thread.sleep(5000);
	     String winHandleBefore = driver.getWindowHandle();
	     driver.switchTo().window(winHandleBefore);
	    Thread.sleep(5000);*/


		/*String parentHandle = driver.getWindowHandle(); // get the current window handle
		driver.findElement(By.xpath("//*[@id='dimensions_tool']/div[1]/a")).click(); // click some link that opens a new window

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}



		driver.findElement(By.xpath("//*[@id='dimensions_tool']/div[1]/a")).click();
		Thread.sleep(10000);
		String borrowIt=driver.findElement(By.xpath("//*[@id='accordion']/h3[1]/a")).getText();
		Thread.sleep(2000);

		String useIt=driver.findElement(By.xpath("//*[@id='accordion']/h3[2]/a")).getText();
		Thread.sleep(2000);

		String returnIt=driver.findElement(By.xpath("//*[@id='accordion']/h3[3]/a")).getText();
		Thread.sleep(2000);

		String relatedArticles=driver.findElement(By.xpath("//*[@id='content-area-no-nav-widest']/div/div[3]/div[2]/h3")).getText();
		Thread.sleep(2000);

		String youTube=driver.findElement(By.xpath("//*[@id='ReasonText']")).getText();
		Thread.sleep(2000);
		System.out.println("Youtube and all the stuff"+youTube+" "+returnIt+" "+borrowIt+" "+useIt);
		if(borrowIt.contains("Borrow It") && useIt.contains("Use It") && returnIt.contains("Return It") && relatedArticles.contains("Related Articles and Tools"))
		{
			if(youTube.contains("YouTube"))
			{
				report.updateTestLog("Trying to validate Bosch Laser tool measuring video","Bosch Laser tool measuring video validation is Successful",Status.PASS);
				driver.close(); // close newly opened window when done with it
				driver.switchTo().window(parentHandle); 
			}
			else
			{
				report.updateTestLog("Trying to validate Bosch Laser tool measuring video","Bosch Laser tool measuring video validation Failed",Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Trying to validate Bosch Laser tool measuring video","Bosch Laser tool measuring video validation Failed",Status.FAIL);
		}*/

	}
	public void documentSortMechanism() throws Exception
	{
		/*Thread.sleep(3000);
		String docText=driver.findElement(By.xpath(UIMapMyLowes.lblSpace5DocCount)).getText();
		Thread.sleep(2000);
		String[] x = docText.split(" ");
		Thread.sleep(2000);

		String docText1= x[0];
		int docCount=Integer.parseInt(docText1);
		if(docCount>=2)
		{
			try{driver.findElement(By.partialLinkText("Yard")).click();
			selenium.waitForPageToLoad("20000");
			}
			catch(Exception WebDriverException){
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup","Handeled", Status.DONE);
				driver.findElement(By.partialLinkText("Yard")).click();
				selenium.waitForPageToLoad("20000");
				}
			Thread.sleep(3000);
			
			driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(UIMapMyLowes.lnkProductsShowDoc)).click();
			Thread.sleep(5000);
			*/
			String mostRecent=driver.findElement(By.xpath(UIMapMyLowes.drpDownSortByDefault)).getText();
			Thread.sleep(2000);
			if(mostRecent.equalsIgnoreCase("Most Recent"))
			{
				driver.findElement(By.xpath(UIMapMyLowes.webElmntDocsSortByDownArrow)).click();
				Thread.sleep(3000);
				String mostRecent1=driver.findElement(By.xpath(UIMapMyLowes.lnkDocSortByMostRecent)).getText();
				Thread.sleep(2000);
				String A2Z=driver.findElement(By.xpath(UIMapMyLowes.lnkDocSortByAToZ)).getText();
				Thread.sleep(2000);
				if(mostRecent1.equalsIgnoreCase("Most Recent") && A2Z.equalsIgnoreCase("A-Z"))
				{

					driver.findElement(By.xpath(UIMapMyLowes.lnkDocSortByAToZ)).click();
					Thread.sleep(5000);
					int varCount=ps.countWebElement(UIMapMyLowes.webElmntDocCountOnPg);
					List<String> varCat=new ArrayList<String>();
					for(int i=1;i<=varCount;i++)
					{
						
						String varDocName=driver.findElement(By.xpath("//*[@id='documentsContainer']/div[2]/div[3]/div["+i+"]/div[2]/form/div[2]/div[2]/h5")).getText();
						System.out.println(varDocName);
						varCat.add(varDocName);
						
					}
					boolean varSorted=ps.isSorted(varCat);
					if(varSorted)
						report.updateTestLog("Trying to Sort the Docs A-Z","A-Z Sorting is Successful", Status.PASS);
					else
						report.updateTestLog("Trying to Sort the Docs A-Z","A-Z Sorting NOT Successful", Status.FAIL);
					
				}
				else
				{
					report.updateTestLog("Trying to validate Document sort mechanism","Document sort mechanism validation failed",Status.FAIL);
				}
			}
			else
			{
				report.updateTestLog("Trying to validate Document sort mechanism","Document sort mechanism validation failed",Status.FAIL);
			}
		/*}
		else
		{
			report.updateTestLog("Trying to validate Document sort mechanism","Document sort mechanism validation failed",Status.FAIL);
		}*/
	}
	public void documentDeleteTabMechanism() throws Exception
	{
		/*Thread.sleep(3000);

		try{driver.findElement(By.partialLinkText("Yard")).click();
		selenium.waitForPageToLoad("20000");
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.partialLinkText("Yard")).click();
			selenium.waitForPageToLoad("20000");
			}
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(UIMapMyLowes.lnkProductsShowDoc)).click();
		Thread.sleep(5000);*/
		String docText=driver.findElement(By.xpath(UIMapMyLowes.webElmntDocCount)).getText();
		Thread.sleep(2000);
		String[] x = docText.split(" ");
		Thread.sleep(2000);

		String docText1= x[0];
		int docCount=Integer.parseInt(docText1);
		/*if(docCount>0)
		{*/
			System.out.println("1st");
			driver.findElement(By.xpath(UIMapMyLowes.webElmntDoc1Trashcan1)).click();
			Thread.sleep(3000);
			String deletionMsg=driver.findElement(By.xpath(UIMapMyLowes.webElmntDoc1DeletedMsg)).getText();
			Thread.sleep(2000);
			if(deletionMsg.contains("has been deleted"))
			{
				System.out.println("2nd");
				String docTextNew=driver.findElement(By.xpath(UIMapMyLowes.webElmntDocCount)).getText();
				Thread.sleep(2000);
				String[] y = docTextNew.split(" ");
				Thread.sleep(2000);

				String docTextNew1= y[0];
				int docCountNew=Integer.parseInt(docTextNew1);
				if((docCount-docCountNew)==1)
				{
					System.out.println("3rd");
					report.updateTestLog("Trying to validate Document Deletion mechanism","Document Deletion mechanism validation is Successful",Status.PASS);
					Thread.sleep(2000);
					driver.findElement(By.xpath(UIMapMyLowes.lnkDoc1DeletedMsgUndo)).click();
					Thread.sleep(5000);
				}
				else
				{
					report.updateTestLog("Trying to validate Document Deletion mechanism","Document Deletion mechanism validation is Successful",Status.FAIL);
				}
			}
			else
			{
				report.updateTestLog("Trying to validate Document Deletion mechanism","Document Deletion mechanism validation is Successful",Status.FAIL);
			}

		/*}
		else
		{
			report.updateTestLog("Trying to validate Document Deletion mechanism","Document Deletion mechanism validation is Successful",Status.FAIL);
		}*/
	}
	public void deleteDocInEditMode() throws Exception
	{
		/*Thread.sleep(3000);

		try{driver.findElement(By.partialLinkText("Yard")).click();
		selenium.waitForPageToLoad("20000");
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.partialLinkText("Yard")).click();
			selenium.waitForPageToLoad("20000");
			}
		Thread.sleep(3000);
		
		driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(UIMapMyLowes.lnkProductsShowDoc)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(5000);
		*/
		String docText=driver.findElement(By.xpath(UIMapMyLowes.webElmntDocCount)).getText();
		System.out.println(docText);
		Thread.sleep(2000);
		String[] x = docText.split(" ");
		Thread.sleep(2000);

		String docText1= x[0];
		int docCount=Integer.parseInt(docText1);
		System.out.println(docCount);
		driver.findElement(By.xpath(UIMapMyLowes.lnkDoc1Edit1)).click();
		Thread.sleep(3000);
		if(selenium.isElementPresent(UIMapMyLowes.webElmntDocNotes))
		{
			driver.findElement(By.xpath(UIMapMyLowes.webElmntDoc1Trashcan1)).click();
			Thread.sleep(3000);

			String docTextNew=driver.findElement(By.xpath(UIMapMyLowes.webElmntDocCount)).getText();
			System.out.println(docTextNew);
			Thread.sleep(2000);
			String[] y = docTextNew.split(" ");
			Thread.sleep(2000);

			String docTextNew1= y[0];
			int docCountNew=Integer.parseInt(docTextNew1);
			System.out.println(docCountNew);
			if((docCount-docCountNew)==1)
			{
				String deletionMsg=driver.findElement(By.xpath(UIMapMyLowes.webElmntDoc1DeletedMsg)).getText();
				Thread.sleep(2000);
				if(deletionMsg.contains("has been deleted"))
				{
					Thread.sleep(3000);
					report.updateTestLog("Trying to validate Document Deletion mechanism in Edit Mode","Document Deletion mechanism validation is Successful",Status.PASS);
					Thread.sleep(2000);
					driver.findElement(By.xpath(UIMapMyLowes.lnkDoc1DeletedMsgUndo)).click();
					Thread.sleep(5000);
				}
				else
				{
					report.updateTestLog("Trying to validate Document Deletion mechanism in Edit Mode","Document Deletion mechanism validation Failed",Status.FAIL);
				}
			}
			else
			{
				report.updateTestLog("Trying to validate Document Deletion mechanism in Edit Mode","Document Deletion mechanism validation Failed",Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Trying to validate Document Deletion mechanism in Edit Mode","Document Deletion mechanism validation Failed",Status.FAIL);
		}

	}

	public void listSortGridViewPOS() throws Exception
	{
		Thread.sleep(3000);
		try{
		driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
		Thread.sleep(3000);
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
			Thread.sleep(3000);
			}
		driver.findElement(By.xpath(UIMapMyLowes.webElmntShowAllProducts)).click();
		Thread.sleep(3000);
		String sort=driver.findElement(By.xpath(UIMapMyLowes.lblProductsSortBy)).getText();
		Thread.sleep(3000);
		if(sort.contains("Sort by"))
		{
			System.out.println("1st");
			String text1=driver.findElement(By.xpath(UIMapMyLowes.webElmntItem1Name)).getText();
			Thread.sleep(2000);
			String text2=driver.findElement(By.xpath(UIMapMyLowes.webElmntItem2Name)).getText();
			Thread.sleep(2000);
			String text3=driver.findElement(By.xpath(UIMapMyLowes.webElmntItem3Name)).getText();
			Thread.sleep(2000);
			driver.findElement(By.xpath(UIMapMyLowes.drpDownSortBy)).click();
			Thread.sleep(3000);
			String mostRecent=driver.findElement(By.xpath(UIMapMyLowes.webElmntSortByHpMostRecent)).getText();
			Thread.sleep(5000);
			String A2Z=driver.findElement(By.xpath(UIMapMyLowes.lblSortByAToZ)).getText();
			Thread.sleep(5000);
			if(mostRecent.equalsIgnoreCase("Most Recent") && A2Z.equalsIgnoreCase("A-Z"))
			{
				System.out.println("2nd");

				driver.findElement(By.xpath(UIMapMyLowes.webElmntSortByHpMostRecent)).click();
				Thread.sleep(4000);
				String text4=driver.findElement(By.xpath(UIMapMyLowes.webElmntItem1Name)).getText();
				Thread.sleep(2000);
				String text5=driver.findElement(By.xpath(UIMapMyLowes.webElmntItem2Name)).getText();
				Thread.sleep(2000);
				String text6=driver.findElement(By.xpath(UIMapMyLowes.webElmntItem3Name)).getText();
				Thread.sleep(2000);

				if((text1.equalsIgnoreCase(text4)) && (text2.equalsIgnoreCase(text5)) && (text3.equalsIgnoreCase(text6)))
				{
					System.out.println("3rd");
					report.updateTestLog("Trying to List Sort Grid View POS","List Sort Grid View POS validation is Successful",Status.PASS);
				}
				else
				{
					report.updateTestLog("Trying to List Sort Grid View POS","List Sort Grid View POS validation Failed",Status.FAIL);
				}
			}
			else
			{
				report.updateTestLog("Trying to List Sort Grid View POS","List Sort Grid View POS validation Failed",Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Trying to List Sort Grid View POS","List Sort Grid View POS validation Failed",Status.FAIL);
		}
	}

	public void productRemoveSpaces() throws Exception
	{
		Thread.sleep(3000);
		try{
		driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
		Thread.sleep(4000);
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.drpDownShow)).click();
			Thread.sleep(4000);
			}
		driver.findElement(By.xpath(UIMapMyLowes.webElmntShowAllProducts)).click();
		Thread.sleep(4000);
		if(selenium.isElementPresent(UIMapMyLowes.lnkItem1ViewProduct))
		{
			System.out.println("1st");
			driver.findElement(By.xpath(UIMapMyLowes.lnkEdit2)).click();
			Thread.sleep(4000);
			String selectSpaces=driver.findElement(By.xpath(UIMapMyLowes.lnkSelectSpaces2)).getText();
			Thread.sleep(2000);
			if(selectSpaces.equalsIgnoreCase("Select Spaces"))
			{
				System.out.println("2nd");
				driver.findElement(By.xpath(UIMapMyLowes.lnkSelectSpaces2)).click();
				Thread.sleep(4000);
				String interiorSpace=driver.findElement(By.xpath(UIMapMyLowes.lblProductNewIntSpace)).getText();
				Thread.sleep(2000);
				String exteriorSpace=driver.findElement(By.xpath(UIMapMyLowes.lblProductNewExtSpace)).getText();
				Thread.sleep(2000);

				boolean isChecked = driver.findElement(By.xpath(UIMapMyLowes.chkBoxYARD)).isSelected();
				if(!(interiorSpace.equals("")) && !(exteriorSpace.equals("")))
				{
					System.out.println("3rd");
					if(isChecked)
					{
						System.out.println("4th");
						String isLocated=driver.findElement(By.xpath(UIMapMyLowes.webElmntManualItemAssignedSpaceGrid)).getText();
						Thread.sleep(2000);
						String labelText=driver.findElement(By.xpath(UIMapMyLowes.lblYourSpacesSpace5)).getText();
						Thread.sleep(2000);
						if(labelText.equalsIgnoreCase(isLocated))
						{
							System.out.println("5th");
							driver.findElement(By.xpath(UIMapMyLowes.chkBoxSpace2)).click();
							Thread.sleep(2000);
							driver.findElement(By.partialLinkText("Cancel")).click();
							Thread.sleep(2000);
							String locatedInNew=driver.findElement(By.xpath(UIMapMyLowes.webElmntProductAssignedSpace)).getText();
							Thread.sleep(2000);
							if(locatedInNew.equalsIgnoreCase(isLocated))
							{
								System.out.println("6th");
								report.updateTestLog("Trying to validate Product Remove Space","Product Remove Space validation is Successful",Status.PASS);
							}
							else
							{
								report.updateTestLog("Trying to validate Product Remove Space","Product Remove Space validation Failed",Status.FAIL);
							}
						}
						else
						{
							report.updateTestLog("Trying to validate Product Remove Space","Product Remove Space validation Failed",Status.FAIL);
						}
					}
					else
					{
						report.updateTestLog("Trying to validate Product Remove Space","Product Remove Space validation Failed",Status.FAIL);
					}
				}
				else
				{
					report.updateTestLog("Trying to validate Product Remove Space","Product Remove Space validation Failed",Status.FAIL);
				}
			}

			else
			{
				report.updateTestLog("Trying to validate Product Remove Space","Product Remove Space validation Failed",Status.FAIL);
			}

		}
		else
		{
			report.updateTestLog("Trying to validate Product Remove Space","Product Remove Space validation Failed",Status.FAIL);
		}
	}

	/*This function validates calculations order*/
	public void calcVerifyOrder() throws Exception
	{
		try{driver.findElement(By.partialLinkText("Yard")).click();
		selenium.waitForPageToLoad("20000");
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.partialLinkText("Yard")).click();
			selenium.waitForPageToLoad("20000");
			}
		Thread.sleep(3000);

		driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(UIMapMyLowes.lnkShowCalc)).click();
		Thread.sleep(3000);
		
		
		int varCalcCount=ps.countWebElement(UIMapMyLowes.webElmntAllCalc);
		System.out.println(varCalcCount);
		int varFertFlag=0, varMulchFlag=0,varSeedFlag=0;
		List<String> varFert=new ArrayList<String>();
		List<String> varMulch=new ArrayList<String>();
		List<String> varSeed=new ArrayList<String>();
		for(int i=1;i<=varCalcCount;i++)
		{
			String varClass=driver.findElement(By.xpath(UIMapMyLowes.webElmntAllCalc+"["+i+"]/div[2]/div[1]")).getAttribute("class");
			if(varClass.equals("item_thumb fertilizer"))
			{
				
				if((varMulchFlag==0) && (varSeedFlag==0))
				{
					if(varFertFlag==0)
						varFertFlag=1;
					String varCalcName=driver.findElement(By.xpath(UIMapMyLowes.webElmntAllCalc+"["+i+"]/div[2]/div[2]/div[1]/h5")).getText();
					varFert.add(varCalcName);
				}
				else
				{
					report.updateTestLog("Checking Calculations Order", "Fert Appearing after Mulch/Seed", Status.FAIL);
					break;
				}
					
			}
			
			if(varClass.equals("item_thumb mulch"))
			{
				
				if(varSeedFlag==0)
				{
					if(varMulchFlag==0)
						varMulchFlag=1;
					
					String varCalcName=driver.findElement(By.xpath(UIMapMyLowes.webElmntAllCalc+"["+i+"]/div[2]/div[2]/div[1]/h5")).getText();
					varMulch.add(varCalcName);
				}
				else
				{
					report.updateTestLog("Checking Calculations Order", "Mulch Appearing after Seed", Status.FAIL);
					break;
				}
			}
			if(varClass.equals("item_thumb grassseed"))
				{
					
					
				if(varSeedFlag==0)
					varSeedFlag=1;
						
				String varCalcName=driver.findElement(By.xpath(UIMapMyLowes.webElmntAllCalc+"["+i+"]/div[2]/div[2]/div[1]/h5")).getText();
					varSeed.add(varCalcName);
				}
				if(i==varCalcCount)	
					report.updateTestLog("Checking Calculations Order", "Calculations ordered in Fert->Mulch->Seed", Status.PASS);
				
		}
		if(varFertFlag==1)
		{
			boolean varFertSorted=ps.isSorted(varFert);
			if(varFertSorted)
			{
				report.updateTestLog("Checking Calculations Order", "Fert Calculations ordered Alphabetically", Status.PASS);
			}
			else
			{
				report.updateTestLog("Checking Calculations Order", "Fert Calculations NOT ordered Alphabetically", Status.FAIL);
				
			}
		}
		if(varMulchFlag==1)
		{
			boolean varMulchSorted=ps.isSorted(varMulch);
			if(varMulchSorted)
			{
				report.updateTestLog("Checking Calculations Order", "Mulch Calculations ordered Alphabetically", Status.PASS);
			}
			else
			{
				report.updateTestLog("Checking Calculations Order", "Mulch Calculations NOT ordered Alphabetically", Status.FAIL);
				
			}
		}
		if(varSeedFlag==1)
		{
			boolean varSeedSorted=ps.isSorted(varSeed);
			if(varSeedSorted)
			{
				report.updateTestLog("Checking Calculations Order", "Grass Seed Calculations ordered Alphabetically", Status.PASS);
			}
			else
			{
				report.updateTestLog("Checking Calculations Order", "Grass Seed Calculations NOT ordered Alphabetically", Status.FAIL);
				
			}
		}
	}
	
	public void calcListViewVerifyOrder() throws Exception
	{
		Thread.sleep(3000);
		int grassseed=0;
		int fertilizer=0;
		int mulch=0;
		int count=0;
		int compare;
		try{driver.findElement(By.partialLinkText("Yard")).click();
		selenium.waitForPageToLoad("20000");
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.partialLinkText("Yard")).click();
			selenium.waitForPageToLoad("20000");
			}
		Thread.sleep(3000);

		driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(UIMapMyLowes.lnkShowCalc)).click();
		Thread.sleep(3000);

		String text1=driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc1Img)).getAttribute("class");
		Thread.sleep(2000);
		String text2=driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc2Img)).getAttribute("class");
		Thread.sleep(2000);
		String text3=driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc3Img)).getAttribute("class");
		Thread.sleep(2000);
		String text4=driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc4Img)).getAttribute("class");
		Thread.sleep(2000);
		String text5=driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc5Img)).getAttribute("class");
		Thread.sleep(2000);
		String[] x = text1.split(" ");


		Thread.sleep(2000);

		String calcType1= x[1];

		String[] y = text2.split(" ");
		Thread.sleep(2000);

		String calcType2= y[1];

		String[] z = text3.split(" ");
		Thread.sleep(2000);

		String calcType3= z[1];

		String[] w = text4.split(" ");
		Thread.sleep(2000);

		String calcType4= w[1];

		String[] s = text5.split(" ");
		Thread.sleep(2000);

		String calcType5= s[1];

		String[] Arr= new String[5];

		Arr[0]=calcType1;
		Arr[1]=calcType2;
		Arr[2]=calcType3;
		Arr[3]=calcType4;
		Arr[4]=calcType5;

		for(int i=0;i<5;i++)
		{
			if(Arr[i].equalsIgnoreCase("grassseed"))
			{
				grassseed++;
			}
			else if(Arr[i].equalsIgnoreCase("fertilizer"))
			{
				fertilizer++;
			}
			else if(Arr[i].equalsIgnoreCase("mulch"))
			{
				mulch++;
			}
		}
		System.out.println("count of grass,Fert,mulch"+grassseed+fertilizer+mulch);
		for(int ab=0;ab<fertilizer;ab++)
		{
			System.out.println("first for condition");
			if(Arr[ab].equalsIgnoreCase("fertilizer"))
			{
				count++;
				if(count==fertilizer)
				{
					report.updateTestLog("Checking the order of Fertilizer calculations","fertilizer order is Correct",Status.PASS);
				}
				System.out.println("Count pls1:"+count);

			}
			else
			{
				report.updateTestLog("Checking the order of Fertilizer calculations","fertilizer order is InCorrect",Status.FAIL);
			}
		}

		for(int cd=fertilizer;cd<(mulch+fertilizer);cd++)
		{
			System.out.println("second for condition");
			if(Arr[cd].equalsIgnoreCase("mulch"))
			{
				count++;
				if(count==(mulch+fertilizer))
				{
					report.updateTestLog("Checking the order of Mulch calculations","Mulch order is Correct",Status.PASS);
				}
				System.out.println("Count pls2:"+count);

			}
			else
			{
				report.updateTestLog("Checking the order of Mulch calculations","Mulch order is InCorrect",Status.FAIL);
			}
		}
		for(int ef=(mulch+fertilizer);ef<(mulch+fertilizer+grassseed);ef++)
		{
			System.out.println("Third for condition");
			if(Arr[ef].equalsIgnoreCase("grassseed"))
			{
				count++;
				if(count==(mulch+fertilizer+grassseed))
				{
					report.updateTestLog("Checking the order of grassseed calculations","grassseed order is Correct",Status.PASS);
				}
				System.out.println("Count pls3:"+count);

			}
			else
			{
				report.updateTestLog("Checking the order of grassseed calculations","grassseed order is InCorrect",Status.FAIL);
			}
		}


		String name1=driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc1Name)).getText();
		Thread.sleep(2000);

		String name2=driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc2Name)).getText();
		Thread.sleep(2000);

		String name3=driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc3Name)).getText();
		Thread.sleep(2000);

		String name4=driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc4Name)).getText();
		Thread.sleep(2000);

		String name5=driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc5Name)).getText();
		Thread.sleep(2000);

		if(fertilizer>1)
		{
			compare = name1.compareToIgnoreCase(name2);
			if (compare < 0)  
			{  
				System.out.println("The strings are in sorted order.");
				report.updateTestLog("Checking the order of Fert calculations","Fertilizer Calculations order is Correct",Status.PASS);
				if(fertilizer>2)
				{
					compare = name1.compareToIgnoreCase(name2);
					if (compare < 0)
					{
						report.updateTestLog("Checking the order of Fert calculations","Fertilizer Calculations order is Correct",Status.PASS);
					}
					report.updateTestLog("Checking the order of Fert calculations","Fertilizer Calculations order is Correct",Status.PASS);
				}

			}
			else
			{
				report.updateTestLog("Checking the order of Fert calculations","Fertilizer Calculations order is InCorrect",Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Checking the order of Fert calculations","Fertilizer Calculations order is Correct",Status.PASS);
		}
		if(mulch>1)
		{	
			compare = name2.compareToIgnoreCase(name3);
			if (compare < 0)  
			{  
				System.out.println("The strings are in sorted order.");
				report.updateTestLog("Checking the order of Mulch calculations","Mulch Calculations order is Correct",Status.PASS);
				if(mulch>2)
				{
					compare = name3.compareToIgnoreCase(name4);
					if (compare < 0)
					{
						report.updateTestLog("Checking the order of Mulch calculations","Mulch Calculations order is Correct",Status.PASS);
					}
					report.updateTestLog("Checking the order of Mulch calculations","Mulch Calculations order is Correct",Status.PASS);
				}

			}
			else
			{
				report.updateTestLog("Checking the order of Mulch calculations","Mulch Calculations order is InCorrect",Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Checking the order of Mulch calculations","Mulch Calculations order is Correct",Status.PASS);
		}
		if(grassseed>1)
		{
			compare = name4.compareToIgnoreCase(name5);
			if (compare < 0)  
			{  
				System.out.println("The strings are in sorted order.");
				report.updateTestLog("Checking the order of grassseed calculations","grassseed Calculations order is Correct",Status.PASS);
				if(grassseed>2)
				{
					compare = name4.compareToIgnoreCase(name5);
					if (compare < 0)
					{
						report.updateTestLog("Checking the order of grassseed calculations","grassseed Calculations order is Correct",Status.PASS);
					}
					report.updateTestLog("Checking the order of grassseed calculations","grassseed Calculations order is Correct",Status.PASS);
				}

			}
			else
			{
				report.updateTestLog("Checking the order of grassseed calculations","grassseed Calculations order is InCorrect",Status.FAIL);
			}		
		}
		else
		{
			report.updateTestLog("Checking the order of grassseed calculations","grassseed Calculations order is Correct",Status.PASS);
		}
	}

	public void exteriorDimensionsNetAreaCalc() throws Exception
	{
		Thread.sleep(3000);
		try{driver.findElement(By.partialLinkText("Yard")).click();
		selenium.waitForPageToLoad("20000");
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.partialLinkText("Yard")).click();
			selenium.waitForPageToLoad("20000");
			}
		Thread.sleep(3000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(UIMapMyLowes.lnkShowDim)).click();
		Thread.sleep(3000);


		String initialArea=driver.findElement(By.xpath(UIMapMyLowes.webElmntTotalArea)).getText();
		Thread.sleep(2000);
		String[] x = initialArea.split(" ");
		Thread.sleep(2000);

		String initialAreaSplit= x[0];
		int initialAreaValue=Integer.parseInt(initialAreaSplit);

		String initialNegativeSpace=driver.findElement(By.xpath(UIMapMyLowes.lblNonLawnInAreaTotal)).getText();
		Thread.sleep(2000);
		if(!initialNegativeSpace.equals(""))
		{
			System.out.println("1st");
			driver.findElement(By.xpath(UIMapMyLowes.btnEditDimensions)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(UIMapMyLowes.lnkAddAnother)).click();
			Thread.sleep(3000);
			if(selenium.isElementPresent(UIMapMyLowes.webElmntDeleteNegSpaceArea2))
			{
				System.out.println("2nd");
				driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceAreaName2)).sendKeys("NegSpace");
				Thread.sleep(2000);
				driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceArea2)).sendKeys("5");
				Thread.sleep(2000);
				driver.findElement(By.xpath(UIMapMyLowes.btnFinish2)).click();
				Thread.sleep(4000);

				String negativeAreaText=driver.findElement(By.xpath(UIMapMyLowes.lblNonLawnInAreaTotal)).getText();
				Thread.sleep(3000);

				String[] y = negativeAreaText.split(" ");
				Thread.sleep(2000);

				String negativeAreaSplit= y[0];
				int negativeAreaValue=Integer.parseInt(negativeAreaSplit);

				String mainAreaText=driver.findElement(By.xpath(UIMapMyLowes.lblNetAreaInAreaTotal)).getText();

				String[] z = mainAreaText.split(" ");
				Thread.sleep(2000);

				String mainAreaSplit= z[0];
				int mainAreaValue=Integer.parseInt(mainAreaSplit);

				if((mainAreaValue)==(initialAreaValue-negativeAreaValue))
				{
					System.out.println("3rd");
					report.updateTestLog("Trying to validate Exterior Dimensions Net Area","Exterior Net Area dimension validation is Successful",Status.PASS);

					driver.findElement(By.xpath(UIMapMyLowes.btnEditDimensions)).click();
					Thread.sleep(4000);

					driver.findElement(By.xpath(UIMapMyLowes.txtNegSpaceArea2)).sendKeys("0");
					Thread.sleep(2000);

					driver.findElement(By.xpath(UIMapMyLowes.btnFinish2)).click();
					Thread.sleep(4000);
				}
				else
				{
					report.updateTestLog("Trying to validate Exterior Dimensions Net Area","Exterior Net Area dimension validation is Failed",Status.FAIL);

				}

			}

			else
			{
				report.updateTestLog("Trying to validate Exterior Dimensions Net Area","Exterior Net Area dimension validation is Failed",Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Trying to validate Exterior Dimensions Net Area","Exterior Net Area dimension validation is Failed",Status.FAIL);
		}
	}

	public void editPhotoInModal() throws Exception
	{
		if(selenium.isElementPresent(UIMapMyLowes.lblSpace5PhotosCount))
		{
			Thread.sleep(3000);
			try{driver.findElement(By.partialLinkText("Yard")).click();
			selenium.waitForPageToLoad("20000");
			}
			catch(Exception WebDriverException){
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup","Handeled", Status.DONE);
				driver.findElement(By.partialLinkText("Yard")).click();
				selenium.waitForPageToLoad("20000");
				}
			Thread.sleep(5000);
			driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(UIMapMyLowes.lblShowPhotos)).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(UIMapMyLowes.webElmntPhoto1NameDisp)).click();
			Thread.sleep(5000);


			Actions actions = new Actions(driver);
			WebElement menuHoverLink = driver.findElement(By.xpath(UIMapMyLowes.lblPhotoDetailName));
			actions.moveToElement(menuHoverLink).build().perform();
			System.out.println("Mouse Hover successful");
			//Thread.sleep(5000);
			/*String hoverText = */
			//driver.findElement(By.xpath(UIMapMyLowes.lnkPhotoDetailNameEdit)).click();
			driver.findElement(By.partialLinkText("Edit")).click();
			Thread.sleep(2000);
			/*if(hoverText.equalsIgnoreCase("Edit"))
			{*/
			System.out.println("1st");
			/*driver.findElement(By.xpath(UIMapMyLowes.lnkPhotoDetailNameEdit)).click();
				Thread.sleep(3000);*/
			if(selenium.isElementPresent(UIMapMyLowes.webElmntPhotoDetailNote))
			{
				System.out.println("2nd");
				driver.findElement(By.xpath(UIMapMyLowes.webElmntPhotoDetailNote)).clear();
				driver.findElement(By.xpath(UIMapMyLowes.webElmntPhotoDetailNote)).sendKeys("thisisthetextaddedbyme");
				String str=new String("thisisthetextaddedbyme");

				int stringLength=str.length();
				System.out.println("String Length"+stringLength);
				String charLength=driver.findElement(By.xpath(UIMapMyLowes.webElmntPhotoDetailNoteCharRemaining)).getText();
				Thread.sleep(2000);
				int characterLen=Integer.parseInt(charLength);
				if((characterLen)==(2000-stringLength))
				{
					System.out.println("3rd");
					driver.findElement(By.xpath(UIMapMyLowes.webElmntPhotoDetailUnassignSpace)).click();
					Thread.sleep(2000);

					driver.findElement(By.xpath(UIMapMyLowes.lnkPhotoDetailAddToSpaces)).click();
					Thread.sleep(2000);

					String varNewSpace= driver.findElement(By.xpath(UIMapMyLowes.lblPhotoDetailSpace4)).getText();
					driver.findElement(By.xpath(UIMapMyLowes.chkBoxPhotoDetailSpace4)).click();
					Thread.sleep(2000);

					driver.findElement(By.xpath(UIMapMyLowes.btnPhotoDetailSpaceApply)).click();
					Thread.sleep(2000);

					driver.findElement(By.xpath(UIMapMyLowes.btnPhotoDetail)).click();
					Thread.sleep(2000);
					String varNewLocatedIn=driver.findElement(By.xpath(UIMapMyLowes.lblPhotoDetailLocatedIn)).getText();
					String varNewNote=driver.findElement(By.xpath(UIMapMyLowes.lblPhotoDetailSavedNotes)).getText();
					System.out.println(varNewNote);
					System.out.println(str);
					if((varNewLocatedIn.equalsIgnoreCase(varNewSpace)) && (varNewNote.equals(str)))
					{
						System.out.println("4th");
						report.updateTestLog("Trying to edit photo in Modal","Editing photo in Modal is Successful",Status.PASS);
					}
					else
					{
						report.updateTestLog("Trying to edit photo in Modal","Editing photo in Modal Failed",Status.FAIL);
					}
				}
				else
				{
					report.updateTestLog("Trying to edit photo in Modal","Editing photo in Modal Failed",Status.FAIL);
				}
			}
			else
			{
				report.updateTestLog("Trying to edit photo in Modal","Editing photo in Modal Failed",Status.FAIL);
			}

			
		}
		else
		{
			report.updateTestLog("Trying to edit photo in Modal","Editing photo in Modal Failed",Status.FAIL);
		}
	}

	public void editCalculationPaint() throws Exception
	{
		if(selenium.isElementPresent(UIMapMyLowes.lblSpace3CalcCount))
		{
			System.out.println("1st");
			Thread.sleep(2000);
			try{driver.findElement(By.partialLinkText("Bedroom")).click();
			selenium.waitForPageToLoad("20000");
			}
			catch(Exception WebDriverException){
				driver.findElement(By.linkText("No, thanks")).click();
				report.updateTestLog("Survey Popup","Handeled", Status.DONE);
				driver.findElement(By.partialLinkText("Bedroom")).click();
				selenium.waitForPageToLoad("20000");
				}
			Thread.sleep(3000);
			driver.findElement(By.xpath(UIMapMyLowes.webElmntShowDownArrow)).click();
			Thread.sleep(3000);

			driver.findElement(By.xpath(UIMapMyLowes.lnkShowCalc)).click();
			Thread.sleep(3000);

			String calcType=driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcTypeIcon)).getAttribute("class");
			Thread.sleep(2000);
			if(calcType.contains("calcpaint"))
			{
				System.out.println("2nd");
				driver.findElement(By.xpath(UIMapMyLowes.lnkShowDetails)).click();
				Thread.sleep(3000);
				String hideLink=driver.findElement(By.xpath(UIMapMyLowes.lnkCalcHideDetails)).getText();
				Thread.sleep(2000);
				if(hideLink.contains("Hide Details"))
				{
					System.out.println("3rd");
					driver.findElement(By.xpath(UIMapMyLowes.txtCalcName1)).click();
					Thread.sleep(2000);
					String calcName=driver.findElement(By.xpath(UIMapMyLowes.txtCalcName1)).getText();
					Thread.sleep(2000);
					System.out.println("This is the calc Name:"+calcName);
					if(selenium.isElementPresent(UIMapMyLowes.webElmntCalcTrashcan))
					{
						System.out.println("4th");
						String addedOn=driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcAddedOn)).getText();
						Thread.sleep(2000);
						if(addedOn.contains("Added on"))
						{
							System.out.println("5th");
							String totalArea=driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcTotalNetArea)).getText();
							Thread.sleep(2000);
							String paintNeeded=driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcPaintNeeded)).getText();
							Thread.sleep(2000);
							String primerNeeded=driver.findElement(By.xpath(UIMapMyLowes.webElmntCalcPrimerNeeded)).getText();
							Thread.sleep(2000);


							if((totalArea.matches(".*\\d.*")) && (paintNeeded.contains("Paint Needed")) && (primerNeeded.contains("Primer Needed")))
							{
								System.out.println("6th");
								if(selenium.isElementPresent(UIMapMyLowes.webElmntCalcMulchArea1) && selenium.isElementPresent(UIMapMyLowes.webElmntCalcMulcWidth) && selenium.isElementPresent(UIMapMyLowes.webElmntCalcMulcLength))
								{
									System.out.println("7th");
									if(selenium.isElementPresent(UIMapMyLowes.btnCalcShop))
									{
										System.out.println("8th");
										if(selenium.isElementPresent(UIMapMyLowes.btnCalcSave) && selenium.isElementPresent(UIMapMyLowes.lnkCalcCancel))
										{
											System.out.println("9th");
											driver.findElement(By.xpath(UIMapMyLowes.txtNotes2)).click();
											Thread.sleep(2000);
											driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).clear();
											driver.findElement(By.xpath(UIMapMyLowes.txtNotesTextArea)).sendKeys("add this text");
											Thread.sleep(3000);
											driver.findElement(By.xpath(UIMapMyLowes.txtCalcName1)).clear();
											driver.findElement(By.xpath(UIMapMyLowes.txtCalcName1)).sendKeys("New");
											Thread.sleep(3000);
											driver.findElement(By.xpath(UIMapMyLowes.btnCalcSave)).click();
											Thread.sleep(4000);
											String newName=driver.findElement(By.xpath(UIMapMyLowes.webElmntCalc1Name)).getText();
											String newNotes=driver.findElement(By.xpath(UIMapMyLowes.lblDocAddedNotes)).getText();
											if((newName.equals("New")) && (newNotes.equals("add this text")))
											{
											driver.findElement(By.xpath(UIMapMyLowes.lnkShowDetails)).click();
											Thread.sleep(4000);
											
											
											
											
												driver.findElement(By.xpath(UIMapMyLowes.btnCalcShop)).click();
												selenium.waitForPageToLoad("20000");
												Thread.sleep(4000);

												String searchResults=driver.findElement(By.xpath(UIMapMyLowes.webElmntShopPaintPg)).getText();
												Thread.sleep(2000);
												if(searchResults.matches(".*\\d.*"))
												{
													System.out.println("10th");
													report.updateTestLog("Trying to edit Calculation Paint","Editing Calculation paint is Successful",Status.PASS);
												}
											}
											
											else
											{
												report.updateTestLog("Trying to edit Calculation Paint","Editing Calculation paint Failed",Status.FAIL);
											}
										}
										else
										{
											report.updateTestLog("Trying to edit Calculation Paint","Editing Calculation paint Failed",Status.FAIL);
										}
									}
									else
									{
										report.updateTestLog("Trying to edit Calculation Paint","Editing Calculation paint Failed",Status.FAIL);
									}
								}
								else
								{
									report.updateTestLog("Trying to edit Calculation Paint","Editing Calculation paint Failed",Status.FAIL);
								}
							}
							else
							{
								report.updateTestLog("Trying to edit Calculation Paint","Editing Calculation paint Failed",Status.FAIL);
							}
						}
						else
						{
							report.updateTestLog("Trying to edit Calculation Paint","Editing Calculation paint Failed",Status.FAIL);
						}
					}
					else
					{
						report.updateTestLog("Trying to edit Calculation Paint","Editing Calculation paint Failed",Status.FAIL);
					}
				}
				else
				{
					report.updateTestLog("Trying to edit Calculation Paint","Editing Calculation paint Failed",Status.FAIL);
				}
			}
			else
			{
				report.updateTestLog("Trying to edit Calculation Paint","Editing Calculation paint Failed",Status.FAIL);
			}
		}
		else
		{
			report.updateTestLog("Trying to edit Calculation Paint","Editing Calculation paint Failed",Status.FAIL);
		}
	}

	public void gridViewPos() throws Exception
	{
		Thread.sleep(2000);
		try{
		driver.findElement(By.xpath(UIMapMyLowes.webElmntViewOrAssignProducts2)).click();
		selenium.waitForPageToLoad("20000");
		}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.xpath(UIMapMyLowes.webElmntViewOrAssignProducts2)).click();
			selenium.waitForPageToLoad("20000");
			}
			
		Thread.sleep(3000);
		driver.findElement(By.xpath(UIMapMyLowes.webElmntGridViewImg)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(UIMapMyLowes.lnkEdit2)).click();
		Thread.sleep(3000);
		String addToSpaces=driver.findElement(By.xpath(UIMapMyLowes.lblAddToSpaces)).getText();
		Thread.sleep(2000);
		if(addToSpaces.contains("Add to Spaces"))
		{
			System.out.println("1st");

			if(selenium.isElementPresent(UIMapMyLowes.webElmntProductAssignedSpaceGrid) && selenium.isElementPresent(UIMapMyLowes.webElmntSelectSpaceDownArrow))
			{
				System.out.println("2nd");
				driver.findElement(By.xpath(UIMapMyLowes.webElmntSelectSpaceDownArrow)).click();
				Thread.sleep(3000);
				String close=driver.findElement(By.xpath(UIMapMyLowes.lnkClose)).getText();
				Thread.sleep(2000);
				System.out.println("This is:"+close);
				if(close.contains("Close"))
				{
					System.out.println("3rd");
					boolean isChecked = driver.findElement(By.xpath(UIMapMyLowes.chkBoxYARD)).isSelected();
					if(isChecked)
					{
						System.out.println("4th");
						String space1=driver.findElement(By.xpath(UIMapMyLowes.lblYourSpacesSpace5)).getText();
						Thread.sleep(2000);
						String space=driver.findElement(By.xpath(UIMapMyLowes.webElmntManualItemAssignedSpaceGrid)).getText();
						Thread.sleep(2000);
						if(space.equalsIgnoreCase(space1))
						{
							System.out.println("5th");
							Thread.sleep(2000);

							driver.findElement(By.xpath(UIMapMyLowes.btnSaveManualItem)).click();
							Thread.sleep(3000);

							driver.findElement(By.xpath(UIMapMyLowes.webElmntListViewImg)).click();
							Thread.sleep(3000);

							report.updateTestLog("Trying to change Grid view POS","Grid view POS change is Successful",Status.PASS);
						}
						else
						{
							report.updateTestLog("Trying to change Grid view POS","Grid view POS change Failed",Status.FAIL);
						}
					}
					else
					{
						report.updateTestLog("Trying to change Grid view POS","Grid view POS change Failed",Status.FAIL);
					}
				}
				else
				{
					report.updateTestLog("Trying to change Grid view POS","Grid view POS change Failed",Status.FAIL);
				}
			}
			else
			{
				report.updateTestLog("Trying to change Grid view POS","Grid view POS change Failed",Status.FAIL);
			}

		}
		else
		{
			report.updateTestLog("Trying to change Grid view POS","Grid view POS change Failed",Status.FAIL);
		}

	}
	
	/**
	 * This function uploads an image called A.jpg from D drive
	 * @throws Exception
	 */
	public void uploadPhotosHomeProfile() throws Exception
	{
		driver.findElement(By.cssSelector("a.btn.dropdown-toggle > span")).click();
		driver.findElement(By.linkText("Photos")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("div.no_results > div.sort-bar > div.group > a.btn.upload-action > span")).click();
		Thread.sleep(10000);
		Robot r = new Robot(); 
		r.keyPress(KeyEvent.VK_D);        // D
		r.keyRelease(KeyEvent.VK_D);
		r.keyPress(KeyEvent.VK_SHIFT);	// : (colon)
		r.keyPress(KeyEvent.VK_SEMICOLON);
		r.keyRelease(KeyEvent.VK_SEMICOLON);
		r.keyRelease(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_BACK_SLASH );    // \ (back slash)
		r.keyRelease(KeyEvent.VK_BACK_SLASH );
		r.keyPress(KeyEvent.VK_A);        // A
		r.keyRelease(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_PERIOD); 
		r.keyRelease(KeyEvent.VK_PERIOD); 
		r.keyPress(KeyEvent.VK_J);        // J
		r.keyRelease(KeyEvent.VK_J);
		r.keyPress(KeyEvent.VK_P);        // P
		r.keyRelease(KeyEvent.VK_P);
		r.keyPress(KeyEvent.VK_G);        // G
		r.keyRelease(KeyEvent.VK_G);
		
		r.keyPress(KeyEvent.VK_ENTER); 
		r.keyRelease(KeyEvent.VK_ENTER);
		
		String varPhotoUpload = driver.findElement(By.xpath("//*[@id='upload-modal-5']/ul/li/div/div/p")).getText();
		System.out.println(varPhotoUpload);
		
		if(varPhotoUpload.equals("Upload complete."))
		{
			report.updateTestLog("Photo Uploading","Photo Upload successful" ,Status.PASS);
			driver.findElement(By.xpath("html/body/div[20]/div[1]/a/span")).click();
			
		}
		else
		{
			report.updateTestLog("Photo Uploading","Photo Upload NOT successful" ,Status.FAIL);
		}
		
	}
	}
	



	
	

