package com.qa.putRequest;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PUTrequestSample {

	// what is a PUT request :
	// The HTTP PUT request method creates a new resource or substitutes a
	// representation of the target resource with the request payload.

	/*
	 * PUT request : 1. If the resource already exits then PUT replaces the 2. If
	 * the resouce is not present then PUT request creates a new resource in the
	 * location
	 */

	// Responses from the PUT request are not cacheable

	// PUT Vs POST
	// PUT is impodent whereas POST is not : means if we send the PUT request
	// multiple times it will result in the same thing, whereas in case of POST
	// calls it will result in creation of multiple resources on the server

	// create a empId variable which we intend to update using PUT request

	public static int empId = 15410;

	@Test
	public static void testPUTrequest() {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RequestSpecification httpRequest = RestAssured.given();

		// JSONObject is a class that represents a Simple JSON.
		// We can add Key - Value pairs using the put method

		JSONObject jsonRequestParm = new JSONObject();
		jsonRequestParm.put("name", "Zion");
		jsonRequestParm.put("age", "23");
		jsonRequestParm.put("salary", "12000");

		httpRequest.header("Content-Type", "application/json");

		// add the json body to the request :

		httpRequest.body(jsonRequestParm.toJSONString());

		// The actual request being passed equalizes to
		// http://dummy.restapiexample.com/api/v1/update/15410
		// Here, we capture the response for PUT request by passing the associated empID
		// in the baseURI

		Response httpResponse = httpRequest.get("/update/" + empId);
		
		int statCode = httpResponse.getStatusCode();
		System.out.println("Response code :" +statCode);
		
		String responseString = httpResponse.getBody().asString();
		System.out.println("Response from the server :" +responseString);
		assertEquals(statCode, "200");
		
		
	}

}
