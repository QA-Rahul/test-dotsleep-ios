package com.haulhub.tests;

import static org.testng.Assert.assertEquals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.haulhub.TestSession;
import com.haulhub.pageactions.IFeedPage;
import com.haulhub.pageactions.ILoginPage;
import com.haulhub.pageactions.INavigationBar;
import com.haulhub.pageactions.ITicketDetailsPage;

public class DotSlipTicketDetailsPageTest extends TestSession {

	private static final Logger LOGGER = LoggerFactory.getLogger(DotSlipFeedPageTest.class);

	private ILoginPage iLoginPage;
	private INavigationBar iNavigationBar;
	private IFeedPage iFeedPage;
	private ITicketDetailsPage iTicketDetailsPage;
	private static final String REJECTION_MESSAGE = "Ticket rejected";
	private static final String REJECTED_STATUS = "Rejected";

	@BeforeClass(alwaysRun = true)
	public void class_objects_setup() throws Exception {
		LOGGER.info("Running DOTslip Ticket Details page tests");
		iLoginPage = initPlatformPage(iLoginPage, "LoginPageAction");
		iLoginPage.signInToApp();
		iNavigationBar = initPlatformPage(iNavigationBar, "NavigationBarAction");
	}

	@Test(priority = 1)
	public void verify_ticket_status_and_reason_for_rejection_get_updated_on_rejecting_a_ticket() {
		iFeedPage = iNavigationBar.clickOnFeedButton();
		iTicketDetailsPage = iFeedPage.clickOnFirstTicket();
		iTicketDetailsPage.clickOnRejectButton();
		iTicketDetailsPage.enterReasonAndClickRejectButton(REJECTION_MESSAGE);
		assertEquals(iTicketDetailsPage.getTicketStatus(), REJECTED_STATUS);
		assertEquals(iTicketDetailsPage.getReasonForRejection(), REJECTION_MESSAGE);
	}

	@Test(priority = 2)
	public void verify_ticket_status_gets_updated_to_Rejected_on_feed_page_after_rejecting_the_ticket() {
		iTicketDetailsPage.clickOnBackButton();
		assertEquals(iFeedPage.getRejectedTicketStatus(), REJECTED_STATUS);
	}

}
