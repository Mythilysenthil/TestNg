package com.test;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public static WebDriver driver;

    private static final Logger log =
            LogManager.getLogger(BaseTest.class);

    @BeforeClass
    public void setup() {

        log.info("Browser launched");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/");

        log.info("Application launched");
    }

    @AfterClass
    public void close() {

        log.info("Browser closed");

        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}