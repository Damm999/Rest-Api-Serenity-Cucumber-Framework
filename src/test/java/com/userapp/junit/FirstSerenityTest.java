package com.userapp.junit;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.userapp.cucumber.serenity.UserSerenitySteps;
import com.userapp.model.EmployeeModel;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

//@RunWith(SerenityRunner.class)
public class FirstSerenityTest {

	@Steps
	UserSerenitySteps userSteps;
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://dummy.restapiexample.com";
	}

	@Title("Verify Get operation for all users")
	@Test
	public void getAllUsers() {
		SerenityRest.given().when().get("/employees").then().log().all().statusCode(200);
	}

	@Test
	public void sampleFailTest() {
		SerenityRest.given().when().get("/employees").then().log().all().statusCode(404);
	}
	
	@Test
	public void checkEmployee() {
		String name = "Garrett Winters";
		Object value = userSteps.getEmployeeInfoByID(7);
		System.out.println("EMpoyee: "+value);
	}
	
	@Test
	public void createEmployee() {
		EmployeeModel emp = new EmployeeModel();
		
		emp.setName("Dummy");
		emp.setAge("23");
		emp.setSalary("32300");
		
		userSteps.saveUser(emp);
	}

	@Pending
	@Test
	public void samplePendingTest() {

	}

	@Ignore
	@Test
	public void sampleIgnoreTest() {
	}

	@Test
	public void sampleErrorIgnoredTest() {
		System.out.println("Wnat to show error: " + (5 / 0)); 
	}
}