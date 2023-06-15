package com.myapp.tests.US_11;

import com.myapp.pages.My_Account_2Page;
import com.myapp.pages.PearlyMarketHomePage;
import com.myapp.pages.PearlyMarketMyAccountPage;
import com.myapp.pages.PearlyMarketRegisterPage;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import org.testng.annotations.Test;

public class TC_10 {

    @Test
    public void US11_TC10_NGT(){

        //    1_Go to https://pearlymarket.com/

        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_homepage_url"));
        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();
        PearlyMarketRegisterPage pearlyMarketRegisterPage = new PearlyMarketRegisterPage();
        PearlyMarketMyAccountPage pearlyMarketMyAccountPage = new PearlyMarketMyAccountPage();
        My_Account_2Page my_account_2Page = new My_Account_2Page();

//        2_Click on Sign in
        pearlyMarketHomePage.homePageSignInLink.click();

//        3_User should enter Email
        my_account_2Page.userName.sendKeys(ConfigReader.getProperty("PMValidUsername"));

//        4_User should enter the password
        my_account_2Page.password.sendKeys(ConfigReader.getProperty("PMValidPassword"));

//        5_Click on SIGN In button
        my_account_2Page.signIn.click();

//    6. Chatbox on the page could not appear if user does not click Sign out
        pearlyMarketMyAccountPage.followingsLink.isDisplayed();
    }
}



