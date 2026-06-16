package com.testpractice;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutPost1Test {
  @Test
  public void putpost() {
	  Map<String, Object> payload = new HashMap<>();
	  payload.put("userId", 1);
	  payload.put("id",1);
	  payload.put("title","updated title");
	  payload.put("body","updated body");
	  
	  Response res = RestAssured
	            .given()
	            .contentType(ContentType.JSON)
	            .pathParam("id", 1)
	            .body(payload)
	            .when()
	            .put("https://jsonplaceholder.typicode.com/posts/{id}");

	    System.out.println("PUT Status Code: " + res.getStatusCode());
	    res.prettyPrint();
	    assertEquals(res.getStatusCode(), 200);
	    assertEquals(res.jsonPath().getString("title"), "Updated Title");
  }
}
