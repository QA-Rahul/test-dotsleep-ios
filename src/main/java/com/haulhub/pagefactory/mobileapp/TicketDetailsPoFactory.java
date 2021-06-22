package com.haulhub.pagefactory.mobileapp;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class TicketDetailsPoFactory {

	public TicketDetailsPoFactory(AppiumDriver<MobileElement> appiumDriver) {

		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)), this);
	}
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeStaticText")
	public MobileElement ticketId;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Mark Delivered\"]")
	public MobileElement deliveredButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Reject\"]")
	public MobileElement rejectButton;
	
	@iOSXCUITFindBy(xpath =  "//XCUIElementTypeButton[@name=\"Mark Pending\"]")
	public MobileElement markPendingButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[4]/XCUIElementTypeStaticText[1]")
	public MobileElement contractorName;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[4]/XCUIElementTypeStaticText[9]")
	public MobileElement jobName;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[4]/XCUIElementTypeStaticText[11]")
	public MobileElement jobNumber;
	
	@iOSXCUITFindBy(accessibility =  "Please enter a reason")
	public MobileElement reasonTextbox;
	
	@iOSXCUITFindBy(xpath =  "//XCUIElementTypeButton[@name=\"Reject\"]")
	public MobileElement rejectButtonInReasonPopup;
	
	@iOSXCUITFindBy(accessibility =  "Back")
	public MobileElement backButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Reason For Rejection\"]/../XCUIElementTypeStaticText[7]")
	public MobileElement reasonForRejection;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Status\"]/../XCUIElementTypeStaticText[1]")
	public MobileElement ticketStatus;
	
}
