package test;

import org.testng.annotations.Test;

import base.BaseTest;
import endPoints.AuthManager;
import io.restassured.response.Response;

public class My_Players extends BaseTest {

	@Test
	void getMyPlayers() {
		
		 Response response =
	                requestSpec
	                    .header("ROLE", "PARENT")   
	                    .log().all()
	                .when()
	                    .get("/user/parents/players") 
	                .then()
	                    .log().all()
	                    .statusCode(200)
	                    .extract()
	                    .response();
	}
	
}
