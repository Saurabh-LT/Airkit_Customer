package com.resumelibrary.cucumber.stepdefinitions.web.candidate;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.candidate.CareerAdvicePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CareerAdvice extends Utility {

    @Then("I should not see the companies count is zero")
    public void iShouldNotSeeTheCompaniesCountIsZero() {
        Assert.assertTrue(new CareerAdvicePage().getTextFromSubHeaderCompaniesCount(),"[---> Companies count is zero <---]");
    }

    @Then("I should see resume Library header logo")
    public void iShouldSeeResumeLibraryHeaderLogo() {
        Assert.assertTrue(new CareerAdvicePage().isRLHeaderLogoDisplayed(),"[---> Resume Library header logo is not displayed <---]");
    }

    @When("I click on the logged in RL header logo")
    public void iClickOnTheLoggedInRLHeaderLogo() {
        new CareerAdvicePage().clickOnLoggedInRLHeaderLogo();
    }

    @When("I click on the logged out RL header logo")
    public void iClickOnTheLoggedOutRLHeaderLogo() {
        new CareerAdvicePage().clickOnLoggedOutRLHeaderLogo();
    }

    @Then("I should see Search Jobs link")
    public void iShouldSeeSearchJobsLink() {
        Assert.assertTrue(new CareerAdvicePage().getTextFromSiteStartsSearchCount(),"[---> Search Jobs link is not displayed <---]");
    }

    @When("I click on Search Jobs link")
    public void iClickOnSearchJobsLink() {
        new CareerAdvicePage().clickOnSearchJobsLink();
    }

    @When("I click on {string} career advice links")
    public void iClickOnCareerAdviceLinks(String links) {
        new CareerAdvicePage().clickOnCareerAdviceNavLinks(links);
    }

    @Then("I should see resume Library footer logo")
    public void iShouldSeeResumeLibraryFooterLogo() {
        Assert.assertTrue(new CareerAdvicePage().isRLFooterLogoDisplayed(),"[---> Resume Library footer logo is not displayed <---]");
    }

    @When("I click on resume Library footer logo")
    public void iClickOnResumeLibraryFooterLogo() {
        new CareerAdvicePage().clickOnRLFooterLogo();
    }

    @Then("I should see resume Library Employers header logo")
    public void iShouldSeeResumeLibraryEmployersHeaderLogo() {
        Assert.assertTrue(new CareerAdvicePage().isRLEmployersHeaderLogo(),"[---> Resume Library employers header logo is not displayed <---]");
    }

    @When("I click on the RL Employers header logo")
    public void iClickOnTheRLEmployersHeaderLogo() {
        new CareerAdvicePage().clickOnRLEmployersHeaderLogo();
    }

    @Then("I click on link {string} jobseeker tools menu")
    public void iClickOnLinkJobSeekerToolsMenu( String link) {
        new CareerAdvicePage().clickOnLinkJobSeekerToolsMenu(link);
    }

    @And("I click on link {string} account options menu")
    public void iClickOnLinkAccountOptionsMenu(String link) {
        new CareerAdvicePage().clickOnAccountOptionsLink(link);
    }

    @When("I click on link {string} about RL menu")
    public void iClickOnLinkAboutRLMenu(String link) {
        new CareerAdvicePage().clickOnLinkAboutRLMenu(link);
    }

    @Then("I should see RL Career Advice Dyn Banner")
    public void iShouldSeeRLCareerAdviceDynBanner() {
        Assert.assertTrue(new CareerAdvicePage().isRLCareerAdviceDynBannerDisplayed(),"[---> Resume Library Dyn banner is not displayed <---]");
    }

    @And("I should see RL Career Advice {int}x{int}")
    public void iShouldSeeRLCareerAdviceX(int arg0, int arg1) {
        Assert.assertTrue(new CareerAdvicePage().isRLCareerAdvice160x600Displayed(),"[---> Resume Library career advice logo is not displayed <---]");
    }

    @And("I should see blog-fb-banner")
    public void iShouldSeeBlogFbBanner() {
        Assert.assertTrue(new CareerAdvicePage().isBlogFBBannerDisplayed(),"[---> Blog FB banner is not displayed <---]");
    }

    @And("I click on resume upload btn")
    public void iClickOnResumeUploadBtn() {
        new CareerAdvicePage().clickOnResumeUploadBtn();
    }

    @Then("I click on {string} in footer menu job seekers and verify url {string}")
    public void iClickOnInFooterMenuJobSeekersAndVerifyUrl(String text, String url) {
        new CareerAdvicePage().clickOnAndVeryUrlForJobseekersFooter(text,url);
    }

    @And("I click on {string} in footer menu hiring and verify url {string}")
    public void iClickOnInFooterMenuHiringAndVerifyUrl(String text, String url) {
        new CareerAdvicePage().clickOnAndVerifyUrlForHiringFooter(text,url);
    }

    @And("I click on {string} in footer menu Resume-Library and verify url {string}")
    public void iClickOnInFooterMenuResumeLibraryAndVerifyUrl(String text, String url) {
        new CareerAdvicePage().clickOnInFooterMenuResumeLibraryAndVerifyUrl(text,url);
    }

    @When("I click on Companies link")
    public void iClickOnCompaniesLink() {
        new CareerAdvicePage().clickOnCompaniesLink();
    }

    @When("I click on back to top button")
    public void iClickOnBackToTopButton() {
        new CareerAdvicePage().clickOnBackToTopButton();
    }
}