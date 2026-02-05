package test;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import base.BaseTest;

import config.ConfigReader;
import io.restassured.response.Response;
import payload.LogIn_Payload;
public class Login extends BaseTest {

    @Test
    public void loginWithValidCredentials() {

        LogIn_Payload payload = new LogIn_Payload(
            "wisely.rom@yopmail.com",
            "Test@123"
        );

        Response response =
            requestSpec.contentType("application/json")
                .body(payload)
            .when()
                .post(ConfigReader.getProperty("loginEndpoint"))
                .then()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("data.access", not(isEmptyOrNullString()))
                .extract()
                .response();

        String token = response.jsonPath().getString("data.access");
        System.out.println("TOKEN = " + token);
    }
}
