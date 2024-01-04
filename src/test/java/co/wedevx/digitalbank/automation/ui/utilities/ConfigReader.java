package co.wedevx.digitalbank.automation.ui.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//build a logic that reads the config file (properties file)
public class ConfigReader {
    private static Properties properties;

    static {   //static initializer - run the block only once for the whole project
//        instance initializer run the block once for every object creation from the class
//        filePath - directory of your properties file
        String filePath = "src/test/resources/properties/digitalbank.properties";
        FileInputStream input = null;
//it throws a checked exception
        try {
            input = new FileInputStream(filePath);  // this is a class that enables you to read files
            properties = new Properties();
            properties.load(input);

        } catch (IOException e) {
            System.out.println("File not found");
            // throw new RuntimeException(e);
        } finally {
            try {
                input.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
        }

//        System.out.println(properties.get("My_NAME"));
//        System.out.println(properties.get("browser"));
//        System.out.println(properties.get("environment"));
    }

    public static String getPropertiesValeu(String key){
        return properties.getProperty(key);
    }
}
