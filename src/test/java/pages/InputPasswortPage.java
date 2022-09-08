package pages;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;

@Log4j
public class InputPasswortPage extends BasePage {

    private By PASSWORT_INPUT = By.xpath("");

    private By WEITER_BUTTON = By.xpath("");

    public InputPasswortPage(AppiumDriver driver) {
        super(driver);
    }

    //ToDo: page not complete because elements on page hidden by security reason

    @Step("Input password")
    public InputPasswortPage inputPasswort(String passwort) {
        log.debug(String.format("Attempt to send text to element by locator: %s", PASSWORT_INPUT.toString()));
        driver.findElement(PASSWORT_INPUT).sendKeys(passwort);
        return this;
    }

    @Step
    public MainPage clickWeiterButton() {
        log.debug(String.format("Attempt to click element by locator: %s", WEITER_BUTTON.toString()));
        driver.findElement(WEITER_BUTTON).click();
        return new MainPage(driver);
    }
}
