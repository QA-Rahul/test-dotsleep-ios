package com.haulhub.tests;

import static org.testng.Assert.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.haulhub.TestSession;
import com.haulhub.pageactions.ILoginPage;
import com.haulhub.pageactions.ISignUpPage;

public class DotSlipSignUpPageTest extends TestSession {

	private static final Logger LOGGER = LoggerFactory.getLogger(DotSlipSignUpPageTest.class);

	private ILoginPage iLoginPage;
	private ISignUpPage iSignUpPage;

	@BeforeClass(alwaysRun = true)
	public void class_objects_setup() throws Exception {
		LOGGER.info("Running DOTslip My Projects page tests");
		iLoginPage = initPlatformPage(iLoginPage, "LoginPageAction");
		iSignUpPage = iLoginPage.clickOnEnterMyCodeButton();
	}

	@Test(priority = 1)
	public void verify_that_dot_slip_logo_is_displayed() {
		assertTrue(iSignUpPage.isDotSlipLogoEnabled(), "DOTslip logo in not displayed on SignUp page");
	}

	@Test(priority = 2)
	public void verify_that_enter_my_code_logo_is_displayed() {
		assertTrue(iSignUpPage.isEnterMyCodeLogoDisplayed(), "Enter My Code logo in not displayed on SignUp page");
	}

	@Test(priority = 3)
	public void verify_submit_button_gets_enabled_on_entering_the_values() {
		iSignUpPage.enterPhoneNumber();
		iSignUpPage.enterInvitationCode();
		iSignUpPage.enterPassword();
		iSignUpPage.enterConfirmPassword();
		assertTrue(iSignUpPage.isSubmitButtonEnabled(),
				"Submit button does not get enabled on entering the values on SignUp page");
	}

	@Test(priority = 4)
	public void verify_that_contact_us_button_is_displayed_and_enabled() {
		assertTrue(iSignUpPage.isContactUsButtonDisplayedAndEnabled(), "Contact Us button is not displyed or enabled");
	}

	@Test(priority = 5)
	public void verify_that_clicking_on_already_have_an_account_link_navigates_to_login_page() {
		iSignUpPage.clickOnAlreadyHaveAnAccountLink();
		assertTrue(iLoginPage.isLoginLogoDisplayed(),
				"Clicking on Already Having An Account does not navigate to the login page");
	}
}
