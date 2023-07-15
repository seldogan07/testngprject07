package com.myapp.tests.US_08;

import com.myapp.pages.ComparePage;
import com.myapp.pages.PearlyMarketHomePage;
import com.myapp.pages.WishListPage;
import com.myapp.utilities.*;
import org.testng.annotations.Test;

public class TC_001 {
    //1_ Go to https://pearlymarket.com/
    //2_ click on Sign in
    //3_ Enter valid username and password
    //4_Click Electronics
    //5_ Click first item on the page
    //6_Click wishlist buttons on the first product
    //7_Click wishlist buttons on the second product
    //8_Click wishlist buttons on the third product
    //9_Click the wishlist button on the page
    @Test
    public void wishListTest1() throws InterruptedException {

        PearlyMarketHomePage PearlyHomePage = new PearlyMarketHomePage();
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_homepage_url"));
        PearlyHomePage.homepageSignInButton.click();
        PearlyHomePage.usernameBox.sendKeys("mercure");
        PearlyHomePage.passwordBox.sendKeys("mercure123");
        PearlyHomePage.loginButton.click();
        WaitUtils.waitFor(6);
        ReusableMethods reusableMethods = new ReusableMethods();
        PearlyHomePage.electronicsElements.click();
        WaitUtils.waitFor(9);

        ComparePage comparePage= new ComparePage();
        comparePage.compare1.click();
        WaitUtils.waitFor(9);

        WishListPage wishlist = new WishListPage();
        JSUtils.clickWithTimeoutByJS(wishlist.Wishclick);
        WaitUtils.waitFor(4);

        // Back to previous page
        Driver.getDriver().navigate().back();
        WaitUtils.waitFor(3);

        comparePage.compare2.click();
        WaitUtils.waitFor(3);

        JSUtils.clickWithTimeoutByJS(wishlist.Wishclick2);
        WaitUtils.waitFor(4);
        // Back to previous page
        Driver.getDriver().navigate().back();
        WaitUtils.waitFor(3);

        comparePage.compare3.click();
        WaitUtils.waitFor(4);
        JSUtils.clickWithTimeoutByJS(wishlist.Wishclick2);
        WaitUtils.waitFor(7);

        JSUtils.clickWithTimeoutByJS(wishlist.WishMainButton);
        WaitUtils.waitFor(4);
    }
}
