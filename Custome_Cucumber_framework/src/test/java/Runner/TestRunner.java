package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features/logintestsnew.feature", // Path to your feature files
	    glue = "steps",// Package where your step definitions are located
	    monochrome=true,
	    plugin = {"pretty", "html:target/cucumber-reports"} // Plugins for test reporting
		)
public class TestRunner {

}
