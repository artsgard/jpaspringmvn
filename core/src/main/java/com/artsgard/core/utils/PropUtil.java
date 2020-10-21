package com.artsgard.core.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author WillemFrits
 */
public class PropUtil {
    
    public static String getProp(String k) {
        Properties prop = new Properties();
        InputStream input = null;
        String val = null;
        try {
            String filename = "contact.properties";
            input
                    = PropUtil.class
                            .getClassLoader().getResourceAsStream(filename);
            if (input == null) {
                System.out.println("Sorry, unable to find " + filename);
                return null;
            }
            prop.load(input);
            val = prop.getProperty(k);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return val;
    }
}
