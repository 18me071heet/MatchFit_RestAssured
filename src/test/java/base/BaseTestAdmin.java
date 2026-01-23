package base;

import org.testng.annotations.BeforeClass;

import config.ConfigReader;
import endPoints.AuthManagerAdmin;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseTestAdmin {

	 protected RequestSpecification requestSpec;

	    @BeforeClass
	    public void setup() {

	        requestSpec = RestAssured.given()
	            .baseUri("https://api-koradream.dev.inheritxdev.in/api/v1")
	            .contentType("application/json")
	            .header("Authorization", "Bearer " + AuthManagerAdmin.getToken())
	            .header("ROLE", "ADMIN");
	    }
}
