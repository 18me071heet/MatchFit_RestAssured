package payload;

public class LogIn_Payload {
 
	 private String identifier;
	    private String password;

	    public LogIn_Payload(String identifier, String password) {
	        this.identifier = identifier;
	        this.password = password;
	    }

	    public String getIdentifier() {
	        return identifier;
	    }

	    public String getPassword() {
	        return password;
	    }
	
}
