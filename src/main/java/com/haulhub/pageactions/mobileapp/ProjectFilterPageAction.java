package com.haulhub.pageactions.mobileapp;

import com.haulhub.framework.utils.UtilsComponent;
import com.haulhub.pageactions.IProjectFilter;
import com.haulhub.pagefactory.mobileapp.ProjectFilterPoFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProjectFilterPageAction extends UtilsComponent implements IProjectFilter {

    private ProjectFilterPoFactory projectFilterPoFactory;
    private String currentClassName,truckNumber="PNM84-102",text,ticketNumber="654123",filterValue;
    private boolean isMatched;

    AppiumDriver<MobileElement> appiumDriver;

    @SuppressWarnings("unchecked")
    public ProjectFilterPageAction(WebDriver driver) {
        super(driver);
        appiumDriver = (AppiumDriver<MobileElement>) driver;
        projectFilterPoFactory = new ProjectFilterPoFactory(appiumDriver);
        currentClassName = getCurrentClassName();
    }

    public void clickOnSearchIcon() {
        waitForElementToLoad();
        Reporter.log(currentClassName + ": Clicking on My Projects Tab", true);
        projectFilterPoFactory.myProjectTab.click();
        sleep(2000);
        Reporter.log(currentClassName + ": Clicking on Search Icon", true);
        projectFilterPoFactory.searchBtn.click();
        sleep(2000);
    }

    public void applyFilter(){
        waitForElementToLoad();
        Reporter.log(currentClassName + ": Entering Truck Number: "+truckNumber, true);
        projectFilterPoFactory.truckNumberTextBox.sendKeys(truckNumber);
        sleep(2000);
        Reporter.log(currentClassName + ": Entering Ticket Number: "+ticketNumber, true);
        projectFilterPoFactory.ticketNumberTextBox.sendKeys(ticketNumber);
        sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) appiumDriver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "down");
        js.executeScript("mobile: scroll", scrollObject);
        sleep(2000);
        Reporter.log(currentClassName + ": Clicking statusPending", true);
        projectFilterPoFactory.statusPending.click();
        sleep(2000);
        Reporter.log(currentClassName + ":  Clicking on Apply Filter Button", true);
        projectFilterPoFactory.applyBtn.click();
        sleep(2000);
    }

    public void clickOnProject(){
        waitForElementToLoad();
        Reporter.log(currentClassName + ": Clicking Project Name", true);
        projectFilterPoFactory.projectName.click();
        sleep(2000);
    }

    public boolean verifyingSearch(String filterValue){
        sleep(2000);
        appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) appiumDriver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "down");
        js.executeScript("mobile: scroll", scrollObject);
        sleep(2000);
        Reporter.log(currentClassName + ": Verifying Search result", true);
        List<MobileElement> elements= projectFilterPoFactory.tickets;
        outer:
        for(int i=0; i<elements.size(); i++) {
            waitForElementToLoad();
            elements.get(i).click();
            sleep(2000);
            waitForElementToLoad();
            List<MobileElement> verifyElement = appiumDriver.findElements(By.xpath("//XCUIElementTypeStaticText[contains(@name, '" + filterValue + "')]"));
            sleep(3000);
            int size = verifyElement.size();
            Reporter.log(currentClassName + ": Size of element is :" + size, true);
            if (size > 0) {
                inner:
                for (int j = 0; j < size; j++) {
                    text = verifyElement.get(j).getText();
                    Reporter.log(currentClassName + ": Text Value is :" + text, true);
                    if (text.contains(filterValue)) {
                        isMatched = true;
                        break outer;
                    }
                }
            } else {
                isMatched = false;
                sleep(2000);
                projectFilterPoFactory.backBtn.click();
            }
        }
        Reporter.log(currentClassName + ": Value of isMatched is :"+isMatched, true);
        return isMatched;

    }

    public void clickOnBackBtn(){
        Reporter.log(currentClassName + ":CLicking on Back Button", true);
        sleep(2000);
        projectFilterPoFactory.backBtn.click();
    }

    public String checkTicketWithRejectStatus(){
        clickOnBackBtn();
        sleep(2000);
        scrollDown(appiumDriver);
        Reporter.log(currentClassName + ": Checking Tickets for status reject", true);
        List<MobileElement> elements= projectFilterPoFactory.tickets;
        for(int i=0; i<elements.size(); i++) {
            waitForElementToLoad();
            elements.get(i).click();
            sleep(2000);
            waitForElementToLoad();
            List<MobileElement> verifyElement = appiumDriver.findElements(By.xpath("//XCUIElementTypeStaticText[contains(@name, 'Rejected')]"));
            sleep(3000);
            int size = verifyElement.size();
            Reporter.log(currentClassName + ": Size of element rejected is :" + size, true);
            if (size > 0) {
                filterValue="Found";
            } else {
                filterValue="No Slips";
                sleep(2000);
                projectFilterPoFactory.backBtn.click();
            }
        }
        Reporter.log(currentClassName + ": Value of Feed filter before search is :"+isMatched, true);
        return filterValue;

    }

    public void applyFilterOnFeed(){
        clickOnBackBtn();
        Reporter.log(currentClassName + ":CLicking on Back Button for Project", true);
        sleep(2000);
        projectFilterPoFactory.backBtnForProject.click();
        Reporter.log(currentClassName + ":CLicking on Feed Tab", true);
        sleep(2000);
        projectFilterPoFactory.feedTab.click();
        Reporter.log(currentClassName + ": Clicking on Search Icon", true);
        projectFilterPoFactory.searchBtn.click();
        sleep(2000);
        waitForElementToLoad();
        Reporter.log(currentClassName + ": Scrolling down", true);
        scrollDown(appiumDriver);
        Reporter.log(currentClassName + ": Clicking statusPending", true);
        projectFilterPoFactory.statusRejected.click();
        sleep(2000);
        Reporter.log(currentClassName + ":  Clicking on Apply Filter Button", true);
        projectFilterPoFactory.applyBtn.click();
        sleep(2000);
    }

    public String verifySearchForFeed(){
        waitForElementToLoad();
        sleep(2000);
        Reporter.log(currentClassName + ": Verifying Result for feed search", true);
        text= projectFilterPoFactory.noResultForFeed.getAttribute("value");
        Reporter.log(currentClassName + ": Value of Feed filter after search is :"+text, true);
        return text;
    }
}
