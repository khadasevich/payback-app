package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import steps.LoginStep;

public class CouponTest extends BaseTest{

    private MainPage mainPage;

    @BeforeMethod
    public void goThroughLogin() {
        LoginStep loginStep = new LoginStep(driver);
        mainPage = loginStep.completeLogin("3582097778", "string@1");
    }

    @Test
    public void activateReweCouponTest() {
        boolean isCouponActivated = mainPage
                .closeKarteBanner()
                .openCouponsPage()
                .openFilters()
                .activateCoupon()
                .openDetailsOfActivatedCoupon()
                .isActivatedDisplayedInDetails();
        Assert.assertTrue(isCouponActivated, "Activated icon doesn't present in the details of coupon");
    }
}
