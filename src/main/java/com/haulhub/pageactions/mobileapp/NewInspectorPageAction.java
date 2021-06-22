package com.haulhub.pageactions.mobileapp;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.haulhub.framework.utils.UtilsComponent;
import com.haulhub.pageactions.INewInspectorPage;
import com.haulhub.pagefactory.mobileapp.NewInspectorPoFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class NewInspectorPageAction extends UtilsComponent implements INewInspectorPage {

	private NewInspectorPoFactory newInspectorPoFactory;
	private String currentClassName;

	AppiumDriver<MobileElement> appiumDriver;

	@SuppressWarnings("unchecked")
	public NewInspectorPageAction(WebDriver driver) {
		super(driver);
		appiumDriver = (AppiumDriver<MobileElement>) driver;
		newInspectorPoFactory = new NewInspectorPoFactory(appiumDriver);
		currentClassName = getCurrentClassName();
	}

	public void enterValuesOnNewInspectorPage(String firstName, String lastName, String email, String phone) {
		waitForElementToLoad();
		Reporter.log(currentClassName + ": Entering first name: " + firstName, true);
		newInspectorPoFactory.firstNameTextField.sendKeys(firstName);
		Reporter.log(currentClassName + ": Entering last name: " + lastName, true);
		newInspectorPoFactory.lastNameTextField.sendKeys(lastName);
		Reporter.log(currentClassName + ": Entering email: " + email, true);
		newInspectorPoFactory.emailTextField.sendKeys(email);
		Reporter.log(currentClassName + ": Entering phone number: " + phone, true);
		newInspectorPoFactory.phoneTextField.sendKeys(phone);
		Reporter.log(currentClassName + ": Clicking on done button", true);
		newInspectorPoFactory.doneButton.click();
	}

	public boolean isAddInspectorButtonEnabled() {
		waitForElementToLoad();
		Reporter.log(currentClassName + ": Verifying if Add Inspector button is enabled", true);
		return newInspectorPoFactory.addInspectorButton.isEnabled();
	}
}
