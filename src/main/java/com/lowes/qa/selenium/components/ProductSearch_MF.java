package com.lowes.qa.selenium.components;

import java.text.DecimalFormat;
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
import com.lowes.qa.selenium.uimap.UIMapCheckOut;
import com.lowes.qa.selenium.uimap.UIMapFunctionalComponents;
import com.lowes.qa.selenium.uimap.UIMapMyLowes;
import com.lowes.qa.selenium.uimap.UIMapProductSearch;
import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class ProductSearch_MF extends ReusableLibrary {

	String baseurl = dataTable.getData("General_Data", "URL");
	Selenium selenium = new WebDriverBackedSelenium(driver, baseurl);
	ProductSearch ps=new ProductSearch(scriptHelper);
	CheckOut co = new CheckOut(scriptHelper);

	public ProductSearch_MF(ScriptHelper scriptHelper) {
		super(scriptHelper);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void navigateToGiftCard() throws Exception {
		// click on masterhead gift card
		driver.findElement(By.xpath("//a[@name='MASTHEAD_Gift_Cards']"))
				.click();
		selenium.waitForPageToLoad("15000");
		Thread.sleep(6000);
		// click on gift card type
		driver.findElement(By.xpath("//p[2]/a/span")).click();
		selenium.waitForPageToLoad("15000");
		Thread.sleep(6000);
		// selecting a gift card
		selenium.waitForPageToLoad("30000");
		//boolean verItemPresent = driver.findElement(
		//		By.name("listpage_productname")).isDisplayed();
		/*if (verItemPresent) {
			report.updateTestLog("Veriyfing Navigating to Item's PDP Page",
					"Name - " + dataTable.getData("General_Data", "searchName")
							+ " is Present", Status.PASS);
		} else {
			report.updateTestLog("Veriyfing Navigating to Item's PDP Page",
					"Model name is NOT Present", Status.FAIL);
		}
*/
		//selenium.waitForPageToLoad("30000");
		boolean selectElement = driver.findElement(By.xpath("//h3/a"))
				.isDisplayed();
		if (selectElement) {
			driver.findElement(By.xpath("//h3/a")).click();
		} else {
			report.updateTestLog("Select of first element is failed",
					"Element NOT Present", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void verifyGiftCardItemNo() throws Exception {
		driver.findElement(By.xpath("//a[@name='MASTHEAD_Gift_Cards']"))
				.click();
		selenium.waitForPageToLoad("15000");
		Thread.sleep(6000);
		// click on gift card type
		driver.findElement(By.xpath("//p[2]/a/span")).click();
		selenium.waitForPageToLoad("15000");
		Thread.sleep(6000);
		// selecting a gift card
		selenium.waitForPageToLoad("30000");
		boolean verItemPresent = driver.findElement(
				By.name("listpage_productname")).isDisplayed();
		/*if (verItemPresent) {
			report.updateTestLog("Veriyfing Navigating to Item's PDP Page",
					"Name - " + dataTable.getData("General_Data", "searchName")
							+ " is Present", Status.PASS);
		} else {
			report.updateTestLog("Veriyfing Navigating to Item's PDP Page",
					"Model name is NOT Present", Status.FAIL);
		}*/
		selenium.waitForPageToLoad("30000");
		// item no same
		String giftItem1 = driver
				.findElement(By.xpath("//li/div/div[4]/ul/li")).getText();
		String giftItem2 = driver.findElement(
				By.xpath("//li[2]/div/div[4]/ul/li")).getText();
		if (giftItem1.equals(giftItem2)) {
			report.updateTestLog("Checking ITem ",
					"same Item displayed, Verified", Status.PASS);
		} else {
			report.updateTestLog("Checking ITem ", "same Item NOT displayed",
					Status.FAIL);
		}
		// model no not same
		String giftModel1 = driver.findElement(By.xpath("//div[4]/ul/li[2]"))
				.getText();
		String giftModel2 = driver.findElement(
				By.xpath("//li[2]/div/div[4]/ul/li[2]")).getText();
		if (giftModel1.equals(giftModel2)) {
			report.updateTestLog("Checking ITem ",
					"same MOdel displayed, Verified", Status.FAIL);
		} else {
			report.updateTestLog("Checking ITem ", "same MOdel NOT displayed",
					Status.PASS);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void giftCardAddToCart() throws Exception {
		// checking parcel shipping section
		String itemInfo = driver.findElement(By.xpath("//*[@id='original-image']")).getAttribute("src");
		String deliveryMethod = driver.findElement(
				By.xpath("//div[4]/div/div/h3")).getText();
		System.out.println(deliveryMethod);
		if (deliveryMethod.equals("Delivery Method")) {
			report.updateTestLog("Checking Delivery Method ",
					"Delivery Method displayed", Status.PASS);
		} else {
			report.updateTestLog("Checking Delivery Method ",
					"Delivery Method NOT displayed", Status.FAIL);
		}
		// checking Free Lable
		String free = driver.findElement(By.xpath("//div[4]/div/div/span"))
				.getText();
		if (free.equals("FREE")) {
			report.updateTestLog("Checking FREE ", "FREE displayed",
					Status.PASS);
		} else {
			report.updateTestLog("Checking FREE ", "FREE NOT displayed",
					Status.FAIL);
		}
		driver.findElement(By.id("gcTo_i")).sendKeys(
				dataTable.getData("General_Data", "Firstname"));
		Thread.sleep(1000);
		driver.findElement(By.id("gcFrom_i")).sendKeys(
				dataTable.getData("General_Data", "Lastname"));
		driver.findElement(By.xpath("//*[@id='gift-msg-txtarea']")).sendKeys(
				dataTable.getData("General_Data", "GCMessage"));
		
		driver.findElement(By.xpath("//*[@id='giftCardForm']/div/ul/li[10]/button")).click();
		selenium.waitForPageToLoad("15000");
		Thread.sleep(4000);
		System.out.println(itemInfo);
		String itemInfoCart = driver.findElement(By.xpath("//form/div[4]/div/div/a/img")).getAttribute("src");
		System.out.println(itemInfoCart);
		if(itemInfo.trim().equals(itemInfoCart.trim()))
			report.updateTestLog("Verifying whether Gift Card item added to cart","Gift Card successfully added to cart",Status.PASS);
		else
			report.updateTestLog("Verifying whether Gift Card item added to cart","Gift Card not added to cart",Status.FAIL);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void verifyItemAddedToCart() throws Exception {
		driver.findElement(By.id("nav-my-account")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.id("nav-cart-label")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void searchNutsThroughShopHardware() throws Exception {
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By
				.xpath("//div[@id='header-block']/div[3]/ul/li[2]/a/span"));
		Thread.sleep(6000);
		actions.moveToElement(menuHoverLink).build().perform();
		Thread.sleep(6000);
		WebElement subLink = driver.findElement(By
				.xpath("//a[contains(text(),'Hardware')]"));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.cssSelector("a[title=\"Fasteners\"]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.cssSelector("a[title=\"Nuts\"]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void searchStaplesThroughShopHardware() throws Exception {
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By
				.xpath("//div[@id='header-block']/div[3]/ul/li[2]/a/span"));
		Thread.sleep(6000);
		actions.moveToElement(menuHoverLink).build().perform();
		Thread.sleep(6000);
		WebElement subLink = driver.findElement(By
				.xpath("//a[contains(text(),'Hardware')]"));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.cssSelector("a[title=\"Fasteners\"]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.cssSelector("a[title=\"Staples\"]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// viewAllPresent
		viewAllPresent();
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void refineResultsAndRemove() throws Exception {
		driver.findElement(By.xpath("//*[@id='Brand_Arrow']")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// remove using removeLink
		driver.findElement(By.xpath("//a[contains(text(),'remove')]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// viewAllNotPresent
		viewAllNotPresent();

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void revisitingNutsThroughShopHardware() throws Exception {
		searchNutsThroughShopHardware();
		selectMinResults();
		viewAllNotPresent();
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void viewAllNotPresent() throws Exception {
		boolean viewAll = selenium.isTextPresent("View All");
		if (viewAll) {
			report.updateTestLog("Checking View All ",
					"View All NOT displayed", Status.FAIL);
		} else {
			report.updateTestLog("Checking View All ", "View All displayed",
					Status.PASS);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void viewAllPresent() throws Exception {
		String viewAll = driver
				.findElement(
						By.xpath("//div[@id='main_content_rail']/div[3]/div/form/a/span"))
				.getText();
		// div[@id='main_content_rail']/div[3]/div/form/span
		String resultNo = driver
				.findElement(
						By.xpath("//div[@id='main_content_rail']/div[3]/div/form/span"))
				.getText();
		int actualResult = Integer.valueOf(resultNo);
		int maxResult = 48;
		if ((maxResult - actualResult) >= 0 && viewAll.equals("View All")) {
			report.updateTestLog("Checking View All ", "View All displayed",
					Status.PASS);
		} else {
			report.updateTestLog("Checking View All ",
					"View All NOT displayed", Status.FAIL);
		}
		driver.findElement(
				By.xpath("//div[@id='main_content_rail']/div[3]/div/form/a/span"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void selectMaxResults() throws Exception {
		new Select(
				driver.findElement(By
						.xpath("//div[@id='main_content_rail']/div[3]/div/form/select")))
				.selectByVisibleText("48");
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		viewAllNotPresent();
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void selectMinResults() throws Exception {
		new Select(
				driver.findElement(By
						.xpath("//div[@id='main_content_rail']/div[3]/div/form/select")))
				.selectByVisibleText("16");
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		viewAllNotPresent();
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void searchRefThroughShopHardware() throws Exception {
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By
				.xpath("//div[@id='header-block']/div[3]/ul/li[2]/a/span"));
		Thread.sleep(6000);
		actions.moveToElement(menuHoverLink).build().perform();
		Thread.sleep(6000);
		WebElement subLink = driver.findElement(By
				.xpath("//a[@name='MASTHEAD_Depts_Appliances']"));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.cssSelector("a[title=\"Refrigerators\"]"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(
				By.cssSelector("a[title=\"Bottom-Freezer Refrigerators\"]"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void searchFLWashersThroughShopApp() throws Exception {
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By
				.xpath("//div[@id='header-block']/div[3]/ul/li[2]/a/span"));
		Thread.sleep(6000);
		actions.moveToElement(menuHoverLink).build().perform();
		Thread.sleep(6000);
		WebElement subLink = driver.findElement(By
				.xpath("//a[@name='MASTHEAD_Depts_Appliances']"));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.cssSelector("a[title=\"Washers & Dryers\"]"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.cssSelector("a[title=\"Washing Machines\"]"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(
				By.cssSelector("a[title=\"Washing Machines:Front-Load Washers\"]"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void searchBuyThePairDryerThroughShopApp() throws Exception {
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By
				.xpath("//div[@id='header-block']/div[3]/ul/li[2]/a/span"));
		Thread.sleep(6000);
		actions.moveToElement(menuHoverLink).build().perform();
		Thread.sleep(6000);
		WebElement subLink = driver.findElement(By
				.xpath("//a[@name='MASTHEAD_Depts_Appliances']"));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.cssSelector("a[title=\"Washers & Dryers\"]"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(
				By.cssSelector("a[title=\"Dryers:Electric Dryers\"]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.cssSelector("//input[@id='Brand_Maytag']"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void searchCarpetFromFlooring() throws Exception {
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By
				.xpath("//div[@id='header-block']/div[3]/ul/li[2]/a/span"));
		Thread.sleep(6000);
		actions.moveToElement(menuHoverLink).build().perform();
		Thread.sleep(6000);
		WebElement subLink = driver.findElement(By
				.xpath("//a[contains(text(),'Flooring')]"));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.cssSelector("a[title=\"Carpet & Carpet Tile\"]"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.cssSelector("a[title=\"Carpet\"] > span"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void searchLumberThroughShopBS() throws Exception {
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By
				.xpath("//div[@id='header-block']/div[3]/ul/li[2]/a/span"));
		Thread.sleep(6000);
		actions.moveToElement(menuHoverLink).build().perform();
		Thread.sleep(6000);
		WebElement subLink = driver.findElement(By
				.xpath("//a[contains(text(),'Building Supplies')]"));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.cssSelector("a[title=\"Lumber\"]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void submitWithOutZipCode() throws Exception {
		driver.findElement(By.xpath(UIMapFunctionalComponents.lnkStoreUnzip))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//button[@id='find_a_store_btn']"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// button[@id='find_a_store_btn']
		driver.findElement(By.xpath("(//input[@name='zipCode'])[2]")).sendKeys(
				dataTable.getData("General_Data", "Store"));
		driver.findElement(By.xpath("//button[@id='find_a_store_btn']"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void lumberTypeMiddleArea() throws Exception {
		new Select(driver.findElement(By.id("gridSelect")))
				.selectByVisibleText(dataTable.getData("General_Data",
						"Lumber Type"));
		driver.findElement(By.xpath("(//input[@type='text'])[6]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys(
				dataTable.getData("General_Data", "Qty"));
		driver.findElement(By.xpath("(//input[@type='text'])[7]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys(
				dataTable.getData("General_Data", "Qty"));
		driver.findElement(By.xpath("(//input[@type='text'])[8]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[8]")).sendKeys(
				dataTable.getData("General_Data", "Qty"));
		driver.findElement(By.xpath("//a[@id='toggleGrid']/span[2]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//a[@id='toggleGrid']/span[2]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void lumberTypeBottomArea() throws Exception {
		new Select(driver.findElement(By.id("gridSelect")))
				.selectByVisibleText(dataTable.getData("General_Data",
						"Lumber Type"));
		driver.findElement(By.xpath("//button[@id='addAllToCart']")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//input[@type='text'])[6]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys(
				dataTable.getData("General_Data", "Qty"));
		driver.findElement(By.xpath("//button[@id='clearGrid']")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//input[@type='text'])[7]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys(
				dataTable.getData("General_Data", "Qty"));
		driver.findElement(By.xpath("(//input[@type='text'])[8]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[8]")).sendKeys(
				dataTable.getData("General_Data", "Qty"));
		driver.findElement(By.xpath("//button[@id='addAllToCart']")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void searchWCThroughShopHardware() throws Exception {
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(By
				.xpath("//div[@id='header-block']/div[3]/ul/li[2]/a/span"));
		Thread.sleep(6000);
		actions.moveToElement(menuHoverLink).build().perform();
		Thread.sleep(6000);
		WebElement subLink = driver.findElement(By
				.xpath("//a[@name='MASTHEAD_Depts_Appliances']"));
		actions.moveToElement(subLink).build().perform();
		subLink.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.cssSelector("a[title=\"Water Coolers\"]"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		viewAllNotPresent();
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void selectMinValueForViewAll() throws Exception {
		searchNutsThroughShopHardware();
		selectMinResults();
	}

	/* this function selects an In stock product in product List */
	/**
	 * 
	 */

	public void selectOutOfStockProductFromList() throws Exception {
		List<WebElement> varProductList = driver.findElements(By
				.xpath("//*[@id='productResults']/li"));
		int varCount = varProductList.size();
		int i;
		for (i = 1; i <= varCount; i++) {
			String varXPath = "//*[@id='productResults']/li[" + i + "]";
			String varID = driver.findElement(By.xpath(varXPath)).getAttribute(
					"id");
			System.out.println(varID);
			try {
				// if(selenium.isElementPresent("//*[@id='"+varID+"']/div/button"))
				if (driver.findElement(
						By.xpath("//*[@id='" + varID
								+ "']/div/div[3]/div[3]/p/span")).isDisplayed()) {
					System.out.println("Add to Cart present for:" + varID);
					driver.findElement(
							By.xpath("//*[@id='" + varID + "']/div/div[2]/h3/a"))
							.click();
					selenium.waitForPageToLoad("20000");
				} else
					continue;
			} catch (Exception NoSuchElementException) {
				continue;
			}
		}
		if (i == (varCount + 1)) {
			report.updateTestLog("Selecting In Stock Item",
					"No In Stock Item in page", Status.FAIL);
		}
	}

	/* this function selects an In stock product in product List */
	/**
	 * 
	 */
	public void selectInStockProductFromList() throws Exception {
		List<WebElement> varProductList = driver.findElements(By
				.xpath("//*[@id='productResults']/li"));
		int varCount = varProductList.size();
		int i;
		for (i = 1; i <= varCount; i++) {
			String varXPath = "//*[@id='productResults']/li[" + i + "]";
			String varID = driver.findElement(By.xpath(varXPath)).getAttribute(
					"id");
			System.out.println(varID);
			try {
				// if(selenium.isElementPresent("//*[@id='"+varID+"']/div/button"))
				if (driver.findElement(
						By.xpath("//*[@id='" + varID
								+ "']/div/button")).isDisplayed()) {
					System.out.println("Add to Cart present for:" + varID);
					driver.findElement(
							By.xpath("//*[@id='" + varID + "']/div/div[2]/h3/a"))
							.click();
					selenium.waitForPageToLoad("20000");
				} else
					continue;
			} catch (Exception NoSuchElementException) {
				continue;
			}
		}
		if (i == (varCount + 1)) {
			report.updateTestLog("Selecting In Stock Item",
					"No In Stock Item in page", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void validateShippingDeliveryDetails() throws Exception {
		// Store PickUp
		String free = driver.findElement(
				By.xpath("//*[@id='delivery']/li[1]/div/p")).getText();
		if (free.equals("FREE")) {
			report.updateTestLog("Validating Availability Message",
					"Store Pickup Availability Message correct", Status.PASS);
		} else {
			report.updateTestLog("Validating Availability Message",
					"Store Pickup Availability Message INcorrect", Status.FAIL);
		}

		String varPL = driver.findElement(
				By.xpath("//*[@id='delivery']/li[1]/div/label/p[1]")).getText();
		if (varPL != null) {
			report.updateTestLog("Validating Availability Message",
					"Store Pickup Availability Message correct", Status.PASS);
		} else {
			report.updateTestLog("Validating Availability Message",
					"Store Pickup Availability Message INcorrect", Status.FAIL);
		}

		// Truck Delivery
		String varTD = driver.findElement(
				By.xpath("//*[@id='delivery']/li[2]/div/label/p")).getText();
		if (varTD != null) {
			report.updateTestLog("Validating Availability Message",
					"Store Pickup Availability Message correct", Status.PASS);
		} else {
			report.updateTestLog("Validating Availability Message",
					"Store Pickup Availability Message INcorrect", Status.FAIL);
		}

		// parcel Shipping
		String varPS = driver.findElement(
				By.xpath("//*[@id='delivery']/li[3]/div/label/p[2]")).getText();
		if (varPS != null) {
			report.updateTestLog("Validating Availability Message",
					"Store Pickup Availability Message correct", Status.PASS);
		} else {
			report.updateTestLog("Validating Availability Message",
					"Store Pickup Availability Message INcorrect", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void cancelChangeStoreLink() throws Exception {
		driver.findElement(
				By.xpath("(//a[contains(text(),'Change Store')])[2]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//a[contains(text(),'Cancel')]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void cancelFindStoreLink() throws Exception {
		driver.findElement(
				By.xpath("//a[contains(text(),'Find Store Locations.')]"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//a[contains(text(),'Cancel')]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void enterZipcodeForChangeStoreLink() throws Exception {
		driver.findElement(
				By.xpath("(//a[contains(text(),'Change Store')])[2]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//input[@type='text'])[7]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys(
				dataTable.getData("General_Data", "zipcode"));
		// select store
		driver.findElement(By.xpath("//a[contains(text(),'Select Store')]"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void enterZipcodeForFindStoreLink() throws Exception {
		driver.findElement(
				By.xpath("//a[contains(text(),'Find Store Locations.')]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//input[@type='text'])[7]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys(
				dataTable.getData("General_Data", "zipcode"));
		// select store
		driver.findElement(By.xpath("//a[contains(text(),'Select Store')]"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void storesWithUpcomingAvailability() throws Exception {
		driver.findElement(
				By.xpath("(//a[contains(text(),'Change Store')])[2]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//input[@id='showFuture']")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// select store
		driver.findElement(By.xpath("//a[contains(text(),'Select Store')]"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void availableRelatedItems() throws Exception {
		boolean relatedItems = selenium.isTextPresent("Related Items");
		if (relatedItems) {
			// select related item
			driver.findElement(By.xpath("//div[@id='relatedItem1']/p/a"))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		}

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void relatedItemsAddToCart() throws Exception {
		// click on Add to Cart
		driver.findElement(By.xpath("//li[2]/div/a/span")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

		// click on continue shopping
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// availableRelatedItems
		availableRelatedItems();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		addToCartThroughStorePickup();
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void cancelParcelShippingUnavailable() throws Exception {
		// select parcel shipping
		driver.findElement(By.xpath("//ul[@id='delivery']/li[3]/a")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//a[contains(text(),'Cancel')]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// select parcel shipping
		driver.findElement(By.xpath("//ul[@id='delivery']/li[3]/a")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// select store from unavailable
		boolean unavailable = selenium
				.isTextPresent("Your Selected Option Is Unavailable");
		if (unavailable) {
			driver.findElement(By.xpath("//*[@id='truck']/span")).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			boolean cancelUnavailable = selenium.isTextPresent("Cancel");
			if (cancelUnavailable) {
				driver.findElement(By.xpath("//a[contains(text(),'Cancel')]"))
						.click();
				selenium.waitForPageToLoad("20000");
				Thread.sleep(6000);
			}
		}
		driver.findElement(By.xpath("//ul[@id='delivery']/li[3]/a")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// select truck from unavailable
		boolean unavailable2 = selenium
				.isTextPresent("Your Selected Option Is Unavailable");
		if (unavailable2) {
			driver.findElement(By.xpath("//a[@id='pickup']/span")).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			boolean cancelUnavailable2 = selenium.isTextPresent("Cancel");
			if (cancelUnavailable2) {
				driver.findElement(By.xpath("//a[contains(text(),'Cancel')]"))
						.click();
				selenium.waitForPageToLoad("20000");
				Thread.sleep(6000);
			}
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void cancelStorePickupUnavailable() throws Exception {
		driver.findElement(By.xpath("//ul[@id='delivery']/li[1]/a")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//a[contains(text(),'Cancel')]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void cancelTruckDeliveryUnavailable() throws Exception {
		driver.findElement(By.xpath("//ul[@id='delivery']/li[2]/a")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//a[contains(text(),'Cancel')]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void cancelAddToCartUnavailable() throws Exception {
		// select Add to cart
		driver.findElement(By.xpath("//li[2]/div/a/span")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//a[contains(text(),'Cancel')]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// select Add to cart
		driver.findElement(By.xpath("//li[2]/div/a/span")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// select store from unavailable
		boolean unavailable = selenium
				.isTextPresent("Your Selected Option Is Unavailable");
		if (unavailable) {
			driver.findElement(By.xpath("//a[@id='pickup']/span")).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			driver.findElement(By.xpath("//a[contains(text(),'Cancel')]"))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		}
		driver.findElement(By.xpath("//li[2]/div/a/span")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// select truck from unavailable
		boolean unavailable2 = selenium
				.isTextPresent("Your Selected Option Is Unavailable");
		if (unavailable2) {
			driver.findElement(By.xpath("//*[@id='truck']/span")).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			driver.findElement(By.xpath("//a[contains(text(),'Cancel')]"))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void addToCartThroughParcelShipping() throws Exception {
		driver.findElement(By.id("UPS")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//li[2]/div/a/span")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void addToCartThroughStorePickup() throws Exception {
		driver.findElement(By.id("PL")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//li[2]/div/a/span")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void rftItemsAddToCart() throws Exception {
		// click add to cart button
		driver.findElement(By.xpath("//li[2]/div/a/span")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// select RTF
		String didYouKnow = driver.findElement(
				By.xpath("//*[@id='productAddToCart']/div[2]/h3")).getText();
		if (didYouKnow.equals("Did you know?")) {
			String extraItems = driver.findElement(
					By.xpath("//*[@id='productAddToCart']/div[2]/p")).getText();
			if (extraItems
					.equals("Some of our items need additional products in order to work properly. Your selected item needs one or more of these item(s)")) {
				boolean isPresent = driver
						.findElement(
								By.xpath("//*[@id='productAddToCart']/div[2]/ul/li[1]/h2/a"))
						.isDisplayed();
				if (isPresent) {
					driver.findElement(
							By.xpath("//*[@id='productAddToCart']/div[2]/ul/li[1]/h2/a"))
							.click();
					selenium.waitForPageToLoad("20000");
					Thread.sleep(6000);
					driver.findElement(By.xpath("//div[2]/div[2]/button"))
							.click();
					selenium.waitForPageToLoad("20000");
					Thread.sleep(6000);
				} else {
					report.updateTestLog(
							"Veriyfing Navigating to Item's PDP Page",
							"Item NOT Present", Status.FAIL);
				}
			} else {
				report.updateTestLog("Veriyfing Navigating to Item's PDP Page",
						"rtf disclaimer is NOT Present", Status.FAIL);
			}
		} else {
			report.updateTestLog("Veriyfing Navigating to Item's PDP Page",
					"RTF NOT Present", Status.FAIL);
		}
		// checkout
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void addToCartThroughTruck() throws Exception {
		driver.findElement(By.id("LD")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//li[2]/div/a/span")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void clickTruckDeliveryAvailable() throws Exception {
		driver.findElement(By.id("LD")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void clickPickUpStockAvailable() throws Exception {
		driver.findElement(By.id("PL")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void selectEPPForItem() throws Exception {
		boolean warranty = driver.findElement(By.id("warranty")).isDisplayed();
		if (warranty) {
			driver.findElement(By.xpath("//ul[@id='warranty']/li/div/input"))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void compareFromProductList() throws Exception {
		boolean compare1 = driver.findElement(
				By.xpath(UIMapMyLowes.lblCompare1)).isDisplayed();
		if (compare1) {
			report.updateTestLog("ProPrice Present", "ProPrice displayed",
					Status.PASS);
			// click compare1
			driver.findElement(By.xpath(UIMapMyLowes.lblCompare1)).click();
		} else {
			report.updateTestLog("ProPrice not Present",
					"ProPrice not displayed", Status.FAIL);
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// sts msg
		String stsMsg = driver.findElement(By.xpath("//*[@id='statusMsg']"))
				.getText();
		if (stsMsg.equals("You must select at least 2 items for comparison.")) {
			report.updateTestLog("ProPrice Present", "ProPrice displayed",
					Status.PASS);
		}
		// compare2
		boolean compare2 = driver.findElement(
				By.xpath(UIMapMyLowes.lblCompare2)).isDisplayed();
		if (compare2) {
			report.updateTestLog("ProPrice Present", "ProPrice displayed",
					Status.PASS);
			// click compare2
			driver.findElement(By.xpath(UIMapMyLowes.lblCompare2)).click();
		} else {
			report.updateTestLog("ProPrice not Present",
					"ProPrice not displayed", Status.FAIL);
		}
		// compare3
		boolean compare3 = driver.findElement(
				By.xpath("//li[3]/div/div/div/input")).isDisplayed();
		if (compare3) {
			report.updateTestLog("ProPrice Present", "ProPrice displayed",
					Status.PASS);
			// click compare2
			driver.findElement(By.xpath("//li[3]/div/div/div/input")).click();
		} else {
			report.updateTestLog("ProPrice not Present",
					"ProPrice not displayed", Status.FAIL);
		}
		// compare4
		boolean compare4 = driver.findElement(
				By.xpath("//li[4]/div/div/div/input")).isDisplayed();
		if (compare4) {
			report.updateTestLog("ProPrice Present", "ProPrice displayed",
					Status.PASS);
			// click compare2
			driver.findElement(By.xpath("//li[4]/div/div/div/input")).click();
		} else {
			report.updateTestLog("ProPrice not Present",
					"ProPrice not displayed", Status.FAIL);
		}
		// sts msg
		String stsMsg2 = driver.findElement(By.xpath("//*[@id='statusMsg']"))
				.getText();
		if (stsMsg2
				.equals("You have selected 4 products for comparison and reached the limit.")) {
			report.updateTestLog("ProPrice Present", "ProPrice displayed",
					Status.PASS);
		}

		// remove from comparision
		boolean remove = driver.findElement(
				By.xpath("//div[2]/div[2]/div/div/a/span")).isDisplayed();
		if (remove) {
			report.updateTestLog("ProPrice Present", "ProPrice displayed",
					Status.PASS);
			// click compare2
			driver.findElement(By.xpath("//div[2]/div[2]/div/div/a/span"))
					.click();
		} else {
			report.updateTestLog("ProPrice not Present",
					"ProPrice not displayed", Status.FAIL);
		}
		// change from lis view to grid view
		driver.findElement(By.xpath("//a[contains(text(),'Grid View')]"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// click compare both items
		driver.findElement(By.xpath(UIMapMyLowes.btnCompare)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void goToProductDetailPage() throws Exception {
		selenium.waitForPageToLoad("30000");
		boolean verItemPresent = driver.findElement(
				By.name("listpage_productname")).isDisplayed();
		if (verItemPresent) {
			report.updateTestLog("Veriyfing Navigating to Item's PDP Page",
					"Name - " + dataTable.getData("General_Data", "searchName")
							+ " is Present", Status.PASS);
		} else {
			report.updateTestLog("Veriyfing Navigating to Item's PDP Page",
					"Model name is NOT Present", Status.FAIL);
		}

		selenium.waitForPageToLoad("30000");
		boolean selectElement = driver.findElement(
				By.xpath(UIMapMyLowes.txtElementDisplayed)).isDisplayed();
		if (selectElement) {
			driver.findElement(By.xpath(UIMapMyLowes.txtElementDisplayed))
					.click();
		} else {
			report.updateTestLog("Select of first element is failed",
					"Element NOT Present", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void verifyPositiveFunctionalTest() throws Exception {
		// verify price displayed
		boolean priceDisplayed = driver.findElement(
				By.xpath("//*[@id='pricing']/span")).isDisplayed();
		if (priceDisplayed) {
			report.updateTestLog("Select of first element is passed",
					"Price of an Item Present", Status.PASS);
		} else {
			report.updateTestLog("Select of first element is failed",
					"Price of an Item NOT Present", Status.FAIL);
		}
		// verify availability
		boolean availability = selenium.isTextPresent("Qty.:");
		if (availability) {
			report.updateTestLog("Select of first element is passed",
					"availability of an Item Present", Status.PASS);
		} else {
			report.updateTestLog("Select of first element is failed",
					"availability of an Item NOT Present", Status.FAIL);
		}
		// verify footer
		boolean footerDisplayed = driver.findElement(
				By.xpath("//*[@id='footer-block']")).isDisplayed();
		if (footerDisplayed) {
			report.updateTestLog("Select of first element is passed",
					"footer of an Item Present", Status.PASS);
		} else {
			report.updateTestLog("Select of first element is failed",
					"footer of an Item NOT Present", Status.FAIL);
		}
		// verify footNote
		boolean footNoteDisplayed = driver.findElement(
				By.xpath("//div[@id='footer-block']/div[2]/div/p"))
				.isDisplayed();
		if (footNoteDisplayed) {
			report.updateTestLog("Select of first element is passed",
					"footNote of an Item Present", Status.PASS);
		} else {
			report.updateTestLog("Select of first element is failed",
					"footNote of an Item NOT Present", Status.FAIL);
		}

		// verify Print
		boolean printDisplayed = driver.findElement(
				By.xpath("//a[contains(text(),'Print')]")).isDisplayed();
		if (printDisplayed) {
			report.updateTestLog("Select of first element is passed",
					"print of an Item Present", Status.PASS);
		} else {
			report.updateTestLog("Select of first element is failed",
					"print of an Item NOT Present", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void listViewGridView() throws Exception {
		// list view
		boolean listViewDisplayed = driver.findElement(
				By.xpath("//a[contains(text(),'List View')]")).isDisplayed();
		if (listViewDisplayed) {
			report.updateTestLog("Select of first element is passed",
					"listViewDisplayed", Status.PASS);
			driver.findElement(By.xpath("//a[contains(text(),'List View')]"))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		} else {
			report.updateTestLog("Select of first element is failed",
					"listView NOT Present", Status.FAIL);
		}
		// grid view
		boolean gridViewDisplayed = driver.findElement(
				By.xpath("//a[contains(text(),'Grid View')]")).isDisplayed();
		if (gridViewDisplayed) {
			report.updateTestLog("Select of first element is passed",
					"gridViewDisplayed", Status.PASS);
			driver.findElement(By.xpath("//a[contains(text(),'Grid View')]"))
					.click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		} else {
			report.updateTestLog("Select of first element is failed",
					"gridView not Displayed", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void listPageProductPage() throws Exception {
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@id='Brand_Premier']")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// changeSort Type
		driver.findElement(By.linkText("Price (Low to High)")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.linkText("Best Sellers")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(
				By.xpath("//div[@id='main_content_rail']/div[3]/div/form/span[3]/a[2]/span"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void compare2ProductsList() throws Exception {
		boolean compare1 = driver.findElement(
				By.xpath(UIMapMyLowes.lblCompare1)).isDisplayed();
		if (compare1) {
			report.updateTestLog("ProPrice Present", "ProPrice displayed",
					Status.PASS);
			// click compare1
			driver.findElement(By.xpath(UIMapMyLowes.lblCompare1)).click();
		} else {
			report.updateTestLog("ProPrice not Present",
					"ProPrice not displayed", Status.FAIL);
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// sts msg
		String stsMsg = driver.findElement(By.xpath("//*[@id='statusMsg']"))
				.getText();
		if (stsMsg.equals("You must select at least 2 items for comparison.")) {
			report.updateTestLog("ProPrice Present", "ProPrice displayed",
					Status.PASS);
		}
		// compare2
		boolean compare2 = driver.findElement(
				By.xpath(UIMapMyLowes.lblCompare2)).isDisplayed();
		if (compare2) {
			report.updateTestLog("ProPrice Present", "ProPrice displayed",
					Status.PASS);
			// click compare2
			driver.findElement(By.xpath(UIMapMyLowes.lblCompare2)).click();
		} else {
			report.updateTestLog("ProPrice not Present",
					"ProPrice not displayed", Status.FAIL);
		}
		driver.findElement(By.xpath(UIMapMyLowes.btnCompare)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void addToCartComparedItems() throws Exception {
		driver.findElement(
				By.xpath("//div[@id='header_container']/div[2]/div/table/tbody/tr[4]/td/a/span"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void viewInStoreOnlyGetDetails() throws Exception {
		boolean inStoreOnly = selenium.isTextPresent("In-Store Only");
		if (inStoreOnly) {
			report.updateTestLog("inStoreOnly Present",
					"inStoreOnly displayed", Status.PASS);
		} else {
			report.updateTestLog("inStoreOnly not Present",
					"inStoreOnly not displayed", Status.FAIL);
		}
		boolean getDetails = selenium.isTextPresent("Get Details");
		if (getDetails) {
			report.updateTestLog("getDetails Present", "getDetails displayed",
					Status.PASS);
		} else {
			report.updateTestLog("getDetails not Present",
					"getDetails not displayed", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void getDetailsThroughInStoreOnly() throws Exception {
		driver.findElement(By.xpath("//p/a/span")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void getStoreInfoFromMasterHead() throws Exception {

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void removeAllFromSearchItem() throws Exception {
		driver.findElement(
				By.xpath("//a[contains(text(),'Built-In Gas Grills')]"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		clearAllSelectionsPresent();

	}

	public void clearAllSelectionsPresent() throws Exception {
		driver.findElement(By.xpath("//*[@id='Price_$800---$1000']")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);

		boolean clearAllSelections = selenium
				.isTextPresent("Clear All Selections");
		if (clearAllSelections) {
			report.updateTestLog("clearAllSelections Present",
					"clearAllSelections displayed", Status.PASS);
		} else {
			report.updateTestLog("clearAllSelections not Present",
					"clearAllSelections not displayed", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void removeAllFromNavItem() throws Exception {
		clearAllSelectionsPresent();
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void pagenationAppear() throws Exception {
		boolean previous = selenium.isTextPresent("Previous");
		if (previous) {
			report.updateTestLog("Pagenation Present", "Pagenation displayed",
					Status.PASS);
		} else {
			report.updateTestLog("Pagenation not Present",
					"Pagenation not displayed", Status.FAIL);
		}
		boolean next = selenium.isTextPresent("Next");
		if (next) {
			report.updateTestLog("Pagenation Present", "Pagenation displayed",
					Status.PASS);
		} else {
			report.updateTestLog("Pagenation not Present",
					"Pagenation not displayed", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void pagenationNotAppear() throws Exception {
		boolean previous = selenium.isTextPresent("Previous");
		if (!previous) {
			report.updateTestLog("Pagenation Present", "Pagenation displayed",
					Status.PASS);
		} else {
			report.updateTestLog("Pagenation not Present",
					"Pagenation not displayed", Status.FAIL);
		}
		boolean next = selenium.isTextPresent("Next");
		if (!next) {
			report.updateTestLog("Pagenation Present", "Pagenation displayed",
					Status.PASS);
		} else {
			report.updateTestLog("Pagenation not Present",
					"Pagenation not displayed", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void commercialRefThroghRef() throws Exception {
		driver.findElement(
				By.xpath("(//a[contains(text(),'Refrigerators')])[3]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(
				By.cssSelector("a[title=\"Commercial Refrigerators\"]"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		pagenationNotAppear();

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void frenchDoorRefThroghRef() throws Exception {
		driver.findElement(
				By.xpath("(//a[contains(text(),'Refrigerators')])[3]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(
				By.cssSelector("a[title=\"French Door Refrigerators\"]"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		pagenationNotAppear();
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void mouseOverPreviousAndNext() throws Exception {
		driver.findElement(
				By.xpath("//div[@id='main_content_rail']/div[3]/div/form/span[3]/a[2]/span"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(
				By.xpath("//div[@id='main_content_rail']/div[3]/div/form/span[3]/a/span"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void verifyGoToProdList() throws Exception {
		driver.findElement(By.name("pageNumber")).clear();
		driver.findElement(By.name("pageNumber")).sendKeys(
				dataTable.getData("General_Data", "GoTo Page"));
		driver.findElement(By.xpath("//a[contains(text(),'Go')]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.name("pageNumber")).clear();
		driver.findElement(By.name("pageNumber")).sendKeys(
				dataTable.getData("General_Data", "GoTo Page2"));
		driver.findElement(By.xpath("//a[contains(text(),'Go')]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.name("pageNumber")).clear();
		driver.findElement(By.name("pageNumber")).sendKeys(
				dataTable.getData("General_Data", "GoTo Page3"));
		driver.findElement(By.xpath("//a[contains(text(),'Go')]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.name("pageNumber")).clear();
		driver.findElement(By.name("pageNumber")).sendKeys(
				dataTable.getData("General_Data", "GoTo Page4"));
		driver.findElement(By.xpath("//a[contains(text(),'Go')]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.name("pageNumber")).clear();
		driver.findElement(By.name("pageNumber")).sendKeys(
				dataTable.getData("General_Data", "GoTo Page5"));
		driver.findElement(By.xpath("//a[contains(text(),'Go')]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void verifySortyByLinks() throws Exception {
		driver.findElement(
				By.xpath("//a[contains(text(),'Price (Low to High)')]"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(
				By.xpath("//a[contains(text(),'Price (High to Low)')]"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath("(//a[contains(text(),'Brand')])[3]"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//a[contains(text(),'Best Sellers')]"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//a[contains(text(),'Customer Ratings')]"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.linkText("Grid View")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.linkText("List View")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//li/div/div/div/input")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		// sts msg
		String stsMsg = driver.findElement(By.xpath("//*[@id='statusMsg']"))
				.getText();
		if (stsMsg.equals("You must select at least 2 items for comparison.")) {
			report.updateTestLog("ProPrice Present", "ProPrice displayed",
					Status.PASS);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void returnToShoppingFromAddToCart() throws Exception {
		driver.findElement(By.id("PL")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(
				By.xpath("//form[@id='ShopCartForm']/div[2]/div[2]/a/span"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//a[contains(text(),'Back to Home')]"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void unZipAndVerifyItem() throws Exception {
		try {
			driver.findElement(
					By.xpath(UIMapFunctionalComponents.lnkStoreUnzip)).click();
		} catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handeled", Status.DONE);
			driver.findElement(
					By.xpath(UIMapFunctionalComponents.lnkStoreUnzip)).click();
		}
		boolean unzip = selenium.isTextPresent("Enter ZIP code to see price.");
		if (!unzip) {
			report.updateTestLog("Unzip not Done", "Unzip not Done",
					Status.FAIL);
		}
		Thread.sleep(2000);
		driver.findElement(By.id(UIMapFunctionalComponents.txtStoreZip))
				.sendKeys(dataTable.getData("General_Data", "Store"));

		try {
			// driver.findElement(By.id("nav-button-store-search")).click();
			driver.findElement(By.id(UIMapFunctionalComponents.txtStoreZip))
					.sendKeys(Keys.ENTER);

		} catch (Exception WebDriverException) {
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup", "Handeled", Status.DONE);
			// driver.findElement(By.id("nav-button-store-search")).click();
			driver.findElement(By.id(UIMapFunctionalComponents.txtStoreZip))
					.sendKeys(Keys.ENTER);
		}
		selenium.waitForPageToLoad("15000");

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void buyThePairPresent() throws Exception {
		boolean buyPairPresent = selenium.isTextPresent("Buy the Pair");
		if (!buyPairPresent) {
			report.updateTestLog("Buy the Pair not Present",
					"Buy the Pair not displayed", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void inspectBuyThePairNotPresent() throws Exception {
		goToProductDetailPage();
		buyThePairPresent();
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void detailPageLayoutDisplay() throws Exception {
		boolean headerPresent = driver.findElement(
				By.xpath("//div[@id='header-block']/div")).isDisplayed();
		if (!headerPresent) {
			report.updateTestLog("headerPresent not Present",
					"headerPresent not displayed", Status.FAIL);
		}
		boolean brudcrumbPresent = driver.findElement(
				By.xpath("//ul[@id='breadcrumbs-list']/li[6]/a")).isDisplayed();
		if (!brudcrumbPresent) {
			report.updateTestLog("brudcrumbPresent not Present",
					"brudcrumbPresent not displayed", Status.FAIL);
		}
		boolean printPresent = driver.findElement(
				By.xpath("//a[contains(text(),'Print')]")).isDisplayed();
		if (!printPresent) {
			report.updateTestLog("printPresent not Present",
					"printPresent not displayed", Status.FAIL);
		}
		boolean prodImgPresent = driver.findElement(
				By.xpath("//img[@id='prodPrimaryImg']")).isDisplayed();
		if (!prodImgPresent) {
			report.updateTestLog("prodImgPresent not Present",
					"prodImgPresent not displayed", Status.FAIL);
		}
		boolean ratingImgPresent = driver.findElement(By.xpath("//div[2]/img"))
				.isDisplayed();
		if (!ratingImgPresent) {
			report.updateTestLog("ratingImgPresent not Present",
					"ratingImgPresent not displayed", Status.FAIL);
		}
		boolean descContPresent = driver.findElement(
				By.xpath("//div[@id='descCont']/div/h1")).isDisplayed();
		if (!descContPresent) {
			report.updateTestLog("descContPresent not Present",
					"descContPresent not displayed", Status.FAIL);
		}
		boolean itemPresent = driver.findElement(By.id("ItemNumber"))
				.isDisplayed();
		if (!itemPresent) {
			report.updateTestLog("itemPresent not Present",
					"itemPresent not displayed", Status.FAIL);
		}
		boolean modelPresent = driver.findElement(By.id("ModelNumber"))
				.isDisplayed();
		if (!modelPresent) {
			report.updateTestLog("modelPresent not Present",
					"modelPresent not displayed", Status.FAIL);
		}
		boolean footerPresent = driver.findElement(
				By.xpath("//div[@id='footer-spotlight']")).isDisplayed();
		if (!footerPresent) {
			report.updateTestLog("footerPresent not Present",
					"footerPresent not displayed", Status.FAIL);
		}
		boolean storeInfoPresent = driver.findElement(
				By.xpath("//a[@id='nav-store-info']/span")).isDisplayed();
		if (!storeInfoPresent) {
			report.updateTestLog("storeInfoPresent not Present",
					"storeInfoPresent not displayed", Status.FAIL);
		}
		boolean productDetailPresent = driver.findElement(
				By.xpath("//div[@id='product-detail-tabs']")).isDisplayed();
		if (!productDetailPresent) {
			report.updateTestLog("productDetailPresent not Present",
					"productDetailPresent not displayed", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void verifyDisplayTitleViews() throws Exception {
		boolean rating = driver
				.findElement(By.xpath("//li/div/div[2]/div/img")).isDisplayed();
		if (!rating) {
			report.updateTestLog("rating not Present", "rating not displayed",
					Status.FAIL);
		}
		boolean review = driver.findElement(By.xpath("//li/div/div[2]/div/a"))
				.isDisplayed();
		if (!review) {
			report.updateTestLog("review not Present", "review not displayed",
					Status.FAIL);
		}
		boolean quickView = driver.findElement(
				By.xpath("//a[contains(text(),'QuickView')]")).isDisplayed();
		if (!quickView) {
			report.updateTestLog("quickView not Present",
					"quickView not displayed", Status.FAIL);
		}
		boolean compare = driver
				.findElement(By.xpath("//li/div/div/div/label")).isDisplayed();
		if (!compare) {
			report.updateTestLog("compare not Present",
					"compare not displayed", Status.FAIL);
		}
		boolean qty = driver.findElement(By.xpath("//form/div/p"))
				.isDisplayed();
		if (!qty) {
			report.updateTestLog("qty not Present", "qty not displayed",
					Status.FAIL);
		}
		boolean addToCart = driver.findElement(
				By.xpath("(//button[@type='submit'])[4]")).isDisplayed();
		if (!addToCart) {
			report.updateTestLog("addToCart not Present",
					"addToCart not displayed", Status.FAIL);
		}
		driver.findElement(By.linkText("Grid View")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.linkText("List View")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//li/div/div[2]/div/a")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		boolean reviewTabPresent = driver.findElement(
				By.xpath("//*[@id='reviews_tab']")).isDisplayed();
		if (!reviewTabPresent) {
			report.updateTestLog("reviewTabPresent not Present",
					"reviewTabPresent not displayed", Status.FAIL);
		}
		String value = driver.findElement(
				By.xpath("//ul[@id='subTotal']/li[2]/div/input[3]"))
				.getAttribute("value");
		if (value.equals("1")) {
			report.updateTestLog("value Present", "value displayed",
					Status.PASS);
		} else {
			report.updateTestLog("value not Present", "value not displayed",
					Status.FAIL);
		}
		driver.findElement(By.xpath("//ul[@id='subTotal']/li[2]/div/input[3]"))
				.sendKeys(dataTable.getData("General_Data", "Qty"));
		driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void inspectZIPCodeEPP() throws Exception {
		boolean storeDetails = driver.findElement(
				By.xpath("//div[@id='confirm-store']")).isDisplayed();
		if (!storeDetails) {
			report.updateTestLog("storeDetails not Present",
					"storeDetails not displayed", Status.FAIL);
		}
		boolean priceAvailability = driver.findElement(
				By.xpath("//div[@id='priceAvailability']")).isDisplayed();
		if (!priceAvailability) {
			report.updateTestLog("priceAvailability not Present",
					"priceAvailability not displayed", Status.FAIL);
		}
		boolean warrantyDisplay = driver.findElement(
				By.xpath("//*[@id='warranty']")).isDisplayed();
		if (!warrantyDisplay) {
			report.updateTestLog("warrantyDisplay not Present",
					"warrantyDisplay not displayed", Status.FAIL);
		}
		driver.findElement(By.xpath("//*[@id='PL']")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//ul[@id='warranty']/li/div/input"))
				.click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.btnAddToCart)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void checkUnavailableGetDetailsItem() throws Exception {
		String outOfStock = driver.findElement(
				By.xpath("//div[3]/div[3]/p/span")).getText();
		if (outOfStock.equals("Out of Stock")) {
			report.updateTestLog("outOfStock not Present",
					"outOfStock not displayed", Status.FAIL);
		} else {
			report.updateTestLog("outOfStock not Present",
					"outOfStock not displayed", Status.FAIL);
		}
		String checkOtherStores = driver.findElement(By.xpath("//p/a[2]/span"))
				.getText();
		if (checkOtherStores.equals("Check Other Stores")) {
			report.updateTestLog("outOfStock Present", "outOfStock displayed",
					Status.PASS);
			driver.findElement(By.xpath("//p/a[2]/span")).click();
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
		} else {
			report.updateTestLog("outOfStock not Present",
					"outOfStock not displayed", Status.FAIL);
		}

	}

	/**
	 * 
	 * @throws Exception
	 */
	public void mismatchOfPrice() throws Exception {
		String priceProductList = driver.findElement(By.xpath("//p/strong"))
				.getText();
		goToProductDetailPage();
		String priceDetailList = driver.findElement(
				By.xpath("//*[@id='pricing']/span")).getText();
		if (priceProductList.equals(priceDetailList)) {
			report.updateTestLog("priceProductList priceDetailList same",
					"priceProductList priceDetailList same", Status.PASS);
		} else {
			report.updateTestLog("priceProductList priceDetailList not same",
					"priceProductList priceDetailList not same", Status.FAIL);
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void eppProtectionPlanTab() throws Exception {
		boolean eppPlan = driver.findElement(By.xpath("//*[@id='epp-tab']/a"))
				.isDisplayed();
		if (!eppPlan) {
			report.updateTestLog("eppPlan not displayed",
					"eppPlan not displayed", Status.FAIL);
		} else {
			driver.findElement(By.xpath("//*[@id='epp-tab']/a")).click();
			// logo displayed
			boolean eppLogo = driver.findElement(
					By.xpath("//div[@id='warranties_tab']/div/div/span"))
					.isDisplayed();
			if (!eppLogo) {
				report.updateTestLog("eppLogo not displayed",
						"eppLogo not displayed", Status.FAIL);
			}
			// checking eppHeading
			String eppHeading = driver.findElement(
					By.xpath("//div[@id='warranties_tab']/div/div[2]/h2"))
					.getText();
			if (eppHeading.equals("Lowe's Extended Protection Plans")) {
				report.updateTestLog("eppHeading displayed",
						"eppHeading displayed", Status.PASS);
			} else {
				report.updateTestLog("eppHeading not displayed",
						"eppHeading not displayed", Status.FAIL);
			}
			boolean twoYrText = driver.findElement(
					By.xpath("// div[@id='warranties_tab']/div[2]/div")).isDisplayed();
			if (!twoYrText) {
				report.updateTestLog("twoYrText not displayed",
						"twoYrText not displayed", Status.FAIL);
			}
			boolean fourYrText = driver.findElement(
					By.xpath("// div[@id='warranties_tab']/div[2]/div[4]")).isDisplayed();
			if (!fourYrText) {
				report.updateTestLog("fourYrText not displayed",
						"fourYrText not displayed", Status.FAIL);
			}
		}
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
	public void checkDelMethodsUnavailable() throws Exception
	{
		//Checking whether Store Pickup is available or not
		WebElement varInput = driver.findElement(By.xpath("//*[@id='delivery']/li[1]/input"));
		String s=varInput.findElement(By.xpath("..")).getAttribute("class");
		if(s.contains("unavailable"))
			report.updateTestLog("Verifying Availability of Store Pickup","Store Pickup is unavailable",Status.DONE);
		else
			report.updateTestLog("Verifying Availability of Store Pickup","Store Pickup is available",Status.DONE);
		//Checking whether Truck Delivery is available or not
		WebElement varInput1 = driver.findElement(By.xpath("//*[@id='delivery']/li[2]/input"));
		String s1=varInput1.findElement(By.xpath("..")).getAttribute("class");
		if(s1.contains("unavailable"))
			report.updateTestLog("Verifying Availability of Truck Delivery","Truck Delivery is unavailable",Status.DONE);
		else
			report.updateTestLog("Verifying Availability of Truck Delivery","Truck Delivery is available",Status.DONE);
		//Checking whether Store Pickup is available or not
		WebElement varInput2 = driver.findElement(By.xpath("//*[@id='delivery']/li[3]/a"));
		String s2=varInput2.findElement(By.xpath("..")).getAttribute("class");
		if(s2.contains("disabled"))
			report.updateTestLog("Verifying Availability of Parcel Shipping","Parcel Shipping is unavailable",Status.DONE);
		else
			report.updateTestLog("Verifying Availability of Parcel Shipping","Parcel Shipping is available",Status.DONE);	
	}
	public void checkDelMethodsavailable() throws Exception
	{
		//Checking whether Store Pickup is available or not
		WebElement varInput = driver.findElement(By.xpath("//*[@id='PL']"));
		String s=varInput.findElement(By.xpath("..")).getAttribute("class");
		if(!(s.contains("unavailable")))
			report.updateTestLog("Verifying Availability of Store Pickup","Store Pickup is available",Status.DONE);
		else
			report.updateTestLog("Verifying Availability of Store Pickup","Store Pickup is unavailable",Status.DONE);
		//Checking whether Truck Delivery is available or not
		WebElement varInput1 = driver.findElement(By.xpath("//*[@id='LD']"));
		String s1=varInput1.findElement(By.xpath("..")).getAttribute("class");
		if(!(s1.contains("unavailable")))
			report.updateTestLog("Verifying Availability of Truck Delivery","Truck Delivery is available",Status.DONE);
		else
			report.updateTestLog("Verifying Availability of Truck Delivery","Truck Delivery is unavailable",Status.DONE);
		//Checking whether Store Pickup is available or not
		WebElement varInput2 = driver.findElement(By.xpath("//*[@id='UPS']"));
		String s2=varInput2.findElement(By.xpath("..")).getAttribute("class");
		if(!(s2.contains("disabled")))
			report.updateTestLog("Verifying Availability of Parcel Shipping","Parcel Shipping is available",Status.DONE);
		else
			report.updateTestLog("Verifying Availability of Parcel Shipping","Parcel Shipping is unavailable",Status.DONE);
	}
	public void verifyTabsForEppItemInPD() throws Exception
	{
		String tabs[] = {"Description","Specifications","Info & Guides","Protection Plans","Reviews","Community Q&A"};
		for(int i=1;i<=6;i++)
		{
			if(i==3)
			{
			if(driver.findElement(By.xpath("//*[@id='product-detail-tabs']/ul/li["+i+"]/a")).isDisplayed())
			{
				report.updateTestLog("Verifying"+tabs[i-1]+"tab in detail page",tabs[i-1]+"tab is displayed",Status.DONE);
				driver.findElement(By.xpath("//*[@id='product-detail-tabs']/ul/li["+i+"]/a")).click();
				Thread.sleep(2000);
				if(driver.findElement(By.id("Infoandguides_tab")).isDisplayed())
					report.updateTestLog("Verifying Content in Info&Guides tab","Content is displayed in Info&Guides tab",Status.PASS);
				else
					report.updateTestLog("Verifying Content in Info&Guides tab","Content is not displayed in Info&Guides tab",Status.FAIL);
				
			}
		    else
				report.updateTestLog("Verifying"+tabs[i-1]+"tab in detail page",tabs[i-1]+"tab is not displayed",Status.DONE);
			}
			if(driver.findElement(By.xpath("//*[@id='product-detail-tabs']/ul/li["+i+"]/a")).isDisplayed())
			{
				if(i==1)
				{
				report.updateTestLog("Verifying"+tabs[i-1]+"tab in detail page",tabs[i-1]+"tab is displayed",Status.PASS);
				driver.findElement(By.xpath("//*[@id='product-detail-tabs']/ul/li["+i+"]/a")).click();
				Thread.sleep(2000);
				if(driver.findElement(By.id("description-tab")).isDisplayed())
					report.updateTestLog("Verifying Content in Description tab","Content is displayed in Description tab",Status.PASS);
				else
					report.updateTestLog("Verifying Content in Description tab","Content is not displayed in Description tab",Status.FAIL);
				}
				if(i==2)
				{
				report.updateTestLog("Verifying"+tabs[i-1]+"tab in detail page",tabs[i-1]+"tab is displayed",Status.PASS);
				driver.findElement(By.xpath("//*[@id='product-detail-tabs']/ul/li["+i+"]/a")).click();
				Thread.sleep(2000);
				if(driver.findElement(By.id("specifications-tab")).isDisplayed())
					report.updateTestLog("Verifying Content in specifications tab","Content is displayed in specifications tab",Status.PASS);
				else
					report.updateTestLog("Verifying Content in specifications tab","Content is not displayed in specifications tab",Status.FAIL);
				}
				if(i==4)
				{
				report.updateTestLog("Verifying"+tabs[i-1]+"tab in detail page",tabs[i-1]+"tab is displayed",Status.PASS);
				driver.findElement(By.xpath("//*[@id='product-detail-tabs']/ul/li["+i+"]/a")).click();
				Thread.sleep(2000);
				if(driver.findElement(By.id("warranties-tab")).isDisplayed())
					report.updateTestLog("Verifying Content in warranties tab","Content is displayed in warranties tab",Status.PASS);
				else
					report.updateTestLog("Verifying Content in warranties tab","Content is not displayed in warranties tab",Status.FAIL);
				}
				if(i==5)
				{
					report.updateTestLog("Verifying"+tabs[i-1]+"tab in detail page",tabs[i-1]+"tab is displayed",Status.PASS);
					driver.findElement(By.xpath("//*[@id='product-detail-tabs']/ul/li["+i+"]/a")).click();
					Thread.sleep(2000);
					if(driver.findElement(By.id("reviews-tab")).isDisplayed())
						report.updateTestLog("Verifying Content in reviews tab","Content is displayed in reviews tab",Status.PASS);
					else
						report.updateTestLog("Verifying Content in reviews tab","Content is not displayed in reviews tab",Status.FAIL);
					}
				if(i==6)
					{
						report.updateTestLog("Verifying"+tabs[i-1]+"tab in detail page",tabs[i-1]+"tab is displayed",Status.PASS);
						driver.findElement(By.xpath("//*[@id='product-detail-tabs']/ul/li["+i+"]/a")).click();
						Thread.sleep(2000);
						if(driver.findElement(By.id("prodAnswerTab")).isDisplayed())
							report.updateTestLog("Verifying Content in Community Q&A tab","Content is displayed in Community Q&A tab",Status.PASS);
						else
							report.updateTestLog("Verifying Content in Community Q&A tab","Content is not displayed in Community Q&A tab",Status.FAIL);
						}
				
			}
			else
				report.updateTestLog("Verifying"+tabs[i-1]+"tab in detail page",tabs[i-1]+"tab is not displayed",Status.FAIL);
		}
	}
	public void verifyTabsForNoEppItemInPD() throws Exception
	{
		String tabs[] = {"Description","Specifications","Info & Guides","Protection Plans","Reviews","Community Q&A"};
		for(int i=1;i<=6;i++)
		{
			System.out.println("Entered for loop");
			if(i==3)
			{
			if(driver.findElement(By.xpath("//*[@id='product-detail-tabs']/ul/li["+i+"]/a")).isDisplayed())
			{
			report.updateTestLog("Verifying"+tabs[i-1]+"tab in detail page",tabs[i-1]+"tab is displayed",Status.DONE);
			driver.findElement(By.xpath("//*[@id='product-detail-tabs']/ul/li["+i+"]/a")).click();
			Thread.sleep(2000);
			if(driver.findElement(By.id("Infoandguides_tab")).isDisplayed())
				report.updateTestLog("Verifying Content in Info&Guides tab","Content is displayed in Info&Guides tab",Status.PASS);
			else
				report.updateTestLog("Verifying Content in Info&Guides tab","Content is not displayed in Info&Guides tab",Status.FAIL);
			}
			else
				report.updateTestLog("Verifying"+tabs[i-1]+"tab in detail page",tabs[i-1]+"tab is not displayed",Status.DONE);
			}
			if(i==4)
			{
			if(driver.findElement(By.xpath("//*[@id='product-detail-tabs']/ul/li["+i+"]/a")).isDisplayed())
				report.updateTestLog("Verifying"+tabs[i-1]+"tab in detail page",tabs[i-1]+"tab is displayed",Status.FAIL);
			else
				report.updateTestLog("Verifying"+tabs[i-1]+"tab in detail page",tabs[i-1]+"tab is not displayed",Status.PASS);
			}
			if(driver.findElement(By.xpath("//*[@id='product-detail-tabs']/ul/li["+i+"]/a")).isDisplayed()){
				System.out.println("enterd if loop for 1,2,5,6 tabs");
				if(i==1)
				{
					System.out.println("enterd if loop for 1");
				report.updateTestLog("Verifying"+tabs[i-1]+"tab in detail page",tabs[i-1]+"tab is displayed",Status.PASS);
				driver.findElement(By.xpath("//*[@id='product-detail-tabs']/ul/li["+i+"]/a")).click();
				Thread.sleep(2000);
				if(driver.findElement(By.id("description-tab")).isDisplayed())
					report.updateTestLog("Verifying Content in Description tab","Content is displayed in Description tab",Status.PASS);
				else
					report.updateTestLog("Verifying Content in Description tab","Content is not displayed in Description tab",Status.FAIL);
				}
				if(i==2)
				{
					System.out.println("enterd if loop for 2");
				report.updateTestLog("Verifying"+tabs[i-1]+"tab in detail page",tabs[i-1]+"tab is displayed",Status.PASS);
				driver.findElement(By.xpath("//*[@id='product-detail-tabs']/ul/li["+i+"]/a")).click();
				Thread.sleep(2000);
				if(driver.findElement(By.id("specifications-tab")).isDisplayed())
					report.updateTestLog("Verifying Content in specifications tab","Content is displayed in specifications tab",Status.PASS);
				else
					report.updateTestLog("Verifying Content in specifications tab","Content is not displayed in specifications tab",Status.FAIL);
				}
				if(i==5)
				{
					System.out.println("enterd if loop for 5");
					report.updateTestLog("Verifying"+tabs[i-1]+"tab in detail page",tabs[i-1]+"tab is displayed",Status.PASS);
					driver.findElement(By.xpath("//*[@id='product-detail-tabs']/ul/li["+i+"]/a")).click();
					Thread.sleep(2000);
					if(driver.findElement(By.id("reviews_tab")).isDisplayed())
						report.updateTestLog("Verifying Content in reviews tab","Content is displayed in reviews tab",Status.PASS);
					else
						report.updateTestLog("Verifying Content in reviews tab","Content is not displayed in reviews tab",Status.FAIL);
					}
				if(i==6)
					{
					System.out.println("enterd if loop for 6");
						report.updateTestLog("Verifying"+tabs[i-1]+"tab in detail page",tabs[i-1]+"tab is displayed",Status.PASS);
						driver.findElement(By.xpath("//*[@id='product-detail-tabs']/ul/li["+i+"]/a")).click();
						Thread.sleep(2000);
						if(driver.findElement(By.id("prodAnswerTab")).isDisplayed())
							report.updateTestLog("Verifying Content in Community Q&A tab","Content is displayed in Community Q&A tab",Status.PASS);
						else
							report.updateTestLog("Verifying Content in Community Q&A tab","Content is not displayed in Community Q&A tab",Status.FAIL);
						}
			}
			else
				if(i!=3 || i!=4)
				report.updateTestLog("Verifying"+tabs[i-1]+"tab in detail page",tabs[i-1]+"tab is not displayed",Status.FAIL);
		}
	}
	
	public void checkUIofPDForZippedUser() throws Exception
	{
		if(driver.findElement(By.xpath("//*[@id='pricing']/span")).isDisplayed())
			report.updateTestLog("Verifying Pricing","Price is displayed",Status.PASS);
		else
			report.updateTestLog("Verifying Pricing","Price is not displayed",Status.FAIL);
	    if(driver.findElement(By.xpath("//*[@id='priceAvailability']")).isDisplayed())
	    	report.updateTestLog("Verifying PriceAvailabilty Module","PriceAvailabilty Module is displayed",Status.PASS);
	    else
	    	report.updateTestLog("Verifying PriceAvailabilty Module","PriceAvailabilty Module is not displayed",Status.FAIL);
	}
	public void checkUIofPDForNonZippedUser() throws Exception
	{
		try{
		if(driver.findElement(By.xpath("//*[@id='pricing']/span")).isDisplayed())
			report.updateTestLog("Verifying Pricing","Price is displayed",Status.FAIL);
		else
			report.updateTestLog("Verifying Pricing","Price is not displayed",Status.PASS);
		}
		catch(Exception e)
		{
			report.updateTestLog("Verifying Pricing","Price is not displayed",Status.PASS);
		}
	    if(driver.findElement(By.xpath("//*[@id='priceAvailability']")).isDisplayed())
	    {
	    	if(driver.findElement(By.xpath("//*[@id='priceAvailability']")).getText().contains("ZIP code"))
	    	report.updateTestLog("Verifying PriceAvailabilty Module","PriceAvailabilty Module is not displayed",Status.PASS);
	        else
	    	report.updateTestLog("Verifying PriceAvailabilty Module","PriceAvailabilty Module is displayed",Status.FAIL);
	    }
	    }
	public void checkAddedItemPriceInPopupWindow() throws Exception
	{
		String DetailPagePrice = driver.findElement(By.xpath(UIMapCheckOut.lblDetailPrice)).getText();
		ClickCustomize("xpath",UIMapCheckOut.btnAddtoCart1);
		selenium.waitForPageToLoad("15000");
		Thread.sleep(6000);
		String NotificationPrice = driver.findElement(By.xpath(UIMapCheckOut.lblPriceInNotification)).getText();
		if(DetailPagePrice.trim().equals(NotificationPrice.trim()))
			report.updateTestLog("Veriying Price in Notification Window is same as in Detail Page","Price in Notification Window is same as in Detail Page",Status.PASS);
		else
			report.updateTestLog("Veriying Price in Notification Window is same as in Detail Page","Price in Notification Window is not same as in Detail Page",Status.FAIL);
	}
	public void verifyBuyThePairSection() throws Exception
	{
		if(driver.findElement(By.xpath(UIMapProductSearch.buyThePair)).isDisplayed())
		{
			report.updateTestLog("Verify Buy the Pair Section","Buy The Pair Section is displayed",Status.PASS);
		    if(driver.findElement(By.xpath(UIMapProductSearch.lblBuyThePair)).getText().equals("Buy the Pair"))
		    	report.updateTestLog("Verify Buy the Pair label","Buy The Pair label is correctly displayed",Status.PASS);
		    else
		    	report.updateTestLog("Verify Buy the Pair label","Buy The Pair label is incorrectly displayed",Status.FAIL);
		String ProdDesc = driver.findElement(By.xpath(UIMapProductSearch.imgBuyThePairItem)).getAttribute("alt");
		driver.findElement(By.xpath(UIMapProductSearch.imgBuyThePairItem)).click();
		selenium.waitForPageToLoad("15000");
		Thread.sleep(6000);
		if(selenium.isTextPresent(ProdDesc))
			report.updateTestLog("Verifying Buy The Pair item image navigation","Buy The Pair item image navigation is redirecting to corresponding page",Status.PASS);
		else
			report.updateTestLog("Verifying Buy The Pair item image navigation","Buy The Pair item image navigation is not redirecting to corresponding page",Status.FAIL);
		//Navigate back to previous page
		driver.navigate().back();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		ClickCustomize("xpath",UIMapProductSearch.titleBuyThePairItem);
		selenium.waitForPageToLoad("15000");
		Thread.sleep(6000);
		if(selenium.isTextPresent(ProdDesc))
			report.updateTestLog("Verifying Buy The Pair item Title navigation","Buy The Pair item Title navigation is redirecting to corresponding page",Status.PASS);
		else
			report.updateTestLog("Verifying Buy The Pair item Title navigation","Buy The Pair item Title navigation is not redirecting to corresponding page",Status.FAIL);
		//Navigate back to previous page
		driver.navigate().back();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		}
		else
			report.updateTestLog("Verify Buy the Pair Section","Buy The Pair Section is not displayed",Status.FAIL);
	}
	public void verifyRelatedItemSection() throws Exception
	{
		if(driver.findElement(By.xpath(UIMapProductSearch.frameRelatedItems)).isDisplayed())
		{
			report.updateTestLog("Verify RelatedItem Section","RelatedItem Section is displayed",Status.PASS);
		    if(driver.findElement(By.xpath(UIMapProductSearch.lblRelatedItems)).getText().equals("Related Items"))
		    	report.updateTestLog("Verify RelatedItem label","RelatedItem label is correctly displayed",Status.PASS);
		    else
		    	report.updateTestLog("Verify RelatedItem label","RelatedItem label is incorrectly displayed",Status.FAIL);
		String ProdDesc = driver.findElement(By.xpath(UIMapProductSearch.imgRelatedItem)).getAttribute("alt");
		driver.findElement(By.xpath(UIMapProductSearch.imgRelatedItem)).click();
		selenium.waitForPageToLoad("15000");
		Thread.sleep(6000);
		if(selenium.isTextPresent(ProdDesc))
			report.updateTestLog("Verifying RelatedItem image navigation","RelatedItem image navigation is redirecting to corresponding page",Status.PASS);
		else
			report.updateTestLog("Verifying RelatedItem image navigation","RelatedItem image navigation is not redirecting to corresponding page",Status.FAIL);
		//Navigate back to previous page
		driver.navigate().back();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		ClickCustomize("xpath",UIMapProductSearch.titleRelatedItem);
		selenium.waitForPageToLoad("15000");
		Thread.sleep(6000);
		if(selenium.isTextPresent(ProdDesc))
			report.updateTestLog("Verifying RelatedItem Title navigation","RelatedItem Title navigation is redirecting to corresponding page",Status.PASS);
		else
			report.updateTestLog("Verifying RelatedItem Title navigation","RelatedItem Title navigation is not redirecting to corresponding page",Status.FAIL);
		//Navigate back to previous page
		driver.navigate().back();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		}
		else
			report.updateTestLog("Verify RelatedItem Section","RelatedItem Section is not displayed",Status.FAIL);
	}

	public void updateQtyInPD() throws Exception
	{
		driver.findElement(By.xpath(UIMapProductSearch.txtQtyInPD)).clear();
		driver.findElement(By.xpath(UIMapProductSearch.txtQtyInPD)).sendKeys(dataTable.getData("General_Data", "Qty"));
		driver.findElement(By.xpath(UIMapProductSearch.txtQtyInPD)).sendKeys(Keys.ENTER);
		WebElement varAddToCart = driver.findElement(By.xpath(UIMapProductSearch.btnAddToCart));
		WebElement varItemID = varAddToCart.findElement(By.xpath(".."));
		String varID = varItemID.getAttribute("id");
		String[] s=varID.split("_");
		System.out.println(s[1]);
		dataTable.putData("General_Data", "ItemId", s[1]);
		//driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    try
	    {
	    	driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
	    	report.updateTestLog("verifying Notification Window after clicking on Enter button in PD","Notification window is displayed",Status.PASS);
	    }
	    catch(Exception e)
	    {
	    	report.updateTestLog("verifying Notification Window after clicking on Enter button in PD","Notification window is not displayed",Status.FAIL);
	    }
	    
	}
	public void searchWord() throws Exception
	{
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","SearchWord"));
		try{driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);}
		selenium.waitForPageToLoad("120000");
		Thread.sleep(4000);
		
		String breadcrumbText = driver.findElement(By.id("breadcrumbs")).getText();
		String ExpectedText = "Home"+'\n'+"Search \""+dataTable.getData("General_Data","SearchWord")+"\"";
		System.out.println(breadcrumbText);
		System.out.println(ExpectedText);
		if(breadcrumbText.trim().equalsIgnoreCase(ExpectedText))
			report.updateTestLog("Verifying Breadcrumb", "Breadcrumb is correctly displayed",Status.PASS);
		else
			report.updateTestLog("Verifying Breadcrumb", "Breadcrumb is incorrectly displayed",Status.FAIL);
		String searchMsg = driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1")).getText();
		String ExpectedMsg = "Search results for "+dataTable.getData("General_Data","SearchWord")+":";
		System.out.println(searchMsg);
		System.out.println(ExpectedMsg);
		if(searchMsg.trim().equalsIgnoreCase(ExpectedMsg))
			report.updateTestLog("Verifying Search Results label","Search Results label correctly displayed",Status.PASS);
		else
			report.updateTestLog("Verifying Search Results label","Search Results label incorrectly displayed",Status.FAIL);	
	}
	public void searchMisSpelledWord() throws Exception
	{
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","SearchMisSpelWord"));
		try{driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);}
		selenium.waitForPageToLoad("120000");
		Thread.sleep(4000);
		
		String breadcrumbText = driver.findElement(By.id("breadcrumbs")).getText();
		String ExpectedText = "Home"+'\n'+"Search \""+dataTable.getData("General_Data","SearchMisSpelWord")+"\":";
		System.out.println(breadcrumbText);
		System.out.println(ExpectedText);
		if(breadcrumbText.trim().equalsIgnoreCase(ExpectedText))
			report.updateTestLog("Verifying Breadcrumb", "Breadcrumb is correctly displayed",Status.PASS);
		else
			report.updateTestLog("Verifying Breadcrumb", "Breadcrumb is incorrectly displayed",Status.FAIL);
		String searchMsg = driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1")).getText();
		//String ExpectedMsg = "We found results for "+dataTable.getData("General_Data","SearchWord")+":";
		if(searchMsg.trim().contains("We found results for "))
			report.updateTestLog("Verifying Search Results label","Search Results label correctly displayed",Status.PASS);
		else
			report.updateTestLog("Verifying Search Results label","Search Results label incorrectly displayed",Status.FAIL);	
	}
	
	public void searchWordWithSpecialChars() throws Exception
	{
		driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(dataTable.getData("General_Data","SearchWord"));
		try{driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);}
		catch(Exception WebDriverException){
			driver.findElement(By.linkText("No, thanks")).click();
			report.updateTestLog("Survey Popup","Handeled", Status.DONE);
			driver.findElement(By.id(UIMapFunctionalComponents.txtSearchBar)).sendKeys(Keys.ENTER);}
		selenium.waitForPageToLoad("120000");
		Thread.sleep(4000);
		String searchMsg = driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1")).getText();
		String ExpectedMsg = "Search results for "+dataTable.getData("General_Data","SearchWord")+":";
		System.out.println(searchMsg);
		System.out.println(ExpectedMsg);
		if(searchMsg.trim().equalsIgnoreCase(ExpectedMsg))
			report.updateTestLog("Verifying Product list page","Product list page displayed",Status.PASS);
		else
			report.updateTestLog("Verifying Product list page","Product list page not displayed",Status.FAIL);	
	}
	
	public void navigateToAppliancesCategory() throws Exception
	{
		Actions actions = new Actions(driver);
		WebElement w = driver.findElement(By.xpath(UIMapProductSearch.lnkShop));
		actions.moveToElement(w).build().perform();
		System.out.println("Mouse hover successful");
		ClickCustomize("linkText",dataTable.getData("General_Data","Dept"));
		selenium.waitForPageToLoad("120000");
		Thread.sleep(4000);
		String showedBreadcrumb = driver.findElement(By.id("breadcrumbs")).getText();
		String ExpBreadcrumb = "Home"+'\n'+"Appliances"+'\n'+dataTable.getData("General_Data","Dept");
		System.out.println("showedBreadcrumb"+showedBreadcrumb);
		System.out.println("ExpBreadcrumb"+ExpBreadcrumb);
		if(showedBreadcrumb.equalsIgnoreCase(ExpBreadcrumb))
			report.updateTestLog("Verifying Breadcrumb","Breadcrumb is correctly dissplayed",Status.PASS);
		else
			report.updateTestLog("Verifying Breadcrumb","Breadcrumb is incorrectly dissplayed",Status.FAIL);
		}
	public void navigateToAppliancesFromCatPage() throws Exception
	{
		ClickCustomize("linkText","Appliances");
		selenium.waitForPageToLoad("120000");
		Thread.sleep(4000);
		if(driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1/span")).getText().equals("Appliances"))
			report.updateTestLog("Verifying Appliances page after clicking on Appliances link from "+dataTable.getData("General_Data","Dept")+"Page","Appliances page loaded successfully",Status.PASS);
		else
			report.updateTestLog("Verifying Appliances page after clicking on Appliances link from "+dataTable.getData("General_Data","Dept")+"Page","Appliances page not loaded successfully",Status.FAIL);
	
	}
	public void navigateToPDbyImgFromListPage() throws Exception
	{
		ClickCustomize("xpath","//li/div/div/a/img");
		selenium.waitForPageToLoad("120000");
		Thread.sleep(4000);
		if(driver.findElement(By.xpath("//*[@id='prodPrimaryImg']")).isDisplayed())
			report.updateTestLog("Verifying Detail Page","Detail Page is displayed",Status.PASS);
		else
			report.updateTestLog("Verifying Detail Page","Detail Page is not displayed",Status.FAIL);
		String ProdDesc = driver.findElement(By.xpath("//*[@id='descCont']/div[1]/h1")).getText();
		String showedBreadcrumb = driver.findElement(By.id("breadcrumbs")).getText();
		String ExpBreadcrumb = "Home"+'\n'+"Search \""+dataTable.getData("General_Data","SearchWord")+"\""+".*"+ProdDesc;
		System.out.println(showedBreadcrumb);
		System.out.println(ExpBreadcrumb);
		Pattern r = Pattern.compile(ExpBreadcrumb);
		Matcher m = r.matcher(showedBreadcrumb);
		if(m.find())
		{
			report.updateTestLog("Validating Breadcrumb format","Breadcrumb format correct", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating Breadcrumb format","Breadcrumb format INcorrect", Status.FAIL);
		}
		if(selenium.isElementPresent("Home"))
			report.updateTestLog("Veriying whether Home is displayed as link","Home is displayed as link",Status.PASS);
		else
			report.updateTestLog("Veriying whether Home is displayed as link","Home is not displayed as link",Status.FAIL);
		if(selenium.isElementPresent("Search \""+dataTable.getData("General_Data","SearchWord")+"\""))
			report.updateTestLog("Veriying whether Home is displayed as link","Home is displayed as link",Status.PASS);
		else
			report.updateTestLog("Veriying whether Home is displayed as link","Home is not displayed as link",Status.FAIL);
		if(selenium.isTextPresent(ProdDesc))
			report.updateTestLog("Veriying whether Product name is displayed as label","Product name is displayed as label",Status.PASS);
		else
			report.updateTestLog("Veriying whether Product name is displayed as label","Product name is displayed as label",Status.FAIL);
		searchWord();
		driver.navigate().back();
		selenium.waitForPageToLoad("120000");
		Thread.sleep(4000);
		if(driver.findElement(By.xpath("//*[@id='prodPrimaryImg']")).isDisplayed())
			report.updateTestLog("Verifying Detail Page","Detail Page is displayed",Status.PASS);
		else
			report.updateTestLog("Verifying Detail Page","Detail Page is not displayed",Status.FAIL);
		
	}
	
	public void navigateToCategory() throws Exception
	{
		Actions actions = new Actions(driver);
		WebElement w = driver.findElement(By.xpath(UIMapProductSearch.lnkShop));
		actions.moveToElement(w).build().perform();
		System.out.println("Mouse hover successful");
		ClickCustomize("linkText",dataTable.getData("General_Data","Dept"));
		selenium.waitForPageToLoad("120000");
		Thread.sleep(4000);
		ClickCustomize("xpath","//*[@id='left_rail']/div[1]/ul[1]/li[2]/a");
		selenium.waitForPageToLoad("120000");
		Thread.sleep(4000);
	}
	public void selectRefinements() throws Exception
	{
		String s = driver.findElement(By.id("Price")).getAttribute("class");
		String s1 = driver.findElement(By.id("Brand")).getAttribute("class");
		String TotalResults = driver.findElement(By.xpath(UIMapProductSearch.webElmntTotalResults)).getText();
	    	if(s.equals("open") && s1.equals("open"))
	    	{
	    		report.updateTestLog("Verifying Price and Brand facets","Price and Brand facets are expanded",Status.PASS);
	    	    String numberOfResults = driver.findElement(By.xpath("//li[3]/ul/li[1]/input")).getAttribute("value");
	    	    int nor = Integer.parseInt(numberOfResults);
	    		ClickCustomize("xpath","//li[3]/ul/li[1]/input");
	    		//selenium.waitForPageToLoad("120000");
	    		Thread.sleep(12000);
	    		String RefinedResults = driver.findElement(By.xpath(UIMapProductSearch.webElmntTotalResults)).getText();
	    		if(RefinedResults.trim().equals(numberOfResults.trim()))
	    			report.updateTestLog("Verifying number of results after selecting a refinement","No. of results are correctly loaded",Status.PASS);
	    		else
	    			report.updateTestLog("Verifying number of results after selecting a refinement","No. of results are not correctly loaded",Status.FAIL);
	    		String numberOfResults1 = driver.findElement(By.xpath("//li[3]/ul/li[2]/input")).getAttribute("value");
	    		int nor1 = Integer.parseInt(numberOfResults1);
	    		ClickCustomize("xpath","//li[3]/ul/li[2]/input");
	    		//selenium.waitForPageToLoad("120000");
	    		Thread.sleep(12000);
	    		String RefinedResults1 = driver.findElement(By.xpath(UIMapProductSearch.webElmntTotalResults)).getText();
	    		int rr1 = Integer.parseInt(RefinedResults1);
	    		System.out.println("rr1"+rr1);
	    		System.out.println("nor"+nor);
	    		System.out.println("nor1"+nor1);
	    		if(rr1 == (nor+nor1))
	    			report.updateTestLog("Verifying number of results after selecting one more refinement","No. of results are correctly loaded",Status.PASS);
	    		else
	    			report.updateTestLog("Verifying number of results after selecting one more refinement","No. of results are not correctly loaded",Status.FAIL);
	    
	    	}
	    	else
	    		report.updateTestLog("Verifying Price and Brand facets","Price and Brand facets are not expanded",Status.FAIL);
	}
	
	public void checkAddedGCinMiniCart() throws Exception
	{
		String CartGCimg = driver.findElement(By.xpath("//form/div[4]/div/div/a/img")).getAttribute("src");
		String CartGCQty = driver.findElement(By.xpath("//div[3]/input")).getAttribute("value");
		String CartGCPrice = driver.findElement(By.xpath("//div[4]/div/input")).getAttribute("value");
		ClickCustomize("xpath","//form/div[4]/div/div/a/img");
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		Actions actions = new Actions(driver);
		WebElement varHoverMiniCart= driver.findElement(By.xpath(UIMapCheckOut.webElmntMiniCart));
		actions.moveToElement(varHoverMiniCart).build().perform();
		System.out.println("Mouse Hover successful");
		Thread.sleep(5000);
		Thread.sleep(15000);
		boolean var1;
		String imgPath = "//img[contains(@src,'"+CartGCimg+"')]";
		var1 = driver.findElement(By.xpath(imgPath)).isDisplayed();
		if(var1)
			report.updateTestLog("Verifying Gift card image in Mini cart","GC image is displayed",Status.PASS);
		else
			report.updateTestLog("Verifying Gift card image in Mini cart","GC image is not displayed",Status.FAIL);
		String miniCartPrice = driver.findElement(By.xpath("//div[3]/p[1]")).getText();
		String CartGCPrice1 = "$"+CartGCPrice+".00";
		System.out.println("MiniCart Price"+miniCartPrice);
		System.out.println("Cart Price"+CartGCPrice1);
		if(miniCartPrice.equals(CartGCPrice1))
			report.updateTestLog("Verifying Price of added GC in Mini cart","Price is correctly displayed",Status.PASS);
		else
			report.updateTestLog("Verifying Price of added GC in Mini cart","Price is incorrectly displayed",Status.FAIL);
		String miniCartQty = driver.findElement(By.xpath("//div[3]/p[2]")).getText();	
		String miniCartQty1 = miniCartQty.replace("Qty.:","");
		System.out.println("MiniCart Qty"+miniCartQty1);
		System.out.println("Cart Qty"+CartGCQty);
		if(miniCartQty1.trim().equals(CartGCQty))
			report.updateTestLog("Verifying Gift card quantity in Mini cart","GC qty is correctly displayed",Status.PASS);
		else
			report.updateTestLog("Verifying Gift card quantity in Mini cart","GC qty is incorrectly displayed",Status.FAIL);
	}

	public void goToProdListPageNo() throws Exception {
		driver.findElement(By.name("pageNumber")).clear();
		String LastPageNo = driver.findElement(By.xpath("//div/span[3]")).getText();
		int LastPage = Integer.parseInt(LastPageNo);
		int GotoPage = Integer.parseInt(dataTable.getData("General_Data", "GoTo Page"));
		if(GotoPage < LastPage)
		{
			driver.findElement(By.name("pageNumber")).sendKeys(
				dataTable.getData("General_Data", "GoTo Page"));
		driver.findElement(By.xpath("//a[contains(text(),'Go')]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		String updatedPageNo = driver.findElement(By.xpath("//span[3]/div/span[1]")).getText();
		System.out.println("updatedPageNo"+updatedPageNo);
		int updatedPage = Integer.parseInt(updatedPageNo.trim());
		System.out.println("updatedPage"+updatedPage);
		if(updatedPage == GotoPage)
		{
			report.updateTestLog("verifying page refresh after entering page number in GoTo field","Page refreshed properly",Status.PASS);
			ClickCustomize("xpath","//h3/a");
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			if(driver.findElement(By.xpath(UIMapProductSearch.myStoreModule)).isDisplayed())
			{
				report.updateTestLog("Verifying PD page after clicking product in list page","PD page loaded successfully",Status.PASS);
				driver.navigate().back();
				selenium.waitForPageToLoad("20000");
				Thread.sleep(10000);
				if(updatedPage == GotoPage)
					report.updateTestLog("verifying page refresh after clicking on back button","Page refreshed properly after clicking on back button in browser",Status.PASS);
				else
					report.updateTestLog("verifying page refresh after clicking on back button","Page NOT refreshed properly after clicking on back button in browser",Status.FAIL);				
			}
			else
				report.updateTestLog("Verifying PD page after clicking product in list page","PD page not loaded successfully",Status.FAIL);
			
		}
		else
			report.updateTestLog("verifying page refresh after entering page number in GoTo field","Page is not refreshed properly",Status.FAIL);
		}
		else
		{
			report.updateTestLog("Verifying Goto Page number entered in data sheet","Goto Page number entered is greater than last page number",Status.FAIL);
		}
	}
	
	public void verifyAndClearFilterBox() throws Exception
	{
		String TotalResults = driver.findElement(By.xpath(UIMapProductSearch.lblnumberOfResults)).getText();
		selectRefinements();
		if(driver.findElement(By.xpath(UIMapProductSearch.filterBox)).isDisplayed())
		{
			ClickCustomize("xpath",UIMapProductSearch.lnkClearAll);
			selenium.waitForPageToLoad("30000");
			Thread.sleep(6000);
			String TotalResultsAfterClear = driver.findElement(By.xpath(UIMapProductSearch.lblnumberOfResults)).getText();
			if(TotalResultsAfterClear.equals(TotalResults))
				report.updateTestLog("Verifying page after clicking on Clear All Selections","Page got loaded successfully after clicking on Clear All Selections",Status.PASS);
			else
				report.updateTestLog("Verifying page after clicking on Clear All Selections","Page Not loaded successfully after clicking on Clear All Selections",Status.FAIL);
		}
		else
			report.updateTestLog("Verifying filter box after selection of refinements","Filter box is not displayed",Status.FAIL);
	}
	public void ratingsFilter() throws Exception
	{
		String InitialResCount = driver.findElement(By.xpath(UIMapProductSearch.lblnumberOfResults)).getText();
		if(driver.findElement(By.id("Rating")).isDisplayed())
		{
			report.updateTestLog("Verifying Ratings facet in left navigation","Ratings facet is displayed in left navigation",Status.PASS);
			if(driver.findElement(By.id("Rating")).getAttribute("class").equals("open"))
			{
				report.updateTestLog("verifying whether Ratings section is expanded by default","Ratings section is expanded by default",Status.PASS);
				
				for(int i=1;i<=5;i++)
				{
				String dataCnt = driver.findElement(By.xpath("//*[@id='Rating']/ul/li/div/a["+i+"]")).getAttribute("data-count");
				int dataCount = Integer.parseInt(dataCnt);
				if(dataCount>0)
				{
					ClickCustomize("xpath","//*[@id='Rating']/ul/li/div/a["+i+"]");
					selenium.waitForPageToLoad("30000");
					Thread.sleep(6000);
					String ResCount = driver.findElement(By.xpath(UIMapProductSearch.lblnumberOfResults)).getText();
					int ResultsCount = Integer.parseInt(ResCount);
					if(ResultsCount == dataCount)
					{
						report.updateTestLog("Veriying refinement behaviour for"+i+"Stars",i+"Stars refinement correctly applied",Status.PASS);
						if(driver.findElement(By.xpath(UIMapProductSearch.filterBox)).isDisplayed())
						{
							ClickCustomize("xpath",UIMapProductSearch.lnkClearAll);
							selenium.waitForPageToLoad("30000");
							Thread.sleep(6000);
							String ResCountAfterClear = driver.findElement(By.xpath(UIMapProductSearch.lblnumberOfResults)).getText();
							if(ResCountAfterClear.equals(InitialResCount))
								report.updateTestLog("Verifying page after clicking on Clear All Selections","Page got loaded successfully after clicking on Clear All Selections",Status.PASS);
							else
								report.updateTestLog("Verifying page after clicking on Clear All Selections","Page Not loaded successfully after clicking on Clear All Selections",Status.FAIL);
						}
						else
							report.updateTestLog("Verifying filter box after selection of refinements","Filter box is not displayed",Status.FAIL);
						
					}
					else
						report.updateTestLog("Veriying refinement behaviour for"+i+"Stars",i+"Stars refinement not correctly applied",Status.FAIL);
					
				}
				else
					report.updateTestLog("Verifying count for the"+i+"Stars refinement","count for the"+i+"Stars refinement is Zero",Status.DONE);
				}
				
				
			}
			else
				report.updateTestLog("verifying whether Ratings section is expanded by default","Ratings section is not expanded by default",Status.FAIL);
		}
		else
		report.updateTestLog("Verifying Ratings facet in left navigation","Ratings facet is not displayed in left navigation",Status.FAIL);
	}
	
  public void expandAndCollapseRatings() throws Exception
  {
	  if(driver.findElement(By.id("Rating")).getAttribute("class").equals("open"))
		{
		  ClickCustomize("linkText","Rating");
		  selenium.waitForPageToLoad("30000");
		  Thread.sleep(6000);
		  if(!(driver.findElement(By.id("Rating")).getAttribute("class").equals("open")))
		  {
			  report.updateTestLog("Collapsing Ratings facet","Ratings facet collapsed",Status.PASS);
			  ClickCustomize("linkText","Rating");
			  selenium.waitForPageToLoad("30000");
			  Thread.sleep(6000);
			  if(driver.findElement(By.id("Rating")).getAttribute("class").equals("open"))
				  report.updateTestLog("Expanding Ratings facet","Ratings facet Expanded",Status.PASS); 
			  else
				  report.updateTestLog("Expanding Ratings facet","Ratings facet not Expanded",Status.FAIL);
		  }
		  else
			  report.updateTestLog("Collapsing Ratings facet","Ratings facet not collapsed",Status.FAIL);  
		}
	  else
	  {
		  ClickCustomize("id","Rating");
		  selenium.waitForPageToLoad("30000");
		  Thread.sleep(6000);
		  if(driver.findElement(By.id("Rating")).getAttribute("class").equals("open"))
		  {
			  report.updateTestLog("Expanding Ratings facet","Ratings facet Expanded",Status.PASS); 
			  ClickCustomize("id","Rating");
			  selenium.waitForPageToLoad("30000");
			  Thread.sleep(6000);
			  if(!(driver.findElement(By.id("Rating")).getAttribute("class").equals("open")))
				  report.updateTestLog("Collapsing Ratings facet","Ratings facet collapsed",Status.PASS);
			  else
				  report.updateTestLog("Collapsing Ratings facet","Ratings facet not collapsed",Status.FAIL);  
		  }
		  else
			  report.updateTestLog("Expanding Ratings facet","Ratings facet not Expanded",Status.FAIL); 
	  }

  }
  public void checkBrowserBackFunctionality() throws Exception {
			ClickCustomize("xpath","//h3/a");
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			if(driver.findElement(By.xpath(UIMapProductSearch.myStoreModule)).isDisplayed())
			{
				report.updateTestLog("Verifying PD page after clicking product in list page","PD page loaded successfully",Status.PASS);
				driver.navigate().back();
				selenium.waitForPageToLoad("20000");
				Thread.sleep(6000);
				WebElement varInput1 = driver.findElement(By.xpath("//li[3]/ul/li[1]/input"));
				String s1=varInput1.findElement(By.xpath("..")).getAttribute("class");
				WebElement varInput2 = driver.findElement(By.xpath("//li[3]/ul/li[1]/input"));
				String s2=varInput2.findElement(By.xpath("..")).getAttribute("class");
				if(s1.equals("checked") && s2.equals("checked"))
					report.updateTestLog("verifying page refresh after clicking on back button","Page refreshed properly after clicking on back button in browser",Status.PASS);
				else
					report.updateTestLog("verifying page refresh after clicking on back button","Page NOT refreshed properly after clicking on back button in browser",Status.FAIL);				
			}
			else
				report.updateTestLog("Verifying PD page after clicking product in list page","PD page not loaded successfully",Status.FAIL);
			
  }
  
  public void verifyShowMe() throws Exception
  {
	  if(driver.findElement(By.xpath("//*[@id='left_rail_pl']/h4[1]")).isDisplayed())
		  report.updateTestLog("Verifying ShowMe in List page","ShowMe is displayed",Status.PASS);
	  else
		  report.updateTestLog("Verifying ShowMe in List page","ShowMe is not displayed",Status.FAIL);
  }
  public void navigateToNPCresults() throws Exception
  {
	  ClickCustomize("xpath",UIMapProductSearch.lnkIdeasHowTos);
	  selenium.waitForPageToLoad("20000");
	  Thread.sleep(6000);
	  try{
	  if(!(driver.findElement(By.id("breadcrumbs")).isDisplayed()))
  		  report.updateTestLog("Verifying Ideas & How-To Search Results page","Toggled to Ideas & How-To Search Results page",Status.PASS);
  	  else
  		report.updateTestLog("Verifying Ideas & How-To Search Results page","NOT Toggled to Ideas & How-To Search Results page",Status.FAIL);
	  }
	  catch(Exception e)
	  {
		  report.updateTestLog("Verifying Ideas & How-To Search Results page","Toggled to Ideas & How-To Search Results page",Status.PASS);
	  }

  }
  public void verifyFilterBehaviourNPC() throws Exception
  {
	  
	  String rr = driver.findElement(By.xpath("//li[2]/input")).getAttribute("value"); 
	  String refinementName = driver.findElement(By.xpath("//li[2]/input")).getAttribute("name");
	  int refinementResults = Integer.parseInt(rr);
	  ClickCustomize("xpath","//li[2]/input");
	  selenium.waitForPageToLoad("20000");
	  Thread.sleep(6000);
	  String nor = driver.findElement(By.xpath(UIMapProductSearch.lblnumberOfResults)).getText();
	  int TotalResults = Integer.parseInt(nor.trim());
	  System.out.println("Total Results"+TotalResults);
	  System.out.println("Refinement Results"+refinementResults);
	  if(TotalResults == refinementResults)
	  {
		  report.updateTestLog("Verifying page results corresponding to selected refinement","Page results are matched",Status.PASS);
		  if(driver.findElement(By.xpath(UIMapProductSearch.youHaveChoosen)).isDisplayed())
		  {
			  report.updateTestLog("Verifying You Have Choosen section","You Have Choosen is displayed",Status.PASS);
			  String filteredName = driver.findElement(By.xpath("//li[1]/ul/li/a")).getAttribute("title");
			  System.out.println("filteredname"+filteredName);
			  System.out.println("refinementName"+refinementName);
			  String refinedName = refinementName.replace("_","");
			  System.out.println(refinedName);
			  if(filteredName.contains(refinedName))
			  {
				  report.updateTestLog("Verifying refinements in You Have Choosen section","Refinements in You Have Choosen section is correctly displayed",Status.PASS);
				  int numberOfRefinements = ps.countWebElement("//*[@id='left_rail_lci']/ul[2]/li[3]/ul/li");
				  if(numberOfRefinements > 6)
					  numberOfRefinements = numberOfRefinements-1;
				  System.out.println("Reached here");
				  int flag = 0;
				  for(int i=1;i<=numberOfRefinements;i++)
				  {
					  System.out.println("Entered for loop");
					  WebElement w = driver.findElement(By.xpath("//li[2]/ul/li["+i+"]/input"));
					  String s = w.findElement(By.xpath("..")).getAttribute("class");
					  System.out.println("Status"+s);
					  if(!(s.contains("disabled")))
					  {
						  System.out.println("Entered if loop");
						  flag =1;
						  ClickCustomize("xpath","//li[2]/ul/li["+i+"]/input");
						  selenium.waitForPageToLoad("20000");
						  Thread.sleep(6000);
						  String count = driver.findElement(By.xpath("//li[1]/ul/li[2]/label")).getText();
						  String[] count1 = count.split("\\(");
						  String refineCount = count1[1].substring(0,(count1.length)-1);
						  int refinecount = Integer.parseInt(refineCount);
						  String nor1 = driver.findElement(By.xpath(UIMapProductSearch.lblnumberOfResults)).getText();
						  int TotalResults1 = Integer.parseInt(nor1.trim());
						  String NextfilteredName = driver.findElement(By.xpath("//li[2]/ul/li/a")).getAttribute("title");
						  String nextRefinementName = driver.findElement(By.xpath("//li[2]/ul/li["+i+"]/input")).getAttribute("name"); 
						  String nxtrefineName = nextRefinementName.replace("_","");
						  System.out.println("Next"+NextfilteredName);
						  System.out.println("Next refine"+nxtrefineName);
						  if(NextfilteredName.contains(nxtrefineName) && (refinecount == TotalResults1))
						  {
							  report.updateTestLog("Selecting one more refinement from another category group","Next refinement selected",Status.PASS);
							  ClickCustomize("xpath","//li[2]/ul/li/a");
							  selenium.waitForPageToLoad("20000");
							  Thread.sleep(6000);
							  String cnt = driver.findElement(By.xpath("//li[1]/ul/li[2]/label")).getText();
							  System.out.println(cnt);
							  String[] cnt1 = cnt.split("\\(");
							  String refineCount1 = cnt1[1].substring(0,(cnt1.length)-1);
							  int refinecount1 = Integer.parseInt(refineCount1);
							  System.out.println(refinecount1);
							  if(refinecount1 == refinementResults)
								  report.updateTestLog("Verifying count after removing one refinement","refinement count updated",Status.PASS);
							  else
								  report.updateTestLog("Verifying count after removing one refinement","refinement count Not updated",Status.FAIL);   
						  }
						  else
							  report.updateTestLog("Selecting one more refinement from another category group","Next refinement not selected",Status.FAIL); 
					  }
					  System.out.println("flag"+flag);
                   if(flag == 1)
                	   break;	  
				  }
			  }
			  else
				  report.updateTestLog("Verifying refinements in You Have Choosen section","Refinements in You Have Choosen section is NOT correctly displayed",Status.FAIL);
		  }
		  else
			  report.updateTestLog("Verifying You Have Choosen section","You Have Choosen is not displayed",Status.FAIL);
		  
	  }
	  else
		  report.updateTestLog("Verifying page results corresponding to selected refinement","Page results are not matched",Status.FAIL);
  }
  
  public void verifySeeMore() throws Exception
  {
	  if(driver.findElement(By.xpath("//*[@id='lci-landing-content']/div[2]/div[17]/div/p/a")).getText().equals("See More Ideas"))
	  {
		  report.updateTestLog("Verifying See More Ideas link","See More Ideas link is present for the selected category",Status.PASS);
		  ClickCustomize("linkText","See More Ideas");
		  selenium.waitForPageToLoad("20000");
		  Thread.sleep(6000);
		  int totalProjects = ps.countWebElement("//*[@id='lci-landing-content']/div[2]/div");
		  totalProjects = totalProjects-1;
		  if(totalProjects<=4)
			  totalProjects = totalProjects-1;
		  else if(totalProjects<=8)
			  totalProjects = totalProjects-2;
		  else if(totalProjects<=12)
			  totalProjects = totalProjects-3;
		  else if(totalProjects<=16)
			  totalProjects = totalProjects-4;
		  System.out.println("totalProjects"+totalProjects);
		  if((totalProjects > 6) && (totalProjects <= 12))
			  report.updateTestLog("Clicking See More Ideas link","See More Ideas link clicked",Status.PASS);
		  else
			  report.updateTestLog("Clicking See More Ideas link","See More Ideas link Not clicked",Status.FAIL);
	  }
	  else
		  report.updateTestLog("Verifying See More Ideas link","See More Ideas link is not present for the selected category",Status.FAIL);
	  if(driver.findElement(By.xpath("//*[@id='lci-landing-content']/div[4]/div[13]/div/p/a")).getText().equals("See More How-Tos"))
	  {
		  report.updateTestLog("Verifying See More How-Tos link","See More How-Tos link is present for the selected category",Status.PASS);
		  ClickCustomize("linkText","See More How-Tos");
		  selenium.waitForPageToLoad("20000");
		  Thread.sleep(6000);
		  int totalProjects = ps.countWebElement("//*[@id='lci-landing-content']/div[4]/div");
		  totalProjects = totalProjects-1;
		  if(totalProjects<=4)
			  totalProjects = totalProjects-1;
		  else if(totalProjects<=8)
			  totalProjects = totalProjects-2;
		  else if(totalProjects<=12)
			  totalProjects = totalProjects-3;
		  else if(totalProjects<=16)
			  totalProjects = totalProjects-4;
		  if((totalProjects > 6) && (totalProjects <= 12))
			  report.updateTestLog("Clicking See More How-Tos link","See More How-Tos link clicked",Status.PASS);
		  else
			  report.updateTestLog("Clicking See More How-Tos link","See More How-Tos link Not clicked",Status.FAIL);
	  }
	  else
		  report.updateTestLog("Verifying See More How-Tos link","See More How-Tos link is not present for the selected category",Status.FAIL);
  }
 
  public void verifyStarRatingsText() throws Exception
  {
	  for(int i=1;i<=4;i++)
	  {
	  Actions actions = new Actions(driver);
	  WebElement w = driver.findElement(By.xpath("//*[@id='Rating']/ul/li/div/a["+i+"]"));
	  actions.moveToElement(w).build().perform();
	  Thread.sleep(2000);
	  String s = driver.findElement(By.xpath("//*[@id='Rating']/ul/li/p")).getText();
	  String hoverText = driver.findElement(By.xpath("//*[@id='Rating']/ul/li/div/a["+i+"]")).getAttribute("title");
	  if(s.equals(i+" or More Stars"))
		  report.updateTestLog("Verifying Display Text for"+i+"Stars","Display Text is correctly displayed",Status.PASS);
	  else
		  report.updateTestLog("Verifying Display Text for"+i+"Stars","Display Text is incorrectly displayed",Status.FAIL);
	  
	  if(hoverText.equals(i+" Stars and Above"))
	      report.updateTestLog("Verifying hover Text for"+i+"Stars","Hover Text is correctly displayed",Status.PASS);
	  else
		  report.updateTestLog("Verifying hover Text for"+i+"Stars","Hover Text is incorrectly displayed",Status.FAIL);
	  }
	  //for 5 Stars
	  Actions actions = new Actions(driver);
	  WebElement w1 = driver.findElement(By.xpath("//*[@id='Rating']/ul/li/div/a[5]"));
	  actions.moveToElement(w1).build().perform();
	  String s1 = driver.findElement(By.xpath("//*[@id='Rating']/ul/li/p")).getText();
	  String hoverText1 = driver.findElement(By.xpath("//*[@id='Rating']/ul/li/div/a[5]")).getAttribute("title");
	  if(s1.equals("5 Stars Only"))
		  report.updateTestLog("Verifying Display Text for 5 Stars","Display Text is correctly displayed",Status.PASS);
	  else
		  report.updateTestLog("Verifying Display Text for 5 Stars","Display Text is incorrectly displayed",Status.FAIL);
	  
	  if(hoverText1.equals("5 Stars Only"))
	      report.updateTestLog("Verifying hover Text for 5 Stars","Hover Text is correctly displayed",Status.PASS);
	  else
		  report.updateTestLog("Verifying hover Text for 5 Stars","Hover Text is incorrectly displayed",Status.FAIL);

  }
  public void verifyRatingsRefinement() throws Exception
  {
	    String dataCnt = driver.findElement(By.xpath("//*[@id='Rating']/ul/li/div/a[3]")).getAttribute("data-count");
		int dataCount = Integer.parseInt(dataCnt);
		if(dataCount>0)
		{
			ClickCustomize("xpath","//*[@id='Rating']/ul/li/div/a[3]");
			selenium.waitForPageToLoad("30000");
			Thread.sleep(6000);
			String ResCount = driver.findElement(By.xpath(UIMapProductSearch.lblnumberOfResults)).getText();
			int ResultsCount = Integer.parseInt(ResCount);
			String selectedRefinement = driver.findElement(By.xpath("//*[@id='Rating-chosen']/ul/li/img")).getAttribute("title");
			if(ResultsCount == dataCount)
			{
				report.updateTestLog("Veriying refinement behaviour for 3 Stars","3 Stars refinement correctly applied",Status.PASS);
				String dataCnt1 = driver.findElement(By.xpath("//*[@id='Rating']/ul/li/div/a[2]")).getAttribute("data-count");
				int dataCount1 = Integer.parseInt(dataCnt1);
				if(dataCount1>0)
				{
					ClickCustomize("xpath","//*[@id='Rating']/ul/li/div/a[2]");
					selenium.waitForPageToLoad("30000");
					Thread.sleep(6000);
					String ResCount1 = driver.findElement(By.xpath(UIMapProductSearch.lblnumberOfResults)).getText();
					int ResultsCount1 = Integer.parseInt(ResCount1);
					String selectedRefinement1 = driver.findElement(By.xpath("//*[@id='Rating-chosen']/ul/li/img")).getAttribute("title");
					if(ResultsCount1 == dataCount1)
					{
						report.updateTestLog("Veriying refinement behaviour for 2 Stars","2 Stars refinement correctly applied",Status.PASS);
						if(selectedRefinement1.equals("Rating 2 stars and above"))
							report.updateTestLog("Checking selected refinement","2 stars refinement selected",Status.PASS);
						else
							report.updateTestLog("Checking selected refinement","2 stars refinement not selected",Status.FAIL);
						
					}
					else
							report.updateTestLog("Veriying refinement behaviour for 2 Stars","2 Stars refinement incorrectly applied",Status.FAIL);

			}
			else
					report.updateTestLog("Veriying refinement behaviour for 3 Stars","3 Stars refinement incorrectly applied",Status.FAIL);
		}
			else
				report.updateTestLog("Veriying refinement behaviour for 2 Stars","2 Stars refinement not correctly applied",Status.FAIL);
		}
		else
			report.updateTestLog("Verifying count for the 2 Stars refinement","count for the 2 Stars refinement is Zero",Status.FAIL);
  }
  
  //Nupur
  public void flooringPriceZipped()throws Exception{
		
		boolean pricingSection = driver.findElement(By.id("pricing")).isDisplayed();
		if(pricingSection)
		{
			//verify the display of Price/ Sq. Ft.
			String pricePerSqFt = driver.findElement(By.xpath("//div[@id='pricing']/span")).getText();
			System.out.println(pricePerSqFt);
			if (pricePerSqFt.contains("/ Sq. Ft."))
			{
			report.updateTestLog("Validating the display of price per squarefoot",
					"Price/ Sq. Ft. is displayed", Status.PASS);
			}
			else
			{
				report.updateTestLog("Validating the display of price per squarefoot",
						"Price/ Sq. Ft. is not displayed", Status.FAIL);
			}
		
			//Verify the display of Purchase price and coverage area
			String purchasePrice = driver.findElement(By.xpath("//div[@id='pricing']/p")).getText();
			System.out.println(purchasePrice);
			if ((purchasePrice.contains("Purchase Price:")) && (purchasePrice.contains("(Covers")))
			{
			report.updateTestLog("Validating the display of Purchase price and Coverage area",
					"Purchase price and Coverage area is displayed", Status.PASS);
			}
			else
			{
				report.updateTestLog("Validating the display of Purchase price and Coverage area",
						"Purchase price and Coverage area is not displayed", Status.FAIL);
			}
			
		}	
		else
		{
			report.updateTestLog("Validating the display of pricing sction",
					"pricing section is not displayed", Status.FAIL);
		}	
		
		
	}

	//function to verify Pricing section for unzipped user
	
	public void flooringPriceUnZipped()throws Exception{
		try {
			boolean pricingSection = driver.findElement(By.id("pricing")).isDisplayed();
			if(pricingSection)
			{
				report.updateTestLog("Validating the display of pricing section",
						"pricing section is displayed for unzipped user", Status.FAIL);
			}
			else
			{
				report.updateTestLog("Validating the display of pricing section",
						"pricing section is not displayed for unzipped user", Status.PASS);
			}
		}
		catch(Exception e)
		{
			
			report.updateTestLog("Validating the display of pricing section",
					"pricing section is not displayed for unzipped user", Status.PASS);
		}
		
		
	}
	
	public void onlyAtLowes()throws Exception{
		List<WebElement> varProductList = driver.findElements(By
				.xpath("//*[@id='productResults']/li"));
		int varCount = varProductList.size();
		System.out.println("Number of search results: "+varCount);
		int i;
		for (i = 1; i <= varCount; i++) {
			String varXPath = "//*[@id='productResults']/li[" + i + "]";
			String varID = driver.findElement(By.xpath(varXPath)).getAttribute("id");
			System.out.println(varID);
			
			try {
				String ItemNo = driver.findElement(By.xpath("//*[@id='" + varID + "']/div/div[4]/ul[1]/li[1]")).getText();
				System.out.println(ItemNo);
				if (ItemNo.contains(dataTable.getData("General_Data","ItemNbr")))
					{
					report.updateTestLog("Verifying the display of the item in the list",
							"Item is present in the list", Status.PASS);
					
					//verifying the Only at Lowes' label in the list
					String onlyAtLoweslabel = driver.findElement(By.xpath(
							"//*[@id='" + varID + "']/div/div[5]/ul/li/span")).getText();
					System.out.println(onlyAtLoweslabel);
					if (onlyAtLoweslabel.contains("Only at Lowe's"))
					{
						report.updateTestLog("Verifying the display of 'Only at Lowes' label",
								"'Only at Lowes' label is present", Status.PASS);
					}
					else
					{
						report.updateTestLog("Verifying the display of 'Only at Lowes' label",
								"'Only at Lowes' label is not present", Status.FAIL);
					}
					
					//compare items
					boolean compare1 = driver.findElement(
							By.xpath("//li[" + i + "]/div/div/div/input")).isDisplayed();
					if (compare1) {
						report.updateTestLog("Compare Present for item1", "Compare displayed",
								Status.PASS);
						// click compare1
						driver.findElement(By.xpath("//li[" + i + "]/div/div/div/input")).click();
					} else {
						report.updateTestLog("Compare not Present for item1",
								"Compare is not displayed", Status.FAIL);
					}
					selenium.waitForPageToLoad("20000");
					Thread.sleep(6000);
					
					boolean compare2 = driver.findElement(
							By.xpath("//li[" + (i+1) + "]/div/div/div/input")).isDisplayed();
					if (compare2) {
						report.updateTestLog("Compare Present for item2", "Compare displayed",
								Status.PASS);
						// click compare1
						driver.findElement(By.xpath("//li[" + (i+1) + "]/div/div/div/input")).click();
					} else {
						report.updateTestLog("Compare not Present for item2",
								"Compare not displayed", Status.FAIL);
					}
					selenium.waitForPageToLoad("20000");
					Thread.sleep(6000);
					
					driver.findElement(By.xpath(UIMapMyLowes.btnCompare)).click();
					selenium.waitForPageToLoad("20000");
					Thread.sleep(6000);
					
					//verify Only at Lowe's label in compare page
					
					
					boolean onlyAtLoweslabelCompare = driver.findElement(
							By.xpath("//div[@id='header_container']/div[2]/div/table/tbody/tr[2]/td/span")).isDisplayed();
					if(onlyAtLoweslabelCompare)
					{
						report.updateTestLog("Validating the display of 'Only at Lowes' label on Compare ",
								"'Only at Lowes' label is present on Compare", Status.PASS);
					}
					else
					{
						report.updateTestLog("Validating the display of 'Only at Lowes' label on Compare ",
								"'Only at Lowes' label is not present on Compare", Status.FAIL);
					}
					
					//navigate back
					driver.navigate().back();
					selenium.waitForPageToLoad("20000");
					Thread.sleep(6000);
					
					//verifying the Only at Lowes' label in the Quick View
					driver.findElement(By.xpath(
							"//*[@id='" + varID + "']/div/div[1]/a[2]")).click();
					Thread.sleep(5000);
					boolean onlyAtLoweslabelQV = driver.findElement(By.xpath("//div[@id='descCont']/span")).isDisplayed();
					if(onlyAtLoweslabelQV)
					{
						report.updateTestLog("Validating the display of 'Only at Lowes' label on QuickView ",
								"'Only at Lowes' label is present on QuickView", Status.PASS);
					}
					else
					{
						report.updateTestLog("Validating the display of 'Only at Lowes' label on QuickView ",
								"'Only at Lowes' label is not present on QuickView", Status.FAIL);
					}
					//close the pop up
					driver.navigate().refresh();
					//int varCount1 = ps.countWebElement("html/body/div");
					//driver.findElement(By.xpath("html/body/div["+varCount1+"]/div[1]/a/span")).click();
					
					//verify display of 'Only at Lowes' label on Detail page
					driver.findElement(By.xpath(
							"//li[@id='" + varID + "']/div/div[2]/h3/a")).click();
					selenium.waitForPageToLoad("20000");
					Thread.sleep(6000);
					boolean onlyAtLoweslabelDetail = driver.findElement(By.xpath("//div[@id='descCont']/p[1]")).isDisplayed();
					if(onlyAtLoweslabelDetail)
					{
						report.updateTestLog("Validating the display of 'Only at Lowes' label on Detail page ",
								"'Only at Lowes' label is present on Detail page", Status.PASS);
					}
					else
					{
						report.updateTestLog("Validating the display of 'Only at Lowes' label on Detail page ",
								"'Only at Lowes' label is not present on Detail page", Status.FAIL);
					}
					//navigate back
					driver.navigate().back();
					selenium.waitForPageToLoad("20000");
					Thread.sleep(6000);
					}
				else
					continue;
			} catch (Exception NoSuchElementException) {
				continue;
			}
		}
	}
	
		
	public void eppNotDisplayed()throws Exception{	
		//validate the absence of EPP section
		
		try {
		boolean warrantySection = driver.findElement(By.linkText("Protection Plans")).isDisplayed();
		if(warrantySection)
		{
			report.updateTestLog("Validating the display of Protection Plans tab on Detail page of non-EPP item ",
					"Protection Plans tab is present on Detail page", Status.FAIL);
		}
		else
		{
			report.updateTestLog("Validating the display of Protection Plans tab on Detail page of non-EPP item ",
					"Protection Plans tab is not present on Detail page", Status.PASS);
		}
		}
		catch(Exception e)
		{
			
			report.updateTestLog("Validating the display of Protection Plans tab on Detail page of non-EPP item ",
					"Protection Plans tab is not present on Detail page", Status.PASS);
		}
			
	}
	
	public void eppDisplayed()throws Exception{	
		//validate the presence of Protection plans tab
		try {
		boolean protectionPlansTab = driver.findElement(By.linkText("Protection Plans")).isDisplayed();
		if(protectionPlansTab)
		{
			report.updateTestLog("Validating the display of Protection Plans tab on Detail page of EPP item ",
					"Protection Plans tab is present on Detail page", Status.PASS);
			
			//protection plans section after clicking on PP tab
			driver.findElement(By.linkText("Protection Plans")).click();
			boolean protectionPlansSection = driver.findElement(By.xpath("//div[@id='warranties_tab']")).isDisplayed();
			if(protectionPlansSection)
			{
				report.updateTestLog("Validating the display of Protection Plans section ",
						"Protection Plans section is displayed on Detail page", Status.PASS);
			}
			else
			{
				report.updateTestLog("Validating the display of Protection Plans section ",
						"Protection Plans section is not displayed on Detail page", Status.FAIL);
			}
			
			//EPP section display
			boolean eppSection = driver.findElement(By.xpath("//ul[@id='warranty']")).isDisplayed();
			if(eppSection)
			{
				report.updateTestLog("Validating the display of EPP section ",
						"EPP section is displayed on Detail page", Status.PASS);
				boolean checkbox = driver.findElement(By.xpath(
						"//ul[@id='warranty']/li[1]/div/input")).isDisplayed();
				if(checkbox)
				{
					report.updateTestLog("Validating the display of checkboxes in the EPP section ",
							"Checkboxes are displayed in the EPP section on Detail page", Status.PASS);
				}
				else
				{
					report.updateTestLog("Validating the display of checkboxes in the EPP section ",
							"Checkboxes are not displayed in the EPP section on Detail page", Status.FAIL);
				}
			}
			else
			{
				report.updateTestLog("Validating the display of EPP section ",
						"EPP section is not displayed on Detail page", Status.FAIL);
			}
			
		}
		else
		{
			report.updateTestLog("Validating the display of Protection Plans tab on Detail page of EPP item ",
					"Protection Plans tab is not present on Detail page", Status.FAIL);
		}
		}
		catch(Exception e)
		{
			
			report.updateTestLog("Validating the display of Protection Plans tab on Detail page of EPP item ",
					"Protection Plans tab is not present on Detail page", Status.FAIL);
		}
			
	}
	
	public void breadCrumbVerify()throws Exception{	
		//verify breadcrumb on list page
		String varBreadcrumbLvl1 = driver.findElement(By.xpath("//div[@id='breadcrumbs']/ul/li[1]/a")).getText();
		System.out.println(varBreadcrumbLvl1);
		String varBreadcrumbLvl2= driver.findElement(By.xpath("//div[@id='breadcrumbs']/ul/li[2]")).getText();
		System.out.println(varBreadcrumbLvl2);
		System.out.println((" Search \""+dataTable.getData("General_Data","SearchString")+"\""));
	
		if((varBreadcrumbLvl1.contains("Home")) & 
				(varBreadcrumbLvl2.contains("Search \""+dataTable.getData("General_Data","SearchString")+"\"")))
		{
			report.updateTestLog("verify Breadcrumb on list page","List page breadcrumb is properly displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("verify Breadcrumb on list page","List page breadcrumb is not correct", Status.FAIL);
		}
		//go to product detail page of first product in the list
		goToProductDetailPage();
		
		//count the number oflevels in breadcrumb
		int varcount2 = ps.countWebElement("//ul[@id='breadcrumbs-list']/li");
		System.out.println(varcount2);
		
		//get the text of the last level of breadcrumb
		String varBreadcrumbDetail = driver.findElement(By.xpath(
				"//ul[@id='breadcrumbs-list']/li["+varcount2+"]")).getText();
		
		//get the product name
		String productName = driver.findElement(By.xpath("//div[@id='descCont']/div/h1")).getText();
		
		//comapre the breadcrumb with the product name
		if((varBreadcrumbDetail.contains(productName)))				
		{
			report.updateTestLog("verify Breadcrumb on PD page","PD page breadcrumb is properly displayed", Status.PASS);
		}
		else
		{
			report.updateTestLog("verify Breadcrumb on PD page","PD page breadcrumb is not correct", Status.FAIL);
		} 
		//Home link present
		if (driver.findElement(By.linkText("Home")).isDisplayed())
		{
			report.updateTestLog("verify the display of 'Home' as a link","'Home' is displayed as a link", Status.PASS);
		}
		else
		{
			report.updateTestLog("verify the display of 'Home' as a link","'Home' is not displayed as a link", Status.FAIL);
		}
		
		//search link present
		
		if (driver.findElement(By.linkText(varBreadcrumbLvl2)).isDisplayed())
		{
			report.updateTestLog("verify the display of Search 'search term' as a link",
					"Search 'search term' is displayed as a link", Status.PASS);
		}
		else
		{
			report.updateTestLog("verify the display of Search 'search term' as a link",
					"Search 'search term' is not displayed as a link", Status.FAIL);
		}
		
		//product name as a link
		try{
		if (driver.findElement(By.linkText((varBreadcrumbDetail))).isDisplayed())
		{
			report.updateTestLog("verify the display of product name in breadcrumb as a link",
					"product name in breadcrumb is displayed as a link", Status.FAIL);
		}
		else
		{
			report.updateTestLog("verify the display of product name in breadcrumb as a link",
					"product name in breadcrumb is not displayed as a link", Status.PASS);
		}
		}catch(Exception e)
		{
			report.updateTestLog("verify the display of product name in breadcrumb as a link",
					"product name in breadcrumb is not displayed as a link", Status.PASS);
		}
		
		//click on Search "search term"
		driver.findElement(By.xpath("//div[@id='breadcrumbs']/ul/li[2]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		
		  
		 if(driver.getTitle().contains("Shop "+dataTable.getData("General_Data","SearchString")+" at Lowes.com: Search Results"))
			{
				report.updateTestLog("Click functionality of Search 'search term'link", 
						"Search 'search term' page is displayed",
						Status.PASS);
			} else {
				report.updateTestLog("Click functionality of Search 'search term' link", 
						"Search 'search term' page is not displayed",
						Status.FAIL);
			}
		
	}
	
	public void inStorePricingInfo()throws Exception{
		String priceAvailabilityText = driver.findElement(By.id("priceAvailability")).getText();
		System.out.println(priceAvailabilityText);
		if (priceAvailabilityText.contains("This item is unavailable for purchase online. You can purchase it at"))
		{
			report.updateTestLog("Validating the display of Price availability text ",
					"Price availability text is displayed properly on Detail page", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the display of Price availability text ",
					"Price availability text is not displayed properly on Detail page", Status.FAIL);
		}
		
		//click on Store Info & Hours
		try{
		driver.findElement(By.linkText("Store Info & Hours")).click();
		boolean expandedStoreInfo = driver.findElement(By.id("expandedStoreInfo")).isDisplayed(); 
		if (expandedStoreInfo)
		{
			report.updateTestLog("Validating the click functionality of Store Info & Hours link ",
					"expandedStoreInfo is displayed properly", Status.PASS);
		}
		else
		{
			report.updateTestLog("Validating the click functionality of Store Info & Hours link",
					"expandedStoreInfo is not displayed", Status.FAIL);
		}
		} catch(Exception e)
		{
			report.updateTestLog("Validating the display of Store Info & Hours link",
					"Store Info & Hours link is not displayed", Status.FAIL);
		}
		
		//Verify price is displayed under the product name
		
		try {
		String pricing = driver.findElement(By.id("pricing")).getText();
		System.out.println(pricing);
		report.updateTestLog("Validating the display of pricing section",
				"price is displayed as "+pricing+" in the pricing section", Status.PASS);
		
		} catch( Exception e)
		{
			report.updateTestLog("Validating the display of pricing section",
					"pricing section is not displayed", Status.FAIL);
		}	
	}
//Kish
	
	public void chooseNumberOfResults() throws Exception
	{
		String Nor = driver.findElement(By.xpath(UIMapProductSearch.lblnumberOfResults)).getText();
		int TotalResults = Integer.parseInt(Nor);
		System.out.println("Total Results"+TotalResults);
		if(TotalResults>16)
		{
		new Select(
				driver.findElement(By
						.xpath("//div[@id='main_content_rail']/div[3]/div/form/select")))
				.selectByVisibleText("16");
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		List<WebElement> varProductList = driver.findElements(By
				.xpath("//*[@id='productResults']/li"));
		int varCount = varProductList.size();
		if(varCount==16)
			report.updateTestLog("Selecting number of results as 16","Results Per dropdown set to 16",Status.PASS);
		else
			report.updateTestLog("Selecting number of results as 16","Results Per dropdown Not set to 16",Status.FAIL);
		new Select(
				driver.findElement(By
						.xpath("//div[@id='main_content_rail']/div[3]/div/form/select")))
				.selectByVisibleText("32");
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		List<WebElement> varProductList2 = driver.findElements(By
				.xpath("//*[@id='productResults']/li"));
		int varCount2 = varProductList2.size();
		if(varCount2>16 && varCount2<=32)
			report.updateTestLog("Selecting number of results as 32","Results Per dropdown set to 32",Status.PASS);
		else
			report.updateTestLog("Selecting number of results as 32","Results Per dropdown Not set to 32",Status.FAIL);
		new Select(
				driver.findElement(By
						.xpath("//div[@id='main_content_rail']/div[3]/div/form/select")))
				.selectByVisibleText("48");
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		List<WebElement> varProductList3 = driver.findElements(By
				.xpath("//*[@id='productResults']/li"));
		int varCount3 = varProductList3.size();
		if(varCount3>16 && varCount3<=48)
			report.updateTestLog("Selecting number of results as 48","Results Per dropdown set to 48",Status.PASS);
		else
			report.updateTestLog("Selecting number of results as 48","Results Per dropdown Not set to 48",Status.FAIL);

		}
		else
			report.updateTestLog("Verifying Results Per Page dropdown","Results Per Page dropdown is not displayed",Status.FAIL);
		}
	public void compareTwoItems() throws Exception
	{
		List<WebElement> varProductList = driver.findElements(By
				.xpath("//*[@id='productResults']/li"));
		int varCount = varProductList.size();
		int i;
		int flag=0;
		for (i = 1; i <= varCount; i++) {
		boolean compare1 = driver.findElement(
				By.xpath("//li[" + i + "]/div/div/div/input")).isDisplayed();
		if (compare1) {
			flag=flag+1;
			report.updateTestLog("Compare Present for item", "Compare displayed",
					Status.PASS);
			// click compare
			driver.findElement(By.xpath("//li[" + i + "]/div/div/div/input")).click();
		} else {
			report.updateTestLog("Compare not Present for item",
					"Compare is not displayed", Status.FAIL);
		}
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		if(flag==2)
			break;
		
	}
		driver.findElement(By.xpath(UIMapMyLowes.btnCompare)).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
	}
	public void validateMiniCartInCA() throws Exception
	{
		Actions actions = new Actions(driver);
		WebElement w = driver.findElement(By.xpath(UIMapCheckOut.webElmntMiniCart));
		actions.moveToElement(w).build().perform();
		System.out.println("Mouse hover successful");
		Thread.sleep(6000);
		if(driver.findElement(By.xpath(UIMapCheckOut.lblCartEmpty)).getText().contains("Your cart is empty"))
			report.updateTestLog("Validating MiniCart","Mini Cart is empty",Status.PASS);
		else
			report.updateTestLog("Validating MiniCart","Mini Cart is NOT empty",Status.FAIL);
		
		ClickCustomize("xpath","//td/a/span");
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		if(driver.findElement(By.xpath(UIMapCheckOut.lblItemAdded)).isDisplayed())
		{
			report.updateTestLog("Verifying Notification Modal","Notification Modal is displayed",Status.PASS);
			co.clickContinueShopping();
			String pageItemSRC = driver.findElement(By.xpath("//div[2]/div/table/tbody/tr[2]/td/div[1]/a/img")).getAttribute("src");
			String pageItemPrice = driver.findElement(By.xpath("//div[2]/div/table/tbody/tr[3]/td/div")).getText();
			String miniCartItemSRC = driver.findElement(By.xpath(UIMapCheckOut.webelmntMiniCartImg)).getAttribute("src");
			String miniCartItemPrice = driver.findElement(By.xpath(UIMapCheckOut.webelmntMiniCartPrice)).getText();
			if(pageItemSRC.equals(miniCartItemSRC) && pageItemPrice.trim().equals(miniCartItemPrice.trim()))
				report.updateTestLog("Verifying added item in mini cart","Item added to mini cart",Status.PASS);
			else
				report.updateTestLog("Verifying added item in mini cart","Item not added to mini cart",Status.FAIL);
		}
		else
			report.updateTestLog("Verifying Notification Modal","Notification Modal is not displayed",Status.FAIL);
		
	}
	public void verifyPreviousNextButtons() throws Exception
	{
		String LastPageNo = driver.findElement(By.xpath("//div/span[3]")).getText();
		int LastPage = Integer.parseInt(LastPageNo);
		ClickCustomize("linkText",UIMapProductSearch.lnkPrevious);
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		String CurrentPageNo = driver.findElement(By.xpath(UIMapProductSearch.lnkCurrentPage)).getText();
		int CurrentPage = Integer.parseInt(CurrentPageNo);
		if(CurrentPage==LastPage)
			report.updateTestLog("Verifying Page after clicking previous","Page correctly updated",Status.PASS);
		else
			report.updateTestLog("Verifying Page after clicking previous","Page NOT updated",Status.FAIL);
		ClickCustomize("linkText",UIMapProductSearch.lnkNext);
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		String CurrentPageNo1 = driver.findElement(By.xpath(UIMapProductSearch.lnkCurrentPage)).getText();
		int CurrentPage1 = Integer.parseInt(CurrentPageNo1);
		if(CurrentPage1 == 1)
			report.updateTestLog("Verifying page after clicking on Next button","Page updated correctly",Status.PASS);
		else
			report.updateTestLog("Verifying page after clicking on Next button","Page NOT updated correctly",Status.FAIL);

	}
	
	public void verifyGotoPage() throws Exception
	{
		driver.findElement(By.name("pageNumber")).clear();
		String LastPageNo = driver.findElement(By.xpath("//div/span[3]")).getText();
		int LastPage = Integer.parseInt(LastPageNo);
		int GotoPage = Integer.parseInt(dataTable.getData("General_Data", "GoTo Page"));
		if(GotoPage < LastPage)
		{
			driver.findElement(By.name("pageNumber")).sendKeys(
				dataTable.getData("General_Data", "GoTo Page"));
		driver.findElement(By.xpath("//a[contains(text(),'Go')]")).click();
		selenium.waitForPageToLoad("20000");
		Thread.sleep(6000);
		String updatedPageNo = driver.findElement(By.xpath(UIMapProductSearch.lnkCurrentPage)).getText();
		System.out.println("updatedPageNo"+updatedPageNo);
		int updatedPage = Integer.parseInt(updatedPageNo.trim());
		System.out.println("updatedPage"+updatedPage);
		if(updatedPage == GotoPage)
			report.updateTestLog("verifying page refresh after entering page number in GoTo field","Page refreshed properly",Status.PASS);
		else
			report.updateTestLog("verifying page refresh after entering page number in GoTo field","Page Not refreshed properly",Status.FAIL);
	}
	}
	public void verifyBackToTop() throws Exception
	{
		if(selenium.isElementPresent("//*[@id='back-to-top']/a"))
			report.updateTestLog("Verifying Back To Top","Verified Back To Top",Status.PASS);
		else
			report.updateTestLog("Verifying Back To Top","Back To Top not present",Status.FAIL);
	}
	public void verifyAutoZipModalInListPage() throws Exception
	{
		try{
		if(driver.findElement(By.xpath(UIMapProductSearch.autozip)).isDisplayed())
			report.updateTestLog("Verifying Autozip modal in list page","Autozip modal is present",Status.PASS);
		else
			report.updateTestLog("Verifying Autozip modal in list page","Autozip modal is Not present",Status.FAIL);
		}
		catch(Exception e)
		{
			report.updateTestLog("Verifying Autozip modal in list page","Autozip modal is Not present",Status.FAIL);
		}
	}
	
	
	public void clickRefinementMoreThan15InLCIcat() throws Exception
	{
		if(driver.findElement(By.xpath(UIMapProductSearch.lciLeftRail)).isDisplayed())
		{
			report.updateTestLog("Verifying Left Rail in LCI Category page","Left Rail is displayed in LCI Category page",Status.PASS);
			String CatGroupName = dataTable.getData("General_Data","CatGroupName");
			if(CatGroupName.equalsIgnoreCase("Home Areas"))
			{
			int Count = ps.countWebElement("//*[@id='left_rail_lci']/ul/li[1]/ul/li");
			if(Count>6)
				Count=Count-1;
			for(int i=1;i<=Count;i++)
			{
			String text = driver.findElement(By.xpath("//*[@id='left_rail_lci']/ul/li[1]/ul/li["+i+"]/a")).getText();
			String[] cnt1 = text.split("\\(");
			String refineCount1 = cnt1[1].substring(0,(cnt1.length)-1);
			int refinecount1 = Integer.parseInt(refineCount1);
			System.out.println(refinecount1);
			if(refinecount1>15)
			{
			ClickCustomize("xpath","//*[@id='left_rail_lci']/ul/li[1]/ul/li["+i+"]/a");
			selenium.waitForPageToLoad("20000");
			Thread.sleep(6000);
			if(driver.findElement(By.xpath(UIMapProductSearch.webElmntFilterBreadBox)).isDisplayed())
				report.updateTestLog("Checking Category Results Page","Category Results page is displayed",Status.PASS);
			else
				report.updateTestLog("Checking Category Results Page","Category Results page is NOT displayed",Status.FAIL);
			break;
			}
			if(i==Count)
				report.updateTestLog("Verifying Refinements having more than 16 results","No refinement in this catgroup has more than 16 results",Status.FAIL);
			}
		    }
			else if(CatGroupName.equalsIgnoreCase("Activities"))
			{
				int Count = ps.countWebElement("//*[@id='left_rail_lci']/ul/li[2]/ul/li");
				if(Count>6)
					Count=Count-1;
				for(int i=1;i<=Count;i++)
				{
				String text = driver.findElement(By.xpath("//*[@id='left_rail_lci']/ul/li[2]/ul/li["+i+"]/a")).getText();
				String[] cnt1 = text.split("\\(");
				String refineCount1 = cnt1[1].substring(0,(cnt1.length)-1);
				int refinecount1 = Integer.parseInt(refineCount1);
				System.out.println(refinecount1);
				if(refinecount1>15)
				{
				ClickCustomize("xpath","//*[@id='left_rail_lci']/ul/li[2]/ul/li["+i+"]/a");
				selenium.waitForPageToLoad("20000");
				Thread.sleep(6000);
				if(driver.findElement(By.xpath(UIMapProductSearch.webElmntFilterBreadBox)).isDisplayed())
					report.updateTestLog("Checking Category Results Page","Category Results page is displayed",Status.PASS);
				else
					report.updateTestLog("Checking Category Results Page","Category Results page is NOT displayed",Status.FAIL);
				break;
				}
				if(i==Count)
					report.updateTestLog("Verifying Refinements having more than 16 results","No refinement in this catgroup has more than 16 results",Status.FAIL);
				}
			    }
			else if(CatGroupName.equalsIgnoreCase("Themes"))
			{
				int Count = ps.countWebElement("//*[@id='left_rail_lci']/ul/li[3]/ul/li");
				if(Count>6)
					Count=Count-1;
				for(int i=1;i<=Count;i++)
				{
				String text = driver.findElement(By.xpath("//*[@id='left_rail_lci']/ul/li[3]/ul/li["+i+"]/a")).getText();
				String[] cnt1 = text.split("\\(");
				String refineCount1 = cnt1[1].substring(0,(cnt1.length)-1);
				int refinecount1 = Integer.parseInt(refineCount1);
				System.out.println(refinecount1);
				if(refinecount1>15)
				{
				ClickCustomize("xpath","//*[@id='left_rail_lci']/ul/li[3]/ul/li["+i+"]/a");
				selenium.waitForPageToLoad("20000");
				Thread.sleep(6000);
				if(driver.findElement(By.xpath(UIMapProductSearch.webElmntFilterBreadBox)).isDisplayed())
					report.updateTestLog("Checking Category Results Page","Category Results page is displayed",Status.PASS);
				else
					report.updateTestLog("Checking Category Results Page","Category Results page is NOT displayed",Status.FAIL);
				break;
				}
				if(i==Count)
					report.updateTestLog("Verifying Refinements having more than 16 results","No refinement in this catgroup has more than 16 results",Status.FAIL);
				}
			    }
			else if(CatGroupName.equalsIgnoreCase("Seasons & Holidays"))
			{
				int Count = ps.countWebElement("//*[@id='left_rail_lci']/ul/li[4]/ul/li");
				if(Count>6)
					Count=Count-1;
				for(int i=1;i<=Count;i++)
				{
				String text = driver.findElement(By.xpath("//*[@id='left_rail_lci']/ul/li[4]/ul/li["+i+"]/a")).getText();
				String[] cnt1 = text.split("\\(");
				String refineCount1 = cnt1[1].substring(0,(cnt1.length)-1);
				int refinecount1 = Integer.parseInt(refineCount1);
				System.out.println(refinecount1);
				if(refinecount1>15)
				{
				ClickCustomize("xpath","//*[@id='left_rail_lci']/ul/li[4]/ul/li["+i+"]/a");
				selenium.waitForPageToLoad("20000");
				Thread.sleep(6000);
				if(driver.findElement(By.xpath(UIMapProductSearch.webElmntFilterBreadBox)).isDisplayed())
					report.updateTestLog("Checking Category Results Page","Category Results page is displayed",Status.PASS);
				else
					report.updateTestLog("Checking Category Results Page","Category Results page is NOT displayed",Status.FAIL);
				break;
				}
				if(i==Count)
					report.updateTestLog("Verifying Refinements having more than 16 results","No refinement in this catgroup has more than 16 results",Status.FAIL);
				}
			    }
			else if(CatGroupName.equalsIgnoreCase("Information Types"))
			{
				int Count = ps.countWebElement("//*[@id='left_rail_lci']/ul/li[5]/ul/li");
				if(Count>6)
					Count=Count-1;
				for(int i=1;i<=Count;i++)
				{
				String text = driver.findElement(By.xpath("//*[@id='left_rail_lci']/ul/li[5]/ul/li["+i+"]/a")).getText();
				String[] cnt1 = text.split("\\(");
				String refineCount1 = cnt1[1].substring(0,(cnt1.length)-1);
				int refinecount1 = Integer.parseInt(refineCount1);
				System.out.println(refinecount1);
				if(refinecount1>15)
				{
				ClickCustomize("xpath","//*[@id='left_rail_lci']/ul/li[5]/ul/li["+i+"]/a");
				selenium.waitForPageToLoad("20000");
				Thread.sleep(6000);
				if(driver.findElement(By.xpath(UIMapProductSearch.webElmntFilterBreadBox)).isDisplayed())
					report.updateTestLog("Checking Category Results Page","Category Results page is displayed",Status.PASS);
				else
					report.updateTestLog("Checking Category Results Page","Category Results page is NOT displayed",Status.FAIL);
				break;
				}
				if(i==Count)
					report.updateTestLog("Verifying Refinements having more than 16 results","No refinement in this catgroup has more than 16 results",Status.FAIL);
				}
			    }
			else if(CatGroupName.equalsIgnoreCase("Region"))
			{
				int Count = ps.countWebElement("//*[@id='left_rail_lci']/ul/li[6]/ul/li");
				if(Count>6)
					Count=Count-1;
				for(int i=1;i<=Count;i++)
				{
				String text = driver.findElement(By.xpath("//*[@id='left_rail_lci']/ul/li[6]/ul/li["+i+"]/a")).getText();
				String[] cnt1 = text.split("\\(");
				String refineCount1 = cnt1[1].substring(0,(cnt1.length)-1);
				int refinecount1 = Integer.parseInt(refineCount1);
				System.out.println(refinecount1);
				if(refinecount1>15)
				{
				ClickCustomize("xpath","//*[@id='left_rail_lci']/ul/li[6]/ul/li["+i+"]/a");
				selenium.waitForPageToLoad("20000");
				Thread.sleep(6000);
				if(driver.findElement(By.xpath(UIMapProductSearch.webElmntFilterBreadBox)).isDisplayed())
					report.updateTestLog("Checking Category Results Page","Category Results page is displayed",Status.PASS);
				else
					report.updateTestLog("Checking Category Results Page","Category Results page is NOT displayed",Status.FAIL);
				break;
				}
				if(i==Count)
					report.updateTestLog("Verifying Refinements having more than 16 results","No refinement in this catgroup has more than 16 results",Status.FAIL);
				}
			    }
			else if(CatGroupName.equalsIgnoreCase("See More From"))
			{
				int Count = ps.countWebElement("//*[@id='left_rail_lci']/ul/li[7]/ul/li");
				Count=Count-1;
				for(int i=1;i<=Count;i++)
				{
				String text = driver.findElement(By.xpath("//*[@id='left_rail_lci']/ul/li[7]/ul/li["+i+"]/a")).getText();
				String[] cnt1 = text.split("\\(");
				String refineCount1 = cnt1[1].substring(0,(cnt1.length)-1);
				int refinecount1 = Integer.parseInt(refineCount1);
				System.out.println(refinecount1);
				if(refinecount1>15)
				{
				ClickCustomize("xpath","//*[@id='left_rail_lci']/ul/li[7]/ul/li["+i+"]/a");
				selenium.waitForPageToLoad("20000");
				Thread.sleep(6000);
				if(driver.findElement(By.xpath(UIMapProductSearch.webElmntFilterBreadBox)).isDisplayed())
					report.updateTestLog("Checking Category Results Page","Category Results page is displayed",Status.PASS);
				else
					report.updateTestLog("Checking Category Results Page","Category Results page is NOT displayed",Status.FAIL);
				break;
				}
				if(i==Count)
					report.updateTestLog("Verifying Refinements having more than 16 results","No refinement in this catgroup has more than 16 results",Status.FAIL);
				}
			    }
		else
			report.updateTestLog("Verifying Left Rail in LCI Category page","Left Rail is not displayed in LCI Category page",Status.FAIL);
	    }
	}	
	public void verifyPaginationsInCatResultsPage() throws Exception
	{
		if(driver.findElement(By.xpath(UIMapProductSearch.webElmntTopActionBar)).isDisplayed())
		{
			report.updateTestLog("Verifying Top Action Bar in Category Results Page","Top Action Bar is displayed in Category Results Page",Status.PASS);
			//verifyPreviousNextButtons();
			//verifyGotoPage();
		}
		else
			report.updateTestLog("Verifying Top Action Bar in Category Results Page","Top Action Bar is NOT displayed in Category Results Page",Status.FAIL);
	}
	public void verifyNoPaginationsInCatResultsPage() throws Exception
	{
		ps.navigateToHomeArea();
		clickRefinementLessThan15InLCIcat();
		boolean Previousfield = driver.findElement(By.linkText(UIMapProductSearch.lnkPrevious)).isDisplayed();
		boolean Nextfield = driver.findElement(By.linkText(UIMapProductSearch.lnkNext)).isDisplayed();
		if(Previousfield && Nextfield)
			report.updateTestLog("Verifying Previous/Next pagination controls","Previous/Next pagination controls are displayed for less than or equal to 15 results",Status.FAIL);
		else
			report.updateTestLog("Verifying Previous/Next pagination controls","Previous/Next pagination controls are not displayed for less than or equal to 15 results",Status.PASS);
		boolean gotoButton = driver.findElement(By.xpath("//a[contains(text(),'Go')]")).isDisplayed();
		if(gotoButton)
			report.updateTestLog("Verifying Goto field","Goto field is displayed for less than or equal to 15 results",Status.FAIL);
		else
			report.updateTestLog("Verifying Goto field","Goto field is not displayed for less than or equal to 15 results",Status.PASS);
	}
    public void clickRefinementLessThan15InLCIcat() throws Exception
		{
			if(driver.findElement(By.xpath(UIMapProductSearch.lciLeftRail)).isDisplayed())
			{
				report.updateTestLog("Verifying Left Rail in LCI Category page","Left Rail is displayed in LCI Category page",Status.PASS);
				String CatGroupName = dataTable.getData("General_Data","CatGroupName1");
				if(CatGroupName.equalsIgnoreCase("Home Areas"))
				{
				int Count = ps.countWebElement("//*[@id='left_rail_lci']/ul/li[1]/ul/li");
				if(Count>6)
					Count=Count-1;
				for(int i=1;i<=Count;i++)
				{
				String text = driver.findElement(By.xpath("//*[@id='left_rail_lci']/ul/li[1]/ul/li["+i+"]/a")).getText();
				String[] cnt1 = text.split("\\(");
				String refineCount1 = cnt1[1].substring(0,(cnt1.length)-1);
				int refinecount1 = Integer.parseInt(refineCount1);
				System.out.println(refinecount1);
				if(refinecount1<=15)
				{
				ClickCustomize("xpath","//*[@id='left_rail_lci']/ul/li[1]/ul/li["+i+"]/a");
				selenium.waitForPageToLoad("20000");
				Thread.sleep(6000);
				if(driver.findElement(By.xpath(UIMapProductSearch.webElmntFilterBreadBox)).isDisplayed())
					report.updateTestLog("Checking Category Results Page","Category Results page is displayed",Status.PASS);
				else
					report.updateTestLog("Checking Category Results Page","Category Results page is NOT displayed",Status.FAIL);
				break;
				}
				if(i==Count)
					report.updateTestLog("Verifying Refinements having less than 15 results","No refinement in this catgroup has less than 15 results",Status.FAIL);
				}
			    }
				else if(CatGroupName.equalsIgnoreCase("Activities"))
				{
					int Count = ps.countWebElement("//*[@id='left_rail_lci']/ul/li[2]/ul/li");
					if(Count>6)
						Count=Count-1;
					for(int i=1;i<=Count;i++)
					{
					String text = driver.findElement(By.xpath("//*[@id='left_rail_lci']/ul/li[2]/ul/li["+i+"]/a")).getText();
					String[] cnt1 = text.split("\\(");
					String refineCount1 = cnt1[1].substring(0,(cnt1.length)-1);
					int refinecount1 = Integer.parseInt(refineCount1);
					System.out.println(refinecount1);
					if(refinecount1<=15)
					{
					ClickCustomize("xpath","//*[@id='left_rail_lci']/ul/li[2]/ul/li["+i+"]/a");
					selenium.waitForPageToLoad("20000");
					Thread.sleep(6000);
					if(driver.findElement(By.xpath(UIMapProductSearch.webElmntFilterBreadBox)).isDisplayed())
						report.updateTestLog("Checking Category Results Page","Category Results page is displayed",Status.PASS);
					else
						report.updateTestLog("Checking Category Results Page","Category Results page is NOT displayed",Status.FAIL);
					break;
					}
					if(i==Count)
						report.updateTestLog("Verifying Refinements having less than 15 results","No refinement in this catgroup has less than 15 results",Status.FAIL);
					}
				    }
				else if(CatGroupName.equalsIgnoreCase("Themes"))
				{
					int Count = ps.countWebElement("//*[@id='left_rail_lci']/ul/li[3]/ul/li");
					if(Count>6)
						Count=Count-1;
					for(int i=1;i<=Count;i++)
					{
					String text = driver.findElement(By.xpath("//*[@id='left_rail_lci']/ul/li[3]/ul/li["+i+"]/a")).getText();
					String[] cnt1 = text.split("\\(");
					String refineCount1 = cnt1[1].substring(0,(cnt1.length)-1);
					int refinecount1 = Integer.parseInt(refineCount1);
					System.out.println(refinecount1);
					if(refinecount1<=15)
					{
					ClickCustomize("xpath","//*[@id='left_rail_lci']/ul/li[3]/ul/li["+i+"]/a");
					selenium.waitForPageToLoad("20000");
					Thread.sleep(6000);
					if(driver.findElement(By.xpath(UIMapProductSearch.webElmntFilterBreadBox)).isDisplayed())
						report.updateTestLog("Checking Category Results Page","Category Results page is displayed",Status.PASS);
					else
						report.updateTestLog("Checking Category Results Page","Category Results page is NOT displayed",Status.FAIL);
					break;
					}
					if(i==Count)
						report.updateTestLog("Verifying Refinements having less than 15 results","No refinement in this catgroup has less than 15 results",Status.FAIL);
					}
				    }
				else if(CatGroupName.equalsIgnoreCase("Seasons & Holidays"))
				{
					int Count = ps.countWebElement("//*[@id='left_rail_lci']/ul/li[4]/ul/li");
					if(Count>6)
						Count=Count-1;
					for(int i=1;i<=Count;i++)
					{
					String text = driver.findElement(By.xpath("//*[@id='left_rail_lci']/ul/li[4]/ul/li["+i+"]/a")).getText();
					String[] cnt1 = text.split("\\(");
					String refineCount1 = cnt1[1].substring(0,(cnt1.length)-1);
					int refinecount1 = Integer.parseInt(refineCount1);
					System.out.println(refinecount1);
					if(refinecount1<=15)
					{
					ClickCustomize("xpath","//*[@id='left_rail_lci']/ul/li[4]/ul/li["+i+"]/a");
					selenium.waitForPageToLoad("20000");
					Thread.sleep(6000);
					if(driver.findElement(By.xpath(UIMapProductSearch.webElmntFilterBreadBox)).isDisplayed())
						report.updateTestLog("Checking Category Results Page","Category Results page is displayed",Status.PASS);
					else
						report.updateTestLog("Checking Category Results Page","Category Results page is NOT displayed",Status.FAIL);
					break;
					}
					if(i==Count)
						report.updateTestLog("Verifying Refinements having less than 15 results","No refinement in this catgroup has less than 15 results",Status.FAIL);
					}
				    }
				else if(CatGroupName.equalsIgnoreCase("Information Types"))
				{
					int Count = ps.countWebElement("//*[@id='left_rail_lci']/ul/li[5]/ul/li");
					if(Count>6)
						Count=Count-1;
					for(int i=1;i<=Count;i++)
					{
					String text = driver.findElement(By.xpath("//*[@id='left_rail_lci']/ul/li[5]/ul/li["+i+"]/a")).getText();
					String[] cnt1 = text.split("\\(");
					String refineCount1 = cnt1[1].substring(0,(cnt1.length)-1);
					int refinecount1 = Integer.parseInt(refineCount1);
					System.out.println(refinecount1);
					if(refinecount1<=15)
					{
					ClickCustomize("xpath","//*[@id='left_rail_lci']/ul/li[5]/ul/li["+i+"]/a");
					selenium.waitForPageToLoad("20000");
					Thread.sleep(6000);
					if(driver.findElement(By.xpath(UIMapProductSearch.webElmntFilterBreadBox)).isDisplayed())
						report.updateTestLog("Checking Category Results Page","Category Results page is displayed",Status.PASS);
					else
						report.updateTestLog("Checking Category Results Page","Category Results page is NOT displayed",Status.FAIL);
					break;
					}
					if(i==Count)
						report.updateTestLog("Verifying Refinements having less than 15 results","No refinement in this catgroup has less than 15 results",Status.FAIL);
					}
				    }
				else if(CatGroupName.equalsIgnoreCase("Region"))
				{
					int Count = ps.countWebElement("//*[@id='left_rail_lci']/ul/li[6]/ul/li");
					if(Count>6)
						Count=Count-1;
					for(int i=1;i<=Count;i++)
					{
					String text = driver.findElement(By.xpath("//*[@id='left_rail_lci']/ul/li[6]/ul/li["+i+"]/a")).getText();
					String[] cnt1 = text.split("\\(");
					String refineCount1 = cnt1[1].substring(0,(cnt1.length)-1);
					int refinecount1 = Integer.parseInt(refineCount1);
					System.out.println(refinecount1);
					if(refinecount1<=15)
					{
					ClickCustomize("xpath","//*[@id='left_rail_lci']/ul/li[6]/ul/li["+i+"]/a");
					selenium.waitForPageToLoad("20000");
					Thread.sleep(6000);
					if(driver.findElement(By.xpath(UIMapProductSearch.webElmntFilterBreadBox)).isDisplayed())
						report.updateTestLog("Checking Category Results Page","Category Results page is displayed",Status.PASS);
					else
						report.updateTestLog("Checking Category Results Page","Category Results page is NOT displayed",Status.FAIL);
					break;
					}
					if(i==Count)
						report.updateTestLog("Verifying Refinements having less than 15 results","No refinement in this catgroup has less than 15 results",Status.FAIL);
					}
				    }
				else if(CatGroupName.equalsIgnoreCase("See More From"))
				{
					int Count = ps.countWebElement("//*[@id='left_rail_lci']/ul/li[7]/ul/li");
					Count=Count-1;
					for(int i=1;i<=Count;i++)
					{
					String text = driver.findElement(By.xpath("//*[@id='left_rail_lci']/ul/li[7]/ul/li["+i+"]/a")).getText();
					String[] cnt1 = text.split("\\(");
					String refineCount1 = cnt1[1].substring(0,(cnt1.length)-1);
					int refinecount1 = Integer.parseInt(refineCount1);
					System.out.println(refinecount1);
					if(refinecount1<=15)
					{
					ClickCustomize("xpath","//*[@id='left_rail_lci']/ul/li[7]/ul/li["+i+"]/a");
					selenium.waitForPageToLoad("20000");
					Thread.sleep(6000);
					if(driver.findElement(By.xpath(UIMapProductSearch.webElmntFilterBreadBox)).isDisplayed())
						report.updateTestLog("Checking Category Results Page","Category Results page is displayed",Status.PASS);
					else
						report.updateTestLog("Checking Category Results Page","Category Results page is NOT displayed",Status.FAIL);
					break;
					}
					if(i==Count)
						report.updateTestLog("Verifying Refinements having less than 15 results","No refinement in this catgroup has less than 15 results",Status.FAIL);
					}
				    }
			else
				report.updateTestLog("Verifying Left Rail in LCI Category page","Left Rail is not displayed in LCI Category page",Status.FAIL);
		    }
		}
    
    public void enterQtyInLumberCat() throws Exception {
		new Select(driver.findElement(By.id("gridSelect")))
				.selectByVisibleText(dataTable.getData("General_Data",
						"Lumber Type"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='text'])[6]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys(
				dataTable.getData("General_Data", "Qty"));
		Thread.sleep(2000);
		String qty = dataTable.getData("General_Data", "Qty");
		int lumberQty = Integer.parseInt(qty);
		String Price = driver.findElement(By.xpath("//*[@id='gridDetail']/table/tbody/tr[1]/td[2]/span")).getText();
		float lumberprice = Float.parseFloat(Price);
		String subtotal = driver.findElement(By.xpath("//*[@id='subTotal']")).getText();
		float subtotalPrice = Float.parseFloat(subtotal);
		float actualPrice1 = (float)(lumberQty*lumberprice);
		actualPrice1 = Float.parseFloat(new DecimalFormat("##.##").format(actualPrice1));
		
		if(subtotalPrice == actualPrice1)
			report.updateTestLog("Verifying Subtotal after tabing from qty field","Subtotal calculated correctly",Status.PASS);
		else
			report.updateTestLog("Verifying Subtotal after tabing from qty field","Subtotal Not calculated correctly",Status.FAIL);
		//entering qty in one more field	
		driver.findElement(By.xpath("(//input[@type='text'])[7]")).clear();
		driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys(
				dataTable.getData("General_Data", "Qty"));
		Thread.sleep(2000);
		String qty1 = dataTable.getData("General_Data", "Qty");
		int lumberQty1 = Integer.parseInt(qty1);
		String Price1 = driver.findElement(By.xpath("//*[@id='gridDetail']/table/tbody/tr[1]/td[3]/span")).getText();
		float lumberprice1 = Float.parseFloat(Price1);
		String subtotal1 = driver.findElement(By.xpath("//*[@id='subTotal']")).getText();
		float subtotalPrice1 = Float.parseFloat(subtotal1);
		float actualPrice = ((float)lumberQty*lumberprice) + ((float)lumberQty1*lumberprice1);
		actualPrice = Float.parseFloat(new DecimalFormat("##.##").format(actualPrice));
		System.out.println("Subtotal"+subtotalPrice1);
		System.out.println("Actual Price"+actualPrice);
		if(subtotalPrice1 == actualPrice)
			report.updateTestLog("Verifying Subtotal after tabing from second qty field","Subtotal calculated correctly",Status.PASS);
		else
			report.updateTestLog("Verifying Subtotal after tabing from second qty field","Subtotal Not calculated correctly",Status.FAIL);
		
	}
    public void validateEPPinNotification() throws Exception
    {
    	String notificationEPP = driver.findElement(By.xpath("//*[@id='productAddToCart']/div[1]/div/div[3]")).getText();
    	String pdEPP = dataTable.getData("General_Data", "EPPName");
    	if(notificationEPP.contains(pdEPP))
    		report.updateTestLog("Verifying selected EPP from PD in Notification window","Selected EPP is displayed",Status.PASS);
    	else
    		report.updateTestLog("Verifying selected EPP from PD in Notification window","Selected EPP is NOT displayed",Status.FAIL);
    }
    public void validateRTFcountinNotification() throws Exception
    {
    	int RTFcount = ps.countWebElement("//*[@id='productAddToCart']/div[2]/ul/li");
    	System.out.println("RTFcount"+RTFcount);
    	if(RTFcount>3)
    		report.updateTestLog("Verifying no. of RTF items in Notification window","More than 3 RTF items displayed",Status.FAIL);
    	else
    		report.updateTestLog("Verifying no. of RTF items in Notification window","Less than 3 RTF items displayed",Status.PASS);
    }
    public void checkoutFromNotification() throws Exception
    {
   	 driver.findElement(By.xpath(UIMapMyLowes.btnCheckOut)).click();
   		selenium.waitForPageToLoad("20000");
   		Thread.sleep(2000);
    }
    public void validateSelectedEPPinCart() throws Exception
	{
		try{
		String varChecked=driver.findElement(By.xpath("//div[2]/label[1]/input")).getAttribute("checked");
		System.out.println("Checked:"+varChecked);
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
    public void verifyShowMeFacets() throws Exception
    {
    	int totalFacets = ps.countWebElement("//*[@id='left_rail_pl']/ul[1]/li");
    	if(totalFacets==2)
    	{
    		if(driver.findElement(By.xpath("//*[@id='left_rail_pl']/ul[1]/li[1]")).getText().contains("Products"))
    			report.updateTestLog("Verifying Products facet","Products facet is displayed",Status.PASS);
    		else
    			report.updateTestLog("Verifying Products facet","Products facet is NOT displayed",Status.FAIL);
    		if(driver.findElement(By.xpath("//*[@id='left_rail_pl']/ul[1]/li[2]")).getText().contains("Ideas & How-Tos"))
    			report.updateTestLog("Verifying Ideas & How-Tos facet","Ideas & How-Tos facet is displayed",Status.PASS);
    		else
    			report.updateTestLog("Verifying Ideas & How-Tos facet","Ideas & How-Tos facet is NOT displayed",Status.FAIL);
    	}
    	else
    		report.updateTestLog("Verifying no. of facets in Show Me toggle",totalFacets+" facets are displayed instead of 2 facets",Status.FAIL);
    }
    public void verifyShowMeInNPC() throws Exception
    {
  	  if(driver.findElement(By.xpath("//*[@id='left_rail_lci']/h4[1]")).isDisplayed())
  		  report.updateTestLog("Verifying ShowMe in NPC List page","ShowMe is displayed",Status.PASS);
  	  else
  		  report.updateTestLog("Verifying ShowMe in NPC List page","ShowMe is not displayed",Status.FAIL);
    }
    public void verifyShowMeFacetsInNPC() throws Exception
    {
    	int totalFacets = ps.countWebElement("//*[@id='left_rail_lci']/ul[1]/li");
    	if(totalFacets==2)
    	{
    		if(driver.findElement(By.xpath("//*[@id='left_rail_lci']/ul[1]/li[1]")).getText().contains("Products"))
    			report.updateTestLog("Verifying Products facet in NPC page","Products facet is displayed in NPC page",Status.PASS);
    		else
    			report.updateTestLog("Verifying Products facet in NPC page","Products facet is NOT displayed in NPC page",Status.FAIL);
    		if(driver.findElement(By.xpath("//*[@id='left_rail_lci']/ul[1]/li[2]")).getText().contains("Ideas & How-Tos"))
    			report.updateTestLog("Verifying Ideas & How-Tos facet in NPC page","Ideas & How-Tos facet is displayed in NPC page",Status.PASS);
    		else
    			report.updateTestLog("Verifying Ideas & How-Tos facet in NPC page","Ideas & How-Tos facet is NOT displayed in NPC page",Status.FAIL);
    	}
    	else
    		report.updateTestLog("Verifying no. of facets in Show Me toggle in NPC page",totalFacets+" facets are displayed instead of 2 facets in NPC page",Status.FAIL);
    }
    public void toggleToProductsResults() throws Exception
    {
  	  ClickCustomize("partialLinkText","Products");
  	  selenium.waitForPageToLoad("200000");
  	  Thread.sleep(6000);
  	  if(driver.findElement(By.id("breadcrumbs")).isDisplayed())
  		  report.updateTestLog("Verifying Products page","Toggled to products results page",Status.PASS);
  	  else
  		report.updateTestLog("Verifying Products page","NOT Toggled to products results page",Status.FAIL);
    }
    public void verifyCountBeforeToggle() throws Exception
    {
    	String products = driver.findElement(By.xpath("//*[@id='left_rail_pl']/ul[1]/li[1]/a")).getText();
    	String a[] = products.split("\\(");
    	String b = a[1].replace(")","");
    	System.out.println(b);
    	//int prodCount = Integer.parseInt(b);
    	//System.out.println("products count"+prodCount);
    	dataTable.putData("General_Data","ProductsCount",b);
    	String ideasHowTos = driver.findElement(By.xpath("//*[@id='left_rail_pl']/ul[1]/li[2]/a")).getText();
    	String c[] = ideasHowTos.split("\\(");
    	String d = c[1].replace(")","");
    	System.out.println(d);
    	//int ideasCount = Integer.parseInt(d);
    	//System.out.println("products count"+ideasCount);
    	dataTable.putData("General_Data","IdeasCount",d);
    	
    }
    public void verifyCountAfterToggle() throws Exception
    {
    	String products = driver.findElement(By.xpath("//*[@id='left_rail_lci']/ul[1]/li[1]/a")).getText();
    	String a[] = products.split("\\(");
    	String b = a[1].replace(")","");
    	System.out.println(b);
    	//int prodCount = Integer.parseInt(b);
    	//System.out.println("products count"+prodCount);
    	String prodCount = dataTable.getData("General_Data","ProductsCount");
    	System.out.println("products count"+prodCount);
    	if(prodCount.equals(b))
    		report.updateTestLog("Verifying Products count after toggle","Products count is same before and after toggle",Status.PASS);
    	else
    		report.updateTestLog("Verifying Products count after toggle","Products count is not same before and after toggle",Status.FAIL);
    	String ideasHowTos = driver.findElement(By.xpath("//*[@id='left_rail_lci']/ul[1]/li[2]/a")).getText();
    	String c[] = ideasHowTos.split("\\(");
    	String d = c[1].replace(")","");
    	System.out.println(d);
    	//int ideasCount = Integer.parseInt(d);
    	//System.out.println("products count"+ideasCount);
    	String ideasCount = dataTable.getData("General_Data","IdeasCount");
    	if(ideasCount.equals(d))
    		report.updateTestLog("Verifying Ideas & How-Tos count after toggle","Ideas & How-Tos count is same before and after toggle",Status.PASS);
    	else
    		report.updateTestLog("Verifying Ideas & How-Tos count after toggle","Ideas & How-Tos count is not same before and after toggle",Status.FAIL);
    }
    public void openSiteDirectoryPage() throws Exception
    {
    	String currentURL = driver.getCurrentUrl();
    	String SiteDirectoryURL = currentURL+"/All-Departments/site-directory";
    	driver.get(SiteDirectoryURL);
    	selenium.waitForPageToLoad("20000");
    	Thread.sleep(6000);
    	String getLowesHomePgTitle=selenium.getTitle();
		System.out.println("Lowes HomePage Title is :"+getLowesHomePgTitle);
		if(getLowesHomePgTitle.contains("Lowes.com: All Departments"))
		{
			report.updateTestLog("Verifying Launch of Site Directory Page", "Site Directory Page Launched Successfully", Status.PASS);
		}
		else
		{
			report.updateTestLog("Verifying Launch of Site Directory Page", "Failed to Launch Site Directory Page", Status.FAIL);
		}
    }
    
    public void verifySiteDirectoryPage() throws Exception
    {
    	String tagName = driver.findElement(By.xpath("//*[@id='LowesSiteDirectory']/div[1]/ul[1]/li/a/h2")).getTagName();
        if(tagName.equals("h2"))
        	report.updateTestLog("Verifying Super Categories","Super Categories displayed with the larger font",Status.PASS);
        else
        	report.updateTestLog("Verifying Super Categories","Super Categories Not displayed with the larger font",Status.FAIL);
        int numberOfColumns = ps.countWebElement("//*[@id='content-area-no-nav-widest']/div/div");
        if(numberOfColumns==4)
        	report.updateTestLog("Verifying the number of columns","4 Columns are displayed",Status.PASS);
        else
        	report.updateTestLog("Verifying the number of columns",numberOfColumns+" Columns are displayed",Status.FAIL);
        for(int i=1;i<=4;i++)
        {
        	if(driver.findElement(By.xpath("//*[@id='LowesSiteDirectory']/div["+i+"]/ul[1]/li/a/h2")).isDisplayed())
        		report.updateTestLog("Verifying Column "+i,"Column "+i+" started with super category",Status.PASS);
        	else
        		report.updateTestLog("Verifying Column "+i,"Column "+i+" not started with super category",Status.FAIL);
        }
        if(driver.findElement(By.xpath("//*[@id='LowesSiteDirectory']/div[1]/ul[1]/ul/li[1]/a")).isDisplayed())
        	report.updateTestLog("Verifying one of the second level category","second level category is displyed",Status.PASS);
        else
        	report.updateTestLog("Verifying one of the second level category","second level category is NOT displyed",Status.FAIL);
        String superCatName = driver.findElement(By.xpath("//*[@id='LowesSiteDirectory']/div[1]/ul[1]/li/a/h2")).getText();
        System.out.println("superCatName"+superCatName);
        driver.findElement(By.xpath("//*[@id='LowesSiteDirectory']/div[1]/ul[1]/li/a/h2")).click();
        selenium.waitForPageToLoad("20000");
    	Thread.sleep(6000);
        System.out.println(driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1/span")).getText());
        if(driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1/span")).getText().equals(superCatName))
        	report.updateTestLog("Verifing Super Category page","Super Category page is displayed",Status.PASS);
        else
        	report.updateTestLog("Verifing Super Category page","Super Category page is Not displayed",Status.FAIL);
        driver.navigate().back();
        selenium.waitForPageToLoad("20000");
    	Thread.sleep(6000);
    	String subCatName = driver.findElement(By.xpath("//*[@id='LowesSiteDirectory']/div[1]/ul[1]/ul/li[1]/a")).getText();
        System.out.println("subCatName"+subCatName);
    	driver.findElement(By.xpath("//*[@id='LowesSiteDirectory']/div[1]/ul[1]/ul/li[1]/a")).click();
    	selenium.waitForPageToLoad("20000");
    	Thread.sleep(6000);
    	System.out.println(driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1/span")).getText());
    	if(driver.findElement(By.xpath("//*[@id='content-area-prod-list']/h1/span")).getText().equals(subCatName))
         	report.updateTestLog("Verifing Sub Category page","Sub Category page is displayed",Status.PASS);
        else
         	report.updateTestLog("Verifing Sub Category page","Sub Category page is Not displayed",Status.FAIL);
    	ps.clickOnFirstItemInListPage();
    }
    
    public void verifySeeAllHowTos() throws Exception
    {
    	int totalProjects = ps.countWebElement("//*[@id='lci-landing-content']/div[4]/div");
		totalProjects = totalProjects-1;
		if(totalProjects<=4)
			  totalProjects = totalProjects-1;
		  else if(totalProjects<=8)
			  totalProjects = totalProjects-2;
		  else if(totalProjects<=12)
			  totalProjects = totalProjects-3;
		  else if(totalProjects<=16)
			  totalProjects = totalProjects-4;
		System.out.println("totalProjects"+totalProjects);
		if((totalProjects <=6))
			report.updateTestLog("Verifying See All link","See All link is displayed",Status.PASS);
		else
			report.updateTestLog("Verifying See All link","See All link is Not displayed",Status.FAIL);	
    }
    public void verifySeeAllIdeas() throws Exception
    {
      int totalProjects = ps.countWebElement("//*[@id='lci-landing-content']/div[2]/div");
	  totalProjects = totalProjects-1;
	  if(totalProjects<=4)
		  totalProjects = totalProjects-1;
	  else if(totalProjects<=8)
		  totalProjects = totalProjects-2;
	  else if(totalProjects<=12)
		  totalProjects = totalProjects-3;
	  else if(totalProjects<=16)
		  totalProjects = totalProjects-4;
	  System.out.println("totalProjects"+totalProjects);
	  if(totalProjects <=6)
			  report.updateTestLog("Verifying See All Ideas link","See All Ideas link is displayed",Status.PASS);
		else
			report.updateTestLog("Verifying See All Ideas link","See All Ideas link is Not displayed",Status.FAIL);
    }
    public void verifyFooterRedesign() throws Exception
    {
    	if(driver.findElement(By.xpath("//*[@id='footer-spotlight']/div[4]/h5")).getText().equals("Services"))
    	{
    		if(driver.findElement(By.xpath("//*[@id='footer-spotlight']/div[4]/ul/li[1]/a")).isDisplayed())
    		{
    			report.updateTestLog("Verifying Credit Card Services", "Credit Card Services is displayed",Status.PASS);
    			ClickCustomize("xpath","//*[@id='footer-spotlight']/div[4]/ul/li[1]/a");
    			selenium.waitForPageToLoad("20000");
    	    	Thread.sleep(6000);
    	    	String pageTitle = selenium.getTitle();
    	    	if(pageTitle.equals("Lowe's Credit Center"))
    	    	{
    	    		report.updateTestLog("Verifying Credit Card Services page","Credit Card Services page displayed",Status.PASS);
    	    		driver.navigate().back();
    	    		selenium.waitForPageToLoad("20000");
        	    	Thread.sleep(6000);
    	    	}
    	    	else
    	    		report.updateTestLog("Verifying Credit Card Services page","Credit Card Services page NOT displayed",Status.FAIL);
    		}
    		else
    			report.updateTestLog("Verifying Credit Card Services", "Credit Card Services is not displayed",Status.FAIL);
    		if(driver.findElement(By.xpath("//*[@id='footer-spotlight']/div[4]/ul/li[3]/a")).isDisplayed())
    		{
    			report.updateTestLog("Verifying GM Business Choice Services", "GM Business Choice Services is displayed",Status.PASS);
    			ClickCustomize("xpath","//*[@id='footer-spotlight']/div[4]/ul/li[3]/a");
    			selenium.waitForPageToLoad("200000");
    	    	Thread.sleep(6000);
    	    	String pageTitle = selenium.getTitle();
    	    	if(pageTitle.equals("Business Choice | Incentives for Small Business/Commercial Customers | GM Fleet"))
    	    	{
    	    		report.updateTestLog("Verifying GM Business Choice Services page","GM Business Choice Services page displayed",Status.PASS);
    	    		driver.navigate().back();
    	    		selenium.waitForPageToLoad("20000");
        	    	Thread.sleep(6000);
    	    	}
    	    	else
    	    		report.updateTestLog("Verifying GM Business Choice Services page","GM Business Choice Services page NOT displayed",Status.FAIL);
    		}
    		else
    			report.updateTestLog("Verifying GM Business Choice Services", "GM Business Choice Services is not displayed",Status.FAIL);
    	}
    	else
    		report.updateTestLog("Verifying Services in footer","Services is not displayed",Status.FAIL);
    	
    	ClickCustomize("id","footer-safe-shop");
		Thread.sleep(6000);
		if(selenium.isTextPresent("Lowe's Safe Shopping Pledge"))
		{
			report.updateTestLog("Verifying Layer of Lowes Safe shopping pledge","Layer is displayed",Status.PASS);
		    driver.navigate().refresh();
		    selenium.waitForPageToLoad("20000");
	    	Thread.sleep(6000);
		}
		else
		{
			report.updateTestLog("Verifying Layer of Lowes Safe shopping pledge","Layer is Not displayed",Status.FAIL);
			driver.navigate().refresh();
			selenium.waitForPageToLoad("20000");
	    	Thread.sleep(6000);
		}
		
		ClickCustomize("xpath","//*[@id='cm_email_trigger']/span[2]");
		Thread.sleep(5000);
		if(driver.findElement(By.name("email")).isDisplayed())
		{
			report.updateTestLog("Verifying Layer of Get Exclusive Email Alerts","Get Exclusive Email Alerts Layer is displayed",Status.PASS);
		    driver.navigate().refresh();
		    selenium.waitForPageToLoad("20000");
	    	Thread.sleep(6000);
		}
		else
		{
			report.updateTestLog("Verifying Layer of Get Exclusive Email Alerts","Get Exclusive Email Alerts Layer is Not displayed",Status.FAIL);
			driver.navigate().refresh();
			selenium.waitForPageToLoad("20000");
	    	Thread.sleep(6000);
		}
		if(driver.findElement(By.xpath("//*[@id='footer-spotlight']/div[5]/div[1]/h6/span[2]")).isDisplayed())
			report.updateTestLog("verifying NeedHelp Section","NeedHelp Section is displayed",Status.PASS);
		else
			report.updateTestLog("verifying NeedHelp Section","NeedHelp Section is NOT displayed",Status.FAIL);
		if(driver.findElement(By.xpath("//*[@id='footer-spotlight']/div[5]/div[3]/h6")).isDisplayed())
		{
			ClickCustomize("xpath","//*[@id='footer-spotlight']/div[5]/div[3]/h6/a/span[1]");
			selenium.waitForPageToLoad("20000");
	    	Thread.sleep(6000);
			String pageTitle = selenium.getTitle();
    	if(pageTitle.equals("Lowe's Mobile"))
    	{
    		report.updateTestLog("Verifying Mobile link","Mobile link corresponding page is displayed",Status.PASS);
    		driver.navigate().back();
    		selenium.waitForPageToLoad("20000");
	    	Thread.sleep(6000);
    	}
    	else
    		report.updateTestLog("Verifying Mobile link","Mobile link corresponding page is Not displayed",Status.FAIL);
		}
		
		String fbHref = driver.findElement(By.xpath("//*[@id='social-nav']/li[2]/a")).getAttribute("href");
		if(fbHref.contains("facebook.com"))
			report.updateTestLog("Verifying Facebook link","Facebook link is correct",Status.PASS);
		else
			report.updateTestLog("Verifying Facebook link","Facebook link is not correct",Status.FAIL);
		String TwitterHref = driver.findElement(By.xpath("//*[@id='social-nav']/li[3]/a")).getAttribute("href");
		if(TwitterHref.contains("twitter.com"))
			report.updateTestLog("Verifying Twitter link","Twitter link is correct",Status.PASS);
		else
			report.updateTestLog("Verifying Twitter link","Twitter link is not correct",Status.FAIL);
    }
    
    public void verifyBuyThePair() throws Exception
    {
    	if(driver.findElement(By.id("buyPair")).isDisplayed() && driver.findElement(By.xpath("//*[@id='buyPair']/h2")).getText().equals("Buy the Pair"))
    		report.updateTestLog("Verifying Buy The Pair Section","Buy The Pair section is displayed",Status.PASS);
    	else
    		report.updateTestLog("Verifying Buy The Pair Section","Buy The Pair section is NOT displayed",Status.FAIL);
    }
    public void verifyNoBuyThePair() throws Exception
    {
    	if(driver.findElement(By.xpath("//div[2]/div[3]/h2")).isDisplayed() && driver.findElement(By.xpath("//div[2]/div[3]/h2")).getText().equals("Related Items"))
    		report.updateTestLog("Verifying Buy The Pair Section","Buy The Pair section is NOT displayed",Status.PASS);
    	else
    		report.updateTestLog("Verifying Buy The Pair Section","Buy The Pair section is displayed",Status.FAIL);	
    }
    
    public void verifyZipLayerInListView() throws Exception
    {
    	String zipClass = driver.findElement(By.xpath(UIMapProductSearch.webElmntZipLayerInList)).getAttribute("class");
    	System.out.println(zipClass);
    	if(zipClass.equals("zipIn"))
    		report.updateTestLog("Verifying ZipIn Layer","ZipIn Layer is displayed",Status.PASS);
    	else
    		report.updateTestLog("Verifying ZipIn Layer","ZipIn Layer is NOT displayed",Status.FAIL);
    }
    public void verifyZipLayerInGridView() throws Exception
    {
    	driver.findElement(By.className(UIMapProductSearch.webElmntGridView)).click();
    	Thread.sleep(5000);
    	String zipClass = driver.findElement(By.xpath(UIMapProductSearch.webElmntZipLayerInList)).getAttribute("class");
    	System.out.println(zipClass);
    	if(zipClass.equals("zipIn"))
    		report.updateTestLog("Verifying ZipIn Layer in Grid view","ZipIn Layer is displayed in Grid view",Status.PASS);
    	else
    		report.updateTestLog("Verifying ZipIn Layer in Grid view","ZipIn Layer is NOT displayed in Grid view",Status.FAIL);
    }
    public void verifyZipLayerInPD() throws Exception
    {
    	ps.clickOnFirstItemInListPage();
    	String zipClass = driver.findElement(By.xpath("//*[@id='priceAvailability']/div")).getAttribute("class");
    	System.out.println(zipClass);
    	if(zipClass.contains("zipIn"))
    		report.updateTestLog("Verifying ZipIn Layer in PD page","ZipIn Layer is displayed in PD page",Status.PASS);
    	else
    		report.updateTestLog("Verifying ZipIn Layer in PD page","ZipIn Layer is NOT displayed in PD page",Status.FAIL);	
    }
    public void backToPreviousPage() throws Exception
    {
    	driver.navigate().back();
    	selenium.waitForPageToLoad("200000");
    	Thread.sleep(6000);
    }
    public void verifyZipLayerInQuickView() throws Exception
    {
    	ClickCustomize("linkText","QuickView");
    	Thread.sleep(6000);
    	String zipClass = driver.findElement(By.xpath("//*[@id='descCont']/div[3]")).getAttribute("class");
    	System.out.println(zipClass);
    	if(zipClass.contains("zipIn"))
    		report.updateTestLog("Verifying ZipIn Layer in Quick view","ZipIn Layer is displayed in Quick view",Status.PASS);
    	else
    		report.updateTestLog("Verifying ZipIn Layer in Quick view","ZipIn Layer is NOT displayed in Quick view",Status.FAIL);	
        driver.navigate().refresh();
        selenium.waitForPageToLoad("20000");
        Thread.sleep(6000);
    }
    public void verifyZipLayerInComparePage() throws Exception
    {
    	ClickCustomize("xpath","//li[2]/div/div/div/label");
    	Thread.sleep(6000);
    	ClickCustomize("xpath","//li[3]/div/div/div/label");
    	Thread.sleep(6000);
    	ClickCustomize("linkText","Compare");
    	selenium.waitForPageToLoad("200000");
    	Thread.sleep(6000);
    	String zipClass = driver.findElement(By.xpath("//*[@id='header_container']/div[1]/div/p[1]/div")).getAttribute("class");
    	System.out.println(zipClass);
    	if(zipClass.contains("zipIn"))
    		report.updateTestLog("Verifying ZipIn Layer in Compare Assistance Page","ZipIn Layer is displayed in Compare Assistance Page",Status.PASS);
    	else
    		report.updateTestLog("Verifying ZipIn Layer in Compare Assistance Page","ZipIn Layer is NOT displayed in Compare Assistance Page",Status.FAIL);	
    }

}
