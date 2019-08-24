package com.discovery.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.discovery.utils.BaseUtils;
import com.discovery.utils.ConfigUtils;
import com.discovery.utils.LocatorUtils;

public class DiscoveryHomePage {
	
	
	@FindBy(how=How.CSS, using=".m-ButtonLink__a-Icon--Discoverygo-logo")
	private WebElement discoveryGoLogo;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Recommended')]/ancestor::section")
	public  WebElement recommendedVideosSection;
	
	@FindBy(how=How.CSS,using=".dscHeaderMain__hideMobile .dscHeaderMain__iconMenu")
	private WebElement menuIcon;
	
	@FindBy(how=How.CSS,using="a[href='/my-videos']")
	private WebElement myVideos_link;
	
	@FindBy(how=How.XPATH,using="//h2[contains(text(),'Favorite Shows')]/parent::div")
	public WebElement favoriteShowsSection;
	
	
	public DiscoveryHomePage()
	{
		BaseUtils.initialiseElement(this);
	}

	public void click_On_DiscoveryGo_link()
	{
		BaseUtils.clickElement(discoveryGoLogo);
	}
	
	public void moveTo_RecommendedVideos_link()
	{
		BaseUtils.moveToElement(recommendedVideosSection);
	}
	
	public void choose_Videos_And_Click_On_Add_To_Favorites(WebElement webElement,int vCount)
	{
		BaseUtils.moveToElement(LocatorUtils.getElement(webElement,ConfigUtils.ElementLocator.CSS,".showCarousel__content").findElements(By.cssSelector(".carousel-tile-wrapper")).get(vCount));
		BaseUtils.wait(4);
		BaseUtils.clickElement(LocatorUtils.getElement(webElement, ConfigUtils.ElementLocator.CSS, ".showCarousel__content").findElements(By.cssSelector(".icon-plus")).get(0));
	}
	
	public void add_videos_to_Favorites(WebElement webElement,int vCount)
	{
		for(int i=0;i<vCount;i++)
		{
			choose_Videos_And_Click_On_Add_To_Favorites(webElement,i);
			
		}
	}
	
	public ArrayList<String> get_Selected_Video_Titles(WebElement webElement,int vCount)
	{
		ArrayList<String>getVideoTitle=new ArrayList<String>();
		for(int vTitle=0;vTitle<vCount;vTitle++)
		{
			
			BaseUtils.moveToElement(LocatorUtils.getElement(webElement,ConfigUtils.ElementLocator.CSS,".showCarousel__content").findElements(By.cssSelector(".carousel-tile-wrapper")).get(vTitle));
			getVideoTitle.add( LocatorUtils.getElement(webElement, ConfigUtils.ElementLocator.CSS, ".showCarousel__content").findElements(By.cssSelector(".showTileSquare__title")).get(vTitle).getText());
		}
		return getVideoTitle;
	}
	
	public void clickOn_MenuIcon()
	{
		BaseUtils.clickElement(menuIcon);
	}
	
	public void clickOn_MyVideos_link()
	{
		BaseUtils.clickObject(myVideos_link);
	}
}
