package co.wedevx.digitalbank.automation.api.utils;

import co.wedevx.digitalbank.automation.ui.utilities.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestHTTPRequest {

    public static RequestSpecification requestSpecification = RestAssured.given();
//    authToken is auto-generated, no need to generated again
    public final static String authToken;

    static {  //instance initializer - runs automatically when you run a project
        requestSpecification.baseUri(ConfigReader.getPropertiesValeu("digitalbank.base.api.uri"));
        authToken = generateAuthenticationToken();
        addHeaders();
    }

    private static String generateAuthenticationToken() {
        Response authRequest = requestSpecification
                .queryParam("username", ConfigReader.getPropertiesValeu("digitalbank.api.admin.username"))
                .queryParam("password", ConfigReader.getPropertiesValeu("digitalbank.api.admin.password"))
                .when()
                .post("/auth");
        JsonPath authResponseJsonPath = authRequest.jsonPath();
        return authResponseJsonPath.getString("authToken");

    }
    public static void addHeaders(){
        requestSpecification.contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer "+authToken);
    }

    public static Response sendPostRequestWithPathParam(String endpoint, String pathParamId,
                                                        Object pathPathParamValue, String body){
        return requestSpecification
                .body(body)
                .pathParam(pathParamId, pathPathParamValue)
                .when()
                .post(endpoint);

    }
}
