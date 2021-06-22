package com.haulhub.pageactions.mobileapp;

import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.haulhub.framework.utils.UtilsComponent;
import com.haulhub.pageactions.ITicketDetailsPage;
import com.haulhub.pagefactory.mobileapp.TicketDetailsPoFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TicketDetailsPageAction extends UtilsComponent implements ITicketDetailsPage {

	private TicketDetailsPoFactory ticketDetailsPoFactory;
	private String currentClassName;

	AppiumDriver<MobileElement> appiumDriver;

	@SuppressWarnings("unchecked")
	public TicketDetailsPageAction(WebDriver driver) {
		super(driver);
		appiumDriver = (AppiumDriver<MobileElement>) driver;
		ticketDetailsPoFactory = new TicketDetailsPoFactory(appiumDriver);
		currentClassName = getCurrentClassName();
	}

	public String getTicketId() {
		waitForElementToBecomeVisible(ticketDetailsPoFactory.ticketId, 2);
		String ticketNumber = ticketDetailsPoFactory.ticketId.getText();
		Reporter.log(currentClassName + ": Ticket Id on Ticket Details page: " + ticketNumber, true);
		return ticketNumber;
	}

	public boolean areDeliveredAndRejectButtonsEnabled() {
		waitForElementToLoad();
		scrollDown();
		Reporter.log(currentClassName
				+ ": Verifying whether Delivered and Reject buttons are enabled on Ticket Details page", true);
		return ticketDetailsPoFactory.deliveredButton.isEnabled() && ticketDetailsPoFactory.rejectButton.isEnabled();
	}

	public void clickOnRejectButton() {
		waitForElementToLoad();
		scrollDown();
		Reporter.log(currentClassName + ": Clicking on Reject button on Ticket Details page", true);
		ticketDetailsPoFactory.rejectButton.click();
	}

	public void enterReasonAndClickRejectButton(String reason) {
		waitForElementToLoad();
		Reporter.log(currentClassName + ": Entering Rejection reason: " + reason, true);
		ticketDetailsPoFactory.reasonTextbox.sendKeys(reason);
		Reporter.log(currentClassName + ": Clicking on Reject button in the Rejection popup", true);
		ticketDetailsPoFactory.rejectButtonInReasonPopup.click();
	}

	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) appiumDriver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		js.executeScript("mobile: scroll", scrollObject);
		js.executeScript("mobile: scroll", scrollObject);
	}

	public void clickOnBackButton() {
		waitForElementToLoad();
		Reporter.log(currentClassName + ": Clicking on Back button to reach Feed Page", true);
		ticketDetailsPoFactory.backButton.click();

	}

	public String getTicketStatus() {
		waitForElementToLoad();
		String ticketStatus = ticketDetailsPoFactory.ticketStatus.getText();
		Reporter.log(currentClassName + ": Updated ticket status " + ticketStatus, true);
		return ticketStatus;
	}

	public String getReasonForRejection() {
		waitForElementToLoad();
		String reasonForRejection = ticketDetailsPoFactory.reasonForRejection.getText();
		Reporter.log(currentClassName + ": Reason for rejection " + reasonForRejection, true);
		return reasonForRejection;
	}
}
