package com.rest.qa;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JSONPathEvaluator {
	
	@Test
	public void verifyJSONpath() {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employees";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get();
		
		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();
		
		// Then simply query the JsonPath object to get a String value of the node
		// specified by JsonPath: data (Note: You should not put $. in the Java code)
		
		String data = jsonPathEvaluator.get("data[(@.employee_name== \"Tiger Nixon\")]").toString();
		
		System.out.println(data);
	}

}
