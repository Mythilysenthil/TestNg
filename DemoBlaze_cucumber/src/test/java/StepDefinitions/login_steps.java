package StepDefinitions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Hooks.hooks;
import io.cucumber.java.en.*;

public class login_steps {

    @Given("User clicks on Login link")
    public void user_clicks_on_login_link() {
        hooks.wait.until(
            ExpectedConditions.elementToBeClickable(By.id("login2"))).click();
    }

    @When("User enters username {string}")
    public void user_enters_username(String username) {

        WebElement user = hooks.wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        user.clear();
        user.sendKeys(username);
    }

    @When("User enters password {string}")
    public void user_enters_password(String password) {

        WebElement pass = hooks.wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword")));
        pass.clear();
        pass.sendKeys(password);
    }

    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {

        hooks.wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Log in']"))).click();
    }

    @Then("User should see the welcome message with username")
    public void verify_welcome_message() {

        String welcomeMsg = hooks.wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser"))).getText();

        System.out.println("Actual Welcome Message: " + welcomeMsg);

        Assert.assertTrue(
            welcomeMsg.equalsIgnoreCase("Welcome admin"),
            "Expected message not matched. Actual: " + welcomeMsg);
    }

    @Then("User should see an error alert message")
    public void user_should_see_error_alert_message() {

        Alert alert = hooks.wait.until(ExpectedConditions.alertIsPresent());

        System.out.println("Error Alert: " + alert.getText());
        alert.accept();
    }

    @Then("User should see an alert for empty credentials")
    public void user_should_see_empty_credentials_alert() {

        Alert alert = hooks.wait.until(ExpectedConditions.alertIsPresent());

        System.out.println("Empty Alert: " + alert.getText());
        alert.accept();
    }
}