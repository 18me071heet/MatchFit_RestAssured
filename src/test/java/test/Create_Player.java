package test;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response; 
import org.testng.annotations.Test;
import base.BaseTest;
import endPoints.AuthManager;

public class Create_Player extends BaseTest{

	public static String playerId;

	    @Test
	    public void createPlayer() {

	        Response response =
	            requestSpec
	                .header("ROLE", "PARENT") // must include

	                .multiPart("username", "Johnty")
	                .multiPart("password", "Stens@123")
	                .multiPart("first_name", "Johnty")
	                .multiPart("last_name", "Stens")
	                .multiPart("gender", "boy")
	                .multiPart("dob", "2002-02-03")
	                .multiPart("country", "India")
	                .multiPart("state", "Gujarat")
	                .multiPart("city", "Jamnagar")
	                .multiPart("preferred_positions", "Goalkeeper")
	                .log().all()
	            .when()
	                .post("/user/parents/createplayer/")
	            .then()
	                .statusCode(201)
	                .body("success", equalTo(true))
	                .body("data.player_id", notNullValue())
	                .extract()
	                .response();

	        playerId = response.jsonPath().getString("data.player_id");
	        System.out.println("CREATED PLAYER ID = " + playerId);
	        
	    }
	    
	  
		@Test(dependsOnMethods = "createPlayer")
	    void getPlayerDetails() {

			  requestSpec
		        .headers(
		            "Authorization", "Bearer  " + AuthManager.getToken(),  // include token
		            "ROLE", "PARENT"                                       // include role
		        )
	        .when()
	            .get("/user/players" + playerId + "/")
	        .then()
	            .statusCode(200)
	            .log().all();
	    }
}
