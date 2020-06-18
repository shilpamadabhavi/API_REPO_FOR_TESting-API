package com.rest.restassuredapi;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
public class Test_case1 {

	
	@Test
	public void test() {
		//1.Approach
//		given().get("http://localhost:8080/student/list")
//		.then().assertThat().statusCode(equalTo(200));
		
		
		//2.Second approach
//		given().baseUri("http://localhost:8080").and().basePath("/student")
//		.when().get("/list")
//		.then().assertThat().statusCode(equalTo(200))
//		.and().assertThat().time(lessThan(4000L));
		
		
		//3.Approach
		baseURI="http://localhost:8080";
		basePath="/student";
		
		given()
		.when().get("/list")
		.then().assertThat().and().statusCode(equalTo(200))
		.and().header("Content-Type", "application/json;charset=UTF-8")
		.body("[0].firstName", equalTo("Vernon"));
		
		
		
		 JsonPath jp = given().when().get("/list").jsonPath();
		 String name = jp.get("[6].firstName");
		 System.out.println(name);
		 
		  List<String> course = jp.get("[6].courses");
		  System.out.println(course.get(0)+""+course.get(1)+""+course.get(2));
		 List<String> list = jp.getList("[6].courses");
		
	}
}
