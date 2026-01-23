package test;

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
				.log().all()
				.extract()
				.response();
		
	}
}
