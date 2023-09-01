package steps;

import java.io.File;


import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinition extends common {

	
	@Given("Set Base URI")
	public void setbase() {
		RestAssured.baseURI="https://esk55.atlassian.net/rest/api/2";
	}
	
	@And ("Set Auth")
	public void setAuth() {
		RestAssured.authentication=RestAssured.preemptive().basic("eswark.test@gmail.com", "ATATT3xFfGF0ISYiN4ZjFSJdySmwkfVh-6o6QI2a0Gkln4wapD2mVv9_NxRdc4TdFXOyoUINFW5CzrkXhxI6bHxXvajnl7lclaO5QqjpYFvPLgQkZ2BOVGDQaNlQRoeOU9WMxpHJXFTmayR90a-Ac-khWZ41SHxIMIcVpX61kehhk_IrmGgvhSc=CA9232B9");
	}
	
	@When("create issue")
	public void createissuewithfile() {
		
		File file= new File("C:/Users/KathirNimi/Desktop/Testing/RESTAPI_course_Testleaf/Restassured/JiraMatchieAssign/src/test/resources/JiraPost.json");
		input=RestAssured.given().contentType("application/json").when().body(file);
		response=input.post("/issue");
		response.prettyPrint();
		sys_id=response.jsonPath().get("id");
		System.out.println("the id number is----------"+" "+ sys_id);
		
	}
	
	@Then ("Validate response code as {int}")
	public void validateresponse(int statuscode) {
		response.then().assertThat().statusCode(statuscode);
	}
	
	
	@When ("update the issue")
	public void updatewithid() {
		File file1= new File("C:/Users/KathirNimi/Desktop/Testing/RESTAPI_course_Testleaf/Restassured/JiraMatchieAssign/src/test/resources/JiraPut.json");
		input=RestAssured.given().contentType("application/json").when().body(file1);
		response=input.put("/issue/"+sys_id);
	}
	
	
	@When("delete the issue with id")
	public void deletewithid() {
		
		RestAssured.given().delete("/issue/"+sys_id);
		
	}
	
	
	
	
	
	
	
}
