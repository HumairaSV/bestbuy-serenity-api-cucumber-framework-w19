package com.bestbuy.cucumber.steps;

import com.bestbuy.productsnstoresinfo.StoreSteps;
import com.bestbuy.utils.TestUtils;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;
import static org.hamcrest.Matchers.hasValue;


public class MyStepdefs {

    static int storeId;
    static int storeId1;
    static String name = null;

    @Steps
    StoreSteps storeSteps;
    static ValidatableResponse response;

    @Given("^Best buy API playground in running$")
    public void bestBuyAPIPlaygroundInRunning() {
    }

    @When("^I create a new store by providing the information name \"([^\"]*)\" type \"([^\"]*)\" address \"([^\"]*)\" address2 \"([^\"]*)\" city \"([^\"]*)\" state \"([^\"]*)\" zip \"([^\"]*)\" lat \"([^\"]*)\" lng \"([^\"]*)\" hours \"([^\"]*)\" service1 \"([^\"]*)\" service2 \"([^\"]*)\"$")
    public void iCreateANewStoreByProvidingTheInformationNameTypeAddressAddressCityStateZipLatLngHoursServiceService(String name1, String type, String address, String address2, String city, String state, String zip, double lat, double lng, String hours, String service1, String service2) {
        HashMap<String, Object> services = new HashMap<>();
        services.put(service1, service2);
        name = TestUtils.getRandomValue() + name1;
        response = storeSteps.createStore(name, type, address, address2, city, state, zip, lat, lng, hours, services);
        storeId = response.log().all().extract().path("id");

    }

    @Then("^I verify the store with name \"([^\"]*)\" is created$")
    public void iVerifyTheStoreWithNameIsCreated(String name1) {
        response.statusCode(201);
        HashMap<String, Object> storeMap = storeSteps.extractStoreByID(storeId);
        Assert.assertThat(storeMap, hasValue(name));
    }

    @And("^I update the store with information name \"([^\"]*)\" type \"([^\"]*)\" address \"([^\"]*)\" address2 \"([^\"]*)\" city \"([^\"]*)\" state \"([^\"]*)\" zip \"([^\"]*)\" lat \"([^\"]*)\" lng \"([^\"]*)\" hours \"([^\"]*)\" service1 \"([^\"]*)\" service2 \"([^\"]*)\"$")
    public void iUpdateTheStoreWithInformationNameTypeAddressAddressCityStateZipLatLngHoursServiceService(String name1, String type, String address, String address2, String city, String state, String zip, double lat, double lng, String hours, String service1, String service2) {
        name = name + "_updated";
        HashMap<String, Object> services = new HashMap<>();
        services.put(service1, service2);
        response = storeSteps.updateStore(name, type, address, address2, city, state, zip, lat, lng, hours, services, storeId);
    }

    @And("^I verify that the store with the name \"([^\"]*)\" has been updated successfully$")
    public void iVerifyThatTheStoreWithTheNameHasBeenUpdatedSuccessfully(String name1) {
        HashMap<String, Object> storeMap = storeSteps.extractStoreByID(storeId);
        Assert.assertThat(storeMap, hasValue(name));
    }

    @And("^I delete the store created with name \"([^\"]*)\"$")
    public void iDeleteTheStoreCreatedWithName(String arg0) {
        response = storeSteps.deletingStoreById(storeId);
    }

    @Then("^I verify that the store is deleted successfully from the database$")
    public void iVerifyThatTheStoreIsDeletedSuccessfullyFromTheDatabase() {
        response.statusCode(200);
        storeSteps.getStoreById(storeId).statusCode(404);
    }

    //____________________________________________________________________________________


    @When("^I send a GET request to stores endpoint$")
    public void iSendAGETRequestToStoresEndpoint() {
        response = storeSteps.getAllStores();
    }

    @When("^I send a POST request to stores endpoint with the information name \"([^\"]*)\" type \"([^\"]*)\" address \"([^\"]*)\" address2 \"([^\"]*)\" city \"([^\"]*)\" state \"([^\"]*)\" zip \"([^\"]*)\" lat \"([^\"]*)\" lng \"([^\"]*)\" hours \"([^\"]*)\" service1 \"([^\"]*)\" service2 \"([^\"]*)\"$")
    public void iSendAPOSTRequestToStoresEndpointWithTheInformationNameTypeAddressAddressCityStateZipLatLngHoursServiceService(String name, String type, String address, String address2, String city, String state, String zip, double lat, double lng, String hours, String service1, String service2) {
        HashMap<String, Object> services = new HashMap<>();
        services.put(service1, service2);
        response = storeSteps.createStore(name, type, address, address2, city, state, zip, lat, lng, hours, services);
        storeId1 = response.log().all().extract().path("id");
    }

    @When("^I send a GET request to single storeID endpoint$")
    public void iSendAGETRequestToSingleStoreIDEndpoint() {
        response = storeSteps.getStoreById(storeId1);
    }

    @When("^I send a PUT request to single storeID endpoint with updated information name \"([^\"]*)\" type \"([^\"]*)\" address \"([^\"]*)\" address2 \"([^\"]*)\" city \"([^\"]*)\" state \"([^\"]*)\" zip \"([^\"]*)\" lat \"([^\"]*)\" lng \"([^\"]*)\" hours \"([^\"]*)\" service1 \"([^\"]*)\" service2 \"([^\"]*)\"$")
    public void iSendAPUTRequestToSingleStoreIDEndpointWithUpdatedInformationNameTypeAddressAddressCityStateZipLatLngHoursServiceService(String name, String type, String address, String address2, String city, String state, String zip, double lat, double lng, String hours, String service1, String service2) {
        name = name + "_updated";
        HashMap<String, Object> services = new HashMap<>();
        services.put(service1, service2);
        response = storeSteps.updateStore(name, type, address, address2, city, state, zip, lat, lng, hours, services, storeId1);
    }

    @When("^I send a DELETE request to single storeID endpoint$")
    public void ISendADELETERequestToSingleStoreIDEndpoint() {
        response = storeSteps.deletingStoreById(storeId1);
    }


    @Then("^I must get back a valid status code \"([^\"]*)\"$")
    public void iMustGetBackAValidStatusCode(int code) {
        response.statusCode(code);
    }
}
