package com.myapp.tests.US_20;

import com.github.javafaker.Faker;
import com.myapp.pages.*;
import com.myapp.tests.US_18.UserShouldBeCreateCoupons;
import com.myapp.utilities.*;
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
    My_Account_2Page my_account_2Page = new My_Account_2Page();
    String couponCode;

    @Test
    public void createCoupon() throws Exception {

//        1_Go to https://pearlymarket.com/
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_homepage_url"));
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

        manageCouponPage.addCouponButton.click();
        couponCode=faker.bothify("??????##").toUpperCase();
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

    }
    @Test
    public void shopAsAVendor() throws IOException {

//        1_Go to https://pearlymarket.com/
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_homepage_url"));


//        2_User should navigate to My Account
        reusableMethods.scrollPageEndActions();
        my_account_2Page.twoMyAccount.click();

//      3_User should click on Orders
        pearlyMarketMyAccountPage.ordersLink.click();

//      4_Then Click on GO SHOP button
        JSUtils.clickWithTimeoutByJS(pearlyMarketMyAccountPage.goShopLink);

//      5_Then user should click on Chart button
        pmHomePage.chartButton.click();
        pmHomePage.viewChartButton.click();
        pmHomePage.couponCodeInput.sendKeys(couponCode);
        JSUtils.clickWithTimeoutByJS(pmHomePage.applyCouponButton);

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