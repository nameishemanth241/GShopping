package com.skillrary.gshopping.pom;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[@class='product_img_link']")
	private List<WebElement> productsList;

	public List<WebElement> getProductsList() {
		return productsList;
	}
	
	public CategoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void clickOnProduct(String productId) {
		for(WebElement ele:productsList) {
			if(ele.getAttribute("href").contains(productId)) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("arguments[0].click();", ele);
				break;
			}
		}
	}
}
