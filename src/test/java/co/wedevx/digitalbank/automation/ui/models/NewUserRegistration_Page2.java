package co.wedevx.digitalbank.automation.ui.models;

public class NewUserRegistration_Page2 {
    private String address;
    private String locality;
    private String region;
    private String postalCode;
    private String country;
    private String homePhone;
    public NewUserRegistration_Page2(String address, String locality, String region, String postalCode, String country, String homePhone){
        this.address = address;
        this.locality = locality;
        this.region = region;
        this.postalCode = postalCode;
        this.country = country;
        this.homePhone = homePhone;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }
}
