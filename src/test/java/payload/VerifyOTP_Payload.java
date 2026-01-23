package payload;

public class VerifyOTP_Payload {

	 private String email;
	    private String otp;

	    public VerifyOTP_Payload(String email, String otp) {
	        this.email = email;
	        this.otp = otp;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getOtp() {
	        return otp;
	    }
}
