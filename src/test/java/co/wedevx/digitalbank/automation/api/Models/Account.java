package co.wedevx.digitalbank.automation.api.Models;

public class Account {
    private String accountName;
    private String accountTypeCode;
    private double openingDeposit;
    private String ownerTypeCode;
    private String accountStandingName;

    public Account(String accountName, String accountTypeCode, double openingDeposit, String ownerTypeCode, String accountStandingName) {
        this.accountName = accountName;
        this.accountTypeCode = accountTypeCode;
        this.openingDeposit = openingDeposit;
        this.ownerTypeCode = ownerTypeCode;
        this.accountStandingName = accountStandingName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountTypeCode() {
        return accountTypeCode;
    }

    public void setAccountTypeCode(String accountTypeCode) {
        this.accountTypeCode = accountTypeCode;
    }

    public double getOpeningDeposit() {
        return openingDeposit;
    }

    public void setOpeningDeposit(double openingDeposit) {
        this.openingDeposit = openingDeposit;
    }

    public String getOwnerTypeCode() {
        return ownerTypeCode;
    }

    public void setOwnerTypeCode(String ownerTypeCode) {
        this.ownerTypeCode = ownerTypeCode;
    }

    public String getAccountStandingName() {
        return accountStandingName;
    }

    public void setAccountStandingName(String accountStandingName) {
        this.accountStandingName = accountStandingName;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", accountTypeCode='" + accountTypeCode + '\'' +
                ", openingDeposit='" + openingDeposit + '\'' +
                ", ownerTypeCode='" + ownerTypeCode + '\'' +
                ", accountStandingName='" + accountStandingName + '\'' +
                '}';
    }
}
