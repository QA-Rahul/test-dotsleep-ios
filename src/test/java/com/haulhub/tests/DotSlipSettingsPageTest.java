package com.haulhub.tests;

import static org.testng.Assert.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.haulhub.TestSession;
import com.haulhub.pageactions.ILeftNavigationPanel;
import com.haulhub.pageactions.ILoginPage;
import com.haulhub.pageactions.INavigationBar;
import com.haulhub.pageactions.ISettingsPage;

public class DotSlipSettingsPageTest extends TestSession {

	private static final Logger LOGGER = LoggerFactory.getLogger(DotSlipSettingsPageTest.class);

	private ILoginPage iLoginPage;
	private INavigationBar iNavigationBar;
	private ILeftNavigationPanel iLeftNavigationPanel;
	private ISettingsPage iSettingPage;

	@BeforeClass(alwaysRun = true)
	public void class_objects_setup() throws Exception {
		LOGGER.info("Running DOTslip Settings page tests");
		iLoginPage = initPlatformPage(iLoginPage, "LoginPageAction");
		iLoginPage.signInToApp();
		iNavigationBar = initPlatformPage(iNavigationBar, "NavigationBarAction");
	}

	@Test(priority = 1)
	public void verify_user_is_able_to_edit_settings() {
		iLeftNavigationPanel = iNavigationBar.clickOnHamburgerMenu();
		iSettingPage = iLeftNavigationPanel.clickOnAccountSettingsButton();
		iSettingPage.clickOnEditButton();
		assertTrue(iSettingPage.isFirstNameTextFieldEnabled(),
				"First name text field is not enabled on clicking edit button");
		assertTrue(iSettingPage.isLastNameTextFieldEnabled(),
				"Last name text field is not enabled on clicking edit button");
		assertTrue(iSettingPage.isPhoneNumberTextFieldEnabled(),
				"Phone number text field is not enabled on clicking edit button");
		assertTrue(iSettingPage.isEmailTextFieldEnabled(), "Email text field is not enabled on clicking edit button");
	}

	@Test(priority = 2)
	public void verify_clicking_on_change_password_opens_password_change_alert() {
		iSettingPage.clickOnDoneButton();
		iSettingPage.clickOnChangePasswordButton();
		iSettingPage.enterNewPassword("Abc!123456");
		boolean isSaveButtonEnabled = iSettingPage.isSaveButtonEnabled();
		iSettingPage.clickOnCancelButton();
		iSettingPage.clickOnDoneButton();
		assertTrue(isSaveButtonEnabled, "Password Alert is not displayed on clicking Change Password button");
	}
	
	@Test(priority = 3)
	public void verify_clicking_on_application_settings_opens_corresponding_page() {
		iLeftNavigationPanel = iNavigationBar.clickOnHamburgerMenu();
		iSettingPage = iLeftNavigationPanel.clickOnApplicationSettingsButton();
		assertTrue(iSettingPage.isVersionDisplayed(), "Application version is not displyed");
		assertTrue(iSettingPage.isPermissionSettingsDisplayed(), "Permission settings is not displyed");
	}
}
