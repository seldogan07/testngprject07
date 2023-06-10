package com.myapp.tests.US_16;

import com.myapp.pages.PearlyMarketAddProductPage;
import com.myapp.pages.PearlyMarketHomePage;
import com.myapp.pages.PearlyMarketMyAccountPage;
import com.myapp.utilities.Driver;
import com.myapp.utilities.MediaUtils;
import com.myapp.utilities.ReusableMethods;
import com.myapp.utilities.WaitUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

public class TC_06 {

    ReusableMethods reusableMethods = new ReusableMethods();
    MediaUtils takeScreenShot = new MediaUtils();
    PearlyMarketHomePage pmHomePage = new PearlyMarketHomePage();

    PearlyMarketMyAccountPage pearlyMarketMyAccountPage = new PearlyMarketMyAccountPage();

    PearlyMarketAddProductPage pearlyMarketAddProductPage = new PearlyMarketAddProductPage();

    JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();


    @Test
    public void addSimpleProductAsAVendor() throws IOException {

///        1_Go to https://pearlymarket.com/
        reusableMethods.signIn();

//        2_User should navigate to Store Manager
        reusableMethods.scrollPageEndActions();
        pmHomePage.myAccountButton.click();
        pmHomePage.storeManagerButton.click();
        pmHomePage.myStoreProductsElement.click();

//        3_Click on Product button
        reusableMethods.hoverOverOnElementActions(pmHomePage.myStoreProductsElement);


//        4_Click on Add New button and fill necessary fields
        pmHomePage.productsAddnewElement.click();


        pearlyMarketAddProductPage.virtualBox.click();
//        pearlyMarketAddProductPage.downloadableBox.click();
        pearlyMarketAddProductPage.priceBox.sendKeys("10");
        pearlyMarketAddProductPage.salePriceBox.sendKeys("10");
        pearlyMarketAddProductPage.productTitleBox.sendKeys("Apple");

        //Add photo

        executor.executeScript("arguments[0].click();", pearlyMarketAddProductPage.featuredImageBox);
        pearlyMarketAddProductPage.mediaLibrarySection.click();
        pearlyMarketAddProductPage.chooseImageSelectButton.click();
        executor.executeScript("arguments[0].click();", pearlyMarketAddProductPage.selectButtonInMediaLibrary);

        reusableMethods.scrollDownActions();
        executor.executeScript("arguments[0].click();", pearlyMarketAddProductPage.galaryImageBox);
        executor.executeScript("arguments[0].click();", pearlyMarketAddProductPage.mediaLibrarySectionForGalary);
        pearlyMarketAddProductPage.chooseImageStoolImage.click();
        executor.executeScript("arguments[0].click();", pearlyMarketAddProductPage.addToGalaryButton);


        reusableMethods.scrollDownActions();
        reusableMethods.scrollDownActions();
        executor.executeScript("arguments[0].click();", pearlyMarketAddProductPage.adidasProductBrandTickBox);


        executor.executeScript("arguments[0].click();", pearlyMarketAddProductPage.applephoneCheckboxInCategories);



        //product title
        reusableMethods.scrollIntoView(pearlyMarketAddProductPage.productTitleBox);

        pearlyMarketAddProductPage.productTitleBox.sendKeys("Stool");

        Driver.getDriver().switchTo().frame(pearlyMarketAddProductPage.shortDescriptionIFrame);
        pearlyMarketAddProductPage.shortDescriptionTextBox.sendKeys("Round 4-Leg Stool");

        Driver.getDriver().switchTo().parentFrame();   // to switch out of the previous iframe

        Driver.getDriver().switchTo().frame(pearlyMarketAddProductPage.descriptionIFrame);
        pearlyMarketAddProductPage.descriptionTextBox.sendKeys("It is a round brown stool with 4 legs in light brown");


        takeScreenShot.takeScreenshotOfTheEntirePage();
//        reusableMethods.scrollDownActions();
//        executor.executeScript("arguments[0].click();", pearlyMarketAddProductPage.downloadableButton);
//        pearlyMarketAddProductPage.downloadableNameTextArea.sendKeys("Apple");
//        pearlyMarketAddProductPage.downloadableFileTextArea.sendKeys("Apple");



//       5_Then user should click on SUBMIT Button
//        reusableMethods.scrollDownActions();
////        reusableMethods.scrollDownActions();
        reusableMethods.scrollDownActions();
        reusableMethods.scrollIntoView(pearlyMarketAddProductPage.submitButton);

        executor.executeScript("arguments[0].click();", pearlyMarketAddProductPage.submitButton);

        //pearlyMarketAddProductPage.addProductSubmitButton.click();



//      6_Then user should see Edit Product(Published) on the page
        reusableMethods.scrollUpActions();
        reusableMethods.scrollUpActions();
        assertTrue(pearlyMarketAddProductPage.publishedText.getText().contains("Published"));
        takeScreenShot.takeScreenshotOfTheEntirePage();




    }
}