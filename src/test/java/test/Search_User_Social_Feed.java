package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;

public class Search_User_Social_Feed extends BaseTest {

	@Test
	void searchUser() {
		
		Response response =requestSpec
				.when()
				.get("/user/social/feeds-list/?search=Steve&sort=newest")
				.then() .statusCode(200)
	            .body("success", equalTo(true))
	            .log().all()
	            .extract()
	            .response();
	}
	
}
