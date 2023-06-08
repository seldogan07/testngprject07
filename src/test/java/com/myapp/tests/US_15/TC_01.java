package com.myapp.tests.US_15;

import com.myapp.pages.PearlyMarketAddProductPage;
import com.myapp.pages.PearlyMarketHomePage;
import com.myapp.utilities.Driver;
import com.myapp.utilities.ReusableMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/*
1. Go to https://pearlymarket.com/
2. Sign in
3. Go to "Add New" page
4. Scroll down to "tabwrap" (Inventory, Shipping, Attributes, Linked, Seo, Advanced)
5. Inventory menu content holder should be visible
6. Shipping menu content holder should be visible
7. Attributes menu content holder should be visible
8. Linked menu content holder should be visible
9. Seo menu content holder should be visible
10.Advanced menu content holder should be visible
*/

public class TC_01 {

    ReusableMethods reMethods = new ReusableMethods();
    PearlyMarketHomePage pmHomePage = new PearlyMarketHomePage();
    PearlyMarketAddProductPage pmAddProductPage = new PearlyMarketAddProductPage();
    JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();

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
        // reMethods.scrollIntoView(pmAddProductPage.applephoneCheckboxInCategories);
        reMethods.scrollDownActions();
        reMethods.scrollDownActions();
        pmAddProductPage.addNewProductBrandLink.click();
        pmAddProductPage.productBrandsNameBox.click();
        pmAddProductPage.productBrandsNameBox.sendKeys("Abrahams Garden");

        Select selectparentTaxomonyDropdown=new Select(pmAddProductPage.parentTaxomonyDropdown);
        selectparentTaxomonyDropdown.selectByVisibleText("Green Grass");
        pmAddProductPage.newProductAddButton.click();

    }

}