package tests;

import constants.Device;
import drivermanager.AndroidDriverManager;
import drivermanager.MobileManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import lombok.extern.log4j.Log4j2;
import models.AppInfoModel;
import models.DeviceDetailsModel;
import org.testng.annotations.*;
import services.appiumservice.AppiumService;

@Log4j2
public class BaseTest {

    private AppiumDriverLocalService server;
    private AppiumService appiumService;
    private MobileManager mobileManager;
    public AppiumDriver driver;

    @BeforeSuite
    public void startAppiumServer() {
        log.info("Start appium service before test suite");
        appiumService = new AppiumService();
        server = appiumService.startService();
    }

    @BeforeClass
    public void getDriverSession() {
        log.info("Start mobile device session before test class execution");
        AppInfoModel appInfo = GetApp.getAppInfo();
        DeviceDetailsModel deviceDetails = GetDevice.getRealDevice();
        if(deviceDetails.getPlatformName().equals(Device.ANDROID.getTitle())){
            mobileManager = new AndroidDriverManager(server, appInfo, deviceDetails);
        } else if (deviceDetails.getPlatformName().equals(Device.IOS.getTitle())) {
            //ToDo: add code for iOS set up
        }
        mobileManager.setUpDriver();
        mobileManager.setTimeout();
        driver = mobileManager.getDriver();
    }

    @AfterClass
    public void closeDriverSession() {
        log.info("Close driver session after test executed");
        mobileManager.quitDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void stopAppiumServer() {
        log.info("Stop appium server after test suite executed");
        appiumService.stopService();
    }
}
