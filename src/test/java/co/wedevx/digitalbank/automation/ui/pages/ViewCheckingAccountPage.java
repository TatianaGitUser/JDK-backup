package co.wedevx.digitalbank.automation.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewCheckingAccountPage extends BasePageClass{

    public ViewCheckingAccountPage(WebDriver driver) {
       super(driver);
    }

    @FindBy(id = "new-account-conf-alert")
    private WebElement cardMessage;
    @FindBy(xpath = "//div[@id='firstRow']/div")
    private List<WebElement> allFirstRowCards;
@FindBy (xpath = "//table[@id='transactionTable']/tbody/tr")
        private WebElement firstRowOfTransactions;

  public Map<String,String>getNewlyAddedTransactionInfoMap() {

      List<WebElement> columnsOfTable = firstRowOfTransactions.findElements(By.xpath("td"));

      Map<String,String>actualResultMap = new HashMap<>();
      actualResultMap.put("actual category", columnsOfTable.get(1).getText());
      actualResultMap.put("actual description", columnsOfTable.get(2).getText());
      actualResultMap.put("actual amount", columnsOfTable.get(3).getText().substring(1));
      actualResultMap.put("actual balance",columnsOfTable.get(4).getText().substring(1));
 return actualResultMap;
  }
    public Map<String,String> getNewlyAddedCheckingAccInfoMap() {

    WebElement lastAccountCard = allFirstRowCards.get(allFirstRowCards.size() - 1);
    //         //div[@id='firstRow']/div[1]//div[@class='h4 m-0']
    String actualResult = lastAccountCard.getText();

Map<String,String>actualResultMap = new HashMap<>();
actualResultMap.put("Actual Account Name", actualResult.substring(0, actualResult.indexOf("\n")).trim());
actualResultMap.put("Actual Account Type",  actualResult.substring(actualResult.indexOf("Account"), actualResult.indexOf("Ownership")).trim());
actualResultMap.put("Actual Account Ownership", actualResult.substring(actualResult.indexOf("Ownership"), actualResult.indexOf("Account Number:")).trim());
actualResultMap.put("Actual Account Number", actualResult.substring(actualResult.indexOf("Account Number:"), actualResult.indexOf("Interest Rate:")).trim());
actualResultMap.put("Actual Account Interest Rate", actualResult.substring(actualResult.indexOf("Interest Rate:"), actualResult.indexOf("Balance:")).trim());
actualResultMap.put("Actual Account Balance", actualResult.substring(actualResult.indexOf("Balance:")).trim());
return actualResultMap;
}


    public String getCreatedAccountConfirmationMassage() {
        return cardMessage.getText();
    }
}
