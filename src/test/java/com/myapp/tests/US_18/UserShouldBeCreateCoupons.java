package com.myapp.tests.US_18;





import com.github.javafaker.Faker;
import com.myapp.pages.*;
import com.myapp.utilities.*;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import com.myapp.utilities.JSUtils;

import io.netty.util.internal.ThreadLocalRandom;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static java.lang.Long.parseLong;

public class UserShouldBeCreateCoupons {
    ReusableMethods reMethods = new ReusableMethods();
    PearlyMarketHomePage pmHomePage = new PearlyMarketHomePage();
    Manage_CouponPage manageCouponPage=new Manage_CouponPage();
    Faker faker=new Faker();
    @Test
    public void createCoupon() throws Exception {
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_homepage_url"));
        PearlyMarketHomePage homePage=new PearlyMarketHomePage();
        Manage_CouponPage manageCouponPage=new Manage_CouponPage();
        ReusableMethods reusableMethods=new ReusableMethods();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        Faker faker=new Faker();

//        1_Go to https://pearlymarket.com/
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_homepage_url"));


        My_Account_2Page my_account_2Page = new My_Account_2Page();

        //        2_Click on Sign in
        homePage.homePageSignInLink.click();

//        3_User should enter Email
        my_account_2Page.userName.sendKeys(ConfigReader.getProperty("PMValidUsername"));

//        4_User should enter the password
        my_account_2Page.password.sendKeys(ConfigReader.getProperty("PMValidPassword"));

//        5_Click on SIGN In button
        my_account_2Page.signIn.click();
//        2_User should navigate to Store Manager
        reusableMethods.scrollPageEndActions();
        homePage.myAccountButton.click();
        homePage.storeManagerButton.click();


        JSUtils.clickWithTimeoutByJS(homePage.couponsButton);

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

        String messageScript = "return wcfm_coupons_manage_messages.coupon_published;";
        String message = (String) jsExecutor.executeScript(messageScript);
        assert message.equals("Coupon Successfully Published.");

        JSUtils.clickWithTimeoutByJS(homePage.couponsButton);



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