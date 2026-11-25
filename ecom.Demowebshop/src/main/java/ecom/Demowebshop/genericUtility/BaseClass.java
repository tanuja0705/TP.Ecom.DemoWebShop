package ecom.Demowebshop.genericUtility;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {
	public WebDriver driver;
	public ReadingDataFromPropertyFile prop = new ReadingDataFromPropertyFile();
	public WebDriverUtility wUtil = new WebDriverUtility();
	
	@BeforeSuite(alwaysRun = true)
	public void db() {
		Reporter.log(" Connected to database ",true);
	}
	
	@AfterSuite(alwaysRun = true)
	public void cdb() {
		Reporter.log(" Close the connection  ",true);
	}
	
	@BeforeTest(alwaysRun = true)
	public void test() {
		Reporter.log(" Before test  ");
	}
	
	@AfterTest(alwaysRun = true)
	public void afterTest() {
		Reporter.log(" After test ",true);
	}
	
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(@Optional("chrome")String browser) throws Exception {
		//String browser = prop.getDataFromProperty("browser");
		driver =wUtil.launchBrowser(browser);
		driver.get(prop.getDataFromProperty("url"));
	}
	
	@AfterClass(alwaysRun = true) 
	public void closeBrowser() {
		driver.quit();
	}
}
