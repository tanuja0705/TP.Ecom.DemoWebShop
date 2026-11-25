package ecomDemowebshop.shoppingcart;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ecom.Demowebshop.genericUtility.BaseClass;
import ecom.Demowebshop.genericUtility.ReadWriteInExcel;
import ecom.Demowebshop.pomRepo.LoginPage;

public class AddToCartBySearching_Test  extends BaseClass{
	@Test
	public void addToCart_Test() throws Exception {
		LoginPage lp = new LoginPage(driver);
		lp.getLogin().click();
		lp.loginUser(prop.getDataFromProperty("un"), prop.getDataFromProperty("pwd"));
		Assert.assertEquals(driver.findElement(By.linkText("Log out")).isDisplayed(), true);
		Reporter.log("User logged in successfully",true);
		Thread.sleep(5000);
		
		ReadWriteInExcel excel = new ReadWriteInExcel();
		lp.getSearchTb().clear();
		lp.getSearchTb().sendKeys(excel.readDataFromExcel("Product", 1, 3));
		lp.getSearchButton().click();
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Search keyword:']/following-sibling::input")).getAttribute("value").equals(excel.readDataFromExcel("Product", 1, 3)), true);
		Reporter.log("Searched proper product",true);
		driver.findElement(By.xpath("//h2[@class='product-title' and contains(.,'"+excel.readDataFromExcel("Product", 1, 3)+"')]/following-sibling::div/descendant::input[@value='Add to cart']")).click();	
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'The product has been added to your')]")).isDisplayed(), true);
		Reporter.log("Product got added", true);
		Thread.sleep(5000);
		
		lp.getCart().click();
		Assert.assertEquals(driver.findElement(By.xpath("//a[@class='product-name']")).getText().equals(excel.readDataFromExcel("Product", 1, 3)), true);
		Reporter.log("Product is visible in cart section", true);
	}
}
