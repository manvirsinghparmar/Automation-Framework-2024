package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.TestBase.TestBase;

public class AccountLoginPage extends TestBase {

	public AccountLoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-email")
	WebElement emailField;

	@FindBy(id = "input-password")
	WebElement pwdField;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginBtn;

	@FindBy(css = "#account-login div.alert-danger")
	WebElement alertBanner;

	@FindBy(css = "div.alert-success")
	WebElement successBanner;

	@FindBy(xpath = "//a[text()='Forgotten Password']")
	WebElement forgettenPwdLink;

	private void enterEmail(String email) {
		emailField.sendKeys(email);
	}

	private void enterPwd(String pwd) {
		pwdField.sendKeys(pwd);
	}

	private void clickLoginBtn() {
		loginBtn.submit();
	}

	public String getTextFromAlertBanner() {
		return alertBanner.getText();
	}

	public String getTextFromSuccessBanner() {
		return successBanner.getText();
	}

	public ForgotYourPasswordPage clickForgetPwdLink() {
		forgettenPwdLink.click();
		return new ForgotYourPasswordPage();
	}

	public MyAccountPage loginToMyAccount(String email, String pwd) {
		enterEmail(email);
		enterPwd(pwd);
		clickLoginBtn();
		return new MyAccountPage();
	}

}
