package com.skillrary.gshopping.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailsPage {
	@FindBy(xpath="//i[@class='icon-plus']")
	private WebElement plusIcon;
	
	@FindBy(id="group_1")
	private WebElement sizeListBox;
	
	@FindBy(xpath="//ul[@id='color_to_pick_list']/li/a")
	private List<WebElement> colorPickerList;
	
	@FindBy(name="Submit")
	private WebElement addToKartButton;
	
	@FindBy(linkText="Proceed to checkout")
	private WebElement proceedToCheckoutButton;
	
	public ProductDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getPlusIcon() {
		return plusIcon;
	}

	public WebElement getSizeListBox() {
		return sizeListBox;
	}

	public List<WebElement> getColorPickerList() {
		return colorPickerList;
	}

	public WebElement getAddToKartButton() {
		return addToKartButton;
	}

	public WebElement getProceedToCheckoutButton() {
		return proceedToCheckoutButton;
	}
	
	public void clickOnColor(String colorName) {
		for(WebElement ele:colorPickerList) {
			if(ele.getAttribute("name").equalsIgnoreCase(colorName)) {
				ele.click();
				break;
			}
		}
	}
	
	public void selectSize(String size) {
		Select s = new Select(sizeListBox);
		s.selectByVisibleText(size);
	}
	
}
