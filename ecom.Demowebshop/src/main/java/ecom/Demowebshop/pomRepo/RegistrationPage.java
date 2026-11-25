package ecom.Demowebshop.pomRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends HomePage {
	public RegistrationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "gender-male")
	private WebElement male;
	
	@FindBy(id = "gender-female")
	private WebElement female;
	
	@FindBy(id = "FirstName")
	private WebElement fn;
	
	@FindBy(id = "LastName")
	private WebElement ln;
	
	@FindBy(id = "Email")
	private WebElement email;
	
	@FindBy(id = "Password")
	private WebElement pwd;
	
	@FindBy(id = "ConfirmPassword")
	private WebElement cpwd;
	
	@FindBy(id = "register-button")
	private WebElement regBut;

	public WebElement getMale() {
		return male;
	}

	public WebElement getFemale() {
		return female;
	}

	public WebElement getFn() {
		return fn;
	}

	public WebElement getLn() {
		return ln;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getCpwd() {
		return cpwd;
	}

	public WebElement getRegBut() {
		return regBut;
	}
	
	public void registerUser(String gender, String fname, String lname, String em, String passw, String cpassw) {
		if(gender.equalsIgnoreCase("male"))
			male.click();
		else if(gender.equalsIgnoreCase("female"))
			female.click();
		fn.clear();
		fn.sendKeys(fname);
		ln.clear();
		ln.sendKeys(lname);
		email.clear();
		email.sendKeys(em);
		pwd.clear();
		pwd.sendKeys(passw);
		cpwd.clear();
		cpwd.sendKeys(cpassw);
		regBut.click();
	}
}
