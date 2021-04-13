package pages;


import base.basePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

public class HoverPage extends basePage
{
    
    @FindBy(id="toolTipButton") public WebElement HoverBtn;
    @FindBy(id="toolTipTextField") public WebElement HoverTextField;

    public  void init()
    {        
        PageFactory.initElements(driver,this);
    }
    
    public void openhover_url()
    {
    	 driver.navigate().to(prop.getProperty("hover_url"));        
    }
    public void hoverBtn(){
        Actions a = new Actions(driver);
        a.moveToElement(HoverBtn).click().perform();
               
        testlog=report.createTest("Hover button");
    	testlog.log(Status.INFO, "Hover on button message displayed");
    	takescreenshot("hoverbutton.png");
    	try {Thread.sleep(5000);}catch(Exception e) {}
    }
        public void hoverTextField(){
        Actions a1 = new Actions(driver);
        a1.moveToElement(HoverTextField).click().perform();
        
        testlog=report.createTest("Hover TextField");
    	testlog.log(Status.INFO, "Hover on TextField message displayed");
    	takescreenshot("hovertext.png");
        
        try {Thread.sleep(5000);}catch(Exception e) {}
    }


}

