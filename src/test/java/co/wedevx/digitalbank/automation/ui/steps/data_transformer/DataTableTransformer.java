package co.wedevx.digitalbank.automation.ui.steps.data_transformer;

import co.wedevx.digitalbank.automation.ui.models.*;
import io.cucumber.java.DataTableType;


import java.util.Map;

public class DataTableTransformer {

    @DataTableType
    public AccountCard accountCardEntry (Map<String ,String>entry){
        String accoutName = entry.get("accountName");
        String accountType = entry.get("accountType");
        String ownership = entry.get("ownership");
        long accountNumber = Long.parseLong(entry.get("accountNumber"));
        String interestRate = entry.get("interestRate");
        double balance = Double.valueOf(entry.get("balance"));
        return new AccountCard(accoutName, accountType, ownership, accountNumber, interestRate, balance);
    }
    @DataTableType
    public BankTransaction transactionEntry(Map<String, String>entry){
        String date = entry.get("date");
        String category = entry.get("category");
        String description = entry.get("description");
        double amount = Double.parseDouble(entry.get("amount"));
        double balance = Double.parseDouble(entry.get("balance"));
        return new BankTransaction(date,category, description, amount, balance);
    }
    @DataTableType
    public NewCheckingAccountInfo newCheckingAccountInfo(Map<String,String>entry){
        String checkingAccountType = entry.get("checkingAccountType");
        String accountOwnership = entry.get("accountOwnership");
        String accountName = entry.get("accountName");
        double initialDeposit = Double.parseDouble(entry.get("initialDeposit"));
        return new NewCheckingAccountInfo(checkingAccountType, accountOwnership, accountName, initialDeposit);
    }
    @DataTableType
    public NewUserRegistration newUserRegistration (Map<String, String>entry){
        String title = entry.get("title");
        String firstName = entry.get("firstName");
        String lastName = entry.get("lastName");
        String gender = entry.get("gender");
        String dOB = entry.get("dOB");
        String sSN = entry.get("sSN");
        String email = entry.get("email");
        String password = entry.get("password");
        String confirmPassword = entry.get("confirmPassword");
        return new NewUserRegistration(title, firstName, lastName, gender, dOB, sSN, email, password, confirmPassword);
    }
    @DataTableType
    public NewUserRegistration_Page2 newUserRegistration2 (Map<String,String>entry){
        String address = entry.get("address");
        String locality = entry.get("locality");
        String region = entry.get("region");
        String postalCode = entry.get("postalCode");
        String country = entry.get("country");
        String homePhone = entry.get("homePhone");
        return new NewUserRegistration_Page2(address, locality, region, postalCode, country, homePhone);
    }
}
