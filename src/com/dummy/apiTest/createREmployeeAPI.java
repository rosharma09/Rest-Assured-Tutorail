package com.dummy.apiTest;

import javax.xml.crypto.dsig.XMLObject;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class createREmployeeAPI {

	@Test
	public void createUserAPITest() {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/create";

		RequestSpecification request = RestAssured.given();

		JSONObject jsonObj = new JSONObject();
		jsonObj.put("name", "sampleUser");
		jsonObj.put("salary", "8,50,000");
		jsonObj.put("age", "34");

		request.header("Content-Type", "application/json");

		request.body(jsonObj.toJSONString());

		Response responseObj = request.request(Method.POST);
		String responseBody = responseObj.getBody().asString();

		System.out.println("The response received from the server : ");
		System.out.println(responseBody);

		int statusCode = responseObj.getStatusCode();
		Assert.assertEquals(statusCode, 200);

		JsonPath jsonPathEvaluator = responseObj.jsonPath();
		String status = jsonPathEvaluator.get("status").toString().toLowerCase();

		Assert.assertEquals(status, "success");

	}

}
