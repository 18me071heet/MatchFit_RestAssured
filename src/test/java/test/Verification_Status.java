package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;

public class Verification_Status extends BaseTest{

	@Test
	void verifyStatus() {
		
		  Response response =
	                requestSpec
	                .when()
	                    .get("/user/verification-status/")
	                .then()
	                    .statusCode(200)
	                    .body("success", equalTo(true))
	                    .log().all()
	                    .extract()
	                    .response();
		  
         

	}
}
