package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import steps.LoginStep;

public class CouponTest extends BaseTest{

    private MainPage mainPage;

    @BeforeMethod
    public void goThroughLogin() {
        LoginStep loginStep = new LoginStep(driver);
        mainPage = loginStep.completeLogin("placeholder");
    }

    @Test
    public void activateReweCouponTest() {

    }
}
