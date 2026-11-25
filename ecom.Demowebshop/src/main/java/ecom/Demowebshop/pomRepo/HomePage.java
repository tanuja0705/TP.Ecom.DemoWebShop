package ecom.Demowebshop.pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Register")
	private WebElement reg;
	
	@FindBy(linkText = "Log in")
	private WebElement login;
	
	@FindBy(xpath = "//li[@id='topcartlink']/a[@class='ico-cart']")
	private WebElement cart;
	
	 @FindBy(xpath = "//span[text()='Wishlist']/..")
	 private WebElement wishlist;
	 
	 @FindBy(id = "small-searchterms")
	 private WebElement searchTb;
	 
	 @FindBy(xpath = "//input[@value='Search']")
	 private WebElement searchButton;

	public WebElement getReg() {
		return reg;
	}

	public WebElement getLogin() {
		return login;
	}

	public WebElement getCart() {
		return cart;
	}

	public WebElement getWishlist() {
		return wishlist;
	}

	public WebElement getSearchTb() {
		return searchTb;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
}
