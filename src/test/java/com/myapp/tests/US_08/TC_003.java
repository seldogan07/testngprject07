package com.myapp.tests.US_08;

import com.myapp.pages.ComparePage;
import com.myapp.pages.PearlyMarketHomePage;
import com.myapp.pages.WishListPage;
import com.myapp.utilities.*;
import org.testng.annotations.Test;

public class TC_003 {
    //1_ Go to https://pearlymarket.com/
    //2_ click on Sign in
    //3_ Enter valid username and password
    //4_ Click Book&Music&Film
    //5_Click first product
    //6_Click wishlist buttons on the first product
    //7_Click the wishlist button on the page
    //8_Click Add to Card
    //9_Click Card section on the page
    //10_Click Checkout
    //11_ Fill all the Billing Details
    //12_Click Pay at the door
    //13_ Click Place Order
    @Test
    public void wishListTest3() throws InterruptedException {

        PearlyMarketHomePage PearlyHomePage = new PearlyMarketHomePage();
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_homepage_url"));
        PearlyHomePage.homepageSignInButton.click();
        PearlyHomePage.usernameBox.sendKeys("mercure");
        PearlyHomePage.passwordBox.sendKeys("mercure123");
        PearlyHomePage.loginButton.click();
        WaitUtils.waitFor(6);

        ReusableMethods reusableMethods = new ReusableMethods();
        WishListPage wishlist = new WishListPage();

        JSUtils.clickWithTimeoutByJS(wishlist.Bookssection);
        WaitUtils.waitFor(4);
        JSUtils.clickWithTimeoutByJS(wishlist.firstitem);
        WaitUtils.waitFor(4);
        JSUtils.clickWithTimeoutByJS(wishlist.firstitemwishclick);
        WaitUtils.waitFor(6);

        JSUtils.clickWithTimeoutByJS(wishlist.WishMainButton);
        WaitUtils.waitFor(4);

        // BUG : Add to card' buttonu çalışmıyor tekrar ürün sayfasına yönlendiriyor.
        JSUtils.clickWithTimeoutByJS(wishlist.addToCard);
        WaitUtils.waitFor(4);




    }
}
