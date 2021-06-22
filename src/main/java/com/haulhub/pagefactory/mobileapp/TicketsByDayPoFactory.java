package com.haulhub.pagefactory.mobileapp;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class TicketsByDayPoFactory {

	public TicketsByDayPoFactory(AppiumDriver<MobileElement> appiumDriver) {

		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)), this);
	}

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeOther[1]")
	public MobileElement projectOverview;

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]")
	public MobileElement ticketDetails;

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Mark delivered\"`][1]")
	public MobileElement markDeliveredButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Project Tickets\"]/XCUIElementTypeButton[3]")
	public MobileElement addUserButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]/XCUIElementTypeImage")
	public MobileElement eligibleInspectorCheckbox;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Update Inspector List\"]")
	public MobileElement updateInspectorListButton;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"New Inspector\"]")
	public MobileElement newInspectorButton;	
	
	@iOSXCUITFindBy(accessibility = "Back")
	public MobileElement backButton;
	
	@iOSXCUITFindBy(accessibility = "Project Tickets")
	public MobileElement projectTicketsBackButton;

}
