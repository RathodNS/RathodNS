package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import utilities.WebUtils;

public class DashboardPage extends WebUtils {

	public DashboardPage(RemoteWebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[text()='Admin']")
	public WebElement AdminIcon; 
	
	@FindBy(xpath="//a[text()='Nationalities']")
	public WebElement Nationalities; 
	
	@FindBy(xpath="//h6[text()='Nationalities']/following-sibling::div/button")
	public WebElement AddNationalitybutton; 
	
	@FindBy(xpath="//h6[text()='User Management']")
	public WebElement UsermanagementTitle;
	
	@FindBy(xpath="//h6[text()='Nationalities']")
	public WebElement NationalitypageTitle;
	
	@FindBy(xpath="//label[text()='Name']")
	public WebElement NationalityNametxtbox;
}
