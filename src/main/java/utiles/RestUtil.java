package utiles;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class RestUtil {
    public Response postData(String endPoint , String payload, Map<String ,String> headers){
        return RestAssured.given()
                        .baseUri(endPoint)
                        .headers(headers)
                .body(payload)

                .post()
                .then()
                .log()
                .all()
                .extract()
                .response();



    }
    public String postDataString(String id, String name, String country, String logo,
                                 String slogan, String head_quarters, String website, String established) {
        String payloadString = "{\n" +
                "    \"_id\": \"" + id + "\",\n" +
                "    \"name\": \"" + name + "\",\n" +
                "    \"country\": \"" + country + "\",\n" +
                "    \"logo\": \"" + logo + "\",\n" +
                "    \"slogan\": \"" + slogan + "\",\n" +
                "    \"head_quarters\": \"" + head_quarters + "\",\n" +
                "    \"website\": \"" + website + "\",\n" +
                "    \"established\": \"" + established + "\"\n" +
                "}";
        return payloadString;
    }


    public Map<String, Object> createpayloadHashmap(String id, String name, String country, String logo,
                                 String slogan, String head_quarters, String website, String established) {

        Map<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put(  "name", name);
        map.put( "country",country);
        map.put(  "logo",logo);
        map.put("slogan",slogan);
        map.put(  "head_quarters",head_quarters);
        map.put( "website",website);
        map.put( "established",established);

        return map;
    }
    public Response postDatahashMap(String endPoint , String payload, Map<String ,String> headers){
        return RestAssured.given()
                .baseUri(endPoint)
                .headers(headers)
                .body(payload)

                .post()
                .then()
                .log()
                .all()
                .extract()
                .response();



    }

}
