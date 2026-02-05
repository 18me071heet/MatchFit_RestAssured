package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;

public class Reset_Password extends BaseTest{
	
	   String requestBody = "{\n" +
	            "  \"email_or_phone\": \"wisely.rom@yopmail.com\",\n" +
	            "  \"newPassword\": \"Test@1234\",\n" +
	            "  \"confirmPassword\": \"Test@1234\"\n" +
	            "}";


	@Test
	public void resetPassword() {
		
		requestSpec.contentType("application/json")   
        .accept("application/json").body(requestBody).when()
		.post("/user/reset-password/")
		.then()
		.statusCode(200)
		  .body("success", equalTo(true))
		.log()
		.all();
		
	}
}
