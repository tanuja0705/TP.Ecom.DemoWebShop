package ecom.Demowebshop.login;

import org.testng.annotations.Test;

import ecom.Demowebshop.genericUtility.BaseClass;
import ecom.Demowebshop.pomRepo.LoginPage;

public class LoginWithValidCredantials_Test extends BaseClass{
	@Test
	public void loginWithValidCred_Test() throws Exception {
		String un = prop.getDataFromProperty("un");
		String pwd = prop.getDataFromProperty("pwd");
		
		LoginPage lp = new LoginPage(driver);
		lp.getLogin().click();
		
		lp.loginUser(un, pwd);
	}
}
