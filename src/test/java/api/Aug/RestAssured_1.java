package api.Aug;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestAssured_1 {
	
	public static void main(String[] args) throws FileNotFoundException {
		
	File f=new File("../APIAugBatch/RequestBody.json"); //connection creation 
	FileReader fr= new FileReader(f);
	JSONTokener js= new JSONTokener(fr);	
	JSONObject j= new JSONObject(js);
	
	System.out.println(j.toString());
	
	Response res=
	
	given()
	.contentType(ContentType.JSON)
	.body(j.toString())
	.when()
	.post("http://localhost:3000/APIStudents");
	
	System.out.println("Status code is ");
	System.out.println(res.statusCode());
	System.out.println("Response data is ");
	System.out.println(res.asString());
			
	}
	

}
