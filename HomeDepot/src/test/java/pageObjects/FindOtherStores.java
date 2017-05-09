package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindOtherStores {
	private static WebElement element = null;

	public static void WaitForElementVisible (WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='myStoreDropdown']//a/span[text()='Find Other Stores']")));
	}	
	
	public static WebElement FindOthrStores(WebDriver driver){
		element = driver.findElement(By.xpath(".//*[@id='myStoreDropdown']//a/span[text()='Find Other Stores']"));
		return element;
	}

}
