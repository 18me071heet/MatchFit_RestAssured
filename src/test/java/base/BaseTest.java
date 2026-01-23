package base;

import org.testng.annotations.BeforeClass;
import endPoints.AuthManager;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseTest {

	  protected RequestSpecification requestSpec;

	    @BeforeClass
	    public void setup() {

	        RestAssured.baseURI = "https://api-koradream.dev.inheritxdev.in/api/v1";

	        requestSpec =
	            RestAssured
	                .given()
	               
	                .header("Authorization", "Bearer " + AuthManager.getToken());
	    }
}
