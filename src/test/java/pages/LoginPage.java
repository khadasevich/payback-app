package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By KARTE_INPUT = By.xpath("");

    private By WEITER_BUTTON = By.xpath("");

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    public LoginPage inputKarteNumber(String karte) {
        driver.findElement(KARTE_INPUT).sendKeys(karte);
        return this;
    }

    public MainPage clickWeiterButton() {
        driver.findElement(WEITER_BUTTON).click();
        return new MainPage(driver);
    }
}
