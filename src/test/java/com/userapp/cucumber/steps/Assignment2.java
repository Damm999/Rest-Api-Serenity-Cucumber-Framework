package com.userapp.cucumber.steps;

import static org.junit.Assert.assertTrue;

import com.userapp.utils.CommonUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;

public class Assignment2 {
	@Steps
	CommonUtils commonSteps;

	String baseUri = "http://restcountries.eu/rest/v1/name/{country}";
	Response response = null;

	@Given("I get the response and store the details obtained for {string}")
	public void i_get_the_response_from_the_api_and_store_the_details_obtained_for(String country) {
		response = commonSteps.getCountriesDetails(country, baseUri);
		response.then().log().all();
	}
	
	@Then("I verify that the capital is {string} in the response")
	public void i_verify_that_the_capital_is_in_the_response(String string) {
		assertTrue(response.then().extract().jsonPath().getList("capital").get(0).equals(string));
	}
}
