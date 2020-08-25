package com.project.pages;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmiPage {
WebDriver driver;
	
	public EmiPage(WebDriver driver) {
		this.driver=driver;
	} 
	    public  void Carloan(String loan) throws Exception
	    {  
	        driver.findElement(By.xpath(loan)).click();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	    }
	    public void amount(String amountpath, String amount) throws Exception 
	    {  
	    	driver.findElement(By.name(amountpath)).sendKeys(Keys.BACK_SPACE,amount);
	    	
	    }
	    public void rate(String Ratepath, String interest) throws Exception 
	    {
	    	driver.findElement(By.id( Ratepath)).sendKeys(Keys.BACK_SPACE,interest);
	    }
	    public void time(String Durationpath, String duration) throws Exception 
	    {
	    	driver.findElement(By.id(Durationpath)).sendKeys(Keys.BACK_SPACE,duration);
	    	Thread.sleep(3000);
	    }	
	    public void scroll(String Forscroll) throws Exception {
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id(Forscroll)));                
	        Thread.sleep(3000);
	 	}
	    public  void clear(String clAmount,String clRate,String clTime ) throws Exception
		 {
			     driver.findElement(By.name(clAmount)).clear();
			     driver.findElement(By.id(clRate)).clear();
			     driver.findElement(By.id(clTime)).clear();
                 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		 }
				public  String[] month_name(String yearpath,String monthpath) throws Exception
				{
					  driver.findElement(By.xpath(yearpath)).click();
					  Thread.sleep(2000);
					  List<WebElement> names=driver.findElements(By.xpath(monthpath));
					  String month[]=new String[names.size()];
					    for(int i=0;i<names.size();i++) {
					    	month[i]=names.get(i).getText();	
					    }return month;
				}
				public  String[] data_amount(String Intersetpath) throws Exception
				{
					    List<WebElement> price= driver.findElements(By.xpath(Intersetpath));
						 String amount[]=new String[price.size()];
					    for(int i=0;i<price.size();i++) {
					    	amount[i]=price.get(i).getText();	}
					    return amount;
					
				}
		
	   
}

