package co.wedevx.digitalbank.automation.ui.pages;

import co.wedevx.digitalbank.automation.ui.models.NewCheckingAccountInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class DepositPage extends BaseMenuPage{
    int transactionId = 1;
    private String expectedUrl = "https://dbank-qa.wedevx.co/bank/account/checking-add";

    public DepositPage(WebDriver driver) {
      super(driver);
      transactionId++;
    }

    @FindBy(id = "deposit-menu-item")
    private WebElement depositBtn;

    @FindBy(id = "Standard Checking")
    private WebElement standardCheckingRadioBtn;
    @FindBy(id = "Individual")
    private WebElement individualRadioBtn;
    @FindBy(id = "Joint")
    private WebElement jointAccRadioBtn;
    @FindBy(id = "Interest Checking")
    private WebElement interestCheckingBtn;
    @FindBy(id = "name")
    private WebElement accountNameField;
    @FindBy(id = "openingBalance")
    private WebElement initialDepositField;
    @FindBy(id = "newCheckingSubmit")
    private WebElement submitBtn;
    @FindBy(id = "selectedAccount")
    private WebElement accountSelect;
    @FindBy(id = "amount")
    private WebElement depositAmountField;
    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
    private WebElement depositSubmitBtn;
    @FindBy(xpath = "//div[contains(text(),'Balance')]")
    private WebElement balanceDisplay;
    @FindBy(xpath = "(//tr[@role='row']/td)[3]")
    private WebElement transactionDescriptionMessage;
    @FindBy(xpath = "(//tr[@role='row']/td)[1]")
    private WebElement transactionDateMsg;
    @FindBy(xpath = "(//tr[@role='row']/td)[4]")
    private WebElement transactionAmountMsg;
    @FindBy(xpath = "(//tr[@role='row']/td)[5]")
    private WebElement totalBalanceMsg;

    @FindBy (id = "savings-menu")
    private WebElement savingsMenuBtn;
    @FindBy(id = "new-savings-menu-item")
    private WebElement newSavingsBtn;
    @FindBy(id = "Savings")
    private WebElement savingsRadioBtn;
    @FindBy(id = "Money Market")
    private WebElement moneyMarketRadioBtn;

public static List<NewCheckingAccountInfo> checkingAccInfoList = new ArrayList<>();
    public void createNewChecking(List<NewCheckingAccountInfo> checkingAccInfoList, String accountName, String initialDeposit) {
        NewCheckingAccountInfo testDateForOneCheckingAccount = checkingAccInfoList.get(0);
        checkingMenuBtn.click();
        newCheckingBtn.click();
        if (testDateForOneCheckingAccount.getCheckingAccountType().equalsIgnoreCase("Standard Checking")) {
            standardCheckingRadioBtn.click();
        } else if (testDateForOneCheckingAccount.getCheckingAccountType().equalsIgnoreCase("Interest Checking")) {
            interestCheckingBtn.click();
        } else {
            throw new NoSuchElementException("Invalid checking account type");
        }
        if (testDateForOneCheckingAccount.getAccountOwnership().equalsIgnoreCase("individual")) {
            individualRadioBtn.click();
        }else if(testDateForOneCheckingAccount.getAccountOwnership().equalsIgnoreCase("joint")){
            jointAccRadioBtn.click();
        }else {
            throw new NoSuchElementException("Invalid checking account type");
        }
        accountNameField.sendKeys(accountName);
        initialDepositField.sendKeys(initialDeposit);
        submitBtn.click();
    }
    public void createNewCheckingEmptyParams() {

        standardCheckingRadioBtn.click();

        individualRadioBtn.click();

        accountNameField.sendKeys("account"+transactionId);
        initialDepositField.sendKeys(transactionId+"100.00");
        submitBtn.click();
        transactionId = 1;
    }

//      WebElement newAccountAlert = driver.findElement(By.id("new-account-conf-alert"));
//        System.out.println(newAccountAlert.getText());
//

    public void initialDeposit(String accountName, String initialDeposit) {

    }

    public void depositToExistingAccount(String deposit) {
        depositBtn.click();
        Select select = new Select(accountSelect);
        select.selectByIndex(1);
        depositAmountField.sendKeys(deposit);
        depositSubmitBtn.click();
    }

    public String getBalance() {
        return balanceDisplay.getText();
    }

    public String getDate() {
        return transactionDateMsg.getText();
    }

    public String getTransactionDescription() {
        return transactionDescriptionMessage.getText();
    }

    public String getTotalBalance() {
        return totalBalanceMsg.getText();
    }

    public String getAmount() {
        return transactionAmountMsg.getText();
    }
public void createSavingsAccountAndDeposit(List<Map<String,String>>testDataListOfMaps){
        Map<String,String>mapOfTestData = testDataListOfMaps.get(0);

        savingsMenuBtn.click();
        newSavingsBtn.click();
        if(mapOfTestData.get("accountType").equalsIgnoreCase("Savings")){
            savingsRadioBtn.click();
        }else{
            moneyMarketRadioBtn.click();
        }
        if(mapOfTestData.get("ownership").equalsIgnoreCase("Individual")){
            individualRadioBtn.click();
        }else {
            jointAccRadioBtn.click();
        }
        accountNameField.sendKeys(mapOfTestData.get("accountName"));
        initialDepositField.sendKeys(mapOfTestData.get("initialDeposit"));
        depositSubmitBtn.click();
}
}
