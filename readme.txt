This project consists of the test case which includes one of the scenario for "www.Discovery.com" site.

Steps covered in the test case:
===============================
1) Launch the chrome browser.
2) Navigate to url "www.Discovery.com".
3) Click on Discovery-Go link ("go.discovery.com").
4) Scroll down to "RECOMMENDED FOR YOU" section.
5) Hover on first video in the list and click on "Add to Favorite" icon to add it to my videos list.
6) Hover on second video in the list and click on "Add to Favorite" icon to add it to my videos list.
7) Go to "My videos" section.
8) Validate the title and discription of both the videos which has been added from Recommended videos section.


Framework Details:
=================
Design : Page Object Module
Tools Used: Selenium, TestNG, Maven
Packages: 3 (com.discovery.pages, com.discovery.tests, com.discovery.utils)
Resource file: discoveryRecomemdedVideos.xml (This is a TestNG xml)


Package details and Structure:
==============================
1) com.discovery.pages: This contains "DiscoveryHomePage.Java" class which contains all the required WebElements which are identifed and initialized here(Object repository),
			Also it contains the basic methods to perform any actions in the related particular page.

2) com.discovery.tests: This contains "CheckRecommendedVideosTest.Java" test class, which contains test cases which will have the same steps as it is mentioned in the
			One of the above sections ("Steps covered..."), This class will also have a assertion which compares and validates the videos that has been added.

3) com.discovery.utils: This contains 6 Java classes which are having important methods which are generic and can be used anywhere in the project, below are the details,
			a)  BaseUtils.Java:  This contains some of the basic methods related to click, display, wait, actions, testNG etc.
			b)  BrowserManager.Java:  This contains methods related to browser, that includes initializing and launching the brower.
			c)  ConfigUtils.Java: This contains some of the collections of constants.
			d)  DriverManager.Java:  This contains methods that does driver initialization with getter and setter methods.
			e)  Listener_Utils.Java:  This contains implementation of testNG ITestListener interface unimplimented methods.
			f)  LocatorUtils.Java:  This contains methods related to getElements which will be helpful for user to find out the dynamic elements.



Running test case on different Operaring systems
===============================================
Navigate to testNG xml file ".\DiscoveryE2E\src\test\resources\discoveryRecommendedVideos.xml", edit the parameter named "OS",
by default OS will be "WINDOWS", if user wants to run the test case in MAC then change the value of parameter named "OS" to "MAC"




How to run the test case:
======================== 
We can run it in 2 ways.
1) From a command line.
2) From Eclipse project.


1) Running test case from command line.
   ====================================
From the command line mavigate to the project path Ex: C:/xyz/DiscoveryE2E/
Hit the below command to run it,


mvn clean test -Dsuite=discoveryRecommendedVideos



2) Runnning test case from Ecplipse project.
   =========================================
Open Eclipse -> Import the existing maven project -> DiscoveryE2E, navigate to resourses folder, right click on the "discoveryRecommendedVideos.xml"
-> Run As -> TestNG Suite.




