package com.userapp.cucumber.serenity;

import java.util.HashMap;

import com.userapp.model.EmployeeModel;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class UserSerenitySteps {

	@Step
	public ValidatableResponse saveUser(EmployeeModel employee) {

		ValidatableResponse response = SerenityRest.rest().given().contentType(ContentType.JSON).when().body(employee)
				.post("/api/v1/create").then().statusCode(200);

		return response;
	}

	@Step
	public ValidatableResponse getEmployeeInfoByID(int id) {
	//	String p = "findAll{data.employee_name='" + name + "'}.get(0)";
	//	return SerenityRest.rest().given().when().get("/employees").then().log().all().statusCode(200).extract().path(p);
		return SerenityRest.given().when().get("/api/v1/employee/"+id).then().statusCode(200);
	}

}
