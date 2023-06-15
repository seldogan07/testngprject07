package com.myapp.tests.US_07;

import com.myapp.pages.ComparePage;
import com.myapp.pages.PearlyMarketHomePage;
import com.myapp.utilities.*;
import org.testng.annotations.Test;

public class TC_004 {
    //1_ Go to https://pearlymarket.com/
    //2_ click on Sign in
    //3_ Enter valid username and password
    //4_ Click electronics
    //5_ Click first item
    //6_Click compare buttons on the first product
    //7_Click the X button for remove item
    //7_Close the pop-up
    @Test
    public void compareTest4() throws InterruptedException {

        PearlyMarketHomePage PearlyHomePage = new PearlyMarketHomePage();
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_homepage_url"));
        PearlyHomePage.homepageSignInButton.click();
        PearlyHomePage.usernameBox.sendKeys("mercure");
        PearlyHomePage.passwordBox.sendKeys("mercure123");
        PearlyHomePage.loginButton.click();

        WaitUtils.waitFor(4);

        ReusableMethods reusableMethods = new ReusableMethods();
        PearlyHomePage.electronicsElements.click();
        WaitUtils.waitFor(6);

        ComparePage comparePage = new ComparePage();
        comparePage.compare1.click();
        WaitUtils.waitFor(5);

        JSUtils.clickWithTimeoutByJS(comparePage.compare1button);
        WaitUtils.waitFor(4);

        JSUtils.clickWithTimeoutByJS(comparePage.removeitem2);
        WaitUtils.waitFor(3);
    }
}