package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.pages.BaseMenuPage;
import co.wedevx.digitalbank.automation.ui.pages.DepositPage;
import co.wedevx.digitalbank.automation.ui.pages.RegistrationPage;
import co.wedevx.digitalbank.automation.ui.pages.TransferPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static co.wedevx.digitalbank.automation.ui.utilities.Driver.getDriver;
import static org.junit.Assert.assertEquals;

public class TransferFundsBetweenAccounts {

    RegistrationPage registrationPage = new RegistrationPage(getDriver());
    DepositPage depositPage = new DepositPage(getDriver());
    BaseMenuPage baseMenuPage = new BaseMenuPage(getDriver());
    TransferPage transferPage = new TransferPage(getDriver());
    @Given("The user has registered at dbank and created two accounts")
    public void the_user_has_registered_at_dbank_and_created_accounts() {
     registrationPage.registerNewUser();
     baseMenuPage.newChecking();
     depositPage.createNewCheckingEmptyParams();
     baseMenuPage.newChecking();
     depositPage.createNewCheckingEmptyParams();
    }
    @When("the user transfers money from one account to another")
    public void the_user_transfers_money_from_one_account_to_another() {
       baseMenuPage.transfer();
       transferPage.transfer();
    }
    @Then("the user should see updated balance in the destination account")
    public void the_user_should_see_updated_balance_in_the_destination_account() {
       String actualSecondBalance = getDriver().findElement(By.xpath("(//div[@class='h4 m-0'])[4]")).getText();
        assertEquals(transferPage.getSecondBalance(),actualSecondBalance);
        String actualTransactionDescription = getDriver().findElement(By.xpath("//div/table//tr[2]/td[3]")).getText();
        assertEquals(baseMenuPage.transactionHistory(), actualTransactionDescription);
    }

}
