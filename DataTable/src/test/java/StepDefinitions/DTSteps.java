package StepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DTSteps  {

    WebDriver driver;
    WebDriverWait wait;

    @Given("User is on Home page")
    public void user_is_on_home_page() {

        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
    }

    @When("User enters valid credentials")
    public void user_enters_valid_credentials(DataTable dataTable) {

        List<List<String>> data = dataTable.asLists(String.class);
        String username = data.get(0).get(0);
        String password = data.get(0).get(1);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("login2"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword"))).sendKeys(password);
    }

    @When("when user click the loginlink")
    public void when_user_click_the_login_link() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Log in']"))).click();
    }

    @Then("User should be able to login successfully and new page open")
    public void user_should_be_able_to_login_successfully_and_new_page_open() {

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout2"))).isDisplayed());

        driver.quit();
    }
}