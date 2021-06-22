package com.haulhub.pageactions.mobileapp;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.haulhub.framework.utils.UtilsComponent;
import com.haulhub.pageactions.ILoginPage;
import com.haulhub.pageactions.ISignUpPage;
import com.haulhub.pagefactory.mobileapp.SignUpPoFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class SignUpPageAction extends UtilsComponent implements ISignUpPage {

	private final String PHONE_NUMBER = "1234567890";
	private final String INVITATION_CODE = "123456abc";
	private final String PASSWORD = "Qwerty@007";

	private SignUpPoFactory signinPagePoFactory;
	private String currentClassName;

	AppiumDriver<MobileElement> appiumDriver;

	@SuppressWarnings("unchecked")
	public SignUpPageAction(WebDriver driver) {
		super(driver);
		appiumDriver = (AppiumDriver<MobileElement>) driver;
		signinPagePoFactory = new SignUpPoFactory(appiumDriver);
		currentClassName = getCurrentClassName();
	}

	public void enterPhoneNumber() {
		waitForElementToLoad();
		Reporter.log(currentClassName + ": Entering the Phone Number: " + PHONE_NUMBER, true);
		signinPagePoFactory.phoneNumberField.sendKeys(PHONE_NUMBER);
	}

	public void enterInvitationCode() {
		waitForElementToLoad();
		Reporter.log(currentClassName + ": Entering the Invitation Code: " + INVITATION_CODE, true);
		signinPagePoFactory.invitationCodeField.sendKeys(INVITATION_CODE);
	}

	public void enterPassword() {
		waitForElementToLoad();
		Reporter.log(currentClassName + ": Entering password under Create Password: " + PASSWORD, true);
		signinPagePoFactory.passwordField.sendKeys(PASSWORD);
		Reporter.log(currentClassName + ": Clicking on password visible button", true);
		signinPagePoFactory.passwordVisibleButton.click();
	}

	public void enterConfirmPassword() {
		waitForElementToLoad();
		Reporter.log(currentClassName + ": Entering password under Confirm Password field: " + PASSWORD, true);
		signinPagePoFactory.confirmPasswordField.sendKeys(PASSWORD);
		Reporter.log(currentClassName + ": Clicking on confirm password visible button", true);
		signinPagePoFactory.confirmPasswordVisibleButton.click();

	}

	public boolean isSubmitButtonEnabled() {
		waitForElementToLoad();
		sleep(2000);
		Reporter.log(currentClassName + ": Verifying if submit button gets enabled on enetering all the required data",
				true);
		return signinPagePoFactory.submitButton.isEnabled();
	}

	public boolean isEnterMyCodeLogoDisplayed() {
		Reporter.log(currentClassName + ": Verifying if \"Enter My Code\" is displayed", true);
		return signinPagePoFactory.enterMyCodeLogo.isDisplayed();
	}

	public boolean isDotSlipLogoEnabled() {
		Reporter.log(currentClassName + ": Verifying if DOTslip logo is enabled", true);
		return signinPagePoFactory.dotSlipLogo.isEnabled();
	}

	public ILoginPage clickOnAlreadyHaveAnAccountLink() {
		Reporter.log(currentClassName + ": Clicking on \"Already have an account\" link", true);
		signinPagePoFactory.alreadyHaveAnAccountLink.click();
		return new LoginPageAction(appiumDriver);
	}

	public boolean isContactUsButtonDisplayedAndEnabled() {
		signinPagePoFactory.backButton.click();
		Reporter.log(currentClassName + ": Verifying if \"Contact Us\" button is displayed and enabled", true);
		return signinPagePoFactory.contactUsButton.isDisplayed() && signinPagePoFactory.contactUsButton.isEnabled();
	}
}
