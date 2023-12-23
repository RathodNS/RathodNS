package Hooks;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import context.TestContext;
import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfiLoader;

public class MyHooks {

	private WebDriver driver;
	private final TestContext context;
//	public static ExtentTest extenttest;
	public MyHooks(TestContext context) {
		this.context=context;
	}
	
	
	 /**
     * Before is a cucumber hook that executes before each scenario executes
     * Initialization of driver is executed
     *
     * @param scenario - The Scenario object
     */
	@Before
	public void SetupDrivers(Scenario sceanrio) throws Exception {
		driver= DriverFactory.getDriver(ConfiLoader.getInstance().GetBrowser());
		context.driver=driver;
//		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
//		String browserName = caps.getBrowserName();
//		String browserVersion = caps.getBrowserVersion();
		
//		extenttest.log(Status.INFO, "Running in:"+browserName+" "+browserVersion);
		System.out.println("Setting up driver for the Sceanrio:"+sceanrio.getName());
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
		driver.quit();
		System.out.println("*********quit test ***********");
	}
}
