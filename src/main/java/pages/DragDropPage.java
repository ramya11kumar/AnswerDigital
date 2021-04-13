package pages;


import base.basePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

public class DragDropPage extends basePage
{
    @FindBy(id="draggable") public WebElement DraggableElement;
    @FindBy(id="droppable") public WebElement DroppableElement;

    public void init()
    {
        PageFactory.initElements(driver,this);
    }
    public void opendrag_url()
    {
    	 driver.navigate().to(prop.getProperty("drag_url"));        
    }
    public void draganddrop()
    {
    Actions act= new Actions(driver);
    act.dragAndDrop(DraggableElement, DroppableElement).perform();
    try {Thread.sleep(3000);}catch(Exception e) {}
    
    testlog=report.createTest("Drag And Drop");
	testlog.log(Status.INFO, "Drag and drop Element done");
	takescreenshot("draganddrop.png");
    }

}
