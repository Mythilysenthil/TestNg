package actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import hooks.Hooks;
import pages.RegisterPage;

public class RegisterActions {

    RegisterPage rp = new RegisterPage();

    private static final Logger log =
            LogManager.getLogger(RegisterActions.class);

    public void clickMyAccount() {

        Hooks.getDriver()
                .findElement(rp.myAccount)
                .click();
    }

    public void clickRegister() {

        Hooks.getDriver()
                .findElement(rp.register)
                .click();

        log.info("Clicked Register");
    }

    public void setFirstName(String firstname) {

        Hooks.getDriver()
                .findElement(rp.firstName)
                .sendKeys(firstname);
    }

    public void setLastName(String lastname) {

        Hooks.getDriver()
                .findElement(rp.lastName)
                .sendKeys(lastname);
    }

    public void setEmail(String email) {

        Hooks.getDriver()
                .findElement(rp.email)
                .sendKeys(email);
    }

    public void setTelephone(String phone) {

        Hooks.getDriver()
                .findElement(rp.telephone)
                .sendKeys(phone);
    }

    public void setPassword(String password) {

        Hooks.getDriver()
                .findElement(rp.password)
                .sendKeys(password);
    }

    public void setConfirmPassword(String password) {

        Hooks.getDriver()
                .findElement(rp.confirmPassword)
                .sendKeys(password);
    }

    public void clickAgree() {

        Hooks.getDriver()
                .findElement(rp.agree)
                .click();
    }

    public void clickContinue() {

        Hooks.getDriver()
                .findElement(rp.continueButton)
                .click();

        log.info("Clicked Continue");
    }

    public String getSuccessMessage() {

        return Hooks.getDriver()
                .findElement(rp.successMessage)
                .getText();
    }

    public boolean verifyLogout() {

        return Hooks.getDriver()
                .findElement(rp.logout)
                .isDisplayed();
    }
}