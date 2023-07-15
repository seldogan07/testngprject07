package com.myapp.tests.US_11;

import com.myapp.pages.*;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import org.testng.annotations.Test;

public class TC_12 {

    @Test
    public void US11_TC12(){

 //    1_Go to https://pearlymarket.com/

        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_homepage_url"));
        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();
        PearlyMarketRegisterPage pearlyMarketRegisterPage = new PearlyMarketRegisterPage();
        PearlyMarketMyAccountPage pearlyMarketMyAccountPage = new PearlyMarketMyAccountPage();
        My_Account_2Page my_account_2Page = new My_Account_2Page();
        AddressesPage addressesPage = new AddressesPage();

//        2_Click on Sign in
        pearlyMarketHomePage.homePageSignInLink.click();

//        3_User should enter Email
        my_account_2Page.userName.sendKeys(ConfigReader.getProperty("PMValidUsername"));

//        4_User should enter the password
        my_account_2Page.password.sendKeys(ConfigReader.getProperty("PMValidPassword"));

//        5_Click on SIGN In button
        my_account_2Page.signIn.click();

//        6_‘My Account’ down on the page should appear

        addressesPage.myAccountDown.click();

        //   7_ Verify that Dashboard and options is visible

        pearlyMarketMyAccountPage.dashboardLink.isDisplayed();
        pearlyMarketMyAccountPage.storeManagerLink.isDisplayed();
        pearlyMarketMyAccountPage.ordersLink.isDisplayed();
        pearlyMarketMyAccountPage.followingsLink.isDisplayed();
        pearlyMarketMyAccountPage.wishlistLink.isDisplayed();

    }
}
