package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class PageObjectsManager {
	
	private static LoginPage loginPage;
	private static DashboardPage dashboardPage;
	private static CommonObjectsPage commonObjectsPage;
	
	public static LoginPage getLoginPage(RemoteWebDriver driver) {
		
		return loginPage==null? loginPage = new LoginPage(driver):loginPage;
	}

	
public static DashboardPage getDashboardPage(RemoteWebDriver driver) {
		
		return dashboardPage==null? dashboardPage = new DashboardPage(driver):dashboardPage;
	}

public static CommonObjectsPage getCommonObjectsPage(RemoteWebDriver driver) {
    return commonObjectsPage == null ? new CommonObjectsPage(driver) : commonObjectsPage;
}

}
