package org.testing.testSteps;

import java.util.Properties;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class HTTPMethods {
	
	Properties pr;
	public HTTPMethods(Properties pr) {
		
		this.pr=pr;
		
		
		
	}
	
	
	public Response postmethod(String uriKeyName , String requestBody )
	
	{
		String uriValue =pr.getProperty(uriKeyName);
		
		Response res=
		
		given()
		.contentType(ContentType.JSON)
		.body(requestBody)
		.when()
		.post(uriValue);
		
		System.out.println("Status code is");
		System.out.println(res.statusCode());
		
		return res;
		
	}
	
public Response putmethod(String uriKeyName ,String endPoint, String requestBody )
	
	{
		String uriValue =pr.getProperty(uriKeyName)+"/"+endPoint;
		
		Response res=
		
		given()
		.contentType(ContentType.JSON)
		.body(requestBody)
		.when()
		.put(uriValue);
		
		System.out.println("Status code is");
		System.out.println(res.statusCode());
		
		System.out.println(res.asString());
		return res;
		
	}
	public Response getAllMethod(String uriKeyName) {
		
		String uriValue =pr.getProperty(uriKeyName);
		Response res=
		given()
		.contentType(ContentType.JSON)
		.when()
		.get(uriValue);
		
		System.out.println("Status code is ");
		System.out.println(res.statusCode());
		
		System.out.println("Response code is ");
		System.out.println(res.statusCode());
		
		System.out.println(res.asString());
		return res;
		
	}

	public Response getParticularMethod(String uriKeyName ,String endPoint) {
		
		String uriValue =pr.getProperty(uriKeyName)+"/"+endPoint;
		Response res=
		given()
		.contentType(ContentType.JSON)
		.when()
		.get(uriValue);
		
		System.out.println("Status code is ");
		System.out.println(res.statusCode());
		
		System.out.println("Response code is ");
		System.out.println(res.statusCode());
		
		System.out.println(res.asString());
		return res;

		
	}

	public Response deleteMethod(String uriKeyName ,String endPoint) {
		
		String uriValue =pr.getProperty(uriKeyName)+"/"+endPoint;
		Response res=
		given()
		.contentType(ContentType.JSON)
		.when()
		.delete(uriValue);
		
		System.out.println("Status code is ");
		System.out.println(res.statusCode());
		
		System.out.println("Response code is ");
		System.out.println(res.statusCode());
		
		System.out.println(res.asString());
		return res;

		
	}
}
