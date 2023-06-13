package com.myapp.tests.US_08;

import com.myapp.pages.PearlyMarketHomePage;
import com.myapp.pages.WishListPage;
import com.myapp.utilities.*;
import org.testng.annotations.Test;

public class TC_002 {
    //1_ Go to https://pearlymarket.com/
    //2_ click on Sign in
    //3_ Enter valid username and password
    //4_ Click electronics
    //5_ Click TV
    //6_Click wishlist buttons on the first product
    //7_Click the wishlist button on the page
    //8_Click Ouick View
    @Test
    public void wishListTest2() throws InterruptedException {

        PearlyMarketHomePage PearlyHomePage = new PearlyMarketHomePage();
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_homepage_url"));
        PearlyHomePage.homepageSignInButton.click();
        PearlyHomePage.usernameBox.sendKeys("mercure");
        PearlyHomePage.passwordBox.sendKeys("mercure123");
        PearlyHomePage.loginButton.click();

        WaitUtils.waitFor(4);
        ReusableMethods reusableMethods = new ReusableMethods();
        PearlyHomePage.electronicsElements.click();
        WaitUtils.waitFor(7);

        WishListPage wishListPage= new WishListPage();
        wishListPage.wishlist2.click();
        WaitUtils.waitFor(5);
        ReusableMethods.scrollDownActions();
        WaitUtils.waitFor(4);
        WaitUtils.waitFor(5);
        JSUtils.clickWithTimeoutByJS(wishListPage.Wishlist2button);
        WaitUtils.waitFor(7);
        JSUtils.clickWithTimeoutByJS(wishListPage.MainWishListButton);
        WaitUtils.waitFor(7);
        JSUtils.clickWithTimeoutByJS(wishListPage.Quickview);
        WaitUtils.waitFor(7);
    }
}