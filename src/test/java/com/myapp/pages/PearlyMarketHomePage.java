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
    @FindBy(xpath = "(//a[.='My Account'])[1]")
    public WebElement myAccountButton;

    @FindBy(xpath = "//span[text()='Sign In']")
    public WebElement signInButton;


}
