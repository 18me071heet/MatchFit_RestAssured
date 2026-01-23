package test;

import java.util.Arrays;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import base.BaseTest;
import config.ConfigReader;
import io.restassured.response.Response;
import payload.SignUp_Parent;

public class Parent_Signup extends BaseTest{

	public static String parentUserId;

    @Test
    public void parentSignup() {

    	SignUp_Parent payload = new SignUp_Parent(
               
    			ConfigReader.getProperty("first_name"),
                ConfigReader.getProperty("last_name"),
                ConfigReader.getProperty("email"),
                ConfigReader.getProperty("mobile"),
                ConfigReader.getProperty("password"),
                ConfigReader.getProperty("confirm_password"),
                ConfigReader.getProperty("country"),
                ConfigReader.getProperty("state"),
                ConfigReader.getProperty("city"),
                true,          
                "PARENT",       
                Arrays.asList("Under-8 (U8)"),
                Arrays.asList("English"),
                ConfigReader.getProperty("other_language"));

        Response response =
            requestSpec
                .header("Content-Type", "application/json")
                .body(payload)
                .log().all()
            .when()
                .post("/user/signup/")
            .then()
            .log().all()
            .statusCode(anyOf(is(200), is(201)))
            .body("success", equalTo(true))
            .body("data.user_id", notNullValue())
            .extract()
            .response();

        System.out.println("PARENT SIGNUP RESPONSE = " + response.asString());
    }
    
   
	
}
