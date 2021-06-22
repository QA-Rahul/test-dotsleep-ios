package com.haulhub.tests;

import com.haulhub.TestSession;
import com.haulhub.pageactions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ProjectFilterPageTest extends TestSession{

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectFilterPageTest.class);

    private ILoginPage iLoginPage;
    private IProjectFilter iProjectFilter;
    private String truckNumber="PNM84-102",status="Pending",ticketNumber="654123",expectedValue,actualValue;


    @BeforeClass(alwaysRun = true)
    public void class_objects_setup() throws Exception {
        LOGGER.info("Running DOTslip Today tests");
        iLoginPage = initPlatformPage(iLoginPage, "LoginPageAction");
        iLoginPage.signInToApp();
        iProjectFilter = initPlatformPage(iProjectFilter, "ProjectFilterPageAction");
    }

    @Test(priority = 0)
    public void verifyProjectFilterForTruckNumber() {
        iProjectFilter.clickOnSearchIcon();
        iProjectFilter.applyFilter();
        iProjectFilter.clickOnProject();
        Assert.assertTrue(iProjectFilter.verifyingSearch(truckNumber),"Unable to verify search for Truck Number");
    }

    @Test(priority = 1)
    public void verifyProjectFilterForTicketNumber() {
        iProjectFilter.clickOnBackBtn();
        Assert.assertTrue(iProjectFilter.verifyingSearch(ticketNumber),"Unable to verify search for Ticket Number");
    }

    @Test(priority = 2)
    public void verifyProjectFilterForStatus() {
        iProjectFilter.clickOnBackBtn();
        Assert.assertTrue(iProjectFilter.verifyingSearch(status),"Unable to verify search for Status");
    }

    @Test(priority = 3)
    public void verifyFilterOnFeed() {
        expectedValue= iProjectFilter.checkTicketWithRejectStatus();
        iProjectFilter.applyFilterOnFeed();
        actualValue= iProjectFilter.verifySearchForFeed();
        Assert.assertEquals(actualValue,expectedValue,"Filter Result is not same");
    }
}
