Feature: This feature is used to login and validate the response from the api

Scenario: Login using the service and validate the response for valid and invalid credentials
	When I create the toolsQa login service response with valid credentials
	|ToolsQA|TestPassword|
	Then I verify the response that user is able to login successfully
	When I create the toolsQa login service response with valid credentials
	|DummyUserName|DummyPassword|
	Then I verify the login failed error details in response