package com.clusters.ui.repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{
	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver,30);
	}
	
	public WebElement getUserNameTextBox()
	{		 
		 return driver.findElement(By.id("identifierId"));
	}
	public WebElement getPasswordDiv()
	{		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
	}
	public WebElement getPasswordTextBox()
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));		
	}
	public WebElement geNextButton()
	{
		 return driver.findElement(By.xpath("//span[text()='Next']"));
	}
	public WebElement getForgotEmailButton()
	{
		 return driver.findElement(By.xpath("//span[text()='Forgot email?']"));
	}
	public WebElement getValidationDiv()
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='LXRPh']/div[@class='dEOOab RxsGPe'])[1]"))); 
	}
	public WebElement getForgotEmailForm()
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='RFjuSb bxPAYd k6Zj8d']"))); 	
	}
	
	public void waitForLoginPageToLoad()
	{		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("yDmH0d")));
	}
	
}
