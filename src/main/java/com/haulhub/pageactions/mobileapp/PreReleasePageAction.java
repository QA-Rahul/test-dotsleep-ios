package com.haulhub.pageactions.mobileapp;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.haulhub.framework.utils.UtilsComponent;
import com.haulhub.pageactions.IPreReleasePage;
import com.haulhub.pageactions.ITicketsByDayPage;
import com.haulhub.pagefactory.mobileapp.PreReleasePoFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PreReleasePageAction extends UtilsComponent implements IPreReleasePage {

	private PreReleasePoFactory preReleasePoFactory;
	private String currentClassName;

	AppiumDriver<MobileElement> appiumDriver;

	@SuppressWarnings("unchecked")
	public PreReleasePageAction(WebDriver driver) {
		super(driver);
		appiumDriver = (AppiumDriver<MobileElement>) driver;
		preReleasePoFactory = new PreReleasePoFactory(appiumDriver);
		currentClassName = getCurrentClassName();
	}

	public ITicketsByDayPage clickOnFirstTicketJobsiteId() {
		waitForElementToBeClickable(preReleasePoFactory.jobsiteId, 6);
		preReleasePoFactory.jobsiteId.click();
		Reporter.log(currentClassName + ": Clicked on the first job site id on My Projects page ", true);
		return new TicketsByDayPageAction(appiumDriver);
	}

}
