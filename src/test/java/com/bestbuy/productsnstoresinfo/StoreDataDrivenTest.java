package com.bestbuy.productsnstoresinfo;

import com.bestbuy.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

@Concurrent(threads = "2x")
@UseTestDataFrom("src/test/java/resources/testdata/Storesdata.csv")
//@UseTestDataFrom("src/test/java/resources/testdata/productsdata.csv")
@RunWith(SerenityParameterizedRunner.class)
public class StoreDataDrivenTest extends TestBase {
    private String name;
    private String type;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private double lat;
    private double lng;
    private String hours;
    private String service1;
    private String service2;

    private String productName;
    private String productType;
    private double price;
    private int shipping;
    private String upc;
    private String description;
    private String manufacturer;
    private String model;
    private String url;
    private String image;


    @Steps
    StoreSteps storeSteps;
    ProductSteps productSteps;

    @Title("Data driven test to create multiple stores")
    @Test
    public void createMultipleStores() {
        HashMap<String, Object> services = new HashMap<>();
        services.put(service1, service2);
        storeSteps.createStore(name, type, address, address2, city, state, zip, lat, lng, hours, services).statusCode(201);
    }

    /*@Title("Data driven test to create multiple products")
    @Test
    public void createMultipleProducts() {
        productSteps.createProduct(name, type, price, shipping, upc, description, manufacturer, model, url, image).statusCode(201);
    }*/

}
