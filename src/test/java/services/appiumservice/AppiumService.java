package services.appiumservice;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import lombok.extern.log4j.Log4j;
import tools.AppiumConfigManager;

import java.io.File;

@Log4j
public class AppiumService {

    private AppiumDriverLocalService server;
    private AppiumConfigManager configManager;
    private AppiumServiceBuilder serviceBuilder;

    public AppiumService() {
        this.configManager = new AppiumConfigManager();
        this.serviceBuilder = new AppiumServiceBuilder();
    }

    public AppiumDriverLocalService startService() {
        serviceBuilder.usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .usingDriverExecutable(new File(configManager.get("NODE_BINARY_PATH")))
                .withAppiumJS(new File(configManager.get("APPIUM_BINARY_PATH")))
                .withArgument(() -> "--base-path", "/wd/");
        log.trace(String.format("Attempt to start server with following builder: %s", serviceBuilder.toString()));
        server = AppiumDriverLocalService.buildService(serviceBuilder);
        server.start();
        return server;
    }

    public void stopService() {
        log.trace("Stop appium server");
        this.server.stop();
    }
}
