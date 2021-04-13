package pages;


import base.basePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

public class AlertsPage extends basePage
{
    @FindBy(id="timerAlertButton") public WebElement SecondAlertBtn;

    public void init()
    {
        PageFactory.initElements(driver,this);
    }
    public void openalert_url()
    {
    	 driver.navigate().to(prop.getProperty("alert_url"));
    }
    public void secondAlertBtn()
    {
        SecondAlertBtn.click();
        try {Thread.sleep(3000);}catch(Exception e) {}
        
        testlog=report.createTest("Alert Test");
    	testlog.log(Status.INFO, "Alert is displayed");
    	takescreenshot("popupalert.png");
    	
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

}
