package com.discovery.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class DriverManager {
	
	public static WebDriver webDriver;
	public BrowserManager browserManager;
	
	@BeforeSuite(groups={"recommenedVideo"})
	@Parameters({"browser","platForm","url","OS"})
	public void driverInitialization(String browser,String platForm,String url, String OS)
	{
		browserManager = new BrowserManager();
		webDriver=browserManager.initializeDriver(browser,url,OS);
		setDriver(webDriver);
	}
	
	@AfterSuite(groups={"recommenedVideo"})
	public void tearDown()
	{
		webDriver.close();
		webDriver.quit();
	}
	
	
	public static WebDriver getDriver()
	{
		return webDriver;
	}
	
	public static void setDriver(WebDriver driver)
	{
		webDriver=driver;
	}

}
