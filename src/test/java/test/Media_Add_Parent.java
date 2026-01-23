package test;

import java.io.File;

import org.testng.annotations.Test;

import base.BaseTest;
import io.restassured.response.Response;

public class Media_Add_Parent extends BaseTest{

	File file = new File("C:\\Users\\INX\\OneDrive\\Documents\\Saved Pictures\\testing.png");
	
	@Test
	public void createMedia() {
		
		Response response =
	            requestSpec
	                .header("ROLE", "PARENT") 
	                .multiPart("player_id", "103")
	                .multiPart("media_caption", "New Media by Julia has been added from the Rest API")
	                .multiPart("media_file", file)
	                .multiPart("access", "public")
	                .when().post("/user/parents/player/media/add")
	                .then().statusCode(201).log().all()
	                .extract()
                    .response();
	}
}
