import java.util.Map;

class Config {
    static String get(String key) {
        Map<String, String> env = System.getenv();

        return env.get(key);
    }

    static Map<String, String> getAll() {
        return System.getenv();
    }
}
