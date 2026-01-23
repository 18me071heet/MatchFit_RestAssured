package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;

public class Followers_List extends BaseTest {

	@Test
	public void followersFollowingList() {
		
		Response response = requestSpec.header("ROLE","PARENT")
				            .when()
				            .get("/user/734/followers-following/")
				            .then()
				            .statusCode(200)
				            .body("success", equalTo(true))
				            .log().all()
				            .extract()
				            .response();
				            
	}
}
