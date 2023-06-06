package com.myapp.tests.US_18;


import com.myapp.pages.My_Account_2Page;
import com.myapp.pages.PearlyMarketHomePage;
import com.myapp.pages.StoreManagerPage;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import com.myapp.utilities.JSUtils;

import com.myapp.utilities.WaitUtils;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class UserShouldBeCreateCoupons {
    @Test
    public void createCoupon() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_homepage_url"));
        //Click on "My Account" button
        PearlyMarketHomePage homePage=new PearlyMarketHomePage();

        JSUtils.clickWithTimeoutByJS(homePage.myAccountButton);

        My_Account_2Page my_account_2Page=new My_Account_2Page();

        my_account_2Page.userName.sendKeys("echelon_1649@hotmail.com");
        my_account_2Page.password.sendKeys("A1234%");
        JSUtils.clickWithTimeoutByJS(my_account_2Page.signIn);

        JSUtils.clickWithTimeoutByJS(my_account_2Page.storeManagerButton);
        StoreManagerPage storeManagerPage=new StoreManagerPage();
        Actions actions=new Actions(Driver.getDriver());

    }
}