package test;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;

public class Update_Post extends BaseTest{
	
	File file = new File("C:\\Users\\INX\\OneDrive\\Documents\\Saved Pictures\\test.jpg");

	@Test
	public void updatePost() {
		
		Response response =
	            requestSpec
	                .header("ROLE", "PARENT") 
	                .multiPart("caption", "New Post has been update from Rest api.")
	                .multiPart("media_file", file)
		.when().put("/user/posts/178/edit/")
		.then()
		.statusCode(200) .body("success", equalTo(true)).log().all().extract().response();
		
	}
}
