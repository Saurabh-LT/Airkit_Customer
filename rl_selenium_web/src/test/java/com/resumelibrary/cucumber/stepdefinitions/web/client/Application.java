package com.resumelibrary.cucumber.stepdefinitions.web.client;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.client.ApplicationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Application extends Utility {

    @When("I click on Action button one")
    public void iClickOnActionButtonOne() {
        new ApplicationPage().clickOnApplicationActions1Btn();
    }

    @And("I click on action view button one")
    public void iClickOnActionViewButtonOne() {
        new ApplicationPage().clickOnApplicationActionsView1Btn();
    }
    @And("I click on application reject button")
    public void iClickOnApplicationRejectButton() {
        new ApplicationPage().clickOnApplicationActionsReject1Btn();
    }

    @Then("I should see job ids in desc order")
    public void iShouldSeeJobIdsInDescOrder() {
        Assert.assertEquals(new ApplicationPage().getListOfJobIds(),new ApplicationPage().jobIdsByDescendingOrder());
    }

    @Then("I should see job ids in asc order")
    public void iShouldSeeJobIdsInAscOrder() {
        Assert.assertEquals(new ApplicationPage().getListOfJobIds(),new ApplicationPage().jobIdsByAscendingOrder());
    }

    @Then("I should see Your Job Ref in desc order")
    public void iShouldSeeYourJobRefInDescOrder() {
        Assert.assertEquals(new ApplicationPage().getListOfJobRef(),new ApplicationPage().jobRefByDescendingOrder());
    }

    @Then("I should see Your Job Ref in asc order")
    public void iShouldSeeYourJobRefInAscOrder() {
        Assert.assertEquals(new ApplicationPage().getListOfJobRef(),new ApplicationPage().jobRefByAscendingOrder());
    }

    @Then("I should see job title in desc order")
    public void iShouldSeeJobTitleInDescOrder() {
        Assert.assertEquals(new ApplicationPage().getListOfJobTitle(),new ApplicationPage().jobTitleByDescendingOrder());
    }

    @Then("I should see job title  in asc order")
    public void iShouldSeeJobTitleInAscOrder() {
        Assert.assertEquals(new ApplicationPage().getListOfJobTitle(),new ApplicationPage().jobTitleByAscendingOrder());
    }

    @Then("I should see candidate name in desc order")
    public void iShouldSeeCandidateNameInDescOrder() {
        Assert.assertEquals(new ApplicationPage().getListOfCandidateName(),new ApplicationPage().candidateNamesByDescendingOrder());
    }

    @Then("I should see candidate name in asc order")
    public void iShouldSeeCandidateNameInAscOrder() {
        Assert.assertEquals(new ApplicationPage().getListOfCandidateName(),new ApplicationPage().candidateNamesByAscendingOrder());
    }

    @Then("I should see candidate email in desc order")
    public void iShouldSeeCandidateEmailInDescOrder() {
        Assert.assertEquals(new ApplicationPage().getListOfCandidateEmail(),new ApplicationPage().candidateEmailByDescendingOrder());
    }

    @Then("I should see candidate email in asc order")
    public void iShouldSeeCandidateEmailInAscOrder() {
        Assert.assertEquals(new ApplicationPage().getListOfCandidateEmail(),new ApplicationPage().candidateEmailByAscendingOrder());
    }

    @Then("I should see date applied in desc order")
    public void iShouldSeeDateAppliedInDescOrder() {
        Assert.assertEquals(new ApplicationPage().getListOfDateApplied(),new ApplicationPage().dateAppliedByDescendingOrder());
    }

    @Then("I should see date applied in asc order")
    public void iShouldSeeDateAppliedInAscOrder() {
        Assert.assertEquals(new ApplicationPage().getListOfDateApplied(),new ApplicationPage().dateAppliedByAscendingOrder());
    }
}