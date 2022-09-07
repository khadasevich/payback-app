package drivermanager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import models.AppInfoModel;
import models.DeviceDetailsModel;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidHolderHolder extends MobileHolder {

    protected static ThreadLocal<AppiumDriver> threadLocalDriver = new ThreadLocal<>();
    private AppiumDriverLocalService server;
    private AppInfoModel appInfo;
    private DeviceDetailsModel deviceDetails;

    public AndroidHolderHolder(AppiumDriverLocalService server, AppInfoModel appInfo, DeviceDetailsModel deviceDetails) {
        this.server = server;
        this.appInfo = appInfo;
        this.deviceDetails = deviceDetails;
    }

    @Override
    public void setUpDriver() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", deviceDetails.getPlatformName());
        caps.setCapability("platformVersion", deviceDetails.getPlatformVersion());
        caps.setCapability("deviceName", deviceDetails.getDeviceName());
        caps.setCapability("udid", deviceDetails.getUdid());
        caps.setCapability("appPackage", appInfo.getAppPackage());
        caps.setCapability("appActivity", appInfo.getAppActivity());
        caps.setCapability("automationName", "UiAutomator2");

        threadLocalDriver.set(new AndroidDriver(server.getUrl(), caps));
    }

    @Override
    public AppiumDriver getDriver() {
        return threadLocalDriver.get();
    }

    @Override
    public void quitDriver() {
        threadLocalDriver.get().quit();
    }
}
