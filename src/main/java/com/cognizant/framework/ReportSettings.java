package com.cognizant.framework;

public class ReportSettings {
	private String reportPath;
	private String reportName;
	private String projectName;
	private int logLevel;
	public Boolean generateHtmlReports;
	public Boolean includeTestDataInReport;
	public Boolean takeScreenshotFailedStep;
	public Boolean takeScreenshotPassedStep;
	private String dateFormatString;

	public String getReportPath() {
		return this.reportPath;
	}

	public String getReportName() {
		return this.reportName;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(final String projectName) {
		this.projectName = projectName;
	}

	public int getLogLevel() {
		return this.logLevel;
	}

	public void setLogLevel(int logLevel) {
		if (logLevel < 0) {
			logLevel = 0;
		}
		if (logLevel > 5) {
			logLevel = 5;
		}
		this.logLevel = logLevel;
	}

	public String getDateFormatString() {
		return this.dateFormatString;
	}

	public void setDateFormatString(final String dateFormatString) {
		this.dateFormatString = dateFormatString;
	}

	public ReportSettings(final String reportPath, final String reportName) {
		super();
		this.projectName = "";
		this.logLevel = 4;
		this.generateHtmlReports = true;
		this.includeTestDataInReport = true;
		this.takeScreenshotFailedStep = true;
		this.takeScreenshotPassedStep = false;
		this.dateFormatString = "dd-MMM-yyyy hh:mm:ss a";
		this.reportPath = reportPath;
		this.reportName = reportName;
	}
}
