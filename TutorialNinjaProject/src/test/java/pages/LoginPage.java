package pages;

import org.openqa.selenium.By;

public class LoginPage {

    public By myAccount =
            By.xpath("//span[text()='My Account']");

    public By login =
            By.linkText("Login");

    public By email =
            By.id("input-email");

    public By password =
            By.id("input-password");

    public By loginButton =
            By.xpath("//input[@value='Login']");

    public By editAccountLink =
            By.linkText("Edit your account information");
}