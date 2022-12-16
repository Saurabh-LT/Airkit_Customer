package com.resumelibrary.cucumber.stepdefinitions.web.candidate;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.candidate.ResourcesPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Resources extends Utility {

    @When("I mouse hover Resources Navigation menu")
    public void iMouseHoverResourcesMenu() {
        new ResourcesPage().mouseHoverResourcesMenu();
    }

    @Then("I should see text on resources page {string}")
    public void iShouldSeeTextOnResourcesPage(String text) {
        Assert.assertEquals(new ResourcesPage().verifyTextMessageEmailUs(),text);
    }

    @Then("I should see resources-switch-banner {string}")
    public void iShouldSeeResourcesSwitchBanner(String text) {
        new ResourcesPage().verifyResourcesSwitchBanner(text);
    }

    @Given("I am on https url {string}")
    public void iAmOnHttpsUrl(String url) {
        new ResourcesPage().onPage(url);
    }
}