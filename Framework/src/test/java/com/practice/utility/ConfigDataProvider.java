package com.practice.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider() {
		
		
		FileInputStream fis;
		try {
			File src=new File("./Configuration/Config.properties");
			fis = new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Not able to load config file "+e.getMessage());
		} 
	}
	
	public String getDataFromConfig(String keyName) {
		return pro.getProperty(keyName);
	}
	
	public String getBrowser() {
		return pro.getProperty("Browser");
	}
	
	public String getStagingURL() {
		return pro.getProperty("qaURL");
	}

}
