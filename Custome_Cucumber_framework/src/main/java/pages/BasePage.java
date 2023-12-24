package pages;

import java.time.Duration;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.RemoteDriverFactory;
import utilities.ConfiLoader;

public class BasePage {

	protected RemoteWebDriver driver;
	protected WebDriverWait wait;
	
	public BasePage(RemoteWebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(50));
		PageFactory.initElements(driver, this);
	}
	
	public void LoadApplication() throws Exception {
		RemoteDriverFactory.getDriver().get(ConfiLoader.getInstance().getBaseUrl());
//		driver.get(ConfiLoader.getInstance().getBaseUrl());
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);
	}
	
}
