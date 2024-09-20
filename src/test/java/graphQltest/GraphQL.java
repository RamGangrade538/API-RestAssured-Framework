package graphQltest;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GraphQL {

    @Test
    public void getAllFilms(){
        RestAssured.baseURI = "https://countries.trevorblades.com/";

    }
}
