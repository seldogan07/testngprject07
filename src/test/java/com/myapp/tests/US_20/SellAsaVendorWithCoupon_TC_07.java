package com.myapp.tests.US_20;

import com.myapp.pages.My_Account_2Page;
import com.myapp.pages.PearlyMarketAddProductPage;
import com.myapp.pages.PearlyMarketHomePage;
import com.myapp.pages.PearlyMarketMyAccountPage;
import com.myapp.utilities.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.io.IOException;


public class SellAsaVendorWithCoupon_TC_07 {
    ReusableMethods reusableMethods = new ReusableMethods();
    MediaUtils takeScreenShot = new MediaUtils();
    PearlyMarketHomePage pmHomePage = new PearlyMarketHomePage();

    PearlyMarketMyAccountPage pearlyMarketMyAccountPage = new PearlyMarketMyAccountPage();

    PearlyMarketAddProductPage pearlyMarketAddProductPage = new PearlyMarketAddProductPage();
    JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();


    @Test
    public void shopAsAVendor() throws IOException {
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_homepage_url"));


        My_Account_2Page my_account_2Page = new My_Account_2Page();

        //        2_Click on Sign in
        pmHomePage.homePageSignInLink.click();

//        3_User should enter Email
        my_account_2Page.userName.sendKeys(ConfigReader.getProperty("PMValidUsername"));

//        4_User should enter the password
        my_account_2Page.password.sendKeys(ConfigReader.getProperty("PMValidPassword"));

//        5_Click on SIGN In button
        my_account_2Page.signIn.click();
//        2_User should navigate to Store Manager
        reusableMethods.scrollPageEndActions();
        pmHomePage.myAccountButton.click();
        pmHomePage.storeManagerButton.click();
        JSUtils.clickWithTimeoutByJS(pmHomePage.couponsButton);
        String couponCode=pmHomePage.couponCodeGet.getText();

        pmHomePage.couponProductName.click();
        pmHomePage.viewButton.click();


//      4_Then Click on GO SHOP button
        ReusableMethods.switchToWindow(1);

//      5_Then user should click on Chart button
        pmHomePage.chartButton.click();
        pmHomePage.viewChartButton.click();
//      Add Coupon Code
        pmHomePage.couponCodeInput.sendKeys(couponCode);
        pmHomePage.applyCouponButton.click();

//      6_Then user should click on CHECKOUT button
        pmHomePage.checkoutButton.click();

//      7_Total amount should be visible.
        JSUtils.clickWithTimeoutByJS(pmHomePage.payAtTheDoorElement);
       takeScreenShot.takeScreenshotOfTheEntirePage();



    }
}