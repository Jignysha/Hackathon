package com.project.test;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.project.base.Driversetup;
import com.project.pages.EmiPage;
import com.project.pages.Homepage;
import com.project.base.Screenshot;
import com.project.data.PropertiesFile_Reader;
import com.project.data.Excel_Data;

@Listeners(com.project.report.ExtentReport.class)
public class EmiCalculator extends Driversetup{
	 WebDriver driver;
	 Homepage page;EmiPage emi;PropertiesFile_Reader data; Screenshot shot;Excel_Data excel;
     Properties value,path;
     String month[],amount[],url;
 	
    @BeforeTest(groups= {"smoke","regression"})
    @Parameters("browser")
	public void Set(String browser) throws Exception 
    {  
    	driver=setup(browser);data=new PropertiesFile_Reader();
        page=new Homepage(driver);emi=new EmiPage(driver);
        shot=new Screenshot(driver);
        path=data.propertiesLocators();
        value=data.propertiesvalues();
        excel=new Excel_Data();
        url=excel.read(); 		
     }
    
    @Test(priority=1,groups= {"smoke","regression"})
    void Homepage() throws Exception{
    	page.property(url); 	
     	shot.takeSnapShot(driver,value.getProperty("Home_shot"));			
     	}
    @Test(priority=2,groups= {"smoke","regression"})
    void CarloanPage() throws Exception {
    	emi.Carloan(path.getProperty("Car_Loan"));	 
    }
    @Test(priority=3,groups= "regression")
    void ClearPreSetData() throws Exception {
    	 emi.clear(path.getProperty("Loan_Amount"),path.getProperty("Loan_Interest"),path.getProperty("Loan_Term"));
    }  
    @Test(priority=4,groups="regression")
    void DataInput() throws Exception {
    	emi.amount(path.getProperty("Loan_Amount"), value.getProperty("AMOUNT"));	 
        emi.rate(path.getProperty("Loan_Interest"), value.getProperty("RATE"));
        emi.time(path.getProperty("Loan_Term"), value.getProperty("TIME"));
    	shot.takeSnapShot(driver,value.getProperty("EmiData_shot"));
     }   
    @Test(priority=5,groups= {"smoke","regression"})
    void Scroll() throws Exception {
    	emi.scroll(path.getProperty("Scroll"));
    }
    @Test(priority=6,groups= "regression")
     void FetchEmiValues() throws Exception {
    	month=emi.month_name(path.getProperty("Year"),path.getProperty("Month"));
        amount=emi.data_amount(path.getProperty("Amount"));
        shot.takeSnapShot(driver,value.getProperty("EmiInterest_shot"));
        excel.write(month, amount);
   } 
    @AfterTest(groups= {"smoke","regression"})
    void End() throws Exception
    {
    driver.close();
    }  
} 


