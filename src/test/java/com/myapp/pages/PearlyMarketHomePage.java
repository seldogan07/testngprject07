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
    public WebElement signInButton;

    @FindBy(partialLinkText = "My Account")
    public WebElement myAccountButton;
}
