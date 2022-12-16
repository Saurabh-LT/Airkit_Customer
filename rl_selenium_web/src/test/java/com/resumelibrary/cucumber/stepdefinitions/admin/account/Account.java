package com.resumelibrary.cucumber.stepdefinitions.admin.account;

import com.resumelibrary.admintest.account.AccountPage;
import com.resumelibrary.admintest.misc.MiscPage;
import com.resumelibrary.utilities.Utility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Account extends Utility {
    public String newAccountName;

    @When("I click Create Account button")
    public void iClickCreateAccountButton() {
        new AccountPage().clickCreateAccountButton();
    }

    @Then("I should be on Account View page")
    public void iShouldBeOnAccountViewPage() {
        new AccountPage().shouldBeOnAccountViewPage();
    }

    @Then("I fill in the field {string}")
    public void iFillInTheField(String field) {
        new AccountPage().fillInTheField(field);
    }

    @Then("I confirm Yes")
    public void iConfirmYes() {
    }

    @When("I search for {string} in the navigation bar")
    public void iSearchForInTheNavigationBar(String value) {
        new AccountPage().searchForInTheNavigationBar(value);
    }

    @Then("I should be on account search results page")
    public void iShouldBeOnAccountSearchResultsPage() {
        new AccountPage().ShouldBeOnAccountSearchResultsPage();
    }

    @When("I click View account details from the first results")
    public void iClickViewAccountDetailsFromTheFirstResults() {
        new AccountPage().clickViewAccountDetails();
    }

    @Then("I click on modify account btn one")
    public void iClickOnModifyAccountBtnOne() {
        new AccountPage().clickOnModifyAccountBtn1();
    }

    @And("I select {string} from acc property[]")
    public void iSelectFromAccProperty(String value) {
        new AccountPage().selectFromAccountProperty(value);
    }

    @And("I click on update account")
    public void iClickOnUpdateAccount() {
        new AccountPage().clickOnUpdateAccount();
    }

    @Then("I click on validate account btn one")
    public void iClickOnValidateAccountBtnOne() {
        new AccountPage().clickOnValidateAccountButton1();
    }

    @Then("I click on reject account btn one")
    public void iClickOnRejectAccountBtnOne() {
        new AccountPage().clickOnRejectAccountBtn1();
    }

    @And("I select deactivate reason from dropdown {string}")
    public void iSelectDeactivateReasonFromDropdown(String reason) {
        new AccountPage().selectDeactivateReasonFromDropdown(reason);
    }

    @And("I click on deactivate client")
    public void iClickOnDeactivateClient() {
        new AccountPage().clickOnDeactivateClient();
    }

    @And("I select Disable Ecomm {string}")
    public void iSelectDisableEcomm(String reason) {
        new AccountPage().selectDisableEcommerceFromDropdown(reason);
    }

    @And("I click on product details Edit button")
    public void iClickOnProductDetailsEditButton() {
        new AccountPage().clickOnEditProductDetails();
    }

    @Then("I enter {string} to ATS field")
    public void iEnterToField(String text) {
        new AccountPage().enterAtsFromList(text);
    }

    @And("I Select Account Type Radio button as {string}")
    public void iSelectAccountTypeRadioButtonAs(String radioButtonValue) {
        new AccountPage().selectAccountTypeRadioButtonAs(radioButtonValue);
    }

    @When("I click Save Changes button")
    public void iClickSaveChangesButton() {
        new AccountPage().clickSaveChangesButton();
    }

    @Then("I click Edit button")
    public void iClickEditButton() {
        new AccountPage().clickEditButton();
    }

    @When("I click View more button")
    public void iClickViewMoreButton() {
        new AccountPage().clickViewMoreButton();
    }

    @And("the ATS Apply field should contain {string}")
    public void theAtsApplyFieldShouldContain(String text) {
        Assert.assertEquals(new AccountPage().getAtsApplyFieldValue(), text);
    }

    @And("I click Account Users")
    public void iClickAccountUsers() {
        new AccountPage().clickAccountUsers();
    }

    @And("I select {string} job posting spend type")
    public void iSelectJobPostingSpendType(String type) {
        new AccountPage().selectJobPostingSpendType(type);
    }

    @And("I click on add jobs link")
    public void iClickOnAddJobsLink() {
        new AccountPage().clickOnAddJobs();
    }

    @And("I select {string} users from list")
    public void iSelectUsersFromList(String list) {
        new AccountPage().selectUsersFromDropdown(list);
    }

    @Then("I should see job credits deducted to {string}")
    public void iShouldSeeJobCreditsDeductedTo(String credit) {
        Assert.assertEquals(new AccountPage().getTextFromJobCredit(), credit);
    }

    @When("I enters job credit {string}")
    public void iEntersJobCredit(String credit) {
        new AccountPage().enterJobCredits(credit);
    }

    @And("I get account name and number")
    public void iGetAccountNameAndNumber() {
        newAccountName = new AccountPage().getTextFromAccountHeaderTitle();
        newAccountName = newAccountName.substring(newAccountName.indexOf("(") + 1);
        newAccountName = newAccountName.substring(0, newAccountName.indexOf(")")).trim();
    }

    @When("I enter account number {string}")
    public void iEnterAccountNumber(String accountNum) {
        new MiscPage().enterAccountNumber(accountNum + newAccountName);
        new MiscPage().setAccountIdToHiddenField(newAccountName);
    }

    @And("I click on actions btn")
    public void iClickOnActionsBtn() {
        new AccountPage().clickOnActionButton();
    }

    @Then("the job posting spend type is {string} not {string}")
    public void theJobPostingSpendTypeIsNot(String account, String client) {
        new AccountPage().jobPostingSpendType(account, client);
    }
}