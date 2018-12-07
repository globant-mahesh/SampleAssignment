package com.org.configs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;

    public ConfigFileReader() {

        BufferedReader reader;
        String propertyFilePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\org\\configs\\Configuration.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch(Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration file not found at the path " + propertyFilePath);
        }
    }


    public String getDriverPath(){
        String driverPath = properties.getProperty("driverPath");
        System.out.println("\nDriver Path " + driverPath);
        if(driverPath!= null)
            return driverPath;
        else
            throw new RuntimeException("DriverPath not specified in the Configuration.properties file.");
    }

    public String getApplicationURL() {

        String urlPath = properties.getProperty("url");
        System.out.println("\nURL Path " + urlPath);
        if (urlPath !=null)
            return urlPath;
        else
            throw new RuntimeException ("URL not specified in the Configuration file ");
    }
}
