package com.myapp.tests.US_14;

import com.myapp.pages.PearlyMarketAddProductPage;
import com.myapp.pages.PearlyMarketHomePage;
import com.myapp.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_01 {

    ReusableMethods reMethods = new ReusableMethods();
    PearlyMarketHomePage pmHomePage = new PearlyMarketHomePage();
    PearlyMarketAddProductPage pmAddProductPage = new PearlyMarketAddProductPage();

    @Test
    public void addNewProductMenuTest(){
        reMethods.signIn();
        reMethods.scrollPageEndActions();

        // reMethods.waitForVisibility(pmHomePage.myAccountButton, 11);
        pmHomePage.myAccountButton.click();
        pmHomePage.storeManagerButton.click();
        pmHomePage.myStoreProductsElement.click();
        reMethods.hoverOverOnElementActions(pmHomePage.myStoreProductsElement);
        pmHomePage.productsAddnewElement.click();

        pmAddProductPage.dropdownProductTypeElement.click();
        Assert.assertTrue(pmAddProductPage.dropdownSimpleProductElement.isDisplayed());
        Assert.assertTrue(pmAddProductPage.dropdownVariableProductElement.isDisplayed());
        Assert.assertTrue(pmAddProductPage.dropdownGroupedProductElement.isDisplayed());
        Assert.assertTrue(pmAddProductPage.dropdownExternalProductElement.isDisplayed());

    }

}