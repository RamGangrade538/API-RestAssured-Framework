import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utiles.RestUtil;
import java.util.HashMap;



public class PostUsingPayload {
    @Test
    public void create_postRequest(){
    RestUtil util = new RestUtil();
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

    Response response  = util.postData(endPoint,payload,new HashMap<>());
        Assert.assertEquals(response.statusCode(),200);

    }

}
