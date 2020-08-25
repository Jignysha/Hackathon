package com.project.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile_Reader {
		public Properties propertiesvalues () throws IOException, Exception
		{
			Properties obj = new Properties();
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//Properties file//Values.properties");
		    obj.load(file); 
			return obj;
		
		    }  
		public Properties propertiesLocators () throws IOException, Exception
		{
			Properties obj = new Properties();
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//Properties file//Locators.properties");
		    obj.load(file); 
			return obj;
		
		    }
		
		 
	}

	
	

