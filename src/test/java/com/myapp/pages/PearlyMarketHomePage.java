package com.myapp.pages;

import com.myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class PearlyMarketHomePage {
    public PearlyMarketHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }
    // ************** LINK TO SIGN IN  / LINK TO REGISTER  **********
    @FindBy(xpath = "//span[text()='Sign In']")
    public WebElement homepageSignInButton;
    @FindBy(xpath = "//span[text()='Register']")
    public WebElement homepageRegisterButton;
/*
       After click to SignIn/Register then ALERT appears.
       And In Alert we have SIGN UP and SIGN IN parts
       */

    // ************** SIGN IN / SIGN UP **********
    @FindBy(xpath = "//input[@id='username']")// for SIGN IN
    public WebElement usernameBox;
    @FindBy(xpath = "//input[@id='reg_username']")// for SIGN UP
    public WebElement singUpUsernameBox;
    @FindBy(xpath = "//input[@id='password']")// for SIGN IN
    public WebElement passwordBox;
    @FindBy(xpath = "//input[@id='reg_password']")// for SIGN UP
    public WebElement signUpPasswordBox;
    @FindBy(xpath = "//input[@id='reg_email']")// for SIGN UP
    public WebElement emailBox;
    @FindBy(id= "rememberme")// for SIGN IN
    public WebElement rememberMe;
    @FindBy(id= "register-policy") // for SIGN UP
    public WebElement registerPolicy; // To select "I agree to the privacy policy"
    @FindBy(xpath = "//button[@name='login']") // for SIGN IN
    public WebElement loginButton;
    @FindBy(xpath = "//button[@name='register']")// for SIGN UP
    public WebElement signUpButton;
   // ******************* MY ACCOUNT LINK **************************

   @FindBy(xpath = "(//*[@href='https://pearlymarket.com/my-account-2/'])[1]") //
   public WebElement myAccountButton;

    //  (//*[@href='https://pearlymarket.com/my-account-2/'])[1]


}



