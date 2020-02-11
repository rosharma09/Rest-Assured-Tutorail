package com.rest.qa;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class VerifyResponseStatus {
	
	// This is a sample program to verify the response status
	
	@Test(priority = 1)
	public void verifyValidaResponseStatus() {
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city/";
		RequestSpecification httpRequest1 = RestAssured.given();
		Response response1 = httpRequest1.get("/bangalore");
		
		System.out.println("Weather info :"+response1);
		
		int statCode1 = response1.getStatusCode();
		System.out.println("Response status code : " +statCode1);
		
		Assert.assertEquals(statCode1, 200 , "The response status is failed");
	}
	
	@Test(priority = 2)
	public void verifyInvalidResponseStatus() {
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city/";
		RequestSpecification httpRequest2 = RestAssured.given();
		Response response2 = httpRequest2.get("/23458723465");
		
		System.out.println("Weather info :"+response2);
		
		int statCode2 = response2.getStatusCode();
		System.out.println("Response status code : " +statCode2);
		
		Assert.assertEquals(statCode2, 400 , "The response status is failed");
	}

}
