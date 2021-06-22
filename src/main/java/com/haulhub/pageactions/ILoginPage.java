package com.haulhub.pageactions;

public interface ILoginPage {

	public IHomePage signInToApp();
	
	public ISignUpPage clickOnEnterMyCodeButton();
	
	public boolean isLoginLogoDisplayed();
}
