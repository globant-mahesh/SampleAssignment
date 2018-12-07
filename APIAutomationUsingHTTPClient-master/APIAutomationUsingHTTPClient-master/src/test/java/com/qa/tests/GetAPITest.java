package com.qa.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.util.TestUtil;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GetAPITest extends TestBase{
	TestBase testBase;
	String serviceUrl;
	String apiUrl;
	String url;
	RestClient restClient;
	CloseableHttpResponse closebaleHttpResponse;
	public static Response response;
	
	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException{
		testBase = new TestBase();
		serviceUrl = prop.getProperty("URL");
		apiUrl = prop.getProperty("serviceURL");
		//https://reqres.in/api/users
		
		//url = serviceUrl + apiUrl;
		url = "https://jsonplaceholder.typicode.com/users";
		
	}
	
	
	
	@Test(priority=1)
	public void getAPITestWithoutHeaders() throws ClientProtocolException, IOException{
		
       RestAssured.useRelaxedHTTPSValidation();
		
		
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
		
		//RequestSpecification httpRequest=RestAssured.given().auth().preemptive().basic("test", "test");
		
		RequestSpecification httpRequest=RestAssured.given();
		
		httpRequest.header("Content-Type", "application/json");

response=httpRequest.request(Method.GET,"/users");
		
		System.out.println(response);
		
		System.out.println(response.getStatusCode());
		
		System.out.println(response.getBody().asString());
		
		
		//Print size of List containing response
		
		List<String> ResponseSize=response.jsonPath().getList("$");
		System.out.println("Total size is "+ResponseSize.size());
		System.out.println(ResponseSize);
		
		//print all the usernames in arrays
		List<String> usernames=response.jsonPath().getList("username");
		System.out.println(usernames);
		System.out.println(usernames.get(0));
		//print username of first entry
		String username=response.jsonPath().getString("username[0]");
		System.out.println(username);
		
		
		String lat=response.jsonPath().getString("address[0].geo.lat");
		System.out.println(lat);
		String zipcode=response.jsonPath().getString("address[9].zipcode");
		System.out.println(zipcode);
		
		
		String phone=response.jsonPath().getString("phone[6]");
		System.out.println(phone);
		
		List<String> addresslat=response.jsonPath().getList("address.geo.lat");
		System.out.println(addresslat);
		
		//Map<String,String> mp=resp.jsonPath().getMap("phone[6]");
		//System.out.println(mp.get("phone[6]"));

		
		//restClient = new RestClient();
		//closebaleHttpResponse = restClient.get(url);
		
		
		
	/*	//a. Status Code:
		int statusCode = closebaleHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code--->"+ statusCode);
		
		Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "Status code is not 200");

		//b. Json String:
		String responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");
*/		
		/*JSONObject responseJson = new JSONObject(responseString);
		System.out.println("Response JSON from API---> "+ responseJson);
		
		//single value assertion:
		//per_page:
		String perPageValue = TestUtil.getValueByJPath(responseJson, "/per_page");
		System.out.println("value of per page is-->"+ perPageValue);
		Assert.assertEquals(Integer.parseInt(perPageValue), 3);
		
		//total:
		String totalValue = TestUtil.getValueByJPath(responseJson, "/total");
		System.out.println("value of total is-->"+ totalValue);		
		Assert.assertEquals(Integer.parseInt(totalValue), 12);

		//get the value from JSON ARRAY:
		String lastName = TestUtil.getValueByJPath(responseJson, "/data[0]/last_name");
		String id = TestUtil.getValueByJPath(responseJson, "/data[0]/id");
		String avatar = TestUtil.getValueByJPath(responseJson, "/data[0]/avatar");
		String firstName = TestUtil.getValueByJPath(responseJson, "/data[0]/first_name");

		System.out.println(lastName);
		System.out.println(id);
		System.out.println(avatar);
		System.out.println(firstName);
		
		
		//c. All Headers
		Header[] headersArray =  closebaleHttpResponse.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();	
		for(Header header : headersArray){
			allHeaders.put(header.getName(), header.getValue());
		}	
		System.out.println("Headers Array-->"+allHeaders);
		
*/		
		
	}
	
	
	
	/*@Test(priority=2)
	public void getAPITestWithHeaders() throws ClientProtocolException, IOException{
		restClient = new RestClient();
		
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
//		headerMap.put("username", "test@amazon.com");
//		headerMap.put("password", "test213");
//		headerMap.put("Auth Token", "12345");

		
		closebaleHttpResponse = restClient.get(url,headerMap);
		
		//a. Status Code:
		int statusCode = closebaleHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code--->"+ statusCode);
		
		Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "Status code is not 200");

		//b. Json String:
		String responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(), "UTF-8");
		
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("Response JSON from API---> "+ responseJson);
		
		//single value assertion:
		//per_page:
		String perPageValue = TestUtil.getValueByJPath(responseJson, "/per_page");
		System.out.println("value of per page is-->"+ perPageValue);
		Assert.assertEquals(Integer.parseInt(perPageValue), 3);
		
		//total:
		String totalValue = TestUtil.getValueByJPath(responseJson, "/total");
		System.out.println("value of total is-->"+ totalValue);		
		Assert.assertEquals(Integer.parseInt(totalValue), 12);

		//get the value from JSON ARRAY:
		String lastName = TestUtil.getValueByJPath(responseJson, "/data[0]/last_name");
		String id = TestUtil.getValueByJPath(responseJson, "/data[0]/id");
		String avatar = TestUtil.getValueByJPath(responseJson, "/data[0]/avatar");
		String firstName = TestUtil.getValueByJPath(responseJson, "/data[0]/first_name");

		System.out.println(lastName);
		System.out.println(id);
		System.out.println(avatar);
		System.out.println(firstName);
		
		
		//c. All Headers
		Header[] headersArray =  closebaleHttpResponse.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();	
		for(Header header : headersArray){
			allHeaders.put(header.getName(), header.getValue());
		}	
		System.out.println("Headers Array-->"+allHeaders);
		
		
		
	}
*/	
	
	
	
	
	
	
	
	
	
	
	

}
