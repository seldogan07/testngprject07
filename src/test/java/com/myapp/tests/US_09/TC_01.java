package com.myapp.tests.US_09;

import com.myapp.pages.PearlyMarketHomePage;
import com.myapp.pages.PearlyMarketMyAccountPage;
import com.myapp.pages.PearlyMarketRegisterPage;
import com.myapp.pages.PearlyMarketVendorRegisterPage;
import com.myapp.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_01 {

//    1_Go to https://pearlymarket.com/
//    2_Navigate to registration page
//    3_Verify that the Sign Up tab is selected on the Register screen.
//    4_On the Register screen, locate the "Become a Vendor" link and click on
//    5_Enter a valid email address in the email address field
//    6_Verify that “Verification code sent to your email: stevegregor2023@gmail.com.” is visible
//    7_Enter the received verification code in the verification code text box
//    8_Enter a password that meets the requirements (contains uppercase, lowercase, digit, and special characters) in the password field.
//    9_Enter the same password again in the password confirmation field.
//    10_Click on the "Register" button.
//    11_"Registration completed successfully!" message should be visible
//    12_Ensure that the user is redirected to the appropriate Vendor dashboard or landing page.

    @Test
    public void US09_TC01 () throws IOException {

        // 1_Go to https://pearlymarket.com/
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_homepage_url"));

        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();
        PearlyMarketRegisterPage pearlyMarketRegisterPage = new PearlyMarketRegisterPage();
        PearlyMarketVendorRegisterPage pearlyMarketVendorRegisterPage = new PearlyMarketVendorRegisterPage();
        PearlyMarketMyAccountPage pearlyMarketMyAccountPage = new PearlyMarketMyAccountPage();
        String path = "src/test/java/resources/email.xlsx";
        String sheetName="Sheet1";
        ExcelUtils excelUtils = new ExcelUtils(path,sheetName);

        //2_ Navigate to registration page
        JSUtils.clickWithTimeoutByJS(pearlyMarketHomePage.homepageRegisterButton);
        WaitUtils.waitFor(1);

        //3_Verify that the Sign Up tab is selected on the Register screen.
        ReusableMethods.verifyElementClickable(pearlyMarketRegisterPage.signUpLink);

        //4_On the Register screen, locate the "Become a Vendor" link and click on
        pearlyMarketRegisterPage.becomeAVendorLink.click();
//
        //5_Enter a valid email address in the email address field
        pearlyMarketVendorRegisterPage.emailBox.sendKeys(ConfigReader.getProperty("vendorregistermail"));

        //6_Verify that “Verification code sent to your email: stevegregor2023@gmail.com.” is visible
        pearlyMarketVendorRegisterPage.verifCodeBox.click();
        WaitUtils.waitFor(2);
        ReusableMethods.verifyElementDisplayed(pearlyMarketVendorRegisterPage.verificationCodeSentBox);
        MediaUtils.takeScreenshotOfTheEntirePageAsString();

        //7_Enter the received verification code in the verification code text box

//      Open a new Tab, enter the proceed the outlook sign in procees.(NOTE:It causes sth wrong for gmail account)
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get(ConfigReader.getProperty("outlook_login"));
        Driver.getDriver().findElement(By.id("i0116")).sendKeys("abdurraheem.galileo@outlook.com");
        Driver.getDriver().findElement(By.id("idSIButton9")).click();

        WaitUtils.waitFor(2);

        Driver.getDriver().findElement(By.id("i0118")).sendKeys(excelUtils.getCellData(1,1));
        Driver.getDriver().findElement(By.id("idSIButton9")).click();

//      Wait until the verification code will be sent from pearly market
        WaitUtils.waitFor(3);
        Driver.getDriver().navigate().refresh();
        WaitUtils.waitForVisibility(By.xpath("//div//span[@title='info@pearlymarket.com']"),4).click();

        String verifCode=Driver.getDriver().findElement(By.xpath("//div/p/b")).getText();

        ReusableMethods.switchToWindow(0);

        pearlyMarketVendorRegisterPage.verifCodeBox.sendKeys(verifCode);

        MediaUtils.takeScreenshotOfTheEntirePageAsString();

        //8_Enter a password that meets the requirements (contains uppercase, lowercase, digit, and special characters) in the password field.
        pearlyMarketVendorRegisterPage.passwordBox.sendKeys(ConfigReader.getProperty("vendorregisterpass"));

        //9_Enter the same password again in the password confirmation field.
        pearlyMarketVendorRegisterPage.confirmPasswordBox.sendKeys(ConfigReader.getProperty("vendorregisterpass"));

        WaitUtils.waitFor(2);

        //10_Click on the "Register" button.
        JSUtils.clickWithTimeoutByJS(pearlyMarketVendorRegisterPage.registerButton);

        //10_"Registration completed successfully!" message should be visible
        pearlyMarketVendorRegisterPage.registeredMessage.isDisplayed();

        //11_Ensure that the user is redirected to the appropriate Vendor dashboard or landing page.
        WaitUtils.waitForClickablility(pearlyMarketVendorRegisterPage.notRightNowLink,2);
        pearlyMarketMyAccountPage.dashboardLink.isDisplayed();

    }
}
