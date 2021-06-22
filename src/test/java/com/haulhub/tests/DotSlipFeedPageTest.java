package com.haulhub.tests;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.haulhub.TestSession;
import com.haulhub.pageactions.IFeedPage;
import com.haulhub.pageactions.ILoginPage;
import com.haulhub.pageactions.INavigationBar;
import com.haulhub.pageactions.ISearchPage;
import com.haulhub.pageactions.ITicketDetailsPage;

public class DotSlipFeedPageTest extends TestSession {

	private static final Logger LOGGER = LoggerFactory.getLogger(DotSlipFeedPageTest.class);

	private ILoginPage iLoginPage;
	private INavigationBar iNavigationBar;
	private IFeedPage iFeedPage;
	private ISearchPage iSearchPage;
	private ITicketDetailsPage iTicketDetailsPage;

	@BeforeClass(alwaysRun = true)
	public void class_objects_setup() throws Exception {
		LOGGER.info("Running DOTslip Feed page tests");
		iLoginPage = initPlatformPage(iLoginPage, "LoginPageAction");
		iLoginPage.signInToApp();
		iNavigationBar = initPlatformPage(iNavigationBar, "NavigationBarAction");
	}

	@Test(priority = 1)
	public void verify_results_filtering_with_ticket_number() {
		iFeedPage = iNavigationBar.clickOnFeedButton();
		String getTicketNumber = iFeedPage.getTicketNumber();
		iSearchPage = iNavigationBar.clickOnSearchIcon();
		iSearchPage.enterTicketNumber(getTicketNumber);
		iSearchPage.clickOnApplyFilterButton();
		assertTrue(iFeedPage.isFirstTicketDisplayed(),
				"Ticket is not displayed after filtering the results by ticket number");
		assertEquals(getTicketNumber, iFeedPage.getTicketNumber());
	}

	@Test(priority = 2)
	public void verify_delivered_reject_buttons_are_enabled() {
		iTicketDetailsPage = iFeedPage.clickOnFirstTicket();
		assertTrue(iTicketDetailsPage.areDeliveredAndRejectButtonsEnabled(),
				"Delivered and Reject buttons are not enabled on Ticket Details page");

	}
}
