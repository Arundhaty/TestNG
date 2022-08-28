package variousConcepts;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LoginTest {

	WebDriver driver;
	String browser ="chrome";

	By usernameField = By.xpath("//input[@id='username']");
	By passwordField = By.xpath("//input[@id='password']");
	By signinbuttonField = By.xpath("//button[@name='login']");
	By dashboardHeaderField = By.xpath("//h2[contains(text(),'Dashboard')]");
	By customerMenuField = By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]");
	By addcustomerMenuField = By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a");
	By fullNameField = By.xpath("//*[@id=\"account\"]");
	By companyDropdownField = By.xpath("//select[@id='cid']");
	By emailField = By.xpath("//*[@id=\"email\"]");
	By phonenumberField = By.xpath("//*[@id=\"phone\"]");
	

	@BeforeTest
	
	public void init() {
		
		if(browser.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			
		System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		}
		
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
     @Test
	public void loginTest() {
		driver.findElement(usernameField).sendKeys("demo@techfios.com");
		driver.findElement(passwordField).sendKeys("abc123");
		driver.findElement(signinbuttonField).click();
	}
}
