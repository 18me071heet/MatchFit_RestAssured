package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;

public class Scout_Directory extends BaseTest {

	@Test
	public void getScoutDetails() {
		
		Response response = requestSpec
				            .when()
				            .get("/user/scouts/directory/?search=Senzu")
				            .then()
				            .statusCode(200)
				            .body("success", equalTo(true))
				            .log().all()
				            .extract()
				            .response();
		
	}
}
