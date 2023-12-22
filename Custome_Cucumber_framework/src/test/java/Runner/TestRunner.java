package Runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = "src/test/java/features", // Path to feature files
	    glue = {"steps","Hooks"},// Package where your step definitions are located
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
