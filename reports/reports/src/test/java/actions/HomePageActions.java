package actions;

import org.openqa.selenium.support.PageFactory;

import pages.HomePage;
import utilities.HelperClass;

public class HomePageActions {
	HomePage locator = null;
	
	public HomePageActions() {
		locator = new HomePage();
		PageFactory.initElements(HelperClass.getDriver(), locator);
	}
	
	public String getHomePageText() {
		return locator.homePageUserName.getText();
	}
}
