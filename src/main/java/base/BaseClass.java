package base;

import utils.JsonUtils;

import java.io.IOException;
import java.util.Map;

public class BaseClass {
    public static Map<String,Object> datafromjsonfile;
    static
    {
        String env = System.getProperty("env") == null ? "qa" :System.getProperty("env");
        System.out.println(System.getProperty("env")+"Env value" );
        Map<String, String> data = null;
        try {
            datafromjsonfile = JsonUtils.getJsonDataHashmap("airline/"+env+"/Airline.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(data);
    }
}
