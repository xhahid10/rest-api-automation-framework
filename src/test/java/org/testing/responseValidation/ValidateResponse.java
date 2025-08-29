package org.testing.responseValidation;

import org.testing.assertions.Assertions;
import org.testing.utilities.JsonParsingUsingOrgJson;

import io.restassured.response.Response;

public class ValidateResponse {

	public static Boolean statusCodeValidate(int expectedStatusCode , Response res)
	{
		
		int actualStatusCode =res.statusCode();
		Boolean result= Assertions.assert1(actualStatusCode, expectedStatusCode);
		return result;
	
	}
	
	
	public static Boolean DataValidate(String expectedData , Response res) {
		
		String actualData =JsonParsingUsingOrgJson.responseParsing(res,"id");
		Boolean result= Assertions.assert2(actualData, expectedData);
		return result;
		
		
	}
	
	
}
