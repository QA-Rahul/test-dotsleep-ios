package com.haulhub.pagefactory.mobileapp;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class TodayPagePoFactory {

	public TodayPagePoFactory(AppiumDriver<MobileElement> appiumDriver) {

		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)), this);
	}

	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[1]")
	public MobileElement firstProject;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[2]")
	public MobileElement ticketCell;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[2]/XCUIElementTypeStaticText[1]")
	public MobileElement truckName;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[2]/XCUIElementTypeStaticText[2]")
	public MobileElement tonnageAndMaterial;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[2]/XCUIElementTypeStaticText[3]")
	public MobileElement jobsiteName;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[2]/XCUIElementTypeStaticText[4]")
	public MobileElement ticketDay;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[2]/XCUIElementTypeStaticText[5]")
	public MobileElement load;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[2]/XCUIElementTypeStaticText[6]")
	public MobileElement ticketId;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[2]/XCUIElementTypeStaticText[7]")
	public MobileElement ticketStatus;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[2]/XCUIElementTypeStaticText[8]")
	public MobileElement ticketDate;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[2]/XCUIElementTypeStaticText[9]")
	public MobileElement ticketTime;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell)[2]/XCUIElementTypeButton")
	public MobileElement markDeliveredButton;

}
