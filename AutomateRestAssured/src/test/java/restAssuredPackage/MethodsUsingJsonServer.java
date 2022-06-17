package restAssuredPackage;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class MethodsUsingJsonServer {

	@Test
	public void GETmethod() {
		
		baseURI ="http://localhost:3000";
		
		given().
		when().
			get("/Users/7").
		then().
			statusCode(200).
			log().all();
	}
	@Test
	public void POSTmethod() {
		baseURI ="http://localhost:3000";
		
		JSONObject request = new JSONObject();
		request.put("firstName", "Roja");
		request.put("lastName", "K");
		request.put("subjectId", 7);
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/Users").
		then().
			statusCode(201).
			log().all();
	}
}
