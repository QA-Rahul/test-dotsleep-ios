package com.haulhub.tests;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.haulhub.TestSession;
import com.haulhub.pageactions.ILoginPage;
import com.haulhub.pageactions.IMyProjectsPage;
import com.haulhub.pageactions.INavigationBar;
import com.haulhub.pageactions.ITicketsByDayPage;

public class DotSlipMyProjectsPageTest extends TestSession {

	private static final Logger LOGGER = LoggerFactory.getLogger(DotSlipMyProjectsPageTest.class);

	private ILoginPage iLoginPage;
	private INavigationBar iNavigationBar;
	private IMyProjectsPage iMyprojectsPage;
	private ITicketsByDayPage iTicketsByDayPage;

	@BeforeClass(alwaysRun = true)
	public void class_objects_setup() throws Exception {
		LOGGER.info("Running DOTslip My Projects page tests");
		iLoginPage = initPlatformPage(iLoginPage, "LoginPageAction");
		iLoginPage.signInToApp();
		iNavigationBar = initPlatformPage(iNavigationBar, "NavigationBarAction");
	}

	@Test(priority = 1)
	public void verify_project_overview_and_mark_delivered_button_are_available() {
		iMyprojectsPage = iNavigationBar.clickOnMyProjectsButton();
		iTicketsByDayPage = iMyprojectsPage.clickOnFirstProject();
		iTicketsByDayPage.clickOnTicketDetails();
		assertTrue(iTicketsByDayPage.isMarkDeliveredButtonEnabled(),
				"Mark Delivered button is not enabled on Tickets By Date page");
	}

	@Test(priority = 2)
	public void verify_send_invite_button_is_not_available() {
		iTicketsByDayPage.clickProjectsTicketBackButton();
		assertFalse(iTicketsByDayPage.isAddUserButtonAvailable(),
				"Project Overview is not displayed on the Tickets By Date page");
	}
}
