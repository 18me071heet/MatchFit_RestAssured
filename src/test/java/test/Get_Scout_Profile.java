package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;

public class Get_Scout_Profile extends BaseTest {

	@Test
	public void getScoutProfile() {
		
		Response response = requestSpec
				            .when()
				            .get("/user/scouts/profile/")
				            .then()
				            .statusCode(200)
				            .body("success", equalTo(true))
				            .log().all().extract()
				            .response();
		
				            
	}
}
