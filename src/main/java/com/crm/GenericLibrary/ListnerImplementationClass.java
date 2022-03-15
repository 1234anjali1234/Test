package com.crm.GenericLibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListnerImplementationClass implements ITestListener{


	public void onTestStart(ITestResult result) 
	{
     String MethodName = result.getMethod().getMethodName();
     Reporter.log(MethodName + "----testscript execution sucessfull - START");
	}
	

	public void onTestSuccess(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
	    Reporter.log(MethodName + "----testscript execution sucessfull - PASS");
	}
	

	public void onTestFailure(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
	    Reporter.log(MethodName + "----testscript execution Failed ");
	    
	    //Step1: Configure screenshot name
	   String screenshotName = MethodName + new JavaUtility().getSystemDateInFormat();
	   System.out.println(screenshotName);
	   
	   //Step2: Using Screenshot method from web driver utility
	   
	   try
	   {
	   new WebDriverUtility().getScreenShot(BaseClass.sDriver, screenshotName);
	   }
	   
	   catch(Throwable e)
	   {
		   e.printStackTrace();
	   }
	   
	}	   
	

	public void onTestSkipped(ITestResult result) 
	{

	}


	public void onTestFailedWithTimeout(ITestResult result) 
	{

	}



	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{

	}



	public void onFinish(ITestContext context) 
	{

	}

	public void onStart(ITestContext context) 
	{

	}




}
