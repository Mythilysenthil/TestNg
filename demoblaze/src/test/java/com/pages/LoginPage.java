package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "login2")
	public WebElement login;
	
	@FindBy(id = "loginusername")
	public WebElement username;
	
	@FindBy(id = "loginpassword")
	public WebElement password;
	
	@FindBy(xpath = "//button[text()='Log in']")
	public WebElement loginbutton;
	
    public void login(String strUsername, String strPassword) {
		
	    login.click();
	    username.sendKeys(strUsername);
		password.sendKeys(strPassword);
		loginbutton.click();
		
	}
}
