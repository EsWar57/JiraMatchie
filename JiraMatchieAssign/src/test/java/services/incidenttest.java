package services;

import static org.hamcrest.Matchers.containsString;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class incidenttest extends Baserequest{
	
	@Test
	public void getIncident() {
		RestAssured.given().contentType("application/json").when().body(new File("./src/test/resources/JiraPost.json") )
		.post("/issue").then().assertThat().statusCode(201).body(Matchers.containsString("number"), containsString("sys_id"));
	}

}
