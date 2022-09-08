package pages;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;

@Log4j
public class MainPage extends BasePage {

    private By TOP_TOOLBAR = By.xpath("//*[contains(@resource-id, 'toolbar_native')]");
    private By COUPON_BUTTON = By.xpath("//*[contains(@resource-id, 'coupon_center_dest')]");

    public MainPage(AppiumDriver driver) {
        super(driver);
    }

    @Step("Hide Karte banner")
    public MainPage closeKarteBanner() {
        log.debug(String.format("Attempt to click element by locator: %s", TOP_TOOLBAR.toString()));
        driver.findElement(TOP_TOOLBAR).click();
        return this;
    }

    public CouponsPage openCouponsPage() {
        log.debug(String.format("Attempt to click element by locator: %s", COUPON_BUTTON.toString()));
        driver.findElement(COUPON_BUTTON).click();
        return new CouponsPage(driver);
    }
}
