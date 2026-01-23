package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;

public class Generate_Unique_Username extends BaseTest {

	@Test
	void generateUsername() {
		
		 Response response =
	                requestSpec
	                    .header("ROLE", "PARENT")   
	                    .log().all()
	                .when()
	                    .get("/user/players/generate-username/") 
	                .then()
	                    .statusCode(200)
	                    .body("success", equalTo(true)).log().all()
	                    .extract()
	                    .response();
	}
}
