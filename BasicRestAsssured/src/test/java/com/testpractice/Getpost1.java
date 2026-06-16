package com.testpractice;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Getpost1 {
  @Test
  public void postpractice() {
	  Response res = RestAssured
              .given().pathParam("id",1)
  			  .when()
  			  .get("https://jsonplaceholder.typicode.com/posts/{id}");
	  System.out.println("Status code: " + res.getStatusCode()); 
      assertEquals(res.getStatusCode(), 200);
      assertEquals(res.jsonPath().getInt("id"),1);
      res.prettyPrint();
  }
}
