package steps;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import models.UserModel;
import pages.MainPage;
import pages.WelcomePage;

public class LoginStep {

    private AppiumDriver driver;

    public LoginStep(AppiumDriver driver) {
        this.driver = driver;
    }

    @Step("Make full login")
    public MainPage completeLogin(UserModel user) {
        new WelcomePage(driver)
                .openLoginPage();
        return new MainPage(driver);
    }
}
