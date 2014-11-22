package com.lowes.qa.selenium.support;

import org.openqa.selenium.WebDriver;

/**
 * Wrapper class for common framework objects, to be used across the entire test
 * case and dependent libraries
 * 
 * @author Cognizant
 * @version 3.0
 * @since October 2011
 */
public class ScriptHelper {
	private final DataTable dataTable;
	private final SeleniumReport report;
	private final WebDriver driver;

	/**
	 * Constructor to initialize all the objects wrapped by the
	 * {@link ScriptHelper} class
	 * 
	 * @param dataTable
	 *            The {@link DataTable} object
	 * @param report
	 *            The {@link SeleniumReport} object
	 * @param driver
	 *            The {@link WebDriver} object
	 */
	public ScriptHelper(DataTable dataTable, SeleniumReport report,
			WebDriver driver) {
		this.dataTable = dataTable;
		this.report = report;
		this.driver = driver;
	}

	/**
	 * Function to get the {@link DataTable} object of the {@link ScriptHelper}
	 * class
	 * 
	 * @return The {@link DataTable} object
	 */
	public DataTable getDataTable() {
		return dataTable;
	}

	/**
	 * Function to get the {@link SeleniumReport} object of the
	 * {@link ScriptHelper} class
	 * 
	 * @return The {@link SeleniumReport} object
	 */
	public SeleniumReport getReport() {
		return report;
	}

	/**
	 * Function to get the {@link WebDriver} object of the {@link ScriptHelper}
	 * class
	 * 
	 * @return The {@link WebDriver} object
	 */
	public WebDriver getDriver() {
		return driver;
	}
}