package com.bestbuy.productinfo;

import com.bestbuy.model.ProductPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;


/*
 *  Created by Jay
 */
public class ProductPostTest extends TestBase {

    @Test
    public void createProudct() {
        ProductPojo productPojo = new ProductPojo();
        productPojo.setName("Rechargeable Battery");
        productPojo.setType("Hardgoods");
        productPojo.setPrice(4);
        productPojo.setShipping(0);
        productPojo.setUpc("123");
        productPojo.setDescription("1000 rechargeable");
        productPojo.setManufacturer("Energizer");
        productPojo.setModel("AAA");
        productPojo.setUrl("string");
        productPojo.setImage("AAA.jpg");

        Response response = (Response) given()
                .headers("Content-Type","application/json")

                .body(productPojo)
                .when()
                .post("/products");
        response.then().statusCode(201);
response.prettyPrint();
    }
    //new product id creaded - 9999682
}
