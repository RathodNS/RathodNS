package Hooks;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import context.TestContext;
import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks {

	private WebDriver driver;
	private final TestContext context;
	public MyHooks(TestContext context) {
		this.context=context;
	}
	
	@Before
	public void SetupDrivers(Scenario sceanrio) throws Exception {
		driver= DriverFactory.getDriver("Chrome");
		context.driver=driver;
		System.out.println("Setting up driver for the Sceanrio:"+sceanrio.getName());
	}
	
	
	@After
	public void after(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			File SourceFile =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] filecontent = FileUtils.readFileToByteArray(SourceFile);
			scenario.attach(filecontent, "image/png", "image");
		}
	}
}
