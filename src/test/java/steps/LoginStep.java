package steps;

import io.appium.java_client.AppiumDriver;
import pages.MainPage;
import pages.WelcomePage;

public class LoginStep {

    private AppiumDriver driver;

    public LoginStep(AppiumDriver driver) {
        this.driver = driver;
    }

    public MainPage completeLogin(String karteNumber, String passwort) {
        return new WelcomePage(driver)
                .openLoginPage()
                .inputKarteNumber(karteNumber)
                .clickWeiterButton()
                .inputPasswort(passwort)
                .clickWeiterButton();
    }
}
