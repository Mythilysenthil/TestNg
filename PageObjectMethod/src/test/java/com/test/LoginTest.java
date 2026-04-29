package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.LoginPage;

public class LoginTest extends BaseTest{
	LoginPage objLogin;
  @Test
  public void loginTest() {
	 objLogin=new LoginPage(driver);
	 String loginPageTitle=objLogin.getLogintext();
	 Assert.assertTrue(loginPageTitle.contains("Login"));
  }
}