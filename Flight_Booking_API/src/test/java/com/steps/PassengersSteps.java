package com.steps;


import io.cucumber.java.en.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import com.config.ApiConfig;
import com.utils.AuthUtil;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PassengersSteps {
    private String token;
    private Response response;
    
 // Inner POJO for Passenger
    public static class Passenger {
        private String passengerId;
        private String passengerName;
        private String passengerMobile;
        private String passengerGender;
        private String passengerAadharNumber; // ✅ match backend spelling
        private String passengerAddress;

        public Passenger(String passengerId, String passengerName, String passengerMobile,
                         String passengerGender, String passengerAadharNumber, String passengerAddress) {
            this.passengerId = passengerId;
            this.passengerName = passengerName;
            this.passengerMobile = passengerMobile;
            this.passengerGender = passengerGender;
            this.passengerAadharNumber = passengerAadharNumber;
            this.passengerAddress = passengerAddress;
        }

        // Getters (needed for JSON serialization)
        public String getPassengerId() { return passengerId; }
        public String getPassengerName() { return passengerName; }
        public String getPassengerMobile() { return passengerMobile; }
        public String getPassengerGender() { return passengerGender; }
        public String getPassengerAadharNumber() { return passengerAadharNumber; }
        public String getPassengerAddress() { return passengerAddress; }
    }


    @Given("I have a valid access token")
    public void i_have_a_valid_access_token() {
        token = AuthUtil.getAccessToken();
    }

    @When("I add passenger with id {string} name {string} mobile {string} gender {string} aadhar {string} address {string}")
    public void addPassenger(String id, String name, String mobile, String gender, String aadhar, String address) {
    	
    	Passenger passenger = new Passenger(id, name, mobile, gender, aadhar, address);

        response = given()
            .spec(ApiConfig.REQUEST)
            .auth().oauth2(token)
            .contentType("application/json")
            .body(passenger)
        .when()
            .post("/addPassenger")
        .then()
            .extract().response();

    	
    }

    @Then("the response status should be {string}")
    public void response_status_should_be(String status) {
        response.then().statusCode(Integer.parseInt(status));
    }

    @Then("the passenger with id {string} should have name {string}")
    public void passenger_should_have_name(String id, String expectedName) {
        // fetch by id and assert name
        Response r = given()
            .spec(ApiConfig.REQUEST)
            .auth().oauth2(token)
        .when()
            .get("/viewPassengerById/" + id)
        .then()
            .statusCode(200)
            .extract().response();

        String actualName = r.jsonPath().getString("passengerName");
        assertThat(actualName, equalTo(expectedName));
    }

    @When("I fetch passenger list")
    public void fetch_passenger_list() {
        response = given().spec(ApiConfig.REQUEST).auth().oauth2(token).when().get("/viewPassengerList").then().extract().response();
    }

    @Then("the list should contain passenger id {string}")
    public void list_should_contain_id(String id) {
    	
//        assertThat(response.asString(), containsString(String.valueOf(Integer.parseInt(id))));
    	List<Integer> passengerIds = response.jsonPath().getList("passengerId");
        assertThat(passengerIds, hasItem(Integer.parseInt(id)));
    }

    @When("I fetch passenger by name {string} and mobile {string}")
    public void fetch_by_name_mobile(String name, String mobile) {
        response = given().spec(ApiConfig.REQUEST).auth().oauth2(token).when()
            .get("/viewPassengerByNameMobile/" + name + "/" + mobile).then().extract().response();
    }

    @When("I delete passenger with id {string}")
    public void delete_passenger(String id) {
        response = given().spec(ApiConfig.REQUEST).auth().oauth2(token).when().delete("/deletePassengerById/" + id).then().extract().response();
    }
    @When("I fetch passenger by id {string}")
    public void i_fetch_passenger_by_id(String id) {
        // Write code here that turns the phrase above into concrete actions
    	response = given().spec(ApiConfig.REQUEST).auth().oauth2(token).when().get("/viewPassengerById/"+id).then().extract().response();
    }
    
}
