package endPoints;
import static io.restassured.RestAssured.*;
import config.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import payload.LogIn_Payload;

public class AuthManager {

	 private static String token;

	    public static String getToken() {

	        if (token == null) {

	            RestAssured.baseURI = ConfigReader.getProperty("baseURI");

	            LogIn_Payload payload = new LogIn_Payload(
	                "senzu.sen@yopmail.com",
	                "Test@123"
	            );

	            Response response =
	                given()
	                    .header("Content-Type", "application/json")
	                    .body(payload)
	                .when()
	                    .post(ConfigReader.getProperty("loginEndpoint"))
	                .then()
	                    .statusCode(200)
	                    .extract()
	                    .response();

	            // Extract the access token from the response body
	            token = response.jsonPath().getString("data.access");

	            System.out.println("ACCESS TOKEN = " + token);
	        }

	        return token;
	    }
}
