package com.myapp.tests.US_18;



import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import com.myapp.pages.Manage_CouponPage;
import com.myapp.pages.PearlyMarketHomePage;
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
    @Test

    public void createCoupon() throws Exception {
        PearlyMarketHomePage homePage=new PearlyMarketHomePage();
        Manage_CouponPage manageCouponPage=new Manage_CouponPage();
        ReusableMethods reusableMethods=new ReusableMethods();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        Faker faker=new Faker();

//        1_Go to https://pearlymarket.com/
        reusableMethods.signIn();
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