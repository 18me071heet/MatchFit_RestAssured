package test;

import org.testng.annotations.Test;

import base.BaseTest;

public class Get_Parent_Profile extends BaseTest{

	@Test
	void getProfile() {
		
		requestSpec.header("ROLE","PARENT").when().get("/user/parents/profile/").then().statusCode(200).log().all();
	
	}
}
