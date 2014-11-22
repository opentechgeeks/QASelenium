package com.lowes.qa.selenium.suites;

import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;

import com.lowes.qa.selenium.categories.SmokeTests;
import com.lowes.qa.selenium.junit.runners.SuiteCategories;
import com.lowes.qa.selenium.junit.runners.SuiteCategories.SuiteClasspathClasses;

/**
 * Executes methods tagged with the @{link SmokeTests} across the defined (all)
 * scenario test classes.
 * 
 * @author Matthew DeTullio
 */
@RunWith(SuiteCategories.class)
@IncludeCategory(SmokeTests.class)
@SuiteClasspathClasses("com.lowes")
public class SmokeTestSuite {
	// Suite definition, nothing goes here
}
