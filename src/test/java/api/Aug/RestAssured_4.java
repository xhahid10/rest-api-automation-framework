package api.Aug;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestAssured_4 {
	
	public static void main(String[] args) {
		
		JSONObject inner1= new JSONObject();
		inner1.put("houseNo", "219");
		inner1.put("sector", "301");
		inner1.put("landmark", "Sector 231 market ");
		inner1.put("type", "permanent address");
		
		
		JSONObject inner2= new JSONObject();
		inner2.put("houseNo", "219");
		inner2.put("sector", "301");
		inner2.put("landmark", "Sector 231 market ");
		inner2.put("type", "secondary address");
		
		JSONArray array= new JSONArray();
		array.put(0,inner1);
		array.put(1,inner2);
		
		
		
		JSONObject outer= new JSONObject();
		outer.put("firstname", "Aman");
		outer.put("lastname", "Singh");
		outer.put("id", "aman22");
		outer.put("designation", "QA lead");
		outer.put("address", array);
				
		
		Response res=	
		given()
		.contentType(ContentType.JSON)
		.body(outer.toString())
		.when()
		.post("http://localhost:3000/APIStudents");
		
		
	System.out.println("Status code is ");
	System.out.println(res.statusCode());
	System.out.println(res.asString());
		
		
	}

}
