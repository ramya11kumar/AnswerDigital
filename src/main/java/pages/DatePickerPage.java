package pages;

import base.basePage;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;


public class DatePickerPage extends basePage
{
	
    @FindBy(id="datePickerMonthYearInput") public WebElement DatePickerField;
    @FindBy(className = "react-datepicker__month-select") public WebElement MonthSelector;

    public void init()
    {       
        PageFactory.initElements(driver,this);
    }
    public void opendate_url()
    {
    	driver.navigate().to(prop.getProperty("date_url"));        
    }
    public void selectDate() throws InterruptedException
    {
    	
    	Date nd = DateUtils.addMonths(new Date(), 1);
    	System.out.println(nd);
	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	    String newformatdate=formatter.format(nd);
	    Thread.sleep(5000);
	    JavascriptExecutor js=(JavascriptExecutor) driver;
	    js.executeScript("document.getElementById('datePickerMonthYearInput').value = '"+newformatdate+"'");
	    try {Thread.sleep(3000);}catch(Exception e) {}
        
        testlog=report.createTest("Date Selection");
    	testlog.log(Status.INFO, "After 1 month from today date selected");
    	takescreenshot("datepick.png");

    	
       
    }



}
