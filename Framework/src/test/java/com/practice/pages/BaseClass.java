package com.practice.pages;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.practice.utility.BrowserFactory;
import com.practice.utility.ConfigDataProvider;
import com.practice.utility.ExcelDataProvider;
import com.practice.utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	public Logger txtLogging=Logger.getLogger(BaseClass.class);
	
	static {
		System.setProperty("current.date.time", Helper.getCurrentDateTime());
	}
	 
	@BeforeClass
	public void setUp() {		
		
		txtLogging.info("Trying to start Browser and get application running");
		driver=BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());
		txtLogging.info("Application launched successfully");
	}
	
	@AfterClass
	public void tearDown() {
		txtLogging.info("Test is about to end");

		BrowserFactory.quitBrowser(driver);
		
		txtLogging.info("Driver closed and ending test");
		txtLogging.info("******************************************");
	}
	
	@BeforeSuite
	public void setUpSuite() {
		PropertyConfigurator.configure(".//Configuration//log4j.properties");
		
		txtLogging.info("******************************************");
		txtLogging.info("Setting up Reports and Test Started");
		
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		ExtentHtmlReporter reporter=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Practice_"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(reporter);		
		
		txtLogging.info("Setting done- Test can be run now");
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		try {
			if(result.getStatus()==ITestResult.FAILURE) {
				txtLogging.info("TestCase is Failed");
				logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			}
			
			else if(result.getStatus()==ITestResult.SUCCESS) {
				txtLogging.info("TestCase is Passed");
				logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			}
		} catch (IOException e) {
			logger.info("Error while taking screenshot for logger");
		}

		report.flush();
	}
}
