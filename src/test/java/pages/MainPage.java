package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class MainPage extends BasePage {

    private By TOP_TOOLBAR = By.xpath("//*[contains(@resource-id, 'toolbar_native')]");
    private By COUPON_BUTTON = By.xpath("//*[contains(@resource-id, 'coupon_center_dest')]");

    public MainPage(AppiumDriver driver) {
        super(driver);
    }

    public MainPage closeKarteBanner() {
        driver.findElement(TOP_TOOLBAR).click();
        return this;
    }

    public CouponsPage openCouponsPage() {
        driver.findElement(COUPON_BUTTON).click();
        return new CouponsPage(driver);
    }
}
