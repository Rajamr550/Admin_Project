 Feature: Selenium Test.
  
  @deleteById
  Scenario Outline: Testing Delete By Id using Selenium
    Given open the chrome browser
    When Enter the url "http://localhost:4200/admin_form"
    And Click on delete button of id 
    Then Deleting works fine


