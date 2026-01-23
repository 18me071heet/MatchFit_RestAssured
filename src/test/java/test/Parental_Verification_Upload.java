package test;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import org.testng.annotations.Test;
import base.BaseTest;
import io.restassured.response.Response;
public class Parental_Verification_Upload extends BaseTest{

	 @Test
	    public void uploadVerificationDocument() {

	        int userId = 927; 
	        File file = new File("C:\\Users\\INX\\OneDrive\\Documents\\Saved Pictures\\testing.png");

	        Response response =
	                requestSpec
	                    .multiPart("user_id", String.valueOf(userId))
	                    .multiPart("file", file)
	                .when()
	                    .post("/user/verification/upload/")
	                .then()
	                    .statusCode(201)
	                    .body("success", equalTo(true))
	                    .extract()
	                    .response();

	       
	    }
}
