package test;

import java.io.File;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;

public class Create_Social_Post extends BaseTest {

	File file = new File("C:\\Users\\INX\\OneDrive\\Documents\\Saved Pictures\\testing.png");
	
	@Test
	public void createPost() {
		
		Response response =
	            requestSpec
	                .header("ROLE", "PARENT") 
	                .multiPart("player_id", "103")
	                .multiPart("caption", "New Post by Julia has been added from the Rest API")
	                .multiPart("media_file", file)
	                .multiPart("access", "public")
	                .when().post("/user/social-feeds/")
	                .then().statusCode(200).log().all()
	                .extract()
                    .response();
	}
}
