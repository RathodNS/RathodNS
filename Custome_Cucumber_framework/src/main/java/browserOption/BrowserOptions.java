package browserOption;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;


/**
 * This class is responsible to set the browser options and initilize the driver for the respective browser
 * and returns the driver instance to calling method
 * @author Rathod
 *
 */
public class BrowserOptions {

	WebDriver driver;
	
	/**
	 * here we are setting up chrom browser options and initilizing the chrome driver
	 * @return
	 */
	public WebDriver SetChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("incognito");
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-gpu");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		return driver;
	}

	/**
	 * here we are setting up FireFox browser options and initilizing the FireFox driver
	 * @return
	 */
	public WebDriver SetFireFoxOptions() {
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--incognito");

		driver = new FirefoxDriver(options);
		return driver;
	}

	/**
	 * here we are setting up Edge browser options and initilizing the Edge driver
	 * @return
	 */
	public WebDriver SetEdgeOptions() {
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("-inprivate");

		driver = new EdgeDriver(options);
		return driver;
	}

	/**
	 * here we are initilizing the Safari driver
	 * @return
	 */
	public WebDriver setSafariOptions() {
		SafariOptions options = new SafariOptions();
		return driver;
	}
	
}
