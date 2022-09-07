package drivermanager;

import io.appium.java_client.AppiumDriver;

public abstract class MobileHolder {

    public abstract void setUpDriver();

    public abstract AppiumDriver getDriver();

    public abstract void quitDriver();
}
