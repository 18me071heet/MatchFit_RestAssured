package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;

public class Report_Post extends BaseTest {

	
	@Test
	public void reportPost() {
		
		String requestBody = "{\n" +
	            "  \"option\": \"other\",\n" +
	            "  \"reason\": \"Post is not contain good content\"\n" +
	            "}";

	    Response response = requestSpec
	            .header("ROLE", "PARENT")
	            .header("Content-Type", "application/json")
	            .body(requestBody)
	            .when()
	            .post("/user/posts/314/report/")
	            .then()
	            .statusCode(200)
	            .body("success", equalTo(true))
	            .log().all()
	            .extract()
	            .response();
}
}
