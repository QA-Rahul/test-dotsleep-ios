package com.haulhub.pagefactory.mobileapp;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SettingsPagePoFactory {

	public SettingsPagePoFactory(AppiumDriver<MobileElement> appiumDriver) {

		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)), this);
	}

	@iOSXCUITFindBy(accessibility = "Edit")
	public MobileElement editButton;

	@iOSXCUITFindBy(accessibility = "Done")
	public MobileElement doneButton;

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Anshuman1\"`]")
	public MobileElement firstNameTextField;

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Ambasht\"`]")
	public MobileElement lastNameTextField;

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"+1 (202) 555-0181\"`]")
	public MobileElement phoneNumberTextField;

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"noreply@haulhub.com\"`]")
	public MobileElement emailTextField;

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[7]")
	public MobileElement signatureField;

	@iOSXCUITFindBy(accessibility = "Change Password")
	public MobileElement changePasswordButton;

	@iOSXCUITFindBy(xpath = ".//XCUIElementTypeOther[1]/XCUIElementTypeSecureTextField")
	public MobileElement newPasswordField;
	
	@iOSXCUITFindBy(xpath = ".//XCUIElementTypeOther[3]/XCUIElementTypeSecureTextField")
	public MobileElement confirmPasswordField;
	
	@iOSXCUITFindBy(accessibility = "Save")
	public MobileElement saveButton;
	
	@iOSXCUITFindBy(accessibility = "Cancel")
	public MobileElement cancelButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[1]")
	public MobileElement version;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[2]")
	public MobileElement permissionSettings;
	
	
}
