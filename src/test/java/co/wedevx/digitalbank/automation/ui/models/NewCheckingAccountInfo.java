package co.wedevx.digitalbank.automation.ui.models;

public class NewCheckingAccountInfo {
    private String checkingAccountType;
    private String accountOwnership;
    private String accountName;
    private double initialDeposit;

    public NewCheckingAccountInfo(String checkingAccountType, String accountOwnership, String accountName, double initialDeposit) {
        this.checkingAccountType = checkingAccountType;
        this.accountOwnership = accountOwnership;
        this.accountName = accountName;
        this.initialDeposit = initialDeposit;
    }

    public String getCheckingAccountType() {
        return checkingAccountType;
    }

    public void setCheckingAccountType(String checkingAccountType) {
        this.checkingAccountType = checkingAccountType;
    }

    public String getAccountOwnership() {
        return accountOwnership;
    }

    public void setAccountOwnership(String accountOwnership) {
        this.accountOwnership = accountOwnership;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getInitialDeposit() {
        return initialDeposit;
    }

    public void setInitialDeposit(double initialDeposit) {
        this.initialDeposit = initialDeposit;
    }
}
