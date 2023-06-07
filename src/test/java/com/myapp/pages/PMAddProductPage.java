package com.myapp.pages;

import com.myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PMAddProductPage {

    public PMAddProductPage() {
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


}
