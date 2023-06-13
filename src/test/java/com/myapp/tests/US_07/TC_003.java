package com.myapp.tests.US_07;

import com.myapp.pages.ComparePage;
import com.myapp.pages.PearlyMarketHomePage;
import com.myapp.utilities.*;
import org.testng.annotations.Test;

import java.util.jar.JarEntry;

public class TC_003 {
    //1_ Go to https://pearlymarket.com/
    //2_Click see all button on Trending section
    //3_ Click first items compare button
    //4_Close the pop-up.
    //5_Click the second items compare button
    //6_Close the pop-up.
    //7_Click Start Compare button on the pop-up
    @Test
    public void compareTest3() throws InterruptedException {

        PearlyMarketHomePage PearlyHomePage = new PearlyMarketHomePage();
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_homepage_url"));

        ReusableMethods reusableMethods = new ReusableMethods();
        ComparePage comparePage= new ComparePage();
        JSUtils.clickWithTimeoutByJS(comparePage.clicktrend);
        WaitUtils.waitFor(4);
        comparePage.trend1.click();
        WaitUtils.waitFor(7);
        //BUG : Compare Button görünür değil!!
        JSUtils.clickWithTimeoutByJS(comparePage.trend1button);
        // Önceki sayfaya geri dön
        Driver.getDriver().navigate().back();
        WaitUtils.waitFor(6);

        comparePage.trend2.click();
        WaitUtils.waitFor(7);
        JSUtils.clickWithTimeoutByJS(comparePage.trend2button);
        WaitUtils.waitFor(6);

        JSUtils.clickWithTimeoutByJS(comparePage.startCompare);
        WaitUtils.waitFor(5);

    }
}