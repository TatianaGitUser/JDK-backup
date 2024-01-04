package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.pages.DepositPage;
import co.wedevx.digitalbank.automation.ui.pages.RegistrationPage;
import co.wedevx.digitalbank.automation.ui.pages.WithdrawPage;
import co.wedevx.digitalbank.automation.ui.utilities.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;

import static co.wedevx.digitalbank.automation.ui.pages.WithdrawPage.testDataListOfMapssaved;
import static co.wedevx.digitalbank.automation.ui.utilities.Driver.getDriver;
import static org.junit.Assert.assertEquals;

public class WithdrawFromSavings {
    RegistrationPage registrationPage = new RegistrationPage(getDriver());
    DepositPage depositPage = new DepositPage(getDriver());
    WithdrawPage withdrawPage = new WithdrawPage(getDriver());

    @Given("the user is logged in as new user")
    public void the_user_is_logged_in_as_new_user() {
        getDriver().get("https://dbank-qa.wedevx.co/bank");
        registrationPage.registerNewUser();
        getDriver().get(ConfigReader.getPropertiesValeu("digitalbank.createsavingsurl"));

    }
    @When("the user creates a new savings account with new credentials")
    public void the_user_creates_a_new_savings_account_with_new_credentials(List<Map<String,String>> testDataListOfMaps) {
        Map<String,String>testDataMap = testDataListOfMaps.get(0);
        depositPage.createSavingsAccountAndDeposit(testDataListOfMaps);
        testDataListOfMapssaved.add(testDataMap);
    }
    @When("the user withdraws ${string}")
    public void the_user_withdraws_$(String withdrawalAmount) {
        Map<String,String>testDataMap = testDataListOfMapssaved.get(0);
        withdrawPage.withdrawFromSavings(testDataListOfMapssaved, withdrawalAmount);
    }
    @Then("the user should see the balance confirmation {string} message")
    public void the_user_should_see_the_balance_confirmation_message(String balance) {

        //assertEquals(balance, withdrawPage.getBalance());
    }
    @Then("the user should see the following transactions data")
    public void the_user_should_see_the_following_transactions_data(List<Map<String,String>> testDataListOfMaps) {
       getDriver().get(ConfigReader.getPropertiesValeu("digitalbank.withdraw"));
       getDriver().navigate().to("https://dbank-qa.wedevx.co/bank/account/withdraw");
        Map<String, String> testMap = testDataListOfMaps.get(0);
//        double initialDeposit = Double.parseDouble(testMap.get("initialDeposit"));
//        if ( initialDeposit > 100.00) {
//            String expected = getDriver().findElement(By.xpath("(//tbody//td)[3]")).getText();
//            assertEquals(expected, withdrawPage.getTransactionDescription());
//        }else if(initialDeposit < 100.00) {
//            assertEquals(testMap.get("errorMessage"), withdrawPage.getOverdraftErrorMessage());
//        }else{
            assertEquals(testMap.get("errorMessage"),withdrawPage.emptyFieldErrorMessage());
        }
    }
//}
