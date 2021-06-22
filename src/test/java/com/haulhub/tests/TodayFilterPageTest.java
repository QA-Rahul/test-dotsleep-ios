package com.haulhub.tests;

import com.haulhub.TestSession;
import com.haulhub.pageactions.ILoginPage;

import com.haulhub.pageactions.ITodayFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TodayFilterPageTest extends TestSession {

    private static final Logger LOGGER = LoggerFactory.getLogger(TodayFilterPageTest.class);

    private ILoginPage iLoginPage;
    private ITodayFilter iTodayFilter;
    private String truckNumber="PNM84-102",status="Pending",ticketNumber="654123";


    @BeforeClass(alwaysRun = true)
    public void class_objects_setup() throws Exception {
        LOGGER.info("Running DOTslip Today tests");
        iLoginPage = initPlatformPage(iLoginPage, "LoginPageAction");
        iLoginPage.signInToApp();
        iTodayFilter = initPlatformPage(iTodayFilter, "TodayFilterPageAction");
    }

    @Test(priority = 0)
    public void verifyTodayFilterForTruckNumber() {
        iTodayFilter.clickOnSearchIcon();
        iTodayFilter.applyFilter();
        iTodayFilter.clickOnProject();
        Assert.assertTrue(iTodayFilter.verifyingSearch(truckNumber),"Unable to verify search for Truck Number");
    }

    @Test(priority = 1)
    public void verifyTodayFilterForTicketNumber() {
        iTodayFilter.clickOnBackBtn();
        Assert.assertTrue(iTodayFilter.verifyingSearch(ticketNumber),"Unable to verify search for Ticket Number");
    }

    @Test(priority = 2)
    public void verifyTodayFilterForStatus() {
        iTodayFilter.clickOnBackBtn();
        Assert.assertTrue(iTodayFilter.verifyingSearch(status),"Unable to verify search for Status");
    }

}
