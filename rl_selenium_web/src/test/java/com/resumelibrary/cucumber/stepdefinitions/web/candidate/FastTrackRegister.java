package com.resumelibrary.cucumber.stepdefinitions.web.candidate;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.candidate.FastTrackRegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FastTrackRegister extends Utility {

    @Then("I set cookie with {string} and {string}")
    public void iSetCookieWithAnd(String key, String value) {
        new FastTrackRegisterPage().setCookieWith(key, value);
    }

    @And("I fill candidate email field with random EmailId")
    public void userFillInWithCandidateEmailRandomly() {
        String emailText = generateRandomEmail();
        new FastTrackRegisterPage().fillEmailField(emailText);
    }

    @And("I fill candidate email with random EmailId")
    public void IFillCandidateEmailWithRandomEmailId() {
        String emailText = generateRandomEmail();
        new FastTrackRegisterPage().fillEmail(emailText);
    }

    @And("I Enters Firstname as {string}")
    public void iEntersFirstnameAs(String firstName) {
        new FastTrackRegisterPage().fillFirstName(firstName);
    }

    @And("I Enter field Firstname as {string}")
    public void userEntersFieldFirstnameAs(String firstName) {
        new FastTrackRegisterPage().fillFirstNameField(firstName);
    }

    @And("I Enter field Lastname as {string}")
    public void userEntersFieldLastnameAs(String firstName) {
        new FastTrackRegisterPage().fillLastNameField(firstName);
    }

    @And("I Enters Lastname as {string}")
    public void userEntersLastnameAs(String lastName) {
        new FastTrackRegisterPage().fillLastName(lastName);
    }

    @Then("I click on Apply now Link")
    public void iClickOnApplyNowLink() {
        new FastTrackRegisterPage().clickOnApplyButton();
    }

    @And("I Enters Password {string}")
    public void iEntersPassword(String password) {
        new FastTrackRegisterPage().enterPassword(password);
    }

    @And("I Enter field Password as {string}")
    public void userEntersFieldPasswordAs(String password) {
        new FastTrackRegisterPage().enterPasswordField(password);
    }

    @And("I Click on Job Title")
    public void userClickOnJobTitle() {
        new FastTrackRegisterPage().clickOnJobTitle();
    }

    @And("I Click on Link {string}")
    public void IClickOnLink(String arg0) {
        new FastTrackRegisterPage().clickOnApplyLink();
    }

    @Then("I click on More Link")
    public void iClickOnMoreLink() {
        new FastTrackRegisterPage().clickOnMoreLink();
    }

    @And("I switch tab")
    public void iSwitchTab() {
        new FastTrackRegisterPage().switchToNewTab();
    }
    @And("I switch tab2")
    public void iSwitchTab2() {
        new FastTrackRegisterPage().switchToNewTab2();
    }

    @And("I should see {string}")
    public void iShouldSee(String text) {
        new FastTrackRegisterPage().verifyTextP(text);
    }

    @And("I should see message {string}")
    public void iShouldSeeMessage(String text) {
        new FastTrackRegisterPage().verifyText(text);
    }

    @Then("I click on Button Apply now")
    public void iClickOnButtonApplyNow() {
        new FastTrackRegisterPage().clickOnApplyButton();
    }

    @When("I follow Login link")
    public void iFollowLoginLink() {
        new FastTrackRegisterPage().clickOnLoginLink();
    }

    @When("I Click on Create a jobseeker account link")
    public void iclickOnCreateAJobseekerAccount() {
        new FastTrackRegisterPage().clickOnJobSeeker();
    }

    @And("I Click on Link Register & Apply")
    public void iClickOnLinkRegisterApply() {
        new FastTrackRegisterPage().clickOnApplyNow();
    }

    @And("I follow {string} Link")
    public void iFollowLink(String id) {
        clickOnId(id);
    }

    @And("I fill acme candidate email with random EmailId")
    public void iFillAcmeCandidateEmailWithRandomEmailId() {
        String emailText = generateRandomEmail();
        new FastTrackRegisterPage().fillACMEEmail(emailText);
    }

    @And("I Enter acme Firstname as {string}")
    public void iEnterAcmeFirstnameAs(String firstName) {
        new FastTrackRegisterPage().fillACMEFirstName(firstName);
    }

    @And("I Enter acme Lastname as {string}")
    public void iEnterAcmeLastnameAs(String lastname) {
        new FastTrackRegisterPage().fillACMELastName(lastname);
    }

    @And("I Enter acme Password as {string}")
    public void iEnterAcmePasswordAs(String password) {
        new FastTrackRegisterPage().fillACMEPassword(password);
    }

    @And("I fill in the field where id is {string} with: {string}")
    public void iFillInTheFieldWhereIdIsWith(String id, String text) {
        fillFieldUsingIdAndText(id, text);
    }

    @And("I press and wait {string}")
    public void iPressAndWait(String id) {
       clickOnId(id);
       waitFor(2);
    }

    @Then("I follow link containing text {string}")
    public void iFollowLinkContangText(String arg0) {
        new FastTrackRegisterPage().clickOnMoreLink();
    }

    @When("I follow link Login")
    public void iFollowLinkLogin() {
        new FastTrackRegisterPage().clickOnLoginLink();
    }

    @And("I Click on Link Register & Quick Apply")
    public void iClickOnLinkRegisterQuickApply() {
        new FastTrackRegisterPage().clickOnApplyNow();
    }

    @When("I fill candidate email {string}")
    public void iFillCandidateEmail(String email) {
        new FastTrackRegisterPage().fillEmailField(email);
    }
}