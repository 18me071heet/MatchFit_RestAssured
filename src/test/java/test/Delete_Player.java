package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;

public class Delete_Player extends BaseTest{

	
	@Test
	public void deletePlayer() {
		
		requestSpec.header("ROLE","PARENT")
		           .when()
		           .delete("/user/parents/players/152/delete/")
		           .then()
		           .statusCode(200)
		           .body("success", equalTo(true))
		           .log().all();
	}
}
