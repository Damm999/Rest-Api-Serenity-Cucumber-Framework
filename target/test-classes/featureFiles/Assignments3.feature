Feature: This feature is used to register a user using api and validate the response

Scenario: Create a user and validate the obtained response
	Given I generate a random user to register into the application
	Then I register the created user using service and validate the success code in the response
	And I register with the existing user and validate the error response