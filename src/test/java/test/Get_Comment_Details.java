package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;

public class Get_Comment_Details extends BaseTest{

	@Test
	public void getCommentDetails() {
		
		Response response = requestSpec
				.header("ROLE","PARENT")
				.when()
				.get("/user/posts/279/comments-list/")
				.then() .statusCode(200)
	            .body("success", equalTo(true))
	            .log().all()
	            .extract()
	            .response();
				
	}
}
