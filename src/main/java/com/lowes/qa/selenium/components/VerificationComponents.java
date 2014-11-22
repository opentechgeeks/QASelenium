package com.lowes.qa.selenium.components;

import com.lowes.qa.selenium.support.Asserts;
import com.lowes.qa.selenium.support.DriverScript;
import com.lowes.qa.selenium.support.ReusableLibrary;
import com.lowes.qa.selenium.support.ScriptHelper;



/**
 * Verification Components class
 * @author Cognizant
 */
public class VerificationComponents extends ReusableLibrary
{
	private Asserts asserts = new Asserts();
	
	
	/**
	 * Constructor to initialize the component library
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link DriverScript}
	 */
	public VerificationComponents(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
	}
	
}