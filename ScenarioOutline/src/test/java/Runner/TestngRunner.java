package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    plugin = {"pretty","html:target/cucumber-reports/Cucumber.html"},
	    features = "src/test/resources/SCDemo.feature",
	    glue = {"StepsDefinitions"}
	)
public class TestngRunner extends AbstractTestNGCucumberTests {
}