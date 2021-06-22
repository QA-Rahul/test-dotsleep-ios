package com.haulhub.pageactions.mobileapp;

import com.haulhub.framework.utils.UtilsComponent;
import com.haulhub.pageactions.IHomePage;
import com.haulhub.pagefactory.mobileapp.HomePagePoFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class HomePageAction extends UtilsComponent implements IHomePage {

	private HomePagePoFactory homePagePoFactory;
	private String currentClassName;

	AppiumDriver<MobileElement> appiumDriver;

	@SuppressWarnings("unchecked")
	public HomePageAction(WebDriver driver) {
		super(driver);
		appiumDriver = (AppiumDriver<MobileElement>) driver;
		homePagePoFactory = new HomePagePoFactory(appiumDriver);
		currentClassName = getCurrentClassName();
	}

	public boolean isNavigationBarDisplayed() {
		Reporter.log(currentClassName + ": Verifying if Navigation Bar is displayed", true);
		waitForElementToBecomeVisible(homePagePoFactory.searchButton, 5);
		return homePagePoFactory.searchButton.isDisplayed();
	}

}
