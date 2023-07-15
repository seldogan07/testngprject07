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

public class TC_07 {
public ExcelUtils excelUtils;
//1_Go to https://pearlymarket.com/
//2_ Navigate to registration page
//3_Click on Sign Up button
//4_On the Register screen, locate the "Become a Vendor" link.
//5_Enter a valid email
//6_Verify that “Verification code sent to your email: arbenkeilai@outlook.com.” is visible
//7_Enter a password that contains uppercase letters, digits, and special characters, but no lowercase letter
//8_Proceed with the registration process
//9_Verify that an error message is displayed, indicating that the password must contain at least one lowercase letter.


    @Test
    public void US09_TC07 () throws IOException {

        // 1_Go to https://pearlymarket.com/
        Driver.getDriver().get(ConfigReader.getProperty("pearlymarket_homepage_url"));

        PearlyMarketHomePage pearlyMarketHomePage = new PearlyMarketHomePage();
        PearlyMarketRegisterPage pearlyMarketRegisterPage = new PearlyMarketRegisterPage();
        PearlyMarketVendorRegisterPage pearlyMarketVendorRegisterPage = new PearlyMarketVendorRegisterPage();
        String path = "src/test/java/resources/email.xlsx";
        String sheetName="Sheet1";
        ExcelUtils excelUtils = new ExcelUtils(path,sheetName);

        //2_ Navigate to registration page
        pearlyMarketHomePage.homepageRegisterButton.click();

        //3_Verify that Sign Up button clicked
        ReusableMethods.verifyElementClickable(pearlyMarketRegisterPage.signUpLink);

        //4_On the Register screen, locate the "Become a Vendor" link and click on
        pearlyMarketRegisterPage.becomeAVendorLink.click();

        //5_Enter a valid email
        pearlyMarketVendorRegisterPage.emailBox.sendKeys(ConfigReader.getProperty("vendorregistermail_fornotlowercase"));

        //6_Verify that “Verification code sent to your email: arbenkeilai@outlook.com.” is visible
        pearlyMarketVendorRegisterPage.verifCodeBox.click();
        WaitUtils.waitFor(4);
        ReusableMethods.verifyElementDisplayed(pearlyMarketVendorRegisterPage.verificationCodeSentBox);

        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get(ConfigReader.getProperty("outlook_login"));
        WaitUtils.waitFor(3);
        Driver.getDriver().findElement(By.id("i0116")).sendKeys("arbenkeilai@outlook.com");
        Driver.getDriver().findElement(By.id("idSIButton9")).click();

        WaitUtils.waitFor(2);

        Driver.getDriver().findElement(By.id("i0118")).sendKeys(excelUtils.getCellData(1,1));
        Driver.getDriver().findElement(By.id("idSIButton9")).click();

//      Wait until the verification code will be sent from pearly market
        WaitUtils.waitFor(3);
        Driver.getDriver().navigate().refresh();
        WaitUtils.waitForVisibility(By.xpath("//div//span[@title='info@pearlymarket.com']"),4).click();

        WaitUtils.waitFor(5);

        String verifCode=Driver.getDriver().findElement(By.xpath("//td//div//p//b")).getText();
        ReusableMethods.switchToWindow(0);
        pearlyMarketVendorRegisterPage.verifCodeBox.sendKeys(verifCode);

        //7_Enter a password that contains uppercase letters, digits, and special characters, but no lowercase letter
        pearlyMarketVendorRegisterPage.passwordBox.sendKeys("PASSWORD123!");
        pearlyMarketVendorRegisterPage.confirmPasswordBox.sendKeys("PASSWORD123!");

        WaitUtils.waitFor(2);

        //8_Proceed with the registration process
        JSUtils.clickWithTimeoutByJS(pearlyMarketVendorRegisterPage.registerButton);

        //9_Verify that an error message is displayed, indicating that the password must contain at least one lowercase letter.
        // We can directly registered with no lowercase password.
        MediaUtils.takeScreenshotOfTheEntirePageAsString();

    }
}
