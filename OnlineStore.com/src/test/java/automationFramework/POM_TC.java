package automationFramework;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import pageObjects.MyAccount_Page;
import pageObjects.Home_Page;
import pageObjects.LogIn_Page;

public class POM_TC {

	private static WebDriver driver = null;
	
	@BeforeTest
	public void beforeTest() {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();		
		String baseUrl = "http://store.demoqa.com/";	
		driver.manage().deleteAllCookies();
		driver.get(baseUrl); 	  
		driver.manage().window().maximize();				
	}

	@Test
	public void run() {
		Home_Page.link_MyAccount(driver).click();
		LogIn_Page.textbox_UserName(driver).sendKeys("qatek");
		LogIn_Page.textbox_Password(driver).sendKeys("Automation1!");
		LogIn_Page.button_Login(driver).click();
		System.out.println("Login Successfully, now it is the time to log off buddy!!");
		MyAccount_Page.WaitForElementVisible(driver);
		MyAccount_Page.link_Logout(driver).click();		
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
