package testAdmin;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import base.BaseTestAdmin;
import config.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import payload.Login_Admin_Payload;


public class Login {

    @Test
    public void loginWithValidCredentials() {

    	 // Set base URI
        RestAssured.baseURI = "https://api-koradream.dev.inheritxdev.in/api/v1";

         Login_Admin_Payload payload = new Login_Admin_Payload (
                "tejo@yopmail.com",  
                "Admin@123"              
            );

        // Send login request
        Response response =
            RestAssured
                .given()
                    .contentType("application/json")
                    .log().all()
                    .body(payload)
                .when()
                    .post("/user/email-login/")
                .then()
                    .log().all()
                    .statusCode(200)                 // expected status
                    .body("success", equalTo(true))  // optional validation
                    .extract()
                    .response();

        System.out.println("LOGIN RESPONSE = " + response.asString());
    }
}
