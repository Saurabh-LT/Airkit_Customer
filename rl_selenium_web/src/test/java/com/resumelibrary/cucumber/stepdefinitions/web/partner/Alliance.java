package com.resumelibrary.cucumber.stepdefinitions.web.partner;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.partner.AlliancePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Alliance extends Utility {

    @When("I click Become an Alliance Partner button")
    public void iClickBecomeAnAlliancePartnerButton() {
        new AlliancePage().clickOnBecomeAnAlliancePartnerButton();
    }

    @Then("I click Request a call back button")
    public void iClickRequestACallBackButton() {
        new AlliancePage().clickOnRequestCallBackButton();
    }

    @Then("I fill in the partner form")
    public void iFillInThePartnerForm() {
        new AlliancePage().fillInPartnerForm();
    }

    @When("I click Alliance Partners button")
    public void iClickAlliancePartnersButton() {
        new AlliancePage().clickOnAlliancePartnersButton();
    }
}