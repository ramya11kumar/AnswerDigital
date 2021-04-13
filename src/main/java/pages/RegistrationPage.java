package pages;

import base.basePage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

public class RegistrationPage extends basePage {

    @FindBy(id="firstName") public WebElement FirstName;
    @FindBy(id="lastName") public WebElement LastName;
    @FindBy(id="userEmail") public WebElement Email;
    @FindBy(id="userNumber") public WebElement MobileNo;
    @FindBy(id="dateOfBirthInput") public WebElement DateOfBirth;    
    @FindBy(id="subjectsInput") public WebElement Subjects;
    @FindBy(id="uploadPicture") public WebElement imgphoto;
    @FindBy(id="currentAddress") public WebElement Address;
    @FindBy(id="submit") public WebElement SubmitBtn;
    @FindBy(xpath="//div[@role='dialog']/div/div/div/div") public WebElement PopupMessage;
    @FindBy(id="closeLargeModal") public WebElement CloseBtn;
    @FindBy(xpath="//div[@class=' css-yk16xz-control']") public WebElement stateTxtBox;
    @FindBy(xpath="//div[@class='css-1g6gooi']") public WebElement cityTxtBox;

    
    public void init()
    {
       PageFactory.initElements(driver,this);
    }
    public void open_registrationform()
    {
    	 driver.get(prop.getProperty("reg_url"));
         Assert.assertEquals(driver.getTitle(), "ToolsQA");   
    }
    public void add_newuser(String firstname, String lastname, String email, String gender, String mobile, String dob, String subjects, String hobbies,String address, String state, String city) throws InterruptedException
    {
    	FirstName.sendKeys(firstname);
    	LastName.sendKeys(lastname);
    	Email.sendKeys(email);
    	if(gender.matches("Male"))
    	{
    		driver.findElement(By.xpath("//label[contains(.,'Male')]")).click();
    	}
    	else if(gender.matches("Female"))
    	{
    		driver.findElement(By.xpath("//label[contains(.,'Female')]")).click();
    	}
    	else
    	{
    		driver.findElement(By.xpath("//label[contains(.,'Other')]")).click();        	
    	}
    	MobileNo.sendKeys(mobile);
    	DateOfBirth.sendKeys(dob);
    	DateOfBirth.sendKeys(Keys.ENTER);
    	Subjects.sendKeys(subjects);
    	Subjects.sendKeys(Keys.ENTER);
    	
    	if(hobbies.matches("Sports"))
    	{
    		driver.findElement(By.xpath("//label[contains(.,'Sports')]")).click();
    	}
    	else if(hobbies.matches("Reading"))
    	{
    		driver.findElement(By.xpath("//label[contains(.,'Reading')]")).click();
    	}
    	else
    	{
    		driver.findElement(By.xpath("//label[contains(.,'Music')]")).click();
    	}
    	Address.sendKeys(address);
    	Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView();", stateTxtBox);
        stateTxtBox.click();
        driver.findElement(By.xpath("//div[text()='Haryana']")).click();
        driver.findElement(By.id("city")).click();
        driver.findElement(By.xpath("//div[text()='Karnal']")).click();
    	
    }
    public void picture()
    {   
	    imgphoto.sendKeys(prop.getProperty("studentPhoto"));	   
    }
    public void submit()
    {
        SubmitBtn.click();
    }

    public void popupMessage()
    {
       String str= PopupMessage.getText();
       if(str.contains("Thanks for submitting the form"))
       {
    	   testlog=report.createTest("Create new user");
    	   testlog.log(Status.PASS, "New user created successfully");
    	   takescreenshot("newuser.png");
       }
       else
       {
    	   testlog=report.createTest("Create new user");
    	   testlog.log(Status.FAIL, "New user Not Created");
    	   takescreenshot("newuser.png");
       }
    }
    public void closeBtn()
    {
        CloseBtn.click();
    }
}
