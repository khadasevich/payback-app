package tests;

import models.DeviceDetailsModel;

public class GetDevice {
    public static DeviceDetailsModel getVirtualDevice() {
        return DeviceDetailsModel
                .builder()
                .platformName("Android")
                .platformVersion("12")
                .deviceName("Pixel 5")
                .udid("emulator-5554")
                .build();
    }

    public static DeviceDetailsModel getRealDevice() {
        return DeviceDetailsModel
                .builder()
                .platformName("Android")
                .platformVersion("10")
                .deviceName("bt")
                .udid("a1436ba2")
                .build();
    }
}
