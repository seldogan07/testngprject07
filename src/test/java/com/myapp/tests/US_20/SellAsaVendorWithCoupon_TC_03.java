package com.myapp.tests.US_20;

import com.github.javafaker.Faker;
import com.myapp.pages.Manage_CouponPage;
import com.myapp.pages.PearlyMarketAddProductPage;
import com.myapp.pages.PearlyMarketHomePage;
import com.myapp.pages.PearlyMarketMyAccountPage;
import com.myapp.tests.US_18.UserShouldBeCreateCoupons;
import com.myapp.utilities.Driver;
import com.myapp.utilities.JSUtils;
import com.myapp.utilities.MediaUtils;
import com.myapp.utilities.ReusableMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class SellAsaVendorWithCoupon_TC_03 {
    ReusableMethods reusableMethods = new ReusableMethods();
    MediaUtils takeScreenShot = new MediaUtils();
    PearlyMarketHomePage pmHomePage = new PearlyMarketHomePage();
    Manage_CouponPage manageCouponPage=new Manage_CouponPage();
    Faker faker=new Faker();
    PearlyMarketMyAccountPage pearlyMarketMyAccountPage = new PearlyMarketMyAccountPage();

    PearlyMarketAddProductPage pearlyMarketAddProductPage = new PearlyMarketAddProductPage();
    JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();


    @Test
    public void shopAsAVendor() throws Exception {

//        1_Go to https://pearlymarket.com/
        reusableMethods.signIn();
        reusableMethods.scrollPageEndActions();
        pmHomePage.myAccountButton.click();
        pmHomePage.storeManagerButton.click();

        JSUtils.clickWithTimeoutByJS(pmHomePage.couponsButton);

        manageCouponPage.addCouponButton.click();
        String couponCode=faker.bothify("??????##").toUpperCase();
        manageCouponPage.couponCode.sendKeys(couponCode);
        manageCouponPage.couponDescription.sendKeys(faker.lorem().paragraph());
        reusableMethods.getDropdownSelectedOptions(manageCouponPage.discountType);
        String paragraph=faker.bothify("##");
        manageCouponPage.couponAmount.clear();
        manageCouponPage.couponAmount.sendKeys(paragraph);
        LocalDate randomDate=generateRandomDate();
        String formattedDate = formatDate(randomDate, "yyyy/MM/dd");
        manageCouponPage.expiryDate.sendKeys(formattedDate);
        if (!manageCouponPage.freeShippingCheck.isSelected()) {
            JSUtils.clickWithTimeoutByJS(manageCouponPage.freeShippingCheck);
        }
        if (!manageCouponPage.showOnStoreCheck.isSelected()){
            JSUtils.clickWithTimeoutByJS(manageCouponPage.showOnStoreCheck);
        }
        JSUtils.clickWithTimeoutByJS(manageCouponPage.submitButton);
//        2_User should navigate to My Account
        ReusableMethods.scrollPageEndActions();
        JSUtils.clickWithTimeoutByJS(pmHomePage.secondMyAccount);

//      3_User should click on Orders
        pearlyMarketMyAccountPage.ordersLink.click();

//      4_Then Click on GO SHOP button
        JSUtils.clickWithTimeoutByJS(pearlyMarketMyAccountPage.goShopLink);

//      5_Then user should click on Chart button
        pmHomePage.chartButton.click();
        pmHomePage.viewChartButton.click();


        //String couponCode=pmHomePage.getCouponCode.getText();
        pmHomePage.couponCodeInput.sendKeys(couponCode);
        pmHomePage.applyCouponButton.click();


//      6_Then user should click on CHECKOUT button
        pmHomePage.checkoutButton.click();

    }
    public LocalDate generateRandomDate() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.of(2023, 12, 31);

        long startEpochDay = startDate.toEpochDay();
        long endEpochDay = endDate.toEpochDay();

        long randomEpochDay = startEpochDay + (long) (Math.random() * (endEpochDay - startEpochDay));

        return LocalDate.ofEpochDay(randomEpochDay);
    }
    public String formatDate(LocalDate date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return date.format(formatter);
    }
}