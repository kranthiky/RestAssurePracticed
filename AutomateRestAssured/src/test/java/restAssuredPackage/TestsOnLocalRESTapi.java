package restAssuredPackage;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
public class TestsOnLocalRESTapi {

	//@Test
	public void GET_test() {
		baseURI="http://localhost:3000";
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			pathParam("id", 2).
		when().	
			get("/employees/{id}").
		then().
			statusCode(200).
			log().all();
	}
//	@Test
	public void POST_test() {
		baseURI="http://localhost:3000";
		
		JSONObject request = new JSONObject();
		request.put("Name", "Simba");
		request.put("DepartmentId", "701");
		request.put("email", "simba@dog.com");
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().	
			post("/employees").
		then().
			statusCode(201).
			log().all();
	}


//@Test
public void PATCH_test() {
	baseURI="http://localhost:3000";
	
	JSONObject request = new JSONObject();
	request.put("Name", "Simba KY");
	request.put("DepartmentId", 701);
	
	given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		pathParam("id", 3).
	when().	
		patch("/employees/{id}").
	then().
		statusCode(200).
		log().all();
}
//@Test
public void DELETE_test() {
	baseURI="http://localhost:3000";
	
	given().
//		header("Content-Type","application/json").
//		contentType(ContentType.JSON).
//		accept(ContentType.JSON).
//		pathParam("id", 4).
	when().	
		delete("/employees/4").
	then().
		statusCode(200).
		log().all();
}
}
