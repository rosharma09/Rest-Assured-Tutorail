package com.rest.qa;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class VerifyResponseHeader {

	/*
	 * Every response that is received from a server contains zero or more headers.
	 * Headers are the part of Response that is sent by the server. Each header
	 * entry is basically a Key-Value pair. Headers are used to send across extra
	 * information by the server. This extra information is also referred to as
	 * Metadata of the Response.
	 */

	@Test
	public void verifyResponseHeader() {

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employees";
		RequestSpecification getEmployeesResquest = RestAssured.given();
		Response getEmployeesResponse = getEmployeesResquest.get();
		String responseBody = getEmployeesResponse.getBody().asString();
		System.out.println("The reponse for the request : " + responseBody);

		// Note : we can use header(HeaderName) or GetHeader(HeaderName)

		// Reader header of a give name. In this line we will get
		// Header named Content-Type
		String ContentType = getEmployeesResponse.header("Content-Type");
		System.out.println("Content Type :" + ContentType);

		Assert.assertEquals(ContentType /* Actual Value */, "application/json;charset=utf-8"/* Actual Value */ ,
				"Content Type is as expected");

		// Reader header of a give name. In this line we will get
		// Header named Server

		String Server = getEmployeesResponse.header("Server");
		System.out.println("Server :" + Server);
		
		Assert.assertEquals(Server /* Actual Value */, "nginx/1.16.0"/* Actual Value */ ,
				"Server is as expected");

		// Reader header of a give name. In this line we will get
		// Header named Content-Encoding

		String ContentEncoding = getEmployeesResponse.header("Content-Encoding");
		System.out.println("Content encoding :" + ContentEncoding);
		
		Assert.assertEquals(ContentEncoding /* Actual Value */, "gzip"/* Actual Value */ ,
				"Content encoding is as expected");

		// To get all the headers in the response

		// Get all the headers. Return value is of type Headers.
		// Headers class implements Iterable interface, hence we
		// can apply an advance for loop to go through all Headers
		// as shown in the code below

		Headers allHeader = getEmployeesResponse.headers();

		for (Header header : allHeader) {
			System.out.println("Key : " + header.getName() + " Value :" + header.getValue());
		}

	}

}
