package com.project.pages;

import org.openqa.selenium.WebDriver;

public class Homepage{
	WebDriver driver;
	
	public Homepage(WebDriver driver) {
		this.driver=driver;
	}   
	public  void property(String url) throws Exception
	{  
	    driver.get(url);
        Thread.sleep(3000);
        
       
    
	}
	
}
