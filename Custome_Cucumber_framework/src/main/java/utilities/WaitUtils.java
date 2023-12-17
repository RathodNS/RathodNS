package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class WaitUtils extends BasePage {
	int webDriverWaitTime =160;
	public WaitUtils(WebDriver driver) {
		super(driver);
	}


	 public void waitForVisibilityOfElement(WebElement element) throws Exception {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(webDriverWaitTime));

	        wait.until(ExpectedConditions.visibilityOf(element));
	    }

	    /**
	     * wait for a specific time for the element to be invisible
	     *
	     * @param - element to be interacted
	     */
	    public void waitForVisibilityOfElement(WebElement elem, int timeDuration) throws Exception {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeDuration));
//	        WebDriverWait wait = new WebDriverWait(driver, webDriverWaitTime);
	        wait.until(ExpectedConditions.visibilityOf(elem));
	    }

	    /**
	     * wait for a specific time for the element to be clickable
	     *
	     * @param - element to be interacted
	     */
	    public void waitForElementToBeClickable(WebElement element) throws Exception {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(webDriverWaitTime));
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	    }

	    /**
	     * wait for a specific time for url to contain specific text
	     *
	     * @param - urlfraction
	     */
	    public void waitForUrlToContain(String urlFraction) throws Exception {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(webDriverWaitTime));
//	        WebDriverWait wait = new WebDriverWait(driver, webDriverWaitTime);
	        wait.until(ExpectedConditions.urlContains(urlFraction));
	    }

	    /**
	     * wait for some seconds
	     */
	    public void waitForSeconds(int seconds) throws InterruptedException {
	        Thread.sleep(seconds * 1000);
	    }
	    public void waiForInvisibilityofElement(WebElement ele) {
	    	wait.until(ExpectedConditions.invisibilityOf(ele));
	    }
	
}
