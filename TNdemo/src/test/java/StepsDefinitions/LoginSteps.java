package StepsDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    String actualMessage;

    @Given("User on the Home Page")
    public void user_is_on_home_page() {
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();
    }
    
    @Given("User clicks on Login link")
    public void user_clicks_on_login_link() {
    	WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
        login.click();
    }

    @When("User enters valid username as {string} and password as {string}")
    public void user_enters_valid_username_as_and_password_as(String string, String string2) {
    	driver.findElement(By.id("input-email")).sendKeys(string);
        driver.findElement(By.id("input-password")).sendKeys(string);        
    }

    @When("when user click the login link")
    public void when_user_click_the_login_link() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();)
    }

    @Then("User should be able to see the dashboard")
    public void user_should_be_able_to_see_the_dashboard() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User enters invalid username as {string} and password as {string}")
    public void user_enters_invalid_username_as_and_password_as(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("User should be able to see the {string}")
    public void user_should_be_able_to_see_the(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
