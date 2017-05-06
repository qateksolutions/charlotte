package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;

public class Home_Page {
	
	private static WebElement element = null;
	
	public static WebElement link_MyAccount(WebDriver driver) {
		try {
		element = driver.findElement(By.id("account"));
		Log.info("My Account link element found");
		} catch (Exception e) {
			Log.error("Element Not visible");
		}	
		return element;
	}
}
