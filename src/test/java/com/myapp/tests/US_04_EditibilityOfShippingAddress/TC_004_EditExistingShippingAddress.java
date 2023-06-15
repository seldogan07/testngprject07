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
import static com.myapp.utilities.ExtentReportUtils.passAndCaptureScreenshot;
import static com.myapp.utilities.JSUtils.clickWithTimeoutByJS;
import static com.myapp.utilities.ReusableMethods.clickWithTimeOut;
import static com.myapp.utilities.WaitUtils.waitFor;
import static com.myapp.utilities.WaitUtils.waitForVisibility;
import static org.testng.AssertJUnit.assertEquals;

public class TC_004_EditExistingShippingAddress {
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
    static String firstName;
    static String lastName;
    static String streetAddress;
    static String cityName;
    static String zipCode;
    @Test(priority = 2)
    public void TC_003_Test01() throws Exception {
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

        //4. Enter valid values for First Name, Last Name, Country/Region, Street Address, Town/City, County, and ZIP Code fields.
        passAndCaptureScreenshot("Enters credentials (First Name, Last Name etc) ... ");
        waitForVisibility(shippingAddressesPage.shippingFirstName,5).sendKeys(firstName);
        waitForVisibility(shippingAddressesPage.shippingLastName,5).sendKeys(lastName);
        WebElement dropdownCountryRegion = waitForVisibility(shippingAddressesPage.shippingSelectCountryRegion,15);
        clickWithTimeoutByJS(dropdownCountryRegion);
        Select optionCountryRegion = new Select(dropdownCountryRegion);
        optionCountryRegion.selectByIndex(1);
        String country = optionCountryRegion.getOptions().get(1).getText();
        waitForVisibility(shippingAddressesPage.shippingAddress1,5).sendKeys(streetAddress);
        waitForVisibility(shippingAddressesPage.shippingTownCity,5).sendKeys(cityName);
        waitForVisibility(shippingAddressesPage.shippingPostalCodeZip,5).sendKeys(zipCode);

        //5. Click on "Save Address" button.
        passAndCaptureScreenshot("Clicks on 'Save Address' button... ");
        WebElement shippingSaveAddressButton =  waitForVisibility(shippingAddressesPage.shippingSaveAddressButton,10);
        clickWithTimeoutByJS(shippingSaveAddressButton);
        passAndCaptureScreenshot("Shipping Address Credentials saved successfully.... ");
    }
    @Test(priority = 3)
    public void TC_003_Test02() throws Exception {
        homePage = new PearlyMarketHomePage();
        myAccountPage = new PearlyMarketMyAccountPage();
        shippingAddressesPage = new MyAccountAddressesPage();
        firstName = Faker.instance().name().firstName();
        lastName = Faker.instance().name().lastName();
        //1. Navigate to "My Account" section.
        passAndCaptureScreenshot("Navigates to 'My Account' section... ");
        WebElement myAccountElement = waitForVisibility(homePage.myAccountButton,15);
        clickWithTimeOut(myAccountElement,15);

        //2. Go to "Addresses" tab.
        passAndCaptureScreenshot("Goes to 'Addresses' tab... ");
        myAccountPage.addressesLink.click();

        //3. Locate an existing Shipping Address. ( public void TC_003_Test01() METHOD LOCATES EXISTING SHIPPING ADDRESS )
        //4. Click on "EDIT YOUR SHIPPING ADDRESS->" under "Shipping Address" option.
        passAndCaptureScreenshot("Clicks on 'EDIT YOUR SHIPPING ADDRESS->' link");
        WebElement addLink= waitForVisibility(myAccountPage.shippingAddLink,5);
        clickWithTimeOut(addLink,15);
        waitFor(15);

        //5. Make changes to one or more fields (First Name, Last Name, Country/Region, Street Address, Town/City, State, ZIP Code). (First Name and Last Name have been changed)
        passAndCaptureScreenshot("Updates First Name and Last Name");
        waitForVisibility(shippingAddressesPage.shippingFirstName,5).clear();
        waitForVisibility(shippingAddressesPage.shippingFirstName,5).sendKeys(firstName);
        waitForVisibility(shippingAddressesPage.shippingLastName,5).clear();
        waitForVisibility(shippingAddressesPage.shippingLastName,5).sendKeys(lastName);

        //6. Click on "Save Address" button.
        passAndCaptureScreenshot("Clicks on 'Save Address' button... ");
        WebElement shippingSaveAddressButton =  waitForVisibility(shippingAddressesPage.shippingSaveAddressButton,10);
        clickWithTimeoutByJS(shippingSaveAddressButton);

        //7. Verify that the Shipping Address is added successfully.
        passAndCaptureScreenshot("Verifies the success of shipping address addition ... ");
        String successMessage = waitForVisibility(myAccountPage.successAlert,5).getText();
        assertEquals("Address changed successfully.",successMessage);

        //7. Ensure that the entered details match the saved address.
        passAndCaptureScreenshot("Ensures that the entered details match the saved address... ");
        assertEquals(firstName+" "+lastName,Driver.getDriver().findElement(By.xpath("(//td)[4]")).getText());
        passAndCaptureScreenshot("TC_004_Edit Existing Shipping Address... is done ");

        Driver.closeDriver();
    }


}