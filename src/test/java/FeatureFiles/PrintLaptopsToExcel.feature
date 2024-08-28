Feature: Take all the laptops and print them to an excel file

  Background:
    Given Navigate to Blaze website

  Scenario: Write all the laptops to an excel file
    When Click on the element in LocatorPage
      | laptops |
    Then Get list of laptops and write to the excel file
