package pages;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class WelcomePage extends BasePage {

    private By LOGIN_BUTTON = By.xpath("//*[contains(@resource-id, 'welcome_loginbutton')]");

    public WelcomePage(AppiumDriver driver) {
        super(driver);
    }

    @Step("Open login login page")
    public InputKartePage openLoginPage() {
        log.debug(String.format("Attempt to click element by locator: "), LOGIN_BUTTON.toString());
        driver.findElement(LOGIN_BUTTON).click();
        return new InputKartePage(driver);
    }
}
