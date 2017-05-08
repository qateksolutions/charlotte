package automationFramework;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class POM_TC {
	private static WebDriver driver = null;

	@BeforeTest
	public static void beforeTest() {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();		
		String baseUrl = "http://www.homedepot.com/";
		driver.manage().deleteAllCookies();
		driver.get(baseUrl); 	  
		driver.manage().window().maximize();				
	}


	@Test
	public void run() {
	}

	@AfterTest
	public void afterTest() {
	}

}
