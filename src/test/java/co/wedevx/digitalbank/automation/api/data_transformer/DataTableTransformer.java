package co.wedevx.digitalbank.automation.api.data_transformer;

import co.wedevx.digitalbank.automation.api.Models.Account;
import co.wedevx.digitalbank.automation.api.Models.UserDomainForDataTable;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class DataTableTransformer {
    @DataTableType
    public UserDomainForDataTable newUser (Map<String,String>entry){
       String title = entry.get("title");
       String firstName = entry.get("firstName");
       String lastName = entry.get("lastName");
       String gender = entry.get("gender");
       String dob = entry.get("dob");
       String ssn = entry.get("ssn");
       String emailAddress = entry.get("emailAddress");
       String password = entry.get("password");
       String address = entry.get("address");
       String locality = entry.get("locality");
       String postalCode = entry.get("postalCode");
       String region = entry.get("region");
       String country = entry.get("country");
       String homePhone = entry.get("homePhone");
       String mobilePhone = entry.get("mobilePhone");
    return new UserDomainForDataTable(title, firstName, lastName, gender, dob, ssn, emailAddress, password, address, locality, region, postalCode, country, homePhone, mobilePhone);
    }

    @DataTableType
    public Account newAccount (Map<String,String>entry){
    String accountName = entry.get("accountName");
    String accountTypeCode = entry.get("accountTypeCode");
    double openingDeposit = Double.parseDouble(entry.get("openingDeposit"));
    String ownerTypeCode = entry.get("ownerTypeCode");
    String accountStandingName = entry.get("accountStandingName");
    return new Account(accountName, accountTypeCode, openingDeposit, ownerTypeCode, accountStandingName);

    }
}
