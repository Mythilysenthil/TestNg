package com.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class ListenerDemo implements ITestListener {
	
	public void onTestStart(ITestResult Result) {
		System.out.println(Result.getName() + " test case started");
	}

	public void onTestSuccess(ITestResult Result) {
		System.out.println("The name of the testcase passed is :" + Result.getName());
	}

	public void onTestSkipped(ITestResult Result) {
		System.out.println("The name of the testcase Skipped is :" + Result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {

	    System.out.println("The name of the testcase failed is :" + result.getName());

	    if (result.getName().equalsIgnoreCase("Invalid1")) {

	        Object testClass = result.getInstance();
	        WebDriver driver = ((LoginTest) testClass).getDriver();

	        takeScreenshot(driver, result.getName());
	    }
	}
	
	public void takeScreenshot(WebDriver driver, String testName) {

	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File src = ts.getScreenshotAs(OutputType.FILE);

	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

	    String filePath = System.getProperty("user.dir") + "/screenshots/" 
	                      + testName + "_" + timeStamp + ".png";
 
	    try {
	        File dest = new File(filePath);
	        FileUtils.copyFile(src, dest);

	        System.out.println("Screenshot saved at: " + filePath);

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

}
