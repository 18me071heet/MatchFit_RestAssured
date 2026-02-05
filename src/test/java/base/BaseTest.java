package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import endPoints.AuthManager;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
	public WebDriver driver;
	protected RequestSpecification requestSpec;
    protected static final org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getLogger(BaseTest.class);

	@BeforeClass
	public void setup() {

		RestAssured.baseURI = "https://api-koradream.dev.inheritxdev.in/api/v1";

		java.io.PrintStream logStream = IoBuilder.toLog4j();
		
		requestSpec = RestAssured.given()
                .filter(new io.restassured.filter.log.RequestLoggingFilter(logStream))
                .filter(new io.restassured.filter.log.ResponseLoggingFilter(logStream))
				.header("Authorization", "Bearer " + AuthManager.getToken());
	}
}
