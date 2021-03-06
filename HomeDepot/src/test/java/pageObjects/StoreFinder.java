package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StoreFinder {
	private static WebElement element = null;
	
	public static void WaitForElementVisible (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='headerSearch']")));
	}	
	
	public static WebElement MyStore(WebDriver driver){
		element = driver.findElement(By.xpath(".//*[@id='myStore']/a/span[@class='MyStore__label']"));
		return element;
	}

}
