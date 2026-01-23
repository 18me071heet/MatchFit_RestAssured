package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;

public class Add_Comment_Post extends BaseTest {

	@Test
	public void add_Comment() {
		
		 String requestBody = "{\n" +
		            "  \"text\": \"Amazing Post , Keep it up champ\"\n" +
		            "}";
		
		Response response = requestSpec
				            .header("ROLE","PARENT")
				            .contentType("application/json")   // ✅ REQUIRED
			                .accept("application/json")
				            .body(requestBody)
				            .when()
				            .post("/user/posts/369/comments/")
				            .then()
				            .statusCode(200)
			                .body("success", equalTo(true))
			                .log().all()
			                .extract()
			                .response();
				            
	}
}
