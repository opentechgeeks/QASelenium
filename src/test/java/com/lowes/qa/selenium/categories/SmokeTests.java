package com.lowes.qa.selenium.categories;

/**
 * JUnit Category marker for smoke tests.
 * <p>
 * Tag your test methods with <code>@Category(SmokeTests.class)</code> to
 * include.
 * <p>
 * Nomenclature is backwards:
 * <ul>
 * <li>If your suite includes the category SmokeTests, it won't run
 * BuildVerificationTests.
 * <li>If your suite includes the category BuildVerificationTests, it will run
 * SmokeTests.
 * 
 * @author Matthew DeTullio
 */
public interface SmokeTests extends BuildVerificationTests {
	// JUnit Category marker
}
