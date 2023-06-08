package com.myapp.pages;

import com.myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountAddressesPage {
    public MyAccountAddressesPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }
    // **************** SHIPPING ADDRESS WEB ELEMENTS ***************
    @FindBy(xpath = "//input[@id='shipping_first_name']")
    public WebElement shippingFirstName;
    @FindBy(xpath = "//input[@id='shipping_last_name']")
    public WebElement shippingLastName;
    @FindBy(xpath = "//*[@id='shipping_country']")// Dropdown
    public WebElement shippingSelectCountryRegion;
    @FindBy(xpath = "//*[@id='shipping_address_1']")
    public WebElement shippingAddress1;
    @FindBy(xpath = "//*[@id='shipping_state']")// Dropdown
    public WebElement shippingSelectCounty;
    @FindBy(xpath = "//*[@id='shipping_city']")
    public WebElement shippingTownCity;
    @FindBy(xpath = "//*[@id='shipping_postcode']")
    public WebElement shippingPostalCodeZip;
    @FindBy(name = "save_address")
    public WebElement shippingSaveAddressButton;



    // **************** BILLING ADDRESS WEB ELEMENTS ***************



}


