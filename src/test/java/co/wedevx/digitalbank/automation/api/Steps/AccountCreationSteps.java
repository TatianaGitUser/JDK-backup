package co.wedevx.digitalbank.automation.api.Steps;

import co.wedevx.digitalbank.automation.api.Models.Account;
import co.wedevx.digitalbank.automation.api.Models.AccountModel;
import co.wedevx.digitalbank.automation.api.Models.AccountTypeModel;
import co.wedevx.digitalbank.automation.api.utils.ObjectMapperUtils;
import co.wedevx.digitalbank.automation.api.utils.RestHTTPRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AccountCreationSteps {
    private AccountModel accountModel;
    @When("the user opens an account with the following credentials")
    public void the_user_opens_an_account_with_the_following_credentials(List<Account> accounts) throws JsonProcessingException {
//        RestAssured.baseURI = "http://tetianac556.mydevx.com/bank/api/v1";
//        Response authRequest = given()
//                .queryParam("username", "admin@demo.io")
//                .queryParam("password","Demo123!")
//                .when()
//                .post("/auth");
//        JsonPath authResponseJsonPath = authRequest.jsonPath();
//        String authToken = authResponseJsonPath.getString("authToken");
//
////convert POJO of users into a single user json
////        create a user request
//
//        ObjectMapper mapper = new ObjectMapper();
//        String accountBodyPayLoad = mapper.writeValueAsString(accounts.get(0));
//        Response accountResponse = given()
//                .header("Authorization", "Bearer "+authToken)
//                .pathParam("user_id", userId)
//                .contentType(ContentType.JSON)
//                .accept(ContentType.JSON)
//                .body(accountBodyPayLoad)
//                .when()
//                .post("/user/{user_id}/account");
//        accountResponse.prettyPrint();
        System.out.println(accounts);

        String accountRequestBodyJSON = ObjectMapperUtils.objectMapper.writeValueAsString(accounts.get(0));
//        Response createAccountResponse = RestHTTPRequest.requestSpecification
//                .body(accountRequestBodyJSON)
//                .pathParam("id", UserCreationSteps.userId)
//                .when()
//                .post("/user/{id}/account");
//        createAccountResponse.prettyPrint();
        Response createAccountResponse = RestHTTPRequest.sendPostRequestWithPathParam(
                "/user/{id}/account","id", UserCreationSteps.userId, accountRequestBodyJSON);
System.out.println(createAccountResponse.asString());
         accountModel = ObjectMapperUtils.objectMapper.readValue(createAccountResponse.asString(), AccountModel.class);
            }

    @Then("the following account info should be returned in the response")
    public void theFollowingAccountInfoShouldBeReturnedInTheResponse(List<Account>accountModelList) {
        assertEquals("AccountName mismatch after creating an account",accountModelList.get(0).getAccountName(), accountModel.getName());
        assertEquals("Account Type Code mismatch",accountModelList.get(0).getAccountTypeCode(), accountModel.getAccountType().getCode());
        assertEquals("Account Opening Deposit Code mismatch",accountModelList.get(0).getOpeningDeposit(), accountModel.getOpeningBalance(), 0.001);
        assertEquals("Account Ownership Type Code mismatch",accountModelList.get(0).getOwnerTypeCode(), accountModel.getOwnershipType().getCode());
        assertEquals("Account Standing Name mismatch",accountModelList.get(0).getAccountStandingName(), accountModel.getAccountStanding().getName());

        if(accountModelList.get(0).getAccountTypeCode().equalsIgnoreCase("SCK")){
            AccountTypeModel expectedAccountTypeModel = AccountTypeModel.createDefaultSCKAccountTypeModel();
            assertEquals(expectedAccountTypeModel.getId(), accountModel.getAccountType().getId());
            assertEquals(expectedAccountTypeModel.getCode(), accountModel.getAccountType().getCode());
            assertEquals(expectedAccountTypeModel.getCategory(), accountModel.getAccountType().getCategory());
            assertEquals(expectedAccountTypeModel.getName(), accountModel.getAccountType().getName());
            assertEquals(expectedAccountTypeModel.getInterestRate(), accountModel.getAccountType().getInterestRate(), 0.001);
            assertEquals(expectedAccountTypeModel.getMinDeposit(), accountModel.getAccountType().getMinDeposit(), 0.001);
            assertEquals(expectedAccountTypeModel.getOverdraftFee(), accountModel.getAccountType().getOverdraftFee(), 0.001);
            assertEquals(expectedAccountTypeModel.getOverdraftLimit(), accountModel.getAccountType().getOverdraftLimit(), 0.001);
        }
    }
}
