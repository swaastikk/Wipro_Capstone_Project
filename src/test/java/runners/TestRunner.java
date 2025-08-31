package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "features", 
				glue = { "stepDefinitions", "hooks" },
				plugin = { "pretty", "html:reports/cucumber.html","json:reports/cucumber.json" }, 
				monochrome = true
				)
public class TestRunner extends AbstractTestNGCucumberTests {
}
