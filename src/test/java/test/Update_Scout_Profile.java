package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;

public class Update_Scout_Profile extends BaseTest {

	@Test
	public void updateScoutProfile() {
		
		Response response = requestSpec
				            .when()
				            .multiPart("description", "An experienced Football and Vollyball coach with over 15 years of experience")
				            .multiPart("year_established", "2010")
				            .multiPart("affiliation", "Always ready for new challanges and new competitions")
				            .patch("/user/scouts/profile/update/")
				            .then()
				            .statusCode(200)
				            .body("success", equalTo(true))
				            .log().all()
				            .extract()
				            .response();
		
	}

}
