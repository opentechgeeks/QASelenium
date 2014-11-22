package com.lowes.qa.selenium.suites;

import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;

import com.lowes.qa.selenium.categories.LocalTests;
import com.lowes.qa.selenium.junit.runners.SuiteCategories;
import com.lowes.qa.selenium.junit.runners.SuiteCategories.SuiteClasspathClasses;

@RunWith(SuiteCategories.class)
@IncludeCategory(LocalTests.class)
@SuiteClasspathClasses("com.lowes")
public class LocalTestSuite {
	// Suite definition, nothing goes here
}
