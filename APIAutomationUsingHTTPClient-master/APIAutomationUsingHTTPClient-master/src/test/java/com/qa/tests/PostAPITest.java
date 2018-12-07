package com.qa.tests;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.data.Users;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONObject;
import org.json.simple.parser.*;


public class PostAPITest extends TestBase{
	TestBase testBase;
	String serviceUrl;
	String apiUrl;
	String url;
	RestClient restClient;
	CloseableHttpResponse closebaleHttpResponse;
	
	
	public static JSONObject jsonReq;
	//public static JSONObject json=jsonReq;
	public static JSONParser parser = new JSONParser();
	
	//public static RequestSpecification httpRequest;
	public static Response response;
	
	
	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException{
		testBase = new TestBase();
		serviceUrl = prop.getProperty("URL");
		apiUrl = prop.getProperty("serviceURL");
		//https://reqres.in/api/users
		
		url = serviceUrl + apiUrl;
		
	}
	
	
	@Test
	public void postAPITest() throws JsonGenerationException, JsonMappingException, IOException, ParseException{
		restClient = new RestClient();
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		
		/*//jackson API:
		ObjectMapper mapper = new ObjectMapper();
		Users users = new Users("morpheus", "leader"); //expected users obejct
		
		//object to json file:
		mapper.writeValue(new File("C:/Users/Thiyaneswaran_Manoha/eclipse-workspace/APIAutomationUsingHTTPClient-master/APIAutomationUsingHTTPClient-master/src/main/java/com/qa/data/users.json"), users);
		
		//java object to json in String:
		String usersJsonString = mapper.writeValueAsString(users);
		System.out.println(usersJsonString);
*/		
		//closebaleHttpResponse = restClient.post(url, usersJsonString, headerMap); //call the API
		
		//validate response from API:
		//1. status code:
		/*int statusCode = closebaleHttpResponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statusCode, testBase.RESPONSE_STATUS_CODE_201);
		
		//2. JsonString:
		String responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");
		
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("The response from API is:"+ responseJson);
		
		//json to java object:
		Users usersResObj = mapper.readValue(responseString, Users.class); //actual users object
		System.out.println(usersResObj);
		
		Assert.assertTrue(users.getName().equals(usersResObj.getName()));
		
		Assert.assertTrue(users.getJob().equals(usersResObj.getJob()));
		
		System.out.println(usersResObj.getId());
		System.out.println(usersResObj.getCreatedAt());
		
		
		
	*/	
	
		FileReader reader=new FileReader(new File("C:/Users/Thiyaneswaran_Manoha/eclipse-workspace/APIAutomationUsingHTTPClient-master/APIAutomationUsingHTTPClient-master/src/main/java/com/qa/data/users.json"));
		jsonReq = (JSONObject) parser.parse(reader);
		System.out.println(jsonReq);
		
		JSONObject json=jsonReq;
		
		JsonPath.parse(json).set("$.name","morpheus");
		JsonPath.parse(json).set("$.job","leader");
		JsonPath.parse(json).set("$.id","1234");
		JsonPath.parse(json).set("$.createdAt","cbe");
		
		System.out.println(json);
		RestAssured.useRelaxedHTTPSValidation();
		
		
		RestAssured.baseURI = "https://reqres.in/api";
		
		//RequestSpecification httpRequest=RestAssured.given().auth().preemptive().basic("test", "test");
		
		RequestSpecification httpRequest=RestAssured.given();
		
		httpRequest.header("Content-Type", "application/json");
		/*httpRequest.queryParam("key", "value");
		httpRequest.queryParam("token", "value");
		httpRequest.queryParam("name", "value");*/
		
		
		
		response=httpRequest.request(Method.POST,"/users");
		
		System.out.println(response);
		
		System.out.println(response.getStatusCode());
		
		System.out.println(response.getBody().asString());
		
		//String resp1=response.getBody().asString();
		System.out.println(response.getBody().prettyPrint());
		
		
	}
	
	
	
	
	
	
	

}
