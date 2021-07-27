package com.practice.testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.practice.pages.BaseClass;
import com.practice.pages.HomePage;
import com.practice.pages.LoginPage;
import com.practice.utility.ExcelDataProvider;
import com.practice.utility.Helper;

public class LoginTestAutomationPractice extends BaseClass {
	
	@Test
	public void loginApp() {
		
		logger=report.createTest("Login to application");
		
		LoginPage loginPage=PageFactory.initElements(driver,LoginPage.class);
		
		logger.info("Starting application");
		
		loginPage.loginToApp(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		HomePage homePage=PageFactory.initElements(driver, HomePage.class);	
		
		assertTrue(homePage.HomePageDisplayed(), "Home Page is not displayed");
	}

}
