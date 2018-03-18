package com.clusters.generic.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class JavaScriptPopUpHandlers 
{
	public static void clickOkOnJSPopup(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}
	public static void clickCancelOnJSPopup(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}
	public static String getMsgOfJSPopup(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		String alt_msg = alt.getText();
		return alt_msg;
	}
	public static void enterTextOnJSPopup(WebDriver driver, String text)
	{
		Alert alt = driver.switchTo().alert();
		alt.sendKeys(text);
	}
}
