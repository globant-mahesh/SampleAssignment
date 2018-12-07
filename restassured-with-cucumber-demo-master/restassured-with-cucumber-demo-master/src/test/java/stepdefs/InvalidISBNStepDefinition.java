package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by garth.combrinck on 2017/04/17.
 */
public class InvalidISBNStepDefinition {
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;

    private String ENDPOINT_GET_BOOK_BY_ISBN = "https://www.googleapis.com/books/v1/volumes";

    @Given("^a book does not exist with an isbn of (\\d+)$")
    public void aBookDoesNotExistWithAnIsbnOf(int isbn){
        request = given().param("q", "isbn:" + isbn);
    }

    @When("^a user tries to retrieve the book by isbn$")
    public void aUserTriesToRetrieveTheBookByIsbn(){
        response = request.when().get(ENDPOINT_GET_BOOK_BY_ISBN);
        System.out.println("response: " + response.prettyPrint());
    }

    @Then("^the error status code is (\\d+)$")
    public void theErrorStatusCodeIs(int statusCode){
            json = response.then().statusCode(statusCode);
    }

    @And("^response includes the following values$")
    public void responseIncludesTheFollowingValues(Map<String,String> responseFields){
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            if(StringUtils.isNumeric(field.getValue())){
                json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
            }
            else{
                json.body(field.getKey(), equalTo(field.getValue()));
            }
        }
    }
}
