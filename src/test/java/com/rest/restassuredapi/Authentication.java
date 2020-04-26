package com.rest.restassuredapi;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



public class Authentication {
//	@Test
//	public void basicAuth() {
//		baseURI = "https://api.github.com";
//		basePath = "/user";
//		
//		given().auth().preemptive().basic("shilpamadabhavi", "appayyaa123")
//		.when().get("/repos")
//		.then().assertThat().statusCode(200).time(lessThan(5000L));
//		
//	}
	
	@Test
	public void bearer_Token() {
		
		baseURI = "https://api.github.com";
		basePath = "/user";
		
		given().auth().oauth2("78bb8875bf2b670776ae496e7ee7af45a97f047b")
		.when().get("/repos")
		.then().statusCode(200);
	}
	

}
