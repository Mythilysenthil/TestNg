package com.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.pages.DashBoardPage;
import com.pages.LoginPage;

public class BaseTest {

	public WebDriver driver;
	LoginPage objLogin;
	DashBoardPage objDashboardPage;
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	@AfterClass
	public void close() {
		driver.close();
	}
}
