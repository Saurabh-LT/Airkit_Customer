package com.resumelibrary.cucumber.stepdefinitions.web.candidate;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.candidate.SavedJobsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SavedJobs extends Utility {

    @And("I click on save toggle one")
    public void iClickOnSaveToggleOne() {
        new SavedJobsPage().clickOnSaveToggle1();
    }

    @Then("I click on saved job link on saved jobs page")
    public void iClickOnSavedJobLinkOnSavedJobsPage() {
        new SavedJobsPage().clickOnSavedJobLink();
    }

    @And("I click on delete jobs button")
    public void iClickOnDeleteJobButton() {
        new SavedJobsPage().clickOnDeleteJobButton();
    }

    @And("I click on Actions")
    public void iClickOnActions() {
        new SavedJobsPage().clickOnActionsLink();
    }

    @Then("I click on save toggle two")
    public void iClickOnSaveToggleTwo() {
        new SavedJobsPage().clickOnSaveToggle2();
    }

    @Then("I click on save toggle three")
    public void iClickOnSaveToggleThree() {
        new SavedJobsPage().clickOnSaveToggle3();
    }

    @Then("I mouse hover Saved Jobs")
    public void iMouseHoverSavedJobs() {
        new SavedJobsPage().mouseHoverToSavedJobs();
    }

    @When("I click delete button on saved jobs")
    public void iClickDeleteButtonOnSavedJobs() {
        new SavedJobsPage().clickOnSavedJobsBasketDeleteButton();
    }

    @And("I click on saved job button")
    public void iClickOnSavedJobButton() {
        new SavedJobsPage().clickOnSavedJobButton();
    }

    @Then("I click apply now job click event")
    public void iClickApplyNowJobClickEvent() {
        new SavedJobsPage().clickOnApplyNowPartnerJobClickEvent();
    }

    @Then("I delete all saved jobs")
    public void iDeleteAllSavedJobs() {
        iClickOnSavedJobButton();
       if(new SavedJobsPage().selectAllSavedJobs()){
           iClickOnDeleteJobButton();
       }
    }


}