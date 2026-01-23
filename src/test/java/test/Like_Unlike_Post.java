package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;

public class Like_Unlike_Post extends BaseTest{

	@Test
	public void likeUnlike() {
		
		Response response = requestSpec
				.header("ROLE","PARENT")
				.when()
				.post("/user/posts/383/like-unlike/")
				.then()
				.statusCode(200)
				 .body("success", equalTo(true))
				.log().all()
				.extract().response();
				
	}
}
