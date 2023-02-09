package org.example.meme.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropsReader {
    private static Logger logger = Logger.getLogger(PropsReader.class.getName());
    private static HashMap<String, String> gottenProps = new HashMap<>();
    private static final String PATH_TO_PROPS = "src\\test\\resources\\config.properties";

    static {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream(PATH_TO_PROPS)) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
            logger.log(Level.SEVERE, ex.getMessage());
        }
        for (final String name: prop.stringPropertyNames())
            gottenProps.put(name, prop.getProperty(name));
    }
    public static String getProperty (String name) {
        return gottenProps.getOrDefault(name, "absent property, check name");
    }
}
