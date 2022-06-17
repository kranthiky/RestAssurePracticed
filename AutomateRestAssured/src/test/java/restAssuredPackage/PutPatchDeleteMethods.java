package restAssuredPackage;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class PutPatchDeleteMethods {

	@Test
	public void methodPUT() { 	//assumed you are sending the complete entity, and that complete entity replaces any existing entity at that URI.
		baseURI = "https://reqres.in";
	
		JSONObject request = new JSONObject();
		request.put("email", "banet.weaver@reqres.in");
		request.put("first_name", "James");
		request.put("last_name", "Bond");
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/api/users/2").
		then().
			statusCode(200).
			log().all();
	}
	@Test
	public void methodPATCH() { //PATCH only updates the fields that were supplied, leaving the others alone
		baseURI ="https://reqres.in";
		
		JSONObject request = new JSONObject();
		request.put("email", "kranthik.yadala@outlook.com");
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/api/users/2").
		then().
			statusCode(200).
			log().all();
	}
	@Test
	public void methodDELETE() {
		baseURI ="https://reqres.in";
		
		given().
		when().
			delete("/api/users/2").
		then().
			statusCode(204).
			log().all();
	}
}
