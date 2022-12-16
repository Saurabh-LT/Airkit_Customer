package com.resumelibrary.utilities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class PropertyFileReader implements Constants {
    private static final Logger logger = LogManager.getLogger(PropertyFileReader.class);

    private static volatile PropertyFileReader propertyInstance;

    public static synchronized PropertyFileReader getInstance() {
        if (propertyInstance == null) {
            propertyInstance = new PropertyFileReader();
        }
        return propertyInstance;
    }

    public String getProperty(String propertyName) {
        Properties properties = new Properties();
        FileInputStream inputStream = null;

        try {
            inputStream = new FileInputStream(System.getProperty("user.dir") + PROPERTY_FILE_PATH);
            properties.load(inputStream);
            if (properties.getProperty(propertyName) != null) {
                return properties.getProperty(propertyName);
            }
        } catch (Exception e) {
            logger.info("[--->Property File not found<---]");
        }
        return null;
    }

    public List getTagNamesFromProperties() {
        List tagNames = new ArrayList<String>();
        String propertiesFilename = "Scenarios.properties";
        Map<String, String> properties = new HashMap<>();

        try (InputStream stream = new FileInputStream(propertiesFilename)) {
            Properties prop = new Properties() {
                @Override
                public synchronized Object put(Object key, Object value) {
                    tagNames.add(value.toString());
                    return properties.put(key.toString(), value.toString());
                }
            };
            prop.load(stream);
            logger.info("[--->tagNames to skip failure from Scenarios.properties :" + tagNames + "<----]");
        } catch (IOException e) {
            logger.info("[--->error while reading data from properties:" + e.getMessage() + "<----]");
        }
        return tagNames;
    }

    public String getConstantsURL(String URL) {
        return null;
    }
}