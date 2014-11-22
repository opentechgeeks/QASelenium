package com.lowes.qa.selenium.support;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import com.cognizant.framework.FrameworkException;
import com.cognizant.framework.ReportSettings;
import com.cognizant.framework.ReportTheme;
import com.cognizant.framework.ReportThemeFactory;
import com.cognizant.framework.ReportThemeFactory.Theme;
import com.cognizant.framework.Settings;
import com.cognizant.framework.Status;
import com.cognizant.framework.Util;

/**
 * Driver script class which encapsulates the core logic of the CRAFT framework
 * 
 * @author Cognizant
 * @author Matthew DeTullio
 */
public class DriverScript {
	private static final String RUNTIME_TABLES_DIR = "target/runtime-datatables";

	private WebDriver webDriver;

	private DataTable dataTable;

	private String scenario;

	private String currentTestCase;
	private int currentTestIteration;
	private int currentTestSubIteration;
	private int currentTestEndIteration;

	private List<String> businessFlowData;

	private Date startTime;
	private Date endTime;

	private String reportPath;
	private SeleniumReport report;
	private ScriptHelper scriptHelper;

	/**
	 * Constructor to initialize the DriverScript
	 * 
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public DriverScript(String scenario) throws IOException, SAXException,
			ParserConfigurationException {
		this.scenario = scenario;
		startTime = Util.getCurrentTime();
		initializeDatatable();
	}

	public void setCurrentTestCase(String testCase) {
		currentTestCase = testCase;
		dataTable.setCurrentRow(currentTestCase, 0, 0);
	}

	public void setCurrentTestCaseDescription(String testCaseDescription) {
		// Currently unused
	}

	/**
	 * Function to execute the given test case
	 */
	public void driveTestExecution() {
		initializeTestReport();
		initializeTestScript();
		currentTestIteration = 1;
		currentTestEndIteration = dataTable.getTestEndIteration();

		webDriver.manage().deleteAllCookies();
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		webDriver.get(Settings.getProperty("ApplicationUrl"));
		webDriver.manage().deleteAllCookies();
		// Add cookie to disable ForeSee pop-up invite
		webDriver.manage().addCookie(
				new Cookie("fsr.s", "{\"i\":-1}", ".lowes.com", "/", null,
						false));

		executeTestIterations();

		wrapUp();
	}

	private void initializeTestReport() {
		ReportTheme reportTheme = ReportThemeFactory.getReportsTheme(Theme
				.valueOf(Settings.getProperty("ReportsTheme")));

		reportPath = "Results/" + TimeStamp.getInstance();

		ReportSettings reportSettings = new ReportSettings(reportPath, scenario
				+ "_" + currentTestCase);

		reportSettings.setDateFormatString(Settings
				.getProperty("DateFormatString"));
		reportSettings.setLogLevel(Integer.parseInt(Settings
				.getProperty("LogLevel")));
		reportSettings.setProjectName(Settings.getProperty("ProjectName"));
		reportSettings.generateHtmlReports = Boolean.parseBoolean(Settings
				.getProperty("HtmlReport"));
		reportSettings.includeTestDataInReport = Boolean.parseBoolean(Settings
				.getProperty("IncludeTestDataInReport"));
		reportSettings.takeScreenshotFailedStep = Boolean.parseBoolean(Settings
				.getProperty("TakeScreenshotFailedStep"));
		reportSettings.takeScreenshotPassedStep = Boolean.parseBoolean(Settings
				.getProperty("TakeScreenshotPassedStep"));

		report = new SeleniumReport(reportSettings, reportTheme);

		report.initializeReportTypes();
		report.setDriver(webDriver);

		report.initializeTestLog();
		report.addTestLogHeading(reportSettings.getProjectName() + " - "
				+ reportSettings.getReportName()
				+ " Automation Execution Results");
		report.addTestLogSubHeading(
				"Date & Time",
				": "
						+ Util.getCurrentFormattedTime(Settings
								.getProperty("DateFormatString")),
				"Iteration Mode", ": All");
		report.addTestLogSubHeading("Start Iteration", ": 1", "End Iteration",
				": " + currentTestEndIteration);

		report.addTestLogSubHeading("", "", "Application URL",
				": " + Settings.getProperty("ApplicationUrl"));
		report.addTestLogTableHeadings();
	}

	private void initializeDatatable() throws IOException, SAXException,
			ParserConfigurationException {
		File runtimeTable = new File(RUNTIME_TABLES_DIR + "/" + scenario
				+ ".xml");
		if (!runtimeTable.exists()) {
			InputStream table = Object.class.getResourceAsStream("/datatables/"
					+ scenario + ".xml");

			FileUtils.copyInputStreamToFile(table, runtimeTable);
		}

		File runtimeCommon = new File(RUNTIME_TABLES_DIR
				+ "/Common Testdata.xml");
		if (!runtimeCommon.exists()) {
			InputStream common = Object.class
					.getResourceAsStream("/datatables/Common Testdata.xml");

			FileUtils.copyInputStreamToFile(common, runtimeCommon);
		}

		dataTable = new DataTable(RUNTIME_TABLES_DIR, scenario);
	}

	private void initializeTestScript() {
		scriptHelper = new ScriptHelper(dataTable, report, webDriver);

		businessFlowData = dataTable.getBusinessFlow();
	}

	private void executeTestIterations() {
		while (currentTestIteration <= currentTestEndIteration) {
			report.addTestLogSection("Iteration: "
					+ Integer.toString(currentTestIteration));

			try {
				executeTestcase(businessFlowData);
			} catch (FrameworkException fx) {
				exceptionHandler(fx, fx.errorName);
			} catch (InvocationTargetException ix) {
				exceptionHandler((Exception) ix.getCause(), "Error");
			} catch (Exception ex) {
				exceptionHandler(ex, "Error");
			}

			currentTestIteration++;
		}
	}

	private void executeTestcase(List<String> businessFlowData2)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, ClassNotFoundException,
			InstantiationException {
		HashMap<String, Integer> keywordDirectory = new HashMap<String, Integer>();

		for (int currentKeywordNum = 0; currentKeywordNum < businessFlowData2
				.size(); currentKeywordNum++) {
			String[] currentFlowData = businessFlowData2.get(currentKeywordNum)
					.split(",");
			String currentKeyword = currentFlowData[0];

			int nKeywordIterations;
			if (currentFlowData.length > 1) {
				nKeywordIterations = Integer.parseInt(currentFlowData[1]);
			} else {
				nKeywordIterations = 1;
			}

			for (int currentKeywordIteration = 0; currentKeywordIteration < nKeywordIterations; currentKeywordIteration++) {
				if (keywordDirectory.containsKey(currentKeyword)) {
					keywordDirectory.put(currentKeyword,
							keywordDirectory.get(currentKeyword) + 1);
				} else {
					keywordDirectory.put(currentKeyword, 1);
				}
				currentTestSubIteration = keywordDirectory.get(currentKeyword);

				dataTable.setCurrentRow(currentTestCase, currentTestIteration,
						currentTestSubIteration);

				if (currentTestSubIteration > 1) {
					report.addTestLogSubSection(currentKeyword
							+ " (Sub-Iteration: " + currentTestSubIteration
							+ ")");
				} else {
					report.addTestLogSubSection(currentKeyword);
				}

				invokeBusinessComponent(currentKeyword);
			}
		}
	}

	private void invokeBusinessComponent(String currentKeyword)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, ClassNotFoundException,
			InstantiationException {
		Boolean isMethodFound = false;
		final String javaFileExtension = ".java";
		File[] packageDirectories = { new File(
				"src/main/java/com/lowes/qa/selenium/components") };

		for (File packageDirectory : packageDirectories) {
			File[] packageFiles = packageDirectory.listFiles();

			for (int i = 0; i < packageFiles.length; i++) {
				File packageFile = packageFiles[i];
				String fileName = packageFile.getName();

				// We only want the .java files
				if (fileName.endsWith(javaFileExtension)) {
					// Remove the .java extension to get the class name
					String className = fileName.substring(0, fileName.length()
							- javaFileExtension.length());

					Class<?> reusableComponents = Class
							.forName("com.lowes.qa.selenium.components."
									+ className);
					Method executeComponent;

					try {
						// Convert the first letter of the method to lowercase
						// (in line with java naming conventions)
						currentKeyword = currentKeyword.substring(0, 1)
								.toLowerCase() + currentKeyword.substring(1);
						executeComponent = reusableComponents.getMethod(
								currentKeyword, (Class<?>[]) null);
					} catch (NoSuchMethodException ex) {
						// If the method is not found in this class, search the
						// next class
						continue;
					}

					isMethodFound = true;

					Constructor<?> ctor = reusableComponents
							.getDeclaredConstructors()[0];
					Object businessComponent = ctor.newInstance(scriptHelper);

					executeComponent.invoke(businessComponent, (Object[]) null);

					break;
				}
			}
		}

		if (!isMethodFound) {
			throw new FrameworkException("Keyword " + currentKeyword
					+ " not found within any class "
					+ "inside the components package");
		}
	}

	private void exceptionHandler(Exception ex, String exceptionName) {
		// Error reporting
		String exceptionDescription = ex.getMessage();
		if (exceptionDescription == null) {
			exceptionDescription = ex.toString();
		}

		if (ex.getCause() != null) {
			report.updateTestLog(exceptionName, exceptionDescription
					+ " <b>Caused by: </b>" + ex.getCause(), Status.FAIL);
		} else {
			report.updateTestLog(exceptionName, exceptionDescription,
					Status.FAIL);
		}
		ex.printStackTrace();

		report.updateTestLog(
				"Lowes Info",
				"Test case iteration terminated by user! Proceeding to next iteration (if applicable)...",
				Status.DONE);
		currentTestIteration++;
		executeTestIterations();

		// Wrap up execution
		wrapUp();
	}

	private void wrapUp() {
		endTime = Util.getCurrentTime();
		closeTestReport();

		if (report.getTestStatus().equalsIgnoreCase("Failed")) {
			Assert.fail(report.getFailureDescription());
		}
	}

	private void closeTestReport() {
		String executionTime = Util.getTimeDifference(startTime, endTime);
		report.addTestLogFooter(executionTime);
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public DataTable getDataTable() {
		return dataTable;
	}
}
