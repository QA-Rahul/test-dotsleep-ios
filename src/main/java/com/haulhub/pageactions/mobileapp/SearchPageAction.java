package com.haulhub.pageactions.mobileapp;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.haulhub.framework.utils.UtilsComponent;
import com.haulhub.pageactions.ISearchPage;
import com.haulhub.pagefactory.mobileapp.SearchPagePoFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class SearchPageAction extends UtilsComponent implements ISearchPage {

	private SearchPagePoFactory searchPagePoFactory;
	private String currentClassName;

	AppiumDriver<MobileElement> appiumDriver;

	@SuppressWarnings("unchecked")
	public SearchPageAction(WebDriver driver) {
		super(driver);
		appiumDriver = (AppiumDriver<MobileElement>) driver;
		searchPagePoFactory = new SearchPagePoFactory(appiumDriver);
		currentClassName = getCurrentClassName();
	}

	public void enterTicketNumber(String ticketNumber) {
		appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) appiumDriver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		js.executeScript("mobile: scroll", scrollObject);
		waitForElementToBecomeVisible(searchPagePoFactory.ticketNumberTextField, 6);
		searchPagePoFactory.ticketNumberTextField.sendKeys(ticketNumber);
		Reporter.log(currentClassName + ": Entered ticket number on Search page: " + ticketNumber, true);
	}

	public void clickOnApplyFilterButton() {
		appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		waitForElementToBeClickable(searchPagePoFactory.applyFilterButton, 6);
		searchPagePoFactory.applyFilterButton.click();
		Reporter.log(currentClassName + ": Clicked on Apply Filter button", true);
	}

}
