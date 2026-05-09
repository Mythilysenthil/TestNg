package definitions;

import java.io.IOException;

import org.testng.Assert;

import actions.HomePageActions;
import actions.LoginPageActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.HelperClass;

public class LoginStepDefinition {
	
	HomePageActions hpa = new HomePageActions();
	LoginPageActions lpa = new LoginPageActions();
	
	@Given("the user is on HRM Page {string}")
	public void the_user_is_on_hrm_page(String string) {
	    HelperClass.openPage(string);
	}

	@When("the user enters username and password")
	public void the_user_enters_username_and_password() throws IOException {
	    lpa.login();
	}

	@Then("user should be able to login successfully and should see {string}")
	public void user_should_be_able_to_login_successfully_and_should_see(String string) {
	   Assert.assertEquals(hpa.getHomePageText(), string);
	}
}
