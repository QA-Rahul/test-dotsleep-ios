package com.haulhub.pageactions;

public interface IFeedPage {

	String getTicketNumber();

	boolean isFirstTicketDisplayed();

	ITicketDetailsPage clickOnFirstTicket();
	
	String getRejectedTicketStatus();

}
