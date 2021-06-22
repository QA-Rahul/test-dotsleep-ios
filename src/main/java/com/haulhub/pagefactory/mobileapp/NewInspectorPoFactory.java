package com.haulhub.pagefactory.mobileapp;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class NewInspectorPoFactory {
	
	public NewInspectorPoFactory(AppiumDriver<MobileElement> appiumDriver) {

		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)), this);
	}

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeTextField[4]")
	public MobileElement firstNameTextField;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeTextField[1]")
	public MobileElement lastNameTextField;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeTextField[2]")
	public MobileElement emailTextField;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeTextField[3]")
	public MobileElement phoneTextField;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Done\"]")
	public MobileElement doneButton;	
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Add Inspector\"])[2]")
	public MobileElement addInspectorButton;	
	
	
}
