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

public class TransferNegativeSteps {

    RegistrationPage registrationPage = new RegistrationPage(getDriver());
    BaseMenuPage baseMenuPage = new BaseMenuPage(getDriver());
    TransferPage transferPage = new TransferPage(getDriver());
    DepositPage depositPage = new DepositPage(getDriver());

    @Given("The user has registered on dbank website and opened two new accounts")
    public void the_user_has_registered_on_dbank_website_and_opened_two_new_accounts() {
        registrationPage.registerNewUser();
        baseMenuPage.newChecking();
        depositPage.createNewCheckingEmptyParams();
        //baseMenuPage.newChecking();
        //depositPage.createNewCheckingEmptyParams();

    }

    @When("the user is trying to transfer funds from one account to another leaving a required field empty")
    public void the_user_is_trying_to_transfer_funds_from_one_account_to_another_leaving_a_required_field_empty() {
        baseMenuPage.transfer();
        transferPage.transferNegative("25.00");

    }

    @Then("the user should see the error message")
    public void the_user_should_see_the_error_message() {
        String actualErrorMessage = getDriver().findElement(By.id("toAccount")).getAttribute("validationMessage");
        //assertEquals(transferPage.getAmountFieldErrorMessage(), actualErrorMessage);
        assertEquals(actualErrorMessage, transferPage.getToAccountErrorMessage());
    }
}
