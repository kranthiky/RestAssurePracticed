package restAssuredPackage;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

public class GET_request2_staticImport_RestAssured {

	@Test
	public void GET_method() {
		
		//long var=2;
		
		baseURI = "https://reqres.in/api";
		
		given().
		with().
		//	pathParam("user", "2").
		queryParam("page", "2").
		when().
			get("/users").
			//get("/users?page={user}").
		then().
			statusCode(200).
			time(lessThan(2L), TimeUnit.SECONDS).
			body("data[1].first_name", equalTo("Lindsay")).
			body("data.first_name", hasItems("Michael","Rachel")).			
			log().all();
	}
}
