package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    plugin = {"pretty","html:target/cucumber-reports/Cucumber.html"},
	    features = "src/test/resources/com.features",
	    glue = {"StepDefinitions", "Hooks"}
	)
public class TestngRunner extends AbstractTestNGCucumberTests {
}