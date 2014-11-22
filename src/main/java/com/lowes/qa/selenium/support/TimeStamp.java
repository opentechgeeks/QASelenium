package com.lowes.qa.selenium.support;

import java.io.File;
import java.util.Properties;

import com.cognizant.framework.Settings;
import com.cognizant.framework.Util;

/**
 * Singleton class which manages the creation of timestamped result folders for
 * every test batch execution
 * 
 * @author Cognizant
 * @version 3.0
 * @since October 2011
 */
public final class TimeStamp {
	private static String timeStamp;

	private TimeStamp() {
		// Prevent outside instantiation
	}

	/**
	 * Function to return the timestamped result folder path
	 * 
	 * @return The timestamped result folder path
	 */
	public static synchronized String getInstance() {
		if (timeStamp == null) {
			Properties properties = Settings.getInstance();

			timeStamp = "Run_"
					+ Util.getCurrentFormattedTime(
							properties.getProperty("DateFormatString"))
							.replace(" ", "_").replace(":", "-");

			String reportPathWithTimeStamp = "Results/" + timeStamp;

			new File(reportPathWithTimeStamp).mkdirs();
			new File(reportPathWithTimeStamp + "/Screenshots").mkdir();
		}

		return timeStamp;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}