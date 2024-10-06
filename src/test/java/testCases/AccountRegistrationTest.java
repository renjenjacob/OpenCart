package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class AccountRegistrationTest extends BaseClass{
	
	@Test
	public void validateAccountRegistration() {
		logger.info("Starting Account Registration test");
		logger.debug("This is a debug log message");
		
		
		try {
		//create an object of HomePage
		HomePage homepage = new HomePage(driver);
		logger.info("Clicked on my account");
		homepage.clickOnMyAccount();
		homepage.clickOnRegister();
		logger.info("Clicked on Register link");
		
		//create an object of RegistrationPage
		RegistrationPage regPage = new RegistrationPage(driver);
		
		logger.info("Providing customer information");
		regPage.setFirstName(randomString().toUpperCase());
		regPage.setLastName(randomString().toUpperCase());
		regPage.setEmail(randomString() + "@mail.com");
		regPage.setTelephone(randomNumber());
	
		String pwd = randomAlphaNumeric();
		regPage.setPassword(pwd);
		regPage.setConfirmPassword(pwd);
		
		regPage.setPrivacyPoilcy();
		regPage.clickContinue();
		logger.info("Validating Expected message");
		String confmsg = regPage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your account has been created!");
		logger.info("Account Registration Test Passed");
		} catch(Exception e) {
			
		} finally {
			logger.info("Finished Account Registration Testing");
		}
		
	}
}
