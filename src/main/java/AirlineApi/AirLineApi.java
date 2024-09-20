package AirlineApi;

import Restutiles.RestUtil;
import base.BaseClass;
import freemarker.core.ReturnInstruction;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class AirLineApi {
    RestUtil util = new RestUtil();

    public Response createAirline(Map<String , Object> createAirlinepayload){
        String endPoint  = (String) BaseClass.datafromjsonfile.get("createairlineendpoint");
        return util.postDataHashMap(endPoint, createAirlinepayload, new HashMap<>());
    }
}
