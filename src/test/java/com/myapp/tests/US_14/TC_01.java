package com.myapp.tests.US_14;

import com.myapp.pages.PearlyMarketHomePage;
import com.myapp.utilities.ReusableMethods;
import org.testng.annotations.Test;

public class TC_01 {

    ReusableMethods reMethods = new ReusableMethods();
    PearlyMarketHomePage pmHomePage = new PearlyMarketHomePage();

    @Test
    public void addNewProductMenuTest(){
        reMethods.signIn();
    }

}
