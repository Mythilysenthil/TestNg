package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
  WebDriver driver;
  By username = By.xpath("//input[@name='username']");
  By password = By.xpath("//input[@name='password']");
  By titleText =By.xpath("//h5[normalize-space()='Login']");
  By submit = By.xpath("//button[@type='submit']");

  public LoginPage(WebDriver driver) {
	  this.driver =driver;
  }
  
  public void setUsername(String strUsername) {
	  driver.findElement(username).sendKeys(strUsername);
  }
  public void setPassword(String strPassword) {
	  driver.findElement(password).sendKeys(strPassword);
  }
  
  public void clicklogin() {
	  driver.findElement(submit).click();
  }
  
  public String getLogintext() {
		return driver.findElement(titleText).getText();
	}
	
	public void login(String strUsername, String strPassword) {
		//fill the user name
		this.setUsername(strUsername);
		//fill the password
		this.setPassword(strPassword);
		//click the login button
		this.clicklogin();
	}
}
