package com.haulhub.pageactions;

public interface INavigationBar {

	ILeftNavigationPanel clickOnHamburgerMenu();
	
	IMyProjectsPage clickOnTodayButton();

	IMyProjectsPage clickOnMyProjectsButton();

	IFeedPage clickOnFeedButton();

	ISearchPage clickOnSearchIcon();
	
	boolean isTodayButtonSelected();

}
