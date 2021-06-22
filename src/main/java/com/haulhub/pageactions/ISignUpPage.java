package com.haulhub.pageactions;

public interface ISignUpPage {

	public void enterPhoneNumber();

	public void enterInvitationCode();

	public void enterPassword();

	public void enterConfirmPassword();

	public boolean isSubmitButtonEnabled();
	
	public boolean isEnterMyCodeLogoDisplayed();

	public boolean isDotSlipLogoEnabled();
	
	public ILoginPage clickOnAlreadyHaveAnAccountLink();
	
	public boolean isContactUsButtonDisplayedAndEnabled();
}
