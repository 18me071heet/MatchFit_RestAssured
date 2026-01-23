package testAdmin;

import org.testng.annotations.Test;

import base.BaseTestAdmin;
import endPoints.AuthManagerAdmin;
import io.restassured.response.Response;

public class Get_Admin_Profile extends BaseTestAdmin{

	@Test
	public void getAdminProfile() {
		
		 requestSpec
	        .header("ROLE", "ADMIN")
	        .log().all()
	    .when()
	        .get("/adminapi/profile/")
	    .then()
	        .log().all()
	        .statusCode(200);
	}
}
