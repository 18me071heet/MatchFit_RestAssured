package test;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;

public class Read_Specific_Notification extends BaseTest {

	@Test
	public void readSpecificNotification() {
		
		 Map<String, Object> body = new HashMap<>();
		    body.put("notification_id", 2268); 
		
		Response response = requestSpec.header("ROLE","PARENT")
				            .contentType("application/json")
				            .body(body)
				            .when()
				            .post("/user/notifications/mark-read/")
				            .then()
				            .statusCode(200)
				            .body("success", equalTo(true))
				            .log().all()
				            .extract()
				            .response();
				            
	}
}
