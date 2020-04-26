package com.rest.restassuredapi;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;

public class Update_using_Put {

	@Test
	public void test1() {
		baseURI = "http://localhost:8080";
		basePath = "/student";
		
//		  Response resp = given().contentType(ContentType.JSON).body(new File("E:\\shilpaFRAMEWORK\\shilpa\\NAVINAUTOMATIONfeb2020course\\Myworkspaceimp\\TYSS_API_RestassuredFW\\src\\test\\resources\\body_put.json"))
//		.when().put("/100");
//		 ValidatableResponse varification = resp.then().body("msg", equalTo("Student Updated"));
//		System.out.println(varification);
//		System.out.println(resp.getBody().asString());
		given().contentType(ContentType.JSON).body(new File("E:\\shilpaFRAMEWORK\\shilpa\\NAVINAUTOMATIONfeb2020course\\Myworkspaceimp\\TYSS_API_RestassuredFW\\src\\test\\resources\\body_put.json"))
		.when().put("/10")
		.then().statusCode(200).body("msg", equalTo("Student Updated"));
		
	}
	@Test
	public void update_Using_Patch() {
		baseURI = "http://localhost:8080";
		basePath = "/student";
		
		Response response = given().contentType(ContentType.JSON).body("{\r\n" + 
				"        \r\n" + 
				"        \"email\": \"Vijay666@gmail.com\"\r\n" + 
				"     \r\n" + 
				" }")
		.when().patch("/12");
		 int statusCode = response.getStatusCode();
		 Assert.assertEquals(200, statusCode);
		   String body = response.getBody().jsonPath().get("msg");
		  
		  Assert.assertEquals("Updated", body);
		 
	}
	
	
}
