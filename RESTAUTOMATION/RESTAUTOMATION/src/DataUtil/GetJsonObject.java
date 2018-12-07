package DataUtil;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GetJsonObject {

	
RequestSpecification request;
	
	 
	public GetJsonObject(RequestSpecification request) {
		this.request=request;
	}
	
 // public final int HTTP_OK=200;

  public static void main(String args[]) {
	  
	  
	  
	  
  }

	public void CreateJsonObject(String name, String salary, String age2, String statusCode2) {
		
		
		JSONObject j = createBody(name,salary,age2);
		request.header("Content-Type", "application/json");
		request.body(j.toJSONString());
		
			    
	    //validating post request
	    Response response=request.post("/create");
	    int statuscode1=response.getStatusCode();
	    Assert.assertEquals(statuscode1, Constants.HTTP_OK);
		System.out.println("Response from the server is :" +response.asString());
	    
	
		//validating the status code from xls
		//int statuscode=response.getStatusCode();
		//int statuscode1=Integer.parseInt(statusCode2);
		//Assert.assertEquals(statuscode, statuscode1);
		
    //validating SuccessCode text in response
		
		
		String name1=response.jsonPath().get("name");
		System.out.println("Updated name is "+name1);
		
		
	
		
		
		
	}


	private JSONObject createBody(String name,String salary,String Age) {
		JSONObject j=new JSONObject();
		j.put("name", name);
		j.put("salary", salary);
		j.put("age", Age);
		
		return j;
	}
	
	
		public JSONObject UpdateBody(String name,String salary,String Age){
						
			JSONObject h=new JSONObject();
			h.put("name", name);
			h.put("Salary", salary);
			h.put("age", Age);
			
			//RequestSpecification request=RestAssured.given();	
			request.header("Content-Type", "application/json");
			request.body(h.toJSONString());
			
			Response resp=request.put("/update/6286");
		    int statuscode=resp.getStatusCode();
		    Assert.assertEquals(statuscode, Constants.HTTP_OK);
			
		    String age=resp.jsonPath().get("name");
			System.out.println("Updated name is "+age);
			
			return h;
			
		}

		
		
	
	
		
		
	
}
