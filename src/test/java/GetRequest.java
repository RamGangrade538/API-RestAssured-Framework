import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetRequest {
    @Test
    public void getRequest() {
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .when()
                .get("https://api.instantwebtools.net/v1/airlines")
                .then()
                .assertThat()
                .statusCode(200)  // Assert that status code is 200 (OK)
                .extract()  // Extract the response
                .response();

        System.out.println((response.prettyPrint()));
        //System.out.println((response.getBody().asString()));
    }
}
