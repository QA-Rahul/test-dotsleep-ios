package com.haulhub.pageactions.mobileapp;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.haulhub.framework.utils.UtilsComponent;
import com.haulhub.pageactions.IMyProjectsPage;
import com.haulhub.pageactions.ITicketsByDayPage;
import com.haulhub.pagefactory.mobileapp.MyProjectsPoFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MyProjectsPageAction extends UtilsComponent implements IMyProjectsPage {

	private MyProjectsPoFactory myProjectsPoFactory;
	private String currentClassName;

	AppiumDriver<MobileElement> appiumDriver;

	@SuppressWarnings("unchecked")
	public MyProjectsPageAction(WebDriver driver) {
		super(driver);
		appiumDriver = (AppiumDriver<MobileElement>) driver;
		myProjectsPoFactory = new MyProjectsPoFactory(appiumDriver);
		currentClassName = getCurrentClassName();
	}

	public ITicketsByDayPage clickOnFirstProject() {
		waitForElementToBeClickable(myProjectsPoFactory.firstProject, 2);
		myProjectsPoFactory.firstProject.click();
		Reporter.log(currentClassName + ": Clicked on the first project on My Projects page ", true);
		return new TicketsByDayPageAction(appiumDriver);
	}

}
