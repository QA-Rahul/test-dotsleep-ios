package com.haulhub.pageactions.mobileapp;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.haulhub.framework.utils.UtilsComponent;
import com.haulhub.pageactions.ILeftNavigationPanel;
import com.haulhub.pageactions.ISettingsPage;
import com.haulhub.pagefactory.mobileapp.LeftNavigationPanelPoFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LeftNavigationPanelAction extends UtilsComponent implements ILeftNavigationPanel {

	private LeftNavigationPanelPoFactory leftNavigationPanelPoFactory;
	private String currentClassName;

	AppiumDriver<MobileElement> appiumDriver;

	@SuppressWarnings("unchecked")
	public LeftNavigationPanelAction(WebDriver driver) {
		super(driver);
		appiumDriver = (AppiumDriver<MobileElement>) driver;
		leftNavigationPanelPoFactory = new LeftNavigationPanelPoFactory(appiumDriver);
		currentClassName = getCurrentClassName();
	}

	public ISettingsPage clickOnAccountSettingsButton() {
		waitForElementToBecomeVisible(leftNavigationPanelPoFactory.accountSettingsButton, 3);
		leftNavigationPanelPoFactory.accountSettingsButton.click();
		Reporter.log(currentClassName + ": Clicked on Account Settings button", true);
		return new SettingsPageAction(appiumDriver);
	}

	public ISettingsPage clickOnApplicationSettingsButton() {
		waitForElementToBecomeVisible(leftNavigationPanelPoFactory.applicationSettingsButton, 5);
		leftNavigationPanelPoFactory.applicationSettingsButton.click();
		Reporter.log(currentClassName + ": Clicked on Application Settings button", true);
		return new SettingsPageAction(appiumDriver);
	}
}
