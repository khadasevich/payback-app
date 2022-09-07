package tests;

import constants.Device;
import drivermanager.AndroidHolderHolder;
import drivermanager.MobileHolder;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import models.AppInfoModel;
import models.DeviceDetailsModel;
import org.testng.ReporterConfig;
import org.testng.annotations.*;
import services.appiumservice.AppiumService;

public class BaseTest {

    private AppiumDriverLocalService server;
    private AppiumService appiumService;
    private MobileHolder mobileHolder;
    public AppiumDriver driver;

    @BeforeSuite
    public void startAppiumServer() {
        appiumService = new AppiumService();
        server = appiumService.startService();
    }

    @BeforeClass
    public void getDriverSession() {
//        System.setProperty("ANDROID_HOME", "C:/Users/alexeykhodasevich/AppData/Local/Android/Sdk");
        AppInfoModel appInfo = GetApp.getAppInfo();
        DeviceDetailsModel deviceDetails = GetDevice.getRealDevice();
        if(deviceDetails.getPlatformName().equals(Device.ANDROID.getTitle())){
            mobileHolder = new AndroidHolderHolder(server, appInfo, deviceDetails);
        } else if (deviceDetails.getPlatformName().equals(Device.IOS.getTitle())) {
            //ToDo: add code for iOS set up
        }
        mobileHolder.setUpDriver();
        driver = mobileHolder.getDriver();
    }

    @AfterClass
    public void closeDriverSession() {
        mobileHolder.quitDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void stopAppiumServer() {
        appiumService.stopService();
    }
}
