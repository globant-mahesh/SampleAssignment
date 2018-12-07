package tests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import util.ExcelUtil;

@Listeners(listener.APIListener.class)
public class SampleTest {

    private RequestSpecification httpRequest;

    @BeforeTest
    public void setUp() {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        httpRequest = RestAssured.given();
    }

    @Test(invocationCount = 3)
    public void getAllEmployeeDetails() {
        Response response = httpRequest.request(Method.GET, "/employees");
        String responseBody = response.getBody().asString();
        System.out.println("Fetching all the employee details -  " + responseBody);
    }

    @Test(dependsOnMethods = {"setEmployeeDetails"})
    public void getEmployeeDetails(ITestContext context) {
        int id = Integer.parseInt((String)context.getAttribute("id"));
        Response response = httpRequest.request(Method.GET,"/employee/" +id);
        String responseBody = response.getBody().asString();
        System.out.println("Details of the employee with id " +id+ " in JSON format are " +responseBody);
    }


    @Test(dataProvider = "getEmployeeData")
    public void setEmployeeDetails(ITestContext context,String uName, String uSalary, String uAge) {
        JSONObject requestParam = new JSONObject();
        requestParam.put("name",uName);
        requestParam.put("salary",uSalary);
        requestParam.put("age",uAge);

        RequestSpecification httpRequest = RestAssured.given().header("Content-Type","application/json").body(requestParam.toJSONString());
        Response response = httpRequest.post("/create");

        JsonPath evaluator = response.jsonPath();
        String id = evaluator.get("id");
        context.setAttribute("id",id); //Sharing the id across required tests to fetch the data of desired employee

        System.out.println("Id generated is  " +id);
        System.out.println("Employee details are added - " +response.getBody().asString());
    }


    @DataProvider
    public Object[][] getEmployeeData() throws Exception {
        return ExcelUtil.getData();
    }
}
