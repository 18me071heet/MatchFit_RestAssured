package testAdmin;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

import org.testng.annotations.Test;

import base.BaseTestAdmin;
import endPoints.AuthManagerAdmin;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import payload.VerifyOTP_Payload;

public class Verify_OTP  {

	@Test
	public void verifyOTP() {
		
		 
		  VerifyOTP_Payload payload = new VerifyOTP_Payload(
			        "tejo@yopmail.com",
			        "958865"
			    );

			    Response response =
			        RestAssured.given().baseUri("https://api-koradream.dev.inheritxdev.in/api/v1")
			            .contentType("application/json")
			            .body(payload)
			        .when()
			            .post("/adminapi/verify_otp_admin/")
			        .then()
			            .statusCode(200)
			            .extract()
			            .response();

			    String token = response.jsonPath().getString("data.access");

			    AuthManagerAdmin.setToken(token);
		
	}
}

