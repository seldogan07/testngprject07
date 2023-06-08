package com.myapp.tests.US_04_EditibilityOfShippingAddress;


import com.github.javafaker.Faker;
import com.myapp.pages.MyAccountAddressesPage;
import com.myapp.pages.PearlyMarketHomePage;
import com.myapp.pages.PearlyMarketMyAccountPage;
import com.myapp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static com.myapp.utilities.Driver.goToURL;
import static com.myapp.utilities.ExtentReportUtils.flush;
import static com.myapp.utilities.ExtentReportUtils.passAndCaptureScreenshot;
import static com.myapp.utilities.JSUtils.clickWithTimeoutByJS;
import static com.myapp.utilities.ReusableMethods.clickWithTimeOut;
import static com.myapp.utilities.WaitUtils.waitFor;
import static com.myapp.utilities.WaitUtils.waitForVisibility;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TC_003_InvalidZipCodeValidation {
    PearlyMarketHomePage homePage;
    PearlyMarketMyAccountPage myAccountPage;
    MyAccountAddressesPage shippingAddressesPage;
    String username;
    String email;
    String password;
    @Test(priority = 1)
    public void signUpAndSignInTest() throws Exception {
       // Objects and variables creation
        passAndCaptureScreenshot("Signing up and Signing in are beginning ...");
        homePage =new PearlyMarketHomePage();
        username = Faker.instance().name().username();
        email = Faker.instance().internet().emailAddress();
        password = Faker.instance().internet().password();
        // signing up & in
        goToURL("pearlyMarket_homepage_url");
        homePage.homepageRegisterButton.click();
        waitForVisibility(homePage.singUpUsernameBox,5).sendKeys(username);
        homePage.emailBox.sendKeys(email);
        homePage.signUpPasswordBox.sendKeys(password);
        waitForVisibility(homePage.registerPolicy,5).click();
        homePage.signUpButton.click();
        passAndCaptureScreenshot("Signing up and Signing in are done successfully ...");
        waitFor(5);
    }
    String firstName;
    String lastName;
    String streetAddress;
    String cityName;
    String zipCode;
    @Test(priority = 2)
    public void TC_003_Test() throws Exception {
        homePage = new PearlyMarketHomePage();
        myAccountPage = new PearlyMarketMyAccountPage();
        shippingAddressesPage = new MyAccountAddressesPage();
        firstName = Faker.instance().name().firstName();
        lastName = Faker.instance().name().lastName();
        streetAddress = Faker.instance().address().streetAddress();
        cityName = Faker.instance().address().cityName();
        zipCode = Faker.instance().address().zipCode();
        //1. Navigate to "My Account" section.
        passAndCaptureScreenshot("Navigates to 'My Account' section... ");
        WebElement myAccountElement = waitForVisibility(homePage.myAccountButton,15);
        clickWithTimeOut(myAccountElement,15);

        //2. Go to "Addresses" tab.
        passAndCaptureScreenshot("Goes to 'Addresses' tab... ");
        myAccountPage.addressesLink.click();

        //3. Click on "ADD->" under "Shipping Address" option.
        passAndCaptureScreenshot("Clicks on 'ADD->' under 'Shipping Address' option... ");
        WebElement addLink= waitForVisibility(myAccountPage.shippingAddLink,5);
        clickWithTimeOut(addLink,15);
        waitFor(15);

        //4. Enter a valid value for all fields except the ZIP Code field.
        passAndCaptureScreenshot("Enters credentials except ZIP Code field ... ");
        waitForVisibility(shippingAddressesPage.shippingFirstName,5).sendKeys(firstName);
        waitForVisibility(shippingAddressesPage.shippingLastName,5).sendKeys(lastName);
        WebElement dropdownCountryRegion = waitForVisibility(shippingAddressesPage.shippingSelectCountryRegion,15);
        clickWithTimeoutByJS(dropdownCountryRegion);
        Select optionCountryRegion = new Select(dropdownCountryRegion);
        optionCountryRegion.selectByIndex(1);
        String country = optionCountryRegion.getOptions().get(1).getText();
        waitForVisibility(shippingAddressesPage.shippingAddress1,5).sendKeys(streetAddress);
        waitForVisibility(shippingAddressesPage.shippingTownCity,5).sendKeys(cityName);

        //5. Enter an invalid or incorrect ZIP Code.
        passAndCaptureScreenshot("Enters invalid ZIP Code as 'U58759%HF' ... ");
        waitForVisibility(shippingAddressesPage.shippingPostalCodeZip,5).sendKeys("U58759%HF");

        //6. Click on "Save Address" button.
        passAndCaptureScreenshot("Clicks on 'Save Address' button... ");
        WebElement shippingSaveAddressButton =  waitForVisibility(shippingAddressesPage.shippingSaveAddressButton,10);
        clickWithTimeoutByJS(shippingSaveAddressButton);

        //7.Verify that an error message ("Please enter a valid postcode / ZIP.") is displayed for the invalid ZIP Code.
        passAndCaptureScreenshot("Verifies the error message 'Please enter a valid postcode / ZIP.' is displayed for the empty field... ");
        String errorMessage = waitForVisibility(Driver.getDriver().findElement(By.xpath("//ul[@role='alert']")),5).getText();
        System.out.println("errorMessage = " + errorMessage);
        assertEquals("Please enter a valid postcode / ZIP.",errorMessage);

        //8. Ensure that the Shipping Address is not added
        passAndCaptureScreenshot("Ensures that the Shipping Address is not added... ");
        assertTrue(shippingAddressesPage.shippingPostalCodeZip.getText().equals(""));
        passAndCaptureScreenshot("TC_003_Invalid ZIP Code Validation... is done ");
        flush();

        Driver.closeDriver();

    }

}