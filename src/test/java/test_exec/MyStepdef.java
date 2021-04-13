package test_exec;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AlertsPage;
import pages.DatePickerPage;
import pages.DragDropPage;
import pages.HoverPage;
import pages.ModalDialogsPage;
import pages.RegistrationPage;

public class MyStepdef {
    RegistrationPage registrationPage;
    AlertsPage alertsPage;
    DatePickerPage datePickerPage;
    DragDropPage dragDropPage;
    HoverPage hoverPage;
    ModalDialogsPage modalDialogsPage;
   

 //************************** Student Registration Scenario steps
    
    @Given("^user is on student registration form page$")
    public void user_is_on_student_registration_form_page() throws Throwable
    {
    	registrationPage = new RegistrationPage();
    	registrationPage.init();
    	registrationPage.open_registrationform();
    }
    
    @When("^user enters (.+) and (.+) and (.+) and (.+) and (.+) and (.+) and (.+) and (.+) and (.+) and (.+) and (.+)$")
    public void user_enters_and_and_and_and_and_and_and_and_and_and(String firstname, String lastname, String email, String gender, String mobile, String dob, String subjects, String hobbies, String address, String state, String city) throws Throwable {
   
        registrationPage.add_newuser(firstname, lastname, email, gender, mobile, dob, subjects, hobbies, address, state, city);
    }
    
    @And("^select Picture$")
    public void select_Picture() throws Throwable 
    {
    	registrationPage.picture();    
    }
    @And("^clicks on Submit button$")
    public void clicks_on_submit_button() throws Throwable
    {
    	registrationPage.submit();
    }
    @Then("^user should see the (.+)$")
    public void user_should_see_the(String popupmessage) throws Throwable
    {
    	 registrationPage.popupMessage();
    	 registrationPage.closeBtn();
    }   
    
//*****************************Handle alert scenario steps
    
   
    @Given("^user is on alerts page$")
    public void user_is_on_alerts_page() 
    {
    	alertsPage = new AlertsPage();
    	alertsPage.openalert_url();
    	alertsPage.init();
    }
    @Then("^user clicks on second alert button and accepts the alert$")
    public void user_clicks_on_second_alert_button_and_accepts_the_alert()
    {        
        alertsPage.secondAlertBtn();
    }
    
 //********************* Hover to see button scenario steps  

    @Given("^user is on tool tips page to hover$")
    public void user_is_on_tool_tips_page_to_hover() 
    {
    	 hoverPage = new HoverPage();
    	 hoverPage.openhover_url();
    	 hoverPage.init();
    }

    @Then("^user hovers over button$")
    public void user_hovers_over_button() 
    {       
        hoverPage.hoverBtn();
    }
    @Then("^user also hovers over textfield$")
    public void user_also_hovers_over_textfield()
    {
        hoverPage.hoverTextField();
    }
    
//******************* Drag and Drop scenario steps

    @Given("^user is on drag and drop page$")
    public void user_is_on_drag_and_drop_page()
    {
    	 dragDropPage = new DragDropPage();
    	 dragDropPage.opendrag_url();
    	 dragDropPage.init();
    }

    @When("^user drags the elmement and drops on another element$")
    public void user_drags_the_elmement_and_drops_on_another_element() throws Throwable 
    {
    	 dragDropPage.draganddrop();   
    }

    @Then("^user drags and drops the dragme element onto draghere element$")
    public void user_drags_and_drops_the_dragme_element_onto_draghere_element() throws Throwable {
       
    }

///********************* small model dialog scenario steps
    @Given("^user is on modal dialogs page$")
    public void user_is_on_modal_dialogs_page() throws Throwable 
    {
    	modalDialogsPage = new ModalDialogsPage();
    	modalDialogsPage.openmodel_url();
    	modalDialogsPage.init();
    
    }
    @When("^user selects small modal button$")
    public void user_selects_small_modal_button() throws Throwable
    {
    	 modalDialogsPage.clickSmallModalBtn();
    
    	 
    }
    @Then("^user closes the modal$")
    public void user_closes_the_modal() throws Throwable 
    {
    	 modalDialogsPage.ClickCloseSmallModBtn();
    }

///***************** select Date scenario steps
    @Given("^user is on the date picker page$")
    public void user_is_on_the_date_picker_page() throws Throwable 
    {
    	 datePickerPage = new DatePickerPage();
    	 datePickerPage.opendate_url();
    	 datePickerPage.init();
    }
    @Then("^user selects a date one month from today date$")
    public void user_selects_a_date_one_month_from_today_date() throws Throwable 
    {
        datePickerPage.selectDate();
    }
    
    
//********************************************************
   

  


}