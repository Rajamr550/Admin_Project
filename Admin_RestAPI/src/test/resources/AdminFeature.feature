Feature: Cucumber Test.

  Scenario Outline:  Add Admin record
    Given I Set POST admin service api endpoint
    When I sending post to be created with email <email>,name <name> ,password <password> ,phNumber <phNumber> 
    Then I receive valid Response 
    
     Examples:
    | email   | name   | password   | phNumber    |
    |"abc@232"| "ABC"  | "ac123"    | 98989890909 |
    
    
  Scenario Outline: Getting all  Admin record
    Given I Set Get admin service api endpoint
    When I sending get all method record to get id<id>, email <email>,name <name> ,password <password> ,phNumber <phNumber>
    Then I recieve valid Response for Getting all Records
    
      Examples:

    |id | email   | name   | password   | phNumber    |
    | 1 |"abc@232"| "ABC"  | "ac123"    | 98989890909 |
    | 2 |"xyz@232"| "XYZ"  | "xy123"    | 98989877777 |
    
    
  Scenario: Delete a  Admin record
    Given I Set Delete admin service api endpoint
    When I sending delete method to be deleted with id 1
    Then I recieve valid Response true/false
    
      

   
   
    
