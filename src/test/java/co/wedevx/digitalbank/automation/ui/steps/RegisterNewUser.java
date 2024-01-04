package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.pages.RegistrationPage;
import co.wedevx.digitalbank.automation.ui.utilities.BrowserHelper;
import co.wedevx.digitalbank.automation.ui.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class RegisterNewUser {
    public static WebDriver driver = Driver.getDriver();
    private RegistrationPage registrationPage = new RegistrationPage(driver);


    @Given("The user is on the main page of dbank and clicked {string} button")
    public void the_user_is_on_the_main_page_of_dbank_and_clicked_button(String string) {

        driver.get("https://dbank-qa.wedevx.co/bank");
    }

    @When("the user provides new credentials")
    public void the_user_provides_new_credentials(){

        registrationPage.registerNewUser();
       // WebElement nextBtn = driver.findElement(By.xpath("//button[@type='submit']"));
       // BrowserHelper.waitForVisibilityOfElement(driver, nextBtn, 5);
    }

    @When("clicked {string} button")
    public void clicked_button(String string) {

    }

    @When("privided new credentials on the next page")
    public void privided_new_credentials_on_the_next_page() {

    }

    @Then("the user should see confirmation message")
    public void the_user_should_see_confirmation_message() {

    }

}
