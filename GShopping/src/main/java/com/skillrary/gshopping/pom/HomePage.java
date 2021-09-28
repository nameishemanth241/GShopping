package com.skillrary.gshopping.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath="(//a[text()='Dresses'])[2]")
	private WebElement dressesMenuLink;
		
	@FindBy(linkText="Sign out")
	private WebElement signOutLink;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getDressesMenuLink() {
		return dressesMenuLink;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
}
