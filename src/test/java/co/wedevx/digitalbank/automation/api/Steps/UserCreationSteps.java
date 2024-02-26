package co.wedevx.digitalbank.automation.api.Steps;

import co.wedevx.digitalbank.automation.api.Models.Account;
import co.wedevx.digitalbank.automation.api.Models.UserAPIModel;
import co.wedevx.digitalbank.automation.api.Models.UserDomainForDataTable;
import co.wedevx.digitalbank.automation.api.utils.RestHTTPRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;

import static co.wedevx.digitalbank.automation.api.utils.ObjectMapperUtils.objectMapper;
import static io.restassured.RestAssured.given;

public class UserCreationSteps {
    public static int userId = 0;

    @Given("the following user is in the DB")
    public void the_following_user_is_in_the_db(List<UserDomainForDataTable> userDomainForDataTables) throws JsonProcessingException {
//        RestAssured.baseURI = "http://tetianac556.mydevx.com/bank/api/v1";
//        Response authRequest = given()
//                .queryParam("username", "admin@demo.io")
//                .queryParam("password","Demo123!")
//                .when()
//                .post("/auth");
//        JsonPath authResponseJsonPath = authRequest.jsonPath();
//        String authToken = authResponseJsonPath.getString("authToken");

////convert POJO of users into a single user json
////        create a user request
//
//        ObjectMapper mapper = new ObjectMapper();
//        String userBodyPayLoad = mapper.writeValueAsString(users.get(0));
//        System.out.println(userBodyPayLoad);
//
//        Response createPostRequestResponse = given()
//                .header("Authorization", "Bearer "+authToken)
//                .contentType(ContentType.JSON)
//                .accept(ContentType.JSON)
//                .body(userBodyPayLoad)
//                .when()
//                .post("/user");
//        createPostRequestResponse.prettyPrint();

//        VS
        String createUserBodyPayLoad = objectMapper.writeValueAsString(userDomainForDataTables.get(0));

        Response response = RestHTTPRequest.requestSpecification
                .body(createUserBodyPayLoad)
                .when()
                .post("/user");
        response.prettyPrint();
        UserAPIModel testUser = objectMapper.readValue(response.asString(), UserAPIModel.class);

        System.out.println(testUser.getId());
        System.out.println(testUser.getUsername());
        userId = testUser.getId();
    }

}
