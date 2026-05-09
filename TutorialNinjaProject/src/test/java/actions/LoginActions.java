package actions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hooks.Hooks;
import pages.LoginPage;

public class LoginActions {

    LoginPage lp = new LoginPage();

    private static final Logger log =
            LogManager.getLogger(LoginActions.class);

    public void clickMyAccount() {

        Hooks.getDriver()
                .findElement(lp.myAccount)
                .click();

        log.info("Clicked My Account");
    }

    public void clickLogin() {

        Hooks.getDriver()
                .findElement(lp.login)
                .click();

        log.info("Clicked Login");
    }

    public void setEmail(String email) {

        Hooks.getDriver()
                .findElement(lp.email)
                .sendKeys(email);

        log.info("Email entered");
    }

    public void setPassword(String password) {

        Hooks.getDriver()
                .findElement(lp.password)
                .sendKeys(password);

        log.info("Password entered");
    }

    public void clickLoginButton() {

        Hooks.getDriver()
                .findElement(lp.loginButton)
                .click();

        log.info("Login button clicked");
    }

    public String getLinkText() {

        WebDriverWait wait = new WebDriverWait(
                Hooks.getDriver(), Duration.ofSeconds(10));

        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                lp.editAccountLink))
                .getText();
    }
}