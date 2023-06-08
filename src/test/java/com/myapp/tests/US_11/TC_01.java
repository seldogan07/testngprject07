package com.myapp.tests.US_11;

import com.myapp.pages.My_Account_2Page;
import com.myapp.utilities.ConfigReader;
import com.myapp.utilities.Driver;
import com.myapp.utilities.ReusableMethods;
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class TC_01 {
    My_Account_2Page myAccount2Page;
    Actions actions;

    @Test
    public void US011_TC01() {

        Driver.getDriver().get(ConfigReader.getProperty("pearlyUrl"));








    }



}
