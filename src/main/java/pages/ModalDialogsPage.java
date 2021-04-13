package pages;


import base.basePage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

public class ModalDialogsPage extends basePage
{
    @FindBy(id="showSmallModal") public WebElement SmallModalBtn;
    @FindBy(xpath="//div[@class='modal-body']") public WebElement ModalText;
    @FindBy(id="closeSmallModal") public WebElement closeBtn;
    

    public void init()
    {
       PageFactory.initElements(driver,this);
    }
    public void openmodel_url()
    {
    	 driver.navigate().to(prop.getProperty("model_url"));      
    }
    public void clickSmallModalBtn()
    {
        SmallModalBtn.click();

    }
    public void modalText()
    {
        String str= ModalText.getText();
       
        try {Thread.sleep(3000);}catch(Exception e) {}
        
        testlog=report.createTest("Small model");
    	testlog.log(Status.INFO, "Small model is displayed"+str);
    	takescreenshot("smallmodel.png");
        System.out.println(str);
    }
    public void ClickCloseSmallModBtn() throws InterruptedException
    {
    	Thread.sleep(3000);
    	closeBtn.click();
    }

}