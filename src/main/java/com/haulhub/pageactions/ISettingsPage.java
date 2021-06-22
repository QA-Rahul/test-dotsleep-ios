package com.haulhub.pageactions;

public interface ISettingsPage {

	void clickOnEditButton();
	
	boolean isFirstNameTextFieldEnabled();
	
	boolean isLastNameTextFieldEnabled();
	
	boolean isPhoneNumberTextFieldEnabled();
	
	boolean isEmailTextFieldEnabled();
	
	void clickOnChangePasswordButton();
	
	void enterNewPassword(String newPassword);
	
	boolean isSaveButtonEnabled();
	
	public void clickOnCancelButton();
	
	public void clickOnDoneButton();
	
	public boolean isVersionDisplayed();
	
	public boolean isPermissionSettingsDisplayed();
}
