Feature: Cucumber Selenium Add Admin Test.
 Scenario: Add a Admin record
  Given open browser
  When Enter url "http://localhost:4200/admin_form"
  And Enter Admin Details like name "Zensar" passowrd "Zensar@123" email "Zensar123@gmail.com" 
  And Click on Submit
  Then Admin details get registered  


   
   

