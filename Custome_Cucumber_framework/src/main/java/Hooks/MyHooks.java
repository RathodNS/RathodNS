package Hooks;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import constants.ExecutionTarget;
import drivers.Driver;
import drivers.RemoteDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfiLoader;

public class MyHooks {

//	private WebDriver driver;

	private RemoteWebDriver driver = RemoteDriverFactory.getDriver();
	
	 /**
     * Before is a cucumber hook that executes before each scenario executes
     * Initialization of driver is executed
     *
     * @param scenario - The Scenario object
     */
		@Before
		public void SetupDrivers(Scenario sceanrio) throws Exception {
			ExecutionTarget target = ConfiLoader.getInstance().getTarget();
			if(target==ExecutionTarget.Remote) {
	        driver.executeScript("lambda-name=" + sceanrio.getName());
	        }
			System.out.println("Started Execution for the Sceanrio:" + sceanrio.getName());
		}
	
	
	/**
     * After is a cucumber hook that executes after each scenario executes
     * Screenshot is captured for each failure after each scenario
     *
     * @param scenario - The Scenario object
     */
	@After
	public void after(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			File SourceFile =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] filecontent = FileUtils.readFileToByteArray(SourceFile);
			scenario.attach(filecontent, "image/png", "image");
		}
//		driver.quit();
		System.out.println(driver.getSessionId());
		Driver.quitDriver();
		System.out.println("*********quit test ***********");
	}
}
