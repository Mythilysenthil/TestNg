package StepsDefinitions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ScLogin {

    WebDriver driver;
    WebDriverWait wait;
    String actualMessage;

    @Given("User is on Home page")
    public void user_is_on_home_page() {
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("User enters username as {string}  and password as {string}")
    public void user_enters_username_as_and_password_as(String username, String password) {

        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("login2")));
        loginBtn.click();

        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        usernameField.sendKeys(username);

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword")));
        passwordField.sendKeys(password);
    }

    @When("when user click the login link")
    public void when_user_click_the_login_link() {

        WebElement loginSubmit = wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Log in']")));
        loginSubmit.click();

        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            actualMessage = alert.getText();
            alert.accept();
        } catch (Exception e) {
            actualMessage = "Please fill out Username and Password.";
        }
    }

    @Then("User should be able to see an {string}")
    public void user_should_be_able_to_see_an(String expectedMessage) {

        System.out.println("Actual Message: " + actualMessage);
        Assert.assertEquals(actualMessage, expectedMessage);

        driver.quit();
    }
}