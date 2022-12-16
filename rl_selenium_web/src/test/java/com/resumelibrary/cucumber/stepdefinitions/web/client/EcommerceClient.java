package com.resumelibrary.cucumber.stepdefinitions.web.client;

import com.resumelibrary.utilities.Utility;
import com.resumelibrary.webtest.client.EcommerceClientPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class EcommerceClient extends Utility {

    @When("I click on Feature Job Posting Buy Online Now")
    public void iClickOnFeatureJobPostingBuyOnlineNow() {
        new EcommerceClientPage().clickOnFeatureJobPostingBuyOnlineNow();
    }

    @When("I close account authentication required popup")
    public void iCloseAccountAuthenticationRequiredPopup() {
        new EcommerceClientPage().closeAccountAuthenticationRequiredPopup();
    }

    @When("I click on three months Resume Search Buy Online Now")
    public void iClickOnMONTHSResumeSearchBuyOnlineNow() {
        new EcommerceClientPage().clickOnMONTHSResumeSearchBuyOnlineNow();
    }

    @When("I close account authentication for unlock resume")
    public void iCloseAccountAuthenticationForUnlockResume() {
        new EcommerceClientPage().closeAccountAuthenticationForUnlockResume();
    }

    @When("I click on main number view contact details")
    public void iClickOnMainNumberViewContactDetails() {
        new EcommerceClientPage().clickOnMainNumberViewContactDetails();
    }

    @When("I click on main email address view contact details")
    public void iClickOnMainEmailAddressViewContactDetails() {
        new EcommerceClientPage().clickOnMainEmailAddressViewContactDetails();
    }

    @Then("I close purchase product popup for unlock resume")
    public void iClosePurchaseProductPopupForUnlockResume() {
        new EcommerceClientPage().closePurchaseProductPopupForUnlockResume();
    }

    @Then("I close account authentication for job dashboard")
    public void iCloseAccountAuthenticationForJobDashboard() {
        new EcommerceClientPage().closeAccountAuthenticationForJobDashboard();
    }

    @Then("I close account authentication for client products")
    public void iCloseAccountAuthenticationForClientProducts() {
        new EcommerceClientPage().closeAccountAuthenticationForClientProducts();
    }

    @When("I click 30-day Resume Search Buy Online")
    public void iClick30DayResumeSearchBuyOnline() {
        new EcommerceClientPage().click30DayResumeSearchBuyOnline();
    }

    @When("I click starter package Buy Online")
    public void iClickStarterPackageBuyOnline() {
        new EcommerceClientPage().clickButtonStarterPackageBuyOnline();
    }

    @Then("I close post a job popup")
    public void iClosePostAJobPopup() {
        new EcommerceClientPage().closePostAJobPopup();
    }

    @When("I click on learn more for search resumes")
    public void iClickOnLearnMoreForSearchResumes() {
        new EcommerceClientPage().clickOnLearnMoreForSearchResumes();
    }

    @When("I click on learn more for post jobs")
    public void iClickOnLearnMoreForPostJobs() {
        new EcommerceClientPage().clickOnLearnMoreForPostJobs();
    }

    @Then("I close account authentication for recruiters")
    public void iCloseAccountAuthenticationForRecruiters() {
        new EcommerceClientPage().clickOnAccountAuthenticationForRecruiters();
    }

    @Then("I tick Select all checkbox")
    public void iTickSelectAllCheckboxForInviteToApply() {
        new EcommerceClientPage().tickSelectAllCheckboxForInviteToApply();
    }

    @Then("I should see all Resume\\(s) selected")
    public void iSeeAllTheCheckBoxesToBeTicked() {
        new EcommerceClientPage().verifyAllCheckBoxesTicked();
    }

    @And("I select option {string} from resumes selected")
    public void iSelectOptionFromResumesSelected(String optionText) {
        new EcommerceClientPage().selectOption(optionText);
    }

    @Then("I close email verification required popup")
    public void iCloseEmailVerificationRequiredPopup() {
        new EcommerceClientPage().closeEmailVerificationRequiredPopup();
    }
    @Then("I close email verification required popup for resume search")
    public void iCloseEmailVerificationRequiredPopupForResumeSearch() {
        new EcommerceClientPage().closeEmailVerificationRequiredPopupForResumeSearch();
    }

    @Then("I close email verification required unlock popup")
    public void iCloseEmailVerificationRequiredUnlockPopup() {
        new EcommerceClientPage().closeEmailVerificationRequiredUnlockPopup();
    }

    @Then("I close email verification required popup for inviteToApply")
    public void closeEmailVerificationRequiredPopupForInviteToApply() {
        new EcommerceClientPage().closeEmailVerificationRequiredPopupForInviteToApply();
    }

    @Then("I click on {string} button to activate user in admin page")
    public void iClickOnButtonToActivateUserInAdminPage(String text) {
        new EcommerceClientPage().clickOnEditButton();
    }

    @And("I should see logo empty cart image")
    public void iShouldSeeLogoEmptyCartImage() {
        Assert.assertTrue("[---> Empty cart logo is not displayed <---]", new EcommerceClientPage().verifyLogoEmptyShoppingCart());
    }

    @Then("I click on button {string} in admin page")
    public void iClickOnButtonInAdminPage(String text) {
        new EcommerceClientPage().clickOnButton(text);
    }

    @And("I should see text total {string}")
    public void iShouldSeeTextTotal(String text) {
        new EcommerceClientPage().iShouldSeeTextTotal(text);

    }

    @And("I enter new balance {string} for contact credits")
    public void iEnterNewBalanceForContactCredits(String text) {
        new EcommerceClientPage().enterContactCredits(text);
    }

    @When("I click on Buy Now 3 Month Access package")
    public void iClickOnMonthAccessPackage() {
        new EcommerceClientPage().clickOnMonthAccessPackage();
    }

    @Then("I should see price {string} for class {string}")
    public void iShouldSeePriceForClass(String price, String clazz) {
        Assert.assertEquals(price, new EcommerceClientPage().verifyPriceForClass(price,clazz));
    }

    @And("I should see option {string} selected for product quantity")
    public void iShouldSeeOptionSelectedForProductQuantity(String option) {
        Assert.assertEquals(option, new EcommerceClientPage().verifyOptionSelected(option));
    }

    @And("I should see text {string} in Order Summary table")
    public void iShouldSeeTextInATable(String text) {
        Assert.assertEquals(text, new EcommerceClientPage().verifyTextInOrderSummaryTable(text));
    }

    @And("I should see resources-3-month-banner {string}")
    public void iShouldSeeResourcesMonthBanner(String text) {
        Assert.assertTrue("[---> Resources 3-month banner is not displayed <---]", new EcommerceClientPage().verifyImage(text));
    }

    @Then("I click on resources-3-month-banner {string}")
    public void iClickOnResourcesMonthBanner(String text) {
        new EcommerceClientPage().clickOnElement(text);
    }

    @And("I should not see resources-3-month-banner {string}")
    public void iShouldNotSeeResourcesMonthBanner(String text) {
        Assert.assertFalse("[---> Resources 3-month banner is displayed <---]", new EcommerceClientPage().verifyImageIsDisplayed(text));
    }

    @And("I should not see resources-switch-banner {string}")
    public void iShouldNotSeeResourcesSwitchBanner(String text) {
        Assert.assertFalse("[---> Resources switch-banner is displayed <---]", new EcommerceClientPage().verifyImageIsDisplayed(text));
    }

    @And("I close popup introducing our new resume search builder")
    public void iClosePopupIntroducingOurNewResumeSearchBuilder() {
        new EcommerceClientPage().closePopupIntroducingOurNewResumeSearchBuilder();
    }

    @Then("I click on preview resume {string}")
    public void iClickOnPreviewResume(String number) {
        new EcommerceClientPage().clickOnPreviewResume(number);
    }

    @When("I click on Request pricing")
    public void iClickOnRequestPricing() {
        new EcommerceClientPage().clickOnRequestPricingBtn();
    }

    @And("I wait for account authentication popup")
    public void iWaitForAccountAuthenticationPopup() {
        new EcommerceClientPage().waitForAccountAuthenticationPopup();
    }
}