package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;

public class Edit_Comment_Post extends BaseTest{

	@Test
	public void editComment() {
		

		  String requestBody = "{\n" +
		            "  \"text\": \"Another Great Work , Well Done!\"\n" +
		            "}";

		    Response response = requestSpec
		            .header("ROLE", "PARENT")
		            .contentType("application/json")
		            .accept("application/json")
		            .body(requestBody)
		            .log().all()
		        .when()
		            .put("/user/edit-comment/730")  
		        .then()
		            .log().all()
		            .statusCode(200)
		            .body("success", equalTo(true))
		            .extract()
		            .response();

		  
	}
}
