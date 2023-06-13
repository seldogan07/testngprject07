package com.myapp.pages;

import com.myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComparePage {

    public ComparePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@data-product-id='14339']")
    public WebElement compare1;

    @FindBy(xpath = "//a[@title='Compare']")
    public WebElement compare1button;

 //   @FindBy(xpath = "//*[@class='compare btn-product-icon'][@data-product_id='14339']")
 //   public WebElement compare1;

    @FindBy(xpath = "//div[@data-product-id='14080']")
    public WebElement compare2;
    @FindBy(xpath = "//a[@title='Compare'][@data-product_id='14080']")
    public WebElement compare2button;

    @FindBy(xpath = "//div[@data-product-id='22412']")
    public WebElement compare3;
    @FindBy(xpath = "//a[@title='Compare'][@data-product_id='22412']")
    public WebElement compare3button;

    @FindBy(xpath = "//div[@class='product-loop product-default content-center product type-product post-21695 status-publish instock product_cat-electronics has-post-thumbnail sale shipping-taxable purchasable product-type-simple']")
    public WebElement compare4;
    @FindBy(xpath = "//a[@title='Compare'][@data-product_id='21695']")
    public WebElement compare4button;

    @FindBy(xpath = "//a[@class='btn btn-dark btn-rounded']")
    public WebElement startCompare;

    @FindBy(xpath = "//div[@data-product-id='14070']")
    public WebElement item1;

    @FindBy(xpath = "//a[@class='compare btn-product-icon']")
    public WebElement item1compare;

    @FindBy(xpath = "//div[@data-product-id='23246']")
    public WebElement item2;

    // BUG!! compare button görünür değil!
    @FindBy(xpath = "//a[@class='compare btn-product-icon']")
    public WebElement item2compare;

    @FindBy(xpath = "(//a[@class='btn-remove remove_from_compare fas fa-times'])[1]")
    public WebElement removeitem;

    @FindBy(xpath = "//a[@class='btn-remove remove_from_compare fas fa-times']")
    public WebElement removeitem2;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div[1]/div/div/div/section/div/div[2]/div/div/div/h2/a")
    public WebElement clicktrend;

    @FindBy(xpath = "//div[@data-product-id='13187']")
    public WebElement trend1;
    // BUG!! compare button görünür değil!
    @FindBy(xpath = "//a[@class='compare btn-product-icon']")
    public WebElement trend1button;

    @FindBy(xpath = "//div[@data-product-id='13178']")
    public WebElement trend2;
    @FindBy(xpath = "//a[@class='compare btn-product-icon']")
    public WebElement trend2button;

}
