Feature: Cucumber Selenium Update Test.
 Scenario: Update a Admin record
  Given open browser in chrome
  When Enter "http://localhost:4200/admin_form" url
  And Click on Edit button for particular id
  And Enter Updated Admin Details like name "Prashan" passowrd "Pras@123" email "Pras123@gmail.com" mobile "7857434325"
  And Click on Update button 
  Then Updated Admin details get registered  


   
   

