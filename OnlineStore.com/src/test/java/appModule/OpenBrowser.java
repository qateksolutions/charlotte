package appModule;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import utility.Log;

public class OpenBrowser {		
	public static void Load_OnlineStore(WebDriver driver, String baseUrl) {
		driver.manage().deleteAllCookies();
		Log.info("Deleted all the cookies");
		driver.get(baseUrl); 	
		Log.info("Browser is Launched");
		driver.manage().window().maximize();		
		Log.info("Browser is maximized");		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
