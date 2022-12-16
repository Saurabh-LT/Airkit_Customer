package com.resumelibrary.cucumber.stepdefinitions.web.candidate;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.candidate.JobViewPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class JobView extends Utility {

    @And("I should see Save button")
    public void iShouldSeeSaveButton() {
        new JobViewPage().saveButtonIsDisplay();
    }

    @And("I should see {string} link")
    public void iShouldSeeLink(String text) {
        Assert.assertTrue(isAnchorElementDisplayed(text),"[---> " + text + " is not displayed <---]");
    }

    @And("I click on View button on job view page")
    public void iClickOnViewButtonOnJobViewPage() {
        new JobViewPage().clickOnViewButton();
    }

    @And("I click on recent job title")
    public void iClickOnRecentJobTitle() {
        new JobViewPage().clickOnRecentJobTitle();
    }

    @When("I click on job title one")
    public void iClickOnJobTitleOne() {
        new JobViewPage().clickOnJobTitle1();
    }

    @Then("I should see element with id {string} on the page")
    public void iShouldSeeElementWithIdOnThePage(String id) {
        Assert.assertTrue(new JobViewPage().verifyPageContainsElement(id),"[---> " + id + " element is not displayed <---]");
    }

    @Then("I should not see element with id {string} on the page")
    public void iShouldNotSeeElementWithIdOnThePage(String id) {
        Assert.assertFalse(new JobViewPage().verifyPageContainsElement(id),"[---> " + id + " element is displayed <---]");
    }
}