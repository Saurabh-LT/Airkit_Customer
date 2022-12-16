package com.resumelibrary.cucumber.stepdefinitions.web.partner;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.client.OthersPage;
import com.resumelibrary.webtest.partner.PartnersPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Partners extends Utility {

    @When("I click Become a Partner")
    public void iClickBecomeAPartner() {
        new PartnersPage().clickOnBecomeAPartnerButton();
    }

    @And("I click Request a call back")
    public void iClickRequestACallBack() {
        new PartnersPage().clickOnRequestCallBackButton();
    }

    @And("I should see all integrations checkbox is checked")
    public void iShouldSeeAllIntegrationsCheckboxIsChecked() {
        Assert.assertTrue(new PartnersPage().verifyThatAllIntegrationsCheckboxIsSelected(),"[---> All integrations checkbox is unchecked <---]");
    }
    @Then("I should see all integrations checkbox is unchecked")
    public void iShouldSeeAllIntegrationsCheckboxIsUnChecked() {
        Assert.assertTrue(new PartnersPage().verifyThatAllIntegrationsCheckboxIsNotSelected(),"[---> All integrations checkbox is checked <---]");
    }
    @When("I click on ATS Import checkbox")
    public void iClickOnATSImportCheckbox() {
        new PartnersPage().clickATSImportCheckbox();
    }

    @And("I click on video play button in the {string}")
    public void iClickOnVideoPlayButton(String playButton) {
        new PartnersPage().clickOnVideoIntegrationsPage(playButton);
    }
}