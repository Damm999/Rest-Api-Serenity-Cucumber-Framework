Feature: This feature is used to verify the response from the countries api

  Scenario: Get all the response from the api and verify the required countries are present or not
    Given I get the response from the api and store the details obtained for "INDIA"
    Then I verify that "Republic of India" is present in the response
    And I verify the error response if "xyz" is passed as a country code
