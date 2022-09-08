package pages;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class InputKartePage extends BasePage {

    private By KARTE_INPUT = By.xpath("");

    private By WEITER_BUTTON = By.xpath("");

    public InputKartePage(AppiumDriver driver) {
        super(driver);
    }

    //ToDo: page not complete because elements on page hidden by security reason

    @Step("Input card number")
    public InputKartePage inputKarteNumber(String karte) {
        log.debug(String.format("Attempt to send text to element by locator: "), KARTE_INPUT.toString());
        driver.findElement(KARTE_INPUT).sendKeys(karte);
        return this;
    }

    @Step("Proceed with password")
    public InputPasswortPage clickWeiterButton() {
        log.debug(String.format("Attempt to click element by locator: "), WEITER_BUTTON.toString());
        driver.findElement(WEITER_BUTTON).click();
        return new InputPasswortPage(driver);
    }
}
