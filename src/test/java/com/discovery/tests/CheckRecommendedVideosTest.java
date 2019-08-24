package com.discovery.tests;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.discovery.pages.DiscoveryHomePage;


public class CheckRecommendedVideosTest {
	public DiscoveryHomePage discoveryHomePage;
	public ArrayList<String> getRecommendedVideo_Titles=new ArrayList<String> ();
	public ArrayList<String> getFavortiesVideo_Section_Titles=new ArrayList<String> ();
	
	@BeforeClass(groups = {"recommenedVideo"})
    public void init()
    {
		 discoveryHomePage=new DiscoveryHomePage();

    }
	@Test(priority = 1,groups={"recommenedVideo"})
	public void checkRecommededVideos()
	{
		   try
	       {
			   //Click on Discovery logo link
			   discoveryHomePage.click_On_DiscoveryGo_link();
			   	   
			   //Move to Recommended videos section
			   discoveryHomePage.moveTo_RecommendedVideos_link();
			   
			   //Selecting videos from Recommended videos section and clicking on Add to favorite button
			   discoveryHomePage.add_videos_to_Favorites(discoveryHomePage.recommendedVideosSection, 2);
			   
			   //Get the Selected Recommended Video titles
			   getRecommendedVideo_Titles=discoveryHomePage.get_Selected_Video_Titles(discoveryHomePage.recommendedVideosSection, 2);
			   
			   //Click on Menu icon
			   discoveryHomePage.clickOn_MenuIcon();
			   
			   //Click on My videos link
			   discoveryHomePage.clickOn_MyVideos_link();
			   
			   //Get the Videos list from My Videos section
			   getFavortiesVideo_Section_Titles=discoveryHomePage.get_Selected_Video_Titles(discoveryHomePage.favoriteShowsSection, 2);
			   
			   //Compare both the array list which contains video titles from recommend videos and My videos sections, both the array list should be same
	        	 Assert.assertTrue(getRecommendedVideo_Titles.containsAll(getFavortiesVideo_Section_Titles));   	
	       }
	       catch(Exception e)
	       {
	    	   e.printStackTrace();
	    	   Assert.fail();
	    	  
	       }
	}

}
