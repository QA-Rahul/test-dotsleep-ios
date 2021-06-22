package com.haulhub.pagefactory.mobileapp;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class NavigationBarPoFactory {

	public NavigationBarPoFactory(AppiumDriver<MobileElement> appiumDriver) {

		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)), this);
	}

	@iOSXCUITFindBy(accessibility = "Today")
	public MobileElement todayButton;

	@iOSXCUITFindBy(accessibility = "My Projects")
	public MobileElement myProjectsButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Feed\"]")
	public MobileElement feedButton;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeButton[1]")
	public MobileElement hamburgerMenu;

	@iOSXCUITFindBy(accessibility = "Search")
	public MobileElement searchButton;

}
