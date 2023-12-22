package drivers;

import org.openqa.selenium.WebDriver;

import browserOption.BrowserOptions;
import constants.DriverType;


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
//	public static WebDriver getDriver(String browserName) {
	public static WebDriver getDriver(DriverType browserName) {

		WebDriver driver;
		BrowserOptions options = new BrowserOptions();
		
		switch(browserName) {
		
		case CHROME:
			driver =options.SetChromeOptions();
			break;
		case FIREFOX:
			driver= options.SetFireFoxOptions();
			break;
		case EDGE:
			driver = options.SetEdgeOptions();
			break;
		case SAFARI:
			driver = options.setSafariOptions();
			break;	
			default:
				throw new IllegalArgumentException("INVALID BROWSER: "+browserName);
		}		
		return driver;
	}
	
}
