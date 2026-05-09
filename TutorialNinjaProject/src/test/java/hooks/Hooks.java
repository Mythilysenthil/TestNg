package hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://tutorialsninja.com/demo/");
    }

    @After
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}