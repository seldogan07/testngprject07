package com.myapp.pages;

import com.myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PearlyMarketAddProductPage {

    public PearlyMarketAddProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="//select[@id='product_type']")
    public WebElement dropdownProductTypeElement;

    @FindBy(xpath="//option[@value='simple']")
    public WebElement dropdownSimpleProductElement;

    @FindBy(xpath="//option[@value='variable']")
    public WebElement dropdownVariableProductElement;

    @FindBy(xpath="//option[@value='grouped']")
    public WebElement dropdownGroupedProductElement;

    @FindBy(xpath="//option[@value='external']")
    public WebElement dropdownExternalProductElement;

    @FindBy(xpath="//select[@id='product_type']")
    public WebElement simpleProductButton;

    @FindBy(xpath="//input[@id='is_virtual']")
    public WebElement virtualBox;

    @FindBy(xpath="//input[@id='is_downloadable']")
    public WebElement downloadableBox;

    @FindBy(xpath="//input[@id='regular_price']")
    public WebElement priceBox;

    @FindBy(xpath="//input[@id='sale_price']")
    public WebElement salePriceBox;

    @FindBy(xpath="//input[@id='pro_title']")
    public WebElement productTitleBox;

    @FindBy(xpath="//input[@data-super_parent='226']")
    public WebElement kitchenButton;


}
