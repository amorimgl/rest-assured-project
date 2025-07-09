package steps;

import org.junit.Test;


import project.common.BodyRequest;
import project.common.EnvUrl;

import io.restassured.RestAssured;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class FirstTest {

    private EnvUrl newEnvUrl;
    private BodyRequest bodyRequest;
    private String requestBody;
    private Response response;
    public String path;
    public String account;
    private String envUrl;

    public FirstTest() {
        this.newEnvUrl = new EnvUrl();
        this.envUrl = newEnvUrl.getEnvUrlSit();
    }

    @Test
    public void setSearchRequest() {

    path = "src/main/resources/FirstStep.json";
    bodyRequest = new BodyRequest(path);
    bodyRequest.readJsonFile();
    requestBody = bodyRequest.displayBody();


    response = given()
            .header("Content-Type", "application/json")
            .body(requestBody)
            .post(envUrl);

    response.then().statusCode(200);
    response.then().body("headers", is(notNullValue()));
    }
}