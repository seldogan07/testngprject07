package com.myapp.tests.US_18;



import com.github.javafaker.Faker;
import com.myapp.pages.Manage_CouponPage;
import com.myapp.pages.PearlyMarketHomePage;
import com.myapp.utilities.*;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import com.myapp.utilities.JSUtils;

import org.testng.annotations.Test;

public class UserShouldBeCreateCoupons {
    ReusableMethods reMethods = new ReusableMethods();
    PearlyMarketHomePage pmHomePage = new PearlyMarketHomePage();
    Manage_CouponPage manageCouponPage=new Manage_CouponPage();
    Faker faker=new Faker();
    @Test

    public void createCoupon() throws Exception {
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_homepage_url"));

        reMethods.signIn();

        pmHomePage.myAccountButton.click();
        pmHomePage.storeManagerButton.click();
        pmHomePage.myStoreProductsElement.click();
        reMethods.hoverOverOnElementActions(pmHomePage.myStoreProductsElement);
        pmHomePage.productsAddnewElement.click();

        JSUtils.clickWithTimeoutByJS(homePage.couponsButton);

        manageCouponPage.addCouponButton.click();
        manageCouponPage.couponCode.sendKeys(faker.bothify("??????##").toUpperCase());
        manageCouponPage.couponDescription.sendKeys(faker.lorem().paragraph());
        reusableMethods.getDropdownSelectedOptions(manageCouponPage.discountType);
        manageCouponPage.couponAmount.sendKeys(faker.bothify("##"));


    }
}