package com.myapp.tests.US_07;

import com.myapp.pages.ComparePage;
import com.myapp.pages.PearlyMarketHomePage;
import com.myapp.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_001 {

    //   1_ Go to https://pearlymarket.com/
    //   2_ click on Sign in
    //   3_ Enter valid username and password
    //   4_ Dropdown electronics
    //   5_ Click phones
    //   6_Click compare buttons on the first product
    //   7_Close the pop-up
    //   8_Click compare buttons on the second product
    //   9_Close the pop-up
    //   10_Click compare buttons on the third product
    //   11_Close the pop-up
    //   12_Click compare buttons on the fourth product
    //   13_Click the Start Compare button.

    @Test
    public void compareTest1() throws InterruptedException {

        PearlyMarketHomePage PearlyHomePage = new PearlyMarketHomePage();
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_homepage_url"));
        PearlyHomePage.homepageSignInButton.click();
        PearlyHomePage.usernameBox.sendKeys("mercure");
        PearlyHomePage.passwordBox.sendKeys("mercure123");
        PearlyHomePage.loginButton.click();

        WaitUtils.waitFor(4);

        ReusableMethods reusableMethods = new ReusableMethods();
        PearlyHomePage.electronicsElements.click();
        WaitUtils.waitFor(4);
    }

    @Test
    public void electronicPage() throws InterruptedException {
        ComparePage comparePage= new ComparePage();
        comparePage.compare1.click();
     //   JSUtils.clickWithTimeoutByJS(comparePage.compare1);
        WaitUtils.waitFor(5);

        JSUtils.clickWithTimeoutByJS(comparePage.compare1button);
       // comparePage.compare1button.click();
        WaitUtils.waitFor(3);

        // Önceki sayfaya geri dön
        Driver.getDriver().navigate().back();
        WaitUtils.waitFor(3);

        comparePage.compare2.click();
        WaitUtils.waitFor(3);
        JSUtils.clickWithTimeoutByJS(comparePage.compare2button);
        WaitUtils.waitFor(2);
        // Önceki sayfaya geri dön
        Driver.getDriver().navigate().back();
        WaitUtils.waitFor(3);

        comparePage.compare3.click();
        WaitUtils.waitFor(2);
        JSUtils.clickWithTimeoutByJS(comparePage.compare3button);
        WaitUtils.waitFor(2);
        // Önceki sayfaya geri dön
        Driver.getDriver().navigate().back();
        WaitUtils.waitFor(5);

     //   Driver.getDriver().navigate().back();
     //   WaitUtils.waitFor(5);

        ReusableMethods.scrollDownActions();
        WaitUtils.waitFor(4);

     //   WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
     //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-loop product-default content-center product type-product post-21695 status-publish instock product_cat-electronics has-post-thumbnail sale shipping-taxable purchasable product-type-simple']")));
       // JSUtils.clickWithTimeoutByJS(comparePage.compare4);
      comparePage.compare4.click();
       // WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Compare'][@data-product_id='21695']")));
        WaitUtils.waitFor(5);
       JSUtils.clickWithTimeoutByJS(comparePage.compare4button);
       WaitUtils.waitFor(5);

       JSUtils.clickWithTimeoutByJS(comparePage.startCompare);
        WaitUtils.waitFor(5);


    }
}
