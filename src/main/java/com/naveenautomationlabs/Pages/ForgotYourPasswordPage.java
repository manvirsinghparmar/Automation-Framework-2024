package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.TestBase.TestBase;

public class ForgotYourPasswordPage extends TestBase {

	public ForgotYourPasswordPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-email")
	WebElement emailInput;

	@FindBy(css = "div.pull-right input")
	WebElement continueBtn;

	@FindBy(css = "div.alert-danger")
	WebElement alertBanner;

	public void enterEmail(String email) {
		emailInput.sendKeys(email);
	}

	public void clickContinueBtn() {
		continueBtn.click();
	}

	public void submitForgetPwdRequest(String email) {
		enterEmail(email);
		clickContinueBtn();
	}

	public String getAlertBannerText() {
		return alertBanner.getText();
	}

}
