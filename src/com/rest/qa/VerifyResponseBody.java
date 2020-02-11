package com.rest.qa;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class VerifyResponseBody {

	@Test
	public void verfiyResponseBody() {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employees";
		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.get();
		// we can user body() or getBody() method to get the response body
//		response.getBody();
//		response.body();

		/*
		 * Using these methods we can get an Object of type
		 * io.restassured.response.ResponseBody. This class represents the Body of a
		 * received Response. Using this class you can get and validate complete or
		 * parts of the Response Body. In the below code we will simply read the
		 * complete Response Body by using Response.getBody() and will print it out on
		 * the console window.
		 */

		@SuppressWarnings("rawtypes")
		ResponseBody responseBody = response.getBody(); // this will return an object of type responseBody

		// print the response body on the console :

		System.out.println("The reponse body is as below : ");

		// ResponseBody interface also has a method called .asString(), as used in the
		// above code, which converts a ResponseBody into its String representation.
		System.out.println(responseBody.asString()); // convert the response body to string
		
		String ResponseBodyAsString = responseBody.asString().toLowerCase();
		Assert.assertEquals(ResponseBodyAsString.contains("tiger"), true , "Response Body contains Tiger");
		
		// Using JSON path to extarct nodes in the response 
		
		
	}

}
