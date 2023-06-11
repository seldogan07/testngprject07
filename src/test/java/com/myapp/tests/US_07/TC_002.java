package com.myapp.tests.US_07;

import com.myapp.pages.ComparePage;
import com.myapp.pages.PearlyMarketHomePage;
import com.myapp.utilities.*;
import org.testng.annotations.Test;

public class TC_002 {
    //1_ Go to https://pearlymarket.com/
    //2_ click on Sign in
    //3_ Enter valid username and password
    //4_ Click Men Category
    //5_Click First item
    //6_Click First item compare button.
    //7_Close the pop-up
    //8_Go Back Page
    //9_Click second item
    //10_ Click second item compare button
    //11_ Remove first item from compare page.

    @Test
    public void compareTest2(){
        PearlyMarketHomePage PearlyHomePage = new PearlyMarketHomePage();
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_homepage_url"));
        PearlyHomePage.homepageSignInButton.click();
        PearlyHomePage.usernameBox.sendKeys("mercure");
        PearlyHomePage.passwordBox.sendKeys("mercure123");
        PearlyHomePage.loginButton.click();

        WaitUtils.waitFor(4);

        ReusableMethods reusableMethods = new ReusableMethods();
        PearlyHomePage.MenElements.click();
        WaitUtils.waitFor(6);

        ComparePage comparePage= new ComparePage();
        comparePage.item1.click();
        WaitUtils.waitFor(7);
        JSUtils.clickWithTimeoutByJS(comparePage.item1compare);
        WaitUtils.waitFor(6);

        // Önceki sayfaya geri dön
        Driver.getDriver().navigate().back();
        WaitUtils.waitFor(7);

        comparePage.item2.click();
        WaitUtils.waitFor(7);

        // BUG!! compare button görünür değil!
        JSUtils.clickWithTimeoutByJS(comparePage.item2compare);
        WaitUtils.waitFor(6);

        JSUtils.clickWithTimeoutByJS(comparePage.removeitem);
        WaitUtils.waitFor(5);

    }
}
