Feature: Cucumber Selenium Test.
 Scenario: Add a Admin record
  Given open browser
  When Enter url "http://localhost:4200/admin_form"
  And Enter Admin Details like name "Dhoke" passowrd "Dhoke@123" email "Dhoke123@gmail.com" 
  And Click on Submit
  Then Admin details get registered  


   
   

