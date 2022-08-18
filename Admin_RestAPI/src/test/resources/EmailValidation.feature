Feature: Cucumber Email Test.

  Scenario: Getting Admin record By Id and Validating Email
    Given I Set Get admin service api endpoint with ids
    When I send get by ids method to get with id 1
    Then I recieve valid Response for Get by ids and check Email
