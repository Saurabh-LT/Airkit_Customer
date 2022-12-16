package com.resumelibrary.cucumber.stepdefinitions.web.candidate;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.candidate.FastTrackRegisterPage;
import com.resumelibrary.webtest.candidate.RegistrationPage;
import com.resumelibrary.webtest.candidate.UpdateProfilePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateProfile extends Utility {

    @And("I click on Save Changes Button on Update Profile Page")
    public void iClickOnSaveChangesButtonOnUpdateProfilePage() {
        //Disabled this line because after entering text, we are already pressing the button somehow
        //new UpdateProfilePage().SaveChangesButton();
    }

    @And("I click on Save Changes Button on Modify Profile Page")
    public void iClickOnSaveChangesButtonOnModifyProfilePage() {
        new UpdateProfilePage().SaveChangesButton();
    }

    @And("I fill in the first name with {string} on modify profile page")
    public void iFillInTheFirstNameWithOnModifyProfilePage(String firstName) {
        new UpdateProfilePage().enterFirstName(firstName);
    }

    @And("I enter the zip code with {string} on modify profile page")
    public void iEnterTheZipCodeWithOnModifyProfilePage(String zipcode) {
        new UpdateProfilePage().enterZipCode(zipcode);
    }

    @When("I fill in the field phone with {string} on modify profile page")
    public void iFillInTheFieldPhoneWithOnUpdateProfilePage(String phone) {
        new UpdateProfilePage().enterPhoneNumber(phone);
    }

    @When("I fill in latest job title with {string} on modify profile page")
    public void iFillInLatestJobTitleWithOnModifyProfilePage(String latestJob) {
        new UpdateProfilePage().enterLatestJobTitle(latestJob);
    }

    @And("I enter desired job title {string} on modify profile page")
    public void iEnterDesiredJobTitleOnModifyProfilePage(String desiredJobTitle) {
        new UpdateProfilePage().enterDesiredJobTitle(desiredJobTitle);
    }

    @When("I fill in skills input with {string} on modify profile page")
    public void iFillInSkillsInputWithOnModifyProfilePage(String skills) {
        new UpdateProfilePage().enterSkills(skills);
    }

    @And("I click on Set Password button")
    public void iClickOnSetPasswordButton() {
        new UpdateProfilePage().clickOnSetPassword();
    }

    @Then("I click on Upload Resume button")
    public void iClickOnUploadResumeButton() {
        new UpdateProfilePage().uploadResume();
    }

    @And("I uncheck the label Claim my free professional Resume Review")
    public void iUncheckTheLabelClaimMyFreeProfessionalResumeReview() {
        new RegistrationPage().clickOnResumeCheckbox();
    }

    @And("I uncheck the label Claim my free professional Resume Review one")
    public void iUncheckTheLabelClaimMyFreeProfessionalResumeReviewOne() {
        new FastTrackRegisterPage().unCheckResume1View();;
    }

    @And("I click on update resume submit button")
    public void iClickOnUpdateResumeSubmitButton() {
        new UpdateProfilePage().clickOnUpdateResumeSubmit();
    }

    @And("I fill in the last name with {string} on modify profile page")
    public void iFillInTheLastNameWithOnModifyProfilePage(String lastName) {
        new UpdateProfilePage().enterLastName(lastName);
    }

    @And("I select the field education level with {string} on modify profile page")
    public void iSelectTheFieldEducationLevelWithOnModifyProfilePage(String educationLevel) {
        new UpdateProfilePage().selectTheFieldEducationLevelWithOnModifyProfilePage(educationLevel);
    }

    @And("I select the field years of experience with {string} on modify profile page")
    public void iSelectTheFieldYearsOfExperienceWithOnModifyProfilePage(String yearsOfExperience) {
        new UpdateProfilePage().selectTheFieldYearsOfExperienceWithOnModifyProfilePage(yearsOfExperience);
    }

    @Then("Compare the {string} label Text With {string}")
    public void compareTheLabelTextWith(String labelName, String labelValue) {
        new UpdateProfilePage().compareTheLabelTextWith(labelName,labelValue);
    }

    @And("I select the field prepared to travel with {string} on modify profile page")
    public void iSelectTheFieldPreparedToTravelWithOnModifyProfilePage(String preparedToTravel) {
        new UpdateProfilePage().selectTheFieldPreparedToTravelWithOnModifyProfilePage(preparedToTravel);
    }

    @And("I select the field willing to relocate with {string} on modify profile page")
    public void iSelectTheFieldWillingToRelocateWithOnModifyProfilePage(String willingTorelocate) {
        new UpdateProfilePage().selectTheFieldWillingToRelocateWithOnModifyProfilePage(willingTorelocate);
    }

    @And("I select the field drivers license with {string} on modify profile page")
    public void iSelectTheFieldDriversLicenseWithOnModifyProfilePage(String driversLicense) {
        new UpdateProfilePage().selectTheFieldDriversLicenseWithOnModifyProfilePage(driversLicense);
    }

    @And("I select the field desired salary from with {string} on modify profile page")
    public void iSelectTheFieldDesiredSalaryFromWithOnModifyProfilePage(String desiredSalaryFrom) {
        new UpdateProfilePage().selectTheFieldDesiredSalaryFromWithOnModifyProfilePage(desiredSalaryFrom);
    }

    @And("I select the field desired salary to with {string} on modify profile page")
    public void iSelectTheFieldDesiredSalaryToWithOnModifyProfilePage(String desiredSalaryTo) {
        new UpdateProfilePage().selectTheFieldDesiredSalaryToWithOnModifyProfilePage(desiredSalaryTo);
    }

    @And("I select the field authorization to work in the U.S with {string} on modify profile page")
    public void iSelectTheFieldAuthorizationToWorkInTheUSWithOnModifyProfilePage(String authorizationToWorkInTheUS) {
        new UpdateProfilePage().selectTheFieldAuthorizationToWorkInTheUSWithOnModifyProfilePage(authorizationToWorkInTheUS);
    }
    @And("I click on View Resume close popup button")
    public void iClickOnViewResumeClosePopupButton() {
        new UpdateProfilePage().clickOnViewResumeClosePopupButton();

    }
}