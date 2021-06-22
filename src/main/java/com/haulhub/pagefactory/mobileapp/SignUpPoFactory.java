package com.haulhub.pagefactory.mobileapp;

import java.time.Duration;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SignUpPoFactory {

	public SignUpPoFactory(AppiumDriver<MobileElement> appiumDriver) {
		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)), this);
	}

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Enter My Code\"]")
	public MobileElement enterMyCodeLogo;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[2]")
	public MobileElement dotSlipLogo;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeTextField")
	public MobileElement phoneNumberField;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeTextField")
	public MobileElement invitationCodeField;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeSecureTextField")
	public MobileElement passwordField;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[4]/XCUIElementTypeImage")
	public MobileElement passwordVisibleButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[5]/XCUIElementTypeOther/XCUIElementTypeSecureTextField")
	public MobileElement confirmPasswordField;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[5]/XCUIElementTypeImage")
	public MobileElement confirmPasswordVisibleButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Submit\"]")
	public MobileElement submitButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Already have an account? Log in\"]")
	public MobileElement alreadyHaveAnAccountLink;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Contact us\"]")
	public MobileElement contactUsButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeButton")
	public MobileElement backButton;

}
