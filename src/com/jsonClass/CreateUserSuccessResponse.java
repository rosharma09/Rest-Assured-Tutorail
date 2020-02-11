package com.jsonClass;

import java.io.Serializable;

import org.json.simple.JSONObject;

public class CreateUserSuccessResponse {

	// Variable where value of status node
	// will be copied
	// Note: The name should be exactly as the node name is
	// present in the Json

	public String status;

	// Variable where value of data node
	// will be copied
	// Note: The name should be exactly as the node name is
	// present in the Json

	public JSONObject data = new JSONObject();

}
