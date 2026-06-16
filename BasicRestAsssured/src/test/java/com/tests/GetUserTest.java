package com.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUserTest {

    @Test
    public void getUserTest() {

        Response response = RestAssured
                .given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users/1");

        System.out.println("Status code: " + response.getStatusCode());
        response.prettyPrint();
        assertEquals(response.getStatusCode(), 200);
        String name = response.jsonPath().getString("name");
        System.out.println("User Name: " + name);
        assertEquals(name, "Leanne Graham");
    }
}