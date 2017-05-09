package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangeLocalStore {
	private static WebElement element = null;
	
	public static void WaitForElementVisible (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='sfHeader']/h1[contains(text(),'Change Your Local Store')]")));
	}	
	
	public static WebElement ZipCode(WebDriver driver){
		element = driver.findElement(By.xpath(".//*[@id='txtStoreFinder']"));
		return element;
	}
	
	public static WebElement SearchButton(WebDriver driver){
		element = driver.findElement(By.xpath(".//*[@id='btnStoreFinder']"));
		return element;
	}
	
	
	public static WebElement MakeThisYourStore(WebDriver driver){
		element = driver.findElement(By.xpath(".//*[@id='sfStoreList']//a[@data-storeid='3638']"));
		return element;
	}
	


}
