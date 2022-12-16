package com.resumelibrary.cucumber.stepdefinitions.web.candidate;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.candidate.FastTrackUpdateProfilePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class FastTrackUpdateProfile extends Utility {

    @And("I click on Create Job Alert")
    public void iClickOnCreateJobAlert() {
        new FastTrackUpdateProfilePage().clickOnCreateJobAlert();
    }

    @And("I fill search results job alerts email with random email id")
    public void iFillSearchResultsJobAlertsEmailWithRandomEmailId() {
        new FastTrackUpdateProfilePage().fillRandomEmailId();
    }

    @When("I click on link Get the latest Jobs with Job Alert")
    public void iClickOnLinkGetTheLatestJobsWithJobAlerts() {
        new FastTrackUpdateProfilePage().clickOnGetLatestJobAlert();
    }

    @When("I fill in latest job title with {string}")
    public void iFillInLatestJobTitleWith(String title) {
        new FastTrackUpdateProfilePage().fillJobTitle(title);
    }

    @And("I click on Save to profile button")
    public void iClickOnSaveToProfileButton() {
        new FastTrackUpdateProfilePage().clickSaveToProfile();
    }

    @When("I fill in the field phone with {string}")
    public void iFillInTheFieldPhoneWith(String phone) {
        new FastTrackUpdateProfilePage().enterPhoneNumber(phone);
    }

    @When("I click on upload resume toggle")
    public void iClickOnUploadResumeToggle() {
        new FastTrackUpdateProfilePage().clickOnUploadResumeToggle();
    }

    @And("I click on Upload resume button")
    public void iClickOnUploadResumeButton() {
        new FastTrackUpdateProfilePage().clickUploadResume();
    }

    @And("I click on the link Skip >")
    public void iClickOnTheLinkSkip() {
        new FastTrackUpdateProfilePage().clickOnSkip();
    }

    @When("I fill in the zip code with {string}")
    public void iFillInTheZipCodeWith(String zipCode) {
        new FastTrackUpdateProfilePage().enterZipCode(zipCode);
    }

    @When("I fill in the desired job title with {string}")
    public void iFillInTheDesiredJobTitleWith(String jobTitle) {
        new FastTrackUpdateProfilePage().enterDesiredJobTitle(jobTitle);
    }

    @When("I fill in salary expectation from with {string}")
    public void iFillInSalaryExpectationFromWith(String minSalary) {
        new FastTrackUpdateProfilePage().selectMinSalary(minSalary);
    }

    @When("I fill in salary expectation to with {string}")
    public void iFillInSalaryExpectationToWith(String maxSalary) {
        new FastTrackUpdateProfilePage().selectMaxSalary(maxSalary);
    }

    @When("I fill in the education level with {string}")
    public void iFillInTheEducationLevelWith(String education) {
        new FastTrackUpdateProfilePage().enterEducation(education);
    }

    @When("I select the option {string} from eligibility status")
    public void iSelectTheOptionFromEligibilityStatus(String eligibilityStatus) {
        new FastTrackUpdateProfilePage().selectEligibilityStatus(eligibilityStatus);
    }

    @When("I fill in skills input with {string}")
    public void iFillTextFieldWhereIdIsWithAttributeValue(String value) {
        new FastTrackUpdateProfilePage().enterSkills(value);
    }

    @When("I fill in the first name with {string}")
    public void iFillInTheFirstNameWith(String firstName) {
        new FastTrackUpdateProfilePage().enterFirstName(firstName);
    }

    @When("I fill the  last name with {string}")
    public void iFillTheLastNameWith(String lastName) {
        new FastTrackUpdateProfilePage().enterLastName(lastName);
    }

    @When("I select the option {string} from relocate")
    public void iSelectTheOptionFromRelocate(String relocate) {
        new FastTrackUpdateProfilePage().selectRelocateStatus(relocate);
    }

    @When("I select the option {string} from work experience")
    public void iSelectTheOptionFromWorkExperience(String exp) {
        new FastTrackUpdateProfilePage().selectWorkExp(exp);
    }

    @When("I select the option {string} from driving licence")
    public void iSelectTheOptionFromDrivingLicence(String licStaus) {
        new FastTrackUpdateProfilePage().selectDrivingLiStatus(licStaus);
    }

    @Then("I should see text Profile {string} complete")
    public void iShouldSeeTextProfileComplete(String expected) {
        String actual = new FastTrackUpdateProfilePage().percentageComplete(expected);
        Assert.assertEquals(expected, actual);
    }

    @And("I click on Save to profile button skip")
    public void iClickOnSaveToProfileButtonSkip() {
        //we don't need to click save profile button, because previous step is entering keyword and submitting form
    }

    @And("I click on Create Job Alert move to page {string}")
    public void iClickOnCreateJobAlertMoveToPage(String url) {
        new FastTrackUpdateProfilePage().clickOnCreateJobAlertAndMoveto(url);
    }
}