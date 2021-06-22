package com.haulhub.pageactions.mobileapp;

import com.haulhub.framework.utils.UtilsComponent;
import com.haulhub.pageactions.ITodayFilter;
import com.haulhub.pagefactory.mobileapp.ProjectFilterPoFactory;
import com.haulhub.pagefactory.mobileapp.TodayFilterPoFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class TodayFilterPageAction extends UtilsComponent implements ITodayFilter {

    private ProjectFilterPoFactory projectFilterPoFactory;
    private TodayFilterPoFactory todayFilterPoFactory;
    private String currentClassName,truckNumber="PNM84-102",text,ticketNumber="654123";
    private boolean isMatched;

    AppiumDriver<MobileElement> appiumDriver;

    @SuppressWarnings("unchecked")
    public TodayFilterPageAction(WebDriver driver) {
        super(driver);
        appiumDriver = (AppiumDriver<MobileElement>) driver;
        projectFilterPoFactory = new ProjectFilterPoFactory(appiumDriver);
        todayFilterPoFactory= new TodayFilterPoFactory(appiumDriver);
        currentClassName = getCurrentClassName();
    }

    public void clickOnSearchIcon() {
        waitForElementToLoad();
        Reporter.log(currentClassName + ": Clicking on My Today Tab", true);
        todayFilterPoFactory.todayTab.click();
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
        scrollDown(appiumDriver);
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
        scrollDown(appiumDriver);
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

}
