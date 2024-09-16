package utiles;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

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
}
