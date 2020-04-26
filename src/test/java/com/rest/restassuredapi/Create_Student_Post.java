package com.rest.restassuredapi;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
public class Create_Student_Post {
	
	@Test
	public void test1() {
		
		 baseURI = "http://localhost:8080";
		 basePath = "/student";
		
		given().contentType(ContentType.JSON).body("{\r\n" + 
				"    \"firstName\": \"Vinay\",\r\n" + 
				"    \"lastName\": \"Choudry\",\r\n" + 
				"    \"email\": \"Vk@gmail.com\",\r\n" + 
				"    \"programme\": \"Computer Science\",\r\n" + 
				"    \"courses\": [\r\n" + 
				"        \"JAVA\"\r\n" + 
				"    ]\r\n" + 
				"}")
		.when().post("/")
		.then().time(lessThan(10L), TimeUnit.SECONDS).statusCode(201);
	}
	
	
	@Test
	public void test2() {
		
		given().contentType(ContentType.JSON).body("{\r\n" + 
				"    \"firstName\": \"Vinay\",\r\n" + 
				"    \"lastName\": \"Choudry\",\r\n" + 
				"    \"email\": \"kkk@gmail.com\",\r\n" + 
				"    \"programme\": \"Computer Science\",\r\n" + 
				"    \"courses\": [\r\n" + 
				"        \"JAVA\"\r\n" + 
				"    ]\r\n" + 
				"}")
		.post("http://localhost:8080/student/")
		.then().statusCode(201).time(lessThan(1000L));
		
	}
	
	
	@Test
	public void test3() {
		baseURI = "http://localhost:8080";
		 basePath = "/student";
		 
		 given().contentType(ContentType.JSON).body(new File("E:\\shilpaFRAMEWORK\\shilpa\\NAVINAUTOMATIONfeb2020course\\Myworkspaceimp\\TYSS_API_RestassuredFW\\src\\test\\resources\\body_post.json"))
		 .when().post("/")
		 .then().statusCode(201).body("msg", equalTo("Student added"));
	
	}
	
	@Test
	public void test4() {
		
		baseURI = "http://localhost:8080";
		basePath = "/student";
		
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("programme", "Computer Science");
		JsonPath jp = given().params(hm)
		.when().get("/list").jsonPath();
		
		
	}
}
