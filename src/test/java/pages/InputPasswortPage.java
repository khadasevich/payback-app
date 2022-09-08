package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class InputPasswortPage extends BasePage {

    private By PASSWORT_INPUT = By.xpath("");

    private By WEITER_BUTTON = By.xpath("");

    public InputPasswortPage(AppiumDriver driver) {
        super(driver);
    }

    public InputPasswortPage inputPasswort(String passwort) {
        driver.findElement(PASSWORT_INPUT).sendKeys(passwort);
        return this;
    }

    public MainPage clickWeiterButton() {
        driver.findElement(WEITER_BUTTON).click();
        return new MainPage(driver);
    }
}
