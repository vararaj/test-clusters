package com.clusters.test.smoke;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.clusters.generic.utils.CreateDriver;
import com.clusters.ui.repo.LoginPage;

public class TestLoginSC3879 
{
	WebDriver driver;
	LoginPage login;
	
	@BeforeMethod
	public void preCondition()
	{		
		driver = CreateDriver.getDriverInstance();
		login = new LoginPage(driver);				
	}	
	
	@Test(priority=1)
	public void testInvalidUsernameTC1()
	{
		login.waitForLoginPageToLoad();
		login.getUserNameTextBox().sendKeys("1234");		
		login.geNextButton().click();		
		WebElement invalidUsernameDiv = login.getValidationDiv();
		String actualValidationMessage = invalidUsernameDiv.getText();
		String expectedValidationMessage = "Enter a valid email or phone number";		
		Assert.assertEquals(actualValidationMessage, expectedValidationMessage);
	}
	
	@Test(priority=2)
	public void tesValidUsernameTC2()
	{
		login.waitForLoginPageToLoad();
		login.getUserNameTextBox().sendKeys("varalakshmi.rajkumar");		
		login.geNextButton().click();
		WebElement passwordDiv = login.getPasswordDiv();
		Boolean expectedVisibility = true;
		Boolean actualVisibility = passwordDiv.isDisplayed();
		Assert.assertEquals(actualVisibility, expectedVisibility);
	}
	
	@Test(priority=3)
	public void testInvalidPasswordTC3()
	{
		login.waitForLoginPageToLoad();
		login.getUserNameTextBox().sendKeys("varalakshmi.rajkumar");		
		login.geNextButton().click();	
		login.getPasswordTextBox().sendKeys("qwart");		
		login.geNextButton().click();	
		WebElement invalidPasswordDiv = login.getValidationDiv();
		String actualValidationMessage = invalidPasswordDiv.getText();
		String expectedValidationMessage = "Wrong password. Try again or click Forgot password to reset it.";		
		Assert.assertEquals(actualValidationMessage, expectedValidationMessage);
	}
	
	@Test(priority=4)
	public void testForgotEmailTC4()
	{
		login.waitForLoginPageToLoad();
		login.getForgotEmailButton().click();	
		WebElement forgotEmailForm = login.getForgotEmailForm();
		Boolean expectedVisibility = true;
		Boolean actualVisibility = forgotEmailForm.isDisplayed();
		Assert.assertEquals(actualVisibility, expectedVisibility);
	}

	@AfterMethod
	public void postCondition()
	{
		driver.quit();
	}

}
