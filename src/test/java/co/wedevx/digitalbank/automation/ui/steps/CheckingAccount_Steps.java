package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.models.AccountCard;
import co.wedevx.digitalbank.automation.ui.models.BankTransaction;
import co.wedevx.digitalbank.automation.ui.models.NewCheckingAccountInfo;
import co.wedevx.digitalbank.automation.ui.pages.DepositPage;
import co.wedevx.digitalbank.automation.ui.pages.LoginPage;
import co.wedevx.digitalbank.automation.ui.pages.ViewCheckingAccountPage;
import co.wedevx.digitalbank.automation.ui.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckingAccount_Steps {
    WebDriver driver = Driver.getDriver();
    DepositPage depositPage = new DepositPage(driver);
    private LoginPage loginPage = new LoginPage(driver);
    private ViewCheckingAccountPage viewCheckingAccountPage = new ViewCheckingAccountPage(driver);
    // @BeforeAll
    public static void setUp() {
        WebDriverManager.firefoxdriver().setup();
    }



  //  @Before //select CUCUMBER BEFORE!!!


    @Given("the user is logged in as {string} {string}")
    public void the_user_is_logged_in_as(String userName, String password) {
        loginPage.login(userName, password);

//                     VS
//        WebElement userNameTxt = driver.findElement(By.id("username"));
//        WebElement passwordTxt = driver.findElement(By.id("password"));
//        userNameTxt.sendKeys(userName);
//        passwordTxt.sendKeys(password);
//        WebElement submit = driver.findElement(By.id("submit"));
//        submit.click();
//
    }

    @When("the user creates a new checking account")
    public void the_user_creates_a_new_checking_account(List<NewCheckingAccountInfo>checkingAccInfoList) {
//     the user clicks on checking button
//        WebElement checkingBttn = driver.findElement(By.id("checking-menu"));
//        checkingBttn.click();
//        WebElement newChqBttn = driver.findElement(By.id("new-checking-menu-item"));
//        newChqBttn.click();
//
//        assertEquals("https://dbank-qa.wedevx.co/bank/account/checking-add", driver.getCurrentUrl(), "newChecking button didn't take to the url");
////        the user selects accountType
        NewCheckingAccountInfo testData = checkingAccInfoList.get(0);
//        WebElement accountType = driver.findElement(By.id("Standard Checking"));
//        accountType.click();
////        the user selects ownership
//        driver.findElement(By.id(testData.getAccountOwnership())).click();
////        the user gives name to account
//        driver.findElement(By.id("name")).sendKeys(testData.getAccountName());
////        the user makes an initial deposit
//        driver.findElement(By.id("openingBalance")).sendKeys(String.valueOf(testData.getInitialDeposit()));
////        the user clicks on the submit button
//        driver.findElement(By.id("newCheckingSubmit")).click();
        depositPage.createNewChecking(checkingAccInfoList, testData.getAccountName(), String.valueOf(testData.getInitialDeposit()));
    }

    @Then("the user should see the green confirmation {string} message")
    public void the_user_should_see_the_green_confirmation_message(String expectedFullActualMessage) {
        String expectedFullActualMessage1 = expectedFullActualMessage +"\n×";
        assertEquals(expectedFullActualMessage1, viewCheckingAccountPage.getCreatedAccountConfirmationMassage());
    }

    @Then("the user should see newly added account card")
    public void the_user_should_see_newly_added_account_card(List<AccountCard> accountCardList) {
        Map <String,String> actualResultMap = viewCheckingAccountPage.getNewlyAddedCheckingAccInfoMap();
        AccountCard expectedResult = accountCardList.get(0);
        String formatBalance = String.format("%.2f", expectedResult.getBalance());
        assertEquals(expectedResult.getAccountName(), actualResultMap.get("Actual Account Name"));
        assertEquals("Account: " + expectedResult.getAccountType(), actualResultMap.get("Actual Account Type"));
        assertEquals("Ownership: " + expectedResult.getOwnership(), actualResultMap.get("Actual Account Ownership"));
        assertEquals("Interest Rate: " + expectedResult.getInterestRate(), actualResultMap.get("Actual Account Interest Rate"));
        assertEquals("Balance: $" + formatBalance, actualResultMap.get("Actual Account Balance"));

    }

    @Then("the user should see the following transactions")
    public void the_user_should_see_the_following_transactions(List<BankTransaction> expectedBankTransactions) {
Map<String,String>actualResultMap = viewCheckingAccountPage.getNewlyAddedTransactionInfoMap();

        BankTransaction expectedTransaction = expectedBankTransactions.get(0);
        assertEquals(expectedTransaction.getCategory(), actualResultMap.get("actual category"));
        // assertEquals(expectedTransaction.getDescription(), actualDescription);
        assertEquals(expectedTransaction.getAmount(), Double.parseDouble(actualResultMap.get("actual amount")));
        assertEquals(expectedTransaction.getBalance(), Double.parseDouble(actualResultMap.get("actual balance")));

       // fail();
    }
}
