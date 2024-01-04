package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.models.NewCheckingAccountInfo;
import co.wedevx.digitalbank.automation.ui.pages.DepositPage;
import co.wedevx.digitalbank.automation.ui.pages.LoginPage;
import co.wedevx.digitalbank.automation.ui.pages.RegistrationPage;
import co.wedevx.digitalbank.automation.ui.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class HW_Deposit {
    public static WebDriver driver = Driver.getDriver();
    RegistrationPage registrationPage = new RegistrationPage(driver);
    LoginPage loginPage = new LoginPage(driver);

    DepositPage depositPage = new DepositPage(driver);
    @Given("the user navigates to deposit page in digital bank")
    public void the_user_navigates_to_deposit_page_in_digital_bank() {

        registrationPage.registerNewUser();
    }
    @When("the user selects his {string} and puts {string} and clicks Submit button")
    public void the_user_selects_his_and_puts_and_clicks_submit_button(String accountName, String depositAmount) {
        depositPage.createNewCheckingEmptyParams();
        depositPage.initialDeposit(accountName, depositAmount);
        depositPage.depositToExistingAccount("5.00");
    }
    @Then("the user should be displayed with new Balance card and transactions info table")
    public void the_user_should_be_displayed_with_new_balance_card_and_transactions_info_table() {
        assertEquals("Balance: $35.00", depositPage.getBalance());
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement date = driver.findElement(By.xpath("(//tr[@role='row']/td)[1]"));
        wait.until(ExpectedConditions.visibilityOf(date));

        assertEquals(driver.findElement(By.xpath("(//tr[@role='row']/td)[1]")).getText(), depositPage.getDate());
        assertEquals(driver.findElement(By.xpath("(//tr[@role='row']/td)[3]")).getText(), depositPage.getTransactionDescription());
        assertEquals(driver.findElement(By.xpath("(//tr[@role='row']/td)[5]")).getText(), depositPage.getTotalBalance());
        assertEquals(driver.findElement(By.xpath("(//tr[@role='row']/td)[4]")).getText(), depositPage.getAmount());
//depositPage.goToHomePage(); inheritance example
    }
}
