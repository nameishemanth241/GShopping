package com.skillrary.gshopping.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.skillrary.gshopping.genericlibs.FUtil;
import com.skillrary.gshopping.genericlibs.IAutoConstants;
import com.skillrary.gshopping.pom.HomePage;
import com.skillrary.gshopping.pom.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements IAutoConstants {
	WebDriver driver;
	WebDriverWait wait;
	@Parameters({"browserName", "appUrl", "implicit", "explicit"})
	@BeforeClass(alwaysRun=true)
	public void openApp(@Optional(DEFAULT_BROWSER)String browserName,
						@Optional(APP_URL)String appUrl,
						@Optional(ITO)String implicit,
						@Optional(ETO)String explicit) {
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			Assert.fail("Browser not supported");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Long.parseLong(implicit), TimeUnit.SECONDS);
		driver.get(appUrl);
		wait = new WebDriverWait(driver, Long.parseLong(explicit));
	}
	
	@Parameters({"username", "password"})
	@BeforeMethod(alwaysRun=true)
	public void login(@Optional(DEFAULT_USERNAME)String username,
					  @Optional(DEFAULT_PASSWORD)String password) {
		LoginPage lp = new LoginPage(driver);
		lp.getSignInLink().click();
		lp.getEmailTextField().sendKeys(username);
		lp.getPasswordField().sendKeys(password);
		lp.getSignInButton().click();
	}
	
	@AfterMethod(alwaysRun=true)
	public void logout(ITestResult result) {
		if(!result.isSuccess()) {
			FUtil.getSnapshot(driver, result.getName());
		}
		HomePage hp = new HomePage(driver);
		hp.getSignOutLink().click();
	}
	
	@AfterClass(alwaysRun=true)
	public void closeApp() {
		driver.quit();
	}
}
