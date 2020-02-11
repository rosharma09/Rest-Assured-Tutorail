package com.jsonClass;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class DeserializeCreateEmployeeResponse {

	@SuppressWarnings("unchecked")
	@Test
	public static void verifyCreateUserAPI() {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/create";
		RequestSpecification httpRequest = RestAssured.given();

		httpRequest.header("Content-Type", "application/json");

		JSONObject requestParameter = new JSONObject();

		requestParameter.put("name", "Rohan");
		requestParameter.put("salary", "300");
		requestParameter.put("age", "24");

		httpRequest.body(requestParameter.toJSONString());

		Response response = httpRequest.post();

		ResponseBody responseBody = response.getBody();
		System.out.println(responseBody.asString());

		// Deserialize the Response body into RegistrationSuccessResponse

		CreateUserSuccessResponse successResponseObj = responseBody.as(CreateUserSuccessResponse.class);

		Assert.assertEquals(successResponseObj.status, "success");

		Assert.assertEquals(successResponseObj.data.get("name"), "Rohan");
		Assert.assertEquals(successResponseObj.data.get("salary"), "300");
		Assert.assertEquals(successResponseObj.data.get("age"), "24");

	}

}
