package definitions;


import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.HelperClass;

public class Hooks {
	
	private static final Logger log = LogManager.getLogger(Hooks.class);
	
	@Before
	public void setUp(Scenario scenario)
	{
		log.info("Scenario started: "+scenario.getName());
		HelperClass.setUpDriver();
	}
	
	@After
	public void tearDown(Scenario scenario) throws IOException
	{
		if(scenario.isFailed())
		{
			TakesScreenshot sc = (TakesScreenshot) HelperClass.getDriver();
			File src = sc.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File("target/screenshots/"+scenario.getName()+System.currentTimeMillis()+".png"));
			
			byte[] img = sc.getScreenshotAs(OutputType.BYTES);
			scenario.attach(img, "image/png", "Failure Screenshot");
			
			log.error("Scenario failed: "+scenario.getName());
			
		}
		else
		{
			log.info("Scenario passed: "+scenario.getName());
		}
		
		HelperClass.tearDown();
	}
}
