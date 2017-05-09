package automationFramework;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import pageObjects.ChangeLocalStore;
import pageObjects.FindOtherStores;
import pageObjects.StoreFinder;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class POM_TC {
	private static WebDriver driver = null;

	@BeforeTest
	public static void beforeTest() throws Exception {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();		
		String baseUrl = "http://www.homedepot.com/";
		driver.manage().deleteAllCookies();
		driver.get(baseUrl); 	  
		driver.manage().window().maximize();	
		Thread.sleep(5000);
	}


	@Test
	public void run() {
		
		StoreFinder.WaitForElementVisible(driver);
		StoreFinder.MyStore(driver).click();
		
		FindOtherStores.WaitForElementVisible(driver);
		FindOtherStores.FindOthrStores(driver).click();
		
		ChangeLocalStore.WaitForElementVisible(driver);
		ChangeLocalStore.ZipCode(driver).sendKeys("28078");
		driver.manage().timeouts().implicitlyWait(0,  TimeUnit.SECONDS);
		ChangeLocalStore.SearchButton(driver).click();
		ChangeLocalStore.MakeThisYourStore(driver).click();
	}

	@AfterTest
	public void afterTest() {
	}

}
