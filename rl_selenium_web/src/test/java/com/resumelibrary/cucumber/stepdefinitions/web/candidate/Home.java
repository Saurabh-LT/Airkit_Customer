package com.resumelibrary.cucumber.stepdefinitions.web.candidate;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.candidate.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Home extends Utility {

    @When("I click on more search options link")
    public void iClickOnMoreSearchOptionsLink() {
        new HomePage().clickOnMoreSearchOptionLink();
    }

    @And("I select the option {string} from salary min dropdown")
    public void iSelectTheOptionFromSalaryMinDropdown(String salMin) {
        new HomePage().selectSalaryMinFromDropdown(salMin);
    }

    @And("I select the option {string} from salary max dropdown")
    public void iSelectTheOptionFromSalaryMaxDropdown(String salMax) {
        new HomePage().selectSalaryMaxFromDropdown(salMax);
    }

    @And("I select the option {string} from job type dropdown")
    public void iSelectTheOptionFromJobTypeDropdown(String jobType) {
        new HomePage().selectJobTypeFromDropdown(jobType);
    }

    @And("I select the option {string} from posted since dropdown")
    public void iSelectTheOptionFromPostedSinceDropdown(String postedSince) {
        new HomePage().selectPostedSinceFromDropdown(postedSince);
    }

    @And("I click on find jobs button")
    public void iClickOnFindJobsButton() {
        new HomePage().clickOnFindJobsButton();
    }

    @Then("I should see resume library logo")
    public void iShouldSeeResumeLibraryLogo() {
        Assert.assertTrue(new HomePage().homePageLogoIsVisible(), "[---> Home page logo is not visible <---]");
    }

    @And("I click on recent searches link")
    public void iClickOnRecentSearchesLink() {
        new HomePage().clickOnRecentSearchesLink();
    }

    @And("I click on clear recent searches link")
    public void iClickOnClearRecentSearchesLink() {
        new HomePage().clickOnClearRecentSearchesLink();
    }

    @And("I click on app store icon link")
    public void iClickOnAppStoreIconLink() {
        new HomePage().clickOnAppStoreIconLink();
    }

    @And("I click on play store icon link")
    public void iClickOnPlayStoreIconLink() {
        new HomePage().clickOnPlayStoreIconLink();
    }

    @Then("I should see linkText {string} under Jobs by Industry tab")
    public void iShouldSeeLinkTextUnderJobsByIndustryTab(String jobsByIndustry) {
        Assert.assertTrue(new HomePage().verifyTheLinkTextUnderJobsByIndustryTab(jobsByIndustry), "[---> " + jobsByIndustry + " is not visible <---]");
    }
    @Then("I should see linkText {string} under Jobs by State tab")
    public void iShouldSeeLinkTextUnderJobsByStateTab(String jobsByState) {
        Assert.assertTrue(new HomePage().verifyTheLinkTextUnderJobsByStateTab(jobsByState), "[---> " + jobsByState + " is not visible <---]");
    }
    @Then("I should see linkText {string} under Jobs by City tab")
    public void iShouldSeeLinkTextUnderJobsByCityTab(String jobsByCity) {
        Assert.assertTrue(new HomePage().verifyTheLinkTextUnderJobsByCityTab(jobsByCity), "[---> " + jobsByCity + " is not visible <---]");
    }
    @Then("I should see linkText {string} under Popular Jobs tab")
    public void iShouldSeeLinkTextUnderPopularJobsTab(String popularJobs) {
        Assert.assertTrue(new HomePage().verifyTheLinkTextUnderPopularJobsTab(popularJobs), "[---> " + popularJobs + " is not visible <---]");
    }

    @When("I click on {string} Header Link")
    public void iClickOnHeaderLink(String headerLink) {
        new HomePage().ClickOnHeaderLink(headerLink);
    }
}