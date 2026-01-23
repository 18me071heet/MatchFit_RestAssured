package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;

public class Follow_Unfollow_User extends BaseTest{

	@Test
	public void followUnfollow() {
		

	    String requestBody = "{\n" +
	            "  \"following_id\": \"734\"\n" +
	            "}";
		
		Response response = requestSpec.header("ROLE","PARENT")
				.contentType("application/json")   
                .accept("application/json")
				.body(requestBody)
				.when()
				.post("/user/user-follow-unfollow/")
				.then()
				.statusCode(200)
				.body("success", equalTo(true))
				.log().all()
				.extract()
				.response();
	}
}
