package co.wedevx.digitalbank.automation.ui.models;

public class NewUserRegistration {
    private String title;
    private String firstName;
    private String lastName;
    private String gender;
    private String dOB;
    private String sSN;
    private String email;
    private String password;
    private String confirmPassword;


    public NewUserRegistration(String title, String firstName, String lastName, String gender, String dOB, String sSN, String email, String password, String confirmPassword) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dOB = dOB;
        this.sSN = sSN;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getdOB() {
        return dOB;
    }

    public void setdOB(String dOB) {
        this.dOB = dOB;
    }

    public String getsSN() {
        return sSN;
    }

    public void setsSN(String sSN) {
        this.sSN = sSN;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }


}
