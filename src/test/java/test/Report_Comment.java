package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;

public class Report_Comment extends BaseTest {

	@Test
	public void reportComment() {
		
		 String requestBody = "{\n" +
		            "  \"option\": \"other\",\n" +
		            "  \"reason\": \"Not a valid comment\"\n" +
		            "}";
	
		Response response = requestSpec.contentType("application/json")  
	            .accept("application/json").header("ROLE","PARENT")
				.body(requestBody)
	            .when()
	            .post("/user/comments/417/report/")
	            .then()
	            .statusCode(200)
	            .body("success", equalTo(true))
	            .log().all()
	            .extract()
	            .response();
	}
}
