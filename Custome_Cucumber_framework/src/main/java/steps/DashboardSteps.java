package steps;

import org.openqa.selenium.remote.RemoteWebDriver;

import drivers.RemoteDriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonObjectsPage;
import pages.DashboardPage;

public class DashboardSteps {

	public RemoteWebDriver driver = RemoteDriverFactory.getDriver();
	private final DashboardPage DashboardPage=new DashboardPage(driver);
	private final CommonObjectsPage CommonObjectsPage= new CommonObjectsPage(driver);
	
//	public DashboardSteps(TestContext context) {
//	 DashboardPage = new DashboardPage(context.driver);
//	 CommonObjectsPage = new CommonObjectsPage(context.driver);
//	}
	
//	public DashboardSteps(TestContext context) {
//		 DashboardPage = PageObjectsManager.getDashboardPage(context.driver);
//		 CommonObjectsPage = PageObjectsManager.getCommonObjectsPage(context.driver);
//		}
	
		
	@When("user clicks on Admin menu from left panel")
	public void user_clicks_on_admin_menu_from_left_panel() {
	   DashboardPage.AdminIcon.click();
	}
	@Then("User Management page should be displayed")
	public void user_management_page_should_be_displayed() {
	   CommonObjectsPage.verifyElementExist(DashboardPage.UsermanagementTitle, "Admin/user mgt title");
	}
	@When("user Selects Nationalities from the available option")
	public void user_selects_nationalities_from_the_available_option() throws Exception {
		CommonObjectsPage.waitforElementToBeclickable(DashboardPage.Nationalities);
	    DashboardPage.Nationalities.click();
	}
	@Then("User should be navigated to Nationalities page")
	public void user_should_be_navigated_to_nationalities_page() {
	    CommonObjectsPage.verifyElementExist(DashboardPage.NationalitypageTitle, "Nationality page title");
	}
	@When("user clicks on Add nationality button")
	public void user_clicks_on_add_nationality_button() {
	   DashboardPage.AddNationalitybutton.click();
	}
	@Then("Verify user gets option to enter the nationlaity")
	public void verify_user_gets_option_to_enter_the_nationlaity() throws Exception {
	    CommonObjectsPage.waitforElementToBeVisible(DashboardPage.NationalityNametxtbox, 10);
	    CommonObjectsPage.verifyElementExist(DashboardPage.NationalityNametxtbox, "text box to enter nationality");
	}
}
