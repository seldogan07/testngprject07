package com.myapp.pages;

import com.myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Manage_CouponPage {
    public Manage_CouponPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id="title")
    public WebElement couponCode;

    @FindBy(id="description")
    public WebElement couponDescription;

    @FindBy(id="coupon_amount")
    public WebElement couponAmount;

}
