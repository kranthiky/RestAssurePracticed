package restAssuredPackage;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;


import io.restassured.config.JsonConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.config.JsonPathConfig.NumberReturnType;

public class POSTwithMap {
	@Test
	public void postWithMap() {
		
		baseURI="https://reqres.in/api";
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("first_name", "Kranthi");
		map.put("last_name", "kumar");		
		
		JSONObject request = new JSONObject(map);
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
		
//		given().
//            config(config().jsonConfig(JsonConfig.jsonConfig().numberReturnType(NumberReturnType.BIG_DECIMAL))).
//        when().
//            get("/price").
//        then().
//            body("price", is(new BigDecimal(12.12)));
	}
}
