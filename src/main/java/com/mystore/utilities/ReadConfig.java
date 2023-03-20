package com.mystore.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig() 	// creating constructor for ReadConfig class
	{ 	
		File src = new File("./Configuration/config.properties");	// making an object of file class to store the config.properties file
		
		// putting the code of reading the config.properties file in try catch block as there is chance of not getting the file at the 
		// specified location
		try {
			
			FileInputStream fis = new FileInputStream(src);	// importing and reading the config file using FileInputStream class
			prop = new Properties();	// initiating the object of Properties class.
			prop.load(fis);		// load method will load the complete config.properties file
			
		} catch(Exception e)
		{
			System.out.println("Exception is: " + e);
		}	
		
	}
	
	// making different methods for each variable to read their value. So they will have a return type as they will return certain value
	
	public String getApplicationUrl() 
	{
		return prop.getProperty("baseURL");
	}
	
	public String getUserName() 
	{
		return prop.getProperty("username");
	}
	
	public String getPassword() 
	{
		return prop.getProperty("password");
	}
	
	public String getBrowser() 
	{
		return prop.getProperty("browser");
	}
	
	
}
