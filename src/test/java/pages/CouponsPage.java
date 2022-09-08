package pages;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

@Log4j2
public class CouponsPage extends BasePage {

    private By FILTER_BUTTON = By.xpath("//*[contains(@resource-id, 'filter_button')]");

    public CouponsPage(AppiumDriver driver) {
        super(driver);
    }

    @Step("Open filters page")
    public FilterPage openFilters() {
        log.debug(String.format("Attempt to click element by locator: "), FILTER_BUTTON.toString());
        driver.findElement(FILTER_BUTTON).click();
        return new FilterPage(driver);
    }
}
