package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class CouponsPage extends BasePage {

    private By FILTER_BUTTON = By.xpath("//*[contains(@resource-id, 'filter_button')]");

    public CouponsPage(AppiumDriver driver) {
        super(driver);
    }

    public FilterPage openFilters() {
        driver.findElement(FILTER_BUTTON).click();
        return new FilterPage(driver);
    }
}
