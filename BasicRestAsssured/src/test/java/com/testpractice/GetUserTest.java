package com.testpractice;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUserTest {
	@Test
    public void getusertest() {
		Response res = RestAssured
                .given()
    			.when()
    			.get("https://jsonplaceholder.typicode.com/posts");
		System.out.println("Status code: " + res.getStatusCode());
		res.prettyPrint();
        assertEquals(res.getStatusCode(), 200);
        System.out.println(res.getHeader("content-Type"));
  	    System.out.println(res.getHeaders());
    }   
}
