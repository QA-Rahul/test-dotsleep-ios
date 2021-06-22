package com.haulhub.pageactions.mobileapp;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.haulhub.framework.utils.UtilsComponent;
import com.haulhub.pageactions.ITicketDetailsPage;
import com.haulhub.pageactions.ITodayPage;
import com.haulhub.pagefactory.mobileapp.TodayPagePoFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TodayPageAction extends UtilsComponent implements ITodayPage {

	private TodayPagePoFactory todayPagePoFactory;
	private String currentClassName;

	AppiumDriver<MobileElement> appiumDriver;

	@SuppressWarnings("unchecked")
	public TodayPageAction(WebDriver driver) {
		super(driver);
		appiumDriver = (AppiumDriver<MobileElement>) driver;
		todayPagePoFactory = new TodayPagePoFactory(appiumDriver);
		currentClassName = getCurrentClassName();
	}

	public void clickOnAProject() {
		Reporter.log(currentClassName + ": Clicking on First Project", true);
		todayPagePoFactory.firstProject.click();
	}

	public boolean isMarkDeliveredButtonEnabled() {
		Reporter.log(currentClassName + ": Verifying if Mark Delivered button is enabled", true);
		return todayPagePoFactory.markDeliveredButton.isEnabled();
	}

	public ITicketDetailsPage clickOnATicket() {
		Reporter.log(currentClassName + ": Clicking on first ticket", true);
		todayPagePoFactory.ticketCell.click();
		return new TicketDetailsPageAction(appiumDriver);
	}

	public String getTicketId() {
		String ticketId = todayPagePoFactory.ticketId.getText();
		Reporter.log(currentClassName + ": Ticket Id on Today page: " + ticketId, true);
		return ticketId;
	}

}
