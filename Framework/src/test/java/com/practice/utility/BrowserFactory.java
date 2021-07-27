package com.practice.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	
	
	public static WebDriver startApplication(WebDriver driver,String browserName,String applicationURL) {
		
		if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromeDriver.exe");
			driver=new ChromeDriver();
		}
		
		else if(browserName.equals("FireFox")) {
			// Not Supported as of now
		}
		
		else if(browserName.equals("IE")) {
			// Not Supported as of now
		}
		
		else {
			System.out.println(browserName+" is not supported");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(applicationURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}

}
