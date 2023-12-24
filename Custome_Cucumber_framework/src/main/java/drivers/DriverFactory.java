package drivers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

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
	
	public static RemoteWebDriver getRemoteDriver(String browser,String version,String OS) throws Exception {

		RemoteWebDriver driver=null;
		
		String URL="@hub.lambdatest.com/wd/hub";
		String username = "nandusinghrathod786";
		String accesskey = "xlN3EyaGbymEC8CnSgeO0SVQNVH7NBUt7zPT1OhyS0wps2M1rV";
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", browser);
		caps.setCapability("browserVersion", version);

		HashMap<String,Object> Customoptions = new HashMap<String,Object>();		
		Customoptions.put("platformName", OS);
		Customoptions.put("build", "Build:3");
		Customoptions.put("project", "MultiThreaded");
		Customoptions.put("name", "End-End");
		Customoptions.put("console", "true");
		
		caps.setCapability("LT:Options", Customoptions);
		
		String gridURL = "https://"+username+":"+accesskey+URL;
		System.err.println("Hub URL:"+gridURL);
		driver = new RemoteWebDriver(new URL(gridURL),caps); 
				
		return driver;
	}
}
