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
        return new WelcomePage(driver)
                .openLoginPage()
                .inputKarteNumber(user.getCardNumber())
                .clickWeiterButton()
                .inputPasswort(user.getPassword())
                .clickWeiterButton();
    }
}
