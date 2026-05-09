package stepdefinitions;

import org.testng.Assert;
import utilities.TestData;

import actions.LoginActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {

    LoginActions la = new LoginActions();

    @Given("the user is on login page")
    public void the_user_is_on_login_page() {

        la.clickMyAccount();
        la.clickLogin();
    }

    @When("the user enters the valid email as {string}")
    public void the_user_enters_the_valid_email_as(String email) {

        if (TestData.email != null) {
            la.setEmail(TestData.email);
        } else {
            la.setEmail(email);
        }
    }

    @When("the user enters the valid password as {string}")
    public void the_user_enters_the_valid_password_as(String password) {

        if (TestData.password != null) {
            la.setPassword(TestData.password);
        } else {
            la.setPassword(password);
        }
    }

    @When("click login")
    public void click_login() {

        la.clickLoginButton();
    }

    @Then("the link should appear as {string}")
    public void the_link_should_appear_as(String expectedText) {

        String actualText = la.getLinkText();

        Assert.assertEquals(actualText, expectedText);
    }
}