package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import utilities.WaitUtils;

public class CommonObjectsPage extends BasePage {

	public CommonObjectsPage(RemoteWebDriver driver) {
		super(driver);
	}

	WaitUtils wait = new WaitUtils(driver);

	public void navigateToIframe(String framename) {

		driver.switchTo().frame(framename);

	}

	public void isChildWindowOpened(Set<String> handelCount, String Action) {
		Assert.assertTrue(handelCount.size() > 1, "Child was not opened at:" + Action);
	}

	public String getWindowHandel() {
		return driver.getWindowHandle();
	}

	public Set<String> getWindowHandels() {
		return driver.getWindowHandles();
	}

	public void swithcToWindow(String windowHandels) {
		driver.switchTo().window(windowHandels);
	}

	public void SwitchToChildWindow(String ParentWindowHandle, Set<String> WindowHandles, String atLocation) {
		boolean SwithcedToChild = false;
		if (WindowHandles.size() > 1) {
			for (String childWindow : WindowHandles) {
				if (!childWindow.equals(ParentWindowHandle)) {
					driver.switchTo().window(childWindow);
					SwithcedToChild = true;
				}

			}
		}

		Assert.assertTrue(SwithcedToChild, "Couldn't Switched to child Window:" + atLocation);
	}

	public void SwitchToParentWindow() {

		Set<String> windows1 = driver.getWindowHandles();
		List<String> windowList1 = new ArrayList<>(windows1);
		driver.switchTo().window(windowList1.get(0));

	}

	public void verifyElementExist(WebElement ele, String ElementName) {
		Assert.assertTrue(ele.isDisplayed(), "element not Present on UI:" + ElementName);

	}

	public void waitforElementToBeclickable(WebElement ele) throws Exception {
		wait.waitForElementToBeClickable(ele);
	}

	public void waitforElementToBeVisible(WebElement ele, int duration) throws Exception {
		wait.waitForVisibilityOfElement(ele, duration);
	}

	public void waitForTime(int time) throws InterruptedException {
		wait.waitForSeconds(time);
	}

	public String GetElementText(WebElement ele) {
		return ele.getText();
	}

	public int ConverStringToInt(String text) {
		return Integer.parseInt(text);
	}

	public void JavaScriptClick(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
	}

}
