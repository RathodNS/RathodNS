package Runner;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import constants.ExecutionTarget;
import drivers.Driver;
import drivers.DriverFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import utilities.ConfiLoader;

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
	
	
	private TestNGCucumberRunner testNG_Cucumber;
	
	@BeforeClass(alwaysRun = true)
	public void setUpCucumber() {
		this.testNG_Cucumber = new TestNGCucumberRunner(this.getClass());
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters({ "browser","version","OS" })
	public void setupDriver(String browser,String version, String OS) throws Exception {
		RemoteWebDriver driver;

		ExecutionTarget executionEnvTarget = ConfiLoader.getInstance().getTarget();

		switch (executionEnvTarget) {
		case Remote:
			driver = DriverFactory.getRemoteDriver(browser,version,OS);
			Driver.initializeDriver(driver);
			break;
		case Local:
			driver = (RemoteWebDriver) DriverFactory.getDriver(ConfiLoader.getInstance().GetBrowser(browser));
			Driver.initializeDriver(driver);
			break;
		}

	}
	
	@DataProvider(parallel=true)
	public Object[][] features() {
		return testNG_Cucumber.provideScenarios();
	}
	
	

	@AfterClass
	public void tearDown() {
		testNG_Cucumber.finish();
		Driver.quitDriver();
	}
}
