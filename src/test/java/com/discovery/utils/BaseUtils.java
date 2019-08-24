package com.discovery.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseUtils {
	public BrowserManager browserManager;
	public static DriverManager driverManager;
	public static WebDriver webDriver;
	public static Actions action = new Actions(DriverManager.getDriver());
	public static JavascriptExecutor javaScriptexecutor = (JavascriptExecutor) DriverManager.getDriver();
	public static String failed_Web_Test_Screenshot_Location = "./screenshot/failed_Test";

	
	public static void initialiseElement(Object object)
	 {
		 PageFactory.initElements(DriverManager.getDriver(),object);
	 }

	
	
	
	//*****************
	//Display functions
	//*****************
	 public static  boolean isDisplayed(WebElement webElement)
	    {
	        try
	        {
	                WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
	                wait.until(ExpectedConditions.visibilityOf(webElement));
	                return true;

	        }
	        catch(NoSuchElementException e)
	        {
	            e.printStackTrace();
	            return false;
	        }

	    }

	
	
	
	//*****************
	//Click functions
	//*****************
	
	 public static void clickElement(WebElement webElement)
	    {
	       try
	       {
	           if(isDisplayed(webElement))
	           {
	               WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
	               wait.until(ExpectedConditions.elementToBeClickable(webElement));
	               webElement.click();
	           }
	       }
	       catch (NoSuchElementException e)
	       {
	           e.printStackTrace();

	       }
	    }
	 
	 
	   public static void clickObject(WebElement webElement)
		{
			try 
			{
				javaScriptexecutor.executeScript("arguments[0].click();", webElement);
			}
			catch (NoSuchElementException e)
	        {
				e.printStackTrace();	
	        }
		}
	 
	 //**********************
	 //Wait functions
	 //**********************
	   public static void wait(int time)
	    {
	    	try
	    	{
	    		Thread.sleep(time*1000);
	    	}
	    	catch(Exception e)
	    	{
	    		
	    	}
	    }
	 
	 //**********************************
	//Functions related to Actions class
	//***********************************
	
	    
	    public static void moveToElement(WebElement webElement)
	    {
	    	action.moveToElement(webElement).build().perform();
	    }
	    
	    public static void moveAndClickElement(WebElement webElement)
	    {
	    	action.moveToElement(webElement).click().build().perform();
	    }
	    
    //**************************************
	//TestNG listener supporting methods
    //**************************************
	    
	    public static void getScreenShot(String failed_TestScreenshot_Location)
	   	{
	   		try 
	   		{
	   			File srcFile=((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
	   			FileUtils.copyFile(srcFile, new File(failed_TestScreenshot_Location));
	   		
	   		} 
	   		catch (IOException e) 
	   		{
	   			e.printStackTrace();
	   		}
	   	}
	    
	    public static String getCurrentTimeStamp()
	   	{
	       	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy HH-mm-ss");
	   		return simpleDateFormat.format(new Date());
	   	}
	 
}
