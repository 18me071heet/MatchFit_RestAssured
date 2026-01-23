package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;

public class Scout_Search_Player extends BaseTest {

	@Test
	public void scoutSearchPlayer() {
		
		Response respone = requestSpec
				           .when()
				           .get("/user/players/search/?positions=Centre Back&foot=RIGHT")
				           .then()
				           .statusCode(200)
				           .body("success", equalTo(true))
				           .log().all()
				           .extract()
				           .response();
	}
}
