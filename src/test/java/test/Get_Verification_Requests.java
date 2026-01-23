package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;

public class Get_Verification_Requests extends BaseTest{

	@Test
	public void getVerificationRequest() {
		
		Response response =
				 requestSpec
                 .header("ROLE", "PARENT")   
				.when().get("/user/parent/verification-requests/")
				.then().statusCode(200) .body("success", equalTo(true))
				.log().all()
				.extract()
				.response();
	}
}
