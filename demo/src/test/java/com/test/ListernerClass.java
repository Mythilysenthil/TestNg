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

public class ListernerClass implements ITestListener {

  @Override
  public void onTestStart(ITestResult result) {
	// TODO Auto-generated method stub
	System.out.println(result.getName() + " Test case starts");
  }

  @Override
  public void onTestSuccess(ITestResult result) {
	// TODO Auto-generated method stub
	System.out.println(result.getName() + " Test case run successfully");
  }

  @Override
  public void onTestFailure(ITestResult result) {
	// TODO Auto-generated method stub
	System.out.println(result.getName() + " Test case was failed");
	
	System.out.println("The name of the testcase failed is :" + result.getName());

    if (result.getName().equalsIgnoreCase("invalidlogin")) {

        Object testClass = result.getInstance();
        WebDriver driver = ((TestDemo) testClass).getDriver();

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

  @Override
  public void onTestSkipped(ITestResult result) {
	// TODO Auto-generated method stub
	System.out.println(result.getName() + " Test case was skipped");
  }
}
