import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class Config {
    private static Properties properties = new Properties();
    private static InputStream fileInput = null;

    static String get(String key) {
        try {
            fileInput = new FileInputStream("config.properties");
            properties.load(fileInput);

            return properties.getProperty(key);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (fileInput != null) {
                try {
                    fileInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
