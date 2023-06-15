package com.myapp.tests.US_06_ToBeAbleToShopOnTheSite;


import com.myapp.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static com.myapp.utilities.Driver.goToURL;
import static com.myapp.utilities.WaitUtils.waitForVisibility;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;


@Test
public class TC_001_FindDesiredProductInTheSearchBox {


    String product ="IPHONE";

    public void navigateToShippingPage(){
        //1. Open the application in the provided URL.
        goToURL("pearlyMarket_homepage_url");
        //2. Enter a specific product name or keyword in the search box.
        WebElement searchBox = Driver.getDriver()
                .findElement(By.xpath("(//input[@type='search'])[1]"));
        waitForVisibility(searchBox,15).sendKeys(product);
        //3. Click the search button or press Enter.
        searchBox.submit();
        //4. Verify if the search results display the desired product.
        String errorMessage = "No products were found matching your selection.";
        String expectedExistence = product;
        String actualExistence = "";

            List<WebElement> mainContent = Driver.getDriver().findElements(By.xpath("//*[@class='product-wrap']"));
            if (mainContent.isEmpty()) {
                actualExistence = errorMessage;
            } else if (!mainContent.isEmpty()) {
                actualExistence = product;
            }else{
                System.out.println("What can I do for you ...");
            }

            assertEquals(expectedExistence,actualExistence);
            Driver.closeDriver();
    }

}
