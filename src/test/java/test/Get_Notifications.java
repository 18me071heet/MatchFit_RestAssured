package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;

public class Get_Notifications extends BaseTest{

	@Test
	public void getNotifications() {
		
		Response response = requestSpec.header("ROLE","PARENT")
				            .when()
				            .get("/user/notifications/")
				            .then()
				            .statusCode(200)
				            .body("success", equalTo(true))
				            .log().all()
				            .extract()
				            .response();
		
				           
	}
}
