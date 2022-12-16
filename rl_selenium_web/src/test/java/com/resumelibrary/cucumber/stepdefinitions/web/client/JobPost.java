package com.resumelibrary.cucumber.stepdefinitions.web.client;

import com.resumelibrary.cucumber.stepdefinitions.web.candidate.Others;
import com.resumelibrary.utilities.DataHelper;
import com.resumelibrary.utilities.Utility;
import com.resumelibrary.utilities.WebURLHelper;
import com.resumelibrary.webtest.candidate.LogoutPage;
import com.resumelibrary.webtest.candidate.RegistrationPage;
import com.resumelibrary.webtest.candidate.SavedJobsPage;
import com.resumelibrary.webtest.client.JobPostPage;
import com.resumelibrary.webtest.client.JobTemplatePage;
import com.resumelibrary.webtest.misc.MiscPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class JobPost extends Utility {

    @And("I enter job title {string}")
    public void iEnterJobTitle(String title) {
        new JobPostPage().enterJobTitle(title);
    }

    @And("I select {string} from state dropdown")
    public void iSelectFromStateDropdown(String state) {
        new JobPostPage().selectStateFromDropdown(state);
    }

    @And("I enter salary min {string}")
    public void iEnterSalaryMin(String salMin) {
        new JobPostPage().enterSalaryMin(salMin);
    }

    @And("I enter salary max {string}")
    public void iEnterSalaryMax(String salMax) {
        new JobPostPage().enterSalaryMax(salMax);
    }

    @Then("I enter job description {string}")
    public void iEnterJobDescription(String jobDescription) {
        new JobPostPage().enterDescription(jobDescription);
    }

    @And("I click on quick apply toggle")
    public void iClickOnQuickApplyToggle() {
        new JobPostPage().clickONQuickApplyToggle();
    }

    @Then("I click on preview button")
    public void iClickOnPreviewButton() {
        new JobPostPage().clickOnPreviewButton();
    }
    @Then("I click Menu button")
    public void iClickOnMenuButton() {
        new JobPostPage().clickOnMenuButton();
    }

    @And("I click on post job button")
    @Then("I click on save template btn")
    public void iClickOnPostJobButton() {
        new JobTemplatePage().clickOnPreviewSubmitButton();
    }

    @And("I click on post job submit button")
    public void iClickOnPostJobSubmitButton() {
        new JobPostPage().clickOnPostJobSubmitButton();
    }

    @And("I login as a client and post a non external job")
    public void iLoginAsAClientAndPostANonExternalJob() {
        new MiscPage().loginAsClient();
        new Others().iAmOnPage(WebURLHelper.getJobPostUrl());
        new JobPostPage().enterJobTitle(DataHelper.getJobPostingTitle());
        new JobPostPage().selectStateFromDropdown(DataHelper.getJobPostingLocation());
        new RegistrationPage().enterCity(DataHelper.getJobPostingCity());
        new JobPostPage().enterSalaryMin(DataHelper.getJobPostingSalaryMin());
        new JobPostPage().enterSalaryMax(DataHelper.getJobPostingSalaryMax());
        new JobPostPage().enterDescription(DataHelper.getJobPostingDescription());
        new JobPostPage().clickOnPreviewButton();
        new JobTemplatePage().clickOnPreviewSubmitButton();
        new JobPostPage().clickOnPostJobSubmitButton();
        new LogoutPage().clickLogout();
        waitUntil(WebURLHelper.getHiringUrl());
    }

    @Then("I click on add screening questions btn")
    public void iClickOnAddScreeningQuestionsBtn() {
        waitFor(1);
        new JobPostPage().clickOnAddScreeningQuestionButton();
    }

    @And("I click on save screening questions btn one")
    public void iClickOnSaveScreeningQuestionsBtnOne() {
        new JobPostPage().clickOnSaveScreeningQuestionButton1();
    }

    @Then("I click on jobs action btn one")
    public void iClickOnJobsActionBtnOne() {
        new JobPostPage().clickOnJobsActionButton1();
    }

    @Then("I click on action edit btn")
    public void iClickOnActionEditBtn() {
        new JobPostPage().clickOnActionEditButton();
    }

    @And("I click on action matching btn")
    public void iClickOnActionMatchingBtn() {
        new JobPostPage().clickOnActionMatchingButton();
    }

    @And("I click on action deactivate btn")
    public void iClickOnActionDeactivateBtn() {
        new JobPostPage().clickOnActionDeactivateButton();
    }

    @And("I click on deactivate this job")
    public void iClickOnDeactivateThisJob() {
        new JobPostPage().clickOnDeactivateThisButton();
    }

    @Then("I click on next-btn")
    public void iClickOnNextBtn() {
        new JobPostPage().clickOnNextButton();
    }

    @When("I click on post job")
    public void iClickOnPostJob() {
        new JobPostPage().clickOnPostJobLink();
    }

    @And("I click on view job applications")
    public void iClickOnViewJobApplications() {
        new JobPostPage().clickOnViewApplicationLink();
    }

    @And("I click on inactive jobs")
    public void iClickOnInactiveJobs() {
        new JobPostPage().clickOnInactiveJobsLink();
    }

    @And("I should see text key feature {string}")
    public void iShouldSeeTextKeyFeature(String text) {
        Assert.assertEquals(new JobPostPage().getTextFromPostingTypeListTitleElement(), text);
    }

    @Then("I click on registration confirm button")
    public void iClickOnRegistrationConfirmButton() {
        //we don't need to do anything because previous step is already submitting the form
        new RegistrationPage().clickOnRegisterAndConfirmButton();
    }

    //Manage Job Template Begin
    @Then("I enter salary benefits details {string}")
    public void iEnterSalaryBenefitsDetails(String description) {
        new JobTemplatePage().enterSalaryDescription(description);
    }

    @And("I click on manage job template")
    public void iClickOnManageJobTemplate() {
        new JobPostPage().clickOnManageJobTemplateLink();
    }

    @And("I enter job template name {string}")
    public void iEnterTemplateName(String templateName) {
        new JobTemplatePage().enterTemplateName(templateName);
    }

    @And("I select the option {string} from Job template")
    public void iSelectTheOptionFromJobType(String template) {
        new JobTemplatePage().selectJobTemplate(template);
    }

    @When("I click on posted dates descending arrow")
    public void iClickOnPostedDatesDescendingArrow() {
        new JobPostPage().clickOnPostedDesc();
    }

    @Then("I should see posted dates in desc order")
    public void iShouldSeePostedDatesInDescOrder() {
        Assert.assertEquals(new JobPostPage().getListOfPostedDates(), new JobPostPage().descendingOrderOnPostedDates());
    }

    @When("I click on posted dates ascending arrow")
    public void iClickOnPostedDatesAscendingArrow() {
        new JobPostPage().clickOnPostedAsc();
    }

    @Then("I should see posted dates in asc order")
    public void iShouldSeePostedDatesInAscOrder() {
        Assert.assertEquals(new JobPostPage().getListOfPostedDates(), new JobPostPage().ascendingOrderOnPostedDates());
    }

    @When("I click on expires dates descending arrow")
    public void iClickOnExpiresDatesDescendingArrow() {
        new JobPostPage().clickOnExpiresDesc();
    }

    @Then("I should see expires dates in desc order")
    public void iShouldSeeExpiresDatesInDescOrder() {
        Assert.assertEquals(new JobPostPage().getListOfExpiresDates(), new JobPostPage().descendingOrderOnExpiresDates());
    }

    @When("I click on expires dates ascending arrow")
    public void iClickOnExpiresDatesAscendingArrow() {
        new JobPostPage().clickOnExpiresAsc();
    }

    @Then("I should see expires dates in asc order")
    public void iShouldSeeExpiresDatesInAscOrder() {
        Assert.assertEquals(new JobPostPage().getListOfExpiresDates(), new JobPostPage().ascendingOrderOnExpiresDates());
    }

    @Then("I click on update template btn")
    public void iClickOnUpdateTemplateBtn() {
        new JobTemplatePage().clickOnUpdateTemplateButton();
    }
}