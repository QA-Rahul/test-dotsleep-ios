package com.haulhub.pageactions.mobileapp;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.haulhub.framework.utils.UtilsComponent;
import com.haulhub.pageactions.INewInspectorPage;
import com.haulhub.pageactions.ITicketsByDayPage;
import com.haulhub.pagefactory.mobileapp.TicketsByDayPoFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TicketsByDayPageAction extends UtilsComponent implements ITicketsByDayPage {

	private TicketsByDayPoFactory ticketsByDayPoFactory;
	private String currentClassName;

	AppiumDriver<MobileElement> appiumDriver;
	WebDriverWait wait;

	@SuppressWarnings("unchecked")
	public TicketsByDayPageAction(WebDriver driver) {
		super(driver);
		appiumDriver = (AppiumDriver<MobileElement>) driver;
		ticketsByDayPoFactory = new TicketsByDayPoFactory(appiumDriver);
		currentClassName = getCurrentClassName();
	}

	public boolean isProjectOverviewDisplayed() {
		Reporter.log(currentClassName + ": Verifying if Project Overview is displayed", true);
		waitForElementToLoad();
		return ticketsByDayPoFactory.projectOverview.isDisplayed();
	}

	public void clickOnTicketDetails() {
		waitForElementToLoad();
		waitForElementToBecomeVisible(ticketsByDayPoFactory.ticketDetails, 10);
		ticketsByDayPoFactory.ticketDetails.click();
		Reporter.log(currentClassName + ": Clicked on Ticket Details on Tickets By Day page", true);
	}

	public boolean isMarkDeliveredButtonEnabled() {
		waitForElementToLoad();
		waitForElementToBecomeVisible(ticketsByDayPoFactory.markDeliveredButton, 15);
		Reporter.log(currentClassName + ": Verifying if Mark Delivered Button is enabled", true);
		return ticketsByDayPoFactory.markDeliveredButton.isEnabled();
	}

	public boolean isAddUserButtonAvailable() {
		Reporter.log(currentClassName + ": Verifying that Add Inspector button is not available", true);
		try {
			return ticketsByDayPoFactory.addUserButton.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void clickProjectsTicketBackButton() {
		waitForElementToLoad();
		ticketsByDayPoFactory.projectTicketsBackButton.click();
		Reporter.log(currentClassName + ": Clicked on Project Tickets Back button", true);
	}

	public void clickOnEligibleInspectorCheckbox() {
		waitForElementToLoad();
		ticketsByDayPoFactory.eligibleInspectorCheckbox.click();
		Reporter.log(currentClassName + ": Clicked on Eligible Inspector checkbox", true);
	}

	public INewInspectorPage clickOnNewInspectorButton() {
		waitForElementToLoad();
		ticketsByDayPoFactory.newInspectorButton.click();
		Reporter.log(currentClassName + ": Clicked on New Inspector Button", true);
		return new NewInspectorPageAction(appiumDriver);
	}
}
