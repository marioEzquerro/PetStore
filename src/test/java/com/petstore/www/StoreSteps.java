package com.petstore.www;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.Serializable;

public class StoreSteps implements Serializable {
    Response GetRequest = null;
    Response PostRequest = null;
    Response DeleteRequest = null;
    Response PutRequest = null;

    @Before
    public void before() {
        RestAssured.baseURI = "http://petstore.swagger.io/v2";
    }

    public String preparePostReques() {
        return "{\n" +
                "    \"petId\": \"\"\n" +
                "    \"quantity\": \"3\"\n" +
                "    \"shipDate\": \"2020-04-24T17:13:12.110Z\"\n" +
                "    \"status\": \"placed\"\n" +
                "    \"complete\": \"true\"\n" +
                "}";
    }

    // POST ---------------
    @When("the user sends the post request")
    public void theUserSendsThePostRequest() {
    }

    @Then("a new order is created")
    public void aNewOrderIsCreated() {
    }

    // GET BY ID ---------------
    @When("the user sends the get request by {string}")
    public void theUserSendsTheGetRequestBy(String id) {
    }

    @Then("the request contains the order")
    public void theRequestContainsTheOrder() {
    }

    // DELETE ---------------
    @When("the user sends the delete request {string}")
    public void theUserSendsTheDeleteRequest(String id) {
        DeleteRequest = RestAssured.given().delete("/store/order/" + id);
    }

    @Then("the order gets deleted")
    public void theOrderGetsDeleted() {
        Assert.assertEquals("Error en el borrado", 200, DeleteRequest.getStatusCode());
    }

    // GET ALL ---------------
    @When("the user sends the get request")
    public void theUserSendsTheGetRequest() {
        GetRequest = RestAssured.given().when().get("/store/inventory");
    }

    @Then("the request is successful")
    public void theRequestIsSuccessful() {
        Assert.assertEquals("Error en get request", 200, GetRequest.getStatusCode());
    }


}







