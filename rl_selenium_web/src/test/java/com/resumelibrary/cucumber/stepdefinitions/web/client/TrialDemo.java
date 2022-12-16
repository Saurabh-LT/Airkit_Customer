package com.resumelibrary.cucumber.stepdefinitions.web.client;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.client.TrialDemoPage;
import io.cucumber.java.en.And;

public class TrialDemo extends Utility {

    @And("I select {string} from approx hires")
    public void iSelectFromApproxHires(String hires) {
        new TrialDemoPage().selectFromApproxHires(hires);
    }
}