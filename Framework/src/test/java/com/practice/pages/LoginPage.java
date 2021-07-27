package com.practice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	 @FindBy(how = How.CLASS_NAME, using = "login") 
	 private WebElement loginLink;
	 
	 @FindBy(how = How.ID, using = "email") 
	 private WebElement email;
	 
	 @FindBy(how = How.ID, using = "passwd") 
	 private WebElement pswrd;
	 
	 @FindBy(how = How.ID, using = "SubmitLogin") 
	 private WebElement signInButton;
	 
	 
	 public void loginToApp(String emailId,String password) {
		 loginLink.click();
		 email.sendKeys(emailId);
		 pswrd.sendKeys(password);
		 signInButton.click();
	 }
	 
	
}
