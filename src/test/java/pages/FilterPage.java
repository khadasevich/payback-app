package pages;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;

@Log4j
public class FilterPage extends BasePage {

    private By REWE_TILE = By.xpath("(//*[contains(@resource-id, 'filter_button')])[3]");
    private By FIRST_REWE_COUPON = By.xpath(("(//*[contains(@resource-id, 'not_activated_button')])[1]"));
    private By FIRST_ACTIVATED_COUPON = By.xpath(("(//*[contains(@resource-id, 'constraint_container')])[1]"));

    public FilterPage(AppiumDriver driver) {
        super(driver);
    }

    @Step("Select REWE partner")
    public FilterPage selectRewePartner() {
        log.debug(String.format("Attempt to click element by locator: %s", REWE_TILE.toString()));
        driver.findElement(REWE_TILE).click();
        return this;
    }

    @Step("Activate coupon")
    public FilterPage activateCoupon() {
        log.debug(String.format("Attempt to click element by locator: ", FIRST_REWE_COUPON.toString()));
        driver.findElement(FIRST_REWE_COUPON).click();
        return this;
    }

    @Step("Open details of activated coupon")
    public CouponDetailsPage openDetailsOfActivatedCoupon() {
        log.debug(String.format("Attempt to click element by locator: ", FIRST_ACTIVATED_COUPON.toString()));
        driver.findElement(FIRST_ACTIVATED_COUPON).click();
        return new CouponDetailsPage(driver);
    }
}
