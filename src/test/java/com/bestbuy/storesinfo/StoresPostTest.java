package com.bestbuy.storesinfo;

import com.bestbuy.model.StorePojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class StoresPostTest extends TestBase {

    @Test
    public void createStore() {
        StorePojo storePojo = new StorePojo();

        storePojo.setName("Southall");
        storePojo.setType("Retail");
        storePojo.setAddress("Near");
        storePojo.setAddress2("Broadway");
        storePojo.setCity("Southall");
        storePojo.setState("Middlesex");
        storePojo.setZip("12345");
        storePojo.setLat(0);
        storePojo.setLng(0);
        storePojo.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");

        Response response = (Response) given()
                .headers("Content-Type","application/json")
                .body(storePojo)
                .when()
                .post("/stores");
        response.then().statusCode(201);
        response.prettyPrint();
    }
    //new product id creaded - 9999682
}
