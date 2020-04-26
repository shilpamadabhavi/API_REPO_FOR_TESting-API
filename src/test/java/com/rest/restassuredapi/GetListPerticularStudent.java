package com.rest.restassuredapi;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class GetListPerticularStudent {

	@Test
	public void Test_case1() {
		baseURI="http://localhost:8080";
		basePath="/student";//common in every endpoint
//		given().get("http://localhost:8080/student/100")
		given()
		.when().get("/100")
		.then().assertThat().statusCode(200).body("firstName",equalTo("Oscar"));
	}
	
	
	@Test
	public void getStudent_Using_Filter() {
//		http://localhost:8080/student/list/?programme=Mechanical Engineering
		
		baseURI = "http://localhost:8080";
		basePath = "/student";
		
		given().param("programme", "Mechanical Engineering")
		.when().get("/list")
		.then().and().statusCode(200).and()
		.body("programme",equalTo("Mechanical Engineering"));
		
		
	}
}
