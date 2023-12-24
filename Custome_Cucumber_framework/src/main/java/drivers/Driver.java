package drivers;

import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.remote.RemoteWebDriver;

public class Driver {

	public Driver() {
		
	}
	
	public static void initializeDriver(RemoteWebDriver driver) {
		if(Objects.isNull(RemoteDriverFactory.getDriver())) {
			RemoteDriverFactory.setDriver(driver);
			RemoteDriverFactory.getDriver().manage().window().maximize();
			RemoteDriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
	}
	
	public static void quitDriver() {
		if(Objects.nonNull(RemoteDriverFactory.getDriver())) {
			RemoteDriverFactory.getDriver().quit();
			RemoteDriverFactory.destroy();
		}
	}
}
