package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;

public class List_User_Likes extends BaseTest{

	@Test
	void userLikes() {
		
		Response response = requestSpec
				.header("ROLE","PARENT")
				.when()
				.get("user/posts/369/likes/")
				.then()
				.statusCode(200)
				.body("success", equalTo(true))
				.log().all()
				.extract()
				.response();
		
	}
}
