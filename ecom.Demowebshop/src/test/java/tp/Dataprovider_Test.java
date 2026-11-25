package tp;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider_Test {
	@DataProvider
	public Object[][] linkss() {
		Object obj [][] = new Object[3][1];
		
		obj[0][0]="https://demowebshop.tricentis.com/";
		obj[1][0]="https://www.flipkart.com/";
		obj[2][0]="http://49.249.29.4:8888/";
		return obj;
	}
	
	@Test(dataProvider = "linkss")
	public void launchApp(String url) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(url);
		Thread.sleep(5000);
		driver.quit();
	}
}
