import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import DataUtil.Constants;
import DataUtil.GetJsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ArraysWithJSONParser {
	GetJsonObject gso;
	RequestSpecification rept;
	//static Xls_Reader read;

@BeforeTest()
public void BeforeAnyTest() {
	RestAssured.baseURI="https://jsonplaceholder.typicode.com";

   rept=RestAssured.given();
	gso=new GetJsonObject(rept);
	//read=new Xls_Reader(Constants.XLS_PATH);	
}
	
	
@Test
public void Test1(){
	Response resp=rept.get("/users");
//System.out.println(resp.asString());
	
	//Print size of List containing response
	
	List<String> ResponseSize=resp.jsonPath().getList("$");
	//System.out.println("Total size is "+ResponseSize.size());
	
	
	//print all the usernames in arrays
	List<String> usernames=resp.jsonPath().getList("username");
	//System.out.println(usernames);
	//System.out.println(usernames.get(0));
	//print username of first entry
	String username=resp.jsonPath().getString("username[0]");
	//System.out.println(username);
	
	
	String lat=resp.jsonPath().getString("address[0].geo.lat");
	String zipcode=resp.jsonPath().getString("address[9].zipcode");
	//System.out.println(zipcode);
	
	
	String phone=resp.jsonPath().getString("phone[6]");
	System.out.println(phone);
	//Map<String,String> mp=resp.jsonPath().getMap("phone[6]");
	//System.out.println(mp.get("phone[6]"));
}
}
