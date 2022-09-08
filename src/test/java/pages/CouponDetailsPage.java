package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class CouponDetailsPage extends BasePage {

    private By ACTIVATED_ICON = By.xpath("//*[contains(@resource-id, 'activated_icon')]");

    public CouponDetailsPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean isActivatedDisplayedInDetails() {
        return driver.findElement(ACTIVATED_ICON).isDisplayed();
    }
}
