package com.haulhub.pagefactory.mobileapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class FeedPagePoFactory {

	public FeedPagePoFactory(AppiumDriver<MobileElement> appiumDriver) {

		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)), this);
	}

	@iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeCell\"")
	public MobileElement firstTicket;

	@iOSXCUITFindBy(xpath = ".//XCUIElementTypeCell[1]/*[@name][6]")
	public MobileElement ticketId;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Rejected\"]")
	public MobileElement rejectedTicketStatus;

}
