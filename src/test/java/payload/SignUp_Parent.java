package payload;

import java.util.List;

public class SignUp_Parent {

	private String first_name;
    private String last_name;
    private String email;
    private String mobile;
    private String password;
    private String confirm_password;
    private String country;
    private String state;
    private String city;
    private boolean terms_agreed;
    private String roletype;
    private List<String> age_groups_covered;
    private List<String> languages_spoken;
    private String other_language;

    // ✅ REQUIRED: No-args constructor
    public SignUp_Parent() {
    }

    // Existing constructor (keep it)
    public SignUp_Parent(String first_name, String last_name, String email, String mobile,
                         String password, String confirm_password, String country,
                         String state, String city, boolean terms_agreed,
                         String roletype, List<String> age_groups_covered,
                         List<String> languages_spoken, String other_language) {

        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.confirm_password = confirm_password;
        this.country = country;
        this.state = state;
        this.city = city;
        this.terms_agreed = terms_agreed;
        this.roletype = roletype;
        this.age_groups_covered = age_groups_covered;
        this.languages_spoken = languages_spoken;
        this.other_language = other_language;
    }

    // ✅ GETTERS & SETTERS (MANDATORY)

    public String getFirst_name() { return first_name; }
    public void setFirst_name(String first_name) { this.first_name = first_name; }

    public String getLast_name() { return last_name; }
    public void setLast_name(String last_name) { this.last_name = last_name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getConfirm_password() { return confirm_password; }
    public void setConfirm_password(String confirm_password) { this.confirm_password = confirm_password; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public boolean isTerms_agreed() { return terms_agreed; }
    public void setTerms_agreed(boolean terms_agreed) { this.terms_agreed = terms_agreed; }

    public String getRoletype() { return roletype; }
    public void setRoletype(String roletype) { this.roletype = roletype; }

    public List<String> getAge_groups_covered() { return age_groups_covered; }
    public void setAge_groups_covered(List<String> age_groups_covered) {
        this.age_groups_covered = age_groups_covered;
    }

    public List<String> getLanguages_spoken() { return languages_spoken; }
    public void setLanguages_spoken(List<String> languages_spoken) {
        this.languages_spoken = languages_spoken;
    }

    public String getOther_language() { return other_language; }
    public void setOther_language(String other_language) {
        this.other_language = other_language;
    }
}
