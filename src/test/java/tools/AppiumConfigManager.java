package tools;

import constants.Paths;
import lombok.extern.log4j.Log4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


@Log4j
public class AppiumConfigManager {

    private String propertyFilePath;
    private Properties prop;

    public AppiumConfigManager() {
        propertyFilePath = System.getProperty("user.dir") + Paths.pathToAppiumConfig;
    }


    public void loadData() {
        log.debug("Get appium config");
        prop = new Properties();
        try {
            prop.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(String propertyName) {
        loadData();
        log.debug(String.format("Get property %s from config", propertyName));
        return prop.getProperty(propertyName);
    }
}