package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;

public class Forgot_Password extends BaseTest{

	String requestBody = "{\n" +
            "  \"email_or_mobile\": \"wisely.rom@yopmail.com\"\n" +
            "}";
	
	@Test
	public void forgotPassword() {
		
		requestSpec.contentType("application/json")   
        .accept("application/json").body(requestBody).when()
		.post("/user/forget-password/")
		.then().statusCode(200).body("success", equalTo(true))
		.log().all().extract().response();
		

	}
}
