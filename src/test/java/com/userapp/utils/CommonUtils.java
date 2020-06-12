package com.userapp.utils;

import java.util.Random;

import com.userapp.model.UserModel;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CommonUtils {
	@Step
	public ValidatableResponse getCountriesDetailResponse(String county, String baseUri) {
		return SerenityRest.given().pathParam("country", county).log().all().when().get(baseUri).then();
	}

	@Step
	public Response getCountriesDetails(String county, String baseUri) {
		return SerenityRest.given().pathParam("country", county).log().all().when().get(baseUri);
	}
	
	@Step
	public Response getUserCreatedResponse(UserModel user, String baseUri) {
		return SerenityRest.given().baseUri(baseUri).body(user).when().post();
	}
	
	@Step
	public Response createUserLoginResponse(String userName, String password, String baseUri) {
		return SerenityRest.given().auth().basic(userName, password)
				.when().log().all().get(baseUri);
	}
	
	public String randomStringGenerator(int size, String randomType) {
		String randomStringChars = null;
		if (randomType.equalsIgnoreCase("text"))
			randomStringChars = "abcdefghijklmnopqrstuvwxyz";
		else if (randomType.equalsIgnoreCase("number"))
			randomStringChars = "1234567890";
		else
			randomStringChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder builder = new StringBuilder();
		Random rnd = new Random();
		while (builder.length() < size) { // length of the random string.
			int index = (int) (rnd.nextFloat() * randomStringChars.length());
			builder.append(randomStringChars.charAt(index));
		}
		return builder.toString();
	}
}
