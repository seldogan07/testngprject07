package com.myapp.tests.US_04;


import com.myapp.pages.PearlyMarketHomePage;
import org.testng.annotations.Test;

import static com.myapp.utilities.WaitUtils.waitForVisibility;

public class ShippingAddress {

    @Test
    public void TC_001_Test(){
        //1. Navigate to "My Account" section.


        //2. Go to "Addresses" tab.
        //3. Click on "ADD->" under "Shipping Address" option.
        //4. Enter valid values for First Name, Last Name, Country/Region, Street Address, Town/City, State, and ZIP Code fields.
        //5. Click on "Save Address" button.
        //6. Verify that the Shipping Address is added successfully.
        //7. Ensure that the entered details match the saved address.

    }
}
