package tp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BrowserLaunch {
	WebDriver driver= null;
	@Test
	public void m1() throws Exception {
		String browser = System.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if(browser.equalsIgnoreCase("edge"))
				driver = new EdgeDriver();
		
		driver.get(System.getProperty("url"));
		
		Thread.sleep(5000);
		driver.quit();
	}
}
