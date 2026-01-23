package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;

public class Edit_Player_Details extends BaseTest{

	 @Test
	    public void editPlayer() {
	    	
	    	 Response response =
	 	            requestSpec
	 	                .header("ROLE", "PARENT") // must include
	 	                .multiPart("first_name", "Reynaaa")
	 	                .multiPart("last_name", "Killerr")
	 	               .when()
		                .patch("/user/parents/players/103/")
		            .then()
		                .statusCode(200)
		                .body("success", equalTo(true))
		                .extract()
		                .response();
	    }
}
