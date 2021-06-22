package com.haulhub.framework.utils;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class UtilsComponent {

	AppiumDriver<MobileElement> appiumDriver;

	@SuppressWarnings("unchecked")
	public UtilsComponent(WebDriver appiumDriver) {
		this.appiumDriver = (AppiumDriver<MobileElement>) appiumDriver;
	}

	public MobileElement waitForElementToBecomeVisible(MobileElement element, int waitInSeconds) {
		new WebDriverWait(appiumDriver, waitInSeconds).until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	public MobileElement waitForElementToBeClickable(MobileElement element, int waitInSeconds) {
		new WebDriverWait(appiumDriver, waitInSeconds).until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}

	public void waitForElementToLoad() {
		appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public String getCurrentClassName() {
		return this.getClass().getSimpleName();
	}

	public void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void scrollDown(WebDriver appiumDriver){
		JavascriptExecutor js = (JavascriptExecutor) appiumDriver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		js.executeScript("mobile: scroll", scrollObject);
		sleep(2000);
	}
}
