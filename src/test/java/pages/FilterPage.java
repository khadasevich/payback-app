package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.util.logging.Filter;

public class FilterPage extends BasePage {

    private By REWE_TILE = By.xpath("(//*[contains(@resource-id, 'filter_button')])[3]");
    private By FIRST_REWE_COUPON = By.xpath(("(//*[contains(@resource-id, 'not_activated_button')])[1]"));
    private By FIRST_ACTIVATED_COUPON = By.xpath(("(//*[contains(@resource-id, 'constraint_container')])[1]"));

    public FilterPage(AppiumDriver driver) {
        super(driver);
    }

    public FilterPage selectRewePartner() {
        driver.findElement(REWE_TILE).click();
        return this;
    }

    public FilterPage activateCoupon() {
        driver.findElement(FIRST_REWE_COUPON).click();
        return this;
    }

    public CouponDetailsPage openDetailsOfActivatedCoupon() {
        driver.findElement(FIRST_ACTIVATED_COUPON).click();
        return new CouponDetailsPage(driver);
    }
}
