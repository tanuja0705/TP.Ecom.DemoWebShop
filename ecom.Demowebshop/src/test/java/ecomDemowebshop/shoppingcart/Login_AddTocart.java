package ecomDemowebshop.shoppingcart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ecom.Demowebshop.genericUtility.ReadWriteInExcel;
import ecom.Demowebshop.genericUtility.ReadingDataFromPropertyFile;
import ecom.Demowebshop.genericUtility.WebDriverUtility;
import ecom.Demowebshop.pomRepo.LoginPage;

public class Login_AddTocart {
	public static void main(String[] args) throws Exception {
		WebDriverUtility wu = new WebDriverUtility();
		ReadingDataFromPropertyFile prop = new ReadingDataFromPropertyFile();
		
		WebDriver d=null;
		
		d = wu.launchBrowser(prop.getDataFromProperty("browser"));

		d.get(prop.getDataFromProperty("url"));

		LoginPage lp = new LoginPage(d);
		lp.getLogin().click();
		
		lp.loginUser(prop.getDataFromProperty("un"), prop.getDataFromProperty("pwd"));
		
		Thread.sleep(3000);
		ReadWriteInExcel excel = new ReadWriteInExcel();

		d.findElement(By.xpath("(//a[contains(text(),'"+excel.readDataFromExcel("Product", 1, 1)+"')])[1]")).click();
		
		if(!(excel.readDataFromExcel("Product", 1, 2).equals("NA")))
				d.findElement(By.xpath("//li/a[contains(text(),'"+excel.readDataFromExcel("Product", 1, 2)+"')]")).click();
	
		
		d.findElement(By.xpath("//a[text()='"+excel.readDataFromExcel("Product", 1, 3)+"']")).click();
		d.findElement(By.xpath("//input[contains(@id,'add-to-cart-button')]")).click();

		d.findElement(By.linkText("Log out")).click();

		Thread.sleep(5000);
		d.quit();
	}
}
