package com.resumelibrary.cucumber.stepdefinitions.web.client;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.client.SavedResumesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class SavedResumes extends Utility {

    @And("I should see in Candidate name in asc order")
    public void iShouldSeeInCandidateNameInAscOrder() {
        Assert.assertEquals(new SavedResumesPage().getListOfCandidates(), new SavedResumesPage().ascendingOrderCandidateName());
    }

    @Then("I should see in Candidate name in desc order")
    public void iShouldSeeInCandidateNameInDescOrder() {
        Assert.assertEquals(new SavedResumesPage().getListOfCandidates(), new SavedResumesPage().descendingOrderCandidateName());
    }


    @When("I click on dates saved descending order")
    public void iClickOnDatesSavedDescendingOrder() {
        new SavedResumesPage().clickOnDateSavedDesc();
    }

    @Then("I should see saved dates in desc order")
    public void iShouldSeeSavedDatesInDescOrder() {
        Assert.assertEquals(new SavedResumesPage().getListOfDates(), new SavedResumesPage().descendingOrderDatesSaved());

    }

    @When("I click on dates saved ascending order")
    public void iClickOnDatesSavedAscendingOrder() {
        new SavedResumesPage().clickOnDateSavedAsc();
    }

    @Then("I should see in saved dates in asc order")
    public void iShouldSeeInSavedDatesInAscOrder() {
        Assert.assertEquals(new SavedResumesPage().getListOfDates(), new SavedResumesPage().ascendingOrderDatesSaved());
    }

    @Then("I should see saved by in asc order on account saved resume page")
    public void iShouldSeeSavedByInAscOrderOnAccountSavedResumePage() {
        Assert.assertEquals(new SavedResumesPage().getListOfSavedByNames(), new SavedResumesPage().ascendingOrderSavedByNames());
    }

    @Then("I should see saved by in desc order on account saved resume page")
    public void iShouldSeeSavedByInDescOrderOnAccountSavedResumePage() {
        Assert.assertEquals(new SavedResumesPage().getListOfSavedByNames(), new SavedResumesPage().descendingOrderSavedByNames());
    }
}