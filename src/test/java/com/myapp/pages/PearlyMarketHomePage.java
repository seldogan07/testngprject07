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


}
