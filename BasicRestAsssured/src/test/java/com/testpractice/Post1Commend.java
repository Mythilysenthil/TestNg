package com.testpractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Post1Commend {
  @Test
  public void post1commend() {
	  RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
      Response res = RestAssured.given().queryParam("postId", 1)
                          .when().get("/comments");
      Assert.assertEquals(res.getStatusCode(), 200);
      System.out.println(res.asPrettyString());
  }
}
