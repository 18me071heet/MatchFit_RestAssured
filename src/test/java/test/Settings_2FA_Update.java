package test;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;

public class Settings_2FA_Update extends BaseTest{

	@Test
	public void settings2FA() {
		
		Map<String, Object> body = new HashMap<>();
	    body.put("two_fa_enabled", false);
	    body.put("biometric_enabled", true);
	    body.put("notifications_enabled", true);
		
		Response response = requestSpec.header("ROLE","PARENT")
				            .contentType("application/json")    
                            .accept("application/json")
                            .body(body)
				            .when()
				            .patch("/user/2fa-settings/")
				            .then()
				            .statusCode(200)
				            .log().all()
				            .body("success", equalTo(true))
				            .extract()
				            .response();
				        
	}
}
