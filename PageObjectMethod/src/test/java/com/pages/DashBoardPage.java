package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage {
  WebDriver driver;
  
  By DashboardPageTitle = By.xpath("//h6[normalize-space()='Dashboard']");
  
  public DashBoardPage(WebDriver driver) {
	  this.driver = driver;
  }
  
  //get the user name from home page
  public String getHomePageText() {
	  return driver.findElement(DashboardPageTitle).getText();
  }
}