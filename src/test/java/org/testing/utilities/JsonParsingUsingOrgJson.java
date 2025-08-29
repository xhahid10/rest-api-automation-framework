package org.testing.utilities;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.response.Response;

public class JsonParsingUsingOrgJson {
	
	public static String responseParsing(Response res ,String KeyName) {
		
		
		JSONArray array =new JSONArray(res.asString());		
		JSONObject ob =array.getJSONObject(0);
		
		return ob.getString(KeyName);
         
		
		
	}

}
