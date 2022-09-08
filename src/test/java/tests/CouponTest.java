package tests;

import constants.Credentials;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import steps.LoginStep;
import tools.RetryAnalyzer;

@Log4j
public class CouponTest extends BaseTest{

    private MainPage mainPage;

    @BeforeMethod
    public void goThroughLogin() {
        log.info("Complete login before test");
        LoginStep loginStep = new LoginStep(driver);
        mainPage = loginStep.completeLogin(Credentials.getCredentials());
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Severity(SeverityLevel.CRITICAL)
    @Description("User freshly logs into system and goes to coupons selects REWE partner and activates first coupon")
    public void activateReweCouponTest() {
        log.info("Start of coupon test");
        boolean isCouponActivated = mainPage
                .closeKarteBanner()
                .openCouponsPage()
                .openFilters()
                .selectRewePartner()
                .activateCoupon()
                .openDetailsOfActivatedCoupon()
                .isActivatedDisplayedInDetails();
        Assert.assertTrue(isCouponActivated, "Activated icon doesn't present in the details of coupon");
    }
}
