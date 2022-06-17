package restAssuredPackage;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class POSTwithOnlyJSONobject {
	@Test
	public void postWithMap() {
		
		baseURI="https://reqres.in";
			
		JSONObject request = new JSONObject();
		request.put("first_name", "James");
		request.put("last_name", "Bond");
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/api/users").
		then().
			statusCode(201).
			log().all();
	}
}
