package steps;

import io.appium.java_client.AppiumDriver;
import pages.MainPage;
import pages.WelcomePage;

public class LoginStep {

    private AppiumDriver driver;

    public LoginStep(AppiumDriver driver) {
        this.driver = driver;
    }

    public MainPage completeLogin(String karteNumber) {
        return new WelcomePage(driver)
                .openLoginPage()
                .inputKarteNumber(karteNumber)
                .clickWeiterButton();
    }
}
