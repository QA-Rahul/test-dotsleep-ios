package com.haulhub.pagefactory.mobileapp;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPagePoFactory {

	public LoginPagePoFactory(AppiumDriver<MobileElement> appiumDriver) {

		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)), this);
	}

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[2]/XCUIElementTypeButton[1]")
	public MobileElement loginButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
	public MobileElement userNameTextField;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
	public MobileElement passwordTextField;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Submit\"]")
	public MobileElement submitButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Enter My Code\"]")
	public MobileElement enterMyCodeButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Login\"]")
	public MobileElement loginLogo;
}
