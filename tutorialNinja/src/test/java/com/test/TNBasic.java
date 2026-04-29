package com.test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.util.TNExcel;

public class TNBasic {
	
	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	@BeforeMethod
	public void setup() {
	    System.out.println("Start the test");
	    WebDriver driver1 = new ChromeDriver();
	    driver.set(driver1);
	    driver1.get("https://tutorialsninja.com/demo/");
	    driver1.manage().window().maximize();
	}


	@AfterMethod
	public void tearDown() {
		WebDriver driver1 = driver.get();
		if (driver1 != null)
			driver1.quit();
	}

	@Test(dataProvider="valid",dataProviderClass=TNExcel.class)
	public void valid(String name, String password) {		
		WebDriver driver1 = driver.get();
		driver1.findElement(By.xpath("//i[@class='fa fa-user']")).click();
		WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));

		driver1.findElement(By.xpath("(//a[text()='Login'])[1]")).click();
		driver1.findElement(By.xpath("//input[@name='email']")).sendKeys(name);
		driver1.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver1.findElement(By.xpath("//input[@type='submit']")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h2[text()='My Account']")));
		String actual = driver1.findElement(By.xpath("//h2[text()='My Account']")).getText();
		Assert.assertEquals(actual, "My Account");
		System.out.println("Login successful");
	}

	@Test(dataProvider="invalid", dataProviderClass=TNExcel.class)
	public void Invalid1(String name, String password) {
		WebDriver driver1 = driver.get();
		driver1.findElement(By.xpath("//i[@class='fa fa-user']")).click();
		WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));
		
		driver1.findElement(By.xpath("(//a[text()='Login'])[1]")).click();
		driver1.findElement(By.xpath("//input[@name='email']")).sendKeys(name);
		driver1.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver1.findElement(By.xpath("//input[@type='submit']")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='alert alert-danger alert-dismissible']")));
		String warn = driver1.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		Assert.assertTrue(warn.contains("Warning: No match for E-Mail Address and/or Password."));		
		System.out.println("Invalid handle successful");
	}
	
	@Test
	@Parameters({"txt"})
	public void search(String txt) {
		WebDriver driver1 = driver.get();
		WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(10));
		
		driver1.findElement(By.name("search")).clear();
		driver1.findElement(By.name("search")).sendKeys(txt);
        driver1.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='There is no product that matches the search criteria.']"))); 
        boolean a=driver1.findElement(By.xpath("//p[text()='There is no product that matches the search criteria.']")).isDisplayed();
        //if(driver1.findElements(By.xpath("//p[text()='There is no product that matches the search criteria.']")).size() > 0){
        if(a) {
        	//Assert.assertTrue(true);
            System.out.println("Invalid search");
            
        } else {
            System.out.println("Valid search");
        }
	}

}