package test;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import base.BaseTest;

public class Delete_Post extends BaseTest{

	@Test
	public void removePost() {
		
		requestSpec.header("ROLE","PARENT")
		.when().delete("/user/posts/179/delete/")
		.then()
		.statusCode(200)
		.body("success", equalTo(true))
		.log().all();
		
	}
}
