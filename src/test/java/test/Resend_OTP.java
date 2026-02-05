package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;

public class Resend_OTP extends BaseTest {

	@Test
	public void resendOTP() {
		
		 String requestBody = "{\n" +
		            "  \"email_or_phone\": \"wisely.rom@yopmail.com\"\n" +
		            "}";
		 
		Response response = requestSpec.contentType("application/json")  
	            .accept("application/json").body(requestBody).when().post("/user/resend-code/")
				.then().statusCode(200)
				 .body("success", equalTo(true))
				.log().all()
				.extract().response();
	}
}
