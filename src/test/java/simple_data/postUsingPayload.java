package simple_data;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import Restutiles.RestUtil;
import java.util.HashMap;
import java.util.Map;
import static org.testng.Assert.assertEquals;
public class postUsingPayload {

    RestUtil util = new RestUtil();

    @Test
    public void create_postRequest() {

        String endPoint = "https://api.instantwebtools.net/v1/airlines";
        String payload = "{\n" +
                "    \"_id\":\"252d3bca-d9bb-476c-9a97-562d685e235c\",\n" +
                "    \"name\": \"Sri Lankan Airways\",\n" +
                "    \"country\": \"Sri Lanka\",\n" +
                "    \"logo\": \"https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png\",\n" +
                "    \"slogan\": \"From Sri Lanka\",\n" +
                "    \"head_quaters\": \"Katunayake, Sri Lanka\",\n" +
                "    \"website\": \"www.srilankaaairways.com\",\n" +
                "    \"established\": \"1990\"\n" +
                "}";
        System.out.println("Payload: " + payload);
        Response response = util.postData(endPoint, payload, new HashMap<>());
        assertEquals(response.statusCode(), 200);

    }

    //String
    @Test
    public void createPostRequestWithString() {
        RestUtil util = new RestUtil();
        String endPoint = "https://api.instantwebtools.net/v1/airlines";
        String payload = util.createPayloadString(
                "252d3bca-d9bb-476c-9a97-562d685e235c",
                "Sri Lankan Airways",
                "Sri Lanka",
                "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",  // Logo
                "From Sri Lanka",
                "Katunayake, Sri Lanka",
                "www.srilankaaairways.com",
                "1990");
        Response response = util.postData(endPoint, payload, new HashMap<>());
        System.out.println(response.getBody().asString());
        assertEquals(200, response.getStatusCode());  // Adjust based on expected status code
    }
    //Hashmap
    @Test
    public void createPostRequestWithHashMap() {
        RestUtil util = new RestUtil();
        String endPoint = "https://api.instantwebtools.net/v1/airlines";
        Map<String, Object> payload = util.createPayloadHashMap(
                "252d3bca-d9bb-476c-9a97-562d685e235c",
                "Sri Lankan Airways",
                "Sri Lanka",
                "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",  // Logo
                "From Sri Lanka",
                "Katunayake, Sri Lanka",
                "www.srilankaaairways.com",
                "1990");
        Response response = util.postDataHashMap(endPoint, payload, new HashMap<>());
        System.out.println(response.getBody().asString());
        assertEquals(200, response.getStatusCode());
    }
}