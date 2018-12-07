package services;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;

import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import org.apache.http.HttpStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import services.lib.TestLinkUtils;


public class BookTests extends TestLinkUtils{
    private static String ENDPOINT_GET_BOOK_BY_ISBN = "https://www.googleapis.com/books/v1/volumes";

    @Test
    public void testGetByISBN() throws Exception {
        setTestCaseId("TST-1");
        setDescription("This is the description 1");
        try {
            String isbn = "isbn:9781451648546";
            given().
                    param("q", isbn).
                    when().
                    get(ENDPOINT_GET_BOOK_BY_ISBN).
                    then().
                    statusCode(HttpStatus.SC_OK).
                    body("totalItems", equalTo(1),
                            "kind", equalTo("books#volumes"),
                            "items.volumeInfo.title", containsInAnyOrder("Steve Jobs"),
                            "items.selfLink", containsInAnyOrder("https://www.googleapis.com/books/v1/volumes/8U2oAAAAQBAJ"),
                            "items.volumeInfo.authors", containsInAnyOrder((Object) Arrays.asList("Walter Isaacson")),
                            "items.volumeInfo.publisher", containsInAnyOrder("Simon and Schuster"),
                            "items.volumeInfo.pageCount", containsInAnyOrder(630),
                            "items.volumeInfo.imageLinks.smallThumbnail", containsInAnyOrder("http://books.google.com/books/content?id=8U2oAAAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api"),
                            "items.volumeInfo.industryIdentifiers.type",containsInAnyOrder((Object) Arrays.asList("[ISBN_13, ISBN_10]"))
                            );
            setResult(ExecutionStatus.PASSED);
        }catch (Exception e){
            setResult(ExecutionStatus.FAILED);
            throw new Exception(e);
        }
    }
    @Test
    public void testGetByI() throws Exception {
        setTestCaseId("TST-2");
        setDescription("This is the description 2");
        try {
            String isbn = "isbn:9781451648546";
            given().
                    param("q", isbn).
                    when().
                    get(ENDPOINT_GET_BOOK_BY_ISBN).
                    then().
                    statusCode(HttpStatus.SC_OK).
                    body("totalItems", equalTo(1),
                            "kind", equalTo("books#volumes"),
                            "items.volumeInfo.title", containsInAnyOrder("Steve Jobs"),
                            "items.volumeInfo.authors", containsInAnyOrder((Object) Arrays.asList("Walter Isaacson")),
                            "items.volumeInfo.publisher", containsInAnyOrder("Simon and Schuster"),
                            "items.volumeInfo.pageCount", containsInAnyOrder(630));
            setResult(ExecutionStatus.PASSED);
        }catch (Exception e){
            setResult(ExecutionStatus.FAILED);
            throw new Exception(e);
        }
    }

}
