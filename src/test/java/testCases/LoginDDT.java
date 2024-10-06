package testCases;

import org.testng.annotations.Test;

import utilities.DataProviders;

public class LoginDDT {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void validate_loginDDT(String email, String password, String dataType) {
		
		logger.info();
		
		
		
		
		
	}
}
