package stepdefinitions;

import java.util.List;

import org.testng.Assert;
import utilities.TestData;

import actions.RegisterActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStepDefinition {

    RegisterActions ra =
            new RegisterActions();

    @Given("the user is on register page")
    public void the_user_is_on_register_page() {

        ra.clickMyAccount();
        ra.clickRegister();
    }

    @When("the user enters the valid cedentials")
    public void the_user_enters_the_valid_cedentials(DataTable dataTable) {

        List<List<String>> data =
                dataTable.asLists();

        ra.setFirstName(
                data.get(0).get(0));

        ra.setLastName(
                data.get(0).get(1));

        String email =
                data.get(0).get(2);

        String generatedEmail =
                email.split("@")[0]
                + System.currentTimeMillis()
                + "@gmail.com";

        ra.setEmail(generatedEmail);

        TestData.email = generatedEmail;
        TestData.password = data.get(0).get(4);

        ra.setTelephone(
                data.get(0).get(3));

        ra.setPassword(
                data.get(0).get(4));

        ra.setConfirmPassword(
                data.get(0).get(5));
    }

    @When("click continue")
    public void click_continue() {

        ra.clickAgree();
        ra.clickContinue();
    }

    @Then("the greet message should appear as {string}")
    public void the_greet_message_should_appear_as(String expectedMessage) {

        String actualMessage =
                ra.getSuccessMessage();

        Assert.assertEquals(
                actualMessage,
                expectedMessage);
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {

        boolean status =
                ra.verifyLogout();

        Assert.assertTrue(status);
    }
}