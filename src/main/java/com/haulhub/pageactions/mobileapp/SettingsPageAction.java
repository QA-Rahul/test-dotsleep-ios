package com.haulhub.pageactions.mobileapp;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.haulhub.framework.utils.UtilsComponent;
import com.haulhub.pageactions.ISettingsPage;
import com.haulhub.pagefactory.mobileapp.SettingsPagePoFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class SettingsPageAction extends UtilsComponent implements ISettingsPage {

	private SettingsPagePoFactory settingsPagePoFactory;
	private String currentClassName;

	AppiumDriver<MobileElement> appiumDriver;

	@SuppressWarnings("unchecked")
	public SettingsPageAction(WebDriver driver) {
		super(driver);
		appiumDriver = (AppiumDriver<MobileElement>) driver;
		settingsPagePoFactory = new SettingsPagePoFactory(appiumDriver);
		currentClassName = getCurrentClassName();
	}

	public void clickOnEditButton() {
		waitForElementToBeClickable(settingsPagePoFactory.editButton, 2);
		settingsPagePoFactory.editButton.click();
		Reporter.log(currentClassName + ": Clicked on Edit button", true);
	}

	public boolean isFirstNameTextFieldEnabled() {
		Reporter.log(currentClassName + ": Verifying whether First Name text field is enabled", true);
		waitForElementToBecomeVisible(settingsPagePoFactory.firstNameTextField, 2);
		return settingsPagePoFactory.firstNameTextField.isEnabled();
	}

	public boolean isLastNameTextFieldEnabled() {
		Reporter.log(currentClassName + ": Verifying whether Last Name text field is enabled", true);
		waitForElementToBecomeVisible(settingsPagePoFactory.lastNameTextField, 2);
		return settingsPagePoFactory.lastNameTextField.isEnabled();
	}

	public boolean isPhoneNumberTextFieldEnabled() {
		Reporter.log(currentClassName + ": Verifying whether Phone Number text field is enabled", true);
		waitForElementToBecomeVisible(settingsPagePoFactory.phoneNumberTextField, 2);
		return settingsPagePoFactory.phoneNumberTextField.isEnabled();
	}

	public boolean isEmailTextFieldEnabled() {
		Reporter.log(currentClassName + ": Verifying whether Email text field is enabled", true);
		waitForElementToBecomeVisible(settingsPagePoFactory.emailTextField, 2);
		return settingsPagePoFactory.emailTextField.isEnabled();
	}

	public void clickOnChangePasswordButton() {
		waitForElementToBeClickable(settingsPagePoFactory.changePasswordButton, 2);
		settingsPagePoFactory.changePasswordButton.click();
		Reporter.log(currentClassName + ": Clicked on Password Change button", true);
	}

	public void enterNewPassword(String newPassword) {
		Reporter.log(currentClassName + ": Entering New Password", true);
		waitForElementToBecomeVisible(settingsPagePoFactory.newPasswordField, 2);
		settingsPagePoFactory.newPasswordField.sendKeys(newPassword);
		waitForElementToBecomeVisible(settingsPagePoFactory.confirmPasswordField, 2);
		settingsPagePoFactory.confirmPasswordField.sendKeys(newPassword);
	}

	public void clickOnCancelButton() {
		waitForElementToBeClickable(settingsPagePoFactory.cancelButton, 2);
		settingsPagePoFactory.cancelButton.click();
		Reporter.log(currentClassName + ": Clicked on Password Change button", true);
	}

	public void clickOnDoneButton() {
		waitForElementToBeClickable(settingsPagePoFactory.doneButton, 2);
		settingsPagePoFactory.doneButton.click();
		Reporter.log(currentClassName + ": Clicked on Done button", true);
	}

	public boolean isSaveButtonEnabled() {
		waitForElementToBecomeVisible(settingsPagePoFactory.saveButton, 2);
		return settingsPagePoFactory.saveButton.isEnabled();
	}

	public boolean isVersionDisplayed() {
		Reporter.log(currentClassName + ": Verifying if App version is displayed");
		sleep(5000);
		return settingsPagePoFactory.version.isDisplayed();
	}

	public boolean isPermissionSettingsDisplayed() {
		Reporter.log(currentClassName + ": Verifying if Permission settings is displayed");
		waitForElementToBecomeVisible(settingsPagePoFactory.permissionSettings, 2);
		return settingsPagePoFactory.permissionSettings.isDisplayed();
	}
}
