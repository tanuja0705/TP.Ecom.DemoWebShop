package tp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BrowserLaunch {
	@Test
	public void m1() {
		WebDriver driver = new FirefoxDriver();
	}
}
