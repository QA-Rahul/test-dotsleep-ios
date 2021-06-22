package com.haulhub.pagefactory.mobileapp;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SearchPagePoFactory {

	public SearchPagePoFactory(AppiumDriver<MobileElement> appiumDriver) {

		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)), this);
	}

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Jobsite name\"`]")
	public MobileElement jobsiteNameTextField;

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Truck number\"`]")
	public MobileElement truckNumberTextField;

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Ticket number\"`]")
	public MobileElement ticketNumberTextField;

	@iOSXCUITFindBy(accessibility = "Pending")
	public MobileElement pendingStatus;

	@iOSXCUITFindBy(accessibility = "Delivered")
	public MobileElement deliveredStatus;

	@iOSXCUITFindBy(accessibility = "Rejected")
	public MobileElement rejectedStatus;

	@iOSXCUITFindBy(accessibility = "Apply")
	public MobileElement applyFilterButton;

}
