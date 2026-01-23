package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;

public class Get_All_My_Posts extends BaseTest {

	@Test
	void getAllPosts() {
		
		 Response response =
	                requestSpec
	                    .header("ROLE", "PARENT")   
	                    .log().all()
	                .when()
	                    .get("/user/parents/myposts/") 
	                .then()
	                    .statusCode(200).body("success", equalTo(true)).log().all()
	                    .extract()
	                    .response();
	}
	
}
