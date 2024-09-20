package Test;

import AirlineApi.AirLineApi;
import Restutiles.RestUtil;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Map;

public class CreateAirline_Test_class extends AirLineApi {
        RestUtil util = new RestUtil();
        @Test
        public void createAirlineTest() throws IOException {
            Map<String, Object> payload = util.createPayloadHashMap(
                    "252d3bca-d9bb-476c-9a97-562d685e235c",
                    "Sri Lankan Airways",
                    "Sri Lanka",
                    "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png", // Logo
                    "From Sri Lanka",
                    "Katunayake, Sri Lanka",
                    "www.srilankaaairways.com",
                    "1990"
            );
            Response response = createAirline(payload);
            //System.out.println(response.getBody().asString());
        }
    }
