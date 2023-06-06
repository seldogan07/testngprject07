package com.myapp.pages;

import com.myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PearlyMarketAddProductPage {

    public PearlyMarketAddProductPage () {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // @FindBy(xpath = "//a//span[.='Register']")
    // public WebElement registerButton;
    @FindBy(xpath="//span[@class='wcfm_sub_menu_items wcfm_sub_menu_items_product_manage moz_class']")
    public WebElement productsAddNewButton;











}
