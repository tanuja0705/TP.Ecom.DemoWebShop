package ecom.Demowebshop.pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends HomePage {
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Email")
	private WebElement email;
	
	@FindBy(id = "Password")
	private WebElement pwd;
	
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginBut;

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getLoginBut() {
		return loginBut;
	}
	
	public void loginUser(String em,String passwd) {
		email.clear();
		email.sendKeys(em);
		pwd.clear();
		pwd.sendKeys(passwd);
		loginBut.click();
	}
}
