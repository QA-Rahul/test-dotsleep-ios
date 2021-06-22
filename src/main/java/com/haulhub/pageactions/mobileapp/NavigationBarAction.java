package com.haulhub.pageactions.mobileapp;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.haulhub.framework.utils.UtilsComponent;
import com.haulhub.pageactions.IFeedPage;
import com.haulhub.pageactions.ILeftNavigationPanel;
import com.haulhub.pageactions.IMyProjectsPage;
import com.haulhub.pageactions.INavigationBar;
import com.haulhub.pageactions.ISearchPage;
import com.haulhub.pagefactory.mobileapp.NavigationBarPoFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class NavigationBarAction extends UtilsComponent implements INavigationBar {

	private NavigationBarPoFactory navigationBarPoFactory;
	private String currentClassName;

	AppiumDriver<MobileElement> appiumDriver;

	@SuppressWarnings("unchecked")
	public NavigationBarAction(WebDriver driver) {
		super(driver);
		appiumDriver = (AppiumDriver<MobileElement>) driver;
		navigationBarPoFactory = new NavigationBarPoFactory(appiumDriver);
		currentClassName = getCurrentClassName();
	}

	public ILeftNavigationPanel clickOnHamburgerMenu() {
		Reporter.log(currentClassName + ": Clicking on DOTslip logo", true);
		sleep(8000);
		waitForElementToLoad();
		waitForElementToBeClickable(navigationBarPoFactory.hamburgerMenu, 5);
		navigationBarPoFactory.hamburgerMenu.click();
		return new LeftNavigationPanelAction(appiumDriver);
	}

	public IMyProjectsPage clickOnTodayButton() {
		Reporter.log(currentClassName + ": Clicking on Today button", true);
		waitForElementToBeClickable(navigationBarPoFactory.todayButton, 2);
		navigationBarPoFactory.todayButton.click();
		return new MyProjectsPageAction(appiumDriver);
	}

	public IMyProjectsPage clickOnMyProjectsButton() {
		Reporter.log(currentClassName + ": Clicking on My Projects button", true);
		waitForElementToBeClickable(navigationBarPoFactory.myProjectsButton, 4);
		navigationBarPoFactory.myProjectsButton.click();
		return new MyProjectsPageAction(appiumDriver);
	}

	public IFeedPage clickOnFeedButton() {
		Reporter.log(currentClassName + ": Clicking on Feed button", true);
		waitForElementToBeClickable(navigationBarPoFactory.feedButton, 5);
		navigationBarPoFactory.feedButton.click();
		return new FeedPageAction(appiumDriver);
	}

	public ISearchPage clickOnSearchIcon() {
		Reporter.log(currentClassName + ": Clicking on Search button", true);
		waitForElementToBeClickable(navigationBarPoFactory.searchButton, 2);
		navigationBarPoFactory.searchButton.click();
		return new SearchPageAction(appiumDriver);
	}

	public boolean isTodayButtonSelected() {
		waitForElementToLoad();
		Reporter.log(currentClassName + ": Verifying whether Today page is displayed and Today button is selected",
				true);
		return navigationBarPoFactory.todayButton.getAttribute("value").equals("1");
	}
}
