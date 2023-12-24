package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import drivers.RemoteDriverFactory;
import pages.BasePage;
/**
 * 
 * @author rathod.singh
 *All Common methods like Click, Settext, clear and settext, selectoptions from drop-down etc. needs to be here
 */
public class WebUtils extends BasePage {


	public WebUtils(RemoteWebDriver driver) {
		super(driver);
	}
	protected RemoteWebDriver driver=RemoteDriverFactory.getDriver();

	public void setTextMethod(WebElement element, String text) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.clear();
		element.sendKeys(text);
	}

	public void clearAndSetTextMethod(WebElement ele, String text) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.clear();
		ele.sendKeys(text);
	}

	public void click(WebElement element) throws Exception {
		ScrollToElementusingActions(element);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public List<WebElement> findelementsMethodXpath(String xpath) {

		return driver.findElements(By.xpath(xpath));
	}

	public WebElement findelementMethodXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public String formatString(String xpath, String value) {
		return String.format(xpath, value);
	}

	public void navigate(String url) {
		super.driver.navigate().to(url);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getText(WebElement element) {
		return element.getText();
	}

	public String getTextValue(WebElement elem) {
		return elem.getAttribute("value").trim();
	}

	public void ScrollToElementusingActions(WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele);
		action.perform();
	}

	public void isElementVisible(WebElement ele,String ElementName) {
		
		Assert.assertTrue(ele.isDisplayed(),"Element not Displayed:"+ElementName);

	}

	protected boolean isElementVisible(WebElement webe) {
		boolean isVisible;
		try {
//			WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
//			shortWait.until(ExpectedConditions.visibilityOfElementLocated(webe));
			wait.until(ExpectedConditions.visibilityOf(webe));
			isVisible = true;
		}
		catch(Exception e) {
			isVisible = false;
		}
		return isVisible;
	}
	public void refresh() {
		driver.navigate().refresh();
	}

	public void clickOnEnter() {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).build().perform();
	}

	public void hoverOverElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void clickOnElementUsingAction(WebElement element) {
		Actions builder = new Actions(driver);
		builder.click(element);
		Action action = builder.build();
		action.perform();
	}

}
	 
	


