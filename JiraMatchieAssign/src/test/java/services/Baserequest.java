package services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class Baserequest {

	@BeforeSuite
	public void setup() throws FileNotFoundException, IOException {
		Properties prop= new Properties();
		prop.load(new FileInputStream(new File("./src/test/resources/config.properties")));
		
		RestAssured.baseURI= "https://"+prop.getProperty("server")+"/"+prop.getProperty("resources")+"/";
		RestAssured.authentication=RestAssured.basic(prop.getProperty("username"), prop.getProperty("password"));	
			
			
	}
}
