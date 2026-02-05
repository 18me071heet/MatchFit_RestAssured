package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;

public class LogOut extends BaseTest{

	@Test
	public void logOut() {
		
		requestSpec.when().post("/user/logout/")
		.then()
		.statusCode(200)
		 .body("success", equalTo(true))
		 .log().all();
		
	}
}
