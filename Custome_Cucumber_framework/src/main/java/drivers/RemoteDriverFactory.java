package drivers;

import java.util.Objects;

import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteDriverFactory {
	
	private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	
	public static RemoteWebDriver getDriver() {
		return driver.get();
	}
	
	public static void setDriver(RemoteWebDriver driveref) {
		if(Objects.nonNull(driveref)) {
		      driver.set(driveref);
		}
	}
	
	public static void destroy() {
		driver.remove();
	}
	
}
