package ecom.Demowebshop.genericUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtility {
	public WebDriver driver;
	public void implicitlyWaiting(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	public void handleWindows(String windowId,WebDriver driver) {
		Set<String> wids = driver.getWindowHandles();
		for(String id:wids) {
			driver.switchTo().window(id);
			if(id.equals(windowId))
				break;	
		}
	}
	
	public WebDriver launchBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if(browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else if(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else
			driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		return driver;
	}
}
