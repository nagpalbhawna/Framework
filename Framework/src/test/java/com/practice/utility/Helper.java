package com.practice.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Helper {
	
	public static String captureScreenshot(WebDriver driver) {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots/Pratice"+getCurrentDateTime()+".png";
		
		try {			
			FileHandler.copy(src, new File(screenshotPath));
			Reporter.log("Screenshot captured");
		} catch (IOException e) {
			Reporter.log("Unable to capture screenshot "+e.getMessage());
		}
		
		return screenshotPath;
	}
	
	public static String getCurrentDateTime() {
		DateFormat format=new SimpleDateFormat("MM_dd_yyyy_HH_mm_Ss");
		Date date=new Date();
		return format.format(date);
	}
	
	public void handleFrames() {
		
	}
	
	public void handleAlerts() {
		
	}
	
	//Handle sync,javascript executor, handle multiple windows

}
