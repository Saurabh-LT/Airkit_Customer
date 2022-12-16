package com.resumelibrary.cucumber.stepdefinitions.web.client;

import com.resumelibrary.cucumber.stepdefinitions.web.misc.Misc;
import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.client.ResumeViewPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ResumeView extends Utility {

    private static final Logger logger = LogManager.getLogger(com.resumelibrary.cucumber.stepdefinitions.web.client.Others.class);

    @And("I click on save resume")
    public void iClickOnSaveResume() {
        new ResumeViewPage().clickOnSaveResumeBtn();
    }

    @When("I click on saved resume one")
    public void iClickOnSavedResumeOne() {
        new ResumeViewPage().clickOnSavedResume1Btn();
    }

    @And("I click on saved action view one")
    public void iClickOnSavedActionViewOne() {
        new ResumeViewPage().clickOnSavedActionView1();
    }

    @And("I click on saved action delete one")
    public void iClickOnSavedActionDeleteOne() {
        new ResumeViewPage().clickOnSavedActionDelete1();
    }

    @And("I click on saved delete")
    public void iClickOnSavedDelete() {
        new ResumeViewPage().clickOnSavedDelete();
    }

    @When("I click on saved delete cancel")
    public void iClickOnSavedDeleteCancel() {
        new ResumeViewPage().clickOnSavedDeleteCancel();
    }

    @And("I click on contact applicant btn")
    public void iClickOnContactApplicantBtn() {
        new ResumeViewPage().clickOnContactApplicantBtn();
    }

    @And("I select {string} from requested action")
    public void iSelectFromRequestedAction(String action) {
        new ResumeViewPage().selectFromRequestResumeActionSelect(action);
    }

    @And("I enter email {string} to your email field")
    public void iEnterEmailToYourEmailField(String email) {
        new ResumeViewPage().enterEmailToRequestResumeNotifyEmailField(email);
    }

    @And("I find a locked candidate and click on unlock resume")
    public void iFindALockedCandidateAndClickOnUnlockResume() {
        new ResumeViewPage().findLockedCandidate();
        new ResumeViewPage().clickOnPreviewResume();
    }

    @And("I find a locked candidate")
    public void iFindALockedCandidate() {
        new ResumeViewPage().findLockedCandidate();
    }

    @And("I click on {string} and verify below steps")
    public void iClickOnAndVerifyBelowSteps(String text) {
        try {
            new com.resumelibrary.cucumber.stepdefinitions.web.candidate.Others().iClickOn(text);
            new Misc().iShouldSeeText("Request Candidate Action");
            iSelectFromRequestedAction("Request updated Resume");
            iEnterEmailToYourEmailField("testers@resume-library.com");
            new com.resumelibrary.cucumber.stepdefinitions.web.candidate.Others().iClickOn("Send Request");
        } catch (Exception e) {
            logger.info("No request resume to be updated");
        }
    }

    @And("I find a locked candidate and verify text {string}")
    public void iFindALockedCandidateAndVerifyText(String text) {
        new ResumeViewPage().findLockedCandidateAndVerify(text);
    }

    @And("I find a unlocked candidate")
    public void iFindAUnlockedCandidate() {
        new ResumeViewPage().findUnLockedCandidate();
    }

    @And("I click on FREE Resume Review")
    public void iClickOnFREEResumeReview() {
        new ResumeViewPage().clickOnFreeResumeReviewBtn();
    }

    @When("I click on {string} on view resume page")
    public void iClickOnOnViewResumePage(String text) {
        new ResumeViewPage().clickOncViewResumeOptions(text);
    }

    @And("I click on Greenhouse checkbox")
    public void iClickOnGreenhouseCheckbox() {
        new ResumeViewPage().clickOnGreenhouseCheckbox();
    }

    @And("I click on Import button")
    public void iClickOnImportButton() {
        new ResumeViewPage().clickImportButton();
    }

    @And("I should see text {string} on ats import popup")
    public void iShouldSeeTextOnAtsImportPopup(String text) {
        new ResumeViewPage().shouldSeeTextOnAtsPopup(text);
    }

    @And("I should see Greenhouse checkbox is selected")
    public void iShouldSeeGreenhouseCheckboxIsSelected() {
        new ResumeViewPage().verifyThatGreenhouseCheckboxIsSelected();
    }
}