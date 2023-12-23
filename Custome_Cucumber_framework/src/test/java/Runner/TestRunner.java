package Runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * This Class starts the execution using given cucumber options
 * @author Rathod
 *Here Runner class extending AbstractTestNGCucumberTests class to integrate our cucumber Tests with TestNG
 * And overriding Scenarios method of this class to pass features and Scenarios as data providers
 */
@CucumberOptions(
		features = "src/test/java/features", // Path to feature files
	    glue = {"steps","Hooks"},// Package where your step definitions and hooks are located
	    monochrome=true,
	    plugin = {"pretty", "html:target/cucumber-reports","summary",
	    		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} // Plugins for test reporting
		)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}

}
