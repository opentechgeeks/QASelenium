package com.cognizant.framework;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Util {
	public static Date getCurrentTime() {
		final Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}

	public static String getCurrentFormattedTime(final String dateFormatString) {
		final DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
		final Calendar calendar = Calendar.getInstance();
		return dateFormat.format(calendar.getTime());
	}

	public static String getFormattedTime(final Date time,
			final String dateFormatString) {
		final DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
		return dateFormat.format(time);
	}

	public static String getTimeDifference(final Date startTime,
			final Date endTime) {
		long timeDifference = endTime.getTime() - startTime.getTime();
		timeDifference /= 1000L;
		final String timeDifferenceDetailed = String.valueOf(Long
				.toString(timeDifference / 60L))
				+ " minute(s), "
				+ Long.toString(timeDifference % 60L) + " seconds";
		return timeDifferenceDetailed;
	}
}
