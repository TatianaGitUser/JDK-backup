package co.wedevx.digitalbank.automation.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WithdrawPage extends BasePageClass{

    public WithdrawPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "withdraw-menu-item")
    private WebElement withdrawMenuBtn;
    @FindBy(id = "selectedAccount")
    private WebElement selectAccDropDown;
    @FindBy(id = "amount")
    private WebElement withdrawAmountField;
    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
    private WebElement submitBtn;
    @FindBy(xpath = "(//div[@class='h4 m-0'])[2]")
    private WebElement newBalanceCard;
    @FindBy(xpath = "//tbody//td")
    private List<WebElement> transactionHistoryTable;
    @FindBy(xpath = "//div[@class='sufee-alert alert with-close alert-danger alert-dismissible fade show']")
    private WebElement errorMessage;
    public static List<Map<String, String>> testDataListOfMapssaved = new ArrayList<>();

    public void withdrawFromSavings(List<Map<String, String>> testDataListOfMaps, String withdrawalAmount) {
        Map<String, String> testDataMap = testDataListOfMaps.get(0);
        withdrawMenuBtn.click();
        Select select = new Select(selectAccDropDown);
        System.out.println(testDataMap.get("accountName"));
        //select.selectByIndex(1);
        withdrawAmountField.sendKeys(withdrawalAmount);
        submitBtn.click();
    }

    public String getBalance() {
        String balanceInCard = newBalanceCard.getText();
    return balanceInCard;
    }
    public String getTransactionDescription(){
       return transactionHistoryTable.get(2).getText();
    }
    public String getOverdraftErrorMessage(){
        return errorMessage.getText();
    }
    public String emptyFieldErrorMessage(){
        return selectAccDropDown.getAttribute("validationMessage");
    }
}
