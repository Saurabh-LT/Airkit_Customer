package com.resumelibrary.cucumber.stepdefinitions.web.candidate;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.candidate.MyDashboardPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MyDashboard extends Utility {

    @When("I click on view link")
    public void iClickOnViewLink() {
        new MyDashboardPage().clickOnViewLink();
    }

    @Then("I click on apply now link")
    public void iClickOnApplyNowLink() {
        new MyDashboardPage().clickOnApplyNowLink();
    }

    @And("I click on recently applied link")
    public void iClickOnRecentlyAppliedLink() {
        new MyDashboardPage().clickOnRecentlyAppliesLink();
    }

    @When("I click on resume review side banner")
    public void iClickOnResumeReviewSideBanner() {
        new MyDashboardPage().clickOnResumeReviewSideBanner();
    }

    @When("I click on search on go banner")
    public void iClickOnSearchOnGoBanner() {
        new MyDashboardPage().clickOnSearchOnGoBannerLink();
    }

    @And("I click on apply send application link")
    public void iClickOnApplySendApplicationLink() {
        new MyDashboardPage().clickOnSendApplicationButton();
    }

    @Then("I should see text Hide Expired Applications label {string}")
    public void iShouldSeeTextHideExpiredApplicationsLabel(String text) {
        Assert.assertEquals(new MyDashboardPage().getTextFromHideExpiredApplicationsLabel(), text);
    }

    @Then("I click on apply now link and I should be able to see in browser URL {string}")
    public void iClickOnApplyNowLinkAndIShouldBeAbleToSeeInBrowserURL(String url) {
        new MyDashboardPage().clickOnApplyNowLink();
    }

    @When("I click on {string} under My Dashboard Section")
    public void iClickOnUnderMyDashboardSection(String linkName) {
        new MyDashboardPage().clickOnUnderMyDashboardSection(linkName);
    }

    @When("I click {string} link on Header Banner")
    public void iClickLinkOnHeaderBanner(String linkName) {
        new MyDashboardPage().clickLinkOnHeaderBanner(linkName);
    }

    @And("I click on {string} edit button")
    public void iClickOnEditButton(String editDetails) {
        new MyDashboardPage().clickOnEditButton(editDetails);

    }
}