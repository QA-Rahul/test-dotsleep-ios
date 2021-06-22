package com.haulhub.tests;

import com.haulhub.TestSession;
import com.haulhub.pageactions.ILoginPage;
import com.haulhub.pageactions.INavigationBar;
import com.haulhub.pageactions.ITicketDetailsPage;
import com.haulhub.pageactions.ITodayPage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class DotSlipTodayPageTest extends TestSession {

	private static final Logger LOGGER = LoggerFactory.getLogger(DotSlipTodayPageTest.class);

	private ILoginPage iLoginPage;
	private INavigationBar iNavigationBar;
	private ITodayPage iTodayPage;
	private ITicketDetailsPage iTicketDetailsPage;

	@BeforeClass(alwaysRun = true)
	public void class_objects_setup() throws Exception {
		LOGGER.info("Running DOTslip Today tests");
		iLoginPage = initPlatformPage(iLoginPage, "LoginPageAction");
		iLoginPage.signInToApp();
		iNavigationBar = initPlatformPage(iNavigationBar, "NavigationBarAction");
		iTodayPage = initPlatformPage(iTodayPage, "TodayPageAction");
	}

	@Test(priority = 0)
	public void verify_today_page_is_displayed_and_today_button_is_selected() {
		iNavigationBar.clickOnMyProjectsButton();
		iNavigationBar.clickOnTodayButton();
		assertTrue(iNavigationBar.isTodayButtonSelected(), "Today button is not selected");

	}

	@Test(priority = 1, enabled = false)
	public void verify_user_is_able_to_click_into_a_project_and_mark_delivered_button_is_enabled() {
		iTodayPage.clickOnAProject();
		assertTrue(iTodayPage.isMarkDeliveredButtonEnabled(),
				"Mark delivered button is not enabled on the ticket after clicking on a project");
	}

	@Test(priority = 2, enabled = false)
	public void verify_clicking_on_a_ticket_opens_the_correct_ticket_details_page() {
		String ticketId = iTodayPage.getTicketId();
		iTicketDetailsPage = iTodayPage.clickOnATicket();
		assertTrue(iTicketDetailsPage.getTicketId().contains(ticketId),
				"Ticket Id's on Today page and Ticket Details page do not match");
	}

	@Test(priority = 3, enabled = false)
	public void verify_delivered_reject_buttons_are_enabled_after_clicking_into_the_ticket() {
		assertTrue(iTicketDetailsPage.areDeliveredAndRejectButtonsEnabled(),
				"Delivered and Reject buttons are not enabled on Ticket Details page");
	}

}
