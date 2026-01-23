package testAdmin;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import base.BaseTestAdmin;
public class Update_Admin_Profile extends BaseTestAdmin {

    @Test
    public void updateProfile() {

        Map<String, Object> body = new HashMap<>();
        body.put("first_name", "Tejoo");
        body.put("last_name", "Testing");

        requestSpec
            .header("ROLE", "ADMIN")  // role header required by backend
            .log().all()
            .body(body)
        .when()
            .put("/adminapi/profile/update/")  // PATCH safer than PUT
        .then()
            .log().all()
            .statusCode(200)
            .body("success", equalTo(true));
    }
}
