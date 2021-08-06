package project.steps.Postman;

import project.common.BodyRequest;
import project.common.EnvUrl;

import static com.jayway.restassured.RestAssured.given;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import com.jayway.restassured.response.Response;

public class FirstStep {

    private EnvUrl newEnvUrl;
    private BodyRequest bodyRequest;
    private String requestBody;
    private Response response;
    public String path;
    public String account;
    private String envUrl;

    public FirstStep() {
        this.newEnvUrl = new EnvUrl();
        this.envUrl = newEnvUrl.getEnvUrlSit();
    }

    @Given("the request is executed")
    public void setSearchRequest() {

        path = "src/test/resources/json/FirstStep.json";
        bodyRequest = new BodyRequest(path);
        bodyRequest.readJsonFile();
        requestBody = bodyRequest.displayBody();

        response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post(envUrl);
    }

    @Then("the response information is returned")
    public void checkSearchResultReturn() {
        response.then().statusCode(200);
        response.then().body("headers", is(notNullValue()));
    }

}