package test;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;

public class Delete_Comment_Post extends BaseTest {

	@Test
	public void deleteComment() {
		
		Response response = requestSpec
				.header("ROLE","PARENT")
				.when()
				.delete("/user/delete-comment/430/")
				.then()
				.statusCode(200)
				.log().all()
				.extract()
				.response();
		
			
	}
}
