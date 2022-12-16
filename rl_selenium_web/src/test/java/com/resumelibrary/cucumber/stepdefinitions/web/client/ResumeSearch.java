package com.resumelibrary.cucumber.stepdefinitions.web.client;

import com.resumelibrary.cucumber.stepdefinitions.web.candidate.Others;
import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.client.OthersPage;
import com.resumelibrary.webtest.client.ResumeSearchPage;
import com.resumelibrary.webtest.misc.MiscPage;
import com.sun.xml.bind.v2.runtime.SwaRefAdapter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ResumeSearch extends Utility {

    @When("I enter saved search name with {string}")
    public void iEnterSavedSearchNameWith(String searchName) {
        new ResumeSearchPage().enterSavedSearchName(searchName);
    }

    @And("I click on Save search submit button")
    public void iClickOnSaveSearchSubmitButton() {
        new ResumeSearchPage().clickOnSaveSearch();
    }

    @And("I click on save search delete btn")
    public void iClickOnSaveSearchDeleteBtn() {
        new ResumeSearchPage().clickOnSaveSearchDeleteBtn();
    }

    @And("I click on saved search actions one")
    public void iClickOnSavedSearchActionsOne() {
        new ResumeSearchPage().clickOnSavedSearchActionsOne();
    }

    @And("I click on run saved search one")
    public void iClickOnRunSavedSearchOne() {
        new ResumeSearchPage().clickOnRunSavedSearchOne();
    }

    @And("I sort the saved searches names in ascending order")
    public void iSortTheSavedSearchesNamesInAscendingOrder() {
        new ResumeSearchPage().sortByNameInAscendingOrder();
    }

    @And("I sort the saved searches names in descending order")
    public void iSortTheSavedSearchesNamesInDescendingOrder() {
        new ResumeSearchPage().sortByNameInDescendingOrder();
    }

    @And("I sort the saved searches keywords in descending order")
    public void iISortTheSavedSearchesKeywordsInDescendingOrder() {
        new ResumeSearchPage().sortByKeywordsInDescendingOrder();
    }

    @And("I sort the saved searches keywords in ascending order")
    public void iISortTheSavedSearchesKeywordsInAscendingOrder() {
        new ResumeSearchPage().sortByKeywordsInAscendingOrder();
    }

    @And("I should see text in location field {string}")
    public void iShouldSeeTextInLocationField(String locationText) {
        Assert.assertEquals(locationText, new ResumeSearchPage().verifyLocationField(locationText));
    }

    @Then("I click on tab Saved searches")
    public void iClickOnTabSavedSearches() {
        new ResumeSearchPage().clickOnTabSavedSearches();
    }

    @Then("I should see run search text {string}")
    public void iShouldSeeButtonRunSearch(String buttonText) {
        Assert.assertEquals(new ResumeSearchPage().verifyButtonText(buttonText), buttonText);
    }

    @When("I click on Run Search button")
    public void iClickOnRunSearchButton() {
        new ResumeSearchPage().clickOnRunSearch();
    }

    @When("I enter search builder keywords text area with {string} to autocomplete")
    public void iEnterSearchBuilderKeywordsTextAreaWithToAutocomplete(String text) {
        new ResumeSearchPage().enterSearchBuilderKeywordsTextAreaWithToAutocomplete(text);
    }

    @And("I hover from autocomplete for keywords textarea input for the option {string}")
    public void iHoverFromAutocompleteForKeywordsTextareaInputForTheOption(String autoCompleteText)  {
        new ResumeSearchPage().hoverToAutocomplete(autoCompleteText);
    }

    @When("I mouse hover Resume Unlocked")
    public void iMouseHoverResumeUnlocked() {
        new ResumeSearchPage().mouseHoverResumeUnlocked();
    }

    @Given("I login as a client with no credits")
    public void iLoginAsAClientWithNoCredits() {
        new MiscPage().loginAsAClientWithNoCredits();
    }

    @And("I should see text {string} and {string}")
    public void iShouldSeeTextAnd(String text1, String text2) {
        new ResumeSearchPage().verifyText(text1, text2);
    }

    @And("I should see value {string} in search builder keywords")
    public void iShouldSeeValueInSearchBuilderKeywords(String text) {
        new ResumeSearchPage().verifyValueInSearchBuilderKeywords(text);
    }

    @Then("I should see element {string} is disabled")
    public void iShouldSeeElementIsDisabled(String text) {
        new ResumeSearchPage().verifyElementIsDisabled(text);
    }

    @Then("I should see element {string} is not disabled")
    public void iShouldSeeElementIsNotDisabled(String text) {
        new ResumeSearchPage().verifyElementIsEnabled(text);
    }

    @Then("I should see table action {string} button is disabled")
    public void iShouldSeeTableActionButtonIsDisabled(String text) {
        new ResumeSearchPage().verifyTableActionButtonIsDisabled(text);
    }

    @Then("I toggle action button status")
    public void iToggleActionButtonStatus() {
        new ResumeSearchPage().toggleActionButtonStatus();
    }

    @Then("I deactivate all active alerts")
    public void iDeactivateAllActiveAlerts() {
       new ResumeSearchPage().deactivateAllActiveAlerts();
    }

    @And("I click on actions button one")
    public void iClickOnActionsButtonOne() {
        new ResumeSearchPage().clickOnActionsButtonOne();
    }

    @And("I click on resume alert Search")
    public void iClickOnResumeAlertSearch() {
        new ResumeSearchPage().clickOnTableActionSearch();
    }

    @And("I enter alert name with {string}")
    public void iEnterAlertNameWith(String alertName) {
        new ResumeSearchPage().enterAlertName(alertName);
    }

    @Then("I click on resume Create Alert")
    public void iClickOnResumeCreateAlert() {
        new ResumeSearchPage().clickOnCreateAlert();
    }

    @Then("I should see all elements for {string} class")
    public void iShouldSeeAllElementsForClass(String elementClass) {
        new ResumeSearchPage().findElementsWithClass(elementClass);
    }

/*    @And("I hover from autocomplete for keywords textarea and select {string}")
    public void iHoverFromAutocompleteForKeywordsTextareaAndSelect(String text)  {
        new ResumeSearchPage().hoverToAutoCompleteAndSelectAll(text);
    }*/

    @And("I check show me unlocked candidates only")
    public void iCheckShowMeUnlockedCandidatesOnly() {
        new ResumeSearchPage().checkShowMeUnlockedCandidatesOnly();
    }

    @Then("I should not see {string} in keywords builder text area")
    public void iShouldNotSeeInKeywordsBuilderTextarea(String text) {
        new OthersPage().verifyKeywordsBuilderTextAreaInput(text);
    }

    @Then("I should not see {string} in basic search keywords")
    public void iShouldNotSeeInBasicSearchKeywords(String text) {
        new OthersPage().verifyBasicSearchKeywords(text);
    }

    @And("I mouse hover to Resume Search")
    public void iMouseHoverToResumeSearch() {
        new ResumeSearchPage().mouseHoverToResumeSearch();
    }

    @When("I select email candidate amount from list")
    @When("I select all \\(20) from email candidates amount dropdown")
    public void iSelectEmailCandidateAmountFromList() {
        new ResumeSearchPage().selectEmailCandidatesAmountFromList();
    }

    @When("I select related job {string}")
    public void iSelectRelatedJob(String text) {
        new ResumeSearchPage().selectRelatedJobsFromList(text);
    }

    @Then("I should see message text {string}")
    public void iShouldSeeMessageText(String text) {
        Assert.assertTrue(new ResumeSearchPage().getTextFromMessageTextField(text).contains(text),"[---> " + text + " is not displayed <---]");
    }

    @When("I click on Preview")
    public void iClickOnPreview() {
        new ResumeSearchPage().clickOnPreviewBtn();
    }

    @And("I select {string} from active within dropdown")
    public void iSelectFromActiveWithinDropdown(String text) {
        new ResumeSearchPage().selectActiveWithinFromList(text);
    }

    @When("I enter subject as {string}")
    public void iEnterSubjectAs(String subject) {
        new ResumeSearchPage().enterSubject(subject);
    }

    @When("I enter message in TextArea with {int} characters")
    public void iEnterMessageInTextAreaWithCharacters(Integer length) {
        new ResumeSearchPage().enterMessage(getRandomString(length));
    }

    @And("I should see {string} in search builder keywords text area")
    public void iShouldSeeInKeywordsBuilderTextArea(String text) {
        Assert.assertEquals(new ResumeSearchPage().getTextFromKeywordsBuilderTextArea(), text);
    }

    @And("I should see {string} in basic keywords field")
    public void iShouldSeeInBasicKeywords(String text) {
        Assert.assertEquals(new ResumeSearchPage().getTextFromKeywords(), text);
    }

    @Then("I should see resume search results displaying text {string}")
    public void iShouldSeeResumeSearchResultsDisplayingText(String displayingText) {
        new ResumeSearchPage().verifyDisplayingText(displayingText);
    }

    @When("I click on my searches link")
    public void iClickOnMySearchesLink() {
        new ResumeSearchPage().clickOnMySearchesLink();
    }

    @And("I click on Search Resumes")
    public void iClickOnSearchResumes() {
        new ResumeSearchPage().clickOnSearchResumes();
    }

    @And("I click on Basic")
    public void iClickOnBasic() {
        new ResumeSearchPage().clickOnBasic();
    }

    @And("I click on Builder")
    public void iClickOnBuilder() {
        new ResumeSearchPage().clickOnBuilder();
    }

    @Then("I delete saved search")
    public void iDeleteSavedSearch() {
        new ResumeSearchPage().deleteSavedSearch();
    }

    @When("I click on Popular searches link")
    public void iClickOnPopularSearchesLink() {
        new ResumeSearchPage().clickOnPopularSearchesLink();
    }

    @Then("I click on Reset form")
    public void iClickOnResetForm() {
        new ResumeSearchPage().clickOnResetFormLink();
    }

    @When("I enter search builder keywords text area with {string} with enter key")
    public void iEnterSearchBuilderKeywordsTextAreaWithWithEnterKey(String keywords) {
        new OthersPage().enterSearchBuilderKeywordsTextAreaWithEnterKey(keywords);
    }

    @When("I click on {string} link from keywords search results")
    public void iClickOnLinkFromKeywordsSearchResults(String linkName) throws InterruptedException {
        new ResumeSearchPage().clickOnLinkFromKeywordsSearchResults(linkName);
    }
}