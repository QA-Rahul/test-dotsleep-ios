package com.haulhub.pageactions;

public interface INewInspectorPage {
	
	public void enterValuesOnNewInspectorPage(String firstName, String lastName, String email, String phone);
	
	public boolean isAddInspectorButtonEnabled();

}
