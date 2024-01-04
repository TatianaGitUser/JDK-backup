package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.pages.RegistrationPage;
import co.wedevx.digitalbank.automation.ui.pages.UpdatingUserInfoPage;
import co.wedevx.digitalbank.automation.ui.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class UpdatingRandomUser {
    private WebDriver driver = Driver.getDriver();
    private UpdatingUserInfoPage updatingUserInfoPage = new UpdatingUserInfoPage(driver);

    @Given("the user updates his existing info")
    public void the_user_updates_his_existing_info() {
        driver.get("https://dbank-qa.wedevx.co/bank");

        updatingUserInfoPage.updateProfile();
    }
    @When("he clicks submit button")
    public void he_clicks_submit_button() {
        
    }
    @Then("he should see the confirmation message")
    public void he_should_see_the_confirmation_message() {
        
    }

}
