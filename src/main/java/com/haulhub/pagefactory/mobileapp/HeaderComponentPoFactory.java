package com.haulhub.pagefactory.mobileapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HeaderComponentPoFactory {

	public HeaderComponentPoFactory(AppiumDriver<MobileElement> appiumDriver) {

		PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(10)), this);
	}

	@AndroidFindBy(accessibility = "")
	@iOSXCUITFindBy(id = "")
	public MobileElement dummy;

}
