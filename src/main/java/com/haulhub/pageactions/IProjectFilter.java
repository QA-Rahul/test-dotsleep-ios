package com.haulhub.pageactions;

public interface IProjectFilter {

    public void clickOnSearchIcon();

    public void applyFilter();

    public void clickOnProject();

    public boolean verifyingSearch(String filterValue);

    public void clickOnBackBtn();

    public String checkTicketWithRejectStatus();

    public void applyFilterOnFeed();

    public String verifySearchForFeed();

}
