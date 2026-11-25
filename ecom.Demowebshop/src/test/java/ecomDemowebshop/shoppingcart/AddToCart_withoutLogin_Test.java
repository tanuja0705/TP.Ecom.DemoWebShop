package ecomDemowebshop.shoppingcart;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecom.Demowebshop.genericUtility.BaseClass;
import ecom.Demowebshop.genericUtility.ReadWriteInExcel;
import ecom.Demowebshop.pomRepo.HomePage;

public class AddToCart_withoutLogin_Test extends BaseClass {
	@Test
	public void addToCart_WithoutLogin_Test() throws Exception {
		HomePage hp = new HomePage(driver);
		hp.getSearchTb().clear();
		
		ReadWriteInExcel excel = new ReadWriteInExcel();
		
		hp.getSearchTb().sendKeys(excel.readDataFromExcel("Product", 1, 3));
		hp.getSearchButton().click();
		
		driver.findElement(By.xpath("//h2[@class='product-title' and contains(.,'"+excel.readDataFromExcel("Product", 1, 3)+"')]/following-sibling::div/descendant::input[@value='Add to cart']")).click();	
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'The product has been added to your')]")).isDisplayed(), true);
		Reporter.log("Product got added", true);
		Thread.sleep(5000);
		
		hp.getCart().click();
		Assert.assertEquals(driver.findElement(By.xpath("//a[@class='product-name']")).getText().equals(excel.readDataFromExcel("Product", 1, 3)), true);
		Reporter.log("Product is visible in cart section", true);
	}
}
