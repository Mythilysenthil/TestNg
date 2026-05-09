package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(xpath = "//input[@name = \"username\"]")
	public WebElement username;
	
	@FindBy(xpath = "//input[@name = \"password\"]")
	public WebElement password;
	
	@FindBy(xpath = "//button[text() = \" Login \"]")
	public WebElement loginButton;
}
