package com.discovery.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener_Utils implements ITestListener{

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) 
	{
		System.out.println(result.getName()+" test case failed");
		BaseUtils.getScreenShot(BaseUtils.failed_Web_Test_Screenshot_Location +result.getMethod().getMethodName()+"_"+BaseUtils.getCurrentTimeStamp()+".png");
	
		
	}

	public void onTestSkipped(ITestResult arg0) 
	{
		System.out.println(arg0.getName()+" test case got skipped");
	}

	public void onTestStart(ITestResult arg0) 
	{
		System.out.println(arg0.getName()+" test run started");
		
	}

	public void onTestSuccess(ITestResult arg0) 
	{
		System.out.println(arg0.getName()+" test case passed****");
		
	}

}
