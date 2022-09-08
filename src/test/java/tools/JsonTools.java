package tools;

import com.google.gson.Gson;
import constants.Paths;
import lombok.extern.log4j.Log4j;
import models.AppInfoModel;
import models.DeviceDetailsModel;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@Log4j
public class JsonTools {

    public static DeviceDetailsModel getDeviceForTest() {
        log.debug("Attempt to get details of device from stored Json");
        Gson gson = new Gson();
        DeviceDetailsModel deviceDetails = null;
        try (Reader reader = new FileReader(Paths.pathToDeviceDetails)) {
            deviceDetails = gson.fromJson(reader, DeviceDetailsModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return deviceDetails;
    }

    public static AppInfoModel getAppForTest() {
        log.debug("Attempt to get details of app from stored Json");
        Gson gson = new Gson();
        AppInfoModel appDetails = null;
        try (Reader reader = new FileReader(Paths.pathToAppDetails)) {
            appDetails = gson.fromJson(reader, AppInfoModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return appDetails;
    }
}
