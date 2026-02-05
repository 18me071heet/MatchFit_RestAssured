package test;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;

public class Read_Specific_Notification extends BaseTest {

    private static final org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(Read_Specific_Notification.class);

	@Test
	public void readSpecificNotification() {
		
        logger.info("Starting test: readSpecificNotification");

		 Map<String, Object> body = new HashMap<>();
		    body.put("notification_id", 2268); 
            logger.info("Request Body prepared: " + body);
		
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
		
        logger.info("Response received with Status Code: " + response.getStatusCode());
        logger.debug("Response Body: " + response.asString());
        logger.info("Test finished: readSpecificNotification");
	}
}
