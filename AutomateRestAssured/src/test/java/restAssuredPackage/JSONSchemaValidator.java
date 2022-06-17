package restAssuredPackage;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
public class JSONSchemaValidator {

	@Test
	public void jsonSchemaValidation() {
		baseURI = "https://reqres.in";
		given().
			header("Content-Type","application/json").
			queryParam("page", "2").
		when().
			get("/api/users").
		then().
		statusCode(200).
		assertThat().body(matchesJsonSchemaInClasspath("users_schema.json"));
		
	}
}
