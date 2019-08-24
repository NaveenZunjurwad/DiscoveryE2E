package com.discovery.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LocatorUtils {
	
	
	public static  WebElement getElement(ConfigUtils.ElementLocator locator,String locatorValue)
	{
		WebElement returnElement=null;
		switch(locator)
		{
		case CSS:
		    returnElement= DriverManager.getDriver().findElement(By.cssSelector(locatorValue));
			break;
		case ID:
			returnElement= DriverManager.getDriver().findElement(By.id(locatorValue));
			break;
		case LINK:
			returnElement= DriverManager.getDriver().findElement(By.linkText(locatorValue));
			break;
		case NAME:
			returnElement= DriverManager.getDriver().findElement(By.name(locatorValue));
			break;
			
		case XPATH:
			returnElement= DriverManager.getDriver().findElement(By.xpath(locatorValue));
			break;
			
		case XPATH_TEXT:
			returnElement= DriverManager.getDriver().findElement(By.xpath("//*[. = '"+locatorValue+"']"));
			break;
			
		case XPATH_DIV_CONTAINS_TEXT:
			returnElement= DriverManager.getDriver().findElement(By.xpath("//div[contains(text(), '"+locatorValue+"']"));
			break;
			
		case XPATH_SPAN_CONTAINS_TEXT:
			returnElement= DriverManager.getDriver().findElement(By.xpath("//span[contains(text(), '"+locatorValue+"']"));
			break;
			
		case XPATH_CONTAINS_TEXT:
			returnElement= DriverManager.getDriver().findElement(By.xpath("//*[contains(text(), '"+locatorValue+"']"));
			break;
			
		default:
			break;
		}
		
		return returnElement;
	}

	 public static WebElement getElement(WebElement parentElement,  ConfigUtils.ElementLocator  webLocatorStrategy, String webAttributeValue) {
	        try {
	          
	        	WebElement returnElement = null;
	            DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	                switch (webLocatorStrategy) {
	                    case ID:
	                        returnElement = parentElement.findElement(By.id(webAttributeValue));
	                        break;
	                        
	                    case XPATH:
	                        returnElement = parentElement.findElement(By.xpath(webAttributeValue));
	                        break;
	                        
	                    case XPATH_TEXT:
	                        returnElement = parentElement.findElement(By.xpath("//*[. = '" + webAttributeValue + "']"));
	                        break;
	                        
	                    case XPATH_DIV_CONTAINS_TEXT:
	                        returnElement = parentElement.findElement(By.xpath("//div[contains(text(), '" + webAttributeValue + "')]"));
	                        break;
	                        
	                    case XPATH_SPAN_CONTAINS_TEXT:
	                        returnElement = parentElement.findElement(By.xpath("//span[contains(text(), '" + webAttributeValue + "')]"));
	                        break;
	                        
	                    case CSS:
	                        returnElement = parentElement.findElement(By.cssSelector(webAttributeValue));
	                        break;
	                        
	                    case XPATH_CONTAINS_TEXT:
	                        returnElement = parentElement.findElement(By.xpath("//*[contains(text(), '" + webAttributeValue + "')]"));
	                        break;
	                    default:
	                }
	              
	                return returnElement;
	            } 
			 catch (Throwable e) {
			            e.printStackTrace();
			        }
			        
			        return null;
	    }

}
