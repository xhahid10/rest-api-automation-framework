package api.Aug;

import org.json.JSONObject;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestAssured_3 {
	
	
	public static void main(String[] args) {
		
		
		JSONObject inner= new JSONObject();
		inner.put("houseNo", "29");
		inner.put("sector", "30");
		inner.put("landmark", "Sector 23 market ");
		
		JSONObject outer= new JSONObject();
		outer.put("firstname", "vipin");
		outer.put("lastname", "Singh");
		outer.put("id", "vip22");
		outer.put("designation", "Team lead");
		outer.put("address", inner);
		
		
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
