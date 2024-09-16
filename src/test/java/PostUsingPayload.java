import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utiles.RestUtil;
import java.util.HashMap;
import java.util.Map;


public class PostUsingPayload {

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
        Assert.assertEquals(response.statusCode(), 200);

    }

    @Test
    public void create_postRequestString() {
        RestUtil util = new RestUtil();
        String endPoint = "https://api.instantwebtools.net/v1/airlines";
        String payload = util.postDataString("252d3bca-d9bb-476c-9a97-562d685e235c", "Sri Lankan Airways",
                "Sri Lanka",
                "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
                "From Sri Lanka",
                "Katunayake, Sri Lanka",
                "www.srilankaaairways.com",
                "1990");

        Response response = util.postData(endPoint, payload, new HashMap<>());
        System.out.println(response.getBody().asString());

    }

    @Test
    public void create_postRequestHashMap() {
        RestUtil util = new RestUtil();
        String endPoint = "https://api.instantwebtools.net/v1/airlines";
        Map<String,Object>  payload = util.createpayloadHashmap("252d3bca-d9bb-476c-9a97-562d685e235c", "Sri Lankan Airways",
                "Sri Lanka",
                "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png",
                "From Sri Lanka",
                "Katunayake, Sri Lanka",
                "www.srilankaaairways.com",
                "1990");

        Response response = util.postData(endPoint, payload<String Object>(), new HashMap<>());
        System.out.println(response.getBody().asString());

    }

}