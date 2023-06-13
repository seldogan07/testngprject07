package com.myapp.pages;

import com.myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
    public WishListPage(){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//div[@data-product-id='14080']")
    public WebElement wishlist1;
    @FindBy(xpath = "//a[@data-title='Add to wishlist']")
    public WebElement Wishlist1button;
    @FindBy(xpath = "//div[@data-product-id='22412']")
    public WebElement wishlist2;
    @FindBy(xpath = "//a[@data-product-id='22412']")
    public WebElement Wishlist2button;
    @FindBy(xpath = "//a[@class='wishlist block-type']")
    public WebElement MainWishListButton;
    @FindBy(xpath = "//button[@data-product='22412']")
    public WebElement Quickview;
    @FindBy(xpath = "//a[@class='add_to_wishlist single_add_to_wishlist']")
    public WebElement Wishclick;
    @FindBy(xpath = "(//a[@class='add_to_wishlist single_add_to_wishlist'])[1]")
    public WebElement Wishclick2;
    @FindBy(xpath = "(//a[@class='wishlist block-type'])[1]")
    public WebElement WishMainButton;
    @FindBy(xpath = "//*[@id=\"menu-item-3834\"]/a")
    public WebElement Bookssection;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div[4]/ul/li[1]/div/figure/a")
    public WebElement firstitem;
    @FindBy(xpath = "//a[@data-product-id='17550']")
    public WebElement firstitemwishclick;
    @FindBy(xpath = "//*[@id=\"yith-wcwl-row-17550\"]/td[5]/div/a")
    public WebElement addToCard;

}
