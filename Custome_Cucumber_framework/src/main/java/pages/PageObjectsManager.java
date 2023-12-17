package pages;

import org.openqa.selenium.WebDriver;

public class PageObjectsManager {
	
	private static LoginPage loginPage;
	private static DashboardPage dashboardPage;
	private static CommonObjectsPage commonObjectsPage;
	
	public static LoginPage getLoginPage(WebDriver driver) {
		
		return loginPage==null? loginPage = new LoginPage(driver):loginPage;
	}

	
public static DashboardPage getDashboardPage(WebDriver driver) {
		
		return dashboardPage==null? dashboardPage = new DashboardPage(driver):dashboardPage;
	}

public static CommonObjectsPage getCommonObjectsPage(WebDriver driver) {
    return commonObjectsPage == null ? new CommonObjectsPage(driver) : commonObjectsPage;
}

}
