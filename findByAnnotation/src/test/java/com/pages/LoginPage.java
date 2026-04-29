package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {	
	
  public LoginPage(WebDriver driver) {
		super(driver);
	}
  
  @FindBy(name = "username")
  public WebElement username;
  
  @FindBy(name = "password")
  public WebElement password;
  
  @FindBy(xpath = "//h5[normalize-space()='Login']")
  public WebElement login_text;
  
  @FindBy(xpath = "//button[normalize-space()='Login']")
  public WebElement login;
	
	public void login(String strUsername, String strPassword) {
		
		username.sendKeys(strUsername);
		password.sendKeys(strPassword);
		login.click();
		
	}
	public String getLogintext() {
		return login.getText();
	}
}
