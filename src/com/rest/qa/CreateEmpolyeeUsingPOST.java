package com.rest.qa;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateEmpolyeeUsingPOST {

	@Test
	public void verifyUserCreation() {

		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification httpRequest = RestAssured.given();

		// How to create JSON object using JSON object for POST method
		// JSONObject is a class that represents a Simple JSON.
		// We can add Key - Value pairs using the put method

		JSONObject requestParm = new JSONObject();
		requestParm.put("FirstName", "Rishab");
		requestParm.put("LastName", "singh");
		requestParm.put("UserName", "rishab123");
		requestParm.put("Password", "Test12345");
		requestParm.put("Email", "Test1234@gmail.com");

		/*
		 * JSONObject is a class that is present in org.json.simple package. This class
		 * is a programmatic representation of a JSON string. Take a look at the Request
		 * JSON above for our test web service, you will notice that there are multiple
		 * nodes in the JSON. Each node can be added using the JSONObject.put(String,
		 * String) method. Once you have added all the nodes you can get the String
		 * representation of JSONObject by calling JSONObject.toJSONString() method.
		 */
		
		// add a header stating that the request body is of the form JSON
		httpRequest.header("Content-Type" , "application/json");
		
		// Add the Json to the body of the request
		httpRequest.body(requestParm.toString());
		
		// post the request using post method
		Response response = httpRequest.request(Method.GET , "/register");
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);
		
	}

}
