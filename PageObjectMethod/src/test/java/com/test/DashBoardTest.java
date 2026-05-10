package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.DashBoardPage;
import com.pages.LoginPage;

import utilities.DataProviderClass;

public class DashBoardTest extends BaseTest {

    LoginPage objLogin;
    DashBoardPage objDashboardPage;

    @Test(
        priority = 0,
        dataProvider = "loginData",dataProviderClass =DataProviderClass.class
    )

    public void DashboardTest(String username,String password) {

        objLogin =new LoginPage(driver);

        objLogin.login(username,password);

        objDashboardPage =new DashBoardPage(driver);
        Assert.assertTrue(objDashboardPage.getHomePageText().contains("Dashboard"));

        System.out.println("Login verified for: "+ username);
    }
}