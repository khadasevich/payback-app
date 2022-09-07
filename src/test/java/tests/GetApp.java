package tests;

import models.AppInfoModel;

public class GetApp {

    public static AppInfoModel getAppInfo() {
        return AppInfoModel
                .builder()
                .appPackage("de.payback.client.android")
                .appActivity("de.payback.app.ui.main.MainActivity")
                .build();
    }
}
