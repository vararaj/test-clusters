package com.clusters.test.config;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class TestConfiguration 
{
	@BeforeSuite
	public void beforeSuite()
	{
		Reporter.log("------Started suite execution-------",true);
	}
	@AfterSuite
	public void afterSuite()
	{
		Reporter.log("------Ended suite execution-------",true);
	}
	@BeforeClass
	public void beforeClass()
	{
		Reporter.log("------Started user story execution-------",true);
	}
	@AfterClass
	public void afterClass()
	{
		Reporter.log("------Ended user story execution-------",true);
	}


}
