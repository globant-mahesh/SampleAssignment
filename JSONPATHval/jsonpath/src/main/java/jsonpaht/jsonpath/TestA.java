import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DataUtil.Constants;
import DataUtil.GetJsonObject;
import DataUtil.Xls_Reader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;


public class TestA {
	GetJsonObject gso;
	RequestSpecification rept;
	static Xls_Reader read;

@BeforeTest()
public void BeforeAnyTest() {
	RestAssured.baseURI=Constants.BaseURI;

   rept=RestAssured.given();
	gso=new GetJsonObject(rept);
	read=new Xls_Reader(Constants.XLS_PATH);	
}

//GET Request
//@Test(dataProvider="GetData")
public void GetData(String name,String salary,String Age,String StatusCode){

 RequestSpecification rept=RestAssured.given();
 	 Response rep=rept.get("/employee/6286");
 	  //System.out.println("Response is "+rep.asString());
	
 	String h=rep.jsonPath().get("employee_name");
	
System.out.println("Employee name is "+h);

}


//POST request
//@Test(dataProvider="GetData")
public void CreateData(String name,String salary,String Age,String StatusCode) {
	
	
	gso.CreateJsonObject(name,salary,Age,StatusCode);

	

	
}


@DataProvider(name="GetData")
public static Object[][] getDatafrom(){
	
	//Xls_Reader read=new Xls_Reader("C:\\Users\\Sankalp_Puranik\\Desktop\\TestData.xlsx");
	
	int RowNum=read.getRowCount("RestData");
	int ColCount=read.getColumnCount("RestData");
	System.out.println("Column count is "+ColCount);
	Object arr[][]=new Object[RowNum-1][ColCount];
	for(int r=2;r<=RowNum;r++) {
	for(int i=0;i<ColCount;i++) {
	String data=read.getCellData("RestData", i, r);
	arr[r-2][i]=data;
	}
	}
return arr;
}


//PUT Request
//@Test(dataProvider="GetData")
public void UpdateData(String name,String salary,String Age,String StatusCode){
	
gso.UpdateBody(name, salary, Age);
 
	

	
}
}
