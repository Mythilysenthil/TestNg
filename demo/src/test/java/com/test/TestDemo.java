package com.test;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.util.Excel;
@Listeners(ListernerClass.class)
public class TestDemo {
    
	
	private static final Logger log = LogManager.getLogger(TestDemo.class);

	WebDriver driver;
	@BeforeMethod
	@Parameters("URL")
	public void setup(String url) {
		driver = new ChromeDriver();
		log.info("Started the browse...");
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "valid", dataProviderClass = DataproviderDemo.class)
	public void validlogin(String username, String password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.id("login2")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));

		driver.findElement(By.id("loginusername")).sendKeys(username);
		driver.findElement(By.id("loginpassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));

		String validtxt = driver.findElement(By.id("nameofuser")).getText();
		Assert.assertTrue(validtxt.contains("Welcome"));
		log.info("Valid login successful");
	}

	@Test(dataProvider = "invalid", dataProviderClass = Excel.class)
	public void invalidlogin(String username, String password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.findElement(By.id("login2")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));

		driver.findElement(By.id("loginusername")).sendKeys(username);
		driver.findElement(By.id("loginpassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();

		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		
		Assert.assertTrue(alertText.contains("Wrong password."));
		log.warn("Invalid login verified...");
	}
	
	public WebDriver getDriver() {
	    return driver;
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			log.info("Closing the browse...");
			driver.quit();
		}
	}        
}
