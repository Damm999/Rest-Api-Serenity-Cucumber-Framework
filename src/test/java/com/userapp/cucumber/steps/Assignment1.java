package com.userapp.cucumber.steps;

import static org.junit.Assert.assertTrue;

import com.userapp.utils.CommonUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class Assignment1 {
	@Steps
	CommonUtils commonSteps;
	
	String baseUri = "http://restcountries.eu/rest/v1/name/{country}";
	ValidatableResponse response = null;
	
	@Given("I get the response from the api and store the details obtained for {string}")
	public void i_get_the_response_from_the_api_and_store_the_details_obtained_for(String country) {
		response = commonSteps.getCountriesDetailResponse(country, baseUri);
		response.log().all();
	}

	@Then("I verify that {string} is present in the response")
	public void i_verify_that_is_present_in_the_response(String content) {
		response.contentType(ContentType.JSON).statusCode(200);
		assertTrue(response.extract().jsonPath().get().toString().contains(content));
	}

	@Then("I verify the error response if {string} is passed as a country code")
	public void i_verify_the_error_response_if_is_passed_as_a_country_code(String country) {
		response = commonSteps.getCountriesDetailResponse(country, baseUri);
		response.log().all();
		response.contentType(ContentType.JSON).statusCode(404);
		assertTrue(response.extract().jsonPath().get().toString().contains("Not Found"));
	}

}
