#Enter all details into the student registration form and submit
#Click on the second button under Alerts and accept the alert
#Hover me to see button and field
#Drag and drop
#Close small modal button
#Select date one month from today's date

@toolsQA
Feature: DemoQATools Automation Test

@register
Scenario Outline: Student registration form submission
    Given user is on student registration form page
    When user enters <firstname> and <lastname> and <email> and <gender> and <mobile> and <dob> and <subjects> and <hobbies> and <address> and <state> and <city>
    And select Picture
    And clicks on Submit button
    Then user should see the <popupMessage>
   
    Examples:
    | firstname | lastname | email | gender | mobile | dob | subjects | hobbies | address | state | city | popupMessage |
    | tom | harris | tomharris@gmail.com | Male | 9999999999 | 09 jun 1999 | science | Reading | highash | Haryana | Karnal | Message |
    
@alert
Scenario: Accept the alert
    Given user is on alerts page
    Then user clicks on second alert button and accepts the alert

@hoverbutton
Scenario: Hover to see button and field
    Given user is on tool tips page to hover
    Then user hovers over button
    Then user also hovers over textfield

@draganddrop
Scenario: Drag and Drop Me Element onto Drophere Element
    Given user is on drag and drop page
    When user drags the elmement and drops on another element 
    Then user drags and drops the dragme element onto draghere element

@smallmodal
 Scenario: Close small modal button
     Given user is on modal dialogs page
     When user selects small modal button
     Then user closes the modal

@datepicker
 Scenario: Select date one month from today date
     Given user is on the date picker page
     Then user selects a date one month from today date
          
     