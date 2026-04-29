package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.DashBoardPage;
import com.pages.LoginPage;

public class DashBoardTest extends BaseTest{
    
	LoginPage objLogin; 
	DashBoardPage objDashboardPage;
	@Test(priority = 0)
	public void DashboardTest() {

		objLogin = new LoginPage(driver);
		objLogin.login("Admin", "admin123");

		objDashboardPage = new DashBoardPage(driver);
		Assert.assertTrue(objDashboardPage.getHomePageText().contains("Dashboard"));
	}
}
