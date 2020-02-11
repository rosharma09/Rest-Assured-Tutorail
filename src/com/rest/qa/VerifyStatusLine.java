package com.rest.qa;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class VerifyStatusLine {

	@Test
	public void verifyStatusLine() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";

		RequestSpecification httpRequest = RestAssured.given();
		Response serverResponse = httpRequest.request(Method.GET, "/Hyderabad");
		String responseStatusLine = serverResponse.getStatusLine().toString();
		System.out.println("The server response status line : " + responseStatusLine);

		Assert.assertEquals(responseStatusLine /* Actual Response line */,
				"HTTP/1.1 400 Bad Request" /* Expected response status */ , "Incorrect response received");
	}

}
