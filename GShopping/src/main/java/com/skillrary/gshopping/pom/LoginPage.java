package com.skillrary.gshopping.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(linkText="Sign in")
	private WebElement signInLink;
	
	@FindBy(id="email")
	private WebElement emailTextField;
	
	@FindBy(id="passwd")
	private WebElement passwordField;
	
	@FindBy(id="SubmitLogin")
	private WebElement signInButton;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSignInLink() {
		return signInLink;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getSignInButton() {
		return signInButton;
	}
	
}
