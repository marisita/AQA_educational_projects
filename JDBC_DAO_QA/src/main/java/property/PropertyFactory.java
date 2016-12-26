package property;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Properties;

public class PropertyFactory {

    private static final Logger LOGGER = LogManager.getLogger(PropertyFactory.class);
    private static final String PROPERTIES_FILE = "src/main/resources/app.properties";
    public static Properties properties;

    public static Properties getInstance(){
        properties = new Properties();
        InputStream is = null;
        try {
            is = new FileInputStream(PROPERTIES_FILE);
            properties.load(is);
            is.close();
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return properties;
    }

    public static String getProperty(String propertyName) {
        getInstance();
        return properties.getProperty(propertyName);
    }

    public static void setProperty(String propertyName, String value) {
        getInstance();
        properties.setProperty(propertyName, value);
        storeProperty();
    }

    public static void storeProperty() {
        try {
            FileOutputStream prop = new FileOutputStream(PROPERTIES_FILE);
            properties.store(prop, null);
            prop.flush();
            prop.close();
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
