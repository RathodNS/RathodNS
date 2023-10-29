package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginTestSteps {
	public static WebDriver driver;

	@Given("User is on Login Page")
	public void user_is_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
//	    throw new io.cucumber.java.PendingException();
	}
//	@And("User enters UserName and Password")
	@And("User enters {string} and {string}")
	public void user_enters_user_name_and_password(String username,String Password ) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement usernamebox= driver.findElement(By.name("username"));
		usernamebox.click();
		usernamebox.sendKeys(username);
		
		WebElement Passbox = driver.findElement(By.name("password"));
		Passbox.click();
		Passbox.sendKeys(Password);
//	    throw new io.cucumber.java.PendingException();
	}
	@When("user clicks on logi button")
	public void user_clicks_on_logi_button() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//button[@type='submit']")).click();
//	    throw new io.cucumber.java.PendingException();
	}
	@Then("Message displayed Login Successfully")
	public void message_displayed_login_successfully() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Page title is:"+driver.getTitle());
		driver.quit();
//	    throw new io.cucumber.java.PendingException();
	}
	
//	public void loginPage() {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		
//		WebElement usernamebox= driver.findElement(By.name("username"));
//		usernamebox.click();
//		usernamebox.sendKeys("Admin");
//		
//		WebElement Passbox = driver.findElement(By.name("password"));
//		Passbox.click();
//		Passbox.sendKeys("admin123");
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		driver.quit();
//		
//	}
	
}
