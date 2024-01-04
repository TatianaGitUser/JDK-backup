package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.pages.RegistrationPage;
import co.wedevx.digitalbank.automation.ui.utilities.ConfigReader;

import co.wedevx.digitalbank.automation.ui.utilities.DB_Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static co.wedevx.digitalbank.automation.ui.utilities.Driver.getDriver;
import static org.junit.Assert.assertEquals;

public class RegistrationSteps {

    RegistrationPage registrationPage = new RegistrationPage(getDriver());
    List<Map<String,Object>>nextValList = new ArrayList<>();
    @Given("User navigates to Digital Bank account")
    public void user_navigates_to_digital_bank_account() {
        getDriver().get(ConfigReader.getPropertiesValeu("digitalbank.registrationpageurl"));
        assertEquals("Registration title mismatch", getDriver().getTitle(), "Digital Bank");
    }

    @When("user creates account with following fields")
    public void user_creates_account_with_following_fields(List<Map<String, String>> registrationTestDataMap) {
        registrationPage.registerNewUserWithDataTable(registrationTestDataMap);
    }

    @Then("the user should be displayed with the message {string}")
    public void the_user_should_be_displayed_with_the_message(String expectedSuccessMessage) {
assertEquals("success message mismatch", expectedSuccessMessage, registrationPage.getMessage());
    }
    @Then("the following user info should be saved in the db")
    public void the_following_user_info_should_be_saved_in_the_db(List<Map<String, String>>expectedUserProfileInfoInBD) {
        Map<String,String> expectedUserInfoMap = expectedUserProfileInfoInBD.get(0);
        String queryUserTable = String.format("select * from users where username = '%s'", expectedUserInfoMap.get("email"));
        String queryUserProfile = String.format("select * from user_profile where email_address = '%s'", expectedUserInfoMap.get("email"));

        List<Map<String, Object>> actualUserInfoList = DB_Utils.runSQLSelectQuery(queryUserTable);
        List<Map<String, Object>> actualUserProfileInfoList = DB_Utils.runSQLSelectQuery(queryUserProfile);

        assertEquals("registration generated duplicate users",1, actualUserInfoList.size());
        assertEquals("registration generated duplicate users",1, actualUserProfileInfoList.size());

        Map<String, Object> actualUserInfoMap = actualUserInfoList.get(0);
        Map<String, Object> actualUserProfileInfoMap = actualUserProfileInfoList.get(0);

        assertEquals("registration generated wrong title", expectedUserInfoMap.get("title"), actualUserProfileInfoMap.get("title"));
        assertEquals("registration generated wrong first name", expectedUserInfoMap.get("firstName"), actualUserProfileInfoMap.get("first_name"));
        assertEquals("registration generated wrong last name", expectedUserInfoMap.get("lastName"), actualUserProfileInfoMap.get("last_name"));
        assertEquals("registration generated wrong gender", expectedUserInfoMap.get("gender"), actualUserProfileInfoMap.get("gender"));
      //  assertEquals("registration generated wrong dob", expectedUserInfoMap.get("dob"), actualUserProfileInfoMap.get("dob"));
        assertEquals("registration generated wrong ssn", expectedUserInfoMap.get("ssn"), actualUserProfileInfoMap.get("ssn"));
        assertEquals("registration generated wrong email", expectedUserInfoMap.get("email"), actualUserProfileInfoMap.get("email_address"));
        assertEquals("registration generated wrong address", expectedUserInfoMap.get("address"), actualUserProfileInfoMap.get("address"));
        assertEquals("registration generated wrong locality", expectedUserInfoMap.get("locality"), actualUserProfileInfoMap.get("locality"));
        assertEquals("registration generated wrong region", expectedUserInfoMap.get("region"), actualUserProfileInfoMap.get("region"));
        assertEquals("registration generated wrong postal code", expectedUserInfoMap.get("postalCode"), actualUserProfileInfoMap.get("postal_code"));
        assertEquals("registration generated wrong postal country", expectedUserInfoMap.get("country"), actualUserProfileInfoMap.get("country"));
        assertEquals("registration generated wrong postal homePhone", expectedUserInfoMap.get("homePhone"), actualUserProfileInfoMap.get("home_phone"));
        assertEquals(nextValList.get(0).get("next_val"), actualUserInfoMap.get("id"));
        long expectedProfileID = Integer.parseInt(String.valueOf(nextValList.get(0).get("next_val")));
        assertEquals(expectedProfileID+1, actualUserProfileInfoMap.get("id"));

//        validate usersTable:

    }
    @Then("the user should see the {string} required field error message {string}")
    public void theUserShouldSeeTheRequiredFieldErrorMessage(String fieldName, String expectedErrorMessage) throws InterruptedException {
      String actualErrorMsg = (registrationPage.getRequiredFieldErrorMessage(fieldName));
      Thread.sleep(1000);
      assertEquals("The error message of field"+fieldName+" mismatch", expectedErrorMessage, actualErrorMsg);
    }

    @Given("the user with {string} is not in DB")
    public void theUserWithIsNotInDB(String email) {
        String queryForUserProfile = String.format("DELETE FROM user_profile WHERE email_address = '%s'", email);
        String queryForUsers = String.format("DELETE FROM users WHERE username = '%s'", email);

        String queryToGetNextValInHibernateSeqTable = String.format("select * from hibernate_sequence");
        nextValList = DB_Utils.runSQLSelectQuery(queryToGetNextValInHibernateSeqTable);

        DB_Utils.runSQLUpdateQuery(queryForUserProfile);
        DB_Utils.runSQLUpdateQuery(queryForUsers);
    }
}
