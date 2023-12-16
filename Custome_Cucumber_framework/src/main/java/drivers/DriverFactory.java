package drivers;

import org.openqa.selenium.WebDriver;

import browserOption.BrowserOptions;


/**
 * This class is used to initilize driver and returning driver instance to calling method
 * @author Rathod
 *
 */
public class DriverFactory {

	/**
	 * this method calls browser options class and sets up the respectiver browser options for the given browser and sets the driver 
	 * @param browserName as paramter
	 * @return the WebDriver instance
	 */
	public static WebDriver getDriver(String browserName) {
		WebDriver driver;
		BrowserOptions options = new BrowserOptions();
		
		switch(browserName) {
		
		case "chrome":
			driver =options.SetChromeOptions();
			break;
		case "firefox":
			driver= options.SetFireFoxOptions();
			break;
		case "edge":
			driver = options.SetEdgeOptions();
			break;
		case "safari":
			driver = options.setSafariOptions();
			break;	
			default:
				throw new IllegalArgumentException("INVALID BROWSER: "+browserName);
		}		
		return driver;
	}
	
}
