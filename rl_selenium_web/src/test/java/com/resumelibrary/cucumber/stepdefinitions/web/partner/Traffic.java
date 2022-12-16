package com.resumelibrary.cucumber.stepdefinitions.web.partner;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.partner.TrafficPage;
import io.cucumber.java.en.When;

public class Traffic extends Utility {

    @When("I click Become a Partner button")
    public void iClickBecomeAPartnerButton() {
        new TrafficPage().clickOnBecomeAPartnerButton();
    }

    @When("I click Traffic Partners button")
    public void iClickTrafficPartnersButton() {
        new TrafficPage().clickOnTrafficPartnersButton();
    }
}