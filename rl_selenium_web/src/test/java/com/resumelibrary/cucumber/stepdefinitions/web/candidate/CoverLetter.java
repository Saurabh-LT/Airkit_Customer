package com.resumelibrary.cucumber.stepdefinitions.web.candidate;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.candidate.CoverLetterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CoverLetter extends Utility {

    @Then("I click on edit profile link")
    public void iClickOnEditProfileLink() {
        new CoverLetterPage().clickOnEditProfileLink();
    }

    @Then("I click on my cover letters link")
    public void iClickOnMyCoverLettersLink() {
        new CoverLetterPage().clickOnMyCoverLettersLink();
    }

    @Then("I click on job alert link")
    public void iClickOnJobAlertLink() {
        new CoverLetterPage().clickOnJobAlertLink();
    }

    @Then("I click on application link")
    public void iClickOnApplicationLink() {
        new CoverLetterPage().clickOnApplicationsLink();
    }

    @Then("I click on saved job link")
    public void iClickOnSavedJobLink() {
        new CoverLetterPage().clickOnSavedJobLinks();
    }

    @Then("I click on modify profile")
    public void iClickOnModifyProfile() {
        new CoverLetterPage().clickOnModifyProfileLinks();
    }

    @Then("I click on email preferences link")
    public void iClickOnEmailPreferencesLink() {
        new CoverLetterPage().clickOnEmailPreferencesLinks();
    }

    @When("I enter {string} to edit your cover letter")
    public void iEnterToEditYourCoverLetter(String text) {
        new CoverLetterPage().EnterTextToEditYourCoverLetterField(text);
    }

    @Then("I click on reset button")
    public void iClickOnResetButton() {
        new CoverLetterPage().clickOnResetButton();
    }

    @Then("I click on save changes button")
    public void iClickOnSaveChangesButton() {
        new CoverLetterPage().clickOnSaveChangesButton();
    }

    @And("I click add-cover-letter-toggle")
    public void iClickAddCoverLetterToggle() {
        new CoverLetterPage().clickOnAddCoverLetterToggle();
    }
}