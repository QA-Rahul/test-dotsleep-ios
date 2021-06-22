package com.haulhub.pagefactory.mobileapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class ProjectFilterPoFactory {

    public ProjectFilterPoFactory(AppiumDriver<MobileElement> appiumDriver) {

        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)), this);
    }

    @iOSXCUITFindBy(accessibility = "Search")
    public MobileElement searchBtn;

    @iOSXCUITFindBy(accessibility = "My Projects")
    public MobileElement myProjectTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='Truck number']")
    public MobileElement truckNumberTextBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='Ticket number']")
    public MobileElement ticketNumberTextBox;

    @iOSXCUITFindBy(accessibility = "Pending")
    public MobileElement statusPending;

    @iOSXCUITFindBy(accessibility = "Rejected")
    public MobileElement statusRejected;

    @iOSXCUITFindBy(accessibility = "Apply")
    public MobileElement applyBtn;

    @iOSXCUITFindBy(accessibility = "40887 - Anshuman Corp")
    public MobileElement projectName;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Tons')]")
    public List<MobileElement> tickets;

    @iOSXCUITFindBy(accessibility = "Project Tickets")
    public MobileElement backBtn;

    @iOSXCUITFindBy(accessibility = "Back")
    public MobileElement backBtnForProject;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Feed')]")
    public MobileElement feedTab;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"No Slips\"]")
    public MobileElement noResultForFeed;


}


