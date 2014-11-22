package com.cognizant.framework;

import java.io.IOException;
import java.util.Properties;

public final class Settings {
	private static Properties properties = loadFromPropertiesFile();

	private Settings() {
		// Prevent outside instantiation
	}

	/**
	 * Gets the global setting for the given key.
	 * 
	 * @return the value of the given key
	 */
	public static synchronized String getProperty(String name) {
		return properties.getProperty(name);
	}

	/**
	 * Gets the global setting for the given key with the ability to set a
	 * default value.
	 * 
	 * @return the value of the given key or the default value if the key is not
	 *         present
	 */
	public static synchronized String getProperty(String name,
			String defaultValue) {
		return properties.getProperty(name, defaultValue);
	}

	/**
	 * Gets the global settings instance.
	 * 
	 * @deprecated Use {@link #getProperty} instead.
	 * @return {@link Properties} loaded from the global-settings.properties
	 *         file.
	 */
	@Deprecated
	public static synchronized Properties getInstance() {
		if (properties == null) {
			loadFromPropertiesFile();
		}
		return properties;
	}

	private static Properties loadFromPropertiesFile() {
		Properties props = new Properties();

		try {
			props.load(Object.class.getClass().getResourceAsStream(
					"/global-settings.properties"));
		} catch (IOException e) {
			throw new IllegalStateException(
					"Could not load global-settings.properties.");
		}
		return props;
	}
}
