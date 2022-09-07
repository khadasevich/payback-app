package services.appiumservice;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import tools.ConfigurationManager;

import java.io.File;

public class AppiumService {

    private AppiumDriverLocalService server;
    private ConfigurationManager configManager;
    private AppiumServiceBuilder serviceBuilder;

    public AppiumService() {
        this.configManager = new ConfigurationManager();
        this.serviceBuilder = new AppiumServiceBuilder();
    }

    public AppiumDriverLocalService startService() {
        serviceBuilder.usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .usingDriverExecutable(new File(configManager.get("NODE_BINARY_PATH")))
                .withAppiumJS(new File(configManager.get("APPIUM_BINARY_PATH")))
                .withArgument(() -> "--base-path", "/wd/");
        server = AppiumDriverLocalService.buildService(serviceBuilder);
        server.start();
        return server;
    }

    public void stop() {
        this.server.stop();
    }

    public AppiumDriverLocalService get(){
        return this.server;
    }
}
