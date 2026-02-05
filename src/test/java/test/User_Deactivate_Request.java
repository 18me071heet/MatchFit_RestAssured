package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;

public class User_Deactivate_Request extends BaseTest{

	@Test
	public void userDeactivate() {
		
		requestSpec.header("ROLE","PARENT")
		           .when()
		           .post("/user/profile/deactivate/")
		           .then()
		           .statusCode(201).body("success", equalTo(true)).log().all();
		
	}
}
