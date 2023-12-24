package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import utilities.WebUtils;

public class LoginPage extends WebUtils {

	public LoginPage(RemoteWebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='username']")
	public WebElement usernametxbox;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement Passwordtxbox;
	
	@FindBy(xpath="//button[text()=' Login ']")
	public WebElement LogginButton;
	
	@FindBy(xpath="//h6[text()='Dashboard']")
	public WebElement Dashboard;

	
}
