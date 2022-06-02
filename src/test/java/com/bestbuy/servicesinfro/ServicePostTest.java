package com.bestbuy.servicesinfro;

//import com.bestbuy.Model.ServicesPojo;
import com.bestbuy.model.ServicesPojo;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServicePostTest extends TestBase {
    @Test
    public void createServicesTest() {
        ServicesPojo servicesPojo = new ServicesPojo();

        servicesPojo.setName("Steve Jobs");
        Response response = given()
                .header("Content-Type", "application/json")
                .body(servicesPojo)
                .when()
                .post("/services");
        response.then().statusCode(201);
        response.prettyPrint();

    }


}
