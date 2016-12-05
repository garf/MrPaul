import java.util.HashMap;
import java.util.Map;

class Config {
    static String get(String key) {
        Map<String, String> map = new HashMap<String, String>();

        map.put("channel", "random");
        map.put("token", "YourToken");

        return map.get(key);
    }
}
