import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Backup {

	public static void main(String[] args) {
		//https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22
		RestAssured.baseURI="https://samples.openweathermap.org/data/2.5/weather";
		
		given().
		param("q","London,uk").param("appid","b6907d289e10d714a6e88b30761fae22").param("appid","b6907d289e10d714a6e88b30761fae22").

		when().
		get("https://samples.openweathermap.org/data/2.5/weather").then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("sys.country", equalTo("GB"));
		
		
		given().
		param("q","London,uk").param("appid","b6907d289e10d714a6e88b30761fae22").

		when().
		get("https://samples.openweathermap.org/data/2.5/weather").then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().body("weather[0].description", equalTo("light intensity drizzle"));

	}

}
