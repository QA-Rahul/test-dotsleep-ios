package com.haulhub.pageactions;

public interface ITicketsByDayPage {

	public boolean isProjectOverviewDisplayed();

	public void clickOnTicketDetails();

	public boolean isMarkDeliveredButtonEnabled();

	public boolean isAddUserButtonAvailable();

	public void clickProjectsTicketBackButton();
	
	public INewInspectorPage clickOnNewInspectorButton();

}
