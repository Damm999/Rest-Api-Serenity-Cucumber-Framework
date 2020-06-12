Feature: This feature is used to verify the response from the countries api to validate the capital

Scenario: Get all the response from the api and verify the capital is matching or not 
	Given I get the response and store the details obtained for "Norway"
	Then I verify that the capital is "Oslo" in the response