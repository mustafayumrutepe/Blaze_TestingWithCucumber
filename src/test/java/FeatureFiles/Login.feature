Feature: Login Functionality

  Background:
    Given Navigate to website
    When Enter username and password
    Then User should login successfully
        |username|
        |password|
        |login|

  Scenario: Create Country
    And Click on the element in LeftNav
