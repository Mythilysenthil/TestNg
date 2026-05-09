package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    static Properties prop;

    public static void loadProperties() {

        try {

            prop = new Properties();

            FileInputStream fis = new FileInputStream(
                    "src/test/resources/config/config.properties");

            prop.load(fis);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {

        return prop.getProperty(key);
    }
}