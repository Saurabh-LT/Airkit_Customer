package com.resumelibrary.cucumber.stepdefinitions.web.candidate;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.candidate.EmailPreferencesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class EmailPreferences extends Utility {

    @Then("I fill in {string} keyword to create job alert")
    public void iFillInKeywordToCreateJobAlert(String keyword) {
        new EmailPreferencesPage().enterKeywordToCreateJobAlert(keyword);
    }

    @And("I fill in {string} location to create job alert")
    public void iFillInLocationToCreateJobAlert(String location) {
        new EmailPreferencesPage().enterLocationToCreateJobAlert(location);
    }

    @And("I click on update profile button")
    public void iClickOnUpdateProfileButton() {
        new EmailPreferencesPage().clickOnUpdateProfileButton();
    }

    @When("I untick Job alerts")
    public void iUntickJobAlerts() {
        new EmailPreferencesPage().untickJobAlerts();
    }

    @And("I Click on Save changes")
    public void iClickOnSaveChanges() {
        new EmailPreferencesPage().clickOnUpdateProfileButton();
    }

    @When("I untick Updates")
    public void iUntickUpdates() {
        new EmailPreferencesPage().untickUpdates();
        waitFor(1);
    }

    @When("I untick unsubscribes from all emails")
    public void iUnTickUnsubscribesFromAllEmails() {
        new EmailPreferencesPage().verifyUnsubscribeAllEmails();
    }

    @And("I should see job alerts is ticked")
    public void iShouldSeeJobAlertsIsTicked() {
        new EmailPreferencesPage().verifyJobAlertsIsSelected();
    }

    @And("I should see updates is ticked")
    public void iShouldSeeUpdatesIsTicked() {
        new EmailPreferencesPage().verifyJobAlertsIsSelected();
    }

    @And("I save to default selections")
    public void iSaveToDefaultSelections() {
        new EmailPreferencesPage().saveToDefaultSelections();
    }

    @And("I tick Job alerts")
    public void iTickJobAlerts() {
        new EmailPreferencesPage().tickJobAlerts();
    }

    @And("I tick updates")
    public void iTickUpdates() {
        new EmailPreferencesPage().tickUpdate();
    }

    @Then("I click on job application confirmation individual")
    public void iClickOnJobApplicationConfirmationIndividual() {
        new EmailPreferencesPage().clickOnJobApplicationConfirmIndividual();
    }

    @Then("I click on job application confirmation combined")
    public void iClickOnJobApplicationConfirmationCombined() {
        new EmailPreferencesPage().clickOnJobApplicationConfirmCombined();
    }

    @Then("I click on job alerts confirmation individual")
    public void iClickOnJobAlertsConfirmationIndividual() {
        new EmailPreferencesPage().clickOnJobJobAlertsIndividual();
    }

    @Then("I click on job alerts confirmation combined")
    public void iClickOnJobAlertsConfirmationCombined() {
        new EmailPreferencesPage().clickOnJobJobAlertsCombined();
    }
}