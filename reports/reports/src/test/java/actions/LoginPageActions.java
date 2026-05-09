package actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import pages.LoginPage;
import utilities.HelperClass;

public class LoginPageActions {
	
	
	LoginPage locator;
	
	public LoginPageActions() {
		locator = new LoginPage();
		PageFactory.initElements(HelperClass.getDriver(), locator);
	}
	
	public void setUsername(String name)
	{
		locator.username.sendKeys(name);
	}
	
	public void setPassword(String password)
	{
		locator.password.sendKeys(password);
	}
	
	public void clickLogin()
	{
		locator.loginButton.click();
	}
	
	public void login() throws IOException
	{ 
		FileInputStream fis = new FileInputStream(new File("src/test/resources/data.properties"));
		
		Properties prop = new Properties();
		prop.load(fis);
		
		setUsername(prop.getProperty("username"));
		setPassword(prop.getProperty("password"));
		clickLogin();
	}
}

