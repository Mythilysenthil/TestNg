package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage extends BasePage {
	public DashBoardPage(WebDriver driver) {
		  super(driver);
	  }
  
  @FindBy(xpath= "//h6[normalize-space()='Dashboard']")
  public WebElement DashboardPageTitle;
  
  
  //get the user name from home page
  public String getHomePageText() {
	  return DashboardPageTitle.getText();
  }
}