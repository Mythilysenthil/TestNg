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
import org.testng.annotations.Test;


import com.util.DPExcel;

@Listeners(ListenerDemo.class)

public class LoginTest {

	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public static Logger log = LogManager.getLogger(LoginTest.class);

	@BeforeMethod
	public void setup() {
	    System.out.println("Start the test");
	    WebDriver driver1 = new ChromeDriver();
	    driver.set(driver1);
	    driver1.get("https://www.demoblaze.com/");
	    log.info("Loading browser...");
	    driver1.manage().window().maximize();
	}


	@AfterMethod
	public void tearDown() {
		WebDriver driver1 = driver.get();
		if (driver1 != null)
			driver1.quit();
	}
	
	public WebDriver getDriver() {
        return driver.get();
    }

	@Test(dataProvider="valid",dataProviderClass=DPExcel.class)
	public void valid(String name, String password) {
		WebDriver driver1 = driver.get();
		driver1.findElement(By.id("login2")).click();
		WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(name);
		driver1.findElement(By.id("loginpassword")).sendKeys(password);
		driver1.findElement(By.xpath("//button[text()='Log in']")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@id=\"nameofuser\"]")));
		String actual = driver1.findElement(By.xpath("//a[@id=\"nameofuser\"]")).getText();
		System.out.println(actual);
		Assert.assertEquals(actual, "Welcome admin");
		log.info("Valid login...");
	}

	@Test(dataProvider="invalid", dataProviderClass=DPExcel.class)
	public void Invalid1(String name, String password) {
		WebDriver driver1 = driver.get();
		driver1.findElement(By.id("login2")).click();

		WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(name);
		driver1.findElement(By.id("loginpassword")).sendKeys(password);
		driver1.findElement(By.xpath("//button[text()='Log in']")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver1.switchTo().alert();
		alert.accept();
		System.out.println("Invalid 1 run successful!");
		
		log.error("Invalid login...");
		
	}

}