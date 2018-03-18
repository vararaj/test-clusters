package com.clusters.generic.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class CreateDriver {

	public static WebDriver getDriverInstance()
	{
		WebDriver driver= null;
		String browserType = DataHandlers.getDataFromProperties("config", "browser");
		String url = DataHandlers.getDataFromProperties("config", "url");
		switch (browserType.toLowerCase()) 
		{
			case "ie" : 
				System.setProperty("webdriver.ie.driver", "./browser-server/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
			case "ff" : 	
				System.setProperty("webdriver.gecko.driver", "./browser-server/geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			case "gc" : 
				System.setProperty("webdriver.chrome.driver","./browser-server//chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "opera" : 
				System.setProperty("webdriver.opera.driver", "./browser-server/operadriver.exe");
		 		OperaOptions operaOptions = new OperaOptions();
		 		operaOptions.setBinary("./browser-server/Opera.exe");
				driver = new OperaDriver(operaOptions);
				break;
			default:
				System.out.println("Invalid browser selection");	
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return driver;
	}
}
