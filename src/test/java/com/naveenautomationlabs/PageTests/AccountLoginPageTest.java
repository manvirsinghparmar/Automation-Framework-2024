package com.naveenautomationlabs.PageTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;
import com.naveen.automationlabs.Utils.ExcelUtils;
import com.naveenautomationlabs.Pages.AccountLoginPage;
import com.naveenautomationlabs.Pages.ForgotYourPasswordPage;
import com.naveenautomationlabs.Pages.MyAccountPage;
import com.naveenautomationlabs.TestBase.TestBase;

public class AccountLoginPageTest extends TestBase {

	AccountLoginPage loginPage;
	ForgotYourPasswordPage pwdPage;
	MyAccountPage myAccountPage;

	@BeforeMethod
	public void setup() {
		intialise();
		loginPage = new AccountLoginPage();
	}

	@Test(dataProvider = "LoginData")
	public void validateLoginWithValidCredentials(String email, String pwd) {
		myAccountPage = loginPage.loginToMyAccount(email, pwd);
		String getMyAccountText = myAccountPage.getMyAccountText();
		Assert.assertEquals("My Account", getMyAccountText);

	}

	@Test
	public void validateLoginWithInValidCredentials() {
		loginPage.loginToMyAccount("munni@it.com", "abcd");
		String alertBannerText = loginPage.getTextFromAlertBanner().trim();
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", alertBannerText);
	}

	@Test
	public void validateForgetPwdFunctionality() {
		pwdPage = loginPage.clickForgetPwdLink();
		loginPage = pwdPage.submitForgetPwdRequest("abc1@xyz.com");
		String succesBannerText = loginPage.getTextFromSuccessBanner().trim();
		Assert.assertEquals("An email with a confirmation link has been sent your email address.", succesBannerText);
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

	@DataProvider(name = "LoginData")
	private String[][] loginInfoProvider() throws IOException {
		String filePath = "C:\\Users\\Owner\\Desktop\\loginData.xlsx";
		int rowCount = ExcelUtils.getRowCount(filePath, "Sheet2");
		int colCount = ExcelUtils.getColumnCount(filePath, "Sheet2", rowCount);
		String[][] loginData = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				loginData[i - 1][j] = ExcelUtils.getCellValue(filePath, "Sheet2", i, j);
			}
		}
		return loginData;
	}

}
