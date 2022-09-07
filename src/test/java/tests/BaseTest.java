package tests;

import constants.Device;
import drivermanager.AndroidDriverManager;
import drivermanager.MobileManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import models.AppInfoModel;
import models.DeviceDetailsModel;
import org.testng.annotations.*;
import services.appiumservice.AppiumService;

public class BaseTest {

    private AppiumDriverLocalService server;
    private AppiumService appiumService;
    private MobileManager mobileManager;
    public AppiumDriver driver;

    @BeforeSuite
    public void startAppiumServer() {
        appiumService = new AppiumService();
        server = appiumService.startService();
    }

    @BeforeClass
    public void getDriverSession() {
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
        mobileManager.quitDriver();
    }

    @Test
    public void test() {
        System.out.println("");
    }

    @AfterSuite(alwaysRun = true)
    public void stopAppiumServer() {
        appiumService.stopService();
    }
}
