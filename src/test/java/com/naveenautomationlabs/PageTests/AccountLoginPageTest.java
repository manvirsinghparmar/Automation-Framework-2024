package com.naveenautomationlabs.PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;
import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.Pages.ForgotYourPasswordPage;
import com.naveenautomationlabs.TestBase.TestBase;

public class AccountLoginPageTest extends TestBase {

	AccountLoginPage loginPage;

	@BeforeMethod
	public void setup() {
		intialise();
		loginPage = new AccountLoginPage();
	}

	@Test
	public void validateLoginWithValidCredentials() {
		loginPage.loginToMyAccount("abc1@xyz.com", "Password1");
		Assert.assertEquals("My Account1111", driver.getTitle());
	}

	@Test
	public void validateLoginWithInValidCredentials() {
		loginPage.loginToMyAccount("munni@it.com", "abcd");
		String alertBannerText = loginPage.getTextFromAlertBanner().trim();
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", alertBannerText);
	}

	@Test
	public void validateForgetPwdFunctionality() {
		loginPage.clickForgetPwdLink();
		ForgotYourPasswordPage pwdPage = new ForgotYourPasswordPage();
		pwdPage.submitForgetPwdRequest("abc1@xyz.com");
		String succesBannerText = loginPage.getTextFromSuccessBanner().trim();
		Assert.assertEquals("An email with a confirmation link has been sent your email address.", succesBannerText);
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
