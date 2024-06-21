package com.naveenautomationlabs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomationlabs.TestBase.TestBase;

public class MyAccountPage extends TestBase {

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement myAccountText;

	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}

	public String getMyAccountText() {
		return myAccountText.getText().trim();
	}

}
