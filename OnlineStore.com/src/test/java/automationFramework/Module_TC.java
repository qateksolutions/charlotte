package automationFramework;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.testng.annotations.BeforeTest;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import appModule.OpenBrowser;
import appModule.SignIn_Action;
import pageObjects.MyAccount_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;;

public class Module_TC {

	private static WebDriver driver = null;

	@BeforeTest
	public void beforeTest() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("OnlineStore_01");
		ExcelUtils.SetExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");
		Log.info("Excel Sheet is opened");
		String browserName = ExcelUtils.GetCellData(1, Constant.Col_Browser);
		if(browserName.equals("Chrome")) {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();	
		}
		if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Eclipse Java\\FirefoxDriver\\geckodriver.exe");	
			driver = new FirefoxDriver();	
		}
		if(browserName.equals("IE")) {
			InternetExplorerDriverManager.getInstance().setup();
			driver = new InternetExplorerDriver();	
		}
		OpenBrowser.Load_OnlineStore(driver, Constant.URL);		
	}	

	@Test
	public void run() throws Exception {	
		DOMConfigurator.configure("log4j.xml");
		ExcelUtils.SetExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");
		SignIn_Action.Execute(driver);
		Log.info("Sign In to Online Store");		
		MyAccount_Page.WaitForElementVisible(driver);
		MyAccount_Page.link_Logout(driver).click();	
		Log.info("Logout from Online Store");
	}

	@AfterTest
	public void afterTest() throws Exception {	
		DOMConfigurator.configure("log4j.xml");
		driver.quit();	
		ExcelUtils.SetExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");		
		ExcelUtils.SetCellData(1, Constant.Col_Results, "PASS");
		Log.info("Test execution results is written into Excel file");
		Log.EndTestCase("OnlineStore_01");
	}
}
