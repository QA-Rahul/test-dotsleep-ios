package com.haulhub.pageactions.mobileapp;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.haulhub.framework.utils.UtilsComponent;
import com.haulhub.pageactions.IHomePage;
import com.haulhub.pageactions.ILoginPage;
import com.haulhub.pageactions.ISignUpPage;
import com.haulhub.pagefactory.mobileapp.LoginPagePoFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginPageAction extends UtilsComponent implements ILoginPage {

	private final String USERNAME = "username";
	private final String PASSWORD = "password";

	private LoginPagePoFactory loginPagePoFactory;
	private String currentClassName;

	AppiumDriver<MobileElement> appiumDriver;

	@SuppressWarnings("unchecked")
	public LoginPageAction(WebDriver driver) {
		super(driver);
		appiumDriver = (AppiumDriver<MobileElement>) driver;
		loginPagePoFactory = new LoginPagePoFactory(appiumDriver);
		currentClassName = getCurrentClassName();
	}

	public IHomePage signInToApp() {
		sleep(3000);
		Reporter.log(currentClassName + ": Clicking on the login button", true);
		loginPagePoFactory.loginButton.click();
		Reporter.log(currentClassName + ": Entering the username", true);
		waitForElementToBecomeVisible(loginPagePoFactory.userNameTextField, 2);
		loginPagePoFactory.userNameTextField.click();
		loginPagePoFactory.userNameTextField.sendKeys(System.getProperty(USERNAME));
		Reporter.log(currentClassName + ": Entering the password", true);
		waitForElementToBecomeVisible(loginPagePoFactory.passwordTextField, 2);
		loginPagePoFactory.passwordTextField.sendKeys(System.getProperty(PASSWORD));
		Reporter.log(currentClassName + ": Clicking on the submit button", true);
		waitForElementToBeClickable(loginPagePoFactory.submitButton, 2);
		loginPagePoFactory.submitButton.click();
		return new HomePageAction(appiumDriver);
	}

	public ISignUpPage clickOnEnterMyCodeButton() {
		Reporter.log(currentClassName + ": Clicking on the Enter My Code button", true);
		loginPagePoFactory.enterMyCodeButton.click();
		return new SignUpPageAction(appiumDriver);
	}

	public boolean isLoginLogoDisplayed() {
		sleep(2000);
		Reporter.log(currentClassName + ": Verifying if Login logo displayed on Login page", true);
		return loginPagePoFactory.loginLogo.isDisplayed();

	}
}
