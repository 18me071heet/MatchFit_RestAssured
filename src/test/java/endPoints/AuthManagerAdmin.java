package endPoints;

public class AuthManagerAdmin {

	private static String token;

    public static void setToken(String accessToken) {
        token = accessToken;
        System.out.println("Admin token stored");
    }

    public static String getToken() {
        if (token == null) {
            throw new RuntimeException(
                "Admin token not available. Run Verify_OTP test first."
            );
        }
        return token;
    }
}
