package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomePage extends BasePage {

    private By LOGIN_BUTTON = By.xpath("//*[@resource-id='de.payback.client.android:id/welcome_loginbutton']");

    public WelcomePage(AppiumDriver driver) {
        super(driver);
    }

    public LoginPage openLoginPage() {
        driver.findElement(LOGIN_BUTTON).click();
        return new LoginPage(driver);
    }
}
