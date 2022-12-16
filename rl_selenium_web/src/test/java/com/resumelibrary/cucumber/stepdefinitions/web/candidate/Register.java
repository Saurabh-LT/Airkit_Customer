package com.resumelibrary.cucumber.stepdefinitions.web.candidate;

import com.resumelibrary.admintest.account.AccountPage;
import com.resumelibrary.utilities.DataHelper;
import com.resumelibrary.utilities.Utility;
import com.resumelibrary.utilities.WebURLHelper;
import com.resumelibrary.webtest.candidate.OthersPage;
import com.resumelibrary.webtest.candidate.RegistrationPage;
import com.resumelibrary.webtest.client.ClientPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Register extends Utility {
    public  String emailAddress = null;
    public static String clientEmailAddress, clientEmailAddress1, clientEmailAddress2,
            clientEmailAddress3, clientEmailAddress4, clientEmailAddress5 = null;

    @And("I register as a new candidate")
    public void iRegisterAsANewCandidate() {
        iEnterEmailAddress(DataHelper.getCandidateEmailAddress());
        iEnterFirstName(DataHelper.getCandidateFirstName());
        iEnterLastName(DataHelper.getLastName());
        iEnterPassword(DataHelper.getPassword());
        iEnterLatestJobTitle(DataHelper.getLatestJobTitle());
        iEnterZipCode(DataHelper.getZipCode());
        iUploadResume(DataHelper.getResumeFileName());
        iClickOnResumeCheckbox();
        iClickOnRegisterButton();
        waitUntil(WebURLHelper.getCandidateRegisterConfirmationUrl());
    }

    @And("I register as a new candidate resume check")
    public void iRegisterAsANewCandidateResumeCheck() {
        iEnterEmailAddress(DataHelper.getCandidateEmailAddress());
        iEnterFirstName(DataHelper.getCandidateFirstName());
        iEnterLastName(DataHelper.getLastName());
        iEnterPassword(DataHelper.getPassword());
        iEnterLatestJobTitle(DataHelper.getLatestJobTitle());
        iEnterZipCode(DataHelper.getZipCode());
        iUploadResume(DataHelper.getResumeFileName());
        iClickOnRegisterButton();
        waitUntil(WebURLHelper.getCandidateRegisterConfirmationUrl());
    }

    @And("I register as a new client")
    public void iRegisterAsANewClient() {
        iEnterEmailAddress(DataHelper.getCandidateEmailAddress());
        iEnterFirstName(DataHelper.getCandidateFirstName());
        iEnterLastName(DataHelper.getLastName());
        iEnterPassword(DataHelper.getPassword());
        new ClientPage().enterCompanyName(DataHelper.getClientCompanyName());
        iEnterPhoneNumber(DataHelper.getClientPhoneNUmber());
        new com.resumelibrary.webtest.client.RegistrationPage().clickOnEnterAddressManuallyLink();
        new com.resumelibrary.webtest.client.RegistrationPage().enterAddress1(DataHelper.getClientAddress());
        iEnterCity(DataHelper.getClientCity());
        new com.resumelibrary.webtest.client.OthersPage().enterState(DataHelper.getClientState());
        iEnterZipCode(DataHelper.getClientZipCode());
        new com.resumelibrary.webtest.client.RegistrationPage().selectRecruiterType(DataHelper.getClientRecruiterType());
        new ClientPage().clickOnSubmitInquiry();
        waitUntil(WebURLHelper.getClientAccountUrl());
    }

    @When("I enter email address {string}")
    public void iEnterEmailAddress(String email) {
        email = getRandomString(7) + email;
        emailAddress = email;
        new RegistrationPage().enterEmailAddress(emailAddress);
    }

    @When("I enter client email address {string}")
    public void iEnterClientEmailAddress(String email) {
        String runnerName = getRunnerName();
        email = getRandomString(7) + "1" + email;
        new RegistrationPage().enterEmailAddress(email);
        setRandomEmail(email);

    }

    @When("I search for {string} in the navigation bar on admin")
    public void iSearchForInTheNavigationBarOnAdmin(String value) {
        new AccountPage().searchForInTheNavigationBar(getRandomEmail());
    }

    @And("I enter first name {string}")
    public void iEnterFirstName(String firstName) {
        new RegistrationPage().enterFirstName(firstName);
    }

    @And("I enter last name {string}")
    public void iEnterLastName(String lastName) {
        new RegistrationPage().enterLastName(lastName);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        new RegistrationPage().enterPassword(password);
    }

    @And("I enter latest job title {string}")
    public void iEnterLatestJobTitle(String title) {
        new RegistrationPage().enterJobTitle(title);
    }

    @And("I enter zip code {string}")
    public void iEnterZipCode(String zipcode) {
        new RegistrationPage().enterZipcode(zipcode);
    }

    @And("I click on register button")
    public void iClickOnRegisterButton() {
        new RegistrationPage().clickOnRegisterButton();
    }

    public void iClickOnResumeCheckbox() {
        new RegistrationPage().clickOnResumeCheckbox();
    }

    @When("I enter phone number {string}")
    public void iEnterPhoneNumber(String phone) {
        new RegistrationPage().enterPhoneNumber(phone);
    }

    @And("I enter desired job title {string}")
    public void iEnterDesiredJobTitle(String jobTitle) {
        new RegistrationPage().enterDesiredJobTitle(jobTitle);
    }

    @And("I select job type {string}")
    public void iSelectJobType(String type) {
        new RegistrationPage().jobTypeCheckBox(type);
    }

    @And("I select minimum salary {string} and maximum salary {string}")
    public void iSelectMinimumSalaryAndMaximumSalary(String salMin, String salMax) {
        new RegistrationPage().selectDesiredSalaryMinAndMax(salMin, salMax);
    }

    @And("I click on on add job title link and enter keyword {string}")
    public void iClickOnOnAddJobTitleLinkAndEnterKeyword(String jobTitle) {
        new RegistrationPage().clickOnAddJobTitleLink();
        new RegistrationPage().enterAddJobTitle(jobTitle);
    }

    @And("I click on complete button")
    public void iClickOnCompleteButton() {
        new RegistrationPage().clickOnCompleteButton();
    }

    @And("I select country from dropdown {string}")
    public void iSelectCountryFromDropdown(String country) {
        new RegistrationPage().selectCountryFromDropdown(country);
    }

    @And("I enter city {string}")
    public void iEnterCity(String city) {
        new RegistrationPage().enterCity(city);
    }

    @Then("I should see text from salary swap{string}")
    public void iShouldSeeTextFromSalarySwap(String msg) {
        Assert.assertEquals(new OthersPage().getTextFromSalarySwap(), msg);
    }

    @And("I should see text from error salary expectation {string}")
    public void iShouldSeeTextFromErrorSalaryExpectation(String msg) {
        Assert.assertEquals(new OthersPage().getTextFromErrorSalaryExpectation(), msg);
    }

    @And("I upload resume {string}")
    public void iUploadResume(String path) {
        try {
            String projectPath = System.getProperty("user.dir");

            new RegistrationPage().upLoadYourResume(projectPath + "/src/test/java/resources/testfiles/" + getURL(path));
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @When("I should not see {string}")
    public void iShouldNotSee(String text) {
        Assert.assertFalse(isElementOrTextDisplayed(text), "[---> " + text + " is displayed <---]");
    }

    @And("I enter email address only {string}")
    public void iEnterEmailAddressOnly(String email) {
        new RegistrationPage().enterEmailAddress(email);
    }

    @And("I click on first name field")
    public void iClickOnFirstNameField() {
        new RegistrationPage().clickOnFirstnameField();
    }

    @Then("I click on register confirm button")
    public void iClickOnRegisterConfirmButton() {
        new RegistrationPage().clickOnRegisterAndConfirmButton();
    }

    @Then("I click on register popup close btn")
    public void iClickOnRegisterPopupCloseBtn() {
        new RegistrationPage().clickOnRegisterAndPopupCloseButton();
    }

    @And("I click on privacy policy link")
    public void iClickOnPrivacyPolicyLink() {
        new RegistrationPage().clickOnPrivacyPolicyLink();
    }

    @Then("I click on terms conditions link")
    public void iClickOnTermsConditionsLink() {
        new RegistrationPage().clickOnTermsConditionsLink();
    }

    @And("I click on search results resume review banner")
    public void iClickOnSearchResultsResumeReviewBanner() {
        new RegistrationPage().clickOnSearchResultResumeReviewBanner();
    }

    @When("I follow job view resume review banner")
    public void iFollowJobViewResumeReviewBanner() {
        new RegistrationPage().clickOnJobViewResumeReviewBanner();
    }

    @And("I follow company search resume review banner")
    public void iFollowCompanySearchResumeReviewBanner() {
        new RegistrationPage().clickOnCompanySearchResumeReviewBanner();
    }

    @And("I enter home town {string}")
    public void iEnterHomeTown(String homeTown) {
        new RegistrationPage().enterHomeTown(homeTown);
    }

    @And("I should see text {string} or {string}")
    public void iShouldSeeTextOr(String success, String popup) {
        String fullText = "Submit your resume to our partner Nexxt and get noticed by a whole new set of employers. I agree to Nexxt's Terms of Service and Privacy.";
        String partialText = "Submit your resume to our partner Nexxt and get noticed by a whole new set of employers. I agree to Nexxt's";
        String yesText = "Yes Please";

        try {
            Assert.assertTrue(verifyTextMessage(success), "[---> " + success + " is not displayed <---]");
            new OthersPage().verifyURLText(WebURLHelper.getJobApplyConfirmUrl(),"");
        } catch (Exception e) {
            Assert.assertTrue(verifyTextMessage(popup),"[---> " + popup + " is not displayed <---]");
            Assert.assertTrue(verifyTextMessagePTags(partialText,
                    fullText)
                    .contains(fullText), "[---> " + fullText + " is not displayed <---]");
            clickOnElementUsingText(yesText);
            new OthersPage().verifyURLText(WebURLHelper.getJobApplyConfirmUrl(),"");
        }
    }

    @Then("I enter registered email address")
    public void iEnterRegisteredEmailAddress() {
        new RegistrationPage().enterEmailAddress(emailAddress);
    }
}