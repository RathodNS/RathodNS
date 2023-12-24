package steps;

import org.openqa.selenium.remote.RemoteWebDriver;

import drivers.RemoteDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonObjectsPage;
import pages.LoginPage;
import utilities.ConfiLoader;

public class LoginSteps {
	
//	private  LoginPage LoginPage;
//	private  CommonObjectsPage CommonObjectsPage;
	
//	public LoginSteps(TestContext context) {
//		LoginPage = PageObjectsManager.getLoginPage(context.driver);
//		CommonObjectsPage = PageObjectsManager.getCommonObjectsPage(context.driver);
//	}
	public RemoteWebDriver driver = RemoteDriverFactory.getDriver();
	private final LoginPage LoginPage = new LoginPage(driver);
	private final CommonObjectsPage CommonObjectsPage = new CommonObjectsPage(driver);



	
	@Given("user is on the login Page of APplication")
	public void user_is_on_the_login_page_of_a_pplication() throws Exception {
	    LoginPage.LoadApplication();
	    CommonObjectsPage.verifyElementExist(LoginPage.usernametxbox, "username textbox");
	    Thread.sleep(10000);
	}

	@Given("user enters the username")
	public void user_enters_the_username() {
		LoginPage.usernametxbox.sendKeys(ConfiLoader.getInstance().getUsername());
	}

	@Given("user enters the password")
	public void user_enters_the_password() {
	    LoginPage.Passwordtxbox.sendKeys(ConfiLoader.getInstance().getPassword());
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
	   LoginPage.LogginButton.click();
	}

	@Then("user should land on home page of Application")
	public void user_should_land_on_home_page_of_application() {
	   CommonObjectsPage.verifyElementExist(LoginPage.Dashboard, "Dashboard Title");
	}

}

