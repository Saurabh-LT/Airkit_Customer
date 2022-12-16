package com.resumelibrary.cucumber.stepdefinitions.web.candidate;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.candidate.JobAlertPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomUtils;

public class JobAlert extends Utility {

    @And("I fill in new user email field with random email id")
    public void iFillInNewUserEmailFieldWithRandomEmailId() {
        String emailText = generateRandomEmail();
        new JobAlertPage().fillInEmail(emailText);
    }

    @When("I click button email me jobs like these")
    public void iClickButtonEmailMeJobsLikeThese() {
        new JobAlertPage().clickOnCreateAlert();
    }

    @And("I fill the fields keywords with {string} and location with {string}")
    public void iFillTheFieldsKeywordsWithAndLocationWith(String keyWords, String location) {
        int number = RandomUtils.nextInt();
        keyWords = keyWords + number;
        new JobAlertPage().enterKeywords(keyWords);
        new JobAlertPage().enterLocation(location);
    }

    @When("I click on Create Job Alerts button")
    public void iClickOnCreateJobAlertsButton() {
        new JobAlertPage().clickJobAlertsButton();
    }

    @And("I fill in Keywords text with {string} and location with {string}")
    public void iFillInKeywordsTextWithAndLocationWith(String keyword, String location) {
        int number = RandomUtils.nextInt();
        keyword = keyword + number;
        new JobAlertPage().enterKeywordAndLocation(keyword, location);
    }

    @And("I select the option {string} from distance")
    public void iSelectTheOptionFromDistance(String radius) {
        new JobAlertPage().enterDistance(radius);
    }

    @And("I click on Create Job Alert button")
    public void iClickOnCreateJobAlertButton() {
        new JobAlertPage().clickOnCreateJobAlert();
    }

    @And("I click on Yes, delete this alert")
    public void iClickOnYesDeleteThisAlert() {
        new JobAlertPage().clickOnDeleteAlert();
    }

    @And("I click on Delete Alert link")
    public void iClickOnDeleteAlertLink() {
        new JobAlertPage().clickOnDelete();
    }

    @Then("I should see text {string} on alert popup")
    public void iShouldSeeTextOnDeleteAlertPopup(String text) {
        new JobAlertPage().verifyTextPopup(text);
    }

    @And("I click on Run Search")
    public void iClickOnRunSearch() {
        new JobAlertPage().clickOnRunSearch();
    }

    @And("I click on Edit Job Alert")
    public void iClickOnEditJobAlert() {
        new JobAlertPage().clickEditJobAlert();
    }

    @When("I fill in edit alert text with random keyword")
    public void iFillInEditAlertTextWithRandomKeyword() {
        String keyword = "Test Manager";
        int number = RandomUtils.nextInt();
        keyword = keyword + number;
        new JobAlertPage().enterEditAlertKeyword(keyword);
    }

    @And("I click Save Changes button on edit alert page")
    public void iClickSaveChangesButtonOnEditAlertPage() {
        new JobAlertPage().clickOnSaveChanges();
    }

    @And("I click on {string} toggle job alert status")
    public void iClickOnActiveToggleJobAlertStatus(String status) {
        new JobAlertPage().clickOnActiveInactiveStatus(status);
    }

    @Then("I click on snooze button")
    public void iClickOnSnoozeButton() {
        new JobAlertPage().clickOnSnoozeButton();
    }

    @And("I click on snoozed toggle job alert status")
    public void iClickOnSnoozedToggleJobAlertStatus() {
        new JobAlertPage().clickOnSnoozed();
    }

    @Then("I click on turn off snooze job alert status")
    public void iClickOnTurnOffSnoozeJobAlertStatus() {
        new JobAlertPage().clickOnUnSnooze();
    }

    @And("I fill in jbe email address with {string}")
    public void iFillInJbeEmailAddressWith(String email) {
        new JobAlertPage().enterSearchResultsJbeEmail(email);
    }

    @And("I fill in jbe password with {string}")
    public void iFillInJbePasswordWith(String password) {
        new JobAlertPage().enterPassword(password);
    }

    @And("I click on Yes, delete this alert on alert popup")
    public void iClickOnYesDeleteThisAlertOnAlertPopup() {
        new JobAlertPage().clickOnDeleteThisAlert();
    }

    @When("I fill in jbe email one with {string}")
    public void iFillInJbeEmailWith( String email) {
        new JobAlertPage().enterEmailOne(email);
    }

    @And("I fill in password one with {string}")
    public void iFillInPasswordOneWith(String password) {
        new JobAlertPage().enterPasswordOne(password);
    }

    @When("I fill in ja email with {string}")
    public void iFillInJaEmailWith(String email) {
        new JobAlertPage().enterJaEmail(email);
    }

    @And("I fill in ja password with {string}")
    public void iFillInJaPasswordWith(String password) {
        new JobAlertPage().enterJaPassword(password);
    }

    @Then("I Click on {string}")
    public void iClickOn(String linkText) {
        new JobAlertPage().ClickOnExampleJobMatchesHeader(linkText);
    }

    @And("I fill in Keywords or JobTitle text with {string}")
    public void iFillInKeywordsOrJobTitleTextWith(String text) throws InterruptedException {
        new JobAlertPage().EnterKeywordOrJobTitle(text);
    }

    @Then("I should see Example Job Matches the Keyword or Job Title Field otherwise it should display {string}")
    public void iShouldSeeExampleJobMatchesTheKeywordOrJobTitleFieldOtherwiseItShouldDisplay(String text) throws InterruptedException {
        new JobAlertPage().CompareExampleJobWithKeyword(text);
    }

    @When("I click on Save Changes Button on Job Alerts Page")
    public void iClickOnSaveChangesButtonOnJobAlertsPage() {
        new JobAlertPage().ClickOnSaveChangesButton();
    }

    @And("I fill in the field where id is {string} with random keyword")
    public void iFillInTheFieldWhereIdIsWithRandomKeyword(String id) {
        fillRandomTextUsingId(id);
    }

    @And("I should see message {string} in the jbe xpath")
    public void iShouldSeeMessageInTheJbeXpath(String text) {
        new JobAlertPage().shouldSeeMessageInJbeXpath(text);
    }
}