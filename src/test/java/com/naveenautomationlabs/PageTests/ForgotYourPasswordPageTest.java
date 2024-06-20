package com.naveenautomationlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.Pages.ForgotYourPasswordPage;
import com.naveenautomationlabs.TestBase.TestBase;

public class ForgotYourPasswordPageTest extends TestBase {

	AccountLoginPage loginPage;

	@BeforeMethod
	public void setup() {
		intialise();
		loginPage = new AccountLoginPage();
	}

	@Test
	public void validateForgetPwdAlertBannerText() {
		loginPage.clickForgetPwdLink();
		ForgotYourPasswordPage pwdPage = new ForgotYourPasswordPage();
		pwdPage.clickContinueBtn();
		String bannerText = pwdPage.getAlertBannerText().trim();
		Assert.assertEquals("Warning: The E-Mail Address was not found in our records, please try again!", bannerText);
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
