import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
public class ResponsebuilderUtility {

	ResponseSpecBuilder resbuild=new ResponseSpecBuilder();
	ResponseSpecification response_200_OK=resbuild.expectContentType(ContentType.JSON)
	.expectStatusCode(200)
	.build();
	
	ResponseSpecification response_401_unautharized=resbuild.expectContentType(ContentType.JSON)
			.expectStatusCode(401)
			.build();
	@Test
	public void responseSpecExample() {
		
		RestAssured.given()
		.when()
			.get("")
		.then()
			.assertThat()
				.spec(response_200_OK);
		
		
		/*
		 * This is very good utility u can use this in your work it will reduced number of lines of codes
		 */
		
		
		
	}
}
