Feature: Cucumber Test.

  Scenario Outline:  Add Admin record
    Given I Set POST admin service api endpoint
    And I sending post to be created with email <email>,name <name> ,password <password> ,phNumber <phNumber> 
    Then I receive valid Response 
    
     Examples:
    | email   | name   | password   | phNumber     |
    |"abc@232"| "ABC"  | "ac123"    | 989898909090 |
   
																		
  
