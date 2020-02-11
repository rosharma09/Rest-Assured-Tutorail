package com.dummy.authentication;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class UserAuthenticationAPITest {

	@Test(priority = 1, groups = "UserLoginTest")
	public void userLoginFailTest() {

		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.get();

		ResponseBody responseBody = response.getBody();

		String responseBodyAsString = responseBody.asString();
		System.out.println("Below is the response body");
		System.out.println(responseBodyAsString);

		int statCode = response.getStatusCode();

		System.out.println("The status for the request : " + statCode);

		// deserialize the response body for failed authentication

		UserAuthenticationFail UFail = responseBody.as(UserAuthenticationFail.class);

		Assert.assertEquals(UFail.StatusID, "FAULT_USER_INVALID_USER_PASSWORD");
		Assert.assertEquals(UFail.Status, "Invalid or expired Authentication key provided");

		System.out.println("No Authentication provided Or Invalid Username/Password entered");

	}

	@Test(priority = 2, groups = "UserLoginTest")
	public void userLoginPassTest() {

		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";

		RequestSpecification httpRequest1 = RestAssured.given().auth().basic("ToolsQA", "TestPassword");

		Response response1 = httpRequest1.get();
		ResponseBody responseBody1 = response1.getBody();
		String responseBodyAsString1 = responseBody1.asString();
		System.out.println("The response is as below");
		System.out.println(responseBodyAsString1);

		JSONObject jObj = new JSONObject();
		System.out.println(responseBody1.jsonPath().get("FaultId").toString());

	}
}
