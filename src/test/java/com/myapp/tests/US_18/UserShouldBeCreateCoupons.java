package com.myapp.tests.US_18;


import com.myapp.pages.My_Account_2Page;
import com.myapp.pages.PearlyMarketHomePage;
import com.myapp.pages.StoreManagerPage;
import com.myapp.utilities.*;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class UserShouldBeCreateCoupons {
    @Test
    public void createCoupon() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_homepage_url"));

        PearlyMarketHomePage homePage=new PearlyMarketHomePage();

        ReusableMethods reusableMethods=new ReusableMethods();
        reusableMethods.signIn();

        JSUtils.clickWithTimeoutByJS(homePage.myAccountButton);

        My_Account_2Page my_account_2Page=new My_Account_2Page();

        JSUtils.clickWithTimeoutByJS(my_account_2Page.storeManagerButton);
        StoreManagerPage storeManagerPage=new StoreManagerPage();
        Actions actions=new Actions(Driver.getDriver());

    }
}