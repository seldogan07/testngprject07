package com.myapp.pages;

import com.myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PearlyMarketHomePage {
    public PearlyMarketHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(xpath = "//a//span[.='Register']")
    public WebElement registerButton;

    @FindBy(xpath = "//span[text()='Sign In']")
    public WebElement homepageSignInButton;

    @FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement usernameBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement signinPageSigninButton;

    @FindBy(xpath = "/html/body/div[2]/footer/div/section[2]/div/div[2]/div/section/div/div[2]/div/div[2]/div/nav/ul/li[4]")
    public WebElement myAccountButton;

    @FindBy(xpath = "//a[@href='https://pearlymarket.com/store-manager/']")
    public WebElement storeManagerButton;

    @FindBy(xpath = "(//a[@class='wcfm_menu_item '])[3]")
    public WebElement myStoreProductsElement;

    @FindBy(xpath = "(//span[@class='text'])[18]")
    public WebElement productsAddnewElement;


}