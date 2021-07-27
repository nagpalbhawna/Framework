package com.practice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}

	 @FindBy(how = How.CLASS_NAME, using = "logout") 
	 private WebElement logoutLink;
	 
	 
	 public boolean HomePageDisplayed() {
		return logoutLink.isDisplayed();
	 }
	 
	
}
