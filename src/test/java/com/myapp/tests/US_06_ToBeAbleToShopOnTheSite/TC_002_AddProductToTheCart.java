package com.myapp.tests.US_06_ToBeAbleToShopOnTheSite;


import com.myapp.pages.PearlyMarketAddProductPage;
import com.myapp.pages.PearlyMarketMyAccountPage;
import com.myapp.utilities.Driver;
import com.myapp.utilities.JSUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

import static com.myapp.utilities.Driver.*;
import static com.myapp.utilities.JSUtils.clickWithTimeoutByJS;
import static com.myapp.utilities.ReusableMethods.verifyElementClickable;
import static com.myapp.utilities.WaitUtils.waitFor;
import static com.myapp.utilities.WaitUtils.waitForVisibility;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;


@Test
public class TC_002_AddProductToTheCart {


    String product ="IPHONE";

    public void TC_002_AddProductToTheCart(){
        PearlyMarketAddProductPage addProductPage =new PearlyMarketAddProductPage();
        //1. Open the application in the provided URL.
        goToURL("pearlyMarket_homepage_url");
        //2. Enter a specific product name or keyword in the search box.
        waitForVisibility(addProductPage.searchBox,15).sendKeys(product,Keys.ENTER);
        waitFor(5);
        //3. Click the "Add to Cart" button or link.
        List<WebElement> mainContent = Driver.getDriver().findElements(By.xpath("//h3/a"));
        waitFor(5);
        System.out.println(mainContent.get(3).getText());
        /*
        for (WebElement w: mainContent) {
            if (w.){
                clickWithTimeoutByJS(w);
                clickWithTimeoutByJS(addProductPage.addToCart);
            }
        }

        //4.Verify if the product is successfully added to the cart.

         /*
        PearlyMarketMyAccountPage myAccountPage = new PearlyMarketMyAccountPage();
        String successMessage = myAccountPage.successAlert.getText();

        System.out.println("successMessage = " + successMessage);
        assertTrue(successMessage.contains(product));

                 */
    }

}
