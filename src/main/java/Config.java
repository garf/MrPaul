import java.util.HashMap;
import java.util.Map;

class Config {
    static String get(String key) {
        Map<String, String> map = new HashMap<String, String>();

        map.put("channel", "random");
        map.put("token", "xoxb-113616991702-8RTnhYhgSRydtiomno1dxsEn");

        return map.get(key);
    }
}
