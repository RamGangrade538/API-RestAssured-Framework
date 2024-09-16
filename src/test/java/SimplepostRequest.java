import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;


public class SimplepostRequest {
@Test
public void postRequest(){
    Response resp  =RestAssured.
            given()
            .header("Content-Type", "application/json")
            .body("{\n" +
                    "    \"_id\":\"252d3bca-d9bb-476c-9a97-562d685e235c\",\n" +
                    "    \"name\": \"Sri Lankan Airways\",\n" +
                    "    \"country\": \"Sri Lanka\",\n" +
                    "    \"logo\": \"https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png\",\n" +
                    "    \"slogan\": \"From Sri Lanka\",\n" +
                    "    \"head_quaters\": \"Katunayake, Sri Lanka\",\n" +
                    "    \"website\": \"www.srilankaaairways.com\",\n" +
                    "    \"established\": \"1990\"\n" +
                    "}")

            .post("https://api.instantwebtools.net/v1/airlines")
            .then()
            .assertThat()
            .statusCode(200)
            .log()
            .all()
            .extract()
            .response();
    //System.out.println(resp.prettyPrint());

}
}