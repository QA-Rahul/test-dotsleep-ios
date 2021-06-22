package com.haulhub.pageactions.mobileapp;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.haulhub.framework.utils.UtilsComponent;
import com.haulhub.pageactions.IFeedPage;
import com.haulhub.pageactions.ITicketDetailsPage;
import com.haulhub.pagefactory.mobileapp.FeedPagePoFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * feed page actions
 */
public class FeedPageAction extends UtilsComponent implements IFeedPage {

	private FeedPagePoFactory feedPagePoFactory;
	private String currentClassName;

	AppiumDriver<MobileElement> appiumDriver;

	@SuppressWarnings("unchecked")
	public FeedPageAction(WebDriver driver) {
		super(driver);
		appiumDriver = (AppiumDriver<MobileElement>) driver;
		feedPagePoFactory = new FeedPagePoFactory(appiumDriver);
		currentClassName = getCurrentClassName();
	}

	public String getTicketNumber() {
		waitForElementToBecomeVisible(feedPagePoFactory.ticketId, 3);
		String ticketNumber = feedPagePoFactory.ticketId.getText();
		Reporter.log(currentClassName + ": Ticket number on Feed page: " + ticketNumber, true);
		return ticketNumber;
	}

	public boolean isFirstTicketDisplayed() {
		sleep(5000);
		Reporter.log(currentClassName
				+ ": Verifying whether first ticket is displayed on Feed page after applying the filter", true);
		return feedPagePoFactory.firstTicket.isDisplayed();
	}

	public ITicketDetailsPage clickOnFirstTicket() {
		waitForElementToBeClickable(feedPagePoFactory.firstTicket, 3);
		Reporter.log(currentClassName + ": Clicking on first ticket", true);
		feedPagePoFactory.firstTicket.click();
		return new TicketDetailsPageAction(appiumDriver);
	}

	public String getRejectedTicketStatus() {
		waitForElementToLoad();
		String ticketStatus = feedPagePoFactory.rejectedTicketStatus.getText();
		Reporter.log(currentClassName + ": Ticket status after rejecting the ticket is: " + ticketStatus, true);
		return ticketStatus;

	}
}
