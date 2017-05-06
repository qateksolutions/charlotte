package appModule;

import org.openqa.selenium.WebDriver;
import pageObjects.Home_Page;
import pageObjects.LogIn_Page;
import utility.ExcelUtils;
import utility.Constant;
import utility.Log;;

public class SignIn_Action {
	public static void Execute(WebDriver driver) throws Exception {
		String userName = ExcelUtils.GetCellData(1, Constant.Col_UserName);
		Log.info("User Name picked from Excel is:  " + userName);
		String password = ExcelUtils.GetCellData(1, Constant.Col_Password);
		Log.info("Password picked from Excel is:  " + password);
		Home_Page.link_MyAccount(driver).click();
		LogIn_Page.WaitForElementVisible(driver);
		LogIn_Page.textbox_UserName(driver).sendKeys(userName);
		Log.info("User Name is entered");
		LogIn_Page.textbox_Password(driver).sendKeys(password);
		Log.info("Password is entered");
		LogIn_Page.button_Login(driver).click();
		Log.info("Login Successfully");		
	}	
}
