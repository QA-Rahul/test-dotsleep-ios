package com.haulhub.pageactions;

public interface ITodayPage {
	
	public void clickOnAProject();
	
	public boolean isMarkDeliveredButtonEnabled();
	
	public ITicketDetailsPage clickOnATicket();
	
	public String getTicketId();

}
