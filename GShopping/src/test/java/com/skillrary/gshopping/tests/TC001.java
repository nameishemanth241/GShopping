package com.skillrary.gshopping.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.skillrary.gshopping.genericlibs.ExcelLibrary;
import com.skillrary.gshopping.pom.CategoryPage;
import com.skillrary.gshopping.pom.HomePage;
import com.skillrary.gshopping.pom.OrderDetailsPage;
import com.skillrary.gshopping.pom.ProductDetailsPage;

public class TC001 extends BaseTest {
	@Test
	public void testAddProductToKart() {
		String productId = ExcelLibrary.getData("TC001", 1, 0).split("\\.")[0];
		String color = ExcelLibrary.getData("TC001", 1, 1);
		
		HomePage hp = new HomePage(driver);
		hp.getDressesMenuLink().click();
		
		CategoryPage c = new CategoryPage(driver);
		c.clickOnProduct(productId);
		
		ProductDetailsPage pdp = new ProductDetailsPage(driver);
		pdp.getPlusIcon().click();
		pdp.getPlusIcon().click();
		pdp.getPlusIcon().click();
		pdp.clickOnColor(color);
		pdp.getAddToKartButton().click();
		pdp.getProceedToCheckoutButton().click();
		
		OrderDetailsPage odp = new OrderDetailsPage(driver);
		Assert.assertTrue(odp.verifyProduct(productId));
	}
}
