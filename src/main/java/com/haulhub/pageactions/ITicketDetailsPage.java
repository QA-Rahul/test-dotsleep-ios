package com.haulhub.pageactions;

public interface ITicketDetailsPage {

	String getTicketId();

	boolean areDeliveredAndRejectButtonsEnabled();
	
	public void clickOnRejectButton();
	
	public void enterReasonAndClickRejectButton(String reason);
	
	public void clickOnBackButton();
	
	public String getReasonForRejection();
	
	public String getTicketStatus();

}
