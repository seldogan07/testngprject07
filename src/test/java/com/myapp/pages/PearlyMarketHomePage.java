package com.myapp.pages;

import com.myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PearlyMarketHomePage {
    public PearlyMarketHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    /*
       After click to SignIn/Register then ALERT appears.
       And In Alert we have SIGN UP and SIGN IN parts
       */
    //<<<<<<< HEAD
    @FindBy(xpath = "//span[text()='Sign In']")
    public WebElement homepageSignInButton;
    @FindBy(xpath = "//span[text()='Register']")
    public WebElement homepageRegisterButton;
    //=======

    // ************** SIGN IN / SIGN UP **********
    @FindBy(xpath = "//input[@id='username']")// for SIGN IN & SIGN UP
    public WebElement usernameBox;
    @FindBy(xpath = "//input[@id='password']")// for SIGN IN
    public WebElement passwordBox;
    @FindBy(xpath = "//input[@id='reg_password']")// for SIGN UP
    public WebElement signUpPasswordBox;
    @FindBy(xpath = "//input[@id='reg_email']")// for SIGN UP
    public WebElement emailBox;
    @FindBy(id= "rememberme")// for SIGN IN
    public WebElement rememberMe;
    @FindBy(id= "'register-policy") // for SIGN UP
    public WebElement registerPolicy; // To select "I agree to the privacy policy"
    @FindBy(xpath = "//button[@name='login']") // for SIGN IN
    public WebElement loginButton;
    @FindBy(xpath = "//button[@name='register']")// for SIGN UP
    public WebElement signUpButton;
    // *********************************************
    @FindBy(xpath = "/html/body/div[2]/footer/div/section[2]/div/div[2]/div/section/div/div[2]/div/div[2]/div/nav/ul/li[4]")
    public WebElement myAccountButton;
    @FindBy(xpath = "//a[@href='https://pearlymarket.com/store-manager/']")
    public WebElement storeManagerButton;
    @FindBy(xpath = "(//a[@class='wcfm_menu_item '])[3]")
    public WebElement myStoreProductsElement;
    @FindBy(xpath = "(//span[@class='text'])[18]")
    public WebElement productsAddnewElement;


}
