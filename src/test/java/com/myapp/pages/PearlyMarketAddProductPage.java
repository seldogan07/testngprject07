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

    @FindBy(xpath="//input[@name='submit-data']") // click after all necessary field fill
    public WebElement submitButton;

    @FindBy(xpath="//span[text()='Published']") // to verify that the product is installed
    public WebElement publishedText;

    @FindBy(xpath="//input[@value='405']")
    public WebElement galaryImageBox;

    @FindBy(xpath="//button[@id='__wp-uploader-id-1']")
    public WebElement addToGalarySelectFileButton;

    @FindBy(xpath="//li[@aria-label='Stool']")
    public WebElement addToGalaryStoolImage;

    @FindBy(xpath="(//div[@class='attachment-preview js--select-attachment type-image subtype-png portrait'])[2]")
    public WebElement chooseImageStoolImage;

    @FindBy(xpath="//button[@class='button media-button button-primary button-large media-button-select']")
    public WebElement addToGalaryButton;

    @FindBy(xpath="//img[@id='featured_img_display']")
    public WebElement featuredImageBox;

    @FindBy(xpath="//button[@id='menu-item-browse']")
    public WebElement mediaLibrarySection;

    @FindBy(xpath="(//button[@class='button media-button button-primary button-large media-button-select'])[2]")
    public WebElement chooseImageSelectButton;


}
