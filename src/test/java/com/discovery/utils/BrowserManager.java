package com.discovery.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;

public class BrowserManager {
	
	public static WebDriver webDriver;
	
    public WebDriver initializeDriver(String browser,String url, String OS)
    {
        if (browser.equals("CHROME"))
        {
        	if(OS.equals("WINDOWS"))
        	{
        		System.setProperty("webdriver.chrome.driver","drivers/Windows/chromedriver.exe");
        	}
        	else if(OS.equals("MAC"))
        	{
        		System.setProperty("webdriver.chrome.driver","./drivers/Mac/chromedriver");
        	}
        	else
        	{
        		System.setProperty("webdriver.chrome.driver","drivers/Windows/chromedriver.exe");
        	}
        	 
             ChromeOptions options=new ChromeOptions();
             options.addArguments("start-maximized");
             options.addArguments("disable-infobars");
             options.addArguments("--disable-gpu");
             webDriver=new ChromeDriver(options);
             webDriver.get(url);
             webDriver.manage().deleteAllCookies();
        }
        
        else if(browser.equals("FIREFOX"))
        {
        	if(OS.equals("WINDOWS"))
        	{
        		System.setProperty("webdriver.gecko.driver","drivers/Windows/geckodriver.exe");
        	}
        	else if(OS.equals("MAC"))
        	{
        		System.setProperty("webdriver.gecko.driver","./drivers/Mac/geckodriver");
        	}
        	else
        	{
        		System.setProperty("webdriver.chrome.driver","drivers/Windows/geckodriver.exe");
        	}
        	
            FirefoxOptions firefoxOptions=new FirefoxOptions();
            firefoxOptions.addArguments("--start-maximized");
            webDriver=new FirefoxDriver();
            webDriver.get(url);
            webDriver.manage().deleteAllCookies();
        }
        
        webDriver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        return webDriver;
    }
        
}
