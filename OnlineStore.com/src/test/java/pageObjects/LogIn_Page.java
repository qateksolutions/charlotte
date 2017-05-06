package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Log;

public class LogIn_Page {
	
	private static WebElement element = null;
	
	public static void WaitForElementVisible (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//header/h1[text()='Your Account']")));
	}	
	
	public static WebElement textbox_UserName(WebDriver driver) {
		element = driver.findElement(By.id("log"));
		Log.info("UserName textbox found");
		return element;		
	}
	
	public static WebElement textbox_Password(WebDriver driver) {
		element = driver.findElement(By.id("pwd"));
		Log.info("Password textbox found");
		return element;
	}
	
	public static WebElement button_Login(WebDriver driver) {
		element = driver.findElement(By.id("login"));
		Log.info("Login button found");
		return element;
	}	
}
