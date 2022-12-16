package com.resumelibrary.cucumber.stepdefinitions.web.client;

import com.resumelibrary.admintest.misc.MiscPage;
import com.resumelibrary.cucumber.stepdefinitions.web.candidate.JobSearch;
import com.resumelibrary.cucumber.stepdefinitions.web.misc.Misc;
import com.resumelibrary.utilities.AdminURLHelper;
import com.resumelibrary.utilities.DataHelper;
import com.resumelibrary.utilities.Utility;
import com.resumelibrary.utilities.WebURLHelper;
import com.resumelibrary.webtest.client.JobTemplatePage;
import com.resumelibrary.webtest.client.ManageUsersPage;
import com.resumelibrary.webtest.client.OthersPage;
import com.resumelibrary.webtest.client.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class Others extends Utility {

    private static final Logger logger = LogManager.getLogger(com.resumelibrary.cucumber.stepdefinitions.web.client.Others.class);

    @When("I click on saved action one")
    public void iClickOnSavedActionOne() {
        new OthersPage().clickOnSavedAction1();
    }

    @Then("I press candidate name by asc order")
    public void iPressCandidateNameByAscOrder() {
        new OthersPage().clickOnCandidateNameByAscOrder();
    }

    @And("I press candidate name by desc order")
    public void iPressCandidateNameByDescOrder() {
        new OthersPage().clickOnCandidateNameByDescOrder();
    }

    @Then("I press saved by asc order")
    public void iPressSavedByAscOrder() {
        new OthersPage().clickOnSavedByAscOrder();
    }

    @And("I press saved by desc order")
    public void iPressSavedByDescOrder() {
        new OthersPage().clickOnSavedByDescOrder();
    }

    @When("I click on footer events link and I should see in browser url {string}")
    public void iClickOnFooterEventsLinkAndVerifyLink(String url) {
        new OthersPage().clickOFooterEventsLinkAndVerifyLink(url);
    }

    @And("I click on footer work permits and visas link")
    public void iClickOnFooterWorkPermitsAndVisasLink() {
        new OthersPage().clickOnFooterWorkPermitsAndVisasLink();
    }

    @And("I click on action toggle btn one")
    public void iClickOnActionToggleBtnOne() {
        new OthersPage().clickOnActionToggleButton1();
    }

    @When("I click on view guide zoho")
    public void iClickOnViewGuideZoho() {
        new OthersPage().clickOnViewGuideZoho();
    }

    @When("I click on generate new key one")
    public void iClickOnGenerateNewKeyOne() {
        new OthersPage().clickOnGenerateKey1();
    }

    @And("I should see text free instant search {string}")
    public void iShouldSeeTextFreeInstantSearch(String text) {
        Assert.assertEquals(new OthersPage().getTextFromFormTagElement(), text);
    }

    @When("I enter email address with random client email")
    public void iEnterEmailAddressWithRandomClientEmail() {
        new OthersPage().enterRandomClientEmailAddress();
    }

    @And("I enter location with {string}")
    public void iEnterLocationWith(String location) {
        new OthersPage().enterLocation(location);
    }

    @And("I enter name field with {string}")
    public void iEnterNameFieldWith(String name) {
        new OthersPage().enterName(name);
    }

    @Then("I click on Search Resumes button")
    public void iClickOnSearchResumesButton() {
        new OthersPage().clickOnSearchResumes();
    }

    @Then("I enter search builder keywords text area with {string}")
    public void iEnterSearchBuilderKeywordsTextAreaWith(String keywords) {
        new OthersPage().enterSearchBuilderKeywordsTextArea(keywords);
    }

    @And("I enter search builder keywords text area with candidate id")
    public void iEnterSearchBuilderTextAreaWithCandidateId() {
        new OthersPage().enterSearchBuilderKeywordsTextArea(DataHelper.getCandidateId());
    }

    @And("I enter search builder keywords text area with invalid candidate id")
    public void iEnterSearchBuilderTextAreaWithInvalidCandidateId() {
        new OthersPage().enterSearchBuilderKeywordsTextArea(DataHelper.getInvalidCandidateId());
    }

    @And("I enter basic search keywords with {string}")
    public void iEnterBasicSearchKeywordsWith(String keywords) {
        new OthersPage().enterBasicSearchKeywords(keywords);
    }

    @And("I enter basic search keywords with candidate id")
    public void iEnterBasicSearchCandidateId() {
        new OthersPage().enterBasicSearchKeywords(DataHelper.getCandidateId());
    }

    @And("I enter basic search keywords with invalid candidate id")
    public void iEnterBasicSearchInvalidCandidateId() {
        new OthersPage().enterBasicSearchKeywords(DataHelper.getInvalidCandidateId());
    }

    @And("I fill in basic search keywords with {string}")
    public void iFillInBasicSearchKeywordsWith(String keywords) {
        new OthersPage().fillInBasicSearchKeywords(keywords);
    }

    @And("I click on More Search Options")
    public void iClickOnMoreSearchOptions() {
        new OthersPage().clickOnMoreSearchOptions();
    }

    @And("I select option {string} from Salary Min")
    public void iSelectOptionFromSalaryMin(String salMin) {
        new OthersPage().selectMinSalary(salMin);
    }

    @And("I select option {string} from Salary Max")
    public void iSelectOptionFromSalaryMax(String salMax) {
        new OthersPage().selectMaxSalary(salMax);
    }

    @Then("I should see text on test search page {string}")
    public void iShouldSeeTextOnTestSearchPage(String text) {
        Assert.assertEquals(new OthersPage().verifySearchTextI(), text);
    }

    @And("I enter address {string}")
    public void iEnterAddress(String address) {
        new OthersPage().enterAddress(address);
    }

    @And("I enter state {string}")
    public void iEnterState(String state) {
        new OthersPage().enterState(state);
    }

    @And("I select option {string} from company type and size")
    public void iSelectFromRecruiterType(String recruiterType) {
        new OthersPage().selectRecruiterType(recruiterType);
    }

    @Then("I should be able to see in browser URL {string} or I should see {string}")
    public void iShouldBeAbleToSeeInBrowserURLOr(String url1, String url2) {
        waitFor(2);
        String presentURL = getPresentURL();
        boolean urlFound = false;
        if (presentURL.contains(getURL(url1)) || presentURL.contains(getURL(url2))) {
            urlFound = true;
            logger.info("[--->urlFound---->" + urlFound + "<---]");
        }
        Assert.assertTrue(urlFound,"[---> " + url1 + " or " + url2 + " is not the browser url <---]");
    }

    @And("I scroll into view header")
    public void iScrollIntoViewHeader() {
        new OthersPage().scrollUpToHeader();
    }

    @When("I click on My searches and verify below steps")
    public void iClickOnMySearchesAndVerifyBelowSteps() {
        new ResumeSearch().iClickOnMySearchesLink();
        try {
            new Misc().iShouldSeeText("Job type");
            new Misc().iShouldSeeText("Actions");
            new com.resumelibrary.cucumber.stepdefinitions.web.candidate.Others().iShouldSeeTextPTagAndVerifyMessage("Displaying ", "Displaying 1 to ");
            new JobSearch().iShouldSeeLinkWithId("Run Search", "my-searches-run-btn");
            new ResumeSearch().iClickOnRunSearchButton();
            new Misc().iShouldSeeText("Instantly contact top candidates");
        } catch (Exception e) {
            logger.info("You don't have any recent searches yet");
            new Misc().iShouldSeeText("You don't have any recent searches yet");
        }
    }

    @And("I click on post jobs button")
    public void iClickOnPostJobsButton() {
        new OthersPage().clickOnPostJobsButton();
    }

    @And("I click on Delete button")
    public void iClickOnDeleteButton() {
        new JobTemplatePage().clickDeleteButton();
    }

    @And("I click on Delete confirm button")
    public void iClickOnDeleteConfirmButton() {
        new JobTemplatePage().clickDeleteConfirmButton();
    }

    @Then("I click on hyper link {string}")
    public void iClickOnHyperLink(String link) {
        new OthersPage().clickOnLink(link);
    }

    @And("I click on video play button in the frame {string}")
    public void iClickOnVideoPlayButton(String iframe) {
        new OthersPage().clickOnVideoPlayButton(iframe);
    }

    @And("I click on video pause button in the frame {string}")
    public void iClickOnVideoPauseButtonInTheFrame(String iframe) {
        new OthersPage().clickOnVideoPauseButton(iframe);
    }

    @And("I should see the video played up to {string} seconds")
    public void iShouldSeeTheVideoPlayedUpToSeconds(String duration) {
        List<String> timeToVerify = Arrays.asList("00:01", "00:02", "00:03", "00:04", "00:05", "00:06", "00:07", "00:08", "00:09");
        logger.info("time to verify " + timeToVerify);
        logger.info("current duration played " + new OthersPage().getTheDurationVideoPlayed());
        Assert.assertTrue(timeToVerify.contains(new OthersPage().getTheDurationVideoPlayed()), "[---> " + timeToVerify + " is not displayed <---]");
    }

    @When("I switch to frame and play the video")
    public void iSwitchToFrameAndPlayTheVideo() {
        new OthersPage().clickOnVideoPlayButton("No iframe Id");
    }

    @Then("I click on video pause button")
    public void iClickOnVideoPauseButton() {
        new OthersPage().clickOnVideoPauseButton("No iframe Id");
    }

    @And("I close current tab")
    public void iCloseCurrentTab() {
        getThreadDriver().close();
    }

    @And("I Verify {string} and update account details in {string}")
    public void iVerifyAndUpdate(String text, String adminUrl) {
        if (new ManageUsersPage().verifyAndUpdate(text) == null) {
            new MiscPage().loginAsAdminUser();
            getDriverWithUrl(AdminURLHelper.getAdminUrl(), adminUrl);
            new MiscPage().updateCandidateUnlock();
            getDriverWithUrl(WebURLHelper.getWebUrl(), WebURLHelper.getClientAccountUsersUrlUserUrl());
        }
    }

    @And("I logout the client")
    public void iLogoutTheClient() {
        new OthersPage().logoutDirectly();
    }

    @Then("I should see text {string} or delete the search")
    public void iShouldSeeTextOrDeleteTheSearch(String text) {
        // Please don't remove this hacky code
        try {
            new com.resumelibrary.webtest.misc.MiscPage().verifyTextMessage(text);
        } catch (Exception e) {
            new com.resumelibrary.cucumber.stepdefinitions.web.candidate.Others().iNavigateToPage("Client Saved Search");
            new com.resumelibrary.cucumber.stepdefinitions.web.candidate.Others().iClickOn("Actions");
            new com.resumelibrary.cucumber.stepdefinitions.web.candidate.Others().iClickOn("Delete");
            new ResumeSearch().iClickOnSaveSearchDeleteBtn();
            new com.resumelibrary.webtest.misc.MiscPage().shouldSeeText("Search removed successfully");
            new com.resumelibrary.cucumber.stepdefinitions.web.candidate.Others().iNavigateToPage("Client Resume Search");
            reloadPage();
            new ResumeSearch().iClickOnMySearchesLink();
            new com.resumelibrary.cucumber.stepdefinitions.web.candidate.Others().iClickOn("Saved searches");
        }
    }

    @And("I should see text {string} if not then delete saved card")
    public void iShouldSeeTextIfNotThenDeleteSavedCard(String text) {
        try {
            Assert.assertTrue(verifyTextMessage(text), "[---> " + text + " is not displayed <---]");
        } catch (Exception e) {
            new ProductsPage().clickDeletedSavedCardIcon();
            new ProductsPage().clickDeleteCardConfirmButton();
            Assert.assertTrue(verifyTextMessage(text),"[---> " + text + " is not displayed <---]");
        }
    }
}