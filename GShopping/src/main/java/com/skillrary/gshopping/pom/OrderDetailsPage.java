package com.skillrary.gshopping.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderDetailsPage {
	@FindBy(xpath="//td[@class='cart_product']/a")
	private List<WebElement> productsList;
	
	@FindBy(xpath="//a[@title='Delete']")
	private List<WebElement> deleteIconList;
	
	public List<WebElement> getProductsList() {
		return productsList;
	}

	public List<WebElement> getDeleteIconList() {
		return deleteIconList;
	}

	public OrderDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> getAllProductsList() {
		return productsList;
	}
	
	public boolean verifyProduct(String productId) {
		for(WebElement ele:productsList) {
			if(ele.getAttribute("href").contains(productId)) {
				return true;
			}
		}
		return false;
	}

	public void deleteProduct(String productId) {
		for(WebElement ele:deleteIconList) {
			if(ele.getAttribute("href").contains(productId)) {
				ele.click();
			}
		}	
	}
	
}
