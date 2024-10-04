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
            Map<String, Object> payload = util.createPayloadHashMap();
            Response response = createAirline(payload);
        }
    }
