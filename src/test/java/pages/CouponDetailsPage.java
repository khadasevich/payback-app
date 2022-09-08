package pages;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;

@Log4j
public class CouponDetailsPage extends BasePage {

    private By ACTIVATED_ICON = By.xpath("//*[contains(@resource-id, 'activated_icon')]");

    public CouponDetailsPage(AppiumDriver driver) {
        super(driver);
    }

    @Step("Check that activated icon is displayed")
    public boolean isActivatedDisplayedInDetails() {
        log.info(String.format("Attempt to find element by locator: %s", ACTIVATED_ICON.toString()));
        return driver.findElement(ACTIVATED_ICON).isDisplayed();
    }
}
