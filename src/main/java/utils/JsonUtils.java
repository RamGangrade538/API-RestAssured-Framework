package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonUtils {
    private static ObjectMapper ObjectMapper = new ObjectMapper();
    public static Map<String ,String > getJsonDataHashmap(String jsonfile) throws IOException {
    String pathofJsonfile = System.getProperty("user.dir") + "/src/test/resources/" + jsonfile;
        Map<String ,String > data= (Map<String, String>) ObjectMapper.readValue(new File(pathofJsonfile), new TypeReference<Object>() {});

        return data ;
    }
}
