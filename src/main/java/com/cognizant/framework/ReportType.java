package com.cognizant.framework;

public interface ReportType {
	void initializeTestLog();

	void addTestLogHeading(String p0);

	void addTestLogSubHeading(String p0, String p1, String p2, String p3);

	void addTestLogTableHeadings();

	void addTestLogSection(String p0);

	void addTestLogSubSection(String p0);

	void updateTestLog(String p0, String p1, String p2, Status p3, String p4);

	void addTestLogFooter(String p0, int p1, int p2);

	void initializeResultSummary();

	void addResultSummaryHeading(String p0);

	void addResultSummarySubHeading(String p0, String p1, String p2, String p3);

	void addResultSummaryTableHeadings();

	void updateResultSummary(String p0, String p1, String p2, String p3,
			String p4);

	void addResultSummaryFooter(String p0, int p1, int p2);
}
