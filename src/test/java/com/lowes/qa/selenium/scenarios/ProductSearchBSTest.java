package com.lowes.qa.selenium.scenarios;

import java.io.IOException;
import java.text.MessageFormat;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.lowes.qa.selenium.ParallelizedTestBase;
import com.lowes.qa.selenium.support.DriverScriptRegistry;

public class ProductSearchBSTest extends ParallelizedTestBase {
	public ProductSearchBSTest(String browserName, String version,
			String platform, String os) throws IOException, SAXException,
			ParserConfigurationException {
		super(browserName, version, platform, os);
		driver = DriverScriptRegistry.getDriverScript(MessageFormat.format(
				"{0}:{1}:{2}:{3}:{4}", browserName, version, platform, os, this
						.getClass().getName()), "ProductSearch_BS");
	}

	// Add tests here
}
