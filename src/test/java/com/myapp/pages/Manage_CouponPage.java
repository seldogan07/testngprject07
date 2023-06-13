package com.myapp.pages;

import com.myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Manage_CouponPage {
    public Manage_CouponPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id="add_new_coupon_dashboard")
    public WebElement addCouponButton;
    @FindBy(id="title")
    public WebElement couponCode;

    @FindBy(id="description")
    public WebElement couponDescription;
    @FindBy(id="discount_type")
    public WebElement discountType;

    @FindBy(id="coupon_amount")
    public WebElement couponAmount;
    @FindBy(id="expiry_date")
    public WebElement expiryDate;

    @FindBy(xpath = "//td[@data-day='15']")
    public WebElement dateTable;
    @FindBy(id = "wcfm_coupon_manager_submit_button")
    public WebElement submitButton;
    @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table")
    public WebElement dateField;
    @FindBy(id = "free_shipping")
    public WebElement freeShippingCheck;
    @FindBy(id="show_on_store")
    public WebElement showOnStoreCheck;
    @FindBy(xpath = "/html/body/div[1]/main/div/div/div/div/div[1]/div[2]/div[2]/div[2]/h2")
    public WebElement couponList;
    

}
