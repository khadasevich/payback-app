package drivermanager;

import constants.Timeouts;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import lombok.extern.log4j.Log4j2;
import models.AppInfoModel;
import models.DeviceDetailsModel;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

@Log4j2
public class AndroidDriverManager extends MobileManager {

    protected static ThreadLocal<AppiumDriver> threadLocalDriver = new ThreadLocal<>();
    private AppiumDriverLocalService server;
    private AppInfoModel appInfo;
    private DeviceDetailsModel deviceDetails;

    public AndroidDriverManager(AppiumDriverLocalService server, AppInfoModel appInfo, DeviceDetailsModel deviceDetails) {
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
        log.debug(String.format("Attempt to start Android session with following device %s, and following app %s", deviceDetails.toString(), appInfo.toString()));
        threadLocalDriver.set(new AndroidDriver(server.getUrl(), caps));
    }

    @Override
    public AppiumDriver getDriver() {
        log.debug("Getting driver from threadlocal storage");
        return threadLocalDriver.get();
    }

    @Override
    public void quitDriver() {
        log.debug("Quit driver");
        threadLocalDriver.get().quit();
    }

    @Override
    public void setTimeout() {
        log.debug("Set implicit wait for driver");
        threadLocalDriver.get().manage().timeouts().implicitlyWait(Timeouts.IMPLICIT_TIMEOUT);
    }
}
