package com.test;

import org.testng.annotations.Test;

import com.pages.LoginPage;

import utilities.DataProviderClass;

public class LoginTest extends BaseTest {

    LoginPage login;

    @Test(
        dataProvider = "loginData",
        dataProviderClass = DataProviderClass.class
    )

    public void verifyLogin( String username,String password) {

        login = new LoginPage(driver);

        login.login(username,password);

        System.out.println("Username: "+ username);

        System.out.println("Password: "+ password);
    }
}