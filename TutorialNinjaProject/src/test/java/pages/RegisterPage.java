package pages;

import org.openqa.selenium.By;

public class RegisterPage {

    public By myAccount =
            By.xpath("//span[text()='My Account']");

    public By register =
            By.linkText("Register");

    public By firstName =
            By.id("input-firstname");

    public By lastName =
            By.id("input-lastname");

    public By email =
            By.id("input-email");

    public By telephone =
            By.id("input-telephone");

    public By password =
            By.id("input-password");

    public By confirmPassword =
            By.id("input-confirm");

    public By agree =
            By.name("agree");

    public By continueButton =
            By.xpath("//input[@value='Continue']");

    public By successMessage =
            By.xpath("//div[@id='content']/h1");

    public By logout =
            By.linkText("Logout");
}