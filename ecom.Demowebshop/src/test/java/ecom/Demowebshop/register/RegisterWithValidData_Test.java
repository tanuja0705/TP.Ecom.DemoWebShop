package ecom.Demowebshop.register;

import org.testng.annotations.Test;

import ecom.Demowebshop.genericUtility.BaseClass;
import ecom.Demowebshop.genericUtility.JavaUtility;
import ecom.Demowebshop.genericUtility.ReadWriteInExcel;
import ecom.Demowebshop.pomRepo.HomePage;
import ecom.Demowebshop.pomRepo.RegistrationPage;

public class RegisterWithValidData_Test extends BaseClass {
	ReadWriteInExcel excel = new ReadWriteInExcel();
	JavaUtility j = new JavaUtility();
	
	@Test(groups = "FT")
	public void registerUserWithValidData_Test() throws Exception {
		
		String gender = excel.readDataFromExcel("Register", 1, 0);
		String first = excel.readDataFromExcel("Register", 1, 1);
		String last = excel.readDataFromExcel("Register", 1, 2);
		String email = excel.readDataFromExcel("Register", 1, 3)+j.randomNumber()+"@gmail.com";
		String password = excel.readDataFromExcel("Register", 1, 4);
		
		HomePage hp = new HomePage(driver);
		hp.getReg().click();
		
		RegistrationPage rp = new RegistrationPage(driver);
		rp.registerUser(gender, first, last, email, password, password);
	}
}
