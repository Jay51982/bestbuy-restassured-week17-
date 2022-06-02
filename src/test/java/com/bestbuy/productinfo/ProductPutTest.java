package com.bestbuy.productinfo;
import com.bestbuy.model.ProductPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import com.bestbuy.model.ProductPojo;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;
/*
 *  Created by Jay
 */
public class ProductPutTest extends TestBase {
    @Test
    public void updateProductWithPatch(){
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
            .header("Content-Type", "application/json")
                .pathParam("id", 9999682)
                .body(productPojo)
                .when()
                .put("/products/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }

}
