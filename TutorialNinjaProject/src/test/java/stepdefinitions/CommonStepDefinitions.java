package stepdefinitions;

import io.cucumber.java.en.Given;

public class CommonStepDefinitions {

    @Given("the user launches the application")
    public void the_user_launches_the_application() {

        System.out.println("Application launched");
    }
}