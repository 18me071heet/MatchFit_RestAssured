package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;


public class Approve_Reject_Media_Requests extends BaseTest {

	@Test
	public void rejectMedia() {
	
		Response response = requestSpec
                .header("ROLE", "PARENT") .multiPart("action", "REJECTED")
                .log().all()
            .when()
                .post("/user/parent/verification-requests/media/141/") 
            .then()
                .statusCode(200)
                .body("success", equalTo(true))
                .log().all()
                .extract()
                .response();
	}
}
