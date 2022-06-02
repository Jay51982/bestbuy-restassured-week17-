package com.bestbuy.productinfo;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class ProductGetTest extends TestBase {

    @Test
    public void getAllPoductInfo() {
        Response response = given()
                .when()
                .get("/products");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleProductInfo() {
        Response response = given()
                .pathParam("id",127687) // path parameters go <-?
                .when()
                .get("/products/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void searchStudentWithParameter() {
        HashMap<String,Object> qParams = new HashMap<>();
        qParams.put("programme","Computer Science");
        qParams.put("limit",2);

        Response response = given()
//                .queryParam("programme","Computer Science")
//                .queryParam("limit",2)

                .queryParams(qParams)
                .when()
                .get("/list");
   response.then().statusCode(200);
       response.prettyPrint();

    }

}
